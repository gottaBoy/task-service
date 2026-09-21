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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPack;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSdepSlnDepSessionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSdepSlnDepSessionBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPINFO = "DEPINFO";
    public static final String FIELD_DEPSTATE = "DEPSTATE";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNDEPSESSIONID = "PSDEPSLNDEPSESSIONID";
    public static final String FIELD_PSDEPSLNDEPSESSIONNAME = "PSDEPSLNDEPSESSIONNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNPACKID = "PSDEPSLNPACKID";
    public static final String FIELD_PSDEPSLNPACKNAME = "PSDEPSLNPACKNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEPINFO = 3;
    private static final int INDEX_DEPSTATE = 4;
    private static final int INDEX_ENDTIME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEPSLNDEPSESSIONID = 7;
    private static final int INDEX_PSDEPSLNDEPSESSIONNAME = 8;
    private static final int INDEX_PSDEPSLNID = 9;
    private static final int INDEX_PSDEPSLNNAME = 10;
    private static final int INDEX_PSDEPSLNPACKID = 11;
    private static final int INDEX_PSDEPSLNPACKNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSdepSlnDepSessionBase proxyPSdepSlnDepSessionBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean depinfoDirtyFlag = false;
    private boolean depstateDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslndepsessionidDirtyFlag = false;
    private boolean psdepslndepsessionnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnpackidDirtyFlag = false;
    private boolean psdepslnpacknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="depinfo")
    private String depinfo;
    @Column(name="depstate")
    private Integer depstate;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslndepsessionid")
    private String psdepslndepsessionid;
    @Column(name="psdepslndepsessionname")
    private String psdepslndepsessionname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnpackid")
    private String psdepslnpackid;
    @Column(name="psdepslnpackname")
    private String psdepslnpackname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnPackLock = new Integer(1);
    private PSDepSlnPack psdepslnpack = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
    }

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

    public void setDepInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depinfo = string;
        this.depinfoDirtyFlag = true;
    }

    public String getDepInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepInfo();
        }
        return this.depinfo;
    }

    public boolean isDepInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepInfoDirty();
        }
        return this.depinfoDirtyFlag;
    }

    public void resetDepInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepInfo();
            return;
        }
        this.depinfoDirtyFlag = false;
        this.depinfo = null;
    }

    public void setDepState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepState(n);
            return;
        }
        this.depstate = n;
        this.depstateDirtyFlag = true;
    }

    public Integer getDepState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepState();
        }
        return this.depstate;
    }

    public boolean isDepStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepStateDirty();
        }
        return this.depstateDirtyFlag;
    }

    public void resetDepState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepState();
            return;
        }
        this.depstateDirtyFlag = false;
        this.depstate = null;
    }

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
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

    public void setPSDepSlnDepSessionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDepSessionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndepsessionid = string;
        this.psdepslndepsessionidDirtyFlag = true;
    }

    public String getPSDepSlnDepSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDepSessionId();
        }
        return this.psdepslndepsessionid;
    }

    public boolean isPSDepSlnDepSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDepSessionIdDirty();
        }
        return this.psdepslndepsessionidDirtyFlag;
    }

    public void resetPSDepSlnDepSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDepSessionId();
            return;
        }
        this.psdepslndepsessionidDirtyFlag = false;
        this.psdepslndepsessionid = null;
    }

    public void setPSDepSlnDepSessionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnDepSessionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslndepsessionname = string;
        this.psdepslndepsessionnameDirtyFlag = true;
    }

    public String getPSDepSlnDepSessionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnDepSessionName();
        }
        return this.psdepslndepsessionname;
    }

    public boolean isPSDepSlnDepSessionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnDepSessionNameDirty();
        }
        return this.psdepslndepsessionnameDirtyFlag;
    }

    public void resetPSDepSlnDepSessionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnDepSessionName();
            return;
        }
        this.psdepslndepsessionnameDirtyFlag = false;
        this.psdepslndepsessionname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnpackid = string;
        this.psdepslnpackidDirtyFlag = true;
    }

    public String getPSDepSlnPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPackId();
        }
        return this.psdepslnpackid;
    }

    public boolean isPSDepSlnPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPackIdDirty();
        }
        return this.psdepslnpackidDirtyFlag;
    }

    public void resetPSDepSlnPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPackId();
            return;
        }
        this.psdepslnpackidDirtyFlag = false;
        this.psdepslnpackid = null;
    }

    public void setPSDepSlnPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnpackname = string;
        this.psdepslnpacknameDirtyFlag = true;
    }

    public String getPSDepSlnPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPackName();
        }
        return this.psdepslnpackname;
    }

    public boolean isPSDepSlnPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPackNameDirty();
        }
        return this.psdepslnpacknameDirtyFlag;
    }

    public void resetPSDepSlnPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPackName();
            return;
        }
        this.psdepslnpacknameDirtyFlag = false;
        this.psdepslnpackname = null;
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
        PSdepSlnDepSessionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSdepSlnDepSessionBase pSdepSlnDepSessionBase) {
        pSdepSlnDepSessionBase.resetBeginTime();
        pSdepSlnDepSessionBase.resetCreateDate();
        pSdepSlnDepSessionBase.resetCreateMan();
        pSdepSlnDepSessionBase.resetDepInfo();
        pSdepSlnDepSessionBase.resetDepState();
        pSdepSlnDepSessionBase.resetEndTime();
        pSdepSlnDepSessionBase.resetMemo();
        pSdepSlnDepSessionBase.resetPSDepSlnDepSessionId();
        pSdepSlnDepSessionBase.resetPSDepSlnDepSessionName();
        pSdepSlnDepSessionBase.resetPSDepSlnId();
        pSdepSlnDepSessionBase.resetPSDepSlnName();
        pSdepSlnDepSessionBase.resetPSDepSlnPackId();
        pSdepSlnDepSessionBase.resetPSDepSlnPackName();
        pSdepSlnDepSessionBase.resetUpdateDate();
        pSdepSlnDepSessionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDepInfoDirty()) {
            hashMap.put(FIELD_DEPINFO, this.getDepInfo());
        }
        if (!bl || this.isDepStateDirty()) {
            hashMap.put(FIELD_DEPSTATE, this.getDepState());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnDepSessionIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNDEPSESSIONID, this.getPSDepSlnDepSessionId());
        }
        if (!bl || this.isPSDepSlnDepSessionNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNDEPSESSIONNAME, this.getPSDepSlnDepSessionName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnPackIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPACKID, this.getPSDepSlnPackId());
        }
        if (!bl || this.isPSDepSlnPackNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPACKNAME, this.getPSDepSlnPackName());
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
        return PSdepSlnDepSessionBase.get(this, n);
    }

    private static Object get(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSdepSlnDepSessionBase.getBeginTime();
            }
            case 1: {
                return pSdepSlnDepSessionBase.getCreateDate();
            }
            case 2: {
                return pSdepSlnDepSessionBase.getCreateMan();
            }
            case 3: {
                return pSdepSlnDepSessionBase.getDepInfo();
            }
            case 4: {
                return pSdepSlnDepSessionBase.getDepState();
            }
            case 5: {
                return pSdepSlnDepSessionBase.getEndTime();
            }
            case 6: {
                return pSdepSlnDepSessionBase.getMemo();
            }
            case 7: {
                return pSdepSlnDepSessionBase.getPSDepSlnDepSessionId();
            }
            case 8: {
                return pSdepSlnDepSessionBase.getPSDepSlnDepSessionName();
            }
            case 9: {
                return pSdepSlnDepSessionBase.getPSDepSlnId();
            }
            case 10: {
                return pSdepSlnDepSessionBase.getPSDepSlnName();
            }
            case 11: {
                return pSdepSlnDepSessionBase.getPSDepSlnPackId();
            }
            case 12: {
                return pSdepSlnDepSessionBase.getPSDepSlnPackName();
            }
            case 13: {
                return pSdepSlnDepSessionBase.getUpdateDate();
            }
            case 14: {
                return pSdepSlnDepSessionBase.getUpdateMan();
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
        PSdepSlnDepSessionBase.set(this, n, object);
    }

    private static void set(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSdepSlnDepSessionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSdepSlnDepSessionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSdepSlnDepSessionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSdepSlnDepSessionBase.setDepInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSdepSlnDepSessionBase.setDepState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSdepSlnDepSessionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSdepSlnDepSessionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSdepSlnDepSessionBase.setPSDepSlnDepSessionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSdepSlnDepSessionBase.setPSDepSlnDepSessionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSdepSlnDepSessionBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSdepSlnDepSessionBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSdepSlnDepSessionBase.setPSDepSlnPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSdepSlnDepSessionBase.setPSDepSlnPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSdepSlnDepSessionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSdepSlnDepSessionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSdepSlnDepSessionBase.isNull(this, n);
    }

    private static boolean isNull(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSdepSlnDepSessionBase.getBeginTime() == null;
            }
            case 1: {
                return pSdepSlnDepSessionBase.getCreateDate() == null;
            }
            case 2: {
                return pSdepSlnDepSessionBase.getCreateMan() == null;
            }
            case 3: {
                return pSdepSlnDepSessionBase.getDepInfo() == null;
            }
            case 4: {
                return pSdepSlnDepSessionBase.getDepState() == null;
            }
            case 5: {
                return pSdepSlnDepSessionBase.getEndTime() == null;
            }
            case 6: {
                return pSdepSlnDepSessionBase.getMemo() == null;
            }
            case 7: {
                return pSdepSlnDepSessionBase.getPSDepSlnDepSessionId() == null;
            }
            case 8: {
                return pSdepSlnDepSessionBase.getPSDepSlnDepSessionName() == null;
            }
            case 9: {
                return pSdepSlnDepSessionBase.getPSDepSlnId() == null;
            }
            case 10: {
                return pSdepSlnDepSessionBase.getPSDepSlnName() == null;
            }
            case 11: {
                return pSdepSlnDepSessionBase.getPSDepSlnPackId() == null;
            }
            case 12: {
                return pSdepSlnDepSessionBase.getPSDepSlnPackName() == null;
            }
            case 13: {
                return pSdepSlnDepSessionBase.getUpdateDate() == null;
            }
            case 14: {
                return pSdepSlnDepSessionBase.getUpdateMan() == null;
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
        return PSdepSlnDepSessionBase.contains(this, n);
    }

    private static boolean contains(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSdepSlnDepSessionBase.isBeginTimeDirty();
            }
            case 1: {
                return pSdepSlnDepSessionBase.isCreateDateDirty();
            }
            case 2: {
                return pSdepSlnDepSessionBase.isCreateManDirty();
            }
            case 3: {
                return pSdepSlnDepSessionBase.isDepInfoDirty();
            }
            case 4: {
                return pSdepSlnDepSessionBase.isDepStateDirty();
            }
            case 5: {
                return pSdepSlnDepSessionBase.isEndTimeDirty();
            }
            case 6: {
                return pSdepSlnDepSessionBase.isMemoDirty();
            }
            case 7: {
                return pSdepSlnDepSessionBase.isPSDepSlnDepSessionIdDirty();
            }
            case 8: {
                return pSdepSlnDepSessionBase.isPSDepSlnDepSessionNameDirty();
            }
            case 9: {
                return pSdepSlnDepSessionBase.isPSDepSlnIdDirty();
            }
            case 10: {
                return pSdepSlnDepSessionBase.isPSDepSlnNameDirty();
            }
            case 11: {
                return pSdepSlnDepSessionBase.isPSDepSlnPackIdDirty();
            }
            case 12: {
                return pSdepSlnDepSessionBase.isPSDepSlnPackNameDirty();
            }
            case 13: {
                return pSdepSlnDepSessionBase.isUpdateDateDirty();
            }
            case 14: {
                return pSdepSlnDepSessionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSdepSlnDepSessionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSdepSlnDepSessionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getDepInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depinfo", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getDepInfo()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getDepState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depstate", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getDepState()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getMemo()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndepsessionid", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnDepSessionId()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslndepsessionname", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnDepSessionName()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnpackid", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnPackId()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnpackname", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getPSDepSlnPackName()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSdepSlnDepSessionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSdepSlnDepSessionBase.getJSONValue((Object)pSdepSlnDepSessionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSdepSlnDepSessionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSdepSlnDepSessionBase.getBeginTime() != null) {
            object = pSdepSlnDepSessionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSdepSlnDepSessionBase.getCreateDate() != null) {
            object = pSdepSlnDepSessionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSdepSlnDepSessionBase.getCreateMan() != null) {
            object = pSdepSlnDepSessionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getDepInfo() != null) {
            object = pSdepSlnDepSessionBase.getDepInfo();
            xmlNode.setAttribute(FIELD_DEPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getDepState() != null) {
            object = pSdepSlnDepSessionBase.getDepState();
            xmlNode.setAttribute(FIELD_DEPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSdepSlnDepSessionBase.getEndTime() != null) {
            object = pSdepSlnDepSessionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSdepSlnDepSessionBase.getMemo() != null) {
            object = pSdepSlnDepSessionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionId() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnDepSessionId();
            xmlNode.setAttribute(FIELD_PSDEPSLNDEPSESSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionName() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnDepSessionName();
            xmlNode.setAttribute(FIELD_PSDEPSLNDEPSESSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnId() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnName() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnPackId() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnPackId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getPSDepSlnPackName() != null) {
            object = pSdepSlnDepSessionBase.getPSDepSlnPackName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSdepSlnDepSessionBase.getUpdateDate() != null) {
            object = pSdepSlnDepSessionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSdepSlnDepSessionBase.getUpdateMan() != null) {
            object = pSdepSlnDepSessionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSdepSlnDepSessionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSdepSlnDepSessionBase.isBeginTimeDirty() && (bl || pSdepSlnDepSessionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSdepSlnDepSessionBase.getBeginTime());
        }
        if (pSdepSlnDepSessionBase.isCreateDateDirty() && (bl || pSdepSlnDepSessionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSdepSlnDepSessionBase.getCreateDate());
        }
        if (pSdepSlnDepSessionBase.isCreateManDirty() && (bl || pSdepSlnDepSessionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSdepSlnDepSessionBase.getCreateMan());
        }
        if (pSdepSlnDepSessionBase.isDepInfoDirty() && (bl || pSdepSlnDepSessionBase.getDepInfo() != null)) {
            iDataObject.set(FIELD_DEPINFO, (Object)pSdepSlnDepSessionBase.getDepInfo());
        }
        if (pSdepSlnDepSessionBase.isDepStateDirty() && (bl || pSdepSlnDepSessionBase.getDepState() != null)) {
            iDataObject.set(FIELD_DEPSTATE, (Object)pSdepSlnDepSessionBase.getDepState());
        }
        if (pSdepSlnDepSessionBase.isEndTimeDirty() && (bl || pSdepSlnDepSessionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSdepSlnDepSessionBase.getEndTime());
        }
        if (pSdepSlnDepSessionBase.isMemoDirty() && (bl || pSdepSlnDepSessionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSdepSlnDepSessionBase.getMemo());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnDepSessionIdDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDEPSESSIONID, (Object)pSdepSlnDepSessionBase.getPSDepSlnDepSessionId());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnDepSessionNameDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnDepSessionName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNDEPSESSIONNAME, (Object)pSdepSlnDepSessionBase.getPSDepSlnDepSessionName());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnIdDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSdepSlnDepSessionBase.getPSDepSlnId());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnNameDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSdepSlnDepSessionBase.getPSDepSlnName());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnPackIdDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnPackId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPACKID, (Object)pSdepSlnDepSessionBase.getPSDepSlnPackId());
        }
        if (pSdepSlnDepSessionBase.isPSDepSlnPackNameDirty() && (bl || pSdepSlnDepSessionBase.getPSDepSlnPackName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPACKNAME, (Object)pSdepSlnDepSessionBase.getPSDepSlnPackName());
        }
        if (pSdepSlnDepSessionBase.isUpdateDateDirty() && (bl || pSdepSlnDepSessionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSdepSlnDepSessionBase.getUpdateDate());
        }
        if (pSdepSlnDepSessionBase.isUpdateManDirty() && (bl || pSdepSlnDepSessionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSdepSlnDepSessionBase.getUpdateMan());
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
        return PSdepSlnDepSessionBase.remove(this, n);
    }

    private static boolean remove(PSdepSlnDepSessionBase pSdepSlnDepSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSdepSlnDepSessionBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSdepSlnDepSessionBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSdepSlnDepSessionBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSdepSlnDepSessionBase.resetDepInfo();
                return true;
            }
            case 4: {
                pSdepSlnDepSessionBase.resetDepState();
                return true;
            }
            case 5: {
                pSdepSlnDepSessionBase.resetEndTime();
                return true;
            }
            case 6: {
                pSdepSlnDepSessionBase.resetMemo();
                return true;
            }
            case 7: {
                pSdepSlnDepSessionBase.resetPSDepSlnDepSessionId();
                return true;
            }
            case 8: {
                pSdepSlnDepSessionBase.resetPSDepSlnDepSessionName();
                return true;
            }
            case 9: {
                pSdepSlnDepSessionBase.resetPSDepSlnId();
                return true;
            }
            case 10: {
                pSdepSlnDepSessionBase.resetPSDepSlnName();
                return true;
            }
            case 11: {
                pSdepSlnDepSessionBase.resetPSDepSlnPackId();
                return true;
            }
            case 12: {
                pSdepSlnDepSessionBase.resetPSDepSlnPackName();
                return true;
            }
            case 13: {
                pSdepSlnDepSessionBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSdepSlnDepSessionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnPack getPSDepSlnPack() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPack();
        }
        if (this.getPSDepSlnPackId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnPackLock;
        synchronized (n) {
            if (this.psdepslnpack != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnPackId(), (Object)this.psdepslnpack.getPSDepSlnPackId()) != 0L) {
                this.psdepslnpack = null;
            }
            if (this.psdepslnpack == null) {
                PSDepSlnPack pSDepSlnPack = new PSDepSlnPack();
                pSDepSlnPack.setPSDepSlnPackId(this.getPSDepSlnPackId());
                PSDepSlnPackService pSDepSlnPackService = (PSDepSlnPackService)ServiceGlobal.getService(PSDepSlnPackService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnPackService.autoGet((IEntity)pSDepSlnPack);
                this.psdepslnpack = pSDepSlnPack;
            }
            return this.psdepslnpack;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSdepSlnDepSessionBase getProxyEntity() {
        return this.proxyPSdepSlnDepSessionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSdepSlnDepSessionBase = null;
        if (iDataObject != null && iDataObject instanceof PSdepSlnDepSessionBase) {
            this.proxyPSdepSlnDepSessionBase = (PSdepSlnDepSessionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEPINFO, 3);
        fieldIndexMap.put(FIELD_DEPSTATE, 4);
        fieldIndexMap.put(FIELD_ENDTIME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNDEPSESSIONID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNDEPSESSIONNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNPACKID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNPACKNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

