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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERSView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDERSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppDERSBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CHILDFILTER = "CHILDFILTER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CPSAPPLOCALDEID = "CPSAPPLOCALDEID";
    public static final String FIELD_CPSAPPLOCALDENAME = "CPSAPPLOCALDENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSAPPLOCALDEID = "PPSAPPLOCALDEID";
    public static final String FIELD_PPSAPPLOCALDENAME = "PPSAPPLOCALDENAME";
    public static final String FIELD_PSAPPDERSID = "PSAPPDERSID";
    public static final String FIELD_PSAPPDERSNAME = "PSAPPDERSNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_RSVIEWMODE = "RSVIEWMODE";
    public static final String FIELD_TYPEFILTER = "TYPEFILTER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARRAYFLAG = 0;
    private static final int INDEX_CHILDFILTER = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CODENAME2 = 3;
    private static final int INDEX_CPSAPPLOCALDEID = 4;
    private static final int INDEX_CPSAPPLOCALDENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PPSAPPLOCALDEID = 10;
    private static final int INDEX_PPSAPPLOCALDENAME = 11;
    private static final int INDEX_PSAPPDERSID = 12;
    private static final int INDEX_PSAPPDERSNAME = 13;
    private static final int INDEX_PSDERID = 14;
    private static final int INDEX_PSDERNAME = 15;
    private static final int INDEX_PSSYSAPPID = 16;
    private static final int INDEX_PSSYSAPPNAME = 17;
    private static final int INDEX_RSVIEWMODE = 18;
    private static final int INDEX_TYPEFILTER = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppDERSBase proxyPSAppDERSBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean childfilterDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean cpsapplocaldeidDirtyFlag = false;
    private boolean cpsapplocaldenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsapplocaldeidDirtyFlag = false;
    private boolean ppsapplocaldenameDirtyFlag = false;
    private boolean psappdersidDirtyFlag = false;
    private boolean psappdersnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean rsviewmodeDirtyFlag = false;
    private boolean typefilterDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="childfilter")
    private String childfilter;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="cpsapplocaldeid")
    private String cpsapplocaldeid;
    @Column(name="cpsapplocaldename")
    private String cpsapplocaldename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsapplocaldeid")
    private String ppsapplocaldeid;
    @Column(name="ppsapplocaldename")
    private String ppsapplocaldename;
    @Column(name="psappdersid")
    private String psappdersid;
    @Column(name="psappdersname")
    private String psappdersname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="rsviewmode")
    private String rsviewmode;
    @Column(name="typefilter")
    private String typefilter;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objCPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE cpsapplocalde = null;
    private Integer objPPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE ppsapplocalde = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSAppDERSViewsLock = new Integer(1);
    private ArrayList<PSAppDERSView> psappdersviews = null;

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

    public void setChildFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childfilter = string;
        this.childfilterDirtyFlag = true;
    }

    public String getChildFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildFilter();
        }
        return this.childfilter;
    }

    public boolean isChildFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildFilterDirty();
        }
        return this.childfilterDirtyFlag;
    }

    public void resetChildFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildFilter();
            return;
        }
        this.childfilterDirtyFlag = false;
        this.childfilter = null;
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

    public void setCPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsapplocaldeid = string;
        this.cpsapplocaldeidDirtyFlag = true;
    }

    public String getCPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppLocalDEId();
        }
        return this.cpsapplocaldeid;
    }

    public boolean isCPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSAppLocalDEIdDirty();
        }
        return this.cpsapplocaldeidDirtyFlag;
    }

    public void resetCPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSAppLocalDEId();
            return;
        }
        this.cpsapplocaldeidDirtyFlag = false;
        this.cpsapplocaldeid = null;
    }

    public void setCPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsapplocaldename = string;
        this.cpsapplocaldenameDirtyFlag = true;
    }

    public String getCPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppLocalDEName();
        }
        return this.cpsapplocaldename;
    }

    public boolean isCPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSAppLocalDENameDirty();
        }
        return this.cpsapplocaldenameDirtyFlag;
    }

    public void resetCPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSAppLocalDEName();
            return;
        }
        this.cpsapplocaldenameDirtyFlag = false;
        this.cpsapplocaldename = null;
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

    public void setPPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapplocaldeid = string;
        this.ppsapplocaldeidDirtyFlag = true;
    }

    public String getPPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDEId();
        }
        return this.ppsapplocaldeid;
    }

    public boolean isPPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppLocalDEIdDirty();
        }
        return this.ppsapplocaldeidDirtyFlag;
    }

    public void resetPPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppLocalDEId();
            return;
        }
        this.ppsapplocaldeidDirtyFlag = false;
        this.ppsapplocaldeid = null;
    }

    public void setPPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsapplocaldename = string;
        this.ppsapplocaldenameDirtyFlag = true;
    }

    public String getPPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDEName();
        }
        return this.ppsapplocaldename;
    }

    public boolean isPPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSAppLocalDENameDirty();
        }
        return this.ppsapplocaldenameDirtyFlag;
    }

    public void resetPPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSAppLocalDEName();
            return;
        }
        this.ppsapplocaldenameDirtyFlag = false;
        this.ppsapplocaldename = null;
    }

    public void setPSAppDERSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersid = string;
        this.psappdersidDirtyFlag = true;
    }

    public String getPSAppDERSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSId();
        }
        return this.psappdersid;
    }

    public boolean isPSAppDERSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSIdDirty();
        }
        return this.psappdersidDirtyFlag;
    }

    public void resetPSAppDERSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSId();
            return;
        }
        this.psappdersidDirtyFlag = false;
        this.psappdersid = null;
    }

    public void setPSAppDERSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersname = string;
        this.psappdersnameDirtyFlag = true;
    }

    public String getPSAppDERSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSName();
        }
        return this.psappdersname;
    }

    public boolean isPSAppDERSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSNameDirty();
        }
        return this.psappdersnameDirtyFlag;
    }

    public void resetPSAppDERSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSName();
            return;
        }
        this.psappdersnameDirtyFlag = false;
        this.psappdersname = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setRSViewMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSViewMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rsviewmode = string;
        this.rsviewmodeDirtyFlag = true;
    }

    public String getRSViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSViewMode();
        }
        return this.rsviewmode;
    }

    public boolean isRSViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSViewModeDirty();
        }
        return this.rsviewmodeDirtyFlag;
    }

    public void resetRSViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSViewMode();
            return;
        }
        this.rsviewmodeDirtyFlag = false;
        this.rsviewmode = null;
    }

    public void setTypeFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typefilter = string;
        this.typefilterDirtyFlag = true;
    }

    public String getTypeFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeFilter();
        }
        return this.typefilter;
    }

    public boolean isTypeFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeFilterDirty();
        }
        return this.typefilterDirtyFlag;
    }

    public void resetTypeFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeFilter();
            return;
        }
        this.typefilterDirtyFlag = false;
        this.typefilter = null;
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
        PSAppDERSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppDERSBase pSAppDERSBase) {
        pSAppDERSBase.resetArrayFlag();
        pSAppDERSBase.resetChildFilter();
        pSAppDERSBase.resetCodeName();
        pSAppDERSBase.resetCodeName2();
        pSAppDERSBase.resetCPSAppLocalDEId();
        pSAppDERSBase.resetCPSAppLocalDEName();
        pSAppDERSBase.resetCreateDate();
        pSAppDERSBase.resetCreateMan();
        pSAppDERSBase.resetMemo();
        pSAppDERSBase.resetOrderValue();
        pSAppDERSBase.resetPPSAppLocalDEId();
        pSAppDERSBase.resetPPSAppLocalDEName();
        pSAppDERSBase.resetPSAppDERSId();
        pSAppDERSBase.resetPSAppDERSName();
        pSAppDERSBase.resetPSDERId();
        pSAppDERSBase.resetPSDERName();
        pSAppDERSBase.resetPSSysAppId();
        pSAppDERSBase.resetPSSysAppName();
        pSAppDERSBase.resetRSViewMode();
        pSAppDERSBase.resetTypeFilter();
        pSAppDERSBase.resetUpdateDate();
        pSAppDERSBase.resetUpdateMan();
        pSAppDERSBase.resetUserTag();
        pSAppDERSBase.resetUserTag2();
        pSAppDERSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
        }
        if (!bl || this.isChildFilterDirty()) {
            hashMap.put(FIELD_CHILDFILTER, this.getChildFilter());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_CPSAPPLOCALDEID, this.getCPSAppLocalDEId());
        }
        if (!bl || this.isCPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_CPSAPPLOCALDENAME, this.getCPSAppLocalDEName());
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
        if (!bl || this.isPPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PPSAPPLOCALDEID, this.getPPSAppLocalDEId());
        }
        if (!bl || this.isPPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PPSAPPLOCALDENAME, this.getPPSAppLocalDEName());
        }
        if (!bl || this.isPSAppDERSIdDirty()) {
            hashMap.put(FIELD_PSAPPDERSID, this.getPSAppDERSId());
        }
        if (!bl || this.isPSAppDERSNameDirty()) {
            hashMap.put(FIELD_PSAPPDERSNAME, this.getPSAppDERSName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isRSViewModeDirty()) {
            hashMap.put(FIELD_RSVIEWMODE, this.getRSViewMode());
        }
        if (!bl || this.isTypeFilterDirty()) {
            hashMap.put(FIELD_TYPEFILTER, this.getTypeFilter());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSAppDERSBase.get(this, n);
    }

    private static Object get(PSAppDERSBase pSAppDERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSBase.getArrayFlag();
            }
            case 1: {
                return pSAppDERSBase.getChildFilter();
            }
            case 2: {
                return pSAppDERSBase.getCodeName();
            }
            case 3: {
                return pSAppDERSBase.getCodeName2();
            }
            case 4: {
                return pSAppDERSBase.getCPSAppLocalDEId();
            }
            case 5: {
                return pSAppDERSBase.getCPSAppLocalDEName();
            }
            case 6: {
                return pSAppDERSBase.getCreateDate();
            }
            case 7: {
                return pSAppDERSBase.getCreateMan();
            }
            case 8: {
                return pSAppDERSBase.getMemo();
            }
            case 9: {
                return pSAppDERSBase.getOrderValue();
            }
            case 10: {
                return pSAppDERSBase.getPPSAppLocalDEId();
            }
            case 11: {
                return pSAppDERSBase.getPPSAppLocalDEName();
            }
            case 12: {
                return pSAppDERSBase.getPSAppDERSId();
            }
            case 13: {
                return pSAppDERSBase.getPSAppDERSName();
            }
            case 14: {
                return pSAppDERSBase.getPSDERId();
            }
            case 15: {
                return pSAppDERSBase.getPSDERName();
            }
            case 16: {
                return pSAppDERSBase.getPSSysAppId();
            }
            case 17: {
                return pSAppDERSBase.getPSSysAppName();
            }
            case 18: {
                return pSAppDERSBase.getRSViewMode();
            }
            case 19: {
                return pSAppDERSBase.getTypeFilter();
            }
            case 20: {
                return pSAppDERSBase.getUpdateDate();
            }
            case 21: {
                return pSAppDERSBase.getUpdateMan();
            }
            case 22: {
                return pSAppDERSBase.getUserTag();
            }
            case 23: {
                return pSAppDERSBase.getUserTag2();
            }
            case 24: {
                return pSAppDERSBase.getValidFlag();
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
        PSAppDERSBase.set(this, n, object);
    }

    private static void set(PSAppDERSBase pSAppDERSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppDERSBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSAppDERSBase.setChildFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppDERSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppDERSBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppDERSBase.setCPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppDERSBase.setCPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppDERSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSAppDERSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppDERSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppDERSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppDERSBase.setPPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppDERSBase.setPPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppDERSBase.setPSAppDERSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppDERSBase.setPSAppDERSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppDERSBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppDERSBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppDERSBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppDERSBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppDERSBase.setRSViewMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppDERSBase.setTypeFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppDERSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSAppDERSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppDERSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppDERSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppDERSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppDERSBase.isNull(this, n);
    }

    private static boolean isNull(PSAppDERSBase pSAppDERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSBase.getArrayFlag() == null;
            }
            case 1: {
                return pSAppDERSBase.getChildFilter() == null;
            }
            case 2: {
                return pSAppDERSBase.getCodeName() == null;
            }
            case 3: {
                return pSAppDERSBase.getCodeName2() == null;
            }
            case 4: {
                return pSAppDERSBase.getCPSAppLocalDEId() == null;
            }
            case 5: {
                return pSAppDERSBase.getCPSAppLocalDEName() == null;
            }
            case 6: {
                return pSAppDERSBase.getCreateDate() == null;
            }
            case 7: {
                return pSAppDERSBase.getCreateMan() == null;
            }
            case 8: {
                return pSAppDERSBase.getMemo() == null;
            }
            case 9: {
                return pSAppDERSBase.getOrderValue() == null;
            }
            case 10: {
                return pSAppDERSBase.getPPSAppLocalDEId() == null;
            }
            case 11: {
                return pSAppDERSBase.getPPSAppLocalDEName() == null;
            }
            case 12: {
                return pSAppDERSBase.getPSAppDERSId() == null;
            }
            case 13: {
                return pSAppDERSBase.getPSAppDERSName() == null;
            }
            case 14: {
                return pSAppDERSBase.getPSDERId() == null;
            }
            case 15: {
                return pSAppDERSBase.getPSDERName() == null;
            }
            case 16: {
                return pSAppDERSBase.getPSSysAppId() == null;
            }
            case 17: {
                return pSAppDERSBase.getPSSysAppName() == null;
            }
            case 18: {
                return pSAppDERSBase.getRSViewMode() == null;
            }
            case 19: {
                return pSAppDERSBase.getTypeFilter() == null;
            }
            case 20: {
                return pSAppDERSBase.getUpdateDate() == null;
            }
            case 21: {
                return pSAppDERSBase.getUpdateMan() == null;
            }
            case 22: {
                return pSAppDERSBase.getUserTag() == null;
            }
            case 23: {
                return pSAppDERSBase.getUserTag2() == null;
            }
            case 24: {
                return pSAppDERSBase.getValidFlag() == null;
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
        return PSAppDERSBase.contains(this, n);
    }

    private static boolean contains(PSAppDERSBase pSAppDERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSBase.isArrayFlagDirty();
            }
            case 1: {
                return pSAppDERSBase.isChildFilterDirty();
            }
            case 2: {
                return pSAppDERSBase.isCodeNameDirty();
            }
            case 3: {
                return pSAppDERSBase.isCodeName2Dirty();
            }
            case 4: {
                return pSAppDERSBase.isCPSAppLocalDEIdDirty();
            }
            case 5: {
                return pSAppDERSBase.isCPSAppLocalDENameDirty();
            }
            case 6: {
                return pSAppDERSBase.isCreateDateDirty();
            }
            case 7: {
                return pSAppDERSBase.isCreateManDirty();
            }
            case 8: {
                return pSAppDERSBase.isMemoDirty();
            }
            case 9: {
                return pSAppDERSBase.isOrderValueDirty();
            }
            case 10: {
                return pSAppDERSBase.isPPSAppLocalDEIdDirty();
            }
            case 11: {
                return pSAppDERSBase.isPPSAppLocalDENameDirty();
            }
            case 12: {
                return pSAppDERSBase.isPSAppDERSIdDirty();
            }
            case 13: {
                return pSAppDERSBase.isPSAppDERSNameDirty();
            }
            case 14: {
                return pSAppDERSBase.isPSDERIdDirty();
            }
            case 15: {
                return pSAppDERSBase.isPSDERNameDirty();
            }
            case 16: {
                return pSAppDERSBase.isPSSysAppIdDirty();
            }
            case 17: {
                return pSAppDERSBase.isPSSysAppNameDirty();
            }
            case 18: {
                return pSAppDERSBase.isRSViewModeDirty();
            }
            case 19: {
                return pSAppDERSBase.isTypeFilterDirty();
            }
            case 20: {
                return pSAppDERSBase.isUpdateDateDirty();
            }
            case 21: {
                return pSAppDERSBase.isUpdateManDirty();
            }
            case 22: {
                return pSAppDERSBase.isUserTagDirty();
            }
            case 23: {
                return pSAppDERSBase.isUserTag2Dirty();
            }
            case 24: {
                return pSAppDERSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppDERSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppDERSBase pSAppDERSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppDERSBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getChildFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childfilter", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getChildFilter()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsapplocaldeid", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsapplocaldename", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapplocaldeid", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsapplocaldename", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSAppDERSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersid", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSAppDERSId()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSAppDERSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersname", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSAppDERSName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getRSViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rsviewmode", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getRSViewMode()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getTypeFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefilter", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getTypeFilter()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppDERSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppDERSBase.getJSONValue((Object)pSAppDERSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppDERSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppDERSBase pSAppDERSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppDERSBase.getArrayFlag() != null) {
            object = pSAppDERSBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppDERSBase.getChildFilter() != null) {
            object = pSAppDERSBase.getChildFilter();
            xmlNode.setAttribute(FIELD_CHILDFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getCodeName() != null) {
            object = pSAppDERSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getCodeName2() != null) {
            object = pSAppDERSBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getCPSAppLocalDEId() != null) {
            object = pSAppDERSBase.getCPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_CPSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getCPSAppLocalDEName() != null) {
            object = pSAppDERSBase.getCPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_CPSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getCreateDate() != null) {
            object = pSAppDERSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDERSBase.getCreateMan() != null) {
            object = pSAppDERSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getMemo() != null) {
            object = pSAppDERSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getOrderValue() != null) {
            object = pSAppDERSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppDERSBase.getPPSAppLocalDEId() != null) {
            object = pSAppDERSBase.getPPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PPSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPPSAppLocalDEName() != null) {
            object = pSAppDERSBase.getPPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PPSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSAppDERSId() != null) {
            object = pSAppDERSBase.getPSAppDERSId();
            xmlNode.setAttribute(FIELD_PSAPPDERSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSAppDERSName() != null) {
            object = pSAppDERSBase.getPSAppDERSName();
            xmlNode.setAttribute(FIELD_PSAPPDERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSDERId() != null) {
            object = pSAppDERSBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSDERName() != null) {
            object = pSAppDERSBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSSysAppId() != null) {
            object = pSAppDERSBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getPSSysAppName() != null) {
            object = pSAppDERSBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getRSViewMode() != null) {
            object = pSAppDERSBase.getRSViewMode();
            xmlNode.setAttribute(FIELD_RSVIEWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getTypeFilter() != null) {
            object = pSAppDERSBase.getTypeFilter();
            xmlNode.setAttribute(FIELD_TYPEFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getUpdateDate() != null) {
            object = pSAppDERSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDERSBase.getUpdateMan() != null) {
            object = pSAppDERSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getUserTag() != null) {
            object = pSAppDERSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getUserTag2() != null) {
            object = pSAppDERSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSBase.getValidFlag() != null) {
            object = pSAppDERSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppDERSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppDERSBase pSAppDERSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppDERSBase.isArrayFlagDirty() && (bl || pSAppDERSBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSAppDERSBase.getArrayFlag());
        }
        if (pSAppDERSBase.isChildFilterDirty() && (bl || pSAppDERSBase.getChildFilter() != null)) {
            iDataObject.set(FIELD_CHILDFILTER, (Object)pSAppDERSBase.getChildFilter());
        }
        if (pSAppDERSBase.isCodeNameDirty() && (bl || pSAppDERSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppDERSBase.getCodeName());
        }
        if (pSAppDERSBase.isCodeName2Dirty() && (bl || pSAppDERSBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSAppDERSBase.getCodeName2());
        }
        if (pSAppDERSBase.isCPSAppLocalDEIdDirty() && (bl || pSAppDERSBase.getCPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_CPSAPPLOCALDEID, (Object)pSAppDERSBase.getCPSAppLocalDEId());
        }
        if (pSAppDERSBase.isCPSAppLocalDENameDirty() && (bl || pSAppDERSBase.getCPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_CPSAPPLOCALDENAME, (Object)pSAppDERSBase.getCPSAppLocalDEName());
        }
        if (pSAppDERSBase.isCreateDateDirty() && (bl || pSAppDERSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppDERSBase.getCreateDate());
        }
        if (pSAppDERSBase.isCreateManDirty() && (bl || pSAppDERSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppDERSBase.getCreateMan());
        }
        if (pSAppDERSBase.isMemoDirty() && (bl || pSAppDERSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppDERSBase.getMemo());
        }
        if (pSAppDERSBase.isOrderValueDirty() && (bl || pSAppDERSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSAppDERSBase.getOrderValue());
        }
        if (pSAppDERSBase.isPPSAppLocalDEIdDirty() && (bl || pSAppDERSBase.getPPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PPSAPPLOCALDEID, (Object)pSAppDERSBase.getPPSAppLocalDEId());
        }
        if (pSAppDERSBase.isPPSAppLocalDENameDirty() && (bl || pSAppDERSBase.getPPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PPSAPPLOCALDENAME, (Object)pSAppDERSBase.getPPSAppLocalDEName());
        }
        if (pSAppDERSBase.isPSAppDERSIdDirty() && (bl || pSAppDERSBase.getPSAppDERSId() != null)) {
            iDataObject.set(FIELD_PSAPPDERSID, (Object)pSAppDERSBase.getPSAppDERSId());
        }
        if (pSAppDERSBase.isPSAppDERSNameDirty() && (bl || pSAppDERSBase.getPSAppDERSName() != null)) {
            iDataObject.set(FIELD_PSAPPDERSNAME, (Object)pSAppDERSBase.getPSAppDERSName());
        }
        if (pSAppDERSBase.isPSDERIdDirty() && (bl || pSAppDERSBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSAppDERSBase.getPSDERId());
        }
        if (pSAppDERSBase.isPSDERNameDirty() && (bl || pSAppDERSBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSAppDERSBase.getPSDERName());
        }
        if (pSAppDERSBase.isPSSysAppIdDirty() && (bl || pSAppDERSBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppDERSBase.getPSSysAppId());
        }
        if (pSAppDERSBase.isPSSysAppNameDirty() && (bl || pSAppDERSBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppDERSBase.getPSSysAppName());
        }
        if (pSAppDERSBase.isRSViewModeDirty() && (bl || pSAppDERSBase.getRSViewMode() != null)) {
            iDataObject.set(FIELD_RSVIEWMODE, (Object)pSAppDERSBase.getRSViewMode());
        }
        if (pSAppDERSBase.isTypeFilterDirty() && (bl || pSAppDERSBase.getTypeFilter() != null)) {
            iDataObject.set(FIELD_TYPEFILTER, (Object)pSAppDERSBase.getTypeFilter());
        }
        if (pSAppDERSBase.isUpdateDateDirty() && (bl || pSAppDERSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppDERSBase.getUpdateDate());
        }
        if (pSAppDERSBase.isUpdateManDirty() && (bl || pSAppDERSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppDERSBase.getUpdateMan());
        }
        if (pSAppDERSBase.isUserTagDirty() && (bl || pSAppDERSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppDERSBase.getUserTag());
        }
        if (pSAppDERSBase.isUserTag2Dirty() && (bl || pSAppDERSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppDERSBase.getUserTag2());
        }
        if (pSAppDERSBase.isValidFlagDirty() && (bl || pSAppDERSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppDERSBase.getValidFlag());
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
        return PSAppDERSBase.remove(this, n);
    }

    private static boolean remove(PSAppDERSBase pSAppDERSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppDERSBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSAppDERSBase.resetChildFilter();
                return true;
            }
            case 2: {
                pSAppDERSBase.resetCodeName();
                return true;
            }
            case 3: {
                pSAppDERSBase.resetCodeName2();
                return true;
            }
            case 4: {
                pSAppDERSBase.resetCPSAppLocalDEId();
                return true;
            }
            case 5: {
                pSAppDERSBase.resetCPSAppLocalDEName();
                return true;
            }
            case 6: {
                pSAppDERSBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSAppDERSBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSAppDERSBase.resetMemo();
                return true;
            }
            case 9: {
                pSAppDERSBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSAppDERSBase.resetPPSAppLocalDEId();
                return true;
            }
            case 11: {
                pSAppDERSBase.resetPPSAppLocalDEName();
                return true;
            }
            case 12: {
                pSAppDERSBase.resetPSAppDERSId();
                return true;
            }
            case 13: {
                pSAppDERSBase.resetPSAppDERSName();
                return true;
            }
            case 14: {
                pSAppDERSBase.resetPSDERId();
                return true;
            }
            case 15: {
                pSAppDERSBase.resetPSDERName();
                return true;
            }
            case 16: {
                pSAppDERSBase.resetPSSysAppId();
                return true;
            }
            case 17: {
                pSAppDERSBase.resetPSSysAppName();
                return true;
            }
            case 18: {
                pSAppDERSBase.resetRSViewMode();
                return true;
            }
            case 19: {
                pSAppDERSBase.resetTypeFilter();
                return true;
            }
            case 20: {
                pSAppDERSBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSAppDERSBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSAppDERSBase.resetUserTag();
                return true;
            }
            case 23: {
                pSAppDERSBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSAppDERSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getCPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSAppLocalDE();
        }
        if (this.getCPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objCPSAppLocalDELock;
        synchronized (n) {
            if (this.cpsapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getCPSAppLocalDEId(), (Object)this.cpsapplocalde.getPSAppLocalDEId()) != 0L) {
                this.cpsapplocalde = null;
            }
            if (this.cpsapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getCPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.cpsapplocalde = pSAppLocalDE;
            }
            return this.cpsapplocalde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSAppLocalDE();
        }
        if (this.getPPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPPSAppLocalDELock;
        synchronized (n) {
            if (this.ppsapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPPSAppLocalDEId(), (Object)this.ppsapplocalde.getPSAppLocalDEId()) != 0L) {
                this.ppsapplocalde = null;
            }
            if (this.ppsapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet(pSAppLocalDE);
                this.ppsapplocalde = pSAppLocalDE;
            }
            return this.ppsapplocalde;
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
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppDERSView> getPSAppDERSViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSViews();
        }
        if (this.getPSAppDERSId() == null) {
            return null;
        }
        PSAppDERSViewService pSAppDERSViewService = (PSAppDERSViewService)ServiceGlobal.getService(PSAppDERSViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppDERSViewsLock;
        synchronized (n) {
            if (this.psappdersviews == null) {
                this.psappdersviews = pSAppDERSViewService.selectByPSAppDERS(this);
            }
            return this.psappdersviews;
        }
    }

    private PSAppDERSBase getProxyEntity() {
        return this.proxyPSAppDERSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppDERSBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppDERSBase) {
            this.proxyPSAppDERSBase = (PSAppDERSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARRAYFLAG, 0);
        fieldIndexMap.put(FIELD_CHILDFILTER, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CODENAME2, 3);
        fieldIndexMap.put(FIELD_CPSAPPLOCALDEID, 4);
        fieldIndexMap.put(FIELD_CPSAPPLOCALDENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PPSAPPLOCALDEID, 10);
        fieldIndexMap.put(FIELD_PPSAPPLOCALDENAME, 11);
        fieldIndexMap.put(FIELD_PSAPPDERSID, 12);
        fieldIndexMap.put(FIELD_PSAPPDERSNAME, 13);
        fieldIndexMap.put(FIELD_PSDERID, 14);
        fieldIndexMap.put(FIELD_PSDERNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 16);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 17);
        fieldIndexMap.put(FIELD_RSVIEWMODE, 18);
        fieldIndexMap.put(FIELD_TYPEFILTER, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
    }
}

