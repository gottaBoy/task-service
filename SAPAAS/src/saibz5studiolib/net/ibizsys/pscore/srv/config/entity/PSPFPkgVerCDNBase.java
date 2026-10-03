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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFCDN;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.service.PSPFCDNService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgVerCDNBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPkgVerCDNBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPFCDNID = "PSPFCDNID";
    public static final String FIELD_PSPFCDNNAME = "PSPFCDNNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPKGID = "PSPFPKGID";
    public static final String FIELD_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String FIELD_PSPFPKGVERCDNID = "PSPFPKGVERCDNID";
    public static final String FIELD_PSPFPKGVERCDNNAME = "PSPFPKGVERCDNNAME";
    public static final String FIELD_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String FIELD_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PKGPARAM = 3;
    private static final int INDEX_PKGPARAM2 = 4;
    private static final int INDEX_PKGPARAM3 = 5;
    private static final int INDEX_PKGPARAM4 = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_PSPFCDNID = 9;
    private static final int INDEX_PSPFCDNNAME = 10;
    private static final int INDEX_PSPFID = 11;
    private static final int INDEX_PSPFNAME = 12;
    private static final int INDEX_PSPFPKGID = 13;
    private static final int INDEX_PSPFPKGNAME = 14;
    private static final int INDEX_PSPFPKGVERCDNID = 15;
    private static final int INDEX_PSPFPKGVERCDNNAME = 16;
    private static final int INDEX_PSPFPKGVERID = 17;
    private static final int INDEX_PSPFPKGVERNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPkgVerCDNBase proxyPSPFPkgVerCDNBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspfcdnidDirtyFlag = false;
    private boolean pspfcdnnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpkgidDirtyFlag = false;
    private boolean pspfpkgnameDirtyFlag = false;
    private boolean pspfpkgvercdnidDirtyFlag = false;
    private boolean pspfpkgvercdnnameDirtyFlag = false;
    private boolean pspfpkgveridDirtyFlag = false;
    private boolean pspfpkgvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgparam")
    private String pkgparam;
    @Column(name="pkgparam2")
    private String pkgparam2;
    @Column(name="pkgparam3")
    private String pkgparam3;
    @Column(name="pkgparam4")
    private String pkgparam4;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspfcdnid")
    private String pspfcdnid;
    @Column(name="pspfcdnname")
    private String pspfcdnname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpkgid")
    private String pspfpkgid;
    @Column(name="pspfpkgname")
    private String pspfpkgname;
    @Column(name="pspfpkgvercdnid")
    private String pspfpkgvercdnid;
    @Column(name="pspfpkgvercdnname")
    private String pspfpkgvercdnname;
    @Column(name="pspfpkgverid")
    private String pspfpkgverid;
    @Column(name="pspfpkgvername")
    private String pspfpkgvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSPFCDNLock = new Integer(1);
    private PSPFCDN pspfcdn = null;
    private Integer objPSPFPkgVerLock = new Integer(1);
    private PSPFPkgVer pspfpkgver = null;
    private Integer objPSPFPkgLock = new Integer(1);
    private PSPFPkg pspfpkg = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setPSPFCDNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnid = string;
        this.pspfcdnidDirtyFlag = true;
    }

    public String getPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNId();
        }
        return this.pspfcdnid;
    }

    public boolean isPSPFCDNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNIdDirty();
        }
        return this.pspfcdnidDirtyFlag;
    }

    public void resetPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNId();
            return;
        }
        this.pspfcdnidDirtyFlag = false;
        this.pspfcdnid = null;
    }

    public void setPSPFCDNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnname = string;
        this.pspfcdnnameDirtyFlag = true;
    }

    public String getPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNName();
        }
        return this.pspfcdnname;
    }

    public boolean isPSPFCDNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNNameDirty();
        }
        return this.pspfcdnnameDirtyFlag;
    }

    public void resetPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNName();
            return;
        }
        this.pspfcdnnameDirtyFlag = false;
        this.pspfcdnname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
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

    public void setPSPFPkgVerCDNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerCDNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgvercdnid = string;
        this.pspfpkgvercdnidDirtyFlag = true;
    }

    public String getPSPFPkgVerCDNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerCDNId();
        }
        return this.pspfpkgvercdnid;
    }

    public boolean isPSPFPkgVerCDNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerCDNIdDirty();
        }
        return this.pspfpkgvercdnidDirtyFlag;
    }

    public void resetPSPFPkgVerCDNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerCDNId();
            return;
        }
        this.pspfpkgvercdnidDirtyFlag = false;
        this.pspfpkgvercdnid = null;
    }

    public void setPSPFPkgVerCDNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerCDNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgvercdnname = string;
        this.pspfpkgvercdnnameDirtyFlag = true;
    }

    public String getPSPFPkgVerCDNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerCDNName();
        }
        return this.pspfpkgvercdnname;
    }

    public boolean isPSPFPkgVerCDNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerCDNNameDirty();
        }
        return this.pspfpkgvercdnnameDirtyFlag;
    }

    public void resetPSPFPkgVerCDNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerCDNName();
            return;
        }
        this.pspfpkgvercdnnameDirtyFlag = false;
        this.pspfpkgvercdnname = null;
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
        PSPFPkgVerCDNBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPkgVerCDNBase pSPFPkgVerCDNBase) {
        pSPFPkgVerCDNBase.resetCreateDate();
        pSPFPkgVerCDNBase.resetCreateMan();
        pSPFPkgVerCDNBase.resetMemo();
        pSPFPkgVerCDNBase.resetPkgParam();
        pSPFPkgVerCDNBase.resetPkgParam2();
        pSPFPkgVerCDNBase.resetPkgParam3();
        pSPFPkgVerCDNBase.resetPkgParam4();
        pSPFPkgVerCDNBase.resetPSDevCenterId();
        pSPFPkgVerCDNBase.resetPSDevCenterName();
        pSPFPkgVerCDNBase.resetPSPFCDNId();
        pSPFPkgVerCDNBase.resetPSPFCDNName();
        pSPFPkgVerCDNBase.resetPSPFId();
        pSPFPkgVerCDNBase.resetPSPFName();
        pSPFPkgVerCDNBase.resetPSPFPkgId();
        pSPFPkgVerCDNBase.resetPSPFPkgName();
        pSPFPkgVerCDNBase.resetPSPFPkgVerCDNId();
        pSPFPkgVerCDNBase.resetPSPFPkgVerCDNName();
        pSPFPkgVerCDNBase.resetPSPFPkgVerId();
        pSPFPkgVerCDNBase.resetPSPFPkgVerName();
        pSPFPkgVerCDNBase.resetUpdateDate();
        pSPFPkgVerCDNBase.resetUpdateMan();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSPFCDNIdDirty()) {
            hashMap.put(FIELD_PSPFCDNID, this.getPSPFCDNId());
        }
        if (!bl || this.isPSPFCDNNameDirty()) {
            hashMap.put(FIELD_PSPFCDNNAME, this.getPSPFCDNName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPkgIdDirty()) {
            hashMap.put(FIELD_PSPFPKGID, this.getPSPFPkgId());
        }
        if (!bl || this.isPSPFPkgNameDirty()) {
            hashMap.put(FIELD_PSPFPKGNAME, this.getPSPFPkgName());
        }
        if (!bl || this.isPSPFPkgVerCDNIdDirty()) {
            hashMap.put(FIELD_PSPFPKGVERCDNID, this.getPSPFPkgVerCDNId());
        }
        if (!bl || this.isPSPFPkgVerCDNNameDirty()) {
            hashMap.put(FIELD_PSPFPKGVERCDNNAME, this.getPSPFPkgVerCDNName());
        }
        if (!bl || this.isPSPFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSPFPKGVERID, this.getPSPFPkgVerId());
        }
        if (!bl || this.isPSPFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSPFPKGVERNAME, this.getPSPFPkgVerName());
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
        return PSPFPkgVerCDNBase.get(this, n);
    }

    private static Object get(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerCDNBase.getCreateDate();
            }
            case 1: {
                return pSPFPkgVerCDNBase.getCreateMan();
            }
            case 2: {
                return pSPFPkgVerCDNBase.getMemo();
            }
            case 3: {
                return pSPFPkgVerCDNBase.getPkgParam();
            }
            case 4: {
                return pSPFPkgVerCDNBase.getPkgParam2();
            }
            case 5: {
                return pSPFPkgVerCDNBase.getPkgParam3();
            }
            case 6: {
                return pSPFPkgVerCDNBase.getPkgParam4();
            }
            case 7: {
                return pSPFPkgVerCDNBase.getPSDevCenterId();
            }
            case 8: {
                return pSPFPkgVerCDNBase.getPSDevCenterName();
            }
            case 9: {
                return pSPFPkgVerCDNBase.getPSPFCDNId();
            }
            case 10: {
                return pSPFPkgVerCDNBase.getPSPFCDNName();
            }
            case 11: {
                return pSPFPkgVerCDNBase.getPSPFId();
            }
            case 12: {
                return pSPFPkgVerCDNBase.getPSPFName();
            }
            case 13: {
                return pSPFPkgVerCDNBase.getPSPFPkgId();
            }
            case 14: {
                return pSPFPkgVerCDNBase.getPSPFPkgName();
            }
            case 15: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerCDNId();
            }
            case 16: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerCDNName();
            }
            case 17: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerId();
            }
            case 18: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerName();
            }
            case 19: {
                return pSPFPkgVerCDNBase.getUpdateDate();
            }
            case 20: {
                return pSPFPkgVerCDNBase.getUpdateMan();
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
        PSPFPkgVerCDNBase.set(this, n, object);
    }

    private static void set(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgVerCDNBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPkgVerCDNBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPkgVerCDNBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPkgVerCDNBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPkgVerCDNBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPkgVerCDNBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPkgVerCDNBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPkgVerCDNBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPkgVerCDNBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPkgVerCDNBase.setPSPFCDNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPkgVerCDNBase.setPSPFCDNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPkgVerCDNBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPkgVerCDNBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPkgVerCDNBase.setPSPFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPkgVerCDNBase.setPSPFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPkgVerCDNBase.setPSPFPkgVerCDNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPkgVerCDNBase.setPSPFPkgVerCDNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPkgVerCDNBase.setPSPFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFPkgVerCDNBase.setPSPFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFPkgVerCDNBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSPFPkgVerCDNBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPkgVerCDNBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerCDNBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPkgVerCDNBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPkgVerCDNBase.getMemo() == null;
            }
            case 3: {
                return pSPFPkgVerCDNBase.getPkgParam() == null;
            }
            case 4: {
                return pSPFPkgVerCDNBase.getPkgParam2() == null;
            }
            case 5: {
                return pSPFPkgVerCDNBase.getPkgParam3() == null;
            }
            case 6: {
                return pSPFPkgVerCDNBase.getPkgParam4() == null;
            }
            case 7: {
                return pSPFPkgVerCDNBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSPFPkgVerCDNBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSPFPkgVerCDNBase.getPSPFCDNId() == null;
            }
            case 10: {
                return pSPFPkgVerCDNBase.getPSPFCDNName() == null;
            }
            case 11: {
                return pSPFPkgVerCDNBase.getPSPFId() == null;
            }
            case 12: {
                return pSPFPkgVerCDNBase.getPSPFName() == null;
            }
            case 13: {
                return pSPFPkgVerCDNBase.getPSPFPkgId() == null;
            }
            case 14: {
                return pSPFPkgVerCDNBase.getPSPFPkgName() == null;
            }
            case 15: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerCDNId() == null;
            }
            case 16: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerCDNName() == null;
            }
            case 17: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerId() == null;
            }
            case 18: {
                return pSPFPkgVerCDNBase.getPSPFPkgVerName() == null;
            }
            case 19: {
                return pSPFPkgVerCDNBase.getUpdateDate() == null;
            }
            case 20: {
                return pSPFPkgVerCDNBase.getUpdateMan() == null;
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
        return PSPFPkgVerCDNBase.contains(this, n);
    }

    private static boolean contains(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerCDNBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPkgVerCDNBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPkgVerCDNBase.isMemoDirty();
            }
            case 3: {
                return pSPFPkgVerCDNBase.isPkgParamDirty();
            }
            case 4: {
                return pSPFPkgVerCDNBase.isPkgParam2Dirty();
            }
            case 5: {
                return pSPFPkgVerCDNBase.isPkgParam3Dirty();
            }
            case 6: {
                return pSPFPkgVerCDNBase.isPkgParam4Dirty();
            }
            case 7: {
                return pSPFPkgVerCDNBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSPFPkgVerCDNBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSPFPkgVerCDNBase.isPSPFCDNIdDirty();
            }
            case 10: {
                return pSPFPkgVerCDNBase.isPSPFCDNNameDirty();
            }
            case 11: {
                return pSPFPkgVerCDNBase.isPSPFIdDirty();
            }
            case 12: {
                return pSPFPkgVerCDNBase.isPSPFNameDirty();
            }
            case 13: {
                return pSPFPkgVerCDNBase.isPSPFPkgIdDirty();
            }
            case 14: {
                return pSPFPkgVerCDNBase.isPSPFPkgNameDirty();
            }
            case 15: {
                return pSPFPkgVerCDNBase.isPSPFPkgVerCDNIdDirty();
            }
            case 16: {
                return pSPFPkgVerCDNBase.isPSPFPkgVerCDNNameDirty();
            }
            case 17: {
                return pSPFPkgVerCDNBase.isPSPFPkgVerIdDirty();
            }
            case 18: {
                return pSPFPkgVerCDNBase.isPSPFPkgVerNameDirty();
            }
            case 19: {
                return pSPFPkgVerCDNBase.isUpdateDateDirty();
            }
            case 20: {
                return pSPFPkgVerCDNBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPkgVerCDNBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPkgVerCDNBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFCDNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFCDNId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFCDNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnname", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFCDNName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgname", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvercdnid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgVerCDNId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvercdnname", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgVerCDNName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgverid", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgVerId()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvername", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getPSPFPkgVerName()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPkgVerCDNBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPkgVerCDNBase.getJSONValue((Object)pSPFPkgVerCDNBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPkgVerCDNBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPkgVerCDNBase.getCreateDate() != null) {
            object = pSPFPkgVerCDNBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgVerCDNBase.getCreateMan() != null) {
            object = pSPFPkgVerCDNBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getMemo() != null) {
            object = pSPFPkgVerCDNBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam() != null) {
            object = pSPFPkgVerCDNBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam2() != null) {
            object = pSPFPkgVerCDNBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam3() != null) {
            object = pSPFPkgVerCDNBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPkgParam4() != null) {
            object = pSPFPkgVerCDNBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSDevCenterId() != null) {
            object = pSPFPkgVerCDNBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSDevCenterName() != null) {
            object = pSPFPkgVerCDNBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFCDNId() != null) {
            object = pSPFPkgVerCDNBase.getPSPFCDNId();
            xmlNode.setAttribute(FIELD_PSPFCDNID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFCDNName() != null) {
            object = pSPFPkgVerCDNBase.getPSPFCDNName();
            xmlNode.setAttribute(FIELD_PSPFCDNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFId() != null) {
            object = pSPFPkgVerCDNBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFName() != null) {
            object = pSPFPkgVerCDNBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgId() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgId();
            xmlNode.setAttribute(FIELD_PSPFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgName() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgName();
            xmlNode.setAttribute(FIELD_PSPFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNId() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgVerCDNId();
            xmlNode.setAttribute(FIELD_PSPFPKGVERCDNID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNName() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgVerCDNName();
            xmlNode.setAttribute(FIELD_PSPFPKGVERCDNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerId() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgVerId();
            xmlNode.setAttribute(FIELD_PSPFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getPSPFPkgVerName() != null) {
            object = pSPFPkgVerCDNBase.getPSPFPkgVerName();
            xmlNode.setAttribute(FIELD_PSPFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerCDNBase.getUpdateDate() != null) {
            object = pSPFPkgVerCDNBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgVerCDNBase.getUpdateMan() != null) {
            object = pSPFPkgVerCDNBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPkgVerCDNBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPkgVerCDNBase.isCreateDateDirty() && (bl || pSPFPkgVerCDNBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPkgVerCDNBase.getCreateDate());
        }
        if (pSPFPkgVerCDNBase.isCreateManDirty() && (bl || pSPFPkgVerCDNBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPkgVerCDNBase.getCreateMan());
        }
        if (pSPFPkgVerCDNBase.isMemoDirty() && (bl || pSPFPkgVerCDNBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPkgVerCDNBase.getMemo());
        }
        if (pSPFPkgVerCDNBase.isPkgParamDirty() && (bl || pSPFPkgVerCDNBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSPFPkgVerCDNBase.getPkgParam());
        }
        if (pSPFPkgVerCDNBase.isPkgParam2Dirty() && (bl || pSPFPkgVerCDNBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSPFPkgVerCDNBase.getPkgParam2());
        }
        if (pSPFPkgVerCDNBase.isPkgParam3Dirty() && (bl || pSPFPkgVerCDNBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSPFPkgVerCDNBase.getPkgParam3());
        }
        if (pSPFPkgVerCDNBase.isPkgParam4Dirty() && (bl || pSPFPkgVerCDNBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSPFPkgVerCDNBase.getPkgParam4());
        }
        if (pSPFPkgVerCDNBase.isPSDevCenterIdDirty() && (bl || pSPFPkgVerCDNBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSPFPkgVerCDNBase.getPSDevCenterId());
        }
        if (pSPFPkgVerCDNBase.isPSDevCenterNameDirty() && (bl || pSPFPkgVerCDNBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSPFPkgVerCDNBase.getPSDevCenterName());
        }
        if (pSPFPkgVerCDNBase.isPSPFCDNIdDirty() && (bl || pSPFPkgVerCDNBase.getPSPFCDNId() != null)) {
            iDataObject.set(FIELD_PSPFCDNID, (Object)pSPFPkgVerCDNBase.getPSPFCDNId());
        }
        if (pSPFPkgVerCDNBase.isPSPFCDNNameDirty() && (bl || pSPFPkgVerCDNBase.getPSPFCDNName() != null)) {
            iDataObject.set(FIELD_PSPFCDNNAME, (Object)pSPFPkgVerCDNBase.getPSPFCDNName());
        }
        if (pSPFPkgVerCDNBase.isPSPFIdDirty() && (bl || pSPFPkgVerCDNBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPkgVerCDNBase.getPSPFId());
        }
        if (pSPFPkgVerCDNBase.isPSPFNameDirty() && (bl || pSPFPkgVerCDNBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPkgVerCDNBase.getPSPFName());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgIdDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgId() != null)) {
            iDataObject.set(FIELD_PSPFPKGID, (Object)pSPFPkgVerCDNBase.getPSPFPkgId());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgNameDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgName() != null)) {
            iDataObject.set(FIELD_PSPFPKGNAME, (Object)pSPFPkgVerCDNBase.getPSPFPkgName());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgVerCDNIdDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNId() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERCDNID, (Object)pSPFPkgVerCDNBase.getPSPFPkgVerCDNId());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgVerCDNNameDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgVerCDNName() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERCDNNAME, (Object)pSPFPkgVerCDNBase.getPSPFPkgVerCDNName());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgVerIdDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERID, (Object)pSPFPkgVerCDNBase.getPSPFPkgVerId());
        }
        if (pSPFPkgVerCDNBase.isPSPFPkgVerNameDirty() && (bl || pSPFPkgVerCDNBase.getPSPFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERNAME, (Object)pSPFPkgVerCDNBase.getPSPFPkgVerName());
        }
        if (pSPFPkgVerCDNBase.isUpdateDateDirty() && (bl || pSPFPkgVerCDNBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPkgVerCDNBase.getUpdateDate());
        }
        if (pSPFPkgVerCDNBase.isUpdateManDirty() && (bl || pSPFPkgVerCDNBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPkgVerCDNBase.getUpdateMan());
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
        return PSPFPkgVerCDNBase.remove(this, n);
    }

    private static boolean remove(PSPFPkgVerCDNBase pSPFPkgVerCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgVerCDNBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPkgVerCDNBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPkgVerCDNBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFPkgVerCDNBase.resetPkgParam();
                return true;
            }
            case 4: {
                pSPFPkgVerCDNBase.resetPkgParam2();
                return true;
            }
            case 5: {
                pSPFPkgVerCDNBase.resetPkgParam3();
                return true;
            }
            case 6: {
                pSPFPkgVerCDNBase.resetPkgParam4();
                return true;
            }
            case 7: {
                pSPFPkgVerCDNBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSPFPkgVerCDNBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSPFPkgVerCDNBase.resetPSPFCDNId();
                return true;
            }
            case 10: {
                pSPFPkgVerCDNBase.resetPSPFCDNName();
                return true;
            }
            case 11: {
                pSPFPkgVerCDNBase.resetPSPFId();
                return true;
            }
            case 12: {
                pSPFPkgVerCDNBase.resetPSPFName();
                return true;
            }
            case 13: {
                pSPFPkgVerCDNBase.resetPSPFPkgId();
                return true;
            }
            case 14: {
                pSPFPkgVerCDNBase.resetPSPFPkgName();
                return true;
            }
            case 15: {
                pSPFPkgVerCDNBase.resetPSPFPkgVerCDNId();
                return true;
            }
            case 16: {
                pSPFPkgVerCDNBase.resetPSPFPkgVerCDNName();
                return true;
            }
            case 17: {
                pSPFPkgVerCDNBase.resetPSPFPkgVerId();
                return true;
            }
            case 18: {
                pSPFPkgVerCDNBase.resetPSPFPkgVerName();
                return true;
            }
            case 19: {
                pSPFPkgVerCDNBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSPFPkgVerCDNBase.resetUpdateMan();
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
    public PSPFCDN getPSPFCDN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDN();
        }
        if (this.getPSPFCDNId() == null) {
            return null;
        }
        Integer n = this.objPSPFCDNLock;
        synchronized (n) {
            if (this.pspfcdn != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFCDNId(), (Object)this.pspfcdn.getPSPFCDNId()) != 0L) {
                this.pspfcdn = null;
            }
            if (this.pspfcdn == null) {
                PSPFCDN pSPFCDN = new PSPFCDN();
                pSPFCDN.setPSPFCDNId(this.getPSPFCDNId());
                PSPFCDNService pSPFCDNService = (PSPFCDNService)ServiceGlobal.getService(PSPFCDNService.class, (SessionFactory)this.getSessionFactory());
                pSPFCDNService.autoGet(pSPFCDN);
                this.pspfcdn = pSPFCDN;
            }
            return this.pspfcdn;
        }
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
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFPkgVerCDNBase getProxyEntity() {
        return this.proxyPSPFPkgVerCDNBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPkgVerCDNBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPkgVerCDNBase) {
            this.proxyPSPFPkgVerCDNBase = (PSPFPkgVerCDNBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PKGPARAM, 3);
        fieldIndexMap.put(FIELD_PKGPARAM2, 4);
        fieldIndexMap.put(FIELD_PKGPARAM3, 5);
        fieldIndexMap.put(FIELD_PKGPARAM4, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_PSPFCDNID, 9);
        fieldIndexMap.put(FIELD_PSPFCDNNAME, 10);
        fieldIndexMap.put(FIELD_PSPFID, 11);
        fieldIndexMap.put(FIELD_PSPFNAME, 12);
        fieldIndexMap.put(FIELD_PSPFPKGID, 13);
        fieldIndexMap.put(FIELD_PSPFPKGNAME, 14);
        fieldIndexMap.put(FIELD_PSPFPKGVERCDNID, 15);
        fieldIndexMap.put(FIELD_PSPFPKGVERCDNNAME, 16);
        fieldIndexMap.put(FIELD_PSPFPKGVERID, 17);
        fieldIndexMap.put(FIELD_PSPFPKGVERNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

