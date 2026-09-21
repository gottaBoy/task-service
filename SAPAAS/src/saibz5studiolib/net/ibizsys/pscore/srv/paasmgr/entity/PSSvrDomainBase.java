/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.entity.PSROSServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService;
import net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSvrDomainBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSvrDomainBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOMAINCODE = "DOMAINCODE";
    public static final String FIELD_DOMAINPARAM = "DOMAINPARAM";
    public static final String FIELD_DOMAINPARAM2 = "DOMAINPARAM2";
    public static final String FIELD_DOMAINPARAM3 = "DOMAINPARAM3";
    public static final String FIELD_DOMAINPARAM4 = "DOMAINPARAM4";
    public static final String FIELD_DOMAINPARAM5 = "DOMAINPARAM5";
    public static final String FIELD_DOMAINPARAM6 = "DOMAINPARAM6";
    public static final String FIELD_DOMAINPARAMS = "DOMAINPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SYNCDATA = "SYNCDATA";
    public static final String FIELD_SYNCDATA10 = "SYNCDATA10";
    public static final String FIELD_SYNCDATA2 = "SYNCDATA2";
    public static final String FIELD_SYNCDATA3 = "SYNCDATA3";
    public static final String FIELD_SYNCDATA4 = "SYNCDATA4";
    public static final String FIELD_SYNCDATA5 = "SYNCDATA5";
    public static final String FIELD_SYNCDATA6 = "SYNCDATA6";
    public static final String FIELD_SYNCDATA7 = "SYNCDATA7";
    public static final String FIELD_SYNCDATA8 = "SYNCDATA8";
    public static final String FIELD_SYNCDATA9 = "SYNCDATA9";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DOMAINCODE = 2;
    private static final int INDEX_DOMAINPARAM = 3;
    private static final int INDEX_DOMAINPARAM2 = 4;
    private static final int INDEX_DOMAINPARAM3 = 5;
    private static final int INDEX_DOMAINPARAM4 = 6;
    private static final int INDEX_DOMAINPARAM5 = 7;
    private static final int INDEX_DOMAINPARAM6 = 8;
    private static final int INDEX_DOMAINPARAMS = 9;
    private static final int INDEX_IPADDR = 10;
    private static final int INDEX_IPADDR2 = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PSSVRDOMAINID = 13;
    private static final int INDEX_PSSVRDOMAINNAME = 14;
    private static final int INDEX_SYNCDATA = 15;
    private static final int INDEX_SYNCDATA10 = 16;
    private static final int INDEX_SYNCDATA2 = 17;
    private static final int INDEX_SYNCDATA3 = 18;
    private static final int INDEX_SYNCDATA4 = 19;
    private static final int INDEX_SYNCDATA5 = 20;
    private static final int INDEX_SYNCDATA6 = 21;
    private static final int INDEX_SYNCDATA7 = 22;
    private static final int INDEX_SYNCDATA8 = 23;
    private static final int INDEX_SYNCDATA9 = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSvrDomainBase proxyPSSvrDomainBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean domaincodeDirtyFlag = false;
    private boolean domainparamDirtyFlag = false;
    private boolean domainparam2DirtyFlag = false;
    private boolean domainparam3DirtyFlag = false;
    private boolean domainparam4DirtyFlag = false;
    private boolean domainparam5DirtyFlag = false;
    private boolean domainparam6DirtyFlag = false;
    private boolean domainparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean syncdataDirtyFlag = false;
    private boolean syncdata10DirtyFlag = false;
    private boolean syncdata2DirtyFlag = false;
    private boolean syncdata3DirtyFlag = false;
    private boolean syncdata4DirtyFlag = false;
    private boolean syncdata5DirtyFlag = false;
    private boolean syncdata6DirtyFlag = false;
    private boolean syncdata7DirtyFlag = false;
    private boolean syncdata8DirtyFlag = false;
    private boolean syncdata9DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="domaincode")
    private String domaincode;
    @Column(name="domainparam")
    private String domainparam;
    @Column(name="domainparam2")
    private String domainparam2;
    @Column(name="domainparam3")
    private String domainparam3;
    @Column(name="domainparam4")
    private String domainparam4;
    @Column(name="domainparam5")
    private Integer domainparam5;
    @Column(name="domainparam6")
    private Integer domainparam6;
    @Column(name="domainparams")
    private String domainparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="syncdata")
    private Integer syncdata;
    @Column(name="syncdata10")
    private Integer syncdata10;
    @Column(name="syncdata2")
    private Integer syncdata2;
    @Column(name="syncdata3")
    private Integer syncdata3;
    @Column(name="syncdata4")
    private Integer syncdata4;
    @Column(name="syncdata5")
    private Integer syncdata5;
    @Column(name="syncdata6")
    private Integer syncdata6;
    @Column(name="syncdata7")
    private Integer syncdata7;
    @Column(name="syncdata8")
    private Integer syncdata8;
    @Column(name="syncdata9")
    private Integer syncdata9;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSASBookingLock = new Integer(1);
    private ArrayList<PSASBooking> psasbooking = null;
    private Integer objPSCredentialsLock = new Integer(1);
    private ArrayList<PSCredential> pscredentials = null;
    private Integer objPSDeployCentersLock = new Integer(1);
    private ArrayList<PSDeployCenter> psdeploycenters = null;
    private Integer objPSDeployServersLock = new Integer(1);
    private ArrayList<PSDeployServer> psdeployservers = null;
    private Integer objPSMSPlatformsLock = new Integer(1);
    private ArrayList<PSMSPlatform> psmsplatforms = null;
    private Integer objPSROSServersLock = new Integer(1);
    private ArrayList<PSROSServer> psrosservers = null;

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

    public void setDomainCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domaincode = string;
        this.domaincodeDirtyFlag = true;
    }

    public String getDomainCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainCode();
        }
        return this.domaincode;
    }

    public boolean isDomainCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainCodeDirty();
        }
        return this.domaincodeDirtyFlag;
    }

    public void resetDomainCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainCode();
            return;
        }
        this.domaincodeDirtyFlag = false;
        this.domaincode = null;
    }

    public void setDomainParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparam = string;
        this.domainparamDirtyFlag = true;
    }

    public String getDomainParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam();
        }
        return this.domainparam;
    }

    public boolean isDomainParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParamDirty();
        }
        return this.domainparamDirtyFlag;
    }

    public void resetDomainParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam();
            return;
        }
        this.domainparamDirtyFlag = false;
        this.domainparam = null;
    }

    public void setDomainParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparam2 = string;
        this.domainparam2DirtyFlag = true;
    }

    public String getDomainParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam2();
        }
        return this.domainparam2;
    }

    public boolean isDomainParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParam2Dirty();
        }
        return this.domainparam2DirtyFlag;
    }

    public void resetDomainParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam2();
            return;
        }
        this.domainparam2DirtyFlag = false;
        this.domainparam2 = null;
    }

    public void setDomainParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparam3 = string;
        this.domainparam3DirtyFlag = true;
    }

    public String getDomainParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam3();
        }
        return this.domainparam3;
    }

    public boolean isDomainParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParam3Dirty();
        }
        return this.domainparam3DirtyFlag;
    }

    public void resetDomainParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam3();
            return;
        }
        this.domainparam3DirtyFlag = false;
        this.domainparam3 = null;
    }

    public void setDomainParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparam4 = string;
        this.domainparam4DirtyFlag = true;
    }

    public String getDomainParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam4();
        }
        return this.domainparam4;
    }

    public boolean isDomainParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParam4Dirty();
        }
        return this.domainparam4DirtyFlag;
    }

    public void resetDomainParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam4();
            return;
        }
        this.domainparam4DirtyFlag = false;
        this.domainparam4 = null;
    }

    public void setDomainParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam5(n);
            return;
        }
        this.domainparam5 = n;
        this.domainparam5DirtyFlag = true;
    }

    public Integer getDomainParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam5();
        }
        return this.domainparam5;
    }

    public boolean isDomainParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParam5Dirty();
        }
        return this.domainparam5DirtyFlag;
    }

    public void resetDomainParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam5();
            return;
        }
        this.domainparam5DirtyFlag = false;
        this.domainparam5 = null;
    }

    public void setDomainParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParam6(n);
            return;
        }
        this.domainparam6 = n;
        this.domainparam6DirtyFlag = true;
    }

    public Integer getDomainParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParam6();
        }
        return this.domainparam6;
    }

    public boolean isDomainParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParam6Dirty();
        }
        return this.domainparam6DirtyFlag;
    }

    public void resetDomainParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParam6();
            return;
        }
        this.domainparam6DirtyFlag = false;
        this.domainparam6 = null;
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

    public void setIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr2();
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

    public void setSyncData(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData(n);
            return;
        }
        this.syncdata = n;
        this.syncdataDirtyFlag = true;
    }

    public Integer getSyncData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData();
        }
        return this.syncdata;
    }

    public boolean isSyncDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncDataDirty();
        }
        return this.syncdataDirtyFlag;
    }

    public void resetSyncData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData();
            return;
        }
        this.syncdataDirtyFlag = false;
        this.syncdata = null;
    }

    public void setSyncData10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData10(n);
            return;
        }
        this.syncdata10 = n;
        this.syncdata10DirtyFlag = true;
    }

    public Integer getSyncData10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData10();
        }
        return this.syncdata10;
    }

    public boolean isSyncData10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData10Dirty();
        }
        return this.syncdata10DirtyFlag;
    }

    public void resetSyncData10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData10();
            return;
        }
        this.syncdata10DirtyFlag = false;
        this.syncdata10 = null;
    }

    public void setSyncData2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData2(n);
            return;
        }
        this.syncdata2 = n;
        this.syncdata2DirtyFlag = true;
    }

    public Integer getSyncData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData2();
        }
        return this.syncdata2;
    }

    public boolean isSyncData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData2Dirty();
        }
        return this.syncdata2DirtyFlag;
    }

    public void resetSyncData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData2();
            return;
        }
        this.syncdata2DirtyFlag = false;
        this.syncdata2 = null;
    }

    public void setSyncData3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData3(n);
            return;
        }
        this.syncdata3 = n;
        this.syncdata3DirtyFlag = true;
    }

    public Integer getSyncData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData3();
        }
        return this.syncdata3;
    }

    public boolean isSyncData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData3Dirty();
        }
        return this.syncdata3DirtyFlag;
    }

    public void resetSyncData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData3();
            return;
        }
        this.syncdata3DirtyFlag = false;
        this.syncdata3 = null;
    }

    public void setSyncData4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData4(n);
            return;
        }
        this.syncdata4 = n;
        this.syncdata4DirtyFlag = true;
    }

    public Integer getSyncData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData4();
        }
        return this.syncdata4;
    }

    public boolean isSyncData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData4Dirty();
        }
        return this.syncdata4DirtyFlag;
    }

    public void resetSyncData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData4();
            return;
        }
        this.syncdata4DirtyFlag = false;
        this.syncdata4 = null;
    }

    public void setSyncData5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData5(n);
            return;
        }
        this.syncdata5 = n;
        this.syncdata5DirtyFlag = true;
    }

    public Integer getSyncData5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData5();
        }
        return this.syncdata5;
    }

    public boolean isSyncData5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData5Dirty();
        }
        return this.syncdata5DirtyFlag;
    }

    public void resetSyncData5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData5();
            return;
        }
        this.syncdata5DirtyFlag = false;
        this.syncdata5 = null;
    }

    public void setSyncData6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData6(n);
            return;
        }
        this.syncdata6 = n;
        this.syncdata6DirtyFlag = true;
    }

    public Integer getSyncData6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData6();
        }
        return this.syncdata6;
    }

    public boolean isSyncData6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData6Dirty();
        }
        return this.syncdata6DirtyFlag;
    }

    public void resetSyncData6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData6();
            return;
        }
        this.syncdata6DirtyFlag = false;
        this.syncdata6 = null;
    }

    public void setSyncData7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData7(n);
            return;
        }
        this.syncdata7 = n;
        this.syncdata7DirtyFlag = true;
    }

    public Integer getSyncData7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData7();
        }
        return this.syncdata7;
    }

    public boolean isSyncData7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData7Dirty();
        }
        return this.syncdata7DirtyFlag;
    }

    public void resetSyncData7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData7();
            return;
        }
        this.syncdata7DirtyFlag = false;
        this.syncdata7 = null;
    }

    public void setSyncData8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData8(n);
            return;
        }
        this.syncdata8 = n;
        this.syncdata8DirtyFlag = true;
    }

    public Integer getSyncData8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData8();
        }
        return this.syncdata8;
    }

    public boolean isSyncData8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData8Dirty();
        }
        return this.syncdata8DirtyFlag;
    }

    public void resetSyncData8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData8();
            return;
        }
        this.syncdata8DirtyFlag = false;
        this.syncdata8 = null;
    }

    public void setSyncData9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncData9(n);
            return;
        }
        this.syncdata9 = n;
        this.syncdata9DirtyFlag = true;
    }

    public Integer getSyncData9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncData9();
        }
        return this.syncdata9;
    }

    public boolean isSyncData9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncData9Dirty();
        }
        return this.syncdata9DirtyFlag;
    }

    public void resetSyncData9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncData9();
            return;
        }
        this.syncdata9DirtyFlag = false;
        this.syncdata9 = null;
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
        PSSvrDomainBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSvrDomainBase pSSvrDomainBase) {
        pSSvrDomainBase.resetCreateDate();
        pSSvrDomainBase.resetCreateMan();
        pSSvrDomainBase.resetDomainCode();
        pSSvrDomainBase.resetDomainParam();
        pSSvrDomainBase.resetDomainParam2();
        pSSvrDomainBase.resetDomainParam3();
        pSSvrDomainBase.resetDomainParam4();
        pSSvrDomainBase.resetDomainParam5();
        pSSvrDomainBase.resetDomainParam6();
        pSSvrDomainBase.resetDomainParams();
        pSSvrDomainBase.resetIpAddr();
        pSSvrDomainBase.resetIpAddr2();
        pSSvrDomainBase.resetMemo();
        pSSvrDomainBase.resetPSSvrDomainId();
        pSSvrDomainBase.resetPSSvrDomainName();
        pSSvrDomainBase.resetSyncData();
        pSSvrDomainBase.resetSyncData10();
        pSSvrDomainBase.resetSyncData2();
        pSSvrDomainBase.resetSyncData3();
        pSSvrDomainBase.resetSyncData4();
        pSSvrDomainBase.resetSyncData5();
        pSSvrDomainBase.resetSyncData6();
        pSSvrDomainBase.resetSyncData7();
        pSSvrDomainBase.resetSyncData8();
        pSSvrDomainBase.resetSyncData9();
        pSSvrDomainBase.resetUpdateDate();
        pSSvrDomainBase.resetUpdateMan();
        pSSvrDomainBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDomainCodeDirty()) {
            hashMap.put(FIELD_DOMAINCODE, this.getDomainCode());
        }
        if (!bl || this.isDomainParamDirty()) {
            hashMap.put(FIELD_DOMAINPARAM, this.getDomainParam());
        }
        if (!bl || this.isDomainParam2Dirty()) {
            hashMap.put(FIELD_DOMAINPARAM2, this.getDomainParam2());
        }
        if (!bl || this.isDomainParam3Dirty()) {
            hashMap.put(FIELD_DOMAINPARAM3, this.getDomainParam3());
        }
        if (!bl || this.isDomainParam4Dirty()) {
            hashMap.put(FIELD_DOMAINPARAM4, this.getDomainParam4());
        }
        if (!bl || this.isDomainParam5Dirty()) {
            hashMap.put(FIELD_DOMAINPARAM5, this.getDomainParam5());
        }
        if (!bl || this.isDomainParam6Dirty()) {
            hashMap.put(FIELD_DOMAINPARAM6, this.getDomainParam6());
        }
        if (!bl || this.isDomainParamsDirty()) {
            hashMap.put(FIELD_DOMAINPARAMS, this.getDomainParams());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isSyncDataDirty()) {
            hashMap.put(FIELD_SYNCDATA, this.getSyncData());
        }
        if (!bl || this.isSyncData10Dirty()) {
            hashMap.put(FIELD_SYNCDATA10, this.getSyncData10());
        }
        if (!bl || this.isSyncData2Dirty()) {
            hashMap.put(FIELD_SYNCDATA2, this.getSyncData2());
        }
        if (!bl || this.isSyncData3Dirty()) {
            hashMap.put(FIELD_SYNCDATA3, this.getSyncData3());
        }
        if (!bl || this.isSyncData4Dirty()) {
            hashMap.put(FIELD_SYNCDATA4, this.getSyncData4());
        }
        if (!bl || this.isSyncData5Dirty()) {
            hashMap.put(FIELD_SYNCDATA5, this.getSyncData5());
        }
        if (!bl || this.isSyncData6Dirty()) {
            hashMap.put(FIELD_SYNCDATA6, this.getSyncData6());
        }
        if (!bl || this.isSyncData7Dirty()) {
            hashMap.put(FIELD_SYNCDATA7, this.getSyncData7());
        }
        if (!bl || this.isSyncData8Dirty()) {
            hashMap.put(FIELD_SYNCDATA8, this.getSyncData8());
        }
        if (!bl || this.isSyncData9Dirty()) {
            hashMap.put(FIELD_SYNCDATA9, this.getSyncData9());
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
        return PSSvrDomainBase.get(this, n);
    }

    private static Object get(PSSvrDomainBase pSSvrDomainBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrDomainBase.getCreateDate();
            }
            case 1: {
                return pSSvrDomainBase.getCreateMan();
            }
            case 2: {
                return pSSvrDomainBase.getDomainCode();
            }
            case 3: {
                return pSSvrDomainBase.getDomainParam();
            }
            case 4: {
                return pSSvrDomainBase.getDomainParam2();
            }
            case 5: {
                return pSSvrDomainBase.getDomainParam3();
            }
            case 6: {
                return pSSvrDomainBase.getDomainParam4();
            }
            case 7: {
                return pSSvrDomainBase.getDomainParam5();
            }
            case 8: {
                return pSSvrDomainBase.getDomainParam6();
            }
            case 9: {
                return pSSvrDomainBase.getDomainParams();
            }
            case 10: {
                return pSSvrDomainBase.getIpAddr();
            }
            case 11: {
                return pSSvrDomainBase.getIpAddr2();
            }
            case 12: {
                return pSSvrDomainBase.getMemo();
            }
            case 13: {
                return pSSvrDomainBase.getPSSvrDomainId();
            }
            case 14: {
                return pSSvrDomainBase.getPSSvrDomainName();
            }
            case 15: {
                return pSSvrDomainBase.getSyncData();
            }
            case 16: {
                return pSSvrDomainBase.getSyncData10();
            }
            case 17: {
                return pSSvrDomainBase.getSyncData2();
            }
            case 18: {
                return pSSvrDomainBase.getSyncData3();
            }
            case 19: {
                return pSSvrDomainBase.getSyncData4();
            }
            case 20: {
                return pSSvrDomainBase.getSyncData5();
            }
            case 21: {
                return pSSvrDomainBase.getSyncData6();
            }
            case 22: {
                return pSSvrDomainBase.getSyncData7();
            }
            case 23: {
                return pSSvrDomainBase.getSyncData8();
            }
            case 24: {
                return pSSvrDomainBase.getSyncData9();
            }
            case 25: {
                return pSSvrDomainBase.getUpdateDate();
            }
            case 26: {
                return pSSvrDomainBase.getUpdateMan();
            }
            case 27: {
                return pSSvrDomainBase.getValidFlag();
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
        PSSvrDomainBase.set(this, n, object);
    }

    private static void set(PSSvrDomainBase pSSvrDomainBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSvrDomainBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSvrDomainBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSvrDomainBase.setDomainCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSvrDomainBase.setDomainParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSvrDomainBase.setDomainParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSvrDomainBase.setDomainParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSvrDomainBase.setDomainParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSvrDomainBase.setDomainParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSvrDomainBase.setDomainParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSvrDomainBase.setDomainParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSvrDomainBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSvrDomainBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSvrDomainBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSvrDomainBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSvrDomainBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSvrDomainBase.setSyncData(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSvrDomainBase.setSyncData10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSvrDomainBase.setSyncData2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSvrDomainBase.setSyncData3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSvrDomainBase.setSyncData4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSvrDomainBase.setSyncData5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSvrDomainBase.setSyncData6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSvrDomainBase.setSyncData7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSvrDomainBase.setSyncData8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSvrDomainBase.setSyncData9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSvrDomainBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSSvrDomainBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSvrDomainBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSvrDomainBase.isNull(this, n);
    }

    private static boolean isNull(PSSvrDomainBase pSSvrDomainBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrDomainBase.getCreateDate() == null;
            }
            case 1: {
                return pSSvrDomainBase.getCreateMan() == null;
            }
            case 2: {
                return pSSvrDomainBase.getDomainCode() == null;
            }
            case 3: {
                return pSSvrDomainBase.getDomainParam() == null;
            }
            case 4: {
                return pSSvrDomainBase.getDomainParam2() == null;
            }
            case 5: {
                return pSSvrDomainBase.getDomainParam3() == null;
            }
            case 6: {
                return pSSvrDomainBase.getDomainParam4() == null;
            }
            case 7: {
                return pSSvrDomainBase.getDomainParam5() == null;
            }
            case 8: {
                return pSSvrDomainBase.getDomainParam6() == null;
            }
            case 9: {
                return pSSvrDomainBase.getDomainParams() == null;
            }
            case 10: {
                return pSSvrDomainBase.getIpAddr() == null;
            }
            case 11: {
                return pSSvrDomainBase.getIpAddr2() == null;
            }
            case 12: {
                return pSSvrDomainBase.getMemo() == null;
            }
            case 13: {
                return pSSvrDomainBase.getPSSvrDomainId() == null;
            }
            case 14: {
                return pSSvrDomainBase.getPSSvrDomainName() == null;
            }
            case 15: {
                return pSSvrDomainBase.getSyncData() == null;
            }
            case 16: {
                return pSSvrDomainBase.getSyncData10() == null;
            }
            case 17: {
                return pSSvrDomainBase.getSyncData2() == null;
            }
            case 18: {
                return pSSvrDomainBase.getSyncData3() == null;
            }
            case 19: {
                return pSSvrDomainBase.getSyncData4() == null;
            }
            case 20: {
                return pSSvrDomainBase.getSyncData5() == null;
            }
            case 21: {
                return pSSvrDomainBase.getSyncData6() == null;
            }
            case 22: {
                return pSSvrDomainBase.getSyncData7() == null;
            }
            case 23: {
                return pSSvrDomainBase.getSyncData8() == null;
            }
            case 24: {
                return pSSvrDomainBase.getSyncData9() == null;
            }
            case 25: {
                return pSSvrDomainBase.getUpdateDate() == null;
            }
            case 26: {
                return pSSvrDomainBase.getUpdateMan() == null;
            }
            case 27: {
                return pSSvrDomainBase.getValidFlag() == null;
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
        return PSSvrDomainBase.contains(this, n);
    }

    private static boolean contains(PSSvrDomainBase pSSvrDomainBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrDomainBase.isCreateDateDirty();
            }
            case 1: {
                return pSSvrDomainBase.isCreateManDirty();
            }
            case 2: {
                return pSSvrDomainBase.isDomainCodeDirty();
            }
            case 3: {
                return pSSvrDomainBase.isDomainParamDirty();
            }
            case 4: {
                return pSSvrDomainBase.isDomainParam2Dirty();
            }
            case 5: {
                return pSSvrDomainBase.isDomainParam3Dirty();
            }
            case 6: {
                return pSSvrDomainBase.isDomainParam4Dirty();
            }
            case 7: {
                return pSSvrDomainBase.isDomainParam5Dirty();
            }
            case 8: {
                return pSSvrDomainBase.isDomainParam6Dirty();
            }
            case 9: {
                return pSSvrDomainBase.isDomainParamsDirty();
            }
            case 10: {
                return pSSvrDomainBase.isIpAddrDirty();
            }
            case 11: {
                return pSSvrDomainBase.isIpAddr2Dirty();
            }
            case 12: {
                return pSSvrDomainBase.isMemoDirty();
            }
            case 13: {
                return pSSvrDomainBase.isPSSvrDomainIdDirty();
            }
            case 14: {
                return pSSvrDomainBase.isPSSvrDomainNameDirty();
            }
            case 15: {
                return pSSvrDomainBase.isSyncDataDirty();
            }
            case 16: {
                return pSSvrDomainBase.isSyncData10Dirty();
            }
            case 17: {
                return pSSvrDomainBase.isSyncData2Dirty();
            }
            case 18: {
                return pSSvrDomainBase.isSyncData3Dirty();
            }
            case 19: {
                return pSSvrDomainBase.isSyncData4Dirty();
            }
            case 20: {
                return pSSvrDomainBase.isSyncData5Dirty();
            }
            case 21: {
                return pSSvrDomainBase.isSyncData6Dirty();
            }
            case 22: {
                return pSSvrDomainBase.isSyncData7Dirty();
            }
            case 23: {
                return pSSvrDomainBase.isSyncData8Dirty();
            }
            case 24: {
                return pSSvrDomainBase.isSyncData9Dirty();
            }
            case 25: {
                return pSSvrDomainBase.isUpdateDateDirty();
            }
            case 26: {
                return pSSvrDomainBase.isUpdateManDirty();
            }
            case 27: {
                return pSSvrDomainBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSvrDomainBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSvrDomainBase pSSvrDomainBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSvrDomainBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domaincode", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainCode()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam2", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam2()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam3", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam3()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam4", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam4()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam5", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam5()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparam6", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParam6()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getDomainParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparams", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getDomainParams()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getMemo()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata10", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData10()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata2", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData2()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata3", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData3()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata4", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData4()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata5", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData5()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata6", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData6()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata7", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData7()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata8", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData8()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getSyncData9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdata9", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getSyncData9()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSvrDomainBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSvrDomainBase.getJSONValue((Object)pSSvrDomainBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSvrDomainBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSvrDomainBase pSSvrDomainBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSvrDomainBase.getCreateDate() != null) {
            object = pSSvrDomainBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrDomainBase.getCreateMan() != null) {
            object = pSSvrDomainBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainCode() != null) {
            object = pSSvrDomainBase.getDomainCode();
            xmlNode.setAttribute(FIELD_DOMAINCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainParam() != null) {
            object = pSSvrDomainBase.getDomainParam();
            xmlNode.setAttribute(FIELD_DOMAINPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainParam2() != null) {
            object = pSSvrDomainBase.getDomainParam2();
            xmlNode.setAttribute(FIELD_DOMAINPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainParam3() != null) {
            object = pSSvrDomainBase.getDomainParam3();
            xmlNode.setAttribute(FIELD_DOMAINPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainParam4() != null) {
            object = pSSvrDomainBase.getDomainParam4();
            xmlNode.setAttribute(FIELD_DOMAINPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getDomainParam5() != null) {
            object = pSSvrDomainBase.getDomainParam5();
            xmlNode.setAttribute(FIELD_DOMAINPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getDomainParam6() != null) {
            object = pSSvrDomainBase.getDomainParam6();
            xmlNode.setAttribute(FIELD_DOMAINPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getDomainParams() != null) {
            object = pSSvrDomainBase.getDomainParams();
            xmlNode.setAttribute(FIELD_DOMAINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getIpAddr() != null) {
            object = pSSvrDomainBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getIpAddr2() != null) {
            object = pSSvrDomainBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getMemo() != null) {
            object = pSSvrDomainBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getPSSvrDomainId() != null) {
            object = pSSvrDomainBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getPSSvrDomainName() != null) {
            object = pSSvrDomainBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getSyncData() != null) {
            object = pSSvrDomainBase.getSyncData();
            xmlNode.setAttribute(FIELD_SYNCDATA, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData10() != null) {
            object = pSSvrDomainBase.getSyncData10();
            xmlNode.setAttribute(FIELD_SYNCDATA10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData2() != null) {
            object = pSSvrDomainBase.getSyncData2();
            xmlNode.setAttribute(FIELD_SYNCDATA2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData3() != null) {
            object = pSSvrDomainBase.getSyncData3();
            xmlNode.setAttribute(FIELD_SYNCDATA3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData4() != null) {
            object = pSSvrDomainBase.getSyncData4();
            xmlNode.setAttribute(FIELD_SYNCDATA4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData5() != null) {
            object = pSSvrDomainBase.getSyncData5();
            xmlNode.setAttribute(FIELD_SYNCDATA5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData6() != null) {
            object = pSSvrDomainBase.getSyncData6();
            xmlNode.setAttribute(FIELD_SYNCDATA6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData7() != null) {
            object = pSSvrDomainBase.getSyncData7();
            xmlNode.setAttribute(FIELD_SYNCDATA7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData8() != null) {
            object = pSSvrDomainBase.getSyncData8();
            xmlNode.setAttribute(FIELD_SYNCDATA8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getSyncData9() != null) {
            object = pSSvrDomainBase.getSyncData9();
            xmlNode.setAttribute(FIELD_SYNCDATA9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSvrDomainBase.getUpdateDate() != null) {
            object = pSSvrDomainBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrDomainBase.getUpdateMan() != null) {
            object = pSSvrDomainBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrDomainBase.getValidFlag() != null) {
            object = pSSvrDomainBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSvrDomainBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSvrDomainBase pSSvrDomainBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSvrDomainBase.isCreateDateDirty() && (bl || pSSvrDomainBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSvrDomainBase.getCreateDate());
        }
        if (pSSvrDomainBase.isCreateManDirty() && (bl || pSSvrDomainBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSvrDomainBase.getCreateMan());
        }
        if (pSSvrDomainBase.isDomainCodeDirty() && (bl || pSSvrDomainBase.getDomainCode() != null)) {
            iDataObject.set(FIELD_DOMAINCODE, (Object)pSSvrDomainBase.getDomainCode());
        }
        if (pSSvrDomainBase.isDomainParamDirty() && (bl || pSSvrDomainBase.getDomainParam() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM, (Object)pSSvrDomainBase.getDomainParam());
        }
        if (pSSvrDomainBase.isDomainParam2Dirty() && (bl || pSSvrDomainBase.getDomainParam2() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM2, (Object)pSSvrDomainBase.getDomainParam2());
        }
        if (pSSvrDomainBase.isDomainParam3Dirty() && (bl || pSSvrDomainBase.getDomainParam3() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM3, (Object)pSSvrDomainBase.getDomainParam3());
        }
        if (pSSvrDomainBase.isDomainParam4Dirty() && (bl || pSSvrDomainBase.getDomainParam4() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM4, (Object)pSSvrDomainBase.getDomainParam4());
        }
        if (pSSvrDomainBase.isDomainParam5Dirty() && (bl || pSSvrDomainBase.getDomainParam5() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM5, (Object)pSSvrDomainBase.getDomainParam5());
        }
        if (pSSvrDomainBase.isDomainParam6Dirty() && (bl || pSSvrDomainBase.getDomainParam6() != null)) {
            iDataObject.set(FIELD_DOMAINPARAM6, (Object)pSSvrDomainBase.getDomainParam6());
        }
        if (pSSvrDomainBase.isDomainParamsDirty() && (bl || pSSvrDomainBase.getDomainParams() != null)) {
            iDataObject.set(FIELD_DOMAINPARAMS, (Object)pSSvrDomainBase.getDomainParams());
        }
        if (pSSvrDomainBase.isIpAddrDirty() && (bl || pSSvrDomainBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSSvrDomainBase.getIpAddr());
        }
        if (pSSvrDomainBase.isIpAddr2Dirty() && (bl || pSSvrDomainBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSSvrDomainBase.getIpAddr2());
        }
        if (pSSvrDomainBase.isMemoDirty() && (bl || pSSvrDomainBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSvrDomainBase.getMemo());
        }
        if (pSSvrDomainBase.isPSSvrDomainIdDirty() && (bl || pSSvrDomainBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSvrDomainBase.getPSSvrDomainId());
        }
        if (pSSvrDomainBase.isPSSvrDomainNameDirty() && (bl || pSSvrDomainBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSvrDomainBase.getPSSvrDomainName());
        }
        if (pSSvrDomainBase.isSyncDataDirty() && (bl || pSSvrDomainBase.getSyncData() != null)) {
            iDataObject.set(FIELD_SYNCDATA, (Object)pSSvrDomainBase.getSyncData());
        }
        if (pSSvrDomainBase.isSyncData10Dirty() && (bl || pSSvrDomainBase.getSyncData10() != null)) {
            iDataObject.set(FIELD_SYNCDATA10, (Object)pSSvrDomainBase.getSyncData10());
        }
        if (pSSvrDomainBase.isSyncData2Dirty() && (bl || pSSvrDomainBase.getSyncData2() != null)) {
            iDataObject.set(FIELD_SYNCDATA2, (Object)pSSvrDomainBase.getSyncData2());
        }
        if (pSSvrDomainBase.isSyncData3Dirty() && (bl || pSSvrDomainBase.getSyncData3() != null)) {
            iDataObject.set(FIELD_SYNCDATA3, (Object)pSSvrDomainBase.getSyncData3());
        }
        if (pSSvrDomainBase.isSyncData4Dirty() && (bl || pSSvrDomainBase.getSyncData4() != null)) {
            iDataObject.set(FIELD_SYNCDATA4, (Object)pSSvrDomainBase.getSyncData4());
        }
        if (pSSvrDomainBase.isSyncData5Dirty() && (bl || pSSvrDomainBase.getSyncData5() != null)) {
            iDataObject.set(FIELD_SYNCDATA5, (Object)pSSvrDomainBase.getSyncData5());
        }
        if (pSSvrDomainBase.isSyncData6Dirty() && (bl || pSSvrDomainBase.getSyncData6() != null)) {
            iDataObject.set(FIELD_SYNCDATA6, (Object)pSSvrDomainBase.getSyncData6());
        }
        if (pSSvrDomainBase.isSyncData7Dirty() && (bl || pSSvrDomainBase.getSyncData7() != null)) {
            iDataObject.set(FIELD_SYNCDATA7, (Object)pSSvrDomainBase.getSyncData7());
        }
        if (pSSvrDomainBase.isSyncData8Dirty() && (bl || pSSvrDomainBase.getSyncData8() != null)) {
            iDataObject.set(FIELD_SYNCDATA8, (Object)pSSvrDomainBase.getSyncData8());
        }
        if (pSSvrDomainBase.isSyncData9Dirty() && (bl || pSSvrDomainBase.getSyncData9() != null)) {
            iDataObject.set(FIELD_SYNCDATA9, (Object)pSSvrDomainBase.getSyncData9());
        }
        if (pSSvrDomainBase.isUpdateDateDirty() && (bl || pSSvrDomainBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSvrDomainBase.getUpdateDate());
        }
        if (pSSvrDomainBase.isUpdateManDirty() && (bl || pSSvrDomainBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSvrDomainBase.getUpdateMan());
        }
        if (pSSvrDomainBase.isValidFlagDirty() && (bl || pSSvrDomainBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSvrDomainBase.getValidFlag());
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
        return PSSvrDomainBase.remove(this, n);
    }

    private static boolean remove(PSSvrDomainBase pSSvrDomainBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSvrDomainBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSvrDomainBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSvrDomainBase.resetDomainCode();
                return true;
            }
            case 3: {
                pSSvrDomainBase.resetDomainParam();
                return true;
            }
            case 4: {
                pSSvrDomainBase.resetDomainParam2();
                return true;
            }
            case 5: {
                pSSvrDomainBase.resetDomainParam3();
                return true;
            }
            case 6: {
                pSSvrDomainBase.resetDomainParam4();
                return true;
            }
            case 7: {
                pSSvrDomainBase.resetDomainParam5();
                return true;
            }
            case 8: {
                pSSvrDomainBase.resetDomainParam6();
                return true;
            }
            case 9: {
                pSSvrDomainBase.resetDomainParams();
                return true;
            }
            case 10: {
                pSSvrDomainBase.resetIpAddr();
                return true;
            }
            case 11: {
                pSSvrDomainBase.resetIpAddr2();
                return true;
            }
            case 12: {
                pSSvrDomainBase.resetMemo();
                return true;
            }
            case 13: {
                pSSvrDomainBase.resetPSSvrDomainId();
                return true;
            }
            case 14: {
                pSSvrDomainBase.resetPSSvrDomainName();
                return true;
            }
            case 15: {
                pSSvrDomainBase.resetSyncData();
                return true;
            }
            case 16: {
                pSSvrDomainBase.resetSyncData10();
                return true;
            }
            case 17: {
                pSSvrDomainBase.resetSyncData2();
                return true;
            }
            case 18: {
                pSSvrDomainBase.resetSyncData3();
                return true;
            }
            case 19: {
                pSSvrDomainBase.resetSyncData4();
                return true;
            }
            case 20: {
                pSSvrDomainBase.resetSyncData5();
                return true;
            }
            case 21: {
                pSSvrDomainBase.resetSyncData6();
                return true;
            }
            case 22: {
                pSSvrDomainBase.resetSyncData7();
                return true;
            }
            case 23: {
                pSSvrDomainBase.resetSyncData8();
                return true;
            }
            case 24: {
                pSSvrDomainBase.resetSyncData9();
                return true;
            }
            case 25: {
                pSSvrDomainBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSSvrDomainBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSSvrDomainBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSASBooking> getPSASBooking() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBooking();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSASBookingService pSASBookingService = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSASBookingLock;
        synchronized (n) {
            if (this.psasbooking == null) {
                this.psasbooking = pSASBookingService.selectByPSSvrDomain(this);
            }
            return this.psasbooking;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCredential> getPSCredentials() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentials();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCredentialsLock;
        synchronized (n) {
            if (this.pscredentials == null) {
                this.pscredentials = pSCredentialService.selectByPSSvrDomain(this);
            }
            return this.pscredentials;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDeployCenter> getPSDeployCenters() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenters();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSDeployCenterService pSDeployCenterService = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDeployCentersLock;
        synchronized (n) {
            if (this.psdeploycenters == null) {
                this.psdeploycenters = pSDeployCenterService.selectByPSSvrDomain(this);
            }
            return this.psdeploycenters;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDeployServer> getPSDeployServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployServers();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSDeployServerService pSDeployServerService = (PSDeployServerService)ServiceGlobal.getService(PSDeployServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDeployServersLock;
        synchronized (n) {
            if (this.psdeployservers == null) {
                this.psdeployservers = pSDeployServerService.selectByPSSvrDomain(this);
            }
            return this.psdeployservers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMSPlatform> getPSMSPlatforms() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatforms();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSMSPlatformService pSMSPlatformService = (PSMSPlatformService)ServiceGlobal.getService(PSMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMSPlatformsLock;
        synchronized (n) {
            if (this.psmsplatforms == null) {
                this.psmsplatforms = pSMSPlatformService.selectByPSSvrDomain(this);
            }
            return this.psmsplatforms;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSROSServer> getPSROSServers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSROSServers();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        PSROSServerService pSROSServerService = (PSROSServerService)ServiceGlobal.getService(PSROSServerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSROSServersLock;
        synchronized (n) {
            if (this.psrosservers == null) {
                this.psrosservers = pSROSServerService.selectByPSSvrDomain(this);
            }
            return this.psrosservers;
        }
    }

    private PSSvrDomainBase getProxyEntity() {
        return this.proxyPSSvrDomainBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSvrDomainBase = null;
        if (iDataObject != null && iDataObject instanceof PSSvrDomainBase) {
            this.proxyPSSvrDomainBase = (PSSvrDomainBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DOMAINCODE, 2);
        fieldIndexMap.put(FIELD_DOMAINPARAM, 3);
        fieldIndexMap.put(FIELD_DOMAINPARAM2, 4);
        fieldIndexMap.put(FIELD_DOMAINPARAM3, 5);
        fieldIndexMap.put(FIELD_DOMAINPARAM4, 6);
        fieldIndexMap.put(FIELD_DOMAINPARAM5, 7);
        fieldIndexMap.put(FIELD_DOMAINPARAM6, 8);
        fieldIndexMap.put(FIELD_DOMAINPARAMS, 9);
        fieldIndexMap.put(FIELD_IPADDR, 10);
        fieldIndexMap.put(FIELD_IPADDR2, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 13);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 14);
        fieldIndexMap.put(FIELD_SYNCDATA, 15);
        fieldIndexMap.put(FIELD_SYNCDATA10, 16);
        fieldIndexMap.put(FIELD_SYNCDATA2, 17);
        fieldIndexMap.put(FIELD_SYNCDATA3, 18);
        fieldIndexMap.put(FIELD_SYNCDATA4, 19);
        fieldIndexMap.put(FIELD_SYNCDATA5, 20);
        fieldIndexMap.put(FIELD_SYNCDATA6, 21);
        fieldIndexMap.put(FIELD_SYNCDATA7, 22);
        fieldIndexMap.put(FIELD_SYNCDATA8, 23);
        fieldIndexMap.put(FIELD_SYNCDATA9, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

