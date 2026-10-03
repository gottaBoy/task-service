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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpPrjTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpPrjTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSHELPPRJTEMPLID = "PSHELPPRJTEMPLID";
    public static final String FIELD_PSHELPPRJTEMPLNAME = "PSHELPPRJTEMPLNAME";
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
    private static final int INDEX_PSHELPPRJTEMPLID = 6;
    private static final int INDEX_PSHELPPRJTEMPLNAME = 7;
    private static final int INDEX_PUBMODE = 8;
    private static final int INDEX_PUBOBJ = 9;
    private static final int INDEX_TEMPLCODE = 10;
    private static final int INDEX_TEMPLCODE2 = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpPrjTemplBase proxyPSHelpPrjTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pshelpprjtemplidDirtyFlag = false;
    private boolean pshelpprjtemplnameDirtyFlag = false;
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
    @Column(name="pshelpprjtemplid")
    private String pshelpprjtemplid;
    @Column(name="pshelpprjtemplname")
    private String pshelpprjtemplname;
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

    public void setPSHelpPrjTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtemplid = string;
        this.pshelpprjtemplidDirtyFlag = true;
    }

    public String getPSHelpPrjTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTemplId();
        }
        return this.pshelpprjtemplid;
    }

    public boolean isPSHelpPrjTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTemplIdDirty();
        }
        return this.pshelpprjtemplidDirtyFlag;
    }

    public void resetPSHelpPrjTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTemplId();
            return;
        }
        this.pshelpprjtemplidDirtyFlag = false;
        this.pshelpprjtemplid = null;
    }

    public void setPSHelpPrjTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtemplname = string;
        this.pshelpprjtemplnameDirtyFlag = true;
    }

    public String getPSHelpPrjTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTemplName();
        }
        return this.pshelpprjtemplname;
    }

    public boolean isPSHelpPrjTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTemplNameDirty();
        }
        return this.pshelpprjtemplnameDirtyFlag;
    }

    public void resetPSHelpPrjTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTemplName();
            return;
        }
        this.pshelpprjtemplnameDirtyFlag = false;
        this.pshelpprjtemplname = null;
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
        PSHelpPrjTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpPrjTemplBase pSHelpPrjTemplBase) {
        pSHelpPrjTemplBase.resetCreateDate();
        pSHelpPrjTemplBase.resetCreateMan();
        pSHelpPrjTemplBase.resetDefaultFlag();
        pSHelpPrjTemplBase.resetMemo();
        pSHelpPrjTemplBase.resetPSDevCenterId();
        pSHelpPrjTemplBase.resetPSDevCenterName();
        pSHelpPrjTemplBase.resetPSHelpPrjTemplId();
        pSHelpPrjTemplBase.resetPSHelpPrjTemplName();
        pSHelpPrjTemplBase.resetPubMode();
        pSHelpPrjTemplBase.resetPubObj();
        pSHelpPrjTemplBase.resetTemplCode();
        pSHelpPrjTemplBase.resetTemplCode2();
        pSHelpPrjTemplBase.resetUpdateDate();
        pSHelpPrjTemplBase.resetUpdateMan();
        pSHelpPrjTemplBase.resetValidFlag();
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
        if (!bl || this.isPSHelpPrjTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPPRJTEMPLID, this.getPSHelpPrjTemplId());
        }
        if (!bl || this.isPSHelpPrjTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPPRJTEMPLNAME, this.getPSHelpPrjTemplName());
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
        return PSHelpPrjTemplBase.get(this, n);
    }

    private static Object get(PSHelpPrjTemplBase pSHelpPrjTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTemplBase.getCreateDate();
            }
            case 1: {
                return pSHelpPrjTemplBase.getCreateMan();
            }
            case 2: {
                return pSHelpPrjTemplBase.getDefaultFlag();
            }
            case 3: {
                return pSHelpPrjTemplBase.getMemo();
            }
            case 4: {
                return pSHelpPrjTemplBase.getPSDevCenterId();
            }
            case 5: {
                return pSHelpPrjTemplBase.getPSDevCenterName();
            }
            case 6: {
                return pSHelpPrjTemplBase.getPSHelpPrjTemplId();
            }
            case 7: {
                return pSHelpPrjTemplBase.getPSHelpPrjTemplName();
            }
            case 8: {
                return pSHelpPrjTemplBase.getPubMode();
            }
            case 9: {
                return pSHelpPrjTemplBase.getPubObj();
            }
            case 10: {
                return pSHelpPrjTemplBase.getTemplCode();
            }
            case 11: {
                return pSHelpPrjTemplBase.getTemplCode2();
            }
            case 12: {
                return pSHelpPrjTemplBase.getUpdateDate();
            }
            case 13: {
                return pSHelpPrjTemplBase.getUpdateMan();
            }
            case 14: {
                return pSHelpPrjTemplBase.getValidFlag();
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
        PSHelpPrjTemplBase.set(this, n, object);
    }

    private static void set(PSHelpPrjTemplBase pSHelpPrjTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpPrjTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpPrjTemplBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSHelpPrjTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpPrjTemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpPrjTemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpPrjTemplBase.setPSHelpPrjTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpPrjTemplBase.setPSHelpPrjTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpPrjTemplBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSHelpPrjTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpPrjTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpPrjTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpPrjTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSHelpPrjTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpPrjTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpPrjTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpPrjTemplBase pSHelpPrjTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpPrjTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpPrjTemplBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSHelpPrjTemplBase.getMemo() == null;
            }
            case 4: {
                return pSHelpPrjTemplBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSHelpPrjTemplBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSHelpPrjTemplBase.getPSHelpPrjTemplId() == null;
            }
            case 7: {
                return pSHelpPrjTemplBase.getPSHelpPrjTemplName() == null;
            }
            case 8: {
                return pSHelpPrjTemplBase.getPubMode() == null;
            }
            case 9: {
                return pSHelpPrjTemplBase.getPubObj() == null;
            }
            case 10: {
                return pSHelpPrjTemplBase.getTemplCode() == null;
            }
            case 11: {
                return pSHelpPrjTemplBase.getTemplCode2() == null;
            }
            case 12: {
                return pSHelpPrjTemplBase.getUpdateDate() == null;
            }
            case 13: {
                return pSHelpPrjTemplBase.getUpdateMan() == null;
            }
            case 14: {
                return pSHelpPrjTemplBase.getValidFlag() == null;
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
        return PSHelpPrjTemplBase.contains(this, n);
    }

    private static boolean contains(PSHelpPrjTemplBase pSHelpPrjTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpPrjTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpPrjTemplBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSHelpPrjTemplBase.isMemoDirty();
            }
            case 4: {
                return pSHelpPrjTemplBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSHelpPrjTemplBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSHelpPrjTemplBase.isPSHelpPrjTemplIdDirty();
            }
            case 7: {
                return pSHelpPrjTemplBase.isPSHelpPrjTemplNameDirty();
            }
            case 8: {
                return pSHelpPrjTemplBase.isPubModeDirty();
            }
            case 9: {
                return pSHelpPrjTemplBase.isPubObjDirty();
            }
            case 10: {
                return pSHelpPrjTemplBase.isTemplCodeDirty();
            }
            case 11: {
                return pSHelpPrjTemplBase.isTemplCode2Dirty();
            }
            case 12: {
                return pSHelpPrjTemplBase.isUpdateDateDirty();
            }
            case 13: {
                return pSHelpPrjTemplBase.isUpdateManDirty();
            }
            case 14: {
                return pSHelpPrjTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpPrjTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpPrjTemplBase pSHelpPrjTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpPrjTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtemplid", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPSHelpPrjTemplId()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtemplname", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPSHelpPrjTemplName()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPubMode()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpPrjTemplBase.getJSONValue((Object)pSHelpPrjTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpPrjTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpPrjTemplBase pSHelpPrjTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpPrjTemplBase.getCreateDate() != null) {
            object = pSHelpPrjTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjTemplBase.getCreateMan() != null) {
            object = pSHelpPrjTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getDefaultFlag() != null) {
            object = pSHelpPrjTemplBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpPrjTemplBase.getMemo() != null) {
            object = pSHelpPrjTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getPSDevCenterId() != null) {
            object = pSHelpPrjTemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getPSDevCenterName() != null) {
            object = pSHelpPrjTemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplId() != null) {
            object = pSHelpPrjTemplBase.getPSHelpPrjTemplId();
            xmlNode.setAttribute(FIELD_PSHELPPRJTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplName() != null) {
            object = pSHelpPrjTemplBase.getPSHelpPrjTemplName();
            xmlNode.setAttribute(FIELD_PSHELPPRJTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getPubMode() != null) {
            object = pSHelpPrjTemplBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpPrjTemplBase.getPubObj() != null) {
            object = pSHelpPrjTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getTemplCode() != null) {
            object = pSHelpPrjTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getTemplCode2() != null) {
            object = pSHelpPrjTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getUpdateDate() != null) {
            object = pSHelpPrjTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjTemplBase.getUpdateMan() != null) {
            object = pSHelpPrjTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTemplBase.getValidFlag() != null) {
            object = pSHelpPrjTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpPrjTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpPrjTemplBase pSHelpPrjTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpPrjTemplBase.isCreateDateDirty() && (bl || pSHelpPrjTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpPrjTemplBase.getCreateDate());
        }
        if (pSHelpPrjTemplBase.isCreateManDirty() && (bl || pSHelpPrjTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpPrjTemplBase.getCreateMan());
        }
        if (pSHelpPrjTemplBase.isDefaultFlagDirty() && (bl || pSHelpPrjTemplBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSHelpPrjTemplBase.getDefaultFlag());
        }
        if (pSHelpPrjTemplBase.isMemoDirty() && (bl || pSHelpPrjTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpPrjTemplBase.getMemo());
        }
        if (pSHelpPrjTemplBase.isPSDevCenterIdDirty() && (bl || pSHelpPrjTemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSHelpPrjTemplBase.getPSDevCenterId());
        }
        if (pSHelpPrjTemplBase.isPSDevCenterNameDirty() && (bl || pSHelpPrjTemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSHelpPrjTemplBase.getPSDevCenterName());
        }
        if (pSHelpPrjTemplBase.isPSHelpPrjTemplIdDirty() && (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTEMPLID, (Object)pSHelpPrjTemplBase.getPSHelpPrjTemplId());
        }
        if (pSHelpPrjTemplBase.isPSHelpPrjTemplNameDirty() && (bl || pSHelpPrjTemplBase.getPSHelpPrjTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTEMPLNAME, (Object)pSHelpPrjTemplBase.getPSHelpPrjTemplName());
        }
        if (pSHelpPrjTemplBase.isPubModeDirty() && (bl || pSHelpPrjTemplBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSHelpPrjTemplBase.getPubMode());
        }
        if (pSHelpPrjTemplBase.isPubObjDirty() && (bl || pSHelpPrjTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpPrjTemplBase.getPubObj());
        }
        if (pSHelpPrjTemplBase.isTemplCodeDirty() && (bl || pSHelpPrjTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSHelpPrjTemplBase.getTemplCode());
        }
        if (pSHelpPrjTemplBase.isTemplCode2Dirty() && (bl || pSHelpPrjTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSHelpPrjTemplBase.getTemplCode2());
        }
        if (pSHelpPrjTemplBase.isUpdateDateDirty() && (bl || pSHelpPrjTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpPrjTemplBase.getUpdateDate());
        }
        if (pSHelpPrjTemplBase.isUpdateManDirty() && (bl || pSHelpPrjTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpPrjTemplBase.getUpdateMan());
        }
        if (pSHelpPrjTemplBase.isValidFlagDirty() && (bl || pSHelpPrjTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpPrjTemplBase.getValidFlag());
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
        return PSHelpPrjTemplBase.remove(this, n);
    }

    private static boolean remove(PSHelpPrjTemplBase pSHelpPrjTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpPrjTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpPrjTemplBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSHelpPrjTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSHelpPrjTemplBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSHelpPrjTemplBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSHelpPrjTemplBase.resetPSHelpPrjTemplId();
                return true;
            }
            case 7: {
                pSHelpPrjTemplBase.resetPSHelpPrjTemplName();
                return true;
            }
            case 8: {
                pSHelpPrjTemplBase.resetPubMode();
                return true;
            }
            case 9: {
                pSHelpPrjTemplBase.resetPubObj();
                return true;
            }
            case 10: {
                pSHelpPrjTemplBase.resetTemplCode();
                return true;
            }
            case 11: {
                pSHelpPrjTemplBase.resetTemplCode2();
                return true;
            }
            case 12: {
                pSHelpPrjTemplBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSHelpPrjTemplBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSHelpPrjTemplBase.resetValidFlag();
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

    private PSHelpPrjTemplBase getProxyEntity() {
        return this.proxyPSHelpPrjTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpPrjTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpPrjTemplBase) {
            this.proxyPSHelpPrjTemplBase = (PSHelpPrjTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSHELPPRJTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSHELPPRJTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PUBMODE, 8);
        fieldIndexMap.put(FIELD_PUBOBJ, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE, 10);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

