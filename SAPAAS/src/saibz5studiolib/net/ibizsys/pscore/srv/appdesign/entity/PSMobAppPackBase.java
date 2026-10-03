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
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCert;
import net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMobAppPackBase.class);
    public static final String FIELD_ANDROIDPERMISSIONS = "ANDROIDPERMISSIONS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEANDROID = "ENABLEANDROID";
    public static final String FIELD_ENABLEENCRYPTION = "ENABLEENCRYPTION";
    public static final String FIELD_ENABLEIOS = "ENABLEIOS";
    public static final String FIELD_IOSDEVICES = "IOSDEVICES";
    public static final String FIELD_IOSPRIVACIES = "IOSPRIVACIES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OSTYPE = "OSTYPE";
    public static final String FIELD_OSTYPES = "OSTYPES";
    public static final String FIELD_PACKTYPE = "PACKTYPE";
    public static final String FIELD_PKGNAME = "PKGNAME";
    public static final String FIELD_PSDCMOBPACKCERTID = "PSDCMOBPACKCERTID";
    public static final String FIELD_PSDCMOBPACKCERTNAME = "PSDCMOBPACKCERTNAME";
    public static final String FIELD_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String FIELD_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_SERVICEURL = "SERVICEURL";
    public static final String FIELD_TDCNT = "TDCNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_ANDROIDPERMISSIONS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENABLEANDROID = 4;
    private static final int INDEX_ENABLEENCRYPTION = 5;
    private static final int INDEX_ENABLEIOS = 6;
    private static final int INDEX_IOSDEVICES = 7;
    private static final int INDEX_IOSPRIVACIES = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_OSTYPE = 10;
    private static final int INDEX_OSTYPES = 11;
    private static final int INDEX_PACKTYPE = 12;
    private static final int INDEX_PKGNAME = 13;
    private static final int INDEX_PSDCMOBPACKCERTID = 14;
    private static final int INDEX_PSDCMOBPACKCERTNAME = 15;
    private static final int INDEX_PSMOBAPPPACKID = 16;
    private static final int INDEX_PSMOBAPPPACKNAME = 17;
    private static final int INDEX_PSSYSAPPID = 18;
    private static final int INDEX_PSSYSAPPNAME = 19;
    private static final int INDEX_SERVICEURL = 20;
    private static final int INDEX_TDCNT = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERPARAMS = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_VERSION = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMobAppPackBase proxyPSMobAppPackBase = null;
    private boolean androidpermissionsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableandroidDirtyFlag = false;
    private boolean enableencryptionDirtyFlag = false;
    private boolean enableiosDirtyFlag = false;
    private boolean iosdevicesDirtyFlag = false;
    private boolean iosprivaciesDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ostypeDirtyFlag = false;
    private boolean ostypesDirtyFlag = false;
    private boolean packtypeDirtyFlag = false;
    private boolean pkgnameDirtyFlag = false;
    private boolean psdcmobpackcertidDirtyFlag = false;
    private boolean psdcmobpackcertnameDirtyFlag = false;
    private boolean psmobapppackidDirtyFlag = false;
    private boolean psmobapppacknameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean serviceurlDirtyFlag = false;
    private boolean tdcntDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="androidpermissions")
    private String androidpermissions;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableandroid")
    private Integer enableandroid;
    @Column(name="enableencryption")
    private Integer enableencryption;
    @Column(name="enableios")
    private Integer enableios;
    @Column(name="iosdevices")
    private String iosdevices;
    @Column(name="iosprivacies")
    private String iosprivacies;
    @Column(name="memo")
    private String memo;
    @Column(name="ostype")
    private String ostype;
    @Column(name="ostypes")
    private String ostypes;
    @Column(name="packtype")
    private String packtype;
    @Column(name="pkgname")
    private String pkgname;
    @Column(name="psdcmobpackcertid")
    private String psdcmobpackcertid;
    @Column(name="psdcmobpackcertname")
    private String psdcmobpackcertname;
    @Column(name="psmobapppackid")
    private String psmobapppackid;
    @Column(name="psmobapppackname")
    private String psmobapppackname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="serviceurl")
    private String serviceurl;
    @Column(name="tdcnt")
    private Integer tdcnt;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="version")
    private String version;
    private Integer objPSDCMobPackCertLock = new Integer(1);
    private PSDCMobPackCert psdcmobpackcert = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

    public void setAndroidPermissions(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAndroidPermissions(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.androidpermissions = string;
        this.androidpermissionsDirtyFlag = true;
    }

    public String getAndroidPermissions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAndroidPermissions();
        }
        return this.androidpermissions;
    }

    public boolean isAndroidPermissionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAndroidPermissionsDirty();
        }
        return this.androidpermissionsDirtyFlag;
    }

    public void resetAndroidPermissions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAndroidPermissions();
            return;
        }
        this.androidpermissionsDirtyFlag = false;
        this.androidpermissions = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setEnableAndroid(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAndroid(n);
            return;
        }
        this.enableandroid = n;
        this.enableandroidDirtyFlag = true;
    }

    public Integer getEnableAndroid() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAndroid();
        }
        return this.enableandroid;
    }

    public boolean isEnableAndroidDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAndroidDirty();
        }
        return this.enableandroidDirtyFlag;
    }

    public void resetEnableAndroid() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAndroid();
            return;
        }
        this.enableandroidDirtyFlag = false;
        this.enableandroid = null;
    }

    public void setEnableEncryption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableEncryption(n);
            return;
        }
        this.enableencryption = n;
        this.enableencryptionDirtyFlag = true;
    }

    public Integer getEnableEncryption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableEncryption();
        }
        return this.enableencryption;
    }

    public boolean isEnableEncryptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableEncryptionDirty();
        }
        return this.enableencryptionDirtyFlag;
    }

    public void resetEnableEncryption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableEncryption();
            return;
        }
        this.enableencryptionDirtyFlag = false;
        this.enableencryption = null;
    }

    public void setEnableIOS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableIOS(n);
            return;
        }
        this.enableios = n;
        this.enableiosDirtyFlag = true;
    }

    public Integer getEnableIOS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableIOS();
        }
        return this.enableios;
    }

    public boolean isEnableIOSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableIOSDirty();
        }
        return this.enableiosDirtyFlag;
    }

    public void resetEnableIOS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableIOS();
            return;
        }
        this.enableiosDirtyFlag = false;
        this.enableios = null;
    }

    public void setIOSDevices(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSDevices(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iosdevices = string;
        this.iosdevicesDirtyFlag = true;
    }

    public String getIOSDevices() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSDevices();
        }
        return this.iosdevices;
    }

    public boolean isIOSDevicesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSDevicesDirty();
        }
        return this.iosdevicesDirtyFlag;
    }

    public void resetIOSDevices() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSDevices();
            return;
        }
        this.iosdevicesDirtyFlag = false;
        this.iosdevices = null;
    }

    public void setIOSPrivacies(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIOSPrivacies(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iosprivacies = string;
        this.iosprivaciesDirtyFlag = true;
    }

    public String getIOSPrivacies() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIOSPrivacies();
        }
        return this.iosprivacies;
    }

    public boolean isIOSPrivaciesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIOSPrivaciesDirty();
        }
        return this.iosprivaciesDirtyFlag;
    }

    public void resetIOSPrivacies() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIOSPrivacies();
            return;
        }
        this.iosprivaciesDirtyFlag = false;
        this.iosprivacies = null;
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

    public void setOSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ostype = string;
        this.ostypeDirtyFlag = true;
    }

    public String getOSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSType();
        }
        return this.ostype;
    }

    public boolean isOSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSTypeDirty();
        }
        return this.ostypeDirtyFlag;
    }

    public void resetOSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSType();
            return;
        }
        this.ostypeDirtyFlag = false;
        this.ostype = null;
    }

    public void setOSTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ostypes = string;
        this.ostypesDirtyFlag = true;
    }

    public String getOSTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSTypes();
        }
        return this.ostypes;
    }

    public boolean isOSTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSTypesDirty();
        }
        return this.ostypesDirtyFlag;
    }

    public void resetOSTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSTypes();
            return;
        }
        this.ostypesDirtyFlag = false;
        this.ostypes = null;
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

    public void setPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgname = string;
        this.pkgnameDirtyFlag = true;
    }

    public String getPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgName();
        }
        return this.pkgname;
    }

    public boolean isPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgNameDirty();
        }
        return this.pkgnameDirtyFlag;
    }

    public void resetPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgName();
            return;
        }
        this.pkgnameDirtyFlag = false;
        this.pkgname = null;
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

    public void setPSMobAppPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackid = string;
        this.psmobapppackidDirtyFlag = true;
    }

    public String getPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackId();
        }
        return this.psmobapppackid;
    }

    public boolean isPSMobAppPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackIdDirty();
        }
        return this.psmobapppackidDirtyFlag;
    }

    public void resetPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackId();
            return;
        }
        this.psmobapppackidDirtyFlag = false;
        this.psmobapppackid = null;
    }

    public void setPSMobAppPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackname = string;
        this.psmobapppacknameDirtyFlag = true;
    }

    public String getPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackName();
        }
        return this.psmobapppackname;
    }

    public boolean isPSMobAppPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackNameDirty();
        }
        return this.psmobapppacknameDirtyFlag;
    }

    public void resetPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackName();
            return;
        }
        this.psmobapppacknameDirtyFlag = false;
        this.psmobapppackname = null;
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

    public void setServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceurl = string;
        this.serviceurlDirtyFlag = true;
    }

    public String getServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceUrl();
        }
        return this.serviceurl;
    }

    public boolean isServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceUrlDirty();
        }
        return this.serviceurlDirtyFlag;
    }

    public void resetServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceUrl();
            return;
        }
        this.serviceurlDirtyFlag = false;
        this.serviceurl = null;
    }

    public void setTDCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTDCnt(n);
            return;
        }
        this.tdcnt = n;
        this.tdcntDirtyFlag = true;
    }

    public Integer getTDCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTDCnt();
        }
        return this.tdcnt;
    }

    public boolean isTDCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTDCntDirty();
        }
        return this.tdcntDirtyFlag;
    }

    public void resetTDCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTDCnt();
            return;
        }
        this.tdcntDirtyFlag = false;
        this.tdcnt = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.version = string;
        this.versionDirtyFlag = true;
    }

    public String getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSMobAppPackBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMobAppPackBase pSMobAppPackBase) {
        pSMobAppPackBase.resetAndroidPermissions();
        pSMobAppPackBase.resetCodeName();
        pSMobAppPackBase.resetCreateDate();
        pSMobAppPackBase.resetCreateMan();
        pSMobAppPackBase.resetEnableAndroid();
        pSMobAppPackBase.resetEnableEncryption();
        pSMobAppPackBase.resetEnableIOS();
        pSMobAppPackBase.resetIOSDevices();
        pSMobAppPackBase.resetIOSPrivacies();
        pSMobAppPackBase.resetMemo();
        pSMobAppPackBase.resetOSType();
        pSMobAppPackBase.resetOSTypes();
        pSMobAppPackBase.resetPackType();
        pSMobAppPackBase.resetPkgName();
        pSMobAppPackBase.resetPSDCMobPackCertId();
        pSMobAppPackBase.resetPSDCMobPackCertName();
        pSMobAppPackBase.resetPSMobAppPackId();
        pSMobAppPackBase.resetPSMobAppPackName();
        pSMobAppPackBase.resetPSSysAppId();
        pSMobAppPackBase.resetPSSysAppName();
        pSMobAppPackBase.resetServiceUrl();
        pSMobAppPackBase.resetTDCnt();
        pSMobAppPackBase.resetUpdateDate();
        pSMobAppPackBase.resetUpdateMan();
        pSMobAppPackBase.resetUserParams();
        pSMobAppPackBase.resetUserTag();
        pSMobAppPackBase.resetUserTag2();
        pSMobAppPackBase.resetUserTag3();
        pSMobAppPackBase.resetUserTag4();
        pSMobAppPackBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAndroidPermissionsDirty()) {
            hashMap.put(FIELD_ANDROIDPERMISSIONS, this.getAndroidPermissions());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableAndroidDirty()) {
            hashMap.put(FIELD_ENABLEANDROID, this.getEnableAndroid());
        }
        if (!bl || this.isEnableEncryptionDirty()) {
            hashMap.put(FIELD_ENABLEENCRYPTION, this.getEnableEncryption());
        }
        if (!bl || this.isEnableIOSDirty()) {
            hashMap.put(FIELD_ENABLEIOS, this.getEnableIOS());
        }
        if (!bl || this.isIOSDevicesDirty()) {
            hashMap.put(FIELD_IOSDEVICES, this.getIOSDevices());
        }
        if (!bl || this.isIOSPrivaciesDirty()) {
            hashMap.put(FIELD_IOSPRIVACIES, this.getIOSPrivacies());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOSTypeDirty()) {
            hashMap.put(FIELD_OSTYPE, this.getOSType());
        }
        if (!bl || this.isOSTypesDirty()) {
            hashMap.put(FIELD_OSTYPES, this.getOSTypes());
        }
        if (!bl || this.isPackTypeDirty()) {
            hashMap.put(FIELD_PACKTYPE, this.getPackType());
        }
        if (!bl || this.isPkgNameDirty()) {
            hashMap.put(FIELD_PKGNAME, this.getPkgName());
        }
        if (!bl || this.isPSDCMobPackCertIdDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTID, this.getPSDCMobPackCertId());
        }
        if (!bl || this.isPSDCMobPackCertNameDirty()) {
            hashMap.put(FIELD_PSDCMOBPACKCERTNAME, this.getPSDCMobPackCertName());
        }
        if (!bl || this.isPSMobAppPackIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKID, this.getPSMobAppPackId());
        }
        if (!bl || this.isPSMobAppPackNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKNAME, this.getPSMobAppPackName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isServiceUrlDirty()) {
            hashMap.put(FIELD_SERVICEURL, this.getServiceUrl());
        }
        if (!bl || this.isTDCntDirty()) {
            hashMap.put(FIELD_TDCNT, this.getTDCnt());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSMobAppPackBase.get(this, n);
    }

    private static Object get(PSMobAppPackBase pSMobAppPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackBase.getAndroidPermissions();
            }
            case 1: {
                return pSMobAppPackBase.getCodeName();
            }
            case 2: {
                return pSMobAppPackBase.getCreateDate();
            }
            case 3: {
                return pSMobAppPackBase.getCreateMan();
            }
            case 4: {
                return pSMobAppPackBase.getEnableAndroid();
            }
            case 5: {
                return pSMobAppPackBase.getEnableEncryption();
            }
            case 6: {
                return pSMobAppPackBase.getEnableIOS();
            }
            case 7: {
                return pSMobAppPackBase.getIOSDevices();
            }
            case 8: {
                return pSMobAppPackBase.getIOSPrivacies();
            }
            case 9: {
                return pSMobAppPackBase.getMemo();
            }
            case 10: {
                return pSMobAppPackBase.getOSType();
            }
            case 11: {
                return pSMobAppPackBase.getOSTypes();
            }
            case 12: {
                return pSMobAppPackBase.getPackType();
            }
            case 13: {
                return pSMobAppPackBase.getPkgName();
            }
            case 14: {
                return pSMobAppPackBase.getPSDCMobPackCertId();
            }
            case 15: {
                return pSMobAppPackBase.getPSDCMobPackCertName();
            }
            case 16: {
                return pSMobAppPackBase.getPSMobAppPackId();
            }
            case 17: {
                return pSMobAppPackBase.getPSMobAppPackName();
            }
            case 18: {
                return pSMobAppPackBase.getPSSysAppId();
            }
            case 19: {
                return pSMobAppPackBase.getPSSysAppName();
            }
            case 20: {
                return pSMobAppPackBase.getServiceUrl();
            }
            case 21: {
                return pSMobAppPackBase.getTDCnt();
            }
            case 22: {
                return pSMobAppPackBase.getUpdateDate();
            }
            case 23: {
                return pSMobAppPackBase.getUpdateMan();
            }
            case 24: {
                return pSMobAppPackBase.getUserParams();
            }
            case 25: {
                return pSMobAppPackBase.getUserTag();
            }
            case 26: {
                return pSMobAppPackBase.getUserTag2();
            }
            case 27: {
                return pSMobAppPackBase.getUserTag3();
            }
            case 28: {
                return pSMobAppPackBase.getUserTag4();
            }
            case 29: {
                return pSMobAppPackBase.getVersion();
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
        PSMobAppPackBase.set(this, n, object);
    }

    private static void set(PSMobAppPackBase pSMobAppPackBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackBase.setAndroidPermissions(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMobAppPackBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMobAppPackBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSMobAppPackBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMobAppPackBase.setEnableAndroid(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSMobAppPackBase.setEnableEncryption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSMobAppPackBase.setEnableIOS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSMobAppPackBase.setIOSDevices(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMobAppPackBase.setIOSPrivacies(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMobAppPackBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMobAppPackBase.setOSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMobAppPackBase.setOSTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMobAppPackBase.setPackType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMobAppPackBase.setPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMobAppPackBase.setPSDCMobPackCertId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMobAppPackBase.setPSDCMobPackCertName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSMobAppPackBase.setPSMobAppPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMobAppPackBase.setPSMobAppPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMobAppPackBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSMobAppPackBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMobAppPackBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMobAppPackBase.setTDCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSMobAppPackBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSMobAppPackBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSMobAppPackBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMobAppPackBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSMobAppPackBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSMobAppPackBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSMobAppPackBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSMobAppPackBase.setVersion(DataObject.getStringValue((Object)object));
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
        return PSMobAppPackBase.isNull(this, n);
    }

    private static boolean isNull(PSMobAppPackBase pSMobAppPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackBase.getAndroidPermissions() == null;
            }
            case 1: {
                return pSMobAppPackBase.getCodeName() == null;
            }
            case 2: {
                return pSMobAppPackBase.getCreateDate() == null;
            }
            case 3: {
                return pSMobAppPackBase.getCreateMan() == null;
            }
            case 4: {
                return pSMobAppPackBase.getEnableAndroid() == null;
            }
            case 5: {
                return pSMobAppPackBase.getEnableEncryption() == null;
            }
            case 6: {
                return pSMobAppPackBase.getEnableIOS() == null;
            }
            case 7: {
                return pSMobAppPackBase.getIOSDevices() == null;
            }
            case 8: {
                return pSMobAppPackBase.getIOSPrivacies() == null;
            }
            case 9: {
                return pSMobAppPackBase.getMemo() == null;
            }
            case 10: {
                return pSMobAppPackBase.getOSType() == null;
            }
            case 11: {
                return pSMobAppPackBase.getOSTypes() == null;
            }
            case 12: {
                return pSMobAppPackBase.getPackType() == null;
            }
            case 13: {
                return pSMobAppPackBase.getPkgName() == null;
            }
            case 14: {
                return pSMobAppPackBase.getPSDCMobPackCertId() == null;
            }
            case 15: {
                return pSMobAppPackBase.getPSDCMobPackCertName() == null;
            }
            case 16: {
                return pSMobAppPackBase.getPSMobAppPackId() == null;
            }
            case 17: {
                return pSMobAppPackBase.getPSMobAppPackName() == null;
            }
            case 18: {
                return pSMobAppPackBase.getPSSysAppId() == null;
            }
            case 19: {
                return pSMobAppPackBase.getPSSysAppName() == null;
            }
            case 20: {
                return pSMobAppPackBase.getServiceUrl() == null;
            }
            case 21: {
                return pSMobAppPackBase.getTDCnt() == null;
            }
            case 22: {
                return pSMobAppPackBase.getUpdateDate() == null;
            }
            case 23: {
                return pSMobAppPackBase.getUpdateMan() == null;
            }
            case 24: {
                return pSMobAppPackBase.getUserParams() == null;
            }
            case 25: {
                return pSMobAppPackBase.getUserTag() == null;
            }
            case 26: {
                return pSMobAppPackBase.getUserTag2() == null;
            }
            case 27: {
                return pSMobAppPackBase.getUserTag3() == null;
            }
            case 28: {
                return pSMobAppPackBase.getUserTag4() == null;
            }
            case 29: {
                return pSMobAppPackBase.getVersion() == null;
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
        return PSMobAppPackBase.contains(this, n);
    }

    private static boolean contains(PSMobAppPackBase pSMobAppPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackBase.isAndroidPermissionsDirty();
            }
            case 1: {
                return pSMobAppPackBase.isCodeNameDirty();
            }
            case 2: {
                return pSMobAppPackBase.isCreateDateDirty();
            }
            case 3: {
                return pSMobAppPackBase.isCreateManDirty();
            }
            case 4: {
                return pSMobAppPackBase.isEnableAndroidDirty();
            }
            case 5: {
                return pSMobAppPackBase.isEnableEncryptionDirty();
            }
            case 6: {
                return pSMobAppPackBase.isEnableIOSDirty();
            }
            case 7: {
                return pSMobAppPackBase.isIOSDevicesDirty();
            }
            case 8: {
                return pSMobAppPackBase.isIOSPrivaciesDirty();
            }
            case 9: {
                return pSMobAppPackBase.isMemoDirty();
            }
            case 10: {
                return pSMobAppPackBase.isOSTypeDirty();
            }
            case 11: {
                return pSMobAppPackBase.isOSTypesDirty();
            }
            case 12: {
                return pSMobAppPackBase.isPackTypeDirty();
            }
            case 13: {
                return pSMobAppPackBase.isPkgNameDirty();
            }
            case 14: {
                return pSMobAppPackBase.isPSDCMobPackCertIdDirty();
            }
            case 15: {
                return pSMobAppPackBase.isPSDCMobPackCertNameDirty();
            }
            case 16: {
                return pSMobAppPackBase.isPSMobAppPackIdDirty();
            }
            case 17: {
                return pSMobAppPackBase.isPSMobAppPackNameDirty();
            }
            case 18: {
                return pSMobAppPackBase.isPSSysAppIdDirty();
            }
            case 19: {
                return pSMobAppPackBase.isPSSysAppNameDirty();
            }
            case 20: {
                return pSMobAppPackBase.isServiceUrlDirty();
            }
            case 21: {
                return pSMobAppPackBase.isTDCntDirty();
            }
            case 22: {
                return pSMobAppPackBase.isUpdateDateDirty();
            }
            case 23: {
                return pSMobAppPackBase.isUpdateManDirty();
            }
            case 24: {
                return pSMobAppPackBase.isUserParamsDirty();
            }
            case 25: {
                return pSMobAppPackBase.isUserTagDirty();
            }
            case 26: {
                return pSMobAppPackBase.isUserTag2Dirty();
            }
            case 27: {
                return pSMobAppPackBase.isUserTag3Dirty();
            }
            case 28: {
                return pSMobAppPackBase.isUserTag4Dirty();
            }
            case 29: {
                return pSMobAppPackBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMobAppPackBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMobAppPackBase pSMobAppPackBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMobAppPackBase.getAndroidPermissions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"androidpermissions", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getAndroidPermissions()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getCodeName()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getEnableAndroid() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableandroid", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getEnableAndroid()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getEnableEncryption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableencryption", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getEnableEncryption()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getEnableIOS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableios", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getEnableIOS()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getIOSDevices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iosdevices", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getIOSDevices()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getIOSPrivacies() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iosprivacies", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getIOSPrivacies()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getMemo()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getOSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ostype", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getOSType()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getOSTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ostypes", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getOSTypes()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPackType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packtype", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPackType()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgname", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPkgName()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSDCMobPackCertId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertid", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSDCMobPackCertId()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSDCMobPackCertName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobpackcertname", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSDCMobPackCertName()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSMobAppPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackid", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSMobAppPackId()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSMobAppPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackname", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSMobAppPackName()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getTDCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tdcnt", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getTDCnt()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUserParams()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUserTag()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSMobAppPackBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSMobAppPackBase.getJSONValue((Object)pSMobAppPackBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMobAppPackBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMobAppPackBase pSMobAppPackBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMobAppPackBase.getAndroidPermissions() != null) {
            object = pSMobAppPackBase.getAndroidPermissions();
            xmlNode.setAttribute(FIELD_ANDROIDPERMISSIONS, (String)(object == null ? "" : object));
        }
        if (bl || pSMobAppPackBase.getCodeName() != null) {
            object = pSMobAppPackBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getCreateDate() != null) {
            object = pSMobAppPackBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackBase.getCreateMan() != null) {
            object = pSMobAppPackBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getEnableAndroid() != null) {
            object = pSMobAppPackBase.getEnableAndroid();
            xmlNode.setAttribute(FIELD_ENABLEANDROID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMobAppPackBase.getEnableEncryption() != null) {
            object = pSMobAppPackBase.getEnableEncryption();
            xmlNode.setAttribute(FIELD_ENABLEENCRYPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMobAppPackBase.getEnableIOS() != null) {
            object = pSMobAppPackBase.getEnableIOS();
            xmlNode.setAttribute(FIELD_ENABLEIOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMobAppPackBase.getIOSDevices() != null) {
            object = pSMobAppPackBase.getIOSDevices();
            xmlNode.setAttribute(FIELD_IOSDEVICES, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getIOSPrivacies() != null) {
            object = pSMobAppPackBase.getIOSPrivacies();
            xmlNode.setAttribute(FIELD_IOSPRIVACIES, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getMemo() != null) {
            object = pSMobAppPackBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getOSType() != null) {
            object = pSMobAppPackBase.getOSType();
            xmlNode.setAttribute(FIELD_OSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getOSTypes() != null) {
            object = pSMobAppPackBase.getOSTypes();
            xmlNode.setAttribute(FIELD_OSTYPES, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPackType() != null) {
            object = pSMobAppPackBase.getPackType();
            xmlNode.setAttribute(FIELD_PACKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPkgName() != null) {
            object = pSMobAppPackBase.getPkgName();
            xmlNode.setAttribute(FIELD_PKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSDCMobPackCertId() != null) {
            object = pSMobAppPackBase.getPSDCMobPackCertId();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSDCMobPackCertName() != null) {
            object = pSMobAppPackBase.getPSDCMobPackCertName();
            xmlNode.setAttribute(FIELD_PSDCMOBPACKCERTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSMobAppPackId() != null) {
            object = pSMobAppPackBase.getPSMobAppPackId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSMobAppPackName() != null) {
            object = pSMobAppPackBase.getPSMobAppPackName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSSysAppId() != null) {
            object = pSMobAppPackBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getPSSysAppName() != null) {
            object = pSMobAppPackBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getServiceUrl() != null) {
            object = pSMobAppPackBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getTDCnt() != null) {
            object = pSMobAppPackBase.getTDCnt();
            xmlNode.setAttribute(FIELD_TDCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMobAppPackBase.getUpdateDate() != null) {
            object = pSMobAppPackBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackBase.getUpdateMan() != null) {
            object = pSMobAppPackBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getUserParams() != null) {
            object = pSMobAppPackBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getUserTag() != null) {
            object = pSMobAppPackBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getUserTag2() != null) {
            object = pSMobAppPackBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getUserTag3() != null) {
            object = pSMobAppPackBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getUserTag4() != null) {
            object = pSMobAppPackBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackBase.getVersion() != null) {
            object = pSMobAppPackBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMobAppPackBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMobAppPackBase pSMobAppPackBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMobAppPackBase.isAndroidPermissionsDirty() && (bl || pSMobAppPackBase.getAndroidPermissions() != null)) {
            iDataObject.set(FIELD_ANDROIDPERMISSIONS, (Object)pSMobAppPackBase.getAndroidPermissions());
        }
        if (pSMobAppPackBase.isCodeNameDirty() && (bl || pSMobAppPackBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSMobAppPackBase.getCodeName());
        }
        if (pSMobAppPackBase.isCreateDateDirty() && (bl || pSMobAppPackBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMobAppPackBase.getCreateDate());
        }
        if (pSMobAppPackBase.isCreateManDirty() && (bl || pSMobAppPackBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMobAppPackBase.getCreateMan());
        }
        if (pSMobAppPackBase.isEnableAndroidDirty() && (bl || pSMobAppPackBase.getEnableAndroid() != null)) {
            iDataObject.set(FIELD_ENABLEANDROID, (Object)pSMobAppPackBase.getEnableAndroid());
        }
        if (pSMobAppPackBase.isEnableEncryptionDirty() && (bl || pSMobAppPackBase.getEnableEncryption() != null)) {
            iDataObject.set(FIELD_ENABLEENCRYPTION, (Object)pSMobAppPackBase.getEnableEncryption());
        }
        if (pSMobAppPackBase.isEnableIOSDirty() && (bl || pSMobAppPackBase.getEnableIOS() != null)) {
            iDataObject.set(FIELD_ENABLEIOS, (Object)pSMobAppPackBase.getEnableIOS());
        }
        if (pSMobAppPackBase.isIOSDevicesDirty() && (bl || pSMobAppPackBase.getIOSDevices() != null)) {
            iDataObject.set(FIELD_IOSDEVICES, (Object)pSMobAppPackBase.getIOSDevices());
        }
        if (pSMobAppPackBase.isIOSPrivaciesDirty() && (bl || pSMobAppPackBase.getIOSPrivacies() != null)) {
            iDataObject.set(FIELD_IOSPRIVACIES, (Object)pSMobAppPackBase.getIOSPrivacies());
        }
        if (pSMobAppPackBase.isMemoDirty() && (bl || pSMobAppPackBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMobAppPackBase.getMemo());
        }
        if (pSMobAppPackBase.isOSTypeDirty() && (bl || pSMobAppPackBase.getOSType() != null)) {
            iDataObject.set(FIELD_OSTYPE, (Object)pSMobAppPackBase.getOSType());
        }
        if (pSMobAppPackBase.isOSTypesDirty() && (bl || pSMobAppPackBase.getOSTypes() != null)) {
            iDataObject.set(FIELD_OSTYPES, (Object)pSMobAppPackBase.getOSTypes());
        }
        if (pSMobAppPackBase.isPackTypeDirty() && (bl || pSMobAppPackBase.getPackType() != null)) {
            iDataObject.set(FIELD_PACKTYPE, (Object)pSMobAppPackBase.getPackType());
        }
        if (pSMobAppPackBase.isPkgNameDirty() && (bl || pSMobAppPackBase.getPkgName() != null)) {
            iDataObject.set(FIELD_PKGNAME, (Object)pSMobAppPackBase.getPkgName());
        }
        if (pSMobAppPackBase.isPSDCMobPackCertIdDirty() && (bl || pSMobAppPackBase.getPSDCMobPackCertId() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTID, (Object)pSMobAppPackBase.getPSDCMobPackCertId());
        }
        if (pSMobAppPackBase.isPSDCMobPackCertNameDirty() && (bl || pSMobAppPackBase.getPSDCMobPackCertName() != null)) {
            iDataObject.set(FIELD_PSDCMOBPACKCERTNAME, (Object)pSMobAppPackBase.getPSDCMobPackCertName());
        }
        if (pSMobAppPackBase.isPSMobAppPackIdDirty() && (bl || pSMobAppPackBase.getPSMobAppPackId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKID, (Object)pSMobAppPackBase.getPSMobAppPackId());
        }
        if (pSMobAppPackBase.isPSMobAppPackNameDirty() && (bl || pSMobAppPackBase.getPSMobAppPackName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKNAME, (Object)pSMobAppPackBase.getPSMobAppPackName());
        }
        if (pSMobAppPackBase.isPSSysAppIdDirty() && (bl || pSMobAppPackBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSMobAppPackBase.getPSSysAppId());
        }
        if (pSMobAppPackBase.isPSSysAppNameDirty() && (bl || pSMobAppPackBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSMobAppPackBase.getPSSysAppName());
        }
        if (pSMobAppPackBase.isServiceUrlDirty() && (bl || pSMobAppPackBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSMobAppPackBase.getServiceUrl());
        }
        if (pSMobAppPackBase.isTDCntDirty() && (bl || pSMobAppPackBase.getTDCnt() != null)) {
            iDataObject.set(FIELD_TDCNT, (Object)pSMobAppPackBase.getTDCnt());
        }
        if (pSMobAppPackBase.isUpdateDateDirty() && (bl || pSMobAppPackBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMobAppPackBase.getUpdateDate());
        }
        if (pSMobAppPackBase.isUpdateManDirty() && (bl || pSMobAppPackBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMobAppPackBase.getUpdateMan());
        }
        if (pSMobAppPackBase.isUserParamsDirty() && (bl || pSMobAppPackBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSMobAppPackBase.getUserParams());
        }
        if (pSMobAppPackBase.isUserTagDirty() && (bl || pSMobAppPackBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSMobAppPackBase.getUserTag());
        }
        if (pSMobAppPackBase.isUserTag2Dirty() && (bl || pSMobAppPackBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSMobAppPackBase.getUserTag2());
        }
        if (pSMobAppPackBase.isUserTag3Dirty() && (bl || pSMobAppPackBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSMobAppPackBase.getUserTag3());
        }
        if (pSMobAppPackBase.isUserTag4Dirty() && (bl || pSMobAppPackBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSMobAppPackBase.getUserTag4());
        }
        if (pSMobAppPackBase.isVersionDirty() && (bl || pSMobAppPackBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSMobAppPackBase.getVersion());
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
        return PSMobAppPackBase.remove(this, n);
    }

    private static boolean remove(PSMobAppPackBase pSMobAppPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackBase.resetAndroidPermissions();
                return true;
            }
            case 1: {
                pSMobAppPackBase.resetCodeName();
                return true;
            }
            case 2: {
                pSMobAppPackBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSMobAppPackBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSMobAppPackBase.resetEnableAndroid();
                return true;
            }
            case 5: {
                pSMobAppPackBase.resetEnableEncryption();
                return true;
            }
            case 6: {
                pSMobAppPackBase.resetEnableIOS();
                return true;
            }
            case 7: {
                pSMobAppPackBase.resetIOSDevices();
                return true;
            }
            case 8: {
                pSMobAppPackBase.resetIOSPrivacies();
                return true;
            }
            case 9: {
                pSMobAppPackBase.resetMemo();
                return true;
            }
            case 10: {
                pSMobAppPackBase.resetOSType();
                return true;
            }
            case 11: {
                pSMobAppPackBase.resetOSTypes();
                return true;
            }
            case 12: {
                pSMobAppPackBase.resetPackType();
                return true;
            }
            case 13: {
                pSMobAppPackBase.resetPkgName();
                return true;
            }
            case 14: {
                pSMobAppPackBase.resetPSDCMobPackCertId();
                return true;
            }
            case 15: {
                pSMobAppPackBase.resetPSDCMobPackCertName();
                return true;
            }
            case 16: {
                pSMobAppPackBase.resetPSMobAppPackId();
                return true;
            }
            case 17: {
                pSMobAppPackBase.resetPSMobAppPackName();
                return true;
            }
            case 18: {
                pSMobAppPackBase.resetPSSysAppId();
                return true;
            }
            case 19: {
                pSMobAppPackBase.resetPSSysAppName();
                return true;
            }
            case 20: {
                pSMobAppPackBase.resetServiceUrl();
                return true;
            }
            case 21: {
                pSMobAppPackBase.resetTDCnt();
                return true;
            }
            case 22: {
                pSMobAppPackBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSMobAppPackBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSMobAppPackBase.resetUserParams();
                return true;
            }
            case 25: {
                pSMobAppPackBase.resetUserTag();
                return true;
            }
            case 26: {
                pSMobAppPackBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSMobAppPackBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSMobAppPackBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSMobAppPackBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMobPackCert getPSDCMobPackCert() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobPackCert();
        }
        if (this.getPSDCMobPackCertId() == null) {
            return null;
        }
        Integer n = this.objPSDCMobPackCertLock;
        synchronized (n) {
            if (this.psdcmobpackcert != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMobPackCertId(), (Object)this.psdcmobpackcert.getPSDCMobPackCertId()) != 0L) {
                this.psdcmobpackcert = null;
            }
            if (this.psdcmobpackcert == null) {
                PSDCMobPackCert pSDCMobPackCert = new PSDCMobPackCert();
                pSDCMobPackCert.setPSDCMobPackCertId(this.getPSDCMobPackCertId());
                PSDCMobPackCertService pSDCMobPackCertService = (PSDCMobPackCertService)ServiceGlobal.getService(PSDCMobPackCertService.class, (SessionFactory)this.getSessionFactory());
                pSDCMobPackCertService.autoGet(pSDCMobPackCert);
                this.psdcmobpackcert = pSDCMobPackCert;
            }
            return this.psdcmobpackcert;
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
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSMobAppPackBase getProxyEntity() {
        return this.proxyPSMobAppPackBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMobAppPackBase = null;
        if (iDataObject != null && iDataObject instanceof PSMobAppPackBase) {
            this.proxyPSMobAppPackBase = (PSMobAppPackBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ANDROIDPERMISSIONS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENABLEANDROID, 4);
        fieldIndexMap.put(FIELD_ENABLEENCRYPTION, 5);
        fieldIndexMap.put(FIELD_ENABLEIOS, 6);
        fieldIndexMap.put(FIELD_IOSDEVICES, 7);
        fieldIndexMap.put(FIELD_IOSPRIVACIES, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_OSTYPE, 10);
        fieldIndexMap.put(FIELD_OSTYPES, 11);
        fieldIndexMap.put(FIELD_PACKTYPE, 12);
        fieldIndexMap.put(FIELD_PKGNAME, 13);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTID, 14);
        fieldIndexMap.put(FIELD_PSDCMOBPACKCERTNAME, 15);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKID, 16);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 18);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 19);
        fieldIndexMap.put(FIELD_SERVICEURL, 20);
        fieldIndexMap.put(FIELD_TDCNT, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERPARAMS, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_VERSION, 29);
    }
}

