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

public abstract class PSBookingResTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBookingResTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSBOOKINGRESTYPEID = "PSBOOKINGRESTYPEID";
    public static final String FIELD_PSBOOKINGRESTYPENAME = "PSBOOKINGRESTYPENAME";
    public static final String FIELD_RESCAT = "RESCAT";
    public static final String FIELD_TYPEHELPER = "TYPEHELPER";
    public static final String FIELD_TYPEPARAM = "TYPEPARAM";
    public static final String FIELD_TYPEPARAM2 = "TYPEPARAM2";
    public static final String FIELD_TYPEPARAM3 = "TYPEPARAM3";
    public static final String FIELD_TYPEPARAM4 = "TYPEPARAM4";
    public static final String FIELD_TYPEPARAM5 = "TYPEPARAM5";
    public static final String FIELD_TYPEPARAM6 = "TYPEPARAM6";
    public static final String FIELD_TYPEPARAM7 = "TYPEPARAM7";
    public static final String FIELD_TYPEPARAM8 = "TYPEPARAM8";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSBOOKINGRESTYPEID = 3;
    private static final int INDEX_PSBOOKINGRESTYPENAME = 4;
    private static final int INDEX_RESCAT = 5;
    private static final int INDEX_TYPEHELPER = 6;
    private static final int INDEX_TYPEPARAM = 7;
    private static final int INDEX_TYPEPARAM2 = 8;
    private static final int INDEX_TYPEPARAM3 = 9;
    private static final int INDEX_TYPEPARAM4 = 10;
    private static final int INDEX_TYPEPARAM5 = 11;
    private static final int INDEX_TYPEPARAM6 = 12;
    private static final int INDEX_TYPEPARAM7 = 13;
    private static final int INDEX_TYPEPARAM8 = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBookingResTypeBase proxyPSBookingResTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psbookingrestypeidDirtyFlag = false;
    private boolean psbookingrestypenameDirtyFlag = false;
    private boolean rescatDirtyFlag = false;
    private boolean typehelperDirtyFlag = false;
    private boolean typeparamDirtyFlag = false;
    private boolean typeparam2DirtyFlag = false;
    private boolean typeparam3DirtyFlag = false;
    private boolean typeparam4DirtyFlag = false;
    private boolean typeparam5DirtyFlag = false;
    private boolean typeparam6DirtyFlag = false;
    private boolean typeparam7DirtyFlag = false;
    private boolean typeparam8DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psbookingrestypeid")
    private String psbookingrestypeid;
    @Column(name="psbookingrestypename")
    private String psbookingrestypename;
    @Column(name="rescat")
    private String rescat;
    @Column(name="typehelper")
    private String typehelper;
    @Column(name="typeparam")
    private String typeparam;
    @Column(name="typeparam2")
    private String typeparam2;
    @Column(name="typeparam3")
    private String typeparam3;
    @Column(name="typeparam4")
    private String typeparam4;
    @Column(name="typeparam5")
    private String typeparam5;
    @Column(name="typeparam6")
    private String typeparam6;
    @Column(name="typeparam7")
    private String typeparam7;
    @Column(name="typeparam8")
    private String typeparam8;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setPSBookingResTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBookingResTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbookingrestypeid = string;
        this.psbookingrestypeidDirtyFlag = true;
    }

    public String getPSBookingResTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBookingResTypeId();
        }
        return this.psbookingrestypeid;
    }

    public boolean isPSBookingResTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBookingResTypeIdDirty();
        }
        return this.psbookingrestypeidDirtyFlag;
    }

    public void resetPSBookingResTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBookingResTypeId();
            return;
        }
        this.psbookingrestypeidDirtyFlag = false;
        this.psbookingrestypeid = null;
    }

    public void setPSBookingResTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBookingResTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbookingrestypename = string;
        this.psbookingrestypenameDirtyFlag = true;
    }

    public String getPSBookingResTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBookingResTypeName();
        }
        return this.psbookingrestypename;
    }

    public boolean isPSBookingResTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBookingResTypeNameDirty();
        }
        return this.psbookingrestypenameDirtyFlag;
    }

    public void resetPSBookingResTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBookingResTypeName();
            return;
        }
        this.psbookingrestypenameDirtyFlag = false;
        this.psbookingrestypename = null;
    }

    public void setResCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rescat = string;
        this.rescatDirtyFlag = true;
    }

    public String getResCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResCat();
        }
        return this.rescat;
    }

    public boolean isResCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResCatDirty();
        }
        return this.rescatDirtyFlag;
    }

    public void resetResCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResCat();
            return;
        }
        this.rescatDirtyFlag = false;
        this.rescat = null;
    }

    public void setTypeHelper(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeHelper(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typehelper = string;
        this.typehelperDirtyFlag = true;
    }

    public String getTypeHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeHelper();
        }
        return this.typehelper;
    }

    public boolean isTypeHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeHelperDirty();
        }
        return this.typehelperDirtyFlag;
    }

    public void resetTypeHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeHelper();
            return;
        }
        this.typehelperDirtyFlag = false;
        this.typehelper = null;
    }

    public void setTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam = string;
        this.typeparamDirtyFlag = true;
    }

    public String getTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam();
        }
        return this.typeparam;
    }

    public boolean isTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamDirty();
        }
        return this.typeparamDirtyFlag;
    }

    public void resetTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam();
            return;
        }
        this.typeparamDirtyFlag = false;
        this.typeparam = null;
    }

    public void setTypeParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam2 = string;
        this.typeparam2DirtyFlag = true;
    }

    public String getTypeParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam2();
        }
        return this.typeparam2;
    }

    public boolean isTypeParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam2Dirty();
        }
        return this.typeparam2DirtyFlag;
    }

    public void resetTypeParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam2();
            return;
        }
        this.typeparam2DirtyFlag = false;
        this.typeparam2 = null;
    }

    public void setTypeParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam3 = string;
        this.typeparam3DirtyFlag = true;
    }

    public String getTypeParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam3();
        }
        return this.typeparam3;
    }

    public boolean isTypeParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam3Dirty();
        }
        return this.typeparam3DirtyFlag;
    }

    public void resetTypeParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam3();
            return;
        }
        this.typeparam3DirtyFlag = false;
        this.typeparam3 = null;
    }

    public void setTypeParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam4 = string;
        this.typeparam4DirtyFlag = true;
    }

    public String getTypeParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam4();
        }
        return this.typeparam4;
    }

    public boolean isTypeParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam4Dirty();
        }
        return this.typeparam4DirtyFlag;
    }

    public void resetTypeParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam4();
            return;
        }
        this.typeparam4DirtyFlag = false;
        this.typeparam4 = null;
    }

    public void setTypeParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam5 = string;
        this.typeparam5DirtyFlag = true;
    }

    public String getTypeParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam5();
        }
        return this.typeparam5;
    }

    public boolean isTypeParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam5Dirty();
        }
        return this.typeparam5DirtyFlag;
    }

    public void resetTypeParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam5();
            return;
        }
        this.typeparam5DirtyFlag = false;
        this.typeparam5 = null;
    }

    public void setTypeParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam6 = string;
        this.typeparam6DirtyFlag = true;
    }

    public String getTypeParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam6();
        }
        return this.typeparam6;
    }

    public boolean isTypeParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam6Dirty();
        }
        return this.typeparam6DirtyFlag;
    }

    public void resetTypeParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam6();
            return;
        }
        this.typeparam6DirtyFlag = false;
        this.typeparam6 = null;
    }

    public void setTypeParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam7 = string;
        this.typeparam7DirtyFlag = true;
    }

    public String getTypeParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam7();
        }
        return this.typeparam7;
    }

    public boolean isTypeParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam7Dirty();
        }
        return this.typeparam7DirtyFlag;
    }

    public void resetTypeParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam7();
            return;
        }
        this.typeparam7DirtyFlag = false;
        this.typeparam7 = null;
    }

    public void setTypeParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam8 = string;
        this.typeparam8DirtyFlag = true;
    }

    public String getTypeParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam8();
        }
        return this.typeparam8;
    }

    public boolean isTypeParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParam8Dirty();
        }
        return this.typeparam8DirtyFlag;
    }

    public void resetTypeParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam8();
            return;
        }
        this.typeparam8DirtyFlag = false;
        this.typeparam8 = null;
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
        PSBookingResTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBookingResTypeBase pSBookingResTypeBase) {
        pSBookingResTypeBase.resetCreateDate();
        pSBookingResTypeBase.resetCreateMan();
        pSBookingResTypeBase.resetMemo();
        pSBookingResTypeBase.resetPSBookingResTypeId();
        pSBookingResTypeBase.resetPSBookingResTypeName();
        pSBookingResTypeBase.resetResCat();
        pSBookingResTypeBase.resetTypeHelper();
        pSBookingResTypeBase.resetTypeParam();
        pSBookingResTypeBase.resetTypeParam2();
        pSBookingResTypeBase.resetTypeParam3();
        pSBookingResTypeBase.resetTypeParam4();
        pSBookingResTypeBase.resetTypeParam5();
        pSBookingResTypeBase.resetTypeParam6();
        pSBookingResTypeBase.resetTypeParam7();
        pSBookingResTypeBase.resetTypeParam8();
        pSBookingResTypeBase.resetUpdateDate();
        pSBookingResTypeBase.resetUpdateMan();
        pSBookingResTypeBase.resetUserTag();
        pSBookingResTypeBase.resetUserTag2();
        pSBookingResTypeBase.resetValidFlag();
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
        if (!bl || this.isPSBookingResTypeIdDirty()) {
            hashMap.put(FIELD_PSBOOKINGRESTYPEID, this.getPSBookingResTypeId());
        }
        if (!bl || this.isPSBookingResTypeNameDirty()) {
            hashMap.put(FIELD_PSBOOKINGRESTYPENAME, this.getPSBookingResTypeName());
        }
        if (!bl || this.isResCatDirty()) {
            hashMap.put(FIELD_RESCAT, this.getResCat());
        }
        if (!bl || this.isTypeHelperDirty()) {
            hashMap.put(FIELD_TYPEHELPER, this.getTypeHelper());
        }
        if (!bl || this.isTypeParamDirty()) {
            hashMap.put(FIELD_TYPEPARAM, this.getTypeParam());
        }
        if (!bl || this.isTypeParam2Dirty()) {
            hashMap.put(FIELD_TYPEPARAM2, this.getTypeParam2());
        }
        if (!bl || this.isTypeParam3Dirty()) {
            hashMap.put(FIELD_TYPEPARAM3, this.getTypeParam3());
        }
        if (!bl || this.isTypeParam4Dirty()) {
            hashMap.put(FIELD_TYPEPARAM4, this.getTypeParam4());
        }
        if (!bl || this.isTypeParam5Dirty()) {
            hashMap.put(FIELD_TYPEPARAM5, this.getTypeParam5());
        }
        if (!bl || this.isTypeParam6Dirty()) {
            hashMap.put(FIELD_TYPEPARAM6, this.getTypeParam6());
        }
        if (!bl || this.isTypeParam7Dirty()) {
            hashMap.put(FIELD_TYPEPARAM7, this.getTypeParam7());
        }
        if (!bl || this.isTypeParam8Dirty()) {
            hashMap.put(FIELD_TYPEPARAM8, this.getTypeParam8());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSBookingResTypeBase.get(this, n);
    }

    private static Object get(PSBookingResTypeBase pSBookingResTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBookingResTypeBase.getCreateDate();
            }
            case 1: {
                return pSBookingResTypeBase.getCreateMan();
            }
            case 2: {
                return pSBookingResTypeBase.getMemo();
            }
            case 3: {
                return pSBookingResTypeBase.getPSBookingResTypeId();
            }
            case 4: {
                return pSBookingResTypeBase.getPSBookingResTypeName();
            }
            case 5: {
                return pSBookingResTypeBase.getResCat();
            }
            case 6: {
                return pSBookingResTypeBase.getTypeHelper();
            }
            case 7: {
                return pSBookingResTypeBase.getTypeParam();
            }
            case 8: {
                return pSBookingResTypeBase.getTypeParam2();
            }
            case 9: {
                return pSBookingResTypeBase.getTypeParam3();
            }
            case 10: {
                return pSBookingResTypeBase.getTypeParam4();
            }
            case 11: {
                return pSBookingResTypeBase.getTypeParam5();
            }
            case 12: {
                return pSBookingResTypeBase.getTypeParam6();
            }
            case 13: {
                return pSBookingResTypeBase.getTypeParam7();
            }
            case 14: {
                return pSBookingResTypeBase.getTypeParam8();
            }
            case 15: {
                return pSBookingResTypeBase.getUpdateDate();
            }
            case 16: {
                return pSBookingResTypeBase.getUpdateMan();
            }
            case 17: {
                return pSBookingResTypeBase.getUserTag();
            }
            case 18: {
                return pSBookingResTypeBase.getUserTag2();
            }
            case 19: {
                return pSBookingResTypeBase.getValidFlag();
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
        PSBookingResTypeBase.set(this, n, object);
    }

    private static void set(PSBookingResTypeBase pSBookingResTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBookingResTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSBookingResTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSBookingResTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBookingResTypeBase.setPSBookingResTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSBookingResTypeBase.setPSBookingResTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSBookingResTypeBase.setResCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBookingResTypeBase.setTypeHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSBookingResTypeBase.setTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSBookingResTypeBase.setTypeParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSBookingResTypeBase.setTypeParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSBookingResTypeBase.setTypeParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSBookingResTypeBase.setTypeParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSBookingResTypeBase.setTypeParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSBookingResTypeBase.setTypeParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSBookingResTypeBase.setTypeParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSBookingResTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSBookingResTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSBookingResTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSBookingResTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSBookingResTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSBookingResTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSBookingResTypeBase pSBookingResTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBookingResTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSBookingResTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSBookingResTypeBase.getMemo() == null;
            }
            case 3: {
                return pSBookingResTypeBase.getPSBookingResTypeId() == null;
            }
            case 4: {
                return pSBookingResTypeBase.getPSBookingResTypeName() == null;
            }
            case 5: {
                return pSBookingResTypeBase.getResCat() == null;
            }
            case 6: {
                return pSBookingResTypeBase.getTypeHelper() == null;
            }
            case 7: {
                return pSBookingResTypeBase.getTypeParam() == null;
            }
            case 8: {
                return pSBookingResTypeBase.getTypeParam2() == null;
            }
            case 9: {
                return pSBookingResTypeBase.getTypeParam3() == null;
            }
            case 10: {
                return pSBookingResTypeBase.getTypeParam4() == null;
            }
            case 11: {
                return pSBookingResTypeBase.getTypeParam5() == null;
            }
            case 12: {
                return pSBookingResTypeBase.getTypeParam6() == null;
            }
            case 13: {
                return pSBookingResTypeBase.getTypeParam7() == null;
            }
            case 14: {
                return pSBookingResTypeBase.getTypeParam8() == null;
            }
            case 15: {
                return pSBookingResTypeBase.getUpdateDate() == null;
            }
            case 16: {
                return pSBookingResTypeBase.getUpdateMan() == null;
            }
            case 17: {
                return pSBookingResTypeBase.getUserTag() == null;
            }
            case 18: {
                return pSBookingResTypeBase.getUserTag2() == null;
            }
            case 19: {
                return pSBookingResTypeBase.getValidFlag() == null;
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
        return PSBookingResTypeBase.contains(this, n);
    }

    private static boolean contains(PSBookingResTypeBase pSBookingResTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBookingResTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSBookingResTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSBookingResTypeBase.isMemoDirty();
            }
            case 3: {
                return pSBookingResTypeBase.isPSBookingResTypeIdDirty();
            }
            case 4: {
                return pSBookingResTypeBase.isPSBookingResTypeNameDirty();
            }
            case 5: {
                return pSBookingResTypeBase.isResCatDirty();
            }
            case 6: {
                return pSBookingResTypeBase.isTypeHelperDirty();
            }
            case 7: {
                return pSBookingResTypeBase.isTypeParamDirty();
            }
            case 8: {
                return pSBookingResTypeBase.isTypeParam2Dirty();
            }
            case 9: {
                return pSBookingResTypeBase.isTypeParam3Dirty();
            }
            case 10: {
                return pSBookingResTypeBase.isTypeParam4Dirty();
            }
            case 11: {
                return pSBookingResTypeBase.isTypeParam5Dirty();
            }
            case 12: {
                return pSBookingResTypeBase.isTypeParam6Dirty();
            }
            case 13: {
                return pSBookingResTypeBase.isTypeParam7Dirty();
            }
            case 14: {
                return pSBookingResTypeBase.isTypeParam8Dirty();
            }
            case 15: {
                return pSBookingResTypeBase.isUpdateDateDirty();
            }
            case 16: {
                return pSBookingResTypeBase.isUpdateManDirty();
            }
            case 17: {
                return pSBookingResTypeBase.isUserTagDirty();
            }
            case 18: {
                return pSBookingResTypeBase.isUserTag2Dirty();
            }
            case 19: {
                return pSBookingResTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBookingResTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBookingResTypeBase pSBookingResTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBookingResTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getPSBookingResTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbookingrestypeid", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getPSBookingResTypeId()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getPSBookingResTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbookingrestypename", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getPSBookingResTypeName()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getResCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rescat", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getResCat()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typehelper", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeHelper()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam2", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam2()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam3", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam3()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam4", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam4()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam5", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam5()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam6", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam6()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam7", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam7()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getTypeParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam8", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getTypeParam8()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSBookingResTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSBookingResTypeBase.getJSONValue((Object)pSBookingResTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBookingResTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBookingResTypeBase pSBookingResTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBookingResTypeBase.getCreateDate() != null) {
            object = pSBookingResTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBookingResTypeBase.getCreateMan() != null) {
            object = pSBookingResTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getMemo() != null) {
            object = pSBookingResTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getPSBookingResTypeId() != null) {
            object = pSBookingResTypeBase.getPSBookingResTypeId();
            xmlNode.setAttribute(FIELD_PSBOOKINGRESTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getPSBookingResTypeName() != null) {
            object = pSBookingResTypeBase.getPSBookingResTypeName();
            xmlNode.setAttribute(FIELD_PSBOOKINGRESTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getResCat() != null) {
            object = pSBookingResTypeBase.getResCat();
            xmlNode.setAttribute(FIELD_RESCAT, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeHelper() != null) {
            object = pSBookingResTypeBase.getTypeHelper();
            xmlNode.setAttribute(FIELD_TYPEHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam() != null) {
            object = pSBookingResTypeBase.getTypeParam();
            xmlNode.setAttribute(FIELD_TYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam2() != null) {
            object = pSBookingResTypeBase.getTypeParam2();
            xmlNode.setAttribute(FIELD_TYPEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam3() != null) {
            object = pSBookingResTypeBase.getTypeParam3();
            xmlNode.setAttribute(FIELD_TYPEPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam4() != null) {
            object = pSBookingResTypeBase.getTypeParam4();
            xmlNode.setAttribute(FIELD_TYPEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam5() != null) {
            object = pSBookingResTypeBase.getTypeParam5();
            xmlNode.setAttribute(FIELD_TYPEPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam6() != null) {
            object = pSBookingResTypeBase.getTypeParam6();
            xmlNode.setAttribute(FIELD_TYPEPARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam7() != null) {
            object = pSBookingResTypeBase.getTypeParam7();
            xmlNode.setAttribute(FIELD_TYPEPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getTypeParam8() != null) {
            object = pSBookingResTypeBase.getTypeParam8();
            xmlNode.setAttribute(FIELD_TYPEPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getUpdateDate() != null) {
            object = pSBookingResTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBookingResTypeBase.getUpdateMan() != null) {
            object = pSBookingResTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getUserTag() != null) {
            object = pSBookingResTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getUserTag2() != null) {
            object = pSBookingResTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSBookingResTypeBase.getValidFlag() != null) {
            object = pSBookingResTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBookingResTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBookingResTypeBase pSBookingResTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBookingResTypeBase.isCreateDateDirty() && (bl || pSBookingResTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBookingResTypeBase.getCreateDate());
        }
        if (pSBookingResTypeBase.isCreateManDirty() && (bl || pSBookingResTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBookingResTypeBase.getCreateMan());
        }
        if (pSBookingResTypeBase.isMemoDirty() && (bl || pSBookingResTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSBookingResTypeBase.getMemo());
        }
        if (pSBookingResTypeBase.isPSBookingResTypeIdDirty() && (bl || pSBookingResTypeBase.getPSBookingResTypeId() != null)) {
            iDataObject.set(FIELD_PSBOOKINGRESTYPEID, (Object)pSBookingResTypeBase.getPSBookingResTypeId());
        }
        if (pSBookingResTypeBase.isPSBookingResTypeNameDirty() && (bl || pSBookingResTypeBase.getPSBookingResTypeName() != null)) {
            iDataObject.set(FIELD_PSBOOKINGRESTYPENAME, (Object)pSBookingResTypeBase.getPSBookingResTypeName());
        }
        if (pSBookingResTypeBase.isResCatDirty() && (bl || pSBookingResTypeBase.getResCat() != null)) {
            iDataObject.set(FIELD_RESCAT, (Object)pSBookingResTypeBase.getResCat());
        }
        if (pSBookingResTypeBase.isTypeHelperDirty() && (bl || pSBookingResTypeBase.getTypeHelper() != null)) {
            iDataObject.set(FIELD_TYPEHELPER, (Object)pSBookingResTypeBase.getTypeHelper());
        }
        if (pSBookingResTypeBase.isTypeParamDirty() && (bl || pSBookingResTypeBase.getTypeParam() != null)) {
            iDataObject.set(FIELD_TYPEPARAM, (Object)pSBookingResTypeBase.getTypeParam());
        }
        if (pSBookingResTypeBase.isTypeParam2Dirty() && (bl || pSBookingResTypeBase.getTypeParam2() != null)) {
            iDataObject.set(FIELD_TYPEPARAM2, (Object)pSBookingResTypeBase.getTypeParam2());
        }
        if (pSBookingResTypeBase.isTypeParam3Dirty() && (bl || pSBookingResTypeBase.getTypeParam3() != null)) {
            iDataObject.set(FIELD_TYPEPARAM3, (Object)pSBookingResTypeBase.getTypeParam3());
        }
        if (pSBookingResTypeBase.isTypeParam4Dirty() && (bl || pSBookingResTypeBase.getTypeParam4() != null)) {
            iDataObject.set(FIELD_TYPEPARAM4, (Object)pSBookingResTypeBase.getTypeParam4());
        }
        if (pSBookingResTypeBase.isTypeParam5Dirty() && (bl || pSBookingResTypeBase.getTypeParam5() != null)) {
            iDataObject.set(FIELD_TYPEPARAM5, (Object)pSBookingResTypeBase.getTypeParam5());
        }
        if (pSBookingResTypeBase.isTypeParam6Dirty() && (bl || pSBookingResTypeBase.getTypeParam6() != null)) {
            iDataObject.set(FIELD_TYPEPARAM6, (Object)pSBookingResTypeBase.getTypeParam6());
        }
        if (pSBookingResTypeBase.isTypeParam7Dirty() && (bl || pSBookingResTypeBase.getTypeParam7() != null)) {
            iDataObject.set(FIELD_TYPEPARAM7, (Object)pSBookingResTypeBase.getTypeParam7());
        }
        if (pSBookingResTypeBase.isTypeParam8Dirty() && (bl || pSBookingResTypeBase.getTypeParam8() != null)) {
            iDataObject.set(FIELD_TYPEPARAM8, (Object)pSBookingResTypeBase.getTypeParam8());
        }
        if (pSBookingResTypeBase.isUpdateDateDirty() && (bl || pSBookingResTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBookingResTypeBase.getUpdateDate());
        }
        if (pSBookingResTypeBase.isUpdateManDirty() && (bl || pSBookingResTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBookingResTypeBase.getUpdateMan());
        }
        if (pSBookingResTypeBase.isUserTagDirty() && (bl || pSBookingResTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSBookingResTypeBase.getUserTag());
        }
        if (pSBookingResTypeBase.isUserTag2Dirty() && (bl || pSBookingResTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSBookingResTypeBase.getUserTag2());
        }
        if (pSBookingResTypeBase.isValidFlagDirty() && (bl || pSBookingResTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSBookingResTypeBase.getValidFlag());
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
        return PSBookingResTypeBase.remove(this, n);
    }

    private static boolean remove(PSBookingResTypeBase pSBookingResTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBookingResTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSBookingResTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSBookingResTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSBookingResTypeBase.resetPSBookingResTypeId();
                return true;
            }
            case 4: {
                pSBookingResTypeBase.resetPSBookingResTypeName();
                return true;
            }
            case 5: {
                pSBookingResTypeBase.resetResCat();
                return true;
            }
            case 6: {
                pSBookingResTypeBase.resetTypeHelper();
                return true;
            }
            case 7: {
                pSBookingResTypeBase.resetTypeParam();
                return true;
            }
            case 8: {
                pSBookingResTypeBase.resetTypeParam2();
                return true;
            }
            case 9: {
                pSBookingResTypeBase.resetTypeParam3();
                return true;
            }
            case 10: {
                pSBookingResTypeBase.resetTypeParam4();
                return true;
            }
            case 11: {
                pSBookingResTypeBase.resetTypeParam5();
                return true;
            }
            case 12: {
                pSBookingResTypeBase.resetTypeParam6();
                return true;
            }
            case 13: {
                pSBookingResTypeBase.resetTypeParam7();
                return true;
            }
            case 14: {
                pSBookingResTypeBase.resetTypeParam8();
                return true;
            }
            case 15: {
                pSBookingResTypeBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSBookingResTypeBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSBookingResTypeBase.resetUserTag();
                return true;
            }
            case 18: {
                pSBookingResTypeBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSBookingResTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSBookingResTypeBase getProxyEntity() {
        return this.proxyPSBookingResTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBookingResTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSBookingResTypeBase) {
            this.proxyPSBookingResTypeBase = (PSBookingResTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSBookingResTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSBOOKINGRESTYPEID, 3);
        fieldIndexMap.put(FIELD_PSBOOKINGRESTYPENAME, 4);
        fieldIndexMap.put(FIELD_RESCAT, 5);
        fieldIndexMap.put(FIELD_TYPEHELPER, 6);
        fieldIndexMap.put(FIELD_TYPEPARAM, 7);
        fieldIndexMap.put(FIELD_TYPEPARAM2, 8);
        fieldIndexMap.put(FIELD_TYPEPARAM3, 9);
        fieldIndexMap.put(FIELD_TYPEPARAM4, 10);
        fieldIndexMap.put(FIELD_TYPEPARAM5, 11);
        fieldIndexMap.put(FIELD_TYPEPARAM6, 12);
        fieldIndexMap.put(FIELD_TYPEPARAM7, 13);
        fieldIndexMap.put(FIELD_TYPEPARAM8, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

