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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMavenRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMavenRepoBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAVENPASSWD = "MAVENPASSWD";
    public static final String FIELD_MAVENUSERNAME = "MAVENUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSMAVENREPOID = "PSMAVENREPOID";
    public static final String FIELD_PSMAVENREPONAME = "PSMAVENREPONAME";
    public static final String FIELD_PSMAVENSERVERID = "PSMAVENSERVERID";
    public static final String FIELD_PSMAVENSERVERNAME = "PSMAVENSERVERNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_REPOSTATE = "REPOSTATE";
    public static final String FIELD_ROPASSWD = "ROPASSWD";
    public static final String FIELD_ROUSERNAME = "ROUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCALRES = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MAVENPASSWD = 5;
    private static final int INDEX_MAVENUSERNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PARAM = 8;
    private static final int INDEX_PARAM2 = 9;
    private static final int INDEX_PARAM3 = 10;
    private static final int INDEX_PARAM4 = 11;
    private static final int INDEX_PARAM5 = 12;
    private static final int INDEX_PARAM6 = 13;
    private static final int INDEX_PARAM7 = 14;
    private static final int INDEX_PARAM8 = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSMAVENREPOID = 18;
    private static final int INDEX_PSMAVENREPONAME = 19;
    private static final int INDEX_PSMAVENSERVERID = 20;
    private static final int INDEX_PSMAVENSERVERNAME = 21;
    private static final int INDEX_PSOBJID = 22;
    private static final int INDEX_PSOBJNAME = 23;
    private static final int INDEX_PSOBJTYPE = 24;
    private static final int INDEX_PSSVRDOMAINID = 25;
    private static final int INDEX_PSSVRDOMAINNAME = 26;
    private static final int INDEX_READONLYMODE = 27;
    private static final int INDEX_REFINFO = 28;
    private static final int INDEX_REPOSTATE = 29;
    private static final int INDEX_ROPASSWD = 30;
    private static final int INDEX_ROUSERNAME = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMavenRepoBase proxyPSMavenRepoBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean mavenpasswdDirtyFlag = false;
    private boolean mavenusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psmavenrepoidDirtyFlag = false;
    private boolean psmavenreponameDirtyFlag = false;
    private boolean psmavenserveridDirtyFlag = false;
    private boolean psmavenservernameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean repostateDirtyFlag = false;
    private boolean ropasswdDirtyFlag = false;
    private boolean rousernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="localres")
    private Integer localres;
    @Column(name="logicname")
    private String logicname;
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
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psmavenrepoid")
    private String psmavenrepoid;
    @Column(name="psmavenreponame")
    private String psmavenreponame;
    @Column(name="psmavenserverid")
    private String psmavenserverid;
    @Column(name="psmavenservername")
    private String psmavenservername;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="repostate")
    private Integer repostate;
    @Column(name="ropasswd")
    private String ropasswd;
    @Column(name="rousername")
    private String rousername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSMavenServerLock = new Integer(1);
    private PSMavenServer psmavenserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

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

    public void setPSMavenRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenrepoid = string;
        this.psmavenrepoidDirtyFlag = true;
    }

    public String getPSMavenRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenRepoId();
        }
        return this.psmavenrepoid;
    }

    public boolean isPSMavenRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenRepoIdDirty();
        }
        return this.psmavenrepoidDirtyFlag;
    }

    public void resetPSMavenRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenRepoId();
            return;
        }
        this.psmavenrepoidDirtyFlag = false;
        this.psmavenrepoid = null;
    }

    public void setPSMavenRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenreponame = string;
        this.psmavenreponameDirtyFlag = true;
    }

    public String getPSMavenRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenRepoName();
        }
        return this.psmavenreponame;
    }

    public boolean isPSMavenRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenRepoNameDirty();
        }
        return this.psmavenreponameDirtyFlag;
    }

    public void resetPSMavenRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenRepoName();
            return;
        }
        this.psmavenreponameDirtyFlag = false;
        this.psmavenreponame = null;
    }

    public void setPSMavenServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenserverid = string;
        this.psmavenserveridDirtyFlag = true;
    }

    public String getPSMavenServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerId();
        }
        return this.psmavenserverid;
    }

    public boolean isPSMavenServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerIdDirty();
        }
        return this.psmavenserveridDirtyFlag;
    }

    public void resetPSMavenServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerId();
            return;
        }
        this.psmavenserveridDirtyFlag = false;
        this.psmavenserverid = null;
    }

    public void setPSMavenServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenservername = string;
        this.psmavenservernameDirtyFlag = true;
    }

    public String getPSMavenServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerName();
        }
        return this.psmavenservername;
    }

    public boolean isPSMavenServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerNameDirty();
        }
        return this.psmavenservernameDirtyFlag;
    }

    public void resetPSMavenServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerName();
            return;
        }
        this.psmavenservernameDirtyFlag = false;
        this.psmavenservername = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
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

    public void setRepoState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepoState(n);
            return;
        }
        this.repostate = n;
        this.repostateDirtyFlag = true;
    }

    public Integer getRepoState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepoState();
        }
        return this.repostate;
    }

    public boolean isRepoStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepoStateDirty();
        }
        return this.repostateDirtyFlag;
    }

    public void resetRepoState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepoState();
            return;
        }
        this.repostateDirtyFlag = false;
        this.repostate = null;
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
        PSMavenRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMavenRepoBase pSMavenRepoBase) {
        pSMavenRepoBase.resetConnStr();
        pSMavenRepoBase.resetCreateDate();
        pSMavenRepoBase.resetCreateMan();
        pSMavenRepoBase.resetLocalRes();
        pSMavenRepoBase.resetLogicName();
        pSMavenRepoBase.resetMavenPasswd();
        pSMavenRepoBase.resetMavenUserName();
        pSMavenRepoBase.resetMemo();
        pSMavenRepoBase.resetParam();
        pSMavenRepoBase.resetParam2();
        pSMavenRepoBase.resetParam3();
        pSMavenRepoBase.resetParam4();
        pSMavenRepoBase.resetParam5();
        pSMavenRepoBase.resetParam6();
        pSMavenRepoBase.resetParam7();
        pSMavenRepoBase.resetParam8();
        pSMavenRepoBase.resetPSDevCenterId();
        pSMavenRepoBase.resetPSDevCenterName();
        pSMavenRepoBase.resetPSMavenRepoId();
        pSMavenRepoBase.resetPSMavenRepoName();
        pSMavenRepoBase.resetPSMavenServerId();
        pSMavenRepoBase.resetPSMavenServerName();
        pSMavenRepoBase.resetPSObjId();
        pSMavenRepoBase.resetPSObjName();
        pSMavenRepoBase.resetPSObjType();
        pSMavenRepoBase.resetPSSvrDomainId();
        pSMavenRepoBase.resetPSSvrDomainName();
        pSMavenRepoBase.resetReadOnlyMode();
        pSMavenRepoBase.resetRefInfo();
        pSMavenRepoBase.resetRepoState();
        pSMavenRepoBase.resetROPasswd();
        pSMavenRepoBase.resetROUserName();
        pSMavenRepoBase.resetUpdateDate();
        pSMavenRepoBase.resetUpdateMan();
        pSMavenRepoBase.resetValidFlag();
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
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSMavenRepoIdDirty()) {
            hashMap.put(FIELD_PSMAVENREPOID, this.getPSMavenRepoId());
        }
        if (!bl || this.isPSMavenRepoNameDirty()) {
            hashMap.put(FIELD_PSMAVENREPONAME, this.getPSMavenRepoName());
        }
        if (!bl || this.isPSMavenServerIdDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERID, this.getPSMavenServerId());
        }
        if (!bl || this.isPSMavenServerNameDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERNAME, this.getPSMavenServerName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isRepoStateDirty()) {
            hashMap.put(FIELD_REPOSTATE, this.getRepoState());
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
        return PSMavenRepoBase.get(this, n);
    }

    private static Object get(PSMavenRepoBase pSMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenRepoBase.getConnStr();
            }
            case 1: {
                return pSMavenRepoBase.getCreateDate();
            }
            case 2: {
                return pSMavenRepoBase.getCreateMan();
            }
            case 3: {
                return pSMavenRepoBase.getLocalRes();
            }
            case 4: {
                return pSMavenRepoBase.getLogicName();
            }
            case 5: {
                return pSMavenRepoBase.getMavenPasswd();
            }
            case 6: {
                return pSMavenRepoBase.getMavenUserName();
            }
            case 7: {
                return pSMavenRepoBase.getMemo();
            }
            case 8: {
                return pSMavenRepoBase.getParam();
            }
            case 9: {
                return pSMavenRepoBase.getParam2();
            }
            case 10: {
                return pSMavenRepoBase.getParam3();
            }
            case 11: {
                return pSMavenRepoBase.getParam4();
            }
            case 12: {
                return pSMavenRepoBase.getParam5();
            }
            case 13: {
                return pSMavenRepoBase.getParam6();
            }
            case 14: {
                return pSMavenRepoBase.getParam7();
            }
            case 15: {
                return pSMavenRepoBase.getParam8();
            }
            case 16: {
                return pSMavenRepoBase.getPSDevCenterId();
            }
            case 17: {
                return pSMavenRepoBase.getPSDevCenterName();
            }
            case 18: {
                return pSMavenRepoBase.getPSMavenRepoId();
            }
            case 19: {
                return pSMavenRepoBase.getPSMavenRepoName();
            }
            case 20: {
                return pSMavenRepoBase.getPSMavenServerId();
            }
            case 21: {
                return pSMavenRepoBase.getPSMavenServerName();
            }
            case 22: {
                return pSMavenRepoBase.getPSObjId();
            }
            case 23: {
                return pSMavenRepoBase.getPSObjName();
            }
            case 24: {
                return pSMavenRepoBase.getPSObjType();
            }
            case 25: {
                return pSMavenRepoBase.getPSSvrDomainId();
            }
            case 26: {
                return pSMavenRepoBase.getPSSvrDomainName();
            }
            case 27: {
                return pSMavenRepoBase.getReadOnlyMode();
            }
            case 28: {
                return pSMavenRepoBase.getRefInfo();
            }
            case 29: {
                return pSMavenRepoBase.getRepoState();
            }
            case 30: {
                return pSMavenRepoBase.getROPasswd();
            }
            case 31: {
                return pSMavenRepoBase.getROUserName();
            }
            case 32: {
                return pSMavenRepoBase.getUpdateDate();
            }
            case 33: {
                return pSMavenRepoBase.getUpdateMan();
            }
            case 34: {
                return pSMavenRepoBase.getValidFlag();
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
        PSMavenRepoBase.set(this, n, object);
    }

    private static void set(PSMavenRepoBase pSMavenRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMavenRepoBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMavenRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMavenRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMavenRepoBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSMavenRepoBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMavenRepoBase.setMavenPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMavenRepoBase.setMavenUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMavenRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMavenRepoBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMavenRepoBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMavenRepoBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMavenRepoBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMavenRepoBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSMavenRepoBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSMavenRepoBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSMavenRepoBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSMavenRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMavenRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMavenRepoBase.setPSMavenRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSMavenRepoBase.setPSMavenRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMavenRepoBase.setPSMavenServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMavenRepoBase.setPSMavenServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSMavenRepoBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSMavenRepoBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSMavenRepoBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMavenRepoBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSMavenRepoBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSMavenRepoBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSMavenRepoBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSMavenRepoBase.setRepoState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSMavenRepoBase.setROPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSMavenRepoBase.setROUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSMavenRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSMavenRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSMavenRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMavenRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSMavenRepoBase pSMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenRepoBase.getConnStr() == null;
            }
            case 1: {
                return pSMavenRepoBase.getCreateDate() == null;
            }
            case 2: {
                return pSMavenRepoBase.getCreateMan() == null;
            }
            case 3: {
                return pSMavenRepoBase.getLocalRes() == null;
            }
            case 4: {
                return pSMavenRepoBase.getLogicName() == null;
            }
            case 5: {
                return pSMavenRepoBase.getMavenPasswd() == null;
            }
            case 6: {
                return pSMavenRepoBase.getMavenUserName() == null;
            }
            case 7: {
                return pSMavenRepoBase.getMemo() == null;
            }
            case 8: {
                return pSMavenRepoBase.getParam() == null;
            }
            case 9: {
                return pSMavenRepoBase.getParam2() == null;
            }
            case 10: {
                return pSMavenRepoBase.getParam3() == null;
            }
            case 11: {
                return pSMavenRepoBase.getParam4() == null;
            }
            case 12: {
                return pSMavenRepoBase.getParam5() == null;
            }
            case 13: {
                return pSMavenRepoBase.getParam6() == null;
            }
            case 14: {
                return pSMavenRepoBase.getParam7() == null;
            }
            case 15: {
                return pSMavenRepoBase.getParam8() == null;
            }
            case 16: {
                return pSMavenRepoBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSMavenRepoBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSMavenRepoBase.getPSMavenRepoId() == null;
            }
            case 19: {
                return pSMavenRepoBase.getPSMavenRepoName() == null;
            }
            case 20: {
                return pSMavenRepoBase.getPSMavenServerId() == null;
            }
            case 21: {
                return pSMavenRepoBase.getPSMavenServerName() == null;
            }
            case 22: {
                return pSMavenRepoBase.getPSObjId() == null;
            }
            case 23: {
                return pSMavenRepoBase.getPSObjName() == null;
            }
            case 24: {
                return pSMavenRepoBase.getPSObjType() == null;
            }
            case 25: {
                return pSMavenRepoBase.getPSSvrDomainId() == null;
            }
            case 26: {
                return pSMavenRepoBase.getPSSvrDomainName() == null;
            }
            case 27: {
                return pSMavenRepoBase.getReadOnlyMode() == null;
            }
            case 28: {
                return pSMavenRepoBase.getRefInfo() == null;
            }
            case 29: {
                return pSMavenRepoBase.getRepoState() == null;
            }
            case 30: {
                return pSMavenRepoBase.getROPasswd() == null;
            }
            case 31: {
                return pSMavenRepoBase.getROUserName() == null;
            }
            case 32: {
                return pSMavenRepoBase.getUpdateDate() == null;
            }
            case 33: {
                return pSMavenRepoBase.getUpdateMan() == null;
            }
            case 34: {
                return pSMavenRepoBase.getValidFlag() == null;
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
        return PSMavenRepoBase.contains(this, n);
    }

    private static boolean contains(PSMavenRepoBase pSMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenRepoBase.isConnStrDirty();
            }
            case 1: {
                return pSMavenRepoBase.isCreateDateDirty();
            }
            case 2: {
                return pSMavenRepoBase.isCreateManDirty();
            }
            case 3: {
                return pSMavenRepoBase.isLocalResDirty();
            }
            case 4: {
                return pSMavenRepoBase.isLogicNameDirty();
            }
            case 5: {
                return pSMavenRepoBase.isMavenPasswdDirty();
            }
            case 6: {
                return pSMavenRepoBase.isMavenUserNameDirty();
            }
            case 7: {
                return pSMavenRepoBase.isMemoDirty();
            }
            case 8: {
                return pSMavenRepoBase.isParamDirty();
            }
            case 9: {
                return pSMavenRepoBase.isParam2Dirty();
            }
            case 10: {
                return pSMavenRepoBase.isParam3Dirty();
            }
            case 11: {
                return pSMavenRepoBase.isParam4Dirty();
            }
            case 12: {
                return pSMavenRepoBase.isParam5Dirty();
            }
            case 13: {
                return pSMavenRepoBase.isParam6Dirty();
            }
            case 14: {
                return pSMavenRepoBase.isParam7Dirty();
            }
            case 15: {
                return pSMavenRepoBase.isParam8Dirty();
            }
            case 16: {
                return pSMavenRepoBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSMavenRepoBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSMavenRepoBase.isPSMavenRepoIdDirty();
            }
            case 19: {
                return pSMavenRepoBase.isPSMavenRepoNameDirty();
            }
            case 20: {
                return pSMavenRepoBase.isPSMavenServerIdDirty();
            }
            case 21: {
                return pSMavenRepoBase.isPSMavenServerNameDirty();
            }
            case 22: {
                return pSMavenRepoBase.isPSObjIdDirty();
            }
            case 23: {
                return pSMavenRepoBase.isPSObjNameDirty();
            }
            case 24: {
                return pSMavenRepoBase.isPSObjTypeDirty();
            }
            case 25: {
                return pSMavenRepoBase.isPSSvrDomainIdDirty();
            }
            case 26: {
                return pSMavenRepoBase.isPSSvrDomainNameDirty();
            }
            case 27: {
                return pSMavenRepoBase.isReadOnlyModeDirty();
            }
            case 28: {
                return pSMavenRepoBase.isRefInfoDirty();
            }
            case 29: {
                return pSMavenRepoBase.isRepoStateDirty();
            }
            case 30: {
                return pSMavenRepoBase.isROPasswdDirty();
            }
            case 31: {
                return pSMavenRepoBase.isROUserNameDirty();
            }
            case 32: {
                return pSMavenRepoBase.isUpdateDateDirty();
            }
            case 33: {
                return pSMavenRepoBase.isUpdateManDirty();
            }
            case 34: {
                return pSMavenRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMavenRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMavenRepoBase pSMavenRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMavenRepoBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getConnStr()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getLogicName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getMavenPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenpasswd", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getMavenPasswd()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getMavenUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenusername", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getMavenUserName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam2()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam3()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam4()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam5()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam6()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam7()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getParam8()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSMavenRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenrepoid", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSMavenRepoId()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSMavenRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenreponame", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSMavenRepoName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSMavenServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenserverid", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSMavenServerId()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSMavenServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenservername", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSMavenServerName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getRepoState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repostate", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getRepoState()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getROPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropasswd", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getROPasswd()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getROUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rousername", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getROUserName()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMavenRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMavenRepoBase.getJSONValue((Object)pSMavenRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMavenRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMavenRepoBase pSMavenRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMavenRepoBase.getConnStr() != null) {
            object = pSMavenRepoBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getCreateDate() != null) {
            object = pSMavenRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenRepoBase.getCreateMan() != null) {
            object = pSMavenRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getLocalRes() != null) {
            object = pSMavenRepoBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getLogicName() != null) {
            object = pSMavenRepoBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getMavenPasswd() != null) {
            object = pSMavenRepoBase.getMavenPasswd();
            xmlNode.setAttribute(FIELD_MAVENPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getMavenUserName() != null) {
            object = pSMavenRepoBase.getMavenUserName();
            xmlNode.setAttribute(FIELD_MAVENUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getMemo() != null) {
            object = pSMavenRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getParam() != null) {
            object = pSMavenRepoBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getParam2() != null) {
            object = pSMavenRepoBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getParam3() != null) {
            object = pSMavenRepoBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getParam4() != null) {
            object = pSMavenRepoBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getParam5() != null) {
            object = pSMavenRepoBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getParam6() != null) {
            object = pSMavenRepoBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getParam7() != null) {
            object = pSMavenRepoBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getParam8() != null) {
            object = pSMavenRepoBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getPSDevCenterId() != null) {
            object = pSMavenRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSDevCenterName() != null) {
            object = pSMavenRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSMavenRepoId() != null) {
            object = pSMavenRepoBase.getPSMavenRepoId();
            xmlNode.setAttribute(FIELD_PSMAVENREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSMavenRepoName() != null) {
            object = pSMavenRepoBase.getPSMavenRepoName();
            xmlNode.setAttribute(FIELD_PSMAVENREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSMavenServerId() != null) {
            object = pSMavenRepoBase.getPSMavenServerId();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSMavenServerName() != null) {
            object = pSMavenRepoBase.getPSMavenServerName();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSObjId() != null) {
            object = pSMavenRepoBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSObjName() != null) {
            object = pSMavenRepoBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSObjType() != null) {
            object = pSMavenRepoBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSSvrDomainId() != null) {
            object = pSMavenRepoBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getPSSvrDomainName() != null) {
            object = pSMavenRepoBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getReadOnlyMode() != null) {
            object = pSMavenRepoBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getRefInfo() != null) {
            object = pSMavenRepoBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getRepoState() != null) {
            object = pSMavenRepoBase.getRepoState();
            xmlNode.setAttribute(FIELD_REPOSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMavenRepoBase.getROPasswd() != null) {
            object = pSMavenRepoBase.getROPasswd();
            xmlNode.setAttribute(FIELD_ROPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getROUserName() != null) {
            object = pSMavenRepoBase.getROUserName();
            xmlNode.setAttribute(FIELD_ROUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getUpdateDate() != null) {
            object = pSMavenRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenRepoBase.getUpdateMan() != null) {
            object = pSMavenRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenRepoBase.getValidFlag() != null) {
            object = pSMavenRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMavenRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMavenRepoBase pSMavenRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMavenRepoBase.isConnStrDirty() && (bl || pSMavenRepoBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSMavenRepoBase.getConnStr());
        }
        if (pSMavenRepoBase.isCreateDateDirty() && (bl || pSMavenRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMavenRepoBase.getCreateDate());
        }
        if (pSMavenRepoBase.isCreateManDirty() && (bl || pSMavenRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMavenRepoBase.getCreateMan());
        }
        if (pSMavenRepoBase.isLocalResDirty() && (bl || pSMavenRepoBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSMavenRepoBase.getLocalRes());
        }
        if (pSMavenRepoBase.isLogicNameDirty() && (bl || pSMavenRepoBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSMavenRepoBase.getLogicName());
        }
        if (pSMavenRepoBase.isMavenPasswdDirty() && (bl || pSMavenRepoBase.getMavenPasswd() != null)) {
            iDataObject.set(FIELD_MAVENPASSWD, (Object)pSMavenRepoBase.getMavenPasswd());
        }
        if (pSMavenRepoBase.isMavenUserNameDirty() && (bl || pSMavenRepoBase.getMavenUserName() != null)) {
            iDataObject.set(FIELD_MAVENUSERNAME, (Object)pSMavenRepoBase.getMavenUserName());
        }
        if (pSMavenRepoBase.isMemoDirty() && (bl || pSMavenRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMavenRepoBase.getMemo());
        }
        if (pSMavenRepoBase.isParamDirty() && (bl || pSMavenRepoBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSMavenRepoBase.getParam());
        }
        if (pSMavenRepoBase.isParam2Dirty() && (bl || pSMavenRepoBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSMavenRepoBase.getParam2());
        }
        if (pSMavenRepoBase.isParam3Dirty() && (bl || pSMavenRepoBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSMavenRepoBase.getParam3());
        }
        if (pSMavenRepoBase.isParam4Dirty() && (bl || pSMavenRepoBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSMavenRepoBase.getParam4());
        }
        if (pSMavenRepoBase.isParam5Dirty() && (bl || pSMavenRepoBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSMavenRepoBase.getParam5());
        }
        if (pSMavenRepoBase.isParam6Dirty() && (bl || pSMavenRepoBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSMavenRepoBase.getParam6());
        }
        if (pSMavenRepoBase.isParam7Dirty() && (bl || pSMavenRepoBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSMavenRepoBase.getParam7());
        }
        if (pSMavenRepoBase.isParam8Dirty() && (bl || pSMavenRepoBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSMavenRepoBase.getParam8());
        }
        if (pSMavenRepoBase.isPSDevCenterIdDirty() && (bl || pSMavenRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSMavenRepoBase.getPSDevCenterId());
        }
        if (pSMavenRepoBase.isPSDevCenterNameDirty() && (bl || pSMavenRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSMavenRepoBase.getPSDevCenterName());
        }
        if (pSMavenRepoBase.isPSMavenRepoIdDirty() && (bl || pSMavenRepoBase.getPSMavenRepoId() != null)) {
            iDataObject.set(FIELD_PSMAVENREPOID, (Object)pSMavenRepoBase.getPSMavenRepoId());
        }
        if (pSMavenRepoBase.isPSMavenRepoNameDirty() && (bl || pSMavenRepoBase.getPSMavenRepoName() != null)) {
            iDataObject.set(FIELD_PSMAVENREPONAME, (Object)pSMavenRepoBase.getPSMavenRepoName());
        }
        if (pSMavenRepoBase.isPSMavenServerIdDirty() && (bl || pSMavenRepoBase.getPSMavenServerId() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERID, (Object)pSMavenRepoBase.getPSMavenServerId());
        }
        if (pSMavenRepoBase.isPSMavenServerNameDirty() && (bl || pSMavenRepoBase.getPSMavenServerName() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERNAME, (Object)pSMavenRepoBase.getPSMavenServerName());
        }
        if (pSMavenRepoBase.isPSObjIdDirty() && (bl || pSMavenRepoBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSMavenRepoBase.getPSObjId());
        }
        if (pSMavenRepoBase.isPSObjNameDirty() && (bl || pSMavenRepoBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSMavenRepoBase.getPSObjName());
        }
        if (pSMavenRepoBase.isPSObjTypeDirty() && (bl || pSMavenRepoBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSMavenRepoBase.getPSObjType());
        }
        if (pSMavenRepoBase.isPSSvrDomainIdDirty() && (bl || pSMavenRepoBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSMavenRepoBase.getPSSvrDomainId());
        }
        if (pSMavenRepoBase.isPSSvrDomainNameDirty() && (bl || pSMavenRepoBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSMavenRepoBase.getPSSvrDomainName());
        }
        if (pSMavenRepoBase.isReadOnlyModeDirty() && (bl || pSMavenRepoBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSMavenRepoBase.getReadOnlyMode());
        }
        if (pSMavenRepoBase.isRefInfoDirty() && (bl || pSMavenRepoBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSMavenRepoBase.getRefInfo());
        }
        if (pSMavenRepoBase.isRepoStateDirty() && (bl || pSMavenRepoBase.getRepoState() != null)) {
            iDataObject.set(FIELD_REPOSTATE, (Object)pSMavenRepoBase.getRepoState());
        }
        if (pSMavenRepoBase.isROPasswdDirty() && (bl || pSMavenRepoBase.getROPasswd() != null)) {
            iDataObject.set(FIELD_ROPASSWD, (Object)pSMavenRepoBase.getROPasswd());
        }
        if (pSMavenRepoBase.isROUserNameDirty() && (bl || pSMavenRepoBase.getROUserName() != null)) {
            iDataObject.set(FIELD_ROUSERNAME, (Object)pSMavenRepoBase.getROUserName());
        }
        if (pSMavenRepoBase.isUpdateDateDirty() && (bl || pSMavenRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMavenRepoBase.getUpdateDate());
        }
        if (pSMavenRepoBase.isUpdateManDirty() && (bl || pSMavenRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMavenRepoBase.getUpdateMan());
        }
        if (pSMavenRepoBase.isValidFlagDirty() && (bl || pSMavenRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMavenRepoBase.getValidFlag());
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
        return PSMavenRepoBase.remove(this, n);
    }

    private static boolean remove(PSMavenRepoBase pSMavenRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMavenRepoBase.resetConnStr();
                return true;
            }
            case 1: {
                pSMavenRepoBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMavenRepoBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMavenRepoBase.resetLocalRes();
                return true;
            }
            case 4: {
                pSMavenRepoBase.resetLogicName();
                return true;
            }
            case 5: {
                pSMavenRepoBase.resetMavenPasswd();
                return true;
            }
            case 6: {
                pSMavenRepoBase.resetMavenUserName();
                return true;
            }
            case 7: {
                pSMavenRepoBase.resetMemo();
                return true;
            }
            case 8: {
                pSMavenRepoBase.resetParam();
                return true;
            }
            case 9: {
                pSMavenRepoBase.resetParam2();
                return true;
            }
            case 10: {
                pSMavenRepoBase.resetParam3();
                return true;
            }
            case 11: {
                pSMavenRepoBase.resetParam4();
                return true;
            }
            case 12: {
                pSMavenRepoBase.resetParam5();
                return true;
            }
            case 13: {
                pSMavenRepoBase.resetParam6();
                return true;
            }
            case 14: {
                pSMavenRepoBase.resetParam7();
                return true;
            }
            case 15: {
                pSMavenRepoBase.resetParam8();
                return true;
            }
            case 16: {
                pSMavenRepoBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSMavenRepoBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSMavenRepoBase.resetPSMavenRepoId();
                return true;
            }
            case 19: {
                pSMavenRepoBase.resetPSMavenRepoName();
                return true;
            }
            case 20: {
                pSMavenRepoBase.resetPSMavenServerId();
                return true;
            }
            case 21: {
                pSMavenRepoBase.resetPSMavenServerName();
                return true;
            }
            case 22: {
                pSMavenRepoBase.resetPSObjId();
                return true;
            }
            case 23: {
                pSMavenRepoBase.resetPSObjName();
                return true;
            }
            case 24: {
                pSMavenRepoBase.resetPSObjType();
                return true;
            }
            case 25: {
                pSMavenRepoBase.resetPSSvrDomainId();
                return true;
            }
            case 26: {
                pSMavenRepoBase.resetPSSvrDomainName();
                return true;
            }
            case 27: {
                pSMavenRepoBase.resetReadOnlyMode();
                return true;
            }
            case 28: {
                pSMavenRepoBase.resetRefInfo();
                return true;
            }
            case 29: {
                pSMavenRepoBase.resetRepoState();
                return true;
            }
            case 30: {
                pSMavenRepoBase.resetROPasswd();
                return true;
            }
            case 31: {
                pSMavenRepoBase.resetROUserName();
                return true;
            }
            case 32: {
                pSMavenRepoBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSMavenRepoBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSMavenRepoBase.resetValidFlag();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMavenServer getPSMavenServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServer();
        }
        if (this.getPSMavenServerId() == null) {
            return null;
        }
        Integer n = this.objPSMavenServerLock;
        synchronized (n) {
            if (this.psmavenserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSMavenServerId(), (Object)this.psmavenserver.getPSMavenServerId()) != 0L) {
                this.psmavenserver = null;
            }
            if (this.psmavenserver == null) {
                PSMavenServer pSMavenServer = new PSMavenServer();
                pSMavenServer.setPSMavenServerId(this.getPSMavenServerId());
                PSMavenServerService pSMavenServerService = (PSMavenServerService)ServiceGlobal.getService(PSMavenServerService.class, (SessionFactory)this.getSessionFactory());
                pSMavenServerService.autoGet((IEntity)pSMavenServer);
                this.psmavenserver = pSMavenServer;
            }
            return this.psmavenserver;
        }
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
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSMavenRepoBase getProxyEntity() {
        return this.proxyPSMavenRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMavenRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSMavenRepoBase) {
            this.proxyPSMavenRepoBase = (PSMavenRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCALRES, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MAVENPASSWD, 5);
        fieldIndexMap.put(FIELD_MAVENUSERNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PARAM, 8);
        fieldIndexMap.put(FIELD_PARAM2, 9);
        fieldIndexMap.put(FIELD_PARAM3, 10);
        fieldIndexMap.put(FIELD_PARAM4, 11);
        fieldIndexMap.put(FIELD_PARAM5, 12);
        fieldIndexMap.put(FIELD_PARAM6, 13);
        fieldIndexMap.put(FIELD_PARAM7, 14);
        fieldIndexMap.put(FIELD_PARAM8, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSMAVENREPOID, 18);
        fieldIndexMap.put(FIELD_PSMAVENREPONAME, 19);
        fieldIndexMap.put(FIELD_PSMAVENSERVERID, 20);
        fieldIndexMap.put(FIELD_PSMAVENSERVERNAME, 21);
        fieldIndexMap.put(FIELD_PSOBJID, 22);
        fieldIndexMap.put(FIELD_PSOBJNAME, 23);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 24);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 25);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 26);
        fieldIndexMap.put(FIELD_READONLYMODE, 27);
        fieldIndexMap.put(FIELD_REFINFO, 28);
        fieldIndexMap.put(FIELD_REPOSTATE, 29);
        fieldIndexMap.put(FIELD_ROPASSWD, 30);
        fieldIndexMap.put(FIELD_ROUSERNAME, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

