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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRODUCTSN = "PRODUCTSN";
    public static final String FIELD_PSDCSYSRESID = "PSDCSYSRESID";
    public static final String FIELD_PSDCSYSRESNAME = "PSDCSYSRESNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSVRPROVIDERNAME = "PSSVRPROVIDERNAME";
    public static final String FIELD_PSSYSPRODUCTID = "PSSYSPRODUCTID";
    public static final String FIELD_PSSYSPRODUCTNAME = "PSSYSPRODUCTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRODUCTSN = 3;
    private static final int INDEX_PSDCSYSRESID = 4;
    private static final int INDEX_PSDCSYSRESNAME = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSSVRPROVIDERNAME = 8;
    private static final int INDEX_PSSYSPRODUCTID = 9;
    private static final int INDEX_PSSYSPRODUCTNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysResBase proxyPSDCSysResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean productsnDirtyFlag = false;
    private boolean psdcsysresidDirtyFlag = false;
    private boolean psdcsysresnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssvrprovidernameDirtyFlag = false;
    private boolean pssysproductidDirtyFlag = false;
    private boolean pssysproductnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="productsn")
    private String productsn;
    @Column(name="psdcsysresid")
    private String psdcsysresid;
    @Column(name="psdcsysresname")
    private String psdcsysresname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssvrprovidername")
    private String pssvrprovidername;
    @Column(name="pssysproductid")
    private String pssysproductid;
    @Column(name="pssysproductname")
    private String pssysproductname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSysProductLock = new Integer(1);
    private PSSysProduct pssysproduct = null;

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

    public void setProductSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProductSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.productsn = string;
        this.productsnDirtyFlag = true;
    }

    public String getProductSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProductSN();
        }
        return this.productsn;
    }

    public boolean isProductSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProductSNDirty();
        }
        return this.productsnDirtyFlag;
    }

    public void resetProductSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProductSN();
            return;
        }
        this.productsnDirtyFlag = false;
        this.productsn = null;
    }

    public void setPSDCSysResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysresid = string;
        this.psdcsysresidDirtyFlag = true;
    }

    public String getPSDCSysResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysResId();
        }
        return this.psdcsysresid;
    }

    public boolean isPSDCSysResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysResIdDirty();
        }
        return this.psdcsysresidDirtyFlag;
    }

    public void resetPSDCSysResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysResId();
            return;
        }
        this.psdcsysresidDirtyFlag = false;
        this.psdcsysresid = null;
    }

    public void setPSDCSysResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysresname = string;
        this.psdcsysresnameDirtyFlag = true;
    }

    public String getPSDCSysResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysResName();
        }
        return this.psdcsysresname;
    }

    public boolean isPSDCSysResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysResNameDirty();
        }
        return this.psdcsysresnameDirtyFlag;
    }

    public void resetPSDCSysResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysResName();
            return;
        }
        this.psdcsysresnameDirtyFlag = false;
        this.psdcsysresname = null;
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

    public void setPSSvrProviderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrprovidername = string;
        this.pssvrprovidernameDirtyFlag = true;
    }

    public String getPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderName();
        }
        return this.pssvrprovidername;
    }

    public boolean isPSSvrProviderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderNameDirty();
        }
        return this.pssvrprovidernameDirtyFlag;
    }

    public void resetPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderName();
            return;
        }
        this.pssvrprovidernameDirtyFlag = false;
        this.pssvrprovidername = null;
    }

    public void setPSSysProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductid = string;
        this.pssysproductidDirtyFlag = true;
    }

    public String getPSSysProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductId();
        }
        return this.pssysproductid;
    }

    public boolean isPSSysProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductIdDirty();
        }
        return this.pssysproductidDirtyFlag;
    }

    public void resetPSSysProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductId();
            return;
        }
        this.pssysproductidDirtyFlag = false;
        this.pssysproductid = null;
    }

    public void setPSSysProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductname = string;
        this.pssysproductnameDirtyFlag = true;
    }

    public String getPSSysProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductName();
        }
        return this.pssysproductname;
    }

    public boolean isPSSysProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductNameDirty();
        }
        return this.pssysproductnameDirtyFlag;
    }

    public void resetPSSysProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductName();
            return;
        }
        this.pssysproductnameDirtyFlag = false;
        this.pssysproductname = null;
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
        PSDCSysResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysResBase pSDCSysResBase) {
        pSDCSysResBase.resetCreateDate();
        pSDCSysResBase.resetCreateMan();
        pSDCSysResBase.resetMemo();
        pSDCSysResBase.resetProductSN();
        pSDCSysResBase.resetPSDCSysResId();
        pSDCSysResBase.resetPSDCSysResName();
        pSDCSysResBase.resetPSDevCenterId();
        pSDCSysResBase.resetPSDevCenterName();
        pSDCSysResBase.resetPSSvrProviderName();
        pSDCSysResBase.resetPSSysProductId();
        pSDCSysResBase.resetPSSysProductName();
        pSDCSysResBase.resetUpdateDate();
        pSDCSysResBase.resetUpdateMan();
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
        if (!bl || this.isProductSNDirty()) {
            hashMap.put(FIELD_PRODUCTSN, this.getProductSN());
        }
        if (!bl || this.isPSDCSysResIdDirty()) {
            hashMap.put(FIELD_PSDCSYSRESID, this.getPSDCSysResId());
        }
        if (!bl || this.isPSDCSysResNameDirty()) {
            hashMap.put(FIELD_PSDCSYSRESNAME, this.getPSDCSysResName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSvrProviderNameDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERNAME, this.getPSSvrProviderName());
        }
        if (!bl || this.isPSSysProductIdDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTID, this.getPSSysProductId());
        }
        if (!bl || this.isPSSysProductNameDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTNAME, this.getPSSysProductName());
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
        return PSDCSysResBase.get(this, n);
    }

    private static Object get(PSDCSysResBase pSDCSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysResBase.getCreateDate();
            }
            case 1: {
                return pSDCSysResBase.getCreateMan();
            }
            case 2: {
                return pSDCSysResBase.getMemo();
            }
            case 3: {
                return pSDCSysResBase.getProductSN();
            }
            case 4: {
                return pSDCSysResBase.getPSDCSysResId();
            }
            case 5: {
                return pSDCSysResBase.getPSDCSysResName();
            }
            case 6: {
                return pSDCSysResBase.getPSDevCenterId();
            }
            case 7: {
                return pSDCSysResBase.getPSDevCenterName();
            }
            case 8: {
                return pSDCSysResBase.getPSSvrProviderName();
            }
            case 9: {
                return pSDCSysResBase.getPSSysProductId();
            }
            case 10: {
                return pSDCSysResBase.getPSSysProductName();
            }
            case 11: {
                return pSDCSysResBase.getUpdateDate();
            }
            case 12: {
                return pSDCSysResBase.getUpdateMan();
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
        PSDCSysResBase.set(this, n, object);
    }

    private static void set(PSDCSysResBase pSDCSysResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysResBase.setProductSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysResBase.setPSDCSysResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysResBase.setPSDCSysResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysResBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysResBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysResBase.setPSSvrProviderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysResBase.setPSSysProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysResBase.setPSSysProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCSysResBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysResBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysResBase pSDCSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysResBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSysResBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSysResBase.getMemo() == null;
            }
            case 3: {
                return pSDCSysResBase.getProductSN() == null;
            }
            case 4: {
                return pSDCSysResBase.getPSDCSysResId() == null;
            }
            case 5: {
                return pSDCSysResBase.getPSDCSysResName() == null;
            }
            case 6: {
                return pSDCSysResBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSDCSysResBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSDCSysResBase.getPSSvrProviderName() == null;
            }
            case 9: {
                return pSDCSysResBase.getPSSysProductId() == null;
            }
            case 10: {
                return pSDCSysResBase.getPSSysProductName() == null;
            }
            case 11: {
                return pSDCSysResBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCSysResBase.getUpdateMan() == null;
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
        return PSDCSysResBase.contains(this, n);
    }

    private static boolean contains(PSDCSysResBase pSDCSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysResBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSysResBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSysResBase.isMemoDirty();
            }
            case 3: {
                return pSDCSysResBase.isProductSNDirty();
            }
            case 4: {
                return pSDCSysResBase.isPSDCSysResIdDirty();
            }
            case 5: {
                return pSDCSysResBase.isPSDCSysResNameDirty();
            }
            case 6: {
                return pSDCSysResBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSDCSysResBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSDCSysResBase.isPSSvrProviderNameDirty();
            }
            case 9: {
                return pSDCSysResBase.isPSSysProductIdDirty();
            }
            case 10: {
                return pSDCSysResBase.isPSSysProductNameDirty();
            }
            case 11: {
                return pSDCSysResBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCSysResBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysResBase pSDCSysResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getProductSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"productsn", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getProductSN()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSDCSysResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysresid", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSDCSysResId()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSDCSysResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysresname", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSDCSysResName()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSSvrProviderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrprovidername", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSSvrProviderName()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSSysProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductid", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSSysProductId()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getPSSysProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductname", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getPSSysProductName()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysResBase.getJSONValue((Object)pSDCSysResBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysResBase pSDCSysResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysResBase.getCreateDate() != null) {
            object = pSDCSysResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysResBase.getCreateMan() != null) {
            object = pSDCSysResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getMemo() != null) {
            object = pSDCSysResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getProductSN() != null) {
            object = pSDCSysResBase.getProductSN();
            xmlNode.setAttribute(FIELD_PRODUCTSN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSDCSysResId() != null) {
            object = pSDCSysResBase.getPSDCSysResId();
            xmlNode.setAttribute(FIELD_PSDCSYSRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSDCSysResName() != null) {
            object = pSDCSysResBase.getPSDCSysResName();
            xmlNode.setAttribute(FIELD_PSDCSYSRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSDevCenterId() != null) {
            object = pSDCSysResBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSDevCenterName() != null) {
            object = pSDCSysResBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSSvrProviderName() != null) {
            object = pSDCSysResBase.getPSSvrProviderName();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSSysProductId() != null) {
            object = pSDCSysResBase.getPSSysProductId();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getPSSysProductName() != null) {
            object = pSDCSysResBase.getPSSysProductName();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysResBase.getUpdateDate() != null) {
            object = pSDCSysResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysResBase.getUpdateMan() != null) {
            object = pSDCSysResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysResBase pSDCSysResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysResBase.isCreateDateDirty() && (bl || pSDCSysResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysResBase.getCreateDate());
        }
        if (pSDCSysResBase.isCreateManDirty() && (bl || pSDCSysResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysResBase.getCreateMan());
        }
        if (pSDCSysResBase.isMemoDirty() && (bl || pSDCSysResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSysResBase.getMemo());
        }
        if (pSDCSysResBase.isProductSNDirty() && (bl || pSDCSysResBase.getProductSN() != null)) {
            iDataObject.set(FIELD_PRODUCTSN, (Object)pSDCSysResBase.getProductSN());
        }
        if (pSDCSysResBase.isPSDCSysResIdDirty() && (bl || pSDCSysResBase.getPSDCSysResId() != null)) {
            iDataObject.set(FIELD_PSDCSYSRESID, (Object)pSDCSysResBase.getPSDCSysResId());
        }
        if (pSDCSysResBase.isPSDCSysResNameDirty() && (bl || pSDCSysResBase.getPSDCSysResName() != null)) {
            iDataObject.set(FIELD_PSDCSYSRESNAME, (Object)pSDCSysResBase.getPSDCSysResName());
        }
        if (pSDCSysResBase.isPSDevCenterIdDirty() && (bl || pSDCSysResBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCSysResBase.getPSDevCenterId());
        }
        if (pSDCSysResBase.isPSDevCenterNameDirty() && (bl || pSDCSysResBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCSysResBase.getPSDevCenterName());
        }
        if (pSDCSysResBase.isPSSvrProviderNameDirty() && (bl || pSDCSysResBase.getPSSvrProviderName() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERNAME, (Object)pSDCSysResBase.getPSSvrProviderName());
        }
        if (pSDCSysResBase.isPSSysProductIdDirty() && (bl || pSDCSysResBase.getPSSysProductId() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTID, (Object)pSDCSysResBase.getPSSysProductId());
        }
        if (pSDCSysResBase.isPSSysProductNameDirty() && (bl || pSDCSysResBase.getPSSysProductName() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTNAME, (Object)pSDCSysResBase.getPSSysProductName());
        }
        if (pSDCSysResBase.isUpdateDateDirty() && (bl || pSDCSysResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysResBase.getUpdateDate());
        }
        if (pSDCSysResBase.isUpdateManDirty() && (bl || pSDCSysResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysResBase.getUpdateMan());
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
        return PSDCSysResBase.remove(this, n);
    }

    private static boolean remove(PSDCSysResBase pSDCSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSysResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSysResBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSysResBase.resetProductSN();
                return true;
            }
            case 4: {
                pSDCSysResBase.resetPSDCSysResId();
                return true;
            }
            case 5: {
                pSDCSysResBase.resetPSDCSysResName();
                return true;
            }
            case 6: {
                pSDCSysResBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSDCSysResBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSDCSysResBase.resetPSSvrProviderName();
                return true;
            }
            case 9: {
                pSDCSysResBase.resetPSSysProductId();
                return true;
            }
            case 10: {
                pSDCSysResBase.resetPSSysProductName();
                return true;
            }
            case 11: {
                pSDCSysResBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCSysResBase.resetUpdateMan();
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
    public PSSysProduct getPSSysProduct() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProduct();
        }
        if (this.getPSSysProductId() == null) {
            return null;
        }
        Integer n = this.objPSSysProductLock;
        synchronized (n) {
            if (this.pssysproduct != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysProductId(), (Object)this.pssysproduct.getPSSysProductId()) != 0L) {
                this.pssysproduct = null;
            }
            if (this.pssysproduct == null) {
                PSSysProduct pSSysProduct = new PSSysProduct();
                pSSysProduct.setPSSysProductId(this.getPSSysProductId());
                PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
                pSSysProductService.autoGet(pSSysProduct);
                this.pssysproduct = pSSysProduct;
            }
            return this.pssysproduct;
        }
    }

    private PSDCSysResBase getProxyEntity() {
        return this.proxyPSDCSysResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysResBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysResBase) {
            this.proxyPSDCSysResBase = (PSDCSysResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRODUCTSN, 3);
        fieldIndexMap.put(FIELD_PSDCSYSRESID, 4);
        fieldIndexMap.put(FIELD_PSDCSYSRESNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTID, 9);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

