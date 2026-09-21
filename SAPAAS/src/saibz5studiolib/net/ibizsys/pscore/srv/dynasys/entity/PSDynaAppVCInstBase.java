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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppVCInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppVCInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAAPPVCINSTID = "PSDYNAAPPVCINSTID";
    public static final String FIELD_PSDYNAAPPVCINSTNAME = "PSDYNAAPPVCINSTNAME";
    public static final String FIELD_PSDYNAAPPVIEWCTRLID = "PSDYNAAPPVIEWCTRLID";
    public static final String FIELD_PSDYNAAPPVIEWCTRLNAME = "PSDYNAAPPVIEWCTRLNAME";
    public static final String FIELD_PSDYNAAPPVIEWINSTID = "PSDYNAAPPVIEWINSTID";
    public static final String FIELD_PSDYNAAPPVIEWINSTNAME = "PSDYNAAPPVIEWINSTNAME";
    public static final String FIELD_PSDYNADEFORMINSTID = "PSDYNADEFORMINSTID";
    public static final String FIELD_PSDYNADEFORMINSTNAME = "PSDYNADEFORMINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNAAPPVCINSTID = 4;
    private static final int INDEX_PSDYNAAPPVCINSTNAME = 5;
    private static final int INDEX_PSDYNAAPPVIEWCTRLID = 6;
    private static final int INDEX_PSDYNAAPPVIEWCTRLNAME = 7;
    private static final int INDEX_PSDYNAAPPVIEWINSTID = 8;
    private static final int INDEX_PSDYNAAPPVIEWINSTNAME = 9;
    private static final int INDEX_PSDYNADEFORMINSTID = 10;
    private static final int INDEX_PSDYNADEFORMINSTNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppVCInstBase proxyPSDynaAppVCInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynaappvcinstidDirtyFlag = false;
    private boolean psdynaappvcinstnameDirtyFlag = false;
    private boolean psdynaappviewctrlidDirtyFlag = false;
    private boolean psdynaappviewctrlnameDirtyFlag = false;
    private boolean psdynaappviewinstidDirtyFlag = false;
    private boolean psdynaappviewinstnameDirtyFlag = false;
    private boolean psdynadeforminstidDirtyFlag = false;
    private boolean psdynadeforminstnameDirtyFlag = false;
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
    @Column(name="psdynaappvcinstid")
    private String psdynaappvcinstid;
    @Column(name="psdynaappvcinstname")
    private String psdynaappvcinstname;
    @Column(name="psdynaappviewctrlid")
    private String psdynaappviewctrlid;
    @Column(name="psdynaappviewctrlname")
    private String psdynaappviewctrlname;
    @Column(name="psdynaappviewinstid")
    private String psdynaappviewinstid;
    @Column(name="psdynaappviewinstname")
    private String psdynaappviewinstname;
    @Column(name="psdynadeforminstid")
    private String psdynadeforminstid;
    @Column(name="psdynadeforminstname")
    private String psdynadeforminstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDynaAppViewCtrlLock = new Integer(1);
    private PSDynaAppViewCtrl psdynaappviewctrl = null;
    private Integer objPSDynaAppViewInstLock = new Integer(1);
    private PSDynaAppViewInst psdynaappviewinst = null;
    private Integer objPSDynaDEFormLock = new Integer(1);
    private PSDynaDEFormInst psdynadeform = null;

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

    public void setPSDynaAppVCInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppVCInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappvcinstid = string;
        this.psdynaappvcinstidDirtyFlag = true;
    }

    public String getPSDynaAppVCInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppVCInstId();
        }
        return this.psdynaappvcinstid;
    }

    public boolean isPSDynaAppVCInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppVCInstIdDirty();
        }
        return this.psdynaappvcinstidDirtyFlag;
    }

    public void resetPSDynaAppVCInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppVCInstId();
            return;
        }
        this.psdynaappvcinstidDirtyFlag = false;
        this.psdynaappvcinstid = null;
    }

    public void setPSDynaAppVCInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppVCInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappvcinstname = string;
        this.psdynaappvcinstnameDirtyFlag = true;
    }

    public String getPSDynaAppVCInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppVCInstName();
        }
        return this.psdynaappvcinstname;
    }

    public boolean isPSDynaAppVCInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppVCInstNameDirty();
        }
        return this.psdynaappvcinstnameDirtyFlag;
    }

    public void resetPSDynaAppVCInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppVCInstName();
            return;
        }
        this.psdynaappvcinstnameDirtyFlag = false;
        this.psdynaappvcinstname = null;
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

    public void setPSDynaAppViewInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewinstid = string;
        this.psdynaappviewinstidDirtyFlag = true;
    }

    public String getPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstId();
        }
        return this.psdynaappviewinstid;
    }

    public boolean isPSDynaAppViewInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstIdDirty();
        }
        return this.psdynaappviewinstidDirtyFlag;
    }

    public void resetPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstId();
            return;
        }
        this.psdynaappviewinstidDirtyFlag = false;
        this.psdynaappviewinstid = null;
    }

    public void setPSDynaAppViewInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewinstname = string;
        this.psdynaappviewinstnameDirtyFlag = true;
    }

    public String getPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstName();
        }
        return this.psdynaappviewinstname;
    }

    public boolean isPSDynaAppViewInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstNameDirty();
        }
        return this.psdynaappviewinstnameDirtyFlag;
    }

    public void resetPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstName();
            return;
        }
        this.psdynaappviewinstnameDirtyFlag = false;
        this.psdynaappviewinstname = null;
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
        PSDynaAppVCInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppVCInstBase pSDynaAppVCInstBase) {
        pSDynaAppVCInstBase.resetCreateDate();
        pSDynaAppVCInstBase.resetCreateMan();
        pSDynaAppVCInstBase.resetCtrlType();
        pSDynaAppVCInstBase.resetMemo();
        pSDynaAppVCInstBase.resetPSDynaAppVCInstId();
        pSDynaAppVCInstBase.resetPSDynaAppVCInstName();
        pSDynaAppVCInstBase.resetPSDynaAppViewCtrlId();
        pSDynaAppVCInstBase.resetPSDynaAppViewCtrlName();
        pSDynaAppVCInstBase.resetPSDynaAppViewInstId();
        pSDynaAppVCInstBase.resetPSDynaAppViewInstName();
        pSDynaAppVCInstBase.resetPSDynaDEFormInstId();
        pSDynaAppVCInstBase.resetPSDynaDEFormInstName();
        pSDynaAppVCInstBase.resetUpdateDate();
        pSDynaAppVCInstBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaAppVCInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVCINSTID, this.getPSDynaAppVCInstId());
        }
        if (!bl || this.isPSDynaAppVCInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVCINSTNAME, this.getPSDynaAppVCInstName());
        }
        if (!bl || this.isPSDynaAppViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWCTRLID, this.getPSDynaAppViewCtrlId());
        }
        if (!bl || this.isPSDynaAppViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWCTRLNAME, this.getPSDynaAppViewCtrlName());
        }
        if (!bl || this.isPSDynaAppViewInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWINSTID, this.getPSDynaAppViewInstId());
        }
        if (!bl || this.isPSDynaAppViewInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWINSTNAME, this.getPSDynaAppViewInstName());
        }
        if (!bl || this.isPSDynaDEFormInstIdDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTID, this.getPSDynaDEFormInstId());
        }
        if (!bl || this.isPSDynaDEFormInstNameDirty()) {
            hashMap.put(FIELD_PSDYNADEFORMINSTNAME, this.getPSDynaDEFormInstName());
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
        return PSDynaAppVCInstBase.get(this, n);
    }

    private static Object get(PSDynaAppVCInstBase pSDynaAppVCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppVCInstBase.getCreateDate();
            }
            case 1: {
                return pSDynaAppVCInstBase.getCreateMan();
            }
            case 2: {
                return pSDynaAppVCInstBase.getCtrlType();
            }
            case 3: {
                return pSDynaAppVCInstBase.getMemo();
            }
            case 4: {
                return pSDynaAppVCInstBase.getPSDynaAppVCInstId();
            }
            case 5: {
                return pSDynaAppVCInstBase.getPSDynaAppVCInstName();
            }
            case 6: {
                return pSDynaAppVCInstBase.getPSDynaAppViewCtrlId();
            }
            case 7: {
                return pSDynaAppVCInstBase.getPSDynaAppViewCtrlName();
            }
            case 8: {
                return pSDynaAppVCInstBase.getPSDynaAppViewInstId();
            }
            case 9: {
                return pSDynaAppVCInstBase.getPSDynaAppViewInstName();
            }
            case 10: {
                return pSDynaAppVCInstBase.getPSDynaDEFormInstId();
            }
            case 11: {
                return pSDynaAppVCInstBase.getPSDynaDEFormInstName();
            }
            case 12: {
                return pSDynaAppVCInstBase.getUpdateDate();
            }
            case 13: {
                return pSDynaAppVCInstBase.getUpdateMan();
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
        PSDynaAppVCInstBase.set(this, n, object);
    }

    private static void set(PSDynaAppVCInstBase pSDynaAppVCInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppVCInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaAppVCInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaAppVCInstBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaAppVCInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaAppVCInstBase.setPSDynaAppVCInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaAppVCInstBase.setPSDynaAppVCInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaAppVCInstBase.setPSDynaAppViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaAppVCInstBase.setPSDynaAppViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaAppVCInstBase.setPSDynaAppViewInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaAppVCInstBase.setPSDynaAppViewInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaAppVCInstBase.setPSDynaDEFormInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaAppVCInstBase.setPSDynaDEFormInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaAppVCInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDynaAppVCInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaAppVCInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaAppVCInstBase pSDynaAppVCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppVCInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaAppVCInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaAppVCInstBase.getCtrlType() == null;
            }
            case 3: {
                return pSDynaAppVCInstBase.getMemo() == null;
            }
            case 4: {
                return pSDynaAppVCInstBase.getPSDynaAppVCInstId() == null;
            }
            case 5: {
                return pSDynaAppVCInstBase.getPSDynaAppVCInstName() == null;
            }
            case 6: {
                return pSDynaAppVCInstBase.getPSDynaAppViewCtrlId() == null;
            }
            case 7: {
                return pSDynaAppVCInstBase.getPSDynaAppViewCtrlName() == null;
            }
            case 8: {
                return pSDynaAppVCInstBase.getPSDynaAppViewInstId() == null;
            }
            case 9: {
                return pSDynaAppVCInstBase.getPSDynaAppViewInstName() == null;
            }
            case 10: {
                return pSDynaAppVCInstBase.getPSDynaDEFormInstId() == null;
            }
            case 11: {
                return pSDynaAppVCInstBase.getPSDynaDEFormInstName() == null;
            }
            case 12: {
                return pSDynaAppVCInstBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDynaAppVCInstBase.getUpdateMan() == null;
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
        return PSDynaAppVCInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaAppVCInstBase pSDynaAppVCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppVCInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaAppVCInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaAppVCInstBase.isCtrlTypeDirty();
            }
            case 3: {
                return pSDynaAppVCInstBase.isMemoDirty();
            }
            case 4: {
                return pSDynaAppVCInstBase.isPSDynaAppVCInstIdDirty();
            }
            case 5: {
                return pSDynaAppVCInstBase.isPSDynaAppVCInstNameDirty();
            }
            case 6: {
                return pSDynaAppVCInstBase.isPSDynaAppViewCtrlIdDirty();
            }
            case 7: {
                return pSDynaAppVCInstBase.isPSDynaAppViewCtrlNameDirty();
            }
            case 8: {
                return pSDynaAppVCInstBase.isPSDynaAppViewInstIdDirty();
            }
            case 9: {
                return pSDynaAppVCInstBase.isPSDynaAppViewInstNameDirty();
            }
            case 10: {
                return pSDynaAppVCInstBase.isPSDynaDEFormInstIdDirty();
            }
            case 11: {
                return pSDynaAppVCInstBase.isPSDynaDEFormInstNameDirty();
            }
            case 12: {
                return pSDynaAppVCInstBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDynaAppVCInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaAppVCInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaAppVCInstBase pSDynaAppVCInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaAppVCInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappvcinstid", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppVCInstId()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappvcinstname", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppVCInstName()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewctrlid", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppViewCtrlId()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewctrlname", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppViewCtrlName()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewinstid", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppViewInstId()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewinstname", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaAppViewInstName()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstid", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaDEFormInstId()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeforminstname", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getPSDynaDEFormInstName()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaAppVCInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaAppVCInstBase.getJSONValue((Object)pSDynaAppVCInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaAppVCInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaAppVCInstBase pSDynaAppVCInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaAppVCInstBase.getCreateDate() != null) {
            object = pSDynaAppVCInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppVCInstBase.getCreateMan() != null) {
            object = pSDynaAppVCInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getCtrlType() != null) {
            object = pSDynaAppVCInstBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getMemo() != null) {
            object = pSDynaAppVCInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstId() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppVCInstId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVCINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstName() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppVCInstName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVCINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlId() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlName() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstId() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppViewInstId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstName() != null) {
            object = pSDynaAppVCInstBase.getPSDynaAppViewInstName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstId() != null) {
            object = pSDynaAppVCInstBase.getPSDynaDEFormInstId();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstName() != null) {
            object = pSDynaAppVCInstBase.getPSDynaDEFormInstName();
            xmlNode.setAttribute(FIELD_PSDYNADEFORMINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppVCInstBase.getUpdateDate() != null) {
            object = pSDynaAppVCInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppVCInstBase.getUpdateMan() != null) {
            object = pSDynaAppVCInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaAppVCInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaAppVCInstBase pSDynaAppVCInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaAppVCInstBase.isCreateDateDirty() && (bl || pSDynaAppVCInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaAppVCInstBase.getCreateDate());
        }
        if (pSDynaAppVCInstBase.isCreateManDirty() && (bl || pSDynaAppVCInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaAppVCInstBase.getCreateMan());
        }
        if (pSDynaAppVCInstBase.isCtrlTypeDirty() && (bl || pSDynaAppVCInstBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSDynaAppVCInstBase.getCtrlType());
        }
        if (pSDynaAppVCInstBase.isMemoDirty() && (bl || pSDynaAppVCInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaAppVCInstBase.getMemo());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppVCInstIdDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVCINSTID, (Object)pSDynaAppVCInstBase.getPSDynaAppVCInstId());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppVCInstNameDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppVCInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVCINSTNAME, (Object)pSDynaAppVCInstBase.getPSDynaAppVCInstName());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppViewCtrlIdDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWCTRLID, (Object)pSDynaAppVCInstBase.getPSDynaAppViewCtrlId());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppViewCtrlNameDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWCTRLNAME, (Object)pSDynaAppVCInstBase.getPSDynaAppViewCtrlName());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppViewInstIdDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWINSTID, (Object)pSDynaAppVCInstBase.getPSDynaAppViewInstId());
        }
        if (pSDynaAppVCInstBase.isPSDynaAppViewInstNameDirty() && (bl || pSDynaAppVCInstBase.getPSDynaAppViewInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWINSTNAME, (Object)pSDynaAppVCInstBase.getPSDynaAppViewInstName());
        }
        if (pSDynaAppVCInstBase.isPSDynaDEFormInstIdDirty() && (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstId() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTID, (Object)pSDynaAppVCInstBase.getPSDynaDEFormInstId());
        }
        if (pSDynaAppVCInstBase.isPSDynaDEFormInstNameDirty() && (bl || pSDynaAppVCInstBase.getPSDynaDEFormInstName() != null)) {
            iDataObject.set(FIELD_PSDYNADEFORMINSTNAME, (Object)pSDynaAppVCInstBase.getPSDynaDEFormInstName());
        }
        if (pSDynaAppVCInstBase.isUpdateDateDirty() && (bl || pSDynaAppVCInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaAppVCInstBase.getUpdateDate());
        }
        if (pSDynaAppVCInstBase.isUpdateManDirty() && (bl || pSDynaAppVCInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaAppVCInstBase.getUpdateMan());
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
        return PSDynaAppVCInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaAppVCInstBase pSDynaAppVCInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppVCInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaAppVCInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaAppVCInstBase.resetCtrlType();
                return true;
            }
            case 3: {
                pSDynaAppVCInstBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaAppVCInstBase.resetPSDynaAppVCInstId();
                return true;
            }
            case 5: {
                pSDynaAppVCInstBase.resetPSDynaAppVCInstName();
                return true;
            }
            case 6: {
                pSDynaAppVCInstBase.resetPSDynaAppViewCtrlId();
                return true;
            }
            case 7: {
                pSDynaAppVCInstBase.resetPSDynaAppViewCtrlName();
                return true;
            }
            case 8: {
                pSDynaAppVCInstBase.resetPSDynaAppViewInstId();
                return true;
            }
            case 9: {
                pSDynaAppVCInstBase.resetPSDynaAppViewInstName();
                return true;
            }
            case 10: {
                pSDynaAppVCInstBase.resetPSDynaDEFormInstId();
                return true;
            }
            case 11: {
                pSDynaAppVCInstBase.resetPSDynaDEFormInstName();
                return true;
            }
            case 12: {
                pSDynaAppVCInstBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDynaAppVCInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaAppViewCtrl getPSDynaAppViewCtrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewCtrl();
        }
        if (this.getPSDynaAppViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppViewCtrlLock;
        synchronized (n) {
            if (this.psdynaappviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppViewCtrlId(), (Object)this.psdynaappviewctrl.getPSDynaAppViewCtrlId()) != 0L) {
                this.psdynaappviewctrl = null;
            }
            if (this.psdynaappviewctrl == null) {
                PSDynaAppViewCtrl pSDynaAppViewCtrl = new PSDynaAppViewCtrl();
                pSDynaAppViewCtrl.setPSDynaAppViewCtrlId(this.getPSDynaAppViewCtrlId());
                PSDynaAppViewCtrlService pSDynaAppViewCtrlService = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppViewCtrlService.autoGet((IEntity)pSDynaAppViewCtrl);
                this.psdynaappviewctrl = pSDynaAppViewCtrl;
            }
            return this.psdynaappviewctrl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaAppViewInst getPSDynaAppViewInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInst();
        }
        if (this.getPSDynaAppViewInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppViewInstLock;
        synchronized (n) {
            if (this.psdynaappviewinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppViewInstId(), (Object)this.psdynaappviewinst.getPSDynaAppViewInstId()) != 0L) {
                this.psdynaappviewinst = null;
            }
            if (this.psdynaappviewinst == null) {
                PSDynaAppViewInst pSDynaAppViewInst = new PSDynaAppViewInst();
                pSDynaAppViewInst.setPSDynaAppViewInstId(this.getPSDynaAppViewInstId());
                PSDynaAppViewInstService pSDynaAppViewInstService = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppViewInstService.autoGet((IEntity)pSDynaAppViewInst);
                this.psdynaappviewinst = pSDynaAppViewInst;
            }
            return this.psdynaappviewinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDEFormInst getPSDynaDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEForm();
        }
        if (this.getPSDynaDEFormInstId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDEFormLock;
        synchronized (n) {
            if (this.psdynadeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEFormInstId(), (Object)this.psdynadeform.getPSDynaDEFormInstId()) != 0L) {
                this.psdynadeform = null;
            }
            if (this.psdynadeform == null) {
                PSDynaDEFormInst pSDynaDEFormInst = new PSDynaDEFormInst();
                pSDynaDEFormInst.setPSDynaDEFormInstId(this.getPSDynaDEFormInstId());
                PSDynaDEFormInstService pSDynaDEFormInstService = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEFormInstService.autoGet((IEntity)pSDynaDEFormInst);
                this.psdynadeform = pSDynaDEFormInst;
            }
            return this.psdynadeform;
        }
    }

    private PSDynaAppVCInstBase getProxyEntity() {
        return this.proxyPSDynaAppVCInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaAppVCInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaAppVCInstBase) {
            this.proxyPSDynaAppVCInstBase = (PSDynaAppVCInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNAAPPVCINSTID, 4);
        fieldIndexMap.put(FIELD_PSDYNAAPPVCINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWCTRLID, 6);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWCTRLNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTID, 8);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTID, 10);
        fieldIndexMap.put(FIELD_PSDYNADEFORMINSTNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

