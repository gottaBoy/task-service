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
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSFCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelSFCodeBase.class);
    public static final String FIELD_CODEMODE = "CODEMODE";
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CODEPKGNAME = "CODEPKGNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMFLAG = "CUSTOMFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJFOLDER = "PRJFOLDER";
    public static final String FIELD_PRJNAME = "PRJNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELSFCODEID = "PSMODELSFCODEID";
    public static final String FIELD_PSMODELSFCODENAME = "PSMODELSFCODENAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String FIELD_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PUBCODE = "PUBCODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCODE = "USERCODE";
    private static final int INDEX_CODEMODE = 0;
    private static final int INDEX_CODEPATH = 1;
    private static final int INDEX_CODEPKGNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PRJFOLDER = 7;
    private static final int INDEX_PRJNAME = 8;
    private static final int INDEX_PSMODELID = 9;
    private static final int INDEX_PSMODELNAME = 10;
    private static final int INDEX_PSMODELSFCODEID = 11;
    private static final int INDEX_PSMODELSFCODENAME = 12;
    private static final int INDEX_PSMODELTYPE = 13;
    private static final int INDEX_PSSFCODETYPEID = 14;
    private static final int INDEX_PSSFCODETYPENAME = 15;
    private static final int INDEX_PSSYSSFPUBID = 16;
    private static final int INDEX_PSSYSSFPUBNAME = 17;
    private static final int INDEX_PUBCODE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCODE = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelSFCodeBase proxyPSModelSFCodeBase = null;
    private boolean codemodeDirtyFlag = false;
    private boolean codepathDirtyFlag = false;
    private boolean codepkgnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjfolderDirtyFlag = false;
    private boolean prjnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelsfcodeidDirtyFlag = false;
    private boolean psmodelsfcodenameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssfcodetypeidDirtyFlag = false;
    private boolean pssfcodetypenameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pubcodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercodeDirtyFlag = false;
    @Column(name="codemode")
    private String codemode;
    @Column(name="codepath")
    private String codepath;
    @Column(name="codepkgname")
    private String codepkgname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customflag")
    private Integer customflag;
    @Column(name="memo")
    private String memo;
    @Column(name="prjfolder")
    private String prjfolder;
    @Column(name="prjname")
    private String prjname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelsfcodeid")
    private String psmodelsfcodeid;
    @Column(name="psmodelsfcodename")
    private String psmodelsfcodename;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssfcodetypeid")
    private String pssfcodetypeid;
    @Column(name="pssfcodetypename")
    private String pssfcodetypename;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pubcode")
    private String pubcode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercode")
    private String usercode;
    private Integer objPSSFCodeTypeLock = new Integer(1);
    private PSSFCodeType pssfcodetype = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;

    public void setCodeMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codemode = string;
        this.codemodeDirtyFlag = true;
    }

    public String getCodeMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeMode();
        }
        return this.codemode;
    }

    public boolean isCodeModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeModeDirty();
        }
        return this.codemodeDirtyFlag;
    }

    public void resetCodeMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeMode();
            return;
        }
        this.codemodeDirtyFlag = false;
        this.codemode = null;
    }

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

    public void setCodePkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodePkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codepkgname = string;
        this.codepkgnameDirtyFlag = true;
    }

    public String getCodePkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodePkgName();
        }
        return this.codepkgname;
    }

    public boolean isCodePkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodePkgNameDirty();
        }
        return this.codepkgnameDirtyFlag;
    }

    public void resetCodePkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodePkgName();
            return;
        }
        this.codepkgnameDirtyFlag = false;
        this.codepkgname = null;
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

    public void setCustomFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomFlag(n);
            return;
        }
        this.customflag = n;
        this.customflagDirtyFlag = true;
    }

    public Integer getCustomFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomFlag();
        }
        return this.customflag;
    }

    public boolean isCustomFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomFlagDirty();
        }
        return this.customflagDirtyFlag;
    }

    public void resetCustomFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomFlag();
            return;
        }
        this.customflagDirtyFlag = false;
        this.customflag = null;
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

    public void setPrjFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjfolder = string;
        this.prjfolderDirtyFlag = true;
    }

    public String getPrjFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjFolder();
        }
        return this.prjfolder;
    }

    public boolean isPrjFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjFolderDirty();
        }
        return this.prjfolderDirtyFlag;
    }

    public void resetPrjFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjFolder();
            return;
        }
        this.prjfolderDirtyFlag = false;
        this.prjfolder = null;
    }

    public void setPrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjname = string;
        this.prjnameDirtyFlag = true;
    }

    public String getPrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjName();
        }
        return this.prjname;
    }

    public boolean isPrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjNameDirty();
        }
        return this.prjnameDirtyFlag;
    }

    public void resetPrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjName();
            return;
        }
        this.prjnameDirtyFlag = false;
        this.prjname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelSFCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSFCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsfcodeid = string;
        this.psmodelsfcodeidDirtyFlag = true;
    }

    public String getPSModelSFCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSFCodeId();
        }
        return this.psmodelsfcodeid;
    }

    public boolean isPSModelSFCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSFCodeIdDirty();
        }
        return this.psmodelsfcodeidDirtyFlag;
    }

    public void resetPSModelSFCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSFCodeId();
            return;
        }
        this.psmodelsfcodeidDirtyFlag = false;
        this.psmodelsfcodeid = null;
    }

    public void setPSModelSFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsfcodename = string;
        this.psmodelsfcodenameDirtyFlag = true;
    }

    public String getPSModelSFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSFCodeName();
        }
        return this.psmodelsfcodename;
    }

    public boolean isPSModelSFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSFCodeNameDirty();
        }
        return this.psmodelsfcodenameDirtyFlag;
    }

    public void resetPSModelSFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSFCodeName();
            return;
        }
        this.psmodelsfcodenameDirtyFlag = false;
        this.psmodelsfcodename = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
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

    protected void onReset() {
        PSModelSFCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelSFCodeBase pSModelSFCodeBase) {
        pSModelSFCodeBase.resetCodeMode();
        pSModelSFCodeBase.resetCodePath();
        pSModelSFCodeBase.resetCodePkgName();
        pSModelSFCodeBase.resetCreateDate();
        pSModelSFCodeBase.resetCreateMan();
        pSModelSFCodeBase.resetCustomFlag();
        pSModelSFCodeBase.resetMemo();
        pSModelSFCodeBase.resetPrjFolder();
        pSModelSFCodeBase.resetPrjName();
        pSModelSFCodeBase.resetPSModelId();
        pSModelSFCodeBase.resetPSModelName();
        pSModelSFCodeBase.resetPSModelSFCodeId();
        pSModelSFCodeBase.resetPSModelSFCodeName();
        pSModelSFCodeBase.resetPSModelType();
        pSModelSFCodeBase.resetPSSFCodeTypeId();
        pSModelSFCodeBase.resetPSSFCodeTypeName();
        pSModelSFCodeBase.resetPSSysSFPubId();
        pSModelSFCodeBase.resetPSSysSFPubName();
        pSModelSFCodeBase.resetPubCode();
        pSModelSFCodeBase.resetUpdateDate();
        pSModelSFCodeBase.resetUpdateMan();
        pSModelSFCodeBase.resetUserCode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeModeDirty()) {
            hashMap.put(FIELD_CODEMODE, this.getCodeMode());
        }
        if (!bl || this.isCodePathDirty()) {
            hashMap.put(FIELD_CODEPATH, this.getCodePath());
        }
        if (!bl || this.isCodePkgNameDirty()) {
            hashMap.put(FIELD_CODEPKGNAME, this.getCodePkgName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomFlagDirty()) {
            hashMap.put(FIELD_CUSTOMFLAG, this.getCustomFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrjFolderDirty()) {
            hashMap.put(FIELD_PRJFOLDER, this.getPrjFolder());
        }
        if (!bl || this.isPrjNameDirty()) {
            hashMap.put(FIELD_PRJNAME, this.getPrjName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelSFCodeIdDirty()) {
            hashMap.put(FIELD_PSMODELSFCODEID, this.getPSModelSFCodeId());
        }
        if (!bl || this.isPSModelSFCodeNameDirty()) {
            hashMap.put(FIELD_PSMODELSFCODENAME, this.getPSModelSFCodeName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSFCodeTypeIdDirty()) {
            hashMap.put(FIELD_PSSFCODETYPEID, this.getPSSFCodeTypeId());
        }
        if (!bl || this.isPSSFCodeTypeNameDirty()) {
            hashMap.put(FIELD_PSSFCODETYPENAME, this.getPSSFCodeTypeName());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCodeDirty()) {
            hashMap.put(FIELD_USERCODE, this.getUserCode());
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
        return PSModelSFCodeBase.get(this, n);
    }

    private static Object get(PSModelSFCodeBase pSModelSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSFCodeBase.getCodeMode();
            }
            case 1: {
                return pSModelSFCodeBase.getCodePath();
            }
            case 2: {
                return pSModelSFCodeBase.getCodePkgName();
            }
            case 3: {
                return pSModelSFCodeBase.getCreateDate();
            }
            case 4: {
                return pSModelSFCodeBase.getCreateMan();
            }
            case 5: {
                return pSModelSFCodeBase.getCustomFlag();
            }
            case 6: {
                return pSModelSFCodeBase.getMemo();
            }
            case 7: {
                return pSModelSFCodeBase.getPrjFolder();
            }
            case 8: {
                return pSModelSFCodeBase.getPrjName();
            }
            case 9: {
                return pSModelSFCodeBase.getPSModelId();
            }
            case 10: {
                return pSModelSFCodeBase.getPSModelName();
            }
            case 11: {
                return pSModelSFCodeBase.getPSModelSFCodeId();
            }
            case 12: {
                return pSModelSFCodeBase.getPSModelSFCodeName();
            }
            case 13: {
                return pSModelSFCodeBase.getPSModelType();
            }
            case 14: {
                return pSModelSFCodeBase.getPSSFCodeTypeId();
            }
            case 15: {
                return pSModelSFCodeBase.getPSSFCodeTypeName();
            }
            case 16: {
                return pSModelSFCodeBase.getPSSysSFPubId();
            }
            case 17: {
                return pSModelSFCodeBase.getPSSysSFPubName();
            }
            case 18: {
                return pSModelSFCodeBase.getPubCode();
            }
            case 19: {
                return pSModelSFCodeBase.getUpdateDate();
            }
            case 20: {
                return pSModelSFCodeBase.getUpdateMan();
            }
            case 21: {
                return pSModelSFCodeBase.getUserCode();
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
        PSModelSFCodeBase.set(this, n, object);
    }

    private static void set(PSModelSFCodeBase pSModelSFCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelSFCodeBase.setCodeMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelSFCodeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelSFCodeBase.setCodePkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelSFCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSModelSFCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelSFCodeBase.setCustomFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelSFCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelSFCodeBase.setPrjFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelSFCodeBase.setPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelSFCodeBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelSFCodeBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelSFCodeBase.setPSModelSFCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelSFCodeBase.setPSModelSFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelSFCodeBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelSFCodeBase.setPSSFCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelSFCodeBase.setPSSFCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelSFCodeBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelSFCodeBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelSFCodeBase.setPubCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelSFCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSModelSFCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModelSFCodeBase.setUserCode(DataObject.getStringValue((Object)object));
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
        return PSModelSFCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSModelSFCodeBase pSModelSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSFCodeBase.getCodeMode() == null;
            }
            case 1: {
                return pSModelSFCodeBase.getCodePath() == null;
            }
            case 2: {
                return pSModelSFCodeBase.getCodePkgName() == null;
            }
            case 3: {
                return pSModelSFCodeBase.getCreateDate() == null;
            }
            case 4: {
                return pSModelSFCodeBase.getCreateMan() == null;
            }
            case 5: {
                return pSModelSFCodeBase.getCustomFlag() == null;
            }
            case 6: {
                return pSModelSFCodeBase.getMemo() == null;
            }
            case 7: {
                return pSModelSFCodeBase.getPrjFolder() == null;
            }
            case 8: {
                return pSModelSFCodeBase.getPrjName() == null;
            }
            case 9: {
                return pSModelSFCodeBase.getPSModelId() == null;
            }
            case 10: {
                return pSModelSFCodeBase.getPSModelName() == null;
            }
            case 11: {
                return pSModelSFCodeBase.getPSModelSFCodeId() == null;
            }
            case 12: {
                return pSModelSFCodeBase.getPSModelSFCodeName() == null;
            }
            case 13: {
                return pSModelSFCodeBase.getPSModelType() == null;
            }
            case 14: {
                return pSModelSFCodeBase.getPSSFCodeTypeId() == null;
            }
            case 15: {
                return pSModelSFCodeBase.getPSSFCodeTypeName() == null;
            }
            case 16: {
                return pSModelSFCodeBase.getPSSysSFPubId() == null;
            }
            case 17: {
                return pSModelSFCodeBase.getPSSysSFPubName() == null;
            }
            case 18: {
                return pSModelSFCodeBase.getPubCode() == null;
            }
            case 19: {
                return pSModelSFCodeBase.getUpdateDate() == null;
            }
            case 20: {
                return pSModelSFCodeBase.getUpdateMan() == null;
            }
            case 21: {
                return pSModelSFCodeBase.getUserCode() == null;
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
        return PSModelSFCodeBase.contains(this, n);
    }

    private static boolean contains(PSModelSFCodeBase pSModelSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSFCodeBase.isCodeModeDirty();
            }
            case 1: {
                return pSModelSFCodeBase.isCodePathDirty();
            }
            case 2: {
                return pSModelSFCodeBase.isCodePkgNameDirty();
            }
            case 3: {
                return pSModelSFCodeBase.isCreateDateDirty();
            }
            case 4: {
                return pSModelSFCodeBase.isCreateManDirty();
            }
            case 5: {
                return pSModelSFCodeBase.isCustomFlagDirty();
            }
            case 6: {
                return pSModelSFCodeBase.isMemoDirty();
            }
            case 7: {
                return pSModelSFCodeBase.isPrjFolderDirty();
            }
            case 8: {
                return pSModelSFCodeBase.isPrjNameDirty();
            }
            case 9: {
                return pSModelSFCodeBase.isPSModelIdDirty();
            }
            case 10: {
                return pSModelSFCodeBase.isPSModelNameDirty();
            }
            case 11: {
                return pSModelSFCodeBase.isPSModelSFCodeIdDirty();
            }
            case 12: {
                return pSModelSFCodeBase.isPSModelSFCodeNameDirty();
            }
            case 13: {
                return pSModelSFCodeBase.isPSModelTypeDirty();
            }
            case 14: {
                return pSModelSFCodeBase.isPSSFCodeTypeIdDirty();
            }
            case 15: {
                return pSModelSFCodeBase.isPSSFCodeTypeNameDirty();
            }
            case 16: {
                return pSModelSFCodeBase.isPSSysSFPubIdDirty();
            }
            case 17: {
                return pSModelSFCodeBase.isPSSysSFPubNameDirty();
            }
            case 18: {
                return pSModelSFCodeBase.isPubCodeDirty();
            }
            case 19: {
                return pSModelSFCodeBase.isUpdateDateDirty();
            }
            case 20: {
                return pSModelSFCodeBase.isUpdateManDirty();
            }
            case 21: {
                return pSModelSFCodeBase.isUserCodeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelSFCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelSFCodeBase pSModelSFCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelSFCodeBase.getCodeMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codemode", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCodeMode()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getCodePkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepkgname", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCodePkgName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getCustomFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customflag", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getCustomFlag()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPrjFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjfolder", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPrjFolder()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjname", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPrjName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSModelSFCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsfcodeid", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSModelSFCodeId()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSModelSFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsfcodename", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSModelSFCodeName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSSFCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypeid", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSSFCodeTypeId()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSSFCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypename", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSSFCodeTypeName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcode", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getPubCode()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelSFCodeBase.getUserCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercode", (Object)PSModelSFCodeBase.getJSONValue((Object)pSModelSFCodeBase.getUserCode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelSFCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelSFCodeBase pSModelSFCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelSFCodeBase.getCodeMode() != null) {
            object = pSModelSFCodeBase.getCodeMode();
            xmlNode.setAttribute(FIELD_CODEMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSModelSFCodeBase.getCodePath() != null) {
            object = pSModelSFCodeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSModelSFCodeBase.getCodePkgName() != null) {
            object = pSModelSFCodeBase.getCodePkgName();
            xmlNode.setAttribute(FIELD_CODEPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getCreateDate() != null) {
            object = pSModelSFCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSFCodeBase.getCreateMan() != null) {
            object = pSModelSFCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getCustomFlag() != null) {
            object = pSModelSFCodeBase.getCustomFlag();
            xmlNode.setAttribute(FIELD_CUSTOMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelSFCodeBase.getMemo() != null) {
            object = pSModelSFCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPrjFolder() != null) {
            object = pSModelSFCodeBase.getPrjFolder();
            xmlNode.setAttribute(FIELD_PRJFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPrjName() != null) {
            object = pSModelSFCodeBase.getPrjName();
            xmlNode.setAttribute(FIELD_PRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSModelId() != null) {
            object = pSModelSFCodeBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSModelName() != null) {
            object = pSModelSFCodeBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSModelSFCodeId() != null) {
            object = pSModelSFCodeBase.getPSModelSFCodeId();
            xmlNode.setAttribute(FIELD_PSMODELSFCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSModelSFCodeName() != null) {
            object = pSModelSFCodeBase.getPSModelSFCodeName();
            xmlNode.setAttribute(FIELD_PSMODELSFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSModelType() != null) {
            object = pSModelSFCodeBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSSFCodeTypeId() != null) {
            object = pSModelSFCodeBase.getPSSFCodeTypeId();
            xmlNode.setAttribute(FIELD_PSSFCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSSFCodeTypeName() != null) {
            object = pSModelSFCodeBase.getPSSFCodeTypeName();
            xmlNode.setAttribute(FIELD_PSSFCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSSysSFPubId() != null) {
            object = pSModelSFCodeBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPSSysSFPubName() != null) {
            object = pSModelSFCodeBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getPubCode() != null) {
            object = pSModelSFCodeBase.getPubCode();
            xmlNode.setAttribute(FIELD_PUBCODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getUpdateDate() != null) {
            object = pSModelSFCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSFCodeBase.getUpdateMan() != null) {
            object = pSModelSFCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSFCodeBase.getUserCode() != null) {
            object = pSModelSFCodeBase.getUserCode();
            xmlNode.setAttribute(FIELD_USERCODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelSFCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelSFCodeBase pSModelSFCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelSFCodeBase.isCodeModeDirty() && (bl || pSModelSFCodeBase.getCodeMode() != null)) {
            iDataObject.set(FIELD_CODEMODE, (Object)pSModelSFCodeBase.getCodeMode());
        }
        if (pSModelSFCodeBase.isCodePathDirty() && (bl || pSModelSFCodeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSModelSFCodeBase.getCodePath());
        }
        if (pSModelSFCodeBase.isCodePkgNameDirty() && (bl || pSModelSFCodeBase.getCodePkgName() != null)) {
            iDataObject.set(FIELD_CODEPKGNAME, (Object)pSModelSFCodeBase.getCodePkgName());
        }
        if (pSModelSFCodeBase.isCreateDateDirty() && (bl || pSModelSFCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelSFCodeBase.getCreateDate());
        }
        if (pSModelSFCodeBase.isCreateManDirty() && (bl || pSModelSFCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelSFCodeBase.getCreateMan());
        }
        if (pSModelSFCodeBase.isCustomFlagDirty() && (bl || pSModelSFCodeBase.getCustomFlag() != null)) {
            iDataObject.set(FIELD_CUSTOMFLAG, (Object)pSModelSFCodeBase.getCustomFlag());
        }
        if (pSModelSFCodeBase.isMemoDirty() && (bl || pSModelSFCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelSFCodeBase.getMemo());
        }
        if (pSModelSFCodeBase.isPrjFolderDirty() && (bl || pSModelSFCodeBase.getPrjFolder() != null)) {
            iDataObject.set(FIELD_PRJFOLDER, (Object)pSModelSFCodeBase.getPrjFolder());
        }
        if (pSModelSFCodeBase.isPrjNameDirty() && (bl || pSModelSFCodeBase.getPrjName() != null)) {
            iDataObject.set(FIELD_PRJNAME, (Object)pSModelSFCodeBase.getPrjName());
        }
        if (pSModelSFCodeBase.isPSModelIdDirty() && (bl || pSModelSFCodeBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelSFCodeBase.getPSModelId());
        }
        if (pSModelSFCodeBase.isPSModelNameDirty() && (bl || pSModelSFCodeBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelSFCodeBase.getPSModelName());
        }
        if (pSModelSFCodeBase.isPSModelSFCodeIdDirty() && (bl || pSModelSFCodeBase.getPSModelSFCodeId() != null)) {
            iDataObject.set(FIELD_PSMODELSFCODEID, (Object)pSModelSFCodeBase.getPSModelSFCodeId());
        }
        if (pSModelSFCodeBase.isPSModelSFCodeNameDirty() && (bl || pSModelSFCodeBase.getPSModelSFCodeName() != null)) {
            iDataObject.set(FIELD_PSMODELSFCODENAME, (Object)pSModelSFCodeBase.getPSModelSFCodeName());
        }
        if (pSModelSFCodeBase.isPSModelTypeDirty() && (bl || pSModelSFCodeBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSModelSFCodeBase.getPSModelType());
        }
        if (pSModelSFCodeBase.isPSSFCodeTypeIdDirty() && (bl || pSModelSFCodeBase.getPSSFCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPEID, (Object)pSModelSFCodeBase.getPSSFCodeTypeId());
        }
        if (pSModelSFCodeBase.isPSSFCodeTypeNameDirty() && (bl || pSModelSFCodeBase.getPSSFCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPENAME, (Object)pSModelSFCodeBase.getPSSFCodeTypeName());
        }
        if (pSModelSFCodeBase.isPSSysSFPubIdDirty() && (bl || pSModelSFCodeBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSModelSFCodeBase.getPSSysSFPubId());
        }
        if (pSModelSFCodeBase.isPSSysSFPubNameDirty() && (bl || pSModelSFCodeBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSModelSFCodeBase.getPSSysSFPubName());
        }
        if (pSModelSFCodeBase.isPubCodeDirty() && (bl || pSModelSFCodeBase.getPubCode() != null)) {
            iDataObject.set(FIELD_PUBCODE, (Object)pSModelSFCodeBase.getPubCode());
        }
        if (pSModelSFCodeBase.isUpdateDateDirty() && (bl || pSModelSFCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelSFCodeBase.getUpdateDate());
        }
        if (pSModelSFCodeBase.isUpdateManDirty() && (bl || pSModelSFCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelSFCodeBase.getUpdateMan());
        }
        if (pSModelSFCodeBase.isUserCodeDirty() && (bl || pSModelSFCodeBase.getUserCode() != null)) {
            iDataObject.set(FIELD_USERCODE, (Object)pSModelSFCodeBase.getUserCode());
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
        return PSModelSFCodeBase.remove(this, n);
    }

    private static boolean remove(PSModelSFCodeBase pSModelSFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelSFCodeBase.resetCodeMode();
                return true;
            }
            case 1: {
                pSModelSFCodeBase.resetCodePath();
                return true;
            }
            case 2: {
                pSModelSFCodeBase.resetCodePkgName();
                return true;
            }
            case 3: {
                pSModelSFCodeBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSModelSFCodeBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSModelSFCodeBase.resetCustomFlag();
                return true;
            }
            case 6: {
                pSModelSFCodeBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelSFCodeBase.resetPrjFolder();
                return true;
            }
            case 8: {
                pSModelSFCodeBase.resetPrjName();
                return true;
            }
            case 9: {
                pSModelSFCodeBase.resetPSModelId();
                return true;
            }
            case 10: {
                pSModelSFCodeBase.resetPSModelName();
                return true;
            }
            case 11: {
                pSModelSFCodeBase.resetPSModelSFCodeId();
                return true;
            }
            case 12: {
                pSModelSFCodeBase.resetPSModelSFCodeName();
                return true;
            }
            case 13: {
                pSModelSFCodeBase.resetPSModelType();
                return true;
            }
            case 14: {
                pSModelSFCodeBase.resetPSSFCodeTypeId();
                return true;
            }
            case 15: {
                pSModelSFCodeBase.resetPSSFCodeTypeName();
                return true;
            }
            case 16: {
                pSModelSFCodeBase.resetPSSysSFPubId();
                return true;
            }
            case 17: {
                pSModelSFCodeBase.resetPSSysSFPubName();
                return true;
            }
            case 18: {
                pSModelSFCodeBase.resetPubCode();
                return true;
            }
            case 19: {
                pSModelSFCodeBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSModelSFCodeBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSModelSFCodeBase.resetUserCode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSModelSFCodeBase getProxyEntity() {
        return this.proxyPSModelSFCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelSFCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelSFCodeBase) {
            this.proxyPSModelSFCodeBase = (PSModelSFCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelSFCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEMODE, 0);
        fieldIndexMap.put(FIELD_CODEPATH, 1);
        fieldIndexMap.put(FIELD_CODEPKGNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PRJFOLDER, 7);
        fieldIndexMap.put(FIELD_PRJNAME, 8);
        fieldIndexMap.put(FIELD_PSMODELID, 9);
        fieldIndexMap.put(FIELD_PSMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSMODELSFCODEID, 11);
        fieldIndexMap.put(FIELD_PSMODELSFCODENAME, 12);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 13);
        fieldIndexMap.put(FIELD_PSSFCODETYPEID, 14);
        fieldIndexMap.put(FIELD_PSSFCODETYPENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 16);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 17);
        fieldIndexMap.put(FIELD_PUBCODE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCODE, 21);
    }
}

