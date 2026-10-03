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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEVRGrpDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEVRGrpDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILPARAM = "DETAILPARAM";
    public static final String FIELD_DETAILPARAM2 = "DETAILPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEVRGROUPID = "PSDEVRGROUPID";
    public static final String FIELD_PSDEVRGROUPNAME = "PSDEVRGROUPNAME";
    public static final String FIELD_PSDEVRGRPDETAILID = "PSDEVRGRPDETAILID";
    public static final String FIELD_PSDEVRGRPDETAILNAME = "PSDEVRGRPDETAILNAME";
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
    private static final int INDEX_DETAILPARAM = 2;
    private static final int INDEX_DETAILPARAM2 = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEFVALUERULEID = 6;
    private static final int INDEX_PSDEFVALUERULENAME = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDEVRGROUPID = 9;
    private static final int INDEX_PSDEVRGROUPNAME = 10;
    private static final int INDEX_PSDEVRGRPDETAILID = 11;
    private static final int INDEX_PSDEVRGRPDETAILNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEVRGrpDetailBase proxyPSDEVRGrpDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailparamDirtyFlag = false;
    private boolean detailparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdevrgroupidDirtyFlag = false;
    private boolean psdevrgroupnameDirtyFlag = false;
    private boolean psdevrgrpdetailidDirtyFlag = false;
    private boolean psdevrgrpdetailnameDirtyFlag = false;
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
    @Column(name="detailparam")
    private String detailparam;
    @Column(name="detailparam2")
    private String detailparam2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdevrgroupid")
    private String psdevrgroupid;
    @Column(name="psdevrgroupname")
    private String psdevrgroupname;
    @Column(name="psdevrgrpdetailid")
    private String psdevrgrpdetailid;
    @Column(name="psdevrgrpdetailname")
    private String psdevrgrpdetailname;
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
    private Integer objPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule psdefvaluerule = null;
    private Integer objPSDEVRGroupLock = new Integer(1);
    private PSDEVRGroup psdevrgroup = null;

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

    public void setDetailParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam = string;
        this.detailparamDirtyFlag = true;
    }

    public String getDetailParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam();
        }
        return this.detailparam;
    }

    public boolean isDetailParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParamDirty();
        }
        return this.detailparamDirtyFlag;
    }

    public void resetDetailParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam();
            return;
        }
        this.detailparamDirtyFlag = false;
        this.detailparam = null;
    }

    public void setDetailParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam2 = string;
        this.detailparam2DirtyFlag = true;
    }

    public String getDetailParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam2();
        }
        return this.detailparam2;
    }

    public boolean isDetailParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParam2Dirty();
        }
        return this.detailparam2DirtyFlag;
    }

    public void resetDetailParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam2();
            return;
        }
        this.detailparam2DirtyFlag = false;
        this.detailparam2 = null;
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

    public void setPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvalueruleid = string;
        this.psdefvalueruleidDirtyFlag = true;
    }

    public String getPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleId();
        }
        return this.psdefvalueruleid;
    }

    public boolean isPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleIdDirty();
        }
        return this.psdefvalueruleidDirtyFlag;
    }

    public void resetPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleId();
            return;
        }
        this.psdefvalueruleidDirtyFlag = false;
        this.psdefvalueruleid = null;
    }

    public void setPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvaluerulename = string;
        this.psdefvaluerulenameDirtyFlag = true;
    }

    public String getPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleName();
        }
        return this.psdefvaluerulename;
    }

    public boolean isPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleNameDirty();
        }
        return this.psdefvaluerulenameDirtyFlag;
    }

    public void resetPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleName();
            return;
        }
        this.psdefvaluerulenameDirtyFlag = false;
        this.psdefvaluerulename = null;
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

    public void setPSDEVRGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgroupid = string;
        this.psdevrgroupidDirtyFlag = true;
    }

    public String getPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroupId();
        }
        return this.psdevrgroupid;
    }

    public boolean isPSDEVRGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGroupIdDirty();
        }
        return this.psdevrgroupidDirtyFlag;
    }

    public void resetPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGroupId();
            return;
        }
        this.psdevrgroupidDirtyFlag = false;
        this.psdevrgroupid = null;
    }

    public void setPSDEVRGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgroupname = string;
        this.psdevrgroupnameDirtyFlag = true;
    }

    public String getPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroupName();
        }
        return this.psdevrgroupname;
    }

    public boolean isPSDEVRGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGroupNameDirty();
        }
        return this.psdevrgroupnameDirtyFlag;
    }

    public void resetPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGroupName();
            return;
        }
        this.psdevrgroupnameDirtyFlag = false;
        this.psdevrgroupname = null;
    }

    public void setPSDEVRGrpDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGrpDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgrpdetailid = string;
        this.psdevrgrpdetailidDirtyFlag = true;
    }

    public String getPSDEVRGrpDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGrpDetailId();
        }
        return this.psdevrgrpdetailid;
    }

    public boolean isPSDEVRGrpDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGrpDetailIdDirty();
        }
        return this.psdevrgrpdetailidDirtyFlag;
    }

    public void resetPSDEVRGrpDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGrpDetailId();
            return;
        }
        this.psdevrgrpdetailidDirtyFlag = false;
        this.psdevrgrpdetailid = null;
    }

    public void setPSDEVRGrpDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEVRGrpDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevrgrpdetailname = string;
        this.psdevrgrpdetailnameDirtyFlag = true;
    }

    public String getPSDEVRGrpDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGrpDetailName();
        }
        return this.psdevrgrpdetailname;
    }

    public boolean isPSDEVRGrpDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEVRGrpDetailNameDirty();
        }
        return this.psdevrgrpdetailnameDirtyFlag;
    }

    public void resetPSDEVRGrpDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEVRGrpDetailName();
            return;
        }
        this.psdevrgrpdetailnameDirtyFlag = false;
        this.psdevrgrpdetailname = null;
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
        PSDEVRGrpDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEVRGrpDetailBase pSDEVRGrpDetailBase) {
        pSDEVRGrpDetailBase.resetCreateDate();
        pSDEVRGrpDetailBase.resetCreateMan();
        pSDEVRGrpDetailBase.resetDetailParam();
        pSDEVRGrpDetailBase.resetDetailParam2();
        pSDEVRGrpDetailBase.resetMemo();
        pSDEVRGrpDetailBase.resetOrderValue();
        pSDEVRGrpDetailBase.resetPSDEFValueRuleId();
        pSDEVRGrpDetailBase.resetPSDEFValueRuleName();
        pSDEVRGrpDetailBase.resetPSDEId();
        pSDEVRGrpDetailBase.resetPSDEVRGroupId();
        pSDEVRGrpDetailBase.resetPSDEVRGroupName();
        pSDEVRGrpDetailBase.resetPSDEVRGrpDetailId();
        pSDEVRGrpDetailBase.resetPSDEVRGrpDetailName();
        pSDEVRGrpDetailBase.resetUpdateDate();
        pSDEVRGrpDetailBase.resetUpdateMan();
        pSDEVRGrpDetailBase.resetUserCat();
        pSDEVRGrpDetailBase.resetUserTag();
        pSDEVRGrpDetailBase.resetUserTag2();
        pSDEVRGrpDetailBase.resetUserTag3();
        pSDEVRGrpDetailBase.resetUserTag4();
        pSDEVRGrpDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailParamDirty()) {
            hashMap.put(FIELD_DETAILPARAM, this.getDetailParam());
        }
        if (!bl || this.isDetailParam2Dirty()) {
            hashMap.put(FIELD_DETAILPARAM2, this.getDetailParam2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULEID, this.getPSDEFValueRuleId());
        }
        if (!bl || this.isPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULENAME, this.getPSDEFValueRuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEVRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPID, this.getPSDEVRGroupId());
        }
        if (!bl || this.isPSDEVRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPNAME, this.getPSDEVRGroupName());
        }
        if (!bl || this.isPSDEVRGrpDetailIdDirty()) {
            hashMap.put(FIELD_PSDEVRGRPDETAILID, this.getPSDEVRGrpDetailId());
        }
        if (!bl || this.isPSDEVRGrpDetailNameDirty()) {
            hashMap.put(FIELD_PSDEVRGRPDETAILNAME, this.getPSDEVRGrpDetailName());
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
        return PSDEVRGrpDetailBase.get(this, n);
    }

    private static Object get(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGrpDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEVRGrpDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEVRGrpDetailBase.getDetailParam();
            }
            case 3: {
                return pSDEVRGrpDetailBase.getDetailParam2();
            }
            case 4: {
                return pSDEVRGrpDetailBase.getMemo();
            }
            case 5: {
                return pSDEVRGrpDetailBase.getOrderValue();
            }
            case 6: {
                return pSDEVRGrpDetailBase.getPSDEFValueRuleId();
            }
            case 7: {
                return pSDEVRGrpDetailBase.getPSDEFValueRuleName();
            }
            case 8: {
                return pSDEVRGrpDetailBase.getPSDEId();
            }
            case 9: {
                return pSDEVRGrpDetailBase.getPSDEVRGroupId();
            }
            case 10: {
                return pSDEVRGrpDetailBase.getPSDEVRGroupName();
            }
            case 11: {
                return pSDEVRGrpDetailBase.getPSDEVRGrpDetailId();
            }
            case 12: {
                return pSDEVRGrpDetailBase.getPSDEVRGrpDetailName();
            }
            case 13: {
                return pSDEVRGrpDetailBase.getUpdateDate();
            }
            case 14: {
                return pSDEVRGrpDetailBase.getUpdateMan();
            }
            case 15: {
                return pSDEVRGrpDetailBase.getUserCat();
            }
            case 16: {
                return pSDEVRGrpDetailBase.getUserTag();
            }
            case 17: {
                return pSDEVRGrpDetailBase.getUserTag2();
            }
            case 18: {
                return pSDEVRGrpDetailBase.getUserTag3();
            }
            case 19: {
                return pSDEVRGrpDetailBase.getUserTag4();
            }
            case 20: {
                return pSDEVRGrpDetailBase.getValidFlag();
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
        PSDEVRGrpDetailBase.set(this, n, object);
    }

    private static void set(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEVRGrpDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEVRGrpDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEVRGrpDetailBase.setDetailParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEVRGrpDetailBase.setDetailParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEVRGrpDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEVRGrpDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEVRGrpDetailBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEVRGrpDetailBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEVRGrpDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEVRGrpDetailBase.setPSDEVRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEVRGrpDetailBase.setPSDEVRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEVRGrpDetailBase.setPSDEVRGrpDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEVRGrpDetailBase.setPSDEVRGrpDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEVRGrpDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEVRGrpDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEVRGrpDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEVRGrpDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEVRGrpDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEVRGrpDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEVRGrpDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEVRGrpDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEVRGrpDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGrpDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEVRGrpDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEVRGrpDetailBase.getDetailParam() == null;
            }
            case 3: {
                return pSDEVRGrpDetailBase.getDetailParam2() == null;
            }
            case 4: {
                return pSDEVRGrpDetailBase.getMemo() == null;
            }
            case 5: {
                return pSDEVRGrpDetailBase.getOrderValue() == null;
            }
            case 6: {
                return pSDEVRGrpDetailBase.getPSDEFValueRuleId() == null;
            }
            case 7: {
                return pSDEVRGrpDetailBase.getPSDEFValueRuleName() == null;
            }
            case 8: {
                return pSDEVRGrpDetailBase.getPSDEId() == null;
            }
            case 9: {
                return pSDEVRGrpDetailBase.getPSDEVRGroupId() == null;
            }
            case 10: {
                return pSDEVRGrpDetailBase.getPSDEVRGroupName() == null;
            }
            case 11: {
                return pSDEVRGrpDetailBase.getPSDEVRGrpDetailId() == null;
            }
            case 12: {
                return pSDEVRGrpDetailBase.getPSDEVRGrpDetailName() == null;
            }
            case 13: {
                return pSDEVRGrpDetailBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEVRGrpDetailBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDEVRGrpDetailBase.getUserCat() == null;
            }
            case 16: {
                return pSDEVRGrpDetailBase.getUserTag() == null;
            }
            case 17: {
                return pSDEVRGrpDetailBase.getUserTag2() == null;
            }
            case 18: {
                return pSDEVRGrpDetailBase.getUserTag3() == null;
            }
            case 19: {
                return pSDEVRGrpDetailBase.getUserTag4() == null;
            }
            case 20: {
                return pSDEVRGrpDetailBase.getValidFlag() == null;
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
        return PSDEVRGrpDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGrpDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEVRGrpDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEVRGrpDetailBase.isDetailParamDirty();
            }
            case 3: {
                return pSDEVRGrpDetailBase.isDetailParam2Dirty();
            }
            case 4: {
                return pSDEVRGrpDetailBase.isMemoDirty();
            }
            case 5: {
                return pSDEVRGrpDetailBase.isOrderValueDirty();
            }
            case 6: {
                return pSDEVRGrpDetailBase.isPSDEFValueRuleIdDirty();
            }
            case 7: {
                return pSDEVRGrpDetailBase.isPSDEFValueRuleNameDirty();
            }
            case 8: {
                return pSDEVRGrpDetailBase.isPSDEIdDirty();
            }
            case 9: {
                return pSDEVRGrpDetailBase.isPSDEVRGroupIdDirty();
            }
            case 10: {
                return pSDEVRGrpDetailBase.isPSDEVRGroupNameDirty();
            }
            case 11: {
                return pSDEVRGrpDetailBase.isPSDEVRGrpDetailIdDirty();
            }
            case 12: {
                return pSDEVRGrpDetailBase.isPSDEVRGrpDetailNameDirty();
            }
            case 13: {
                return pSDEVRGrpDetailBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEVRGrpDetailBase.isUpdateManDirty();
            }
            case 15: {
                return pSDEVRGrpDetailBase.isUserCatDirty();
            }
            case 16: {
                return pSDEVRGrpDetailBase.isUserTagDirty();
            }
            case 17: {
                return pSDEVRGrpDetailBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDEVRGrpDetailBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDEVRGrpDetailBase.isUserTag4Dirty();
            }
            case 20: {
                return pSDEVRGrpDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEVRGrpDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEVRGrpDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getDetailParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getDetailParam()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getDetailParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam2", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getDetailParam2()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupid", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEVRGroupId()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupname", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEVRGroupName()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgrpdetailid", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEVRGrpDetailId()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgrpdetailname", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getPSDEVRGrpDetailName()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEVRGrpDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEVRGrpDetailBase.getJSONValue((Object)pSDEVRGrpDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEVRGrpDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEVRGrpDetailBase.getCreateDate() != null) {
            object = pSDEVRGrpDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEVRGrpDetailBase.getCreateMan() != null) {
            object = pSDEVRGrpDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getDetailParam() != null) {
            object = pSDEVRGrpDetailBase.getDetailParam();
            xmlNode.setAttribute(FIELD_DETAILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getDetailParam2() != null) {
            object = pSDEVRGrpDetailBase.getDetailParam2();
            xmlNode.setAttribute(FIELD_DETAILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getMemo() != null) {
            object = pSDEVRGrpDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getOrderValue() != null) {
            object = pSDEVRGrpDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleId() != null) {
            object = pSDEVRGrpDetailBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleName() != null) {
            object = pSDEVRGrpDetailBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEId() != null) {
            object = pSDEVRGrpDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGroupId() != null) {
            object = pSDEVRGrpDetailBase.getPSDEVRGroupId();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGroupName() != null) {
            object = pSDEVRGrpDetailBase.getPSDEVRGroupName();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailId() != null) {
            object = pSDEVRGrpDetailBase.getPSDEVRGrpDetailId();
            xmlNode.setAttribute(FIELD_PSDEVRGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailName() != null) {
            object = pSDEVRGrpDetailBase.getPSDEVRGrpDetailName();
            xmlNode.setAttribute(FIELD_PSDEVRGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUpdateDate() != null) {
            object = pSDEVRGrpDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEVRGrpDetailBase.getUpdateMan() != null) {
            object = pSDEVRGrpDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUserCat() != null) {
            object = pSDEVRGrpDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag() != null) {
            object = pSDEVRGrpDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag2() != null) {
            object = pSDEVRGrpDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag3() != null) {
            object = pSDEVRGrpDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getUserTag4() != null) {
            object = pSDEVRGrpDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGrpDetailBase.getValidFlag() != null) {
            object = pSDEVRGrpDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEVRGrpDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEVRGrpDetailBase.isCreateDateDirty() && (bl || pSDEVRGrpDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEVRGrpDetailBase.getCreateDate());
        }
        if (pSDEVRGrpDetailBase.isCreateManDirty() && (bl || pSDEVRGrpDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEVRGrpDetailBase.getCreateMan());
        }
        if (pSDEVRGrpDetailBase.isDetailParamDirty() && (bl || pSDEVRGrpDetailBase.getDetailParam() != null)) {
            iDataObject.set(FIELD_DETAILPARAM, (Object)pSDEVRGrpDetailBase.getDetailParam());
        }
        if (pSDEVRGrpDetailBase.isDetailParam2Dirty() && (bl || pSDEVRGrpDetailBase.getDetailParam2() != null)) {
            iDataObject.set(FIELD_DETAILPARAM2, (Object)pSDEVRGrpDetailBase.getDetailParam2());
        }
        if (pSDEVRGrpDetailBase.isMemoDirty() && (bl || pSDEVRGrpDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEVRGrpDetailBase.getMemo());
        }
        if (pSDEVRGrpDetailBase.isOrderValueDirty() && (bl || pSDEVRGrpDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEVRGrpDetailBase.getOrderValue());
        }
        if (pSDEVRGrpDetailBase.isPSDEFValueRuleIdDirty() && (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEVRGrpDetailBase.getPSDEFValueRuleId());
        }
        if (pSDEVRGrpDetailBase.isPSDEFValueRuleNameDirty() && (bl || pSDEVRGrpDetailBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEVRGrpDetailBase.getPSDEFValueRuleName());
        }
        if (pSDEVRGrpDetailBase.isPSDEIdDirty() && (bl || pSDEVRGrpDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEVRGrpDetailBase.getPSDEId());
        }
        if (pSDEVRGrpDetailBase.isPSDEVRGroupIdDirty() && (bl || pSDEVRGrpDetailBase.getPSDEVRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPID, (Object)pSDEVRGrpDetailBase.getPSDEVRGroupId());
        }
        if (pSDEVRGrpDetailBase.isPSDEVRGroupNameDirty() && (bl || pSDEVRGrpDetailBase.getPSDEVRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPNAME, (Object)pSDEVRGrpDetailBase.getPSDEVRGroupName());
        }
        if (pSDEVRGrpDetailBase.isPSDEVRGrpDetailIdDirty() && (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailId() != null)) {
            iDataObject.set(FIELD_PSDEVRGRPDETAILID, (Object)pSDEVRGrpDetailBase.getPSDEVRGrpDetailId());
        }
        if (pSDEVRGrpDetailBase.isPSDEVRGrpDetailNameDirty() && (bl || pSDEVRGrpDetailBase.getPSDEVRGrpDetailName() != null)) {
            iDataObject.set(FIELD_PSDEVRGRPDETAILNAME, (Object)pSDEVRGrpDetailBase.getPSDEVRGrpDetailName());
        }
        if (pSDEVRGrpDetailBase.isUpdateDateDirty() && (bl || pSDEVRGrpDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEVRGrpDetailBase.getUpdateDate());
        }
        if (pSDEVRGrpDetailBase.isUpdateManDirty() && (bl || pSDEVRGrpDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEVRGrpDetailBase.getUpdateMan());
        }
        if (pSDEVRGrpDetailBase.isUserCatDirty() && (bl || pSDEVRGrpDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEVRGrpDetailBase.getUserCat());
        }
        if (pSDEVRGrpDetailBase.isUserTagDirty() && (bl || pSDEVRGrpDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEVRGrpDetailBase.getUserTag());
        }
        if (pSDEVRGrpDetailBase.isUserTag2Dirty() && (bl || pSDEVRGrpDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEVRGrpDetailBase.getUserTag2());
        }
        if (pSDEVRGrpDetailBase.isUserTag3Dirty() && (bl || pSDEVRGrpDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEVRGrpDetailBase.getUserTag3());
        }
        if (pSDEVRGrpDetailBase.isUserTag4Dirty() && (bl || pSDEVRGrpDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEVRGrpDetailBase.getUserTag4());
        }
        if (pSDEVRGrpDetailBase.isValidFlagDirty() && (bl || pSDEVRGrpDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEVRGrpDetailBase.getValidFlag());
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
        return PSDEVRGrpDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEVRGrpDetailBase pSDEVRGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEVRGrpDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEVRGrpDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEVRGrpDetailBase.resetDetailParam();
                return true;
            }
            case 3: {
                pSDEVRGrpDetailBase.resetDetailParam2();
                return true;
            }
            case 4: {
                pSDEVRGrpDetailBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEVRGrpDetailBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDEVRGrpDetailBase.resetPSDEFValueRuleId();
                return true;
            }
            case 7: {
                pSDEVRGrpDetailBase.resetPSDEFValueRuleName();
                return true;
            }
            case 8: {
                pSDEVRGrpDetailBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSDEVRGrpDetailBase.resetPSDEVRGroupId();
                return true;
            }
            case 10: {
                pSDEVRGrpDetailBase.resetPSDEVRGroupName();
                return true;
            }
            case 11: {
                pSDEVRGrpDetailBase.resetPSDEVRGrpDetailId();
                return true;
            }
            case 12: {
                pSDEVRGrpDetailBase.resetPSDEVRGrpDetailName();
                return true;
            }
            case 13: {
                pSDEVRGrpDetailBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEVRGrpDetailBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDEVRGrpDetailBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDEVRGrpDetailBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDEVRGrpDetailBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDEVRGrpDetailBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDEVRGrpDetailBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSDEVRGrpDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRule();
        }
        if (this.getPSDEFValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSDEFValueRuleLock;
        synchronized (n) {
            if (this.psdefvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFValueRuleId(), (Object)this.psdefvaluerule.getPSDEFValueRuleId()) != 0L) {
                this.psdefvaluerule = null;
            }
            if (this.psdefvaluerule == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFValueRuleId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvaluerule = pSDEFValueRule;
            }
            return this.psdefvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEVRGroup getPSDEVRGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGroup();
        }
        if (this.getPSDEVRGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEVRGroupLock;
        synchronized (n) {
            if (this.psdevrgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEVRGroupId(), (Object)this.psdevrgroup.getPSDEVRGroupId()) != 0L) {
                this.psdevrgroup = null;
            }
            if (this.psdevrgroup == null) {
                PSDEVRGroup pSDEVRGroup = new PSDEVRGroup();
                pSDEVRGroup.setPSDEVRGroupId(this.getPSDEVRGroupId());
                PSDEVRGroupService pSDEVRGroupService = (PSDEVRGroupService)ServiceGlobal.getService(PSDEVRGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEVRGroupService.autoGet(pSDEVRGroup);
                this.psdevrgroup = pSDEVRGroup;
            }
            return this.psdevrgroup;
        }
    }

    private PSDEVRGrpDetailBase getProxyEntity() {
        return this.proxyPSDEVRGrpDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEVRGrpDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEVRGrpDetailBase) {
            this.proxyPSDEVRGrpDetailBase = (PSDEVRGrpDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DETAILPARAM, 2);
        fieldIndexMap.put(FIELD_DETAILPARAM2, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 6);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDEVRGROUPID, 9);
        fieldIndexMap.put(FIELD_PSDEVRGROUPNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVRGRPDETAILID, 11);
        fieldIndexMap.put(FIELD_PSDEVRGRPDETAILNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

