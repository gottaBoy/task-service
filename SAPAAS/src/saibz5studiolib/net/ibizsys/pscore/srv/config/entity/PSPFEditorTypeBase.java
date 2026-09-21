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
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFEditorTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFEditorTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EDITORCLASS = "EDITORCLASS";
    public static final String FIELD_EDITORDESC = "EDITORDESC";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_PSPFEDITORTYPEID = "PSPFEDITORTYPEID";
    public static final String FIELD_PSPFEDITORTYPENAME = "PSPFEDITORTYPENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EDITORCLASS = 2;
    private static final int INDEX_EDITORDESC = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSEDITORTYPEID = 5;
    private static final int INDEX_PSEDITORTYPENAME = 6;
    private static final int INDEX_PSPFEDITORTYPEID = 7;
    private static final int INDEX_PSPFEDITORTYPENAME = 8;
    private static final int INDEX_PSPFID = 9;
    private static final int INDEX_PSPFNAME = 10;
    private static final int INDEX_PSPFSTYLEID = 11;
    private static final int INDEX_PSPFSTYLENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFEditorTypeBase proxyPSPFEditorTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean editorclassDirtyFlag = false;
    private boolean editordescDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean pspfeditortypeidDirtyFlag = false;
    private boolean pspfeditortypenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="editorclass")
    private String editorclass;
    @Column(name="editordesc")
    private String editordesc;
    @Column(name="memo")
    private String memo;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="pspfeditortypeid")
    private String pspfeditortypeid;
    @Column(name="pspfeditortypename")
    private String pspfeditortypename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSEditorTypeLock = new Integer(1);
    private PSEditorType pseditortype = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setEditorClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorclass = string;
        this.editorclassDirtyFlag = true;
    }

    public String getEditorClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorClass();
        }
        return this.editorclass;
    }

    public boolean isEditorClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorClassDirty();
        }
        return this.editorclassDirtyFlag;
    }

    public void resetEditorClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorClass();
            return;
        }
        this.editorclassDirtyFlag = false;
        this.editorclass = null;
    }

    public void setEditorDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editordesc = string;
        this.editordescDirtyFlag = true;
    }

    public String getEditorDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorDesc();
        }
        return this.editordesc;
    }

    public boolean isEditorDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorDescDirty();
        }
        return this.editordescDirtyFlag;
    }

    public void resetEditorDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorDesc();
            return;
        }
        this.editordescDirtyFlag = false;
        this.editordesc = null;
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

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
    }

    public void setPSPFEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfeditortypeid = string;
        this.pspfeditortypeidDirtyFlag = true;
    }

    public String getPSPFEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFEditorTypeId();
        }
        return this.pspfeditortypeid;
    }

    public boolean isPSPFEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFEditorTypeIdDirty();
        }
        return this.pspfeditortypeidDirtyFlag;
    }

    public void resetPSPFEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFEditorTypeId();
            return;
        }
        this.pspfeditortypeidDirtyFlag = false;
        this.pspfeditortypeid = null;
    }

    public void setPSPFEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfeditortypename = string;
        this.pspfeditortypenameDirtyFlag = true;
    }

    public String getPSPFEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFEditorTypeName();
        }
        return this.pspfeditortypename;
    }

    public boolean isPSPFEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFEditorTypeNameDirty();
        }
        return this.pspfeditortypenameDirtyFlag;
    }

    public void resetPSPFEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFEditorTypeName();
            return;
        }
        this.pspfeditortypenameDirtyFlag = false;
        this.pspfeditortypename = null;
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
        PSPFEditorTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFEditorTypeBase pSPFEditorTypeBase) {
        pSPFEditorTypeBase.resetCreateDate();
        pSPFEditorTypeBase.resetCreateMan();
        pSPFEditorTypeBase.resetEditorClass();
        pSPFEditorTypeBase.resetEditorDesc();
        pSPFEditorTypeBase.resetMemo();
        pSPFEditorTypeBase.resetPSEditorTypeId();
        pSPFEditorTypeBase.resetPSEditorTypeName();
        pSPFEditorTypeBase.resetPSPFEditorTypeId();
        pSPFEditorTypeBase.resetPSPFEditorTypeName();
        pSPFEditorTypeBase.resetPSPFId();
        pSPFEditorTypeBase.resetPSPFName();
        pSPFEditorTypeBase.resetPSPFStyleId();
        pSPFEditorTypeBase.resetPSPFStyleName();
        pSPFEditorTypeBase.resetUpdateDate();
        pSPFEditorTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEditorClassDirty()) {
            hashMap.put(FIELD_EDITORCLASS, this.getEditorClass());
        }
        if (!bl || this.isEditorDescDirty()) {
            hashMap.put(FIELD_EDITORDESC, this.getEditorDesc());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isPSPFEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSPFEDITORTYPEID, this.getPSPFEditorTypeId());
        }
        if (!bl || this.isPSPFEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSPFEDITORTYPENAME, this.getPSPFEditorTypeName());
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
        return PSPFEditorTypeBase.get(this, n);
    }

    private static Object get(PSPFEditorTypeBase pSPFEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTypeBase.getCreateDate();
            }
            case 1: {
                return pSPFEditorTypeBase.getCreateMan();
            }
            case 2: {
                return pSPFEditorTypeBase.getEditorClass();
            }
            case 3: {
                return pSPFEditorTypeBase.getEditorDesc();
            }
            case 4: {
                return pSPFEditorTypeBase.getMemo();
            }
            case 5: {
                return pSPFEditorTypeBase.getPSEditorTypeId();
            }
            case 6: {
                return pSPFEditorTypeBase.getPSEditorTypeName();
            }
            case 7: {
                return pSPFEditorTypeBase.getPSPFEditorTypeId();
            }
            case 8: {
                return pSPFEditorTypeBase.getPSPFEditorTypeName();
            }
            case 9: {
                return pSPFEditorTypeBase.getPSPFId();
            }
            case 10: {
                return pSPFEditorTypeBase.getPSPFName();
            }
            case 11: {
                return pSPFEditorTypeBase.getPSPFStyleId();
            }
            case 12: {
                return pSPFEditorTypeBase.getPSPFStyleName();
            }
            case 13: {
                return pSPFEditorTypeBase.getUpdateDate();
            }
            case 14: {
                return pSPFEditorTypeBase.getUpdateMan();
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
        PSPFEditorTypeBase.set(this, n, object);
    }

    private static void set(PSPFEditorTypeBase pSPFEditorTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFEditorTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFEditorTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFEditorTypeBase.setEditorClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFEditorTypeBase.setEditorDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFEditorTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFEditorTypeBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFEditorTypeBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFEditorTypeBase.setPSPFEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFEditorTypeBase.setPSPFEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFEditorTypeBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFEditorTypeBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFEditorTypeBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFEditorTypeBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFEditorTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFEditorTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFEditorTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFEditorTypeBase pSPFEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFEditorTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFEditorTypeBase.getEditorClass() == null;
            }
            case 3: {
                return pSPFEditorTypeBase.getEditorDesc() == null;
            }
            case 4: {
                return pSPFEditorTypeBase.getMemo() == null;
            }
            case 5: {
                return pSPFEditorTypeBase.getPSEditorTypeId() == null;
            }
            case 6: {
                return pSPFEditorTypeBase.getPSEditorTypeName() == null;
            }
            case 7: {
                return pSPFEditorTypeBase.getPSPFEditorTypeId() == null;
            }
            case 8: {
                return pSPFEditorTypeBase.getPSPFEditorTypeName() == null;
            }
            case 9: {
                return pSPFEditorTypeBase.getPSPFId() == null;
            }
            case 10: {
                return pSPFEditorTypeBase.getPSPFName() == null;
            }
            case 11: {
                return pSPFEditorTypeBase.getPSPFStyleId() == null;
            }
            case 12: {
                return pSPFEditorTypeBase.getPSPFStyleName() == null;
            }
            case 13: {
                return pSPFEditorTypeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPFEditorTypeBase.getUpdateMan() == null;
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
        return PSPFEditorTypeBase.contains(this, n);
    }

    private static boolean contains(PSPFEditorTypeBase pSPFEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFEditorTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFEditorTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPFEditorTypeBase.isEditorClassDirty();
            }
            case 3: {
                return pSPFEditorTypeBase.isEditorDescDirty();
            }
            case 4: {
                return pSPFEditorTypeBase.isMemoDirty();
            }
            case 5: {
                return pSPFEditorTypeBase.isPSEditorTypeIdDirty();
            }
            case 6: {
                return pSPFEditorTypeBase.isPSEditorTypeNameDirty();
            }
            case 7: {
                return pSPFEditorTypeBase.isPSPFEditorTypeIdDirty();
            }
            case 8: {
                return pSPFEditorTypeBase.isPSPFEditorTypeNameDirty();
            }
            case 9: {
                return pSPFEditorTypeBase.isPSPFIdDirty();
            }
            case 10: {
                return pSPFEditorTypeBase.isPSPFNameDirty();
            }
            case 11: {
                return pSPFEditorTypeBase.isPSPFStyleIdDirty();
            }
            case 12: {
                return pSPFEditorTypeBase.isPSPFStyleNameDirty();
            }
            case 13: {
                return pSPFEditorTypeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPFEditorTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFEditorTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFEditorTypeBase pSPFEditorTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFEditorTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getEditorClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorclass", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getEditorClass()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getEditorDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editordesc", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getEditorDesc()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfeditortypeid", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFEditorTypeId()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfeditortypename", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFEditorTypeName()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFEditorTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFEditorTypeBase.getJSONValue((Object)pSPFEditorTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFEditorTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFEditorTypeBase pSPFEditorTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFEditorTypeBase.getCreateDate() != null) {
            object = pSPFEditorTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFEditorTypeBase.getCreateMan() != null) {
            object = pSPFEditorTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getEditorClass() != null) {
            object = pSPFEditorTypeBase.getEditorClass();
            xmlNode.setAttribute(FIELD_EDITORCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getEditorDesc() != null) {
            object = pSPFEditorTypeBase.getEditorDesc();
            xmlNode.setAttribute(FIELD_EDITORDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getMemo() != null) {
            object = pSPFEditorTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSEditorTypeId() != null) {
            object = pSPFEditorTypeBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSEditorTypeName() != null) {
            object = pSPFEditorTypeBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFEditorTypeId() != null) {
            object = pSPFEditorTypeBase.getPSPFEditorTypeId();
            xmlNode.setAttribute(FIELD_PSPFEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFEditorTypeName() != null) {
            object = pSPFEditorTypeBase.getPSPFEditorTypeName();
            xmlNode.setAttribute(FIELD_PSPFEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFId() != null) {
            object = pSPFEditorTypeBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFName() != null) {
            object = pSPFEditorTypeBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFStyleId() != null) {
            object = pSPFEditorTypeBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getPSPFStyleName() != null) {
            object = pSPFEditorTypeBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFEditorTypeBase.getUpdateDate() != null) {
            object = pSPFEditorTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFEditorTypeBase.getUpdateMan() != null) {
            object = pSPFEditorTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFEditorTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFEditorTypeBase pSPFEditorTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFEditorTypeBase.isCreateDateDirty() && (bl || pSPFEditorTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFEditorTypeBase.getCreateDate());
        }
        if (pSPFEditorTypeBase.isCreateManDirty() && (bl || pSPFEditorTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFEditorTypeBase.getCreateMan());
        }
        if (pSPFEditorTypeBase.isEditorClassDirty() && (bl || pSPFEditorTypeBase.getEditorClass() != null)) {
            iDataObject.set(FIELD_EDITORCLASS, (Object)pSPFEditorTypeBase.getEditorClass());
        }
        if (pSPFEditorTypeBase.isEditorDescDirty() && (bl || pSPFEditorTypeBase.getEditorDesc() != null)) {
            iDataObject.set(FIELD_EDITORDESC, (Object)pSPFEditorTypeBase.getEditorDesc());
        }
        if (pSPFEditorTypeBase.isMemoDirty() && (bl || pSPFEditorTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFEditorTypeBase.getMemo());
        }
        if (pSPFEditorTypeBase.isPSEditorTypeIdDirty() && (bl || pSPFEditorTypeBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSPFEditorTypeBase.getPSEditorTypeId());
        }
        if (pSPFEditorTypeBase.isPSEditorTypeNameDirty() && (bl || pSPFEditorTypeBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSPFEditorTypeBase.getPSEditorTypeName());
        }
        if (pSPFEditorTypeBase.isPSPFEditorTypeIdDirty() && (bl || pSPFEditorTypeBase.getPSPFEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSPFEDITORTYPEID, (Object)pSPFEditorTypeBase.getPSPFEditorTypeId());
        }
        if (pSPFEditorTypeBase.isPSPFEditorTypeNameDirty() && (bl || pSPFEditorTypeBase.getPSPFEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSPFEDITORTYPENAME, (Object)pSPFEditorTypeBase.getPSPFEditorTypeName());
        }
        if (pSPFEditorTypeBase.isPSPFIdDirty() && (bl || pSPFEditorTypeBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFEditorTypeBase.getPSPFId());
        }
        if (pSPFEditorTypeBase.isPSPFNameDirty() && (bl || pSPFEditorTypeBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFEditorTypeBase.getPSPFName());
        }
        if (pSPFEditorTypeBase.isPSPFStyleIdDirty() && (bl || pSPFEditorTypeBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFEditorTypeBase.getPSPFStyleId());
        }
        if (pSPFEditorTypeBase.isPSPFStyleNameDirty() && (bl || pSPFEditorTypeBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFEditorTypeBase.getPSPFStyleName());
        }
        if (pSPFEditorTypeBase.isUpdateDateDirty() && (bl || pSPFEditorTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFEditorTypeBase.getUpdateDate());
        }
        if (pSPFEditorTypeBase.isUpdateManDirty() && (bl || pSPFEditorTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFEditorTypeBase.getUpdateMan());
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
        return PSPFEditorTypeBase.remove(this, n);
    }

    private static boolean remove(PSPFEditorTypeBase pSPFEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFEditorTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFEditorTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFEditorTypeBase.resetEditorClass();
                return true;
            }
            case 3: {
                pSPFEditorTypeBase.resetEditorDesc();
                return true;
            }
            case 4: {
                pSPFEditorTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFEditorTypeBase.resetPSEditorTypeId();
                return true;
            }
            case 6: {
                pSPFEditorTypeBase.resetPSEditorTypeName();
                return true;
            }
            case 7: {
                pSPFEditorTypeBase.resetPSPFEditorTypeId();
                return true;
            }
            case 8: {
                pSPFEditorTypeBase.resetPSPFEditorTypeName();
                return true;
            }
            case 9: {
                pSPFEditorTypeBase.resetPSPFId();
                return true;
            }
            case 10: {
                pSPFEditorTypeBase.resetPSPFName();
                return true;
            }
            case 11: {
                pSPFEditorTypeBase.resetPSPFStyleId();
                return true;
            }
            case 12: {
                pSPFEditorTypeBase.resetPSPFStyleName();
                return true;
            }
            case 13: {
                pSPFEditorTypeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPFEditorTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorType getPSEditorType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorType();
        }
        if (this.getPSEditorTypeId() == null) {
            return null;
        }
        Integer n = this.objPSEditorTypeLock;
        synchronized (n) {
            if (this.pseditortype != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorTypeId(), (Object)this.pseditortype.getPSEditorTypeId()) != 0L) {
                this.pseditortype = null;
            }
            if (this.pseditortype == null) {
                PSEditorType pSEditorType = new PSEditorType();
                pSEditorType.setPSEditorTypeId(this.getPSEditorTypeId());
                PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
                pSEditorTypeService.autoGet((IEntity)pSEditorType);
                this.pseditortype = pSEditorType;
            }
            return this.pseditortype;
        }
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
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFEditorTypeBase getProxyEntity() {
        return this.proxyPSPFEditorTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFEditorTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFEditorTypeBase) {
            this.proxyPSPFEditorTypeBase = (PSPFEditorTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFEditorTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EDITORCLASS, 2);
        fieldIndexMap.put(FIELD_EDITORDESC, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 5);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSPFEDITORTYPEID, 7);
        fieldIndexMap.put(FIELD_PSPFEDITORTYPENAME, 8);
        fieldIndexMap.put(FIELD_PSPFID, 9);
        fieldIndexMap.put(FIELD_PSPFNAME, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 11);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

