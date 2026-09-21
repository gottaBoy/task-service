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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewCtrlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewCtrlBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAAPPVIEWCTRLID = "PSDYNAAPPVIEWCTRLID";
    public static final String FIELD_PSDYNAAPPVIEWCTRLNAME = "PSDYNAAPPVIEWCTRLNAME";
    public static final String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    public static final String FIELD_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    public static final String FIELD_PSDYNADEFORMID = "PSDYNADEFORMID";
    public static final String FIELD_PSDYNADEFORMNAME = "PSDYNADEFORMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNAAPPVIEWCTRLID = 4;
    private static final int INDEX_PSDYNAAPPVIEWCTRLNAME = 5;
    private static final int INDEX_PSDYNAAPPVIEWID = 6;
    private static final int INDEX_PSDYNAAPPVIEWNAME = 7;
    private static final int INDEX_PSDYNADEFORMID = 8;
    private static final int INDEX_PSDYNADEFORMNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppViewCtrlBase proxyPSDynaAppViewCtrlBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynaappviewctrlidDirtyFlag = false;
    private boolean psdynaappviewctrlnameDirtyFlag = false;
    private boolean psdynaappviewidDirtyFlag = false;
    private boolean psdynaappviewnameDirtyFlag = false;
    private boolean psdynadeformidDirtyFlag = false;
    private boolean psdynadeformnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynaappviewctrlid")
    private String psdynaappviewctrlid;
    @Column(name="psdynaappviewctrlname")
    private String psdynaappviewctrlname;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;
    @Column(name="psdynaappviewname")
    private String psdynaappviewname;
    @Column(name="psdynadeformid")
    private String psdynadeformid;
    @Column(name="psdynadeformname")
    private String psdynadeformname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDynaAppViewLock = new Integer(1);
    private PSDynaAppView psdynaappview = null;
    private Integer objPSDynaDEFormLock = new Integer(1);
    private PSDynaDEForm psdynadeform = null;

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

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
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

    public void setPSDynaAppViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewctrlid = string;
        this.psdynaappviewctrlidDirtyFlag = true;
    }

    public String getPSDynaAppViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewCtrlId();
        }
        return this.psdynaappviewctrlid;
    }

    public boolean isPSDynaAppViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewCtrlIdDirty();
        }
        return this.psdynaappviewctrlidDirtyFlag;
    }

    public void resetPSDynaAppViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewCtrlId();
            return;
        }
        this.psdynaappviewctrlidDirtyFlag = false;
        this.psdynaappviewctrlid = null;
    }

    public void setPSDynaAppViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewctrlname = string;
        this.psdynaappviewctrlnameDirtyFlag = true;
    }

    public String getPSDynaAppViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewCtrlName();
        }
        return this.psdynaappviewctrlname;
    }

    public boolean isPSDynaAppViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewCtrlNameDirty();
        }
        return this.psdynaappviewctrlnameDirtyFlag;
    }

    public void resetPSDynaAppViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewCtrlName();
            return;
        }
        this.psdynaappviewctrlnameDirtyFlag = false;
        this.psdynaappviewctrlname = null;
    }

    public void setPSDynaAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewid = string;
        this.psdynaappviewidDirtyFlag = true;
    }

    public String getPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    public boolean isPSDynaAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    public void resetPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

    public void setPSDynaAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewname = string;
        this.psdynaappviewnameDirtyFlag = true;
    }

    public String getPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewName();
        }
        return this.psdynaappviewname;
    }

    public boolean isPSDynaAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewNameDirty();
        }
        return this.psdynaappviewnameDirtyFlag;
    }

    public void resetPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewName();
            return;
        }
        this.psdynaappviewnameDirtyFlag = false;
        this.psdynaappviewname = null;
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
        PSDynaAppViewCtrlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase) {
        pSDynaAppViewCtrlBase.resetCreateDate();
        pSDynaAppViewCtrlBase.resetCreateMan();
        pSDynaAppViewCtrlBase.resetCtrlType();
        pSDynaAppViewCtrlBase.resetMemo();
        pSDynaAppViewCtrlBase.resetPSDynaAppViewCtrlId();
        pSDynaAppViewCtrlBase.resetPSDynaAppViewCtrlName();
        pSDynaAppViewCtrlBase.resetPSDynaAppViewId();
        pSDynaAppViewCtrlBase.resetPSDynaAppViewName();
        pSDynaAppViewCtrlBase.resetPSDynaDEFormId();
        pSDynaAppViewCtrlBase.resetPSDynaDEFormName();
        pSDynaAppViewCtrlBase.resetUpdateDate();
        pSDynaAppViewCtrlBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaAppViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWCTRLID, this.getPSDynaAppViewCtrlId());
        }
        if (!bl || this.isPSDynaAppViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWCTRLNAME, this.getPSDynaAppViewCtrlName());
        }
        if (!bl || this.isPSDynaAppViewIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWID, this.getPSDynaAppViewId());
        }
        if (!bl || this.isPSDynaAppViewNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWNAME, this.getPSDynaAppViewName());
        }
        if (!bl || this.isPSDynaDEFormIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMID, this.getPSDynaDEFormId());
        }
        if (!bl || this.isPSDynaDEFormNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMNAME, this.getPSDynaDEFormName());
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
        return PSDynaAppViewCtrlBase.get(this, n);
    }

    private static Object get(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewCtrlBase.getCreateDate();
            }
            case 1: {
                return pSDynaAppViewCtrlBase.getCreateMan();
            }
            case 2: {
                return pSDynaAppViewCtrlBase.getCtrlType();
            }
            case 3: {
                return pSDynaAppViewCtrlBase.getMemo();
            }
            case 4: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId();
            }
            case 5: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName();
            }
            case 6: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewId();
            }
            case 7: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewName();
            }
            case 8: {
                return pSDynaAppViewCtrlBase.getPSDynaDEFormId();
            }
            case 9: {
                return pSDynaAppViewCtrlBase.getPSDynaDEFormName();
            }
            case 10: {
                return pSDynaAppViewCtrlBase.getUpdateDate();
            }
            case 11: {
                return pSDynaAppViewCtrlBase.getUpdateMan();
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
        PSDynaAppViewCtrlBase.set(this, n, object);
    }

    private static void set(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewCtrlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaAppViewCtrlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaAppViewCtrlBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaAppViewCtrlBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaAppViewCtrlBase.setPSDynaAppViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaAppViewCtrlBase.setPSDynaAppViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaAppViewCtrlBase.setPSDynaAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaAppViewCtrlBase.setPSDynaAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaAppViewCtrlBase.setPSDynaDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaAppViewCtrlBase.setPSDynaDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaAppViewCtrlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDynaAppViewCtrlBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaAppViewCtrlBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewCtrlBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaAppViewCtrlBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaAppViewCtrlBase.getCtrlType() == null;
            }
            case 3: {
                return pSDynaAppViewCtrlBase.getMemo() == null;
            }
            case 4: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId() == null;
            }
            case 5: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName() == null;
            }
            case 6: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewId() == null;
            }
            case 7: {
                return pSDynaAppViewCtrlBase.getPSDynaAppViewName() == null;
            }
            case 8: {
                return pSDynaAppViewCtrlBase.getPSDynaDEFormId() == null;
            }
            case 9: {
                return pSDynaAppViewCtrlBase.getPSDynaDEFormName() == null;
            }
            case 10: {
                return pSDynaAppViewCtrlBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDynaAppViewCtrlBase.getUpdateMan() == null;
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
        return PSDynaAppViewCtrlBase.contains(this, n);
    }

    private static boolean contains(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewCtrlBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaAppViewCtrlBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaAppViewCtrlBase.isCtrlTypeDirty();
            }
            case 3: {
                return pSDynaAppViewCtrlBase.isMemoDirty();
            }
            case 4: {
                return pSDynaAppViewCtrlBase.isPSDynaAppViewCtrlIdDirty();
            }
            case 5: {
                return pSDynaAppViewCtrlBase.isPSDynaAppViewCtrlNameDirty();
            }
            case 6: {
                return pSDynaAppViewCtrlBase.isPSDynaAppViewIdDirty();
            }
            case 7: {
                return pSDynaAppViewCtrlBase.isPSDynaAppViewNameDirty();
            }
            case 8: {
                return pSDynaAppViewCtrlBase.isPSDynaDEFormIdDirty();
            }
            case 9: {
                return pSDynaAppViewCtrlBase.isPSDynaDEFormNameDirty();
            }
            case 10: {
                return pSDynaAppViewCtrlBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDynaAppViewCtrlBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaAppViewCtrlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaAppViewCtrlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewctrlid", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewctrlname", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewid", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaAppViewId()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewname", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaAppViewName()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformid", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaDEFormId()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeformname", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getPSDynaDEFormName()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewCtrlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaAppViewCtrlBase.getJSONValue((Object)pSDynaAppViewCtrlBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaAppViewCtrlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaAppViewCtrlBase.getCreateDate() != null) {
            object = pSDynaAppViewCtrlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewCtrlBase.getCreateMan() != null) {
            object = pSDynaAppViewCtrlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getCtrlType() != null) {
            object = pSDynaAppViewCtrlBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getMemo() != null) {
            object = pSDynaAppViewCtrlBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewId() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaAppViewId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewName() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaAppViewName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormId() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaDEFormId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormName() != null) {
            object = pSDynaAppViewCtrlBase.getPSDynaDEFormName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewCtrlBase.getUpdateDate() != null) {
            object = pSDynaAppViewCtrlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewCtrlBase.getUpdateMan() != null) {
            object = pSDynaAppViewCtrlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaAppViewCtrlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaAppViewCtrlBase.isCreateDateDirty() && (bl || pSDynaAppViewCtrlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaAppViewCtrlBase.getCreateDate());
        }
        if (pSDynaAppViewCtrlBase.isCreateManDirty() && (bl || pSDynaAppViewCtrlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaAppViewCtrlBase.getCreateMan());
        }
        if (pSDynaAppViewCtrlBase.isCtrlTypeDirty() && (bl || pSDynaAppViewCtrlBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSDynaAppViewCtrlBase.getCtrlType());
        }
        if (pSDynaAppViewCtrlBase.isMemoDirty() && (bl || pSDynaAppViewCtrlBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaAppViewCtrlBase.getMemo());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaAppViewCtrlIdDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWCTRLID, (Object)pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaAppViewCtrlNameDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWCTRLNAME, (Object)pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlName());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaAppViewIdDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWID, (Object)pSDynaAppViewCtrlBase.getPSDynaAppViewId());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaAppViewNameDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaAppViewName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWNAME, (Object)pSDynaAppViewCtrlBase.getPSDynaAppViewName());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaDEFormIdDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMID, (Object)pSDynaAppViewCtrlBase.getPSDynaDEFormId());
        }
        if (pSDynaAppViewCtrlBase.isPSDynaDEFormNameDirty() && (bl || pSDynaAppViewCtrlBase.getPSDynaDEFormName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMNAME, (Object)pSDynaAppViewCtrlBase.getPSDynaDEFormName());
        }
        if (pSDynaAppViewCtrlBase.isUpdateDateDirty() && (bl || pSDynaAppViewCtrlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaAppViewCtrlBase.getUpdateDate());
        }
        if (pSDynaAppViewCtrlBase.isUpdateManDirty() && (bl || pSDynaAppViewCtrlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaAppViewCtrlBase.getUpdateMan());
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
        return PSDynaAppViewCtrlBase.remove(this, n);
    }

    private static boolean remove(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewCtrlBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaAppViewCtrlBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaAppViewCtrlBase.resetCtrlType();
                return true;
            }
            case 3: {
                pSDynaAppViewCtrlBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaAppViewCtrlBase.resetPSDynaAppViewCtrlId();
                return true;
            }
            case 5: {
                pSDynaAppViewCtrlBase.resetPSDynaAppViewCtrlName();
                return true;
            }
            case 6: {
                pSDynaAppViewCtrlBase.resetPSDynaAppViewId();
                return true;
            }
            case 7: {
                pSDynaAppViewCtrlBase.resetPSDynaAppViewName();
                return true;
            }
            case 8: {
                pSDynaAppViewCtrlBase.resetPSDynaDEFormId();
                return true;
            }
            case 9: {
                pSDynaAppViewCtrlBase.resetPSDynaDEFormName();
                return true;
            }
            case 10: {
                pSDynaAppViewCtrlBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDynaAppViewCtrlBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaAppView getPSDynaAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppView();
        }
        if (this.getPSDynaAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppViewLock;
        synchronized (n) {
            if (this.psdynaappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppViewId(), (Object)this.psdynaappview.getPSDynaAppViewId()) != 0L) {
                this.psdynaappview = null;
            }
            if (this.psdynaappview == null) {
                PSDynaAppView pSDynaAppView = new PSDynaAppView();
                pSDynaAppView.setPSDynaAppViewId(this.getPSDynaAppViewId());
                PSDynaAppViewService pSDynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppViewService.autoGet((IEntity)pSDynaAppView);
                this.psdynaappview = pSDynaAppView;
            }
            return this.psdynaappview;
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
                pSDynaDEFormService.autoGet((IEntity)pSDynaDEForm);
                this.psdynadeform = pSDynaDEForm;
            }
            return this.psdynadeform;
        }
    }

    private PSDynaAppViewCtrlBase getProxyEntity() {
        return this.proxyPSDynaAppViewCtrlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaAppViewCtrlBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaAppViewCtrlBase) {
            this.proxyPSDynaAppViewCtrlBase = (PSDynaAppViewCtrlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWCTRLID, 4);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWCTRLNAME, 5);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWID, 6);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNADEFORMID, 8);
        fieldIndexMap.put(FIELD_PSDYNADEFORMNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

