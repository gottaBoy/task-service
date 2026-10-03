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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMSPlatformFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMSPlatformFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCPARAM = "FUNCPARAM";
    public static final String FIELD_FUNCPARAM10 = "FUNCPARAM10";
    public static final String FIELD_FUNCPARAM2 = "FUNCPARAM2";
    public static final String FIELD_FUNCPARAM3 = "FUNCPARAM3";
    public static final String FIELD_FUNCPARAM4 = "FUNCPARAM4";
    public static final String FIELD_FUNCPARAM5 = "FUNCPARAM5";
    public static final String FIELD_FUNCPARAM6 = "FUNCPARAM6";
    public static final String FIELD_FUNCPARAM7 = "FUNCPARAM7";
    public static final String FIELD_FUNCPARAM8 = "FUNCPARAM8";
    public static final String FIELD_FUNCPARAM9 = "FUNCPARAM9";
    public static final String FIELD_FUNCPARAMS = "FUNCPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSFUNCTYPE = "MSFUNCTYPE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSMSPLATFORMFUNCID = "PSMSPLATFORMFUNCID";
    public static final String FIELD_PSMSPLATFORMFUNCNAME = "PSMSPLATFORMFUNCNAME";
    public static final String FIELD_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String FIELD_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
    public static final String FIELD_SERVICEURL = "SERVICEURL";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCPARAM = 2;
    private static final int INDEX_FUNCPARAM10 = 3;
    private static final int INDEX_FUNCPARAM2 = 4;
    private static final int INDEX_FUNCPARAM3 = 5;
    private static final int INDEX_FUNCPARAM4 = 6;
    private static final int INDEX_FUNCPARAM5 = 7;
    private static final int INDEX_FUNCPARAM6 = 8;
    private static final int INDEX_FUNCPARAM7 = 9;
    private static final int INDEX_FUNCPARAM8 = 10;
    private static final int INDEX_FUNCPARAM9 = 11;
    private static final int INDEX_FUNCPARAMS = 12;
    private static final int INDEX_IPADDR = 13;
    private static final int INDEX_IPADDR2 = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MSFUNCTYPE = 16;
    private static final int INDEX_PASSWD = 17;
    private static final int INDEX_PORT = 18;
    private static final int INDEX_PSMSPLATFORMFUNCID = 19;
    private static final int INDEX_PSMSPLATFORMFUNCNAME = 20;
    private static final int INDEX_PSMSPLATFORMID = 21;
    private static final int INDEX_PSMSPLATFORMNAME = 22;
    private static final int INDEX_SERVICEURL = 23;
    private static final int INDEX_SSHIPADDR = 24;
    private static final int INDEX_SSHPORT = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_UPLOADFILEMODE = 28;
    private static final int INDEX_UPLOADPATH = 29;
    private static final int INDEX_USERNAME = 30;
    private static final int INDEX_VALIDFLAG = 31;
    private static final int INDEX_WORKSHOPPATH = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMSPlatformFuncBase proxyPSMSPlatformFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcparamDirtyFlag = false;
    private boolean funcparam10DirtyFlag = false;
    private boolean funcparam2DirtyFlag = false;
    private boolean funcparam3DirtyFlag = false;
    private boolean funcparam4DirtyFlag = false;
    private boolean funcparam5DirtyFlag = false;
    private boolean funcparam6DirtyFlag = false;
    private boolean funcparam7DirtyFlag = false;
    private boolean funcparam8DirtyFlag = false;
    private boolean funcparam9DirtyFlag = false;
    private boolean funcparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msfunctypeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psmsplatformfuncidDirtyFlag = false;
    private boolean psmsplatformfuncnameDirtyFlag = false;
    private boolean psmsplatformidDirtyFlag = false;
    private boolean psmsplatformnameDirtyFlag = false;
    private boolean serviceurlDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workshoppathDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcparam")
    private String funcparam;
    @Column(name="funcparam10")
    private String funcparam10;
    @Column(name="funcparam2")
    private String funcparam2;
    @Column(name="funcparam3")
    private String funcparam3;
    @Column(name="funcparam4")
    private String funcparam4;
    @Column(name="funcparam5")
    private Integer funcparam5;
    @Column(name="funcparam6")
    private Integer funcparam6;
    @Column(name="funcparam7")
    private Integer funcparam7;
    @Column(name="funcparam8")
    private Integer funcparam8;
    @Column(name="funcparam9")
    private String funcparam9;
    @Column(name="funcparams")
    private String funcparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="msfunctype")
    private String msfunctype;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psmsplatformfuncid")
    private String psmsplatformfuncid;
    @Column(name="psmsplatformfuncname")
    private String psmsplatformfuncname;
    @Column(name="psmsplatformid")
    private String psmsplatformid;
    @Column(name="psmsplatformname")
    private String psmsplatformname;
    @Column(name="serviceurl")
    private String serviceurl;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSMSPlatformLock = new Integer(1);
    private PSMSPlatform psmsplatform = null;

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

    public void setFuncParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam = string;
        this.funcparamDirtyFlag = true;
    }

    public String getFuncParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam();
        }
        return this.funcparam;
    }

    public boolean isFuncParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParamDirty();
        }
        return this.funcparamDirtyFlag;
    }

    public void resetFuncParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam();
            return;
        }
        this.funcparamDirtyFlag = false;
        this.funcparam = null;
    }

    public void setFuncParam10(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam10(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam10 = string;
        this.funcparam10DirtyFlag = true;
    }

    public String getFuncParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam10();
        }
        return this.funcparam10;
    }

    public boolean isFuncParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam10Dirty();
        }
        return this.funcparam10DirtyFlag;
    }

    public void resetFuncParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam10();
            return;
        }
        this.funcparam10DirtyFlag = false;
        this.funcparam10 = null;
    }

    public void setFuncParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam2 = string;
        this.funcparam2DirtyFlag = true;
    }

    public String getFuncParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam2();
        }
        return this.funcparam2;
    }

    public boolean isFuncParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam2Dirty();
        }
        return this.funcparam2DirtyFlag;
    }

    public void resetFuncParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam2();
            return;
        }
        this.funcparam2DirtyFlag = false;
        this.funcparam2 = null;
    }

    public void setFuncParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam3 = string;
        this.funcparam3DirtyFlag = true;
    }

    public String getFuncParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam3();
        }
        return this.funcparam3;
    }

    public boolean isFuncParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam3Dirty();
        }
        return this.funcparam3DirtyFlag;
    }

    public void resetFuncParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam3();
            return;
        }
        this.funcparam3DirtyFlag = false;
        this.funcparam3 = null;
    }

    public void setFuncParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam4 = string;
        this.funcparam4DirtyFlag = true;
    }

    public String getFuncParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam4();
        }
        return this.funcparam4;
    }

    public boolean isFuncParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam4Dirty();
        }
        return this.funcparam4DirtyFlag;
    }

    public void resetFuncParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam4();
            return;
        }
        this.funcparam4DirtyFlag = false;
        this.funcparam4 = null;
    }

    public void setFuncParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam5(n);
            return;
        }
        this.funcparam5 = n;
        this.funcparam5DirtyFlag = true;
    }

    public Integer getFuncParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam5();
        }
        return this.funcparam5;
    }

    public boolean isFuncParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam5Dirty();
        }
        return this.funcparam5DirtyFlag;
    }

    public void resetFuncParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam5();
            return;
        }
        this.funcparam5DirtyFlag = false;
        this.funcparam5 = null;
    }

    public void setFuncParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam6(n);
            return;
        }
        this.funcparam6 = n;
        this.funcparam6DirtyFlag = true;
    }

    public Integer getFuncParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam6();
        }
        return this.funcparam6;
    }

    public boolean isFuncParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam6Dirty();
        }
        return this.funcparam6DirtyFlag;
    }

    public void resetFuncParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam6();
            return;
        }
        this.funcparam6DirtyFlag = false;
        this.funcparam6 = null;
    }

    public void setFuncParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam7(n);
            return;
        }
        this.funcparam7 = n;
        this.funcparam7DirtyFlag = true;
    }

    public Integer getFuncParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam7();
        }
        return this.funcparam7;
    }

    public boolean isFuncParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam7Dirty();
        }
        return this.funcparam7DirtyFlag;
    }

    public void resetFuncParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam7();
            return;
        }
        this.funcparam7DirtyFlag = false;
        this.funcparam7 = null;
    }

    public void setFuncParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam8(n);
            return;
        }
        this.funcparam8 = n;
        this.funcparam8DirtyFlag = true;
    }

    public Integer getFuncParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam8();
        }
        return this.funcparam8;
    }

    public boolean isFuncParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam8Dirty();
        }
        return this.funcparam8DirtyFlag;
    }

    public void resetFuncParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam8();
            return;
        }
        this.funcparam8DirtyFlag = false;
        this.funcparam8 = null;
    }

    public void setFuncParam9(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParam9(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparam9 = string;
        this.funcparam9DirtyFlag = true;
    }

    public String getFuncParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParam9();
        }
        return this.funcparam9;
    }

    public boolean isFuncParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParam9Dirty();
        }
        return this.funcparam9DirtyFlag;
    }

    public void resetFuncParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParam9();
            return;
        }
        this.funcparam9DirtyFlag = false;
        this.funcparam9 = null;
    }

    public void setFuncParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcparams = string;
        this.funcparamsDirtyFlag = true;
    }

    public String getFuncParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncParams();
        }
        return this.funcparams;
    }

    public boolean isFuncParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncParamsDirty();
        }
        return this.funcparamsDirtyFlag;
    }

    public void resetFuncParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncParams();
            return;
        }
        this.funcparamsDirtyFlag = false;
        this.funcparams = null;
    }

    public void setIpAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIpAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr();
        }
        return this.ipaddr;
    }

    public boolean isIpAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIpAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
    }

    public void setIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
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

    public void setMSFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msfunctype = string;
        this.msfunctypeDirtyFlag = true;
    }

    public String getMSFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSFuncType();
        }
        return this.msfunctype;
    }

    public boolean isMSFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSFuncTypeDirty();
        }
        return this.msfunctypeDirtyFlag;
    }

    public void resetMSFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSFuncType();
            return;
        }
        this.msfunctypeDirtyFlag = false;
        this.msfunctype = null;
    }

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort(n);
            return;
        }
        this.port = n;
        this.portDirtyFlag = true;
    }

    public Integer getPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort();
        }
        return this.port;
    }

    public boolean isPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortDirty();
        }
        return this.portDirtyFlag;
    }

    public void resetPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort();
            return;
        }
        this.portDirtyFlag = false;
        this.port = null;
    }

    public void setPSMSPlatformFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformfuncid = string;
        this.psmsplatformfuncidDirtyFlag = true;
    }

    public String getPSMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformFuncId();
        }
        return this.psmsplatformfuncid;
    }

    public boolean isPSMSPlatformFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformFuncIdDirty();
        }
        return this.psmsplatformfuncidDirtyFlag;
    }

    public void resetPSMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformFuncId();
            return;
        }
        this.psmsplatformfuncidDirtyFlag = false;
        this.psmsplatformfuncid = null;
    }

    public void setPSMSPlatformFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformfuncname = string;
        this.psmsplatformfuncnameDirtyFlag = true;
    }

    public String getPSMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformFuncName();
        }
        return this.psmsplatformfuncname;
    }

    public boolean isPSMSPlatformFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformFuncNameDirty();
        }
        return this.psmsplatformfuncnameDirtyFlag;
    }

    public void resetPSMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformFuncName();
            return;
        }
        this.psmsplatformfuncnameDirtyFlag = false;
        this.psmsplatformfuncname = null;
    }

    public void setPSMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformid = string;
        this.psmsplatformidDirtyFlag = true;
    }

    public String getPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformId();
        }
        return this.psmsplatformid;
    }

    public boolean isPSMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformIdDirty();
        }
        return this.psmsplatformidDirtyFlag;
    }

    public void resetPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformId();
            return;
        }
        this.psmsplatformidDirtyFlag = false;
        this.psmsplatformid = null;
    }

    public void setPSMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformname = string;
        this.psmsplatformnameDirtyFlag = true;
    }

    public String getPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformName();
        }
        return this.psmsplatformname;
    }

    public boolean isPSMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNameDirty();
        }
        return this.psmsplatformnameDirtyFlag;
    }

    public void resetPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformName();
            return;
        }
        this.psmsplatformnameDirtyFlag = false;
        this.psmsplatformname = null;
    }

    public void setServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceurl = string;
        this.serviceurlDirtyFlag = true;
    }

    public String getServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceUrl();
        }
        return this.serviceurl;
    }

    public boolean isServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceUrlDirty();
        }
        return this.serviceurlDirtyFlag;
    }

    public void resetServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceUrl();
            return;
        }
        this.serviceurlDirtyFlag = false;
        this.serviceurl = null;
    }

    public void setSSHIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sshipaddr = string;
        this.sshipaddrDirtyFlag = true;
    }

    public String getSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHIPAddr();
        }
        return this.sshipaddr;
    }

    public boolean isSSHIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHIPAddrDirty();
        }
        return this.sshipaddrDirtyFlag;
    }

    public void resetSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHIPAddr();
            return;
        }
        this.sshipaddrDirtyFlag = false;
        this.sshipaddr = null;
    }

    public void setSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHPort(n);
            return;
        }
        this.sshport = n;
        this.sshportDirtyFlag = true;
    }

    public Integer getSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHPort();
        }
        return this.sshport;
    }

    public boolean isSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHPortDirty();
        }
        return this.sshportDirtyFlag;
    }

    public void resetSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHPort();
            return;
        }
        this.sshportDirtyFlag = false;
        this.sshport = null;
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

    public void setUploadFileMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadFileMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadfilemode = string;
        this.uploadfilemodeDirtyFlag = true;
    }

    public String getUploadFileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadFileMode();
        }
        return this.uploadfilemode;
    }

    public boolean isUploadFileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadFileModeDirty();
        }
        return this.uploadfilemodeDirtyFlag;
    }

    public void resetUploadFileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadFileMode();
            return;
        }
        this.uploadfilemodeDirtyFlag = false;
        this.uploadfilemode = null;
    }

    public void setUploadPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadpath = string;
        this.uploadpathDirtyFlag = true;
    }

    public String getUploadPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadPath();
        }
        return this.uploadpath;
    }

    public boolean isUploadPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadPathDirty();
        }
        return this.uploadpathDirtyFlag;
    }

    public void resetUploadPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadPath();
            return;
        }
        this.uploadpathDirtyFlag = false;
        this.uploadpath = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
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

    public void setWorkshopPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkshopPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workshoppath = string;
        this.workshoppathDirtyFlag = true;
    }

    public String getWorkshopPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkshopPath();
        }
        return this.workshoppath;
    }

    public boolean isWorkshopPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkshopPathDirty();
        }
        return this.workshoppathDirtyFlag;
    }

    public void resetWorkshopPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkshopPath();
            return;
        }
        this.workshoppathDirtyFlag = false;
        this.workshoppath = null;
    }

    protected void onReset() {
        PSMSPlatformFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMSPlatformFuncBase pSMSPlatformFuncBase) {
        pSMSPlatformFuncBase.resetCreateDate();
        pSMSPlatformFuncBase.resetCreateMan();
        pSMSPlatformFuncBase.resetFuncParam();
        pSMSPlatformFuncBase.resetFuncParam10();
        pSMSPlatformFuncBase.resetFuncParam2();
        pSMSPlatformFuncBase.resetFuncParam3();
        pSMSPlatformFuncBase.resetFuncParam4();
        pSMSPlatformFuncBase.resetFuncParam5();
        pSMSPlatformFuncBase.resetFuncParam6();
        pSMSPlatformFuncBase.resetFuncParam7();
        pSMSPlatformFuncBase.resetFuncParam8();
        pSMSPlatformFuncBase.resetFuncParam9();
        pSMSPlatformFuncBase.resetFuncParams();
        pSMSPlatformFuncBase.resetIpAddr();
        pSMSPlatformFuncBase.resetIpAddr2();
        pSMSPlatformFuncBase.resetMemo();
        pSMSPlatformFuncBase.resetMSFuncType();
        pSMSPlatformFuncBase.resetPasswd();
        pSMSPlatformFuncBase.resetPort();
        pSMSPlatformFuncBase.resetPSMSPlatformFuncId();
        pSMSPlatformFuncBase.resetPSMSPlatformFuncName();
        pSMSPlatformFuncBase.resetPSMSPlatformId();
        pSMSPlatformFuncBase.resetPSMSPlatformName();
        pSMSPlatformFuncBase.resetServiceUrl();
        pSMSPlatformFuncBase.resetSSHIPAddr();
        pSMSPlatformFuncBase.resetSSHPort();
        pSMSPlatformFuncBase.resetUpdateDate();
        pSMSPlatformFuncBase.resetUpdateMan();
        pSMSPlatformFuncBase.resetUploadFileMode();
        pSMSPlatformFuncBase.resetUploadPath();
        pSMSPlatformFuncBase.resetUserName();
        pSMSPlatformFuncBase.resetValidFlag();
        pSMSPlatformFuncBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFuncParamDirty()) {
            hashMap.put(FIELD_FUNCPARAM, this.getFuncParam());
        }
        if (!bl || this.isFuncParam10Dirty()) {
            hashMap.put(FIELD_FUNCPARAM10, this.getFuncParam10());
        }
        if (!bl || this.isFuncParam2Dirty()) {
            hashMap.put(FIELD_FUNCPARAM2, this.getFuncParam2());
        }
        if (!bl || this.isFuncParam3Dirty()) {
            hashMap.put(FIELD_FUNCPARAM3, this.getFuncParam3());
        }
        if (!bl || this.isFuncParam4Dirty()) {
            hashMap.put(FIELD_FUNCPARAM4, this.getFuncParam4());
        }
        if (!bl || this.isFuncParam5Dirty()) {
            hashMap.put(FIELD_FUNCPARAM5, this.getFuncParam5());
        }
        if (!bl || this.isFuncParam6Dirty()) {
            hashMap.put(FIELD_FUNCPARAM6, this.getFuncParam6());
        }
        if (!bl || this.isFuncParam7Dirty()) {
            hashMap.put(FIELD_FUNCPARAM7, this.getFuncParam7());
        }
        if (!bl || this.isFuncParam8Dirty()) {
            hashMap.put(FIELD_FUNCPARAM8, this.getFuncParam8());
        }
        if (!bl || this.isFuncParam9Dirty()) {
            hashMap.put(FIELD_FUNCPARAM9, this.getFuncParam9());
        }
        if (!bl || this.isFuncParamsDirty()) {
            hashMap.put(FIELD_FUNCPARAMS, this.getFuncParams());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMSFuncTypeDirty()) {
            hashMap.put(FIELD_MSFUNCTYPE, this.getMSFuncType());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSMSPlatformFuncIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMFUNCID, this.getPSMSPlatformFuncId());
        }
        if (!bl || this.isPSMSPlatformFuncNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMFUNCNAME, this.getPSMSPlatformFuncName());
        }
        if (!bl || this.isPSMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMID, this.getPSMSPlatformId());
        }
        if (!bl || this.isPSMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNAME, this.getPSMSPlatformName());
        }
        if (!bl || this.isServiceUrlDirty()) {
            hashMap.put(FIELD_SERVICEURL, this.getServiceUrl());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUploadPathDirty()) {
            hashMap.put(FIELD_UPLOADPATH, this.getUploadPath());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWorkshopPathDirty()) {
            hashMap.put(FIELD_WORKSHOPPATH, this.getWorkshopPath());
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
        return PSMSPlatformFuncBase.get(this, n);
    }

    private static Object get(PSMSPlatformFuncBase pSMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformFuncBase.getCreateDate();
            }
            case 1: {
                return pSMSPlatformFuncBase.getCreateMan();
            }
            case 2: {
                return pSMSPlatformFuncBase.getFuncParam();
            }
            case 3: {
                return pSMSPlatformFuncBase.getFuncParam10();
            }
            case 4: {
                return pSMSPlatformFuncBase.getFuncParam2();
            }
            case 5: {
                return pSMSPlatformFuncBase.getFuncParam3();
            }
            case 6: {
                return pSMSPlatformFuncBase.getFuncParam4();
            }
            case 7: {
                return pSMSPlatformFuncBase.getFuncParam5();
            }
            case 8: {
                return pSMSPlatformFuncBase.getFuncParam6();
            }
            case 9: {
                return pSMSPlatformFuncBase.getFuncParam7();
            }
            case 10: {
                return pSMSPlatformFuncBase.getFuncParam8();
            }
            case 11: {
                return pSMSPlatformFuncBase.getFuncParam9();
            }
            case 12: {
                return pSMSPlatformFuncBase.getFuncParams();
            }
            case 13: {
                return pSMSPlatformFuncBase.getIpAddr();
            }
            case 14: {
                return pSMSPlatformFuncBase.getIpAddr2();
            }
            case 15: {
                return pSMSPlatformFuncBase.getMemo();
            }
            case 16: {
                return pSMSPlatformFuncBase.getMSFuncType();
            }
            case 17: {
                return pSMSPlatformFuncBase.getPasswd();
            }
            case 18: {
                return pSMSPlatformFuncBase.getPort();
            }
            case 19: {
                return pSMSPlatformFuncBase.getPSMSPlatformFuncId();
            }
            case 20: {
                return pSMSPlatformFuncBase.getPSMSPlatformFuncName();
            }
            case 21: {
                return pSMSPlatformFuncBase.getPSMSPlatformId();
            }
            case 22: {
                return pSMSPlatformFuncBase.getPSMSPlatformName();
            }
            case 23: {
                return pSMSPlatformFuncBase.getServiceUrl();
            }
            case 24: {
                return pSMSPlatformFuncBase.getSSHIPAddr();
            }
            case 25: {
                return pSMSPlatformFuncBase.getSSHPort();
            }
            case 26: {
                return pSMSPlatformFuncBase.getUpdateDate();
            }
            case 27: {
                return pSMSPlatformFuncBase.getUpdateMan();
            }
            case 28: {
                return pSMSPlatformFuncBase.getUploadFileMode();
            }
            case 29: {
                return pSMSPlatformFuncBase.getUploadPath();
            }
            case 30: {
                return pSMSPlatformFuncBase.getUserName();
            }
            case 31: {
                return pSMSPlatformFuncBase.getValidFlag();
            }
            case 32: {
                return pSMSPlatformFuncBase.getWorkshopPath();
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
        PSMSPlatformFuncBase.set(this, n, object);
    }

    private static void set(PSMSPlatformFuncBase pSMSPlatformFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMSPlatformFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMSPlatformFuncBase.setFuncParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMSPlatformFuncBase.setFuncParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMSPlatformFuncBase.setFuncParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMSPlatformFuncBase.setFuncParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMSPlatformFuncBase.setFuncParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMSPlatformFuncBase.setFuncParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSMSPlatformFuncBase.setFuncParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSMSPlatformFuncBase.setFuncParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSMSPlatformFuncBase.setFuncParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSMSPlatformFuncBase.setFuncParam9(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMSPlatformFuncBase.setFuncParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMSPlatformFuncBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMSPlatformFuncBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMSPlatformFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSMSPlatformFuncBase.setMSFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMSPlatformFuncBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMSPlatformFuncBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSMSPlatformFuncBase.setPSMSPlatformFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMSPlatformFuncBase.setPSMSPlatformFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMSPlatformFuncBase.setPSMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSMSPlatformFuncBase.setPSMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSMSPlatformFuncBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSMSPlatformFuncBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMSPlatformFuncBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSMSPlatformFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSMSPlatformFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSMSPlatformFuncBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSMSPlatformFuncBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSMSPlatformFuncBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSMSPlatformFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSMSPlatformFuncBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSMSPlatformFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSMSPlatformFuncBase pSMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSMSPlatformFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSMSPlatformFuncBase.getFuncParam() == null;
            }
            case 3: {
                return pSMSPlatformFuncBase.getFuncParam10() == null;
            }
            case 4: {
                return pSMSPlatformFuncBase.getFuncParam2() == null;
            }
            case 5: {
                return pSMSPlatformFuncBase.getFuncParam3() == null;
            }
            case 6: {
                return pSMSPlatformFuncBase.getFuncParam4() == null;
            }
            case 7: {
                return pSMSPlatformFuncBase.getFuncParam5() == null;
            }
            case 8: {
                return pSMSPlatformFuncBase.getFuncParam6() == null;
            }
            case 9: {
                return pSMSPlatformFuncBase.getFuncParam7() == null;
            }
            case 10: {
                return pSMSPlatformFuncBase.getFuncParam8() == null;
            }
            case 11: {
                return pSMSPlatformFuncBase.getFuncParam9() == null;
            }
            case 12: {
                return pSMSPlatformFuncBase.getFuncParams() == null;
            }
            case 13: {
                return pSMSPlatformFuncBase.getIpAddr() == null;
            }
            case 14: {
                return pSMSPlatformFuncBase.getIpAddr2() == null;
            }
            case 15: {
                return pSMSPlatformFuncBase.getMemo() == null;
            }
            case 16: {
                return pSMSPlatformFuncBase.getMSFuncType() == null;
            }
            case 17: {
                return pSMSPlatformFuncBase.getPasswd() == null;
            }
            case 18: {
                return pSMSPlatformFuncBase.getPort() == null;
            }
            case 19: {
                return pSMSPlatformFuncBase.getPSMSPlatformFuncId() == null;
            }
            case 20: {
                return pSMSPlatformFuncBase.getPSMSPlatformFuncName() == null;
            }
            case 21: {
                return pSMSPlatformFuncBase.getPSMSPlatformId() == null;
            }
            case 22: {
                return pSMSPlatformFuncBase.getPSMSPlatformName() == null;
            }
            case 23: {
                return pSMSPlatformFuncBase.getServiceUrl() == null;
            }
            case 24: {
                return pSMSPlatformFuncBase.getSSHIPAddr() == null;
            }
            case 25: {
                return pSMSPlatformFuncBase.getSSHPort() == null;
            }
            case 26: {
                return pSMSPlatformFuncBase.getUpdateDate() == null;
            }
            case 27: {
                return pSMSPlatformFuncBase.getUpdateMan() == null;
            }
            case 28: {
                return pSMSPlatformFuncBase.getUploadFileMode() == null;
            }
            case 29: {
                return pSMSPlatformFuncBase.getUploadPath() == null;
            }
            case 30: {
                return pSMSPlatformFuncBase.getUserName() == null;
            }
            case 31: {
                return pSMSPlatformFuncBase.getValidFlag() == null;
            }
            case 32: {
                return pSMSPlatformFuncBase.getWorkshopPath() == null;
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
        return PSMSPlatformFuncBase.contains(this, n);
    }

    private static boolean contains(PSMSPlatformFuncBase pSMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMSPlatformFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSMSPlatformFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSMSPlatformFuncBase.isFuncParamDirty();
            }
            case 3: {
                return pSMSPlatformFuncBase.isFuncParam10Dirty();
            }
            case 4: {
                return pSMSPlatformFuncBase.isFuncParam2Dirty();
            }
            case 5: {
                return pSMSPlatformFuncBase.isFuncParam3Dirty();
            }
            case 6: {
                return pSMSPlatformFuncBase.isFuncParam4Dirty();
            }
            case 7: {
                return pSMSPlatformFuncBase.isFuncParam5Dirty();
            }
            case 8: {
                return pSMSPlatformFuncBase.isFuncParam6Dirty();
            }
            case 9: {
                return pSMSPlatformFuncBase.isFuncParam7Dirty();
            }
            case 10: {
                return pSMSPlatformFuncBase.isFuncParam8Dirty();
            }
            case 11: {
                return pSMSPlatformFuncBase.isFuncParam9Dirty();
            }
            case 12: {
                return pSMSPlatformFuncBase.isFuncParamsDirty();
            }
            case 13: {
                return pSMSPlatformFuncBase.isIpAddrDirty();
            }
            case 14: {
                return pSMSPlatformFuncBase.isIpAddr2Dirty();
            }
            case 15: {
                return pSMSPlatformFuncBase.isMemoDirty();
            }
            case 16: {
                return pSMSPlatformFuncBase.isMSFuncTypeDirty();
            }
            case 17: {
                return pSMSPlatformFuncBase.isPasswdDirty();
            }
            case 18: {
                return pSMSPlatformFuncBase.isPortDirty();
            }
            case 19: {
                return pSMSPlatformFuncBase.isPSMSPlatformFuncIdDirty();
            }
            case 20: {
                return pSMSPlatformFuncBase.isPSMSPlatformFuncNameDirty();
            }
            case 21: {
                return pSMSPlatformFuncBase.isPSMSPlatformIdDirty();
            }
            case 22: {
                return pSMSPlatformFuncBase.isPSMSPlatformNameDirty();
            }
            case 23: {
                return pSMSPlatformFuncBase.isServiceUrlDirty();
            }
            case 24: {
                return pSMSPlatformFuncBase.isSSHIPAddrDirty();
            }
            case 25: {
                return pSMSPlatformFuncBase.isSSHPortDirty();
            }
            case 26: {
                return pSMSPlatformFuncBase.isUpdateDateDirty();
            }
            case 27: {
                return pSMSPlatformFuncBase.isUpdateManDirty();
            }
            case 28: {
                return pSMSPlatformFuncBase.isUploadFileModeDirty();
            }
            case 29: {
                return pSMSPlatformFuncBase.isUploadPathDirty();
            }
            case 30: {
                return pSMSPlatformFuncBase.isUserNameDirty();
            }
            case 31: {
                return pSMSPlatformFuncBase.isValidFlagDirty();
            }
            case 32: {
                return pSMSPlatformFuncBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMSPlatformFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMSPlatformFuncBase pSMSPlatformFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMSPlatformFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam10", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam10()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam2", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam2()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam3", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam3()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam4", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam4()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam5", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam5()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam6", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam6()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam7", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam7()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam8", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam8()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam9", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParam9()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparams", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getFuncParams()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getMSFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msfunctype", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getMSFuncType()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPasswd()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPort()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformfuncid", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPSMSPlatformFuncId()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformfuncname", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPSMSPlatformFuncName()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformid", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPSMSPlatformId()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformname", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getPSMSPlatformName()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getUserName()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSMSPlatformFuncBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSMSPlatformFuncBase.getJSONValue((Object)pSMSPlatformFuncBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMSPlatformFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMSPlatformFuncBase pSMSPlatformFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMSPlatformFuncBase.getCreateDate() != null) {
            object = pSMSPlatformFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getCreateMan() != null) {
            object = pSMSPlatformFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam() != null) {
            object = pSMSPlatformFuncBase.getFuncParam();
            xmlNode.setAttribute(FIELD_FUNCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam10() != null) {
            object = pSMSPlatformFuncBase.getFuncParam10();
            xmlNode.setAttribute(FIELD_FUNCPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam2() != null) {
            object = pSMSPlatformFuncBase.getFuncParam2();
            xmlNode.setAttribute(FIELD_FUNCPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam3() != null) {
            object = pSMSPlatformFuncBase.getFuncParam3();
            xmlNode.setAttribute(FIELD_FUNCPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam4() != null) {
            object = pSMSPlatformFuncBase.getFuncParam4();
            xmlNode.setAttribute(FIELD_FUNCPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam5() != null) {
            object = pSMSPlatformFuncBase.getFuncParam5();
            xmlNode.setAttribute(FIELD_FUNCPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam6() != null) {
            object = pSMSPlatformFuncBase.getFuncParam6();
            xmlNode.setAttribute(FIELD_FUNCPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam7() != null) {
            object = pSMSPlatformFuncBase.getFuncParam7();
            xmlNode.setAttribute(FIELD_FUNCPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam8() != null) {
            object = pSMSPlatformFuncBase.getFuncParam8();
            xmlNode.setAttribute(FIELD_FUNCPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getFuncParam9() != null) {
            object = pSMSPlatformFuncBase.getFuncParam9();
            xmlNode.setAttribute(FIELD_FUNCPARAM9, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getFuncParams() != null) {
            object = pSMSPlatformFuncBase.getFuncParams();
            xmlNode.setAttribute(FIELD_FUNCPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getIpAddr() != null) {
            object = pSMSPlatformFuncBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getIpAddr2() != null) {
            object = pSMSPlatformFuncBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getMemo() != null) {
            object = pSMSPlatformFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getMSFuncType() != null) {
            object = pSMSPlatformFuncBase.getMSFuncType();
            xmlNode.setAttribute(FIELD_MSFUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getPasswd() != null) {
            object = pSMSPlatformFuncBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getPort() != null) {
            object = pSMSPlatformFuncBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncId() != null) {
            object = pSMSPlatformFuncBase.getPSMSPlatformFuncId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncName() != null) {
            object = pSMSPlatformFuncBase.getPSMSPlatformFuncName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformId() != null) {
            object = pSMSPlatformFuncBase.getPSMSPlatformId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getPSMSPlatformName() != null) {
            object = pSMSPlatformFuncBase.getPSMSPlatformName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getServiceUrl() != null) {
            object = pSMSPlatformFuncBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getSSHIPAddr() != null) {
            object = pSMSPlatformFuncBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getSSHPort() != null) {
            object = pSMSPlatformFuncBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getUpdateDate() != null) {
            object = pSMSPlatformFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getUpdateMan() != null) {
            object = pSMSPlatformFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getUploadFileMode() != null) {
            object = pSMSPlatformFuncBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getUploadPath() != null) {
            object = pSMSPlatformFuncBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getUserName() != null) {
            object = pSMSPlatformFuncBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMSPlatformFuncBase.getValidFlag() != null) {
            object = pSMSPlatformFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMSPlatformFuncBase.getWorkshopPath() != null) {
            object = pSMSPlatformFuncBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMSPlatformFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMSPlatformFuncBase pSMSPlatformFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMSPlatformFuncBase.isCreateDateDirty() && (bl || pSMSPlatformFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMSPlatformFuncBase.getCreateDate());
        }
        if (pSMSPlatformFuncBase.isCreateManDirty() && (bl || pSMSPlatformFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMSPlatformFuncBase.getCreateMan());
        }
        if (pSMSPlatformFuncBase.isFuncParamDirty() && (bl || pSMSPlatformFuncBase.getFuncParam() != null)) {
            iDataObject.set(FIELD_FUNCPARAM, (Object)pSMSPlatformFuncBase.getFuncParam());
        }
        if (pSMSPlatformFuncBase.isFuncParam10Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam10() != null)) {
            iDataObject.set(FIELD_FUNCPARAM10, (Object)pSMSPlatformFuncBase.getFuncParam10());
        }
        if (pSMSPlatformFuncBase.isFuncParam2Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam2() != null)) {
            iDataObject.set(FIELD_FUNCPARAM2, (Object)pSMSPlatformFuncBase.getFuncParam2());
        }
        if (pSMSPlatformFuncBase.isFuncParam3Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam3() != null)) {
            iDataObject.set(FIELD_FUNCPARAM3, (Object)pSMSPlatformFuncBase.getFuncParam3());
        }
        if (pSMSPlatformFuncBase.isFuncParam4Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam4() != null)) {
            iDataObject.set(FIELD_FUNCPARAM4, (Object)pSMSPlatformFuncBase.getFuncParam4());
        }
        if (pSMSPlatformFuncBase.isFuncParam5Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam5() != null)) {
            iDataObject.set(FIELD_FUNCPARAM5, (Object)pSMSPlatformFuncBase.getFuncParam5());
        }
        if (pSMSPlatformFuncBase.isFuncParam6Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam6() != null)) {
            iDataObject.set(FIELD_FUNCPARAM6, (Object)pSMSPlatformFuncBase.getFuncParam6());
        }
        if (pSMSPlatformFuncBase.isFuncParam7Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam7() != null)) {
            iDataObject.set(FIELD_FUNCPARAM7, (Object)pSMSPlatformFuncBase.getFuncParam7());
        }
        if (pSMSPlatformFuncBase.isFuncParam8Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam8() != null)) {
            iDataObject.set(FIELD_FUNCPARAM8, (Object)pSMSPlatformFuncBase.getFuncParam8());
        }
        if (pSMSPlatformFuncBase.isFuncParam9Dirty() && (bl || pSMSPlatformFuncBase.getFuncParam9() != null)) {
            iDataObject.set(FIELD_FUNCPARAM9, (Object)pSMSPlatformFuncBase.getFuncParam9());
        }
        if (pSMSPlatformFuncBase.isFuncParamsDirty() && (bl || pSMSPlatformFuncBase.getFuncParams() != null)) {
            iDataObject.set(FIELD_FUNCPARAMS, (Object)pSMSPlatformFuncBase.getFuncParams());
        }
        if (pSMSPlatformFuncBase.isIpAddrDirty() && (bl || pSMSPlatformFuncBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSMSPlatformFuncBase.getIpAddr());
        }
        if (pSMSPlatformFuncBase.isIpAddr2Dirty() && (bl || pSMSPlatformFuncBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSMSPlatformFuncBase.getIpAddr2());
        }
        if (pSMSPlatformFuncBase.isMemoDirty() && (bl || pSMSPlatformFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMSPlatformFuncBase.getMemo());
        }
        if (pSMSPlatformFuncBase.isMSFuncTypeDirty() && (bl || pSMSPlatformFuncBase.getMSFuncType() != null)) {
            iDataObject.set(FIELD_MSFUNCTYPE, (Object)pSMSPlatformFuncBase.getMSFuncType());
        }
        if (pSMSPlatformFuncBase.isPasswdDirty() && (bl || pSMSPlatformFuncBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSMSPlatformFuncBase.getPasswd());
        }
        if (pSMSPlatformFuncBase.isPortDirty() && (bl || pSMSPlatformFuncBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSMSPlatformFuncBase.getPort());
        }
        if (pSMSPlatformFuncBase.isPSMSPlatformFuncIdDirty() && (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMFUNCID, (Object)pSMSPlatformFuncBase.getPSMSPlatformFuncId());
        }
        if (pSMSPlatformFuncBase.isPSMSPlatformFuncNameDirty() && (bl || pSMSPlatformFuncBase.getPSMSPlatformFuncName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMFUNCNAME, (Object)pSMSPlatformFuncBase.getPSMSPlatformFuncName());
        }
        if (pSMSPlatformFuncBase.isPSMSPlatformIdDirty() && (bl || pSMSPlatformFuncBase.getPSMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMID, (Object)pSMSPlatformFuncBase.getPSMSPlatformId());
        }
        if (pSMSPlatformFuncBase.isPSMSPlatformNameDirty() && (bl || pSMSPlatformFuncBase.getPSMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNAME, (Object)pSMSPlatformFuncBase.getPSMSPlatformName());
        }
        if (pSMSPlatformFuncBase.isServiceUrlDirty() && (bl || pSMSPlatformFuncBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSMSPlatformFuncBase.getServiceUrl());
        }
        if (pSMSPlatformFuncBase.isSSHIPAddrDirty() && (bl || pSMSPlatformFuncBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSMSPlatformFuncBase.getSSHIPAddr());
        }
        if (pSMSPlatformFuncBase.isSSHPortDirty() && (bl || pSMSPlatformFuncBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSMSPlatformFuncBase.getSSHPort());
        }
        if (pSMSPlatformFuncBase.isUpdateDateDirty() && (bl || pSMSPlatformFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMSPlatformFuncBase.getUpdateDate());
        }
        if (pSMSPlatformFuncBase.isUpdateManDirty() && (bl || pSMSPlatformFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMSPlatformFuncBase.getUpdateMan());
        }
        if (pSMSPlatformFuncBase.isUploadFileModeDirty() && (bl || pSMSPlatformFuncBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSMSPlatformFuncBase.getUploadFileMode());
        }
        if (pSMSPlatformFuncBase.isUploadPathDirty() && (bl || pSMSPlatformFuncBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSMSPlatformFuncBase.getUploadPath());
        }
        if (pSMSPlatformFuncBase.isUserNameDirty() && (bl || pSMSPlatformFuncBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSMSPlatformFuncBase.getUserName());
        }
        if (pSMSPlatformFuncBase.isValidFlagDirty() && (bl || pSMSPlatformFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMSPlatformFuncBase.getValidFlag());
        }
        if (pSMSPlatformFuncBase.isWorkshopPathDirty() && (bl || pSMSPlatformFuncBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSMSPlatformFuncBase.getWorkshopPath());
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
        return PSMSPlatformFuncBase.remove(this, n);
    }

    private static boolean remove(PSMSPlatformFuncBase pSMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMSPlatformFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMSPlatformFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMSPlatformFuncBase.resetFuncParam();
                return true;
            }
            case 3: {
                pSMSPlatformFuncBase.resetFuncParam10();
                return true;
            }
            case 4: {
                pSMSPlatformFuncBase.resetFuncParam2();
                return true;
            }
            case 5: {
                pSMSPlatformFuncBase.resetFuncParam3();
                return true;
            }
            case 6: {
                pSMSPlatformFuncBase.resetFuncParam4();
                return true;
            }
            case 7: {
                pSMSPlatformFuncBase.resetFuncParam5();
                return true;
            }
            case 8: {
                pSMSPlatformFuncBase.resetFuncParam6();
                return true;
            }
            case 9: {
                pSMSPlatformFuncBase.resetFuncParam7();
                return true;
            }
            case 10: {
                pSMSPlatformFuncBase.resetFuncParam8();
                return true;
            }
            case 11: {
                pSMSPlatformFuncBase.resetFuncParam9();
                return true;
            }
            case 12: {
                pSMSPlatformFuncBase.resetFuncParams();
                return true;
            }
            case 13: {
                pSMSPlatformFuncBase.resetIpAddr();
                return true;
            }
            case 14: {
                pSMSPlatformFuncBase.resetIpAddr2();
                return true;
            }
            case 15: {
                pSMSPlatformFuncBase.resetMemo();
                return true;
            }
            case 16: {
                pSMSPlatformFuncBase.resetMSFuncType();
                return true;
            }
            case 17: {
                pSMSPlatformFuncBase.resetPasswd();
                return true;
            }
            case 18: {
                pSMSPlatformFuncBase.resetPort();
                return true;
            }
            case 19: {
                pSMSPlatformFuncBase.resetPSMSPlatformFuncId();
                return true;
            }
            case 20: {
                pSMSPlatformFuncBase.resetPSMSPlatformFuncName();
                return true;
            }
            case 21: {
                pSMSPlatformFuncBase.resetPSMSPlatformId();
                return true;
            }
            case 22: {
                pSMSPlatformFuncBase.resetPSMSPlatformName();
                return true;
            }
            case 23: {
                pSMSPlatformFuncBase.resetServiceUrl();
                return true;
            }
            case 24: {
                pSMSPlatformFuncBase.resetSSHIPAddr();
                return true;
            }
            case 25: {
                pSMSPlatformFuncBase.resetSSHPort();
                return true;
            }
            case 26: {
                pSMSPlatformFuncBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSMSPlatformFuncBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSMSPlatformFuncBase.resetUploadFileMode();
                return true;
            }
            case 29: {
                pSMSPlatformFuncBase.resetUploadPath();
                return true;
            }
            case 30: {
                pSMSPlatformFuncBase.resetUserName();
                return true;
            }
            case 31: {
                pSMSPlatformFuncBase.resetValidFlag();
                return true;
            }
            case 32: {
                pSMSPlatformFuncBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMSPlatform getPSMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatform();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSMSPlatformLock;
        synchronized (n) {
            if (this.psmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSMSPlatformId(), (Object)this.psmsplatform.getPSMSPlatformId()) != 0L) {
                this.psmsplatform = null;
            }
            if (this.psmsplatform == null) {
                PSMSPlatform pSMSPlatform = new PSMSPlatform();
                pSMSPlatform.setPSMSPlatformId(this.getPSMSPlatformId());
                PSMSPlatformService pSMSPlatformService = (PSMSPlatformService)ServiceGlobal.getService(PSMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSMSPlatformService.autoGet(pSMSPlatform);
                this.psmsplatform = pSMSPlatform;
            }
            return this.psmsplatform;
        }
    }

    private PSMSPlatformFuncBase getProxyEntity() {
        return this.proxyPSMSPlatformFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMSPlatformFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSMSPlatformFuncBase) {
            this.proxyPSMSPlatformFuncBase = (PSMSPlatformFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FUNCPARAM, 2);
        fieldIndexMap.put(FIELD_FUNCPARAM10, 3);
        fieldIndexMap.put(FIELD_FUNCPARAM2, 4);
        fieldIndexMap.put(FIELD_FUNCPARAM3, 5);
        fieldIndexMap.put(FIELD_FUNCPARAM4, 6);
        fieldIndexMap.put(FIELD_FUNCPARAM5, 7);
        fieldIndexMap.put(FIELD_FUNCPARAM6, 8);
        fieldIndexMap.put(FIELD_FUNCPARAM7, 9);
        fieldIndexMap.put(FIELD_FUNCPARAM8, 10);
        fieldIndexMap.put(FIELD_FUNCPARAM9, 11);
        fieldIndexMap.put(FIELD_FUNCPARAMS, 12);
        fieldIndexMap.put(FIELD_IPADDR, 13);
        fieldIndexMap.put(FIELD_IPADDR2, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MSFUNCTYPE, 16);
        fieldIndexMap.put(FIELD_PASSWD, 17);
        fieldIndexMap.put(FIELD_PORT, 18);
        fieldIndexMap.put(FIELD_PSMSPLATFORMFUNCID, 19);
        fieldIndexMap.put(FIELD_PSMSPLATFORMFUNCNAME, 20);
        fieldIndexMap.put(FIELD_PSMSPLATFORMID, 21);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNAME, 22);
        fieldIndexMap.put(FIELD_SERVICEURL, 23);
        fieldIndexMap.put(FIELD_SSHIPADDR, 24);
        fieldIndexMap.put(FIELD_SSHPORT, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 28);
        fieldIndexMap.put(FIELD_UPLOADPATH, 29);
        fieldIndexMap.put(FIELD_USERNAME, 30);
        fieldIndexMap.put(FIELD_VALIDFLAG, 31);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 32);
    }
}

