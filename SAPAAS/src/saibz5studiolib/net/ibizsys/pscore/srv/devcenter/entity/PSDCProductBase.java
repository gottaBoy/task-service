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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCProductBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCProductBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRODUCTSN = "PRODUCTSN";
    public static final String FIELD_PRODUCTSTATE = "PRODUCTSTATE";
    public static final String FIELD_PSDCPRODUCTID = "PSDCPRODUCTID";
    public static final String FIELD_PSDCPRODUCTNAME = "PSDCPRODUCTNAME";
    public static final String FIELD_PSDCPRODUCTTYPE = "PSDCPRODUCTTYPE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRODUCTSN = 3;
    private static final int INDEX_PRODUCTSTATE = 4;
    private static final int INDEX_PSDCPRODUCTID = 5;
    private static final int INDEX_PSDCPRODUCTNAME = 6;
    private static final int INDEX_PSDCPRODUCTTYPE = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCProductBase proxyPSDCProductBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean productsnDirtyFlag = false;
    private boolean productstateDirtyFlag = false;
    private boolean psdcproductidDirtyFlag = false;
    private boolean psdcproductnameDirtyFlag = false;
    private boolean psdcproducttypeDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
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
    @Column(name="psdcproductid")
    private String psdcproductid;
    @Column(name="psdcproductname")
    private String psdcproductname;
    @Column(name="psdcproducttype")
    private String psdcproducttype;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setPSDCProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcproductid = string;
        this.psdcproductidDirtyFlag = true;
    }

    public String getPSDCProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCProductId();
        }
        return this.psdcproductid;
    }

    public boolean isPSDCProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCProductIdDirty();
        }
        return this.psdcproductidDirtyFlag;
    }

    public void resetPSDCProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCProductId();
            return;
        }
        this.psdcproductidDirtyFlag = false;
        this.psdcproductid = null;
    }

    public void setPSDCProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcproductname = string;
        this.psdcproductnameDirtyFlag = true;
    }

    public String getPSDCProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCProductName();
        }
        return this.psdcproductname;
    }

    public boolean isPSDCProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCProductNameDirty();
        }
        return this.psdcproductnameDirtyFlag;
    }

    public void resetPSDCProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCProductName();
            return;
        }
        this.psdcproductnameDirtyFlag = false;
        this.psdcproductname = null;
    }

    public void setPSDCProductType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCProductType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcproducttype = string;
        this.psdcproducttypeDirtyFlag = true;
    }

    public String getPSDCProductType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCProductType();
        }
        return this.psdcproducttype;
    }

    public boolean isPSDCProductTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCProductTypeDirty();
        }
        return this.psdcproducttypeDirtyFlag;
    }

    public void resetPSDCProductType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCProductType();
            return;
        }
        this.psdcproducttypeDirtyFlag = false;
        this.psdcproducttype = null;
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
        PSDCProductBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCProductBase pSDCProductBase) {
        pSDCProductBase.resetCreateDate();
        pSDCProductBase.resetCreateMan();
        pSDCProductBase.resetMemo();
        pSDCProductBase.resetProductSN();
        pSDCProductBase.resetProductState();
        pSDCProductBase.resetPSDCProductId();
        pSDCProductBase.resetPSDCProductName();
        pSDCProductBase.resetPSDCProductType();
        pSDCProductBase.resetPSDevCenterId();
        pSDCProductBase.resetPSDevCenterName();
        pSDCProductBase.resetUpdateDate();
        pSDCProductBase.resetUpdateMan();
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
        if (!bl || this.isPSDCProductIdDirty()) {
            hashMap.put(FIELD_PSDCPRODUCTID, this.getPSDCProductId());
        }
        if (!bl || this.isPSDCProductNameDirty()) {
            hashMap.put(FIELD_PSDCPRODUCTNAME, this.getPSDCProductName());
        }
        if (!bl || this.isPSDCProductTypeDirty()) {
            hashMap.put(FIELD_PSDCPRODUCTTYPE, this.getPSDCProductType());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        return PSDCProductBase.get(this, n);
    }

    private static Object get(PSDCProductBase pSDCProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCProductBase.getCreateDate();
            }
            case 1: {
                return pSDCProductBase.getCreateMan();
            }
            case 2: {
                return pSDCProductBase.getMemo();
            }
            case 3: {
                return pSDCProductBase.getProductSN();
            }
            case 4: {
                return pSDCProductBase.getProductState();
            }
            case 5: {
                return pSDCProductBase.getPSDCProductId();
            }
            case 6: {
                return pSDCProductBase.getPSDCProductName();
            }
            case 7: {
                return pSDCProductBase.getPSDCProductType();
            }
            case 8: {
                return pSDCProductBase.getPSDevCenterId();
            }
            case 9: {
                return pSDCProductBase.getPSDevCenterName();
            }
            case 10: {
                return pSDCProductBase.getUpdateDate();
            }
            case 11: {
                return pSDCProductBase.getUpdateMan();
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
        PSDCProductBase.set(this, n, object);
    }

    private static void set(PSDCProductBase pSDCProductBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCProductBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCProductBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCProductBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCProductBase.setProductSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCProductBase.setProductState(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCProductBase.setPSDCProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCProductBase.setPSDCProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCProductBase.setPSDCProductType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCProductBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCProductBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCProductBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCProductBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCProductBase.isNull(this, n);
    }

    private static boolean isNull(PSDCProductBase pSDCProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCProductBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCProductBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCProductBase.getMemo() == null;
            }
            case 3: {
                return pSDCProductBase.getProductSN() == null;
            }
            case 4: {
                return pSDCProductBase.getProductState() == null;
            }
            case 5: {
                return pSDCProductBase.getPSDCProductId() == null;
            }
            case 6: {
                return pSDCProductBase.getPSDCProductName() == null;
            }
            case 7: {
                return pSDCProductBase.getPSDCProductType() == null;
            }
            case 8: {
                return pSDCProductBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCProductBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCProductBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDCProductBase.getUpdateMan() == null;
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
        return PSDCProductBase.contains(this, n);
    }

    private static boolean contains(PSDCProductBase pSDCProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCProductBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCProductBase.isCreateManDirty();
            }
            case 2: {
                return pSDCProductBase.isMemoDirty();
            }
            case 3: {
                return pSDCProductBase.isProductSNDirty();
            }
            case 4: {
                return pSDCProductBase.isProductStateDirty();
            }
            case 5: {
                return pSDCProductBase.isPSDCProductIdDirty();
            }
            case 6: {
                return pSDCProductBase.isPSDCProductNameDirty();
            }
            case 7: {
                return pSDCProductBase.isPSDCProductTypeDirty();
            }
            case 8: {
                return pSDCProductBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCProductBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCProductBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDCProductBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCProductBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCProductBase pSDCProductBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCProductBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCProductBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCProductBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCProductBase.getProductSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"productsn", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getProductSN()), (boolean)false);
        }
        if (bl || pSDCProductBase.getProductState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"productstate", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getProductState()), (boolean)false);
        }
        if (bl || pSDCProductBase.getPSDCProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcproductid", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getPSDCProductId()), (boolean)false);
        }
        if (bl || pSDCProductBase.getPSDCProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcproductname", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getPSDCProductName()), (boolean)false);
        }
        if (bl || pSDCProductBase.getPSDCProductType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcproducttype", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getPSDCProductType()), (boolean)false);
        }
        if (bl || pSDCProductBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCProductBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCProductBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCProductBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCProductBase.getJSONValue((Object)pSDCProductBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCProductBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCProductBase pSDCProductBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCProductBase.getCreateDate() != null) {
            object = pSDCProductBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCProductBase.getCreateMan() != null) {
            object = pSDCProductBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getMemo() != null) {
            object = pSDCProductBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getProductSN() != null) {
            object = pSDCProductBase.getProductSN();
            xmlNode.setAttribute(FIELD_PRODUCTSN, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getProductState() != null) {
            object = pSDCProductBase.getProductState();
            xmlNode.setAttribute(FIELD_PRODUCTSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getPSDCProductId() != null) {
            object = pSDCProductBase.getPSDCProductId();
            xmlNode.setAttribute(FIELD_PSDCPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getPSDCProductName() != null) {
            object = pSDCProductBase.getPSDCProductName();
            xmlNode.setAttribute(FIELD_PSDCPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getPSDCProductType() != null) {
            object = pSDCProductBase.getPSDCProductType();
            xmlNode.setAttribute(FIELD_PSDCPRODUCTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getPSDevCenterId() != null) {
            object = pSDCProductBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getPSDevCenterName() != null) {
            object = pSDCProductBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCProductBase.getUpdateDate() != null) {
            object = pSDCProductBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCProductBase.getUpdateMan() != null) {
            object = pSDCProductBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCProductBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCProductBase pSDCProductBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCProductBase.isCreateDateDirty() && (bl || pSDCProductBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCProductBase.getCreateDate());
        }
        if (pSDCProductBase.isCreateManDirty() && (bl || pSDCProductBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCProductBase.getCreateMan());
        }
        if (pSDCProductBase.isMemoDirty() && (bl || pSDCProductBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCProductBase.getMemo());
        }
        if (pSDCProductBase.isProductSNDirty() && (bl || pSDCProductBase.getProductSN() != null)) {
            iDataObject.set(FIELD_PRODUCTSN, (Object)pSDCProductBase.getProductSN());
        }
        if (pSDCProductBase.isProductStateDirty() && (bl || pSDCProductBase.getProductState() != null)) {
            iDataObject.set(FIELD_PRODUCTSTATE, (Object)pSDCProductBase.getProductState());
        }
        if (pSDCProductBase.isPSDCProductIdDirty() && (bl || pSDCProductBase.getPSDCProductId() != null)) {
            iDataObject.set(FIELD_PSDCPRODUCTID, (Object)pSDCProductBase.getPSDCProductId());
        }
        if (pSDCProductBase.isPSDCProductNameDirty() && (bl || pSDCProductBase.getPSDCProductName() != null)) {
            iDataObject.set(FIELD_PSDCPRODUCTNAME, (Object)pSDCProductBase.getPSDCProductName());
        }
        if (pSDCProductBase.isPSDCProductTypeDirty() && (bl || pSDCProductBase.getPSDCProductType() != null)) {
            iDataObject.set(FIELD_PSDCPRODUCTTYPE, (Object)pSDCProductBase.getPSDCProductType());
        }
        if (pSDCProductBase.isPSDevCenterIdDirty() && (bl || pSDCProductBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCProductBase.getPSDevCenterId());
        }
        if (pSDCProductBase.isPSDevCenterNameDirty() && (bl || pSDCProductBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCProductBase.getPSDevCenterName());
        }
        if (pSDCProductBase.isUpdateDateDirty() && (bl || pSDCProductBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCProductBase.getUpdateDate());
        }
        if (pSDCProductBase.isUpdateManDirty() && (bl || pSDCProductBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCProductBase.getUpdateMan());
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
        return PSDCProductBase.remove(this, n);
    }

    private static boolean remove(PSDCProductBase pSDCProductBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCProductBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCProductBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCProductBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCProductBase.resetProductSN();
                return true;
            }
            case 4: {
                pSDCProductBase.resetProductState();
                return true;
            }
            case 5: {
                pSDCProductBase.resetPSDCProductId();
                return true;
            }
            case 6: {
                pSDCProductBase.resetPSDCProductName();
                return true;
            }
            case 7: {
                pSDCProductBase.resetPSDCProductType();
                return true;
            }
            case 8: {
                pSDCProductBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCProductBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCProductBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDCProductBase.resetUpdateMan();
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

    private PSDCProductBase getProxyEntity() {
        return this.proxyPSDCProductBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCProductBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCProductBase) {
            this.proxyPSDCProductBase = (PSDCProductBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCProductService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRODUCTSN, 3);
        fieldIndexMap.put(FIELD_PRODUCTSTATE, 4);
        fieldIndexMap.put(FIELD_PSDCPRODUCTID, 5);
        fieldIndexMap.put(FIELD_PSDCPRODUCTNAME, 6);
        fieldIndexMap.put(FIELD_PSDCPRODUCTTYPE, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

