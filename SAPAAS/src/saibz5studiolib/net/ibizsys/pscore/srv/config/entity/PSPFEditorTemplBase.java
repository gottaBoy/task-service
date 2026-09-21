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
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFEditorTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFEditorTemplBase.class);
    public static final String FIELD_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_PSPFEDITORTEMPLID = "PSPFEDITORTEMPLID";
    public static final String FIELD_PSPFEDITORTEMPLNAME = "PSPFEDITORTEMPLNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_REQCODE = "REQCODE";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTAINERTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSEDITORTYPEID = 5;
    private static final int INDEX_PSEDITORTYPENAME = 6;
    private static final int INDEX_PSPFEDITORTEMPLID = 7;
    private static final int INDEX_PSPFEDITORTEMPLNAME = 8;
    private static final int INDEX_PSPFID = 9;
    private static final int INDEX_PSPFNAME = 10;
    private static final int INDEX_PSPFPUBCODEID = 11;
    private static final int INDEX_PSPFPUBCODENAME = 12;
    private static final int INDEX_PSPFSTYLEID = 13;
    private static final int INDEX_PSPFSTYLENAME = 14;
    private static final int INDEX_PUBOBJ = 15;
    private static final int INDEX_REQCODE = 16;
    private static final int INDEX_TEMPLCODE = 17;
    private static final int INDEX_TEMPLCODE2 = 18;
    private static final int INDEX_TEMPLCODE3 = 19;
    private static final int INDEX_TEMPLCODE4 = 20;
    private static final int INDEX_TEMPLDESC = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFEditorTemplBase proxyPSPFEditorTemplBase = null;
    private boolean containertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean pspfeditortemplidDirtyFlag = false;
    private boolean pspfeditortemplnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean reqcodeDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="containertype")
    private String containertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="pspfeditortemplid")
    private String pspfeditortemplid;
    @Column(name="pspfeditortemplname")
    private String pspfeditortemplname;
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
    @Column(name="reqcode")
    private String reqcode;
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
    private Integer objPSEditorTypeLock = new Integer(1);
    private PSEditorType pseditortype = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

    public void setContainerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containertype = string;
        this.containertypeDirtyFlag = true;
    }

    public String getContainerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerType();
        }
        return this.containertype;
    }

    public boolean isContainerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerTypeDirty();
        }
        return this.containertypeDirtyFlag;
    }

    public void resetContainerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerType();
            return;
        }
        this.containertypeDirtyFlag = false;
        this.containertype = null;
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

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
    }

    public void setPSPFEditorTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFEditorTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfeditortemplid = string;
        this.pspfeditortemplidDirtyFlag = true;
    }

    public String getPSPFEditorTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFEditorTemplId();
        }
        return this.pspfeditortemplid;
    }

    public boolean isPSPFEditorTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFEditorTemplIdDirty();
        }
        return this.pspfeditortemplidDirtyFlag;
    }

    public void resetPSPFEditorTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFEditorTemplId();
            return;
        }
        this.pspfeditortemplidDirtyFlag = false;
        this.pspfeditortemplid = null;
    }

    public void setPSPFEditorTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFEditorTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfeditortemplname = string;
        this.pspfeditortemplnameDirtyFlag = true;
    }

    public String getPSPFEditorTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFEditorTemplName();
        }
        return this.pspfeditortemplname;
    }

    public boolean isPSPFEditorTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFEditorTemplNameDirty();
        }
        return this.pspfeditortemplnameDirtyFlag;
    }

    public void resetPSPFEditorTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFEditorTemplName();
            return;
        }
        this.pspfeditortemplnameDirtyFlag = false;
        this.pspfeditortemplname = null;
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

    public void setReqCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqcode = string;
        this.reqcodeDirtyFlag = true;
    }

    public String getReqCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqCode();
        }
        return this.reqcode;
    }

    public boolean isReqCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqCodeDirty();
        }
        return this.reqcodeDirtyFlag;
    }

    public void resetReqCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqCode();
            return;
        }
        this.reqcodeDirtyFlag = false;
        this.reqcode = null;
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
        PSPFEditorTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFEditorTemplBase pSPFEditorTemplBase) {
        pSPFEditorTemplBase.resetContainerType();
        pSPFEditorTemplBase.resetCreateDate();
        pSPFEditorTemplBase.resetCreateMan();
        pSPFEditorTemplBase.resetLogicName();
        pSPFEditorTemplBase.resetMemo();
        pSPFEditorTemplBase.resetPSEditorTypeId();
        pSPFEditorTemplBase.resetPSEditorTypeName();
        pSPFEditorTemplBase.resetPSPFEditorTemplId();
        pSPFEditorTemplBase.resetPSPFEditorTemplName();
        pSPFEditorTemplBase.resetPSPFId();
        pSPFEditorTemplBase.resetPSPFName();
        pSPFEditorTemplBase.resetPSPFPubCodeId();
        pSPFEditorTemplBase.resetPSPFPubCodeName();
        pSPFEditorTemplBase.resetPSPFStyleId();
        pSPFEditorTemplBase.resetPSPFStyleName();
        pSPFEditorTemplBase.resetPubObj();
        pSPFEditorTemplBase.resetReqCode();
        pSPFEditorTemplBase.resetTemplCode();
        pSPFEditorTemplBase.resetTemplCode2();
        pSPFEditorTemplBase.resetTemplCode3();
        pSPFEditorTemplBase.resetTemplCode4();
        pSPFEditorTemplBase.resetTemplDesc();
        pSPFEditorTemplBase.resetUpdateDate();
        pSPFEditorTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContainerTypeDirty()) {
            hashMap.put(FIELD_CONTAINERTYPE, this.getContainerType());
        }
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
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isPSPFEditorTemplIdDirty()) {
            hashMap.put(FIELD_PSPFEDITORTEMPLID, this.getPSPFEditorTemplId());
        }
        if (!bl || this.isPSPFEditorTemplNameDirty()) {
            hashMap.put(FIELD_PSPFEDITORTEMPLNAME, this.getPSPFEditorTemplName());
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
        if (!bl || this.isReqCodeDirty()) {
            hashMap.put(FIELD_REQCODE, this.getReqCode());
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
        return PSPFEditorTemplBase.get(this, n);
    }

    private static Object get(PSPFEditorTemplBase pSPFEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTemplBase.getContainerType();
            }
            case 1: {
                return pSPFEditorTemplBase.getCreateDate();
            }
            case 2: {
                return pSPFEditorTemplBase.getCreateMan();
            }
            case 3: {
                return pSPFEditorTemplBase.getLogicName();
            }
            case 4: {
                return pSPFEditorTemplBase.getMemo();
            }
            case 5: {
                return pSPFEditorTemplBase.getPSEditorTypeId();
            }
            case 6: {
                return pSPFEditorTemplBase.getPSEditorTypeName();
            }
            case 7: {
                return pSPFEditorTemplBase.getPSPFEditorTemplId();
            }
            case 8: {
                return pSPFEditorTemplBase.getPSPFEditorTemplName();
            }
            case 9: {
                return pSPFEditorTemplBase.getPSPFId();
            }
            case 10: {
                return pSPFEditorTemplBase.getPSPFName();
            }
            case 11: {
                return pSPFEditorTemplBase.getPSPFPubCodeId();
            }
            case 12: {
                return pSPFEditorTemplBase.getPSPFPubCodeName();
            }
            case 13: {
                return pSPFEditorTemplBase.getPSPFStyleId();
            }
            case 14: {
                return pSPFEditorTemplBase.getPSPFStyleName();
            }
            case 15: {
                return pSPFEditorTemplBase.getPubObj();
            }
            case 16: {
                return pSPFEditorTemplBase.getReqCode();
            }
            case 17: {
                return pSPFEditorTemplBase.getTemplCode();
            }
            case 18: {
                return pSPFEditorTemplBase.getTemplCode2();
            }
            case 19: {
                return pSPFEditorTemplBase.getTemplCode3();
            }
            case 20: {
                return pSPFEditorTemplBase.getTemplCode4();
            }
            case 21: {
                return pSPFEditorTemplBase.getTemplDesc();
            }
            case 22: {
                return pSPFEditorTemplBase.getUpdateDate();
            }
            case 23: {
                return pSPFEditorTemplBase.getUpdateMan();
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
        PSPFEditorTemplBase.set(this, n, object);
    }

    private static void set(PSPFEditorTemplBase pSPFEditorTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFEditorTemplBase.setContainerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFEditorTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFEditorTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFEditorTemplBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFEditorTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFEditorTemplBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFEditorTemplBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFEditorTemplBase.setPSPFEditorTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFEditorTemplBase.setPSPFEditorTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFEditorTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFEditorTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFEditorTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFEditorTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFEditorTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFEditorTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFEditorTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFEditorTemplBase.setReqCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFEditorTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFEditorTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFEditorTemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFEditorTemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFEditorTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFEditorTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSPFEditorTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFEditorTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFEditorTemplBase pSPFEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTemplBase.getContainerType() == null;
            }
            case 1: {
                return pSPFEditorTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFEditorTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFEditorTemplBase.getLogicName() == null;
            }
            case 4: {
                return pSPFEditorTemplBase.getMemo() == null;
            }
            case 5: {
                return pSPFEditorTemplBase.getPSEditorTypeId() == null;
            }
            case 6: {
                return pSPFEditorTemplBase.getPSEditorTypeName() == null;
            }
            case 7: {
                return pSPFEditorTemplBase.getPSPFEditorTemplId() == null;
            }
            case 8: {
                return pSPFEditorTemplBase.getPSPFEditorTemplName() == null;
            }
            case 9: {
                return pSPFEditorTemplBase.getPSPFId() == null;
            }
            case 10: {
                return pSPFEditorTemplBase.getPSPFName() == null;
            }
            case 11: {
                return pSPFEditorTemplBase.getPSPFPubCodeId() == null;
            }
            case 12: {
                return pSPFEditorTemplBase.getPSPFPubCodeName() == null;
            }
            case 13: {
                return pSPFEditorTemplBase.getPSPFStyleId() == null;
            }
            case 14: {
                return pSPFEditorTemplBase.getPSPFStyleName() == null;
            }
            case 15: {
                return pSPFEditorTemplBase.getPubObj() == null;
            }
            case 16: {
                return pSPFEditorTemplBase.getReqCode() == null;
            }
            case 17: {
                return pSPFEditorTemplBase.getTemplCode() == null;
            }
            case 18: {
                return pSPFEditorTemplBase.getTemplCode2() == null;
            }
            case 19: {
                return pSPFEditorTemplBase.getTemplCode3() == null;
            }
            case 20: {
                return pSPFEditorTemplBase.getTemplCode4() == null;
            }
            case 21: {
                return pSPFEditorTemplBase.getTemplDesc() == null;
            }
            case 22: {
                return pSPFEditorTemplBase.getUpdateDate() == null;
            }
            case 23: {
                return pSPFEditorTemplBase.getUpdateMan() == null;
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
        return PSPFEditorTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFEditorTemplBase pSPFEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTemplBase.isContainerTypeDirty();
            }
            case 1: {
                return pSPFEditorTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFEditorTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSPFEditorTemplBase.isLogicNameDirty();
            }
            case 4: {
                return pSPFEditorTemplBase.isMemoDirty();
            }
            case 5: {
                return pSPFEditorTemplBase.isPSEditorTypeIdDirty();
            }
            case 6: {
                return pSPFEditorTemplBase.isPSEditorTypeNameDirty();
            }
            case 7: {
                return pSPFEditorTemplBase.isPSPFEditorTemplIdDirty();
            }
            case 8: {
                return pSPFEditorTemplBase.isPSPFEditorTemplNameDirty();
            }
            case 9: {
                return pSPFEditorTemplBase.isPSPFIdDirty();
            }
            case 10: {
                return pSPFEditorTemplBase.isPSPFNameDirty();
            }
            case 11: {
                return pSPFEditorTemplBase.isPSPFPubCodeIdDirty();
            }
            case 12: {
                return pSPFEditorTemplBase.isPSPFPubCodeNameDirty();
            }
            case 13: {
                return pSPFEditorTemplBase.isPSPFStyleIdDirty();
            }
            case 14: {
                return pSPFEditorTemplBase.isPSPFStyleNameDirty();
            }
            case 15: {
                return pSPFEditorTemplBase.isPubObjDirty();
            }
            case 16: {
                return pSPFEditorTemplBase.isReqCodeDirty();
            }
            case 17: {
                return pSPFEditorTemplBase.isTemplCodeDirty();
            }
            case 18: {
                return pSPFEditorTemplBase.isTemplCode2Dirty();
            }
            case 19: {
                return pSPFEditorTemplBase.isTemplCode3Dirty();
            }
            case 20: {
                return pSPFEditorTemplBase.isTemplCode4Dirty();
            }
            case 21: {
                return pSPFEditorTemplBase.isTemplDescDirty();
            }
            case 22: {
                return pSPFEditorTemplBase.isUpdateDateDirty();
            }
            case 23: {
                return pSPFEditorTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFEditorTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFEditorTemplBase pSPFEditorTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFEditorTemplBase.getContainerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containertype", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getContainerType()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFEditorTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfeditortemplid", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFEditorTemplId()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFEditorTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfeditortemplname", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFEditorTemplName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getReqCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqcode", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getReqCode()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFEditorTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFEditorTemplBase.getJSONValue((Object)pSPFEditorTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFEditorTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFEditorTemplBase pSPFEditorTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFEditorTemplBase.getContainerType() != null) {
            object = pSPFEditorTemplBase.getContainerType();
            xmlNode.setAttribute(FIELD_CONTAINERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getCreateDate() != null) {
            object = pSPFEditorTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFEditorTemplBase.getCreateMan() != null) {
            object = pSPFEditorTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getLogicName() != null) {
            object = pSPFEditorTemplBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getMemo() != null) {
            object = pSPFEditorTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSEditorTypeId() != null) {
            object = pSPFEditorTemplBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSEditorTypeName() != null) {
            object = pSPFEditorTemplBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFEditorTemplId() != null) {
            object = pSPFEditorTemplBase.getPSPFEditorTemplId();
            xmlNode.setAttribute(FIELD_PSPFEDITORTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFEditorTemplName() != null) {
            object = pSPFEditorTemplBase.getPSPFEditorTemplName();
            xmlNode.setAttribute(FIELD_PSPFEDITORTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFId() != null) {
            object = pSPFEditorTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFName() != null) {
            object = pSPFEditorTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFEditorTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFEditorTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFStyleId() != null) {
            object = pSPFEditorTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPSPFStyleName() != null) {
            object = pSPFEditorTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getPubObj() != null) {
            object = pSPFEditorTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getReqCode() != null) {
            object = pSPFEditorTemplBase.getReqCode();
            xmlNode.setAttribute(FIELD_REQCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode() != null) {
            object = pSPFEditorTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode2() != null) {
            object = pSPFEditorTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode3() != null) {
            object = pSPFEditorTemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getTemplCode4() != null) {
            object = pSPFEditorTemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getTemplDesc() != null) {
            object = pSPFEditorTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTemplBase.getUpdateDate() != null) {
            object = pSPFEditorTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFEditorTemplBase.getUpdateMan() != null) {
            object = pSPFEditorTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFEditorTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFEditorTemplBase pSPFEditorTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFEditorTemplBase.isContainerTypeDirty() && (bl || pSPFEditorTemplBase.getContainerType() != null)) {
            iDataObject.set(FIELD_CONTAINERTYPE, (Object)pSPFEditorTemplBase.getContainerType());
        }
        if (pSPFEditorTemplBase.isCreateDateDirty() && (bl || pSPFEditorTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFEditorTemplBase.getCreateDate());
        }
        if (pSPFEditorTemplBase.isCreateManDirty() && (bl || pSPFEditorTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFEditorTemplBase.getCreateMan());
        }
        if (pSPFEditorTemplBase.isLogicNameDirty() && (bl || pSPFEditorTemplBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPFEditorTemplBase.getLogicName());
        }
        if (pSPFEditorTemplBase.isMemoDirty() && (bl || pSPFEditorTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFEditorTemplBase.getMemo());
        }
        if (pSPFEditorTemplBase.isPSEditorTypeIdDirty() && (bl || pSPFEditorTemplBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSPFEditorTemplBase.getPSEditorTypeId());
        }
        if (pSPFEditorTemplBase.isPSEditorTypeNameDirty() && (bl || pSPFEditorTemplBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSPFEditorTemplBase.getPSEditorTypeName());
        }
        if (pSPFEditorTemplBase.isPSPFEditorTemplIdDirty() && (bl || pSPFEditorTemplBase.getPSPFEditorTemplId() != null)) {
            iDataObject.set(FIELD_PSPFEDITORTEMPLID, (Object)pSPFEditorTemplBase.getPSPFEditorTemplId());
        }
        if (pSPFEditorTemplBase.isPSPFEditorTemplNameDirty() && (bl || pSPFEditorTemplBase.getPSPFEditorTemplName() != null)) {
            iDataObject.set(FIELD_PSPFEDITORTEMPLNAME, (Object)pSPFEditorTemplBase.getPSPFEditorTemplName());
        }
        if (pSPFEditorTemplBase.isPSPFIdDirty() && (bl || pSPFEditorTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFEditorTemplBase.getPSPFId());
        }
        if (pSPFEditorTemplBase.isPSPFNameDirty() && (bl || pSPFEditorTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFEditorTemplBase.getPSPFName());
        }
        if (pSPFEditorTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFEditorTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFEditorTemplBase.getPSPFPubCodeId());
        }
        if (pSPFEditorTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFEditorTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFEditorTemplBase.getPSPFPubCodeName());
        }
        if (pSPFEditorTemplBase.isPSPFStyleIdDirty() && (bl || pSPFEditorTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFEditorTemplBase.getPSPFStyleId());
        }
        if (pSPFEditorTemplBase.isPSPFStyleNameDirty() && (bl || pSPFEditorTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFEditorTemplBase.getPSPFStyleName());
        }
        if (pSPFEditorTemplBase.isPubObjDirty() && (bl || pSPFEditorTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFEditorTemplBase.getPubObj());
        }
        if (pSPFEditorTemplBase.isReqCodeDirty() && (bl || pSPFEditorTemplBase.getReqCode() != null)) {
            iDataObject.set(FIELD_REQCODE, (Object)pSPFEditorTemplBase.getReqCode());
        }
        if (pSPFEditorTemplBase.isTemplCodeDirty() && (bl || pSPFEditorTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFEditorTemplBase.getTemplCode());
        }
        if (pSPFEditorTemplBase.isTemplCode2Dirty() && (bl || pSPFEditorTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFEditorTemplBase.getTemplCode2());
        }
        if (pSPFEditorTemplBase.isTemplCode3Dirty() && (bl || pSPFEditorTemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFEditorTemplBase.getTemplCode3());
        }
        if (pSPFEditorTemplBase.isTemplCode4Dirty() && (bl || pSPFEditorTemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFEditorTemplBase.getTemplCode4());
        }
        if (pSPFEditorTemplBase.isTemplDescDirty() && (bl || pSPFEditorTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFEditorTemplBase.getTemplDesc());
        }
        if (pSPFEditorTemplBase.isUpdateDateDirty() && (bl || pSPFEditorTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFEditorTemplBase.getUpdateDate());
        }
        if (pSPFEditorTemplBase.isUpdateManDirty() && (bl || pSPFEditorTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFEditorTemplBase.getUpdateMan());
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
        return PSPFEditorTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFEditorTemplBase pSPFEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFEditorTemplBase.resetContainerType();
                return true;
            }
            case 1: {
                pSPFEditorTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFEditorTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFEditorTemplBase.resetLogicName();
                return true;
            }
            case 4: {
                pSPFEditorTemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFEditorTemplBase.resetPSEditorTypeId();
                return true;
            }
            case 6: {
                pSPFEditorTemplBase.resetPSEditorTypeName();
                return true;
            }
            case 7: {
                pSPFEditorTemplBase.resetPSPFEditorTemplId();
                return true;
            }
            case 8: {
                pSPFEditorTemplBase.resetPSPFEditorTemplName();
                return true;
            }
            case 9: {
                pSPFEditorTemplBase.resetPSPFId();
                return true;
            }
            case 10: {
                pSPFEditorTemplBase.resetPSPFName();
                return true;
            }
            case 11: {
                pSPFEditorTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 12: {
                pSPFEditorTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 13: {
                pSPFEditorTemplBase.resetPSPFStyleId();
                return true;
            }
            case 14: {
                pSPFEditorTemplBase.resetPSPFStyleName();
                return true;
            }
            case 15: {
                pSPFEditorTemplBase.resetPubObj();
                return true;
            }
            case 16: {
                pSPFEditorTemplBase.resetReqCode();
                return true;
            }
            case 17: {
                pSPFEditorTemplBase.resetTemplCode();
                return true;
            }
            case 18: {
                pSPFEditorTemplBase.resetTemplCode2();
                return true;
            }
            case 19: {
                pSPFEditorTemplBase.resetTemplCode3();
                return true;
            }
            case 20: {
                pSPFEditorTemplBase.resetTemplCode4();
                return true;
            }
            case 21: {
                pSPFEditorTemplBase.resetTemplDesc();
                return true;
            }
            case 22: {
                pSPFEditorTemplBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSPFEditorTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorType getPSEditorType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorType();
        }
        if (this.getPSEditorTypeId() == null) {
            return null;
        }
        Integer n = this.objPSEditorTypeLock;
        synchronized (n) {
            if (this.pseditortype != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorTypeId(), (Object)this.pseditortype.getPSEditorTypeId()) != 0L) {
                this.pseditortype = null;
            }
            if (this.pseditortype == null) {
                PSEditorType pSEditorType = new PSEditorType();
                pSEditorType.setPSEditorTypeId(this.getPSEditorTypeId());
                PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
                pSEditorTypeService.autoGet((IEntity)pSEditorType);
                this.pseditortype = pSEditorType;
            }
            return this.pseditortype;
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

    private PSPFEditorTemplBase getProxyEntity() {
        return this.proxyPSPFEditorTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFEditorTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFEditorTemplBase) {
            this.proxyPSPFEditorTemplBase = (PSPFEditorTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTAINERTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 5);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSPFEDITORTEMPLID, 7);
        fieldIndexMap.put(FIELD_PSPFEDITORTEMPLNAME, 8);
        fieldIndexMap.put(FIELD_PSPFID, 9);
        fieldIndexMap.put(FIELD_PSPFNAME, 10);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 11);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 12);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 13);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 14);
        fieldIndexMap.put(FIELD_PUBOBJ, 15);
        fieldIndexMap.put(FIELD_REQCODE, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 20);
        fieldIndexMap.put(FIELD_TEMPLDESC, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

