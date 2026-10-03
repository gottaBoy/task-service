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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStyleLogBase.class);
    public static final String FIELD_CHANGELOG = "CHANGELOG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLELOGID = "PSPFSTYLELOGID";
    public static final String FIELD_PSPFSTYLELOGNAME = "PSPFSTYLELOGNAME";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CHANGELOG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_PSPFID = 3;
    private static final int INDEX_PSPFNAME = 4;
    private static final int INDEX_PSPFSTYLEID = 5;
    private static final int INDEX_PSPFSTYLELOGID = 6;
    private static final int INDEX_PSPFSTYLELOGNAME = 7;
    private static final int INDEX_PSPFSTYLENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStyleLogBase proxyPSPFStyleLogBase = null;
    private boolean changelogDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylelogidDirtyFlag = false;
    private boolean pspfstylelognameDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="changelog")
    private String changelog;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylelogid")
    private String pspfstylelogid;
    @Column(name="pspfstylelogname")
    private String pspfstylelogname;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

    public void setChangeLog(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChangeLog(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.changelog = string;
        this.changelogDirtyFlag = true;
    }

    public String getChangeLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChangeLog();
        }
        return this.changelog;
    }

    public boolean isChangeLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChangeLogDirty();
        }
        return this.changelogDirtyFlag;
    }

    public void resetChangeLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChangeLog();
            return;
        }
        this.changelogDirtyFlag = false;
        this.changelog = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
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

    public void setPSPFStyleLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylelogid = string;
        this.pspfstylelogidDirtyFlag = true;
    }

    public String getPSPFStyleLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleLogId();
        }
        return this.pspfstylelogid;
    }

    public boolean isPSPFStyleLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleLogIdDirty();
        }
        return this.pspfstylelogidDirtyFlag;
    }

    public void resetPSPFStyleLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleLogId();
            return;
        }
        this.pspfstylelogidDirtyFlag = false;
        this.pspfstylelogid = null;
    }

    public void setPSPFStyleLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylelogname = string;
        this.pspfstylelognameDirtyFlag = true;
    }

    public String getPSPFStyleLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleLogName();
        }
        return this.pspfstylelogname;
    }

    public boolean isPSPFStyleLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleLogNameDirty();
        }
        return this.pspfstylelognameDirtyFlag;
    }

    public void resetPSPFStyleLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleLogName();
            return;
        }
        this.pspfstylelognameDirtyFlag = false;
        this.pspfstylelogname = null;
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
        PSPFStyleLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStyleLogBase pSPFStyleLogBase) {
        pSPFStyleLogBase.resetChangeLog();
        pSPFStyleLogBase.resetCreateDate();
        pSPFStyleLogBase.resetCreateMan();
        pSPFStyleLogBase.resetPSPFId();
        pSPFStyleLogBase.resetPSPFName();
        pSPFStyleLogBase.resetPSPFStyleId();
        pSPFStyleLogBase.resetPSPFStyleLogId();
        pSPFStyleLogBase.resetPSPFStyleLogName();
        pSPFStyleLogBase.resetPSPFStyleName();
        pSPFStyleLogBase.resetUpdateDate();
        pSPFStyleLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isChangeLogDirty()) {
            hashMap.put(FIELD_CHANGELOG, this.getChangeLog());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleLogIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLELOGID, this.getPSPFStyleLogId());
        }
        if (!bl || this.isPSPFStyleLogNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLELOGNAME, this.getPSPFStyleLogName());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
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
        return PSPFStyleLogBase.get(this, n);
    }

    private static Object get(PSPFStyleLogBase pSPFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleLogBase.getChangeLog();
            }
            case 1: {
                return pSPFStyleLogBase.getCreateDate();
            }
            case 2: {
                return pSPFStyleLogBase.getCreateMan();
            }
            case 3: {
                return pSPFStyleLogBase.getPSPFId();
            }
            case 4: {
                return pSPFStyleLogBase.getPSPFName();
            }
            case 5: {
                return pSPFStyleLogBase.getPSPFStyleId();
            }
            case 6: {
                return pSPFStyleLogBase.getPSPFStyleLogId();
            }
            case 7: {
                return pSPFStyleLogBase.getPSPFStyleLogName();
            }
            case 8: {
                return pSPFStyleLogBase.getPSPFStyleName();
            }
            case 9: {
                return pSPFStyleLogBase.getUpdateDate();
            }
            case 10: {
                return pSPFStyleLogBase.getUpdateMan();
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
        PSPFStyleLogBase.set(this, n, object);
    }

    private static void set(PSPFStyleLogBase pSPFStyleLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleLogBase.setChangeLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFStyleLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFStyleLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFStyleLogBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFStyleLogBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFStyleLogBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFStyleLogBase.setPSPFStyleLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFStyleLogBase.setPSPFStyleLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFStyleLogBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStyleLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSPFStyleLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFStyleLogBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStyleLogBase pSPFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleLogBase.getChangeLog() == null;
            }
            case 1: {
                return pSPFStyleLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFStyleLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFStyleLogBase.getPSPFId() == null;
            }
            case 4: {
                return pSPFStyleLogBase.getPSPFName() == null;
            }
            case 5: {
                return pSPFStyleLogBase.getPSPFStyleId() == null;
            }
            case 6: {
                return pSPFStyleLogBase.getPSPFStyleLogId() == null;
            }
            case 7: {
                return pSPFStyleLogBase.getPSPFStyleLogName() == null;
            }
            case 8: {
                return pSPFStyleLogBase.getPSPFStyleName() == null;
            }
            case 9: {
                return pSPFStyleLogBase.getUpdateDate() == null;
            }
            case 10: {
                return pSPFStyleLogBase.getUpdateMan() == null;
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
        return PSPFStyleLogBase.contains(this, n);
    }

    private static boolean contains(PSPFStyleLogBase pSPFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleLogBase.isChangeLogDirty();
            }
            case 1: {
                return pSPFStyleLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFStyleLogBase.isCreateManDirty();
            }
            case 3: {
                return pSPFStyleLogBase.isPSPFIdDirty();
            }
            case 4: {
                return pSPFStyleLogBase.isPSPFNameDirty();
            }
            case 5: {
                return pSPFStyleLogBase.isPSPFStyleIdDirty();
            }
            case 6: {
                return pSPFStyleLogBase.isPSPFStyleLogIdDirty();
            }
            case 7: {
                return pSPFStyleLogBase.isPSPFStyleLogNameDirty();
            }
            case 8: {
                return pSPFStyleLogBase.isPSPFStyleNameDirty();
            }
            case 9: {
                return pSPFStyleLogBase.isUpdateDateDirty();
            }
            case 10: {
                return pSPFStyleLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStyleLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStyleLogBase pSPFStyleLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStyleLogBase.getChangeLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"changelog", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getChangeLog()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylelogid", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFStyleLogId()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylelogname", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFStyleLogName()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStyleLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStyleLogBase.getJSONValue((Object)pSPFStyleLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStyleLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStyleLogBase pSPFStyleLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStyleLogBase.getChangeLog() != null) {
            object = pSPFStyleLogBase.getChangeLog();
            xmlNode.setAttribute(FIELD_CHANGELOG, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getCreateDate() != null) {
            object = pSPFStyleLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleLogBase.getCreateMan() != null) {
            object = pSPFStyleLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFId() != null) {
            object = pSPFStyleLogBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFName() != null) {
            object = pSPFStyleLogBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleId() != null) {
            object = pSPFStyleLogBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleLogId() != null) {
            object = pSPFStyleLogBase.getPSPFStyleLogId();
            xmlNode.setAttribute(FIELD_PSPFSTYLELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleLogName() != null) {
            object = pSPFStyleLogBase.getPSPFStyleLogName();
            xmlNode.setAttribute(FIELD_PSPFSTYLELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getPSPFStyleName() != null) {
            object = pSPFStyleLogBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleLogBase.getUpdateDate() != null) {
            object = pSPFStyleLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleLogBase.getUpdateMan() != null) {
            object = pSPFStyleLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStyleLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStyleLogBase pSPFStyleLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStyleLogBase.isChangeLogDirty() && (bl || pSPFStyleLogBase.getChangeLog() != null)) {
            iDataObject.set(FIELD_CHANGELOG, (Object)pSPFStyleLogBase.getChangeLog());
        }
        if (pSPFStyleLogBase.isCreateDateDirty() && (bl || pSPFStyleLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStyleLogBase.getCreateDate());
        }
        if (pSPFStyleLogBase.isCreateManDirty() && (bl || pSPFStyleLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStyleLogBase.getCreateMan());
        }
        if (pSPFStyleLogBase.isPSPFIdDirty() && (bl || pSPFStyleLogBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFStyleLogBase.getPSPFId());
        }
        if (pSPFStyleLogBase.isPSPFNameDirty() && (bl || pSPFStyleLogBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFStyleLogBase.getPSPFName());
        }
        if (pSPFStyleLogBase.isPSPFStyleIdDirty() && (bl || pSPFStyleLogBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStyleLogBase.getPSPFStyleId());
        }
        if (pSPFStyleLogBase.isPSPFStyleLogIdDirty() && (bl || pSPFStyleLogBase.getPSPFStyleLogId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLELOGID, (Object)pSPFStyleLogBase.getPSPFStyleLogId());
        }
        if (pSPFStyleLogBase.isPSPFStyleLogNameDirty() && (bl || pSPFStyleLogBase.getPSPFStyleLogName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLELOGNAME, (Object)pSPFStyleLogBase.getPSPFStyleLogName());
        }
        if (pSPFStyleLogBase.isPSPFStyleNameDirty() && (bl || pSPFStyleLogBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStyleLogBase.getPSPFStyleName());
        }
        if (pSPFStyleLogBase.isUpdateDateDirty() && (bl || pSPFStyleLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStyleLogBase.getUpdateDate());
        }
        if (pSPFStyleLogBase.isUpdateManDirty() && (bl || pSPFStyleLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStyleLogBase.getUpdateMan());
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
        return PSPFStyleLogBase.remove(this, n);
    }

    private static boolean remove(PSPFStyleLogBase pSPFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleLogBase.resetChangeLog();
                return true;
            }
            case 1: {
                pSPFStyleLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFStyleLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFStyleLogBase.resetPSPFId();
                return true;
            }
            case 4: {
                pSPFStyleLogBase.resetPSPFName();
                return true;
            }
            case 5: {
                pSPFStyleLogBase.resetPSPFStyleId();
                return true;
            }
            case 6: {
                pSPFStyleLogBase.resetPSPFStyleLogId();
                return true;
            }
            case 7: {
                pSPFStyleLogBase.resetPSPFStyleLogName();
                return true;
            }
            case 8: {
                pSPFStyleLogBase.resetPSPFStyleName();
                return true;
            }
            case 9: {
                pSPFStyleLogBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSPFStyleLogBase.resetUpdateMan();
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
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFStyleLogBase getProxyEntity() {
        return this.proxyPSPFStyleLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStyleLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStyleLogBase) {
            this.proxyPSPFStyleLogBase = (PSPFStyleLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHANGELOG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_PSPFID, 3);
        fieldIndexMap.put(FIELD_PSPFNAME, 4);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 5);
        fieldIndexMap.put(FIELD_PSPFSTYLELOGID, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLELOGNAME, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

