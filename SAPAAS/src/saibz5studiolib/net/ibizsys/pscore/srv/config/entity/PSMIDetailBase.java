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
import net.ibizsys.pscore.srv.config.entity.PSModelInit;
import net.ibizsys.pscore.srv.config.service.PSModelInitService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMIDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMIDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INITMODE = "INITMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMIDETAILID = "PSMIDETAILID";
    public static final String FIELD_PSMIDETAILNAME = "PSMIDETAILNAME";
    public static final String FIELD_PSMODELINITID = "PSMODELINITID";
    public static final String FIELD_PSMODELINITNAME = "PSMODELINITNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INITMODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDENAME = 5;
    private static final int INDEX_PSMIDETAILID = 6;
    private static final int INDEX_PSMIDETAILNAME = 7;
    private static final int INDEX_PSMODELINITID = 8;
    private static final int INDEX_PSMODELINITNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMIDetailBase proxyPSMIDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean initmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmidetailidDirtyFlag = false;
    private boolean psmidetailnameDirtyFlag = false;
    private boolean psmodelinitidDirtyFlag = false;
    private boolean psmodelinitnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="initmode")
    private String initmode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmidetailid")
    private String psmidetailid;
    @Column(name="psmidetailname")
    private String psmidetailname;
    @Column(name="psmodelinitid")
    private String psmodelinitid;
    @Column(name="psmodelinitname")
    private String psmodelinitname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsmodelinitLock = new Integer(1);
    private PSModelInit psmodelinit = null;

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

    public void setInitMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initmode = string;
        this.initmodeDirtyFlag = true;
    }

    public String getInitMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitMode();
        }
        return this.initmode;
    }

    public boolean isInitModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitModeDirty();
        }
        return this.initmodeDirtyFlag;
    }

    public void resetInitMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitMode();
            return;
        }
        this.initmodeDirtyFlag = false;
        this.initmode = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSMIDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMIDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmidetailid = string;
        this.psmidetailidDirtyFlag = true;
    }

    public String getPSMIDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMIDetailId();
        }
        return this.psmidetailid;
    }

    public boolean isPSMIDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMIDetailIdDirty();
        }
        return this.psmidetailidDirtyFlag;
    }

    public void resetPSMIDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMIDetailId();
            return;
        }
        this.psmidetailidDirtyFlag = false;
        this.psmidetailid = null;
    }

    public void setPSMIDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMIDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmidetailname = string;
        this.psmidetailnameDirtyFlag = true;
    }

    public String getPSMIDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMIDetailName();
        }
        return this.psmidetailname;
    }

    public boolean isPSMIDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMIDetailNameDirty();
        }
        return this.psmidetailnameDirtyFlag;
    }

    public void resetPSMIDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMIDetailName();
            return;
        }
        this.psmidetailnameDirtyFlag = false;
        this.psmidetailname = null;
    }

    public void setPSModelInitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelInitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelinitid = string;
        this.psmodelinitidDirtyFlag = true;
    }

    public String getPSModelInitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelInitId();
        }
        return this.psmodelinitid;
    }

    public boolean isPSModelInitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelInitIdDirty();
        }
        return this.psmodelinitidDirtyFlag;
    }

    public void resetPSModelInitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelInitId();
            return;
        }
        this.psmodelinitidDirtyFlag = false;
        this.psmodelinitid = null;
    }

    public void setPSModelInitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelInitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelinitname = string;
        this.psmodelinitnameDirtyFlag = true;
    }

    public String getPSModelInitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelInitName();
        }
        return this.psmodelinitname;
    }

    public boolean isPSModelInitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelInitNameDirty();
        }
        return this.psmodelinitnameDirtyFlag;
    }

    public void resetPSModelInitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelInitName();
            return;
        }
        this.psmodelinitnameDirtyFlag = false;
        this.psmodelinitname = null;
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
        PSMIDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMIDetailBase pSMIDetailBase) {
        pSMIDetailBase.resetCreateDate();
        pSMIDetailBase.resetCreateMan();
        pSMIDetailBase.resetInitMode();
        pSMIDetailBase.resetMemo();
        pSMIDetailBase.resetOrderValue();
        pSMIDetailBase.resetPSDEName();
        pSMIDetailBase.resetPSMIDetailId();
        pSMIDetailBase.resetPSMIDetailName();
        pSMIDetailBase.resetPSModelInitId();
        pSMIDetailBase.resetPSModelInitName();
        pSMIDetailBase.resetUpdateDate();
        pSMIDetailBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInitModeDirty()) {
            hashMap.put(FIELD_INITMODE, this.getInitMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSMIDetailIdDirty()) {
            hashMap.put(FIELD_PSMIDETAILID, this.getPSMIDetailId());
        }
        if (!bl || this.isPSMIDetailNameDirty()) {
            hashMap.put(FIELD_PSMIDETAILNAME, this.getPSMIDetailName());
        }
        if (!bl || this.isPSModelInitIdDirty()) {
            hashMap.put(FIELD_PSMODELINITID, this.getPSModelInitId());
        }
        if (!bl || this.isPSModelInitNameDirty()) {
            hashMap.put(FIELD_PSMODELINITNAME, this.getPSModelInitName());
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
        return PSMIDetailBase.get(this, n);
    }

    private static Object get(PSMIDetailBase pSMIDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMIDetailBase.getCreateDate();
            }
            case 1: {
                return pSMIDetailBase.getCreateMan();
            }
            case 2: {
                return pSMIDetailBase.getInitMode();
            }
            case 3: {
                return pSMIDetailBase.getMemo();
            }
            case 4: {
                return pSMIDetailBase.getOrderValue();
            }
            case 5: {
                return pSMIDetailBase.getPSDEName();
            }
            case 6: {
                return pSMIDetailBase.getPSMIDetailId();
            }
            case 7: {
                return pSMIDetailBase.getPSMIDetailName();
            }
            case 8: {
                return pSMIDetailBase.getPSModelInitId();
            }
            case 9: {
                return pSMIDetailBase.getPSModelInitName();
            }
            case 10: {
                return pSMIDetailBase.getUpdateDate();
            }
            case 11: {
                return pSMIDetailBase.getUpdateMan();
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
        PSMIDetailBase.set(this, n, object);
    }

    private static void set(PSMIDetailBase pSMIDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMIDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMIDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMIDetailBase.setInitMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMIDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMIDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSMIDetailBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMIDetailBase.setPSMIDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMIDetailBase.setPSMIDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMIDetailBase.setPSModelInitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMIDetailBase.setPSModelInitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMIDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSMIDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSMIDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSMIDetailBase pSMIDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMIDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSMIDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSMIDetailBase.getInitMode() == null;
            }
            case 3: {
                return pSMIDetailBase.getMemo() == null;
            }
            case 4: {
                return pSMIDetailBase.getOrderValue() == null;
            }
            case 5: {
                return pSMIDetailBase.getPSDEName() == null;
            }
            case 6: {
                return pSMIDetailBase.getPSMIDetailId() == null;
            }
            case 7: {
                return pSMIDetailBase.getPSMIDetailName() == null;
            }
            case 8: {
                return pSMIDetailBase.getPSModelInitId() == null;
            }
            case 9: {
                return pSMIDetailBase.getPSModelInitName() == null;
            }
            case 10: {
                return pSMIDetailBase.getUpdateDate() == null;
            }
            case 11: {
                return pSMIDetailBase.getUpdateMan() == null;
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
        return PSMIDetailBase.contains(this, n);
    }

    private static boolean contains(PSMIDetailBase pSMIDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMIDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSMIDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSMIDetailBase.isInitModeDirty();
            }
            case 3: {
                return pSMIDetailBase.isMemoDirty();
            }
            case 4: {
                return pSMIDetailBase.isOrderValueDirty();
            }
            case 5: {
                return pSMIDetailBase.isPSDENameDirty();
            }
            case 6: {
                return pSMIDetailBase.isPSMIDetailIdDirty();
            }
            case 7: {
                return pSMIDetailBase.isPSMIDetailNameDirty();
            }
            case 8: {
                return pSMIDetailBase.isPSModelInitIdDirty();
            }
            case 9: {
                return pSMIDetailBase.isPSModelInitNameDirty();
            }
            case 10: {
                return pSMIDetailBase.isUpdateDateDirty();
            }
            case 11: {
                return pSMIDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMIDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMIDetailBase pSMIDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMIDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getInitMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initmode", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getInitMode()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getPSMIDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmidetailid", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getPSMIDetailId()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getPSMIDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmidetailname", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getPSMIDetailName()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getPSModelInitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelinitid", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getPSModelInitId()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getPSModelInitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelinitname", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getPSModelInitName()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMIDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMIDetailBase.getJSONValue((Object)pSMIDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMIDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMIDetailBase pSMIDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMIDetailBase.getCreateDate() != null) {
            object = pSMIDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMIDetailBase.getCreateMan() != null) {
            object = pSMIDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getInitMode() != null) {
            object = pSMIDetailBase.getInitMode();
            xmlNode.setAttribute(FIELD_INITMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getMemo() != null) {
            object = pSMIDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getOrderValue() != null) {
            object = pSMIDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMIDetailBase.getPSDEName() != null) {
            object = pSMIDetailBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getPSMIDetailId() != null) {
            object = pSMIDetailBase.getPSMIDetailId();
            xmlNode.setAttribute(FIELD_PSMIDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getPSMIDetailName() != null) {
            object = pSMIDetailBase.getPSMIDetailName();
            xmlNode.setAttribute(FIELD_PSMIDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getPSModelInitId() != null) {
            object = pSMIDetailBase.getPSModelInitId();
            xmlNode.setAttribute(FIELD_PSMODELINITID, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getPSModelInitName() != null) {
            object = pSMIDetailBase.getPSModelInitName();
            xmlNode.setAttribute(FIELD_PSMODELINITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMIDetailBase.getUpdateDate() != null) {
            object = pSMIDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMIDetailBase.getUpdateMan() != null) {
            object = pSMIDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMIDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMIDetailBase pSMIDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMIDetailBase.isCreateDateDirty() && (bl || pSMIDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMIDetailBase.getCreateDate());
        }
        if (pSMIDetailBase.isCreateManDirty() && (bl || pSMIDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMIDetailBase.getCreateMan());
        }
        if (pSMIDetailBase.isInitModeDirty() && (bl || pSMIDetailBase.getInitMode() != null)) {
            iDataObject.set(FIELD_INITMODE, (Object)pSMIDetailBase.getInitMode());
        }
        if (pSMIDetailBase.isMemoDirty() && (bl || pSMIDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMIDetailBase.getMemo());
        }
        if (pSMIDetailBase.isOrderValueDirty() && (bl || pSMIDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSMIDetailBase.getOrderValue());
        }
        if (pSMIDetailBase.isPSDENameDirty() && (bl || pSMIDetailBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSMIDetailBase.getPSDEName());
        }
        if (pSMIDetailBase.isPSMIDetailIdDirty() && (bl || pSMIDetailBase.getPSMIDetailId() != null)) {
            iDataObject.set(FIELD_PSMIDETAILID, (Object)pSMIDetailBase.getPSMIDetailId());
        }
        if (pSMIDetailBase.isPSMIDetailNameDirty() && (bl || pSMIDetailBase.getPSMIDetailName() != null)) {
            iDataObject.set(FIELD_PSMIDETAILNAME, (Object)pSMIDetailBase.getPSMIDetailName());
        }
        if (pSMIDetailBase.isPSModelInitIdDirty() && (bl || pSMIDetailBase.getPSModelInitId() != null)) {
            iDataObject.set(FIELD_PSMODELINITID, (Object)pSMIDetailBase.getPSModelInitId());
        }
        if (pSMIDetailBase.isPSModelInitNameDirty() && (bl || pSMIDetailBase.getPSModelInitName() != null)) {
            iDataObject.set(FIELD_PSMODELINITNAME, (Object)pSMIDetailBase.getPSModelInitName());
        }
        if (pSMIDetailBase.isUpdateDateDirty() && (bl || pSMIDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMIDetailBase.getUpdateDate());
        }
        if (pSMIDetailBase.isUpdateManDirty() && (bl || pSMIDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMIDetailBase.getUpdateMan());
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
        return PSMIDetailBase.remove(this, n);
    }

    private static boolean remove(PSMIDetailBase pSMIDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMIDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMIDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMIDetailBase.resetInitMode();
                return true;
            }
            case 3: {
                pSMIDetailBase.resetMemo();
                return true;
            }
            case 4: {
                pSMIDetailBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSMIDetailBase.resetPSDEName();
                return true;
            }
            case 6: {
                pSMIDetailBase.resetPSMIDetailId();
                return true;
            }
            case 7: {
                pSMIDetailBase.resetPSMIDetailName();
                return true;
            }
            case 8: {
                pSMIDetailBase.resetPSModelInitId();
                return true;
            }
            case 9: {
                pSMIDetailBase.resetPSModelInitName();
                return true;
            }
            case 10: {
                pSMIDetailBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSMIDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelInit getPsmodelinit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodelinit();
        }
        if (this.getPSModelInitId() == null) {
            return null;
        }
        Integer n = this.objPsmodelinitLock;
        synchronized (n) {
            if (this.psmodelinit != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelInitId(), (Object)this.psmodelinit.getPSModelInitId()) != 0L) {
                this.psmodelinit = null;
            }
            if (this.psmodelinit == null) {
                PSModelInit pSModelInit = new PSModelInit();
                pSModelInit.setPSModelInitId(this.getPSModelInitId());
                PSModelInitService pSModelInitService = (PSModelInitService)ServiceGlobal.getService(PSModelInitService.class, (SessionFactory)this.getSessionFactory());
                pSModelInitService.autoGet((IEntity)pSModelInit);
                this.psmodelinit = pSModelInit;
            }
            return this.psmodelinit;
        }
    }

    private PSMIDetailBase getProxyEntity() {
        return this.proxyPSMIDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMIDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSMIDetailBase) {
            this.proxyPSMIDetailBase = (PSMIDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSMIDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INITMODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDENAME, 5);
        fieldIndexMap.put(FIELD_PSMIDETAILID, 6);
        fieldIndexMap.put(FIELD_PSMIDETAILNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELINITID, 8);
        fieldIndexMap.put(FIELD_PSMODELINITNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

