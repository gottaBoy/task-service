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
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSysUIActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFUATemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFUATemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFUATEMPLID = "PSPFUATEMPLID";
    public static final String FIELD_PSPFUATEMPLNAME = "PSPFUATEMPLNAME";
    public static final String FIELD_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String FIELD_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
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
    private static final int INDEX_PSPFID = 3;
    private static final int INDEX_PSPFNAME = 4;
    private static final int INDEX_PSPFPUBCODEID = 5;
    private static final int INDEX_PSPFPUBCODENAME = 6;
    private static final int INDEX_PSPFSTYLEID = 7;
    private static final int INDEX_PSPFSTYLENAME = 8;
    private static final int INDEX_PSPFUATEMPLID = 9;
    private static final int INDEX_PSPFUATEMPLNAME = 10;
    private static final int INDEX_PSSYSUIACTIONID = 11;
    private static final int INDEX_PSSYSUIACTIONNAME = 12;
    private static final int INDEX_PUBOBJ = 13;
    private static final int INDEX_TEMPLCODE = 14;
    private static final int INDEX_TEMPLCODE2 = 15;
    private static final int INDEX_TEMPLCODE3 = 16;
    private static final int INDEX_TEMPLCODE4 = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFUATemplBase proxyPSPFUATemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfuatemplidDirtyFlag = false;
    private boolean pspfuatemplnameDirtyFlag = false;
    private boolean pssysuiactionidDirtyFlag = false;
    private boolean pssysuiactionnameDirtyFlag = false;
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
    @Column(name="pspfuatemplid")
    private String pspfuatemplid;
    @Column(name="pspfuatemplname")
    private String pspfuatemplname;
    @Column(name="pssysuiactionid")
    private String pssysuiactionid;
    @Column(name="pssysuiactionname")
    private String pssysuiactionname;
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
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSysUIActionLock = new Integer(1);
    private PSSysUIAction pssysuiaction = null;

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

    public void setPSPFUATemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFUATemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfuatemplid = string;
        this.pspfuatemplidDirtyFlag = true;
    }

    public String getPSPFUATemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFUATemplId();
        }
        return this.pspfuatemplid;
    }

    public boolean isPSPFUATemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFUATemplIdDirty();
        }
        return this.pspfuatemplidDirtyFlag;
    }

    public void resetPSPFUATemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFUATemplId();
            return;
        }
        this.pspfuatemplidDirtyFlag = false;
        this.pspfuatemplid = null;
    }

    public void setPSPFUATemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFUATemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfuatemplname = string;
        this.pspfuatemplnameDirtyFlag = true;
    }

    public String getPSPFUATemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFUATemplName();
        }
        return this.pspfuatemplname;
    }

    public boolean isPSPFUATemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFUATemplNameDirty();
        }
        return this.pspfuatemplnameDirtyFlag;
    }

    public void resetPSPFUATemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFUATemplName();
            return;
        }
        this.pspfuatemplnameDirtyFlag = false;
        this.pspfuatemplname = null;
    }

    public void setPSSysUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionid = string;
        this.pssysuiactionidDirtyFlag = true;
    }

    public String getPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionId();
        }
        return this.pssysuiactionid;
    }

    public boolean isPSSysUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionIdDirty();
        }
        return this.pssysuiactionidDirtyFlag;
    }

    public void resetPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionId();
            return;
        }
        this.pssysuiactionidDirtyFlag = false;
        this.pssysuiactionid = null;
    }

    public void setPSSysUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionname = string;
        this.pssysuiactionnameDirtyFlag = true;
    }

    public String getPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionName();
        }
        return this.pssysuiactionname;
    }

    public boolean isPSSysUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionNameDirty();
        }
        return this.pssysuiactionnameDirtyFlag;
    }

    public void resetPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionName();
            return;
        }
        this.pssysuiactionnameDirtyFlag = false;
        this.pssysuiactionname = null;
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
        PSPFUATemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFUATemplBase pSPFUATemplBase) {
        pSPFUATemplBase.resetCreateDate();
        pSPFUATemplBase.resetCreateMan();
        pSPFUATemplBase.resetMemo();
        pSPFUATemplBase.resetPSPFId();
        pSPFUATemplBase.resetPSPFName();
        pSPFUATemplBase.resetPSPFPubCodeId();
        pSPFUATemplBase.resetPSPFPubCodeName();
        pSPFUATemplBase.resetPSPFStyleId();
        pSPFUATemplBase.resetPSPFStyleName();
        pSPFUATemplBase.resetPSPFUATemplId();
        pSPFUATemplBase.resetPSPFUATemplName();
        pSPFUATemplBase.resetPSSysUIActionId();
        pSPFUATemplBase.resetPSSysUIActionName();
        pSPFUATemplBase.resetPubObj();
        pSPFUATemplBase.resetTemplCode();
        pSPFUATemplBase.resetTemplCode2();
        pSPFUATemplBase.resetTemplCode3();
        pSPFUATemplBase.resetTemplCode4();
        pSPFUATemplBase.resetUpdateDate();
        pSPFUATemplBase.resetUpdateMan();
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
        if (!bl || this.isPSPFUATemplIdDirty()) {
            hashMap.put(FIELD_PSPFUATEMPLID, this.getPSPFUATemplId());
        }
        if (!bl || this.isPSPFUATemplNameDirty()) {
            hashMap.put(FIELD_PSPFUATEMPLNAME, this.getPSPFUATemplName());
        }
        if (!bl || this.isPSSysUIActionIdDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONID, this.getPSSysUIActionId());
        }
        if (!bl || this.isPSSysUIActionNameDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONNAME, this.getPSSysUIActionName());
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
        return PSPFUATemplBase.get(this, n);
    }

    private static Object get(PSPFUATemplBase pSPFUATemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFUATemplBase.getCreateDate();
            }
            case 1: {
                return pSPFUATemplBase.getCreateMan();
            }
            case 2: {
                return pSPFUATemplBase.getMemo();
            }
            case 3: {
                return pSPFUATemplBase.getPSPFId();
            }
            case 4: {
                return pSPFUATemplBase.getPSPFName();
            }
            case 5: {
                return pSPFUATemplBase.getPSPFPubCodeId();
            }
            case 6: {
                return pSPFUATemplBase.getPSPFPubCodeName();
            }
            case 7: {
                return pSPFUATemplBase.getPSPFStyleId();
            }
            case 8: {
                return pSPFUATemplBase.getPSPFStyleName();
            }
            case 9: {
                return pSPFUATemplBase.getPSPFUATemplId();
            }
            case 10: {
                return pSPFUATemplBase.getPSPFUATemplName();
            }
            case 11: {
                return pSPFUATemplBase.getPSSysUIActionId();
            }
            case 12: {
                return pSPFUATemplBase.getPSSysUIActionName();
            }
            case 13: {
                return pSPFUATemplBase.getPubObj();
            }
            case 14: {
                return pSPFUATemplBase.getTemplCode();
            }
            case 15: {
                return pSPFUATemplBase.getTemplCode2();
            }
            case 16: {
                return pSPFUATemplBase.getTemplCode3();
            }
            case 17: {
                return pSPFUATemplBase.getTemplCode4();
            }
            case 18: {
                return pSPFUATemplBase.getUpdateDate();
            }
            case 19: {
                return pSPFUATemplBase.getUpdateMan();
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
        PSPFUATemplBase.set(this, n, object);
    }

    private static void set(PSPFUATemplBase pSPFUATemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFUATemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFUATemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFUATemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFUATemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFUATemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFUATemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFUATemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFUATemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFUATemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFUATemplBase.setPSPFUATemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFUATemplBase.setPSPFUATemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFUATemplBase.setPSSysUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFUATemplBase.setPSSysUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFUATemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFUATemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFUATemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFUATemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFUATemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFUATemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSPFUATemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFUATemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFUATemplBase pSPFUATemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFUATemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFUATemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFUATemplBase.getMemo() == null;
            }
            case 3: {
                return pSPFUATemplBase.getPSPFId() == null;
            }
            case 4: {
                return pSPFUATemplBase.getPSPFName() == null;
            }
            case 5: {
                return pSPFUATemplBase.getPSPFPubCodeId() == null;
            }
            case 6: {
                return pSPFUATemplBase.getPSPFPubCodeName() == null;
            }
            case 7: {
                return pSPFUATemplBase.getPSPFStyleId() == null;
            }
            case 8: {
                return pSPFUATemplBase.getPSPFStyleName() == null;
            }
            case 9: {
                return pSPFUATemplBase.getPSPFUATemplId() == null;
            }
            case 10: {
                return pSPFUATemplBase.getPSPFUATemplName() == null;
            }
            case 11: {
                return pSPFUATemplBase.getPSSysUIActionId() == null;
            }
            case 12: {
                return pSPFUATemplBase.getPSSysUIActionName() == null;
            }
            case 13: {
                return pSPFUATemplBase.getPubObj() == null;
            }
            case 14: {
                return pSPFUATemplBase.getTemplCode() == null;
            }
            case 15: {
                return pSPFUATemplBase.getTemplCode2() == null;
            }
            case 16: {
                return pSPFUATemplBase.getTemplCode3() == null;
            }
            case 17: {
                return pSPFUATemplBase.getTemplCode4() == null;
            }
            case 18: {
                return pSPFUATemplBase.getUpdateDate() == null;
            }
            case 19: {
                return pSPFUATemplBase.getUpdateMan() == null;
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
        return PSPFUATemplBase.contains(this, n);
    }

    private static boolean contains(PSPFUATemplBase pSPFUATemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFUATemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFUATemplBase.isCreateManDirty();
            }
            case 2: {
                return pSPFUATemplBase.isMemoDirty();
            }
            case 3: {
                return pSPFUATemplBase.isPSPFIdDirty();
            }
            case 4: {
                return pSPFUATemplBase.isPSPFNameDirty();
            }
            case 5: {
                return pSPFUATemplBase.isPSPFPubCodeIdDirty();
            }
            case 6: {
                return pSPFUATemplBase.isPSPFPubCodeNameDirty();
            }
            case 7: {
                return pSPFUATemplBase.isPSPFStyleIdDirty();
            }
            case 8: {
                return pSPFUATemplBase.isPSPFStyleNameDirty();
            }
            case 9: {
                return pSPFUATemplBase.isPSPFUATemplIdDirty();
            }
            case 10: {
                return pSPFUATemplBase.isPSPFUATemplNameDirty();
            }
            case 11: {
                return pSPFUATemplBase.isPSSysUIActionIdDirty();
            }
            case 12: {
                return pSPFUATemplBase.isPSSysUIActionNameDirty();
            }
            case 13: {
                return pSPFUATemplBase.isPubObjDirty();
            }
            case 14: {
                return pSPFUATemplBase.isTemplCodeDirty();
            }
            case 15: {
                return pSPFUATemplBase.isTemplCode2Dirty();
            }
            case 16: {
                return pSPFUATemplBase.isTemplCode3Dirty();
            }
            case 17: {
                return pSPFUATemplBase.isTemplCode4Dirty();
            }
            case 18: {
                return pSPFUATemplBase.isUpdateDateDirty();
            }
            case 19: {
                return pSPFUATemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFUATemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFUATemplBase pSPFUATemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFUATemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFUATemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfuatemplid", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFUATemplId()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSPFUATemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfuatemplname", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSPFUATemplName()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSSysUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionid", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSSysUIActionId()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPSSysUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionname", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPSSysUIActionName()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFUATemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFUATemplBase.getJSONValue((Object)pSPFUATemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFUATemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFUATemplBase pSPFUATemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFUATemplBase.getCreateDate() != null) {
            object = pSPFUATemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFUATemplBase.getCreateMan() != null) {
            object = pSPFUATemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getMemo() != null) {
            object = pSPFUATemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFId() != null) {
            object = pSPFUATemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFName() != null) {
            object = pSPFUATemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFPubCodeId() != null) {
            object = pSPFUATemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFPubCodeName() != null) {
            object = pSPFUATemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFStyleId() != null) {
            object = pSPFUATemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFStyleName() != null) {
            object = pSPFUATemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFUATemplId() != null) {
            object = pSPFUATemplBase.getPSPFUATemplId();
            xmlNode.setAttribute(FIELD_PSPFUATEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSPFUATemplName() != null) {
            object = pSPFUATemplBase.getPSPFUATemplName();
            xmlNode.setAttribute(FIELD_PSPFUATEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSSysUIActionId() != null) {
            object = pSPFUATemplBase.getPSSysUIActionId();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPSSysUIActionName() != null) {
            object = pSPFUATemplBase.getPSSysUIActionName();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getPubObj() != null) {
            object = pSPFUATemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getTemplCode() != null) {
            object = pSPFUATemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getTemplCode2() != null) {
            object = pSPFUATemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getTemplCode3() != null) {
            object = pSPFUATemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getTemplCode4() != null) {
            object = pSPFUATemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFUATemplBase.getUpdateDate() != null) {
            object = pSPFUATemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFUATemplBase.getUpdateMan() != null) {
            object = pSPFUATemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFUATemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFUATemplBase pSPFUATemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFUATemplBase.isCreateDateDirty() && (bl || pSPFUATemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFUATemplBase.getCreateDate());
        }
        if (pSPFUATemplBase.isCreateManDirty() && (bl || pSPFUATemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFUATemplBase.getCreateMan());
        }
        if (pSPFUATemplBase.isMemoDirty() && (bl || pSPFUATemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFUATemplBase.getMemo());
        }
        if (pSPFUATemplBase.isPSPFIdDirty() && (bl || pSPFUATemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFUATemplBase.getPSPFId());
        }
        if (pSPFUATemplBase.isPSPFNameDirty() && (bl || pSPFUATemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFUATemplBase.getPSPFName());
        }
        if (pSPFUATemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFUATemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFUATemplBase.getPSPFPubCodeId());
        }
        if (pSPFUATemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFUATemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFUATemplBase.getPSPFPubCodeName());
        }
        if (pSPFUATemplBase.isPSPFStyleIdDirty() && (bl || pSPFUATemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFUATemplBase.getPSPFStyleId());
        }
        if (pSPFUATemplBase.isPSPFStyleNameDirty() && (bl || pSPFUATemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFUATemplBase.getPSPFStyleName());
        }
        if (pSPFUATemplBase.isPSPFUATemplIdDirty() && (bl || pSPFUATemplBase.getPSPFUATemplId() != null)) {
            iDataObject.set(FIELD_PSPFUATEMPLID, (Object)pSPFUATemplBase.getPSPFUATemplId());
        }
        if (pSPFUATemplBase.isPSPFUATemplNameDirty() && (bl || pSPFUATemplBase.getPSPFUATemplName() != null)) {
            iDataObject.set(FIELD_PSPFUATEMPLNAME, (Object)pSPFUATemplBase.getPSPFUATemplName());
        }
        if (pSPFUATemplBase.isPSSysUIActionIdDirty() && (bl || pSPFUATemplBase.getPSSysUIActionId() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONID, (Object)pSPFUATemplBase.getPSSysUIActionId());
        }
        if (pSPFUATemplBase.isPSSysUIActionNameDirty() && (bl || pSPFUATemplBase.getPSSysUIActionName() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONNAME, (Object)pSPFUATemplBase.getPSSysUIActionName());
        }
        if (pSPFUATemplBase.isPubObjDirty() && (bl || pSPFUATemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFUATemplBase.getPubObj());
        }
        if (pSPFUATemplBase.isTemplCodeDirty() && (bl || pSPFUATemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFUATemplBase.getTemplCode());
        }
        if (pSPFUATemplBase.isTemplCode2Dirty() && (bl || pSPFUATemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFUATemplBase.getTemplCode2());
        }
        if (pSPFUATemplBase.isTemplCode3Dirty() && (bl || pSPFUATemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFUATemplBase.getTemplCode3());
        }
        if (pSPFUATemplBase.isTemplCode4Dirty() && (bl || pSPFUATemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFUATemplBase.getTemplCode4());
        }
        if (pSPFUATemplBase.isUpdateDateDirty() && (bl || pSPFUATemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFUATemplBase.getUpdateDate());
        }
        if (pSPFUATemplBase.isUpdateManDirty() && (bl || pSPFUATemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFUATemplBase.getUpdateMan());
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
        return PSPFUATemplBase.remove(this, n);
    }

    private static boolean remove(PSPFUATemplBase pSPFUATemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFUATemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFUATemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFUATemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFUATemplBase.resetPSPFId();
                return true;
            }
            case 4: {
                pSPFUATemplBase.resetPSPFName();
                return true;
            }
            case 5: {
                pSPFUATemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 6: {
                pSPFUATemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 7: {
                pSPFUATemplBase.resetPSPFStyleId();
                return true;
            }
            case 8: {
                pSPFUATemplBase.resetPSPFStyleName();
                return true;
            }
            case 9: {
                pSPFUATemplBase.resetPSPFUATemplId();
                return true;
            }
            case 10: {
                pSPFUATemplBase.resetPSPFUATemplName();
                return true;
            }
            case 11: {
                pSPFUATemplBase.resetPSSysUIActionId();
                return true;
            }
            case 12: {
                pSPFUATemplBase.resetPSSysUIActionName();
                return true;
            }
            case 13: {
                pSPFUATemplBase.resetPubObj();
                return true;
            }
            case 14: {
                pSPFUATemplBase.resetTemplCode();
                return true;
            }
            case 15: {
                pSPFUATemplBase.resetTemplCode2();
                return true;
            }
            case 16: {
                pSPFUATemplBase.resetTemplCode3();
                return true;
            }
            case 17: {
                pSPFUATemplBase.resetTemplCode4();
                return true;
            }
            case 18: {
                pSPFUATemplBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSPFUATemplBase.resetUpdateMan();
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
    public PSSysUIAction getPSSysUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIAction();
        }
        if (this.getPSSysUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSSysUIActionLock;
        synchronized (n) {
            if (this.pssysuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUIActionId(), (Object)this.pssysuiaction.getPSSysUIActionId()) != 0L) {
                this.pssysuiaction = null;
            }
            if (this.pssysuiaction == null) {
                PSSysUIAction pSSysUIAction = new PSSysUIAction();
                pSSysUIAction.setPSSysUIActionId(this.getPSSysUIActionId());
                PSSysUIActionService pSSysUIActionService = (PSSysUIActionService)ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSSysUIActionService.autoGet(pSSysUIAction);
                this.pssysuiaction = pSSysUIAction;
            }
            return this.pssysuiaction;
        }
    }

    private PSPFUATemplBase getProxyEntity() {
        return this.proxyPSPFUATemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFUATemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFUATemplBase) {
            this.proxyPSPFUATemplBase = (PSPFUATemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFUATemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPFID, 3);
        fieldIndexMap.put(FIELD_PSPFNAME, 4);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 5);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_PSPFUATEMPLID, 9);
        fieldIndexMap.put(FIELD_PSPFUATEMPLNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONID, 11);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONNAME, 12);
        fieldIndexMap.put(FIELD_PUBOBJ, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 15);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

