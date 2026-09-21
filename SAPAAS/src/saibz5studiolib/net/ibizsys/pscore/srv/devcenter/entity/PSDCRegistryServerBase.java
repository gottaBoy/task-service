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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRegistryServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRegistryServerBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDCREGISTRYSERVERID = "PSDCREGISTRYSERVERID";
    public static final String FIELD_PSDCREGISTRYSERVERNAME = "PSDCREGISTRYSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REGISTRYTYPE = "REGISTRYTYPE";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PARAM = 5;
    private static final int INDEX_PARAM2 = 6;
    private static final int INDEX_PARAM3 = 7;
    private static final int INDEX_PARAM4 = 8;
    private static final int INDEX_PSCREDENTIALID = 9;
    private static final int INDEX_PSCREDENTIALNAME = 10;
    private static final int INDEX_PSDCREGISTRYSERVERID = 11;
    private static final int INDEX_PSDCREGISTRYSERVERNAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_REGISTRYTYPE = 15;
    private static final int INDEX_RESSTATE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRegistryServerBase proxyPSDCRegistryServerBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdcregistryserveridDirtyFlag = false;
    private boolean psdcregistryservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean registrytypeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
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
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdcregistryserverid")
    private String psdcregistryserverid;
    @Column(name="psdcregistryservername")
    private String psdcregistryservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="registrytype")
    private String registrytype;
    @Column(name="resstate")
    private Integer resstate;
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
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setPSDCRegistryServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryserverid = string;
        this.psdcregistryserveridDirtyFlag = true;
    }

    public String getPSDCRegistryServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryServerId();
        }
        return this.psdcregistryserverid;
    }

    public boolean isPSDCRegistryServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryServerIdDirty();
        }
        return this.psdcregistryserveridDirtyFlag;
    }

    public void resetPSDCRegistryServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryServerId();
            return;
        }
        this.psdcregistryserveridDirtyFlag = false;
        this.psdcregistryserverid = null;
    }

    public void setPSDCRegistryServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryservername = string;
        this.psdcregistryservernameDirtyFlag = true;
    }

    public String getPSDCRegistryServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryServerName();
        }
        return this.psdcregistryservername;
    }

    public boolean isPSDCRegistryServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryServerNameDirty();
        }
        return this.psdcregistryservernameDirtyFlag;
    }

    public void resetPSDCRegistryServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryServerName();
            return;
        }
        this.psdcregistryservernameDirtyFlag = false;
        this.psdcregistryservername = null;
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

    protected void onReset() {
        PSDCRegistryServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRegistryServerBase pSDCRegistryServerBase) {
        pSDCRegistryServerBase.resetConnStr();
        pSDCRegistryServerBase.resetCreateDate();
        pSDCRegistryServerBase.resetCreateMan();
        pSDCRegistryServerBase.resetDefaultFlag();
        pSDCRegistryServerBase.resetMemo();
        pSDCRegistryServerBase.resetParam();
        pSDCRegistryServerBase.resetParam2();
        pSDCRegistryServerBase.resetParam3();
        pSDCRegistryServerBase.resetParam4();
        pSDCRegistryServerBase.resetPSCredentialId();
        pSDCRegistryServerBase.resetPSCredentialName();
        pSDCRegistryServerBase.resetPSDCRegistryServerId();
        pSDCRegistryServerBase.resetPSDCRegistryServerName();
        pSDCRegistryServerBase.resetPSDevCenterId();
        pSDCRegistryServerBase.resetPSDevCenterName();
        pSDCRegistryServerBase.resetRegistryType();
        pSDCRegistryServerBase.resetResState();
        pSDCRegistryServerBase.resetUpdateDate();
        pSDCRegistryServerBase.resetUpdateMan();
        pSDCRegistryServerBase.resetUserTag();
        pSDCRegistryServerBase.resetUserTag2();
        pSDCRegistryServerBase.resetUserTag3();
        pSDCRegistryServerBase.resetUserTag4();
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
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSDCRegistryServerIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYSERVERID, this.getPSDCRegistryServerId());
        }
        if (!bl || this.isPSDCRegistryServerNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYSERVERNAME, this.getPSDCRegistryServerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isRegistryTypeDirty()) {
            hashMap.put(FIELD_REGISTRYTYPE, this.getRegistryType());
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
        return PSDCRegistryServerBase.get(this, n);
    }

    private static Object get(PSDCRegistryServerBase pSDCRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryServerBase.getConnStr();
            }
            case 1: {
                return pSDCRegistryServerBase.getCreateDate();
            }
            case 2: {
                return pSDCRegistryServerBase.getCreateMan();
            }
            case 3: {
                return pSDCRegistryServerBase.getDefaultFlag();
            }
            case 4: {
                return pSDCRegistryServerBase.getMemo();
            }
            case 5: {
                return pSDCRegistryServerBase.getParam();
            }
            case 6: {
                return pSDCRegistryServerBase.getParam2();
            }
            case 7: {
                return pSDCRegistryServerBase.getParam3();
            }
            case 8: {
                return pSDCRegistryServerBase.getParam4();
            }
            case 9: {
                return pSDCRegistryServerBase.getPSCredentialId();
            }
            case 10: {
                return pSDCRegistryServerBase.getPSCredentialName();
            }
            case 11: {
                return pSDCRegistryServerBase.getPSDCRegistryServerId();
            }
            case 12: {
                return pSDCRegistryServerBase.getPSDCRegistryServerName();
            }
            case 13: {
                return pSDCRegistryServerBase.getPSDevCenterId();
            }
            case 14: {
                return pSDCRegistryServerBase.getPSDevCenterName();
            }
            case 15: {
                return pSDCRegistryServerBase.getRegistryType();
            }
            case 16: {
                return pSDCRegistryServerBase.getResState();
            }
            case 17: {
                return pSDCRegistryServerBase.getUpdateDate();
            }
            case 18: {
                return pSDCRegistryServerBase.getUpdateMan();
            }
            case 19: {
                return pSDCRegistryServerBase.getUserTag();
            }
            case 20: {
                return pSDCRegistryServerBase.getUserTag2();
            }
            case 21: {
                return pSDCRegistryServerBase.getUserTag3();
            }
            case 22: {
                return pSDCRegistryServerBase.getUserTag4();
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
        PSDCRegistryServerBase.set(this, n, object);
    }

    private static void set(PSDCRegistryServerBase pSDCRegistryServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryServerBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCRegistryServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCRegistryServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCRegistryServerBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCRegistryServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCRegistryServerBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCRegistryServerBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCRegistryServerBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCRegistryServerBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCRegistryServerBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRegistryServerBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCRegistryServerBase.setPSDCRegistryServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRegistryServerBase.setPSDCRegistryServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCRegistryServerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRegistryServerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCRegistryServerBase.setRegistryType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRegistryServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDCRegistryServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDCRegistryServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCRegistryServerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCRegistryServerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCRegistryServerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCRegistryServerBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCRegistryServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRegistryServerBase pSDCRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryServerBase.getConnStr() == null;
            }
            case 1: {
                return pSDCRegistryServerBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCRegistryServerBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCRegistryServerBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSDCRegistryServerBase.getMemo() == null;
            }
            case 5: {
                return pSDCRegistryServerBase.getParam() == null;
            }
            case 6: {
                return pSDCRegistryServerBase.getParam2() == null;
            }
            case 7: {
                return pSDCRegistryServerBase.getParam3() == null;
            }
            case 8: {
                return pSDCRegistryServerBase.getParam4() == null;
            }
            case 9: {
                return pSDCRegistryServerBase.getPSCredentialId() == null;
            }
            case 10: {
                return pSDCRegistryServerBase.getPSCredentialName() == null;
            }
            case 11: {
                return pSDCRegistryServerBase.getPSDCRegistryServerId() == null;
            }
            case 12: {
                return pSDCRegistryServerBase.getPSDCRegistryServerName() == null;
            }
            case 13: {
                return pSDCRegistryServerBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDCRegistryServerBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDCRegistryServerBase.getRegistryType() == null;
            }
            case 16: {
                return pSDCRegistryServerBase.getResState() == null;
            }
            case 17: {
                return pSDCRegistryServerBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDCRegistryServerBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDCRegistryServerBase.getUserTag() == null;
            }
            case 20: {
                return pSDCRegistryServerBase.getUserTag2() == null;
            }
            case 21: {
                return pSDCRegistryServerBase.getUserTag3() == null;
            }
            case 22: {
                return pSDCRegistryServerBase.getUserTag4() == null;
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
        return PSDCRegistryServerBase.contains(this, n);
    }

    private static boolean contains(PSDCRegistryServerBase pSDCRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryServerBase.isConnStrDirty();
            }
            case 1: {
                return pSDCRegistryServerBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCRegistryServerBase.isCreateManDirty();
            }
            case 3: {
                return pSDCRegistryServerBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSDCRegistryServerBase.isMemoDirty();
            }
            case 5: {
                return pSDCRegistryServerBase.isParamDirty();
            }
            case 6: {
                return pSDCRegistryServerBase.isParam2Dirty();
            }
            case 7: {
                return pSDCRegistryServerBase.isParam3Dirty();
            }
            case 8: {
                return pSDCRegistryServerBase.isParam4Dirty();
            }
            case 9: {
                return pSDCRegistryServerBase.isPSCredentialIdDirty();
            }
            case 10: {
                return pSDCRegistryServerBase.isPSCredentialNameDirty();
            }
            case 11: {
                return pSDCRegistryServerBase.isPSDCRegistryServerIdDirty();
            }
            case 12: {
                return pSDCRegistryServerBase.isPSDCRegistryServerNameDirty();
            }
            case 13: {
                return pSDCRegistryServerBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDCRegistryServerBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDCRegistryServerBase.isRegistryTypeDirty();
            }
            case 16: {
                return pSDCRegistryServerBase.isResStateDirty();
            }
            case 17: {
                return pSDCRegistryServerBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDCRegistryServerBase.isUpdateManDirty();
            }
            case 19: {
                return pSDCRegistryServerBase.isUserTagDirty();
            }
            case 20: {
                return pSDCRegistryServerBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDCRegistryServerBase.isUserTag3Dirty();
            }
            case 22: {
                return pSDCRegistryServerBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRegistryServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRegistryServerBase pSDCRegistryServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRegistryServerBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getParam()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getParam3()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getParam4()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSDCRegistryServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryserverid", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSDCRegistryServerId()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSDCRegistryServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryservername", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSDCRegistryServerName()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getRegistryType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrytype", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getRegistryType()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCRegistryServerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCRegistryServerBase.getJSONValue((Object)pSDCRegistryServerBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRegistryServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRegistryServerBase pSDCRegistryServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRegistryServerBase.getConnStr() != null) {
            object = pSDCRegistryServerBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getCreateDate() != null) {
            object = pSDCRegistryServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryServerBase.getCreateMan() != null) {
            object = pSDCRegistryServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getDefaultFlag() != null) {
            object = pSDCRegistryServerBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryServerBase.getMemo() != null) {
            object = pSDCRegistryServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getParam() != null) {
            object = pSDCRegistryServerBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getParam2() != null) {
            object = pSDCRegistryServerBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getParam3() != null) {
            object = pSDCRegistryServerBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getParam4() != null) {
            object = pSDCRegistryServerBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSCredentialId() != null) {
            object = pSDCRegistryServerBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSCredentialName() != null) {
            object = pSDCRegistryServerBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSDCRegistryServerId() != null) {
            object = pSDCRegistryServerBase.getPSDCRegistryServerId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSDCRegistryServerName() != null) {
            object = pSDCRegistryServerBase.getPSDCRegistryServerName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSDevCenterId() != null) {
            object = pSDCRegistryServerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getPSDevCenterName() != null) {
            object = pSDCRegistryServerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getRegistryType() != null) {
            object = pSDCRegistryServerBase.getRegistryType();
            xmlNode.setAttribute(FIELD_REGISTRYTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getResState() != null) {
            object = pSDCRegistryServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryServerBase.getUpdateDate() != null) {
            object = pSDCRegistryServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryServerBase.getUpdateMan() != null) {
            object = pSDCRegistryServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getUserTag() != null) {
            object = pSDCRegistryServerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getUserTag2() != null) {
            object = pSDCRegistryServerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getUserTag3() != null) {
            object = pSDCRegistryServerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryServerBase.getUserTag4() != null) {
            object = pSDCRegistryServerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRegistryServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRegistryServerBase pSDCRegistryServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRegistryServerBase.isConnStrDirty() && (bl || pSDCRegistryServerBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCRegistryServerBase.getConnStr());
        }
        if (pSDCRegistryServerBase.isCreateDateDirty() && (bl || pSDCRegistryServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRegistryServerBase.getCreateDate());
        }
        if (pSDCRegistryServerBase.isCreateManDirty() && (bl || pSDCRegistryServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRegistryServerBase.getCreateMan());
        }
        if (pSDCRegistryServerBase.isDefaultFlagDirty() && (bl || pSDCRegistryServerBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCRegistryServerBase.getDefaultFlag());
        }
        if (pSDCRegistryServerBase.isMemoDirty() && (bl || pSDCRegistryServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCRegistryServerBase.getMemo());
        }
        if (pSDCRegistryServerBase.isParamDirty() && (bl || pSDCRegistryServerBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCRegistryServerBase.getParam());
        }
        if (pSDCRegistryServerBase.isParam2Dirty() && (bl || pSDCRegistryServerBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCRegistryServerBase.getParam2());
        }
        if (pSDCRegistryServerBase.isParam3Dirty() && (bl || pSDCRegistryServerBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDCRegistryServerBase.getParam3());
        }
        if (pSDCRegistryServerBase.isParam4Dirty() && (bl || pSDCRegistryServerBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDCRegistryServerBase.getParam4());
        }
        if (pSDCRegistryServerBase.isPSCredentialIdDirty() && (bl || pSDCRegistryServerBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDCRegistryServerBase.getPSCredentialId());
        }
        if (pSDCRegistryServerBase.isPSCredentialNameDirty() && (bl || pSDCRegistryServerBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDCRegistryServerBase.getPSCredentialName());
        }
        if (pSDCRegistryServerBase.isPSDCRegistryServerIdDirty() && (bl || pSDCRegistryServerBase.getPSDCRegistryServerId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYSERVERID, (Object)pSDCRegistryServerBase.getPSDCRegistryServerId());
        }
        if (pSDCRegistryServerBase.isPSDCRegistryServerNameDirty() && (bl || pSDCRegistryServerBase.getPSDCRegistryServerName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYSERVERNAME, (Object)pSDCRegistryServerBase.getPSDCRegistryServerName());
        }
        if (pSDCRegistryServerBase.isPSDevCenterIdDirty() && (bl || pSDCRegistryServerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCRegistryServerBase.getPSDevCenterId());
        }
        if (pSDCRegistryServerBase.isPSDevCenterNameDirty() && (bl || pSDCRegistryServerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCRegistryServerBase.getPSDevCenterName());
        }
        if (pSDCRegistryServerBase.isRegistryTypeDirty() && (bl || pSDCRegistryServerBase.getRegistryType() != null)) {
            iDataObject.set(FIELD_REGISTRYTYPE, (Object)pSDCRegistryServerBase.getRegistryType());
        }
        if (pSDCRegistryServerBase.isResStateDirty() && (bl || pSDCRegistryServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCRegistryServerBase.getResState());
        }
        if (pSDCRegistryServerBase.isUpdateDateDirty() && (bl || pSDCRegistryServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRegistryServerBase.getUpdateDate());
        }
        if (pSDCRegistryServerBase.isUpdateManDirty() && (bl || pSDCRegistryServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRegistryServerBase.getUpdateMan());
        }
        if (pSDCRegistryServerBase.isUserTagDirty() && (bl || pSDCRegistryServerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCRegistryServerBase.getUserTag());
        }
        if (pSDCRegistryServerBase.isUserTag2Dirty() && (bl || pSDCRegistryServerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCRegistryServerBase.getUserTag2());
        }
        if (pSDCRegistryServerBase.isUserTag3Dirty() && (bl || pSDCRegistryServerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCRegistryServerBase.getUserTag3());
        }
        if (pSDCRegistryServerBase.isUserTag4Dirty() && (bl || pSDCRegistryServerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCRegistryServerBase.getUserTag4());
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
        return PSDCRegistryServerBase.remove(this, n);
    }

    private static boolean remove(PSDCRegistryServerBase pSDCRegistryServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryServerBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCRegistryServerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCRegistryServerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCRegistryServerBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSDCRegistryServerBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCRegistryServerBase.resetParam();
                return true;
            }
            case 6: {
                pSDCRegistryServerBase.resetParam2();
                return true;
            }
            case 7: {
                pSDCRegistryServerBase.resetParam3();
                return true;
            }
            case 8: {
                pSDCRegistryServerBase.resetParam4();
                return true;
            }
            case 9: {
                pSDCRegistryServerBase.resetPSCredentialId();
                return true;
            }
            case 10: {
                pSDCRegistryServerBase.resetPSCredentialName();
                return true;
            }
            case 11: {
                pSDCRegistryServerBase.resetPSDCRegistryServerId();
                return true;
            }
            case 12: {
                pSDCRegistryServerBase.resetPSDCRegistryServerName();
                return true;
            }
            case 13: {
                pSDCRegistryServerBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDCRegistryServerBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDCRegistryServerBase.resetRegistryType();
                return true;
            }
            case 16: {
                pSDCRegistryServerBase.resetResState();
                return true;
            }
            case 17: {
                pSDCRegistryServerBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDCRegistryServerBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDCRegistryServerBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDCRegistryServerBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDCRegistryServerBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSDCRegistryServerBase.resetUserTag4();
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
                pSCredentialService.autoGet((IEntity)pSCredential);
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCRegistryServerBase getProxyEntity() {
        return this.proxyPSDCRegistryServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRegistryServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRegistryServerBase) {
            this.proxyPSDCRegistryServerBase = (PSDCRegistryServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PARAM, 5);
        fieldIndexMap.put(FIELD_PARAM2, 6);
        fieldIndexMap.put(FIELD_PARAM3, 7);
        fieldIndexMap.put(FIELD_PARAM4, 8);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 9);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 10);
        fieldIndexMap.put(FIELD_PSDCREGISTRYSERVERID, 11);
        fieldIndexMap.put(FIELD_PSDCREGISTRYSERVERNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_REGISTRYTYPE, 15);
        fieldIndexMap.put(FIELD_RESSTATE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

