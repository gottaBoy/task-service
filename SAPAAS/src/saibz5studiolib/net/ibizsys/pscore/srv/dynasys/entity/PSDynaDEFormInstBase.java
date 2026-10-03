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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDEFormInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDYNADEFORMID = "PSDYNADEFORMID";
    public static final String FIELD_PSDYNADEFORMINSTID = "PSDYNADEFORMINSTID";
    public static final String FIELD_PSDYNADEFORMINSTNAME = "PSDYNADEFORMINSTNAME";
    public static final String FIELD_PSDYNADEFORMNAME = "PSDYNADEFORMNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEFORMID = 3;
    private static final int INDEX_PSDEFORMNAME = 4;
    private static final int INDEX_PSDYNADEFORMID = 5;
    private static final int INDEX_PSDYNADEFORMINSTID = 6;
    private static final int INDEX_PSDYNADEFORMINSTNAME = 7;
    private static final int INDEX_PSDYNADEFORMNAME = 8;
    private static final int INDEX_PSDYNAINSTID = 9;
    private static final int INDEX_PSDYNAINSTNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDEFormInstBase proxyPSDynaDEFormInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdynadeformidDirtyFlag = false;
    private boolean psdynadeforminstidDirtyFlag = false;
    private boolean psdynadeforminstnameDirtyFlag = false;
    private boolean psdynadeformnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
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
    @Column(name="psdynadeformid")
    private String psdynadeformid;
    @Column(name="psdynadeforminstid")
    private String psdynadeforminstid;
    @Column(name="psdynadeforminstname")
    private String psdynadeforminstname;
    @Column(name="psdynadeformname")
    private String psdynadeformname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDynaDEFormLock = new Integer(1);
    private PSDynaDEForm psdynadeform = null;
    private Integer objPSDynaInstLock = new Integer(1);
    private PSDynaInst psdynainst = null;

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

    public void setPSDynaDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformid = string;
        this.psdynadeformidDirtyFlag = true;
    }

    public String getPSDynaDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormId();
        }
        return this.psdynadeformid;
    }

    public boolean isPSDynaDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormIdDirty();
        }
        return this.psdynadeformidDirtyFlag;
    }

    public void resetPSDynaDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormId();
            return;
        }
        this.psdynadeformidDirtyFlag = false;
        this.psdynadeformid = null;
    }

    public void setPSDynaDEFormInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeforminstid = string;
        this.psdynadeforminstidDirtyFlag = true;
    }

    public String getPSDynaDEFormInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInstId();
        }
        return this.psdynadeforminstid;
    }

    public boolean isPSDynaDEFormInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormInstIdDirty();
        }
        return this.psdynadeforminstidDirtyFlag;
    }

    public void resetPSDynaDEFormInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormInstId();
            return;
        }
        this.psdynadeforminstidDirtyFlag = false;
        this.psdynadeforminstid = null;
    }

    public void setPSDynaDEFormInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeforminstname = string;
        this.psdynadeforminstnameDirtyFlag = true;
    }

    public String getPSDynaDEFormInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInstName();
        }
        return this.psdynadeforminstname;
    }

    public boolean isPSDynaDEFormInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormInstNameDirty();
        }
        return this.psdynadeforminstnameDirtyFlag;
    }

    public void resetPSDynaDEFormInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormInstName();
            return;
        }
        this.psdynadeforminstnameDirtyFlag = false;
        this.psdynadeforminstname = null;
    }

    public void setPSDynaDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeformname = string;
        this.psdynadeformnameDirtyFlag = true;
    }

    public String getPSDynaDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormName();
        }
        return this.psdynadeformname;
    }

    public boolean isPSDynaDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEFormNameDirty();
        }
        return this.psdynadeformnameDirtyFlag;
    }

    public void resetPSDynaDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEFormName();
            return;
        }
        this.psdynadeformnameDirtyFlag = false;
        this.psdynadeformname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
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
        PSDynaDEFormInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDEFormInstBase pSDynaDEFormInstBase) {
        pSDynaDEFormInstBase.resetCreateDate();
        pSDynaDEFormInstBase.resetCreateMan();
        pSDynaDEFormInstBase.resetMemo();
        pSDynaDEFormInstBase.resetPSDEFormId();
        pSDynaDEFormInstBase.resetPSDEFormName();
        pSDynaDEFormInstBase.resetPSDynaDEFormId();
        pSDynaDEFormInstBase.resetPSDynaDEFormInstId();
        pSDynaDEFormInstBase.resetPSDynaDEFormInstName();
        pSDynaDEFormInstBase.resetPSDynaDEFormName();
        pSDynaDEFormInstBase.resetPSDynaInstId();
        pSDynaDEFormInstBase.resetPSDynaInstName();
        pSDynaDEFormInstBase.resetUpdateDate();
        pSDynaDEFormInstBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaDEFormIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMID, this.getPSDynaDEFormId());
        }
        if (!bl || this.isPSDynaDEFormInstIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTID, this.getPSDynaDEFormInstId());
        }
        if (!bl || this.isPSDynaDEFormInstNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTNAME, this.getPSDynaDEFormInstName());
        }
        if (!bl || this.isPSDynaDEFormNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMNAME, this.getPSDynaDEFormName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
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
        return PSDynaDEFormInstBase.get(this, n);
    }

    private static Object get(PSDynaDEFormInstBase pSDynaDEFormInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormInstBase.getCreateDate();
            }
            case 1: {
                return pSDynaDEFormInstBase.getCreateMan();
            }
            case 2: {
                return pSDynaDEFormInstBase.getMemo();
            }
            case 3: {
                return pSDynaDEFormInstBase.getPSDEFormId();
            }
            case 4: {
                return pSDynaDEFormInstBase.getPSDEFormName();
            }
            case 5: {
                return pSDynaDEFormInstBase.getPSDynaDEFormId();
            }
            case 6: {
                return pSDynaDEFormInstBase.getPSDynaDEFormInstId();
            }
            case 7: {
                return pSDynaDEFormInstBase.getPSDynaDEFormInstName();
            }
            case 8: {
                return pSDynaDEFormInstBase.getPSDynaDEFormName();
            }
            case 9: {
                return pSDynaDEFormInstBase.getPSDynaInstId();
            }
            case 10: {
                return pSDynaDEFormInstBase.getPSDynaInstName();
            }
            case 11: {
                return pSDynaDEFormInstBase.getUpdateDate();
            }
            case 12: {
                return pSDynaDEFormInstBase.getUpdateMan();
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
        PSDynaDEFormInstBase.set(this, n, object);
    }

    private static void set(PSDynaDEFormInstBase pSDynaDEFormInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDEFormInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDEFormInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDEFormInstBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDEFormInstBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDEFormInstBase.setPSDynaDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDEFormInstBase.setPSDynaDEFormInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDEFormInstBase.setPSDynaDEFormInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDEFormInstBase.setPSDynaDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDEFormInstBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaDEFormInstBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaDEFormInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDynaDEFormInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaDEFormInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDEFormInstBase pSDynaDEFormInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaDEFormInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaDEFormInstBase.getMemo() == null;
            }
            case 3: {
                return pSDynaDEFormInstBase.getPSDEFormId() == null;
            }
            case 4: {
                return pSDynaDEFormInstBase.getPSDEFormName() == null;
            }
            case 5: {
                return pSDynaDEFormInstBase.getPSDynaDEFormId() == null;
            }
            case 6: {
                return pSDynaDEFormInstBase.getPSDynaDEFormInstId() == null;
            }
            case 7: {
                return pSDynaDEFormInstBase.getPSDynaDEFormInstName() == null;
            }
            case 8: {
                return pSDynaDEFormInstBase.getPSDynaDEFormName() == null;
            }
            case 9: {
                return pSDynaDEFormInstBase.getPSDynaInstId() == null;
            }
            case 10: {
                return pSDynaDEFormInstBase.getPSDynaInstName() == null;
            }
            case 11: {
                return pSDynaDEFormInstBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDynaDEFormInstBase.getUpdateMan() == null;
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
        return PSDynaDEFormInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaDEFormInstBase pSDynaDEFormInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaDEFormInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaDEFormInstBase.isMemoDirty();
            }
            case 3: {
                return pSDynaDEFormInstBase.isPSDEFormIdDirty();
            }
            case 4: {
                return pSDynaDEFormInstBase.isPSDEFormNameDirty();
            }
            case 5: {
                return pSDynaDEFormInstBase.isPSDynaDEFormIdDirty();
            }
            case 6: {
                return pSDynaDEFormInstBase.isPSDynaDEFormInstIdDirty();
            }
            case 7: {
                return pSDynaDEFormInstBase.isPSDynaDEFormInstNameDirty();
            }
            case 8: {
                return pSDynaDEFormInstBase.isPSDynaDEFormNameDirty();
            }
            case 9: {
                return pSDynaDEFormInstBase.isPSDynaInstIdDirty();
            }
            case 10: {
                return pSDynaDEFormInstBase.isPSDynaInstNameDirty();
            }
            case 11: {
                return pSDynaDEFormInstBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDynaDEFormInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDEFormInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDEFormInstBase pSDynaDEFormInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDEFormInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformid", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaDEFormId()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstid", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaDEFormInstId()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstname", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaDEFormInstName()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformname", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaDEFormName()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDEFormInstBase.getJSONValue((Object)pSDynaDEFormInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDEFormInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDEFormInstBase pSDynaDEFormInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDEFormInstBase.getCreateDate() != null) {
            object = pSDynaDEFormInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormInstBase.getCreateMan() != null) {
            object = pSDynaDEFormInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getMemo() != null) {
            object = pSDynaDEFormInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDEFormId() != null) {
            object = pSDynaDEFormInstBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDEFormName() != null) {
            object = pSDynaDEFormInstBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormId() != null) {
            object = pSDynaDEFormInstBase.getPSDynaDEFormId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstId() != null) {
            object = pSDynaDEFormInstBase.getPSDynaDEFormInstId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstName() != null) {
            object = pSDynaDEFormInstBase.getPSDynaDEFormInstName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaDEFormName() != null) {
            object = pSDynaDEFormInstBase.getPSDynaDEFormName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaInstId() != null) {
            object = pSDynaDEFormInstBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getPSDynaInstName() != null) {
            object = pSDynaDEFormInstBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormInstBase.getUpdateDate() != null) {
            object = pSDynaDEFormInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormInstBase.getUpdateMan() != null) {
            object = pSDynaDEFormInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDEFormInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDEFormInstBase pSDynaDEFormInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDEFormInstBase.isCreateDateDirty() && (bl || pSDynaDEFormInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDEFormInstBase.getCreateDate());
        }
        if (pSDynaDEFormInstBase.isCreateManDirty() && (bl || pSDynaDEFormInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDEFormInstBase.getCreateMan());
        }
        if (pSDynaDEFormInstBase.isMemoDirty() && (bl || pSDynaDEFormInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDEFormInstBase.getMemo());
        }
        if (pSDynaDEFormInstBase.isPSDEFormIdDirty() && (bl || pSDynaDEFormInstBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDynaDEFormInstBase.getPSDEFormId());
        }
        if (pSDynaDEFormInstBase.isPSDEFormNameDirty() && (bl || pSDynaDEFormInstBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDynaDEFormInstBase.getPSDEFormName());
        }
        if (pSDynaDEFormInstBase.isPSDynaDEFormIdDirty() && (bl || pSDynaDEFormInstBase.getPSDynaDEFormId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMID, (Object)pSDynaDEFormInstBase.getPSDynaDEFormId());
        }
        if (pSDynaDEFormInstBase.isPSDynaDEFormInstIdDirty() && (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTID, (Object)pSDynaDEFormInstBase.getPSDynaDEFormInstId());
        }
        if (pSDynaDEFormInstBase.isPSDynaDEFormInstNameDirty() && (bl || pSDynaDEFormInstBase.getPSDynaDEFormInstName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTNAME, (Object)pSDynaDEFormInstBase.getPSDynaDEFormInstName());
        }
        if (pSDynaDEFormInstBase.isPSDynaDEFormNameDirty() && (bl || pSDynaDEFormInstBase.getPSDynaDEFormName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMNAME, (Object)pSDynaDEFormInstBase.getPSDynaDEFormName());
        }
        if (pSDynaDEFormInstBase.isPSDynaInstIdDirty() && (bl || pSDynaDEFormInstBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaDEFormInstBase.getPSDynaInstId());
        }
        if (pSDynaDEFormInstBase.isPSDynaInstNameDirty() && (bl || pSDynaDEFormInstBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDynaDEFormInstBase.getPSDynaInstName());
        }
        if (pSDynaDEFormInstBase.isUpdateDateDirty() && (bl || pSDynaDEFormInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDEFormInstBase.getUpdateDate());
        }
        if (pSDynaDEFormInstBase.isUpdateManDirty() && (bl || pSDynaDEFormInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDEFormInstBase.getUpdateMan());
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
        return PSDynaDEFormInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaDEFormInstBase pSDynaDEFormInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaDEFormInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaDEFormInstBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaDEFormInstBase.resetPSDEFormId();
                return true;
            }
            case 4: {
                pSDynaDEFormInstBase.resetPSDEFormName();
                return true;
            }
            case 5: {
                pSDynaDEFormInstBase.resetPSDynaDEFormId();
                return true;
            }
            case 6: {
                pSDynaDEFormInstBase.resetPSDynaDEFormInstId();
                return true;
            }
            case 7: {
                pSDynaDEFormInstBase.resetPSDynaDEFormInstName();
                return true;
            }
            case 8: {
                pSDynaDEFormInstBase.resetPSDynaDEFormName();
                return true;
            }
            case 9: {
                pSDynaDEFormInstBase.resetPSDynaInstId();
                return true;
            }
            case 10: {
                pSDynaDEFormInstBase.resetPSDynaInstName();
                return true;
            }
            case 11: {
                pSDynaDEFormInstBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDynaDEFormInstBase.resetUpdateMan();
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
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDEForm getPSDynaDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEForm();
        }
        if (this.getPSDynaDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDEFormLock;
        synchronized (n) {
            if (this.psdynadeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEFormId(), (Object)this.psdynadeform.getPSDynaDEFormId()) != 0L) {
                this.psdynadeform = null;
            }
            if (this.psdynadeform == null) {
                PSDynaDEForm pSDynaDEForm = new PSDynaDEForm();
                pSDynaDEForm.setPSDynaDEFormId(this.getPSDynaDEFormId());
                PSDynaDEFormService pSDynaDEFormService = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEFormService.autoGet(pSDynaDEForm);
                this.psdynadeform = pSDynaDEForm;
            }
            return this.psdynadeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaInst getPSDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInst();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaInstLock;
        synchronized (n) {
            if (this.psdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaInstId(), (Object)this.psdynainst.getPSDynaInstId()) != 0L) {
                this.psdynainst = null;
            }
            if (this.psdynainst == null) {
                PSDynaInst pSDynaInst = new PSDynaInst();
                pSDynaInst.setPSDynaInstId(this.getPSDynaInstId());
                PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaInstService.autoGet(pSDynaInst);
                this.psdynainst = pSDynaInst;
            }
            return this.psdynainst;
        }
    }

    private PSDynaDEFormInstBase getProxyEntity() {
        return this.proxyPSDynaDEFormInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDEFormInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDEFormInstBase) {
            this.proxyPSDynaDEFormInstBase = (PSDynaDEFormInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEFORMID, 3);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 4);
        fieldIndexMap.put(FIELD_PSDYNADEFORMID, 5);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTID, 6);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNADEFORMNAME, 8);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 9);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

