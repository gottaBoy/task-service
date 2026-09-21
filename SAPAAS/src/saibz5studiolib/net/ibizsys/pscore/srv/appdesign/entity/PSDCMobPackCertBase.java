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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackTD;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMobPackCertBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMobPackCertBase.class);
    public static final String FIELD_ANDROIDCERTALIAS = "ANDROIDCERTALIAS";
    public static final String FIELD_ANDROIDCERTDOMAIN = "ANDROIDCERTDOMAIN";
    public static final String FIELD_ANDROIDCERTFILE = "ANDROIDCERTFILE";
    public static final String FIELD_ANDROIDCERTINFO = "ANDROIDCERTINFO";
    public static final String FIELD_ANDROIDCERTKEY = "ANDROIDCERTKEY";
    public static final String FIELD_ANDROIDCERTSTOREPWD = "ANDROIDCERTSTOREPWD";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IOSAPPIDS = "IOSAPPIDS";
    public static final String FIELD_IOSCERTINFO = "IOSCERTINFO";
    public static final String FIELD_IOSCERTPWD = "IOSCERTPWD";
    public static final String FIELD_IOSDISTMPCERT = "IOSDISTMPCERT";
    public static final String FIELD_IOSDISTP12CERT = "IOSDISTP12CERT";
    public static final String FIELD_IOSWKAMPCERT = "IOSWKAMPCERT";
    public static final String FIELD_IOSWKEMPCERT = "IOSWKEMPCERT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PACKTYPE = "PACKTYPE";
    public static final String FIELD_PSDCMOBPACKCERTID = "PSDCMOBPACKCERTID";
    public static final String FIELD_PSDCMOBPACKCERTNAME = "PSDCMOBPACKCERTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ANDROIDCERTALIAS = 0;
    private static final int INDEX_ANDROIDCERTDOMAIN = 1;
    private static final int INDEX_ANDROIDCERTFILE = 2;
    private static final int INDEX_ANDROIDCERTINFO = 3;
    private static final int INDEX_ANDROIDCERTKEY = 4;
    private static final int INDEX_ANDROIDCERTSTOREPWD = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_IOSAPPIDS = 8;
    private static final int INDEX_IOSCERTINFO = 9;
    private static final int INDEX_IOSCERTPWD = 10;
    private static final int INDEX_IOSDISTMPCERT = 11;
    private static final int INDEX_IOSDISTP12CERT = 12;
    private static final int INDEX_IOSWKAMPCERT = 13;
    private static final int INDEX_IOSWKEMPCERT = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PACKTYPE = 16;
    private static final int INDEX_PSDCMOBPACKCERTID = 17;
    private static final int INDEX_PSDCMOBPACKCERTNAME = 18;
    private static final int INDEX_PSDEVCENTERID = 19;
    private static final int INDEX_PSDEVCENTERNAME = 20;
    private static final int INDEX_PSSYSAPPID = 21;
    private static final int INDEX_PSSYSAPPNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMobPackCertBase proxyPSDCMobPackCertBase = null;
    private boolean androidcertaliasDirtyFlag = false;
    private boolean androidcertdomainDirtyFlag = false;
    private boolean androidcertfileDirtyFlag = false;
    private boolean androidcertinfoDirtyFlag = false;
    private boolean androidcertkeyDirtyFlag = false;
    private boolean androidcertstorepwdDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iosappidsDirtyFlag = false;
    private boolean ioscertinfoDirtyFlag = false;
    private boolean ioscertpwdDirtyFlag = false;
    private boolean iosdistmpcertDirtyFlag = false;
    private boolean iosdistp12certDirtyFlag = false;
    private boolean ioswkampcertDirtyFlag = false;
    private boolean ioswkempcertDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean packtypeDirtyFlag = false;
    private boolean psdcmobpackcertidDirtyFlag = false;
    private boolean psdcmobpackcertnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="androidcertalias")
    private String androidcertalias;
    @Column(name="androidcertdomain")
    private String androidcertdomain;
    @Column(name="androidcertfile")
    private String androidcertfile;
    @Column(name="androidcertinfo")
    private String androidcertinfo;
    @Column(name="androidcertkey")
    private String androidcertkey;
    @Column(name="androidcertstorepwd")
    private String androidcertstorepwd;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iosappids")
    private String iosappids;
    @Column(name="ioscertinfo")
    private String ioscertinfo;
    @Column(name="ioscertpwd")
    private String ioscertpwd;
    @Column(name="iosdistmpcert")
    private String iosdistmpcert;
    @Column(name="iosdistp12cert")
    private String iosdistp12cert;
    @Column(name="ioswkampcert")
    private String ioswkampcert;
    @Column(name="ioswkempcert")
    private String ioswkempcert;
    @Column(name="memo")
    private String memo;
    @Column(name="packtype")
    private String packtype;
    @Column(name="psdcmobpackcertid")
    private String psdcmobpackcertid;
    @Column(name="psdcmobpackcertname")
    private String psdcmobpackcertname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSMobAppPackTDsLock = new Integer(1);
    private ArrayList<PSMobAppPackTD> psmobapppacktds = null;

    public void setAndroidCertAlias(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidCertAlias(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertalias = string;
        this.androidcertaliasDirtyFlag = true;
    }

    public String getAndroidCertAlias() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidCertAlias();
        }
        return this.androidcertalias;
    }

    public boolean isAndroidCertAliasDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidCertAliasDirty();
        }
        return this.androidcertaliasDirtyFlag;
    }

    public void resetAndroidCertAlias() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidCertAlias();
            return;
        }
        this.androidcertaliasDirtyFlag = false;
        this.androidcertalias = null;
    }

    public void setAndroidCertDomain(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidCertDomain(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertdomain = string;
        this.androidcertdomainDirtyFlag = true;
    }

    public String getAndroidCertDomain() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidCertDomain();
        }
        return this.androidcertdomain;
    }

    public boolean isAndroidCertDomainDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidCertDomainDirty();
        }
        return this.androidcertdomainDirtyFlag;
    }

    public void resetAndroidCertDomain() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidCertDomain();
            return;
        }
        this.androidcertdomainDirtyFlag = false;
        this.androidcertdomain = null;
    }

    public void setAndroidCertFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidCertFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertfile = string;
        this.androidcertfileDirtyFlag = true;
    }

    public String getAndroidCertFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidCertFile();
        }
        return this.androidcertfile;
    }

    public boolean isAndroidCertFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidCertFileDirty();
        }
        return this.androidcertfileDirtyFlag;
    }

    public void resetAndroidCertFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidCertFile();
            return;
        }
        this.androidcertfileDirtyFlag = false;
        this.androidcertfile = null;
    }

    public void setAndroidCertInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidCertInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertinfo = string;
        this.androidcertinfoDirtyFlag = true;
    }

    public String getAndroidCertInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidCertInfo();
        }
        return this.androidcertinfo;
    }

    public boolean isAndroidCertInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidCertInfoDirty();
        }
        return this.androidcertinfoDirtyFlag;
    }

    public void resetAndroidCertInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidCertInfo();
            return;
        }
        this.androidcertinfoDirtyFlag = false;
        this.androidcertinfo = null;
    }

    public void setAndroidcertKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidcertKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertkey = string;
        this.androidcertkeyDirtyFlag = true;
    }

    public String getAndroidcertKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidcertKey();
        }
        return this.androidcertkey;
    }

    public boolean isAndroidcertKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidcertKeyDirty();
        }
        return this.androidcertkeyDirtyFlag;
    }

    public void resetAndroidcertKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidcertKey();
            return;
        }
        this.androidcertkeyDirtyFlag = false;
        this.androidcertkey = null;
    }

    public void setAndroidCertStorePwd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidCertStorePwd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidcertstorepwd = string;
        this.androidcertstorepwdDirtyFlag = true;
    }

    public String getAndroidCertStorePwd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidCertStorePwd();
        }
        return this.androidcertstorepwd;
    }

    public boolean isAndroidCertStorePwdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidCertStorePwdDirty();
        }
        return this.androidcertstorepwdDirtyFlag;
    }

    public void resetAndroidCertStorePwd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidCertStorePwd();
            return;
        }
        this.androidcertstorepwdDirtyFlag = false;
        this.androidcertstorepwd = null;
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

    public void setIOSAppIDS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSAppIDS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iosappids = string;
        this.iosappidsDirtyFlag = true;
    }

    public String getIOSAppIDS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSAppIDS();
        }
        return this.iosappids;
    }

    public boolean isIOSAppIDSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSAppIDSDirty();
        }
        return this.iosappidsDirtyFlag;
    }

    public void resetIOSAppIDS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSAppIDS();
            return;
        }
        this.iosappidsDirtyFlag = false;
        this.iosappids = null;
    }

    public void setIOSCertInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSCertInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ioscertinfo = string;
        this.ioscertinfoDirtyFlag = true;
    }

    public String getIOSCertInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSCertInfo();
        }
        return this.ioscertinfo;
    }

    public boolean isIOSCertInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSCertInfoDirty();
        }
        return this.ioscertinfoDirtyFlag;
    }

    public void resetIOSCertInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSCertInfo();
            return;
        }
        this.ioscertinfoDirtyFlag = false;
        this.ioscertinfo = null;
    }

    public void setIOSCertPwd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSCertPwd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ioscertpwd = string;
        this.ioscertpwdDirtyFlag = true;
    }

    public String getIOSCertPwd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSCertPwd();
        }
        return this.ioscertpwd;
    }

    public boolean isIOSCertPwdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSCertPwdDirty();
        }
        return this.ioscertpwdDirtyFlag;
    }

    public void resetIOSCertPwd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSCertPwd();
            return;
        }
        this.ioscertpwdDirtyFlag = false;
        this.ioscertpwd = null;
    }

    public void setIOSDistMPCert(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSDistMPCert(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iosdistmpcert = string;
        this.iosdistmpcertDirtyFlag = true;
    }

    public String getIOSDistMPCert() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSDistMPCert();
        }
        return this.iosdistmpcert;
    }

    public boolean isIOSDistMPCertDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSDistMPCertDirty();
        }
        return this.iosdistmpcertDirtyFlag;
    }

    public void resetIOSDistMPCert() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSDistMPCert();
            return;
        }
        this.iosdistmpcertDirtyFlag = false;
        this.iosdistmpcert = null;
    }

    public void setIOSDistP12Cert(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSDistP12Cert(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iosdistp12cert = string;
        this.iosdistp12certDirtyFlag = true;
    }

    public String getIOSDistP12Cert() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSDistP12Cert();
        }
        return this.iosdistp12cert;
    }

    public boolean isIOSDistP12CertDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSDistP12CertDirty();
        }
        return this.iosdistp12certDirtyFlag;
    }

    public void resetIOSDistP12Cert() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSDistP12Cert();
            return;
        }
        this.iosdistp12certDirtyFlag = false;
        this.iosdistp12cert = null;
    }

    public void setIOSWKAMPCert(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSWKAMPCert(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ioswkampcert = string;
        this.ioswkampcertDirtyFlag = true;
    }

    public String getIOSWKAMPCert() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSWKAMPCert();
        }
        return this.ioswkampcert;
    }

    public boolean isIOSWKAMPCertDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSWKAMPCertDirty();
        }
        return this.ioswkampcertDirtyFlag;
    }

    public void resetIOSWKAMPCert() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSWKAMPCert();
            return;
        }
        this.ioswkampcertDirtyFlag = false;
        this.ioswkampcert = null;
    }

    public void setIOSWKEMPCert(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSWKEMPCert(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ioswkempcert = string;
        this.ioswkempcertDirtyFlag = true;
    }

    public String getIOSWKEMPCert() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSWKEMPCert();
        }
        return this.ioswkempcert;
    }

    public boolean isIOSWKEMPCertDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSWKEMPCertDirty();
        }
        return this.ioswkempcertDirtyFlag;
    }

    public void resetIOSWKEMPCert() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSWKEMPCert();
            return;
        }
        this.ioswkempcertDirtyFlag = false;
        this.ioswkempcert = null;
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

    public void setPackType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.packtype = string;
        this.packtypeDirtyFlag = true;
    }

    public String getPackType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackType();
        }
        return this.packtype;
    }

    public boolean isPackTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackTypeDirty();
        }
        return this.packtypeDirtyFlag;
    }

    public void resetPackType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackType();
            return;
        }
        this.packtypeDirtyFlag = false;
        this.packtype = null;
    }

    public void setPSDCMobPackCertId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobPackCertId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobpackcertid = string;
        this.psdcmobpackcertidDirtyFlag = true;
    }

    public String getPSDCMobPackCertId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCertId();
        }
        return this.psdcmobpackcertid;
    }

    public boolean isPSDCMobPackCertIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobPackCertIdDirty();
        }
        return this.psdcmobpackcertidDirtyFlag;
    }

    public void resetPSDCMobPackCertId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobPackCertId();
            return;
        }
        this.psdcmobpackcertidDirtyFlag = false;
        this.psdcmobpackcertid = null;
    }

    public void setPSDCMobPackCertName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobPackCertName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobpackcertname = string;
        this.psdcmobpackcertnameDirtyFlag = true;
    }

    public String getPSDCMobPackCertName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCertName();
        }
        return this.psdcmobpackcertname;
    }

    public boolean isPSDCMobPackCertNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobPackCertNameDirty();
        }
        return this.psdcmobpackcertnameDirtyFlag;
    }

    public void resetPSDCMobPackCertName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobPackCertName();
            return;
        }
        this.psdcmobpackcertnameDirtyFlag = false;
        this.psdcmobpackcertname = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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
        PSDCMobPackCertBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMobPackCertBase pSDCMobPackCertBase) {
        pSDCMobPackCertBase.resetAndroidCertAlias();
        pSDCMobPackCertBase.resetAndroidCertDomain();
        pSDCMobPackCertBase.resetAndroidCertFile();
        pSDCMobPackCertBase.resetAndroidCertInfo();
        pSDCMobPackCertBase.resetAndroidcertKey();
        pSDCMobPackCertBase.resetAndroidCertStorePwd();
        pSDCMobPackCertBase.resetCreateDate();
        pSDCMobPackCertBase.resetCreateMan();
        pSDCMobPackCertBase.resetIOSAppIDS();
        pSDCMobPackCertBase.resetIOSCertInfo();
        pSDCMobPackCertBase.resetIOSCertPwd();
        pSDCMobPackCertBase.resetIOSDistMPCert();
        pSDCMobPackCertBase.resetIOSDistP12Cert();
        pSDCMobPackCertBase.resetIOSWKAMPCert();
        pSDCMobPackCertBase.resetIOSWKEMPCert();
        pSDCMobPackCertBase.resetMemo();
        pSDCMobPackCertBase.resetPackType();
        pSDCMobPackCertBase.resetPSDCMobPackCertId();
        pSDCMobPackCertBase.resetPSDCMobPackCertName();
        pSDCMobPackCertBase.resetPSDevCenterId();
        pSDCMobPackCertBase.resetPSDevCenterName();
        pSDCMobPackCertBase.resetPSSysAppId();
        pSDCMobPackCertBase.resetPSSysAppName();
        pSDCMobPackCertBase.resetUpdateDate();
        pSDCMobPackCertBase.resetUpdateMan();
        pSDCMobPackCertBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAndroidCertAliasDirty()) {
            hashMap.put(FIELD_ANDROIDCERTALIAS, this.getAndroidCertAlias());
        }
        if (!bl || this.isAndroidCertDomainDirty()) {
            hashMap.put(FIELD_ANDROIDCERTDOMAIN, this.getAndroidCertDomain());
        }
        if (!bl || this.isAndroidCertFileDirty()) {
            hashMap.put(FIELD_ANDROIDCERTFILE, this.getAndroidCertFile());
        }
        if (!bl || this.isAndroidCertInfoDirty()) {
            hashMap.put(FIELD_ANDROIDCERTINFO, this.getAndroidCertInfo());
        }
        if (!bl || this.isAndroidcertKeyDirty()) {
            hashMap.put(FIELD_ANDROIDCERTKEY, this.getAndroidcertKey());
        }
        if (!bl || this.isAndroidCertStorePwdDirty()) {
            hashMap.put(FIELD_ANDROIDCERTSTOREPWD, this.getAndroidCertStorePwd());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIOSAppIDSDirty()) {
            hashMap.put(FIELD_IOSAPPIDS, this.getIOSAppIDS());
        }
        if (!bl || this.isIOSCertInfoDirty()) {
            hashMap.put(FIELD_IOSCERTINFO, this.getIOSCertInfo());
        }
        if (!bl || this.isIOSCertPwdDirty()) {
            hashMap.put(FIELD_IOSCERTPWD, this.getIOSCertPwd());
        }
        if (!bl || this.isIOSDistMPCertDirty()) {
            hashMap.put(FIELD_IOSDISTMPCERT, this.getIOSDistMPCert());
        }
        if (!bl || this.isIOSDistP12CertDirty()) {
            hashMap.put(FIELD_IOSDISTP12CERT, this.getIOSDistP12Cert());
        }
        if (!bl || this.isIOSWKAMPCertDirty()) {
            hashMap.put(FIELD_IOSWKAMPCERT, this.getIOSWKAMPCert());
        }
        if (!bl || this.isIOSWKEMPCertDirty()) {
            hashMap.put(FIELD_IOSWKEMPCERT, this.getIOSWKEMPCert());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPackTypeDirty()) {
            hashMap.put(FIELD_PACKTYPE, this.getPackType());
        }
        if (!bl || this.isPSDCMobPackCertIdDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTID, this.getPSDCMobPackCertId());
        }
        if (!bl || this.isPSDCMobPackCertNameDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTNAME, this.getPSDCMobPackCertName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSDCMobPackCertBase.get(this, n);
    }

    private static Object get(PSDCMobPackCertBase pSDCMobPackCertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobPackCertBase.getAndroidCertAlias();
            }
            case 1: {
                return pSDCMobPackCertBase.getAndroidCertDomain();
            }
            case 2: {
                return pSDCMobPackCertBase.getAndroidCertFile();
            }
            case 3: {
                return pSDCMobPackCertBase.getAndroidCertInfo();
            }
            case 4: {
                return pSDCMobPackCertBase.getAndroidcertKey();
            }
            case 5: {
                return pSDCMobPackCertBase.getAndroidCertStorePwd();
            }
            case 6: {
                return pSDCMobPackCertBase.getCreateDate();
            }
            case 7: {
                return pSDCMobPackCertBase.getCreateMan();
            }
            case 8: {
                return pSDCMobPackCertBase.getIOSAppIDS();
            }
            case 9: {
                return pSDCMobPackCertBase.getIOSCertInfo();
            }
            case 10: {
                return pSDCMobPackCertBase.getIOSCertPwd();
            }
            case 11: {
                return pSDCMobPackCertBase.getIOSDistMPCert();
            }
            case 12: {
                return pSDCMobPackCertBase.getIOSDistP12Cert();
            }
            case 13: {
                return pSDCMobPackCertBase.getIOSWKAMPCert();
            }
            case 14: {
                return pSDCMobPackCertBase.getIOSWKEMPCert();
            }
            case 15: {
                return pSDCMobPackCertBase.getMemo();
            }
            case 16: {
                return pSDCMobPackCertBase.getPackType();
            }
            case 17: {
                return pSDCMobPackCertBase.getPSDCMobPackCertId();
            }
            case 18: {
                return pSDCMobPackCertBase.getPSDCMobPackCertName();
            }
            case 19: {
                return pSDCMobPackCertBase.getPSDevCenterId();
            }
            case 20: {
                return pSDCMobPackCertBase.getPSDevCenterName();
            }
            case 21: {
                return pSDCMobPackCertBase.getPSSysAppId();
            }
            case 22: {
                return pSDCMobPackCertBase.getPSSysAppName();
            }
            case 23: {
                return pSDCMobPackCertBase.getUpdateDate();
            }
            case 24: {
                return pSDCMobPackCertBase.getUpdateMan();
            }
            case 25: {
                return pSDCMobPackCertBase.getValidFlag();
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
        PSDCMobPackCertBase.set(this, n, object);
    }

    private static void set(PSDCMobPackCertBase pSDCMobPackCertBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobPackCertBase.setAndroidCertAlias(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCMobPackCertBase.setAndroidCertDomain(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMobPackCertBase.setAndroidCertFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMobPackCertBase.setAndroidCertInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMobPackCertBase.setAndroidcertKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMobPackCertBase.setAndroidCertStorePwd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMobPackCertBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCMobPackCertBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMobPackCertBase.setIOSAppIDS(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMobPackCertBase.setIOSCertInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMobPackCertBase.setIOSCertPwd(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCMobPackCertBase.setIOSDistMPCert(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCMobPackCertBase.setIOSDistP12Cert(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCMobPackCertBase.setIOSWKAMPCert(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMobPackCertBase.setIOSWKEMPCert(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCMobPackCertBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCMobPackCertBase.setPackType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCMobPackCertBase.setPSDCMobPackCertId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCMobPackCertBase.setPSDCMobPackCertName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCMobPackCertBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCMobPackCertBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCMobPackCertBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCMobPackCertBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCMobPackCertBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDCMobPackCertBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCMobPackCertBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCMobPackCertBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMobPackCertBase pSDCMobPackCertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobPackCertBase.getAndroidCertAlias() == null;
            }
            case 1: {
                return pSDCMobPackCertBase.getAndroidCertDomain() == null;
            }
            case 2: {
                return pSDCMobPackCertBase.getAndroidCertFile() == null;
            }
            case 3: {
                return pSDCMobPackCertBase.getAndroidCertInfo() == null;
            }
            case 4: {
                return pSDCMobPackCertBase.getAndroidcertKey() == null;
            }
            case 5: {
                return pSDCMobPackCertBase.getAndroidCertStorePwd() == null;
            }
            case 6: {
                return pSDCMobPackCertBase.getCreateDate() == null;
            }
            case 7: {
                return pSDCMobPackCertBase.getCreateMan() == null;
            }
            case 8: {
                return pSDCMobPackCertBase.getIOSAppIDS() == null;
            }
            case 9: {
                return pSDCMobPackCertBase.getIOSCertInfo() == null;
            }
            case 10: {
                return pSDCMobPackCertBase.getIOSCertPwd() == null;
            }
            case 11: {
                return pSDCMobPackCertBase.getIOSDistMPCert() == null;
            }
            case 12: {
                return pSDCMobPackCertBase.getIOSDistP12Cert() == null;
            }
            case 13: {
                return pSDCMobPackCertBase.getIOSWKAMPCert() == null;
            }
            case 14: {
                return pSDCMobPackCertBase.getIOSWKEMPCert() == null;
            }
            case 15: {
                return pSDCMobPackCertBase.getMemo() == null;
            }
            case 16: {
                return pSDCMobPackCertBase.getPackType() == null;
            }
            case 17: {
                return pSDCMobPackCertBase.getPSDCMobPackCertId() == null;
            }
            case 18: {
                return pSDCMobPackCertBase.getPSDCMobPackCertName() == null;
            }
            case 19: {
                return pSDCMobPackCertBase.getPSDevCenterId() == null;
            }
            case 20: {
                return pSDCMobPackCertBase.getPSDevCenterName() == null;
            }
            case 21: {
                return pSDCMobPackCertBase.getPSSysAppId() == null;
            }
            case 22: {
                return pSDCMobPackCertBase.getPSSysAppName() == null;
            }
            case 23: {
                return pSDCMobPackCertBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDCMobPackCertBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDCMobPackCertBase.getValidFlag() == null;
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
        return PSDCMobPackCertBase.contains(this, n);
    }

    private static boolean contains(PSDCMobPackCertBase pSDCMobPackCertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobPackCertBase.isAndroidCertAliasDirty();
            }
            case 1: {
                return pSDCMobPackCertBase.isAndroidCertDomainDirty();
            }
            case 2: {
                return pSDCMobPackCertBase.isAndroidCertFileDirty();
            }
            case 3: {
                return pSDCMobPackCertBase.isAndroidCertInfoDirty();
            }
            case 4: {
                return pSDCMobPackCertBase.isAndroidcertKeyDirty();
            }
            case 5: {
                return pSDCMobPackCertBase.isAndroidCertStorePwdDirty();
            }
            case 6: {
                return pSDCMobPackCertBase.isCreateDateDirty();
            }
            case 7: {
                return pSDCMobPackCertBase.isCreateManDirty();
            }
            case 8: {
                return pSDCMobPackCertBase.isIOSAppIDSDirty();
            }
            case 9: {
                return pSDCMobPackCertBase.isIOSCertInfoDirty();
            }
            case 10: {
                return pSDCMobPackCertBase.isIOSCertPwdDirty();
            }
            case 11: {
                return pSDCMobPackCertBase.isIOSDistMPCertDirty();
            }
            case 12: {
                return pSDCMobPackCertBase.isIOSDistP12CertDirty();
            }
            case 13: {
                return pSDCMobPackCertBase.isIOSWKAMPCertDirty();
            }
            case 14: {
                return pSDCMobPackCertBase.isIOSWKEMPCertDirty();
            }
            case 15: {
                return pSDCMobPackCertBase.isMemoDirty();
            }
            case 16: {
                return pSDCMobPackCertBase.isPackTypeDirty();
            }
            case 17: {
                return pSDCMobPackCertBase.isPSDCMobPackCertIdDirty();
            }
            case 18: {
                return pSDCMobPackCertBase.isPSDCMobPackCertNameDirty();
            }
            case 19: {
                return pSDCMobPackCertBase.isPSDevCenterIdDirty();
            }
            case 20: {
                return pSDCMobPackCertBase.isPSDevCenterNameDirty();
            }
            case 21: {
                return pSDCMobPackCertBase.isPSSysAppIdDirty();
            }
            case 22: {
                return pSDCMobPackCertBase.isPSSysAppNameDirty();
            }
            case 23: {
                return pSDCMobPackCertBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDCMobPackCertBase.isUpdateManDirty();
            }
            case 25: {
                return pSDCMobPackCertBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMobPackCertBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMobPackCertBase pSDCMobPackCertBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMobPackCertBase.getAndroidCertAlias() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertalias", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidCertAlias()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertDomain() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertdomain", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidCertDomain()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertfile", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidCertFile()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertinfo", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidCertInfo()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getAndroidcertKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertkey", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidcertKey()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertStorePwd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidcertstorepwd", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getAndroidCertStorePwd()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSAppIDS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iosappids", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSAppIDS()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSCertInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ioscertinfo", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSCertInfo()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSCertPwd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ioscertpwd", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSCertPwd()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSDistMPCert() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iosdistmpcert", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSDistMPCert()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSDistP12Cert() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iosdistp12cert", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSDistP12Cert()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSWKAMPCert() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ioswkampcert", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSWKAMPCert()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getIOSWKEMPCert() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ioswkempcert", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getIOSWKEMPCert()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPackType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packtype", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPackType()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSDCMobPackCertId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertid", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSDCMobPackCertId()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSDCMobPackCertName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertname", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSDCMobPackCertName()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMobPackCertBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMobPackCertBase.getJSONValue((Object)pSDCMobPackCertBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMobPackCertBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMobPackCertBase pSDCMobPackCertBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMobPackCertBase.getAndroidCertAlias() != null) {
            object = pSDCMobPackCertBase.getAndroidCertAlias();
            xmlNode.setAttribute(FIELD_ANDROIDCERTALIAS, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertDomain() != null) {
            object = pSDCMobPackCertBase.getAndroidCertDomain();
            xmlNode.setAttribute(FIELD_ANDROIDCERTDOMAIN, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertFile() != null) {
            object = pSDCMobPackCertBase.getAndroidCertFile();
            xmlNode.setAttribute(FIELD_ANDROIDCERTFILE, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertInfo() != null) {
            object = pSDCMobPackCertBase.getAndroidCertInfo();
            xmlNode.setAttribute(FIELD_ANDROIDCERTINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMobPackCertBase.getAndroidcertKey() != null) {
            object = pSDCMobPackCertBase.getAndroidcertKey();
            xmlNode.setAttribute(FIELD_ANDROIDCERTKEY, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMobPackCertBase.getAndroidCertStorePwd() != null) {
            object = pSDCMobPackCertBase.getAndroidCertStorePwd();
            xmlNode.setAttribute(FIELD_ANDROIDCERTSTOREPWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getCreateDate() != null) {
            object = pSDCMobPackCertBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobPackCertBase.getCreateMan() != null) {
            object = pSDCMobPackCertBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSAppIDS() != null) {
            object = pSDCMobPackCertBase.getIOSAppIDS();
            xmlNode.setAttribute(FIELD_IOSAPPIDS, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSCertInfo() != null) {
            object = pSDCMobPackCertBase.getIOSCertInfo();
            xmlNode.setAttribute(FIELD_IOSCERTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSCertPwd() != null) {
            object = pSDCMobPackCertBase.getIOSCertPwd();
            xmlNode.setAttribute(FIELD_IOSCERTPWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSDistMPCert() != null) {
            object = pSDCMobPackCertBase.getIOSDistMPCert();
            xmlNode.setAttribute(FIELD_IOSDISTMPCERT, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSDistP12Cert() != null) {
            object = pSDCMobPackCertBase.getIOSDistP12Cert();
            xmlNode.setAttribute(FIELD_IOSDISTP12CERT, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSWKAMPCert() != null) {
            object = pSDCMobPackCertBase.getIOSWKAMPCert();
            xmlNode.setAttribute(FIELD_IOSWKAMPCERT, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getIOSWKEMPCert() != null) {
            object = pSDCMobPackCertBase.getIOSWKEMPCert();
            xmlNode.setAttribute(FIELD_IOSWKEMPCERT, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getMemo() != null) {
            object = pSDCMobPackCertBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPackType() != null) {
            object = pSDCMobPackCertBase.getPackType();
            xmlNode.setAttribute(FIELD_PACKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSDCMobPackCertId() != null) {
            object = pSDCMobPackCertBase.getPSDCMobPackCertId();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSDCMobPackCertName() != null) {
            object = pSDCMobPackCertBase.getPSDCMobPackCertName();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSDevCenterId() != null) {
            object = pSDCMobPackCertBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSDevCenterName() != null) {
            object = pSDCMobPackCertBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSSysAppId() != null) {
            object = pSDCMobPackCertBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getPSSysAppName() != null) {
            object = pSDCMobPackCertBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getUpdateDate() != null) {
            object = pSDCMobPackCertBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobPackCertBase.getUpdateMan() != null) {
            object = pSDCMobPackCertBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobPackCertBase.getValidFlag() != null) {
            object = pSDCMobPackCertBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMobPackCertBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMobPackCertBase pSDCMobPackCertBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMobPackCertBase.isAndroidCertAliasDirty() && (bl || pSDCMobPackCertBase.getAndroidCertAlias() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTALIAS, (Object)pSDCMobPackCertBase.getAndroidCertAlias());
        }
        if (pSDCMobPackCertBase.isAndroidCertDomainDirty() && (bl || pSDCMobPackCertBase.getAndroidCertDomain() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTDOMAIN, (Object)pSDCMobPackCertBase.getAndroidCertDomain());
        }
        if (pSDCMobPackCertBase.isAndroidCertFileDirty() && (bl || pSDCMobPackCertBase.getAndroidCertFile() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTFILE, (Object)pSDCMobPackCertBase.getAndroidCertFile());
        }
        if (pSDCMobPackCertBase.isAndroidCertInfoDirty() && (bl || pSDCMobPackCertBase.getAndroidCertInfo() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTINFO, (Object)pSDCMobPackCertBase.getAndroidCertInfo());
        }
        if (pSDCMobPackCertBase.isAndroidcertKeyDirty() && (bl || pSDCMobPackCertBase.getAndroidcertKey() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTKEY, (Object)pSDCMobPackCertBase.getAndroidcertKey());
        }
        if (pSDCMobPackCertBase.isAndroidCertStorePwdDirty() && (bl || pSDCMobPackCertBase.getAndroidCertStorePwd() != null)) {
            iDataObject.set(FIELD_ANDROIDCERTSTOREPWD, (Object)pSDCMobPackCertBase.getAndroidCertStorePwd());
        }
        if (pSDCMobPackCertBase.isCreateDateDirty() && (bl || pSDCMobPackCertBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMobPackCertBase.getCreateDate());
        }
        if (pSDCMobPackCertBase.isCreateManDirty() && (bl || pSDCMobPackCertBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMobPackCertBase.getCreateMan());
        }
        if (pSDCMobPackCertBase.isIOSAppIDSDirty() && (bl || pSDCMobPackCertBase.getIOSAppIDS() != null)) {
            iDataObject.set(FIELD_IOSAPPIDS, (Object)pSDCMobPackCertBase.getIOSAppIDS());
        }
        if (pSDCMobPackCertBase.isIOSCertInfoDirty() && (bl || pSDCMobPackCertBase.getIOSCertInfo() != null)) {
            iDataObject.set(FIELD_IOSCERTINFO, (Object)pSDCMobPackCertBase.getIOSCertInfo());
        }
        if (pSDCMobPackCertBase.isIOSCertPwdDirty() && (bl || pSDCMobPackCertBase.getIOSCertPwd() != null)) {
            iDataObject.set(FIELD_IOSCERTPWD, (Object)pSDCMobPackCertBase.getIOSCertPwd());
        }
        if (pSDCMobPackCertBase.isIOSDistMPCertDirty() && (bl || pSDCMobPackCertBase.getIOSDistMPCert() != null)) {
            iDataObject.set(FIELD_IOSDISTMPCERT, (Object)pSDCMobPackCertBase.getIOSDistMPCert());
        }
        if (pSDCMobPackCertBase.isIOSDistP12CertDirty() && (bl || pSDCMobPackCertBase.getIOSDistP12Cert() != null)) {
            iDataObject.set(FIELD_IOSDISTP12CERT, (Object)pSDCMobPackCertBase.getIOSDistP12Cert());
        }
        if (pSDCMobPackCertBase.isIOSWKAMPCertDirty() && (bl || pSDCMobPackCertBase.getIOSWKAMPCert() != null)) {
            iDataObject.set(FIELD_IOSWKAMPCERT, (Object)pSDCMobPackCertBase.getIOSWKAMPCert());
        }
        if (pSDCMobPackCertBase.isIOSWKEMPCertDirty() && (bl || pSDCMobPackCertBase.getIOSWKEMPCert() != null)) {
            iDataObject.set(FIELD_IOSWKEMPCERT, (Object)pSDCMobPackCertBase.getIOSWKEMPCert());
        }
        if (pSDCMobPackCertBase.isMemoDirty() && (bl || pSDCMobPackCertBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMobPackCertBase.getMemo());
        }
        if (pSDCMobPackCertBase.isPackTypeDirty() && (bl || pSDCMobPackCertBase.getPackType() != null)) {
            iDataObject.set(FIELD_PACKTYPE, (Object)pSDCMobPackCertBase.getPackType());
        }
        if (pSDCMobPackCertBase.isPSDCMobPackCertIdDirty() && (bl || pSDCMobPackCertBase.getPSDCMobPackCertId() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTID, (Object)pSDCMobPackCertBase.getPSDCMobPackCertId());
        }
        if (pSDCMobPackCertBase.isPSDCMobPackCertNameDirty() && (bl || pSDCMobPackCertBase.getPSDCMobPackCertName() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTNAME, (Object)pSDCMobPackCertBase.getPSDCMobPackCertName());
        }
        if (pSDCMobPackCertBase.isPSDevCenterIdDirty() && (bl || pSDCMobPackCertBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCMobPackCertBase.getPSDevCenterId());
        }
        if (pSDCMobPackCertBase.isPSDevCenterNameDirty() && (bl || pSDCMobPackCertBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCMobPackCertBase.getPSDevCenterName());
        }
        if (pSDCMobPackCertBase.isPSSysAppIdDirty() && (bl || pSDCMobPackCertBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDCMobPackCertBase.getPSSysAppId());
        }
        if (pSDCMobPackCertBase.isPSSysAppNameDirty() && (bl || pSDCMobPackCertBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDCMobPackCertBase.getPSSysAppName());
        }
        if (pSDCMobPackCertBase.isUpdateDateDirty() && (bl || pSDCMobPackCertBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMobPackCertBase.getUpdateDate());
        }
        if (pSDCMobPackCertBase.isUpdateManDirty() && (bl || pSDCMobPackCertBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMobPackCertBase.getUpdateMan());
        }
        if (pSDCMobPackCertBase.isValidFlagDirty() && (bl || pSDCMobPackCertBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMobPackCertBase.getValidFlag());
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
        return PSDCMobPackCertBase.remove(this, n);
    }

    private static boolean remove(PSDCMobPackCertBase pSDCMobPackCertBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobPackCertBase.resetAndroidCertAlias();
                return true;
            }
            case 1: {
                pSDCMobPackCertBase.resetAndroidCertDomain();
                return true;
            }
            case 2: {
                pSDCMobPackCertBase.resetAndroidCertFile();
                return true;
            }
            case 3: {
                pSDCMobPackCertBase.resetAndroidCertInfo();
                return true;
            }
            case 4: {
                pSDCMobPackCertBase.resetAndroidcertKey();
                return true;
            }
            case 5: {
                pSDCMobPackCertBase.resetAndroidCertStorePwd();
                return true;
            }
            case 6: {
                pSDCMobPackCertBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDCMobPackCertBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDCMobPackCertBase.resetIOSAppIDS();
                return true;
            }
            case 9: {
                pSDCMobPackCertBase.resetIOSCertInfo();
                return true;
            }
            case 10: {
                pSDCMobPackCertBase.resetIOSCertPwd();
                return true;
            }
            case 11: {
                pSDCMobPackCertBase.resetIOSDistMPCert();
                return true;
            }
            case 12: {
                pSDCMobPackCertBase.resetIOSDistP12Cert();
                return true;
            }
            case 13: {
                pSDCMobPackCertBase.resetIOSWKAMPCert();
                return true;
            }
            case 14: {
                pSDCMobPackCertBase.resetIOSWKEMPCert();
                return true;
            }
            case 15: {
                pSDCMobPackCertBase.resetMemo();
                return true;
            }
            case 16: {
                pSDCMobPackCertBase.resetPackType();
                return true;
            }
            case 17: {
                pSDCMobPackCertBase.resetPSDCMobPackCertId();
                return true;
            }
            case 18: {
                pSDCMobPackCertBase.resetPSDCMobPackCertName();
                return true;
            }
            case 19: {
                pSDCMobPackCertBase.resetPSDevCenterId();
                return true;
            }
            case 20: {
                pSDCMobPackCertBase.resetPSDevCenterName();
                return true;
            }
            case 21: {
                pSDCMobPackCertBase.resetPSSysAppId();
                return true;
            }
            case 22: {
                pSDCMobPackCertBase.resetPSSysAppName();
                return true;
            }
            case 23: {
                pSDCMobPackCertBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDCMobPackCertBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDCMobPackCertBase.resetValidFlag();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMobAppPackTD> getPSMobAppPackTDs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackTDs();
        }
        if (this.getPSDCMobPackCertId() == null) {
            return null;
        }
        PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMobAppPackTDsLock;
        synchronized (n) {
            if (this.psmobapppacktds == null) {
                this.psmobapppacktds = pSMobAppPackTDService.selectByPSDCMobPackCert(this);
            }
            return this.psmobapppacktds;
        }
    }

    private PSDCMobPackCertBase getProxyEntity() {
        return this.proxyPSDCMobPackCertBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMobPackCertBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMobPackCertBase) {
            this.proxyPSDCMobPackCertBase = (PSDCMobPackCertBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ANDROIDCERTALIAS, 0);
        fieldIndexMap.put(FIELD_ANDROIDCERTDOMAIN, 1);
        fieldIndexMap.put(FIELD_ANDROIDCERTFILE, 2);
        fieldIndexMap.put(FIELD_ANDROIDCERTINFO, 3);
        fieldIndexMap.put(FIELD_ANDROIDCERTKEY, 4);
        fieldIndexMap.put(FIELD_ANDROIDCERTSTOREPWD, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_IOSAPPIDS, 8);
        fieldIndexMap.put(FIELD_IOSCERTINFO, 9);
        fieldIndexMap.put(FIELD_IOSCERTPWD, 10);
        fieldIndexMap.put(FIELD_IOSDISTMPCERT, 11);
        fieldIndexMap.put(FIELD_IOSDISTP12CERT, 12);
        fieldIndexMap.put(FIELD_IOSWKAMPCERT, 13);
        fieldIndexMap.put(FIELD_IOSWKEMPCERT, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PACKTYPE, 16);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTID, 17);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 21);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

