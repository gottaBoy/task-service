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
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFAppTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFAppTemplBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILENAME = "FILENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFAPPTEMPLID = "PSPFAPPTEMPLID";
    public static final String FIELD_PSPFAPPTEMPLNAME = "PSPFAPPTEMPLNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
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
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSPFAPPTEMPLID = 5;
    private static final int INDEX_PSPFAPPTEMPLNAME = 6;
    private static final int INDEX_PSPFID = 7;
    private static final int INDEX_PSPFNAME = 8;
    private static final int INDEX_PSPFPUBCODEID = 9;
    private static final int INDEX_PSPFPUBCODENAME = 10;
    private static final int INDEX_PSPFSTYLEID = 11;
    private static final int INDEX_PSPFSTYLENAME = 12;
    private static final int INDEX_PUBOBJ = 13;
    private static final int INDEX_TEMPLCODE = 14;
    private static final int INDEX_TEMPLCODE2 = 15;
    private static final int INDEX_TEMPLDESC = 16;
    private static final int INDEX_TYPECODE = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFAppTemplBase proxyPSPFAppTemplBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean filenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfapptemplidDirtyFlag = false;
    private boolean pspfapptemplnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="pspfapptemplid")
    private String pspfapptemplid;
    @Column(name="pspfapptemplname")
    private String pspfapptemplname;
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

    public void setPSPFAppTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFAppTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfapptemplid = string;
        this.pspfapptemplidDirtyFlag = true;
    }

    public String getPSPFAppTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFAppTemplId();
        }
        return this.pspfapptemplid;
    }

    public boolean isPSPFAppTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFAppTemplIdDirty();
        }
        return this.pspfapptemplidDirtyFlag;
    }

    public void resetPSPFAppTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFAppTemplId();
            return;
        }
        this.pspfapptemplidDirtyFlag = false;
        this.pspfapptemplid = null;
    }

    public void setPSPFAppTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFAppTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfapptemplname = string;
        this.pspfapptemplnameDirtyFlag = true;
    }

    public String getPSPFAppTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFAppTemplName();
        }
        return this.pspfapptemplname;
    }

    public boolean isPSPFAppTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFAppTemplNameDirty();
        }
        return this.pspfapptemplnameDirtyFlag;
    }

    public void resetPSPFAppTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFAppTemplName();
            return;
        }
        this.pspfapptemplnameDirtyFlag = false;
        this.pspfapptemplname = null;
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
        PSPFAppTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFAppTemplBase pSPFAppTemplBase) {
        pSPFAppTemplBase.resetCodePath();
        pSPFAppTemplBase.resetCreateDate();
        pSPFAppTemplBase.resetCreateMan();
        pSPFAppTemplBase.resetFileName();
        pSPFAppTemplBase.resetMemo();
        pSPFAppTemplBase.resetPSPFAppTemplId();
        pSPFAppTemplBase.resetPSPFAppTemplName();
        pSPFAppTemplBase.resetPSPFId();
        pSPFAppTemplBase.resetPSPFName();
        pSPFAppTemplBase.resetPSPFPubCodeId();
        pSPFAppTemplBase.resetPSPFPubCodeName();
        pSPFAppTemplBase.resetPSPFStyleId();
        pSPFAppTemplBase.resetPSPFStyleName();
        pSPFAppTemplBase.resetPubObj();
        pSPFAppTemplBase.resetTemplCode();
        pSPFAppTemplBase.resetTemplCode2();
        pSPFAppTemplBase.resetTemplDesc();
        pSPFAppTemplBase.resetTypeCode();
        pSPFAppTemplBase.resetUpdateDate();
        pSPFAppTemplBase.resetUpdateMan();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSPFAppTemplIdDirty()) {
            hashMap.put(FIELD_PSPFAPPTEMPLID, this.getPSPFAppTemplId());
        }
        if (!bl || this.isPSPFAppTemplNameDirty()) {
            hashMap.put(FIELD_PSPFAPPTEMPLNAME, this.getPSPFAppTemplName());
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
        return PSPFAppTemplBase.get(this, n);
    }

    private static Object get(PSPFAppTemplBase pSPFAppTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFAppTemplBase.getCodePath();
            }
            case 1: {
                return pSPFAppTemplBase.getCreateDate();
            }
            case 2: {
                return pSPFAppTemplBase.getCreateMan();
            }
            case 3: {
                return pSPFAppTemplBase.getFileName();
            }
            case 4: {
                return pSPFAppTemplBase.getMemo();
            }
            case 5: {
                return pSPFAppTemplBase.getPSPFAppTemplId();
            }
            case 6: {
                return pSPFAppTemplBase.getPSPFAppTemplName();
            }
            case 7: {
                return pSPFAppTemplBase.getPSPFId();
            }
            case 8: {
                return pSPFAppTemplBase.getPSPFName();
            }
            case 9: {
                return pSPFAppTemplBase.getPSPFPubCodeId();
            }
            case 10: {
                return pSPFAppTemplBase.getPSPFPubCodeName();
            }
            case 11: {
                return pSPFAppTemplBase.getPSPFStyleId();
            }
            case 12: {
                return pSPFAppTemplBase.getPSPFStyleName();
            }
            case 13: {
                return pSPFAppTemplBase.getPubObj();
            }
            case 14: {
                return pSPFAppTemplBase.getTemplCode();
            }
            case 15: {
                return pSPFAppTemplBase.getTemplCode2();
            }
            case 16: {
                return pSPFAppTemplBase.getTemplDesc();
            }
            case 17: {
                return pSPFAppTemplBase.getTypeCode();
            }
            case 18: {
                return pSPFAppTemplBase.getUpdateDate();
            }
            case 19: {
                return pSPFAppTemplBase.getUpdateMan();
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
        PSPFAppTemplBase.set(this, n, object);
    }

    private static void set(PSPFAppTemplBase pSPFAppTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFAppTemplBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFAppTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFAppTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFAppTemplBase.setFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFAppTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFAppTemplBase.setPSPFAppTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFAppTemplBase.setPSPFAppTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFAppTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFAppTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFAppTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFAppTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFAppTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFAppTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFAppTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFAppTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFAppTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFAppTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFAppTemplBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFAppTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSPFAppTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFAppTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFAppTemplBase pSPFAppTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFAppTemplBase.getCodePath() == null;
            }
            case 1: {
                return pSPFAppTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFAppTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFAppTemplBase.getFileName() == null;
            }
            case 4: {
                return pSPFAppTemplBase.getMemo() == null;
            }
            case 5: {
                return pSPFAppTemplBase.getPSPFAppTemplId() == null;
            }
            case 6: {
                return pSPFAppTemplBase.getPSPFAppTemplName() == null;
            }
            case 7: {
                return pSPFAppTemplBase.getPSPFId() == null;
            }
            case 8: {
                return pSPFAppTemplBase.getPSPFName() == null;
            }
            case 9: {
                return pSPFAppTemplBase.getPSPFPubCodeId() == null;
            }
            case 10: {
                return pSPFAppTemplBase.getPSPFPubCodeName() == null;
            }
            case 11: {
                return pSPFAppTemplBase.getPSPFStyleId() == null;
            }
            case 12: {
                return pSPFAppTemplBase.getPSPFStyleName() == null;
            }
            case 13: {
                return pSPFAppTemplBase.getPubObj() == null;
            }
            case 14: {
                return pSPFAppTemplBase.getTemplCode() == null;
            }
            case 15: {
                return pSPFAppTemplBase.getTemplCode2() == null;
            }
            case 16: {
                return pSPFAppTemplBase.getTemplDesc() == null;
            }
            case 17: {
                return pSPFAppTemplBase.getTypeCode() == null;
            }
            case 18: {
                return pSPFAppTemplBase.getUpdateDate() == null;
            }
            case 19: {
                return pSPFAppTemplBase.getUpdateMan() == null;
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
        return PSPFAppTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFAppTemplBase pSPFAppTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFAppTemplBase.isCodePathDirty();
            }
            case 1: {
                return pSPFAppTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFAppTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSPFAppTemplBase.isFileNameDirty();
            }
            case 4: {
                return pSPFAppTemplBase.isMemoDirty();
            }
            case 5: {
                return pSPFAppTemplBase.isPSPFAppTemplIdDirty();
            }
            case 6: {
                return pSPFAppTemplBase.isPSPFAppTemplNameDirty();
            }
            case 7: {
                return pSPFAppTemplBase.isPSPFIdDirty();
            }
            case 8: {
                return pSPFAppTemplBase.isPSPFNameDirty();
            }
            case 9: {
                return pSPFAppTemplBase.isPSPFPubCodeIdDirty();
            }
            case 10: {
                return pSPFAppTemplBase.isPSPFPubCodeNameDirty();
            }
            case 11: {
                return pSPFAppTemplBase.isPSPFStyleIdDirty();
            }
            case 12: {
                return pSPFAppTemplBase.isPSPFStyleNameDirty();
            }
            case 13: {
                return pSPFAppTemplBase.isPubObjDirty();
            }
            case 14: {
                return pSPFAppTemplBase.isTemplCodeDirty();
            }
            case 15: {
                return pSPFAppTemplBase.isTemplCode2Dirty();
            }
            case 16: {
                return pSPFAppTemplBase.isTemplDescDirty();
            }
            case 17: {
                return pSPFAppTemplBase.isTypeCodeDirty();
            }
            case 18: {
                return pSPFAppTemplBase.isUpdateDateDirty();
            }
            case 19: {
                return pSPFAppTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFAppTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFAppTemplBase pSPFAppTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFAppTemplBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getCodePath()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filename", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getFileName()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFAppTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfapptemplid", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFAppTemplId()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFAppTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfapptemplname", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFAppTemplName()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFAppTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFAppTemplBase.getJSONValue((Object)pSPFAppTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFAppTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFAppTemplBase pSPFAppTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFAppTemplBase.getCodePath() != null) {
            object = pSPFAppTemplBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getCreateDate() != null) {
            object = pSPFAppTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFAppTemplBase.getCreateMan() != null) {
            object = pSPFAppTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getFileName() != null) {
            object = pSPFAppTemplBase.getFileName();
            xmlNode.setAttribute(FIELD_FILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getMemo() != null) {
            object = pSPFAppTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFAppTemplId() != null) {
            object = pSPFAppTemplBase.getPSPFAppTemplId();
            xmlNode.setAttribute(FIELD_PSPFAPPTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFAppTemplName() != null) {
            object = pSPFAppTemplBase.getPSPFAppTemplName();
            xmlNode.setAttribute(FIELD_PSPFAPPTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFId() != null) {
            object = pSPFAppTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFName() != null) {
            object = pSPFAppTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFAppTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFAppTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFStyleId() != null) {
            object = pSPFAppTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPSPFStyleName() != null) {
            object = pSPFAppTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getPubObj() != null) {
            object = pSPFAppTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getTemplCode() != null) {
            object = pSPFAppTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getTemplCode2() != null) {
            object = pSPFAppTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getTemplDesc() != null) {
            object = pSPFAppTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getTypeCode() != null) {
            object = pSPFAppTemplBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFAppTemplBase.getUpdateDate() != null) {
            object = pSPFAppTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFAppTemplBase.getUpdateMan() != null) {
            object = pSPFAppTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFAppTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFAppTemplBase pSPFAppTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFAppTemplBase.isCodePathDirty() && (bl || pSPFAppTemplBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSPFAppTemplBase.getCodePath());
        }
        if (pSPFAppTemplBase.isCreateDateDirty() && (bl || pSPFAppTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFAppTemplBase.getCreateDate());
        }
        if (pSPFAppTemplBase.isCreateManDirty() && (bl || pSPFAppTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFAppTemplBase.getCreateMan());
        }
        if (pSPFAppTemplBase.isFileNameDirty() && (bl || pSPFAppTemplBase.getFileName() != null)) {
            iDataObject.set(FIELD_FILENAME, (Object)pSPFAppTemplBase.getFileName());
        }
        if (pSPFAppTemplBase.isMemoDirty() && (bl || pSPFAppTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFAppTemplBase.getMemo());
        }
        if (pSPFAppTemplBase.isPSPFAppTemplIdDirty() && (bl || pSPFAppTemplBase.getPSPFAppTemplId() != null)) {
            iDataObject.set(FIELD_PSPFAPPTEMPLID, (Object)pSPFAppTemplBase.getPSPFAppTemplId());
        }
        if (pSPFAppTemplBase.isPSPFAppTemplNameDirty() && (bl || pSPFAppTemplBase.getPSPFAppTemplName() != null)) {
            iDataObject.set(FIELD_PSPFAPPTEMPLNAME, (Object)pSPFAppTemplBase.getPSPFAppTemplName());
        }
        if (pSPFAppTemplBase.isPSPFIdDirty() && (bl || pSPFAppTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFAppTemplBase.getPSPFId());
        }
        if (pSPFAppTemplBase.isPSPFNameDirty() && (bl || pSPFAppTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFAppTemplBase.getPSPFName());
        }
        if (pSPFAppTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFAppTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFAppTemplBase.getPSPFPubCodeId());
        }
        if (pSPFAppTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFAppTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFAppTemplBase.getPSPFPubCodeName());
        }
        if (pSPFAppTemplBase.isPSPFStyleIdDirty() && (bl || pSPFAppTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFAppTemplBase.getPSPFStyleId());
        }
        if (pSPFAppTemplBase.isPSPFStyleNameDirty() && (bl || pSPFAppTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFAppTemplBase.getPSPFStyleName());
        }
        if (pSPFAppTemplBase.isPubObjDirty() && (bl || pSPFAppTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFAppTemplBase.getPubObj());
        }
        if (pSPFAppTemplBase.isTemplCodeDirty() && (bl || pSPFAppTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFAppTemplBase.getTemplCode());
        }
        if (pSPFAppTemplBase.isTemplCode2Dirty() && (bl || pSPFAppTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFAppTemplBase.getTemplCode2());
        }
        if (pSPFAppTemplBase.isTemplDescDirty() && (bl || pSPFAppTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFAppTemplBase.getTemplDesc());
        }
        if (pSPFAppTemplBase.isTypeCodeDirty() && (bl || pSPFAppTemplBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSPFAppTemplBase.getTypeCode());
        }
        if (pSPFAppTemplBase.isUpdateDateDirty() && (bl || pSPFAppTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFAppTemplBase.getUpdateDate());
        }
        if (pSPFAppTemplBase.isUpdateManDirty() && (bl || pSPFAppTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFAppTemplBase.getUpdateMan());
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
        return PSPFAppTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFAppTemplBase pSPFAppTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFAppTemplBase.resetCodePath();
                return true;
            }
            case 1: {
                pSPFAppTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFAppTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFAppTemplBase.resetFileName();
                return true;
            }
            case 4: {
                pSPFAppTemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFAppTemplBase.resetPSPFAppTemplId();
                return true;
            }
            case 6: {
                pSPFAppTemplBase.resetPSPFAppTemplName();
                return true;
            }
            case 7: {
                pSPFAppTemplBase.resetPSPFId();
                return true;
            }
            case 8: {
                pSPFAppTemplBase.resetPSPFName();
                return true;
            }
            case 9: {
                pSPFAppTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 10: {
                pSPFAppTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 11: {
                pSPFAppTemplBase.resetPSPFStyleId();
                return true;
            }
            case 12: {
                pSPFAppTemplBase.resetPSPFStyleName();
                return true;
            }
            case 13: {
                pSPFAppTemplBase.resetPubObj();
                return true;
            }
            case 14: {
                pSPFAppTemplBase.resetTemplCode();
                return true;
            }
            case 15: {
                pSPFAppTemplBase.resetTemplCode2();
                return true;
            }
            case 16: {
                pSPFAppTemplBase.resetTemplDesc();
                return true;
            }
            case 17: {
                pSPFAppTemplBase.resetTypeCode();
                return true;
            }
            case 18: {
                pSPFAppTemplBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSPFAppTemplBase.resetUpdateMan();
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

    private PSPFAppTemplBase getProxyEntity() {
        return this.proxyPSPFAppTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFAppTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFAppTemplBase) {
            this.proxyPSPFAppTemplBase = (PSPFAppTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFAppTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FILENAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSPFAPPTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSPFAPPTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSPFID, 7);
        fieldIndexMap.put(FIELD_PSPFNAME, 8);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 9);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 11);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_PUBOBJ, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 15);
        fieldIndexMap.put(FIELD_TEMPLDESC, 16);
        fieldIndexMap.put(FIELD_TYPECODE, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

