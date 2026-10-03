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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGrpDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGrpDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEVRGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEVRGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVRGROUPID = "PSDEVRGROUPID";
    public static final String FIELD_PSDEVRGROUPNAME = "PSDEVRGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_GROUPTAG = 3;
    private static final int INDEX_GROUPTAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSDEVRGROUPID = 9;
    private static final int INDEX_PSDEVRGROUPNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERPARAMS = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEVRGroupBase proxyPSDEVRGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdevrgroupidDirtyFlag = false;
    private boolean psdevrgroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdevrgroupid")
    private String psdevrgroupid;
    @Column(name="psdevrgroupname")
    private String psdevrgroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEVRGrpDetailsLock = new Integer(1);
    private ArrayList<PSDEVRGrpDetail> psdevrgrpdetails = null;

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

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSDEVRGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEVRGroupBase pSDEVRGroupBase) {
        pSDEVRGroupBase.resetCodeName();
        pSDEVRGroupBase.resetCreateDate();
        pSDEVRGroupBase.resetCreateMan();
        pSDEVRGroupBase.resetGroupTag();
        pSDEVRGroupBase.resetGroupTag2();
        pSDEVRGroupBase.resetMemo();
        pSDEVRGroupBase.resetOrderValue();
        pSDEVRGroupBase.resetPSDEId();
        pSDEVRGroupBase.resetPSDEName();
        pSDEVRGroupBase.resetPSDEVRGroupId();
        pSDEVRGroupBase.resetPSDEVRGroupName();
        pSDEVRGroupBase.resetUpdateDate();
        pSDEVRGroupBase.resetUpdateMan();
        pSDEVRGroupBase.resetUserCat();
        pSDEVRGroupBase.resetUserParams();
        pSDEVRGroupBase.resetUserTag();
        pSDEVRGroupBase.resetUserTag2();
        pSDEVRGroupBase.resetUserTag3();
        pSDEVRGroupBase.resetUserTag4();
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
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEVRGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPID, this.getPSDEVRGroupId());
        }
        if (!bl || this.isPSDEVRGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVRGROUPNAME, this.getPSDEVRGroupName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDEVRGroupBase.get(this, n);
    }

    private static Object get(PSDEVRGroupBase pSDEVRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGroupBase.getCodeName();
            }
            case 1: {
                return pSDEVRGroupBase.getCreateDate();
            }
            case 2: {
                return pSDEVRGroupBase.getCreateMan();
            }
            case 3: {
                return pSDEVRGroupBase.getGroupTag();
            }
            case 4: {
                return pSDEVRGroupBase.getGroupTag2();
            }
            case 5: {
                return pSDEVRGroupBase.getMemo();
            }
            case 6: {
                return pSDEVRGroupBase.getOrderValue();
            }
            case 7: {
                return pSDEVRGroupBase.getPSDEId();
            }
            case 8: {
                return pSDEVRGroupBase.getPSDEName();
            }
            case 9: {
                return pSDEVRGroupBase.getPSDEVRGroupId();
            }
            case 10: {
                return pSDEVRGroupBase.getPSDEVRGroupName();
            }
            case 11: {
                return pSDEVRGroupBase.getUpdateDate();
            }
            case 12: {
                return pSDEVRGroupBase.getUpdateMan();
            }
            case 13: {
                return pSDEVRGroupBase.getUserCat();
            }
            case 14: {
                return pSDEVRGroupBase.getUserParams();
            }
            case 15: {
                return pSDEVRGroupBase.getUserTag();
            }
            case 16: {
                return pSDEVRGroupBase.getUserTag2();
            }
            case 17: {
                return pSDEVRGroupBase.getUserTag3();
            }
            case 18: {
                return pSDEVRGroupBase.getUserTag4();
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
        PSDEVRGroupBase.set(this, n, object);
    }

    private static void set(PSDEVRGroupBase pSDEVRGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEVRGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEVRGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEVRGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEVRGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEVRGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEVRGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEVRGroupBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEVRGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEVRGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEVRGroupBase.setPSDEVRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEVRGroupBase.setPSDEVRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEVRGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEVRGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEVRGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEVRGroupBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEVRGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEVRGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEVRGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEVRGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEVRGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEVRGroupBase pSDEVRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEVRGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEVRGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEVRGroupBase.getGroupTag() == null;
            }
            case 4: {
                return pSDEVRGroupBase.getGroupTag2() == null;
            }
            case 5: {
                return pSDEVRGroupBase.getMemo() == null;
            }
            case 6: {
                return pSDEVRGroupBase.getOrderValue() == null;
            }
            case 7: {
                return pSDEVRGroupBase.getPSDEId() == null;
            }
            case 8: {
                return pSDEVRGroupBase.getPSDEName() == null;
            }
            case 9: {
                return pSDEVRGroupBase.getPSDEVRGroupId() == null;
            }
            case 10: {
                return pSDEVRGroupBase.getPSDEVRGroupName() == null;
            }
            case 11: {
                return pSDEVRGroupBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEVRGroupBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDEVRGroupBase.getUserCat() == null;
            }
            case 14: {
                return pSDEVRGroupBase.getUserParams() == null;
            }
            case 15: {
                return pSDEVRGroupBase.getUserTag() == null;
            }
            case 16: {
                return pSDEVRGroupBase.getUserTag2() == null;
            }
            case 17: {
                return pSDEVRGroupBase.getUserTag3() == null;
            }
            case 18: {
                return pSDEVRGroupBase.getUserTag4() == null;
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
        return PSDEVRGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEVRGroupBase pSDEVRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEVRGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEVRGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEVRGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSDEVRGroupBase.isGroupTagDirty();
            }
            case 4: {
                return pSDEVRGroupBase.isGroupTag2Dirty();
            }
            case 5: {
                return pSDEVRGroupBase.isMemoDirty();
            }
            case 6: {
                return pSDEVRGroupBase.isOrderValueDirty();
            }
            case 7: {
                return pSDEVRGroupBase.isPSDEIdDirty();
            }
            case 8: {
                return pSDEVRGroupBase.isPSDENameDirty();
            }
            case 9: {
                return pSDEVRGroupBase.isPSDEVRGroupIdDirty();
            }
            case 10: {
                return pSDEVRGroupBase.isPSDEVRGroupNameDirty();
            }
            case 11: {
                return pSDEVRGroupBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEVRGroupBase.isUpdateManDirty();
            }
            case 13: {
                return pSDEVRGroupBase.isUserCatDirty();
            }
            case 14: {
                return pSDEVRGroupBase.isUserParamsDirty();
            }
            case 15: {
                return pSDEVRGroupBase.isUserTagDirty();
            }
            case 16: {
                return pSDEVRGroupBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDEVRGroupBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDEVRGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEVRGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEVRGroupBase pSDEVRGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEVRGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getPSDEVRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupid", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getPSDEVRGroupId()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getPSDEVRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevrgroupname", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getPSDEVRGroupName()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEVRGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEVRGroupBase.getJSONValue((Object)pSDEVRGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEVRGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEVRGroupBase pSDEVRGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEVRGroupBase.getCodeName() != null) {
            object = pSDEVRGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getCreateDate() != null) {
            object = pSDEVRGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEVRGroupBase.getCreateMan() != null) {
            object = pSDEVRGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getGroupTag() != null) {
            object = pSDEVRGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getGroupTag2() != null) {
            object = pSDEVRGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getMemo() != null) {
            object = pSDEVRGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getOrderValue() != null) {
            object = pSDEVRGroupBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEVRGroupBase.getPSDEId() != null) {
            object = pSDEVRGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getPSDEName() != null) {
            object = pSDEVRGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getPSDEVRGroupId() != null) {
            object = pSDEVRGroupBase.getPSDEVRGroupId();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getPSDEVRGroupName() != null) {
            object = pSDEVRGroupBase.getPSDEVRGroupName();
            xmlNode.setAttribute(FIELD_PSDEVRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUpdateDate() != null) {
            object = pSDEVRGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEVRGroupBase.getUpdateMan() != null) {
            object = pSDEVRGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserCat() != null) {
            object = pSDEVRGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserParams() != null) {
            object = pSDEVRGroupBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserTag() != null) {
            object = pSDEVRGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserTag2() != null) {
            object = pSDEVRGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserTag3() != null) {
            object = pSDEVRGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEVRGroupBase.getUserTag4() != null) {
            object = pSDEVRGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEVRGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEVRGroupBase pSDEVRGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEVRGroupBase.isCodeNameDirty() && (bl || pSDEVRGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEVRGroupBase.getCodeName());
        }
        if (pSDEVRGroupBase.isCreateDateDirty() && (bl || pSDEVRGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEVRGroupBase.getCreateDate());
        }
        if (pSDEVRGroupBase.isCreateManDirty() && (bl || pSDEVRGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEVRGroupBase.getCreateMan());
        }
        if (pSDEVRGroupBase.isGroupTagDirty() && (bl || pSDEVRGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDEVRGroupBase.getGroupTag());
        }
        if (pSDEVRGroupBase.isGroupTag2Dirty() && (bl || pSDEVRGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDEVRGroupBase.getGroupTag2());
        }
        if (pSDEVRGroupBase.isMemoDirty() && (bl || pSDEVRGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEVRGroupBase.getMemo());
        }
        if (pSDEVRGroupBase.isOrderValueDirty() && (bl || pSDEVRGroupBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEVRGroupBase.getOrderValue());
        }
        if (pSDEVRGroupBase.isPSDEIdDirty() && (bl || pSDEVRGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEVRGroupBase.getPSDEId());
        }
        if (pSDEVRGroupBase.isPSDENameDirty() && (bl || pSDEVRGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEVRGroupBase.getPSDEName());
        }
        if (pSDEVRGroupBase.isPSDEVRGroupIdDirty() && (bl || pSDEVRGroupBase.getPSDEVRGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPID, (Object)pSDEVRGroupBase.getPSDEVRGroupId());
        }
        if (pSDEVRGroupBase.isPSDEVRGroupNameDirty() && (bl || pSDEVRGroupBase.getPSDEVRGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVRGROUPNAME, (Object)pSDEVRGroupBase.getPSDEVRGroupName());
        }
        if (pSDEVRGroupBase.isUpdateDateDirty() && (bl || pSDEVRGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEVRGroupBase.getUpdateDate());
        }
        if (pSDEVRGroupBase.isUpdateManDirty() && (bl || pSDEVRGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEVRGroupBase.getUpdateMan());
        }
        if (pSDEVRGroupBase.isUserCatDirty() && (bl || pSDEVRGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEVRGroupBase.getUserCat());
        }
        if (pSDEVRGroupBase.isUserParamsDirty() && (bl || pSDEVRGroupBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEVRGroupBase.getUserParams());
        }
        if (pSDEVRGroupBase.isUserTagDirty() && (bl || pSDEVRGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEVRGroupBase.getUserTag());
        }
        if (pSDEVRGroupBase.isUserTag2Dirty() && (bl || pSDEVRGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEVRGroupBase.getUserTag2());
        }
        if (pSDEVRGroupBase.isUserTag3Dirty() && (bl || pSDEVRGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEVRGroupBase.getUserTag3());
        }
        if (pSDEVRGroupBase.isUserTag4Dirty() && (bl || pSDEVRGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEVRGroupBase.getUserTag4());
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
        return PSDEVRGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEVRGroupBase pSDEVRGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEVRGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEVRGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEVRGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEVRGroupBase.resetGroupTag();
                return true;
            }
            case 4: {
                pSDEVRGroupBase.resetGroupTag2();
                return true;
            }
            case 5: {
                pSDEVRGroupBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEVRGroupBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDEVRGroupBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSDEVRGroupBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSDEVRGroupBase.resetPSDEVRGroupId();
                return true;
            }
            case 10: {
                pSDEVRGroupBase.resetPSDEVRGroupName();
                return true;
            }
            case 11: {
                pSDEVRGroupBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEVRGroupBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDEVRGroupBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDEVRGroupBase.resetUserParams();
                return true;
            }
            case 15: {
                pSDEVRGroupBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDEVRGroupBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDEVRGroupBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDEVRGroupBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEVRGrpDetail> getPSDEVRGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEVRGrpDetails();
        }
        if (this.getPSDEVRGroupId() == null) {
            return null;
        }
        PSDEVRGroupService pSDEVRGroupService = (PSDEVRGroupService)ServiceGlobal.getService(PSDEVRGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEVRGrpDetailService pSDEVRGrpDetailService = (PSDEVRGrpDetailService)ServiceGlobal.getService(PSDEVRGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEVRGrpDetailsLock;
        synchronized (n) {
            if (this.psdevrgrpdetails == null) {
                this.psdevrgrpdetails = pSDEVRGroupService.isTempData(this) ? pSDEVRGrpDetailService.selectTempByPSDEVRGroup(this) : pSDEVRGrpDetailService.selectByPSDEVRGroup(this);
            }
            return this.psdevrgrpdetails;
        }
    }

    private PSDEVRGroupBase getProxyEntity() {
        return this.proxyPSDEVRGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEVRGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEVRGroupBase) {
            this.proxyPSDEVRGroupBase = (PSDEVRGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_GROUPTAG, 3);
        fieldIndexMap.put(FIELD_GROUPTAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSDEVRGROUPID, 9);
        fieldIndexMap.put(FIELD_PSDEVRGROUPNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERPARAMS, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
    }
}

