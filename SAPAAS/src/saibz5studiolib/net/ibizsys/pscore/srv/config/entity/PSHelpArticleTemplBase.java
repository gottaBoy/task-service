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
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpArticleTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSHELPARTICLETEMPLID = "PSHELPARTICLETEMPLID";
    public static final String FIELD_PSHELPARTICLETEMPLNAME = "PSHELPARTICLETEMPLNAME";
    public static final String FIELD_PSHELPARTICLETYPEID = "PSHELPARTICLETYPEID";
    public static final String FIELD_PSHELPARTICLETYPENAME = "PSHELPARTICLETYPENAME";
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
    private static final int INDEX_PSHELPARTICLETEMPLID = 6;
    private static final int INDEX_PSHELPARTICLETEMPLNAME = 7;
    private static final int INDEX_PSHELPARTICLETYPEID = 8;
    private static final int INDEX_PSHELPARTICLETYPENAME = 9;
    private static final int INDEX_PUBMODE = 10;
    private static final int INDEX_PUBOBJ = 11;
    private static final int INDEX_TEMPLCODE = 12;
    private static final int INDEX_TEMPLCODE2 = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpArticleTemplBase proxyPSHelpArticleTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pshelparticletemplidDirtyFlag = false;
    private boolean pshelparticletemplnameDirtyFlag = false;
    private boolean pshelparticletypeidDirtyFlag = false;
    private boolean pshelparticletypenameDirtyFlag = false;
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
    @Column(name="pshelparticletemplid")
    private String pshelparticletemplid;
    @Column(name="pshelparticletemplname")
    private String pshelparticletemplname;
    @Column(name="pshelparticletypeid")
    private String pshelparticletypeid;
    @Column(name="pshelparticletypename")
    private String pshelparticletypename;
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
    private PSHelpArticleType pshelparticletype = null;

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

    public void setPSHelpArticleTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletemplid = string;
        this.pshelparticletemplidDirtyFlag = true;
    }

    public String getPSHelpArticleTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTemplId();
        }
        return this.pshelparticletemplid;
    }

    public boolean isPSHelpArticleTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTemplIdDirty();
        }
        return this.pshelparticletemplidDirtyFlag;
    }

    public void resetPSHelpArticleTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTemplId();
            return;
        }
        this.pshelparticletemplidDirtyFlag = false;
        this.pshelparticletemplid = null;
    }

    public void setPSHelpArticleTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletemplname = string;
        this.pshelparticletemplnameDirtyFlag = true;
    }

    public String getPSHelpArticleTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTemplName();
        }
        return this.pshelparticletemplname;
    }

    public boolean isPSHelpArticleTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTemplNameDirty();
        }
        return this.pshelparticletemplnameDirtyFlag;
    }

    public void resetPSHelpArticleTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTemplName();
            return;
        }
        this.pshelparticletemplnameDirtyFlag = false;
        this.pshelparticletemplname = null;
    }

    public void setPSHelpArticleTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletypeid = string;
        this.pshelparticletypeidDirtyFlag = true;
    }

    public String getPSHelpArticleTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTypeId();
        }
        return this.pshelparticletypeid;
    }

    public boolean isPSHelpArticleTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTypeIdDirty();
        }
        return this.pshelparticletypeidDirtyFlag;
    }

    public void resetPSHelpArticleTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTypeId();
            return;
        }
        this.pshelparticletypeidDirtyFlag = false;
        this.pshelparticletypeid = null;
    }

    public void setPSHelpArticleTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticletypename = string;
        this.pshelparticletypenameDirtyFlag = true;
    }

    public String getPSHelpArticleTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleTypeName();
        }
        return this.pshelparticletypename;
    }

    public boolean isPSHelpArticleTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleTypeNameDirty();
        }
        return this.pshelparticletypenameDirtyFlag;
    }

    public void resetPSHelpArticleTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleTypeName();
            return;
        }
        this.pshelparticletypenameDirtyFlag = false;
        this.pshelparticletypename = null;
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
        PSHelpArticleTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpArticleTemplBase pSHelpArticleTemplBase) {
        pSHelpArticleTemplBase.resetCreateDate();
        pSHelpArticleTemplBase.resetCreateMan();
        pSHelpArticleTemplBase.resetDefaultFlag();
        pSHelpArticleTemplBase.resetMemo();
        pSHelpArticleTemplBase.resetPSDevCenterId();
        pSHelpArticleTemplBase.resetPSDevCenterName();
        pSHelpArticleTemplBase.resetPSHelpArticleTemplId();
        pSHelpArticleTemplBase.resetPSHelpArticleTemplName();
        pSHelpArticleTemplBase.resetPSHelpArticleTypeId();
        pSHelpArticleTemplBase.resetPSHelpArticleTypeName();
        pSHelpArticleTemplBase.resetPubMode();
        pSHelpArticleTemplBase.resetPubObj();
        pSHelpArticleTemplBase.resetTemplCode();
        pSHelpArticleTemplBase.resetTemplCode2();
        pSHelpArticleTemplBase.resetUpdateDate();
        pSHelpArticleTemplBase.resetUpdateMan();
        pSHelpArticleTemplBase.resetValidFlag();
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
        if (!bl || this.isPSHelpArticleTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETEMPLID, this.getPSHelpArticleTemplId());
        }
        if (!bl || this.isPSHelpArticleTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETEMPLNAME, this.getPSHelpArticleTemplName());
        }
        if (!bl || this.isPSHelpArticleTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPEID, this.getPSHelpArticleTypeId());
        }
        if (!bl || this.isPSHelpArticleTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLETYPENAME, this.getPSHelpArticleTypeName());
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
        return PSHelpArticleTemplBase.get(this, n);
    }

    private static Object get(PSHelpArticleTemplBase pSHelpArticleTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTemplBase.getCreateDate();
            }
            case 1: {
                return pSHelpArticleTemplBase.getCreateMan();
            }
            case 2: {
                return pSHelpArticleTemplBase.getDefaultFlag();
            }
            case 3: {
                return pSHelpArticleTemplBase.getMemo();
            }
            case 4: {
                return pSHelpArticleTemplBase.getPSDevCenterId();
            }
            case 5: {
                return pSHelpArticleTemplBase.getPSDevCenterName();
            }
            case 6: {
                return pSHelpArticleTemplBase.getPSHelpArticleTemplId();
            }
            case 7: {
                return pSHelpArticleTemplBase.getPSHelpArticleTemplName();
            }
            case 8: {
                return pSHelpArticleTemplBase.getPSHelpArticleTypeId();
            }
            case 9: {
                return pSHelpArticleTemplBase.getPSHelpArticleTypeName();
            }
            case 10: {
                return pSHelpArticleTemplBase.getPubMode();
            }
            case 11: {
                return pSHelpArticleTemplBase.getPubObj();
            }
            case 12: {
                return pSHelpArticleTemplBase.getTemplCode();
            }
            case 13: {
                return pSHelpArticleTemplBase.getTemplCode2();
            }
            case 14: {
                return pSHelpArticleTemplBase.getUpdateDate();
            }
            case 15: {
                return pSHelpArticleTemplBase.getUpdateMan();
            }
            case 16: {
                return pSHelpArticleTemplBase.getValidFlag();
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
        PSHelpArticleTemplBase.set(this, n, object);
    }

    private static void set(PSHelpArticleTemplBase pSHelpArticleTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpArticleTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpArticleTemplBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSHelpArticleTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpArticleTemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpArticleTemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpArticleTemplBase.setPSHelpArticleTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpArticleTemplBase.setPSHelpArticleTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpArticleTemplBase.setPSHelpArticleTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpArticleTemplBase.setPSHelpArticleTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpArticleTemplBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSHelpArticleTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpArticleTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpArticleTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpArticleTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSHelpArticleTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpArticleTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpArticleTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpArticleTemplBase pSHelpArticleTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpArticleTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpArticleTemplBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSHelpArticleTemplBase.getMemo() == null;
            }
            case 4: {
                return pSHelpArticleTemplBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSHelpArticleTemplBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSHelpArticleTemplBase.getPSHelpArticleTemplId() == null;
            }
            case 7: {
                return pSHelpArticleTemplBase.getPSHelpArticleTemplName() == null;
            }
            case 8: {
                return pSHelpArticleTemplBase.getPSHelpArticleTypeId() == null;
            }
            case 9: {
                return pSHelpArticleTemplBase.getPSHelpArticleTypeName() == null;
            }
            case 10: {
                return pSHelpArticleTemplBase.getPubMode() == null;
            }
            case 11: {
                return pSHelpArticleTemplBase.getPubObj() == null;
            }
            case 12: {
                return pSHelpArticleTemplBase.getTemplCode() == null;
            }
            case 13: {
                return pSHelpArticleTemplBase.getTemplCode2() == null;
            }
            case 14: {
                return pSHelpArticleTemplBase.getUpdateDate() == null;
            }
            case 15: {
                return pSHelpArticleTemplBase.getUpdateMan() == null;
            }
            case 16: {
                return pSHelpArticleTemplBase.getValidFlag() == null;
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
        return PSHelpArticleTemplBase.contains(this, n);
    }

    private static boolean contains(PSHelpArticleTemplBase pSHelpArticleTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpArticleTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpArticleTemplBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSHelpArticleTemplBase.isMemoDirty();
            }
            case 4: {
                return pSHelpArticleTemplBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSHelpArticleTemplBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSHelpArticleTemplBase.isPSHelpArticleTemplIdDirty();
            }
            case 7: {
                return pSHelpArticleTemplBase.isPSHelpArticleTemplNameDirty();
            }
            case 8: {
                return pSHelpArticleTemplBase.isPSHelpArticleTypeIdDirty();
            }
            case 9: {
                return pSHelpArticleTemplBase.isPSHelpArticleTypeNameDirty();
            }
            case 10: {
                return pSHelpArticleTemplBase.isPubModeDirty();
            }
            case 11: {
                return pSHelpArticleTemplBase.isPubObjDirty();
            }
            case 12: {
                return pSHelpArticleTemplBase.isTemplCodeDirty();
            }
            case 13: {
                return pSHelpArticleTemplBase.isTemplCode2Dirty();
            }
            case 14: {
                return pSHelpArticleTemplBase.isUpdateDateDirty();
            }
            case 15: {
                return pSHelpArticleTemplBase.isUpdateManDirty();
            }
            case 16: {
                return pSHelpArticleTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpArticleTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpArticleTemplBase pSHelpArticleTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpArticleTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletemplid", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSHelpArticleTemplId()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletemplname", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSHelpArticleTemplName()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypeid", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSHelpArticleTypeId()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticletypename", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPSHelpArticleTypeName()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPubMode()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpArticleTemplBase.getJSONValue((Object)pSHelpArticleTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpArticleTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpArticleTemplBase pSHelpArticleTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpArticleTemplBase.getCreateDate() != null) {
            object = pSHelpArticleTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleTemplBase.getCreateMan() != null) {
            object = pSHelpArticleTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getDefaultFlag() != null) {
            object = pSHelpArticleTemplBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleTemplBase.getMemo() != null) {
            object = pSHelpArticleTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSDevCenterId() != null) {
            object = pSHelpArticleTemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSDevCenterName() != null) {
            object = pSHelpArticleTemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplId() != null) {
            object = pSHelpArticleTemplBase.getPSHelpArticleTemplId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplName() != null) {
            object = pSHelpArticleTemplBase.getPSHelpArticleTemplName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeId() != null) {
            object = pSHelpArticleTemplBase.getPSHelpArticleTypeId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeName() != null) {
            object = pSHelpArticleTemplBase.getPSHelpArticleTypeName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getPubMode() != null) {
            object = pSHelpArticleTemplBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleTemplBase.getPubObj() != null) {
            object = pSHelpArticleTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getTemplCode() != null) {
            object = pSHelpArticleTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getTemplCode2() != null) {
            object = pSHelpArticleTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getUpdateDate() != null) {
            object = pSHelpArticleTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleTemplBase.getUpdateMan() != null) {
            object = pSHelpArticleTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleTemplBase.getValidFlag() != null) {
            object = pSHelpArticleTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpArticleTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpArticleTemplBase pSHelpArticleTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpArticleTemplBase.isCreateDateDirty() && (bl || pSHelpArticleTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpArticleTemplBase.getCreateDate());
        }
        if (pSHelpArticleTemplBase.isCreateManDirty() && (bl || pSHelpArticleTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpArticleTemplBase.getCreateMan());
        }
        if (pSHelpArticleTemplBase.isDefaultFlagDirty() && (bl || pSHelpArticleTemplBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSHelpArticleTemplBase.getDefaultFlag());
        }
        if (pSHelpArticleTemplBase.isMemoDirty() && (bl || pSHelpArticleTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpArticleTemplBase.getMemo());
        }
        if (pSHelpArticleTemplBase.isPSDevCenterIdDirty() && (bl || pSHelpArticleTemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSHelpArticleTemplBase.getPSDevCenterId());
        }
        if (pSHelpArticleTemplBase.isPSDevCenterNameDirty() && (bl || pSHelpArticleTemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSHelpArticleTemplBase.getPSDevCenterName());
        }
        if (pSHelpArticleTemplBase.isPSHelpArticleTemplIdDirty() && (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETEMPLID, (Object)pSHelpArticleTemplBase.getPSHelpArticleTemplId());
        }
        if (pSHelpArticleTemplBase.isPSHelpArticleTemplNameDirty() && (bl || pSHelpArticleTemplBase.getPSHelpArticleTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETEMPLNAME, (Object)pSHelpArticleTemplBase.getPSHelpArticleTemplName());
        }
        if (pSHelpArticleTemplBase.isPSHelpArticleTypeIdDirty() && (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPEID, (Object)pSHelpArticleTemplBase.getPSHelpArticleTypeId());
        }
        if (pSHelpArticleTemplBase.isPSHelpArticleTypeNameDirty() && (bl || pSHelpArticleTemplBase.getPSHelpArticleTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLETYPENAME, (Object)pSHelpArticleTemplBase.getPSHelpArticleTypeName());
        }
        if (pSHelpArticleTemplBase.isPubModeDirty() && (bl || pSHelpArticleTemplBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSHelpArticleTemplBase.getPubMode());
        }
        if (pSHelpArticleTemplBase.isPubObjDirty() && (bl || pSHelpArticleTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpArticleTemplBase.getPubObj());
        }
        if (pSHelpArticleTemplBase.isTemplCodeDirty() && (bl || pSHelpArticleTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSHelpArticleTemplBase.getTemplCode());
        }
        if (pSHelpArticleTemplBase.isTemplCode2Dirty() && (bl || pSHelpArticleTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSHelpArticleTemplBase.getTemplCode2());
        }
        if (pSHelpArticleTemplBase.isUpdateDateDirty() && (bl || pSHelpArticleTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpArticleTemplBase.getUpdateDate());
        }
        if (pSHelpArticleTemplBase.isUpdateManDirty() && (bl || pSHelpArticleTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpArticleTemplBase.getUpdateMan());
        }
        if (pSHelpArticleTemplBase.isValidFlagDirty() && (bl || pSHelpArticleTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpArticleTemplBase.getValidFlag());
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
        return PSHelpArticleTemplBase.remove(this, n);
    }

    private static boolean remove(PSHelpArticleTemplBase pSHelpArticleTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpArticleTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpArticleTemplBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSHelpArticleTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSHelpArticleTemplBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSHelpArticleTemplBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSHelpArticleTemplBase.resetPSHelpArticleTemplId();
                return true;
            }
            case 7: {
                pSHelpArticleTemplBase.resetPSHelpArticleTemplName();
                return true;
            }
            case 8: {
                pSHelpArticleTemplBase.resetPSHelpArticleTypeId();
                return true;
            }
            case 9: {
                pSHelpArticleTemplBase.resetPSHelpArticleTypeName();
                return true;
            }
            case 10: {
                pSHelpArticleTemplBase.resetPubMode();
                return true;
            }
            case 11: {
                pSHelpArticleTemplBase.resetPubObj();
                return true;
            }
            case 12: {
                pSHelpArticleTemplBase.resetTemplCode();
                return true;
            }
            case 13: {
                pSHelpArticleTemplBase.resetTemplCode2();
                return true;
            }
            case 14: {
                pSHelpArticleTemplBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSHelpArticleTemplBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSHelpArticleTemplBase.resetValidFlag();
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
    public PSHelpArticleType getPSHelpArticleType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleType();
        }
        if (this.getPSHelpArticleTypeId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleTypeLock;
        synchronized (n) {
            if (this.pshelparticletype != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleTypeId(), (Object)this.pshelparticletype.getPSHelpArticleTypeId()) != 0L) {
                this.pshelparticletype = null;
            }
            if (this.pshelparticletype == null) {
                PSHelpArticleType pSHelpArticleType = new PSHelpArticleType();
                pSHelpArticleType.setPSHelpArticleTypeId(this.getPSHelpArticleTypeId());
                PSHelpArticleTypeService pSHelpArticleTypeService = (PSHelpArticleTypeService)ServiceGlobal.getService(PSHelpArticleTypeService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleTypeService.autoGet(pSHelpArticleType);
                this.pshelparticletype = pSHelpArticleType;
            }
            return this.pshelparticletype;
        }
    }

    private PSHelpArticleTemplBase getProxyEntity() {
        return this.proxyPSHelpArticleTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpArticleTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpArticleTemplBase) {
            this.proxyPSHelpArticleTemplBase = (PSHelpArticleTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSHELPARTICLETEMPLID, 6);
        fieldIndexMap.put(FIELD_PSHELPARTICLETEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPEID, 8);
        fieldIndexMap.put(FIELD_PSHELPARTICLETYPENAME, 9);
        fieldIndexMap.put(FIELD_PUBMODE, 10);
        fieldIndexMap.put(FIELD_PUBOBJ, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE, 12);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

