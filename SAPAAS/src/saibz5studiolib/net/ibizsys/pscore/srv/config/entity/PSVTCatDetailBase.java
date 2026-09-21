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
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import net.ibizsys.pscore.srv.config.service.PSViewTypeCatService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTCatDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVTCatDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSVIEWTYPECATID = "PSVIEWTYPECATID";
    public static final String FIELD_PSVIEWTYPECATNAME = "PSVIEWTYPECATNAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PSVTCATDETAILID = "PSVTCATDETAILID";
    public static final String FIELD_PSVTCATDETAILNAME = "PSVTCATDETAILNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSVIEWTYPECATID = 2;
    private static final int INDEX_PSVIEWTYPECATNAME = 3;
    private static final int INDEX_PSVIEWTYPEID = 4;
    private static final int INDEX_PSVIEWTYPENAME = 5;
    private static final int INDEX_PSVTCATDETAILID = 6;
    private static final int INDEX_PSVTCATDETAILNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVTCatDetailBase proxyPSVTCatDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psviewtypecatidDirtyFlag = false;
    private boolean psviewtypecatnameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean psvtcatdetailidDirtyFlag = false;
    private boolean psvtcatdetailnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psviewtypecatid")
    private String psviewtypecatid;
    @Column(name="psviewtypecatname")
    private String psviewtypecatname;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="psvtcatdetailid")
    private String psvtcatdetailid;
    @Column(name="psvtcatdetailname")
    private String psvtcatdetailname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSViewTypeCatLock = new Integer(1);
    private PSViewTypeCat psviewtypecat = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setPSViewTypeCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypecatid = string;
        this.psviewtypecatidDirtyFlag = true;
    }

    public String getPSViewTypeCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeCatId();
        }
        return this.psviewtypecatid;
    }

    public boolean isPSViewTypeCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeCatIdDirty();
        }
        return this.psviewtypecatidDirtyFlag;
    }

    public void resetPSViewTypeCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeCatId();
            return;
        }
        this.psviewtypecatidDirtyFlag = false;
        this.psviewtypecatid = null;
    }

    public void setPSViewTypeCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypecatname = string;
        this.psviewtypecatnameDirtyFlag = true;
    }

    public String getPSViewTypeCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeCatName();
        }
        return this.psviewtypecatname;
    }

    public boolean isPSViewTypeCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeCatNameDirty();
        }
        return this.psviewtypecatnameDirtyFlag;
    }

    public void resetPSViewTypeCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeCatName();
            return;
        }
        this.psviewtypecatnameDirtyFlag = false;
        this.psviewtypecatname = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setPSVTCatDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTCatDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtcatdetailid = string;
        this.psvtcatdetailidDirtyFlag = true;
    }

    public String getPSVTCatDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTCatDetailId();
        }
        return this.psvtcatdetailid;
    }

    public boolean isPSVTCatDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTCatDetailIdDirty();
        }
        return this.psvtcatdetailidDirtyFlag;
    }

    public void resetPSVTCatDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTCatDetailId();
            return;
        }
        this.psvtcatdetailidDirtyFlag = false;
        this.psvtcatdetailid = null;
    }

    public void setPSVTCatDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTCatDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtcatdetailname = string;
        this.psvtcatdetailnameDirtyFlag = true;
    }

    public String getPSVTCatDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTCatDetailName();
        }
        return this.psvtcatdetailname;
    }

    public boolean isPSVTCatDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTCatDetailNameDirty();
        }
        return this.psvtcatdetailnameDirtyFlag;
    }

    public void resetPSVTCatDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTCatDetailName();
            return;
        }
        this.psvtcatdetailnameDirtyFlag = false;
        this.psvtcatdetailname = null;
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
        PSVTCatDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVTCatDetailBase pSVTCatDetailBase) {
        pSVTCatDetailBase.resetCreateDate();
        pSVTCatDetailBase.resetCreateMan();
        pSVTCatDetailBase.resetPSViewTypeCatId();
        pSVTCatDetailBase.resetPSViewTypeCatName();
        pSVTCatDetailBase.resetPSViewTypeId();
        pSVTCatDetailBase.resetPSViewTypeName();
        pSVTCatDetailBase.resetPSVTCatDetailId();
        pSVTCatDetailBase.resetPSVTCatDetailName();
        pSVTCatDetailBase.resetUpdateDate();
        pSVTCatDetailBase.resetUpdateMan();
        pSVTCatDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSViewTypeCatIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPECATID, this.getPSViewTypeCatId());
        }
        if (!bl || this.isPSViewTypeCatNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPECATNAME, this.getPSViewTypeCatName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPSVTCatDetailIdDirty()) {
            hashMap.put(FIELD_PSVTCATDETAILID, this.getPSVTCatDetailId());
        }
        if (!bl || this.isPSVTCatDetailNameDirty()) {
            hashMap.put(FIELD_PSVTCATDETAILNAME, this.getPSVTCatDetailName());
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
        return PSVTCatDetailBase.get(this, n);
    }

    private static Object get(PSVTCatDetailBase pSVTCatDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCatDetailBase.getCreateDate();
            }
            case 1: {
                return pSVTCatDetailBase.getCreateMan();
            }
            case 2: {
                return pSVTCatDetailBase.getPSViewTypeCatId();
            }
            case 3: {
                return pSVTCatDetailBase.getPSViewTypeCatName();
            }
            case 4: {
                return pSVTCatDetailBase.getPSViewTypeId();
            }
            case 5: {
                return pSVTCatDetailBase.getPSViewTypeName();
            }
            case 6: {
                return pSVTCatDetailBase.getPSVTCatDetailId();
            }
            case 7: {
                return pSVTCatDetailBase.getPSVTCatDetailName();
            }
            case 8: {
                return pSVTCatDetailBase.getUpdateDate();
            }
            case 9: {
                return pSVTCatDetailBase.getUpdateMan();
            }
            case 10: {
                return pSVTCatDetailBase.getValidFlag();
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
        PSVTCatDetailBase.set(this, n, object);
    }

    private static void set(PSVTCatDetailBase pSVTCatDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVTCatDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVTCatDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVTCatDetailBase.setPSViewTypeCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVTCatDetailBase.setPSViewTypeCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVTCatDetailBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSVTCatDetailBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSVTCatDetailBase.setPSVTCatDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVTCatDetailBase.setPSVTCatDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVTCatDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSVTCatDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSVTCatDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSVTCatDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSVTCatDetailBase pSVTCatDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCatDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSVTCatDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSVTCatDetailBase.getPSViewTypeCatId() == null;
            }
            case 3: {
                return pSVTCatDetailBase.getPSViewTypeCatName() == null;
            }
            case 4: {
                return pSVTCatDetailBase.getPSViewTypeId() == null;
            }
            case 5: {
                return pSVTCatDetailBase.getPSViewTypeName() == null;
            }
            case 6: {
                return pSVTCatDetailBase.getPSVTCatDetailId() == null;
            }
            case 7: {
                return pSVTCatDetailBase.getPSVTCatDetailName() == null;
            }
            case 8: {
                return pSVTCatDetailBase.getUpdateDate() == null;
            }
            case 9: {
                return pSVTCatDetailBase.getUpdateMan() == null;
            }
            case 10: {
                return pSVTCatDetailBase.getValidFlag() == null;
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
        return PSVTCatDetailBase.contains(this, n);
    }

    private static boolean contains(PSVTCatDetailBase pSVTCatDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCatDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSVTCatDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSVTCatDetailBase.isPSViewTypeCatIdDirty();
            }
            case 3: {
                return pSVTCatDetailBase.isPSViewTypeCatNameDirty();
            }
            case 4: {
                return pSVTCatDetailBase.isPSViewTypeIdDirty();
            }
            case 5: {
                return pSVTCatDetailBase.isPSViewTypeNameDirty();
            }
            case 6: {
                return pSVTCatDetailBase.isPSVTCatDetailIdDirty();
            }
            case 7: {
                return pSVTCatDetailBase.isPSVTCatDetailNameDirty();
            }
            case 8: {
                return pSVTCatDetailBase.isUpdateDateDirty();
            }
            case 9: {
                return pSVTCatDetailBase.isUpdateManDirty();
            }
            case 10: {
                return pSVTCatDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVTCatDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVTCatDetailBase pSVTCatDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVTCatDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypecatid", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSViewTypeCatId()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypecatname", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSViewTypeCatName()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSVTCatDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtcatdetailid", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSVTCatDetailId()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getPSVTCatDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtcatdetailname", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getPSVTCatDetailName()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVTCatDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVTCatDetailBase.getJSONValue((Object)pSVTCatDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVTCatDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVTCatDetailBase pSVTCatDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVTCatDetailBase.getCreateDate() != null) {
            object = pSVTCatDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTCatDetailBase.getCreateMan() != null) {
            object = pSVTCatDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeCatId() != null) {
            object = pSVTCatDetailBase.getPSViewTypeCatId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPECATID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeCatName() != null) {
            object = pSVTCatDetailBase.getPSViewTypeCatName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeId() != null) {
            object = pSVTCatDetailBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSViewTypeName() != null) {
            object = pSVTCatDetailBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSVTCatDetailId() != null) {
            object = pSVTCatDetailBase.getPSVTCatDetailId();
            xmlNode.setAttribute(FIELD_PSVTCATDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getPSVTCatDetailName() != null) {
            object = pSVTCatDetailBase.getPSVTCatDetailName();
            xmlNode.setAttribute(FIELD_PSVTCATDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getUpdateDate() != null) {
            object = pSVTCatDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTCatDetailBase.getUpdateMan() != null) {
            object = pSVTCatDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTCatDetailBase.getValidFlag() != null) {
            object = pSVTCatDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVTCatDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVTCatDetailBase pSVTCatDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVTCatDetailBase.isCreateDateDirty() && (bl || pSVTCatDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVTCatDetailBase.getCreateDate());
        }
        if (pSVTCatDetailBase.isCreateManDirty() && (bl || pSVTCatDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVTCatDetailBase.getCreateMan());
        }
        if (pSVTCatDetailBase.isPSViewTypeCatIdDirty() && (bl || pSVTCatDetailBase.getPSViewTypeCatId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPECATID, (Object)pSVTCatDetailBase.getPSViewTypeCatId());
        }
        if (pSVTCatDetailBase.isPSViewTypeCatNameDirty() && (bl || pSVTCatDetailBase.getPSViewTypeCatName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPECATNAME, (Object)pSVTCatDetailBase.getPSViewTypeCatName());
        }
        if (pSVTCatDetailBase.isPSViewTypeIdDirty() && (bl || pSVTCatDetailBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSVTCatDetailBase.getPSViewTypeId());
        }
        if (pSVTCatDetailBase.isPSViewTypeNameDirty() && (bl || pSVTCatDetailBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSVTCatDetailBase.getPSViewTypeName());
        }
        if (pSVTCatDetailBase.isPSVTCatDetailIdDirty() && (bl || pSVTCatDetailBase.getPSVTCatDetailId() != null)) {
            iDataObject.set(FIELD_PSVTCATDETAILID, (Object)pSVTCatDetailBase.getPSVTCatDetailId());
        }
        if (pSVTCatDetailBase.isPSVTCatDetailNameDirty() && (bl || pSVTCatDetailBase.getPSVTCatDetailName() != null)) {
            iDataObject.set(FIELD_PSVTCATDETAILNAME, (Object)pSVTCatDetailBase.getPSVTCatDetailName());
        }
        if (pSVTCatDetailBase.isUpdateDateDirty() && (bl || pSVTCatDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVTCatDetailBase.getUpdateDate());
        }
        if (pSVTCatDetailBase.isUpdateManDirty() && (bl || pSVTCatDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVTCatDetailBase.getUpdateMan());
        }
        if (pSVTCatDetailBase.isValidFlagDirty() && (bl || pSVTCatDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVTCatDetailBase.getValidFlag());
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
        return PSVTCatDetailBase.remove(this, n);
    }

    private static boolean remove(PSVTCatDetailBase pSVTCatDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVTCatDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVTCatDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVTCatDetailBase.resetPSViewTypeCatId();
                return true;
            }
            case 3: {
                pSVTCatDetailBase.resetPSViewTypeCatName();
                return true;
            }
            case 4: {
                pSVTCatDetailBase.resetPSViewTypeId();
                return true;
            }
            case 5: {
                pSVTCatDetailBase.resetPSViewTypeName();
                return true;
            }
            case 6: {
                pSVTCatDetailBase.resetPSVTCatDetailId();
                return true;
            }
            case 7: {
                pSVTCatDetailBase.resetPSVTCatDetailName();
                return true;
            }
            case 8: {
                pSVTCatDetailBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSVTCatDetailBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSVTCatDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewTypeCat getPSViewTypeCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeCat();
        }
        if (this.getPSViewTypeCatId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeCatLock;
        synchronized (n) {
            if (this.psviewtypecat != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeCatId(), (Object)this.psviewtypecat.getPSViewTypeCatId()) != 0L) {
                this.psviewtypecat = null;
            }
            if (this.psviewtypecat == null) {
                PSViewTypeCat pSViewTypeCat = new PSViewTypeCat();
                pSViewTypeCat.setPSViewTypeCatId(this.getPSViewTypeCatId());
                PSViewTypeCatService pSViewTypeCatService = (PSViewTypeCatService)ServiceGlobal.getService(PSViewTypeCatService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeCatService.autoGet((IEntity)pSViewTypeCat);
                this.psviewtypecat = pSViewTypeCat;
            }
            return this.psviewtypecat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet((IEntity)pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSVTCatDetailBase getProxyEntity() {
        return this.proxyPSVTCatDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVTCatDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSVTCatDetailBase) {
            this.proxyPSVTCatDetailBase = (PSVTCatDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTCatDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSVIEWTYPECATID, 2);
        fieldIndexMap.put(FIELD_PSVIEWTYPECATNAME, 3);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 4);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSVTCATDETAILID, 6);
        fieldIndexMap.put(FIELD_PSVTCATDETAILNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

