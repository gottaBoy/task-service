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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDEFormBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDYNADEFORMID = "PSDYNADEFORMID";
    public static final String FIELD_PSDYNADEFORMNAME = "PSDYNADEFORMNAME";
    public static final String FIELD_PSDYNADEID = "PSDYNADEID";
    public static final String FIELD_PSDYNADENAME = "PSDYNADENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEFORMID = 3;
    private static final int INDEX_PSDEFORMNAME = 4;
    private static final int INDEX_PSDYNADEFORMID = 5;
    private static final int INDEX_PSDYNADEFORMNAME = 6;
    private static final int INDEX_PSDYNADEID = 7;
    private static final int INDEX_PSDYNADENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDEFormBase proxyPSDynaDEFormBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdynadeformidDirtyFlag = false;
    private boolean psdynadeformnameDirtyFlag = false;
    private boolean psdynadeidDirtyFlag = false;
    private boolean psdynadenameDirtyFlag = false;
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
    @Column(name="psdynadeformname")
    private String psdynadeformname;
    @Column(name="psdynadeid")
    private String psdynadeid;
    @Column(name="psdynadename")
    private String psdynadename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDynaDELock = new Integer(1);
    private PSDynaDE psdynade = null;
    private Integer objPSDynaDEFormInstLock = new Integer(1);
    private ArrayList<PSDynaDEFormInst> psdynadeforminst = null;

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

    public void setPSDynaDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeid = string;
        this.psdynadeidDirtyFlag = true;
    }

    public String getPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEId();
        }
        return this.psdynadeid;
    }

    public boolean isPSDynaDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEIdDirty();
        }
        return this.psdynadeidDirtyFlag;
    }

    public void resetPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEId();
            return;
        }
        this.psdynadeidDirtyFlag = false;
        this.psdynadeid = null;
    }

    public void setPSDynaDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadename = string;
        this.psdynadenameDirtyFlag = true;
    }

    public String getPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEName();
        }
        return this.psdynadename;
    }

    public boolean isPSDynaDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDENameDirty();
        }
        return this.psdynadenameDirtyFlag;
    }

    public void resetPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEName();
            return;
        }
        this.psdynadenameDirtyFlag = false;
        this.psdynadename = null;
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
        PSDynaDEFormBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDEFormBase pSDynaDEFormBase) {
        pSDynaDEFormBase.resetCreateDate();
        pSDynaDEFormBase.resetCreateMan();
        pSDynaDEFormBase.resetMemo();
        pSDynaDEFormBase.resetPSDEFormId();
        pSDynaDEFormBase.resetPSDEFormName();
        pSDynaDEFormBase.resetPSDynaDEFormId();
        pSDynaDEFormBase.resetPSDynaDEFormName();
        pSDynaDEFormBase.resetPSDynaDEId();
        pSDynaDEFormBase.resetPSDynaDEName();
        pSDynaDEFormBase.resetUpdateDate();
        pSDynaDEFormBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaDEFormNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMNAME, this.getPSDynaDEFormName());
        }
        if (!bl || this.isPSDynaDEIdDirty()) {
            hashMap.put(FIELD_PSDYNADEID, this.getPSDynaDEId());
        }
        if (!bl || this.isPSDynaDENameDirty()) {
            hashMap.put(FIELD_PSDYNADENAME, this.getPSDynaDEName());
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
        return PSDynaDEFormBase.get(this, n);
    }

    private static Object get(PSDynaDEFormBase pSDynaDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormBase.getCreateDate();
            }
            case 1: {
                return pSDynaDEFormBase.getCreateMan();
            }
            case 2: {
                return pSDynaDEFormBase.getMemo();
            }
            case 3: {
                return pSDynaDEFormBase.getPSDEFormId();
            }
            case 4: {
                return pSDynaDEFormBase.getPSDEFormName();
            }
            case 5: {
                return pSDynaDEFormBase.getPSDynaDEFormId();
            }
            case 6: {
                return pSDynaDEFormBase.getPSDynaDEFormName();
            }
            case 7: {
                return pSDynaDEFormBase.getPSDynaDEId();
            }
            case 8: {
                return pSDynaDEFormBase.getPSDynaDEName();
            }
            case 9: {
                return pSDynaDEFormBase.getUpdateDate();
            }
            case 10: {
                return pSDynaDEFormBase.getUpdateMan();
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
        PSDynaDEFormBase.set(this, n, object);
    }

    private static void set(PSDynaDEFormBase pSDynaDEFormBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDEFormBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDEFormBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDEFormBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDEFormBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDEFormBase.setPSDynaDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDEFormBase.setPSDynaDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDEFormBase.setPSDynaDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDEFormBase.setPSDynaDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDEFormBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDynaDEFormBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaDEFormBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDEFormBase pSDynaDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaDEFormBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaDEFormBase.getMemo() == null;
            }
            case 3: {
                return pSDynaDEFormBase.getPSDEFormId() == null;
            }
            case 4: {
                return pSDynaDEFormBase.getPSDEFormName() == null;
            }
            case 5: {
                return pSDynaDEFormBase.getPSDynaDEFormId() == null;
            }
            case 6: {
                return pSDynaDEFormBase.getPSDynaDEFormName() == null;
            }
            case 7: {
                return pSDynaDEFormBase.getPSDynaDEId() == null;
            }
            case 8: {
                return pSDynaDEFormBase.getPSDynaDEName() == null;
            }
            case 9: {
                return pSDynaDEFormBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDynaDEFormBase.getUpdateMan() == null;
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
        return PSDynaDEFormBase.contains(this, n);
    }

    private static boolean contains(PSDynaDEFormBase pSDynaDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEFormBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaDEFormBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaDEFormBase.isMemoDirty();
            }
            case 3: {
                return pSDynaDEFormBase.isPSDEFormIdDirty();
            }
            case 4: {
                return pSDynaDEFormBase.isPSDEFormNameDirty();
            }
            case 5: {
                return pSDynaDEFormBase.isPSDynaDEFormIdDirty();
            }
            case 6: {
                return pSDynaDEFormBase.isPSDynaDEFormNameDirty();
            }
            case 7: {
                return pSDynaDEFormBase.isPSDynaDEIdDirty();
            }
            case 8: {
                return pSDynaDEFormBase.isPSDynaDENameDirty();
            }
            case 9: {
                return pSDynaDEFormBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDynaDEFormBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDEFormBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDEFormBase pSDynaDEFormBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDEFormBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformid", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDynaDEFormId()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformname", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDynaDEFormName()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeid", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDynaDEId()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadename", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getPSDynaDEName()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDEFormBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDEFormBase.getJSONValue((Object)pSDynaDEFormBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDEFormBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDEFormBase pSDynaDEFormBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDEFormBase.getCreateDate() != null) {
            object = pSDynaDEFormBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormBase.getCreateMan() != null) {
            object = pSDynaDEFormBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getMemo() != null) {
            object = pSDynaDEFormBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDEFormId() != null) {
            object = pSDynaDEFormBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDEFormName() != null) {
            object = pSDynaDEFormBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEFormId() != null) {
            object = pSDynaDEFormBase.getPSDynaDEFormId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEFormName() != null) {
            object = pSDynaDEFormBase.getPSDynaDEFormName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEId() != null) {
            object = pSDynaDEFormBase.getPSDynaDEId();
            xmlNode.setAttribute(FIELD_PSDYNADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getPSDynaDEName() != null) {
            object = pSDynaDEFormBase.getPSDynaDEName();
            xmlNode.setAttribute(FIELD_PSDYNADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEFormBase.getUpdateDate() != null) {
            object = pSDynaDEFormBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEFormBase.getUpdateMan() != null) {
            object = pSDynaDEFormBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDEFormBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDEFormBase pSDynaDEFormBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDEFormBase.isCreateDateDirty() && (bl || pSDynaDEFormBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDEFormBase.getCreateDate());
        }
        if (pSDynaDEFormBase.isCreateManDirty() && (bl || pSDynaDEFormBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDEFormBase.getCreateMan());
        }
        if (pSDynaDEFormBase.isMemoDirty() && (bl || pSDynaDEFormBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDEFormBase.getMemo());
        }
        if (pSDynaDEFormBase.isPSDEFormIdDirty() && (bl || pSDynaDEFormBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDynaDEFormBase.getPSDEFormId());
        }
        if (pSDynaDEFormBase.isPSDEFormNameDirty() && (bl || pSDynaDEFormBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDynaDEFormBase.getPSDEFormName());
        }
        if (pSDynaDEFormBase.isPSDynaDEFormIdDirty() && (bl || pSDynaDEFormBase.getPSDynaDEFormId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMID, (Object)pSDynaDEFormBase.getPSDynaDEFormId());
        }
        if (pSDynaDEFormBase.isPSDynaDEFormNameDirty() && (bl || pSDynaDEFormBase.getPSDynaDEFormName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMNAME, (Object)pSDynaDEFormBase.getPSDynaDEFormName());
        }
        if (pSDynaDEFormBase.isPSDynaDEIdDirty() && (bl || pSDynaDEFormBase.getPSDynaDEId() != null)) {
            iDataObject.set(FIELD_PSDYNADEID, (Object)pSDynaDEFormBase.getPSDynaDEId());
        }
        if (pSDynaDEFormBase.isPSDynaDENameDirty() && (bl || pSDynaDEFormBase.getPSDynaDEName() != null)) {
            iDataObject.set(FIELD_PSDYNADENAME, (Object)pSDynaDEFormBase.getPSDynaDEName());
        }
        if (pSDynaDEFormBase.isUpdateDateDirty() && (bl || pSDynaDEFormBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDEFormBase.getUpdateDate());
        }
        if (pSDynaDEFormBase.isUpdateManDirty() && (bl || pSDynaDEFormBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDEFormBase.getUpdateMan());
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
        return PSDynaDEFormBase.remove(this, n);
    }

    private static boolean remove(PSDynaDEFormBase pSDynaDEFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEFormBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaDEFormBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaDEFormBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaDEFormBase.resetPSDEFormId();
                return true;
            }
            case 4: {
                pSDynaDEFormBase.resetPSDEFormName();
                return true;
            }
            case 5: {
                pSDynaDEFormBase.resetPSDynaDEFormId();
                return true;
            }
            case 6: {
                pSDynaDEFormBase.resetPSDynaDEFormName();
                return true;
            }
            case 7: {
                pSDynaDEFormBase.resetPSDynaDEId();
                return true;
            }
            case 8: {
                pSDynaDEFormBase.resetPSDynaDEName();
                return true;
            }
            case 9: {
                pSDynaDEFormBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDynaDEFormBase.resetUpdateMan();
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
    public PSDynaDE getPSDynaDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDE();
        }
        if (this.getPSDynaDEId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDELock;
        synchronized (n) {
            if (this.psdynade != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEId(), (Object)this.psdynade.getPSDynaDEId()) != 0L) {
                this.psdynade = null;
            }
            if (this.psdynade == null) {
                PSDynaDE pSDynaDE = new PSDynaDE();
                pSDynaDE.setPSDynaDEId(this.getPSDynaDEId());
                PSDynaDEService pSDynaDEService = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEService.autoGet((IEntity)pSDynaDE);
                this.psdynade = pSDynaDE;
            }
            return this.psdynade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDEFormInst> getPSDynaDEFormInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInst();
        }
        if (this.getPSDynaDEFormId() == null) {
            return null;
        }
        PSDynaDEFormInstService pSDynaDEFormInstService = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEFormInstLock;
        synchronized (n) {
            if (this.psdynadeforminst == null) {
                this.psdynadeforminst = pSDynaDEFormInstService.selectByPSDynaDEForm(this);
            }
            return this.psdynadeforminst;
        }
    }

    private PSDynaDEFormBase getProxyEntity() {
        return this.proxyPSDynaDEFormBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDEFormBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDEFormBase) {
            this.proxyPSDynaDEFormBase = (PSDynaDEFormBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDYNADEFORMNAME, 6);
        fieldIndexMap.put(FIELD_PSDYNADEID, 7);
        fieldIndexMap.put(FIELD_PSDYNADENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

