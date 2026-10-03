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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESPFieldBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DECLAREPARAM = "DECLAREPARAM";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PROCPARAM = "PROCPARAM";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDESPFIELDID = "PSDESPFIELDID";
    public static final String FIELD_PSDESPFIELDNAME = "PSDESPFIELDNAME";
    public static final String FIELD_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String FIELD_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DECLAREPARAM = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PROCPARAM = 5;
    private static final int INDEX_PSDEFID = 6;
    private static final int INDEX_PSDEFNAME = 7;
    private static final int INDEX_PSDESPFIELDID = 8;
    private static final int INDEX_PSDESPFIELDNAME = 9;
    private static final int INDEX_PSDESYSPROCID = 10;
    private static final int INDEX_PSDESYSPROCNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESPFieldBase proxyPSDESPFieldBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean declareparamDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean procparamDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdespfieldidDirtyFlag = false;
    private boolean psdespfieldnameDirtyFlag = false;
    private boolean psdesysprocidDirtyFlag = false;
    private boolean psdesysprocnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="declareparam")
    private Integer declareparam;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="procparam")
    private Integer procparam;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdespfieldid")
    private String psdespfieldid;
    @Column(name="psdespfieldname")
    private String psdespfieldname;
    @Column(name="psdesysprocid")
    private String psdesysprocid;
    @Column(name="psdesysprocname")
    private String psdesysprocname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPsdesysprocLock = new Integer(1);
    private PSDESysProc psdesysproc = null;

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

    public void setDeclareParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeclareParam(n);
            return;
        }
        this.declareparam = n;
        this.declareparamDirtyFlag = true;
    }

    public Integer getDeclareParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeclareParam();
        }
        return this.declareparam;
    }

    public boolean isDeclareParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeclareParamDirty();
        }
        return this.declareparamDirtyFlag;
    }

    public void resetDeclareParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeclareParam();
            return;
        }
        this.declareparamDirtyFlag = false;
        this.declareparam = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPROCParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPROCParam(n);
            return;
        }
        this.procparam = n;
        this.procparamDirtyFlag = true;
    }

    public Integer getPROCParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPROCParam();
        }
        return this.procparam;
    }

    public boolean isPROCParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPROCParamDirty();
        }
        return this.procparamDirtyFlag;
    }

    public void resetPROCParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPROCParam();
            return;
        }
        this.procparamDirtyFlag = false;
        this.procparam = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDESPFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespfieldid = string;
        this.psdespfieldidDirtyFlag = true;
    }

    public String getPSDESPFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPFieldId();
        }
        return this.psdespfieldid;
    }

    public boolean isPSDESPFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPFieldIdDirty();
        }
        return this.psdespfieldidDirtyFlag;
    }

    public void resetPSDESPFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPFieldId();
            return;
        }
        this.psdespfieldidDirtyFlag = false;
        this.psdespfieldid = null;
    }

    public void setPSDESPFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespfieldname = string;
        this.psdespfieldnameDirtyFlag = true;
    }

    public String getPSDESPFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPFieldName();
        }
        return this.psdespfieldname;
    }

    public boolean isPSDESPFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPFieldNameDirty();
        }
        return this.psdespfieldnameDirtyFlag;
    }

    public void resetPSDESPFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPFieldName();
            return;
        }
        this.psdespfieldnameDirtyFlag = false;
        this.psdespfieldname = null;
    }

    public void setPSDESysProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocid = string;
        this.psdesysprocidDirtyFlag = true;
    }

    public String getPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcId();
        }
        return this.psdesysprocid;
    }

    public boolean isPSDESysProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcIdDirty();
        }
        return this.psdesysprocidDirtyFlag;
    }

    public void resetPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcId();
            return;
        }
        this.psdesysprocidDirtyFlag = false;
        this.psdesysprocid = null;
    }

    public void setPSDESysProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocname = string;
        this.psdesysprocnameDirtyFlag = true;
    }

    public String getPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcName();
        }
        return this.psdesysprocname;
    }

    public boolean isPSDESysProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcNameDirty();
        }
        return this.psdesysprocnameDirtyFlag;
    }

    public void resetPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcName();
            return;
        }
        this.psdesysprocnameDirtyFlag = false;
        this.psdesysprocname = null;
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
        PSDESPFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESPFieldBase pSDESPFieldBase) {
        pSDESPFieldBase.resetCreateDate();
        pSDESPFieldBase.resetCreateMan();
        pSDESPFieldBase.resetDeclareParam();
        pSDESPFieldBase.resetMemo();
        pSDESPFieldBase.resetOrderValue();
        pSDESPFieldBase.resetPROCParam();
        pSDESPFieldBase.resetPSDEFId();
        pSDESPFieldBase.resetPSDEFName();
        pSDESPFieldBase.resetPSDESPFieldId();
        pSDESPFieldBase.resetPSDESPFieldName();
        pSDESPFieldBase.resetPSDESysProcId();
        pSDESPFieldBase.resetPSDESysProcName();
        pSDESPFieldBase.resetUpdateDate();
        pSDESPFieldBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeclareParamDirty()) {
            hashMap.put(FIELD_DECLAREPARAM, this.getDeclareParam());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPROCParamDirty()) {
            hashMap.put(FIELD_PROCPARAM, this.getPROCParam());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDESPFieldIdDirty()) {
            hashMap.put(FIELD_PSDESPFIELDID, this.getPSDESPFieldId());
        }
        if (!bl || this.isPSDESPFieldNameDirty()) {
            hashMap.put(FIELD_PSDESPFIELDNAME, this.getPSDESPFieldName());
        }
        if (!bl || this.isPSDESysProcIdDirty()) {
            hashMap.put(FIELD_PSDESYSPROCID, this.getPSDESysProcId());
        }
        if (!bl || this.isPSDESysProcNameDirty()) {
            hashMap.put(FIELD_PSDESYSPROCNAME, this.getPSDESysProcName());
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
        return PSDESPFieldBase.get(this, n);
    }

    private static Object get(PSDESPFieldBase pSDESPFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPFieldBase.getCreateDate();
            }
            case 1: {
                return pSDESPFieldBase.getCreateMan();
            }
            case 2: {
                return pSDESPFieldBase.getDeclareParam();
            }
            case 3: {
                return pSDESPFieldBase.getMemo();
            }
            case 4: {
                return pSDESPFieldBase.getOrderValue();
            }
            case 5: {
                return pSDESPFieldBase.getPROCParam();
            }
            case 6: {
                return pSDESPFieldBase.getPSDEFId();
            }
            case 7: {
                return pSDESPFieldBase.getPSDEFName();
            }
            case 8: {
                return pSDESPFieldBase.getPSDESPFieldId();
            }
            case 9: {
                return pSDESPFieldBase.getPSDESPFieldName();
            }
            case 10: {
                return pSDESPFieldBase.getPSDESysProcId();
            }
            case 11: {
                return pSDESPFieldBase.getPSDESysProcName();
            }
            case 12: {
                return pSDESPFieldBase.getUpdateDate();
            }
            case 13: {
                return pSDESPFieldBase.getUpdateMan();
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
        PSDESPFieldBase.set(this, n, object);
    }

    private static void set(PSDESPFieldBase pSDESPFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESPFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDESPFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDESPFieldBase.setDeclareParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDESPFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESPFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDESPFieldBase.setPROCParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDESPFieldBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESPFieldBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESPFieldBase.setPSDESPFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESPFieldBase.setPSDESPFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESPFieldBase.setPSDESysProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESPFieldBase.setPSDESysProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESPFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDESPFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDESPFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSDESPFieldBase pSDESPFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPFieldBase.getCreateDate() == null;
            }
            case 1: {
                return pSDESPFieldBase.getCreateMan() == null;
            }
            case 2: {
                return pSDESPFieldBase.getDeclareParam() == null;
            }
            case 3: {
                return pSDESPFieldBase.getMemo() == null;
            }
            case 4: {
                return pSDESPFieldBase.getOrderValue() == null;
            }
            case 5: {
                return pSDESPFieldBase.getPROCParam() == null;
            }
            case 6: {
                return pSDESPFieldBase.getPSDEFId() == null;
            }
            case 7: {
                return pSDESPFieldBase.getPSDEFName() == null;
            }
            case 8: {
                return pSDESPFieldBase.getPSDESPFieldId() == null;
            }
            case 9: {
                return pSDESPFieldBase.getPSDESPFieldName() == null;
            }
            case 10: {
                return pSDESPFieldBase.getPSDESysProcId() == null;
            }
            case 11: {
                return pSDESPFieldBase.getPSDESysProcName() == null;
            }
            case 12: {
                return pSDESPFieldBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDESPFieldBase.getUpdateMan() == null;
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
        return PSDESPFieldBase.contains(this, n);
    }

    private static boolean contains(PSDESPFieldBase pSDESPFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPFieldBase.isCreateDateDirty();
            }
            case 1: {
                return pSDESPFieldBase.isCreateManDirty();
            }
            case 2: {
                return pSDESPFieldBase.isDeclareParamDirty();
            }
            case 3: {
                return pSDESPFieldBase.isMemoDirty();
            }
            case 4: {
                return pSDESPFieldBase.isOrderValueDirty();
            }
            case 5: {
                return pSDESPFieldBase.isPROCParamDirty();
            }
            case 6: {
                return pSDESPFieldBase.isPSDEFIdDirty();
            }
            case 7: {
                return pSDESPFieldBase.isPSDEFNameDirty();
            }
            case 8: {
                return pSDESPFieldBase.isPSDESPFieldIdDirty();
            }
            case 9: {
                return pSDESPFieldBase.isPSDESPFieldNameDirty();
            }
            case 10: {
                return pSDESPFieldBase.isPSDESysProcIdDirty();
            }
            case 11: {
                return pSDESPFieldBase.isPSDESysProcNameDirty();
            }
            case 12: {
                return pSDESPFieldBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDESPFieldBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESPFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESPFieldBase pSDESPFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESPFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getDeclareParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"declareparam", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getDeclareParam()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPROCParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"procparam", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPROCParam()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDESPFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespfieldid", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDESPFieldId()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDESPFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespfieldname", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDESPFieldName()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDESysProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocid", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDESysProcId()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getPSDESysProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocname", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getPSDESysProcName()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESPFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESPFieldBase.getJSONValue((Object)pSDESPFieldBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESPFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESPFieldBase pSDESPFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESPFieldBase.getCreateDate() != null) {
            object = pSDESPFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPFieldBase.getCreateMan() != null) {
            object = pSDESPFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getDeclareParam() != null) {
            object = pSDESPFieldBase.getDeclareParam();
            xmlNode.setAttribute(FIELD_DECLAREPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPFieldBase.getMemo() != null) {
            object = pSDESPFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getOrderValue() != null) {
            object = pSDESPFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPFieldBase.getPROCParam() != null) {
            object = pSDESPFieldBase.getPROCParam();
            xmlNode.setAttribute(FIELD_PROCPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPFieldBase.getPSDEFId() != null) {
            object = pSDESPFieldBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getPSDEFName() != null) {
            object = pSDESPFieldBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getPSDESPFieldId() != null) {
            object = pSDESPFieldBase.getPSDESPFieldId();
            xmlNode.setAttribute(FIELD_PSDESPFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getPSDESPFieldName() != null) {
            object = pSDESPFieldBase.getPSDESPFieldName();
            xmlNode.setAttribute(FIELD_PSDESPFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getPSDESysProcId() != null) {
            object = pSDESPFieldBase.getPSDESysProcId();
            xmlNode.setAttribute(FIELD_PSDESYSPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getPSDESysProcName() != null) {
            object = pSDESPFieldBase.getPSDESysProcName();
            xmlNode.setAttribute(FIELD_PSDESYSPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPFieldBase.getUpdateDate() != null) {
            object = pSDESPFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPFieldBase.getUpdateMan() != null) {
            object = pSDESPFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESPFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESPFieldBase pSDESPFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESPFieldBase.isCreateDateDirty() && (bl || pSDESPFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESPFieldBase.getCreateDate());
        }
        if (pSDESPFieldBase.isCreateManDirty() && (bl || pSDESPFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESPFieldBase.getCreateMan());
        }
        if (pSDESPFieldBase.isDeclareParamDirty() && (bl || pSDESPFieldBase.getDeclareParam() != null)) {
            iDataObject.set(FIELD_DECLAREPARAM, (Object)pSDESPFieldBase.getDeclareParam());
        }
        if (pSDESPFieldBase.isMemoDirty() && (bl || pSDESPFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESPFieldBase.getMemo());
        }
        if (pSDESPFieldBase.isOrderValueDirty() && (bl || pSDESPFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESPFieldBase.getOrderValue());
        }
        if (pSDESPFieldBase.isPROCParamDirty() && (bl || pSDESPFieldBase.getPROCParam() != null)) {
            iDataObject.set(FIELD_PROCPARAM, (Object)pSDESPFieldBase.getPROCParam());
        }
        if (pSDESPFieldBase.isPSDEFIdDirty() && (bl || pSDESPFieldBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDESPFieldBase.getPSDEFId());
        }
        if (pSDESPFieldBase.isPSDEFNameDirty() && (bl || pSDESPFieldBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDESPFieldBase.getPSDEFName());
        }
        if (pSDESPFieldBase.isPSDESPFieldIdDirty() && (bl || pSDESPFieldBase.getPSDESPFieldId() != null)) {
            iDataObject.set(FIELD_PSDESPFIELDID, (Object)pSDESPFieldBase.getPSDESPFieldId());
        }
        if (pSDESPFieldBase.isPSDESPFieldNameDirty() && (bl || pSDESPFieldBase.getPSDESPFieldName() != null)) {
            iDataObject.set(FIELD_PSDESPFIELDNAME, (Object)pSDESPFieldBase.getPSDESPFieldName());
        }
        if (pSDESPFieldBase.isPSDESysProcIdDirty() && (bl || pSDESPFieldBase.getPSDESysProcId() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCID, (Object)pSDESPFieldBase.getPSDESysProcId());
        }
        if (pSDESPFieldBase.isPSDESysProcNameDirty() && (bl || pSDESPFieldBase.getPSDESysProcName() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCNAME, (Object)pSDESPFieldBase.getPSDESysProcName());
        }
        if (pSDESPFieldBase.isUpdateDateDirty() && (bl || pSDESPFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESPFieldBase.getUpdateDate());
        }
        if (pSDESPFieldBase.isUpdateManDirty() && (bl || pSDESPFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESPFieldBase.getUpdateMan());
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
        return PSDESPFieldBase.remove(this, n);
    }

    private static boolean remove(PSDESPFieldBase pSDESPFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESPFieldBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDESPFieldBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDESPFieldBase.resetDeclareParam();
                return true;
            }
            case 3: {
                pSDESPFieldBase.resetMemo();
                return true;
            }
            case 4: {
                pSDESPFieldBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDESPFieldBase.resetPROCParam();
                return true;
            }
            case 6: {
                pSDESPFieldBase.resetPSDEFId();
                return true;
            }
            case 7: {
                pSDESPFieldBase.resetPSDEFName();
                return true;
            }
            case 8: {
                pSDESPFieldBase.resetPSDESPFieldId();
                return true;
            }
            case 9: {
                pSDESPFieldBase.resetPSDESPFieldName();
                return true;
            }
            case 10: {
                pSDESPFieldBase.resetPSDESysProcId();
                return true;
            }
            case 11: {
                pSDESPFieldBase.resetPSDESysProcName();
                return true;
            }
            case 12: {
                pSDESPFieldBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDESPFieldBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESysProc getPsdesysproc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdesysproc();
        }
        if (this.getPSDESysProcId() == null) {
            return null;
        }
        Integer n = this.objPsdesysprocLock;
        synchronized (n) {
            if (this.psdesysproc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESysProcId(), (Object)this.psdesysproc.getPSDESysProcId()) != 0L) {
                this.psdesysproc = null;
            }
            if (this.psdesysproc == null) {
                PSDESysProc pSDESysProc = new PSDESysProc();
                pSDESysProc.setPSDESysProcId(this.getPSDESysProcId());
                PSDESysProcService pSDESysProcService = (PSDESysProcService)ServiceGlobal.getService(PSDESysProcService.class, (SessionFactory)this.getSessionFactory());
                pSDESysProcService.autoGet(pSDESysProc);
                this.psdesysproc = pSDESysProc;
            }
            return this.psdesysproc;
        }
    }

    private PSDESPFieldBase getProxyEntity() {
        return this.proxyPSDESPFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESPFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESPFieldBase) {
            this.proxyPSDESPFieldBase = (PSDESPFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESPFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DECLAREPARAM, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PROCPARAM, 5);
        fieldIndexMap.put(FIELD_PSDEFID, 6);
        fieldIndexMap.put(FIELD_PSDEFNAME, 7);
        fieldIndexMap.put(FIELD_PSDESPFIELDID, 8);
        fieldIndexMap.put(FIELD_PSDESPFIELDNAME, 9);
        fieldIndexMap.put(FIELD_PSDESYSPROCID, 10);
        fieldIndexMap.put(FIELD_PSDESYSPROCNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

