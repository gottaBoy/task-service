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
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItem;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFVerCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFVerCodeBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CODETEMPL = "CODETEMPL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMTYPECODE = "CUSTOMTYPECODE";
    public static final String FIELD_CUSTOMTYPECODEDESC = "CUSTOMTYPECODEDESC";
    public static final String FIELD_ENABLECUSTOMCODEPATH = "ENABLECUSTOMCODEPATH";
    public static final String FIELD_ENABLECUSTOMFILENAME = "ENABLECUSTOMFILENAME";
    public static final String FIELD_ENABLECUSTOMTYPECODE = "ENABLECUSTOMTYPECODE";
    public static final String FIELD_FILEEXT = "FILEEXT";
    public static final String FIELD_FILENAME = "FILENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String FIELD_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String FIELD_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String FIELD_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String FIELD_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String FIELD_PSSFVERCODEID = "PSSFVERCODEID";
    public static final String FIELD_PSSFVERCODENAME = "PSSFVERCODENAME";
    public static final String FIELD_REALPSSFSTYLEID = "REALPSSFSTYLEID";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODEPATH = 0;
    private static final int INDEX_CODETEMPL = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMTYPECODE = 4;
    private static final int INDEX_CUSTOMTYPECODEDESC = 5;
    private static final int INDEX_ENABLECUSTOMCODEPATH = 6;
    private static final int INDEX_ENABLECUSTOMFILENAME = 7;
    private static final int INDEX_ENABLECUSTOMTYPECODE = 8;
    private static final int INDEX_FILEEXT = 9;
    private static final int INDEX_FILENAME = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSSFCODEFOLDERID = 12;
    private static final int INDEX_PSSFCODETYPEID = 13;
    private static final int INDEX_PSSFCODETYPENAME = 14;
    private static final int INDEX_PSSFSTYLEVERID = 15;
    private static final int INDEX_PSSFSTYLEVERNAME = 16;
    private static final int INDEX_PSSFVERCODEID = 17;
    private static final int INDEX_PSSFVERCODENAME = 18;
    private static final int INDEX_REALPSSFSTYLEID = 19;
    private static final int INDEX_TEMPLCODE2 = 20;
    private static final int INDEX_TYPECODE = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFVerCodeBase proxyPSSFVerCodeBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean codetemplDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customtypecodeDirtyFlag = false;
    private boolean customtypecodedescDirtyFlag = false;
    private boolean enablecustomcodepathDirtyFlag = false;
    private boolean enablecustomfilenameDirtyFlag = false;
    private boolean enablecustomtypecodeDirtyFlag = false;
    private boolean fileextDirtyFlag = false;
    private boolean filenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfcodefolderidDirtyFlag = false;
    private boolean pssfcodetypeidDirtyFlag = false;
    private boolean pssfcodetypenameDirtyFlag = false;
    private boolean pssfstyleveridDirtyFlag = false;
    private boolean pssfstylevernameDirtyFlag = false;
    private boolean pssfvercodeidDirtyFlag = false;
    private boolean pssfvercodenameDirtyFlag = false;
    private boolean realpssfstyleidDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
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
    @Column(name="customtypecode")
    private String customtypecode;
    @Column(name="customtypecodedesc")
    private String customtypecodedesc;
    @Column(name="enablecustomcodepath")
    private Integer enablecustomcodepath;
    @Column(name="enablecustomfilename")
    private Integer enablecustomfilename;
    @Column(name="enablecustomtypecode")
    private Integer enablecustomtypecode;
    @Column(name="fileext")
    private String fileext;
    @Column(name="filename")
    private String filename;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfcodefolderid")
    private String pssfcodefolderid;
    @Column(name="pssfcodetypeid")
    private String pssfcodetypeid;
    @Column(name="pssfcodetypename")
    private String pssfcodetypename;
    @Column(name="pssfstyleverid")
    private String pssfstyleverid;
    @Column(name="pssfstylevername")
    private String pssfstylevername;
    @Column(name="pssfvercodeid")
    private String pssfvercodeid;
    @Column(name="pssfvercodename")
    private String pssfvercodename;
    @Column(name="realpssfstyleid")
    private String realpssfstyleid;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="typecode")
    private String typecode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFCodeTypeLock = new Integer(1);
    private PSSFCodeType pssfcodetype = null;
    private Integer objPSSFStyleVerLock = new Integer(1);
    private PSSFStyleVer pssfstylever = null;
    private Integer objPSSFVerCodeItemsLock = new Integer(1);
    private ArrayList<PSSFVerCodeItem> pssfvercodeitems = null;

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

    public void setCustomTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtypecode = string;
        this.customtypecodeDirtyFlag = true;
    }

    public String getCustomTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomTypeCode();
        }
        return this.customtypecode;
    }

    public boolean isCustomTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeCodeDirty();
        }
        return this.customtypecodeDirtyFlag;
    }

    public void resetCustomTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomTypeCode();
            return;
        }
        this.customtypecodeDirtyFlag = false;
        this.customtypecode = null;
    }

    public void setCustomTypeCodeDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomTypeCodeDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtypecodedesc = string;
        this.customtypecodedescDirtyFlag = true;
    }

    public String getCustomTypeCodeDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomTypeCodeDesc();
        }
        return this.customtypecodedesc;
    }

    public boolean isCustomTypeCodeDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeCodeDescDirty();
        }
        return this.customtypecodedescDirtyFlag;
    }

    public void resetCustomTypeCodeDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomTypeCodeDesc();
            return;
        }
        this.customtypecodedescDirtyFlag = false;
        this.customtypecodedesc = null;
    }

    public void setEnableCustomCodePath(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomCodePath(n);
            return;
        }
        this.enablecustomcodepath = n;
        this.enablecustomcodepathDirtyFlag = true;
    }

    public Integer getEnableCustomCodePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomCodePath();
        }
        return this.enablecustomcodepath;
    }

    public boolean isEnableCustomCodePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomCodePathDirty();
        }
        return this.enablecustomcodepathDirtyFlag;
    }

    public void resetEnableCustomCodePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomCodePath();
            return;
        }
        this.enablecustomcodepathDirtyFlag = false;
        this.enablecustomcodepath = null;
    }

    public void setEnableCustomFileName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomFileName(n);
            return;
        }
        this.enablecustomfilename = n;
        this.enablecustomfilenameDirtyFlag = true;
    }

    public Integer getEnableCustomFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomFileName();
        }
        return this.enablecustomfilename;
    }

    public boolean isEnableCustomFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomFileNameDirty();
        }
        return this.enablecustomfilenameDirtyFlag;
    }

    public void resetEnableCustomFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomFileName();
            return;
        }
        this.enablecustomfilenameDirtyFlag = false;
        this.enablecustomfilename = null;
    }

    public void setEnableCustomTypeCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomTypeCode(n);
            return;
        }
        this.enablecustomtypecode = n;
        this.enablecustomtypecodeDirtyFlag = true;
    }

    public Integer getEnableCustomTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomTypeCode();
        }
        return this.enablecustomtypecode;
    }

    public boolean isEnableCustomTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomTypeCodeDirty();
        }
        return this.enablecustomtypecodeDirtyFlag;
    }

    public void resetEnableCustomTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomTypeCode();
            return;
        }
        this.enablecustomtypecodeDirtyFlag = false;
        this.enablecustomtypecode = null;
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

    public void setPSSFStyleVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleverid = string;
        this.pssfstyleveridDirtyFlag = true;
    }

    public String getPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerId();
        }
        return this.pssfstyleverid;
    }

    public boolean isPSSFStyleVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerIdDirty();
        }
        return this.pssfstyleveridDirtyFlag;
    }

    public void resetPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerId();
            return;
        }
        this.pssfstyleveridDirtyFlag = false;
        this.pssfstyleverid = null;
    }

    public void setPSSFStyleVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylevername = string;
        this.pssfstylevernameDirtyFlag = true;
    }

    public String getPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerName();
        }
        return this.pssfstylevername;
    }

    public boolean isPSSFStyleVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerNameDirty();
        }
        return this.pssfstylevernameDirtyFlag;
    }

    public void resetPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerName();
            return;
        }
        this.pssfstylevernameDirtyFlag = false;
        this.pssfstylevername = null;
    }

    public void setPSSFVerCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfvercodeid = string;
        this.pssfvercodeidDirtyFlag = true;
    }

    public String getPSSFVerCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeId();
        }
        return this.pssfvercodeid;
    }

    public boolean isPSSFVerCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeIdDirty();
        }
        return this.pssfvercodeidDirtyFlag;
    }

    public void resetPSSFVerCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeId();
            return;
        }
        this.pssfvercodeidDirtyFlag = false;
        this.pssfvercodeid = null;
    }

    public void setPSSFVerCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfvercodename = string;
        this.pssfvercodenameDirtyFlag = true;
    }

    public String getPSSFVerCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeName();
        }
        return this.pssfvercodename;
    }

    public boolean isPSSFVerCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeNameDirty();
        }
        return this.pssfvercodenameDirtyFlag;
    }

    public void resetPSSFVerCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeName();
            return;
        }
        this.pssfvercodenameDirtyFlag = false;
        this.pssfvercodename = null;
    }

    public void setRealPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.realpssfstyleid = string;
        this.realpssfstyleidDirtyFlag = true;
    }

    public String getRealPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealPSSFStyleId();
        }
        return this.realpssfstyleid;
    }

    public boolean isRealPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealPSSFStyleIdDirty();
        }
        return this.realpssfstyleidDirtyFlag;
    }

    public void resetRealPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealPSSFStyleId();
            return;
        }
        this.realpssfstyleidDirtyFlag = false;
        this.realpssfstyleid = null;
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
        PSSFVerCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFVerCodeBase pSSFVerCodeBase) {
        pSSFVerCodeBase.resetCodePath();
        pSSFVerCodeBase.resetCodeTempl();
        pSSFVerCodeBase.resetCreateDate();
        pSSFVerCodeBase.resetCreateMan();
        pSSFVerCodeBase.resetCustomTypeCode();
        pSSFVerCodeBase.resetCustomTypeCodeDesc();
        pSSFVerCodeBase.resetEnableCustomCodePath();
        pSSFVerCodeBase.resetEnableCustomFileName();
        pSSFVerCodeBase.resetEnableCustomTypeCode();
        pSSFVerCodeBase.resetFileExt();
        pSSFVerCodeBase.resetFileName();
        pSSFVerCodeBase.resetMemo();
        pSSFVerCodeBase.resetPSSFCodeFolderId();
        pSSFVerCodeBase.resetPSSFCodeTypeId();
        pSSFVerCodeBase.resetPSSFCodeTypeName();
        pSSFVerCodeBase.resetPSSFStyleVerId();
        pSSFVerCodeBase.resetPSSFStyleVerName();
        pSSFVerCodeBase.resetPSSFVerCodeId();
        pSSFVerCodeBase.resetPSSFVerCodeName();
        pSSFVerCodeBase.resetRealPSSFStyleId();
        pSSFVerCodeBase.resetTemplCode2();
        pSSFVerCodeBase.resetTypeCode();
        pSSFVerCodeBase.resetUpdateDate();
        pSSFVerCodeBase.resetUpdateMan();
        pSSFVerCodeBase.resetValidFlag();
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
        if (!bl || this.isCustomTypeCodeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPECODE, this.getCustomTypeCode());
        }
        if (!bl || this.isCustomTypeCodeDescDirty()) {
            hashMap.put(FIELD_CUSTOMTYPECODEDESC, this.getCustomTypeCodeDesc());
        }
        if (!bl || this.isEnableCustomCodePathDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMCODEPATH, this.getEnableCustomCodePath());
        }
        if (!bl || this.isEnableCustomFileNameDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMFILENAME, this.getEnableCustomFileName());
        }
        if (!bl || this.isEnableCustomTypeCodeDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMTYPECODE, this.getEnableCustomTypeCode());
        }
        if (!bl || this.isFileExtDirty()) {
            hashMap.put(FIELD_FILEEXT, this.getFileExt());
        }
        if (!bl || this.isFileNameDirty()) {
            hashMap.put(FIELD_FILENAME, this.getFileName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFCodeFolderIdDirty()) {
            hashMap.put(FIELD_PSSFCODEFOLDERID, this.getPSSFCodeFolderId());
        }
        if (!bl || this.isPSSFCodeTypeIdDirty()) {
            hashMap.put(FIELD_PSSFCODETYPEID, this.getPSSFCodeTypeId());
        }
        if (!bl || this.isPSSFCodeTypeNameDirty()) {
            hashMap.put(FIELD_PSSFCODETYPENAME, this.getPSSFCodeTypeName());
        }
        if (!bl || this.isPSSFStyleVerIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERID, this.getPSSFStyleVerId());
        }
        if (!bl || this.isPSSFStyleVerNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERNAME, this.getPSSFStyleVerName());
        }
        if (!bl || this.isPSSFVerCodeIdDirty()) {
            hashMap.put(FIELD_PSSFVERCODEID, this.getPSSFVerCodeId());
        }
        if (!bl || this.isPSSFVerCodeNameDirty()) {
            hashMap.put(FIELD_PSSFVERCODENAME, this.getPSSFVerCodeName());
        }
        if (!bl || this.isRealPSSFStyleIdDirty()) {
            hashMap.put(FIELD_REALPSSFSTYLEID, this.getRealPSSFStyleId());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
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
        return PSSFVerCodeBase.get(this, n);
    }

    private static Object get(PSSFVerCodeBase pSSFVerCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeBase.getCodePath();
            }
            case 1: {
                return pSSFVerCodeBase.getCodeTempl();
            }
            case 2: {
                return pSSFVerCodeBase.getCreateDate();
            }
            case 3: {
                return pSSFVerCodeBase.getCreateMan();
            }
            case 4: {
                return pSSFVerCodeBase.getCustomTypeCode();
            }
            case 5: {
                return pSSFVerCodeBase.getCustomTypeCodeDesc();
            }
            case 6: {
                return pSSFVerCodeBase.getEnableCustomCodePath();
            }
            case 7: {
                return pSSFVerCodeBase.getEnableCustomFileName();
            }
            case 8: {
                return pSSFVerCodeBase.getEnableCustomTypeCode();
            }
            case 9: {
                return pSSFVerCodeBase.getFileExt();
            }
            case 10: {
                return pSSFVerCodeBase.getFileName();
            }
            case 11: {
                return pSSFVerCodeBase.getMemo();
            }
            case 12: {
                return pSSFVerCodeBase.getPSSFCodeFolderId();
            }
            case 13: {
                return pSSFVerCodeBase.getPSSFCodeTypeId();
            }
            case 14: {
                return pSSFVerCodeBase.getPSSFCodeTypeName();
            }
            case 15: {
                return pSSFVerCodeBase.getPSSFStyleVerId();
            }
            case 16: {
                return pSSFVerCodeBase.getPSSFStyleVerName();
            }
            case 17: {
                return pSSFVerCodeBase.getPSSFVerCodeId();
            }
            case 18: {
                return pSSFVerCodeBase.getPSSFVerCodeName();
            }
            case 19: {
                return pSSFVerCodeBase.getRealPSSFStyleId();
            }
            case 20: {
                return pSSFVerCodeBase.getTemplCode2();
            }
            case 21: {
                return pSSFVerCodeBase.getTypeCode();
            }
            case 22: {
                return pSSFVerCodeBase.getUpdateDate();
            }
            case 23: {
                return pSSFVerCodeBase.getUpdateMan();
            }
            case 24: {
                return pSSFVerCodeBase.getValidFlag();
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
        PSSFVerCodeBase.set(this, n, object);
    }

    private static void set(PSSFVerCodeBase pSSFVerCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFVerCodeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFVerCodeBase.setCodeTempl(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFVerCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSFVerCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFVerCodeBase.setCustomTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFVerCodeBase.setCustomTypeCodeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFVerCodeBase.setEnableCustomCodePath(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSFVerCodeBase.setEnableCustomFileName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSFVerCodeBase.setEnableCustomTypeCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSFVerCodeBase.setFileExt(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFVerCodeBase.setFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFVerCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFVerCodeBase.setPSSFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFVerCodeBase.setPSSFCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFVerCodeBase.setPSSFCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFVerCodeBase.setPSSFStyleVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFVerCodeBase.setPSSFStyleVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSFVerCodeBase.setPSSFVerCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFVerCodeBase.setPSSFVerCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSFVerCodeBase.setRealPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSFVerCodeBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSFVerCodeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSFVerCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSFVerCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSFVerCodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFVerCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSFVerCodeBase pSSFVerCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeBase.getCodePath() == null;
            }
            case 1: {
                return pSSFVerCodeBase.getCodeTempl() == null;
            }
            case 2: {
                return pSSFVerCodeBase.getCreateDate() == null;
            }
            case 3: {
                return pSSFVerCodeBase.getCreateMan() == null;
            }
            case 4: {
                return pSSFVerCodeBase.getCustomTypeCode() == null;
            }
            case 5: {
                return pSSFVerCodeBase.getCustomTypeCodeDesc() == null;
            }
            case 6: {
                return pSSFVerCodeBase.getEnableCustomCodePath() == null;
            }
            case 7: {
                return pSSFVerCodeBase.getEnableCustomFileName() == null;
            }
            case 8: {
                return pSSFVerCodeBase.getEnableCustomTypeCode() == null;
            }
            case 9: {
                return pSSFVerCodeBase.getFileExt() == null;
            }
            case 10: {
                return pSSFVerCodeBase.getFileName() == null;
            }
            case 11: {
                return pSSFVerCodeBase.getMemo() == null;
            }
            case 12: {
                return pSSFVerCodeBase.getPSSFCodeFolderId() == null;
            }
            case 13: {
                return pSSFVerCodeBase.getPSSFCodeTypeId() == null;
            }
            case 14: {
                return pSSFVerCodeBase.getPSSFCodeTypeName() == null;
            }
            case 15: {
                return pSSFVerCodeBase.getPSSFStyleVerId() == null;
            }
            case 16: {
                return pSSFVerCodeBase.getPSSFStyleVerName() == null;
            }
            case 17: {
                return pSSFVerCodeBase.getPSSFVerCodeId() == null;
            }
            case 18: {
                return pSSFVerCodeBase.getPSSFVerCodeName() == null;
            }
            case 19: {
                return pSSFVerCodeBase.getRealPSSFStyleId() == null;
            }
            case 20: {
                return pSSFVerCodeBase.getTemplCode2() == null;
            }
            case 21: {
                return pSSFVerCodeBase.getTypeCode() == null;
            }
            case 22: {
                return pSSFVerCodeBase.getUpdateDate() == null;
            }
            case 23: {
                return pSSFVerCodeBase.getUpdateMan() == null;
            }
            case 24: {
                return pSSFVerCodeBase.getValidFlag() == null;
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
        return PSSFVerCodeBase.contains(this, n);
    }

    private static boolean contains(PSSFVerCodeBase pSSFVerCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeBase.isCodePathDirty();
            }
            case 1: {
                return pSSFVerCodeBase.isCodeTemplDirty();
            }
            case 2: {
                return pSSFVerCodeBase.isCreateDateDirty();
            }
            case 3: {
                return pSSFVerCodeBase.isCreateManDirty();
            }
            case 4: {
                return pSSFVerCodeBase.isCustomTypeCodeDirty();
            }
            case 5: {
                return pSSFVerCodeBase.isCustomTypeCodeDescDirty();
            }
            case 6: {
                return pSSFVerCodeBase.isEnableCustomCodePathDirty();
            }
            case 7: {
                return pSSFVerCodeBase.isEnableCustomFileNameDirty();
            }
            case 8: {
                return pSSFVerCodeBase.isEnableCustomTypeCodeDirty();
            }
            case 9: {
                return pSSFVerCodeBase.isFileExtDirty();
            }
            case 10: {
                return pSSFVerCodeBase.isFileNameDirty();
            }
            case 11: {
                return pSSFVerCodeBase.isMemoDirty();
            }
            case 12: {
                return pSSFVerCodeBase.isPSSFCodeFolderIdDirty();
            }
            case 13: {
                return pSSFVerCodeBase.isPSSFCodeTypeIdDirty();
            }
            case 14: {
                return pSSFVerCodeBase.isPSSFCodeTypeNameDirty();
            }
            case 15: {
                return pSSFVerCodeBase.isPSSFStyleVerIdDirty();
            }
            case 16: {
                return pSSFVerCodeBase.isPSSFStyleVerNameDirty();
            }
            case 17: {
                return pSSFVerCodeBase.isPSSFVerCodeIdDirty();
            }
            case 18: {
                return pSSFVerCodeBase.isPSSFVerCodeNameDirty();
            }
            case 19: {
                return pSSFVerCodeBase.isRealPSSFStyleIdDirty();
            }
            case 20: {
                return pSSFVerCodeBase.isTemplCode2Dirty();
            }
            case 21: {
                return pSSFVerCodeBase.isTypeCodeDirty();
            }
            case 22: {
                return pSSFVerCodeBase.isUpdateDateDirty();
            }
            case 23: {
                return pSSFVerCodeBase.isUpdateManDirty();
            }
            case 24: {
                return pSSFVerCodeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFVerCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFVerCodeBase pSSFVerCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFVerCodeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getCodeTempl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetempl", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCodeTempl()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getCustomTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtypecode", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCustomTypeCode()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getCustomTypeCodeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtypecodedesc", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getCustomTypeCodeDesc()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getEnableCustomCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomcodepath", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getEnableCustomCodePath()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getEnableCustomFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomfilename", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getEnableCustomFileName()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getEnableCustomTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomtypecode", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getEnableCustomTypeCode()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getFileExt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileext", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getFileExt()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filename", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getFileName()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefolderid", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFCodeFolderId()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypeid", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFCodeTypeId()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypename", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFCodeTypeName()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFStyleVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleverid", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFStyleVerId()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFStyleVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylevername", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFStyleVerName()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFVerCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodeid", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFVerCodeId()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getPSSFVerCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodename", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getPSSFVerCodeName()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getRealPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realpssfstyleid", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getRealPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFVerCodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFVerCodeBase.getJSONValue((Object)pSSFVerCodeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFVerCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFVerCodeBase pSSFVerCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFVerCodeBase.getCodePath() != null) {
            object = pSSFVerCodeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSSFVerCodeBase.getCodeTempl() != null) {
            object = pSSFVerCodeBase.getCodeTempl();
            xmlNode.setAttribute(FIELD_CODETEMPL, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getCreateDate() != null) {
            object = pSSFVerCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFVerCodeBase.getCreateMan() != null) {
            object = pSSFVerCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getCustomTypeCode() != null) {
            object = pSSFVerCodeBase.getCustomTypeCode();
            xmlNode.setAttribute(FIELD_CUSTOMTYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getCustomTypeCodeDesc() != null) {
            object = pSSFVerCodeBase.getCustomTypeCodeDesc();
            xmlNode.setAttribute(FIELD_CUSTOMTYPECODEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getEnableCustomCodePath() != null) {
            object = pSSFVerCodeBase.getEnableCustomCodePath();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMCODEPATH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFVerCodeBase.getEnableCustomFileName() != null) {
            object = pSSFVerCodeBase.getEnableCustomFileName();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMFILENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFVerCodeBase.getEnableCustomTypeCode() != null) {
            object = pSSFVerCodeBase.getEnableCustomTypeCode();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMTYPECODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFVerCodeBase.getFileExt() != null) {
            object = pSSFVerCodeBase.getFileExt();
            xmlNode.setAttribute(FIELD_FILEEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getFileName() != null) {
            object = pSSFVerCodeBase.getFileName();
            xmlNode.setAttribute(FIELD_FILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getMemo() != null) {
            object = pSSFVerCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeFolderId() != null) {
            object = pSSFVerCodeBase.getPSSFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeTypeId() != null) {
            object = pSSFVerCodeBase.getPSSFCodeTypeId();
            xmlNode.setAttribute(FIELD_PSSFCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFCodeTypeName() != null) {
            object = pSSFVerCodeBase.getPSSFCodeTypeName();
            xmlNode.setAttribute(FIELD_PSSFCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFStyleVerId() != null) {
            object = pSSFVerCodeBase.getPSSFStyleVerId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFStyleVerName() != null) {
            object = pSSFVerCodeBase.getPSSFStyleVerName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFVerCodeId() != null) {
            object = pSSFVerCodeBase.getPSSFVerCodeId();
            xmlNode.setAttribute(FIELD_PSSFVERCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getPSSFVerCodeName() != null) {
            object = pSSFVerCodeBase.getPSSFVerCodeName();
            xmlNode.setAttribute(FIELD_PSSFVERCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getRealPSSFStyleId() != null) {
            object = pSSFVerCodeBase.getRealPSSFStyleId();
            xmlNode.setAttribute(FIELD_REALPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getTemplCode2() != null) {
            object = pSSFVerCodeBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getTypeCode() != null) {
            object = pSSFVerCodeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getUpdateDate() != null) {
            object = pSSFVerCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFVerCodeBase.getUpdateMan() != null) {
            object = pSSFVerCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeBase.getValidFlag() != null) {
            object = pSSFVerCodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFVerCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFVerCodeBase pSSFVerCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFVerCodeBase.isCodePathDirty() && (bl || pSSFVerCodeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSSFVerCodeBase.getCodePath());
        }
        if (pSSFVerCodeBase.isCodeTemplDirty() && (bl || pSSFVerCodeBase.getCodeTempl() != null)) {
            iDataObject.set(FIELD_CODETEMPL, (Object)pSSFVerCodeBase.getCodeTempl());
        }
        if (pSSFVerCodeBase.isCreateDateDirty() && (bl || pSSFVerCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFVerCodeBase.getCreateDate());
        }
        if (pSSFVerCodeBase.isCreateManDirty() && (bl || pSSFVerCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFVerCodeBase.getCreateMan());
        }
        if (pSSFVerCodeBase.isCustomTypeCodeDirty() && (bl || pSSFVerCodeBase.getCustomTypeCode() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPECODE, (Object)pSSFVerCodeBase.getCustomTypeCode());
        }
        if (pSSFVerCodeBase.isCustomTypeCodeDescDirty() && (bl || pSSFVerCodeBase.getCustomTypeCodeDesc() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPECODEDESC, (Object)pSSFVerCodeBase.getCustomTypeCodeDesc());
        }
        if (pSSFVerCodeBase.isEnableCustomCodePathDirty() && (bl || pSSFVerCodeBase.getEnableCustomCodePath() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMCODEPATH, (Object)pSSFVerCodeBase.getEnableCustomCodePath());
        }
        if (pSSFVerCodeBase.isEnableCustomFileNameDirty() && (bl || pSSFVerCodeBase.getEnableCustomFileName() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMFILENAME, (Object)pSSFVerCodeBase.getEnableCustomFileName());
        }
        if (pSSFVerCodeBase.isEnableCustomTypeCodeDirty() && (bl || pSSFVerCodeBase.getEnableCustomTypeCode() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMTYPECODE, (Object)pSSFVerCodeBase.getEnableCustomTypeCode());
        }
        if (pSSFVerCodeBase.isFileExtDirty() && (bl || pSSFVerCodeBase.getFileExt() != null)) {
            iDataObject.set(FIELD_FILEEXT, (Object)pSSFVerCodeBase.getFileExt());
        }
        if (pSSFVerCodeBase.isFileNameDirty() && (bl || pSSFVerCodeBase.getFileName() != null)) {
            iDataObject.set(FIELD_FILENAME, (Object)pSSFVerCodeBase.getFileName());
        }
        if (pSSFVerCodeBase.isMemoDirty() && (bl || pSSFVerCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFVerCodeBase.getMemo());
        }
        if (pSSFVerCodeBase.isPSSFCodeFolderIdDirty() && (bl || pSSFVerCodeBase.getPSSFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERID, (Object)pSSFVerCodeBase.getPSSFCodeFolderId());
        }
        if (pSSFVerCodeBase.isPSSFCodeTypeIdDirty() && (bl || pSSFVerCodeBase.getPSSFCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPEID, (Object)pSSFVerCodeBase.getPSSFCodeTypeId());
        }
        if (pSSFVerCodeBase.isPSSFCodeTypeNameDirty() && (bl || pSSFVerCodeBase.getPSSFCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPENAME, (Object)pSSFVerCodeBase.getPSSFCodeTypeName());
        }
        if (pSSFVerCodeBase.isPSSFStyleVerIdDirty() && (bl || pSSFVerCodeBase.getPSSFStyleVerId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERID, (Object)pSSFVerCodeBase.getPSSFStyleVerId());
        }
        if (pSSFVerCodeBase.isPSSFStyleVerNameDirty() && (bl || pSSFVerCodeBase.getPSSFStyleVerName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERNAME, (Object)pSSFVerCodeBase.getPSSFStyleVerName());
        }
        if (pSSFVerCodeBase.isPSSFVerCodeIdDirty() && (bl || pSSFVerCodeBase.getPSSFVerCodeId() != null)) {
            iDataObject.set(FIELD_PSSFVERCODEID, (Object)pSSFVerCodeBase.getPSSFVerCodeId());
        }
        if (pSSFVerCodeBase.isPSSFVerCodeNameDirty() && (bl || pSSFVerCodeBase.getPSSFVerCodeName() != null)) {
            iDataObject.set(FIELD_PSSFVERCODENAME, (Object)pSSFVerCodeBase.getPSSFVerCodeName());
        }
        if (pSSFVerCodeBase.isRealPSSFStyleIdDirty() && (bl || pSSFVerCodeBase.getRealPSSFStyleId() != null)) {
            iDataObject.set(FIELD_REALPSSFSTYLEID, (Object)pSSFVerCodeBase.getRealPSSFStyleId());
        }
        if (pSSFVerCodeBase.isTemplCode2Dirty() && (bl || pSSFVerCodeBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSFVerCodeBase.getTemplCode2());
        }
        if (pSSFVerCodeBase.isTypeCodeDirty() && (bl || pSSFVerCodeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSSFVerCodeBase.getTypeCode());
        }
        if (pSSFVerCodeBase.isUpdateDateDirty() && (bl || pSSFVerCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFVerCodeBase.getUpdateDate());
        }
        if (pSSFVerCodeBase.isUpdateManDirty() && (bl || pSSFVerCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFVerCodeBase.getUpdateMan());
        }
        if (pSSFVerCodeBase.isValidFlagDirty() && (bl || pSSFVerCodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFVerCodeBase.getValidFlag());
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
        return PSSFVerCodeBase.remove(this, n);
    }

    private static boolean remove(PSSFVerCodeBase pSSFVerCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFVerCodeBase.resetCodePath();
                return true;
            }
            case 1: {
                pSSFVerCodeBase.resetCodeTempl();
                return true;
            }
            case 2: {
                pSSFVerCodeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSFVerCodeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSFVerCodeBase.resetCustomTypeCode();
                return true;
            }
            case 5: {
                pSSFVerCodeBase.resetCustomTypeCodeDesc();
                return true;
            }
            case 6: {
                pSSFVerCodeBase.resetEnableCustomCodePath();
                return true;
            }
            case 7: {
                pSSFVerCodeBase.resetEnableCustomFileName();
                return true;
            }
            case 8: {
                pSSFVerCodeBase.resetEnableCustomTypeCode();
                return true;
            }
            case 9: {
                pSSFVerCodeBase.resetFileExt();
                return true;
            }
            case 10: {
                pSSFVerCodeBase.resetFileName();
                return true;
            }
            case 11: {
                pSSFVerCodeBase.resetMemo();
                return true;
            }
            case 12: {
                pSSFVerCodeBase.resetPSSFCodeFolderId();
                return true;
            }
            case 13: {
                pSSFVerCodeBase.resetPSSFCodeTypeId();
                return true;
            }
            case 14: {
                pSSFVerCodeBase.resetPSSFCodeTypeName();
                return true;
            }
            case 15: {
                pSSFVerCodeBase.resetPSSFStyleVerId();
                return true;
            }
            case 16: {
                pSSFVerCodeBase.resetPSSFStyleVerName();
                return true;
            }
            case 17: {
                pSSFVerCodeBase.resetPSSFVerCodeId();
                return true;
            }
            case 18: {
                pSSFVerCodeBase.resetPSSFVerCodeName();
                return true;
            }
            case 19: {
                pSSFVerCodeBase.resetRealPSSFStyleId();
                return true;
            }
            case 20: {
                pSSFVerCodeBase.resetTemplCode2();
                return true;
            }
            case 21: {
                pSSFVerCodeBase.resetTypeCode();
                return true;
            }
            case 22: {
                pSSFVerCodeBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSSFVerCodeBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSSFVerCodeBase.resetValidFlag();
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
    public PSSFStyleVer getPSSFStyleVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVer();
        }
        if (this.getPSSFStyleVerId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleVerLock;
        synchronized (n) {
            if (this.pssfstylever != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleVerId(), (Object)this.pssfstylever.getPSSFStyleVerId()) != 0L) {
                this.pssfstylever = null;
            }
            if (this.pssfstylever == null) {
                PSSFStyleVer pSSFStyleVer = new PSSFStyleVer();
                pSSFStyleVer.setPSSFStyleVerId(this.getPSSFStyleVerId());
                PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleVerService.autoGet((IEntity)pSSFStyleVer);
                this.pssfstylever = pSSFStyleVer;
            }
            return this.pssfstylever;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFVerCodeItem> getPSSFVerCodeItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeItems();
        }
        if (this.getPSSFVerCodeId() == null) {
            return null;
        }
        PSSFVerCodeItemService pSSFVerCodeItemService = (PSSFVerCodeItemService)ServiceGlobal.getService(PSSFVerCodeItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFVerCodeItemsLock;
        synchronized (n) {
            if (this.pssfvercodeitems == null) {
                this.pssfvercodeitems = pSSFVerCodeItemService.selectByPSSFVerCode(this);
            }
            return this.pssfvercodeitems;
        }
    }

    private PSSFVerCodeBase getProxyEntity() {
        return this.proxyPSSFVerCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFVerCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFVerCodeBase) {
            this.proxyPSSFVerCodeBase = (PSSFVerCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFVerCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CODETEMPL, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMTYPECODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMTYPECODEDESC, 5);
        fieldIndexMap.put(FIELD_ENABLECUSTOMCODEPATH, 6);
        fieldIndexMap.put(FIELD_ENABLECUSTOMFILENAME, 7);
        fieldIndexMap.put(FIELD_ENABLECUSTOMTYPECODE, 8);
        fieldIndexMap.put(FIELD_FILEEXT, 9);
        fieldIndexMap.put(FIELD_FILENAME, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERID, 12);
        fieldIndexMap.put(FIELD_PSSFCODETYPEID, 13);
        fieldIndexMap.put(FIELD_PSSFCODETYPENAME, 14);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERID, 15);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERNAME, 16);
        fieldIndexMap.put(FIELD_PSSFVERCODEID, 17);
        fieldIndexMap.put(FIELD_PSSFVERCODENAME, 18);
        fieldIndexMap.put(FIELD_REALPSSFSTYLEID, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 20);
        fieldIndexMap.put(FIELD_TYPECODE, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
    }
}

