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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSaaSSysBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSAASSYSID = "PSSAASSYSID";
    public static final String FIELD_PSSAASSYSNAME = "PSSAASSYSNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_SFPSSUBSYSID = "SFPSSUBSYSID";
    public static final String FIELD_SFPSSUBSYSNAME = "SFPSSUBSYSNAME";
    public static final String FIELD_SYSTAG = "SYSTAG";
    public static final String FIELD_SYSTAG2 = "SYSTAG2";
    public static final String FIELD_SYSTAG3 = "SYSTAG3";
    public static final String FIELD_SYSTAG4 = "SYSTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_PSDEVSLNSYSID = 6;
    private static final int INDEX_PSDEVSLNSYSNAME = 7;
    private static final int INDEX_PSSAASSYSID = 8;
    private static final int INDEX_PSSAASSYSNAME = 9;
    private static final int INDEX_PSSFID = 10;
    private static final int INDEX_PSSFNAME = 11;
    private static final int INDEX_PUBMODE = 12;
    private static final int INDEX_SFPSSUBSYSID = 13;
    private static final int INDEX_SFPSSUBSYSNAME = 14;
    private static final int INDEX_SYSTAG = 15;
    private static final int INDEX_SYSTAG2 = 16;
    private static final int INDEX_SYSTAG3 = 17;
    private static final int INDEX_SYSTAG4 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSaaSSysBase proxyPSSaaSSysBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssaassysidDirtyFlag = false;
    private boolean pssaassysnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean sfpssubsysidDirtyFlag = false;
    private boolean sfpssubsysnameDirtyFlag = false;
    private boolean systagDirtyFlag = false;
    private boolean systag2DirtyFlag = false;
    private boolean systag3DirtyFlag = false;
    private boolean systag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssaassysid")
    private String pssaassysid;
    @Column(name="pssaassysname")
    private String pssaassysname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="sfpssubsysid")
    private String sfpssubsysid;
    @Column(name="sfpssubsysname")
    private String sfpssubsysname;
    @Column(name="systag")
    private String systag;
    @Column(name="systag2")
    private String systag2;
    @Column(name="systag3")
    private String systag3;
    @Column(name="systag4")
    private String systag4;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objSFPSSubSysLock = new Integer(1);
    private PSSubSys sfpssubsys = null;
    private Integer objPSSaaSSysVersLock = new Integer(1);
    private ArrayList<PSSaaSSysVer> pssaassysvers = null;

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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSSaaSSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysid = string;
        this.pssaassysidDirtyFlag = true;
    }

    public String getPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysId();
        }
        return this.pssaassysid;
    }

    public boolean isPSSaaSSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysIdDirty();
        }
        return this.pssaassysidDirtyFlag;
    }

    public void resetPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysId();
            return;
        }
        this.pssaassysidDirtyFlag = false;
        this.pssaassysid = null;
    }

    public void setPSSaaSSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysname = string;
        this.pssaassysnameDirtyFlag = true;
    }

    public String getPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysName();
        }
        return this.pssaassysname;
    }

    public boolean isPSSaaSSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysNameDirty();
        }
        return this.pssaassysnameDirtyFlag;
    }

    public void resetPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysName();
            return;
        }
        this.pssaassysnameDirtyFlag = false;
        this.pssaassysname = null;
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

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setSFPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpssubsysid = string;
        this.sfpssubsysidDirtyFlag = true;
    }

    public String getSFPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSysId();
        }
        return this.sfpssubsysid;
    }

    public boolean isSFPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSSubSysIdDirty();
        }
        return this.sfpssubsysidDirtyFlag;
    }

    public void resetSFPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSSubSysId();
            return;
        }
        this.sfpssubsysidDirtyFlag = false;
        this.sfpssubsysid = null;
    }

    public void setSFPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfpssubsysname = string;
        this.sfpssubsysnameDirtyFlag = true;
    }

    public String getSFPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSysName();
        }
        return this.sfpssubsysname;
    }

    public boolean isSFPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFPSSubSysNameDirty();
        }
        return this.sfpssubsysnameDirtyFlag;
    }

    public void resetSFPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFPSSubSysName();
            return;
        }
        this.sfpssubsysnameDirtyFlag = false;
        this.sfpssubsysname = null;
    }

    public void setSysTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag = string;
        this.systagDirtyFlag = true;
    }

    public String getSysTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag();
        }
        return this.systag;
    }

    public boolean isSysTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTagDirty();
        }
        return this.systagDirtyFlag;
    }

    public void resetSysTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag();
            return;
        }
        this.systagDirtyFlag = false;
        this.systag = null;
    }

    public void setSysTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag2 = string;
        this.systag2DirtyFlag = true;
    }

    public String getSysTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag2();
        }
        return this.systag2;
    }

    public boolean isSysTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag2Dirty();
        }
        return this.systag2DirtyFlag;
    }

    public void resetSysTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag2();
            return;
        }
        this.systag2DirtyFlag = false;
        this.systag2 = null;
    }

    public void setSysTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag3 = string;
        this.systag3DirtyFlag = true;
    }

    public String getSysTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag3();
        }
        return this.systag3;
    }

    public boolean isSysTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag3Dirty();
        }
        return this.systag3DirtyFlag;
    }

    public void resetSysTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag3();
            return;
        }
        this.systag3DirtyFlag = false;
        this.systag3 = null;
    }

    public void setSysTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag4 = string;
        this.systag4DirtyFlag = true;
    }

    public String getSysTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag4();
        }
        return this.systag4;
    }

    public boolean isSysTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag4Dirty();
        }
        return this.systag4DirtyFlag;
    }

    public void resetSysTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag4();
            return;
        }
        this.systag4DirtyFlag = false;
        this.systag4 = null;
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
        PSSaaSSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSaaSSysBase pSSaaSSysBase) {
        pSSaaSSysBase.resetCodeName();
        pSSaaSSysBase.resetCreateDate();
        pSSaaSSysBase.resetCreateMan();
        pSSaaSSysBase.resetMemo();
        pSSaaSSysBase.resetPSDevCenterId();
        pSSaaSSysBase.resetPSDevCenterName();
        pSSaaSSysBase.resetPSDevSlnSysId();
        pSSaaSSysBase.resetPSDevSlnSysName();
        pSSaaSSysBase.resetPSSaaSSysId();
        pSSaaSSysBase.resetPSSaaSSysName();
        pSSaaSSysBase.resetPSSFId();
        pSSaaSSysBase.resetPSSFName();
        pSSaaSSysBase.resetPubMode();
        pSSaaSSysBase.resetSFPSSubSysId();
        pSSaaSSysBase.resetSFPSSubSysName();
        pSSaaSSysBase.resetSysTag();
        pSSaaSSysBase.resetSysTag2();
        pSSaaSSysBase.resetSysTag3();
        pSSaaSSysBase.resetSysTag4();
        pSSaaSSysBase.resetUpdateDate();
        pSSaaSSysBase.resetUpdateMan();
        pSSaaSSysBase.resetUserCat();
        pSSaaSSysBase.resetUserTag();
        pSSaaSSysBase.resetUserTag2();
        pSSaaSSysBase.resetUserTag3();
        pSSaaSSysBase.resetUserTag4();
        pSSaaSSysBase.resetValidFlag();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSSaaSSysIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSID, this.getPSSaaSSysId());
        }
        if (!bl || this.isPSSaaSSysNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSNAME, this.getPSSaaSSysName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isSFPSSubSysIdDirty()) {
            hashMap.put(FIELD_SFPSSUBSYSID, this.getSFPSSubSysId());
        }
        if (!bl || this.isSFPSSubSysNameDirty()) {
            hashMap.put(FIELD_SFPSSUBSYSNAME, this.getSFPSSubSysName());
        }
        if (!bl || this.isSysTagDirty()) {
            hashMap.put(FIELD_SYSTAG, this.getSysTag());
        }
        if (!bl || this.isSysTag2Dirty()) {
            hashMap.put(FIELD_SYSTAG2, this.getSysTag2());
        }
        if (!bl || this.isSysTag3Dirty()) {
            hashMap.put(FIELD_SYSTAG3, this.getSysTag3());
        }
        if (!bl || this.isSysTag4Dirty()) {
            hashMap.put(FIELD_SYSTAG4, this.getSysTag4());
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
        return PSSaaSSysBase.get(this, n);
    }

    private static Object get(PSSaaSSysBase pSSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysBase.getCodeName();
            }
            case 1: {
                return pSSaaSSysBase.getCreateDate();
            }
            case 2: {
                return pSSaaSSysBase.getCreateMan();
            }
            case 3: {
                return pSSaaSSysBase.getMemo();
            }
            case 4: {
                return pSSaaSSysBase.getPSDevCenterId();
            }
            case 5: {
                return pSSaaSSysBase.getPSDevCenterName();
            }
            case 6: {
                return pSSaaSSysBase.getPSDevSlnSysId();
            }
            case 7: {
                return pSSaaSSysBase.getPSDevSlnSysName();
            }
            case 8: {
                return pSSaaSSysBase.getPSSaaSSysId();
            }
            case 9: {
                return pSSaaSSysBase.getPSSaaSSysName();
            }
            case 10: {
                return pSSaaSSysBase.getPSSFId();
            }
            case 11: {
                return pSSaaSSysBase.getPSSFName();
            }
            case 12: {
                return pSSaaSSysBase.getPubMode();
            }
            case 13: {
                return pSSaaSSysBase.getSFPSSubSysId();
            }
            case 14: {
                return pSSaaSSysBase.getSFPSSubSysName();
            }
            case 15: {
                return pSSaaSSysBase.getSysTag();
            }
            case 16: {
                return pSSaaSSysBase.getSysTag2();
            }
            case 17: {
                return pSSaaSSysBase.getSysTag3();
            }
            case 18: {
                return pSSaaSSysBase.getSysTag4();
            }
            case 19: {
                return pSSaaSSysBase.getUpdateDate();
            }
            case 20: {
                return pSSaaSSysBase.getUpdateMan();
            }
            case 21: {
                return pSSaaSSysBase.getUserCat();
            }
            case 22: {
                return pSSaaSSysBase.getUserTag();
            }
            case 23: {
                return pSSaaSSysBase.getUserTag2();
            }
            case 24: {
                return pSSaaSSysBase.getUserTag3();
            }
            case 25: {
                return pSSaaSSysBase.getUserTag4();
            }
            case 26: {
                return pSSaaSSysBase.getValidFlag();
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
        PSSaaSSysBase.set(this, n, object);
    }

    private static void set(PSSaaSSysBase pSSaaSSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSaaSSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSaaSSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSaaSSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSaaSSysBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSaaSSysBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSaaSSysBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSaaSSysBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSaaSSysBase.setPSSaaSSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSaaSSysBase.setPSSaaSSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSaaSSysBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSaaSSysBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSaaSSysBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSaaSSysBase.setSFPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSaaSSysBase.setSFPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSaaSSysBase.setSysTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSaaSSysBase.setSysTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSaaSSysBase.setSysTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSaaSSysBase.setSysTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSaaSSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSaaSSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSaaSSysBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSaaSSysBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSaaSSysBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSaaSSysBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSaaSSysBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSaaSSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSaaSSysBase.isNull(this, n);
    }

    private static boolean isNull(PSSaaSSysBase pSSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysBase.getCodeName() == null;
            }
            case 1: {
                return pSSaaSSysBase.getCreateDate() == null;
            }
            case 2: {
                return pSSaaSSysBase.getCreateMan() == null;
            }
            case 3: {
                return pSSaaSSysBase.getMemo() == null;
            }
            case 4: {
                return pSSaaSSysBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSSaaSSysBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSSaaSSysBase.getPSDevSlnSysId() == null;
            }
            case 7: {
                return pSSaaSSysBase.getPSDevSlnSysName() == null;
            }
            case 8: {
                return pSSaaSSysBase.getPSSaaSSysId() == null;
            }
            case 9: {
                return pSSaaSSysBase.getPSSaaSSysName() == null;
            }
            case 10: {
                return pSSaaSSysBase.getPSSFId() == null;
            }
            case 11: {
                return pSSaaSSysBase.getPSSFName() == null;
            }
            case 12: {
                return pSSaaSSysBase.getPubMode() == null;
            }
            case 13: {
                return pSSaaSSysBase.getSFPSSubSysId() == null;
            }
            case 14: {
                return pSSaaSSysBase.getSFPSSubSysName() == null;
            }
            case 15: {
                return pSSaaSSysBase.getSysTag() == null;
            }
            case 16: {
                return pSSaaSSysBase.getSysTag2() == null;
            }
            case 17: {
                return pSSaaSSysBase.getSysTag3() == null;
            }
            case 18: {
                return pSSaaSSysBase.getSysTag4() == null;
            }
            case 19: {
                return pSSaaSSysBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSaaSSysBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSaaSSysBase.getUserCat() == null;
            }
            case 22: {
                return pSSaaSSysBase.getUserTag() == null;
            }
            case 23: {
                return pSSaaSSysBase.getUserTag2() == null;
            }
            case 24: {
                return pSSaaSSysBase.getUserTag3() == null;
            }
            case 25: {
                return pSSaaSSysBase.getUserTag4() == null;
            }
            case 26: {
                return pSSaaSSysBase.getValidFlag() == null;
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
        return PSSaaSSysBase.contains(this, n);
    }

    private static boolean contains(PSSaaSSysBase pSSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysBase.isCodeNameDirty();
            }
            case 1: {
                return pSSaaSSysBase.isCreateDateDirty();
            }
            case 2: {
                return pSSaaSSysBase.isCreateManDirty();
            }
            case 3: {
                return pSSaaSSysBase.isMemoDirty();
            }
            case 4: {
                return pSSaaSSysBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSSaaSSysBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSSaaSSysBase.isPSDevSlnSysIdDirty();
            }
            case 7: {
                return pSSaaSSysBase.isPSDevSlnSysNameDirty();
            }
            case 8: {
                return pSSaaSSysBase.isPSSaaSSysIdDirty();
            }
            case 9: {
                return pSSaaSSysBase.isPSSaaSSysNameDirty();
            }
            case 10: {
                return pSSaaSSysBase.isPSSFIdDirty();
            }
            case 11: {
                return pSSaaSSysBase.isPSSFNameDirty();
            }
            case 12: {
                return pSSaaSSysBase.isPubModeDirty();
            }
            case 13: {
                return pSSaaSSysBase.isSFPSSubSysIdDirty();
            }
            case 14: {
                return pSSaaSSysBase.isSFPSSubSysNameDirty();
            }
            case 15: {
                return pSSaaSSysBase.isSysTagDirty();
            }
            case 16: {
                return pSSaaSSysBase.isSysTag2Dirty();
            }
            case 17: {
                return pSSaaSSysBase.isSysTag3Dirty();
            }
            case 18: {
                return pSSaaSSysBase.isSysTag4Dirty();
            }
            case 19: {
                return pSSaaSSysBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSaaSSysBase.isUpdateManDirty();
            }
            case 21: {
                return pSSaaSSysBase.isUserCatDirty();
            }
            case 22: {
                return pSSaaSSysBase.isUserTagDirty();
            }
            case 23: {
                return pSSaaSSysBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSaaSSysBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSaaSSysBase.isUserTag4Dirty();
            }
            case 26: {
                return pSSaaSSysBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSaaSSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSaaSSysBase pSSaaSSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSaaSSysBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSSaaSSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysid", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSSaaSSysId()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSSaaSSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysname", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSSaaSSysName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getPubMode()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSFPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpssubsysid", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSFPSSubSysId()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSFPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfpssubsysname", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSFPSSubSysName()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSysTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSysTag()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSysTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag2", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSysTag2()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSysTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag3", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSysTag3()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getSysTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag4", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getSysTag4()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSaaSSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSaaSSysBase.getJSONValue((Object)pSSaaSSysBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSaaSSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSaaSSysBase pSSaaSSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSaaSSysBase.getCodeName() != null) {
            object = pSSaaSSysBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getCreateDate() != null) {
            object = pSSaaSSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysBase.getCreateMan() != null) {
            object = pSSaaSSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getMemo() != null) {
            object = pSSaaSSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSDevCenterId() != null) {
            object = pSSaaSSysBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSDevCenterName() != null) {
            object = pSSaaSSysBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSDevSlnSysId() != null) {
            object = pSSaaSSysBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSDevSlnSysName() != null) {
            object = pSSaaSSysBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSSaaSSysId() != null) {
            object = pSSaaSSysBase.getPSSaaSSysId();
            xmlNode.setAttribute(FIELD_PSSAASSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSSaaSSysName() != null) {
            object = pSSaaSSysBase.getPSSaaSSysName();
            xmlNode.setAttribute(FIELD_PSSAASSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSSFId() != null) {
            object = pSSaaSSysBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPSSFName() != null) {
            object = pSSaaSSysBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getPubMode() != null) {
            object = pSSaaSSysBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSaaSSysBase.getSFPSSubSysId() != null) {
            object = pSSaaSSysBase.getSFPSSubSysId();
            xmlNode.setAttribute(FIELD_SFPSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getSFPSSubSysName() != null) {
            object = pSSaaSSysBase.getSFPSSubSysName();
            xmlNode.setAttribute(FIELD_SFPSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getSysTag() != null) {
            object = pSSaaSSysBase.getSysTag();
            xmlNode.setAttribute(FIELD_SYSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getSysTag2() != null) {
            object = pSSaaSSysBase.getSysTag2();
            xmlNode.setAttribute(FIELD_SYSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getSysTag3() != null) {
            object = pSSaaSSysBase.getSysTag3();
            xmlNode.setAttribute(FIELD_SYSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getSysTag4() != null) {
            object = pSSaaSSysBase.getSysTag4();
            xmlNode.setAttribute(FIELD_SYSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUpdateDate() != null) {
            object = pSSaaSSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysBase.getUpdateMan() != null) {
            object = pSSaaSSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUserCat() != null) {
            object = pSSaaSSysBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUserTag() != null) {
            object = pSSaaSSysBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUserTag2() != null) {
            object = pSSaaSSysBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUserTag3() != null) {
            object = pSSaaSSysBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getUserTag4() != null) {
            object = pSSaaSSysBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysBase.getValidFlag() != null) {
            object = pSSaaSSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSaaSSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSaaSSysBase pSSaaSSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSaaSSysBase.isCodeNameDirty() && (bl || pSSaaSSysBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSaaSSysBase.getCodeName());
        }
        if (pSSaaSSysBase.isCreateDateDirty() && (bl || pSSaaSSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSaaSSysBase.getCreateDate());
        }
        if (pSSaaSSysBase.isCreateManDirty() && (bl || pSSaaSSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSaaSSysBase.getCreateMan());
        }
        if (pSSaaSSysBase.isMemoDirty() && (bl || pSSaaSSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSaaSSysBase.getMemo());
        }
        if (pSSaaSSysBase.isPSDevCenterIdDirty() && (bl || pSSaaSSysBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSaaSSysBase.getPSDevCenterId());
        }
        if (pSSaaSSysBase.isPSDevCenterNameDirty() && (bl || pSSaaSSysBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSaaSSysBase.getPSDevCenterName());
        }
        if (pSSaaSSysBase.isPSDevSlnSysIdDirty() && (bl || pSSaaSSysBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSaaSSysBase.getPSDevSlnSysId());
        }
        if (pSSaaSSysBase.isPSDevSlnSysNameDirty() && (bl || pSSaaSSysBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSSaaSSysBase.getPSDevSlnSysName());
        }
        if (pSSaaSSysBase.isPSSaaSSysIdDirty() && (bl || pSSaaSSysBase.getPSSaaSSysId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSID, (Object)pSSaaSSysBase.getPSSaaSSysId());
        }
        if (pSSaaSSysBase.isPSSaaSSysNameDirty() && (bl || pSSaaSSysBase.getPSSaaSSysName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSNAME, (Object)pSSaaSSysBase.getPSSaaSSysName());
        }
        if (pSSaaSSysBase.isPSSFIdDirty() && (bl || pSSaaSSysBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSaaSSysBase.getPSSFId());
        }
        if (pSSaaSSysBase.isPSSFNameDirty() && (bl || pSSaaSSysBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSaaSSysBase.getPSSFName());
        }
        if (pSSaaSSysBase.isPubModeDirty() && (bl || pSSaaSSysBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSSaaSSysBase.getPubMode());
        }
        if (pSSaaSSysBase.isSFPSSubSysIdDirty() && (bl || pSSaaSSysBase.getSFPSSubSysId() != null)) {
            iDataObject.set(FIELD_SFPSSUBSYSID, (Object)pSSaaSSysBase.getSFPSSubSysId());
        }
        if (pSSaaSSysBase.isSFPSSubSysNameDirty() && (bl || pSSaaSSysBase.getSFPSSubSysName() != null)) {
            iDataObject.set(FIELD_SFPSSUBSYSNAME, (Object)pSSaaSSysBase.getSFPSSubSysName());
        }
        if (pSSaaSSysBase.isSysTagDirty() && (bl || pSSaaSSysBase.getSysTag() != null)) {
            iDataObject.set(FIELD_SYSTAG, (Object)pSSaaSSysBase.getSysTag());
        }
        if (pSSaaSSysBase.isSysTag2Dirty() && (bl || pSSaaSSysBase.getSysTag2() != null)) {
            iDataObject.set(FIELD_SYSTAG2, (Object)pSSaaSSysBase.getSysTag2());
        }
        if (pSSaaSSysBase.isSysTag3Dirty() && (bl || pSSaaSSysBase.getSysTag3() != null)) {
            iDataObject.set(FIELD_SYSTAG3, (Object)pSSaaSSysBase.getSysTag3());
        }
        if (pSSaaSSysBase.isSysTag4Dirty() && (bl || pSSaaSSysBase.getSysTag4() != null)) {
            iDataObject.set(FIELD_SYSTAG4, (Object)pSSaaSSysBase.getSysTag4());
        }
        if (pSSaaSSysBase.isUpdateDateDirty() && (bl || pSSaaSSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSaaSSysBase.getUpdateDate());
        }
        if (pSSaaSSysBase.isUpdateManDirty() && (bl || pSSaaSSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSaaSSysBase.getUpdateMan());
        }
        if (pSSaaSSysBase.isUserCatDirty() && (bl || pSSaaSSysBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSaaSSysBase.getUserCat());
        }
        if (pSSaaSSysBase.isUserTagDirty() && (bl || pSSaaSSysBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSaaSSysBase.getUserTag());
        }
        if (pSSaaSSysBase.isUserTag2Dirty() && (bl || pSSaaSSysBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSaaSSysBase.getUserTag2());
        }
        if (pSSaaSSysBase.isUserTag3Dirty() && (bl || pSSaaSSysBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSaaSSysBase.getUserTag3());
        }
        if (pSSaaSSysBase.isUserTag4Dirty() && (bl || pSSaaSSysBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSaaSSysBase.getUserTag4());
        }
        if (pSSaaSSysBase.isValidFlagDirty() && (bl || pSSaaSSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSaaSSysBase.getValidFlag());
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
        return PSSaaSSysBase.remove(this, n);
    }

    private static boolean remove(PSSaaSSysBase pSSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSaaSSysBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSaaSSysBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSaaSSysBase.resetMemo();
                return true;
            }
            case 4: {
                pSSaaSSysBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSSaaSSysBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSSaaSSysBase.resetPSDevSlnSysId();
                return true;
            }
            case 7: {
                pSSaaSSysBase.resetPSDevSlnSysName();
                return true;
            }
            case 8: {
                pSSaaSSysBase.resetPSSaaSSysId();
                return true;
            }
            case 9: {
                pSSaaSSysBase.resetPSSaaSSysName();
                return true;
            }
            case 10: {
                pSSaaSSysBase.resetPSSFId();
                return true;
            }
            case 11: {
                pSSaaSSysBase.resetPSSFName();
                return true;
            }
            case 12: {
                pSSaaSSysBase.resetPubMode();
                return true;
            }
            case 13: {
                pSSaaSSysBase.resetSFPSSubSysId();
                return true;
            }
            case 14: {
                pSSaaSSysBase.resetSFPSSubSysName();
                return true;
            }
            case 15: {
                pSSaaSSysBase.resetSysTag();
                return true;
            }
            case 16: {
                pSSaaSSysBase.resetSysTag2();
                return true;
            }
            case 17: {
                pSSaaSSysBase.resetSysTag3();
                return true;
            }
            case 18: {
                pSSaaSSysBase.resetSysTag4();
                return true;
            }
            case 19: {
                pSSaaSSysBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSaaSSysBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSaaSSysBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSaaSSysBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSaaSSysBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSaaSSysBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSaaSSysBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSSaaSSysBase.resetValidFlag();
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
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
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
    public PSSubSys getSFPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFPSSubSys();
        }
        if (this.getSFPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objSFPSSubSysLock;
        synchronized (n) {
            if (this.sfpssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getSFPSSubSysId(), (Object)this.sfpssubsys.getPSSubSysId()) != 0L) {
                this.sfpssubsys = null;
            }
            if (this.sfpssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getSFPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet(pSSubSys);
                this.sfpssubsys = pSSubSys;
            }
            return this.sfpssubsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSaaSSysVer> getPSSaaSSysVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVers();
        }
        if (this.getPSSaaSSysId() == null) {
            return null;
        }
        PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSaaSSysVersLock;
        synchronized (n) {
            if (this.pssaassysvers == null) {
                this.pssaassysvers = pSSaaSSysVerService.selectByPSSaaSSys(this);
            }
            return this.pssaassysvers;
        }
    }

    private PSSaaSSysBase getProxyEntity() {
        return this.proxyPSSaaSSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSaaSSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSSaaSSysBase) {
            this.proxyPSSaaSSysBase = (PSSaaSSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 7);
        fieldIndexMap.put(FIELD_PSSAASSYSID, 8);
        fieldIndexMap.put(FIELD_PSSAASSYSNAME, 9);
        fieldIndexMap.put(FIELD_PSSFID, 10);
        fieldIndexMap.put(FIELD_PSSFNAME, 11);
        fieldIndexMap.put(FIELD_PUBMODE, 12);
        fieldIndexMap.put(FIELD_SFPSSUBSYSID, 13);
        fieldIndexMap.put(FIELD_SFPSSUBSYSNAME, 14);
        fieldIndexMap.put(FIELD_SYSTAG, 15);
        fieldIndexMap.put(FIELD_SYSTAG2, 16);
        fieldIndexMap.put(FIELD_SYSTAG3, 17);
        fieldIndexMap.put(FIELD_SYSTAG4, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

