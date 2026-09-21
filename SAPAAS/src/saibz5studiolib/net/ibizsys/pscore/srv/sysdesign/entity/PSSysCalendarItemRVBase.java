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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarItemRVBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCalendarItemRVBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARITEMID = "PSSYSCALENDARITEMID";
    public static final String FIELD_PSSYSCALENDARITEMNAME = "PSSYSCALENDARITEMNAME";
    public static final String FIELD_PSSYSCALENDARITEMRVID = "PSSYSCALENDARITEMRVID";
    public static final String FIELD_PSSYSCALENDARITEMRVNAME = "PSSYSCALENDARITEMRVNAME";
    public static final String FIELD_REFMODETEXT = "REFMODETEXT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVIEWBASEID = 3;
    private static final int INDEX_PSDEVIEWBASENAME = 4;
    private static final int INDEX_PSSYSCALENDARID = 5;
    private static final int INDEX_PSSYSCALENDARITEMID = 6;
    private static final int INDEX_PSSYSCALENDARITEMNAME = 7;
    private static final int INDEX_PSSYSCALENDARITEMRVID = 8;
    private static final int INDEX_PSSYSCALENDARITEMRVNAME = 9;
    private static final int INDEX_REFMODETEXT = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VIEWPARAMS = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCalendarItemRVBase proxyPSSysCalendarItemRVBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendaritemidDirtyFlag = false;
    private boolean pssyscalendaritemnameDirtyFlag = false;
    private boolean pssyscalendaritemrvidDirtyFlag = false;
    private boolean pssyscalendaritemrvnameDirtyFlag = false;
    private boolean refmodetextDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendaritemid")
    private String pssyscalendaritemid;
    @Column(name="pssyscalendaritemname")
    private String pssyscalendaritemname;
    @Column(name="pssyscalendaritemrvid")
    private String pssyscalendaritemrvid;
    @Column(name="pssyscalendaritemrvname")
    private String pssyscalendaritemrvname;
    @Column(name="refmodetext")
    private String refmodetext;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewparams")
    private String viewparams;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSSysCalendarItemLock = new Integer(1);
    private PSSysCalendarItem pssyscalendaritem = null;

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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSSysCalendarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarid = string;
        this.pssyscalendaridDirtyFlag = true;
    }

    public String getPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarId();
        }
        return this.pssyscalendarid;
    }

    public boolean isPSSysCalendarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarIdDirty();
        }
        return this.pssyscalendaridDirtyFlag;
    }

    public void resetPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarId();
            return;
        }
        this.pssyscalendaridDirtyFlag = false;
        this.pssyscalendarid = null;
    }

    public void setPSSysCalendarItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemid = string;
        this.pssyscalendaritemidDirtyFlag = true;
    }

    public String getPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemId();
        }
        return this.pssyscalendaritemid;
    }

    public boolean isPSSysCalendarItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemIdDirty();
        }
        return this.pssyscalendaritemidDirtyFlag;
    }

    public void resetPSSysCalendarItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemId();
            return;
        }
        this.pssyscalendaritemidDirtyFlag = false;
        this.pssyscalendaritemid = null;
    }

    public void setPSSysCalendarItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemname = string;
        this.pssyscalendaritemnameDirtyFlag = true;
    }

    public String getPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemName();
        }
        return this.pssyscalendaritemname;
    }

    public boolean isPSSysCalendarItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemNameDirty();
        }
        return this.pssyscalendaritemnameDirtyFlag;
    }

    public void resetPSSysCalendarItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemName();
            return;
        }
        this.pssyscalendaritemnameDirtyFlag = false;
        this.pssyscalendaritemname = null;
    }

    public void setPSSysCalendarItemRVId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemRVId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemrvid = string;
        this.pssyscalendaritemrvidDirtyFlag = true;
    }

    public String getPSSysCalendarItemRVId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemRVId();
        }
        return this.pssyscalendaritemrvid;
    }

    public boolean isPSSysCalendarItemRVIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemRVIdDirty();
        }
        return this.pssyscalendaritemrvidDirtyFlag;
    }

    public void resetPSSysCalendarItemRVId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemRVId();
            return;
        }
        this.pssyscalendaritemrvidDirtyFlag = false;
        this.pssyscalendaritemrvid = null;
    }

    public void setPSSysCalendarItemRVName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarItemRVName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendaritemrvname = string;
        this.pssyscalendaritemrvnameDirtyFlag = true;
    }

    public String getPSSysCalendarItemRVName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItemRVName();
        }
        return this.pssyscalendaritemrvname;
    }

    public boolean isPSSysCalendarItemRVNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarItemRVNameDirty();
        }
        return this.pssyscalendaritemrvnameDirtyFlag;
    }

    public void resetPSSysCalendarItemRVName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarItemRVName();
            return;
        }
        this.pssyscalendaritemrvnameDirtyFlag = false;
        this.pssyscalendaritemrvname = null;
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

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    protected void onReset() {
        PSSysCalendarItemRVBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCalendarItemRVBase pSSysCalendarItemRVBase) {
        pSSysCalendarItemRVBase.resetCreateDate();
        pSSysCalendarItemRVBase.resetCreateMan();
        pSSysCalendarItemRVBase.resetMemo();
        pSSysCalendarItemRVBase.resetPSDEViewBaseId();
        pSSysCalendarItemRVBase.resetPSDEViewBaseName();
        pSSysCalendarItemRVBase.resetPSSysCalendarId();
        pSSysCalendarItemRVBase.resetPSSysCalendarItemId();
        pSSysCalendarItemRVBase.resetPSSysCalendarItemName();
        pSSysCalendarItemRVBase.resetPSSysCalendarItemRVId();
        pSSysCalendarItemRVBase.resetPSSysCalendarItemRVName();
        pSSysCalendarItemRVBase.resetRefModeText();
        pSSysCalendarItemRVBase.resetUpdateDate();
        pSSysCalendarItemRVBase.resetUpdateMan();
        pSSysCalendarItemRVBase.resetViewParams();
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
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarItemIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMID, this.getPSSysCalendarItemId());
        }
        if (!bl || this.isPSSysCalendarItemNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMNAME, this.getPSSysCalendarItemName());
        }
        if (!bl || this.isPSSysCalendarItemRVIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMRVID, this.getPSSysCalendarItemRVId());
        }
        if (!bl || this.isPSSysCalendarItemRVNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARITEMRVNAME, this.getPSSysCalendarItemRVName());
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
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
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
        return PSSysCalendarItemRVBase.get(this, n);
    }

    private static Object get(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemRVBase.getCreateDate();
            }
            case 1: {
                return pSSysCalendarItemRVBase.getCreateMan();
            }
            case 2: {
                return pSSysCalendarItemRVBase.getMemo();
            }
            case 3: {
                return pSSysCalendarItemRVBase.getPSDEViewBaseId();
            }
            case 4: {
                return pSSysCalendarItemRVBase.getPSDEViewBaseName();
            }
            case 5: {
                return pSSysCalendarItemRVBase.getPSSysCalendarId();
            }
            case 6: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemId();
            }
            case 7: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemName();
            }
            case 8: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemRVId();
            }
            case 9: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemRVName();
            }
            case 10: {
                return pSSysCalendarItemRVBase.getRefModeText();
            }
            case 11: {
                return pSSysCalendarItemRVBase.getUpdateDate();
            }
            case 12: {
                return pSSysCalendarItemRVBase.getUpdateMan();
            }
            case 13: {
                return pSSysCalendarItemRVBase.getViewParams();
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
        PSSysCalendarItemRVBase.set(this, n, object);
    }

    private static void set(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarItemRVBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysCalendarItemRVBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCalendarItemRVBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCalendarItemRVBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCalendarItemRVBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCalendarItemRVBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCalendarItemRVBase.setPSSysCalendarItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCalendarItemRVBase.setPSSysCalendarItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCalendarItemRVBase.setPSSysCalendarItemRVId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCalendarItemRVBase.setPSSysCalendarItemRVName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCalendarItemRVBase.setRefModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCalendarItemRVBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysCalendarItemRVBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCalendarItemRVBase.setViewParams(DataObject.getStringValue((Object)object));
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
        return PSSysCalendarItemRVBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemRVBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysCalendarItemRVBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysCalendarItemRVBase.getMemo() == null;
            }
            case 3: {
                return pSSysCalendarItemRVBase.getPSDEViewBaseId() == null;
            }
            case 4: {
                return pSSysCalendarItemRVBase.getPSDEViewBaseName() == null;
            }
            case 5: {
                return pSSysCalendarItemRVBase.getPSSysCalendarId() == null;
            }
            case 6: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemId() == null;
            }
            case 7: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemName() == null;
            }
            case 8: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemRVId() == null;
            }
            case 9: {
                return pSSysCalendarItemRVBase.getPSSysCalendarItemRVName() == null;
            }
            case 10: {
                return pSSysCalendarItemRVBase.getRefModeText() == null;
            }
            case 11: {
                return pSSysCalendarItemRVBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysCalendarItemRVBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysCalendarItemRVBase.getViewParams() == null;
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
        return PSSysCalendarItemRVBase.contains(this, n);
    }

    private static boolean contains(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCalendarItemRVBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysCalendarItemRVBase.isCreateManDirty();
            }
            case 2: {
                return pSSysCalendarItemRVBase.isMemoDirty();
            }
            case 3: {
                return pSSysCalendarItemRVBase.isPSDEViewBaseIdDirty();
            }
            case 4: {
                return pSSysCalendarItemRVBase.isPSDEViewBaseNameDirty();
            }
            case 5: {
                return pSSysCalendarItemRVBase.isPSSysCalendarIdDirty();
            }
            case 6: {
                return pSSysCalendarItemRVBase.isPSSysCalendarItemIdDirty();
            }
            case 7: {
                return pSSysCalendarItemRVBase.isPSSysCalendarItemNameDirty();
            }
            case 8: {
                return pSSysCalendarItemRVBase.isPSSysCalendarItemRVIdDirty();
            }
            case 9: {
                return pSSysCalendarItemRVBase.isPSSysCalendarItemRVNameDirty();
            }
            case 10: {
                return pSSysCalendarItemRVBase.isRefModeTextDirty();
            }
            case 11: {
                return pSSysCalendarItemRVBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysCalendarItemRVBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysCalendarItemRVBase.isViewParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCalendarItemRVBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCalendarItemRVBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemid", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSSysCalendarItemId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemname", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSSysCalendarItemName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemrvid", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSSysCalendarItemRVId()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendaritemrvname", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getPSSysCalendarItemRVName()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getRefModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodetext", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getRefModeText()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCalendarItemRVBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSSysCalendarItemRVBase.getJSONValue((Object)pSSysCalendarItemRVBase.getViewParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCalendarItemRVBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCalendarItemRVBase.getCreateDate() != null) {
            object = pSSysCalendarItemRVBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarItemRVBase.getCreateMan() != null) {
            object = pSSysCalendarItemRVBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getMemo() != null) {
            object = pSSysCalendarItemRVBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSDEViewBaseId() != null) {
            object = pSSysCalendarItemRVBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSDEViewBaseName() != null) {
            object = pSSysCalendarItemRVBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarId() != null) {
            object = pSSysCalendarItemRVBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemId() != null) {
            object = pSSysCalendarItemRVBase.getPSSysCalendarItemId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemName() != null) {
            object = pSSysCalendarItemRVBase.getPSSysCalendarItemName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVId() != null) {
            object = pSSysCalendarItemRVBase.getPSSysCalendarItemRVId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMRVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVName() != null) {
            object = pSSysCalendarItemRVBase.getPSSysCalendarItemRVName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARITEMRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getRefModeText() != null) {
            object = pSSysCalendarItemRVBase.getRefModeText();
            xmlNode.setAttribute(FIELD_REFMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getUpdateDate() != null) {
            object = pSSysCalendarItemRVBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCalendarItemRVBase.getUpdateMan() != null) {
            object = pSSysCalendarItemRVBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCalendarItemRVBase.getViewParams() != null) {
            object = pSSysCalendarItemRVBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCalendarItemRVBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCalendarItemRVBase.isCreateDateDirty() && (bl || pSSysCalendarItemRVBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCalendarItemRVBase.getCreateDate());
        }
        if (pSSysCalendarItemRVBase.isCreateManDirty() && (bl || pSSysCalendarItemRVBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCalendarItemRVBase.getCreateMan());
        }
        if (pSSysCalendarItemRVBase.isMemoDirty() && (bl || pSSysCalendarItemRVBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCalendarItemRVBase.getMemo());
        }
        if (pSSysCalendarItemRVBase.isPSDEViewBaseIdDirty() && (bl || pSSysCalendarItemRVBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysCalendarItemRVBase.getPSDEViewBaseId());
        }
        if (pSSysCalendarItemRVBase.isPSDEViewBaseNameDirty() && (bl || pSSysCalendarItemRVBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysCalendarItemRVBase.getPSDEViewBaseName());
        }
        if (pSSysCalendarItemRVBase.isPSSysCalendarIdDirty() && (bl || pSSysCalendarItemRVBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysCalendarItemRVBase.getPSSysCalendarId());
        }
        if (pSSysCalendarItemRVBase.isPSSysCalendarItemIdDirty() && (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMID, (Object)pSSysCalendarItemRVBase.getPSSysCalendarItemId());
        }
        if (pSSysCalendarItemRVBase.isPSSysCalendarItemNameDirty() && (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMNAME, (Object)pSSysCalendarItemRVBase.getPSSysCalendarItemName());
        }
        if (pSSysCalendarItemRVBase.isPSSysCalendarItemRVIdDirty() && (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMRVID, (Object)pSSysCalendarItemRVBase.getPSSysCalendarItemRVId());
        }
        if (pSSysCalendarItemRVBase.isPSSysCalendarItemRVNameDirty() && (bl || pSSysCalendarItemRVBase.getPSSysCalendarItemRVName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARITEMRVNAME, (Object)pSSysCalendarItemRVBase.getPSSysCalendarItemRVName());
        }
        if (pSSysCalendarItemRVBase.isRefModeTextDirty() && (bl || pSSysCalendarItemRVBase.getRefModeText() != null)) {
            iDataObject.set(FIELD_REFMODETEXT, (Object)pSSysCalendarItemRVBase.getRefModeText());
        }
        if (pSSysCalendarItemRVBase.isUpdateDateDirty() && (bl || pSSysCalendarItemRVBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCalendarItemRVBase.getUpdateDate());
        }
        if (pSSysCalendarItemRVBase.isUpdateManDirty() && (bl || pSSysCalendarItemRVBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCalendarItemRVBase.getUpdateMan());
        }
        if (pSSysCalendarItemRVBase.isViewParamsDirty() && (bl || pSSysCalendarItemRVBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSSysCalendarItemRVBase.getViewParams());
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
        return PSSysCalendarItemRVBase.remove(this, n);
    }

    private static boolean remove(PSSysCalendarItemRVBase pSSysCalendarItemRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCalendarItemRVBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysCalendarItemRVBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysCalendarItemRVBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysCalendarItemRVBase.resetPSDEViewBaseId();
                return true;
            }
            case 4: {
                pSSysCalendarItemRVBase.resetPSDEViewBaseName();
                return true;
            }
            case 5: {
                pSSysCalendarItemRVBase.resetPSSysCalendarId();
                return true;
            }
            case 6: {
                pSSysCalendarItemRVBase.resetPSSysCalendarItemId();
                return true;
            }
            case 7: {
                pSSysCalendarItemRVBase.resetPSSysCalendarItemName();
                return true;
            }
            case 8: {
                pSSysCalendarItemRVBase.resetPSSysCalendarItemRVId();
                return true;
            }
            case 9: {
                pSSysCalendarItemRVBase.resetPSSysCalendarItemRVName();
                return true;
            }
            case 10: {
                pSSysCalendarItemRVBase.resetRefModeText();
                return true;
            }
            case 11: {
                pSSysCalendarItemRVBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysCalendarItemRVBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysCalendarItemRVBase.resetViewParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCalendarItem getPSSysCalendarItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarItem();
        }
        if (this.getPSSysCalendarItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarItemLock;
        synchronized (n) {
            if (this.pssyscalendaritem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarItemId(), (Object)this.pssyscalendaritem.getPSSysCalendarItemId()) != 0L) {
                this.pssyscalendaritem = null;
            }
            if (this.pssyscalendaritem == null) {
                PSSysCalendarItem pSSysCalendarItem = new PSSysCalendarItem();
                pSSysCalendarItem.setPSSysCalendarItemId(this.getPSSysCalendarItemId());
                PSSysCalendarItemService pSSysCalendarItemService = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarItemService.autoGet((IEntity)pSSysCalendarItem);
                this.pssyscalendaritem = pSSysCalendarItem;
            }
            return this.pssyscalendaritem;
        }
    }

    private PSSysCalendarItemRVBase getProxyEntity() {
        return this.proxyPSSysCalendarItemRVBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCalendarItemRVBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCalendarItemRVBase) {
            this.proxyPSSysCalendarItemRVBase = (PSSysCalendarItemRVBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 3);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 4);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 5);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMRVID, 8);
        fieldIndexMap.put(FIELD_PSSYSCALENDARITEMRVNAME, 9);
        fieldIndexMap.put(FIELD_REFMODETEXT, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 13);
    }
}

