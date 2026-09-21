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

public abstract class PSMobAppPackServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMobAppPackServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMOBAPPPACKSERVERID = "PSMOBAPPPACKSERVERID";
    public static final String FIELD_PSMOBAPPPACKSERVERNAME = "PSMOBAPPPACKSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IPADDR = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PASSWD = 4;
    private static final int INDEX_PORT = 5;
    private static final int INDEX_PSMOBAPPPACKSERVERID = 6;
    private static final int INDEX_PSMOBAPPPACKSERVERNAME = 7;
    private static final int INDEX_PSSVRDOMAINID = 8;
    private static final int INDEX_PSSVRDOMAINNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_UPLOADFILEMODE = 12;
    private static final int INDEX_UPLOADPATH = 13;
    private static final int INDEX_USERNAME = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMobAppPackServerBase proxyPSMobAppPackServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmobapppackserveridDirtyFlag = false;
    private boolean psmobapppackservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psmobapppackserverid")
    private String psmobapppackserverid;
    @Column(name="psmobapppackservername")
    private String psmobapppackservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSVRDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

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

    public void setPSMobAppPackServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackserverid = string;
        this.psmobapppackserveridDirtyFlag = true;
    }

    public String getPSMobAppPackServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackServerId();
        }
        return this.psmobapppackserverid;
    }

    public boolean isPSMobAppPackServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackServerIdDirty();
        }
        return this.psmobapppackserveridDirtyFlag;
    }

    public void resetPSMobAppPackServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackServerId();
            return;
        }
        this.psmobapppackserveridDirtyFlag = false;
        this.psmobapppackserverid = null;
    }

    public void setPSMobAppPackServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackservername = string;
        this.psmobapppackservernameDirtyFlag = true;
    }

    public String getPSMobAppPackServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackServerName();
        }
        return this.psmobapppackservername;
    }

    public boolean isPSMobAppPackServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackServerNameDirty();
        }
        return this.psmobapppackservernameDirtyFlag;
    }

    public void resetPSMobAppPackServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackServerName();
            return;
        }
        this.psmobapppackservernameDirtyFlag = false;
        this.psmobapppackservername = null;
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

    public void setUploadFileMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadFileMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadfilemode = string;
        this.uploadfilemodeDirtyFlag = true;
    }

    public String getUploadFileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadFileMode();
        }
        return this.uploadfilemode;
    }

    public boolean isUploadFileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadFileModeDirty();
        }
        return this.uploadfilemodeDirtyFlag;
    }

    public void resetUploadFileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadFileMode();
            return;
        }
        this.uploadfilemodeDirtyFlag = false;
        this.uploadfilemode = null;
    }

    public void setUploadPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadpath = string;
        this.uploadpathDirtyFlag = true;
    }

    public String getUploadPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadPath();
        }
        return this.uploadpath;
    }

    public boolean isUploadPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadPathDirty();
        }
        return this.uploadpathDirtyFlag;
    }

    public void resetUploadPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadPath();
            return;
        }
        this.uploadpathDirtyFlag = false;
        this.uploadpath = null;
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
        PSMobAppPackServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMobAppPackServerBase pSMobAppPackServerBase) {
        pSMobAppPackServerBase.resetCreateDate();
        pSMobAppPackServerBase.resetCreateMan();
        pSMobAppPackServerBase.resetIPAddr();
        pSMobAppPackServerBase.resetMemo();
        pSMobAppPackServerBase.resetPasswd();
        pSMobAppPackServerBase.resetPort();
        pSMobAppPackServerBase.resetPSMobAppPackServerId();
        pSMobAppPackServerBase.resetPSMobAppPackServerName();
        pSMobAppPackServerBase.resetPSSvrDomainId();
        pSMobAppPackServerBase.resetPSSvrDomainName();
        pSMobAppPackServerBase.resetUpdateDate();
        pSMobAppPackServerBase.resetUpdateMan();
        pSMobAppPackServerBase.resetUploadFileMode();
        pSMobAppPackServerBase.resetUploadPath();
        pSMobAppPackServerBase.resetUserName();
        pSMobAppPackServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
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
        if (!bl || this.isPSMobAppPackServerIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSERVERID, this.getPSMobAppPackServerId());
        }
        if (!bl || this.isPSMobAppPackServerNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSERVERNAME, this.getPSMobAppPackServerName());
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
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUploadPathDirty()) {
            hashMap.put(FIELD_UPLOADPATH, this.getUploadPath());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSMobAppPackServerBase.get(this, n);
    }

    private static Object get(PSMobAppPackServerBase pSMobAppPackServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackServerBase.getCreateDate();
            }
            case 1: {
                return pSMobAppPackServerBase.getCreateMan();
            }
            case 2: {
                return pSMobAppPackServerBase.getIPAddr();
            }
            case 3: {
                return pSMobAppPackServerBase.getMemo();
            }
            case 4: {
                return pSMobAppPackServerBase.getPasswd();
            }
            case 5: {
                return pSMobAppPackServerBase.getPort();
            }
            case 6: {
                return pSMobAppPackServerBase.getPSMobAppPackServerId();
            }
            case 7: {
                return pSMobAppPackServerBase.getPSMobAppPackServerName();
            }
            case 8: {
                return pSMobAppPackServerBase.getPSSvrDomainId();
            }
            case 9: {
                return pSMobAppPackServerBase.getPSSvrDomainName();
            }
            case 10: {
                return pSMobAppPackServerBase.getUpdateDate();
            }
            case 11: {
                return pSMobAppPackServerBase.getUpdateMan();
            }
            case 12: {
                return pSMobAppPackServerBase.getUploadFileMode();
            }
            case 13: {
                return pSMobAppPackServerBase.getUploadPath();
            }
            case 14: {
                return pSMobAppPackServerBase.getUserName();
            }
            case 15: {
                return pSMobAppPackServerBase.getValidFlag();
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
        PSMobAppPackServerBase.set(this, n, object);
    }

    private static void set(PSMobAppPackServerBase pSMobAppPackServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMobAppPackServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMobAppPackServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMobAppPackServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMobAppPackServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMobAppPackServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSMobAppPackServerBase.setPSMobAppPackServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMobAppPackServerBase.setPSMobAppPackServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMobAppPackServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMobAppPackServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMobAppPackServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSMobAppPackServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMobAppPackServerBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMobAppPackServerBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMobAppPackServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMobAppPackServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMobAppPackServerBase.isNull(this, n);
    }

    private static boolean isNull(PSMobAppPackServerBase pSMobAppPackServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSMobAppPackServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSMobAppPackServerBase.getIPAddr() == null;
            }
            case 3: {
                return pSMobAppPackServerBase.getMemo() == null;
            }
            case 4: {
                return pSMobAppPackServerBase.getPasswd() == null;
            }
            case 5: {
                return pSMobAppPackServerBase.getPort() == null;
            }
            case 6: {
                return pSMobAppPackServerBase.getPSMobAppPackServerId() == null;
            }
            case 7: {
                return pSMobAppPackServerBase.getPSMobAppPackServerName() == null;
            }
            case 8: {
                return pSMobAppPackServerBase.getPSSvrDomainId() == null;
            }
            case 9: {
                return pSMobAppPackServerBase.getPSSvrDomainName() == null;
            }
            case 10: {
                return pSMobAppPackServerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSMobAppPackServerBase.getUpdateMan() == null;
            }
            case 12: {
                return pSMobAppPackServerBase.getUploadFileMode() == null;
            }
            case 13: {
                return pSMobAppPackServerBase.getUploadPath() == null;
            }
            case 14: {
                return pSMobAppPackServerBase.getUserName() == null;
            }
            case 15: {
                return pSMobAppPackServerBase.getValidFlag() == null;
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
        return PSMobAppPackServerBase.contains(this, n);
    }

    private static boolean contains(PSMobAppPackServerBase pSMobAppPackServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSMobAppPackServerBase.isCreateManDirty();
            }
            case 2: {
                return pSMobAppPackServerBase.isIPAddrDirty();
            }
            case 3: {
                return pSMobAppPackServerBase.isMemoDirty();
            }
            case 4: {
                return pSMobAppPackServerBase.isPasswdDirty();
            }
            case 5: {
                return pSMobAppPackServerBase.isPortDirty();
            }
            case 6: {
                return pSMobAppPackServerBase.isPSMobAppPackServerIdDirty();
            }
            case 7: {
                return pSMobAppPackServerBase.isPSMobAppPackServerNameDirty();
            }
            case 8: {
                return pSMobAppPackServerBase.isPSSvrDomainIdDirty();
            }
            case 9: {
                return pSMobAppPackServerBase.isPSSvrDomainNameDirty();
            }
            case 10: {
                return pSMobAppPackServerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSMobAppPackServerBase.isUpdateManDirty();
            }
            case 12: {
                return pSMobAppPackServerBase.isUploadFileModeDirty();
            }
            case 13: {
                return pSMobAppPackServerBase.isUploadPathDirty();
            }
            case 14: {
                return pSMobAppPackServerBase.isUserNameDirty();
            }
            case 15: {
                return pSMobAppPackServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMobAppPackServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMobAppPackServerBase pSMobAppPackServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMobAppPackServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPort()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPSMobAppPackServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackserverid", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPSMobAppPackServerId()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPSMobAppPackServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackservername", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPSMobAppPackServerName()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSMobAppPackServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMobAppPackServerBase.getJSONValue((Object)pSMobAppPackServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMobAppPackServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMobAppPackServerBase pSMobAppPackServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMobAppPackServerBase.getCreateDate() != null) {
            object = pSMobAppPackServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackServerBase.getCreateMan() != null) {
            object = pSMobAppPackServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getIPAddr() != null) {
            object = pSMobAppPackServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getMemo() != null) {
            object = pSMobAppPackServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getPasswd() != null) {
            object = pSMobAppPackServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getPort() != null) {
            object = pSMobAppPackServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMobAppPackServerBase.getPSMobAppPackServerId() != null) {
            object = pSMobAppPackServerBase.getPSMobAppPackServerId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getPSMobAppPackServerName() != null) {
            object = pSMobAppPackServerBase.getPSMobAppPackServerName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getPSSvrDomainId() != null) {
            object = pSMobAppPackServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getPSSvrDomainName() != null) {
            object = pSMobAppPackServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getUpdateDate() != null) {
            object = pSMobAppPackServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackServerBase.getUpdateMan() != null) {
            object = pSMobAppPackServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getUploadFileMode() != null) {
            object = pSMobAppPackServerBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getUploadPath() != null) {
            object = pSMobAppPackServerBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getUserName() != null) {
            object = pSMobAppPackServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackServerBase.getValidFlag() != null) {
            object = pSMobAppPackServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMobAppPackServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMobAppPackServerBase pSMobAppPackServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMobAppPackServerBase.isCreateDateDirty() && (bl || pSMobAppPackServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMobAppPackServerBase.getCreateDate());
        }
        if (pSMobAppPackServerBase.isCreateManDirty() && (bl || pSMobAppPackServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMobAppPackServerBase.getCreateMan());
        }
        if (pSMobAppPackServerBase.isIPAddrDirty() && (bl || pSMobAppPackServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMobAppPackServerBase.getIPAddr());
        }
        if (pSMobAppPackServerBase.isMemoDirty() && (bl || pSMobAppPackServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMobAppPackServerBase.getMemo());
        }
        if (pSMobAppPackServerBase.isPasswdDirty() && (bl || pSMobAppPackServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMobAppPackServerBase.getPasswd());
        }
        if (pSMobAppPackServerBase.isPortDirty() && (bl || pSMobAppPackServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMobAppPackServerBase.getPort());
        }
        if (pSMobAppPackServerBase.isPSMobAppPackServerIdDirty() && (bl || pSMobAppPackServerBase.getPSMobAppPackServerId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSERVERID, (Object)pSMobAppPackServerBase.getPSMobAppPackServerId());
        }
        if (pSMobAppPackServerBase.isPSMobAppPackServerNameDirty() && (bl || pSMobAppPackServerBase.getPSMobAppPackServerName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSERVERNAME, (Object)pSMobAppPackServerBase.getPSMobAppPackServerName());
        }
        if (pSMobAppPackServerBase.isPSSvrDomainIdDirty() && (bl || pSMobAppPackServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSMobAppPackServerBase.getPSSvrDomainId());
        }
        if (pSMobAppPackServerBase.isPSSvrDomainNameDirty() && (bl || pSMobAppPackServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSMobAppPackServerBase.getPSSvrDomainName());
        }
        if (pSMobAppPackServerBase.isUpdateDateDirty() && (bl || pSMobAppPackServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMobAppPackServerBase.getUpdateDate());
        }
        if (pSMobAppPackServerBase.isUpdateManDirty() && (bl || pSMobAppPackServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMobAppPackServerBase.getUpdateMan());
        }
        if (pSMobAppPackServerBase.isUploadFileModeDirty() && (bl || pSMobAppPackServerBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSMobAppPackServerBase.getUploadFileMode());
        }
        if (pSMobAppPackServerBase.isUploadPathDirty() && (bl || pSMobAppPackServerBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSMobAppPackServerBase.getUploadPath());
        }
        if (pSMobAppPackServerBase.isUserNameDirty() && (bl || pSMobAppPackServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMobAppPackServerBase.getUserName());
        }
        if (pSMobAppPackServerBase.isValidFlagDirty() && (bl || pSMobAppPackServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMobAppPackServerBase.getValidFlag());
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
        return PSMobAppPackServerBase.remove(this, n);
    }

    private static boolean remove(PSMobAppPackServerBase pSMobAppPackServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMobAppPackServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMobAppPackServerBase.resetIPAddr();
                return true;
            }
            case 3: {
                pSMobAppPackServerBase.resetMemo();
                return true;
            }
            case 4: {
                pSMobAppPackServerBase.resetPasswd();
                return true;
            }
            case 5: {
                pSMobAppPackServerBase.resetPort();
                return true;
            }
            case 6: {
                pSMobAppPackServerBase.resetPSMobAppPackServerId();
                return true;
            }
            case 7: {
                pSMobAppPackServerBase.resetPSMobAppPackServerName();
                return true;
            }
            case 8: {
                pSMobAppPackServerBase.resetPSSvrDomainId();
                return true;
            }
            case 9: {
                pSMobAppPackServerBase.resetPSSvrDomainName();
                return true;
            }
            case 10: {
                pSMobAppPackServerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSMobAppPackServerBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSMobAppPackServerBase.resetUploadFileMode();
                return true;
            }
            case 13: {
                pSMobAppPackServerBase.resetUploadPath();
                return true;
            }
            case 14: {
                pSMobAppPackServerBase.resetUserName();
                return true;
            }
            case 15: {
                pSMobAppPackServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSVRDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSVRDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSVRDomainLock;
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

    private PSMobAppPackServerBase getProxyEntity() {
        return this.proxyPSMobAppPackServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMobAppPackServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSMobAppPackServerBase) {
            this.proxyPSMobAppPackServerBase = (PSMobAppPackServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IPADDR, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PASSWD, 4);
        fieldIndexMap.put(FIELD_PORT, 5);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSERVERID, 6);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSERVERNAME, 7);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 12);
        fieldIndexMap.put(FIELD_UPLOADPATH, 13);
        fieldIndexMap.put(FIELD_USERNAME, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

