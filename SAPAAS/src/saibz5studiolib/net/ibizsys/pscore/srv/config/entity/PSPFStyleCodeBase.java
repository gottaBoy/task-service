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
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStyleCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFSTYLECODEID = "PSPFSTYLECODEID";
    public static final String FIELD_PSPFSTYLECODENAME = "PSPFSTYLECODENAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_STYLECODE = "STYLECODE";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPFSTYLECODEID = 3;
    private static final int INDEX_PSPFSTYLECODENAME = 4;
    private static final int INDEX_PSPFSTYLEID = 5;
    private static final int INDEX_PSPFSTYLENAME = 6;
    private static final int INDEX_STYLECODE = 7;
    private static final int INDEX_TEMPLDESC = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStyleCodeBase proxyPSPFStyleCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfstylecodeidDirtyFlag = false;
    private boolean pspfstylecodenameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean stylecodeDirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfstylecodeid")
    private String pspfstylecodeid;
    @Column(name="pspfstylecodename")
    private String pspfstylecodename;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="stylecode")
    private String stylecode;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;

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

    public void setPSPFStyleCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylecodeid = string;
        this.pspfstylecodeidDirtyFlag = true;
    }

    public String getPSPFStyleCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleCodeId();
        }
        return this.pspfstylecodeid;
    }

    public boolean isPSPFStyleCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleCodeIdDirty();
        }
        return this.pspfstylecodeidDirtyFlag;
    }

    public void resetPSPFStyleCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleCodeId();
            return;
        }
        this.pspfstylecodeidDirtyFlag = false;
        this.pspfstylecodeid = null;
    }

    public void setPSPFStyleCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylecodename = string;
        this.pspfstylecodenameDirtyFlag = true;
    }

    public String getPSPFStyleCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleCodeName();
        }
        return this.pspfstylecodename;
    }

    public boolean isPSPFStyleCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleCodeNameDirty();
        }
        return this.pspfstylecodenameDirtyFlag;
    }

    public void resetPSPFStyleCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleCodeName();
            return;
        }
        this.pspfstylecodenameDirtyFlag = false;
        this.pspfstylecodename = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setStyleCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stylecode = string;
        this.stylecodeDirtyFlag = true;
    }

    public String getStyleCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleCode();
        }
        return this.stylecode;
    }

    public boolean isStyleCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleCodeDirty();
        }
        return this.stylecodeDirtyFlag;
    }

    public void resetStyleCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleCode();
            return;
        }
        this.stylecodeDirtyFlag = false;
        this.stylecode = null;
    }

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
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
        PSPFStyleCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStyleCodeBase pSPFStyleCodeBase) {
        pSPFStyleCodeBase.resetCreateDate();
        pSPFStyleCodeBase.resetCreateMan();
        pSPFStyleCodeBase.resetMemo();
        pSPFStyleCodeBase.resetPSPFStyleCodeId();
        pSPFStyleCodeBase.resetPSPFStyleCodeName();
        pSPFStyleCodeBase.resetPSPFStyleId();
        pSPFStyleCodeBase.resetPSPFStyleName();
        pSPFStyleCodeBase.resetStyleCode();
        pSPFStyleCodeBase.resetTemplDesc();
        pSPFStyleCodeBase.resetUpdateDate();
        pSPFStyleCodeBase.resetUpdateMan();
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
        if (!bl || this.isPSPFStyleCodeIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLECODEID, this.getPSPFStyleCodeId());
        }
        if (!bl || this.isPSPFStyleCodeNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLECODENAME, this.getPSPFStyleCodeName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isStyleCodeDirty()) {
            hashMap.put(FIELD_STYLECODE, this.getStyleCode());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSPFStyleCodeBase.get(this, n);
    }

    private static Object get(PSPFStyleCodeBase pSPFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleCodeBase.getCreateDate();
            }
            case 1: {
                return pSPFStyleCodeBase.getCreateMan();
            }
            case 2: {
                return pSPFStyleCodeBase.getMemo();
            }
            case 3: {
                return pSPFStyleCodeBase.getPSPFStyleCodeId();
            }
            case 4: {
                return pSPFStyleCodeBase.getPSPFStyleCodeName();
            }
            case 5: {
                return pSPFStyleCodeBase.getPSPFStyleId();
            }
            case 6: {
                return pSPFStyleCodeBase.getPSPFStyleName();
            }
            case 7: {
                return pSPFStyleCodeBase.getStyleCode();
            }
            case 8: {
                return pSPFStyleCodeBase.getTemplDesc();
            }
            case 9: {
                return pSPFStyleCodeBase.getUpdateDate();
            }
            case 10: {
                return pSPFStyleCodeBase.getUpdateMan();
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
        PSPFStyleCodeBase.set(this, n, object);
    }

    private static void set(PSPFStyleCodeBase pSPFStyleCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFStyleCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFStyleCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFStyleCodeBase.setPSPFStyleCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFStyleCodeBase.setPSPFStyleCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFStyleCodeBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFStyleCodeBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFStyleCodeBase.setStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFStyleCodeBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStyleCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSPFStyleCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFStyleCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStyleCodeBase pSPFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFStyleCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFStyleCodeBase.getMemo() == null;
            }
            case 3: {
                return pSPFStyleCodeBase.getPSPFStyleCodeId() == null;
            }
            case 4: {
                return pSPFStyleCodeBase.getPSPFStyleCodeName() == null;
            }
            case 5: {
                return pSPFStyleCodeBase.getPSPFStyleId() == null;
            }
            case 6: {
                return pSPFStyleCodeBase.getPSPFStyleName() == null;
            }
            case 7: {
                return pSPFStyleCodeBase.getStyleCode() == null;
            }
            case 8: {
                return pSPFStyleCodeBase.getTemplDesc() == null;
            }
            case 9: {
                return pSPFStyleCodeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSPFStyleCodeBase.getUpdateMan() == null;
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
        return PSPFStyleCodeBase.contains(this, n);
    }

    private static boolean contains(PSPFStyleCodeBase pSPFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFStyleCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSPFStyleCodeBase.isMemoDirty();
            }
            case 3: {
                return pSPFStyleCodeBase.isPSPFStyleCodeIdDirty();
            }
            case 4: {
                return pSPFStyleCodeBase.isPSPFStyleCodeNameDirty();
            }
            case 5: {
                return pSPFStyleCodeBase.isPSPFStyleIdDirty();
            }
            case 6: {
                return pSPFStyleCodeBase.isPSPFStyleNameDirty();
            }
            case 7: {
                return pSPFStyleCodeBase.isStyleCodeDirty();
            }
            case 8: {
                return pSPFStyleCodeBase.isTemplDescDirty();
            }
            case 9: {
                return pSPFStyleCodeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSPFStyleCodeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStyleCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStyleCodeBase pSPFStyleCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStyleCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylecodeid", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getPSPFStyleCodeId()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylecodename", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getPSPFStyleCodeName()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stylecode", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getStyleCode()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStyleCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStyleCodeBase.getJSONValue((Object)pSPFStyleCodeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStyleCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStyleCodeBase pSPFStyleCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStyleCodeBase.getCreateDate() != null) {
            object = pSPFStyleCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleCodeBase.getCreateMan() != null) {
            object = pSPFStyleCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getMemo() != null) {
            object = pSPFStyleCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleCodeId() != null) {
            object = pSPFStyleCodeBase.getPSPFStyleCodeId();
            xmlNode.setAttribute(FIELD_PSPFSTYLECODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleCodeName() != null) {
            object = pSPFStyleCodeBase.getPSPFStyleCodeName();
            xmlNode.setAttribute(FIELD_PSPFSTYLECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleId() != null) {
            object = pSPFStyleCodeBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getPSPFStyleName() != null) {
            object = pSPFStyleCodeBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getStyleCode() != null) {
            object = pSPFStyleCodeBase.getStyleCode();
            xmlNode.setAttribute(FIELD_STYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getTemplDesc() != null) {
            object = pSPFStyleCodeBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleCodeBase.getUpdateDate() != null) {
            object = pSPFStyleCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleCodeBase.getUpdateMan() != null) {
            object = pSPFStyleCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStyleCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStyleCodeBase pSPFStyleCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStyleCodeBase.isCreateDateDirty() && (bl || pSPFStyleCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStyleCodeBase.getCreateDate());
        }
        if (pSPFStyleCodeBase.isCreateManDirty() && (bl || pSPFStyleCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStyleCodeBase.getCreateMan());
        }
        if (pSPFStyleCodeBase.isMemoDirty() && (bl || pSPFStyleCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFStyleCodeBase.getMemo());
        }
        if (pSPFStyleCodeBase.isPSPFStyleCodeIdDirty() && (bl || pSPFStyleCodeBase.getPSPFStyleCodeId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLECODEID, (Object)pSPFStyleCodeBase.getPSPFStyleCodeId());
        }
        if (pSPFStyleCodeBase.isPSPFStyleCodeNameDirty() && (bl || pSPFStyleCodeBase.getPSPFStyleCodeName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLECODENAME, (Object)pSPFStyleCodeBase.getPSPFStyleCodeName());
        }
        if (pSPFStyleCodeBase.isPSPFStyleIdDirty() && (bl || pSPFStyleCodeBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStyleCodeBase.getPSPFStyleId());
        }
        if (pSPFStyleCodeBase.isPSPFStyleNameDirty() && (bl || pSPFStyleCodeBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStyleCodeBase.getPSPFStyleName());
        }
        if (pSPFStyleCodeBase.isStyleCodeDirty() && (bl || pSPFStyleCodeBase.getStyleCode() != null)) {
            iDataObject.set(FIELD_STYLECODE, (Object)pSPFStyleCodeBase.getStyleCode());
        }
        if (pSPFStyleCodeBase.isTemplDescDirty() && (bl || pSPFStyleCodeBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFStyleCodeBase.getTemplDesc());
        }
        if (pSPFStyleCodeBase.isUpdateDateDirty() && (bl || pSPFStyleCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStyleCodeBase.getUpdateDate());
        }
        if (pSPFStyleCodeBase.isUpdateManDirty() && (bl || pSPFStyleCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStyleCodeBase.getUpdateMan());
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
        return PSPFStyleCodeBase.remove(this, n);
    }

    private static boolean remove(PSPFStyleCodeBase pSPFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFStyleCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFStyleCodeBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFStyleCodeBase.resetPSPFStyleCodeId();
                return true;
            }
            case 4: {
                pSPFStyleCodeBase.resetPSPFStyleCodeName();
                return true;
            }
            case 5: {
                pSPFStyleCodeBase.resetPSPFStyleId();
                return true;
            }
            case 6: {
                pSPFStyleCodeBase.resetPSPFStyleName();
                return true;
            }
            case 7: {
                pSPFStyleCodeBase.resetStyleCode();
                return true;
            }
            case 8: {
                pSPFStyleCodeBase.resetTemplDesc();
                return true;
            }
            case 9: {
                pSPFStyleCodeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSPFStyleCodeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    private PSPFStyleCodeBase getProxyEntity() {
        return this.proxyPSPFStyleCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStyleCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStyleCodeBase) {
            this.proxyPSPFStyleCodeBase = (PSPFStyleCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPFSTYLECODEID, 3);
        fieldIndexMap.put(FIELD_PSPFSTYLECODENAME, 4);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 5);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 6);
        fieldIndexMap.put(FIELD_STYLECODE, 7);
        fieldIndexMap.put(FIELD_TEMPLDESC, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

