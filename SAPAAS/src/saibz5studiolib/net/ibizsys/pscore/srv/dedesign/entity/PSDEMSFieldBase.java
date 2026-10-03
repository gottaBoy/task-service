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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMSFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMSFieldBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DEFAULTVALUETYPE = "DVT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMSFIELDID = "PSDEMSFIELDID";
    public static final String FIELD_PSDEMSFIELDNAME = "PSDEMSFIELDNAME";
    public static final String FIELD_PSDEMSID = "PSDEMSID";
    public static final String FIELD_PSDEMSNAME = "PSDEMSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTVALUE = 2;
    private static final int INDEX_DEFAULTVALUETYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEFID = 5;
    private static final int INDEX_PSDEFNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDEMSFIELDID = 8;
    private static final int INDEX_PSDEMSFIELDNAME = 9;
    private static final int INDEX_PSDEMSID = 10;
    private static final int INDEX_PSDEMSNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMSFieldBase proxyPSDEMSFieldBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemsfieldidDirtyFlag = false;
    private boolean psdemsfieldnameDirtyFlag = false;
    private boolean psdemsidDirtyFlag = false;
    private boolean psdemsnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemsfieldid")
    private String psdemsfieldid;
    @Column(name="psdemsfieldname")
    private String psdemsfieldname;
    @Column(name="psdemsid")
    private String psdemsid;
    @Column(name="psdemsname")
    private String psdemsname;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEMSLock = new Integer(1);
    private PSDEMainState psdems = null;

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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setDefaultValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvaluetype = string;
        this.defaultvaluetypeDirtyFlag = true;
    }

    public String getDefaultValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValueType();
        }
        return this.defaultvaluetype;
    }

    public boolean isDefaultValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueTypeDirty();
        }
        return this.defaultvaluetypeDirtyFlag;
    }

    public void resetDefaultValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValueType();
            return;
        }
        this.defaultvaluetypeDirtyFlag = false;
        this.defaultvaluetype = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEMSFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsfieldid = string;
        this.psdemsfieldidDirtyFlag = true;
    }

    public String getPSDEMSFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSFieldId();
        }
        return this.psdemsfieldid;
    }

    public boolean isPSDEMSFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSFieldIdDirty();
        }
        return this.psdemsfieldidDirtyFlag;
    }

    public void resetPSDEMSFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSFieldId();
            return;
        }
        this.psdemsfieldidDirtyFlag = false;
        this.psdemsfieldid = null;
    }

    public void setPSDEMSFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsfieldname = string;
        this.psdemsfieldnameDirtyFlag = true;
    }

    public String getPSDEMSFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSFieldName();
        }
        return this.psdemsfieldname;
    }

    public boolean isPSDEMSFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSFieldNameDirty();
        }
        return this.psdemsfieldnameDirtyFlag;
    }

    public void resetPSDEMSFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSFieldName();
            return;
        }
        this.psdemsfieldnameDirtyFlag = false;
        this.psdemsfieldname = null;
    }

    public void setPSDEMSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsid = string;
        this.psdemsidDirtyFlag = true;
    }

    public String getPSDEMSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSId();
        }
        return this.psdemsid;
    }

    public boolean isPSDEMSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSIdDirty();
        }
        return this.psdemsidDirtyFlag;
    }

    public void resetPSDEMSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSId();
            return;
        }
        this.psdemsidDirtyFlag = false;
        this.psdemsid = null;
    }

    public void setPSDEMSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsname = string;
        this.psdemsnameDirtyFlag = true;
    }

    public String getPSDEMSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSName();
        }
        return this.psdemsname;
    }

    public boolean isPSDEMSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSNameDirty();
        }
        return this.psdemsnameDirtyFlag;
    }

    public void resetPSDEMSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSName();
            return;
        }
        this.psdemsnameDirtyFlag = false;
        this.psdemsname = null;
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
        PSDEMSFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMSFieldBase pSDEMSFieldBase) {
        pSDEMSFieldBase.resetCreateDate();
        pSDEMSFieldBase.resetCreateMan();
        pSDEMSFieldBase.resetDefaultValue();
        pSDEMSFieldBase.resetDefaultValueType();
        pSDEMSFieldBase.resetMemo();
        pSDEMSFieldBase.resetPSDEFId();
        pSDEMSFieldBase.resetPSDEFName();
        pSDEMSFieldBase.resetPSDEId();
        pSDEMSFieldBase.resetPSDEMSFieldId();
        pSDEMSFieldBase.resetPSDEMSFieldName();
        pSDEMSFieldBase.resetPSDEMSId();
        pSDEMSFieldBase.resetPSDEMSName();
        pSDEMSFieldBase.resetUpdateDate();
        pSDEMSFieldBase.resetUpdateMan();
        pSDEMSFieldBase.resetUserCat();
        pSDEMSFieldBase.resetUserTag();
        pSDEMSFieldBase.resetUserTag2();
        pSDEMSFieldBase.resetUserTag3();
        pSDEMSFieldBase.resetUserTag4();
        pSDEMSFieldBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMSFieldIdDirty()) {
            hashMap.put(FIELD_PSDEMSFIELDID, this.getPSDEMSFieldId());
        }
        if (!bl || this.isPSDEMSFieldNameDirty()) {
            hashMap.put(FIELD_PSDEMSFIELDNAME, this.getPSDEMSFieldName());
        }
        if (!bl || this.isPSDEMSIdDirty()) {
            hashMap.put(FIELD_PSDEMSID, this.getPSDEMSId());
        }
        if (!bl || this.isPSDEMSNameDirty()) {
            hashMap.put(FIELD_PSDEMSNAME, this.getPSDEMSName());
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
        return PSDEMSFieldBase.get(this, n);
    }

    private static Object get(PSDEMSFieldBase pSDEMSFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSFieldBase.getCreateDate();
            }
            case 1: {
                return pSDEMSFieldBase.getCreateMan();
            }
            case 2: {
                return pSDEMSFieldBase.getDefaultValue();
            }
            case 3: {
                return pSDEMSFieldBase.getDefaultValueType();
            }
            case 4: {
                return pSDEMSFieldBase.getMemo();
            }
            case 5: {
                return pSDEMSFieldBase.getPSDEFId();
            }
            case 6: {
                return pSDEMSFieldBase.getPSDEFName();
            }
            case 7: {
                return pSDEMSFieldBase.getPSDEId();
            }
            case 8: {
                return pSDEMSFieldBase.getPSDEMSFieldId();
            }
            case 9: {
                return pSDEMSFieldBase.getPSDEMSFieldName();
            }
            case 10: {
                return pSDEMSFieldBase.getPSDEMSId();
            }
            case 11: {
                return pSDEMSFieldBase.getPSDEMSName();
            }
            case 12: {
                return pSDEMSFieldBase.getUpdateDate();
            }
            case 13: {
                return pSDEMSFieldBase.getUpdateMan();
            }
            case 14: {
                return pSDEMSFieldBase.getUserCat();
            }
            case 15: {
                return pSDEMSFieldBase.getUserTag();
            }
            case 16: {
                return pSDEMSFieldBase.getUserTag2();
            }
            case 17: {
                return pSDEMSFieldBase.getUserTag3();
            }
            case 18: {
                return pSDEMSFieldBase.getUserTag4();
            }
            case 19: {
                return pSDEMSFieldBase.getValidFlag();
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
        PSDEMSFieldBase.set(this, n, object);
    }

    private static void set(PSDEMSFieldBase pSDEMSFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMSFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMSFieldBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMSFieldBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMSFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMSFieldBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMSFieldBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMSFieldBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMSFieldBase.setPSDEMSFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMSFieldBase.setPSDEMSFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMSFieldBase.setPSDEMSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMSFieldBase.setPSDEMSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMSFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDEMSFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMSFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMSFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMSFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMSFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMSFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMSFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMSFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMSFieldBase pSDEMSFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSFieldBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMSFieldBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMSFieldBase.getDefaultValue() == null;
            }
            case 3: {
                return pSDEMSFieldBase.getDefaultValueType() == null;
            }
            case 4: {
                return pSDEMSFieldBase.getMemo() == null;
            }
            case 5: {
                return pSDEMSFieldBase.getPSDEFId() == null;
            }
            case 6: {
                return pSDEMSFieldBase.getPSDEFName() == null;
            }
            case 7: {
                return pSDEMSFieldBase.getPSDEId() == null;
            }
            case 8: {
                return pSDEMSFieldBase.getPSDEMSFieldId() == null;
            }
            case 9: {
                return pSDEMSFieldBase.getPSDEMSFieldName() == null;
            }
            case 10: {
                return pSDEMSFieldBase.getPSDEMSId() == null;
            }
            case 11: {
                return pSDEMSFieldBase.getPSDEMSName() == null;
            }
            case 12: {
                return pSDEMSFieldBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDEMSFieldBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDEMSFieldBase.getUserCat() == null;
            }
            case 15: {
                return pSDEMSFieldBase.getUserTag() == null;
            }
            case 16: {
                return pSDEMSFieldBase.getUserTag2() == null;
            }
            case 17: {
                return pSDEMSFieldBase.getUserTag3() == null;
            }
            case 18: {
                return pSDEMSFieldBase.getUserTag4() == null;
            }
            case 19: {
                return pSDEMSFieldBase.getValidFlag() == null;
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
        return PSDEMSFieldBase.contains(this, n);
    }

    private static boolean contains(PSDEMSFieldBase pSDEMSFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSFieldBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMSFieldBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMSFieldBase.isDefaultValueDirty();
            }
            case 3: {
                return pSDEMSFieldBase.isDefaultValueTypeDirty();
            }
            case 4: {
                return pSDEMSFieldBase.isMemoDirty();
            }
            case 5: {
                return pSDEMSFieldBase.isPSDEFIdDirty();
            }
            case 6: {
                return pSDEMSFieldBase.isPSDEFNameDirty();
            }
            case 7: {
                return pSDEMSFieldBase.isPSDEIdDirty();
            }
            case 8: {
                return pSDEMSFieldBase.isPSDEMSFieldIdDirty();
            }
            case 9: {
                return pSDEMSFieldBase.isPSDEMSFieldNameDirty();
            }
            case 10: {
                return pSDEMSFieldBase.isPSDEMSIdDirty();
            }
            case 11: {
                return pSDEMSFieldBase.isPSDEMSNameDirty();
            }
            case 12: {
                return pSDEMSFieldBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDEMSFieldBase.isUpdateManDirty();
            }
            case 14: {
                return pSDEMSFieldBase.isUserCatDirty();
            }
            case 15: {
                return pSDEMSFieldBase.isUserTagDirty();
            }
            case 16: {
                return pSDEMSFieldBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDEMSFieldBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDEMSFieldBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDEMSFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMSFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMSFieldBase pSDEMSFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMSFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvt", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsfieldid", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEMSFieldId()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsfieldname", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEMSFieldName()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsid", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEMSId()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsname", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getPSDEMSName()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMSFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMSFieldBase.getJSONValue((Object)pSDEMSFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMSFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMSFieldBase pSDEMSFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMSFieldBase.getCreateDate() != null) {
            object = pSDEMSFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSFieldBase.getCreateMan() != null) {
            object = pSDEMSFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getDefaultValue() != null) {
            object = pSDEMSFieldBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getDefaultValueType() != null) {
            object = pSDEMSFieldBase.getDefaultValueType();
            xmlNode.setAttribute("DEFAULTVALUETYPE", object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getMemo() != null) {
            object = pSDEMSFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEFId() != null) {
            object = pSDEMSFieldBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEFName() != null) {
            object = pSDEMSFieldBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEId() != null) {
            object = pSDEMSFieldBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSFieldId() != null) {
            object = pSDEMSFieldBase.getPSDEMSFieldId();
            xmlNode.setAttribute(FIELD_PSDEMSFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSFieldName() != null) {
            object = pSDEMSFieldBase.getPSDEMSFieldName();
            xmlNode.setAttribute(FIELD_PSDEMSFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSId() != null) {
            object = pSDEMSFieldBase.getPSDEMSId();
            xmlNode.setAttribute(FIELD_PSDEMSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getPSDEMSName() != null) {
            object = pSDEMSFieldBase.getPSDEMSName();
            xmlNode.setAttribute(FIELD_PSDEMSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUpdateDate() != null) {
            object = pSDEMSFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSFieldBase.getUpdateMan() != null) {
            object = pSDEMSFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUserCat() != null) {
            object = pSDEMSFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUserTag() != null) {
            object = pSDEMSFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUserTag2() != null) {
            object = pSDEMSFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUserTag3() != null) {
            object = pSDEMSFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getUserTag4() != null) {
            object = pSDEMSFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSFieldBase.getValidFlag() != null) {
            object = pSDEMSFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMSFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMSFieldBase pSDEMSFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMSFieldBase.isCreateDateDirty() && (bl || pSDEMSFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMSFieldBase.getCreateDate());
        }
        if (pSDEMSFieldBase.isCreateManDirty() && (bl || pSDEMSFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMSFieldBase.getCreateMan());
        }
        if (pSDEMSFieldBase.isDefaultValueDirty() && (bl || pSDEMSFieldBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDEMSFieldBase.getDefaultValue());
        }
        if (pSDEMSFieldBase.isDefaultValueTypeDirty() && (bl || pSDEMSFieldBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSDEMSFieldBase.getDefaultValueType());
        }
        if (pSDEMSFieldBase.isMemoDirty() && (bl || pSDEMSFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMSFieldBase.getMemo());
        }
        if (pSDEMSFieldBase.isPSDEFIdDirty() && (bl || pSDEMSFieldBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEMSFieldBase.getPSDEFId());
        }
        if (pSDEMSFieldBase.isPSDEFNameDirty() && (bl || pSDEMSFieldBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEMSFieldBase.getPSDEFName());
        }
        if (pSDEMSFieldBase.isPSDEIdDirty() && (bl || pSDEMSFieldBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMSFieldBase.getPSDEId());
        }
        if (pSDEMSFieldBase.isPSDEMSFieldIdDirty() && (bl || pSDEMSFieldBase.getPSDEMSFieldId() != null)) {
            iDataObject.set(FIELD_PSDEMSFIELDID, (Object)pSDEMSFieldBase.getPSDEMSFieldId());
        }
        if (pSDEMSFieldBase.isPSDEMSFieldNameDirty() && (bl || pSDEMSFieldBase.getPSDEMSFieldName() != null)) {
            iDataObject.set(FIELD_PSDEMSFIELDNAME, (Object)pSDEMSFieldBase.getPSDEMSFieldName());
        }
        if (pSDEMSFieldBase.isPSDEMSIdDirty() && (bl || pSDEMSFieldBase.getPSDEMSId() != null)) {
            iDataObject.set(FIELD_PSDEMSID, (Object)pSDEMSFieldBase.getPSDEMSId());
        }
        if (pSDEMSFieldBase.isPSDEMSNameDirty() && (bl || pSDEMSFieldBase.getPSDEMSName() != null)) {
            iDataObject.set(FIELD_PSDEMSNAME, (Object)pSDEMSFieldBase.getPSDEMSName());
        }
        if (pSDEMSFieldBase.isUpdateDateDirty() && (bl || pSDEMSFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMSFieldBase.getUpdateDate());
        }
        if (pSDEMSFieldBase.isUpdateManDirty() && (bl || pSDEMSFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMSFieldBase.getUpdateMan());
        }
        if (pSDEMSFieldBase.isUserCatDirty() && (bl || pSDEMSFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMSFieldBase.getUserCat());
        }
        if (pSDEMSFieldBase.isUserTagDirty() && (bl || pSDEMSFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMSFieldBase.getUserTag());
        }
        if (pSDEMSFieldBase.isUserTag2Dirty() && (bl || pSDEMSFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMSFieldBase.getUserTag2());
        }
        if (pSDEMSFieldBase.isUserTag3Dirty() && (bl || pSDEMSFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMSFieldBase.getUserTag3());
        }
        if (pSDEMSFieldBase.isUserTag4Dirty() && (bl || pSDEMSFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMSFieldBase.getUserTag4());
        }
        if (pSDEMSFieldBase.isValidFlagDirty() && (bl || pSDEMSFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMSFieldBase.getValidFlag());
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
        return PSDEMSFieldBase.remove(this, n);
    }

    private static boolean remove(PSDEMSFieldBase pSDEMSFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSFieldBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMSFieldBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMSFieldBase.resetDefaultValue();
                return true;
            }
            case 3: {
                pSDEMSFieldBase.resetDefaultValueType();
                return true;
            }
            case 4: {
                pSDEMSFieldBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEMSFieldBase.resetPSDEFId();
                return true;
            }
            case 6: {
                pSDEMSFieldBase.resetPSDEFName();
                return true;
            }
            case 7: {
                pSDEMSFieldBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSDEMSFieldBase.resetPSDEMSFieldId();
                return true;
            }
            case 9: {
                pSDEMSFieldBase.resetPSDEMSFieldName();
                return true;
            }
            case 10: {
                pSDEMSFieldBase.resetPSDEMSId();
                return true;
            }
            case 11: {
                pSDEMSFieldBase.resetPSDEMSName();
                return true;
            }
            case 12: {
                pSDEMSFieldBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDEMSFieldBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDEMSFieldBase.resetUserCat();
                return true;
            }
            case 15: {
                pSDEMSFieldBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDEMSFieldBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDEMSFieldBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDEMSFieldBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDEMSFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMS();
        }
        if (this.getPSDEMSId() == null) {
            return null;
        }
        Integer n = this.objPSDEMSLock;
        synchronized (n) {
            if (this.psdems != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMSId(), (Object)this.psdems.getPSDEMainStateId()) != 0L) {
                this.psdems = null;
            }
            if (this.psdems == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMSId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdems = pSDEMainState;
            }
            return this.psdems;
        }
    }

    private PSDEMSFieldBase getProxyEntity() {
        return this.proxyPSDEMSFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMSFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMSFieldBase) {
            this.proxyPSDEMSFieldBase = (PSDEMSFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 2);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEFID, 5);
        fieldIndexMap.put(FIELD_PSDEFNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDEMSFIELDID, 8);
        fieldIndexMap.put(FIELD_PSDEMSFIELDNAME, 9);
        fieldIndexMap.put(FIELD_PSDEMSID, 10);
        fieldIndexMap.put(FIELD_PSDEMSNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

