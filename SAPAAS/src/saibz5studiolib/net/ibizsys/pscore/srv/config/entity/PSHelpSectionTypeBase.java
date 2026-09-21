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
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTempl;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpSectionTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OUTPUTDIR = "OUTPUTDIR";
    public static final String FIELD_PSHELPSECTIONTEMPLID = "PSHELPSECTIONTEMPLID";
    public static final String FIELD_PSHELPSECTIONTEMPLNAME = "PSHELPSECTIONTEMPLNAME";
    public static final String FIELD_PSHELPSECTIONTYPEID = "PSHELPSECTIONTYPEID";
    public static final String FIELD_PSHELPSECTIONTYPENAME = "PSHELPSECTIONTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_SECTIONOBJ = "SECTIONOBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_OUTPUTDIR = 3;
    private static final int INDEX_PSHELPSECTIONTEMPLID = 4;
    private static final int INDEX_PSHELPSECTIONTEMPLNAME = 5;
    private static final int INDEX_PSHELPSECTIONTYPEID = 6;
    private static final int INDEX_PSHELPSECTIONTYPENAME = 7;
    private static final int INDEX_PUBOBJ = 8;
    private static final int INDEX_SECTIONOBJ = 9;
    private static final int INDEX_TYPEOBJ = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpSectionTypeBase proxyPSHelpSectionTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean outputdirDirtyFlag = false;
    private boolean pshelpsectiontemplidDirtyFlag = false;
    private boolean pshelpsectiontemplnameDirtyFlag = false;
    private boolean pshelpsectiontypeidDirtyFlag = false;
    private boolean pshelpsectiontypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean sectionobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="outputdir")
    private Integer outputdir;
    @Column(name="pshelpsectiontemplid")
    private String pshelpsectiontemplid;
    @Column(name="pshelpsectiontemplname")
    private String pshelpsectiontemplname;
    @Column(name="pshelpsectiontypeid")
    private String pshelpsectiontypeid;
    @Column(name="pshelpsectiontypename")
    private String pshelpsectiontypename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="sectionobj")
    private String sectionobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSHelpSectionTemplLock = new Integer(1);
    private PSHelpSectionTempl pshelpsectiontempl = null;

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

    public void setOutputDir(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutputDir(n);
            return;
        }
        this.outputdir = n;
        this.outputdirDirtyFlag = true;
    }

    public Integer getOutputDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutputDir();
        }
        return this.outputdir;
    }

    public boolean isOutputDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutputDirDirty();
        }
        return this.outputdirDirtyFlag;
    }

    public void resetOutputDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutputDir();
            return;
        }
        this.outputdirDirtyFlag = false;
        this.outputdir = null;
    }

    public void setPSHelpSectionTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplid = string;
        this.pshelpsectiontemplidDirtyFlag = true;
    }

    public String getPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplId();
        }
        return this.pshelpsectiontemplid;
    }

    public boolean isPSHelpSectionTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplIdDirty();
        }
        return this.pshelpsectiontemplidDirtyFlag;
    }

    public void resetPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplId();
            return;
        }
        this.pshelpsectiontemplidDirtyFlag = false;
        this.pshelpsectiontemplid = null;
    }

    public void setPSHelpSectionTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplname = string;
        this.pshelpsectiontemplnameDirtyFlag = true;
    }

    public String getPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplName();
        }
        return this.pshelpsectiontemplname;
    }

    public boolean isPSHelpSectionTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplNameDirty();
        }
        return this.pshelpsectiontemplnameDirtyFlag;
    }

    public void resetPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplName();
            return;
        }
        this.pshelpsectiontemplnameDirtyFlag = false;
        this.pshelpsectiontemplname = null;
    }

    public void setPSHelpSectionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypeid = string;
        this.pshelpsectiontypeidDirtyFlag = true;
    }

    public String getPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeId();
        }
        return this.pshelpsectiontypeid;
    }

    public boolean isPSHelpSectionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeIdDirty();
        }
        return this.pshelpsectiontypeidDirtyFlag;
    }

    public void resetPSHelpSectionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeId();
            return;
        }
        this.pshelpsectiontypeidDirtyFlag = false;
        this.pshelpsectiontypeid = null;
    }

    public void setPSHelpSectionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontypename = string;
        this.pshelpsectiontypenameDirtyFlag = true;
    }

    public String getPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTypeName();
        }
        return this.pshelpsectiontypename;
    }

    public boolean isPSHelpSectionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTypeNameDirty();
        }
        return this.pshelpsectiontypenameDirtyFlag;
    }

    public void resetPSHelpSectionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTypeName();
            return;
        }
        this.pshelpsectiontypenameDirtyFlag = false;
        this.pshelpsectiontypename = null;
    }

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setSectionObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectionobj = string;
        this.sectionobjDirtyFlag = true;
    }

    public String getSectionObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionObj();
        }
        return this.sectionobj;
    }

    public boolean isSectionObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionObjDirty();
        }
        return this.sectionobjDirtyFlag;
    }

    public void resetSectionObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionObj();
            return;
        }
        this.sectionobjDirtyFlag = false;
        this.sectionobj = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSHelpSectionTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpSectionTypeBase pSHelpSectionTypeBase) {
        pSHelpSectionTypeBase.resetCreateDate();
        pSHelpSectionTypeBase.resetCreateMan();
        pSHelpSectionTypeBase.resetMemo();
        pSHelpSectionTypeBase.resetOutputDir();
        pSHelpSectionTypeBase.resetPSHelpSectionTemplId();
        pSHelpSectionTypeBase.resetPSHelpSectionTemplName();
        pSHelpSectionTypeBase.resetPSHelpSectionTypeId();
        pSHelpSectionTypeBase.resetPSHelpSectionTypeName();
        pSHelpSectionTypeBase.resetPubObj();
        pSHelpSectionTypeBase.resetSectionObj();
        pSHelpSectionTypeBase.resetTypeObj();
        pSHelpSectionTypeBase.resetUpdateDate();
        pSHelpSectionTypeBase.resetUpdateMan();
        pSHelpSectionTypeBase.resetValidFlag();
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
        if (!bl || this.isOutputDirDirty()) {
            hashMap.put(FIELD_OUTPUTDIR, this.getOutputDir());
        }
        if (!bl || this.isPSHelpSectionTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLID, this.getPSHelpSectionTemplId());
        }
        if (!bl || this.isPSHelpSectionTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLNAME, this.getPSHelpSectionTemplName());
        }
        if (!bl || this.isPSHelpSectionTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPEID, this.getPSHelpSectionTypeId());
        }
        if (!bl || this.isPSHelpSectionTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTYPENAME, this.getPSHelpSectionTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isSectionObjDirty()) {
            hashMap.put(FIELD_SECTIONOBJ, this.getSectionObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSHelpSectionTypeBase.get(this, n);
    }

    private static Object get(PSHelpSectionTypeBase pSHelpSectionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTypeBase.getCreateDate();
            }
            case 1: {
                return pSHelpSectionTypeBase.getCreateMan();
            }
            case 2: {
                return pSHelpSectionTypeBase.getMemo();
            }
            case 3: {
                return pSHelpSectionTypeBase.getOutputDir();
            }
            case 4: {
                return pSHelpSectionTypeBase.getPSHelpSectionTemplId();
            }
            case 5: {
                return pSHelpSectionTypeBase.getPSHelpSectionTemplName();
            }
            case 6: {
                return pSHelpSectionTypeBase.getPSHelpSectionTypeId();
            }
            case 7: {
                return pSHelpSectionTypeBase.getPSHelpSectionTypeName();
            }
            case 8: {
                return pSHelpSectionTypeBase.getPubObj();
            }
            case 9: {
                return pSHelpSectionTypeBase.getSectionObj();
            }
            case 10: {
                return pSHelpSectionTypeBase.getTypeObj();
            }
            case 11: {
                return pSHelpSectionTypeBase.getUpdateDate();
            }
            case 12: {
                return pSHelpSectionTypeBase.getUpdateMan();
            }
            case 13: {
                return pSHelpSectionTypeBase.getValidFlag();
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
        PSHelpSectionTypeBase.set(this, n, object);
    }

    private static void set(PSHelpSectionTypeBase pSHelpSectionTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpSectionTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpSectionTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpSectionTypeBase.setOutputDir(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSHelpSectionTypeBase.setPSHelpSectionTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpSectionTypeBase.setPSHelpSectionTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpSectionTypeBase.setPSHelpSectionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpSectionTypeBase.setPSHelpSectionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpSectionTypeBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpSectionTypeBase.setSectionObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpSectionTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpSectionTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSHelpSectionTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpSectionTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpSectionTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpSectionTypeBase pSHelpSectionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpSectionTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpSectionTypeBase.getMemo() == null;
            }
            case 3: {
                return pSHelpSectionTypeBase.getOutputDir() == null;
            }
            case 4: {
                return pSHelpSectionTypeBase.getPSHelpSectionTemplId() == null;
            }
            case 5: {
                return pSHelpSectionTypeBase.getPSHelpSectionTemplName() == null;
            }
            case 6: {
                return pSHelpSectionTypeBase.getPSHelpSectionTypeId() == null;
            }
            case 7: {
                return pSHelpSectionTypeBase.getPSHelpSectionTypeName() == null;
            }
            case 8: {
                return pSHelpSectionTypeBase.getPubObj() == null;
            }
            case 9: {
                return pSHelpSectionTypeBase.getSectionObj() == null;
            }
            case 10: {
                return pSHelpSectionTypeBase.getTypeObj() == null;
            }
            case 11: {
                return pSHelpSectionTypeBase.getUpdateDate() == null;
            }
            case 12: {
                return pSHelpSectionTypeBase.getUpdateMan() == null;
            }
            case 13: {
                return pSHelpSectionTypeBase.getValidFlag() == null;
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
        return PSHelpSectionTypeBase.contains(this, n);
    }

    private static boolean contains(PSHelpSectionTypeBase pSHelpSectionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpSectionTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpSectionTypeBase.isMemoDirty();
            }
            case 3: {
                return pSHelpSectionTypeBase.isOutputDirDirty();
            }
            case 4: {
                return pSHelpSectionTypeBase.isPSHelpSectionTemplIdDirty();
            }
            case 5: {
                return pSHelpSectionTypeBase.isPSHelpSectionTemplNameDirty();
            }
            case 6: {
                return pSHelpSectionTypeBase.isPSHelpSectionTypeIdDirty();
            }
            case 7: {
                return pSHelpSectionTypeBase.isPSHelpSectionTypeNameDirty();
            }
            case 8: {
                return pSHelpSectionTypeBase.isPubObjDirty();
            }
            case 9: {
                return pSHelpSectionTypeBase.isSectionObjDirty();
            }
            case 10: {
                return pSHelpSectionTypeBase.isTypeObjDirty();
            }
            case 11: {
                return pSHelpSectionTypeBase.isUpdateDateDirty();
            }
            case 12: {
                return pSHelpSectionTypeBase.isUpdateManDirty();
            }
            case 13: {
                return pSHelpSectionTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpSectionTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpSectionTypeBase pSHelpSectionTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpSectionTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getOutputDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputdir", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getOutputDir()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplid", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getPSHelpSectionTemplId()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplname", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getPSHelpSectionTemplName()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypeid", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getPSHelpSectionTypeId()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontypename", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getPSHelpSectionTypeName()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getSectionObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectionobj", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getSectionObj()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpSectionTypeBase.getJSONValue((Object)pSHelpSectionTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpSectionTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpSectionTypeBase pSHelpSectionTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpSectionTypeBase.getCreateDate() != null) {
            object = pSHelpSectionTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionTypeBase.getCreateMan() != null) {
            object = pSHelpSectionTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getMemo() != null) {
            object = pSHelpSectionTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getOutputDir() != null) {
            object = pSHelpSectionTypeBase.getOutputDir();
            xmlNode.setAttribute(FIELD_OUTPUTDIR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplId() != null) {
            object = pSHelpSectionTypeBase.getPSHelpSectionTemplId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplName() != null) {
            object = pSHelpSectionTypeBase.getPSHelpSectionTemplName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeId() != null) {
            object = pSHelpSectionTypeBase.getPSHelpSectionTypeId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeName() != null) {
            object = pSHelpSectionTypeBase.getPSHelpSectionTypeName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getPubObj() != null) {
            object = pSHelpSectionTypeBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getSectionObj() != null) {
            object = pSHelpSectionTypeBase.getSectionObj();
            xmlNode.setAttribute(FIELD_SECTIONOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getTypeObj() != null) {
            object = pSHelpSectionTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getUpdateDate() != null) {
            object = pSHelpSectionTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionTypeBase.getUpdateMan() != null) {
            object = pSHelpSectionTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionTypeBase.getValidFlag() != null) {
            object = pSHelpSectionTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpSectionTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpSectionTypeBase pSHelpSectionTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpSectionTypeBase.isCreateDateDirty() && (bl || pSHelpSectionTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpSectionTypeBase.getCreateDate());
        }
        if (pSHelpSectionTypeBase.isCreateManDirty() && (bl || pSHelpSectionTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpSectionTypeBase.getCreateMan());
        }
        if (pSHelpSectionTypeBase.isMemoDirty() && (bl || pSHelpSectionTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpSectionTypeBase.getMemo());
        }
        if (pSHelpSectionTypeBase.isOutputDirDirty() && (bl || pSHelpSectionTypeBase.getOutputDir() != null)) {
            iDataObject.set(FIELD_OUTPUTDIR, (Object)pSHelpSectionTypeBase.getOutputDir());
        }
        if (pSHelpSectionTypeBase.isPSHelpSectionTemplIdDirty() && (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLID, (Object)pSHelpSectionTypeBase.getPSHelpSectionTemplId());
        }
        if (pSHelpSectionTypeBase.isPSHelpSectionTemplNameDirty() && (bl || pSHelpSectionTypeBase.getPSHelpSectionTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLNAME, (Object)pSHelpSectionTypeBase.getPSHelpSectionTemplName());
        }
        if (pSHelpSectionTypeBase.isPSHelpSectionTypeIdDirty() && (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPEID, (Object)pSHelpSectionTypeBase.getPSHelpSectionTypeId());
        }
        if (pSHelpSectionTypeBase.isPSHelpSectionTypeNameDirty() && (bl || pSHelpSectionTypeBase.getPSHelpSectionTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTYPENAME, (Object)pSHelpSectionTypeBase.getPSHelpSectionTypeName());
        }
        if (pSHelpSectionTypeBase.isPubObjDirty() && (bl || pSHelpSectionTypeBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpSectionTypeBase.getPubObj());
        }
        if (pSHelpSectionTypeBase.isSectionObjDirty() && (bl || pSHelpSectionTypeBase.getSectionObj() != null)) {
            iDataObject.set(FIELD_SECTIONOBJ, (Object)pSHelpSectionTypeBase.getSectionObj());
        }
        if (pSHelpSectionTypeBase.isTypeObjDirty() && (bl || pSHelpSectionTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSHelpSectionTypeBase.getTypeObj());
        }
        if (pSHelpSectionTypeBase.isUpdateDateDirty() && (bl || pSHelpSectionTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpSectionTypeBase.getUpdateDate());
        }
        if (pSHelpSectionTypeBase.isUpdateManDirty() && (bl || pSHelpSectionTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpSectionTypeBase.getUpdateMan());
        }
        if (pSHelpSectionTypeBase.isValidFlagDirty() && (bl || pSHelpSectionTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpSectionTypeBase.getValidFlag());
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
        return PSHelpSectionTypeBase.remove(this, n);
    }

    private static boolean remove(PSHelpSectionTypeBase pSHelpSectionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpSectionTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpSectionTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSHelpSectionTypeBase.resetOutputDir();
                return true;
            }
            case 4: {
                pSHelpSectionTypeBase.resetPSHelpSectionTemplId();
                return true;
            }
            case 5: {
                pSHelpSectionTypeBase.resetPSHelpSectionTemplName();
                return true;
            }
            case 6: {
                pSHelpSectionTypeBase.resetPSHelpSectionTypeId();
                return true;
            }
            case 7: {
                pSHelpSectionTypeBase.resetPSHelpSectionTypeName();
                return true;
            }
            case 8: {
                pSHelpSectionTypeBase.resetPubObj();
                return true;
            }
            case 9: {
                pSHelpSectionTypeBase.resetSectionObj();
                return true;
            }
            case 10: {
                pSHelpSectionTypeBase.resetTypeObj();
                return true;
            }
            case 11: {
                pSHelpSectionTypeBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSHelpSectionTypeBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSHelpSectionTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpSectionTempl getPSHelpSectionTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTempl();
        }
        if (this.getPSHelpSectionTemplId() == null) {
            return null;
        }
        Integer n = this.objPSHelpSectionTemplLock;
        synchronized (n) {
            if (this.pshelpsectiontempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpSectionTemplId(), (Object)this.pshelpsectiontempl.getPSHelpSectionTemplId()) != 0L) {
                this.pshelpsectiontempl = null;
            }
            if (this.pshelpsectiontempl == null) {
                PSHelpSectionTempl pSHelpSectionTempl = new PSHelpSectionTempl();
                pSHelpSectionTempl.setPSHelpSectionTemplId(this.getPSHelpSectionTemplId());
                PSHelpSectionTemplService pSHelpSectionTemplService = (PSHelpSectionTemplService)ServiceGlobal.getService(PSHelpSectionTemplService.class, (SessionFactory)this.getSessionFactory());
                pSHelpSectionTemplService.autoGet((IEntity)pSHelpSectionTempl);
                this.pshelpsectiontempl = pSHelpSectionTempl;
            }
            return this.pshelpsectiontempl;
        }
    }

    private PSHelpSectionTypeBase getProxyEntity() {
        return this.proxyPSHelpSectionTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpSectionTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpSectionTypeBase) {
            this.proxyPSHelpSectionTypeBase = (PSHelpSectionTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_OUTPUTDIR, 3);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPEID, 6);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTYPENAME, 7);
        fieldIndexMap.put(FIELD_PUBOBJ, 8);
        fieldIndexMap.put(FIELD_SECTIONOBJ, 9);
        fieldIndexMap.put(FIELD_TYPEOBJ, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

