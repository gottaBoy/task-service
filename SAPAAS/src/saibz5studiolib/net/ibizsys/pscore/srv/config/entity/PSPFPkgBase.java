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
import net.ibizsys.pscore.srv.config.entity.PSPFPkgCat;
import net.ibizsys.pscore.srv.config.service.PSPFPkgCatService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OSLIC = "OSLIC";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PKGTAG = "PKGTAG";
    public static final String FIELD_PKGTAG2 = "PKGTAG2";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPKGCATID = "PSPFPKGCATID";
    public static final String FIELD_PSPFPKGCATNAME = "PSPFPKGCATNAME";
    public static final String FIELD_PSPFPKGID = "PSPFPKGID";
    public static final String FIELD_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_OSLIC = 3;
    private static final int INDEX_PKGPARAM = 4;
    private static final int INDEX_PKGPARAM2 = 5;
    private static final int INDEX_PKGPARAM3 = 6;
    private static final int INDEX_PKGPARAM4 = 7;
    private static final int INDEX_PKGTAG = 8;
    private static final int INDEX_PKGTAG2 = 9;
    private static final int INDEX_PSDCID = 10;
    private static final int INDEX_PSDCNAME = 11;
    private static final int INDEX_PSPFID = 12;
    private static final int INDEX_PSPFNAME = 13;
    private static final int INDEX_PSPFPKGCATID = 14;
    private static final int INDEX_PSPFPKGCATNAME = 15;
    private static final int INDEX_PSPFPKGID = 16;
    private static final int INDEX_PSPFPKGNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPkgBase proxyPSPFPkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean oslicDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean pkgtagDirtyFlag = false;
    private boolean pkgtag2DirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpkgcatidDirtyFlag = false;
    private boolean pspfpkgcatnameDirtyFlag = false;
    private boolean pspfpkgidDirtyFlag = false;
    private boolean pspfpkgnameDirtyFlag = false;
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
    @Column(name="pkgparam")
    private String pkgparam;
    @Column(name="pkgparam2")
    private String pkgparam2;
    @Column(name="pkgparam3")
    private String pkgparam3;
    @Column(name="pkgparam4")
    private String pkgparam4;
    @Column(name="pkgtag")
    private String pkgtag;
    @Column(name="pkgtag2")
    private String pkgtag2;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpkgcatid")
    private String pspfpkgcatid;
    @Column(name="pspfpkgcatname")
    private String pspfpkgcatname;
    @Column(name="pspfpkgid")
    private String pspfpkgid;
    @Column(name="pspfpkgname")
    private String pspfpkgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSPFPkgCatLock = new Integer(1);
    private PSPFPkgCat pspfpkgcat = null;
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

    public void setPSPFPkgCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgcatid = string;
        this.pspfpkgcatidDirtyFlag = true;
    }

    public String getPSPFPkgCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgCatId();
        }
        return this.pspfpkgcatid;
    }

    public boolean isPSPFPkgCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgCatIdDirty();
        }
        return this.pspfpkgcatidDirtyFlag;
    }

    public void resetPSPFPkgCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgCatId();
            return;
        }
        this.pspfpkgcatidDirtyFlag = false;
        this.pspfpkgcatid = null;
    }

    public void setPSPFPkgCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgcatname = string;
        this.pspfpkgcatnameDirtyFlag = true;
    }

    public String getPSPFPkgCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgCatName();
        }
        return this.pspfpkgcatname;
    }

    public boolean isPSPFPkgCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgCatNameDirty();
        }
        return this.pspfpkgcatnameDirtyFlag;
    }

    public void resetPSPFPkgCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgCatName();
            return;
        }
        this.pspfpkgcatnameDirtyFlag = false;
        this.pspfpkgcatname = null;
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
        PSPFPkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPkgBase pSPFPkgBase) {
        pSPFPkgBase.resetCreateDate();
        pSPFPkgBase.resetCreateMan();
        pSPFPkgBase.resetMemo();
        pSPFPkgBase.resetOSLic();
        pSPFPkgBase.resetPkgParam();
        pSPFPkgBase.resetPkgParam2();
        pSPFPkgBase.resetPkgParam3();
        pSPFPkgBase.resetPkgParam4();
        pSPFPkgBase.resetPkgTag();
        pSPFPkgBase.resetPkgTag2();
        pSPFPkgBase.resetPSDCId();
        pSPFPkgBase.resetPSDCName();
        pSPFPkgBase.resetPSPFId();
        pSPFPkgBase.resetPSPFName();
        pSPFPkgBase.resetPSPFPkgCatId();
        pSPFPkgBase.resetPSPFPkgCatName();
        pSPFPkgBase.resetPSPFPkgId();
        pSPFPkgBase.resetPSPFPkgName();
        pSPFPkgBase.resetUpdateDate();
        pSPFPkgBase.resetUpdateMan();
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPkgCatIdDirty()) {
            hashMap.put(FIELD_PSPFPKGCATID, this.getPSPFPkgCatId());
        }
        if (!bl || this.isPSPFPkgCatNameDirty()) {
            hashMap.put(FIELD_PSPFPKGCATNAME, this.getPSPFPkgCatName());
        }
        if (!bl || this.isPSPFPkgIdDirty()) {
            hashMap.put(FIELD_PSPFPKGID, this.getPSPFPkgId());
        }
        if (!bl || this.isPSPFPkgNameDirty()) {
            hashMap.put(FIELD_PSPFPKGNAME, this.getPSPFPkgName());
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
        return PSPFPkgBase.get(this, n);
    }

    private static Object get(PSPFPkgBase pSPFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgBase.getCreateDate();
            }
            case 1: {
                return pSPFPkgBase.getCreateMan();
            }
            case 2: {
                return pSPFPkgBase.getMemo();
            }
            case 3: {
                return pSPFPkgBase.getOSLic();
            }
            case 4: {
                return pSPFPkgBase.getPkgParam();
            }
            case 5: {
                return pSPFPkgBase.getPkgParam2();
            }
            case 6: {
                return pSPFPkgBase.getPkgParam3();
            }
            case 7: {
                return pSPFPkgBase.getPkgParam4();
            }
            case 8: {
                return pSPFPkgBase.getPkgTag();
            }
            case 9: {
                return pSPFPkgBase.getPkgTag2();
            }
            case 10: {
                return pSPFPkgBase.getPSDCId();
            }
            case 11: {
                return pSPFPkgBase.getPSDCName();
            }
            case 12: {
                return pSPFPkgBase.getPSPFId();
            }
            case 13: {
                return pSPFPkgBase.getPSPFName();
            }
            case 14: {
                return pSPFPkgBase.getPSPFPkgCatId();
            }
            case 15: {
                return pSPFPkgBase.getPSPFPkgCatName();
            }
            case 16: {
                return pSPFPkgBase.getPSPFPkgId();
            }
            case 17: {
                return pSPFPkgBase.getPSPFPkgName();
            }
            case 18: {
                return pSPFPkgBase.getUpdateDate();
            }
            case 19: {
                return pSPFPkgBase.getUpdateMan();
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
        PSPFPkgBase.set(this, n, object);
    }

    private static void set(PSPFPkgBase pSPFPkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPkgBase.setOSLic(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPkgBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPkgBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPkgBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPkgBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPkgBase.setPkgTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPkgBase.setPkgTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPkgBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPkgBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPkgBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPkgBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPkgBase.setPSPFPkgCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPkgBase.setPSPFPkgCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPkgBase.setPSPFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPkgBase.setPSPFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFPkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSPFPkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPkgBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPkgBase pSPFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPkgBase.getMemo() == null;
            }
            case 3: {
                return pSPFPkgBase.getOSLic() == null;
            }
            case 4: {
                return pSPFPkgBase.getPkgParam() == null;
            }
            case 5: {
                return pSPFPkgBase.getPkgParam2() == null;
            }
            case 6: {
                return pSPFPkgBase.getPkgParam3() == null;
            }
            case 7: {
                return pSPFPkgBase.getPkgParam4() == null;
            }
            case 8: {
                return pSPFPkgBase.getPkgTag() == null;
            }
            case 9: {
                return pSPFPkgBase.getPkgTag2() == null;
            }
            case 10: {
                return pSPFPkgBase.getPSDCId() == null;
            }
            case 11: {
                return pSPFPkgBase.getPSDCName() == null;
            }
            case 12: {
                return pSPFPkgBase.getPSPFId() == null;
            }
            case 13: {
                return pSPFPkgBase.getPSPFName() == null;
            }
            case 14: {
                return pSPFPkgBase.getPSPFPkgCatId() == null;
            }
            case 15: {
                return pSPFPkgBase.getPSPFPkgCatName() == null;
            }
            case 16: {
                return pSPFPkgBase.getPSPFPkgId() == null;
            }
            case 17: {
                return pSPFPkgBase.getPSPFPkgName() == null;
            }
            case 18: {
                return pSPFPkgBase.getUpdateDate() == null;
            }
            case 19: {
                return pSPFPkgBase.getUpdateMan() == null;
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
        return PSPFPkgBase.contains(this, n);
    }

    private static boolean contains(PSPFPkgBase pSPFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPkgBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPkgBase.isMemoDirty();
            }
            case 3: {
                return pSPFPkgBase.isOSLicDirty();
            }
            case 4: {
                return pSPFPkgBase.isPkgParamDirty();
            }
            case 5: {
                return pSPFPkgBase.isPkgParam2Dirty();
            }
            case 6: {
                return pSPFPkgBase.isPkgParam3Dirty();
            }
            case 7: {
                return pSPFPkgBase.isPkgParam4Dirty();
            }
            case 8: {
                return pSPFPkgBase.isPkgTagDirty();
            }
            case 9: {
                return pSPFPkgBase.isPkgTag2Dirty();
            }
            case 10: {
                return pSPFPkgBase.isPSDCIdDirty();
            }
            case 11: {
                return pSPFPkgBase.isPSDCNameDirty();
            }
            case 12: {
                return pSPFPkgBase.isPSPFIdDirty();
            }
            case 13: {
                return pSPFPkgBase.isPSPFNameDirty();
            }
            case 14: {
                return pSPFPkgBase.isPSPFPkgCatIdDirty();
            }
            case 15: {
                return pSPFPkgBase.isPSPFPkgCatNameDirty();
            }
            case 16: {
                return pSPFPkgBase.isPSPFPkgIdDirty();
            }
            case 17: {
                return pSPFPkgBase.isPSPFPkgNameDirty();
            }
            case 18: {
                return pSPFPkgBase.isUpdateDateDirty();
            }
            case 19: {
                return pSPFPkgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPkgBase pSPFPkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getOSLic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oslic", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getOSLic()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgtag", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgTag()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPkgTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgtag2", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPkgTag2()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFPkgCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgcatid", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFPkgCatId()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFPkgCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgcatname", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFPkgCatName()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgid", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFPkgId()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getPSPFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgname", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getPSPFPkgName()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPkgBase.getJSONValue((Object)pSPFPkgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPkgBase pSPFPkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPkgBase.getCreateDate() != null) {
            object = pSPFPkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgBase.getCreateMan() != null) {
            object = pSPFPkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getMemo() != null) {
            object = pSPFPkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getOSLic() != null) {
            object = pSPFPkgBase.getOSLic();
            xmlNode.setAttribute(FIELD_OSLIC, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgParam() != null) {
            object = pSPFPkgBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgParam2() != null) {
            object = pSPFPkgBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgParam3() != null) {
            object = pSPFPkgBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgParam4() != null) {
            object = pSPFPkgBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgTag() != null) {
            object = pSPFPkgBase.getPkgTag();
            xmlNode.setAttribute(FIELD_PKGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPkgTag2() != null) {
            object = pSPFPkgBase.getPkgTag2();
            xmlNode.setAttribute(FIELD_PKGTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSDCId() != null) {
            object = pSPFPkgBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSDCName() != null) {
            object = pSPFPkgBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFId() != null) {
            object = pSPFPkgBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFName() != null) {
            object = pSPFPkgBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFPkgCatId() != null) {
            object = pSPFPkgBase.getPSPFPkgCatId();
            xmlNode.setAttribute(FIELD_PSPFPKGCATID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFPkgCatName() != null) {
            object = pSPFPkgBase.getPSPFPkgCatName();
            xmlNode.setAttribute(FIELD_PSPFPKGCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFPkgId() != null) {
            object = pSPFPkgBase.getPSPFPkgId();
            xmlNode.setAttribute(FIELD_PSPFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getPSPFPkgName() != null) {
            object = pSPFPkgBase.getPSPFPkgName();
            xmlNode.setAttribute(FIELD_PSPFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgBase.getUpdateDate() != null) {
            object = pSPFPkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgBase.getUpdateMan() != null) {
            object = pSPFPkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPkgBase pSPFPkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPkgBase.isCreateDateDirty() && (bl || pSPFPkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPkgBase.getCreateDate());
        }
        if (pSPFPkgBase.isCreateManDirty() && (bl || pSPFPkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPkgBase.getCreateMan());
        }
        if (pSPFPkgBase.isMemoDirty() && (bl || pSPFPkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPkgBase.getMemo());
        }
        if (pSPFPkgBase.isOSLicDirty() && (bl || pSPFPkgBase.getOSLic() != null)) {
            iDataObject.set(FIELD_OSLIC, (Object)pSPFPkgBase.getOSLic());
        }
        if (pSPFPkgBase.isPkgParamDirty() && (bl || pSPFPkgBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSPFPkgBase.getPkgParam());
        }
        if (pSPFPkgBase.isPkgParam2Dirty() && (bl || pSPFPkgBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSPFPkgBase.getPkgParam2());
        }
        if (pSPFPkgBase.isPkgParam3Dirty() && (bl || pSPFPkgBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSPFPkgBase.getPkgParam3());
        }
        if (pSPFPkgBase.isPkgParam4Dirty() && (bl || pSPFPkgBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSPFPkgBase.getPkgParam4());
        }
        if (pSPFPkgBase.isPkgTagDirty() && (bl || pSPFPkgBase.getPkgTag() != null)) {
            iDataObject.set(FIELD_PKGTAG, (Object)pSPFPkgBase.getPkgTag());
        }
        if (pSPFPkgBase.isPkgTag2Dirty() && (bl || pSPFPkgBase.getPkgTag2() != null)) {
            iDataObject.set(FIELD_PKGTAG2, (Object)pSPFPkgBase.getPkgTag2());
        }
        if (pSPFPkgBase.isPSDCIdDirty() && (bl || pSPFPkgBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSPFPkgBase.getPSDCId());
        }
        if (pSPFPkgBase.isPSDCNameDirty() && (bl || pSPFPkgBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSPFPkgBase.getPSDCName());
        }
        if (pSPFPkgBase.isPSPFIdDirty() && (bl || pSPFPkgBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPkgBase.getPSPFId());
        }
        if (pSPFPkgBase.isPSPFNameDirty() && (bl || pSPFPkgBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPkgBase.getPSPFName());
        }
        if (pSPFPkgBase.isPSPFPkgCatIdDirty() && (bl || pSPFPkgBase.getPSPFPkgCatId() != null)) {
            iDataObject.set(FIELD_PSPFPKGCATID, (Object)pSPFPkgBase.getPSPFPkgCatId());
        }
        if (pSPFPkgBase.isPSPFPkgCatNameDirty() && (bl || pSPFPkgBase.getPSPFPkgCatName() != null)) {
            iDataObject.set(FIELD_PSPFPKGCATNAME, (Object)pSPFPkgBase.getPSPFPkgCatName());
        }
        if (pSPFPkgBase.isPSPFPkgIdDirty() && (bl || pSPFPkgBase.getPSPFPkgId() != null)) {
            iDataObject.set(FIELD_PSPFPKGID, (Object)pSPFPkgBase.getPSPFPkgId());
        }
        if (pSPFPkgBase.isPSPFPkgNameDirty() && (bl || pSPFPkgBase.getPSPFPkgName() != null)) {
            iDataObject.set(FIELD_PSPFPKGNAME, (Object)pSPFPkgBase.getPSPFPkgName());
        }
        if (pSPFPkgBase.isUpdateDateDirty() && (bl || pSPFPkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPkgBase.getUpdateDate());
        }
        if (pSPFPkgBase.isUpdateManDirty() && (bl || pSPFPkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPkgBase.getUpdateMan());
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
        return PSPFPkgBase.remove(this, n);
    }

    private static boolean remove(PSPFPkgBase pSPFPkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFPkgBase.resetOSLic();
                return true;
            }
            case 4: {
                pSPFPkgBase.resetPkgParam();
                return true;
            }
            case 5: {
                pSPFPkgBase.resetPkgParam2();
                return true;
            }
            case 6: {
                pSPFPkgBase.resetPkgParam3();
                return true;
            }
            case 7: {
                pSPFPkgBase.resetPkgParam4();
                return true;
            }
            case 8: {
                pSPFPkgBase.resetPkgTag();
                return true;
            }
            case 9: {
                pSPFPkgBase.resetPkgTag2();
                return true;
            }
            case 10: {
                pSPFPkgBase.resetPSDCId();
                return true;
            }
            case 11: {
                pSPFPkgBase.resetPSDCName();
                return true;
            }
            case 12: {
                pSPFPkgBase.resetPSPFId();
                return true;
            }
            case 13: {
                pSPFPkgBase.resetPSPFName();
                return true;
            }
            case 14: {
                pSPFPkgBase.resetPSPFPkgCatId();
                return true;
            }
            case 15: {
                pSPFPkgBase.resetPSPFPkgCatName();
                return true;
            }
            case 16: {
                pSPFPkgBase.resetPSPFPkgId();
                return true;
            }
            case 17: {
                pSPFPkgBase.resetPSPFPkgName();
                return true;
            }
            case 18: {
                pSPFPkgBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSPFPkgBase.resetUpdateMan();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPkgCat getPSPFPkgCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgCat();
        }
        if (this.getPSPFPkgCatId() == null) {
            return null;
        }
        Integer n = this.objPSPFPkgCatLock;
        synchronized (n) {
            if (this.pspfpkgcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPkgCatId(), (Object)this.pspfpkgcat.getPSPFPkgCatId()) != 0L) {
                this.pspfpkgcat = null;
            }
            if (this.pspfpkgcat == null) {
                PSPFPkgCat pSPFPkgCat = new PSPFPkgCat();
                pSPFPkgCat.setPSPFPkgCatId(this.getPSPFPkgCatId());
                PSPFPkgCatService pSPFPkgCatService = (PSPFPkgCatService)ServiceGlobal.getService(PSPFPkgCatService.class, (SessionFactory)this.getSessionFactory());
                pSPFPkgCatService.autoGet(pSPFPkgCat);
                this.pspfpkgcat = pSPFPkgCat;
            }
            return this.pspfpkgcat;
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

    private PSPFPkgBase getProxyEntity() {
        return this.proxyPSPFPkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPkgBase) {
            this.proxyPSPFPkgBase = (PSPFPkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_OSLIC, 3);
        fieldIndexMap.put(FIELD_PKGPARAM, 4);
        fieldIndexMap.put(FIELD_PKGPARAM2, 5);
        fieldIndexMap.put(FIELD_PKGPARAM3, 6);
        fieldIndexMap.put(FIELD_PKGPARAM4, 7);
        fieldIndexMap.put(FIELD_PKGTAG, 8);
        fieldIndexMap.put(FIELD_PKGTAG2, 9);
        fieldIndexMap.put(FIELD_PSDCID, 10);
        fieldIndexMap.put(FIELD_PSDCNAME, 11);
        fieldIndexMap.put(FIELD_PSPFID, 12);
        fieldIndexMap.put(FIELD_PSPFNAME, 13);
        fieldIndexMap.put(FIELD_PSPFPKGCATID, 14);
        fieldIndexMap.put(FIELD_PSPFPKGCATNAME, 15);
        fieldIndexMap.put(FIELD_PSPFPKGID, 16);
        fieldIndexMap.put(FIELD_PSPFPKGNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

