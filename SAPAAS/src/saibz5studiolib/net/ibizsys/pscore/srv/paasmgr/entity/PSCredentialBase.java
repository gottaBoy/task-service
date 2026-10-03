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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCredentialBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCredentialBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREDENTIALDATA = "CREDENTIALDATA";
    public static final String FIELD_CREDENTIALTAG = "CREDENTIALTAG";
    public static final String FIELD_CREDENTIALTAG2 = "CREDENTIALTAG2";
    public static final String FIELD_CREDENTIALTYPE = "CREDENTIALTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PASSWDDATA = "PASSWDDATA";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SYNCMODE = "SYNCMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CREDENTIALDATA = 3;
    private static final int INDEX_CREDENTIALTAG = 4;
    private static final int INDEX_CREDENTIALTAG2 = 5;
    private static final int INDEX_CREDENTIALTYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PASSWD = 8;
    private static final int INDEX_PASSWDDATA = 9;
    private static final int INDEX_PSCREDENTIALID = 10;
    private static final int INDEX_PSCREDENTIALNAME = 11;
    private static final int INDEX_PSDEVCENTERID = 12;
    private static final int INDEX_PSDEVCENTERNAME = 13;
    private static final int INDEX_PSDEVSLNID = 14;
    private static final int INDEX_PSDEVSLNNAME = 15;
    private static final int INDEX_PSSVRDOMAINID = 16;
    private static final int INDEX_PSSVRDOMAINNAME = 17;
    private static final int INDEX_SYNCMODE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERNAME = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCredentialBase proxyPSCredentialBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean credentialdataDirtyFlag = false;
    private boolean credentialtagDirtyFlag = false;
    private boolean credentialtag2DirtyFlag = false;
    private boolean credentialtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean passwddataDirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean syncmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="credentialdata")
    private String credentialdata;
    @Column(name="credentialtag")
    private String credentialtag;
    @Column(name="credentialtag2")
    private String credentialtag2;
    @Column(name="credentialtype")
    private String credentialtype;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="passwddata")
    private String passwddata;
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="syncmode")
    private Integer syncmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
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

    public void setCredentialData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.credentialdata = string;
        this.credentialdataDirtyFlag = true;
    }

    public String getCredentialData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialData();
        }
        return this.credentialdata;
    }

    public boolean isCredentialDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialDataDirty();
        }
        return this.credentialdataDirtyFlag;
    }

    public void resetCredentialData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialData();
            return;
        }
        this.credentialdataDirtyFlag = false;
        this.credentialdata = null;
    }

    public void setCredentialTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.credentialtag = string;
        this.credentialtagDirtyFlag = true;
    }

    public String getCredentialTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialTag();
        }
        return this.credentialtag;
    }

    public boolean isCredentialTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialTagDirty();
        }
        return this.credentialtagDirtyFlag;
    }

    public void resetCredentialTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialTag();
            return;
        }
        this.credentialtagDirtyFlag = false;
        this.credentialtag = null;
    }

    public void setCredentialTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.credentialtag2 = string;
        this.credentialtag2DirtyFlag = true;
    }

    public String getCredentialTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialTag2();
        }
        return this.credentialtag2;
    }

    public boolean isCredentialTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialTag2Dirty();
        }
        return this.credentialtag2DirtyFlag;
    }

    public void resetCredentialTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialTag2();
            return;
        }
        this.credentialtag2DirtyFlag = false;
        this.credentialtag2 = null;
    }

    public void setCredentialType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.credentialtype = string;
        this.credentialtypeDirtyFlag = true;
    }

    public String getCredentialType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialType();
        }
        return this.credentialtype;
    }

    public boolean isCredentialTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialTypeDirty();
        }
        return this.credentialtypeDirtyFlag;
    }

    public void resetCredentialType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialType();
            return;
        }
        this.credentialtypeDirtyFlag = false;
        this.credentialtype = null;
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

    public void setPasswdData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswdData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwddata = string;
        this.passwddataDirtyFlag = true;
    }

    public String getPasswdData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswdData();
        }
        return this.passwddata;
    }

    public boolean isPasswdDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDataDirty();
        }
        return this.passwddataDirtyFlag;
    }

    public void resetPasswdData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswdData();
            return;
        }
        this.passwddataDirtyFlag = false;
        this.passwddata = null;
    }

    public void setPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialid = string;
        this.pscredentialidDirtyFlag = true;
    }

    public String getPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialId();
        }
        return this.pscredentialid;
    }

    public boolean isPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialIdDirty();
        }
        return this.pscredentialidDirtyFlag;
    }

    public void resetPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialId();
            return;
        }
        this.pscredentialidDirtyFlag = false;
        this.pscredentialid = null;
    }

    public void setPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialname = string;
        this.pscredentialnameDirtyFlag = true;
    }

    public String getPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialName();
        }
        return this.pscredentialname;
    }

    public boolean isPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialNameDirty();
        }
        return this.pscredentialnameDirtyFlag;
    }

    public void resetPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialName();
            return;
        }
        this.pscredentialnameDirtyFlag = false;
        this.pscredentialname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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

    public void setSyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncMode(n);
            return;
        }
        this.syncmode = n;
        this.syncmodeDirtyFlag = true;
    }

    public Integer getSyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncMode();
        }
        return this.syncmode;
    }

    public boolean isSyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncModeDirty();
        }
        return this.syncmodeDirtyFlag;
    }

    public void resetSyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncMode();
            return;
        }
        this.syncmodeDirtyFlag = false;
        this.syncmode = null;
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
        PSCredentialBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCredentialBase pSCredentialBase) {
        pSCredentialBase.resetAllDCFlag();
        pSCredentialBase.resetCreateDate();
        pSCredentialBase.resetCreateMan();
        pSCredentialBase.resetCredentialData();
        pSCredentialBase.resetCredentialTag();
        pSCredentialBase.resetCredentialTag2();
        pSCredentialBase.resetCredentialType();
        pSCredentialBase.resetMemo();
        pSCredentialBase.resetPasswd();
        pSCredentialBase.resetPasswdData();
        pSCredentialBase.resetPSCredentialId();
        pSCredentialBase.resetPSCredentialName();
        pSCredentialBase.resetPSDevCenterId();
        pSCredentialBase.resetPSDevCenterName();
        pSCredentialBase.resetPSDevSlnId();
        pSCredentialBase.resetPSDevSlnName();
        pSCredentialBase.resetPSSvrDomainId();
        pSCredentialBase.resetPSSvrDomainName();
        pSCredentialBase.resetSyncMode();
        pSCredentialBase.resetUpdateDate();
        pSCredentialBase.resetUpdateMan();
        pSCredentialBase.resetUserName();
        pSCredentialBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCredentialDataDirty()) {
            hashMap.put(FIELD_CREDENTIALDATA, this.getCredentialData());
        }
        if (!bl || this.isCredentialTagDirty()) {
            hashMap.put(FIELD_CREDENTIALTAG, this.getCredentialTag());
        }
        if (!bl || this.isCredentialTag2Dirty()) {
            hashMap.put(FIELD_CREDENTIALTAG2, this.getCredentialTag2());
        }
        if (!bl || this.isCredentialTypeDirty()) {
            hashMap.put(FIELD_CREDENTIALTYPE, this.getCredentialType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPasswdDataDirty()) {
            hashMap.put(FIELD_PASSWDDATA, this.getPasswdData());
        }
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isSyncModeDirty()) {
            hashMap.put(FIELD_SYNCMODE, this.getSyncMode());
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
        return PSCredentialBase.get(this, n);
    }

    private static Object get(PSCredentialBase pSCredentialBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCredentialBase.getAllDCFlag();
            }
            case 1: {
                return pSCredentialBase.getCreateDate();
            }
            case 2: {
                return pSCredentialBase.getCreateMan();
            }
            case 3: {
                return pSCredentialBase.getCredentialData();
            }
            case 4: {
                return pSCredentialBase.getCredentialTag();
            }
            case 5: {
                return pSCredentialBase.getCredentialTag2();
            }
            case 6: {
                return pSCredentialBase.getCredentialType();
            }
            case 7: {
                return pSCredentialBase.getMemo();
            }
            case 8: {
                return pSCredentialBase.getPasswd();
            }
            case 9: {
                return pSCredentialBase.getPasswdData();
            }
            case 10: {
                return pSCredentialBase.getPSCredentialId();
            }
            case 11: {
                return pSCredentialBase.getPSCredentialName();
            }
            case 12: {
                return pSCredentialBase.getPSDevCenterId();
            }
            case 13: {
                return pSCredentialBase.getPSDevCenterName();
            }
            case 14: {
                return pSCredentialBase.getPSDevSlnId();
            }
            case 15: {
                return pSCredentialBase.getPSDevSlnName();
            }
            case 16: {
                return pSCredentialBase.getPSSvrDomainId();
            }
            case 17: {
                return pSCredentialBase.getPSSvrDomainName();
            }
            case 18: {
                return pSCredentialBase.getSyncMode();
            }
            case 19: {
                return pSCredentialBase.getUpdateDate();
            }
            case 20: {
                return pSCredentialBase.getUpdateMan();
            }
            case 21: {
                return pSCredentialBase.getUserName();
            }
            case 22: {
                return pSCredentialBase.getValidFlag();
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
        PSCredentialBase.set(this, n, object);
    }

    private static void set(PSCredentialBase pSCredentialBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCredentialBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSCredentialBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCredentialBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCredentialBase.setCredentialData(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCredentialBase.setCredentialTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCredentialBase.setCredentialTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCredentialBase.setCredentialType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCredentialBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCredentialBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCredentialBase.setPasswdData(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCredentialBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCredentialBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCredentialBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCredentialBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCredentialBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCredentialBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCredentialBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCredentialBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCredentialBase.setSyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSCredentialBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSCredentialBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCredentialBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCredentialBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCredentialBase.isNull(this, n);
    }

    private static boolean isNull(PSCredentialBase pSCredentialBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCredentialBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSCredentialBase.getCreateDate() == null;
            }
            case 2: {
                return pSCredentialBase.getCreateMan() == null;
            }
            case 3: {
                return pSCredentialBase.getCredentialData() == null;
            }
            case 4: {
                return pSCredentialBase.getCredentialTag() == null;
            }
            case 5: {
                return pSCredentialBase.getCredentialTag2() == null;
            }
            case 6: {
                return pSCredentialBase.getCredentialType() == null;
            }
            case 7: {
                return pSCredentialBase.getMemo() == null;
            }
            case 8: {
                return pSCredentialBase.getPasswd() == null;
            }
            case 9: {
                return pSCredentialBase.getPasswdData() == null;
            }
            case 10: {
                return pSCredentialBase.getPSCredentialId() == null;
            }
            case 11: {
                return pSCredentialBase.getPSCredentialName() == null;
            }
            case 12: {
                return pSCredentialBase.getPSDevCenterId() == null;
            }
            case 13: {
                return pSCredentialBase.getPSDevCenterName() == null;
            }
            case 14: {
                return pSCredentialBase.getPSDevSlnId() == null;
            }
            case 15: {
                return pSCredentialBase.getPSDevSlnName() == null;
            }
            case 16: {
                return pSCredentialBase.getPSSvrDomainId() == null;
            }
            case 17: {
                return pSCredentialBase.getPSSvrDomainName() == null;
            }
            case 18: {
                return pSCredentialBase.getSyncMode() == null;
            }
            case 19: {
                return pSCredentialBase.getUpdateDate() == null;
            }
            case 20: {
                return pSCredentialBase.getUpdateMan() == null;
            }
            case 21: {
                return pSCredentialBase.getUserName() == null;
            }
            case 22: {
                return pSCredentialBase.getValidFlag() == null;
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
        return PSCredentialBase.contains(this, n);
    }

    private static boolean contains(PSCredentialBase pSCredentialBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCredentialBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSCredentialBase.isCreateDateDirty();
            }
            case 2: {
                return pSCredentialBase.isCreateManDirty();
            }
            case 3: {
                return pSCredentialBase.isCredentialDataDirty();
            }
            case 4: {
                return pSCredentialBase.isCredentialTagDirty();
            }
            case 5: {
                return pSCredentialBase.isCredentialTag2Dirty();
            }
            case 6: {
                return pSCredentialBase.isCredentialTypeDirty();
            }
            case 7: {
                return pSCredentialBase.isMemoDirty();
            }
            case 8: {
                return pSCredentialBase.isPasswdDirty();
            }
            case 9: {
                return pSCredentialBase.isPasswdDataDirty();
            }
            case 10: {
                return pSCredentialBase.isPSCredentialIdDirty();
            }
            case 11: {
                return pSCredentialBase.isPSCredentialNameDirty();
            }
            case 12: {
                return pSCredentialBase.isPSDevCenterIdDirty();
            }
            case 13: {
                return pSCredentialBase.isPSDevCenterNameDirty();
            }
            case 14: {
                return pSCredentialBase.isPSDevSlnIdDirty();
            }
            case 15: {
                return pSCredentialBase.isPSDevSlnNameDirty();
            }
            case 16: {
                return pSCredentialBase.isPSSvrDomainIdDirty();
            }
            case 17: {
                return pSCredentialBase.isPSSvrDomainNameDirty();
            }
            case 18: {
                return pSCredentialBase.isSyncModeDirty();
            }
            case 19: {
                return pSCredentialBase.isUpdateDateDirty();
            }
            case 20: {
                return pSCredentialBase.isUpdateManDirty();
            }
            case 21: {
                return pSCredentialBase.isUserNameDirty();
            }
            case 22: {
                return pSCredentialBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCredentialBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCredentialBase pSCredentialBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCredentialBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCredentialData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialdata", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCredentialData()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCredentialTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialtag", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCredentialTag()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCredentialTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialtag2", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCredentialTag2()), (boolean)false);
        }
        if (bl || pSCredentialBase.getCredentialType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialtype", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getCredentialType()), (boolean)false);
        }
        if (bl || pSCredentialBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getMemo()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPasswd()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPasswdData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwddata", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPasswdData()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSCredentialBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSCredentialBase.getSyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncmode", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getSyncMode()), (boolean)false);
        }
        if (bl || pSCredentialBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCredentialBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCredentialBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getUserName()), (boolean)false);
        }
        if (bl || pSCredentialBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCredentialBase.getJSONValue((Object)pSCredentialBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCredentialBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCredentialBase pSCredentialBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCredentialBase.getAllDCFlag() != null) {
            object = pSCredentialBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCredentialBase.getCreateDate() != null) {
            object = pSCredentialBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCredentialBase.getCreateMan() != null) {
            object = pSCredentialBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getCredentialData() != null) {
            object = pSCredentialBase.getCredentialData();
            xmlNode.setAttribute(FIELD_CREDENTIALDATA, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getCredentialTag() != null) {
            object = pSCredentialBase.getCredentialTag();
            xmlNode.setAttribute(FIELD_CREDENTIALTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getCredentialTag2() != null) {
            object = pSCredentialBase.getCredentialTag2();
            xmlNode.setAttribute(FIELD_CREDENTIALTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getCredentialType() != null) {
            object = pSCredentialBase.getCredentialType();
            xmlNode.setAttribute(FIELD_CREDENTIALTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getMemo() != null) {
            object = pSCredentialBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPasswd() != null) {
            object = pSCredentialBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPasswdData() != null) {
            object = pSCredentialBase.getPasswdData();
            xmlNode.setAttribute(FIELD_PASSWDDATA, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSCredentialId() != null) {
            object = pSCredentialBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSCredentialName() != null) {
            object = pSCredentialBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSDevCenterId() != null) {
            object = pSCredentialBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSDevCenterName() != null) {
            object = pSCredentialBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSDevSlnId() != null) {
            object = pSCredentialBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSDevSlnName() != null) {
            object = pSCredentialBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSSvrDomainId() != null) {
            object = pSCredentialBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getPSSvrDomainName() != null) {
            object = pSCredentialBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getSyncMode() != null) {
            object = pSCredentialBase.getSyncMode();
            xmlNode.setAttribute(FIELD_SYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCredentialBase.getUpdateDate() != null) {
            object = pSCredentialBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCredentialBase.getUpdateMan() != null) {
            object = pSCredentialBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getUserName() != null) {
            object = pSCredentialBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCredentialBase.getValidFlag() != null) {
            object = pSCredentialBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCredentialBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCredentialBase pSCredentialBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCredentialBase.isAllDCFlagDirty() && (bl || pSCredentialBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSCredentialBase.getAllDCFlag());
        }
        if (pSCredentialBase.isCreateDateDirty() && (bl || pSCredentialBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCredentialBase.getCreateDate());
        }
        if (pSCredentialBase.isCreateManDirty() && (bl || pSCredentialBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCredentialBase.getCreateMan());
        }
        if (pSCredentialBase.isCredentialDataDirty() && (bl || pSCredentialBase.getCredentialData() != null)) {
            iDataObject.set(FIELD_CREDENTIALDATA, (Object)pSCredentialBase.getCredentialData());
        }
        if (pSCredentialBase.isCredentialTagDirty() && (bl || pSCredentialBase.getCredentialTag() != null)) {
            iDataObject.set(FIELD_CREDENTIALTAG, (Object)pSCredentialBase.getCredentialTag());
        }
        if (pSCredentialBase.isCredentialTag2Dirty() && (bl || pSCredentialBase.getCredentialTag2() != null)) {
            iDataObject.set(FIELD_CREDENTIALTAG2, (Object)pSCredentialBase.getCredentialTag2());
        }
        if (pSCredentialBase.isCredentialTypeDirty() && (bl || pSCredentialBase.getCredentialType() != null)) {
            iDataObject.set(FIELD_CREDENTIALTYPE, (Object)pSCredentialBase.getCredentialType());
        }
        if (pSCredentialBase.isMemoDirty() && (bl || pSCredentialBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCredentialBase.getMemo());
        }
        if (pSCredentialBase.isPasswdDirty() && (bl || pSCredentialBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSCredentialBase.getPasswd());
        }
        if (pSCredentialBase.isPasswdDataDirty() && (bl || pSCredentialBase.getPasswdData() != null)) {
            iDataObject.set(FIELD_PASSWDDATA, (Object)pSCredentialBase.getPasswdData());
        }
        if (pSCredentialBase.isPSCredentialIdDirty() && (bl || pSCredentialBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSCredentialBase.getPSCredentialId());
        }
        if (pSCredentialBase.isPSCredentialNameDirty() && (bl || pSCredentialBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSCredentialBase.getPSCredentialName());
        }
        if (pSCredentialBase.isPSDevCenterIdDirty() && (bl || pSCredentialBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSCredentialBase.getPSDevCenterId());
        }
        if (pSCredentialBase.isPSDevCenterNameDirty() && (bl || pSCredentialBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSCredentialBase.getPSDevCenterName());
        }
        if (pSCredentialBase.isPSDevSlnIdDirty() && (bl || pSCredentialBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSCredentialBase.getPSDevSlnId());
        }
        if (pSCredentialBase.isPSDevSlnNameDirty() && (bl || pSCredentialBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSCredentialBase.getPSDevSlnName());
        }
        if (pSCredentialBase.isPSSvrDomainIdDirty() && (bl || pSCredentialBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSCredentialBase.getPSSvrDomainId());
        }
        if (pSCredentialBase.isPSSvrDomainNameDirty() && (bl || pSCredentialBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSCredentialBase.getPSSvrDomainName());
        }
        if (pSCredentialBase.isSyncModeDirty() && (bl || pSCredentialBase.getSyncMode() != null)) {
            iDataObject.set(FIELD_SYNCMODE, (Object)pSCredentialBase.getSyncMode());
        }
        if (pSCredentialBase.isUpdateDateDirty() && (bl || pSCredentialBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCredentialBase.getUpdateDate());
        }
        if (pSCredentialBase.isUpdateManDirty() && (bl || pSCredentialBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCredentialBase.getUpdateMan());
        }
        if (pSCredentialBase.isUserNameDirty() && (bl || pSCredentialBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSCredentialBase.getUserName());
        }
        if (pSCredentialBase.isValidFlagDirty() && (bl || pSCredentialBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCredentialBase.getValidFlag());
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
        return PSCredentialBase.remove(this, n);
    }

    private static boolean remove(PSCredentialBase pSCredentialBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCredentialBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSCredentialBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCredentialBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCredentialBase.resetCredentialData();
                return true;
            }
            case 4: {
                pSCredentialBase.resetCredentialTag();
                return true;
            }
            case 5: {
                pSCredentialBase.resetCredentialTag2();
                return true;
            }
            case 6: {
                pSCredentialBase.resetCredentialType();
                return true;
            }
            case 7: {
                pSCredentialBase.resetMemo();
                return true;
            }
            case 8: {
                pSCredentialBase.resetPasswd();
                return true;
            }
            case 9: {
                pSCredentialBase.resetPasswdData();
                return true;
            }
            case 10: {
                pSCredentialBase.resetPSCredentialId();
                return true;
            }
            case 11: {
                pSCredentialBase.resetPSCredentialName();
                return true;
            }
            case 12: {
                pSCredentialBase.resetPSDevCenterId();
                return true;
            }
            case 13: {
                pSCredentialBase.resetPSDevCenterName();
                return true;
            }
            case 14: {
                pSCredentialBase.resetPSDevSlnId();
                return true;
            }
            case 15: {
                pSCredentialBase.resetPSDevSlnName();
                return true;
            }
            case 16: {
                pSCredentialBase.resetPSSvrDomainId();
                return true;
            }
            case 17: {
                pSCredentialBase.resetPSSvrDomainName();
                return true;
            }
            case 18: {
                pSCredentialBase.resetSyncMode();
                return true;
            }
            case 19: {
                pSCredentialBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSCredentialBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSCredentialBase.resetUserName();
                return true;
            }
            case 22: {
                pSCredentialBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
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

    private PSCredentialBase getProxyEntity() {
        return this.proxyPSCredentialBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCredentialBase = null;
        if (iDataObject != null && iDataObject instanceof PSCredentialBase) {
            this.proxyPSCredentialBase = (PSCredentialBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CREDENTIALDATA, 3);
        fieldIndexMap.put(FIELD_CREDENTIALTAG, 4);
        fieldIndexMap.put(FIELD_CREDENTIALTAG2, 5);
        fieldIndexMap.put(FIELD_CREDENTIALTYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PASSWD, 8);
        fieldIndexMap.put(FIELD_PASSWDDATA, 9);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 10);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 15);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 16);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 17);
        fieldIndexMap.put(FIELD_SYNCMODE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERNAME, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

