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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSFBase.class);
    public static final String FIELD_BASECLSPKGCODENAME = "BASECLSPKGCODENAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGCODENAME = "PKGCODENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSUBSYSSFID = "PSSUBSYSSFID";
    public static final String FIELD_PSSUBSYSSFNAME = "PSSUBSYSSFNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPKGCODENAME = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PKGCODENAME = 5;
    private static final int INDEX_PSSFID = 6;
    private static final int INDEX_PSSFNAME = 7;
    private static final int INDEX_PSSFSTYLEID = 8;
    private static final int INDEX_PSSFSTYLENAME = 9;
    private static final int INDEX_PSSUBSYSID = 10;
    private static final int INDEX_PSSUBSYSNAME = 11;
    private static final int INDEX_PSSUBSYSSFID = 12;
    private static final int INDEX_PSSUBSYSSFNAME = 13;
    private static final int INDEX_PSSYSSFPUBID = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSFBase proxyPSSubSysSFBase = null;
    private boolean baseclspkgcodenameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgcodenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssubsyssfidDirtyFlag = false;
    private boolean pssubsyssfnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclspkgcodename")
    private String baseclspkgcodename;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgcodename")
    private String pkgcodename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="pssubsyssfid")
    private String pssubsyssfid;
    @Column(name="pssubsyssfname")
    private String pssubsyssfname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

    public void setBaseClsPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclspkgcodename = string;
        this.baseclspkgcodenameDirtyFlag = true;
    }

    public String getBaseClsPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsPKGCodeName();
        }
        return this.baseclspkgcodename;
    }

    public boolean isBaseClsPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsPKGCodeNameDirty();
        }
        return this.baseclspkgcodenameDirtyFlag;
    }

    public void resetBaseClsPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsPKGCodeName();
            return;
        }
        this.baseclspkgcodenameDirtyFlag = false;
        this.baseclspkgcodename = null;
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

    public void setPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgcodename = string;
        this.pkgcodenameDirtyFlag = true;
    }

    public String getPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGCodeName();
        }
        return this.pkgcodename;
    }

    public boolean isPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGCodeNameDirty();
        }
        return this.pkgcodenameDirtyFlag;
    }

    public void resetPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGCodeName();
            return;
        }
        this.pkgcodenameDirtyFlag = false;
        this.pkgcodename = null;
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

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
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

    public void setPSSubSysSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssfid = string;
        this.pssubsyssfidDirtyFlag = true;
    }

    public String getPSSubSysSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSFId();
        }
        return this.pssubsyssfid;
    }

    public boolean isPSSubSysSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSFIdDirty();
        }
        return this.pssubsyssfidDirtyFlag;
    }

    public void resetPSSubSysSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSFId();
            return;
        }
        this.pssubsyssfidDirtyFlag = false;
        this.pssubsyssfid = null;
    }

    public void setPSSubSysSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssfname = string;
        this.pssubsyssfnameDirtyFlag = true;
    }

    public String getPSSubSysSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSFName();
        }
        return this.pssubsyssfname;
    }

    public boolean isPSSubSysSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSFNameDirty();
        }
        return this.pssubsyssfnameDirtyFlag;
    }

    public void resetPSSubSysSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSFName();
            return;
        }
        this.pssubsyssfnameDirtyFlag = false;
        this.pssubsyssfname = null;
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
        PSSubSysSFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSFBase pSSubSysSFBase) {
        pSSubSysSFBase.resetBaseClsPKGCodeName();
        pSSubSysSFBase.resetCodeName();
        pSSubSysSFBase.resetCreateDate();
        pSSubSysSFBase.resetCreateMan();
        pSSubSysSFBase.resetMemo();
        pSSubSysSFBase.resetPKGCodeName();
        pSSubSysSFBase.resetPSSFId();
        pSSubSysSFBase.resetPSSFName();
        pSSubSysSFBase.resetPSSFStyleId();
        pSSubSysSFBase.resetPSSFStyleName();
        pSSubSysSFBase.resetPSSubSysId();
        pSSubSysSFBase.resetPSSubSysName();
        pSSubSysSFBase.resetPSSubSysSFId();
        pSSubSysSFBase.resetPSSubSysSFName();
        pSSubSysSFBase.resetPSSysSFPubId();
        pSSubSysSFBase.resetUpdateDate();
        pSSubSysSFBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsPKGCodeNameDirty()) {
            hashMap.put(FIELD_BASECLSPKGCODENAME, this.getBaseClsPKGCodeName());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPKGCodeNameDirty()) {
            hashMap.put(FIELD_PKGCODENAME, this.getPKGCodeName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
        }
        if (!bl || this.isPSSubSysSFIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSFID, this.getPSSubSysSFId());
        }
        if (!bl || this.isPSSubSysSFNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSFNAME, this.getPSSubSysSFName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
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
        return PSSubSysSFBase.get(this, n);
    }

    private static Object get(PSSubSysSFBase pSSubSysSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSFBase.getBaseClsPKGCodeName();
            }
            case 1: {
                return pSSubSysSFBase.getCodeName();
            }
            case 2: {
                return pSSubSysSFBase.getCreateDate();
            }
            case 3: {
                return pSSubSysSFBase.getCreateMan();
            }
            case 4: {
                return pSSubSysSFBase.getMemo();
            }
            case 5: {
                return pSSubSysSFBase.getPKGCodeName();
            }
            case 6: {
                return pSSubSysSFBase.getPSSFId();
            }
            case 7: {
                return pSSubSysSFBase.getPSSFName();
            }
            case 8: {
                return pSSubSysSFBase.getPSSFStyleId();
            }
            case 9: {
                return pSSubSysSFBase.getPSSFStyleName();
            }
            case 10: {
                return pSSubSysSFBase.getPSSubSysId();
            }
            case 11: {
                return pSSubSysSFBase.getPSSubSysName();
            }
            case 12: {
                return pSSubSysSFBase.getPSSubSysSFId();
            }
            case 13: {
                return pSSubSysSFBase.getPSSubSysSFName();
            }
            case 14: {
                return pSSubSysSFBase.getPSSysSFPubId();
            }
            case 15: {
                return pSSubSysSFBase.getUpdateDate();
            }
            case 16: {
                return pSSubSysSFBase.getUpdateMan();
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
        PSSubSysSFBase.set(this, n, object);
    }

    private static void set(PSSubSysSFBase pSSubSysSFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSFBase.setBaseClsPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSFBase.setPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSFBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSFBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSFBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSFBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSFBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSFBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSFBase.setPSSubSysSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSFBase.setPSSubSysSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSFBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSubSysSFBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSFBase pSSubSysSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSFBase.getBaseClsPKGCodeName() == null;
            }
            case 1: {
                return pSSubSysSFBase.getCodeName() == null;
            }
            case 2: {
                return pSSubSysSFBase.getCreateDate() == null;
            }
            case 3: {
                return pSSubSysSFBase.getCreateMan() == null;
            }
            case 4: {
                return pSSubSysSFBase.getMemo() == null;
            }
            case 5: {
                return pSSubSysSFBase.getPKGCodeName() == null;
            }
            case 6: {
                return pSSubSysSFBase.getPSSFId() == null;
            }
            case 7: {
                return pSSubSysSFBase.getPSSFName() == null;
            }
            case 8: {
                return pSSubSysSFBase.getPSSFStyleId() == null;
            }
            case 9: {
                return pSSubSysSFBase.getPSSFStyleName() == null;
            }
            case 10: {
                return pSSubSysSFBase.getPSSubSysId() == null;
            }
            case 11: {
                return pSSubSysSFBase.getPSSubSysName() == null;
            }
            case 12: {
                return pSSubSysSFBase.getPSSubSysSFId() == null;
            }
            case 13: {
                return pSSubSysSFBase.getPSSubSysSFName() == null;
            }
            case 14: {
                return pSSubSysSFBase.getPSSysSFPubId() == null;
            }
            case 15: {
                return pSSubSysSFBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSubSysSFBase.getUpdateMan() == null;
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
        return PSSubSysSFBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSFBase pSSubSysSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSFBase.isBaseClsPKGCodeNameDirty();
            }
            case 1: {
                return pSSubSysSFBase.isCodeNameDirty();
            }
            case 2: {
                return pSSubSysSFBase.isCreateDateDirty();
            }
            case 3: {
                return pSSubSysSFBase.isCreateManDirty();
            }
            case 4: {
                return pSSubSysSFBase.isMemoDirty();
            }
            case 5: {
                return pSSubSysSFBase.isPKGCodeNameDirty();
            }
            case 6: {
                return pSSubSysSFBase.isPSSFIdDirty();
            }
            case 7: {
                return pSSubSysSFBase.isPSSFNameDirty();
            }
            case 8: {
                return pSSubSysSFBase.isPSSFStyleIdDirty();
            }
            case 9: {
                return pSSubSysSFBase.isPSSFStyleNameDirty();
            }
            case 10: {
                return pSSubSysSFBase.isPSSubSysIdDirty();
            }
            case 11: {
                return pSSubSysSFBase.isPSSubSysNameDirty();
            }
            case 12: {
                return pSSubSysSFBase.isPSSubSysSFIdDirty();
            }
            case 13: {
                return pSSubSysSFBase.isPSSubSysSFNameDirty();
            }
            case 14: {
                return pSSubSysSFBase.isPSSysSFPubIdDirty();
            }
            case 15: {
                return pSSubSysSFBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSubSysSFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSFBase pSSubSysSFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSFBase.getBaseClsPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclspkgcodename", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getBaseClsPKGCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgcodename", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPKGCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSubSysSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssfid", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSubSysSFId()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSubSysSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssfname", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSubSysSFName()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSFBase.getJSONValue((Object)pSSubSysSFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSFBase pSSubSysSFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSFBase.getBaseClsPKGCodeName() != null) {
            object = pSSubSysSFBase.getBaseClsPKGCodeName();
            xmlNode.setAttribute(FIELD_BASECLSPKGCODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSubSysSFBase.getCodeName() != null) {
            object = pSSubSysSFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getCreateDate() != null) {
            object = pSSubSysSFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSFBase.getCreateMan() != null) {
            object = pSSubSysSFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getMemo() != null) {
            object = pSSubSysSFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPKGCodeName() != null) {
            object = pSSubSysSFBase.getPKGCodeName();
            xmlNode.setAttribute(FIELD_PKGCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSFId() != null) {
            object = pSSubSysSFBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSFName() != null) {
            object = pSSubSysSFBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSFStyleId() != null) {
            object = pSSubSysSFBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSFStyleName() != null) {
            object = pSSubSysSFBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSubSysId() != null) {
            object = pSSubSysSFBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSubSysName() != null) {
            object = pSSubSysSFBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSubSysSFId() != null) {
            object = pSSubSysSFBase.getPSSubSysSFId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSubSysSFName() != null) {
            object = pSSubSysSFBase.getPSSubSysSFName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getPSSysSFPubId() != null) {
            object = pSSubSysSFBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSFBase.getUpdateDate() != null) {
            object = pSSubSysSFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSFBase.getUpdateMan() != null) {
            object = pSSubSysSFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSFBase pSSubSysSFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSFBase.isBaseClsPKGCodeNameDirty() && (bl || pSSubSysSFBase.getBaseClsPKGCodeName() != null)) {
            iDataObject.set(FIELD_BASECLSPKGCODENAME, (Object)pSSubSysSFBase.getBaseClsPKGCodeName());
        }
        if (pSSubSysSFBase.isCodeNameDirty() && (bl || pSSubSysSFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSFBase.getCodeName());
        }
        if (pSSubSysSFBase.isCreateDateDirty() && (bl || pSSubSysSFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSFBase.getCreateDate());
        }
        if (pSSubSysSFBase.isCreateManDirty() && (bl || pSSubSysSFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSFBase.getCreateMan());
        }
        if (pSSubSysSFBase.isMemoDirty() && (bl || pSSubSysSFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSFBase.getMemo());
        }
        if (pSSubSysSFBase.isPKGCodeNameDirty() && (bl || pSSubSysSFBase.getPKGCodeName() != null)) {
            iDataObject.set(FIELD_PKGCODENAME, (Object)pSSubSysSFBase.getPKGCodeName());
        }
        if (pSSubSysSFBase.isPSSFIdDirty() && (bl || pSSubSysSFBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSubSysSFBase.getPSSFId());
        }
        if (pSSubSysSFBase.isPSSFNameDirty() && (bl || pSSubSysSFBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSubSysSFBase.getPSSFName());
        }
        if (pSSubSysSFBase.isPSSFStyleIdDirty() && (bl || pSSubSysSFBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSubSysSFBase.getPSSFStyleId());
        }
        if (pSSubSysSFBase.isPSSFStyleNameDirty() && (bl || pSSubSysSFBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSubSysSFBase.getPSSFStyleName());
        }
        if (pSSubSysSFBase.isPSSubSysIdDirty() && (bl || pSSubSysSFBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubSysSFBase.getPSSubSysId());
        }
        if (pSSubSysSFBase.isPSSubSysNameDirty() && (bl || pSSubSysSFBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubSysSFBase.getPSSubSysName());
        }
        if (pSSubSysSFBase.isPSSubSysSFIdDirty() && (bl || pSSubSysSFBase.getPSSubSysSFId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSFID, (Object)pSSubSysSFBase.getPSSubSysSFId());
        }
        if (pSSubSysSFBase.isPSSubSysSFNameDirty() && (bl || pSSubSysSFBase.getPSSubSysSFName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSFNAME, (Object)pSSubSysSFBase.getPSSubSysSFName());
        }
        if (pSSubSysSFBase.isPSSysSFPubIdDirty() && (bl || pSSubSysSFBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSubSysSFBase.getPSSysSFPubId());
        }
        if (pSSubSysSFBase.isUpdateDateDirty() && (bl || pSSubSysSFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSFBase.getUpdateDate());
        }
        if (pSSubSysSFBase.isUpdateManDirty() && (bl || pSSubSysSFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSFBase.getUpdateMan());
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
        return PSSubSysSFBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSFBase pSSubSysSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSFBase.resetBaseClsPKGCodeName();
                return true;
            }
            case 1: {
                pSSubSysSFBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSubSysSFBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSubSysSFBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSubSysSFBase.resetMemo();
                return true;
            }
            case 5: {
                pSSubSysSFBase.resetPKGCodeName();
                return true;
            }
            case 6: {
                pSSubSysSFBase.resetPSSFId();
                return true;
            }
            case 7: {
                pSSubSysSFBase.resetPSSFName();
                return true;
            }
            case 8: {
                pSSubSysSFBase.resetPSSFStyleId();
                return true;
            }
            case 9: {
                pSSubSysSFBase.resetPSSFStyleName();
                return true;
            }
            case 10: {
                pSSubSysSFBase.resetPSSubSysId();
                return true;
            }
            case 11: {
                pSSubSysSFBase.resetPSSubSysName();
                return true;
            }
            case 12: {
                pSSubSysSFBase.resetPSSubSysSFId();
                return true;
            }
            case 13: {
                pSSubSysSFBase.resetPSSubSysSFName();
                return true;
            }
            case 14: {
                pSSubSysSFBase.resetPSSysSFPubId();
                return true;
            }
            case 15: {
                pSSubSysSFBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSubSysSFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
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
                pSSFService.autoGet(pSSF);
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
                pSSubSysService.autoGet(pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSubSysSFBase getProxyEntity() {
        return this.proxyPSSubSysSFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSFBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSFBase) {
            this.proxyPSSubSysSFBase = (PSSubSysSFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysSFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPKGCODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PKGCODENAME, 5);
        fieldIndexMap.put(FIELD_PSSFID, 6);
        fieldIndexMap.put(FIELD_PSSFNAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 8);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 11);
        fieldIndexMap.put(FIELD_PSSUBSYSSFID, 12);
        fieldIndexMap.put(FIELD_PSSUBSYSSFNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

