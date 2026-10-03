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
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelPFCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelPFCodeBase.class);
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
    public static final String FIELD_PSMODELPFCODEID = "PSMODELPFCODEID";
    public static final String FIELD_PSMODELPFCODENAME = "PSMODELPFCODENAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
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
    private static final int INDEX_PSMODELPFCODEID = 11;
    private static final int INDEX_PSMODELPFCODENAME = 12;
    private static final int INDEX_PSMODELTYPE = 13;
    private static final int INDEX_PSPFPUBCODEID = 14;
    private static final int INDEX_PSPFPUBCODENAME = 15;
    private static final int INDEX_PSSYSAPPID = 16;
    private static final int INDEX_PSSYSAPPNAME = 17;
    private static final int INDEX_PUBCODE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCODE = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelPFCodeBase proxyPSModelPFCodeBase = null;
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
    private boolean psmodelpfcodeidDirtyFlag = false;
    private boolean psmodelpfcodenameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
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
    @Column(name="psmodelpfcodeid")
    private String psmodelpfcodeid;
    @Column(name="psmodelpfcodename")
    private String psmodelpfcodename;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pubcode")
    private String pubcode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercode")
    private String usercode;
    private Integer objPSSFPubCodeLock = new Integer(1);
    private PSPFPubCode pssfpubcode = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

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

    public void setPSModelPFCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelPFCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelpfcodeid = string;
        this.psmodelpfcodeidDirtyFlag = true;
    }

    public String getPSModelPFCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelPFCodeId();
        }
        return this.psmodelpfcodeid;
    }

    public boolean isPSModelPFCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelPFCodeIdDirty();
        }
        return this.psmodelpfcodeidDirtyFlag;
    }

    public void resetPSModelPFCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelPFCodeId();
            return;
        }
        this.psmodelpfcodeidDirtyFlag = false;
        this.psmodelpfcodeid = null;
    }

    public void setPSModelPFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelPFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelpfcodename = string;
        this.psmodelpfcodenameDirtyFlag = true;
    }

    public String getPSModelPFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelPFCodeName();
        }
        return this.psmodelpfcodename;
    }

    public boolean isPSModelPFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelPFCodeNameDirty();
        }
        return this.psmodelpfcodenameDirtyFlag;
    }

    public void resetPSModelPFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelPFCodeName();
            return;
        }
        this.psmodelpfcodenameDirtyFlag = false;
        this.psmodelpfcodename = null;
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

    public void setPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodeid = string;
        this.pspfpubcodeidDirtyFlag = true;
    }

    public String getPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeId();
        }
        return this.pspfpubcodeid;
    }

    public boolean isPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeIdDirty();
        }
        return this.pspfpubcodeidDirtyFlag;
    }

    public void resetPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeId();
            return;
        }
        this.pspfpubcodeidDirtyFlag = false;
        this.pspfpubcodeid = null;
    }

    public void setPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodename = string;
        this.pspfpubcodenameDirtyFlag = true;
    }

    public String getPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeName();
        }
        return this.pspfpubcodename;
    }

    public boolean isPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeNameDirty();
        }
        return this.pspfpubcodenameDirtyFlag;
    }

    public void resetPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeName();
            return;
        }
        this.pspfpubcodenameDirtyFlag = false;
        this.pspfpubcodename = null;
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
        PSModelPFCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelPFCodeBase pSModelPFCodeBase) {
        pSModelPFCodeBase.resetCodeMode();
        pSModelPFCodeBase.resetCodePath();
        pSModelPFCodeBase.resetCodePkgName();
        pSModelPFCodeBase.resetCreateDate();
        pSModelPFCodeBase.resetCreateMan();
        pSModelPFCodeBase.resetCustomFlag();
        pSModelPFCodeBase.resetMemo();
        pSModelPFCodeBase.resetPrjFolder();
        pSModelPFCodeBase.resetPrjName();
        pSModelPFCodeBase.resetPSModelId();
        pSModelPFCodeBase.resetPSModelName();
        pSModelPFCodeBase.resetPSModelPFCodeId();
        pSModelPFCodeBase.resetPSModelPFCodeName();
        pSModelPFCodeBase.resetPSModelType();
        pSModelPFCodeBase.resetPSPFPubCodeId();
        pSModelPFCodeBase.resetPSPFPubCodeName();
        pSModelPFCodeBase.resetPSSysAppId();
        pSModelPFCodeBase.resetPSSysAppName();
        pSModelPFCodeBase.resetPubCode();
        pSModelPFCodeBase.resetUpdateDate();
        pSModelPFCodeBase.resetUpdateMan();
        pSModelPFCodeBase.resetUserCode();
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
        if (!bl || this.isPSModelPFCodeIdDirty()) {
            hashMap.put(FIELD_PSMODELPFCODEID, this.getPSModelPFCodeId());
        }
        if (!bl || this.isPSModelPFCodeNameDirty()) {
            hashMap.put(FIELD_PSMODELPFCODENAME, this.getPSModelPFCodeName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSModelPFCodeBase.get(this, n);
    }

    private static Object get(PSModelPFCodeBase pSModelPFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPFCodeBase.getCodeMode();
            }
            case 1: {
                return pSModelPFCodeBase.getCodePath();
            }
            case 2: {
                return pSModelPFCodeBase.getCodePkgName();
            }
            case 3: {
                return pSModelPFCodeBase.getCreateDate();
            }
            case 4: {
                return pSModelPFCodeBase.getCreateMan();
            }
            case 5: {
                return pSModelPFCodeBase.getCustomFlag();
            }
            case 6: {
                return pSModelPFCodeBase.getMemo();
            }
            case 7: {
                return pSModelPFCodeBase.getPrjFolder();
            }
            case 8: {
                return pSModelPFCodeBase.getPrjName();
            }
            case 9: {
                return pSModelPFCodeBase.getPSModelId();
            }
            case 10: {
                return pSModelPFCodeBase.getPSModelName();
            }
            case 11: {
                return pSModelPFCodeBase.getPSModelPFCodeId();
            }
            case 12: {
                return pSModelPFCodeBase.getPSModelPFCodeName();
            }
            case 13: {
                return pSModelPFCodeBase.getPSModelType();
            }
            case 14: {
                return pSModelPFCodeBase.getPSPFPubCodeId();
            }
            case 15: {
                return pSModelPFCodeBase.getPSPFPubCodeName();
            }
            case 16: {
                return pSModelPFCodeBase.getPSSysAppId();
            }
            case 17: {
                return pSModelPFCodeBase.getPSSysAppName();
            }
            case 18: {
                return pSModelPFCodeBase.getPubCode();
            }
            case 19: {
                return pSModelPFCodeBase.getUpdateDate();
            }
            case 20: {
                return pSModelPFCodeBase.getUpdateMan();
            }
            case 21: {
                return pSModelPFCodeBase.getUserCode();
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
        PSModelPFCodeBase.set(this, n, object);
    }

    private static void set(PSModelPFCodeBase pSModelPFCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelPFCodeBase.setCodeMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelPFCodeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelPFCodeBase.setCodePkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelPFCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSModelPFCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelPFCodeBase.setCustomFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelPFCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelPFCodeBase.setPrjFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelPFCodeBase.setPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelPFCodeBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelPFCodeBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelPFCodeBase.setPSModelPFCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelPFCodeBase.setPSModelPFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelPFCodeBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelPFCodeBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelPFCodeBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelPFCodeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelPFCodeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelPFCodeBase.setPubCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelPFCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSModelPFCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModelPFCodeBase.setUserCode(DataObject.getStringValue((Object)object));
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
        return PSModelPFCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSModelPFCodeBase pSModelPFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPFCodeBase.getCodeMode() == null;
            }
            case 1: {
                return pSModelPFCodeBase.getCodePath() == null;
            }
            case 2: {
                return pSModelPFCodeBase.getCodePkgName() == null;
            }
            case 3: {
                return pSModelPFCodeBase.getCreateDate() == null;
            }
            case 4: {
                return pSModelPFCodeBase.getCreateMan() == null;
            }
            case 5: {
                return pSModelPFCodeBase.getCustomFlag() == null;
            }
            case 6: {
                return pSModelPFCodeBase.getMemo() == null;
            }
            case 7: {
                return pSModelPFCodeBase.getPrjFolder() == null;
            }
            case 8: {
                return pSModelPFCodeBase.getPrjName() == null;
            }
            case 9: {
                return pSModelPFCodeBase.getPSModelId() == null;
            }
            case 10: {
                return pSModelPFCodeBase.getPSModelName() == null;
            }
            case 11: {
                return pSModelPFCodeBase.getPSModelPFCodeId() == null;
            }
            case 12: {
                return pSModelPFCodeBase.getPSModelPFCodeName() == null;
            }
            case 13: {
                return pSModelPFCodeBase.getPSModelType() == null;
            }
            case 14: {
                return pSModelPFCodeBase.getPSPFPubCodeId() == null;
            }
            case 15: {
                return pSModelPFCodeBase.getPSPFPubCodeName() == null;
            }
            case 16: {
                return pSModelPFCodeBase.getPSSysAppId() == null;
            }
            case 17: {
                return pSModelPFCodeBase.getPSSysAppName() == null;
            }
            case 18: {
                return pSModelPFCodeBase.getPubCode() == null;
            }
            case 19: {
                return pSModelPFCodeBase.getUpdateDate() == null;
            }
            case 20: {
                return pSModelPFCodeBase.getUpdateMan() == null;
            }
            case 21: {
                return pSModelPFCodeBase.getUserCode() == null;
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
        return PSModelPFCodeBase.contains(this, n);
    }

    private static boolean contains(PSModelPFCodeBase pSModelPFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPFCodeBase.isCodeModeDirty();
            }
            case 1: {
                return pSModelPFCodeBase.isCodePathDirty();
            }
            case 2: {
                return pSModelPFCodeBase.isCodePkgNameDirty();
            }
            case 3: {
                return pSModelPFCodeBase.isCreateDateDirty();
            }
            case 4: {
                return pSModelPFCodeBase.isCreateManDirty();
            }
            case 5: {
                return pSModelPFCodeBase.isCustomFlagDirty();
            }
            case 6: {
                return pSModelPFCodeBase.isMemoDirty();
            }
            case 7: {
                return pSModelPFCodeBase.isPrjFolderDirty();
            }
            case 8: {
                return pSModelPFCodeBase.isPrjNameDirty();
            }
            case 9: {
                return pSModelPFCodeBase.isPSModelIdDirty();
            }
            case 10: {
                return pSModelPFCodeBase.isPSModelNameDirty();
            }
            case 11: {
                return pSModelPFCodeBase.isPSModelPFCodeIdDirty();
            }
            case 12: {
                return pSModelPFCodeBase.isPSModelPFCodeNameDirty();
            }
            case 13: {
                return pSModelPFCodeBase.isPSModelTypeDirty();
            }
            case 14: {
                return pSModelPFCodeBase.isPSPFPubCodeIdDirty();
            }
            case 15: {
                return pSModelPFCodeBase.isPSPFPubCodeNameDirty();
            }
            case 16: {
                return pSModelPFCodeBase.isPSSysAppIdDirty();
            }
            case 17: {
                return pSModelPFCodeBase.isPSSysAppNameDirty();
            }
            case 18: {
                return pSModelPFCodeBase.isPubCodeDirty();
            }
            case 19: {
                return pSModelPFCodeBase.isUpdateDateDirty();
            }
            case 20: {
                return pSModelPFCodeBase.isUpdateManDirty();
            }
            case 21: {
                return pSModelPFCodeBase.isUserCodeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelPFCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelPFCodeBase pSModelPFCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelPFCodeBase.getCodeMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codemode", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCodeMode()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getCodePkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepkgname", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCodePkgName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getCustomFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customflag", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getCustomFlag()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPrjFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjfolder", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPrjFolder()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjname", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPrjName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSModelPFCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelpfcodeid", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSModelPFCodeId()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSModelPFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelpfcodename", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSModelPFCodeName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcode", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getPubCode()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelPFCodeBase.getUserCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercode", (Object)PSModelPFCodeBase.getJSONValue((Object)pSModelPFCodeBase.getUserCode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelPFCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelPFCodeBase pSModelPFCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelPFCodeBase.getCodeMode() != null) {
            object = pSModelPFCodeBase.getCodeMode();
            xmlNode.setAttribute(FIELD_CODEMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSModelPFCodeBase.getCodePath() != null) {
            object = pSModelPFCodeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSModelPFCodeBase.getCodePkgName() != null) {
            object = pSModelPFCodeBase.getCodePkgName();
            xmlNode.setAttribute(FIELD_CODEPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getCreateDate() != null) {
            object = pSModelPFCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelPFCodeBase.getCreateMan() != null) {
            object = pSModelPFCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getCustomFlag() != null) {
            object = pSModelPFCodeBase.getCustomFlag();
            xmlNode.setAttribute(FIELD_CUSTOMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelPFCodeBase.getMemo() != null) {
            object = pSModelPFCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPrjFolder() != null) {
            object = pSModelPFCodeBase.getPrjFolder();
            xmlNode.setAttribute(FIELD_PRJFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPrjName() != null) {
            object = pSModelPFCodeBase.getPrjName();
            xmlNode.setAttribute(FIELD_PRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSModelId() != null) {
            object = pSModelPFCodeBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSModelName() != null) {
            object = pSModelPFCodeBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSModelPFCodeId() != null) {
            object = pSModelPFCodeBase.getPSModelPFCodeId();
            xmlNode.setAttribute(FIELD_PSMODELPFCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSModelPFCodeName() != null) {
            object = pSModelPFCodeBase.getPSModelPFCodeName();
            xmlNode.setAttribute(FIELD_PSMODELPFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSModelType() != null) {
            object = pSModelPFCodeBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSPFPubCodeId() != null) {
            object = pSModelPFCodeBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSPFPubCodeName() != null) {
            object = pSModelPFCodeBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSSysAppId() != null) {
            object = pSModelPFCodeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPSSysAppName() != null) {
            object = pSModelPFCodeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getPubCode() != null) {
            object = pSModelPFCodeBase.getPubCode();
            xmlNode.setAttribute(FIELD_PUBCODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getUpdateDate() != null) {
            object = pSModelPFCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelPFCodeBase.getUpdateMan() != null) {
            object = pSModelPFCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelPFCodeBase.getUserCode() != null) {
            object = pSModelPFCodeBase.getUserCode();
            xmlNode.setAttribute(FIELD_USERCODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelPFCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelPFCodeBase pSModelPFCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelPFCodeBase.isCodeModeDirty() && (bl || pSModelPFCodeBase.getCodeMode() != null)) {
            iDataObject.set(FIELD_CODEMODE, (Object)pSModelPFCodeBase.getCodeMode());
        }
        if (pSModelPFCodeBase.isCodePathDirty() && (bl || pSModelPFCodeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSModelPFCodeBase.getCodePath());
        }
        if (pSModelPFCodeBase.isCodePkgNameDirty() && (bl || pSModelPFCodeBase.getCodePkgName() != null)) {
            iDataObject.set(FIELD_CODEPKGNAME, (Object)pSModelPFCodeBase.getCodePkgName());
        }
        if (pSModelPFCodeBase.isCreateDateDirty() && (bl || pSModelPFCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelPFCodeBase.getCreateDate());
        }
        if (pSModelPFCodeBase.isCreateManDirty() && (bl || pSModelPFCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelPFCodeBase.getCreateMan());
        }
        if (pSModelPFCodeBase.isCustomFlagDirty() && (bl || pSModelPFCodeBase.getCustomFlag() != null)) {
            iDataObject.set(FIELD_CUSTOMFLAG, (Object)pSModelPFCodeBase.getCustomFlag());
        }
        if (pSModelPFCodeBase.isMemoDirty() && (bl || pSModelPFCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelPFCodeBase.getMemo());
        }
        if (pSModelPFCodeBase.isPrjFolderDirty() && (bl || pSModelPFCodeBase.getPrjFolder() != null)) {
            iDataObject.set(FIELD_PRJFOLDER, (Object)pSModelPFCodeBase.getPrjFolder());
        }
        if (pSModelPFCodeBase.isPrjNameDirty() && (bl || pSModelPFCodeBase.getPrjName() != null)) {
            iDataObject.set(FIELD_PRJNAME, (Object)pSModelPFCodeBase.getPrjName());
        }
        if (pSModelPFCodeBase.isPSModelIdDirty() && (bl || pSModelPFCodeBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelPFCodeBase.getPSModelId());
        }
        if (pSModelPFCodeBase.isPSModelNameDirty() && (bl || pSModelPFCodeBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelPFCodeBase.getPSModelName());
        }
        if (pSModelPFCodeBase.isPSModelPFCodeIdDirty() && (bl || pSModelPFCodeBase.getPSModelPFCodeId() != null)) {
            iDataObject.set(FIELD_PSMODELPFCODEID, (Object)pSModelPFCodeBase.getPSModelPFCodeId());
        }
        if (pSModelPFCodeBase.isPSModelPFCodeNameDirty() && (bl || pSModelPFCodeBase.getPSModelPFCodeName() != null)) {
            iDataObject.set(FIELD_PSMODELPFCODENAME, (Object)pSModelPFCodeBase.getPSModelPFCodeName());
        }
        if (pSModelPFCodeBase.isPSModelTypeDirty() && (bl || pSModelPFCodeBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSModelPFCodeBase.getPSModelType());
        }
        if (pSModelPFCodeBase.isPSPFPubCodeIdDirty() && (bl || pSModelPFCodeBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSModelPFCodeBase.getPSPFPubCodeId());
        }
        if (pSModelPFCodeBase.isPSPFPubCodeNameDirty() && (bl || pSModelPFCodeBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSModelPFCodeBase.getPSPFPubCodeName());
        }
        if (pSModelPFCodeBase.isPSSysAppIdDirty() && (bl || pSModelPFCodeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSModelPFCodeBase.getPSSysAppId());
        }
        if (pSModelPFCodeBase.isPSSysAppNameDirty() && (bl || pSModelPFCodeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSModelPFCodeBase.getPSSysAppName());
        }
        if (pSModelPFCodeBase.isPubCodeDirty() && (bl || pSModelPFCodeBase.getPubCode() != null)) {
            iDataObject.set(FIELD_PUBCODE, (Object)pSModelPFCodeBase.getPubCode());
        }
        if (pSModelPFCodeBase.isUpdateDateDirty() && (bl || pSModelPFCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelPFCodeBase.getUpdateDate());
        }
        if (pSModelPFCodeBase.isUpdateManDirty() && (bl || pSModelPFCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelPFCodeBase.getUpdateMan());
        }
        if (pSModelPFCodeBase.isUserCodeDirty() && (bl || pSModelPFCodeBase.getUserCode() != null)) {
            iDataObject.set(FIELD_USERCODE, (Object)pSModelPFCodeBase.getUserCode());
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
        return PSModelPFCodeBase.remove(this, n);
    }

    private static boolean remove(PSModelPFCodeBase pSModelPFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelPFCodeBase.resetCodeMode();
                return true;
            }
            case 1: {
                pSModelPFCodeBase.resetCodePath();
                return true;
            }
            case 2: {
                pSModelPFCodeBase.resetCodePkgName();
                return true;
            }
            case 3: {
                pSModelPFCodeBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSModelPFCodeBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSModelPFCodeBase.resetCustomFlag();
                return true;
            }
            case 6: {
                pSModelPFCodeBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelPFCodeBase.resetPrjFolder();
                return true;
            }
            case 8: {
                pSModelPFCodeBase.resetPrjName();
                return true;
            }
            case 9: {
                pSModelPFCodeBase.resetPSModelId();
                return true;
            }
            case 10: {
                pSModelPFCodeBase.resetPSModelName();
                return true;
            }
            case 11: {
                pSModelPFCodeBase.resetPSModelPFCodeId();
                return true;
            }
            case 12: {
                pSModelPFCodeBase.resetPSModelPFCodeName();
                return true;
            }
            case 13: {
                pSModelPFCodeBase.resetPSModelType();
                return true;
            }
            case 14: {
                pSModelPFCodeBase.resetPSPFPubCodeId();
                return true;
            }
            case 15: {
                pSModelPFCodeBase.resetPSPFPubCodeName();
                return true;
            }
            case 16: {
                pSModelPFCodeBase.resetPSSysAppId();
                return true;
            }
            case 17: {
                pSModelPFCodeBase.resetPSSysAppName();
                return true;
            }
            case 18: {
                pSModelPFCodeBase.resetPubCode();
                return true;
            }
            case 19: {
                pSModelPFCodeBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSModelPFCodeBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSModelPFCodeBase.resetUserCode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSSFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSSFPubCodeLock;
        synchronized (n) {
            if (this.pssfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pssfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pssfpubcode = null;
            }
            if (this.pssfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet(pSPFPubCode);
                this.pssfpubcode = pSPFPubCode;
            }
            return this.pssfpubcode;
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

    private PSModelPFCodeBase getProxyEntity() {
        return this.proxyPSModelPFCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelPFCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelPFCodeBase) {
            this.proxyPSModelPFCodeBase = (PSModelPFCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSModelPFCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSMODELPFCODEID, 11);
        fieldIndexMap.put(FIELD_PSMODELPFCODENAME, 12);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 13);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 14);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 16);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 17);
        fieldIndexMap.put(FIELD_PUBCODE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCODE, 21);
    }
}

