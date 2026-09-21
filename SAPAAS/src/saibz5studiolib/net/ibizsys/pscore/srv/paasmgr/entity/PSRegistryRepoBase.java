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
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRegistryRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRegistryRepoBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
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
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String FIELD_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String FIELD_PSREGISTRYSERVERID = "PSREGISTRYSERVERID";
    public static final String FIELD_PSREGISTRYSERVERNAME = "PSREGISTRYSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_REGISTRYPASSWD = "REGISTRYPASSWD";
    public static final String FIELD_REGISTRYTYPE = "REGISTRYTYPE";
    public static final String FIELD_REGISTRYUSERNAME = "REGISTRYUSERNAME";
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
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PARAM = 6;
    private static final int INDEX_PARAM2 = 7;
    private static final int INDEX_PARAM3 = 8;
    private static final int INDEX_PARAM4 = 9;
    private static final int INDEX_PARAM5 = 10;
    private static final int INDEX_PARAM6 = 11;
    private static final int INDEX_PARAM7 = 12;
    private static final int INDEX_PARAM8 = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_PSOBJID = 16;
    private static final int INDEX_PSOBJNAME = 17;
    private static final int INDEX_PSOBJTYPE = 18;
    private static final int INDEX_PSREGISTRYREPOID = 19;
    private static final int INDEX_PSREGISTRYREPONAME = 20;
    private static final int INDEX_PSREGISTRYSERVERID = 21;
    private static final int INDEX_PSREGISTRYSERVERNAME = 22;
    private static final int INDEX_PSSVRDOMAINID = 23;
    private static final int INDEX_PSSVRDOMAINNAME = 24;
    private static final int INDEX_READONLYMODE = 25;
    private static final int INDEX_REFINFO = 26;
    private static final int INDEX_REGISTRYPASSWD = 27;
    private static final int INDEX_REGISTRYTYPE = 28;
    private static final int INDEX_REGISTRYUSERNAME = 29;
    private static final int INDEX_REPOSTATE = 30;
    private static final int INDEX_ROPASSWD = 31;
    private static final int INDEX_ROUSERNAME = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRegistryRepoBase proxyPSRegistryRepoBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
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
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psregistryrepoidDirtyFlag = false;
    private boolean psregistryreponameDirtyFlag = false;
    private boolean psregistryserveridDirtyFlag = false;
    private boolean psregistryservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean registrypasswdDirtyFlag = false;
    private boolean registrytypeDirtyFlag = false;
    private boolean registryusernameDirtyFlag = false;
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
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psregistryrepoid")
    private String psregistryrepoid;
    @Column(name="psregistryreponame")
    private String psregistryreponame;
    @Column(name="psregistryserverid")
    private String psregistryserverid;
    @Column(name="psregistryservername")
    private String psregistryservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="registrypasswd")
    private String registrypasswd;
    @Column(name="registrytype")
    private String registrytype;
    @Column(name="registryusername")
    private String registryusername;
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
    private Integer objPsregistryserverLock = new Integer(1);
    private PSRegistryServer psregistryserver = null;
    private Integer objPssvrdomainLock = new Integer(1);
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

    public void setPSRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryrepoid = string;
        this.psregistryrepoidDirtyFlag = true;
    }

    public String getPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoId();
        }
        return this.psregistryrepoid;
    }

    public boolean isPSRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoIdDirty();
        }
        return this.psregistryrepoidDirtyFlag;
    }

    public void resetPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoId();
            return;
        }
        this.psregistryrepoidDirtyFlag = false;
        this.psregistryrepoid = null;
    }

    public void setPSRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryreponame = string;
        this.psregistryreponameDirtyFlag = true;
    }

    public String getPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoName();
        }
        return this.psregistryreponame;
    }

    public boolean isPSRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoNameDirty();
        }
        return this.psregistryreponameDirtyFlag;
    }

    public void resetPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoName();
            return;
        }
        this.psregistryreponameDirtyFlag = false;
        this.psregistryreponame = null;
    }

    public void setPSRegistryServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryserverid = string;
        this.psregistryserveridDirtyFlag = true;
    }

    public String getPSRegistryServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerId();
        }
        return this.psregistryserverid;
    }

    public boolean isPSRegistryServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerIdDirty();
        }
        return this.psregistryserveridDirtyFlag;
    }

    public void resetPSRegistryServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerId();
            return;
        }
        this.psregistryserveridDirtyFlag = false;
        this.psregistryserverid = null;
    }

    public void setPSRegistryServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryservername = string;
        this.psregistryservernameDirtyFlag = true;
    }

    public String getPSRegistryServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerName();
        }
        return this.psregistryservername;
    }

    public boolean isPSRegistryServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerNameDirty();
        }
        return this.psregistryservernameDirtyFlag;
    }

    public void resetPSRegistryServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerName();
            return;
        }
        this.psregistryservernameDirtyFlag = false;
        this.psregistryservername = null;
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

    public void setRegistryPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrypasswd = string;
        this.registrypasswdDirtyFlag = true;
    }

    public String getRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryPasswd();
        }
        return this.registrypasswd;
    }

    public boolean isRegistryPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryPasswdDirty();
        }
        return this.registrypasswdDirtyFlag;
    }

    public void resetRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryPasswd();
            return;
        }
        this.registrypasswdDirtyFlag = false;
        this.registrypasswd = null;
    }

    public void setRegistryType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrytype = string;
        this.registrytypeDirtyFlag = true;
    }

    public String getRegistryType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryType();
        }
        return this.registrytype;
    }

    public boolean isRegistryTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryTypeDirty();
        }
        return this.registrytypeDirtyFlag;
    }

    public void resetRegistryType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryType();
            return;
        }
        this.registrytypeDirtyFlag = false;
        this.registrytype = null;
    }

    public void setRegistryUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registryusername = string;
        this.registryusernameDirtyFlag = true;
    }

    public String getRegistryUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryUserName();
        }
        return this.registryusername;
    }

    public boolean isRegistryUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryUserNameDirty();
        }
        return this.registryusernameDirtyFlag;
    }

    public void resetRegistryUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryUserName();
            return;
        }
        this.registryusernameDirtyFlag = false;
        this.registryusername = null;
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
        PSRegistryRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRegistryRepoBase pSRegistryRepoBase) {
        pSRegistryRepoBase.resetConnStr();
        pSRegistryRepoBase.resetCreateDate();
        pSRegistryRepoBase.resetCreateMan();
        pSRegistryRepoBase.resetLocalRes();
        pSRegistryRepoBase.resetLogicName();
        pSRegistryRepoBase.resetMemo();
        pSRegistryRepoBase.resetParam();
        pSRegistryRepoBase.resetParam2();
        pSRegistryRepoBase.resetParam3();
        pSRegistryRepoBase.resetParam4();
        pSRegistryRepoBase.resetParam5();
        pSRegistryRepoBase.resetParam6();
        pSRegistryRepoBase.resetParam7();
        pSRegistryRepoBase.resetParam8();
        pSRegistryRepoBase.resetPSDevCenterId();
        pSRegistryRepoBase.resetPSDevCenterName();
        pSRegistryRepoBase.resetPSObjId();
        pSRegistryRepoBase.resetPSObjName();
        pSRegistryRepoBase.resetPSObjType();
        pSRegistryRepoBase.resetPSRegistryRepoId();
        pSRegistryRepoBase.resetPSRegistryRepoName();
        pSRegistryRepoBase.resetPSRegistryServerId();
        pSRegistryRepoBase.resetPSRegistryServerName();
        pSRegistryRepoBase.resetPSSvrDomainId();
        pSRegistryRepoBase.resetPSSvrDomainName();
        pSRegistryRepoBase.resetReadOnlyMode();
        pSRegistryRepoBase.resetRefInfo();
        pSRegistryRepoBase.resetRegistryPasswd();
        pSRegistryRepoBase.resetRegistryType();
        pSRegistryRepoBase.resetRegistryUserName();
        pSRegistryRepoBase.resetRepoState();
        pSRegistryRepoBase.resetROPasswd();
        pSRegistryRepoBase.resetROUserName();
        pSRegistryRepoBase.resetUpdateDate();
        pSRegistryRepoBase.resetUpdateMan();
        pSRegistryRepoBase.resetValidFlag();
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
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPOID, this.getPSRegistryRepoId());
        }
        if (!bl || this.isPSRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPONAME, this.getPSRegistryRepoName());
        }
        if (!bl || this.isPSRegistryServerIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERID, this.getPSRegistryServerId());
        }
        if (!bl || this.isPSRegistryServerNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERNAME, this.getPSRegistryServerName());
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
        if (!bl || this.isRegistryPasswdDirty()) {
            hashMap.put(FIELD_REGISTRYPASSWD, this.getRegistryPasswd());
        }
        if (!bl || this.isRegistryTypeDirty()) {
            hashMap.put(FIELD_REGISTRYTYPE, this.getRegistryType());
        }
        if (!bl || this.isRegistryUserNameDirty()) {
            hashMap.put(FIELD_REGISTRYUSERNAME, this.getRegistryUserName());
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
        return PSRegistryRepoBase.get(this, n);
    }

    private static Object get(PSRegistryRepoBase pSRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryRepoBase.getConnStr();
            }
            case 1: {
                return pSRegistryRepoBase.getCreateDate();
            }
            case 2: {
                return pSRegistryRepoBase.getCreateMan();
            }
            case 3: {
                return pSRegistryRepoBase.getLocalRes();
            }
            case 4: {
                return pSRegistryRepoBase.getLogicName();
            }
            case 5: {
                return pSRegistryRepoBase.getMemo();
            }
            case 6: {
                return pSRegistryRepoBase.getParam();
            }
            case 7: {
                return pSRegistryRepoBase.getParam2();
            }
            case 8: {
                return pSRegistryRepoBase.getParam3();
            }
            case 9: {
                return pSRegistryRepoBase.getParam4();
            }
            case 10: {
                return pSRegistryRepoBase.getParam5();
            }
            case 11: {
                return pSRegistryRepoBase.getParam6();
            }
            case 12: {
                return pSRegistryRepoBase.getParam7();
            }
            case 13: {
                return pSRegistryRepoBase.getParam8();
            }
            case 14: {
                return pSRegistryRepoBase.getPSDevCenterId();
            }
            case 15: {
                return pSRegistryRepoBase.getPSDevCenterName();
            }
            case 16: {
                return pSRegistryRepoBase.getPSObjId();
            }
            case 17: {
                return pSRegistryRepoBase.getPSObjName();
            }
            case 18: {
                return pSRegistryRepoBase.getPSObjType();
            }
            case 19: {
                return pSRegistryRepoBase.getPSRegistryRepoId();
            }
            case 20: {
                return pSRegistryRepoBase.getPSRegistryRepoName();
            }
            case 21: {
                return pSRegistryRepoBase.getPSRegistryServerId();
            }
            case 22: {
                return pSRegistryRepoBase.getPSRegistryServerName();
            }
            case 23: {
                return pSRegistryRepoBase.getPSSvrDomainId();
            }
            case 24: {
                return pSRegistryRepoBase.getPSSvrDomainName();
            }
            case 25: {
                return pSRegistryRepoBase.getReadOnlyMode();
            }
            case 26: {
                return pSRegistryRepoBase.getRefInfo();
            }
            case 27: {
                return pSRegistryRepoBase.getRegistryPasswd();
            }
            case 28: {
                return pSRegistryRepoBase.getRegistryType();
            }
            case 29: {
                return pSRegistryRepoBase.getRegistryUserName();
            }
            case 30: {
                return pSRegistryRepoBase.getRepoState();
            }
            case 31: {
                return pSRegistryRepoBase.getROPasswd();
            }
            case 32: {
                return pSRegistryRepoBase.getROUserName();
            }
            case 33: {
                return pSRegistryRepoBase.getUpdateDate();
            }
            case 34: {
                return pSRegistryRepoBase.getUpdateMan();
            }
            case 35: {
                return pSRegistryRepoBase.getValidFlag();
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
        PSRegistryRepoBase.set(this, n, object);
    }

    private static void set(PSRegistryRepoBase pSRegistryRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryRepoBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSRegistryRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSRegistryRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRegistryRepoBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSRegistryRepoBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRegistryRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRegistryRepoBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRegistryRepoBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRegistryRepoBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRegistryRepoBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRegistryRepoBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSRegistryRepoBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSRegistryRepoBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSRegistryRepoBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSRegistryRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSRegistryRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSRegistryRepoBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSRegistryRepoBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSRegistryRepoBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSRegistryRepoBase.setPSRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSRegistryRepoBase.setPSRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSRegistryRepoBase.setPSRegistryServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSRegistryRepoBase.setPSRegistryServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSRegistryRepoBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSRegistryRepoBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSRegistryRepoBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSRegistryRepoBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSRegistryRepoBase.setRegistryPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSRegistryRepoBase.setRegistryType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSRegistryRepoBase.setRegistryUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSRegistryRepoBase.setRepoState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSRegistryRepoBase.setROPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSRegistryRepoBase.setROUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSRegistryRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSRegistryRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSRegistryRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRegistryRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSRegistryRepoBase pSRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryRepoBase.getConnStr() == null;
            }
            case 1: {
                return pSRegistryRepoBase.getCreateDate() == null;
            }
            case 2: {
                return pSRegistryRepoBase.getCreateMan() == null;
            }
            case 3: {
                return pSRegistryRepoBase.getLocalRes() == null;
            }
            case 4: {
                return pSRegistryRepoBase.getLogicName() == null;
            }
            case 5: {
                return pSRegistryRepoBase.getMemo() == null;
            }
            case 6: {
                return pSRegistryRepoBase.getParam() == null;
            }
            case 7: {
                return pSRegistryRepoBase.getParam2() == null;
            }
            case 8: {
                return pSRegistryRepoBase.getParam3() == null;
            }
            case 9: {
                return pSRegistryRepoBase.getParam4() == null;
            }
            case 10: {
                return pSRegistryRepoBase.getParam5() == null;
            }
            case 11: {
                return pSRegistryRepoBase.getParam6() == null;
            }
            case 12: {
                return pSRegistryRepoBase.getParam7() == null;
            }
            case 13: {
                return pSRegistryRepoBase.getParam8() == null;
            }
            case 14: {
                return pSRegistryRepoBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSRegistryRepoBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSRegistryRepoBase.getPSObjId() == null;
            }
            case 17: {
                return pSRegistryRepoBase.getPSObjName() == null;
            }
            case 18: {
                return pSRegistryRepoBase.getPSObjType() == null;
            }
            case 19: {
                return pSRegistryRepoBase.getPSRegistryRepoId() == null;
            }
            case 20: {
                return pSRegistryRepoBase.getPSRegistryRepoName() == null;
            }
            case 21: {
                return pSRegistryRepoBase.getPSRegistryServerId() == null;
            }
            case 22: {
                return pSRegistryRepoBase.getPSRegistryServerName() == null;
            }
            case 23: {
                return pSRegistryRepoBase.getPSSvrDomainId() == null;
            }
            case 24: {
                return pSRegistryRepoBase.getPSSvrDomainName() == null;
            }
            case 25: {
                return pSRegistryRepoBase.getReadOnlyMode() == null;
            }
            case 26: {
                return pSRegistryRepoBase.getRefInfo() == null;
            }
            case 27: {
                return pSRegistryRepoBase.getRegistryPasswd() == null;
            }
            case 28: {
                return pSRegistryRepoBase.getRegistryType() == null;
            }
            case 29: {
                return pSRegistryRepoBase.getRegistryUserName() == null;
            }
            case 30: {
                return pSRegistryRepoBase.getRepoState() == null;
            }
            case 31: {
                return pSRegistryRepoBase.getROPasswd() == null;
            }
            case 32: {
                return pSRegistryRepoBase.getROUserName() == null;
            }
            case 33: {
                return pSRegistryRepoBase.getUpdateDate() == null;
            }
            case 34: {
                return pSRegistryRepoBase.getUpdateMan() == null;
            }
            case 35: {
                return pSRegistryRepoBase.getValidFlag() == null;
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
        return PSRegistryRepoBase.contains(this, n);
    }

    private static boolean contains(PSRegistryRepoBase pSRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryRepoBase.isConnStrDirty();
            }
            case 1: {
                return pSRegistryRepoBase.isCreateDateDirty();
            }
            case 2: {
                return pSRegistryRepoBase.isCreateManDirty();
            }
            case 3: {
                return pSRegistryRepoBase.isLocalResDirty();
            }
            case 4: {
                return pSRegistryRepoBase.isLogicNameDirty();
            }
            case 5: {
                return pSRegistryRepoBase.isMemoDirty();
            }
            case 6: {
                return pSRegistryRepoBase.isParamDirty();
            }
            case 7: {
                return pSRegistryRepoBase.isParam2Dirty();
            }
            case 8: {
                return pSRegistryRepoBase.isParam3Dirty();
            }
            case 9: {
                return pSRegistryRepoBase.isParam4Dirty();
            }
            case 10: {
                return pSRegistryRepoBase.isParam5Dirty();
            }
            case 11: {
                return pSRegistryRepoBase.isParam6Dirty();
            }
            case 12: {
                return pSRegistryRepoBase.isParam7Dirty();
            }
            case 13: {
                return pSRegistryRepoBase.isParam8Dirty();
            }
            case 14: {
                return pSRegistryRepoBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSRegistryRepoBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSRegistryRepoBase.isPSObjIdDirty();
            }
            case 17: {
                return pSRegistryRepoBase.isPSObjNameDirty();
            }
            case 18: {
                return pSRegistryRepoBase.isPSObjTypeDirty();
            }
            case 19: {
                return pSRegistryRepoBase.isPSRegistryRepoIdDirty();
            }
            case 20: {
                return pSRegistryRepoBase.isPSRegistryRepoNameDirty();
            }
            case 21: {
                return pSRegistryRepoBase.isPSRegistryServerIdDirty();
            }
            case 22: {
                return pSRegistryRepoBase.isPSRegistryServerNameDirty();
            }
            case 23: {
                return pSRegistryRepoBase.isPSSvrDomainIdDirty();
            }
            case 24: {
                return pSRegistryRepoBase.isPSSvrDomainNameDirty();
            }
            case 25: {
                return pSRegistryRepoBase.isReadOnlyModeDirty();
            }
            case 26: {
                return pSRegistryRepoBase.isRefInfoDirty();
            }
            case 27: {
                return pSRegistryRepoBase.isRegistryPasswdDirty();
            }
            case 28: {
                return pSRegistryRepoBase.isRegistryTypeDirty();
            }
            case 29: {
                return pSRegistryRepoBase.isRegistryUserNameDirty();
            }
            case 30: {
                return pSRegistryRepoBase.isRepoStateDirty();
            }
            case 31: {
                return pSRegistryRepoBase.isROPasswdDirty();
            }
            case 32: {
                return pSRegistryRepoBase.isROUserNameDirty();
            }
            case 33: {
                return pSRegistryRepoBase.isUpdateDateDirty();
            }
            case 34: {
                return pSRegistryRepoBase.isUpdateManDirty();
            }
            case 35: {
                return pSRegistryRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRegistryRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRegistryRepoBase pSRegistryRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRegistryRepoBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getConnStr()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getLogicName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam2()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam3()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam4()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam5()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam6()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam7()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getParam8()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryrepoid", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSRegistryRepoId()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryreponame", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSRegistryRepoName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryserverid", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSRegistryServerId()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryservername", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSRegistryServerName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getRegistryPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrypasswd", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getRegistryPasswd()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getRegistryType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrytype", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getRegistryType()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getRegistryUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registryusername", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getRegistryUserName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getRepoState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repostate", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getRepoState()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getROPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropasswd", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getROPasswd()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getROUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rousername", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getROUserName()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRegistryRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRegistryRepoBase.getJSONValue((Object)pSRegistryRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRegistryRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRegistryRepoBase pSRegistryRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRegistryRepoBase.getConnStr() != null) {
            object = pSRegistryRepoBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getCreateDate() != null) {
            object = pSRegistryRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getCreateMan() != null) {
            object = pSRegistryRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getLocalRes() != null) {
            object = pSRegistryRepoBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getLogicName() != null) {
            object = pSRegistryRepoBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getMemo() != null) {
            object = pSRegistryRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getParam() != null) {
            object = pSRegistryRepoBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getParam2() != null) {
            object = pSRegistryRepoBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getParam3() != null) {
            object = pSRegistryRepoBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getParam4() != null) {
            object = pSRegistryRepoBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getParam5() != null) {
            object = pSRegistryRepoBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getParam6() != null) {
            object = pSRegistryRepoBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getParam7() != null) {
            object = pSRegistryRepoBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getParam8() != null) {
            object = pSRegistryRepoBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getPSDevCenterId() != null) {
            object = pSRegistryRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSDevCenterName() != null) {
            object = pSRegistryRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSObjId() != null) {
            object = pSRegistryRepoBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSObjName() != null) {
            object = pSRegistryRepoBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSObjType() != null) {
            object = pSRegistryRepoBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryRepoId() != null) {
            object = pSRegistryRepoBase.getPSRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryRepoName() != null) {
            object = pSRegistryRepoBase.getPSRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryServerId() != null) {
            object = pSRegistryRepoBase.getPSRegistryServerId();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSRegistryServerName() != null) {
            object = pSRegistryRepoBase.getPSRegistryServerName();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSSvrDomainId() != null) {
            object = pSRegistryRepoBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getPSSvrDomainName() != null) {
            object = pSRegistryRepoBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getReadOnlyMode() != null) {
            object = pSRegistryRepoBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getRefInfo() != null) {
            object = pSRegistryRepoBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getRegistryPasswd() != null) {
            object = pSRegistryRepoBase.getRegistryPasswd();
            xmlNode.setAttribute(FIELD_REGISTRYPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getRegistryType() != null) {
            object = pSRegistryRepoBase.getRegistryType();
            xmlNode.setAttribute(FIELD_REGISTRYTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getRegistryUserName() != null) {
            object = pSRegistryRepoBase.getRegistryUserName();
            xmlNode.setAttribute(FIELD_REGISTRYUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getRepoState() != null) {
            object = pSRegistryRepoBase.getRepoState();
            xmlNode.setAttribute(FIELD_REPOSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getROPasswd() != null) {
            object = pSRegistryRepoBase.getROPasswd();
            xmlNode.setAttribute(FIELD_ROPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getROUserName() != null) {
            object = pSRegistryRepoBase.getROUserName();
            xmlNode.setAttribute(FIELD_ROUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getUpdateDate() != null) {
            object = pSRegistryRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryRepoBase.getUpdateMan() != null) {
            object = pSRegistryRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryRepoBase.getValidFlag() != null) {
            object = pSRegistryRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRegistryRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRegistryRepoBase pSRegistryRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRegistryRepoBase.isConnStrDirty() && (bl || pSRegistryRepoBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSRegistryRepoBase.getConnStr());
        }
        if (pSRegistryRepoBase.isCreateDateDirty() && (bl || pSRegistryRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRegistryRepoBase.getCreateDate());
        }
        if (pSRegistryRepoBase.isCreateManDirty() && (bl || pSRegistryRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRegistryRepoBase.getCreateMan());
        }
        if (pSRegistryRepoBase.isLocalResDirty() && (bl || pSRegistryRepoBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSRegistryRepoBase.getLocalRes());
        }
        if (pSRegistryRepoBase.isLogicNameDirty() && (bl || pSRegistryRepoBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSRegistryRepoBase.getLogicName());
        }
        if (pSRegistryRepoBase.isMemoDirty() && (bl || pSRegistryRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRegistryRepoBase.getMemo());
        }
        if (pSRegistryRepoBase.isParamDirty() && (bl || pSRegistryRepoBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSRegistryRepoBase.getParam());
        }
        if (pSRegistryRepoBase.isParam2Dirty() && (bl || pSRegistryRepoBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSRegistryRepoBase.getParam2());
        }
        if (pSRegistryRepoBase.isParam3Dirty() && (bl || pSRegistryRepoBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSRegistryRepoBase.getParam3());
        }
        if (pSRegistryRepoBase.isParam4Dirty() && (bl || pSRegistryRepoBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSRegistryRepoBase.getParam4());
        }
        if (pSRegistryRepoBase.isParam5Dirty() && (bl || pSRegistryRepoBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSRegistryRepoBase.getParam5());
        }
        if (pSRegistryRepoBase.isParam6Dirty() && (bl || pSRegistryRepoBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSRegistryRepoBase.getParam6());
        }
        if (pSRegistryRepoBase.isParam7Dirty() && (bl || pSRegistryRepoBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSRegistryRepoBase.getParam7());
        }
        if (pSRegistryRepoBase.isParam8Dirty() && (bl || pSRegistryRepoBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSRegistryRepoBase.getParam8());
        }
        if (pSRegistryRepoBase.isPSDevCenterIdDirty() && (bl || pSRegistryRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSRegistryRepoBase.getPSDevCenterId());
        }
        if (pSRegistryRepoBase.isPSDevCenterNameDirty() && (bl || pSRegistryRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSRegistryRepoBase.getPSDevCenterName());
        }
        if (pSRegistryRepoBase.isPSObjIdDirty() && (bl || pSRegistryRepoBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSRegistryRepoBase.getPSObjId());
        }
        if (pSRegistryRepoBase.isPSObjNameDirty() && (bl || pSRegistryRepoBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSRegistryRepoBase.getPSObjName());
        }
        if (pSRegistryRepoBase.isPSObjTypeDirty() && (bl || pSRegistryRepoBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSRegistryRepoBase.getPSObjType());
        }
        if (pSRegistryRepoBase.isPSRegistryRepoIdDirty() && (bl || pSRegistryRepoBase.getPSRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPOID, (Object)pSRegistryRepoBase.getPSRegistryRepoId());
        }
        if (pSRegistryRepoBase.isPSRegistryRepoNameDirty() && (bl || pSRegistryRepoBase.getPSRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPONAME, (Object)pSRegistryRepoBase.getPSRegistryRepoName());
        }
        if (pSRegistryRepoBase.isPSRegistryServerIdDirty() && (bl || pSRegistryRepoBase.getPSRegistryServerId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERID, (Object)pSRegistryRepoBase.getPSRegistryServerId());
        }
        if (pSRegistryRepoBase.isPSRegistryServerNameDirty() && (bl || pSRegistryRepoBase.getPSRegistryServerName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERNAME, (Object)pSRegistryRepoBase.getPSRegistryServerName());
        }
        if (pSRegistryRepoBase.isPSSvrDomainIdDirty() && (bl || pSRegistryRepoBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSRegistryRepoBase.getPSSvrDomainId());
        }
        if (pSRegistryRepoBase.isPSSvrDomainNameDirty() && (bl || pSRegistryRepoBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSRegistryRepoBase.getPSSvrDomainName());
        }
        if (pSRegistryRepoBase.isReadOnlyModeDirty() && (bl || pSRegistryRepoBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSRegistryRepoBase.getReadOnlyMode());
        }
        if (pSRegistryRepoBase.isRefInfoDirty() && (bl || pSRegistryRepoBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSRegistryRepoBase.getRefInfo());
        }
        if (pSRegistryRepoBase.isRegistryPasswdDirty() && (bl || pSRegistryRepoBase.getRegistryPasswd() != null)) {
            iDataObject.set(FIELD_REGISTRYPASSWD, (Object)pSRegistryRepoBase.getRegistryPasswd());
        }
        if (pSRegistryRepoBase.isRegistryTypeDirty() && (bl || pSRegistryRepoBase.getRegistryType() != null)) {
            iDataObject.set(FIELD_REGISTRYTYPE, (Object)pSRegistryRepoBase.getRegistryType());
        }
        if (pSRegistryRepoBase.isRegistryUserNameDirty() && (bl || pSRegistryRepoBase.getRegistryUserName() != null)) {
            iDataObject.set(FIELD_REGISTRYUSERNAME, (Object)pSRegistryRepoBase.getRegistryUserName());
        }
        if (pSRegistryRepoBase.isRepoStateDirty() && (bl || pSRegistryRepoBase.getRepoState() != null)) {
            iDataObject.set(FIELD_REPOSTATE, (Object)pSRegistryRepoBase.getRepoState());
        }
        if (pSRegistryRepoBase.isROPasswdDirty() && (bl || pSRegistryRepoBase.getROPasswd() != null)) {
            iDataObject.set(FIELD_ROPASSWD, (Object)pSRegistryRepoBase.getROPasswd());
        }
        if (pSRegistryRepoBase.isROUserNameDirty() && (bl || pSRegistryRepoBase.getROUserName() != null)) {
            iDataObject.set(FIELD_ROUSERNAME, (Object)pSRegistryRepoBase.getROUserName());
        }
        if (pSRegistryRepoBase.isUpdateDateDirty() && (bl || pSRegistryRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRegistryRepoBase.getUpdateDate());
        }
        if (pSRegistryRepoBase.isUpdateManDirty() && (bl || pSRegistryRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRegistryRepoBase.getUpdateMan());
        }
        if (pSRegistryRepoBase.isValidFlagDirty() && (bl || pSRegistryRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRegistryRepoBase.getValidFlag());
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
        return PSRegistryRepoBase.remove(this, n);
    }

    private static boolean remove(PSRegistryRepoBase pSRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryRepoBase.resetConnStr();
                return true;
            }
            case 1: {
                pSRegistryRepoBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSRegistryRepoBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSRegistryRepoBase.resetLocalRes();
                return true;
            }
            case 4: {
                pSRegistryRepoBase.resetLogicName();
                return true;
            }
            case 5: {
                pSRegistryRepoBase.resetMemo();
                return true;
            }
            case 6: {
                pSRegistryRepoBase.resetParam();
                return true;
            }
            case 7: {
                pSRegistryRepoBase.resetParam2();
                return true;
            }
            case 8: {
                pSRegistryRepoBase.resetParam3();
                return true;
            }
            case 9: {
                pSRegistryRepoBase.resetParam4();
                return true;
            }
            case 10: {
                pSRegistryRepoBase.resetParam5();
                return true;
            }
            case 11: {
                pSRegistryRepoBase.resetParam6();
                return true;
            }
            case 12: {
                pSRegistryRepoBase.resetParam7();
                return true;
            }
            case 13: {
                pSRegistryRepoBase.resetParam8();
                return true;
            }
            case 14: {
                pSRegistryRepoBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSRegistryRepoBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSRegistryRepoBase.resetPSObjId();
                return true;
            }
            case 17: {
                pSRegistryRepoBase.resetPSObjName();
                return true;
            }
            case 18: {
                pSRegistryRepoBase.resetPSObjType();
                return true;
            }
            case 19: {
                pSRegistryRepoBase.resetPSRegistryRepoId();
                return true;
            }
            case 20: {
                pSRegistryRepoBase.resetPSRegistryRepoName();
                return true;
            }
            case 21: {
                pSRegistryRepoBase.resetPSRegistryServerId();
                return true;
            }
            case 22: {
                pSRegistryRepoBase.resetPSRegistryServerName();
                return true;
            }
            case 23: {
                pSRegistryRepoBase.resetPSSvrDomainId();
                return true;
            }
            case 24: {
                pSRegistryRepoBase.resetPSSvrDomainName();
                return true;
            }
            case 25: {
                pSRegistryRepoBase.resetReadOnlyMode();
                return true;
            }
            case 26: {
                pSRegistryRepoBase.resetRefInfo();
                return true;
            }
            case 27: {
                pSRegistryRepoBase.resetRegistryPasswd();
                return true;
            }
            case 28: {
                pSRegistryRepoBase.resetRegistryType();
                return true;
            }
            case 29: {
                pSRegistryRepoBase.resetRegistryUserName();
                return true;
            }
            case 30: {
                pSRegistryRepoBase.resetRepoState();
                return true;
            }
            case 31: {
                pSRegistryRepoBase.resetROPasswd();
                return true;
            }
            case 32: {
                pSRegistryRepoBase.resetROUserName();
                return true;
            }
            case 33: {
                pSRegistryRepoBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSRegistryRepoBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSRegistryRepoBase.resetValidFlag();
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
    public PSRegistryServer getPsregistryserver() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsregistryserver();
        }
        if (this.getPSRegistryServerId() == null) {
            return null;
        }
        Integer n = this.objPsregistryserverLock;
        synchronized (n) {
            if (this.psregistryserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryServerId(), (Object)this.psregistryserver.getPSRegistryServerId()) != 0L) {
                this.psregistryserver = null;
            }
            if (this.psregistryserver == null) {
                PSRegistryServer pSRegistryServer = new PSRegistryServer();
                pSRegistryServer.setPSRegistryServerId(this.getPSRegistryServerId());
                PSRegistryServerService pSRegistryServerService = (PSRegistryServerService)ServiceGlobal.getService(PSRegistryServerService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryServerService.autoGet((IEntity)pSRegistryServer);
                this.psregistryserver = pSRegistryServer;
            }
            return this.psregistryserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPssvrdomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssvrdomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPssvrdomainLock;
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

    private PSRegistryRepoBase getProxyEntity() {
        return this.proxyPSRegistryRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRegistryRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSRegistryRepoBase) {
            this.proxyPSRegistryRepoBase = (PSRegistryRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCALRES, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PARAM, 6);
        fieldIndexMap.put(FIELD_PARAM2, 7);
        fieldIndexMap.put(FIELD_PARAM3, 8);
        fieldIndexMap.put(FIELD_PARAM4, 9);
        fieldIndexMap.put(FIELD_PARAM5, 10);
        fieldIndexMap.put(FIELD_PARAM6, 11);
        fieldIndexMap.put(FIELD_PARAM7, 12);
        fieldIndexMap.put(FIELD_PARAM8, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSOBJID, 16);
        fieldIndexMap.put(FIELD_PSOBJNAME, 17);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 18);
        fieldIndexMap.put(FIELD_PSREGISTRYREPOID, 19);
        fieldIndexMap.put(FIELD_PSREGISTRYREPONAME, 20);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERID, 21);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERNAME, 22);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 23);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 24);
        fieldIndexMap.put(FIELD_READONLYMODE, 25);
        fieldIndexMap.put(FIELD_REFINFO, 26);
        fieldIndexMap.put(FIELD_REGISTRYPASSWD, 27);
        fieldIndexMap.put(FIELD_REGISTRYTYPE, 28);
        fieldIndexMap.put(FIELD_REGISTRYUSERNAME, 29);
        fieldIndexMap.put(FIELD_REPOSTATE, 30);
        fieldIndexMap.put(FIELD_ROPASSWD, 31);
        fieldIndexMap.put(FIELD_ROUSERNAME, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
    }
}

