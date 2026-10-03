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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNRESID = "PSDEVSLNRESID";
    public static final String FIELD_PSDEVSLNRESNAME = "PSDEVSLNRESNAME";
    public static final String FIELD_RESPARAMS = "RESPARAMS";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNID = 3;
    private static final int INDEX_PSDEVSLNNAME = 4;
    private static final int INDEX_PSDEVSLNRESID = 5;
    private static final int INDEX_PSDEVSLNRESNAME = 6;
    private static final int INDEX_RESPARAMS = 7;
    private static final int INDEX_RESTYPE = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnResBase proxyPSDevSlnResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnresidDirtyFlag = false;
    private boolean psdevslnresnameDirtyFlag = false;
    private boolean resparamsDirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnresid")
    private String psdevslnresid;
    @Column(name="psdevslnresname")
    private String psdevslnresname;
    @Column(name="resparams")
    private String resparams;
    @Column(name="restype")
    private String restype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnresid = string;
        this.psdevslnresidDirtyFlag = true;
    }

    public String getPSDevSlnResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnResId();
        }
        return this.psdevslnresid;
    }

    public boolean isPSDevSlnResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnResIdDirty();
        }
        return this.psdevslnresidDirtyFlag;
    }

    public void resetPSDevSlnResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnResId();
            return;
        }
        this.psdevslnresidDirtyFlag = false;
        this.psdevslnresid = null;
    }

    public void setPSDevSlnResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnresname = string;
        this.psdevslnresnameDirtyFlag = true;
    }

    public String getPSDevSlnResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnResName();
        }
        return this.psdevslnresname;
    }

    public boolean isPSDevSlnResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnResNameDirty();
        }
        return this.psdevslnresnameDirtyFlag;
    }

    public void resetPSDevSlnResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnResName();
            return;
        }
        this.psdevslnresnameDirtyFlag = false;
        this.psdevslnresname = null;
    }

    public void setResParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resparams = string;
        this.resparamsDirtyFlag = true;
    }

    public String getResParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResParams();
        }
        return this.resparams;
    }

    public boolean isResParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResParamsDirty();
        }
        return this.resparamsDirtyFlag;
    }

    public void resetResParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResParams();
            return;
        }
        this.resparamsDirtyFlag = false;
        this.resparams = null;
    }

    public void setResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restype = string;
        this.restypeDirtyFlag = true;
    }

    public String getResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResType();
        }
        return this.restype;
    }

    public boolean isResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTypeDirty();
        }
        return this.restypeDirtyFlag;
    }

    public void resetResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResType();
            return;
        }
        this.restypeDirtyFlag = false;
        this.restype = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSDevSlnResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnResBase pSDevSlnResBase) {
        pSDevSlnResBase.resetCreateDate();
        pSDevSlnResBase.resetCreateMan();
        pSDevSlnResBase.resetMemo();
        pSDevSlnResBase.resetPSDevSlnId();
        pSDevSlnResBase.resetPSDevSlnName();
        pSDevSlnResBase.resetPSDevSlnResId();
        pSDevSlnResBase.resetPSDevSlnResName();
        pSDevSlnResBase.resetResParams();
        pSDevSlnResBase.resetResType();
        pSDevSlnResBase.resetUpdateDate();
        pSDevSlnResBase.resetUpdateMan();
        pSDevSlnResBase.resetUserCat();
        pSDevSlnResBase.resetUserTag();
        pSDevSlnResBase.resetUserTag2();
        pSDevSlnResBase.resetUserTag3();
        pSDevSlnResBase.resetUserTag4();
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
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnResIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNRESID, this.getPSDevSlnResId());
        }
        if (!bl || this.isPSDevSlnResNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNRESNAME, this.getPSDevSlnResName());
        }
        if (!bl || this.isResParamsDirty()) {
            hashMap.put(FIELD_RESPARAMS, this.getResParams());
        }
        if (!bl || this.isResTypeDirty()) {
            hashMap.put(FIELD_RESTYPE, this.getResType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSDevSlnResBase.get(this, n);
    }

    private static Object get(PSDevSlnResBase pSDevSlnResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnResBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnResBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnResBase.getMemo();
            }
            case 3: {
                return pSDevSlnResBase.getPSDevSlnId();
            }
            case 4: {
                return pSDevSlnResBase.getPSDevSlnName();
            }
            case 5: {
                return pSDevSlnResBase.getPSDevSlnResId();
            }
            case 6: {
                return pSDevSlnResBase.getPSDevSlnResName();
            }
            case 7: {
                return pSDevSlnResBase.getResParams();
            }
            case 8: {
                return pSDevSlnResBase.getResType();
            }
            case 9: {
                return pSDevSlnResBase.getUpdateDate();
            }
            case 10: {
                return pSDevSlnResBase.getUpdateMan();
            }
            case 11: {
                return pSDevSlnResBase.getUserCat();
            }
            case 12: {
                return pSDevSlnResBase.getUserTag();
            }
            case 13: {
                return pSDevSlnResBase.getUserTag2();
            }
            case 14: {
                return pSDevSlnResBase.getUserTag3();
            }
            case 15: {
                return pSDevSlnResBase.getUserTag4();
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
        PSDevSlnResBase.set(this, n, object);
    }

    private static void set(PSDevSlnResBase pSDevSlnResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnResBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnResBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnResBase.setPSDevSlnResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnResBase.setPSDevSlnResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnResBase.setResParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnResBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnResBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnResBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnResBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnResBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnResBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevSlnResBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnResBase pSDevSlnResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnResBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnResBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnResBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnResBase.getPSDevSlnId() == null;
            }
            case 4: {
                return pSDevSlnResBase.getPSDevSlnName() == null;
            }
            case 5: {
                return pSDevSlnResBase.getPSDevSlnResId() == null;
            }
            case 6: {
                return pSDevSlnResBase.getPSDevSlnResName() == null;
            }
            case 7: {
                return pSDevSlnResBase.getResParams() == null;
            }
            case 8: {
                return pSDevSlnResBase.getResType() == null;
            }
            case 9: {
                return pSDevSlnResBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDevSlnResBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDevSlnResBase.getUserCat() == null;
            }
            case 12: {
                return pSDevSlnResBase.getUserTag() == null;
            }
            case 13: {
                return pSDevSlnResBase.getUserTag2() == null;
            }
            case 14: {
                return pSDevSlnResBase.getUserTag3() == null;
            }
            case 15: {
                return pSDevSlnResBase.getUserTag4() == null;
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
        return PSDevSlnResBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnResBase pSDevSlnResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnResBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnResBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnResBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnResBase.isPSDevSlnIdDirty();
            }
            case 4: {
                return pSDevSlnResBase.isPSDevSlnNameDirty();
            }
            case 5: {
                return pSDevSlnResBase.isPSDevSlnResIdDirty();
            }
            case 6: {
                return pSDevSlnResBase.isPSDevSlnResNameDirty();
            }
            case 7: {
                return pSDevSlnResBase.isResParamsDirty();
            }
            case 8: {
                return pSDevSlnResBase.isResTypeDirty();
            }
            case 9: {
                return pSDevSlnResBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDevSlnResBase.isUpdateManDirty();
            }
            case 11: {
                return pSDevSlnResBase.isUserCatDirty();
            }
            case 12: {
                return pSDevSlnResBase.isUserTagDirty();
            }
            case 13: {
                return pSDevSlnResBase.isUserTag2Dirty();
            }
            case 14: {
                return pSDevSlnResBase.isUserTag3Dirty();
            }
            case 15: {
                return pSDevSlnResBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnResBase pSDevSlnResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnresid", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getPSDevSlnResId()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnresname", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getPSDevSlnResName()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getResParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resparams", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getResParams()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getResType()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnResBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnResBase.getJSONValue((Object)pSDevSlnResBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnResBase pSDevSlnResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnResBase.getCreateDate() != null) {
            object = pSDevSlnResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnResBase.getCreateMan() != null) {
            object = pSDevSlnResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getMemo() != null) {
            object = pSDevSlnResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnId() != null) {
            object = pSDevSlnResBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnName() != null) {
            object = pSDevSlnResBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnResId() != null) {
            object = pSDevSlnResBase.getPSDevSlnResId();
            xmlNode.setAttribute(FIELD_PSDEVSLNRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getPSDevSlnResName() != null) {
            object = pSDevSlnResBase.getPSDevSlnResName();
            xmlNode.setAttribute(FIELD_PSDEVSLNRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getResParams() != null) {
            object = pSDevSlnResBase.getResParams();
            xmlNode.setAttribute(FIELD_RESPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getResType() != null) {
            object = pSDevSlnResBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUpdateDate() != null) {
            object = pSDevSlnResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnResBase.getUpdateMan() != null) {
            object = pSDevSlnResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUserCat() != null) {
            object = pSDevSlnResBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUserTag() != null) {
            object = pSDevSlnResBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUserTag2() != null) {
            object = pSDevSlnResBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUserTag3() != null) {
            object = pSDevSlnResBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnResBase.getUserTag4() != null) {
            object = pSDevSlnResBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnResBase pSDevSlnResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnResBase.isCreateDateDirty() && (bl || pSDevSlnResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnResBase.getCreateDate());
        }
        if (pSDevSlnResBase.isCreateManDirty() && (bl || pSDevSlnResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnResBase.getCreateMan());
        }
        if (pSDevSlnResBase.isMemoDirty() && (bl || pSDevSlnResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnResBase.getMemo());
        }
        if (pSDevSlnResBase.isPSDevSlnIdDirty() && (bl || pSDevSlnResBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnResBase.getPSDevSlnId());
        }
        if (pSDevSlnResBase.isPSDevSlnNameDirty() && (bl || pSDevSlnResBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnResBase.getPSDevSlnName());
        }
        if (pSDevSlnResBase.isPSDevSlnResIdDirty() && (bl || pSDevSlnResBase.getPSDevSlnResId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRESID, (Object)pSDevSlnResBase.getPSDevSlnResId());
        }
        if (pSDevSlnResBase.isPSDevSlnResNameDirty() && (bl || pSDevSlnResBase.getPSDevSlnResName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNRESNAME, (Object)pSDevSlnResBase.getPSDevSlnResName());
        }
        if (pSDevSlnResBase.isResParamsDirty() && (bl || pSDevSlnResBase.getResParams() != null)) {
            iDataObject.set(FIELD_RESPARAMS, (Object)pSDevSlnResBase.getResParams());
        }
        if (pSDevSlnResBase.isResTypeDirty() && (bl || pSDevSlnResBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSDevSlnResBase.getResType());
        }
        if (pSDevSlnResBase.isUpdateDateDirty() && (bl || pSDevSlnResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnResBase.getUpdateDate());
        }
        if (pSDevSlnResBase.isUpdateManDirty() && (bl || pSDevSlnResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnResBase.getUpdateMan());
        }
        if (pSDevSlnResBase.isUserCatDirty() && (bl || pSDevSlnResBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnResBase.getUserCat());
        }
        if (pSDevSlnResBase.isUserTagDirty() && (bl || pSDevSlnResBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnResBase.getUserTag());
        }
        if (pSDevSlnResBase.isUserTag2Dirty() && (bl || pSDevSlnResBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnResBase.getUserTag2());
        }
        if (pSDevSlnResBase.isUserTag3Dirty() && (bl || pSDevSlnResBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnResBase.getUserTag3());
        }
        if (pSDevSlnResBase.isUserTag4Dirty() && (bl || pSDevSlnResBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnResBase.getUserTag4());
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
        return PSDevSlnResBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnResBase pSDevSlnResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnResBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnResBase.resetPSDevSlnId();
                return true;
            }
            case 4: {
                pSDevSlnResBase.resetPSDevSlnName();
                return true;
            }
            case 5: {
                pSDevSlnResBase.resetPSDevSlnResId();
                return true;
            }
            case 6: {
                pSDevSlnResBase.resetPSDevSlnResName();
                return true;
            }
            case 7: {
                pSDevSlnResBase.resetResParams();
                return true;
            }
            case 8: {
                pSDevSlnResBase.resetResType();
                return true;
            }
            case 9: {
                pSDevSlnResBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDevSlnResBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDevSlnResBase.resetUserCat();
                return true;
            }
            case 12: {
                pSDevSlnResBase.resetUserTag();
                return true;
            }
            case 13: {
                pSDevSlnResBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSDevSlnResBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSDevSlnResBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnResBase getProxyEntity() {
        return this.proxyPSDevSlnResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnResBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnResBase) {
            this.proxyPSDevSlnResBase = (PSDevSlnResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNRESID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNRESNAME, 6);
        fieldIndexMap.put(FIELD_RESPARAMS, 7);
        fieldIndexMap.put(FIELD_RESTYPE, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERCAT, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
    }
}

