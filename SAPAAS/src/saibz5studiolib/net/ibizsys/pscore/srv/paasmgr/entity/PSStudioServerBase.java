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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdInstLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrp;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdInstLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOMAINPARAMS = "DOMAINPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PSSTUDIOSERVERGRPID = "PSSTUDIOSERVERGRPID";
    public static final String FIELD_PSSTUDIOSERVERGRPNAME = "PSSTUDIOSERVERGRPNAME";
    public static final String FIELD_PSSTUDIOSERVERID = "PSSTUDIOSERVERID";
    public static final String FIELD_PSSTUDIOSERVERNAME = "PSSTUDIOSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SERVERPARAMS = "SERVERPARAMS";
    public static final String FIELD_SERVERURL = "SERVERURL";
    public static final String FIELD_SERVERURL2 = "SERVERURL2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DOMAINPARAMS = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_IPADDR2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSCOREPRDID = 6;
    private static final int INDEX_PSCOREPRDNAME = 7;
    private static final int INDEX_PSCOREPRDVERID = 8;
    private static final int INDEX_PSCOREPRDVERNAME = 9;
    private static final int INDEX_PSSTUDIOSERVERGRPID = 10;
    private static final int INDEX_PSSTUDIOSERVERGRPNAME = 11;
    private static final int INDEX_PSSTUDIOSERVERID = 12;
    private static final int INDEX_PSSTUDIOSERVERNAME = 13;
    private static final int INDEX_PSSVRDOMAINID = 14;
    private static final int INDEX_PSSVRDOMAINNAME = 15;
    private static final int INDEX_SERVERPARAMS = 16;
    private static final int INDEX_SERVERURL = 17;
    private static final int INDEX_SERVERURL2 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioServerBase proxyPSStudioServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean domainparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean psstudioservergrpidDirtyFlag = false;
    private boolean psstudioservergrpnameDirtyFlag = false;
    private boolean psstudioserveridDirtyFlag = false;
    private boolean psstudioservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean serverparamsDirtyFlag = false;
    private boolean serverurlDirtyFlag = false;
    private boolean serverurl2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="domainparams")
    private String domainparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="psstudioservergrpid")
    private String psstudioservergrpid;
    @Column(name="psstudioservergrpname")
    private String psstudioservergrpname;
    @Column(name="psstudioserverid")
    private String psstudioserverid;
    @Column(name="psstudioservername")
    private String psstudioservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="serverparams")
    private String serverparams;
    @Column(name="serverurl")
    private String serverurl;
    @Column(name="serverurl2")
    private String serverurl2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCorePrdVerLock = new Integer(1);
    private PSCorePrdVer pscoreprdver = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;
    private Integer objPSStudioServerGrpLock = new Integer(1);
    private PSStudioServerGrp psstudioservergrp = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSCorePrdInstLogsLock = new Integer(1);
    private ArrayList<PSCorePrdInstLog> pscoreprdinstlogs = null;

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

    public void setDomainParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparams = string;
        this.domainparamsDirtyFlag = true;
    }

    public String getDomainParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParams();
        }
        return this.domainparams;
    }

    public boolean isDomainParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParamsDirty();
        }
        return this.domainparamsDirtyFlag;
    }

    public void resetDomainParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParams();
            return;
        }
        this.domainparamsDirtyFlag = false;
        this.domainparams = null;
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

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPSStudioServerGrpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpid = string;
        this.psstudioservergrpidDirtyFlag = true;
    }

    public String getPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpId();
        }
        return this.psstudioservergrpid;
    }

    public boolean isPSStudioServerGrpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpIdDirty();
        }
        return this.psstudioservergrpidDirtyFlag;
    }

    public void resetPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpId();
            return;
        }
        this.psstudioservergrpidDirtyFlag = false;
        this.psstudioservergrpid = null;
    }

    public void setPSStudioServerGrpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpname = string;
        this.psstudioservergrpnameDirtyFlag = true;
    }

    public String getPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpName();
        }
        return this.psstudioservergrpname;
    }

    public boolean isPSStudioServerGrpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpNameDirty();
        }
        return this.psstudioservergrpnameDirtyFlag;
    }

    public void resetPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpName();
            return;
        }
        this.psstudioservergrpnameDirtyFlag = false;
        this.psstudioservergrpname = null;
    }

    public void setPSStudioServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioserverid = string;
        this.psstudioserveridDirtyFlag = true;
    }

    public String getPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerId();
        }
        return this.psstudioserverid;
    }

    public boolean isPSStudioServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerIdDirty();
        }
        return this.psstudioserveridDirtyFlag;
    }

    public void resetPSStudioServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerId();
            return;
        }
        this.psstudioserveridDirtyFlag = false;
        this.psstudioserverid = null;
    }

    public void setPSStudioServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservername = string;
        this.psstudioservernameDirtyFlag = true;
    }

    public String getPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerName();
        }
        return this.psstudioservername;
    }

    public boolean isPSStudioServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerNameDirty();
        }
        return this.psstudioservernameDirtyFlag;
    }

    public void resetPSStudioServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerName();
            return;
        }
        this.psstudioservernameDirtyFlag = false;
        this.psstudioservername = null;
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

    public void setServerParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverparams = string;
        this.serverparamsDirtyFlag = true;
    }

    public String getServerParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerParams();
        }
        return this.serverparams;
    }

    public boolean isServerParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerParamsDirty();
        }
        return this.serverparamsDirtyFlag;
    }

    public void resetServerParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerParams();
            return;
        }
        this.serverparamsDirtyFlag = false;
        this.serverparams = null;
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
        PSStudioServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioServerBase pSStudioServerBase) {
        pSStudioServerBase.resetCreateDate();
        pSStudioServerBase.resetCreateMan();
        pSStudioServerBase.resetDomainParams();
        pSStudioServerBase.resetIPAddr();
        pSStudioServerBase.resetIPAddr2();
        pSStudioServerBase.resetMemo();
        pSStudioServerBase.resetPSCorePrdId();
        pSStudioServerBase.resetPSCorePrdName();
        pSStudioServerBase.resetPSCorePrdVerId();
        pSStudioServerBase.resetPSCorePrdVerName();
        pSStudioServerBase.resetPSStudioServerGrpId();
        pSStudioServerBase.resetPSStudioServerGrpName();
        pSStudioServerBase.resetPSStudioServerId();
        pSStudioServerBase.resetPSStudioServerName();
        pSStudioServerBase.resetPSSvrDomainId();
        pSStudioServerBase.resetPSSvrDomainName();
        pSStudioServerBase.resetServerParams();
        pSStudioServerBase.resetServerUrl();
        pSStudioServerBase.resetServerUrl2();
        pSStudioServerBase.resetUpdateDate();
        pSStudioServerBase.resetUpdateMan();
        pSStudioServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDomainParamsDirty()) {
            hashMap.put(FIELD_DOMAINPARAMS, this.getDomainParams());
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
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPSStudioServerGrpIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPID, this.getPSStudioServerGrpId());
        }
        if (!bl || this.isPSStudioServerGrpNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPNAME, this.getPSStudioServerGrpName());
        }
        if (!bl || this.isPSStudioServerIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERID, this.getPSStudioServerId());
        }
        if (!bl || this.isPSStudioServerNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERNAME, this.getPSStudioServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isServerParamsDirty()) {
            hashMap.put(FIELD_SERVERPARAMS, this.getServerParams());
        }
        if (!bl || this.isServerUrlDirty()) {
            hashMap.put(FIELD_SERVERURL, this.getServerUrl());
        }
        if (!bl || this.isServerUrl2Dirty()) {
            hashMap.put(FIELD_SERVERURL2, this.getServerUrl2());
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
        return PSStudioServerBase.get(this, n);
    }

    private static Object get(PSStudioServerBase pSStudioServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerBase.getCreateDate();
            }
            case 1: {
                return pSStudioServerBase.getCreateMan();
            }
            case 2: {
                return pSStudioServerBase.getDomainParams();
            }
            case 3: {
                return pSStudioServerBase.getIPAddr();
            }
            case 4: {
                return pSStudioServerBase.getIPAddr2();
            }
            case 5: {
                return pSStudioServerBase.getMemo();
            }
            case 6: {
                return pSStudioServerBase.getPSCorePrdId();
            }
            case 7: {
                return pSStudioServerBase.getPSCorePrdName();
            }
            case 8: {
                return pSStudioServerBase.getPSCorePrdVerId();
            }
            case 9: {
                return pSStudioServerBase.getPSCorePrdVerName();
            }
            case 10: {
                return pSStudioServerBase.getPSStudioServerGrpId();
            }
            case 11: {
                return pSStudioServerBase.getPSStudioServerGrpName();
            }
            case 12: {
                return pSStudioServerBase.getPSStudioServerId();
            }
            case 13: {
                return pSStudioServerBase.getPSStudioServerName();
            }
            case 14: {
                return pSStudioServerBase.getPSSvrDomainId();
            }
            case 15: {
                return pSStudioServerBase.getPSSvrDomainName();
            }
            case 16: {
                return pSStudioServerBase.getServerParams();
            }
            case 17: {
                return pSStudioServerBase.getServerUrl();
            }
            case 18: {
                return pSStudioServerBase.getServerUrl2();
            }
            case 19: {
                return pSStudioServerBase.getUpdateDate();
            }
            case 20: {
                return pSStudioServerBase.getUpdateMan();
            }
            case 21: {
                return pSStudioServerBase.getValidFlag();
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
        PSStudioServerBase.set(this, n, object);
    }

    private static void set(PSStudioServerBase pSStudioServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSStudioServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSStudioServerBase.setDomainParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSStudioServerBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSStudioServerBase.setIPAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSStudioServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSStudioServerBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSStudioServerBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioServerBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioServerBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioServerBase.setPSStudioServerGrpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioServerBase.setPSStudioServerGrpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSStudioServerBase.setPSStudioServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSStudioServerBase.setPSStudioServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSStudioServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSStudioServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSStudioServerBase.setServerParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSStudioServerBase.setServerUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSStudioServerBase.setServerUrl2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSStudioServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSStudioServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSStudioServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSStudioServerBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioServerBase pSStudioServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSStudioServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSStudioServerBase.getDomainParams() == null;
            }
            case 3: {
                return pSStudioServerBase.getIPAddr() == null;
            }
            case 4: {
                return pSStudioServerBase.getIPAddr2() == null;
            }
            case 5: {
                return pSStudioServerBase.getMemo() == null;
            }
            case 6: {
                return pSStudioServerBase.getPSCorePrdId() == null;
            }
            case 7: {
                return pSStudioServerBase.getPSCorePrdName() == null;
            }
            case 8: {
                return pSStudioServerBase.getPSCorePrdVerId() == null;
            }
            case 9: {
                return pSStudioServerBase.getPSCorePrdVerName() == null;
            }
            case 10: {
                return pSStudioServerBase.getPSStudioServerGrpId() == null;
            }
            case 11: {
                return pSStudioServerBase.getPSStudioServerGrpName() == null;
            }
            case 12: {
                return pSStudioServerBase.getPSStudioServerId() == null;
            }
            case 13: {
                return pSStudioServerBase.getPSStudioServerName() == null;
            }
            case 14: {
                return pSStudioServerBase.getPSSvrDomainId() == null;
            }
            case 15: {
                return pSStudioServerBase.getPSSvrDomainName() == null;
            }
            case 16: {
                return pSStudioServerBase.getServerParams() == null;
            }
            case 17: {
                return pSStudioServerBase.getServerUrl() == null;
            }
            case 18: {
                return pSStudioServerBase.getServerUrl2() == null;
            }
            case 19: {
                return pSStudioServerBase.getUpdateDate() == null;
            }
            case 20: {
                return pSStudioServerBase.getUpdateMan() == null;
            }
            case 21: {
                return pSStudioServerBase.getValidFlag() == null;
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
        return PSStudioServerBase.contains(this, n);
    }

    private static boolean contains(PSStudioServerBase pSStudioServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSStudioServerBase.isCreateManDirty();
            }
            case 2: {
                return pSStudioServerBase.isDomainParamsDirty();
            }
            case 3: {
                return pSStudioServerBase.isIPAddrDirty();
            }
            case 4: {
                return pSStudioServerBase.isIPAddr2Dirty();
            }
            case 5: {
                return pSStudioServerBase.isMemoDirty();
            }
            case 6: {
                return pSStudioServerBase.isPSCorePrdIdDirty();
            }
            case 7: {
                return pSStudioServerBase.isPSCorePrdNameDirty();
            }
            case 8: {
                return pSStudioServerBase.isPSCorePrdVerIdDirty();
            }
            case 9: {
                return pSStudioServerBase.isPSCorePrdVerNameDirty();
            }
            case 10: {
                return pSStudioServerBase.isPSStudioServerGrpIdDirty();
            }
            case 11: {
                return pSStudioServerBase.isPSStudioServerGrpNameDirty();
            }
            case 12: {
                return pSStudioServerBase.isPSStudioServerIdDirty();
            }
            case 13: {
                return pSStudioServerBase.isPSStudioServerNameDirty();
            }
            case 14: {
                return pSStudioServerBase.isPSSvrDomainIdDirty();
            }
            case 15: {
                return pSStudioServerBase.isPSSvrDomainNameDirty();
            }
            case 16: {
                return pSStudioServerBase.isServerParamsDirty();
            }
            case 17: {
                return pSStudioServerBase.isServerUrlDirty();
            }
            case 18: {
                return pSStudioServerBase.isServerUrl2Dirty();
            }
            case 19: {
                return pSStudioServerBase.isUpdateDateDirty();
            }
            case 20: {
                return pSStudioServerBase.isUpdateManDirty();
            }
            case 21: {
                return pSStudioServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioServerBase pSStudioServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getDomainParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparams", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getDomainParams()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getIPAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getIPAddr2()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSStudioServerGrpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpid", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSStudioServerGrpId()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSStudioServerGrpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpname", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSStudioServerGrpName()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSStudioServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioserverid", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSStudioServerId()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSStudioServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservername", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSStudioServerName()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getServerParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverparams", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getServerParams()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getServerUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getServerUrl()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getServerUrl2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl2", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getServerUrl2()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSStudioServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSStudioServerBase.getJSONValue((Object)pSStudioServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioServerBase pSStudioServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioServerBase.getCreateDate() != null) {
            object = pSStudioServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerBase.getCreateMan() != null) {
            object = pSStudioServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getDomainParams() != null) {
            object = pSStudioServerBase.getDomainParams();
            xmlNode.setAttribute(FIELD_DOMAINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getIPAddr() != null) {
            object = pSStudioServerBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getIPAddr2() != null) {
            object = pSStudioServerBase.getIPAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getMemo() != null) {
            object = pSStudioServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSCorePrdId() != null) {
            object = pSStudioServerBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSCorePrdName() != null) {
            object = pSStudioServerBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSCorePrdVerId() != null) {
            object = pSStudioServerBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSCorePrdVerName() != null) {
            object = pSStudioServerBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSStudioServerGrpId() != null) {
            object = pSStudioServerBase.getPSStudioServerGrpId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSStudioServerGrpName() != null) {
            object = pSStudioServerBase.getPSStudioServerGrpName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSStudioServerId() != null) {
            object = pSStudioServerBase.getPSStudioServerId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSStudioServerName() != null) {
            object = pSStudioServerBase.getPSStudioServerName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSSvrDomainId() != null) {
            object = pSStudioServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getPSSvrDomainName() != null) {
            object = pSStudioServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getServerParams() != null) {
            object = pSStudioServerBase.getServerParams();
            xmlNode.setAttribute(FIELD_SERVERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getServerUrl() != null) {
            object = pSStudioServerBase.getServerUrl();
            xmlNode.setAttribute(FIELD_SERVERURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getServerUrl2() != null) {
            object = pSStudioServerBase.getServerUrl2();
            xmlNode.setAttribute(FIELD_SERVERURL2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getUpdateDate() != null) {
            object = pSStudioServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerBase.getUpdateMan() != null) {
            object = pSStudioServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerBase.getValidFlag() != null) {
            object = pSStudioServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioServerBase pSStudioServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioServerBase.isCreateDateDirty() && (bl || pSStudioServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioServerBase.getCreateDate());
        }
        if (pSStudioServerBase.isCreateManDirty() && (bl || pSStudioServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioServerBase.getCreateMan());
        }
        if (pSStudioServerBase.isDomainParamsDirty() && (bl || pSStudioServerBase.getDomainParams() != null)) {
            iDataObject.set(FIELD_DOMAINPARAMS, (Object)pSStudioServerBase.getDomainParams());
        }
        if (pSStudioServerBase.isIPAddrDirty() && (bl || pSStudioServerBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSStudioServerBase.getIPAddr());
        }
        if (pSStudioServerBase.isIPAddr2Dirty() && (bl || pSStudioServerBase.getIPAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSStudioServerBase.getIPAddr2());
        }
        if (pSStudioServerBase.isMemoDirty() && (bl || pSStudioServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSStudioServerBase.getMemo());
        }
        if (pSStudioServerBase.isPSCorePrdIdDirty() && (bl || pSStudioServerBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSStudioServerBase.getPSCorePrdId());
        }
        if (pSStudioServerBase.isPSCorePrdNameDirty() && (bl || pSStudioServerBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSStudioServerBase.getPSCorePrdName());
        }
        if (pSStudioServerBase.isPSCorePrdVerIdDirty() && (bl || pSStudioServerBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSStudioServerBase.getPSCorePrdVerId());
        }
        if (pSStudioServerBase.isPSCorePrdVerNameDirty() && (bl || pSStudioServerBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSStudioServerBase.getPSCorePrdVerName());
        }
        if (pSStudioServerBase.isPSStudioServerGrpIdDirty() && (bl || pSStudioServerBase.getPSStudioServerGrpId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPID, (Object)pSStudioServerBase.getPSStudioServerGrpId());
        }
        if (pSStudioServerBase.isPSStudioServerGrpNameDirty() && (bl || pSStudioServerBase.getPSStudioServerGrpName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPNAME, (Object)pSStudioServerBase.getPSStudioServerGrpName());
        }
        if (pSStudioServerBase.isPSStudioServerIdDirty() && (bl || pSStudioServerBase.getPSStudioServerId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERID, (Object)pSStudioServerBase.getPSStudioServerId());
        }
        if (pSStudioServerBase.isPSStudioServerNameDirty() && (bl || pSStudioServerBase.getPSStudioServerName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERNAME, (Object)pSStudioServerBase.getPSStudioServerName());
        }
        if (pSStudioServerBase.isPSSvrDomainIdDirty() && (bl || pSStudioServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSStudioServerBase.getPSSvrDomainId());
        }
        if (pSStudioServerBase.isPSSvrDomainNameDirty() && (bl || pSStudioServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSStudioServerBase.getPSSvrDomainName());
        }
        if (pSStudioServerBase.isServerParamsDirty() && (bl || pSStudioServerBase.getServerParams() != null)) {
            iDataObject.set(FIELD_SERVERPARAMS, (Object)pSStudioServerBase.getServerParams());
        }
        if (pSStudioServerBase.isServerUrlDirty() && (bl || pSStudioServerBase.getServerUrl() != null)) {
            iDataObject.set(FIELD_SERVERURL, (Object)pSStudioServerBase.getServerUrl());
        }
        if (pSStudioServerBase.isServerUrl2Dirty() && (bl || pSStudioServerBase.getServerUrl2() != null)) {
            iDataObject.set(FIELD_SERVERURL2, (Object)pSStudioServerBase.getServerUrl2());
        }
        if (pSStudioServerBase.isUpdateDateDirty() && (bl || pSStudioServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioServerBase.getUpdateDate());
        }
        if (pSStudioServerBase.isUpdateManDirty() && (bl || pSStudioServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioServerBase.getUpdateMan());
        }
        if (pSStudioServerBase.isValidFlagDirty() && (bl || pSStudioServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSStudioServerBase.getValidFlag());
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
        return PSStudioServerBase.remove(this, n);
    }

    private static boolean remove(PSStudioServerBase pSStudioServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSStudioServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSStudioServerBase.resetDomainParams();
                return true;
            }
            case 3: {
                pSStudioServerBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSStudioServerBase.resetIPAddr2();
                return true;
            }
            case 5: {
                pSStudioServerBase.resetMemo();
                return true;
            }
            case 6: {
                pSStudioServerBase.resetPSCorePrdId();
                return true;
            }
            case 7: {
                pSStudioServerBase.resetPSCorePrdName();
                return true;
            }
            case 8: {
                pSStudioServerBase.resetPSCorePrdVerId();
                return true;
            }
            case 9: {
                pSStudioServerBase.resetPSCorePrdVerName();
                return true;
            }
            case 10: {
                pSStudioServerBase.resetPSStudioServerGrpId();
                return true;
            }
            case 11: {
                pSStudioServerBase.resetPSStudioServerGrpName();
                return true;
            }
            case 12: {
                pSStudioServerBase.resetPSStudioServerId();
                return true;
            }
            case 13: {
                pSStudioServerBase.resetPSStudioServerName();
                return true;
            }
            case 14: {
                pSStudioServerBase.resetPSSvrDomainId();
                return true;
            }
            case 15: {
                pSStudioServerBase.resetPSSvrDomainName();
                return true;
            }
            case 16: {
                pSStudioServerBase.resetServerParams();
                return true;
            }
            case 17: {
                pSStudioServerBase.resetServerUrl();
                return true;
            }
            case 18: {
                pSStudioServerBase.resetServerUrl2();
                return true;
            }
            case 19: {
                pSStudioServerBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSStudioServerBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSStudioServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCorePrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdVerLock;
        synchronized (n) {
            if (this.pscoreprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscoreprdver.getPSCorePrdVerId()) != 0L) {
                this.pscoreprdver = null;
            }
            if (this.pscoreprdver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet(pSCorePrdVer);
                this.pscoreprdver = pSCorePrdVer;
            }
            return this.pscoreprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet(pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioServerGrp getPSStudioServerGrp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrp();
        }
        if (this.getPSStudioServerGrpId() == null) {
            return null;
        }
        Integer n = this.objPSStudioServerGrpLock;
        synchronized (n) {
            if (this.psstudioservergrp != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioServerGrpId(), (Object)this.psstudioservergrp.getPSStudioServerGrpId()) != 0L) {
                this.psstudioservergrp = null;
            }
            if (this.psstudioservergrp == null) {
                PSStudioServerGrp pSStudioServerGrp = new PSStudioServerGrp();
                pSStudioServerGrp.setPSStudioServerGrpId(this.getPSStudioServerGrpId());
                PSStudioServerGrpService pSStudioServerGrpService = (PSStudioServerGrpService)ServiceGlobal.getService(PSStudioServerGrpService.class, (SessionFactory)this.getSessionFactory());
                pSStudioServerGrpService.autoGet(pSStudioServerGrp);
                this.psstudioservergrp = pSStudioServerGrp;
            }
            return this.psstudioservergrp;
        }
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
    public ArrayList<PSCorePrdInstLog> getPSCorePrdInstLogs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdInstLogs();
        }
        if (this.getPSStudioServerId() == null) {
            return null;
        }
        PSCorePrdInstLogService pSCorePrdInstLogService = (PSCorePrdInstLogService)ServiceGlobal.getService(PSCorePrdInstLogService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCorePrdInstLogsLock;
        synchronized (n) {
            if (this.pscoreprdinstlogs == null) {
                this.pscoreprdinstlogs = pSCorePrdInstLogService.selectByPSStudioServer(this);
            }
            return this.pscoreprdinstlogs;
        }
    }

    private PSStudioServerBase getProxyEntity() {
        return this.proxyPSStudioServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioServerBase) {
            this.proxyPSStudioServerBase = (PSStudioServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DOMAINPARAMS, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_IPADDR2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 7);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 9);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPID, 10);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPNAME, 11);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERID, 12);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERNAME, 13);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 14);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 15);
        fieldIndexMap.put(FIELD_SERVERPARAMS, 16);
        fieldIndexMap.put(FIELD_SERVERURL, 17);
        fieldIndexMap.put(FIELD_SERVERURL2, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

