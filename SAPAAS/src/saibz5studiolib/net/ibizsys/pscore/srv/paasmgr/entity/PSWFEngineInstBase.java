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

public abstract class PSWFEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFEngineInstBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
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
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSWFENGINEINSTID = "PSWFENGINEINSTID";
    public static final String FIELD_PSWFENGINEINSTNAME = "PSWFENGINEINSTNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_INSTSTATE = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_LOCALRES = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PARAM = 7;
    private static final int INDEX_PARAM2 = 8;
    private static final int INDEX_PARAM3 = 9;
    private static final int INDEX_PARAM4 = 10;
    private static final int INDEX_PARAM5 = 11;
    private static final int INDEX_PARAM6 = 12;
    private static final int INDEX_PARAM7 = 13;
    private static final int INDEX_PARAM8 = 14;
    private static final int INDEX_PASSWD = 15;
    private static final int INDEX_PORT = 16;
    private static final int INDEX_PSSVRDOMAINID = 17;
    private static final int INDEX_PSSVRDOMAINNAME = 18;
    private static final int INDEX_PSWFENGINEINSTID = 19;
    private static final int INDEX_PSWFENGINEINSTNAME = 20;
    private static final int INDEX_REFINFO = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USAGEMODE = 24;
    private static final int INDEX_USERNAME = 25;
    private static final int INDEX_WFENGINETYPE = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFEngineInstBase proxyPSWFEngineInstBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
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
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pswfengineinstidDirtyFlag = false;
    private boolean pswfengineinstnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
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
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pswfengineinstid")
    private String pswfengineinstid;
    @Column(name="pswfengineinstname")
    private String pswfengineinstname;
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
    @Column(name="wfenginetype")
    private String wfenginetype;
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

    public void setPSWFEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfengineinstid = string;
        this.pswfengineinstidDirtyFlag = true;
    }

    public String getPSWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFEngineInstId();
        }
        return this.pswfengineinstid;
    }

    public boolean isPSWFEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFEngineInstIdDirty();
        }
        return this.pswfengineinstidDirtyFlag;
    }

    public void resetPSWFEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFEngineInstId();
            return;
        }
        this.pswfengineinstidDirtyFlag = false;
        this.pswfengineinstid = null;
    }

    public void setPSWFEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfengineinstname = string;
        this.pswfengineinstnameDirtyFlag = true;
    }

    public String getPSWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFEngineInstName();
        }
        return this.pswfengineinstname;
    }

    public boolean isPSWFEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFEngineInstNameDirty();
        }
        return this.pswfengineinstnameDirtyFlag;
    }

    public void resetPSWFEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFEngineInstName();
            return;
        }
        this.pswfengineinstnameDirtyFlag = false;
        this.pswfengineinstname = null;
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

    public void setWFEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfenginetype = string;
        this.wfenginetypeDirtyFlag = true;
    }

    public String getWFEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEngineType();
        }
        return this.wfenginetype;
    }

    public boolean isWFEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEngineTypeDirty();
        }
        return this.wfenginetypeDirtyFlag;
    }

    public void resetWFEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEngineType();
            return;
        }
        this.wfenginetypeDirtyFlag = false;
        this.wfenginetype = null;
    }

    protected void onReset() {
        PSWFEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFEngineInstBase pSWFEngineInstBase) {
        pSWFEngineInstBase.resetConnStr();
        pSWFEngineInstBase.resetCreateDate();
        pSWFEngineInstBase.resetCreateMan();
        pSWFEngineInstBase.resetInstState();
        pSWFEngineInstBase.resetIpAddr();
        pSWFEngineInstBase.resetLocalRes();
        pSWFEngineInstBase.resetMemo();
        pSWFEngineInstBase.resetParam();
        pSWFEngineInstBase.resetParam2();
        pSWFEngineInstBase.resetParam3();
        pSWFEngineInstBase.resetParam4();
        pSWFEngineInstBase.resetParam5();
        pSWFEngineInstBase.resetParam6();
        pSWFEngineInstBase.resetParam7();
        pSWFEngineInstBase.resetParam8();
        pSWFEngineInstBase.resetPasswd();
        pSWFEngineInstBase.resetPort();
        pSWFEngineInstBase.resetPSSvrDomainId();
        pSWFEngineInstBase.resetPSSvrDomainName();
        pSWFEngineInstBase.resetPSWFEngineInstId();
        pSWFEngineInstBase.resetPSWFEngineInstName();
        pSWFEngineInstBase.resetRefInfo();
        pSWFEngineInstBase.resetUpdateDate();
        pSWFEngineInstBase.resetUpdateMan();
        pSWFEngineInstBase.resetUsageMode();
        pSWFEngineInstBase.resetUserName();
        pSWFEngineInstBase.resetWFEngineType();
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
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
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
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSWFEngineInstIdDirty()) {
            hashMap.put(FIELD_PSWFENGINEINSTID, this.getPSWFEngineInstId());
        }
        if (!bl || this.isPSWFEngineInstNameDirty()) {
            hashMap.put(FIELD_PSWFENGINEINSTNAME, this.getPSWFEngineInstName());
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
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
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
        return PSWFEngineInstBase.get(this, n);
    }

    private static Object get(PSWFEngineInstBase pSWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineInstBase.getConnStr();
            }
            case 1: {
                return pSWFEngineInstBase.getCreateDate();
            }
            case 2: {
                return pSWFEngineInstBase.getCreateMan();
            }
            case 3: {
                return pSWFEngineInstBase.getInstState();
            }
            case 4: {
                return pSWFEngineInstBase.getIpAddr();
            }
            case 5: {
                return pSWFEngineInstBase.getLocalRes();
            }
            case 6: {
                return pSWFEngineInstBase.getMemo();
            }
            case 7: {
                return pSWFEngineInstBase.getParam();
            }
            case 8: {
                return pSWFEngineInstBase.getParam2();
            }
            case 9: {
                return pSWFEngineInstBase.getParam3();
            }
            case 10: {
                return pSWFEngineInstBase.getParam4();
            }
            case 11: {
                return pSWFEngineInstBase.getParam5();
            }
            case 12: {
                return pSWFEngineInstBase.getParam6();
            }
            case 13: {
                return pSWFEngineInstBase.getParam7();
            }
            case 14: {
                return pSWFEngineInstBase.getParam8();
            }
            case 15: {
                return pSWFEngineInstBase.getPasswd();
            }
            case 16: {
                return pSWFEngineInstBase.getPort();
            }
            case 17: {
                return pSWFEngineInstBase.getPSSvrDomainId();
            }
            case 18: {
                return pSWFEngineInstBase.getPSSvrDomainName();
            }
            case 19: {
                return pSWFEngineInstBase.getPSWFEngineInstId();
            }
            case 20: {
                return pSWFEngineInstBase.getPSWFEngineInstName();
            }
            case 21: {
                return pSWFEngineInstBase.getRefInfo();
            }
            case 22: {
                return pSWFEngineInstBase.getUpdateDate();
            }
            case 23: {
                return pSWFEngineInstBase.getUpdateMan();
            }
            case 24: {
                return pSWFEngineInstBase.getUsageMode();
            }
            case 25: {
                return pSWFEngineInstBase.getUserName();
            }
            case 26: {
                return pSWFEngineInstBase.getWFEngineType();
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
        PSWFEngineInstBase.set(this, n, object);
    }

    private static void set(PSWFEngineInstBase pSWFEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFEngineInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFEngineInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFEngineInstBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFEngineInstBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSWFEngineInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFEngineInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFEngineInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFEngineInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFEngineInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFEngineInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSWFEngineInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWFEngineInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSWFEngineInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWFEngineInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFEngineInstBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSWFEngineInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFEngineInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFEngineInstBase.setPSWFEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFEngineInstBase.setPSWFEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFEngineInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSWFEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFEngineInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFEngineInstBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFEngineInstBase.setWFEngineType(DataObject.getStringValue((Object)object));
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
        return PSWFEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWFEngineInstBase pSWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineInstBase.getConnStr() == null;
            }
            case 1: {
                return pSWFEngineInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFEngineInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFEngineInstBase.getInstState() == null;
            }
            case 4: {
                return pSWFEngineInstBase.getIpAddr() == null;
            }
            case 5: {
                return pSWFEngineInstBase.getLocalRes() == null;
            }
            case 6: {
                return pSWFEngineInstBase.getMemo() == null;
            }
            case 7: {
                return pSWFEngineInstBase.getParam() == null;
            }
            case 8: {
                return pSWFEngineInstBase.getParam2() == null;
            }
            case 9: {
                return pSWFEngineInstBase.getParam3() == null;
            }
            case 10: {
                return pSWFEngineInstBase.getParam4() == null;
            }
            case 11: {
                return pSWFEngineInstBase.getParam5() == null;
            }
            case 12: {
                return pSWFEngineInstBase.getParam6() == null;
            }
            case 13: {
                return pSWFEngineInstBase.getParam7() == null;
            }
            case 14: {
                return pSWFEngineInstBase.getParam8() == null;
            }
            case 15: {
                return pSWFEngineInstBase.getPasswd() == null;
            }
            case 16: {
                return pSWFEngineInstBase.getPort() == null;
            }
            case 17: {
                return pSWFEngineInstBase.getPSSvrDomainId() == null;
            }
            case 18: {
                return pSWFEngineInstBase.getPSSvrDomainName() == null;
            }
            case 19: {
                return pSWFEngineInstBase.getPSWFEngineInstId() == null;
            }
            case 20: {
                return pSWFEngineInstBase.getPSWFEngineInstName() == null;
            }
            case 21: {
                return pSWFEngineInstBase.getRefInfo() == null;
            }
            case 22: {
                return pSWFEngineInstBase.getUpdateDate() == null;
            }
            case 23: {
                return pSWFEngineInstBase.getUpdateMan() == null;
            }
            case 24: {
                return pSWFEngineInstBase.getUsageMode() == null;
            }
            case 25: {
                return pSWFEngineInstBase.getUserName() == null;
            }
            case 26: {
                return pSWFEngineInstBase.getWFEngineType() == null;
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
        return PSWFEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSWFEngineInstBase pSWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineInstBase.isConnStrDirty();
            }
            case 1: {
                return pSWFEngineInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFEngineInstBase.isCreateManDirty();
            }
            case 3: {
                return pSWFEngineInstBase.isInstStateDirty();
            }
            case 4: {
                return pSWFEngineInstBase.isIpAddrDirty();
            }
            case 5: {
                return pSWFEngineInstBase.isLocalResDirty();
            }
            case 6: {
                return pSWFEngineInstBase.isMemoDirty();
            }
            case 7: {
                return pSWFEngineInstBase.isParamDirty();
            }
            case 8: {
                return pSWFEngineInstBase.isParam2Dirty();
            }
            case 9: {
                return pSWFEngineInstBase.isParam3Dirty();
            }
            case 10: {
                return pSWFEngineInstBase.isParam4Dirty();
            }
            case 11: {
                return pSWFEngineInstBase.isParam5Dirty();
            }
            case 12: {
                return pSWFEngineInstBase.isParam6Dirty();
            }
            case 13: {
                return pSWFEngineInstBase.isParam7Dirty();
            }
            case 14: {
                return pSWFEngineInstBase.isParam8Dirty();
            }
            case 15: {
                return pSWFEngineInstBase.isPasswdDirty();
            }
            case 16: {
                return pSWFEngineInstBase.isPortDirty();
            }
            case 17: {
                return pSWFEngineInstBase.isPSSvrDomainIdDirty();
            }
            case 18: {
                return pSWFEngineInstBase.isPSSvrDomainNameDirty();
            }
            case 19: {
                return pSWFEngineInstBase.isPSWFEngineInstIdDirty();
            }
            case 20: {
                return pSWFEngineInstBase.isPSWFEngineInstNameDirty();
            }
            case 21: {
                return pSWFEngineInstBase.isRefInfoDirty();
            }
            case 22: {
                return pSWFEngineInstBase.isUpdateDateDirty();
            }
            case 23: {
                return pSWFEngineInstBase.isUpdateManDirty();
            }
            case 24: {
                return pSWFEngineInstBase.isUsageModeDirty();
            }
            case 25: {
                return pSWFEngineInstBase.isUserNameDirty();
            }
            case 26: {
                return pSWFEngineInstBase.isWFEngineTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFEngineInstBase pSWFEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFEngineInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPort()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPSWFEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfengineinstid", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPSWFEngineInstId()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getPSWFEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfengineinstname", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getPSWFEngineInstName()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getUserName()), (boolean)false);
        }
        if (bl || pSWFEngineInstBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSWFEngineInstBase.getJSONValue((Object)pSWFEngineInstBase.getWFEngineType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFEngineInstBase pSWFEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFEngineInstBase.getConnStr() != null) {
            object = pSWFEngineInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getCreateDate() != null) {
            object = pSWFEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getCreateMan() != null) {
            object = pSWFEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getInstState() != null) {
            object = pSWFEngineInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getIpAddr() != null) {
            object = pSWFEngineInstBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getLocalRes() != null) {
            object = pSWFEngineInstBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getMemo() != null) {
            object = pSWFEngineInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getParam() != null) {
            object = pSWFEngineInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getParam2() != null) {
            object = pSWFEngineInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getParam3() != null) {
            object = pSWFEngineInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getParam4() != null) {
            object = pSWFEngineInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getParam5() != null) {
            object = pSWFEngineInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getParam6() != null) {
            object = pSWFEngineInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getParam7() != null) {
            object = pSWFEngineInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getParam8() != null) {
            object = pSWFEngineInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getPasswd() != null) {
            object = pSWFEngineInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getPort() != null) {
            object = pSWFEngineInstBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getPSSvrDomainId() != null) {
            object = pSWFEngineInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getPSSvrDomainName() != null) {
            object = pSWFEngineInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getPSWFEngineInstId() != null) {
            object = pSWFEngineInstBase.getPSWFEngineInstId();
            xmlNode.setAttribute(FIELD_PSWFENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getPSWFEngineInstName() != null) {
            object = pSWFEngineInstBase.getPSWFEngineInstName();
            xmlNode.setAttribute(FIELD_PSWFENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getRefInfo() != null) {
            object = pSWFEngineInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getUpdateDate() != null) {
            object = pSWFEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFEngineInstBase.getUpdateMan() != null) {
            object = pSWFEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getUsageMode() != null) {
            object = pSWFEngineInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getUserName() != null) {
            object = pSWFEngineInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineInstBase.getWFEngineType() != null) {
            object = pSWFEngineInstBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFEngineInstBase pSWFEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFEngineInstBase.isConnStrDirty() && (bl || pSWFEngineInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSWFEngineInstBase.getConnStr());
        }
        if (pSWFEngineInstBase.isCreateDateDirty() && (bl || pSWFEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFEngineInstBase.getCreateDate());
        }
        if (pSWFEngineInstBase.isCreateManDirty() && (bl || pSWFEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFEngineInstBase.getCreateMan());
        }
        if (pSWFEngineInstBase.isInstStateDirty() && (bl || pSWFEngineInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSWFEngineInstBase.getInstState());
        }
        if (pSWFEngineInstBase.isIpAddrDirty() && (bl || pSWFEngineInstBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSWFEngineInstBase.getIpAddr());
        }
        if (pSWFEngineInstBase.isLocalResDirty() && (bl || pSWFEngineInstBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSWFEngineInstBase.getLocalRes());
        }
        if (pSWFEngineInstBase.isMemoDirty() && (bl || pSWFEngineInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFEngineInstBase.getMemo());
        }
        if (pSWFEngineInstBase.isParamDirty() && (bl || pSWFEngineInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSWFEngineInstBase.getParam());
        }
        if (pSWFEngineInstBase.isParam2Dirty() && (bl || pSWFEngineInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSWFEngineInstBase.getParam2());
        }
        if (pSWFEngineInstBase.isParam3Dirty() && (bl || pSWFEngineInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSWFEngineInstBase.getParam3());
        }
        if (pSWFEngineInstBase.isParam4Dirty() && (bl || pSWFEngineInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSWFEngineInstBase.getParam4());
        }
        if (pSWFEngineInstBase.isParam5Dirty() && (bl || pSWFEngineInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSWFEngineInstBase.getParam5());
        }
        if (pSWFEngineInstBase.isParam6Dirty() && (bl || pSWFEngineInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSWFEngineInstBase.getParam6());
        }
        if (pSWFEngineInstBase.isParam7Dirty() && (bl || pSWFEngineInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSWFEngineInstBase.getParam7());
        }
        if (pSWFEngineInstBase.isParam8Dirty() && (bl || pSWFEngineInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSWFEngineInstBase.getParam8());
        }
        if (pSWFEngineInstBase.isPasswdDirty() && (bl || pSWFEngineInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSWFEngineInstBase.getPasswd());
        }
        if (pSWFEngineInstBase.isPortDirty() && (bl || pSWFEngineInstBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSWFEngineInstBase.getPort());
        }
        if (pSWFEngineInstBase.isPSSvrDomainIdDirty() && (bl || pSWFEngineInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSWFEngineInstBase.getPSSvrDomainId());
        }
        if (pSWFEngineInstBase.isPSSvrDomainNameDirty() && (bl || pSWFEngineInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSWFEngineInstBase.getPSSvrDomainName());
        }
        if (pSWFEngineInstBase.isPSWFEngineInstIdDirty() && (bl || pSWFEngineInstBase.getPSWFEngineInstId() != null)) {
            iDataObject.set(FIELD_PSWFENGINEINSTID, (Object)pSWFEngineInstBase.getPSWFEngineInstId());
        }
        if (pSWFEngineInstBase.isPSWFEngineInstNameDirty() && (bl || pSWFEngineInstBase.getPSWFEngineInstName() != null)) {
            iDataObject.set(FIELD_PSWFENGINEINSTNAME, (Object)pSWFEngineInstBase.getPSWFEngineInstName());
        }
        if (pSWFEngineInstBase.isRefInfoDirty() && (bl || pSWFEngineInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSWFEngineInstBase.getRefInfo());
        }
        if (pSWFEngineInstBase.isUpdateDateDirty() && (bl || pSWFEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFEngineInstBase.getUpdateDate());
        }
        if (pSWFEngineInstBase.isUpdateManDirty() && (bl || pSWFEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFEngineInstBase.getUpdateMan());
        }
        if (pSWFEngineInstBase.isUsageModeDirty() && (bl || pSWFEngineInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSWFEngineInstBase.getUsageMode());
        }
        if (pSWFEngineInstBase.isUserNameDirty() && (bl || pSWFEngineInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSWFEngineInstBase.getUserName());
        }
        if (pSWFEngineInstBase.isWFEngineTypeDirty() && (bl || pSWFEngineInstBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSWFEngineInstBase.getWFEngineType());
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
        return PSWFEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSWFEngineInstBase pSWFEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFEngineInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSWFEngineInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFEngineInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFEngineInstBase.resetInstState();
                return true;
            }
            case 4: {
                pSWFEngineInstBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSWFEngineInstBase.resetLocalRes();
                return true;
            }
            case 6: {
                pSWFEngineInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSWFEngineInstBase.resetParam();
                return true;
            }
            case 8: {
                pSWFEngineInstBase.resetParam2();
                return true;
            }
            case 9: {
                pSWFEngineInstBase.resetParam3();
                return true;
            }
            case 10: {
                pSWFEngineInstBase.resetParam4();
                return true;
            }
            case 11: {
                pSWFEngineInstBase.resetParam5();
                return true;
            }
            case 12: {
                pSWFEngineInstBase.resetParam6();
                return true;
            }
            case 13: {
                pSWFEngineInstBase.resetParam7();
                return true;
            }
            case 14: {
                pSWFEngineInstBase.resetParam8();
                return true;
            }
            case 15: {
                pSWFEngineInstBase.resetPasswd();
                return true;
            }
            case 16: {
                pSWFEngineInstBase.resetPort();
                return true;
            }
            case 17: {
                pSWFEngineInstBase.resetPSSvrDomainId();
                return true;
            }
            case 18: {
                pSWFEngineInstBase.resetPSSvrDomainName();
                return true;
            }
            case 19: {
                pSWFEngineInstBase.resetPSWFEngineInstId();
                return true;
            }
            case 20: {
                pSWFEngineInstBase.resetPSWFEngineInstName();
                return true;
            }
            case 21: {
                pSWFEngineInstBase.resetRefInfo();
                return true;
            }
            case 22: {
                pSWFEngineInstBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSWFEngineInstBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSWFEngineInstBase.resetUsageMode();
                return true;
            }
            case 25: {
                pSWFEngineInstBase.resetUserName();
                return true;
            }
            case 26: {
                pSWFEngineInstBase.resetWFEngineType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSWFEngineInstBase getProxyEntity() {
        return this.proxyPSWFEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFEngineInstBase) {
            this.proxyPSWFEngineInstBase = (PSWFEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWFEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PARAM, 7);
        fieldIndexMap.put(FIELD_PARAM2, 8);
        fieldIndexMap.put(FIELD_PARAM3, 9);
        fieldIndexMap.put(FIELD_PARAM4, 10);
        fieldIndexMap.put(FIELD_PARAM5, 11);
        fieldIndexMap.put(FIELD_PARAM6, 12);
        fieldIndexMap.put(FIELD_PARAM7, 13);
        fieldIndexMap.put(FIELD_PARAM8, 14);
        fieldIndexMap.put(FIELD_PASSWD, 15);
        fieldIndexMap.put(FIELD_PORT, 16);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 17);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 18);
        fieldIndexMap.put(FIELD_PSWFENGINEINSTID, 19);
        fieldIndexMap.put(FIELD_PSWFENGINEINSTNAME, 20);
        fieldIndexMap.put(FIELD_REFINFO, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USAGEMODE, 24);
        fieldIndexMap.put(FIELD_USERNAME, 25);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 26);
    }
}

