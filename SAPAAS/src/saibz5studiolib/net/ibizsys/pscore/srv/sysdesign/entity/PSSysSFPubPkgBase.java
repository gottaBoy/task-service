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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVer;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubPkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFPubPkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PSSFPKGID = "PSSFPKGID";
    public static final String FIELD_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String FIELD_PSSFPKGVERID = "PSSFPKGVERID";
    public static final String FIELD_PSSFPKGVERNAME = "PSSFPKGVERNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSSFPUBPKGID = "PSSYSSFPUBPKGID";
    public static final String FIELD_PSSYSSFPUBPKGNAME = "PSSYSSFPUBPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PKGPARAM = 4;
    private static final int INDEX_PKGPARAM2 = 5;
    private static final int INDEX_PKGPARAM3 = 6;
    private static final int INDEX_PKGPARAM4 = 7;
    private static final int INDEX_PSSFPKGID = 8;
    private static final int INDEX_PSSFPKGNAME = 9;
    private static final int INDEX_PSSFPKGVERID = 10;
    private static final int INDEX_PSSFPKGVERNAME = 11;
    private static final int INDEX_PSSYSSFPUBID = 12;
    private static final int INDEX_PSSYSSFPUBNAME = 13;
    private static final int INDEX_PSSYSSFPUBPKGID = 14;
    private static final int INDEX_PSSYSSFPUBPKGNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFPubPkgBase proxyPSSysSFPubPkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean pssfpkgidDirtyFlag = false;
    private boolean pssfpkgnameDirtyFlag = false;
    private boolean pssfpkgveridDirtyFlag = false;
    private boolean pssfpkgvernameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssyssfpubpkgidDirtyFlag = false;
    private boolean pssyssfpubpkgnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
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
    @Column(name="pssfpkgid")
    private String pssfpkgid;
    @Column(name="pssfpkgname")
    private String pssfpkgname;
    @Column(name="pssfpkgverid")
    private String pssfpkgverid;
    @Column(name="pssfpkgvername")
    private String pssfpkgvername;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssyssfpubpkgid")
    private String pssyssfpubpkgid;
    @Column(name="pssyssfpubpkgname")
    private String pssyssfpubpkgname;
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
    private Integer objPSSFPkgVerLock = new Integer(1);
    private PSSFPkgVer pssfpkgver = null;
    private Integer objPSSFPkgLock = new Integer(1);
    private PSSFPkg pssfpkg = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;

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

    public void setPSSFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgid = string;
        this.pssfpkgidDirtyFlag = true;
    }

    public String getPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgId();
        }
        return this.pssfpkgid;
    }

    public boolean isPSSFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgIdDirty();
        }
        return this.pssfpkgidDirtyFlag;
    }

    public void resetPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgId();
            return;
        }
        this.pssfpkgidDirtyFlag = false;
        this.pssfpkgid = null;
    }

    public void setPSSFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgname = string;
        this.pssfpkgnameDirtyFlag = true;
    }

    public String getPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgName();
        }
        return this.pssfpkgname;
    }

    public boolean isPSSFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgNameDirty();
        }
        return this.pssfpkgnameDirtyFlag;
    }

    public void resetPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgName();
            return;
        }
        this.pssfpkgnameDirtyFlag = false;
        this.pssfpkgname = null;
    }

    public void setPSSFPkgVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgverid = string;
        this.pssfpkgveridDirtyFlag = true;
    }

    public String getPSSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVerId();
        }
        return this.pssfpkgverid;
    }

    public boolean isPSSFPkgVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgVerIdDirty();
        }
        return this.pssfpkgveridDirtyFlag;
    }

    public void resetPSSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgVerId();
            return;
        }
        this.pssfpkgveridDirtyFlag = false;
        this.pssfpkgverid = null;
    }

    public void setPSSFPkgVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgvername = string;
        this.pssfpkgvernameDirtyFlag = true;
    }

    public String getPSSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVerName();
        }
        return this.pssfpkgvername;
    }

    public boolean isPSSFPkgVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgVerNameDirty();
        }
        return this.pssfpkgvernameDirtyFlag;
    }

    public void resetPSSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgVerName();
            return;
        }
        this.pssfpkgvernameDirtyFlag = false;
        this.pssfpkgvername = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
    }

    public void setPSSysSFPubPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubpkgid = string;
        this.pssyssfpubpkgidDirtyFlag = true;
    }

    public String getPSSysSFPubPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubPkgId();
        }
        return this.pssyssfpubpkgid;
    }

    public boolean isPSSysSFPubPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubPkgIdDirty();
        }
        return this.pssyssfpubpkgidDirtyFlag;
    }

    public void resetPSSysSFPubPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubPkgId();
            return;
        }
        this.pssyssfpubpkgidDirtyFlag = false;
        this.pssyssfpubpkgid = null;
    }

    public void setPSSysSFPubPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubpkgname = string;
        this.pssyssfpubpkgnameDirtyFlag = true;
    }

    public String getPSSysSFPubPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubPkgName();
        }
        return this.pssyssfpubpkgname;
    }

    public boolean isPSSysSFPubPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubPkgNameDirty();
        }
        return this.pssyssfpubpkgnameDirtyFlag;
    }

    public void resetPSSysSFPubPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubPkgName();
            return;
        }
        this.pssyssfpubpkgnameDirtyFlag = false;
        this.pssyssfpubpkgname = null;
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
        PSSysSFPubPkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFPubPkgBase pSSysSFPubPkgBase) {
        pSSysSFPubPkgBase.resetCreateDate();
        pSSysSFPubPkgBase.resetCreateMan();
        pSSysSFPubPkgBase.resetMemo();
        pSSysSFPubPkgBase.resetOrderValue();
        pSSysSFPubPkgBase.resetPkgParam();
        pSSysSFPubPkgBase.resetPkgParam2();
        pSSysSFPubPkgBase.resetPkgParam3();
        pSSysSFPubPkgBase.resetPkgParam4();
        pSSysSFPubPkgBase.resetPSSFPkgId();
        pSSysSFPubPkgBase.resetPSSFPkgName();
        pSSysSFPubPkgBase.resetPSSFPkgVerId();
        pSSysSFPubPkgBase.resetPSSFPkgVerName();
        pSSysSFPubPkgBase.resetPSSysSFPubId();
        pSSysSFPubPkgBase.resetPSSysSFPubName();
        pSSysSFPubPkgBase.resetPSSysSFPubPkgId();
        pSSysSFPubPkgBase.resetPSSysSFPubPkgName();
        pSSysSFPubPkgBase.resetUpdateDate();
        pSSysSFPubPkgBase.resetUpdateMan();
        pSSysSFPubPkgBase.resetUserCat();
        pSSysSFPubPkgBase.resetUserTag();
        pSSysSFPubPkgBase.resetUserTag2();
        pSSysSFPubPkgBase.resetUserTag3();
        pSSysSFPubPkgBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSSFPkgIdDirty()) {
            hashMap.put(FIELD_PSSFPKGID, this.getPSSFPkgId());
        }
        if (!bl || this.isPSSFPkgNameDirty()) {
            hashMap.put(FIELD_PSSFPKGNAME, this.getPSSFPkgName());
        }
        if (!bl || this.isPSSFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSSFPKGVERID, this.getPSSFPkgVerId());
        }
        if (!bl || this.isPSSFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSSFPKGVERNAME, this.getPSSFPkgVerName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSysSFPubPkgIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBPKGID, this.getPSSysSFPubPkgId());
        }
        if (!bl || this.isPSSysSFPubPkgNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBPKGNAME, this.getPSSysSFPubPkgName());
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
        return PSSysSFPubPkgBase.get(this, n);
    }

    private static Object get(PSSysSFPubPkgBase pSSysSFPubPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubPkgBase.getCreateDate();
            }
            case 1: {
                return pSSysSFPubPkgBase.getCreateMan();
            }
            case 2: {
                return pSSysSFPubPkgBase.getMemo();
            }
            case 3: {
                return pSSysSFPubPkgBase.getOrderValue();
            }
            case 4: {
                return pSSysSFPubPkgBase.getPkgParam();
            }
            case 5: {
                return pSSysSFPubPkgBase.getPkgParam2();
            }
            case 6: {
                return pSSysSFPubPkgBase.getPkgParam3();
            }
            case 7: {
                return pSSysSFPubPkgBase.getPkgParam4();
            }
            case 8: {
                return pSSysSFPubPkgBase.getPSSFPkgId();
            }
            case 9: {
                return pSSysSFPubPkgBase.getPSSFPkgName();
            }
            case 10: {
                return pSSysSFPubPkgBase.getPSSFPkgVerId();
            }
            case 11: {
                return pSSysSFPubPkgBase.getPSSFPkgVerName();
            }
            case 12: {
                return pSSysSFPubPkgBase.getPSSysSFPubId();
            }
            case 13: {
                return pSSysSFPubPkgBase.getPSSysSFPubName();
            }
            case 14: {
                return pSSysSFPubPkgBase.getPSSysSFPubPkgId();
            }
            case 15: {
                return pSSysSFPubPkgBase.getPSSysSFPubPkgName();
            }
            case 16: {
                return pSSysSFPubPkgBase.getUpdateDate();
            }
            case 17: {
                return pSSysSFPubPkgBase.getUpdateMan();
            }
            case 18: {
                return pSSysSFPubPkgBase.getUserCat();
            }
            case 19: {
                return pSSysSFPubPkgBase.getUserTag();
            }
            case 20: {
                return pSSysSFPubPkgBase.getUserTag2();
            }
            case 21: {
                return pSSysSFPubPkgBase.getUserTag3();
            }
            case 22: {
                return pSSysSFPubPkgBase.getUserTag4();
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
        PSSysSFPubPkgBase.set(this, n, object);
    }

    private static void set(PSSysSFPubPkgBase pSSysSFPubPkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubPkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFPubPkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFPubPkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFPubPkgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFPubPkgBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFPubPkgBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFPubPkgBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFPubPkgBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFPubPkgBase.setPSSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFPubPkgBase.setPSSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFPubPkgBase.setPSSFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFPubPkgBase.setPSSFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFPubPkgBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSFPubPkgBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSFPubPkgBase.setPSSysSFPubPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSFPubPkgBase.setPSSysSFPubPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSFPubPkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysSFPubPkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSFPubPkgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSFPubPkgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSFPubPkgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSFPubPkgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSFPubPkgBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSFPubPkgBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFPubPkgBase pSSysSFPubPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubPkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysSFPubPkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysSFPubPkgBase.getMemo() == null;
            }
            case 3: {
                return pSSysSFPubPkgBase.getOrderValue() == null;
            }
            case 4: {
                return pSSysSFPubPkgBase.getPkgParam() == null;
            }
            case 5: {
                return pSSysSFPubPkgBase.getPkgParam2() == null;
            }
            case 6: {
                return pSSysSFPubPkgBase.getPkgParam3() == null;
            }
            case 7: {
                return pSSysSFPubPkgBase.getPkgParam4() == null;
            }
            case 8: {
                return pSSysSFPubPkgBase.getPSSFPkgId() == null;
            }
            case 9: {
                return pSSysSFPubPkgBase.getPSSFPkgName() == null;
            }
            case 10: {
                return pSSysSFPubPkgBase.getPSSFPkgVerId() == null;
            }
            case 11: {
                return pSSysSFPubPkgBase.getPSSFPkgVerName() == null;
            }
            case 12: {
                return pSSysSFPubPkgBase.getPSSysSFPubId() == null;
            }
            case 13: {
                return pSSysSFPubPkgBase.getPSSysSFPubName() == null;
            }
            case 14: {
                return pSSysSFPubPkgBase.getPSSysSFPubPkgId() == null;
            }
            case 15: {
                return pSSysSFPubPkgBase.getPSSysSFPubPkgName() == null;
            }
            case 16: {
                return pSSysSFPubPkgBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysSFPubPkgBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysSFPubPkgBase.getUserCat() == null;
            }
            case 19: {
                return pSSysSFPubPkgBase.getUserTag() == null;
            }
            case 20: {
                return pSSysSFPubPkgBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysSFPubPkgBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysSFPubPkgBase.getUserTag4() == null;
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
        return PSSysSFPubPkgBase.contains(this, n);
    }

    private static boolean contains(PSSysSFPubPkgBase pSSysSFPubPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubPkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysSFPubPkgBase.isCreateManDirty();
            }
            case 2: {
                return pSSysSFPubPkgBase.isMemoDirty();
            }
            case 3: {
                return pSSysSFPubPkgBase.isOrderValueDirty();
            }
            case 4: {
                return pSSysSFPubPkgBase.isPkgParamDirty();
            }
            case 5: {
                return pSSysSFPubPkgBase.isPkgParam2Dirty();
            }
            case 6: {
                return pSSysSFPubPkgBase.isPkgParam3Dirty();
            }
            case 7: {
                return pSSysSFPubPkgBase.isPkgParam4Dirty();
            }
            case 8: {
                return pSSysSFPubPkgBase.isPSSFPkgIdDirty();
            }
            case 9: {
                return pSSysSFPubPkgBase.isPSSFPkgNameDirty();
            }
            case 10: {
                return pSSysSFPubPkgBase.isPSSFPkgVerIdDirty();
            }
            case 11: {
                return pSSysSFPubPkgBase.isPSSFPkgVerNameDirty();
            }
            case 12: {
                return pSSysSFPubPkgBase.isPSSysSFPubIdDirty();
            }
            case 13: {
                return pSSysSFPubPkgBase.isPSSysSFPubNameDirty();
            }
            case 14: {
                return pSSysSFPubPkgBase.isPSSysSFPubPkgIdDirty();
            }
            case 15: {
                return pSSysSFPubPkgBase.isPSSysSFPubPkgNameDirty();
            }
            case 16: {
                return pSSysSFPubPkgBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysSFPubPkgBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysSFPubPkgBase.isUserCatDirty();
            }
            case 19: {
                return pSSysSFPubPkgBase.isUserTagDirty();
            }
            case 20: {
                return pSSysSFPubPkgBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysSFPubPkgBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysSFPubPkgBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFPubPkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFPubPkgBase pSSysSFPubPkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFPubPkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgid", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSFPkgId()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgname", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSFPkgName()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgverid", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSFPkgVerId()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgvername", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSFPkgVerName()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubpkgid", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSysSFPubPkgId()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubpkgname", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getPSSysSFPubPkgName()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSFPubPkgBase.getJSONValue((Object)pSSysSFPubPkgBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFPubPkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFPubPkgBase pSSysSFPubPkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFPubPkgBase.getCreateDate() != null) {
            object = pSSysSFPubPkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubPkgBase.getCreateMan() != null) {
            object = pSSysSFPubPkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getMemo() != null) {
            object = pSSysSFPubPkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getOrderValue() != null) {
            object = pSSysSFPubPkgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam() != null) {
            object = pSSysSFPubPkgBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam2() != null) {
            object = pSSysSFPubPkgBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam3() != null) {
            object = pSSysSFPubPkgBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPkgParam4() != null) {
            object = pSSysSFPubPkgBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgId() != null) {
            object = pSSysSFPubPkgBase.getPSSFPkgId();
            xmlNode.setAttribute(FIELD_PSSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgName() != null) {
            object = pSSysSFPubPkgBase.getPSSFPkgName();
            xmlNode.setAttribute(FIELD_PSSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgVerId() != null) {
            object = pSSysSFPubPkgBase.getPSSFPkgVerId();
            xmlNode.setAttribute(FIELD_PSSFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSFPkgVerName() != null) {
            object = pSSysSFPubPkgBase.getPSSFPkgVerName();
            xmlNode.setAttribute(FIELD_PSSFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubId() != null) {
            object = pSSysSFPubPkgBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubName() != null) {
            object = pSSysSFPubPkgBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgId() != null) {
            object = pSSysSFPubPkgBase.getPSSysSFPubPkgId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgName() != null) {
            object = pSSysSFPubPkgBase.getPSSysSFPubPkgName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUpdateDate() != null) {
            object = pSSysSFPubPkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubPkgBase.getUpdateMan() != null) {
            object = pSSysSFPubPkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUserCat() != null) {
            object = pSSysSFPubPkgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag() != null) {
            object = pSSysSFPubPkgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag2() != null) {
            object = pSSysSFPubPkgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag3() != null) {
            object = pSSysSFPubPkgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubPkgBase.getUserTag4() != null) {
            object = pSSysSFPubPkgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFPubPkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFPubPkgBase pSSysSFPubPkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFPubPkgBase.isCreateDateDirty() && (bl || pSSysSFPubPkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFPubPkgBase.getCreateDate());
        }
        if (pSSysSFPubPkgBase.isCreateManDirty() && (bl || pSSysSFPubPkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFPubPkgBase.getCreateMan());
        }
        if (pSSysSFPubPkgBase.isMemoDirty() && (bl || pSSysSFPubPkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFPubPkgBase.getMemo());
        }
        if (pSSysSFPubPkgBase.isOrderValueDirty() && (bl || pSSysSFPubPkgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSFPubPkgBase.getOrderValue());
        }
        if (pSSysSFPubPkgBase.isPkgParamDirty() && (bl || pSSysSFPubPkgBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSSysSFPubPkgBase.getPkgParam());
        }
        if (pSSysSFPubPkgBase.isPkgParam2Dirty() && (bl || pSSysSFPubPkgBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSSysSFPubPkgBase.getPkgParam2());
        }
        if (pSSysSFPubPkgBase.isPkgParam3Dirty() && (bl || pSSysSFPubPkgBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSSysSFPubPkgBase.getPkgParam3());
        }
        if (pSSysSFPubPkgBase.isPkgParam4Dirty() && (bl || pSSysSFPubPkgBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSSysSFPubPkgBase.getPkgParam4());
        }
        if (pSSysSFPubPkgBase.isPSSFPkgIdDirty() && (bl || pSSysSFPubPkgBase.getPSSFPkgId() != null)) {
            iDataObject.set(FIELD_PSSFPKGID, (Object)pSSysSFPubPkgBase.getPSSFPkgId());
        }
        if (pSSysSFPubPkgBase.isPSSFPkgNameDirty() && (bl || pSSysSFPubPkgBase.getPSSFPkgName() != null)) {
            iDataObject.set(FIELD_PSSFPKGNAME, (Object)pSSysSFPubPkgBase.getPSSFPkgName());
        }
        if (pSSysSFPubPkgBase.isPSSFPkgVerIdDirty() && (bl || pSSysSFPubPkgBase.getPSSFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERID, (Object)pSSysSFPubPkgBase.getPSSFPkgVerId());
        }
        if (pSSysSFPubPkgBase.isPSSFPkgVerNameDirty() && (bl || pSSysSFPubPkgBase.getPSSFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERNAME, (Object)pSSysSFPubPkgBase.getPSSFPkgVerName());
        }
        if (pSSysSFPubPkgBase.isPSSysSFPubIdDirty() && (bl || pSSysSFPubPkgBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysSFPubPkgBase.getPSSysSFPubId());
        }
        if (pSSysSFPubPkgBase.isPSSysSFPubNameDirty() && (bl || pSSysSFPubPkgBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysSFPubPkgBase.getPSSysSFPubName());
        }
        if (pSSysSFPubPkgBase.isPSSysSFPubPkgIdDirty() && (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBPKGID, (Object)pSSysSFPubPkgBase.getPSSysSFPubPkgId());
        }
        if (pSSysSFPubPkgBase.isPSSysSFPubPkgNameDirty() && (bl || pSSysSFPubPkgBase.getPSSysSFPubPkgName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBPKGNAME, (Object)pSSysSFPubPkgBase.getPSSysSFPubPkgName());
        }
        if (pSSysSFPubPkgBase.isUpdateDateDirty() && (bl || pSSysSFPubPkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFPubPkgBase.getUpdateDate());
        }
        if (pSSysSFPubPkgBase.isUpdateManDirty() && (bl || pSSysSFPubPkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFPubPkgBase.getUpdateMan());
        }
        if (pSSysSFPubPkgBase.isUserCatDirty() && (bl || pSSysSFPubPkgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSFPubPkgBase.getUserCat());
        }
        if (pSSysSFPubPkgBase.isUserTagDirty() && (bl || pSSysSFPubPkgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSFPubPkgBase.getUserTag());
        }
        if (pSSysSFPubPkgBase.isUserTag2Dirty() && (bl || pSSysSFPubPkgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSFPubPkgBase.getUserTag2());
        }
        if (pSSysSFPubPkgBase.isUserTag3Dirty() && (bl || pSSysSFPubPkgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSFPubPkgBase.getUserTag3());
        }
        if (pSSysSFPubPkgBase.isUserTag4Dirty() && (bl || pSSysSFPubPkgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSFPubPkgBase.getUserTag4());
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
        return PSSysSFPubPkgBase.remove(this, n);
    }

    private static boolean remove(PSSysSFPubPkgBase pSSysSFPubPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubPkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysSFPubPkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysSFPubPkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysSFPubPkgBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSSysSFPubPkgBase.resetPkgParam();
                return true;
            }
            case 5: {
                pSSysSFPubPkgBase.resetPkgParam2();
                return true;
            }
            case 6: {
                pSSysSFPubPkgBase.resetPkgParam3();
                return true;
            }
            case 7: {
                pSSysSFPubPkgBase.resetPkgParam4();
                return true;
            }
            case 8: {
                pSSysSFPubPkgBase.resetPSSFPkgId();
                return true;
            }
            case 9: {
                pSSysSFPubPkgBase.resetPSSFPkgName();
                return true;
            }
            case 10: {
                pSSysSFPubPkgBase.resetPSSFPkgVerId();
                return true;
            }
            case 11: {
                pSSysSFPubPkgBase.resetPSSFPkgVerName();
                return true;
            }
            case 12: {
                pSSysSFPubPkgBase.resetPSSysSFPubId();
                return true;
            }
            case 13: {
                pSSysSFPubPkgBase.resetPSSysSFPubName();
                return true;
            }
            case 14: {
                pSSysSFPubPkgBase.resetPSSysSFPubPkgId();
                return true;
            }
            case 15: {
                pSSysSFPubPkgBase.resetPSSysSFPubPkgName();
                return true;
            }
            case 16: {
                pSSysSFPubPkgBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysSFPubPkgBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysSFPubPkgBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysSFPubPkgBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysSFPubPkgBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysSFPubPkgBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysSFPubPkgBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPkgVer getPSSFPkgVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVer();
        }
        if (this.getPSSFPkgVerId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgVerLock;
        synchronized (n) {
            if (this.pssfpkgver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgVerId(), (Object)this.pssfpkgver.getPSSFPkgVerId()) != 0L) {
                this.pssfpkgver = null;
            }
            if (this.pssfpkgver == null) {
                PSSFPkgVer pSSFPkgVer = new PSSFPkgVer();
                pSSFPkgVer.setPSSFPkgVerId(this.getPSSFPkgVerId());
                PSSFPkgVerService pSSFPkgVerService = (PSSFPkgVerService)ServiceGlobal.getService(PSSFPkgVerService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgVerService.autoGet((IEntity)pSSFPkgVer);
                this.pssfpkgver = pSSFPkgVer;
            }
            return this.pssfpkgver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPkg getPSSFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkg();
        }
        if (this.getPSSFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgLock;
        synchronized (n) {
            if (this.pssfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgId(), (Object)this.pssfpkg.getPSSFPkgId()) != 0L) {
                this.pssfpkg = null;
            }
            if (this.pssfpkg == null) {
                PSSFPkg pSSFPkg = new PSSFPkg();
                pSSFPkg.setPSSFPkgId(this.getPSSFPkgId());
                PSSFPkgService pSSFPkgService = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgService.autoGet((IEntity)pSSFPkg);
                this.pssfpkg = pSSFPkg;
            }
            return this.pssfpkg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPub();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPubLock;
        synchronized (n) {
            if (this.pssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPubId(), (Object)this.pssyssfpub.getPSSysSFPubId()) != 0L) {
                this.pssyssfpub = null;
            }
            if (this.pssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet((IEntity)pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
        }
    }

    private PSSysSFPubPkgBase getProxyEntity() {
        return this.proxyPSSysSFPubPkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFPubPkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFPubPkgBase) {
            this.proxyPSSysSFPubPkgBase = (PSSysSFPubPkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubPkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PKGPARAM, 4);
        fieldIndexMap.put(FIELD_PKGPARAM2, 5);
        fieldIndexMap.put(FIELD_PKGPARAM3, 6);
        fieldIndexMap.put(FIELD_PKGPARAM4, 7);
        fieldIndexMap.put(FIELD_PSSFPKGID, 8);
        fieldIndexMap.put(FIELD_PSSFPKGNAME, 9);
        fieldIndexMap.put(FIELD_PSSFPKGVERID, 10);
        fieldIndexMap.put(FIELD_PSSFPKGVERNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 12);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSSFPUBPKGID, 14);
        fieldIndexMap.put(FIELD_PSSYSSFPUBPKGNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

