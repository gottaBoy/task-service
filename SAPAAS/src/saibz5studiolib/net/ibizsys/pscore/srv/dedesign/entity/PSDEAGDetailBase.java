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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAGDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEAGDetailBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEACTIONGROUPID = "PSDEACTIONGROUPID";
    public static final String FIELD_PSDEACTIONGROUPNAME = "PSDEACTIONGROUPNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEAGDETAILID = "PSDEAGDETAILID";
    public static final String FIELD_PSDEAGDETAILNAME = "PSDEAGDETAILNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DETAILTYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEACTIONGROUPID = 7;
    private static final int INDEX_PSDEACTIONGROUPNAME = 8;
    private static final int INDEX_PSDEACTIONID = 9;
    private static final int INDEX_PSDEACTIONNAME = 10;
    private static final int INDEX_PSDEAGDETAILID = 11;
    private static final int INDEX_PSDEAGDETAILNAME = 12;
    private static final int INDEX_PSDEDATASETID = 13;
    private static final int INDEX_PSDEDATASETNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEAGDetailBase proxyPSDEAGDetailBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeactiongroupidDirtyFlag = false;
    private boolean psdeactiongroupnameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeagdetailidDirtyFlag = false;
    private boolean psdeagdetailnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeactiongroupid")
    private String psdeactiongroupid;
    @Column(name="psdeactiongroupname")
    private String psdeactiongroupname;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeagdetailid")
    private String psdeagdetailid;
    @Column(name="psdeagdetailname")
    private String psdeagdetailname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
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
    private Integer objPSDEActionGroupLock = new Integer(1);
    private PSDEActionGroup psdeactiongroup = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;

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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setDetailType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtype = string;
        this.detailtypeDirtyFlag = true;
    }

    public String getDetailType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailType();
        }
        return this.detailtype;
    }

    public boolean isDetailTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTypeDirty();
        }
        return this.detailtypeDirtyFlag;
    }

    public void resetDetailType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailType();
            return;
        }
        this.detailtypeDirtyFlag = false;
        this.detailtype = null;
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

    public void setPSDEActionGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiongroupid = string;
        this.psdeactiongroupidDirtyFlag = true;
    }

    public String getPSDEActionGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroupId();
        }
        return this.psdeactiongroupid;
    }

    public boolean isPSDEActionGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionGroupIdDirty();
        }
        return this.psdeactiongroupidDirtyFlag;
    }

    public void resetPSDEActionGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionGroupId();
            return;
        }
        this.psdeactiongroupidDirtyFlag = false;
        this.psdeactiongroupid = null;
    }

    public void setPSDEActionGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiongroupname = string;
        this.psdeactiongroupnameDirtyFlag = true;
    }

    public String getPSDEActionGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroupName();
        }
        return this.psdeactiongroupname;
    }

    public boolean isPSDEActionGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionGroupNameDirty();
        }
        return this.psdeactiongroupnameDirtyFlag;
    }

    public void resetPSDEActionGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionGroupName();
            return;
        }
        this.psdeactiongroupnameDirtyFlag = false;
        this.psdeactiongroupname = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEAGDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAGDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeagdetailid = string;
        this.psdeagdetailidDirtyFlag = true;
    }

    public String getPSDEAGDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAGDetailId();
        }
        return this.psdeagdetailid;
    }

    public boolean isPSDEAGDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAGDetailIdDirty();
        }
        return this.psdeagdetailidDirtyFlag;
    }

    public void resetPSDEAGDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAGDetailId();
            return;
        }
        this.psdeagdetailidDirtyFlag = false;
        this.psdeagdetailid = null;
    }

    public void setPSDEAGDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAGDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeagdetailname = string;
        this.psdeagdetailnameDirtyFlag = true;
    }

    public String getPSDEAGDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAGDetailName();
        }
        return this.psdeagdetailname;
    }

    public boolean isPSDEAGDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAGDetailNameDirty();
        }
        return this.psdeagdetailnameDirtyFlag;
    }

    public void resetPSDEAGDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAGDetailName();
            return;
        }
        this.psdeagdetailnameDirtyFlag = false;
        this.psdeagdetailname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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
        PSDEAGDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEAGDetailBase pSDEAGDetailBase) {
        pSDEAGDetailBase.resetCodeName();
        pSDEAGDetailBase.resetCodeName2();
        pSDEAGDetailBase.resetCreateDate();
        pSDEAGDetailBase.resetCreateMan();
        pSDEAGDetailBase.resetDetailType();
        pSDEAGDetailBase.resetMemo();
        pSDEAGDetailBase.resetOrderValue();
        pSDEAGDetailBase.resetPSDEActionGroupId();
        pSDEAGDetailBase.resetPSDEActionGroupName();
        pSDEAGDetailBase.resetPSDEActionId();
        pSDEAGDetailBase.resetPSDEActionName();
        pSDEAGDetailBase.resetPSDEAGDetailId();
        pSDEAGDetailBase.resetPSDEAGDetailName();
        pSDEAGDetailBase.resetPSDEDataSetId();
        pSDEAGDetailBase.resetPSDEDataSetName();
        pSDEAGDetailBase.resetPSDEId();
        pSDEAGDetailBase.resetUpdateDate();
        pSDEAGDetailBase.resetUpdateMan();
        pSDEAGDetailBase.resetUserCat();
        pSDEAGDetailBase.resetUserTag();
        pSDEAGDetailBase.resetUserTag2();
        pSDEAGDetailBase.resetUserTag3();
        pSDEAGDetailBase.resetUserTag4();
        pSDEAGDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEActionGroupIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONGROUPID, this.getPSDEActionGroupId());
        }
        if (!bl || this.isPSDEActionGroupNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONGROUPNAME, this.getPSDEActionGroupName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEAGDetailIdDirty()) {
            hashMap.put(FIELD_PSDEAGDETAILID, this.getPSDEAGDetailId());
        }
        if (!bl || this.isPSDEAGDetailNameDirty()) {
            hashMap.put(FIELD_PSDEAGDETAILNAME, this.getPSDEAGDetailName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        return PSDEAGDetailBase.get(this, n);
    }

    private static Object get(PSDEAGDetailBase pSDEAGDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAGDetailBase.getCodeName();
            }
            case 1: {
                return pSDEAGDetailBase.getCodeName2();
            }
            case 2: {
                return pSDEAGDetailBase.getCreateDate();
            }
            case 3: {
                return pSDEAGDetailBase.getCreateMan();
            }
            case 4: {
                return pSDEAGDetailBase.getDetailType();
            }
            case 5: {
                return pSDEAGDetailBase.getMemo();
            }
            case 6: {
                return pSDEAGDetailBase.getOrderValue();
            }
            case 7: {
                return pSDEAGDetailBase.getPSDEActionGroupId();
            }
            case 8: {
                return pSDEAGDetailBase.getPSDEActionGroupName();
            }
            case 9: {
                return pSDEAGDetailBase.getPSDEActionId();
            }
            case 10: {
                return pSDEAGDetailBase.getPSDEActionName();
            }
            case 11: {
                return pSDEAGDetailBase.getPSDEAGDetailId();
            }
            case 12: {
                return pSDEAGDetailBase.getPSDEAGDetailName();
            }
            case 13: {
                return pSDEAGDetailBase.getPSDEDataSetId();
            }
            case 14: {
                return pSDEAGDetailBase.getPSDEDataSetName();
            }
            case 15: {
                return pSDEAGDetailBase.getPSDEId();
            }
            case 16: {
                return pSDEAGDetailBase.getUpdateDate();
            }
            case 17: {
                return pSDEAGDetailBase.getUpdateMan();
            }
            case 18: {
                return pSDEAGDetailBase.getUserCat();
            }
            case 19: {
                return pSDEAGDetailBase.getUserTag();
            }
            case 20: {
                return pSDEAGDetailBase.getUserTag2();
            }
            case 21: {
                return pSDEAGDetailBase.getUserTag3();
            }
            case 22: {
                return pSDEAGDetailBase.getUserTag4();
            }
            case 23: {
                return pSDEAGDetailBase.getValidFlag();
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
        PSDEAGDetailBase.set(this, n, object);
    }

    private static void set(PSDEAGDetailBase pSDEAGDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEAGDetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEAGDetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEAGDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEAGDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEAGDetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEAGDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEAGDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEAGDetailBase.setPSDEActionGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEAGDetailBase.setPSDEActionGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEAGDetailBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEAGDetailBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEAGDetailBase.setPSDEAGDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEAGDetailBase.setPSDEAGDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEAGDetailBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEAGDetailBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEAGDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEAGDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEAGDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEAGDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEAGDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEAGDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEAGDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEAGDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEAGDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEAGDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEAGDetailBase pSDEAGDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAGDetailBase.getCodeName() == null;
            }
            case 1: {
                return pSDEAGDetailBase.getCodeName2() == null;
            }
            case 2: {
                return pSDEAGDetailBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEAGDetailBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEAGDetailBase.getDetailType() == null;
            }
            case 5: {
                return pSDEAGDetailBase.getMemo() == null;
            }
            case 6: {
                return pSDEAGDetailBase.getOrderValue() == null;
            }
            case 7: {
                return pSDEAGDetailBase.getPSDEActionGroupId() == null;
            }
            case 8: {
                return pSDEAGDetailBase.getPSDEActionGroupName() == null;
            }
            case 9: {
                return pSDEAGDetailBase.getPSDEActionId() == null;
            }
            case 10: {
                return pSDEAGDetailBase.getPSDEActionName() == null;
            }
            case 11: {
                return pSDEAGDetailBase.getPSDEAGDetailId() == null;
            }
            case 12: {
                return pSDEAGDetailBase.getPSDEAGDetailName() == null;
            }
            case 13: {
                return pSDEAGDetailBase.getPSDEDataSetId() == null;
            }
            case 14: {
                return pSDEAGDetailBase.getPSDEDataSetName() == null;
            }
            case 15: {
                return pSDEAGDetailBase.getPSDEId() == null;
            }
            case 16: {
                return pSDEAGDetailBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDEAGDetailBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDEAGDetailBase.getUserCat() == null;
            }
            case 19: {
                return pSDEAGDetailBase.getUserTag() == null;
            }
            case 20: {
                return pSDEAGDetailBase.getUserTag2() == null;
            }
            case 21: {
                return pSDEAGDetailBase.getUserTag3() == null;
            }
            case 22: {
                return pSDEAGDetailBase.getUserTag4() == null;
            }
            case 23: {
                return pSDEAGDetailBase.getValidFlag() == null;
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
        return PSDEAGDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEAGDetailBase pSDEAGDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAGDetailBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEAGDetailBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDEAGDetailBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEAGDetailBase.isCreateManDirty();
            }
            case 4: {
                return pSDEAGDetailBase.isDetailTypeDirty();
            }
            case 5: {
                return pSDEAGDetailBase.isMemoDirty();
            }
            case 6: {
                return pSDEAGDetailBase.isOrderValueDirty();
            }
            case 7: {
                return pSDEAGDetailBase.isPSDEActionGroupIdDirty();
            }
            case 8: {
                return pSDEAGDetailBase.isPSDEActionGroupNameDirty();
            }
            case 9: {
                return pSDEAGDetailBase.isPSDEActionIdDirty();
            }
            case 10: {
                return pSDEAGDetailBase.isPSDEActionNameDirty();
            }
            case 11: {
                return pSDEAGDetailBase.isPSDEAGDetailIdDirty();
            }
            case 12: {
                return pSDEAGDetailBase.isPSDEAGDetailNameDirty();
            }
            case 13: {
                return pSDEAGDetailBase.isPSDEDataSetIdDirty();
            }
            case 14: {
                return pSDEAGDetailBase.isPSDEDataSetNameDirty();
            }
            case 15: {
                return pSDEAGDetailBase.isPSDEIdDirty();
            }
            case 16: {
                return pSDEAGDetailBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDEAGDetailBase.isUpdateManDirty();
            }
            case 18: {
                return pSDEAGDetailBase.isUserCatDirty();
            }
            case 19: {
                return pSDEAGDetailBase.isUserTagDirty();
            }
            case 20: {
                return pSDEAGDetailBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDEAGDetailBase.isUserTag3Dirty();
            }
            case 22: {
                return pSDEAGDetailBase.isUserTag4Dirty();
            }
            case 23: {
                return pSDEAGDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEAGDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEAGDetailBase pSDEAGDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEAGDetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiongroupid", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEActionGroupId()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiongroupname", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEActionGroupName()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEAGDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeagdetailid", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEAGDetailId()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEAGDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeagdetailname", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEAGDetailName()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEAGDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEAGDetailBase.getJSONValue((Object)pSDEAGDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEAGDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEAGDetailBase pSDEAGDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEAGDetailBase.getCodeName() != null) {
            object = pSDEAGDetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEAGDetailBase.getCodeName2() != null) {
            object = pSDEAGDetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getCreateDate() != null) {
            object = pSDEAGDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAGDetailBase.getCreateMan() != null) {
            object = pSDEAGDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getDetailType() != null) {
            object = pSDEAGDetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getMemo() != null) {
            object = pSDEAGDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getOrderValue() != null) {
            object = pSDEAGDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEAGDetailBase.getPSDEActionGroupId() != null) {
            object = pSDEAGDetailBase.getPSDEActionGroupId();
            xmlNode.setAttribute(FIELD_PSDEACTIONGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionGroupName() != null) {
            object = pSDEAGDetailBase.getPSDEActionGroupName();
            xmlNode.setAttribute(FIELD_PSDEACTIONGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionId() != null) {
            object = pSDEAGDetailBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEActionName() != null) {
            object = pSDEAGDetailBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEAGDetailId() != null) {
            object = pSDEAGDetailBase.getPSDEAGDetailId();
            xmlNode.setAttribute(FIELD_PSDEAGDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEAGDetailName() != null) {
            object = pSDEAGDetailBase.getPSDEAGDetailName();
            xmlNode.setAttribute(FIELD_PSDEAGDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEDataSetId() != null) {
            object = pSDEAGDetailBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEDataSetName() != null) {
            object = pSDEAGDetailBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getPSDEId() != null) {
            object = pSDEAGDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUpdateDate() != null) {
            object = pSDEAGDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAGDetailBase.getUpdateMan() != null) {
            object = pSDEAGDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUserCat() != null) {
            object = pSDEAGDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUserTag() != null) {
            object = pSDEAGDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUserTag2() != null) {
            object = pSDEAGDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUserTag3() != null) {
            object = pSDEAGDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getUserTag4() != null) {
            object = pSDEAGDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEAGDetailBase.getValidFlag() != null) {
            object = pSDEAGDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEAGDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEAGDetailBase pSDEAGDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEAGDetailBase.isCodeNameDirty() && (bl || pSDEAGDetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEAGDetailBase.getCodeName());
        }
        if (pSDEAGDetailBase.isCodeName2Dirty() && (bl || pSDEAGDetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEAGDetailBase.getCodeName2());
        }
        if (pSDEAGDetailBase.isCreateDateDirty() && (bl || pSDEAGDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEAGDetailBase.getCreateDate());
        }
        if (pSDEAGDetailBase.isCreateManDirty() && (bl || pSDEAGDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEAGDetailBase.getCreateMan());
        }
        if (pSDEAGDetailBase.isDetailTypeDirty() && (bl || pSDEAGDetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDEAGDetailBase.getDetailType());
        }
        if (pSDEAGDetailBase.isMemoDirty() && (bl || pSDEAGDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEAGDetailBase.getMemo());
        }
        if (pSDEAGDetailBase.isOrderValueDirty() && (bl || pSDEAGDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEAGDetailBase.getOrderValue());
        }
        if (pSDEAGDetailBase.isPSDEActionGroupIdDirty() && (bl || pSDEAGDetailBase.getPSDEActionGroupId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONGROUPID, (Object)pSDEAGDetailBase.getPSDEActionGroupId());
        }
        if (pSDEAGDetailBase.isPSDEActionGroupNameDirty() && (bl || pSDEAGDetailBase.getPSDEActionGroupName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONGROUPNAME, (Object)pSDEAGDetailBase.getPSDEActionGroupName());
        }
        if (pSDEAGDetailBase.isPSDEActionIdDirty() && (bl || pSDEAGDetailBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEAGDetailBase.getPSDEActionId());
        }
        if (pSDEAGDetailBase.isPSDEActionNameDirty() && (bl || pSDEAGDetailBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEAGDetailBase.getPSDEActionName());
        }
        if (pSDEAGDetailBase.isPSDEAGDetailIdDirty() && (bl || pSDEAGDetailBase.getPSDEAGDetailId() != null)) {
            iDataObject.set(FIELD_PSDEAGDETAILID, (Object)pSDEAGDetailBase.getPSDEAGDetailId());
        }
        if (pSDEAGDetailBase.isPSDEAGDetailNameDirty() && (bl || pSDEAGDetailBase.getPSDEAGDetailName() != null)) {
            iDataObject.set(FIELD_PSDEAGDETAILNAME, (Object)pSDEAGDetailBase.getPSDEAGDetailName());
        }
        if (pSDEAGDetailBase.isPSDEDataSetIdDirty() && (bl || pSDEAGDetailBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEAGDetailBase.getPSDEDataSetId());
        }
        if (pSDEAGDetailBase.isPSDEDataSetNameDirty() && (bl || pSDEAGDetailBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEAGDetailBase.getPSDEDataSetName());
        }
        if (pSDEAGDetailBase.isPSDEIdDirty() && (bl || pSDEAGDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEAGDetailBase.getPSDEId());
        }
        if (pSDEAGDetailBase.isUpdateDateDirty() && (bl || pSDEAGDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEAGDetailBase.getUpdateDate());
        }
        if (pSDEAGDetailBase.isUpdateManDirty() && (bl || pSDEAGDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEAGDetailBase.getUpdateMan());
        }
        if (pSDEAGDetailBase.isUserCatDirty() && (bl || pSDEAGDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEAGDetailBase.getUserCat());
        }
        if (pSDEAGDetailBase.isUserTagDirty() && (bl || pSDEAGDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEAGDetailBase.getUserTag());
        }
        if (pSDEAGDetailBase.isUserTag2Dirty() && (bl || pSDEAGDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEAGDetailBase.getUserTag2());
        }
        if (pSDEAGDetailBase.isUserTag3Dirty() && (bl || pSDEAGDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEAGDetailBase.getUserTag3());
        }
        if (pSDEAGDetailBase.isUserTag4Dirty() && (bl || pSDEAGDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEAGDetailBase.getUserTag4());
        }
        if (pSDEAGDetailBase.isValidFlagDirty() && (bl || pSDEAGDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEAGDetailBase.getValidFlag());
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
        return PSDEAGDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEAGDetailBase pSDEAGDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEAGDetailBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEAGDetailBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDEAGDetailBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEAGDetailBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEAGDetailBase.resetDetailType();
                return true;
            }
            case 5: {
                pSDEAGDetailBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEAGDetailBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDEAGDetailBase.resetPSDEActionGroupId();
                return true;
            }
            case 8: {
                pSDEAGDetailBase.resetPSDEActionGroupName();
                return true;
            }
            case 9: {
                pSDEAGDetailBase.resetPSDEActionId();
                return true;
            }
            case 10: {
                pSDEAGDetailBase.resetPSDEActionName();
                return true;
            }
            case 11: {
                pSDEAGDetailBase.resetPSDEAGDetailId();
                return true;
            }
            case 12: {
                pSDEAGDetailBase.resetPSDEAGDetailName();
                return true;
            }
            case 13: {
                pSDEAGDetailBase.resetPSDEDataSetId();
                return true;
            }
            case 14: {
                pSDEAGDetailBase.resetPSDEDataSetName();
                return true;
            }
            case 15: {
                pSDEAGDetailBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSDEAGDetailBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDEAGDetailBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDEAGDetailBase.resetUserCat();
                return true;
            }
            case 19: {
                pSDEAGDetailBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDEAGDetailBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDEAGDetailBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSDEAGDetailBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSDEAGDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEActionGroup getPSDEActionGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionGroup();
        }
        if (this.getPSDEActionGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionGroupLock;
        synchronized (n) {
            if (this.psdeactiongroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionGroupId(), (Object)this.psdeactiongroup.getPSDEActionGroupId()) != 0L) {
                this.psdeactiongroup = null;
            }
            if (this.psdeactiongroup == null) {
                PSDEActionGroup pSDEActionGroup = new PSDEActionGroup();
                pSDEActionGroup.setPSDEActionGroupId(this.getPSDEActionGroupId());
                PSDEActionGroupService pSDEActionGroupService = (PSDEActionGroupService)ServiceGlobal.getService(PSDEActionGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionGroupService.autoGet(pSDEActionGroup);
                this.psdeactiongroup = pSDEActionGroup;
            }
            return this.psdeactiongroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    private PSDEAGDetailBase getProxyEntity() {
        return this.proxyPSDEAGDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEAGDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEAGDetailBase) {
            this.proxyPSDEAGDetailBase = (PSDEAGDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DETAILTYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEACTIONGROUPID, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONGROUPNAME, 8);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 9);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 10);
        fieldIndexMap.put(FIELD_PSDEAGDETAILID, 11);
        fieldIndexMap.put(FIELD_PSDEAGDETAILNAME, 12);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 13);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

