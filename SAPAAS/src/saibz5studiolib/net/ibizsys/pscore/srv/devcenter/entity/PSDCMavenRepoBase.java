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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMavenRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMavenRepoBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MAVENPASSWD = "MAVENPASSWD";
    public static final String FIELD_MAVENUSERNAME = "MAVENUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PSDCMAVENREPOID = "PSDCMAVENREPOID";
    public static final String FIELD_PSDCMAVENREPONAME = "PSDCMAVENREPONAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_ROPASSWD = "ROPASSWD";
    public static final String FIELD_ROUSERNAME = "ROUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MAVENPASSWD = 4;
    private static final int INDEX_MAVENUSERNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PARAM = 7;
    private static final int INDEX_PARAM2 = 8;
    private static final int INDEX_PARAM3 = 9;
    private static final int INDEX_PARAM4 = 10;
    private static final int INDEX_PSDCMAVENREPOID = 11;
    private static final int INDEX_PSDCMAVENREPONAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNNAME = 16;
    private static final int INDEX_ROPASSWD = 17;
    private static final int INDEX_ROUSERNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMavenRepoBase proxyPSDCMavenRepoBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean mavenpasswdDirtyFlag = false;
    private boolean mavenusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean psdcmavenrepoidDirtyFlag = false;
    private boolean psdcmavenreponameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean ropasswdDirtyFlag = false;
    private boolean rousernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="mavenpasswd")
    private String mavenpasswd;
    @Column(name="mavenusername")
    private String mavenusername;
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
    @Column(name="psdcmavenrepoid")
    private String psdcmavenrepoid;
    @Column(name="psdcmavenreponame")
    private String psdcmavenreponame;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="ropasswd")
    private String ropasswd;
    @Column(name="rousername")
    private String rousername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setMavenPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenpasswd = string;
        this.mavenpasswdDirtyFlag = true;
    }

    public String getMavenPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenPasswd();
        }
        return this.mavenpasswd;
    }

    public boolean isMavenPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenPasswdDirty();
        }
        return this.mavenpasswdDirtyFlag;
    }

    public void resetMavenPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenPasswd();
            return;
        }
        this.mavenpasswdDirtyFlag = false;
        this.mavenpasswd = null;
    }

    public void setMavenUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mavenusername = string;
        this.mavenusernameDirtyFlag = true;
    }

    public String getMavenUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenUserName();
        }
        return this.mavenusername;
    }

    public boolean isMavenUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenUserNameDirty();
        }
        return this.mavenusernameDirtyFlag;
    }

    public void resetMavenUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenUserName();
            return;
        }
        this.mavenusernameDirtyFlag = false;
        this.mavenusername = null;
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

    public void setPSDCMavenRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMavenRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmavenrepoid = string;
        this.psdcmavenrepoidDirtyFlag = true;
    }

    public String getPSDCMavenRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMavenRepoId();
        }
        return this.psdcmavenrepoid;
    }

    public boolean isPSDCMavenRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMavenRepoIdDirty();
        }
        return this.psdcmavenrepoidDirtyFlag;
    }

    public void resetPSDCMavenRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMavenRepoId();
            return;
        }
        this.psdcmavenrepoidDirtyFlag = false;
        this.psdcmavenrepoid = null;
    }

    public void setPSDCMavenRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMavenRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmavenreponame = string;
        this.psdcmavenreponameDirtyFlag = true;
    }

    public String getPSDCMavenRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMavenRepoName();
        }
        return this.psdcmavenreponame;
    }

    public boolean isPSDCMavenRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMavenRepoNameDirty();
        }
        return this.psdcmavenreponameDirtyFlag;
    }

    public void resetPSDCMavenRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMavenRepoName();
            return;
        }
        this.psdcmavenreponameDirtyFlag = false;
        this.psdcmavenreponame = null;
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

    public void setROPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropasswd = string;
        this.ropasswdDirtyFlag = true;
    }

    public String getROPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPasswd();
        }
        return this.ropasswd;
    }

    public boolean isROPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPasswdDirty();
        }
        return this.ropasswdDirtyFlag;
    }

    public void resetROPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPasswd();
            return;
        }
        this.ropasswdDirtyFlag = false;
        this.ropasswd = null;
    }

    public void setROUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rousername = string;
        this.rousernameDirtyFlag = true;
    }

    public String getROUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROUserName();
        }
        return this.rousername;
    }

    public boolean isROUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROUserNameDirty();
        }
        return this.rousernameDirtyFlag;
    }

    public void resetROUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROUserName();
            return;
        }
        this.rousernameDirtyFlag = false;
        this.rousername = null;
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
        PSDCMavenRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMavenRepoBase pSDCMavenRepoBase) {
        pSDCMavenRepoBase.resetConnStr();
        pSDCMavenRepoBase.resetCreateDate();
        pSDCMavenRepoBase.resetCreateMan();
        pSDCMavenRepoBase.resetDefaultFlag();
        pSDCMavenRepoBase.resetMavenPasswd();
        pSDCMavenRepoBase.resetMavenUserName();
        pSDCMavenRepoBase.resetMemo();
        pSDCMavenRepoBase.resetParam();
        pSDCMavenRepoBase.resetParam2();
        pSDCMavenRepoBase.resetParam3();
        pSDCMavenRepoBase.resetParam4();
        pSDCMavenRepoBase.resetPSDCMavenRepoId();
        pSDCMavenRepoBase.resetPSDCMavenRepoName();
        pSDCMavenRepoBase.resetPSDevCenterId();
        pSDCMavenRepoBase.resetPSDevCenterName();
        pSDCMavenRepoBase.resetPSDevSlnId();
        pSDCMavenRepoBase.resetPSDevSlnName();
        pSDCMavenRepoBase.resetROPasswd();
        pSDCMavenRepoBase.resetROUserName();
        pSDCMavenRepoBase.resetUpdateDate();
        pSDCMavenRepoBase.resetUpdateMan();
        pSDCMavenRepoBase.resetUserTag();
        pSDCMavenRepoBase.resetUserTag2();
        pSDCMavenRepoBase.resetUserTag3();
        pSDCMavenRepoBase.resetUserTag4();
        pSDCMavenRepoBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
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
        if (!bl || this.isMavenPasswdDirty()) {
            hashMap.put(FIELD_MAVENPASSWD, this.getMavenPasswd());
        }
        if (!bl || this.isMavenUserNameDirty()) {
            hashMap.put(FIELD_MAVENUSERNAME, this.getMavenUserName());
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
        if (!bl || this.isPSDCMavenRepoIdDirty()) {
            hashMap.put(FIELD_PSDCMAVENREPOID, this.getPSDCMavenRepoId());
        }
        if (!bl || this.isPSDCMavenRepoNameDirty()) {
            hashMap.put(FIELD_PSDCMAVENREPONAME, this.getPSDCMavenRepoName());
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
        if (!bl || this.isROPasswdDirty()) {
            hashMap.put(FIELD_ROPASSWD, this.getROPasswd());
        }
        if (!bl || this.isROUserNameDirty()) {
            hashMap.put(FIELD_ROUSERNAME, this.getROUserName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCMavenRepoBase.get(this, n);
    }

    private static Object get(PSDCMavenRepoBase pSDCMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMavenRepoBase.getConnStr();
            }
            case 1: {
                return pSDCMavenRepoBase.getCreateDate();
            }
            case 2: {
                return pSDCMavenRepoBase.getCreateMan();
            }
            case 3: {
                return pSDCMavenRepoBase.getDefaultFlag();
            }
            case 4: {
                return pSDCMavenRepoBase.getMavenPasswd();
            }
            case 5: {
                return pSDCMavenRepoBase.getMavenUserName();
            }
            case 6: {
                return pSDCMavenRepoBase.getMemo();
            }
            case 7: {
                return pSDCMavenRepoBase.getParam();
            }
            case 8: {
                return pSDCMavenRepoBase.getParam2();
            }
            case 9: {
                return pSDCMavenRepoBase.getParam3();
            }
            case 10: {
                return pSDCMavenRepoBase.getParam4();
            }
            case 11: {
                return pSDCMavenRepoBase.getPSDCMavenRepoId();
            }
            case 12: {
                return pSDCMavenRepoBase.getPSDCMavenRepoName();
            }
            case 13: {
                return pSDCMavenRepoBase.getPSDevCenterId();
            }
            case 14: {
                return pSDCMavenRepoBase.getPSDevCenterName();
            }
            case 15: {
                return pSDCMavenRepoBase.getPSDevSlnId();
            }
            case 16: {
                return pSDCMavenRepoBase.getPSDevSlnName();
            }
            case 17: {
                return pSDCMavenRepoBase.getROPasswd();
            }
            case 18: {
                return pSDCMavenRepoBase.getROUserName();
            }
            case 19: {
                return pSDCMavenRepoBase.getUpdateDate();
            }
            case 20: {
                return pSDCMavenRepoBase.getUpdateMan();
            }
            case 21: {
                return pSDCMavenRepoBase.getUserTag();
            }
            case 22: {
                return pSDCMavenRepoBase.getUserTag2();
            }
            case 23: {
                return pSDCMavenRepoBase.getUserTag3();
            }
            case 24: {
                return pSDCMavenRepoBase.getUserTag4();
            }
            case 25: {
                return pSDCMavenRepoBase.getValidFlag();
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
        PSDCMavenRepoBase.set(this, n, object);
    }

    private static void set(PSDCMavenRepoBase pSDCMavenRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMavenRepoBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCMavenRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCMavenRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMavenRepoBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCMavenRepoBase.setMavenPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMavenRepoBase.setMavenUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMavenRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMavenRepoBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMavenRepoBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMavenRepoBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMavenRepoBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCMavenRepoBase.setPSDCMavenRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCMavenRepoBase.setPSDCMavenRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCMavenRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMavenRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCMavenRepoBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCMavenRepoBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCMavenRepoBase.setROPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCMavenRepoBase.setROUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCMavenRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDCMavenRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCMavenRepoBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCMavenRepoBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCMavenRepoBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCMavenRepoBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCMavenRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCMavenRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMavenRepoBase pSDCMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMavenRepoBase.getConnStr() == null;
            }
            case 1: {
                return pSDCMavenRepoBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCMavenRepoBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCMavenRepoBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSDCMavenRepoBase.getMavenPasswd() == null;
            }
            case 5: {
                return pSDCMavenRepoBase.getMavenUserName() == null;
            }
            case 6: {
                return pSDCMavenRepoBase.getMemo() == null;
            }
            case 7: {
                return pSDCMavenRepoBase.getParam() == null;
            }
            case 8: {
                return pSDCMavenRepoBase.getParam2() == null;
            }
            case 9: {
                return pSDCMavenRepoBase.getParam3() == null;
            }
            case 10: {
                return pSDCMavenRepoBase.getParam4() == null;
            }
            case 11: {
                return pSDCMavenRepoBase.getPSDCMavenRepoId() == null;
            }
            case 12: {
                return pSDCMavenRepoBase.getPSDCMavenRepoName() == null;
            }
            case 13: {
                return pSDCMavenRepoBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDCMavenRepoBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDCMavenRepoBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDCMavenRepoBase.getPSDevSlnName() == null;
            }
            case 17: {
                return pSDCMavenRepoBase.getROPasswd() == null;
            }
            case 18: {
                return pSDCMavenRepoBase.getROUserName() == null;
            }
            case 19: {
                return pSDCMavenRepoBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDCMavenRepoBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDCMavenRepoBase.getUserTag() == null;
            }
            case 22: {
                return pSDCMavenRepoBase.getUserTag2() == null;
            }
            case 23: {
                return pSDCMavenRepoBase.getUserTag3() == null;
            }
            case 24: {
                return pSDCMavenRepoBase.getUserTag4() == null;
            }
            case 25: {
                return pSDCMavenRepoBase.getValidFlag() == null;
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
        return PSDCMavenRepoBase.contains(this, n);
    }

    private static boolean contains(PSDCMavenRepoBase pSDCMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMavenRepoBase.isConnStrDirty();
            }
            case 1: {
                return pSDCMavenRepoBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCMavenRepoBase.isCreateManDirty();
            }
            case 3: {
                return pSDCMavenRepoBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSDCMavenRepoBase.isMavenPasswdDirty();
            }
            case 5: {
                return pSDCMavenRepoBase.isMavenUserNameDirty();
            }
            case 6: {
                return pSDCMavenRepoBase.isMemoDirty();
            }
            case 7: {
                return pSDCMavenRepoBase.isParamDirty();
            }
            case 8: {
                return pSDCMavenRepoBase.isParam2Dirty();
            }
            case 9: {
                return pSDCMavenRepoBase.isParam3Dirty();
            }
            case 10: {
                return pSDCMavenRepoBase.isParam4Dirty();
            }
            case 11: {
                return pSDCMavenRepoBase.isPSDCMavenRepoIdDirty();
            }
            case 12: {
                return pSDCMavenRepoBase.isPSDCMavenRepoNameDirty();
            }
            case 13: {
                return pSDCMavenRepoBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDCMavenRepoBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDCMavenRepoBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDCMavenRepoBase.isPSDevSlnNameDirty();
            }
            case 17: {
                return pSDCMavenRepoBase.isROPasswdDirty();
            }
            case 18: {
                return pSDCMavenRepoBase.isROUserNameDirty();
            }
            case 19: {
                return pSDCMavenRepoBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDCMavenRepoBase.isUpdateManDirty();
            }
            case 21: {
                return pSDCMavenRepoBase.isUserTagDirty();
            }
            case 22: {
                return pSDCMavenRepoBase.isUserTag2Dirty();
            }
            case 23: {
                return pSDCMavenRepoBase.isUserTag3Dirty();
            }
            case 24: {
                return pSDCMavenRepoBase.isUserTag4Dirty();
            }
            case 25: {
                return pSDCMavenRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMavenRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMavenRepoBase pSDCMavenRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMavenRepoBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getMavenPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenpasswd", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getMavenPasswd()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getMavenUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenusername", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getMavenUserName()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getParam()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getParam3()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getParam4()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDCMavenRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmavenrepoid", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDCMavenRepoId()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDCMavenRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmavenreponame", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDCMavenRepoName()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getROPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropasswd", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getROPasswd()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getROUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rousername", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getROUserName()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCMavenRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMavenRepoBase.getJSONValue((Object)pSDCMavenRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMavenRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMavenRepoBase pSDCMavenRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMavenRepoBase.getConnStr() != null) {
            object = pSDCMavenRepoBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getCreateDate() != null) {
            object = pSDCMavenRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMavenRepoBase.getCreateMan() != null) {
            object = pSDCMavenRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getDefaultFlag() != null) {
            object = pSDCMavenRepoBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMavenRepoBase.getMavenPasswd() != null) {
            object = pSDCMavenRepoBase.getMavenPasswd();
            xmlNode.setAttribute(FIELD_MAVENPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getMavenUserName() != null) {
            object = pSDCMavenRepoBase.getMavenUserName();
            xmlNode.setAttribute(FIELD_MAVENUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getMemo() != null) {
            object = pSDCMavenRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getParam() != null) {
            object = pSDCMavenRepoBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getParam2() != null) {
            object = pSDCMavenRepoBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getParam3() != null) {
            object = pSDCMavenRepoBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getParam4() != null) {
            object = pSDCMavenRepoBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDCMavenRepoId() != null) {
            object = pSDCMavenRepoBase.getPSDCMavenRepoId();
            xmlNode.setAttribute(FIELD_PSDCMAVENREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDCMavenRepoName() != null) {
            object = pSDCMavenRepoBase.getPSDCMavenRepoName();
            xmlNode.setAttribute(FIELD_PSDCMAVENREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDevCenterId() != null) {
            object = pSDCMavenRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDevCenterName() != null) {
            object = pSDCMavenRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDevSlnId() != null) {
            object = pSDCMavenRepoBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getPSDevSlnName() != null) {
            object = pSDCMavenRepoBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getROPasswd() != null) {
            object = pSDCMavenRepoBase.getROPasswd();
            xmlNode.setAttribute(FIELD_ROPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getROUserName() != null) {
            object = pSDCMavenRepoBase.getROUserName();
            xmlNode.setAttribute(FIELD_ROUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getUpdateDate() != null) {
            object = pSDCMavenRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMavenRepoBase.getUpdateMan() != null) {
            object = pSDCMavenRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getUserTag() != null) {
            object = pSDCMavenRepoBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getUserTag2() != null) {
            object = pSDCMavenRepoBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getUserTag3() != null) {
            object = pSDCMavenRepoBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getUserTag4() != null) {
            object = pSDCMavenRepoBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMavenRepoBase.getValidFlag() != null) {
            object = pSDCMavenRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMavenRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMavenRepoBase pSDCMavenRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMavenRepoBase.isConnStrDirty() && (bl || pSDCMavenRepoBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCMavenRepoBase.getConnStr());
        }
        if (pSDCMavenRepoBase.isCreateDateDirty() && (bl || pSDCMavenRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMavenRepoBase.getCreateDate());
        }
        if (pSDCMavenRepoBase.isCreateManDirty() && (bl || pSDCMavenRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMavenRepoBase.getCreateMan());
        }
        if (pSDCMavenRepoBase.isDefaultFlagDirty() && (bl || pSDCMavenRepoBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCMavenRepoBase.getDefaultFlag());
        }
        if (pSDCMavenRepoBase.isMavenPasswdDirty() && (bl || pSDCMavenRepoBase.getMavenPasswd() != null)) {
            iDataObject.set(FIELD_MAVENPASSWD, (Object)pSDCMavenRepoBase.getMavenPasswd());
        }
        if (pSDCMavenRepoBase.isMavenUserNameDirty() && (bl || pSDCMavenRepoBase.getMavenUserName() != null)) {
            iDataObject.set(FIELD_MAVENUSERNAME, (Object)pSDCMavenRepoBase.getMavenUserName());
        }
        if (pSDCMavenRepoBase.isMemoDirty() && (bl || pSDCMavenRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMavenRepoBase.getMemo());
        }
        if (pSDCMavenRepoBase.isParamDirty() && (bl || pSDCMavenRepoBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCMavenRepoBase.getParam());
        }
        if (pSDCMavenRepoBase.isParam2Dirty() && (bl || pSDCMavenRepoBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCMavenRepoBase.getParam2());
        }
        if (pSDCMavenRepoBase.isParam3Dirty() && (bl || pSDCMavenRepoBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDCMavenRepoBase.getParam3());
        }
        if (pSDCMavenRepoBase.isParam4Dirty() && (bl || pSDCMavenRepoBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDCMavenRepoBase.getParam4());
        }
        if (pSDCMavenRepoBase.isPSDCMavenRepoIdDirty() && (bl || pSDCMavenRepoBase.getPSDCMavenRepoId() != null)) {
            iDataObject.set(FIELD_PSDCMAVENREPOID, (Object)pSDCMavenRepoBase.getPSDCMavenRepoId());
        }
        if (pSDCMavenRepoBase.isPSDCMavenRepoNameDirty() && (bl || pSDCMavenRepoBase.getPSDCMavenRepoName() != null)) {
            iDataObject.set(FIELD_PSDCMAVENREPONAME, (Object)pSDCMavenRepoBase.getPSDCMavenRepoName());
        }
        if (pSDCMavenRepoBase.isPSDevCenterIdDirty() && (bl || pSDCMavenRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCMavenRepoBase.getPSDevCenterId());
        }
        if (pSDCMavenRepoBase.isPSDevCenterNameDirty() && (bl || pSDCMavenRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCMavenRepoBase.getPSDevCenterName());
        }
        if (pSDCMavenRepoBase.isPSDevSlnIdDirty() && (bl || pSDCMavenRepoBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCMavenRepoBase.getPSDevSlnId());
        }
        if (pSDCMavenRepoBase.isPSDevSlnNameDirty() && (bl || pSDCMavenRepoBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCMavenRepoBase.getPSDevSlnName());
        }
        if (pSDCMavenRepoBase.isROPasswdDirty() && (bl || pSDCMavenRepoBase.getROPasswd() != null)) {
            iDataObject.set(FIELD_ROPASSWD, (Object)pSDCMavenRepoBase.getROPasswd());
        }
        if (pSDCMavenRepoBase.isROUserNameDirty() && (bl || pSDCMavenRepoBase.getROUserName() != null)) {
            iDataObject.set(FIELD_ROUSERNAME, (Object)pSDCMavenRepoBase.getROUserName());
        }
        if (pSDCMavenRepoBase.isUpdateDateDirty() && (bl || pSDCMavenRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMavenRepoBase.getUpdateDate());
        }
        if (pSDCMavenRepoBase.isUpdateManDirty() && (bl || pSDCMavenRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMavenRepoBase.getUpdateMan());
        }
        if (pSDCMavenRepoBase.isUserTagDirty() && (bl || pSDCMavenRepoBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCMavenRepoBase.getUserTag());
        }
        if (pSDCMavenRepoBase.isUserTag2Dirty() && (bl || pSDCMavenRepoBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCMavenRepoBase.getUserTag2());
        }
        if (pSDCMavenRepoBase.isUserTag3Dirty() && (bl || pSDCMavenRepoBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCMavenRepoBase.getUserTag3());
        }
        if (pSDCMavenRepoBase.isUserTag4Dirty() && (bl || pSDCMavenRepoBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCMavenRepoBase.getUserTag4());
        }
        if (pSDCMavenRepoBase.isValidFlagDirty() && (bl || pSDCMavenRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMavenRepoBase.getValidFlag());
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
        return PSDCMavenRepoBase.remove(this, n);
    }

    private static boolean remove(PSDCMavenRepoBase pSDCMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMavenRepoBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCMavenRepoBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCMavenRepoBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCMavenRepoBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSDCMavenRepoBase.resetMavenPasswd();
                return true;
            }
            case 5: {
                pSDCMavenRepoBase.resetMavenUserName();
                return true;
            }
            case 6: {
                pSDCMavenRepoBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCMavenRepoBase.resetParam();
                return true;
            }
            case 8: {
                pSDCMavenRepoBase.resetParam2();
                return true;
            }
            case 9: {
                pSDCMavenRepoBase.resetParam3();
                return true;
            }
            case 10: {
                pSDCMavenRepoBase.resetParam4();
                return true;
            }
            case 11: {
                pSDCMavenRepoBase.resetPSDCMavenRepoId();
                return true;
            }
            case 12: {
                pSDCMavenRepoBase.resetPSDCMavenRepoName();
                return true;
            }
            case 13: {
                pSDCMavenRepoBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDCMavenRepoBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDCMavenRepoBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDCMavenRepoBase.resetPSDevSlnName();
                return true;
            }
            case 17: {
                pSDCMavenRepoBase.resetROPasswd();
                return true;
            }
            case 18: {
                pSDCMavenRepoBase.resetROUserName();
                return true;
            }
            case 19: {
                pSDCMavenRepoBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDCMavenRepoBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDCMavenRepoBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDCMavenRepoBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSDCMavenRepoBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSDCMavenRepoBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSDCMavenRepoBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSDCMavenRepoBase getProxyEntity() {
        return this.proxyPSDCMavenRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMavenRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMavenRepoBase) {
            this.proxyPSDCMavenRepoBase = (PSDCMavenRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MAVENPASSWD, 4);
        fieldIndexMap.put(FIELD_MAVENUSERNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PARAM, 7);
        fieldIndexMap.put(FIELD_PARAM2, 8);
        fieldIndexMap.put(FIELD_PARAM3, 9);
        fieldIndexMap.put(FIELD_PARAM4, 10);
        fieldIndexMap.put(FIELD_PSDCMAVENREPOID, 11);
        fieldIndexMap.put(FIELD_PSDCMAVENREPONAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 16);
        fieldIndexMap.put(FIELD_ROPASSWD, 17);
        fieldIndexMap.put(FIELD_ROUSERNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

