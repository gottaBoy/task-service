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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysSADetailBase.class);
    public static final String FIELD_AFTERCODE = "AFTERCODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DETAILID = "DETAILID";
    public static final String FIELD_DETAILPARAM = "DETAILPARAM";
    public static final String FIELD_DETAILPARAM2 = "DETAILPARAM2";
    public static final String FIELD_DETAILPARAMS = "DETAILPARAMS";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_INPSSUBSYSSADEID = "INPSSUBSYSSADEID";
    public static final String FIELD_INPSSUBSYSSADENAME = "INPSSUBSYSSADENAME";
    public static final String FIELD_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String FIELD_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String FIELD_KEYFIELDNAME = "KEYFIELDNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODCODE = "METHODCODE";
    public static final String FIELD_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";
    public static final String FIELD_NOSERVICECODENAME = "NOSERVICECODENAME";
    public static final String FIELD_OUTPSSUBSYSSADEID = "OUTPSSUBSYSSADEID";
    public static final String FIELD_OUTPSSUBSYSSADENAME = "OUTPSSUBSYSSADENAME";
    public static final String FIELD_OUTPSSYSDYNAMODELID = "OUTPSSYSDYNAMODELID";
    public static final String FIELD_OUTPSSYSDYNAMODELNAME = "OUTPSSYSDYNAMODELNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String FIELD_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String FIELD_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_REQUESTCONTENTTYPE = "REQUESTCONTENTTYPE";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String FIELD_RETPSSUBSYSSADEID = "RETPSSUBSYSSADEID";
    public static final String FIELD_RETPSSUBSYSSADENAME = "RETPSSUBSYSSADENAME";
    public static final String FIELD_RETSTDDATATYPE = "RETSTDDATATYPE";
    public static final String FIELD_RETVALTYPE = "RETVALTYPE";
    public static final String FIELD_SERVICEURL = "SERVICEURL";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AFTERCODE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAME2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMCODE = 5;
    private static final int INDEX_CUSTOMMODE = 6;
    private static final int INDEX_DETAILID = 7;
    private static final int INDEX_DETAILPARAM = 8;
    private static final int INDEX_DETAILPARAM2 = 9;
    private static final int INDEX_DETAILPARAMS = 10;
    private static final int INDEX_DETAILTAG = 11;
    private static final int INDEX_DETAILTAG2 = 12;
    private static final int INDEX_DETAILTYPE = 13;
    private static final int INDEX_INPSSUBSYSSADEID = 14;
    private static final int INDEX_INPSSUBSYSSADENAME = 15;
    private static final int INDEX_INPSSYSDYNAMODELID = 16;
    private static final int INDEX_INPSSYSDYNAMODELNAME = 17;
    private static final int INDEX_KEYFIELDNAME = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_METHODCODE = 20;
    private static final int INDEX_NEEDRESOURCEKEY = 21;
    private static final int INDEX_NOSERVICECODENAME = 22;
    private static final int INDEX_OUTPSSUBSYSSADEID = 23;
    private static final int INDEX_OUTPSSUBSYSSADENAME = 24;
    private static final int INDEX_OUTPSSYSDYNAMODELID = 25;
    private static final int INDEX_OUTPSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSDELOGICNAME = 28;
    private static final int INDEX_PSDENAME = 29;
    private static final int INDEX_PSSUBSYSSADEID = 30;
    private static final int INDEX_PSSUBSYSSADENAME = 31;
    private static final int INDEX_PSSUBSYSSADETAILID = 32;
    private static final int INDEX_PSSUBSYSSADETAILNAME = 33;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 34;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 35;
    private static final int INDEX_PSSYSSFPLUGINID = 36;
    private static final int INDEX_PSSYSSFPLUGINNAME = 37;
    private static final int INDEX_REQUESTCONTENTTYPE = 38;
    private static final int INDEX_REQUESTMETHOD = 39;
    private static final int INDEX_REQUESTPARAMTYPE = 40;
    private static final int INDEX_RETPSSUBSYSSADEID = 41;
    private static final int INDEX_RETPSSUBSYSSADENAME = 42;
    private static final int INDEX_RETSTDDATATYPE = 43;
    private static final int INDEX_RETVALTYPE = 44;
    private static final int INDEX_SERVICEURL = 45;
    private static final int INDEX_UNIQUETAG = 46;
    private static final int INDEX_UPDATEDATE = 47;
    private static final int INDEX_UPDATEMAN = 48;
    private static final int INDEX_USERCAT = 49;
    private static final int INDEX_USERTAG = 50;
    private static final int INDEX_USERTAG2 = 51;
    private static final int INDEX_USERTAG3 = 52;
    private static final int INDEX_USERTAG4 = 53;
    private static final int INDEX_VALIDFLAG = 54;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysSADetailBase proxyPSSubSysSADetailBase = null;
    private boolean aftercodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean detailidDirtyFlag = false;
    private boolean detailparamDirtyFlag = false;
    private boolean detailparam2DirtyFlag = false;
    private boolean detailparamsDirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean inpssubsyssadeidDirtyFlag = false;
    private boolean inpssubsyssadenameDirtyFlag = false;
    private boolean inpssysdynamodelidDirtyFlag = false;
    private boolean inpssysdynamodelnameDirtyFlag = false;
    private boolean keyfieldnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodcodeDirtyFlag = false;
    private boolean needresourcekeyDirtyFlag = false;
    private boolean noservicecodenameDirtyFlag = false;
    private boolean outpssubsyssadeidDirtyFlag = false;
    private boolean outpssubsyssadenameDirtyFlag = false;
    private boolean outpssysdynamodelidDirtyFlag = false;
    private boolean outpssysdynamodelnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssubsyssadeidDirtyFlag = false;
    private boolean pssubsyssadenameDirtyFlag = false;
    private boolean pssubsyssadetailidDirtyFlag = false;
    private boolean pssubsyssadetailnameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean requestcontenttypeDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestparamtypeDirtyFlag = false;
    private boolean retpssubsyssadeidDirtyFlag = false;
    private boolean retpssubsyssadenameDirtyFlag = false;
    private boolean retstddatatypeDirtyFlag = false;
    private boolean retvaltypeDirtyFlag = false;
    private boolean serviceurlDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="aftercode")
    private String aftercode;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="detailid")
    private String detailid;
    @Column(name="detailparam")
    private String detailparam;
    @Column(name="detailparam2")
    private String detailparam2;
    @Column(name="detailparams")
    private String detailparams;
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="inpssubsyssadeid")
    private String inpssubsyssadeid;
    @Column(name="inpssubsyssadename")
    private String inpssubsyssadename;
    @Column(name="inpssysdynamodelid")
    private String inpssysdynamodelid;
    @Column(name="inpssysdynamodelname")
    private String inpssysdynamodelname;
    @Column(name="keyfieldname")
    private String keyfieldname;
    @Column(name="memo")
    private String memo;
    @Column(name="methodcode")
    private String methodcode;
    @Column(name="needresourcekey")
    private Integer needresourcekey;
    @Column(name="noservicecodename")
    private Integer noservicecodename;
    @Column(name="outpssubsyssadeid")
    private String outpssubsyssadeid;
    @Column(name="outpssubsyssadename")
    private String outpssubsyssadename;
    @Column(name="outpssysdynamodelid")
    private String outpssysdynamodelid;
    @Column(name="outpssysdynamodelname")
    private String outpssysdynamodelname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssubsyssadeid")
    private String pssubsyssadeid;
    @Column(name="pssubsyssadename")
    private String pssubsyssadename;
    @Column(name="pssubsyssadetailid")
    private String pssubsyssadetailid;
    @Column(name="pssubsyssadetailname")
    private String pssubsyssadetailname;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="requestcontenttype")
    private String requestcontenttype;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestparamtype")
    private String requestparamtype;
    @Column(name="retpssubsyssadeid")
    private String retpssubsyssadeid;
    @Column(name="retpssubsyssadename")
    private String retpssubsyssadename;
    @Column(name="retstddatatype")
    private Integer retstddatatype;
    @Column(name="retvaltype")
    private String retvaltype;
    @Column(name="serviceurl")
    private String serviceurl;
    @Column(name="uniquetag")
    private String uniquetag;
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
    private Integer objInPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE inpssubsyssade = null;
    private Integer objOutPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE outpssubsyssade = null;
    private Integer objPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE pssubsyssade = null;
    private Integer objRetPSSubSysSADELock = new Integer(1);
    private PSSubSysSADE retpssubsyssade = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objInPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel inpssysdynamodel = null;
    private Integer objOutPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel outpssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSubSysSADetailParamsLock = new Integer(1);
    private ArrayList<PSSubSysSADetailParam> pssubsyssadetailparams = null;

    public void setAfterCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aftercode = string;
        this.aftercodeDirtyFlag = true;
    }

    public String getAfterCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterCode();
        }
        return this.aftercode;
    }

    public boolean isAfterCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterCodeDirty();
        }
        return this.aftercodeDirtyFlag;
    }

    public void resetAfterCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterCode();
            return;
        }
        this.aftercodeDirtyFlag = false;
        this.aftercode = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailid = string;
        this.detailidDirtyFlag = true;
    }

    public String getDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailId();
        }
        return this.detailid;
    }

    public boolean isDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailIdDirty();
        }
        return this.detailidDirtyFlag;
    }

    public void resetDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailId();
            return;
        }
        this.detailidDirtyFlag = false;
        this.detailid = null;
    }

    public void setDetailParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam = string;
        this.detailparamDirtyFlag = true;
    }

    public String getDetailParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam();
        }
        return this.detailparam;
    }

    public boolean isDetailParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParamDirty();
        }
        return this.detailparamDirtyFlag;
    }

    public void resetDetailParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam();
            return;
        }
        this.detailparamDirtyFlag = false;
        this.detailparam = null;
    }

    public void setDetailParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam2 = string;
        this.detailparam2DirtyFlag = true;
    }

    public String getDetailParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam2();
        }
        return this.detailparam2;
    }

    public boolean isDetailParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParam2Dirty();
        }
        return this.detailparam2DirtyFlag;
    }

    public void resetDetailParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam2();
            return;
        }
        this.detailparam2DirtyFlag = false;
        this.detailparam2 = null;
    }

    public void setDetailParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparams = string;
        this.detailparamsDirtyFlag = true;
    }

    public String getDetailParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParams();
        }
        return this.detailparams;
    }

    public boolean isDetailParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParamsDirty();
        }
        return this.detailparamsDirtyFlag;
    }

    public void resetDetailParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParams();
            return;
        }
        this.detailparamsDirtyFlag = false;
        this.detailparams = null;
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

    public void setInPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssubsyssadeid = string;
        this.inpssubsyssadeidDirtyFlag = true;
    }

    public String getInPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSubSysSADEId();
        }
        return this.inpssubsyssadeid;
    }

    public boolean isInPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSubSysSADEIdDirty();
        }
        return this.inpssubsyssadeidDirtyFlag;
    }

    public void resetInPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSubSysSADEId();
            return;
        }
        this.inpssubsyssadeidDirtyFlag = false;
        this.inpssubsyssadeid = null;
    }

    public void setInPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssubsyssadename = string;
        this.inpssubsyssadenameDirtyFlag = true;
    }

    public String getInPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSubSysSADEName();
        }
        return this.inpssubsyssadename;
    }

    public boolean isInPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSubSysSADENameDirty();
        }
        return this.inpssubsyssadenameDirtyFlag;
    }

    public void resetInPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSubSysSADEName();
            return;
        }
        this.inpssubsyssadenameDirtyFlag = false;
        this.inpssubsyssadename = null;
    }

    public void setInPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdynamodelid = string;
        this.inpssysdynamodelidDirtyFlag = true;
    }

    public String getInPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModelId();
        }
        return this.inpssysdynamodelid;
    }

    public boolean isInPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDynaModelIdDirty();
        }
        return this.inpssysdynamodelidDirtyFlag;
    }

    public void resetInPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDynaModelId();
            return;
        }
        this.inpssysdynamodelidDirtyFlag = false;
        this.inpssysdynamodelid = null;
    }

    public void setInPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdynamodelname = string;
        this.inpssysdynamodelnameDirtyFlag = true;
    }

    public String getInPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModelName();
        }
        return this.inpssysdynamodelname;
    }

    public boolean isInPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDynaModelNameDirty();
        }
        return this.inpssysdynamodelnameDirtyFlag;
    }

    public void resetInPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDynaModelName();
            return;
        }
        this.inpssysdynamodelnameDirtyFlag = false;
        this.inpssysdynamodelname = null;
    }

    public void setKeyFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keyfieldname = string;
        this.keyfieldnameDirtyFlag = true;
    }

    public String getKeyFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyFieldName();
        }
        return this.keyfieldname;
    }

    public boolean isKeyFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyFieldNameDirty();
        }
        return this.keyfieldnameDirtyFlag;
    }

    public void resetKeyFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyFieldName();
            return;
        }
        this.keyfieldnameDirtyFlag = false;
        this.keyfieldname = null;
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

    public void setMethodCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMethodCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.methodcode = string;
        this.methodcodeDirtyFlag = true;
    }

    public String getMethodCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMethodCode();
        }
        return this.methodcode;
    }

    public boolean isMethodCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMethodCodeDirty();
        }
        return this.methodcodeDirtyFlag;
    }

    public void resetMethodCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMethodCode();
            return;
        }
        this.methodcodeDirtyFlag = false;
        this.methodcode = null;
    }

    public void setNeedResourceKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNeedResourceKey(n);
            return;
        }
        this.needresourcekey = n;
        this.needresourcekeyDirtyFlag = true;
    }

    public Integer getNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNeedResourceKey();
        }
        return this.needresourcekey;
    }

    public boolean isNeedResourceKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNeedResourceKeyDirty();
        }
        return this.needresourcekeyDirtyFlag;
    }

    public void resetNeedResourceKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNeedResourceKey();
            return;
        }
        this.needresourcekeyDirtyFlag = false;
        this.needresourcekey = null;
    }

    public void setNoServiceCodeName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoServiceCodeName(n);
            return;
        }
        this.noservicecodename = n;
        this.noservicecodenameDirtyFlag = true;
    }

    public Integer getNoServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoServiceCodeName();
        }
        return this.noservicecodename;
    }

    public boolean isNoServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoServiceCodeNameDirty();
        }
        return this.noservicecodenameDirtyFlag;
    }

    public void resetNoServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoServiceCodeName();
            return;
        }
        this.noservicecodenameDirtyFlag = false;
        this.noservicecodename = null;
    }

    public void setOutPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssubsyssadeid = string;
        this.outpssubsyssadeidDirtyFlag = true;
    }

    public String getOutPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSubSysSADEId();
        }
        return this.outpssubsyssadeid;
    }

    public boolean isOutPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSubSysSADEIdDirty();
        }
        return this.outpssubsyssadeidDirtyFlag;
    }

    public void resetOutPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSubSysSADEId();
            return;
        }
        this.outpssubsyssadeidDirtyFlag = false;
        this.outpssubsyssadeid = null;
    }

    public void setOutPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssubsyssadename = string;
        this.outpssubsyssadenameDirtyFlag = true;
    }

    public String getOutPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSubSysSADEName();
        }
        return this.outpssubsyssadename;
    }

    public boolean isOutPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSubSysSADENameDirty();
        }
        return this.outpssubsyssadenameDirtyFlag;
    }

    public void resetOutPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSubSysSADEName();
            return;
        }
        this.outpssubsyssadenameDirtyFlag = false;
        this.outpssubsyssadename = null;
    }

    public void setOutPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdynamodelid = string;
        this.outpssysdynamodelidDirtyFlag = true;
    }

    public String getOutPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModelId();
        }
        return this.outpssysdynamodelid;
    }

    public boolean isOutPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDynaModelIdDirty();
        }
        return this.outpssysdynamodelidDirtyFlag;
    }

    public void resetOutPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDynaModelId();
            return;
        }
        this.outpssysdynamodelidDirtyFlag = false;
        this.outpssysdynamodelid = null;
    }

    public void setOutPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdynamodelname = string;
        this.outpssysdynamodelnameDirtyFlag = true;
    }

    public String getOutPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModelName();
        }
        return this.outpssysdynamodelname;
    }

    public boolean isOutPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDynaModelNameDirty();
        }
        return this.outpssysdynamodelnameDirtyFlag;
    }

    public void resetOutPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDynaModelName();
            return;
        }
        this.outpssysdynamodelnameDirtyFlag = false;
        this.outpssysdynamodelname = null;
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

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadeid = string;
        this.pssubsyssadeidDirtyFlag = true;
    }

    public String getPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEId();
        }
        return this.pssubsyssadeid;
    }

    public boolean isPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADEIdDirty();
        }
        return this.pssubsyssadeidDirtyFlag;
    }

    public void resetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEId();
            return;
        }
        this.pssubsyssadeidDirtyFlag = false;
        this.pssubsyssadeid = null;
    }

    public void setPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadename = string;
        this.pssubsyssadenameDirtyFlag = true;
    }

    public String getPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADEName();
        }
        return this.pssubsyssadename;
    }

    public boolean isPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADENameDirty();
        }
        return this.pssubsyssadenameDirtyFlag;
    }

    public void resetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADEName();
            return;
        }
        this.pssubsyssadenameDirtyFlag = false;
        this.pssubsyssadename = null;
    }

    public void setPSSubSysSADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailid = string;
        this.pssubsyssadetailidDirtyFlag = true;
    }

    public String getPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailId();
        }
        return this.pssubsyssadetailid;
    }

    public boolean isPSSubSysSADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailIdDirty();
        }
        return this.pssubsyssadetailidDirtyFlag;
    }

    public void resetPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailId();
            return;
        }
        this.pssubsyssadetailidDirtyFlag = false;
        this.pssubsyssadetailid = null;
    }

    public void setPSSubSysSADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailname = string;
        this.pssubsyssadetailnameDirtyFlag = true;
    }

    public String getPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailName();
        }
        return this.pssubsyssadetailname;
    }

    public boolean isPSSubSysSADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailNameDirty();
        }
        return this.pssubsyssadetailnameDirtyFlag;
    }

    public void resetPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailName();
            return;
        }
        this.pssubsyssadetailnameDirtyFlag = false;
        this.pssubsyssadetailname = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setRequestContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestcontenttype = string;
        this.requestcontenttypeDirtyFlag = true;
    }

    public String getRequestContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestContentType();
        }
        return this.requestcontenttype;
    }

    public boolean isRequestContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestContentTypeDirty();
        }
        return this.requestcontenttypeDirtyFlag;
    }

    public void resetRequestContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestContentType();
            return;
        }
        this.requestcontenttypeDirtyFlag = false;
        this.requestcontenttype = null;
    }

    public void setRequestMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestmethod = string;
        this.requestmethodDirtyFlag = true;
    }

    public String getRequestMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestMethod();
        }
        return this.requestmethod;
    }

    public boolean isRequestMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestMethodDirty();
        }
        return this.requestmethodDirtyFlag;
    }

    public void resetRequestMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestMethod();
            return;
        }
        this.requestmethodDirtyFlag = false;
        this.requestmethod = null;
    }

    public void setRequestParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestparamtype = string;
        this.requestparamtypeDirtyFlag = true;
    }

    public String getRequestParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestParamType();
        }
        return this.requestparamtype;
    }

    public boolean isRequestParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestParamTypeDirty();
        }
        return this.requestparamtypeDirtyFlag;
    }

    public void resetRequestParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestParamType();
            return;
        }
        this.requestparamtypeDirtyFlag = false;
        this.requestparamtype = null;
    }

    public void setRetPSSubSysSADEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetPSSubSysSADEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retpssubsyssadeid = string;
        this.retpssubsyssadeidDirtyFlag = true;
    }

    public String getRetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSSubSysSADEId();
        }
        return this.retpssubsyssadeid;
    }

    public boolean isRetPSSubSysSADEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetPSSubSysSADEIdDirty();
        }
        return this.retpssubsyssadeidDirtyFlag;
    }

    public void resetRetPSSubSysSADEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetPSSubSysSADEId();
            return;
        }
        this.retpssubsyssadeidDirtyFlag = false;
        this.retpssubsyssadeid = null;
    }

    public void setRetPSSubSysSADEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetPSSubSysSADEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retpssubsyssadename = string;
        this.retpssubsyssadenameDirtyFlag = true;
    }

    public String getRetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSSubSysSADEName();
        }
        return this.retpssubsyssadename;
    }

    public boolean isRetPSSubSysSADENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetPSSubSysSADENameDirty();
        }
        return this.retpssubsyssadenameDirtyFlag;
    }

    public void resetRetPSSubSysSADEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetPSSubSysSADEName();
            return;
        }
        this.retpssubsyssadenameDirtyFlag = false;
        this.retpssubsyssadename = null;
    }

    public void setRetStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetStdDataType(n);
            return;
        }
        this.retstddatatype = n;
        this.retstddatatypeDirtyFlag = true;
    }

    public Integer getRetStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetStdDataType();
        }
        return this.retstddatatype;
    }

    public boolean isRetStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetStdDataTypeDirty();
        }
        return this.retstddatatypeDirtyFlag;
    }

    public void resetRetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetStdDataType();
            return;
        }
        this.retstddatatypeDirtyFlag = false;
        this.retstddatatype = null;
    }

    public void setRetValType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetValType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retvaltype = string;
        this.retvaltypeDirtyFlag = true;
    }

    public String getRetValType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetValType();
        }
        return this.retvaltype;
    }

    public boolean isRetValTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetValTypeDirty();
        }
        return this.retvaltypeDirtyFlag;
    }

    public void resetRetValType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetValType();
            return;
        }
        this.retvaltypeDirtyFlag = false;
        this.retvaltype = null;
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

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
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
        PSSubSysSADetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysSADetailBase pSSubSysSADetailBase) {
        pSSubSysSADetailBase.resetAfterCode();
        pSSubSysSADetailBase.resetCodeName();
        pSSubSysSADetailBase.resetCodeName2();
        pSSubSysSADetailBase.resetCreateDate();
        pSSubSysSADetailBase.resetCreateMan();
        pSSubSysSADetailBase.resetCustomCode();
        pSSubSysSADetailBase.resetCustomMode();
        pSSubSysSADetailBase.resetDetailId();
        pSSubSysSADetailBase.resetDetailParam();
        pSSubSysSADetailBase.resetDetailParam2();
        pSSubSysSADetailBase.resetDetailParams();
        pSSubSysSADetailBase.resetDetailTag();
        pSSubSysSADetailBase.resetDetailTag2();
        pSSubSysSADetailBase.resetDetailType();
        pSSubSysSADetailBase.resetInPSSubSysSADEId();
        pSSubSysSADetailBase.resetInPSSubSysSADEName();
        pSSubSysSADetailBase.resetInPSSysDynaModelId();
        pSSubSysSADetailBase.resetInPSSysDynaModelName();
        pSSubSysSADetailBase.resetKeyFieldName();
        pSSubSysSADetailBase.resetMemo();
        pSSubSysSADetailBase.resetMethodCode();
        pSSubSysSADetailBase.resetNeedResourceKey();
        pSSubSysSADetailBase.resetNoServiceCodeName();
        pSSubSysSADetailBase.resetOutPSSubSysSADEId();
        pSSubSysSADetailBase.resetOutPSSubSysSADEName();
        pSSubSysSADetailBase.resetOutPSSysDynaModelId();
        pSSubSysSADetailBase.resetOutPSSysDynaModelName();
        pSSubSysSADetailBase.resetPSDEId();
        pSSubSysSADetailBase.resetPSDELogicName();
        pSSubSysSADetailBase.resetPSDEName();
        pSSubSysSADetailBase.resetPSSubSysSADEId();
        pSSubSysSADetailBase.resetPSSubSysSADEName();
        pSSubSysSADetailBase.resetPSSubSysSADetailId();
        pSSubSysSADetailBase.resetPSSubSysSADetailName();
        pSSubSysSADetailBase.resetPSSubSysServiceAPIId();
        pSSubSysSADetailBase.resetPSSubSysServiceAPIName();
        pSSubSysSADetailBase.resetPSSysSFPluginId();
        pSSubSysSADetailBase.resetPSSysSFPluginName();
        pSSubSysSADetailBase.resetRequestContentType();
        pSSubSysSADetailBase.resetRequestMethod();
        pSSubSysSADetailBase.resetRequestParamType();
        pSSubSysSADetailBase.resetRetPSSubSysSADEId();
        pSSubSysSADetailBase.resetRetPSSubSysSADEName();
        pSSubSysSADetailBase.resetRetStdDataType();
        pSSubSysSADetailBase.resetRetValType();
        pSSubSysSADetailBase.resetServiceUrl();
        pSSubSysSADetailBase.resetUniqueTag();
        pSSubSysSADetailBase.resetUpdateDate();
        pSSubSysSADetailBase.resetUpdateMan();
        pSSubSysSADetailBase.resetUserCat();
        pSSubSysSADetailBase.resetUserTag();
        pSSubSysSADetailBase.resetUserTag2();
        pSSubSysSADetailBase.resetUserTag3();
        pSSubSysSADetailBase.resetUserTag4();
        pSSubSysSADetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAfterCodeDirty()) {
            hashMap.put(FIELD_AFTERCODE, this.getAfterCode());
        }
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDetailIdDirty()) {
            hashMap.put(FIELD_DETAILID, this.getDetailId());
        }
        if (!bl || this.isDetailParamDirty()) {
            hashMap.put(FIELD_DETAILPARAM, this.getDetailParam());
        }
        if (!bl || this.isDetailParam2Dirty()) {
            hashMap.put(FIELD_DETAILPARAM2, this.getDetailParam2());
        }
        if (!bl || this.isDetailParamsDirty()) {
            hashMap.put(FIELD_DETAILPARAMS, this.getDetailParams());
        }
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isInPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_INPSSUBSYSSADEID, this.getInPSSubSysSADEId());
        }
        if (!bl || this.isInPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_INPSSUBSYSSADENAME, this.getInPSSubSysSADEName());
        }
        if (!bl || this.isInPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_INPSSYSDYNAMODELID, this.getInPSSysDynaModelId());
        }
        if (!bl || this.isInPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_INPSSYSDYNAMODELNAME, this.getInPSSysDynaModelName());
        }
        if (!bl || this.isKeyFieldNameDirty()) {
            hashMap.put(FIELD_KEYFIELDNAME, this.getKeyFieldName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodCodeDirty()) {
            hashMap.put(FIELD_METHODCODE, this.getMethodCode());
        }
        if (!bl || this.isNeedResourceKeyDirty()) {
            hashMap.put(FIELD_NEEDRESOURCEKEY, this.getNeedResourceKey());
        }
        if (!bl || this.isNoServiceCodeNameDirty()) {
            hashMap.put(FIELD_NOSERVICECODENAME, this.getNoServiceCodeName());
        }
        if (!bl || this.isOutPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_OUTPSSUBSYSSADEID, this.getOutPSSubSysSADEId());
        }
        if (!bl || this.isOutPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_OUTPSSUBSYSSADENAME, this.getOutPSSubSysSADEName());
        }
        if (!bl || this.isOutPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSDYNAMODELID, this.getOutPSSysDynaModelId());
        }
        if (!bl || this.isOutPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSDYNAMODELNAME, this.getOutPSSysDynaModelName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADEID, this.getPSSubSysSADEId());
        }
        if (!bl || this.isPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADENAME, this.getPSSubSysSADEName());
        }
        if (!bl || this.isPSSubSysSADetailIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILID, this.getPSSubSysSADetailId());
        }
        if (!bl || this.isPSSubSysSADetailNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILNAME, this.getPSSubSysSADetailName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isRequestContentTypeDirty()) {
            hashMap.put(FIELD_REQUESTCONTENTTYPE, this.getRequestContentType());
        }
        if (!bl || this.isRequestMethodDirty()) {
            hashMap.put(FIELD_REQUESTMETHOD, this.getRequestMethod());
        }
        if (!bl || this.isRequestParamTypeDirty()) {
            hashMap.put(FIELD_REQUESTPARAMTYPE, this.getRequestParamType());
        }
        if (!bl || this.isRetPSSubSysSADEIdDirty()) {
            hashMap.put(FIELD_RETPSSUBSYSSADEID, this.getRetPSSubSysSADEId());
        }
        if (!bl || this.isRetPSSubSysSADENameDirty()) {
            hashMap.put(FIELD_RETPSSUBSYSSADENAME, this.getRetPSSubSysSADEName());
        }
        if (!bl || this.isRetStdDataTypeDirty()) {
            hashMap.put(FIELD_RETSTDDATATYPE, this.getRetStdDataType());
        }
        if (!bl || this.isRetValTypeDirty()) {
            hashMap.put(FIELD_RETVALTYPE, this.getRetValType());
        }
        if (!bl || this.isServiceUrlDirty()) {
            hashMap.put(FIELD_SERVICEURL, this.getServiceUrl());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        return PSSubSysSADetailBase.get(this, n);
    }

    private static Object get(PSSubSysSADetailBase pSSubSysSADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailBase.getAfterCode();
            }
            case 1: {
                return pSSubSysSADetailBase.getCodeName();
            }
            case 2: {
                return pSSubSysSADetailBase.getCodeName2();
            }
            case 3: {
                return pSSubSysSADetailBase.getCreateDate();
            }
            case 4: {
                return pSSubSysSADetailBase.getCreateMan();
            }
            case 5: {
                return pSSubSysSADetailBase.getCustomCode();
            }
            case 6: {
                return pSSubSysSADetailBase.getCustomMode();
            }
            case 7: {
                return pSSubSysSADetailBase.getDetailId();
            }
            case 8: {
                return pSSubSysSADetailBase.getDetailParam();
            }
            case 9: {
                return pSSubSysSADetailBase.getDetailParam2();
            }
            case 10: {
                return pSSubSysSADetailBase.getDetailParams();
            }
            case 11: {
                return pSSubSysSADetailBase.getDetailTag();
            }
            case 12: {
                return pSSubSysSADetailBase.getDetailTag2();
            }
            case 13: {
                return pSSubSysSADetailBase.getDetailType();
            }
            case 14: {
                return pSSubSysSADetailBase.getInPSSubSysSADEId();
            }
            case 15: {
                return pSSubSysSADetailBase.getInPSSubSysSADEName();
            }
            case 16: {
                return pSSubSysSADetailBase.getInPSSysDynaModelId();
            }
            case 17: {
                return pSSubSysSADetailBase.getInPSSysDynaModelName();
            }
            case 18: {
                return pSSubSysSADetailBase.getKeyFieldName();
            }
            case 19: {
                return pSSubSysSADetailBase.getMemo();
            }
            case 20: {
                return pSSubSysSADetailBase.getMethodCode();
            }
            case 21: {
                return pSSubSysSADetailBase.getNeedResourceKey();
            }
            case 22: {
                return pSSubSysSADetailBase.getNoServiceCodeName();
            }
            case 23: {
                return pSSubSysSADetailBase.getOutPSSubSysSADEId();
            }
            case 24: {
                return pSSubSysSADetailBase.getOutPSSubSysSADEName();
            }
            case 25: {
                return pSSubSysSADetailBase.getOutPSSysDynaModelId();
            }
            case 26: {
                return pSSubSysSADetailBase.getOutPSSysDynaModelName();
            }
            case 27: {
                return pSSubSysSADetailBase.getPSDEId();
            }
            case 28: {
                return pSSubSysSADetailBase.getPSDELogicName();
            }
            case 29: {
                return pSSubSysSADetailBase.getPSDEName();
            }
            case 30: {
                return pSSubSysSADetailBase.getPSSubSysSADEId();
            }
            case 31: {
                return pSSubSysSADetailBase.getPSSubSysSADEName();
            }
            case 32: {
                return pSSubSysSADetailBase.getPSSubSysSADetailId();
            }
            case 33: {
                return pSSubSysSADetailBase.getPSSubSysSADetailName();
            }
            case 34: {
                return pSSubSysSADetailBase.getPSSubSysServiceAPIId();
            }
            case 35: {
                return pSSubSysSADetailBase.getPSSubSysServiceAPIName();
            }
            case 36: {
                return pSSubSysSADetailBase.getPSSysSFPluginId();
            }
            case 37: {
                return pSSubSysSADetailBase.getPSSysSFPluginName();
            }
            case 38: {
                return pSSubSysSADetailBase.getRequestContentType();
            }
            case 39: {
                return pSSubSysSADetailBase.getRequestMethod();
            }
            case 40: {
                return pSSubSysSADetailBase.getRequestParamType();
            }
            case 41: {
                return pSSubSysSADetailBase.getRetPSSubSysSADEId();
            }
            case 42: {
                return pSSubSysSADetailBase.getRetPSSubSysSADEName();
            }
            case 43: {
                return pSSubSysSADetailBase.getRetStdDataType();
            }
            case 44: {
                return pSSubSysSADetailBase.getRetValType();
            }
            case 45: {
                return pSSubSysSADetailBase.getServiceUrl();
            }
            case 46: {
                return pSSubSysSADetailBase.getUniqueTag();
            }
            case 47: {
                return pSSubSysSADetailBase.getUpdateDate();
            }
            case 48: {
                return pSSubSysSADetailBase.getUpdateMan();
            }
            case 49: {
                return pSSubSysSADetailBase.getUserCat();
            }
            case 50: {
                return pSSubSysSADetailBase.getUserTag();
            }
            case 51: {
                return pSSubSysSADetailBase.getUserTag2();
            }
            case 52: {
                return pSSubSysSADetailBase.getUserTag3();
            }
            case 53: {
                return pSSubSysSADetailBase.getUserTag4();
            }
            case 54: {
                return pSSubSysSADetailBase.getValidFlag();
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
        PSSubSysSADetailBase.set(this, n, object);
    }

    private static void set(PSSubSysSADetailBase pSSubSysSADetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADetailBase.setAfterCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysSADetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysSADetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysSADetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysSADetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysSADetailBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysSADetailBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysSADetailBase.setDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysSADetailBase.setDetailParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysSADetailBase.setDetailParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysSADetailBase.setDetailParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysSADetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysSADetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysSADetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysSADetailBase.setInPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysSADetailBase.setInPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSubSysSADetailBase.setInPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSubSysSADetailBase.setInPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSubSysSADetailBase.setKeyFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSubSysSADetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSubSysSADetailBase.setMethodCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSubSysSADetailBase.setNeedResourceKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSubSysSADetailBase.setNoServiceCodeName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSubSysSADetailBase.setOutPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSubSysSADetailBase.setOutPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSubSysSADetailBase.setOutPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSubSysSADetailBase.setOutPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSubSysSADetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSubSysSADetailBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSubSysSADetailBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSubSysSADetailBase.setPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSubSysSADetailBase.setPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSubSysSADetailBase.setPSSubSysSADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSubSysSADetailBase.setPSSubSysSADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSubSysSADetailBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSubSysSADetailBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSubSysSADetailBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSubSysSADetailBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSubSysSADetailBase.setRequestContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSubSysSADetailBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSubSysSADetailBase.setRequestParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSubSysSADetailBase.setRetPSSubSysSADEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSubSysSADetailBase.setRetPSSubSysSADEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSubSysSADetailBase.setRetStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSubSysSADetailBase.setRetValType(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSubSysSADetailBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSubSysSADetailBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSubSysSADetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 48: {
                pSSubSysSADetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSubSysSADetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSubSysSADetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSubSysSADetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSubSysSADetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSubSysSADetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSubSysSADetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysSADetailBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysSADetailBase pSSubSysSADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailBase.getAfterCode() == null;
            }
            case 1: {
                return pSSubSysSADetailBase.getCodeName() == null;
            }
            case 2: {
                return pSSubSysSADetailBase.getCodeName2() == null;
            }
            case 3: {
                return pSSubSysSADetailBase.getCreateDate() == null;
            }
            case 4: {
                return pSSubSysSADetailBase.getCreateMan() == null;
            }
            case 5: {
                return pSSubSysSADetailBase.getCustomCode() == null;
            }
            case 6: {
                return pSSubSysSADetailBase.getCustomMode() == null;
            }
            case 7: {
                return pSSubSysSADetailBase.getDetailId() == null;
            }
            case 8: {
                return pSSubSysSADetailBase.getDetailParam() == null;
            }
            case 9: {
                return pSSubSysSADetailBase.getDetailParam2() == null;
            }
            case 10: {
                return pSSubSysSADetailBase.getDetailParams() == null;
            }
            case 11: {
                return pSSubSysSADetailBase.getDetailTag() == null;
            }
            case 12: {
                return pSSubSysSADetailBase.getDetailTag2() == null;
            }
            case 13: {
                return pSSubSysSADetailBase.getDetailType() == null;
            }
            case 14: {
                return pSSubSysSADetailBase.getInPSSubSysSADEId() == null;
            }
            case 15: {
                return pSSubSysSADetailBase.getInPSSubSysSADEName() == null;
            }
            case 16: {
                return pSSubSysSADetailBase.getInPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSubSysSADetailBase.getInPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSubSysSADetailBase.getKeyFieldName() == null;
            }
            case 19: {
                return pSSubSysSADetailBase.getMemo() == null;
            }
            case 20: {
                return pSSubSysSADetailBase.getMethodCode() == null;
            }
            case 21: {
                return pSSubSysSADetailBase.getNeedResourceKey() == null;
            }
            case 22: {
                return pSSubSysSADetailBase.getNoServiceCodeName() == null;
            }
            case 23: {
                return pSSubSysSADetailBase.getOutPSSubSysSADEId() == null;
            }
            case 24: {
                return pSSubSysSADetailBase.getOutPSSubSysSADEName() == null;
            }
            case 25: {
                return pSSubSysSADetailBase.getOutPSSysDynaModelId() == null;
            }
            case 26: {
                return pSSubSysSADetailBase.getOutPSSysDynaModelName() == null;
            }
            case 27: {
                return pSSubSysSADetailBase.getPSDEId() == null;
            }
            case 28: {
                return pSSubSysSADetailBase.getPSDELogicName() == null;
            }
            case 29: {
                return pSSubSysSADetailBase.getPSDEName() == null;
            }
            case 30: {
                return pSSubSysSADetailBase.getPSSubSysSADEId() == null;
            }
            case 31: {
                return pSSubSysSADetailBase.getPSSubSysSADEName() == null;
            }
            case 32: {
                return pSSubSysSADetailBase.getPSSubSysSADetailId() == null;
            }
            case 33: {
                return pSSubSysSADetailBase.getPSSubSysSADetailName() == null;
            }
            case 34: {
                return pSSubSysSADetailBase.getPSSubSysServiceAPIId() == null;
            }
            case 35: {
                return pSSubSysSADetailBase.getPSSubSysServiceAPIName() == null;
            }
            case 36: {
                return pSSubSysSADetailBase.getPSSysSFPluginId() == null;
            }
            case 37: {
                return pSSubSysSADetailBase.getPSSysSFPluginName() == null;
            }
            case 38: {
                return pSSubSysSADetailBase.getRequestContentType() == null;
            }
            case 39: {
                return pSSubSysSADetailBase.getRequestMethod() == null;
            }
            case 40: {
                return pSSubSysSADetailBase.getRequestParamType() == null;
            }
            case 41: {
                return pSSubSysSADetailBase.getRetPSSubSysSADEId() == null;
            }
            case 42: {
                return pSSubSysSADetailBase.getRetPSSubSysSADEName() == null;
            }
            case 43: {
                return pSSubSysSADetailBase.getRetStdDataType() == null;
            }
            case 44: {
                return pSSubSysSADetailBase.getRetValType() == null;
            }
            case 45: {
                return pSSubSysSADetailBase.getServiceUrl() == null;
            }
            case 46: {
                return pSSubSysSADetailBase.getUniqueTag() == null;
            }
            case 47: {
                return pSSubSysSADetailBase.getUpdateDate() == null;
            }
            case 48: {
                return pSSubSysSADetailBase.getUpdateMan() == null;
            }
            case 49: {
                return pSSubSysSADetailBase.getUserCat() == null;
            }
            case 50: {
                return pSSubSysSADetailBase.getUserTag() == null;
            }
            case 51: {
                return pSSubSysSADetailBase.getUserTag2() == null;
            }
            case 52: {
                return pSSubSysSADetailBase.getUserTag3() == null;
            }
            case 53: {
                return pSSubSysSADetailBase.getUserTag4() == null;
            }
            case 54: {
                return pSSubSysSADetailBase.getValidFlag() == null;
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
        return PSSubSysSADetailBase.contains(this, n);
    }

    private static boolean contains(PSSubSysSADetailBase pSSubSysSADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysSADetailBase.isAfterCodeDirty();
            }
            case 1: {
                return pSSubSysSADetailBase.isCodeNameDirty();
            }
            case 2: {
                return pSSubSysSADetailBase.isCodeName2Dirty();
            }
            case 3: {
                return pSSubSysSADetailBase.isCreateDateDirty();
            }
            case 4: {
                return pSSubSysSADetailBase.isCreateManDirty();
            }
            case 5: {
                return pSSubSysSADetailBase.isCustomCodeDirty();
            }
            case 6: {
                return pSSubSysSADetailBase.isCustomModeDirty();
            }
            case 7: {
                return pSSubSysSADetailBase.isDetailIdDirty();
            }
            case 8: {
                return pSSubSysSADetailBase.isDetailParamDirty();
            }
            case 9: {
                return pSSubSysSADetailBase.isDetailParam2Dirty();
            }
            case 10: {
                return pSSubSysSADetailBase.isDetailParamsDirty();
            }
            case 11: {
                return pSSubSysSADetailBase.isDetailTagDirty();
            }
            case 12: {
                return pSSubSysSADetailBase.isDetailTag2Dirty();
            }
            case 13: {
                return pSSubSysSADetailBase.isDetailTypeDirty();
            }
            case 14: {
                return pSSubSysSADetailBase.isInPSSubSysSADEIdDirty();
            }
            case 15: {
                return pSSubSysSADetailBase.isInPSSubSysSADENameDirty();
            }
            case 16: {
                return pSSubSysSADetailBase.isInPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSubSysSADetailBase.isInPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSubSysSADetailBase.isKeyFieldNameDirty();
            }
            case 19: {
                return pSSubSysSADetailBase.isMemoDirty();
            }
            case 20: {
                return pSSubSysSADetailBase.isMethodCodeDirty();
            }
            case 21: {
                return pSSubSysSADetailBase.isNeedResourceKeyDirty();
            }
            case 22: {
                return pSSubSysSADetailBase.isNoServiceCodeNameDirty();
            }
            case 23: {
                return pSSubSysSADetailBase.isOutPSSubSysSADEIdDirty();
            }
            case 24: {
                return pSSubSysSADetailBase.isOutPSSubSysSADENameDirty();
            }
            case 25: {
                return pSSubSysSADetailBase.isOutPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSSubSysSADetailBase.isOutPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSSubSysSADetailBase.isPSDEIdDirty();
            }
            case 28: {
                return pSSubSysSADetailBase.isPSDELogicNameDirty();
            }
            case 29: {
                return pSSubSysSADetailBase.isPSDENameDirty();
            }
            case 30: {
                return pSSubSysSADetailBase.isPSSubSysSADEIdDirty();
            }
            case 31: {
                return pSSubSysSADetailBase.isPSSubSysSADENameDirty();
            }
            case 32: {
                return pSSubSysSADetailBase.isPSSubSysSADetailIdDirty();
            }
            case 33: {
                return pSSubSysSADetailBase.isPSSubSysSADetailNameDirty();
            }
            case 34: {
                return pSSubSysSADetailBase.isPSSubSysServiceAPIIdDirty();
            }
            case 35: {
                return pSSubSysSADetailBase.isPSSubSysServiceAPINameDirty();
            }
            case 36: {
                return pSSubSysSADetailBase.isPSSysSFPluginIdDirty();
            }
            case 37: {
                return pSSubSysSADetailBase.isPSSysSFPluginNameDirty();
            }
            case 38: {
                return pSSubSysSADetailBase.isRequestContentTypeDirty();
            }
            case 39: {
                return pSSubSysSADetailBase.isRequestMethodDirty();
            }
            case 40: {
                return pSSubSysSADetailBase.isRequestParamTypeDirty();
            }
            case 41: {
                return pSSubSysSADetailBase.isRetPSSubSysSADEIdDirty();
            }
            case 42: {
                return pSSubSysSADetailBase.isRetPSSubSysSADENameDirty();
            }
            case 43: {
                return pSSubSysSADetailBase.isRetStdDataTypeDirty();
            }
            case 44: {
                return pSSubSysSADetailBase.isRetValTypeDirty();
            }
            case 45: {
                return pSSubSysSADetailBase.isServiceUrlDirty();
            }
            case 46: {
                return pSSubSysSADetailBase.isUniqueTagDirty();
            }
            case 47: {
                return pSSubSysSADetailBase.isUpdateDateDirty();
            }
            case 48: {
                return pSSubSysSADetailBase.isUpdateManDirty();
            }
            case 49: {
                return pSSubSysSADetailBase.isUserCatDirty();
            }
            case 50: {
                return pSSubSysSADetailBase.isUserTagDirty();
            }
            case 51: {
                return pSSubSysSADetailBase.isUserTag2Dirty();
            }
            case 52: {
                return pSSubSysSADetailBase.isUserTag3Dirty();
            }
            case 53: {
                return pSSubSysSADetailBase.isUserTag4Dirty();
            }
            case 54: {
                return pSSubSysSADetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysSADetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysSADetailBase pSSubSysSADetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysSADetailBase.getAfterCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aftercode", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getAfterCode()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailParam()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam2", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailParam2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparams", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailParams()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getInPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssubsyssadeid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getInPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getInPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssubsyssadename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getInPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getInPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getInPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getInPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdynamodelname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getInPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getKeyFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keyfieldname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getKeyFieldName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getMethodCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodcode", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getMethodCode()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getNeedResourceKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needresourcekey", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getNeedResourceKey()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getNoServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noservicecodename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getNoServiceCodeName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssubsyssadeid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getOutPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssubsyssadename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getOutPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdynamodelid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getOutPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdynamodelname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getOutPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadeid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysSADetailId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysSADetailName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRequestContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestcontenttype", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRequestContentType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRequestParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestparamtype", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRequestParamType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRetPSSubSysSADEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retpssubsyssadeid", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRetPSSubSysSADEId()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRetPSSubSysSADEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retpssubsyssadename", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRetPSSubSysSADEName()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRetStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retstddatatype", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRetStdDataType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getRetValType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retvaltype", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getRetValType()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSubSysSADetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysSADetailBase.getJSONValue((Object)pSSubSysSADetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysSADetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysSADetailBase pSSubSysSADetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysSADetailBase.getAfterCode() != null) {
            object = pSSubSysSADetailBase.getAfterCode();
            xmlNode.setAttribute(FIELD_AFTERCODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSubSysSADetailBase.getCodeName() != null) {
            object = pSSubSysSADetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSubSysSADetailBase.getCodeName2() != null) {
            object = pSSubSysSADetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getCreateDate() != null) {
            object = pSSubSysSADetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getCreateMan() != null) {
            object = pSSubSysSADetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getCustomCode() != null) {
            object = pSSubSysSADetailBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getCustomMode() != null) {
            object = pSSubSysSADetailBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getDetailId() != null) {
            object = pSSubSysSADetailBase.getDetailId();
            xmlNode.setAttribute(FIELD_DETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailParam() != null) {
            object = pSSubSysSADetailBase.getDetailParam();
            xmlNode.setAttribute(FIELD_DETAILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailParam2() != null) {
            object = pSSubSysSADetailBase.getDetailParam2();
            xmlNode.setAttribute(FIELD_DETAILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailParams() != null) {
            object = pSSubSysSADetailBase.getDetailParams();
            xmlNode.setAttribute(FIELD_DETAILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailTag() != null) {
            object = pSSubSysSADetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailTag2() != null) {
            object = pSSubSysSADetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getDetailType() != null) {
            object = pSSubSysSADetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getInPSSubSysSADEId() != null) {
            object = pSSubSysSADetailBase.getInPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_INPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getInPSSubSysSADEName() != null) {
            object = pSSubSysSADetailBase.getInPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_INPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getInPSSysDynaModelId() != null) {
            object = pSSubSysSADetailBase.getInPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getInPSSysDynaModelName() != null) {
            object = pSSubSysSADetailBase.getInPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_INPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getKeyFieldName() != null) {
            object = pSSubSysSADetailBase.getKeyFieldName();
            xmlNode.setAttribute(FIELD_KEYFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getMemo() != null) {
            object = pSSubSysSADetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getMethodCode() != null) {
            object = pSSubSysSADetailBase.getMethodCode();
            xmlNode.setAttribute(FIELD_METHODCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getNeedResourceKey() != null) {
            object = pSSubSysSADetailBase.getNeedResourceKey();
            xmlNode.setAttribute(FIELD_NEEDRESOURCEKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getNoServiceCodeName() != null) {
            object = pSSubSysSADetailBase.getNoServiceCodeName();
            xmlNode.setAttribute(FIELD_NOSERVICECODENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getOutPSSubSysSADEId() != null) {
            object = pSSubSysSADetailBase.getOutPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_OUTPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSubSysSADEName() != null) {
            object = pSSubSysSADetailBase.getOutPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_OUTPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSysDynaModelId() != null) {
            object = pSSubSysSADetailBase.getOutPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_OUTPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getOutPSSysDynaModelName() != null) {
            object = pSSubSysSADetailBase.getOutPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_OUTPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSDEId() != null) {
            object = pSSubSysSADetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSDELogicName() != null) {
            object = pSSubSysSADetailBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSDEName() != null) {
            object = pSSubSysSADetailBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADEId() != null) {
            object = pSSubSysSADetailBase.getPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADEName() != null) {
            object = pSSubSysSADetailBase.getPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADetailId() != null) {
            object = pSSubSysSADetailBase.getPSSubSysSADetailId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysSADetailName() != null) {
            object = pSSubSysSADetailBase.getPSSubSysSADetailName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIId() != null) {
            object = pSSubSysSADetailBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIName() != null) {
            object = pSSubSysSADetailBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSysSFPluginId() != null) {
            object = pSSubSysSADetailBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getPSSysSFPluginName() != null) {
            object = pSSubSysSADetailBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRequestContentType() != null) {
            object = pSSubSysSADetailBase.getRequestContentType();
            xmlNode.setAttribute(FIELD_REQUESTCONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRequestMethod() != null) {
            object = pSSubSysSADetailBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRequestParamType() != null) {
            object = pSSubSysSADetailBase.getRequestParamType();
            xmlNode.setAttribute(FIELD_REQUESTPARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRetPSSubSysSADEId() != null) {
            object = pSSubSysSADetailBase.getRetPSSubSysSADEId();
            xmlNode.setAttribute(FIELD_RETPSSUBSYSSADEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRetPSSubSysSADEName() != null) {
            object = pSSubSysSADetailBase.getRetPSSubSysSADEName();
            xmlNode.setAttribute(FIELD_RETPSSUBSYSSADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getRetStdDataType() != null) {
            object = pSSubSysSADetailBase.getRetStdDataType();
            xmlNode.setAttribute(FIELD_RETSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getRetValType() != null) {
            object = pSSubSysSADetailBase.getRetValType();
            xmlNode.setAttribute(FIELD_RETVALTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getServiceUrl() != null) {
            object = pSSubSysSADetailBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUniqueTag() != null) {
            object = pSSubSysSADetailBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUpdateDate() != null) {
            object = pSSubSysSADetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysSADetailBase.getUpdateMan() != null) {
            object = pSSubSysSADetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUserCat() != null) {
            object = pSSubSysSADetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUserTag() != null) {
            object = pSSubSysSADetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUserTag2() != null) {
            object = pSSubSysSADetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUserTag3() != null) {
            object = pSSubSysSADetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getUserTag4() != null) {
            object = pSSubSysSADetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysSADetailBase.getValidFlag() != null) {
            object = pSSubSysSADetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysSADetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysSADetailBase pSSubSysSADetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysSADetailBase.isAfterCodeDirty() && (bl || pSSubSysSADetailBase.getAfterCode() != null)) {
            iDataObject.set(FIELD_AFTERCODE, (Object)pSSubSysSADetailBase.getAfterCode());
        }
        if (pSSubSysSADetailBase.isCodeNameDirty() && (bl || pSSubSysSADetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubSysSADetailBase.getCodeName());
        }
        if (pSSubSysSADetailBase.isCodeName2Dirty() && (bl || pSSubSysSADetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSubSysSADetailBase.getCodeName2());
        }
        if (pSSubSysSADetailBase.isCreateDateDirty() && (bl || pSSubSysSADetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysSADetailBase.getCreateDate());
        }
        if (pSSubSysSADetailBase.isCreateManDirty() && (bl || pSSubSysSADetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysSADetailBase.getCreateMan());
        }
        if (pSSubSysSADetailBase.isCustomCodeDirty() && (bl || pSSubSysSADetailBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSubSysSADetailBase.getCustomCode());
        }
        if (pSSubSysSADetailBase.isCustomModeDirty() && (bl || pSSubSysSADetailBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSubSysSADetailBase.getCustomMode());
        }
        if (pSSubSysSADetailBase.isDetailIdDirty() && (bl || pSSubSysSADetailBase.getDetailId() != null)) {
            iDataObject.set(FIELD_DETAILID, (Object)pSSubSysSADetailBase.getDetailId());
        }
        if (pSSubSysSADetailBase.isDetailParamDirty() && (bl || pSSubSysSADetailBase.getDetailParam() != null)) {
            iDataObject.set(FIELD_DETAILPARAM, (Object)pSSubSysSADetailBase.getDetailParam());
        }
        if (pSSubSysSADetailBase.isDetailParam2Dirty() && (bl || pSSubSysSADetailBase.getDetailParam2() != null)) {
            iDataObject.set(FIELD_DETAILPARAM2, (Object)pSSubSysSADetailBase.getDetailParam2());
        }
        if (pSSubSysSADetailBase.isDetailParamsDirty() && (bl || pSSubSysSADetailBase.getDetailParams() != null)) {
            iDataObject.set(FIELD_DETAILPARAMS, (Object)pSSubSysSADetailBase.getDetailParams());
        }
        if (pSSubSysSADetailBase.isDetailTagDirty() && (bl || pSSubSysSADetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSSubSysSADetailBase.getDetailTag());
        }
        if (pSSubSysSADetailBase.isDetailTag2Dirty() && (bl || pSSubSysSADetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSSubSysSADetailBase.getDetailTag2());
        }
        if (pSSubSysSADetailBase.isDetailTypeDirty() && (bl || pSSubSysSADetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSSubSysSADetailBase.getDetailType());
        }
        if (pSSubSysSADetailBase.isInPSSubSysSADEIdDirty() && (bl || pSSubSysSADetailBase.getInPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_INPSSUBSYSSADEID, (Object)pSSubSysSADetailBase.getInPSSubSysSADEId());
        }
        if (pSSubSysSADetailBase.isInPSSubSysSADENameDirty() && (bl || pSSubSysSADetailBase.getInPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_INPSSUBSYSSADENAME, (Object)pSSubSysSADetailBase.getInPSSubSysSADEName());
        }
        if (pSSubSysSADetailBase.isInPSSysDynaModelIdDirty() && (bl || pSSubSysSADetailBase.getInPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELID, (Object)pSSubSysSADetailBase.getInPSSysDynaModelId());
        }
        if (pSSubSysSADetailBase.isInPSSysDynaModelNameDirty() && (bl || pSSubSysSADetailBase.getInPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_INPSSYSDYNAMODELNAME, (Object)pSSubSysSADetailBase.getInPSSysDynaModelName());
        }
        if (pSSubSysSADetailBase.isKeyFieldNameDirty() && (bl || pSSubSysSADetailBase.getKeyFieldName() != null)) {
            iDataObject.set(FIELD_KEYFIELDNAME, (Object)pSSubSysSADetailBase.getKeyFieldName());
        }
        if (pSSubSysSADetailBase.isMemoDirty() && (bl || pSSubSysSADetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysSADetailBase.getMemo());
        }
        if (pSSubSysSADetailBase.isMethodCodeDirty() && (bl || pSSubSysSADetailBase.getMethodCode() != null)) {
            iDataObject.set(FIELD_METHODCODE, (Object)pSSubSysSADetailBase.getMethodCode());
        }
        if (pSSubSysSADetailBase.isNeedResourceKeyDirty() && (bl || pSSubSysSADetailBase.getNeedResourceKey() != null)) {
            iDataObject.set(FIELD_NEEDRESOURCEKEY, (Object)pSSubSysSADetailBase.getNeedResourceKey());
        }
        if (pSSubSysSADetailBase.isNoServiceCodeNameDirty() && (bl || pSSubSysSADetailBase.getNoServiceCodeName() != null)) {
            iDataObject.set(FIELD_NOSERVICECODENAME, (Object)pSSubSysSADetailBase.getNoServiceCodeName());
        }
        if (pSSubSysSADetailBase.isOutPSSubSysSADEIdDirty() && (bl || pSSubSysSADetailBase.getOutPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_OUTPSSUBSYSSADEID, (Object)pSSubSysSADetailBase.getOutPSSubSysSADEId());
        }
        if (pSSubSysSADetailBase.isOutPSSubSysSADENameDirty() && (bl || pSSubSysSADetailBase.getOutPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_OUTPSSUBSYSSADENAME, (Object)pSSubSysSADetailBase.getOutPSSubSysSADEName());
        }
        if (pSSubSysSADetailBase.isOutPSSysDynaModelIdDirty() && (bl || pSSubSysSADetailBase.getOutPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDYNAMODELID, (Object)pSSubSysSADetailBase.getOutPSSysDynaModelId());
        }
        if (pSSubSysSADetailBase.isOutPSSysDynaModelNameDirty() && (bl || pSSubSysSADetailBase.getOutPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDYNAMODELNAME, (Object)pSSubSysSADetailBase.getOutPSSysDynaModelName());
        }
        if (pSSubSysSADetailBase.isPSDEIdDirty() && (bl || pSSubSysSADetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSubSysSADetailBase.getPSDEId());
        }
        if (pSSubSysSADetailBase.isPSDELogicNameDirty() && (bl || pSSubSysSADetailBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSubSysSADetailBase.getPSDELogicName());
        }
        if (pSSubSysSADetailBase.isPSDENameDirty() && (bl || pSSubSysSADetailBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSubSysSADetailBase.getPSDEName());
        }
        if (pSSubSysSADetailBase.isPSSubSysSADEIdDirty() && (bl || pSSubSysSADetailBase.getPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADEID, (Object)pSSubSysSADetailBase.getPSSubSysSADEId());
        }
        if (pSSubSysSADetailBase.isPSSubSysSADENameDirty() && (bl || pSSubSysSADetailBase.getPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADENAME, (Object)pSSubSysSADetailBase.getPSSubSysSADEName());
        }
        if (pSSubSysSADetailBase.isPSSubSysSADetailIdDirty() && (bl || pSSubSysSADetailBase.getPSSubSysSADetailId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILID, (Object)pSSubSysSADetailBase.getPSSubSysSADetailId());
        }
        if (pSSubSysSADetailBase.isPSSubSysSADetailNameDirty() && (bl || pSSubSysSADetailBase.getPSSubSysSADetailName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILNAME, (Object)pSSubSysSADetailBase.getPSSubSysSADetailName());
        }
        if (pSSubSysSADetailBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSubSysSADetailBase.getPSSubSysServiceAPIId());
        }
        if (pSSubSysSADetailBase.isPSSubSysServiceAPINameDirty() && (bl || pSSubSysSADetailBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSubSysSADetailBase.getPSSubSysServiceAPIName());
        }
        if (pSSubSysSADetailBase.isPSSysSFPluginIdDirty() && (bl || pSSubSysSADetailBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSubSysSADetailBase.getPSSysSFPluginId());
        }
        if (pSSubSysSADetailBase.isPSSysSFPluginNameDirty() && (bl || pSSubSysSADetailBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSubSysSADetailBase.getPSSysSFPluginName());
        }
        if (pSSubSysSADetailBase.isRequestContentTypeDirty() && (bl || pSSubSysSADetailBase.getRequestContentType() != null)) {
            iDataObject.set(FIELD_REQUESTCONTENTTYPE, (Object)pSSubSysSADetailBase.getRequestContentType());
        }
        if (pSSubSysSADetailBase.isRequestMethodDirty() && (bl || pSSubSysSADetailBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSSubSysSADetailBase.getRequestMethod());
        }
        if (pSSubSysSADetailBase.isRequestParamTypeDirty() && (bl || pSSubSysSADetailBase.getRequestParamType() != null)) {
            iDataObject.set(FIELD_REQUESTPARAMTYPE, (Object)pSSubSysSADetailBase.getRequestParamType());
        }
        if (pSSubSysSADetailBase.isRetPSSubSysSADEIdDirty() && (bl || pSSubSysSADetailBase.getRetPSSubSysSADEId() != null)) {
            iDataObject.set(FIELD_RETPSSUBSYSSADEID, (Object)pSSubSysSADetailBase.getRetPSSubSysSADEId());
        }
        if (pSSubSysSADetailBase.isRetPSSubSysSADENameDirty() && (bl || pSSubSysSADetailBase.getRetPSSubSysSADEName() != null)) {
            iDataObject.set(FIELD_RETPSSUBSYSSADENAME, (Object)pSSubSysSADetailBase.getRetPSSubSysSADEName());
        }
        if (pSSubSysSADetailBase.isRetStdDataTypeDirty() && (bl || pSSubSysSADetailBase.getRetStdDataType() != null)) {
            iDataObject.set(FIELD_RETSTDDATATYPE, (Object)pSSubSysSADetailBase.getRetStdDataType());
        }
        if (pSSubSysSADetailBase.isRetValTypeDirty() && (bl || pSSubSysSADetailBase.getRetValType() != null)) {
            iDataObject.set(FIELD_RETVALTYPE, (Object)pSSubSysSADetailBase.getRetValType());
        }
        if (pSSubSysSADetailBase.isServiceUrlDirty() && (bl || pSSubSysSADetailBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSSubSysSADetailBase.getServiceUrl());
        }
        if (pSSubSysSADetailBase.isUniqueTagDirty() && (bl || pSSubSysSADetailBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSSubSysSADetailBase.getUniqueTag());
        }
        if (pSSubSysSADetailBase.isUpdateDateDirty() && (bl || pSSubSysSADetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysSADetailBase.getUpdateDate());
        }
        if (pSSubSysSADetailBase.isUpdateManDirty() && (bl || pSSubSysSADetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysSADetailBase.getUpdateMan());
        }
        if (pSSubSysSADetailBase.isUserCatDirty() && (bl || pSSubSysSADetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSubSysSADetailBase.getUserCat());
        }
        if (pSSubSysSADetailBase.isUserTagDirty() && (bl || pSSubSysSADetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSubSysSADetailBase.getUserTag());
        }
        if (pSSubSysSADetailBase.isUserTag2Dirty() && (bl || pSSubSysSADetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSubSysSADetailBase.getUserTag2());
        }
        if (pSSubSysSADetailBase.isUserTag3Dirty() && (bl || pSSubSysSADetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSubSysSADetailBase.getUserTag3());
        }
        if (pSSubSysSADetailBase.isUserTag4Dirty() && (bl || pSSubSysSADetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSubSysSADetailBase.getUserTag4());
        }
        if (pSSubSysSADetailBase.isValidFlagDirty() && (bl || pSSubSysSADetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysSADetailBase.getValidFlag());
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
        return PSSubSysSADetailBase.remove(this, n);
    }

    private static boolean remove(PSSubSysSADetailBase pSSubSysSADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysSADetailBase.resetAfterCode();
                return true;
            }
            case 1: {
                pSSubSysSADetailBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSubSysSADetailBase.resetCodeName2();
                return true;
            }
            case 3: {
                pSSubSysSADetailBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSubSysSADetailBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSubSysSADetailBase.resetCustomCode();
                return true;
            }
            case 6: {
                pSSubSysSADetailBase.resetCustomMode();
                return true;
            }
            case 7: {
                pSSubSysSADetailBase.resetDetailId();
                return true;
            }
            case 8: {
                pSSubSysSADetailBase.resetDetailParam();
                return true;
            }
            case 9: {
                pSSubSysSADetailBase.resetDetailParam2();
                return true;
            }
            case 10: {
                pSSubSysSADetailBase.resetDetailParams();
                return true;
            }
            case 11: {
                pSSubSysSADetailBase.resetDetailTag();
                return true;
            }
            case 12: {
                pSSubSysSADetailBase.resetDetailTag2();
                return true;
            }
            case 13: {
                pSSubSysSADetailBase.resetDetailType();
                return true;
            }
            case 14: {
                pSSubSysSADetailBase.resetInPSSubSysSADEId();
                return true;
            }
            case 15: {
                pSSubSysSADetailBase.resetInPSSubSysSADEName();
                return true;
            }
            case 16: {
                pSSubSysSADetailBase.resetInPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSubSysSADetailBase.resetInPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSubSysSADetailBase.resetKeyFieldName();
                return true;
            }
            case 19: {
                pSSubSysSADetailBase.resetMemo();
                return true;
            }
            case 20: {
                pSSubSysSADetailBase.resetMethodCode();
                return true;
            }
            case 21: {
                pSSubSysSADetailBase.resetNeedResourceKey();
                return true;
            }
            case 22: {
                pSSubSysSADetailBase.resetNoServiceCodeName();
                return true;
            }
            case 23: {
                pSSubSysSADetailBase.resetOutPSSubSysSADEId();
                return true;
            }
            case 24: {
                pSSubSysSADetailBase.resetOutPSSubSysSADEName();
                return true;
            }
            case 25: {
                pSSubSysSADetailBase.resetOutPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSSubSysSADetailBase.resetOutPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSSubSysSADetailBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSSubSysSADetailBase.resetPSDELogicName();
                return true;
            }
            case 29: {
                pSSubSysSADetailBase.resetPSDEName();
                return true;
            }
            case 30: {
                pSSubSysSADetailBase.resetPSSubSysSADEId();
                return true;
            }
            case 31: {
                pSSubSysSADetailBase.resetPSSubSysSADEName();
                return true;
            }
            case 32: {
                pSSubSysSADetailBase.resetPSSubSysSADetailId();
                return true;
            }
            case 33: {
                pSSubSysSADetailBase.resetPSSubSysSADetailName();
                return true;
            }
            case 34: {
                pSSubSysSADetailBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 35: {
                pSSubSysSADetailBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 36: {
                pSSubSysSADetailBase.resetPSSysSFPluginId();
                return true;
            }
            case 37: {
                pSSubSysSADetailBase.resetPSSysSFPluginName();
                return true;
            }
            case 38: {
                pSSubSysSADetailBase.resetRequestContentType();
                return true;
            }
            case 39: {
                pSSubSysSADetailBase.resetRequestMethod();
                return true;
            }
            case 40: {
                pSSubSysSADetailBase.resetRequestParamType();
                return true;
            }
            case 41: {
                pSSubSysSADetailBase.resetRetPSSubSysSADEId();
                return true;
            }
            case 42: {
                pSSubSysSADetailBase.resetRetPSSubSysSADEName();
                return true;
            }
            case 43: {
                pSSubSysSADetailBase.resetRetStdDataType();
                return true;
            }
            case 44: {
                pSSubSysSADetailBase.resetRetValType();
                return true;
            }
            case 45: {
                pSSubSysSADetailBase.resetServiceUrl();
                return true;
            }
            case 46: {
                pSSubSysSADetailBase.resetUniqueTag();
                return true;
            }
            case 47: {
                pSSubSysSADetailBase.resetUpdateDate();
                return true;
            }
            case 48: {
                pSSubSysSADetailBase.resetUpdateMan();
                return true;
            }
            case 49: {
                pSSubSysSADetailBase.resetUserCat();
                return true;
            }
            case 50: {
                pSSubSysSADetailBase.resetUserTag();
                return true;
            }
            case 51: {
                pSSubSysSADetailBase.resetUserTag2();
                return true;
            }
            case 52: {
                pSSubSysSADetailBase.resetUserTag3();
                return true;
            }
            case 53: {
                pSSubSysSADetailBase.resetUserTag4();
                return true;
            }
            case 54: {
                pSSubSysSADetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getInPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSubSysSADE();
        }
        if (this.getInPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objInPSSubSysSADELock;
        synchronized (n) {
            if (this.inpssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getInPSSubSysSADEId(), (Object)this.inpssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.inpssubsyssade = null;
            }
            if (this.inpssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getInPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.inpssubsyssade = pSSubSysSADE;
            }
            return this.inpssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getOutPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSubSysSADE();
        }
        if (this.getOutPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objOutPSSubSysSADELock;
        synchronized (n) {
            if (this.outpssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSubSysSADEId(), (Object)this.outpssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.outpssubsyssade = null;
            }
            if (this.outpssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getOutPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.outpssubsyssade = pSSubSysSADE;
            }
            return this.outpssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADE();
        }
        if (this.getPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADELock;
        synchronized (n) {
            if (this.pssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADEId(), (Object)this.pssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.pssubsyssade = null;
            }
            if (this.pssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.pssubsyssade = pSSubSysSADE;
            }
            return this.pssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADE getRetPSSubSysSADE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSSubSysSADE();
        }
        if (this.getRetPSSubSysSADEId() == null) {
            return null;
        }
        Integer n = this.objRetPSSubSysSADELock;
        synchronized (n) {
            if (this.retpssubsyssade != null && DataTypeHelper.compare((int)25, (Object)this.getRetPSSubSysSADEId(), (Object)this.retpssubsyssade.getPSSubSysSADEId()) != 0L) {
                this.retpssubsyssade = null;
            }
            if (this.retpssubsyssade == null) {
                PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
                pSSubSysSADE.setPSSubSysSADEId(this.getRetPSSubSysSADEId());
                PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADEService.autoGet(pSSubSysSADE);
                this.retpssubsyssade = pSSubSysSADE;
            }
            return this.retpssubsyssade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getInPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDynaModel();
        }
        if (this.getInPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objInPSSysDynaModelLock;
        synchronized (n) {
            if (this.inpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getInPSSysDynaModelId(), (Object)this.inpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.inpssysdynamodel = null;
            }
            if (this.inpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getInPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.inpssysdynamodel = pSSysDynaModel;
            }
            return this.inpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getOutPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDynaModel();
        }
        if (this.getOutPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysDynaModelLock;
        synchronized (n) {
            if (this.outpssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysDynaModelId(), (Object)this.outpssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.outpssysdynamodel = null;
            }
            if (this.outpssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getOutPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.outpssysdynamodel = pSSysDynaModel;
            }
            return this.outpssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysSADetailParam> getPSSubSysSADetailParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailParams();
        }
        if (this.getPSSubSysSADetailId() == null) {
            return null;
        }
        PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysSADetailParamsLock;
        synchronized (n) {
            if (this.pssubsyssadetailparams == null) {
                this.pssubsyssadetailparams = pSSubSysSADetailService.isTempData(this) ? pSSubSysSADetailParamService.selectTempByPSSubSysSADetail(this) : pSSubSysSADetailParamService.selectByPSSubSysSADetail(this);
            }
            return this.pssubsyssadetailparams;
        }
    }

    private PSSubSysSADetailBase getProxyEntity() {
        return this.proxyPSSubSysSADetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysSADetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysSADetailBase) {
            this.proxyPSSubSysSADetailBase = (PSSubSysSADetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AFTERCODE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 5);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 6);
        fieldIndexMap.put(FIELD_DETAILID, 7);
        fieldIndexMap.put(FIELD_DETAILPARAM, 8);
        fieldIndexMap.put(FIELD_DETAILPARAM2, 9);
        fieldIndexMap.put(FIELD_DETAILPARAMS, 10);
        fieldIndexMap.put(FIELD_DETAILTAG, 11);
        fieldIndexMap.put(FIELD_DETAILTAG2, 12);
        fieldIndexMap.put(FIELD_DETAILTYPE, 13);
        fieldIndexMap.put(FIELD_INPSSUBSYSSADEID, 14);
        fieldIndexMap.put(FIELD_INPSSUBSYSSADENAME, 15);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_INPSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_KEYFIELDNAME, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_METHODCODE, 20);
        fieldIndexMap.put(FIELD_NEEDRESOURCEKEY, 21);
        fieldIndexMap.put(FIELD_NOSERVICECODENAME, 22);
        fieldIndexMap.put(FIELD_OUTPSSUBSYSSADEID, 23);
        fieldIndexMap.put(FIELD_OUTPSSUBSYSSADENAME, 24);
        fieldIndexMap.put(FIELD_OUTPSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_OUTPSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 28);
        fieldIndexMap.put(FIELD_PSDENAME, 29);
        fieldIndexMap.put(FIELD_PSSUBSYSSADEID, 30);
        fieldIndexMap.put(FIELD_PSSUBSYSSADENAME, 31);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILID, 32);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILNAME, 33);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 34);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 35);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 36);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 37);
        fieldIndexMap.put(FIELD_REQUESTCONTENTTYPE, 38);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 39);
        fieldIndexMap.put(FIELD_REQUESTPARAMTYPE, 40);
        fieldIndexMap.put(FIELD_RETPSSUBSYSSADEID, 41);
        fieldIndexMap.put(FIELD_RETPSSUBSYSSADENAME, 42);
        fieldIndexMap.put(FIELD_RETSTDDATATYPE, 43);
        fieldIndexMap.put(FIELD_RETVALTYPE, 44);
        fieldIndexMap.put(FIELD_SERVICEURL, 45);
        fieldIndexMap.put(FIELD_UNIQUETAG, 46);
        fieldIndexMap.put(FIELD_UPDATEDATE, 47);
        fieldIndexMap.put(FIELD_UPDATEMAN, 48);
        fieldIndexMap.put(FIELD_USERCAT, 49);
        fieldIndexMap.put(FIELD_USERTAG, 50);
        fieldIndexMap.put(FIELD_USERTAG2, 51);
        fieldIndexMap.put(FIELD_USERTAG3, 52);
        fieldIndexMap.put(FIELD_USERTAG4, 53);
        fieldIndexMap.put(FIELD_VALIDFLAG, 54);
    }
}

