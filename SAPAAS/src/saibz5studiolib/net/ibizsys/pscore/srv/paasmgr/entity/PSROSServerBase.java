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

public abstract class PSROSServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSROSServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FWTYPE = "FWTYPE";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSROSSERVERID = "PSROSSERVERID";
    public static final String FIELD_PSROSSERVERNAME = "PSROSSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FWTYPE = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PASSWD = 5;
    private static final int INDEX_PORT = 6;
    private static final int INDEX_PSROSSERVERID = 7;
    private static final int INDEX_PSROSSERVERNAME = 8;
    private static final int INDEX_PSSVRDOMAINID = 9;
    private static final int INDEX_PSSVRDOMAINNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERNAME = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSROSServerBase proxyPSROSServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fwtypeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psrosserveridDirtyFlag = false;
    private boolean psrosservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fwtype")
    private String fwtype;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psrosserverid")
    private String psrosserverid;
    @Column(name="psrosservername")
    private String psrosservername;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSvrDomainLock = new Integer(1);
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

    public void setFWType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFWType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fwtype = string;
        this.fwtypeDirtyFlag = true;
    }

    public String getFWType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFWType();
        }
        return this.fwtype;
    }

    public boolean isFWTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFWTypeDirty();
        }
        return this.fwtypeDirtyFlag;
    }

    public void resetFWType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFWType();
            return;
        }
        this.fwtypeDirtyFlag = false;
        this.fwtype = null;
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

    public void setPassWD(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPassWD(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPassWD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPassWD();
        }
        return this.passwd;
    }

    public boolean isPassWDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPassWDDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPassWD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPassWD();
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

    public void setPSROSServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSROSServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrosserverid = string;
        this.psrosserveridDirtyFlag = true;
    }

    public String getPSROSServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServerId();
        }
        return this.psrosserverid;
    }

    public boolean isPSROSServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSROSServerIdDirty();
        }
        return this.psrosserveridDirtyFlag;
    }

    public void resetPSROSServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSROSServerId();
            return;
        }
        this.psrosserveridDirtyFlag = false;
        this.psrosserverid = null;
    }

    public void setPSROSServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSROSServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrosservername = string;
        this.psrosservernameDirtyFlag = true;
    }

    public String getPSROSServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServerName();
        }
        return this.psrosservername;
    }

    public boolean isPSROSServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSROSServerNameDirty();
        }
        return this.psrosservernameDirtyFlag;
    }

    public void resetPSROSServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSROSServerName();
            return;
        }
        this.psrosservernameDirtyFlag = false;
        this.psrosservername = null;
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
        PSROSServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSROSServerBase pSROSServerBase) {
        pSROSServerBase.resetCreateDate();
        pSROSServerBase.resetCreateMan();
        pSROSServerBase.resetFWType();
        pSROSServerBase.resetIPAddr();
        pSROSServerBase.resetMemo();
        pSROSServerBase.resetPassWD();
        pSROSServerBase.resetPort();
        pSROSServerBase.resetPSROSServerId();
        pSROSServerBase.resetPSROSServerName();
        pSROSServerBase.resetPSSvrDomainId();
        pSROSServerBase.resetPSSvrDomainName();
        pSROSServerBase.resetUpdateDate();
        pSROSServerBase.resetUpdateMan();
        pSROSServerBase.resetUserName();
        pSROSServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFWTypeDirty()) {
            hashMap.put(FIELD_FWTYPE, this.getFWType());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPassWDDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPassWD());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSROSServerIdDirty()) {
            hashMap.put(FIELD_PSROSSERVERID, this.getPSROSServerId());
        }
        if (!bl || this.isPSROSServerNameDirty()) {
            hashMap.put(FIELD_PSROSSERVERNAME, this.getPSROSServerName());
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
        return PSROSServerBase.get(this, n);
    }

    private static Object get(PSROSServerBase pSROSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSROSServerBase.getCreateDate();
            }
            case 1: {
                return pSROSServerBase.getCreateMan();
            }
            case 2: {
                return pSROSServerBase.getFWType();
            }
            case 3: {
                return pSROSServerBase.getIPAddr();
            }
            case 4: {
                return pSROSServerBase.getMemo();
            }
            case 5: {
                return pSROSServerBase.getPassWD();
            }
            case 6: {
                return pSROSServerBase.getPort();
            }
            case 7: {
                return pSROSServerBase.getPSROSServerId();
            }
            case 8: {
                return pSROSServerBase.getPSROSServerName();
            }
            case 9: {
                return pSROSServerBase.getPSSvrDomainId();
            }
            case 10: {
                return pSROSServerBase.getPSSvrDomainName();
            }
            case 11: {
                return pSROSServerBase.getUpdateDate();
            }
            case 12: {
                return pSROSServerBase.getUpdateMan();
            }
            case 13: {
                return pSROSServerBase.getUserName();
            }
            case 14: {
                return pSROSServerBase.getValidFlag();
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
        PSROSServerBase.set(this, n, object);
    }

    private static void set(PSROSServerBase pSROSServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSROSServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSROSServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSROSServerBase.setFWType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSROSServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSROSServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSROSServerBase.setPassWD(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSROSServerBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSROSServerBase.setPSROSServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSROSServerBase.setPSROSServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSROSServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSROSServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSROSServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSROSServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSROSServerBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSROSServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSROSServerBase.isNull(this, n);
    }

    private static boolean isNull(PSROSServerBase pSROSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSROSServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSROSServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSROSServerBase.getFWType() == null;
            }
            case 3: {
                return pSROSServerBase.getIPAddr() == null;
            }
            case 4: {
                return pSROSServerBase.getMemo() == null;
            }
            case 5: {
                return pSROSServerBase.getPassWD() == null;
            }
            case 6: {
                return pSROSServerBase.getPort() == null;
            }
            case 7: {
                return pSROSServerBase.getPSROSServerId() == null;
            }
            case 8: {
                return pSROSServerBase.getPSROSServerName() == null;
            }
            case 9: {
                return pSROSServerBase.getPSSvrDomainId() == null;
            }
            case 10: {
                return pSROSServerBase.getPSSvrDomainName() == null;
            }
            case 11: {
                return pSROSServerBase.getUpdateDate() == null;
            }
            case 12: {
                return pSROSServerBase.getUpdateMan() == null;
            }
            case 13: {
                return pSROSServerBase.getUserName() == null;
            }
            case 14: {
                return pSROSServerBase.getValidFlag() == null;
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
        return PSROSServerBase.contains(this, n);
    }

    private static boolean contains(PSROSServerBase pSROSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSROSServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSROSServerBase.isCreateManDirty();
            }
            case 2: {
                return pSROSServerBase.isFWTypeDirty();
            }
            case 3: {
                return pSROSServerBase.isIPAddrDirty();
            }
            case 4: {
                return pSROSServerBase.isMemoDirty();
            }
            case 5: {
                return pSROSServerBase.isPassWDDirty();
            }
            case 6: {
                return pSROSServerBase.isPortDirty();
            }
            case 7: {
                return pSROSServerBase.isPSROSServerIdDirty();
            }
            case 8: {
                return pSROSServerBase.isPSROSServerNameDirty();
            }
            case 9: {
                return pSROSServerBase.isPSSvrDomainIdDirty();
            }
            case 10: {
                return pSROSServerBase.isPSSvrDomainNameDirty();
            }
            case 11: {
                return pSROSServerBase.isUpdateDateDirty();
            }
            case 12: {
                return pSROSServerBase.isUpdateManDirty();
            }
            case 13: {
                return pSROSServerBase.isUserNameDirty();
            }
            case 14: {
                return pSROSServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSROSServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSROSServerBase pSROSServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSROSServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSROSServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSROSServerBase.getFWType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fwtype", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getFWType()), (boolean)false);
        }
        if (bl || pSROSServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSROSServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPassWD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPassWD()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPort()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPSROSServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrosserverid", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPSROSServerId()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPSROSServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrosservername", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPSROSServerName()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSROSServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSROSServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSROSServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSROSServerBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getUserName()), (boolean)false);
        }
        if (bl || pSROSServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSROSServerBase.getJSONValue((Object)pSROSServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSROSServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSROSServerBase pSROSServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSROSServerBase.getCreateDate() != null) {
            object = pSROSServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSROSServerBase.getCreateMan() != null) {
            object = pSROSServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getFWType() != null) {
            object = pSROSServerBase.getFWType();
            xmlNode.setAttribute(FIELD_FWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getIPAddr() != null) {
            object = pSROSServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getMemo() != null) {
            object = pSROSServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getPassWD() != null) {
            object = pSROSServerBase.getPassWD();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getPort() != null) {
            object = pSROSServerBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSROSServerBase.getPSROSServerId() != null) {
            object = pSROSServerBase.getPSROSServerId();
            xmlNode.setAttribute(FIELD_PSROSSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getPSROSServerName() != null) {
            object = pSROSServerBase.getPSROSServerName();
            xmlNode.setAttribute(FIELD_PSROSSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getPSSvrDomainId() != null) {
            object = pSROSServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getPSSvrDomainName() != null) {
            object = pSROSServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getUpdateDate() != null) {
            object = pSROSServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSROSServerBase.getUpdateMan() != null) {
            object = pSROSServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getUserName() != null) {
            object = pSROSServerBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSROSServerBase.getValidFlag() != null) {
            object = pSROSServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSROSServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSROSServerBase pSROSServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSROSServerBase.isCreateDateDirty() && (bl || pSROSServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSROSServerBase.getCreateDate());
        }
        if (pSROSServerBase.isCreateManDirty() && (bl || pSROSServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSROSServerBase.getCreateMan());
        }
        if (pSROSServerBase.isFWTypeDirty() && (bl || pSROSServerBase.getFWType() != null)) {
            iDataObject.set(FIELD_FWTYPE, (Object)pSROSServerBase.getFWType());
        }
        if (pSROSServerBase.isIPAddrDirty() && (bl || pSROSServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSROSServerBase.getIPAddr());
        }
        if (pSROSServerBase.isMemoDirty() && (bl || pSROSServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSROSServerBase.getMemo());
        }
        if (pSROSServerBase.isPassWDDirty() && (bl || pSROSServerBase.getPassWD() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSROSServerBase.getPassWD());
        }
        if (pSROSServerBase.isPortDirty() && (bl || pSROSServerBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSROSServerBase.getPort());
        }
        if (pSROSServerBase.isPSROSServerIdDirty() && (bl || pSROSServerBase.getPSROSServerId() != null)) {
            iDataObject.set(FIELD_PSROSSERVERID, (Object)pSROSServerBase.getPSROSServerId());
        }
        if (pSROSServerBase.isPSROSServerNameDirty() && (bl || pSROSServerBase.getPSROSServerName() != null)) {
            iDataObject.set(FIELD_PSROSSERVERNAME, (Object)pSROSServerBase.getPSROSServerName());
        }
        if (pSROSServerBase.isPSSvrDomainIdDirty() && (bl || pSROSServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSROSServerBase.getPSSvrDomainId());
        }
        if (pSROSServerBase.isPSSvrDomainNameDirty() && (bl || pSROSServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSROSServerBase.getPSSvrDomainName());
        }
        if (pSROSServerBase.isUpdateDateDirty() && (bl || pSROSServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSROSServerBase.getUpdateDate());
        }
        if (pSROSServerBase.isUpdateManDirty() && (bl || pSROSServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSROSServerBase.getUpdateMan());
        }
        if (pSROSServerBase.isUserNameDirty() && (bl || pSROSServerBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSROSServerBase.getUserName());
        }
        if (pSROSServerBase.isValidFlagDirty() && (bl || pSROSServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSROSServerBase.getValidFlag());
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
        return PSROSServerBase.remove(this, n);
    }

    private static boolean remove(PSROSServerBase pSROSServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSROSServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSROSServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSROSServerBase.resetFWType();
                return true;
            }
            case 3: {
                pSROSServerBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSROSServerBase.resetMemo();
                return true;
            }
            case 5: {
                pSROSServerBase.resetPassWD();
                return true;
            }
            case 6: {
                pSROSServerBase.resetPort();
                return true;
            }
            case 7: {
                pSROSServerBase.resetPSROSServerId();
                return true;
            }
            case 8: {
                pSROSServerBase.resetPSROSServerName();
                return true;
            }
            case 9: {
                pSROSServerBase.resetPSSvrDomainId();
                return true;
            }
            case 10: {
                pSROSServerBase.resetPSSvrDomainName();
                return true;
            }
            case 11: {
                pSROSServerBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSROSServerBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSROSServerBase.resetUserName();
                return true;
            }
            case 14: {
                pSROSServerBase.resetValidFlag();
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

    private PSROSServerBase getProxyEntity() {
        return this.proxyPSROSServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSROSServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSROSServerBase) {
            this.proxyPSROSServerBase = (PSROSServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FWTYPE, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PASSWD, 5);
        fieldIndexMap.put(FIELD_PORT, 6);
        fieldIndexMap.put(FIELD_PSROSSERVERID, 7);
        fieldIndexMap.put(FIELD_PSROSSERVERNAME, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERNAME, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

