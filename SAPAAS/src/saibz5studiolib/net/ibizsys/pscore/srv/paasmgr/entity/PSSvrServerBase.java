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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSvrServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSvrServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_LASTHTTPPORT = "LASTHTTPPORT";
    public static final String FIELD_LASTSSHPORT = "LASTSSHPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String FIELD_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String FIELD_TEMPL1ID = "TEMPL1ID";
    public static final String FIELD_TEMPL2ID = "TEMPL2ID";
    public static final String FIELD_TEMPL3ID = "TEMPL3ID";
    public static final String FIELD_TEMPL4ID = "TEMPL4ID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_LASTHTTPPORT = 4;
    private static final int INDEX_LASTSSHPORT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PASSWD = 7;
    private static final int INDEX_PORT = 8;
    private static final int INDEX_PSSVRDOMAINID = 9;
    private static final int INDEX_PSSVRDOMAINNAME = 10;
    private static final int INDEX_PSSVRSERVERID = 11;
    private static final int INDEX_PSSVRSERVERNAME = 12;
    private static final int INDEX_TEMPL1ID = 13;
    private static final int INDEX_TEMPL2ID = 14;
    private static final int INDEX_TEMPL3ID = 15;
    private static final int INDEX_TEMPL4ID = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERNAME = 19;
    private static final int INDEX_WEBCONSOLEPATH = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSvrServerBase proxyPSSvrServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean lasthttpportDirtyFlag = false;
    private boolean lastsshportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssvrserveridDirtyFlag = false;
    private boolean pssvrservernameDirtyFlag = false;
    private boolean templ1idDirtyFlag = false;
    private boolean templ2idDirtyFlag = false;
    private boolean templ3idDirtyFlag = false;
    private boolean templ4idDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean webconsolepathDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="lasthttpport")
    private Integer lasthttpport;
    @Column(name="lastsshport")
    private Integer lastsshport;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pssvrserverid")
    private String pssvrserverid;
    @Column(name="pssvrservername")
    private String pssvrservername;
    @Column(name="templ1id")
    private String templ1id;
    @Column(name="templ2id")
    private String templ2id;
    @Column(name="templ3id")
    private String templ3id;
    @Column(name="templ4id")
    private String templ4id;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    @Column(name="webconsolepath")
    private String webconsolepath;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSAppServersLock = new Integer(1);
    private ArrayList<PSAppServer> psappservers = null;

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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setLastHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastHttpPort(n);
            return;
        }
        this.lasthttpport = n;
        this.lasthttpportDirtyFlag = true;
    }

    public Integer getLastHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastHttpPort();
        }
        return this.lasthttpport;
    }

    public boolean isLastHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastHttpPortDirty();
        }
        return this.lasthttpportDirtyFlag;
    }

    public void resetLastHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastHttpPort();
            return;
        }
        this.lasthttpportDirtyFlag = false;
        this.lasthttpport = null;
    }

    public void setLastSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastSSHPort(n);
            return;
        }
        this.lastsshport = n;
        this.lastsshportDirtyFlag = true;
    }

    public Integer getLastSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastSSHPort();
        }
        return this.lastsshport;
    }

    public boolean isLastSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastSSHPortDirty();
        }
        return this.lastsshportDirtyFlag;
    }

    public void resetLastSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastSSHPort();
            return;
        }
        this.lastsshportDirtyFlag = false;
        this.lastsshport = null;
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

    public void setPSSvrServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrserverid = string;
        this.pssvrserveridDirtyFlag = true;
    }

    public String getPSSvrServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrServerId();
        }
        return this.pssvrserverid;
    }

    public boolean isPSSvrServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrServerIdDirty();
        }
        return this.pssvrserveridDirtyFlag;
    }

    public void resetPSSvrServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrServerId();
            return;
        }
        this.pssvrserveridDirtyFlag = false;
        this.pssvrserverid = null;
    }

    public void setPSSvrServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrservername = string;
        this.pssvrservernameDirtyFlag = true;
    }

    public String getPSSvrServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrServerName();
        }
        return this.pssvrservername;
    }

    public boolean isPSSvrServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrServerNameDirty();
        }
        return this.pssvrservernameDirtyFlag;
    }

    public void resetPSSvrServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrServerName();
            return;
        }
        this.pssvrservernameDirtyFlag = false;
        this.pssvrservername = null;
    }

    public void setTempl1Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempl1Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templ1id = string;
        this.templ1idDirtyFlag = true;
    }

    public String getTempl1Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempl1Id();
        }
        return this.templ1id;
    }

    public boolean isTempl1IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempl1IdDirty();
        }
        return this.templ1idDirtyFlag;
    }

    public void resetTempl1Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempl1Id();
            return;
        }
        this.templ1idDirtyFlag = false;
        this.templ1id = null;
    }

    public void setTempl2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempl2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templ2id = string;
        this.templ2idDirtyFlag = true;
    }

    public String getTempl2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempl2Id();
        }
        return this.templ2id;
    }

    public boolean isTempl2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempl2IdDirty();
        }
        return this.templ2idDirtyFlag;
    }

    public void resetTempl2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempl2Id();
            return;
        }
        this.templ2idDirtyFlag = false;
        this.templ2id = null;
    }

    public void setTempl3Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempl3Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templ3id = string;
        this.templ3idDirtyFlag = true;
    }

    public String getTempl3Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempl3Id();
        }
        return this.templ3id;
    }

    public boolean isTempl3IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempl3IdDirty();
        }
        return this.templ3idDirtyFlag;
    }

    public void resetTempl3Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempl3Id();
            return;
        }
        this.templ3idDirtyFlag = false;
        this.templ3id = null;
    }

    public void setTempl4Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempl4Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templ4id = string;
        this.templ4idDirtyFlag = true;
    }

    public String getTempl4Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempl4Id();
        }
        return this.templ4id;
    }

    public boolean isTempl4IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempl4IdDirty();
        }
        return this.templ4idDirtyFlag;
    }

    public void resetTempl4Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempl4Id();
            return;
        }
        this.templ4idDirtyFlag = false;
        this.templ4id = null;
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

    public void setWebConsolePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebConsolePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.webconsolepath = string;
        this.webconsolepathDirtyFlag = true;
    }

    public String getWebConsolePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebConsolePath();
        }
        return this.webconsolepath;
    }

    public boolean isWebConsolePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebConsolePathDirty();
        }
        return this.webconsolepathDirtyFlag;
    }

    public void resetWebConsolePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebConsolePath();
            return;
        }
        this.webconsolepathDirtyFlag = false;
        this.webconsolepath = null;
    }

    protected void onReset() {
        PSSvrServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSvrServerBase pSSvrServerBase) {
        pSSvrServerBase.resetCreateDate();
        pSSvrServerBase.resetCreateMan();
        pSSvrServerBase.resetEnable();
        pSSvrServerBase.resetIPAddr();
        pSSvrServerBase.resetLastHttpPort();
        pSSvrServerBase.resetLastSSHPort();
        pSSvrServerBase.resetMemo();
        pSSvrServerBase.resetPasswd();
        pSSvrServerBase.resetPort();
        pSSvrServerBase.resetPSSvrDomainId();
        pSSvrServerBase.resetPSSvrDomainName();
        pSSvrServerBase.resetPSSvrServerId();
        pSSvrServerBase.resetPSSvrServerName();
        pSSvrServerBase.resetTempl1Id();
        pSSvrServerBase.resetTempl2Id();
        pSSvrServerBase.resetTempl3Id();
        pSSvrServerBase.resetTempl4Id();
        pSSvrServerBase.resetUpdateDate();
        pSSvrServerBase.resetUpdateMan();
        pSSvrServerBase.resetUserName();
        pSSvrServerBase.resetWebConsolePath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isLastHttpPortDirty()) {
            hashMap.put(FIELD_LASTHTTPPORT, this.getLastHttpPort());
        }
        if (!bl || this.isLastSSHPortDirty()) {
            hashMap.put(FIELD_LASTSSHPORT, this.getLastSSHPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSvrServerIdDirty()) {
            hashMap.put(FIELD_PSSVRSERVERID, this.getPSSvrServerId());
        }
        if (!bl || this.isPSSvrServerNameDirty()) {
            hashMap.put(FIELD_PSSVRSERVERNAME, this.getPSSvrServerName());
        }
        if (!bl || this.isTempl1IdDirty()) {
            hashMap.put(FIELD_TEMPL1ID, this.getTempl1Id());
        }
        if (!bl || this.isTempl2IdDirty()) {
            hashMap.put(FIELD_TEMPL2ID, this.getTempl2Id());
        }
        if (!bl || this.isTempl3IdDirty()) {
            hashMap.put(FIELD_TEMPL3ID, this.getTempl3Id());
        }
        if (!bl || this.isTempl4IdDirty()) {
            hashMap.put(FIELD_TEMPL4ID, this.getTempl4Id());
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
        if (!bl || this.isWebConsolePathDirty()) {
            hashMap.put(FIELD_WEBCONSOLEPATH, this.getWebConsolePath());
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
        return PSSvrServerBase.get(this, n);
    }

    private static Object get(PSSvrServerBase pSSvrServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrServerBase.getCreateDate();
            }
            case 1: {
                return pSSvrServerBase.getCreateMan();
            }
            case 2: {
                return pSSvrServerBase.getEnable();
            }
            case 3: {
                return pSSvrServerBase.getIPAddr();
            }
            case 4: {
                return pSSvrServerBase.getLastHttpPort();
            }
            case 5: {
                return pSSvrServerBase.getLastSSHPort();
            }
            case 6: {
                return pSSvrServerBase.getMemo();
            }
            case 7: {
                return pSSvrServerBase.getPasswd();
            }
            case 8: {
                return pSSvrServerBase.getPort();
            }
            case 9: {
                return pSSvrServerBase.getPSSvrDomainId();
            }
            case 10: {
                return pSSvrServerBase.getPSSvrDomainName();
            }
            case 11: {
                return pSSvrServerBase.getPSSvrServerId();
            }
            case 12: {
                return pSSvrServerBase.getPSSvrServerName();
            }
            case 13: {
                return pSSvrServerBase.getTempl1Id();
            }
            case 14: {
                return pSSvrServerBase.getTempl2Id();
            }
            case 15: {
                return pSSvrServerBase.getTempl3Id();
            }
            case 16: {
                return pSSvrServerBase.getTempl4Id();
            }
            case 17: {
                return pSSvrServerBase.getUpdateDate();
            }
            case 18: {
                return pSSvrServerBase.getUpdateMan();
            }
            case 19: {
                return pSSvrServerBase.getUserName();
            }
            case 20: {
                return pSSvrServerBase.getWebConsolePath();
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
        PSSvrServerBase.set(this, n, object);
    }

    private static void set(PSSvrServerBase pSSvrServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSvrServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSvrServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSvrServerBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSvrServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSvrServerBase.setLastHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSvrServerBase.setLastSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSvrServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSvrServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSvrServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSvrServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSvrServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSvrServerBase.setPSSvrServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSvrServerBase.setPSSvrServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSvrServerBase.setTempl1Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSvrServerBase.setTempl2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSvrServerBase.setTempl3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSvrServerBase.setTempl4Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSvrServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSvrServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSvrServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSvrServerBase.setWebConsolePath(DataObject.getStringValue((Object)object));
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
        return PSSvrServerBase.isNull(this, n);
    }

    private static boolean isNull(PSSvrServerBase pSSvrServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSvrServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSvrServerBase.getEnable() == null;
            }
            case 3: {
                return pSSvrServerBase.getIPAddr() == null;
            }
            case 4: {
                return pSSvrServerBase.getLastHttpPort() == null;
            }
            case 5: {
                return pSSvrServerBase.getLastSSHPort() == null;
            }
            case 6: {
                return pSSvrServerBase.getMemo() == null;
            }
            case 7: {
                return pSSvrServerBase.getPasswd() == null;
            }
            case 8: {
                return pSSvrServerBase.getPort() == null;
            }
            case 9: {
                return pSSvrServerBase.getPSSvrDomainId() == null;
            }
            case 10: {
                return pSSvrServerBase.getPSSvrDomainName() == null;
            }
            case 11: {
                return pSSvrServerBase.getPSSvrServerId() == null;
            }
            case 12: {
                return pSSvrServerBase.getPSSvrServerName() == null;
            }
            case 13: {
                return pSSvrServerBase.getTempl1Id() == null;
            }
            case 14: {
                return pSSvrServerBase.getTempl2Id() == null;
            }
            case 15: {
                return pSSvrServerBase.getTempl3Id() == null;
            }
            case 16: {
                return pSSvrServerBase.getTempl4Id() == null;
            }
            case 17: {
                return pSSvrServerBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSvrServerBase.getUpdateMan() == null;
            }
            case 19: {
                return pSSvrServerBase.getUserName() == null;
            }
            case 20: {
                return pSSvrServerBase.getWebConsolePath() == null;
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
        return PSSvrServerBase.contains(this, n);
    }

    private static boolean contains(PSSvrServerBase pSSvrServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSvrServerBase.isCreateManDirty();
            }
            case 2: {
                return pSSvrServerBase.isEnableDirty();
            }
            case 3: {
                return pSSvrServerBase.isIPAddrDirty();
            }
            case 4: {
                return pSSvrServerBase.isLastHttpPortDirty();
            }
            case 5: {
                return pSSvrServerBase.isLastSSHPortDirty();
            }
            case 6: {
                return pSSvrServerBase.isMemoDirty();
            }
            case 7: {
                return pSSvrServerBase.isPasswdDirty();
            }
            case 8: {
                return pSSvrServerBase.isPortDirty();
            }
            case 9: {
                return pSSvrServerBase.isPSSvrDomainIdDirty();
            }
            case 10: {
                return pSSvrServerBase.isPSSvrDomainNameDirty();
            }
            case 11: {
                return pSSvrServerBase.isPSSvrServerIdDirty();
            }
            case 12: {
                return pSSvrServerBase.isPSSvrServerNameDirty();
            }
            case 13: {
                return pSSvrServerBase.isTempl1IdDirty();
            }
            case 14: {
                return pSSvrServerBase.isTempl2IdDirty();
            }
            case 15: {
                return pSSvrServerBase.isTempl3IdDirty();
            }
            case 16: {
                return pSSvrServerBase.isTempl4IdDirty();
            }
            case 17: {
                return pSSvrServerBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSvrServerBase.isUpdateManDirty();
            }
            case 19: {
                return pSSvrServerBase.isUserNameDirty();
            }
            case 20: {
                return pSSvrServerBase.isWebConsolePathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSvrServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSvrServerBase pSSvrServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSvrServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getEnable()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getLastHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lasthttpport", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getLastHttpPort()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getLastSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastsshport", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getLastSSHPort()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPort()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPSSvrServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrserverid", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPSSvrServerId()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getPSSvrServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrservername", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getPSSvrServerName()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getTempl1Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templ1id", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getTempl1Id()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getTempl2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templ2id", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getTempl2Id()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getTempl3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templ3id", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getTempl3Id()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getTempl4Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templ4id", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getTempl4Id()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSSvrServerBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSSvrServerBase.getJSONValue((Object)pSSvrServerBase.getWebConsolePath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSvrServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSvrServerBase pSSvrServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSvrServerBase.getCreateDate() != null) {
            object = pSSvrServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrServerBase.getCreateMan() != null) {
            object = pSSvrServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getEnable() != null) {
            object = pSSvrServerBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrServerBase.getIPAddr() != null) {
            object = pSSvrServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getLastHttpPort() != null) {
            object = pSSvrServerBase.getLastHttpPort();
            xmlNode.setAttribute(FIELD_LASTHTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrServerBase.getLastSSHPort() != null) {
            object = pSSvrServerBase.getLastSSHPort();
            xmlNode.setAttribute(FIELD_LASTSSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrServerBase.getMemo() != null) {
            object = pSSvrServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getPasswd() != null) {
            object = pSSvrServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getPort() != null) {
            object = pSSvrServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrServerBase.getPSSvrDomainId() != null) {
            object = pSSvrServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getPSSvrDomainName() != null) {
            object = pSSvrServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getPSSvrServerId() != null) {
            object = pSSvrServerBase.getPSSvrServerId();
            xmlNode.setAttribute(FIELD_PSSVRSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getPSSvrServerName() != null) {
            object = pSSvrServerBase.getPSSvrServerName();
            xmlNode.setAttribute(FIELD_PSSVRSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getTempl1Id() != null) {
            object = pSSvrServerBase.getTempl1Id();
            xmlNode.setAttribute(FIELD_TEMPL1ID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getTempl2Id() != null) {
            object = pSSvrServerBase.getTempl2Id();
            xmlNode.setAttribute(FIELD_TEMPL2ID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getTempl3Id() != null) {
            object = pSSvrServerBase.getTempl3Id();
            xmlNode.setAttribute(FIELD_TEMPL3ID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getTempl4Id() != null) {
            object = pSSvrServerBase.getTempl4Id();
            xmlNode.setAttribute(FIELD_TEMPL4ID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getUpdateDate() != null) {
            object = pSSvrServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrServerBase.getUpdateMan() != null) {
            object = pSSvrServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getUserName() != null) {
            object = pSSvrServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSvrServerBase.getWebConsolePath() != null) {
            object = pSSvrServerBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSvrServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSvrServerBase pSSvrServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSvrServerBase.isCreateDateDirty() && (bl || pSSvrServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSvrServerBase.getCreateDate());
        }
        if (pSSvrServerBase.isCreateManDirty() && (bl || pSSvrServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSvrServerBase.getCreateMan());
        }
        if (pSSvrServerBase.isEnableDirty() && (bl || pSSvrServerBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSSvrServerBase.getEnable());
        }
        if (pSSvrServerBase.isIPAddrDirty() && (bl || pSSvrServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSSvrServerBase.getIPAddr());
        }
        if (pSSvrServerBase.isLastHttpPortDirty() && (bl || pSSvrServerBase.getLastHttpPort() != null)) {
            iDataObject.set(FIELD_LASTHTTPPORT, (Object)pSSvrServerBase.getLastHttpPort());
        }
        if (pSSvrServerBase.isLastSSHPortDirty() && (bl || pSSvrServerBase.getLastSSHPort() != null)) {
            iDataObject.set(FIELD_LASTSSHPORT, (Object)pSSvrServerBase.getLastSSHPort());
        }
        if (pSSvrServerBase.isMemoDirty() && (bl || pSSvrServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSvrServerBase.getMemo());
        }
        if (pSSvrServerBase.isPasswdDirty() && (bl || pSSvrServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSvrServerBase.getPasswd());
        }
        if (pSSvrServerBase.isPortDirty() && (bl || pSSvrServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSSvrServerBase.getPort());
        }
        if (pSSvrServerBase.isPSSvrDomainIdDirty() && (bl || pSSvrServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSvrServerBase.getPSSvrDomainId());
        }
        if (pSSvrServerBase.isPSSvrDomainNameDirty() && (bl || pSSvrServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSvrServerBase.getPSSvrDomainName());
        }
        if (pSSvrServerBase.isPSSvrServerIdDirty() && (bl || pSSvrServerBase.getPSSvrServerId() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERID, (Object)pSSvrServerBase.getPSSvrServerId());
        }
        if (pSSvrServerBase.isPSSvrServerNameDirty() && (bl || pSSvrServerBase.getPSSvrServerName() != null)) {
            iDataObject.set(FIELD_PSSVRSERVERNAME, (Object)pSSvrServerBase.getPSSvrServerName());
        }
        if (pSSvrServerBase.isTempl1IdDirty() && (bl || pSSvrServerBase.getTempl1Id() != null)) {
            iDataObject.set(FIELD_TEMPL1ID, (Object)pSSvrServerBase.getTempl1Id());
        }
        if (pSSvrServerBase.isTempl2IdDirty() && (bl || pSSvrServerBase.getTempl2Id() != null)) {
            iDataObject.set(FIELD_TEMPL2ID, (Object)pSSvrServerBase.getTempl2Id());
        }
        if (pSSvrServerBase.isTempl3IdDirty() && (bl || pSSvrServerBase.getTempl3Id() != null)) {
            iDataObject.set(FIELD_TEMPL3ID, (Object)pSSvrServerBase.getTempl3Id());
        }
        if (pSSvrServerBase.isTempl4IdDirty() && (bl || pSSvrServerBase.getTempl4Id() != null)) {
            iDataObject.set(FIELD_TEMPL4ID, (Object)pSSvrServerBase.getTempl4Id());
        }
        if (pSSvrServerBase.isUpdateDateDirty() && (bl || pSSvrServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSvrServerBase.getUpdateDate());
        }
        if (pSSvrServerBase.isUpdateManDirty() && (bl || pSSvrServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSvrServerBase.getUpdateMan());
        }
        if (pSSvrServerBase.isUserNameDirty() && (bl || pSSvrServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSSvrServerBase.getUserName());
        }
        if (pSSvrServerBase.isWebConsolePathDirty() && (bl || pSSvrServerBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSSvrServerBase.getWebConsolePath());
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
        return PSSvrServerBase.remove(this, n);
    }

    private static boolean remove(PSSvrServerBase pSSvrServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSvrServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSvrServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSvrServerBase.resetEnable();
                return true;
            }
            case 3: {
                pSSvrServerBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSSvrServerBase.resetLastHttpPort();
                return true;
            }
            case 5: {
                pSSvrServerBase.resetLastSSHPort();
                return true;
            }
            case 6: {
                pSSvrServerBase.resetMemo();
                return true;
            }
            case 7: {
                pSSvrServerBase.resetPasswd();
                return true;
            }
            case 8: {
                pSSvrServerBase.resetPort();
                return true;
            }
            case 9: {
                pSSvrServerBase.resetPSSvrDomainId();
                return true;
            }
            case 10: {
                pSSvrServerBase.resetPSSvrDomainName();
                return true;
            }
            case 11: {
                pSSvrServerBase.resetPSSvrServerId();
                return true;
            }
            case 12: {
                pSSvrServerBase.resetPSSvrServerName();
                return true;
            }
            case 13: {
                pSSvrServerBase.resetTempl1Id();
                return true;
            }
            case 14: {
                pSSvrServerBase.resetTempl2Id();
                return true;
            }
            case 15: {
                pSSvrServerBase.resetTempl3Id();
                return true;
            }
            case 16: {
                pSSvrServerBase.resetTempl4Id();
                return true;
            }
            case 17: {
                pSSvrServerBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSvrServerBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSSvrServerBase.resetUserName();
                return true;
            }
            case 20: {
                pSSvrServerBase.resetWebConsolePath();
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
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppServer> getPSAppServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServers();
        }
        if (this.getPSSvrServerId() == null) {
            return null;
        }
        PSAppServerService pSAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppServersLock;
        synchronized (n) {
            if (this.psappservers == null) {
                this.psappservers = pSAppServerService.selectByPSSvrServer(this);
            }
            return this.psappservers;
        }
    }

    private PSSvrServerBase getProxyEntity() {
        return this.proxyPSSvrServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSvrServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSvrServerBase) {
            this.proxyPSSvrServerBase = (PSSvrServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_LASTHTTPPORT, 4);
        fieldIndexMap.put(FIELD_LASTSSHPORT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PASSWD, 7);
        fieldIndexMap.put(FIELD_PORT, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 10);
        fieldIndexMap.put(FIELD_PSSVRSERVERID, 11);
        fieldIndexMap.put(FIELD_PSSVRSERVERNAME, 12);
        fieldIndexMap.put(FIELD_TEMPL1ID, 13);
        fieldIndexMap.put(FIELD_TEMPL2ID, 14);
        fieldIndexMap.put(FIELD_TEMPL3ID, 15);
        fieldIndexMap.put(FIELD_TEMPL4ID, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERNAME, 19);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 20);
    }
}

