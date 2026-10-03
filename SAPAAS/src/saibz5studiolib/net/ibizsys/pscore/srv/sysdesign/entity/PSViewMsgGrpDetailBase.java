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
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgGrpDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewMsgGrpDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMICMODE = "DYNAMICMODE";
    public static final String FIELD_ENABLEMODE = "ENABLEMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGPOS = "MSGPOS";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PSVIEWMSGGRPDETAILID = "PSVIEWMSGGRPDETAILID";
    public static final String FIELD_PSVIEWMSGGRPDETAILNAME = "PSVIEWMSGGRPDETAILNAME";
    public static final String FIELD_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String FIELD_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String FIELD_TESTCUSTOMCODE = "TESTCUSTOMCODE";
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
    private static final int INDEX_DYNAMICMODE = 2;
    private static final int INDEX_ENABLEMODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MSGPOS = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSVIEWMSGGROUPID = 7;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 8;
    private static final int INDEX_PSVIEWMSGGRPDETAILID = 9;
    private static final int INDEX_PSVIEWMSGGRPDETAILNAME = 10;
    private static final int INDEX_PSVIEWMSGID = 11;
    private static final int INDEX_PSVIEWMSGNAME = 12;
    private static final int INDEX_TESTCUSTOMCODE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewMsgGrpDetailBase proxyPSViewMsgGrpDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamicmodeDirtyFlag = false;
    private boolean enablemodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msgposDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean psviewmsggrpdetailidDirtyFlag = false;
    private boolean psviewmsggrpdetailnameDirtyFlag = false;
    private boolean psviewmsgidDirtyFlag = false;
    private boolean psviewmsgnameDirtyFlag = false;
    private boolean testcustomcodeDirtyFlag = false;
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
    @Column(name="dynamicmode")
    private Integer dynamicmode;
    @Column(name="enablemode")
    private String enablemode;
    @Column(name="memo")
    private String memo;
    @Column(name="msgpos")
    private String msgpos;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="psviewmsggrpdetailid")
    private String psviewmsggrpdetailid;
    @Column(name="psviewmsggrpdetailname")
    private String psviewmsggrpdetailname;
    @Column(name="psviewmsgid")
    private String psviewmsgid;
    @Column(name="psviewmsgname")
    private String psviewmsgname;
    @Column(name="testcustomcode")
    private String testcustomcode;
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
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSViewMsgLock = new Integer(1);
    private PSViewMsg psviewmsg = null;

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

    public void setDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynamicMode(n);
            return;
        }
        this.dynamicmode = n;
        this.dynamicmodeDirtyFlag = true;
    }

    public Integer getDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynamicMode();
        }
        return this.dynamicmode;
    }

    public boolean isDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynamicModeDirty();
        }
        return this.dynamicmodeDirtyFlag;
    }

    public void resetDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynamicMode();
            return;
        }
        this.dynamicmodeDirtyFlag = false;
        this.dynamicmode = null;
    }

    public void setEnableMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablemode = string;
        this.enablemodeDirtyFlag = true;
    }

    public String getEnableMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMode();
        }
        return this.enablemode;
    }

    public boolean isEnableModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableModeDirty();
        }
        return this.enablemodeDirtyFlag;
    }

    public void resetEnableMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMode();
            return;
        }
        this.enablemodeDirtyFlag = false;
        this.enablemode = null;
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

    public void setMsgPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpos = string;
        this.msgposDirtyFlag = true;
    }

    public String getMsgPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPos();
        }
        return this.msgpos;
    }

    public boolean isMsgPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPosDirty();
        }
        return this.msgposDirtyFlag;
    }

    public void resetMsgPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPos();
            return;
        }
        this.msgposDirtyFlag = false;
        this.msgpos = null;
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

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setPSViewMsgGrpDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGrpDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggrpdetailid = string;
        this.psviewmsggrpdetailidDirtyFlag = true;
    }

    public String getPSViewMsgGrpDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGrpDetailId();
        }
        return this.psviewmsggrpdetailid;
    }

    public boolean isPSViewMsgGrpDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGrpDetailIdDirty();
        }
        return this.psviewmsggrpdetailidDirtyFlag;
    }

    public void resetPSViewMsgGrpDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGrpDetailId();
            return;
        }
        this.psviewmsggrpdetailidDirtyFlag = false;
        this.psviewmsggrpdetailid = null;
    }

    public void setPSViewMsgGrpDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGrpDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggrpdetailname = string;
        this.psviewmsggrpdetailnameDirtyFlag = true;
    }

    public String getPSViewMsgGrpDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGrpDetailName();
        }
        return this.psviewmsggrpdetailname;
    }

    public boolean isPSViewMsgGrpDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGrpDetailNameDirty();
        }
        return this.psviewmsggrpdetailnameDirtyFlag;
    }

    public void resetPSViewMsgGrpDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGrpDetailName();
            return;
        }
        this.psviewmsggrpdetailnameDirtyFlag = false;
        this.psviewmsggrpdetailname = null;
    }

    public void setPSViewMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgid = string;
        this.psviewmsgidDirtyFlag = true;
    }

    public String getPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgId();
        }
        return this.psviewmsgid;
    }

    public boolean isPSViewMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgIdDirty();
        }
        return this.psviewmsgidDirtyFlag;
    }

    public void resetPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgId();
            return;
        }
        this.psviewmsgidDirtyFlag = false;
        this.psviewmsgid = null;
    }

    public void setPSViewMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgname = string;
        this.psviewmsgnameDirtyFlag = true;
    }

    public String getPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgName();
        }
        return this.psviewmsgname;
    }

    public boolean isPSViewMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgNameDirty();
        }
        return this.psviewmsgnameDirtyFlag;
    }

    public void resetPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgName();
            return;
        }
        this.psviewmsgnameDirtyFlag = false;
        this.psviewmsgname = null;
    }

    public void setTestCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcustomcode = string;
        this.testcustomcodeDirtyFlag = true;
    }

    public String getTestCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomCode();
        }
        return this.testcustomcode;
    }

    public boolean isTestCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomCodeDirty();
        }
        return this.testcustomcodeDirtyFlag;
    }

    public void resetTestCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomCode();
            return;
        }
        this.testcustomcodeDirtyFlag = false;
        this.testcustomcode = null;
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
        PSViewMsgGrpDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase) {
        pSViewMsgGrpDetailBase.resetCreateDate();
        pSViewMsgGrpDetailBase.resetCreateMan();
        pSViewMsgGrpDetailBase.resetDynamicMode();
        pSViewMsgGrpDetailBase.resetEnableMode();
        pSViewMsgGrpDetailBase.resetMemo();
        pSViewMsgGrpDetailBase.resetMsgPos();
        pSViewMsgGrpDetailBase.resetOrderValue();
        pSViewMsgGrpDetailBase.resetPSViewMsgGroupId();
        pSViewMsgGrpDetailBase.resetPSViewMsgGroupName();
        pSViewMsgGrpDetailBase.resetPSViewMsgGrpDetailId();
        pSViewMsgGrpDetailBase.resetPSViewMsgGrpDetailName();
        pSViewMsgGrpDetailBase.resetPSViewMsgId();
        pSViewMsgGrpDetailBase.resetPSViewMsgName();
        pSViewMsgGrpDetailBase.resetTestCustomCode();
        pSViewMsgGrpDetailBase.resetUpdateDate();
        pSViewMsgGrpDetailBase.resetUpdateMan();
        pSViewMsgGrpDetailBase.resetUserCat();
        pSViewMsgGrpDetailBase.resetUserTag();
        pSViewMsgGrpDetailBase.resetUserTag2();
        pSViewMsgGrpDetailBase.resetUserTag3();
        pSViewMsgGrpDetailBase.resetUserTag4();
        pSViewMsgGrpDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynamicModeDirty()) {
            hashMap.put(FIELD_DYNAMICMODE, this.getDynamicMode());
        }
        if (!bl || this.isEnableModeDirty()) {
            hashMap.put(FIELD_ENABLEMODE, this.getEnableMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMsgPosDirty()) {
            hashMap.put(FIELD_MSGPOS, this.getMsgPos());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isPSViewMsgGrpDetailIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGRPDETAILID, this.getPSViewMsgGrpDetailId());
        }
        if (!bl || this.isPSViewMsgGrpDetailNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGRPDETAILNAME, this.getPSViewMsgGrpDetailName());
        }
        if (!bl || this.isPSViewMsgIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGID, this.getPSViewMsgId());
        }
        if (!bl || this.isPSViewMsgNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGNAME, this.getPSViewMsgName());
        }
        if (!bl || this.isTestCustomCodeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMCODE, this.getTestCustomCode());
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
        return PSViewMsgGrpDetailBase.get(this, n);
    }

    private static Object get(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGrpDetailBase.getCreateDate();
            }
            case 1: {
                return pSViewMsgGrpDetailBase.getCreateMan();
            }
            case 2: {
                return pSViewMsgGrpDetailBase.getDynamicMode();
            }
            case 3: {
                return pSViewMsgGrpDetailBase.getEnableMode();
            }
            case 4: {
                return pSViewMsgGrpDetailBase.getMemo();
            }
            case 5: {
                return pSViewMsgGrpDetailBase.getMsgPos();
            }
            case 6: {
                return pSViewMsgGrpDetailBase.getOrderValue();
            }
            case 7: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGroupId();
            }
            case 8: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGroupName();
            }
            case 9: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId();
            }
            case 10: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName();
            }
            case 11: {
                return pSViewMsgGrpDetailBase.getPSViewMsgId();
            }
            case 12: {
                return pSViewMsgGrpDetailBase.getPSViewMsgName();
            }
            case 13: {
                return pSViewMsgGrpDetailBase.getTestCustomCode();
            }
            case 14: {
                return pSViewMsgGrpDetailBase.getUpdateDate();
            }
            case 15: {
                return pSViewMsgGrpDetailBase.getUpdateMan();
            }
            case 16: {
                return pSViewMsgGrpDetailBase.getUserCat();
            }
            case 17: {
                return pSViewMsgGrpDetailBase.getUserTag();
            }
            case 18: {
                return pSViewMsgGrpDetailBase.getUserTag2();
            }
            case 19: {
                return pSViewMsgGrpDetailBase.getUserTag3();
            }
            case 20: {
                return pSViewMsgGrpDetailBase.getUserTag4();
            }
            case 21: {
                return pSViewMsgGrpDetailBase.getValidFlag();
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
        PSViewMsgGrpDetailBase.set(this, n, object);
    }

    private static void set(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgGrpDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSViewMsgGrpDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewMsgGrpDetailBase.setDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSViewMsgGrpDetailBase.setEnableMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewMsgGrpDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewMsgGrpDetailBase.setMsgPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewMsgGrpDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSViewMsgGrpDetailBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewMsgGrpDetailBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewMsgGrpDetailBase.setPSViewMsgGrpDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewMsgGrpDetailBase.setPSViewMsgGrpDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewMsgGrpDetailBase.setPSViewMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewMsgGrpDetailBase.setPSViewMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewMsgGrpDetailBase.setTestCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSViewMsgGrpDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSViewMsgGrpDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewMsgGrpDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewMsgGrpDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSViewMsgGrpDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewMsgGrpDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSViewMsgGrpDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSViewMsgGrpDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSViewMsgGrpDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGrpDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSViewMsgGrpDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSViewMsgGrpDetailBase.getDynamicMode() == null;
            }
            case 3: {
                return pSViewMsgGrpDetailBase.getEnableMode() == null;
            }
            case 4: {
                return pSViewMsgGrpDetailBase.getMemo() == null;
            }
            case 5: {
                return pSViewMsgGrpDetailBase.getMsgPos() == null;
            }
            case 6: {
                return pSViewMsgGrpDetailBase.getOrderValue() == null;
            }
            case 7: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGroupId() == null;
            }
            case 8: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGroupName() == null;
            }
            case 9: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId() == null;
            }
            case 10: {
                return pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName() == null;
            }
            case 11: {
                return pSViewMsgGrpDetailBase.getPSViewMsgId() == null;
            }
            case 12: {
                return pSViewMsgGrpDetailBase.getPSViewMsgName() == null;
            }
            case 13: {
                return pSViewMsgGrpDetailBase.getTestCustomCode() == null;
            }
            case 14: {
                return pSViewMsgGrpDetailBase.getUpdateDate() == null;
            }
            case 15: {
                return pSViewMsgGrpDetailBase.getUpdateMan() == null;
            }
            case 16: {
                return pSViewMsgGrpDetailBase.getUserCat() == null;
            }
            case 17: {
                return pSViewMsgGrpDetailBase.getUserTag() == null;
            }
            case 18: {
                return pSViewMsgGrpDetailBase.getUserTag2() == null;
            }
            case 19: {
                return pSViewMsgGrpDetailBase.getUserTag3() == null;
            }
            case 20: {
                return pSViewMsgGrpDetailBase.getUserTag4() == null;
            }
            case 21: {
                return pSViewMsgGrpDetailBase.getValidFlag() == null;
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
        return PSViewMsgGrpDetailBase.contains(this, n);
    }

    private static boolean contains(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewMsgGrpDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSViewMsgGrpDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSViewMsgGrpDetailBase.isDynamicModeDirty();
            }
            case 3: {
                return pSViewMsgGrpDetailBase.isEnableModeDirty();
            }
            case 4: {
                return pSViewMsgGrpDetailBase.isMemoDirty();
            }
            case 5: {
                return pSViewMsgGrpDetailBase.isMsgPosDirty();
            }
            case 6: {
                return pSViewMsgGrpDetailBase.isOrderValueDirty();
            }
            case 7: {
                return pSViewMsgGrpDetailBase.isPSViewMsgGroupIdDirty();
            }
            case 8: {
                return pSViewMsgGrpDetailBase.isPSViewMsgGroupNameDirty();
            }
            case 9: {
                return pSViewMsgGrpDetailBase.isPSViewMsgGrpDetailIdDirty();
            }
            case 10: {
                return pSViewMsgGrpDetailBase.isPSViewMsgGrpDetailNameDirty();
            }
            case 11: {
                return pSViewMsgGrpDetailBase.isPSViewMsgIdDirty();
            }
            case 12: {
                return pSViewMsgGrpDetailBase.isPSViewMsgNameDirty();
            }
            case 13: {
                return pSViewMsgGrpDetailBase.isTestCustomCodeDirty();
            }
            case 14: {
                return pSViewMsgGrpDetailBase.isUpdateDateDirty();
            }
            case 15: {
                return pSViewMsgGrpDetailBase.isUpdateManDirty();
            }
            case 16: {
                return pSViewMsgGrpDetailBase.isUserCatDirty();
            }
            case 17: {
                return pSViewMsgGrpDetailBase.isUserTagDirty();
            }
            case 18: {
                return pSViewMsgGrpDetailBase.isUserTag2Dirty();
            }
            case 19: {
                return pSViewMsgGrpDetailBase.isUserTag3Dirty();
            }
            case 20: {
                return pSViewMsgGrpDetailBase.isUserTag4Dirty();
            }
            case 21: {
                return pSViewMsgGrpDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewMsgGrpDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewMsgGrpDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamicmode", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getDynamicMode()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getEnableMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemode", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getEnableMode()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getMsgPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpos", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getMsgPos()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggrpdetailid", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggrpdetailname", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgid", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgId()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgname", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getPSViewMsgName()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getTestCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustomcode", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getTestCustomCode()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSViewMsgGrpDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewMsgGrpDetailBase.getJSONValue((Object)pSViewMsgGrpDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewMsgGrpDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewMsgGrpDetailBase.getCreateDate() != null) {
            object = pSViewMsgGrpDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgGrpDetailBase.getCreateMan() != null) {
            object = pSViewMsgGrpDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getDynamicMode() != null) {
            object = pSViewMsgGrpDetailBase.getDynamicMode();
            xmlNode.setAttribute(FIELD_DYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgGrpDetailBase.getEnableMode() != null) {
            object = pSViewMsgGrpDetailBase.getEnableMode();
            xmlNode.setAttribute(FIELD_ENABLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getMemo() != null) {
            object = pSViewMsgGrpDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getMsgPos() != null) {
            object = pSViewMsgGrpDetailBase.getMsgPos();
            xmlNode.setAttribute(FIELD_MSGPOS, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getOrderValue() != null) {
            object = pSViewMsgGrpDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupId() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupName() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgId() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getPSViewMsgName() != null) {
            object = pSViewMsgGrpDetailBase.getPSViewMsgName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getTestCustomCode() != null) {
            object = pSViewMsgGrpDetailBase.getTestCustomCode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUpdateDate() != null) {
            object = pSViewMsgGrpDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewMsgGrpDetailBase.getUpdateMan() != null) {
            object = pSViewMsgGrpDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserCat() != null) {
            object = pSViewMsgGrpDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag() != null) {
            object = pSViewMsgGrpDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag2() != null) {
            object = pSViewMsgGrpDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag3() != null) {
            object = pSViewMsgGrpDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getUserTag4() != null) {
            object = pSViewMsgGrpDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSViewMsgGrpDetailBase.getValidFlag() != null) {
            object = pSViewMsgGrpDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewMsgGrpDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewMsgGrpDetailBase.isCreateDateDirty() && (bl || pSViewMsgGrpDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewMsgGrpDetailBase.getCreateDate());
        }
        if (pSViewMsgGrpDetailBase.isCreateManDirty() && (bl || pSViewMsgGrpDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewMsgGrpDetailBase.getCreateMan());
        }
        if (pSViewMsgGrpDetailBase.isDynamicModeDirty() && (bl || pSViewMsgGrpDetailBase.getDynamicMode() != null)) {
            iDataObject.set(FIELD_DYNAMICMODE, (Object)pSViewMsgGrpDetailBase.getDynamicMode());
        }
        if (pSViewMsgGrpDetailBase.isEnableModeDirty() && (bl || pSViewMsgGrpDetailBase.getEnableMode() != null)) {
            iDataObject.set(FIELD_ENABLEMODE, (Object)pSViewMsgGrpDetailBase.getEnableMode());
        }
        if (pSViewMsgGrpDetailBase.isMemoDirty() && (bl || pSViewMsgGrpDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewMsgGrpDetailBase.getMemo());
        }
        if (pSViewMsgGrpDetailBase.isMsgPosDirty() && (bl || pSViewMsgGrpDetailBase.getMsgPos() != null)) {
            iDataObject.set(FIELD_MSGPOS, (Object)pSViewMsgGrpDetailBase.getMsgPos());
        }
        if (pSViewMsgGrpDetailBase.isOrderValueDirty() && (bl || pSViewMsgGrpDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSViewMsgGrpDetailBase.getOrderValue());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgGroupIdDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSViewMsgGrpDetailBase.getPSViewMsgGroupId());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgGroupNameDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSViewMsgGrpDetailBase.getPSViewMsgGroupName());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgGrpDetailIdDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGRPDETAILID, (Object)pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailId());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgGrpDetailNameDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGRPDETAILNAME, (Object)pSViewMsgGrpDetailBase.getPSViewMsgGrpDetailName());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgIdDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGID, (Object)pSViewMsgGrpDetailBase.getPSViewMsgId());
        }
        if (pSViewMsgGrpDetailBase.isPSViewMsgNameDirty() && (bl || pSViewMsgGrpDetailBase.getPSViewMsgName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGNAME, (Object)pSViewMsgGrpDetailBase.getPSViewMsgName());
        }
        if (pSViewMsgGrpDetailBase.isTestCustomCodeDirty() && (bl || pSViewMsgGrpDetailBase.getTestCustomCode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMCODE, (Object)pSViewMsgGrpDetailBase.getTestCustomCode());
        }
        if (pSViewMsgGrpDetailBase.isUpdateDateDirty() && (bl || pSViewMsgGrpDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewMsgGrpDetailBase.getUpdateDate());
        }
        if (pSViewMsgGrpDetailBase.isUpdateManDirty() && (bl || pSViewMsgGrpDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewMsgGrpDetailBase.getUpdateMan());
        }
        if (pSViewMsgGrpDetailBase.isUserCatDirty() && (bl || pSViewMsgGrpDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewMsgGrpDetailBase.getUserCat());
        }
        if (pSViewMsgGrpDetailBase.isUserTagDirty() && (bl || pSViewMsgGrpDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewMsgGrpDetailBase.getUserTag());
        }
        if (pSViewMsgGrpDetailBase.isUserTag2Dirty() && (bl || pSViewMsgGrpDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewMsgGrpDetailBase.getUserTag2());
        }
        if (pSViewMsgGrpDetailBase.isUserTag3Dirty() && (bl || pSViewMsgGrpDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewMsgGrpDetailBase.getUserTag3());
        }
        if (pSViewMsgGrpDetailBase.isUserTag4Dirty() && (bl || pSViewMsgGrpDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewMsgGrpDetailBase.getUserTag4());
        }
        if (pSViewMsgGrpDetailBase.isValidFlagDirty() && (bl || pSViewMsgGrpDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewMsgGrpDetailBase.getValidFlag());
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
        return PSViewMsgGrpDetailBase.remove(this, n);
    }

    private static boolean remove(PSViewMsgGrpDetailBase pSViewMsgGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewMsgGrpDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSViewMsgGrpDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSViewMsgGrpDetailBase.resetDynamicMode();
                return true;
            }
            case 3: {
                pSViewMsgGrpDetailBase.resetEnableMode();
                return true;
            }
            case 4: {
                pSViewMsgGrpDetailBase.resetMemo();
                return true;
            }
            case 5: {
                pSViewMsgGrpDetailBase.resetMsgPos();
                return true;
            }
            case 6: {
                pSViewMsgGrpDetailBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSViewMsgGrpDetailBase.resetPSViewMsgGroupId();
                return true;
            }
            case 8: {
                pSViewMsgGrpDetailBase.resetPSViewMsgGroupName();
                return true;
            }
            case 9: {
                pSViewMsgGrpDetailBase.resetPSViewMsgGrpDetailId();
                return true;
            }
            case 10: {
                pSViewMsgGrpDetailBase.resetPSViewMsgGrpDetailName();
                return true;
            }
            case 11: {
                pSViewMsgGrpDetailBase.resetPSViewMsgId();
                return true;
            }
            case 12: {
                pSViewMsgGrpDetailBase.resetPSViewMsgName();
                return true;
            }
            case 13: {
                pSViewMsgGrpDetailBase.resetTestCustomCode();
                return true;
            }
            case 14: {
                pSViewMsgGrpDetailBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSViewMsgGrpDetailBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSViewMsgGrpDetailBase.resetUserCat();
                return true;
            }
            case 17: {
                pSViewMsgGrpDetailBase.resetUserTag();
                return true;
            }
            case 18: {
                pSViewMsgGrpDetailBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSViewMsgGrpDetailBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSViewMsgGrpDetailBase.resetUserTag4();
                return true;
            }
            case 21: {
                pSViewMsgGrpDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet(pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsg getPSViewMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsg();
        }
        if (this.getPSViewMsgId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgLock;
        synchronized (n) {
            if (this.psviewmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgId(), (Object)this.psviewmsg.getPSViewMsgId()) != 0L) {
                this.psviewmsg = null;
            }
            if (this.psviewmsg == null) {
                PSViewMsg pSViewMsg = new PSViewMsg();
                pSViewMsg.setPSViewMsgId(this.getPSViewMsgId());
                PSViewMsgService pSViewMsgService = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgService.autoGet(pSViewMsg);
                this.psviewmsg = pSViewMsg;
            }
            return this.psviewmsg;
        }
    }

    private PSViewMsgGrpDetailBase getProxyEntity() {
        return this.proxyPSViewMsgGrpDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewMsgGrpDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewMsgGrpDetailBase) {
            this.proxyPSViewMsgGrpDetailBase = (PSViewMsgGrpDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMICMODE, 2);
        fieldIndexMap.put(FIELD_ENABLEMODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MSGPOS, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 7);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 8);
        fieldIndexMap.put(FIELD_PSVIEWMSGGRPDETAILID, 9);
        fieldIndexMap.put(FIELD_PSVIEWMSGGRPDETAILNAME, 10);
        fieldIndexMap.put(FIELD_PSVIEWMSGID, 11);
        fieldIndexMap.put(FIELD_PSVIEWMSGNAME, 12);
        fieldIndexMap.put(FIELD_TESTCUSTOMCODE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

