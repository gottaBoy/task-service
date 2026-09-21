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

public abstract class PSDELLCondTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELLCondTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_ITEMOBJ2 = "ITEMOBJ2";
    public static final String FIELD_ITEMOBJ3 = "ITEMOBJ3";
    public static final String FIELD_ITEMOBJ4 = "ITEMOBJ4";
    public static final String FIELD_ITEMOBJ5 = "ITEMOBJ5";
    public static final String FIELD_ITEMOBJ6 = "ITEMOBJ6";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDELLCONDTYPEID = "PSDELLCONDTYPEID";
    public static final String FIELD_PSDELLCONDTYPENAME = "PSDELLCONDTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_ITEMOBJ2 = 3;
    private static final int INDEX_ITEMOBJ3 = 4;
    private static final int INDEX_ITEMOBJ4 = 5;
    private static final int INDEX_ITEMOBJ5 = 6;
    private static final int INDEX_ITEMOBJ6 = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSDELLCONDTYPEID = 9;
    private static final int INDEX_PSDELLCONDTYPENAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELLCondTypeBase proxyPSDELLCondTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean itemobj2DirtyFlag = false;
    private boolean itemobj3DirtyFlag = false;
    private boolean itemobj4DirtyFlag = false;
    private boolean itemobj5DirtyFlag = false;
    private boolean itemobj6DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdellcondtypeidDirtyFlag = false;
    private boolean psdellcondtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="itemobj2")
    private String itemobj2;
    @Column(name="itemobj3")
    private String itemobj3;
    @Column(name="itemobj4")
    private String itemobj4;
    @Column(name="itemobj5")
    private String itemobj5;
    @Column(name="itemobj6")
    private String itemobj6;
    @Column(name="memo")
    private String memo;
    @Column(name="psdellcondtypeid")
    private String psdellcondtypeid;
    @Column(name="psdellcondtypename")
    private String psdellcondtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
    }

    public void setItemObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj2 = string;
        this.itemobj2DirtyFlag = true;
    }

    public String getItemObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj2();
        }
        return this.itemobj2;
    }

    public boolean isItemObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj2Dirty();
        }
        return this.itemobj2DirtyFlag;
    }

    public void resetItemObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj2();
            return;
        }
        this.itemobj2DirtyFlag = false;
        this.itemobj2 = null;
    }

    public void setItemObj3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj3 = string;
        this.itemobj3DirtyFlag = true;
    }

    public String getItemObj3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj3();
        }
        return this.itemobj3;
    }

    public boolean isItemObj3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj3Dirty();
        }
        return this.itemobj3DirtyFlag;
    }

    public void resetItemObj3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj3();
            return;
        }
        this.itemobj3DirtyFlag = false;
        this.itemobj3 = null;
    }

    public void setItemObj4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj4 = string;
        this.itemobj4DirtyFlag = true;
    }

    public String getItemObj4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj4();
        }
        return this.itemobj4;
    }

    public boolean isItemObj4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj4Dirty();
        }
        return this.itemobj4DirtyFlag;
    }

    public void resetItemObj4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj4();
            return;
        }
        this.itemobj4DirtyFlag = false;
        this.itemobj4 = null;
    }

    public void setItemObj5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj5 = string;
        this.itemobj5DirtyFlag = true;
    }

    public String getItemObj5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj5();
        }
        return this.itemobj5;
    }

    public boolean isItemObj5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj5Dirty();
        }
        return this.itemobj5DirtyFlag;
    }

    public void resetItemObj5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj5();
            return;
        }
        this.itemobj5DirtyFlag = false;
        this.itemobj5 = null;
    }

    public void setItemObj6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj6 = string;
        this.itemobj6DirtyFlag = true;
    }

    public String getItemObj6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj6();
        }
        return this.itemobj6;
    }

    public boolean isItemObj6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj6Dirty();
        }
        return this.itemobj6DirtyFlag;
    }

    public void resetItemObj6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj6();
            return;
        }
        this.itemobj6DirtyFlag = false;
        this.itemobj6 = null;
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

    public void setPSDELLCondTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLCondTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdellcondtypeid = string;
        this.psdellcondtypeidDirtyFlag = true;
    }

    public String getPSDELLCondTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLCondTypeId();
        }
        return this.psdellcondtypeid;
    }

    public boolean isPSDELLCondTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLCondTypeIdDirty();
        }
        return this.psdellcondtypeidDirtyFlag;
    }

    public void resetPSDELLCondTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLCondTypeId();
            return;
        }
        this.psdellcondtypeidDirtyFlag = false;
        this.psdellcondtypeid = null;
    }

    public void setPSDELLCondTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLCondTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdellcondtypename = string;
        this.psdellcondtypenameDirtyFlag = true;
    }

    public String getPSDELLCondTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLCondTypeName();
        }
        return this.psdellcondtypename;
    }

    public boolean isPSDELLCondTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLCondTypeNameDirty();
        }
        return this.psdellcondtypenameDirtyFlag;
    }

    public void resetPSDELLCondTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLCondTypeName();
            return;
        }
        this.psdellcondtypenameDirtyFlag = false;
        this.psdellcondtypename = null;
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
        PSDELLCondTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELLCondTypeBase pSDELLCondTypeBase) {
        pSDELLCondTypeBase.resetCreateDate();
        pSDELLCondTypeBase.resetCreateMan();
        pSDELLCondTypeBase.resetItemObj();
        pSDELLCondTypeBase.resetItemObj2();
        pSDELLCondTypeBase.resetItemObj3();
        pSDELLCondTypeBase.resetItemObj4();
        pSDELLCondTypeBase.resetItemObj5();
        pSDELLCondTypeBase.resetItemObj6();
        pSDELLCondTypeBase.resetMemo();
        pSDELLCondTypeBase.resetPSDELLCondTypeId();
        pSDELLCondTypeBase.resetPSDELLCondTypeName();
        pSDELLCondTypeBase.resetUpdateDate();
        pSDELLCondTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isItemObj2Dirty()) {
            hashMap.put(FIELD_ITEMOBJ2, this.getItemObj2());
        }
        if (!bl || this.isItemObj3Dirty()) {
            hashMap.put(FIELD_ITEMOBJ3, this.getItemObj3());
        }
        if (!bl || this.isItemObj4Dirty()) {
            hashMap.put(FIELD_ITEMOBJ4, this.getItemObj4());
        }
        if (!bl || this.isItemObj5Dirty()) {
            hashMap.put(FIELD_ITEMOBJ5, this.getItemObj5());
        }
        if (!bl || this.isItemObj6Dirty()) {
            hashMap.put(FIELD_ITEMOBJ6, this.getItemObj6());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDELLCondTypeIdDirty()) {
            hashMap.put(FIELD_PSDELLCONDTYPEID, this.getPSDELLCondTypeId());
        }
        if (!bl || this.isPSDELLCondTypeNameDirty()) {
            hashMap.put(FIELD_PSDELLCONDTYPENAME, this.getPSDELLCondTypeName());
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
        return PSDELLCondTypeBase.get(this, n);
    }

    private static Object get(PSDELLCondTypeBase pSDELLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondTypeBase.getCreateDate();
            }
            case 1: {
                return pSDELLCondTypeBase.getCreateMan();
            }
            case 2: {
                return pSDELLCondTypeBase.getItemObj();
            }
            case 3: {
                return pSDELLCondTypeBase.getItemObj2();
            }
            case 4: {
                return pSDELLCondTypeBase.getItemObj3();
            }
            case 5: {
                return pSDELLCondTypeBase.getItemObj4();
            }
            case 6: {
                return pSDELLCondTypeBase.getItemObj5();
            }
            case 7: {
                return pSDELLCondTypeBase.getItemObj6();
            }
            case 8: {
                return pSDELLCondTypeBase.getMemo();
            }
            case 9: {
                return pSDELLCondTypeBase.getPSDELLCondTypeId();
            }
            case 10: {
                return pSDELLCondTypeBase.getPSDELLCondTypeName();
            }
            case 11: {
                return pSDELLCondTypeBase.getUpdateDate();
            }
            case 12: {
                return pSDELLCondTypeBase.getUpdateMan();
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
        PSDELLCondTypeBase.set(this, n, object);
    }

    private static void set(PSDELLCondTypeBase pSDELLCondTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELLCondTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDELLCondTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDELLCondTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELLCondTypeBase.setItemObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELLCondTypeBase.setItemObj3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELLCondTypeBase.setItemObj4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELLCondTypeBase.setItemObj5(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELLCondTypeBase.setItemObj6(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELLCondTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELLCondTypeBase.setPSDELLCondTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELLCondTypeBase.setPSDELLCondTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELLCondTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDELLCondTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDELLCondTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDELLCondTypeBase pSDELLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDELLCondTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDELLCondTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSDELLCondTypeBase.getItemObj2() == null;
            }
            case 4: {
                return pSDELLCondTypeBase.getItemObj3() == null;
            }
            case 5: {
                return pSDELLCondTypeBase.getItemObj4() == null;
            }
            case 6: {
                return pSDELLCondTypeBase.getItemObj5() == null;
            }
            case 7: {
                return pSDELLCondTypeBase.getItemObj6() == null;
            }
            case 8: {
                return pSDELLCondTypeBase.getMemo() == null;
            }
            case 9: {
                return pSDELLCondTypeBase.getPSDELLCondTypeId() == null;
            }
            case 10: {
                return pSDELLCondTypeBase.getPSDELLCondTypeName() == null;
            }
            case 11: {
                return pSDELLCondTypeBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDELLCondTypeBase.getUpdateMan() == null;
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
        return PSDELLCondTypeBase.contains(this, n);
    }

    private static boolean contains(PSDELLCondTypeBase pSDELLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDELLCondTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDELLCondTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSDELLCondTypeBase.isItemObj2Dirty();
            }
            case 4: {
                return pSDELLCondTypeBase.isItemObj3Dirty();
            }
            case 5: {
                return pSDELLCondTypeBase.isItemObj4Dirty();
            }
            case 6: {
                return pSDELLCondTypeBase.isItemObj5Dirty();
            }
            case 7: {
                return pSDELLCondTypeBase.isItemObj6Dirty();
            }
            case 8: {
                return pSDELLCondTypeBase.isMemoDirty();
            }
            case 9: {
                return pSDELLCondTypeBase.isPSDELLCondTypeIdDirty();
            }
            case 10: {
                return pSDELLCondTypeBase.isPSDELLCondTypeNameDirty();
            }
            case 11: {
                return pSDELLCondTypeBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDELLCondTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELLCondTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELLCondTypeBase pSDELLCondTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELLCondTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj2", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj2()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj3", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj3()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj4", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj4()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj5", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj5()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getItemObj6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj6", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getItemObj6()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getPSDELLCondTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdellcondtypeid", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getPSDELLCondTypeId()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getPSDELLCondTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdellcondtypename", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getPSDELLCondTypeName()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELLCondTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELLCondTypeBase.getJSONValue((Object)pSDELLCondTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELLCondTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELLCondTypeBase pSDELLCondTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELLCondTypeBase.getCreateDate() != null) {
            object = pSDELLCondTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLCondTypeBase.getCreateMan() != null) {
            object = pSDELLCondTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj() != null) {
            object = pSDELLCondTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj2() != null) {
            object = pSDELLCondTypeBase.getItemObj2();
            xmlNode.setAttribute(FIELD_ITEMOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj3() != null) {
            object = pSDELLCondTypeBase.getItemObj3();
            xmlNode.setAttribute(FIELD_ITEMOBJ3, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj4() != null) {
            object = pSDELLCondTypeBase.getItemObj4();
            xmlNode.setAttribute(FIELD_ITEMOBJ4, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj5() != null) {
            object = pSDELLCondTypeBase.getItemObj5();
            xmlNode.setAttribute(FIELD_ITEMOBJ5, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getItemObj6() != null) {
            object = pSDELLCondTypeBase.getItemObj6();
            xmlNode.setAttribute(FIELD_ITEMOBJ6, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getMemo() != null) {
            object = pSDELLCondTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getPSDELLCondTypeId() != null) {
            object = pSDELLCondTypeBase.getPSDELLCondTypeId();
            xmlNode.setAttribute(FIELD_PSDELLCONDTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getPSDELLCondTypeName() != null) {
            object = pSDELLCondTypeBase.getPSDELLCondTypeName();
            xmlNode.setAttribute(FIELD_PSDELLCONDTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondTypeBase.getUpdateDate() != null) {
            object = pSDELLCondTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLCondTypeBase.getUpdateMan() != null) {
            object = pSDELLCondTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELLCondTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELLCondTypeBase pSDELLCondTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELLCondTypeBase.isCreateDateDirty() && (bl || pSDELLCondTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELLCondTypeBase.getCreateDate());
        }
        if (pSDELLCondTypeBase.isCreateManDirty() && (bl || pSDELLCondTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELLCondTypeBase.getCreateMan());
        }
        if (pSDELLCondTypeBase.isItemObjDirty() && (bl || pSDELLCondTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSDELLCondTypeBase.getItemObj());
        }
        if (pSDELLCondTypeBase.isItemObj2Dirty() && (bl || pSDELLCondTypeBase.getItemObj2() != null)) {
            iDataObject.set(FIELD_ITEMOBJ2, (Object)pSDELLCondTypeBase.getItemObj2());
        }
        if (pSDELLCondTypeBase.isItemObj3Dirty() && (bl || pSDELLCondTypeBase.getItemObj3() != null)) {
            iDataObject.set(FIELD_ITEMOBJ3, (Object)pSDELLCondTypeBase.getItemObj3());
        }
        if (pSDELLCondTypeBase.isItemObj4Dirty() && (bl || pSDELLCondTypeBase.getItemObj4() != null)) {
            iDataObject.set(FIELD_ITEMOBJ4, (Object)pSDELLCondTypeBase.getItemObj4());
        }
        if (pSDELLCondTypeBase.isItemObj5Dirty() && (bl || pSDELLCondTypeBase.getItemObj5() != null)) {
            iDataObject.set(FIELD_ITEMOBJ5, (Object)pSDELLCondTypeBase.getItemObj5());
        }
        if (pSDELLCondTypeBase.isItemObj6Dirty() && (bl || pSDELLCondTypeBase.getItemObj6() != null)) {
            iDataObject.set(FIELD_ITEMOBJ6, (Object)pSDELLCondTypeBase.getItemObj6());
        }
        if (pSDELLCondTypeBase.isMemoDirty() && (bl || pSDELLCondTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELLCondTypeBase.getMemo());
        }
        if (pSDELLCondTypeBase.isPSDELLCondTypeIdDirty() && (bl || pSDELLCondTypeBase.getPSDELLCondTypeId() != null)) {
            iDataObject.set(FIELD_PSDELLCONDTYPEID, (Object)pSDELLCondTypeBase.getPSDELLCondTypeId());
        }
        if (pSDELLCondTypeBase.isPSDELLCondTypeNameDirty() && (bl || pSDELLCondTypeBase.getPSDELLCondTypeName() != null)) {
            iDataObject.set(FIELD_PSDELLCONDTYPENAME, (Object)pSDELLCondTypeBase.getPSDELLCondTypeName());
        }
        if (pSDELLCondTypeBase.isUpdateDateDirty() && (bl || pSDELLCondTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELLCondTypeBase.getUpdateDate());
        }
        if (pSDELLCondTypeBase.isUpdateManDirty() && (bl || pSDELLCondTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELLCondTypeBase.getUpdateMan());
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
        return PSDELLCondTypeBase.remove(this, n);
    }

    private static boolean remove(PSDELLCondTypeBase pSDELLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELLCondTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDELLCondTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDELLCondTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSDELLCondTypeBase.resetItemObj2();
                return true;
            }
            case 4: {
                pSDELLCondTypeBase.resetItemObj3();
                return true;
            }
            case 5: {
                pSDELLCondTypeBase.resetItemObj4();
                return true;
            }
            case 6: {
                pSDELLCondTypeBase.resetItemObj5();
                return true;
            }
            case 7: {
                pSDELLCondTypeBase.resetItemObj6();
                return true;
            }
            case 8: {
                pSDELLCondTypeBase.resetMemo();
                return true;
            }
            case 9: {
                pSDELLCondTypeBase.resetPSDELLCondTypeId();
                return true;
            }
            case 10: {
                pSDELLCondTypeBase.resetPSDELLCondTypeName();
                return true;
            }
            case 11: {
                pSDELLCondTypeBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDELLCondTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDELLCondTypeBase getProxyEntity() {
        return this.proxyPSDELLCondTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELLCondTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELLCondTypeBase) {
            this.proxyPSDELLCondTypeBase = (PSDELLCondTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDELLCondTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_ITEMOBJ2, 3);
        fieldIndexMap.put(FIELD_ITEMOBJ3, 4);
        fieldIndexMap.put(FIELD_ITEMOBJ4, 5);
        fieldIndexMap.put(FIELD_ITEMOBJ5, 6);
        fieldIndexMap.put(FIELD_ITEMOBJ6, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSDELLCONDTYPEID, 9);
        fieldIndexMap.put(FIELD_PSDELLCONDTYPENAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

