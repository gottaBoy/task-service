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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETemplField;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplFieldService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDETemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDETemplBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_BIZTAG = "BIZTAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDETEMPLID = "PSDCDETEMPLID";
    public static final String FIELD_PSDCDETEMPLNAME = "PSDCDETEMPLNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_BIZTAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDCDETEMPLID = 5;
    private static final int INDEX_PSDCDETEMPLNAME = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_PSDEVSLNID = 9;
    private static final int INDEX_PSDEVSLNNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDETemplBase proxyPSDCDETemplBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean biztagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdetemplidDirtyFlag = false;
    private boolean psdcdetemplnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="biztag")
    private String biztag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcdetemplid")
    private String psdcdetemplid;
    @Column(name="psdcdetemplname")
    private String psdcdetemplname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDCDETemplFieldsLock = new Integer(1);
    private ArrayList<PSDCDETemplField> psdcdetemplfields = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
    }

    public void setBizTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBizTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biztag = string;
        this.biztagDirtyFlag = true;
    }

    public String getBizTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBizTag();
        }
        return this.biztag;
    }

    public boolean isBizTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBizTagDirty();
        }
        return this.biztagDirtyFlag;
    }

    public void resetBizTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBizTag();
            return;
        }
        this.biztagDirtyFlag = false;
        this.biztag = null;
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

    public void setPSDCDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplid = string;
        this.psdcdetemplidDirtyFlag = true;
    }

    public String getPSDCDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplId();
        }
        return this.psdcdetemplid;
    }

    public boolean isPSDCDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplIdDirty();
        }
        return this.psdcdetemplidDirtyFlag;
    }

    public void resetPSDCDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplId();
            return;
        }
        this.psdcdetemplidDirtyFlag = false;
        this.psdcdetemplid = null;
    }

    public void setPSDCDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplname = string;
        this.psdcdetemplnameDirtyFlag = true;
    }

    public String getPSDCDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplName();
        }
        return this.psdcdetemplname;
    }

    public boolean isPSDCDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplNameDirty();
        }
        return this.psdcdetemplnameDirtyFlag;
    }

    public void resetPSDCDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplName();
            return;
        }
        this.psdcdetemplnameDirtyFlag = false;
        this.psdcdetemplname = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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
        PSDCDETemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDETemplBase pSDCDETemplBase) {
        pSDCDETemplBase.resetAllDCFlag();
        pSDCDETemplBase.resetBizTag();
        pSDCDETemplBase.resetCreateDate();
        pSDCDETemplBase.resetCreateMan();
        pSDCDETemplBase.resetMemo();
        pSDCDETemplBase.resetPSDCDETemplId();
        pSDCDETemplBase.resetPSDCDETemplName();
        pSDCDETemplBase.resetPSDevCenterId();
        pSDCDETemplBase.resetPSDevCenterName();
        pSDCDETemplBase.resetPSDevSlnId();
        pSDCDETemplBase.resetPSDevSlnName();
        pSDCDETemplBase.resetUpdateDate();
        pSDCDETemplBase.resetUpdateMan();
        pSDCDETemplBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isBizTagDirty()) {
            hashMap.put(FIELD_BIZTAG, this.getBizTag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCDETemplIdDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLID, this.getPSDCDETemplId());
        }
        if (!bl || this.isPSDCDETemplNameDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLNAME, this.getPSDCDETemplName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
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
        return PSDCDETemplBase.get(this, n);
    }

    private static Object get(PSDCDETemplBase pSDCDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplBase.getAllDCFlag();
            }
            case 1: {
                return pSDCDETemplBase.getBizTag();
            }
            case 2: {
                return pSDCDETemplBase.getCreateDate();
            }
            case 3: {
                return pSDCDETemplBase.getCreateMan();
            }
            case 4: {
                return pSDCDETemplBase.getMemo();
            }
            case 5: {
                return pSDCDETemplBase.getPSDCDETemplId();
            }
            case 6: {
                return pSDCDETemplBase.getPSDCDETemplName();
            }
            case 7: {
                return pSDCDETemplBase.getPSDevCenterId();
            }
            case 8: {
                return pSDCDETemplBase.getPSDevCenterName();
            }
            case 9: {
                return pSDCDETemplBase.getPSDevSlnId();
            }
            case 10: {
                return pSDCDETemplBase.getPSDevSlnName();
            }
            case 11: {
                return pSDCDETemplBase.getUpdateDate();
            }
            case 12: {
                return pSDCDETemplBase.getUpdateMan();
            }
            case 13: {
                return pSDCDETemplBase.getValidFlag();
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
        PSDCDETemplBase.set(this, n, object);
    }

    private static void set(PSDCDETemplBase pSDCDETemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDETemplBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCDETemplBase.setBizTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDETemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCDETemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDETemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDETemplBase.setPSDCDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDETemplBase.setPSDCDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDETemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDETemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDETemplBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDETemplBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDETemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCDETemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCDETemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCDETemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDETemplBase pSDCDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSDCDETemplBase.getBizTag() == null;
            }
            case 2: {
                return pSDCDETemplBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCDETemplBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCDETemplBase.getMemo() == null;
            }
            case 5: {
                return pSDCDETemplBase.getPSDCDETemplId() == null;
            }
            case 6: {
                return pSDCDETemplBase.getPSDCDETemplName() == null;
            }
            case 7: {
                return pSDCDETemplBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDCDETemplBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSDCDETemplBase.getPSDevSlnId() == null;
            }
            case 10: {
                return pSDCDETemplBase.getPSDevSlnName() == null;
            }
            case 11: {
                return pSDCDETemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCDETemplBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDCDETemplBase.getValidFlag() == null;
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
        return PSDCDETemplBase.contains(this, n);
    }

    private static boolean contains(PSDCDETemplBase pSDCDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSDCDETemplBase.isBizTagDirty();
            }
            case 2: {
                return pSDCDETemplBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCDETemplBase.isCreateManDirty();
            }
            case 4: {
                return pSDCDETemplBase.isMemoDirty();
            }
            case 5: {
                return pSDCDETemplBase.isPSDCDETemplIdDirty();
            }
            case 6: {
                return pSDCDETemplBase.isPSDCDETemplNameDirty();
            }
            case 7: {
                return pSDCDETemplBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDCDETemplBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSDCDETemplBase.isPSDevSlnIdDirty();
            }
            case 10: {
                return pSDCDETemplBase.isPSDevSlnNameDirty();
            }
            case 11: {
                return pSDCDETemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCDETemplBase.isUpdateManDirty();
            }
            case 13: {
                return pSDCDETemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDETemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDETemplBase pSDCDETemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDETemplBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getBizTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biztag", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getBizTag()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDCDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplid", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDCDETemplId()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDCDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplname", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDCDETemplName()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCDETemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCDETemplBase.getJSONValue((Object)pSDCDETemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDETemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDETemplBase pSDCDETemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDETemplBase.getAllDCFlag() != null) {
            object = pSDCDETemplBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDETemplBase.getBizTag() != null) {
            object = pSDCDETemplBase.getBizTag();
            xmlNode.setAttribute(FIELD_BIZTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getCreateDate() != null) {
            object = pSDCDETemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDETemplBase.getCreateMan() != null) {
            object = pSDCDETemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getMemo() != null) {
            object = pSDCDETemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDCDETemplId() != null) {
            object = pSDCDETemplBase.getPSDCDETemplId();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDCDETemplName() != null) {
            object = pSDCDETemplBase.getPSDCDETemplName();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDevCenterId() != null) {
            object = pSDCDETemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDevCenterName() != null) {
            object = pSDCDETemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDevSlnId() != null) {
            object = pSDCDETemplBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getPSDevSlnName() != null) {
            object = pSDCDETemplBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getUpdateDate() != null) {
            object = pSDCDETemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDETemplBase.getUpdateMan() != null) {
            object = pSDCDETemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplBase.getValidFlag() != null) {
            object = pSDCDETemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDETemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDETemplBase pSDCDETemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDETemplBase.isAllDCFlagDirty() && (bl || pSDCDETemplBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSDCDETemplBase.getAllDCFlag());
        }
        if (pSDCDETemplBase.isBizTagDirty() && (bl || pSDCDETemplBase.getBizTag() != null)) {
            iDataObject.set(FIELD_BIZTAG, (Object)pSDCDETemplBase.getBizTag());
        }
        if (pSDCDETemplBase.isCreateDateDirty() && (bl || pSDCDETemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDETemplBase.getCreateDate());
        }
        if (pSDCDETemplBase.isCreateManDirty() && (bl || pSDCDETemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDETemplBase.getCreateMan());
        }
        if (pSDCDETemplBase.isMemoDirty() && (bl || pSDCDETemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDETemplBase.getMemo());
        }
        if (pSDCDETemplBase.isPSDCDETemplIdDirty() && (bl || pSDCDETemplBase.getPSDCDETemplId() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLID, (Object)pSDCDETemplBase.getPSDCDETemplId());
        }
        if (pSDCDETemplBase.isPSDCDETemplNameDirty() && (bl || pSDCDETemplBase.getPSDCDETemplName() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLNAME, (Object)pSDCDETemplBase.getPSDCDETemplName());
        }
        if (pSDCDETemplBase.isPSDevCenterIdDirty() && (bl || pSDCDETemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCDETemplBase.getPSDevCenterId());
        }
        if (pSDCDETemplBase.isPSDevCenterNameDirty() && (bl || pSDCDETemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCDETemplBase.getPSDevCenterName());
        }
        if (pSDCDETemplBase.isPSDevSlnIdDirty() && (bl || pSDCDETemplBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCDETemplBase.getPSDevSlnId());
        }
        if (pSDCDETemplBase.isPSDevSlnNameDirty() && (bl || pSDCDETemplBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCDETemplBase.getPSDevSlnName());
        }
        if (pSDCDETemplBase.isUpdateDateDirty() && (bl || pSDCDETemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDETemplBase.getUpdateDate());
        }
        if (pSDCDETemplBase.isUpdateManDirty() && (bl || pSDCDETemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDETemplBase.getUpdateMan());
        }
        if (pSDCDETemplBase.isValidFlagDirty() && (bl || pSDCDETemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCDETemplBase.getValidFlag());
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
        return PSDCDETemplBase.remove(this, n);
    }

    private static boolean remove(PSDCDETemplBase pSDCDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDETemplBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSDCDETemplBase.resetBizTag();
                return true;
            }
            case 2: {
                pSDCDETemplBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCDETemplBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCDETemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCDETemplBase.resetPSDCDETemplId();
                return true;
            }
            case 6: {
                pSDCDETemplBase.resetPSDCDETemplName();
                return true;
            }
            case 7: {
                pSDCDETemplBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDCDETemplBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSDCDETemplBase.resetPSDevSlnId();
                return true;
            }
            case 10: {
                pSDCDETemplBase.resetPSDevSlnName();
                return true;
            }
            case 11: {
                pSDCDETemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCDETemplBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDCDETemplBase.resetValidFlag();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDETemplField> getPSDCDETemplFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplFields();
        }
        if (this.getPSDCDETemplId() == null) {
            return null;
        }
        PSDCDETemplFieldService pSDCDETemplFieldService = (PSDCDETemplFieldService)ServiceGlobal.getService(PSDCDETemplFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDETemplFieldsLock;
        synchronized (n) {
            if (this.psdcdetemplfields == null) {
                this.psdcdetemplfields = pSDCDETemplFieldService.selectByPSDCDETempl(this);
            }
            return this.psdcdetemplfields;
        }
    }

    private PSDCDETemplBase getProxyEntity() {
        return this.proxyPSDCDETemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDETemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDETemplBase) {
            this.proxyPSDCDETemplBase = (PSDCDETemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_BIZTAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDCDETEMPLID, 5);
        fieldIndexMap.put(FIELD_PSDCDETEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

