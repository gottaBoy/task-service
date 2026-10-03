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
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import net.ibizsys.pscore.srv.config.service.PSViewTypeCatService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewTypeCatBase.class);
    public static final String FIELD_CATCODE = "CATCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSVIEWTYPECATID = "PPSVIEWTYPECATID";
    public static final String FIELD_PPSVIEWTYPECATNAME = "PPSVIEWTYPECATNAME";
    public static final String FIELD_PSVIEWTYPECATID = "PSVIEWTYPECATID";
    public static final String FIELD_PSVIEWTYPECATNAME = "PSVIEWTYPECATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CATCODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PPSVIEWTYPECATID = 6;
    private static final int INDEX_PPSVIEWTYPECATNAME = 7;
    private static final int INDEX_PSVIEWTYPECATID = 8;
    private static final int INDEX_PSVIEWTYPECATNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewTypeCatBase proxyPSViewTypeCatBase = null;
    private boolean catcodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsviewtypecatidDirtyFlag = false;
    private boolean ppsviewtypecatnameDirtyFlag = false;
    private boolean psviewtypecatidDirtyFlag = false;
    private boolean psviewtypecatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="catcode")
    private String catcode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsviewtypecatid")
    private String ppsviewtypecatid;
    @Column(name="ppsviewtypecatname")
    private String ppsviewtypecatname;
    @Column(name="psviewtypecatid")
    private String psviewtypecatid;
    @Column(name="psviewtypecatname")
    private String psviewtypecatname;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPpsviewtypecatLock = new Integer(1);
    private PSViewTypeCat ppsviewtypecat = null;

    public void setCatCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catcode = string;
        this.catcodeDirtyFlag = true;
    }

    public String getCatCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatCode();
        }
        return this.catcode;
    }

    public boolean isCatCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatCodeDirty();
        }
        return this.catcodeDirtyFlag;
    }

    public void resetCatCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatCode();
            return;
        }
        this.catcodeDirtyFlag = false;
        this.catcode = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPPSViewTypeCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSViewTypeCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsviewtypecatid = string;
        this.ppsviewtypecatidDirtyFlag = true;
    }

    public String getPPSViewTypeCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSViewTypeCatId();
        }
        return this.ppsviewtypecatid;
    }

    public boolean isPPSViewTypeCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSViewTypeCatIdDirty();
        }
        return this.ppsviewtypecatidDirtyFlag;
    }

    public void resetPPSViewTypeCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSViewTypeCatId();
            return;
        }
        this.ppsviewtypecatidDirtyFlag = false;
        this.ppsviewtypecatid = null;
    }

    public void setPPSViewTypeCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSViewTypeCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsviewtypecatname = string;
        this.ppsviewtypecatnameDirtyFlag = true;
    }

    public String getPPSViewTypeCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSViewTypeCatName();
        }
        return this.ppsviewtypecatname;
    }

    public boolean isPPSViewTypeCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSViewTypeCatNameDirty();
        }
        return this.ppsviewtypecatnameDirtyFlag;
    }

    public void resetPPSViewTypeCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSViewTypeCatName();
            return;
        }
        this.ppsviewtypecatnameDirtyFlag = false;
        this.ppsviewtypecatname = null;
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
        PSViewTypeCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewTypeCatBase pSViewTypeCatBase) {
        pSViewTypeCatBase.resetCatCode();
        pSViewTypeCatBase.resetCreateDate();
        pSViewTypeCatBase.resetCreateMan();
        pSViewTypeCatBase.resetIconPath();
        pSViewTypeCatBase.resetMemo();
        pSViewTypeCatBase.resetOrderValue();
        pSViewTypeCatBase.resetPPSViewTypeCatId();
        pSViewTypeCatBase.resetPPSViewTypeCatName();
        pSViewTypeCatBase.resetPSViewTypeCatId();
        pSViewTypeCatBase.resetPSViewTypeCatName();
        pSViewTypeCatBase.resetUpdateDate();
        pSViewTypeCatBase.resetUpdateMan();
        pSViewTypeCatBase.resetUserCat();
        pSViewTypeCatBase.resetUserTag();
        pSViewTypeCatBase.resetUserTag2();
        pSViewTypeCatBase.resetUserTag3();
        pSViewTypeCatBase.resetUserTag4();
        pSViewTypeCatBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatCodeDirty()) {
            hashMap.put(FIELD_CATCODE, this.getCatCode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSViewTypeCatIdDirty()) {
            hashMap.put(FIELD_PPSVIEWTYPECATID, this.getPPSViewTypeCatId());
        }
        if (!bl || this.isPPSViewTypeCatNameDirty()) {
            hashMap.put(FIELD_PPSVIEWTYPECATNAME, this.getPPSViewTypeCatName());
        }
        if (!bl || this.isPSViewTypeCatIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPECATID, this.getPSViewTypeCatId());
        }
        if (!bl || this.isPSViewTypeCatNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPECATNAME, this.getPSViewTypeCatName());
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
        return PSViewTypeCatBase.get(this, n);
    }

    private static Object get(PSViewTypeCatBase pSViewTypeCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeCatBase.getCatCode();
            }
            case 1: {
                return pSViewTypeCatBase.getCreateDate();
            }
            case 2: {
                return pSViewTypeCatBase.getCreateMan();
            }
            case 3: {
                return pSViewTypeCatBase.getIconPath();
            }
            case 4: {
                return pSViewTypeCatBase.getMemo();
            }
            case 5: {
                return pSViewTypeCatBase.getOrderValue();
            }
            case 6: {
                return pSViewTypeCatBase.getPPSViewTypeCatId();
            }
            case 7: {
                return pSViewTypeCatBase.getPPSViewTypeCatName();
            }
            case 8: {
                return pSViewTypeCatBase.getPSViewTypeCatId();
            }
            case 9: {
                return pSViewTypeCatBase.getPSViewTypeCatName();
            }
            case 10: {
                return pSViewTypeCatBase.getUpdateDate();
            }
            case 11: {
                return pSViewTypeCatBase.getUpdateMan();
            }
            case 12: {
                return pSViewTypeCatBase.getUserCat();
            }
            case 13: {
                return pSViewTypeCatBase.getUserTag();
            }
            case 14: {
                return pSViewTypeCatBase.getUserTag2();
            }
            case 15: {
                return pSViewTypeCatBase.getUserTag3();
            }
            case 16: {
                return pSViewTypeCatBase.getUserTag4();
            }
            case 17: {
                return pSViewTypeCatBase.getValidFlag();
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
        PSViewTypeCatBase.set(this, n, object);
    }

    private static void set(PSViewTypeCatBase pSViewTypeCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeCatBase.setCatCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewTypeCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSViewTypeCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewTypeCatBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewTypeCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewTypeCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSViewTypeCatBase.setPPSViewTypeCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewTypeCatBase.setPPSViewTypeCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewTypeCatBase.setPSViewTypeCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewTypeCatBase.setPSViewTypeCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewTypeCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSViewTypeCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewTypeCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewTypeCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSViewTypeCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewTypeCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewTypeCatBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewTypeCatBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSViewTypeCatBase.isNull(this, n);
    }

    private static boolean isNull(PSViewTypeCatBase pSViewTypeCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeCatBase.getCatCode() == null;
            }
            case 1: {
                return pSViewTypeCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSViewTypeCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSViewTypeCatBase.getIconPath() == null;
            }
            case 4: {
                return pSViewTypeCatBase.getMemo() == null;
            }
            case 5: {
                return pSViewTypeCatBase.getOrderValue() == null;
            }
            case 6: {
                return pSViewTypeCatBase.getPPSViewTypeCatId() == null;
            }
            case 7: {
                return pSViewTypeCatBase.getPPSViewTypeCatName() == null;
            }
            case 8: {
                return pSViewTypeCatBase.getPSViewTypeCatId() == null;
            }
            case 9: {
                return pSViewTypeCatBase.getPSViewTypeCatName() == null;
            }
            case 10: {
                return pSViewTypeCatBase.getUpdateDate() == null;
            }
            case 11: {
                return pSViewTypeCatBase.getUpdateMan() == null;
            }
            case 12: {
                return pSViewTypeCatBase.getUserCat() == null;
            }
            case 13: {
                return pSViewTypeCatBase.getUserTag() == null;
            }
            case 14: {
                return pSViewTypeCatBase.getUserTag2() == null;
            }
            case 15: {
                return pSViewTypeCatBase.getUserTag3() == null;
            }
            case 16: {
                return pSViewTypeCatBase.getUserTag4() == null;
            }
            case 17: {
                return pSViewTypeCatBase.getValidFlag() == null;
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
        return PSViewTypeCatBase.contains(this, n);
    }

    private static boolean contains(PSViewTypeCatBase pSViewTypeCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeCatBase.isCatCodeDirty();
            }
            case 1: {
                return pSViewTypeCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSViewTypeCatBase.isCreateManDirty();
            }
            case 3: {
                return pSViewTypeCatBase.isIconPathDirty();
            }
            case 4: {
                return pSViewTypeCatBase.isMemoDirty();
            }
            case 5: {
                return pSViewTypeCatBase.isOrderValueDirty();
            }
            case 6: {
                return pSViewTypeCatBase.isPPSViewTypeCatIdDirty();
            }
            case 7: {
                return pSViewTypeCatBase.isPPSViewTypeCatNameDirty();
            }
            case 8: {
                return pSViewTypeCatBase.isPSViewTypeCatIdDirty();
            }
            case 9: {
                return pSViewTypeCatBase.isPSViewTypeCatNameDirty();
            }
            case 10: {
                return pSViewTypeCatBase.isUpdateDateDirty();
            }
            case 11: {
                return pSViewTypeCatBase.isUpdateManDirty();
            }
            case 12: {
                return pSViewTypeCatBase.isUserCatDirty();
            }
            case 13: {
                return pSViewTypeCatBase.isUserTagDirty();
            }
            case 14: {
                return pSViewTypeCatBase.isUserTag2Dirty();
            }
            case 15: {
                return pSViewTypeCatBase.isUserTag3Dirty();
            }
            case 16: {
                return pSViewTypeCatBase.isUserTag4Dirty();
            }
            case 17: {
                return pSViewTypeCatBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewTypeCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewTypeCatBase pSViewTypeCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewTypeCatBase.getCatCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catcode", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getCatCode()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getIconPath()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getPPSViewTypeCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsviewtypecatid", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getPPSViewTypeCatId()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getPPSViewTypeCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsviewtypecatname", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getPPSViewTypeCatName()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getPSViewTypeCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypecatid", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getPSViewTypeCatId()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getPSViewTypeCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypecatname", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getPSViewTypeCatName()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSViewTypeCatBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewTypeCatBase.getJSONValue((Object)pSViewTypeCatBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewTypeCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewTypeCatBase pSViewTypeCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewTypeCatBase.getCatCode() != null) {
            object = pSViewTypeCatBase.getCatCode();
            xmlNode.setAttribute(FIELD_CATCODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getCreateDate() != null) {
            object = pSViewTypeCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeCatBase.getCreateMan() != null) {
            object = pSViewTypeCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getIconPath() != null) {
            object = pSViewTypeCatBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getMemo() != null) {
            object = pSViewTypeCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getOrderValue() != null) {
            object = pSViewTypeCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeCatBase.getPPSViewTypeCatId() != null) {
            object = pSViewTypeCatBase.getPPSViewTypeCatId();
            xmlNode.setAttribute(FIELD_PPSVIEWTYPECATID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getPPSViewTypeCatName() != null) {
            object = pSViewTypeCatBase.getPPSViewTypeCatName();
            xmlNode.setAttribute(FIELD_PPSVIEWTYPECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getPSViewTypeCatId() != null) {
            object = pSViewTypeCatBase.getPSViewTypeCatId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPECATID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getPSViewTypeCatName() != null) {
            object = pSViewTypeCatBase.getPSViewTypeCatName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUpdateDate() != null) {
            object = pSViewTypeCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeCatBase.getUpdateMan() != null) {
            object = pSViewTypeCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUserCat() != null) {
            object = pSViewTypeCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUserTag() != null) {
            object = pSViewTypeCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUserTag2() != null) {
            object = pSViewTypeCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUserTag3() != null) {
            object = pSViewTypeCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getUserTag4() != null) {
            object = pSViewTypeCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeCatBase.getValidFlag() != null) {
            object = pSViewTypeCatBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewTypeCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewTypeCatBase pSViewTypeCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewTypeCatBase.isCatCodeDirty() && (bl || pSViewTypeCatBase.getCatCode() != null)) {
            iDataObject.set(FIELD_CATCODE, (Object)pSViewTypeCatBase.getCatCode());
        }
        if (pSViewTypeCatBase.isCreateDateDirty() && (bl || pSViewTypeCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewTypeCatBase.getCreateDate());
        }
        if (pSViewTypeCatBase.isCreateManDirty() && (bl || pSViewTypeCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewTypeCatBase.getCreateMan());
        }
        if (pSViewTypeCatBase.isIconPathDirty() && (bl || pSViewTypeCatBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSViewTypeCatBase.getIconPath());
        }
        if (pSViewTypeCatBase.isMemoDirty() && (bl || pSViewTypeCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewTypeCatBase.getMemo());
        }
        if (pSViewTypeCatBase.isOrderValueDirty() && (bl || pSViewTypeCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSViewTypeCatBase.getOrderValue());
        }
        if (pSViewTypeCatBase.isPPSViewTypeCatIdDirty() && (bl || pSViewTypeCatBase.getPPSViewTypeCatId() != null)) {
            iDataObject.set(FIELD_PPSVIEWTYPECATID, (Object)pSViewTypeCatBase.getPPSViewTypeCatId());
        }
        if (pSViewTypeCatBase.isPPSViewTypeCatNameDirty() && (bl || pSViewTypeCatBase.getPPSViewTypeCatName() != null)) {
            iDataObject.set(FIELD_PPSVIEWTYPECATNAME, (Object)pSViewTypeCatBase.getPPSViewTypeCatName());
        }
        if (pSViewTypeCatBase.isPSViewTypeCatIdDirty() && (bl || pSViewTypeCatBase.getPSViewTypeCatId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPECATID, (Object)pSViewTypeCatBase.getPSViewTypeCatId());
        }
        if (pSViewTypeCatBase.isPSViewTypeCatNameDirty() && (bl || pSViewTypeCatBase.getPSViewTypeCatName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPECATNAME, (Object)pSViewTypeCatBase.getPSViewTypeCatName());
        }
        if (pSViewTypeCatBase.isUpdateDateDirty() && (bl || pSViewTypeCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewTypeCatBase.getUpdateDate());
        }
        if (pSViewTypeCatBase.isUpdateManDirty() && (bl || pSViewTypeCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewTypeCatBase.getUpdateMan());
        }
        if (pSViewTypeCatBase.isUserCatDirty() && (bl || pSViewTypeCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewTypeCatBase.getUserCat());
        }
        if (pSViewTypeCatBase.isUserTagDirty() && (bl || pSViewTypeCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewTypeCatBase.getUserTag());
        }
        if (pSViewTypeCatBase.isUserTag2Dirty() && (bl || pSViewTypeCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewTypeCatBase.getUserTag2());
        }
        if (pSViewTypeCatBase.isUserTag3Dirty() && (bl || pSViewTypeCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewTypeCatBase.getUserTag3());
        }
        if (pSViewTypeCatBase.isUserTag4Dirty() && (bl || pSViewTypeCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewTypeCatBase.getUserTag4());
        }
        if (pSViewTypeCatBase.isValidFlagDirty() && (bl || pSViewTypeCatBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewTypeCatBase.getValidFlag());
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
        return PSViewTypeCatBase.remove(this, n);
    }

    private static boolean remove(PSViewTypeCatBase pSViewTypeCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeCatBase.resetCatCode();
                return true;
            }
            case 1: {
                pSViewTypeCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSViewTypeCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSViewTypeCatBase.resetIconPath();
                return true;
            }
            case 4: {
                pSViewTypeCatBase.resetMemo();
                return true;
            }
            case 5: {
                pSViewTypeCatBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSViewTypeCatBase.resetPPSViewTypeCatId();
                return true;
            }
            case 7: {
                pSViewTypeCatBase.resetPPSViewTypeCatName();
                return true;
            }
            case 8: {
                pSViewTypeCatBase.resetPSViewTypeCatId();
                return true;
            }
            case 9: {
                pSViewTypeCatBase.resetPSViewTypeCatName();
                return true;
            }
            case 10: {
                pSViewTypeCatBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSViewTypeCatBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSViewTypeCatBase.resetUserCat();
                return true;
            }
            case 13: {
                pSViewTypeCatBase.resetUserTag();
                return true;
            }
            case 14: {
                pSViewTypeCatBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSViewTypeCatBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSViewTypeCatBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSViewTypeCatBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewTypeCat getPpsviewtypecat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpsviewtypecat();
        }
        if (this.getPPSViewTypeCatId() == null) {
            return null;
        }
        Integer n = this.objPpsviewtypecatLock;
        synchronized (n) {
            if (this.ppsviewtypecat != null && DataTypeHelper.compare((int)25, (Object)this.getPPSViewTypeCatId(), (Object)this.ppsviewtypecat.getPSViewTypeCatId()) != 0L) {
                this.ppsviewtypecat = null;
            }
            if (this.ppsviewtypecat == null) {
                PSViewTypeCat pSViewTypeCat = new PSViewTypeCat();
                pSViewTypeCat.setPSViewTypeCatId(this.getPPSViewTypeCatId());
                PSViewTypeCatService pSViewTypeCatService = (PSViewTypeCatService)ServiceGlobal.getService(PSViewTypeCatService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeCatService.autoGet(pSViewTypeCat);
                this.ppsviewtypecat = pSViewTypeCat;
            }
            return this.ppsviewtypecat;
        }
    }

    private PSViewTypeCatBase getProxyEntity() {
        return this.proxyPSViewTypeCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewTypeCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewTypeCatBase) {
            this.proxyPSViewTypeCatBase = (PSViewTypeCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATCODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PPSVIEWTYPECATID, 6);
        fieldIndexMap.put(FIELD_PPSVIEWTYPECATNAME, 7);
        fieldIndexMap.put(FIELD_PSVIEWTYPECATID, 8);
        fieldIndexMap.put(FIELD_PSVIEWTYPECATNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

