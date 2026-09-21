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

public abstract class PSCounterTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCounterTypeBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_COUNTEROBJ = "COUNTEROBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOUNTERTYPEID = "PSCOUNTERTYPEID";
    public static final String FIELD_PSCOUNTERTYPENAME = "PSCOUNTERTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_COUNTEROBJ = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_JITCTRLOBJ = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSCOUNTERTYPEID = 6;
    private static final int INDEX_PSCOUNTERTYPENAME = 7;
    private static final int INDEX_TYPEOBJ = 8;
    private static final int INDEX_TYPEPARAMS = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCounterTypeBase proxyPSCounterTypeBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean counterobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscountertypeidDirtyFlag = false;
    private boolean pscountertypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="counterobj")
    private String counterobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pscountertypeid")
    private String pscountertypeid;
    @Column(name="pscountertypename")
    private String pscountertypename;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

    public void setCounterOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterobj = string;
        this.counterobjDirtyFlag = true;
    }

    public String getCounterOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterOBJ();
        }
        return this.counterobj;
    }

    public boolean isCounterOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterOBJDirty();
        }
        return this.counterobjDirtyFlag;
    }

    public void resetCounterOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterOBJ();
            return;
        }
        this.counterobjDirtyFlag = false;
        this.counterobj = null;
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

    public void setJITCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj = string;
        this.jitctrlobjDirtyFlag = true;
    }

    public String getJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj();
        }
        return this.jitctrlobj;
    }

    public boolean isJITCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObjDirty();
        }
        return this.jitctrlobjDirtyFlag;
    }

    public void resetJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj();
            return;
        }
        this.jitctrlobjDirtyFlag = false;
        this.jitctrlobj = null;
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

    public void setPSCounterTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypeid = string;
        this.pscountertypeidDirtyFlag = true;
    }

    public String getPSCounterTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeId();
        }
        return this.pscountertypeid;
    }

    public boolean isPSCounterTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeIdDirty();
        }
        return this.pscountertypeidDirtyFlag;
    }

    public void resetPSCounterTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeId();
            return;
        }
        this.pscountertypeidDirtyFlag = false;
        this.pscountertypeid = null;
    }

    public void setPSCounterTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypename = string;
        this.pscountertypenameDirtyFlag = true;
    }

    public String getPSCounterTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeName();
        }
        return this.pscountertypename;
    }

    public boolean isPSCounterTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeNameDirty();
        }
        return this.pscountertypenameDirtyFlag;
    }

    public void resetPSCounterTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeName();
            return;
        }
        this.pscountertypenameDirtyFlag = false;
        this.pscountertypename = null;
    }

    public void setTypeOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeOBJ();
        }
        return this.typeobj;
    }

    public boolean isTypeOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeOBJDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeOBJ();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
    }

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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
        PSCounterTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCounterTypeBase pSCounterTypeBase) {
        pSCounterTypeBase.resetBaseClsParams();
        pSCounterTypeBase.resetCounterOBJ();
        pSCounterTypeBase.resetCreateDate();
        pSCounterTypeBase.resetCreateMan();
        pSCounterTypeBase.resetJITCtrlObj();
        pSCounterTypeBase.resetMemo();
        pSCounterTypeBase.resetPSCounterTypeId();
        pSCounterTypeBase.resetPSCounterTypeName();
        pSCounterTypeBase.resetTypeOBJ();
        pSCounterTypeBase.resetTypeParams();
        pSCounterTypeBase.resetUpdateDate();
        pSCounterTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCounterOBJDirty()) {
            hashMap.put(FIELD_COUNTEROBJ, this.getCounterOBJ());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCounterTypeIdDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPEID, this.getPSCounterTypeId());
        }
        if (!bl || this.isPSCounterTypeNameDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPENAME, this.getPSCounterTypeName());
        }
        if (!bl || this.isTypeOBJDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeOBJ());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
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
        return PSCounterTypeBase.get(this, n);
    }

    private static Object get(PSCounterTypeBase pSCounterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeBase.getBaseClsParams();
            }
            case 1: {
                return pSCounterTypeBase.getCounterOBJ();
            }
            case 2: {
                return pSCounterTypeBase.getCreateDate();
            }
            case 3: {
                return pSCounterTypeBase.getCreateMan();
            }
            case 4: {
                return pSCounterTypeBase.getJITCtrlObj();
            }
            case 5: {
                return pSCounterTypeBase.getMemo();
            }
            case 6: {
                return pSCounterTypeBase.getPSCounterTypeId();
            }
            case 7: {
                return pSCounterTypeBase.getPSCounterTypeName();
            }
            case 8: {
                return pSCounterTypeBase.getTypeOBJ();
            }
            case 9: {
                return pSCounterTypeBase.getTypeParams();
            }
            case 10: {
                return pSCounterTypeBase.getUpdateDate();
            }
            case 11: {
                return pSCounterTypeBase.getUpdateMan();
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
        PSCounterTypeBase.set(this, n, object);
    }

    private static void set(PSCounterTypeBase pSCounterTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCounterTypeBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCounterTypeBase.setCounterOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCounterTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSCounterTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCounterTypeBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCounterTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCounterTypeBase.setPSCounterTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCounterTypeBase.setPSCounterTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCounterTypeBase.setTypeOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCounterTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCounterTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCounterTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCounterTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSCounterTypeBase pSCounterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSCounterTypeBase.getCounterOBJ() == null;
            }
            case 2: {
                return pSCounterTypeBase.getCreateDate() == null;
            }
            case 3: {
                return pSCounterTypeBase.getCreateMan() == null;
            }
            case 4: {
                return pSCounterTypeBase.getJITCtrlObj() == null;
            }
            case 5: {
                return pSCounterTypeBase.getMemo() == null;
            }
            case 6: {
                return pSCounterTypeBase.getPSCounterTypeId() == null;
            }
            case 7: {
                return pSCounterTypeBase.getPSCounterTypeName() == null;
            }
            case 8: {
                return pSCounterTypeBase.getTypeOBJ() == null;
            }
            case 9: {
                return pSCounterTypeBase.getTypeParams() == null;
            }
            case 10: {
                return pSCounterTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSCounterTypeBase.getUpdateMan() == null;
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
        return PSCounterTypeBase.contains(this, n);
    }

    private static boolean contains(PSCounterTypeBase pSCounterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSCounterTypeBase.isCounterOBJDirty();
            }
            case 2: {
                return pSCounterTypeBase.isCreateDateDirty();
            }
            case 3: {
                return pSCounterTypeBase.isCreateManDirty();
            }
            case 4: {
                return pSCounterTypeBase.isJITCtrlObjDirty();
            }
            case 5: {
                return pSCounterTypeBase.isMemoDirty();
            }
            case 6: {
                return pSCounterTypeBase.isPSCounterTypeIdDirty();
            }
            case 7: {
                return pSCounterTypeBase.isPSCounterTypeNameDirty();
            }
            case 8: {
                return pSCounterTypeBase.isTypeOBJDirty();
            }
            case 9: {
                return pSCounterTypeBase.isTypeParamsDirty();
            }
            case 10: {
                return pSCounterTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSCounterTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCounterTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCounterTypeBase pSCounterTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCounterTypeBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getCounterOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterobj", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getCounterOBJ()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getPSCounterTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypeid", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getPSCounterTypeId()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getPSCounterTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypename", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getPSCounterTypeName()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getTypeOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getTypeOBJ()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCounterTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCounterTypeBase.getJSONValue((Object)pSCounterTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCounterTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCounterTypeBase pSCounterTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCounterTypeBase.getBaseClsParams() != null) {
            object = pSCounterTypeBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSCounterTypeBase.getCounterOBJ() != null) {
            object = pSCounterTypeBase.getCounterOBJ();
            xmlNode.setAttribute(FIELD_COUNTEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getCreateDate() != null) {
            object = pSCounterTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterTypeBase.getCreateMan() != null) {
            object = pSCounterTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getJITCtrlObj() != null) {
            object = pSCounterTypeBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getMemo() != null) {
            object = pSCounterTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getPSCounterTypeId() != null) {
            object = pSCounterTypeBase.getPSCounterTypeId();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getPSCounterTypeName() != null) {
            object = pSCounterTypeBase.getPSCounterTypeName();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getTypeOBJ() != null) {
            object = pSCounterTypeBase.getTypeOBJ();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getTypeParams() != null) {
            object = pSCounterTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeBase.getUpdateDate() != null) {
            object = pSCounterTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterTypeBase.getUpdateMan() != null) {
            object = pSCounterTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCounterTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCounterTypeBase pSCounterTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCounterTypeBase.isBaseClsParamsDirty() && (bl || pSCounterTypeBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSCounterTypeBase.getBaseClsParams());
        }
        if (pSCounterTypeBase.isCounterOBJDirty() && (bl || pSCounterTypeBase.getCounterOBJ() != null)) {
            iDataObject.set(FIELD_COUNTEROBJ, (Object)pSCounterTypeBase.getCounterOBJ());
        }
        if (pSCounterTypeBase.isCreateDateDirty() && (bl || pSCounterTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCounterTypeBase.getCreateDate());
        }
        if (pSCounterTypeBase.isCreateManDirty() && (bl || pSCounterTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCounterTypeBase.getCreateMan());
        }
        if (pSCounterTypeBase.isJITCtrlObjDirty() && (bl || pSCounterTypeBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSCounterTypeBase.getJITCtrlObj());
        }
        if (pSCounterTypeBase.isMemoDirty() && (bl || pSCounterTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCounterTypeBase.getMemo());
        }
        if (pSCounterTypeBase.isPSCounterTypeIdDirty() && (bl || pSCounterTypeBase.getPSCounterTypeId() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPEID, (Object)pSCounterTypeBase.getPSCounterTypeId());
        }
        if (pSCounterTypeBase.isPSCounterTypeNameDirty() && (bl || pSCounterTypeBase.getPSCounterTypeName() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPENAME, (Object)pSCounterTypeBase.getPSCounterTypeName());
        }
        if (pSCounterTypeBase.isTypeOBJDirty() && (bl || pSCounterTypeBase.getTypeOBJ() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSCounterTypeBase.getTypeOBJ());
        }
        if (pSCounterTypeBase.isTypeParamsDirty() && (bl || pSCounterTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSCounterTypeBase.getTypeParams());
        }
        if (pSCounterTypeBase.isUpdateDateDirty() && (bl || pSCounterTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCounterTypeBase.getUpdateDate());
        }
        if (pSCounterTypeBase.isUpdateManDirty() && (bl || pSCounterTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCounterTypeBase.getUpdateMan());
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
        return PSCounterTypeBase.remove(this, n);
    }

    private static boolean remove(PSCounterTypeBase pSCounterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCounterTypeBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSCounterTypeBase.resetCounterOBJ();
                return true;
            }
            case 2: {
                pSCounterTypeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSCounterTypeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSCounterTypeBase.resetJITCtrlObj();
                return true;
            }
            case 5: {
                pSCounterTypeBase.resetMemo();
                return true;
            }
            case 6: {
                pSCounterTypeBase.resetPSCounterTypeId();
                return true;
            }
            case 7: {
                pSCounterTypeBase.resetPSCounterTypeName();
                return true;
            }
            case 8: {
                pSCounterTypeBase.resetTypeOBJ();
                return true;
            }
            case 9: {
                pSCounterTypeBase.resetTypeParams();
                return true;
            }
            case 10: {
                pSCounterTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSCounterTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCounterTypeBase getProxyEntity() {
        return this.proxyPSCounterTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCounterTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSCounterTypeBase) {
            this.proxyPSCounterTypeBase = (PSCounterTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCounterTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_COUNTEROBJ, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPENAME, 7);
        fieldIndexMap.put(FIELD_TYPEOBJ, 8);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

