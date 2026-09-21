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
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFVLTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFVLTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSNAME = "PROCESSNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFVLTEMPLID = "PSPFVLTEMPLID";
    public static final String FIELD_PSPFVLTEMPLNAME = "PSPFVLTEMPLNAME";
    public static final String FIELD_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String FIELD_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PROCESSNAME = 3;
    private static final int INDEX_PSPFID = 4;
    private static final int INDEX_PSPFNAME = 5;
    private static final int INDEX_PSPFPUBCODEID = 6;
    private static final int INDEX_PSPFPUBCODENAME = 7;
    private static final int INDEX_PSPFSTYLEID = 8;
    private static final int INDEX_PSPFSTYLENAME = 9;
    private static final int INDEX_PSPFVLTEMPLID = 10;
    private static final int INDEX_PSPFVLTEMPLNAME = 11;
    private static final int INDEX_PSVIEWLOGICTYPEID = 12;
    private static final int INDEX_PSVIEWLOGICTYPENAME = 13;
    private static final int INDEX_PUBOBJ = 14;
    private static final int INDEX_TEMPLCODE = 15;
    private static final int INDEX_TEMPLCODE2 = 16;
    private static final int INDEX_TEMPLCODE3 = 17;
    private static final int INDEX_TEMPLCODE4 = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFVLTemplBase proxyPSPFVLTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfvltemplidDirtyFlag = false;
    private boolean pspfvltemplnameDirtyFlag = false;
    private boolean psviewlogictypeidDirtyFlag = false;
    private boolean psviewlogictypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="processname")
    private String processname;
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
    @Column(name="pspfvltemplid")
    private String pspfvltemplid;
    @Column(name="pspfvltemplname")
    private String pspfvltemplname;
    @Column(name="psviewlogictypeid")
    private String psviewlogictypeid;
    @Column(name="psviewlogictypename")
    private String psviewlogictypename;
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
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPspfLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSViewLogicTypeLock = new Integer(1);
    private PSViewLogicType psviewlogictype = null;

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

    public void setProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processname = string;
        this.processnameDirtyFlag = true;
    }

    public String getProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessName();
        }
        return this.processname;
    }

    public boolean isProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessNameDirty();
        }
        return this.processnameDirtyFlag;
    }

    public void resetProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessName();
            return;
        }
        this.processnameDirtyFlag = false;
        this.processname = null;
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

    public void setPSPFVLTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFVLTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfvltemplid = string;
        this.pspfvltemplidDirtyFlag = true;
    }

    public String getPSPFVLTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFVLTemplId();
        }
        return this.pspfvltemplid;
    }

    public boolean isPSPFVLTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFVLTemplIdDirty();
        }
        return this.pspfvltemplidDirtyFlag;
    }

    public void resetPSPFVLTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFVLTemplId();
            return;
        }
        this.pspfvltemplidDirtyFlag = false;
        this.pspfvltemplid = null;
    }

    public void setPSPFVLTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFVLTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfvltemplname = string;
        this.pspfvltemplnameDirtyFlag = true;
    }

    public String getPSPFVLTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFVLTemplName();
        }
        return this.pspfvltemplname;
    }

    public boolean isPSPFVLTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFVLTemplNameDirty();
        }
        return this.pspfvltemplnameDirtyFlag;
    }

    public void resetPSPFVLTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFVLTemplName();
            return;
        }
        this.pspfvltemplnameDirtyFlag = false;
        this.pspfvltemplname = null;
    }

    public void setPSViewLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeid = string;
        this.psviewlogictypeidDirtyFlag = true;
    }

    public String getPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeId();
        }
        return this.psviewlogictypeid;
    }

    public boolean isPSViewLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeIdDirty();
        }
        return this.psviewlogictypeidDirtyFlag;
    }

    public void resetPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeId();
            return;
        }
        this.psviewlogictypeidDirtyFlag = false;
        this.psviewlogictypeid = null;
    }

    public void setPSViewLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypename = string;
        this.psviewlogictypenameDirtyFlag = true;
    }

    public String getPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeName();
        }
        return this.psviewlogictypename;
    }

    public boolean isPSViewLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeNameDirty();
        }
        return this.psviewlogictypenameDirtyFlag;
    }

    public void resetPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeName();
            return;
        }
        this.psviewlogictypenameDirtyFlag = false;
        this.psviewlogictypename = null;
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
        PSPFVLTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFVLTemplBase pSPFVLTemplBase) {
        pSPFVLTemplBase.resetCreateDate();
        pSPFVLTemplBase.resetCreateMan();
        pSPFVLTemplBase.resetMemo();
        pSPFVLTemplBase.resetProcessName();
        pSPFVLTemplBase.resetPSPFId();
        pSPFVLTemplBase.resetPSPFName();
        pSPFVLTemplBase.resetPSPFPubCodeId();
        pSPFVLTemplBase.resetPSPFPubCodeName();
        pSPFVLTemplBase.resetPSPFStyleId();
        pSPFVLTemplBase.resetPSPFStyleName();
        pSPFVLTemplBase.resetPSPFVLTemplId();
        pSPFVLTemplBase.resetPSPFVLTemplName();
        pSPFVLTemplBase.resetPSViewLogicTypeId();
        pSPFVLTemplBase.resetPSViewLogicTypeName();
        pSPFVLTemplBase.resetPubObj();
        pSPFVLTemplBase.resetTemplCode();
        pSPFVLTemplBase.resetTemplCode2();
        pSPFVLTemplBase.resetTemplCode3();
        pSPFVLTemplBase.resetTemplCode4();
        pSPFVLTemplBase.resetUpdateDate();
        pSPFVLTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isProcessNameDirty()) {
            hashMap.put(FIELD_PROCESSNAME, this.getProcessName());
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
        if (!bl || this.isPSPFVLTemplIdDirty()) {
            hashMap.put(FIELD_PSPFVLTEMPLID, this.getPSPFVLTemplId());
        }
        if (!bl || this.isPSPFVLTemplNameDirty()) {
            hashMap.put(FIELD_PSPFVLTEMPLNAME, this.getPSPFVLTemplName());
        }
        if (!bl || this.isPSViewLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEID, this.getPSViewLogicTypeId());
        }
        if (!bl || this.isPSViewLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPENAME, this.getPSViewLogicTypeName());
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
        return PSPFVLTemplBase.get(this, n);
    }

    private static Object get(PSPFVLTemplBase pSPFVLTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFVLTemplBase.getCreateDate();
            }
            case 1: {
                return pSPFVLTemplBase.getCreateMan();
            }
            case 2: {
                return pSPFVLTemplBase.getMemo();
            }
            case 3: {
                return pSPFVLTemplBase.getProcessName();
            }
            case 4: {
                return pSPFVLTemplBase.getPSPFId();
            }
            case 5: {
                return pSPFVLTemplBase.getPSPFName();
            }
            case 6: {
                return pSPFVLTemplBase.getPSPFPubCodeId();
            }
            case 7: {
                return pSPFVLTemplBase.getPSPFPubCodeName();
            }
            case 8: {
                return pSPFVLTemplBase.getPSPFStyleId();
            }
            case 9: {
                return pSPFVLTemplBase.getPSPFStyleName();
            }
            case 10: {
                return pSPFVLTemplBase.getPSPFVLTemplId();
            }
            case 11: {
                return pSPFVLTemplBase.getPSPFVLTemplName();
            }
            case 12: {
                return pSPFVLTemplBase.getPSViewLogicTypeId();
            }
            case 13: {
                return pSPFVLTemplBase.getPSViewLogicTypeName();
            }
            case 14: {
                return pSPFVLTemplBase.getPubObj();
            }
            case 15: {
                return pSPFVLTemplBase.getTemplCode();
            }
            case 16: {
                return pSPFVLTemplBase.getTemplCode2();
            }
            case 17: {
                return pSPFVLTemplBase.getTemplCode3();
            }
            case 18: {
                return pSPFVLTemplBase.getTemplCode4();
            }
            case 19: {
                return pSPFVLTemplBase.getUpdateDate();
            }
            case 20: {
                return pSPFVLTemplBase.getUpdateMan();
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
        PSPFVLTemplBase.set(this, n, object);
    }

    private static void set(PSPFVLTemplBase pSPFVLTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFVLTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFVLTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFVLTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFVLTemplBase.setProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFVLTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFVLTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFVLTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFVLTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFVLTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFVLTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFVLTemplBase.setPSPFVLTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFVLTemplBase.setPSPFVLTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFVLTemplBase.setPSViewLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFVLTemplBase.setPSViewLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFVLTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFVLTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFVLTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFVLTemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFVLTemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFVLTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSPFVLTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFVLTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFVLTemplBase pSPFVLTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFVLTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFVLTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFVLTemplBase.getMemo() == null;
            }
            case 3: {
                return pSPFVLTemplBase.getProcessName() == null;
            }
            case 4: {
                return pSPFVLTemplBase.getPSPFId() == null;
            }
            case 5: {
                return pSPFVLTemplBase.getPSPFName() == null;
            }
            case 6: {
                return pSPFVLTemplBase.getPSPFPubCodeId() == null;
            }
            case 7: {
                return pSPFVLTemplBase.getPSPFPubCodeName() == null;
            }
            case 8: {
                return pSPFVLTemplBase.getPSPFStyleId() == null;
            }
            case 9: {
                return pSPFVLTemplBase.getPSPFStyleName() == null;
            }
            case 10: {
                return pSPFVLTemplBase.getPSPFVLTemplId() == null;
            }
            case 11: {
                return pSPFVLTemplBase.getPSPFVLTemplName() == null;
            }
            case 12: {
                return pSPFVLTemplBase.getPSViewLogicTypeId() == null;
            }
            case 13: {
                return pSPFVLTemplBase.getPSViewLogicTypeName() == null;
            }
            case 14: {
                return pSPFVLTemplBase.getPubObj() == null;
            }
            case 15: {
                return pSPFVLTemplBase.getTemplCode() == null;
            }
            case 16: {
                return pSPFVLTemplBase.getTemplCode2() == null;
            }
            case 17: {
                return pSPFVLTemplBase.getTemplCode3() == null;
            }
            case 18: {
                return pSPFVLTemplBase.getTemplCode4() == null;
            }
            case 19: {
                return pSPFVLTemplBase.getUpdateDate() == null;
            }
            case 20: {
                return pSPFVLTemplBase.getUpdateMan() == null;
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
        return PSPFVLTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFVLTemplBase pSPFVLTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFVLTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFVLTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSPFVLTemplBase.isMemoDirty();
            }
            case 3: {
                return pSPFVLTemplBase.isProcessNameDirty();
            }
            case 4: {
                return pSPFVLTemplBase.isPSPFIdDirty();
            }
            case 5: {
                return pSPFVLTemplBase.isPSPFNameDirty();
            }
            case 6: {
                return pSPFVLTemplBase.isPSPFPubCodeIdDirty();
            }
            case 7: {
                return pSPFVLTemplBase.isPSPFPubCodeNameDirty();
            }
            case 8: {
                return pSPFVLTemplBase.isPSPFStyleIdDirty();
            }
            case 9: {
                return pSPFVLTemplBase.isPSPFStyleNameDirty();
            }
            case 10: {
                return pSPFVLTemplBase.isPSPFVLTemplIdDirty();
            }
            case 11: {
                return pSPFVLTemplBase.isPSPFVLTemplNameDirty();
            }
            case 12: {
                return pSPFVLTemplBase.isPSViewLogicTypeIdDirty();
            }
            case 13: {
                return pSPFVLTemplBase.isPSViewLogicTypeNameDirty();
            }
            case 14: {
                return pSPFVLTemplBase.isPubObjDirty();
            }
            case 15: {
                return pSPFVLTemplBase.isTemplCodeDirty();
            }
            case 16: {
                return pSPFVLTemplBase.isTemplCode2Dirty();
            }
            case 17: {
                return pSPFVLTemplBase.isTemplCode3Dirty();
            }
            case 18: {
                return pSPFVLTemplBase.isTemplCode4Dirty();
            }
            case 19: {
                return pSPFVLTemplBase.isUpdateDateDirty();
            }
            case 20: {
                return pSPFVLTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFVLTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFVLTemplBase pSPFVLTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFVLTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processname", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getProcessName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFVLTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfvltemplid", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFVLTemplId()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSPFVLTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfvltemplname", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSPFVLTemplName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSViewLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeid", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSViewLogicTypeId()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPSViewLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypename", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPSViewLogicTypeName()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFVLTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFVLTemplBase.getJSONValue((Object)pSPFVLTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFVLTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFVLTemplBase pSPFVLTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFVLTemplBase.getCreateDate() != null) {
            object = pSPFVLTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFVLTemplBase.getCreateMan() != null) {
            object = pSPFVLTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getMemo() != null) {
            object = pSPFVLTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getProcessName() != null) {
            object = pSPFVLTemplBase.getProcessName();
            xmlNode.setAttribute(FIELD_PROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFId() != null) {
            object = pSPFVLTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFName() != null) {
            object = pSPFVLTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFVLTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFVLTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFStyleId() != null) {
            object = pSPFVLTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFStyleName() != null) {
            object = pSPFVLTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFVLTemplId() != null) {
            object = pSPFVLTemplBase.getPSPFVLTemplId();
            xmlNode.setAttribute(FIELD_PSPFVLTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSPFVLTemplName() != null) {
            object = pSPFVLTemplBase.getPSPFVLTemplName();
            xmlNode.setAttribute(FIELD_PSPFVLTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSViewLogicTypeId() != null) {
            object = pSPFVLTemplBase.getPSViewLogicTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPSViewLogicTypeName() != null) {
            object = pSPFVLTemplBase.getPSViewLogicTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getPubObj() != null) {
            object = pSPFVLTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getTemplCode() != null) {
            object = pSPFVLTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getTemplCode2() != null) {
            object = pSPFVLTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getTemplCode3() != null) {
            object = pSPFVLTemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getTemplCode4() != null) {
            object = pSPFVLTemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFVLTemplBase.getUpdateDate() != null) {
            object = pSPFVLTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFVLTemplBase.getUpdateMan() != null) {
            object = pSPFVLTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFVLTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFVLTemplBase pSPFVLTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFVLTemplBase.isCreateDateDirty() && (bl || pSPFVLTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFVLTemplBase.getCreateDate());
        }
        if (pSPFVLTemplBase.isCreateManDirty() && (bl || pSPFVLTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFVLTemplBase.getCreateMan());
        }
        if (pSPFVLTemplBase.isMemoDirty() && (bl || pSPFVLTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFVLTemplBase.getMemo());
        }
        if (pSPFVLTemplBase.isProcessNameDirty() && (bl || pSPFVLTemplBase.getProcessName() != null)) {
            iDataObject.set(FIELD_PROCESSNAME, (Object)pSPFVLTemplBase.getProcessName());
        }
        if (pSPFVLTemplBase.isPSPFIdDirty() && (bl || pSPFVLTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFVLTemplBase.getPSPFId());
        }
        if (pSPFVLTemplBase.isPSPFNameDirty() && (bl || pSPFVLTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFVLTemplBase.getPSPFName());
        }
        if (pSPFVLTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFVLTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFVLTemplBase.getPSPFPubCodeId());
        }
        if (pSPFVLTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFVLTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFVLTemplBase.getPSPFPubCodeName());
        }
        if (pSPFVLTemplBase.isPSPFStyleIdDirty() && (bl || pSPFVLTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFVLTemplBase.getPSPFStyleId());
        }
        if (pSPFVLTemplBase.isPSPFStyleNameDirty() && (bl || pSPFVLTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFVLTemplBase.getPSPFStyleName());
        }
        if (pSPFVLTemplBase.isPSPFVLTemplIdDirty() && (bl || pSPFVLTemplBase.getPSPFVLTemplId() != null)) {
            iDataObject.set(FIELD_PSPFVLTEMPLID, (Object)pSPFVLTemplBase.getPSPFVLTemplId());
        }
        if (pSPFVLTemplBase.isPSPFVLTemplNameDirty() && (bl || pSPFVLTemplBase.getPSPFVLTemplName() != null)) {
            iDataObject.set(FIELD_PSPFVLTEMPLNAME, (Object)pSPFVLTemplBase.getPSPFVLTemplName());
        }
        if (pSPFVLTemplBase.isPSViewLogicTypeIdDirty() && (bl || pSPFVLTemplBase.getPSViewLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEID, (Object)pSPFVLTemplBase.getPSViewLogicTypeId());
        }
        if (pSPFVLTemplBase.isPSViewLogicTypeNameDirty() && (bl || pSPFVLTemplBase.getPSViewLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPENAME, (Object)pSPFVLTemplBase.getPSViewLogicTypeName());
        }
        if (pSPFVLTemplBase.isPubObjDirty() && (bl || pSPFVLTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFVLTemplBase.getPubObj());
        }
        if (pSPFVLTemplBase.isTemplCodeDirty() && (bl || pSPFVLTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFVLTemplBase.getTemplCode());
        }
        if (pSPFVLTemplBase.isTemplCode2Dirty() && (bl || pSPFVLTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFVLTemplBase.getTemplCode2());
        }
        if (pSPFVLTemplBase.isTemplCode3Dirty() && (bl || pSPFVLTemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFVLTemplBase.getTemplCode3());
        }
        if (pSPFVLTemplBase.isTemplCode4Dirty() && (bl || pSPFVLTemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFVLTemplBase.getTemplCode4());
        }
        if (pSPFVLTemplBase.isUpdateDateDirty() && (bl || pSPFVLTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFVLTemplBase.getUpdateDate());
        }
        if (pSPFVLTemplBase.isUpdateManDirty() && (bl || pSPFVLTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFVLTemplBase.getUpdateMan());
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
        return PSPFVLTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFVLTemplBase pSPFVLTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFVLTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFVLTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFVLTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFVLTemplBase.resetProcessName();
                return true;
            }
            case 4: {
                pSPFVLTemplBase.resetPSPFId();
                return true;
            }
            case 5: {
                pSPFVLTemplBase.resetPSPFName();
                return true;
            }
            case 6: {
                pSPFVLTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 7: {
                pSPFVLTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 8: {
                pSPFVLTemplBase.resetPSPFStyleId();
                return true;
            }
            case 9: {
                pSPFVLTemplBase.resetPSPFStyleName();
                return true;
            }
            case 10: {
                pSPFVLTemplBase.resetPSPFVLTemplId();
                return true;
            }
            case 11: {
                pSPFVLTemplBase.resetPSPFVLTemplName();
                return true;
            }
            case 12: {
                pSPFVLTemplBase.resetPSViewLogicTypeId();
                return true;
            }
            case 13: {
                pSPFVLTemplBase.resetPSViewLogicTypeName();
                return true;
            }
            case 14: {
                pSPFVLTemplBase.resetPubObj();
                return true;
            }
            case 15: {
                pSPFVLTemplBase.resetTemplCode();
                return true;
            }
            case 16: {
                pSPFVLTemplBase.resetTemplCode2();
                return true;
            }
            case 17: {
                pSPFVLTemplBase.resetTemplCode3();
                return true;
            }
            case 18: {
                pSPFVLTemplBase.resetTemplCode4();
                return true;
            }
            case 19: {
                pSPFVLTemplBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSPFVLTemplBase.resetUpdateMan();
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
    public PSPF getPspf() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPspf();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPspfLock;
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
    public PSViewLogicType getPSViewLogicType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicType();
        }
        if (this.getPSViewLogicTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewLogicTypeLock;
        synchronized (n) {
            if (this.psviewlogictype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewLogicTypeId(), (Object)this.psviewlogictype.getPSViewLogicTypeId()) != 0L) {
                this.psviewlogictype = null;
            }
            if (this.psviewlogictype == null) {
                PSViewLogicType pSViewLogicType = new PSViewLogicType();
                pSViewLogicType.setPSViewLogicTypeId(this.getPSViewLogicTypeId());
                PSViewLogicTypeService pSViewLogicTypeService = (PSViewLogicTypeService)ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewLogicTypeService.autoGet((IEntity)pSViewLogicType);
                this.psviewlogictype = pSViewLogicType;
            }
            return this.psviewlogictype;
        }
    }

    private PSPFVLTemplBase getProxyEntity() {
        return this.proxyPSPFVLTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFVLTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFVLTemplBase) {
            this.proxyPSPFVLTemplBase = (PSPFVLTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFVLTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PROCESSNAME, 3);
        fieldIndexMap.put(FIELD_PSPFID, 4);
        fieldIndexMap.put(FIELD_PSPFNAME, 5);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 6);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 8);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSPFVLTEMPLID, 10);
        fieldIndexMap.put(FIELD_PSPFVLTEMPLNAME, 11);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEID, 12);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPENAME, 13);
        fieldIndexMap.put(FIELD_PUBOBJ, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE, 15);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

