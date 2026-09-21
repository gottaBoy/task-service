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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORPSAPPVIEWID = "MAJORPSAPPVIEWID";
    public static final String FIELD_MAJORPSAPPVIEWNAME = "MAJORPSAPPVIEWNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSAPPVIEWID = "MINORPSAPPVIEWID";
    public static final String FIELD_MINORPSAPPVIEWNAME = "MINORPSAPPVIEWNAME";
    public static final String FIELD_OPENMODE = "OPENMODE";
    public static final String FIELD_PSAPPVIEWREFID = "PSAPPVIEWREFID";
    public static final String FIELD_PSAPPVIEWREFNAME = "PSAPPVIEWREFNAME";
    public static final String FIELD_REFMODETEXT = "REFMODETEXT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAJORPSAPPVIEWID = 2;
    private static final int INDEX_MAJORPSAPPVIEWNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MINORPSAPPVIEWID = 5;
    private static final int INDEX_MINORPSAPPVIEWNAME = 6;
    private static final int INDEX_OPENMODE = 7;
    private static final int INDEX_PSAPPVIEWREFID = 8;
    private static final int INDEX_PSAPPVIEWREFNAME = 9;
    private static final int INDEX_REFMODETEXT = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewRefBase proxyPSAppViewRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majorpsappviewidDirtyFlag = false;
    private boolean majorpsappviewnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsappviewidDirtyFlag = false;
    private boolean minorpsappviewnameDirtyFlag = false;
    private boolean openmodeDirtyFlag = false;
    private boolean psappviewrefidDirtyFlag = false;
    private boolean psappviewrefnameDirtyFlag = false;
    private boolean refmodetextDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majorpsappviewid")
    private String majorpsappviewid;
    @Column(name="majorpsappviewname")
    private String majorpsappviewname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsappviewid")
    private String minorpsappviewid;
    @Column(name="minorpsappviewname")
    private String minorpsappviewname;
    @Column(name="openmode")
    private String openmode;
    @Column(name="psappviewrefid")
    private String psappviewrefid;
    @Column(name="psappviewrefname")
    private String psappviewrefname;
    @Column(name="refmodetext")
    private String refmodetext;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objMajorPSAppViewLock = new Integer(1);
    private PSAppView majorpsappview = null;
    private Integer objMinorPSAppViewLock = new Integer(1);
    private PSAppView minorpsappview = null;

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

    public void setMajorPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsappviewid = string;
        this.majorpsappviewidDirtyFlag = true;
    }

    public String getMajorPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSAppViewId();
        }
        return this.majorpsappviewid;
    }

    public boolean isMajorPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSAppViewIdDirty();
        }
        return this.majorpsappviewidDirtyFlag;
    }

    public void resetMajorPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSAppViewId();
            return;
        }
        this.majorpsappviewidDirtyFlag = false;
        this.majorpsappviewid = null;
    }

    public void setMajorPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsappviewname = string;
        this.majorpsappviewnameDirtyFlag = true;
    }

    public String getMajorPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSAppViewName();
        }
        return this.majorpsappviewname;
    }

    public boolean isMajorPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSAppViewNameDirty();
        }
        return this.majorpsappviewnameDirtyFlag;
    }

    public void resetMajorPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSAppViewName();
            return;
        }
        this.majorpsappviewnameDirtyFlag = false;
        this.majorpsappviewname = null;
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

    public void setMinorPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsappviewid = string;
        this.minorpsappviewidDirtyFlag = true;
    }

    public String getMinorPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSAppViewId();
        }
        return this.minorpsappviewid;
    }

    public boolean isMinorPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSAppViewIdDirty();
        }
        return this.minorpsappviewidDirtyFlag;
    }

    public void resetMinorPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSAppViewId();
            return;
        }
        this.minorpsappviewidDirtyFlag = false;
        this.minorpsappviewid = null;
    }

    public void setMinorPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsappviewname = string;
        this.minorpsappviewnameDirtyFlag = true;
    }

    public String getMinorPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSAppViewName();
        }
        return this.minorpsappviewname;
    }

    public boolean isMinorPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSAppViewNameDirty();
        }
        return this.minorpsappviewnameDirtyFlag;
    }

    public void resetMinorPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSAppViewName();
            return;
        }
        this.minorpsappviewnameDirtyFlag = false;
        this.minorpsappviewname = null;
    }

    public void setOpenMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openmode = string;
        this.openmodeDirtyFlag = true;
    }

    public String getOpenMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenMode();
        }
        return this.openmode;
    }

    public boolean isOpenModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenModeDirty();
        }
        return this.openmodeDirtyFlag;
    }

    public void resetOpenMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenMode();
            return;
        }
        this.openmodeDirtyFlag = false;
        this.openmode = null;
    }

    public void setPSAppViewRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewrefid = string;
        this.psappviewrefidDirtyFlag = true;
    }

    public String getPSAppViewRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewRefId();
        }
        return this.psappviewrefid;
    }

    public boolean isPSAppViewRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewRefIdDirty();
        }
        return this.psappviewrefidDirtyFlag;
    }

    public void resetPSAppViewRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewRefId();
            return;
        }
        this.psappviewrefidDirtyFlag = false;
        this.psappviewrefid = null;
    }

    public void setPSAppViewRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewrefname = string;
        this.psappviewrefnameDirtyFlag = true;
    }

    public String getPSAppViewRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewRefName();
        }
        return this.psappviewrefname;
    }

    public boolean isPSAppViewRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewRefNameDirty();
        }
        return this.psappviewrefnameDirtyFlag;
    }

    public void resetPSAppViewRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewRefName();
            return;
        }
        this.psappviewrefnameDirtyFlag = false;
        this.psappviewrefname = null;
    }

    public void setRefModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodetext = string;
        this.refmodetextDirtyFlag = true;
    }

    public String getRefModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModeText();
        }
        return this.refmodetext;
    }

    public boolean isRefModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeTextDirty();
        }
        return this.refmodetextDirtyFlag;
    }

    public void resetRefModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModeText();
            return;
        }
        this.refmodetextDirtyFlag = false;
        this.refmodetext = null;
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
        PSAppViewRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewRefBase pSAppViewRefBase) {
        pSAppViewRefBase.resetCreateDate();
        pSAppViewRefBase.resetCreateMan();
        pSAppViewRefBase.resetMajorPSAppViewId();
        pSAppViewRefBase.resetMajorPSAppViewName();
        pSAppViewRefBase.resetMemo();
        pSAppViewRefBase.resetMinorPSAppViewId();
        pSAppViewRefBase.resetMinorPSAppViewName();
        pSAppViewRefBase.resetOpenMode();
        pSAppViewRefBase.resetPSAppViewRefId();
        pSAppViewRefBase.resetPSAppViewRefName();
        pSAppViewRefBase.resetRefModeText();
        pSAppViewRefBase.resetUpdateDate();
        pSAppViewRefBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMajorPSAppViewIdDirty()) {
            hashMap.put(FIELD_MAJORPSAPPVIEWID, this.getMajorPSAppViewId());
        }
        if (!bl || this.isMajorPSAppViewNameDirty()) {
            hashMap.put(FIELD_MAJORPSAPPVIEWNAME, this.getMajorPSAppViewName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSAppViewIdDirty()) {
            hashMap.put(FIELD_MINORPSAPPVIEWID, this.getMinorPSAppViewId());
        }
        if (!bl || this.isMinorPSAppViewNameDirty()) {
            hashMap.put(FIELD_MINORPSAPPVIEWNAME, this.getMinorPSAppViewName());
        }
        if (!bl || this.isOpenModeDirty()) {
            hashMap.put(FIELD_OPENMODE, this.getOpenMode());
        }
        if (!bl || this.isPSAppViewRefIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWREFID, this.getPSAppViewRefId());
        }
        if (!bl || this.isPSAppViewRefNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWREFNAME, this.getPSAppViewRefName());
        }
        if (!bl || this.isRefModeTextDirty()) {
            hashMap.put(FIELD_REFMODETEXT, this.getRefModeText());
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
        return PSAppViewRefBase.get(this, n);
    }

    private static Object get(PSAppViewRefBase pSAppViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewRefBase.getCreateDate();
            }
            case 1: {
                return pSAppViewRefBase.getCreateMan();
            }
            case 2: {
                return pSAppViewRefBase.getMajorPSAppViewId();
            }
            case 3: {
                return pSAppViewRefBase.getMajorPSAppViewName();
            }
            case 4: {
                return pSAppViewRefBase.getMemo();
            }
            case 5: {
                return pSAppViewRefBase.getMinorPSAppViewId();
            }
            case 6: {
                return pSAppViewRefBase.getMinorPSAppViewName();
            }
            case 7: {
                return pSAppViewRefBase.getOpenMode();
            }
            case 8: {
                return pSAppViewRefBase.getPSAppViewRefId();
            }
            case 9: {
                return pSAppViewRefBase.getPSAppViewRefName();
            }
            case 10: {
                return pSAppViewRefBase.getRefModeText();
            }
            case 11: {
                return pSAppViewRefBase.getUpdateDate();
            }
            case 12: {
                return pSAppViewRefBase.getUpdateMan();
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
        PSAppViewRefBase.set(this, n, object);
    }

    private static void set(PSAppViewRefBase pSAppViewRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewRefBase.setMajorPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewRefBase.setMajorPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewRefBase.setMinorPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewRefBase.setMinorPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewRefBase.setOpenMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewRefBase.setPSAppViewRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewRefBase.setPSAppViewRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppViewRefBase.setRefModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppViewRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSAppViewRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppViewRefBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewRefBase pSAppViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppViewRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppViewRefBase.getMajorPSAppViewId() == null;
            }
            case 3: {
                return pSAppViewRefBase.getMajorPSAppViewName() == null;
            }
            case 4: {
                return pSAppViewRefBase.getMemo() == null;
            }
            case 5: {
                return pSAppViewRefBase.getMinorPSAppViewId() == null;
            }
            case 6: {
                return pSAppViewRefBase.getMinorPSAppViewName() == null;
            }
            case 7: {
                return pSAppViewRefBase.getOpenMode() == null;
            }
            case 8: {
                return pSAppViewRefBase.getPSAppViewRefId() == null;
            }
            case 9: {
                return pSAppViewRefBase.getPSAppViewRefName() == null;
            }
            case 10: {
                return pSAppViewRefBase.getRefModeText() == null;
            }
            case 11: {
                return pSAppViewRefBase.getUpdateDate() == null;
            }
            case 12: {
                return pSAppViewRefBase.getUpdateMan() == null;
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
        return PSAppViewRefBase.contains(this, n);
    }

    private static boolean contains(PSAppViewRefBase pSAppViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppViewRefBase.isCreateManDirty();
            }
            case 2: {
                return pSAppViewRefBase.isMajorPSAppViewIdDirty();
            }
            case 3: {
                return pSAppViewRefBase.isMajorPSAppViewNameDirty();
            }
            case 4: {
                return pSAppViewRefBase.isMemoDirty();
            }
            case 5: {
                return pSAppViewRefBase.isMinorPSAppViewIdDirty();
            }
            case 6: {
                return pSAppViewRefBase.isMinorPSAppViewNameDirty();
            }
            case 7: {
                return pSAppViewRefBase.isOpenModeDirty();
            }
            case 8: {
                return pSAppViewRefBase.isPSAppViewRefIdDirty();
            }
            case 9: {
                return pSAppViewRefBase.isPSAppViewRefNameDirty();
            }
            case 10: {
                return pSAppViewRefBase.isRefModeTextDirty();
            }
            case 11: {
                return pSAppViewRefBase.isUpdateDateDirty();
            }
            case 12: {
                return pSAppViewRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewRefBase pSAppViewRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getMajorPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsappviewid", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getMajorPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getMajorPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsappviewname", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getMajorPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getMinorPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsappviewid", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getMinorPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getMinorPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsappviewname", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getMinorPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getOpenMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openmode", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getOpenMode()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getPSAppViewRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewrefid", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getPSAppViewRefId()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getPSAppViewRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewrefname", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getPSAppViewRefName()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getRefModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodetext", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getRefModeText()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewRefBase.getJSONValue((Object)pSAppViewRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewRefBase pSAppViewRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewRefBase.getCreateDate() != null) {
            object = pSAppViewRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewRefBase.getCreateMan() != null) {
            object = pSAppViewRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getMajorPSAppViewId() != null) {
            object = pSAppViewRefBase.getMajorPSAppViewId();
            xmlNode.setAttribute(FIELD_MAJORPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getMajorPSAppViewName() != null) {
            object = pSAppViewRefBase.getMajorPSAppViewName();
            xmlNode.setAttribute(FIELD_MAJORPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getMemo() != null) {
            object = pSAppViewRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getMinorPSAppViewId() != null) {
            object = pSAppViewRefBase.getMinorPSAppViewId();
            xmlNode.setAttribute(FIELD_MINORPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getMinorPSAppViewName() != null) {
            object = pSAppViewRefBase.getMinorPSAppViewName();
            xmlNode.setAttribute(FIELD_MINORPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getOpenMode() != null) {
            object = pSAppViewRefBase.getOpenMode();
            xmlNode.setAttribute(FIELD_OPENMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getPSAppViewRefId() != null) {
            object = pSAppViewRefBase.getPSAppViewRefId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWREFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getPSAppViewRefName() != null) {
            object = pSAppViewRefBase.getPSAppViewRefName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getRefModeText() != null) {
            object = pSAppViewRefBase.getRefModeText();
            xmlNode.setAttribute(FIELD_REFMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewRefBase.getUpdateDate() != null) {
            object = pSAppViewRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewRefBase.getUpdateMan() != null) {
            object = pSAppViewRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewRefBase pSAppViewRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewRefBase.isCreateDateDirty() && (bl || pSAppViewRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewRefBase.getCreateDate());
        }
        if (pSAppViewRefBase.isCreateManDirty() && (bl || pSAppViewRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewRefBase.getCreateMan());
        }
        if (pSAppViewRefBase.isMajorPSAppViewIdDirty() && (bl || pSAppViewRefBase.getMajorPSAppViewId() != null)) {
            iDataObject.set(FIELD_MAJORPSAPPVIEWID, (Object)pSAppViewRefBase.getMajorPSAppViewId());
        }
        if (pSAppViewRefBase.isMajorPSAppViewNameDirty() && (bl || pSAppViewRefBase.getMajorPSAppViewName() != null)) {
            iDataObject.set(FIELD_MAJORPSAPPVIEWNAME, (Object)pSAppViewRefBase.getMajorPSAppViewName());
        }
        if (pSAppViewRefBase.isMemoDirty() && (bl || pSAppViewRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewRefBase.getMemo());
        }
        if (pSAppViewRefBase.isMinorPSAppViewIdDirty() && (bl || pSAppViewRefBase.getMinorPSAppViewId() != null)) {
            iDataObject.set(FIELD_MINORPSAPPVIEWID, (Object)pSAppViewRefBase.getMinorPSAppViewId());
        }
        if (pSAppViewRefBase.isMinorPSAppViewNameDirty() && (bl || pSAppViewRefBase.getMinorPSAppViewName() != null)) {
            iDataObject.set(FIELD_MINORPSAPPVIEWNAME, (Object)pSAppViewRefBase.getMinorPSAppViewName());
        }
        if (pSAppViewRefBase.isOpenModeDirty() && (bl || pSAppViewRefBase.getOpenMode() != null)) {
            iDataObject.set(FIELD_OPENMODE, (Object)pSAppViewRefBase.getOpenMode());
        }
        if (pSAppViewRefBase.isPSAppViewRefIdDirty() && (bl || pSAppViewRefBase.getPSAppViewRefId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWREFID, (Object)pSAppViewRefBase.getPSAppViewRefId());
        }
        if (pSAppViewRefBase.isPSAppViewRefNameDirty() && (bl || pSAppViewRefBase.getPSAppViewRefName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWREFNAME, (Object)pSAppViewRefBase.getPSAppViewRefName());
        }
        if (pSAppViewRefBase.isRefModeTextDirty() && (bl || pSAppViewRefBase.getRefModeText() != null)) {
            iDataObject.set(FIELD_REFMODETEXT, (Object)pSAppViewRefBase.getRefModeText());
        }
        if (pSAppViewRefBase.isUpdateDateDirty() && (bl || pSAppViewRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewRefBase.getUpdateDate());
        }
        if (pSAppViewRefBase.isUpdateManDirty() && (bl || pSAppViewRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewRefBase.getUpdateMan());
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
        return PSAppViewRefBase.remove(this, n);
    }

    private static boolean remove(PSAppViewRefBase pSAppViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppViewRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppViewRefBase.resetMajorPSAppViewId();
                return true;
            }
            case 3: {
                pSAppViewRefBase.resetMajorPSAppViewName();
                return true;
            }
            case 4: {
                pSAppViewRefBase.resetMemo();
                return true;
            }
            case 5: {
                pSAppViewRefBase.resetMinorPSAppViewId();
                return true;
            }
            case 6: {
                pSAppViewRefBase.resetMinorPSAppViewName();
                return true;
            }
            case 7: {
                pSAppViewRefBase.resetOpenMode();
                return true;
            }
            case 8: {
                pSAppViewRefBase.resetPSAppViewRefId();
                return true;
            }
            case 9: {
                pSAppViewRefBase.resetPSAppViewRefName();
                return true;
            }
            case 10: {
                pSAppViewRefBase.resetRefModeText();
                return true;
            }
            case 11: {
                pSAppViewRefBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSAppViewRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getMajorPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSAppView();
        }
        if (this.getMajorPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objMajorPSAppViewLock;
        synchronized (n) {
            if (this.majorpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSAppViewId(), (Object)this.majorpsappview.getPSAppViewId()) != 0L) {
                this.majorpsappview = null;
            }
            if (this.majorpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getMajorPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.majorpsappview = pSAppView;
            }
            return this.majorpsappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getMinorPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSAppView();
        }
        if (this.getMinorPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objMinorPSAppViewLock;
        synchronized (n) {
            if (this.minorpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSAppViewId(), (Object)this.minorpsappview.getPSAppViewId()) != 0L) {
                this.minorpsappview = null;
            }
            if (this.minorpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getMinorPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.minorpsappview = pSAppView;
            }
            return this.minorpsappview;
        }
    }

    private PSAppViewRefBase getProxyEntity() {
        return this.proxyPSAppViewRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewRefBase) {
            this.proxyPSAppViewRefBase = (PSAppViewRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAJORPSAPPVIEWID, 2);
        fieldIndexMap.put(FIELD_MAJORPSAPPVIEWNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MINORPSAPPVIEWID, 5);
        fieldIndexMap.put(FIELD_MINORPSAPPVIEWNAME, 6);
        fieldIndexMap.put(FIELD_OPENMODE, 7);
        fieldIndexMap.put(FIELD_PSAPPVIEWREFID, 8);
        fieldIndexMap.put(FIELD_PSAPPVIEWREFNAME, 9);
        fieldIndexMap.put(FIELD_REFMODETEXT, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

