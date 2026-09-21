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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDEFormTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDYNADEFORMTEMPLID = "PSDYNADEFORMTEMPLID";
    public static final String FIELD_PSDYNADEFORMTEMPLNAME = "PSDYNADEFORMTEMPLNAME";
    public static final String FIELD_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String FIELD_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEFORMID = 3;
    private static final int INDEX_PSDEFORMNAME = 4;
    private static final int INDEX_PSDYNADEFORMTEMPLID = 5;
    private static final int INDEX_PSDYNADEFORMTEMPLNAME = 6;
    private static final int INDEX_PSDYNADETEMPLID = 7;
    private static final int INDEX_PSDYNADETEMPLNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDEFormTemplBase proxyPSDynaDEFormTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdynadeformtemplidDirtyFlag = false;
    private boolean psdynadeformtemplnameDirtyFlag = false;
    private boolean psdynadetemplidDirtyFlag = false;
    private boolean psdynadetemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdynadeformtemplid")
    private String psdynadeformtemplid;
    @Column(name="psdynadeformtemplname")
    private String psdynadeformtemplname;
    @Column(name="psdynadetemplid")
    private String psdynadetemplid;
    @Column(name="psdynadetemplname")
    private String psdynadetemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDynaDETemplLock = new Integer(1);
    private PSDynaDETempl psdynadetempl = null;

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

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDynaDEFormTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformtemplid = string;
        this.psdynadeformtemplidDirtyFlag = true;
    }

    public String getPSDynaDEFormTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormTemplId();
        }
        return this.psdynadeformtemplid;
    }

    public boolean isPSDynaDEFormTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormTemplIdDirty();
        }
        return this.psdynadeformtemplidDirtyFlag;
    }

    public void resetPSDynaDEFormTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormTemplId();
            return;
        }
        this.psdynadeformtemplidDirtyFlag = false;
        this.psdynadeformtemplid = null;
    }

    public void setPSDynaDEFormTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformtemplname = string;
        this.psdynadeformtemplnameDirtyFlag = true;
    }

    public String getPSDynaDEFormTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormTemplName();
        }
        return this.psdynadeformtemplname;
    }

    public boolean isPSDynaDEFormTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormTemplNameDirty();
        }
        return this.psdynadeformtemplnameDirtyFlag;
    }

    public void resetPSDynaDEFormTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormTemplName();
            return;
        }
        this.psdynadeformtemplnameDirtyFlag = false;
        this.psdynadeformtemplname = null;
    }

    public void setPSDynaDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplid = string;
        this.psdynadetemplidDirtyFlag = true;
    }

    public String getPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplId();
        }
        return this.psdynadetemplid;
    }

    public boolean isPSDynaDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplIdDirty();
        }
        return this.psdynadetemplidDirtyFlag;
    }

    public void resetPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplId();
            return;
        }
        this.psdynadetemplidDirtyFlag = false;
        this.psdynadetemplid = null;
    }

    public void setPSDynaDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplname = string;
        this.psdynadetemplnameDirtyFlag = true;
    }

    public String getPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplName();
        }
        return this.psdynadetemplname;
    }

    public boolean isPSDynaDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplNameDirty();
        }
        return this.psdynadetemplnameDirtyFlag;
    }

    public void resetPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplName();
            return;
        }
        this.psdynadetemplnameDirtyFlag = false;
        this.psdynadetemplname = null;
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
        PSDynaDEFormTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDEFormTemplBase pSDynaDEFormTemplBase) {
        pSDynaDEFormTemplBase.resetCreateDate();
        pSDynaDEFormTemplBase.resetCreateMan();
        pSDynaDEFormTemplBase.resetMemo();
        pSDynaDEFormTemplBase.resetPSDEFormId();
        pSDynaDEFormTemplBase.resetPSDEFormName();
        pSDynaDEFormTemplBase.resetPSDynaDEFormTemplId();
        pSDynaDEFormTemplBase.resetPSDynaDEFormTemplName();
        pSDynaDEFormTemplBase.resetPSDynaDETemplId();
        pSDynaDEFormTemplBase.resetPSDynaDETemplName();
        pSDynaDEFormTemplBase.resetUpdateDate();
        pSDynaDEFormTemplBase.resetUpdateMan();
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
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDynaDEFormTemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMTEMPLID, this.getPSDynaDEFormTemplId());
        }
        if (!bl || this.isPSDynaDEFormTemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMTEMPLNAME, this.getPSDynaDEFormTemplName());
        }
        if (!bl || this.isPSDynaDETemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLID, this.getPSDynaDETemplId());
        }
        if (!bl || this.isPSDynaDETemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLNAME, this.getPSDynaDETemplName());
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
        return PSDynaDEFormTemplBase.get(this, n);
    }

    private static Object get(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormTemplBase.getCreateDate();
            }
            case 1: {
                return pSDynaDEFormTemplBase.getCreateMan();
            }
            case 2: {
                return pSDynaDEFormTemplBase.getMemo();
            }
            case 3: {
                return pSDynaDEFormTemplBase.getPSDEFormId();
            }
            case 4: {
                return pSDynaDEFormTemplBase.getPSDEFormName();
            }
            case 5: {
                return pSDynaDEFormTemplBase.getPSDynaDEFormTemplId();
            }
            case 6: {
                return pSDynaDEFormTemplBase.getPSDynaDEFormTemplName();
            }
            case 7: {
                return pSDynaDEFormTemplBase.getPSDynaDETemplId();
            }
            case 8: {
                return pSDynaDEFormTemplBase.getPSDynaDETemplName();
            }
            case 9: {
                return pSDynaDEFormTemplBase.getUpdateDate();
            }
            case 10: {
                return pSDynaDEFormTemplBase.getUpdateMan();
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
        PSDynaDEFormTemplBase.set(this, n, object);
    }

    private static void set(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDEFormTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDEFormTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDEFormTemplBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDEFormTemplBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDEFormTemplBase.setPSDynaDEFormTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDEFormTemplBase.setPSDynaDEFormTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDEFormTemplBase.setPSDynaDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDEFormTemplBase.setPSDynaDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDEFormTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDynaDEFormTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaDEFormTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaDEFormTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaDEFormTemplBase.getMemo() == null;
            }
            case 3: {
                return pSDynaDEFormTemplBase.getPSDEFormId() == null;
            }
            case 4: {
                return pSDynaDEFormTemplBase.getPSDEFormName() == null;
            }
            case 5: {
                return pSDynaDEFormTemplBase.getPSDynaDEFormTemplId() == null;
            }
            case 6: {
                return pSDynaDEFormTemplBase.getPSDynaDEFormTemplName() == null;
            }
            case 7: {
                return pSDynaDEFormTemplBase.getPSDynaDETemplId() == null;
            }
            case 8: {
                return pSDynaDEFormTemplBase.getPSDynaDETemplName() == null;
            }
            case 9: {
                return pSDynaDEFormTemplBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDynaDEFormTemplBase.getUpdateMan() == null;
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
        return PSDynaDEFormTemplBase.contains(this, n);
    }

    private static boolean contains(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaDEFormTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaDEFormTemplBase.isMemoDirty();
            }
            case 3: {
                return pSDynaDEFormTemplBase.isPSDEFormIdDirty();
            }
            case 4: {
                return pSDynaDEFormTemplBase.isPSDEFormNameDirty();
            }
            case 5: {
                return pSDynaDEFormTemplBase.isPSDynaDEFormTemplIdDirty();
            }
            case 6: {
                return pSDynaDEFormTemplBase.isPSDynaDEFormTemplNameDirty();
            }
            case 7: {
                return pSDynaDEFormTemplBase.isPSDynaDETemplIdDirty();
            }
            case 8: {
                return pSDynaDEFormTemplBase.isPSDynaDETemplNameDirty();
            }
            case 9: {
                return pSDynaDEFormTemplBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDynaDEFormTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDEFormTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDEFormTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformtemplid", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDynaDEFormTemplId()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformtemplname", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDynaDEFormTemplName()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplid", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDynaDETemplId()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplname", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getPSDynaDETemplName()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDEFormTemplBase.getJSONValue((Object)pSDynaDEFormTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDEFormTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDEFormTemplBase.getCreateDate() != null) {
            object = pSDynaDEFormTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormTemplBase.getCreateMan() != null) {
            object = pSDynaDEFormTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getMemo() != null) {
            object = pSDynaDEFormTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDEFormId() != null) {
            object = pSDynaDEFormTemplBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDEFormName() != null) {
            object = pSDynaDEFormTemplBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplId() != null) {
            object = pSDynaDEFormTemplBase.getPSDynaDEFormTemplId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplName() != null) {
            object = pSDynaDEFormTemplBase.getPSDynaDEFormTemplName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDETemplId() != null) {
            object = pSDynaDEFormTemplBase.getPSDynaDETemplId();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getPSDynaDETemplName() != null) {
            object = pSDynaDEFormTemplBase.getPSDynaDETemplName();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormTemplBase.getUpdateDate() != null) {
            object = pSDynaDEFormTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormTemplBase.getUpdateMan() != null) {
            object = pSDynaDEFormTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDEFormTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDEFormTemplBase.isCreateDateDirty() && (bl || pSDynaDEFormTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDEFormTemplBase.getCreateDate());
        }
        if (pSDynaDEFormTemplBase.isCreateManDirty() && (bl || pSDynaDEFormTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDEFormTemplBase.getCreateMan());
        }
        if (pSDynaDEFormTemplBase.isMemoDirty() && (bl || pSDynaDEFormTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDEFormTemplBase.getMemo());
        }
        if (pSDynaDEFormTemplBase.isPSDEFormIdDirty() && (bl || pSDynaDEFormTemplBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDynaDEFormTemplBase.getPSDEFormId());
        }
        if (pSDynaDEFormTemplBase.isPSDEFormNameDirty() && (bl || pSDynaDEFormTemplBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDynaDEFormTemplBase.getPSDEFormName());
        }
        if (pSDynaDEFormTemplBase.isPSDynaDEFormTemplIdDirty() && (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMTEMPLID, (Object)pSDynaDEFormTemplBase.getPSDynaDEFormTemplId());
        }
        if (pSDynaDEFormTemplBase.isPSDynaDEFormTemplNameDirty() && (bl || pSDynaDEFormTemplBase.getPSDynaDEFormTemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMTEMPLNAME, (Object)pSDynaDEFormTemplBase.getPSDynaDEFormTemplName());
        }
        if (pSDynaDEFormTemplBase.isPSDynaDETemplIdDirty() && (bl || pSDynaDEFormTemplBase.getPSDynaDETemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLID, (Object)pSDynaDEFormTemplBase.getPSDynaDETemplId());
        }
        if (pSDynaDEFormTemplBase.isPSDynaDETemplNameDirty() && (bl || pSDynaDEFormTemplBase.getPSDynaDETemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLNAME, (Object)pSDynaDEFormTemplBase.getPSDynaDETemplName());
        }
        if (pSDynaDEFormTemplBase.isUpdateDateDirty() && (bl || pSDynaDEFormTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDEFormTemplBase.getUpdateDate());
        }
        if (pSDynaDEFormTemplBase.isUpdateManDirty() && (bl || pSDynaDEFormTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDEFormTemplBase.getUpdateMan());
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
        return PSDynaDEFormTemplBase.remove(this, n);
    }

    private static boolean remove(PSDynaDEFormTemplBase pSDynaDEFormTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaDEFormTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaDEFormTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaDEFormTemplBase.resetPSDEFormId();
                return true;
            }
            case 4: {
                pSDynaDEFormTemplBase.resetPSDEFormName();
                return true;
            }
            case 5: {
                pSDynaDEFormTemplBase.resetPSDynaDEFormTemplId();
                return true;
            }
            case 6: {
                pSDynaDEFormTemplBase.resetPSDynaDEFormTemplName();
                return true;
            }
            case 7: {
                pSDynaDEFormTemplBase.resetPSDynaDETemplId();
                return true;
            }
            case 8: {
                pSDynaDEFormTemplBase.resetPSDynaDETemplName();
                return true;
            }
            case 9: {
                pSDynaDEFormTemplBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDynaDEFormTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDETempl getPSDynaDETempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETempl();
        }
        if (this.getPSDynaDETemplId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDETemplLock;
        synchronized (n) {
            if (this.psdynadetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDETemplId(), (Object)this.psdynadetempl.getPSDynaDETemplId()) != 0L) {
                this.psdynadetempl = null;
            }
            if (this.psdynadetempl == null) {
                PSDynaDETempl pSDynaDETempl = new PSDynaDETempl();
                pSDynaDETempl.setPSDynaDETemplId(this.getPSDynaDETemplId());
                PSDynaDETemplService pSDynaDETemplService = (PSDynaDETemplService)ServiceGlobal.getService(PSDynaDETemplService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDETemplService.autoGet((IEntity)pSDynaDETempl);
                this.psdynadetempl = pSDynaDETempl;
            }
            return this.psdynadetempl;
        }
    }

    private PSDynaDEFormTemplBase getProxyEntity() {
        return this.proxyPSDynaDEFormTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDEFormTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDEFormTemplBase) {
            this.proxyPSDynaDEFormTemplBase = (PSDynaDEFormTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEFORMID, 3);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 4);
        fieldIndexMap.put(FIELD_PSDYNADEFORMTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSDYNADEFORMTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLID, 7);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

