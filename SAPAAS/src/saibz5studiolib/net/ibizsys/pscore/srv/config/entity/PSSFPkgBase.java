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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgCat;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSFPkgCatService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OSLIC = "OSLIC";
    public static final String FIELD_PKGTAG = "PKGTAG";
    public static final String FIELD_PKGTAG2 = "PKGTAG2";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPKGCATID = "PSSFPKGCATID";
    public static final String FIELD_PSSFPKGCATNAME = "PSSFPKGCATNAME";
    public static final String FIELD_PSSFPKGID = "PSSFPKGID";
    public static final String FIELD_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_OSLIC = 3;
    private static final int INDEX_PKGTAG = 4;
    private static final int INDEX_PKGTAG2 = 5;
    private static final int INDEX_PSDCID = 6;
    private static final int INDEX_PSDCNAME = 7;
    private static final int INDEX_PSSFID = 8;
    private static final int INDEX_PSSFNAME = 9;
    private static final int INDEX_PSSFPKGCATID = 10;
    private static final int INDEX_PSSFPKGCATNAME = 11;
    private static final int INDEX_PSSFPKGID = 12;
    private static final int INDEX_PSSFPKGNAME = 13;
    private static final int INDEX_PSSUBSYSID = 14;
    private static final int INDEX_PSSUBSYSNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPkgBase proxyPSSFPkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean oslicDirtyFlag = false;
    private boolean pkgtagDirtyFlag = false;
    private boolean pkgtag2DirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpkgcatidDirtyFlag = false;
    private boolean pssfpkgcatnameDirtyFlag = false;
    private boolean pssfpkgidDirtyFlag = false;
    private boolean pssfpkgnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="oslic")
    private String oslic;
    @Column(name="pkgtag")
    private String pkgtag;
    @Column(name="pkgtag2")
    private String pkgtag2;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpkgcatid")
    private String pssfpkgcatid;
    @Column(name="pssfpkgcatname")
    private String pssfpkgcatname;
    @Column(name="pssfpkgid")
    private String pssfpkgid;
    @Column(name="pssfpkgname")
    private String pssfpkgname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSSFPkgCatLock = new Integer(1);
    private PSSFPkgCat pssfpkgcat = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

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

    public void setOSLic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSLic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oslic = string;
        this.oslicDirtyFlag = true;
    }

    public String getOSLic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSLic();
        }
        return this.oslic;
    }

    public boolean isOSLicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSLicDirty();
        }
        return this.oslicDirtyFlag;
    }

    public void resetOSLic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSLic();
            return;
        }
        this.oslicDirtyFlag = false;
        this.oslic = null;
    }

    public void setPkgTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgtag = string;
        this.pkgtagDirtyFlag = true;
    }

    public String getPkgTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgTag();
        }
        return this.pkgtag;
    }

    public boolean isPkgTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgTagDirty();
        }
        return this.pkgtagDirtyFlag;
    }

    public void resetPkgTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgTag();
            return;
        }
        this.pkgtagDirtyFlag = false;
        this.pkgtag = null;
    }

    public void setPkgTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgtag2 = string;
        this.pkgtag2DirtyFlag = true;
    }

    public String getPkgTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgTag2();
        }
        return this.pkgtag2;
    }

    public boolean isPkgTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgTag2Dirty();
        }
        return this.pkgtag2DirtyFlag;
    }

    public void resetPkgTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgTag2();
            return;
        }
        this.pkgtag2DirtyFlag = false;
        this.pkgtag2 = null;
    }

    public void setPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcid = string;
        this.psdcidDirtyFlag = true;
    }

    public String getPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCId();
        }
        return this.psdcid;
    }

    public boolean isPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCIdDirty();
        }
        return this.psdcidDirtyFlag;
    }

    public void resetPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCId();
            return;
        }
        this.psdcidDirtyFlag = false;
        this.psdcid = null;
    }

    public void setPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcname = string;
        this.psdcnameDirtyFlag = true;
    }

    public String getPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCName();
        }
        return this.psdcname;
    }

    public boolean isPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNameDirty();
        }
        return this.psdcnameDirtyFlag;
    }

    public void resetPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCName();
            return;
        }
        this.psdcnameDirtyFlag = false;
        this.psdcname = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFPkgCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgcatid = string;
        this.pssfpkgcatidDirtyFlag = true;
    }

    public String getPSSFPkgCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgCatId();
        }
        return this.pssfpkgcatid;
    }

    public boolean isPSSFPkgCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgCatIdDirty();
        }
        return this.pssfpkgcatidDirtyFlag;
    }

    public void resetPSSFPkgCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgCatId();
            return;
        }
        this.pssfpkgcatidDirtyFlag = false;
        this.pssfpkgcatid = null;
    }

    public void setPSSFPkgCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgcatname = string;
        this.pssfpkgcatnameDirtyFlag = true;
    }

    public String getPSSFPkgCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgCatName();
        }
        return this.pssfpkgcatname;
    }

    public boolean isPSSFPkgCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgCatNameDirty();
        }
        return this.pssfpkgcatnameDirtyFlag;
    }

    public void resetPSSFPkgCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgCatName();
            return;
        }
        this.pssfpkgcatnameDirtyFlag = false;
        this.pssfpkgcatname = null;
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

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
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
        PSSFPkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPkgBase pSSFPkgBase) {
        pSSFPkgBase.resetCreateDate();
        pSSFPkgBase.resetCreateMan();
        pSSFPkgBase.resetMemo();
        pSSFPkgBase.resetOSLic();
        pSSFPkgBase.resetPkgTag();
        pSSFPkgBase.resetPkgTag2();
        pSSFPkgBase.resetPSDCId();
        pSSFPkgBase.resetPSDCName();
        pSSFPkgBase.resetPSSFId();
        pSSFPkgBase.resetPSSFName();
        pSSFPkgBase.resetPSSFPkgCatId();
        pSSFPkgBase.resetPSSFPkgCatName();
        pSSFPkgBase.resetPSSFPkgId();
        pSSFPkgBase.resetPSSFPkgName();
        pSSFPkgBase.resetPSSubSysId();
        pSSFPkgBase.resetPSSubSysName();
        pSSFPkgBase.resetUpdateDate();
        pSSFPkgBase.resetUpdateMan();
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
        if (!bl || this.isOSLicDirty()) {
            hashMap.put(FIELD_OSLIC, this.getOSLic());
        }
        if (!bl || this.isPkgTagDirty()) {
            hashMap.put(FIELD_PKGTAG, this.getPkgTag());
        }
        if (!bl || this.isPkgTag2Dirty()) {
            hashMap.put(FIELD_PKGTAG2, this.getPkgTag2());
        }
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPkgCatIdDirty()) {
            hashMap.put(FIELD_PSSFPKGCATID, this.getPSSFPkgCatId());
        }
        if (!bl || this.isPSSFPkgCatNameDirty()) {
            hashMap.put(FIELD_PSSFPKGCATNAME, this.getPSSFPkgCatName());
        }
        if (!bl || this.isPSSFPkgIdDirty()) {
            hashMap.put(FIELD_PSSFPKGID, this.getPSSFPkgId());
        }
        if (!bl || this.isPSSFPkgNameDirty()) {
            hashMap.put(FIELD_PSSFPKGNAME, this.getPSSFPkgName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
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
        return PSSFPkgBase.get(this, n);
    }

    private static Object get(PSSFPkgBase pSSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgBase.getCreateDate();
            }
            case 1: {
                return pSSFPkgBase.getCreateMan();
            }
            case 2: {
                return pSSFPkgBase.getMemo();
            }
            case 3: {
                return pSSFPkgBase.getOSLic();
            }
            case 4: {
                return pSSFPkgBase.getPkgTag();
            }
            case 5: {
                return pSSFPkgBase.getPkgTag2();
            }
            case 6: {
                return pSSFPkgBase.getPSDCId();
            }
            case 7: {
                return pSSFPkgBase.getPSDCName();
            }
            case 8: {
                return pSSFPkgBase.getPSSFId();
            }
            case 9: {
                return pSSFPkgBase.getPSSFName();
            }
            case 10: {
                return pSSFPkgBase.getPSSFPkgCatId();
            }
            case 11: {
                return pSSFPkgBase.getPSSFPkgCatName();
            }
            case 12: {
                return pSSFPkgBase.getPSSFPkgId();
            }
            case 13: {
                return pSSFPkgBase.getPSSFPkgName();
            }
            case 14: {
                return pSSFPkgBase.getPSSubSysId();
            }
            case 15: {
                return pSSFPkgBase.getPSSubSysName();
            }
            case 16: {
                return pSSFPkgBase.getUpdateDate();
            }
            case 17: {
                return pSSFPkgBase.getUpdateMan();
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
        PSSFPkgBase.set(this, n, object);
    }

    private static void set(PSSFPkgBase pSSFPkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPkgBase.setOSLic(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPkgBase.setPkgTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPkgBase.setPkgTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPkgBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPkgBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPkgBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPkgBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPkgBase.setPSSFPkgCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFPkgBase.setPSSFPkgCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPkgBase.setPSSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFPkgBase.setPSSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFPkgBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFPkgBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFPkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSFPkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFPkgBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPkgBase pSSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPkgBase.getMemo() == null;
            }
            case 3: {
                return pSSFPkgBase.getOSLic() == null;
            }
            case 4: {
                return pSSFPkgBase.getPkgTag() == null;
            }
            case 5: {
                return pSSFPkgBase.getPkgTag2() == null;
            }
            case 6: {
                return pSSFPkgBase.getPSDCId() == null;
            }
            case 7: {
                return pSSFPkgBase.getPSDCName() == null;
            }
            case 8: {
                return pSSFPkgBase.getPSSFId() == null;
            }
            case 9: {
                return pSSFPkgBase.getPSSFName() == null;
            }
            case 10: {
                return pSSFPkgBase.getPSSFPkgCatId() == null;
            }
            case 11: {
                return pSSFPkgBase.getPSSFPkgCatName() == null;
            }
            case 12: {
                return pSSFPkgBase.getPSSFPkgId() == null;
            }
            case 13: {
                return pSSFPkgBase.getPSSFPkgName() == null;
            }
            case 14: {
                return pSSFPkgBase.getPSSubSysId() == null;
            }
            case 15: {
                return pSSFPkgBase.getPSSubSysName() == null;
            }
            case 16: {
                return pSSFPkgBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSFPkgBase.getUpdateMan() == null;
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
        return PSSFPkgBase.contains(this, n);
    }

    private static boolean contains(PSSFPkgBase pSSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPkgBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPkgBase.isMemoDirty();
            }
            case 3: {
                return pSSFPkgBase.isOSLicDirty();
            }
            case 4: {
                return pSSFPkgBase.isPkgTagDirty();
            }
            case 5: {
                return pSSFPkgBase.isPkgTag2Dirty();
            }
            case 6: {
                return pSSFPkgBase.isPSDCIdDirty();
            }
            case 7: {
                return pSSFPkgBase.isPSDCNameDirty();
            }
            case 8: {
                return pSSFPkgBase.isPSSFIdDirty();
            }
            case 9: {
                return pSSFPkgBase.isPSSFNameDirty();
            }
            case 10: {
                return pSSFPkgBase.isPSSFPkgCatIdDirty();
            }
            case 11: {
                return pSSFPkgBase.isPSSFPkgCatNameDirty();
            }
            case 12: {
                return pSSFPkgBase.isPSSFPkgIdDirty();
            }
            case 13: {
                return pSSFPkgBase.isPSSFPkgNameDirty();
            }
            case 14: {
                return pSSFPkgBase.isPSSubSysIdDirty();
            }
            case 15: {
                return pSSFPkgBase.isPSSubSysNameDirty();
            }
            case 16: {
                return pSSFPkgBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSFPkgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPkgBase pSSFPkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getOSLic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oslic", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getOSLic()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPkgTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgtag", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPkgTag()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPkgTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgtag2", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPkgTag2()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFPkgCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgcatid", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFPkgCatId()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFPkgCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgcatname", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFPkgCatName()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgid", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFPkgId()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgname", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSFPkgName()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPkgBase.getJSONValue((Object)pSSFPkgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPkgBase pSSFPkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPkgBase.getCreateDate() != null) {
            object = pSSFPkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgBase.getCreateMan() != null) {
            object = pSSFPkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getMemo() != null) {
            object = pSSFPkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getOSLic() != null) {
            object = pSSFPkgBase.getOSLic();
            xmlNode.setAttribute(FIELD_OSLIC, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPkgTag() != null) {
            object = pSSFPkgBase.getPkgTag();
            xmlNode.setAttribute(FIELD_PKGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPkgTag2() != null) {
            object = pSSFPkgBase.getPkgTag2();
            xmlNode.setAttribute(FIELD_PKGTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSDCId() != null) {
            object = pSSFPkgBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSDCName() != null) {
            object = pSSFPkgBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFId() != null) {
            object = pSSFPkgBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFName() != null) {
            object = pSSFPkgBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFPkgCatId() != null) {
            object = pSSFPkgBase.getPSSFPkgCatId();
            xmlNode.setAttribute(FIELD_PSSFPKGCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFPkgCatName() != null) {
            object = pSSFPkgBase.getPSSFPkgCatName();
            xmlNode.setAttribute(FIELD_PSSFPKGCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFPkgId() != null) {
            object = pSSFPkgBase.getPSSFPkgId();
            xmlNode.setAttribute(FIELD_PSSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSFPkgName() != null) {
            object = pSSFPkgBase.getPSSFPkgName();
            xmlNode.setAttribute(FIELD_PSSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSubSysId() != null) {
            object = pSSFPkgBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getPSSubSysName() != null) {
            object = pSSFPkgBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgBase.getUpdateDate() != null) {
            object = pSSFPkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgBase.getUpdateMan() != null) {
            object = pSSFPkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPkgBase pSSFPkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPkgBase.isCreateDateDirty() && (bl || pSSFPkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPkgBase.getCreateDate());
        }
        if (pSSFPkgBase.isCreateManDirty() && (bl || pSSFPkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPkgBase.getCreateMan());
        }
        if (pSSFPkgBase.isMemoDirty() && (bl || pSSFPkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPkgBase.getMemo());
        }
        if (pSSFPkgBase.isOSLicDirty() && (bl || pSSFPkgBase.getOSLic() != null)) {
            iDataObject.set(FIELD_OSLIC, (Object)pSSFPkgBase.getOSLic());
        }
        if (pSSFPkgBase.isPkgTagDirty() && (bl || pSSFPkgBase.getPkgTag() != null)) {
            iDataObject.set(FIELD_PKGTAG, (Object)pSSFPkgBase.getPkgTag());
        }
        if (pSSFPkgBase.isPkgTag2Dirty() && (bl || pSSFPkgBase.getPkgTag2() != null)) {
            iDataObject.set(FIELD_PKGTAG2, (Object)pSSFPkgBase.getPkgTag2());
        }
        if (pSSFPkgBase.isPSDCIdDirty() && (bl || pSSFPkgBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSSFPkgBase.getPSDCId());
        }
        if (pSSFPkgBase.isPSDCNameDirty() && (bl || pSSFPkgBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSSFPkgBase.getPSDCName());
        }
        if (pSSFPkgBase.isPSSFIdDirty() && (bl || pSSFPkgBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPkgBase.getPSSFId());
        }
        if (pSSFPkgBase.isPSSFNameDirty() && (bl || pSSFPkgBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFPkgBase.getPSSFName());
        }
        if (pSSFPkgBase.isPSSFPkgCatIdDirty() && (bl || pSSFPkgBase.getPSSFPkgCatId() != null)) {
            iDataObject.set(FIELD_PSSFPKGCATID, (Object)pSSFPkgBase.getPSSFPkgCatId());
        }
        if (pSSFPkgBase.isPSSFPkgCatNameDirty() && (bl || pSSFPkgBase.getPSSFPkgCatName() != null)) {
            iDataObject.set(FIELD_PSSFPKGCATNAME, (Object)pSSFPkgBase.getPSSFPkgCatName());
        }
        if (pSSFPkgBase.isPSSFPkgIdDirty() && (bl || pSSFPkgBase.getPSSFPkgId() != null)) {
            iDataObject.set(FIELD_PSSFPKGID, (Object)pSSFPkgBase.getPSSFPkgId());
        }
        if (pSSFPkgBase.isPSSFPkgNameDirty() && (bl || pSSFPkgBase.getPSSFPkgName() != null)) {
            iDataObject.set(FIELD_PSSFPKGNAME, (Object)pSSFPkgBase.getPSSFPkgName());
        }
        if (pSSFPkgBase.isPSSubSysIdDirty() && (bl || pSSFPkgBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSFPkgBase.getPSSubSysId());
        }
        if (pSSFPkgBase.isPSSubSysNameDirty() && (bl || pSSFPkgBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSFPkgBase.getPSSubSysName());
        }
        if (pSSFPkgBase.isUpdateDateDirty() && (bl || pSSFPkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPkgBase.getUpdateDate());
        }
        if (pSSFPkgBase.isUpdateManDirty() && (bl || pSSFPkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPkgBase.getUpdateMan());
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
        return PSSFPkgBase.remove(this, n);
    }

    private static boolean remove(PSSFPkgBase pSSFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFPkgBase.resetOSLic();
                return true;
            }
            case 4: {
                pSSFPkgBase.resetPkgTag();
                return true;
            }
            case 5: {
                pSSFPkgBase.resetPkgTag2();
                return true;
            }
            case 6: {
                pSSFPkgBase.resetPSDCId();
                return true;
            }
            case 7: {
                pSSFPkgBase.resetPSDCName();
                return true;
            }
            case 8: {
                pSSFPkgBase.resetPSSFId();
                return true;
            }
            case 9: {
                pSSFPkgBase.resetPSSFName();
                return true;
            }
            case 10: {
                pSSFPkgBase.resetPSSFPkgCatId();
                return true;
            }
            case 11: {
                pSSFPkgBase.resetPSSFPkgCatName();
                return true;
            }
            case 12: {
                pSSFPkgBase.resetPSSFPkgId();
                return true;
            }
            case 13: {
                pSSFPkgBase.resetPSSFPkgName();
                return true;
            }
            case 14: {
                pSSFPkgBase.resetPSSubSysId();
                return true;
            }
            case 15: {
                pSSFPkgBase.resetPSSubSysName();
                return true;
            }
            case 16: {
                pSSFPkgBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSFPkgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDC();
        }
        if (this.getPSDCId() == null) {
            return null;
        }
        Integer n = this.objPSDCLock;
        synchronized (n) {
            if (this.psdc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCId(), (Object)this.psdc.getPSDevCenterId()) != 0L) {
                this.psdc = null;
            }
            if (this.psdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPkgCat getPSSFPkgCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgCat();
        }
        if (this.getPSSFPkgCatId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgCatLock;
        synchronized (n) {
            if (this.pssfpkgcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgCatId(), (Object)this.pssfpkgcat.getPSSFPkgCatId()) != 0L) {
                this.pssfpkgcat = null;
            }
            if (this.pssfpkgcat == null) {
                PSSFPkgCat pSSFPkgCat = new PSSFPkgCat();
                pSSFPkgCat.setPSSFPkgCatId(this.getPSSFPkgCatId());
                PSSFPkgCatService pSSFPkgCatService = (PSSFPkgCatService)ServiceGlobal.getService(PSSFPkgCatService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgCatService.autoGet((IEntity)pSSFPkgCat);
                this.pssfpkgcat = pSSFPkgCat;
            }
            return this.pssfpkgcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet((IEntity)pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSFPkgBase getProxyEntity() {
        return this.proxyPSSFPkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPkgBase) {
            this.proxyPSSFPkgBase = (PSSFPkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_OSLIC, 3);
        fieldIndexMap.put(FIELD_PKGTAG, 4);
        fieldIndexMap.put(FIELD_PKGTAG2, 5);
        fieldIndexMap.put(FIELD_PSDCID, 6);
        fieldIndexMap.put(FIELD_PSDCNAME, 7);
        fieldIndexMap.put(FIELD_PSSFID, 8);
        fieldIndexMap.put(FIELD_PSSFNAME, 9);
        fieldIndexMap.put(FIELD_PSSFPKGCATID, 10);
        fieldIndexMap.put(FIELD_PSSFPKGCATNAME, 11);
        fieldIndexMap.put(FIELD_PSSFPKGID, 12);
        fieldIndexMap.put(FIELD_PSSFPKGNAME, 13);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 14);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

