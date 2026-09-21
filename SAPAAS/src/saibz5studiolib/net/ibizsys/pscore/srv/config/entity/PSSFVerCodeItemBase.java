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
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFVerCodeItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFVerCodeItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String FIELD_PSSFVERCODEID = "PSSFVERCODEID";
    public static final String FIELD_PSSFVERCODEITEMID = "PSSFVERCODEITEMID";
    public static final String FIELD_PSSFVERCODEITEMNAME = "PSSFVERCODEITEMNAME";
    public static final String FIELD_PSSFVERCODENAME = "PSSFVERCODENAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSFSTYLEVERID = 3;
    private static final int INDEX_PSSFVERCODEID = 4;
    private static final int INDEX_PSSFVERCODEITEMID = 5;
    private static final int INDEX_PSSFVERCODEITEMNAME = 6;
    private static final int INDEX_PSSFVERCODENAME = 7;
    private static final int INDEX_TEMPLCODE = 8;
    private static final int INDEX_TEMPLCODE2 = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFVerCodeItemBase proxyPSSFVerCodeItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfstyleveridDirtyFlag = false;
    private boolean pssfvercodeidDirtyFlag = false;
    private boolean pssfvercodeitemidDirtyFlag = false;
    private boolean pssfvercodeitemnameDirtyFlag = false;
    private boolean pssfvercodenameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfstyleverid")
    private String pssfstyleverid;
    @Column(name="pssfvercodeid")
    private String pssfvercodeid;
    @Column(name="pssfvercodeitemid")
    private String pssfvercodeitemid;
    @Column(name="pssfvercodeitemname")
    private String pssfvercodeitemname;
    @Column(name="pssfvercodename")
    private String pssfvercodename;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFVerCodeLock = new Integer(1);
    private PSSFVerCode pssfvercode = null;

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

    public void setPSSFStyleVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleverid = string;
        this.pssfstyleveridDirtyFlag = true;
    }

    public String getPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerId();
        }
        return this.pssfstyleverid;
    }

    public boolean isPSSFStyleVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerIdDirty();
        }
        return this.pssfstyleveridDirtyFlag;
    }

    public void resetPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerId();
            return;
        }
        this.pssfstyleveridDirtyFlag = false;
        this.pssfstyleverid = null;
    }

    public void setPSSFVerCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfvercodeid = string;
        this.pssfvercodeidDirtyFlag = true;
    }

    public String getPSSFVerCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeId();
        }
        return this.pssfvercodeid;
    }

    public boolean isPSSFVerCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeIdDirty();
        }
        return this.pssfvercodeidDirtyFlag;
    }

    public void resetPSSFVerCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeId();
            return;
        }
        this.pssfvercodeidDirtyFlag = false;
        this.pssfvercodeid = null;
    }

    public void setPSSFVerCodeItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfvercodeitemid = string;
        this.pssfvercodeitemidDirtyFlag = true;
    }

    public String getPSSFVerCodeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeItemId();
        }
        return this.pssfvercodeitemid;
    }

    public boolean isPSSFVerCodeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeItemIdDirty();
        }
        return this.pssfvercodeitemidDirtyFlag;
    }

    public void resetPSSFVerCodeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeItemId();
            return;
        }
        this.pssfvercodeitemidDirtyFlag = false;
        this.pssfvercodeitemid = null;
    }

    public void setPSSFVerCodeItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssfvercodeitemname = string;
        this.pssfvercodeitemnameDirtyFlag = true;
    }

    public String getPSSFVerCodeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeItemName();
        }
        return this.pssfvercodeitemname;
    }

    public boolean isPSSFVerCodeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeItemNameDirty();
        }
        return this.pssfvercodeitemnameDirtyFlag;
    }

    public void resetPSSFVerCodeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeItemName();
            return;
        }
        this.pssfvercodeitemnameDirtyFlag = false;
        this.pssfvercodeitemname = null;
    }

    public void setPSSFVerCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFVerCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfvercodename = string;
        this.pssfvercodenameDirtyFlag = true;
    }

    public String getPSSFVerCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCodeName();
        }
        return this.pssfvercodename;
    }

    public boolean isPSSFVerCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFVerCodeNameDirty();
        }
        return this.pssfvercodenameDirtyFlag;
    }

    public void resetPSSFVerCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFVerCodeName();
            return;
        }
        this.pssfvercodenameDirtyFlag = false;
        this.pssfvercodename = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
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
        PSSFVerCodeItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFVerCodeItemBase pSSFVerCodeItemBase) {
        pSSFVerCodeItemBase.resetCreateDate();
        pSSFVerCodeItemBase.resetCreateMan();
        pSSFVerCodeItemBase.resetMemo();
        pSSFVerCodeItemBase.resetPSSFStyleVerId();
        pSSFVerCodeItemBase.resetPSSFVerCodeId();
        pSSFVerCodeItemBase.resetPSSFVerCodeItemId();
        pSSFVerCodeItemBase.resetPSSFVerCodeItemName();
        pSSFVerCodeItemBase.resetPSSFVerCodeName();
        pSSFVerCodeItemBase.resetTemplCode();
        pSSFVerCodeItemBase.resetTemplCode2();
        pSSFVerCodeItemBase.resetUpdateDate();
        pSSFVerCodeItemBase.resetUpdateMan();
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
        if (!bl || this.isPSSFStyleVerIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERID, this.getPSSFStyleVerId());
        }
        if (!bl || this.isPSSFVerCodeIdDirty()) {
            hashMap.put(FIELD_PSSFVERCODEID, this.getPSSFVerCodeId());
        }
        if (!bl || this.isPSSFVerCodeItemIdDirty()) {
            hashMap.put(FIELD_PSSFVERCODEITEMID, this.getPSSFVerCodeItemId());
        }
        if (!bl || this.isPSSFVerCodeItemNameDirty()) {
            hashMap.put(FIELD_PSSFVERCODEITEMNAME, this.getPSSFVerCodeItemName());
        }
        if (!bl || this.isPSSFVerCodeNameDirty()) {
            hashMap.put(FIELD_PSSFVERCODENAME, this.getPSSFVerCodeName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
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
        return PSSFVerCodeItemBase.get(this, n);
    }

    private static Object get(PSSFVerCodeItemBase pSSFVerCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeItemBase.getCreateDate();
            }
            case 1: {
                return pSSFVerCodeItemBase.getCreateMan();
            }
            case 2: {
                return pSSFVerCodeItemBase.getMemo();
            }
            case 3: {
                return pSSFVerCodeItemBase.getPSSFStyleVerId();
            }
            case 4: {
                return pSSFVerCodeItemBase.getPSSFVerCodeId();
            }
            case 5: {
                return pSSFVerCodeItemBase.getPSSFVerCodeItemId();
            }
            case 6: {
                return pSSFVerCodeItemBase.getPSSFVerCodeItemName();
            }
            case 7: {
                return pSSFVerCodeItemBase.getPSSFVerCodeName();
            }
            case 8: {
                return pSSFVerCodeItemBase.getTemplCode();
            }
            case 9: {
                return pSSFVerCodeItemBase.getTemplCode2();
            }
            case 10: {
                return pSSFVerCodeItemBase.getUpdateDate();
            }
            case 11: {
                return pSSFVerCodeItemBase.getUpdateMan();
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
        PSSFVerCodeItemBase.set(this, n, object);
    }

    private static void set(PSSFVerCodeItemBase pSSFVerCodeItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFVerCodeItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFVerCodeItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFVerCodeItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFVerCodeItemBase.setPSSFStyleVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFVerCodeItemBase.setPSSFVerCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFVerCodeItemBase.setPSSFVerCodeItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFVerCodeItemBase.setPSSFVerCodeItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFVerCodeItemBase.setPSSFVerCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFVerCodeItemBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFVerCodeItemBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFVerCodeItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSFVerCodeItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFVerCodeItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSFVerCodeItemBase pSSFVerCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFVerCodeItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFVerCodeItemBase.getMemo() == null;
            }
            case 3: {
                return pSSFVerCodeItemBase.getPSSFStyleVerId() == null;
            }
            case 4: {
                return pSSFVerCodeItemBase.getPSSFVerCodeId() == null;
            }
            case 5: {
                return pSSFVerCodeItemBase.getPSSFVerCodeItemId() == null;
            }
            case 6: {
                return pSSFVerCodeItemBase.getPSSFVerCodeItemName() == null;
            }
            case 7: {
                return pSSFVerCodeItemBase.getPSSFVerCodeName() == null;
            }
            case 8: {
                return pSSFVerCodeItemBase.getTemplCode() == null;
            }
            case 9: {
                return pSSFVerCodeItemBase.getTemplCode2() == null;
            }
            case 10: {
                return pSSFVerCodeItemBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSFVerCodeItemBase.getUpdateMan() == null;
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
        return PSSFVerCodeItemBase.contains(this, n);
    }

    private static boolean contains(PSSFVerCodeItemBase pSSFVerCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFVerCodeItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFVerCodeItemBase.isCreateManDirty();
            }
            case 2: {
                return pSSFVerCodeItemBase.isMemoDirty();
            }
            case 3: {
                return pSSFVerCodeItemBase.isPSSFStyleVerIdDirty();
            }
            case 4: {
                return pSSFVerCodeItemBase.isPSSFVerCodeIdDirty();
            }
            case 5: {
                return pSSFVerCodeItemBase.isPSSFVerCodeItemIdDirty();
            }
            case 6: {
                return pSSFVerCodeItemBase.isPSSFVerCodeItemNameDirty();
            }
            case 7: {
                return pSSFVerCodeItemBase.isPSSFVerCodeNameDirty();
            }
            case 8: {
                return pSSFVerCodeItemBase.isTemplCodeDirty();
            }
            case 9: {
                return pSSFVerCodeItemBase.isTemplCode2Dirty();
            }
            case 10: {
                return pSSFVerCodeItemBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSFVerCodeItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFVerCodeItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFVerCodeItemBase pSSFVerCodeItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFVerCodeItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFStyleVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleverid", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getPSSFStyleVerId()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodeid", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getPSSFVerCodeId()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodeitemid", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getPSSFVerCodeItemId()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodeitemname", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getPSSFVerCodeItemName()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfvercodename", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getPSSFVerCodeName()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFVerCodeItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFVerCodeItemBase.getJSONValue((Object)pSSFVerCodeItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFVerCodeItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFVerCodeItemBase pSSFVerCodeItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFVerCodeItemBase.getCreateDate() != null) {
            object = pSSFVerCodeItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFVerCodeItemBase.getCreateMan() != null) {
            object = pSSFVerCodeItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getMemo() != null) {
            object = pSSFVerCodeItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFStyleVerId() != null) {
            object = pSSFVerCodeItemBase.getPSSFStyleVerId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeId() != null) {
            object = pSSFVerCodeItemBase.getPSSFVerCodeId();
            xmlNode.setAttribute(FIELD_PSSFVERCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemId() != null) {
            object = pSSFVerCodeItemBase.getPSSFVerCodeItemId();
            xmlNode.setAttribute(FIELD_PSSFVERCODEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemName() != null) {
            object = pSSFVerCodeItemBase.getPSSFVerCodeItemName();
            xmlNode.setAttribute(FIELD_PSSFVERCODEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getPSSFVerCodeName() != null) {
            object = pSSFVerCodeItemBase.getPSSFVerCodeName();
            xmlNode.setAttribute(FIELD_PSSFVERCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getTemplCode() != null) {
            object = pSSFVerCodeItemBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getTemplCode2() != null) {
            object = pSSFVerCodeItemBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSFVerCodeItemBase.getUpdateDate() != null) {
            object = pSSFVerCodeItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFVerCodeItemBase.getUpdateMan() != null) {
            object = pSSFVerCodeItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFVerCodeItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFVerCodeItemBase pSSFVerCodeItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFVerCodeItemBase.isCreateDateDirty() && (bl || pSSFVerCodeItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFVerCodeItemBase.getCreateDate());
        }
        if (pSSFVerCodeItemBase.isCreateManDirty() && (bl || pSSFVerCodeItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFVerCodeItemBase.getCreateMan());
        }
        if (pSSFVerCodeItemBase.isMemoDirty() && (bl || pSSFVerCodeItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFVerCodeItemBase.getMemo());
        }
        if (pSSFVerCodeItemBase.isPSSFStyleVerIdDirty() && (bl || pSSFVerCodeItemBase.getPSSFStyleVerId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERID, (Object)pSSFVerCodeItemBase.getPSSFStyleVerId());
        }
        if (pSSFVerCodeItemBase.isPSSFVerCodeIdDirty() && (bl || pSSFVerCodeItemBase.getPSSFVerCodeId() != null)) {
            iDataObject.set(FIELD_PSSFVERCODEID, (Object)pSSFVerCodeItemBase.getPSSFVerCodeId());
        }
        if (pSSFVerCodeItemBase.isPSSFVerCodeItemIdDirty() && (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemId() != null)) {
            iDataObject.set(FIELD_PSSFVERCODEITEMID, (Object)pSSFVerCodeItemBase.getPSSFVerCodeItemId());
        }
        if (pSSFVerCodeItemBase.isPSSFVerCodeItemNameDirty() && (bl || pSSFVerCodeItemBase.getPSSFVerCodeItemName() != null)) {
            iDataObject.set(FIELD_PSSFVERCODEITEMNAME, (Object)pSSFVerCodeItemBase.getPSSFVerCodeItemName());
        }
        if (pSSFVerCodeItemBase.isPSSFVerCodeNameDirty() && (bl || pSSFVerCodeItemBase.getPSSFVerCodeName() != null)) {
            iDataObject.set(FIELD_PSSFVERCODENAME, (Object)pSSFVerCodeItemBase.getPSSFVerCodeName());
        }
        if (pSSFVerCodeItemBase.isTemplCodeDirty() && (bl || pSSFVerCodeItemBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSSFVerCodeItemBase.getTemplCode());
        }
        if (pSSFVerCodeItemBase.isTemplCode2Dirty() && (bl || pSSFVerCodeItemBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSFVerCodeItemBase.getTemplCode2());
        }
        if (pSSFVerCodeItemBase.isUpdateDateDirty() && (bl || pSSFVerCodeItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFVerCodeItemBase.getUpdateDate());
        }
        if (pSSFVerCodeItemBase.isUpdateManDirty() && (bl || pSSFVerCodeItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFVerCodeItemBase.getUpdateMan());
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
        return PSSFVerCodeItemBase.remove(this, n);
    }

    private static boolean remove(PSSFVerCodeItemBase pSSFVerCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFVerCodeItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFVerCodeItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFVerCodeItemBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFVerCodeItemBase.resetPSSFStyleVerId();
                return true;
            }
            case 4: {
                pSSFVerCodeItemBase.resetPSSFVerCodeId();
                return true;
            }
            case 5: {
                pSSFVerCodeItemBase.resetPSSFVerCodeItemId();
                return true;
            }
            case 6: {
                pSSFVerCodeItemBase.resetPSSFVerCodeItemName();
                return true;
            }
            case 7: {
                pSSFVerCodeItemBase.resetPSSFVerCodeName();
                return true;
            }
            case 8: {
                pSSFVerCodeItemBase.resetTemplCode();
                return true;
            }
            case 9: {
                pSSFVerCodeItemBase.resetTemplCode2();
                return true;
            }
            case 10: {
                pSSFVerCodeItemBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSFVerCodeItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFVerCode getPSSFVerCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFVerCode();
        }
        if (this.getPSSFVerCodeId() == null) {
            return null;
        }
        Integer n = this.objPSSFVerCodeLock;
        synchronized (n) {
            if (this.pssfvercode != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFVerCodeId(), (Object)this.pssfvercode.getPSSFVerCodeId()) != 0L) {
                this.pssfvercode = null;
            }
            if (this.pssfvercode == null) {
                PSSFVerCode pSSFVerCode = new PSSFVerCode();
                pSSFVerCode.setPSSFVerCodeId(this.getPSSFVerCodeId());
                PSSFVerCodeService pSSFVerCodeService = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
                pSSFVerCodeService.autoGet((IEntity)pSSFVerCode);
                this.pssfvercode = pSSFVerCode;
            }
            return this.pssfvercode;
        }
    }

    private PSSFVerCodeItemBase getProxyEntity() {
        return this.proxyPSSFVerCodeItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFVerCodeItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFVerCodeItemBase) {
            this.proxyPSSFVerCodeItemBase = (PSSFVerCodeItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERID, 3);
        fieldIndexMap.put(FIELD_PSSFVERCODEID, 4);
        fieldIndexMap.put(FIELD_PSSFVERCODEITEMID, 5);
        fieldIndexMap.put(FIELD_PSSFVERCODEITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSSFVERCODENAME, 7);
        fieldIndexMap.put(FIELD_TEMPLCODE, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

