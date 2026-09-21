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
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFCTDetail;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFCTDetailService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCtrlTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PITEMPLCODE = "PITEMPLCODE";
    public static final String FIELD_PITEMPLCODE2 = "PITEMPLCODE2";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSPFCTRLTEMPLID = "PSPFCTRLTEMPLID";
    public static final String FIELD_PSPFCTRLTEMPLNAME = "PSPFCTRLTEMPLNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PITEMPLCODE = 4;
    private static final int INDEX_PITEMPLCODE2 = 5;
    private static final int INDEX_PSCTRLTYPEID = 6;
    private static final int INDEX_PSCTRLTYPENAME = 7;
    private static final int INDEX_PSPFCTRLTEMPLID = 8;
    private static final int INDEX_PSPFCTRLTEMPLNAME = 9;
    private static final int INDEX_PSPFID = 10;
    private static final int INDEX_PSPFNAME = 11;
    private static final int INDEX_PSPFPUBCODEID = 12;
    private static final int INDEX_PSPFPUBCODENAME = 13;
    private static final int INDEX_PSPFSTYLEID = 14;
    private static final int INDEX_PSPFSTYLENAME = 15;
    private static final int INDEX_PUBOBJ = 16;
    private static final int INDEX_TEMPLCODE = 17;
    private static final int INDEX_TEMPLCODE2 = 18;
    private static final int INDEX_TEMPLCODE3 = 19;
    private static final int INDEX_TEMPLCODE4 = 20;
    private static final int INDEX_TEMPLDESC = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFCtrlTemplBase proxyPSPFCtrlTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pitemplcodeDirtyFlag = false;
    private boolean pitemplcode2DirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean pspfctrltemplidDirtyFlag = false;
    private boolean pspfctrltemplnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pitemplcode")
    private String pitemplcode;
    @Column(name="pitemplcode2")
    private String pitemplcode2;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="pspfctrltemplid")
    private String pspfctrltemplid;
    @Column(name="pspfctrltemplname")
    private String pspfctrltemplname;
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
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSPFCTDetailsLock = new Integer(1);
    private ArrayList<PSPFCTDetail> pspfctdetails = null;

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

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setPSPFCtrlTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltemplid = string;
        this.pspfctrltemplidDirtyFlag = true;
    }

    public String getPSPFCtrlTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTemplId();
        }
        return this.pspfctrltemplid;
    }

    public boolean isPSPFCtrlTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTemplIdDirty();
        }
        return this.pspfctrltemplidDirtyFlag;
    }

    public void resetPSPFCtrlTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTemplId();
            return;
        }
        this.pspfctrltemplidDirtyFlag = false;
        this.pspfctrltemplid = null;
    }

    public void setPSPFCtrlTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltemplname = string;
        this.pspfctrltemplnameDirtyFlag = true;
    }

    public String getPSPFCtrlTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTemplName();
        }
        return this.pspfctrltemplname;
    }

    public boolean isPSPFCtrlTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTemplNameDirty();
        }
        return this.pspfctrltemplnameDirtyFlag;
    }

    public void resetPSPFCtrlTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTemplName();
            return;
        }
        this.pspfctrltemplnameDirtyFlag = false;
        this.pspfctrltemplname = null;
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

    public void setTemplCode3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode3 = string;
        this.templcode3DirtyFlag = true;
    }

    public String getTemplCode3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode3();
        }
        return this.templcode3;
    }

    public boolean isTemplCode3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode3Dirty();
        }
        return this.templcode3DirtyFlag;
    }

    public void resetTemplCode3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode3();
            return;
        }
        this.templcode3DirtyFlag = false;
        this.templcode3 = null;
    }

    public void setTemplCode4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode4 = string;
        this.templcode4DirtyFlag = true;
    }

    public String getTemplCode4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode4();
        }
        return this.templcode4;
    }

    public boolean isTemplCode4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode4Dirty();
        }
        return this.templcode4DirtyFlag;
    }

    public void resetTemplCode4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode4();
            return;
        }
        this.templcode4DirtyFlag = false;
        this.templcode4 = null;
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
        PSPFCtrlTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFCtrlTemplBase pSPFCtrlTemplBase) {
        pSPFCtrlTemplBase.resetCreateDate();
        pSPFCtrlTemplBase.resetCreateMan();
        pSPFCtrlTemplBase.resetLogicName();
        pSPFCtrlTemplBase.resetMemo();
        pSPFCtrlTemplBase.resetPITemplCode();
        pSPFCtrlTemplBase.resetPITemplCode2();
        pSPFCtrlTemplBase.resetPSCtrlTypeId();
        pSPFCtrlTemplBase.resetPSCtrlTypeName();
        pSPFCtrlTemplBase.resetPSPFCtrlTemplId();
        pSPFCtrlTemplBase.resetPSPFCtrlTemplName();
        pSPFCtrlTemplBase.resetPSPFId();
        pSPFCtrlTemplBase.resetPSPFName();
        pSPFCtrlTemplBase.resetPSPFPubCodeId();
        pSPFCtrlTemplBase.resetPSPFPubCodeName();
        pSPFCtrlTemplBase.resetPSPFStyleId();
        pSPFCtrlTemplBase.resetPSPFStyleName();
        pSPFCtrlTemplBase.resetPubObj();
        pSPFCtrlTemplBase.resetTemplCode();
        pSPFCtrlTemplBase.resetTemplCode2();
        pSPFCtrlTemplBase.resetTemplCode3();
        pSPFCtrlTemplBase.resetTemplCode4();
        pSPFCtrlTemplBase.resetTemplDesc();
        pSPFCtrlTemplBase.resetUpdateDate();
        pSPFCtrlTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isPITemplCode2Dirty()) {
            hashMap.put(FIELD_PITEMPLCODE2, this.getPITemplCode2());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSPFCtrlTemplIdDirty()) {
            hashMap.put(FIELD_PSPFCTRLTEMPLID, this.getPSPFCtrlTemplId());
        }
        if (!bl || this.isPSPFCtrlTemplNameDirty()) {
            hashMap.put(FIELD_PSPFCTRLTEMPLNAME, this.getPSPFCtrlTemplName());
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
        if (!bl || this.isTemplCode3Dirty()) {
            hashMap.put(FIELD_TEMPLCODE3, this.getTemplCode3());
        }
        if (!bl || this.isTemplCode4Dirty()) {
            hashMap.put(FIELD_TEMPLCODE4, this.getTemplCode4());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSPFCtrlTemplBase.get(this, n);
    }

    private static Object get(PSPFCtrlTemplBase pSPFCtrlTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTemplBase.getCreateDate();
            }
            case 1: {
                return pSPFCtrlTemplBase.getCreateMan();
            }
            case 2: {
                return pSPFCtrlTemplBase.getLogicName();
            }
            case 3: {
                return pSPFCtrlTemplBase.getMemo();
            }
            case 4: {
                return pSPFCtrlTemplBase.getPITemplCode();
            }
            case 5: {
                return pSPFCtrlTemplBase.getPITemplCode2();
            }
            case 6: {
                return pSPFCtrlTemplBase.getPSCtrlTypeId();
            }
            case 7: {
                return pSPFCtrlTemplBase.getPSCtrlTypeName();
            }
            case 8: {
                return pSPFCtrlTemplBase.getPSPFCtrlTemplId();
            }
            case 9: {
                return pSPFCtrlTemplBase.getPSPFCtrlTemplName();
            }
            case 10: {
                return pSPFCtrlTemplBase.getPSPFId();
            }
            case 11: {
                return pSPFCtrlTemplBase.getPSPFName();
            }
            case 12: {
                return pSPFCtrlTemplBase.getPSPFPubCodeId();
            }
            case 13: {
                return pSPFCtrlTemplBase.getPSPFPubCodeName();
            }
            case 14: {
                return pSPFCtrlTemplBase.getPSPFStyleId();
            }
            case 15: {
                return pSPFCtrlTemplBase.getPSPFStyleName();
            }
            case 16: {
                return pSPFCtrlTemplBase.getPubObj();
            }
            case 17: {
                return pSPFCtrlTemplBase.getTemplCode();
            }
            case 18: {
                return pSPFCtrlTemplBase.getTemplCode2();
            }
            case 19: {
                return pSPFCtrlTemplBase.getTemplCode3();
            }
            case 20: {
                return pSPFCtrlTemplBase.getTemplCode4();
            }
            case 21: {
                return pSPFCtrlTemplBase.getTemplDesc();
            }
            case 22: {
                return pSPFCtrlTemplBase.getUpdateDate();
            }
            case 23: {
                return pSPFCtrlTemplBase.getUpdateMan();
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
        PSPFCtrlTemplBase.set(this, n, object);
    }

    private static void set(PSPFCtrlTemplBase pSPFCtrlTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFCtrlTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFCtrlTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFCtrlTemplBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFCtrlTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFCtrlTemplBase.setPITemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFCtrlTemplBase.setPITemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFCtrlTemplBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFCtrlTemplBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFCtrlTemplBase.setPSPFCtrlTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFCtrlTemplBase.setPSPFCtrlTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFCtrlTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFCtrlTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFCtrlTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFCtrlTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFCtrlTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFCtrlTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFCtrlTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFCtrlTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFCtrlTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFCtrlTemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFCtrlTemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFCtrlTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFCtrlTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSPFCtrlTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFCtrlTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFCtrlTemplBase pSPFCtrlTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFCtrlTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFCtrlTemplBase.getLogicName() == null;
            }
            case 3: {
                return pSPFCtrlTemplBase.getMemo() == null;
            }
            case 4: {
                return pSPFCtrlTemplBase.getPITemplCode() == null;
            }
            case 5: {
                return pSPFCtrlTemplBase.getPITemplCode2() == null;
            }
            case 6: {
                return pSPFCtrlTemplBase.getPSCtrlTypeId() == null;
            }
            case 7: {
                return pSPFCtrlTemplBase.getPSCtrlTypeName() == null;
            }
            case 8: {
                return pSPFCtrlTemplBase.getPSPFCtrlTemplId() == null;
            }
            case 9: {
                return pSPFCtrlTemplBase.getPSPFCtrlTemplName() == null;
            }
            case 10: {
                return pSPFCtrlTemplBase.getPSPFId() == null;
            }
            case 11: {
                return pSPFCtrlTemplBase.getPSPFName() == null;
            }
            case 12: {
                return pSPFCtrlTemplBase.getPSPFPubCodeId() == null;
            }
            case 13: {
                return pSPFCtrlTemplBase.getPSPFPubCodeName() == null;
            }
            case 14: {
                return pSPFCtrlTemplBase.getPSPFStyleId() == null;
            }
            case 15: {
                return pSPFCtrlTemplBase.getPSPFStyleName() == null;
            }
            case 16: {
                return pSPFCtrlTemplBase.getPubObj() == null;
            }
            case 17: {
                return pSPFCtrlTemplBase.getTemplCode() == null;
            }
            case 18: {
                return pSPFCtrlTemplBase.getTemplCode2() == null;
            }
            case 19: {
                return pSPFCtrlTemplBase.getTemplCode3() == null;
            }
            case 20: {
                return pSPFCtrlTemplBase.getTemplCode4() == null;
            }
            case 21: {
                return pSPFCtrlTemplBase.getTemplDesc() == null;
            }
            case 22: {
                return pSPFCtrlTemplBase.getUpdateDate() == null;
            }
            case 23: {
                return pSPFCtrlTemplBase.getUpdateMan() == null;
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
        return PSPFCtrlTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFCtrlTemplBase pSPFCtrlTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFCtrlTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSPFCtrlTemplBase.isLogicNameDirty();
            }
            case 3: {
                return pSPFCtrlTemplBase.isMemoDirty();
            }
            case 4: {
                return pSPFCtrlTemplBase.isPITemplCodeDirty();
            }
            case 5: {
                return pSPFCtrlTemplBase.isPITemplCode2Dirty();
            }
            case 6: {
                return pSPFCtrlTemplBase.isPSCtrlTypeIdDirty();
            }
            case 7: {
                return pSPFCtrlTemplBase.isPSCtrlTypeNameDirty();
            }
            case 8: {
                return pSPFCtrlTemplBase.isPSPFCtrlTemplIdDirty();
            }
            case 9: {
                return pSPFCtrlTemplBase.isPSPFCtrlTemplNameDirty();
            }
            case 10: {
                return pSPFCtrlTemplBase.isPSPFIdDirty();
            }
            case 11: {
                return pSPFCtrlTemplBase.isPSPFNameDirty();
            }
            case 12: {
                return pSPFCtrlTemplBase.isPSPFPubCodeIdDirty();
            }
            case 13: {
                return pSPFCtrlTemplBase.isPSPFPubCodeNameDirty();
            }
            case 14: {
                return pSPFCtrlTemplBase.isPSPFStyleIdDirty();
            }
            case 15: {
                return pSPFCtrlTemplBase.isPSPFStyleNameDirty();
            }
            case 16: {
                return pSPFCtrlTemplBase.isPubObjDirty();
            }
            case 17: {
                return pSPFCtrlTemplBase.isTemplCodeDirty();
            }
            case 18: {
                return pSPFCtrlTemplBase.isTemplCode2Dirty();
            }
            case 19: {
                return pSPFCtrlTemplBase.isTemplCode3Dirty();
            }
            case 20: {
                return pSPFCtrlTemplBase.isTemplCode4Dirty();
            }
            case 21: {
                return pSPFCtrlTemplBase.isTemplDescDirty();
            }
            case 22: {
                return pSPFCtrlTemplBase.isUpdateDateDirty();
            }
            case 23: {
                return pSPFCtrlTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFCtrlTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFCtrlTemplBase pSPFCtrlTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFCtrlTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPITemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pitemplcode", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPITemplCode()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPITemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pitemplcode2", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPITemplCode2()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltemplid", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFCtrlTemplId()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltemplname", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFCtrlTemplName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFCtrlTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFCtrlTemplBase.getJSONValue((Object)pSPFCtrlTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFCtrlTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFCtrlTemplBase pSPFCtrlTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFCtrlTemplBase.getCreateDate() != null) {
            object = pSPFCtrlTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCtrlTemplBase.getCreateMan() != null) {
            object = pSPFCtrlTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getLogicName() != null) {
            object = pSPFCtrlTemplBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getMemo() != null) {
            object = pSPFCtrlTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPITemplCode() != null) {
            object = pSPFCtrlTemplBase.getPITemplCode();
            xmlNode.setAttribute(FIELD_PITEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPITemplCode2() != null) {
            object = pSPFCtrlTemplBase.getPITemplCode2();
            xmlNode.setAttribute(FIELD_PITEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSCtrlTypeId() != null) {
            object = pSPFCtrlTemplBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSCtrlTypeName() != null) {
            object = pSPFCtrlTemplBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplId() != null) {
            object = pSPFCtrlTemplBase.getPSPFCtrlTemplId();
            xmlNode.setAttribute(FIELD_PSPFCTRLTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplName() != null) {
            object = pSPFCtrlTemplBase.getPSPFCtrlTemplName();
            xmlNode.setAttribute(FIELD_PSPFCTRLTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFId() != null) {
            object = pSPFCtrlTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFName() != null) {
            object = pSPFCtrlTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFCtrlTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFCtrlTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFStyleId() != null) {
            object = pSPFCtrlTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPSPFStyleName() != null) {
            object = pSPFCtrlTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getPubObj() != null) {
            object = pSPFCtrlTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode() != null) {
            object = pSPFCtrlTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode2() != null) {
            object = pSPFCtrlTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode3() != null) {
            object = pSPFCtrlTemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getTemplCode4() != null) {
            object = pSPFCtrlTemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getTemplDesc() != null) {
            object = pSPFCtrlTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTemplBase.getUpdateDate() != null) {
            object = pSPFCtrlTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCtrlTemplBase.getUpdateMan() != null) {
            object = pSPFCtrlTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFCtrlTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFCtrlTemplBase pSPFCtrlTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFCtrlTemplBase.isCreateDateDirty() && (bl || pSPFCtrlTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFCtrlTemplBase.getCreateDate());
        }
        if (pSPFCtrlTemplBase.isCreateManDirty() && (bl || pSPFCtrlTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFCtrlTemplBase.getCreateMan());
        }
        if (pSPFCtrlTemplBase.isLogicNameDirty() && (bl || pSPFCtrlTemplBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPFCtrlTemplBase.getLogicName());
        }
        if (pSPFCtrlTemplBase.isMemoDirty() && (bl || pSPFCtrlTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFCtrlTemplBase.getMemo());
        }
        if (pSPFCtrlTemplBase.isPITemplCodeDirty() && (bl || pSPFCtrlTemplBase.getPITemplCode() != null)) {
            iDataObject.set(FIELD_PITEMPLCODE, (Object)pSPFCtrlTemplBase.getPITemplCode());
        }
        if (pSPFCtrlTemplBase.isPITemplCode2Dirty() && (bl || pSPFCtrlTemplBase.getPITemplCode2() != null)) {
            iDataObject.set(FIELD_PITEMPLCODE2, (Object)pSPFCtrlTemplBase.getPITemplCode2());
        }
        if (pSPFCtrlTemplBase.isPSCtrlTypeIdDirty() && (bl || pSPFCtrlTemplBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSPFCtrlTemplBase.getPSCtrlTypeId());
        }
        if (pSPFCtrlTemplBase.isPSCtrlTypeNameDirty() && (bl || pSPFCtrlTemplBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSPFCtrlTemplBase.getPSCtrlTypeName());
        }
        if (pSPFCtrlTemplBase.isPSPFCtrlTemplIdDirty() && (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplId() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTEMPLID, (Object)pSPFCtrlTemplBase.getPSPFCtrlTemplId());
        }
        if (pSPFCtrlTemplBase.isPSPFCtrlTemplNameDirty() && (bl || pSPFCtrlTemplBase.getPSPFCtrlTemplName() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTEMPLNAME, (Object)pSPFCtrlTemplBase.getPSPFCtrlTemplName());
        }
        if (pSPFCtrlTemplBase.isPSPFIdDirty() && (bl || pSPFCtrlTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFCtrlTemplBase.getPSPFId());
        }
        if (pSPFCtrlTemplBase.isPSPFNameDirty() && (bl || pSPFCtrlTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFCtrlTemplBase.getPSPFName());
        }
        if (pSPFCtrlTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFCtrlTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFCtrlTemplBase.getPSPFPubCodeId());
        }
        if (pSPFCtrlTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFCtrlTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFCtrlTemplBase.getPSPFPubCodeName());
        }
        if (pSPFCtrlTemplBase.isPSPFStyleIdDirty() && (bl || pSPFCtrlTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFCtrlTemplBase.getPSPFStyleId());
        }
        if (pSPFCtrlTemplBase.isPSPFStyleNameDirty() && (bl || pSPFCtrlTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFCtrlTemplBase.getPSPFStyleName());
        }
        if (pSPFCtrlTemplBase.isPubObjDirty() && (bl || pSPFCtrlTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFCtrlTemplBase.getPubObj());
        }
        if (pSPFCtrlTemplBase.isTemplCodeDirty() && (bl || pSPFCtrlTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFCtrlTemplBase.getTemplCode());
        }
        if (pSPFCtrlTemplBase.isTemplCode2Dirty() && (bl || pSPFCtrlTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFCtrlTemplBase.getTemplCode2());
        }
        if (pSPFCtrlTemplBase.isTemplCode3Dirty() && (bl || pSPFCtrlTemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFCtrlTemplBase.getTemplCode3());
        }
        if (pSPFCtrlTemplBase.isTemplCode4Dirty() && (bl || pSPFCtrlTemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFCtrlTemplBase.getTemplCode4());
        }
        if (pSPFCtrlTemplBase.isTemplDescDirty() && (bl || pSPFCtrlTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFCtrlTemplBase.getTemplDesc());
        }
        if (pSPFCtrlTemplBase.isUpdateDateDirty() && (bl || pSPFCtrlTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFCtrlTemplBase.getUpdateDate());
        }
        if (pSPFCtrlTemplBase.isUpdateManDirty() && (bl || pSPFCtrlTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFCtrlTemplBase.getUpdateMan());
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
        return PSPFCtrlTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFCtrlTemplBase pSPFCtrlTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFCtrlTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFCtrlTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFCtrlTemplBase.resetLogicName();
                return true;
            }
            case 3: {
                pSPFCtrlTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFCtrlTemplBase.resetPITemplCode();
                return true;
            }
            case 5: {
                pSPFCtrlTemplBase.resetPITemplCode2();
                return true;
            }
            case 6: {
                pSPFCtrlTemplBase.resetPSCtrlTypeId();
                return true;
            }
            case 7: {
                pSPFCtrlTemplBase.resetPSCtrlTypeName();
                return true;
            }
            case 8: {
                pSPFCtrlTemplBase.resetPSPFCtrlTemplId();
                return true;
            }
            case 9: {
                pSPFCtrlTemplBase.resetPSPFCtrlTemplName();
                return true;
            }
            case 10: {
                pSPFCtrlTemplBase.resetPSPFId();
                return true;
            }
            case 11: {
                pSPFCtrlTemplBase.resetPSPFName();
                return true;
            }
            case 12: {
                pSPFCtrlTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 13: {
                pSPFCtrlTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 14: {
                pSPFCtrlTemplBase.resetPSPFStyleId();
                return true;
            }
            case 15: {
                pSPFCtrlTemplBase.resetPSPFStyleName();
                return true;
            }
            case 16: {
                pSPFCtrlTemplBase.resetPubObj();
                return true;
            }
            case 17: {
                pSPFCtrlTemplBase.resetTemplCode();
                return true;
            }
            case 18: {
                pSPFCtrlTemplBase.resetTemplCode2();
                return true;
            }
            case 19: {
                pSPFCtrlTemplBase.resetTemplCode3();
                return true;
            }
            case 20: {
                pSPFCtrlTemplBase.resetTemplCode4();
                return true;
            }
            case 21: {
                pSPFCtrlTemplBase.resetTemplDesc();
                return true;
            }
            case 22: {
                pSPFCtrlTemplBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSPFCtrlTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlType getPSCtrlType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlType();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlTypeLock;
        synchronized (n) {
            if (this.psctrltype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlTypeId(), (Object)this.psctrltype.getPSCtrlTypeId()) != 0L) {
                this.psctrltype = null;
            }
            if (this.psctrltype == null) {
                PSCtrlType pSCtrlType = new PSCtrlType();
                pSCtrlType.setPSCtrlTypeId(this.getPSCtrlTypeId());
                PSCtrlTypeService pSCtrlTypeService = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlTypeService.autoGet((IEntity)pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
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
                pSPFPubCodeService.autoGet((IEntity)pSPFPubCode);
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
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
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
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFCTDetail> getPSPFCTDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCTDetails();
        }
        if (this.getPSPFCtrlTemplId() == null) {
            return null;
        }
        PSPFCTDetailService pSPFCTDetailService = (PSPFCTDetailService)ServiceGlobal.getService(PSPFCTDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFCTDetailsLock;
        synchronized (n) {
            if (this.pspfctdetails == null) {
                this.pspfctdetails = pSPFCTDetailService.selectByPSPFCtrlTemp(this);
            }
            return this.pspfctdetails;
        }
    }

    private PSPFCtrlTemplBase getProxyEntity() {
        return this.proxyPSPFCtrlTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFCtrlTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFCtrlTemplBase) {
            this.proxyPSPFCtrlTemplBase = (PSPFCtrlTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PITEMPLCODE, 4);
        fieldIndexMap.put(FIELD_PITEMPLCODE2, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSPFCTRLTEMPLID, 8);
        fieldIndexMap.put(FIELD_PSPFCTRLTEMPLNAME, 9);
        fieldIndexMap.put(FIELD_PSPFID, 10);
        fieldIndexMap.put(FIELD_PSPFNAME, 11);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 12);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 13);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 14);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 15);
        fieldIndexMap.put(FIELD_PUBOBJ, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 20);
        fieldIndexMap.put(FIELD_TEMPLDESC, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

