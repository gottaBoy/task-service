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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformFunc;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMSPlatformFuncBase.class);
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
    public static final String FIELD_MAXCPU = "MAXCPU";
    public static final String FIELD_MAXMEM = "MAXMEN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINCPU = "MINCPU";
    public static final String FIELD_MINMEM = "MINMEN";
    public static final String FIELD_MSFUNCTYPE = "MSFUNCTYPE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDCMSPLATFORMFUNCID = "PSDCMSPLATFORMFUNCID";
    public static final String FIELD_PSDCMSPLATFORMFUNCNAME = "PSDCMSPLATFORMFUNCNAME";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSMSPLATFORMFUNCID = "PSMSPLATFORMFUNCID";
    public static final String FIELD_PSMSPLATFORMFUNCNAME = "PSMSPLATFORMFUNCNAME";
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
    private static final int INDEX_MAXCPU = 15;
    private static final int INDEX_MAXMEM = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_MINCPU = 18;
    private static final int INDEX_MINMEM = 19;
    private static final int INDEX_MSFUNCTYPE = 20;
    private static final int INDEX_PASSWD = 21;
    private static final int INDEX_PORT = 22;
    private static final int INDEX_PSDCMSPLATFORMFUNCID = 23;
    private static final int INDEX_PSDCMSPLATFORMFUNCNAME = 24;
    private static final int INDEX_PSDCMSPLATFORMID = 25;
    private static final int INDEX_PSDCMSPLATFORMNAME = 26;
    private static final int INDEX_PSDEVSLNID = 27;
    private static final int INDEX_PSDEVSLNNAME = 28;
    private static final int INDEX_PSMSPLATFORMFUNCID = 29;
    private static final int INDEX_PSMSPLATFORMFUNCNAME = 30;
    private static final int INDEX_SERVICEURL = 31;
    private static final int INDEX_SSHIPADDR = 32;
    private static final int INDEX_SSHPORT = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_UPLOADFILEMODE = 36;
    private static final int INDEX_UPLOADPATH = 37;
    private static final int INDEX_USERNAME = 38;
    private static final int INDEX_VALIDFLAG = 39;
    private static final int INDEX_WORKSHOPPATH = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMSPlatformFuncBase proxyPSDCMSPlatformFuncBase = null;
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
    private boolean maxcpuDirtyFlag = false;
    private boolean maxmemDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mincpuDirtyFlag = false;
    private boolean minmemDirtyFlag = false;
    private boolean msfunctypeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdcmsplatformfuncidDirtyFlag = false;
    private boolean psdcmsplatformfuncnameDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psmsplatformfuncidDirtyFlag = false;
    private boolean psmsplatformfuncnameDirtyFlag = false;
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
    @Column(name="maxcpu")
    private Double maxcpu;
    @Column(name="maxmem")
    private Double maxmem;
    @Column(name="memo")
    private String memo;
    @Column(name="mincpu")
    private Double mincpu;
    @Column(name="minmem")
    private Double minmem;
    @Column(name="msfunctype")
    private String msfunctype;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psdcmsplatformfuncid")
    private String psdcmsplatformfuncid;
    @Column(name="psdcmsplatformfuncname")
    private String psdcmsplatformfuncname;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psmsplatformfuncid")
    private String psmsplatformfuncid;
    @Column(name="psmsplatformfuncname")
    private String psmsplatformfuncname;
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
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private PSDCMSPlatform psdcmsplatform = null;
    private Integer objPSMSPlatformFuncLock = new Integer(1);
    private PSMSPlatformFunc psmsplatformfunc = null;

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

    public void setMaxCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCPU(d);
            return;
        }
        this.maxcpu = d;
        this.maxcpuDirtyFlag = true;
    }

    public Double getMaxCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCPU();
        }
        return this.maxcpu;
    }

    public boolean isMaxCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCPUDirty();
        }
        return this.maxcpuDirtyFlag;
    }

    public void resetMaxCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCPU();
            return;
        }
        this.maxcpuDirtyFlag = false;
        this.maxcpu = null;
    }

    public void setMaxMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMem(d);
            return;
        }
        this.maxmem = d;
        this.maxmemDirtyFlag = true;
    }

    public Double getMaxMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMem();
        }
        return this.maxmem;
    }

    public boolean isMaxMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMemDirty();
        }
        return this.maxmemDirtyFlag;
    }

    public void resetMaxMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMem();
            return;
        }
        this.maxmemDirtyFlag = false;
        this.maxmem = null;
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

    public void setMinCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinCPU(d);
            return;
        }
        this.mincpu = d;
        this.mincpuDirtyFlag = true;
    }

    public Double getMinCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinCPU();
        }
        return this.mincpu;
    }

    public boolean isMinCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinCPUDirty();
        }
        return this.mincpuDirtyFlag;
    }

    public void resetMinCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinCPU();
            return;
        }
        this.mincpuDirtyFlag = false;
        this.mincpu = null;
    }

    public void setMinMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinMem(d);
            return;
        }
        this.minmem = d;
        this.minmemDirtyFlag = true;
    }

    public Double getMinMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinMem();
        }
        return this.minmem;
    }

    public boolean isMinMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinMemDirty();
        }
        return this.minmemDirtyFlag;
    }

    public void resetMinMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinMem();
            return;
        }
        this.minmemDirtyFlag = false;
        this.minmem = null;
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

    public void setPSDCMSPlatformFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformfuncid = string;
        this.psdcmsplatformfuncidDirtyFlag = true;
    }

    public String getPSDCMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFuncId();
        }
        return this.psdcmsplatformfuncid;
    }

    public boolean isPSDCMSPlatformFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformFuncIdDirty();
        }
        return this.psdcmsplatformfuncidDirtyFlag;
    }

    public void resetPSDCMSPlatformFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformFuncId();
            return;
        }
        this.psdcmsplatformfuncidDirtyFlag = false;
        this.psdcmsplatformfuncid = null;
    }

    public void setPSDCMSPlatformFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformfuncname = string;
        this.psdcmsplatformfuncnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFuncName();
        }
        return this.psdcmsplatformfuncname;
    }

    public boolean isPSDCMSPlatformFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformFuncNameDirty();
        }
        return this.psdcmsplatformfuncnameDirtyFlag;
    }

    public void resetPSDCMSPlatformFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformFuncName();
            return;
        }
        this.psdcmsplatformfuncnameDirtyFlag = false;
        this.psdcmsplatformfuncname = null;
    }

    public void setPSDCMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformid = string;
        this.psdcmsplatformidDirtyFlag = true;
    }

    public String getPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformId();
        }
        return this.psdcmsplatformid;
    }

    public boolean isPSDCMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformIdDirty();
        }
        return this.psdcmsplatformidDirtyFlag;
    }

    public void resetPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformId();
            return;
        }
        this.psdcmsplatformidDirtyFlag = false;
        this.psdcmsplatformid = null;
    }

    public void setPSDCMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformname = string;
        this.psdcmsplatformnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformName();
        }
        return this.psdcmsplatformname;
    }

    public boolean isPSDCMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNameDirty();
        }
        return this.psdcmsplatformnameDirtyFlag;
    }

    public void resetPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformName();
            return;
        }
        this.psdcmsplatformnameDirtyFlag = false;
        this.psdcmsplatformname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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
        PSDCMSPlatformFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase) {
        pSDCMSPlatformFuncBase.resetCreateDate();
        pSDCMSPlatformFuncBase.resetCreateMan();
        pSDCMSPlatformFuncBase.resetFuncParam();
        pSDCMSPlatformFuncBase.resetFuncParam10();
        pSDCMSPlatformFuncBase.resetFuncParam2();
        pSDCMSPlatformFuncBase.resetFuncParam3();
        pSDCMSPlatformFuncBase.resetFuncParam4();
        pSDCMSPlatformFuncBase.resetFuncParam5();
        pSDCMSPlatformFuncBase.resetFuncParam6();
        pSDCMSPlatformFuncBase.resetFuncParam7();
        pSDCMSPlatformFuncBase.resetFuncParam8();
        pSDCMSPlatformFuncBase.resetFuncParam9();
        pSDCMSPlatformFuncBase.resetFuncParams();
        pSDCMSPlatformFuncBase.resetIpAddr();
        pSDCMSPlatformFuncBase.resetIpAddr2();
        pSDCMSPlatformFuncBase.resetMaxCPU();
        pSDCMSPlatformFuncBase.resetMaxMem();
        pSDCMSPlatformFuncBase.resetMemo();
        pSDCMSPlatformFuncBase.resetMinCPU();
        pSDCMSPlatformFuncBase.resetMinMem();
        pSDCMSPlatformFuncBase.resetMSFuncType();
        pSDCMSPlatformFuncBase.resetPasswd();
        pSDCMSPlatformFuncBase.resetPort();
        pSDCMSPlatformFuncBase.resetPSDCMSPlatformFuncId();
        pSDCMSPlatformFuncBase.resetPSDCMSPlatformFuncName();
        pSDCMSPlatformFuncBase.resetPSDCMSPlatformId();
        pSDCMSPlatformFuncBase.resetPSDCMSPlatformName();
        pSDCMSPlatformFuncBase.resetPSDevSlnId();
        pSDCMSPlatformFuncBase.resetPSDevSlnName();
        pSDCMSPlatformFuncBase.resetPSMSPlatformFuncId();
        pSDCMSPlatformFuncBase.resetPSMSPlatformFuncName();
        pSDCMSPlatformFuncBase.resetServiceUrl();
        pSDCMSPlatformFuncBase.resetSSHIPAddr();
        pSDCMSPlatformFuncBase.resetSSHPort();
        pSDCMSPlatformFuncBase.resetUpdateDate();
        pSDCMSPlatformFuncBase.resetUpdateMan();
        pSDCMSPlatformFuncBase.resetUploadFileMode();
        pSDCMSPlatformFuncBase.resetUploadPath();
        pSDCMSPlatformFuncBase.resetUserName();
        pSDCMSPlatformFuncBase.resetValidFlag();
        pSDCMSPlatformFuncBase.resetWorkshopPath();
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
        if (!bl || this.isMaxCPUDirty()) {
            hashMap.put(FIELD_MAXCPU, this.getMaxCPU());
        }
        if (!bl || this.isMaxMemDirty()) {
            hashMap.put(FIELD_MAXMEM, this.getMaxMem());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinCPUDirty()) {
            hashMap.put(FIELD_MINCPU, this.getMinCPU());
        }
        if (!bl || this.isMinMemDirty()) {
            hashMap.put(FIELD_MINMEM, this.getMinMem());
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
        if (!bl || this.isPSDCMSPlatformFuncIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMFUNCID, this.getPSDCMSPlatformFuncId());
        }
        if (!bl || this.isPSDCMSPlatformFuncNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMFUNCNAME, this.getPSDCMSPlatformFuncName());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSMSPlatformFuncIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMFUNCID, this.getPSMSPlatformFuncId());
        }
        if (!bl || this.isPSMSPlatformFuncNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMFUNCNAME, this.getPSMSPlatformFuncName());
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
        return PSDCMSPlatformFuncBase.get(this, n);
    }

    private static Object get(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformFuncBase.getCreateDate();
            }
            case 1: {
                return pSDCMSPlatformFuncBase.getCreateMan();
            }
            case 2: {
                return pSDCMSPlatformFuncBase.getFuncParam();
            }
            case 3: {
                return pSDCMSPlatformFuncBase.getFuncParam10();
            }
            case 4: {
                return pSDCMSPlatformFuncBase.getFuncParam2();
            }
            case 5: {
                return pSDCMSPlatformFuncBase.getFuncParam3();
            }
            case 6: {
                return pSDCMSPlatformFuncBase.getFuncParam4();
            }
            case 7: {
                return pSDCMSPlatformFuncBase.getFuncParam5();
            }
            case 8: {
                return pSDCMSPlatformFuncBase.getFuncParam6();
            }
            case 9: {
                return pSDCMSPlatformFuncBase.getFuncParam7();
            }
            case 10: {
                return pSDCMSPlatformFuncBase.getFuncParam8();
            }
            case 11: {
                return pSDCMSPlatformFuncBase.getFuncParam9();
            }
            case 12: {
                return pSDCMSPlatformFuncBase.getFuncParams();
            }
            case 13: {
                return pSDCMSPlatformFuncBase.getIpAddr();
            }
            case 14: {
                return pSDCMSPlatformFuncBase.getIpAddr2();
            }
            case 15: {
                return pSDCMSPlatformFuncBase.getMaxCPU();
            }
            case 16: {
                return pSDCMSPlatformFuncBase.getMaxMem();
            }
            case 17: {
                return pSDCMSPlatformFuncBase.getMemo();
            }
            case 18: {
                return pSDCMSPlatformFuncBase.getMinCPU();
            }
            case 19: {
                return pSDCMSPlatformFuncBase.getMinMem();
            }
            case 20: {
                return pSDCMSPlatformFuncBase.getMSFuncType();
            }
            case 21: {
                return pSDCMSPlatformFuncBase.getPasswd();
            }
            case 22: {
                return pSDCMSPlatformFuncBase.getPort();
            }
            case 23: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId();
            }
            case 24: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName();
            }
            case 25: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformId();
            }
            case 26: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformName();
            }
            case 27: {
                return pSDCMSPlatformFuncBase.getPSDevSlnId();
            }
            case 28: {
                return pSDCMSPlatformFuncBase.getPSDevSlnName();
            }
            case 29: {
                return pSDCMSPlatformFuncBase.getPSMSPlatformFuncId();
            }
            case 30: {
                return pSDCMSPlatformFuncBase.getPSMSPlatformFuncName();
            }
            case 31: {
                return pSDCMSPlatformFuncBase.getServiceUrl();
            }
            case 32: {
                return pSDCMSPlatformFuncBase.getSSHIPAddr();
            }
            case 33: {
                return pSDCMSPlatformFuncBase.getSSHPort();
            }
            case 34: {
                return pSDCMSPlatformFuncBase.getUpdateDate();
            }
            case 35: {
                return pSDCMSPlatformFuncBase.getUpdateMan();
            }
            case 36: {
                return pSDCMSPlatformFuncBase.getUploadFileMode();
            }
            case 37: {
                return pSDCMSPlatformFuncBase.getUploadPath();
            }
            case 38: {
                return pSDCMSPlatformFuncBase.getUserName();
            }
            case 39: {
                return pSDCMSPlatformFuncBase.getValidFlag();
            }
            case 40: {
                return pSDCMSPlatformFuncBase.getWorkshopPath();
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
        PSDCMSPlatformFuncBase.set(this, n, object);
    }

    private static void set(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCMSPlatformFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMSPlatformFuncBase.setFuncParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMSPlatformFuncBase.setFuncParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMSPlatformFuncBase.setFuncParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMSPlatformFuncBase.setFuncParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMSPlatformFuncBase.setFuncParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMSPlatformFuncBase.setFuncParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCMSPlatformFuncBase.setFuncParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCMSPlatformFuncBase.setFuncParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDCMSPlatformFuncBase.setFuncParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCMSPlatformFuncBase.setFuncParam9(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCMSPlatformFuncBase.setFuncParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCMSPlatformFuncBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMSPlatformFuncBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCMSPlatformFuncBase.setMaxCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 16: {
                pSDCMSPlatformFuncBase.setMaxMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 17: {
                pSDCMSPlatformFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCMSPlatformFuncBase.setMinCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 19: {
                pSDCMSPlatformFuncBase.setMinMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 20: {
                pSDCMSPlatformFuncBase.setMSFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCMSPlatformFuncBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCMSPlatformFuncBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCMSPlatformFuncBase.setPSDCMSPlatformFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCMSPlatformFuncBase.setPSDCMSPlatformFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCMSPlatformFuncBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCMSPlatformFuncBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCMSPlatformFuncBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCMSPlatformFuncBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCMSPlatformFuncBase.setPSMSPlatformFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCMSPlatformFuncBase.setPSMSPlatformFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCMSPlatformFuncBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCMSPlatformFuncBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCMSPlatformFuncBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDCMSPlatformFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSDCMSPlatformFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDCMSPlatformFuncBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDCMSPlatformFuncBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDCMSPlatformFuncBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCMSPlatformFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDCMSPlatformFuncBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCMSPlatformFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCMSPlatformFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCMSPlatformFuncBase.getFuncParam() == null;
            }
            case 3: {
                return pSDCMSPlatformFuncBase.getFuncParam10() == null;
            }
            case 4: {
                return pSDCMSPlatformFuncBase.getFuncParam2() == null;
            }
            case 5: {
                return pSDCMSPlatformFuncBase.getFuncParam3() == null;
            }
            case 6: {
                return pSDCMSPlatformFuncBase.getFuncParam4() == null;
            }
            case 7: {
                return pSDCMSPlatformFuncBase.getFuncParam5() == null;
            }
            case 8: {
                return pSDCMSPlatformFuncBase.getFuncParam6() == null;
            }
            case 9: {
                return pSDCMSPlatformFuncBase.getFuncParam7() == null;
            }
            case 10: {
                return pSDCMSPlatformFuncBase.getFuncParam8() == null;
            }
            case 11: {
                return pSDCMSPlatformFuncBase.getFuncParam9() == null;
            }
            case 12: {
                return pSDCMSPlatformFuncBase.getFuncParams() == null;
            }
            case 13: {
                return pSDCMSPlatformFuncBase.getIpAddr() == null;
            }
            case 14: {
                return pSDCMSPlatformFuncBase.getIpAddr2() == null;
            }
            case 15: {
                return pSDCMSPlatformFuncBase.getMaxCPU() == null;
            }
            case 16: {
                return pSDCMSPlatformFuncBase.getMaxMem() == null;
            }
            case 17: {
                return pSDCMSPlatformFuncBase.getMemo() == null;
            }
            case 18: {
                return pSDCMSPlatformFuncBase.getMinCPU() == null;
            }
            case 19: {
                return pSDCMSPlatformFuncBase.getMinMem() == null;
            }
            case 20: {
                return pSDCMSPlatformFuncBase.getMSFuncType() == null;
            }
            case 21: {
                return pSDCMSPlatformFuncBase.getPasswd() == null;
            }
            case 22: {
                return pSDCMSPlatformFuncBase.getPort() == null;
            }
            case 23: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId() == null;
            }
            case 24: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName() == null;
            }
            case 25: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformId() == null;
            }
            case 26: {
                return pSDCMSPlatformFuncBase.getPSDCMSPlatformName() == null;
            }
            case 27: {
                return pSDCMSPlatformFuncBase.getPSDevSlnId() == null;
            }
            case 28: {
                return pSDCMSPlatformFuncBase.getPSDevSlnName() == null;
            }
            case 29: {
                return pSDCMSPlatformFuncBase.getPSMSPlatformFuncId() == null;
            }
            case 30: {
                return pSDCMSPlatformFuncBase.getPSMSPlatformFuncName() == null;
            }
            case 31: {
                return pSDCMSPlatformFuncBase.getServiceUrl() == null;
            }
            case 32: {
                return pSDCMSPlatformFuncBase.getSSHIPAddr() == null;
            }
            case 33: {
                return pSDCMSPlatformFuncBase.getSSHPort() == null;
            }
            case 34: {
                return pSDCMSPlatformFuncBase.getUpdateDate() == null;
            }
            case 35: {
                return pSDCMSPlatformFuncBase.getUpdateMan() == null;
            }
            case 36: {
                return pSDCMSPlatformFuncBase.getUploadFileMode() == null;
            }
            case 37: {
                return pSDCMSPlatformFuncBase.getUploadPath() == null;
            }
            case 38: {
                return pSDCMSPlatformFuncBase.getUserName() == null;
            }
            case 39: {
                return pSDCMSPlatformFuncBase.getValidFlag() == null;
            }
            case 40: {
                return pSDCMSPlatformFuncBase.getWorkshopPath() == null;
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
        return PSDCMSPlatformFuncBase.contains(this, n);
    }

    private static boolean contains(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCMSPlatformFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSDCMSPlatformFuncBase.isFuncParamDirty();
            }
            case 3: {
                return pSDCMSPlatformFuncBase.isFuncParam10Dirty();
            }
            case 4: {
                return pSDCMSPlatformFuncBase.isFuncParam2Dirty();
            }
            case 5: {
                return pSDCMSPlatformFuncBase.isFuncParam3Dirty();
            }
            case 6: {
                return pSDCMSPlatformFuncBase.isFuncParam4Dirty();
            }
            case 7: {
                return pSDCMSPlatformFuncBase.isFuncParam5Dirty();
            }
            case 8: {
                return pSDCMSPlatformFuncBase.isFuncParam6Dirty();
            }
            case 9: {
                return pSDCMSPlatformFuncBase.isFuncParam7Dirty();
            }
            case 10: {
                return pSDCMSPlatformFuncBase.isFuncParam8Dirty();
            }
            case 11: {
                return pSDCMSPlatformFuncBase.isFuncParam9Dirty();
            }
            case 12: {
                return pSDCMSPlatformFuncBase.isFuncParamsDirty();
            }
            case 13: {
                return pSDCMSPlatformFuncBase.isIpAddrDirty();
            }
            case 14: {
                return pSDCMSPlatformFuncBase.isIpAddr2Dirty();
            }
            case 15: {
                return pSDCMSPlatformFuncBase.isMaxCPUDirty();
            }
            case 16: {
                return pSDCMSPlatformFuncBase.isMaxMemDirty();
            }
            case 17: {
                return pSDCMSPlatformFuncBase.isMemoDirty();
            }
            case 18: {
                return pSDCMSPlatformFuncBase.isMinCPUDirty();
            }
            case 19: {
                return pSDCMSPlatformFuncBase.isMinMemDirty();
            }
            case 20: {
                return pSDCMSPlatformFuncBase.isMSFuncTypeDirty();
            }
            case 21: {
                return pSDCMSPlatformFuncBase.isPasswdDirty();
            }
            case 22: {
                return pSDCMSPlatformFuncBase.isPortDirty();
            }
            case 23: {
                return pSDCMSPlatformFuncBase.isPSDCMSPlatformFuncIdDirty();
            }
            case 24: {
                return pSDCMSPlatformFuncBase.isPSDCMSPlatformFuncNameDirty();
            }
            case 25: {
                return pSDCMSPlatformFuncBase.isPSDCMSPlatformIdDirty();
            }
            case 26: {
                return pSDCMSPlatformFuncBase.isPSDCMSPlatformNameDirty();
            }
            case 27: {
                return pSDCMSPlatformFuncBase.isPSDevSlnIdDirty();
            }
            case 28: {
                return pSDCMSPlatformFuncBase.isPSDevSlnNameDirty();
            }
            case 29: {
                return pSDCMSPlatformFuncBase.isPSMSPlatformFuncIdDirty();
            }
            case 30: {
                return pSDCMSPlatformFuncBase.isPSMSPlatformFuncNameDirty();
            }
            case 31: {
                return pSDCMSPlatformFuncBase.isServiceUrlDirty();
            }
            case 32: {
                return pSDCMSPlatformFuncBase.isSSHIPAddrDirty();
            }
            case 33: {
                return pSDCMSPlatformFuncBase.isSSHPortDirty();
            }
            case 34: {
                return pSDCMSPlatformFuncBase.isUpdateDateDirty();
            }
            case 35: {
                return pSDCMSPlatformFuncBase.isUpdateManDirty();
            }
            case 36: {
                return pSDCMSPlatformFuncBase.isUploadFileModeDirty();
            }
            case 37: {
                return pSDCMSPlatformFuncBase.isUploadPathDirty();
            }
            case 38: {
                return pSDCMSPlatformFuncBase.isUserNameDirty();
            }
            case 39: {
                return pSDCMSPlatformFuncBase.isValidFlagDirty();
            }
            case 40: {
                return pSDCMSPlatformFuncBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMSPlatformFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMSPlatformFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam10", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam10()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam2", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam3", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam3()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam4", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam4()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam5", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam5()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam6", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam6()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam7", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam7()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam8", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam8()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparam9", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParam9()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcparams", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getFuncParams()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMaxCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcpu", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMaxCPU()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMaxMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmen", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMaxMem()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMinCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mincpu", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMinCPU()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMinMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minmen", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMinMem()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getMSFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msfunctype", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getMSFuncType()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformfuncid", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformfuncname", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformfuncid", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSMSPlatformFuncId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformfuncname", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getPSMSPlatformFuncName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformFuncBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCMSPlatformFuncBase.getJSONValue((Object)pSDCMSPlatformFuncBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMSPlatformFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMSPlatformFuncBase.getCreateDate() != null) {
            object = pSDCMSPlatformFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getCreateMan() != null) {
            object = pSDCMSPlatformFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam();
            xmlNode.setAttribute(FIELD_FUNCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam10() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam10();
            xmlNode.setAttribute(FIELD_FUNCPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam2() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam2();
            xmlNode.setAttribute(FIELD_FUNCPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam3() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam3();
            xmlNode.setAttribute(FIELD_FUNCPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam4() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam4();
            xmlNode.setAttribute(FIELD_FUNCPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam5() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam5();
            xmlNode.setAttribute(FIELD_FUNCPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam6() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam6();
            xmlNode.setAttribute(FIELD_FUNCPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam7() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam7();
            xmlNode.setAttribute(FIELD_FUNCPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam8() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam8();
            xmlNode.setAttribute(FIELD_FUNCPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParam9() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParam9();
            xmlNode.setAttribute(FIELD_FUNCPARAM9, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getFuncParams() != null) {
            object = pSDCMSPlatformFuncBase.getFuncParams();
            xmlNode.setAttribute(FIELD_FUNCPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getIpAddr() != null) {
            object = pSDCMSPlatformFuncBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getIpAddr2() != null) {
            object = pSDCMSPlatformFuncBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getMaxCPU() != null) {
            object = pSDCMSPlatformFuncBase.getMaxCPU();
            xmlNode.setAttribute(FIELD_MAXCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getMaxMem() != null) {
            object = pSDCMSPlatformFuncBase.getMaxMem();
            xmlNode.setAttribute("MAXMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getMemo() != null) {
            object = pSDCMSPlatformFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getMinCPU() != null) {
            object = pSDCMSPlatformFuncBase.getMinCPU();
            xmlNode.setAttribute(FIELD_MINCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getMinMem() != null) {
            object = pSDCMSPlatformFuncBase.getMinMem();
            xmlNode.setAttribute("MINMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getMSFuncType() != null) {
            object = pSDCMSPlatformFuncBase.getMSFuncType();
            xmlNode.setAttribute(FIELD_MSFUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPasswd() != null) {
            object = pSDCMSPlatformFuncBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPort() != null) {
            object = pSDCMSPlatformFuncBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId() != null) {
            object = pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName() != null) {
            object = pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformId() != null) {
            object = pSDCMSPlatformFuncBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformName() != null) {
            object = pSDCMSPlatformFuncBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDevSlnId() != null) {
            object = pSDCMSPlatformFuncBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSDevSlnName() != null) {
            object = pSDCMSPlatformFuncBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncId() != null) {
            object = pSDCMSPlatformFuncBase.getPSMSPlatformFuncId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncName() != null) {
            object = pSDCMSPlatformFuncBase.getPSMSPlatformFuncName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getServiceUrl() != null) {
            object = pSDCMSPlatformFuncBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getSSHIPAddr() != null) {
            object = pSDCMSPlatformFuncBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getSSHPort() != null) {
            object = pSDCMSPlatformFuncBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getUpdateDate() != null) {
            object = pSDCMSPlatformFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getUpdateMan() != null) {
            object = pSDCMSPlatformFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getUploadFileMode() != null) {
            object = pSDCMSPlatformFuncBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getUploadPath() != null) {
            object = pSDCMSPlatformFuncBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getUserName() != null) {
            object = pSDCMSPlatformFuncBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformFuncBase.getValidFlag() != null) {
            object = pSDCMSPlatformFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformFuncBase.getWorkshopPath() != null) {
            object = pSDCMSPlatformFuncBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMSPlatformFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMSPlatformFuncBase.isCreateDateDirty() && (bl || pSDCMSPlatformFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMSPlatformFuncBase.getCreateDate());
        }
        if (pSDCMSPlatformFuncBase.isCreateManDirty() && (bl || pSDCMSPlatformFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMSPlatformFuncBase.getCreateMan());
        }
        if (pSDCMSPlatformFuncBase.isFuncParamDirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam() != null)) {
            iDataObject.set(FIELD_FUNCPARAM, (Object)pSDCMSPlatformFuncBase.getFuncParam());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam10Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam10() != null)) {
            iDataObject.set(FIELD_FUNCPARAM10, (Object)pSDCMSPlatformFuncBase.getFuncParam10());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam2Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam2() != null)) {
            iDataObject.set(FIELD_FUNCPARAM2, (Object)pSDCMSPlatformFuncBase.getFuncParam2());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam3Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam3() != null)) {
            iDataObject.set(FIELD_FUNCPARAM3, (Object)pSDCMSPlatformFuncBase.getFuncParam3());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam4Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam4() != null)) {
            iDataObject.set(FIELD_FUNCPARAM4, (Object)pSDCMSPlatformFuncBase.getFuncParam4());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam5Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam5() != null)) {
            iDataObject.set(FIELD_FUNCPARAM5, (Object)pSDCMSPlatformFuncBase.getFuncParam5());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam6Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam6() != null)) {
            iDataObject.set(FIELD_FUNCPARAM6, (Object)pSDCMSPlatformFuncBase.getFuncParam6());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam7Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam7() != null)) {
            iDataObject.set(FIELD_FUNCPARAM7, (Object)pSDCMSPlatformFuncBase.getFuncParam7());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam8Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam8() != null)) {
            iDataObject.set(FIELD_FUNCPARAM8, (Object)pSDCMSPlatformFuncBase.getFuncParam8());
        }
        if (pSDCMSPlatformFuncBase.isFuncParam9Dirty() && (bl || pSDCMSPlatformFuncBase.getFuncParam9() != null)) {
            iDataObject.set(FIELD_FUNCPARAM9, (Object)pSDCMSPlatformFuncBase.getFuncParam9());
        }
        if (pSDCMSPlatformFuncBase.isFuncParamsDirty() && (bl || pSDCMSPlatformFuncBase.getFuncParams() != null)) {
            iDataObject.set(FIELD_FUNCPARAMS, (Object)pSDCMSPlatformFuncBase.getFuncParams());
        }
        if (pSDCMSPlatformFuncBase.isIpAddrDirty() && (bl || pSDCMSPlatformFuncBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCMSPlatformFuncBase.getIpAddr());
        }
        if (pSDCMSPlatformFuncBase.isIpAddr2Dirty() && (bl || pSDCMSPlatformFuncBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCMSPlatformFuncBase.getIpAddr2());
        }
        if (pSDCMSPlatformFuncBase.isMaxCPUDirty() && (bl || pSDCMSPlatformFuncBase.getMaxCPU() != null)) {
            iDataObject.set(FIELD_MAXCPU, (Object)pSDCMSPlatformFuncBase.getMaxCPU());
        }
        if (pSDCMSPlatformFuncBase.isMaxMemDirty() && (bl || pSDCMSPlatformFuncBase.getMaxMem() != null)) {
            iDataObject.set(FIELD_MAXMEM, (Object)pSDCMSPlatformFuncBase.getMaxMem());
        }
        if (pSDCMSPlatformFuncBase.isMemoDirty() && (bl || pSDCMSPlatformFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMSPlatformFuncBase.getMemo());
        }
        if (pSDCMSPlatformFuncBase.isMinCPUDirty() && (bl || pSDCMSPlatformFuncBase.getMinCPU() != null)) {
            iDataObject.set(FIELD_MINCPU, (Object)pSDCMSPlatformFuncBase.getMinCPU());
        }
        if (pSDCMSPlatformFuncBase.isMinMemDirty() && (bl || pSDCMSPlatformFuncBase.getMinMem() != null)) {
            iDataObject.set(FIELD_MINMEM, (Object)pSDCMSPlatformFuncBase.getMinMem());
        }
        if (pSDCMSPlatformFuncBase.isMSFuncTypeDirty() && (bl || pSDCMSPlatformFuncBase.getMSFuncType() != null)) {
            iDataObject.set(FIELD_MSFUNCTYPE, (Object)pSDCMSPlatformFuncBase.getMSFuncType());
        }
        if (pSDCMSPlatformFuncBase.isPasswdDirty() && (bl || pSDCMSPlatformFuncBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCMSPlatformFuncBase.getPasswd());
        }
        if (pSDCMSPlatformFuncBase.isPortDirty() && (bl || pSDCMSPlatformFuncBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCMSPlatformFuncBase.getPort());
        }
        if (pSDCMSPlatformFuncBase.isPSDCMSPlatformFuncIdDirty() && (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMFUNCID, (Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId());
        }
        if (pSDCMSPlatformFuncBase.isPSDCMSPlatformFuncNameDirty() && (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMFUNCNAME, (Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncName());
        }
        if (pSDCMSPlatformFuncBase.isPSDCMSPlatformIdDirty() && (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformId());
        }
        if (pSDCMSPlatformFuncBase.isPSDCMSPlatformNameDirty() && (bl || pSDCMSPlatformFuncBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformName());
        }
        if (pSDCMSPlatformFuncBase.isPSDevSlnIdDirty() && (bl || pSDCMSPlatformFuncBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCMSPlatformFuncBase.getPSDevSlnId());
        }
        if (pSDCMSPlatformFuncBase.isPSDevSlnNameDirty() && (bl || pSDCMSPlatformFuncBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCMSPlatformFuncBase.getPSDevSlnName());
        }
        if (pSDCMSPlatformFuncBase.isPSMSPlatformFuncIdDirty() && (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMFUNCID, (Object)pSDCMSPlatformFuncBase.getPSMSPlatformFuncId());
        }
        if (pSDCMSPlatformFuncBase.isPSMSPlatformFuncNameDirty() && (bl || pSDCMSPlatformFuncBase.getPSMSPlatformFuncName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMFUNCNAME, (Object)pSDCMSPlatformFuncBase.getPSMSPlatformFuncName());
        }
        if (pSDCMSPlatformFuncBase.isServiceUrlDirty() && (bl || pSDCMSPlatformFuncBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSDCMSPlatformFuncBase.getServiceUrl());
        }
        if (pSDCMSPlatformFuncBase.isSSHIPAddrDirty() && (bl || pSDCMSPlatformFuncBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCMSPlatformFuncBase.getSSHIPAddr());
        }
        if (pSDCMSPlatformFuncBase.isSSHPortDirty() && (bl || pSDCMSPlatformFuncBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCMSPlatformFuncBase.getSSHPort());
        }
        if (pSDCMSPlatformFuncBase.isUpdateDateDirty() && (bl || pSDCMSPlatformFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMSPlatformFuncBase.getUpdateDate());
        }
        if (pSDCMSPlatformFuncBase.isUpdateManDirty() && (bl || pSDCMSPlatformFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMSPlatformFuncBase.getUpdateMan());
        }
        if (pSDCMSPlatformFuncBase.isUploadFileModeDirty() && (bl || pSDCMSPlatformFuncBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCMSPlatformFuncBase.getUploadFileMode());
        }
        if (pSDCMSPlatformFuncBase.isUploadPathDirty() && (bl || pSDCMSPlatformFuncBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCMSPlatformFuncBase.getUploadPath());
        }
        if (pSDCMSPlatformFuncBase.isUserNameDirty() && (bl || pSDCMSPlatformFuncBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCMSPlatformFuncBase.getUserName());
        }
        if (pSDCMSPlatformFuncBase.isValidFlagDirty() && (bl || pSDCMSPlatformFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMSPlatformFuncBase.getValidFlag());
        }
        if (pSDCMSPlatformFuncBase.isWorkshopPathDirty() && (bl || pSDCMSPlatformFuncBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCMSPlatformFuncBase.getWorkshopPath());
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
        return PSDCMSPlatformFuncBase.remove(this, n);
    }

    private static boolean remove(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCMSPlatformFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCMSPlatformFuncBase.resetFuncParam();
                return true;
            }
            case 3: {
                pSDCMSPlatformFuncBase.resetFuncParam10();
                return true;
            }
            case 4: {
                pSDCMSPlatformFuncBase.resetFuncParam2();
                return true;
            }
            case 5: {
                pSDCMSPlatformFuncBase.resetFuncParam3();
                return true;
            }
            case 6: {
                pSDCMSPlatformFuncBase.resetFuncParam4();
                return true;
            }
            case 7: {
                pSDCMSPlatformFuncBase.resetFuncParam5();
                return true;
            }
            case 8: {
                pSDCMSPlatformFuncBase.resetFuncParam6();
                return true;
            }
            case 9: {
                pSDCMSPlatformFuncBase.resetFuncParam7();
                return true;
            }
            case 10: {
                pSDCMSPlatformFuncBase.resetFuncParam8();
                return true;
            }
            case 11: {
                pSDCMSPlatformFuncBase.resetFuncParam9();
                return true;
            }
            case 12: {
                pSDCMSPlatformFuncBase.resetFuncParams();
                return true;
            }
            case 13: {
                pSDCMSPlatformFuncBase.resetIpAddr();
                return true;
            }
            case 14: {
                pSDCMSPlatformFuncBase.resetIpAddr2();
                return true;
            }
            case 15: {
                pSDCMSPlatformFuncBase.resetMaxCPU();
                return true;
            }
            case 16: {
                pSDCMSPlatformFuncBase.resetMaxMem();
                return true;
            }
            case 17: {
                pSDCMSPlatformFuncBase.resetMemo();
                return true;
            }
            case 18: {
                pSDCMSPlatformFuncBase.resetMinCPU();
                return true;
            }
            case 19: {
                pSDCMSPlatformFuncBase.resetMinMem();
                return true;
            }
            case 20: {
                pSDCMSPlatformFuncBase.resetMSFuncType();
                return true;
            }
            case 21: {
                pSDCMSPlatformFuncBase.resetPasswd();
                return true;
            }
            case 22: {
                pSDCMSPlatformFuncBase.resetPort();
                return true;
            }
            case 23: {
                pSDCMSPlatformFuncBase.resetPSDCMSPlatformFuncId();
                return true;
            }
            case 24: {
                pSDCMSPlatformFuncBase.resetPSDCMSPlatformFuncName();
                return true;
            }
            case 25: {
                pSDCMSPlatformFuncBase.resetPSDCMSPlatformId();
                return true;
            }
            case 26: {
                pSDCMSPlatformFuncBase.resetPSDCMSPlatformName();
                return true;
            }
            case 27: {
                pSDCMSPlatformFuncBase.resetPSDevSlnId();
                return true;
            }
            case 28: {
                pSDCMSPlatformFuncBase.resetPSDevSlnName();
                return true;
            }
            case 29: {
                pSDCMSPlatformFuncBase.resetPSMSPlatformFuncId();
                return true;
            }
            case 30: {
                pSDCMSPlatformFuncBase.resetPSMSPlatformFuncName();
                return true;
            }
            case 31: {
                pSDCMSPlatformFuncBase.resetServiceUrl();
                return true;
            }
            case 32: {
                pSDCMSPlatformFuncBase.resetSSHIPAddr();
                return true;
            }
            case 33: {
                pSDCMSPlatformFuncBase.resetSSHPort();
                return true;
            }
            case 34: {
                pSDCMSPlatformFuncBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSDCMSPlatformFuncBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSDCMSPlatformFuncBase.resetUploadFileMode();
                return true;
            }
            case 37: {
                pSDCMSPlatformFuncBase.resetUploadPath();
                return true;
            }
            case 38: {
                pSDCMSPlatformFuncBase.resetUserName();
                return true;
            }
            case 39: {
                pSDCMSPlatformFuncBase.resetValidFlag();
                return true;
            }
            case 40: {
                pSDCMSPlatformFuncBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatform getPSDCMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatform();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformLock;
        synchronized (n) {
            if (this.psdcmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformId(), (Object)this.psdcmsplatform.getPSDCMSPlatformId()) != 0L) {
                this.psdcmsplatform = null;
            }
            if (this.psdcmsplatform == null) {
                PSDCMSPlatform pSDCMSPlatform = new PSDCMSPlatform();
                pSDCMSPlatform.setPSDCMSPlatformId(this.getPSDCMSPlatformId());
                PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformService.autoGet((IEntity)pSDCMSPlatform);
                this.psdcmsplatform = pSDCMSPlatform;
            }
            return this.psdcmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMSPlatformFunc getPSMSPlatformFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformFunc();
        }
        if (this.getPSMSPlatformFuncId() == null) {
            return null;
        }
        Integer n = this.objPSMSPlatformFuncLock;
        synchronized (n) {
            if (this.psmsplatformfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSMSPlatformFuncId(), (Object)this.psmsplatformfunc.getPSMSPlatformFuncId()) != 0L) {
                this.psmsplatformfunc = null;
            }
            if (this.psmsplatformfunc == null) {
                PSMSPlatformFunc pSMSPlatformFunc = new PSMSPlatformFunc();
                pSMSPlatformFunc.setPSMSPlatformFuncId(this.getPSMSPlatformFuncId());
                PSMSPlatformFuncService pSMSPlatformFuncService = (PSMSPlatformFuncService)ServiceGlobal.getService(PSMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
                pSMSPlatformFuncService.autoGet((IEntity)pSMSPlatformFunc);
                this.psmsplatformfunc = pSMSPlatformFunc;
            }
            return this.psmsplatformfunc;
        }
    }

    private PSDCMSPlatformFuncBase getProxyEntity() {
        return this.proxyPSDCMSPlatformFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMSPlatformFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMSPlatformFuncBase) {
            this.proxyPSDCMSPlatformFuncBase = (PSDCMSPlatformFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_MAXCPU, 15);
        fieldIndexMap.put(FIELD_MAXMEM, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_MINCPU, 18);
        fieldIndexMap.put(FIELD_MINMEM, 19);
        fieldIndexMap.put(FIELD_MSFUNCTYPE, 20);
        fieldIndexMap.put(FIELD_PASSWD, 21);
        fieldIndexMap.put(FIELD_PORT, 22);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMFUNCID, 23);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMFUNCNAME, 24);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 25);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 28);
        fieldIndexMap.put(FIELD_PSMSPLATFORMFUNCID, 29);
        fieldIndexMap.put(FIELD_PSMSPLATFORMFUNCNAME, 30);
        fieldIndexMap.put(FIELD_SERVICEURL, 31);
        fieldIndexMap.put(FIELD_SSHIPADDR, 32);
        fieldIndexMap.put(FIELD_SSHPORT, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 36);
        fieldIndexMap.put(FIELD_UPLOADPATH, 37);
        fieldIndexMap.put(FIELD_USERNAME, 38);
        fieldIndexMap.put(FIELD_VALIDFLAG, 39);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 40);
    }
}

