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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBNAME = "DBNAME";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDBSERVERID = "PSDBSERVERID";
    public static final String FIELD_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String FIELD_PSDCINSTID = "PSDCINSTID";
    public static final String FIELD_PSDCINSTNAME = "PSDCINSTNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEDSIZE = "USEDSIZE";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBNAME = 3;
    private static final int INDEX_DBTYPE = 4;
    private static final int INDEX_INSTSTATE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELVER = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PASSWD = 9;
    private static final int INDEX_PSDBSERVERID = 10;
    private static final int INDEX_PSDBSERVERNAME = 11;
    private static final int INDEX_PSDCINSTID = 12;
    private static final int INDEX_PSDCINSTNAME = 13;
    private static final int INDEX_PSSVRDOMAINID = 14;
    private static final int INDEX_PSSVRDOMAINNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USEDSIZE = 18;
    private static final int INDEX_USERNAME = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCInstBase proxyPSDCInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbnameDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdbserveridDirtyFlag = false;
    private boolean psdbservernameDirtyFlag = false;
    private boolean psdcinstidDirtyFlag = false;
    private boolean psdcinstnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usedsizeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
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
    @Column(name="inststate")
    private String inststate;
    @Column(name="memo")
    private String memo;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdbserverid")
    private String psdbserverid;
    @Column(name="psdbservername")
    private String psdbservername;
    @Column(name="psdcinstid")
    private String psdcinstid;
    @Column(name="psdcinstname")
    private String psdcinstname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usedsize")
    private Integer usedsize;
    @Column(name="username")
    private String username;
    private Integer objPSDBServerLock = new Integer(1);
    private PSDBServer psdbserver = null;
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

    public void setInstState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inststate = string;
        this.inststateDirtyFlag = true;
    }

    public String getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
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

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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

    public void setPSDBServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbserverid = string;
        this.psdbserveridDirtyFlag = true;
    }

    public String getPSDBServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerId();
        }
        return this.psdbserverid;
    }

    public boolean isPSDBServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerIdDirty();
        }
        return this.psdbserveridDirtyFlag;
    }

    public void resetPSDBServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerId();
            return;
        }
        this.psdbserveridDirtyFlag = false;
        this.psdbserverid = null;
    }

    public void setPSDBServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbservername = string;
        this.psdbservernameDirtyFlag = true;
    }

    public String getPSDBServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerName();
        }
        return this.psdbservername;
    }

    public boolean isPSDBServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerNameDirty();
        }
        return this.psdbservernameDirtyFlag;
    }

    public void resetPSDBServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerName();
            return;
        }
        this.psdbservernameDirtyFlag = false;
        this.psdbservername = null;
    }

    public void setPSDCInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcinstid = string;
        this.psdcinstidDirtyFlag = true;
    }

    public String getPSDCInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCInstId();
        }
        return this.psdcinstid;
    }

    public boolean isPSDCInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCInstIdDirty();
        }
        return this.psdcinstidDirtyFlag;
    }

    public void resetPSDCInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCInstId();
            return;
        }
        this.psdcinstidDirtyFlag = false;
        this.psdcinstid = null;
    }

    public void setPSDCInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcinstname = string;
        this.psdcinstnameDirtyFlag = true;
    }

    public String getPSDCInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCInstName();
        }
        return this.psdcinstname;
    }

    public boolean isPSDCInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCInstNameDirty();
        }
        return this.psdcinstnameDirtyFlag;
    }

    public void resetPSDCInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCInstName();
            return;
        }
        this.psdcinstnameDirtyFlag = false;
        this.psdcinstname = null;
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

    public void setUsedSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedSize(n);
            return;
        }
        this.usedsize = n;
        this.usedsizeDirtyFlag = true;
    }

    public Integer getUsedSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedSize();
        }
        return this.usedsize;
    }

    public boolean isUsedSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedSizeDirty();
        }
        return this.usedsizeDirtyFlag;
    }

    public void resetUsedSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedSize();
            return;
        }
        this.usedsizeDirtyFlag = false;
        this.usedsize = null;
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

    protected void onReset() {
        PSDCInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCInstBase pSDCInstBase) {
        pSDCInstBase.resetConnStr();
        pSDCInstBase.resetCreateDate();
        pSDCInstBase.resetCreateMan();
        pSDCInstBase.resetDBName();
        pSDCInstBase.resetDBType();
        pSDCInstBase.resetInstState();
        pSDCInstBase.resetMemo();
        pSDCInstBase.resetModelVer();
        pSDCInstBase.resetOrderValue();
        pSDCInstBase.resetPasswd();
        pSDCInstBase.resetPSDBServerId();
        pSDCInstBase.resetPSDBServerName();
        pSDCInstBase.resetPSDCInstId();
        pSDCInstBase.resetPSDCInstName();
        pSDCInstBase.resetPSSvrDomainId();
        pSDCInstBase.resetPSSvrDomainName();
        pSDCInstBase.resetUpdateDate();
        pSDCInstBase.resetUpdateMan();
        pSDCInstBase.resetUsedSize();
        pSDCInstBase.resetUserName();
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
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDBServerIdDirty()) {
            hashMap.put(FIELD_PSDBSERVERID, this.getPSDBServerId());
        }
        if (!bl || this.isPSDBServerNameDirty()) {
            hashMap.put(FIELD_PSDBSERVERNAME, this.getPSDBServerName());
        }
        if (!bl || this.isPSDCInstIdDirty()) {
            hashMap.put(FIELD_PSDCINSTID, this.getPSDCInstId());
        }
        if (!bl || this.isPSDCInstNameDirty()) {
            hashMap.put(FIELD_PSDCINSTNAME, this.getPSDCInstName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsedSizeDirty()) {
            hashMap.put(FIELD_USEDSIZE, this.getUsedSize());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSDCInstBase.get(this, n);
    }

    private static Object get(PSDCInstBase pSDCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCInstBase.getConnStr();
            }
            case 1: {
                return pSDCInstBase.getCreateDate();
            }
            case 2: {
                return pSDCInstBase.getCreateMan();
            }
            case 3: {
                return pSDCInstBase.getDBName();
            }
            case 4: {
                return pSDCInstBase.getDBType();
            }
            case 5: {
                return pSDCInstBase.getInstState();
            }
            case 6: {
                return pSDCInstBase.getMemo();
            }
            case 7: {
                return pSDCInstBase.getModelVer();
            }
            case 8: {
                return pSDCInstBase.getOrderValue();
            }
            case 9: {
                return pSDCInstBase.getPasswd();
            }
            case 10: {
                return pSDCInstBase.getPSDBServerId();
            }
            case 11: {
                return pSDCInstBase.getPSDBServerName();
            }
            case 12: {
                return pSDCInstBase.getPSDCInstId();
            }
            case 13: {
                return pSDCInstBase.getPSDCInstName();
            }
            case 14: {
                return pSDCInstBase.getPSSvrDomainId();
            }
            case 15: {
                return pSDCInstBase.getPSSvrDomainName();
            }
            case 16: {
                return pSDCInstBase.getUpdateDate();
            }
            case 17: {
                return pSDCInstBase.getUpdateMan();
            }
            case 18: {
                return pSDCInstBase.getUsedSize();
            }
            case 19: {
                return pSDCInstBase.getUserName();
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
        PSDCInstBase.set(this, n, object);
    }

    private static void set(PSDCInstBase pSDCInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCInstBase.setDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCInstBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCInstBase.setInstState(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCInstBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCInstBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCInstBase.setPSDBServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCInstBase.setPSDBServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCInstBase.setPSDCInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCInstBase.setPSDCInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDCInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCInstBase.setUsedSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDCInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSDCInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDCInstBase pSDCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCInstBase.getConnStr() == null;
            }
            case 1: {
                return pSDCInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCInstBase.getDBName() == null;
            }
            case 4: {
                return pSDCInstBase.getDBType() == null;
            }
            case 5: {
                return pSDCInstBase.getInstState() == null;
            }
            case 6: {
                return pSDCInstBase.getMemo() == null;
            }
            case 7: {
                return pSDCInstBase.getModelVer() == null;
            }
            case 8: {
                return pSDCInstBase.getOrderValue() == null;
            }
            case 9: {
                return pSDCInstBase.getPasswd() == null;
            }
            case 10: {
                return pSDCInstBase.getPSDBServerId() == null;
            }
            case 11: {
                return pSDCInstBase.getPSDBServerName() == null;
            }
            case 12: {
                return pSDCInstBase.getPSDCInstId() == null;
            }
            case 13: {
                return pSDCInstBase.getPSDCInstName() == null;
            }
            case 14: {
                return pSDCInstBase.getPSSvrDomainId() == null;
            }
            case 15: {
                return pSDCInstBase.getPSSvrDomainName() == null;
            }
            case 16: {
                return pSDCInstBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDCInstBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDCInstBase.getUsedSize() == null;
            }
            case 19: {
                return pSDCInstBase.getUserName() == null;
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
        return PSDCInstBase.contains(this, n);
    }

    private static boolean contains(PSDCInstBase pSDCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCInstBase.isConnStrDirty();
            }
            case 1: {
                return pSDCInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDCInstBase.isDBNameDirty();
            }
            case 4: {
                return pSDCInstBase.isDBTypeDirty();
            }
            case 5: {
                return pSDCInstBase.isInstStateDirty();
            }
            case 6: {
                return pSDCInstBase.isMemoDirty();
            }
            case 7: {
                return pSDCInstBase.isModelVerDirty();
            }
            case 8: {
                return pSDCInstBase.isOrderValueDirty();
            }
            case 9: {
                return pSDCInstBase.isPasswdDirty();
            }
            case 10: {
                return pSDCInstBase.isPSDBServerIdDirty();
            }
            case 11: {
                return pSDCInstBase.isPSDBServerNameDirty();
            }
            case 12: {
                return pSDCInstBase.isPSDCInstIdDirty();
            }
            case 13: {
                return pSDCInstBase.isPSDCInstNameDirty();
            }
            case 14: {
                return pSDCInstBase.isPSSvrDomainIdDirty();
            }
            case 15: {
                return pSDCInstBase.isPSSvrDomainNameDirty();
            }
            case 16: {
                return pSDCInstBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDCInstBase.isUpdateManDirty();
            }
            case 18: {
                return pSDCInstBase.isUsedSizeDirty();
            }
            case 19: {
                return pSDCInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCInstBase pSDCInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCInstBase.getDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbname", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getDBName()), (boolean)false);
        }
        if (bl || pSDCInstBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getDBType()), (boolean)false);
        }
        if (bl || pSDCInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSDCInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCInstBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getModelVer()), (boolean)false);
        }
        if (bl || pSDCInstBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSDBServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbserverid", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSDBServerId()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSDBServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbservername", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSDBServerName()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSDCInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcinstid", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSDCInstId()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSDCInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcinstname", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSDCInstName()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDCInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDCInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCInstBase.getUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedsize", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getUsedSize()), (boolean)false);
        }
        if (bl || pSDCInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCInstBase.getJSONValue((Object)pSDCInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCInstBase pSDCInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCInstBase.getConnStr() != null) {
            object = pSDCInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getCreateDate() != null) {
            object = pSDCInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCInstBase.getCreateMan() != null) {
            object = pSDCInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getDBName() != null) {
            object = pSDCInstBase.getDBName();
            xmlNode.setAttribute(FIELD_DBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getDBType() != null) {
            object = pSDCInstBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getInstState() != null) {
            object = pSDCInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getMemo() != null) {
            object = pSDCInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getModelVer() != null) {
            object = pSDCInstBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCInstBase.getOrderValue() != null) {
            object = pSDCInstBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCInstBase.getPasswd() != null) {
            object = pSDCInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSDBServerId() != null) {
            object = pSDCInstBase.getPSDBServerId();
            xmlNode.setAttribute(FIELD_PSDBSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSDBServerName() != null) {
            object = pSDCInstBase.getPSDBServerName();
            xmlNode.setAttribute(FIELD_PSDBSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSDCInstId() != null) {
            object = pSDCInstBase.getPSDCInstId();
            xmlNode.setAttribute(FIELD_PSDCINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSDCInstName() != null) {
            object = pSDCInstBase.getPSDCInstName();
            xmlNode.setAttribute(FIELD_PSDCINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSSvrDomainId() != null) {
            object = pSDCInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getPSSvrDomainName() != null) {
            object = pSDCInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getUpdateDate() != null) {
            object = pSDCInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCInstBase.getUpdateMan() != null) {
            object = pSDCInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCInstBase.getUsedSize() != null) {
            object = pSDCInstBase.getUsedSize();
            xmlNode.setAttribute(FIELD_USEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCInstBase.getUserName() != null) {
            object = pSDCInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCInstBase pSDCInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCInstBase.isConnStrDirty() && (bl || pSDCInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCInstBase.getConnStr());
        }
        if (pSDCInstBase.isCreateDateDirty() && (bl || pSDCInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCInstBase.getCreateDate());
        }
        if (pSDCInstBase.isCreateManDirty() && (bl || pSDCInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCInstBase.getCreateMan());
        }
        if (pSDCInstBase.isDBNameDirty() && (bl || pSDCInstBase.getDBName() != null)) {
            iDataObject.set(FIELD_DBNAME, (Object)pSDCInstBase.getDBName());
        }
        if (pSDCInstBase.isDBTypeDirty() && (bl || pSDCInstBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDCInstBase.getDBType());
        }
        if (pSDCInstBase.isInstStateDirty() && (bl || pSDCInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSDCInstBase.getInstState());
        }
        if (pSDCInstBase.isMemoDirty() && (bl || pSDCInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCInstBase.getMemo());
        }
        if (pSDCInstBase.isModelVerDirty() && (bl || pSDCInstBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSDCInstBase.getModelVer());
        }
        if (pSDCInstBase.isOrderValueDirty() && (bl || pSDCInstBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDCInstBase.getOrderValue());
        }
        if (pSDCInstBase.isPasswdDirty() && (bl || pSDCInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCInstBase.getPasswd());
        }
        if (pSDCInstBase.isPSDBServerIdDirty() && (bl || pSDCInstBase.getPSDBServerId() != null)) {
            iDataObject.set(FIELD_PSDBSERVERID, (Object)pSDCInstBase.getPSDBServerId());
        }
        if (pSDCInstBase.isPSDBServerNameDirty() && (bl || pSDCInstBase.getPSDBServerName() != null)) {
            iDataObject.set(FIELD_PSDBSERVERNAME, (Object)pSDCInstBase.getPSDBServerName());
        }
        if (pSDCInstBase.isPSDCInstIdDirty() && (bl || pSDCInstBase.getPSDCInstId() != null)) {
            iDataObject.set(FIELD_PSDCINSTID, (Object)pSDCInstBase.getPSDCInstId());
        }
        if (pSDCInstBase.isPSDCInstNameDirty() && (bl || pSDCInstBase.getPSDCInstName() != null)) {
            iDataObject.set(FIELD_PSDCINSTNAME, (Object)pSDCInstBase.getPSDCInstName());
        }
        if (pSDCInstBase.isPSSvrDomainIdDirty() && (bl || pSDCInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDCInstBase.getPSSvrDomainId());
        }
        if (pSDCInstBase.isPSSvrDomainNameDirty() && (bl || pSDCInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDCInstBase.getPSSvrDomainName());
        }
        if (pSDCInstBase.isUpdateDateDirty() && (bl || pSDCInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCInstBase.getUpdateDate());
        }
        if (pSDCInstBase.isUpdateManDirty() && (bl || pSDCInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCInstBase.getUpdateMan());
        }
        if (pSDCInstBase.isUsedSizeDirty() && (bl || pSDCInstBase.getUsedSize() != null)) {
            iDataObject.set(FIELD_USEDSIZE, (Object)pSDCInstBase.getUsedSize());
        }
        if (pSDCInstBase.isUserNameDirty() && (bl || pSDCInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCInstBase.getUserName());
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
        return PSDCInstBase.remove(this, n);
    }

    private static boolean remove(PSDCInstBase pSDCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCInstBase.resetDBName();
                return true;
            }
            case 4: {
                pSDCInstBase.resetDBType();
                return true;
            }
            case 5: {
                pSDCInstBase.resetInstState();
                return true;
            }
            case 6: {
                pSDCInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCInstBase.resetModelVer();
                return true;
            }
            case 8: {
                pSDCInstBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDCInstBase.resetPasswd();
                return true;
            }
            case 10: {
                pSDCInstBase.resetPSDBServerId();
                return true;
            }
            case 11: {
                pSDCInstBase.resetPSDBServerName();
                return true;
            }
            case 12: {
                pSDCInstBase.resetPSDCInstId();
                return true;
            }
            case 13: {
                pSDCInstBase.resetPSDCInstName();
                return true;
            }
            case 14: {
                pSDCInstBase.resetPSSvrDomainId();
                return true;
            }
            case 15: {
                pSDCInstBase.resetPSSvrDomainName();
                return true;
            }
            case 16: {
                pSDCInstBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDCInstBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDCInstBase.resetUsedSize();
                return true;
            }
            case 19: {
                pSDCInstBase.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBServer getPSDBServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServer();
        }
        if (this.getPSDBServerId() == null) {
            return null;
        }
        Integer n = this.objPSDBServerLock;
        synchronized (n) {
            if (this.psdbserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBServerId(), (Object)this.psdbserver.getPSDBServerId()) != 0L) {
                this.psdbserver = null;
            }
            if (this.psdbserver == null) {
                PSDBServer pSDBServer = new PSDBServer();
                pSDBServer.setPSDBServerId(this.getPSDBServerId());
                PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
                pSDBServerService.autoGet((IEntity)pSDBServer);
                this.psdbserver = pSDBServer;
            }
            return this.psdbserver;
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

    private PSDCInstBase getProxyEntity() {
        return this.proxyPSDCInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCInstBase) {
            this.proxyPSDCInstBase = (PSDCInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBNAME, 3);
        fieldIndexMap.put(FIELD_DBTYPE, 4);
        fieldIndexMap.put(FIELD_INSTSTATE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELVER, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PASSWD, 9);
        fieldIndexMap.put(FIELD_PSDBSERVERID, 10);
        fieldIndexMap.put(FIELD_PSDBSERVERNAME, 11);
        fieldIndexMap.put(FIELD_PSDCINSTID, 12);
        fieldIndexMap.put(FIELD_PSDCINSTNAME, 13);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 14);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USEDSIZE, 18);
        fieldIndexMap.put(FIELD_USERNAME, 19);
    }
}

