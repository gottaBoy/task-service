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
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.service.PSPFPkgService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPkgBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PSAPPPKGID = "PSAPPPKGID";
    public static final String FIELD_PSAPPPKGNAME = "PSAPPPKGNAME";
    public static final String FIELD_PSPFPKGID = "PSPFPKGID";
    public static final String FIELD_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String FIELD_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String FIELD_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PKGPARAM = 5;
    private static final int INDEX_PKGPARAM2 = 6;
    private static final int INDEX_PKGPARAM3 = 7;
    private static final int INDEX_PKGPARAM4 = 8;
    private static final int INDEX_PSAPPPKGID = 9;
    private static final int INDEX_PSAPPPKGNAME = 10;
    private static final int INDEX_PSPFPKGID = 11;
    private static final int INDEX_PSPFPKGNAME = 12;
    private static final int INDEX_PSPFPKGVERID = 13;
    private static final int INDEX_PSPFPKGVERNAME = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPkgBase proxyPSAppPkgBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean psapppkgidDirtyFlag = false;
    private boolean psapppkgnameDirtyFlag = false;
    private boolean pspfpkgidDirtyFlag = false;
    private boolean pspfpkgnameDirtyFlag = false;
    private boolean pspfpkgveridDirtyFlag = false;
    private boolean pspfpkgvernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pkgparam")
    private String pkgparam;
    @Column(name="pkgparam2")
    private String pkgparam2;
    @Column(name="pkgparam3")
    private String pkgparam3;
    @Column(name="pkgparam4")
    private String pkgparam4;
    @Column(name="psapppkgid")
    private String psapppkgid;
    @Column(name="psapppkgname")
    private String psapppkgname;
    @Column(name="pspfpkgid")
    private String pspfpkgid;
    @Column(name="pspfpkgname")
    private String pspfpkgname;
    @Column(name="pspfpkgverid")
    private String pspfpkgverid;
    @Column(name="pspfpkgvername")
    private String pspfpkgvername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSPFPkgVerLock = new Integer(1);
    private PSPFPkgVer pspfpkgver = null;
    private Integer objPSPFPkgLock = new Integer(1);
    private PSPFPkg pspfpkg = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPkgParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam = string;
        this.pkgparamDirtyFlag = true;
    }

    public String getPkgParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam();
        }
        return this.pkgparam;
    }

    public boolean isPkgParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParamDirty();
        }
        return this.pkgparamDirtyFlag;
    }

    public void resetPkgParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam();
            return;
        }
        this.pkgparamDirtyFlag = false;
        this.pkgparam = null;
    }

    public void setPkgParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam2 = string;
        this.pkgparam2DirtyFlag = true;
    }

    public String getPkgParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam2();
        }
        return this.pkgparam2;
    }

    public boolean isPkgParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam2Dirty();
        }
        return this.pkgparam2DirtyFlag;
    }

    public void resetPkgParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam2();
            return;
        }
        this.pkgparam2DirtyFlag = false;
        this.pkgparam2 = null;
    }

    public void setPkgParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam3 = string;
        this.pkgparam3DirtyFlag = true;
    }

    public String getPkgParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam3();
        }
        return this.pkgparam3;
    }

    public boolean isPkgParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam3Dirty();
        }
        return this.pkgparam3DirtyFlag;
    }

    public void resetPkgParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam3();
            return;
        }
        this.pkgparam3DirtyFlag = false;
        this.pkgparam3 = null;
    }

    public void setPkgParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam4 = string;
        this.pkgparam4DirtyFlag = true;
    }

    public String getPkgParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam4();
        }
        return this.pkgparam4;
    }

    public boolean isPkgParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam4Dirty();
        }
        return this.pkgparam4DirtyFlag;
    }

    public void resetPkgParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam4();
            return;
        }
        this.pkgparam4DirtyFlag = false;
        this.pkgparam4 = null;
    }

    public void setPSAppPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppkgid = string;
        this.psapppkgidDirtyFlag = true;
    }

    public String getPSAppPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPkgId();
        }
        return this.psapppkgid;
    }

    public boolean isPSAppPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPkgIdDirty();
        }
        return this.psapppkgidDirtyFlag;
    }

    public void resetPSAppPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPkgId();
            return;
        }
        this.psapppkgidDirtyFlag = false;
        this.psapppkgid = null;
    }

    public void setPSAppPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppkgname = string;
        this.psapppkgnameDirtyFlag = true;
    }

    public String getPSAppPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPkgName();
        }
        return this.psapppkgname;
    }

    public boolean isPSAppPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPkgNameDirty();
        }
        return this.psapppkgnameDirtyFlag;
    }

    public void resetPSAppPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPkgName();
            return;
        }
        this.psapppkgnameDirtyFlag = false;
        this.psapppkgname = null;
    }

    public void setPSPFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgid = string;
        this.pspfpkgidDirtyFlag = true;
    }

    public String getPSPFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgId();
        }
        return this.pspfpkgid;
    }

    public boolean isPSPFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgIdDirty();
        }
        return this.pspfpkgidDirtyFlag;
    }

    public void resetPSPFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgId();
            return;
        }
        this.pspfpkgidDirtyFlag = false;
        this.pspfpkgid = null;
    }

    public void setPSPFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgname = string;
        this.pspfpkgnameDirtyFlag = true;
    }

    public String getPSPFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgName();
        }
        return this.pspfpkgname;
    }

    public boolean isPSPFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgNameDirty();
        }
        return this.pspfpkgnameDirtyFlag;
    }

    public void resetPSPFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgName();
            return;
        }
        this.pspfpkgnameDirtyFlag = false;
        this.pspfpkgname = null;
    }

    public void setPSPFPkgVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgverid = string;
        this.pspfpkgveridDirtyFlag = true;
    }

    public String getPSPFPkgVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerId();
        }
        return this.pspfpkgverid;
    }

    public boolean isPSPFPkgVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerIdDirty();
        }
        return this.pspfpkgveridDirtyFlag;
    }

    public void resetPSPFPkgVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerId();
            return;
        }
        this.pspfpkgveridDirtyFlag = false;
        this.pspfpkgverid = null;
    }

    public void setPSPFPkgVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgvername = string;
        this.pspfpkgvernameDirtyFlag = true;
    }

    public String getPSPFPkgVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerName();
        }
        return this.pspfpkgvername;
    }

    public boolean isPSPFPkgVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerNameDirty();
        }
        return this.pspfpkgvernameDirtyFlag;
    }

    public void resetPSPFPkgVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerName();
            return;
        }
        this.pspfpkgvernameDirtyFlag = false;
        this.pspfpkgvername = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    protected void onReset() {
        PSAppPkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPkgBase pSAppPkgBase) {
        pSAppPkgBase.resetCodeName();
        pSAppPkgBase.resetCreateDate();
        pSAppPkgBase.resetCreateMan();
        pSAppPkgBase.resetMemo();
        pSAppPkgBase.resetOrderValue();
        pSAppPkgBase.resetPkgParam();
        pSAppPkgBase.resetPkgParam2();
        pSAppPkgBase.resetPkgParam3();
        pSAppPkgBase.resetPkgParam4();
        pSAppPkgBase.resetPSAppPkgId();
        pSAppPkgBase.resetPSAppPkgName();
        pSAppPkgBase.resetPSPFPkgId();
        pSAppPkgBase.resetPSPFPkgName();
        pSAppPkgBase.resetPSPFPkgVerId();
        pSAppPkgBase.resetPSPFPkgVerName();
        pSAppPkgBase.resetPSSysAppId();
        pSAppPkgBase.resetPSSysAppName();
        pSAppPkgBase.resetUpdateDate();
        pSAppPkgBase.resetUpdateMan();
        pSAppPkgBase.resetUserCat();
        pSAppPkgBase.resetUserTag();
        pSAppPkgBase.resetUserTag2();
        pSAppPkgBase.resetUserTag3();
        pSAppPkgBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPkgParamDirty()) {
            hashMap.put(FIELD_PKGPARAM, this.getPkgParam());
        }
        if (!bl || this.isPkgParam2Dirty()) {
            hashMap.put(FIELD_PKGPARAM2, this.getPkgParam2());
        }
        if (!bl || this.isPkgParam3Dirty()) {
            hashMap.put(FIELD_PKGPARAM3, this.getPkgParam3());
        }
        if (!bl || this.isPkgParam4Dirty()) {
            hashMap.put(FIELD_PKGPARAM4, this.getPkgParam4());
        }
        if (!bl || this.isPSAppPkgIdDirty()) {
            hashMap.put(FIELD_PSAPPPKGID, this.getPSAppPkgId());
        }
        if (!bl || this.isPSAppPkgNameDirty()) {
            hashMap.put(FIELD_PSAPPPKGNAME, this.getPSAppPkgName());
        }
        if (!bl || this.isPSPFPkgIdDirty()) {
            hashMap.put(FIELD_PSPFPKGID, this.getPSPFPkgId());
        }
        if (!bl || this.isPSPFPkgNameDirty()) {
            hashMap.put(FIELD_PSPFPKGNAME, this.getPSPFPkgName());
        }
        if (!bl || this.isPSPFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSPFPKGVERID, this.getPSPFPkgVerId());
        }
        if (!bl || this.isPSPFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSPFPKGVERNAME, this.getPSPFPkgVerName());
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
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        return PSAppPkgBase.get(this, n);
    }

    private static Object get(PSAppPkgBase pSAppPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPkgBase.getCodeName();
            }
            case 1: {
                return pSAppPkgBase.getCreateDate();
            }
            case 2: {
                return pSAppPkgBase.getCreateMan();
            }
            case 3: {
                return pSAppPkgBase.getMemo();
            }
            case 4: {
                return pSAppPkgBase.getOrderValue();
            }
            case 5: {
                return pSAppPkgBase.getPkgParam();
            }
            case 6: {
                return pSAppPkgBase.getPkgParam2();
            }
            case 7: {
                return pSAppPkgBase.getPkgParam3();
            }
            case 8: {
                return pSAppPkgBase.getPkgParam4();
            }
            case 9: {
                return pSAppPkgBase.getPSAppPkgId();
            }
            case 10: {
                return pSAppPkgBase.getPSAppPkgName();
            }
            case 11: {
                return pSAppPkgBase.getPSPFPkgId();
            }
            case 12: {
                return pSAppPkgBase.getPSPFPkgName();
            }
            case 13: {
                return pSAppPkgBase.getPSPFPkgVerId();
            }
            case 14: {
                return pSAppPkgBase.getPSPFPkgVerName();
            }
            case 15: {
                return pSAppPkgBase.getPSSysAppId();
            }
            case 16: {
                return pSAppPkgBase.getPSSysAppName();
            }
            case 17: {
                return pSAppPkgBase.getUpdateDate();
            }
            case 18: {
                return pSAppPkgBase.getUpdateMan();
            }
            case 19: {
                return pSAppPkgBase.getUserCat();
            }
            case 20: {
                return pSAppPkgBase.getUserTag();
            }
            case 21: {
                return pSAppPkgBase.getUserTag2();
            }
            case 22: {
                return pSAppPkgBase.getUserTag3();
            }
            case 23: {
                return pSAppPkgBase.getUserTag4();
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
        PSAppPkgBase.set(this, n, object);
    }

    private static void set(PSAppPkgBase pSAppPkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppPkgBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppPkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppPkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppPkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppPkgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppPkgBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppPkgBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppPkgBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppPkgBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppPkgBase.setPSAppPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppPkgBase.setPSAppPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppPkgBase.setPSPFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppPkgBase.setPSPFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppPkgBase.setPSPFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPkgBase.setPSPFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppPkgBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPkgBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSAppPkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppPkgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppPkgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppPkgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppPkgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppPkgBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppPkgBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPkgBase pSAppPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPkgBase.getCodeName() == null;
            }
            case 1: {
                return pSAppPkgBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppPkgBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppPkgBase.getMemo() == null;
            }
            case 4: {
                return pSAppPkgBase.getOrderValue() == null;
            }
            case 5: {
                return pSAppPkgBase.getPkgParam() == null;
            }
            case 6: {
                return pSAppPkgBase.getPkgParam2() == null;
            }
            case 7: {
                return pSAppPkgBase.getPkgParam3() == null;
            }
            case 8: {
                return pSAppPkgBase.getPkgParam4() == null;
            }
            case 9: {
                return pSAppPkgBase.getPSAppPkgId() == null;
            }
            case 10: {
                return pSAppPkgBase.getPSAppPkgName() == null;
            }
            case 11: {
                return pSAppPkgBase.getPSPFPkgId() == null;
            }
            case 12: {
                return pSAppPkgBase.getPSPFPkgName() == null;
            }
            case 13: {
                return pSAppPkgBase.getPSPFPkgVerId() == null;
            }
            case 14: {
                return pSAppPkgBase.getPSPFPkgVerName() == null;
            }
            case 15: {
                return pSAppPkgBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSAppPkgBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSAppPkgBase.getUpdateDate() == null;
            }
            case 18: {
                return pSAppPkgBase.getUpdateMan() == null;
            }
            case 19: {
                return pSAppPkgBase.getUserCat() == null;
            }
            case 20: {
                return pSAppPkgBase.getUserTag() == null;
            }
            case 21: {
                return pSAppPkgBase.getUserTag2() == null;
            }
            case 22: {
                return pSAppPkgBase.getUserTag3() == null;
            }
            case 23: {
                return pSAppPkgBase.getUserTag4() == null;
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
        return PSAppPkgBase.contains(this, n);
    }

    private static boolean contains(PSAppPkgBase pSAppPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPkgBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppPkgBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppPkgBase.isCreateManDirty();
            }
            case 3: {
                return pSAppPkgBase.isMemoDirty();
            }
            case 4: {
                return pSAppPkgBase.isOrderValueDirty();
            }
            case 5: {
                return pSAppPkgBase.isPkgParamDirty();
            }
            case 6: {
                return pSAppPkgBase.isPkgParam2Dirty();
            }
            case 7: {
                return pSAppPkgBase.isPkgParam3Dirty();
            }
            case 8: {
                return pSAppPkgBase.isPkgParam4Dirty();
            }
            case 9: {
                return pSAppPkgBase.isPSAppPkgIdDirty();
            }
            case 10: {
                return pSAppPkgBase.isPSAppPkgNameDirty();
            }
            case 11: {
                return pSAppPkgBase.isPSPFPkgIdDirty();
            }
            case 12: {
                return pSAppPkgBase.isPSPFPkgNameDirty();
            }
            case 13: {
                return pSAppPkgBase.isPSPFPkgVerIdDirty();
            }
            case 14: {
                return pSAppPkgBase.isPSPFPkgVerNameDirty();
            }
            case 15: {
                return pSAppPkgBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSAppPkgBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSAppPkgBase.isUpdateDateDirty();
            }
            case 18: {
                return pSAppPkgBase.isUpdateManDirty();
            }
            case 19: {
                return pSAppPkgBase.isUserCatDirty();
            }
            case 20: {
                return pSAppPkgBase.isUserTagDirty();
            }
            case 21: {
                return pSAppPkgBase.isUserTag2Dirty();
            }
            case 22: {
                return pSAppPkgBase.isUserTag3Dirty();
            }
            case 23: {
                return pSAppPkgBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPkgBase pSAppPkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPkgBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSAppPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppkgid", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSAppPkgId()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSAppPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppkgname", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSAppPkgName()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSPFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgid", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSPFPkgId()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSPFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgname", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSPFPkgName()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSPFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgverid", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSPFPkgVerId()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSPFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvername", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSPFPkgVerName()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppPkgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppPkgBase.getJSONValue((Object)pSAppPkgBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPkgBase pSAppPkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPkgBase.getCodeName() != null) {
            object = pSAppPkgBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getCreateDate() != null) {
            object = pSAppPkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPkgBase.getCreateMan() != null) {
            object = pSAppPkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getMemo() != null) {
            object = pSAppPkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getOrderValue() != null) {
            object = pSAppPkgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPkgBase.getPkgParam() != null) {
            object = pSAppPkgBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPkgParam2() != null) {
            object = pSAppPkgBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPkgParam3() != null) {
            object = pSAppPkgBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPkgParam4() != null) {
            object = pSAppPkgBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSAppPkgId() != null) {
            object = pSAppPkgBase.getPSAppPkgId();
            xmlNode.setAttribute(FIELD_PSAPPPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSAppPkgName() != null) {
            object = pSAppPkgBase.getPSAppPkgName();
            xmlNode.setAttribute(FIELD_PSAPPPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSPFPkgId() != null) {
            object = pSAppPkgBase.getPSPFPkgId();
            xmlNode.setAttribute(FIELD_PSPFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSPFPkgName() != null) {
            object = pSAppPkgBase.getPSPFPkgName();
            xmlNode.setAttribute(FIELD_PSPFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSPFPkgVerId() != null) {
            object = pSAppPkgBase.getPSPFPkgVerId();
            xmlNode.setAttribute(FIELD_PSPFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSPFPkgVerName() != null) {
            object = pSAppPkgBase.getPSPFPkgVerName();
            xmlNode.setAttribute(FIELD_PSPFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSSysAppId() != null) {
            object = pSAppPkgBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getPSSysAppName() != null) {
            object = pSAppPkgBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUpdateDate() != null) {
            object = pSAppPkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPkgBase.getUpdateMan() != null) {
            object = pSAppPkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUserCat() != null) {
            object = pSAppPkgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUserTag() != null) {
            object = pSAppPkgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUserTag2() != null) {
            object = pSAppPkgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUserTag3() != null) {
            object = pSAppPkgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppPkgBase.getUserTag4() != null) {
            object = pSAppPkgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPkgBase pSAppPkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPkgBase.isCodeNameDirty() && (bl || pSAppPkgBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppPkgBase.getCodeName());
        }
        if (pSAppPkgBase.isCreateDateDirty() && (bl || pSAppPkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPkgBase.getCreateDate());
        }
        if (pSAppPkgBase.isCreateManDirty() && (bl || pSAppPkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPkgBase.getCreateMan());
        }
        if (pSAppPkgBase.isMemoDirty() && (bl || pSAppPkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppPkgBase.getMemo());
        }
        if (pSAppPkgBase.isOrderValueDirty() && (bl || pSAppPkgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppPkgBase.getOrderValue());
        }
        if (pSAppPkgBase.isPkgParamDirty() && (bl || pSAppPkgBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSAppPkgBase.getPkgParam());
        }
        if (pSAppPkgBase.isPkgParam2Dirty() && (bl || pSAppPkgBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSAppPkgBase.getPkgParam2());
        }
        if (pSAppPkgBase.isPkgParam3Dirty() && (bl || pSAppPkgBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSAppPkgBase.getPkgParam3());
        }
        if (pSAppPkgBase.isPkgParam4Dirty() && (bl || pSAppPkgBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSAppPkgBase.getPkgParam4());
        }
        if (pSAppPkgBase.isPSAppPkgIdDirty() && (bl || pSAppPkgBase.getPSAppPkgId() != null)) {
            iDataObject.set(FIELD_PSAPPPKGID, (Object)pSAppPkgBase.getPSAppPkgId());
        }
        if (pSAppPkgBase.isPSAppPkgNameDirty() && (bl || pSAppPkgBase.getPSAppPkgName() != null)) {
            iDataObject.set(FIELD_PSAPPPKGNAME, (Object)pSAppPkgBase.getPSAppPkgName());
        }
        if (pSAppPkgBase.isPSPFPkgIdDirty() && (bl || pSAppPkgBase.getPSPFPkgId() != null)) {
            iDataObject.set(FIELD_PSPFPKGID, (Object)pSAppPkgBase.getPSPFPkgId());
        }
        if (pSAppPkgBase.isPSPFPkgNameDirty() && (bl || pSAppPkgBase.getPSPFPkgName() != null)) {
            iDataObject.set(FIELD_PSPFPKGNAME, (Object)pSAppPkgBase.getPSPFPkgName());
        }
        if (pSAppPkgBase.isPSPFPkgVerIdDirty() && (bl || pSAppPkgBase.getPSPFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERID, (Object)pSAppPkgBase.getPSPFPkgVerId());
        }
        if (pSAppPkgBase.isPSPFPkgVerNameDirty() && (bl || pSAppPkgBase.getPSPFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERNAME, (Object)pSAppPkgBase.getPSPFPkgVerName());
        }
        if (pSAppPkgBase.isPSSysAppIdDirty() && (bl || pSAppPkgBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppPkgBase.getPSSysAppId());
        }
        if (pSAppPkgBase.isPSSysAppNameDirty() && (bl || pSAppPkgBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppPkgBase.getPSSysAppName());
        }
        if (pSAppPkgBase.isUpdateDateDirty() && (bl || pSAppPkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPkgBase.getUpdateDate());
        }
        if (pSAppPkgBase.isUpdateManDirty() && (bl || pSAppPkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPkgBase.getUpdateMan());
        }
        if (pSAppPkgBase.isUserCatDirty() && (bl || pSAppPkgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppPkgBase.getUserCat());
        }
        if (pSAppPkgBase.isUserTagDirty() && (bl || pSAppPkgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppPkgBase.getUserTag());
        }
        if (pSAppPkgBase.isUserTag2Dirty() && (bl || pSAppPkgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppPkgBase.getUserTag2());
        }
        if (pSAppPkgBase.isUserTag3Dirty() && (bl || pSAppPkgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppPkgBase.getUserTag3());
        }
        if (pSAppPkgBase.isUserTag4Dirty() && (bl || pSAppPkgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppPkgBase.getUserTag4());
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
        return PSAppPkgBase.remove(this, n);
    }

    private static boolean remove(PSAppPkgBase pSAppPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppPkgBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppPkgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppPkgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppPkgBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppPkgBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSAppPkgBase.resetPkgParam();
                return true;
            }
            case 6: {
                pSAppPkgBase.resetPkgParam2();
                return true;
            }
            case 7: {
                pSAppPkgBase.resetPkgParam3();
                return true;
            }
            case 8: {
                pSAppPkgBase.resetPkgParam4();
                return true;
            }
            case 9: {
                pSAppPkgBase.resetPSAppPkgId();
                return true;
            }
            case 10: {
                pSAppPkgBase.resetPSAppPkgName();
                return true;
            }
            case 11: {
                pSAppPkgBase.resetPSPFPkgId();
                return true;
            }
            case 12: {
                pSAppPkgBase.resetPSPFPkgName();
                return true;
            }
            case 13: {
                pSAppPkgBase.resetPSPFPkgVerId();
                return true;
            }
            case 14: {
                pSAppPkgBase.resetPSPFPkgVerName();
                return true;
            }
            case 15: {
                pSAppPkgBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSAppPkgBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSAppPkgBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSAppPkgBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSAppPkgBase.resetUserCat();
                return true;
            }
            case 20: {
                pSAppPkgBase.resetUserTag();
                return true;
            }
            case 21: {
                pSAppPkgBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSAppPkgBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSAppPkgBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPkgVer getPSPFPkgVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVer();
        }
        if (this.getPSPFPkgVerId() == null) {
            return null;
        }
        Integer n = this.objPSPFPkgVerLock;
        synchronized (n) {
            if (this.pspfpkgver != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPkgVerId(), (Object)this.pspfpkgver.getPSPFPkgVerId()) != 0L) {
                this.pspfpkgver = null;
            }
            if (this.pspfpkgver == null) {
                PSPFPkgVer pSPFPkgVer = new PSPFPkgVer();
                pSPFPkgVer.setPSPFPkgVerId(this.getPSPFPkgVerId());
                PSPFPkgVerService pSPFPkgVerService = (PSPFPkgVerService)ServiceGlobal.getService(PSPFPkgVerService.class, (SessionFactory)this.getSessionFactory());
                pSPFPkgVerService.autoGet(pSPFPkgVer);
                this.pspfpkgver = pSPFPkgVer;
            }
            return this.pspfpkgver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPkg getPSPFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkg();
        }
        if (this.getPSPFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSPFPkgLock;
        synchronized (n) {
            if (this.pspfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPkgId(), (Object)this.pspfpkg.getPSPFPkgId()) != 0L) {
                this.pspfpkg = null;
            }
            if (this.pspfpkg == null) {
                PSPFPkg pSPFPkg = new PSPFPkg();
                pSPFPkg.setPSPFPkgId(this.getPSPFPkgId());
                PSPFPkgService pSPFPkgService = (PSPFPkgService)ServiceGlobal.getService(PSPFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSPFPkgService.autoGet(pSPFPkg);
                this.pspfpkg = pSPFPkg;
            }
            return this.pspfpkg;
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

    private PSAppPkgBase getProxyEntity() {
        return this.proxyPSAppPkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPkgBase) {
            this.proxyPSAppPkgBase = (PSAppPkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PKGPARAM, 5);
        fieldIndexMap.put(FIELD_PKGPARAM2, 6);
        fieldIndexMap.put(FIELD_PKGPARAM3, 7);
        fieldIndexMap.put(FIELD_PKGPARAM4, 8);
        fieldIndexMap.put(FIELD_PSAPPPKGID, 9);
        fieldIndexMap.put(FIELD_PSAPPPKGNAME, 10);
        fieldIndexMap.put(FIELD_PSPFPKGID, 11);
        fieldIndexMap.put(FIELD_PSPFPKGNAME, 12);
        fieldIndexMap.put(FIELD_PSPFPKGVERID, 13);
        fieldIndexMap.put(FIELD_PSPFPKGVERNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
    }
}

