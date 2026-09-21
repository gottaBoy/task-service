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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERepItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERepItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORPSDEREPORTID = "MAJORPSDEREPORTID";
    public static final String FIELD_MAJORPSDEREPORTNAME = "MAJORPSDEREPORTNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEREPORTID = "MINORPSDEREPORTID";
    public static final String FIELD_MINORPSDEREPORTNAME = "MINORPSDEREPORTNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEREPITEMID = "PSDEREPITEMID";
    public static final String FIELD_PSDEREPITEMNAME = "PSDEREPITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAJORPSDEREPORTID = 2;
    private static final int INDEX_MAJORPSDEREPORTNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MINORPSDEREPORTID = 5;
    private static final int INDEX_MINORPSDEREPORTNAME = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDEREPITEMID = 9;
    private static final int INDEX_PSDEREPITEMNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERepItemBase proxyPSDERepItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majorpsdereportidDirtyFlag = false;
    private boolean majorpsdereportnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdereportidDirtyFlag = false;
    private boolean minorpsdereportnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psderepitemidDirtyFlag = false;
    private boolean psderepitemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majorpsdereportid")
    private String majorpsdereportid;
    @Column(name="majorpsdereportname")
    private String majorpsdereportname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdereportid")
    private String minorpsdereportid;
    @Column(name="minorpsdereportname")
    private String minorpsdereportname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psderepitemid")
    private String psderepitemid;
    @Column(name="psderepitemname")
    private String psderepitemname;
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
    private Integer objMajorPSDEReportLock = new Integer(1);
    private PSDEReport majorpsdereport = null;
    private Integer objMinorPSDEReportLock = new Integer(1);
    private PSDEReport minorpsdereport = null;

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

    public void setMajorPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdereportid = string;
        this.majorpsdereportidDirtyFlag = true;
    }

    public String getMajorPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEReportId();
        }
        return this.majorpsdereportid;
    }

    public boolean isMajorPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEReportIdDirty();
        }
        return this.majorpsdereportidDirtyFlag;
    }

    public void resetMajorPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEReportId();
            return;
        }
        this.majorpsdereportidDirtyFlag = false;
        this.majorpsdereportid = null;
    }

    public void setMajorPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdereportname = string;
        this.majorpsdereportnameDirtyFlag = true;
    }

    public String getMajorPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEReportName();
        }
        return this.majorpsdereportname;
    }

    public boolean isMajorPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEReportNameDirty();
        }
        return this.majorpsdereportnameDirtyFlag;
    }

    public void resetMajorPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEReportName();
            return;
        }
        this.majorpsdereportnameDirtyFlag = false;
        this.majorpsdereportname = null;
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

    public void setMinorPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdereportid = string;
        this.minorpsdereportidDirtyFlag = true;
    }

    public String getMinorPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEReportId();
        }
        return this.minorpsdereportid;
    }

    public boolean isMinorPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEReportIdDirty();
        }
        return this.minorpsdereportidDirtyFlag;
    }

    public void resetMinorPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEReportId();
            return;
        }
        this.minorpsdereportidDirtyFlag = false;
        this.minorpsdereportid = null;
    }

    public void setMinorPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdereportname = string;
        this.minorpsdereportnameDirtyFlag = true;
    }

    public String getMinorPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEReportName();
        }
        return this.minorpsdereportname;
    }

    public boolean isMinorPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEReportNameDirty();
        }
        return this.minorpsdereportnameDirtyFlag;
    }

    public void resetMinorPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEReportName();
            return;
        }
        this.minorpsdereportnameDirtyFlag = false;
        this.minorpsdereportname = null;
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

    public void setPSDERepItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERepItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderepitemid = string;
        this.psderepitemidDirtyFlag = true;
    }

    public String getPSDERepItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERepItemId();
        }
        return this.psderepitemid;
    }

    public boolean isPSDERepItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERepItemIdDirty();
        }
        return this.psderepitemidDirtyFlag;
    }

    public void resetPSDERepItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERepItemId();
            return;
        }
        this.psderepitemidDirtyFlag = false;
        this.psderepitemid = null;
    }

    public void setPSDERepItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERepItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderepitemname = string;
        this.psderepitemnameDirtyFlag = true;
    }

    public String getPSDERepItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERepItemName();
        }
        return this.psderepitemname;
    }

    public boolean isPSDERepItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERepItemNameDirty();
        }
        return this.psderepitemnameDirtyFlag;
    }

    public void resetPSDERepItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERepItemName();
            return;
        }
        this.psderepitemnameDirtyFlag = false;
        this.psderepitemname = null;
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
        PSDERepItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERepItemBase pSDERepItemBase) {
        pSDERepItemBase.resetCreateDate();
        pSDERepItemBase.resetCreateMan();
        pSDERepItemBase.resetMajorPSDEReportId();
        pSDERepItemBase.resetMajorPSDEReportName();
        pSDERepItemBase.resetMemo();
        pSDERepItemBase.resetMinorPSDEReportId();
        pSDERepItemBase.resetMinorPSDEReportName();
        pSDERepItemBase.resetOrderValue();
        pSDERepItemBase.resetPSDEId();
        pSDERepItemBase.resetPSDERepItemId();
        pSDERepItemBase.resetPSDERepItemName();
        pSDERepItemBase.resetUpdateDate();
        pSDERepItemBase.resetUpdateMan();
        pSDERepItemBase.resetUserCat();
        pSDERepItemBase.resetUserTag();
        pSDERepItemBase.resetUserTag2();
        pSDERepItemBase.resetUserTag3();
        pSDERepItemBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMajorPSDEReportIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEREPORTID, this.getMajorPSDEReportId());
        }
        if (!bl || this.isMajorPSDEReportNameDirty()) {
            hashMap.put(FIELD_MAJORPSDEREPORTNAME, this.getMajorPSDEReportName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEReportIdDirty()) {
            hashMap.put(FIELD_MINORPSDEREPORTID, this.getMinorPSDEReportId());
        }
        if (!bl || this.isMinorPSDEReportNameDirty()) {
            hashMap.put(FIELD_MINORPSDEREPORTNAME, this.getMinorPSDEReportName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDERepItemIdDirty()) {
            hashMap.put(FIELD_PSDEREPITEMID, this.getPSDERepItemId());
        }
        if (!bl || this.isPSDERepItemNameDirty()) {
            hashMap.put(FIELD_PSDEREPITEMNAME, this.getPSDERepItemName());
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
        return PSDERepItemBase.get(this, n);
    }

    private static Object get(PSDERepItemBase pSDERepItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERepItemBase.getCreateDate();
            }
            case 1: {
                return pSDERepItemBase.getCreateMan();
            }
            case 2: {
                return pSDERepItemBase.getMajorPSDEReportId();
            }
            case 3: {
                return pSDERepItemBase.getMajorPSDEReportName();
            }
            case 4: {
                return pSDERepItemBase.getMemo();
            }
            case 5: {
                return pSDERepItemBase.getMinorPSDEReportId();
            }
            case 6: {
                return pSDERepItemBase.getMinorPSDEReportName();
            }
            case 7: {
                return pSDERepItemBase.getOrderValue();
            }
            case 8: {
                return pSDERepItemBase.getPSDEId();
            }
            case 9: {
                return pSDERepItemBase.getPSDERepItemId();
            }
            case 10: {
                return pSDERepItemBase.getPSDERepItemName();
            }
            case 11: {
                return pSDERepItemBase.getUpdateDate();
            }
            case 12: {
                return pSDERepItemBase.getUpdateMan();
            }
            case 13: {
                return pSDERepItemBase.getUserCat();
            }
            case 14: {
                return pSDERepItemBase.getUserTag();
            }
            case 15: {
                return pSDERepItemBase.getUserTag2();
            }
            case 16: {
                return pSDERepItemBase.getUserTag3();
            }
            case 17: {
                return pSDERepItemBase.getUserTag4();
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
        PSDERepItemBase.set(this, n, object);
    }

    private static void set(PSDERepItemBase pSDERepItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERepItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDERepItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDERepItemBase.setMajorPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERepItemBase.setMajorPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERepItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERepItemBase.setMinorPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERepItemBase.setMinorPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERepItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDERepItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDERepItemBase.setPSDERepItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERepItemBase.setPSDERepItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERepItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDERepItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERepItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERepItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERepItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDERepItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDERepItemBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDERepItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDERepItemBase pSDERepItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERepItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSDERepItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSDERepItemBase.getMajorPSDEReportId() == null;
            }
            case 3: {
                return pSDERepItemBase.getMajorPSDEReportName() == null;
            }
            case 4: {
                return pSDERepItemBase.getMemo() == null;
            }
            case 5: {
                return pSDERepItemBase.getMinorPSDEReportId() == null;
            }
            case 6: {
                return pSDERepItemBase.getMinorPSDEReportName() == null;
            }
            case 7: {
                return pSDERepItemBase.getOrderValue() == null;
            }
            case 8: {
                return pSDERepItemBase.getPSDEId() == null;
            }
            case 9: {
                return pSDERepItemBase.getPSDERepItemId() == null;
            }
            case 10: {
                return pSDERepItemBase.getPSDERepItemName() == null;
            }
            case 11: {
                return pSDERepItemBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDERepItemBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDERepItemBase.getUserCat() == null;
            }
            case 14: {
                return pSDERepItemBase.getUserTag() == null;
            }
            case 15: {
                return pSDERepItemBase.getUserTag2() == null;
            }
            case 16: {
                return pSDERepItemBase.getUserTag3() == null;
            }
            case 17: {
                return pSDERepItemBase.getUserTag4() == null;
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
        return PSDERepItemBase.contains(this, n);
    }

    private static boolean contains(PSDERepItemBase pSDERepItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERepItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSDERepItemBase.isCreateManDirty();
            }
            case 2: {
                return pSDERepItemBase.isMajorPSDEReportIdDirty();
            }
            case 3: {
                return pSDERepItemBase.isMajorPSDEReportNameDirty();
            }
            case 4: {
                return pSDERepItemBase.isMemoDirty();
            }
            case 5: {
                return pSDERepItemBase.isMinorPSDEReportIdDirty();
            }
            case 6: {
                return pSDERepItemBase.isMinorPSDEReportNameDirty();
            }
            case 7: {
                return pSDERepItemBase.isOrderValueDirty();
            }
            case 8: {
                return pSDERepItemBase.isPSDEIdDirty();
            }
            case 9: {
                return pSDERepItemBase.isPSDERepItemIdDirty();
            }
            case 10: {
                return pSDERepItemBase.isPSDERepItemNameDirty();
            }
            case 11: {
                return pSDERepItemBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDERepItemBase.isUpdateManDirty();
            }
            case 13: {
                return pSDERepItemBase.isUserCatDirty();
            }
            case 14: {
                return pSDERepItemBase.isUserTagDirty();
            }
            case 15: {
                return pSDERepItemBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDERepItemBase.isUserTag3Dirty();
            }
            case 17: {
                return pSDERepItemBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERepItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERepItemBase pSDERepItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERepItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getMajorPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdereportid", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getMajorPSDEReportId()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getMajorPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdereportname", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getMajorPSDEReportName()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getMinorPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdereportid", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getMinorPSDEReportId()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getMinorPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdereportname", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getMinorPSDEReportName()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getPSDERepItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderepitemid", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getPSDERepItemId()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getPSDERepItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderepitemname", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getPSDERepItemName()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDERepItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDERepItemBase.getJSONValue((Object)pSDERepItemBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERepItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERepItemBase pSDERepItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERepItemBase.getCreateDate() != null) {
            object = pSDERepItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERepItemBase.getCreateMan() != null) {
            object = pSDERepItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getMajorPSDEReportId() != null) {
            object = pSDERepItemBase.getMajorPSDEReportId();
            xmlNode.setAttribute(FIELD_MAJORPSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getMajorPSDEReportName() != null) {
            object = pSDERepItemBase.getMajorPSDEReportName();
            xmlNode.setAttribute(FIELD_MAJORPSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getMemo() != null) {
            object = pSDERepItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getMinorPSDEReportId() != null) {
            object = pSDERepItemBase.getMinorPSDEReportId();
            xmlNode.setAttribute(FIELD_MINORPSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getMinorPSDEReportName() != null) {
            object = pSDERepItemBase.getMinorPSDEReportName();
            xmlNode.setAttribute(FIELD_MINORPSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getOrderValue() != null) {
            object = pSDERepItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERepItemBase.getPSDEId() != null) {
            object = pSDERepItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getPSDERepItemId() != null) {
            object = pSDERepItemBase.getPSDERepItemId();
            xmlNode.setAttribute(FIELD_PSDEREPITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getPSDERepItemName() != null) {
            object = pSDERepItemBase.getPSDERepItemName();
            xmlNode.setAttribute(FIELD_PSDEREPITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUpdateDate() != null) {
            object = pSDERepItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERepItemBase.getUpdateMan() != null) {
            object = pSDERepItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUserCat() != null) {
            object = pSDERepItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUserTag() != null) {
            object = pSDERepItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUserTag2() != null) {
            object = pSDERepItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUserTag3() != null) {
            object = pSDERepItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDERepItemBase.getUserTag4() != null) {
            object = pSDERepItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERepItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERepItemBase pSDERepItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERepItemBase.isCreateDateDirty() && (bl || pSDERepItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERepItemBase.getCreateDate());
        }
        if (pSDERepItemBase.isCreateManDirty() && (bl || pSDERepItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERepItemBase.getCreateMan());
        }
        if (pSDERepItemBase.isMajorPSDEReportIdDirty() && (bl || pSDERepItemBase.getMajorPSDEReportId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEREPORTID, (Object)pSDERepItemBase.getMajorPSDEReportId());
        }
        if (pSDERepItemBase.isMajorPSDEReportNameDirty() && (bl || pSDERepItemBase.getMajorPSDEReportName() != null)) {
            iDataObject.set(FIELD_MAJORPSDEREPORTNAME, (Object)pSDERepItemBase.getMajorPSDEReportName());
        }
        if (pSDERepItemBase.isMemoDirty() && (bl || pSDERepItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERepItemBase.getMemo());
        }
        if (pSDERepItemBase.isMinorPSDEReportIdDirty() && (bl || pSDERepItemBase.getMinorPSDEReportId() != null)) {
            iDataObject.set(FIELD_MINORPSDEREPORTID, (Object)pSDERepItemBase.getMinorPSDEReportId());
        }
        if (pSDERepItemBase.isMinorPSDEReportNameDirty() && (bl || pSDERepItemBase.getMinorPSDEReportName() != null)) {
            iDataObject.set(FIELD_MINORPSDEREPORTNAME, (Object)pSDERepItemBase.getMinorPSDEReportName());
        }
        if (pSDERepItemBase.isOrderValueDirty() && (bl || pSDERepItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERepItemBase.getOrderValue());
        }
        if (pSDERepItemBase.isPSDEIdDirty() && (bl || pSDERepItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDERepItemBase.getPSDEId());
        }
        if (pSDERepItemBase.isPSDERepItemIdDirty() && (bl || pSDERepItemBase.getPSDERepItemId() != null)) {
            iDataObject.set(FIELD_PSDEREPITEMID, (Object)pSDERepItemBase.getPSDERepItemId());
        }
        if (pSDERepItemBase.isPSDERepItemNameDirty() && (bl || pSDERepItemBase.getPSDERepItemName() != null)) {
            iDataObject.set(FIELD_PSDEREPITEMNAME, (Object)pSDERepItemBase.getPSDERepItemName());
        }
        if (pSDERepItemBase.isUpdateDateDirty() && (bl || pSDERepItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERepItemBase.getUpdateDate());
        }
        if (pSDERepItemBase.isUpdateManDirty() && (bl || pSDERepItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERepItemBase.getUpdateMan());
        }
        if (pSDERepItemBase.isUserCatDirty() && (bl || pSDERepItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDERepItemBase.getUserCat());
        }
        if (pSDERepItemBase.isUserTagDirty() && (bl || pSDERepItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERepItemBase.getUserTag());
        }
        if (pSDERepItemBase.isUserTag2Dirty() && (bl || pSDERepItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERepItemBase.getUserTag2());
        }
        if (pSDERepItemBase.isUserTag3Dirty() && (bl || pSDERepItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDERepItemBase.getUserTag3());
        }
        if (pSDERepItemBase.isUserTag4Dirty() && (bl || pSDERepItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDERepItemBase.getUserTag4());
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
        return PSDERepItemBase.remove(this, n);
    }

    private static boolean remove(PSDERepItemBase pSDERepItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERepItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDERepItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDERepItemBase.resetMajorPSDEReportId();
                return true;
            }
            case 3: {
                pSDERepItemBase.resetMajorPSDEReportName();
                return true;
            }
            case 4: {
                pSDERepItemBase.resetMemo();
                return true;
            }
            case 5: {
                pSDERepItemBase.resetMinorPSDEReportId();
                return true;
            }
            case 6: {
                pSDERepItemBase.resetMinorPSDEReportName();
                return true;
            }
            case 7: {
                pSDERepItemBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSDERepItemBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSDERepItemBase.resetPSDERepItemId();
                return true;
            }
            case 10: {
                pSDERepItemBase.resetPSDERepItemName();
                return true;
            }
            case 11: {
                pSDERepItemBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDERepItemBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDERepItemBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDERepItemBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDERepItemBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDERepItemBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSDERepItemBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getMajorPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEReport();
        }
        if (this.getMajorPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objMajorPSDEReportLock;
        synchronized (n) {
            if (this.majorpsdereport != null && DataTypeHelper.compare((int)25, (Object)this.getMajorPSDEReportId(), (Object)this.majorpsdereport.getPSDEReportId()) != 0L) {
                this.majorpsdereport = null;
            }
            if (this.majorpsdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getMajorPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet((IEntity)pSDEReport);
                this.majorpsdereport = pSDEReport;
            }
            return this.majorpsdereport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getMinorPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEReport();
        }
        if (this.getMinorPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDEReportLock;
        synchronized (n) {
            if (this.minorpsdereport != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEReportId(), (Object)this.minorpsdereport.getPSDEReportId()) != 0L) {
                this.minorpsdereport = null;
            }
            if (this.minorpsdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getMinorPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet((IEntity)pSDEReport);
                this.minorpsdereport = pSDEReport;
            }
            return this.minorpsdereport;
        }
    }

    private PSDERepItemBase getProxyEntity() {
        return this.proxyPSDERepItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERepItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERepItemBase) {
            this.proxyPSDERepItemBase = (PSDERepItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERepItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAJORPSDEREPORTID, 2);
        fieldIndexMap.put(FIELD_MAJORPSDEREPORTNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MINORPSDEREPORTID, 5);
        fieldIndexMap.put(FIELD_MINORPSDEREPORTNAME, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDEREPITEMID, 9);
        fieldIndexMap.put(FIELD_PSDEREPITEMNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

