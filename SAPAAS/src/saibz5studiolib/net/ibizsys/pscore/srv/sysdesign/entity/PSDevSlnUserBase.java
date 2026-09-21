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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnUserBase.class);
    public static final String FIELD_ACCMODE = "ACCMODE";
    public static final String FIELD_ALLSYSFLAG = "ALLSYSFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DEVUSEROBJTYPE = "DEVUSEROBJTYPE";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSDEVSLNUSERID = "PSDEVSLNUSERID";
    public static final String FIELD_PSDEVSLNUSERNAME = "PSDEVSLNUSERNAME";
    public static final String FIELD_PSDEVUSEROBJID = "PSDEVUSEROBJID";
    public static final String FIELD_PSDEVUSEROBJNAME = "PSDEVUSEROBJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACCMODE = 0;
    private static final int INDEX_ALLSYSFLAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_DEVUSEROBJTYPE = 5;
    private static final int INDEX_EXPIREDTIME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEVSLNID = 8;
    private static final int INDEX_PSDEVSLNNAME = 9;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTID = 10;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTNAME = 11;
    private static final int INDEX_PSDEVSLNSYSID = 12;
    private static final int INDEX_PSDEVSLNSYSNAME = 13;
    private static final int INDEX_PSDEVSLNTEMPLID = 14;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 15;
    private static final int INDEX_PSDEVSLNUSERID = 16;
    private static final int INDEX_PSDEVSLNUSERNAME = 17;
    private static final int INDEX_PSDEVUSEROBJID = 18;
    private static final int INDEX_PSDEVUSEROBJNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnUserBase proxyPSDevSlnUserBase = null;
    private boolean accmodeDirtyFlag = false;
    private boolean allsysflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean devuserobjtypeDirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysdynainstidDirtyFlag = false;
    private boolean psdevslnsysdynainstnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean psdevslnuseridDirtyFlag = false;
    private boolean psdevslnusernameDirtyFlag = false;
    private boolean psdevuserobjidDirtyFlag = false;
    private boolean psdevuserobjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="accmode")
    private Integer accmode;
    @Column(name="allsysflag")
    private Integer allsysflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="devuserobjtype")
    private String devuserobjtype;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysdynainstid")
    private String psdevslnsysdynainstid;
    @Column(name="psdevslnsysdynainstname")
    private String psdevslnsysdynainstname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="psdevslnuserid")
    private String psdevslnuserid;
    @Column(name="psdevslnusername")
    private String psdevslnusername;
    @Column(name="psdevuserobjid")
    private String psdevuserobjid;
    @Column(name="psdevuserobjname")
    private String psdevuserobjname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnSysDynaInstLock = new Integer(1);
    private PSDevSlnSysDynaInst psdevslnsysdynainst = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevUserObjLock = new Integer(1);
    private PSDevUserObj psdevuserobj = null;

    public void setAccMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccMode(n);
            return;
        }
        this.accmode = n;
        this.accmodeDirtyFlag = true;
    }

    public Integer getAccMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccMode();
        }
        return this.accmode;
    }

    public boolean isAccModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccModeDirty();
        }
        return this.accmodeDirtyFlag;
    }

    public void resetAccMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccMode();
            return;
        }
        this.accmodeDirtyFlag = false;
        this.accmode = null;
    }

    public void setAllSysFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllSysFlag(n);
            return;
        }
        this.allsysflag = n;
        this.allsysflagDirtyFlag = true;
    }

    public Integer getAllSysFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllSysFlag();
        }
        return this.allsysflag;
    }

    public boolean isAllSysFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllSysFlagDirty();
        }
        return this.allsysflagDirtyFlag;
    }

    public void resetAllSysFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllSysFlag();
            return;
        }
        this.allsysflagDirtyFlag = false;
        this.allsysflag = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDevUserObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevUserObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devuserobjtype = string;
        this.devuserobjtypeDirtyFlag = true;
    }

    public String getDevUserObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevUserObjType();
        }
        return this.devuserobjtype;
    }

    public boolean isDevUserObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevUserObjTypeDirty();
        }
        return this.devuserobjtypeDirtyFlag;
    }

    public void resetDevUserObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevUserObjType();
            return;
        }
        this.devuserobjtypeDirtyFlag = false;
        this.devuserobjtype = null;
    }

    public void setExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(timestamp);
            return;
        }
        this.expiredtime = timestamp;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstid = string;
        this.psdevslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstId();
        }
        return this.psdevslnsysdynainstid;
    }

    public boolean isPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstIdDirty();
        }
        return this.psdevslnsysdynainstidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstId();
            return;
        }
        this.psdevslnsysdynainstidDirtyFlag = false;
        this.psdevslnsysdynainstid = null;
    }

    public void setPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstname = string;
        this.psdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstName();
        }
        return this.psdevslnsysdynainstname;
    }

    public boolean isPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstNameDirty();
        }
        return this.psdevslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstName();
            return;
        }
        this.psdevslnsysdynainstnameDirtyFlag = false;
        this.psdevslnsysdynainstname = null;
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

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
    }

    public void setPSDevSlnUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnuserid = string;
        this.psdevslnuseridDirtyFlag = true;
    }

    public String getPSDevSlnUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUserId();
        }
        return this.psdevslnuserid;
    }

    public boolean isPSDevSlnUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnUserIdDirty();
        }
        return this.psdevslnuseridDirtyFlag;
    }

    public void resetPSDevSlnUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnUserId();
            return;
        }
        this.psdevslnuseridDirtyFlag = false;
        this.psdevslnuserid = null;
    }

    public void setPSDevSlnUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnusername = string;
        this.psdevslnusernameDirtyFlag = true;
    }

    public String getPSDevSlnUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUserName();
        }
        return this.psdevslnusername;
    }

    public boolean isPSDevSlnUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnUserNameDirty();
        }
        return this.psdevslnusernameDirtyFlag;
    }

    public void resetPSDevSlnUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnUserName();
            return;
        }
        this.psdevslnusernameDirtyFlag = false;
        this.psdevslnusername = null;
    }

    public void setPSDevUserObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjid = string;
        this.psdevuserobjidDirtyFlag = true;
    }

    public String getPSDevUserObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjId();
        }
        return this.psdevuserobjid;
    }

    public boolean isPSDevUserObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjIdDirty();
        }
        return this.psdevuserobjidDirtyFlag;
    }

    public void resetPSDevUserObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjId();
            return;
        }
        this.psdevuserobjidDirtyFlag = false;
        this.psdevuserobjid = null;
    }

    public void setPSDevUserObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjname = string;
        this.psdevuserobjnameDirtyFlag = true;
    }

    public String getPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjName();
        }
        return this.psdevuserobjname;
    }

    public boolean isPSDevUserObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjNameDirty();
        }
        return this.psdevuserobjnameDirtyFlag;
    }

    public void resetPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjName();
            return;
        }
        this.psdevuserobjnameDirtyFlag = false;
        this.psdevuserobjname = null;
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

    protected void onReset() {
        PSDevSlnUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnUserBase pSDevSlnUserBase) {
        pSDevSlnUserBase.resetAccMode();
        pSDevSlnUserBase.resetAllSysFlag();
        pSDevSlnUserBase.resetCreateDate();
        pSDevSlnUserBase.resetCreateMan();
        pSDevSlnUserBase.resetDefaultFlag();
        pSDevSlnUserBase.resetDevUserObjType();
        pSDevSlnUserBase.resetExpiredTime();
        pSDevSlnUserBase.resetMemo();
        pSDevSlnUserBase.resetPSDevSlnId();
        pSDevSlnUserBase.resetPSDevSlnName();
        pSDevSlnUserBase.resetPSDevSlnSysDynaInstId();
        pSDevSlnUserBase.resetPSDevSlnSysDynaInstName();
        pSDevSlnUserBase.resetPSDevSlnSysId();
        pSDevSlnUserBase.resetPSDevSlnSysName();
        pSDevSlnUserBase.resetPSDevSlnTemplId();
        pSDevSlnUserBase.resetPSDevSlnTemplName();
        pSDevSlnUserBase.resetPSDevSlnUserId();
        pSDevSlnUserBase.resetPSDevSlnUserName();
        pSDevSlnUserBase.resetPSDevUserObjId();
        pSDevSlnUserBase.resetPSDevUserObjName();
        pSDevSlnUserBase.resetUpdateDate();
        pSDevSlnUserBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccModeDirty()) {
            hashMap.put(FIELD_ACCMODE, this.getAccMode());
        }
        if (!bl || this.isAllSysFlagDirty()) {
            hashMap.put(FIELD_ALLSYSFLAG, this.getAllSysFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDevUserObjTypeDirty()) {
            hashMap.put(FIELD_DEVUSEROBJTYPE, this.getDevUserObjType());
        }
        if (!bl || this.isExpiredTimeDirty()) {
            hashMap.put(FIELD_EXPIREDTIME, this.getExpiredTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, this.getPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, this.getPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isPSDevSlnUserIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERID, this.getPSDevSlnUserId());
        }
        if (!bl || this.isPSDevSlnUserNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERNAME, this.getPSDevSlnUserName());
        }
        if (!bl || this.isPSDevUserObjIdDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJID, this.getPSDevUserObjId());
        }
        if (!bl || this.isPSDevUserObjNameDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJNAME, this.getPSDevUserObjName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevSlnUserBase.get(this, n);
    }

    private static Object get(PSDevSlnUserBase pSDevSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserBase.getAccMode();
            }
            case 1: {
                return pSDevSlnUserBase.getAllSysFlag();
            }
            case 2: {
                return pSDevSlnUserBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnUserBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnUserBase.getDefaultFlag();
            }
            case 5: {
                return pSDevSlnUserBase.getDevUserObjType();
            }
            case 6: {
                return pSDevSlnUserBase.getExpiredTime();
            }
            case 7: {
                return pSDevSlnUserBase.getMemo();
            }
            case 8: {
                return pSDevSlnUserBase.getPSDevSlnId();
            }
            case 9: {
                return pSDevSlnUserBase.getPSDevSlnName();
            }
            case 10: {
                return pSDevSlnUserBase.getPSDevSlnSysDynaInstId();
            }
            case 11: {
                return pSDevSlnUserBase.getPSDevSlnSysDynaInstName();
            }
            case 12: {
                return pSDevSlnUserBase.getPSDevSlnSysId();
            }
            case 13: {
                return pSDevSlnUserBase.getPSDevSlnSysName();
            }
            case 14: {
                return pSDevSlnUserBase.getPSDevSlnTemplId();
            }
            case 15: {
                return pSDevSlnUserBase.getPSDevSlnTemplName();
            }
            case 16: {
                return pSDevSlnUserBase.getPSDevSlnUserId();
            }
            case 17: {
                return pSDevSlnUserBase.getPSDevSlnUserName();
            }
            case 18: {
                return pSDevSlnUserBase.getPSDevUserObjId();
            }
            case 19: {
                return pSDevSlnUserBase.getPSDevUserObjName();
            }
            case 20: {
                return pSDevSlnUserBase.getUpdateDate();
            }
            case 21: {
                return pSDevSlnUserBase.getUpdateMan();
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
        PSDevSlnUserBase.set(this, n, object);
    }

    private static void set(PSDevSlnUserBase pSDevSlnUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnUserBase.setAccMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnUserBase.setAllSysFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnUserBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnUserBase.setDevUserObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnUserBase.setExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnUserBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnUserBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnUserBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnUserBase.setPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnUserBase.setPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnUserBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnUserBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnUserBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnUserBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnUserBase.setPSDevSlnUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnUserBase.setPSDevSlnUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnUserBase.setPSDevUserObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnUserBase.setPSDevUserObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnUserBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnUserBase pSDevSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserBase.getAccMode() == null;
            }
            case 1: {
                return pSDevSlnUserBase.getAllSysFlag() == null;
            }
            case 2: {
                return pSDevSlnUserBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnUserBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnUserBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSDevSlnUserBase.getDevUserObjType() == null;
            }
            case 6: {
                return pSDevSlnUserBase.getExpiredTime() == null;
            }
            case 7: {
                return pSDevSlnUserBase.getMemo() == null;
            }
            case 8: {
                return pSDevSlnUserBase.getPSDevSlnId() == null;
            }
            case 9: {
                return pSDevSlnUserBase.getPSDevSlnName() == null;
            }
            case 10: {
                return pSDevSlnUserBase.getPSDevSlnSysDynaInstId() == null;
            }
            case 11: {
                return pSDevSlnUserBase.getPSDevSlnSysDynaInstName() == null;
            }
            case 12: {
                return pSDevSlnUserBase.getPSDevSlnSysId() == null;
            }
            case 13: {
                return pSDevSlnUserBase.getPSDevSlnSysName() == null;
            }
            case 14: {
                return pSDevSlnUserBase.getPSDevSlnTemplId() == null;
            }
            case 15: {
                return pSDevSlnUserBase.getPSDevSlnTemplName() == null;
            }
            case 16: {
                return pSDevSlnUserBase.getPSDevSlnUserId() == null;
            }
            case 17: {
                return pSDevSlnUserBase.getPSDevSlnUserName() == null;
            }
            case 18: {
                return pSDevSlnUserBase.getPSDevUserObjId() == null;
            }
            case 19: {
                return pSDevSlnUserBase.getPSDevUserObjName() == null;
            }
            case 20: {
                return pSDevSlnUserBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDevSlnUserBase.getUpdateMan() == null;
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
        return PSDevSlnUserBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnUserBase pSDevSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserBase.isAccModeDirty();
            }
            case 1: {
                return pSDevSlnUserBase.isAllSysFlagDirty();
            }
            case 2: {
                return pSDevSlnUserBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnUserBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnUserBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSDevSlnUserBase.isDevUserObjTypeDirty();
            }
            case 6: {
                return pSDevSlnUserBase.isExpiredTimeDirty();
            }
            case 7: {
                return pSDevSlnUserBase.isMemoDirty();
            }
            case 8: {
                return pSDevSlnUserBase.isPSDevSlnIdDirty();
            }
            case 9: {
                return pSDevSlnUserBase.isPSDevSlnNameDirty();
            }
            case 10: {
                return pSDevSlnUserBase.isPSDevSlnSysDynaInstIdDirty();
            }
            case 11: {
                return pSDevSlnUserBase.isPSDevSlnSysDynaInstNameDirty();
            }
            case 12: {
                return pSDevSlnUserBase.isPSDevSlnSysIdDirty();
            }
            case 13: {
                return pSDevSlnUserBase.isPSDevSlnSysNameDirty();
            }
            case 14: {
                return pSDevSlnUserBase.isPSDevSlnTemplIdDirty();
            }
            case 15: {
                return pSDevSlnUserBase.isPSDevSlnTemplNameDirty();
            }
            case 16: {
                return pSDevSlnUserBase.isPSDevSlnUserIdDirty();
            }
            case 17: {
                return pSDevSlnUserBase.isPSDevSlnUserNameDirty();
            }
            case 18: {
                return pSDevSlnUserBase.isPSDevUserObjIdDirty();
            }
            case 19: {
                return pSDevSlnUserBase.isPSDevUserObjNameDirty();
            }
            case 20: {
                return pSDevSlnUserBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDevSlnUserBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnUserBase pSDevSlnUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnUserBase.getAccMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accmode", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getAccMode()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getAllSysFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allsysflag", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getAllSysFlag()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getDevUserObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devuserobjtype", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getDevUserObjType()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredtime", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getExpiredTime()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstname", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnuserid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnUserId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnusername", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevSlnUserName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevUserObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjid", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevUserObjId()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getPSDevUserObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjname", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getPSDevUserObjName()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnUserBase.getJSONValue((Object)pSDevSlnUserBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnUserBase pSDevSlnUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnUserBase.getAccMode() != null) {
            object = pSDevSlnUserBase.getAccMode();
            xmlNode.setAttribute(FIELD_ACCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getAllSysFlag() != null) {
            object = pSDevSlnUserBase.getAllSysFlag();
            xmlNode.setAttribute(FIELD_ALLSYSFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getCreateDate() != null) {
            object = pSDevSlnUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getCreateMan() != null) {
            object = pSDevSlnUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getDefaultFlag() != null) {
            object = pSDevSlnUserBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getDevUserObjType() != null) {
            object = pSDevSlnUserBase.getDevUserObjType();
            xmlNode.setAttribute(FIELD_DEVUSEROBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getExpiredTime() != null) {
            object = pSDevSlnUserBase.getExpiredTime();
            xmlNode.setAttribute(FIELD_EXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getMemo() != null) {
            object = pSDevSlnUserBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnId() != null) {
            object = pSDevSlnUserBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnName() != null) {
            object = pSDevSlnUserBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnUserBase.getPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnUserBase.getPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnUserBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnUserBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnUserBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnUserBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnUserId() != null) {
            object = pSDevSlnUserBase.getPSDevSlnUserId();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevSlnUserName() != null) {
            object = pSDevSlnUserBase.getPSDevSlnUserName();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevUserObjId() != null) {
            object = pSDevSlnUserBase.getPSDevUserObjId();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getPSDevUserObjName() != null) {
            object = pSDevSlnUserBase.getPSDevUserObjName();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserBase.getUpdateDate() != null) {
            object = pSDevSlnUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserBase.getUpdateMan() != null) {
            object = pSDevSlnUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnUserBase pSDevSlnUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnUserBase.isAccModeDirty() && (bl || pSDevSlnUserBase.getAccMode() != null)) {
            iDataObject.set(FIELD_ACCMODE, (Object)pSDevSlnUserBase.getAccMode());
        }
        if (pSDevSlnUserBase.isAllSysFlagDirty() && (bl || pSDevSlnUserBase.getAllSysFlag() != null)) {
            iDataObject.set(FIELD_ALLSYSFLAG, (Object)pSDevSlnUserBase.getAllSysFlag());
        }
        if (pSDevSlnUserBase.isCreateDateDirty() && (bl || pSDevSlnUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnUserBase.getCreateDate());
        }
        if (pSDevSlnUserBase.isCreateManDirty() && (bl || pSDevSlnUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnUserBase.getCreateMan());
        }
        if (pSDevSlnUserBase.isDefaultFlagDirty() && (bl || pSDevSlnUserBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDevSlnUserBase.getDefaultFlag());
        }
        if (pSDevSlnUserBase.isDevUserObjTypeDirty() && (bl || pSDevSlnUserBase.getDevUserObjType() != null)) {
            iDataObject.set(FIELD_DEVUSEROBJTYPE, (Object)pSDevSlnUserBase.getDevUserObjType());
        }
        if (pSDevSlnUserBase.isExpiredTimeDirty() && (bl || pSDevSlnUserBase.getExpiredTime() != null)) {
            iDataObject.set(FIELD_EXPIREDTIME, (Object)pSDevSlnUserBase.getExpiredTime());
        }
        if (pSDevSlnUserBase.isMemoDirty() && (bl || pSDevSlnUserBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnUserBase.getMemo());
        }
        if (pSDevSlnUserBase.isPSDevSlnIdDirty() && (bl || pSDevSlnUserBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnUserBase.getPSDevSlnId());
        }
        if (pSDevSlnUserBase.isPSDevSlnNameDirty() && (bl || pSDevSlnUserBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnUserBase.getPSDevSlnName());
        }
        if (pSDevSlnUserBase.isPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnUserBase.getPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnUserBase.isPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnUserBase.getPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnUserBase.getPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnUserBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnUserBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnUserBase.getPSDevSlnSysId());
        }
        if (pSDevSlnUserBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnUserBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnUserBase.getPSDevSlnSysName());
        }
        if (pSDevSlnUserBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnUserBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnUserBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnUserBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnUserBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnUserBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnUserBase.isPSDevSlnUserIdDirty() && (bl || pSDevSlnUserBase.getPSDevSlnUserId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERID, (Object)pSDevSlnUserBase.getPSDevSlnUserId());
        }
        if (pSDevSlnUserBase.isPSDevSlnUserNameDirty() && (bl || pSDevSlnUserBase.getPSDevSlnUserName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERNAME, (Object)pSDevSlnUserBase.getPSDevSlnUserName());
        }
        if (pSDevSlnUserBase.isPSDevUserObjIdDirty() && (bl || pSDevSlnUserBase.getPSDevUserObjId() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJID, (Object)pSDevSlnUserBase.getPSDevUserObjId());
        }
        if (pSDevSlnUserBase.isPSDevUserObjNameDirty() && (bl || pSDevSlnUserBase.getPSDevUserObjName() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJNAME, (Object)pSDevSlnUserBase.getPSDevUserObjName());
        }
        if (pSDevSlnUserBase.isUpdateDateDirty() && (bl || pSDevSlnUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnUserBase.getUpdateDate());
        }
        if (pSDevSlnUserBase.isUpdateManDirty() && (bl || pSDevSlnUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnUserBase.getUpdateMan());
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
        return PSDevSlnUserBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnUserBase pSDevSlnUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnUserBase.resetAccMode();
                return true;
            }
            case 1: {
                pSDevSlnUserBase.resetAllSysFlag();
                return true;
            }
            case 2: {
                pSDevSlnUserBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnUserBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnUserBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSDevSlnUserBase.resetDevUserObjType();
                return true;
            }
            case 6: {
                pSDevSlnUserBase.resetExpiredTime();
                return true;
            }
            case 7: {
                pSDevSlnUserBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevSlnUserBase.resetPSDevSlnId();
                return true;
            }
            case 9: {
                pSDevSlnUserBase.resetPSDevSlnName();
                return true;
            }
            case 10: {
                pSDevSlnUserBase.resetPSDevSlnSysDynaInstId();
                return true;
            }
            case 11: {
                pSDevSlnUserBase.resetPSDevSlnSysDynaInstName();
                return true;
            }
            case 12: {
                pSDevSlnUserBase.resetPSDevSlnSysId();
                return true;
            }
            case 13: {
                pSDevSlnUserBase.resetPSDevSlnSysName();
                return true;
            }
            case 14: {
                pSDevSlnUserBase.resetPSDevSlnTemplId();
                return true;
            }
            case 15: {
                pSDevSlnUserBase.resetPSDevSlnTemplName();
                return true;
            }
            case 16: {
                pSDevSlnUserBase.resetPSDevSlnUserId();
                return true;
            }
            case 17: {
                pSDevSlnUserBase.resetPSDevSlnUserName();
                return true;
            }
            case 18: {
                pSDevSlnUserBase.resetPSDevUserObjId();
                return true;
            }
            case 19: {
                pSDevSlnUserBase.resetPSDevUserObjName();
                return true;
            }
            case 20: {
                pSDevSlnUserBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDevSlnUserBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getPSDevSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInst();
        }
        if (this.getPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysDynaInstLock;
        synchronized (n) {
            if (this.psdevslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysDynaInstId(), (Object)this.psdevslnsysdynainst.getPSDevSlnSysDynaInstId()) != 0L) {
                this.psdevslnsysdynainst = null;
            }
            if (this.psdevslnsysdynainst == null) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.getPSDevSlnSysDynaInstId());
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDynaInstService.autoGet((IEntity)pSDevSlnSysDynaInst);
                this.psdevslnsysdynainst = pSDevSlnSysDynaInst;
            }
            return this.psdevslnsysdynainst;
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
    public PSDevSlnTempl getPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempl();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnTemplLock;
        synchronized (n) {
            if (this.psdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnTemplId(), (Object)this.psdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.psdevslntempl = null;
            }
            if (this.psdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet((IEntity)pSDevSlnTempl);
                this.psdevslntempl = pSDevSlnTempl;
            }
            return this.psdevslntempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUserObj getPSDevUserObj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObj();
        }
        if (this.getPSDevUserObjId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserObjLock;
        synchronized (n) {
            if (this.psdevuserobj != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserObjId(), (Object)this.psdevuserobj.getPSDevUserObjectId()) != 0L) {
                this.psdevuserobj = null;
            }
            if (this.psdevuserobj == null) {
                PSDevUserObj pSDevUserObj = new PSDevUserObj();
                pSDevUserObj.setPSDevUserObjectId(this.getPSDevUserObjId());
                PSDevUserObjService pSDevUserObjService = (PSDevUserObjService)ServiceGlobal.getService(PSDevUserObjService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserObjService.autoGet((IEntity)pSDevUserObj);
                this.psdevuserobj = pSDevUserObj;
            }
            return this.psdevuserobj;
        }
    }

    private PSDevSlnUserBase getProxyEntity() {
        return this.proxyPSDevSlnUserBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnUserBase) {
            this.proxyPSDevSlnUserBase = (PSDevSlnUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCMODE, 0);
        fieldIndexMap.put(FIELD_ALLSYSFLAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_DEVUSEROBJTYPE, 5);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJID, 18);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

