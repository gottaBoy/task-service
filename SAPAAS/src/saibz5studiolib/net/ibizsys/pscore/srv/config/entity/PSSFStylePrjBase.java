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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStylePrjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStylePrjBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAVENFLAG = "MAVENFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEFMT = "NAMEFMT";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEPRJID = "PSSFSTYLEPRJID";
    public static final String FIELD_PSSFSTYLEPRJNAME = "PSSFSTYLEPRJNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAVENFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_NAMEFMT = 4;
    private static final int INDEX_PRJTYPE = 5;
    private static final int INDEX_PSSFSTYLEID = 6;
    private static final int INDEX_PSSFSTYLENAME = 7;
    private static final int INDEX_PSSFSTYLEPRJID = 8;
    private static final int INDEX_PSSFSTYLEPRJNAME = 9;
    private static final int INDEX_READONLYMODE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStylePrjBase proxyPSSFStylePrjBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean mavenflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namefmtDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleprjidDirtyFlag = false;
    private boolean pssfstyleprjnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="mavenflag")
    private Integer mavenflag;
    @Column(name="memo")
    private String memo;
    @Column(name="namefmt")
    private String namefmt;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleprjid")
    private String pssfstyleprjid;
    @Column(name="pssfstyleprjname")
    private String pssfstyleprjname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;

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

    public void setMavenFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMavenFlag(n);
            return;
        }
        this.mavenflag = n;
        this.mavenflagDirtyFlag = true;
    }

    public Integer getMavenFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMavenFlag();
        }
        return this.mavenflag;
    }

    public boolean isMavenFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMavenFlagDirty();
        }
        return this.mavenflagDirtyFlag;
    }

    public void resetMavenFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMavenFlag();
            return;
        }
        this.mavenflagDirtyFlag = false;
        this.mavenflag = null;
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

    public void setNameFmt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNameFmt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namefmt = string;
        this.namefmtDirtyFlag = true;
    }

    public String getNameFmt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNameFmt();
        }
        return this.namefmt;
    }

    public boolean isNameFmtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNameFmtDirty();
        }
        return this.namefmtDirtyFlag;
    }

    public void resetNameFmt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNameFmt();
            return;
        }
        this.namefmtDirtyFlag = false;
        this.namefmt = null;
    }

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSFStylePrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleprjid = string;
        this.pssfstyleprjidDirtyFlag = true;
    }

    public String getPSSFStylePrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrjId();
        }
        return this.pssfstyleprjid;
    }

    public boolean isPSSFStylePrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePrjIdDirty();
        }
        return this.pssfstyleprjidDirtyFlag;
    }

    public void resetPSSFStylePrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePrjId();
            return;
        }
        this.pssfstyleprjidDirtyFlag = false;
        this.pssfstyleprjid = null;
    }

    public void setPSSFStylePrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleprjname = string;
        this.pssfstyleprjnameDirtyFlag = true;
    }

    public String getPSSFStylePrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrjName();
        }
        return this.pssfstyleprjname;
    }

    public boolean isPSSFStylePrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePrjNameDirty();
        }
        return this.pssfstyleprjnameDirtyFlag;
    }

    public void resetPSSFStylePrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePrjName();
            return;
        }
        this.pssfstyleprjnameDirtyFlag = false;
        this.pssfstyleprjname = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
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
        PSSFStylePrjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStylePrjBase pSSFStylePrjBase) {
        pSSFStylePrjBase.resetCreateDate();
        pSSFStylePrjBase.resetCreateMan();
        pSSFStylePrjBase.resetMavenFlag();
        pSSFStylePrjBase.resetMemo();
        pSSFStylePrjBase.resetNameFmt();
        pSSFStylePrjBase.resetPrjType();
        pSSFStylePrjBase.resetPSSFStyleId();
        pSSFStylePrjBase.resetPSSFStyleName();
        pSSFStylePrjBase.resetPSSFStylePrjId();
        pSSFStylePrjBase.resetPSSFStylePrjName();
        pSSFStylePrjBase.resetReadOnlyMode();
        pSSFStylePrjBase.resetUpdateDate();
        pSSFStylePrjBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMavenFlagDirty()) {
            hashMap.put(FIELD_MAVENFLAG, this.getMavenFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNameFmtDirty()) {
            hashMap.put(FIELD_NAMEFMT, this.getNameFmt());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStylePrjIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPRJID, this.getPSSFStylePrjId());
        }
        if (!bl || this.isPSSFStylePrjNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPRJNAME, this.getPSSFStylePrjName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
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
        return PSSFStylePrjBase.get(this, n);
    }

    private static Object get(PSSFStylePrjBase pSSFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePrjBase.getCreateDate();
            }
            case 1: {
                return pSSFStylePrjBase.getCreateMan();
            }
            case 2: {
                return pSSFStylePrjBase.getMavenFlag();
            }
            case 3: {
                return pSSFStylePrjBase.getMemo();
            }
            case 4: {
                return pSSFStylePrjBase.getNameFmt();
            }
            case 5: {
                return pSSFStylePrjBase.getPrjType();
            }
            case 6: {
                return pSSFStylePrjBase.getPSSFStyleId();
            }
            case 7: {
                return pSSFStylePrjBase.getPSSFStyleName();
            }
            case 8: {
                return pSSFStylePrjBase.getPSSFStylePrjId();
            }
            case 9: {
                return pSSFStylePrjBase.getPSSFStylePrjName();
            }
            case 10: {
                return pSSFStylePrjBase.getReadOnlyMode();
            }
            case 11: {
                return pSSFStylePrjBase.getUpdateDate();
            }
            case 12: {
                return pSSFStylePrjBase.getUpdateMan();
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
        PSSFStylePrjBase.set(this, n, object);
    }

    private static void set(PSSFStylePrjBase pSSFStylePrjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStylePrjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFStylePrjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFStylePrjBase.setMavenFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSFStylePrjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFStylePrjBase.setNameFmt(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStylePrjBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFStylePrjBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStylePrjBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStylePrjBase.setPSSFStylePrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStylePrjBase.setPSSFStylePrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFStylePrjBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSFStylePrjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSFStylePrjBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFStylePrjBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStylePrjBase pSSFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePrjBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFStylePrjBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFStylePrjBase.getMavenFlag() == null;
            }
            case 3: {
                return pSSFStylePrjBase.getMemo() == null;
            }
            case 4: {
                return pSSFStylePrjBase.getNameFmt() == null;
            }
            case 5: {
                return pSSFStylePrjBase.getPrjType() == null;
            }
            case 6: {
                return pSSFStylePrjBase.getPSSFStyleId() == null;
            }
            case 7: {
                return pSSFStylePrjBase.getPSSFStyleName() == null;
            }
            case 8: {
                return pSSFStylePrjBase.getPSSFStylePrjId() == null;
            }
            case 9: {
                return pSSFStylePrjBase.getPSSFStylePrjName() == null;
            }
            case 10: {
                return pSSFStylePrjBase.getReadOnlyMode() == null;
            }
            case 11: {
                return pSSFStylePrjBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSFStylePrjBase.getUpdateMan() == null;
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
        return PSSFStylePrjBase.contains(this, n);
    }

    private static boolean contains(PSSFStylePrjBase pSSFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePrjBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFStylePrjBase.isCreateManDirty();
            }
            case 2: {
                return pSSFStylePrjBase.isMavenFlagDirty();
            }
            case 3: {
                return pSSFStylePrjBase.isMemoDirty();
            }
            case 4: {
                return pSSFStylePrjBase.isNameFmtDirty();
            }
            case 5: {
                return pSSFStylePrjBase.isPrjTypeDirty();
            }
            case 6: {
                return pSSFStylePrjBase.isPSSFStyleIdDirty();
            }
            case 7: {
                return pSSFStylePrjBase.isPSSFStyleNameDirty();
            }
            case 8: {
                return pSSFStylePrjBase.isPSSFStylePrjIdDirty();
            }
            case 9: {
                return pSSFStylePrjBase.isPSSFStylePrjNameDirty();
            }
            case 10: {
                return pSSFStylePrjBase.isReadOnlyModeDirty();
            }
            case 11: {
                return pSSFStylePrjBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSFStylePrjBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStylePrjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStylePrjBase pSSFStylePrjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStylePrjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getMavenFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenflag", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getMavenFlag()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getNameFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namefmt", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getNameFmt()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getPrjType()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getPSSFStylePrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleprjid", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getPSSFStylePrjId()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getPSSFStylePrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleprjname", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getPSSFStylePrjName()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStylePrjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStylePrjBase.getJSONValue((Object)pSSFStylePrjBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStylePrjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStylePrjBase pSSFStylePrjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStylePrjBase.getCreateDate() != null) {
            object = pSSFStylePrjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStylePrjBase.getCreateMan() != null) {
            object = pSSFStylePrjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getMavenFlag() != null) {
            object = pSSFStylePrjBase.getMavenFlag();
            xmlNode.setAttribute(FIELD_MAVENFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStylePrjBase.getMemo() != null) {
            object = pSSFStylePrjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getNameFmt() != null) {
            object = pSSFStylePrjBase.getNameFmt();
            xmlNode.setAttribute(FIELD_NAMEFMT, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getPrjType() != null) {
            object = pSSFStylePrjBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getPSSFStyleId() != null) {
            object = pSSFStylePrjBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getPSSFStyleName() != null) {
            object = pSSFStylePrjBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getPSSFStylePrjId() != null) {
            object = pSSFStylePrjBase.getPSSFStylePrjId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getPSSFStylePrjName() != null) {
            object = pSSFStylePrjBase.getPSSFStylePrjName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePrjBase.getReadOnlyMode() != null) {
            object = pSSFStylePrjBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStylePrjBase.getUpdateDate() != null) {
            object = pSSFStylePrjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStylePrjBase.getUpdateMan() != null) {
            object = pSSFStylePrjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStylePrjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStylePrjBase pSSFStylePrjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStylePrjBase.isCreateDateDirty() && (bl || pSSFStylePrjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStylePrjBase.getCreateDate());
        }
        if (pSSFStylePrjBase.isCreateManDirty() && (bl || pSSFStylePrjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStylePrjBase.getCreateMan());
        }
        if (pSSFStylePrjBase.isMavenFlagDirty() && (bl || pSSFStylePrjBase.getMavenFlag() != null)) {
            iDataObject.set(FIELD_MAVENFLAG, (Object)pSSFStylePrjBase.getMavenFlag());
        }
        if (pSSFStylePrjBase.isMemoDirty() && (bl || pSSFStylePrjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStylePrjBase.getMemo());
        }
        if (pSSFStylePrjBase.isNameFmtDirty() && (bl || pSSFStylePrjBase.getNameFmt() != null)) {
            iDataObject.set(FIELD_NAMEFMT, (Object)pSSFStylePrjBase.getNameFmt());
        }
        if (pSSFStylePrjBase.isPrjTypeDirty() && (bl || pSSFStylePrjBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSSFStylePrjBase.getPrjType());
        }
        if (pSSFStylePrjBase.isPSSFStyleIdDirty() && (bl || pSSFStylePrjBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStylePrjBase.getPSSFStyleId());
        }
        if (pSSFStylePrjBase.isPSSFStyleNameDirty() && (bl || pSSFStylePrjBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStylePrjBase.getPSSFStyleName());
        }
        if (pSSFStylePrjBase.isPSSFStylePrjIdDirty() && (bl || pSSFStylePrjBase.getPSSFStylePrjId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPRJID, (Object)pSSFStylePrjBase.getPSSFStylePrjId());
        }
        if (pSSFStylePrjBase.isPSSFStylePrjNameDirty() && (bl || pSSFStylePrjBase.getPSSFStylePrjName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPRJNAME, (Object)pSSFStylePrjBase.getPSSFStylePrjName());
        }
        if (pSSFStylePrjBase.isReadOnlyModeDirty() && (bl || pSSFStylePrjBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSSFStylePrjBase.getReadOnlyMode());
        }
        if (pSSFStylePrjBase.isUpdateDateDirty() && (bl || pSSFStylePrjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStylePrjBase.getUpdateDate());
        }
        if (pSSFStylePrjBase.isUpdateManDirty() && (bl || pSSFStylePrjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStylePrjBase.getUpdateMan());
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
        return PSSFStylePrjBase.remove(this, n);
    }

    private static boolean remove(PSSFStylePrjBase pSSFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStylePrjBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFStylePrjBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFStylePrjBase.resetMavenFlag();
                return true;
            }
            case 3: {
                pSSFStylePrjBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFStylePrjBase.resetNameFmt();
                return true;
            }
            case 5: {
                pSSFStylePrjBase.resetPrjType();
                return true;
            }
            case 6: {
                pSSFStylePrjBase.resetPSSFStyleId();
                return true;
            }
            case 7: {
                pSSFStylePrjBase.resetPSSFStyleName();
                return true;
            }
            case 8: {
                pSSFStylePrjBase.resetPSSFStylePrjId();
                return true;
            }
            case 9: {
                pSSFStylePrjBase.resetPSSFStylePrjName();
                return true;
            }
            case 10: {
                pSSFStylePrjBase.resetReadOnlyMode();
                return true;
            }
            case 11: {
                pSSFStylePrjBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSFStylePrjBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    private PSSFStylePrjBase getProxyEntity() {
        return this.proxyPSSFStylePrjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStylePrjBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStylePrjBase) {
            this.proxyPSSFStylePrjBase = (PSSFStylePrjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStylePrjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAVENFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_NAMEFMT, 4);
        fieldIndexMap.put(FIELD_PRJTYPE, 5);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 6);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEPRJID, 8);
        fieldIndexMap.put(FIELD_PSSFSTYLEPRJNAME, 9);
        fieldIndexMap.put(FIELD_READONLYMODE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

