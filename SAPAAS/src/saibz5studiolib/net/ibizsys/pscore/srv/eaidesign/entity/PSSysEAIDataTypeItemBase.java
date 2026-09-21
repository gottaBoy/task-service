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
package net.ibizsys.pscore.srv.eaidesign.entity;

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
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDataTypeItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeItemBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_EAIDATATYPEITEMTAG = "EAIDATATYPEITEMTAG";
    public static final String FIELD_EAIDATATYPEITEMTAG2 = "EAIDATATYPEITEMTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String FIELD_PSSYSEAIDATATYPEITEMID = "PSSYSEAIDATATYPEITEMID";
    public static final String FIELD_PSSYSEAIDATATYPEITEMNAME = "PSSYSEAIDATATYPEITEMNAME";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DATA = 3;
    private static final int INDEX_EAIDATATYPEITEMTAG = 4;
    private static final int INDEX_EAIDATATYPEITEMTAG2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PSSYSEAIDATATYPEID = 8;
    private static final int INDEX_PSSYSEAIDATATYPEITEMID = 9;
    private static final int INDEX_PSSYSEAIDATATYPEITEMNAME = 10;
    private static final int INDEX_PSSYSEAIDATATYPENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final int INDEX_VALUE = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIDataTypeItemBase proxyPSSysEAIDataTypeItemBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean eaidatatypeitemtagDirtyFlag = false;
    private boolean eaidatatypeitemtag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssyseaidatatypeidDirtyFlag = false;
    private boolean pssyseaidatatypeitemidDirtyFlag = false;
    private boolean pssyseaidatatypeitemnameDirtyFlag = false;
    private boolean pssyseaidatatypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="eaidatatypeitemtag")
    private String eaidatatypeitemtag;
    @Column(name="eaidatatypeitemtag2")
    private String eaidatatypeitemtag2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssyseaidatatypeid")
    private String pssyseaidatatypeid;
    @Column(name="pssyseaidatatypeitemid")
    private String pssyseaidatatypeitemid;
    @Column(name="pssyseaidatatypeitemname")
    private String pssyseaidatatypeitemname;
    @Column(name="pssyseaidatatypename")
    private String pssyseaidatatypename;
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
    @Column(name="value")
    private String value;
    private Integer objPSSysEAIDataTypeLock = new Integer(1);
    private PSSysEAIDataType pssyseaidatatype = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setEAIDataTypeItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDataTypeItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidatatypeitemtag = string;
        this.eaidatatypeitemtagDirtyFlag = true;
    }

    public String getEAIDataTypeItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDataTypeItemTag();
        }
        return this.eaidatatypeitemtag;
    }

    public boolean isEAIDataTypeItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDataTypeItemTagDirty();
        }
        return this.eaidatatypeitemtagDirtyFlag;
    }

    public void resetEAIDataTypeItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDataTypeItemTag();
            return;
        }
        this.eaidatatypeitemtagDirtyFlag = false;
        this.eaidatatypeitemtag = null;
    }

    public void setEAIDataTypeItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDataTypeItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidatatypeitemtag2 = string;
        this.eaidatatypeitemtag2DirtyFlag = true;
    }

    public String getEAIDataTypeItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDataTypeItemTag2();
        }
        return this.eaidatatypeitemtag2;
    }

    public boolean isEAIDataTypeItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDataTypeItemTag2Dirty();
        }
        return this.eaidatatypeitemtag2DirtyFlag;
    }

    public void resetEAIDataTypeItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDataTypeItemTag2();
            return;
        }
        this.eaidatatypeitemtag2DirtyFlag = false;
        this.eaidatatypeitemtag2 = null;
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

    public void setPSSysEAIDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypeid = string;
        this.pssyseaidatatypeidDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeId();
        }
        return this.pssyseaidatatypeid;
    }

    public boolean isPSSysEAIDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeIdDirty();
        }
        return this.pssyseaidatatypeidDirtyFlag;
    }

    public void resetPSSysEAIDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeId();
            return;
        }
        this.pssyseaidatatypeidDirtyFlag = false;
        this.pssyseaidatatypeid = null;
    }

    public void setPSSysEAIDataTypeItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypeitemid = string;
        this.pssyseaidatatypeitemidDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeItemId();
        }
        return this.pssyseaidatatypeitemid;
    }

    public boolean isPSSysEAIDataTypeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeItemIdDirty();
        }
        return this.pssyseaidatatypeitemidDirtyFlag;
    }

    public void resetPSSysEAIDataTypeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeItemId();
            return;
        }
        this.pssyseaidatatypeitemidDirtyFlag = false;
        this.pssyseaidatatypeitemid = null;
    }

    public void setPSSysEAIDataTypeItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypeitemname = string;
        this.pssyseaidatatypeitemnameDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeItemName();
        }
        return this.pssyseaidatatypeitemname;
    }

    public boolean isPSSysEAIDataTypeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeItemNameDirty();
        }
        return this.pssyseaidatatypeitemnameDirtyFlag;
    }

    public void resetPSSysEAIDataTypeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeItemName();
            return;
        }
        this.pssyseaidatatypeitemnameDirtyFlag = false;
        this.pssyseaidatatypeitemname = null;
    }

    public void setPSSysEAIDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypename = string;
        this.pssyseaidatatypenameDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeName();
        }
        return this.pssyseaidatatypename;
    }

    public boolean isPSSysEAIDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeNameDirty();
        }
        return this.pssyseaidatatypenameDirtyFlag;
    }

    public void resetPSSysEAIDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeName();
            return;
        }
        this.pssyseaidatatypenameDirtyFlag = false;
        this.pssyseaidatatypename = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    protected void onReset() {
        PSSysEAIDataTypeItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase) {
        pSSysEAIDataTypeItemBase.resetCodeName();
        pSSysEAIDataTypeItemBase.resetCreateDate();
        pSSysEAIDataTypeItemBase.resetCreateMan();
        pSSysEAIDataTypeItemBase.resetData();
        pSSysEAIDataTypeItemBase.resetEAIDataTypeItemTag();
        pSSysEAIDataTypeItemBase.resetEAIDataTypeItemTag2();
        pSSysEAIDataTypeItemBase.resetMemo();
        pSSysEAIDataTypeItemBase.resetOrderValue();
        pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeId();
        pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeItemId();
        pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeItemName();
        pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeName();
        pSSysEAIDataTypeItemBase.resetUpdateDate();
        pSSysEAIDataTypeItemBase.resetUpdateMan();
        pSSysEAIDataTypeItemBase.resetUserCat();
        pSSysEAIDataTypeItemBase.resetUserTag();
        pSSysEAIDataTypeItemBase.resetUserTag2();
        pSSysEAIDataTypeItemBase.resetUserTag3();
        pSSysEAIDataTypeItemBase.resetUserTag4();
        pSSysEAIDataTypeItemBase.resetValidFlag();
        pSSysEAIDataTypeItemBase.resetValue();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isEAIDataTypeItemTagDirty()) {
            hashMap.put(FIELD_EAIDATATYPEITEMTAG, this.getEAIDataTypeItemTag());
        }
        if (!bl || this.isEAIDataTypeItemTag2Dirty()) {
            hashMap.put(FIELD_EAIDATATYPEITEMTAG2, this.getEAIDataTypeItemTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysEAIDataTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPEID, this.getPSSysEAIDataTypeId());
        }
        if (!bl || this.isPSSysEAIDataTypeItemIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPEITEMID, this.getPSSysEAIDataTypeItemId());
        }
        if (!bl || this.isPSSysEAIDataTypeItemNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPEITEMNAME, this.getPSSysEAIDataTypeItemName());
        }
        if (!bl || this.isPSSysEAIDataTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPENAME, this.getPSSysEAIDataTypeName());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
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
        return PSSysEAIDataTypeItemBase.get(this, n);
    }

    private static Object get(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeItemBase.getCodeName();
            }
            case 1: {
                return pSSysEAIDataTypeItemBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIDataTypeItemBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIDataTypeItemBase.getData();
            }
            case 4: {
                return pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag();
            }
            case 5: {
                return pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2();
            }
            case 6: {
                return pSSysEAIDataTypeItemBase.getMemo();
            }
            case 7: {
                return pSSysEAIDataTypeItemBase.getOrderValue();
            }
            case 8: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId();
            }
            case 9: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId();
            }
            case 10: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName();
            }
            case 11: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName();
            }
            case 12: {
                return pSSysEAIDataTypeItemBase.getUpdateDate();
            }
            case 13: {
                return pSSysEAIDataTypeItemBase.getUpdateMan();
            }
            case 14: {
                return pSSysEAIDataTypeItemBase.getUserCat();
            }
            case 15: {
                return pSSysEAIDataTypeItemBase.getUserTag();
            }
            case 16: {
                return pSSysEAIDataTypeItemBase.getUserTag2();
            }
            case 17: {
                return pSSysEAIDataTypeItemBase.getUserTag3();
            }
            case 18: {
                return pSSysEAIDataTypeItemBase.getUserTag4();
            }
            case 19: {
                return pSSysEAIDataTypeItemBase.getValidFlag();
            }
            case 20: {
                return pSSysEAIDataTypeItemBase.getValue();
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
        PSSysEAIDataTypeItemBase.set(this, n, object);
    }

    private static void set(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDataTypeItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIDataTypeItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIDataTypeItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIDataTypeItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIDataTypeItemBase.setEAIDataTypeItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIDataTypeItemBase.setEAIDataTypeItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIDataTypeItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIDataTypeItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIDataTypeItemBase.setPSSysEAIDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIDataTypeItemBase.setPSSysEAIDataTypeItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIDataTypeItemBase.setPSSysEAIDataTypeItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIDataTypeItemBase.setPSSysEAIDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIDataTypeItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIDataTypeItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIDataTypeItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIDataTypeItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIDataTypeItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIDataTypeItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIDataTypeItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIDataTypeItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIDataTypeItemBase.setValue(DataObject.getStringValue((Object)object));
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
        return PSSysEAIDataTypeItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeItemBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIDataTypeItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIDataTypeItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIDataTypeItemBase.getData() == null;
            }
            case 4: {
                return pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag() == null;
            }
            case 5: {
                return pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2() == null;
            }
            case 6: {
                return pSSysEAIDataTypeItemBase.getMemo() == null;
            }
            case 7: {
                return pSSysEAIDataTypeItemBase.getOrderValue() == null;
            }
            case 8: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId() == null;
            }
            case 9: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId() == null;
            }
            case 10: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName() == null;
            }
            case 11: {
                return pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName() == null;
            }
            case 12: {
                return pSSysEAIDataTypeItemBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysEAIDataTypeItemBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysEAIDataTypeItemBase.getUserCat() == null;
            }
            case 15: {
                return pSSysEAIDataTypeItemBase.getUserTag() == null;
            }
            case 16: {
                return pSSysEAIDataTypeItemBase.getUserTag2() == null;
            }
            case 17: {
                return pSSysEAIDataTypeItemBase.getUserTag3() == null;
            }
            case 18: {
                return pSSysEAIDataTypeItemBase.getUserTag4() == null;
            }
            case 19: {
                return pSSysEAIDataTypeItemBase.getValidFlag() == null;
            }
            case 20: {
                return pSSysEAIDataTypeItemBase.getValue() == null;
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
        return PSSysEAIDataTypeItemBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeItemBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIDataTypeItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIDataTypeItemBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIDataTypeItemBase.isDataDirty();
            }
            case 4: {
                return pSSysEAIDataTypeItemBase.isEAIDataTypeItemTagDirty();
            }
            case 5: {
                return pSSysEAIDataTypeItemBase.isEAIDataTypeItemTag2Dirty();
            }
            case 6: {
                return pSSysEAIDataTypeItemBase.isMemoDirty();
            }
            case 7: {
                return pSSysEAIDataTypeItemBase.isOrderValueDirty();
            }
            case 8: {
                return pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeIdDirty();
            }
            case 9: {
                return pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeItemIdDirty();
            }
            case 10: {
                return pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeItemNameDirty();
            }
            case 11: {
                return pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeNameDirty();
            }
            case 12: {
                return pSSysEAIDataTypeItemBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysEAIDataTypeItemBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysEAIDataTypeItemBase.isUserCatDirty();
            }
            case 15: {
                return pSSysEAIDataTypeItemBase.isUserTagDirty();
            }
            case 16: {
                return pSSysEAIDataTypeItemBase.isUserTag2Dirty();
            }
            case 17: {
                return pSSysEAIDataTypeItemBase.isUserTag3Dirty();
            }
            case 18: {
                return pSSysEAIDataTypeItemBase.isUserTag4Dirty();
            }
            case 19: {
                return pSSysEAIDataTypeItemBase.isValidFlagDirty();
            }
            case 20: {
                return pSSysEAIDataTypeItemBase.isValueDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIDataTypeItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIDataTypeItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getData()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidatatypeitemtag", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidatatypeitemtag2", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeid", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeitemid", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeitemname", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypename", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeItemBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSSysEAIDataTypeItemBase.getJSONValue((Object)pSSysEAIDataTypeItemBase.getValue()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIDataTypeItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIDataTypeItemBase.getCodeName() != null) {
            object = pSSysEAIDataTypeItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getCreateDate() != null) {
            object = pSSysEAIDataTypeItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDataTypeItemBase.getCreateMan() != null) {
            object = pSSysEAIDataTypeItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getData() != null) {
            object = pSSysEAIDataTypeItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag() != null) {
            object = pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag();
            xmlNode.setAttribute(FIELD_EAIDATATYPEITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2() != null) {
            object = pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2();
            xmlNode.setAttribute(FIELD_EAIDATATYPEITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getMemo() != null) {
            object = pSSysEAIDataTypeItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getOrderValue() != null) {
            object = pSSysEAIDataTypeItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId() != null) {
            object = pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId() != null) {
            object = pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName() != null) {
            object = pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName() != null) {
            object = pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUpdateDate() != null) {
            object = pSSysEAIDataTypeItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDataTypeItemBase.getUpdateMan() != null) {
            object = pSSysEAIDataTypeItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserCat() != null) {
            object = pSSysEAIDataTypeItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag() != null) {
            object = pSSysEAIDataTypeItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag2() != null) {
            object = pSSysEAIDataTypeItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag3() != null) {
            object = pSSysEAIDataTypeItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getUserTag4() != null) {
            object = pSSysEAIDataTypeItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeItemBase.getValidFlag() != null) {
            object = pSSysEAIDataTypeItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeItemBase.getValue() != null) {
            object = pSSysEAIDataTypeItemBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIDataTypeItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIDataTypeItemBase.isCodeNameDirty() && (bl || pSSysEAIDataTypeItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIDataTypeItemBase.getCodeName());
        }
        if (pSSysEAIDataTypeItemBase.isCreateDateDirty() && (bl || pSSysEAIDataTypeItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIDataTypeItemBase.getCreateDate());
        }
        if (pSSysEAIDataTypeItemBase.isCreateManDirty() && (bl || pSSysEAIDataTypeItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIDataTypeItemBase.getCreateMan());
        }
        if (pSSysEAIDataTypeItemBase.isDataDirty() && (bl || pSSysEAIDataTypeItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysEAIDataTypeItemBase.getData());
        }
        if (pSSysEAIDataTypeItemBase.isEAIDataTypeItemTagDirty() && (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag() != null)) {
            iDataObject.set(FIELD_EAIDATATYPEITEMTAG, (Object)pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag());
        }
        if (pSSysEAIDataTypeItemBase.isEAIDataTypeItemTag2Dirty() && (bl || pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2() != null)) {
            iDataObject.set(FIELD_EAIDATATYPEITEMTAG2, (Object)pSSysEAIDataTypeItemBase.getEAIDataTypeItemTag2());
        }
        if (pSSysEAIDataTypeItemBase.isMemoDirty() && (bl || pSSysEAIDataTypeItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIDataTypeItemBase.getMemo());
        }
        if (pSSysEAIDataTypeItemBase.isOrderValueDirty() && (bl || pSSysEAIDataTypeItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysEAIDataTypeItemBase.getOrderValue());
        }
        if (pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeIdDirty() && (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEID, (Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeId());
        }
        if (pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeItemIdDirty() && (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEITEMID, (Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemId());
        }
        if (pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeItemNameDirty() && (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEITEMNAME, (Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeItemName());
        }
        if (pSSysEAIDataTypeItemBase.isPSSysEAIDataTypeNameDirty() && (bl || pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPENAME, (Object)pSSysEAIDataTypeItemBase.getPSSysEAIDataTypeName());
        }
        if (pSSysEAIDataTypeItemBase.isUpdateDateDirty() && (bl || pSSysEAIDataTypeItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIDataTypeItemBase.getUpdateDate());
        }
        if (pSSysEAIDataTypeItemBase.isUpdateManDirty() && (bl || pSSysEAIDataTypeItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIDataTypeItemBase.getUpdateMan());
        }
        if (pSSysEAIDataTypeItemBase.isUserCatDirty() && (bl || pSSysEAIDataTypeItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIDataTypeItemBase.getUserCat());
        }
        if (pSSysEAIDataTypeItemBase.isUserTagDirty() && (bl || pSSysEAIDataTypeItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIDataTypeItemBase.getUserTag());
        }
        if (pSSysEAIDataTypeItemBase.isUserTag2Dirty() && (bl || pSSysEAIDataTypeItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIDataTypeItemBase.getUserTag2());
        }
        if (pSSysEAIDataTypeItemBase.isUserTag3Dirty() && (bl || pSSysEAIDataTypeItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIDataTypeItemBase.getUserTag3());
        }
        if (pSSysEAIDataTypeItemBase.isUserTag4Dirty() && (bl || pSSysEAIDataTypeItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIDataTypeItemBase.getUserTag4());
        }
        if (pSSysEAIDataTypeItemBase.isValidFlagDirty() && (bl || pSSysEAIDataTypeItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIDataTypeItemBase.getValidFlag());
        }
        if (pSSysEAIDataTypeItemBase.isValueDirty() && (bl || pSSysEAIDataTypeItemBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSSysEAIDataTypeItemBase.getValue());
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
        return PSSysEAIDataTypeItemBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIDataTypeItemBase pSSysEAIDataTypeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDataTypeItemBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIDataTypeItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIDataTypeItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIDataTypeItemBase.resetData();
                return true;
            }
            case 4: {
                pSSysEAIDataTypeItemBase.resetEAIDataTypeItemTag();
                return true;
            }
            case 5: {
                pSSysEAIDataTypeItemBase.resetEAIDataTypeItemTag2();
                return true;
            }
            case 6: {
                pSSysEAIDataTypeItemBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysEAIDataTypeItemBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeId();
                return true;
            }
            case 9: {
                pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeItemId();
                return true;
            }
            case 10: {
                pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeItemName();
                return true;
            }
            case 11: {
                pSSysEAIDataTypeItemBase.resetPSSysEAIDataTypeName();
                return true;
            }
            case 12: {
                pSSysEAIDataTypeItemBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysEAIDataTypeItemBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysEAIDataTypeItemBase.resetUserCat();
                return true;
            }
            case 15: {
                pSSysEAIDataTypeItemBase.resetUserTag();
                return true;
            }
            case 16: {
                pSSysEAIDataTypeItemBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSSysEAIDataTypeItemBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSSysEAIDataTypeItemBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSSysEAIDataTypeItemBase.resetValidFlag();
                return true;
            }
            case 20: {
                pSSysEAIDataTypeItemBase.resetValue();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIDataType getPSSysEAIDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataType();
        }
        if (this.getPSSysEAIDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIDataTypeLock;
        synchronized (n) {
            if (this.pssyseaidatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIDataTypeId(), (Object)this.pssyseaidatatype.getPSSysEAIDataTypeId()) != 0L) {
                this.pssyseaidatatype = null;
            }
            if (this.pssyseaidatatype == null) {
                PSSysEAIDataType pSSysEAIDataType = new PSSysEAIDataType();
                pSSysEAIDataType.setPSSysEAIDataTypeId(this.getPSSysEAIDataTypeId());
                PSSysEAIDataTypeService pSSysEAIDataTypeService = (PSSysEAIDataTypeService)ServiceGlobal.getService(PSSysEAIDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIDataTypeService.autoGet((IEntity)pSSysEAIDataType);
                this.pssyseaidatatype = pSSysEAIDataType;
            }
            return this.pssyseaidatatype;
        }
    }

    private PSSysEAIDataTypeItemBase getProxyEntity() {
        return this.proxyPSSysEAIDataTypeItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIDataTypeItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIDataTypeItemBase) {
            this.proxyPSSysEAIDataTypeItemBase = (PSSysEAIDataTypeItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DATA, 3);
        fieldIndexMap.put(FIELD_EAIDATATYPEITEMTAG, 4);
        fieldIndexMap.put(FIELD_EAIDATATYPEITEMTAG2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEID, 8);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEITEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
        fieldIndexMap.put(FIELD_VALUE, 20);
    }
}

