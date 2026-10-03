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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeExpBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQCodeExpBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPCODE = "EXPCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDQCODEEXPID = "PSDEDQCODEEXPID";
    public static final String FIELD_PSDEDQCODEEXPNAME = "PSDEDQCODEEXPNAME";
    public static final String FIELD_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String FIELD_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXPCODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEDQCODEEXPID = 5;
    private static final int INDEX_PSDEDQCODEEXPNAME = 6;
    private static final int INDEX_PSDEDQCODEID = 7;
    private static final int INDEX_PSDEDQCODENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQCodeExpBase proxyPSDEDQCodeExpBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedqcodeexpidDirtyFlag = false;
    private boolean psdedqcodeexpnameDirtyFlag = false;
    private boolean psdedqcodeidDirtyFlag = false;
    private boolean psdedqcodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expcode")
    private String expcode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedqcodeexpid")
    private String psdedqcodeexpid;
    @Column(name="psdedqcodeexpname")
    private String psdedqcodeexpname;
    @Column(name="psdedqcodeid")
    private String psdedqcodeid;
    @Column(name="psdedqcodename")
    private String psdedqcodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEDQCodeLock = new Integer(1);
    private PSDEDQCode psdedqcode = null;

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

    public void setExpCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.expcode = string;
        this.expcodeDirtyFlag = true;
    }

    public String getExpCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpCode();
        }
        return this.expcode;
    }

    public boolean isExpCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpCodeDirty();
        }
        return this.expcodeDirtyFlag;
    }

    public void resetExpCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpCode();
            return;
        }
        this.expcodeDirtyFlag = false;
        this.expcode = null;
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

    public void setPSDEDQCodeExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodeexpid = string;
        this.psdedqcodeexpidDirtyFlag = true;
    }

    public String getPSDEDQCodeExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeExpId();
        }
        return this.psdedqcodeexpid;
    }

    public boolean isPSDEDQCodeExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeExpIdDirty();
        }
        return this.psdedqcodeexpidDirtyFlag;
    }

    public void resetPSDEDQCodeExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeExpId();
            return;
        }
        this.psdedqcodeexpidDirtyFlag = false;
        this.psdedqcodeexpid = null;
    }

    public void setPSDEDQCodeExpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeExpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdedqcodeexpname = string;
        this.psdedqcodeexpnameDirtyFlag = true;
    }

    public String getPSDEDQCodeExpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeExpName();
        }
        return this.psdedqcodeexpname;
    }

    public boolean isPSDEDQCodeExpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeExpNameDirty();
        }
        return this.psdedqcodeexpnameDirtyFlag;
    }

    public void resetPSDEDQCodeExpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeExpName();
            return;
        }
        this.psdedqcodeexpnameDirtyFlag = false;
        this.psdedqcodeexpname = null;
    }

    public void setPSDEDQCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodeid = string;
        this.psdedqcodeidDirtyFlag = true;
    }

    public String getPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeId();
        }
        return this.psdedqcodeid;
    }

    public boolean isPSDEDQCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeIdDirty();
        }
        return this.psdedqcodeidDirtyFlag;
    }

    public void resetPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeId();
            return;
        }
        this.psdedqcodeidDirtyFlag = false;
        this.psdedqcodeid = null;
    }

    public void setPSDEDQCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodename = string;
        this.psdedqcodenameDirtyFlag = true;
    }

    public String getPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeName();
        }
        return this.psdedqcodename;
    }

    public boolean isPSDEDQCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeNameDirty();
        }
        return this.psdedqcodenameDirtyFlag;
    }

    public void resetPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeName();
            return;
        }
        this.psdedqcodenameDirtyFlag = false;
        this.psdedqcodename = null;
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
        PSDEDQCodeExpBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQCodeExpBase pSDEDQCodeExpBase) {
        pSDEDQCodeExpBase.resetCreateDate();
        pSDEDQCodeExpBase.resetCreateMan();
        pSDEDQCodeExpBase.resetExpCode();
        pSDEDQCodeExpBase.resetMemo();
        pSDEDQCodeExpBase.resetOrderValue();
        pSDEDQCodeExpBase.resetPSDEDQCodeExpId();
        pSDEDQCodeExpBase.resetPSDEDQCodeExpName();
        pSDEDQCodeExpBase.resetPSDEDQCodeId();
        pSDEDQCodeExpBase.resetPSDEDQCodeName();
        pSDEDQCodeExpBase.resetUpdateDate();
        pSDEDQCodeExpBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpCodeDirty()) {
            hashMap.put(FIELD_EXPCODE, this.getExpCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDQCodeExpIdDirty()) {
            hashMap.put(FIELD_PSDEDQCODEEXPID, this.getPSDEDQCodeExpId());
        }
        if (!bl || this.isPSDEDQCodeExpNameDirty()) {
            hashMap.put(FIELD_PSDEDQCODEEXPNAME, this.getPSDEDQCodeExpName());
        }
        if (!bl || this.isPSDEDQCodeIdDirty()) {
            hashMap.put(FIELD_PSDEDQCODEID, this.getPSDEDQCodeId());
        }
        if (!bl || this.isPSDEDQCodeNameDirty()) {
            hashMap.put(FIELD_PSDEDQCODENAME, this.getPSDEDQCodeName());
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
        return PSDEDQCodeExpBase.get(this, n);
    }

    private static Object get(PSDEDQCodeExpBase pSDEDQCodeExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeExpBase.getCreateDate();
            }
            case 1: {
                return pSDEDQCodeExpBase.getCreateMan();
            }
            case 2: {
                return pSDEDQCodeExpBase.getExpCode();
            }
            case 3: {
                return pSDEDQCodeExpBase.getMemo();
            }
            case 4: {
                return pSDEDQCodeExpBase.getOrderValue();
            }
            case 5: {
                return pSDEDQCodeExpBase.getPSDEDQCodeExpId();
            }
            case 6: {
                return pSDEDQCodeExpBase.getPSDEDQCodeExpName();
            }
            case 7: {
                return pSDEDQCodeExpBase.getPSDEDQCodeId();
            }
            case 8: {
                return pSDEDQCodeExpBase.getPSDEDQCodeName();
            }
            case 9: {
                return pSDEDQCodeExpBase.getUpdateDate();
            }
            case 10: {
                return pSDEDQCodeExpBase.getUpdateMan();
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
        PSDEDQCodeExpBase.set(this, n, object);
    }

    private static void set(PSDEDQCodeExpBase pSDEDQCodeExpBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeExpBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQCodeExpBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQCodeExpBase.setExpCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQCodeExpBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQCodeExpBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQCodeExpBase.setPSDEDQCodeExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQCodeExpBase.setPSDEDQCodeExpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQCodeExpBase.setPSDEDQCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDQCodeExpBase.setPSDEDQCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDQCodeExpBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDEDQCodeExpBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDQCodeExpBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQCodeExpBase pSDEDQCodeExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeExpBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDQCodeExpBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDQCodeExpBase.getExpCode() == null;
            }
            case 3: {
                return pSDEDQCodeExpBase.getMemo() == null;
            }
            case 4: {
                return pSDEDQCodeExpBase.getOrderValue() == null;
            }
            case 5: {
                return pSDEDQCodeExpBase.getPSDEDQCodeExpId() == null;
            }
            case 6: {
                return pSDEDQCodeExpBase.getPSDEDQCodeExpName() == null;
            }
            case 7: {
                return pSDEDQCodeExpBase.getPSDEDQCodeId() == null;
            }
            case 8: {
                return pSDEDQCodeExpBase.getPSDEDQCodeName() == null;
            }
            case 9: {
                return pSDEDQCodeExpBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDEDQCodeExpBase.getUpdateMan() == null;
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
        return PSDEDQCodeExpBase.contains(this, n);
    }

    private static boolean contains(PSDEDQCodeExpBase pSDEDQCodeExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeExpBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDQCodeExpBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDQCodeExpBase.isExpCodeDirty();
            }
            case 3: {
                return pSDEDQCodeExpBase.isMemoDirty();
            }
            case 4: {
                return pSDEDQCodeExpBase.isOrderValueDirty();
            }
            case 5: {
                return pSDEDQCodeExpBase.isPSDEDQCodeExpIdDirty();
            }
            case 6: {
                return pSDEDQCodeExpBase.isPSDEDQCodeExpNameDirty();
            }
            case 7: {
                return pSDEDQCodeExpBase.isPSDEDQCodeIdDirty();
            }
            case 8: {
                return pSDEDQCodeExpBase.isPSDEDQCodeNameDirty();
            }
            case 9: {
                return pSDEDQCodeExpBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDEDQCodeExpBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQCodeExpBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQCodeExpBase pSDEDQCodeExpBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQCodeExpBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getExpCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expcode", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getExpCode()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodeexpid", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getPSDEDQCodeExpId()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodeexpname", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getPSDEDQCodeExpName()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodeid", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getPSDEDQCodeId()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodename", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getPSDEDQCodeName()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeExpBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQCodeExpBase.getJSONValue((Object)pSDEDQCodeExpBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQCodeExpBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQCodeExpBase pSDEDQCodeExpBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQCodeExpBase.getCreateDate() != null) {
            object = pSDEDQCodeExpBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeExpBase.getCreateMan() != null) {
            object = pSDEDQCodeExpBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getExpCode() != null) {
            object = pSDEDQCodeExpBase.getExpCode();
            xmlNode.setAttribute(FIELD_EXPCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getMemo() != null) {
            object = pSDEDQCodeExpBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getOrderValue() != null) {
            object = pSDEDQCodeExpBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpId() != null) {
            object = pSDEDQCodeExpBase.getPSDEDQCodeExpId();
            xmlNode.setAttribute(FIELD_PSDEDQCODEEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpName() != null) {
            object = pSDEDQCodeExpBase.getPSDEDQCodeExpName();
            xmlNode.setAttribute(FIELD_PSDEDQCODEEXPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeId() != null) {
            object = pSDEDQCodeExpBase.getPSDEDQCodeId();
            xmlNode.setAttribute(FIELD_PSDEDQCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getPSDEDQCodeName() != null) {
            object = pSDEDQCodeExpBase.getPSDEDQCodeName();
            xmlNode.setAttribute(FIELD_PSDEDQCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeExpBase.getUpdateDate() != null) {
            object = pSDEDQCodeExpBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeExpBase.getUpdateMan() != null) {
            object = pSDEDQCodeExpBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQCodeExpBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQCodeExpBase pSDEDQCodeExpBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQCodeExpBase.isCreateDateDirty() && (bl || pSDEDQCodeExpBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQCodeExpBase.getCreateDate());
        }
        if (pSDEDQCodeExpBase.isCreateManDirty() && (bl || pSDEDQCodeExpBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQCodeExpBase.getCreateMan());
        }
        if (pSDEDQCodeExpBase.isExpCodeDirty() && (bl || pSDEDQCodeExpBase.getExpCode() != null)) {
            iDataObject.set(FIELD_EXPCODE, (Object)pSDEDQCodeExpBase.getExpCode());
        }
        if (pSDEDQCodeExpBase.isMemoDirty() && (bl || pSDEDQCodeExpBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQCodeExpBase.getMemo());
        }
        if (pSDEDQCodeExpBase.isOrderValueDirty() && (bl || pSDEDQCodeExpBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDQCodeExpBase.getOrderValue());
        }
        if (pSDEDQCodeExpBase.isPSDEDQCodeExpIdDirty() && (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpId() != null)) {
            iDataObject.set(FIELD_PSDEDQCODEEXPID, (Object)pSDEDQCodeExpBase.getPSDEDQCodeExpId());
        }
        if (pSDEDQCodeExpBase.isPSDEDQCodeExpNameDirty() && (bl || pSDEDQCodeExpBase.getPSDEDQCodeExpName() != null)) {
            iDataObject.set(FIELD_PSDEDQCODEEXPNAME, (Object)pSDEDQCodeExpBase.getPSDEDQCodeExpName());
        }
        if (pSDEDQCodeExpBase.isPSDEDQCodeIdDirty() && (bl || pSDEDQCodeExpBase.getPSDEDQCodeId() != null)) {
            iDataObject.set(FIELD_PSDEDQCODEID, (Object)pSDEDQCodeExpBase.getPSDEDQCodeId());
        }
        if (pSDEDQCodeExpBase.isPSDEDQCodeNameDirty() && (bl || pSDEDQCodeExpBase.getPSDEDQCodeName() != null)) {
            iDataObject.set(FIELD_PSDEDQCODENAME, (Object)pSDEDQCodeExpBase.getPSDEDQCodeName());
        }
        if (pSDEDQCodeExpBase.isUpdateDateDirty() && (bl || pSDEDQCodeExpBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQCodeExpBase.getUpdateDate());
        }
        if (pSDEDQCodeExpBase.isUpdateManDirty() && (bl || pSDEDQCodeExpBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQCodeExpBase.getUpdateMan());
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
        return PSDEDQCodeExpBase.remove(this, n);
    }

    private static boolean remove(PSDEDQCodeExpBase pSDEDQCodeExpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeExpBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDQCodeExpBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDQCodeExpBase.resetExpCode();
                return true;
            }
            case 3: {
                pSDEDQCodeExpBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDQCodeExpBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDEDQCodeExpBase.resetPSDEDQCodeExpId();
                return true;
            }
            case 6: {
                pSDEDQCodeExpBase.resetPSDEDQCodeExpName();
                return true;
            }
            case 7: {
                pSDEDQCodeExpBase.resetPSDEDQCodeId();
                return true;
            }
            case 8: {
                pSDEDQCodeExpBase.resetPSDEDQCodeName();
                return true;
            }
            case 9: {
                pSDEDQCodeExpBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDEDQCodeExpBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQCode getPSDEDQCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCode();
        }
        if (this.getPSDEDQCodeId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQCodeLock;
        synchronized (n) {
            if (this.psdedqcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQCodeId(), (Object)this.psdedqcode.getPSDEDQCodeId()) != 0L) {
                this.psdedqcode = null;
            }
            if (this.psdedqcode == null) {
                PSDEDQCode pSDEDQCode = new PSDEDQCode();
                pSDEDQCode.setPSDEDQCodeId(this.getPSDEDQCodeId());
                PSDEDQCodeService pSDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQCodeService.autoGet(pSDEDQCode);
                this.psdedqcode = pSDEDQCode;
            }
            return this.psdedqcode;
        }
    }

    private PSDEDQCodeExpBase getProxyEntity() {
        return this.proxyPSDEDQCodeExpBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQCodeExpBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQCodeExpBase) {
            this.proxyPSDEDQCodeExpBase = (PSDEDQCodeExpBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXPCODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEDQCODEEXPID, 5);
        fieldIndexMap.put(FIELD_PSDEDQCODEEXPNAME, 6);
        fieldIndexMap.put(FIELD_PSDEDQCODEID, 7);
        fieldIndexMap.put(FIELD_PSDEDQCODENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

