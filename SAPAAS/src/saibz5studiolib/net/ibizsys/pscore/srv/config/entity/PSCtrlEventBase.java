/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlEventBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlEventBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLCODENAMEFMT = "CTRLCODENAMEFMT";
    public static final String FIELD_EVENTARG = "EVENTARG";
    public static final String FIELD_EVENTARG2 = "EVENTARG2";
    public static final String FIELD_EVENTARG3 = "EVENTARG3";
    public static final String FIELD_EVENTARG4 = "EVENTARG4";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLEVENTID = "PSCTRLEVENTID";
    public static final String FIELD_PSCTRLEVENTNAME = "PSCTRLEVENTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWCODENAMEFMT = "VIEWCODENAMEFMT";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTRLCODENAMEFMT = 3;
    private static final int INDEX_EVENTARG = 4;
    private static final int INDEX_EVENTARG2 = 5;
    private static final int INDEX_EVENTARG3 = 6;
    private static final int INDEX_EVENTARG4 = 7;
    private static final int INDEX_LOGICNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSCTRLEVENTID = 10;
    private static final int INDEX_PSCTRLEVENTNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VIEWCODENAMEFMT = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlEventBase proxyPSCtrlEventBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlcodenamefmtDirtyFlag = false;
    private boolean eventargDirtyFlag = false;
    private boolean eventarg2DirtyFlag = false;
    private boolean eventarg3DirtyFlag = false;
    private boolean eventarg4DirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrleventidDirtyFlag = false;
    private boolean psctrleventnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewcodenamefmtDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlcodenamefmt")
    private String ctrlcodenamefmt;
    @Column(name="eventarg")
    private String eventarg;
    @Column(name="eventarg2")
    private String eventarg2;
    @Column(name="eventarg3")
    private String eventarg3;
    @Column(name="eventarg4")
    private String eventarg4;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrleventid")
    private String psctrleventid;
    @Column(name="psctrleventname")
    private String psctrleventname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewcodenamefmt")
    private String viewcodenamefmt;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setCtrlCodeNameFmt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlCodeNameFmt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlcodenamefmt = string;
        this.ctrlcodenamefmtDirtyFlag = true;
    }

    public String getCtrlCodeNameFmt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlCodeNameFmt();
        }
        return this.ctrlcodenamefmt;
    }

    public boolean isCtrlCodeNameFmtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlCodeNameFmtDirty();
        }
        return this.ctrlcodenamefmtDirtyFlag;
    }

    public void resetCtrlCodeNameFmt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlCodeNameFmt();
            return;
        }
        this.ctrlcodenamefmtDirtyFlag = false;
        this.ctrlcodenamefmt = null;
    }

    public void setEventArg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg = string;
        this.eventargDirtyFlag = true;
    }

    public String getEventArg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg();
        }
        return this.eventarg;
    }

    public boolean isEventArgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArgDirty();
        }
        return this.eventargDirtyFlag;
    }

    public void resetEventArg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg();
            return;
        }
        this.eventargDirtyFlag = false;
        this.eventarg = null;
    }

    public void setEventArg2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg2 = string;
        this.eventarg2DirtyFlag = true;
    }

    public String getEventArg2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg2();
        }
        return this.eventarg2;
    }

    public boolean isEventArg2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArg2Dirty();
        }
        return this.eventarg2DirtyFlag;
    }

    public void resetEventArg2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg2();
            return;
        }
        this.eventarg2DirtyFlag = false;
        this.eventarg2 = null;
    }

    public void setEventArg3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg3 = string;
        this.eventarg3DirtyFlag = true;
    }

    public String getEventArg3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg3();
        }
        return this.eventarg3;
    }

    public boolean isEventArg3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArg3Dirty();
        }
        return this.eventarg3DirtyFlag;
    }

    public void resetEventArg3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg3();
            return;
        }
        this.eventarg3DirtyFlag = false;
        this.eventarg3 = null;
    }

    public void setEventArg4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventArg4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventarg4 = string;
        this.eventarg4DirtyFlag = true;
    }

    public String getEventArg4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventArg4();
        }
        return this.eventarg4;
    }

    public boolean isEventArg4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventArg4Dirty();
        }
        return this.eventarg4DirtyFlag;
    }

    public void resetEventArg4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventArg4();
            return;
        }
        this.eventarg4DirtyFlag = false;
        this.eventarg4 = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSCtrlEventId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlEventId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrleventid = string;
        this.psctrleventidDirtyFlag = true;
    }

    public String getPSCtrlEventId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlEventId();
        }
        return this.psctrleventid;
    }

    public boolean isPSCtrlEventIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlEventIdDirty();
        }
        return this.psctrleventidDirtyFlag;
    }

    public void resetPSCtrlEventId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlEventId();
            return;
        }
        this.psctrleventidDirtyFlag = false;
        this.psctrleventid = null;
    }

    public void setPSCtrlEventName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlEventName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrleventname = string;
        this.psctrleventnameDirtyFlag = true;
    }

    public String getPSCtrlEventName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlEventName();
        }
        return this.psctrleventname;
    }

    public boolean isPSCtrlEventNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlEventNameDirty();
        }
        return this.psctrleventnameDirtyFlag;
    }

    public void resetPSCtrlEventName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlEventName();
            return;
        }
        this.psctrleventnameDirtyFlag = false;
        this.psctrleventname = null;
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

    public void setViewCodeNameFmt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCodeNameFmt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewcodenamefmt = string;
        this.viewcodenamefmtDirtyFlag = true;
    }

    public String getViewCodeNameFmt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCodeNameFmt();
        }
        return this.viewcodenamefmt;
    }

    public boolean isViewCodeNameFmtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCodeNameFmtDirty();
        }
        return this.viewcodenamefmtDirtyFlag;
    }

    public void resetViewCodeNameFmt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCodeNameFmt();
            return;
        }
        this.viewcodenamefmtDirtyFlag = false;
        this.viewcodenamefmt = null;
    }

    protected void onReset() {
        PSCtrlEventBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlEventBase pSCtrlEventBase) {
        pSCtrlEventBase.resetCodeName();
        pSCtrlEventBase.resetCreateDate();
        pSCtrlEventBase.resetCreateMan();
        pSCtrlEventBase.resetCtrlCodeNameFmt();
        pSCtrlEventBase.resetEventArg();
        pSCtrlEventBase.resetEventArg2();
        pSCtrlEventBase.resetEventArg3();
        pSCtrlEventBase.resetEventArg4();
        pSCtrlEventBase.resetLogicName();
        pSCtrlEventBase.resetMemo();
        pSCtrlEventBase.resetPSCtrlEventId();
        pSCtrlEventBase.resetPSCtrlEventName();
        pSCtrlEventBase.resetUpdateDate();
        pSCtrlEventBase.resetUpdateMan();
        pSCtrlEventBase.resetViewCodeNameFmt();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlCodeNameFmtDirty()) {
            hashMap.put(FIELD_CTRLCODENAMEFMT, this.getCtrlCodeNameFmt());
        }
        if (!bl || this.isEventArgDirty()) {
            hashMap.put(FIELD_EVENTARG, this.getEventArg());
        }
        if (!bl || this.isEventArg2Dirty()) {
            hashMap.put(FIELD_EVENTARG2, this.getEventArg2());
        }
        if (!bl || this.isEventArg3Dirty()) {
            hashMap.put(FIELD_EVENTARG3, this.getEventArg3());
        }
        if (!bl || this.isEventArg4Dirty()) {
            hashMap.put(FIELD_EVENTARG4, this.getEventArg4());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlEventIdDirty()) {
            hashMap.put(FIELD_PSCTRLEVENTID, this.getPSCtrlEventId());
        }
        if (!bl || this.isPSCtrlEventNameDirty()) {
            hashMap.put(FIELD_PSCTRLEVENTNAME, this.getPSCtrlEventName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewCodeNameFmtDirty()) {
            hashMap.put(FIELD_VIEWCODENAMEFMT, this.getViewCodeNameFmt());
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
        return PSCtrlEventBase.get(this, n);
    }

    private static Object get(PSCtrlEventBase pSCtrlEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlEventBase.getCodeName();
            }
            case 1: {
                return pSCtrlEventBase.getCreateDate();
            }
            case 2: {
                return pSCtrlEventBase.getCreateMan();
            }
            case 3: {
                return pSCtrlEventBase.getCtrlCodeNameFmt();
            }
            case 4: {
                return pSCtrlEventBase.getEventArg();
            }
            case 5: {
                return pSCtrlEventBase.getEventArg2();
            }
            case 6: {
                return pSCtrlEventBase.getEventArg3();
            }
            case 7: {
                return pSCtrlEventBase.getEventArg4();
            }
            case 8: {
                return pSCtrlEventBase.getLogicName();
            }
            case 9: {
                return pSCtrlEventBase.getMemo();
            }
            case 10: {
                return pSCtrlEventBase.getPSCtrlEventId();
            }
            case 11: {
                return pSCtrlEventBase.getPSCtrlEventName();
            }
            case 12: {
                return pSCtrlEventBase.getUpdateDate();
            }
            case 13: {
                return pSCtrlEventBase.getUpdateMan();
            }
            case 14: {
                return pSCtrlEventBase.getViewCodeNameFmt();
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
        PSCtrlEventBase.set(this, n, object);
    }

    private static void set(PSCtrlEventBase pSCtrlEventBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlEventBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlEventBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlEventBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlEventBase.setCtrlCodeNameFmt(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlEventBase.setEventArg(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlEventBase.setEventArg2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlEventBase.setEventArg3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlEventBase.setEventArg4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlEventBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlEventBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlEventBase.setPSCtrlEventId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlEventBase.setPSCtrlEventName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlEventBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlEventBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlEventBase.setViewCodeNameFmt(DataObject.getStringValue((Object)object));
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
        return PSCtrlEventBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlEventBase pSCtrlEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlEventBase.getCodeName() == null;
            }
            case 1: {
                return pSCtrlEventBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlEventBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlEventBase.getCtrlCodeNameFmt() == null;
            }
            case 4: {
                return pSCtrlEventBase.getEventArg() == null;
            }
            case 5: {
                return pSCtrlEventBase.getEventArg2() == null;
            }
            case 6: {
                return pSCtrlEventBase.getEventArg3() == null;
            }
            case 7: {
                return pSCtrlEventBase.getEventArg4() == null;
            }
            case 8: {
                return pSCtrlEventBase.getLogicName() == null;
            }
            case 9: {
                return pSCtrlEventBase.getMemo() == null;
            }
            case 10: {
                return pSCtrlEventBase.getPSCtrlEventId() == null;
            }
            case 11: {
                return pSCtrlEventBase.getPSCtrlEventName() == null;
            }
            case 12: {
                return pSCtrlEventBase.getUpdateDate() == null;
            }
            case 13: {
                return pSCtrlEventBase.getUpdateMan() == null;
            }
            case 14: {
                return pSCtrlEventBase.getViewCodeNameFmt() == null;
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
        return PSCtrlEventBase.contains(this, n);
    }

    private static boolean contains(PSCtrlEventBase pSCtrlEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlEventBase.isCodeNameDirty();
            }
            case 1: {
                return pSCtrlEventBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlEventBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlEventBase.isCtrlCodeNameFmtDirty();
            }
            case 4: {
                return pSCtrlEventBase.isEventArgDirty();
            }
            case 5: {
                return pSCtrlEventBase.isEventArg2Dirty();
            }
            case 6: {
                return pSCtrlEventBase.isEventArg3Dirty();
            }
            case 7: {
                return pSCtrlEventBase.isEventArg4Dirty();
            }
            case 8: {
                return pSCtrlEventBase.isLogicNameDirty();
            }
            case 9: {
                return pSCtrlEventBase.isMemoDirty();
            }
            case 10: {
                return pSCtrlEventBase.isPSCtrlEventIdDirty();
            }
            case 11: {
                return pSCtrlEventBase.isPSCtrlEventNameDirty();
            }
            case 12: {
                return pSCtrlEventBase.isUpdateDateDirty();
            }
            case 13: {
                return pSCtrlEventBase.isUpdateManDirty();
            }
            case 14: {
                return pSCtrlEventBase.isViewCodeNameFmtDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlEventBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlEventBase pSCtrlEventBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlEventBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getCtrlCodeNameFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlcodenamefmt", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getCtrlCodeNameFmt()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getEventArg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getEventArg()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getEventArg2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg2", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getEventArg2()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getEventArg3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg3", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getEventArg3()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getEventArg4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventarg4", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getEventArg4()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getLogicName()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getPSCtrlEventId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrleventid", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getPSCtrlEventId()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getPSCtrlEventName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrleventname", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getPSCtrlEventName()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlEventBase.getViewCodeNameFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcodenamefmt", (Object)PSCtrlEventBase.getJSONValue((Object)pSCtrlEventBase.getViewCodeNameFmt()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlEventBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlEventBase pSCtrlEventBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlEventBase.getCodeName() != null) {
            object = pSCtrlEventBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getCreateDate() != null) {
            object = pSCtrlEventBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlEventBase.getCreateMan() != null) {
            object = pSCtrlEventBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getCtrlCodeNameFmt() != null) {
            object = pSCtrlEventBase.getCtrlCodeNameFmt();
            xmlNode.setAttribute(FIELD_CTRLCODENAMEFMT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getEventArg() != null) {
            object = pSCtrlEventBase.getEventArg();
            xmlNode.setAttribute(FIELD_EVENTARG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getEventArg2() != null) {
            object = pSCtrlEventBase.getEventArg2();
            xmlNode.setAttribute(FIELD_EVENTARG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getEventArg3() != null) {
            object = pSCtrlEventBase.getEventArg3();
            xmlNode.setAttribute(FIELD_EVENTARG3, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getEventArg4() != null) {
            object = pSCtrlEventBase.getEventArg4();
            xmlNode.setAttribute(FIELD_EVENTARG4, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getLogicName() != null) {
            object = pSCtrlEventBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getMemo() != null) {
            object = pSCtrlEventBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getPSCtrlEventId() != null) {
            object = pSCtrlEventBase.getPSCtrlEventId();
            xmlNode.setAttribute(FIELD_PSCTRLEVENTID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getPSCtrlEventName() != null) {
            object = pSCtrlEventBase.getPSCtrlEventName();
            xmlNode.setAttribute(FIELD_PSCTRLEVENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getUpdateDate() != null) {
            object = pSCtrlEventBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlEventBase.getUpdateMan() != null) {
            object = pSCtrlEventBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlEventBase.getViewCodeNameFmt() != null) {
            object = pSCtrlEventBase.getViewCodeNameFmt();
            xmlNode.setAttribute(FIELD_VIEWCODENAMEFMT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlEventBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlEventBase pSCtrlEventBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlEventBase.isCodeNameDirty() && (bl || pSCtrlEventBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCtrlEventBase.getCodeName());
        }
        if (pSCtrlEventBase.isCreateDateDirty() && (bl || pSCtrlEventBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlEventBase.getCreateDate());
        }
        if (pSCtrlEventBase.isCreateManDirty() && (bl || pSCtrlEventBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlEventBase.getCreateMan());
        }
        if (pSCtrlEventBase.isCtrlCodeNameFmtDirty() && (bl || pSCtrlEventBase.getCtrlCodeNameFmt() != null)) {
            iDataObject.set(FIELD_CTRLCODENAMEFMT, (Object)pSCtrlEventBase.getCtrlCodeNameFmt());
        }
        if (pSCtrlEventBase.isEventArgDirty() && (bl || pSCtrlEventBase.getEventArg() != null)) {
            iDataObject.set(FIELD_EVENTARG, (Object)pSCtrlEventBase.getEventArg());
        }
        if (pSCtrlEventBase.isEventArg2Dirty() && (bl || pSCtrlEventBase.getEventArg2() != null)) {
            iDataObject.set(FIELD_EVENTARG2, (Object)pSCtrlEventBase.getEventArg2());
        }
        if (pSCtrlEventBase.isEventArg3Dirty() && (bl || pSCtrlEventBase.getEventArg3() != null)) {
            iDataObject.set(FIELD_EVENTARG3, (Object)pSCtrlEventBase.getEventArg3());
        }
        if (pSCtrlEventBase.isEventArg4Dirty() && (bl || pSCtrlEventBase.getEventArg4() != null)) {
            iDataObject.set(FIELD_EVENTARG4, (Object)pSCtrlEventBase.getEventArg4());
        }
        if (pSCtrlEventBase.isLogicNameDirty() && (bl || pSCtrlEventBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSCtrlEventBase.getLogicName());
        }
        if (pSCtrlEventBase.isMemoDirty() && (bl || pSCtrlEventBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlEventBase.getMemo());
        }
        if (pSCtrlEventBase.isPSCtrlEventIdDirty() && (bl || pSCtrlEventBase.getPSCtrlEventId() != null)) {
            iDataObject.set(FIELD_PSCTRLEVENTID, (Object)pSCtrlEventBase.getPSCtrlEventId());
        }
        if (pSCtrlEventBase.isPSCtrlEventNameDirty() && (bl || pSCtrlEventBase.getPSCtrlEventName() != null)) {
            iDataObject.set(FIELD_PSCTRLEVENTNAME, (Object)pSCtrlEventBase.getPSCtrlEventName());
        }
        if (pSCtrlEventBase.isUpdateDateDirty() && (bl || pSCtrlEventBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlEventBase.getUpdateDate());
        }
        if (pSCtrlEventBase.isUpdateManDirty() && (bl || pSCtrlEventBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlEventBase.getUpdateMan());
        }
        if (pSCtrlEventBase.isViewCodeNameFmtDirty() && (bl || pSCtrlEventBase.getViewCodeNameFmt() != null)) {
            iDataObject.set(FIELD_VIEWCODENAMEFMT, (Object)pSCtrlEventBase.getViewCodeNameFmt());
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
        return PSCtrlEventBase.remove(this, n);
    }

    private static boolean remove(PSCtrlEventBase pSCtrlEventBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlEventBase.resetCodeName();
                return true;
            }
            case 1: {
                pSCtrlEventBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlEventBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlEventBase.resetCtrlCodeNameFmt();
                return true;
            }
            case 4: {
                pSCtrlEventBase.resetEventArg();
                return true;
            }
            case 5: {
                pSCtrlEventBase.resetEventArg2();
                return true;
            }
            case 6: {
                pSCtrlEventBase.resetEventArg3();
                return true;
            }
            case 7: {
                pSCtrlEventBase.resetEventArg4();
                return true;
            }
            case 8: {
                pSCtrlEventBase.resetLogicName();
                return true;
            }
            case 9: {
                pSCtrlEventBase.resetMemo();
                return true;
            }
            case 10: {
                pSCtrlEventBase.resetPSCtrlEventId();
                return true;
            }
            case 11: {
                pSCtrlEventBase.resetPSCtrlEventName();
                return true;
            }
            case 12: {
                pSCtrlEventBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSCtrlEventBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSCtrlEventBase.resetViewCodeNameFmt();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCtrlEventBase getProxyEntity() {
        return this.proxyPSCtrlEventBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlEventBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlEventBase) {
            this.proxyPSCtrlEventBase = (PSCtrlEventBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlEventService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLCODENAMEFMT, 3);
        fieldIndexMap.put(FIELD_EVENTARG, 4);
        fieldIndexMap.put(FIELD_EVENTARG2, 5);
        fieldIndexMap.put(FIELD_EVENTARG3, 6);
        fieldIndexMap.put(FIELD_EVENTARG4, 7);
        fieldIndexMap.put(FIELD_LOGICNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSCTRLEVENTID, 10);
        fieldIndexMap.put(FIELD_PSCTRLEVENTNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VIEWCODENAMEFMT, 14);
    }
}

