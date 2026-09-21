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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSysVerBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBVERSION = "DBVERSION";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELINSTVER = "MODELINSTVER";
    public static final String FIELD_PSDEPSYSID = "PSDEPSYSID";
    public static final String FIELD_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String FIELD_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String FIELD_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String FIELD_PSDEPSYSVERTYPE = "PSDEPSYSVERTYPE";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    public static final String FIELD_VERTAG3 = "VERTAG3";
    public static final String FIELD_VERTAG4 = "VERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBVERSION = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODELINSTVER = 5;
    private static final int INDEX_PSDEPSYSID = 6;
    private static final int INDEX_PSDEPSYSNAME = 7;
    private static final int INDEX_PSDEPSYSVERID = 8;
    private static final int INDEX_PSDEPSYSVERNAME = 9;
    private static final int INDEX_PSDEPSYSVERTYPE = 10;
    private static final int INDEX_PSDEVSLNSYSID = 11;
    private static final int INDEX_PSDEVSLNSYSNAME = 12;
    private static final int INDEX_PSDEVSLNSYSVERID = 13;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 14;
    private static final int INDEX_PSSAASSYSVERID = 15;
    private static final int INDEX_PSSAASSYSVERNAME = 16;
    private static final int INDEX_PSSYSMODELINSTID = 17;
    private static final int INDEX_PSSYSMODELINSTNAME = 18;
    private static final int INDEX_PSSYSTEMID = 19;
    private static final int INDEX_SYSVER = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final int INDEX_VERTAG = 29;
    private static final int INDEX_VERTAG2 = 30;
    private static final int INDEX_VERTAG3 = 31;
    private static final int INDEX_VERTAG4 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSysVerBase proxyPSDepSysVerBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbversionDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelinstverDirtyFlag = false;
    private boolean psdepsysidDirtyFlag = false;
    private boolean psdepsysnameDirtyFlag = false;
    private boolean psdepsysveridDirtyFlag = false;
    private boolean psdepsysvernameDirtyFlag = false;
    private boolean psdepsysvertypeDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    private boolean vertag3DirtyFlag = false;
    private boolean vertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbversion")
    private Integer dbversion;
    @Column(name="memo")
    private String memo;
    @Column(name="modelinstver")
    private Integer modelinstver;
    @Column(name="psdepsysid")
    private String psdepsysid;
    @Column(name="psdepsysname")
    private String psdepsysname;
    @Column(name="psdepsysverid")
    private String psdepsysverid;
    @Column(name="psdepsysvername")
    private String psdepsysvername;
    @Column(name="psdepsysvertype")
    private String psdepsysvertype;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="pssaassysverid")
    private String pssaassysverid;
    @Column(name="pssaassysvername")
    private String pssaassysvername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="sysver")
    private String sysver;
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
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    @Column(name="vertag3")
    private String vertag3;
    @Column(name="vertag4")
    private String vertag4;
    private Integer objPSDepSysLock = new Integer(1);
    private PSDepSys psdepsys = null;
    private Integer objPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer psdevslnsysver = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSaaSSysVerLock = new Integer(1);
    private PSSaaSSysVer pssaassysver = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
    private Integer objPSDepSysAPIsLock = new Integer(1);
    private ArrayList<PSDepSysAPI> psdepsysapis = null;
    private Integer objPSDepSysAppsLock = new Integer(1);
    private ArrayList<PSDepSysApp> psdepsysapps = null;

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

    public void setDBVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVersion(n);
            return;
        }
        this.dbversion = n;
        this.dbversionDirtyFlag = true;
    }

    public Integer getDBVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVersion();
        }
        return this.dbversion;
    }

    public boolean isDBVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVersionDirty();
        }
        return this.dbversionDirtyFlag;
    }

    public void resetDBVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVersion();
            return;
        }
        this.dbversionDirtyFlag = false;
        this.dbversion = null;
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

    public void setModelInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelInstVer(n);
            return;
        }
        this.modelinstver = n;
        this.modelinstverDirtyFlag = true;
    }

    public Integer getModelInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelInstVer();
        }
        return this.modelinstver;
    }

    public boolean isModelInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelInstVerDirty();
        }
        return this.modelinstverDirtyFlag;
    }

    public void resetModelInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelInstVer();
            return;
        }
        this.modelinstverDirtyFlag = false;
        this.modelinstver = null;
    }

    public void setPSDepSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysid = string;
        this.psdepsysidDirtyFlag = true;
    }

    public String getPSDepSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysId();
        }
        return this.psdepsysid;
    }

    public boolean isPSDepSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysIdDirty();
        }
        return this.psdepsysidDirtyFlag;
    }

    public void resetPSDepSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysId();
            return;
        }
        this.psdepsysidDirtyFlag = false;
        this.psdepsysid = null;
    }

    public void setPSDepSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysname = string;
        this.psdepsysnameDirtyFlag = true;
    }

    public String getPSDepSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysName();
        }
        return this.psdepsysname;
    }

    public boolean isPSDepSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysNameDirty();
        }
        return this.psdepsysnameDirtyFlag;
    }

    public void resetPSDepSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysName();
            return;
        }
        this.psdepsysnameDirtyFlag = false;
        this.psdepsysname = null;
    }

    public void setPSDepSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysverid = string;
        this.psdepsysveridDirtyFlag = true;
    }

    public String getPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerId();
        }
        return this.psdepsysverid;
    }

    public boolean isPSDepSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerIdDirty();
        }
        return this.psdepsysveridDirtyFlag;
    }

    public void resetPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerId();
            return;
        }
        this.psdepsysveridDirtyFlag = false;
        this.psdepsysverid = null;
    }

    public void setPSDepSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysvername = string;
        this.psdepsysvernameDirtyFlag = true;
    }

    public String getPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerName();
        }
        return this.psdepsysvername;
    }

    public boolean isPSDepSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerNameDirty();
        }
        return this.psdepsysvernameDirtyFlag;
    }

    public void resetPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerName();
            return;
        }
        this.psdepsysvernameDirtyFlag = false;
        this.psdepsysvername = null;
    }

    public void setPSDepSysVerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysvertype = string;
        this.psdepsysvertypeDirtyFlag = true;
    }

    public String getPSDepSysVerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerType();
        }
        return this.psdepsysvertype;
    }

    public boolean isPSDepSysVerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerTypeDirty();
        }
        return this.psdepsysvertypeDirtyFlag;
    }

    public void resetPSDepSysVerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerType();
            return;
        }
        this.psdepsysvertypeDirtyFlag = false;
        this.psdepsysvertype = null;
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

    public void setPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysverid = string;
        this.psdevslnsysveridDirtyFlag = true;
    }

    public String getPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerId();
        }
        return this.psdevslnsysverid;
    }

    public boolean isPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerIdDirty();
        }
        return this.psdevslnsysveridDirtyFlag;
    }

    public void resetPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerId();
            return;
        }
        this.psdevslnsysveridDirtyFlag = false;
        this.psdevslnsysverid = null;
    }

    public void setPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysvername = string;
        this.psdevslnsysvernameDirtyFlag = true;
    }

    public String getPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerName();
        }
        return this.psdevslnsysvername;
    }

    public boolean isPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerNameDirty();
        }
        return this.psdevslnsysvernameDirtyFlag;
    }

    public void resetPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerName();
            return;
        }
        this.psdevslnsysvernameDirtyFlag = false;
        this.psdevslnsysvername = null;
    }

    public void setPSSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysverid = string;
        this.pssaassysveridDirtyFlag = true;
    }

    public String getPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerId();
        }
        return this.pssaassysverid;
    }

    public boolean isPSSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerIdDirty();
        }
        return this.pssaassysveridDirtyFlag;
    }

    public void resetPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerId();
            return;
        }
        this.pssaassysveridDirtyFlag = false;
        this.pssaassysverid = null;
    }

    public void setPSSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysvername = string;
        this.pssaassysvernameDirtyFlag = true;
    }

    public String getPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerName();
        }
        return this.pssaassysvername;
    }

    public boolean isPSSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerNameDirty();
        }
        return this.pssaassysvernameDirtyFlag;
    }

    public void resetPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerName();
            return;
        }
        this.pssaassysvernameDirtyFlag = false;
        this.pssaassysvername = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setSysVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysver = string;
        this.sysverDirtyFlag = true;
    }

    public String getSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVer();
        }
        return this.sysver;
    }

    public boolean isSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerDirty();
        }
        return this.sysverDirtyFlag;
    }

    public void resetSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVer();
            return;
        }
        this.sysverDirtyFlag = false;
        this.sysver = null;
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

    public void setVerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag = string;
        this.vertagDirtyFlag = true;
    }

    public String getVerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag();
        }
        return this.vertag;
    }

    public boolean isVerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTagDirty();
        }
        return this.vertagDirtyFlag;
    }

    public void resetVerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag();
            return;
        }
        this.vertagDirtyFlag = false;
        this.vertag = null;
    }

    public void setVerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag2 = string;
        this.vertag2DirtyFlag = true;
    }

    public String getVerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag2();
        }
        return this.vertag2;
    }

    public boolean isVerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag2Dirty();
        }
        return this.vertag2DirtyFlag;
    }

    public void resetVerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag2();
            return;
        }
        this.vertag2DirtyFlag = false;
        this.vertag2 = null;
    }

    public void setVerTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag3 = string;
        this.vertag3DirtyFlag = true;
    }

    public String getVerTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag3();
        }
        return this.vertag3;
    }

    public boolean isVerTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag3Dirty();
        }
        return this.vertag3DirtyFlag;
    }

    public void resetVerTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag3();
            return;
        }
        this.vertag3DirtyFlag = false;
        this.vertag3 = null;
    }

    public void setVerTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag4 = string;
        this.vertag4DirtyFlag = true;
    }

    public String getVerTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag4();
        }
        return this.vertag4;
    }

    public boolean isVerTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag4Dirty();
        }
        return this.vertag4DirtyFlag;
    }

    public void resetVerTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag4();
            return;
        }
        this.vertag4DirtyFlag = false;
        this.vertag4 = null;
    }

    protected void onReset() {
        PSDepSysVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSysVerBase pSDepSysVerBase) {
        pSDepSysVerBase.resetCodeName();
        pSDepSysVerBase.resetCreateDate();
        pSDepSysVerBase.resetCreateMan();
        pSDepSysVerBase.resetDBVersion();
        pSDepSysVerBase.resetMemo();
        pSDepSysVerBase.resetModelInstVer();
        pSDepSysVerBase.resetPSDepSysId();
        pSDepSysVerBase.resetPSDepSysName();
        pSDepSysVerBase.resetPSDepSysVerId();
        pSDepSysVerBase.resetPSDepSysVerName();
        pSDepSysVerBase.resetPSDepSysVerType();
        pSDepSysVerBase.resetPSDevSlnSysId();
        pSDepSysVerBase.resetPSDevSlnSysName();
        pSDepSysVerBase.resetPSDevSlnSysVerId();
        pSDepSysVerBase.resetPSDevSlnSysVerName();
        pSDepSysVerBase.resetPSSaaSSysVerId();
        pSDepSysVerBase.resetPSSaaSSysVerName();
        pSDepSysVerBase.resetPSSysModelInstId();
        pSDepSysVerBase.resetPSSysModelInstName();
        pSDepSysVerBase.resetPSSystemId();
        pSDepSysVerBase.resetSysVer();
        pSDepSysVerBase.resetUpdateDate();
        pSDepSysVerBase.resetUpdateMan();
        pSDepSysVerBase.resetUserCat();
        pSDepSysVerBase.resetUserTag();
        pSDepSysVerBase.resetUserTag2();
        pSDepSysVerBase.resetUserTag3();
        pSDepSysVerBase.resetUserTag4();
        pSDepSysVerBase.resetValidFlag();
        pSDepSysVerBase.resetVerTag();
        pSDepSysVerBase.resetVerTag2();
        pSDepSysVerBase.resetVerTag3();
        pSDepSysVerBase.resetVerTag4();
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
        if (!bl || this.isDBVersionDirty()) {
            hashMap.put(FIELD_DBVERSION, this.getDBVersion());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelInstVerDirty()) {
            hashMap.put(FIELD_MODELINSTVER, this.getModelInstVer());
        }
        if (!bl || this.isPSDepSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSID, this.getPSDepSysId());
        }
        if (!bl || this.isPSDepSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSNAME, this.getPSDepSysName());
        }
        if (!bl || this.isPSDepSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERID, this.getPSDepSysVerId());
        }
        if (!bl || this.isPSDepSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERNAME, this.getPSDepSysVerName());
        }
        if (!bl || this.isPSDepSysVerTypeDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERTYPE, this.getPSDepSysVerType());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERID, this.getPSDevSlnSysVerId());
        }
        if (!bl || this.isPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERNAME, this.getPSDevSlnSysVerName());
        }
        if (!bl || this.isPSSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERID, this.getPSSaaSSysVerId());
        }
        if (!bl || this.isPSSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERNAME, this.getPSSaaSSysVerName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
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
        if (!bl || this.isVerTagDirty()) {
            hashMap.put(FIELD_VERTAG, this.getVerTag());
        }
        if (!bl || this.isVerTag2Dirty()) {
            hashMap.put(FIELD_VERTAG2, this.getVerTag2());
        }
        if (!bl || this.isVerTag3Dirty()) {
            hashMap.put(FIELD_VERTAG3, this.getVerTag3());
        }
        if (!bl || this.isVerTag4Dirty()) {
            hashMap.put(FIELD_VERTAG4, this.getVerTag4());
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
        return PSDepSysVerBase.get(this, n);
    }

    private static Object get(PSDepSysVerBase pSDepSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysVerBase.getCodeName();
            }
            case 1: {
                return pSDepSysVerBase.getCreateDate();
            }
            case 2: {
                return pSDepSysVerBase.getCreateMan();
            }
            case 3: {
                return pSDepSysVerBase.getDBVersion();
            }
            case 4: {
                return pSDepSysVerBase.getMemo();
            }
            case 5: {
                return pSDepSysVerBase.getModelInstVer();
            }
            case 6: {
                return pSDepSysVerBase.getPSDepSysId();
            }
            case 7: {
                return pSDepSysVerBase.getPSDepSysName();
            }
            case 8: {
                return pSDepSysVerBase.getPSDepSysVerId();
            }
            case 9: {
                return pSDepSysVerBase.getPSDepSysVerName();
            }
            case 10: {
                return pSDepSysVerBase.getPSDepSysVerType();
            }
            case 11: {
                return pSDepSysVerBase.getPSDevSlnSysId();
            }
            case 12: {
                return pSDepSysVerBase.getPSDevSlnSysName();
            }
            case 13: {
                return pSDepSysVerBase.getPSDevSlnSysVerId();
            }
            case 14: {
                return pSDepSysVerBase.getPSDevSlnSysVerName();
            }
            case 15: {
                return pSDepSysVerBase.getPSSaaSSysVerId();
            }
            case 16: {
                return pSDepSysVerBase.getPSSaaSSysVerName();
            }
            case 17: {
                return pSDepSysVerBase.getPSSysModelInstId();
            }
            case 18: {
                return pSDepSysVerBase.getPSSysModelInstName();
            }
            case 19: {
                return pSDepSysVerBase.getPSSystemId();
            }
            case 20: {
                return pSDepSysVerBase.getSysVer();
            }
            case 21: {
                return pSDepSysVerBase.getUpdateDate();
            }
            case 22: {
                return pSDepSysVerBase.getUpdateMan();
            }
            case 23: {
                return pSDepSysVerBase.getUserCat();
            }
            case 24: {
                return pSDepSysVerBase.getUserTag();
            }
            case 25: {
                return pSDepSysVerBase.getUserTag2();
            }
            case 26: {
                return pSDepSysVerBase.getUserTag3();
            }
            case 27: {
                return pSDepSysVerBase.getUserTag4();
            }
            case 28: {
                return pSDepSysVerBase.getValidFlag();
            }
            case 29: {
                return pSDepSysVerBase.getVerTag();
            }
            case 30: {
                return pSDepSysVerBase.getVerTag2();
            }
            case 31: {
                return pSDepSysVerBase.getVerTag3();
            }
            case 32: {
                return pSDepSysVerBase.getVerTag4();
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
        PSDepSysVerBase.set(this, n, object);
    }

    private static void set(PSDepSysVerBase pSDepSysVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysVerBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSysVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSysVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSysVerBase.setDBVersion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDepSysVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSysVerBase.setModelInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSysVerBase.setPSDepSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSysVerBase.setPSDepSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSysVerBase.setPSDepSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSysVerBase.setPSDepSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSysVerBase.setPSDepSysVerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSysVerBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSysVerBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSysVerBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSysVerBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSysVerBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSysVerBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSysVerBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSysVerBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSysVerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDepSysVerBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDepSysVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDepSysVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDepSysVerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDepSysVerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDepSysVerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDepSysVerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDepSysVerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDepSysVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDepSysVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDepSysVerBase.setVerTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDepSysVerBase.setVerTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDepSysVerBase.setVerTag4(DataObject.getStringValue((Object)object));
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
        return PSDepSysVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSysVerBase pSDepSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysVerBase.getCodeName() == null;
            }
            case 1: {
                return pSDepSysVerBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSysVerBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSysVerBase.getDBVersion() == null;
            }
            case 4: {
                return pSDepSysVerBase.getMemo() == null;
            }
            case 5: {
                return pSDepSysVerBase.getModelInstVer() == null;
            }
            case 6: {
                return pSDepSysVerBase.getPSDepSysId() == null;
            }
            case 7: {
                return pSDepSysVerBase.getPSDepSysName() == null;
            }
            case 8: {
                return pSDepSysVerBase.getPSDepSysVerId() == null;
            }
            case 9: {
                return pSDepSysVerBase.getPSDepSysVerName() == null;
            }
            case 10: {
                return pSDepSysVerBase.getPSDepSysVerType() == null;
            }
            case 11: {
                return pSDepSysVerBase.getPSDevSlnSysId() == null;
            }
            case 12: {
                return pSDepSysVerBase.getPSDevSlnSysName() == null;
            }
            case 13: {
                return pSDepSysVerBase.getPSDevSlnSysVerId() == null;
            }
            case 14: {
                return pSDepSysVerBase.getPSDevSlnSysVerName() == null;
            }
            case 15: {
                return pSDepSysVerBase.getPSSaaSSysVerId() == null;
            }
            case 16: {
                return pSDepSysVerBase.getPSSaaSSysVerName() == null;
            }
            case 17: {
                return pSDepSysVerBase.getPSSysModelInstId() == null;
            }
            case 18: {
                return pSDepSysVerBase.getPSSysModelInstName() == null;
            }
            case 19: {
                return pSDepSysVerBase.getPSSystemId() == null;
            }
            case 20: {
                return pSDepSysVerBase.getSysVer() == null;
            }
            case 21: {
                return pSDepSysVerBase.getUpdateDate() == null;
            }
            case 22: {
                return pSDepSysVerBase.getUpdateMan() == null;
            }
            case 23: {
                return pSDepSysVerBase.getUserCat() == null;
            }
            case 24: {
                return pSDepSysVerBase.getUserTag() == null;
            }
            case 25: {
                return pSDepSysVerBase.getUserTag2() == null;
            }
            case 26: {
                return pSDepSysVerBase.getUserTag3() == null;
            }
            case 27: {
                return pSDepSysVerBase.getUserTag4() == null;
            }
            case 28: {
                return pSDepSysVerBase.getValidFlag() == null;
            }
            case 29: {
                return pSDepSysVerBase.getVerTag() == null;
            }
            case 30: {
                return pSDepSysVerBase.getVerTag2() == null;
            }
            case 31: {
                return pSDepSysVerBase.getVerTag3() == null;
            }
            case 32: {
                return pSDepSysVerBase.getVerTag4() == null;
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
        return PSDepSysVerBase.contains(this, n);
    }

    private static boolean contains(PSDepSysVerBase pSDepSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysVerBase.isCodeNameDirty();
            }
            case 1: {
                return pSDepSysVerBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSysVerBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSysVerBase.isDBVersionDirty();
            }
            case 4: {
                return pSDepSysVerBase.isMemoDirty();
            }
            case 5: {
                return pSDepSysVerBase.isModelInstVerDirty();
            }
            case 6: {
                return pSDepSysVerBase.isPSDepSysIdDirty();
            }
            case 7: {
                return pSDepSysVerBase.isPSDepSysNameDirty();
            }
            case 8: {
                return pSDepSysVerBase.isPSDepSysVerIdDirty();
            }
            case 9: {
                return pSDepSysVerBase.isPSDepSysVerNameDirty();
            }
            case 10: {
                return pSDepSysVerBase.isPSDepSysVerTypeDirty();
            }
            case 11: {
                return pSDepSysVerBase.isPSDevSlnSysIdDirty();
            }
            case 12: {
                return pSDepSysVerBase.isPSDevSlnSysNameDirty();
            }
            case 13: {
                return pSDepSysVerBase.isPSDevSlnSysVerIdDirty();
            }
            case 14: {
                return pSDepSysVerBase.isPSDevSlnSysVerNameDirty();
            }
            case 15: {
                return pSDepSysVerBase.isPSSaaSSysVerIdDirty();
            }
            case 16: {
                return pSDepSysVerBase.isPSSaaSSysVerNameDirty();
            }
            case 17: {
                return pSDepSysVerBase.isPSSysModelInstIdDirty();
            }
            case 18: {
                return pSDepSysVerBase.isPSSysModelInstNameDirty();
            }
            case 19: {
                return pSDepSysVerBase.isPSSystemIdDirty();
            }
            case 20: {
                return pSDepSysVerBase.isSysVerDirty();
            }
            case 21: {
                return pSDepSysVerBase.isUpdateDateDirty();
            }
            case 22: {
                return pSDepSysVerBase.isUpdateManDirty();
            }
            case 23: {
                return pSDepSysVerBase.isUserCatDirty();
            }
            case 24: {
                return pSDepSysVerBase.isUserTagDirty();
            }
            case 25: {
                return pSDepSysVerBase.isUserTag2Dirty();
            }
            case 26: {
                return pSDepSysVerBase.isUserTag3Dirty();
            }
            case 27: {
                return pSDepSysVerBase.isUserTag4Dirty();
            }
            case 28: {
                return pSDepSysVerBase.isValidFlagDirty();
            }
            case 29: {
                return pSDepSysVerBase.isVerTagDirty();
            }
            case 30: {
                return pSDepSysVerBase.isVerTag2Dirty();
            }
            case 31: {
                return pSDepSysVerBase.isVerTag3Dirty();
            }
            case 32: {
                return pSDepSysVerBase.isVerTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSysVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSysVerBase pSDepSysVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSysVerBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getDBVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbversion", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getDBVersion()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getModelInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelinstver", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getModelInstVer()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDepSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDepSysId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDepSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysname", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDepSysName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysverid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDepSysVerId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysvername", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDepSysVerName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysvertype", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDepSysVerType()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getSysVer()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getVerTag2()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getVerTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag3", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getVerTag3()), (boolean)false);
        }
        if (bl || pSDepSysVerBase.getVerTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag4", (Object)PSDepSysVerBase.getJSONValue((Object)pSDepSysVerBase.getVerTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSysVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSysVerBase pSDepSysVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSysVerBase.getCodeName() != null) {
            object = pSDepSysVerBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getCreateDate() != null) {
            object = pSDepSysVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysVerBase.getCreateMan() != null) {
            object = pSDepSysVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getDBVersion() != null) {
            object = pSDepSysVerBase.getDBVersion();
            xmlNode.setAttribute(FIELD_DBVERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSysVerBase.getMemo() != null) {
            object = pSDepSysVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getModelInstVer() != null) {
            object = pSDepSysVerBase.getModelInstVer();
            xmlNode.setAttribute(FIELD_MODELINSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSysVerBase.getPSDepSysId() != null) {
            object = pSDepSysVerBase.getPSDepSysId();
            xmlNode.setAttribute(FIELD_PSDEPSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDepSysName() != null) {
            object = pSDepSysVerBase.getPSDepSysName();
            xmlNode.setAttribute(FIELD_PSDEPSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerId() != null) {
            object = pSDepSysVerBase.getPSDepSysVerId();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerName() != null) {
            object = pSDepSysVerBase.getPSDepSysVerName();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDepSysVerType() != null) {
            object = pSDepSysVerBase.getPSDepSysVerType();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysId() != null) {
            object = pSDepSysVerBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysName() != null) {
            object = pSDepSysVerBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysVerId() != null) {
            object = pSDepSysVerBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSDevSlnSysVerName() != null) {
            object = pSDepSysVerBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSSaaSSysVerId() != null) {
            object = pSDepSysVerBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSSaaSSysVerName() != null) {
            object = pSDepSysVerBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSSysModelInstId() != null) {
            object = pSDepSysVerBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSSysModelInstName() != null) {
            object = pSDepSysVerBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getPSSystemId() != null) {
            object = pSDepSysVerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getSysVer() != null) {
            object = pSDepSysVerBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUpdateDate() != null) {
            object = pSDepSysVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysVerBase.getUpdateMan() != null) {
            object = pSDepSysVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUserCat() != null) {
            object = pSDepSysVerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUserTag() != null) {
            object = pSDepSysVerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUserTag2() != null) {
            object = pSDepSysVerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUserTag3() != null) {
            object = pSDepSysVerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getUserTag4() != null) {
            object = pSDepSysVerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getValidFlag() != null) {
            object = pSDepSysVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSysVerBase.getVerTag() != null) {
            object = pSDepSysVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getVerTag2() != null) {
            object = pSDepSysVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getVerTag3() != null) {
            object = pSDepSysVerBase.getVerTag3();
            xmlNode.setAttribute(FIELD_VERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysVerBase.getVerTag4() != null) {
            object = pSDepSysVerBase.getVerTag4();
            xmlNode.setAttribute(FIELD_VERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSysVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSysVerBase pSDepSysVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSysVerBase.isCodeNameDirty() && (bl || pSDepSysVerBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDepSysVerBase.getCodeName());
        }
        if (pSDepSysVerBase.isCreateDateDirty() && (bl || pSDepSysVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSysVerBase.getCreateDate());
        }
        if (pSDepSysVerBase.isCreateManDirty() && (bl || pSDepSysVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSysVerBase.getCreateMan());
        }
        if (pSDepSysVerBase.isDBVersionDirty() && (bl || pSDepSysVerBase.getDBVersion() != null)) {
            iDataObject.set(FIELD_DBVERSION, (Object)pSDepSysVerBase.getDBVersion());
        }
        if (pSDepSysVerBase.isMemoDirty() && (bl || pSDepSysVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSysVerBase.getMemo());
        }
        if (pSDepSysVerBase.isModelInstVerDirty() && (bl || pSDepSysVerBase.getModelInstVer() != null)) {
            iDataObject.set(FIELD_MODELINSTVER, (Object)pSDepSysVerBase.getModelInstVer());
        }
        if (pSDepSysVerBase.isPSDepSysIdDirty() && (bl || pSDepSysVerBase.getPSDepSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSID, (Object)pSDepSysVerBase.getPSDepSysId());
        }
        if (pSDepSysVerBase.isPSDepSysNameDirty() && (bl || pSDepSysVerBase.getPSDepSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSNAME, (Object)pSDepSysVerBase.getPSDepSysName());
        }
        if (pSDepSysVerBase.isPSDepSysVerIdDirty() && (bl || pSDepSysVerBase.getPSDepSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERID, (Object)pSDepSysVerBase.getPSDepSysVerId());
        }
        if (pSDepSysVerBase.isPSDepSysVerNameDirty() && (bl || pSDepSysVerBase.getPSDepSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERNAME, (Object)pSDepSysVerBase.getPSDepSysVerName());
        }
        if (pSDepSysVerBase.isPSDepSysVerTypeDirty() && (bl || pSDepSysVerBase.getPSDepSysVerType() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERTYPE, (Object)pSDepSysVerBase.getPSDepSysVerType());
        }
        if (pSDepSysVerBase.isPSDevSlnSysIdDirty() && (bl || pSDepSysVerBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDepSysVerBase.getPSDevSlnSysId());
        }
        if (pSDepSysVerBase.isPSDevSlnSysNameDirty() && (bl || pSDepSysVerBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDepSysVerBase.getPSDevSlnSysName());
        }
        if (pSDepSysVerBase.isPSDevSlnSysVerIdDirty() && (bl || pSDepSysVerBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSDepSysVerBase.getPSDevSlnSysVerId());
        }
        if (pSDepSysVerBase.isPSDevSlnSysVerNameDirty() && (bl || pSDepSysVerBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSDepSysVerBase.getPSDevSlnSysVerName());
        }
        if (pSDepSysVerBase.isPSSaaSSysVerIdDirty() && (bl || pSDepSysVerBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSDepSysVerBase.getPSSaaSSysVerId());
        }
        if (pSDepSysVerBase.isPSSaaSSysVerNameDirty() && (bl || pSDepSysVerBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSDepSysVerBase.getPSSaaSSysVerName());
        }
        if (pSDepSysVerBase.isPSSysModelInstIdDirty() && (bl || pSDepSysVerBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDepSysVerBase.getPSSysModelInstId());
        }
        if (pSDepSysVerBase.isPSSysModelInstNameDirty() && (bl || pSDepSysVerBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDepSysVerBase.getPSSysModelInstName());
        }
        if (pSDepSysVerBase.isPSSystemIdDirty() && (bl || pSDepSysVerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDepSysVerBase.getPSSystemId());
        }
        if (pSDepSysVerBase.isSysVerDirty() && (bl || pSDepSysVerBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSDepSysVerBase.getSysVer());
        }
        if (pSDepSysVerBase.isUpdateDateDirty() && (bl || pSDepSysVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSysVerBase.getUpdateDate());
        }
        if (pSDepSysVerBase.isUpdateManDirty() && (bl || pSDepSysVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSysVerBase.getUpdateMan());
        }
        if (pSDepSysVerBase.isUserCatDirty() && (bl || pSDepSysVerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDepSysVerBase.getUserCat());
        }
        if (pSDepSysVerBase.isUserTagDirty() && (bl || pSDepSysVerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSysVerBase.getUserTag());
        }
        if (pSDepSysVerBase.isUserTag2Dirty() && (bl || pSDepSysVerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSysVerBase.getUserTag2());
        }
        if (pSDepSysVerBase.isUserTag3Dirty() && (bl || pSDepSysVerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDepSysVerBase.getUserTag3());
        }
        if (pSDepSysVerBase.isUserTag4Dirty() && (bl || pSDepSysVerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDepSysVerBase.getUserTag4());
        }
        if (pSDepSysVerBase.isValidFlagDirty() && (bl || pSDepSysVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSysVerBase.getValidFlag());
        }
        if (pSDepSysVerBase.isVerTagDirty() && (bl || pSDepSysVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSDepSysVerBase.getVerTag());
        }
        if (pSDepSysVerBase.isVerTag2Dirty() && (bl || pSDepSysVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSDepSysVerBase.getVerTag2());
        }
        if (pSDepSysVerBase.isVerTag3Dirty() && (bl || pSDepSysVerBase.getVerTag3() != null)) {
            iDataObject.set(FIELD_VERTAG3, (Object)pSDepSysVerBase.getVerTag3());
        }
        if (pSDepSysVerBase.isVerTag4Dirty() && (bl || pSDepSysVerBase.getVerTag4() != null)) {
            iDataObject.set(FIELD_VERTAG4, (Object)pSDepSysVerBase.getVerTag4());
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
        return PSDepSysVerBase.remove(this, n);
    }

    private static boolean remove(PSDepSysVerBase pSDepSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysVerBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDepSysVerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSysVerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSysVerBase.resetDBVersion();
                return true;
            }
            case 4: {
                pSDepSysVerBase.resetMemo();
                return true;
            }
            case 5: {
                pSDepSysVerBase.resetModelInstVer();
                return true;
            }
            case 6: {
                pSDepSysVerBase.resetPSDepSysId();
                return true;
            }
            case 7: {
                pSDepSysVerBase.resetPSDepSysName();
                return true;
            }
            case 8: {
                pSDepSysVerBase.resetPSDepSysVerId();
                return true;
            }
            case 9: {
                pSDepSysVerBase.resetPSDepSysVerName();
                return true;
            }
            case 10: {
                pSDepSysVerBase.resetPSDepSysVerType();
                return true;
            }
            case 11: {
                pSDepSysVerBase.resetPSDevSlnSysId();
                return true;
            }
            case 12: {
                pSDepSysVerBase.resetPSDevSlnSysName();
                return true;
            }
            case 13: {
                pSDepSysVerBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 14: {
                pSDepSysVerBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 15: {
                pSDepSysVerBase.resetPSSaaSSysVerId();
                return true;
            }
            case 16: {
                pSDepSysVerBase.resetPSSaaSSysVerName();
                return true;
            }
            case 17: {
                pSDepSysVerBase.resetPSSysModelInstId();
                return true;
            }
            case 18: {
                pSDepSysVerBase.resetPSSysModelInstName();
                return true;
            }
            case 19: {
                pSDepSysVerBase.resetPSSystemId();
                return true;
            }
            case 20: {
                pSDepSysVerBase.resetSysVer();
                return true;
            }
            case 21: {
                pSDepSysVerBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSDepSysVerBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSDepSysVerBase.resetUserCat();
                return true;
            }
            case 24: {
                pSDepSysVerBase.resetUserTag();
                return true;
            }
            case 25: {
                pSDepSysVerBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSDepSysVerBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSDepSysVerBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSDepSysVerBase.resetValidFlag();
                return true;
            }
            case 29: {
                pSDepSysVerBase.resetVerTag();
                return true;
            }
            case 30: {
                pSDepSysVerBase.resetVerTag2();
                return true;
            }
            case 31: {
                pSDepSysVerBase.resetVerTag3();
                return true;
            }
            case 32: {
                pSDepSysVerBase.resetVerTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSys getPSDepSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSys();
        }
        if (this.getPSDepSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysLock;
        synchronized (n) {
            if (this.psdepsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysId(), (Object)this.psdepsys.getPSDepSysId()) != 0L) {
                this.psdepsys = null;
            }
            if (this.psdepsys == null) {
                PSDepSys pSDepSys = new PSDepSys();
                pSDepSys.setPSDepSysId(this.getPSDepSysId());
                PSDepSysService pSDepSysService = (PSDepSysService)ServiceGlobal.getService(PSDepSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysService.autoGet((IEntity)pSDepSys);
                this.psdepsys = pSDepSys;
            }
            return this.psdepsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVer();
        }
        if (this.getPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.psdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysVerId(), (Object)this.psdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.psdevslnsysver = null;
            }
            if (this.psdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet((IEntity)pSDevSlnSysVer);
                this.psdevslnsysver = pSDevSlnSysVer;
            }
            return this.psdevslnsysver;
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
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysVer getPSSaaSSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVer();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysVerLock;
        synchronized (n) {
            if (this.pssaassysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysVerId(), (Object)this.pssaassysver.getPSSaaSSysVerId()) != 0L) {
                this.pssaassysver = null;
            }
            if (this.pssaassysver == null) {
                PSSaaSSysVer pSSaaSSysVer = new PSSaaSSysVer();
                pSSaaSSysVer.setPSSaaSSysVerId(this.getPSSaaSSysVerId());
                PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysVerService.autoGet((IEntity)pSSaaSSysVer);
                this.pssaassysver = pSSaaSSysVer;
            }
            return this.pssaassysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSysAPI> getPSDepSysAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIs();
        }
        if (this.getPSDepSysVerId() == null) {
            return null;
        }
        PSDepSysAPIService pSDepSysAPIService = (PSDepSysAPIService)ServiceGlobal.getService(PSDepSysAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSysAPIsLock;
        synchronized (n) {
            if (this.psdepsysapis == null) {
                this.psdepsysapis = pSDepSysAPIService.selectByPSDepSysVer(this);
            }
            return this.psdepsysapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSysApp> getPSDepSysApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysApps();
        }
        if (this.getPSDepSysVerId() == null) {
            return null;
        }
        PSDepSysAppService pSDepSysAppService = (PSDepSysAppService)ServiceGlobal.getService(PSDepSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSysAppsLock;
        synchronized (n) {
            if (this.psdepsysapps == null) {
                this.psdepsysapps = pSDepSysAppService.selectByPSDepSysVer(this);
            }
            return this.psdepsysapps;
        }
    }

    private PSDepSysVerBase getProxyEntity() {
        return this.proxyPSDepSysVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSysVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSysVerBase) {
            this.proxyPSDepSysVerBase = (PSDepSysVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBVERSION, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODELINSTVER, 5);
        fieldIndexMap.put(FIELD_PSDEPSYSID, 6);
        fieldIndexMap.put(FIELD_PSDEPSYSNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSYSVERID, 8);
        fieldIndexMap.put(FIELD_PSDEPSYSVERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSYSVERTYPE, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 14);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 15);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 17);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 19);
        fieldIndexMap.put(FIELD_SYSVER, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
        fieldIndexMap.put(FIELD_VERTAG, 29);
        fieldIndexMap.put(FIELD_VERTAG2, 30);
        fieldIndexMap.put(FIELD_VERTAG3, 31);
        fieldIndexMap.put(FIELD_VERTAG4, 32);
    }
}

