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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnMQInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnMQInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String FIELD_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MQTYPE = "MQTYPE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String FIELD_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNMQINSTID = "PSDEPSLNMQINSTID";
    public static final String FIELD_PSDEPSLNMQINSTNAME = "PSDEPSLNMQINSTNAME";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEVCENTERMQID = "PSDEVCENTERMQID";
    public static final String FIELD_PSDEVCENTERMQNAME = "PSDEVCENTERMQNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLELOCALMODE = 3;
    private static final int INDEX_ENABLEREMOTEMODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MQTYPE = 6;
    private static final int INDEX_PASSWD = 7;
    private static final int INDEX_PSDEPSLNHOSTID = 8;
    private static final int INDEX_PSDEPSLNHOSTNAME = 9;
    private static final int INDEX_PSDEPSLNID = 10;
    private static final int INDEX_PSDEPSLNMQINSTID = 11;
    private static final int INDEX_PSDEPSLNMQINSTNAME = 12;
    private static final int INDEX_PSDEPSLNNAME = 13;
    private static final int INDEX_PSDEVCENTERMQID = 14;
    private static final int INDEX_PSDEVCENTERMQNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERNAME = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnMQInstBase proxyPSDepSlnMQInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelocalmodeDirtyFlag = false;
    private boolean enableremotemodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mqtypeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdepslnhostidDirtyFlag = false;
    private boolean psdepslnhostnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnmqinstidDirtyFlag = false;
    private boolean psdepslnmqinstnameDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdevcentermqidDirtyFlag = false;
    private boolean psdevcentermqnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablelocalmode")
    private Integer enablelocalmode;
    @Column(name="enableremotemode")
    private Integer enableremotemode;
    @Column(name="memo")
    private String memo;
    @Column(name="mqtype")
    private String mqtype;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdepslnhostid")
    private String psdepslnhostid;
    @Column(name="psdepslnhostname")
    private String psdepslnhostname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnmqinstid")
    private String psdepslnmqinstid;
    @Column(name="psdepslnmqinstname")
    private String psdepslnmqinstname;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdevcentermqid")
    private String psdevcentermqid;
    @Column(name="psdevcentermqname")
    private String psdevcentermqname;
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
    private Integer objPSDevCenterMQLock = new Integer(1);
    private PSDevCenterMQ psdevcentermq = null;

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

    public void setMQType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMQType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mqtype = string;
        this.mqtypeDirtyFlag = true;
    }

    public String getMQType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMQType();
        }
        return this.mqtype;
    }

    public boolean isMQTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMQTypeDirty();
        }
        return this.mqtypeDirtyFlag;
    }

    public void resetMQType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMQType();
            return;
        }
        this.mqtypeDirtyFlag = false;
        this.mqtype = null;
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

    public void setPSDepSlnMQInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnMQInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmqinstid = string;
        this.psdepslnmqinstidDirtyFlag = true;
    }

    public String getPSDepSlnMQInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMQInstId();
        }
        return this.psdepslnmqinstid;
    }

    public boolean isPSDepSlnMQInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnMQInstIdDirty();
        }
        return this.psdepslnmqinstidDirtyFlag;
    }

    public void resetPSDepSlnMQInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnMQInstId();
            return;
        }
        this.psdepslnmqinstidDirtyFlag = false;
        this.psdepslnmqinstid = null;
    }

    public void setPSDepSlnMQInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnMQInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmqinstname = string;
        this.psdepslnmqinstnameDirtyFlag = true;
    }

    public String getPSDepSlnMQInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMQInstName();
        }
        return this.psdepslnmqinstname;
    }

    public boolean isPSDepSlnMQInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnMQInstNameDirty();
        }
        return this.psdepslnmqinstnameDirtyFlag;
    }

    public void resetPSDepSlnMQInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnMQInstName();
            return;
        }
        this.psdepslnmqinstnameDirtyFlag = false;
        this.psdepslnmqinstname = null;
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

    public void setPSDevCenterMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqid = string;
        this.psdevcentermqidDirtyFlag = true;
    }

    public String getPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQId();
        }
        return this.psdevcentermqid;
    }

    public boolean isPSDevCenterMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQIdDirty();
        }
        return this.psdevcentermqidDirtyFlag;
    }

    public void resetPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQId();
            return;
        }
        this.psdevcentermqidDirtyFlag = false;
        this.psdevcentermqid = null;
    }

    public void setPSDevCenterMQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqname = string;
        this.psdevcentermqnameDirtyFlag = true;
    }

    public String getPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQName();
        }
        return this.psdevcentermqname;
    }

    public boolean isPSDevCenterMQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQNameDirty();
        }
        return this.psdevcentermqnameDirtyFlag;
    }

    public void resetPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQName();
            return;
        }
        this.psdevcentermqnameDirtyFlag = false;
        this.psdevcentermqname = null;
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
        PSDepSlnMQInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnMQInstBase pSDepSlnMQInstBase) {
        pSDepSlnMQInstBase.resetConnStr();
        pSDepSlnMQInstBase.resetCreateDate();
        pSDepSlnMQInstBase.resetCreateMan();
        pSDepSlnMQInstBase.resetEnableLocalMode();
        pSDepSlnMQInstBase.resetEnableRemoteMode();
        pSDepSlnMQInstBase.resetMemo();
        pSDepSlnMQInstBase.resetMQType();
        pSDepSlnMQInstBase.resetPasswd();
        pSDepSlnMQInstBase.resetPSDepSlnHostId();
        pSDepSlnMQInstBase.resetPSDepSlnHostName();
        pSDepSlnMQInstBase.resetPSDepSlnId();
        pSDepSlnMQInstBase.resetPSDepSlnMQInstId();
        pSDepSlnMQInstBase.resetPSDepSlnMQInstName();
        pSDepSlnMQInstBase.resetPSDepSlnName();
        pSDepSlnMQInstBase.resetPSDevCenterMQId();
        pSDepSlnMQInstBase.resetPSDevCenterMQName();
        pSDepSlnMQInstBase.resetUpdateDate();
        pSDepSlnMQInstBase.resetUpdateMan();
        pSDepSlnMQInstBase.resetUserName();
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
        if (!bl || this.isEnableLocalModeDirty()) {
            hashMap.put(FIELD_ENABLELOCALMODE, this.getEnableLocalMode());
        }
        if (!bl || this.isEnableRemoteModeDirty()) {
            hashMap.put(FIELD_ENABLEREMOTEMODE, this.getEnableRemoteMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMQTypeDirty()) {
            hashMap.put(FIELD_MQTYPE, this.getMQType());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
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
        if (!bl || this.isPSDepSlnMQInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMQINSTID, this.getPSDepSlnMQInstId());
        }
        if (!bl || this.isPSDepSlnMQInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMQINSTNAME, this.getPSDepSlnMQInstName());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDevCenterMQIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQID, this.getPSDevCenterMQId());
        }
        if (!bl || this.isPSDevCenterMQNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQNAME, this.getPSDevCenterMQName());
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
        return PSDepSlnMQInstBase.get(this, n);
    }

    private static Object get(PSDepSlnMQInstBase pSDepSlnMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnMQInstBase.getConnStr();
            }
            case 1: {
                return pSDepSlnMQInstBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnMQInstBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnMQInstBase.getEnableLocalMode();
            }
            case 4: {
                return pSDepSlnMQInstBase.getEnableRemoteMode();
            }
            case 5: {
                return pSDepSlnMQInstBase.getMemo();
            }
            case 6: {
                return pSDepSlnMQInstBase.getMQType();
            }
            case 7: {
                return pSDepSlnMQInstBase.getPasswd();
            }
            case 8: {
                return pSDepSlnMQInstBase.getPSDepSlnHostId();
            }
            case 9: {
                return pSDepSlnMQInstBase.getPSDepSlnHostName();
            }
            case 10: {
                return pSDepSlnMQInstBase.getPSDepSlnId();
            }
            case 11: {
                return pSDepSlnMQInstBase.getPSDepSlnMQInstId();
            }
            case 12: {
                return pSDepSlnMQInstBase.getPSDepSlnMQInstName();
            }
            case 13: {
                return pSDepSlnMQInstBase.getPSDepSlnName();
            }
            case 14: {
                return pSDepSlnMQInstBase.getPSDevCenterMQId();
            }
            case 15: {
                return pSDepSlnMQInstBase.getPSDevCenterMQName();
            }
            case 16: {
                return pSDepSlnMQInstBase.getUpdateDate();
            }
            case 17: {
                return pSDepSlnMQInstBase.getUpdateMan();
            }
            case 18: {
                return pSDepSlnMQInstBase.getUserName();
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
        PSDepSlnMQInstBase.set(this, n, object);
    }

    private static void set(PSDepSlnMQInstBase pSDepSlnMQInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnMQInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnMQInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnMQInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnMQInstBase.setEnableLocalMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnMQInstBase.setEnableRemoteMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnMQInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnMQInstBase.setMQType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnMQInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnMQInstBase.setPSDepSlnHostId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnMQInstBase.setPSDepSlnHostName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnMQInstBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnMQInstBase.setPSDepSlnMQInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnMQInstBase.setPSDepSlnMQInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnMQInstBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnMQInstBase.setPSDevCenterMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnMQInstBase.setPSDevCenterMQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnMQInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnMQInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnMQInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSDepSlnMQInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnMQInstBase pSDepSlnMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnMQInstBase.getConnStr() == null;
            }
            case 1: {
                return pSDepSlnMQInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnMQInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnMQInstBase.getEnableLocalMode() == null;
            }
            case 4: {
                return pSDepSlnMQInstBase.getEnableRemoteMode() == null;
            }
            case 5: {
                return pSDepSlnMQInstBase.getMemo() == null;
            }
            case 6: {
                return pSDepSlnMQInstBase.getMQType() == null;
            }
            case 7: {
                return pSDepSlnMQInstBase.getPasswd() == null;
            }
            case 8: {
                return pSDepSlnMQInstBase.getPSDepSlnHostId() == null;
            }
            case 9: {
                return pSDepSlnMQInstBase.getPSDepSlnHostName() == null;
            }
            case 10: {
                return pSDepSlnMQInstBase.getPSDepSlnId() == null;
            }
            case 11: {
                return pSDepSlnMQInstBase.getPSDepSlnMQInstId() == null;
            }
            case 12: {
                return pSDepSlnMQInstBase.getPSDepSlnMQInstName() == null;
            }
            case 13: {
                return pSDepSlnMQInstBase.getPSDepSlnName() == null;
            }
            case 14: {
                return pSDepSlnMQInstBase.getPSDevCenterMQId() == null;
            }
            case 15: {
                return pSDepSlnMQInstBase.getPSDevCenterMQName() == null;
            }
            case 16: {
                return pSDepSlnMQInstBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDepSlnMQInstBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDepSlnMQInstBase.getUserName() == null;
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
        return PSDepSlnMQInstBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnMQInstBase pSDepSlnMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnMQInstBase.isConnStrDirty();
            }
            case 1: {
                return pSDepSlnMQInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnMQInstBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnMQInstBase.isEnableLocalModeDirty();
            }
            case 4: {
                return pSDepSlnMQInstBase.isEnableRemoteModeDirty();
            }
            case 5: {
                return pSDepSlnMQInstBase.isMemoDirty();
            }
            case 6: {
                return pSDepSlnMQInstBase.isMQTypeDirty();
            }
            case 7: {
                return pSDepSlnMQInstBase.isPasswdDirty();
            }
            case 8: {
                return pSDepSlnMQInstBase.isPSDepSlnHostIdDirty();
            }
            case 9: {
                return pSDepSlnMQInstBase.isPSDepSlnHostNameDirty();
            }
            case 10: {
                return pSDepSlnMQInstBase.isPSDepSlnIdDirty();
            }
            case 11: {
                return pSDepSlnMQInstBase.isPSDepSlnMQInstIdDirty();
            }
            case 12: {
                return pSDepSlnMQInstBase.isPSDepSlnMQInstNameDirty();
            }
            case 13: {
                return pSDepSlnMQInstBase.isPSDepSlnNameDirty();
            }
            case 14: {
                return pSDepSlnMQInstBase.isPSDevCenterMQIdDirty();
            }
            case 15: {
                return pSDepSlnMQInstBase.isPSDevCenterMQNameDirty();
            }
            case 16: {
                return pSDepSlnMQInstBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDepSlnMQInstBase.isUpdateManDirty();
            }
            case 18: {
                return pSDepSlnMQInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnMQInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnMQInstBase pSDepSlnMQInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnMQInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getEnableLocalMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelocalmode", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getEnableLocalMode()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getEnableRemoteMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremotemode", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getEnableRemoteMode()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getMQType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mqtype", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getMQType()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnHostId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostid", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnHostId()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnHostName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostname", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnHostName()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmqinstid", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnMQInstId()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmqinstname", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnMQInstName()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDevCenterMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqid", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDevCenterMQId()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getPSDevCenterMQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqname", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getPSDevCenterMQName()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnMQInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDepSlnMQInstBase.getJSONValue((Object)pSDepSlnMQInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnMQInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnMQInstBase pSDepSlnMQInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnMQInstBase.getConnStr() != null) {
            object = pSDepSlnMQInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getCreateDate() != null) {
            object = pSDepSlnMQInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnMQInstBase.getCreateMan() != null) {
            object = pSDepSlnMQInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getEnableLocalMode() != null) {
            object = pSDepSlnMQInstBase.getEnableLocalMode();
            xmlNode.setAttribute(FIELD_ENABLELOCALMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnMQInstBase.getEnableRemoteMode() != null) {
            object = pSDepSlnMQInstBase.getEnableRemoteMode();
            xmlNode.setAttribute(FIELD_ENABLEREMOTEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnMQInstBase.getMemo() != null) {
            object = pSDepSlnMQInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getMQType() != null) {
            object = pSDepSlnMQInstBase.getMQType();
            xmlNode.setAttribute(FIELD_MQTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPasswd() != null) {
            object = pSDepSlnMQInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnHostId() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnHostId();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnHostName() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnHostName();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnId() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstId() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnMQInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMQINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstName() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnMQInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMQINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDepSlnName() != null) {
            object = pSDepSlnMQInstBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDevCenterMQId() != null) {
            object = pSDepSlnMQInstBase.getPSDevCenterMQId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getPSDevCenterMQName() != null) {
            object = pSDepSlnMQInstBase.getPSDevCenterMQName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getUpdateDate() != null) {
            object = pSDepSlnMQInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnMQInstBase.getUpdateMan() != null) {
            object = pSDepSlnMQInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnMQInstBase.getUserName() != null) {
            object = pSDepSlnMQInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnMQInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnMQInstBase pSDepSlnMQInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnMQInstBase.isConnStrDirty() && (bl || pSDepSlnMQInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDepSlnMQInstBase.getConnStr());
        }
        if (pSDepSlnMQInstBase.isCreateDateDirty() && (bl || pSDepSlnMQInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnMQInstBase.getCreateDate());
        }
        if (pSDepSlnMQInstBase.isCreateManDirty() && (bl || pSDepSlnMQInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnMQInstBase.getCreateMan());
        }
        if (pSDepSlnMQInstBase.isEnableLocalModeDirty() && (bl || pSDepSlnMQInstBase.getEnableLocalMode() != null)) {
            iDataObject.set(FIELD_ENABLELOCALMODE, (Object)pSDepSlnMQInstBase.getEnableLocalMode());
        }
        if (pSDepSlnMQInstBase.isEnableRemoteModeDirty() && (bl || pSDepSlnMQInstBase.getEnableRemoteMode() != null)) {
            iDataObject.set(FIELD_ENABLEREMOTEMODE, (Object)pSDepSlnMQInstBase.getEnableRemoteMode());
        }
        if (pSDepSlnMQInstBase.isMemoDirty() && (bl || pSDepSlnMQInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnMQInstBase.getMemo());
        }
        if (pSDepSlnMQInstBase.isMQTypeDirty() && (bl || pSDepSlnMQInstBase.getMQType() != null)) {
            iDataObject.set(FIELD_MQTYPE, (Object)pSDepSlnMQInstBase.getMQType());
        }
        if (pSDepSlnMQInstBase.isPasswdDirty() && (bl || pSDepSlnMQInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDepSlnMQInstBase.getPasswd());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnHostIdDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnHostId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTID, (Object)pSDepSlnMQInstBase.getPSDepSlnHostId());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnHostNameDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnHostName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTNAME, (Object)pSDepSlnMQInstBase.getPSDepSlnHostName());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnIdDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnMQInstBase.getPSDepSlnId());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnMQInstIdDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMQINSTID, (Object)pSDepSlnMQInstBase.getPSDepSlnMQInstId());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnMQInstNameDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnMQInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMQINSTNAME, (Object)pSDepSlnMQInstBase.getPSDepSlnMQInstName());
        }
        if (pSDepSlnMQInstBase.isPSDepSlnNameDirty() && (bl || pSDepSlnMQInstBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnMQInstBase.getPSDepSlnName());
        }
        if (pSDepSlnMQInstBase.isPSDevCenterMQIdDirty() && (bl || pSDepSlnMQInstBase.getPSDevCenterMQId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQID, (Object)pSDepSlnMQInstBase.getPSDevCenterMQId());
        }
        if (pSDepSlnMQInstBase.isPSDevCenterMQNameDirty() && (bl || pSDepSlnMQInstBase.getPSDevCenterMQName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQNAME, (Object)pSDepSlnMQInstBase.getPSDevCenterMQName());
        }
        if (pSDepSlnMQInstBase.isUpdateDateDirty() && (bl || pSDepSlnMQInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnMQInstBase.getUpdateDate());
        }
        if (pSDepSlnMQInstBase.isUpdateManDirty() && (bl || pSDepSlnMQInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnMQInstBase.getUpdateMan());
        }
        if (pSDepSlnMQInstBase.isUserNameDirty() && (bl || pSDepSlnMQInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDepSlnMQInstBase.getUserName());
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
        return PSDepSlnMQInstBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnMQInstBase pSDepSlnMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnMQInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDepSlnMQInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnMQInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnMQInstBase.resetEnableLocalMode();
                return true;
            }
            case 4: {
                pSDepSlnMQInstBase.resetEnableRemoteMode();
                return true;
            }
            case 5: {
                pSDepSlnMQInstBase.resetMemo();
                return true;
            }
            case 6: {
                pSDepSlnMQInstBase.resetMQType();
                return true;
            }
            case 7: {
                pSDepSlnMQInstBase.resetPasswd();
                return true;
            }
            case 8: {
                pSDepSlnMQInstBase.resetPSDepSlnHostId();
                return true;
            }
            case 9: {
                pSDepSlnMQInstBase.resetPSDepSlnHostName();
                return true;
            }
            case 10: {
                pSDepSlnMQInstBase.resetPSDepSlnId();
                return true;
            }
            case 11: {
                pSDepSlnMQInstBase.resetPSDepSlnMQInstId();
                return true;
            }
            case 12: {
                pSDepSlnMQInstBase.resetPSDepSlnMQInstName();
                return true;
            }
            case 13: {
                pSDepSlnMQInstBase.resetPSDepSlnName();
                return true;
            }
            case 14: {
                pSDepSlnMQInstBase.resetPSDevCenterMQId();
                return true;
            }
            case 15: {
                pSDepSlnMQInstBase.resetPSDevCenterMQName();
                return true;
            }
            case 16: {
                pSDepSlnMQInstBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDepSlnMQInstBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDepSlnMQInstBase.resetUserName();
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
                pSDepSlnHostService.autoGet((IEntity)pSDepSlnHost);
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
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterMQ getPSDevCenterMQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQ();
        }
        if (this.getPSDevCenterMQId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterMQLock;
        synchronized (n) {
            if (this.psdevcentermq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterMQId(), (Object)this.psdevcentermq.getPSDevCenterMQId()) != 0L) {
                this.psdevcentermq = null;
            }
            if (this.psdevcentermq == null) {
                PSDevCenterMQ pSDevCenterMQ = new PSDevCenterMQ();
                pSDevCenterMQ.setPSDevCenterMQId(this.getPSDevCenterMQId());
                PSDevCenterMQService pSDevCenterMQService = (PSDevCenterMQService)ServiceGlobal.getService(PSDevCenterMQService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterMQService.autoGet((IEntity)pSDevCenterMQ);
                this.psdevcentermq = pSDevCenterMQ;
            }
            return this.psdevcentermq;
        }
    }

    private PSDepSlnMQInstBase getProxyEntity() {
        return this.proxyPSDepSlnMQInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnMQInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnMQInstBase) {
            this.proxyPSDepSlnMQInstBase = (PSDepSlnMQInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLELOCALMODE, 3);
        fieldIndexMap.put(FIELD_ENABLEREMOTEMODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MQTYPE, 6);
        fieldIndexMap.put(FIELD_PASSWD, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNMQINSTID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNMQINSTNAME, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERNAME, 18);
    }
}

