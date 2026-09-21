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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelRSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORPSMODELID = "MAJORPSMODELID";
    public static final String FIELD_MAJORPSMODELNAME = "MAJORPSMODELNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSMODELID = "MINORPSMODELID";
    public static final String FIELD_MINORPSMODELNAME = "MINORPSMODELNAME";
    public static final String FIELD_PSMODELRSID = "PSMODELRSID";
    public static final String FIELD_PSMODELRSNAME = "PSMODELRSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAJORPSMODELID = 2;
    private static final int INDEX_MAJORPSMODELNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MINORPSMODELID = 5;
    private static final int INDEX_MINORPSMODELNAME = 6;
    private static final int INDEX_PSMODELRSID = 7;
    private static final int INDEX_PSMODELRSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelRSBase proxyPSModelRSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majorpsmodelidDirtyFlag = false;
    private boolean majorpsmodelnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsmodelidDirtyFlag = false;
    private boolean minorpsmodelnameDirtyFlag = false;
    private boolean psmodelrsidDirtyFlag = false;
    private boolean psmodelrsnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majorpsmodelid")
    private String majorpsmodelid;
    @Column(name="majorpsmodelname")
    private String majorpsmodelname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsmodelid")
    private String minorpsmodelid;
    @Column(name="minorpsmodelname")
    private String minorpsmodelname;
    @Column(name="psmodelrsid")
    private String psmodelrsid;
    @Column(name="psmodelrsname")
    private String psmodelrsname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objMajorPSModelLock = new Integer(1);
    private PSModel majorpsmodel = null;
    private Integer objMinorPSModelLock = new Integer(1);
    private PSModel minorpsmodel = null;

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

    public void setMajorPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsmodelid = string;
        this.majorpsmodelidDirtyFlag = true;
    }

    public String getMajorPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSModelId();
        }
        return this.majorpsmodelid;
    }

    public boolean isMajorPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSModelIdDirty();
        }
        return this.majorpsmodelidDirtyFlag;
    }

    public void resetMajorPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSModelId();
            return;
        }
        this.majorpsmodelidDirtyFlag = false;
        this.majorpsmodelid = null;
    }

    public void setMajorPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsmodelname = string;
        this.majorpsmodelnameDirtyFlag = true;
    }

    public String getMajorPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSModelName();
        }
        return this.majorpsmodelname;
    }

    public boolean isMajorPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSModelNameDirty();
        }
        return this.majorpsmodelnameDirtyFlag;
    }

    public void resetMajorPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSModelName();
            return;
        }
        this.majorpsmodelnameDirtyFlag = false;
        this.majorpsmodelname = null;
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

    public void setMinorPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsmodelid = string;
        this.minorpsmodelidDirtyFlag = true;
    }

    public String getMinorPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSModelId();
        }
        return this.minorpsmodelid;
    }

    public boolean isMinorPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSModelIdDirty();
        }
        return this.minorpsmodelidDirtyFlag;
    }

    public void resetMinorPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSModelId();
            return;
        }
        this.minorpsmodelidDirtyFlag = false;
        this.minorpsmodelid = null;
    }

    public void setMinorPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsmodelname = string;
        this.minorpsmodelnameDirtyFlag = true;
    }

    public String getMinorPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSModelName();
        }
        return this.minorpsmodelname;
    }

    public boolean isMinorPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSModelNameDirty();
        }
        return this.minorpsmodelnameDirtyFlag;
    }

    public void resetMinorPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSModelName();
            return;
        }
        this.minorpsmodelnameDirtyFlag = false;
        this.minorpsmodelname = null;
    }

    public void setPSModelRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrsid = string;
        this.psmodelrsidDirtyFlag = true;
    }

    public String getPSModelRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRSId();
        }
        return this.psmodelrsid;
    }

    public boolean isPSModelRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRSIdDirty();
        }
        return this.psmodelrsidDirtyFlag;
    }

    public void resetPSModelRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRSId();
            return;
        }
        this.psmodelrsidDirtyFlag = false;
        this.psmodelrsid = null;
    }

    public void setPSModelRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrsname = string;
        this.psmodelrsnameDirtyFlag = true;
    }

    public String getPSModelRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRSName();
        }
        return this.psmodelrsname;
    }

    public boolean isPSModelRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRSNameDirty();
        }
        return this.psmodelrsnameDirtyFlag;
    }

    public void resetPSModelRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRSName();
            return;
        }
        this.psmodelrsnameDirtyFlag = false;
        this.psmodelrsname = null;
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
        PSModelRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelRSBase pSModelRSBase) {
        pSModelRSBase.resetCreateDate();
        pSModelRSBase.resetCreateMan();
        pSModelRSBase.resetMajorPSModelId();
        pSModelRSBase.resetMajorPSModelName();
        pSModelRSBase.resetMemo();
        pSModelRSBase.resetMinorPSModelId();
        pSModelRSBase.resetMinorPSModelName();
        pSModelRSBase.resetPSModelRSId();
        pSModelRSBase.resetPSModelRSName();
        pSModelRSBase.resetUpdateDate();
        pSModelRSBase.resetUpdateMan();
        pSModelRSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMajorPSModelIdDirty()) {
            hashMap.put(FIELD_MAJORPSMODELID, this.getMajorPSModelId());
        }
        if (!bl || this.isMajorPSModelNameDirty()) {
            hashMap.put(FIELD_MAJORPSMODELNAME, this.getMajorPSModelName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSModelIdDirty()) {
            hashMap.put(FIELD_MINORPSMODELID, this.getMinorPSModelId());
        }
        if (!bl || this.isMinorPSModelNameDirty()) {
            hashMap.put(FIELD_MINORPSMODELNAME, this.getMinorPSModelName());
        }
        if (!bl || this.isPSModelRSIdDirty()) {
            hashMap.put(FIELD_PSMODELRSID, this.getPSModelRSId());
        }
        if (!bl || this.isPSModelRSNameDirty()) {
            hashMap.put(FIELD_PSMODELRSNAME, this.getPSModelRSName());
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
        return PSModelRSBase.get(this, n);
    }

    private static Object get(PSModelRSBase pSModelRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRSBase.getCreateDate();
            }
            case 1: {
                return pSModelRSBase.getCreateMan();
            }
            case 2: {
                return pSModelRSBase.getMajorPSModelId();
            }
            case 3: {
                return pSModelRSBase.getMajorPSModelName();
            }
            case 4: {
                return pSModelRSBase.getMemo();
            }
            case 5: {
                return pSModelRSBase.getMinorPSModelId();
            }
            case 6: {
                return pSModelRSBase.getMinorPSModelName();
            }
            case 7: {
                return pSModelRSBase.getPSModelRSId();
            }
            case 8: {
                return pSModelRSBase.getPSModelRSName();
            }
            case 9: {
                return pSModelRSBase.getUpdateDate();
            }
            case 10: {
                return pSModelRSBase.getUpdateMan();
            }
            case 11: {
                return pSModelRSBase.getValidFlag();
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
        PSModelRSBase.set(this, n, object);
    }

    private static void set(PSModelRSBase pSModelRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelRSBase.setMajorPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelRSBase.setMajorPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelRSBase.setMinorPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelRSBase.setMinorPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelRSBase.setPSModelRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelRSBase.setPSModelRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSModelRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelRSBase.isNull(this, n);
    }

    private static boolean isNull(PSModelRSBase pSModelRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRSBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelRSBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelRSBase.getMajorPSModelId() == null;
            }
            case 3: {
                return pSModelRSBase.getMajorPSModelName() == null;
            }
            case 4: {
                return pSModelRSBase.getMemo() == null;
            }
            case 5: {
                return pSModelRSBase.getMinorPSModelId() == null;
            }
            case 6: {
                return pSModelRSBase.getMinorPSModelName() == null;
            }
            case 7: {
                return pSModelRSBase.getPSModelRSId() == null;
            }
            case 8: {
                return pSModelRSBase.getPSModelRSName() == null;
            }
            case 9: {
                return pSModelRSBase.getUpdateDate() == null;
            }
            case 10: {
                return pSModelRSBase.getUpdateMan() == null;
            }
            case 11: {
                return pSModelRSBase.getValidFlag() == null;
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
        return PSModelRSBase.contains(this, n);
    }

    private static boolean contains(PSModelRSBase pSModelRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRSBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelRSBase.isCreateManDirty();
            }
            case 2: {
                return pSModelRSBase.isMajorPSModelIdDirty();
            }
            case 3: {
                return pSModelRSBase.isMajorPSModelNameDirty();
            }
            case 4: {
                return pSModelRSBase.isMemoDirty();
            }
            case 5: {
                return pSModelRSBase.isMinorPSModelIdDirty();
            }
            case 6: {
                return pSModelRSBase.isMinorPSModelNameDirty();
            }
            case 7: {
                return pSModelRSBase.isPSModelRSIdDirty();
            }
            case 8: {
                return pSModelRSBase.isPSModelRSNameDirty();
            }
            case 9: {
                return pSModelRSBase.isUpdateDateDirty();
            }
            case 10: {
                return pSModelRSBase.isUpdateManDirty();
            }
            case 11: {
                return pSModelRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelRSBase pSModelRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelRSBase.getMajorPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsmodelid", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getMajorPSModelId()), (boolean)false);
        }
        if (bl || pSModelRSBase.getMajorPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsmodelname", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getMajorPSModelName()), (boolean)false);
        }
        if (bl || pSModelRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelRSBase.getMinorPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsmodelid", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getMinorPSModelId()), (boolean)false);
        }
        if (bl || pSModelRSBase.getMinorPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsmodelname", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getMinorPSModelName()), (boolean)false);
        }
        if (bl || pSModelRSBase.getPSModelRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrsid", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getPSModelRSId()), (boolean)false);
        }
        if (bl || pSModelRSBase.getPSModelRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrsname", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getPSModelRSName()), (boolean)false);
        }
        if (bl || pSModelRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelRSBase.getJSONValue((Object)pSModelRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelRSBase pSModelRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelRSBase.getCreateDate() != null) {
            object = pSModelRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRSBase.getCreateMan() != null) {
            object = pSModelRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getMajorPSModelId() != null) {
            object = pSModelRSBase.getMajorPSModelId();
            xmlNode.setAttribute(FIELD_MAJORPSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getMajorPSModelName() != null) {
            object = pSModelRSBase.getMajorPSModelName();
            xmlNode.setAttribute(FIELD_MAJORPSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getMemo() != null) {
            object = pSModelRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getMinorPSModelId() != null) {
            object = pSModelRSBase.getMinorPSModelId();
            xmlNode.setAttribute(FIELD_MINORPSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getMinorPSModelName() != null) {
            object = pSModelRSBase.getMinorPSModelName();
            xmlNode.setAttribute(FIELD_MINORPSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getPSModelRSId() != null) {
            object = pSModelRSBase.getPSModelRSId();
            xmlNode.setAttribute(FIELD_PSMODELRSID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getPSModelRSName() != null) {
            object = pSModelRSBase.getPSModelRSName();
            xmlNode.setAttribute(FIELD_PSMODELRSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getUpdateDate() != null) {
            object = pSModelRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRSBase.getUpdateMan() != null) {
            object = pSModelRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRSBase.getValidFlag() != null) {
            object = pSModelRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelRSBase pSModelRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelRSBase.isCreateDateDirty() && (bl || pSModelRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelRSBase.getCreateDate());
        }
        if (pSModelRSBase.isCreateManDirty() && (bl || pSModelRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelRSBase.getCreateMan());
        }
        if (pSModelRSBase.isMajorPSModelIdDirty() && (bl || pSModelRSBase.getMajorPSModelId() != null)) {
            iDataObject.set(FIELD_MAJORPSMODELID, (Object)pSModelRSBase.getMajorPSModelId());
        }
        if (pSModelRSBase.isMajorPSModelNameDirty() && (bl || pSModelRSBase.getMajorPSModelName() != null)) {
            iDataObject.set(FIELD_MAJORPSMODELNAME, (Object)pSModelRSBase.getMajorPSModelName());
        }
        if (pSModelRSBase.isMemoDirty() && (bl || pSModelRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelRSBase.getMemo());
        }
        if (pSModelRSBase.isMinorPSModelIdDirty() && (bl || pSModelRSBase.getMinorPSModelId() != null)) {
            iDataObject.set(FIELD_MINORPSMODELID, (Object)pSModelRSBase.getMinorPSModelId());
        }
        if (pSModelRSBase.isMinorPSModelNameDirty() && (bl || pSModelRSBase.getMinorPSModelName() != null)) {
            iDataObject.set(FIELD_MINORPSMODELNAME, (Object)pSModelRSBase.getMinorPSModelName());
        }
        if (pSModelRSBase.isPSModelRSIdDirty() && (bl || pSModelRSBase.getPSModelRSId() != null)) {
            iDataObject.set(FIELD_PSMODELRSID, (Object)pSModelRSBase.getPSModelRSId());
        }
        if (pSModelRSBase.isPSModelRSNameDirty() && (bl || pSModelRSBase.getPSModelRSName() != null)) {
            iDataObject.set(FIELD_PSMODELRSNAME, (Object)pSModelRSBase.getPSModelRSName());
        }
        if (pSModelRSBase.isUpdateDateDirty() && (bl || pSModelRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelRSBase.getUpdateDate());
        }
        if (pSModelRSBase.isUpdateManDirty() && (bl || pSModelRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelRSBase.getUpdateMan());
        }
        if (pSModelRSBase.isValidFlagDirty() && (bl || pSModelRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelRSBase.getValidFlag());
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
        return PSModelRSBase.remove(this, n);
    }

    private static boolean remove(PSModelRSBase pSModelRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelRSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelRSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelRSBase.resetMajorPSModelId();
                return true;
            }
            case 3: {
                pSModelRSBase.resetMajorPSModelName();
                return true;
            }
            case 4: {
                pSModelRSBase.resetMemo();
                return true;
            }
            case 5: {
                pSModelRSBase.resetMinorPSModelId();
                return true;
            }
            case 6: {
                pSModelRSBase.resetMinorPSModelName();
                return true;
            }
            case 7: {
                pSModelRSBase.resetPSModelRSId();
                return true;
            }
            case 8: {
                pSModelRSBase.resetPSModelRSName();
                return true;
            }
            case 9: {
                pSModelRSBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSModelRSBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSModelRSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getMajorPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSModel();
        }
        if (this.getMajorPSModelId() == null) {
            return null;
        }
        Integer n = this.objMajorPSModelLock;
        synchronized (n) {
            if (this.majorpsmodel != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSModelId(), (Object)this.majorpsmodel.getPSModelId()) != 0L) {
                this.majorpsmodel = null;
            }
            if (this.majorpsmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getMajorPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.majorpsmodel = pSModel;
            }
            return this.majorpsmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getMinorPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSModel();
        }
        if (this.getMinorPSModelId() == null) {
            return null;
        }
        Integer n = this.objMinorPSModelLock;
        synchronized (n) {
            if (this.minorpsmodel != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSModelId(), (Object)this.minorpsmodel.getPSModelId()) != 0L) {
                this.minorpsmodel = null;
            }
            if (this.minorpsmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getMinorPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.minorpsmodel = pSModel;
            }
            return this.minorpsmodel;
        }
    }

    private PSModelRSBase getProxyEntity() {
        return this.proxyPSModelRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelRSBase) {
            this.proxyPSModelRSBase = (PSModelRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAJORPSMODELID, 2);
        fieldIndexMap.put(FIELD_MAJORPSMODELNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MINORPSMODELID, 5);
        fieldIndexMap.put(FIELD_MINORPSMODELNAME, 6);
        fieldIndexMap.put(FIELD_PSMODELRSID, 7);
        fieldIndexMap.put(FIELD_PSMODELRSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

