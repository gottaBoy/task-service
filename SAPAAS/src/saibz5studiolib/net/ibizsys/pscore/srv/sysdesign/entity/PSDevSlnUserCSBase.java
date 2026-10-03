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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCodeServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnUserCSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnUserCSBase.class);
    public static final String FIELD_ALLUSERFLAG = "ALLUSERFLAG";
    public static final String FIELD_CODETARGET = "CODETARGET";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSPARAM = "CSPARAM";
    public static final String FIELD_CSPARAM2 = "CSPARAM2";
    public static final String FIELD_CSPARAM3 = "CSPARAM3";
    public static final String FIELD_CSPARAM4 = "CSPARAM4";
    public static final String FIELD_CSPARAMS = "CSPARAMS";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNCODESERVERID = "PSDEVSLNCODESERVERID";
    public static final String FIELD_PSDEVSLNCODESERVERNAME = "PSDEVSLNCODESERVERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSDEVSLNUSERCSID = "PSDEVSLNUSERCSID";
    public static final String FIELD_PSDEVSLNUSERCSNAME = "PSDEVSLNUSERCSNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ALLUSERFLAG = 0;
    private static final int INDEX_CODETARGET = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CSPARAM = 4;
    private static final int INDEX_CSPARAM2 = 5;
    private static final int INDEX_CSPARAM3 = 6;
    private static final int INDEX_CSPARAM4 = 7;
    private static final int INDEX_CSPARAMS = 8;
    private static final int INDEX_EXPRIEDTIME = 9;
    private static final int INDEX_HOSTPASSWD = 10;
    private static final int INDEX_HOSTUSERNAME = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PSDEVSLNCODESERVERID = 13;
    private static final int INDEX_PSDEVSLNCODESERVERNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNNAME = 16;
    private static final int INDEX_PSDEVSLNSYSID = 17;
    private static final int INDEX_PSDEVSLNSYSNAME = 18;
    private static final int INDEX_PSDEVSLNTEMPLID = 19;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 20;
    private static final int INDEX_PSDEVSLNUSERCSID = 21;
    private static final int INDEX_PSDEVSLNUSERCSNAME = 22;
    private static final int INDEX_PSDEVUSERID = 23;
    private static final int INDEX_PSDEVUSERNAME = 24;
    private static final int INDEX_READONLYMODE = 25;
    private static final int INDEX_RESREADYTIME = 26;
    private static final int INDEX_RESSTATE = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnUserCSBase proxyPSDevSlnUserCSBase = null;
    private boolean alluserflagDirtyFlag = false;
    private boolean codetargetDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csparamDirtyFlag = false;
    private boolean csparam2DirtyFlag = false;
    private boolean csparam3DirtyFlag = false;
    private boolean csparam4DirtyFlag = false;
    private boolean csparamsDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslncodeserveridDirtyFlag = false;
    private boolean psdevslncodeservernameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean psdevslnusercsidDirtyFlag = false;
    private boolean psdevslnusercsnameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="alluserflag")
    private Integer alluserflag;
    @Column(name="codetarget")
    private String codetarget;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="csparam")
    private String csparam;
    @Column(name="csparam2")
    private String csparam2;
    @Column(name="csparam3")
    private Integer csparam3;
    @Column(name="csparam4")
    private Integer csparam4;
    @Column(name="csparams")
    private String csparams;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslncodeserverid")
    private String psdevslncodeserverid;
    @Column(name="psdevslncodeservername")
    private String psdevslncodeservername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="psdevslnusercsid")
    private String psdevslnusercsid;
    @Column(name="psdevslnusercsname")
    private String psdevslnusercsname;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnCodeServerLock = new Integer(1);
    private PSDevSlnCodeServer psdevslncodeserver = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

    public void setAllUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllUserFlag(n);
            return;
        }
        this.alluserflag = n;
        this.alluserflagDirtyFlag = true;
    }

    public Integer getAllUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllUserFlag();
        }
        return this.alluserflag;
    }

    public boolean isAllUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllUserFlagDirty();
        }
        return this.alluserflagDirtyFlag;
    }

    public void resetAllUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllUserFlag();
            return;
        }
        this.alluserflagDirtyFlag = false;
        this.alluserflag = null;
    }

    public void setCodeTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codetarget = string;
        this.codetargetDirtyFlag = true;
    }

    public String getCodeTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeTarget();
        }
        return this.codetarget;
    }

    public boolean isCodeTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeTargetDirty();
        }
        return this.codetargetDirtyFlag;
    }

    public void resetCodeTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeTarget();
            return;
        }
        this.codetargetDirtyFlag = false;
        this.codetarget = null;
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

    public void setCSParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csparam = string;
        this.csparamDirtyFlag = true;
    }

    public String getCSParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam();
        }
        return this.csparam;
    }

    public boolean isCSParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParamDirty();
        }
        return this.csparamDirtyFlag;
    }

    public void resetCSParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam();
            return;
        }
        this.csparamDirtyFlag = false;
        this.csparam = null;
    }

    public void setCSParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csparam2 = string;
        this.csparam2DirtyFlag = true;
    }

    public String getCSParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam2();
        }
        return this.csparam2;
    }

    public boolean isCSParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam2Dirty();
        }
        return this.csparam2DirtyFlag;
    }

    public void resetCSParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam2();
            return;
        }
        this.csparam2DirtyFlag = false;
        this.csparam2 = null;
    }

    public void setCSParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam3(n);
            return;
        }
        this.csparam3 = n;
        this.csparam3DirtyFlag = true;
    }

    public Integer getCSParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam3();
        }
        return this.csparam3;
    }

    public boolean isCSParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam3Dirty();
        }
        return this.csparam3DirtyFlag;
    }

    public void resetCSParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam3();
            return;
        }
        this.csparam3DirtyFlag = false;
        this.csparam3 = null;
    }

    public void setCSParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParam4(n);
            return;
        }
        this.csparam4 = n;
        this.csparam4DirtyFlag = true;
    }

    public Integer getCSParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParam4();
        }
        return this.csparam4;
    }

    public boolean isCSParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParam4Dirty();
        }
        return this.csparam4DirtyFlag;
    }

    public void resetCSParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParam4();
            return;
        }
        this.csparam4DirtyFlag = false;
        this.csparam4 = null;
    }

    public void setCSParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csparams = string;
        this.csparamsDirtyFlag = true;
    }

    public String getCSParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSParams();
        }
        return this.csparams;
    }

    public boolean isCSParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSParamsDirty();
        }
        return this.csparamsDirtyFlag;
    }

    public void resetCSParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSParams();
            return;
        }
        this.csparamsDirtyFlag = false;
        this.csparams = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setHostPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostpasswd = string;
        this.hostpasswdDirtyFlag = true;
    }

    public String getHostPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPasswd();
        }
        return this.hostpasswd;
    }

    public boolean isHostPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPasswdDirty();
        }
        return this.hostpasswdDirtyFlag;
    }

    public void resetHostPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPasswd();
            return;
        }
        this.hostpasswdDirtyFlag = false;
        this.hostpasswd = null;
    }

    public void setHostUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostusername = string;
        this.hostusernameDirtyFlag = true;
    }

    public String getHostUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostUserName();
        }
        return this.hostusername;
    }

    public boolean isHostUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostUserNameDirty();
        }
        return this.hostusernameDirtyFlag;
    }

    public void resetHostUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostUserName();
            return;
        }
        this.hostusernameDirtyFlag = false;
        this.hostusername = null;
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

    public void setPSDevSlnCodeServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCodeServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncodeserverid = string;
        this.psdevslncodeserveridDirtyFlag = true;
    }

    public String getPSDevSlnCodeServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCodeServerId();
        }
        return this.psdevslncodeserverid;
    }

    public boolean isPSDevSlnCodeServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCodeServerIdDirty();
        }
        return this.psdevslncodeserveridDirtyFlag;
    }

    public void resetPSDevSlnCodeServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCodeServerId();
            return;
        }
        this.psdevslncodeserveridDirtyFlag = false;
        this.psdevslncodeserverid = null;
    }

    public void setPSDevSlnCodeServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCodeServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncodeservername = string;
        this.psdevslncodeservernameDirtyFlag = true;
    }

    public String getPSDevSlnCodeServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCodeServerName();
        }
        return this.psdevslncodeservername;
    }

    public boolean isPSDevSlnCodeServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCodeServerNameDirty();
        }
        return this.psdevslncodeservernameDirtyFlag;
    }

    public void resetPSDevSlnCodeServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCodeServerName();
            return;
        }
        this.psdevslncodeservernameDirtyFlag = false;
        this.psdevslncodeservername = null;
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

    public void setPSDevSlnUserCSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnUserCSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnusercsid = string;
        this.psdevslnusercsidDirtyFlag = true;
    }

    public String getPSDevSlnUserCSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUserCSId();
        }
        return this.psdevslnusercsid;
    }

    public boolean isPSDevSlnUserCSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnUserCSIdDirty();
        }
        return this.psdevslnusercsidDirtyFlag;
    }

    public void resetPSDevSlnUserCSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnUserCSId();
            return;
        }
        this.psdevslnusercsidDirtyFlag = false;
        this.psdevslnusercsid = null;
    }

    public void setPSDevSlnUserCSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnUserCSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnusercsname = string;
        this.psdevslnusercsnameDirtyFlag = true;
    }

    public String getPSDevSlnUserCSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUserCSName();
        }
        return this.psdevslnusercsname;
    }

    public boolean isPSDevSlnUserCSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnUserCSNameDirty();
        }
        return this.psdevslnusercsnameDirtyFlag;
    }

    public void resetPSDevSlnUserCSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnUserCSName();
            return;
        }
        this.psdevslnusercsnameDirtyFlag = false;
        this.psdevslnusercsname = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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
        PSDevSlnUserCSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnUserCSBase pSDevSlnUserCSBase) {
        pSDevSlnUserCSBase.resetAllUserFlag();
        pSDevSlnUserCSBase.resetCodeTarget();
        pSDevSlnUserCSBase.resetCreateDate();
        pSDevSlnUserCSBase.resetCreateMan();
        pSDevSlnUserCSBase.resetCSParam();
        pSDevSlnUserCSBase.resetCSParam2();
        pSDevSlnUserCSBase.resetCSParam3();
        pSDevSlnUserCSBase.resetCSParam4();
        pSDevSlnUserCSBase.resetCSParams();
        pSDevSlnUserCSBase.resetExpriedTime();
        pSDevSlnUserCSBase.resetHostPasswd();
        pSDevSlnUserCSBase.resetHostUserName();
        pSDevSlnUserCSBase.resetMemo();
        pSDevSlnUserCSBase.resetPSDevSlnCodeServerId();
        pSDevSlnUserCSBase.resetPSDevSlnCodeServerName();
        pSDevSlnUserCSBase.resetPSDevSlnId();
        pSDevSlnUserCSBase.resetPSDevSlnName();
        pSDevSlnUserCSBase.resetPSDevSlnSysId();
        pSDevSlnUserCSBase.resetPSDevSlnSysName();
        pSDevSlnUserCSBase.resetPSDevSlnTemplId();
        pSDevSlnUserCSBase.resetPSDevSlnTemplName();
        pSDevSlnUserCSBase.resetPSDevSlnUserCSId();
        pSDevSlnUserCSBase.resetPSDevSlnUserCSName();
        pSDevSlnUserCSBase.resetPSDevUserId();
        pSDevSlnUserCSBase.resetPSDevUserName();
        pSDevSlnUserCSBase.resetReadOnlyMode();
        pSDevSlnUserCSBase.resetResReadyTime();
        pSDevSlnUserCSBase.resetResState();
        pSDevSlnUserCSBase.resetUpdateDate();
        pSDevSlnUserCSBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllUserFlagDirty()) {
            hashMap.put(FIELD_ALLUSERFLAG, this.getAllUserFlag());
        }
        if (!bl || this.isCodeTargetDirty()) {
            hashMap.put(FIELD_CODETARGET, this.getCodeTarget());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSParamDirty()) {
            hashMap.put(FIELD_CSPARAM, this.getCSParam());
        }
        if (!bl || this.isCSParam2Dirty()) {
            hashMap.put(FIELD_CSPARAM2, this.getCSParam2());
        }
        if (!bl || this.isCSParam3Dirty()) {
            hashMap.put(FIELD_CSPARAM3, this.getCSParam3());
        }
        if (!bl || this.isCSParam4Dirty()) {
            hashMap.put(FIELD_CSPARAM4, this.getCSParam4());
        }
        if (!bl || this.isCSParamsDirty()) {
            hashMap.put(FIELD_CSPARAMS, this.getCSParams());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHostPasswdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPasswd());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnCodeServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNCODESERVERID, this.getPSDevSlnCodeServerId());
        }
        if (!bl || this.isPSDevSlnCodeServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNCODESERVERNAME, this.getPSDevSlnCodeServerName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
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
        if (!bl || this.isPSDevSlnUserCSIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERCSID, this.getPSDevSlnUserCSId());
        }
        if (!bl || this.isPSDevSlnUserCSNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERCSNAME, this.getPSDevSlnUserCSName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        return PSDevSlnUserCSBase.get(this, n);
    }

    private static Object get(PSDevSlnUserCSBase pSDevSlnUserCSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserCSBase.getAllUserFlag();
            }
            case 1: {
                return pSDevSlnUserCSBase.getCodeTarget();
            }
            case 2: {
                return pSDevSlnUserCSBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnUserCSBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnUserCSBase.getCSParam();
            }
            case 5: {
                return pSDevSlnUserCSBase.getCSParam2();
            }
            case 6: {
                return pSDevSlnUserCSBase.getCSParam3();
            }
            case 7: {
                return pSDevSlnUserCSBase.getCSParam4();
            }
            case 8: {
                return pSDevSlnUserCSBase.getCSParams();
            }
            case 9: {
                return pSDevSlnUserCSBase.getExpriedTime();
            }
            case 10: {
                return pSDevSlnUserCSBase.getHostPasswd();
            }
            case 11: {
                return pSDevSlnUserCSBase.getHostUserName();
            }
            case 12: {
                return pSDevSlnUserCSBase.getMemo();
            }
            case 13: {
                return pSDevSlnUserCSBase.getPSDevSlnCodeServerId();
            }
            case 14: {
                return pSDevSlnUserCSBase.getPSDevSlnCodeServerName();
            }
            case 15: {
                return pSDevSlnUserCSBase.getPSDevSlnId();
            }
            case 16: {
                return pSDevSlnUserCSBase.getPSDevSlnName();
            }
            case 17: {
                return pSDevSlnUserCSBase.getPSDevSlnSysId();
            }
            case 18: {
                return pSDevSlnUserCSBase.getPSDevSlnSysName();
            }
            case 19: {
                return pSDevSlnUserCSBase.getPSDevSlnTemplId();
            }
            case 20: {
                return pSDevSlnUserCSBase.getPSDevSlnTemplName();
            }
            case 21: {
                return pSDevSlnUserCSBase.getPSDevSlnUserCSId();
            }
            case 22: {
                return pSDevSlnUserCSBase.getPSDevSlnUserCSName();
            }
            case 23: {
                return pSDevSlnUserCSBase.getPSDevUserId();
            }
            case 24: {
                return pSDevSlnUserCSBase.getPSDevUserName();
            }
            case 25: {
                return pSDevSlnUserCSBase.getReadOnlyMode();
            }
            case 26: {
                return pSDevSlnUserCSBase.getResReadyTime();
            }
            case 27: {
                return pSDevSlnUserCSBase.getResState();
            }
            case 28: {
                return pSDevSlnUserCSBase.getUpdateDate();
            }
            case 29: {
                return pSDevSlnUserCSBase.getUpdateMan();
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
        PSDevSlnUserCSBase.set(this, n, object);
    }

    private static void set(PSDevSlnUserCSBase pSDevSlnUserCSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnUserCSBase.setAllUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnUserCSBase.setCodeTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnUserCSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnUserCSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnUserCSBase.setCSParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnUserCSBase.setCSParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnUserCSBase.setCSParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnUserCSBase.setCSParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnUserCSBase.setCSParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnUserCSBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnUserCSBase.setHostPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnUserCSBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnUserCSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnUserCSBase.setPSDevSlnCodeServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnUserCSBase.setPSDevSlnCodeServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnUserCSBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnUserCSBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnUserCSBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnUserCSBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnUserCSBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnUserCSBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnUserCSBase.setPSDevSlnUserCSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnUserCSBase.setPSDevSlnUserCSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnUserCSBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnUserCSBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnUserCSBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnUserCSBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnUserCSBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnUserCSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnUserCSBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnUserCSBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnUserCSBase pSDevSlnUserCSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserCSBase.getAllUserFlag() == null;
            }
            case 1: {
                return pSDevSlnUserCSBase.getCodeTarget() == null;
            }
            case 2: {
                return pSDevSlnUserCSBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnUserCSBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnUserCSBase.getCSParam() == null;
            }
            case 5: {
                return pSDevSlnUserCSBase.getCSParam2() == null;
            }
            case 6: {
                return pSDevSlnUserCSBase.getCSParam3() == null;
            }
            case 7: {
                return pSDevSlnUserCSBase.getCSParam4() == null;
            }
            case 8: {
                return pSDevSlnUserCSBase.getCSParams() == null;
            }
            case 9: {
                return pSDevSlnUserCSBase.getExpriedTime() == null;
            }
            case 10: {
                return pSDevSlnUserCSBase.getHostPasswd() == null;
            }
            case 11: {
                return pSDevSlnUserCSBase.getHostUserName() == null;
            }
            case 12: {
                return pSDevSlnUserCSBase.getMemo() == null;
            }
            case 13: {
                return pSDevSlnUserCSBase.getPSDevSlnCodeServerId() == null;
            }
            case 14: {
                return pSDevSlnUserCSBase.getPSDevSlnCodeServerName() == null;
            }
            case 15: {
                return pSDevSlnUserCSBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDevSlnUserCSBase.getPSDevSlnName() == null;
            }
            case 17: {
                return pSDevSlnUserCSBase.getPSDevSlnSysId() == null;
            }
            case 18: {
                return pSDevSlnUserCSBase.getPSDevSlnSysName() == null;
            }
            case 19: {
                return pSDevSlnUserCSBase.getPSDevSlnTemplId() == null;
            }
            case 20: {
                return pSDevSlnUserCSBase.getPSDevSlnTemplName() == null;
            }
            case 21: {
                return pSDevSlnUserCSBase.getPSDevSlnUserCSId() == null;
            }
            case 22: {
                return pSDevSlnUserCSBase.getPSDevSlnUserCSName() == null;
            }
            case 23: {
                return pSDevSlnUserCSBase.getPSDevUserId() == null;
            }
            case 24: {
                return pSDevSlnUserCSBase.getPSDevUserName() == null;
            }
            case 25: {
                return pSDevSlnUserCSBase.getReadOnlyMode() == null;
            }
            case 26: {
                return pSDevSlnUserCSBase.getResReadyTime() == null;
            }
            case 27: {
                return pSDevSlnUserCSBase.getResState() == null;
            }
            case 28: {
                return pSDevSlnUserCSBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDevSlnUserCSBase.getUpdateMan() == null;
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
        return PSDevSlnUserCSBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnUserCSBase pSDevSlnUserCSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnUserCSBase.isAllUserFlagDirty();
            }
            case 1: {
                return pSDevSlnUserCSBase.isCodeTargetDirty();
            }
            case 2: {
                return pSDevSlnUserCSBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnUserCSBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnUserCSBase.isCSParamDirty();
            }
            case 5: {
                return pSDevSlnUserCSBase.isCSParam2Dirty();
            }
            case 6: {
                return pSDevSlnUserCSBase.isCSParam3Dirty();
            }
            case 7: {
                return pSDevSlnUserCSBase.isCSParam4Dirty();
            }
            case 8: {
                return pSDevSlnUserCSBase.isCSParamsDirty();
            }
            case 9: {
                return pSDevSlnUserCSBase.isExpriedTimeDirty();
            }
            case 10: {
                return pSDevSlnUserCSBase.isHostPasswdDirty();
            }
            case 11: {
                return pSDevSlnUserCSBase.isHostUserNameDirty();
            }
            case 12: {
                return pSDevSlnUserCSBase.isMemoDirty();
            }
            case 13: {
                return pSDevSlnUserCSBase.isPSDevSlnCodeServerIdDirty();
            }
            case 14: {
                return pSDevSlnUserCSBase.isPSDevSlnCodeServerNameDirty();
            }
            case 15: {
                return pSDevSlnUserCSBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDevSlnUserCSBase.isPSDevSlnNameDirty();
            }
            case 17: {
                return pSDevSlnUserCSBase.isPSDevSlnSysIdDirty();
            }
            case 18: {
                return pSDevSlnUserCSBase.isPSDevSlnSysNameDirty();
            }
            case 19: {
                return pSDevSlnUserCSBase.isPSDevSlnTemplIdDirty();
            }
            case 20: {
                return pSDevSlnUserCSBase.isPSDevSlnTemplNameDirty();
            }
            case 21: {
                return pSDevSlnUserCSBase.isPSDevSlnUserCSIdDirty();
            }
            case 22: {
                return pSDevSlnUserCSBase.isPSDevSlnUserCSNameDirty();
            }
            case 23: {
                return pSDevSlnUserCSBase.isPSDevUserIdDirty();
            }
            case 24: {
                return pSDevSlnUserCSBase.isPSDevUserNameDirty();
            }
            case 25: {
                return pSDevSlnUserCSBase.isReadOnlyModeDirty();
            }
            case 26: {
                return pSDevSlnUserCSBase.isResReadyTimeDirty();
            }
            case 27: {
                return pSDevSlnUserCSBase.isResStateDirty();
            }
            case 28: {
                return pSDevSlnUserCSBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDevSlnUserCSBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnUserCSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnUserCSBase pSDevSlnUserCSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnUserCSBase.getAllUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alluserflag", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getAllUserFlag()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCodeTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetarget", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCodeTarget()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCSParam()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam2", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCSParam2()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam3", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCSParam3()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam4", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCSParam4()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getCSParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparams", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getCSParams()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getHostPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getHostPasswd()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncodeserverid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnCodeServerId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncodeservername", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnCodeServerName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnusercsid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnUserCSId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnusercsname", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevSlnUserCSName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getResState()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnUserCSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnUserCSBase.getJSONValue((Object)pSDevSlnUserCSBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnUserCSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnUserCSBase pSDevSlnUserCSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnUserCSBase.getAllUserFlag() != null) {
            object = pSDevSlnUserCSBase.getAllUserFlag();
            xmlNode.setAttribute(FIELD_ALLUSERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getCodeTarget() != null) {
            object = pSDevSlnUserCSBase.getCodeTarget();
            xmlNode.setAttribute(FIELD_CODETARGET, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getCreateDate() != null) {
            object = pSDevSlnUserCSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getCreateMan() != null) {
            object = pSDevSlnUserCSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam() != null) {
            object = pSDevSlnUserCSBase.getCSParam();
            xmlNode.setAttribute(FIELD_CSPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam2() != null) {
            object = pSDevSlnUserCSBase.getCSParam2();
            xmlNode.setAttribute(FIELD_CSPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getCSParam3() != null) {
            object = pSDevSlnUserCSBase.getCSParam3();
            xmlNode.setAttribute(FIELD_CSPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getCSParam4() != null) {
            object = pSDevSlnUserCSBase.getCSParam4();
            xmlNode.setAttribute(FIELD_CSPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getCSParams() != null) {
            object = pSDevSlnUserCSBase.getCSParams();
            xmlNode.setAttribute(FIELD_CSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getExpriedTime() != null) {
            object = pSDevSlnUserCSBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getHostPasswd() != null) {
            object = pSDevSlnUserCSBase.getHostPasswd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getHostUserName() != null) {
            object = pSDevSlnUserCSBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getMemo() != null) {
            object = pSDevSlnUserCSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerId() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnCodeServerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNCODESERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerName() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnCodeServerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNCODESERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnId() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnName() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSId() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnUserCSId();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERCSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSName() != null) {
            object = pSDevSlnUserCSBase.getPSDevSlnUserCSName();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERCSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevUserId() != null) {
            object = pSDevSlnUserCSBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getPSDevUserName() != null) {
            object = pSDevSlnUserCSBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnUserCSBase.getReadOnlyMode() != null) {
            object = pSDevSlnUserCSBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getResReadyTime() != null) {
            object = pSDevSlnUserCSBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getResState() != null) {
            object = pSDevSlnUserCSBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getUpdateDate() != null) {
            object = pSDevSlnUserCSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnUserCSBase.getUpdateMan() != null) {
            object = pSDevSlnUserCSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnUserCSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnUserCSBase pSDevSlnUserCSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnUserCSBase.isAllUserFlagDirty() && (bl || pSDevSlnUserCSBase.getAllUserFlag() != null)) {
            iDataObject.set(FIELD_ALLUSERFLAG, (Object)pSDevSlnUserCSBase.getAllUserFlag());
        }
        if (pSDevSlnUserCSBase.isCodeTargetDirty() && (bl || pSDevSlnUserCSBase.getCodeTarget() != null)) {
            iDataObject.set(FIELD_CODETARGET, (Object)pSDevSlnUserCSBase.getCodeTarget());
        }
        if (pSDevSlnUserCSBase.isCreateDateDirty() && (bl || pSDevSlnUserCSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnUserCSBase.getCreateDate());
        }
        if (pSDevSlnUserCSBase.isCreateManDirty() && (bl || pSDevSlnUserCSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnUserCSBase.getCreateMan());
        }
        if (pSDevSlnUserCSBase.isCSParamDirty() && (bl || pSDevSlnUserCSBase.getCSParam() != null)) {
            iDataObject.set(FIELD_CSPARAM, (Object)pSDevSlnUserCSBase.getCSParam());
        }
        if (pSDevSlnUserCSBase.isCSParam2Dirty() && (bl || pSDevSlnUserCSBase.getCSParam2() != null)) {
            iDataObject.set(FIELD_CSPARAM2, (Object)pSDevSlnUserCSBase.getCSParam2());
        }
        if (pSDevSlnUserCSBase.isCSParam3Dirty() && (bl || pSDevSlnUserCSBase.getCSParam3() != null)) {
            iDataObject.set(FIELD_CSPARAM3, (Object)pSDevSlnUserCSBase.getCSParam3());
        }
        if (pSDevSlnUserCSBase.isCSParam4Dirty() && (bl || pSDevSlnUserCSBase.getCSParam4() != null)) {
            iDataObject.set(FIELD_CSPARAM4, (Object)pSDevSlnUserCSBase.getCSParam4());
        }
        if (pSDevSlnUserCSBase.isCSParamsDirty() && (bl || pSDevSlnUserCSBase.getCSParams() != null)) {
            iDataObject.set(FIELD_CSPARAMS, (Object)pSDevSlnUserCSBase.getCSParams());
        }
        if (pSDevSlnUserCSBase.isExpriedTimeDirty() && (bl || pSDevSlnUserCSBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnUserCSBase.getExpriedTime());
        }
        if (pSDevSlnUserCSBase.isHostPasswdDirty() && (bl || pSDevSlnUserCSBase.getHostPasswd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevSlnUserCSBase.getHostPasswd());
        }
        if (pSDevSlnUserCSBase.isHostUserNameDirty() && (bl || pSDevSlnUserCSBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevSlnUserCSBase.getHostUserName());
        }
        if (pSDevSlnUserCSBase.isMemoDirty() && (bl || pSDevSlnUserCSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnUserCSBase.getMemo());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnCodeServerIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCODESERVERID, (Object)pSDevSlnUserCSBase.getPSDevSlnCodeServerId());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnCodeServerNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnCodeServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCODESERVERNAME, (Object)pSDevSlnUserCSBase.getPSDevSlnCodeServerName());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnUserCSBase.getPSDevSlnId());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnUserCSBase.getPSDevSlnName());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnUserCSBase.getPSDevSlnSysId());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnUserCSBase.getPSDevSlnSysName());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnUserCSBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnUserCSBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnUserCSIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERCSID, (Object)pSDevSlnUserCSBase.getPSDevSlnUserCSId());
        }
        if (pSDevSlnUserCSBase.isPSDevSlnUserCSNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevSlnUserCSName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERCSNAME, (Object)pSDevSlnUserCSBase.getPSDevSlnUserCSName());
        }
        if (pSDevSlnUserCSBase.isPSDevUserIdDirty() && (bl || pSDevSlnUserCSBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevSlnUserCSBase.getPSDevUserId());
        }
        if (pSDevSlnUserCSBase.isPSDevUserNameDirty() && (bl || pSDevSlnUserCSBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDevSlnUserCSBase.getPSDevUserName());
        }
        if (pSDevSlnUserCSBase.isReadOnlyModeDirty() && (bl || pSDevSlnUserCSBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDevSlnUserCSBase.getReadOnlyMode());
        }
        if (pSDevSlnUserCSBase.isResReadyTimeDirty() && (bl || pSDevSlnUserCSBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevSlnUserCSBase.getResReadyTime());
        }
        if (pSDevSlnUserCSBase.isResStateDirty() && (bl || pSDevSlnUserCSBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevSlnUserCSBase.getResState());
        }
        if (pSDevSlnUserCSBase.isUpdateDateDirty() && (bl || pSDevSlnUserCSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnUserCSBase.getUpdateDate());
        }
        if (pSDevSlnUserCSBase.isUpdateManDirty() && (bl || pSDevSlnUserCSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnUserCSBase.getUpdateMan());
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
        return PSDevSlnUserCSBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnUserCSBase pSDevSlnUserCSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnUserCSBase.resetAllUserFlag();
                return true;
            }
            case 1: {
                pSDevSlnUserCSBase.resetCodeTarget();
                return true;
            }
            case 2: {
                pSDevSlnUserCSBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnUserCSBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnUserCSBase.resetCSParam();
                return true;
            }
            case 5: {
                pSDevSlnUserCSBase.resetCSParam2();
                return true;
            }
            case 6: {
                pSDevSlnUserCSBase.resetCSParam3();
                return true;
            }
            case 7: {
                pSDevSlnUserCSBase.resetCSParam4();
                return true;
            }
            case 8: {
                pSDevSlnUserCSBase.resetCSParams();
                return true;
            }
            case 9: {
                pSDevSlnUserCSBase.resetExpriedTime();
                return true;
            }
            case 10: {
                pSDevSlnUserCSBase.resetHostPasswd();
                return true;
            }
            case 11: {
                pSDevSlnUserCSBase.resetHostUserName();
                return true;
            }
            case 12: {
                pSDevSlnUserCSBase.resetMemo();
                return true;
            }
            case 13: {
                pSDevSlnUserCSBase.resetPSDevSlnCodeServerId();
                return true;
            }
            case 14: {
                pSDevSlnUserCSBase.resetPSDevSlnCodeServerName();
                return true;
            }
            case 15: {
                pSDevSlnUserCSBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDevSlnUserCSBase.resetPSDevSlnName();
                return true;
            }
            case 17: {
                pSDevSlnUserCSBase.resetPSDevSlnSysId();
                return true;
            }
            case 18: {
                pSDevSlnUserCSBase.resetPSDevSlnSysName();
                return true;
            }
            case 19: {
                pSDevSlnUserCSBase.resetPSDevSlnTemplId();
                return true;
            }
            case 20: {
                pSDevSlnUserCSBase.resetPSDevSlnTemplName();
                return true;
            }
            case 21: {
                pSDevSlnUserCSBase.resetPSDevSlnUserCSId();
                return true;
            }
            case 22: {
                pSDevSlnUserCSBase.resetPSDevSlnUserCSName();
                return true;
            }
            case 23: {
                pSDevSlnUserCSBase.resetPSDevUserId();
                return true;
            }
            case 24: {
                pSDevSlnUserCSBase.resetPSDevUserName();
                return true;
            }
            case 25: {
                pSDevSlnUserCSBase.resetReadOnlyMode();
                return true;
            }
            case 26: {
                pSDevSlnUserCSBase.resetResReadyTime();
                return true;
            }
            case 27: {
                pSDevSlnUserCSBase.resetResState();
                return true;
            }
            case 28: {
                pSDevSlnUserCSBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDevSlnUserCSBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnCodeServer getPSDevSlnCodeServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCodeServer();
        }
        if (this.getPSDevSlnCodeServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnCodeServerLock;
        synchronized (n) {
            if (this.psdevslncodeserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnCodeServerId(), (Object)this.psdevslncodeserver.getPSDevSlnCodeServerId()) != 0L) {
                this.psdevslncodeserver = null;
            }
            if (this.psdevslncodeserver == null) {
                PSDevSlnCodeServer pSDevSlnCodeServer = new PSDevSlnCodeServer();
                pSDevSlnCodeServer.setPSDevSlnCodeServerId(this.getPSDevSlnCodeServerId());
                PSDevSlnCodeServerService pSDevSlnCodeServerService = (PSDevSlnCodeServerService)ServiceGlobal.getService(PSDevSlnCodeServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnCodeServerService.autoGet(pSDevSlnCodeServer);
                this.psdevslncodeserver = pSDevSlnCodeServer;
            }
            return this.psdevslncodeserver;
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
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
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDevSlnUserCSBase getProxyEntity() {
        return this.proxyPSDevSlnUserCSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnUserCSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnUserCSBase) {
            this.proxyPSDevSlnUserCSBase = (PSDevSlnUserCSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLUSERFLAG, 0);
        fieldIndexMap.put(FIELD_CODETARGET, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CSPARAM, 4);
        fieldIndexMap.put(FIELD_CSPARAM2, 5);
        fieldIndexMap.put(FIELD_CSPARAM3, 6);
        fieldIndexMap.put(FIELD_CSPARAM4, 7);
        fieldIndexMap.put(FIELD_CSPARAMS, 8);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 9);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 10);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNCODESERVERID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNCODESERVERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERCSID, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERCSNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 23);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 24);
        fieldIndexMap.put(FIELD_READONLYMODE, 25);
        fieldIndexMap.put(FIELD_RESREADYTIME, 26);
        fieldIndexMap.put(FIELD_RESSTATE, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
    }
}

