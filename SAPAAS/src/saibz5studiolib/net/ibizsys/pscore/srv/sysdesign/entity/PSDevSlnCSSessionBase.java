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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCS;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnCSSessionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnCSSessionBase.class);
    public static final String FIELD_CODETARGET = "CODETARGET";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSPARAM = "CSPARAM";
    public static final String FIELD_CSPARAM2 = "CSPARAM2";
    public static final String FIELD_CSPARAM3 = "CSPARAM3";
    public static final String FIELD_CSPARAM4 = "CSPARAM4";
    public static final String FIELD_CSPARAMS = "CSPARAMS";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITUSER = "GITUSER";
    public static final String FIELD_HOSTADDRESS = "HOSTADDRESS";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTPORT = "HOSTPORT";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNCSSESSIONID = "PSDEVSLNCSSESSIONID";
    public static final String FIELD_PSDEVSLNCSSESSIONNAME = "PSDEVSLNCSSESSIONNAME";
    public static final String FIELD_PSDEVSLNUSERCSID = "PSDEVSLNUSERCSID";
    public static final String FIELD_PSDEVSLNUSERCSNAME = "PSDEVSLNUSERCSNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_TARGETID = "TARGETID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_CODETARGET = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CSPARAM = 3;
    private static final int INDEX_CSPARAM2 = 4;
    private static final int INDEX_CSPARAM3 = 5;
    private static final int INDEX_CSPARAM4 = 6;
    private static final int INDEX_CSPARAMS = 7;
    private static final int INDEX_EXPRIEDTIME = 8;
    private static final int INDEX_GITPATH = 9;
    private static final int INDEX_GITUSER = 10;
    private static final int INDEX_HOSTADDRESS = 11;
    private static final int INDEX_HOSTPASSWD = 12;
    private static final int INDEX_HOSTPORT = 13;
    private static final int INDEX_HOSTUSERNAME = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PSDEVSLNCSSESSIONID = 16;
    private static final int INDEX_PSDEVSLNCSSESSIONNAME = 17;
    private static final int INDEX_PSDEVSLNUSERCSID = 18;
    private static final int INDEX_PSDEVSLNUSERCSNAME = 19;
    private static final int INDEX_READONLYMODE = 20;
    private static final int INDEX_RESREADYTIME = 21;
    private static final int INDEX_RESSTATE = 22;
    private static final int INDEX_TARGETID = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_WORKSHOPPATH = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnCSSessionBase proxyPSDevSlnCSSessionBase = null;
    private boolean codetargetDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csparamDirtyFlag = false;
    private boolean csparam2DirtyFlag = false;
    private boolean csparam3DirtyFlag = false;
    private boolean csparam4DirtyFlag = false;
    private boolean csparamsDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gituserDirtyFlag = false;
    private boolean hostaddressDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostportDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslncssessionidDirtyFlag = false;
    private boolean psdevslncssessionnameDirtyFlag = false;
    private boolean psdevslnusercsidDirtyFlag = false;
    private boolean psdevslnusercsnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean targetidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean workshoppathDirtyFlag = false;
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
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gituser")
    private String gituser;
    @Column(name="hostaddress")
    private String hostaddress;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostport")
    private Integer hostport;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslncssessionid")
    private String psdevslncssessionid;
    @Column(name="psdevslncssessionname")
    private String psdevslncssessionname;
    @Column(name="psdevslnusercsid")
    private String psdevslnusercsid;
    @Column(name="psdevslnusercsname")
    private String psdevslnusercsname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="targetid")
    private String targetid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSDevSlnUserCSLock = new Integer(1);
    private PSDevSlnUserCS psdevslnusercs = null;

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

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setGitUser(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitUser(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gituser = string;
        this.gituserDirtyFlag = true;
    }

    public String getGitUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitUser();
        }
        return this.gituser;
    }

    public boolean isGitUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitUserDirty();
        }
        return this.gituserDirtyFlag;
    }

    public void resetGitUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitUser();
            return;
        }
        this.gituserDirtyFlag = false;
        this.gituser = null;
    }

    public void setHostAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostaddress = string;
        this.hostaddressDirtyFlag = true;
    }

    public String getHostAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostAddress();
        }
        return this.hostaddress;
    }

    public boolean isHostAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostAddressDirty();
        }
        return this.hostaddressDirtyFlag;
    }

    public void resetHostAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostAddress();
            return;
        }
        this.hostaddressDirtyFlag = false;
        this.hostaddress = null;
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

    public void setHostPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPort(n);
            return;
        }
        this.hostport = n;
        this.hostportDirtyFlag = true;
    }

    public Integer getHostPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPort();
        }
        return this.hostport;
    }

    public boolean isHostPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPortDirty();
        }
        return this.hostportDirtyFlag;
    }

    public void resetHostPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPort();
            return;
        }
        this.hostportDirtyFlag = false;
        this.hostport = null;
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

    public void setPSDevSlnCSSessionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCSSessionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncssessionid = string;
        this.psdevslncssessionidDirtyFlag = true;
    }

    public String getPSDevSlnCSSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCSSessionId();
        }
        return this.psdevslncssessionid;
    }

    public boolean isPSDevSlnCSSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCSSessionIdDirty();
        }
        return this.psdevslncssessionidDirtyFlag;
    }

    public void resetPSDevSlnCSSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCSSessionId();
            return;
        }
        this.psdevslncssessionidDirtyFlag = false;
        this.psdevslncssessionid = null;
    }

    public void setPSDevSlnCSSessionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCSSessionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncssessionname = string;
        this.psdevslncssessionnameDirtyFlag = true;
    }

    public String getPSDevSlnCSSessionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCSSessionName();
        }
        return this.psdevslncssessionname;
    }

    public boolean isPSDevSlnCSSessionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCSSessionNameDirty();
        }
        return this.psdevslncssessionnameDirtyFlag;
    }

    public void resetPSDevSlnCSSessionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCSSessionName();
            return;
        }
        this.psdevslncssessionnameDirtyFlag = false;
        this.psdevslncssessionname = null;
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

    public void setTargetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetid = string;
        this.targetidDirtyFlag = true;
    }

    public String getTargetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetId();
        }
        return this.targetid;
    }

    public boolean isTargetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetIdDirty();
        }
        return this.targetidDirtyFlag;
    }

    public void resetTargetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetId();
            return;
        }
        this.targetidDirtyFlag = false;
        this.targetid = null;
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

    public void setWorkshopPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkshopPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workshoppath = string;
        this.workshoppathDirtyFlag = true;
    }

    public String getWorkshopPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkshopPath();
        }
        return this.workshoppath;
    }

    public boolean isWorkshopPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkshopPathDirty();
        }
        return this.workshoppathDirtyFlag;
    }

    public void resetWorkshopPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkshopPath();
            return;
        }
        this.workshoppathDirtyFlag = false;
        this.workshoppath = null;
    }

    protected void onReset() {
        PSDevSlnCSSessionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnCSSessionBase pSDevSlnCSSessionBase) {
        pSDevSlnCSSessionBase.resetCodeTarget();
        pSDevSlnCSSessionBase.resetCreateDate();
        pSDevSlnCSSessionBase.resetCreateMan();
        pSDevSlnCSSessionBase.resetCSParam();
        pSDevSlnCSSessionBase.resetCSParam2();
        pSDevSlnCSSessionBase.resetCSParam3();
        pSDevSlnCSSessionBase.resetCSParam4();
        pSDevSlnCSSessionBase.resetCSParams();
        pSDevSlnCSSessionBase.resetExpriedTime();
        pSDevSlnCSSessionBase.resetGitPath();
        pSDevSlnCSSessionBase.resetGitUser();
        pSDevSlnCSSessionBase.resetHostAddress();
        pSDevSlnCSSessionBase.resetHostPasswd();
        pSDevSlnCSSessionBase.resetHostPort();
        pSDevSlnCSSessionBase.resetHostUserName();
        pSDevSlnCSSessionBase.resetMemo();
        pSDevSlnCSSessionBase.resetPSDevSlnCSSessionId();
        pSDevSlnCSSessionBase.resetPSDevSlnCSSessionName();
        pSDevSlnCSSessionBase.resetPSDevSlnUserCSId();
        pSDevSlnCSSessionBase.resetPSDevSlnUserCSName();
        pSDevSlnCSSessionBase.resetReadOnlyMode();
        pSDevSlnCSSessionBase.resetResReadyTime();
        pSDevSlnCSSessionBase.resetResState();
        pSDevSlnCSSessionBase.resetTargetId();
        pSDevSlnCSSessionBase.resetUpdateDate();
        pSDevSlnCSSessionBase.resetUpdateMan();
        pSDevSlnCSSessionBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isGitUserDirty()) {
            hashMap.put(FIELD_GITUSER, this.getGitUser());
        }
        if (!bl || this.isHostAddressDirty()) {
            hashMap.put(FIELD_HOSTADDRESS, this.getHostAddress());
        }
        if (!bl || this.isHostPasswdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPasswd());
        }
        if (!bl || this.isHostPortDirty()) {
            hashMap.put(FIELD_HOSTPORT, this.getHostPort());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnCSSessionIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNCSSESSIONID, this.getPSDevSlnCSSessionId());
        }
        if (!bl || this.isPSDevSlnCSSessionNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNCSSESSIONNAME, this.getPSDevSlnCSSessionName());
        }
        if (!bl || this.isPSDevSlnUserCSIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERCSID, this.getPSDevSlnUserCSId());
        }
        if (!bl || this.isPSDevSlnUserCSNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERCSNAME, this.getPSDevSlnUserCSName());
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
        if (!bl || this.isTargetIdDirty()) {
            hashMap.put(FIELD_TARGETID, this.getTargetId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWorkshopPathDirty()) {
            hashMap.put(FIELD_WORKSHOPPATH, this.getWorkshopPath());
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
        return PSDevSlnCSSessionBase.get(this, n);
    }

    private static Object get(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCSSessionBase.getCodeTarget();
            }
            case 1: {
                return pSDevSlnCSSessionBase.getCreateDate();
            }
            case 2: {
                return pSDevSlnCSSessionBase.getCreateMan();
            }
            case 3: {
                return pSDevSlnCSSessionBase.getCSParam();
            }
            case 4: {
                return pSDevSlnCSSessionBase.getCSParam2();
            }
            case 5: {
                return pSDevSlnCSSessionBase.getCSParam3();
            }
            case 6: {
                return pSDevSlnCSSessionBase.getCSParam4();
            }
            case 7: {
                return pSDevSlnCSSessionBase.getCSParams();
            }
            case 8: {
                return pSDevSlnCSSessionBase.getExpriedTime();
            }
            case 9: {
                return pSDevSlnCSSessionBase.getGitPath();
            }
            case 10: {
                return pSDevSlnCSSessionBase.getGitUser();
            }
            case 11: {
                return pSDevSlnCSSessionBase.getHostAddress();
            }
            case 12: {
                return pSDevSlnCSSessionBase.getHostPasswd();
            }
            case 13: {
                return pSDevSlnCSSessionBase.getHostPort();
            }
            case 14: {
                return pSDevSlnCSSessionBase.getHostUserName();
            }
            case 15: {
                return pSDevSlnCSSessionBase.getMemo();
            }
            case 16: {
                return pSDevSlnCSSessionBase.getPSDevSlnCSSessionId();
            }
            case 17: {
                return pSDevSlnCSSessionBase.getPSDevSlnCSSessionName();
            }
            case 18: {
                return pSDevSlnCSSessionBase.getPSDevSlnUserCSId();
            }
            case 19: {
                return pSDevSlnCSSessionBase.getPSDevSlnUserCSName();
            }
            case 20: {
                return pSDevSlnCSSessionBase.getReadOnlyMode();
            }
            case 21: {
                return pSDevSlnCSSessionBase.getResReadyTime();
            }
            case 22: {
                return pSDevSlnCSSessionBase.getResState();
            }
            case 23: {
                return pSDevSlnCSSessionBase.getTargetId();
            }
            case 24: {
                return pSDevSlnCSSessionBase.getUpdateDate();
            }
            case 25: {
                return pSDevSlnCSSessionBase.getUpdateMan();
            }
            case 26: {
                return pSDevSlnCSSessionBase.getWorkshopPath();
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
        PSDevSlnCSSessionBase.set(this, n, object);
    }

    private static void set(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCSSessionBase.setCodeTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnCSSessionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnCSSessionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnCSSessionBase.setCSParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnCSSessionBase.setCSParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnCSSessionBase.setCSParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnCSSessionBase.setCSParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnCSSessionBase.setCSParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnCSSessionBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnCSSessionBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnCSSessionBase.setGitUser(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnCSSessionBase.setHostAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnCSSessionBase.setHostPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnCSSessionBase.setHostPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnCSSessionBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnCSSessionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnCSSessionBase.setPSDevSlnCSSessionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnCSSessionBase.setPSDevSlnCSSessionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnCSSessionBase.setPSDevSlnUserCSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnCSSessionBase.setPSDevSlnUserCSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnCSSessionBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnCSSessionBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnCSSessionBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnCSSessionBase.setTargetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnCSSessionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnCSSessionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnCSSessionBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDevSlnCSSessionBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCSSessionBase.getCodeTarget() == null;
            }
            case 1: {
                return pSDevSlnCSSessionBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevSlnCSSessionBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevSlnCSSessionBase.getCSParam() == null;
            }
            case 4: {
                return pSDevSlnCSSessionBase.getCSParam2() == null;
            }
            case 5: {
                return pSDevSlnCSSessionBase.getCSParam3() == null;
            }
            case 6: {
                return pSDevSlnCSSessionBase.getCSParam4() == null;
            }
            case 7: {
                return pSDevSlnCSSessionBase.getCSParams() == null;
            }
            case 8: {
                return pSDevSlnCSSessionBase.getExpriedTime() == null;
            }
            case 9: {
                return pSDevSlnCSSessionBase.getGitPath() == null;
            }
            case 10: {
                return pSDevSlnCSSessionBase.getGitUser() == null;
            }
            case 11: {
                return pSDevSlnCSSessionBase.getHostAddress() == null;
            }
            case 12: {
                return pSDevSlnCSSessionBase.getHostPasswd() == null;
            }
            case 13: {
                return pSDevSlnCSSessionBase.getHostPort() == null;
            }
            case 14: {
                return pSDevSlnCSSessionBase.getHostUserName() == null;
            }
            case 15: {
                return pSDevSlnCSSessionBase.getMemo() == null;
            }
            case 16: {
                return pSDevSlnCSSessionBase.getPSDevSlnCSSessionId() == null;
            }
            case 17: {
                return pSDevSlnCSSessionBase.getPSDevSlnCSSessionName() == null;
            }
            case 18: {
                return pSDevSlnCSSessionBase.getPSDevSlnUserCSId() == null;
            }
            case 19: {
                return pSDevSlnCSSessionBase.getPSDevSlnUserCSName() == null;
            }
            case 20: {
                return pSDevSlnCSSessionBase.getReadOnlyMode() == null;
            }
            case 21: {
                return pSDevSlnCSSessionBase.getResReadyTime() == null;
            }
            case 22: {
                return pSDevSlnCSSessionBase.getResState() == null;
            }
            case 23: {
                return pSDevSlnCSSessionBase.getTargetId() == null;
            }
            case 24: {
                return pSDevSlnCSSessionBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDevSlnCSSessionBase.getUpdateMan() == null;
            }
            case 26: {
                return pSDevSlnCSSessionBase.getWorkshopPath() == null;
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
        return PSDevSlnCSSessionBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCSSessionBase.isCodeTargetDirty();
            }
            case 1: {
                return pSDevSlnCSSessionBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevSlnCSSessionBase.isCreateManDirty();
            }
            case 3: {
                return pSDevSlnCSSessionBase.isCSParamDirty();
            }
            case 4: {
                return pSDevSlnCSSessionBase.isCSParam2Dirty();
            }
            case 5: {
                return pSDevSlnCSSessionBase.isCSParam3Dirty();
            }
            case 6: {
                return pSDevSlnCSSessionBase.isCSParam4Dirty();
            }
            case 7: {
                return pSDevSlnCSSessionBase.isCSParamsDirty();
            }
            case 8: {
                return pSDevSlnCSSessionBase.isExpriedTimeDirty();
            }
            case 9: {
                return pSDevSlnCSSessionBase.isGitPathDirty();
            }
            case 10: {
                return pSDevSlnCSSessionBase.isGitUserDirty();
            }
            case 11: {
                return pSDevSlnCSSessionBase.isHostAddressDirty();
            }
            case 12: {
                return pSDevSlnCSSessionBase.isHostPasswdDirty();
            }
            case 13: {
                return pSDevSlnCSSessionBase.isHostPortDirty();
            }
            case 14: {
                return pSDevSlnCSSessionBase.isHostUserNameDirty();
            }
            case 15: {
                return pSDevSlnCSSessionBase.isMemoDirty();
            }
            case 16: {
                return pSDevSlnCSSessionBase.isPSDevSlnCSSessionIdDirty();
            }
            case 17: {
                return pSDevSlnCSSessionBase.isPSDevSlnCSSessionNameDirty();
            }
            case 18: {
                return pSDevSlnCSSessionBase.isPSDevSlnUserCSIdDirty();
            }
            case 19: {
                return pSDevSlnCSSessionBase.isPSDevSlnUserCSNameDirty();
            }
            case 20: {
                return pSDevSlnCSSessionBase.isReadOnlyModeDirty();
            }
            case 21: {
                return pSDevSlnCSSessionBase.isResReadyTimeDirty();
            }
            case 22: {
                return pSDevSlnCSSessionBase.isResStateDirty();
            }
            case 23: {
                return pSDevSlnCSSessionBase.isTargetIdDirty();
            }
            case 24: {
                return pSDevSlnCSSessionBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDevSlnCSSessionBase.isUpdateManDirty();
            }
            case 26: {
                return pSDevSlnCSSessionBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnCSSessionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnCSSessionBase.getCodeTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetarget", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCodeTarget()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCSParam()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam2", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCSParam2()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam3", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCSParam3()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparam4", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCSParam4()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csparams", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getCSParams()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getGitUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gituser", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getGitUser()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getHostAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostaddress", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getHostAddress()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getHostPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getHostPasswd()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getHostPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostport", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getHostPort()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncssessionid", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getPSDevSlnCSSessionId()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncssessionname", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getPSDevSlnCSSessionName()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnusercsid", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getPSDevSlnUserCSId()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnusercsname", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getPSDevSlnUserCSName()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getResState()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getTargetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetid", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getTargetId()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnCSSessionBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDevSlnCSSessionBase.getJSONValue((Object)pSDevSlnCSSessionBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnCSSessionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnCSSessionBase.getCodeTarget() != null) {
            object = pSDevSlnCSSessionBase.getCodeTarget();
            xmlNode.setAttribute(FIELD_CODETARGET, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getCreateDate() != null) {
            object = pSDevSlnCSSessionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getCreateMan() != null) {
            object = pSDevSlnCSSessionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam() != null) {
            object = pSDevSlnCSSessionBase.getCSParam();
            xmlNode.setAttribute(FIELD_CSPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam2() != null) {
            object = pSDevSlnCSSessionBase.getCSParam2();
            xmlNode.setAttribute(FIELD_CSPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam3() != null) {
            object = pSDevSlnCSSessionBase.getCSParam3();
            xmlNode.setAttribute(FIELD_CSPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getCSParam4() != null) {
            object = pSDevSlnCSSessionBase.getCSParam4();
            xmlNode.setAttribute(FIELD_CSPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getCSParams() != null) {
            object = pSDevSlnCSSessionBase.getCSParams();
            xmlNode.setAttribute(FIELD_CSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getExpriedTime() != null) {
            object = pSDevSlnCSSessionBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getGitPath() != null) {
            object = pSDevSlnCSSessionBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getGitUser() != null) {
            object = pSDevSlnCSSessionBase.getGitUser();
            xmlNode.setAttribute(FIELD_GITUSER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getHostAddress() != null) {
            object = pSDevSlnCSSessionBase.getHostAddress();
            xmlNode.setAttribute(FIELD_HOSTADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getHostPasswd() != null) {
            object = pSDevSlnCSSessionBase.getHostPasswd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getHostPort() != null) {
            object = pSDevSlnCSSessionBase.getHostPort();
            xmlNode.setAttribute(FIELD_HOSTPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getHostUserName() != null) {
            object = pSDevSlnCSSessionBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getMemo() != null) {
            object = pSDevSlnCSSessionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionId() != null) {
            object = pSDevSlnCSSessionBase.getPSDevSlnCSSessionId();
            xmlNode.setAttribute(FIELD_PSDEVSLNCSSESSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionName() != null) {
            object = pSDevSlnCSSessionBase.getPSDevSlnCSSessionName();
            xmlNode.setAttribute(FIELD_PSDEVSLNCSSESSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSId() != null) {
            object = pSDevSlnCSSessionBase.getPSDevSlnUserCSId();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERCSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSName() != null) {
            object = pSDevSlnCSSessionBase.getPSDevSlnUserCSName();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERCSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getReadOnlyMode() != null) {
            object = pSDevSlnCSSessionBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getResReadyTime() != null) {
            object = pSDevSlnCSSessionBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getResState() != null) {
            object = pSDevSlnCSSessionBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getTargetId() != null) {
            object = pSDevSlnCSSessionBase.getTargetId();
            xmlNode.setAttribute(FIELD_TARGETID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getUpdateDate() != null) {
            object = pSDevSlnCSSessionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCSSessionBase.getUpdateMan() != null) {
            object = pSDevSlnCSSessionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCSSessionBase.getWorkshopPath() != null) {
            object = pSDevSlnCSSessionBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnCSSessionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnCSSessionBase.isCodeTargetDirty() && (bl || pSDevSlnCSSessionBase.getCodeTarget() != null)) {
            iDataObject.set(FIELD_CODETARGET, (Object)pSDevSlnCSSessionBase.getCodeTarget());
        }
        if (pSDevSlnCSSessionBase.isCreateDateDirty() && (bl || pSDevSlnCSSessionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnCSSessionBase.getCreateDate());
        }
        if (pSDevSlnCSSessionBase.isCreateManDirty() && (bl || pSDevSlnCSSessionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnCSSessionBase.getCreateMan());
        }
        if (pSDevSlnCSSessionBase.isCSParamDirty() && (bl || pSDevSlnCSSessionBase.getCSParam() != null)) {
            iDataObject.set(FIELD_CSPARAM, (Object)pSDevSlnCSSessionBase.getCSParam());
        }
        if (pSDevSlnCSSessionBase.isCSParam2Dirty() && (bl || pSDevSlnCSSessionBase.getCSParam2() != null)) {
            iDataObject.set(FIELD_CSPARAM2, (Object)pSDevSlnCSSessionBase.getCSParam2());
        }
        if (pSDevSlnCSSessionBase.isCSParam3Dirty() && (bl || pSDevSlnCSSessionBase.getCSParam3() != null)) {
            iDataObject.set(FIELD_CSPARAM3, (Object)pSDevSlnCSSessionBase.getCSParam3());
        }
        if (pSDevSlnCSSessionBase.isCSParam4Dirty() && (bl || pSDevSlnCSSessionBase.getCSParam4() != null)) {
            iDataObject.set(FIELD_CSPARAM4, (Object)pSDevSlnCSSessionBase.getCSParam4());
        }
        if (pSDevSlnCSSessionBase.isCSParamsDirty() && (bl || pSDevSlnCSSessionBase.getCSParams() != null)) {
            iDataObject.set(FIELD_CSPARAMS, (Object)pSDevSlnCSSessionBase.getCSParams());
        }
        if (pSDevSlnCSSessionBase.isExpriedTimeDirty() && (bl || pSDevSlnCSSessionBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnCSSessionBase.getExpriedTime());
        }
        if (pSDevSlnCSSessionBase.isGitPathDirty() && (bl || pSDevSlnCSSessionBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDevSlnCSSessionBase.getGitPath());
        }
        if (pSDevSlnCSSessionBase.isGitUserDirty() && (bl || pSDevSlnCSSessionBase.getGitUser() != null)) {
            iDataObject.set(FIELD_GITUSER, (Object)pSDevSlnCSSessionBase.getGitUser());
        }
        if (pSDevSlnCSSessionBase.isHostAddressDirty() && (bl || pSDevSlnCSSessionBase.getHostAddress() != null)) {
            iDataObject.set(FIELD_HOSTADDRESS, (Object)pSDevSlnCSSessionBase.getHostAddress());
        }
        if (pSDevSlnCSSessionBase.isHostPasswdDirty() && (bl || pSDevSlnCSSessionBase.getHostPasswd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevSlnCSSessionBase.getHostPasswd());
        }
        if (pSDevSlnCSSessionBase.isHostPortDirty() && (bl || pSDevSlnCSSessionBase.getHostPort() != null)) {
            iDataObject.set(FIELD_HOSTPORT, (Object)pSDevSlnCSSessionBase.getHostPort());
        }
        if (pSDevSlnCSSessionBase.isHostUserNameDirty() && (bl || pSDevSlnCSSessionBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevSlnCSSessionBase.getHostUserName());
        }
        if (pSDevSlnCSSessionBase.isMemoDirty() && (bl || pSDevSlnCSSessionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnCSSessionBase.getMemo());
        }
        if (pSDevSlnCSSessionBase.isPSDevSlnCSSessionIdDirty() && (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCSSESSIONID, (Object)pSDevSlnCSSessionBase.getPSDevSlnCSSessionId());
        }
        if (pSDevSlnCSSessionBase.isPSDevSlnCSSessionNameDirty() && (bl || pSDevSlnCSSessionBase.getPSDevSlnCSSessionName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCSSESSIONNAME, (Object)pSDevSlnCSSessionBase.getPSDevSlnCSSessionName());
        }
        if (pSDevSlnCSSessionBase.isPSDevSlnUserCSIdDirty() && (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERCSID, (Object)pSDevSlnCSSessionBase.getPSDevSlnUserCSId());
        }
        if (pSDevSlnCSSessionBase.isPSDevSlnUserCSNameDirty() && (bl || pSDevSlnCSSessionBase.getPSDevSlnUserCSName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERCSNAME, (Object)pSDevSlnCSSessionBase.getPSDevSlnUserCSName());
        }
        if (pSDevSlnCSSessionBase.isReadOnlyModeDirty() && (bl || pSDevSlnCSSessionBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDevSlnCSSessionBase.getReadOnlyMode());
        }
        if (pSDevSlnCSSessionBase.isResReadyTimeDirty() && (bl || pSDevSlnCSSessionBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevSlnCSSessionBase.getResReadyTime());
        }
        if (pSDevSlnCSSessionBase.isResStateDirty() && (bl || pSDevSlnCSSessionBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevSlnCSSessionBase.getResState());
        }
        if (pSDevSlnCSSessionBase.isTargetIdDirty() && (bl || pSDevSlnCSSessionBase.getTargetId() != null)) {
            iDataObject.set(FIELD_TARGETID, (Object)pSDevSlnCSSessionBase.getTargetId());
        }
        if (pSDevSlnCSSessionBase.isUpdateDateDirty() && (bl || pSDevSlnCSSessionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnCSSessionBase.getUpdateDate());
        }
        if (pSDevSlnCSSessionBase.isUpdateManDirty() && (bl || pSDevSlnCSSessionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnCSSessionBase.getUpdateMan());
        }
        if (pSDevSlnCSSessionBase.isWorkshopPathDirty() && (bl || pSDevSlnCSSessionBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDevSlnCSSessionBase.getWorkshopPath());
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
        return PSDevSlnCSSessionBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnCSSessionBase pSDevSlnCSSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCSSessionBase.resetCodeTarget();
                return true;
            }
            case 1: {
                pSDevSlnCSSessionBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevSlnCSSessionBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevSlnCSSessionBase.resetCSParam();
                return true;
            }
            case 4: {
                pSDevSlnCSSessionBase.resetCSParam2();
                return true;
            }
            case 5: {
                pSDevSlnCSSessionBase.resetCSParam3();
                return true;
            }
            case 6: {
                pSDevSlnCSSessionBase.resetCSParam4();
                return true;
            }
            case 7: {
                pSDevSlnCSSessionBase.resetCSParams();
                return true;
            }
            case 8: {
                pSDevSlnCSSessionBase.resetExpriedTime();
                return true;
            }
            case 9: {
                pSDevSlnCSSessionBase.resetGitPath();
                return true;
            }
            case 10: {
                pSDevSlnCSSessionBase.resetGitUser();
                return true;
            }
            case 11: {
                pSDevSlnCSSessionBase.resetHostAddress();
                return true;
            }
            case 12: {
                pSDevSlnCSSessionBase.resetHostPasswd();
                return true;
            }
            case 13: {
                pSDevSlnCSSessionBase.resetHostPort();
                return true;
            }
            case 14: {
                pSDevSlnCSSessionBase.resetHostUserName();
                return true;
            }
            case 15: {
                pSDevSlnCSSessionBase.resetMemo();
                return true;
            }
            case 16: {
                pSDevSlnCSSessionBase.resetPSDevSlnCSSessionId();
                return true;
            }
            case 17: {
                pSDevSlnCSSessionBase.resetPSDevSlnCSSessionName();
                return true;
            }
            case 18: {
                pSDevSlnCSSessionBase.resetPSDevSlnUserCSId();
                return true;
            }
            case 19: {
                pSDevSlnCSSessionBase.resetPSDevSlnUserCSName();
                return true;
            }
            case 20: {
                pSDevSlnCSSessionBase.resetReadOnlyMode();
                return true;
            }
            case 21: {
                pSDevSlnCSSessionBase.resetResReadyTime();
                return true;
            }
            case 22: {
                pSDevSlnCSSessionBase.resetResState();
                return true;
            }
            case 23: {
                pSDevSlnCSSessionBase.resetTargetId();
                return true;
            }
            case 24: {
                pSDevSlnCSSessionBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDevSlnCSSessionBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSDevSlnCSSessionBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnUserCS getPSDevSlnUserCS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUserCS();
        }
        if (this.getPSDevSlnUserCSId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnUserCSLock;
        synchronized (n) {
            if (this.psdevslnusercs != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnUserCSId(), (Object)this.psdevslnusercs.getPSDevSlnUserCSId()) != 0L) {
                this.psdevslnusercs = null;
            }
            if (this.psdevslnusercs == null) {
                PSDevSlnUserCS pSDevSlnUserCS = new PSDevSlnUserCS();
                pSDevSlnUserCS.setPSDevSlnUserCSId(this.getPSDevSlnUserCSId());
                PSDevSlnUserCSService pSDevSlnUserCSService = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnUserCSService.autoGet((IEntity)pSDevSlnUserCS);
                this.psdevslnusercs = pSDevSlnUserCS;
            }
            return this.psdevslnusercs;
        }
    }

    private PSDevSlnCSSessionBase getProxyEntity() {
        return this.proxyPSDevSlnCSSessionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnCSSessionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnCSSessionBase) {
            this.proxyPSDevSlnCSSessionBase = (PSDevSlnCSSessionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCSSessionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODETARGET, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CSPARAM, 3);
        fieldIndexMap.put(FIELD_CSPARAM2, 4);
        fieldIndexMap.put(FIELD_CSPARAM3, 5);
        fieldIndexMap.put(FIELD_CSPARAM4, 6);
        fieldIndexMap.put(FIELD_CSPARAMS, 7);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 8);
        fieldIndexMap.put(FIELD_GITPATH, 9);
        fieldIndexMap.put(FIELD_GITUSER, 10);
        fieldIndexMap.put(FIELD_HOSTADDRESS, 11);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 12);
        fieldIndexMap.put(FIELD_HOSTPORT, 13);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNCSSESSIONID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNCSSESSIONNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERCSID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERCSNAME, 19);
        fieldIndexMap.put(FIELD_READONLYMODE, 20);
        fieldIndexMap.put(FIELD_RESREADYTIME, 21);
        fieldIndexMap.put(FIELD_RESSTATE, 22);
        fieldIndexMap.put(FIELD_TARGETID, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 26);
    }
}

