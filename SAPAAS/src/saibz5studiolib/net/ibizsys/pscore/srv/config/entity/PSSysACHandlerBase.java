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

public abstract class PSSysACHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysACHandlerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_FUNCMODE = "FUNCMODE";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_JITCTRLOBJ2 = "JITCTRLOBJ2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSACHANDLERID = "PSSYSACHANDLERID";
    public static final String FIELD_PSSYSACHANDLERNAME = "PSSYSACHANDLERNAME";
    public static final String FIELD_TEMPMODE = "TEMPMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLTYPE = 2;
    private static final int INDEX_FUNCMODE = 3;
    private static final int INDEX_JITCTRLOBJ = 4;
    private static final int INDEX_JITCTRLOBJ2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSSYSACHANDLERID = 7;
    private static final int INDEX_PSSYSACHANDLERNAME = 8;
    private static final int INDEX_TEMPMODE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysACHandlerBase proxyPSSysACHandlerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean funcmodeDirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean jitctrlobj2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysachandleridDirtyFlag = false;
    private boolean pssysachandlernameDirtyFlag = false;
    private boolean tempmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="funcmode")
    private String funcmode;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="jitctrlobj2")
    private String jitctrlobj2;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysachandlerid")
    private String pssysachandlerid;
    @Column(name="pssysachandlername")
    private String pssysachandlername;
    @Column(name="tempmode")
    private Integer tempmode;
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

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
    }

    public void setFuncMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcmode = string;
        this.funcmodeDirtyFlag = true;
    }

    public String getFuncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncMode();
        }
        return this.funcmode;
    }

    public boolean isFuncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncModeDirty();
        }
        return this.funcmodeDirtyFlag;
    }

    public void resetFuncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncMode();
            return;
        }
        this.funcmodeDirtyFlag = false;
        this.funcmode = null;
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

    public void setJITCtrlObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj2 = string;
        this.jitctrlobj2DirtyFlag = true;
    }

    public String getJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj2();
        }
        return this.jitctrlobj2;
    }

    public boolean isJITCtrlObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObj2Dirty();
        }
        return this.jitctrlobj2DirtyFlag;
    }

    public void resetJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj2();
            return;
        }
        this.jitctrlobj2DirtyFlag = false;
        this.jitctrlobj2 = null;
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

    public void setPSSysACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlerid = string;
        this.pssysachandleridDirtyFlag = true;
    }

    public String getPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerId();
        }
        return this.pssysachandlerid;
    }

    public boolean isPSSysACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerIdDirty();
        }
        return this.pssysachandleridDirtyFlag;
    }

    public void resetPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerId();
            return;
        }
        this.pssysachandleridDirtyFlag = false;
        this.pssysachandlerid = null;
    }

    public void setPSSysACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlername = string;
        this.pssysachandlernameDirtyFlag = true;
    }

    public String getPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerName();
        }
        return this.pssysachandlername;
    }

    public boolean isPSSysACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerNameDirty();
        }
        return this.pssysachandlernameDirtyFlag;
    }

    public void resetPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerName();
            return;
        }
        this.pssysachandlernameDirtyFlag = false;
        this.pssysachandlername = null;
    }

    public void setTempMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempMode(n);
            return;
        }
        this.tempmode = n;
        this.tempmodeDirtyFlag = true;
    }

    public Integer getTempMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempMode();
        }
        return this.tempmode;
    }

    public boolean isTempModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempModeDirty();
        }
        return this.tempmodeDirtyFlag;
    }

    public void resetTempMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempMode();
            return;
        }
        this.tempmodeDirtyFlag = false;
        this.tempmode = null;
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
        PSSysACHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysACHandlerBase pSSysACHandlerBase) {
        pSSysACHandlerBase.resetCreateDate();
        pSSysACHandlerBase.resetCreateMan();
        pSSysACHandlerBase.resetCtrlType();
        pSSysACHandlerBase.resetFuncMode();
        pSSysACHandlerBase.resetJITCtrlObj();
        pSSysACHandlerBase.resetJITCtrlObj2();
        pSSysACHandlerBase.resetMemo();
        pSSysACHandlerBase.resetPSSysACHandlerId();
        pSSysACHandlerBase.resetPSSysACHandlerName();
        pSSysACHandlerBase.resetTempMode();
        pSSysACHandlerBase.resetUpdateDate();
        pSSysACHandlerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isFuncModeDirty()) {
            hashMap.put(FIELD_FUNCMODE, this.getFuncMode());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isJITCtrlObj2Dirty()) {
            hashMap.put(FIELD_JITCTRLOBJ2, this.getJITCtrlObj2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERID, this.getPSSysACHandlerId());
        }
        if (!bl || this.isPSSysACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERNAME, this.getPSSysACHandlerName());
        }
        if (!bl || this.isTempModeDirty()) {
            hashMap.put(FIELD_TEMPMODE, this.getTempMode());
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
        return PSSysACHandlerBase.get(this, n);
    }

    private static Object get(PSSysACHandlerBase pSSysACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysACHandlerBase.getCreateDate();
            }
            case 1: {
                return pSSysACHandlerBase.getCreateMan();
            }
            case 2: {
                return pSSysACHandlerBase.getCtrlType();
            }
            case 3: {
                return pSSysACHandlerBase.getFuncMode();
            }
            case 4: {
                return pSSysACHandlerBase.getJITCtrlObj();
            }
            case 5: {
                return pSSysACHandlerBase.getJITCtrlObj2();
            }
            case 6: {
                return pSSysACHandlerBase.getMemo();
            }
            case 7: {
                return pSSysACHandlerBase.getPSSysACHandlerId();
            }
            case 8: {
                return pSSysACHandlerBase.getPSSysACHandlerName();
            }
            case 9: {
                return pSSysACHandlerBase.getTempMode();
            }
            case 10: {
                return pSSysACHandlerBase.getUpdateDate();
            }
            case 11: {
                return pSSysACHandlerBase.getUpdateMan();
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
        PSSysACHandlerBase.set(this, n, object);
    }

    private static void set(PSSysACHandlerBase pSSysACHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysACHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysACHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysACHandlerBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysACHandlerBase.setFuncMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysACHandlerBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysACHandlerBase.setJITCtrlObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysACHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysACHandlerBase.setPSSysACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysACHandlerBase.setPSSysACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysACHandlerBase.setTempMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysACHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysACHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysACHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysACHandlerBase pSSysACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysACHandlerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysACHandlerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysACHandlerBase.getCtrlType() == null;
            }
            case 3: {
                return pSSysACHandlerBase.getFuncMode() == null;
            }
            case 4: {
                return pSSysACHandlerBase.getJITCtrlObj() == null;
            }
            case 5: {
                return pSSysACHandlerBase.getJITCtrlObj2() == null;
            }
            case 6: {
                return pSSysACHandlerBase.getMemo() == null;
            }
            case 7: {
                return pSSysACHandlerBase.getPSSysACHandlerId() == null;
            }
            case 8: {
                return pSSysACHandlerBase.getPSSysACHandlerName() == null;
            }
            case 9: {
                return pSSysACHandlerBase.getTempMode() == null;
            }
            case 10: {
                return pSSysACHandlerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysACHandlerBase.getUpdateMan() == null;
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
        return PSSysACHandlerBase.contains(this, n);
    }

    private static boolean contains(PSSysACHandlerBase pSSysACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysACHandlerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysACHandlerBase.isCreateManDirty();
            }
            case 2: {
                return pSSysACHandlerBase.isCtrlTypeDirty();
            }
            case 3: {
                return pSSysACHandlerBase.isFuncModeDirty();
            }
            case 4: {
                return pSSysACHandlerBase.isJITCtrlObjDirty();
            }
            case 5: {
                return pSSysACHandlerBase.isJITCtrlObj2Dirty();
            }
            case 6: {
                return pSSysACHandlerBase.isMemoDirty();
            }
            case 7: {
                return pSSysACHandlerBase.isPSSysACHandlerIdDirty();
            }
            case 8: {
                return pSSysACHandlerBase.isPSSysACHandlerNameDirty();
            }
            case 9: {
                return pSSysACHandlerBase.isTempModeDirty();
            }
            case 10: {
                return pSSysACHandlerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysACHandlerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysACHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysACHandlerBase pSSysACHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysACHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getFuncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcmode", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getFuncMode()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getJITCtrlObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj2", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getJITCtrlObj2()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getPSSysACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlerid", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getPSSysACHandlerId()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getPSSysACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlername", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getPSSysACHandlerName()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getTempMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempmode", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getTempMode()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysACHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysACHandlerBase.getJSONValue((Object)pSSysACHandlerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysACHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysACHandlerBase pSSysACHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysACHandlerBase.getCreateDate() != null) {
            object = pSSysACHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysACHandlerBase.getCreateMan() != null) {
            object = pSSysACHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getCtrlType() != null) {
            object = pSSysACHandlerBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getFuncMode() != null) {
            object = pSSysACHandlerBase.getFuncMode();
            xmlNode.setAttribute(FIELD_FUNCMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getJITCtrlObj() != null) {
            object = pSSysACHandlerBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getJITCtrlObj2() != null) {
            object = pSSysACHandlerBase.getJITCtrlObj2();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getMemo() != null) {
            object = pSSysACHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getPSSysACHandlerId() != null) {
            object = pSSysACHandlerBase.getPSSysACHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getPSSysACHandlerName() != null) {
            object = pSSysACHandlerBase.getPSSysACHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysACHandlerBase.getTempMode() != null) {
            object = pSSysACHandlerBase.getTempMode();
            xmlNode.setAttribute(FIELD_TEMPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysACHandlerBase.getUpdateDate() != null) {
            object = pSSysACHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysACHandlerBase.getUpdateMan() != null) {
            object = pSSysACHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysACHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysACHandlerBase pSSysACHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysACHandlerBase.isCreateDateDirty() && (bl || pSSysACHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysACHandlerBase.getCreateDate());
        }
        if (pSSysACHandlerBase.isCreateManDirty() && (bl || pSSysACHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysACHandlerBase.getCreateMan());
        }
        if (pSSysACHandlerBase.isCtrlTypeDirty() && (bl || pSSysACHandlerBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSSysACHandlerBase.getCtrlType());
        }
        if (pSSysACHandlerBase.isFuncModeDirty() && (bl || pSSysACHandlerBase.getFuncMode() != null)) {
            iDataObject.set(FIELD_FUNCMODE, (Object)pSSysACHandlerBase.getFuncMode());
        }
        if (pSSysACHandlerBase.isJITCtrlObjDirty() && (bl || pSSysACHandlerBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSSysACHandlerBase.getJITCtrlObj());
        }
        if (pSSysACHandlerBase.isJITCtrlObj2Dirty() && (bl || pSSysACHandlerBase.getJITCtrlObj2() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ2, (Object)pSSysACHandlerBase.getJITCtrlObj2());
        }
        if (pSSysACHandlerBase.isMemoDirty() && (bl || pSSysACHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysACHandlerBase.getMemo());
        }
        if (pSSysACHandlerBase.isPSSysACHandlerIdDirty() && (bl || pSSysACHandlerBase.getPSSysACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERID, (Object)pSSysACHandlerBase.getPSSysACHandlerId());
        }
        if (pSSysACHandlerBase.isPSSysACHandlerNameDirty() && (bl || pSSysACHandlerBase.getPSSysACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERNAME, (Object)pSSysACHandlerBase.getPSSysACHandlerName());
        }
        if (pSSysACHandlerBase.isTempModeDirty() && (bl || pSSysACHandlerBase.getTempMode() != null)) {
            iDataObject.set(FIELD_TEMPMODE, (Object)pSSysACHandlerBase.getTempMode());
        }
        if (pSSysACHandlerBase.isUpdateDateDirty() && (bl || pSSysACHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysACHandlerBase.getUpdateDate());
        }
        if (pSSysACHandlerBase.isUpdateManDirty() && (bl || pSSysACHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysACHandlerBase.getUpdateMan());
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
        return PSSysACHandlerBase.remove(this, n);
    }

    private static boolean remove(PSSysACHandlerBase pSSysACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysACHandlerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysACHandlerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysACHandlerBase.resetCtrlType();
                return true;
            }
            case 3: {
                pSSysACHandlerBase.resetFuncMode();
                return true;
            }
            case 4: {
                pSSysACHandlerBase.resetJITCtrlObj();
                return true;
            }
            case 5: {
                pSSysACHandlerBase.resetJITCtrlObj2();
                return true;
            }
            case 6: {
                pSSysACHandlerBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysACHandlerBase.resetPSSysACHandlerId();
                return true;
            }
            case 8: {
                pSSysACHandlerBase.resetPSSysACHandlerName();
                return true;
            }
            case 9: {
                pSSysACHandlerBase.resetTempMode();
                return true;
            }
            case 10: {
                pSSysACHandlerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysACHandlerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysACHandlerBase getProxyEntity() {
        return this.proxyPSSysACHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysACHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysACHandlerBase) {
            this.proxyPSSysACHandlerBase = (PSSysACHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysACHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLTYPE, 2);
        fieldIndexMap.put(FIELD_FUNCMODE, 3);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 4);
        fieldIndexMap.put(FIELD_JITCTRLOBJ2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERID, 7);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERNAME, 8);
        fieldIndexMap.put(FIELD_TEMPMODE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

