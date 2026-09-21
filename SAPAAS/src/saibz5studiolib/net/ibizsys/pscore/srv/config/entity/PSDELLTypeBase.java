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

public abstract class PSDELLTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELLTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_ITEMOBJ2 = "ITEMOBJ2";
    public static final String FIELD_ITEMOBJ3 = "ITEMOBJ3";
    public static final String FIELD_ITEMOBJ4 = "ITEMOBJ4";
    public static final String FIELD_ITEMOBJ5 = "ITEMOBJ5";
    public static final String FIELD_ITEMOBJ6 = "ITEMOBJ6";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDELLTYPEID = "PSDELLTYPEID";
    public static final String FIELD_PSDELLTYPENAME = "PSDELLTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_ITEMOBJ = 3;
    private static final int INDEX_ITEMOBJ2 = 4;
    private static final int INDEX_ITEMOBJ3 = 5;
    private static final int INDEX_ITEMOBJ4 = 6;
    private static final int INDEX_ITEMOBJ5 = 7;
    private static final int INDEX_ITEMOBJ6 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSDELLTYPEID = 10;
    private static final int INDEX_PSDELLTYPENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELLTypeBase proxyPSDELLTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean itemobj2DirtyFlag = false;
    private boolean itemobj3DirtyFlag = false;
    private boolean itemobj4DirtyFlag = false;
    private boolean itemobj5DirtyFlag = false;
    private boolean itemobj6DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdelltypeidDirtyFlag = false;
    private boolean psdelltypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
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
    @Column(name="psdelltypeid")
    private String psdelltypeid;
    @Column(name="psdelltypename")
    private String psdelltypename;
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

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
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

    public void setPSDELLTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelltypeid = string;
        this.psdelltypeidDirtyFlag = true;
    }

    public String getPSDELLTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLTypeId();
        }
        return this.psdelltypeid;
    }

    public boolean isPSDELLTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLTypeIdDirty();
        }
        return this.psdelltypeidDirtyFlag;
    }

    public void resetPSDELLTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLTypeId();
            return;
        }
        this.psdelltypeidDirtyFlag = false;
        this.psdelltypeid = null;
    }

    public void setPSDELLTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelltypename = string;
        this.psdelltypenameDirtyFlag = true;
    }

    public String getPSDELLTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLTypeName();
        }
        return this.psdelltypename;
    }

    public boolean isPSDELLTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLTypeNameDirty();
        }
        return this.psdelltypenameDirtyFlag;
    }

    public void resetPSDELLTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLTypeName();
            return;
        }
        this.psdelltypenameDirtyFlag = false;
        this.psdelltypename = null;
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
        PSDELLTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELLTypeBase pSDELLTypeBase) {
        pSDELLTypeBase.resetCreateDate();
        pSDELLTypeBase.resetCreateMan();
        pSDELLTypeBase.resetIconPath();
        pSDELLTypeBase.resetItemObj();
        pSDELLTypeBase.resetItemObj2();
        pSDELLTypeBase.resetItemObj3();
        pSDELLTypeBase.resetItemObj4();
        pSDELLTypeBase.resetItemObj5();
        pSDELLTypeBase.resetItemObj6();
        pSDELLTypeBase.resetMemo();
        pSDELLTypeBase.resetPSDELLTypeId();
        pSDELLTypeBase.resetPSDELLTypeName();
        pSDELLTypeBase.resetUpdateDate();
        pSDELLTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
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
        if (!bl || this.isPSDELLTypeIdDirty()) {
            hashMap.put(FIELD_PSDELLTYPEID, this.getPSDELLTypeId());
        }
        if (!bl || this.isPSDELLTypeNameDirty()) {
            hashMap.put(FIELD_PSDELLTYPENAME, this.getPSDELLTypeName());
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
        return PSDELLTypeBase.get(this, n);
    }

    private static Object get(PSDELLTypeBase pSDELLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLTypeBase.getCreateDate();
            }
            case 1: {
                return pSDELLTypeBase.getCreateMan();
            }
            case 2: {
                return pSDELLTypeBase.getIconPath();
            }
            case 3: {
                return pSDELLTypeBase.getItemObj();
            }
            case 4: {
                return pSDELLTypeBase.getItemObj2();
            }
            case 5: {
                return pSDELLTypeBase.getItemObj3();
            }
            case 6: {
                return pSDELLTypeBase.getItemObj4();
            }
            case 7: {
                return pSDELLTypeBase.getItemObj5();
            }
            case 8: {
                return pSDELLTypeBase.getItemObj6();
            }
            case 9: {
                return pSDELLTypeBase.getMemo();
            }
            case 10: {
                return pSDELLTypeBase.getPSDELLTypeId();
            }
            case 11: {
                return pSDELLTypeBase.getPSDELLTypeName();
            }
            case 12: {
                return pSDELLTypeBase.getUpdateDate();
            }
            case 13: {
                return pSDELLTypeBase.getUpdateMan();
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
        PSDELLTypeBase.set(this, n, object);
    }

    private static void set(PSDELLTypeBase pSDELLTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELLTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDELLTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDELLTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELLTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELLTypeBase.setItemObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELLTypeBase.setItemObj3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELLTypeBase.setItemObj4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELLTypeBase.setItemObj5(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELLTypeBase.setItemObj6(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELLTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELLTypeBase.setPSDELLTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELLTypeBase.setPSDELLTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELLTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDELLTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDELLTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDELLTypeBase pSDELLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDELLTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDELLTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDELLTypeBase.getItemObj() == null;
            }
            case 4: {
                return pSDELLTypeBase.getItemObj2() == null;
            }
            case 5: {
                return pSDELLTypeBase.getItemObj3() == null;
            }
            case 6: {
                return pSDELLTypeBase.getItemObj4() == null;
            }
            case 7: {
                return pSDELLTypeBase.getItemObj5() == null;
            }
            case 8: {
                return pSDELLTypeBase.getItemObj6() == null;
            }
            case 9: {
                return pSDELLTypeBase.getMemo() == null;
            }
            case 10: {
                return pSDELLTypeBase.getPSDELLTypeId() == null;
            }
            case 11: {
                return pSDELLTypeBase.getPSDELLTypeName() == null;
            }
            case 12: {
                return pSDELLTypeBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDELLTypeBase.getUpdateMan() == null;
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
        return PSDELLTypeBase.contains(this, n);
    }

    private static boolean contains(PSDELLTypeBase pSDELLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDELLTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDELLTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDELLTypeBase.isItemObjDirty();
            }
            case 4: {
                return pSDELLTypeBase.isItemObj2Dirty();
            }
            case 5: {
                return pSDELLTypeBase.isItemObj3Dirty();
            }
            case 6: {
                return pSDELLTypeBase.isItemObj4Dirty();
            }
            case 7: {
                return pSDELLTypeBase.isItemObj5Dirty();
            }
            case 8: {
                return pSDELLTypeBase.isItemObj6Dirty();
            }
            case 9: {
                return pSDELLTypeBase.isMemoDirty();
            }
            case 10: {
                return pSDELLTypeBase.isPSDELLTypeIdDirty();
            }
            case 11: {
                return pSDELLTypeBase.isPSDELLTypeNameDirty();
            }
            case 12: {
                return pSDELLTypeBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDELLTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELLTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELLTypeBase pSDELLTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELLTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj2", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj2()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj3", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj3()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj4", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj4()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj5", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj5()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getItemObj6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj6", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getItemObj6()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getPSDELLTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelltypeid", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getPSDELLTypeId()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getPSDELLTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelltypename", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getPSDELLTypeName()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELLTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELLTypeBase.getJSONValue((Object)pSDELLTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELLTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELLTypeBase pSDELLTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELLTypeBase.getCreateDate() != null) {
            object = pSDELLTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLTypeBase.getCreateMan() != null) {
            object = pSDELLTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getIconPath() != null) {
            object = pSDELLTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj() != null) {
            object = pSDELLTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj2() != null) {
            object = pSDELLTypeBase.getItemObj2();
            xmlNode.setAttribute(FIELD_ITEMOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj3() != null) {
            object = pSDELLTypeBase.getItemObj3();
            xmlNode.setAttribute(FIELD_ITEMOBJ3, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj4() != null) {
            object = pSDELLTypeBase.getItemObj4();
            xmlNode.setAttribute(FIELD_ITEMOBJ4, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj5() != null) {
            object = pSDELLTypeBase.getItemObj5();
            xmlNode.setAttribute(FIELD_ITEMOBJ5, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getItemObj6() != null) {
            object = pSDELLTypeBase.getItemObj6();
            xmlNode.setAttribute(FIELD_ITEMOBJ6, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getMemo() != null) {
            object = pSDELLTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getPSDELLTypeId() != null) {
            object = pSDELLTypeBase.getPSDELLTypeId();
            xmlNode.setAttribute(FIELD_PSDELLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getPSDELLTypeName() != null) {
            object = pSDELLTypeBase.getPSDELLTypeName();
            xmlNode.setAttribute(FIELD_PSDELLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLTypeBase.getUpdateDate() != null) {
            object = pSDELLTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLTypeBase.getUpdateMan() != null) {
            object = pSDELLTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELLTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELLTypeBase pSDELLTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELLTypeBase.isCreateDateDirty() && (bl || pSDELLTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELLTypeBase.getCreateDate());
        }
        if (pSDELLTypeBase.isCreateManDirty() && (bl || pSDELLTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELLTypeBase.getCreateMan());
        }
        if (pSDELLTypeBase.isIconPathDirty() && (bl || pSDELLTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDELLTypeBase.getIconPath());
        }
        if (pSDELLTypeBase.isItemObjDirty() && (bl || pSDELLTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSDELLTypeBase.getItemObj());
        }
        if (pSDELLTypeBase.isItemObj2Dirty() && (bl || pSDELLTypeBase.getItemObj2() != null)) {
            iDataObject.set(FIELD_ITEMOBJ2, (Object)pSDELLTypeBase.getItemObj2());
        }
        if (pSDELLTypeBase.isItemObj3Dirty() && (bl || pSDELLTypeBase.getItemObj3() != null)) {
            iDataObject.set(FIELD_ITEMOBJ3, (Object)pSDELLTypeBase.getItemObj3());
        }
        if (pSDELLTypeBase.isItemObj4Dirty() && (bl || pSDELLTypeBase.getItemObj4() != null)) {
            iDataObject.set(FIELD_ITEMOBJ4, (Object)pSDELLTypeBase.getItemObj4());
        }
        if (pSDELLTypeBase.isItemObj5Dirty() && (bl || pSDELLTypeBase.getItemObj5() != null)) {
            iDataObject.set(FIELD_ITEMOBJ5, (Object)pSDELLTypeBase.getItemObj5());
        }
        if (pSDELLTypeBase.isItemObj6Dirty() && (bl || pSDELLTypeBase.getItemObj6() != null)) {
            iDataObject.set(FIELD_ITEMOBJ6, (Object)pSDELLTypeBase.getItemObj6());
        }
        if (pSDELLTypeBase.isMemoDirty() && (bl || pSDELLTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELLTypeBase.getMemo());
        }
        if (pSDELLTypeBase.isPSDELLTypeIdDirty() && (bl || pSDELLTypeBase.getPSDELLTypeId() != null)) {
            iDataObject.set(FIELD_PSDELLTYPEID, (Object)pSDELLTypeBase.getPSDELLTypeId());
        }
        if (pSDELLTypeBase.isPSDELLTypeNameDirty() && (bl || pSDELLTypeBase.getPSDELLTypeName() != null)) {
            iDataObject.set(FIELD_PSDELLTYPENAME, (Object)pSDELLTypeBase.getPSDELLTypeName());
        }
        if (pSDELLTypeBase.isUpdateDateDirty() && (bl || pSDELLTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELLTypeBase.getUpdateDate());
        }
        if (pSDELLTypeBase.isUpdateManDirty() && (bl || pSDELLTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELLTypeBase.getUpdateMan());
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
        return PSDELLTypeBase.remove(this, n);
    }

    private static boolean remove(PSDELLTypeBase pSDELLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELLTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDELLTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDELLTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDELLTypeBase.resetItemObj();
                return true;
            }
            case 4: {
                pSDELLTypeBase.resetItemObj2();
                return true;
            }
            case 5: {
                pSDELLTypeBase.resetItemObj3();
                return true;
            }
            case 6: {
                pSDELLTypeBase.resetItemObj4();
                return true;
            }
            case 7: {
                pSDELLTypeBase.resetItemObj5();
                return true;
            }
            case 8: {
                pSDELLTypeBase.resetItemObj6();
                return true;
            }
            case 9: {
                pSDELLTypeBase.resetMemo();
                return true;
            }
            case 10: {
                pSDELLTypeBase.resetPSDELLTypeId();
                return true;
            }
            case 11: {
                pSDELLTypeBase.resetPSDELLTypeName();
                return true;
            }
            case 12: {
                pSDELLTypeBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDELLTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDELLTypeBase getProxyEntity() {
        return this.proxyPSDELLTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELLTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELLTypeBase) {
            this.proxyPSDELLTypeBase = (PSDELLTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDELLTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_ITEMOBJ, 3);
        fieldIndexMap.put(FIELD_ITEMOBJ2, 4);
        fieldIndexMap.put(FIELD_ITEMOBJ3, 5);
        fieldIndexMap.put(FIELD_ITEMOBJ4, 6);
        fieldIndexMap.put(FIELD_ITEMOBJ5, 7);
        fieldIndexMap.put(FIELD_ITEMOBJ6, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSDELLTYPEID, 10);
        fieldIndexMap.put(FIELD_PSDELLTYPENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

