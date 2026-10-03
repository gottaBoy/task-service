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
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFViewTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFViewTemplBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILENAME = "FILENAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PITEMPLCODE = "PITEMPLCODE";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFVIEWTEMPLID = "PSPFVIEWTEMPLID";
    public static final String FIELD_PSPFVIEWTEMPLNAME = "PSPFVIEWTEMPLNAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODEPATH = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FILENAME = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PITEMPLCODE = 6;
    private static final int INDEX_PSPFID = 7;
    private static final int INDEX_PSPFNAME = 8;
    private static final int INDEX_PSPFPUBCODEID = 9;
    private static final int INDEX_PSPFPUBCODENAME = 10;
    private static final int INDEX_PSPFSTYLEID = 11;
    private static final int INDEX_PSPFSTYLENAME = 12;
    private static final int INDEX_PSPFVIEWTEMPLID = 13;
    private static final int INDEX_PSPFVIEWTEMPLNAME = 14;
    private static final int INDEX_PSVIEWTYPEID = 15;
    private static final int INDEX_PSVIEWTYPENAME = 16;
    private static final int INDEX_PUBOBJ = 17;
    private static final int INDEX_TEMPLCODE = 18;
    private static final int INDEX_TEMPLCODE2 = 19;
    private static final int INDEX_TEMPLDESC = 20;
    private static final int INDEX_TYPECODE = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFViewTemplBase proxyPSPFViewTemplBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean filenameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pitemplcodeDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfviewtemplidDirtyFlag = false;
    private boolean pspfviewtemplnameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codepath")
    private String codepath;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="filename")
    private String filename;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pitemplcode")
    private String pitemplcode;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pspfviewtemplid")
    private String pspfviewtemplid;
    @Column(name="pspfviewtemplname")
    private String pspfviewtemplname;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="templcode")
    private String templcode;
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
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSPFViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfviewtemplid = string;
        this.pspfviewtemplidDirtyFlag = true;
    }

    public String getPSPFViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFViewTemplId();
        }
        return this.pspfviewtemplid;
    }

    public boolean isPSPFViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFViewTemplIdDirty();
        }
        return this.pspfviewtemplidDirtyFlag;
    }

    public void resetPSPFViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFViewTemplId();
            return;
        }
        this.pspfviewtemplidDirtyFlag = false;
        this.pspfviewtemplid = null;
    }

    public void setPSPFViewTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFViewTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfviewtemplname = string;
        this.pspfviewtemplnameDirtyFlag = true;
    }

    public String getPSPFViewTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFViewTemplName();
        }
        return this.pspfviewtemplname;
    }

    public boolean isPSPFViewTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFViewTemplNameDirty();
        }
        return this.pspfviewtemplnameDirtyFlag;
    }

    public void resetPSPFViewTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFViewTemplName();
            return;
        }
        this.pspfviewtemplnameDirtyFlag = false;
        this.pspfviewtemplname = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
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

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
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

    protected void onReset() {
        PSPFViewTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFViewTemplBase pSPFViewTemplBase) {
        pSPFViewTemplBase.resetCodePath();
        pSPFViewTemplBase.resetCreateDate();
        pSPFViewTemplBase.resetCreateMan();
        pSPFViewTemplBase.resetFileName();
        pSPFViewTemplBase.resetLogicName();
        pSPFViewTemplBase.resetMemo();
        pSPFViewTemplBase.resetPITemplCode();
        pSPFViewTemplBase.resetPSPFId();
        pSPFViewTemplBase.resetPSPFName();
        pSPFViewTemplBase.resetPSPFPubCodeId();
        pSPFViewTemplBase.resetPSPFPubCodeName();
        pSPFViewTemplBase.resetPSPFStyleId();
        pSPFViewTemplBase.resetPSPFStyleName();
        pSPFViewTemplBase.resetPSPFViewTemplId();
        pSPFViewTemplBase.resetPSPFViewTemplName();
        pSPFViewTemplBase.resetPSViewTypeId();
        pSPFViewTemplBase.resetPSViewTypeName();
        pSPFViewTemplBase.resetPubObj();
        pSPFViewTemplBase.resetTemplCode();
        pSPFViewTemplBase.resetTemplCode2();
        pSPFViewTemplBase.resetTemplDesc();
        pSPFViewTemplBase.resetTypeCode();
        pSPFViewTemplBase.resetUpdateDate();
        pSPFViewTemplBase.resetUpdateMan();
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
        if (!bl || this.isFileNameDirty()) {
            hashMap.put(FIELD_FILENAME, this.getFileName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPITemplCodeDirty()) {
            hashMap.put(FIELD_PITEMPLCODE, this.getPITemplCode());
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
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSPFViewTemplIdDirty()) {
            hashMap.put(FIELD_PSPFVIEWTEMPLID, this.getPSPFViewTemplId());
        }
        if (!bl || this.isPSPFViewTemplNameDirty()) {
            hashMap.put(FIELD_PSPFVIEWTEMPLNAME, this.getPSPFViewTemplName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
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
        return PSPFViewTemplBase.get(this, n);
    }

    private static Object get(PSPFViewTemplBase pSPFViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTemplBase.getCodePath();
            }
            case 1: {
                return pSPFViewTemplBase.getCreateDate();
            }
            case 2: {
                return pSPFViewTemplBase.getCreateMan();
            }
            case 3: {
                return pSPFViewTemplBase.getFileName();
            }
            case 4: {
                return pSPFViewTemplBase.getLogicName();
            }
            case 5: {
                return pSPFViewTemplBase.getMemo();
            }
            case 6: {
                return pSPFViewTemplBase.getPITemplCode();
            }
            case 7: {
                return pSPFViewTemplBase.getPSPFId();
            }
            case 8: {
                return pSPFViewTemplBase.getPSPFName();
            }
            case 9: {
                return pSPFViewTemplBase.getPSPFPubCodeId();
            }
            case 10: {
                return pSPFViewTemplBase.getPSPFPubCodeName();
            }
            case 11: {
                return pSPFViewTemplBase.getPSPFStyleId();
            }
            case 12: {
                return pSPFViewTemplBase.getPSPFStyleName();
            }
            case 13: {
                return pSPFViewTemplBase.getPSPFViewTemplId();
            }
            case 14: {
                return pSPFViewTemplBase.getPSPFViewTemplName();
            }
            case 15: {
                return pSPFViewTemplBase.getPSViewTypeId();
            }
            case 16: {
                return pSPFViewTemplBase.getPSViewTypeName();
            }
            case 17: {
                return pSPFViewTemplBase.getPubObj();
            }
            case 18: {
                return pSPFViewTemplBase.getTemplCode();
            }
            case 19: {
                return pSPFViewTemplBase.getTemplCode2();
            }
            case 20: {
                return pSPFViewTemplBase.getTemplDesc();
            }
            case 21: {
                return pSPFViewTemplBase.getTypeCode();
            }
            case 22: {
                return pSPFViewTemplBase.getUpdateDate();
            }
            case 23: {
                return pSPFViewTemplBase.getUpdateMan();
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
        PSPFViewTemplBase.set(this, n, object);
    }

    private static void set(PSPFViewTemplBase pSPFViewTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFViewTemplBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFViewTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFViewTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFViewTemplBase.setFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFViewTemplBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFViewTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFViewTemplBase.setPITemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFViewTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFViewTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFViewTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFViewTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFViewTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFViewTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFViewTemplBase.setPSPFViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFViewTemplBase.setPSPFViewTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFViewTemplBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFViewTemplBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFViewTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFViewTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFViewTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFViewTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFViewTemplBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFViewTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSPFViewTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFViewTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFViewTemplBase pSPFViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTemplBase.getCodePath() == null;
            }
            case 1: {
                return pSPFViewTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFViewTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFViewTemplBase.getFileName() == null;
            }
            case 4: {
                return pSPFViewTemplBase.getLogicName() == null;
            }
            case 5: {
                return pSPFViewTemplBase.getMemo() == null;
            }
            case 6: {
                return pSPFViewTemplBase.getPITemplCode() == null;
            }
            case 7: {
                return pSPFViewTemplBase.getPSPFId() == null;
            }
            case 8: {
                return pSPFViewTemplBase.getPSPFName() == null;
            }
            case 9: {
                return pSPFViewTemplBase.getPSPFPubCodeId() == null;
            }
            case 10: {
                return pSPFViewTemplBase.getPSPFPubCodeName() == null;
            }
            case 11: {
                return pSPFViewTemplBase.getPSPFStyleId() == null;
            }
            case 12: {
                return pSPFViewTemplBase.getPSPFStyleName() == null;
            }
            case 13: {
                return pSPFViewTemplBase.getPSPFViewTemplId() == null;
            }
            case 14: {
                return pSPFViewTemplBase.getPSPFViewTemplName() == null;
            }
            case 15: {
                return pSPFViewTemplBase.getPSViewTypeId() == null;
            }
            case 16: {
                return pSPFViewTemplBase.getPSViewTypeName() == null;
            }
            case 17: {
                return pSPFViewTemplBase.getPubObj() == null;
            }
            case 18: {
                return pSPFViewTemplBase.getTemplCode() == null;
            }
            case 19: {
                return pSPFViewTemplBase.getTemplCode2() == null;
            }
            case 20: {
                return pSPFViewTemplBase.getTemplDesc() == null;
            }
            case 21: {
                return pSPFViewTemplBase.getTypeCode() == null;
            }
            case 22: {
                return pSPFViewTemplBase.getUpdateDate() == null;
            }
            case 23: {
                return pSPFViewTemplBase.getUpdateMan() == null;
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
        return PSPFViewTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFViewTemplBase pSPFViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTemplBase.isCodePathDirty();
            }
            case 1: {
                return pSPFViewTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFViewTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSPFViewTemplBase.isFileNameDirty();
            }
            case 4: {
                return pSPFViewTemplBase.isLogicNameDirty();
            }
            case 5: {
                return pSPFViewTemplBase.isMemoDirty();
            }
            case 6: {
                return pSPFViewTemplBase.isPITemplCodeDirty();
            }
            case 7: {
                return pSPFViewTemplBase.isPSPFIdDirty();
            }
            case 8: {
                return pSPFViewTemplBase.isPSPFNameDirty();
            }
            case 9: {
                return pSPFViewTemplBase.isPSPFPubCodeIdDirty();
            }
            case 10: {
                return pSPFViewTemplBase.isPSPFPubCodeNameDirty();
            }
            case 11: {
                return pSPFViewTemplBase.isPSPFStyleIdDirty();
            }
            case 12: {
                return pSPFViewTemplBase.isPSPFStyleNameDirty();
            }
            case 13: {
                return pSPFViewTemplBase.isPSPFViewTemplIdDirty();
            }
            case 14: {
                return pSPFViewTemplBase.isPSPFViewTemplNameDirty();
            }
            case 15: {
                return pSPFViewTemplBase.isPSViewTypeIdDirty();
            }
            case 16: {
                return pSPFViewTemplBase.isPSViewTypeNameDirty();
            }
            case 17: {
                return pSPFViewTemplBase.isPubObjDirty();
            }
            case 18: {
                return pSPFViewTemplBase.isTemplCodeDirty();
            }
            case 19: {
                return pSPFViewTemplBase.isTemplCode2Dirty();
            }
            case 20: {
                return pSPFViewTemplBase.isTemplDescDirty();
            }
            case 21: {
                return pSPFViewTemplBase.isTypeCodeDirty();
            }
            case 22: {
                return pSPFViewTemplBase.isUpdateDateDirty();
            }
            case 23: {
                return pSPFViewTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFViewTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFViewTemplBase pSPFViewTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFViewTemplBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getCodePath()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filename", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getFileName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPITemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pitemplcode", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPITemplCode()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfviewtemplid", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFViewTemplId()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSPFViewTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfviewtemplname", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSPFViewTemplName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFViewTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFViewTemplBase.getJSONValue((Object)pSPFViewTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFViewTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFViewTemplBase pSPFViewTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFViewTemplBase.getCodePath() != null) {
            object = pSPFViewTemplBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getCreateDate() != null) {
            object = pSPFViewTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFViewTemplBase.getCreateMan() != null) {
            object = pSPFViewTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getFileName() != null) {
            object = pSPFViewTemplBase.getFileName();
            xmlNode.setAttribute(FIELD_FILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getLogicName() != null) {
            object = pSPFViewTemplBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getMemo() != null) {
            object = pSPFViewTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPITemplCode() != null) {
            object = pSPFViewTemplBase.getPITemplCode();
            xmlNode.setAttribute(FIELD_PITEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFId() != null) {
            object = pSPFViewTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFName() != null) {
            object = pSPFViewTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFViewTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFViewTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFStyleId() != null) {
            object = pSPFViewTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFStyleName() != null) {
            object = pSPFViewTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFViewTemplId() != null) {
            object = pSPFViewTemplBase.getPSPFViewTemplId();
            xmlNode.setAttribute(FIELD_PSPFVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSPFViewTemplName() != null) {
            object = pSPFViewTemplBase.getPSPFViewTemplName();
            xmlNode.setAttribute(FIELD_PSPFVIEWTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSViewTypeId() != null) {
            object = pSPFViewTemplBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPSViewTypeName() != null) {
            object = pSPFViewTemplBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getPubObj() != null) {
            object = pSPFViewTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getTemplCode() != null) {
            object = pSPFViewTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getTemplCode2() != null) {
            object = pSPFViewTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getTemplDesc() != null) {
            object = pSPFViewTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getTypeCode() != null) {
            object = pSPFViewTemplBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTemplBase.getUpdateDate() != null) {
            object = pSPFViewTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFViewTemplBase.getUpdateMan() != null) {
            object = pSPFViewTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFViewTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFViewTemplBase pSPFViewTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFViewTemplBase.isCodePathDirty() && (bl || pSPFViewTemplBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSPFViewTemplBase.getCodePath());
        }
        if (pSPFViewTemplBase.isCreateDateDirty() && (bl || pSPFViewTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFViewTemplBase.getCreateDate());
        }
        if (pSPFViewTemplBase.isCreateManDirty() && (bl || pSPFViewTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFViewTemplBase.getCreateMan());
        }
        if (pSPFViewTemplBase.isFileNameDirty() && (bl || pSPFViewTemplBase.getFileName() != null)) {
            iDataObject.set(FIELD_FILENAME, (Object)pSPFViewTemplBase.getFileName());
        }
        if (pSPFViewTemplBase.isLogicNameDirty() && (bl || pSPFViewTemplBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPFViewTemplBase.getLogicName());
        }
        if (pSPFViewTemplBase.isMemoDirty() && (bl || pSPFViewTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFViewTemplBase.getMemo());
        }
        if (pSPFViewTemplBase.isPITemplCodeDirty() && (bl || pSPFViewTemplBase.getPITemplCode() != null)) {
            iDataObject.set(FIELD_PITEMPLCODE, (Object)pSPFViewTemplBase.getPITemplCode());
        }
        if (pSPFViewTemplBase.isPSPFIdDirty() && (bl || pSPFViewTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFViewTemplBase.getPSPFId());
        }
        if (pSPFViewTemplBase.isPSPFNameDirty() && (bl || pSPFViewTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFViewTemplBase.getPSPFName());
        }
        if (pSPFViewTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFViewTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFViewTemplBase.getPSPFPubCodeId());
        }
        if (pSPFViewTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFViewTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFViewTemplBase.getPSPFPubCodeName());
        }
        if (pSPFViewTemplBase.isPSPFStyleIdDirty() && (bl || pSPFViewTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFViewTemplBase.getPSPFStyleId());
        }
        if (pSPFViewTemplBase.isPSPFStyleNameDirty() && (bl || pSPFViewTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFViewTemplBase.getPSPFStyleName());
        }
        if (pSPFViewTemplBase.isPSPFViewTemplIdDirty() && (bl || pSPFViewTemplBase.getPSPFViewTemplId() != null)) {
            iDataObject.set(FIELD_PSPFVIEWTEMPLID, (Object)pSPFViewTemplBase.getPSPFViewTemplId());
        }
        if (pSPFViewTemplBase.isPSPFViewTemplNameDirty() && (bl || pSPFViewTemplBase.getPSPFViewTemplName() != null)) {
            iDataObject.set(FIELD_PSPFVIEWTEMPLNAME, (Object)pSPFViewTemplBase.getPSPFViewTemplName());
        }
        if (pSPFViewTemplBase.isPSViewTypeIdDirty() && (bl || pSPFViewTemplBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSPFViewTemplBase.getPSViewTypeId());
        }
        if (pSPFViewTemplBase.isPSViewTypeNameDirty() && (bl || pSPFViewTemplBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSPFViewTemplBase.getPSViewTypeName());
        }
        if (pSPFViewTemplBase.isPubObjDirty() && (bl || pSPFViewTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFViewTemplBase.getPubObj());
        }
        if (pSPFViewTemplBase.isTemplCodeDirty() && (bl || pSPFViewTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFViewTemplBase.getTemplCode());
        }
        if (pSPFViewTemplBase.isTemplCode2Dirty() && (bl || pSPFViewTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFViewTemplBase.getTemplCode2());
        }
        if (pSPFViewTemplBase.isTemplDescDirty() && (bl || pSPFViewTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFViewTemplBase.getTemplDesc());
        }
        if (pSPFViewTemplBase.isTypeCodeDirty() && (bl || pSPFViewTemplBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSPFViewTemplBase.getTypeCode());
        }
        if (pSPFViewTemplBase.isUpdateDateDirty() && (bl || pSPFViewTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFViewTemplBase.getUpdateDate());
        }
        if (pSPFViewTemplBase.isUpdateManDirty() && (bl || pSPFViewTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFViewTemplBase.getUpdateMan());
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
        return PSPFViewTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFViewTemplBase pSPFViewTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFViewTemplBase.resetCodePath();
                return true;
            }
            case 1: {
                pSPFViewTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFViewTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFViewTemplBase.resetFileName();
                return true;
            }
            case 4: {
                pSPFViewTemplBase.resetLogicName();
                return true;
            }
            case 5: {
                pSPFViewTemplBase.resetMemo();
                return true;
            }
            case 6: {
                pSPFViewTemplBase.resetPITemplCode();
                return true;
            }
            case 7: {
                pSPFViewTemplBase.resetPSPFId();
                return true;
            }
            case 8: {
                pSPFViewTemplBase.resetPSPFName();
                return true;
            }
            case 9: {
                pSPFViewTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 10: {
                pSPFViewTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 11: {
                pSPFViewTemplBase.resetPSPFStyleId();
                return true;
            }
            case 12: {
                pSPFViewTemplBase.resetPSPFStyleName();
                return true;
            }
            case 13: {
                pSPFViewTemplBase.resetPSPFViewTemplId();
                return true;
            }
            case 14: {
                pSPFViewTemplBase.resetPSPFViewTemplName();
                return true;
            }
            case 15: {
                pSPFViewTemplBase.resetPSViewTypeId();
                return true;
            }
            case 16: {
                pSPFViewTemplBase.resetPSViewTypeName();
                return true;
            }
            case 17: {
                pSPFViewTemplBase.resetPubObj();
                return true;
            }
            case 18: {
                pSPFViewTemplBase.resetTemplCode();
                return true;
            }
            case 19: {
                pSPFViewTemplBase.resetTemplCode2();
                return true;
            }
            case 20: {
                pSPFViewTemplBase.resetTemplDesc();
                return true;
            }
            case 21: {
                pSPFViewTemplBase.resetTypeCode();
                return true;
            }
            case 22: {
                pSPFViewTemplBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSPFViewTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSPFPubCodeLock;
        synchronized (n) {
            if (this.pspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pspfpubcode = null;
            }
            if (this.pspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet(pSPFPubCode);
                this.pspfpubcode = pSPFPubCode;
            }
            return this.pspfpubcode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSPFViewTemplBase getProxyEntity() {
        return this.proxyPSPFViewTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFViewTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFViewTemplBase) {
            this.proxyPSPFViewTemplBase = (PSPFViewTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFViewTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FILENAME, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PITEMPLCODE, 6);
        fieldIndexMap.put(FIELD_PSPFID, 7);
        fieldIndexMap.put(FIELD_PSPFNAME, 8);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 9);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 11);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_PSPFVIEWTEMPLID, 13);
        fieldIndexMap.put(FIELD_PSPFVIEWTEMPLNAME, 14);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 15);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 16);
        fieldIndexMap.put(FIELD_PUBOBJ, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 19);
        fieldIndexMap.put(FIELD_TEMPLDESC, 20);
        fieldIndexMap.put(FIELD_TYPECODE, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

