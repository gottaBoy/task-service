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

public abstract class PSBDServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBDServerBase.class);
    public static final String FIELD_BDTYPE = "BDTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSBDSERVERID = "PSBDSERVERID";
    public static final String FIELD_PSBDSERVERNAME = "PSBDSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_BDTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PASSWD = 5;
    private static final int INDEX_PORT = 6;
    private static final int INDEX_PSBDSERVERID = 7;
    private static final int INDEX_PSBDSERVERNAME = 8;
    private static final int INDEX_PSSVRDOMAINID = 9;
    private static final int INDEX_PSSVRDOMAINNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERNAME = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBDServerBase proxyPSBDServerBase = null;
    private boolean bdtypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psbdserveridDirtyFlag = false;
    private boolean psbdservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="bdtype")
    private String bdtype;
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
    @Column(name="psbdserverid")
    private String psbdserverid;
    @Column(name="psbdservername")
    private String psbdservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setBDType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bdtype = string;
        this.bdtypeDirtyFlag = true;
    }

    public String getBDType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDType();
        }
        return this.bdtype;
    }

    public boolean isBDTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTypeDirty();
        }
        return this.bdtypeDirtyFlag;
    }

    public void resetBDType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDType();
            return;
        }
        this.bdtypeDirtyFlag = false;
        this.bdtype = null;
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

    public void setPSBDServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdserverid = string;
        this.psbdserveridDirtyFlag = true;
    }

    public String getPSBDServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDServerId();
        }
        return this.psbdserverid;
    }

    public boolean isPSBDServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDServerIdDirty();
        }
        return this.psbdserveridDirtyFlag;
    }

    public void resetPSBDServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDServerId();
            return;
        }
        this.psbdserveridDirtyFlag = false;
        this.psbdserverid = null;
    }

    public void setPSBDServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdservername = string;
        this.psbdservernameDirtyFlag = true;
    }

    public String getPSBDServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDServerName();
        }
        return this.psbdservername;
    }

    public boolean isPSBDServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDServerNameDirty();
        }
        return this.psbdservernameDirtyFlag;
    }

    public void resetPSBDServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDServerName();
            return;
        }
        this.psbdservernameDirtyFlag = false;
        this.psbdservername = null;
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
        PSBDServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBDServerBase pSBDServerBase) {
        pSBDServerBase.resetBDType();
        pSBDServerBase.resetCreateDate();
        pSBDServerBase.resetCreateMan();
        pSBDServerBase.resetIPAddr();
        pSBDServerBase.resetMemo();
        pSBDServerBase.resetPasswd();
        pSBDServerBase.resetPort();
        pSBDServerBase.resetPSBDServerId();
        pSBDServerBase.resetPSBDServerName();
        pSBDServerBase.resetPSSvrDomainId();
        pSBDServerBase.resetPSSvrDomainName();
        pSBDServerBase.resetUpdateDate();
        pSBDServerBase.resetUpdateMan();
        pSBDServerBase.resetUserName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBDTypeDirty()) {
            hashMap.put(FIELD_BDTYPE, this.getBDType());
        }
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
        if (!bl || this.isPSBDServerIdDirty()) {
            hashMap.put(FIELD_PSBDSERVERID, this.getPSBDServerId());
        }
        if (!bl || this.isPSBDServerNameDirty()) {
            hashMap.put(FIELD_PSBDSERVERNAME, this.getPSBDServerName());
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
        return PSBDServerBase.get(this, n);
    }

    private static Object get(PSBDServerBase pSBDServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDServerBase.getBDType();
            }
            case 1: {
                return pSBDServerBase.getCreateDate();
            }
            case 2: {
                return pSBDServerBase.getCreateMan();
            }
            case 3: {
                return pSBDServerBase.getIPAddr();
            }
            case 4: {
                return pSBDServerBase.getMemo();
            }
            case 5: {
                return pSBDServerBase.getPasswd();
            }
            case 6: {
                return pSBDServerBase.getPort();
            }
            case 7: {
                return pSBDServerBase.getPSBDServerId();
            }
            case 8: {
                return pSBDServerBase.getPSBDServerName();
            }
            case 9: {
                return pSBDServerBase.getPSSvrDomainId();
            }
            case 10: {
                return pSBDServerBase.getPSSvrDomainName();
            }
            case 11: {
                return pSBDServerBase.getUpdateDate();
            }
            case 12: {
                return pSBDServerBase.getUpdateMan();
            }
            case 13: {
                return pSBDServerBase.getUserName();
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
        PSBDServerBase.set(this, n, object);
    }

    private static void set(PSBDServerBase pSBDServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBDServerBase.setBDType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSBDServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSBDServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBDServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSBDServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSBDServerBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBDServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSBDServerBase.setPSBDServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSBDServerBase.setPSBDServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSBDServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSBDServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSBDServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSBDServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSBDServerBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSBDServerBase.isNull(this, n);
    }

    private static boolean isNull(PSBDServerBase pSBDServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDServerBase.getBDType() == null;
            }
            case 1: {
                return pSBDServerBase.getCreateDate() == null;
            }
            case 2: {
                return pSBDServerBase.getCreateMan() == null;
            }
            case 3: {
                return pSBDServerBase.getIPAddr() == null;
            }
            case 4: {
                return pSBDServerBase.getMemo() == null;
            }
            case 5: {
                return pSBDServerBase.getPasswd() == null;
            }
            case 6: {
                return pSBDServerBase.getPort() == null;
            }
            case 7: {
                return pSBDServerBase.getPSBDServerId() == null;
            }
            case 8: {
                return pSBDServerBase.getPSBDServerName() == null;
            }
            case 9: {
                return pSBDServerBase.getPSSvrDomainId() == null;
            }
            case 10: {
                return pSBDServerBase.getPSSvrDomainName() == null;
            }
            case 11: {
                return pSBDServerBase.getUpdateDate() == null;
            }
            case 12: {
                return pSBDServerBase.getUpdateMan() == null;
            }
            case 13: {
                return pSBDServerBase.getUserName() == null;
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
        return PSBDServerBase.contains(this, n);
    }

    private static boolean contains(PSBDServerBase pSBDServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDServerBase.isBDTypeDirty();
            }
            case 1: {
                return pSBDServerBase.isCreateDateDirty();
            }
            case 2: {
                return pSBDServerBase.isCreateManDirty();
            }
            case 3: {
                return pSBDServerBase.isIPAddrDirty();
            }
            case 4: {
                return pSBDServerBase.isMemoDirty();
            }
            case 5: {
                return pSBDServerBase.isPasswdDirty();
            }
            case 6: {
                return pSBDServerBase.isPortDirty();
            }
            case 7: {
                return pSBDServerBase.isPSBDServerIdDirty();
            }
            case 8: {
                return pSBDServerBase.isPSBDServerNameDirty();
            }
            case 9: {
                return pSBDServerBase.isPSSvrDomainIdDirty();
            }
            case 10: {
                return pSBDServerBase.isPSSvrDomainNameDirty();
            }
            case 11: {
                return pSBDServerBase.isUpdateDateDirty();
            }
            case 12: {
                return pSBDServerBase.isUpdateManDirty();
            }
            case 13: {
                return pSBDServerBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBDServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBDServerBase pSBDServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBDServerBase.getBDType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtype", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getBDType()), (boolean)false);
        }
        if (bl || pSBDServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBDServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBDServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSBDServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPasswd()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPort()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPSBDServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdserverid", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPSBDServerId()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPSBDServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdservername", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPSBDServerName()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSBDServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSBDServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBDServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSBDServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSBDServerBase.getJSONValue((Object)pSBDServerBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBDServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBDServerBase pSBDServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBDServerBase.getBDType() != null) {
            object = pSBDServerBase.getBDType();
            xmlNode.setAttribute(FIELD_BDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getCreateDate() != null) {
            object = pSBDServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDServerBase.getCreateMan() != null) {
            object = pSBDServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getIPAddr() != null) {
            object = pSBDServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getMemo() != null) {
            object = pSBDServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getPasswd() != null) {
            object = pSBDServerBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getPort() != null) {
            object = pSBDServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDServerBase.getPSBDServerId() != null) {
            object = pSBDServerBase.getPSBDServerId();
            xmlNode.setAttribute(FIELD_PSBDSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getPSBDServerName() != null) {
            object = pSBDServerBase.getPSBDServerName();
            xmlNode.setAttribute(FIELD_PSBDSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getPSSvrDomainId() != null) {
            object = pSBDServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getPSSvrDomainName() != null) {
            object = pSBDServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getUpdateDate() != null) {
            object = pSBDServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDServerBase.getUpdateMan() != null) {
            object = pSBDServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBDServerBase.getUserName() != null) {
            object = pSBDServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBDServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBDServerBase pSBDServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBDServerBase.isBDTypeDirty() && (bl || pSBDServerBase.getBDType() != null)) {
            iDataObject.set(FIELD_BDTYPE, (Object)pSBDServerBase.getBDType());
        }
        if (pSBDServerBase.isCreateDateDirty() && (bl || pSBDServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBDServerBase.getCreateDate());
        }
        if (pSBDServerBase.isCreateManDirty() && (bl || pSBDServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBDServerBase.getCreateMan());
        }
        if (pSBDServerBase.isIPAddrDirty() && (bl || pSBDServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSBDServerBase.getIPAddr());
        }
        if (pSBDServerBase.isMemoDirty() && (bl || pSBDServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSBDServerBase.getMemo());
        }
        if (pSBDServerBase.isPasswdDirty() && (bl || pSBDServerBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSBDServerBase.getPasswd());
        }
        if (pSBDServerBase.isPortDirty() && (bl || pSBDServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSBDServerBase.getPort());
        }
        if (pSBDServerBase.isPSBDServerIdDirty() && (bl || pSBDServerBase.getPSBDServerId() != null)) {
            iDataObject.set(FIELD_PSBDSERVERID, (Object)pSBDServerBase.getPSBDServerId());
        }
        if (pSBDServerBase.isPSBDServerNameDirty() && (bl || pSBDServerBase.getPSBDServerName() != null)) {
            iDataObject.set(FIELD_PSBDSERVERNAME, (Object)pSBDServerBase.getPSBDServerName());
        }
        if (pSBDServerBase.isPSSvrDomainIdDirty() && (bl || pSBDServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSBDServerBase.getPSSvrDomainId());
        }
        if (pSBDServerBase.isPSSvrDomainNameDirty() && (bl || pSBDServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSBDServerBase.getPSSvrDomainName());
        }
        if (pSBDServerBase.isUpdateDateDirty() && (bl || pSBDServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBDServerBase.getUpdateDate());
        }
        if (pSBDServerBase.isUpdateManDirty() && (bl || pSBDServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBDServerBase.getUpdateMan());
        }
        if (pSBDServerBase.isUserNameDirty() && (bl || pSBDServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSBDServerBase.getUserName());
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
        return PSBDServerBase.remove(this, n);
    }

    private static boolean remove(PSBDServerBase pSBDServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBDServerBase.resetBDType();
                return true;
            }
            case 1: {
                pSBDServerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSBDServerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSBDServerBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSBDServerBase.resetMemo();
                return true;
            }
            case 5: {
                pSBDServerBase.resetPasswd();
                return true;
            }
            case 6: {
                pSBDServerBase.resetPort();
                return true;
            }
            case 7: {
                pSBDServerBase.resetPSBDServerId();
                return true;
            }
            case 8: {
                pSBDServerBase.resetPSBDServerName();
                return true;
            }
            case 9: {
                pSBDServerBase.resetPSSvrDomainId();
                return true;
            }
            case 10: {
                pSBDServerBase.resetPSSvrDomainName();
                return true;
            }
            case 11: {
                pSBDServerBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSBDServerBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSBDServerBase.resetUserName();
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

    private PSBDServerBase getProxyEntity() {
        return this.proxyPSBDServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBDServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSBDServerBase) {
            this.proxyPSBDServerBase = (PSBDServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSBDServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BDTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PASSWD, 5);
        fieldIndexMap.put(FIELD_PORT, 6);
        fieldIndexMap.put(FIELD_PSBDSERVERID, 7);
        fieldIndexMap.put(FIELD_PSBDSERVERNAME, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERNAME, 13);
    }
}

