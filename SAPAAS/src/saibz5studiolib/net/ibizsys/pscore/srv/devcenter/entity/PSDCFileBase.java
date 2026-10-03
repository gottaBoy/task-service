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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCFileBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_FILEPATH = "FILEPATH";
    public static final String FIELD_FSTYPE = "FSTYPE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_EXPRIEDTIME = 4;
    private static final int INDEX_FILEPATH = 5;
    private static final int INDEX_FSTYPE = 6;
    private static final int INDEX_IPADDR = 7;
    private static final int INDEX_IPADDR2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PASSWD = 10;
    private static final int INDEX_PSCREDENTIALID = 11;
    private static final int INDEX_PSCREDENTIALNAME = 12;
    private static final int INDEX_PSDCFILEID = 13;
    private static final int INDEX_PSDCFILENAME = 14;
    private static final int INDEX_PSDEVCENTERID = 15;
    private static final int INDEX_PSDEVCENTERNAME = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDEVSLNNAME = 18;
    private static final int INDEX_REFCOUNT = 19;
    private static final int INDEX_RESPOS = 20;
    private static final int INDEX_RESREADYTIME = 21;
    private static final int INDEX_RESSTATE = 22;
    private static final int INDEX_RESVER = 23;
    private static final int INDEX_SSHIPADDR = 24;
    private static final int INDEX_SSHPORT = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERNAME = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCFileBase proxyPSDCFileBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean filepathDirtyFlag = false;
    private boolean fstypeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="filepath")
    private String filepath;
    @Column(name="fstype")
    private String fstype;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
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
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filepath = string;
        this.filepathDirtyFlag = true;
    }

    public String getFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePath();
        }
        return this.filepath;
    }

    public boolean isFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilePathDirty();
        }
        return this.filepathDirtyFlag;
    }

    public void resetFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilePath();
            return;
        }
        this.filepathDirtyFlag = false;
        this.filepath = null;
    }

    public void setFSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fstype = string;
        this.fstypeDirtyFlag = true;
    }

    public String getFSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFSType();
        }
        return this.fstype;
    }

    public boolean isFSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFSTypeDirty();
        }
        return this.fstypeDirtyFlag;
    }

    public void resetFSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFSType();
            return;
        }
        this.fstypeDirtyFlag = false;
        this.fstype = null;
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

    public void setPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialid = string;
        this.pscredentialidDirtyFlag = true;
    }

    public String getPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialId();
        }
        return this.pscredentialid;
    }

    public boolean isPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialIdDirty();
        }
        return this.pscredentialidDirtyFlag;
    }

    public void resetPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialId();
            return;
        }
        this.pscredentialidDirtyFlag = false;
        this.pscredentialid = null;
    }

    public void setPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialname = string;
        this.pscredentialnameDirtyFlag = true;
    }

    public String getPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialName();
        }
        return this.pscredentialname;
    }

    public boolean isPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialNameDirty();
        }
        return this.pscredentialnameDirtyFlag;
    }

    public void resetPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialName();
            return;
        }
        this.pscredentialnameDirtyFlag = false;
        this.pscredentialname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
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

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
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
        PSDCFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCFileBase pSDCFileBase) {
        pSDCFileBase.resetAdminPasswd();
        pSDCFileBase.resetAdminUserName();
        pSDCFileBase.resetCreateDate();
        pSDCFileBase.resetCreateMan();
        pSDCFileBase.resetExpriedTime();
        pSDCFileBase.resetFilePath();
        pSDCFileBase.resetFSType();
        pSDCFileBase.resetIpAddr();
        pSDCFileBase.resetIpAddr2();
        pSDCFileBase.resetMemo();
        pSDCFileBase.resetPasswd();
        pSDCFileBase.resetPSCredentialId();
        pSDCFileBase.resetPSCredentialName();
        pSDCFileBase.resetPSDCFileId();
        pSDCFileBase.resetPSDCFileName();
        pSDCFileBase.resetPSDevCenterId();
        pSDCFileBase.resetPSDevCenterName();
        pSDCFileBase.resetPSDevSlnId();
        pSDCFileBase.resetPSDevSlnName();
        pSDCFileBase.resetRefCount();
        pSDCFileBase.resetResPos();
        pSDCFileBase.resetResReadyTime();
        pSDCFileBase.resetResState();
        pSDCFileBase.resetResVer();
        pSDCFileBase.resetSSHIPAddr();
        pSDCFileBase.resetSSHPort();
        pSDCFileBase.resetUpdateDate();
        pSDCFileBase.resetUpdateMan();
        pSDCFileBase.resetUserName();
        pSDCFileBase.resetUserTag();
        pSDCFileBase.resetUserTag2();
        pSDCFileBase.resetUserTag3();
        pSDCFileBase.resetUserTag4();
        pSDCFileBase.resetValidFlag();
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
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isFilePathDirty()) {
            hashMap.put(FIELD_FILEPATH, this.getFilePath());
        }
        if (!bl || this.isFSTypeDirty()) {
            hashMap.put(FIELD_FSTYPE, this.getFSType());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSDCFileBase.get(this, n);
    }

    private static Object get(PSDCFileBase pSDCFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCFileBase.getAdminPasswd();
            }
            case 1: {
                return pSDCFileBase.getAdminUserName();
            }
            case 2: {
                return pSDCFileBase.getCreateDate();
            }
            case 3: {
                return pSDCFileBase.getCreateMan();
            }
            case 4: {
                return pSDCFileBase.getExpriedTime();
            }
            case 5: {
                return pSDCFileBase.getFilePath();
            }
            case 6: {
                return pSDCFileBase.getFSType();
            }
            case 7: {
                return pSDCFileBase.getIpAddr();
            }
            case 8: {
                return pSDCFileBase.getIpAddr2();
            }
            case 9: {
                return pSDCFileBase.getMemo();
            }
            case 10: {
                return pSDCFileBase.getPasswd();
            }
            case 11: {
                return pSDCFileBase.getPSCredentialId();
            }
            case 12: {
                return pSDCFileBase.getPSCredentialName();
            }
            case 13: {
                return pSDCFileBase.getPSDCFileId();
            }
            case 14: {
                return pSDCFileBase.getPSDCFileName();
            }
            case 15: {
                return pSDCFileBase.getPSDevCenterId();
            }
            case 16: {
                return pSDCFileBase.getPSDevCenterName();
            }
            case 17: {
                return pSDCFileBase.getPSDevSlnId();
            }
            case 18: {
                return pSDCFileBase.getPSDevSlnName();
            }
            case 19: {
                return pSDCFileBase.getRefCount();
            }
            case 20: {
                return pSDCFileBase.getResPos();
            }
            case 21: {
                return pSDCFileBase.getResReadyTime();
            }
            case 22: {
                return pSDCFileBase.getResState();
            }
            case 23: {
                return pSDCFileBase.getResVer();
            }
            case 24: {
                return pSDCFileBase.getSSHIPAddr();
            }
            case 25: {
                return pSDCFileBase.getSSHPort();
            }
            case 26: {
                return pSDCFileBase.getUpdateDate();
            }
            case 27: {
                return pSDCFileBase.getUpdateMan();
            }
            case 28: {
                return pSDCFileBase.getUserName();
            }
            case 29: {
                return pSDCFileBase.getUserTag();
            }
            case 30: {
                return pSDCFileBase.getUserTag2();
            }
            case 31: {
                return pSDCFileBase.getUserTag3();
            }
            case 32: {
                return pSDCFileBase.getUserTag4();
            }
            case 33: {
                return pSDCFileBase.getValidFlag();
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
        PSDCFileBase.set(this, n, object);
    }

    private static void set(PSDCFileBase pSDCFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCFileBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCFileBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCFileBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDCFileBase.setFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCFileBase.setFSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCFileBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCFileBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCFileBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCFileBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCFileBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCFileBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCFileBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCFileBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCFileBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCFileBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCFileBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCFileBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDCFileBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDCFileBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDCFileBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCFileBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCFileBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCFileBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDCFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDCFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCFileBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCFileBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCFileBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCFileBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCFileBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCFileBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCFileBase.isNull(this, n);
    }

    private static boolean isNull(PSDCFileBase pSDCFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCFileBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDCFileBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDCFileBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCFileBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCFileBase.getExpriedTime() == null;
            }
            case 5: {
                return pSDCFileBase.getFilePath() == null;
            }
            case 6: {
                return pSDCFileBase.getFSType() == null;
            }
            case 7: {
                return pSDCFileBase.getIpAddr() == null;
            }
            case 8: {
                return pSDCFileBase.getIpAddr2() == null;
            }
            case 9: {
                return pSDCFileBase.getMemo() == null;
            }
            case 10: {
                return pSDCFileBase.getPasswd() == null;
            }
            case 11: {
                return pSDCFileBase.getPSCredentialId() == null;
            }
            case 12: {
                return pSDCFileBase.getPSCredentialName() == null;
            }
            case 13: {
                return pSDCFileBase.getPSDCFileId() == null;
            }
            case 14: {
                return pSDCFileBase.getPSDCFileName() == null;
            }
            case 15: {
                return pSDCFileBase.getPSDevCenterId() == null;
            }
            case 16: {
                return pSDCFileBase.getPSDevCenterName() == null;
            }
            case 17: {
                return pSDCFileBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSDCFileBase.getPSDevSlnName() == null;
            }
            case 19: {
                return pSDCFileBase.getRefCount() == null;
            }
            case 20: {
                return pSDCFileBase.getResPos() == null;
            }
            case 21: {
                return pSDCFileBase.getResReadyTime() == null;
            }
            case 22: {
                return pSDCFileBase.getResState() == null;
            }
            case 23: {
                return pSDCFileBase.getResVer() == null;
            }
            case 24: {
                return pSDCFileBase.getSSHIPAddr() == null;
            }
            case 25: {
                return pSDCFileBase.getSSHPort() == null;
            }
            case 26: {
                return pSDCFileBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDCFileBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDCFileBase.getUserName() == null;
            }
            case 29: {
                return pSDCFileBase.getUserTag() == null;
            }
            case 30: {
                return pSDCFileBase.getUserTag2() == null;
            }
            case 31: {
                return pSDCFileBase.getUserTag3() == null;
            }
            case 32: {
                return pSDCFileBase.getUserTag4() == null;
            }
            case 33: {
                return pSDCFileBase.getValidFlag() == null;
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
        return PSDCFileBase.contains(this, n);
    }

    private static boolean contains(PSDCFileBase pSDCFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCFileBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDCFileBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDCFileBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCFileBase.isCreateManDirty();
            }
            case 4: {
                return pSDCFileBase.isExpriedTimeDirty();
            }
            case 5: {
                return pSDCFileBase.isFilePathDirty();
            }
            case 6: {
                return pSDCFileBase.isFSTypeDirty();
            }
            case 7: {
                return pSDCFileBase.isIpAddrDirty();
            }
            case 8: {
                return pSDCFileBase.isIpAddr2Dirty();
            }
            case 9: {
                return pSDCFileBase.isMemoDirty();
            }
            case 10: {
                return pSDCFileBase.isPasswdDirty();
            }
            case 11: {
                return pSDCFileBase.isPSCredentialIdDirty();
            }
            case 12: {
                return pSDCFileBase.isPSCredentialNameDirty();
            }
            case 13: {
                return pSDCFileBase.isPSDCFileIdDirty();
            }
            case 14: {
                return pSDCFileBase.isPSDCFileNameDirty();
            }
            case 15: {
                return pSDCFileBase.isPSDevCenterIdDirty();
            }
            case 16: {
                return pSDCFileBase.isPSDevCenterNameDirty();
            }
            case 17: {
                return pSDCFileBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSDCFileBase.isPSDevSlnNameDirty();
            }
            case 19: {
                return pSDCFileBase.isRefCountDirty();
            }
            case 20: {
                return pSDCFileBase.isResPosDirty();
            }
            case 21: {
                return pSDCFileBase.isResReadyTimeDirty();
            }
            case 22: {
                return pSDCFileBase.isResStateDirty();
            }
            case 23: {
                return pSDCFileBase.isResVerDirty();
            }
            case 24: {
                return pSDCFileBase.isSSHIPAddrDirty();
            }
            case 25: {
                return pSDCFileBase.isSSHPortDirty();
            }
            case 26: {
                return pSDCFileBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDCFileBase.isUpdateManDirty();
            }
            case 28: {
                return pSDCFileBase.isUserNameDirty();
            }
            case 29: {
                return pSDCFileBase.isUserTagDirty();
            }
            case 30: {
                return pSDCFileBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDCFileBase.isUserTag3Dirty();
            }
            case 32: {
                return pSDCFileBase.isUserTag4Dirty();
            }
            case 33: {
                return pSDCFileBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCFileBase pSDCFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCFileBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDCFileBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCFileBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCFileBase.getFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filepath", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getFilePath()), (boolean)false);
        }
        if (bl || pSDCFileBase.getFSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fstype", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getFSType()), (boolean)false);
        }
        if (bl || pSDCFileBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCFileBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCFileBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCFileBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCFileBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCFileBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getResState()), (boolean)false);
        }
        if (bl || pSDCFileBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCFileBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCFileBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCFileBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCFileBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCFileBase.getJSONValue((Object)pSDCFileBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCFileBase pSDCFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCFileBase.getAdminPasswd() != null) {
            object = pSDCFileBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDCFileBase.getAdminUserName() != null) {
            object = pSDCFileBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getCreateDate() != null) {
            object = pSDCFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCFileBase.getCreateMan() != null) {
            object = pSDCFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getExpriedTime() != null) {
            object = pSDCFileBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCFileBase.getFilePath() != null) {
            object = pSDCFileBase.getFilePath();
            xmlNode.setAttribute(FIELD_FILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getFSType() != null) {
            object = pSDCFileBase.getFSType();
            xmlNode.setAttribute(FIELD_FSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getIpAddr() != null) {
            object = pSDCFileBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getIpAddr2() != null) {
            object = pSDCFileBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getMemo() != null) {
            object = pSDCFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPasswd() != null) {
            object = pSDCFileBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSCredentialId() != null) {
            object = pSDCFileBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSCredentialName() != null) {
            object = pSDCFileBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDCFileId() != null) {
            object = pSDCFileBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDCFileName() != null) {
            object = pSDCFileBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDevCenterId() != null) {
            object = pSDCFileBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDevCenterName() != null) {
            object = pSDCFileBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDevSlnId() != null) {
            object = pSDCFileBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getPSDevSlnName() != null) {
            object = pSDCFileBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getRefCount() != null) {
            object = pSDCFileBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCFileBase.getResPos() != null) {
            object = pSDCFileBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCFileBase.getResReadyTime() != null) {
            object = pSDCFileBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCFileBase.getResState() != null) {
            object = pSDCFileBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCFileBase.getResVer() != null) {
            object = pSDCFileBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCFileBase.getSSHIPAddr() != null) {
            object = pSDCFileBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getSSHPort() != null) {
            object = pSDCFileBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCFileBase.getUpdateDate() != null) {
            object = pSDCFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCFileBase.getUpdateMan() != null) {
            object = pSDCFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getUserName() != null) {
            object = pSDCFileBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getUserTag() != null) {
            object = pSDCFileBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getUserTag2() != null) {
            object = pSDCFileBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getUserTag3() != null) {
            object = pSDCFileBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getUserTag4() != null) {
            object = pSDCFileBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCFileBase.getValidFlag() != null) {
            object = pSDCFileBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCFileBase pSDCFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCFileBase.isAdminPasswdDirty() && (bl || pSDCFileBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDCFileBase.getAdminPasswd());
        }
        if (pSDCFileBase.isAdminUserNameDirty() && (bl || pSDCFileBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDCFileBase.getAdminUserName());
        }
        if (pSDCFileBase.isCreateDateDirty() && (bl || pSDCFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCFileBase.getCreateDate());
        }
        if (pSDCFileBase.isCreateManDirty() && (bl || pSDCFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCFileBase.getCreateMan());
        }
        if (pSDCFileBase.isExpriedTimeDirty() && (bl || pSDCFileBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCFileBase.getExpriedTime());
        }
        if (pSDCFileBase.isFilePathDirty() && (bl || pSDCFileBase.getFilePath() != null)) {
            iDataObject.set(FIELD_FILEPATH, (Object)pSDCFileBase.getFilePath());
        }
        if (pSDCFileBase.isFSTypeDirty() && (bl || pSDCFileBase.getFSType() != null)) {
            iDataObject.set(FIELD_FSTYPE, (Object)pSDCFileBase.getFSType());
        }
        if (pSDCFileBase.isIpAddrDirty() && (bl || pSDCFileBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCFileBase.getIpAddr());
        }
        if (pSDCFileBase.isIpAddr2Dirty() && (bl || pSDCFileBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCFileBase.getIpAddr2());
        }
        if (pSDCFileBase.isMemoDirty() && (bl || pSDCFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCFileBase.getMemo());
        }
        if (pSDCFileBase.isPasswdDirty() && (bl || pSDCFileBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCFileBase.getPasswd());
        }
        if (pSDCFileBase.isPSCredentialIdDirty() && (bl || pSDCFileBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDCFileBase.getPSCredentialId());
        }
        if (pSDCFileBase.isPSCredentialNameDirty() && (bl || pSDCFileBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDCFileBase.getPSCredentialName());
        }
        if (pSDCFileBase.isPSDCFileIdDirty() && (bl || pSDCFileBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCFileBase.getPSDCFileId());
        }
        if (pSDCFileBase.isPSDCFileNameDirty() && (bl || pSDCFileBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCFileBase.getPSDCFileName());
        }
        if (pSDCFileBase.isPSDevCenterIdDirty() && (bl || pSDCFileBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCFileBase.getPSDevCenterId());
        }
        if (pSDCFileBase.isPSDevCenterNameDirty() && (bl || pSDCFileBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCFileBase.getPSDevCenterName());
        }
        if (pSDCFileBase.isPSDevSlnIdDirty() && (bl || pSDCFileBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCFileBase.getPSDevSlnId());
        }
        if (pSDCFileBase.isPSDevSlnNameDirty() && (bl || pSDCFileBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCFileBase.getPSDevSlnName());
        }
        if (pSDCFileBase.isRefCountDirty() && (bl || pSDCFileBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCFileBase.getRefCount());
        }
        if (pSDCFileBase.isResPosDirty() && (bl || pSDCFileBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCFileBase.getResPos());
        }
        if (pSDCFileBase.isResReadyTimeDirty() && (bl || pSDCFileBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCFileBase.getResReadyTime());
        }
        if (pSDCFileBase.isResStateDirty() && (bl || pSDCFileBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCFileBase.getResState());
        }
        if (pSDCFileBase.isResVerDirty() && (bl || pSDCFileBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCFileBase.getResVer());
        }
        if (pSDCFileBase.isSSHIPAddrDirty() && (bl || pSDCFileBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCFileBase.getSSHIPAddr());
        }
        if (pSDCFileBase.isSSHPortDirty() && (bl || pSDCFileBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCFileBase.getSSHPort());
        }
        if (pSDCFileBase.isUpdateDateDirty() && (bl || pSDCFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCFileBase.getUpdateDate());
        }
        if (pSDCFileBase.isUpdateManDirty() && (bl || pSDCFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCFileBase.getUpdateMan());
        }
        if (pSDCFileBase.isUserNameDirty() && (bl || pSDCFileBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCFileBase.getUserName());
        }
        if (pSDCFileBase.isUserTagDirty() && (bl || pSDCFileBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCFileBase.getUserTag());
        }
        if (pSDCFileBase.isUserTag2Dirty() && (bl || pSDCFileBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCFileBase.getUserTag2());
        }
        if (pSDCFileBase.isUserTag3Dirty() && (bl || pSDCFileBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCFileBase.getUserTag3());
        }
        if (pSDCFileBase.isUserTag4Dirty() && (bl || pSDCFileBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCFileBase.getUserTag4());
        }
        if (pSDCFileBase.isValidFlagDirty() && (bl || pSDCFileBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCFileBase.getValidFlag());
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
        return PSDCFileBase.remove(this, n);
    }

    private static boolean remove(PSDCFileBase pSDCFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCFileBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDCFileBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDCFileBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCFileBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCFileBase.resetExpriedTime();
                return true;
            }
            case 5: {
                pSDCFileBase.resetFilePath();
                return true;
            }
            case 6: {
                pSDCFileBase.resetFSType();
                return true;
            }
            case 7: {
                pSDCFileBase.resetIpAddr();
                return true;
            }
            case 8: {
                pSDCFileBase.resetIpAddr2();
                return true;
            }
            case 9: {
                pSDCFileBase.resetMemo();
                return true;
            }
            case 10: {
                pSDCFileBase.resetPasswd();
                return true;
            }
            case 11: {
                pSDCFileBase.resetPSCredentialId();
                return true;
            }
            case 12: {
                pSDCFileBase.resetPSCredentialName();
                return true;
            }
            case 13: {
                pSDCFileBase.resetPSDCFileId();
                return true;
            }
            case 14: {
                pSDCFileBase.resetPSDCFileName();
                return true;
            }
            case 15: {
                pSDCFileBase.resetPSDevCenterId();
                return true;
            }
            case 16: {
                pSDCFileBase.resetPSDevCenterName();
                return true;
            }
            case 17: {
                pSDCFileBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSDCFileBase.resetPSDevSlnName();
                return true;
            }
            case 19: {
                pSDCFileBase.resetRefCount();
                return true;
            }
            case 20: {
                pSDCFileBase.resetResPos();
                return true;
            }
            case 21: {
                pSDCFileBase.resetResReadyTime();
                return true;
            }
            case 22: {
                pSDCFileBase.resetResState();
                return true;
            }
            case 23: {
                pSDCFileBase.resetResVer();
                return true;
            }
            case 24: {
                pSDCFileBase.resetSSHIPAddr();
                return true;
            }
            case 25: {
                pSDCFileBase.resetSSHPort();
                return true;
            }
            case 26: {
                pSDCFileBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDCFileBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDCFileBase.resetUserName();
                return true;
            }
            case 29: {
                pSDCFileBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDCFileBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDCFileBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSDCFileBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSDCFileBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredential();
        }
        if (this.getPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objPSCredentialLock;
        synchronized (n) {
            if (this.pscredential != null && DataTypeHelper.compare((int)25, (Object)this.getPSCredentialId(), (Object)this.pscredential.getPSCredentialId()) != 0L) {
                this.pscredential = null;
            }
            if (this.pscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet(pSCredential);
                this.pscredential = pSCredential;
            }
            return this.pscredential;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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

    private PSDCFileBase getProxyEntity() {
        return this.proxyPSDCFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCFileBase) {
            this.proxyPSDCFileBase = (PSDCFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 4);
        fieldIndexMap.put(FIELD_FILEPATH, 5);
        fieldIndexMap.put(FIELD_FSTYPE, 6);
        fieldIndexMap.put(FIELD_IPADDR, 7);
        fieldIndexMap.put(FIELD_IPADDR2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PASSWD, 10);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 11);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 12);
        fieldIndexMap.put(FIELD_PSDCFILEID, 13);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 18);
        fieldIndexMap.put(FIELD_REFCOUNT, 19);
        fieldIndexMap.put(FIELD_RESPOS, 20);
        fieldIndexMap.put(FIELD_RESREADYTIME, 21);
        fieldIndexMap.put(FIELD_RESSTATE, 22);
        fieldIndexMap.put(FIELD_RESVER, 23);
        fieldIndexMap.put(FIELD_SSHIPADDR, 24);
        fieldIndexMap.put(FIELD_SSHPORT, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERNAME, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

