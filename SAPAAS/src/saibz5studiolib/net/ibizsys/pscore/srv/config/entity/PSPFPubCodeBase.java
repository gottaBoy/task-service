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
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPubCodeBase.class);
    public static final String FIELD_CLASSEXT = "CLASSEXT";
    public static final String FIELD_CODEEXT = "CODEEXT";
    public static final String FIELD_CODEFOLDER = "CODEFOLDER";
    public static final String FIELD_CODEFOLDER2 = "CODEFOLDER2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNAVIEWFLAG = "DYNAVIEWFLAG";
    public static final String FIELD_HASPSPFPUBCODE = "HASPSPFPUBCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PITEMPLCODE = "PITEMPLCODE";
    public static final String FIELD_PITEMPLCODE2 = "PITEMPLCODE2";
    public static final String FIELD_PKGNAME = "PKGNAME";
    public static final String FIELD_PPSPFPUBCODEID = "PPSPFPUBCODEID";
    public static final String FIELD_PPSPFPUBCODENAME = "PPSPFPUBCODENAME";
    public static final String FIELD_PREVIEWCODE = "PREVIEWCODE";
    public static final String FIELD_PREVIEWFLAG = "PREVIEWFLAG";
    public static final String FIELD_PSPFCODEFOLDERID = "PSPFCODEFOLDERID";
    public static final String FIELD_PSPFCODEFOLDERNAME = "PSPFCODEFOLDERNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PUBCODEDESC = "PUBCODEDESC";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CLASSEXT = 0;
    private static final int INDEX_CODEEXT = 1;
    private static final int INDEX_CODEFOLDER = 2;
    private static final int INDEX_CODEFOLDER2 = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_DYNAVIEWFLAG = 7;
    private static final int INDEX_HASPSPFPUBCODE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PITEMPLCODE = 10;
    private static final int INDEX_PITEMPLCODE2 = 11;
    private static final int INDEX_PKGNAME = 12;
    private static final int INDEX_PPSPFPUBCODEID = 13;
    private static final int INDEX_PPSPFPUBCODENAME = 14;
    private static final int INDEX_PREVIEWCODE = 15;
    private static final int INDEX_PREVIEWFLAG = 16;
    private static final int INDEX_PSPFCODEFOLDERID = 17;
    private static final int INDEX_PSPFCODEFOLDERNAME = 18;
    private static final int INDEX_PSPFID = 19;
    private static final int INDEX_PSPFNAME = 20;
    private static final int INDEX_PSPFPUBCODEID = 21;
    private static final int INDEX_PSPFPUBCODENAME = 22;
    private static final int INDEX_PUBCODEDESC = 23;
    private static final int INDEX_TARGETTYPE = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPubCodeBase proxyPSPFPubCodeBase = null;
    private boolean classextDirtyFlag = false;
    private boolean codeextDirtyFlag = false;
    private boolean codefolderDirtyFlag = false;
    private boolean codefolder2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dynaviewflagDirtyFlag = false;
    private boolean haspspfpubcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pitemplcodeDirtyFlag = false;
    private boolean pitemplcode2DirtyFlag = false;
    private boolean pkgnameDirtyFlag = false;
    private boolean ppspfpubcodeidDirtyFlag = false;
    private boolean ppspfpubcodenameDirtyFlag = false;
    private boolean previewcodeDirtyFlag = false;
    private boolean previewflagDirtyFlag = false;
    private boolean pspfcodefolderidDirtyFlag = false;
    private boolean pspfcodefoldernameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pubcodedescDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="classext")
    private String classext;
    @Column(name="codeext")
    private String codeext;
    @Column(name="codefolder")
    private String codefolder;
    @Column(name="codefolder2")
    private String codefolder2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dynaviewflag")
    private Integer dynaviewflag;
    @Column(name="haspspfpubcode")
    private Integer haspspfpubcode;
    @Column(name="memo")
    private String memo;
    @Column(name="pitemplcode")
    private String pitemplcode;
    @Column(name="pitemplcode2")
    private String pitemplcode2;
    @Column(name="pkgname")
    private String pkgname;
    @Column(name="ppspfpubcodeid")
    private String ppspfpubcodeid;
    @Column(name="ppspfpubcodename")
    private String ppspfpubcodename;
    @Column(name="previewcode")
    private String previewcode;
    @Column(name="previewflag")
    private Integer previewflag;
    @Column(name="pspfcodefolderid")
    private String pspfcodefolderid;
    @Column(name="pspfcodefoldername")
    private String pspfcodefoldername;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pubcodedesc")
    private String pubcodedesc;
    @Column(name="targettype")
    private String targettype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFCodeFolderLock = new Integer(1);
    private PSPFCodeFolder pspfcodefolder = null;
    private Integer objPPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode ppspfpubcode = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

    public void setCLASSEXT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLASSEXT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.classext = string;
        this.classextDirtyFlag = true;
    }

    public String getCLASSEXT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLASSEXT();
        }
        return this.classext;
    }

    public boolean isCLASSEXTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLASSEXTDirty();
        }
        return this.classextDirtyFlag;
    }

    public void resetCLASSEXT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLASSEXT();
            return;
        }
        this.classextDirtyFlag = false;
        this.classext = null;
    }

    public void setCodeEXT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeEXT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codeext = string;
        this.codeextDirtyFlag = true;
    }

    public String getCodeEXT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeEXT();
        }
        return this.codeext;
    }

    public boolean isCodeEXTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeEXTDirty();
        }
        return this.codeextDirtyFlag;
    }

    public void resetCodeEXT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeEXT();
            return;
        }
        this.codeextDirtyFlag = false;
        this.codeext = null;
    }

    public void setCodeFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codefolder = string;
        this.codefolderDirtyFlag = true;
    }

    public String getCodeFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeFolder();
        }
        return this.codefolder;
    }

    public boolean isCodeFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeFolderDirty();
        }
        return this.codefolderDirtyFlag;
    }

    public void resetCodeFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeFolder();
            return;
        }
        this.codefolderDirtyFlag = false;
        this.codefolder = null;
    }

    public void setCodeFolder2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeFolder2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codefolder2 = string;
        this.codefolder2DirtyFlag = true;
    }

    public String getCodeFolder2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeFolder2();
        }
        return this.codefolder2;
    }

    public boolean isCodeFolder2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeFolder2Dirty();
        }
        return this.codefolder2DirtyFlag;
    }

    public void resetCodeFolder2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeFolder2();
            return;
        }
        this.codefolder2DirtyFlag = false;
        this.codefolder2 = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setDynaViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaViewFlag(n);
            return;
        }
        this.dynaviewflag = n;
        this.dynaviewflagDirtyFlag = true;
    }

    public Integer getDynaViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaViewFlag();
        }
        return this.dynaviewflag;
    }

    public boolean isDynaViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaViewFlagDirty();
        }
        return this.dynaviewflagDirtyFlag;
    }

    public void resetDynaViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaViewFlag();
            return;
        }
        this.dynaviewflagDirtyFlag = false;
        this.dynaviewflag = null;
    }

    public void setHasPSPFPubCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHasPSPFPubCode(n);
            return;
        }
        this.haspspfpubcode = n;
        this.haspspfpubcodeDirtyFlag = true;
    }

    public Integer getHasPSPFPubCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHasPSPFPubCode();
        }
        return this.haspspfpubcode;
    }

    public boolean isHasPSPFPubCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHasPSPFPubCodeDirty();
        }
        return this.haspspfpubcodeDirtyFlag;
    }

    public void resetHasPSPFPubCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHasPSPFPubCode();
            return;
        }
        this.haspspfpubcodeDirtyFlag = false;
        this.haspspfpubcode = null;
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

    public void setPITemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPITemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pitemplcode = string;
        this.pitemplcodeDirtyFlag = true;
    }

    public String getPITemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPITemplCode();
        }
        return this.pitemplcode;
    }

    public boolean isPITemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPITemplCodeDirty();
        }
        return this.pitemplcodeDirtyFlag;
    }

    public void resetPITemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPITemplCode();
            return;
        }
        this.pitemplcodeDirtyFlag = false;
        this.pitemplcode = null;
    }

    public void setPITemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPITemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pitemplcode2 = string;
        this.pitemplcode2DirtyFlag = true;
    }

    public String getPITemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPITemplCode2();
        }
        return this.pitemplcode2;
    }

    public boolean isPITemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPITemplCode2Dirty();
        }
        return this.pitemplcode2DirtyFlag;
    }

    public void resetPITemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPITemplCode2();
            return;
        }
        this.pitemplcode2DirtyFlag = false;
        this.pitemplcode2 = null;
    }

    public void setPKGName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgname = string;
        this.pkgnameDirtyFlag = true;
    }

    public String getPKGName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGName();
        }
        return this.pkgname;
    }

    public boolean isPKGNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGNameDirty();
        }
        return this.pkgnameDirtyFlag;
    }

    public void resetPKGName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGName();
            return;
        }
        this.pkgnameDirtyFlag = false;
        this.pkgname = null;
    }

    public void setPPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspfpubcodeid = string;
        this.ppspfpubcodeidDirtyFlag = true;
    }

    public String getPPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPFPubCodeId();
        }
        return this.ppspfpubcodeid;
    }

    public boolean isPPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPFPubCodeIdDirty();
        }
        return this.ppspfpubcodeidDirtyFlag;
    }

    public void resetPPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPFPubCodeId();
            return;
        }
        this.ppspfpubcodeidDirtyFlag = false;
        this.ppspfpubcodeid = null;
    }

    public void setPPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspfpubcodename = string;
        this.ppspfpubcodenameDirtyFlag = true;
    }

    public String getPPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPFPubCodeName();
        }
        return this.ppspfpubcodename;
    }

    public boolean isPPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPFPubCodeNameDirty();
        }
        return this.ppspfpubcodenameDirtyFlag;
    }

    public void resetPPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPFPubCodeName();
            return;
        }
        this.ppspfpubcodenameDirtyFlag = false;
        this.ppspfpubcodename = null;
    }

    public void setPreviewCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewcode = string;
        this.previewcodeDirtyFlag = true;
    }

    public String getPreviewCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewCode();
        }
        return this.previewcode;
    }

    public boolean isPreviewCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewCodeDirty();
        }
        return this.previewcodeDirtyFlag;
    }

    public void resetPreviewCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewCode();
            return;
        }
        this.previewcodeDirtyFlag = false;
        this.previewcode = null;
    }

    public void setPreviewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewFlag(n);
            return;
        }
        this.previewflag = n;
        this.previewflagDirtyFlag = true;
    }

    public Integer getPreviewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewFlag();
        }
        return this.previewflag;
    }

    public boolean isPreviewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewFlagDirty();
        }
        return this.previewflagDirtyFlag;
    }

    public void resetPreviewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewFlag();
            return;
        }
        this.previewflagDirtyFlag = false;
        this.previewflag = null;
    }

    public void setPSPFCodeFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCodeFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcodefolderid = string;
        this.pspfcodefolderidDirtyFlag = true;
    }

    public String getPSPFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCodeFolderId();
        }
        return this.pspfcodefolderid;
    }

    public boolean isPSPFCodeFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCodeFolderIdDirty();
        }
        return this.pspfcodefolderidDirtyFlag;
    }

    public void resetPSPFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCodeFolderId();
            return;
        }
        this.pspfcodefolderidDirtyFlag = false;
        this.pspfcodefolderid = null;
    }

    public void setPSPFCodeFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCodeFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcodefoldername = string;
        this.pspfcodefoldernameDirtyFlag = true;
    }

    public String getPSPFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCodeFolderName();
        }
        return this.pspfcodefoldername;
    }

    public boolean isPSPFCodeFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCodeFolderNameDirty();
        }
        return this.pspfcodefoldernameDirtyFlag;
    }

    public void resetPSPFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCodeFolderName();
            return;
        }
        this.pspfcodefoldernameDirtyFlag = false;
        this.pspfcodefoldername = null;
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

    public void setPubCodeDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubCodeDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubcodedesc = string;
        this.pubcodedescDirtyFlag = true;
    }

    public String getPubCodeDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubCodeDesc();
        }
        return this.pubcodedesc;
    }

    public boolean isPubCodeDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubCodeDescDirty();
        }
        return this.pubcodedescDirtyFlag;
    }

    public void resetPubCodeDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubCodeDesc();
            return;
        }
        this.pubcodedescDirtyFlag = false;
        this.pubcodedesc = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
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
        PSPFPubCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPubCodeBase pSPFPubCodeBase) {
        pSPFPubCodeBase.resetCLASSEXT();
        pSPFPubCodeBase.resetCodeEXT();
        pSPFPubCodeBase.resetCodeFolder();
        pSPFPubCodeBase.resetCodeFolder2();
        pSPFPubCodeBase.resetCreateDate();
        pSPFPubCodeBase.resetCreateMan();
        pSPFPubCodeBase.resetDynaModelFlag();
        pSPFPubCodeBase.resetDynaViewFlag();
        pSPFPubCodeBase.resetHasPSPFPubCode();
        pSPFPubCodeBase.resetMemo();
        pSPFPubCodeBase.resetPITemplCode();
        pSPFPubCodeBase.resetPITemplCode2();
        pSPFPubCodeBase.resetPKGName();
        pSPFPubCodeBase.resetPPSPFPubCodeId();
        pSPFPubCodeBase.resetPPSPFPubCodeName();
        pSPFPubCodeBase.resetPreviewCode();
        pSPFPubCodeBase.resetPreviewFlag();
        pSPFPubCodeBase.resetPSPFCodeFolderId();
        pSPFPubCodeBase.resetPSPFCodeFolderName();
        pSPFPubCodeBase.resetPSPFId();
        pSPFPubCodeBase.resetPSPFName();
        pSPFPubCodeBase.resetPSPFPubCodeId();
        pSPFPubCodeBase.resetPSPFPubCodeName();
        pSPFPubCodeBase.resetPubCodeDesc();
        pSPFPubCodeBase.resetTargetType();
        pSPFPubCodeBase.resetUpdateDate();
        pSPFPubCodeBase.resetUpdateMan();
        pSPFPubCodeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCLASSEXTDirty()) {
            hashMap.put(FIELD_CLASSEXT, this.getCLASSEXT());
        }
        if (!bl || this.isCodeEXTDirty()) {
            hashMap.put(FIELD_CODEEXT, this.getCodeEXT());
        }
        if (!bl || this.isCodeFolderDirty()) {
            hashMap.put(FIELD_CODEFOLDER, this.getCodeFolder());
        }
        if (!bl || this.isCodeFolder2Dirty()) {
            hashMap.put(FIELD_CODEFOLDER2, this.getCodeFolder2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDynaViewFlagDirty()) {
            hashMap.put(FIELD_DYNAVIEWFLAG, this.getDynaViewFlag());
        }
        if (!bl || this.isHasPSPFPubCodeDirty()) {
            hashMap.put(FIELD_HASPSPFPUBCODE, this.getHasPSPFPubCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPITemplCodeDirty()) {
            hashMap.put(FIELD_PITEMPLCODE, this.getPITemplCode());
        }
        if (!bl || this.isPITemplCode2Dirty()) {
            hashMap.put(FIELD_PITEMPLCODE2, this.getPITemplCode2());
        }
        if (!bl || this.isPKGNameDirty()) {
            hashMap.put(FIELD_PKGNAME, this.getPKGName());
        }
        if (!bl || this.isPPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PPSPFPUBCODEID, this.getPPSPFPubCodeId());
        }
        if (!bl || this.isPPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PPSPFPUBCODENAME, this.getPPSPFPubCodeName());
        }
        if (!bl || this.isPreviewCodeDirty()) {
            hashMap.put(FIELD_PREVIEWCODE, this.getPreviewCode());
        }
        if (!bl || this.isPreviewFlagDirty()) {
            hashMap.put(FIELD_PREVIEWFLAG, this.getPreviewFlag());
        }
        if (!bl || this.isPSPFCodeFolderIdDirty()) {
            hashMap.put(FIELD_PSPFCODEFOLDERID, this.getPSPFCodeFolderId());
        }
        if (!bl || this.isPSPFCodeFolderNameDirty()) {
            hashMap.put(FIELD_PSPFCODEFOLDERNAME, this.getPSPFCodeFolderName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isPubCodeDescDirty()) {
            hashMap.put(FIELD_PUBCODEDESC, this.getPubCodeDesc());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSPFPubCodeBase.get(this, n);
    }

    private static Object get(PSPFPubCodeBase pSPFPubCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubCodeBase.getCLASSEXT();
            }
            case 1: {
                return pSPFPubCodeBase.getCodeEXT();
            }
            case 2: {
                return pSPFPubCodeBase.getCodeFolder();
            }
            case 3: {
                return pSPFPubCodeBase.getCodeFolder2();
            }
            case 4: {
                return pSPFPubCodeBase.getCreateDate();
            }
            case 5: {
                return pSPFPubCodeBase.getCreateMan();
            }
            case 6: {
                return pSPFPubCodeBase.getDynaModelFlag();
            }
            case 7: {
                return pSPFPubCodeBase.getDynaViewFlag();
            }
            case 8: {
                return pSPFPubCodeBase.getHasPSPFPubCode();
            }
            case 9: {
                return pSPFPubCodeBase.getMemo();
            }
            case 10: {
                return pSPFPubCodeBase.getPITemplCode();
            }
            case 11: {
                return pSPFPubCodeBase.getPITemplCode2();
            }
            case 12: {
                return pSPFPubCodeBase.getPKGName();
            }
            case 13: {
                return pSPFPubCodeBase.getPPSPFPubCodeId();
            }
            case 14: {
                return pSPFPubCodeBase.getPPSPFPubCodeName();
            }
            case 15: {
                return pSPFPubCodeBase.getPreviewCode();
            }
            case 16: {
                return pSPFPubCodeBase.getPreviewFlag();
            }
            case 17: {
                return pSPFPubCodeBase.getPSPFCodeFolderId();
            }
            case 18: {
                return pSPFPubCodeBase.getPSPFCodeFolderName();
            }
            case 19: {
                return pSPFPubCodeBase.getPSPFId();
            }
            case 20: {
                return pSPFPubCodeBase.getPSPFName();
            }
            case 21: {
                return pSPFPubCodeBase.getPSPFPubCodeId();
            }
            case 22: {
                return pSPFPubCodeBase.getPSPFPubCodeName();
            }
            case 23: {
                return pSPFPubCodeBase.getPubCodeDesc();
            }
            case 24: {
                return pSPFPubCodeBase.getTargetType();
            }
            case 25: {
                return pSPFPubCodeBase.getUpdateDate();
            }
            case 26: {
                return pSPFPubCodeBase.getUpdateMan();
            }
            case 27: {
                return pSPFPubCodeBase.getValidFlag();
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
        PSPFPubCodeBase.set(this, n, object);
    }

    private static void set(PSPFPubCodeBase pSPFPubCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubCodeBase.setCLASSEXT(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFPubCodeBase.setCodeEXT(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPubCodeBase.setCodeFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPubCodeBase.setCodeFolder2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPubCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSPFPubCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPubCodeBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSPFPubCodeBase.setDynaViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSPFPubCodeBase.setHasPSPFPubCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSPFPubCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPubCodeBase.setPITemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPubCodeBase.setPITemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPubCodeBase.setPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPubCodeBase.setPPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPubCodeBase.setPPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPubCodeBase.setPreviewCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPubCodeBase.setPreviewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSPFPubCodeBase.setPSPFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFPubCodeBase.setPSPFCodeFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFPubCodeBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFPubCodeBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFPubCodeBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFPubCodeBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPFPubCodeBase.setPubCodeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPFPubCodeBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPFPubCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSPFPubCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSPFPubCodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFPubCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPubCodeBase pSPFPubCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubCodeBase.getCLASSEXT() == null;
            }
            case 1: {
                return pSPFPubCodeBase.getCodeEXT() == null;
            }
            case 2: {
                return pSPFPubCodeBase.getCodeFolder() == null;
            }
            case 3: {
                return pSPFPubCodeBase.getCodeFolder2() == null;
            }
            case 4: {
                return pSPFPubCodeBase.getCreateDate() == null;
            }
            case 5: {
                return pSPFPubCodeBase.getCreateMan() == null;
            }
            case 6: {
                return pSPFPubCodeBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSPFPubCodeBase.getDynaViewFlag() == null;
            }
            case 8: {
                return pSPFPubCodeBase.getHasPSPFPubCode() == null;
            }
            case 9: {
                return pSPFPubCodeBase.getMemo() == null;
            }
            case 10: {
                return pSPFPubCodeBase.getPITemplCode() == null;
            }
            case 11: {
                return pSPFPubCodeBase.getPITemplCode2() == null;
            }
            case 12: {
                return pSPFPubCodeBase.getPKGName() == null;
            }
            case 13: {
                return pSPFPubCodeBase.getPPSPFPubCodeId() == null;
            }
            case 14: {
                return pSPFPubCodeBase.getPPSPFPubCodeName() == null;
            }
            case 15: {
                return pSPFPubCodeBase.getPreviewCode() == null;
            }
            case 16: {
                return pSPFPubCodeBase.getPreviewFlag() == null;
            }
            case 17: {
                return pSPFPubCodeBase.getPSPFCodeFolderId() == null;
            }
            case 18: {
                return pSPFPubCodeBase.getPSPFCodeFolderName() == null;
            }
            case 19: {
                return pSPFPubCodeBase.getPSPFId() == null;
            }
            case 20: {
                return pSPFPubCodeBase.getPSPFName() == null;
            }
            case 21: {
                return pSPFPubCodeBase.getPSPFPubCodeId() == null;
            }
            case 22: {
                return pSPFPubCodeBase.getPSPFPubCodeName() == null;
            }
            case 23: {
                return pSPFPubCodeBase.getPubCodeDesc() == null;
            }
            case 24: {
                return pSPFPubCodeBase.getTargetType() == null;
            }
            case 25: {
                return pSPFPubCodeBase.getUpdateDate() == null;
            }
            case 26: {
                return pSPFPubCodeBase.getUpdateMan() == null;
            }
            case 27: {
                return pSPFPubCodeBase.getValidFlag() == null;
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
        return PSPFPubCodeBase.contains(this, n);
    }

    private static boolean contains(PSPFPubCodeBase pSPFPubCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPubCodeBase.isCLASSEXTDirty();
            }
            case 1: {
                return pSPFPubCodeBase.isCodeEXTDirty();
            }
            case 2: {
                return pSPFPubCodeBase.isCodeFolderDirty();
            }
            case 3: {
                return pSPFPubCodeBase.isCodeFolder2Dirty();
            }
            case 4: {
                return pSPFPubCodeBase.isCreateDateDirty();
            }
            case 5: {
                return pSPFPubCodeBase.isCreateManDirty();
            }
            case 6: {
                return pSPFPubCodeBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSPFPubCodeBase.isDynaViewFlagDirty();
            }
            case 8: {
                return pSPFPubCodeBase.isHasPSPFPubCodeDirty();
            }
            case 9: {
                return pSPFPubCodeBase.isMemoDirty();
            }
            case 10: {
                return pSPFPubCodeBase.isPITemplCodeDirty();
            }
            case 11: {
                return pSPFPubCodeBase.isPITemplCode2Dirty();
            }
            case 12: {
                return pSPFPubCodeBase.isPKGNameDirty();
            }
            case 13: {
                return pSPFPubCodeBase.isPPSPFPubCodeIdDirty();
            }
            case 14: {
                return pSPFPubCodeBase.isPPSPFPubCodeNameDirty();
            }
            case 15: {
                return pSPFPubCodeBase.isPreviewCodeDirty();
            }
            case 16: {
                return pSPFPubCodeBase.isPreviewFlagDirty();
            }
            case 17: {
                return pSPFPubCodeBase.isPSPFCodeFolderIdDirty();
            }
            case 18: {
                return pSPFPubCodeBase.isPSPFCodeFolderNameDirty();
            }
            case 19: {
                return pSPFPubCodeBase.isPSPFIdDirty();
            }
            case 20: {
                return pSPFPubCodeBase.isPSPFNameDirty();
            }
            case 21: {
                return pSPFPubCodeBase.isPSPFPubCodeIdDirty();
            }
            case 22: {
                return pSPFPubCodeBase.isPSPFPubCodeNameDirty();
            }
            case 23: {
                return pSPFPubCodeBase.isPubCodeDescDirty();
            }
            case 24: {
                return pSPFPubCodeBase.isTargetTypeDirty();
            }
            case 25: {
                return pSPFPubCodeBase.isUpdateDateDirty();
            }
            case 26: {
                return pSPFPubCodeBase.isUpdateManDirty();
            }
            case 27: {
                return pSPFPubCodeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPubCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPubCodeBase pSPFPubCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPubCodeBase.getCLASSEXT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"classext", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCLASSEXT()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getCodeEXT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeext", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCodeEXT()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getCodeFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codefolder", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCodeFolder()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getCodeFolder2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codefolder2", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCodeFolder2()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getDynaViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaviewflag", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getDynaViewFlag()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getHasPSPFPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"haspspfpubcode", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getHasPSPFPubCode()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPITemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pitemplcode", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPITemplCode()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPITemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pitemplcode2", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPITemplCode2()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgname", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPKGName()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspfpubcodeid", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspfpubcodename", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPreviewCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewcode", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPreviewCode()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPreviewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewflag", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPreviewFlag()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcodefolderid", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFCodeFolderId()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFCodeFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcodefoldername", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFCodeFolderName()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getPubCodeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcodedesc", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getPubCodeDesc()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getTargetType()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPubCodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFPubCodeBase.getJSONValue((Object)pSPFPubCodeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPubCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPubCodeBase pSPFPubCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPubCodeBase.getCLASSEXT() != null) {
            object = pSPFPubCodeBase.getCLASSEXT();
            xmlNode.setAttribute(FIELD_CLASSEXT, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPubCodeBase.getCodeEXT() != null) {
            object = pSPFPubCodeBase.getCodeEXT();
            xmlNode.setAttribute(FIELD_CODEEXT, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPubCodeBase.getCodeFolder() != null) {
            object = pSPFPubCodeBase.getCodeFolder();
            xmlNode.setAttribute(FIELD_CODEFOLDER, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPubCodeBase.getCodeFolder2() != null) {
            object = pSPFPubCodeBase.getCodeFolder2();
            xmlNode.setAttribute(FIELD_CODEFOLDER2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getCreateDate() != null) {
            object = pSPFPubCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getCreateMan() != null) {
            object = pSPFPubCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getDynaModelFlag() != null) {
            object = pSPFPubCodeBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getDynaViewFlag() != null) {
            object = pSPFPubCodeBase.getDynaViewFlag();
            xmlNode.setAttribute(FIELD_DYNAVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getHasPSPFPubCode() != null) {
            object = pSPFPubCodeBase.getHasPSPFPubCode();
            xmlNode.setAttribute(FIELD_HASPSPFPUBCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getMemo() != null) {
            object = pSPFPubCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPITemplCode() != null) {
            object = pSPFPubCodeBase.getPITemplCode();
            xmlNode.setAttribute(FIELD_PITEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPITemplCode2() != null) {
            object = pSPFPubCodeBase.getPITemplCode2();
            xmlNode.setAttribute(FIELD_PITEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPKGName() != null) {
            object = pSPFPubCodeBase.getPKGName();
            xmlNode.setAttribute(FIELD_PKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPPSPFPubCodeId() != null) {
            object = pSPFPubCodeBase.getPPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PPSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPPSPFPubCodeName() != null) {
            object = pSPFPubCodeBase.getPPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PPSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPreviewCode() != null) {
            object = pSPFPubCodeBase.getPreviewCode();
            xmlNode.setAttribute(FIELD_PREVIEWCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPreviewFlag() != null) {
            object = pSPFPubCodeBase.getPreviewFlag();
            xmlNode.setAttribute(FIELD_PREVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getPSPFCodeFolderId() != null) {
            object = pSPFPubCodeBase.getPSPFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSPFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPSPFCodeFolderName() != null) {
            object = pSPFPubCodeBase.getPSPFCodeFolderName();
            xmlNode.setAttribute(FIELD_PSPFCODEFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPSPFId() != null) {
            object = pSPFPubCodeBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPSPFName() != null) {
            object = pSPFPubCodeBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPSPFPubCodeId() != null) {
            object = pSPFPubCodeBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPSPFPubCodeName() != null) {
            object = pSPFPubCodeBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getPubCodeDesc() != null) {
            object = pSPFPubCodeBase.getPubCodeDesc();
            xmlNode.setAttribute(FIELD_PUBCODEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getTargetType() != null) {
            object = pSPFPubCodeBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getUpdateDate() != null) {
            object = pSPFPubCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPubCodeBase.getUpdateMan() != null) {
            object = pSPFPubCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPubCodeBase.getValidFlag() != null) {
            object = pSPFPubCodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPubCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPubCodeBase pSPFPubCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPubCodeBase.isCLASSEXTDirty() && (bl || pSPFPubCodeBase.getCLASSEXT() != null)) {
            iDataObject.set(FIELD_CLASSEXT, (Object)pSPFPubCodeBase.getCLASSEXT());
        }
        if (pSPFPubCodeBase.isCodeEXTDirty() && (bl || pSPFPubCodeBase.getCodeEXT() != null)) {
            iDataObject.set(FIELD_CODEEXT, (Object)pSPFPubCodeBase.getCodeEXT());
        }
        if (pSPFPubCodeBase.isCodeFolderDirty() && (bl || pSPFPubCodeBase.getCodeFolder() != null)) {
            iDataObject.set(FIELD_CODEFOLDER, (Object)pSPFPubCodeBase.getCodeFolder());
        }
        if (pSPFPubCodeBase.isCodeFolder2Dirty() && (bl || pSPFPubCodeBase.getCodeFolder2() != null)) {
            iDataObject.set(FIELD_CODEFOLDER2, (Object)pSPFPubCodeBase.getCodeFolder2());
        }
        if (pSPFPubCodeBase.isCreateDateDirty() && (bl || pSPFPubCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPubCodeBase.getCreateDate());
        }
        if (pSPFPubCodeBase.isCreateManDirty() && (bl || pSPFPubCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPubCodeBase.getCreateMan());
        }
        if (pSPFPubCodeBase.isDynaModelFlagDirty() && (bl || pSPFPubCodeBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSPFPubCodeBase.getDynaModelFlag());
        }
        if (pSPFPubCodeBase.isDynaViewFlagDirty() && (bl || pSPFPubCodeBase.getDynaViewFlag() != null)) {
            iDataObject.set(FIELD_DYNAVIEWFLAG, (Object)pSPFPubCodeBase.getDynaViewFlag());
        }
        if (pSPFPubCodeBase.isHasPSPFPubCodeDirty() && (bl || pSPFPubCodeBase.getHasPSPFPubCode() != null)) {
            iDataObject.set(FIELD_HASPSPFPUBCODE, (Object)pSPFPubCodeBase.getHasPSPFPubCode());
        }
        if (pSPFPubCodeBase.isMemoDirty() && (bl || pSPFPubCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPubCodeBase.getMemo());
        }
        if (pSPFPubCodeBase.isPITemplCodeDirty() && (bl || pSPFPubCodeBase.getPITemplCode() != null)) {
            iDataObject.set(FIELD_PITEMPLCODE, (Object)pSPFPubCodeBase.getPITemplCode());
        }
        if (pSPFPubCodeBase.isPITemplCode2Dirty() && (bl || pSPFPubCodeBase.getPITemplCode2() != null)) {
            iDataObject.set(FIELD_PITEMPLCODE2, (Object)pSPFPubCodeBase.getPITemplCode2());
        }
        if (pSPFPubCodeBase.isPKGNameDirty() && (bl || pSPFPubCodeBase.getPKGName() != null)) {
            iDataObject.set(FIELD_PKGNAME, (Object)pSPFPubCodeBase.getPKGName());
        }
        if (pSPFPubCodeBase.isPPSPFPubCodeIdDirty() && (bl || pSPFPubCodeBase.getPPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PPSPFPUBCODEID, (Object)pSPFPubCodeBase.getPPSPFPubCodeId());
        }
        if (pSPFPubCodeBase.isPPSPFPubCodeNameDirty() && (bl || pSPFPubCodeBase.getPPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PPSPFPUBCODENAME, (Object)pSPFPubCodeBase.getPPSPFPubCodeName());
        }
        if (pSPFPubCodeBase.isPreviewCodeDirty() && (bl || pSPFPubCodeBase.getPreviewCode() != null)) {
            iDataObject.set(FIELD_PREVIEWCODE, (Object)pSPFPubCodeBase.getPreviewCode());
        }
        if (pSPFPubCodeBase.isPreviewFlagDirty() && (bl || pSPFPubCodeBase.getPreviewFlag() != null)) {
            iDataObject.set(FIELD_PREVIEWFLAG, (Object)pSPFPubCodeBase.getPreviewFlag());
        }
        if (pSPFPubCodeBase.isPSPFCodeFolderIdDirty() && (bl || pSPFPubCodeBase.getPSPFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSPFCODEFOLDERID, (Object)pSPFPubCodeBase.getPSPFCodeFolderId());
        }
        if (pSPFPubCodeBase.isPSPFCodeFolderNameDirty() && (bl || pSPFPubCodeBase.getPSPFCodeFolderName() != null)) {
            iDataObject.set(FIELD_PSPFCODEFOLDERNAME, (Object)pSPFPubCodeBase.getPSPFCodeFolderName());
        }
        if (pSPFPubCodeBase.isPSPFIdDirty() && (bl || pSPFPubCodeBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPubCodeBase.getPSPFId());
        }
        if (pSPFPubCodeBase.isPSPFNameDirty() && (bl || pSPFPubCodeBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPubCodeBase.getPSPFName());
        }
        if (pSPFPubCodeBase.isPSPFPubCodeIdDirty() && (bl || pSPFPubCodeBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        }
        if (pSPFPubCodeBase.isPSPFPubCodeNameDirty() && (bl || pSPFPubCodeBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFPubCodeBase.getPSPFPubCodeName());
        }
        if (pSPFPubCodeBase.isPubCodeDescDirty() && (bl || pSPFPubCodeBase.getPubCodeDesc() != null)) {
            iDataObject.set(FIELD_PUBCODEDESC, (Object)pSPFPubCodeBase.getPubCodeDesc());
        }
        if (pSPFPubCodeBase.isTargetTypeDirty() && (bl || pSPFPubCodeBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSPFPubCodeBase.getTargetType());
        }
        if (pSPFPubCodeBase.isUpdateDateDirty() && (bl || pSPFPubCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPubCodeBase.getUpdateDate());
        }
        if (pSPFPubCodeBase.isUpdateManDirty() && (bl || pSPFPubCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPubCodeBase.getUpdateMan());
        }
        if (pSPFPubCodeBase.isValidFlagDirty() && (bl || pSPFPubCodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFPubCodeBase.getValidFlag());
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
        return PSPFPubCodeBase.remove(this, n);
    }

    private static boolean remove(PSPFPubCodeBase pSPFPubCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPubCodeBase.resetCLASSEXT();
                return true;
            }
            case 1: {
                pSPFPubCodeBase.resetCodeEXT();
                return true;
            }
            case 2: {
                pSPFPubCodeBase.resetCodeFolder();
                return true;
            }
            case 3: {
                pSPFPubCodeBase.resetCodeFolder2();
                return true;
            }
            case 4: {
                pSPFPubCodeBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSPFPubCodeBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSPFPubCodeBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSPFPubCodeBase.resetDynaViewFlag();
                return true;
            }
            case 8: {
                pSPFPubCodeBase.resetHasPSPFPubCode();
                return true;
            }
            case 9: {
                pSPFPubCodeBase.resetMemo();
                return true;
            }
            case 10: {
                pSPFPubCodeBase.resetPITemplCode();
                return true;
            }
            case 11: {
                pSPFPubCodeBase.resetPITemplCode2();
                return true;
            }
            case 12: {
                pSPFPubCodeBase.resetPKGName();
                return true;
            }
            case 13: {
                pSPFPubCodeBase.resetPPSPFPubCodeId();
                return true;
            }
            case 14: {
                pSPFPubCodeBase.resetPPSPFPubCodeName();
                return true;
            }
            case 15: {
                pSPFPubCodeBase.resetPreviewCode();
                return true;
            }
            case 16: {
                pSPFPubCodeBase.resetPreviewFlag();
                return true;
            }
            case 17: {
                pSPFPubCodeBase.resetPSPFCodeFolderId();
                return true;
            }
            case 18: {
                pSPFPubCodeBase.resetPSPFCodeFolderName();
                return true;
            }
            case 19: {
                pSPFPubCodeBase.resetPSPFId();
                return true;
            }
            case 20: {
                pSPFPubCodeBase.resetPSPFName();
                return true;
            }
            case 21: {
                pSPFPubCodeBase.resetPSPFPubCodeId();
                return true;
            }
            case 22: {
                pSPFPubCodeBase.resetPSPFPubCodeName();
                return true;
            }
            case 23: {
                pSPFPubCodeBase.resetPubCodeDesc();
                return true;
            }
            case 24: {
                pSPFPubCodeBase.resetTargetType();
                return true;
            }
            case 25: {
                pSPFPubCodeBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSPFPubCodeBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSPFPubCodeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFCodeFolder getPSPFCodeFolder() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCodeFolder();
        }
        if (this.getPSPFCodeFolderId() == null) {
            return null;
        }
        Integer n = this.objPSPFCodeFolderLock;
        synchronized (n) {
            if (this.pspfcodefolder != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFCodeFolderId(), (Object)this.pspfcodefolder.getPSPFCodeFolderId()) != 0L) {
                this.pspfcodefolder = null;
            }
            if (this.pspfcodefolder == null) {
                PSPFCodeFolder pSPFCodeFolder = new PSPFCodeFolder();
                pSPFCodeFolder.setPSPFCodeFolderId(this.getPSPFCodeFolderId());
                PSPFCodeFolderService pSPFCodeFolderService = (PSPFCodeFolderService)ServiceGlobal.getService(PSPFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
                pSPFCodeFolderService.autoGet(pSPFCodeFolder);
                this.pspfcodefolder = pSPFCodeFolder;
            }
            return this.pspfcodefolder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPFPubCode();
        }
        if (this.getPPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPPSPFPubCodeLock;
        synchronized (n) {
            if (this.ppspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPPSPFPubCodeId(), (Object)this.ppspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.ppspfpubcode = null;
            }
            if (this.ppspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet(pSPFPubCode);
                this.ppspfpubcode = pSPFPubCode;
            }
            return this.ppspfpubcode;
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

    private PSPFPubCodeBase getProxyEntity() {
        return this.proxyPSPFPubCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPubCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPubCodeBase) {
            this.proxyPSPFPubCodeBase = (PSPFPubCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLASSEXT, 0);
        fieldIndexMap.put(FIELD_CODEEXT, 1);
        fieldIndexMap.put(FIELD_CODEFOLDER, 2);
        fieldIndexMap.put(FIELD_CODEFOLDER2, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_DYNAVIEWFLAG, 7);
        fieldIndexMap.put(FIELD_HASPSPFPUBCODE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PITEMPLCODE, 10);
        fieldIndexMap.put(FIELD_PITEMPLCODE2, 11);
        fieldIndexMap.put(FIELD_PKGNAME, 12);
        fieldIndexMap.put(FIELD_PPSPFPUBCODEID, 13);
        fieldIndexMap.put(FIELD_PPSPFPUBCODENAME, 14);
        fieldIndexMap.put(FIELD_PREVIEWCODE, 15);
        fieldIndexMap.put(FIELD_PREVIEWFLAG, 16);
        fieldIndexMap.put(FIELD_PSPFCODEFOLDERID, 17);
        fieldIndexMap.put(FIELD_PSPFCODEFOLDERNAME, 18);
        fieldIndexMap.put(FIELD_PSPFID, 19);
        fieldIndexMap.put(FIELD_PSPFNAME, 20);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 21);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 22);
        fieldIndexMap.put(FIELD_PUBCODEDESC, 23);
        fieldIndexMap.put(FIELD_TARGETTYPE, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

