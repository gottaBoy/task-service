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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevServerBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSSTATE = "DSSTATE";
    public static final String FIELD_DSTYPE = "DSTYPE";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_TIMESHAREMODE = "TIMESHAREMODE";
    public static final String FIELD_TIMESHARERESSPEC = "TIMESHARERESSPEC";
    public static final String FIELD_TIMESHARERESTYPE = "TIMESHARERESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DSSTATE = 4;
    private static final int INDEX_DSTYPE = 5;
    private static final int INDEX_ENABLE = 6;
    private static final int INDEX_IPADDR = 7;
    private static final int INDEX_IPADDR2 = 8;
    private static final int INDEX_LOCALRES = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PARAM = 11;
    private static final int INDEX_PARAM2 = 12;
    private static final int INDEX_PARAM3 = 13;
    private static final int INDEX_PARAM4 = 14;
    private static final int INDEX_PARAM5 = 15;
    private static final int INDEX_PARAM6 = 16;
    private static final int INDEX_PARAM7 = 17;
    private static final int INDEX_PARAM8 = 18;
    private static final int INDEX_PASSWD = 19;
    private static final int INDEX_PSDEVSERVERID = 20;
    private static final int INDEX_PSDEVSERVERNAME = 21;
    private static final int INDEX_PSSVRDOMAINID = 22;
    private static final int INDEX_PSSVRDOMAINNAME = 23;
    private static final int INDEX_REFINFO = 24;
    private static final int INDEX_SSHIPADDR = 25;
    private static final int INDEX_SSHPORT = 26;
    private static final int INDEX_TIMESHAREMODE = 27;
    private static final int INDEX_TIMESHARERESSPEC = 28;
    private static final int INDEX_TIMESHARERESTYPE = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_UPLOADFILEMODE = 32;
    private static final int INDEX_USERNAME = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevServerBase proxyPSDevServerBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsstateDirtyFlag = false;
    private boolean dstypeDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean timesharemodeDirtyFlag = false;
    private boolean timeshareresspecDirtyFlag = false;
    private boolean timesharerestypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsstate")
    private Integer dsstate;
    @Column(name="dstype")
    private String dstype;
    @Column(name="enable")
    private Integer enable;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdevserverid")
    private String psdevserverid;
    @Column(name="psdevservername")
    private String psdevservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="timesharemode")
    private Integer timesharemode;
    @Column(name="timeshareresspec")
    private String timeshareresspec;
    @Column(name="timesharerestype")
    private String timesharerestype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAdminPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpasswd = string;
        this.adminpasswdDirtyFlag = true;
    }

    public String getAdminPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPasswd();
        }
        return this.adminpasswd;
    }

    public boolean isAdminPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPasswdDirty();
        }
        return this.adminpasswdDirtyFlag;
    }

    public void resetAdminPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPasswd();
            return;
        }
        this.adminpasswdDirtyFlag = false;
        this.adminpasswd = null;
    }

    public void setAdminUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminusername = string;
        this.adminusernameDirtyFlag = true;
    }

    public String getAdminUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminUserName();
        }
        return this.adminusername;
    }

    public boolean isAdminUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminUserNameDirty();
        }
        return this.adminusernameDirtyFlag;
    }

    public void resetAdminUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminUserName();
            return;
        }
        this.adminusernameDirtyFlag = false;
        this.adminusername = null;
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

    public void setDSState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSState(n);
            return;
        }
        this.dsstate = n;
        this.dsstateDirtyFlag = true;
    }

    public Integer getDSState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSState();
        }
        return this.dsstate;
    }

    public boolean isDSStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSStateDirty();
        }
        return this.dsstateDirtyFlag;
    }

    public void resetDSState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSState();
            return;
        }
        this.dsstateDirtyFlag = false;
        this.dsstate = null;
    }

    public void setDSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstype = string;
        this.dstypeDirtyFlag = true;
    }

    public String getDSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSType();
        }
        return this.dstype;
    }

    public boolean isDSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTypeDirty();
        }
        return this.dstypeDirtyFlag;
    }

    public void resetDSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSType();
            return;
        }
        this.dstypeDirtyFlag = false;
        this.dstype = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setIpAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIpAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr();
        }
        return this.ipaddr;
    }

    public boolean isIpAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIpAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
    }

    public void setIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
    }

    public void setLocalRes(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalRes(n);
            return;
        }
        this.localres = n;
        this.localresDirtyFlag = true;
    }

    public Integer getLocalRes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalRes();
        }
        return this.localres;
    }

    public boolean isLocalResDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalResDirty();
        }
        return this.localresDirtyFlag;
    }

    public void resetLocalRes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalRes();
            return;
        }
        this.localresDirtyFlag = false;
        this.localres = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPSDevServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverid = string;
        this.psdevserveridDirtyFlag = true;
    }

    public String getPSDevServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerId();
        }
        return this.psdevserverid;
    }

    public boolean isPSDevServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerIdDirty();
        }
        return this.psdevserveridDirtyFlag;
    }

    public void resetPSDevServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerId();
            return;
        }
        this.psdevserveridDirtyFlag = false;
        this.psdevserverid = null;
    }

    public void setPSDevServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservername = string;
        this.psdevservernameDirtyFlag = true;
    }

    public String getPSDevServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerName();
        }
        return this.psdevservername;
    }

    public boolean isPSDevServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerNameDirty();
        }
        return this.psdevservernameDirtyFlag;
    }

    public void resetPSDevServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerName();
            return;
        }
        this.psdevservernameDirtyFlag = false;
        this.psdevservername = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
    }

    public void setSSHIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sshipaddr = string;
        this.sshipaddrDirtyFlag = true;
    }

    public String getSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHIPAddr();
        }
        return this.sshipaddr;
    }

    public boolean isSSHIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHIPAddrDirty();
        }
        return this.sshipaddrDirtyFlag;
    }

    public void resetSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHIPAddr();
            return;
        }
        this.sshipaddrDirtyFlag = false;
        this.sshipaddr = null;
    }

    public void setSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHPort(n);
            return;
        }
        this.sshport = n;
        this.sshportDirtyFlag = true;
    }

    public Integer getSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHPort();
        }
        return this.sshport;
    }

    public boolean isSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHPortDirty();
        }
        return this.sshportDirtyFlag;
    }

    public void resetSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHPort();
            return;
        }
        this.sshportDirtyFlag = false;
        this.sshport = null;
    }

    public void setTimeShareMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareMode(n);
            return;
        }
        this.timesharemode = n;
        this.timesharemodeDirtyFlag = true;
    }

    public Integer getTimeShareMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareMode();
        }
        return this.timesharemode;
    }

    public boolean isTimeShareModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareModeDirty();
        }
        return this.timesharemodeDirtyFlag;
    }

    public void resetTimeShareMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareMode();
            return;
        }
        this.timesharemodeDirtyFlag = false;
        this.timesharemode = null;
    }

    public void setTimeShareResSpec(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareResSpec(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeshareresspec = string;
        this.timeshareresspecDirtyFlag = true;
    }

    public String getTimeShareResSpec() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareResSpec();
        }
        return this.timeshareresspec;
    }

    public boolean isTimeShareResSpecDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareResSpecDirty();
        }
        return this.timeshareresspecDirtyFlag;
    }

    public void resetTimeShareResSpec() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareResSpec();
            return;
        }
        this.timeshareresspecDirtyFlag = false;
        this.timeshareresspec = null;
    }

    public void setTimeShareResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timesharerestype = string;
        this.timesharerestypeDirtyFlag = true;
    }

    public String getTimeShareResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareResType();
        }
        return this.timesharerestype;
    }

    public boolean isTimeShareResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareResTypeDirty();
        }
        return this.timesharerestypeDirtyFlag;
    }

    public void resetTimeShareResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareResType();
            return;
        }
        this.timesharerestypeDirtyFlag = false;
        this.timesharerestype = null;
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

    public void setUploadFileMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadFileMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadfilemode = string;
        this.uploadfilemodeDirtyFlag = true;
    }

    public String getUploadFileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadFileMode();
        }
        return this.uploadfilemode;
    }

    public boolean isUploadFileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadFileModeDirty();
        }
        return this.uploadfilemodeDirtyFlag;
    }

    public void resetUploadFileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadFileMode();
            return;
        }
        this.uploadfilemodeDirtyFlag = false;
        this.uploadfilemode = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
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
        PSDevServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevServerBase pSDevServerBase) {
        pSDevServerBase.resetAdminPasswd();
        pSDevServerBase.resetAdminUserName();
        pSDevServerBase.resetCreateDate();
        pSDevServerBase.resetCreateMan();
        pSDevServerBase.resetDSState();
        pSDevServerBase.resetDSType();
        pSDevServerBase.resetEnable();
        pSDevServerBase.resetIpAddr();
        pSDevServerBase.resetIpAddr2();
        pSDevServerBase.resetLocalRes();
        pSDevServerBase.resetMemo();
        pSDevServerBase.resetParam();
        pSDevServerBase.resetParam2();
        pSDevServerBase.resetParam3();
        pSDevServerBase.resetParam4();
        pSDevServerBase.resetParam5();
        pSDevServerBase.resetParam6();
        pSDevServerBase.resetParam7();
        pSDevServerBase.resetParam8();
        pSDevServerBase.resetPasswd();
        pSDevServerBase.resetPSDevServerId();
        pSDevServerBase.resetPSDevServerName();
        pSDevServerBase.resetPSSvrDomainId();
        pSDevServerBase.resetPSSvrDomainName();
        pSDevServerBase.resetRefInfo();
        pSDevServerBase.resetSSHIPAddr();
        pSDevServerBase.resetSSHPort();
        pSDevServerBase.resetTimeShareMode();
        pSDevServerBase.resetTimeShareResSpec();
        pSDevServerBase.resetTimeShareResType();
        pSDevServerBase.resetUpdateDate();
        pSDevServerBase.resetUpdateMan();
        pSDevServerBase.resetUploadFileMode();
        pSDevServerBase.resetUserName();
        pSDevServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPasswdDirty()) {
            hashMap.put(FIELD_ADMINPASSWD, this.getAdminPasswd());
        }
        if (!bl || this.isAdminUserNameDirty()) {
            hashMap.put(FIELD_ADMINUSERNAME, this.getAdminUserName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDSStateDirty()) {
            hashMap.put(FIELD_DSSTATE, this.getDSState());
        }
        if (!bl || this.isDSTypeDirty()) {
            hashMap.put(FIELD_DSTYPE, this.getDSType());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDevServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERID, this.getPSDevServerId());
        }
        if (!bl || this.isPSDevServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERNAME, this.getPSDevServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isTimeShareModeDirty()) {
            hashMap.put(FIELD_TIMESHAREMODE, this.getTimeShareMode());
        }
        if (!bl || this.isTimeShareResSpecDirty()) {
            hashMap.put(FIELD_TIMESHARERESSPEC, this.getTimeShareResSpec());
        }
        if (!bl || this.isTimeShareResTypeDirty()) {
            hashMap.put(FIELD_TIMESHARERESTYPE, this.getTimeShareResType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSDevServerBase.get(this, n);
    }

    private static Object get(PSDevServerBase pSDevServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerBase.getAdminPasswd();
            }
            case 1: {
                return pSDevServerBase.getAdminUserName();
            }
            case 2: {
                return pSDevServerBase.getCreateDate();
            }
            case 3: {
                return pSDevServerBase.getCreateMan();
            }
            case 4: {
                return pSDevServerBase.getDSState();
            }
            case 5: {
                return pSDevServerBase.getDSType();
            }
            case 6: {
                return pSDevServerBase.getEnable();
            }
            case 7: {
                return pSDevServerBase.getIpAddr();
            }
            case 8: {
                return pSDevServerBase.getIpAddr2();
            }
            case 9: {
                return pSDevServerBase.getLocalRes();
            }
            case 10: {
                return pSDevServerBase.getMemo();
            }
            case 11: {
                return pSDevServerBase.getParam();
            }
            case 12: {
                return pSDevServerBase.getParam2();
            }
            case 13: {
                return pSDevServerBase.getParam3();
            }
            case 14: {
                return pSDevServerBase.getParam4();
            }
            case 15: {
                return pSDevServerBase.getParam5();
            }
            case 16: {
                return pSDevServerBase.getParam6();
            }
            case 17: {
                return pSDevServerBase.getParam7();
            }
            case 18: {
                return pSDevServerBase.getParam8();
            }
            case 19: {
                return pSDevServerBase.getPasswd();
            }
            case 20: {
                return pSDevServerBase.getPSDevServerId();
            }
            case 21: {
                return pSDevServerBase.getPSDevServerName();
            }
            case 22: {
                return pSDevServerBase.getPSSvrDomainId();
            }
            case 23: {
                return pSDevServerBase.getPSSvrDomainName();
            }
            case 24: {
                return pSDevServerBase.getRefInfo();
            }
            case 25: {
                return pSDevServerBase.getSSHIPAddr();
            }
            case 26: {
                return pSDevServerBase.getSSHPort();
            }
            case 27: {
                return pSDevServerBase.getTimeShareMode();
            }
            case 28: {
                return pSDevServerBase.getTimeShareResSpec();
            }
            case 29: {
                return pSDevServerBase.getTimeShareResType();
            }
            case 30: {
                return pSDevServerBase.getUpdateDate();
            }
            case 31: {
                return pSDevServerBase.getUpdateMan();
            }
            case 32: {
                return pSDevServerBase.getUploadFileMode();
            }
            case 33: {
                return pSDevServerBase.getUserName();
            }
            case 34: {
                return pSDevServerBase.getValidFlag();
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
        PSDevServerBase.set(this, n, object);
    }

    private static void set(PSDevServerBase pSDevServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevServerBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevServerBase.setDSState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevServerBase.setDSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevServerBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevServerBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevServerBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevServerBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevServerBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevServerBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevServerBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevServerBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevServerBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDevServerBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDevServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevServerBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevServerBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevServerBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevServerBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevServerBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDevServerBase.setTimeShareMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDevServerBase.setTimeShareResSpec(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevServerBase.setTimeShareResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSDevServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevServerBase pSDevServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDevServerBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDevServerBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevServerBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevServerBase.getDSState() == null;
            }
            case 5: {
                return pSDevServerBase.getDSType() == null;
            }
            case 6: {
                return pSDevServerBase.getEnable() == null;
            }
            case 7: {
                return pSDevServerBase.getIpAddr() == null;
            }
            case 8: {
                return pSDevServerBase.getIpAddr2() == null;
            }
            case 9: {
                return pSDevServerBase.getLocalRes() == null;
            }
            case 10: {
                return pSDevServerBase.getMemo() == null;
            }
            case 11: {
                return pSDevServerBase.getParam() == null;
            }
            case 12: {
                return pSDevServerBase.getParam2() == null;
            }
            case 13: {
                return pSDevServerBase.getParam3() == null;
            }
            case 14: {
                return pSDevServerBase.getParam4() == null;
            }
            case 15: {
                return pSDevServerBase.getParam5() == null;
            }
            case 16: {
                return pSDevServerBase.getParam6() == null;
            }
            case 17: {
                return pSDevServerBase.getParam7() == null;
            }
            case 18: {
                return pSDevServerBase.getParam8() == null;
            }
            case 19: {
                return pSDevServerBase.getPasswd() == null;
            }
            case 20: {
                return pSDevServerBase.getPSDevServerId() == null;
            }
            case 21: {
                return pSDevServerBase.getPSDevServerName() == null;
            }
            case 22: {
                return pSDevServerBase.getPSSvrDomainId() == null;
            }
            case 23: {
                return pSDevServerBase.getPSSvrDomainName() == null;
            }
            case 24: {
                return pSDevServerBase.getRefInfo() == null;
            }
            case 25: {
                return pSDevServerBase.getSSHIPAddr() == null;
            }
            case 26: {
                return pSDevServerBase.getSSHPort() == null;
            }
            case 27: {
                return pSDevServerBase.getTimeShareMode() == null;
            }
            case 28: {
                return pSDevServerBase.getTimeShareResSpec() == null;
            }
            case 29: {
                return pSDevServerBase.getTimeShareResType() == null;
            }
            case 30: {
                return pSDevServerBase.getUpdateDate() == null;
            }
            case 31: {
                return pSDevServerBase.getUpdateMan() == null;
            }
            case 32: {
                return pSDevServerBase.getUploadFileMode() == null;
            }
            case 33: {
                return pSDevServerBase.getUserName() == null;
            }
            case 34: {
                return pSDevServerBase.getValidFlag() == null;
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
        return PSDevServerBase.contains(this, n);
    }

    private static boolean contains(PSDevServerBase pSDevServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDevServerBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDevServerBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevServerBase.isCreateManDirty();
            }
            case 4: {
                return pSDevServerBase.isDSStateDirty();
            }
            case 5: {
                return pSDevServerBase.isDSTypeDirty();
            }
            case 6: {
                return pSDevServerBase.isEnableDirty();
            }
            case 7: {
                return pSDevServerBase.isIpAddrDirty();
            }
            case 8: {
                return pSDevServerBase.isIpAddr2Dirty();
            }
            case 9: {
                return pSDevServerBase.isLocalResDirty();
            }
            case 10: {
                return pSDevServerBase.isMemoDirty();
            }
            case 11: {
                return pSDevServerBase.isParamDirty();
            }
            case 12: {
                return pSDevServerBase.isParam2Dirty();
            }
            case 13: {
                return pSDevServerBase.isParam3Dirty();
            }
            case 14: {
                return pSDevServerBase.isParam4Dirty();
            }
            case 15: {
                return pSDevServerBase.isParam5Dirty();
            }
            case 16: {
                return pSDevServerBase.isParam6Dirty();
            }
            case 17: {
                return pSDevServerBase.isParam7Dirty();
            }
            case 18: {
                return pSDevServerBase.isParam8Dirty();
            }
            case 19: {
                return pSDevServerBase.isPasswdDirty();
            }
            case 20: {
                return pSDevServerBase.isPSDevServerIdDirty();
            }
            case 21: {
                return pSDevServerBase.isPSDevServerNameDirty();
            }
            case 22: {
                return pSDevServerBase.isPSSvrDomainIdDirty();
            }
            case 23: {
                return pSDevServerBase.isPSSvrDomainNameDirty();
            }
            case 24: {
                return pSDevServerBase.isRefInfoDirty();
            }
            case 25: {
                return pSDevServerBase.isSSHIPAddrDirty();
            }
            case 26: {
                return pSDevServerBase.isSSHPortDirty();
            }
            case 27: {
                return pSDevServerBase.isTimeShareModeDirty();
            }
            case 28: {
                return pSDevServerBase.isTimeShareResSpecDirty();
            }
            case 29: {
                return pSDevServerBase.isTimeShareResTypeDirty();
            }
            case 30: {
                return pSDevServerBase.isUpdateDateDirty();
            }
            case 31: {
                return pSDevServerBase.isUpdateManDirty();
            }
            case 32: {
                return pSDevServerBase.isUploadFileModeDirty();
            }
            case 33: {
                return pSDevServerBase.isUserNameDirty();
            }
            case 34: {
                return pSDevServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevServerBase pSDevServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevServerBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDevServerBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDevServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevServerBase.getDSState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsstate", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getDSState()), (boolean)false);
        }
        if (bl || pSDevServerBase.getDSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstype", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getDSType()), (boolean)false);
        }
        if (bl || pSDevServerBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getEnable()), (boolean)false);
        }
        if (bl || pSDevServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDevServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDevServerBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSDevServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam2()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam3()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam4()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam5()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam6()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam7()), (boolean)false);
        }
        if (bl || pSDevServerBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getParam8()), (boolean)false);
        }
        if (bl || pSDevServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDevServerBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDevServerBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDevServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDevServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDevServerBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSDevServerBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDevServerBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDevServerBase.getTimeShareMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timesharemode", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getTimeShareMode()), (boolean)false);
        }
        if (bl || pSDevServerBase.getTimeShareResSpec() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeshareresspec", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getTimeShareResSpec()), (boolean)false);
        }
        if (bl || pSDevServerBase.getTimeShareResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timesharerestype", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getTimeShareResType()), (boolean)false);
        }
        if (bl || pSDevServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDevServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSDevServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevServerBase.getJSONValue((Object)pSDevServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevServerBase pSDevServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevServerBase.getAdminPasswd() != null) {
            object = pSDevServerBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDevServerBase.getAdminUserName() != null) {
            object = pSDevServerBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getCreateDate() != null) {
            object = pSDevServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerBase.getCreateMan() != null) {
            object = pSDevServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getDSState() != null) {
            object = pSDevServerBase.getDSState();
            xmlNode.setAttribute(FIELD_DSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getDSType() != null) {
            object = pSDevServerBase.getDSType();
            xmlNode.setAttribute(FIELD_DSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getEnable() != null) {
            object = pSDevServerBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getIpAddr() != null) {
            object = pSDevServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getIpAddr2() != null) {
            object = pSDevServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getLocalRes() != null) {
            object = pSDevServerBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getMemo() != null) {
            object = pSDevServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getParam() != null) {
            object = pSDevServerBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getParam2() != null) {
            object = pSDevServerBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getParam3() != null) {
            object = pSDevServerBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getParam4() != null) {
            object = pSDevServerBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getParam5() != null) {
            object = pSDevServerBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getParam6() != null) {
            object = pSDevServerBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getParam7() != null) {
            object = pSDevServerBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getParam8() != null) {
            object = pSDevServerBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getPasswd() != null) {
            object = pSDevServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getPSDevServerId() != null) {
            object = pSDevServerBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getPSDevServerName() != null) {
            object = pSDevServerBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getPSSvrDomainId() != null) {
            object = pSDevServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getPSSvrDomainName() != null) {
            object = pSDevServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getRefInfo() != null) {
            object = pSDevServerBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getSSHIPAddr() != null) {
            object = pSDevServerBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getSSHPort() != null) {
            object = pSDevServerBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getTimeShareMode() != null) {
            object = pSDevServerBase.getTimeShareMode();
            xmlNode.setAttribute(FIELD_TIMESHAREMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevServerBase.getTimeShareResSpec() != null) {
            object = pSDevServerBase.getTimeShareResSpec();
            xmlNode.setAttribute(FIELD_TIMESHARERESSPEC, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getTimeShareResType() != null) {
            object = pSDevServerBase.getTimeShareResType();
            xmlNode.setAttribute(FIELD_TIMESHARERESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getUpdateDate() != null) {
            object = pSDevServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerBase.getUpdateMan() != null) {
            object = pSDevServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getUploadFileMode() != null) {
            object = pSDevServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getUserName() != null) {
            object = pSDevServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerBase.getValidFlag() != null) {
            object = pSDevServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevServerBase pSDevServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevServerBase.isAdminPasswdDirty() && (bl || pSDevServerBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDevServerBase.getAdminPasswd());
        }
        if (pSDevServerBase.isAdminUserNameDirty() && (bl || pSDevServerBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDevServerBase.getAdminUserName());
        }
        if (pSDevServerBase.isCreateDateDirty() && (bl || pSDevServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevServerBase.getCreateDate());
        }
        if (pSDevServerBase.isCreateManDirty() && (bl || pSDevServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevServerBase.getCreateMan());
        }
        if (pSDevServerBase.isDSStateDirty() && (bl || pSDevServerBase.getDSState() != null)) {
            iDataObject.set(FIELD_DSSTATE, (Object)pSDevServerBase.getDSState());
        }
        if (pSDevServerBase.isDSTypeDirty() && (bl || pSDevServerBase.getDSType() != null)) {
            iDataObject.set(FIELD_DSTYPE, (Object)pSDevServerBase.getDSType());
        }
        if (pSDevServerBase.isEnableDirty() && (bl || pSDevServerBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDevServerBase.getEnable());
        }
        if (pSDevServerBase.isIpAddrDirty() && (bl || pSDevServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDevServerBase.getIpAddr());
        }
        if (pSDevServerBase.isIpAddr2Dirty() && (bl || pSDevServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDevServerBase.getIpAddr2());
        }
        if (pSDevServerBase.isLocalResDirty() && (bl || pSDevServerBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSDevServerBase.getLocalRes());
        }
        if (pSDevServerBase.isMemoDirty() && (bl || pSDevServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevServerBase.getMemo());
        }
        if (pSDevServerBase.isParamDirty() && (bl || pSDevServerBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDevServerBase.getParam());
        }
        if (pSDevServerBase.isParam2Dirty() && (bl || pSDevServerBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDevServerBase.getParam2());
        }
        if (pSDevServerBase.isParam3Dirty() && (bl || pSDevServerBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDevServerBase.getParam3());
        }
        if (pSDevServerBase.isParam4Dirty() && (bl || pSDevServerBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDevServerBase.getParam4());
        }
        if (pSDevServerBase.isParam5Dirty() && (bl || pSDevServerBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSDevServerBase.getParam5());
        }
        if (pSDevServerBase.isParam6Dirty() && (bl || pSDevServerBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSDevServerBase.getParam6());
        }
        if (pSDevServerBase.isParam7Dirty() && (bl || pSDevServerBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSDevServerBase.getParam7());
        }
        if (pSDevServerBase.isParam8Dirty() && (bl || pSDevServerBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSDevServerBase.getParam8());
        }
        if (pSDevServerBase.isPasswdDirty() && (bl || pSDevServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDevServerBase.getPasswd());
        }
        if (pSDevServerBase.isPSDevServerIdDirty() && (bl || pSDevServerBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDevServerBase.getPSDevServerId());
        }
        if (pSDevServerBase.isPSDevServerNameDirty() && (bl || pSDevServerBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDevServerBase.getPSDevServerName());
        }
        if (pSDevServerBase.isPSSvrDomainIdDirty() && (bl || pSDevServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDevServerBase.getPSSvrDomainId());
        }
        if (pSDevServerBase.isPSSvrDomainNameDirty() && (bl || pSDevServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDevServerBase.getPSSvrDomainName());
        }
        if (pSDevServerBase.isRefInfoDirty() && (bl || pSDevServerBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSDevServerBase.getRefInfo());
        }
        if (pSDevServerBase.isSSHIPAddrDirty() && (bl || pSDevServerBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDevServerBase.getSSHIPAddr());
        }
        if (pSDevServerBase.isSSHPortDirty() && (bl || pSDevServerBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDevServerBase.getSSHPort());
        }
        if (pSDevServerBase.isTimeShareModeDirty() && (bl || pSDevServerBase.getTimeShareMode() != null)) {
            iDataObject.set(FIELD_TIMESHAREMODE, (Object)pSDevServerBase.getTimeShareMode());
        }
        if (pSDevServerBase.isTimeShareResSpecDirty() && (bl || pSDevServerBase.getTimeShareResSpec() != null)) {
            iDataObject.set(FIELD_TIMESHARERESSPEC, (Object)pSDevServerBase.getTimeShareResSpec());
        }
        if (pSDevServerBase.isTimeShareResTypeDirty() && (bl || pSDevServerBase.getTimeShareResType() != null)) {
            iDataObject.set(FIELD_TIMESHARERESTYPE, (Object)pSDevServerBase.getTimeShareResType());
        }
        if (pSDevServerBase.isUpdateDateDirty() && (bl || pSDevServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevServerBase.getUpdateDate());
        }
        if (pSDevServerBase.isUpdateManDirty() && (bl || pSDevServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevServerBase.getUpdateMan());
        }
        if (pSDevServerBase.isUploadFileModeDirty() && (bl || pSDevServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDevServerBase.getUploadFileMode());
        }
        if (pSDevServerBase.isUserNameDirty() && (bl || pSDevServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDevServerBase.getUserName());
        }
        if (pSDevServerBase.isValidFlagDirty() && (bl || pSDevServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevServerBase.getValidFlag());
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
        return PSDevServerBase.remove(this, n);
    }

    private static boolean remove(PSDevServerBase pSDevServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDevServerBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDevServerBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevServerBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevServerBase.resetDSState();
                return true;
            }
            case 5: {
                pSDevServerBase.resetDSType();
                return true;
            }
            case 6: {
                pSDevServerBase.resetEnable();
                return true;
            }
            case 7: {
                pSDevServerBase.resetIpAddr();
                return true;
            }
            case 8: {
                pSDevServerBase.resetIpAddr2();
                return true;
            }
            case 9: {
                pSDevServerBase.resetLocalRes();
                return true;
            }
            case 10: {
                pSDevServerBase.resetMemo();
                return true;
            }
            case 11: {
                pSDevServerBase.resetParam();
                return true;
            }
            case 12: {
                pSDevServerBase.resetParam2();
                return true;
            }
            case 13: {
                pSDevServerBase.resetParam3();
                return true;
            }
            case 14: {
                pSDevServerBase.resetParam4();
                return true;
            }
            case 15: {
                pSDevServerBase.resetParam5();
                return true;
            }
            case 16: {
                pSDevServerBase.resetParam6();
                return true;
            }
            case 17: {
                pSDevServerBase.resetParam7();
                return true;
            }
            case 18: {
                pSDevServerBase.resetParam8();
                return true;
            }
            case 19: {
                pSDevServerBase.resetPasswd();
                return true;
            }
            case 20: {
                pSDevServerBase.resetPSDevServerId();
                return true;
            }
            case 21: {
                pSDevServerBase.resetPSDevServerName();
                return true;
            }
            case 22: {
                pSDevServerBase.resetPSSvrDomainId();
                return true;
            }
            case 23: {
                pSDevServerBase.resetPSSvrDomainName();
                return true;
            }
            case 24: {
                pSDevServerBase.resetRefInfo();
                return true;
            }
            case 25: {
                pSDevServerBase.resetSSHIPAddr();
                return true;
            }
            case 26: {
                pSDevServerBase.resetSSHPort();
                return true;
            }
            case 27: {
                pSDevServerBase.resetTimeShareMode();
                return true;
            }
            case 28: {
                pSDevServerBase.resetTimeShareResSpec();
                return true;
            }
            case 29: {
                pSDevServerBase.resetTimeShareResType();
                return true;
            }
            case 30: {
                pSDevServerBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSDevServerBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSDevServerBase.resetUploadFileMode();
                return true;
            }
            case 33: {
                pSDevServerBase.resetUserName();
                return true;
            }
            case 34: {
                pSDevServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSDevServerBase getProxyEntity() {
        return this.proxyPSDevServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevServerBase) {
            this.proxyPSDevServerBase = (PSDevServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DSSTATE, 4);
        fieldIndexMap.put(FIELD_DSTYPE, 5);
        fieldIndexMap.put(FIELD_ENABLE, 6);
        fieldIndexMap.put(FIELD_IPADDR, 7);
        fieldIndexMap.put(FIELD_IPADDR2, 8);
        fieldIndexMap.put(FIELD_LOCALRES, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PARAM, 11);
        fieldIndexMap.put(FIELD_PARAM2, 12);
        fieldIndexMap.put(FIELD_PARAM3, 13);
        fieldIndexMap.put(FIELD_PARAM4, 14);
        fieldIndexMap.put(FIELD_PARAM5, 15);
        fieldIndexMap.put(FIELD_PARAM6, 16);
        fieldIndexMap.put(FIELD_PARAM7, 17);
        fieldIndexMap.put(FIELD_PARAM8, 18);
        fieldIndexMap.put(FIELD_PASSWD, 19);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 20);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 21);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 22);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 23);
        fieldIndexMap.put(FIELD_REFINFO, 24);
        fieldIndexMap.put(FIELD_SSHIPADDR, 25);
        fieldIndexMap.put(FIELD_SSHPORT, 26);
        fieldIndexMap.put(FIELD_TIMESHAREMODE, 27);
        fieldIndexMap.put(FIELD_TIMESHARERESSPEC, 28);
        fieldIndexMap.put(FIELD_TIMESHARERESTYPE, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 32);
        fieldIndexMap.put(FIELD_USERNAME, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

