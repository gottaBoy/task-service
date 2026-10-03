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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSModelBookmark;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSModelBookmarkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelBookmarkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelBookmarkBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FOLDERFLAG = "FOLDERFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSMODELBOOKMARKID = "PPSMODELBOOKMARKID";
    public static final String FIELD_PPSMODELBOOKMARKNAME = "PPSMODELBOOKMARKNAME";
    public static final String FIELD_PSMODELBOOKMARKID = "PSMODELBOOKMARKID";
    public static final String FIELD_PSMODELBOOKMARKNAME = "PSMODELBOOKMARKNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FOLDERFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PPSMODELBOOKMARKID = 4;
    private static final int INDEX_PPSMODELBOOKMARKNAME = 5;
    private static final int INDEX_PSMODELBOOKMARKID = 6;
    private static final int INDEX_PSMODELBOOKMARKNAME = 7;
    private static final int INDEX_PSOBJID = 8;
    private static final int INDEX_PSOBJNAME = 9;
    private static final int INDEX_PSOBJTYPE = 10;
    private static final int INDEX_PSOBJTYPENAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelBookmarkBase proxyPSModelBookmarkBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean folderflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsmodelbookmarkidDirtyFlag = false;
    private boolean ppsmodelbookmarknameDirtyFlag = false;
    private boolean psmodelbookmarkidDirtyFlag = false;
    private boolean psmodelbookmarknameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="folderflag")
    private Integer folderflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsmodelbookmarkid")
    private String ppsmodelbookmarkid;
    @Column(name="ppsmodelbookmarkname")
    private String ppsmodelbookmarkname;
    @Column(name="psmodelbookmarkid")
    private String psmodelbookmarkid;
    @Column(name="psmodelbookmarkname")
    private String psmodelbookmarkname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSModelBookmarkLock = new Integer(1);
    private PSModelBookmark ppsmodelbookmark = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setFolderFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderFlag(n);
            return;
        }
        this.folderflag = n;
        this.folderflagDirtyFlag = true;
    }

    public Integer getFolderFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderFlag();
        }
        return this.folderflag;
    }

    public boolean isFolderFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderFlagDirty();
        }
        return this.folderflagDirtyFlag;
    }

    public void resetFolderFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderFlag();
            return;
        }
        this.folderflagDirtyFlag = false;
        this.folderflag = null;
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

    public void setPPSModelBookmarkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelBookmarkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelbookmarkid = string;
        this.ppsmodelbookmarkidDirtyFlag = true;
    }

    public String getPPSModelBookmarkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelBookmarkId();
        }
        return this.ppsmodelbookmarkid;
    }

    public boolean isPPSModelBookmarkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelBookmarkIdDirty();
        }
        return this.ppsmodelbookmarkidDirtyFlag;
    }

    public void resetPPSModelBookmarkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelBookmarkId();
            return;
        }
        this.ppsmodelbookmarkidDirtyFlag = false;
        this.ppsmodelbookmarkid = null;
    }

    public void setPPSModelBookmarkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelBookmarkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelbookmarkname = string;
        this.ppsmodelbookmarknameDirtyFlag = true;
    }

    public String getPPSModelBookmarkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelBookmarkName();
        }
        return this.ppsmodelbookmarkname;
    }

    public boolean isPPSModelBookmarkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelBookmarkNameDirty();
        }
        return this.ppsmodelbookmarknameDirtyFlag;
    }

    public void resetPPSModelBookmarkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelBookmarkName();
            return;
        }
        this.ppsmodelbookmarknameDirtyFlag = false;
        this.ppsmodelbookmarkname = null;
    }

    public void setPSModelBookmarkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelBookmarkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelbookmarkid = string;
        this.psmodelbookmarkidDirtyFlag = true;
    }

    public String getPSModelBookmarkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelBookmarkId();
        }
        return this.psmodelbookmarkid;
    }

    public boolean isPSModelBookmarkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelBookmarkIdDirty();
        }
        return this.psmodelbookmarkidDirtyFlag;
    }

    public void resetPSModelBookmarkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelBookmarkId();
            return;
        }
        this.psmodelbookmarkidDirtyFlag = false;
        this.psmodelbookmarkid = null;
    }

    public void setPSModelBookmarkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelBookmarkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelbookmarkname = string;
        this.psmodelbookmarknameDirtyFlag = true;
    }

    public String getPSModelBookmarkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelBookmarkName();
        }
        return this.psmodelbookmarkname;
    }

    public boolean isPSModelBookmarkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelBookmarkNameDirty();
        }
        return this.psmodelbookmarknameDirtyFlag;
    }

    public void resetPSModelBookmarkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelBookmarkName();
            return;
        }
        this.psmodelbookmarknameDirtyFlag = false;
        this.psmodelbookmarkname = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSModelBookmarkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelBookmarkBase pSModelBookmarkBase) {
        pSModelBookmarkBase.resetCreateDate();
        pSModelBookmarkBase.resetCreateMan();
        pSModelBookmarkBase.resetFolderFlag();
        pSModelBookmarkBase.resetMemo();
        pSModelBookmarkBase.resetPPSModelBookmarkId();
        pSModelBookmarkBase.resetPPSModelBookmarkName();
        pSModelBookmarkBase.resetPSModelBookmarkId();
        pSModelBookmarkBase.resetPSModelBookmarkName();
        pSModelBookmarkBase.resetPSObjId();
        pSModelBookmarkBase.resetPSObjName();
        pSModelBookmarkBase.resetPSObjType();
        pSModelBookmarkBase.resetPSObjTypeName();
        pSModelBookmarkBase.resetPSSystemId();
        pSModelBookmarkBase.resetPSSystemName();
        pSModelBookmarkBase.resetUpdateDate();
        pSModelBookmarkBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFolderFlagDirty()) {
            hashMap.put(FIELD_FOLDERFLAG, this.getFolderFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSModelBookmarkIdDirty()) {
            hashMap.put(FIELD_PPSMODELBOOKMARKID, this.getPPSModelBookmarkId());
        }
        if (!bl || this.isPPSModelBookmarkNameDirty()) {
            hashMap.put(FIELD_PPSMODELBOOKMARKNAME, this.getPPSModelBookmarkName());
        }
        if (!bl || this.isPSModelBookmarkIdDirty()) {
            hashMap.put(FIELD_PSMODELBOOKMARKID, this.getPSModelBookmarkId());
        }
        if (!bl || this.isPSModelBookmarkNameDirty()) {
            hashMap.put(FIELD_PSMODELBOOKMARKNAME, this.getPSModelBookmarkName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSModelBookmarkBase.get(this, n);
    }

    private static Object get(PSModelBookmarkBase pSModelBookmarkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBookmarkBase.getCreateDate();
            }
            case 1: {
                return pSModelBookmarkBase.getCreateMan();
            }
            case 2: {
                return pSModelBookmarkBase.getFolderFlag();
            }
            case 3: {
                return pSModelBookmarkBase.getMemo();
            }
            case 4: {
                return pSModelBookmarkBase.getPPSModelBookmarkId();
            }
            case 5: {
                return pSModelBookmarkBase.getPPSModelBookmarkName();
            }
            case 6: {
                return pSModelBookmarkBase.getPSModelBookmarkId();
            }
            case 7: {
                return pSModelBookmarkBase.getPSModelBookmarkName();
            }
            case 8: {
                return pSModelBookmarkBase.getPSObjId();
            }
            case 9: {
                return pSModelBookmarkBase.getPSObjName();
            }
            case 10: {
                return pSModelBookmarkBase.getPSObjType();
            }
            case 11: {
                return pSModelBookmarkBase.getPSObjTypeName();
            }
            case 12: {
                return pSModelBookmarkBase.getPSSystemId();
            }
            case 13: {
                return pSModelBookmarkBase.getPSSystemName();
            }
            case 14: {
                return pSModelBookmarkBase.getUpdateDate();
            }
            case 15: {
                return pSModelBookmarkBase.getUpdateMan();
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
        PSModelBookmarkBase.set(this, n, object);
    }

    private static void set(PSModelBookmarkBase pSModelBookmarkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelBookmarkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelBookmarkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelBookmarkBase.setFolderFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelBookmarkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelBookmarkBase.setPPSModelBookmarkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelBookmarkBase.setPPSModelBookmarkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelBookmarkBase.setPSModelBookmarkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelBookmarkBase.setPSModelBookmarkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelBookmarkBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelBookmarkBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelBookmarkBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelBookmarkBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelBookmarkBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelBookmarkBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelBookmarkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelBookmarkBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelBookmarkBase.isNull(this, n);
    }

    private static boolean isNull(PSModelBookmarkBase pSModelBookmarkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBookmarkBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelBookmarkBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelBookmarkBase.getFolderFlag() == null;
            }
            case 3: {
                return pSModelBookmarkBase.getMemo() == null;
            }
            case 4: {
                return pSModelBookmarkBase.getPPSModelBookmarkId() == null;
            }
            case 5: {
                return pSModelBookmarkBase.getPPSModelBookmarkName() == null;
            }
            case 6: {
                return pSModelBookmarkBase.getPSModelBookmarkId() == null;
            }
            case 7: {
                return pSModelBookmarkBase.getPSModelBookmarkName() == null;
            }
            case 8: {
                return pSModelBookmarkBase.getPSObjId() == null;
            }
            case 9: {
                return pSModelBookmarkBase.getPSObjName() == null;
            }
            case 10: {
                return pSModelBookmarkBase.getPSObjType() == null;
            }
            case 11: {
                return pSModelBookmarkBase.getPSObjTypeName() == null;
            }
            case 12: {
                return pSModelBookmarkBase.getPSSystemId() == null;
            }
            case 13: {
                return pSModelBookmarkBase.getPSSystemName() == null;
            }
            case 14: {
                return pSModelBookmarkBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelBookmarkBase.getUpdateMan() == null;
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
        return PSModelBookmarkBase.contains(this, n);
    }

    private static boolean contains(PSModelBookmarkBase pSModelBookmarkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBookmarkBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelBookmarkBase.isCreateManDirty();
            }
            case 2: {
                return pSModelBookmarkBase.isFolderFlagDirty();
            }
            case 3: {
                return pSModelBookmarkBase.isMemoDirty();
            }
            case 4: {
                return pSModelBookmarkBase.isPPSModelBookmarkIdDirty();
            }
            case 5: {
                return pSModelBookmarkBase.isPPSModelBookmarkNameDirty();
            }
            case 6: {
                return pSModelBookmarkBase.isPSModelBookmarkIdDirty();
            }
            case 7: {
                return pSModelBookmarkBase.isPSModelBookmarkNameDirty();
            }
            case 8: {
                return pSModelBookmarkBase.isPSObjIdDirty();
            }
            case 9: {
                return pSModelBookmarkBase.isPSObjNameDirty();
            }
            case 10: {
                return pSModelBookmarkBase.isPSObjTypeDirty();
            }
            case 11: {
                return pSModelBookmarkBase.isPSObjTypeNameDirty();
            }
            case 12: {
                return pSModelBookmarkBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSModelBookmarkBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSModelBookmarkBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelBookmarkBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelBookmarkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelBookmarkBase pSModelBookmarkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelBookmarkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getFolderFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"folderflag", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getFolderFlag()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPPSModelBookmarkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelbookmarkid", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPPSModelBookmarkId()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPPSModelBookmarkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelbookmarkname", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPPSModelBookmarkName()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSModelBookmarkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelbookmarkid", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSModelBookmarkId()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSModelBookmarkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelbookmarkname", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSModelBookmarkName()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelBookmarkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelBookmarkBase.getJSONValue((Object)pSModelBookmarkBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelBookmarkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelBookmarkBase pSModelBookmarkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelBookmarkBase.getCreateDate() != null) {
            object = pSModelBookmarkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelBookmarkBase.getCreateMan() != null) {
            object = pSModelBookmarkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getFolderFlag() != null) {
            object = pSModelBookmarkBase.getFolderFlag();
            xmlNode.setAttribute(FIELD_FOLDERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBookmarkBase.getMemo() != null) {
            object = pSModelBookmarkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPPSModelBookmarkId() != null) {
            object = pSModelBookmarkBase.getPPSModelBookmarkId();
            xmlNode.setAttribute(FIELD_PPSMODELBOOKMARKID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPPSModelBookmarkName() != null) {
            object = pSModelBookmarkBase.getPPSModelBookmarkName();
            xmlNode.setAttribute(FIELD_PPSMODELBOOKMARKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSModelBookmarkId() != null) {
            object = pSModelBookmarkBase.getPSModelBookmarkId();
            xmlNode.setAttribute(FIELD_PSMODELBOOKMARKID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSModelBookmarkName() != null) {
            object = pSModelBookmarkBase.getPSModelBookmarkName();
            xmlNode.setAttribute(FIELD_PSMODELBOOKMARKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSObjId() != null) {
            object = pSModelBookmarkBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSObjName() != null) {
            object = pSModelBookmarkBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSObjType() != null) {
            object = pSModelBookmarkBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSObjTypeName() != null) {
            object = pSModelBookmarkBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSSystemId() != null) {
            object = pSModelBookmarkBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getPSSystemName() != null) {
            object = pSModelBookmarkBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBookmarkBase.getUpdateDate() != null) {
            object = pSModelBookmarkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelBookmarkBase.getUpdateMan() != null) {
            object = pSModelBookmarkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelBookmarkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelBookmarkBase pSModelBookmarkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelBookmarkBase.isCreateDateDirty() && (bl || pSModelBookmarkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelBookmarkBase.getCreateDate());
        }
        if (pSModelBookmarkBase.isCreateManDirty() && (bl || pSModelBookmarkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelBookmarkBase.getCreateMan());
        }
        if (pSModelBookmarkBase.isFolderFlagDirty() && (bl || pSModelBookmarkBase.getFolderFlag() != null)) {
            iDataObject.set(FIELD_FOLDERFLAG, (Object)pSModelBookmarkBase.getFolderFlag());
        }
        if (pSModelBookmarkBase.isMemoDirty() && (bl || pSModelBookmarkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelBookmarkBase.getMemo());
        }
        if (pSModelBookmarkBase.isPPSModelBookmarkIdDirty() && (bl || pSModelBookmarkBase.getPPSModelBookmarkId() != null)) {
            iDataObject.set(FIELD_PPSMODELBOOKMARKID, (Object)pSModelBookmarkBase.getPPSModelBookmarkId());
        }
        if (pSModelBookmarkBase.isPPSModelBookmarkNameDirty() && (bl || pSModelBookmarkBase.getPPSModelBookmarkName() != null)) {
            iDataObject.set(FIELD_PPSMODELBOOKMARKNAME, (Object)pSModelBookmarkBase.getPPSModelBookmarkName());
        }
        if (pSModelBookmarkBase.isPSModelBookmarkIdDirty() && (bl || pSModelBookmarkBase.getPSModelBookmarkId() != null)) {
            iDataObject.set(FIELD_PSMODELBOOKMARKID, (Object)pSModelBookmarkBase.getPSModelBookmarkId());
        }
        if (pSModelBookmarkBase.isPSModelBookmarkNameDirty() && (bl || pSModelBookmarkBase.getPSModelBookmarkName() != null)) {
            iDataObject.set(FIELD_PSMODELBOOKMARKNAME, (Object)pSModelBookmarkBase.getPSModelBookmarkName());
        }
        if (pSModelBookmarkBase.isPSObjIdDirty() && (bl || pSModelBookmarkBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSModelBookmarkBase.getPSObjId());
        }
        if (pSModelBookmarkBase.isPSObjNameDirty() && (bl || pSModelBookmarkBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSModelBookmarkBase.getPSObjName());
        }
        if (pSModelBookmarkBase.isPSObjTypeDirty() && (bl || pSModelBookmarkBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSModelBookmarkBase.getPSObjType());
        }
        if (pSModelBookmarkBase.isPSObjTypeNameDirty() && (bl || pSModelBookmarkBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSModelBookmarkBase.getPSObjTypeName());
        }
        if (pSModelBookmarkBase.isPSSystemIdDirty() && (bl || pSModelBookmarkBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelBookmarkBase.getPSSystemId());
        }
        if (pSModelBookmarkBase.isPSSystemNameDirty() && (bl || pSModelBookmarkBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSModelBookmarkBase.getPSSystemName());
        }
        if (pSModelBookmarkBase.isUpdateDateDirty() && (bl || pSModelBookmarkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelBookmarkBase.getUpdateDate());
        }
        if (pSModelBookmarkBase.isUpdateManDirty() && (bl || pSModelBookmarkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelBookmarkBase.getUpdateMan());
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
        return PSModelBookmarkBase.remove(this, n);
    }

    private static boolean remove(PSModelBookmarkBase pSModelBookmarkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelBookmarkBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelBookmarkBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelBookmarkBase.resetFolderFlag();
                return true;
            }
            case 3: {
                pSModelBookmarkBase.resetMemo();
                return true;
            }
            case 4: {
                pSModelBookmarkBase.resetPPSModelBookmarkId();
                return true;
            }
            case 5: {
                pSModelBookmarkBase.resetPPSModelBookmarkName();
                return true;
            }
            case 6: {
                pSModelBookmarkBase.resetPSModelBookmarkId();
                return true;
            }
            case 7: {
                pSModelBookmarkBase.resetPSModelBookmarkName();
                return true;
            }
            case 8: {
                pSModelBookmarkBase.resetPSObjId();
                return true;
            }
            case 9: {
                pSModelBookmarkBase.resetPSObjName();
                return true;
            }
            case 10: {
                pSModelBookmarkBase.resetPSObjType();
                return true;
            }
            case 11: {
                pSModelBookmarkBase.resetPSObjTypeName();
                return true;
            }
            case 12: {
                pSModelBookmarkBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSModelBookmarkBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSModelBookmarkBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelBookmarkBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelBookmark getPPSModelBookmark() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelBookmark();
        }
        if (this.getPPSModelBookmarkId() == null) {
            return null;
        }
        Integer n = this.objPPSModelBookmarkLock;
        synchronized (n) {
            if (this.ppsmodelbookmark != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelBookmarkId(), (Object)this.ppsmodelbookmark.getPSModelBookmarkId()) != 0L) {
                this.ppsmodelbookmark = null;
            }
            if (this.ppsmodelbookmark == null) {
                PSModelBookmark pSModelBookmark = new PSModelBookmark();
                pSModelBookmark.setPSModelBookmarkId(this.getPPSModelBookmarkId());
                PSModelBookmarkService pSModelBookmarkService = (PSModelBookmarkService)ServiceGlobal.getService(PSModelBookmarkService.class, (SessionFactory)this.getSessionFactory());
                pSModelBookmarkService.autoGet(pSModelBookmark);
                this.ppsmodelbookmark = pSModelBookmark;
            }
            return this.ppsmodelbookmark;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSModelBookmarkBase getProxyEntity() {
        return this.proxyPSModelBookmarkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelBookmarkBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelBookmarkBase) {
            this.proxyPSModelBookmarkBase = (PSModelBookmarkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSModelBookmarkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FOLDERFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PPSMODELBOOKMARKID, 4);
        fieldIndexMap.put(FIELD_PPSMODELBOOKMARKNAME, 5);
        fieldIndexMap.put(FIELD_PSMODELBOOKMARKID, 6);
        fieldIndexMap.put(FIELD_PSMODELBOOKMARKNAME, 7);
        fieldIndexMap.put(FIELD_PSOBJID, 8);
        fieldIndexMap.put(FIELD_PSOBJNAME, 9);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 10);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

