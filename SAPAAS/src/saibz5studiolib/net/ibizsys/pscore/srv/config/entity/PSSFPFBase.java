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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPFID = "PSSFPFID";
    public static final String FIELD_PSSFPFNAME = "PSSFPFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPFID = 3;
    private static final int INDEX_PSPFNAME = 4;
    private static final int INDEX_PSSFID = 5;
    private static final int INDEX_PSSFNAME = 6;
    private static final int INDEX_PSSFPFID = 7;
    private static final int INDEX_PSSFPFNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPFBase proxyPSSFPFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpfidDirtyFlag = false;
    private boolean pssfpfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpfid")
    private String pssfpfid;
    @Column(name="pssfpfname")
    private String pssfpfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpfid = string;
        this.pssfpfidDirtyFlag = true;
    }

    public String getPSSFPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPFId();
        }
        return this.pssfpfid;
    }

    public boolean isPSSFPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPFIdDirty();
        }
        return this.pssfpfidDirtyFlag;
    }

    public void resetPSSFPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPFId();
            return;
        }
        this.pssfpfidDirtyFlag = false;
        this.pssfpfid = null;
    }

    public void setPSSFPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpfname = string;
        this.pssfpfnameDirtyFlag = true;
    }

    public String getPSSFPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPFName();
        }
        return this.pssfpfname;
    }

    public boolean isPSSFPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPFNameDirty();
        }
        return this.pssfpfnameDirtyFlag;
    }

    public void resetPSSFPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPFName();
            return;
        }
        this.pssfpfnameDirtyFlag = false;
        this.pssfpfname = null;
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
        PSSFPFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPFBase pSSFPFBase) {
        pSSFPFBase.resetCreateDate();
        pSSFPFBase.resetCreateMan();
        pSSFPFBase.resetMemo();
        pSSFPFBase.resetPSPFId();
        pSSFPFBase.resetPSPFName();
        pSSFPFBase.resetPSSFId();
        pSSFPFBase.resetPSSFName();
        pSSFPFBase.resetPSSFPFId();
        pSSFPFBase.resetPSSFPFName();
        pSSFPFBase.resetUpdateDate();
        pSSFPFBase.resetUpdateMan();
        pSSFPFBase.resetValidFlag();
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
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPFIdDirty()) {
            hashMap.put(FIELD_PSSFPFID, this.getPSSFPFId());
        }
        if (!bl || this.isPSSFPFNameDirty()) {
            hashMap.put(FIELD_PSSFPFNAME, this.getPSSFPFName());
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
        return PSSFPFBase.get(this, n);
    }

    private static Object get(PSSFPFBase pSSFPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPFBase.getCreateDate();
            }
            case 1: {
                return pSSFPFBase.getCreateMan();
            }
            case 2: {
                return pSSFPFBase.getMemo();
            }
            case 3: {
                return pSSFPFBase.getPSPFId();
            }
            case 4: {
                return pSSFPFBase.getPSPFName();
            }
            case 5: {
                return pSSFPFBase.getPSSFId();
            }
            case 6: {
                return pSSFPFBase.getPSSFName();
            }
            case 7: {
                return pSSFPFBase.getPSSFPFId();
            }
            case 8: {
                return pSSFPFBase.getPSSFPFName();
            }
            case 9: {
                return pSSFPFBase.getUpdateDate();
            }
            case 10: {
                return pSSFPFBase.getUpdateMan();
            }
            case 11: {
                return pSSFPFBase.getValidFlag();
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
        PSSFPFBase.set(this, n, object);
    }

    private static void set(PSSFPFBase pSSFPFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPFBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPFBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPFBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPFBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPFBase.setPSSFPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPFBase.setPSSFPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSFPFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFPFBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFPFBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPFBase pSSFPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPFBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPFBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPFBase.getMemo() == null;
            }
            case 3: {
                return pSSFPFBase.getPSPFId() == null;
            }
            case 4: {
                return pSSFPFBase.getPSPFName() == null;
            }
            case 5: {
                return pSSFPFBase.getPSSFId() == null;
            }
            case 6: {
                return pSSFPFBase.getPSSFName() == null;
            }
            case 7: {
                return pSSFPFBase.getPSSFPFId() == null;
            }
            case 8: {
                return pSSFPFBase.getPSSFPFName() == null;
            }
            case 9: {
                return pSSFPFBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSFPFBase.getUpdateMan() == null;
            }
            case 11: {
                return pSSFPFBase.getValidFlag() == null;
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
        return PSSFPFBase.contains(this, n);
    }

    private static boolean contains(PSSFPFBase pSSFPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPFBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPFBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPFBase.isMemoDirty();
            }
            case 3: {
                return pSSFPFBase.isPSPFIdDirty();
            }
            case 4: {
                return pSSFPFBase.isPSPFNameDirty();
            }
            case 5: {
                return pSSFPFBase.isPSSFIdDirty();
            }
            case 6: {
                return pSSFPFBase.isPSSFNameDirty();
            }
            case 7: {
                return pSSFPFBase.isPSSFPFIdDirty();
            }
            case 8: {
                return pSSFPFBase.isPSSFPFNameDirty();
            }
            case 9: {
                return pSSFPFBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSFPFBase.isUpdateManDirty();
            }
            case 11: {
                return pSSFPFBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPFBase pSSFPFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSSFPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpfid", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSSFPFId()), (boolean)false);
        }
        if (bl || pSSFPFBase.getPSSFPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpfname", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getPSSFPFName()), (boolean)false);
        }
        if (bl || pSSFPFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFPFBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFPFBase.getJSONValue((Object)pSSFPFBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPFBase pSSFPFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPFBase.getCreateDate() != null) {
            object = pSSFPFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPFBase.getCreateMan() != null) {
            object = pSSFPFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getMemo() != null) {
            object = pSSFPFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSPFId() != null) {
            object = pSSFPFBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSPFName() != null) {
            object = pSSFPFBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSSFId() != null) {
            object = pSSFPFBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSSFName() != null) {
            object = pSSFPFBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSSFPFId() != null) {
            object = pSSFPFBase.getPSSFPFId();
            xmlNode.setAttribute(FIELD_PSSFPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getPSSFPFName() != null) {
            object = pSSFPFBase.getPSSFPFName();
            xmlNode.setAttribute(FIELD_PSSFPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getUpdateDate() != null) {
            object = pSSFPFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPFBase.getUpdateMan() != null) {
            object = pSSFPFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPFBase.getValidFlag() != null) {
            object = pSSFPFBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPFBase pSSFPFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPFBase.isCreateDateDirty() && (bl || pSSFPFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPFBase.getCreateDate());
        }
        if (pSSFPFBase.isCreateManDirty() && (bl || pSSFPFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPFBase.getCreateMan());
        }
        if (pSSFPFBase.isMemoDirty() && (bl || pSSFPFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPFBase.getMemo());
        }
        if (pSSFPFBase.isPSPFIdDirty() && (bl || pSSFPFBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSSFPFBase.getPSPFId());
        }
        if (pSSFPFBase.isPSPFNameDirty() && (bl || pSSFPFBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSSFPFBase.getPSPFName());
        }
        if (pSSFPFBase.isPSSFIdDirty() && (bl || pSSFPFBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPFBase.getPSSFId());
        }
        if (pSSFPFBase.isPSSFNameDirty() && (bl || pSSFPFBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFPFBase.getPSSFName());
        }
        if (pSSFPFBase.isPSSFPFIdDirty() && (bl || pSSFPFBase.getPSSFPFId() != null)) {
            iDataObject.set(FIELD_PSSFPFID, (Object)pSSFPFBase.getPSSFPFId());
        }
        if (pSSFPFBase.isPSSFPFNameDirty() && (bl || pSSFPFBase.getPSSFPFName() != null)) {
            iDataObject.set(FIELD_PSSFPFNAME, (Object)pSSFPFBase.getPSSFPFName());
        }
        if (pSSFPFBase.isUpdateDateDirty() && (bl || pSSFPFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPFBase.getUpdateDate());
        }
        if (pSSFPFBase.isUpdateManDirty() && (bl || pSSFPFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPFBase.getUpdateMan());
        }
        if (pSSFPFBase.isValidFlagDirty() && (bl || pSSFPFBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFPFBase.getValidFlag());
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
        return PSSFPFBase.remove(this, n);
    }

    private static boolean remove(PSSFPFBase pSSFPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPFBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFPFBase.resetPSPFId();
                return true;
            }
            case 4: {
                pSSFPFBase.resetPSPFName();
                return true;
            }
            case 5: {
                pSSFPFBase.resetPSSFId();
                return true;
            }
            case 6: {
                pSSFPFBase.resetPSSFName();
                return true;
            }
            case 7: {
                pSSFPFBase.resetPSSFPFId();
                return true;
            }
            case 8: {
                pSSFPFBase.resetPSSFPFName();
                return true;
            }
            case 9: {
                pSSFPFBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSFPFBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSSFPFBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFPFBase getProxyEntity() {
        return this.proxyPSSFPFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPFBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPFBase) {
            this.proxyPSSFPFBase = (PSSFPFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPFID, 3);
        fieldIndexMap.put(FIELD_PSPFNAME, 4);
        fieldIndexMap.put(FIELD_PSSFID, 5);
        fieldIndexMap.put(FIELD_PSSFNAME, 6);
        fieldIndexMap.put(FIELD_PSSFPFID, 7);
        fieldIndexMap.put(FIELD_PSSFPFNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

