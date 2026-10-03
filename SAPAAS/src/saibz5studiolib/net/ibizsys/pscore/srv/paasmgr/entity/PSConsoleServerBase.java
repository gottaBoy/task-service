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

public abstract class PSConsoleServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSConsoleServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSTATE = "CSSTATE";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPPORT = "IPPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCONSOLESERVERID = "PSCONSOLESERVERID";
    public static final String FIELD_PSCONSOLESERVERNAME = "PSCONSOLESERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CSSTATE = 2;
    private static final int INDEX_HTTPADDRESS = 3;
    private static final int INDEX_HTTPPORT = 4;
    private static final int INDEX_IPADDR = 5;
    private static final int INDEX_IPPORT = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSCONSOLESERVERID = 8;
    private static final int INDEX_PSCONSOLESERVERNAME = 9;
    private static final int INDEX_PSSVRDOMAINID = 10;
    private static final int INDEX_PSSVRDOMAINNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSConsoleServerBase proxyPSConsoleServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csstateDirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psconsoleserveridDirtyFlag = false;
    private boolean psconsoleservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="csstate")
    private Integer csstate;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipport")
    private Integer ipport;
    @Column(name="memo")
    private String memo;
    @Column(name="psconsoleserverid")
    private String psconsoleserverid;
    @Column(name="psconsoleservername")
    private String psconsoleservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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

    public void setCSState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSState(n);
            return;
        }
        this.csstate = n;
        this.csstateDirtyFlag = true;
    }

    public Integer getCSState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSState();
        }
        return this.csstate;
    }

    public boolean isCSStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSStateDirty();
        }
        return this.csstateDirtyFlag;
    }

    public void resetCSState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSState();
            return;
        }
        this.csstateDirtyFlag = false;
        this.csstate = null;
    }

    public void setHttpAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpaddress = string;
        this.httpaddressDirtyFlag = true;
    }

    public String getHttpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpAddress();
        }
        return this.httpaddress;
    }

    public boolean isHttpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpAddressDirty();
        }
        return this.httpaddressDirtyFlag;
    }

    public void resetHttpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpAddress();
            return;
        }
        this.httpaddressDirtyFlag = false;
        this.httpaddress = null;
    }

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
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

    public void setIPPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPPort(n);
            return;
        }
        this.ipport = n;
        this.ipportDirtyFlag = true;
    }

    public Integer getIPPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPPort();
        }
        return this.ipport;
    }

    public boolean isIPPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPPortDirty();
        }
        return this.ipportDirtyFlag;
    }

    public void resetIPPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPPort();
            return;
        }
        this.ipportDirtyFlag = false;
        this.ipport = null;
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

    public void setPSConsoleServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSConsoleServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psconsoleserverid = string;
        this.psconsoleserveridDirtyFlag = true;
    }

    public String getPSConsoleServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSConsoleServerId();
        }
        return this.psconsoleserverid;
    }

    public boolean isPSConsoleServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSConsoleServerIdDirty();
        }
        return this.psconsoleserveridDirtyFlag;
    }

    public void resetPSConsoleServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSConsoleServerId();
            return;
        }
        this.psconsoleserveridDirtyFlag = false;
        this.psconsoleserverid = null;
    }

    public void setPSConsoleServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSConsoleServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psconsoleservername = string;
        this.psconsoleservernameDirtyFlag = true;
    }

    public String getPSConsoleServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSConsoleServerName();
        }
        return this.psconsoleservername;
    }

    public boolean isPSConsoleServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSConsoleServerNameDirty();
        }
        return this.psconsoleservernameDirtyFlag;
    }

    public void resetPSConsoleServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSConsoleServerName();
            return;
        }
        this.psconsoleservernameDirtyFlag = false;
        this.psconsoleservername = null;
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

    protected void onReset() {
        PSConsoleServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSConsoleServerBase pSConsoleServerBase) {
        pSConsoleServerBase.resetCreateDate();
        pSConsoleServerBase.resetCreateMan();
        pSConsoleServerBase.resetCSState();
        pSConsoleServerBase.resetHttpAddress();
        pSConsoleServerBase.resetHttpPort();
        pSConsoleServerBase.resetIpAddr();
        pSConsoleServerBase.resetIPPort();
        pSConsoleServerBase.resetMemo();
        pSConsoleServerBase.resetPSConsoleServerId();
        pSConsoleServerBase.resetPSConsoleServerName();
        pSConsoleServerBase.resetPSSvrDomainId();
        pSConsoleServerBase.resetPSSvrDomainName();
        pSConsoleServerBase.resetUpdateDate();
        pSConsoleServerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSStateDirty()) {
            hashMap.put(FIELD_CSSTATE, this.getCSState());
        }
        if (!bl || this.isHttpAddressDirty()) {
            hashMap.put(FIELD_HTTPADDRESS, this.getHttpAddress());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIPPortDirty()) {
            hashMap.put(FIELD_IPPORT, this.getIPPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSConsoleServerIdDirty()) {
            hashMap.put(FIELD_PSCONSOLESERVERID, this.getPSConsoleServerId());
        }
        if (!bl || this.isPSConsoleServerNameDirty()) {
            hashMap.put(FIELD_PSCONSOLESERVERNAME, this.getPSConsoleServerName());
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
        return PSConsoleServerBase.get(this, n);
    }

    private static Object get(PSConsoleServerBase pSConsoleServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSConsoleServerBase.getCreateDate();
            }
            case 1: {
                return pSConsoleServerBase.getCreateMan();
            }
            case 2: {
                return pSConsoleServerBase.getCSState();
            }
            case 3: {
                return pSConsoleServerBase.getHttpAddress();
            }
            case 4: {
                return pSConsoleServerBase.getHttpPort();
            }
            case 5: {
                return pSConsoleServerBase.getIpAddr();
            }
            case 6: {
                return pSConsoleServerBase.getIPPort();
            }
            case 7: {
                return pSConsoleServerBase.getMemo();
            }
            case 8: {
                return pSConsoleServerBase.getPSConsoleServerId();
            }
            case 9: {
                return pSConsoleServerBase.getPSConsoleServerName();
            }
            case 10: {
                return pSConsoleServerBase.getPSSvrDomainId();
            }
            case 11: {
                return pSConsoleServerBase.getPSSvrDomainName();
            }
            case 12: {
                return pSConsoleServerBase.getUpdateDate();
            }
            case 13: {
                return pSConsoleServerBase.getUpdateMan();
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
        PSConsoleServerBase.set(this, n, object);
    }

    private static void set(PSConsoleServerBase pSConsoleServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSConsoleServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSConsoleServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSConsoleServerBase.setCSState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSConsoleServerBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSConsoleServerBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSConsoleServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSConsoleServerBase.setIPPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSConsoleServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSConsoleServerBase.setPSConsoleServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSConsoleServerBase.setPSConsoleServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSConsoleServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSConsoleServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSConsoleServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSConsoleServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSConsoleServerBase.isNull(this, n);
    }

    private static boolean isNull(PSConsoleServerBase pSConsoleServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSConsoleServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSConsoleServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSConsoleServerBase.getCSState() == null;
            }
            case 3: {
                return pSConsoleServerBase.getHttpAddress() == null;
            }
            case 4: {
                return pSConsoleServerBase.getHttpPort() == null;
            }
            case 5: {
                return pSConsoleServerBase.getIpAddr() == null;
            }
            case 6: {
                return pSConsoleServerBase.getIPPort() == null;
            }
            case 7: {
                return pSConsoleServerBase.getMemo() == null;
            }
            case 8: {
                return pSConsoleServerBase.getPSConsoleServerId() == null;
            }
            case 9: {
                return pSConsoleServerBase.getPSConsoleServerName() == null;
            }
            case 10: {
                return pSConsoleServerBase.getPSSvrDomainId() == null;
            }
            case 11: {
                return pSConsoleServerBase.getPSSvrDomainName() == null;
            }
            case 12: {
                return pSConsoleServerBase.getUpdateDate() == null;
            }
            case 13: {
                return pSConsoleServerBase.getUpdateMan() == null;
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
        return PSConsoleServerBase.contains(this, n);
    }

    private static boolean contains(PSConsoleServerBase pSConsoleServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSConsoleServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSConsoleServerBase.isCreateManDirty();
            }
            case 2: {
                return pSConsoleServerBase.isCSStateDirty();
            }
            case 3: {
                return pSConsoleServerBase.isHttpAddressDirty();
            }
            case 4: {
                return pSConsoleServerBase.isHttpPortDirty();
            }
            case 5: {
                return pSConsoleServerBase.isIpAddrDirty();
            }
            case 6: {
                return pSConsoleServerBase.isIPPortDirty();
            }
            case 7: {
                return pSConsoleServerBase.isMemoDirty();
            }
            case 8: {
                return pSConsoleServerBase.isPSConsoleServerIdDirty();
            }
            case 9: {
                return pSConsoleServerBase.isPSConsoleServerNameDirty();
            }
            case 10: {
                return pSConsoleServerBase.isPSSvrDomainIdDirty();
            }
            case 11: {
                return pSConsoleServerBase.isPSSvrDomainNameDirty();
            }
            case 12: {
                return pSConsoleServerBase.isUpdateDateDirty();
            }
            case 13: {
                return pSConsoleServerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSConsoleServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSConsoleServerBase pSConsoleServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSConsoleServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getCSState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csstate", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getCSState()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getIPPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipport", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getIPPort()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getPSConsoleServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psconsoleserverid", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getPSConsoleServerId()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getPSConsoleServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psconsoleservername", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getPSConsoleServerName()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSConsoleServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSConsoleServerBase.getJSONValue((Object)pSConsoleServerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSConsoleServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSConsoleServerBase pSConsoleServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSConsoleServerBase.getCreateDate() != null) {
            object = pSConsoleServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSConsoleServerBase.getCreateMan() != null) {
            object = pSConsoleServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getCSState() != null) {
            object = pSConsoleServerBase.getCSState();
            xmlNode.setAttribute(FIELD_CSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSConsoleServerBase.getHttpAddress() != null) {
            object = pSConsoleServerBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getHttpPort() != null) {
            object = pSConsoleServerBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSConsoleServerBase.getIpAddr() != null) {
            object = pSConsoleServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getIPPort() != null) {
            object = pSConsoleServerBase.getIPPort();
            xmlNode.setAttribute(FIELD_IPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSConsoleServerBase.getMemo() != null) {
            object = pSConsoleServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getPSConsoleServerId() != null) {
            object = pSConsoleServerBase.getPSConsoleServerId();
            xmlNode.setAttribute(FIELD_PSCONSOLESERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getPSConsoleServerName() != null) {
            object = pSConsoleServerBase.getPSConsoleServerName();
            xmlNode.setAttribute(FIELD_PSCONSOLESERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getPSSvrDomainId() != null) {
            object = pSConsoleServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getPSSvrDomainName() != null) {
            object = pSConsoleServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSConsoleServerBase.getUpdateDate() != null) {
            object = pSConsoleServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSConsoleServerBase.getUpdateMan() != null) {
            object = pSConsoleServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSConsoleServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSConsoleServerBase pSConsoleServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSConsoleServerBase.isCreateDateDirty() && (bl || pSConsoleServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSConsoleServerBase.getCreateDate());
        }
        if (pSConsoleServerBase.isCreateManDirty() && (bl || pSConsoleServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSConsoleServerBase.getCreateMan());
        }
        if (pSConsoleServerBase.isCSStateDirty() && (bl || pSConsoleServerBase.getCSState() != null)) {
            iDataObject.set(FIELD_CSSTATE, (Object)pSConsoleServerBase.getCSState());
        }
        if (pSConsoleServerBase.isHttpAddressDirty() && (bl || pSConsoleServerBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSConsoleServerBase.getHttpAddress());
        }
        if (pSConsoleServerBase.isHttpPortDirty() && (bl || pSConsoleServerBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSConsoleServerBase.getHttpPort());
        }
        if (pSConsoleServerBase.isIpAddrDirty() && (bl || pSConsoleServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSConsoleServerBase.getIpAddr());
        }
        if (pSConsoleServerBase.isIPPortDirty() && (bl || pSConsoleServerBase.getIPPort() != null)) {
            iDataObject.set(FIELD_IPPORT, (Object)pSConsoleServerBase.getIPPort());
        }
        if (pSConsoleServerBase.isMemoDirty() && (bl || pSConsoleServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSConsoleServerBase.getMemo());
        }
        if (pSConsoleServerBase.isPSConsoleServerIdDirty() && (bl || pSConsoleServerBase.getPSConsoleServerId() != null)) {
            iDataObject.set(FIELD_PSCONSOLESERVERID, (Object)pSConsoleServerBase.getPSConsoleServerId());
        }
        if (pSConsoleServerBase.isPSConsoleServerNameDirty() && (bl || pSConsoleServerBase.getPSConsoleServerName() != null)) {
            iDataObject.set(FIELD_PSCONSOLESERVERNAME, (Object)pSConsoleServerBase.getPSConsoleServerName());
        }
        if (pSConsoleServerBase.isPSSvrDomainIdDirty() && (bl || pSConsoleServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSConsoleServerBase.getPSSvrDomainId());
        }
        if (pSConsoleServerBase.isPSSvrDomainNameDirty() && (bl || pSConsoleServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSConsoleServerBase.getPSSvrDomainName());
        }
        if (pSConsoleServerBase.isUpdateDateDirty() && (bl || pSConsoleServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSConsoleServerBase.getUpdateDate());
        }
        if (pSConsoleServerBase.isUpdateManDirty() && (bl || pSConsoleServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSConsoleServerBase.getUpdateMan());
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
        return PSConsoleServerBase.remove(this, n);
    }

    private static boolean remove(PSConsoleServerBase pSConsoleServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSConsoleServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSConsoleServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSConsoleServerBase.resetCSState();
                return true;
            }
            case 3: {
                pSConsoleServerBase.resetHttpAddress();
                return true;
            }
            case 4: {
                pSConsoleServerBase.resetHttpPort();
                return true;
            }
            case 5: {
                pSConsoleServerBase.resetIpAddr();
                return true;
            }
            case 6: {
                pSConsoleServerBase.resetIPPort();
                return true;
            }
            case 7: {
                pSConsoleServerBase.resetMemo();
                return true;
            }
            case 8: {
                pSConsoleServerBase.resetPSConsoleServerId();
                return true;
            }
            case 9: {
                pSConsoleServerBase.resetPSConsoleServerName();
                return true;
            }
            case 10: {
                pSConsoleServerBase.resetPSSvrDomainId();
                return true;
            }
            case 11: {
                pSConsoleServerBase.resetPSSvrDomainName();
                return true;
            }
            case 12: {
                pSConsoleServerBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSConsoleServerBase.resetUpdateMan();
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

    private PSConsoleServerBase getProxyEntity() {
        return this.proxyPSConsoleServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSConsoleServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSConsoleServerBase) {
            this.proxyPSConsoleServerBase = (PSConsoleServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CSSTATE, 2);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 3);
        fieldIndexMap.put(FIELD_HTTPPORT, 4);
        fieldIndexMap.put(FIELD_IPADDR, 5);
        fieldIndexMap.put(FIELD_IPPORT, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSCONSOLESERVERID, 8);
        fieldIndexMap.put(FIELD_PSCONSOLESERVERNAME, 9);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 10);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

