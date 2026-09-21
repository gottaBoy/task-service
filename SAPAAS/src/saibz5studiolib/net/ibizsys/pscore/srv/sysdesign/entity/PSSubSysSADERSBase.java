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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADERSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSADERSBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CHILDFILTER = "CHILDFILTER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CPSSUBSYSSADEID = "CPSSUBSYSSADEID";
    public static final String FIELD_CPSSUBSYSSADENAME = "CPSSUBSYSSADENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSUBSYSSADEID = "PPSSUBSYSSADEID";
    public static final String FIELD_PPSSUBSYSSADENAME = "PPSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSADERSID = "PSSUBSYSSADERSID";
    public static final String FIELD_PSSUBSYSSADERSNAME = "PSSUBSYSSADERSNAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_RSTAG = "RSTAG";
    public static final String FIELD_RSTAG2 = "RSTAG2";
    public static final String FIELD_TYPEFILTER = "TYPEFILTER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARRAYFLAG = 0;
    private static final int INDEX_CHILDFILTER = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CODENAME2 = 3;
    private static final int INDEX_CPSSUBSYSSADEID = 4;
    private static final int INDEX_CPSSUBSYSSADENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PPSSUBSYSSADEID = 10;
    private static final int INDEX_PPSSUBSYSSADENAME = 11;
    private static final int INDEX_PSSUBSYSSADERSID = 12;
    private static final int INDEX_PSSUBSYSSADERSNAME = 13;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 14;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 15;
    private static final int INDEX_RSTAG = 16;
    private static final int INDEX_RSTAG2 = 17;
    private static final int INDEX_TYPEFILTER = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSADERSBase proxyPSSubSysSADERSBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean childfilterDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean cpssubsyssadeidDirtyFlag = false;
    private boolean cpssubsyssadenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssubsyssadeidDirtyFlag = false;
    private boolean ppssubsyssadenameDirtyFlag = false;
    private boolean pssubsyssadersidDirtyFlag = false;
    private boolean pssubsyssadersnameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean rstagDirtyFlag = false;
    private boolean rstag2DirtyFlag = false;
    private boolean typefilterDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="childfilter")
    private String childfilter;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="cpssubsyssadeid")
    private String cpssubsyssadeid;
    @Column(name="cpssubsyssadename")
    private String cpssubsyssadename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssubsyssadeid")
    private String ppssubsyssadeid;
    @Column(name="ppssubsyssadename")
    private String ppssubsyssadename;
    @Column(name="pssubsyssadersid")
    private String pssubsyssadersid;
    @Column(name="pssubsyssadersname")
    private String pssubsyssadersname;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="rstag")
    private String rstag;
    @Column(name="rstag2")
    private String rstag2;
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
    private Integer objCPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE cpssubsyssade = null;
    private Integer objPPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE ppssubsyssade = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;

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

    public void setCPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpssubsyssadeid = string;
        this.cpssubsyssadeidDirtyFlag = true;
    }

    public String getCPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSubSysSADEId();
        }
        return this.cpssubsyssadeid;
    }

    public boolean isCPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSSubSysSADEIdDirty();
        }
        return this.cpssubsyssadeidDirtyFlag;
    }

    public void resetCPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSSubSysSADEId();
            return;
        }
        this.cpssubsyssadeidDirtyFlag = false;
        this.cpssubsyssadeid = null;
    }

    public void setCPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpssubsyssadename = string;
        this.cpssubsyssadenameDirtyFlag = true;
    }

    public String getCPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSubSysSADEName();
        }
        return this.cpssubsyssadename;
    }

    public boolean isCPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSSubSysSADENameDirty();
        }
        return this.cpssubsyssadenameDirtyFlag;
    }

    public void resetCPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSSubSysSADEName();
            return;
        }
        this.cpssubsyssadenameDirtyFlag = false;
        this.cpssubsyssadename = null;
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

    public void setPPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssubsyssadeid = string;
        this.ppssubsyssadeidDirtyFlag = true;
    }

    public String getPPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSubSysSADEId();
        }
        return this.ppssubsyssadeid;
    }

    public boolean isPPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSubSysSADEIdDirty();
        }
        return this.ppssubsyssadeidDirtyFlag;
    }

    public void resetPPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSubSysSADEId();
            return;
        }
        this.ppssubsyssadeidDirtyFlag = false;
        this.ppssubsyssadeid = null;
    }

    public void setPPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssubsyssadename = string;
        this.ppssubsyssadenameDirtyFlag = true;
    }

    public String getPPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSubSysSADEName();
        }
        return this.ppssubsyssadename;
    }

    public boolean isPPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSubSysSADENameDirty();
        }
        return this.ppssubsyssadenameDirtyFlag;
    }

    public void resetPPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSubSysSADEName();
            return;
        }
        this.ppssubsyssadenameDirtyFlag = false;
        this.ppssubsyssadename = null;
    }

    public void setPSSubSysSADERSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADERSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadersid = string;
        this.pssubsyssadersidDirtyFlag = true;
    }

    public String getPSSubSysSADERSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADERSId();
        }
        return this.pssubsyssadersid;
    }

    public boolean isPSSubSysSADERSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADERSIdDirty();
        }
        return this.pssubsyssadersidDirtyFlag;
    }

    public void resetPSSubSysSADERSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADERSId();
            return;
        }
        this.pssubsyssadersidDirtyFlag = false;
        this.pssubsyssadersid = null;
    }

    public void setPSSubSysSADERSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADERSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadersname = string;
        this.pssubsyssadersnameDirtyFlag = true;
    }

    public String getPSSubSysSADERSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADERSName();
        }
        return this.pssubsyssadersname;
    }

    public boolean isPSSubSysSADERSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADERSNameDirty();
        }
        return this.pssubsyssadersnameDirtyFlag;
    }

    public void resetPSSubSysSADERSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADERSName();
            return;
        }
        this.pssubsyssadersnameDirtyFlag = false;
        this.pssubsyssadersname = null;
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

    public void setRSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag = string;
        this.rstagDirtyFlag = true;
    }

    public String getRSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag();
        }
        return this.rstag;
    }

    public boolean isRSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTagDirty();
        }
        return this.rstagDirtyFlag;
    }

    public void resetRSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag();
            return;
        }
        this.rstagDirtyFlag = false;
        this.rstag = null;
    }

    public void setRSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag2 = string;
        this.rstag2DirtyFlag = true;
    }

    public String getRSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag2();
        }
        return this.rstag2;
    }

    public boolean isRSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag2Dirty();
        }
        return this.rstag2DirtyFlag;
    }

    public void resetRSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag2();
            return;
        }
        this.rstag2DirtyFlag = false;
        this.rstag2 = null;
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
        PSSubSysSADERSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSADERSBase pSSubSysSADERSBase) {
        pSSubSysSADERSBase.resetArrayFlag();
        pSSubSysSADERSBase.resetChildFilter();
        pSSubSysSADERSBase.resetCodeName();
        pSSubSysSADERSBase.resetCodeName2();
        pSSubSysSADERSBase.resetCPSSubSysSADEId();
        pSSubSysSADERSBase.resetCPSSubSysSADEName();
        pSSubSysSADERSBase.resetCreateDate();
        pSSubSysSADERSBase.resetCreateMan();
        pSSubSysSADERSBase.resetMemo();
        pSSubSysSADERSBase.resetOrderValue();
        pSSubSysSADERSBase.resetPPSSubSysSADEId();
        pSSubSysSADERSBase.resetPPSSubSysSADEName();
        pSSubSysSADERSBase.resetPSSubSysSADERSId();
        pSSubSysSADERSBase.resetPSSubSysSADERSName();
        pSSubSysSADERSBase.resetPSSubSysServiceAPIId();
        pSSubSysSADERSBase.resetPSSubSysServiceAPIName();
        pSSubSysSADERSBase.resetRSTag();
        pSSubSysSADERSBase.resetRSTag2();
        pSSubSysSADERSBase.resetTypeFilter();
        pSSubSysSADERSBase.resetUpdateDate();
        pSSubSysSADERSBase.resetUpdateMan();
        pSSubSysSADERSBase.resetUserCat();
        pSSubSysSADERSBase.resetUserTag();
        pSSubSysSADERSBase.resetUserTag2();
        pSSubSysSADERSBase.resetUserTag3();
        pSSubSysSADERSBase.resetUserTag4();
        pSSubSysSADERSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isCPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_CPSSUBSYSSADEID, this.getCPSSubSysSADEId());
        }
        if (!bl || this.isCPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_CPSSUBSYSSADENAME, this.getCPSSubSysSADEName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PPSSUBSYSSADEID, this.getPPSSubSysSADEId());
        }
        if (!bl || this.isPPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_PPSSUBSYSSADENAME, this.getPPSSubSysSADEName());
        }
        if (!bl || this.isPSSubSysSADERSIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADERSID, this.getPSSubSysSADERSId());
        }
        if (!bl || this.isPSSubSysSADERSNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADERSNAME, this.getPSSubSysSADERSName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isRSTagDirty()) {
            hashMap.put(FIELD_RSTAG, this.getRSTag());
        }
        if (!bl || this.isRSTag2Dirty()) {
            hashMap.put(FIELD_RSTAG2, this.getRSTag2());
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
        return PSSubSysSADERSBase.get(this, n);
    }

    private static Object get(PSSubSysSADERSBase pSSubSysSADERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADERSBase.getArrayFlag();
            }
            case 1: {
                return pSSubSysSADERSBase.getChildFilter();
            }
            case 2: {
                return pSSubSysSADERSBase.getCodeName();
            }
            case 3: {
                return pSSubSysSADERSBase.getCodeName2();
            }
            case 4: {
                return pSSubSysSADERSBase.getCPSSubSysSADEId();
            }
            case 5: {
                return pSSubSysSADERSBase.getCPSSubSysSADEName();
            }
            case 6: {
                return pSSubSysSADERSBase.getCreateDate();
            }
            case 7: {
                return pSSubSysSADERSBase.getCreateMan();
            }
            case 8: {
                return pSSubSysSADERSBase.getMemo();
            }
            case 9: {
                return pSSubSysSADERSBase.getOrderValue();
            }
            case 10: {
                return pSSubSysSADERSBase.getPPSSubSysSADEId();
            }
            case 11: {
                return pSSubSysSADERSBase.getPPSSubSysSADEName();
            }
            case 12: {
                return pSSubSysSADERSBase.getPSSubSysSADERSId();
            }
            case 13: {
                return pSSubSysSADERSBase.getPSSubSysSADERSName();
            }
            case 14: {
                return pSSubSysSADERSBase.getPSSubSysServiceAPIId();
            }
            case 15: {
                return pSSubSysSADERSBase.getPSSubSysServiceAPIName();
            }
            case 16: {
                return pSSubSysSADERSBase.getRSTag();
            }
            case 17: {
                return pSSubSysSADERSBase.getRSTag2();
            }
            case 18: {
                return pSSubSysSADERSBase.getTypeFilter();
            }
            case 19: {
                return pSSubSysSADERSBase.getUpdateDate();
            }
            case 20: {
                return pSSubSysSADERSBase.getUpdateMan();
            }
            case 21: {
                return pSSubSysSADERSBase.getUserCat();
            }
            case 22: {
                return pSSubSysSADERSBase.getUserTag();
            }
            case 23: {
                return pSSubSysSADERSBase.getUserTag2();
            }
            case 24: {
                return pSSubSysSADERSBase.getUserTag3();
            }
            case 25: {
                return pSSubSysSADERSBase.getUserTag4();
            }
            case 26: {
                return pSSubSysSADERSBase.getValidFlag();
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
        PSSubSysSADERSBase.set(this, n, object);
    }

    private static void set(PSSubSysSADERSBase pSSubSysSADERSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADERSBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSADERSBase.setChildFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSADERSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSADERSBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSADERSBase.setCPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSADERSBase.setCPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSADERSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSADERSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSADERSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSADERSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSADERSBase.setPPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSADERSBase.setPPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSADERSBase.setPSSubSysSADERSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSADERSBase.setPSSubSysSADERSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSADERSBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSADERSBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSADERSBase.setRSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysSADERSBase.setRSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysSADERSBase.setTypeFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysSADERSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSubSysSADERSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSubSysSADERSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSubSysSADERSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSubSysSADERSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSubSysSADERSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubSysSADERSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSubSysSADERSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysSADERSBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSADERSBase pSSubSysSADERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADERSBase.getArrayFlag() == null;
            }
            case 1: {
                return pSSubSysSADERSBase.getChildFilter() == null;
            }
            case 2: {
                return pSSubSysSADERSBase.getCodeName() == null;
            }
            case 3: {
                return pSSubSysSADERSBase.getCodeName2() == null;
            }
            case 4: {
                return pSSubSysSADERSBase.getCPSSubSysSADEId() == null;
            }
            case 5: {
                return pSSubSysSADERSBase.getCPSSubSysSADEName() == null;
            }
            case 6: {
                return pSSubSysSADERSBase.getCreateDate() == null;
            }
            case 7: {
                return pSSubSysSADERSBase.getCreateMan() == null;
            }
            case 8: {
                return pSSubSysSADERSBase.getMemo() == null;
            }
            case 9: {
                return pSSubSysSADERSBase.getOrderValue() == null;
            }
            case 10: {
                return pSSubSysSADERSBase.getPPSSubSysSADEId() == null;
            }
            case 11: {
                return pSSubSysSADERSBase.getPPSSubSysSADEName() == null;
            }
            case 12: {
                return pSSubSysSADERSBase.getPSSubSysSADERSId() == null;
            }
            case 13: {
                return pSSubSysSADERSBase.getPSSubSysSADERSName() == null;
            }
            case 14: {
                return pSSubSysSADERSBase.getPSSubSysServiceAPIId() == null;
            }
            case 15: {
                return pSSubSysSADERSBase.getPSSubSysServiceAPIName() == null;
            }
            case 16: {
                return pSSubSysSADERSBase.getRSTag() == null;
            }
            case 17: {
                return pSSubSysSADERSBase.getRSTag2() == null;
            }
            case 18: {
                return pSSubSysSADERSBase.getTypeFilter() == null;
            }
            case 19: {
                return pSSubSysSADERSBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSubSysSADERSBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSubSysSADERSBase.getUserCat() == null;
            }
            case 22: {
                return pSSubSysSADERSBase.getUserTag() == null;
            }
            case 23: {
                return pSSubSysSADERSBase.getUserTag2() == null;
            }
            case 24: {
                return pSSubSysSADERSBase.getUserTag3() == null;
            }
            case 25: {
                return pSSubSysSADERSBase.getUserTag4() == null;
            }
            case 26: {
                return pSSubSysSADERSBase.getValidFlag() == null;
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
        return PSSubSysSADERSBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSADERSBase pSSubSysSADERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADERSBase.isArrayFlagDirty();
            }
            case 1: {
                return pSSubSysSADERSBase.isChildFilterDirty();
            }
            case 2: {
                return pSSubSysSADERSBase.isCodeNameDirty();
            }
            case 3: {
                return pSSubSysSADERSBase.isCodeName2Dirty();
            }
            case 4: {
                return pSSubSysSADERSBase.isCPSSubSysSADEIdDirty();
            }
            case 5: {
                return pSSubSysSADERSBase.isCPSSubSysSADENameDirty();
            }
            case 6: {
                return pSSubSysSADERSBase.isCreateDateDirty();
            }
            case 7: {
                return pSSubSysSADERSBase.isCreateManDirty();
            }
            case 8: {
                return pSSubSysSADERSBase.isMemoDirty();
            }
            case 9: {
                return pSSubSysSADERSBase.isOrderValueDirty();
            }
            case 10: {
                return pSSubSysSADERSBase.isPPSSubSysSADEIdDirty();
            }
            case 11: {
                return pSSubSysSADERSBase.isPPSSubSysSADENameDirty();
            }
            case 12: {
                return pSSubSysSADERSBase.isPSSubSysSADERSIdDirty();
            }
            case 13: {
                return pSSubSysSADERSBase.isPSSubSysSADERSNameDirty();
            }
            case 14: {
                return pSSubSysSADERSBase.isPSSubSysServiceAPIIdDirty();
            }
            case 15: {
                return pSSubSysSADERSBase.isPSSubSysServiceAPINameDirty();
            }
            case 16: {
                return pSSubSysSADERSBase.isRSTagDirty();
            }
            case 17: {
                return pSSubSysSADERSBase.isRSTag2Dirty();
            }
            case 18: {
                return pSSubSysSADERSBase.isTypeFilterDirty();
            }
            case 19: {
                return pSSubSysSADERSBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSubSysSADERSBase.isUpdateManDirty();
            }
            case 21: {
                return pSSubSysSADERSBase.isUserCatDirty();
            }
            case 22: {
                return pSSubSysSADERSBase.isUserTagDirty();
            }
            case 23: {
                return pSSubSysSADERSBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSubSysSADERSBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSubSysSADERSBase.isUserTag4Dirty();
            }
            case 26: {
                return pSSubSysSADERSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSADERSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSADERSBase pSSubSysSADERSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSADERSBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getChildFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childfilter", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getChildFilter()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpssubsyssadeid", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpssubsyssadename", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssubsyssadeid", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssubsyssadename", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysSADERSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadersid", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPSSubSysSADERSId()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysSADERSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadersname", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPSSubSysSADERSName()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getRSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getRSTag()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getRSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag2", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getRSTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getTypeFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefilter", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getTypeFilter()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubSysSADERSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysSADERSBase.getJSONValue((Object)pSSubSysSADERSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSADERSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSADERSBase pSSubSysSADERSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSADERSBase.getArrayFlag() != null) {
            object = pSSubSysSADERSBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADERSBase.getChildFilter() != null) {
            object = pSSubSysSADERSBase.getChildFilter();
            xmlNode.setAttribute(FIELD_CHILDFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getCodeName() != null) {
            object = pSSubSysSADERSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getCodeName2() != null) {
            object = pSSubSysSADERSBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getCPSSubSysSADEId() != null) {
            object = pSSubSysSADERSBase.getCPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_CPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getCPSSubSysSADEName() != null) {
            object = pSSubSysSADERSBase.getCPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_CPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getCreateDate() != null) {
            object = pSSubSysSADERSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADERSBase.getCreateMan() != null) {
            object = pSSubSysSADERSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getMemo() != null) {
            object = pSSubSysSADERSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getOrderValue() != null) {
            object = pSSubSysSADERSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADERSBase.getPPSSubSysSADEId() != null) {
            object = pSSubSysSADERSBase.getPPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getPPSSubSysSADEName() != null) {
            object = pSSubSysSADERSBase.getPPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysSADERSId() != null) {
            object = pSSubSysSADERSBase.getPSSubSysSADERSId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADERSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysSADERSName() != null) {
            object = pSSubSysSADERSBase.getPSSubSysSADERSName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIId() != null) {
            object = pSSubSysSADERSBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIName() != null) {
            object = pSSubSysSADERSBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getRSTag() != null) {
            object = pSSubSysSADERSBase.getRSTag();
            xmlNode.setAttribute(FIELD_RSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getRSTag2() != null) {
            object = pSSubSysSADERSBase.getRSTag2();
            xmlNode.setAttribute(FIELD_RSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getTypeFilter() != null) {
            object = pSSubSysSADERSBase.getTypeFilter();
            xmlNode.setAttribute(FIELD_TYPEFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUpdateDate() != null) {
            object = pSSubSysSADERSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADERSBase.getUpdateMan() != null) {
            object = pSSubSysSADERSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUserCat() != null) {
            object = pSSubSysSADERSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUserTag() != null) {
            object = pSSubSysSADERSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUserTag2() != null) {
            object = pSSubSysSADERSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUserTag3() != null) {
            object = pSSubSysSADERSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getUserTag4() != null) {
            object = pSSubSysSADERSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADERSBase.getValidFlag() != null) {
            object = pSSubSysSADERSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSADERSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSADERSBase pSSubSysSADERSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSADERSBase.isArrayFlagDirty() && (bl || pSSubSysSADERSBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSSubSysSADERSBase.getArrayFlag());
        }
        if (pSSubSysSADERSBase.isChildFilterDirty() && (bl || pSSubSysSADERSBase.getChildFilter() != null)) {
            iDataObject.set(FIELD_CHILDFILTER, (Object)pSSubSysSADERSBase.getChildFilter());
        }
        if (pSSubSysSADERSBase.isCodeNameDirty() && (bl || pSSubSysSADERSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSADERSBase.getCodeName());
        }
        if (pSSubSysSADERSBase.isCodeName2Dirty() && (bl || pSSubSysSADERSBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSubSysSADERSBase.getCodeName2());
        }
        if (pSSubSysSADERSBase.isCPSSubSysSADEIdDirty() && (bl || pSSubSysSADERSBase.getCPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_CPSSUBSYSSADEID, (Object)pSSubSysSADERSBase.getCPSSubSysSADEId());
        }
        if (pSSubSysSADERSBase.isCPSSubSysSADENameDirty() && (bl || pSSubSysSADERSBase.getCPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_CPSSUBSYSSADENAME, (Object)pSSubSysSADERSBase.getCPSSubSysSADEName());
        }
        if (pSSubSysSADERSBase.isCreateDateDirty() && (bl || pSSubSysSADERSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSADERSBase.getCreateDate());
        }
        if (pSSubSysSADERSBase.isCreateManDirty() && (bl || pSSubSysSADERSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSADERSBase.getCreateMan());
        }
        if (pSSubSysSADERSBase.isMemoDirty() && (bl || pSSubSysSADERSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSADERSBase.getMemo());
        }
        if (pSSubSysSADERSBase.isOrderValueDirty() && (bl || pSSubSysSADERSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSubSysSADERSBase.getOrderValue());
        }
        if (pSSubSysSADERSBase.isPPSSubSysSADEIdDirty() && (bl || pSSubSysSADERSBase.getPPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PPSSUBSYSSADEID, (Object)pSSubSysSADERSBase.getPPSSubSysSADEId());
        }
        if (pSSubSysSADERSBase.isPPSSubSysSADENameDirty() && (bl || pSSubSysSADERSBase.getPPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PPSSUBSYSSADENAME, (Object)pSSubSysSADERSBase.getPPSSubSysSADEName());
        }
        if (pSSubSysSADERSBase.isPSSubSysSADERSIdDirty() && (bl || pSSubSysSADERSBase.getPSSubSysSADERSId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADERSID, (Object)pSSubSysSADERSBase.getPSSubSysSADERSId());
        }
        if (pSSubSysSADERSBase.isPSSubSysSADERSNameDirty() && (bl || pSSubSysSADERSBase.getPSSubSysSADERSName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADERSNAME, (Object)pSSubSysSADERSBase.getPSSubSysSADERSName());
        }
        if (pSSubSysSADERSBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSubSysSADERSBase.getPSSubSysServiceAPIId());
        }
        if (pSSubSysSADERSBase.isPSSubSysServiceAPINameDirty() && (bl || pSSubSysSADERSBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSubSysSADERSBase.getPSSubSysServiceAPIName());
        }
        if (pSSubSysSADERSBase.isRSTagDirty() && (bl || pSSubSysSADERSBase.getRSTag() != null)) {
            iDataObject.set(FIELD_RSTAG, (Object)pSSubSysSADERSBase.getRSTag());
        }
        if (pSSubSysSADERSBase.isRSTag2Dirty() && (bl || pSSubSysSADERSBase.getRSTag2() != null)) {
            iDataObject.set(FIELD_RSTAG2, (Object)pSSubSysSADERSBase.getRSTag2());
        }
        if (pSSubSysSADERSBase.isTypeFilterDirty() && (bl || pSSubSysSADERSBase.getTypeFilter() != null)) {
            iDataObject.set(FIELD_TYPEFILTER, (Object)pSSubSysSADERSBase.getTypeFilter());
        }
        if (pSSubSysSADERSBase.isUpdateDateDirty() && (bl || pSSubSysSADERSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSADERSBase.getUpdateDate());
        }
        if (pSSubSysSADERSBase.isUpdateManDirty() && (bl || pSSubSysSADERSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSADERSBase.getUpdateMan());
        }
        if (pSSubSysSADERSBase.isUserCatDirty() && (bl || pSSubSysSADERSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysSADERSBase.getUserCat());
        }
        if (pSSubSysSADERSBase.isUserTagDirty() && (bl || pSSubSysSADERSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysSADERSBase.getUserTag());
        }
        if (pSSubSysSADERSBase.isUserTag2Dirty() && (bl || pSSubSysSADERSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysSADERSBase.getUserTag2());
        }
        if (pSSubSysSADERSBase.isUserTag3Dirty() && (bl || pSSubSysSADERSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysSADERSBase.getUserTag3());
        }
        if (pSSubSysSADERSBase.isUserTag4Dirty() && (bl || pSSubSysSADERSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysSADERSBase.getUserTag4());
        }
        if (pSSubSysSADERSBase.isValidFlagDirty() && (bl || pSSubSysSADERSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysSADERSBase.getValidFlag());
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
        return PSSubSysSADERSBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSADERSBase pSSubSysSADERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADERSBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSSubSysSADERSBase.resetChildFilter();
                return true;
            }
            case 2: {
                pSSubSysSADERSBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSubSysSADERSBase.resetCodeName2();
                return true;
            }
            case 4: {
                pSSubSysSADERSBase.resetCPSSubSysSADEId();
                return true;
            }
            case 5: {
                pSSubSysSADERSBase.resetCPSSubSysSADEName();
                return true;
            }
            case 6: {
                pSSubSysSADERSBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSubSysSADERSBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSubSysSADERSBase.resetMemo();
                return true;
            }
            case 9: {
                pSSubSysSADERSBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSSubSysSADERSBase.resetPPSSubSysSADEId();
                return true;
            }
            case 11: {
                pSSubSysSADERSBase.resetPPSSubSysSADEName();
                return true;
            }
            case 12: {
                pSSubSysSADERSBase.resetPSSubSysSADERSId();
                return true;
            }
            case 13: {
                pSSubSysSADERSBase.resetPSSubSysSADERSName();
                return true;
            }
            case 14: {
                pSSubSysSADERSBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 15: {
                pSSubSysSADERSBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 16: {
                pSSubSysSADERSBase.resetRSTag();
                return true;
            }
            case 17: {
                pSSubSysSADERSBase.resetRSTag2();
                return true;
            }
            case 18: {
                pSSubSysSADERSBase.resetTypeFilter();
                return true;
            }
            case 19: {
                pSSubSysSADERSBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSubSysSADERSBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSubSysSADERSBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSubSysSADERSBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSubSysSADERSBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSubSysSADERSBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSubSysSADERSBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSSubSysSADERSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getCPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSubSysSADE();
        }
        if (this.getCPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objCPSSubSysSADELock;
        synchronized (n) {
            if (this.cpssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getCPSSubSysSADEId(), (Object)this.cpssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.cpssubsyssade = null;
            }
            if (this.cpssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getCPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet((IEntity)pSSubSysSADE);
                this.cpssubsyssade = pSSubSysSADE;
            }
            return this.cpssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getPPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSubSysSADE();
        }
        if (this.getPPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objPPSSubSysSADELock;
        synchronized (n) {
            if (this.ppssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSubSysSADEId(), (Object)this.ppssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.ppssubsyssade = null;
            }
            if (this.ppssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getPPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet((IEntity)pSSubSysSADE);
                this.ppssubsyssade = pSSubSysSADE;
            }
            return this.ppssubsyssade;
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
                pSSubSysServiceAPIService.autoGet((IEntity)pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    private PSSubSysSADERSBase getProxyEntity() {
        return this.proxyPSSubSysSADERSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSADERSBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSADERSBase) {
            this.proxyPSSubSysSADERSBase = (PSSubSysSADERSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARRAYFLAG, 0);
        fieldIndexMap.put(FIELD_CHILDFILTER, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CODENAME2, 3);
        fieldIndexMap.put(FIELD_CPSSUBSYSSADEID, 4);
        fieldIndexMap.put(FIELD_CPSSUBSYSSADENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PPSSUBSYSSADEID, 10);
        fieldIndexMap.put(FIELD_PPSSUBSYSSADENAME, 11);
        fieldIndexMap.put(FIELD_PSSUBSYSSADERSID, 12);
        fieldIndexMap.put(FIELD_PSSUBSYSSADERSNAME, 13);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 14);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 15);
        fieldIndexMap.put(FIELD_RSTAG, 16);
        fieldIndexMap.put(FIELD_RSTAG2, 17);
        fieldIndexMap.put(FIELD_TYPEFILTER, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

