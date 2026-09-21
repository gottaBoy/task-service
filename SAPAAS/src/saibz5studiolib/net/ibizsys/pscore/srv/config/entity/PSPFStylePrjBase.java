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
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStylePrjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStylePrjBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAVENFLAG = "MAVENFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEFMT = "NAMEFMT";
    public static final String FIELD_NAMEFMT2 = "NAMEFMT2";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFSTYLEPRJID = "PSPFSTYLEPRJID";
    public static final String FIELD_PSPFSTYLEPRJNAME = "PSPFSTYLEPRJNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAVENFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_NAMEFMT = 4;
    private static final int INDEX_NAMEFMT2 = 5;
    private static final int INDEX_PRJTYPE = 6;
    private static final int INDEX_PSPFSTYLEID = 7;
    private static final int INDEX_PSPFSTYLENAME = 8;
    private static final int INDEX_PSPFSTYLEPRJID = 9;
    private static final int INDEX_PSPFSTYLEPRJNAME = 10;
    private static final int INDEX_READONLYMODE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStylePrjBase proxyPSPFStylePrjBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean mavenflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namefmtDirtyFlag = false;
    private boolean namefmt2DirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfstyleprjidDirtyFlag = false;
    private boolean pspfstyleprjnameDirtyFlag = false;
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
    @Column(name="namefmt2")
    private String namefmt2;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pspfstyleprjid")
    private String pspfstyleprjid;
    @Column(name="pspfstyleprjname")
    private String pspfstyleprjname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;

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

    public void setNameFmt2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNameFmt2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namefmt2 = string;
        this.namefmt2DirtyFlag = true;
    }

    public String getNameFmt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNameFmt2();
        }
        return this.namefmt2;
    }

    public boolean isNameFmt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNameFmt2Dirty();
        }
        return this.namefmt2DirtyFlag;
    }

    public void resetNameFmt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNameFmt2();
            return;
        }
        this.namefmt2DirtyFlag = false;
        this.namefmt2 = null;
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

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSPFStylePrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStylePrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleprjid = string;
        this.pspfstyleprjidDirtyFlag = true;
    }

    public String getPSPFStylePrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePrjId();
        }
        return this.pspfstyleprjid;
    }

    public boolean isPSPFStylePrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStylePrjIdDirty();
        }
        return this.pspfstyleprjidDirtyFlag;
    }

    public void resetPSPFStylePrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStylePrjId();
            return;
        }
        this.pspfstyleprjidDirtyFlag = false;
        this.pspfstyleprjid = null;
    }

    public void setPSPFStylePrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStylePrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleprjname = string;
        this.pspfstyleprjnameDirtyFlag = true;
    }

    public String getPSPFStylePrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePrjName();
        }
        return this.pspfstyleprjname;
    }

    public boolean isPSPFStylePrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStylePrjNameDirty();
        }
        return this.pspfstyleprjnameDirtyFlag;
    }

    public void resetPSPFStylePrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStylePrjName();
            return;
        }
        this.pspfstyleprjnameDirtyFlag = false;
        this.pspfstyleprjname = null;
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
        PSPFStylePrjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStylePrjBase pSPFStylePrjBase) {
        pSPFStylePrjBase.resetCreateDate();
        pSPFStylePrjBase.resetCreateMan();
        pSPFStylePrjBase.resetMavenFlag();
        pSPFStylePrjBase.resetMemo();
        pSPFStylePrjBase.resetNameFmt();
        pSPFStylePrjBase.resetNameFmt2();
        pSPFStylePrjBase.resetPrjType();
        pSPFStylePrjBase.resetPSPFStyleId();
        pSPFStylePrjBase.resetPSPFStyleName();
        pSPFStylePrjBase.resetPSPFStylePrjId();
        pSPFStylePrjBase.resetPSPFStylePrjName();
        pSPFStylePrjBase.resetReadOnlyMode();
        pSPFStylePrjBase.resetUpdateDate();
        pSPFStylePrjBase.resetUpdateMan();
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
        if (!bl || this.isNameFmt2Dirty()) {
            hashMap.put(FIELD_NAMEFMT2, this.getNameFmt2());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSPFStylePrjIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEPRJID, this.getPSPFStylePrjId());
        }
        if (!bl || this.isPSPFStylePrjNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLEPRJNAME, this.getPSPFStylePrjName());
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
        return PSPFStylePrjBase.get(this, n);
    }

    private static Object get(PSPFStylePrjBase pSPFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePrjBase.getCreateDate();
            }
            case 1: {
                return pSPFStylePrjBase.getCreateMan();
            }
            case 2: {
                return pSPFStylePrjBase.getMavenFlag();
            }
            case 3: {
                return pSPFStylePrjBase.getMemo();
            }
            case 4: {
                return pSPFStylePrjBase.getNameFmt();
            }
            case 5: {
                return pSPFStylePrjBase.getNameFmt2();
            }
            case 6: {
                return pSPFStylePrjBase.getPrjType();
            }
            case 7: {
                return pSPFStylePrjBase.getPSPFStyleId();
            }
            case 8: {
                return pSPFStylePrjBase.getPSPFStyleName();
            }
            case 9: {
                return pSPFStylePrjBase.getPSPFStylePrjId();
            }
            case 10: {
                return pSPFStylePrjBase.getPSPFStylePrjName();
            }
            case 11: {
                return pSPFStylePrjBase.getReadOnlyMode();
            }
            case 12: {
                return pSPFStylePrjBase.getUpdateDate();
            }
            case 13: {
                return pSPFStylePrjBase.getUpdateMan();
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
        PSPFStylePrjBase.set(this, n, object);
    }

    private static void set(PSPFStylePrjBase pSPFStylePrjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStylePrjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFStylePrjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFStylePrjBase.setMavenFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSPFStylePrjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFStylePrjBase.setNameFmt(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFStylePrjBase.setNameFmt2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFStylePrjBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFStylePrjBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFStylePrjBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStylePrjBase.setPSPFStylePrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFStylePrjBase.setPSPFStylePrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFStylePrjBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSPFStylePrjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSPFStylePrjBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFStylePrjBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStylePrjBase pSPFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePrjBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFStylePrjBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFStylePrjBase.getMavenFlag() == null;
            }
            case 3: {
                return pSPFStylePrjBase.getMemo() == null;
            }
            case 4: {
                return pSPFStylePrjBase.getNameFmt() == null;
            }
            case 5: {
                return pSPFStylePrjBase.getNameFmt2() == null;
            }
            case 6: {
                return pSPFStylePrjBase.getPrjType() == null;
            }
            case 7: {
                return pSPFStylePrjBase.getPSPFStyleId() == null;
            }
            case 8: {
                return pSPFStylePrjBase.getPSPFStyleName() == null;
            }
            case 9: {
                return pSPFStylePrjBase.getPSPFStylePrjId() == null;
            }
            case 10: {
                return pSPFStylePrjBase.getPSPFStylePrjName() == null;
            }
            case 11: {
                return pSPFStylePrjBase.getReadOnlyMode() == null;
            }
            case 12: {
                return pSPFStylePrjBase.getUpdateDate() == null;
            }
            case 13: {
                return pSPFStylePrjBase.getUpdateMan() == null;
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
        return PSPFStylePrjBase.contains(this, n);
    }

    private static boolean contains(PSPFStylePrjBase pSPFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePrjBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFStylePrjBase.isCreateManDirty();
            }
            case 2: {
                return pSPFStylePrjBase.isMavenFlagDirty();
            }
            case 3: {
                return pSPFStylePrjBase.isMemoDirty();
            }
            case 4: {
                return pSPFStylePrjBase.isNameFmtDirty();
            }
            case 5: {
                return pSPFStylePrjBase.isNameFmt2Dirty();
            }
            case 6: {
                return pSPFStylePrjBase.isPrjTypeDirty();
            }
            case 7: {
                return pSPFStylePrjBase.isPSPFStyleIdDirty();
            }
            case 8: {
                return pSPFStylePrjBase.isPSPFStyleNameDirty();
            }
            case 9: {
                return pSPFStylePrjBase.isPSPFStylePrjIdDirty();
            }
            case 10: {
                return pSPFStylePrjBase.isPSPFStylePrjNameDirty();
            }
            case 11: {
                return pSPFStylePrjBase.isReadOnlyModeDirty();
            }
            case 12: {
                return pSPFStylePrjBase.isUpdateDateDirty();
            }
            case 13: {
                return pSPFStylePrjBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStylePrjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStylePrjBase pSPFStylePrjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStylePrjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getMavenFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mavenflag", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getMavenFlag()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getNameFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namefmt", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getNameFmt()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getNameFmt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namefmt2", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getNameFmt2()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getPrjType()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getPSPFStylePrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleprjid", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getPSPFStylePrjId()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getPSPFStylePrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleprjname", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getPSPFStylePrjName()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStylePrjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStylePrjBase.getJSONValue((Object)pSPFStylePrjBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStylePrjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStylePrjBase pSPFStylePrjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStylePrjBase.getCreateDate() != null) {
            object = pSPFStylePrjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStylePrjBase.getCreateMan() != null) {
            object = pSPFStylePrjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getMavenFlag() != null) {
            object = pSPFStylePrjBase.getMavenFlag();
            xmlNode.setAttribute(FIELD_MAVENFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStylePrjBase.getMemo() != null) {
            object = pSPFStylePrjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getNameFmt() != null) {
            object = pSPFStylePrjBase.getNameFmt();
            xmlNode.setAttribute(FIELD_NAMEFMT, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getNameFmt2() != null) {
            object = pSPFStylePrjBase.getNameFmt2();
            xmlNode.setAttribute(FIELD_NAMEFMT2, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getPrjType() != null) {
            object = pSPFStylePrjBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getPSPFStyleId() != null) {
            object = pSPFStylePrjBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getPSPFStyleName() != null) {
            object = pSPFStylePrjBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getPSPFStylePrjId() != null) {
            object = pSPFStylePrjBase.getPSPFStylePrjId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getPSPFStylePrjName() != null) {
            object = pSPFStylePrjBase.getPSPFStylePrjName();
            xmlNode.setAttribute(FIELD_PSPFSTYLEPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePrjBase.getReadOnlyMode() != null) {
            object = pSPFStylePrjBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStylePrjBase.getUpdateDate() != null) {
            object = pSPFStylePrjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStylePrjBase.getUpdateMan() != null) {
            object = pSPFStylePrjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStylePrjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStylePrjBase pSPFStylePrjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStylePrjBase.isCreateDateDirty() && (bl || pSPFStylePrjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStylePrjBase.getCreateDate());
        }
        if (pSPFStylePrjBase.isCreateManDirty() && (bl || pSPFStylePrjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStylePrjBase.getCreateMan());
        }
        if (pSPFStylePrjBase.isMavenFlagDirty() && (bl || pSPFStylePrjBase.getMavenFlag() != null)) {
            iDataObject.set(FIELD_MAVENFLAG, (Object)pSPFStylePrjBase.getMavenFlag());
        }
        if (pSPFStylePrjBase.isMemoDirty() && (bl || pSPFStylePrjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFStylePrjBase.getMemo());
        }
        if (pSPFStylePrjBase.isNameFmtDirty() && (bl || pSPFStylePrjBase.getNameFmt() != null)) {
            iDataObject.set(FIELD_NAMEFMT, (Object)pSPFStylePrjBase.getNameFmt());
        }
        if (pSPFStylePrjBase.isNameFmt2Dirty() && (bl || pSPFStylePrjBase.getNameFmt2() != null)) {
            iDataObject.set(FIELD_NAMEFMT2, (Object)pSPFStylePrjBase.getNameFmt2());
        }
        if (pSPFStylePrjBase.isPrjTypeDirty() && (bl || pSPFStylePrjBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSPFStylePrjBase.getPrjType());
        }
        if (pSPFStylePrjBase.isPSPFStyleIdDirty() && (bl || pSPFStylePrjBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStylePrjBase.getPSPFStyleId());
        }
        if (pSPFStylePrjBase.isPSPFStyleNameDirty() && (bl || pSPFStylePrjBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStylePrjBase.getPSPFStyleName());
        }
        if (pSPFStylePrjBase.isPSPFStylePrjIdDirty() && (bl || pSPFStylePrjBase.getPSPFStylePrjId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEPRJID, (Object)pSPFStylePrjBase.getPSPFStylePrjId());
        }
        if (pSPFStylePrjBase.isPSPFStylePrjNameDirty() && (bl || pSPFStylePrjBase.getPSPFStylePrjName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEPRJNAME, (Object)pSPFStylePrjBase.getPSPFStylePrjName());
        }
        if (pSPFStylePrjBase.isReadOnlyModeDirty() && (bl || pSPFStylePrjBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSPFStylePrjBase.getReadOnlyMode());
        }
        if (pSPFStylePrjBase.isUpdateDateDirty() && (bl || pSPFStylePrjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStylePrjBase.getUpdateDate());
        }
        if (pSPFStylePrjBase.isUpdateManDirty() && (bl || pSPFStylePrjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStylePrjBase.getUpdateMan());
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
        return PSPFStylePrjBase.remove(this, n);
    }

    private static boolean remove(PSPFStylePrjBase pSPFStylePrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStylePrjBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFStylePrjBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFStylePrjBase.resetMavenFlag();
                return true;
            }
            case 3: {
                pSPFStylePrjBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFStylePrjBase.resetNameFmt();
                return true;
            }
            case 5: {
                pSPFStylePrjBase.resetNameFmt2();
                return true;
            }
            case 6: {
                pSPFStylePrjBase.resetPrjType();
                return true;
            }
            case 7: {
                pSPFStylePrjBase.resetPSPFStyleId();
                return true;
            }
            case 8: {
                pSPFStylePrjBase.resetPSPFStyleName();
                return true;
            }
            case 9: {
                pSPFStylePrjBase.resetPSPFStylePrjId();
                return true;
            }
            case 10: {
                pSPFStylePrjBase.resetPSPFStylePrjName();
                return true;
            }
            case 11: {
                pSPFStylePrjBase.resetReadOnlyMode();
                return true;
            }
            case 12: {
                pSPFStylePrjBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSPFStylePrjBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    private PSPFStylePrjBase getProxyEntity() {
        return this.proxyPSPFStylePrjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStylePrjBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStylePrjBase) {
            this.proxyPSPFStylePrjBase = (PSPFStylePrjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStylePrjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAVENFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_NAMEFMT, 4);
        fieldIndexMap.put(FIELD_NAMEFMT2, 5);
        fieldIndexMap.put(FIELD_PRJTYPE, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_PSPFSTYLEPRJID, 9);
        fieldIndexMap.put(FIELD_PSPFSTYLEPRJNAME, 10);
        fieldIndexMap.put(FIELD_READONLYMODE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

