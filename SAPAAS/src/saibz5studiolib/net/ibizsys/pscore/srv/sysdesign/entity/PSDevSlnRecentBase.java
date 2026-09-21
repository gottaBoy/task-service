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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnRecentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnRecentBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNRECENTID = "PSDEVSLNRECENTID";
    public static final String FIELD_PSDEVSLNRECENTNAME = "PSDEVSLNRECENTNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ORDERVALUE = 2;
    private static final int INDEX_PSDEVSLNID = 3;
    private static final int INDEX_PSDEVSLNNAME = 4;
    private static final int INDEX_PSDEVSLNRECENTID = 5;
    private static final int INDEX_PSDEVSLNRECENTNAME = 6;
    private static final int INDEX_PSDEVUSERID = 7;
    private static final int INDEX_PSDEVUSERNAME = 8;
    private static final int INDEX_PSOBJID = 9;
    private static final int INDEX_PSOBJNAME = 10;
    private static final int INDEX_PSOBJTYPE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnRecentBase proxyPSDevSlnRecentBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnrecentidDirtyFlag = false;
    private boolean psdevslnrecentnameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnrecentid")
    private String psdevslnrecentid;
    @Column(name="psdevslnrecentname")
    private String psdevslnrecentname;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

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

    public void setPSDevSlnRecentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnRecentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnrecentid = string;
        this.psdevslnrecentidDirtyFlag = true;
    }

    public String getPSDevSlnRecentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnRecentId();
        }
        return this.psdevslnrecentid;
    }

    public boolean isPSDevSlnRecentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnRecentIdDirty();
        }
        return this.psdevslnrecentidDirtyFlag;
    }

    public void resetPSDevSlnRecentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnRecentId();
            return;
        }
        this.psdevslnrecentidDirtyFlag = false;
        this.psdevslnrecentid = null;
    }

    public void setPSDevSlnRecentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnRecentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnrecentname = string;
        this.psdevslnrecentnameDirtyFlag = true;
    }

    public String getPSDevSlnRecentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnRecentName();
        }
        return this.psdevslnrecentname;
    }

    public boolean isPSDevSlnRecentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnRecentNameDirty();
        }
        return this.psdevslnrecentnameDirtyFlag;
    }

    public void resetPSDevSlnRecentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnRecentName();
            return;
        }
        this.psdevslnrecentnameDirtyFlag = false;
        this.psdevslnrecentname = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
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
        PSDevSlnRecentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnRecentBase pSDevSlnRecentBase) {
        pSDevSlnRecentBase.resetCreateDate();
        pSDevSlnRecentBase.resetCreateMan();
        pSDevSlnRecentBase.resetOrderValue();
        pSDevSlnRecentBase.resetPSDevSlnId();
        pSDevSlnRecentBase.resetPSDevSlnName();
        pSDevSlnRecentBase.resetPSDevSlnRecentId();
        pSDevSlnRecentBase.resetPSDevSlnRecentName();
        pSDevSlnRecentBase.resetPSDevUserId();
        pSDevSlnRecentBase.resetPSDevUserName();
        pSDevSlnRecentBase.resetPSObjId();
        pSDevSlnRecentBase.resetPSObjName();
        pSDevSlnRecentBase.resetPSObjType();
        pSDevSlnRecentBase.resetUpdateDate();
        pSDevSlnRecentBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnRecentIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNRECENTID, this.getPSDevSlnRecentId());
        }
        if (!bl || this.isPSDevSlnRecentNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNRECENTNAME, this.getPSDevSlnRecentName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
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
        return PSDevSlnRecentBase.get(this, n);
    }

    private static Object get(PSDevSlnRecentBase pSDevSlnRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnRecentBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnRecentBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnRecentBase.getOrderValue();
            }
            case 3: {
                return pSDevSlnRecentBase.getPSDevSlnId();
            }
            case 4: {
                return pSDevSlnRecentBase.getPSDevSlnName();
            }
            case 5: {
                return pSDevSlnRecentBase.getPSDevSlnRecentId();
            }
            case 6: {
                return pSDevSlnRecentBase.getPSDevSlnRecentName();
            }
            case 7: {
                return pSDevSlnRecentBase.getPSDevUserId();
            }
            case 8: {
                return pSDevSlnRecentBase.getPSDevUserName();
            }
            case 9: {
                return pSDevSlnRecentBase.getPSObjId();
            }
            case 10: {
                return pSDevSlnRecentBase.getPSObjName();
            }
            case 11: {
                return pSDevSlnRecentBase.getPSObjType();
            }
            case 12: {
                return pSDevSlnRecentBase.getUpdateDate();
            }
            case 13: {
                return pSDevSlnRecentBase.getUpdateMan();
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
        PSDevSlnRecentBase.set(this, n, object);
    }

    private static void set(PSDevSlnRecentBase pSDevSlnRecentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnRecentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnRecentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnRecentBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnRecentBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnRecentBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnRecentBase.setPSDevSlnRecentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnRecentBase.setPSDevSlnRecentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnRecentBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnRecentBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnRecentBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnRecentBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnRecentBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnRecentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnRecentBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnRecentBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnRecentBase pSDevSlnRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnRecentBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnRecentBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnRecentBase.getOrderValue() == null;
            }
            case 3: {
                return pSDevSlnRecentBase.getPSDevSlnId() == null;
            }
            case 4: {
                return pSDevSlnRecentBase.getPSDevSlnName() == null;
            }
            case 5: {
                return pSDevSlnRecentBase.getPSDevSlnRecentId() == null;
            }
            case 6: {
                return pSDevSlnRecentBase.getPSDevSlnRecentName() == null;
            }
            case 7: {
                return pSDevSlnRecentBase.getPSDevUserId() == null;
            }
            case 8: {
                return pSDevSlnRecentBase.getPSDevUserName() == null;
            }
            case 9: {
                return pSDevSlnRecentBase.getPSObjId() == null;
            }
            case 10: {
                return pSDevSlnRecentBase.getPSObjName() == null;
            }
            case 11: {
                return pSDevSlnRecentBase.getPSObjType() == null;
            }
            case 12: {
                return pSDevSlnRecentBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevSlnRecentBase.getUpdateMan() == null;
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
        return PSDevSlnRecentBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnRecentBase pSDevSlnRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnRecentBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnRecentBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnRecentBase.isOrderValueDirty();
            }
            case 3: {
                return pSDevSlnRecentBase.isPSDevSlnIdDirty();
            }
            case 4: {
                return pSDevSlnRecentBase.isPSDevSlnNameDirty();
            }
            case 5: {
                return pSDevSlnRecentBase.isPSDevSlnRecentIdDirty();
            }
            case 6: {
                return pSDevSlnRecentBase.isPSDevSlnRecentNameDirty();
            }
            case 7: {
                return pSDevSlnRecentBase.isPSDevUserIdDirty();
            }
            case 8: {
                return pSDevSlnRecentBase.isPSDevUserNameDirty();
            }
            case 9: {
                return pSDevSlnRecentBase.isPSObjIdDirty();
            }
            case 10: {
                return pSDevSlnRecentBase.isPSObjNameDirty();
            }
            case 11: {
                return pSDevSlnRecentBase.isPSObjTypeDirty();
            }
            case 12: {
                return pSDevSlnRecentBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevSlnRecentBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnRecentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnRecentBase pSDevSlnRecentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnRecentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnRecentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnrecentid", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevSlnRecentId()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnRecentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnrecentname", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevSlnRecentName()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnRecentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnRecentBase.getJSONValue((Object)pSDevSlnRecentBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnRecentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnRecentBase pSDevSlnRecentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnRecentBase.getCreateDate() != null) {
            object = pSDevSlnRecentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnRecentBase.getCreateMan() != null) {
            object = pSDevSlnRecentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getOrderValue() != null) {
            object = pSDevSlnRecentBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnId() != null) {
            object = pSDevSlnRecentBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnName() != null) {
            object = pSDevSlnRecentBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnRecentId() != null) {
            object = pSDevSlnRecentBase.getPSDevSlnRecentId();
            xmlNode.setAttribute(FIELD_PSDEVSLNRECENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSDevSlnRecentName() != null) {
            object = pSDevSlnRecentBase.getPSDevSlnRecentName();
            xmlNode.setAttribute(FIELD_PSDEVSLNRECENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSDevUserId() != null) {
            object = pSDevSlnRecentBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSDevUserName() != null) {
            object = pSDevSlnRecentBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSObjId() != null) {
            object = pSDevSlnRecentBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSObjName() != null) {
            object = pSDevSlnRecentBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getPSObjType() != null) {
            object = pSDevSlnRecentBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnRecentBase.getUpdateDate() != null) {
            object = pSDevSlnRecentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnRecentBase.getUpdateMan() != null) {
            object = pSDevSlnRecentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnRecentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnRecentBase pSDevSlnRecentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnRecentBase.isCreateDateDirty() && (bl || pSDevSlnRecentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnRecentBase.getCreateDate());
        }
        if (pSDevSlnRecentBase.isCreateManDirty() && (bl || pSDevSlnRecentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnRecentBase.getCreateMan());
        }
        if (pSDevSlnRecentBase.isOrderValueDirty() && (bl || pSDevSlnRecentBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnRecentBase.getOrderValue());
        }
        if (pSDevSlnRecentBase.isPSDevSlnIdDirty() && (bl || pSDevSlnRecentBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnRecentBase.getPSDevSlnId());
        }
        if (pSDevSlnRecentBase.isPSDevSlnNameDirty() && (bl || pSDevSlnRecentBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnRecentBase.getPSDevSlnName());
        }
        if (pSDevSlnRecentBase.isPSDevSlnRecentIdDirty() && (bl || pSDevSlnRecentBase.getPSDevSlnRecentId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRECENTID, (Object)pSDevSlnRecentBase.getPSDevSlnRecentId());
        }
        if (pSDevSlnRecentBase.isPSDevSlnRecentNameDirty() && (bl || pSDevSlnRecentBase.getPSDevSlnRecentName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRECENTNAME, (Object)pSDevSlnRecentBase.getPSDevSlnRecentName());
        }
        if (pSDevSlnRecentBase.isPSDevUserIdDirty() && (bl || pSDevSlnRecentBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevSlnRecentBase.getPSDevUserId());
        }
        if (pSDevSlnRecentBase.isPSDevUserNameDirty() && (bl || pSDevSlnRecentBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDevSlnRecentBase.getPSDevUserName());
        }
        if (pSDevSlnRecentBase.isPSObjIdDirty() && (bl || pSDevSlnRecentBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDevSlnRecentBase.getPSObjId());
        }
        if (pSDevSlnRecentBase.isPSObjNameDirty() && (bl || pSDevSlnRecentBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDevSlnRecentBase.getPSObjName());
        }
        if (pSDevSlnRecentBase.isPSObjTypeDirty() && (bl || pSDevSlnRecentBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSDevSlnRecentBase.getPSObjType());
        }
        if (pSDevSlnRecentBase.isUpdateDateDirty() && (bl || pSDevSlnRecentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnRecentBase.getUpdateDate());
        }
        if (pSDevSlnRecentBase.isUpdateManDirty() && (bl || pSDevSlnRecentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnRecentBase.getUpdateMan());
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
        return PSDevSlnRecentBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnRecentBase pSDevSlnRecentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnRecentBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnRecentBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnRecentBase.resetOrderValue();
                return true;
            }
            case 3: {
                pSDevSlnRecentBase.resetPSDevSlnId();
                return true;
            }
            case 4: {
                pSDevSlnRecentBase.resetPSDevSlnName();
                return true;
            }
            case 5: {
                pSDevSlnRecentBase.resetPSDevSlnRecentId();
                return true;
            }
            case 6: {
                pSDevSlnRecentBase.resetPSDevSlnRecentName();
                return true;
            }
            case 7: {
                pSDevSlnRecentBase.resetPSDevUserId();
                return true;
            }
            case 8: {
                pSDevSlnRecentBase.resetPSDevUserName();
                return true;
            }
            case 9: {
                pSDevSlnRecentBase.resetPSObjId();
                return true;
            }
            case 10: {
                pSDevSlnRecentBase.resetPSObjName();
                return true;
            }
            case 11: {
                pSDevSlnRecentBase.resetPSObjType();
                return true;
            }
            case 12: {
                pSDevSlnRecentBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevSlnRecentBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet((IEntity)pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDevSlnRecentBase getProxyEntity() {
        return this.proxyPSDevSlnRecentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnRecentBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnRecentBase) {
            this.proxyPSDevSlnRecentBase = (PSDevSlnRecentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnRecentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ORDERVALUE, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNRECENTID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNRECENTNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 7);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 8);
        fieldIndexMap.put(FIELD_PSOBJID, 9);
        fieldIndexMap.put(FIELD_PSOBJNAME, 10);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

