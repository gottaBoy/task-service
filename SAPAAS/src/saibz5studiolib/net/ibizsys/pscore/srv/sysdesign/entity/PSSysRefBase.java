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
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRefBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCDOMAINNAME = "DCDOMAINNAME";
    public static final String FIELD_DEVSLNCODENAME = "DEVSLNCODENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSYSREFID = "PSSYSREFID";
    public static final String FIELD_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REALSYSID = "REALSYSID";
    public static final String FIELD_REFPARAM = "REFPARAM";
    public static final String FIELD_REFPARAM2 = "REFPARAM2";
    public static final String FIELD_REFPARAMS = "REFPARAMS";
    public static final String FIELD_SFFWFLAG = "SFFWFLAG";
    public static final String FIELD_SRVCODENAME = "SRVCODENAME";
    public static final String FIELD_SYSCODENAME = "SYSCODENAME";
    public static final String FIELD_SYSNAME = "SYSNAME";
    public static final String FIELD_SYSPKGNAME = "SYSPKGNAME";
    public static final String FIELD_SYSREFTYPE = "SYSREFTYPE";
    public static final String FIELD_SYSVCNAME = "SYSVCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DCDOMAINNAME = 3;
    private static final int INDEX_DEVSLNCODENAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEVSLNSYSID = 7;
    private static final int INDEX_PSDEVSLNSYSNAME = 8;
    private static final int INDEX_PSDEVSLNSYSSRVID = 9;
    private static final int INDEX_PSDEVSLNSYSSRVNAME = 10;
    private static final int INDEX_PSSUBSYSID = 11;
    private static final int INDEX_PSSUBSYSNAME = 12;
    private static final int INDEX_PSSYSREFID = 13;
    private static final int INDEX_PSSYSREFNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_REALSYSID = 17;
    private static final int INDEX_REFPARAM = 18;
    private static final int INDEX_REFPARAM2 = 19;
    private static final int INDEX_REFPARAMS = 20;
    private static final int INDEX_SFFWFLAG = 21;
    private static final int INDEX_SRVCODENAME = 22;
    private static final int INDEX_SYSCODENAME = 23;
    private static final int INDEX_SYSNAME = 24;
    private static final int INDEX_SYSPKGNAME = 25;
    private static final int INDEX_SYSREFTYPE = 26;
    private static final int INDEX_SYSVCNAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final int INDEX_VERSION = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRefBase proxyPSSysRefBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dcdomainnameDirtyFlag = false;
    private boolean devslncodenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyssrvidDirtyFlag = false;
    private boolean psdevslnsyssrvnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssysrefidDirtyFlag = false;
    private boolean pssysrefnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean realsysidDirtyFlag = false;
    private boolean refparamDirtyFlag = false;
    private boolean refparam2DirtyFlag = false;
    private boolean refparamsDirtyFlag = false;
    private boolean sffwflagDirtyFlag = false;
    private boolean srvcodenameDirtyFlag = false;
    private boolean syscodenameDirtyFlag = false;
    private boolean sysnameDirtyFlag = false;
    private boolean syspkgnameDirtyFlag = false;
    private boolean sysreftypeDirtyFlag = false;
    private boolean sysvcnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dcdomainname")
    private String dcdomainname;
    @Column(name="devslncodename")
    private String devslncodename;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyssrvid")
    private String psdevslnsyssrvid;
    @Column(name="psdevslnsyssrvname")
    private String psdevslnsyssrvname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="pssysrefid")
    private String pssysrefid;
    @Column(name="pssysrefname")
    private String pssysrefname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="realsysid")
    private String realsysid;
    @Column(name="refparam")
    private String refparam;
    @Column(name="refparam2")
    private String refparam2;
    @Column(name="refparams")
    private String refparams;
    @Column(name="sffwflag")
    private Integer sffwflag;
    @Column(name="srvcodename")
    private String srvcodename;
    @Column(name="syscodename")
    private String syscodename;
    @Column(name="sysname")
    private String sysname;
    @Column(name="syspkgname")
    private String syspkgname;
    @Column(name="sysreftype")
    private String sysreftype;
    @Column(name="sysvcname")
    private String sysvcname;
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
    @Column(name="version")
    private Integer version;
    private Integer objPSDevSlnSysSrvLock = new Integer(1);
    private PSDevSlnSysSrv psdevslnsyssrv = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDEMapsLock = new Integer(1);
    private ArrayList<PSDEMap> psdemaps = null;
    private Integer objPSModulesLock = new Integer(1);
    private ArrayList<PSModule> psmodules = null;

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
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

    public void setDCDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcdomainname = string;
        this.dcdomainnameDirtyFlag = true;
    }

    public String getDCDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCDomainName();
        }
        return this.dcdomainname;
    }

    public boolean isDCDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCDomainNameDirty();
        }
        return this.dcdomainnameDirtyFlag;
    }

    public void resetDCDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCDomainName();
            return;
        }
        this.dcdomainnameDirtyFlag = false;
        this.dcdomainname = null;
    }

    public void setDevSlnCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSlnCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devslncodename = string;
        this.devslncodenameDirtyFlag = true;
    }

    public String getDevSlnCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSlnCodeName();
        }
        return this.devslncodename;
    }

    public boolean isDevSlnCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSlnCodeNameDirty();
        }
        return this.devslncodenameDirtyFlag;
    }

    public void resetDevSlnCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSlnCodeName();
            return;
        }
        this.devslncodenameDirtyFlag = false;
        this.devslncodename = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvid = string;
        this.psdevslnsyssrvidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvId();
        }
        return this.psdevslnsyssrvid;
    }

    public boolean isPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvIdDirty();
        }
        return this.psdevslnsyssrvidDirtyFlag;
    }

    public void resetPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvId();
            return;
        }
        this.psdevslnsyssrvidDirtyFlag = false;
        this.psdevslnsyssrvid = null;
    }

    public void setPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvname = string;
        this.psdevslnsyssrvnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvName();
        }
        return this.psdevslnsyssrvname;
    }

    public boolean isPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvNameDirty();
        }
        return this.psdevslnsyssrvnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvName();
            return;
        }
        this.psdevslnsyssrvnameDirtyFlag = false;
        this.psdevslnsyssrvname = null;
    }

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
    }

    public void setPSSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefid = string;
        this.pssysrefidDirtyFlag = true;
    }

    public String getPSSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefId();
        }
        return this.pssysrefid;
    }

    public boolean isPSSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefIdDirty();
        }
        return this.pssysrefidDirtyFlag;
    }

    public void resetPSSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefId();
            return;
        }
        this.pssysrefidDirtyFlag = false;
        this.pssysrefid = null;
    }

    public void setPSSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefname = string;
        this.pssysrefnameDirtyFlag = true;
    }

    public String getPSSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefName();
        }
        return this.pssysrefname;
    }

    public boolean isPSSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefNameDirty();
        }
        return this.pssysrefnameDirtyFlag;
    }

    public void resetPSSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefName();
            return;
        }
        this.pssysrefnameDirtyFlag = false;
        this.pssysrefname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setRealSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.realsysid = string;
        this.realsysidDirtyFlag = true;
    }

    public String getRealSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealSysId();
        }
        return this.realsysid;
    }

    public boolean isRealSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealSysIdDirty();
        }
        return this.realsysidDirtyFlag;
    }

    public void resetRealSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealSysId();
            return;
        }
        this.realsysidDirtyFlag = false;
        this.realsysid = null;
    }

    public void setRefParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam = string;
        this.refparamDirtyFlag = true;
    }

    public String getRefParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam();
        }
        return this.refparam;
    }

    public boolean isRefParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDirty();
        }
        return this.refparamDirtyFlag;
    }

    public void resetRefParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam();
            return;
        }
        this.refparamDirtyFlag = false;
        this.refparam = null;
    }

    public void setRefParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam2 = string;
        this.refparam2DirtyFlag = true;
    }

    public String getRefParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam2();
        }
        return this.refparam2;
    }

    public boolean isRefParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParam2Dirty();
        }
        return this.refparam2DirtyFlag;
    }

    public void resetRefParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam2();
            return;
        }
        this.refparam2DirtyFlag = false;
        this.refparam2 = null;
    }

    public void setRefParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparams = string;
        this.refparamsDirtyFlag = true;
    }

    public String getRefParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParams();
        }
        return this.refparams;
    }

    public boolean isRefParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamsDirty();
        }
        return this.refparamsDirtyFlag;
    }

    public void resetRefParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParams();
            return;
        }
        this.refparamsDirtyFlag = false;
        this.refparams = null;
    }

    public void setSFFWFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFFWFlag(n);
            return;
        }
        this.sffwflag = n;
        this.sffwflagDirtyFlag = true;
    }

    public Integer getSFFWFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFFWFlag();
        }
        return this.sffwflag;
    }

    public boolean isSFFWFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFFWFlagDirty();
        }
        return this.sffwflagDirtyFlag;
    }

    public void resetSFFWFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFFWFlag();
            return;
        }
        this.sffwflagDirtyFlag = false;
        this.sffwflag = null;
    }

    public void setSrvCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrvCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srvcodename = string;
        this.srvcodenameDirtyFlag = true;
    }

    public String getSrvCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrvCodeName();
        }
        return this.srvcodename;
    }

    public boolean isSrvCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrvCodeNameDirty();
        }
        return this.srvcodenameDirtyFlag;
    }

    public void resetSrvCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrvCodeName();
            return;
        }
        this.srvcodenameDirtyFlag = false;
        this.srvcodename = null;
    }

    public void setSysCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syscodename = string;
        this.syscodenameDirtyFlag = true;
    }

    public String getSysCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysCodeName();
        }
        return this.syscodename;
    }

    public boolean isSysCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysCodeNameDirty();
        }
        return this.syscodenameDirtyFlag;
    }

    public void resetSysCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysCodeName();
            return;
        }
        this.syscodenameDirtyFlag = false;
        this.syscodename = null;
    }

    public void setSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysname = string;
        this.sysnameDirtyFlag = true;
    }

    public String getSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysName();
        }
        return this.sysname;
    }

    public boolean isSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysNameDirty();
        }
        return this.sysnameDirtyFlag;
    }

    public void resetSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysName();
            return;
        }
        this.sysnameDirtyFlag = false;
        this.sysname = null;
    }

    public void setSysPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syspkgname = string;
        this.syspkgnameDirtyFlag = true;
    }

    public String getSysPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPkgName();
        }
        return this.syspkgname;
    }

    public boolean isSysPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPkgNameDirty();
        }
        return this.syspkgnameDirtyFlag;
    }

    public void resetSysPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPkgName();
            return;
        }
        this.syspkgnameDirtyFlag = false;
        this.syspkgname = null;
    }

    public void setSysRefType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRefType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysreftype = string;
        this.sysreftypeDirtyFlag = true;
    }

    public String getSysRefType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRefType();
        }
        return this.sysreftype;
    }

    public boolean isSysRefTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRefTypeDirty();
        }
        return this.sysreftypeDirtyFlag;
    }

    public void resetSysRefType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRefType();
            return;
        }
        this.sysreftypeDirtyFlag = false;
        this.sysreftype = null;
    }

    public void setSysVCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysvcname = string;
        this.sysvcnameDirtyFlag = true;
    }

    public String getSysVCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVCName();
        }
        return this.sysvcname;
    }

    public boolean isSysVCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVCNameDirty();
        }
        return this.sysvcnameDirtyFlag;
    }

    public void resetSysVCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVCName();
            return;
        }
        this.sysvcnameDirtyFlag = false;
        this.sysvcname = null;
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

    public void setVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(n);
            return;
        }
        this.version = n;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSSysRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRefBase pSSysRefBase) {
        pSSysRefBase.resetClsPkgParams();
        pSSysRefBase.resetCreateDate();
        pSSysRefBase.resetCreateMan();
        pSSysRefBase.resetDCDomainName();
        pSSysRefBase.resetDevSlnCodeName();
        pSSysRefBase.resetMemo();
        pSSysRefBase.resetOrderValue();
        pSSysRefBase.resetPSDevSlnSysId();
        pSSysRefBase.resetPSDevSlnSysName();
        pSSysRefBase.resetPSDevSlnSysSrvId();
        pSSysRefBase.resetPSDevSlnSysSrvName();
        pSSysRefBase.resetPSSubSysId();
        pSSysRefBase.resetPSSubSysName();
        pSSysRefBase.resetPSSysRefId();
        pSSysRefBase.resetPSSysRefName();
        pSSysRefBase.resetPSSystemId();
        pSSysRefBase.resetPSSystemName();
        pSSysRefBase.resetRealSysId();
        pSSysRefBase.resetRefParam();
        pSSysRefBase.resetRefParam2();
        pSSysRefBase.resetRefParams();
        pSSysRefBase.resetSFFWFlag();
        pSSysRefBase.resetSrvCodeName();
        pSSysRefBase.resetSysCodeName();
        pSSysRefBase.resetSysName();
        pSSysRefBase.resetSysPkgName();
        pSSysRefBase.resetSysRefType();
        pSSysRefBase.resetSysVCName();
        pSSysRefBase.resetUpdateDate();
        pSSysRefBase.resetUpdateMan();
        pSSysRefBase.resetUserCat();
        pSSysRefBase.resetUserTag();
        pSSysRefBase.resetUserTag2();
        pSSysRefBase.resetUserTag3();
        pSSysRefBase.resetUserTag4();
        pSSysRefBase.resetValidFlag();
        pSSysRefBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCDomainNameDirty()) {
            hashMap.put(FIELD_DCDOMAINNAME, this.getDCDomainName());
        }
        if (!bl || this.isDevSlnCodeNameDirty()) {
            hashMap.put(FIELD_DEVSLNCODENAME, this.getDevSlnCodeName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVID, this.getPSDevSlnSysSrvId());
        }
        if (!bl || this.isPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVNAME, this.getPSDevSlnSysSrvName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
        }
        if (!bl || this.isPSSysRefIdDirty()) {
            hashMap.put(FIELD_PSSYSREFID, this.getPSSysRefId());
        }
        if (!bl || this.isPSSysRefNameDirty()) {
            hashMap.put(FIELD_PSSYSREFNAME, this.getPSSysRefName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRealSysIdDirty()) {
            hashMap.put(FIELD_REALSYSID, this.getRealSysId());
        }
        if (!bl || this.isRefParamDirty()) {
            hashMap.put(FIELD_REFPARAM, this.getRefParam());
        }
        if (!bl || this.isRefParam2Dirty()) {
            hashMap.put(FIELD_REFPARAM2, this.getRefParam2());
        }
        if (!bl || this.isRefParamsDirty()) {
            hashMap.put(FIELD_REFPARAMS, this.getRefParams());
        }
        if (!bl || this.isSFFWFlagDirty()) {
            hashMap.put(FIELD_SFFWFLAG, this.getSFFWFlag());
        }
        if (!bl || this.isSrvCodeNameDirty()) {
            hashMap.put(FIELD_SRVCODENAME, this.getSrvCodeName());
        }
        if (!bl || this.isSysCodeNameDirty()) {
            hashMap.put(FIELD_SYSCODENAME, this.getSysCodeName());
        }
        if (!bl || this.isSysNameDirty()) {
            hashMap.put(FIELD_SYSNAME, this.getSysName());
        }
        if (!bl || this.isSysPkgNameDirty()) {
            hashMap.put(FIELD_SYSPKGNAME, this.getSysPkgName());
        }
        if (!bl || this.isSysRefTypeDirty()) {
            hashMap.put(FIELD_SYSREFTYPE, this.getSysRefType());
        }
        if (!bl || this.isSysVCNameDirty()) {
            hashMap.put(FIELD_SYSVCNAME, this.getSysVCName());
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
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSSysRefBase.get(this, n);
    }

    private static Object get(PSSysRefBase pSSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefBase.getClsPkgParams();
            }
            case 1: {
                return pSSysRefBase.getCreateDate();
            }
            case 2: {
                return pSSysRefBase.getCreateMan();
            }
            case 3: {
                return pSSysRefBase.getDCDomainName();
            }
            case 4: {
                return pSSysRefBase.getDevSlnCodeName();
            }
            case 5: {
                return pSSysRefBase.getMemo();
            }
            case 6: {
                return pSSysRefBase.getOrderValue();
            }
            case 7: {
                return pSSysRefBase.getPSDevSlnSysId();
            }
            case 8: {
                return pSSysRefBase.getPSDevSlnSysName();
            }
            case 9: {
                return pSSysRefBase.getPSDevSlnSysSrvId();
            }
            case 10: {
                return pSSysRefBase.getPSDevSlnSysSrvName();
            }
            case 11: {
                return pSSysRefBase.getPSSubSysId();
            }
            case 12: {
                return pSSysRefBase.getPSSubSysName();
            }
            case 13: {
                return pSSysRefBase.getPSSysRefId();
            }
            case 14: {
                return pSSysRefBase.getPSSysRefName();
            }
            case 15: {
                return pSSysRefBase.getPSSystemId();
            }
            case 16: {
                return pSSysRefBase.getPSSystemName();
            }
            case 17: {
                return pSSysRefBase.getRealSysId();
            }
            case 18: {
                return pSSysRefBase.getRefParam();
            }
            case 19: {
                return pSSysRefBase.getRefParam2();
            }
            case 20: {
                return pSSysRefBase.getRefParams();
            }
            case 21: {
                return pSSysRefBase.getSFFWFlag();
            }
            case 22: {
                return pSSysRefBase.getSrvCodeName();
            }
            case 23: {
                return pSSysRefBase.getSysCodeName();
            }
            case 24: {
                return pSSysRefBase.getSysName();
            }
            case 25: {
                return pSSysRefBase.getSysPkgName();
            }
            case 26: {
                return pSSysRefBase.getSysRefType();
            }
            case 27: {
                return pSSysRefBase.getSysVCName();
            }
            case 28: {
                return pSSysRefBase.getUpdateDate();
            }
            case 29: {
                return pSSysRefBase.getUpdateMan();
            }
            case 30: {
                return pSSysRefBase.getUserCat();
            }
            case 31: {
                return pSSysRefBase.getUserTag();
            }
            case 32: {
                return pSSysRefBase.getUserTag2();
            }
            case 33: {
                return pSSysRefBase.getUserTag3();
            }
            case 34: {
                return pSSysRefBase.getUserTag4();
            }
            case 35: {
                return pSSysRefBase.getValidFlag();
            }
            case 36: {
                return pSSysRefBase.getVersion();
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
        PSSysRefBase.set(this, n, object);
    }

    private static void set(PSSysRefBase pSSysRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRefBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysRefBase.setDCDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysRefBase.setDevSlnCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysRefBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRefBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRefBase.setPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRefBase.setPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysRefBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysRefBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysRefBase.setPSSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysRefBase.setPSSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysRefBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysRefBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysRefBase.setRealSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysRefBase.setRefParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysRefBase.setRefParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysRefBase.setRefParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysRefBase.setSFFWFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysRefBase.setSrvCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysRefBase.setSysCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysRefBase.setSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysRefBase.setSysPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysRefBase.setSysRefType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysRefBase.setSysVCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSSysRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysRefBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysRefBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysRefBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysRefBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysRefBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysRefBase.setVersion(DataObject.getIntegerValue((Object)object));
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
        return PSSysRefBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRefBase pSSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSSysRefBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysRefBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysRefBase.getDCDomainName() == null;
            }
            case 4: {
                return pSSysRefBase.getDevSlnCodeName() == null;
            }
            case 5: {
                return pSSysRefBase.getMemo() == null;
            }
            case 6: {
                return pSSysRefBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysRefBase.getPSDevSlnSysId() == null;
            }
            case 8: {
                return pSSysRefBase.getPSDevSlnSysName() == null;
            }
            case 9: {
                return pSSysRefBase.getPSDevSlnSysSrvId() == null;
            }
            case 10: {
                return pSSysRefBase.getPSDevSlnSysSrvName() == null;
            }
            case 11: {
                return pSSysRefBase.getPSSubSysId() == null;
            }
            case 12: {
                return pSSysRefBase.getPSSubSysName() == null;
            }
            case 13: {
                return pSSysRefBase.getPSSysRefId() == null;
            }
            case 14: {
                return pSSysRefBase.getPSSysRefName() == null;
            }
            case 15: {
                return pSSysRefBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysRefBase.getPSSystemName() == null;
            }
            case 17: {
                return pSSysRefBase.getRealSysId() == null;
            }
            case 18: {
                return pSSysRefBase.getRefParam() == null;
            }
            case 19: {
                return pSSysRefBase.getRefParam2() == null;
            }
            case 20: {
                return pSSysRefBase.getRefParams() == null;
            }
            case 21: {
                return pSSysRefBase.getSFFWFlag() == null;
            }
            case 22: {
                return pSSysRefBase.getSrvCodeName() == null;
            }
            case 23: {
                return pSSysRefBase.getSysCodeName() == null;
            }
            case 24: {
                return pSSysRefBase.getSysName() == null;
            }
            case 25: {
                return pSSysRefBase.getSysPkgName() == null;
            }
            case 26: {
                return pSSysRefBase.getSysRefType() == null;
            }
            case 27: {
                return pSSysRefBase.getSysVCName() == null;
            }
            case 28: {
                return pSSysRefBase.getUpdateDate() == null;
            }
            case 29: {
                return pSSysRefBase.getUpdateMan() == null;
            }
            case 30: {
                return pSSysRefBase.getUserCat() == null;
            }
            case 31: {
                return pSSysRefBase.getUserTag() == null;
            }
            case 32: {
                return pSSysRefBase.getUserTag2() == null;
            }
            case 33: {
                return pSSysRefBase.getUserTag3() == null;
            }
            case 34: {
                return pSSysRefBase.getUserTag4() == null;
            }
            case 35: {
                return pSSysRefBase.getValidFlag() == null;
            }
            case 36: {
                return pSSysRefBase.getVersion() == null;
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
        return PSSysRefBase.contains(this, n);
    }

    private static boolean contains(PSSysRefBase pSSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRefBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSSysRefBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysRefBase.isCreateManDirty();
            }
            case 3: {
                return pSSysRefBase.isDCDomainNameDirty();
            }
            case 4: {
                return pSSysRefBase.isDevSlnCodeNameDirty();
            }
            case 5: {
                return pSSysRefBase.isMemoDirty();
            }
            case 6: {
                return pSSysRefBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysRefBase.isPSDevSlnSysIdDirty();
            }
            case 8: {
                return pSSysRefBase.isPSDevSlnSysNameDirty();
            }
            case 9: {
                return pSSysRefBase.isPSDevSlnSysSrvIdDirty();
            }
            case 10: {
                return pSSysRefBase.isPSDevSlnSysSrvNameDirty();
            }
            case 11: {
                return pSSysRefBase.isPSSubSysIdDirty();
            }
            case 12: {
                return pSSysRefBase.isPSSubSysNameDirty();
            }
            case 13: {
                return pSSysRefBase.isPSSysRefIdDirty();
            }
            case 14: {
                return pSSysRefBase.isPSSysRefNameDirty();
            }
            case 15: {
                return pSSysRefBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysRefBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSSysRefBase.isRealSysIdDirty();
            }
            case 18: {
                return pSSysRefBase.isRefParamDirty();
            }
            case 19: {
                return pSSysRefBase.isRefParam2Dirty();
            }
            case 20: {
                return pSSysRefBase.isRefParamsDirty();
            }
            case 21: {
                return pSSysRefBase.isSFFWFlagDirty();
            }
            case 22: {
                return pSSysRefBase.isSrvCodeNameDirty();
            }
            case 23: {
                return pSSysRefBase.isSysCodeNameDirty();
            }
            case 24: {
                return pSSysRefBase.isSysNameDirty();
            }
            case 25: {
                return pSSysRefBase.isSysPkgNameDirty();
            }
            case 26: {
                return pSSysRefBase.isSysRefTypeDirty();
            }
            case 27: {
                return pSSysRefBase.isSysVCNameDirty();
            }
            case 28: {
                return pSSysRefBase.isUpdateDateDirty();
            }
            case 29: {
                return pSSysRefBase.isUpdateManDirty();
            }
            case 30: {
                return pSSysRefBase.isUserCatDirty();
            }
            case 31: {
                return pSSysRefBase.isUserTagDirty();
            }
            case 32: {
                return pSSysRefBase.isUserTag2Dirty();
            }
            case 33: {
                return pSSysRefBase.isUserTag3Dirty();
            }
            case 34: {
                return pSSysRefBase.isUserTag4Dirty();
            }
            case 35: {
                return pSSysRefBase.isValidFlagDirty();
            }
            case 36: {
                return pSSysRefBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRefBase pSSysRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRefBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSSysRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRefBase.getDCDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcdomainname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getDCDomainName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getDevSlnCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devslncodename", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getDevSlnCodeName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSysRefId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSysRefName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getRealSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realsysid", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getRealSysId()), (boolean)false);
        }
        if (bl || pSSysRefBase.getRefParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getRefParam()), (boolean)false);
        }
        if (bl || pSSysRefBase.getRefParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam2", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getRefParam2()), (boolean)false);
        }
        if (bl || pSSysRefBase.getRefParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparams", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getRefParams()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSFFWFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sffwflag", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSFFWFlag()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSrvCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srvcodename", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSrvCodeName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSysCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syscodename", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSysCodeName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSysName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSysPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syspkgname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSysPkgName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSysRefType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysreftype", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSysRefType()), (boolean)false);
        }
        if (bl || pSSysRefBase.getSysVCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysvcname", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getSysVCName()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysRefBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysRefBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSysRefBase.getJSONValue((Object)pSSysRefBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRefBase pSSysRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRefBase.getClsPkgParams() != null) {
            object = pSSysRefBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getCreateDate() != null) {
            object = pSSysRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRefBase.getCreateMan() != null) {
            object = pSSysRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getDCDomainName() != null) {
            object = pSSysRefBase.getDCDomainName();
            xmlNode.setAttribute(FIELD_DCDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getDevSlnCodeName() != null) {
            object = pSSysRefBase.getDevSlnCodeName();
            xmlNode.setAttribute(FIELD_DEVSLNCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getMemo() != null) {
            object = pSSysRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getOrderValue() != null) {
            object = pSSysRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRefBase.getPSDevSlnSysId() != null) {
            object = pSSysRefBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysName() != null) {
            object = pSSysRefBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysSrvId() != null) {
            object = pSSysRefBase.getPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSDevSlnSysSrvName() != null) {
            object = pSSysRefBase.getPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSubSysId() != null) {
            object = pSSysRefBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSubSysName() != null) {
            object = pSSysRefBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSysRefId() != null) {
            object = pSSysRefBase.getPSSysRefId();
            xmlNode.setAttribute(FIELD_PSSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSysRefName() != null) {
            object = pSSysRefBase.getPSSysRefName();
            xmlNode.setAttribute(FIELD_PSSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSystemId() != null) {
            object = pSSysRefBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getPSSystemName() != null) {
            object = pSSysRefBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getRealSysId() != null) {
            object = pSSysRefBase.getRealSysId();
            xmlNode.setAttribute(FIELD_REALSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getRefParam() != null) {
            object = pSSysRefBase.getRefParam();
            xmlNode.setAttribute(FIELD_REFPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getRefParam2() != null) {
            object = pSSysRefBase.getRefParam2();
            xmlNode.setAttribute(FIELD_REFPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getRefParams() != null) {
            object = pSSysRefBase.getRefParams();
            xmlNode.setAttribute(FIELD_REFPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSFFWFlag() != null) {
            object = pSSysRefBase.getSFFWFlag();
            xmlNode.setAttribute(FIELD_SFFWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRefBase.getSrvCodeName() != null) {
            object = pSSysRefBase.getSrvCodeName();
            xmlNode.setAttribute(FIELD_SRVCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSysCodeName() != null) {
            object = pSSysRefBase.getSysCodeName();
            xmlNode.setAttribute(FIELD_SYSCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSysName() != null) {
            object = pSSysRefBase.getSysName();
            xmlNode.setAttribute(FIELD_SYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSysPkgName() != null) {
            object = pSSysRefBase.getSysPkgName();
            xmlNode.setAttribute(FIELD_SYSPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSysRefType() != null) {
            object = pSSysRefBase.getSysRefType();
            xmlNode.setAttribute(FIELD_SYSREFTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getSysVCName() != null) {
            object = pSSysRefBase.getSysVCName();
            xmlNode.setAttribute(FIELD_SYSVCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUpdateDate() != null) {
            object = pSSysRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRefBase.getUpdateMan() != null) {
            object = pSSysRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUserCat() != null) {
            object = pSSysRefBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUserTag() != null) {
            object = pSSysRefBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUserTag2() != null) {
            object = pSSysRefBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUserTag3() != null) {
            object = pSSysRefBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getUserTag4() != null) {
            object = pSSysRefBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysRefBase.getValidFlag() != null) {
            object = pSSysRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRefBase.getVersion() != null) {
            object = pSSysRefBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRefBase pSSysRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRefBase.isClsPkgParamsDirty() && (bl || pSSysRefBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSSysRefBase.getClsPkgParams());
        }
        if (pSSysRefBase.isCreateDateDirty() && (bl || pSSysRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRefBase.getCreateDate());
        }
        if (pSSysRefBase.isCreateManDirty() && (bl || pSSysRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRefBase.getCreateMan());
        }
        if (pSSysRefBase.isDCDomainNameDirty() && (bl || pSSysRefBase.getDCDomainName() != null)) {
            iDataObject.set(FIELD_DCDOMAINNAME, (Object)pSSysRefBase.getDCDomainName());
        }
        if (pSSysRefBase.isDevSlnCodeNameDirty() && (bl || pSSysRefBase.getDevSlnCodeName() != null)) {
            iDataObject.set(FIELD_DEVSLNCODENAME, (Object)pSSysRefBase.getDevSlnCodeName());
        }
        if (pSSysRefBase.isMemoDirty() && (bl || pSSysRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysRefBase.getMemo());
        }
        if (pSSysRefBase.isOrderValueDirty() && (bl || pSSysRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysRefBase.getOrderValue());
        }
        if (pSSysRefBase.isPSDevSlnSysIdDirty() && (bl || pSSysRefBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSysRefBase.getPSDevSlnSysId());
        }
        if (pSSysRefBase.isPSDevSlnSysNameDirty() && (bl || pSSysRefBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSSysRefBase.getPSDevSlnSysName());
        }
        if (pSSysRefBase.isPSDevSlnSysSrvIdDirty() && (bl || pSSysRefBase.getPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVID, (Object)pSSysRefBase.getPSDevSlnSysSrvId());
        }
        if (pSSysRefBase.isPSDevSlnSysSrvNameDirty() && (bl || pSSysRefBase.getPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVNAME, (Object)pSSysRefBase.getPSDevSlnSysSrvName());
        }
        if (pSSysRefBase.isPSSubSysIdDirty() && (bl || pSSysRefBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSysRefBase.getPSSubSysId());
        }
        if (pSSysRefBase.isPSSubSysNameDirty() && (bl || pSSysRefBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSysRefBase.getPSSubSysName());
        }
        if (pSSysRefBase.isPSSysRefIdDirty() && (bl || pSSysRefBase.getPSSysRefId() != null)) {
            iDataObject.set(FIELD_PSSYSREFID, (Object)pSSysRefBase.getPSSysRefId());
        }
        if (pSSysRefBase.isPSSysRefNameDirty() && (bl || pSSysRefBase.getPSSysRefName() != null)) {
            iDataObject.set(FIELD_PSSYSREFNAME, (Object)pSSysRefBase.getPSSysRefName());
        }
        if (pSSysRefBase.isPSSystemIdDirty() && (bl || pSSysRefBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysRefBase.getPSSystemId());
        }
        if (pSSysRefBase.isPSSystemNameDirty() && (bl || pSSysRefBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysRefBase.getPSSystemName());
        }
        if (pSSysRefBase.isRealSysIdDirty() && (bl || pSSysRefBase.getRealSysId() != null)) {
            iDataObject.set(FIELD_REALSYSID, (Object)pSSysRefBase.getRealSysId());
        }
        if (pSSysRefBase.isRefParamDirty() && (bl || pSSysRefBase.getRefParam() != null)) {
            iDataObject.set(FIELD_REFPARAM, (Object)pSSysRefBase.getRefParam());
        }
        if (pSSysRefBase.isRefParam2Dirty() && (bl || pSSysRefBase.getRefParam2() != null)) {
            iDataObject.set(FIELD_REFPARAM2, (Object)pSSysRefBase.getRefParam2());
        }
        if (pSSysRefBase.isRefParamsDirty() && (bl || pSSysRefBase.getRefParams() != null)) {
            iDataObject.set(FIELD_REFPARAMS, (Object)pSSysRefBase.getRefParams());
        }
        if (pSSysRefBase.isSFFWFlagDirty() && (bl || pSSysRefBase.getSFFWFlag() != null)) {
            iDataObject.set(FIELD_SFFWFLAG, (Object)pSSysRefBase.getSFFWFlag());
        }
        if (pSSysRefBase.isSrvCodeNameDirty() && (bl || pSSysRefBase.getSrvCodeName() != null)) {
            iDataObject.set(FIELD_SRVCODENAME, (Object)pSSysRefBase.getSrvCodeName());
        }
        if (pSSysRefBase.isSysCodeNameDirty() && (bl || pSSysRefBase.getSysCodeName() != null)) {
            iDataObject.set(FIELD_SYSCODENAME, (Object)pSSysRefBase.getSysCodeName());
        }
        if (pSSysRefBase.isSysNameDirty() && (bl || pSSysRefBase.getSysName() != null)) {
            iDataObject.set(FIELD_SYSNAME, (Object)pSSysRefBase.getSysName());
        }
        if (pSSysRefBase.isSysPkgNameDirty() && (bl || pSSysRefBase.getSysPkgName() != null)) {
            iDataObject.set(FIELD_SYSPKGNAME, (Object)pSSysRefBase.getSysPkgName());
        }
        if (pSSysRefBase.isSysRefTypeDirty() && (bl || pSSysRefBase.getSysRefType() != null)) {
            iDataObject.set(FIELD_SYSREFTYPE, (Object)pSSysRefBase.getSysRefType());
        }
        if (pSSysRefBase.isSysVCNameDirty() && (bl || pSSysRefBase.getSysVCName() != null)) {
            iDataObject.set(FIELD_SYSVCNAME, (Object)pSSysRefBase.getSysVCName());
        }
        if (pSSysRefBase.isUpdateDateDirty() && (bl || pSSysRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRefBase.getUpdateDate());
        }
        if (pSSysRefBase.isUpdateManDirty() && (bl || pSSysRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRefBase.getUpdateMan());
        }
        if (pSSysRefBase.isUserCatDirty() && (bl || pSSysRefBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysRefBase.getUserCat());
        }
        if (pSSysRefBase.isUserTagDirty() && (bl || pSSysRefBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysRefBase.getUserTag());
        }
        if (pSSysRefBase.isUserTag2Dirty() && (bl || pSSysRefBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysRefBase.getUserTag2());
        }
        if (pSSysRefBase.isUserTag3Dirty() && (bl || pSSysRefBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysRefBase.getUserTag3());
        }
        if (pSSysRefBase.isUserTag4Dirty() && (bl || pSSysRefBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysRefBase.getUserTag4());
        }
        if (pSSysRefBase.isValidFlagDirty() && (bl || pSSysRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysRefBase.getValidFlag());
        }
        if (pSSysRefBase.isVersionDirty() && (bl || pSSysRefBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSysRefBase.getVersion());
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
        return PSSysRefBase.remove(this, n);
    }

    private static boolean remove(PSSysRefBase pSSysRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRefBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSSysRefBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysRefBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysRefBase.resetDCDomainName();
                return true;
            }
            case 4: {
                pSSysRefBase.resetDevSlnCodeName();
                return true;
            }
            case 5: {
                pSSysRefBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysRefBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysRefBase.resetPSDevSlnSysId();
                return true;
            }
            case 8: {
                pSSysRefBase.resetPSDevSlnSysName();
                return true;
            }
            case 9: {
                pSSysRefBase.resetPSDevSlnSysSrvId();
                return true;
            }
            case 10: {
                pSSysRefBase.resetPSDevSlnSysSrvName();
                return true;
            }
            case 11: {
                pSSysRefBase.resetPSSubSysId();
                return true;
            }
            case 12: {
                pSSysRefBase.resetPSSubSysName();
                return true;
            }
            case 13: {
                pSSysRefBase.resetPSSysRefId();
                return true;
            }
            case 14: {
                pSSysRefBase.resetPSSysRefName();
                return true;
            }
            case 15: {
                pSSysRefBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysRefBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSSysRefBase.resetRealSysId();
                return true;
            }
            case 18: {
                pSSysRefBase.resetRefParam();
                return true;
            }
            case 19: {
                pSSysRefBase.resetRefParam2();
                return true;
            }
            case 20: {
                pSSysRefBase.resetRefParams();
                return true;
            }
            case 21: {
                pSSysRefBase.resetSFFWFlag();
                return true;
            }
            case 22: {
                pSSysRefBase.resetSrvCodeName();
                return true;
            }
            case 23: {
                pSSysRefBase.resetSysCodeName();
                return true;
            }
            case 24: {
                pSSysRefBase.resetSysName();
                return true;
            }
            case 25: {
                pSSysRefBase.resetSysPkgName();
                return true;
            }
            case 26: {
                pSSysRefBase.resetSysRefType();
                return true;
            }
            case 27: {
                pSSysRefBase.resetSysVCName();
                return true;
            }
            case 28: {
                pSSysRefBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSSysRefBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSSysRefBase.resetUserCat();
                return true;
            }
            case 31: {
                pSSysRefBase.resetUserTag();
                return true;
            }
            case 32: {
                pSSysRefBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSSysRefBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSSysRefBase.resetUserTag4();
                return true;
            }
            case 35: {
                pSSysRefBase.resetValidFlag();
                return true;
            }
            case 36: {
                pSSysRefBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysSrv getPSDevSlnSysSrv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrv();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysSrvLock;
        synchronized (n) {
            if (this.psdevslnsyssrv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysSrvId(), (Object)this.psdevslnsyssrv.getPSDevSlnSysSrvId()) != 0L) {
                this.psdevslnsyssrv = null;
            }
            if (this.psdevslnsyssrv == null) {
                PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
                pSDevSlnSysSrv.setPSDevSlnSysSrvId(this.getPSDevSlnSysSrvId());
                PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrvService.autoGet((IEntity)pSDevSlnSysSrv);
                this.psdevslnsyssrv = pSDevSlnSysSrv;
            }
            return this.psdevslnsyssrv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet((IEntity)pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMap> getPSDEMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMaps();
        }
        if (this.getPSSysRefId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapsLock;
        synchronized (n) {
            if (this.psdemaps == null) {
                this.psdemaps = pSDEMapService.selectByPSSysRef(this);
            }
            return this.psdemaps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModule> getPSModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModules();
        }
        if (this.getPSSysRefId() == null) {
            return null;
        }
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModulesLock;
        synchronized (n) {
            if (this.psmodules == null) {
                this.psmodules = pSModuleService.selectByPSSysRef(this);
            }
            return this.psmodules;
        }
    }

    private PSSysRefBase getProxyEntity() {
        return this.proxyPSSysRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRefBase) {
            this.proxyPSSysRefBase = (PSSysRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DCDOMAINNAME, 3);
        fieldIndexMap.put(FIELD_DEVSLNCODENAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVNAME, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 11);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSREFID, 13);
        fieldIndexMap.put(FIELD_PSSYSREFNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_REALSYSID, 17);
        fieldIndexMap.put(FIELD_REFPARAM, 18);
        fieldIndexMap.put(FIELD_REFPARAM2, 19);
        fieldIndexMap.put(FIELD_REFPARAMS, 20);
        fieldIndexMap.put(FIELD_SFFWFLAG, 21);
        fieldIndexMap.put(FIELD_SRVCODENAME, 22);
        fieldIndexMap.put(FIELD_SYSCODENAME, 23);
        fieldIndexMap.put(FIELD_SYSNAME, 24);
        fieldIndexMap.put(FIELD_SYSPKGNAME, 25);
        fieldIndexMap.put(FIELD_SYSREFTYPE, 26);
        fieldIndexMap.put(FIELD_SYSVCNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
        fieldIndexMap.put(FIELD_VERSION, 36);
    }
}

