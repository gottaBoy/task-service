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
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionType;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpSectionTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSHELPSECTIONTEMPLID = "PSHELPSECTIONTEMPLID";
    public static final String FIELD_PSHELPSECTIONTEMPLNAME = "PSHELPSECTIONTEMPLNAME";
    public static final String FIELD_PSHELPSECTIONTYPEID = "PSHELPSECTIONTYPEID";
    public static final String FIELD_PSHELPSECTIONTYPENAME = "PSHELPSECTIONTYPENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_PSHELPSECTIONTEMPLID = 6;
    private static final int INDEX_PSHELPSECTIONTEMPLNAME = 7;
    private static final int INDEX_PSHELPSECTIONTYPEID = 8;
    private static final int INDEX_PSHELPSECTIONTYPENAME = 9;
    private static final int INDEX_PUBMODE = 10;
    private static final int INDEX_PUBOBJ = 11;
    private static final int INDEX_TEMPLCODE = 12;
    private static final int INDEX_TEMPLCODE2 = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpSectionTemplBase proxyPSHelpSectionTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pshelpsectiontemplidDirtyFlag = false;
    private boolean pshelpsectiontemplnameDirtyFlag = false;
    private boolean pshelpsectiontypeidDirtyFlag = false;
    private boolean pshelpsectiontypenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pshelpsectiontemplid")
    private String pshelpsectiontemplid;
    @Column(name="pshelpsectiontemplname")
    private String pshelpsectiontemplname;
    @Column(name="pshelpsectiontypeid")
    private String pshelpsectiontypeid;
    @Column(name="pshelpsectiontypename")
    private String pshelpsectiontypename;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSHelpArticleTypeLock = new Integer(1);
    private PSHelpSectionType pshelparticletype = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSHelpSectionTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplid = string;
        this.pshelpsectiontemplidDirtyFlag = true;
    }

    public String getPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplId();
        }
        return this.pshelpsectiontemplid;
    }

    public boolean isPSHelpSectionTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplIdDirty();
        }
        return this.pshelpsectiontemplidDirtyFlag;
    }

    public void resetPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplId();
            return;
        }
        this.pshelpsectiontemplidDirtyFlag = false;
        this.pshelpsectiontemplid = null;
    }

    public void setPSHelpSectionTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplname = string;
        this.pshelpsectiontemplnameDirtyFlag = true;
    }

    public String getPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplName();
        }
        return this.pshelpsectiontemplname;
    }

    public boolean isPSHelpSectionTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplNameDirty();
        }
        return this.pshelpsectiontemplnameDirtyFlag;
    }

    public void resetPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplName();
            return;
        }
        this.pshelpsectiontemplnameDirtyFlag = false;
        this.pshelpsectiontemplname = null;
    }

    public void setPSHelpSectionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypeid = string;
        this.pshelpsectiontypeidDirtyFlag = true;
    }

    public String getPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeId();
        }
        return this.pshelpsectiontypeid;
    }

    public boolean isPSHelpSectionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeIdDirty();
        }
        return this.pshelpsectiontypeidDirtyFlag;
    }

    public void resetPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeId();
            return;
        }
        this.pshelpsectiontypeidDirtyFlag = false;
        this.pshelpsectiontypeid = null;
    }

    public void setPSHelpSectionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypename = string;
        this.pshelpsectiontypenameDirtyFlag = true;
    }

    public String getPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeName();
        }
        return this.pshelpsectiontypename;
    }

    public boolean isPSHelpSectionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeNameDirty();
        }
        return this.pshelpsectiontypenameDirtyFlag;
    }

    public void resetPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeName();
            return;
        }
        this.pshelpsectiontypenameDirtyFlag = false;
        this.pshelpsectiontypename = null;
    }

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
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
        PSHelpSectionTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpSectionTemplBase pSHelpSectionTemplBase) {
        pSHelpSectionTemplBase.resetCreateDate();
        pSHelpSectionTemplBase.resetCreateMan();
        pSHelpSectionTemplBase.resetDefaultFlag();
        pSHelpSectionTemplBase.resetMemo();
        pSHelpSectionTemplBase.resetPSDevCenterId();
        pSHelpSectionTemplBase.resetPSDevCenterName();
        pSHelpSectionTemplBase.resetPSHelpSectionTemplId();
        pSHelpSectionTemplBase.resetPSHelpSectionTemplName();
        pSHelpSectionTemplBase.resetPSHelpSectionTypeId();
        pSHelpSectionTemplBase.resetPSHelpSectionTypeName();
        pSHelpSectionTemplBase.resetPubMode();
        pSHelpSectionTemplBase.resetPubObj();
        pSHelpSectionTemplBase.resetTemplCode();
        pSHelpSectionTemplBase.resetTemplCode2();
        pSHelpSectionTemplBase.resetUpdateDate();
        pSHelpSectionTemplBase.resetUpdateMan();
        pSHelpSectionTemplBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSHelpSectionTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLID, this.getPSHelpSectionTemplId());
        }
        if (!bl || this.isPSHelpSectionTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLNAME, this.getPSHelpSectionTemplName());
        }
        if (!bl || this.isPSHelpSectionTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPEID, this.getPSHelpSectionTypeId());
        }
        if (!bl || this.isPSHelpSectionTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPENAME, this.getPSHelpSectionTypeName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
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
        return PSHelpSectionTemplBase.get(this, n);
    }

    private static Object get(PSHelpSectionTemplBase pSHelpSectionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTemplBase.getCreateDate();
            }
            case 1: {
                return pSHelpSectionTemplBase.getCreateMan();
            }
            case 2: {
                return pSHelpSectionTemplBase.getDefaultFlag();
            }
            case 3: {
                return pSHelpSectionTemplBase.getMemo();
            }
            case 4: {
                return pSHelpSectionTemplBase.getPSDevCenterId();
            }
            case 5: {
                return pSHelpSectionTemplBase.getPSDevCenterName();
            }
            case 6: {
                return pSHelpSectionTemplBase.getPSHelpSectionTemplId();
            }
            case 7: {
                return pSHelpSectionTemplBase.getPSHelpSectionTemplName();
            }
            case 8: {
                return pSHelpSectionTemplBase.getPSHelpSectionTypeId();
            }
            case 9: {
                return pSHelpSectionTemplBase.getPSHelpSectionTypeName();
            }
            case 10: {
                return pSHelpSectionTemplBase.getPubMode();
            }
            case 11: {
                return pSHelpSectionTemplBase.getPubObj();
            }
            case 12: {
                return pSHelpSectionTemplBase.getTemplCode();
            }
            case 13: {
                return pSHelpSectionTemplBase.getTemplCode2();
            }
            case 14: {
                return pSHelpSectionTemplBase.getUpdateDate();
            }
            case 15: {
                return pSHelpSectionTemplBase.getUpdateMan();
            }
            case 16: {
                return pSHelpSectionTemplBase.getValidFlag();
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
        PSHelpSectionTemplBase.set(this, n, object);
    }

    private static void set(PSHelpSectionTemplBase pSHelpSectionTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpSectionTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpSectionTemplBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSHelpSectionTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpSectionTemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpSectionTemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpSectionTemplBase.setPSHelpSectionTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpSectionTemplBase.setPSHelpSectionTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpSectionTemplBase.setPSHelpSectionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpSectionTemplBase.setPSHelpSectionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpSectionTemplBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSHelpSectionTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpSectionTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpSectionTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpSectionTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSHelpSectionTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpSectionTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpSectionTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpSectionTemplBase pSHelpSectionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpSectionTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpSectionTemplBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSHelpSectionTemplBase.getMemo() == null;
            }
            case 4: {
                return pSHelpSectionTemplBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSHelpSectionTemplBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSHelpSectionTemplBase.getPSHelpSectionTemplId() == null;
            }
            case 7: {
                return pSHelpSectionTemplBase.getPSHelpSectionTemplName() == null;
            }
            case 8: {
                return pSHelpSectionTemplBase.getPSHelpSectionTypeId() == null;
            }
            case 9: {
                return pSHelpSectionTemplBase.getPSHelpSectionTypeName() == null;
            }
            case 10: {
                return pSHelpSectionTemplBase.getPubMode() == null;
            }
            case 11: {
                return pSHelpSectionTemplBase.getPubObj() == null;
            }
            case 12: {
                return pSHelpSectionTemplBase.getTemplCode() == null;
            }
            case 13: {
                return pSHelpSectionTemplBase.getTemplCode2() == null;
            }
            case 14: {
                return pSHelpSectionTemplBase.getUpdateDate() == null;
            }
            case 15: {
                return pSHelpSectionTemplBase.getUpdateMan() == null;
            }
            case 16: {
                return pSHelpSectionTemplBase.getValidFlag() == null;
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
        return PSHelpSectionTemplBase.contains(this, n);
    }

    private static boolean contains(PSHelpSectionTemplBase pSHelpSectionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpSectionTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpSectionTemplBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSHelpSectionTemplBase.isMemoDirty();
            }
            case 4: {
                return pSHelpSectionTemplBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSHelpSectionTemplBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSHelpSectionTemplBase.isPSHelpSectionTemplIdDirty();
            }
            case 7: {
                return pSHelpSectionTemplBase.isPSHelpSectionTemplNameDirty();
            }
            case 8: {
                return pSHelpSectionTemplBase.isPSHelpSectionTypeIdDirty();
            }
            case 9: {
                return pSHelpSectionTemplBase.isPSHelpSectionTypeNameDirty();
            }
            case 10: {
                return pSHelpSectionTemplBase.isPubModeDirty();
            }
            case 11: {
                return pSHelpSectionTemplBase.isPubObjDirty();
            }
            case 12: {
                return pSHelpSectionTemplBase.isTemplCodeDirty();
            }
            case 13: {
                return pSHelpSectionTemplBase.isTemplCode2Dirty();
            }
            case 14: {
                return pSHelpSectionTemplBase.isUpdateDateDirty();
            }
            case 15: {
                return pSHelpSectionTemplBase.isUpdateManDirty();
            }
            case 16: {
                return pSHelpSectionTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpSectionTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpSectionTemplBase pSHelpSectionTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpSectionTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplid", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSHelpSectionTemplId()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplname", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSHelpSectionTemplName()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypeid", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSHelpSectionTypeId()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypename", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPSHelpSectionTypeName()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPubMode()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpSectionTemplBase.getJSONValue((Object)pSHelpSectionTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpSectionTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpSectionTemplBase pSHelpSectionTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpSectionTemplBase.getCreateDate() != null) {
            object = pSHelpSectionTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionTemplBase.getCreateMan() != null) {
            object = pSHelpSectionTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getDefaultFlag() != null) {
            object = pSHelpSectionTemplBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionTemplBase.getMemo() != null) {
            object = pSHelpSectionTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSDevCenterId() != null) {
            object = pSHelpSectionTemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSDevCenterName() != null) {
            object = pSHelpSectionTemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplId() != null) {
            object = pSHelpSectionTemplBase.getPSHelpSectionTemplId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplName() != null) {
            object = pSHelpSectionTemplBase.getPSHelpSectionTemplName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeId() != null) {
            object = pSHelpSectionTemplBase.getPSHelpSectionTypeId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeName() != null) {
            object = pSHelpSectionTemplBase.getPSHelpSectionTypeName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getPubMode() != null) {
            object = pSHelpSectionTemplBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionTemplBase.getPubObj() != null) {
            object = pSHelpSectionTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getTemplCode() != null) {
            object = pSHelpSectionTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getTemplCode2() != null) {
            object = pSHelpSectionTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getUpdateDate() != null) {
            object = pSHelpSectionTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionTemplBase.getUpdateMan() != null) {
            object = pSHelpSectionTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTemplBase.getValidFlag() != null) {
            object = pSHelpSectionTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpSectionTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpSectionTemplBase pSHelpSectionTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpSectionTemplBase.isCreateDateDirty() && (bl || pSHelpSectionTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpSectionTemplBase.getCreateDate());
        }
        if (pSHelpSectionTemplBase.isCreateManDirty() && (bl || pSHelpSectionTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpSectionTemplBase.getCreateMan());
        }
        if (pSHelpSectionTemplBase.isDefaultFlagDirty() && (bl || pSHelpSectionTemplBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSHelpSectionTemplBase.getDefaultFlag());
        }
        if (pSHelpSectionTemplBase.isMemoDirty() && (bl || pSHelpSectionTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpSectionTemplBase.getMemo());
        }
        if (pSHelpSectionTemplBase.isPSDevCenterIdDirty() && (bl || pSHelpSectionTemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSHelpSectionTemplBase.getPSDevCenterId());
        }
        if (pSHelpSectionTemplBase.isPSDevCenterNameDirty() && (bl || pSHelpSectionTemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSHelpSectionTemplBase.getPSDevCenterName());
        }
        if (pSHelpSectionTemplBase.isPSHelpSectionTemplIdDirty() && (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLID, (Object)pSHelpSectionTemplBase.getPSHelpSectionTemplId());
        }
        if (pSHelpSectionTemplBase.isPSHelpSectionTemplNameDirty() && (bl || pSHelpSectionTemplBase.getPSHelpSectionTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLNAME, (Object)pSHelpSectionTemplBase.getPSHelpSectionTemplName());
        }
        if (pSHelpSectionTemplBase.isPSHelpSectionTypeIdDirty() && (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPEID, (Object)pSHelpSectionTemplBase.getPSHelpSectionTypeId());
        }
        if (pSHelpSectionTemplBase.isPSHelpSectionTypeNameDirty() && (bl || pSHelpSectionTemplBase.getPSHelpSectionTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPENAME, (Object)pSHelpSectionTemplBase.getPSHelpSectionTypeName());
        }
        if (pSHelpSectionTemplBase.isPubModeDirty() && (bl || pSHelpSectionTemplBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSHelpSectionTemplBase.getPubMode());
        }
        if (pSHelpSectionTemplBase.isPubObjDirty() && (bl || pSHelpSectionTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpSectionTemplBase.getPubObj());
        }
        if (pSHelpSectionTemplBase.isTemplCodeDirty() && (bl || pSHelpSectionTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSHelpSectionTemplBase.getTemplCode());
        }
        if (pSHelpSectionTemplBase.isTemplCode2Dirty() && (bl || pSHelpSectionTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSHelpSectionTemplBase.getTemplCode2());
        }
        if (pSHelpSectionTemplBase.isUpdateDateDirty() && (bl || pSHelpSectionTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpSectionTemplBase.getUpdateDate());
        }
        if (pSHelpSectionTemplBase.isUpdateManDirty() && (bl || pSHelpSectionTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpSectionTemplBase.getUpdateMan());
        }
        if (pSHelpSectionTemplBase.isValidFlagDirty() && (bl || pSHelpSectionTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpSectionTemplBase.getValidFlag());
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
        return PSHelpSectionTemplBase.remove(this, n);
    }

    private static boolean remove(PSHelpSectionTemplBase pSHelpSectionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpSectionTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpSectionTemplBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSHelpSectionTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSHelpSectionTemplBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSHelpSectionTemplBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSHelpSectionTemplBase.resetPSHelpSectionTemplId();
                return true;
            }
            case 7: {
                pSHelpSectionTemplBase.resetPSHelpSectionTemplName();
                return true;
            }
            case 8: {
                pSHelpSectionTemplBase.resetPSHelpSectionTypeId();
                return true;
            }
            case 9: {
                pSHelpSectionTemplBase.resetPSHelpSectionTypeName();
                return true;
            }
            case 10: {
                pSHelpSectionTemplBase.resetPubMode();
                return true;
            }
            case 11: {
                pSHelpSectionTemplBase.resetPubObj();
                return true;
            }
            case 12: {
                pSHelpSectionTemplBase.resetTemplCode();
                return true;
            }
            case 13: {
                pSHelpSectionTemplBase.resetTemplCode2();
                return true;
            }
            case 14: {
                pSHelpSectionTemplBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSHelpSectionTemplBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSHelpSectionTemplBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpSectionType getPSHelpArticleType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleType();
        }
        if (this.getPSHelpSectionTypeId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleTypeLock;
        synchronized (n) {
            if (this.pshelparticletype != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpSectionTypeId(), (Object)this.pshelparticletype.getPSHelpSectionTypeId()) != 0L) {
                this.pshelparticletype = null;
            }
            if (this.pshelparticletype == null) {
                PSHelpSectionType pSHelpSectionType = new PSHelpSectionType();
                pSHelpSectionType.setPSHelpSectionTypeId(this.getPSHelpSectionTypeId());
                PSHelpSectionTypeService pSHelpSectionTypeService = (PSHelpSectionTypeService)ServiceGlobal.getService(PSHelpSectionTypeService.class, (SessionFactory)this.getSessionFactory());
                pSHelpSectionTypeService.autoGet(pSHelpSectionType);
                this.pshelparticletype = pSHelpSectionType;
            }
            return this.pshelparticletype;
        }
    }

    private PSHelpSectionTemplBase getProxyEntity() {
        return this.proxyPSHelpSectionTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpSectionTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpSectionTemplBase) {
            this.proxyPSHelpSectionTemplBase = (PSHelpSectionTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPEID, 8);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPENAME, 9);
        fieldIndexMap.put(FIELD_PUBMODE, 10);
        fieldIndexMap.put(FIELD_PUBOBJ, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE, 12);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

