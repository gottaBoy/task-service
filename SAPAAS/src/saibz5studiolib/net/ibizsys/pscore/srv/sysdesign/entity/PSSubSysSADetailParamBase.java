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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADetailParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSADetailParamBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String FIELD_PSSUBSYSSADETAILPARAMID = "PSSUBSYSSADETAILPARAMID";
    public static final String FIELD_PSSUBSYSSADETAILPARAMNAME = "PSSUBSYSSADETAILPARAMNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ARRAYFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PARAMTAG = 6;
    private static final int INDEX_PARAMTAG2 = 7;
    private static final int INDEX_PSSUBSYSSADETAILID = 8;
    private static final int INDEX_PSSUBSYSSADETAILNAME = 9;
    private static final int INDEX_PSSUBSYSSADETAILPARAMID = 10;
    private static final int INDEX_PSSUBSYSSADETAILPARAMNAME = 11;
    private static final int INDEX_STDDATATYPE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSADetailParamBase proxyPSSubSysSADetailParamBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean pssubsyssadetailidDirtyFlag = false;
    private boolean pssubsyssadetailnameDirtyFlag = false;
    private boolean pssubsyssadetailparamidDirtyFlag = false;
    private boolean pssubsyssadetailparamnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramtag")
    private String paramtag;
    @Column(name="paramtag2")
    private String paramtag2;
    @Column(name="pssubsyssadetailid")
    private String pssubsyssadetailid;
    @Column(name="pssubsyssadetailname")
    private String pssubsyssadetailname;
    @Column(name="pssubsyssadetailparamid")
    private String pssubsyssadetailparamid;
    @Column(name="pssubsyssadetailparamname")
    private String pssubsyssadetailparamname;
    @Column(name="stddatatype")
    private Integer stddatatype;
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
    private Integer objPSSubSysSADetailLock = new Integer(1);
    private PSSubSysSADetail pssubsyssadetail = null;

    public void setArrayFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArrayFlag(n);
            return;
        }
        this.arrayflag = n;
        this.arrayflagDirtyFlag = true;
    }

    public Integer getArrayFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArrayFlag();
        }
        return this.arrayflag;
    }

    public boolean isArrayFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArrayFlagDirty();
        }
        return this.arrayflagDirtyFlag;
    }

    public void resetArrayFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArrayFlag();
            return;
        }
        this.arrayflagDirtyFlag = false;
        this.arrayflag = null;
    }

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

    public void setParamTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag = string;
        this.paramtagDirtyFlag = true;
    }

    public String getParamTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag();
        }
        return this.paramtag;
    }

    public boolean isParamTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTagDirty();
        }
        return this.paramtagDirtyFlag;
    }

    public void resetParamTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag();
            return;
        }
        this.paramtagDirtyFlag = false;
        this.paramtag = null;
    }

    public void setParamTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag2 = string;
        this.paramtag2DirtyFlag = true;
    }

    public String getParamTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag2();
        }
        return this.paramtag2;
    }

    public boolean isParamTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTag2Dirty();
        }
        return this.paramtag2DirtyFlag;
    }

    public void resetParamTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag2();
            return;
        }
        this.paramtag2DirtyFlag = false;
        this.paramtag2 = null;
    }

    public void setPSSubSysSADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailid = string;
        this.pssubsyssadetailidDirtyFlag = true;
    }

    public String getPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailId();
        }
        return this.pssubsyssadetailid;
    }

    public boolean isPSSubSysSADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailIdDirty();
        }
        return this.pssubsyssadetailidDirtyFlag;
    }

    public void resetPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailId();
            return;
        }
        this.pssubsyssadetailidDirtyFlag = false;
        this.pssubsyssadetailid = null;
    }

    public void setPSSubSysSADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailname = string;
        this.pssubsyssadetailnameDirtyFlag = true;
    }

    public String getPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailName();
        }
        return this.pssubsyssadetailname;
    }

    public boolean isPSSubSysSADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailNameDirty();
        }
        return this.pssubsyssadetailnameDirtyFlag;
    }

    public void resetPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailName();
            return;
        }
        this.pssubsyssadetailnameDirtyFlag = false;
        this.pssubsyssadetailname = null;
    }

    public void setPSSubSysSADetailParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailparamid = string;
        this.pssubsyssadetailparamidDirtyFlag = true;
    }

    public String getPSSubSysSADetailParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailParamId();
        }
        return this.pssubsyssadetailparamid;
    }

    public boolean isPSSubSysSADetailParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailParamIdDirty();
        }
        return this.pssubsyssadetailparamidDirtyFlag;
    }

    public void resetPSSubSysSADetailParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailParamId();
            return;
        }
        this.pssubsyssadetailparamidDirtyFlag = false;
        this.pssubsyssadetailparamid = null;
    }

    public void setPSSubSysSADetailParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailparamname = string;
        this.pssubsyssadetailparamnameDirtyFlag = true;
    }

    public String getPSSubSysSADetailParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailParamName();
        }
        return this.pssubsyssadetailparamname;
    }

    public boolean isPSSubSysSADetailParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailParamNameDirty();
        }
        return this.pssubsyssadetailparamnameDirtyFlag;
    }

    public void resetPSSubSysSADetailParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailParamName();
            return;
        }
        this.pssubsyssadetailparamnameDirtyFlag = false;
        this.pssubsyssadetailparamname = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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
        PSSubSysSADetailParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSADetailParamBase pSSubSysSADetailParamBase) {
        pSSubSysSADetailParamBase.resetArrayFlag();
        pSSubSysSADetailParamBase.resetCodeName();
        pSSubSysSADetailParamBase.resetCreateDate();
        pSSubSysSADetailParamBase.resetCreateMan();
        pSSubSysSADetailParamBase.resetMemo();
        pSSubSysSADetailParamBase.resetOrderValue();
        pSSubSysSADetailParamBase.resetParamTag();
        pSSubSysSADetailParamBase.resetParamTag2();
        pSSubSysSADetailParamBase.resetPSSubSysSADetailId();
        pSSubSysSADetailParamBase.resetPSSubSysSADetailName();
        pSSubSysSADetailParamBase.resetPSSubSysSADetailParamId();
        pSSubSysSADetailParamBase.resetPSSubSysSADetailParamName();
        pSSubSysSADetailParamBase.resetStdDataType();
        pSSubSysSADetailParamBase.resetUpdateDate();
        pSSubSysSADetailParamBase.resetUpdateMan();
        pSSubSysSADetailParamBase.resetUserCat();
        pSSubSysSADetailParamBase.resetUserTag();
        pSSubSysSADetailParamBase.resetUserTag2();
        pSSubSysSADetailParamBase.resetUserTag3();
        pSSubSysSADetailParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamTagDirty()) {
            hashMap.put(FIELD_PARAMTAG, this.getParamTag());
        }
        if (!bl || this.isParamTag2Dirty()) {
            hashMap.put(FIELD_PARAMTAG2, this.getParamTag2());
        }
        if (!bl || this.isPSSubSysSADetailIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILID, this.getPSSubSysSADetailId());
        }
        if (!bl || this.isPSSubSysSADetailNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILNAME, this.getPSSubSysSADetailName());
        }
        if (!bl || this.isPSSubSysSADetailParamIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILPARAMID, this.getPSSubSysSADetailParamId());
        }
        if (!bl || this.isPSSubSysSADetailParamNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILPARAMNAME, this.getPSSubSysSADetailParamName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
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
        return PSSubSysSADetailParamBase.get(this, n);
    }

    private static Object get(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailParamBase.getArrayFlag();
            }
            case 1: {
                return pSSubSysSADetailParamBase.getCodeName();
            }
            case 2: {
                return pSSubSysSADetailParamBase.getCreateDate();
            }
            case 3: {
                return pSSubSysSADetailParamBase.getCreateMan();
            }
            case 4: {
                return pSSubSysSADetailParamBase.getMemo();
            }
            case 5: {
                return pSSubSysSADetailParamBase.getOrderValue();
            }
            case 6: {
                return pSSubSysSADetailParamBase.getParamTag();
            }
            case 7: {
                return pSSubSysSADetailParamBase.getParamTag2();
            }
            case 8: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailId();
            }
            case 9: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailName();
            }
            case 10: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailParamId();
            }
            case 11: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailParamName();
            }
            case 12: {
                return pSSubSysSADetailParamBase.getStdDataType();
            }
            case 13: {
                return pSSubSysSADetailParamBase.getUpdateDate();
            }
            case 14: {
                return pSSubSysSADetailParamBase.getUpdateMan();
            }
            case 15: {
                return pSSubSysSADetailParamBase.getUserCat();
            }
            case 16: {
                return pSSubSysSADetailParamBase.getUserTag();
            }
            case 17: {
                return pSSubSysSADetailParamBase.getUserTag2();
            }
            case 18: {
                return pSSubSysSADetailParamBase.getUserTag3();
            }
            case 19: {
                return pSSubSysSADetailParamBase.getUserTag4();
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
        PSSubSysSADetailParamBase.set(this, n, object);
    }

    private static void set(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADetailParamBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSADetailParamBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSADetailParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSADetailParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSADetailParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSADetailParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSADetailParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSADetailParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSADetailParamBase.setPSSubSysSADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSADetailParamBase.setPSSubSysSADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSADetailParamBase.setPSSubSysSADetailParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSADetailParamBase.setPSSubSysSADetailParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSADetailParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSADetailParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSADetailParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSADetailParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSADetailParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysSADetailParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysSADetailParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysSADetailParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSubSysSADetailParamBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailParamBase.getArrayFlag() == null;
            }
            case 1: {
                return pSSubSysSADetailParamBase.getCodeName() == null;
            }
            case 2: {
                return pSSubSysSADetailParamBase.getCreateDate() == null;
            }
            case 3: {
                return pSSubSysSADetailParamBase.getCreateMan() == null;
            }
            case 4: {
                return pSSubSysSADetailParamBase.getMemo() == null;
            }
            case 5: {
                return pSSubSysSADetailParamBase.getOrderValue() == null;
            }
            case 6: {
                return pSSubSysSADetailParamBase.getParamTag() == null;
            }
            case 7: {
                return pSSubSysSADetailParamBase.getParamTag2() == null;
            }
            case 8: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailId() == null;
            }
            case 9: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailName() == null;
            }
            case 10: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailParamId() == null;
            }
            case 11: {
                return pSSubSysSADetailParamBase.getPSSubSysSADetailParamName() == null;
            }
            case 12: {
                return pSSubSysSADetailParamBase.getStdDataType() == null;
            }
            case 13: {
                return pSSubSysSADetailParamBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSubSysSADetailParamBase.getUpdateMan() == null;
            }
            case 15: {
                return pSSubSysSADetailParamBase.getUserCat() == null;
            }
            case 16: {
                return pSSubSysSADetailParamBase.getUserTag() == null;
            }
            case 17: {
                return pSSubSysSADetailParamBase.getUserTag2() == null;
            }
            case 18: {
                return pSSubSysSADetailParamBase.getUserTag3() == null;
            }
            case 19: {
                return pSSubSysSADetailParamBase.getUserTag4() == null;
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
        return PSSubSysSADetailParamBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailParamBase.isArrayFlagDirty();
            }
            case 1: {
                return pSSubSysSADetailParamBase.isCodeNameDirty();
            }
            case 2: {
                return pSSubSysSADetailParamBase.isCreateDateDirty();
            }
            case 3: {
                return pSSubSysSADetailParamBase.isCreateManDirty();
            }
            case 4: {
                return pSSubSysSADetailParamBase.isMemoDirty();
            }
            case 5: {
                return pSSubSysSADetailParamBase.isOrderValueDirty();
            }
            case 6: {
                return pSSubSysSADetailParamBase.isParamTagDirty();
            }
            case 7: {
                return pSSubSysSADetailParamBase.isParamTag2Dirty();
            }
            case 8: {
                return pSSubSysSADetailParamBase.isPSSubSysSADetailIdDirty();
            }
            case 9: {
                return pSSubSysSADetailParamBase.isPSSubSysSADetailNameDirty();
            }
            case 10: {
                return pSSubSysSADetailParamBase.isPSSubSysSADetailParamIdDirty();
            }
            case 11: {
                return pSSubSysSADetailParamBase.isPSSubSysSADetailParamNameDirty();
            }
            case 12: {
                return pSSubSysSADetailParamBase.isStdDataTypeDirty();
            }
            case 13: {
                return pSSubSysSADetailParamBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSubSysSADetailParamBase.isUpdateManDirty();
            }
            case 15: {
                return pSSubSysSADetailParamBase.isUserCatDirty();
            }
            case 16: {
                return pSSubSysSADetailParamBase.isUserTagDirty();
            }
            case 17: {
                return pSSubSysSADetailParamBase.isUserTag2Dirty();
            }
            case 18: {
                return pSSubSysSADetailParamBase.isUserTag3Dirty();
            }
            case 19: {
                return pSSubSysSADetailParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSADetailParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSADetailParamBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailid", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getPSSubSysSADetailId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailname", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getPSSubSysSADetailName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailparamid", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getPSSubSysSADetailParamId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailparamname", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getPSSubSysSADetailParamName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysSADetailParamBase.getJSONValue((Object)pSSubSysSADetailParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSADetailParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSADetailParamBase.getArrayFlag() != null) {
            object = pSSubSysSADetailParamBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailParamBase.getCodeName() != null) {
            object = pSSubSysSADetailParamBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getCreateDate() != null) {
            object = pSSubSysSADetailParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADetailParamBase.getCreateMan() != null) {
            object = pSSubSysSADetailParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getMemo() != null) {
            object = pSSubSysSADetailParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getOrderValue() != null) {
            object = pSSubSysSADetailParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailParamBase.getParamTag() != null) {
            object = pSSubSysSADetailParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getParamTag2() != null) {
            object = pSSubSysSADetailParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailId() != null) {
            object = pSSubSysSADetailParamBase.getPSSubSysSADetailId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailName() != null) {
            object = pSSubSysSADetailParamBase.getPSSubSysSADetailName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamId() != null) {
            object = pSSubSysSADetailParamBase.getPSSubSysSADetailParamId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamName() != null) {
            object = pSSubSysSADetailParamBase.getPSSubSysSADetailParamName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getStdDataType() != null) {
            object = pSSubSysSADetailParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailParamBase.getUpdateDate() != null) {
            object = pSSubSysSADetailParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADetailParamBase.getUpdateMan() != null) {
            object = pSSubSysSADetailParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getUserCat() != null) {
            object = pSSubSysSADetailParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag() != null) {
            object = pSSubSysSADetailParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag2() != null) {
            object = pSSubSysSADetailParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag3() != null) {
            object = pSSubSysSADetailParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailParamBase.getUserTag4() != null) {
            object = pSSubSysSADetailParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSADetailParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSADetailParamBase.isArrayFlagDirty() && (bl || pSSubSysSADetailParamBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSSubSysSADetailParamBase.getArrayFlag());
        }
        if (pSSubSysSADetailParamBase.isCodeNameDirty() && (bl || pSSubSysSADetailParamBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSADetailParamBase.getCodeName());
        }
        if (pSSubSysSADetailParamBase.isCreateDateDirty() && (bl || pSSubSysSADetailParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSADetailParamBase.getCreateDate());
        }
        if (pSSubSysSADetailParamBase.isCreateManDirty() && (bl || pSSubSysSADetailParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSADetailParamBase.getCreateMan());
        }
        if (pSSubSysSADetailParamBase.isMemoDirty() && (bl || pSSubSysSADetailParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSADetailParamBase.getMemo());
        }
        if (pSSubSysSADetailParamBase.isOrderValueDirty() && (bl || pSSubSysSADetailParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSubSysSADetailParamBase.getOrderValue());
        }
        if (pSSubSysSADetailParamBase.isParamTagDirty() && (bl || pSSubSysSADetailParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSSubSysSADetailParamBase.getParamTag());
        }
        if (pSSubSysSADetailParamBase.isParamTag2Dirty() && (bl || pSSubSysSADetailParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSSubSysSADetailParamBase.getParamTag2());
        }
        if (pSSubSysSADetailParamBase.isPSSubSysSADetailIdDirty() && (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILID, (Object)pSSubSysSADetailParamBase.getPSSubSysSADetailId());
        }
        if (pSSubSysSADetailParamBase.isPSSubSysSADetailNameDirty() && (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILNAME, (Object)pSSubSysSADetailParamBase.getPSSubSysSADetailName());
        }
        if (pSSubSysSADetailParamBase.isPSSubSysSADetailParamIdDirty() && (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILPARAMID, (Object)pSSubSysSADetailParamBase.getPSSubSysSADetailParamId());
        }
        if (pSSubSysSADetailParamBase.isPSSubSysSADetailParamNameDirty() && (bl || pSSubSysSADetailParamBase.getPSSubSysSADetailParamName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILPARAMNAME, (Object)pSSubSysSADetailParamBase.getPSSubSysSADetailParamName());
        }
        if (pSSubSysSADetailParamBase.isStdDataTypeDirty() && (bl || pSSubSysSADetailParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSubSysSADetailParamBase.getStdDataType());
        }
        if (pSSubSysSADetailParamBase.isUpdateDateDirty() && (bl || pSSubSysSADetailParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSADetailParamBase.getUpdateDate());
        }
        if (pSSubSysSADetailParamBase.isUpdateManDirty() && (bl || pSSubSysSADetailParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSADetailParamBase.getUpdateMan());
        }
        if (pSSubSysSADetailParamBase.isUserCatDirty() && (bl || pSSubSysSADetailParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysSADetailParamBase.getUserCat());
        }
        if (pSSubSysSADetailParamBase.isUserTagDirty() && (bl || pSSubSysSADetailParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysSADetailParamBase.getUserTag());
        }
        if (pSSubSysSADetailParamBase.isUserTag2Dirty() && (bl || pSSubSysSADetailParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysSADetailParamBase.getUserTag2());
        }
        if (pSSubSysSADetailParamBase.isUserTag3Dirty() && (bl || pSSubSysSADetailParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysSADetailParamBase.getUserTag3());
        }
        if (pSSubSysSADetailParamBase.isUserTag4Dirty() && (bl || pSSubSysSADetailParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysSADetailParamBase.getUserTag4());
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
        return PSSubSysSADetailParamBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSADetailParamBase pSSubSysSADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADetailParamBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSSubSysSADetailParamBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSubSysSADetailParamBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSubSysSADetailParamBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSubSysSADetailParamBase.resetMemo();
                return true;
            }
            case 5: {
                pSSubSysSADetailParamBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSubSysSADetailParamBase.resetParamTag();
                return true;
            }
            case 7: {
                pSSubSysSADetailParamBase.resetParamTag2();
                return true;
            }
            case 8: {
                pSSubSysSADetailParamBase.resetPSSubSysSADetailId();
                return true;
            }
            case 9: {
                pSSubSysSADetailParamBase.resetPSSubSysSADetailName();
                return true;
            }
            case 10: {
                pSSubSysSADetailParamBase.resetPSSubSysSADetailParamId();
                return true;
            }
            case 11: {
                pSSubSysSADetailParamBase.resetPSSubSysSADetailParamName();
                return true;
            }
            case 12: {
                pSSubSysSADetailParamBase.resetStdDataType();
                return true;
            }
            case 13: {
                pSSubSysSADetailParamBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSubSysSADetailParamBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSSubSysSADetailParamBase.resetUserCat();
                return true;
            }
            case 16: {
                pSSubSysSADetailParamBase.resetUserTag();
                return true;
            }
            case 17: {
                pSSubSysSADetailParamBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSSubSysSADetailParamBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSSubSysSADetailParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADetail getPSSubSysSADetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetail();
        }
        if (this.getPSSubSysSADetailId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADetailLock;
        synchronized (n) {
            if (this.pssubsyssadetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADetailId(), (Object)this.pssubsyssadetail.getPSSubSysSADetailId()) != 0L) {
                this.pssubsyssadetail = null;
            }
            if (this.pssubsyssadetail == null) {
                PSSubSysSADetail pSSubSysSADetail = new PSSubSysSADetail();
                pSSubSysSADetail.setPSSubSysSADetailId(this.getPSSubSysSADetailId());
                PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADetailService.autoGet(pSSubSysSADetail);
                this.pssubsyssadetail = pSSubSysSADetail;
            }
            return this.pssubsyssadetail;
        }
    }

    private PSSubSysSADetailParamBase getProxyEntity() {
        return this.proxyPSSubSysSADetailParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSADetailParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSADetailParamBase) {
            this.proxyPSSubSysSADetailParamBase = (PSSubSysSADetailParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARRAYFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PARAMTAG, 6);
        fieldIndexMap.put(FIELD_PARAMTAG2, 7);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILID, 8);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILNAME, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILPARAMID, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILPARAMNAME, 11);
        fieldIndexMap.put(FIELD_STDDATATYPE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

