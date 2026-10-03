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

public abstract class PSDCServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSPARAMS = "DSPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSERVERID = "PSDCSERVERID";
    public static final String FIELD_PSDCSERVERNAME = "PSDCSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SERVERURL = "SERVERURL";
    public static final String FIELD_SERVERURL2 = "SERVERURL2";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSPARAMS = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_IPADDR2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCSERVERID = 6;
    private static final int INDEX_PSDCSERVERNAME = 7;
    private static final int INDEX_PSSVRDOMAINID = 8;
    private static final int INDEX_PSSVRDOMAINNAME = 9;
    private static final int INDEX_SERVERURL = 10;
    private static final int INDEX_SERVERURL2 = 11;
    private static final int INDEX_SYSVER = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCServerBase proxyPSDCServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcserveridDirtyFlag = false;
    private boolean psdcservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean serverurlDirtyFlag = false;
    private boolean serverurl2DirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsparams")
    private String dsparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcserverid")
    private String psdcserverid;
    @Column(name="psdcservername")
    private String psdcservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="serverurl")
    private String serverurl;
    @Column(name="serverurl2")
    private String serverurl2;
    @Column(name="sysver")
    private String sysver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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

    public void setDSParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dsparams = string;
        this.dsparamsDirtyFlag = true;
    }

    public String getDSParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSParams();
        }
        return this.dsparams;
    }

    public boolean isDSParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSParamsDirty();
        }
        return this.dsparamsDirtyFlag;
    }

    public void resetDSParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSParams();
            return;
        }
        this.dsparamsDirtyFlag = false;
        this.dsparams = null;
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

    public void setIPAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIPAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIPAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIPAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
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

    public void setPSDCServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcserverid = string;
        this.psdcserveridDirtyFlag = true;
    }

    public String getPSDCServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCServerId();
        }
        return this.psdcserverid;
    }

    public boolean isPSDCServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCServerIdDirty();
        }
        return this.psdcserveridDirtyFlag;
    }

    public void resetPSDCServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCServerId();
            return;
        }
        this.psdcserveridDirtyFlag = false;
        this.psdcserverid = null;
    }

    public void setPSDCServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcservername = string;
        this.psdcservernameDirtyFlag = true;
    }

    public String getPSDCServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCServerName();
        }
        return this.psdcservername;
    }

    public boolean isPSDCServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCServerNameDirty();
        }
        return this.psdcservernameDirtyFlag;
    }

    public void resetPSDCServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCServerName();
            return;
        }
        this.psdcservernameDirtyFlag = false;
        this.psdcservername = null;
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

    public void setServerUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl = string;
        this.serverurlDirtyFlag = true;
    }

    public String getServerUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl();
        }
        return this.serverurl;
    }

    public boolean isServerUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrlDirty();
        }
        return this.serverurlDirtyFlag;
    }

    public void resetServerUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl();
            return;
        }
        this.serverurlDirtyFlag = false;
        this.serverurl = null;
    }

    public void setServerUrl2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl2 = string;
        this.serverurl2DirtyFlag = true;
    }

    public String getServerUrl2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl2();
        }
        return this.serverurl2;
    }

    public boolean isServerUrl2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrl2Dirty();
        }
        return this.serverurl2DirtyFlag;
    }

    public void resetServerUrl2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl2();
            return;
        }
        this.serverurl2DirtyFlag = false;
        this.serverurl2 = null;
    }

    public void setSysVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysver = string;
        this.sysverDirtyFlag = true;
    }

    public String getSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVer();
        }
        return this.sysver;
    }

    public boolean isSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerDirty();
        }
        return this.sysverDirtyFlag;
    }

    public void resetSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVer();
            return;
        }
        this.sysverDirtyFlag = false;
        this.sysver = null;
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
        PSDCServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCServerBase pSDCServerBase) {
        pSDCServerBase.resetCreateDate();
        pSDCServerBase.resetCreateMan();
        pSDCServerBase.resetDSParams();
        pSDCServerBase.resetIPAddr();
        pSDCServerBase.resetIPAddr2();
        pSDCServerBase.resetMemo();
        pSDCServerBase.resetPSDCServerId();
        pSDCServerBase.resetPSDCServerName();
        pSDCServerBase.resetPSSvrDomainId();
        pSDCServerBase.resetPSSvrDomainName();
        pSDCServerBase.resetServerUrl();
        pSDCServerBase.resetServerUrl2();
        pSDCServerBase.resetSysVer();
        pSDCServerBase.resetUpdateDate();
        pSDCServerBase.resetUpdateMan();
        pSDCServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDSParamsDirty()) {
            hashMap.put(FIELD_DSPARAMS, this.getDSParams());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isIPAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIPAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCServerIdDirty()) {
            hashMap.put(FIELD_PSDCSERVERID, this.getPSDCServerId());
        }
        if (!bl || this.isPSDCServerNameDirty()) {
            hashMap.put(FIELD_PSDCSERVERNAME, this.getPSDCServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isServerUrlDirty()) {
            hashMap.put(FIELD_SERVERURL, this.getServerUrl());
        }
        if (!bl || this.isServerUrl2Dirty()) {
            hashMap.put(FIELD_SERVERURL2, this.getServerUrl2());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCServerBase.get(this, n);
    }

    private static Object get(PSDCServerBase pSDCServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerBase.getCreateDate();
            }
            case 1: {
                return pSDCServerBase.getCreateMan();
            }
            case 2: {
                return pSDCServerBase.getDSParams();
            }
            case 3: {
                return pSDCServerBase.getIPAddr();
            }
            case 4: {
                return pSDCServerBase.getIPAddr2();
            }
            case 5: {
                return pSDCServerBase.getMemo();
            }
            case 6: {
                return pSDCServerBase.getPSDCServerId();
            }
            case 7: {
                return pSDCServerBase.getPSDCServerName();
            }
            case 8: {
                return pSDCServerBase.getPSSvrDomainId();
            }
            case 9: {
                return pSDCServerBase.getPSSvrDomainName();
            }
            case 10: {
                return pSDCServerBase.getServerUrl();
            }
            case 11: {
                return pSDCServerBase.getServerUrl2();
            }
            case 12: {
                return pSDCServerBase.getSysVer();
            }
            case 13: {
                return pSDCServerBase.getUpdateDate();
            }
            case 14: {
                return pSDCServerBase.getUpdateMan();
            }
            case 15: {
                return pSDCServerBase.getValidFlag();
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
        PSDCServerBase.set(this, n, object);
    }

    private static void set(PSDCServerBase pSDCServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCServerBase.setDSParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCServerBase.setIPAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCServerBase.setPSDCServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCServerBase.setPSDCServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCServerBase.setServerUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCServerBase.setServerUrl2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCServerBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDCServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCServerBase pSDCServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCServerBase.getDSParams() == null;
            }
            case 3: {
                return pSDCServerBase.getIPAddr() == null;
            }
            case 4: {
                return pSDCServerBase.getIPAddr2() == null;
            }
            case 5: {
                return pSDCServerBase.getMemo() == null;
            }
            case 6: {
                return pSDCServerBase.getPSDCServerId() == null;
            }
            case 7: {
                return pSDCServerBase.getPSDCServerName() == null;
            }
            case 8: {
                return pSDCServerBase.getPSSvrDomainId() == null;
            }
            case 9: {
                return pSDCServerBase.getPSSvrDomainName() == null;
            }
            case 10: {
                return pSDCServerBase.getServerUrl() == null;
            }
            case 11: {
                return pSDCServerBase.getServerUrl2() == null;
            }
            case 12: {
                return pSDCServerBase.getSysVer() == null;
            }
            case 13: {
                return pSDCServerBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDCServerBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDCServerBase.getValidFlag() == null;
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
        return PSDCServerBase.contains(this, n);
    }

    private static boolean contains(PSDCServerBase pSDCServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCServerBase.isCreateManDirty();
            }
            case 2: {
                return pSDCServerBase.isDSParamsDirty();
            }
            case 3: {
                return pSDCServerBase.isIPAddrDirty();
            }
            case 4: {
                return pSDCServerBase.isIPAddr2Dirty();
            }
            case 5: {
                return pSDCServerBase.isMemoDirty();
            }
            case 6: {
                return pSDCServerBase.isPSDCServerIdDirty();
            }
            case 7: {
                return pSDCServerBase.isPSDCServerNameDirty();
            }
            case 8: {
                return pSDCServerBase.isPSSvrDomainIdDirty();
            }
            case 9: {
                return pSDCServerBase.isPSSvrDomainNameDirty();
            }
            case 10: {
                return pSDCServerBase.isServerUrlDirty();
            }
            case 11: {
                return pSDCServerBase.isServerUrl2Dirty();
            }
            case 12: {
                return pSDCServerBase.isSysVerDirty();
            }
            case 13: {
                return pSDCServerBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDCServerBase.isUpdateManDirty();
            }
            case 15: {
                return pSDCServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCServerBase pSDCServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCServerBase.getDSParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dsparams", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getDSParams()), (boolean)false);
        }
        if (bl || pSDCServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSDCServerBase.getIPAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getIPAddr2()), (boolean)false);
        }
        if (bl || pSDCServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCServerBase.getPSDCServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcserverid", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getPSDCServerId()), (boolean)false);
        }
        if (bl || pSDCServerBase.getPSDCServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcservername", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getPSDCServerName()), (boolean)false);
        }
        if (bl || pSDCServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDCServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDCServerBase.getServerUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getServerUrl()), (boolean)false);
        }
        if (bl || pSDCServerBase.getServerUrl2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl2", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getServerUrl2()), (boolean)false);
        }
        if (bl || pSDCServerBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getSysVer()), (boolean)false);
        }
        if (bl || pSDCServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCServerBase.getJSONValue((Object)pSDCServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCServerBase pSDCServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCServerBase.getCreateDate() != null) {
            object = pSDCServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCServerBase.getCreateMan() != null) {
            object = pSDCServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getDSParams() != null) {
            object = pSDCServerBase.getDSParams();
            xmlNode.setAttribute(FIELD_DSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getIPAddr() != null) {
            object = pSDCServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getIPAddr2() != null) {
            object = pSDCServerBase.getIPAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getMemo() != null) {
            object = pSDCServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getPSDCServerId() != null) {
            object = pSDCServerBase.getPSDCServerId();
            xmlNode.setAttribute(FIELD_PSDCSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getPSDCServerName() != null) {
            object = pSDCServerBase.getPSDCServerName();
            xmlNode.setAttribute(FIELD_PSDCSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getPSSvrDomainId() != null) {
            object = pSDCServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getPSSvrDomainName() != null) {
            object = pSDCServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getServerUrl() != null) {
            object = pSDCServerBase.getServerUrl();
            xmlNode.setAttribute(FIELD_SERVERURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getServerUrl2() != null) {
            object = pSDCServerBase.getServerUrl2();
            xmlNode.setAttribute(FIELD_SERVERURL2, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getSysVer() != null) {
            object = pSDCServerBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getUpdateDate() != null) {
            object = pSDCServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCServerBase.getUpdateMan() != null) {
            object = pSDCServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCServerBase.getValidFlag() != null) {
            object = pSDCServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCServerBase pSDCServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCServerBase.isCreateDateDirty() && (bl || pSDCServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCServerBase.getCreateDate());
        }
        if (pSDCServerBase.isCreateManDirty() && (bl || pSDCServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCServerBase.getCreateMan());
        }
        if (pSDCServerBase.isDSParamsDirty() && (bl || pSDCServerBase.getDSParams() != null)) {
            iDataObject.set(FIELD_DSPARAMS, (Object)pSDCServerBase.getDSParams());
        }
        if (pSDCServerBase.isIPAddrDirty() && (bl || pSDCServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCServerBase.getIPAddr());
        }
        if (pSDCServerBase.isIPAddr2Dirty() && (bl || pSDCServerBase.getIPAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCServerBase.getIPAddr2());
        }
        if (pSDCServerBase.isMemoDirty() && (bl || pSDCServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCServerBase.getMemo());
        }
        if (pSDCServerBase.isPSDCServerIdDirty() && (bl || pSDCServerBase.getPSDCServerId() != null)) {
            iDataObject.set(FIELD_PSDCSERVERID, (Object)pSDCServerBase.getPSDCServerId());
        }
        if (pSDCServerBase.isPSDCServerNameDirty() && (bl || pSDCServerBase.getPSDCServerName() != null)) {
            iDataObject.set(FIELD_PSDCSERVERNAME, (Object)pSDCServerBase.getPSDCServerName());
        }
        if (pSDCServerBase.isPSSvrDomainIdDirty() && (bl || pSDCServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDCServerBase.getPSSvrDomainId());
        }
        if (pSDCServerBase.isPSSvrDomainNameDirty() && (bl || pSDCServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDCServerBase.getPSSvrDomainName());
        }
        if (pSDCServerBase.isServerUrlDirty() && (bl || pSDCServerBase.getServerUrl() != null)) {
            iDataObject.set(FIELD_SERVERURL, (Object)pSDCServerBase.getServerUrl());
        }
        if (pSDCServerBase.isServerUrl2Dirty() && (bl || pSDCServerBase.getServerUrl2() != null)) {
            iDataObject.set(FIELD_SERVERURL2, (Object)pSDCServerBase.getServerUrl2());
        }
        if (pSDCServerBase.isSysVerDirty() && (bl || pSDCServerBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSDCServerBase.getSysVer());
        }
        if (pSDCServerBase.isUpdateDateDirty() && (bl || pSDCServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCServerBase.getUpdateDate());
        }
        if (pSDCServerBase.isUpdateManDirty() && (bl || pSDCServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCServerBase.getUpdateMan());
        }
        if (pSDCServerBase.isValidFlagDirty() && (bl || pSDCServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCServerBase.getValidFlag());
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
        return PSDCServerBase.remove(this, n);
    }

    private static boolean remove(PSDCServerBase pSDCServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCServerBase.resetDSParams();
                return true;
            }
            case 3: {
                pSDCServerBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSDCServerBase.resetIPAddr2();
                return true;
            }
            case 5: {
                pSDCServerBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCServerBase.resetPSDCServerId();
                return true;
            }
            case 7: {
                pSDCServerBase.resetPSDCServerName();
                return true;
            }
            case 8: {
                pSDCServerBase.resetPSSvrDomainId();
                return true;
            }
            case 9: {
                pSDCServerBase.resetPSSvrDomainName();
                return true;
            }
            case 10: {
                pSDCServerBase.resetServerUrl();
                return true;
            }
            case 11: {
                pSDCServerBase.resetServerUrl2();
                return true;
            }
            case 12: {
                pSDCServerBase.resetSysVer();
                return true;
            }
            case 13: {
                pSDCServerBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDCServerBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDCServerBase.resetValidFlag();
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

    private PSDCServerBase getProxyEntity() {
        return this.proxyPSDCServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCServerBase) {
            this.proxyPSDCServerBase = (PSDCServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDCServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSPARAMS, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_IPADDR2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCSERVERID, 6);
        fieldIndexMap.put(FIELD_PSDCSERVERNAME, 7);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 9);
        fieldIndexMap.put(FIELD_SERVERURL, 10);
        fieldIndexMap.put(FIELD_SERVERURL2, 11);
        fieldIndexMap.put(FIELD_SYSVER, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

