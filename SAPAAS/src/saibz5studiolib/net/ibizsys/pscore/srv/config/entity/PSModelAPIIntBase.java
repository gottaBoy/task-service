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
import net.ibizsys.pscore.srv.config.entity.PSModelAPI;
import net.ibizsys.pscore.srv.config.service.PSModelAPIService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIIntBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelAPIIntBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INTDESC = "INTDESC";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELAPIID = "PSMODELAPIID";
    public static final String FIELD_PSMODELAPIINTID = "PSMODELAPIINTID";
    public static final String FIELD_PSMODELAPIINTNAME = "PSMODELAPIINTNAME";
    public static final String FIELD_PSMODELAPINAME = "PSMODELAPINAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_TYPEFIELD = "TYPEFIELD";
    public static final String FIELD_TYPEPARAM = "TYPEPARAM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INTDESC = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSMODELAPIID = 5;
    private static final int INDEX_PSMODELAPIINTID = 6;
    private static final int INDEX_PSMODELAPIINTNAME = 7;
    private static final int INDEX_PSMODELAPINAME = 8;
    private static final int INDEX_PSMODELID = 9;
    private static final int INDEX_PSMODELNAME = 10;
    private static final int INDEX_TYPEFIELD = 11;
    private static final int INDEX_TYPEPARAM = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelAPIIntBase proxyPSModelAPIIntBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean intdescDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelapiidDirtyFlag = false;
    private boolean psmodelapiintidDirtyFlag = false;
    private boolean psmodelapiintnameDirtyFlag = false;
    private boolean psmodelapinameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean typefieldDirtyFlag = false;
    private boolean typeparamDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="intdesc")
    private String intdesc;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelapiid")
    private String psmodelapiid;
    @Column(name="psmodelapiintid")
    private String psmodelapiintid;
    @Column(name="psmodelapiintname")
    private String psmodelapiintname;
    @Column(name="psmodelapiname")
    private String psmodelapiname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="typefield")
    private String typefield;
    @Column(name="typeparam")
    private String typeparam;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelAPILock = new Integer(1);
    private PSModelAPI psmodelapi = null;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setIntDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIntDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.intdesc = string;
        this.intdescDirtyFlag = true;
    }

    public String getIntDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIntDesc();
        }
        return this.intdesc;
    }

    public boolean isIntDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIntDescDirty();
        }
        return this.intdescDirtyFlag;
    }

    public void resetIntDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIntDesc();
            return;
        }
        this.intdescDirtyFlag = false;
        this.intdesc = null;
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

    public void setPSModelAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiid = string;
        this.psmodelapiidDirtyFlag = true;
    }

    public String getPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIId();
        }
        return this.psmodelapiid;
    }

    public boolean isPSModelAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIdDirty();
        }
        return this.psmodelapiidDirtyFlag;
    }

    public void resetPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIId();
            return;
        }
        this.psmodelapiidDirtyFlag = false;
        this.psmodelapiid = null;
    }

    public void setPSModelAPIIntId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIIntId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiintid = string;
        this.psmodelapiintidDirtyFlag = true;
    }

    public String getPSModelAPIIntId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIIntId();
        }
        return this.psmodelapiintid;
    }

    public boolean isPSModelAPIIntIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIntIdDirty();
        }
        return this.psmodelapiintidDirtyFlag;
    }

    public void resetPSModelAPIIntId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIIntId();
            return;
        }
        this.psmodelapiintidDirtyFlag = false;
        this.psmodelapiintid = null;
    }

    public void setPSModelAPIIntName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIIntName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiintname = string;
        this.psmodelapiintnameDirtyFlag = true;
    }

    public String getPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIIntName();
        }
        return this.psmodelapiintname;
    }

    public boolean isPSModelAPIIntNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIntNameDirty();
        }
        return this.psmodelapiintnameDirtyFlag;
    }

    public void resetPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIIntName();
            return;
        }
        this.psmodelapiintnameDirtyFlag = false;
        this.psmodelapiintname = null;
    }

    public void setPSModelAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiname = string;
        this.psmodelapinameDirtyFlag = true;
    }

    public String getPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIName();
        }
        return this.psmodelapiname;
    }

    public boolean isPSModelAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPINameDirty();
        }
        return this.psmodelapinameDirtyFlag;
    }

    public void resetPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIName();
            return;
        }
        this.psmodelapinameDirtyFlag = false;
        this.psmodelapiname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setTypeField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typefield = string;
        this.typefieldDirtyFlag = true;
    }

    public String getTypeField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeField();
        }
        return this.typefield;
    }

    public boolean isTypeFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeFieldDirty();
        }
        return this.typefieldDirtyFlag;
    }

    public void resetTypeField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeField();
            return;
        }
        this.typefieldDirtyFlag = false;
        this.typefield = null;
    }

    public void setTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam = string;
        this.typeparamDirtyFlag = true;
    }

    public String getTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam();
        }
        return this.typeparam;
    }

    public boolean isTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamDirty();
        }
        return this.typeparamDirtyFlag;
    }

    public void resetTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam();
            return;
        }
        this.typeparamDirtyFlag = false;
        this.typeparam = null;
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
        PSModelAPIIntBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelAPIIntBase pSModelAPIIntBase) {
        pSModelAPIIntBase.resetCreateDate();
        pSModelAPIIntBase.resetCreateMan();
        pSModelAPIIntBase.resetIntDesc();
        pSModelAPIIntBase.resetMemo();
        pSModelAPIIntBase.resetOrderValue();
        pSModelAPIIntBase.resetPSModelAPIId();
        pSModelAPIIntBase.resetPSModelAPIIntId();
        pSModelAPIIntBase.resetPSModelAPIIntName();
        pSModelAPIIntBase.resetPSModelAPIName();
        pSModelAPIIntBase.resetPSModelId();
        pSModelAPIIntBase.resetPSModelName();
        pSModelAPIIntBase.resetTypeField();
        pSModelAPIIntBase.resetTypeParam();
        pSModelAPIIntBase.resetUpdateDate();
        pSModelAPIIntBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIntDescDirty()) {
            hashMap.put(FIELD_INTDESC, this.getIntDesc());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelAPIIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIID, this.getPSModelAPIId());
        }
        if (!bl || this.isPSModelAPIIntIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIINTID, this.getPSModelAPIIntId());
        }
        if (!bl || this.isPSModelAPIIntNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIINTNAME, this.getPSModelAPIIntName());
        }
        if (!bl || this.isPSModelAPINameDirty()) {
            hashMap.put(FIELD_PSMODELAPINAME, this.getPSModelAPIName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isTypeFieldDirty()) {
            hashMap.put(FIELD_TYPEFIELD, this.getTypeField());
        }
        if (!bl || this.isTypeParamDirty()) {
            hashMap.put(FIELD_TYPEPARAM, this.getTypeParam());
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
        return PSModelAPIIntBase.get(this, n);
    }

    private static Object get(PSModelAPIIntBase pSModelAPIIntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIIntBase.getCreateDate();
            }
            case 1: {
                return pSModelAPIIntBase.getCreateMan();
            }
            case 2: {
                return pSModelAPIIntBase.getIntDesc();
            }
            case 3: {
                return pSModelAPIIntBase.getMemo();
            }
            case 4: {
                return pSModelAPIIntBase.getOrderValue();
            }
            case 5: {
                return pSModelAPIIntBase.getPSModelAPIId();
            }
            case 6: {
                return pSModelAPIIntBase.getPSModelAPIIntId();
            }
            case 7: {
                return pSModelAPIIntBase.getPSModelAPIIntName();
            }
            case 8: {
                return pSModelAPIIntBase.getPSModelAPIName();
            }
            case 9: {
                return pSModelAPIIntBase.getPSModelId();
            }
            case 10: {
                return pSModelAPIIntBase.getPSModelName();
            }
            case 11: {
                return pSModelAPIIntBase.getTypeField();
            }
            case 12: {
                return pSModelAPIIntBase.getTypeParam();
            }
            case 13: {
                return pSModelAPIIntBase.getUpdateDate();
            }
            case 14: {
                return pSModelAPIIntBase.getUpdateMan();
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
        PSModelAPIIntBase.set(this, n, object);
    }

    private static void set(PSModelAPIIntBase pSModelAPIIntBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIIntBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelAPIIntBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelAPIIntBase.setIntDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelAPIIntBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelAPIIntBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelAPIIntBase.setPSModelAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelAPIIntBase.setPSModelAPIIntId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelAPIIntBase.setPSModelAPIIntName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelAPIIntBase.setPSModelAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelAPIIntBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelAPIIntBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelAPIIntBase.setTypeField(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelAPIIntBase.setTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelAPIIntBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSModelAPIIntBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelAPIIntBase.isNull(this, n);
    }

    private static boolean isNull(PSModelAPIIntBase pSModelAPIIntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIIntBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelAPIIntBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelAPIIntBase.getIntDesc() == null;
            }
            case 3: {
                return pSModelAPIIntBase.getMemo() == null;
            }
            case 4: {
                return pSModelAPIIntBase.getOrderValue() == null;
            }
            case 5: {
                return pSModelAPIIntBase.getPSModelAPIId() == null;
            }
            case 6: {
                return pSModelAPIIntBase.getPSModelAPIIntId() == null;
            }
            case 7: {
                return pSModelAPIIntBase.getPSModelAPIIntName() == null;
            }
            case 8: {
                return pSModelAPIIntBase.getPSModelAPIName() == null;
            }
            case 9: {
                return pSModelAPIIntBase.getPSModelId() == null;
            }
            case 10: {
                return pSModelAPIIntBase.getPSModelName() == null;
            }
            case 11: {
                return pSModelAPIIntBase.getTypeField() == null;
            }
            case 12: {
                return pSModelAPIIntBase.getTypeParam() == null;
            }
            case 13: {
                return pSModelAPIIntBase.getUpdateDate() == null;
            }
            case 14: {
                return pSModelAPIIntBase.getUpdateMan() == null;
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
        return PSModelAPIIntBase.contains(this, n);
    }

    private static boolean contains(PSModelAPIIntBase pSModelAPIIntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIIntBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelAPIIntBase.isCreateManDirty();
            }
            case 2: {
                return pSModelAPIIntBase.isIntDescDirty();
            }
            case 3: {
                return pSModelAPIIntBase.isMemoDirty();
            }
            case 4: {
                return pSModelAPIIntBase.isOrderValueDirty();
            }
            case 5: {
                return pSModelAPIIntBase.isPSModelAPIIdDirty();
            }
            case 6: {
                return pSModelAPIIntBase.isPSModelAPIIntIdDirty();
            }
            case 7: {
                return pSModelAPIIntBase.isPSModelAPIIntNameDirty();
            }
            case 8: {
                return pSModelAPIIntBase.isPSModelAPINameDirty();
            }
            case 9: {
                return pSModelAPIIntBase.isPSModelIdDirty();
            }
            case 10: {
                return pSModelAPIIntBase.isPSModelNameDirty();
            }
            case 11: {
                return pSModelAPIIntBase.isTypeFieldDirty();
            }
            case 12: {
                return pSModelAPIIntBase.isTypeParamDirty();
            }
            case 13: {
                return pSModelAPIIntBase.isUpdateDateDirty();
            }
            case 14: {
                return pSModelAPIIntBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelAPIIntBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelAPIIntBase pSModelAPIIntBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelAPIIntBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getIntDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"intdesc", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getIntDesc()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiid", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelAPIId()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIIntId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiintid", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelAPIIntId()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIIntName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiintname", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelAPIIntName()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiname", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelAPIName()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getTypeField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefield", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getTypeField()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getTypeParam()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelAPIIntBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelAPIIntBase.getJSONValue((Object)pSModelAPIIntBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelAPIIntBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelAPIIntBase pSModelAPIIntBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelAPIIntBase.getCreateDate() != null) {
            object = pSModelAPIIntBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIIntBase.getCreateMan() != null) {
            object = pSModelAPIIntBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getIntDesc() != null) {
            object = pSModelAPIIntBase.getIntDesc();
            xmlNode.setAttribute(FIELD_INTDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getMemo() != null) {
            object = pSModelAPIIntBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getOrderValue() != null) {
            object = pSModelAPIIntBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIId() != null) {
            object = pSModelAPIIntBase.getPSModelAPIId();
            xmlNode.setAttribute(FIELD_PSMODELAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIIntId() != null) {
            object = pSModelAPIIntBase.getPSModelAPIIntId();
            xmlNode.setAttribute(FIELD_PSMODELAPIINTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIIntName() != null) {
            object = pSModelAPIIntBase.getPSModelAPIIntName();
            xmlNode.setAttribute(FIELD_PSMODELAPIINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getPSModelAPIName() != null) {
            object = pSModelAPIIntBase.getPSModelAPIName();
            xmlNode.setAttribute(FIELD_PSMODELAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getPSModelId() != null) {
            object = pSModelAPIIntBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getPSModelName() != null) {
            object = pSModelAPIIntBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getTypeField() != null) {
            object = pSModelAPIIntBase.getTypeField();
            xmlNode.setAttribute(FIELD_TYPEFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getTypeParam() != null) {
            object = pSModelAPIIntBase.getTypeParam();
            xmlNode.setAttribute(FIELD_TYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIIntBase.getUpdateDate() != null) {
            object = pSModelAPIIntBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIIntBase.getUpdateMan() != null) {
            object = pSModelAPIIntBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelAPIIntBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelAPIIntBase pSModelAPIIntBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelAPIIntBase.isCreateDateDirty() && (bl || pSModelAPIIntBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelAPIIntBase.getCreateDate());
        }
        if (pSModelAPIIntBase.isCreateManDirty() && (bl || pSModelAPIIntBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelAPIIntBase.getCreateMan());
        }
        if (pSModelAPIIntBase.isIntDescDirty() && (bl || pSModelAPIIntBase.getIntDesc() != null)) {
            iDataObject.set(FIELD_INTDESC, (Object)pSModelAPIIntBase.getIntDesc());
        }
        if (pSModelAPIIntBase.isMemoDirty() && (bl || pSModelAPIIntBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelAPIIntBase.getMemo());
        }
        if (pSModelAPIIntBase.isOrderValueDirty() && (bl || pSModelAPIIntBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelAPIIntBase.getOrderValue());
        }
        if (pSModelAPIIntBase.isPSModelAPIIdDirty() && (bl || pSModelAPIIntBase.getPSModelAPIId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIID, (Object)pSModelAPIIntBase.getPSModelAPIId());
        }
        if (pSModelAPIIntBase.isPSModelAPIIntIdDirty() && (bl || pSModelAPIIntBase.getPSModelAPIIntId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIINTID, (Object)pSModelAPIIntBase.getPSModelAPIIntId());
        }
        if (pSModelAPIIntBase.isPSModelAPIIntNameDirty() && (bl || pSModelAPIIntBase.getPSModelAPIIntName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIINTNAME, (Object)pSModelAPIIntBase.getPSModelAPIIntName());
        }
        if (pSModelAPIIntBase.isPSModelAPINameDirty() && (bl || pSModelAPIIntBase.getPSModelAPIName() != null)) {
            iDataObject.set(FIELD_PSMODELAPINAME, (Object)pSModelAPIIntBase.getPSModelAPIName());
        }
        if (pSModelAPIIntBase.isPSModelIdDirty() && (bl || pSModelAPIIntBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelAPIIntBase.getPSModelId());
        }
        if (pSModelAPIIntBase.isPSModelNameDirty() && (bl || pSModelAPIIntBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelAPIIntBase.getPSModelName());
        }
        if (pSModelAPIIntBase.isTypeFieldDirty() && (bl || pSModelAPIIntBase.getTypeField() != null)) {
            iDataObject.set(FIELD_TYPEFIELD, (Object)pSModelAPIIntBase.getTypeField());
        }
        if (pSModelAPIIntBase.isTypeParamDirty() && (bl || pSModelAPIIntBase.getTypeParam() != null)) {
            iDataObject.set(FIELD_TYPEPARAM, (Object)pSModelAPIIntBase.getTypeParam());
        }
        if (pSModelAPIIntBase.isUpdateDateDirty() && (bl || pSModelAPIIntBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelAPIIntBase.getUpdateDate());
        }
        if (pSModelAPIIntBase.isUpdateManDirty() && (bl || pSModelAPIIntBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelAPIIntBase.getUpdateMan());
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
        return PSModelAPIIntBase.remove(this, n);
    }

    private static boolean remove(PSModelAPIIntBase pSModelAPIIntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIIntBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelAPIIntBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelAPIIntBase.resetIntDesc();
                return true;
            }
            case 3: {
                pSModelAPIIntBase.resetMemo();
                return true;
            }
            case 4: {
                pSModelAPIIntBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSModelAPIIntBase.resetPSModelAPIId();
                return true;
            }
            case 6: {
                pSModelAPIIntBase.resetPSModelAPIIntId();
                return true;
            }
            case 7: {
                pSModelAPIIntBase.resetPSModelAPIIntName();
                return true;
            }
            case 8: {
                pSModelAPIIntBase.resetPSModelAPIName();
                return true;
            }
            case 9: {
                pSModelAPIIntBase.resetPSModelId();
                return true;
            }
            case 10: {
                pSModelAPIIntBase.resetPSModelName();
                return true;
            }
            case 11: {
                pSModelAPIIntBase.resetTypeField();
                return true;
            }
            case 12: {
                pSModelAPIIntBase.resetTypeParam();
                return true;
            }
            case 13: {
                pSModelAPIIntBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSModelAPIIntBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelAPI getPSModelAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPI();
        }
        if (this.getPSModelAPIId() == null) {
            return null;
        }
        Integer n = this.objPSModelAPILock;
        synchronized (n) {
            if (this.psmodelapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelAPIId(), (Object)this.psmodelapi.getPSModelAPIId()) != 0L) {
                this.psmodelapi = null;
            }
            if (this.psmodelapi == null) {
                PSModelAPI pSModelAPI = new PSModelAPI();
                pSModelAPI.setPSModelAPIId(this.getPSModelAPIId());
                PSModelAPIService pSModelAPIService = (PSModelAPIService)ServiceGlobal.getService(PSModelAPIService.class, (SessionFactory)this.getSessionFactory());
                pSModelAPIService.autoGet(pSModelAPI);
                this.psmodelapi = pSModelAPI;
            }
            return this.psmodelapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet(pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelAPIIntBase getProxyEntity() {
        return this.proxyPSModelAPIIntBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelAPIIntBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelAPIIntBase) {
            this.proxyPSModelAPIIntBase = (PSModelAPIIntBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIIntService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INTDESC, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSMODELAPIID, 5);
        fieldIndexMap.put(FIELD_PSMODELAPIINTID, 6);
        fieldIndexMap.put(FIELD_PSMODELAPIINTNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELAPINAME, 8);
        fieldIndexMap.put(FIELD_PSMODELID, 9);
        fieldIndexMap.put(FIELD_PSMODELNAME, 10);
        fieldIndexMap.put(FIELD_TYPEFIELD, 11);
        fieldIndexMap.put(FIELD_TYPEPARAM, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

