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
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFCodeBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FULLCODENAME = "FULLCODENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String FIELD_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String FIELD_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String FIELD_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String FIELD_PSSYSSFCODEID = "PSSYSSFCODEID";
    public static final String FIELD_PSSYSSFCODENAME = "PSSYSSFCODENAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PUBCODE = "PUBCODE";
    public static final String FIELD_SYSOBJID = "SYSOBJID";
    public static final String FIELD_SYSOBJNAME = "SYSOBJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCODE = "USERCODE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODEPATH = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FULLCODENAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSSFCODEFOLDERID = 5;
    private static final int INDEX_PSSFCODEFOLDERNAME = 6;
    private static final int INDEX_PSSFCODETYPEID = 7;
    private static final int INDEX_PSSFCODETYPENAME = 8;
    private static final int INDEX_PSSYSSFCODEID = 9;
    private static final int INDEX_PSSYSSFCODENAME = 10;
    private static final int INDEX_PSSYSSFPUBID = 11;
    private static final int INDEX_PSSYSSFPUBNAME = 12;
    private static final int INDEX_PUBCODE = 13;
    private static final int INDEX_SYSOBJID = 14;
    private static final int INDEX_SYSOBJNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCODE = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFCodeBase proxyPSSysSFCodeBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fullcodenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfcodefolderidDirtyFlag = false;
    private boolean pssfcodefoldernameDirtyFlag = false;
    private boolean pssfcodetypeidDirtyFlag = false;
    private boolean pssfcodetypenameDirtyFlag = false;
    private boolean pssyssfcodeidDirtyFlag = false;
    private boolean pssyssfcodenameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pubcodeDirtyFlag = false;
    private boolean sysobjidDirtyFlag = false;
    private boolean sysobjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercodeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codepath")
    private String codepath;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fullcodename")
    private String fullcodename;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfcodefolderid")
    private String pssfcodefolderid;
    @Column(name="pssfcodefoldername")
    private String pssfcodefoldername;
    @Column(name="pssfcodetypeid")
    private String pssfcodetypeid;
    @Column(name="pssfcodetypename")
    private String pssfcodetypename;
    @Column(name="pssyssfcodeid")
    private String pssyssfcodeid;
    @Column(name="pssyssfcodename")
    private String pssyssfcodename;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pubcode")
    private String pubcode;
    @Column(name="sysobjid")
    private String sysobjid;
    @Column(name="sysobjname")
    private String sysobjname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercode")
    private String usercode;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFCodeFolderLock = new Integer(1);
    private PSSFCodeFolder pssfcodefolder = null;
    private Integer objPSSFCodeTypeLock = new Integer(1);
    private PSSFCodeType pssfcodetype = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;

    public void setCodePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codepath = string;
        this.codepathDirtyFlag = true;
    }

    public String getCodePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodePath();
        }
        return this.codepath;
    }

    public boolean isCodePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodePathDirty();
        }
        return this.codepathDirtyFlag;
    }

    public void resetCodePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodePath();
            return;
        }
        this.codepathDirtyFlag = false;
        this.codepath = null;
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

    public void setFullCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullcodename = string;
        this.fullcodenameDirtyFlag = true;
    }

    public String getFullCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullCodeName();
        }
        return this.fullcodename;
    }

    public boolean isFullCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullCodeNameDirty();
        }
        return this.fullcodenameDirtyFlag;
    }

    public void resetFullCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullCodeName();
            return;
        }
        this.fullcodenameDirtyFlag = false;
        this.fullcodename = null;
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

    public void setPSSFCodeFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodefolderid = string;
        this.pssfcodefolderidDirtyFlag = true;
    }

    public String getPSSFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolderId();
        }
        return this.pssfcodefolderid;
    }

    public boolean isPSSFCodeFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeFolderIdDirty();
        }
        return this.pssfcodefolderidDirtyFlag;
    }

    public void resetPSSFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeFolderId();
            return;
        }
        this.pssfcodefolderidDirtyFlag = false;
        this.pssfcodefolderid = null;
    }

    public void setPSSFCodeFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodefoldername = string;
        this.pssfcodefoldernameDirtyFlag = true;
    }

    public String getPSSFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolderName();
        }
        return this.pssfcodefoldername;
    }

    public boolean isPSSFCodeFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeFolderNameDirty();
        }
        return this.pssfcodefoldernameDirtyFlag;
    }

    public void resetPSSFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeFolderName();
            return;
        }
        this.pssfcodefoldernameDirtyFlag = false;
        this.pssfcodefoldername = null;
    }

    public void setPSSFCodeTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetypeid = string;
        this.pssfcodetypeidDirtyFlag = true;
    }

    public String getPSSFCodeTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTypeId();
        }
        return this.pssfcodetypeid;
    }

    public boolean isPSSFCodeTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTypeIdDirty();
        }
        return this.pssfcodetypeidDirtyFlag;
    }

    public void resetPSSFCodeTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTypeId();
            return;
        }
        this.pssfcodetypeidDirtyFlag = false;
        this.pssfcodetypeid = null;
    }

    public void setPSSFCodeTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetypename = string;
        this.pssfcodetypenameDirtyFlag = true;
    }

    public String getPSSFCodeTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTypeName();
        }
        return this.pssfcodetypename;
    }

    public boolean isPSSFCodeTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTypeNameDirty();
        }
        return this.pssfcodetypenameDirtyFlag;
    }

    public void resetPSSFCodeTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTypeName();
            return;
        }
        this.pssfcodetypenameDirtyFlag = false;
        this.pssfcodetypename = null;
    }

    public void setPSSysSFCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfcodeid = string;
        this.pssyssfcodeidDirtyFlag = true;
    }

    public String getPSSysSFCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFCodeId();
        }
        return this.pssyssfcodeid;
    }

    public boolean isPSSysSFCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFCodeIdDirty();
        }
        return this.pssyssfcodeidDirtyFlag;
    }

    public void resetPSSysSFCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFCodeId();
            return;
        }
        this.pssyssfcodeidDirtyFlag = false;
        this.pssyssfcodeid = null;
    }

    public void setPSSysSFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfcodename = string;
        this.pssyssfcodenameDirtyFlag = true;
    }

    public String getPSSysSFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFCodeName();
        }
        return this.pssyssfcodename;
    }

    public boolean isPSSysSFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFCodeNameDirty();
        }
        return this.pssyssfcodenameDirtyFlag;
    }

    public void resetPSSysSFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFCodeName();
            return;
        }
        this.pssyssfcodenameDirtyFlag = false;
        this.pssyssfcodename = null;
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

    public void setPubCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubcode = string;
        this.pubcodeDirtyFlag = true;
    }

    public String getPubCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubCode();
        }
        return this.pubcode;
    }

    public boolean isPubCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubCodeDirty();
        }
        return this.pubcodeDirtyFlag;
    }

    public void resetPubCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubCode();
            return;
        }
        this.pubcodeDirtyFlag = false;
        this.pubcode = null;
    }

    public void setSysObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysobjid = string;
        this.sysobjidDirtyFlag = true;
    }

    public String getSysObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysObjId();
        }
        return this.sysobjid;
    }

    public boolean isSysObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysObjIdDirty();
        }
        return this.sysobjidDirtyFlag;
    }

    public void resetSysObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysObjId();
            return;
        }
        this.sysobjidDirtyFlag = false;
        this.sysobjid = null;
    }

    public void setSysObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysobjname = string;
        this.sysobjnameDirtyFlag = true;
    }

    public String getSysObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysObjName();
        }
        return this.sysobjname;
    }

    public boolean isSysObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysObjNameDirty();
        }
        return this.sysobjnameDirtyFlag;
    }

    public void resetSysObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysObjName();
            return;
        }
        this.sysobjnameDirtyFlag = false;
        this.sysobjname = null;
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

    public void setUserCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercode = string;
        this.usercodeDirtyFlag = true;
    }

    public String getUserCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCode();
        }
        return this.usercode;
    }

    public boolean isUserCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCodeDirty();
        }
        return this.usercodeDirtyFlag;
    }

    public void resetUserCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCode();
            return;
        }
        this.usercodeDirtyFlag = false;
        this.usercode = null;
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
        PSSysSFCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFCodeBase pSSysSFCodeBase) {
        pSSysSFCodeBase.resetCodePath();
        pSSysSFCodeBase.resetCreateDate();
        pSSysSFCodeBase.resetCreateMan();
        pSSysSFCodeBase.resetFullCodeName();
        pSSysSFCodeBase.resetMemo();
        pSSysSFCodeBase.resetPSSFCodeFolderId();
        pSSysSFCodeBase.resetPSSFCodeFolderName();
        pSSysSFCodeBase.resetPSSFCodeTypeId();
        pSSysSFCodeBase.resetPSSFCodeTypeName();
        pSSysSFCodeBase.resetPSSysSFCodeId();
        pSSysSFCodeBase.resetPSSysSFCodeName();
        pSSysSFCodeBase.resetPSSysSFPubId();
        pSSysSFCodeBase.resetPSSysSFPubName();
        pSSysSFCodeBase.resetPubCode();
        pSSysSFCodeBase.resetSysObjId();
        pSSysSFCodeBase.resetSysObjName();
        pSSysSFCodeBase.resetUpdateDate();
        pSSysSFCodeBase.resetUpdateMan();
        pSSysSFCodeBase.resetUserCode();
        pSSysSFCodeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodePathDirty()) {
            hashMap.put(FIELD_CODEPATH, this.getCodePath());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFullCodeNameDirty()) {
            hashMap.put(FIELD_FULLCODENAME, this.getFullCodeName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFCodeFolderIdDirty()) {
            hashMap.put(FIELD_PSSFCODEFOLDERID, this.getPSSFCodeFolderId());
        }
        if (!bl || this.isPSSFCodeFolderNameDirty()) {
            hashMap.put(FIELD_PSSFCODEFOLDERNAME, this.getPSSFCodeFolderName());
        }
        if (!bl || this.isPSSFCodeTypeIdDirty()) {
            hashMap.put(FIELD_PSSFCODETYPEID, this.getPSSFCodeTypeId());
        }
        if (!bl || this.isPSSFCodeTypeNameDirty()) {
            hashMap.put(FIELD_PSSFCODETYPENAME, this.getPSSFCodeTypeName());
        }
        if (!bl || this.isPSSysSFCodeIdDirty()) {
            hashMap.put(FIELD_PSSYSSFCODEID, this.getPSSysSFCodeId());
        }
        if (!bl || this.isPSSysSFCodeNameDirty()) {
            hashMap.put(FIELD_PSSYSSFCODENAME, this.getPSSysSFCodeName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPubCodeDirty()) {
            hashMap.put(FIELD_PUBCODE, this.getPubCode());
        }
        if (!bl || this.isSysObjIdDirty()) {
            hashMap.put(FIELD_SYSOBJID, this.getSysObjId());
        }
        if (!bl || this.isSysObjNameDirty()) {
            hashMap.put(FIELD_SYSOBJNAME, this.getSysObjName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCodeDirty()) {
            hashMap.put(FIELD_USERCODE, this.getUserCode());
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
        return PSSysSFCodeBase.get(this, n);
    }

    private static Object get(PSSysSFCodeBase pSSysSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFCodeBase.getCodePath();
            }
            case 1: {
                return pSSysSFCodeBase.getCreateDate();
            }
            case 2: {
                return pSSysSFCodeBase.getCreateMan();
            }
            case 3: {
                return pSSysSFCodeBase.getFullCodeName();
            }
            case 4: {
                return pSSysSFCodeBase.getMemo();
            }
            case 5: {
                return pSSysSFCodeBase.getPSSFCodeFolderId();
            }
            case 6: {
                return pSSysSFCodeBase.getPSSFCodeFolderName();
            }
            case 7: {
                return pSSysSFCodeBase.getPSSFCodeTypeId();
            }
            case 8: {
                return pSSysSFCodeBase.getPSSFCodeTypeName();
            }
            case 9: {
                return pSSysSFCodeBase.getPSSysSFCodeId();
            }
            case 10: {
                return pSSysSFCodeBase.getPSSysSFCodeName();
            }
            case 11: {
                return pSSysSFCodeBase.getPSSysSFPubId();
            }
            case 12: {
                return pSSysSFCodeBase.getPSSysSFPubName();
            }
            case 13: {
                return pSSysSFCodeBase.getPubCode();
            }
            case 14: {
                return pSSysSFCodeBase.getSysObjId();
            }
            case 15: {
                return pSSysSFCodeBase.getSysObjName();
            }
            case 16: {
                return pSSysSFCodeBase.getUpdateDate();
            }
            case 17: {
                return pSSysSFCodeBase.getUpdateMan();
            }
            case 18: {
                return pSSysSFCodeBase.getUserCode();
            }
            case 19: {
                return pSSysSFCodeBase.getValidFlag();
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
        PSSysSFCodeBase.set(this, n, object);
    }

    private static void set(PSSysSFCodeBase pSSysSFCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFCodeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFCodeBase.setFullCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFCodeBase.setPSSFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFCodeBase.setPSSFCodeFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFCodeBase.setPSSFCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFCodeBase.setPSSFCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFCodeBase.setPSSysSFCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFCodeBase.setPSSysSFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFCodeBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFCodeBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSFCodeBase.setPubCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSFCodeBase.setSysObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSFCodeBase.setSysObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSFCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysSFCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSFCodeBase.setUserCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSFCodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSFCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFCodeBase pSSysSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFCodeBase.getCodePath() == null;
            }
            case 1: {
                return pSSysSFCodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSFCodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSFCodeBase.getFullCodeName() == null;
            }
            case 4: {
                return pSSysSFCodeBase.getMemo() == null;
            }
            case 5: {
                return pSSysSFCodeBase.getPSSFCodeFolderId() == null;
            }
            case 6: {
                return pSSysSFCodeBase.getPSSFCodeFolderName() == null;
            }
            case 7: {
                return pSSysSFCodeBase.getPSSFCodeTypeId() == null;
            }
            case 8: {
                return pSSysSFCodeBase.getPSSFCodeTypeName() == null;
            }
            case 9: {
                return pSSysSFCodeBase.getPSSysSFCodeId() == null;
            }
            case 10: {
                return pSSysSFCodeBase.getPSSysSFCodeName() == null;
            }
            case 11: {
                return pSSysSFCodeBase.getPSSysSFPubId() == null;
            }
            case 12: {
                return pSSysSFCodeBase.getPSSysSFPubName() == null;
            }
            case 13: {
                return pSSysSFCodeBase.getPubCode() == null;
            }
            case 14: {
                return pSSysSFCodeBase.getSysObjId() == null;
            }
            case 15: {
                return pSSysSFCodeBase.getSysObjName() == null;
            }
            case 16: {
                return pSSysSFCodeBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysSFCodeBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysSFCodeBase.getUserCode() == null;
            }
            case 19: {
                return pSSysSFCodeBase.getValidFlag() == null;
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
        return PSSysSFCodeBase.contains(this, n);
    }

    private static boolean contains(PSSysSFCodeBase pSSysSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFCodeBase.isCodePathDirty();
            }
            case 1: {
                return pSSysSFCodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSFCodeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSFCodeBase.isFullCodeNameDirty();
            }
            case 4: {
                return pSSysSFCodeBase.isMemoDirty();
            }
            case 5: {
                return pSSysSFCodeBase.isPSSFCodeFolderIdDirty();
            }
            case 6: {
                return pSSysSFCodeBase.isPSSFCodeFolderNameDirty();
            }
            case 7: {
                return pSSysSFCodeBase.isPSSFCodeTypeIdDirty();
            }
            case 8: {
                return pSSysSFCodeBase.isPSSFCodeTypeNameDirty();
            }
            case 9: {
                return pSSysSFCodeBase.isPSSysSFCodeIdDirty();
            }
            case 10: {
                return pSSysSFCodeBase.isPSSysSFCodeNameDirty();
            }
            case 11: {
                return pSSysSFCodeBase.isPSSysSFPubIdDirty();
            }
            case 12: {
                return pSSysSFCodeBase.isPSSysSFPubNameDirty();
            }
            case 13: {
                return pSSysSFCodeBase.isPubCodeDirty();
            }
            case 14: {
                return pSSysSFCodeBase.isSysObjIdDirty();
            }
            case 15: {
                return pSSysSFCodeBase.isSysObjNameDirty();
            }
            case 16: {
                return pSSysSFCodeBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysSFCodeBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysSFCodeBase.isUserCodeDirty();
            }
            case 19: {
                return pSSysSFCodeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFCodeBase pSSysSFCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFCodeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getFullCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcodename", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getFullCodeName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefolderid", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSFCodeFolderId()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefoldername", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSFCodeFolderName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypeid", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSFCodeTypeId()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypename", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSFCodeTypeName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfcodeid", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSysSFCodeId()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfcodename", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSysSFCodeName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcode", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getPubCode()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getSysObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysobjid", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getSysObjId()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getSysObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysobjname", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getSysObjName()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getUserCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercode", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getUserCode()), (boolean)false);
        }
        if (bl || pSSysSFCodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSFCodeBase.getJSONValue((Object)pSSysSFCodeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFCodeBase pSSysSFCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFCodeBase.getCodePath() != null) {
            object = pSSysSFCodeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getCreateDate() != null) {
            object = pSSysSFCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFCodeBase.getCreateMan() != null) {
            object = pSSysSFCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getFullCodeName() != null) {
            object = pSSysSFCodeBase.getFullCodeName();
            xmlNode.setAttribute(FIELD_FULLCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getMemo() != null) {
            object = pSSysSFCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeFolderId() != null) {
            object = pSSysSFCodeBase.getPSSFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeFolderName() != null) {
            object = pSSysSFCodeBase.getPSSFCodeFolderName();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeTypeId() != null) {
            object = pSSysSFCodeBase.getPSSFCodeTypeId();
            xmlNode.setAttribute(FIELD_PSSFCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSFCodeTypeName() != null) {
            object = pSSysSFCodeBase.getPSSFCodeTypeName();
            xmlNode.setAttribute(FIELD_PSSFCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFCodeId() != null) {
            object = pSSysSFCodeBase.getPSSysSFCodeId();
            xmlNode.setAttribute(FIELD_PSSYSSFCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFCodeName() != null) {
            object = pSSysSFCodeBase.getPSSysSFCodeName();
            xmlNode.setAttribute(FIELD_PSSYSSFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFPubId() != null) {
            object = pSSysSFCodeBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPSSysSFPubName() != null) {
            object = pSSysSFCodeBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getPubCode() != null) {
            object = pSSysSFCodeBase.getPubCode();
            xmlNode.setAttribute(FIELD_PUBCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getSysObjId() != null) {
            object = pSSysSFCodeBase.getSysObjId();
            xmlNode.setAttribute(FIELD_SYSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getSysObjName() != null) {
            object = pSSysSFCodeBase.getSysObjName();
            xmlNode.setAttribute(FIELD_SYSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getUpdateDate() != null) {
            object = pSSysSFCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFCodeBase.getUpdateMan() != null) {
            object = pSSysSFCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getUserCode() != null) {
            object = pSSysSFCodeBase.getUserCode();
            xmlNode.setAttribute(FIELD_USERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFCodeBase.getValidFlag() != null) {
            object = pSSysSFCodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFCodeBase pSSysSFCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFCodeBase.isCodePathDirty() && (bl || pSSysSFCodeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSSysSFCodeBase.getCodePath());
        }
        if (pSSysSFCodeBase.isCreateDateDirty() && (bl || pSSysSFCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFCodeBase.getCreateDate());
        }
        if (pSSysSFCodeBase.isCreateManDirty() && (bl || pSSysSFCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFCodeBase.getCreateMan());
        }
        if (pSSysSFCodeBase.isFullCodeNameDirty() && (bl || pSSysSFCodeBase.getFullCodeName() != null)) {
            iDataObject.set(FIELD_FULLCODENAME, (Object)pSSysSFCodeBase.getFullCodeName());
        }
        if (pSSysSFCodeBase.isMemoDirty() && (bl || pSSysSFCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFCodeBase.getMemo());
        }
        if (pSSysSFCodeBase.isPSSFCodeFolderIdDirty() && (bl || pSSysSFCodeBase.getPSSFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERID, (Object)pSSysSFCodeBase.getPSSFCodeFolderId());
        }
        if (pSSysSFCodeBase.isPSSFCodeFolderNameDirty() && (bl || pSSysSFCodeBase.getPSSFCodeFolderName() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERNAME, (Object)pSSysSFCodeBase.getPSSFCodeFolderName());
        }
        if (pSSysSFCodeBase.isPSSFCodeTypeIdDirty() && (bl || pSSysSFCodeBase.getPSSFCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPEID, (Object)pSSysSFCodeBase.getPSSFCodeTypeId());
        }
        if (pSSysSFCodeBase.isPSSFCodeTypeNameDirty() && (bl || pSSysSFCodeBase.getPSSFCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPENAME, (Object)pSSysSFCodeBase.getPSSFCodeTypeName());
        }
        if (pSSysSFCodeBase.isPSSysSFCodeIdDirty() && (bl || pSSysSFCodeBase.getPSSysSFCodeId() != null)) {
            iDataObject.set(FIELD_PSSYSSFCODEID, (Object)pSSysSFCodeBase.getPSSysSFCodeId());
        }
        if (pSSysSFCodeBase.isPSSysSFCodeNameDirty() && (bl || pSSysSFCodeBase.getPSSysSFCodeName() != null)) {
            iDataObject.set(FIELD_PSSYSSFCODENAME, (Object)pSSysSFCodeBase.getPSSysSFCodeName());
        }
        if (pSSysSFCodeBase.isPSSysSFPubIdDirty() && (bl || pSSysSFCodeBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysSFCodeBase.getPSSysSFPubId());
        }
        if (pSSysSFCodeBase.isPSSysSFPubNameDirty() && (bl || pSSysSFCodeBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysSFCodeBase.getPSSysSFPubName());
        }
        if (pSSysSFCodeBase.isPubCodeDirty() && (bl || pSSysSFCodeBase.getPubCode() != null)) {
            iDataObject.set(FIELD_PUBCODE, (Object)pSSysSFCodeBase.getPubCode());
        }
        if (pSSysSFCodeBase.isSysObjIdDirty() && (bl || pSSysSFCodeBase.getSysObjId() != null)) {
            iDataObject.set(FIELD_SYSOBJID, (Object)pSSysSFCodeBase.getSysObjId());
        }
        if (pSSysSFCodeBase.isSysObjNameDirty() && (bl || pSSysSFCodeBase.getSysObjName() != null)) {
            iDataObject.set(FIELD_SYSOBJNAME, (Object)pSSysSFCodeBase.getSysObjName());
        }
        if (pSSysSFCodeBase.isUpdateDateDirty() && (bl || pSSysSFCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFCodeBase.getUpdateDate());
        }
        if (pSSysSFCodeBase.isUpdateManDirty() && (bl || pSSysSFCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFCodeBase.getUpdateMan());
        }
        if (pSSysSFCodeBase.isUserCodeDirty() && (bl || pSSysSFCodeBase.getUserCode() != null)) {
            iDataObject.set(FIELD_USERCODE, (Object)pSSysSFCodeBase.getUserCode());
        }
        if (pSSysSFCodeBase.isValidFlagDirty() && (bl || pSSysSFCodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSFCodeBase.getValidFlag());
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
        return PSSysSFCodeBase.remove(this, n);
    }

    private static boolean remove(PSSysSFCodeBase pSSysSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFCodeBase.resetCodePath();
                return true;
            }
            case 1: {
                pSSysSFCodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSFCodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSFCodeBase.resetFullCodeName();
                return true;
            }
            case 4: {
                pSSysSFCodeBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysSFCodeBase.resetPSSFCodeFolderId();
                return true;
            }
            case 6: {
                pSSysSFCodeBase.resetPSSFCodeFolderName();
                return true;
            }
            case 7: {
                pSSysSFCodeBase.resetPSSFCodeTypeId();
                return true;
            }
            case 8: {
                pSSysSFCodeBase.resetPSSFCodeTypeName();
                return true;
            }
            case 9: {
                pSSysSFCodeBase.resetPSSysSFCodeId();
                return true;
            }
            case 10: {
                pSSysSFCodeBase.resetPSSysSFCodeName();
                return true;
            }
            case 11: {
                pSSysSFCodeBase.resetPSSysSFPubId();
                return true;
            }
            case 12: {
                pSSysSFCodeBase.resetPSSysSFPubName();
                return true;
            }
            case 13: {
                pSSysSFCodeBase.resetPubCode();
                return true;
            }
            case 14: {
                pSSysSFCodeBase.resetSysObjId();
                return true;
            }
            case 15: {
                pSSysSFCodeBase.resetSysObjName();
                return true;
            }
            case 16: {
                pSSysSFCodeBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysSFCodeBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysSFCodeBase.resetUserCode();
                return true;
            }
            case 19: {
                pSSysSFCodeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFCodeFolder getPSSFCodeFolder() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolder();
        }
        if (this.getPSSFCodeFolderId() == null) {
            return null;
        }
        Integer n = this.objPSSFCodeFolderLock;
        synchronized (n) {
            if (this.pssfcodefolder != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFCodeFolderId(), (Object)this.pssfcodefolder.getPSSFCodeFolderId()) != 0L) {
                this.pssfcodefolder = null;
            }
            if (this.pssfcodefolder == null) {
                PSSFCodeFolder pSSFCodeFolder = new PSSFCodeFolder();
                pSSFCodeFolder.setPSSFCodeFolderId(this.getPSSFCodeFolderId());
                PSSFCodeFolderService pSSFCodeFolderService = (PSSFCodeFolderService)ServiceGlobal.getService(PSSFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
                pSSFCodeFolderService.autoGet((IEntity)pSSFCodeFolder);
                this.pssfcodefolder = pSSFCodeFolder;
            }
            return this.pssfcodefolder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFCodeType getPSSFCodeType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeType();
        }
        if (this.getPSSFCodeTypeId() == null) {
            return null;
        }
        Integer n = this.objPSSFCodeTypeLock;
        synchronized (n) {
            if (this.pssfcodetype != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFCodeTypeId(), (Object)this.pssfcodetype.getPSSFCodeTypeId()) != 0L) {
                this.pssfcodetype = null;
            }
            if (this.pssfcodetype == null) {
                PSSFCodeType pSSFCodeType = new PSSFCodeType();
                pSSFCodeType.setPSSFCodeTypeId(this.getPSSFCodeTypeId());
                PSSFCodeTypeService pSSFCodeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSFCodeTypeService.autoGet((IEntity)pSSFCodeType);
                this.pssfcodetype = pSSFCodeType;
            }
            return this.pssfcodetype;
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

    private PSSysSFCodeBase getProxyEntity() {
        return this.proxyPSSysSFCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFCodeBase) {
            this.proxyPSSysSFCodeBase = (PSSysSFCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FULLCODENAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERID, 5);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERNAME, 6);
        fieldIndexMap.put(FIELD_PSSFCODETYPEID, 7);
        fieldIndexMap.put(FIELD_PSSFCODETYPENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSSFCODEID, 9);
        fieldIndexMap.put(FIELD_PSSYSSFCODENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 12);
        fieldIndexMap.put(FIELD_PUBCODE, 13);
        fieldIndexMap.put(FIELD_SYSOBJID, 14);
        fieldIndexMap.put(FIELD_SYSOBJNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCODE, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

