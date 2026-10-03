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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployDBBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDeployDBBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBNAME = "DBNAME";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSSYSDEPLOYDBID = "PSSYSDEPLOYDBID";
    public static final String FIELD_PSSYSDEPLOYDBNAME = "PSSYSDEPLOYDBNAME";
    public static final String FIELD_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String FIELD_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBNAME = 3;
    private static final int INDEX_DBTYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PASSWD = 6;
    private static final int INDEX_PSDEVCENTERDBINSTID = 7;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 8;
    private static final int INDEX_PSSYSDEPLOYDBID = 9;
    private static final int INDEX_PSSYSDEPLOYDBNAME = 10;
    private static final int INDEX_PSSYSDEPLOYID = 11;
    private static final int INDEX_PSSYSDEPLOYNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERNAME = 15;
    private static final int INDEX_USERPARAMS = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDeployDBBase proxyPSSysDeployDBBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbnameDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean pssysdeploydbidDirtyFlag = false;
    private boolean pssysdeploydbnameDirtyFlag = false;
    private boolean pssysdeployidDirtyFlag = false;
    private boolean pssysdeploynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbname")
    private String dbname;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="pssysdeploydbid")
    private String pssysdeploydbid;
    @Column(name="pssysdeploydbname")
    private String pssysdeploydbname;
    @Column(name="pssysdeployid")
    private String pssysdeployid;
    @Column(name="pssysdeployname")
    private String pssysdeployname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPssysdeployLock = new Integer(1);
    private PSSysDeploy pssysdeploy = null;

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

    public void setDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbname = string;
        this.dbnameDirtyFlag = true;
    }

    public String getDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBName();
        }
        return this.dbname;
    }

    public boolean isDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBNameDirty();
        }
        return this.dbnameDirtyFlag;
    }

    public void resetDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBName();
            return;
        }
        this.dbnameDirtyFlag = false;
        this.dbname = null;
    }

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
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

    public void setPASSWD(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPASSWD(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPASSWD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPASSWD();
        }
        return this.passwd;
    }

    public boolean isPASSWDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPASSWDDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPASSWD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPASSWD();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSSysDeployDBId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployDBId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeploydbid = string;
        this.pssysdeploydbidDirtyFlag = true;
    }

    public String getPSSysDeployDBId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployDBId();
        }
        return this.pssysdeploydbid;
    }

    public boolean isPSSysDeployDBIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployDBIdDirty();
        }
        return this.pssysdeploydbidDirtyFlag;
    }

    public void resetPSSysDeployDBId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployDBId();
            return;
        }
        this.pssysdeploydbidDirtyFlag = false;
        this.pssysdeploydbid = null;
    }

    public void setPSSysDeployDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeploydbname = string;
        this.pssysdeploydbnameDirtyFlag = true;
    }

    public String getPSSysDeployDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployDBName();
        }
        return this.pssysdeploydbname;
    }

    public boolean isPSSysDeployDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployDBNameDirty();
        }
        return this.pssysdeploydbnameDirtyFlag;
    }

    public void resetPSSysDeployDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployDBName();
            return;
        }
        this.pssysdeploydbnameDirtyFlag = false;
        this.pssysdeploydbname = null;
    }

    public void setPSSysDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployid = string;
        this.pssysdeployidDirtyFlag = true;
    }

    public String getPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployId();
        }
        return this.pssysdeployid;
    }

    public boolean isPSSysDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployIdDirty();
        }
        return this.pssysdeployidDirtyFlag;
    }

    public void resetPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployId();
            return;
        }
        this.pssysdeployidDirtyFlag = false;
        this.pssysdeployid = null;
    }

    public void setPSSysDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployname = string;
        this.pssysdeploynameDirtyFlag = true;
    }

    public String getPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployName();
        }
        return this.pssysdeployname;
    }

    public boolean isPSSysDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployNameDirty();
        }
        return this.pssysdeploynameDirtyFlag;
    }

    public void resetPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployName();
            return;
        }
        this.pssysdeploynameDirtyFlag = false;
        this.pssysdeployname = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSSysDeployDBBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDeployDBBase pSSysDeployDBBase) {
        pSSysDeployDBBase.resetConnStr();
        pSSysDeployDBBase.resetCreateDate();
        pSSysDeployDBBase.resetCreateMan();
        pSSysDeployDBBase.resetDBName();
        pSSysDeployDBBase.resetDBType();
        pSSysDeployDBBase.resetMemo();
        pSSysDeployDBBase.resetPASSWD();
        pSSysDeployDBBase.resetPSDevCenterDBInstId();
        pSSysDeployDBBase.resetPSDevCenterDBInstName();
        pSSysDeployDBBase.resetPSSysDeployDBId();
        pSSysDeployDBBase.resetPSSysDeployDBName();
        pSSysDeployDBBase.resetPSSysDeployId();
        pSSysDeployDBBase.resetPSSysDeployName();
        pSSysDeployDBBase.resetUpdateDate();
        pSSysDeployDBBase.resetUpdateMan();
        pSSysDeployDBBase.resetUserName();
        pSSysDeployDBBase.resetUserParams();
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
        if (!bl || this.isDBNameDirty()) {
            hashMap.put(FIELD_DBNAME, this.getDBName());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPASSWDDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPASSWD());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSSysDeployDBIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYDBID, this.getPSSysDeployDBId());
        }
        if (!bl || this.isPSSysDeployDBNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYDBNAME, this.getPSSysDeployDBName());
        }
        if (!bl || this.isPSSysDeployIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYID, this.getPSSysDeployId());
        }
        if (!bl || this.isPSSysDeployNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYNAME, this.getPSSysDeployName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSSysDeployDBBase.get(this, n);
    }

    private static Object get(PSSysDeployDBBase pSSysDeployDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployDBBase.getConnStr();
            }
            case 1: {
                return pSSysDeployDBBase.getCreateDate();
            }
            case 2: {
                return pSSysDeployDBBase.getCreateMan();
            }
            case 3: {
                return pSSysDeployDBBase.getDBName();
            }
            case 4: {
                return pSSysDeployDBBase.getDBType();
            }
            case 5: {
                return pSSysDeployDBBase.getMemo();
            }
            case 6: {
                return pSSysDeployDBBase.getPASSWD();
            }
            case 7: {
                return pSSysDeployDBBase.getPSDevCenterDBInstId();
            }
            case 8: {
                return pSSysDeployDBBase.getPSDevCenterDBInstName();
            }
            case 9: {
                return pSSysDeployDBBase.getPSSysDeployDBId();
            }
            case 10: {
                return pSSysDeployDBBase.getPSSysDeployDBName();
            }
            case 11: {
                return pSSysDeployDBBase.getPSSysDeployId();
            }
            case 12: {
                return pSSysDeployDBBase.getPSSysDeployName();
            }
            case 13: {
                return pSSysDeployDBBase.getUpdateDate();
            }
            case 14: {
                return pSSysDeployDBBase.getUpdateMan();
            }
            case 15: {
                return pSSysDeployDBBase.getUserName();
            }
            case 16: {
                return pSSysDeployDBBase.getUserParams();
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
        PSSysDeployDBBase.set(this, n, object);
    }

    private static void set(PSSysDeployDBBase pSSysDeployDBBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployDBBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDeployDBBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDeployDBBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDeployDBBase.setDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDeployDBBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDeployDBBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDeployDBBase.setPASSWD(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDeployDBBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDeployDBBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDeployDBBase.setPSSysDeployDBId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDeployDBBase.setPSSysDeployDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDeployDBBase.setPSSysDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDeployDBBase.setPSSysDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDeployDBBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSysDeployDBBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDeployDBBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDeployDBBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSSysDeployDBBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDeployDBBase pSSysDeployDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployDBBase.getConnStr() == null;
            }
            case 1: {
                return pSSysDeployDBBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDeployDBBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDeployDBBase.getDBName() == null;
            }
            case 4: {
                return pSSysDeployDBBase.getDBType() == null;
            }
            case 5: {
                return pSSysDeployDBBase.getMemo() == null;
            }
            case 6: {
                return pSSysDeployDBBase.getPASSWD() == null;
            }
            case 7: {
                return pSSysDeployDBBase.getPSDevCenterDBInstId() == null;
            }
            case 8: {
                return pSSysDeployDBBase.getPSDevCenterDBInstName() == null;
            }
            case 9: {
                return pSSysDeployDBBase.getPSSysDeployDBId() == null;
            }
            case 10: {
                return pSSysDeployDBBase.getPSSysDeployDBName() == null;
            }
            case 11: {
                return pSSysDeployDBBase.getPSSysDeployId() == null;
            }
            case 12: {
                return pSSysDeployDBBase.getPSSysDeployName() == null;
            }
            case 13: {
                return pSSysDeployDBBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSysDeployDBBase.getUpdateMan() == null;
            }
            case 15: {
                return pSSysDeployDBBase.getUserName() == null;
            }
            case 16: {
                return pSSysDeployDBBase.getUserParams() == null;
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
        return PSSysDeployDBBase.contains(this, n);
    }

    private static boolean contains(PSSysDeployDBBase pSSysDeployDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployDBBase.isConnStrDirty();
            }
            case 1: {
                return pSSysDeployDBBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDeployDBBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDeployDBBase.isDBNameDirty();
            }
            case 4: {
                return pSSysDeployDBBase.isDBTypeDirty();
            }
            case 5: {
                return pSSysDeployDBBase.isMemoDirty();
            }
            case 6: {
                return pSSysDeployDBBase.isPASSWDDirty();
            }
            case 7: {
                return pSSysDeployDBBase.isPSDevCenterDBInstIdDirty();
            }
            case 8: {
                return pSSysDeployDBBase.isPSDevCenterDBInstNameDirty();
            }
            case 9: {
                return pSSysDeployDBBase.isPSSysDeployDBIdDirty();
            }
            case 10: {
                return pSSysDeployDBBase.isPSSysDeployDBNameDirty();
            }
            case 11: {
                return pSSysDeployDBBase.isPSSysDeployIdDirty();
            }
            case 12: {
                return pSSysDeployDBBase.isPSSysDeployNameDirty();
            }
            case 13: {
                return pSSysDeployDBBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSysDeployDBBase.isUpdateManDirty();
            }
            case 15: {
                return pSSysDeployDBBase.isUserNameDirty();
            }
            case 16: {
                return pSSysDeployDBBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDeployDBBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDeployDBBase pSSysDeployDBBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDeployDBBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getConnStr()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbname", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getDBName()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getDBType()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPASSWD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPASSWD()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployDBId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeploydbid", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSSysDeployDBId()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeploydbname", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSSysDeployDBName()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployid", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSSysDeployId()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployname", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getPSSysDeployName()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getUserName()), (boolean)false);
        }
        if (bl || pSSysDeployDBBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysDeployDBBase.getJSONValue((Object)pSSysDeployDBBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDeployDBBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDeployDBBase pSSysDeployDBBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDeployDBBase.getConnStr() != null) {
            object = pSSysDeployDBBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getCreateDate() != null) {
            object = pSSysDeployDBBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployDBBase.getCreateMan() != null) {
            object = pSSysDeployDBBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getDBName() != null) {
            object = pSSysDeployDBBase.getDBName();
            xmlNode.setAttribute(FIELD_DBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getDBType() != null) {
            object = pSSysDeployDBBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getMemo() != null) {
            object = pSSysDeployDBBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPASSWD() != null) {
            object = pSSysDeployDBBase.getPASSWD();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSDevCenterDBInstId() != null) {
            object = pSSysDeployDBBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSDevCenterDBInstName() != null) {
            object = pSSysDeployDBBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployDBId() != null) {
            object = pSSysDeployDBBase.getPSSysDeployDBId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYDBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployDBName() != null) {
            object = pSSysDeployDBBase.getPSSysDeployDBName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYDBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployId() != null) {
            object = pSSysDeployDBBase.getPSSysDeployId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getPSSysDeployName() != null) {
            object = pSSysDeployDBBase.getPSSysDeployName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getUpdateDate() != null) {
            object = pSSysDeployDBBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployDBBase.getUpdateMan() != null) {
            object = pSSysDeployDBBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getUserName() != null) {
            object = pSSysDeployDBBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployDBBase.getUserParams() != null) {
            object = pSSysDeployDBBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDeployDBBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDeployDBBase pSSysDeployDBBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDeployDBBase.isConnStrDirty() && (bl || pSSysDeployDBBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSSysDeployDBBase.getConnStr());
        }
        if (pSSysDeployDBBase.isCreateDateDirty() && (bl || pSSysDeployDBBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDeployDBBase.getCreateDate());
        }
        if (pSSysDeployDBBase.isCreateManDirty() && (bl || pSSysDeployDBBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDeployDBBase.getCreateMan());
        }
        if (pSSysDeployDBBase.isDBNameDirty() && (bl || pSSysDeployDBBase.getDBName() != null)) {
            iDataObject.set(FIELD_DBNAME, (Object)pSSysDeployDBBase.getDBName());
        }
        if (pSSysDeployDBBase.isDBTypeDirty() && (bl || pSSysDeployDBBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSSysDeployDBBase.getDBType());
        }
        if (pSSysDeployDBBase.isMemoDirty() && (bl || pSSysDeployDBBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDeployDBBase.getMemo());
        }
        if (pSSysDeployDBBase.isPASSWDDirty() && (bl || pSSysDeployDBBase.getPASSWD() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSysDeployDBBase.getPASSWD());
        }
        if (pSSysDeployDBBase.isPSDevCenterDBInstIdDirty() && (bl || pSSysDeployDBBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSSysDeployDBBase.getPSDevCenterDBInstId());
        }
        if (pSSysDeployDBBase.isPSDevCenterDBInstNameDirty() && (bl || pSSysDeployDBBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSSysDeployDBBase.getPSDevCenterDBInstName());
        }
        if (pSSysDeployDBBase.isPSSysDeployDBIdDirty() && (bl || pSSysDeployDBBase.getPSSysDeployDBId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYDBID, (Object)pSSysDeployDBBase.getPSSysDeployDBId());
        }
        if (pSSysDeployDBBase.isPSSysDeployDBNameDirty() && (bl || pSSysDeployDBBase.getPSSysDeployDBName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYDBNAME, (Object)pSSysDeployDBBase.getPSSysDeployDBName());
        }
        if (pSSysDeployDBBase.isPSSysDeployIdDirty() && (bl || pSSysDeployDBBase.getPSSysDeployId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYID, (Object)pSSysDeployDBBase.getPSSysDeployId());
        }
        if (pSSysDeployDBBase.isPSSysDeployNameDirty() && (bl || pSSysDeployDBBase.getPSSysDeployName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYNAME, (Object)pSSysDeployDBBase.getPSSysDeployName());
        }
        if (pSSysDeployDBBase.isUpdateDateDirty() && (bl || pSSysDeployDBBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDeployDBBase.getUpdateDate());
        }
        if (pSSysDeployDBBase.isUpdateManDirty() && (bl || pSSysDeployDBBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDeployDBBase.getUpdateMan());
        }
        if (pSSysDeployDBBase.isUserNameDirty() && (bl || pSSysDeployDBBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSSysDeployDBBase.getUserName());
        }
        if (pSSysDeployDBBase.isUserParamsDirty() && (bl || pSSysDeployDBBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysDeployDBBase.getUserParams());
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
        return PSSysDeployDBBase.remove(this, n);
    }

    private static boolean remove(PSSysDeployDBBase pSSysDeployDBBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployDBBase.resetConnStr();
                return true;
            }
            case 1: {
                pSSysDeployDBBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDeployDBBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDeployDBBase.resetDBName();
                return true;
            }
            case 4: {
                pSSysDeployDBBase.resetDBType();
                return true;
            }
            case 5: {
                pSSysDeployDBBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysDeployDBBase.resetPASSWD();
                return true;
            }
            case 7: {
                pSSysDeployDBBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 8: {
                pSSysDeployDBBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 9: {
                pSSysDeployDBBase.resetPSSysDeployDBId();
                return true;
            }
            case 10: {
                pSSysDeployDBBase.resetPSSysDeployDBName();
                return true;
            }
            case 11: {
                pSSysDeployDBBase.resetPSSysDeployId();
                return true;
            }
            case 12: {
                pSSysDeployDBBase.resetPSSysDeployName();
                return true;
            }
            case 13: {
                pSSysDeployDBBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSysDeployDBBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSSysDeployDBBase.resetUserName();
                return true;
            }
            case 16: {
                pSSysDeployDBBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDeploy getPssysdeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysdeploy();
        }
        if (this.getPSSysDeployId() == null) {
            return null;
        }
        Integer n = this.objPssysdeployLock;
        synchronized (n) {
            if (this.pssysdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDeployId(), (Object)this.pssysdeploy.getPSSysDeployId()) != 0L) {
                this.pssysdeploy = null;
            }
            if (this.pssysdeploy == null) {
                PSSysDeploy pSSysDeploy = new PSSysDeploy();
                pSSysDeploy.setPSSysDeployId(this.getPSSysDeployId());
                PSSysDeployService pSSysDeployService = (PSSysDeployService)ServiceGlobal.getService(PSSysDeployService.class, (SessionFactory)this.getSessionFactory());
                pSSysDeployService.autoGet(pSSysDeploy);
                this.pssysdeploy = pSSysDeploy;
            }
            return this.pssysdeploy;
        }
    }

    private PSSysDeployDBBase getProxyEntity() {
        return this.proxyPSSysDeployDBBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDeployDBBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDeployDBBase) {
            this.proxyPSSysDeployDBBase = (PSSysDeployDBBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployDBService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBNAME, 3);
        fieldIndexMap.put(FIELD_DBTYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PASSWD, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYDBID, 9);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYDBNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYID, 11);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERNAME, 15);
        fieldIndexMap.put(FIELD_USERPARAMS, 16);
    }
}

