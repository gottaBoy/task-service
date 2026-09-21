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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCNWFlowBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCNWFlowBase.class);
    public static final String FIELD_ACTIONINFO = "ACTIONINFO";
    public static final String FIELD_ACTIONTYPE = "ACTIONTYPE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FLOW = "FLOW";
    public static final String FIELD_PSDCNWFLOWID = "PSDCNWFLOWID";
    public static final String FIELD_PSDCNWFLOWNAME = "PSDCNWFLOWNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ACTIONINFO = 0;
    private static final int INDEX_ACTIONTYPE = 1;
    private static final int INDEX_BEGINTIME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENDTIME = 5;
    private static final int INDEX_FLOW = 6;
    private static final int INDEX_PSDCNWFLOWID = 7;
    private static final int INDEX_PSDCNWFLOWNAME = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCNWFlowBase proxyPSDCNWFlowBase = null;
    private boolean actioninfoDirtyFlag = false;
    private boolean actiontypeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean flowDirtyFlag = false;
    private boolean psdcnwflowidDirtyFlag = false;
    private boolean psdcnwflownameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="actioninfo")
    private String actioninfo;
    @Column(name="actiontype")
    private String actiontype;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="flow")
    private Integer flow;
    @Column(name="psdcnwflowid")
    private String psdcnwflowid;
    @Column(name="psdcnwflowname")
    private String psdcnwflowname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setActionInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actioninfo = string;
        this.actioninfoDirtyFlag = true;
    }

    public String getActionInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionInfo();
        }
        return this.actioninfo;
    }

    public boolean isActionInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionInfoDirty();
        }
        return this.actioninfoDirtyFlag;
    }

    public void resetActionInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionInfo();
            return;
        }
        this.actioninfoDirtyFlag = false;
        this.actioninfo = null;
    }

    public void setActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontype = string;
        this.actiontypeDirtyFlag = true;
    }

    public String getActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionType();
        }
        return this.actiontype;
    }

    public boolean isActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTypeDirty();
        }
        return this.actiontypeDirtyFlag;
    }

    public void resetActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionType();
            return;
        }
        this.actiontypeDirtyFlag = false;
        this.actiontype = null;
    }

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

    public void setFlow(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlow(n);
            return;
        }
        this.flow = n;
        this.flowDirtyFlag = true;
    }

    public Integer getFlow() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlow();
        }
        return this.flow;
    }

    public boolean isFlowDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlowDirty();
        }
        return this.flowDirtyFlag;
    }

    public void resetFlow() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlow();
            return;
        }
        this.flowDirtyFlag = false;
        this.flow = null;
    }

    public void setPSDCNWFlowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCNWFlowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcnwflowid = string;
        this.psdcnwflowidDirtyFlag = true;
    }

    public String getPSDCNWFlowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCNWFlowId();
        }
        return this.psdcnwflowid;
    }

    public boolean isPSDCNWFlowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNWFlowIdDirty();
        }
        return this.psdcnwflowidDirtyFlag;
    }

    public void resetPSDCNWFlowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCNWFlowId();
            return;
        }
        this.psdcnwflowidDirtyFlag = false;
        this.psdcnwflowid = null;
    }

    public void setPSDCNWFlowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCNWFlowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcnwflowname = string;
        this.psdcnwflownameDirtyFlag = true;
    }

    public String getPSDCNWFlowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCNWFlowName();
        }
        return this.psdcnwflowname;
    }

    public boolean isPSDCNWFlowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNWFlowNameDirty();
        }
        return this.psdcnwflownameDirtyFlag;
    }

    public void resetPSDCNWFlowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCNWFlowName();
            return;
        }
        this.psdcnwflownameDirtyFlag = false;
        this.psdcnwflowname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    protected void onReset() {
        PSDCNWFlowBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCNWFlowBase pSDCNWFlowBase) {
        pSDCNWFlowBase.resetActionInfo();
        pSDCNWFlowBase.resetActionType();
        pSDCNWFlowBase.resetBeginTime();
        pSDCNWFlowBase.resetCreateDate();
        pSDCNWFlowBase.resetCreateMan();
        pSDCNWFlowBase.resetEndTime();
        pSDCNWFlowBase.resetFlow();
        pSDCNWFlowBase.resetPSDCNWFlowId();
        pSDCNWFlowBase.resetPSDCNWFlowName();
        pSDCNWFlowBase.resetPSDevCenterId();
        pSDCNWFlowBase.resetPSDevCenterName();
        pSDCNWFlowBase.resetUpdateDate();
        pSDCNWFlowBase.resetUpdateMan();
        pSDCNWFlowBase.resetUserTag();
        pSDCNWFlowBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionInfoDirty()) {
            hashMap.put(FIELD_ACTIONINFO, this.getActionInfo());
        }
        if (!bl || this.isActionTypeDirty()) {
            hashMap.put(FIELD_ACTIONTYPE, this.getActionType());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isFlowDirty()) {
            hashMap.put(FIELD_FLOW, this.getFlow());
        }
        if (!bl || this.isPSDCNWFlowIdDirty()) {
            hashMap.put(FIELD_PSDCNWFLOWID, this.getPSDCNWFlowId());
        }
        if (!bl || this.isPSDCNWFlowNameDirty()) {
            hashMap.put(FIELD_PSDCNWFLOWNAME, this.getPSDCNWFlowName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDCNWFlowBase.get(this, n);
    }

    private static Object get(PSDCNWFlowBase pSDCNWFlowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCNWFlowBase.getActionInfo();
            }
            case 1: {
                return pSDCNWFlowBase.getActionType();
            }
            case 2: {
                return pSDCNWFlowBase.getBeginTime();
            }
            case 3: {
                return pSDCNWFlowBase.getCreateDate();
            }
            case 4: {
                return pSDCNWFlowBase.getCreateMan();
            }
            case 5: {
                return pSDCNWFlowBase.getEndTime();
            }
            case 6: {
                return pSDCNWFlowBase.getFlow();
            }
            case 7: {
                return pSDCNWFlowBase.getPSDCNWFlowId();
            }
            case 8: {
                return pSDCNWFlowBase.getPSDCNWFlowName();
            }
            case 9: {
                return pSDCNWFlowBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCNWFlowBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCNWFlowBase.getUpdateDate();
            }
            case 12: {
                return pSDCNWFlowBase.getUpdateMan();
            }
            case 13: {
                return pSDCNWFlowBase.getUserTag();
            }
            case 14: {
                return pSDCNWFlowBase.getUserTag2();
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
        PSDCNWFlowBase.set(this, n, object);
    }

    private static void set(PSDCNWFlowBase pSDCNWFlowBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCNWFlowBase.setActionInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCNWFlowBase.setActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCNWFlowBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCNWFlowBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCNWFlowBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCNWFlowBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCNWFlowBase.setFlow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDCNWFlowBase.setPSDCNWFlowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCNWFlowBase.setPSDCNWFlowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCNWFlowBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCNWFlowBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCNWFlowBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCNWFlowBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCNWFlowBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCNWFlowBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDCNWFlowBase.isNull(this, n);
    }

    private static boolean isNull(PSDCNWFlowBase pSDCNWFlowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCNWFlowBase.getActionInfo() == null;
            }
            case 1: {
                return pSDCNWFlowBase.getActionType() == null;
            }
            case 2: {
                return pSDCNWFlowBase.getBeginTime() == null;
            }
            case 3: {
                return pSDCNWFlowBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCNWFlowBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCNWFlowBase.getEndTime() == null;
            }
            case 6: {
                return pSDCNWFlowBase.getFlow() == null;
            }
            case 7: {
                return pSDCNWFlowBase.getPSDCNWFlowId() == null;
            }
            case 8: {
                return pSDCNWFlowBase.getPSDCNWFlowName() == null;
            }
            case 9: {
                return pSDCNWFlowBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCNWFlowBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCNWFlowBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCNWFlowBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDCNWFlowBase.getUserTag() == null;
            }
            case 14: {
                return pSDCNWFlowBase.getUserTag2() == null;
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
        return PSDCNWFlowBase.contains(this, n);
    }

    private static boolean contains(PSDCNWFlowBase pSDCNWFlowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCNWFlowBase.isActionInfoDirty();
            }
            case 1: {
                return pSDCNWFlowBase.isActionTypeDirty();
            }
            case 2: {
                return pSDCNWFlowBase.isBeginTimeDirty();
            }
            case 3: {
                return pSDCNWFlowBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCNWFlowBase.isCreateManDirty();
            }
            case 5: {
                return pSDCNWFlowBase.isEndTimeDirty();
            }
            case 6: {
                return pSDCNWFlowBase.isFlowDirty();
            }
            case 7: {
                return pSDCNWFlowBase.isPSDCNWFlowIdDirty();
            }
            case 8: {
                return pSDCNWFlowBase.isPSDCNWFlowNameDirty();
            }
            case 9: {
                return pSDCNWFlowBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCNWFlowBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCNWFlowBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCNWFlowBase.isUpdateManDirty();
            }
            case 13: {
                return pSDCNWFlowBase.isUserTagDirty();
            }
            case 14: {
                return pSDCNWFlowBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCNWFlowBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCNWFlowBase pSDCNWFlowBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCNWFlowBase.getActionInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actioninfo", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getActionInfo()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontype", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getActionType()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getFlow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flow", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getFlow()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getPSDCNWFlowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcnwflowid", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getPSDCNWFlowId()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getPSDCNWFlowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcnwflowname", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getPSDCNWFlowName()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCNWFlowBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCNWFlowBase.getJSONValue((Object)pSDCNWFlowBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCNWFlowBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCNWFlowBase pSDCNWFlowBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCNWFlowBase.getActionInfo() != null) {
            object = pSDCNWFlowBase.getActionInfo();
            xmlNode.setAttribute(FIELD_ACTIONINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSDCNWFlowBase.getActionType() != null) {
            object = pSDCNWFlowBase.getActionType();
            xmlNode.setAttribute(FIELD_ACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getBeginTime() != null) {
            object = pSDCNWFlowBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCNWFlowBase.getCreateDate() != null) {
            object = pSDCNWFlowBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCNWFlowBase.getCreateMan() != null) {
            object = pSDCNWFlowBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getEndTime() != null) {
            object = pSDCNWFlowBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCNWFlowBase.getFlow() != null) {
            object = pSDCNWFlowBase.getFlow();
            xmlNode.setAttribute(FIELD_FLOW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCNWFlowBase.getPSDCNWFlowId() != null) {
            object = pSDCNWFlowBase.getPSDCNWFlowId();
            xmlNode.setAttribute(FIELD_PSDCNWFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getPSDCNWFlowName() != null) {
            object = pSDCNWFlowBase.getPSDCNWFlowName();
            xmlNode.setAttribute(FIELD_PSDCNWFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getPSDevCenterId() != null) {
            object = pSDCNWFlowBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getPSDevCenterName() != null) {
            object = pSDCNWFlowBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getUpdateDate() != null) {
            object = pSDCNWFlowBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCNWFlowBase.getUpdateMan() != null) {
            object = pSDCNWFlowBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getUserTag() != null) {
            object = pSDCNWFlowBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCNWFlowBase.getUserTag2() != null) {
            object = pSDCNWFlowBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCNWFlowBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCNWFlowBase pSDCNWFlowBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCNWFlowBase.isActionInfoDirty() && (bl || pSDCNWFlowBase.getActionInfo() != null)) {
            iDataObject.set(FIELD_ACTIONINFO, (Object)pSDCNWFlowBase.getActionInfo());
        }
        if (pSDCNWFlowBase.isActionTypeDirty() && (bl || pSDCNWFlowBase.getActionType() != null)) {
            iDataObject.set(FIELD_ACTIONTYPE, (Object)pSDCNWFlowBase.getActionType());
        }
        if (pSDCNWFlowBase.isBeginTimeDirty() && (bl || pSDCNWFlowBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCNWFlowBase.getBeginTime());
        }
        if (pSDCNWFlowBase.isCreateDateDirty() && (bl || pSDCNWFlowBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCNWFlowBase.getCreateDate());
        }
        if (pSDCNWFlowBase.isCreateManDirty() && (bl || pSDCNWFlowBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCNWFlowBase.getCreateMan());
        }
        if (pSDCNWFlowBase.isEndTimeDirty() && (bl || pSDCNWFlowBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCNWFlowBase.getEndTime());
        }
        if (pSDCNWFlowBase.isFlowDirty() && (bl || pSDCNWFlowBase.getFlow() != null)) {
            iDataObject.set(FIELD_FLOW, (Object)pSDCNWFlowBase.getFlow());
        }
        if (pSDCNWFlowBase.isPSDCNWFlowIdDirty() && (bl || pSDCNWFlowBase.getPSDCNWFlowId() != null)) {
            iDataObject.set(FIELD_PSDCNWFLOWID, (Object)pSDCNWFlowBase.getPSDCNWFlowId());
        }
        if (pSDCNWFlowBase.isPSDCNWFlowNameDirty() && (bl || pSDCNWFlowBase.getPSDCNWFlowName() != null)) {
            iDataObject.set(FIELD_PSDCNWFLOWNAME, (Object)pSDCNWFlowBase.getPSDCNWFlowName());
        }
        if (pSDCNWFlowBase.isPSDevCenterIdDirty() && (bl || pSDCNWFlowBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCNWFlowBase.getPSDevCenterId());
        }
        if (pSDCNWFlowBase.isPSDevCenterNameDirty() && (bl || pSDCNWFlowBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCNWFlowBase.getPSDevCenterName());
        }
        if (pSDCNWFlowBase.isUpdateDateDirty() && (bl || pSDCNWFlowBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCNWFlowBase.getUpdateDate());
        }
        if (pSDCNWFlowBase.isUpdateManDirty() && (bl || pSDCNWFlowBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCNWFlowBase.getUpdateMan());
        }
        if (pSDCNWFlowBase.isUserTagDirty() && (bl || pSDCNWFlowBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCNWFlowBase.getUserTag());
        }
        if (pSDCNWFlowBase.isUserTag2Dirty() && (bl || pSDCNWFlowBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCNWFlowBase.getUserTag2());
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
        return PSDCNWFlowBase.remove(this, n);
    }

    private static boolean remove(PSDCNWFlowBase pSDCNWFlowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCNWFlowBase.resetActionInfo();
                return true;
            }
            case 1: {
                pSDCNWFlowBase.resetActionType();
                return true;
            }
            case 2: {
                pSDCNWFlowBase.resetBeginTime();
                return true;
            }
            case 3: {
                pSDCNWFlowBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCNWFlowBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCNWFlowBase.resetEndTime();
                return true;
            }
            case 6: {
                pSDCNWFlowBase.resetFlow();
                return true;
            }
            case 7: {
                pSDCNWFlowBase.resetPSDCNWFlowId();
                return true;
            }
            case 8: {
                pSDCNWFlowBase.resetPSDCNWFlowName();
                return true;
            }
            case 9: {
                pSDCNWFlowBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCNWFlowBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCNWFlowBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCNWFlowBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDCNWFlowBase.resetUserTag();
                return true;
            }
            case 14: {
                pSDCNWFlowBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCNWFlowBase getProxyEntity() {
        return this.proxyPSDCNWFlowBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCNWFlowBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCNWFlowBase) {
            this.proxyPSDCNWFlowBase = (PSDCNWFlowBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCNWFlowService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONINFO, 0);
        fieldIndexMap.put(FIELD_ACTIONTYPE, 1);
        fieldIndexMap.put(FIELD_BEGINTIME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENDTIME, 5);
        fieldIndexMap.put(FIELD_FLOW, 6);
        fieldIndexMap.put(FIELD_PSDCNWFLOWID, 7);
        fieldIndexMap.put(FIELD_PSDCNWFLOWNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
    }
}

