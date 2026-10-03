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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewLogicParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewLogicParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMCAT = "PARAMCAT";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PARAMKEY = "PARAMKEY";
    public static final String FIELD_PARAMSTATE = "PARAMSTATE";
    public static final String FIELD_PARAMSUBKEY = "PARAMSUBKEY";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PARAMVALUE = "PARAMVALUE";
    public static final String FIELD_PARAMVALUE10 = "PARAMVALUE10";
    public static final String FIELD_PARAMVALUE2 = "PARAMVALUE2";
    public static final String FIELD_PARAMVALUE3 = "PARAMVALUE3";
    public static final String FIELD_PARAMVALUE4 = "PARAMVALUE4";
    public static final String FIELD_PARAMVALUE5 = "PARAMVALUE5";
    public static final String FIELD_PARAMVALUE6 = "PARAMVALUE6";
    public static final String FIELD_PARAMVALUE7 = "PARAMVALUE7";
    public static final String FIELD_PARAMVALUE8 = "PARAMVALUE8";
    public static final String FIELD_PARAMVALUE9 = "PARAMVALUE9";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSSYSVIEWLOGICPARAMID = "PSSYSVIEWLOGICPARAMID";
    public static final String FIELD_PSSYSVIEWLOGICPARAMNAME = "PSSYSVIEWLOGICPARAMNAME";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PARAMCAT = 4;
    private static final int INDEX_PARAMDESC = 5;
    private static final int INDEX_PARAMKEY = 6;
    private static final int INDEX_PARAMSTATE = 7;
    private static final int INDEX_PARAMSUBKEY = 8;
    private static final int INDEX_PARAMTYPE = 9;
    private static final int INDEX_PARAMVALUE = 10;
    private static final int INDEX_PARAMVALUE10 = 11;
    private static final int INDEX_PARAMVALUE2 = 12;
    private static final int INDEX_PARAMVALUE3 = 13;
    private static final int INDEX_PARAMVALUE4 = 14;
    private static final int INDEX_PARAMVALUE5 = 15;
    private static final int INDEX_PARAMVALUE6 = 16;
    private static final int INDEX_PARAMVALUE7 = 17;
    private static final int INDEX_PARAMVALUE8 = 18;
    private static final int INDEX_PARAMVALUE9 = 19;
    private static final int INDEX_PSSYSVIEWLOGICID = 20;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 21;
    private static final int INDEX_PSSYSVIEWLOGICPARAMID = 22;
    private static final int INDEX_PSSYSVIEWLOGICPARAMNAME = 23;
    private static final int INDEX_REFOBJID = 24;
    private static final int INDEX_REFOBJNAME = 25;
    private static final int INDEX_REFOBJTYPE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewLogicParamBase proxyPSSysViewLogicParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramcatDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean paramkeyDirtyFlag = false;
    private boolean paramstateDirtyFlag = false;
    private boolean paramsubkeyDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean paramvalueDirtyFlag = false;
    private boolean paramvalue10DirtyFlag = false;
    private boolean paramvalue2DirtyFlag = false;
    private boolean paramvalue3DirtyFlag = false;
    private boolean paramvalue4DirtyFlag = false;
    private boolean paramvalue5DirtyFlag = false;
    private boolean paramvalue6DirtyFlag = false;
    private boolean paramvalue7DirtyFlag = false;
    private boolean paramvalue8DirtyFlag = false;
    private boolean paramvalue9DirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean pssysviewlogicparamidDirtyFlag = false;
    private boolean pssysviewlogicparamnameDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramcat")
    private String paramcat;
    @Column(name="paramdesc")
    private String paramdesc;
    @Column(name="paramkey")
    private String paramkey;
    @Column(name="paramstate")
    private Integer paramstate;
    @Column(name="paramsubkey")
    private String paramsubkey;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="paramvalue")
    private String paramvalue;
    @Column(name="paramvalue10")
    private Integer paramvalue10;
    @Column(name="paramvalue2")
    private String paramvalue2;
    @Column(name="paramvalue3")
    private String paramvalue3;
    @Column(name="paramvalue4")
    private String paramvalue4;
    @Column(name="paramvalue5")
    private Integer paramvalue5;
    @Column(name="paramvalue6")
    private Integer paramvalue6;
    @Column(name="paramvalue7")
    private Double paramvalue7;
    @Column(name="paramvalue8")
    private Double paramvalue8;
    @Column(name="paramvalue9")
    private Integer paramvalue9;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
    @Column(name="pssysviewlogicparamid")
    private String pssysviewlogicparamid;
    @Column(name="pssysviewlogicparamname")
    private String pssysviewlogicparamname;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
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
    private Integer objPSSysViewLogicLock = new Integer(1);
    private PSSysViewLogic pssysviewlogic = null;

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

    public void setParamCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramcat = string;
        this.paramcatDirtyFlag = true;
    }

    public String getParamCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamCat();
        }
        return this.paramcat;
    }

    public boolean isParamCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamCatDirty();
        }
        return this.paramcatDirtyFlag;
    }

    public void resetParamCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamCat();
            return;
        }
        this.paramcatDirtyFlag = false;
        this.paramcat = null;
    }

    public void setParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramdesc = string;
        this.paramdescDirtyFlag = true;
    }

    public String getParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDesc();
        }
        return this.paramdesc;
    }

    public boolean isParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDescDirty();
        }
        return this.paramdescDirtyFlag;
    }

    public void resetParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDesc();
            return;
        }
        this.paramdescDirtyFlag = false;
        this.paramdesc = null;
    }

    public void setParamKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramkey = string;
        this.paramkeyDirtyFlag = true;
    }

    public String getParamKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamKey();
        }
        return this.paramkey;
    }

    public boolean isParamKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamKeyDirty();
        }
        return this.paramkeyDirtyFlag;
    }

    public void resetParamKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamKey();
            return;
        }
        this.paramkeyDirtyFlag = false;
        this.paramkey = null;
    }

    public void setParamState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamState(n);
            return;
        }
        this.paramstate = n;
        this.paramstateDirtyFlag = true;
    }

    public Integer getParamState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamState();
        }
        return this.paramstate;
    }

    public boolean isParamStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamStateDirty();
        }
        return this.paramstateDirtyFlag;
    }

    public void resetParamState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamState();
            return;
        }
        this.paramstateDirtyFlag = false;
        this.paramstate = null;
    }

    public void setParamSubKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamSubKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramsubkey = string;
        this.paramsubkeyDirtyFlag = true;
    }

    public String getParamSubKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamSubKey();
        }
        return this.paramsubkey;
    }

    public boolean isParamSubKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamSubKeyDirty();
        }
        return this.paramsubkeyDirtyFlag;
    }

    public void resetParamSubKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamSubKey();
            return;
        }
        this.paramsubkeyDirtyFlag = false;
        this.paramsubkey = null;
    }

    public void setParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtype = string;
        this.paramtypeDirtyFlag = true;
    }

    public String getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setParamValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue = string;
        this.paramvalueDirtyFlag = true;
    }

    public String getParamValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue();
        }
        return this.paramvalue;
    }

    public boolean isParamValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValueDirty();
        }
        return this.paramvalueDirtyFlag;
    }

    public void resetParamValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue();
            return;
        }
        this.paramvalueDirtyFlag = false;
        this.paramvalue = null;
    }

    public void setParamValue10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue10(n);
            return;
        }
        this.paramvalue10 = n;
        this.paramvalue10DirtyFlag = true;
    }

    public Integer getParamValue10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue10();
        }
        return this.paramvalue10;
    }

    public boolean isParamValue10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue10Dirty();
        }
        return this.paramvalue10DirtyFlag;
    }

    public void resetParamValue10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue10();
            return;
        }
        this.paramvalue10DirtyFlag = false;
        this.paramvalue10 = null;
    }

    public void setParamValue2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue2 = string;
        this.paramvalue2DirtyFlag = true;
    }

    public String getParamValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue2();
        }
        return this.paramvalue2;
    }

    public boolean isParamValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue2Dirty();
        }
        return this.paramvalue2DirtyFlag;
    }

    public void resetParamValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue2();
            return;
        }
        this.paramvalue2DirtyFlag = false;
        this.paramvalue2 = null;
    }

    public void setParamValue3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue3 = string;
        this.paramvalue3DirtyFlag = true;
    }

    public String getParamValue3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue3();
        }
        return this.paramvalue3;
    }

    public boolean isParamValue3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue3Dirty();
        }
        return this.paramvalue3DirtyFlag;
    }

    public void resetParamValue3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue3();
            return;
        }
        this.paramvalue3DirtyFlag = false;
        this.paramvalue3 = null;
    }

    public void setParamValue4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue4 = string;
        this.paramvalue4DirtyFlag = true;
    }

    public String getParamValue4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue4();
        }
        return this.paramvalue4;
    }

    public boolean isParamValue4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue4Dirty();
        }
        return this.paramvalue4DirtyFlag;
    }

    public void resetParamValue4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue4();
            return;
        }
        this.paramvalue4DirtyFlag = false;
        this.paramvalue4 = null;
    }

    public void setParamValue5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue5(n);
            return;
        }
        this.paramvalue5 = n;
        this.paramvalue5DirtyFlag = true;
    }

    public Integer getParamValue5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue5();
        }
        return this.paramvalue5;
    }

    public boolean isParamValue5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue5Dirty();
        }
        return this.paramvalue5DirtyFlag;
    }

    public void resetParamValue5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue5();
            return;
        }
        this.paramvalue5DirtyFlag = false;
        this.paramvalue5 = null;
    }

    public void setParamValue6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue6(n);
            return;
        }
        this.paramvalue6 = n;
        this.paramvalue6DirtyFlag = true;
    }

    public Integer getParamValue6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue6();
        }
        return this.paramvalue6;
    }

    public boolean isParamValue6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue6Dirty();
        }
        return this.paramvalue6DirtyFlag;
    }

    public void resetParamValue6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue6();
            return;
        }
        this.paramvalue6DirtyFlag = false;
        this.paramvalue6 = null;
    }

    public void setParamValue7(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue7(d);
            return;
        }
        this.paramvalue7 = d;
        this.paramvalue7DirtyFlag = true;
    }

    public Double getParamValue7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue7();
        }
        return this.paramvalue7;
    }

    public boolean isParamValue7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue7Dirty();
        }
        return this.paramvalue7DirtyFlag;
    }

    public void resetParamValue7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue7();
            return;
        }
        this.paramvalue7DirtyFlag = false;
        this.paramvalue7 = null;
    }

    public void setParamValue8(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue8(d);
            return;
        }
        this.paramvalue8 = d;
        this.paramvalue8DirtyFlag = true;
    }

    public Double getParamValue8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue8();
        }
        return this.paramvalue8;
    }

    public boolean isParamValue8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue8Dirty();
        }
        return this.paramvalue8DirtyFlag;
    }

    public void resetParamValue8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue8();
            return;
        }
        this.paramvalue8DirtyFlag = false;
        this.paramvalue8 = null;
    }

    public void setParamValue9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue9(n);
            return;
        }
        this.paramvalue9 = n;
        this.paramvalue9DirtyFlag = true;
    }

    public Integer getParamValue9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue9();
        }
        return this.paramvalue9;
    }

    public boolean isParamValue9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue9Dirty();
        }
        return this.paramvalue9DirtyFlag;
    }

    public void resetParamValue9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue9();
            return;
        }
        this.paramvalue9DirtyFlag = false;
        this.paramvalue9 = null;
    }

    public void setPSSysViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicid = string;
        this.pssysviewlogicidDirtyFlag = true;
    }

    public String getPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicId();
        }
        return this.pssysviewlogicid;
    }

    public boolean isPSSysViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicIdDirty();
        }
        return this.pssysviewlogicidDirtyFlag;
    }

    public void resetPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicId();
            return;
        }
        this.pssysviewlogicidDirtyFlag = false;
        this.pssysviewlogicid = null;
    }

    public void setPSSysViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicname = string;
        this.pssysviewlogicnameDirtyFlag = true;
    }

    public String getPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicName();
        }
        return this.pssysviewlogicname;
    }

    public boolean isPSSysViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicNameDirty();
        }
        return this.pssysviewlogicnameDirtyFlag;
    }

    public void resetPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicName();
            return;
        }
        this.pssysviewlogicnameDirtyFlag = false;
        this.pssysviewlogicname = null;
    }

    public void setPSSysViewLogicParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicparamid = string;
        this.pssysviewlogicparamidDirtyFlag = true;
    }

    public String getPSSysViewLogicParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicParamId();
        }
        return this.pssysviewlogicparamid;
    }

    public boolean isPSSysViewLogicParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicParamIdDirty();
        }
        return this.pssysviewlogicparamidDirtyFlag;
    }

    public void resetPSSysViewLogicParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicParamId();
            return;
        }
        this.pssysviewlogicparamidDirtyFlag = false;
        this.pssysviewlogicparamid = null;
    }

    public void setPSSysViewLogicParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicparamname = string;
        this.pssysviewlogicparamnameDirtyFlag = true;
    }

    public String getPSSysViewLogicParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicParamName();
        }
        return this.pssysviewlogicparamname;
    }

    public boolean isPSSysViewLogicParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicParamNameDirty();
        }
        return this.pssysviewlogicparamnameDirtyFlag;
    }

    public void resetPSSysViewLogicParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicParamName();
            return;
        }
        this.pssysviewlogicparamnameDirtyFlag = false;
        this.pssysviewlogicparamname = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
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
        PSSysViewLogicParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewLogicParamBase pSSysViewLogicParamBase) {
        pSSysViewLogicParamBase.resetCreateDate();
        pSSysViewLogicParamBase.resetCreateMan();
        pSSysViewLogicParamBase.resetMemo();
        pSSysViewLogicParamBase.resetOrderValue();
        pSSysViewLogicParamBase.resetParamCat();
        pSSysViewLogicParamBase.resetParamDesc();
        pSSysViewLogicParamBase.resetParamKey();
        pSSysViewLogicParamBase.resetParamState();
        pSSysViewLogicParamBase.resetParamSubKey();
        pSSysViewLogicParamBase.resetParamType();
        pSSysViewLogicParamBase.resetParamValue();
        pSSysViewLogicParamBase.resetParamValue10();
        pSSysViewLogicParamBase.resetParamValue2();
        pSSysViewLogicParamBase.resetParamValue3();
        pSSysViewLogicParamBase.resetParamValue4();
        pSSysViewLogicParamBase.resetParamValue5();
        pSSysViewLogicParamBase.resetParamValue6();
        pSSysViewLogicParamBase.resetParamValue7();
        pSSysViewLogicParamBase.resetParamValue8();
        pSSysViewLogicParamBase.resetParamValue9();
        pSSysViewLogicParamBase.resetPSSysViewLogicId();
        pSSysViewLogicParamBase.resetPSSysViewLogicName();
        pSSysViewLogicParamBase.resetPSSysViewLogicParamId();
        pSSysViewLogicParamBase.resetPSSysViewLogicParamName();
        pSSysViewLogicParamBase.resetRefObjId();
        pSSysViewLogicParamBase.resetRefObjName();
        pSSysViewLogicParamBase.resetRefObjType();
        pSSysViewLogicParamBase.resetUpdateDate();
        pSSysViewLogicParamBase.resetUpdateMan();
        pSSysViewLogicParamBase.resetUserCat();
        pSSysViewLogicParamBase.resetUserTag();
        pSSysViewLogicParamBase.resetUserTag2();
        pSSysViewLogicParamBase.resetUserTag3();
        pSSysViewLogicParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isParamCatDirty()) {
            hashMap.put(FIELD_PARAMCAT, this.getParamCat());
        }
        if (!bl || this.isParamDescDirty()) {
            hashMap.put(FIELD_PARAMDESC, this.getParamDesc());
        }
        if (!bl || this.isParamKeyDirty()) {
            hashMap.put(FIELD_PARAMKEY, this.getParamKey());
        }
        if (!bl || this.isParamStateDirty()) {
            hashMap.put(FIELD_PARAMSTATE, this.getParamState());
        }
        if (!bl || this.isParamSubKeyDirty()) {
            hashMap.put(FIELD_PARAMSUBKEY, this.getParamSubKey());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isParamValueDirty()) {
            hashMap.put(FIELD_PARAMVALUE, this.getParamValue());
        }
        if (!bl || this.isParamValue10Dirty()) {
            hashMap.put(FIELD_PARAMVALUE10, this.getParamValue10());
        }
        if (!bl || this.isParamValue2Dirty()) {
            hashMap.put(FIELD_PARAMVALUE2, this.getParamValue2());
        }
        if (!bl || this.isParamValue3Dirty()) {
            hashMap.put(FIELD_PARAMVALUE3, this.getParamValue3());
        }
        if (!bl || this.isParamValue4Dirty()) {
            hashMap.put(FIELD_PARAMVALUE4, this.getParamValue4());
        }
        if (!bl || this.isParamValue5Dirty()) {
            hashMap.put(FIELD_PARAMVALUE5, this.getParamValue5());
        }
        if (!bl || this.isParamValue6Dirty()) {
            hashMap.put(FIELD_PARAMVALUE6, this.getParamValue6());
        }
        if (!bl || this.isParamValue7Dirty()) {
            hashMap.put(FIELD_PARAMVALUE7, this.getParamValue7());
        }
        if (!bl || this.isParamValue8Dirty()) {
            hashMap.put(FIELD_PARAMVALUE8, this.getParamValue8());
        }
        if (!bl || this.isParamValue9Dirty()) {
            hashMap.put(FIELD_PARAMVALUE9, this.getParamValue9());
        }
        if (!bl || this.isPSSysViewLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICID, this.getPSSysViewLogicId());
        }
        if (!bl || this.isPSSysViewLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICNAME, this.getPSSysViewLogicName());
        }
        if (!bl || this.isPSSysViewLogicParamIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICPARAMID, this.getPSSysViewLogicParamId());
        }
        if (!bl || this.isPSSysViewLogicParamNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICPARAMNAME, this.getPSSysViewLogicParamName());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
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
        return PSSysViewLogicParamBase.get(this, n);
    }

    private static Object get(PSSysViewLogicParamBase pSSysViewLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicParamBase.getCreateDate();
            }
            case 1: {
                return pSSysViewLogicParamBase.getCreateMan();
            }
            case 2: {
                return pSSysViewLogicParamBase.getMemo();
            }
            case 3: {
                return pSSysViewLogicParamBase.getOrderValue();
            }
            case 4: {
                return pSSysViewLogicParamBase.getParamCat();
            }
            case 5: {
                return pSSysViewLogicParamBase.getParamDesc();
            }
            case 6: {
                return pSSysViewLogicParamBase.getParamKey();
            }
            case 7: {
                return pSSysViewLogicParamBase.getParamState();
            }
            case 8: {
                return pSSysViewLogicParamBase.getParamSubKey();
            }
            case 9: {
                return pSSysViewLogicParamBase.getParamType();
            }
            case 10: {
                return pSSysViewLogicParamBase.getParamValue();
            }
            case 11: {
                return pSSysViewLogicParamBase.getParamValue10();
            }
            case 12: {
                return pSSysViewLogicParamBase.getParamValue2();
            }
            case 13: {
                return pSSysViewLogicParamBase.getParamValue3();
            }
            case 14: {
                return pSSysViewLogicParamBase.getParamValue4();
            }
            case 15: {
                return pSSysViewLogicParamBase.getParamValue5();
            }
            case 16: {
                return pSSysViewLogicParamBase.getParamValue6();
            }
            case 17: {
                return pSSysViewLogicParamBase.getParamValue7();
            }
            case 18: {
                return pSSysViewLogicParamBase.getParamValue8();
            }
            case 19: {
                return pSSysViewLogicParamBase.getParamValue9();
            }
            case 20: {
                return pSSysViewLogicParamBase.getPSSysViewLogicId();
            }
            case 21: {
                return pSSysViewLogicParamBase.getPSSysViewLogicName();
            }
            case 22: {
                return pSSysViewLogicParamBase.getPSSysViewLogicParamId();
            }
            case 23: {
                return pSSysViewLogicParamBase.getPSSysViewLogicParamName();
            }
            case 24: {
                return pSSysViewLogicParamBase.getRefObjId();
            }
            case 25: {
                return pSSysViewLogicParamBase.getRefObjName();
            }
            case 26: {
                return pSSysViewLogicParamBase.getRefObjType();
            }
            case 27: {
                return pSSysViewLogicParamBase.getUpdateDate();
            }
            case 28: {
                return pSSysViewLogicParamBase.getUpdateMan();
            }
            case 29: {
                return pSSysViewLogicParamBase.getUserCat();
            }
            case 30: {
                return pSSysViewLogicParamBase.getUserTag();
            }
            case 31: {
                return pSSysViewLogicParamBase.getUserTag2();
            }
            case 32: {
                return pSSysViewLogicParamBase.getUserTag3();
            }
            case 33: {
                return pSSysViewLogicParamBase.getUserTag4();
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
        PSSysViewLogicParamBase.set(this, n, object);
    }

    private static void set(PSSysViewLogicParamBase pSSysViewLogicParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewLogicParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewLogicParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewLogicParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewLogicParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewLogicParamBase.setParamCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewLogicParamBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewLogicParamBase.setParamKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewLogicParamBase.setParamState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewLogicParamBase.setParamSubKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewLogicParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewLogicParamBase.setParamValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewLogicParamBase.setParamValue10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewLogicParamBase.setParamValue2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewLogicParamBase.setParamValue3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewLogicParamBase.setParamValue4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewLogicParamBase.setParamValue5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewLogicParamBase.setParamValue6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewLogicParamBase.setParamValue7(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewLogicParamBase.setParamValue8(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewLogicParamBase.setParamValue9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewLogicParamBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewLogicParamBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewLogicParamBase.setPSSysViewLogicParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewLogicParamBase.setPSSysViewLogicParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewLogicParamBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewLogicParamBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewLogicParamBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewLogicParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewLogicParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysViewLogicParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysViewLogicParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysViewLogicParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysViewLogicParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysViewLogicParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysViewLogicParamBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewLogicParamBase pSSysViewLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysViewLogicParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysViewLogicParamBase.getMemo() == null;
            }
            case 3: {
                return pSSysViewLogicParamBase.getOrderValue() == null;
            }
            case 4: {
                return pSSysViewLogicParamBase.getParamCat() == null;
            }
            case 5: {
                return pSSysViewLogicParamBase.getParamDesc() == null;
            }
            case 6: {
                return pSSysViewLogicParamBase.getParamKey() == null;
            }
            case 7: {
                return pSSysViewLogicParamBase.getParamState() == null;
            }
            case 8: {
                return pSSysViewLogicParamBase.getParamSubKey() == null;
            }
            case 9: {
                return pSSysViewLogicParamBase.getParamType() == null;
            }
            case 10: {
                return pSSysViewLogicParamBase.getParamValue() == null;
            }
            case 11: {
                return pSSysViewLogicParamBase.getParamValue10() == null;
            }
            case 12: {
                return pSSysViewLogicParamBase.getParamValue2() == null;
            }
            case 13: {
                return pSSysViewLogicParamBase.getParamValue3() == null;
            }
            case 14: {
                return pSSysViewLogicParamBase.getParamValue4() == null;
            }
            case 15: {
                return pSSysViewLogicParamBase.getParamValue5() == null;
            }
            case 16: {
                return pSSysViewLogicParamBase.getParamValue6() == null;
            }
            case 17: {
                return pSSysViewLogicParamBase.getParamValue7() == null;
            }
            case 18: {
                return pSSysViewLogicParamBase.getParamValue8() == null;
            }
            case 19: {
                return pSSysViewLogicParamBase.getParamValue9() == null;
            }
            case 20: {
                return pSSysViewLogicParamBase.getPSSysViewLogicId() == null;
            }
            case 21: {
                return pSSysViewLogicParamBase.getPSSysViewLogicName() == null;
            }
            case 22: {
                return pSSysViewLogicParamBase.getPSSysViewLogicParamId() == null;
            }
            case 23: {
                return pSSysViewLogicParamBase.getPSSysViewLogicParamName() == null;
            }
            case 24: {
                return pSSysViewLogicParamBase.getRefObjId() == null;
            }
            case 25: {
                return pSSysViewLogicParamBase.getRefObjName() == null;
            }
            case 26: {
                return pSSysViewLogicParamBase.getRefObjType() == null;
            }
            case 27: {
                return pSSysViewLogicParamBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSysViewLogicParamBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSysViewLogicParamBase.getUserCat() == null;
            }
            case 30: {
                return pSSysViewLogicParamBase.getUserTag() == null;
            }
            case 31: {
                return pSSysViewLogicParamBase.getUserTag2() == null;
            }
            case 32: {
                return pSSysViewLogicParamBase.getUserTag3() == null;
            }
            case 33: {
                return pSSysViewLogicParamBase.getUserTag4() == null;
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
        return PSSysViewLogicParamBase.contains(this, n);
    }

    private static boolean contains(PSSysViewLogicParamBase pSSysViewLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysViewLogicParamBase.isCreateManDirty();
            }
            case 2: {
                return pSSysViewLogicParamBase.isMemoDirty();
            }
            case 3: {
                return pSSysViewLogicParamBase.isOrderValueDirty();
            }
            case 4: {
                return pSSysViewLogicParamBase.isParamCatDirty();
            }
            case 5: {
                return pSSysViewLogicParamBase.isParamDescDirty();
            }
            case 6: {
                return pSSysViewLogicParamBase.isParamKeyDirty();
            }
            case 7: {
                return pSSysViewLogicParamBase.isParamStateDirty();
            }
            case 8: {
                return pSSysViewLogicParamBase.isParamSubKeyDirty();
            }
            case 9: {
                return pSSysViewLogicParamBase.isParamTypeDirty();
            }
            case 10: {
                return pSSysViewLogicParamBase.isParamValueDirty();
            }
            case 11: {
                return pSSysViewLogicParamBase.isParamValue10Dirty();
            }
            case 12: {
                return pSSysViewLogicParamBase.isParamValue2Dirty();
            }
            case 13: {
                return pSSysViewLogicParamBase.isParamValue3Dirty();
            }
            case 14: {
                return pSSysViewLogicParamBase.isParamValue4Dirty();
            }
            case 15: {
                return pSSysViewLogicParamBase.isParamValue5Dirty();
            }
            case 16: {
                return pSSysViewLogicParamBase.isParamValue6Dirty();
            }
            case 17: {
                return pSSysViewLogicParamBase.isParamValue7Dirty();
            }
            case 18: {
                return pSSysViewLogicParamBase.isParamValue8Dirty();
            }
            case 19: {
                return pSSysViewLogicParamBase.isParamValue9Dirty();
            }
            case 20: {
                return pSSysViewLogicParamBase.isPSSysViewLogicIdDirty();
            }
            case 21: {
                return pSSysViewLogicParamBase.isPSSysViewLogicNameDirty();
            }
            case 22: {
                return pSSysViewLogicParamBase.isPSSysViewLogicParamIdDirty();
            }
            case 23: {
                return pSSysViewLogicParamBase.isPSSysViewLogicParamNameDirty();
            }
            case 24: {
                return pSSysViewLogicParamBase.isRefObjIdDirty();
            }
            case 25: {
                return pSSysViewLogicParamBase.isRefObjNameDirty();
            }
            case 26: {
                return pSSysViewLogicParamBase.isRefObjTypeDirty();
            }
            case 27: {
                return pSSysViewLogicParamBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSysViewLogicParamBase.isUpdateManDirty();
            }
            case 29: {
                return pSSysViewLogicParamBase.isUserCatDirty();
            }
            case 30: {
                return pSSysViewLogicParamBase.isUserTagDirty();
            }
            case 31: {
                return pSSysViewLogicParamBase.isUserTag2Dirty();
            }
            case 32: {
                return pSSysViewLogicParamBase.isUserTag3Dirty();
            }
            case 33: {
                return pSSysViewLogicParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewLogicParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewLogicParamBase pSSysViewLogicParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewLogicParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramcat", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamCat()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramkey", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamKey()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramstate", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamState()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamSubKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramsubkey", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamSubKey()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue10", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue10()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue2", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue2()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue3", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue3()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue4", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue4()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue5", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue5()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue6", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue6()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue7", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue7()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue8", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue8()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue9", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getParamValue9()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicparamid", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getPSSysViewLogicParamId()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicparamname", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getPSSysViewLogicParamName()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysViewLogicParamBase.getJSONValue((Object)pSSysViewLogicParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewLogicParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewLogicParamBase pSSysViewLogicParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewLogicParamBase.getCreateDate() != null) {
            object = pSSysViewLogicParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getCreateMan() != null) {
            object = pSSysViewLogicParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getMemo() != null) {
            object = pSSysViewLogicParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getOrderValue() != null) {
            object = pSSysViewLogicParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamCat() != null) {
            object = pSSysViewLogicParamBase.getParamCat();
            xmlNode.setAttribute(FIELD_PARAMCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamDesc() != null) {
            object = pSSysViewLogicParamBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamKey() != null) {
            object = pSSysViewLogicParamBase.getParamKey();
            xmlNode.setAttribute(FIELD_PARAMKEY, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamState() != null) {
            object = pSSysViewLogicParamBase.getParamState();
            xmlNode.setAttribute(FIELD_PARAMSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamSubKey() != null) {
            object = pSSysViewLogicParamBase.getParamSubKey();
            xmlNode.setAttribute(FIELD_PARAMSUBKEY, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamType() != null) {
            object = pSSysViewLogicParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue() != null) {
            object = pSSysViewLogicParamBase.getParamValue();
            xmlNode.setAttribute(FIELD_PARAMVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue10() != null) {
            object = pSSysViewLogicParamBase.getParamValue10();
            xmlNode.setAttribute(FIELD_PARAMVALUE10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamValue2() != null) {
            object = pSSysViewLogicParamBase.getParamValue2();
            xmlNode.setAttribute(FIELD_PARAMVALUE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue3() != null) {
            object = pSSysViewLogicParamBase.getParamValue3();
            xmlNode.setAttribute(FIELD_PARAMVALUE3, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue4() != null) {
            object = pSSysViewLogicParamBase.getParamValue4();
            xmlNode.setAttribute(FIELD_PARAMVALUE4, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getParamValue5() != null) {
            object = pSSysViewLogicParamBase.getParamValue5();
            xmlNode.setAttribute(FIELD_PARAMVALUE5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamValue6() != null) {
            object = pSSysViewLogicParamBase.getParamValue6();
            xmlNode.setAttribute(FIELD_PARAMVALUE6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamValue7() != null) {
            object = pSSysViewLogicParamBase.getParamValue7();
            xmlNode.setAttribute(FIELD_PARAMVALUE7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamValue8() != null) {
            object = pSSysViewLogicParamBase.getParamValue8();
            xmlNode.setAttribute(FIELD_PARAMVALUE8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getParamValue9() != null) {
            object = pSSysViewLogicParamBase.getParamValue9();
            xmlNode.setAttribute(FIELD_PARAMVALUE9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicId() != null) {
            object = pSSysViewLogicParamBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicName() != null) {
            object = pSSysViewLogicParamBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamId() != null) {
            object = pSSysViewLogicParamBase.getPSSysViewLogicParamId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamName() != null) {
            object = pSSysViewLogicParamBase.getPSSysViewLogicParamName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjId() != null) {
            object = pSSysViewLogicParamBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjName() != null) {
            object = pSSysViewLogicParamBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getRefObjType() != null) {
            object = pSSysViewLogicParamBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUpdateDate() != null) {
            object = pSSysViewLogicParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewLogicParamBase.getUpdateMan() != null) {
            object = pSSysViewLogicParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUserCat() != null) {
            object = pSSysViewLogicParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag() != null) {
            object = pSSysViewLogicParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag2() != null) {
            object = pSSysViewLogicParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag3() != null) {
            object = pSSysViewLogicParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicParamBase.getUserTag4() != null) {
            object = pSSysViewLogicParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewLogicParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewLogicParamBase pSSysViewLogicParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewLogicParamBase.isCreateDateDirty() && (bl || pSSysViewLogicParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewLogicParamBase.getCreateDate());
        }
        if (pSSysViewLogicParamBase.isCreateManDirty() && (bl || pSSysViewLogicParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewLogicParamBase.getCreateMan());
        }
        if (pSSysViewLogicParamBase.isMemoDirty() && (bl || pSSysViewLogicParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewLogicParamBase.getMemo());
        }
        if (pSSysViewLogicParamBase.isOrderValueDirty() && (bl || pSSysViewLogicParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysViewLogicParamBase.getOrderValue());
        }
        if (pSSysViewLogicParamBase.isParamCatDirty() && (bl || pSSysViewLogicParamBase.getParamCat() != null)) {
            iDataObject.set(FIELD_PARAMCAT, (Object)pSSysViewLogicParamBase.getParamCat());
        }
        if (pSSysViewLogicParamBase.isParamDescDirty() && (bl || pSSysViewLogicParamBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSSysViewLogicParamBase.getParamDesc());
        }
        if (pSSysViewLogicParamBase.isParamKeyDirty() && (bl || pSSysViewLogicParamBase.getParamKey() != null)) {
            iDataObject.set(FIELD_PARAMKEY, (Object)pSSysViewLogicParamBase.getParamKey());
        }
        if (pSSysViewLogicParamBase.isParamStateDirty() && (bl || pSSysViewLogicParamBase.getParamState() != null)) {
            iDataObject.set(FIELD_PARAMSTATE, (Object)pSSysViewLogicParamBase.getParamState());
        }
        if (pSSysViewLogicParamBase.isParamSubKeyDirty() && (bl || pSSysViewLogicParamBase.getParamSubKey() != null)) {
            iDataObject.set(FIELD_PARAMSUBKEY, (Object)pSSysViewLogicParamBase.getParamSubKey());
        }
        if (pSSysViewLogicParamBase.isParamTypeDirty() && (bl || pSSysViewLogicParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSSysViewLogicParamBase.getParamType());
        }
        if (pSSysViewLogicParamBase.isParamValueDirty() && (bl || pSSysViewLogicParamBase.getParamValue() != null)) {
            iDataObject.set(FIELD_PARAMVALUE, (Object)pSSysViewLogicParamBase.getParamValue());
        }
        if (pSSysViewLogicParamBase.isParamValue10Dirty() && (bl || pSSysViewLogicParamBase.getParamValue10() != null)) {
            iDataObject.set(FIELD_PARAMVALUE10, (Object)pSSysViewLogicParamBase.getParamValue10());
        }
        if (pSSysViewLogicParamBase.isParamValue2Dirty() && (bl || pSSysViewLogicParamBase.getParamValue2() != null)) {
            iDataObject.set(FIELD_PARAMVALUE2, (Object)pSSysViewLogicParamBase.getParamValue2());
        }
        if (pSSysViewLogicParamBase.isParamValue3Dirty() && (bl || pSSysViewLogicParamBase.getParamValue3() != null)) {
            iDataObject.set(FIELD_PARAMVALUE3, (Object)pSSysViewLogicParamBase.getParamValue3());
        }
        if (pSSysViewLogicParamBase.isParamValue4Dirty() && (bl || pSSysViewLogicParamBase.getParamValue4() != null)) {
            iDataObject.set(FIELD_PARAMVALUE4, (Object)pSSysViewLogicParamBase.getParamValue4());
        }
        if (pSSysViewLogicParamBase.isParamValue5Dirty() && (bl || pSSysViewLogicParamBase.getParamValue5() != null)) {
            iDataObject.set(FIELD_PARAMVALUE5, (Object)pSSysViewLogicParamBase.getParamValue5());
        }
        if (pSSysViewLogicParamBase.isParamValue6Dirty() && (bl || pSSysViewLogicParamBase.getParamValue6() != null)) {
            iDataObject.set(FIELD_PARAMVALUE6, (Object)pSSysViewLogicParamBase.getParamValue6());
        }
        if (pSSysViewLogicParamBase.isParamValue7Dirty() && (bl || pSSysViewLogicParamBase.getParamValue7() != null)) {
            iDataObject.set(FIELD_PARAMVALUE7, (Object)pSSysViewLogicParamBase.getParamValue7());
        }
        if (pSSysViewLogicParamBase.isParamValue8Dirty() && (bl || pSSysViewLogicParamBase.getParamValue8() != null)) {
            iDataObject.set(FIELD_PARAMVALUE8, (Object)pSSysViewLogicParamBase.getParamValue8());
        }
        if (pSSysViewLogicParamBase.isParamValue9Dirty() && (bl || pSSysViewLogicParamBase.getParamValue9() != null)) {
            iDataObject.set(FIELD_PARAMVALUE9, (Object)pSSysViewLogicParamBase.getParamValue9());
        }
        if (pSSysViewLogicParamBase.isPSSysViewLogicIdDirty() && (bl || pSSysViewLogicParamBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysViewLogicParamBase.getPSSysViewLogicId());
        }
        if (pSSysViewLogicParamBase.isPSSysViewLogicNameDirty() && (bl || pSSysViewLogicParamBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysViewLogicParamBase.getPSSysViewLogicName());
        }
        if (pSSysViewLogicParamBase.isPSSysViewLogicParamIdDirty() && (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICPARAMID, (Object)pSSysViewLogicParamBase.getPSSysViewLogicParamId());
        }
        if (pSSysViewLogicParamBase.isPSSysViewLogicParamNameDirty() && (bl || pSSysViewLogicParamBase.getPSSysViewLogicParamName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICPARAMNAME, (Object)pSSysViewLogicParamBase.getPSSysViewLogicParamName());
        }
        if (pSSysViewLogicParamBase.isRefObjIdDirty() && (bl || pSSysViewLogicParamBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSSysViewLogicParamBase.getRefObjId());
        }
        if (pSSysViewLogicParamBase.isRefObjNameDirty() && (bl || pSSysViewLogicParamBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSSysViewLogicParamBase.getRefObjName());
        }
        if (pSSysViewLogicParamBase.isRefObjTypeDirty() && (bl || pSSysViewLogicParamBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSSysViewLogicParamBase.getRefObjType());
        }
        if (pSSysViewLogicParamBase.isUpdateDateDirty() && (bl || pSSysViewLogicParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewLogicParamBase.getUpdateDate());
        }
        if (pSSysViewLogicParamBase.isUpdateManDirty() && (bl || pSSysViewLogicParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewLogicParamBase.getUpdateMan());
        }
        if (pSSysViewLogicParamBase.isUserCatDirty() && (bl || pSSysViewLogicParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysViewLogicParamBase.getUserCat());
        }
        if (pSSysViewLogicParamBase.isUserTagDirty() && (bl || pSSysViewLogicParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysViewLogicParamBase.getUserTag());
        }
        if (pSSysViewLogicParamBase.isUserTag2Dirty() && (bl || pSSysViewLogicParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysViewLogicParamBase.getUserTag2());
        }
        if (pSSysViewLogicParamBase.isUserTag3Dirty() && (bl || pSSysViewLogicParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysViewLogicParamBase.getUserTag3());
        }
        if (pSSysViewLogicParamBase.isUserTag4Dirty() && (bl || pSSysViewLogicParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysViewLogicParamBase.getUserTag4());
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
        return PSSysViewLogicParamBase.remove(this, n);
    }

    private static boolean remove(PSSysViewLogicParamBase pSSysViewLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewLogicParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysViewLogicParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysViewLogicParamBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysViewLogicParamBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSSysViewLogicParamBase.resetParamCat();
                return true;
            }
            case 5: {
                pSSysViewLogicParamBase.resetParamDesc();
                return true;
            }
            case 6: {
                pSSysViewLogicParamBase.resetParamKey();
                return true;
            }
            case 7: {
                pSSysViewLogicParamBase.resetParamState();
                return true;
            }
            case 8: {
                pSSysViewLogicParamBase.resetParamSubKey();
                return true;
            }
            case 9: {
                pSSysViewLogicParamBase.resetParamType();
                return true;
            }
            case 10: {
                pSSysViewLogicParamBase.resetParamValue();
                return true;
            }
            case 11: {
                pSSysViewLogicParamBase.resetParamValue10();
                return true;
            }
            case 12: {
                pSSysViewLogicParamBase.resetParamValue2();
                return true;
            }
            case 13: {
                pSSysViewLogicParamBase.resetParamValue3();
                return true;
            }
            case 14: {
                pSSysViewLogicParamBase.resetParamValue4();
                return true;
            }
            case 15: {
                pSSysViewLogicParamBase.resetParamValue5();
                return true;
            }
            case 16: {
                pSSysViewLogicParamBase.resetParamValue6();
                return true;
            }
            case 17: {
                pSSysViewLogicParamBase.resetParamValue7();
                return true;
            }
            case 18: {
                pSSysViewLogicParamBase.resetParamValue8();
                return true;
            }
            case 19: {
                pSSysViewLogicParamBase.resetParamValue9();
                return true;
            }
            case 20: {
                pSSysViewLogicParamBase.resetPSSysViewLogicId();
                return true;
            }
            case 21: {
                pSSysViewLogicParamBase.resetPSSysViewLogicName();
                return true;
            }
            case 22: {
                pSSysViewLogicParamBase.resetPSSysViewLogicParamId();
                return true;
            }
            case 23: {
                pSSysViewLogicParamBase.resetPSSysViewLogicParamName();
                return true;
            }
            case 24: {
                pSSysViewLogicParamBase.resetRefObjId();
                return true;
            }
            case 25: {
                pSSysViewLogicParamBase.resetRefObjName();
                return true;
            }
            case 26: {
                pSSysViewLogicParamBase.resetRefObjType();
                return true;
            }
            case 27: {
                pSSysViewLogicParamBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSysViewLogicParamBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSysViewLogicParamBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysViewLogicParamBase.resetUserTag();
                return true;
            }
            case 31: {
                pSSysViewLogicParamBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSSysViewLogicParamBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSSysViewLogicParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewLogic getPSSysViewLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogic();
        }
        if (this.getPSSysViewLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewLogicLock;
        synchronized (n) {
            if (this.pssysviewlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewLogicId(), (Object)this.pssysviewlogic.getPSSysViewLogicId()) != 0L) {
                this.pssysviewlogic = null;
            }
            if (this.pssysviewlogic == null) {
                PSSysViewLogic pSSysViewLogic = new PSSysViewLogic();
                pSSysViewLogic.setPSSysViewLogicId(this.getPSSysViewLogicId());
                PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewLogicService.autoGet(pSSysViewLogic);
                this.pssysviewlogic = pSSysViewLogic;
            }
            return this.pssysviewlogic;
        }
    }

    private PSSysViewLogicParamBase getProxyEntity() {
        return this.proxyPSSysViewLogicParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewLogicParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewLogicParamBase) {
            this.proxyPSSysViewLogicParamBase = (PSSysViewLogicParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PARAMCAT, 4);
        fieldIndexMap.put(FIELD_PARAMDESC, 5);
        fieldIndexMap.put(FIELD_PARAMKEY, 6);
        fieldIndexMap.put(FIELD_PARAMSTATE, 7);
        fieldIndexMap.put(FIELD_PARAMSUBKEY, 8);
        fieldIndexMap.put(FIELD_PARAMTYPE, 9);
        fieldIndexMap.put(FIELD_PARAMVALUE, 10);
        fieldIndexMap.put(FIELD_PARAMVALUE10, 11);
        fieldIndexMap.put(FIELD_PARAMVALUE2, 12);
        fieldIndexMap.put(FIELD_PARAMVALUE3, 13);
        fieldIndexMap.put(FIELD_PARAMVALUE4, 14);
        fieldIndexMap.put(FIELD_PARAMVALUE5, 15);
        fieldIndexMap.put(FIELD_PARAMVALUE6, 16);
        fieldIndexMap.put(FIELD_PARAMVALUE7, 17);
        fieldIndexMap.put(FIELD_PARAMVALUE8, 18);
        fieldIndexMap.put(FIELD_PARAMVALUE9, 19);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 20);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICPARAMID, 22);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICPARAMNAME, 23);
        fieldIndexMap.put(FIELD_REFOBJID, 24);
        fieldIndexMap.put(FIELD_REFOBJNAME, 25);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

