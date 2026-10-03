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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnDBInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnDBInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String FIELD_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDEPSLNDBINSTID = "PSDEPSLNDBINSTID";
    public static final String FIELD_PSDEPSLNDBINSTNAME = "PSDEPSLNDBINSTNAME";
    public static final String FIELD_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String FIELD_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBTYPE = 3;
    private static final int INDEX_ENABLELOCALMODE = 4;
    private static final int INDEX_ENABLEREMOTEMODE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PASSWD = 7;
    private static final int INDEX_PSDEPSLNDBINSTID = 8;
    private static final int INDEX_PSDEPSLNDBINSTNAME = 9;
    private static final int INDEX_PSDEPSLNHOSTID = 10;
    private static final int INDEX_PSDEPSLNHOSTNAME = 11;
    private static final int INDEX_PSDEPSLNID = 12;
    private static final int INDEX_PSDEPSLNNAME = 13;
    private static final int INDEX_PSDEVCENTERDBINSTID = 14;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERNAME = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnDBInstBase proxyPSDepSlnDBInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean enablelocalmodeDirtyFlag = false;
    private boolean enableremotemodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdepslndbinstidDirtyFlag = false;
    private boolean psdepslndbinstnameDirtyFlag = false;
    private boolean psdepslnhostidDirtyFlag = false;
    private boolean psdepslnhostnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="enablelocalmode")
    private Integer enablelocalmode;
    @Column(name="enableremotemode")
    private Integer enableremotemode;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdepslndbinstid")
    private String psdepslndbinstid;
    @Column(name="psdepslndbinstname")
    private String psdepslndbinstname;
    @Column(name="psdepslnhostid")
    private String psdepslnhostid;
    @Column(name="psdepslnhostname")
    private String psdepslnhostname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    private Integer objPSDepSlnHostLock = new Integer(1);
    private PSDepSlnHost psdepslnhost = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;

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

    public void setEnableLocalMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLocalMode(n);
            return;
        }
        this.enablelocalmode = n;
        this.enablelocalmodeDirtyFlag = true;
    }

    public Integer getEnableLocalMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLocalMode();
        }
        return this.enablelocalmode;
    }

    public boolean isEnableLocalModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLocalModeDirty();
        }
        return this.enablelocalmodeDirtyFlag;
    }

    public void resetEnableLocalMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLocalMode();
            return;
        }
        this.enablelocalmodeDirtyFlag = false;
        this.enablelocalmode = null;
    }

    public void setEnableRemoteMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRemoteMode(n);
            return;
        }
        this.enableremotemode = n;
        this.enableremotemodeDirtyFlag = true;
    }

    public Integer getEnableRemoteMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRemoteMode();
        }
        return this.enableremotemode;
    }

    public boolean isEnableRemoteModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRemoteModeDirty();
        }
        return this.enableremotemodeDirtyFlag;
    }

    public void resetEnableRemoteMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRemoteMode();
            return;
        }
        this.enableremotemodeDirtyFlag = false;
        this.enableremotemode = null;
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

    public void setPSDepSlnDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndbinstid = string;
        this.psdepslndbinstidDirtyFlag = true;
    }

    public String getPSDepSlnDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInstId();
        }
        return this.psdepslndbinstid;
    }

    public boolean isPSDepSlnDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDBInstIdDirty();
        }
        return this.psdepslndbinstidDirtyFlag;
    }

    public void resetPSDepSlnDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDBInstId();
            return;
        }
        this.psdepslndbinstidDirtyFlag = false;
        this.psdepslndbinstid = null;
    }

    public void setPSDepSlnDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndbinstname = string;
        this.psdepslndbinstnameDirtyFlag = true;
    }

    public String getPSDepSlnDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDBInstName();
        }
        return this.psdepslndbinstname;
    }

    public boolean isPSDepSlnDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDBInstNameDirty();
        }
        return this.psdepslndbinstnameDirtyFlag;
    }

    public void resetPSDepSlnDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDBInstName();
            return;
        }
        this.psdepslndbinstnameDirtyFlag = false;
        this.psdepslndbinstname = null;
    }

    public void setPSDepSlnHostId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostid = string;
        this.psdepslnhostidDirtyFlag = true;
    }

    public String getPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostId();
        }
        return this.psdepslnhostid;
    }

    public boolean isPSDepSlnHostIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostIdDirty();
        }
        return this.psdepslnhostidDirtyFlag;
    }

    public void resetPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostId();
            return;
        }
        this.psdepslnhostidDirtyFlag = false;
        this.psdepslnhostid = null;
    }

    public void setPSDepSlnHostName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostname = string;
        this.psdepslnhostnameDirtyFlag = true;
    }

    public String getPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostName();
        }
        return this.psdepslnhostname;
    }

    public boolean isPSDepSlnHostNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostNameDirty();
        }
        return this.psdepslnhostnameDirtyFlag;
    }

    public void resetPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostName();
            return;
        }
        this.psdepslnhostnameDirtyFlag = false;
        this.psdepslnhostname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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

    protected void onReset() {
        PSDepSlnDBInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnDBInstBase pSDepSlnDBInstBase) {
        pSDepSlnDBInstBase.resetConnStr();
        pSDepSlnDBInstBase.resetCreateDate();
        pSDepSlnDBInstBase.resetCreateMan();
        pSDepSlnDBInstBase.resetDBType();
        pSDepSlnDBInstBase.resetEnableLocalMode();
        pSDepSlnDBInstBase.resetEnableRemoteMode();
        pSDepSlnDBInstBase.resetMemo();
        pSDepSlnDBInstBase.resetPasswd();
        pSDepSlnDBInstBase.resetPSDepSlnDBInstId();
        pSDepSlnDBInstBase.resetPSDepSlnDBInstName();
        pSDepSlnDBInstBase.resetPSDepSlnHostId();
        pSDepSlnDBInstBase.resetPSDepSlnHostName();
        pSDepSlnDBInstBase.resetPSDepSlnId();
        pSDepSlnDBInstBase.resetPSDepSlnName();
        pSDepSlnDBInstBase.resetPSDevCenterDBInstId();
        pSDepSlnDBInstBase.resetPSDevCenterDBInstName();
        pSDepSlnDBInstBase.resetUpdateDate();
        pSDepSlnDBInstBase.resetUpdateMan();
        pSDepSlnDBInstBase.resetUserName();
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
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isEnableLocalModeDirty()) {
            hashMap.put(FIELD_ENABLELOCALMODE, this.getEnableLocalMode());
        }
        if (!bl || this.isEnableRemoteModeDirty()) {
            hashMap.put(FIELD_ENABLEREMOTEMODE, this.getEnableRemoteMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDepSlnDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNDBINSTID, this.getPSDepSlnDBInstId());
        }
        if (!bl || this.isPSDepSlnDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNDBINSTNAME, this.getPSDepSlnDBInstName());
        }
        if (!bl || this.isPSDepSlnHostIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTID, this.getPSDepSlnHostId());
        }
        if (!bl || this.isPSDepSlnHostNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTNAME, this.getPSDepSlnHostName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
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
        return PSDepSlnDBInstBase.get(this, n);
    }

    private static Object get(PSDepSlnDBInstBase pSDepSlnDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnDBInstBase.getConnStr();
            }
            case 1: {
                return pSDepSlnDBInstBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnDBInstBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnDBInstBase.getDBType();
            }
            case 4: {
                return pSDepSlnDBInstBase.getEnableLocalMode();
            }
            case 5: {
                return pSDepSlnDBInstBase.getEnableRemoteMode();
            }
            case 6: {
                return pSDepSlnDBInstBase.getMemo();
            }
            case 7: {
                return pSDepSlnDBInstBase.getPasswd();
            }
            case 8: {
                return pSDepSlnDBInstBase.getPSDepSlnDBInstId();
            }
            case 9: {
                return pSDepSlnDBInstBase.getPSDepSlnDBInstName();
            }
            case 10: {
                return pSDepSlnDBInstBase.getPSDepSlnHostId();
            }
            case 11: {
                return pSDepSlnDBInstBase.getPSDepSlnHostName();
            }
            case 12: {
                return pSDepSlnDBInstBase.getPSDepSlnId();
            }
            case 13: {
                return pSDepSlnDBInstBase.getPSDepSlnName();
            }
            case 14: {
                return pSDepSlnDBInstBase.getPSDevCenterDBInstId();
            }
            case 15: {
                return pSDepSlnDBInstBase.getPSDevCenterDBInstName();
            }
            case 16: {
                return pSDepSlnDBInstBase.getUpdateDate();
            }
            case 17: {
                return pSDepSlnDBInstBase.getUpdateMan();
            }
            case 18: {
                return pSDepSlnDBInstBase.getUserName();
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
        PSDepSlnDBInstBase.set(this, n, object);
    }

    private static void set(PSDepSlnDBInstBase pSDepSlnDBInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnDBInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnDBInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnDBInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnDBInstBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnDBInstBase.setEnableLocalMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnDBInstBase.setEnableRemoteMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnDBInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnDBInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnDBInstBase.setPSDepSlnDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnDBInstBase.setPSDepSlnDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnDBInstBase.setPSDepSlnHostId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnDBInstBase.setPSDepSlnHostName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnDBInstBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnDBInstBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnDBInstBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnDBInstBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnDBInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnDBInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnDBInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSDepSlnDBInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnDBInstBase pSDepSlnDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnDBInstBase.getConnStr() == null;
            }
            case 1: {
                return pSDepSlnDBInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnDBInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnDBInstBase.getDBType() == null;
            }
            case 4: {
                return pSDepSlnDBInstBase.getEnableLocalMode() == null;
            }
            case 5: {
                return pSDepSlnDBInstBase.getEnableRemoteMode() == null;
            }
            case 6: {
                return pSDepSlnDBInstBase.getMemo() == null;
            }
            case 7: {
                return pSDepSlnDBInstBase.getPasswd() == null;
            }
            case 8: {
                return pSDepSlnDBInstBase.getPSDepSlnDBInstId() == null;
            }
            case 9: {
                return pSDepSlnDBInstBase.getPSDepSlnDBInstName() == null;
            }
            case 10: {
                return pSDepSlnDBInstBase.getPSDepSlnHostId() == null;
            }
            case 11: {
                return pSDepSlnDBInstBase.getPSDepSlnHostName() == null;
            }
            case 12: {
                return pSDepSlnDBInstBase.getPSDepSlnId() == null;
            }
            case 13: {
                return pSDepSlnDBInstBase.getPSDepSlnName() == null;
            }
            case 14: {
                return pSDepSlnDBInstBase.getPSDevCenterDBInstId() == null;
            }
            case 15: {
                return pSDepSlnDBInstBase.getPSDevCenterDBInstName() == null;
            }
            case 16: {
                return pSDepSlnDBInstBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDepSlnDBInstBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDepSlnDBInstBase.getUserName() == null;
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
        return PSDepSlnDBInstBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnDBInstBase pSDepSlnDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnDBInstBase.isConnStrDirty();
            }
            case 1: {
                return pSDepSlnDBInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnDBInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnDBInstBase.isDBTypeDirty();
            }
            case 4: {
                return pSDepSlnDBInstBase.isEnableLocalModeDirty();
            }
            case 5: {
                return pSDepSlnDBInstBase.isEnableRemoteModeDirty();
            }
            case 6: {
                return pSDepSlnDBInstBase.isMemoDirty();
            }
            case 7: {
                return pSDepSlnDBInstBase.isPasswdDirty();
            }
            case 8: {
                return pSDepSlnDBInstBase.isPSDepSlnDBInstIdDirty();
            }
            case 9: {
                return pSDepSlnDBInstBase.isPSDepSlnDBInstNameDirty();
            }
            case 10: {
                return pSDepSlnDBInstBase.isPSDepSlnHostIdDirty();
            }
            case 11: {
                return pSDepSlnDBInstBase.isPSDepSlnHostNameDirty();
            }
            case 12: {
                return pSDepSlnDBInstBase.isPSDepSlnIdDirty();
            }
            case 13: {
                return pSDepSlnDBInstBase.isPSDepSlnNameDirty();
            }
            case 14: {
                return pSDepSlnDBInstBase.isPSDevCenterDBInstIdDirty();
            }
            case 15: {
                return pSDepSlnDBInstBase.isPSDevCenterDBInstNameDirty();
            }
            case 16: {
                return pSDepSlnDBInstBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDepSlnDBInstBase.isUpdateManDirty();
            }
            case 18: {
                return pSDepSlnDBInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnDBInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnDBInstBase pSDepSlnDBInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnDBInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getDBType()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getEnableLocalMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelocalmode", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getEnableLocalMode()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getEnableRemoteMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremotemode", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getEnableRemoteMode()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndbinstid", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnDBInstId()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndbinstname", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnDBInstName()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnHostId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostid", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnHostId()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnHostName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostname", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnHostName()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnDBInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDepSlnDBInstBase.getJSONValue((Object)pSDepSlnDBInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnDBInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnDBInstBase pSDepSlnDBInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnDBInstBase.getConnStr() != null) {
            object = pSDepSlnDBInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getCreateDate() != null) {
            object = pSDepSlnDBInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnDBInstBase.getCreateMan() != null) {
            object = pSDepSlnDBInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getDBType() != null) {
            object = pSDepSlnDBInstBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getEnableLocalMode() != null) {
            object = pSDepSlnDBInstBase.getEnableLocalMode();
            xmlNode.setAttribute(FIELD_ENABLELOCALMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnDBInstBase.getEnableRemoteMode() != null) {
            object = pSDepSlnDBInstBase.getEnableRemoteMode();
            xmlNode.setAttribute(FIELD_ENABLEREMOTEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnDBInstBase.getMemo() != null) {
            object = pSDepSlnDBInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPasswd() != null) {
            object = pSDepSlnDBInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstId() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnDBInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstName() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnDBInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnHostId() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnHostId();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnHostName() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnHostName();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnId() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDepSlnName() != null) {
            object = pSDepSlnDBInstBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstId() != null) {
            object = pSDepSlnDBInstBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstName() != null) {
            object = pSDepSlnDBInstBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getUpdateDate() != null) {
            object = pSDepSlnDBInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnDBInstBase.getUpdateMan() != null) {
            object = pSDepSlnDBInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnDBInstBase.getUserName() != null) {
            object = pSDepSlnDBInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnDBInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnDBInstBase pSDepSlnDBInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnDBInstBase.isConnStrDirty() && (bl || pSDepSlnDBInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDepSlnDBInstBase.getConnStr());
        }
        if (pSDepSlnDBInstBase.isCreateDateDirty() && (bl || pSDepSlnDBInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnDBInstBase.getCreateDate());
        }
        if (pSDepSlnDBInstBase.isCreateManDirty() && (bl || pSDepSlnDBInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnDBInstBase.getCreateMan());
        }
        if (pSDepSlnDBInstBase.isDBTypeDirty() && (bl || pSDepSlnDBInstBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDepSlnDBInstBase.getDBType());
        }
        if (pSDepSlnDBInstBase.isEnableLocalModeDirty() && (bl || pSDepSlnDBInstBase.getEnableLocalMode() != null)) {
            iDataObject.set(FIELD_ENABLELOCALMODE, (Object)pSDepSlnDBInstBase.getEnableLocalMode());
        }
        if (pSDepSlnDBInstBase.isEnableRemoteModeDirty() && (bl || pSDepSlnDBInstBase.getEnableRemoteMode() != null)) {
            iDataObject.set(FIELD_ENABLEREMOTEMODE, (Object)pSDepSlnDBInstBase.getEnableRemoteMode());
        }
        if (pSDepSlnDBInstBase.isMemoDirty() && (bl || pSDepSlnDBInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnDBInstBase.getMemo());
        }
        if (pSDepSlnDBInstBase.isPasswdDirty() && (bl || pSDepSlnDBInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDepSlnDBInstBase.getPasswd());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnDBInstIdDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDBINSTID, (Object)pSDepSlnDBInstBase.getPSDepSlnDBInstId());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnDBInstNameDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDBINSTNAME, (Object)pSDepSlnDBInstBase.getPSDepSlnDBInstName());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnHostIdDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnHostId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTID, (Object)pSDepSlnDBInstBase.getPSDepSlnHostId());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnHostNameDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnHostName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTNAME, (Object)pSDepSlnDBInstBase.getPSDepSlnHostName());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnIdDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnDBInstBase.getPSDepSlnId());
        }
        if (pSDepSlnDBInstBase.isPSDepSlnNameDirty() && (bl || pSDepSlnDBInstBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnDBInstBase.getPSDepSlnName());
        }
        if (pSDepSlnDBInstBase.isPSDevCenterDBInstIdDirty() && (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDepSlnDBInstBase.getPSDevCenterDBInstId());
        }
        if (pSDepSlnDBInstBase.isPSDevCenterDBInstNameDirty() && (bl || pSDepSlnDBInstBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDepSlnDBInstBase.getPSDevCenterDBInstName());
        }
        if (pSDepSlnDBInstBase.isUpdateDateDirty() && (bl || pSDepSlnDBInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnDBInstBase.getUpdateDate());
        }
        if (pSDepSlnDBInstBase.isUpdateManDirty() && (bl || pSDepSlnDBInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnDBInstBase.getUpdateMan());
        }
        if (pSDepSlnDBInstBase.isUserNameDirty() && (bl || pSDepSlnDBInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDepSlnDBInstBase.getUserName());
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
        return PSDepSlnDBInstBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnDBInstBase pSDepSlnDBInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnDBInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDepSlnDBInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnDBInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnDBInstBase.resetDBType();
                return true;
            }
            case 4: {
                pSDepSlnDBInstBase.resetEnableLocalMode();
                return true;
            }
            case 5: {
                pSDepSlnDBInstBase.resetEnableRemoteMode();
                return true;
            }
            case 6: {
                pSDepSlnDBInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSDepSlnDBInstBase.resetPasswd();
                return true;
            }
            case 8: {
                pSDepSlnDBInstBase.resetPSDepSlnDBInstId();
                return true;
            }
            case 9: {
                pSDepSlnDBInstBase.resetPSDepSlnDBInstName();
                return true;
            }
            case 10: {
                pSDepSlnDBInstBase.resetPSDepSlnHostId();
                return true;
            }
            case 11: {
                pSDepSlnDBInstBase.resetPSDepSlnHostName();
                return true;
            }
            case 12: {
                pSDepSlnDBInstBase.resetPSDepSlnId();
                return true;
            }
            case 13: {
                pSDepSlnDBInstBase.resetPSDepSlnName();
                return true;
            }
            case 14: {
                pSDepSlnDBInstBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 15: {
                pSDepSlnDBInstBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 16: {
                pSDepSlnDBInstBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDepSlnDBInstBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDepSlnDBInstBase.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnHost getPSDepSlnHost() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHost();
        }
        if (this.getPSDepSlnHostId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnHostLock;
        synchronized (n) {
            if (this.psdepslnhost != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnHostId(), (Object)this.psdepslnhost.getPSDepSlnHostId()) != 0L) {
                this.psdepslnhost = null;
            }
            if (this.psdepslnhost == null) {
                PSDepSlnHost pSDepSlnHost = new PSDepSlnHost();
                pSDepSlnHost.setPSDepSlnHostId(this.getPSDepSlnHostId());
                PSDepSlnHostService pSDepSlnHostService = (PSDepSlnHostService)ServiceGlobal.getService(PSDepSlnHostService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnHostService.autoGet(pSDepSlnHost);
                this.psdepslnhost = pSDepSlnHost;
            }
            return this.psdepslnhost;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
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

    private PSDepSlnDBInstBase getProxyEntity() {
        return this.proxyPSDepSlnDBInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnDBInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnDBInstBase) {
            this.proxyPSDepSlnDBInstBase = (PSDepSlnDBInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBTYPE, 3);
        fieldIndexMap.put(FIELD_ENABLELOCALMODE, 4);
        fieldIndexMap.put(FIELD_ENABLEREMOTEMODE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PASSWD, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNDBINSTID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNDBINSTNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTID, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTNAME, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERNAME, 18);
    }
}

