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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormRFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFormRFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORPSDEFORMID = "MAJORPSDEFORMID";
    public static final String FIELD_MAJORPSDEFORMNAME = "MAJORPSDEFORMNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEFORMID = "MINORPSDEFORMID";
    public static final String FIELD_MINORPSDEFORMNAME = "MINORPSDEFORMNAME";
    public static final String FIELD_PSDEFORMRFID = "PSDEFORMRFID";
    public static final String FIELD_PSDEFORMRFNAME = "PSDEFORMRFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAJORPSDEFORMID = 2;
    private static final int INDEX_MAJORPSDEFORMNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MINORPSDEFORMID = 5;
    private static final int INDEX_MINORPSDEFORMNAME = 6;
    private static final int INDEX_PSDEFORMRFID = 7;
    private static final int INDEX_PSDEFORMRFNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFormRFBase proxyPSDEFormRFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majorpsdeformidDirtyFlag = false;
    private boolean majorpsdeformnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdeformidDirtyFlag = false;
    private boolean minorpsdeformnameDirtyFlag = false;
    private boolean psdeformrfidDirtyFlag = false;
    private boolean psdeformrfnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majorpsdeformid")
    private String majorpsdeformid;
    @Column(name="majorpsdeformname")
    private String majorpsdeformname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdeformid")
    private String minorpsdeformid;
    @Column(name="minorpsdeformname")
    private String minorpsdeformname;
    @Column(name="psdeformrfid")
    private String psdeformrfid;
    @Column(name="psdeformrfname")
    private String psdeformrfname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objMajorPSDEFormLock = new Integer(1);
    private PSDEForm majorpsdeform = null;
    private Integer objMinorPSDEFormLock = new Integer(1);
    private PSDEForm minorpsdeform = null;

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

    public void setMajorPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeformid = string;
        this.majorpsdeformidDirtyFlag = true;
    }

    public String getMajorPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFormId();
        }
        return this.majorpsdeformid;
    }

    public boolean isMajorPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFormIdDirty();
        }
        return this.majorpsdeformidDirtyFlag;
    }

    public void resetMajorPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFormId();
            return;
        }
        this.majorpsdeformidDirtyFlag = false;
        this.majorpsdeformid = null;
    }

    public void setMajorPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeformname = string;
        this.majorpsdeformnameDirtyFlag = true;
    }

    public String getMajorPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEFormName();
        }
        return this.majorpsdeformname;
    }

    public boolean isMajorPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEFormNameDirty();
        }
        return this.majorpsdeformnameDirtyFlag;
    }

    public void resetMajorPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEFormName();
            return;
        }
        this.majorpsdeformnameDirtyFlag = false;
        this.majorpsdeformname = null;
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

    public void setMinorPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeformid = string;
        this.minorpsdeformidDirtyFlag = true;
    }

    public String getMinorPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFormId();
        }
        return this.minorpsdeformid;
    }

    public boolean isMinorPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFormIdDirty();
        }
        return this.minorpsdeformidDirtyFlag;
    }

    public void resetMinorPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFormId();
            return;
        }
        this.minorpsdeformidDirtyFlag = false;
        this.minorpsdeformid = null;
    }

    public void setMinorPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeformname = string;
        this.minorpsdeformnameDirtyFlag = true;
    }

    public String getMinorPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEFormName();
        }
        return this.minorpsdeformname;
    }

    public boolean isMinorPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEFormNameDirty();
        }
        return this.minorpsdeformnameDirtyFlag;
    }

    public void resetMinorPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEFormName();
            return;
        }
        this.minorpsdeformnameDirtyFlag = false;
        this.minorpsdeformname = null;
    }

    public void setPSDEFormRFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormRFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformrfid = string;
        this.psdeformrfidDirtyFlag = true;
    }

    public String getPSDEFormRFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormRFId();
        }
        return this.psdeformrfid;
    }

    public boolean isPSDEFormRFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormRFIdDirty();
        }
        return this.psdeformrfidDirtyFlag;
    }

    public void resetPSDEFormRFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormRFId();
            return;
        }
        this.psdeformrfidDirtyFlag = false;
        this.psdeformrfid = null;
    }

    public void setPSDEFormRFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormRFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformrfname = string;
        this.psdeformrfnameDirtyFlag = true;
    }

    public String getPSDEFormRFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormRFName();
        }
        return this.psdeformrfname;
    }

    public boolean isPSDEFormRFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormRFNameDirty();
        }
        return this.psdeformrfnameDirtyFlag;
    }

    public void resetPSDEFormRFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormRFName();
            return;
        }
        this.psdeformrfnameDirtyFlag = false;
        this.psdeformrfname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
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
        PSDEFormRFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFormRFBase pSDEFormRFBase) {
        pSDEFormRFBase.resetCreateDate();
        pSDEFormRFBase.resetCreateMan();
        pSDEFormRFBase.resetMajorPSDEFormId();
        pSDEFormRFBase.resetMajorPSDEFormName();
        pSDEFormRFBase.resetMemo();
        pSDEFormRFBase.resetMinorPSDEFormId();
        pSDEFormRFBase.resetMinorPSDEFormName();
        pSDEFormRFBase.resetPSDEFormRFId();
        pSDEFormRFBase.resetPSDEFormRFName();
        pSDEFormRFBase.resetPSDEId();
        pSDEFormRFBase.resetUpdateDate();
        pSDEFormRFBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMajorPSDEFormIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEFORMID, this.getMajorPSDEFormId());
        }
        if (!bl || this.isMajorPSDEFormNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEFORMNAME, this.getMajorPSDEFormName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEFormIdDirty()) {
            hashMap.put(FIELD_MINORPSDEFORMID, this.getMinorPSDEFormId());
        }
        if (!bl || this.isMinorPSDEFormNameDirty()) {
            hashMap.put(FIELD_MINORPSDEFORMNAME, this.getMinorPSDEFormName());
        }
        if (!bl || this.isPSDEFormRFIdDirty()) {
            hashMap.put(FIELD_PSDEFORMRFID, this.getPSDEFormRFId());
        }
        if (!bl || this.isPSDEFormRFNameDirty()) {
            hashMap.put(FIELD_PSDEFORMRFNAME, this.getPSDEFormRFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        return PSDEFormRFBase.get(this, n);
    }

    private static Object get(PSDEFormRFBase pSDEFormRFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormRFBase.getCreateDate();
            }
            case 1: {
                return pSDEFormRFBase.getCreateMan();
            }
            case 2: {
                return pSDEFormRFBase.getMajorPSDEFormId();
            }
            case 3: {
                return pSDEFormRFBase.getMajorPSDEFormName();
            }
            case 4: {
                return pSDEFormRFBase.getMemo();
            }
            case 5: {
                return pSDEFormRFBase.getMinorPSDEFormId();
            }
            case 6: {
                return pSDEFormRFBase.getMinorPSDEFormName();
            }
            case 7: {
                return pSDEFormRFBase.getPSDEFormRFId();
            }
            case 8: {
                return pSDEFormRFBase.getPSDEFormRFName();
            }
            case 9: {
                return pSDEFormRFBase.getPSDEId();
            }
            case 10: {
                return pSDEFormRFBase.getUpdateDate();
            }
            case 11: {
                return pSDEFormRFBase.getUpdateMan();
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
        PSDEFormRFBase.set(this, n, object);
    }

    private static void set(PSDEFormRFBase pSDEFormRFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormRFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFormRFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFormRFBase.setMajorPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFormRFBase.setMajorPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFormRFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFormRFBase.setMinorPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFormRFBase.setMinorPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFormRFBase.setPSDEFormRFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFormRFBase.setPSDEFormRFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFormRFBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFormRFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEFormRFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFormRFBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFormRFBase pSDEFormRFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormRFBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFormRFBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFormRFBase.getMajorPSDEFormId() == null;
            }
            case 3: {
                return pSDEFormRFBase.getMajorPSDEFormName() == null;
            }
            case 4: {
                return pSDEFormRFBase.getMemo() == null;
            }
            case 5: {
                return pSDEFormRFBase.getMinorPSDEFormId() == null;
            }
            case 6: {
                return pSDEFormRFBase.getMinorPSDEFormName() == null;
            }
            case 7: {
                return pSDEFormRFBase.getPSDEFormRFId() == null;
            }
            case 8: {
                return pSDEFormRFBase.getPSDEFormRFName() == null;
            }
            case 9: {
                return pSDEFormRFBase.getPSDEId() == null;
            }
            case 10: {
                return pSDEFormRFBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEFormRFBase.getUpdateMan() == null;
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
        return PSDEFormRFBase.contains(this, n);
    }

    private static boolean contains(PSDEFormRFBase pSDEFormRFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormRFBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFormRFBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFormRFBase.isMajorPSDEFormIdDirty();
            }
            case 3: {
                return pSDEFormRFBase.isMajorPSDEFormNameDirty();
            }
            case 4: {
                return pSDEFormRFBase.isMemoDirty();
            }
            case 5: {
                return pSDEFormRFBase.isMinorPSDEFormIdDirty();
            }
            case 6: {
                return pSDEFormRFBase.isMinorPSDEFormNameDirty();
            }
            case 7: {
                return pSDEFormRFBase.isPSDEFormRFIdDirty();
            }
            case 8: {
                return pSDEFormRFBase.isPSDEFormRFNameDirty();
            }
            case 9: {
                return pSDEFormRFBase.isPSDEIdDirty();
            }
            case 10: {
                return pSDEFormRFBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEFormRFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFormRFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFormRFBase pSDEFormRFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFormRFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getMajorPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeformid", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getMajorPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getMajorPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeformname", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getMajorPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getMinorPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeformid", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getMinorPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getMinorPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeformname", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getMinorPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getPSDEFormRFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformrfid", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getPSDEFormRFId()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getPSDEFormRFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformrfname", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getPSDEFormRFName()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFormRFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFormRFBase.getJSONValue((Object)pSDEFormRFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFormRFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFormRFBase pSDEFormRFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFormRFBase.getCreateDate() != null) {
            object = pSDEFormRFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormRFBase.getCreateMan() != null) {
            object = pSDEFormRFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getMajorPSDEFormId() != null) {
            object = pSDEFormRFBase.getMajorPSDEFormId();
            xmlNode.setAttribute(FIELD_MAJORPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getMajorPSDEFormName() != null) {
            object = pSDEFormRFBase.getMajorPSDEFormName();
            xmlNode.setAttribute(FIELD_MAJORPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getMemo() != null) {
            object = pSDEFormRFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getMinorPSDEFormId() != null) {
            object = pSDEFormRFBase.getMinorPSDEFormId();
            xmlNode.setAttribute(FIELD_MINORPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getMinorPSDEFormName() != null) {
            object = pSDEFormRFBase.getMinorPSDEFormName();
            xmlNode.setAttribute(FIELD_MINORPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getPSDEFormRFId() != null) {
            object = pSDEFormRFBase.getPSDEFormRFId();
            xmlNode.setAttribute(FIELD_PSDEFORMRFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getPSDEFormRFName() != null) {
            object = pSDEFormRFBase.getPSDEFormRFName();
            xmlNode.setAttribute(FIELD_PSDEFORMRFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getPSDEId() != null) {
            object = pSDEFormRFBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormRFBase.getUpdateDate() != null) {
            object = pSDEFormRFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormRFBase.getUpdateMan() != null) {
            object = pSDEFormRFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFormRFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFormRFBase pSDEFormRFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFormRFBase.isCreateDateDirty() && (bl || pSDEFormRFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFormRFBase.getCreateDate());
        }
        if (pSDEFormRFBase.isCreateManDirty() && (bl || pSDEFormRFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFormRFBase.getCreateMan());
        }
        if (pSDEFormRFBase.isMajorPSDEFormIdDirty() && (bl || pSDEFormRFBase.getMajorPSDEFormId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFORMID, (Object)pSDEFormRFBase.getMajorPSDEFormId());
        }
        if (pSDEFormRFBase.isMajorPSDEFormNameDirty() && (bl || pSDEFormRFBase.getMajorPSDEFormName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEFORMNAME, (Object)pSDEFormRFBase.getMajorPSDEFormName());
        }
        if (pSDEFormRFBase.isMemoDirty() && (bl || pSDEFormRFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFormRFBase.getMemo());
        }
        if (pSDEFormRFBase.isMinorPSDEFormIdDirty() && (bl || pSDEFormRFBase.getMinorPSDEFormId() != null)) {
            iDataObject.set(FIELD_MINORPSDEFORMID, (Object)pSDEFormRFBase.getMinorPSDEFormId());
        }
        if (pSDEFormRFBase.isMinorPSDEFormNameDirty() && (bl || pSDEFormRFBase.getMinorPSDEFormName() != null)) {
            iDataObject.set(FIELD_MINORPSDEFORMNAME, (Object)pSDEFormRFBase.getMinorPSDEFormName());
        }
        if (pSDEFormRFBase.isPSDEFormRFIdDirty() && (bl || pSDEFormRFBase.getPSDEFormRFId() != null)) {
            iDataObject.set(FIELD_PSDEFORMRFID, (Object)pSDEFormRFBase.getPSDEFormRFId());
        }
        if (pSDEFormRFBase.isPSDEFormRFNameDirty() && (bl || pSDEFormRFBase.getPSDEFormRFName() != null)) {
            iDataObject.set(FIELD_PSDEFORMRFNAME, (Object)pSDEFormRFBase.getPSDEFormRFName());
        }
        if (pSDEFormRFBase.isPSDEIdDirty() && (bl || pSDEFormRFBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFormRFBase.getPSDEId());
        }
        if (pSDEFormRFBase.isUpdateDateDirty() && (bl || pSDEFormRFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFormRFBase.getUpdateDate());
        }
        if (pSDEFormRFBase.isUpdateManDirty() && (bl || pSDEFormRFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFormRFBase.getUpdateMan());
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
        return PSDEFormRFBase.remove(this, n);
    }

    private static boolean remove(PSDEFormRFBase pSDEFormRFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormRFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFormRFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFormRFBase.resetMajorPSDEFormId();
                return true;
            }
            case 3: {
                pSDEFormRFBase.resetMajorPSDEFormName();
                return true;
            }
            case 4: {
                pSDEFormRFBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEFormRFBase.resetMinorPSDEFormId();
                return true;
            }
            case 6: {
                pSDEFormRFBase.resetMinorPSDEFormName();
                return true;
            }
            case 7: {
                pSDEFormRFBase.resetPSDEFormRFId();
                return true;
            }
            case 8: {
                pSDEFormRFBase.resetPSDEFormRFName();
                return true;
            }
            case 9: {
                pSDEFormRFBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSDEFormRFBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEFormRFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMajorPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEForm();
        }
        if (this.getMajorPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEFormLock;
        synchronized (n) {
            if (this.majorpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEFormId(), (Object)this.majorpsdeform.getPSDEFormId()) != 0L) {
                this.majorpsdeform = null;
            }
            if (this.majorpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMajorPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.majorpsdeform = pSDEForm;
            }
            return this.majorpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMinorPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEForm();
        }
        if (this.getMinorPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEFormLock;
        synchronized (n) {
            if (this.minorpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEFormId(), (Object)this.minorpsdeform.getPSDEFormId()) != 0L) {
                this.minorpsdeform = null;
            }
            if (this.minorpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMinorPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.minorpsdeform = pSDEForm;
            }
            return this.minorpsdeform;
        }
    }

    private PSDEFormRFBase getProxyEntity() {
        return this.proxyPSDEFormRFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFormRFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFormRFBase) {
            this.proxyPSDEFormRFBase = (PSDEFormRFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAJORPSDEFORMID, 2);
        fieldIndexMap.put(FIELD_MAJORPSDEFORMNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MINORPSDEFORMID, 5);
        fieldIndexMap.put(FIELD_MINORPSDEFORMNAME, 6);
        fieldIndexMap.put(FIELD_PSDEFORMRFID, 7);
        fieldIndexMap.put(FIELD_PSDEFORMRFNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

