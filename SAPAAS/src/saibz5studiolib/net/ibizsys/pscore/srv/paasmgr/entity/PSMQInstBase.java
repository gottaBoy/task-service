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

public abstract class PSMQInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMQInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MQTYPE = "MQTYPE";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMQINSTID = "PSMQINSTID";
    public static final String FIELD_PSMQINSTNAME = "PSMQINSTNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_INSTSTATE = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_LOCALRES = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MQTYPE = 7;
    private static final int INDEX_PARAM = 8;
    private static final int INDEX_PARAM2 = 9;
    private static final int INDEX_PARAM3 = 10;
    private static final int INDEX_PARAM4 = 11;
    private static final int INDEX_PARAM5 = 12;
    private static final int INDEX_PARAM6 = 13;
    private static final int INDEX_PARAM7 = 14;
    private static final int INDEX_PARAM8 = 15;
    private static final int INDEX_PASSWD = 16;
    private static final int INDEX_PORT = 17;
    private static final int INDEX_PSMQINSTID = 18;
    private static final int INDEX_PSMQINSTNAME = 19;
    private static final int INDEX_PSSVRDOMAINID = 20;
    private static final int INDEX_PSSVRDOMAINNAME = 21;
    private static final int INDEX_REFINFO = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USAGEMODE = 25;
    private static final int INDEX_USERNAME = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMQInstBase proxyPSMQInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mqtypeDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmqinstidDirtyFlag = false;
    private boolean psmqinstnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="mqtype")
    private String mqtype;
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
    @Column(name="port")
    private Integer port;
    @Column(name="psmqinstid")
    private String psmqinstid;
    @Column(name="psmqinstname")
    private String psmqinstname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="username")
    private String username;
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

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
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

    public void setIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr();
        }
        return this.ipaddr;
    }

    public boolean isIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
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

    public void setPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort(n);
            return;
        }
        this.port = n;
        this.portDirtyFlag = true;
    }

    public Integer getPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort();
        }
        return this.port;
    }

    public boolean isPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortDirty();
        }
        return this.portDirtyFlag;
    }

    public void resetPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort();
            return;
        }
        this.portDirtyFlag = false;
        this.port = null;
    }

    public void setPSMQInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqinstid = string;
        this.psmqinstidDirtyFlag = true;
    }

    public String getPSMQInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQInstId();
        }
        return this.psmqinstid;
    }

    public boolean isPSMQInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQInstIdDirty();
        }
        return this.psmqinstidDirtyFlag;
    }

    public void resetPSMQInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQInstId();
            return;
        }
        this.psmqinstidDirtyFlag = false;
        this.psmqinstid = null;
    }

    public void setPSMQInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqinstname = string;
        this.psmqinstnameDirtyFlag = true;
    }

    public String getPSMQInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQInstName();
        }
        return this.psmqinstname;
    }

    public boolean isPSMQInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQInstNameDirty();
        }
        return this.psmqinstnameDirtyFlag;
    }

    public void resetPSMQInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQInstName();
            return;
        }
        this.psmqinstnameDirtyFlag = false;
        this.psmqinstname = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
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
        PSMQInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMQInstBase pSMQInstBase) {
        pSMQInstBase.resetConnStr();
        pSMQInstBase.resetCreateDate();
        pSMQInstBase.resetCreateMan();
        pSMQInstBase.resetInstState();
        pSMQInstBase.resetIPAddr();
        pSMQInstBase.resetLocalRes();
        pSMQInstBase.resetMemo();
        pSMQInstBase.resetMQType();
        pSMQInstBase.resetParam();
        pSMQInstBase.resetParam2();
        pSMQInstBase.resetParam3();
        pSMQInstBase.resetParam4();
        pSMQInstBase.resetParam5();
        pSMQInstBase.resetParam6();
        pSMQInstBase.resetParam7();
        pSMQInstBase.resetParam8();
        pSMQInstBase.resetPasswd();
        pSMQInstBase.resetPort();
        pSMQInstBase.resetPSMQInstId();
        pSMQInstBase.resetPSMQInstName();
        pSMQInstBase.resetPSSvrDomainId();
        pSMQInstBase.resetPSSvrDomainName();
        pSMQInstBase.resetRefInfo();
        pSMQInstBase.resetUpdateDate();
        pSMQInstBase.resetUpdateMan();
        pSMQInstBase.resetUsageMode();
        pSMQInstBase.resetUserName();
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
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMQTypeDirty()) {
            hashMap.put(FIELD_MQTYPE, this.getMQType());
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
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSMQInstIdDirty()) {
            hashMap.put(FIELD_PSMQINSTID, this.getPSMQInstId());
        }
        if (!bl || this.isPSMQInstNameDirty()) {
            hashMap.put(FIELD_PSMQINSTNAME, this.getPSMQInstName());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
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
        return PSMQInstBase.get(this, n);
    }

    private static Object get(PSMQInstBase pSMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQInstBase.getConnStr();
            }
            case 1: {
                return pSMQInstBase.getCreateDate();
            }
            case 2: {
                return pSMQInstBase.getCreateMan();
            }
            case 3: {
                return pSMQInstBase.getInstState();
            }
            case 4: {
                return pSMQInstBase.getIPAddr();
            }
            case 5: {
                return pSMQInstBase.getLocalRes();
            }
            case 6: {
                return pSMQInstBase.getMemo();
            }
            case 7: {
                return pSMQInstBase.getMQType();
            }
            case 8: {
                return pSMQInstBase.getParam();
            }
            case 9: {
                return pSMQInstBase.getParam2();
            }
            case 10: {
                return pSMQInstBase.getParam3();
            }
            case 11: {
                return pSMQInstBase.getParam4();
            }
            case 12: {
                return pSMQInstBase.getParam5();
            }
            case 13: {
                return pSMQInstBase.getParam6();
            }
            case 14: {
                return pSMQInstBase.getParam7();
            }
            case 15: {
                return pSMQInstBase.getParam8();
            }
            case 16: {
                return pSMQInstBase.getPasswd();
            }
            case 17: {
                return pSMQInstBase.getPort();
            }
            case 18: {
                return pSMQInstBase.getPSMQInstId();
            }
            case 19: {
                return pSMQInstBase.getPSMQInstName();
            }
            case 20: {
                return pSMQInstBase.getPSSvrDomainId();
            }
            case 21: {
                return pSMQInstBase.getPSSvrDomainName();
            }
            case 22: {
                return pSMQInstBase.getRefInfo();
            }
            case 23: {
                return pSMQInstBase.getUpdateDate();
            }
            case 24: {
                return pSMQInstBase.getUpdateMan();
            }
            case 25: {
                return pSMQInstBase.getUsageMode();
            }
            case 26: {
                return pSMQInstBase.getUserName();
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
        PSMQInstBase.set(this, n, object);
    }

    private static void set(PSMQInstBase pSMQInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMQInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMQInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMQInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMQInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSMQInstBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMQInstBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSMQInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMQInstBase.setMQType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMQInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMQInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMQInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMQInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMQInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSMQInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSMQInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSMQInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSMQInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMQInstBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSMQInstBase.setPSMQInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSMQInstBase.setPSMQInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMQInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMQInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSMQInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSMQInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSMQInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMQInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSMQInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSMQInstBase.isNull(this, n);
    }

    private static boolean isNull(PSMQInstBase pSMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQInstBase.getConnStr() == null;
            }
            case 1: {
                return pSMQInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSMQInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSMQInstBase.getInstState() == null;
            }
            case 4: {
                return pSMQInstBase.getIPAddr() == null;
            }
            case 5: {
                return pSMQInstBase.getLocalRes() == null;
            }
            case 6: {
                return pSMQInstBase.getMemo() == null;
            }
            case 7: {
                return pSMQInstBase.getMQType() == null;
            }
            case 8: {
                return pSMQInstBase.getParam() == null;
            }
            case 9: {
                return pSMQInstBase.getParam2() == null;
            }
            case 10: {
                return pSMQInstBase.getParam3() == null;
            }
            case 11: {
                return pSMQInstBase.getParam4() == null;
            }
            case 12: {
                return pSMQInstBase.getParam5() == null;
            }
            case 13: {
                return pSMQInstBase.getParam6() == null;
            }
            case 14: {
                return pSMQInstBase.getParam7() == null;
            }
            case 15: {
                return pSMQInstBase.getParam8() == null;
            }
            case 16: {
                return pSMQInstBase.getPasswd() == null;
            }
            case 17: {
                return pSMQInstBase.getPort() == null;
            }
            case 18: {
                return pSMQInstBase.getPSMQInstId() == null;
            }
            case 19: {
                return pSMQInstBase.getPSMQInstName() == null;
            }
            case 20: {
                return pSMQInstBase.getPSSvrDomainId() == null;
            }
            case 21: {
                return pSMQInstBase.getPSSvrDomainName() == null;
            }
            case 22: {
                return pSMQInstBase.getRefInfo() == null;
            }
            case 23: {
                return pSMQInstBase.getUpdateDate() == null;
            }
            case 24: {
                return pSMQInstBase.getUpdateMan() == null;
            }
            case 25: {
                return pSMQInstBase.getUsageMode() == null;
            }
            case 26: {
                return pSMQInstBase.getUserName() == null;
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
        return PSMQInstBase.contains(this, n);
    }

    private static boolean contains(PSMQInstBase pSMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQInstBase.isConnStrDirty();
            }
            case 1: {
                return pSMQInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSMQInstBase.isCreateManDirty();
            }
            case 3: {
                return pSMQInstBase.isInstStateDirty();
            }
            case 4: {
                return pSMQInstBase.isIPAddrDirty();
            }
            case 5: {
                return pSMQInstBase.isLocalResDirty();
            }
            case 6: {
                return pSMQInstBase.isMemoDirty();
            }
            case 7: {
                return pSMQInstBase.isMQTypeDirty();
            }
            case 8: {
                return pSMQInstBase.isParamDirty();
            }
            case 9: {
                return pSMQInstBase.isParam2Dirty();
            }
            case 10: {
                return pSMQInstBase.isParam3Dirty();
            }
            case 11: {
                return pSMQInstBase.isParam4Dirty();
            }
            case 12: {
                return pSMQInstBase.isParam5Dirty();
            }
            case 13: {
                return pSMQInstBase.isParam6Dirty();
            }
            case 14: {
                return pSMQInstBase.isParam7Dirty();
            }
            case 15: {
                return pSMQInstBase.isParam8Dirty();
            }
            case 16: {
                return pSMQInstBase.isPasswdDirty();
            }
            case 17: {
                return pSMQInstBase.isPortDirty();
            }
            case 18: {
                return pSMQInstBase.isPSMQInstIdDirty();
            }
            case 19: {
                return pSMQInstBase.isPSMQInstNameDirty();
            }
            case 20: {
                return pSMQInstBase.isPSSvrDomainIdDirty();
            }
            case 21: {
                return pSMQInstBase.isPSSvrDomainNameDirty();
            }
            case 22: {
                return pSMQInstBase.isRefInfoDirty();
            }
            case 23: {
                return pSMQInstBase.isUpdateDateDirty();
            }
            case 24: {
                return pSMQInstBase.isUpdateManDirty();
            }
            case 25: {
                return pSMQInstBase.isUsageModeDirty();
            }
            case 26: {
                return pSMQInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMQInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMQInstBase pSMQInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMQInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSMQInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMQInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMQInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSMQInstBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSMQInstBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSMQInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSMQInstBase.getMQType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mqtype", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getMQType()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSMQInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPort()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPSMQInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqinstid", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPSMQInstId()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPSMQInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqinstname", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPSMQInstName()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSMQInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSMQInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSMQInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMQInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMQInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSMQInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMQInstBase.getJSONValue((Object)pSMQInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMQInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMQInstBase pSMQInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMQInstBase.getConnStr() != null) {
            object = pSMQInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getCreateDate() != null) {
            object = pSMQInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMQInstBase.getCreateMan() != null) {
            object = pSMQInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getInstState() != null) {
            object = pSMQInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getIPAddr() != null) {
            object = pSMQInstBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getLocalRes() != null) {
            object = pSMQInstBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getMemo() != null) {
            object = pSMQInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getMQType() != null) {
            object = pSMQInstBase.getMQType();
            xmlNode.setAttribute(FIELD_MQTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getParam() != null) {
            object = pSMQInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getParam2() != null) {
            object = pSMQInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getParam3() != null) {
            object = pSMQInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getParam4() != null) {
            object = pSMQInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getParam5() != null) {
            object = pSMQInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getParam6() != null) {
            object = pSMQInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getParam7() != null) {
            object = pSMQInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getParam8() != null) {
            object = pSMQInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getPasswd() != null) {
            object = pSMQInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getPort() != null) {
            object = pSMQInstBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMQInstBase.getPSMQInstId() != null) {
            object = pSMQInstBase.getPSMQInstId();
            xmlNode.setAttribute(FIELD_PSMQINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getPSMQInstName() != null) {
            object = pSMQInstBase.getPSMQInstName();
            xmlNode.setAttribute(FIELD_PSMQINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getPSSvrDomainId() != null) {
            object = pSMQInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getPSSvrDomainName() != null) {
            object = pSMQInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getRefInfo() != null) {
            object = pSMQInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getUpdateDate() != null) {
            object = pSMQInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMQInstBase.getUpdateMan() != null) {
            object = pSMQInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getUsageMode() != null) {
            object = pSMQInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMQInstBase.getUserName() != null) {
            object = pSMQInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMQInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMQInstBase pSMQInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMQInstBase.isConnStrDirty() && (bl || pSMQInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSMQInstBase.getConnStr());
        }
        if (pSMQInstBase.isCreateDateDirty() && (bl || pSMQInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMQInstBase.getCreateDate());
        }
        if (pSMQInstBase.isCreateManDirty() && (bl || pSMQInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMQInstBase.getCreateMan());
        }
        if (pSMQInstBase.isInstStateDirty() && (bl || pSMQInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSMQInstBase.getInstState());
        }
        if (pSMQInstBase.isIPAddrDirty() && (bl || pSMQInstBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMQInstBase.getIPAddr());
        }
        if (pSMQInstBase.isLocalResDirty() && (bl || pSMQInstBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSMQInstBase.getLocalRes());
        }
        if (pSMQInstBase.isMemoDirty() && (bl || pSMQInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMQInstBase.getMemo());
        }
        if (pSMQInstBase.isMQTypeDirty() && (bl || pSMQInstBase.getMQType() != null)) {
            iDataObject.set(FIELD_MQTYPE, (Object)pSMQInstBase.getMQType());
        }
        if (pSMQInstBase.isParamDirty() && (bl || pSMQInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSMQInstBase.getParam());
        }
        if (pSMQInstBase.isParam2Dirty() && (bl || pSMQInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSMQInstBase.getParam2());
        }
        if (pSMQInstBase.isParam3Dirty() && (bl || pSMQInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSMQInstBase.getParam3());
        }
        if (pSMQInstBase.isParam4Dirty() && (bl || pSMQInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSMQInstBase.getParam4());
        }
        if (pSMQInstBase.isParam5Dirty() && (bl || pSMQInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSMQInstBase.getParam5());
        }
        if (pSMQInstBase.isParam6Dirty() && (bl || pSMQInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSMQInstBase.getParam6());
        }
        if (pSMQInstBase.isParam7Dirty() && (bl || pSMQInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSMQInstBase.getParam7());
        }
        if (pSMQInstBase.isParam8Dirty() && (bl || pSMQInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSMQInstBase.getParam8());
        }
        if (pSMQInstBase.isPasswdDirty() && (bl || pSMQInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMQInstBase.getPasswd());
        }
        if (pSMQInstBase.isPortDirty() && (bl || pSMQInstBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMQInstBase.getPort());
        }
        if (pSMQInstBase.isPSMQInstIdDirty() && (bl || pSMQInstBase.getPSMQInstId() != null)) {
            iDataObject.set(FIELD_PSMQINSTID, (Object)pSMQInstBase.getPSMQInstId());
        }
        if (pSMQInstBase.isPSMQInstNameDirty() && (bl || pSMQInstBase.getPSMQInstName() != null)) {
            iDataObject.set(FIELD_PSMQINSTNAME, (Object)pSMQInstBase.getPSMQInstName());
        }
        if (pSMQInstBase.isPSSvrDomainIdDirty() && (bl || pSMQInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSMQInstBase.getPSSvrDomainId());
        }
        if (pSMQInstBase.isPSSvrDomainNameDirty() && (bl || pSMQInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSMQInstBase.getPSSvrDomainName());
        }
        if (pSMQInstBase.isRefInfoDirty() && (bl || pSMQInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSMQInstBase.getRefInfo());
        }
        if (pSMQInstBase.isUpdateDateDirty() && (bl || pSMQInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMQInstBase.getUpdateDate());
        }
        if (pSMQInstBase.isUpdateManDirty() && (bl || pSMQInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMQInstBase.getUpdateMan());
        }
        if (pSMQInstBase.isUsageModeDirty() && (bl || pSMQInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSMQInstBase.getUsageMode());
        }
        if (pSMQInstBase.isUserNameDirty() && (bl || pSMQInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMQInstBase.getUserName());
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
        return PSMQInstBase.remove(this, n);
    }

    private static boolean remove(PSMQInstBase pSMQInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMQInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSMQInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMQInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMQInstBase.resetInstState();
                return true;
            }
            case 4: {
                pSMQInstBase.resetIPAddr();
                return true;
            }
            case 5: {
                pSMQInstBase.resetLocalRes();
                return true;
            }
            case 6: {
                pSMQInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSMQInstBase.resetMQType();
                return true;
            }
            case 8: {
                pSMQInstBase.resetParam();
                return true;
            }
            case 9: {
                pSMQInstBase.resetParam2();
                return true;
            }
            case 10: {
                pSMQInstBase.resetParam3();
                return true;
            }
            case 11: {
                pSMQInstBase.resetParam4();
                return true;
            }
            case 12: {
                pSMQInstBase.resetParam5();
                return true;
            }
            case 13: {
                pSMQInstBase.resetParam6();
                return true;
            }
            case 14: {
                pSMQInstBase.resetParam7();
                return true;
            }
            case 15: {
                pSMQInstBase.resetParam8();
                return true;
            }
            case 16: {
                pSMQInstBase.resetPasswd();
                return true;
            }
            case 17: {
                pSMQInstBase.resetPort();
                return true;
            }
            case 18: {
                pSMQInstBase.resetPSMQInstId();
                return true;
            }
            case 19: {
                pSMQInstBase.resetPSMQInstName();
                return true;
            }
            case 20: {
                pSMQInstBase.resetPSSvrDomainId();
                return true;
            }
            case 21: {
                pSMQInstBase.resetPSSvrDomainName();
                return true;
            }
            case 22: {
                pSMQInstBase.resetRefInfo();
                return true;
            }
            case 23: {
                pSMQInstBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSMQInstBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSMQInstBase.resetUsageMode();
                return true;
            }
            case 26: {
                pSMQInstBase.resetUserName();
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
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSMQInstBase getProxyEntity() {
        return this.proxyPSMQInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMQInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSMQInstBase) {
            this.proxyPSMQInstBase = (PSMQInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMQInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_INSTSTATE, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_LOCALRES, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MQTYPE, 7);
        fieldIndexMap.put(FIELD_PARAM, 8);
        fieldIndexMap.put(FIELD_PARAM2, 9);
        fieldIndexMap.put(FIELD_PARAM3, 10);
        fieldIndexMap.put(FIELD_PARAM4, 11);
        fieldIndexMap.put(FIELD_PARAM5, 12);
        fieldIndexMap.put(FIELD_PARAM6, 13);
        fieldIndexMap.put(FIELD_PARAM7, 14);
        fieldIndexMap.put(FIELD_PARAM8, 15);
        fieldIndexMap.put(FIELD_PASSWD, 16);
        fieldIndexMap.put(FIELD_PORT, 17);
        fieldIndexMap.put(FIELD_PSMQINSTID, 18);
        fieldIndexMap.put(FIELD_PSMQINSTNAME, 19);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 20);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 21);
        fieldIndexMap.put(FIELD_REFINFO, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USAGEMODE, 25);
        fieldIndexMap.put(FIELD_USERNAME, 26);
    }
}

