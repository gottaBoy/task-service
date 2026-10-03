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
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESADetailParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESADetailParamBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PSDESADETAILID = "PSDESADETAILID";
    public static final String FIELD_PSDESADETAILNAME = "PSDESADETAILNAME";
    public static final String FIELD_PSDESADETAILPARAMID = "PSDESADETAILPARAMID";
    public static final String FIELD_PSDESADETAILPARAMNAME = "PSDESADETAILPARAMNAME";
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
    private static final int INDEX_PSDESADETAILID = 8;
    private static final int INDEX_PSDESADETAILNAME = 9;
    private static final int INDEX_PSDESADETAILPARAMID = 10;
    private static final int INDEX_PSDESADETAILPARAMNAME = 11;
    private static final int INDEX_STDDATATYPE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESADetailParamBase proxyPSDESADetailParamBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean psdesadetailidDirtyFlag = false;
    private boolean psdesadetailnameDirtyFlag = false;
    private boolean psdesadetailparamidDirtyFlag = false;
    private boolean psdesadetailparamnameDirtyFlag = false;
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
    @Column(name="psdesadetailid")
    private String psdesadetailid;
    @Column(name="psdesadetailname")
    private String psdesadetailname;
    @Column(name="psdesadetailparamid")
    private String psdesadetailparamid;
    @Column(name="psdesadetailparamname")
    private String psdesadetailparamname;
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
    private Integer objPSDESADetailLock = new Integer(1);
    private PSDESADetail psdesadetail = null;

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

    public void setPSDESADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailid = string;
        this.psdesadetailidDirtyFlag = true;
    }

    public String getPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailId();
        }
        return this.psdesadetailid;
    }

    public boolean isPSDESADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailIdDirty();
        }
        return this.psdesadetailidDirtyFlag;
    }

    public void resetPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailId();
            return;
        }
        this.psdesadetailidDirtyFlag = false;
        this.psdesadetailid = null;
    }

    public void setPSDESADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailname = string;
        this.psdesadetailnameDirtyFlag = true;
    }

    public String getPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailName();
        }
        return this.psdesadetailname;
    }

    public boolean isPSDESADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailNameDirty();
        }
        return this.psdesadetailnameDirtyFlag;
    }

    public void resetPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailName();
            return;
        }
        this.psdesadetailnameDirtyFlag = false;
        this.psdesadetailname = null;
    }

    public void setPSDESADetailParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailparamid = string;
        this.psdesadetailparamidDirtyFlag = true;
    }

    public String getPSDESADetailParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailParamId();
        }
        return this.psdesadetailparamid;
    }

    public boolean isPSDESADetailParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailParamIdDirty();
        }
        return this.psdesadetailparamidDirtyFlag;
    }

    public void resetPSDESADetailParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailParamId();
            return;
        }
        this.psdesadetailparamidDirtyFlag = false;
        this.psdesadetailparamid = null;
    }

    public void setPSDESADetailParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailparamname = string;
        this.psdesadetailparamnameDirtyFlag = true;
    }

    public String getPSDESADetailParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailParamName();
        }
        return this.psdesadetailparamname;
    }

    public boolean isPSDESADetailParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailParamNameDirty();
        }
        return this.psdesadetailparamnameDirtyFlag;
    }

    public void resetPSDESADetailParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailParamName();
            return;
        }
        this.psdesadetailparamnameDirtyFlag = false;
        this.psdesadetailparamname = null;
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
        PSDESADetailParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESADetailParamBase pSDESADetailParamBase) {
        pSDESADetailParamBase.resetArrayFlag();
        pSDESADetailParamBase.resetCodeName();
        pSDESADetailParamBase.resetCreateDate();
        pSDESADetailParamBase.resetCreateMan();
        pSDESADetailParamBase.resetMemo();
        pSDESADetailParamBase.resetOrderValue();
        pSDESADetailParamBase.resetParamTag();
        pSDESADetailParamBase.resetParamTag2();
        pSDESADetailParamBase.resetPSDESADetailId();
        pSDESADetailParamBase.resetPSDESADetailName();
        pSDESADetailParamBase.resetPSDESADetailParamId();
        pSDESADetailParamBase.resetPSDESADetailParamName();
        pSDESADetailParamBase.resetStdDataType();
        pSDESADetailParamBase.resetUpdateDate();
        pSDESADetailParamBase.resetUpdateMan();
        pSDESADetailParamBase.resetUserCat();
        pSDESADetailParamBase.resetUserTag();
        pSDESADetailParamBase.resetUserTag2();
        pSDESADetailParamBase.resetUserTag3();
        pSDESADetailParamBase.resetUserTag4();
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
        if (!bl || this.isPSDESADetailIdDirty()) {
            hashMap.put(FIELD_PSDESADETAILID, this.getPSDESADetailId());
        }
        if (!bl || this.isPSDESADetailNameDirty()) {
            hashMap.put(FIELD_PSDESADETAILNAME, this.getPSDESADetailName());
        }
        if (!bl || this.isPSDESADetailParamIdDirty()) {
            hashMap.put(FIELD_PSDESADETAILPARAMID, this.getPSDESADetailParamId());
        }
        if (!bl || this.isPSDESADetailParamNameDirty()) {
            hashMap.put(FIELD_PSDESADETAILPARAMNAME, this.getPSDESADetailParamName());
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
        return PSDESADetailParamBase.get(this, n);
    }

    private static Object get(PSDESADetailParamBase pSDESADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailParamBase.getArrayFlag();
            }
            case 1: {
                return pSDESADetailParamBase.getCodeName();
            }
            case 2: {
                return pSDESADetailParamBase.getCreateDate();
            }
            case 3: {
                return pSDESADetailParamBase.getCreateMan();
            }
            case 4: {
                return pSDESADetailParamBase.getMemo();
            }
            case 5: {
                return pSDESADetailParamBase.getOrderValue();
            }
            case 6: {
                return pSDESADetailParamBase.getParamTag();
            }
            case 7: {
                return pSDESADetailParamBase.getParamTag2();
            }
            case 8: {
                return pSDESADetailParamBase.getPSDESADetailId();
            }
            case 9: {
                return pSDESADetailParamBase.getPSDESADetailName();
            }
            case 10: {
                return pSDESADetailParamBase.getPSDESADetailParamId();
            }
            case 11: {
                return pSDESADetailParamBase.getPSDESADetailParamName();
            }
            case 12: {
                return pSDESADetailParamBase.getStdDataType();
            }
            case 13: {
                return pSDESADetailParamBase.getUpdateDate();
            }
            case 14: {
                return pSDESADetailParamBase.getUpdateMan();
            }
            case 15: {
                return pSDESADetailParamBase.getUserCat();
            }
            case 16: {
                return pSDESADetailParamBase.getUserTag();
            }
            case 17: {
                return pSDESADetailParamBase.getUserTag2();
            }
            case 18: {
                return pSDESADetailParamBase.getUserTag3();
            }
            case 19: {
                return pSDESADetailParamBase.getUserTag4();
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
        PSDESADetailParamBase.set(this, n, object);
    }

    private static void set(PSDESADetailParamBase pSDESADetailParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESADetailParamBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDESADetailParamBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDESADetailParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDESADetailParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESADetailParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESADetailParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDESADetailParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESADetailParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESADetailParamBase.setPSDESADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESADetailParamBase.setPSDESADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESADetailParamBase.setPSDESADetailParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESADetailParamBase.setPSDESADetailParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESADetailParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDESADetailParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDESADetailParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDESADetailParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDESADetailParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDESADetailParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDESADetailParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDESADetailParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDESADetailParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDESADetailParamBase pSDESADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailParamBase.getArrayFlag() == null;
            }
            case 1: {
                return pSDESADetailParamBase.getCodeName() == null;
            }
            case 2: {
                return pSDESADetailParamBase.getCreateDate() == null;
            }
            case 3: {
                return pSDESADetailParamBase.getCreateMan() == null;
            }
            case 4: {
                return pSDESADetailParamBase.getMemo() == null;
            }
            case 5: {
                return pSDESADetailParamBase.getOrderValue() == null;
            }
            case 6: {
                return pSDESADetailParamBase.getParamTag() == null;
            }
            case 7: {
                return pSDESADetailParamBase.getParamTag2() == null;
            }
            case 8: {
                return pSDESADetailParamBase.getPSDESADetailId() == null;
            }
            case 9: {
                return pSDESADetailParamBase.getPSDESADetailName() == null;
            }
            case 10: {
                return pSDESADetailParamBase.getPSDESADetailParamId() == null;
            }
            case 11: {
                return pSDESADetailParamBase.getPSDESADetailParamName() == null;
            }
            case 12: {
                return pSDESADetailParamBase.getStdDataType() == null;
            }
            case 13: {
                return pSDESADetailParamBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDESADetailParamBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDESADetailParamBase.getUserCat() == null;
            }
            case 16: {
                return pSDESADetailParamBase.getUserTag() == null;
            }
            case 17: {
                return pSDESADetailParamBase.getUserTag2() == null;
            }
            case 18: {
                return pSDESADetailParamBase.getUserTag3() == null;
            }
            case 19: {
                return pSDESADetailParamBase.getUserTag4() == null;
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
        return PSDESADetailParamBase.contains(this, n);
    }

    private static boolean contains(PSDESADetailParamBase pSDESADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailParamBase.isArrayFlagDirty();
            }
            case 1: {
                return pSDESADetailParamBase.isCodeNameDirty();
            }
            case 2: {
                return pSDESADetailParamBase.isCreateDateDirty();
            }
            case 3: {
                return pSDESADetailParamBase.isCreateManDirty();
            }
            case 4: {
                return pSDESADetailParamBase.isMemoDirty();
            }
            case 5: {
                return pSDESADetailParamBase.isOrderValueDirty();
            }
            case 6: {
                return pSDESADetailParamBase.isParamTagDirty();
            }
            case 7: {
                return pSDESADetailParamBase.isParamTag2Dirty();
            }
            case 8: {
                return pSDESADetailParamBase.isPSDESADetailIdDirty();
            }
            case 9: {
                return pSDESADetailParamBase.isPSDESADetailNameDirty();
            }
            case 10: {
                return pSDESADetailParamBase.isPSDESADetailParamIdDirty();
            }
            case 11: {
                return pSDESADetailParamBase.isPSDESADetailParamNameDirty();
            }
            case 12: {
                return pSDESADetailParamBase.isStdDataTypeDirty();
            }
            case 13: {
                return pSDESADetailParamBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDESADetailParamBase.isUpdateManDirty();
            }
            case 15: {
                return pSDESADetailParamBase.isUserCatDirty();
            }
            case 16: {
                return pSDESADetailParamBase.isUserTagDirty();
            }
            case 17: {
                return pSDESADetailParamBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDESADetailParamBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDESADetailParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESADetailParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESADetailParamBase pSDESADetailParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESADetailParamBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailid", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getPSDESADetailId()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailname", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getPSDESADetailName()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailparamid", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getPSDESADetailParamId()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailparamname", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getPSDESADetailParamName()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDESADetailParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDESADetailParamBase.getJSONValue((Object)pSDESADetailParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESADetailParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESADetailParamBase pSDESADetailParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESADetailParamBase.getArrayFlag() != null) {
            object = pSDESADetailParamBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailParamBase.getCodeName() != null) {
            object = pSDESADetailParamBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getCreateDate() != null) {
            object = pSDESADetailParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESADetailParamBase.getCreateMan() != null) {
            object = pSDESADetailParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getMemo() != null) {
            object = pSDESADetailParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getOrderValue() != null) {
            object = pSDESADetailParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailParamBase.getParamTag() != null) {
            object = pSDESADetailParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getParamTag2() != null) {
            object = pSDESADetailParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailId() != null) {
            object = pSDESADetailParamBase.getPSDESADetailId();
            xmlNode.setAttribute(FIELD_PSDESADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailName() != null) {
            object = pSDESADetailParamBase.getPSDESADetailName();
            xmlNode.setAttribute(FIELD_PSDESADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailParamId() != null) {
            object = pSDESADetailParamBase.getPSDESADetailParamId();
            xmlNode.setAttribute(FIELD_PSDESADETAILPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getPSDESADetailParamName() != null) {
            object = pSDESADetailParamBase.getPSDESADetailParamName();
            xmlNode.setAttribute(FIELD_PSDESADETAILPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getStdDataType() != null) {
            object = pSDESADetailParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailParamBase.getUpdateDate() != null) {
            object = pSDESADetailParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESADetailParamBase.getUpdateMan() != null) {
            object = pSDESADetailParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getUserCat() != null) {
            object = pSDESADetailParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getUserTag() != null) {
            object = pSDESADetailParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getUserTag2() != null) {
            object = pSDESADetailParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getUserTag3() != null) {
            object = pSDESADetailParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailParamBase.getUserTag4() != null) {
            object = pSDESADetailParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESADetailParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESADetailParamBase pSDESADetailParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESADetailParamBase.isArrayFlagDirty() && (bl || pSDESADetailParamBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSDESADetailParamBase.getArrayFlag());
        }
        if (pSDESADetailParamBase.isCodeNameDirty() && (bl || pSDESADetailParamBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDESADetailParamBase.getCodeName());
        }
        if (pSDESADetailParamBase.isCreateDateDirty() && (bl || pSDESADetailParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESADetailParamBase.getCreateDate());
        }
        if (pSDESADetailParamBase.isCreateManDirty() && (bl || pSDESADetailParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESADetailParamBase.getCreateMan());
        }
        if (pSDESADetailParamBase.isMemoDirty() && (bl || pSDESADetailParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESADetailParamBase.getMemo());
        }
        if (pSDESADetailParamBase.isOrderValueDirty() && (bl || pSDESADetailParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESADetailParamBase.getOrderValue());
        }
        if (pSDESADetailParamBase.isParamTagDirty() && (bl || pSDESADetailParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSDESADetailParamBase.getParamTag());
        }
        if (pSDESADetailParamBase.isParamTag2Dirty() && (bl || pSDESADetailParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSDESADetailParamBase.getParamTag2());
        }
        if (pSDESADetailParamBase.isPSDESADetailIdDirty() && (bl || pSDESADetailParamBase.getPSDESADetailId() != null)) {
            iDataObject.set(FIELD_PSDESADETAILID, (Object)pSDESADetailParamBase.getPSDESADetailId());
        }
        if (pSDESADetailParamBase.isPSDESADetailNameDirty() && (bl || pSDESADetailParamBase.getPSDESADetailName() != null)) {
            iDataObject.set(FIELD_PSDESADETAILNAME, (Object)pSDESADetailParamBase.getPSDESADetailName());
        }
        if (pSDESADetailParamBase.isPSDESADetailParamIdDirty() && (bl || pSDESADetailParamBase.getPSDESADetailParamId() != null)) {
            iDataObject.set(FIELD_PSDESADETAILPARAMID, (Object)pSDESADetailParamBase.getPSDESADetailParamId());
        }
        if (pSDESADetailParamBase.isPSDESADetailParamNameDirty() && (bl || pSDESADetailParamBase.getPSDESADetailParamName() != null)) {
            iDataObject.set(FIELD_PSDESADETAILPARAMNAME, (Object)pSDESADetailParamBase.getPSDESADetailParamName());
        }
        if (pSDESADetailParamBase.isStdDataTypeDirty() && (bl || pSDESADetailParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDESADetailParamBase.getStdDataType());
        }
        if (pSDESADetailParamBase.isUpdateDateDirty() && (bl || pSDESADetailParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESADetailParamBase.getUpdateDate());
        }
        if (pSDESADetailParamBase.isUpdateManDirty() && (bl || pSDESADetailParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESADetailParamBase.getUpdateMan());
        }
        if (pSDESADetailParamBase.isUserCatDirty() && (bl || pSDESADetailParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDESADetailParamBase.getUserCat());
        }
        if (pSDESADetailParamBase.isUserTagDirty() && (bl || pSDESADetailParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDESADetailParamBase.getUserTag());
        }
        if (pSDESADetailParamBase.isUserTag2Dirty() && (bl || pSDESADetailParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDESADetailParamBase.getUserTag2());
        }
        if (pSDESADetailParamBase.isUserTag3Dirty() && (bl || pSDESADetailParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDESADetailParamBase.getUserTag3());
        }
        if (pSDESADetailParamBase.isUserTag4Dirty() && (bl || pSDESADetailParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDESADetailParamBase.getUserTag4());
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
        return PSDESADetailParamBase.remove(this, n);
    }

    private static boolean remove(PSDESADetailParamBase pSDESADetailParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESADetailParamBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSDESADetailParamBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDESADetailParamBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDESADetailParamBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDESADetailParamBase.resetMemo();
                return true;
            }
            case 5: {
                pSDESADetailParamBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDESADetailParamBase.resetParamTag();
                return true;
            }
            case 7: {
                pSDESADetailParamBase.resetParamTag2();
                return true;
            }
            case 8: {
                pSDESADetailParamBase.resetPSDESADetailId();
                return true;
            }
            case 9: {
                pSDESADetailParamBase.resetPSDESADetailName();
                return true;
            }
            case 10: {
                pSDESADetailParamBase.resetPSDESADetailParamId();
                return true;
            }
            case 11: {
                pSDESADetailParamBase.resetPSDESADetailParamName();
                return true;
            }
            case 12: {
                pSDESADetailParamBase.resetStdDataType();
                return true;
            }
            case 13: {
                pSDESADetailParamBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDESADetailParamBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDESADetailParamBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDESADetailParamBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDESADetailParamBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDESADetailParamBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDESADetailParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESADetail getPSDESADetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetail();
        }
        if (this.getPSDESADetailId() == null) {
            return null;
        }
        Integer n = this.objPSDESADetailLock;
        synchronized (n) {
            if (this.psdesadetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESADetailId(), (Object)this.psdesadetail.getPSDESADetailId()) != 0L) {
                this.psdesadetail = null;
            }
            if (this.psdesadetail == null) {
                PSDESADetail pSDESADetail = new PSDESADetail();
                pSDESADetail.setPSDESADetailId(this.getPSDESADetailId());
                PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
                pSDESADetailService.autoGet(pSDESADetail);
                this.psdesadetail = pSDESADetail;
            }
            return this.psdesadetail;
        }
    }

    private PSDESADetailParamBase getProxyEntity() {
        return this.proxyPSDESADetailParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESADetailParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESADetailParamBase) {
            this.proxyPSDESADetailParamBase = (PSDESADetailParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESADetailParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDESADETAILID, 8);
        fieldIndexMap.put(FIELD_PSDESADETAILNAME, 9);
        fieldIndexMap.put(FIELD_PSDESADETAILPARAMID, 10);
        fieldIndexMap.put(FIELD_PSDESADETAILPARAMNAME, 11);
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

