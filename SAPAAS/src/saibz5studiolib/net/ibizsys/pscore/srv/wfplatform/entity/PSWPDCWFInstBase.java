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
package net.ibizsys.pscore.srv.wfplatform.entity;

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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWorkflow;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCWFInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCWFInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPDCAPPENTITYID = "PSWPDCAPPENTITYID";
    public static final String FIELD_PSWPDCAPPENTITYNAME = "PSWPDCAPPENTITYNAME";
    public static final String FIELD_PSWPDCWFINSTID = "PSWPDCWFINSTID";
    public static final String FIELD_PSWPDCWFINSTNAME = "PSWPDCWFINSTNAME";
    public static final String FIELD_PSWPDCWORKFLOWID = "PSWPDCWORKFLOWID";
    public static final String FIELD_PSWPDCWORKFLOWNAME = "PSWPDCWORKFLOWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFINSTSN = "WFINSTSN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPDCAPPENTITYID = 2;
    private static final int INDEX_PSWPDCAPPENTITYNAME = 3;
    private static final int INDEX_PSWPDCWFINSTID = 4;
    private static final int INDEX_PSWPDCWFINSTNAME = 5;
    private static final int INDEX_PSWPDCWORKFLOWID = 6;
    private static final int INDEX_PSWPDCWORKFLOWNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_WFINSTSN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCWFInstBase proxyPSWPDCWFInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpdcappentityidDirtyFlag = false;
    private boolean pswpdcappentitynameDirtyFlag = false;
    private boolean pswpdcwfinstidDirtyFlag = false;
    private boolean pswpdcwfinstnameDirtyFlag = false;
    private boolean pswpdcworkflowidDirtyFlag = false;
    private boolean pswpdcworkflownameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfinstsnDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpdcappentityid")
    private String pswpdcappentityid;
    @Column(name="pswpdcappentityname")
    private String pswpdcappentityname;
    @Column(name="pswpdcwfinstid")
    private String pswpdcwfinstid;
    @Column(name="pswpdcwfinstname")
    private String pswpdcwfinstname;
    @Column(name="pswpdcworkflowid")
    private String pswpdcworkflowid;
    @Column(name="pswpdcworkflowname")
    private String pswpdcworkflowname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfinstsn")
    private String wfinstsn;
    private Integer objPswpdcappentityLock = new Integer(1);
    private PSWPDCAppEntity pswpdcappentity = null;
    private Integer objPswpdcworkflowLock = new Integer(1);
    private PSWPDCWorkflow pswpdcworkflow = null;

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

    public void setPSWPDCAppEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappentityid = string;
        this.pswpdcappentityidDirtyFlag = true;
    }

    public String getPSWPDCAppEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppEntityId();
        }
        return this.pswpdcappentityid;
    }

    public boolean isPSWPDCAppEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppEntityIdDirty();
        }
        return this.pswpdcappentityidDirtyFlag;
    }

    public void resetPSWPDCAppEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppEntityId();
            return;
        }
        this.pswpdcappentityidDirtyFlag = false;
        this.pswpdcappentityid = null;
    }

    public void setPSWPDCAppEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappentityname = string;
        this.pswpdcappentitynameDirtyFlag = true;
    }

    public String getPSWPDCAppEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppEntityName();
        }
        return this.pswpdcappentityname;
    }

    public boolean isPSWPDCAppEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppEntityNameDirty();
        }
        return this.pswpdcappentitynameDirtyFlag;
    }

    public void resetPSWPDCAppEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppEntityName();
            return;
        }
        this.pswpdcappentitynameDirtyFlag = false;
        this.pswpdcappentityname = null;
    }

    public void setPSWPDCWFInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWFInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcwfinstid = string;
        this.pswpdcwfinstidDirtyFlag = true;
    }

    public String getPSWPDCWFInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWFInstId();
        }
        return this.pswpdcwfinstid;
    }

    public boolean isPSWPDCWFInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWFInstIdDirty();
        }
        return this.pswpdcwfinstidDirtyFlag;
    }

    public void resetPSWPDCWFInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWFInstId();
            return;
        }
        this.pswpdcwfinstidDirtyFlag = false;
        this.pswpdcwfinstid = null;
    }

    public void setPSWPDCWFInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWFInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcwfinstname = string;
        this.pswpdcwfinstnameDirtyFlag = true;
    }

    public String getPSWPDCWFInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWFInstName();
        }
        return this.pswpdcwfinstname;
    }

    public boolean isPSWPDCWFInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWFInstNameDirty();
        }
        return this.pswpdcwfinstnameDirtyFlag;
    }

    public void resetPSWPDCWFInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWFInstName();
            return;
        }
        this.pswpdcwfinstnameDirtyFlag = false;
        this.pswpdcwfinstname = null;
    }

    public void setPSWPDCWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcworkflowid = string;
        this.pswpdcworkflowidDirtyFlag = true;
    }

    public String getPSWPDCWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWorkflowId();
        }
        return this.pswpdcworkflowid;
    }

    public boolean isPSWPDCWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWorkflowIdDirty();
        }
        return this.pswpdcworkflowidDirtyFlag;
    }

    public void resetPSWPDCWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWorkflowId();
            return;
        }
        this.pswpdcworkflowidDirtyFlag = false;
        this.pswpdcworkflowid = null;
    }

    public void setPSWPDCWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcworkflowname = string;
        this.pswpdcworkflownameDirtyFlag = true;
    }

    public String getPSWPDCWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWorkflowName();
        }
        return this.pswpdcworkflowname;
    }

    public boolean isPSWPDCWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWorkflowNameDirty();
        }
        return this.pswpdcworkflownameDirtyFlag;
    }

    public void resetPSWPDCWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWorkflowName();
            return;
        }
        this.pswpdcworkflownameDirtyFlag = false;
        this.pswpdcworkflowname = null;
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

    public void setWFInstSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfinstsn = string;
        this.wfinstsnDirtyFlag = true;
    }

    public String getWFInstSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstSN();
        }
        return this.wfinstsn;
    }

    public boolean isWFInstSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstSNDirty();
        }
        return this.wfinstsnDirtyFlag;
    }

    public void resetWFInstSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstSN();
            return;
        }
        this.wfinstsnDirtyFlag = false;
        this.wfinstsn = null;
    }

    protected void onReset() {
        PSWPDCWFInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCWFInstBase pSWPDCWFInstBase) {
        pSWPDCWFInstBase.resetCreateDate();
        pSWPDCWFInstBase.resetCreateMan();
        pSWPDCWFInstBase.resetPSWPDCAppEntityId();
        pSWPDCWFInstBase.resetPSWPDCAppEntityName();
        pSWPDCWFInstBase.resetPSWPDCWFInstId();
        pSWPDCWFInstBase.resetPSWPDCWFInstName();
        pSWPDCWFInstBase.resetPSWPDCWorkflowId();
        pSWPDCWFInstBase.resetPSWPDCWorkflowName();
        pSWPDCWFInstBase.resetUpdateDate();
        pSWPDCWFInstBase.resetUpdateMan();
        pSWPDCWFInstBase.resetWFInstSN();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPDCAppEntityIdDirty()) {
            hashMap.put(FIELD_PSWPDCAPPENTITYID, this.getPSWPDCAppEntityId());
        }
        if (!bl || this.isPSWPDCAppEntityNameDirty()) {
            hashMap.put(FIELD_PSWPDCAPPENTITYNAME, this.getPSWPDCAppEntityName());
        }
        if (!bl || this.isPSWPDCWFInstIdDirty()) {
            hashMap.put(FIELD_PSWPDCWFINSTID, this.getPSWPDCWFInstId());
        }
        if (!bl || this.isPSWPDCWFInstNameDirty()) {
            hashMap.put(FIELD_PSWPDCWFINSTNAME, this.getPSWPDCWFInstName());
        }
        if (!bl || this.isPSWPDCWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWPDCWORKFLOWID, this.getPSWPDCWorkflowId());
        }
        if (!bl || this.isPSWPDCWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWPDCWORKFLOWNAME, this.getPSWPDCWorkflowName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWFInstSNDirty()) {
            hashMap.put(FIELD_WFINSTSN, this.getWFInstSN());
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
        return PSWPDCWFInstBase.get(this, n);
    }

    private static Object get(PSWPDCWFInstBase pSWPDCWFInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFInstBase.getCreateDate();
            }
            case 1: {
                return pSWPDCWFInstBase.getCreateMan();
            }
            case 2: {
                return pSWPDCWFInstBase.getPSWPDCAppEntityId();
            }
            case 3: {
                return pSWPDCWFInstBase.getPSWPDCAppEntityName();
            }
            case 4: {
                return pSWPDCWFInstBase.getPSWPDCWFInstId();
            }
            case 5: {
                return pSWPDCWFInstBase.getPSWPDCWFInstName();
            }
            case 6: {
                return pSWPDCWFInstBase.getPSWPDCWorkflowId();
            }
            case 7: {
                return pSWPDCWFInstBase.getPSWPDCWorkflowName();
            }
            case 8: {
                return pSWPDCWFInstBase.getUpdateDate();
            }
            case 9: {
                return pSWPDCWFInstBase.getUpdateMan();
            }
            case 10: {
                return pSWPDCWFInstBase.getWFInstSN();
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
        PSWPDCWFInstBase.set(this, n, object);
    }

    private static void set(PSWPDCWFInstBase pSWPDCWFInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWFInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCWFInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCWFInstBase.setPSWPDCAppEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCWFInstBase.setPSWPDCAppEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCWFInstBase.setPSWPDCWFInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCWFInstBase.setPSWPDCWFInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCWFInstBase.setPSWPDCWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCWFInstBase.setPSWPDCWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWPDCWFInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSWPDCWFInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWPDCWFInstBase.setWFInstSN(DataObject.getStringValue((Object)object));
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
        return PSWPDCWFInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCWFInstBase pSWPDCWFInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCWFInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCWFInstBase.getPSWPDCAppEntityId() == null;
            }
            case 3: {
                return pSWPDCWFInstBase.getPSWPDCAppEntityName() == null;
            }
            case 4: {
                return pSWPDCWFInstBase.getPSWPDCWFInstId() == null;
            }
            case 5: {
                return pSWPDCWFInstBase.getPSWPDCWFInstName() == null;
            }
            case 6: {
                return pSWPDCWFInstBase.getPSWPDCWorkflowId() == null;
            }
            case 7: {
                return pSWPDCWFInstBase.getPSWPDCWorkflowName() == null;
            }
            case 8: {
                return pSWPDCWFInstBase.getUpdateDate() == null;
            }
            case 9: {
                return pSWPDCWFInstBase.getUpdateMan() == null;
            }
            case 10: {
                return pSWPDCWFInstBase.getWFInstSN() == null;
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
        return PSWPDCWFInstBase.contains(this, n);
    }

    private static boolean contains(PSWPDCWFInstBase pSWPDCWFInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCWFInstBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCWFInstBase.isPSWPDCAppEntityIdDirty();
            }
            case 3: {
                return pSWPDCWFInstBase.isPSWPDCAppEntityNameDirty();
            }
            case 4: {
                return pSWPDCWFInstBase.isPSWPDCWFInstIdDirty();
            }
            case 5: {
                return pSWPDCWFInstBase.isPSWPDCWFInstNameDirty();
            }
            case 6: {
                return pSWPDCWFInstBase.isPSWPDCWorkflowIdDirty();
            }
            case 7: {
                return pSWPDCWFInstBase.isPSWPDCWorkflowNameDirty();
            }
            case 8: {
                return pSWPDCWFInstBase.isUpdateDateDirty();
            }
            case 9: {
                return pSWPDCWFInstBase.isUpdateManDirty();
            }
            case 10: {
                return pSWPDCWFInstBase.isWFInstSNDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCWFInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCWFInstBase pSWPDCWFInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCWFInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCAppEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappentityid", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCAppEntityId()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCAppEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappentityname", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCAppEntityName()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWFInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcwfinstid", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCWFInstId()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWFInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcwfinstname", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCWFInstName()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcworkflowid", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCWorkflowId()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcworkflowname", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getPSWPDCWorkflowName()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWPDCWFInstBase.getWFInstSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfinstsn", (Object)PSWPDCWFInstBase.getJSONValue((Object)pSWPDCWFInstBase.getWFInstSN()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCWFInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCWFInstBase pSWPDCWFInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCWFInstBase.getCreateDate() != null) {
            object = pSWPDCWFInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWFInstBase.getCreateMan() != null) {
            object = pSWPDCWFInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCAppEntityId() != null) {
            object = pSWPDCWFInstBase.getPSWPDCAppEntityId();
            xmlNode.setAttribute(FIELD_PSWPDCAPPENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCAppEntityName() != null) {
            object = pSWPDCWFInstBase.getPSWPDCAppEntityName();
            xmlNode.setAttribute(FIELD_PSWPDCAPPENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWFInstId() != null) {
            object = pSWPDCWFInstBase.getPSWPDCWFInstId();
            xmlNode.setAttribute(FIELD_PSWPDCWFINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWFInstName() != null) {
            object = pSWPDCWFInstBase.getPSWPDCWFInstName();
            xmlNode.setAttribute(FIELD_PSWPDCWFINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWorkflowId() != null) {
            object = pSWPDCWFInstBase.getPSWPDCWorkflowId();
            xmlNode.setAttribute(FIELD_PSWPDCWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getPSWPDCWorkflowName() != null) {
            object = pSWPDCWFInstBase.getPSWPDCWorkflowName();
            xmlNode.setAttribute(FIELD_PSWPDCWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getUpdateDate() != null) {
            object = pSWPDCWFInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWFInstBase.getUpdateMan() != null) {
            object = pSWPDCWFInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFInstBase.getWFInstSN() != null) {
            object = pSWPDCWFInstBase.getWFInstSN();
            xmlNode.setAttribute(FIELD_WFINSTSN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCWFInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCWFInstBase pSWPDCWFInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCWFInstBase.isCreateDateDirty() && (bl || pSWPDCWFInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCWFInstBase.getCreateDate());
        }
        if (pSWPDCWFInstBase.isCreateManDirty() && (bl || pSWPDCWFInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCWFInstBase.getCreateMan());
        }
        if (pSWPDCWFInstBase.isPSWPDCAppEntityIdDirty() && (bl || pSWPDCWFInstBase.getPSWPDCAppEntityId() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPENTITYID, (Object)pSWPDCWFInstBase.getPSWPDCAppEntityId());
        }
        if (pSWPDCWFInstBase.isPSWPDCAppEntityNameDirty() && (bl || pSWPDCWFInstBase.getPSWPDCAppEntityName() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPENTITYNAME, (Object)pSWPDCWFInstBase.getPSWPDCAppEntityName());
        }
        if (pSWPDCWFInstBase.isPSWPDCWFInstIdDirty() && (bl || pSWPDCWFInstBase.getPSWPDCWFInstId() != null)) {
            iDataObject.set(FIELD_PSWPDCWFINSTID, (Object)pSWPDCWFInstBase.getPSWPDCWFInstId());
        }
        if (pSWPDCWFInstBase.isPSWPDCWFInstNameDirty() && (bl || pSWPDCWFInstBase.getPSWPDCWFInstName() != null)) {
            iDataObject.set(FIELD_PSWPDCWFINSTNAME, (Object)pSWPDCWFInstBase.getPSWPDCWFInstName());
        }
        if (pSWPDCWFInstBase.isPSWPDCWorkflowIdDirty() && (bl || pSWPDCWFInstBase.getPSWPDCWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWPDCWORKFLOWID, (Object)pSWPDCWFInstBase.getPSWPDCWorkflowId());
        }
        if (pSWPDCWFInstBase.isPSWPDCWorkflowNameDirty() && (bl || pSWPDCWFInstBase.getPSWPDCWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWPDCWORKFLOWNAME, (Object)pSWPDCWFInstBase.getPSWPDCWorkflowName());
        }
        if (pSWPDCWFInstBase.isUpdateDateDirty() && (bl || pSWPDCWFInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCWFInstBase.getUpdateDate());
        }
        if (pSWPDCWFInstBase.isUpdateManDirty() && (bl || pSWPDCWFInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCWFInstBase.getUpdateMan());
        }
        if (pSWPDCWFInstBase.isWFInstSNDirty() && (bl || pSWPDCWFInstBase.getWFInstSN() != null)) {
            iDataObject.set(FIELD_WFINSTSN, (Object)pSWPDCWFInstBase.getWFInstSN());
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
        return PSWPDCWFInstBase.remove(this, n);
    }

    private static boolean remove(PSWPDCWFInstBase pSWPDCWFInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWFInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCWFInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCWFInstBase.resetPSWPDCAppEntityId();
                return true;
            }
            case 3: {
                pSWPDCWFInstBase.resetPSWPDCAppEntityName();
                return true;
            }
            case 4: {
                pSWPDCWFInstBase.resetPSWPDCWFInstId();
                return true;
            }
            case 5: {
                pSWPDCWFInstBase.resetPSWPDCWFInstName();
                return true;
            }
            case 6: {
                pSWPDCWFInstBase.resetPSWPDCWorkflowId();
                return true;
            }
            case 7: {
                pSWPDCWFInstBase.resetPSWPDCWorkflowName();
                return true;
            }
            case 8: {
                pSWPDCWFInstBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSWPDCWFInstBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSWPDCWFInstBase.resetWFInstSN();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPDCAppEntity getPswpdcappentity() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPswpdcappentity();
        }
        if (this.getPSWPDCAppEntityId() == null) {
            return null;
        }
        Integer n = this.objPswpdcappentityLock;
        synchronized (n) {
            if (this.pswpdcappentity != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPDCAppEntityId(), (Object)this.pswpdcappentity.getPSWPDCAppEntityId()) != 0L) {
                this.pswpdcappentity = null;
            }
            if (this.pswpdcappentity == null) {
                PSWPDCAppEntity pSWPDCAppEntity = new PSWPDCAppEntity();
                pSWPDCAppEntity.setPSWPDCAppEntityId(this.getPSWPDCAppEntityId());
                PSWPDCAppEntityService pSWPDCAppEntityService = (PSWPDCAppEntityService)ServiceGlobal.getService(PSWPDCAppEntityService.class, (SessionFactory)this.getSessionFactory());
                pSWPDCAppEntityService.autoGet(pSWPDCAppEntity);
                this.pswpdcappentity = pSWPDCAppEntity;
            }
            return this.pswpdcappentity;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPDCWorkflow getPswpdcworkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPswpdcworkflow();
        }
        if (this.getPSWPDCWorkflowId() == null) {
            return null;
        }
        Integer n = this.objPswpdcworkflowLock;
        synchronized (n) {
            if (this.pswpdcworkflow != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPDCWorkflowId(), (Object)this.pswpdcworkflow.getPSWPDCWorkflowId()) != 0L) {
                this.pswpdcworkflow = null;
            }
            if (this.pswpdcworkflow == null) {
                PSWPDCWorkflow pSWPDCWorkflow = new PSWPDCWorkflow();
                pSWPDCWorkflow.setPSWPDCWorkflowId(this.getPSWPDCWorkflowId());
                PSWPDCWorkflowService pSWPDCWorkflowService = (PSWPDCWorkflowService)ServiceGlobal.getService(PSWPDCWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWPDCWorkflowService.autoGet(pSWPDCWorkflow);
                this.pswpdcworkflow = pSWPDCWorkflow;
            }
            return this.pswpdcworkflow;
        }
    }

    private PSWPDCWFInstBase getProxyEntity() {
        return this.proxyPSWPDCWFInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCWFInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCWFInstBase) {
            this.proxyPSWPDCWFInstBase = (PSWPDCWFInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPDCAPPENTITYID, 2);
        fieldIndexMap.put(FIELD_PSWPDCAPPENTITYNAME, 3);
        fieldIndexMap.put(FIELD_PSWPDCWFINSTID, 4);
        fieldIndexMap.put(FIELD_PSWPDCWFINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSWPDCWORKFLOWID, 6);
        fieldIndexMap.put(FIELD_PSWPDCWORKFLOWNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_WFINSTSN, 10);
    }
}

