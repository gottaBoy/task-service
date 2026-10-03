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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysProduct;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysProductService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysPrdVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSysPrdVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRDVERSTATE = "PRDVERSTATE";
    public static final String FIELD_PSDCSYSPRDVERID = "PSDCSYSPRDVERID";
    public static final String FIELD_PSDCSYSPRDVERNAME = "PSDCSYSPRDVERNAME";
    public static final String FIELD_PSDCSYSPRODUCTID = "PSDCSYSPRODUCTID";
    public static final String FIELD_PSDCSYSPRODUCTNAME = "PSDCSYSPRODUCTNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRDVERSTATE = 3;
    private static final int INDEX_PSDCSYSPRDVERID = 4;
    private static final int INDEX_PSDCSYSPRDVERNAME = 5;
    private static final int INDEX_PSDCSYSPRODUCTID = 6;
    private static final int INDEX_PSDCSYSPRODUCTNAME = 7;
    private static final int INDEX_PSSYSTEMID = 8;
    private static final int INDEX_PSSYSTEMNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSysPrdVerBase proxyPSDCSysPrdVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prdverstateDirtyFlag = false;
    private boolean psdcsysprdveridDirtyFlag = false;
    private boolean psdcsysprdvernameDirtyFlag = false;
    private boolean psdcsysproductidDirtyFlag = false;
    private boolean psdcsysproductnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="prdverstate")
    private String prdverstate;
    @Column(name="psdcsysprdverid")
    private String psdcsysprdverid;
    @Column(name="psdcsysprdvername")
    private String psdcsysprdvername;
    @Column(name="psdcsysproductid")
    private String psdcsysproductid;
    @Column(name="psdcsysproductname")
    private String psdcsysproductname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCSysProductLock = new Integer(1);
    private PSDCSysProduct psdcsysproduct = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPrdVerState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdVerState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdverstate = string;
        this.prdverstateDirtyFlag = true;
    }

    public String getPrdVerState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdVerState();
        }
        return this.prdverstate;
    }

    public boolean isPrdVerStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdVerStateDirty();
        }
        return this.prdverstateDirtyFlag;
    }

    public void resetPrdVerState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdVerState();
            return;
        }
        this.prdverstateDirtyFlag = false;
        this.prdverstate = null;
    }

    public void setPSDCSysPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysprdverid = string;
        this.psdcsysprdveridDirtyFlag = true;
    }

    public String getPSDCSysPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysPrdVerId();
        }
        return this.psdcsysprdverid;
    }

    public boolean isPSDCSysPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysPrdVerIdDirty();
        }
        return this.psdcsysprdveridDirtyFlag;
    }

    public void resetPSDCSysPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysPrdVerId();
            return;
        }
        this.psdcsysprdveridDirtyFlag = false;
        this.psdcsysprdverid = null;
    }

    public void setPSDCSysPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysprdvername = string;
        this.psdcsysprdvernameDirtyFlag = true;
    }

    public String getPSDCSysPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysPrdVerName();
        }
        return this.psdcsysprdvername;
    }

    public boolean isPSDCSysPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysPrdVerNameDirty();
        }
        return this.psdcsysprdvernameDirtyFlag;
    }

    public void resetPSDCSysPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysPrdVerName();
            return;
        }
        this.psdcsysprdvernameDirtyFlag = false;
        this.psdcsysprdvername = null;
    }

    public void setPSDCSysProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysproductid = string;
        this.psdcsysproductidDirtyFlag = true;
    }

    public String getPSDCSysProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysProductId();
        }
        return this.psdcsysproductid;
    }

    public boolean isPSDCSysProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysProductIdDirty();
        }
        return this.psdcsysproductidDirtyFlag;
    }

    public void resetPSDCSysProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysProductId();
            return;
        }
        this.psdcsysproductidDirtyFlag = false;
        this.psdcsysproductid = null;
    }

    public void setPSDCSysProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysproductname = string;
        this.psdcsysproductnameDirtyFlag = true;
    }

    public String getPSDCSysProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysProductName();
        }
        return this.psdcsysproductname;
    }

    public boolean isPSDCSysProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysProductNameDirty();
        }
        return this.psdcsysproductnameDirtyFlag;
    }

    public void resetPSDCSysProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysProductName();
            return;
        }
        this.psdcsysproductnameDirtyFlag = false;
        this.psdcsysproductname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSDCSysPrdVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSysPrdVerBase pSDCSysPrdVerBase) {
        pSDCSysPrdVerBase.resetCreateDate();
        pSDCSysPrdVerBase.resetCreateMan();
        pSDCSysPrdVerBase.resetMemo();
        pSDCSysPrdVerBase.resetPrdVerState();
        pSDCSysPrdVerBase.resetPSDCSysPrdVerId();
        pSDCSysPrdVerBase.resetPSDCSysPrdVerName();
        pSDCSysPrdVerBase.resetPSDCSysProductId();
        pSDCSysPrdVerBase.resetPSDCSysProductName();
        pSDCSysPrdVerBase.resetPSSystemId();
        pSDCSysPrdVerBase.resetPSSystemName();
        pSDCSysPrdVerBase.resetUpdateDate();
        pSDCSysPrdVerBase.resetUpdateMan();
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
        if (!bl || this.isPrdVerStateDirty()) {
            hashMap.put(FIELD_PRDVERSTATE, this.getPrdVerState());
        }
        if (!bl || this.isPSDCSysPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDCSYSPRDVERID, this.getPSDCSysPrdVerId());
        }
        if (!bl || this.isPSDCSysPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDCSYSPRDVERNAME, this.getPSDCSysPrdVerName());
        }
        if (!bl || this.isPSDCSysProductIdDirty()) {
            hashMap.put(FIELD_PSDCSYSPRODUCTID, this.getPSDCSysProductId());
        }
        if (!bl || this.isPSDCSysProductNameDirty()) {
            hashMap.put(FIELD_PSDCSYSPRODUCTNAME, this.getPSDCSysProductName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSDCSysPrdVerBase.get(this, n);
    }

    private static Object get(PSDCSysPrdVerBase pSDCSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysPrdVerBase.getCreateDate();
            }
            case 1: {
                return pSDCSysPrdVerBase.getCreateMan();
            }
            case 2: {
                return pSDCSysPrdVerBase.getMemo();
            }
            case 3: {
                return pSDCSysPrdVerBase.getPrdVerState();
            }
            case 4: {
                return pSDCSysPrdVerBase.getPSDCSysPrdVerId();
            }
            case 5: {
                return pSDCSysPrdVerBase.getPSDCSysPrdVerName();
            }
            case 6: {
                return pSDCSysPrdVerBase.getPSDCSysProductId();
            }
            case 7: {
                return pSDCSysPrdVerBase.getPSDCSysProductName();
            }
            case 8: {
                return pSDCSysPrdVerBase.getPSSystemId();
            }
            case 9: {
                return pSDCSysPrdVerBase.getPSSystemName();
            }
            case 10: {
                return pSDCSysPrdVerBase.getUpdateDate();
            }
            case 11: {
                return pSDCSysPrdVerBase.getUpdateMan();
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
        PSDCSysPrdVerBase.set(this, n, object);
    }

    private static void set(PSDCSysPrdVerBase pSDCSysPrdVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysPrdVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSysPrdVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSysPrdVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSysPrdVerBase.setPrdVerState(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSysPrdVerBase.setPSDCSysPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSysPrdVerBase.setPSDCSysPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSysPrdVerBase.setPSDCSysProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSysPrdVerBase.setPSDCSysProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSysPrdVerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSysPrdVerBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSysPrdVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCSysPrdVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCSysPrdVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSysPrdVerBase pSDCSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysPrdVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSysPrdVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSysPrdVerBase.getMemo() == null;
            }
            case 3: {
                return pSDCSysPrdVerBase.getPrdVerState() == null;
            }
            case 4: {
                return pSDCSysPrdVerBase.getPSDCSysPrdVerId() == null;
            }
            case 5: {
                return pSDCSysPrdVerBase.getPSDCSysPrdVerName() == null;
            }
            case 6: {
                return pSDCSysPrdVerBase.getPSDCSysProductId() == null;
            }
            case 7: {
                return pSDCSysPrdVerBase.getPSDCSysProductName() == null;
            }
            case 8: {
                return pSDCSysPrdVerBase.getPSSystemId() == null;
            }
            case 9: {
                return pSDCSysPrdVerBase.getPSSystemName() == null;
            }
            case 10: {
                return pSDCSysPrdVerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDCSysPrdVerBase.getUpdateMan() == null;
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
        return PSDCSysPrdVerBase.contains(this, n);
    }

    private static boolean contains(PSDCSysPrdVerBase pSDCSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSysPrdVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSysPrdVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSysPrdVerBase.isMemoDirty();
            }
            case 3: {
                return pSDCSysPrdVerBase.isPrdVerStateDirty();
            }
            case 4: {
                return pSDCSysPrdVerBase.isPSDCSysPrdVerIdDirty();
            }
            case 5: {
                return pSDCSysPrdVerBase.isPSDCSysPrdVerNameDirty();
            }
            case 6: {
                return pSDCSysPrdVerBase.isPSDCSysProductIdDirty();
            }
            case 7: {
                return pSDCSysPrdVerBase.isPSDCSysProductNameDirty();
            }
            case 8: {
                return pSDCSysPrdVerBase.isPSSystemIdDirty();
            }
            case 9: {
                return pSDCSysPrdVerBase.isPSSystemNameDirty();
            }
            case 10: {
                return pSDCSysPrdVerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDCSysPrdVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSysPrdVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSysPrdVerBase pSDCSysPrdVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSysPrdVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPrdVerState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdverstate", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPrdVerState()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysprdverid", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSDCSysPrdVerId()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysprdvername", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSDCSysPrdVerName()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysproductid", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSDCSysProductId()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysproductname", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSDCSysProductName()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSysPrdVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSysPrdVerBase.getJSONValue((Object)pSDCSysPrdVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSysPrdVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSysPrdVerBase pSDCSysPrdVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSysPrdVerBase.getCreateDate() != null) {
            object = pSDCSysPrdVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysPrdVerBase.getCreateMan() != null) {
            object = pSDCSysPrdVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getMemo() != null) {
            object = pSDCSysPrdVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPrdVerState() != null) {
            object = pSDCSysPrdVerBase.getPrdVerState();
            xmlNode.setAttribute(FIELD_PRDVERSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerId() != null) {
            object = pSDCSysPrdVerBase.getPSDCSysPrdVerId();
            xmlNode.setAttribute(FIELD_PSDCSYSPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerName() != null) {
            object = pSDCSysPrdVerBase.getPSDCSysPrdVerName();
            xmlNode.setAttribute(FIELD_PSDCSYSPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysProductId() != null) {
            object = pSDCSysPrdVerBase.getPSDCSysProductId();
            xmlNode.setAttribute(FIELD_PSDCSYSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSDCSysProductName() != null) {
            object = pSDCSysPrdVerBase.getPSDCSysProductName();
            xmlNode.setAttribute(FIELD_PSDCSYSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSSystemId() != null) {
            object = pSDCSysPrdVerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getPSSystemName() != null) {
            object = pSDCSysPrdVerBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSysPrdVerBase.getUpdateDate() != null) {
            object = pSDCSysPrdVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSysPrdVerBase.getUpdateMan() != null) {
            object = pSDCSysPrdVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSysPrdVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSysPrdVerBase pSDCSysPrdVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSysPrdVerBase.isCreateDateDirty() && (bl || pSDCSysPrdVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSysPrdVerBase.getCreateDate());
        }
        if (pSDCSysPrdVerBase.isCreateManDirty() && (bl || pSDCSysPrdVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSysPrdVerBase.getCreateMan());
        }
        if (pSDCSysPrdVerBase.isMemoDirty() && (bl || pSDCSysPrdVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSysPrdVerBase.getMemo());
        }
        if (pSDCSysPrdVerBase.isPrdVerStateDirty() && (bl || pSDCSysPrdVerBase.getPrdVerState() != null)) {
            iDataObject.set(FIELD_PRDVERSTATE, (Object)pSDCSysPrdVerBase.getPrdVerState());
        }
        if (pSDCSysPrdVerBase.isPSDCSysPrdVerIdDirty() && (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRDVERID, (Object)pSDCSysPrdVerBase.getPSDCSysPrdVerId());
        }
        if (pSDCSysPrdVerBase.isPSDCSysPrdVerNameDirty() && (bl || pSDCSysPrdVerBase.getPSDCSysPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRDVERNAME, (Object)pSDCSysPrdVerBase.getPSDCSysPrdVerName());
        }
        if (pSDCSysPrdVerBase.isPSDCSysProductIdDirty() && (bl || pSDCSysPrdVerBase.getPSDCSysProductId() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRODUCTID, (Object)pSDCSysPrdVerBase.getPSDCSysProductId());
        }
        if (pSDCSysPrdVerBase.isPSDCSysProductNameDirty() && (bl || pSDCSysPrdVerBase.getPSDCSysProductName() != null)) {
            iDataObject.set(FIELD_PSDCSYSPRODUCTNAME, (Object)pSDCSysPrdVerBase.getPSDCSysProductName());
        }
        if (pSDCSysPrdVerBase.isPSSystemIdDirty() && (bl || pSDCSysPrdVerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDCSysPrdVerBase.getPSSystemId());
        }
        if (pSDCSysPrdVerBase.isPSSystemNameDirty() && (bl || pSDCSysPrdVerBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDCSysPrdVerBase.getPSSystemName());
        }
        if (pSDCSysPrdVerBase.isUpdateDateDirty() && (bl || pSDCSysPrdVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSysPrdVerBase.getUpdateDate());
        }
        if (pSDCSysPrdVerBase.isUpdateManDirty() && (bl || pSDCSysPrdVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSysPrdVerBase.getUpdateMan());
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
        return PSDCSysPrdVerBase.remove(this, n);
    }

    private static boolean remove(PSDCSysPrdVerBase pSDCSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSysPrdVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSysPrdVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSysPrdVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSysPrdVerBase.resetPrdVerState();
                return true;
            }
            case 4: {
                pSDCSysPrdVerBase.resetPSDCSysPrdVerId();
                return true;
            }
            case 5: {
                pSDCSysPrdVerBase.resetPSDCSysPrdVerName();
                return true;
            }
            case 6: {
                pSDCSysPrdVerBase.resetPSDCSysProductId();
                return true;
            }
            case 7: {
                pSDCSysPrdVerBase.resetPSDCSysProductName();
                return true;
            }
            case 8: {
                pSDCSysPrdVerBase.resetPSSystemId();
                return true;
            }
            case 9: {
                pSDCSysPrdVerBase.resetPSSystemName();
                return true;
            }
            case 10: {
                pSDCSysPrdVerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDCSysPrdVerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSysProduct getPSDCSysProduct() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysProduct();
        }
        if (this.getPSDCSysProductId() == null) {
            return null;
        }
        Integer n = this.objPSDCSysProductLock;
        synchronized (n) {
            if (this.psdcsysproduct != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCSysProductId(), (Object)this.psdcsysproduct.getPSDCSysProductId()) != 0L) {
                this.psdcsysproduct = null;
            }
            if (this.psdcsysproduct == null) {
                PSDCSysProduct pSDCSysProduct = new PSDCSysProduct();
                pSDCSysProduct.setPSDCSysProductId(this.getPSDCSysProductId());
                PSDCSysProductService pSDCSysProductService = (PSDCSysProductService)ServiceGlobal.getService(PSDCSysProductService.class, (SessionFactory)this.getSessionFactory());
                pSDCSysProductService.autoGet(pSDCSysProduct);
                this.psdcsysproduct = pSDCSysProduct;
            }
            return this.psdcsysproduct;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSDCSysPrdVerBase getProxyEntity() {
        return this.proxyPSDCSysPrdVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSysPrdVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSysPrdVerBase) {
            this.proxyPSDCSysPrdVerBase = (PSDCSysPrdVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysPrdVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRDVERSTATE, 3);
        fieldIndexMap.put(FIELD_PSDCSYSPRDVERID, 4);
        fieldIndexMap.put(FIELD_PSDCSYSPRDVERNAME, 5);
        fieldIndexMap.put(FIELD_PSDCSYSPRODUCTID, 6);
        fieldIndexMap.put(FIELD_PSDCSYSPRODUCTNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

