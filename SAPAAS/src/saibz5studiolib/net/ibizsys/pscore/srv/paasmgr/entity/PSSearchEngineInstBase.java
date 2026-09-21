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

public abstract class PSSearchEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSearchEngineInstBase.class);
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
    public static final String FIELD_PSSEARCHENGINEINSTID = "PSSEARCHENGINEINSTID";
    public static final String FIELD_PSSEARCHENGINEINSTNAME = "PSSEARCHENGINEINSTNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SEARCHENGINETYPE = "SEARCHENGINETYPE";
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
    private static final int INDEX_PSSEARCHENGINEINSTID = 17;
    private static final int INDEX_PSSEARCHENGINEINSTNAME = 18;
    private static final int INDEX_PSSVRDOMAINID = 19;
    private static final int INDEX_PSSVRDOMAINNAME = 20;
    private static final int INDEX_REFINFO = 21;
    private static final int INDEX_SEARCHENGINETYPE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USAGEMODE = 25;
    private static final int INDEX_USERNAME = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSearchEngineInstBase proxyPSSearchEngineInstBase = null;
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
    private boolean pssearchengineinstidDirtyFlag = false;
    private boolean pssearchengineinstnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean searchenginetypeDirtyFlag = false;
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
    @Column(name="pssearchengineinstid")
    private String pssearchengineinstid;
    @Column(name="pssearchengineinstname")
    private String pssearchengineinstname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="searchenginetype")
    private String searchenginetype;
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

    public void setPSSearchEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchengineinstid = string;
        this.pssearchengineinstidDirtyFlag = true;
    }

    public String getPSSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineInstId();
        }
        return this.pssearchengineinstid;
    }

    public boolean isPSSearchEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineInstIdDirty();
        }
        return this.pssearchengineinstidDirtyFlag;
    }

    public void resetPSSearchEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineInstId();
            return;
        }
        this.pssearchengineinstidDirtyFlag = false;
        this.pssearchengineinstid = null;
    }

    public void setPSSearchEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchengineinstname = string;
        this.pssearchengineinstnameDirtyFlag = true;
    }

    public String getPSSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineInstName();
        }
        return this.pssearchengineinstname;
    }

    public boolean isPSSearchEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineInstNameDirty();
        }
        return this.pssearchengineinstnameDirtyFlag;
    }

    public void resetPSSearchEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineInstName();
            return;
        }
        this.pssearchengineinstnameDirtyFlag = false;
        this.pssearchengineinstname = null;
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

    public void setSearchEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchenginetype = string;
        this.searchenginetypeDirtyFlag = true;
    }

    public String getSearchEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEngineType();
        }
        return this.searchenginetype;
    }

    public boolean isSearchEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEngineTypeDirty();
        }
        return this.searchenginetypeDirtyFlag;
    }

    public void resetSearchEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEngineType();
            return;
        }
        this.searchenginetypeDirtyFlag = false;
        this.searchenginetype = null;
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
        PSSearchEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSearchEngineInstBase pSSearchEngineInstBase) {
        pSSearchEngineInstBase.resetConnStr();
        pSSearchEngineInstBase.resetCreateDate();
        pSSearchEngineInstBase.resetCreateMan();
        pSSearchEngineInstBase.resetInstState();
        pSSearchEngineInstBase.resetIpAddr();
        pSSearchEngineInstBase.resetLocalRes();
        pSSearchEngineInstBase.resetMemo();
        pSSearchEngineInstBase.resetParam();
        pSSearchEngineInstBase.resetParam2();
        pSSearchEngineInstBase.resetParam3();
        pSSearchEngineInstBase.resetParam4();
        pSSearchEngineInstBase.resetParam5();
        pSSearchEngineInstBase.resetParam6();
        pSSearchEngineInstBase.resetParam7();
        pSSearchEngineInstBase.resetParam8();
        pSSearchEngineInstBase.resetPasswd();
        pSSearchEngineInstBase.resetPort();
        pSSearchEngineInstBase.resetPSSearchEngineInstId();
        pSSearchEngineInstBase.resetPSSearchEngineInstName();
        pSSearchEngineInstBase.resetPSSvrDomainId();
        pSSearchEngineInstBase.resetPSSvrDomainName();
        pSSearchEngineInstBase.resetRefInfo();
        pSSearchEngineInstBase.resetSearchEngineType();
        pSSearchEngineInstBase.resetUpdateDate();
        pSSearchEngineInstBase.resetUpdateMan();
        pSSearchEngineInstBase.resetUsageMode();
        pSSearchEngineInstBase.resetUserName();
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
        if (!bl || this.isPSSearchEngineInstIdDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINEINSTID, this.getPSSearchEngineInstId());
        }
        if (!bl || this.isPSSearchEngineInstNameDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINEINSTNAME, this.getPSSearchEngineInstName());
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
        if (!bl || this.isSearchEngineTypeDirty()) {
            hashMap.put(FIELD_SEARCHENGINETYPE, this.getSearchEngineType());
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
        return PSSearchEngineInstBase.get(this, n);
    }

    private static Object get(PSSearchEngineInstBase pSSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineInstBase.getConnStr();
            }
            case 1: {
                return pSSearchEngineInstBase.getCreateDate();
            }
            case 2: {
                return pSSearchEngineInstBase.getCreateMan();
            }
            case 3: {
                return pSSearchEngineInstBase.getInstState();
            }
            case 4: {
                return pSSearchEngineInstBase.getIpAddr();
            }
            case 5: {
                return pSSearchEngineInstBase.getLocalRes();
            }
            case 6: {
                return pSSearchEngineInstBase.getMemo();
            }
            case 7: {
                return pSSearchEngineInstBase.getParam();
            }
            case 8: {
                return pSSearchEngineInstBase.getParam2();
            }
            case 9: {
                return pSSearchEngineInstBase.getParam3();
            }
            case 10: {
                return pSSearchEngineInstBase.getParam4();
            }
            case 11: {
                return pSSearchEngineInstBase.getParam5();
            }
            case 12: {
                return pSSearchEngineInstBase.getParam6();
            }
            case 13: {
                return pSSearchEngineInstBase.getParam7();
            }
            case 14: {
                return pSSearchEngineInstBase.getParam8();
            }
            case 15: {
                return pSSearchEngineInstBase.getPasswd();
            }
            case 16: {
                return pSSearchEngineInstBase.getPort();
            }
            case 17: {
                return pSSearchEngineInstBase.getPSSearchEngineInstId();
            }
            case 18: {
                return pSSearchEngineInstBase.getPSSearchEngineInstName();
            }
            case 19: {
                return pSSearchEngineInstBase.getPSSvrDomainId();
            }
            case 20: {
                return pSSearchEngineInstBase.getPSSvrDomainName();
            }
            case 21: {
                return pSSearchEngineInstBase.getRefInfo();
            }
            case 22: {
                return pSSearchEngineInstBase.getSearchEngineType();
            }
            case 23: {
                return pSSearchEngineInstBase.getUpdateDate();
            }
            case 24: {
                return pSSearchEngineInstBase.getUpdateMan();
            }
            case 25: {
                return pSSearchEngineInstBase.getUsageMode();
            }
            case 26: {
                return pSSearchEngineInstBase.getUserName();
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
        PSSearchEngineInstBase.set(this, n, object);
    }

    private static void set(PSSearchEngineInstBase pSSearchEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSearchEngineInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSearchEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSearchEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSearchEngineInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSearchEngineInstBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSearchEngineInstBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSearchEngineInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSearchEngineInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSearchEngineInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSearchEngineInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSearchEngineInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSearchEngineInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSearchEngineInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSearchEngineInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSearchEngineInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSearchEngineInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSearchEngineInstBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSearchEngineInstBase.setPSSearchEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSearchEngineInstBase.setPSSearchEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSearchEngineInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSearchEngineInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSearchEngineInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSearchEngineInstBase.setSearchEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSearchEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSearchEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSearchEngineInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSearchEngineInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSSearchEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSSearchEngineInstBase pSSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineInstBase.getConnStr() == null;
            }
            case 1: {
                return pSSearchEngineInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSSearchEngineInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSSearchEngineInstBase.getInstState() == null;
            }
            case 4: {
                return pSSearchEngineInstBase.getIpAddr() == null;
            }
            case 5: {
                return pSSearchEngineInstBase.getLocalRes() == null;
            }
            case 6: {
                return pSSearchEngineInstBase.getMemo() == null;
            }
            case 7: {
                return pSSearchEngineInstBase.getParam() == null;
            }
            case 8: {
                return pSSearchEngineInstBase.getParam2() == null;
            }
            case 9: {
                return pSSearchEngineInstBase.getParam3() == null;
            }
            case 10: {
                return pSSearchEngineInstBase.getParam4() == null;
            }
            case 11: {
                return pSSearchEngineInstBase.getParam5() == null;
            }
            case 12: {
                return pSSearchEngineInstBase.getParam6() == null;
            }
            case 13: {
                return pSSearchEngineInstBase.getParam7() == null;
            }
            case 14: {
                return pSSearchEngineInstBase.getParam8() == null;
            }
            case 15: {
                return pSSearchEngineInstBase.getPasswd() == null;
            }
            case 16: {
                return pSSearchEngineInstBase.getPort() == null;
            }
            case 17: {
                return pSSearchEngineInstBase.getPSSearchEngineInstId() == null;
            }
            case 18: {
                return pSSearchEngineInstBase.getPSSearchEngineInstName() == null;
            }
            case 19: {
                return pSSearchEngineInstBase.getPSSvrDomainId() == null;
            }
            case 20: {
                return pSSearchEngineInstBase.getPSSvrDomainName() == null;
            }
            case 21: {
                return pSSearchEngineInstBase.getRefInfo() == null;
            }
            case 22: {
                return pSSearchEngineInstBase.getSearchEngineType() == null;
            }
            case 23: {
                return pSSearchEngineInstBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSearchEngineInstBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSearchEngineInstBase.getUsageMode() == null;
            }
            case 26: {
                return pSSearchEngineInstBase.getUserName() == null;
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
        return PSSearchEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSSearchEngineInstBase pSSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineInstBase.isConnStrDirty();
            }
            case 1: {
                return pSSearchEngineInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSSearchEngineInstBase.isCreateManDirty();
            }
            case 3: {
                return pSSearchEngineInstBase.isInstStateDirty();
            }
            case 4: {
                return pSSearchEngineInstBase.isIpAddrDirty();
            }
            case 5: {
                return pSSearchEngineInstBase.isLocalResDirty();
            }
            case 6: {
                return pSSearchEngineInstBase.isMemoDirty();
            }
            case 7: {
                return pSSearchEngineInstBase.isParamDirty();
            }
            case 8: {
                return pSSearchEngineInstBase.isParam2Dirty();
            }
            case 9: {
                return pSSearchEngineInstBase.isParam3Dirty();
            }
            case 10: {
                return pSSearchEngineInstBase.isParam4Dirty();
            }
            case 11: {
                return pSSearchEngineInstBase.isParam5Dirty();
            }
            case 12: {
                return pSSearchEngineInstBase.isParam6Dirty();
            }
            case 13: {
                return pSSearchEngineInstBase.isParam7Dirty();
            }
            case 14: {
                return pSSearchEngineInstBase.isParam8Dirty();
            }
            case 15: {
                return pSSearchEngineInstBase.isPasswdDirty();
            }
            case 16: {
                return pSSearchEngineInstBase.isPortDirty();
            }
            case 17: {
                return pSSearchEngineInstBase.isPSSearchEngineInstIdDirty();
            }
            case 18: {
                return pSSearchEngineInstBase.isPSSearchEngineInstNameDirty();
            }
            case 19: {
                return pSSearchEngineInstBase.isPSSvrDomainIdDirty();
            }
            case 20: {
                return pSSearchEngineInstBase.isPSSvrDomainNameDirty();
            }
            case 21: {
                return pSSearchEngineInstBase.isRefInfoDirty();
            }
            case 22: {
                return pSSearchEngineInstBase.isSearchEngineTypeDirty();
            }
            case 23: {
                return pSSearchEngineInstBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSearchEngineInstBase.isUpdateManDirty();
            }
            case 25: {
                return pSSearchEngineInstBase.isUsageModeDirty();
            }
            case 26: {
                return pSSearchEngineInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSearchEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSearchEngineInstBase pSSearchEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSearchEngineInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPort()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPSSearchEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchengineinstid", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPSSearchEngineInstId()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPSSearchEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchengineinstname", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPSSearchEngineInstName()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getSearchEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchenginetype", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getSearchEngineType()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSSearchEngineInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSSearchEngineInstBase.getJSONValue((Object)pSSearchEngineInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSearchEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSearchEngineInstBase pSSearchEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSearchEngineInstBase.getConnStr() != null) {
            object = pSSearchEngineInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getCreateDate() != null) {
            object = pSSearchEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getCreateMan() != null) {
            object = pSSearchEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getInstState() != null) {
            object = pSSearchEngineInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getIpAddr() != null) {
            object = pSSearchEngineInstBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getLocalRes() != null) {
            object = pSSearchEngineInstBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getMemo() != null) {
            object = pSSearchEngineInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getParam() != null) {
            object = pSSearchEngineInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getParam2() != null) {
            object = pSSearchEngineInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getParam3() != null) {
            object = pSSearchEngineInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getParam4() != null) {
            object = pSSearchEngineInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getParam5() != null) {
            object = pSSearchEngineInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getParam6() != null) {
            object = pSSearchEngineInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getParam7() != null) {
            object = pSSearchEngineInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getParam8() != null) {
            object = pSSearchEngineInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getPasswd() != null) {
            object = pSSearchEngineInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getPort() != null) {
            object = pSSearchEngineInstBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getPSSearchEngineInstId() != null) {
            object = pSSearchEngineInstBase.getPSSearchEngineInstId();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getPSSearchEngineInstName() != null) {
            object = pSSearchEngineInstBase.getPSSearchEngineInstName();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getPSSvrDomainId() != null) {
            object = pSSearchEngineInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getPSSvrDomainName() != null) {
            object = pSSearchEngineInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getRefInfo() != null) {
            object = pSSearchEngineInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getSearchEngineType() != null) {
            object = pSSearchEngineInstBase.getSearchEngineType();
            xmlNode.setAttribute(FIELD_SEARCHENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getUpdateDate() != null) {
            object = pSSearchEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSearchEngineInstBase.getUpdateMan() != null) {
            object = pSSearchEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getUsageMode() != null) {
            object = pSSearchEngineInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineInstBase.getUserName() != null) {
            object = pSSearchEngineInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSearchEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSearchEngineInstBase pSSearchEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSearchEngineInstBase.isConnStrDirty() && (bl || pSSearchEngineInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSSearchEngineInstBase.getConnStr());
        }
        if (pSSearchEngineInstBase.isCreateDateDirty() && (bl || pSSearchEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSearchEngineInstBase.getCreateDate());
        }
        if (pSSearchEngineInstBase.isCreateManDirty() && (bl || pSSearchEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSearchEngineInstBase.getCreateMan());
        }
        if (pSSearchEngineInstBase.isInstStateDirty() && (bl || pSSearchEngineInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSSearchEngineInstBase.getInstState());
        }
        if (pSSearchEngineInstBase.isIpAddrDirty() && (bl || pSSearchEngineInstBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSSearchEngineInstBase.getIpAddr());
        }
        if (pSSearchEngineInstBase.isLocalResDirty() && (bl || pSSearchEngineInstBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSSearchEngineInstBase.getLocalRes());
        }
        if (pSSearchEngineInstBase.isMemoDirty() && (bl || pSSearchEngineInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSearchEngineInstBase.getMemo());
        }
        if (pSSearchEngineInstBase.isParamDirty() && (bl || pSSearchEngineInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSSearchEngineInstBase.getParam());
        }
        if (pSSearchEngineInstBase.isParam2Dirty() && (bl || pSSearchEngineInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSSearchEngineInstBase.getParam2());
        }
        if (pSSearchEngineInstBase.isParam3Dirty() && (bl || pSSearchEngineInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSSearchEngineInstBase.getParam3());
        }
        if (pSSearchEngineInstBase.isParam4Dirty() && (bl || pSSearchEngineInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSSearchEngineInstBase.getParam4());
        }
        if (pSSearchEngineInstBase.isParam5Dirty() && (bl || pSSearchEngineInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSSearchEngineInstBase.getParam5());
        }
        if (pSSearchEngineInstBase.isParam6Dirty() && (bl || pSSearchEngineInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSSearchEngineInstBase.getParam6());
        }
        if (pSSearchEngineInstBase.isParam7Dirty() && (bl || pSSearchEngineInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSSearchEngineInstBase.getParam7());
        }
        if (pSSearchEngineInstBase.isParam8Dirty() && (bl || pSSearchEngineInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSSearchEngineInstBase.getParam8());
        }
        if (pSSearchEngineInstBase.isPasswdDirty() && (bl || pSSearchEngineInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSearchEngineInstBase.getPasswd());
        }
        if (pSSearchEngineInstBase.isPortDirty() && (bl || pSSearchEngineInstBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSSearchEngineInstBase.getPort());
        }
        if (pSSearchEngineInstBase.isPSSearchEngineInstIdDirty() && (bl || pSSearchEngineInstBase.getPSSearchEngineInstId() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINEINSTID, (Object)pSSearchEngineInstBase.getPSSearchEngineInstId());
        }
        if (pSSearchEngineInstBase.isPSSearchEngineInstNameDirty() && (bl || pSSearchEngineInstBase.getPSSearchEngineInstName() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINEINSTNAME, (Object)pSSearchEngineInstBase.getPSSearchEngineInstName());
        }
        if (pSSearchEngineInstBase.isPSSvrDomainIdDirty() && (bl || pSSearchEngineInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSearchEngineInstBase.getPSSvrDomainId());
        }
        if (pSSearchEngineInstBase.isPSSvrDomainNameDirty() && (bl || pSSearchEngineInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSearchEngineInstBase.getPSSvrDomainName());
        }
        if (pSSearchEngineInstBase.isRefInfoDirty() && (bl || pSSearchEngineInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSSearchEngineInstBase.getRefInfo());
        }
        if (pSSearchEngineInstBase.isSearchEngineTypeDirty() && (bl || pSSearchEngineInstBase.getSearchEngineType() != null)) {
            iDataObject.set(FIELD_SEARCHENGINETYPE, (Object)pSSearchEngineInstBase.getSearchEngineType());
        }
        if (pSSearchEngineInstBase.isUpdateDateDirty() && (bl || pSSearchEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSearchEngineInstBase.getUpdateDate());
        }
        if (pSSearchEngineInstBase.isUpdateManDirty() && (bl || pSSearchEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSearchEngineInstBase.getUpdateMan());
        }
        if (pSSearchEngineInstBase.isUsageModeDirty() && (bl || pSSearchEngineInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSSearchEngineInstBase.getUsageMode());
        }
        if (pSSearchEngineInstBase.isUserNameDirty() && (bl || pSSearchEngineInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSSearchEngineInstBase.getUserName());
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
        return PSSearchEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSSearchEngineInstBase pSSearchEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSearchEngineInstBase.resetConnStr();
                return true;
            }
            case 1: {
                pSSearchEngineInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSearchEngineInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSearchEngineInstBase.resetInstState();
                return true;
            }
            case 4: {
                pSSearchEngineInstBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSSearchEngineInstBase.resetLocalRes();
                return true;
            }
            case 6: {
                pSSearchEngineInstBase.resetMemo();
                return true;
            }
            case 7: {
                pSSearchEngineInstBase.resetParam();
                return true;
            }
            case 8: {
                pSSearchEngineInstBase.resetParam2();
                return true;
            }
            case 9: {
                pSSearchEngineInstBase.resetParam3();
                return true;
            }
            case 10: {
                pSSearchEngineInstBase.resetParam4();
                return true;
            }
            case 11: {
                pSSearchEngineInstBase.resetParam5();
                return true;
            }
            case 12: {
                pSSearchEngineInstBase.resetParam6();
                return true;
            }
            case 13: {
                pSSearchEngineInstBase.resetParam7();
                return true;
            }
            case 14: {
                pSSearchEngineInstBase.resetParam8();
                return true;
            }
            case 15: {
                pSSearchEngineInstBase.resetPasswd();
                return true;
            }
            case 16: {
                pSSearchEngineInstBase.resetPort();
                return true;
            }
            case 17: {
                pSSearchEngineInstBase.resetPSSearchEngineInstId();
                return true;
            }
            case 18: {
                pSSearchEngineInstBase.resetPSSearchEngineInstName();
                return true;
            }
            case 19: {
                pSSearchEngineInstBase.resetPSSvrDomainId();
                return true;
            }
            case 20: {
                pSSearchEngineInstBase.resetPSSvrDomainName();
                return true;
            }
            case 21: {
                pSSearchEngineInstBase.resetRefInfo();
                return true;
            }
            case 22: {
                pSSearchEngineInstBase.resetSearchEngineType();
                return true;
            }
            case 23: {
                pSSearchEngineInstBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSearchEngineInstBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSearchEngineInstBase.resetUsageMode();
                return true;
            }
            case 26: {
                pSSearchEngineInstBase.resetUserName();
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

    private PSSearchEngineInstBase getProxyEntity() {
        return this.proxyPSSearchEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSearchEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSSearchEngineInstBase) {
            this.proxyPSSearchEngineInstBase = (PSSearchEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSearchEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSSEARCHENGINEINSTID, 17);
        fieldIndexMap.put(FIELD_PSSEARCHENGINEINSTNAME, 18);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 19);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 20);
        fieldIndexMap.put(FIELD_REFINFO, 21);
        fieldIndexMap.put(FIELD_SEARCHENGINETYPE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USAGEMODE, 25);
        fieldIndexMap.put(FIELD_USERNAME, 26);
    }
}

