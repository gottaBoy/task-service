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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProvider;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSProductBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSProductBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRODUCTSN = "PRODUCTSN";
    public static final String FIELD_PRODUCTSTATE = "PRODUCTSTATE";
    public static final String FIELD_PSPRODUCTID = "PSPRODUCTID";
    public static final String FIELD_PSPRODUCTNAME = "PSPRODUCTNAME";
    public static final String FIELD_PSPRODUCTTYPE = "PSPRODUCTTYPE";
    public static final String FIELD_PSSVRPROVIDERID = "PSSVRPROVIDERID";
    public static final String FIELD_PSSVRPROVIDERNAME = "PSSVRPROVIDERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRODUCTSN = 3;
    private static final int INDEX_PRODUCTSTATE = 4;
    private static final int INDEX_PSPRODUCTID = 5;
    private static final int INDEX_PSPRODUCTNAME = 6;
    private static final int INDEX_PSPRODUCTTYPE = 7;
    private static final int INDEX_PSSVRPROVIDERID = 8;
    private static final int INDEX_PSSVRPROVIDERNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSProductBase proxyPSProductBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean productsnDirtyFlag = false;
    private boolean productstateDirtyFlag = false;
    private boolean psproductidDirtyFlag = false;
    private boolean psproductnameDirtyFlag = false;
    private boolean psproducttypeDirtyFlag = false;
    private boolean pssvrprovideridDirtyFlag = false;
    private boolean pssvrprovidernameDirtyFlag = false;
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
    @Column(name="productstate")
    private String productstate;
    @Column(name="psproductid")
    private String psproductid;
    @Column(name="psproductname")
    private String psproductname;
    @Column(name="psproducttype")
    private String psproducttype;
    @Column(name="pssvrproviderid")
    private String pssvrproviderid;
    @Column(name="pssvrprovidername")
    private String pssvrprovidername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPssvrproviderLock = new Integer(1);
    private PSSvrProvider pssvrprovider = null;

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

    public void setProductState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProductState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.productstate = string;
        this.productstateDirtyFlag = true;
    }

    public String getProductState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProductState();
        }
        return this.productstate;
    }

    public boolean isProductStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProductStateDirty();
        }
        return this.productstateDirtyFlag;
    }

    public void resetProductState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProductState();
            return;
        }
        this.productstateDirtyFlag = false;
        this.productstate = null;
    }

    public void setPSProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psproductid = string;
        this.psproductidDirtyFlag = true;
    }

    public String getPSProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSProductId();
        }
        return this.psproductid;
    }

    public boolean isPSProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSProductIdDirty();
        }
        return this.psproductidDirtyFlag;
    }

    public void resetPSProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSProductId();
            return;
        }
        this.psproductidDirtyFlag = false;
        this.psproductid = null;
    }

    public void setPSProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psproductname = string;
        this.psproductnameDirtyFlag = true;
    }

    public String getPSProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSProductName();
        }
        return this.psproductname;
    }

    public boolean isPSProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSProductNameDirty();
        }
        return this.psproductnameDirtyFlag;
    }

    public void resetPSProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSProductName();
            return;
        }
        this.psproductnameDirtyFlag = false;
        this.psproductname = null;
    }

    public void setPSProductType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSProductType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psproducttype = string;
        this.psproducttypeDirtyFlag = true;
    }

    public String getPSProductType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSProductType();
        }
        return this.psproducttype;
    }

    public boolean isPSProductTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSProductTypeDirty();
        }
        return this.psproducttypeDirtyFlag;
    }

    public void resetPSProductType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSProductType();
            return;
        }
        this.psproducttypeDirtyFlag = false;
        this.psproducttype = null;
    }

    public void setPSSvrProviderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrproviderid = string;
        this.pssvrprovideridDirtyFlag = true;
    }

    public String getPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderId();
        }
        return this.pssvrproviderid;
    }

    public boolean isPSSvrProviderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderIdDirty();
        }
        return this.pssvrprovideridDirtyFlag;
    }

    public void resetPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderId();
            return;
        }
        this.pssvrprovideridDirtyFlag = false;
        this.pssvrproviderid = null;
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
        PSProductBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSProductBase pSProductBase) {
        pSProductBase.resetCreateDate();
        pSProductBase.resetCreateMan();
        pSProductBase.resetMemo();
        pSProductBase.resetProductSN();
        pSProductBase.resetProductState();
        pSProductBase.resetPSProductId();
        pSProductBase.resetPSProductName();
        pSProductBase.resetPSProductType();
        pSProductBase.resetPSSvrProviderId();
        pSProductBase.resetPSSvrProviderName();
        pSProductBase.resetUpdateDate();
        pSProductBase.resetUpdateMan();
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
        if (!bl || this.isProductStateDirty()) {
            hashMap.put(FIELD_PRODUCTSTATE, this.getProductState());
        }
        if (!bl || this.isPSProductIdDirty()) {
            hashMap.put(FIELD_PSPRODUCTID, this.getPSProductId());
        }
        if (!bl || this.isPSProductNameDirty()) {
            hashMap.put(FIELD_PSPRODUCTNAME, this.getPSProductName());
        }
        if (!bl || this.isPSProductTypeDirty()) {
            hashMap.put(FIELD_PSPRODUCTTYPE, this.getPSProductType());
        }
        if (!bl || this.isPSSvrProviderIdDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERID, this.getPSSvrProviderId());
        }
        if (!bl || this.isPSSvrProviderNameDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERNAME, this.getPSSvrProviderName());
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
        return PSProductBase.get(this, n);
    }

    private static Object get(PSProductBase pSProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductBase.getCreateDate();
            }
            case 1: {
                return pSProductBase.getCreateMan();
            }
            case 2: {
                return pSProductBase.getMemo();
            }
            case 3: {
                return pSProductBase.getProductSN();
            }
            case 4: {
                return pSProductBase.getProductState();
            }
            case 5: {
                return pSProductBase.getPSProductId();
            }
            case 6: {
                return pSProductBase.getPSProductName();
            }
            case 7: {
                return pSProductBase.getPSProductType();
            }
            case 8: {
                return pSProductBase.getPSSvrProviderId();
            }
            case 9: {
                return pSProductBase.getPSSvrProviderName();
            }
            case 10: {
                return pSProductBase.getUpdateDate();
            }
            case 11: {
                return pSProductBase.getUpdateMan();
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
        PSProductBase.set(this, n, object);
    }

    private static void set(PSProductBase pSProductBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSProductBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSProductBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSProductBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSProductBase.setProductSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSProductBase.setProductState(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSProductBase.setPSProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSProductBase.setPSProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSProductBase.setPSProductType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSProductBase.setPSSvrProviderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSProductBase.setPSSvrProviderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSProductBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSProductBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSProductBase.isNull(this, n);
    }

    private static boolean isNull(PSProductBase pSProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductBase.getCreateDate() == null;
            }
            case 1: {
                return pSProductBase.getCreateMan() == null;
            }
            case 2: {
                return pSProductBase.getMemo() == null;
            }
            case 3: {
                return pSProductBase.getProductSN() == null;
            }
            case 4: {
                return pSProductBase.getProductState() == null;
            }
            case 5: {
                return pSProductBase.getPSProductId() == null;
            }
            case 6: {
                return pSProductBase.getPSProductName() == null;
            }
            case 7: {
                return pSProductBase.getPSProductType() == null;
            }
            case 8: {
                return pSProductBase.getPSSvrProviderId() == null;
            }
            case 9: {
                return pSProductBase.getPSSvrProviderName() == null;
            }
            case 10: {
                return pSProductBase.getUpdateDate() == null;
            }
            case 11: {
                return pSProductBase.getUpdateMan() == null;
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
        return PSProductBase.contains(this, n);
    }

    private static boolean contains(PSProductBase pSProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductBase.isCreateDateDirty();
            }
            case 1: {
                return pSProductBase.isCreateManDirty();
            }
            case 2: {
                return pSProductBase.isMemoDirty();
            }
            case 3: {
                return pSProductBase.isProductSNDirty();
            }
            case 4: {
                return pSProductBase.isProductStateDirty();
            }
            case 5: {
                return pSProductBase.isPSProductIdDirty();
            }
            case 6: {
                return pSProductBase.isPSProductNameDirty();
            }
            case 7: {
                return pSProductBase.isPSProductTypeDirty();
            }
            case 8: {
                return pSProductBase.isPSSvrProviderIdDirty();
            }
            case 9: {
                return pSProductBase.isPSSvrProviderNameDirty();
            }
            case 10: {
                return pSProductBase.isUpdateDateDirty();
            }
            case 11: {
                return pSProductBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSProductBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSProductBase pSProductBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSProductBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSProductBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSProductBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getMemo()), (boolean)false);
        }
        if (bl || pSProductBase.getProductSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"productsn", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getProductSN()), (boolean)false);
        }
        if (bl || pSProductBase.getProductState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"productstate", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getProductState()), (boolean)false);
        }
        if (bl || pSProductBase.getPSProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psproductid", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getPSProductId()), (boolean)false);
        }
        if (bl || pSProductBase.getPSProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psproductname", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getPSProductName()), (boolean)false);
        }
        if (bl || pSProductBase.getPSProductType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psproducttype", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getPSProductType()), (boolean)false);
        }
        if (bl || pSProductBase.getPSSvrProviderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrproviderid", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getPSSvrProviderId()), (boolean)false);
        }
        if (bl || pSProductBase.getPSSvrProviderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrprovidername", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getPSSvrProviderName()), (boolean)false);
        }
        if (bl || pSProductBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSProductBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSProductBase.getJSONValue((Object)pSProductBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSProductBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSProductBase pSProductBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSProductBase.getCreateDate() != null) {
            object = pSProductBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSProductBase.getCreateMan() != null) {
            object = pSProductBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getMemo() != null) {
            object = pSProductBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getProductSN() != null) {
            object = pSProductBase.getProductSN();
            xmlNode.setAttribute(FIELD_PRODUCTSN, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getProductState() != null) {
            object = pSProductBase.getProductState();
            xmlNode.setAttribute(FIELD_PRODUCTSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getPSProductId() != null) {
            object = pSProductBase.getPSProductId();
            xmlNode.setAttribute(FIELD_PSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getPSProductName() != null) {
            object = pSProductBase.getPSProductName();
            xmlNode.setAttribute(FIELD_PSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getPSProductType() != null) {
            object = pSProductBase.getPSProductType();
            xmlNode.setAttribute(FIELD_PSPRODUCTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getPSSvrProviderId() != null) {
            object = pSProductBase.getPSSvrProviderId();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERID, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getPSSvrProviderName() != null) {
            object = pSProductBase.getPSSvrProviderName();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSProductBase.getUpdateDate() != null) {
            object = pSProductBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSProductBase.getUpdateMan() != null) {
            object = pSProductBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSProductBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSProductBase pSProductBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSProductBase.isCreateDateDirty() && (bl || pSProductBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSProductBase.getCreateDate());
        }
        if (pSProductBase.isCreateManDirty() && (bl || pSProductBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSProductBase.getCreateMan());
        }
        if (pSProductBase.isMemoDirty() && (bl || pSProductBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSProductBase.getMemo());
        }
        if (pSProductBase.isProductSNDirty() && (bl || pSProductBase.getProductSN() != null)) {
            iDataObject.set(FIELD_PRODUCTSN, (Object)pSProductBase.getProductSN());
        }
        if (pSProductBase.isProductStateDirty() && (bl || pSProductBase.getProductState() != null)) {
            iDataObject.set(FIELD_PRODUCTSTATE, (Object)pSProductBase.getProductState());
        }
        if (pSProductBase.isPSProductIdDirty() && (bl || pSProductBase.getPSProductId() != null)) {
            iDataObject.set(FIELD_PSPRODUCTID, (Object)pSProductBase.getPSProductId());
        }
        if (pSProductBase.isPSProductNameDirty() && (bl || pSProductBase.getPSProductName() != null)) {
            iDataObject.set(FIELD_PSPRODUCTNAME, (Object)pSProductBase.getPSProductName());
        }
        if (pSProductBase.isPSProductTypeDirty() && (bl || pSProductBase.getPSProductType() != null)) {
            iDataObject.set(FIELD_PSPRODUCTTYPE, (Object)pSProductBase.getPSProductType());
        }
        if (pSProductBase.isPSSvrProviderIdDirty() && (bl || pSProductBase.getPSSvrProviderId() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERID, (Object)pSProductBase.getPSSvrProviderId());
        }
        if (pSProductBase.isPSSvrProviderNameDirty() && (bl || pSProductBase.getPSSvrProviderName() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERNAME, (Object)pSProductBase.getPSSvrProviderName());
        }
        if (pSProductBase.isUpdateDateDirty() && (bl || pSProductBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSProductBase.getUpdateDate());
        }
        if (pSProductBase.isUpdateManDirty() && (bl || pSProductBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSProductBase.getUpdateMan());
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
        return PSProductBase.remove(this, n);
    }

    private static boolean remove(PSProductBase pSProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSProductBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSProductBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSProductBase.resetMemo();
                return true;
            }
            case 3: {
                pSProductBase.resetProductSN();
                return true;
            }
            case 4: {
                pSProductBase.resetProductState();
                return true;
            }
            case 5: {
                pSProductBase.resetPSProductId();
                return true;
            }
            case 6: {
                pSProductBase.resetPSProductName();
                return true;
            }
            case 7: {
                pSProductBase.resetPSProductType();
                return true;
            }
            case 8: {
                pSProductBase.resetPSSvrProviderId();
                return true;
            }
            case 9: {
                pSProductBase.resetPSSvrProviderName();
                return true;
            }
            case 10: {
                pSProductBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSProductBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrProvider getPssvrprovider() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssvrprovider();
        }
        if (this.getPSSvrProviderId() == null) {
            return null;
        }
        Integer n = this.objPssvrproviderLock;
        synchronized (n) {
            if (this.pssvrprovider != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrProviderId(), (Object)this.pssvrprovider.getPSSvrProviderId()) != 0L) {
                this.pssvrprovider = null;
            }
            if (this.pssvrprovider == null) {
                PSSvrProvider pSSvrProvider = new PSSvrProvider();
                pSSvrProvider.setPSSvrProviderId(this.getPSSvrProviderId());
                PSSvrProviderService pSSvrProviderService = (PSSvrProviderService)ServiceGlobal.getService(PSSvrProviderService.class, (SessionFactory)this.getSessionFactory());
                pSSvrProviderService.autoGet((IEntity)pSSvrProvider);
                this.pssvrprovider = pSSvrProvider;
            }
            return this.pssvrprovider;
        }
    }

    private PSProductBase getProxyEntity() {
        return this.proxyPSProductBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSProductBase = null;
        if (iDataObject != null && iDataObject instanceof PSProductBase) {
            this.proxyPSProductBase = (PSProductBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSProductService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRODUCTSN, 3);
        fieldIndexMap.put(FIELD_PRODUCTSTATE, 4);
        fieldIndexMap.put(FIELD_PSPRODUCTID, 5);
        fieldIndexMap.put(FIELD_PSPRODUCTNAME, 6);
        fieldIndexMap.put(FIELD_PSPRODUCTTYPE, 7);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERID, 8);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

