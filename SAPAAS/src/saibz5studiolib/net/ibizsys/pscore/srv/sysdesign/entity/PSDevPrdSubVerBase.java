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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssuePlan;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpecPlan;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSubVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSubVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSDEVPRDSUBVERID = "PPSDEVPRDSUBVERID";
    public static final String FIELD_PPSDEVPRDSUBVERNAME = "PPSDEVPRDSUBVERNAME";
    public static final String FIELD_PSDEVPRDSUBVERID = "PSDEVPRDSUBVERID";
    public static final String FIELD_PSDEVPRDSUBVERNAME = "PSDEVPRDSUBVERNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_SUBVERSTATE = "SUBVERSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PPSDEVPRDSUBVERID = 3;
    private static final int INDEX_PPSDEVPRDSUBVERNAME = 4;
    private static final int INDEX_PSDEVPRDSUBVERID = 5;
    private static final int INDEX_PSDEVPRDSUBVERNAME = 6;
    private static final int INDEX_PSDEVPRDVERID = 7;
    private static final int INDEX_PSDEVPRDVERNAME = 8;
    private static final int INDEX_SUBVERSTATE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final int INDEX_VER = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSubVerBase proxyPSDevPrdSubVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsdevprdsubveridDirtyFlag = false;
    private boolean ppsdevprdsubvernameDirtyFlag = false;
    private boolean psdevprdsubveridDirtyFlag = false;
    private boolean psdevprdsubvernameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean subverstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsdevprdsubverid")
    private String ppsdevprdsubverid;
    @Column(name="ppsdevprdsubvername")
    private String ppsdevprdsubvername;
    @Column(name="psdevprdsubverid")
    private String psdevprdsubverid;
    @Column(name="psdevprdsubvername")
    private String psdevprdsubvername;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="subverstate")
    private Integer subverstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="ver")
    private String ver;
    private Integer objPPSDevPrdSubVerLock = new Integer(1);
    private PSDevPrdSubVer ppsdevprdsubver = null;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdIssuePlansLock = new Integer(1);
    private ArrayList<PSDevPrdIssuePlan> psdevprdissueplans = null;
    private Integer objPSDevPrdSpecPlansLock = new Integer(1);
    private ArrayList<PSDevPrdSpecPlan> psdevprdspecplans = null;

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

    public void setPPSDevPrdSubVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevPrdSubVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevprdsubverid = string;
        this.ppsdevprdsubveridDirtyFlag = true;
    }

    public String getPPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdSubVerId();
        }
        return this.ppsdevprdsubverid;
    }

    public boolean isPPSDevPrdSubVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevPrdSubVerIdDirty();
        }
        return this.ppsdevprdsubveridDirtyFlag;
    }

    public void resetPPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevPrdSubVerId();
            return;
        }
        this.ppsdevprdsubveridDirtyFlag = false;
        this.ppsdevprdsubverid = null;
    }

    public void setPPSDevPrdSubVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevPrdSubVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevprdsubvername = string;
        this.ppsdevprdsubvernameDirtyFlag = true;
    }

    public String getPPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdSubVerName();
        }
        return this.ppsdevprdsubvername;
    }

    public boolean isPPSDevPrdSubVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevPrdSubVerNameDirty();
        }
        return this.ppsdevprdsubvernameDirtyFlag;
    }

    public void resetPPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevPrdSubVerName();
            return;
        }
        this.ppsdevprdsubvernameDirtyFlag = false;
        this.ppsdevprdsubvername = null;
    }

    public void setPSDevPrdSubVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubverid = string;
        this.psdevprdsubveridDirtyFlag = true;
    }

    public String getPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerId();
        }
        return this.psdevprdsubverid;
    }

    public boolean isPSDevPrdSubVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerIdDirty();
        }
        return this.psdevprdsubveridDirtyFlag;
    }

    public void resetPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerId();
            return;
        }
        this.psdevprdsubveridDirtyFlag = false;
        this.psdevprdsubverid = null;
    }

    public void setPSDevPrdSubVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubvername = string;
        this.psdevprdsubvernameDirtyFlag = true;
    }

    public String getPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerName();
        }
        return this.psdevprdsubvername;
    }

    public boolean isPSDevPrdSubVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerNameDirty();
        }
        return this.psdevprdsubvernameDirtyFlag;
    }

    public void resetPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerName();
            return;
        }
        this.psdevprdsubvernameDirtyFlag = false;
        this.psdevprdsubvername = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
    }

    public void setSubVerState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubVerState(n);
            return;
        }
        this.subverstate = n;
        this.subverstateDirtyFlag = true;
    }

    public Integer getSubVerState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubVerState();
        }
        return this.subverstate;
    }

    public boolean isSubVerStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubVerStateDirty();
        }
        return this.subverstateDirtyFlag;
    }

    public void resetSubVerState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubVerState();
            return;
        }
        this.subverstateDirtyFlag = false;
        this.subverstate = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ver = string;
        this.verDirtyFlag = true;
    }

    public String getVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVer();
        }
        return this.ver;
    }

    public boolean isVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDirty();
        }
        return this.verDirtyFlag;
    }

    public void resetVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVer();
            return;
        }
        this.verDirtyFlag = false;
        this.ver = null;
    }

    protected void onReset() {
        PSDevPrdSubVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSubVerBase pSDevPrdSubVerBase) {
        pSDevPrdSubVerBase.resetCreateDate();
        pSDevPrdSubVerBase.resetCreateMan();
        pSDevPrdSubVerBase.resetMemo();
        pSDevPrdSubVerBase.resetPPSDevPrdSubVerId();
        pSDevPrdSubVerBase.resetPPSDevPrdSubVerName();
        pSDevPrdSubVerBase.resetPSDevPrdSubVerId();
        pSDevPrdSubVerBase.resetPSDevPrdSubVerName();
        pSDevPrdSubVerBase.resetPSDevPrdVerId();
        pSDevPrdSubVerBase.resetPSDevPrdVerName();
        pSDevPrdSubVerBase.resetSubVerState();
        pSDevPrdSubVerBase.resetUpdateDate();
        pSDevPrdSubVerBase.resetUpdateMan();
        pSDevPrdSubVerBase.resetValidFlag();
        pSDevPrdSubVerBase.resetVer();
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
        if (!bl || this.isPPSDevPrdSubVerIdDirty()) {
            hashMap.put(FIELD_PPSDEVPRDSUBVERID, this.getPPSDevPrdSubVerId());
        }
        if (!bl || this.isPPSDevPrdSubVerNameDirty()) {
            hashMap.put(FIELD_PPSDEVPRDSUBVERNAME, this.getPPSDevPrdSubVerName());
        }
        if (!bl || this.isPSDevPrdSubVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERID, this.getPSDevPrdSubVerId());
        }
        if (!bl || this.isPSDevPrdSubVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERNAME, this.getPSDevPrdSubVerName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
        }
        if (!bl || this.isSubVerStateDirty()) {
            hashMap.put(FIELD_SUBVERSTATE, this.getSubVerState());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isVerDirty()) {
            hashMap.put(FIELD_VER, this.getVer());
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
        return PSDevPrdSubVerBase.get(this, n);
    }

    private static Object get(PSDevPrdSubVerBase pSDevPrdSubVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSubVerBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSubVerBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSubVerBase.getMemo();
            }
            case 3: {
                return pSDevPrdSubVerBase.getPPSDevPrdSubVerId();
            }
            case 4: {
                return pSDevPrdSubVerBase.getPPSDevPrdSubVerName();
            }
            case 5: {
                return pSDevPrdSubVerBase.getPSDevPrdSubVerId();
            }
            case 6: {
                return pSDevPrdSubVerBase.getPSDevPrdSubVerName();
            }
            case 7: {
                return pSDevPrdSubVerBase.getPSDevPrdVerId();
            }
            case 8: {
                return pSDevPrdSubVerBase.getPSDevPrdVerName();
            }
            case 9: {
                return pSDevPrdSubVerBase.getSubVerState();
            }
            case 10: {
                return pSDevPrdSubVerBase.getUpdateDate();
            }
            case 11: {
                return pSDevPrdSubVerBase.getUpdateMan();
            }
            case 12: {
                return pSDevPrdSubVerBase.getValidFlag();
            }
            case 13: {
                return pSDevPrdSubVerBase.getVer();
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
        PSDevPrdSubVerBase.set(this, n, object);
    }

    private static void set(PSDevPrdSubVerBase pSDevPrdSubVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSubVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSubVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSubVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSubVerBase.setPPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSubVerBase.setPPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSubVerBase.setPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSubVerBase.setPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSubVerBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSubVerBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSubVerBase.setSubVerState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSubVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSubVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSubVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdSubVerBase.setVer(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSubVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSubVerBase pSDevPrdSubVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSubVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSubVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSubVerBase.getMemo() == null;
            }
            case 3: {
                return pSDevPrdSubVerBase.getPPSDevPrdSubVerId() == null;
            }
            case 4: {
                return pSDevPrdSubVerBase.getPPSDevPrdSubVerName() == null;
            }
            case 5: {
                return pSDevPrdSubVerBase.getPSDevPrdSubVerId() == null;
            }
            case 6: {
                return pSDevPrdSubVerBase.getPSDevPrdSubVerName() == null;
            }
            case 7: {
                return pSDevPrdSubVerBase.getPSDevPrdVerId() == null;
            }
            case 8: {
                return pSDevPrdSubVerBase.getPSDevPrdVerName() == null;
            }
            case 9: {
                return pSDevPrdSubVerBase.getSubVerState() == null;
            }
            case 10: {
                return pSDevPrdSubVerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDevPrdSubVerBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDevPrdSubVerBase.getValidFlag() == null;
            }
            case 13: {
                return pSDevPrdSubVerBase.getVer() == null;
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
        return PSDevPrdSubVerBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSubVerBase pSDevPrdSubVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSubVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSubVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSubVerBase.isMemoDirty();
            }
            case 3: {
                return pSDevPrdSubVerBase.isPPSDevPrdSubVerIdDirty();
            }
            case 4: {
                return pSDevPrdSubVerBase.isPPSDevPrdSubVerNameDirty();
            }
            case 5: {
                return pSDevPrdSubVerBase.isPSDevPrdSubVerIdDirty();
            }
            case 6: {
                return pSDevPrdSubVerBase.isPSDevPrdSubVerNameDirty();
            }
            case 7: {
                return pSDevPrdSubVerBase.isPSDevPrdVerIdDirty();
            }
            case 8: {
                return pSDevPrdSubVerBase.isPSDevPrdVerNameDirty();
            }
            case 9: {
                return pSDevPrdSubVerBase.isSubVerStateDirty();
            }
            case 10: {
                return pSDevPrdSubVerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDevPrdSubVerBase.isUpdateManDirty();
            }
            case 12: {
                return pSDevPrdSubVerBase.isValidFlagDirty();
            }
            case 13: {
                return pSDevPrdSubVerBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSubVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSubVerBase pSDevPrdSubVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSubVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevprdsubverid", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevprdsubvername", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubverid", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubvername", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getSubVerState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subverstate", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getSubVerState()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDevPrdSubVerBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSDevPrdSubVerBase.getJSONValue((Object)pSDevPrdSubVerBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSubVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSubVerBase pSDevPrdSubVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSubVerBase.getCreateDate() != null) {
            object = pSDevPrdSubVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSubVerBase.getCreateMan() != null) {
            object = pSDevPrdSubVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getMemo() != null) {
            object = pSDevPrdSubVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerId() != null) {
            object = pSDevPrdSubVerBase.getPPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PPSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerName() != null) {
            object = pSDevPrdSubVerBase.getPPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PPSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerId() != null) {
            object = pSDevPrdSubVerBase.getPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerName() != null) {
            object = pSDevPrdSubVerBase.getPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdSubVerBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdSubVerBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getSubVerState() != null) {
            object = pSDevPrdSubVerBase.getSubVerState();
            xmlNode.setAttribute(FIELD_SUBVERSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSubVerBase.getUpdateDate() != null) {
            object = pSDevPrdSubVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSubVerBase.getUpdateMan() != null) {
            object = pSDevPrdSubVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSubVerBase.getValidFlag() != null) {
            object = pSDevPrdSubVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSubVerBase.getVer() != null) {
            object = pSDevPrdSubVerBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSubVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSubVerBase pSDevPrdSubVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSubVerBase.isCreateDateDirty() && (bl || pSDevPrdSubVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSubVerBase.getCreateDate());
        }
        if (pSDevPrdSubVerBase.isCreateManDirty() && (bl || pSDevPrdSubVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSubVerBase.getCreateMan());
        }
        if (pSDevPrdSubVerBase.isMemoDirty() && (bl || pSDevPrdSubVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSubVerBase.getMemo());
        }
        if (pSDevPrdSubVerBase.isPPSDevPrdSubVerIdDirty() && (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PPSDEVPRDSUBVERID, (Object)pSDevPrdSubVerBase.getPPSDevPrdSubVerId());
        }
        if (pSDevPrdSubVerBase.isPPSDevPrdSubVerNameDirty() && (bl || pSDevPrdSubVerBase.getPPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PPSDEVPRDSUBVERNAME, (Object)pSDevPrdSubVerBase.getPPSDevPrdSubVerName());
        }
        if (pSDevPrdSubVerBase.isPSDevPrdSubVerIdDirty() && (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERID, (Object)pSDevPrdSubVerBase.getPSDevPrdSubVerId());
        }
        if (pSDevPrdSubVerBase.isPSDevPrdSubVerNameDirty() && (bl || pSDevPrdSubVerBase.getPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERNAME, (Object)pSDevPrdSubVerBase.getPSDevPrdSubVerName());
        }
        if (pSDevPrdSubVerBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdSubVerBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdSubVerBase.getPSDevPrdVerId());
        }
        if (pSDevPrdSubVerBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdSubVerBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdSubVerBase.getPSDevPrdVerName());
        }
        if (pSDevPrdSubVerBase.isSubVerStateDirty() && (bl || pSDevPrdSubVerBase.getSubVerState() != null)) {
            iDataObject.set(FIELD_SUBVERSTATE, (Object)pSDevPrdSubVerBase.getSubVerState());
        }
        if (pSDevPrdSubVerBase.isUpdateDateDirty() && (bl || pSDevPrdSubVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSubVerBase.getUpdateDate());
        }
        if (pSDevPrdSubVerBase.isUpdateManDirty() && (bl || pSDevPrdSubVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSubVerBase.getUpdateMan());
        }
        if (pSDevPrdSubVerBase.isValidFlagDirty() && (bl || pSDevPrdSubVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevPrdSubVerBase.getValidFlag());
        }
        if (pSDevPrdSubVerBase.isVerDirty() && (bl || pSDevPrdSubVerBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSDevPrdSubVerBase.getVer());
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
        return PSDevPrdSubVerBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSubVerBase pSDevPrdSubVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSubVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSubVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSubVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevPrdSubVerBase.resetPPSDevPrdSubVerId();
                return true;
            }
            case 4: {
                pSDevPrdSubVerBase.resetPPSDevPrdSubVerName();
                return true;
            }
            case 5: {
                pSDevPrdSubVerBase.resetPSDevPrdSubVerId();
                return true;
            }
            case 6: {
                pSDevPrdSubVerBase.resetPSDevPrdSubVerName();
                return true;
            }
            case 7: {
                pSDevPrdSubVerBase.resetPSDevPrdVerId();
                return true;
            }
            case 8: {
                pSDevPrdSubVerBase.resetPSDevPrdVerName();
                return true;
            }
            case 9: {
                pSDevPrdSubVerBase.resetSubVerState();
                return true;
            }
            case 10: {
                pSDevPrdSubVerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDevPrdSubVerBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDevPrdSubVerBase.resetValidFlag();
                return true;
            }
            case 13: {
                pSDevPrdSubVerBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSubVer getPPSDevPrdSubVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdSubVer();
        }
        if (this.getPPSDevPrdSubVerId() == null) {
            return null;
        }
        Integer n = this.objPPSDevPrdSubVerLock;
        synchronized (n) {
            if (this.ppsdevprdsubver != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevPrdSubVerId(), (Object)this.ppsdevprdsubver.getPSDevPrdSubVerId()) != 0L) {
                this.ppsdevprdsubver = null;
            }
            if (this.ppsdevprdsubver == null) {
                PSDevPrdSubVer pSDevPrdSubVer = new PSDevPrdSubVer();
                pSDevPrdSubVer.setPSDevPrdSubVerId(this.getPPSDevPrdSubVerId());
                PSDevPrdSubVerService pSDevPrdSubVerService = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSubVerService.autoGet(pSDevPrdSubVer);
                this.ppsdevprdsubver = pSDevPrdSubVer;
            }
            return this.ppsdevprdsubver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet(pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevPrdIssuePlan> getPSDevPrdIssuePlans() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssuePlans();
        }
        if (this.getPSDevPrdSubVerId() == null) {
            return null;
        }
        PSDevPrdIssuePlanService pSDevPrdIssuePlanService = (PSDevPrdIssuePlanService)ServiceGlobal.getService(PSDevPrdIssuePlanService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevPrdIssuePlansLock;
        synchronized (n) {
            if (this.psdevprdissueplans == null) {
                this.psdevprdissueplans = pSDevPrdIssuePlanService.selectByPSDevPrdSubVer(this);
            }
            return this.psdevprdissueplans;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevPrdSpecPlan> getPSDevPrdSpecPlans() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecPlans();
        }
        if (this.getPSDevPrdSubVerId() == null) {
            return null;
        }
        PSDevPrdSpecPlanService pSDevPrdSpecPlanService = (PSDevPrdSpecPlanService)ServiceGlobal.getService(PSDevPrdSpecPlanService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevPrdSpecPlansLock;
        synchronized (n) {
            if (this.psdevprdspecplans == null) {
                this.psdevprdspecplans = pSDevPrdSpecPlanService.selectByPSDevPrdSubVer(this);
            }
            return this.psdevprdspecplans;
        }
    }

    private PSDevPrdSubVerBase getProxyEntity() {
        return this.proxyPSDevPrdSubVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSubVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSubVerBase) {
            this.proxyPSDevPrdSubVerBase = (PSDevPrdSubVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PPSDEVPRDSUBVERID, 3);
        fieldIndexMap.put(FIELD_PPSDEVPRDSUBVERNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERID, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 8);
        fieldIndexMap.put(FIELD_SUBVERSTATE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
        fieldIndexMap.put(FIELD_VER, 13);
    }
}

