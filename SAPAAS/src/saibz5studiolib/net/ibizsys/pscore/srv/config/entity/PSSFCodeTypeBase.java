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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTempl;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFCodeTypeBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CODETEMPL = "CODETEMPL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEBUGMODE = "DEBUGMODE";
    public static final String FIELD_DEFAULTPUB = "DEFAULTPUB";
    public static final String FIELD_FILEEXT = "FILEEXT";
    public static final String FIELD_FILENAME = "FILENAME";
    public static final String FIELD_FULLCODENAME = "FULLCODENAME";
    public static final String FIELD_GLOBALFLAG = "GLOBALFLAG";
    public static final String FIELD_HEADERCODE = "HEADERCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELLIST = "MODELLIST";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String FIELD_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String FIELD_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String FIELD_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_SECURITYTEMPL = "SECURITYTEMPL";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODEPATH = 0;
    private static final int INDEX_CODETEMPL = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEBUGMODE = 4;
    private static final int INDEX_DEFAULTPUB = 5;
    private static final int INDEX_FILEEXT = 6;
    private static final int INDEX_FILENAME = 7;
    private static final int INDEX_FULLCODENAME = 8;
    private static final int INDEX_GLOBALFLAG = 9;
    private static final int INDEX_HEADERCODE = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_MODELLIST = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_PSMODELID = 14;
    private static final int INDEX_PSMODELNAME = 15;
    private static final int INDEX_PSSFCODEFOLDERID = 16;
    private static final int INDEX_PSSFCODEFOLDERNAME = 17;
    private static final int INDEX_PSSFCODETYPEID = 18;
    private static final int INDEX_PSSFCODETYPENAME = 19;
    private static final int INDEX_PSSFSTYLEID = 20;
    private static final int INDEX_PSSFSTYLENAME = 21;
    private static final int INDEX_PUBOBJ = 22;
    private static final int INDEX_SECURITYTEMPL = 23;
    private static final int INDEX_TEMPLCODE2 = 24;
    private static final int INDEX_TEMPLDESC = 25;
    private static final int INDEX_TYPECODE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFCodeTypeBase proxyPSSFCodeTypeBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean codetemplDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean debugmodeDirtyFlag = false;
    private boolean defaultpubDirtyFlag = false;
    private boolean fileextDirtyFlag = false;
    private boolean filenameDirtyFlag = false;
    private boolean fullcodenameDirtyFlag = false;
    private boolean globalflagDirtyFlag = false;
    private boolean headercodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modellistDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean pssfcodefolderidDirtyFlag = false;
    private boolean pssfcodefoldernameDirtyFlag = false;
    private boolean pssfcodetypeidDirtyFlag = false;
    private boolean pssfcodetypenameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean securitytemplDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codepath")
    private String codepath;
    @Column(name="codetempl")
    private String codetempl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="debugmode")
    private Integer debugmode;
    @Column(name="defaultpub")
    private Integer defaultpub;
    @Column(name="fileext")
    private String fileext;
    @Column(name="filename")
    private String filename;
    @Column(name="fullcodename")
    private String fullcodename;
    @Column(name="globalflag")
    private Integer globalflag;
    @Column(name="headercode")
    private String headercode;
    @Column(name="memo")
    private String memo;
    @Column(name="modellist")
    private String modellist;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="pssfcodefolderid")
    private String pssfcodefolderid;
    @Column(name="pssfcodefoldername")
    private String pssfcodefoldername;
    @Column(name="pssfcodetypeid")
    private String pssfcodetypeid;
    @Column(name="pssfcodetypename")
    private String pssfcodetypename;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="securitytempl")
    private Integer securitytempl;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="typecode")
    private String typecode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;
    private Integer objPSSFCodeFolderLock = new Integer(1);
    private PSSFCodeFolder pssfcodefolder = null;
    private Integer objPSSFCodeTemplsLock = new Integer(1);
    private ArrayList<PSSFCodeTempl> pssfcodetempls = null;

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

    public void setCodeTempl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeTempl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codetempl = string;
        this.codetemplDirtyFlag = true;
    }

    public String getCodeTempl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeTempl();
        }
        return this.codetempl;
    }

    public boolean isCodeTemplDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeTemplDirty();
        }
        return this.codetemplDirtyFlag;
    }

    public void resetCodeTempl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeTempl();
            return;
        }
        this.codetemplDirtyFlag = false;
        this.codetempl = null;
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

    public void setDebugMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDebugMode(n);
            return;
        }
        this.debugmode = n;
        this.debugmodeDirtyFlag = true;
    }

    public Integer getDebugMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDebugMode();
        }
        return this.debugmode;
    }

    public boolean isDebugModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDebugModeDirty();
        }
        return this.debugmodeDirtyFlag;
    }

    public void resetDebugMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDebugMode();
            return;
        }
        this.debugmodeDirtyFlag = false;
        this.debugmode = null;
    }

    public void setDefaultPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPub(n);
            return;
        }
        this.defaultpub = n;
        this.defaultpubDirtyFlag = true;
    }

    public Integer getDefaultPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPub();
        }
        return this.defaultpub;
    }

    public boolean isDefaultPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPubDirty();
        }
        return this.defaultpubDirtyFlag;
    }

    public void resetDefaultPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPub();
            return;
        }
        this.defaultpubDirtyFlag = false;
        this.defaultpub = null;
    }

    public void setFileExt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileExt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fileext = string;
        this.fileextDirtyFlag = true;
    }

    public String getFileExt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileExt();
        }
        return this.fileext;
    }

    public boolean isFileExtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileExtDirty();
        }
        return this.fileextDirtyFlag;
    }

    public void resetFileExt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileExt();
            return;
        }
        this.fileextDirtyFlag = false;
        this.fileext = null;
    }

    public void setFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filename = string;
        this.filenameDirtyFlag = true;
    }

    public String getFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileName();
        }
        return this.filename;
    }

    public boolean isFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileNameDirty();
        }
        return this.filenameDirtyFlag;
    }

    public void resetFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileName();
            return;
        }
        this.filenameDirtyFlag = false;
        this.filename = null;
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

    public void setGlobalFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalFlag(n);
            return;
        }
        this.globalflag = n;
        this.globalflagDirtyFlag = true;
    }

    public Integer getGlobalFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalFlag();
        }
        return this.globalflag;
    }

    public boolean isGlobalFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalFlagDirty();
        }
        return this.globalflagDirtyFlag;
    }

    public void resetGlobalFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalFlag();
            return;
        }
        this.globalflagDirtyFlag = false;
        this.globalflag = null;
    }

    public void setHeaderCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headercode = string;
        this.headercodeDirtyFlag = true;
    }

    public String getHeaderCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderCode();
        }
        return this.headercode;
    }

    public boolean isHeaderCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderCodeDirty();
        }
        return this.headercodeDirtyFlag;
    }

    public void resetHeaderCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderCode();
            return;
        }
        this.headercodeDirtyFlag = false;
        this.headercode = null;
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

    public void setModelList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modellist = string;
        this.modellistDirtyFlag = true;
    }

    public String getModelList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelList();
        }
        return this.modellist;
    }

    public boolean isModelListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelListDirty();
        }
        return this.modellistDirtyFlag;
    }

    public void resetModelList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelList();
            return;
        }
        this.modellistDirtyFlag = false;
        this.modellist = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setSecurityTempl(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecurityTempl(n);
            return;
        }
        this.securitytempl = n;
        this.securitytemplDirtyFlag = true;
    }

    public Integer getSecurityTempl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecurityTempl();
        }
        return this.securitytempl;
    }

    public boolean isSecurityTemplDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecurityTemplDirty();
        }
        return this.securitytemplDirtyFlag;
    }

    public void resetSecurityTempl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecurityTempl();
            return;
        }
        this.securitytemplDirtyFlag = false;
        this.securitytempl = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
    }

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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
        PSSFCodeTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFCodeTypeBase pSSFCodeTypeBase) {
        pSSFCodeTypeBase.resetCodePath();
        pSSFCodeTypeBase.resetCodeTempl();
        pSSFCodeTypeBase.resetCreateDate();
        pSSFCodeTypeBase.resetCreateMan();
        pSSFCodeTypeBase.resetDebugMode();
        pSSFCodeTypeBase.resetDefaultPub();
        pSSFCodeTypeBase.resetFileExt();
        pSSFCodeTypeBase.resetFileName();
        pSSFCodeTypeBase.resetFullCodeName();
        pSSFCodeTypeBase.resetGlobalFlag();
        pSSFCodeTypeBase.resetHeaderCode();
        pSSFCodeTypeBase.resetMemo();
        pSSFCodeTypeBase.resetModelList();
        pSSFCodeTypeBase.resetOrderValue();
        pSSFCodeTypeBase.resetPSModelId();
        pSSFCodeTypeBase.resetPSModelName();
        pSSFCodeTypeBase.resetPSSFCodeFolderId();
        pSSFCodeTypeBase.resetPSSFCodeFolderName();
        pSSFCodeTypeBase.resetPSSFCodeTypeId();
        pSSFCodeTypeBase.resetPSSFCodeTypeName();
        pSSFCodeTypeBase.resetPSSFStyleId();
        pSSFCodeTypeBase.resetPSSFStyleName();
        pSSFCodeTypeBase.resetPubObj();
        pSSFCodeTypeBase.resetSecurityTempl();
        pSSFCodeTypeBase.resetTemplCode2();
        pSSFCodeTypeBase.resetTemplDesc();
        pSSFCodeTypeBase.resetTypeCode();
        pSSFCodeTypeBase.resetUpdateDate();
        pSSFCodeTypeBase.resetUpdateMan();
        pSSFCodeTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodePathDirty()) {
            hashMap.put(FIELD_CODEPATH, this.getCodePath());
        }
        if (!bl || this.isCodeTemplDirty()) {
            hashMap.put(FIELD_CODETEMPL, this.getCodeTempl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDebugModeDirty()) {
            hashMap.put(FIELD_DEBUGMODE, this.getDebugMode());
        }
        if (!bl || this.isDefaultPubDirty()) {
            hashMap.put(FIELD_DEFAULTPUB, this.getDefaultPub());
        }
        if (!bl || this.isFileExtDirty()) {
            hashMap.put(FIELD_FILEEXT, this.getFileExt());
        }
        if (!bl || this.isFileNameDirty()) {
            hashMap.put(FIELD_FILENAME, this.getFileName());
        }
        if (!bl || this.isFullCodeNameDirty()) {
            hashMap.put(FIELD_FULLCODENAME, this.getFullCodeName());
        }
        if (!bl || this.isGlobalFlagDirty()) {
            hashMap.put(FIELD_GLOBALFLAG, this.getGlobalFlag());
        }
        if (!bl || this.isHeaderCodeDirty()) {
            hashMap.put(FIELD_HEADERCODE, this.getHeaderCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelListDirty()) {
            hashMap.put(FIELD_MODELLIST, this.getModelList());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
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
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isSecurityTemplDirty()) {
            hashMap.put(FIELD_SECURITYTEMPL, this.getSecurityTempl());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
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
        return PSSFCodeTypeBase.get(this, n);
    }

    private static Object get(PSSFCodeTypeBase pSSFCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTypeBase.getCodePath();
            }
            case 1: {
                return pSSFCodeTypeBase.getCodeTempl();
            }
            case 2: {
                return pSSFCodeTypeBase.getCreateDate();
            }
            case 3: {
                return pSSFCodeTypeBase.getCreateMan();
            }
            case 4: {
                return pSSFCodeTypeBase.getDebugMode();
            }
            case 5: {
                return pSSFCodeTypeBase.getDefaultPub();
            }
            case 6: {
                return pSSFCodeTypeBase.getFileExt();
            }
            case 7: {
                return pSSFCodeTypeBase.getFileName();
            }
            case 8: {
                return pSSFCodeTypeBase.getFullCodeName();
            }
            case 9: {
                return pSSFCodeTypeBase.getGlobalFlag();
            }
            case 10: {
                return pSSFCodeTypeBase.getHeaderCode();
            }
            case 11: {
                return pSSFCodeTypeBase.getMemo();
            }
            case 12: {
                return pSSFCodeTypeBase.getModelList();
            }
            case 13: {
                return pSSFCodeTypeBase.getOrderValue();
            }
            case 14: {
                return pSSFCodeTypeBase.getPSModelId();
            }
            case 15: {
                return pSSFCodeTypeBase.getPSModelName();
            }
            case 16: {
                return pSSFCodeTypeBase.getPSSFCodeFolderId();
            }
            case 17: {
                return pSSFCodeTypeBase.getPSSFCodeFolderName();
            }
            case 18: {
                return pSSFCodeTypeBase.getPSSFCodeTypeId();
            }
            case 19: {
                return pSSFCodeTypeBase.getPSSFCodeTypeName();
            }
            case 20: {
                return pSSFCodeTypeBase.getPSSFStyleId();
            }
            case 21: {
                return pSSFCodeTypeBase.getPSSFStyleName();
            }
            case 22: {
                return pSSFCodeTypeBase.getPubObj();
            }
            case 23: {
                return pSSFCodeTypeBase.getSecurityTempl();
            }
            case 24: {
                return pSSFCodeTypeBase.getTemplCode2();
            }
            case 25: {
                return pSSFCodeTypeBase.getTemplDesc();
            }
            case 26: {
                return pSSFCodeTypeBase.getTypeCode();
            }
            case 27: {
                return pSSFCodeTypeBase.getUpdateDate();
            }
            case 28: {
                return pSSFCodeTypeBase.getUpdateMan();
            }
            case 29: {
                return pSSFCodeTypeBase.getValidFlag();
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
        PSSFCodeTypeBase.set(this, n, object);
    }

    private static void set(PSSFCodeTypeBase pSSFCodeTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeTypeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFCodeTypeBase.setCodeTempl(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFCodeTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSFCodeTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFCodeTypeBase.setDebugMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSFCodeTypeBase.setDefaultPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFCodeTypeBase.setFileExt(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFCodeTypeBase.setFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFCodeTypeBase.setFullCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFCodeTypeBase.setGlobalFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSFCodeTypeBase.setHeaderCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFCodeTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFCodeTypeBase.setModelList(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFCodeTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSFCodeTypeBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFCodeTypeBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFCodeTypeBase.setPSSFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSFCodeTypeBase.setPSSFCodeFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFCodeTypeBase.setPSSFCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSFCodeTypeBase.setPSSFCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSFCodeTypeBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSFCodeTypeBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSFCodeTypeBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSFCodeTypeBase.setSecurityTempl(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSFCodeTypeBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSFCodeTypeBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSFCodeTypeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSFCodeTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSFCodeTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSFCodeTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFCodeTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSFCodeTypeBase pSSFCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTypeBase.getCodePath() == null;
            }
            case 1: {
                return pSSFCodeTypeBase.getCodeTempl() == null;
            }
            case 2: {
                return pSSFCodeTypeBase.getCreateDate() == null;
            }
            case 3: {
                return pSSFCodeTypeBase.getCreateMan() == null;
            }
            case 4: {
                return pSSFCodeTypeBase.getDebugMode() == null;
            }
            case 5: {
                return pSSFCodeTypeBase.getDefaultPub() == null;
            }
            case 6: {
                return pSSFCodeTypeBase.getFileExt() == null;
            }
            case 7: {
                return pSSFCodeTypeBase.getFileName() == null;
            }
            case 8: {
                return pSSFCodeTypeBase.getFullCodeName() == null;
            }
            case 9: {
                return pSSFCodeTypeBase.getGlobalFlag() == null;
            }
            case 10: {
                return pSSFCodeTypeBase.getHeaderCode() == null;
            }
            case 11: {
                return pSSFCodeTypeBase.getMemo() == null;
            }
            case 12: {
                return pSSFCodeTypeBase.getModelList() == null;
            }
            case 13: {
                return pSSFCodeTypeBase.getOrderValue() == null;
            }
            case 14: {
                return pSSFCodeTypeBase.getPSModelId() == null;
            }
            case 15: {
                return pSSFCodeTypeBase.getPSModelName() == null;
            }
            case 16: {
                return pSSFCodeTypeBase.getPSSFCodeFolderId() == null;
            }
            case 17: {
                return pSSFCodeTypeBase.getPSSFCodeFolderName() == null;
            }
            case 18: {
                return pSSFCodeTypeBase.getPSSFCodeTypeId() == null;
            }
            case 19: {
                return pSSFCodeTypeBase.getPSSFCodeTypeName() == null;
            }
            case 20: {
                return pSSFCodeTypeBase.getPSSFStyleId() == null;
            }
            case 21: {
                return pSSFCodeTypeBase.getPSSFStyleName() == null;
            }
            case 22: {
                return pSSFCodeTypeBase.getPubObj() == null;
            }
            case 23: {
                return pSSFCodeTypeBase.getSecurityTempl() == null;
            }
            case 24: {
                return pSSFCodeTypeBase.getTemplCode2() == null;
            }
            case 25: {
                return pSSFCodeTypeBase.getTemplDesc() == null;
            }
            case 26: {
                return pSSFCodeTypeBase.getTypeCode() == null;
            }
            case 27: {
                return pSSFCodeTypeBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSFCodeTypeBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSFCodeTypeBase.getValidFlag() == null;
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
        return PSSFCodeTypeBase.contains(this, n);
    }

    private static boolean contains(PSSFCodeTypeBase pSSFCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTypeBase.isCodePathDirty();
            }
            case 1: {
                return pSSFCodeTypeBase.isCodeTemplDirty();
            }
            case 2: {
                return pSSFCodeTypeBase.isCreateDateDirty();
            }
            case 3: {
                return pSSFCodeTypeBase.isCreateManDirty();
            }
            case 4: {
                return pSSFCodeTypeBase.isDebugModeDirty();
            }
            case 5: {
                return pSSFCodeTypeBase.isDefaultPubDirty();
            }
            case 6: {
                return pSSFCodeTypeBase.isFileExtDirty();
            }
            case 7: {
                return pSSFCodeTypeBase.isFileNameDirty();
            }
            case 8: {
                return pSSFCodeTypeBase.isFullCodeNameDirty();
            }
            case 9: {
                return pSSFCodeTypeBase.isGlobalFlagDirty();
            }
            case 10: {
                return pSSFCodeTypeBase.isHeaderCodeDirty();
            }
            case 11: {
                return pSSFCodeTypeBase.isMemoDirty();
            }
            case 12: {
                return pSSFCodeTypeBase.isModelListDirty();
            }
            case 13: {
                return pSSFCodeTypeBase.isOrderValueDirty();
            }
            case 14: {
                return pSSFCodeTypeBase.isPSModelIdDirty();
            }
            case 15: {
                return pSSFCodeTypeBase.isPSModelNameDirty();
            }
            case 16: {
                return pSSFCodeTypeBase.isPSSFCodeFolderIdDirty();
            }
            case 17: {
                return pSSFCodeTypeBase.isPSSFCodeFolderNameDirty();
            }
            case 18: {
                return pSSFCodeTypeBase.isPSSFCodeTypeIdDirty();
            }
            case 19: {
                return pSSFCodeTypeBase.isPSSFCodeTypeNameDirty();
            }
            case 20: {
                return pSSFCodeTypeBase.isPSSFStyleIdDirty();
            }
            case 21: {
                return pSSFCodeTypeBase.isPSSFStyleNameDirty();
            }
            case 22: {
                return pSSFCodeTypeBase.isPubObjDirty();
            }
            case 23: {
                return pSSFCodeTypeBase.isSecurityTemplDirty();
            }
            case 24: {
                return pSSFCodeTypeBase.isTemplCode2Dirty();
            }
            case 25: {
                return pSSFCodeTypeBase.isTemplDescDirty();
            }
            case 26: {
                return pSSFCodeTypeBase.isTypeCodeDirty();
            }
            case 27: {
                return pSSFCodeTypeBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSFCodeTypeBase.isUpdateManDirty();
            }
            case 29: {
                return pSSFCodeTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFCodeTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFCodeTypeBase pSSFCodeTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFCodeTypeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getCodeTempl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetempl", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getCodeTempl()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getDebugMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"debugmode", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getDebugMode()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getDefaultPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpub", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getDefaultPub()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getFileExt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileext", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getFileExt()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filename", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getFileName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getFullCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcodename", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getFullCodeName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getGlobalFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globalflag", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getGlobalFlag()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getHeaderCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercode", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getHeaderCode()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getModelList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modellist", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getModelList()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefolderid", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFCodeFolderId()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefoldername", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFCodeFolderName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypeid", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFCodeTypeId()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypename", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFCodeTypeName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getPubObj()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getSecurityTempl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"securitytempl", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getSecurityTempl()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFCodeTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFCodeTypeBase.getJSONValue((Object)pSSFCodeTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFCodeTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFCodeTypeBase pSSFCodeTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFCodeTypeBase.getCodePath() != null) {
            object = pSSFCodeTypeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSSFCodeTypeBase.getCodeTempl() != null) {
            object = pSSFCodeTypeBase.getCodeTempl();
            xmlNode.setAttribute(FIELD_CODETEMPL, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getCreateDate() != null) {
            object = pSSFCodeTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getCreateMan() != null) {
            object = pSSFCodeTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getDebugMode() != null) {
            object = pSSFCodeTypeBase.getDebugMode();
            xmlNode.setAttribute(FIELD_DEBUGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getDefaultPub() != null) {
            object = pSSFCodeTypeBase.getDefaultPub();
            xmlNode.setAttribute(FIELD_DEFAULTPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getFileExt() != null) {
            object = pSSFCodeTypeBase.getFileExt();
            xmlNode.setAttribute(FIELD_FILEEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getFileName() != null) {
            object = pSSFCodeTypeBase.getFileName();
            xmlNode.setAttribute(FIELD_FILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getFullCodeName() != null) {
            object = pSSFCodeTypeBase.getFullCodeName();
            xmlNode.setAttribute(FIELD_FULLCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getGlobalFlag() != null) {
            object = pSSFCodeTypeBase.getGlobalFlag();
            xmlNode.setAttribute(FIELD_GLOBALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getHeaderCode() != null) {
            object = pSSFCodeTypeBase.getHeaderCode();
            xmlNode.setAttribute(FIELD_HEADERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getMemo() != null) {
            object = pSSFCodeTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getModelList() != null) {
            object = pSSFCodeTypeBase.getModelList();
            xmlNode.setAttribute(FIELD_MODELLIST, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getOrderValue() != null) {
            object = pSSFCodeTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getPSModelId() != null) {
            object = pSSFCodeTypeBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSModelName() != null) {
            object = pSSFCodeTypeBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeFolderId() != null) {
            object = pSSFCodeTypeBase.getPSSFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeFolderName() != null) {
            object = pSSFCodeTypeBase.getPSSFCodeFolderName();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeTypeId() != null) {
            object = pSSFCodeTypeBase.getPSSFCodeTypeId();
            xmlNode.setAttribute(FIELD_PSSFCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFCodeTypeName() != null) {
            object = pSSFCodeTypeBase.getPSSFCodeTypeName();
            xmlNode.setAttribute(FIELD_PSSFCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFStyleId() != null) {
            object = pSSFCodeTypeBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPSSFStyleName() != null) {
            object = pSSFCodeTypeBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getPubObj() != null) {
            object = pSSFCodeTypeBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getSecurityTempl() != null) {
            object = pSSFCodeTypeBase.getSecurityTempl();
            xmlNode.setAttribute(FIELD_SECURITYTEMPL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getTemplCode2() != null) {
            object = pSSFCodeTypeBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getTemplDesc() != null) {
            object = pSSFCodeTypeBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getTypeCode() != null) {
            object = pSSFCodeTypeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getUpdateDate() != null) {
            object = pSSFCodeTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeTypeBase.getUpdateMan() != null) {
            object = pSSFCodeTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTypeBase.getValidFlag() != null) {
            object = pSSFCodeTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFCodeTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFCodeTypeBase pSSFCodeTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFCodeTypeBase.isCodePathDirty() && (bl || pSSFCodeTypeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSSFCodeTypeBase.getCodePath());
        }
        if (pSSFCodeTypeBase.isCodeTemplDirty() && (bl || pSSFCodeTypeBase.getCodeTempl() != null)) {
            iDataObject.set(FIELD_CODETEMPL, (Object)pSSFCodeTypeBase.getCodeTempl());
        }
        if (pSSFCodeTypeBase.isCreateDateDirty() && (bl || pSSFCodeTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFCodeTypeBase.getCreateDate());
        }
        if (pSSFCodeTypeBase.isCreateManDirty() && (bl || pSSFCodeTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFCodeTypeBase.getCreateMan());
        }
        if (pSSFCodeTypeBase.isDebugModeDirty() && (bl || pSSFCodeTypeBase.getDebugMode() != null)) {
            iDataObject.set(FIELD_DEBUGMODE, (Object)pSSFCodeTypeBase.getDebugMode());
        }
        if (pSSFCodeTypeBase.isDefaultPubDirty() && (bl || pSSFCodeTypeBase.getDefaultPub() != null)) {
            iDataObject.set(FIELD_DEFAULTPUB, (Object)pSSFCodeTypeBase.getDefaultPub());
        }
        if (pSSFCodeTypeBase.isFileExtDirty() && (bl || pSSFCodeTypeBase.getFileExt() != null)) {
            iDataObject.set(FIELD_FILEEXT, (Object)pSSFCodeTypeBase.getFileExt());
        }
        if (pSSFCodeTypeBase.isFileNameDirty() && (bl || pSSFCodeTypeBase.getFileName() != null)) {
            iDataObject.set(FIELD_FILENAME, (Object)pSSFCodeTypeBase.getFileName());
        }
        if (pSSFCodeTypeBase.isFullCodeNameDirty() && (bl || pSSFCodeTypeBase.getFullCodeName() != null)) {
            iDataObject.set(FIELD_FULLCODENAME, (Object)pSSFCodeTypeBase.getFullCodeName());
        }
        if (pSSFCodeTypeBase.isGlobalFlagDirty() && (bl || pSSFCodeTypeBase.getGlobalFlag() != null)) {
            iDataObject.set(FIELD_GLOBALFLAG, (Object)pSSFCodeTypeBase.getGlobalFlag());
        }
        if (pSSFCodeTypeBase.isHeaderCodeDirty() && (bl || pSSFCodeTypeBase.getHeaderCode() != null)) {
            iDataObject.set(FIELD_HEADERCODE, (Object)pSSFCodeTypeBase.getHeaderCode());
        }
        if (pSSFCodeTypeBase.isMemoDirty() && (bl || pSSFCodeTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFCodeTypeBase.getMemo());
        }
        if (pSSFCodeTypeBase.isModelListDirty() && (bl || pSSFCodeTypeBase.getModelList() != null)) {
            iDataObject.set(FIELD_MODELLIST, (Object)pSSFCodeTypeBase.getModelList());
        }
        if (pSSFCodeTypeBase.isOrderValueDirty() && (bl || pSSFCodeTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSFCodeTypeBase.getOrderValue());
        }
        if (pSSFCodeTypeBase.isPSModelIdDirty() && (bl || pSSFCodeTypeBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSSFCodeTypeBase.getPSModelId());
        }
        if (pSSFCodeTypeBase.isPSModelNameDirty() && (bl || pSSFCodeTypeBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSSFCodeTypeBase.getPSModelName());
        }
        if (pSSFCodeTypeBase.isPSSFCodeFolderIdDirty() && (bl || pSSFCodeTypeBase.getPSSFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERID, (Object)pSSFCodeTypeBase.getPSSFCodeFolderId());
        }
        if (pSSFCodeTypeBase.isPSSFCodeFolderNameDirty() && (bl || pSSFCodeTypeBase.getPSSFCodeFolderName() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERNAME, (Object)pSSFCodeTypeBase.getPSSFCodeFolderName());
        }
        if (pSSFCodeTypeBase.isPSSFCodeTypeIdDirty() && (bl || pSSFCodeTypeBase.getPSSFCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPEID, (Object)pSSFCodeTypeBase.getPSSFCodeTypeId());
        }
        if (pSSFCodeTypeBase.isPSSFCodeTypeNameDirty() && (bl || pSSFCodeTypeBase.getPSSFCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPENAME, (Object)pSSFCodeTypeBase.getPSSFCodeTypeName());
        }
        if (pSSFCodeTypeBase.isPSSFStyleIdDirty() && (bl || pSSFCodeTypeBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFCodeTypeBase.getPSSFStyleId());
        }
        if (pSSFCodeTypeBase.isPSSFStyleNameDirty() && (bl || pSSFCodeTypeBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFCodeTypeBase.getPSSFStyleName());
        }
        if (pSSFCodeTypeBase.isPubObjDirty() && (bl || pSSFCodeTypeBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSSFCodeTypeBase.getPubObj());
        }
        if (pSSFCodeTypeBase.isSecurityTemplDirty() && (bl || pSSFCodeTypeBase.getSecurityTempl() != null)) {
            iDataObject.set(FIELD_SECURITYTEMPL, (Object)pSSFCodeTypeBase.getSecurityTempl());
        }
        if (pSSFCodeTypeBase.isTemplCode2Dirty() && (bl || pSSFCodeTypeBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSFCodeTypeBase.getTemplCode2());
        }
        if (pSSFCodeTypeBase.isTemplDescDirty() && (bl || pSSFCodeTypeBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSSFCodeTypeBase.getTemplDesc());
        }
        if (pSSFCodeTypeBase.isTypeCodeDirty() && (bl || pSSFCodeTypeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSSFCodeTypeBase.getTypeCode());
        }
        if (pSSFCodeTypeBase.isUpdateDateDirty() && (bl || pSSFCodeTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFCodeTypeBase.getUpdateDate());
        }
        if (pSSFCodeTypeBase.isUpdateManDirty() && (bl || pSSFCodeTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFCodeTypeBase.getUpdateMan());
        }
        if (pSSFCodeTypeBase.isValidFlagDirty() && (bl || pSSFCodeTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFCodeTypeBase.getValidFlag());
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
        return PSSFCodeTypeBase.remove(this, n);
    }

    private static boolean remove(PSSFCodeTypeBase pSSFCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeTypeBase.resetCodePath();
                return true;
            }
            case 1: {
                pSSFCodeTypeBase.resetCodeTempl();
                return true;
            }
            case 2: {
                pSSFCodeTypeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSFCodeTypeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSFCodeTypeBase.resetDebugMode();
                return true;
            }
            case 5: {
                pSSFCodeTypeBase.resetDefaultPub();
                return true;
            }
            case 6: {
                pSSFCodeTypeBase.resetFileExt();
                return true;
            }
            case 7: {
                pSSFCodeTypeBase.resetFileName();
                return true;
            }
            case 8: {
                pSSFCodeTypeBase.resetFullCodeName();
                return true;
            }
            case 9: {
                pSSFCodeTypeBase.resetGlobalFlag();
                return true;
            }
            case 10: {
                pSSFCodeTypeBase.resetHeaderCode();
                return true;
            }
            case 11: {
                pSSFCodeTypeBase.resetMemo();
                return true;
            }
            case 12: {
                pSSFCodeTypeBase.resetModelList();
                return true;
            }
            case 13: {
                pSSFCodeTypeBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSSFCodeTypeBase.resetPSModelId();
                return true;
            }
            case 15: {
                pSSFCodeTypeBase.resetPSModelName();
                return true;
            }
            case 16: {
                pSSFCodeTypeBase.resetPSSFCodeFolderId();
                return true;
            }
            case 17: {
                pSSFCodeTypeBase.resetPSSFCodeFolderName();
                return true;
            }
            case 18: {
                pSSFCodeTypeBase.resetPSSFCodeTypeId();
                return true;
            }
            case 19: {
                pSSFCodeTypeBase.resetPSSFCodeTypeName();
                return true;
            }
            case 20: {
                pSSFCodeTypeBase.resetPSSFStyleId();
                return true;
            }
            case 21: {
                pSSFCodeTypeBase.resetPSSFStyleName();
                return true;
            }
            case 22: {
                pSSFCodeTypeBase.resetPubObj();
                return true;
            }
            case 23: {
                pSSFCodeTypeBase.resetSecurityTempl();
                return true;
            }
            case 24: {
                pSSFCodeTypeBase.resetTemplCode2();
                return true;
            }
            case 25: {
                pSSFCodeTypeBase.resetTemplDesc();
                return true;
            }
            case 26: {
                pSSFCodeTypeBase.resetTypeCode();
                return true;
            }
            case 27: {
                pSSFCodeTypeBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSFCodeTypeBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSFCodeTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
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
    public ArrayList<PSSFCodeTempl> getPSSFCodeTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTempls();
        }
        if (this.getPSSFCodeTypeId() == null) {
            return null;
        }
        PSSFCodeTemplService pSSFCodeTemplService = (PSSFCodeTemplService)ServiceGlobal.getService(PSSFCodeTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFCodeTemplsLock;
        synchronized (n) {
            if (this.pssfcodetempls == null) {
                this.pssfcodetempls = pSSFCodeTemplService.selectByPSSFCodeType(this);
            }
            return this.pssfcodetempls;
        }
    }

    private PSSFCodeTypeBase getProxyEntity() {
        return this.proxyPSSFCodeTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFCodeTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFCodeTypeBase) {
            this.proxyPSSFCodeTypeBase = (PSSFCodeTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CODETEMPL, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEBUGMODE, 4);
        fieldIndexMap.put(FIELD_DEFAULTPUB, 5);
        fieldIndexMap.put(FIELD_FILEEXT, 6);
        fieldIndexMap.put(FIELD_FILENAME, 7);
        fieldIndexMap.put(FIELD_FULLCODENAME, 8);
        fieldIndexMap.put(FIELD_GLOBALFLAG, 9);
        fieldIndexMap.put(FIELD_HEADERCODE, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_MODELLIST, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_PSMODELID, 14);
        fieldIndexMap.put(FIELD_PSMODELNAME, 15);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERID, 16);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERNAME, 17);
        fieldIndexMap.put(FIELD_PSSFCODETYPEID, 18);
        fieldIndexMap.put(FIELD_PSSFCODETYPENAME, 19);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 20);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 21);
        fieldIndexMap.put(FIELD_PUBOBJ, 22);
        fieldIndexMap.put(FIELD_SECURITYTEMPL, 23);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 24);
        fieldIndexMap.put(FIELD_TEMPLDESC, 25);
        fieldIndexMap.put(FIELD_TYPECODE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

