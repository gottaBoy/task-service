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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERGroupDetailBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDERGROUPDETAILID = "PSDERGROUPDETAILID";
    public static final String FIELD_PSDERGROUPDETAILNAME = "PSDERGROUPDETAILNAME";
    public static final String FIELD_PSDERGROUPID = "PSDERGROUPID";
    public static final String FIELD_PSDERGROUPNAME = "PSDERGROUPNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
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
    private static final int INDEX_DATA = 4;
    private static final int INDEX_DETAILTAG = 5;
    private static final int INDEX_DETAILTAG2 = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSDERGROUPDETAILID = 9;
    private static final int INDEX_PSDERGROUPDETAILNAME = 10;
    private static final int INDEX_PSDERGROUPID = 11;
    private static final int INDEX_PSDERGROUPNAME = 12;
    private static final int INDEX_PSDERID = 13;
    private static final int INDEX_PSDERNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERGroupDetailBase proxyPSDERGroupDetailBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdergroupdetailidDirtyFlag = false;
    private boolean psdergroupdetailnameDirtyFlag = false;
    private boolean psdergroupidDirtyFlag = false;
    private boolean psdergroupnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
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
    @Column(name="data")
    private String data;
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdergroupdetailid")
    private String psdergroupdetailid;
    @Column(name="psdergroupdetailname")
    private String psdergroupdetailname;
    @Column(name="psdergroupid")
    private String psdergroupid;
    @Column(name="psdergroupname")
    private String psdergroupname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
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
    private Integer objPSDERGroupLock = new Integer(1);
    private PSDERGroup psdergroup = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;

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

    public void setDetailTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag = string;
        this.detailtagDirtyFlag = true;
    }

    public String getDetailTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag();
        }
        return this.detailtag;
    }

    public boolean isDetailTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTagDirty();
        }
        return this.detailtagDirtyFlag;
    }

    public void resetDetailTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag();
            return;
        }
        this.detailtagDirtyFlag = false;
        this.detailtag = null;
    }

    public void setDetailTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag2 = string;
        this.detailtag2DirtyFlag = true;
    }

    public String getDetailTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag2();
        }
        return this.detailtag2;
    }

    public boolean isDetailTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTag2Dirty();
        }
        return this.detailtag2DirtyFlag;
    }

    public void resetDetailTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag2();
            return;
        }
        this.detailtag2DirtyFlag = false;
        this.detailtag2 = null;
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

    public void setPSDERGroupDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupdetailid = string;
        this.psdergroupdetailidDirtyFlag = true;
    }

    public String getPSDERGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupDetailId();
        }
        return this.psdergroupdetailid;
    }

    public boolean isPSDERGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupDetailIdDirty();
        }
        return this.psdergroupdetailidDirtyFlag;
    }

    public void resetPSDERGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupDetailId();
            return;
        }
        this.psdergroupdetailidDirtyFlag = false;
        this.psdergroupdetailid = null;
    }

    public void setPSDERGroupDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupdetailname = string;
        this.psdergroupdetailnameDirtyFlag = true;
    }

    public String getPSDERGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupDetailName();
        }
        return this.psdergroupdetailname;
    }

    public boolean isPSDERGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupDetailNameDirty();
        }
        return this.psdergroupdetailnameDirtyFlag;
    }

    public void resetPSDERGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupDetailName();
            return;
        }
        this.psdergroupdetailnameDirtyFlag = false;
        this.psdergroupdetailname = null;
    }

    public void setPSDERGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupid = string;
        this.psdergroupidDirtyFlag = true;
    }

    public String getPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupId();
        }
        return this.psdergroupid;
    }

    public boolean isPSDERGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupIdDirty();
        }
        return this.psdergroupidDirtyFlag;
    }

    public void resetPSDERGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupId();
            return;
        }
        this.psdergroupidDirtyFlag = false;
        this.psdergroupid = null;
    }

    public void setPSDERGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdergroupname = string;
        this.psdergroupnameDirtyFlag = true;
    }

    public String getPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroupName();
        }
        return this.psdergroupname;
    }

    public boolean isPSDERGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERGroupNameDirty();
        }
        return this.psdergroupnameDirtyFlag;
    }

    public void resetPSDERGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERGroupName();
            return;
        }
        this.psdergroupnameDirtyFlag = false;
        this.psdergroupname = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
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
        PSDERGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERGroupDetailBase pSDERGroupDetailBase) {
        pSDERGroupDetailBase.resetCodeName();
        pSDERGroupDetailBase.resetCodeName2();
        pSDERGroupDetailBase.resetCreateDate();
        pSDERGroupDetailBase.resetCreateMan();
        pSDERGroupDetailBase.resetData();
        pSDERGroupDetailBase.resetDetailTag();
        pSDERGroupDetailBase.resetDetailTag2();
        pSDERGroupDetailBase.resetMemo();
        pSDERGroupDetailBase.resetOrderValue();
        pSDERGroupDetailBase.resetPSDERGroupDetailId();
        pSDERGroupDetailBase.resetPSDERGroupDetailName();
        pSDERGroupDetailBase.resetPSDERGroupId();
        pSDERGroupDetailBase.resetPSDERGroupName();
        pSDERGroupDetailBase.resetPSDERId();
        pSDERGroupDetailBase.resetPSDERName();
        pSDERGroupDetailBase.resetUpdateDate();
        pSDERGroupDetailBase.resetUpdateMan();
        pSDERGroupDetailBase.resetUserCat();
        pSDERGroupDetailBase.resetUserTag();
        pSDERGroupDetailBase.resetUserTag2();
        pSDERGroupDetailBase.resetUserTag3();
        pSDERGroupDetailBase.resetUserTag4();
        pSDERGroupDetailBase.resetValidFlag();
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
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDERGroupDetailIdDirty()) {
            hashMap.put(FIELD_PSDERGROUPDETAILID, this.getPSDERGroupDetailId());
        }
        if (!bl || this.isPSDERGroupDetailNameDirty()) {
            hashMap.put(FIELD_PSDERGROUPDETAILNAME, this.getPSDERGroupDetailName());
        }
        if (!bl || this.isPSDERGroupIdDirty()) {
            hashMap.put(FIELD_PSDERGROUPID, this.getPSDERGroupId());
        }
        if (!bl || this.isPSDERGroupNameDirty()) {
            hashMap.put(FIELD_PSDERGROUPNAME, this.getPSDERGroupName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
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
        return PSDERGroupDetailBase.get(this, n);
    }

    private static Object get(PSDERGroupDetailBase pSDERGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupDetailBase.getCodeName();
            }
            case 1: {
                return pSDERGroupDetailBase.getCodeName2();
            }
            case 2: {
                return pSDERGroupDetailBase.getCreateDate();
            }
            case 3: {
                return pSDERGroupDetailBase.getCreateMan();
            }
            case 4: {
                return pSDERGroupDetailBase.getData();
            }
            case 5: {
                return pSDERGroupDetailBase.getDetailTag();
            }
            case 6: {
                return pSDERGroupDetailBase.getDetailTag2();
            }
            case 7: {
                return pSDERGroupDetailBase.getMemo();
            }
            case 8: {
                return pSDERGroupDetailBase.getOrderValue();
            }
            case 9: {
                return pSDERGroupDetailBase.getPSDERGroupDetailId();
            }
            case 10: {
                return pSDERGroupDetailBase.getPSDERGroupDetailName();
            }
            case 11: {
                return pSDERGroupDetailBase.getPSDERGroupId();
            }
            case 12: {
                return pSDERGroupDetailBase.getPSDERGroupName();
            }
            case 13: {
                return pSDERGroupDetailBase.getPSDERId();
            }
            case 14: {
                return pSDERGroupDetailBase.getPSDERName();
            }
            case 15: {
                return pSDERGroupDetailBase.getUpdateDate();
            }
            case 16: {
                return pSDERGroupDetailBase.getUpdateMan();
            }
            case 17: {
                return pSDERGroupDetailBase.getUserCat();
            }
            case 18: {
                return pSDERGroupDetailBase.getUserTag();
            }
            case 19: {
                return pSDERGroupDetailBase.getUserTag2();
            }
            case 20: {
                return pSDERGroupDetailBase.getUserTag3();
            }
            case 21: {
                return pSDERGroupDetailBase.getUserTag4();
            }
            case 22: {
                return pSDERGroupDetailBase.getValidFlag();
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
        PSDERGroupDetailBase.set(this, n, object);
    }

    private static void set(PSDERGroupDetailBase pSDERGroupDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERGroupDetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDERGroupDetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDERGroupDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDERGroupDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERGroupDetailBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERGroupDetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERGroupDetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERGroupDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERGroupDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDERGroupDetailBase.setPSDERGroupDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERGroupDetailBase.setPSDERGroupDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERGroupDetailBase.setPSDERGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDERGroupDetailBase.setPSDERGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERGroupDetailBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERGroupDetailBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERGroupDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDERGroupDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDERGroupDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDERGroupDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDERGroupDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDERGroupDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDERGroupDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDERGroupDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDERGroupDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDERGroupDetailBase pSDERGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupDetailBase.getCodeName() == null;
            }
            case 1: {
                return pSDERGroupDetailBase.getCodeName2() == null;
            }
            case 2: {
                return pSDERGroupDetailBase.getCreateDate() == null;
            }
            case 3: {
                return pSDERGroupDetailBase.getCreateMan() == null;
            }
            case 4: {
                return pSDERGroupDetailBase.getData() == null;
            }
            case 5: {
                return pSDERGroupDetailBase.getDetailTag() == null;
            }
            case 6: {
                return pSDERGroupDetailBase.getDetailTag2() == null;
            }
            case 7: {
                return pSDERGroupDetailBase.getMemo() == null;
            }
            case 8: {
                return pSDERGroupDetailBase.getOrderValue() == null;
            }
            case 9: {
                return pSDERGroupDetailBase.getPSDERGroupDetailId() == null;
            }
            case 10: {
                return pSDERGroupDetailBase.getPSDERGroupDetailName() == null;
            }
            case 11: {
                return pSDERGroupDetailBase.getPSDERGroupId() == null;
            }
            case 12: {
                return pSDERGroupDetailBase.getPSDERGroupName() == null;
            }
            case 13: {
                return pSDERGroupDetailBase.getPSDERId() == null;
            }
            case 14: {
                return pSDERGroupDetailBase.getPSDERName() == null;
            }
            case 15: {
                return pSDERGroupDetailBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDERGroupDetailBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDERGroupDetailBase.getUserCat() == null;
            }
            case 18: {
                return pSDERGroupDetailBase.getUserTag() == null;
            }
            case 19: {
                return pSDERGroupDetailBase.getUserTag2() == null;
            }
            case 20: {
                return pSDERGroupDetailBase.getUserTag3() == null;
            }
            case 21: {
                return pSDERGroupDetailBase.getUserTag4() == null;
            }
            case 22: {
                return pSDERGroupDetailBase.getValidFlag() == null;
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
        return PSDERGroupDetailBase.contains(this, n);
    }

    private static boolean contains(PSDERGroupDetailBase pSDERGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERGroupDetailBase.isCodeNameDirty();
            }
            case 1: {
                return pSDERGroupDetailBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDERGroupDetailBase.isCreateDateDirty();
            }
            case 3: {
                return pSDERGroupDetailBase.isCreateManDirty();
            }
            case 4: {
                return pSDERGroupDetailBase.isDataDirty();
            }
            case 5: {
                return pSDERGroupDetailBase.isDetailTagDirty();
            }
            case 6: {
                return pSDERGroupDetailBase.isDetailTag2Dirty();
            }
            case 7: {
                return pSDERGroupDetailBase.isMemoDirty();
            }
            case 8: {
                return pSDERGroupDetailBase.isOrderValueDirty();
            }
            case 9: {
                return pSDERGroupDetailBase.isPSDERGroupDetailIdDirty();
            }
            case 10: {
                return pSDERGroupDetailBase.isPSDERGroupDetailNameDirty();
            }
            case 11: {
                return pSDERGroupDetailBase.isPSDERGroupIdDirty();
            }
            case 12: {
                return pSDERGroupDetailBase.isPSDERGroupNameDirty();
            }
            case 13: {
                return pSDERGroupDetailBase.isPSDERIdDirty();
            }
            case 14: {
                return pSDERGroupDetailBase.isPSDERNameDirty();
            }
            case 15: {
                return pSDERGroupDetailBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDERGroupDetailBase.isUpdateManDirty();
            }
            case 17: {
                return pSDERGroupDetailBase.isUserCatDirty();
            }
            case 18: {
                return pSDERGroupDetailBase.isUserTagDirty();
            }
            case 19: {
                return pSDERGroupDetailBase.isUserTag2Dirty();
            }
            case 20: {
                return pSDERGroupDetailBase.isUserTag3Dirty();
            }
            case 21: {
                return pSDERGroupDetailBase.isUserTag4Dirty();
            }
            case 22: {
                return pSDERGroupDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERGroupDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERGroupDetailBase pSDERGroupDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERGroupDetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getData()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupdetailid", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERGroupDetailId()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupdetailname", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERGroupDetailName()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupid", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERGroupId()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdergroupname", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERGroupName()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDERGroupDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERGroupDetailBase.getJSONValue((Object)pSDERGroupDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERGroupDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERGroupDetailBase pSDERGroupDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERGroupDetailBase.getCodeName() != null) {
            object = pSDERGroupDetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDERGroupDetailBase.getCodeName2() != null) {
            object = pSDERGroupDetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getCreateDate() != null) {
            object = pSDERGroupDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERGroupDetailBase.getCreateMan() != null) {
            object = pSDERGroupDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getData() != null) {
            object = pSDERGroupDetailBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getDetailTag() != null) {
            object = pSDERGroupDetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getDetailTag2() != null) {
            object = pSDERGroupDetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getMemo() != null) {
            object = pSDERGroupDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getOrderValue() != null) {
            object = pSDERGroupDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupDetailId() != null) {
            object = pSDERGroupDetailBase.getPSDERGroupDetailId();
            xmlNode.setAttribute(FIELD_PSDERGROUPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupDetailName() != null) {
            object = pSDERGroupDetailBase.getPSDERGroupDetailName();
            xmlNode.setAttribute(FIELD_PSDERGROUPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupId() != null) {
            object = pSDERGroupDetailBase.getPSDERGroupId();
            xmlNode.setAttribute(FIELD_PSDERGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getPSDERGroupName() != null) {
            object = pSDERGroupDetailBase.getPSDERGroupName();
            xmlNode.setAttribute(FIELD_PSDERGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getPSDERId() != null) {
            object = pSDERGroupDetailBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getPSDERName() != null) {
            object = pSDERGroupDetailBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUpdateDate() != null) {
            object = pSDERGroupDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERGroupDetailBase.getUpdateMan() != null) {
            object = pSDERGroupDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUserCat() != null) {
            object = pSDERGroupDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUserTag() != null) {
            object = pSDERGroupDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUserTag2() != null) {
            object = pSDERGroupDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUserTag3() != null) {
            object = pSDERGroupDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getUserTag4() != null) {
            object = pSDERGroupDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDERGroupDetailBase.getValidFlag() != null) {
            object = pSDERGroupDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERGroupDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERGroupDetailBase pSDERGroupDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERGroupDetailBase.isCodeNameDirty() && (bl || pSDERGroupDetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDERGroupDetailBase.getCodeName());
        }
        if (pSDERGroupDetailBase.isCodeName2Dirty() && (bl || pSDERGroupDetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDERGroupDetailBase.getCodeName2());
        }
        if (pSDERGroupDetailBase.isCreateDateDirty() && (bl || pSDERGroupDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERGroupDetailBase.getCreateDate());
        }
        if (pSDERGroupDetailBase.isCreateManDirty() && (bl || pSDERGroupDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERGroupDetailBase.getCreateMan());
        }
        if (pSDERGroupDetailBase.isDataDirty() && (bl || pSDERGroupDetailBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDERGroupDetailBase.getData());
        }
        if (pSDERGroupDetailBase.isDetailTagDirty() && (bl || pSDERGroupDetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSDERGroupDetailBase.getDetailTag());
        }
        if (pSDERGroupDetailBase.isDetailTag2Dirty() && (bl || pSDERGroupDetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSDERGroupDetailBase.getDetailTag2());
        }
        if (pSDERGroupDetailBase.isMemoDirty() && (bl || pSDERGroupDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERGroupDetailBase.getMemo());
        }
        if (pSDERGroupDetailBase.isOrderValueDirty() && (bl || pSDERGroupDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERGroupDetailBase.getOrderValue());
        }
        if (pSDERGroupDetailBase.isPSDERGroupDetailIdDirty() && (bl || pSDERGroupDetailBase.getPSDERGroupDetailId() != null)) {
            iDataObject.set(FIELD_PSDERGROUPDETAILID, (Object)pSDERGroupDetailBase.getPSDERGroupDetailId());
        }
        if (pSDERGroupDetailBase.isPSDERGroupDetailNameDirty() && (bl || pSDERGroupDetailBase.getPSDERGroupDetailName() != null)) {
            iDataObject.set(FIELD_PSDERGROUPDETAILNAME, (Object)pSDERGroupDetailBase.getPSDERGroupDetailName());
        }
        if (pSDERGroupDetailBase.isPSDERGroupIdDirty() && (bl || pSDERGroupDetailBase.getPSDERGroupId() != null)) {
            iDataObject.set(FIELD_PSDERGROUPID, (Object)pSDERGroupDetailBase.getPSDERGroupId());
        }
        if (pSDERGroupDetailBase.isPSDERGroupNameDirty() && (bl || pSDERGroupDetailBase.getPSDERGroupName() != null)) {
            iDataObject.set(FIELD_PSDERGROUPNAME, (Object)pSDERGroupDetailBase.getPSDERGroupName());
        }
        if (pSDERGroupDetailBase.isPSDERIdDirty() && (bl || pSDERGroupDetailBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDERGroupDetailBase.getPSDERId());
        }
        if (pSDERGroupDetailBase.isPSDERNameDirty() && (bl || pSDERGroupDetailBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDERGroupDetailBase.getPSDERName());
        }
        if (pSDERGroupDetailBase.isUpdateDateDirty() && (bl || pSDERGroupDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERGroupDetailBase.getUpdateDate());
        }
        if (pSDERGroupDetailBase.isUpdateManDirty() && (bl || pSDERGroupDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERGroupDetailBase.getUpdateMan());
        }
        if (pSDERGroupDetailBase.isUserCatDirty() && (bl || pSDERGroupDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDERGroupDetailBase.getUserCat());
        }
        if (pSDERGroupDetailBase.isUserTagDirty() && (bl || pSDERGroupDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERGroupDetailBase.getUserTag());
        }
        if (pSDERGroupDetailBase.isUserTag2Dirty() && (bl || pSDERGroupDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERGroupDetailBase.getUserTag2());
        }
        if (pSDERGroupDetailBase.isUserTag3Dirty() && (bl || pSDERGroupDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDERGroupDetailBase.getUserTag3());
        }
        if (pSDERGroupDetailBase.isUserTag4Dirty() && (bl || pSDERGroupDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDERGroupDetailBase.getUserTag4());
        }
        if (pSDERGroupDetailBase.isValidFlagDirty() && (bl || pSDERGroupDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERGroupDetailBase.getValidFlag());
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
        return PSDERGroupDetailBase.remove(this, n);
    }

    private static boolean remove(PSDERGroupDetailBase pSDERGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERGroupDetailBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDERGroupDetailBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDERGroupDetailBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDERGroupDetailBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDERGroupDetailBase.resetData();
                return true;
            }
            case 5: {
                pSDERGroupDetailBase.resetDetailTag();
                return true;
            }
            case 6: {
                pSDERGroupDetailBase.resetDetailTag2();
                return true;
            }
            case 7: {
                pSDERGroupDetailBase.resetMemo();
                return true;
            }
            case 8: {
                pSDERGroupDetailBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDERGroupDetailBase.resetPSDERGroupDetailId();
                return true;
            }
            case 10: {
                pSDERGroupDetailBase.resetPSDERGroupDetailName();
                return true;
            }
            case 11: {
                pSDERGroupDetailBase.resetPSDERGroupId();
                return true;
            }
            case 12: {
                pSDERGroupDetailBase.resetPSDERGroupName();
                return true;
            }
            case 13: {
                pSDERGroupDetailBase.resetPSDERId();
                return true;
            }
            case 14: {
                pSDERGroupDetailBase.resetPSDERName();
                return true;
            }
            case 15: {
                pSDERGroupDetailBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDERGroupDetailBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDERGroupDetailBase.resetUserCat();
                return true;
            }
            case 18: {
                pSDERGroupDetailBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDERGroupDetailBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSDERGroupDetailBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSDERGroupDetailBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSDERGroupDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDERGroup getPSDERGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroup();
        }
        if (this.getPSDERGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDERGroupLock;
        synchronized (n) {
            if (this.psdergroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERGroupId(), (Object)this.psdergroup.getPSDERGroupId()) != 0L) {
                this.psdergroup = null;
            }
            if (this.psdergroup == null) {
                PSDERGroup pSDERGroup = new PSDERGroup();
                pSDERGroup.setPSDERGroupId(this.getPSDERGroupId());
                PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDERGroupService.autoGet((IEntity)pSDERGroup);
                this.psdergroup = pSDERGroup;
            }
            return this.psdergroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    private PSDERGroupDetailBase getProxyEntity() {
        return this.proxyPSDERGroupDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERGroupDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERGroupDetailBase) {
            this.proxyPSDERGroupDetailBase = (PSDERGroupDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATA, 4);
        fieldIndexMap.put(FIELD_DETAILTAG, 5);
        fieldIndexMap.put(FIELD_DETAILTAG2, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSDERGROUPDETAILID, 9);
        fieldIndexMap.put(FIELD_PSDERGROUPDETAILNAME, 10);
        fieldIndexMap.put(FIELD_PSDERGROUPID, 11);
        fieldIndexMap.put(FIELD_PSDERGROUPNAME, 12);
        fieldIndexMap.put(FIELD_PSDERID, 13);
        fieldIndexMap.put(FIELD_PSDERNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

