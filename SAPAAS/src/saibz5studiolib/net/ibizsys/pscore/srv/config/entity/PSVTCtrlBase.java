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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSSysACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSysToolbarService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTCtrlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVTCtrlBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARAM = "CTRLPARAM";
    public static final String FIELD_CTRLPARAM10 = "CTRLPARAM10";
    public static final String FIELD_CTRLPARAM11 = "CTRLPARAM11";
    public static final String FIELD_CTRLPARAM12 = "CTRLPARAM12";
    public static final String FIELD_CTRLPARAM2 = "CTRLPARAM2";
    public static final String FIELD_CTRLPARAM3 = "CTRLPARAM3";
    public static final String FIELD_CTRLPARAM4 = "CTRLPARAM4";
    public static final String FIELD_CTRLPARAM5 = "CTRLPARAM5";
    public static final String FIELD_CTRLPARAM6 = "CTRLPARAM6";
    public static final String FIELD_CTRLPARAM7 = "CTRLPARAM7";
    public static final String FIELD_CTRLPARAM8 = "CTRLPARAM8";
    public static final String FIELD_CTRLPARAM9 = "CTRLPARAM9";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLEDYNATOOL = "ENABLEDYNATOOL";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSACHANDLERID = "PSSYSACHANDLERID";
    public static final String FIELD_PSSYSACHANDLERNAME = "PSSYSACHANDLERNAME";
    public static final String FIELD_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String FIELD_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PSVTCTRLID = "PSVTCTRLID";
    public static final String FIELD_PSVTCTRLNAME = "PSVTCTRLNAME";
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
    private static final int INDEX_CTRLPARAM = 2;
    private static final int INDEX_CTRLPARAM10 = 3;
    private static final int INDEX_CTRLPARAM11 = 4;
    private static final int INDEX_CTRLPARAM12 = 5;
    private static final int INDEX_CTRLPARAM2 = 6;
    private static final int INDEX_CTRLPARAM3 = 7;
    private static final int INDEX_CTRLPARAM4 = 8;
    private static final int INDEX_CTRLPARAM5 = 9;
    private static final int INDEX_CTRLPARAM6 = 10;
    private static final int INDEX_CTRLPARAM7 = 11;
    private static final int INDEX_CTRLPARAM8 = 12;
    private static final int INDEX_CTRLPARAM9 = 13;
    private static final int INDEX_CTRLTYPE = 14;
    private static final int INDEX_DEFAULTFLAG = 15;
    private static final int INDEX_ENABLEDYNATOOL = 16;
    private static final int INDEX_ENABLEVIEWACTIONS = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_ORDERVALUE = 19;
    private static final int INDEX_PSSYSACHANDLERID = 20;
    private static final int INDEX_PSSYSACHANDLERNAME = 21;
    private static final int INDEX_PSSYSTOOLBARID = 22;
    private static final int INDEX_PSSYSTOOLBARNAME = 23;
    private static final int INDEX_PSVIEWTYPEID = 24;
    private static final int INDEX_PSVIEWTYPENAME = 25;
    private static final int INDEX_PSVTCTRLID = 26;
    private static final int INDEX_PSVTCTRLNAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVTCtrlBase proxyPSVTCtrlBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlparamDirtyFlag = false;
    private boolean ctrlparam10DirtyFlag = false;
    private boolean ctrlparam11DirtyFlag = false;
    private boolean ctrlparam12DirtyFlag = false;
    private boolean ctrlparam2DirtyFlag = false;
    private boolean ctrlparam3DirtyFlag = false;
    private boolean ctrlparam4DirtyFlag = false;
    private boolean ctrlparam5DirtyFlag = false;
    private boolean ctrlparam6DirtyFlag = false;
    private boolean ctrlparam7DirtyFlag = false;
    private boolean ctrlparam8DirtyFlag = false;
    private boolean ctrlparam9DirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enabledynatoolDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysachandleridDirtyFlag = false;
    private boolean pssysachandlernameDirtyFlag = false;
    private boolean pssystoolbaridDirtyFlag = false;
    private boolean pssystoolbarnameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean psvtctrlidDirtyFlag = false;
    private boolean psvtctrlnameDirtyFlag = false;
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
    @Column(name="ctrlparam")
    private String ctrlparam;
    @Column(name="ctrlparam10")
    private Double ctrlparam10;
    @Column(name="ctrlparam11")
    private Integer ctrlparam11;
    @Column(name="ctrlparam12")
    private Integer ctrlparam12;
    @Column(name="ctrlparam2")
    private String ctrlparam2;
    @Column(name="ctrlparam3")
    private String ctrlparam3;
    @Column(name="ctrlparam4")
    private String ctrlparam4;
    @Column(name="ctrlparam5")
    private Integer ctrlparam5;
    @Column(name="ctrlparam6")
    private Integer ctrlparam6;
    @Column(name="ctrlparam7")
    private Integer ctrlparam7;
    @Column(name="ctrlparam8")
    private Integer ctrlparam8;
    @Column(name="ctrlparam9")
    private Double ctrlparam9;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enabledynatool")
    private Integer enabledynatool;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysachandlerid")
    private String pssysachandlerid;
    @Column(name="pssysachandlername")
    private String pssysachandlername;
    @Column(name="pssystoolbarid")
    private String pssystoolbarid;
    @Column(name="pssystoolbarname")
    private String pssystoolbarname;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="psvtctrlid")
    private String psvtctrlid;
    @Column(name="psvtctrlname")
    private String psvtctrlname;
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
    private Integer objPSSysACHandlerLock = new Integer(1);
    private PSSysACHandler pssysachandler = null;
    private Integer objPSSysToolbarLock = new Integer(1);
    private PSSysToolbar pssystoolbar = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam = string;
        this.ctrlparamDirtyFlag = true;
    }

    public String getCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam();
        }
        return this.ctrlparam;
    }

    public boolean isCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamDirty();
        }
        return this.ctrlparamDirtyFlag;
    }

    public void resetCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam();
            return;
        }
        this.ctrlparamDirtyFlag = false;
        this.ctrlparam = null;
    }

    public void setCtrlParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam10(d);
            return;
        }
        this.ctrlparam10 = d;
        this.ctrlparam10DirtyFlag = true;
    }

    public Double getCtrlParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam10();
        }
        return this.ctrlparam10;
    }

    public boolean isCtrlParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam10Dirty();
        }
        return this.ctrlparam10DirtyFlag;
    }

    public void resetCtrlParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam10();
            return;
        }
        this.ctrlparam10DirtyFlag = false;
        this.ctrlparam10 = null;
    }

    public void setCtrlParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam11(n);
            return;
        }
        this.ctrlparam11 = n;
        this.ctrlparam11DirtyFlag = true;
    }

    public Integer getCtrlParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam11();
        }
        return this.ctrlparam11;
    }

    public boolean isCtrlParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam11Dirty();
        }
        return this.ctrlparam11DirtyFlag;
    }

    public void resetCtrlParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam11();
            return;
        }
        this.ctrlparam11DirtyFlag = false;
        this.ctrlparam11 = null;
    }

    public void setCtrlParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam12(n);
            return;
        }
        this.ctrlparam12 = n;
        this.ctrlparam12DirtyFlag = true;
    }

    public Integer getCtrlParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam12();
        }
        return this.ctrlparam12;
    }

    public boolean isCtrlParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam12Dirty();
        }
        return this.ctrlparam12DirtyFlag;
    }

    public void resetCtrlParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam12();
            return;
        }
        this.ctrlparam12DirtyFlag = false;
        this.ctrlparam12 = null;
    }

    public void setCtrlParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam2 = string;
        this.ctrlparam2DirtyFlag = true;
    }

    public String getCtrlParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam2();
        }
        return this.ctrlparam2;
    }

    public boolean isCtrlParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam2Dirty();
        }
        return this.ctrlparam2DirtyFlag;
    }

    public void resetCtrlParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam2();
            return;
        }
        this.ctrlparam2DirtyFlag = false;
        this.ctrlparam2 = null;
    }

    public void setCtrlParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam3 = string;
        this.ctrlparam3DirtyFlag = true;
    }

    public String getCtrlParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam3();
        }
        return this.ctrlparam3;
    }

    public boolean isCtrlParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam3Dirty();
        }
        return this.ctrlparam3DirtyFlag;
    }

    public void resetCtrlParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam3();
            return;
        }
        this.ctrlparam3DirtyFlag = false;
        this.ctrlparam3 = null;
    }

    public void setCtrlParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam4 = string;
        this.ctrlparam4DirtyFlag = true;
    }

    public String getCtrlParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam4();
        }
        return this.ctrlparam4;
    }

    public boolean isCtrlParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam4Dirty();
        }
        return this.ctrlparam4DirtyFlag;
    }

    public void resetCtrlParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam4();
            return;
        }
        this.ctrlparam4DirtyFlag = false;
        this.ctrlparam4 = null;
    }

    public void setCtrlParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam5(n);
            return;
        }
        this.ctrlparam5 = n;
        this.ctrlparam5DirtyFlag = true;
    }

    public Integer getCtrlParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam5();
        }
        return this.ctrlparam5;
    }

    public boolean isCtrlParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam5Dirty();
        }
        return this.ctrlparam5DirtyFlag;
    }

    public void resetCtrlParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam5();
            return;
        }
        this.ctrlparam5DirtyFlag = false;
        this.ctrlparam5 = null;
    }

    public void setCtrlParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam6(n);
            return;
        }
        this.ctrlparam6 = n;
        this.ctrlparam6DirtyFlag = true;
    }

    public Integer getCtrlParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam6();
        }
        return this.ctrlparam6;
    }

    public boolean isCtrlParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam6Dirty();
        }
        return this.ctrlparam6DirtyFlag;
    }

    public void resetCtrlParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam6();
            return;
        }
        this.ctrlparam6DirtyFlag = false;
        this.ctrlparam6 = null;
    }

    public void setCtrlParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam7(n);
            return;
        }
        this.ctrlparam7 = n;
        this.ctrlparam7DirtyFlag = true;
    }

    public Integer getCtrlParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam7();
        }
        return this.ctrlparam7;
    }

    public boolean isCtrlParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam7Dirty();
        }
        return this.ctrlparam7DirtyFlag;
    }

    public void resetCtrlParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam7();
            return;
        }
        this.ctrlparam7DirtyFlag = false;
        this.ctrlparam7 = null;
    }

    public void setCtrlParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam8(n);
            return;
        }
        this.ctrlparam8 = n;
        this.ctrlparam8DirtyFlag = true;
    }

    public Integer getCtrlParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam8();
        }
        return this.ctrlparam8;
    }

    public boolean isCtrlParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam8Dirty();
        }
        return this.ctrlparam8DirtyFlag;
    }

    public void resetCtrlParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam8();
            return;
        }
        this.ctrlparam8DirtyFlag = false;
        this.ctrlparam8 = null;
    }

    public void setCtrlParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam9(d);
            return;
        }
        this.ctrlparam9 = d;
        this.ctrlparam9DirtyFlag = true;
    }

    public Double getCtrlParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam9();
        }
        return this.ctrlparam9;
    }

    public boolean isCtrlParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam9Dirty();
        }
        return this.ctrlparam9DirtyFlag;
    }

    public void resetCtrlParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam9();
            return;
        }
        this.ctrlparam9DirtyFlag = false;
        this.ctrlparam9 = null;
    }

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setEnableDynaTool(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaTool(n);
            return;
        }
        this.enabledynatool = n;
        this.enabledynatoolDirtyFlag = true;
    }

    public Integer getEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaTool();
        }
        return this.enabledynatool;
    }

    public boolean isEnableDynaToolDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaToolDirty();
        }
        return this.enabledynatoolDirtyFlag;
    }

    public void resetEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaTool();
            return;
        }
        this.enabledynatoolDirtyFlag = false;
        this.enabledynatool = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
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

    public void setPSSysACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlerid = string;
        this.pssysachandleridDirtyFlag = true;
    }

    public String getPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerId();
        }
        return this.pssysachandlerid;
    }

    public boolean isPSSysACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerIdDirty();
        }
        return this.pssysachandleridDirtyFlag;
    }

    public void resetPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerId();
            return;
        }
        this.pssysachandleridDirtyFlag = false;
        this.pssysachandlerid = null;
    }

    public void setPSSysACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlername = string;
        this.pssysachandlernameDirtyFlag = true;
    }

    public String getPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerName();
        }
        return this.pssysachandlername;
    }

    public boolean isPSSysACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerNameDirty();
        }
        return this.pssysachandlernameDirtyFlag;
    }

    public void resetPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerName();
            return;
        }
        this.pssysachandlernameDirtyFlag = false;
        this.pssysachandlername = null;
    }

    public void setPSSysToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarid = string;
        this.pssystoolbaridDirtyFlag = true;
    }

    public String getPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarId();
        }
        return this.pssystoolbarid;
    }

    public boolean isPSSysToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarIdDirty();
        }
        return this.pssystoolbaridDirtyFlag;
    }

    public void resetPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarId();
            return;
        }
        this.pssystoolbaridDirtyFlag = false;
        this.pssystoolbarid = null;
    }

    public void setPSSysToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarname = string;
        this.pssystoolbarnameDirtyFlag = true;
    }

    public String getPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarName();
        }
        return this.pssystoolbarname;
    }

    public boolean isPSSysToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarNameDirty();
        }
        return this.pssystoolbarnameDirtyFlag;
    }

    public void resetPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarName();
            return;
        }
        this.pssystoolbarnameDirtyFlag = false;
        this.pssystoolbarname = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setPSVTCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtctrlid = string;
        this.psvtctrlidDirtyFlag = true;
    }

    public String getPSVTCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTCtrlId();
        }
        return this.psvtctrlid;
    }

    public boolean isPSVTCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTCtrlIdDirty();
        }
        return this.psvtctrlidDirtyFlag;
    }

    public void resetPSVTCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTCtrlId();
            return;
        }
        this.psvtctrlidDirtyFlag = false;
        this.psvtctrlid = null;
    }

    public void setPSVTCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtctrlname = string;
        this.psvtctrlnameDirtyFlag = true;
    }

    public String getPSVTCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTCtrlName();
        }
        return this.psvtctrlname;
    }

    public boolean isPSVTCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTCtrlNameDirty();
        }
        return this.psvtctrlnameDirtyFlag;
    }

    public void resetPSVTCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTCtrlName();
            return;
        }
        this.psvtctrlnameDirtyFlag = false;
        this.psvtctrlname = null;
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
        PSVTCtrlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVTCtrlBase pSVTCtrlBase) {
        pSVTCtrlBase.resetCreateDate();
        pSVTCtrlBase.resetCreateMan();
        pSVTCtrlBase.resetCtrlParam();
        pSVTCtrlBase.resetCtrlParam10();
        pSVTCtrlBase.resetCtrlParam11();
        pSVTCtrlBase.resetCtrlParam12();
        pSVTCtrlBase.resetCtrlParam2();
        pSVTCtrlBase.resetCtrlParam3();
        pSVTCtrlBase.resetCtrlParam4();
        pSVTCtrlBase.resetCtrlParam5();
        pSVTCtrlBase.resetCtrlParam6();
        pSVTCtrlBase.resetCtrlParam7();
        pSVTCtrlBase.resetCtrlParam8();
        pSVTCtrlBase.resetCtrlParam9();
        pSVTCtrlBase.resetCtrlType();
        pSVTCtrlBase.resetDefaultFlag();
        pSVTCtrlBase.resetEnableDynaTool();
        pSVTCtrlBase.resetEnableViewActions();
        pSVTCtrlBase.resetMemo();
        pSVTCtrlBase.resetOrderValue();
        pSVTCtrlBase.resetPSSysACHandlerId();
        pSVTCtrlBase.resetPSSysACHandlerName();
        pSVTCtrlBase.resetPSSysToolbarId();
        pSVTCtrlBase.resetPSSysToolbarName();
        pSVTCtrlBase.resetPSViewTypeId();
        pSVTCtrlBase.resetPSViewTypeName();
        pSVTCtrlBase.resetPSVTCtrlId();
        pSVTCtrlBase.resetPSVTCtrlName();
        pSVTCtrlBase.resetUpdateDate();
        pSVTCtrlBase.resetUpdateMan();
        pSVTCtrlBase.resetUserCat();
        pSVTCtrlBase.resetUserTag();
        pSVTCtrlBase.resetUserTag2();
        pSVTCtrlBase.resetUserTag3();
        pSVTCtrlBase.resetUserTag4();
        pSVTCtrlBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlParamDirty()) {
            hashMap.put(FIELD_CTRLPARAM, this.getCtrlParam());
        }
        if (!bl || this.isCtrlParam10Dirty()) {
            hashMap.put(FIELD_CTRLPARAM10, this.getCtrlParam10());
        }
        if (!bl || this.isCtrlParam11Dirty()) {
            hashMap.put(FIELD_CTRLPARAM11, this.getCtrlParam11());
        }
        if (!bl || this.isCtrlParam12Dirty()) {
            hashMap.put(FIELD_CTRLPARAM12, this.getCtrlParam12());
        }
        if (!bl || this.isCtrlParam2Dirty()) {
            hashMap.put(FIELD_CTRLPARAM2, this.getCtrlParam2());
        }
        if (!bl || this.isCtrlParam3Dirty()) {
            hashMap.put(FIELD_CTRLPARAM3, this.getCtrlParam3());
        }
        if (!bl || this.isCtrlParam4Dirty()) {
            hashMap.put(FIELD_CTRLPARAM4, this.getCtrlParam4());
        }
        if (!bl || this.isCtrlParam5Dirty()) {
            hashMap.put(FIELD_CTRLPARAM5, this.getCtrlParam5());
        }
        if (!bl || this.isCtrlParam6Dirty()) {
            hashMap.put(FIELD_CTRLPARAM6, this.getCtrlParam6());
        }
        if (!bl || this.isCtrlParam7Dirty()) {
            hashMap.put(FIELD_CTRLPARAM7, this.getCtrlParam7());
        }
        if (!bl || this.isCtrlParam8Dirty()) {
            hashMap.put(FIELD_CTRLPARAM8, this.getCtrlParam8());
        }
        if (!bl || this.isCtrlParam9Dirty()) {
            hashMap.put(FIELD_CTRLPARAM9, this.getCtrlParam9());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEnableDynaToolDirty()) {
            hashMap.put(FIELD_ENABLEDYNATOOL, this.getEnableDynaTool());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERID, this.getPSSysACHandlerId());
        }
        if (!bl || this.isPSSysACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERNAME, this.getPSSysACHandlerName());
        }
        if (!bl || this.isPSSysToolbarIdDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARID, this.getPSSysToolbarId());
        }
        if (!bl || this.isPSSysToolbarNameDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARNAME, this.getPSSysToolbarName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPSVTCtrlIdDirty()) {
            hashMap.put(FIELD_PSVTCTRLID, this.getPSVTCtrlId());
        }
        if (!bl || this.isPSVTCtrlNameDirty()) {
            hashMap.put(FIELD_PSVTCTRLNAME, this.getPSVTCtrlName());
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
        return PSVTCtrlBase.get(this, n);
    }

    private static Object get(PSVTCtrlBase pSVTCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCtrlBase.getCreateDate();
            }
            case 1: {
                return pSVTCtrlBase.getCreateMan();
            }
            case 2: {
                return pSVTCtrlBase.getCtrlParam();
            }
            case 3: {
                return pSVTCtrlBase.getCtrlParam10();
            }
            case 4: {
                return pSVTCtrlBase.getCtrlParam11();
            }
            case 5: {
                return pSVTCtrlBase.getCtrlParam12();
            }
            case 6: {
                return pSVTCtrlBase.getCtrlParam2();
            }
            case 7: {
                return pSVTCtrlBase.getCtrlParam3();
            }
            case 8: {
                return pSVTCtrlBase.getCtrlParam4();
            }
            case 9: {
                return pSVTCtrlBase.getCtrlParam5();
            }
            case 10: {
                return pSVTCtrlBase.getCtrlParam6();
            }
            case 11: {
                return pSVTCtrlBase.getCtrlParam7();
            }
            case 12: {
                return pSVTCtrlBase.getCtrlParam8();
            }
            case 13: {
                return pSVTCtrlBase.getCtrlParam9();
            }
            case 14: {
                return pSVTCtrlBase.getCtrlType();
            }
            case 15: {
                return pSVTCtrlBase.getDefaultFlag();
            }
            case 16: {
                return pSVTCtrlBase.getEnableDynaTool();
            }
            case 17: {
                return pSVTCtrlBase.getEnableViewActions();
            }
            case 18: {
                return pSVTCtrlBase.getMemo();
            }
            case 19: {
                return pSVTCtrlBase.getOrderValue();
            }
            case 20: {
                return pSVTCtrlBase.getPSSysACHandlerId();
            }
            case 21: {
                return pSVTCtrlBase.getPSSysACHandlerName();
            }
            case 22: {
                return pSVTCtrlBase.getPSSysToolbarId();
            }
            case 23: {
                return pSVTCtrlBase.getPSSysToolbarName();
            }
            case 24: {
                return pSVTCtrlBase.getPSViewTypeId();
            }
            case 25: {
                return pSVTCtrlBase.getPSViewTypeName();
            }
            case 26: {
                return pSVTCtrlBase.getPSVTCtrlId();
            }
            case 27: {
                return pSVTCtrlBase.getPSVTCtrlName();
            }
            case 28: {
                return pSVTCtrlBase.getUpdateDate();
            }
            case 29: {
                return pSVTCtrlBase.getUpdateMan();
            }
            case 30: {
                return pSVTCtrlBase.getUserCat();
            }
            case 31: {
                return pSVTCtrlBase.getUserTag();
            }
            case 32: {
                return pSVTCtrlBase.getUserTag2();
            }
            case 33: {
                return pSVTCtrlBase.getUserTag3();
            }
            case 34: {
                return pSVTCtrlBase.getUserTag4();
            }
            case 35: {
                return pSVTCtrlBase.getValidFlag();
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
        PSVTCtrlBase.set(this, n, object);
    }

    private static void set(PSVTCtrlBase pSVTCtrlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVTCtrlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVTCtrlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVTCtrlBase.setCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVTCtrlBase.setCtrlParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSVTCtrlBase.setCtrlParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSVTCtrlBase.setCtrlParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSVTCtrlBase.setCtrlParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVTCtrlBase.setCtrlParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVTCtrlBase.setCtrlParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSVTCtrlBase.setCtrlParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSVTCtrlBase.setCtrlParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSVTCtrlBase.setCtrlParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSVTCtrlBase.setCtrlParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSVTCtrlBase.setCtrlParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 14: {
                pSVTCtrlBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSVTCtrlBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSVTCtrlBase.setEnableDynaTool(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSVTCtrlBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSVTCtrlBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSVTCtrlBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSVTCtrlBase.setPSSysACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSVTCtrlBase.setPSSysACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSVTCtrlBase.setPSSysToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSVTCtrlBase.setPSSysToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSVTCtrlBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSVTCtrlBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSVTCtrlBase.setPSVTCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSVTCtrlBase.setPSVTCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSVTCtrlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSVTCtrlBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSVTCtrlBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSVTCtrlBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSVTCtrlBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSVTCtrlBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSVTCtrlBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSVTCtrlBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSVTCtrlBase.isNull(this, n);
    }

    private static boolean isNull(PSVTCtrlBase pSVTCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCtrlBase.getCreateDate() == null;
            }
            case 1: {
                return pSVTCtrlBase.getCreateMan() == null;
            }
            case 2: {
                return pSVTCtrlBase.getCtrlParam() == null;
            }
            case 3: {
                return pSVTCtrlBase.getCtrlParam10() == null;
            }
            case 4: {
                return pSVTCtrlBase.getCtrlParam11() == null;
            }
            case 5: {
                return pSVTCtrlBase.getCtrlParam12() == null;
            }
            case 6: {
                return pSVTCtrlBase.getCtrlParam2() == null;
            }
            case 7: {
                return pSVTCtrlBase.getCtrlParam3() == null;
            }
            case 8: {
                return pSVTCtrlBase.getCtrlParam4() == null;
            }
            case 9: {
                return pSVTCtrlBase.getCtrlParam5() == null;
            }
            case 10: {
                return pSVTCtrlBase.getCtrlParam6() == null;
            }
            case 11: {
                return pSVTCtrlBase.getCtrlParam7() == null;
            }
            case 12: {
                return pSVTCtrlBase.getCtrlParam8() == null;
            }
            case 13: {
                return pSVTCtrlBase.getCtrlParam9() == null;
            }
            case 14: {
                return pSVTCtrlBase.getCtrlType() == null;
            }
            case 15: {
                return pSVTCtrlBase.getDefaultFlag() == null;
            }
            case 16: {
                return pSVTCtrlBase.getEnableDynaTool() == null;
            }
            case 17: {
                return pSVTCtrlBase.getEnableViewActions() == null;
            }
            case 18: {
                return pSVTCtrlBase.getMemo() == null;
            }
            case 19: {
                return pSVTCtrlBase.getOrderValue() == null;
            }
            case 20: {
                return pSVTCtrlBase.getPSSysACHandlerId() == null;
            }
            case 21: {
                return pSVTCtrlBase.getPSSysACHandlerName() == null;
            }
            case 22: {
                return pSVTCtrlBase.getPSSysToolbarId() == null;
            }
            case 23: {
                return pSVTCtrlBase.getPSSysToolbarName() == null;
            }
            case 24: {
                return pSVTCtrlBase.getPSViewTypeId() == null;
            }
            case 25: {
                return pSVTCtrlBase.getPSViewTypeName() == null;
            }
            case 26: {
                return pSVTCtrlBase.getPSVTCtrlId() == null;
            }
            case 27: {
                return pSVTCtrlBase.getPSVTCtrlName() == null;
            }
            case 28: {
                return pSVTCtrlBase.getUpdateDate() == null;
            }
            case 29: {
                return pSVTCtrlBase.getUpdateMan() == null;
            }
            case 30: {
                return pSVTCtrlBase.getUserCat() == null;
            }
            case 31: {
                return pSVTCtrlBase.getUserTag() == null;
            }
            case 32: {
                return pSVTCtrlBase.getUserTag2() == null;
            }
            case 33: {
                return pSVTCtrlBase.getUserTag3() == null;
            }
            case 34: {
                return pSVTCtrlBase.getUserTag4() == null;
            }
            case 35: {
                return pSVTCtrlBase.getValidFlag() == null;
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
        return PSVTCtrlBase.contains(this, n);
    }

    private static boolean contains(PSVTCtrlBase pSVTCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTCtrlBase.isCreateDateDirty();
            }
            case 1: {
                return pSVTCtrlBase.isCreateManDirty();
            }
            case 2: {
                return pSVTCtrlBase.isCtrlParamDirty();
            }
            case 3: {
                return pSVTCtrlBase.isCtrlParam10Dirty();
            }
            case 4: {
                return pSVTCtrlBase.isCtrlParam11Dirty();
            }
            case 5: {
                return pSVTCtrlBase.isCtrlParam12Dirty();
            }
            case 6: {
                return pSVTCtrlBase.isCtrlParam2Dirty();
            }
            case 7: {
                return pSVTCtrlBase.isCtrlParam3Dirty();
            }
            case 8: {
                return pSVTCtrlBase.isCtrlParam4Dirty();
            }
            case 9: {
                return pSVTCtrlBase.isCtrlParam5Dirty();
            }
            case 10: {
                return pSVTCtrlBase.isCtrlParam6Dirty();
            }
            case 11: {
                return pSVTCtrlBase.isCtrlParam7Dirty();
            }
            case 12: {
                return pSVTCtrlBase.isCtrlParam8Dirty();
            }
            case 13: {
                return pSVTCtrlBase.isCtrlParam9Dirty();
            }
            case 14: {
                return pSVTCtrlBase.isCtrlTypeDirty();
            }
            case 15: {
                return pSVTCtrlBase.isDefaultFlagDirty();
            }
            case 16: {
                return pSVTCtrlBase.isEnableDynaToolDirty();
            }
            case 17: {
                return pSVTCtrlBase.isEnableViewActionsDirty();
            }
            case 18: {
                return pSVTCtrlBase.isMemoDirty();
            }
            case 19: {
                return pSVTCtrlBase.isOrderValueDirty();
            }
            case 20: {
                return pSVTCtrlBase.isPSSysACHandlerIdDirty();
            }
            case 21: {
                return pSVTCtrlBase.isPSSysACHandlerNameDirty();
            }
            case 22: {
                return pSVTCtrlBase.isPSSysToolbarIdDirty();
            }
            case 23: {
                return pSVTCtrlBase.isPSSysToolbarNameDirty();
            }
            case 24: {
                return pSVTCtrlBase.isPSViewTypeIdDirty();
            }
            case 25: {
                return pSVTCtrlBase.isPSViewTypeNameDirty();
            }
            case 26: {
                return pSVTCtrlBase.isPSVTCtrlIdDirty();
            }
            case 27: {
                return pSVTCtrlBase.isPSVTCtrlNameDirty();
            }
            case 28: {
                return pSVTCtrlBase.isUpdateDateDirty();
            }
            case 29: {
                return pSVTCtrlBase.isUpdateManDirty();
            }
            case 30: {
                return pSVTCtrlBase.isUserCatDirty();
            }
            case 31: {
                return pSVTCtrlBase.isUserTagDirty();
            }
            case 32: {
                return pSVTCtrlBase.isUserTag2Dirty();
            }
            case 33: {
                return pSVTCtrlBase.isUserTag3Dirty();
            }
            case 34: {
                return pSVTCtrlBase.isUserTag4Dirty();
            }
            case 35: {
                return pSVTCtrlBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVTCtrlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVTCtrlBase pSVTCtrlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVTCtrlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam10", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam10()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam11", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam11()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam12", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam12()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam2", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam2()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam3", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam3()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam4", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam4()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam5", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam5()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam6", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam6()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam7", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam7()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam8", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam8()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam9", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlParam9()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getEnableDynaTool() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynatool", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getEnableDynaTool()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getMemo()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSSysACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlerid", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSSysACHandlerId()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSSysACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlername", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSSysACHandlerName()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSSysToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarid", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSSysToolbarId()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSSysToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarname", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSSysToolbarName()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSVTCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtctrlid", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSVTCtrlId()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getPSVTCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtctrlname", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getPSVTCtrlName()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUserCat()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUserTag()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSVTCtrlBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVTCtrlBase.getJSONValue((Object)pSVTCtrlBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVTCtrlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVTCtrlBase pSVTCtrlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVTCtrlBase.getCreateDate() != null) {
            object = pSVTCtrlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCreateMan() != null) {
            object = pSVTCtrlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getCtrlParam() != null) {
            object = pSVTCtrlBase.getCtrlParam();
            xmlNode.setAttribute(FIELD_CTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getCtrlParam10() != null) {
            object = pSVTCtrlBase.getCtrlParam10();
            xmlNode.setAttribute(FIELD_CTRLPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam11() != null) {
            object = pSVTCtrlBase.getCtrlParam11();
            xmlNode.setAttribute(FIELD_CTRLPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam12() != null) {
            object = pSVTCtrlBase.getCtrlParam12();
            xmlNode.setAttribute(FIELD_CTRLPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam2() != null) {
            object = pSVTCtrlBase.getCtrlParam2();
            xmlNode.setAttribute(FIELD_CTRLPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getCtrlParam3() != null) {
            object = pSVTCtrlBase.getCtrlParam3();
            xmlNode.setAttribute(FIELD_CTRLPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getCtrlParam4() != null) {
            object = pSVTCtrlBase.getCtrlParam4();
            xmlNode.setAttribute(FIELD_CTRLPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getCtrlParam5() != null) {
            object = pSVTCtrlBase.getCtrlParam5();
            xmlNode.setAttribute(FIELD_CTRLPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam6() != null) {
            object = pSVTCtrlBase.getCtrlParam6();
            xmlNode.setAttribute(FIELD_CTRLPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam7() != null) {
            object = pSVTCtrlBase.getCtrlParam7();
            xmlNode.setAttribute(FIELD_CTRLPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam8() != null) {
            object = pSVTCtrlBase.getCtrlParam8();
            xmlNode.setAttribute(FIELD_CTRLPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlParam9() != null) {
            object = pSVTCtrlBase.getCtrlParam9();
            xmlNode.setAttribute(FIELD_CTRLPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getCtrlType() != null) {
            object = pSVTCtrlBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getDefaultFlag() != null) {
            object = pSVTCtrlBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getEnableDynaTool() != null) {
            object = pSVTCtrlBase.getEnableDynaTool();
            xmlNode.setAttribute(FIELD_ENABLEDYNATOOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getEnableViewActions() != null) {
            object = pSVTCtrlBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getMemo() != null) {
            object = pSVTCtrlBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getOrderValue() != null) {
            object = pSVTCtrlBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVTCtrlBase.getPSSysACHandlerId() != null) {
            object = pSVTCtrlBase.getPSSysACHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSSysACHandlerName() != null) {
            object = pSVTCtrlBase.getPSSysACHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSSysToolbarId() != null) {
            object = pSVTCtrlBase.getPSSysToolbarId();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSSysToolbarName() != null) {
            object = pSVTCtrlBase.getPSSysToolbarName();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSViewTypeId() != null) {
            object = pSVTCtrlBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSViewTypeName() != null) {
            object = pSVTCtrlBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSVTCtrlId() != null) {
            object = pSVTCtrlBase.getPSVTCtrlId();
            xmlNode.setAttribute(FIELD_PSVTCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getPSVTCtrlName() != null) {
            object = pSVTCtrlBase.getPSVTCtrlName();
            xmlNode.setAttribute(FIELD_PSVTCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUpdateDate() != null) {
            object = pSVTCtrlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTCtrlBase.getUpdateMan() != null) {
            object = pSVTCtrlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUserCat() != null) {
            object = pSVTCtrlBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUserTag() != null) {
            object = pSVTCtrlBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUserTag2() != null) {
            object = pSVTCtrlBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUserTag3() != null) {
            object = pSVTCtrlBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getUserTag4() != null) {
            object = pSVTCtrlBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSVTCtrlBase.getValidFlag() != null) {
            object = pSVTCtrlBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVTCtrlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVTCtrlBase pSVTCtrlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVTCtrlBase.isCreateDateDirty() && (bl || pSVTCtrlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVTCtrlBase.getCreateDate());
        }
        if (pSVTCtrlBase.isCreateManDirty() && (bl || pSVTCtrlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVTCtrlBase.getCreateMan());
        }
        if (pSVTCtrlBase.isCtrlParamDirty() && (bl || pSVTCtrlBase.getCtrlParam() != null)) {
            iDataObject.set(FIELD_CTRLPARAM, (Object)pSVTCtrlBase.getCtrlParam());
        }
        if (pSVTCtrlBase.isCtrlParam10Dirty() && (bl || pSVTCtrlBase.getCtrlParam10() != null)) {
            iDataObject.set(FIELD_CTRLPARAM10, (Object)pSVTCtrlBase.getCtrlParam10());
        }
        if (pSVTCtrlBase.isCtrlParam11Dirty() && (bl || pSVTCtrlBase.getCtrlParam11() != null)) {
            iDataObject.set(FIELD_CTRLPARAM11, (Object)pSVTCtrlBase.getCtrlParam11());
        }
        if (pSVTCtrlBase.isCtrlParam12Dirty() && (bl || pSVTCtrlBase.getCtrlParam12() != null)) {
            iDataObject.set(FIELD_CTRLPARAM12, (Object)pSVTCtrlBase.getCtrlParam12());
        }
        if (pSVTCtrlBase.isCtrlParam2Dirty() && (bl || pSVTCtrlBase.getCtrlParam2() != null)) {
            iDataObject.set(FIELD_CTRLPARAM2, (Object)pSVTCtrlBase.getCtrlParam2());
        }
        if (pSVTCtrlBase.isCtrlParam3Dirty() && (bl || pSVTCtrlBase.getCtrlParam3() != null)) {
            iDataObject.set(FIELD_CTRLPARAM3, (Object)pSVTCtrlBase.getCtrlParam3());
        }
        if (pSVTCtrlBase.isCtrlParam4Dirty() && (bl || pSVTCtrlBase.getCtrlParam4() != null)) {
            iDataObject.set(FIELD_CTRLPARAM4, (Object)pSVTCtrlBase.getCtrlParam4());
        }
        if (pSVTCtrlBase.isCtrlParam5Dirty() && (bl || pSVTCtrlBase.getCtrlParam5() != null)) {
            iDataObject.set(FIELD_CTRLPARAM5, (Object)pSVTCtrlBase.getCtrlParam5());
        }
        if (pSVTCtrlBase.isCtrlParam6Dirty() && (bl || pSVTCtrlBase.getCtrlParam6() != null)) {
            iDataObject.set(FIELD_CTRLPARAM6, (Object)pSVTCtrlBase.getCtrlParam6());
        }
        if (pSVTCtrlBase.isCtrlParam7Dirty() && (bl || pSVTCtrlBase.getCtrlParam7() != null)) {
            iDataObject.set(FIELD_CTRLPARAM7, (Object)pSVTCtrlBase.getCtrlParam7());
        }
        if (pSVTCtrlBase.isCtrlParam8Dirty() && (bl || pSVTCtrlBase.getCtrlParam8() != null)) {
            iDataObject.set(FIELD_CTRLPARAM8, (Object)pSVTCtrlBase.getCtrlParam8());
        }
        if (pSVTCtrlBase.isCtrlParam9Dirty() && (bl || pSVTCtrlBase.getCtrlParam9() != null)) {
            iDataObject.set(FIELD_CTRLPARAM9, (Object)pSVTCtrlBase.getCtrlParam9());
        }
        if (pSVTCtrlBase.isCtrlTypeDirty() && (bl || pSVTCtrlBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSVTCtrlBase.getCtrlType());
        }
        if (pSVTCtrlBase.isDefaultFlagDirty() && (bl || pSVTCtrlBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSVTCtrlBase.getDefaultFlag());
        }
        if (pSVTCtrlBase.isEnableDynaToolDirty() && (bl || pSVTCtrlBase.getEnableDynaTool() != null)) {
            iDataObject.set(FIELD_ENABLEDYNATOOL, (Object)pSVTCtrlBase.getEnableDynaTool());
        }
        if (pSVTCtrlBase.isEnableViewActionsDirty() && (bl || pSVTCtrlBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSVTCtrlBase.getEnableViewActions());
        }
        if (pSVTCtrlBase.isMemoDirty() && (bl || pSVTCtrlBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVTCtrlBase.getMemo());
        }
        if (pSVTCtrlBase.isOrderValueDirty() && (bl || pSVTCtrlBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSVTCtrlBase.getOrderValue());
        }
        if (pSVTCtrlBase.isPSSysACHandlerIdDirty() && (bl || pSVTCtrlBase.getPSSysACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERID, (Object)pSVTCtrlBase.getPSSysACHandlerId());
        }
        if (pSVTCtrlBase.isPSSysACHandlerNameDirty() && (bl || pSVTCtrlBase.getPSSysACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERNAME, (Object)pSVTCtrlBase.getPSSysACHandlerName());
        }
        if (pSVTCtrlBase.isPSSysToolbarIdDirty() && (bl || pSVTCtrlBase.getPSSysToolbarId() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARID, (Object)pSVTCtrlBase.getPSSysToolbarId());
        }
        if (pSVTCtrlBase.isPSSysToolbarNameDirty() && (bl || pSVTCtrlBase.getPSSysToolbarName() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARNAME, (Object)pSVTCtrlBase.getPSSysToolbarName());
        }
        if (pSVTCtrlBase.isPSViewTypeIdDirty() && (bl || pSVTCtrlBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSVTCtrlBase.getPSViewTypeId());
        }
        if (pSVTCtrlBase.isPSViewTypeNameDirty() && (bl || pSVTCtrlBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSVTCtrlBase.getPSViewTypeName());
        }
        if (pSVTCtrlBase.isPSVTCtrlIdDirty() && (bl || pSVTCtrlBase.getPSVTCtrlId() != null)) {
            iDataObject.set(FIELD_PSVTCTRLID, (Object)pSVTCtrlBase.getPSVTCtrlId());
        }
        if (pSVTCtrlBase.isPSVTCtrlNameDirty() && (bl || pSVTCtrlBase.getPSVTCtrlName() != null)) {
            iDataObject.set(FIELD_PSVTCTRLNAME, (Object)pSVTCtrlBase.getPSVTCtrlName());
        }
        if (pSVTCtrlBase.isUpdateDateDirty() && (bl || pSVTCtrlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVTCtrlBase.getUpdateDate());
        }
        if (pSVTCtrlBase.isUpdateManDirty() && (bl || pSVTCtrlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVTCtrlBase.getUpdateMan());
        }
        if (pSVTCtrlBase.isUserCatDirty() && (bl || pSVTCtrlBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSVTCtrlBase.getUserCat());
        }
        if (pSVTCtrlBase.isUserTagDirty() && (bl || pSVTCtrlBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSVTCtrlBase.getUserTag());
        }
        if (pSVTCtrlBase.isUserTag2Dirty() && (bl || pSVTCtrlBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSVTCtrlBase.getUserTag2());
        }
        if (pSVTCtrlBase.isUserTag3Dirty() && (bl || pSVTCtrlBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSVTCtrlBase.getUserTag3());
        }
        if (pSVTCtrlBase.isUserTag4Dirty() && (bl || pSVTCtrlBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSVTCtrlBase.getUserTag4());
        }
        if (pSVTCtrlBase.isValidFlagDirty() && (bl || pSVTCtrlBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVTCtrlBase.getValidFlag());
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
        return PSVTCtrlBase.remove(this, n);
    }

    private static boolean remove(PSVTCtrlBase pSVTCtrlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVTCtrlBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVTCtrlBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVTCtrlBase.resetCtrlParam();
                return true;
            }
            case 3: {
                pSVTCtrlBase.resetCtrlParam10();
                return true;
            }
            case 4: {
                pSVTCtrlBase.resetCtrlParam11();
                return true;
            }
            case 5: {
                pSVTCtrlBase.resetCtrlParam12();
                return true;
            }
            case 6: {
                pSVTCtrlBase.resetCtrlParam2();
                return true;
            }
            case 7: {
                pSVTCtrlBase.resetCtrlParam3();
                return true;
            }
            case 8: {
                pSVTCtrlBase.resetCtrlParam4();
                return true;
            }
            case 9: {
                pSVTCtrlBase.resetCtrlParam5();
                return true;
            }
            case 10: {
                pSVTCtrlBase.resetCtrlParam6();
                return true;
            }
            case 11: {
                pSVTCtrlBase.resetCtrlParam7();
                return true;
            }
            case 12: {
                pSVTCtrlBase.resetCtrlParam8();
                return true;
            }
            case 13: {
                pSVTCtrlBase.resetCtrlParam9();
                return true;
            }
            case 14: {
                pSVTCtrlBase.resetCtrlType();
                return true;
            }
            case 15: {
                pSVTCtrlBase.resetDefaultFlag();
                return true;
            }
            case 16: {
                pSVTCtrlBase.resetEnableDynaTool();
                return true;
            }
            case 17: {
                pSVTCtrlBase.resetEnableViewActions();
                return true;
            }
            case 18: {
                pSVTCtrlBase.resetMemo();
                return true;
            }
            case 19: {
                pSVTCtrlBase.resetOrderValue();
                return true;
            }
            case 20: {
                pSVTCtrlBase.resetPSSysACHandlerId();
                return true;
            }
            case 21: {
                pSVTCtrlBase.resetPSSysACHandlerName();
                return true;
            }
            case 22: {
                pSVTCtrlBase.resetPSSysToolbarId();
                return true;
            }
            case 23: {
                pSVTCtrlBase.resetPSSysToolbarName();
                return true;
            }
            case 24: {
                pSVTCtrlBase.resetPSViewTypeId();
                return true;
            }
            case 25: {
                pSVTCtrlBase.resetPSViewTypeName();
                return true;
            }
            case 26: {
                pSVTCtrlBase.resetPSVTCtrlId();
                return true;
            }
            case 27: {
                pSVTCtrlBase.resetPSVTCtrlName();
                return true;
            }
            case 28: {
                pSVTCtrlBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSVTCtrlBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSVTCtrlBase.resetUserCat();
                return true;
            }
            case 31: {
                pSVTCtrlBase.resetUserTag();
                return true;
            }
            case 32: {
                pSVTCtrlBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSVTCtrlBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSVTCtrlBase.resetUserTag4();
                return true;
            }
            case 35: {
                pSVTCtrlBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysACHandler getPSSysACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandler();
        }
        if (this.getPSSysACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSSysACHandlerLock;
        synchronized (n) {
            if (this.pssysachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysACHandlerId(), (Object)this.pssysachandler.getPSSysACHandlerId()) != 0L) {
                this.pssysachandler = null;
            }
            if (this.pssysachandler == null) {
                PSSysACHandler pSSysACHandler = new PSSysACHandler();
                pSSysACHandler.setPSSysACHandlerId(this.getPSSysACHandlerId());
                PSSysACHandlerService pSSysACHandlerService = (PSSysACHandlerService)ServiceGlobal.getService(PSSysACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSysACHandlerService.autoGet(pSSysACHandler);
                this.pssysachandler = pSSysACHandler;
            }
            return this.pssysachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysToolbar getPSSysToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbar();
        }
        if (this.getPSSysToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSSysToolbarLock;
        synchronized (n) {
            if (this.pssystoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysToolbarId(), (Object)this.pssystoolbar.getPSSysToolbarId()) != 0L) {
                this.pssystoolbar = null;
            }
            if (this.pssystoolbar == null) {
                PSSysToolbar pSSysToolbar = new PSSysToolbar();
                pSSysToolbar.setPSSysToolbarId(this.getPSSysToolbarId());
                PSSysToolbarService pSSysToolbarService = (PSSysToolbarService)ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSSysToolbarService.autoGet(pSSysToolbar);
                this.pssystoolbar = pSSysToolbar;
            }
            return this.pssystoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSVTCtrlBase getProxyEntity() {
        return this.proxyPSVTCtrlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVTCtrlBase = null;
        if (iDataObject != null && iDataObject instanceof PSVTCtrlBase) {
            this.proxyPSVTCtrlBase = (PSVTCtrlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTCtrlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLPARAM, 2);
        fieldIndexMap.put(FIELD_CTRLPARAM10, 3);
        fieldIndexMap.put(FIELD_CTRLPARAM11, 4);
        fieldIndexMap.put(FIELD_CTRLPARAM12, 5);
        fieldIndexMap.put(FIELD_CTRLPARAM2, 6);
        fieldIndexMap.put(FIELD_CTRLPARAM3, 7);
        fieldIndexMap.put(FIELD_CTRLPARAM4, 8);
        fieldIndexMap.put(FIELD_CTRLPARAM5, 9);
        fieldIndexMap.put(FIELD_CTRLPARAM6, 10);
        fieldIndexMap.put(FIELD_CTRLPARAM7, 11);
        fieldIndexMap.put(FIELD_CTRLPARAM8, 12);
        fieldIndexMap.put(FIELD_CTRLPARAM9, 13);
        fieldIndexMap.put(FIELD_CTRLTYPE, 14);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 15);
        fieldIndexMap.put(FIELD_ENABLEDYNATOOL, 16);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_ORDERVALUE, 19);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERID, 20);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARID, 22);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARNAME, 23);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 24);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 25);
        fieldIndexMap.put(FIELD_PSVTCTRLID, 26);
        fieldIndexMap.put(FIELD_PSVTCTRLNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
    }
}

