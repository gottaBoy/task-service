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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionVRBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionVRBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEACTIONVRID = "PSDEACTIONVRID";
    public static final String FIELD_PSDEACTIONVRNAME = "PSDEACTIONVRNAME";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VRTYPE = "VRTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEACTIONID = 5;
    private static final int INDEX_PSDEACTIONNAME = 6;
    private static final int INDEX_PSDEACTIONVRID = 7;
    private static final int INDEX_PSDEACTIONVRNAME = 8;
    private static final int INDEX_PSDEFVRID = 9;
    private static final int INDEX_PSDEFVRNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final int INDEX_VRTYPE = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionVRBase proxyPSDEActionVRBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeactionvridDirtyFlag = false;
    private boolean psdeactionvrnameDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vrtypeDirtyFlag = false;
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
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeactionvrid")
    private String psdeactionvrid;
    @Column(name="psdeactionvrname")
    private String psdeactionvrname;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
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
    @Column(name="vrtype")
    private String vrtype;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;

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

    public void setPSDEActionVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionvrid = string;
        this.psdeactionvridDirtyFlag = true;
    }

    public String getPSDEActionVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionVRId();
        }
        return this.psdeactionvrid;
    }

    public boolean isPSDEActionVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionVRIdDirty();
        }
        return this.psdeactionvridDirtyFlag;
    }

    public void resetPSDEActionVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionVRId();
            return;
        }
        this.psdeactionvridDirtyFlag = false;
        this.psdeactionvrid = null;
    }

    public void setPSDEActionVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionvrname = string;
        this.psdeactionvrnameDirtyFlag = true;
    }

    public String getPSDEActionVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionVRName();
        }
        return this.psdeactionvrname;
    }

    public boolean isPSDEActionVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionVRNameDirty();
        }
        return this.psdeactionvrnameDirtyFlag;
    }

    public void resetPSDEActionVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionVRName();
            return;
        }
        this.psdeactionvrnameDirtyFlag = false;
        this.psdeactionvrname = null;
    }

    public void setPSDEFVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrid = string;
        this.psdefvridDirtyFlag = true;
    }

    public String getPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRId();
        }
        return this.psdefvrid;
    }

    public boolean isPSDEFVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRIdDirty();
        }
        return this.psdefvridDirtyFlag;
    }

    public void resetPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRId();
            return;
        }
        this.psdefvridDirtyFlag = false;
        this.psdefvrid = null;
    }

    public void setPSDEFVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrname = string;
        this.psdefvrnameDirtyFlag = true;
    }

    public String getPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRName();
        }
        return this.psdefvrname;
    }

    public boolean isPSDEFVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRNameDirty();
        }
        return this.psdefvrnameDirtyFlag;
    }

    public void resetPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRName();
            return;
        }
        this.psdefvrnameDirtyFlag = false;
        this.psdefvrname = null;
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

    public void setVRType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrtype = string;
        this.vrtypeDirtyFlag = true;
    }

    public String getVRType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRType();
        }
        return this.vrtype;
    }

    public boolean isVRTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRTypeDirty();
        }
        return this.vrtypeDirtyFlag;
    }

    public void resetVRType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRType();
            return;
        }
        this.vrtypeDirtyFlag = false;
        this.vrtype = null;
    }

    protected void onReset() {
        PSDEActionVRBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionVRBase pSDEActionVRBase) {
        pSDEActionVRBase.resetCodeName();
        pSDEActionVRBase.resetCreateDate();
        pSDEActionVRBase.resetCreateMan();
        pSDEActionVRBase.resetMemo();
        pSDEActionVRBase.resetOrderValue();
        pSDEActionVRBase.resetPSDEActionId();
        pSDEActionVRBase.resetPSDEActionName();
        pSDEActionVRBase.resetPSDEActionVRId();
        pSDEActionVRBase.resetPSDEActionVRName();
        pSDEActionVRBase.resetPSDEFVRId();
        pSDEActionVRBase.resetPSDEFVRName();
        pSDEActionVRBase.resetPSDEId();
        pSDEActionVRBase.resetUpdateDate();
        pSDEActionVRBase.resetUpdateMan();
        pSDEActionVRBase.resetUserCat();
        pSDEActionVRBase.resetUserTag();
        pSDEActionVRBase.resetUserTag2();
        pSDEActionVRBase.resetUserTag3();
        pSDEActionVRBase.resetUserTag4();
        pSDEActionVRBase.resetValidFlag();
        pSDEActionVRBase.resetVRType();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEActionVRIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONVRID, this.getPSDEActionVRId());
        }
        if (!bl || this.isPSDEActionVRNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONVRNAME, this.getPSDEActionVRName());
        }
        if (!bl || this.isPSDEFVRIdDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRId());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
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
        if (!bl || this.isVRTypeDirty()) {
            hashMap.put(FIELD_VRTYPE, this.getVRType());
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
        return PSDEActionVRBase.get(this, n);
    }

    private static Object get(PSDEActionVRBase pSDEActionVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionVRBase.getCodeName();
            }
            case 1: {
                return pSDEActionVRBase.getCreateDate();
            }
            case 2: {
                return pSDEActionVRBase.getCreateMan();
            }
            case 3: {
                return pSDEActionVRBase.getMemo();
            }
            case 4: {
                return pSDEActionVRBase.getOrderValue();
            }
            case 5: {
                return pSDEActionVRBase.getPSDEActionId();
            }
            case 6: {
                return pSDEActionVRBase.getPSDEActionName();
            }
            case 7: {
                return pSDEActionVRBase.getPSDEActionVRId();
            }
            case 8: {
                return pSDEActionVRBase.getPSDEActionVRName();
            }
            case 9: {
                return pSDEActionVRBase.getPSDEFVRId();
            }
            case 10: {
                return pSDEActionVRBase.getPSDEFVRName();
            }
            case 11: {
                return pSDEActionVRBase.getPSDEId();
            }
            case 12: {
                return pSDEActionVRBase.getUpdateDate();
            }
            case 13: {
                return pSDEActionVRBase.getUpdateMan();
            }
            case 14: {
                return pSDEActionVRBase.getUserCat();
            }
            case 15: {
                return pSDEActionVRBase.getUserTag();
            }
            case 16: {
                return pSDEActionVRBase.getUserTag2();
            }
            case 17: {
                return pSDEActionVRBase.getUserTag3();
            }
            case 18: {
                return pSDEActionVRBase.getUserTag4();
            }
            case 19: {
                return pSDEActionVRBase.getValidFlag();
            }
            case 20: {
                return pSDEActionVRBase.getVRType();
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
        PSDEActionVRBase.set(this, n, object);
    }

    private static void set(PSDEActionVRBase pSDEActionVRBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionVRBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionVRBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionVRBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionVRBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionVRBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionVRBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionVRBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionVRBase.setPSDEActionVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionVRBase.setPSDEActionVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionVRBase.setPSDEFVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionVRBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionVRBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionVRBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionVRBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionVRBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionVRBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionVRBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionVRBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionVRBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionVRBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionVRBase.setVRType(DataObject.getStringValue((Object)object));
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
        return PSDEActionVRBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionVRBase pSDEActionVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionVRBase.getCodeName() == null;
            }
            case 1: {
                return pSDEActionVRBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEActionVRBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEActionVRBase.getMemo() == null;
            }
            case 4: {
                return pSDEActionVRBase.getOrderValue() == null;
            }
            case 5: {
                return pSDEActionVRBase.getPSDEActionId() == null;
            }
            case 6: {
                return pSDEActionVRBase.getPSDEActionName() == null;
            }
            case 7: {
                return pSDEActionVRBase.getPSDEActionVRId() == null;
            }
            case 8: {
                return pSDEActionVRBase.getPSDEActionVRName() == null;
            }
            case 9: {
                return pSDEActionVRBase.getPSDEFVRId() == null;
            }
            case 10: {
                return pSDEActionVRBase.getPSDEFVRName() == null;
            }
            case 11: {
                return pSDEActionVRBase.getPSDEId() == null;
            }
            case 12: {
                return pSDEActionVRBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDEActionVRBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDEActionVRBase.getUserCat() == null;
            }
            case 15: {
                return pSDEActionVRBase.getUserTag() == null;
            }
            case 16: {
                return pSDEActionVRBase.getUserTag2() == null;
            }
            case 17: {
                return pSDEActionVRBase.getUserTag3() == null;
            }
            case 18: {
                return pSDEActionVRBase.getUserTag4() == null;
            }
            case 19: {
                return pSDEActionVRBase.getValidFlag() == null;
            }
            case 20: {
                return pSDEActionVRBase.getVRType() == null;
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
        return PSDEActionVRBase.contains(this, n);
    }

    private static boolean contains(PSDEActionVRBase pSDEActionVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionVRBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEActionVRBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEActionVRBase.isCreateManDirty();
            }
            case 3: {
                return pSDEActionVRBase.isMemoDirty();
            }
            case 4: {
                return pSDEActionVRBase.isOrderValueDirty();
            }
            case 5: {
                return pSDEActionVRBase.isPSDEActionIdDirty();
            }
            case 6: {
                return pSDEActionVRBase.isPSDEActionNameDirty();
            }
            case 7: {
                return pSDEActionVRBase.isPSDEActionVRIdDirty();
            }
            case 8: {
                return pSDEActionVRBase.isPSDEActionVRNameDirty();
            }
            case 9: {
                return pSDEActionVRBase.isPSDEFVRIdDirty();
            }
            case 10: {
                return pSDEActionVRBase.isPSDEFVRNameDirty();
            }
            case 11: {
                return pSDEActionVRBase.isPSDEIdDirty();
            }
            case 12: {
                return pSDEActionVRBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDEActionVRBase.isUpdateManDirty();
            }
            case 14: {
                return pSDEActionVRBase.isUserCatDirty();
            }
            case 15: {
                return pSDEActionVRBase.isUserTagDirty();
            }
            case 16: {
                return pSDEActionVRBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDEActionVRBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDEActionVRBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDEActionVRBase.isValidFlagDirty();
            }
            case 20: {
                return pSDEActionVRBase.isVRTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionVRBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionVRBase pSDEActionVRBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionVRBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEActionVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionvrid", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEActionVRId()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEActionVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionvrname", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEActionVRName()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEFVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEFVRId()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEActionVRBase.getVRType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrtype", (Object)PSDEActionVRBase.getJSONValue((Object)pSDEActionVRBase.getVRType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionVRBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionVRBase pSDEActionVRBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionVRBase.getCodeName() != null) {
            object = pSDEActionVRBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getCreateDate() != null) {
            object = pSDEActionVRBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionVRBase.getCreateMan() != null) {
            object = pSDEActionVRBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getMemo() != null) {
            object = pSDEActionVRBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getOrderValue() != null) {
            object = pSDEActionVRBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionVRBase.getPSDEActionId() != null) {
            object = pSDEActionVRBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEActionName() != null) {
            object = pSDEActionVRBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEActionVRId() != null) {
            object = pSDEActionVRBase.getPSDEActionVRId();
            xmlNode.setAttribute(FIELD_PSDEACTIONVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEActionVRName() != null) {
            object = pSDEActionVRBase.getPSDEActionVRName();
            xmlNode.setAttribute(FIELD_PSDEACTIONVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEFVRId() != null) {
            object = pSDEActionVRBase.getPSDEFVRId();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEFVRName() != null) {
            object = pSDEActionVRBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getPSDEId() != null) {
            object = pSDEActionVRBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUpdateDate() != null) {
            object = pSDEActionVRBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionVRBase.getUpdateMan() != null) {
            object = pSDEActionVRBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUserCat() != null) {
            object = pSDEActionVRBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUserTag() != null) {
            object = pSDEActionVRBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUserTag2() != null) {
            object = pSDEActionVRBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUserTag3() != null) {
            object = pSDEActionVRBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getUserTag4() != null) {
            object = pSDEActionVRBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionVRBase.getValidFlag() != null) {
            object = pSDEActionVRBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionVRBase.getVRType() != null) {
            object = pSDEActionVRBase.getVRType();
            xmlNode.setAttribute(FIELD_VRTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionVRBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionVRBase pSDEActionVRBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionVRBase.isCodeNameDirty() && (bl || pSDEActionVRBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionVRBase.getCodeName());
        }
        if (pSDEActionVRBase.isCreateDateDirty() && (bl || pSDEActionVRBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionVRBase.getCreateDate());
        }
        if (pSDEActionVRBase.isCreateManDirty() && (bl || pSDEActionVRBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionVRBase.getCreateMan());
        }
        if (pSDEActionVRBase.isMemoDirty() && (bl || pSDEActionVRBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionVRBase.getMemo());
        }
        if (pSDEActionVRBase.isOrderValueDirty() && (bl || pSDEActionVRBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEActionVRBase.getOrderValue());
        }
        if (pSDEActionVRBase.isPSDEActionIdDirty() && (bl || pSDEActionVRBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEActionVRBase.getPSDEActionId());
        }
        if (pSDEActionVRBase.isPSDEActionNameDirty() && (bl || pSDEActionVRBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEActionVRBase.getPSDEActionName());
        }
        if (pSDEActionVRBase.isPSDEActionVRIdDirty() && (bl || pSDEActionVRBase.getPSDEActionVRId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONVRID, (Object)pSDEActionVRBase.getPSDEActionVRId());
        }
        if (pSDEActionVRBase.isPSDEActionVRNameDirty() && (bl || pSDEActionVRBase.getPSDEActionVRName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONVRNAME, (Object)pSDEActionVRBase.getPSDEActionVRName());
        }
        if (pSDEActionVRBase.isPSDEFVRIdDirty() && (bl || pSDEActionVRBase.getPSDEFVRId() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDEActionVRBase.getPSDEFVRId());
        }
        if (pSDEActionVRBase.isPSDEFVRNameDirty() && (bl || pSDEActionVRBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDEActionVRBase.getPSDEFVRName());
        }
        if (pSDEActionVRBase.isPSDEIdDirty() && (bl || pSDEActionVRBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEActionVRBase.getPSDEId());
        }
        if (pSDEActionVRBase.isUpdateDateDirty() && (bl || pSDEActionVRBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionVRBase.getUpdateDate());
        }
        if (pSDEActionVRBase.isUpdateManDirty() && (bl || pSDEActionVRBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionVRBase.getUpdateMan());
        }
        if (pSDEActionVRBase.isUserCatDirty() && (bl || pSDEActionVRBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionVRBase.getUserCat());
        }
        if (pSDEActionVRBase.isUserTagDirty() && (bl || pSDEActionVRBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionVRBase.getUserTag());
        }
        if (pSDEActionVRBase.isUserTag2Dirty() && (bl || pSDEActionVRBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionVRBase.getUserTag2());
        }
        if (pSDEActionVRBase.isUserTag3Dirty() && (bl || pSDEActionVRBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionVRBase.getUserTag3());
        }
        if (pSDEActionVRBase.isUserTag4Dirty() && (bl || pSDEActionVRBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionVRBase.getUserTag4());
        }
        if (pSDEActionVRBase.isValidFlagDirty() && (bl || pSDEActionVRBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEActionVRBase.getValidFlag());
        }
        if (pSDEActionVRBase.isVRTypeDirty() && (bl || pSDEActionVRBase.getVRType() != null)) {
            iDataObject.set(FIELD_VRTYPE, (Object)pSDEActionVRBase.getVRType());
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
        return PSDEActionVRBase.remove(this, n);
    }

    private static boolean remove(PSDEActionVRBase pSDEActionVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionVRBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEActionVRBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEActionVRBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEActionVRBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEActionVRBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDEActionVRBase.resetPSDEActionId();
                return true;
            }
            case 6: {
                pSDEActionVRBase.resetPSDEActionName();
                return true;
            }
            case 7: {
                pSDEActionVRBase.resetPSDEActionVRId();
                return true;
            }
            case 8: {
                pSDEActionVRBase.resetPSDEActionVRName();
                return true;
            }
            case 9: {
                pSDEActionVRBase.resetPSDEFVRId();
                return true;
            }
            case 10: {
                pSDEActionVRBase.resetPSDEFVRName();
                return true;
            }
            case 11: {
                pSDEActionVRBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSDEActionVRBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDEActionVRBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDEActionVRBase.resetUserCat();
                return true;
            }
            case 15: {
                pSDEActionVRBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDEActionVRBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDEActionVRBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDEActionVRBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDEActionVRBase.resetValidFlag();
                return true;
            }
            case 20: {
                pSDEActionVRBase.resetVRType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEFValueRule getPSDEFVR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVR();
        }
        if (this.getPSDEFVRId() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRLock;
        synchronized (n) {
            if (this.psdefvr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRId(), (Object)this.psdefvr.getPSDEFValueRuleId()) != 0L) {
                this.psdefvr = null;
            }
            if (this.psdefvr == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFVRId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
        }
    }

    private PSDEActionVRBase getProxyEntity() {
        return this.proxyPSDEActionVRBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionVRBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionVRBase) {
            this.proxyPSDEActionVRBase = (PSDEActionVRBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 5);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 6);
        fieldIndexMap.put(FIELD_PSDEACTIONVRID, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONVRNAME, 8);
        fieldIndexMap.put(FIELD_PSDEFVRID, 9);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
        fieldIndexMap.put(FIELD_VRTYPE, 20);
    }
}

