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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESADetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESADetailBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILPARAM = "DETAILPARAM";
    public static final String FIELD_DETAILPARAM2 = "DETAILPARAM2";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_INPSDESERVICEAPIID = "INPSDESERVICEAPIID";
    public static final String FIELD_INPSDESERVICEAPINAME = "INPSDESERVICEAPINAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODTAG = "METHODTAG";
    public static final String FIELD_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";
    public static final String FIELD_NOSERVICECODENAME = "NOSERVICECODENAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPSDESERVICEAPIID = "OUTPSDESERVICEAPIID";
    public static final String FIELD_OUTPSDESERVICEAPINAME = "OUTPSDESERVICEAPINAME";
    public static final String FIELD_PARENTKEYMODE = "PARENTKEYMODE";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDESADETAILID = "PSDESADETAILID";
    public static final String FIELD_PSDESADETAILNAME = "PSDESADETAILNAME";
    public static final String FIELD_PSDESARSID = "PSDESARSID";
    public static final String FIELD_PSDESARSNAME = "PSDESARSNAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_REQUESTFIELD = "REQUESTFIELD";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
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
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DETAILPARAM = 4;
    private static final int INDEX_DETAILPARAM2 = 5;
    private static final int INDEX_DETAILTYPE = 6;
    private static final int INDEX_INPSDESERVICEAPIID = 7;
    private static final int INDEX_INPSDESERVICEAPINAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_METHODTAG = 10;
    private static final int INDEX_NEEDRESOURCEKEY = 11;
    private static final int INDEX_NOSERVICECODENAME = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_OUTPSDESERVICEAPIID = 14;
    private static final int INDEX_OUTPSDESERVICEAPINAME = 15;
    private static final int INDEX_PARENTKEYMODE = 16;
    private static final int INDEX_PSDEACTIONID = 17;
    private static final int INDEX_PSDEACTIONNAME = 18;
    private static final int INDEX_PSDEDQID = 19;
    private static final int INDEX_PSDEDQNAME = 20;
    private static final int INDEX_PSDEDSID = 21;
    private static final int INDEX_PSDEDSNAME = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDEOPPRIVID = 24;
    private static final int INDEX_PSDEOPPRIVNAME = 25;
    private static final int INDEX_PSDESADETAILID = 26;
    private static final int INDEX_PSDESADETAILNAME = 27;
    private static final int INDEX_PSDESARSID = 28;
    private static final int INDEX_PSDESARSNAME = 29;
    private static final int INDEX_PSDESERVICEAPIID = 30;
    private static final int INDEX_PSDESERVICEAPINAME = 31;
    private static final int INDEX_PSSYSSERVICEAPIID = 32;
    private static final int INDEX_PSSYSSFPLUGINID = 33;
    private static final int INDEX_PSSYSSFPLUGINNAME = 34;
    private static final int INDEX_REQUESTFIELD = 35;
    private static final int INDEX_REQUESTMETHOD = 36;
    private static final int INDEX_REQUESTPARAMTYPE = 37;
    private static final int INDEX_RETVALTYPE = 38;
    private static final int INDEX_SERVICEURL = 39;
    private static final int INDEX_UNIQUETAG = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_USERCAT = 43;
    private static final int INDEX_USERTAG = 44;
    private static final int INDEX_USERTAG2 = 45;
    private static final int INDEX_USERTAG3 = 46;
    private static final int INDEX_USERTAG4 = 47;
    private static final int INDEX_VALIDFLAG = 48;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESADetailBase proxyPSDESADetailBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailparamDirtyFlag = false;
    private boolean detailparam2DirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean inpsdeserviceapiidDirtyFlag = false;
    private boolean inpsdeserviceapinameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodtagDirtyFlag = false;
    private boolean needresourcekeyDirtyFlag = false;
    private boolean noservicecodenameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outpsdeserviceapiidDirtyFlag = false;
    private boolean outpsdeserviceapinameDirtyFlag = false;
    private boolean parentkeymodeDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psdesadetailidDirtyFlag = false;
    private boolean psdesadetailnameDirtyFlag = false;
    private boolean psdesarsidDirtyFlag = false;
    private boolean psdesarsnameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean requestfieldDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestparamtypeDirtyFlag = false;
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
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailparam")
    private String detailparam;
    @Column(name="detailparam2")
    private String detailparam2;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="inpsdeserviceapiid")
    private String inpsdeserviceapiid;
    @Column(name="inpsdeserviceapiname")
    private String inpsdeserviceapiname;
    @Column(name="memo")
    private String memo;
    @Column(name="methodtag")
    private String methodtag;
    @Column(name="needresourcekey")
    private Integer needresourcekey;
    @Column(name="noservicecodename")
    private Integer noservicecodename;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outpsdeserviceapiid")
    private String outpsdeserviceapiid;
    @Column(name="outpsdeserviceapiname")
    private String outpsdeserviceapiname;
    @Column(name="parentkeymode")
    private String parentkeymode;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psdesadetailid")
    private String psdesadetailid;
    @Column(name="psdesadetailname")
    private String psdesadetailname;
    @Column(name="psdesarsid")
    private String psdesarsid;
    @Column(name="psdesarsname")
    private String psdesarsname;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="requestfield")
    private String requestfield;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestparamtype")
    private String requestparamtype;
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
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;
    private Integer objPSDESARSLock = new Integer(1);
    private PSDESARS psdesars = null;
    private Integer objInPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI inpsdeserviceapi = null;
    private Integer objOutPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI outpsdeserviceapi = null;
    private Integer objPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI psdeserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDESADetailParamsLock = new Integer(1);
    private ArrayList<PSDESADetailParam> psdesadetailparams = null;

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

    public void setInPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdeserviceapiid = string;
        this.inpsdeserviceapiidDirtyFlag = true;
    }

    public String getInPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEServiceAPIId();
        }
        return this.inpsdeserviceapiid;
    }

    public boolean isInPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEServiceAPIIdDirty();
        }
        return this.inpsdeserviceapiidDirtyFlag;
    }

    public void resetInPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEServiceAPIId();
            return;
        }
        this.inpsdeserviceapiidDirtyFlag = false;
        this.inpsdeserviceapiid = null;
    }

    public void setInPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdeserviceapiname = string;
        this.inpsdeserviceapinameDirtyFlag = true;
    }

    public String getInPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEServiceAPIName();
        }
        return this.inpsdeserviceapiname;
    }

    public boolean isInPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEServiceAPINameDirty();
        }
        return this.inpsdeserviceapinameDirtyFlag;
    }

    public void resetInPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEServiceAPIName();
            return;
        }
        this.inpsdeserviceapinameDirtyFlag = false;
        this.inpsdeserviceapiname = null;
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

    public void setMethodTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMethodTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.methodtag = string;
        this.methodtagDirtyFlag = true;
    }

    public String getMethodTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMethodTag();
        }
        return this.methodtag;
    }

    public boolean isMethodTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMethodTagDirty();
        }
        return this.methodtagDirtyFlag;
    }

    public void resetMethodTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMethodTag();
            return;
        }
        this.methodtagDirtyFlag = false;
        this.methodtag = null;
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

    public void setOutPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdeserviceapiid = string;
        this.outpsdeserviceapiidDirtyFlag = true;
    }

    public String getOutPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEServiceAPIId();
        }
        return this.outpsdeserviceapiid;
    }

    public boolean isOutPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEServiceAPIIdDirty();
        }
        return this.outpsdeserviceapiidDirtyFlag;
    }

    public void resetOutPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEServiceAPIId();
            return;
        }
        this.outpsdeserviceapiidDirtyFlag = false;
        this.outpsdeserviceapiid = null;
    }

    public void setOutPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdeserviceapiname = string;
        this.outpsdeserviceapinameDirtyFlag = true;
    }

    public String getOutPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEServiceAPIName();
        }
        return this.outpsdeserviceapiname;
    }

    public boolean isOutPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEServiceAPINameDirty();
        }
        return this.outpsdeserviceapinameDirtyFlag;
    }

    public void resetOutPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEServiceAPIName();
            return;
        }
        this.outpsdeserviceapinameDirtyFlag = false;
        this.outpsdeserviceapiname = null;
    }

    public void setParentKeyMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParentKeyMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parentkeymode = string;
        this.parentkeymodeDirtyFlag = true;
    }

    public String getParentKeyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParentKeyMode();
        }
        return this.parentkeymode;
    }

    public boolean isParentKeyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParentKeyModeDirty();
        }
        return this.parentkeymodeDirtyFlag;
    }

    public void resetParentKeyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParentKeyMode();
            return;
        }
        this.parentkeymodeDirtyFlag = false;
        this.parentkeymode = null;
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

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
    }

    public void setPSDESADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailid = string;
        this.psdesadetailidDirtyFlag = true;
    }

    public String getPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailId();
        }
        return this.psdesadetailid;
    }

    public boolean isPSDESADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailIdDirty();
        }
        return this.psdesadetailidDirtyFlag;
    }

    public void resetPSDESADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailId();
            return;
        }
        this.psdesadetailidDirtyFlag = false;
        this.psdesadetailid = null;
    }

    public void setPSDESADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesadetailname = string;
        this.psdesadetailnameDirtyFlag = true;
    }

    public String getPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailName();
        }
        return this.psdesadetailname;
    }

    public boolean isPSDESADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESADetailNameDirty();
        }
        return this.psdesadetailnameDirtyFlag;
    }

    public void resetPSDESADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESADetailName();
            return;
        }
        this.psdesadetailnameDirtyFlag = false;
        this.psdesadetailname = null;
    }

    public void setPSDESARSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESARSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesarsid = string;
        this.psdesarsidDirtyFlag = true;
    }

    public String getPSDESARSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARSId();
        }
        return this.psdesarsid;
    }

    public boolean isPSDESARSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESARSIdDirty();
        }
        return this.psdesarsidDirtyFlag;
    }

    public void resetPSDESARSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESARSId();
            return;
        }
        this.psdesarsidDirtyFlag = false;
        this.psdesarsid = null;
    }

    public void setPSDESARSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESARSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesarsname = string;
        this.psdesarsnameDirtyFlag = true;
    }

    public String getPSDESARSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARSName();
        }
        return this.psdesarsname;
    }

    public boolean isPSDESARSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESARSNameDirty();
        }
        return this.psdesarsnameDirtyFlag;
    }

    public void resetPSDESARSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESARSName();
            return;
        }
        this.psdesarsnameDirtyFlag = false;
        this.psdesarsname = null;
    }

    public void setPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiid = string;
        this.psdeserviceapiidDirtyFlag = true;
    }

    public String getPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIId();
        }
        return this.psdeserviceapiid;
    }

    public boolean isPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPIIdDirty();
        }
        return this.psdeserviceapiidDirtyFlag;
    }

    public void resetPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIId();
            return;
        }
        this.psdeserviceapiidDirtyFlag = false;
        this.psdeserviceapiid = null;
    }

    public void setPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiname = string;
        this.psdeserviceapinameDirtyFlag = true;
    }

    public String getPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIName();
        }
        return this.psdeserviceapiname;
    }

    public boolean isPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPINameDirty();
        }
        return this.psdeserviceapinameDirtyFlag;
    }

    public void resetPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIName();
            return;
        }
        this.psdeserviceapinameDirtyFlag = false;
        this.psdeserviceapiname = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
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

    public void setRequestField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRequestField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.requestfield = string;
        this.requestfieldDirtyFlag = true;
    }

    public String getRequestField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRequestField();
        }
        return this.requestfield;
    }

    public boolean isRequestFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRequestFieldDirty();
        }
        return this.requestfieldDirtyFlag;
    }

    public void resetRequestField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRequestField();
            return;
        }
        this.requestfieldDirtyFlag = false;
        this.requestfield = null;
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
        PSDESADetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESADetailBase pSDESADetailBase) {
        pSDESADetailBase.resetCodeName();
        pSDESADetailBase.resetCodeName2();
        pSDESADetailBase.resetCreateDate();
        pSDESADetailBase.resetCreateMan();
        pSDESADetailBase.resetDetailParam();
        pSDESADetailBase.resetDetailParam2();
        pSDESADetailBase.resetDetailType();
        pSDESADetailBase.resetInPSDEServiceAPIId();
        pSDESADetailBase.resetInPSDEServiceAPIName();
        pSDESADetailBase.resetMemo();
        pSDESADetailBase.resetMethodTag();
        pSDESADetailBase.resetNeedResourceKey();
        pSDESADetailBase.resetNoServiceCodeName();
        pSDESADetailBase.resetOrderValue();
        pSDESADetailBase.resetOutPSDEServiceAPIId();
        pSDESADetailBase.resetOutPSDEServiceAPIName();
        pSDESADetailBase.resetParentKeyMode();
        pSDESADetailBase.resetPSDEActionId();
        pSDESADetailBase.resetPSDEActionName();
        pSDESADetailBase.resetPSDEDQId();
        pSDESADetailBase.resetPSDEDQName();
        pSDESADetailBase.resetPSDEDSId();
        pSDESADetailBase.resetPSDEDSName();
        pSDESADetailBase.resetPSDEId();
        pSDESADetailBase.resetPSDEOPPrivId();
        pSDESADetailBase.resetPSDEOPPrivName();
        pSDESADetailBase.resetPSDESADetailId();
        pSDESADetailBase.resetPSDESADetailName();
        pSDESADetailBase.resetPSDESARSId();
        pSDESADetailBase.resetPSDESARSName();
        pSDESADetailBase.resetPSDEServiceAPIId();
        pSDESADetailBase.resetPSDEServiceAPIName();
        pSDESADetailBase.resetPSSysServiceAPIId();
        pSDESADetailBase.resetPSSysSFPluginId();
        pSDESADetailBase.resetPSSysSFPluginName();
        pSDESADetailBase.resetRequestField();
        pSDESADetailBase.resetRequestMethod();
        pSDESADetailBase.resetRequestParamType();
        pSDESADetailBase.resetRetValType();
        pSDESADetailBase.resetServiceUrl();
        pSDESADetailBase.resetUniqueTag();
        pSDESADetailBase.resetUpdateDate();
        pSDESADetailBase.resetUpdateMan();
        pSDESADetailBase.resetUserCat();
        pSDESADetailBase.resetUserTag();
        pSDESADetailBase.resetUserTag2();
        pSDESADetailBase.resetUserTag3();
        pSDESADetailBase.resetUserTag4();
        pSDESADetailBase.resetValidFlag();
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
        if (!bl || this.isDetailParamDirty()) {
            hashMap.put(FIELD_DETAILPARAM, this.getDetailParam());
        }
        if (!bl || this.isDetailParam2Dirty()) {
            hashMap.put(FIELD_DETAILPARAM2, this.getDetailParam2());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isInPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_INPSDESERVICEAPIID, this.getInPSDEServiceAPIId());
        }
        if (!bl || this.isInPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_INPSDESERVICEAPINAME, this.getInPSDEServiceAPIName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodTagDirty()) {
            hashMap.put(FIELD_METHODTAG, this.getMethodTag());
        }
        if (!bl || this.isNeedResourceKeyDirty()) {
            hashMap.put(FIELD_NEEDRESOURCEKEY, this.getNeedResourceKey());
        }
        if (!bl || this.isNoServiceCodeNameDirty()) {
            hashMap.put(FIELD_NOSERVICECODENAME, this.getNoServiceCodeName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_OUTPSDESERVICEAPIID, this.getOutPSDEServiceAPIId());
        }
        if (!bl || this.isOutPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_OUTPSDESERVICEAPINAME, this.getOutPSDEServiceAPIName());
        }
        if (!bl || this.isParentKeyModeDirty()) {
            hashMap.put(FIELD_PARENTKEYMODE, this.getParentKeyMode());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDESADetailIdDirty()) {
            hashMap.put(FIELD_PSDESADETAILID, this.getPSDESADetailId());
        }
        if (!bl || this.isPSDESADetailNameDirty()) {
            hashMap.put(FIELD_PSDESADETAILNAME, this.getPSDESADetailName());
        }
        if (!bl || this.isPSDESARSIdDirty()) {
            hashMap.put(FIELD_PSDESARSID, this.getPSDESARSId());
        }
        if (!bl || this.isPSDESARSNameDirty()) {
            hashMap.put(FIELD_PSDESARSNAME, this.getPSDESARSName());
        }
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isRequestFieldDirty()) {
            hashMap.put(FIELD_REQUESTFIELD, this.getRequestField());
        }
        if (!bl || this.isRequestMethodDirty()) {
            hashMap.put(FIELD_REQUESTMETHOD, this.getRequestMethod());
        }
        if (!bl || this.isRequestParamTypeDirty()) {
            hashMap.put(FIELD_REQUESTPARAMTYPE, this.getRequestParamType());
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
        return PSDESADetailBase.get(this, n);
    }

    private static Object get(PSDESADetailBase pSDESADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailBase.getCodeName();
            }
            case 1: {
                return pSDESADetailBase.getCodeName2();
            }
            case 2: {
                return pSDESADetailBase.getCreateDate();
            }
            case 3: {
                return pSDESADetailBase.getCreateMan();
            }
            case 4: {
                return pSDESADetailBase.getDetailParam();
            }
            case 5: {
                return pSDESADetailBase.getDetailParam2();
            }
            case 6: {
                return pSDESADetailBase.getDetailType();
            }
            case 7: {
                return pSDESADetailBase.getInPSDEServiceAPIId();
            }
            case 8: {
                return pSDESADetailBase.getInPSDEServiceAPIName();
            }
            case 9: {
                return pSDESADetailBase.getMemo();
            }
            case 10: {
                return pSDESADetailBase.getMethodTag();
            }
            case 11: {
                return pSDESADetailBase.getNeedResourceKey();
            }
            case 12: {
                return pSDESADetailBase.getNoServiceCodeName();
            }
            case 13: {
                return pSDESADetailBase.getOrderValue();
            }
            case 14: {
                return pSDESADetailBase.getOutPSDEServiceAPIId();
            }
            case 15: {
                return pSDESADetailBase.getOutPSDEServiceAPIName();
            }
            case 16: {
                return pSDESADetailBase.getParentKeyMode();
            }
            case 17: {
                return pSDESADetailBase.getPSDEActionId();
            }
            case 18: {
                return pSDESADetailBase.getPSDEActionName();
            }
            case 19: {
                return pSDESADetailBase.getPSDEDQId();
            }
            case 20: {
                return pSDESADetailBase.getPSDEDQName();
            }
            case 21: {
                return pSDESADetailBase.getPSDEDSId();
            }
            case 22: {
                return pSDESADetailBase.getPSDEDSName();
            }
            case 23: {
                return pSDESADetailBase.getPSDEId();
            }
            case 24: {
                return pSDESADetailBase.getPSDEOPPrivId();
            }
            case 25: {
                return pSDESADetailBase.getPSDEOPPrivName();
            }
            case 26: {
                return pSDESADetailBase.getPSDESADetailId();
            }
            case 27: {
                return pSDESADetailBase.getPSDESADetailName();
            }
            case 28: {
                return pSDESADetailBase.getPSDESARSId();
            }
            case 29: {
                return pSDESADetailBase.getPSDESARSName();
            }
            case 30: {
                return pSDESADetailBase.getPSDEServiceAPIId();
            }
            case 31: {
                return pSDESADetailBase.getPSDEServiceAPIName();
            }
            case 32: {
                return pSDESADetailBase.getPSSysServiceAPIId();
            }
            case 33: {
                return pSDESADetailBase.getPSSysSFPluginId();
            }
            case 34: {
                return pSDESADetailBase.getPSSysSFPluginName();
            }
            case 35: {
                return pSDESADetailBase.getRequestField();
            }
            case 36: {
                return pSDESADetailBase.getRequestMethod();
            }
            case 37: {
                return pSDESADetailBase.getRequestParamType();
            }
            case 38: {
                return pSDESADetailBase.getRetValType();
            }
            case 39: {
                return pSDESADetailBase.getServiceUrl();
            }
            case 40: {
                return pSDESADetailBase.getUniqueTag();
            }
            case 41: {
                return pSDESADetailBase.getUpdateDate();
            }
            case 42: {
                return pSDESADetailBase.getUpdateMan();
            }
            case 43: {
                return pSDESADetailBase.getUserCat();
            }
            case 44: {
                return pSDESADetailBase.getUserTag();
            }
            case 45: {
                return pSDESADetailBase.getUserTag2();
            }
            case 46: {
                return pSDESADetailBase.getUserTag3();
            }
            case 47: {
                return pSDESADetailBase.getUserTag4();
            }
            case 48: {
                return pSDESADetailBase.getValidFlag();
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
        PSDESADetailBase.set(this, n, object);
    }

    private static void set(PSDESADetailBase pSDESADetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESADetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDESADetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDESADetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDESADetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESADetailBase.setDetailParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESADetailBase.setDetailParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESADetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESADetailBase.setInPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESADetailBase.setInPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESADetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESADetailBase.setMethodTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESADetailBase.setNeedResourceKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDESADetailBase.setNoServiceCodeName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDESADetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDESADetailBase.setOutPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDESADetailBase.setOutPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDESADetailBase.setParentKeyMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDESADetailBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDESADetailBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDESADetailBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDESADetailBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDESADetailBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDESADetailBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDESADetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDESADetailBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDESADetailBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDESADetailBase.setPSDESADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDESADetailBase.setPSDESADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDESADetailBase.setPSDESARSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDESADetailBase.setPSDESARSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDESADetailBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDESADetailBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDESADetailBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDESADetailBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDESADetailBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDESADetailBase.setRequestField(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDESADetailBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDESADetailBase.setRequestParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDESADetailBase.setRetValType(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDESADetailBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDESADetailBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDESADetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSDESADetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDESADetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDESADetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDESADetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDESADetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDESADetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDESADetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDESADetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDESADetailBase pSDESADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailBase.getCodeName() == null;
            }
            case 1: {
                return pSDESADetailBase.getCodeName2() == null;
            }
            case 2: {
                return pSDESADetailBase.getCreateDate() == null;
            }
            case 3: {
                return pSDESADetailBase.getCreateMan() == null;
            }
            case 4: {
                return pSDESADetailBase.getDetailParam() == null;
            }
            case 5: {
                return pSDESADetailBase.getDetailParam2() == null;
            }
            case 6: {
                return pSDESADetailBase.getDetailType() == null;
            }
            case 7: {
                return pSDESADetailBase.getInPSDEServiceAPIId() == null;
            }
            case 8: {
                return pSDESADetailBase.getInPSDEServiceAPIName() == null;
            }
            case 9: {
                return pSDESADetailBase.getMemo() == null;
            }
            case 10: {
                return pSDESADetailBase.getMethodTag() == null;
            }
            case 11: {
                return pSDESADetailBase.getNeedResourceKey() == null;
            }
            case 12: {
                return pSDESADetailBase.getNoServiceCodeName() == null;
            }
            case 13: {
                return pSDESADetailBase.getOrderValue() == null;
            }
            case 14: {
                return pSDESADetailBase.getOutPSDEServiceAPIId() == null;
            }
            case 15: {
                return pSDESADetailBase.getOutPSDEServiceAPIName() == null;
            }
            case 16: {
                return pSDESADetailBase.getParentKeyMode() == null;
            }
            case 17: {
                return pSDESADetailBase.getPSDEActionId() == null;
            }
            case 18: {
                return pSDESADetailBase.getPSDEActionName() == null;
            }
            case 19: {
                return pSDESADetailBase.getPSDEDQId() == null;
            }
            case 20: {
                return pSDESADetailBase.getPSDEDQName() == null;
            }
            case 21: {
                return pSDESADetailBase.getPSDEDSId() == null;
            }
            case 22: {
                return pSDESADetailBase.getPSDEDSName() == null;
            }
            case 23: {
                return pSDESADetailBase.getPSDEId() == null;
            }
            case 24: {
                return pSDESADetailBase.getPSDEOPPrivId() == null;
            }
            case 25: {
                return pSDESADetailBase.getPSDEOPPrivName() == null;
            }
            case 26: {
                return pSDESADetailBase.getPSDESADetailId() == null;
            }
            case 27: {
                return pSDESADetailBase.getPSDESADetailName() == null;
            }
            case 28: {
                return pSDESADetailBase.getPSDESARSId() == null;
            }
            case 29: {
                return pSDESADetailBase.getPSDESARSName() == null;
            }
            case 30: {
                return pSDESADetailBase.getPSDEServiceAPIId() == null;
            }
            case 31: {
                return pSDESADetailBase.getPSDEServiceAPIName() == null;
            }
            case 32: {
                return pSDESADetailBase.getPSSysServiceAPIId() == null;
            }
            case 33: {
                return pSDESADetailBase.getPSSysSFPluginId() == null;
            }
            case 34: {
                return pSDESADetailBase.getPSSysSFPluginName() == null;
            }
            case 35: {
                return pSDESADetailBase.getRequestField() == null;
            }
            case 36: {
                return pSDESADetailBase.getRequestMethod() == null;
            }
            case 37: {
                return pSDESADetailBase.getRequestParamType() == null;
            }
            case 38: {
                return pSDESADetailBase.getRetValType() == null;
            }
            case 39: {
                return pSDESADetailBase.getServiceUrl() == null;
            }
            case 40: {
                return pSDESADetailBase.getUniqueTag() == null;
            }
            case 41: {
                return pSDESADetailBase.getUpdateDate() == null;
            }
            case 42: {
                return pSDESADetailBase.getUpdateMan() == null;
            }
            case 43: {
                return pSDESADetailBase.getUserCat() == null;
            }
            case 44: {
                return pSDESADetailBase.getUserTag() == null;
            }
            case 45: {
                return pSDESADetailBase.getUserTag2() == null;
            }
            case 46: {
                return pSDESADetailBase.getUserTag3() == null;
            }
            case 47: {
                return pSDESADetailBase.getUserTag4() == null;
            }
            case 48: {
                return pSDESADetailBase.getValidFlag() == null;
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
        return PSDESADetailBase.contains(this, n);
    }

    private static boolean contains(PSDESADetailBase pSDESADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESADetailBase.isCodeNameDirty();
            }
            case 1: {
                return pSDESADetailBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDESADetailBase.isCreateDateDirty();
            }
            case 3: {
                return pSDESADetailBase.isCreateManDirty();
            }
            case 4: {
                return pSDESADetailBase.isDetailParamDirty();
            }
            case 5: {
                return pSDESADetailBase.isDetailParam2Dirty();
            }
            case 6: {
                return pSDESADetailBase.isDetailTypeDirty();
            }
            case 7: {
                return pSDESADetailBase.isInPSDEServiceAPIIdDirty();
            }
            case 8: {
                return pSDESADetailBase.isInPSDEServiceAPINameDirty();
            }
            case 9: {
                return pSDESADetailBase.isMemoDirty();
            }
            case 10: {
                return pSDESADetailBase.isMethodTagDirty();
            }
            case 11: {
                return pSDESADetailBase.isNeedResourceKeyDirty();
            }
            case 12: {
                return pSDESADetailBase.isNoServiceCodeNameDirty();
            }
            case 13: {
                return pSDESADetailBase.isOrderValueDirty();
            }
            case 14: {
                return pSDESADetailBase.isOutPSDEServiceAPIIdDirty();
            }
            case 15: {
                return pSDESADetailBase.isOutPSDEServiceAPINameDirty();
            }
            case 16: {
                return pSDESADetailBase.isParentKeyModeDirty();
            }
            case 17: {
                return pSDESADetailBase.isPSDEActionIdDirty();
            }
            case 18: {
                return pSDESADetailBase.isPSDEActionNameDirty();
            }
            case 19: {
                return pSDESADetailBase.isPSDEDQIdDirty();
            }
            case 20: {
                return pSDESADetailBase.isPSDEDQNameDirty();
            }
            case 21: {
                return pSDESADetailBase.isPSDEDSIdDirty();
            }
            case 22: {
                return pSDESADetailBase.isPSDEDSNameDirty();
            }
            case 23: {
                return pSDESADetailBase.isPSDEIdDirty();
            }
            case 24: {
                return pSDESADetailBase.isPSDEOPPrivIdDirty();
            }
            case 25: {
                return pSDESADetailBase.isPSDEOPPrivNameDirty();
            }
            case 26: {
                return pSDESADetailBase.isPSDESADetailIdDirty();
            }
            case 27: {
                return pSDESADetailBase.isPSDESADetailNameDirty();
            }
            case 28: {
                return pSDESADetailBase.isPSDESARSIdDirty();
            }
            case 29: {
                return pSDESADetailBase.isPSDESARSNameDirty();
            }
            case 30: {
                return pSDESADetailBase.isPSDEServiceAPIIdDirty();
            }
            case 31: {
                return pSDESADetailBase.isPSDEServiceAPINameDirty();
            }
            case 32: {
                return pSDESADetailBase.isPSSysServiceAPIIdDirty();
            }
            case 33: {
                return pSDESADetailBase.isPSSysSFPluginIdDirty();
            }
            case 34: {
                return pSDESADetailBase.isPSSysSFPluginNameDirty();
            }
            case 35: {
                return pSDESADetailBase.isRequestFieldDirty();
            }
            case 36: {
                return pSDESADetailBase.isRequestMethodDirty();
            }
            case 37: {
                return pSDESADetailBase.isRequestParamTypeDirty();
            }
            case 38: {
                return pSDESADetailBase.isRetValTypeDirty();
            }
            case 39: {
                return pSDESADetailBase.isServiceUrlDirty();
            }
            case 40: {
                return pSDESADetailBase.isUniqueTagDirty();
            }
            case 41: {
                return pSDESADetailBase.isUpdateDateDirty();
            }
            case 42: {
                return pSDESADetailBase.isUpdateManDirty();
            }
            case 43: {
                return pSDESADetailBase.isUserCatDirty();
            }
            case 44: {
                return pSDESADetailBase.isUserTagDirty();
            }
            case 45: {
                return pSDESADetailBase.isUserTag2Dirty();
            }
            case 46: {
                return pSDESADetailBase.isUserTag3Dirty();
            }
            case 47: {
                return pSDESADetailBase.isUserTag4Dirty();
            }
            case 48: {
                return pSDESADetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESADetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESADetailBase pSDESADetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESADetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getDetailParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getDetailParam()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getDetailParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam2", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getDetailParam2()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getInPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdeserviceapiid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getInPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getInPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdeserviceapiname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getInPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getMethodTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodtag", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getMethodTag()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getNeedResourceKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needresourcekey", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getNeedResourceKey()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getNoServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noservicecodename", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getNoServiceCodeName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getOutPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdeserviceapiid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getOutPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getOutPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdeserviceapiname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getOutPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getParentKeyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parentkeymode", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getParentKeyMode()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDESADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDESADetailId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDESADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesadetailname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDESADetailName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDESARSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesarsid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDESARSId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDESARSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesarsname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDESARSName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getRequestField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestfield", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getRequestField()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getRequestParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestparamtype", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getRequestParamType()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getRetValType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retvaltype", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getRetValType()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDESADetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDESADetailBase.getJSONValue((Object)pSDESADetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESADetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESADetailBase pSDESADetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESADetailBase.getCodeName() != null) {
            object = pSDESADetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDESADetailBase.getCodeName2() != null) {
            object = pSDESADetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getCreateDate() != null) {
            object = pSDESADetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESADetailBase.getCreateMan() != null) {
            object = pSDESADetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getDetailParam() != null) {
            object = pSDESADetailBase.getDetailParam();
            xmlNode.setAttribute(FIELD_DETAILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getDetailParam2() != null) {
            object = pSDESADetailBase.getDetailParam2();
            xmlNode.setAttribute(FIELD_DETAILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getDetailType() != null) {
            object = pSDESADetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getInPSDEServiceAPIId() != null) {
            object = pSDESADetailBase.getInPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_INPSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getInPSDEServiceAPIName() != null) {
            object = pSDESADetailBase.getInPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_INPSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getMemo() != null) {
            object = pSDESADetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getMethodTag() != null) {
            object = pSDESADetailBase.getMethodTag();
            xmlNode.setAttribute(FIELD_METHODTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getNeedResourceKey() != null) {
            object = pSDESADetailBase.getNeedResourceKey();
            xmlNode.setAttribute(FIELD_NEEDRESOURCEKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailBase.getNoServiceCodeName() != null) {
            object = pSDESADetailBase.getNoServiceCodeName();
            xmlNode.setAttribute(FIELD_NOSERVICECODENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailBase.getOrderValue() != null) {
            object = pSDESADetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESADetailBase.getOutPSDEServiceAPIId() != null) {
            object = pSDESADetailBase.getOutPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_OUTPSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getOutPSDEServiceAPIName() != null) {
            object = pSDESADetailBase.getOutPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_OUTPSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getParentKeyMode() != null) {
            object = pSDESADetailBase.getParentKeyMode();
            xmlNode.setAttribute(FIELD_PARENTKEYMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEActionId() != null) {
            object = pSDESADetailBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEActionName() != null) {
            object = pSDESADetailBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEDQId() != null) {
            object = pSDESADetailBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEDQName() != null) {
            object = pSDESADetailBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEDSId() != null) {
            object = pSDESADetailBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEDSName() != null) {
            object = pSDESADetailBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEId() != null) {
            object = pSDESADetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEOPPrivId() != null) {
            object = pSDESADetailBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEOPPrivName() != null) {
            object = pSDESADetailBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDESADetailId() != null) {
            object = pSDESADetailBase.getPSDESADetailId();
            xmlNode.setAttribute(FIELD_PSDESADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDESADetailName() != null) {
            object = pSDESADetailBase.getPSDESADetailName();
            xmlNode.setAttribute(FIELD_PSDESADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDESARSId() != null) {
            object = pSDESADetailBase.getPSDESARSId();
            xmlNode.setAttribute(FIELD_PSDESARSID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDESARSName() != null) {
            object = pSDESADetailBase.getPSDESARSName();
            xmlNode.setAttribute(FIELD_PSDESARSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEServiceAPIId() != null) {
            object = pSDESADetailBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSDEServiceAPIName() != null) {
            object = pSDESADetailBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSSysServiceAPIId() != null) {
            object = pSDESADetailBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSSysSFPluginId() != null) {
            object = pSDESADetailBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getPSSysSFPluginName() != null) {
            object = pSDESADetailBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getRequestField() != null) {
            object = pSDESADetailBase.getRequestField();
            xmlNode.setAttribute(FIELD_REQUESTFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getRequestMethod() != null) {
            object = pSDESADetailBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getRequestParamType() != null) {
            object = pSDESADetailBase.getRequestParamType();
            xmlNode.setAttribute(FIELD_REQUESTPARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getRetValType() != null) {
            object = pSDESADetailBase.getRetValType();
            xmlNode.setAttribute(FIELD_RETVALTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getServiceUrl() != null) {
            object = pSDESADetailBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUniqueTag() != null) {
            object = pSDESADetailBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUpdateDate() != null) {
            object = pSDESADetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESADetailBase.getUpdateMan() != null) {
            object = pSDESADetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUserCat() != null) {
            object = pSDESADetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUserTag() != null) {
            object = pSDESADetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUserTag2() != null) {
            object = pSDESADetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUserTag3() != null) {
            object = pSDESADetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getUserTag4() != null) {
            object = pSDESADetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDESADetailBase.getValidFlag() != null) {
            object = pSDESADetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESADetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESADetailBase pSDESADetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESADetailBase.isCodeNameDirty() && (bl || pSDESADetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDESADetailBase.getCodeName());
        }
        if (pSDESADetailBase.isCodeName2Dirty() && (bl || pSDESADetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDESADetailBase.getCodeName2());
        }
        if (pSDESADetailBase.isCreateDateDirty() && (bl || pSDESADetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESADetailBase.getCreateDate());
        }
        if (pSDESADetailBase.isCreateManDirty() && (bl || pSDESADetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESADetailBase.getCreateMan());
        }
        if (pSDESADetailBase.isDetailParamDirty() && (bl || pSDESADetailBase.getDetailParam() != null)) {
            iDataObject.set(FIELD_DETAILPARAM, (Object)pSDESADetailBase.getDetailParam());
        }
        if (pSDESADetailBase.isDetailParam2Dirty() && (bl || pSDESADetailBase.getDetailParam2() != null)) {
            iDataObject.set(FIELD_DETAILPARAM2, (Object)pSDESADetailBase.getDetailParam2());
        }
        if (pSDESADetailBase.isDetailTypeDirty() && (bl || pSDESADetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDESADetailBase.getDetailType());
        }
        if (pSDESADetailBase.isInPSDEServiceAPIIdDirty() && (bl || pSDESADetailBase.getInPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_INPSDESERVICEAPIID, (Object)pSDESADetailBase.getInPSDEServiceAPIId());
        }
        if (pSDESADetailBase.isInPSDEServiceAPINameDirty() && (bl || pSDESADetailBase.getInPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_INPSDESERVICEAPINAME, (Object)pSDESADetailBase.getInPSDEServiceAPIName());
        }
        if (pSDESADetailBase.isMemoDirty() && (bl || pSDESADetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESADetailBase.getMemo());
        }
        if (pSDESADetailBase.isMethodTagDirty() && (bl || pSDESADetailBase.getMethodTag() != null)) {
            iDataObject.set(FIELD_METHODTAG, (Object)pSDESADetailBase.getMethodTag());
        }
        if (pSDESADetailBase.isNeedResourceKeyDirty() && (bl || pSDESADetailBase.getNeedResourceKey() != null)) {
            iDataObject.set(FIELD_NEEDRESOURCEKEY, (Object)pSDESADetailBase.getNeedResourceKey());
        }
        if (pSDESADetailBase.isNoServiceCodeNameDirty() && (bl || pSDESADetailBase.getNoServiceCodeName() != null)) {
            iDataObject.set(FIELD_NOSERVICECODENAME, (Object)pSDESADetailBase.getNoServiceCodeName());
        }
        if (pSDESADetailBase.isOrderValueDirty() && (bl || pSDESADetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESADetailBase.getOrderValue());
        }
        if (pSDESADetailBase.isOutPSDEServiceAPIIdDirty() && (bl || pSDESADetailBase.getOutPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_OUTPSDESERVICEAPIID, (Object)pSDESADetailBase.getOutPSDEServiceAPIId());
        }
        if (pSDESADetailBase.isOutPSDEServiceAPINameDirty() && (bl || pSDESADetailBase.getOutPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_OUTPSDESERVICEAPINAME, (Object)pSDESADetailBase.getOutPSDEServiceAPIName());
        }
        if (pSDESADetailBase.isParentKeyModeDirty() && (bl || pSDESADetailBase.getParentKeyMode() != null)) {
            iDataObject.set(FIELD_PARENTKEYMODE, (Object)pSDESADetailBase.getParentKeyMode());
        }
        if (pSDESADetailBase.isPSDEActionIdDirty() && (bl || pSDESADetailBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDESADetailBase.getPSDEActionId());
        }
        if (pSDESADetailBase.isPSDEActionNameDirty() && (bl || pSDESADetailBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDESADetailBase.getPSDEActionName());
        }
        if (pSDESADetailBase.isPSDEDQIdDirty() && (bl || pSDESADetailBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDESADetailBase.getPSDEDQId());
        }
        if (pSDESADetailBase.isPSDEDQNameDirty() && (bl || pSDESADetailBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDESADetailBase.getPSDEDQName());
        }
        if (pSDESADetailBase.isPSDEDSIdDirty() && (bl || pSDESADetailBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDESADetailBase.getPSDEDSId());
        }
        if (pSDESADetailBase.isPSDEDSNameDirty() && (bl || pSDESADetailBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDESADetailBase.getPSDEDSName());
        }
        if (pSDESADetailBase.isPSDEIdDirty() && (bl || pSDESADetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDESADetailBase.getPSDEId());
        }
        if (pSDESADetailBase.isPSDEOPPrivIdDirty() && (bl || pSDESADetailBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDESADetailBase.getPSDEOPPrivId());
        }
        if (pSDESADetailBase.isPSDEOPPrivNameDirty() && (bl || pSDESADetailBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDESADetailBase.getPSDEOPPrivName());
        }
        if (pSDESADetailBase.isPSDESADetailIdDirty() && (bl || pSDESADetailBase.getPSDESADetailId() != null)) {
            iDataObject.set(FIELD_PSDESADETAILID, (Object)pSDESADetailBase.getPSDESADetailId());
        }
        if (pSDESADetailBase.isPSDESADetailNameDirty() && (bl || pSDESADetailBase.getPSDESADetailName() != null)) {
            iDataObject.set(FIELD_PSDESADETAILNAME, (Object)pSDESADetailBase.getPSDESADetailName());
        }
        if (pSDESADetailBase.isPSDESARSIdDirty() && (bl || pSDESADetailBase.getPSDESARSId() != null)) {
            iDataObject.set(FIELD_PSDESARSID, (Object)pSDESADetailBase.getPSDESARSId());
        }
        if (pSDESADetailBase.isPSDESARSNameDirty() && (bl || pSDESADetailBase.getPSDESARSName() != null)) {
            iDataObject.set(FIELD_PSDESARSNAME, (Object)pSDESADetailBase.getPSDESARSName());
        }
        if (pSDESADetailBase.isPSDEServiceAPIIdDirty() && (bl || pSDESADetailBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSDESADetailBase.getPSDEServiceAPIId());
        }
        if (pSDESADetailBase.isPSDEServiceAPINameDirty() && (bl || pSDESADetailBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSDESADetailBase.getPSDEServiceAPIName());
        }
        if (pSDESADetailBase.isPSSysServiceAPIIdDirty() && (bl || pSDESADetailBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDESADetailBase.getPSSysServiceAPIId());
        }
        if (pSDESADetailBase.isPSSysSFPluginIdDirty() && (bl || pSDESADetailBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDESADetailBase.getPSSysSFPluginId());
        }
        if (pSDESADetailBase.isPSSysSFPluginNameDirty() && (bl || pSDESADetailBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDESADetailBase.getPSSysSFPluginName());
        }
        if (pSDESADetailBase.isRequestFieldDirty() && (bl || pSDESADetailBase.getRequestField() != null)) {
            iDataObject.set(FIELD_REQUESTFIELD, (Object)pSDESADetailBase.getRequestField());
        }
        if (pSDESADetailBase.isRequestMethodDirty() && (bl || pSDESADetailBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSDESADetailBase.getRequestMethod());
        }
        if (pSDESADetailBase.isRequestParamTypeDirty() && (bl || pSDESADetailBase.getRequestParamType() != null)) {
            iDataObject.set(FIELD_REQUESTPARAMTYPE, (Object)pSDESADetailBase.getRequestParamType());
        }
        if (pSDESADetailBase.isRetValTypeDirty() && (bl || pSDESADetailBase.getRetValType() != null)) {
            iDataObject.set(FIELD_RETVALTYPE, (Object)pSDESADetailBase.getRetValType());
        }
        if (pSDESADetailBase.isServiceUrlDirty() && (bl || pSDESADetailBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSDESADetailBase.getServiceUrl());
        }
        if (pSDESADetailBase.isUniqueTagDirty() && (bl || pSDESADetailBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSDESADetailBase.getUniqueTag());
        }
        if (pSDESADetailBase.isUpdateDateDirty() && (bl || pSDESADetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESADetailBase.getUpdateDate());
        }
        if (pSDESADetailBase.isUpdateManDirty() && (bl || pSDESADetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESADetailBase.getUpdateMan());
        }
        if (pSDESADetailBase.isUserCatDirty() && (bl || pSDESADetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDESADetailBase.getUserCat());
        }
        if (pSDESADetailBase.isUserTagDirty() && (bl || pSDESADetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDESADetailBase.getUserTag());
        }
        if (pSDESADetailBase.isUserTag2Dirty() && (bl || pSDESADetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDESADetailBase.getUserTag2());
        }
        if (pSDESADetailBase.isUserTag3Dirty() && (bl || pSDESADetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDESADetailBase.getUserTag3());
        }
        if (pSDESADetailBase.isUserTag4Dirty() && (bl || pSDESADetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDESADetailBase.getUserTag4());
        }
        if (pSDESADetailBase.isValidFlagDirty() && (bl || pSDESADetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDESADetailBase.getValidFlag());
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
        return PSDESADetailBase.remove(this, n);
    }

    private static boolean remove(PSDESADetailBase pSDESADetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESADetailBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDESADetailBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDESADetailBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDESADetailBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDESADetailBase.resetDetailParam();
                return true;
            }
            case 5: {
                pSDESADetailBase.resetDetailParam2();
                return true;
            }
            case 6: {
                pSDESADetailBase.resetDetailType();
                return true;
            }
            case 7: {
                pSDESADetailBase.resetInPSDEServiceAPIId();
                return true;
            }
            case 8: {
                pSDESADetailBase.resetInPSDEServiceAPIName();
                return true;
            }
            case 9: {
                pSDESADetailBase.resetMemo();
                return true;
            }
            case 10: {
                pSDESADetailBase.resetMethodTag();
                return true;
            }
            case 11: {
                pSDESADetailBase.resetNeedResourceKey();
                return true;
            }
            case 12: {
                pSDESADetailBase.resetNoServiceCodeName();
                return true;
            }
            case 13: {
                pSDESADetailBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSDESADetailBase.resetOutPSDEServiceAPIId();
                return true;
            }
            case 15: {
                pSDESADetailBase.resetOutPSDEServiceAPIName();
                return true;
            }
            case 16: {
                pSDESADetailBase.resetParentKeyMode();
                return true;
            }
            case 17: {
                pSDESADetailBase.resetPSDEActionId();
                return true;
            }
            case 18: {
                pSDESADetailBase.resetPSDEActionName();
                return true;
            }
            case 19: {
                pSDESADetailBase.resetPSDEDQId();
                return true;
            }
            case 20: {
                pSDESADetailBase.resetPSDEDQName();
                return true;
            }
            case 21: {
                pSDESADetailBase.resetPSDEDSId();
                return true;
            }
            case 22: {
                pSDESADetailBase.resetPSDEDSName();
                return true;
            }
            case 23: {
                pSDESADetailBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSDESADetailBase.resetPSDEOPPrivId();
                return true;
            }
            case 25: {
                pSDESADetailBase.resetPSDEOPPrivName();
                return true;
            }
            case 26: {
                pSDESADetailBase.resetPSDESADetailId();
                return true;
            }
            case 27: {
                pSDESADetailBase.resetPSDESADetailName();
                return true;
            }
            case 28: {
                pSDESADetailBase.resetPSDESARSId();
                return true;
            }
            case 29: {
                pSDESADetailBase.resetPSDESARSName();
                return true;
            }
            case 30: {
                pSDESADetailBase.resetPSDEServiceAPIId();
                return true;
            }
            case 31: {
                pSDESADetailBase.resetPSDEServiceAPIName();
                return true;
            }
            case 32: {
                pSDESADetailBase.resetPSSysServiceAPIId();
                return true;
            }
            case 33: {
                pSDESADetailBase.resetPSSysSFPluginId();
                return true;
            }
            case 34: {
                pSDESADetailBase.resetPSSysSFPluginName();
                return true;
            }
            case 35: {
                pSDESADetailBase.resetRequestField();
                return true;
            }
            case 36: {
                pSDESADetailBase.resetRequestMethod();
                return true;
            }
            case 37: {
                pSDESADetailBase.resetRequestParamType();
                return true;
            }
            case 38: {
                pSDESADetailBase.resetRetValType();
                return true;
            }
            case 39: {
                pSDESADetailBase.resetServiceUrl();
                return true;
            }
            case 40: {
                pSDESADetailBase.resetUniqueTag();
                return true;
            }
            case 41: {
                pSDESADetailBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSDESADetailBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSDESADetailBase.resetUserCat();
                return true;
            }
            case 44: {
                pSDESADetailBase.resetUserTag();
                return true;
            }
            case 45: {
                pSDESADetailBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSDESADetailBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSDESADetailBase.resetUserTag4();
                return true;
            }
            case 48: {
                pSDESADetailBase.resetValidFlag();
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
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESARS getPSDESARS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESARS();
        }
        if (this.getPSDESARSId() == null) {
            return null;
        }
        Integer n = this.objPSDESARSLock;
        synchronized (n) {
            if (this.psdesars != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESARSId(), (Object)this.psdesars.getPSDESARSId()) != 0L) {
                this.psdesars = null;
            }
            if (this.psdesars == null) {
                PSDESARS pSDESARS = new PSDESARS();
                pSDESARS.setPSDESARSId(this.getPSDESARSId());
                PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
                pSDESARSService.autoGet((IEntity)pSDESARS);
                this.psdesars = pSDESARS;
            }
            return this.psdesars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getInPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEServiceAPI();
        }
        if (this.getInPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objInPSDEServiceAPILock;
        synchronized (n) {
            if (this.inpsdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getInPSDEServiceAPIId(), (Object)this.inpsdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.inpsdeserviceapi = null;
            }
            if (this.inpsdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getInPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet((IEntity)pSDEServiceAPI);
                this.inpsdeserviceapi = pSDEServiceAPI;
            }
            return this.inpsdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getOutPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEServiceAPI();
        }
        if (this.getOutPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objOutPSDEServiceAPILock;
        synchronized (n) {
            if (this.outpsdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSDEServiceAPIId(), (Object)this.outpsdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.outpsdeserviceapi = null;
            }
            if (this.outpsdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getOutPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet((IEntity)pSDEServiceAPI);
                this.outpsdeserviceapi = pSDEServiceAPI;
            }
            return this.outpsdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPI();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDEServiceAPILock;
        synchronized (n) {
            if (this.psdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEServiceAPIId(), (Object)this.psdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.psdeserviceapi = null;
            }
            if (this.psdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet((IEntity)pSDEServiceAPI);
                this.psdeserviceapi = pSDEServiceAPI;
            }
            return this.psdeserviceapi;
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
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESADetailParam> getPSDESADetailParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESADetailParams();
        }
        if (this.getPSDESADetailId() == null) {
            return null;
        }
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESADetailParamsLock;
        synchronized (n) {
            if (this.psdesadetailparams == null) {
                this.psdesadetailparams = pSDESADetailService.isTempData((IEntity)this) ? pSDESADetailParamService.selectTempByPSDESADetail(this) : pSDESADetailParamService.selectByPSDESADetail(this);
            }
            return this.psdesadetailparams;
        }
    }

    private PSDESADetailBase getProxyEntity() {
        return this.proxyPSDESADetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESADetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESADetailBase) {
            this.proxyPSDESADetailBase = (PSDESADetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DETAILPARAM, 4);
        fieldIndexMap.put(FIELD_DETAILPARAM2, 5);
        fieldIndexMap.put(FIELD_DETAILTYPE, 6);
        fieldIndexMap.put(FIELD_INPSDESERVICEAPIID, 7);
        fieldIndexMap.put(FIELD_INPSDESERVICEAPINAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_METHODTAG, 10);
        fieldIndexMap.put(FIELD_NEEDRESOURCEKEY, 11);
        fieldIndexMap.put(FIELD_NOSERVICECODENAME, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_OUTPSDESERVICEAPIID, 14);
        fieldIndexMap.put(FIELD_OUTPSDESERVICEAPINAME, 15);
        fieldIndexMap.put(FIELD_PARENTKEYMODE, 16);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 17);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 18);
        fieldIndexMap.put(FIELD_PSDEDQID, 19);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 20);
        fieldIndexMap.put(FIELD_PSDEDSID, 21);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 24);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 25);
        fieldIndexMap.put(FIELD_PSDESADETAILID, 26);
        fieldIndexMap.put(FIELD_PSDESADETAILNAME, 27);
        fieldIndexMap.put(FIELD_PSDESARSID, 28);
        fieldIndexMap.put(FIELD_PSDESARSNAME, 29);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 30);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 31);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 33);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_REQUESTFIELD, 35);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 36);
        fieldIndexMap.put(FIELD_REQUESTPARAMTYPE, 37);
        fieldIndexMap.put(FIELD_RETVALTYPE, 38);
        fieldIndexMap.put(FIELD_SERVICEURL, 39);
        fieldIndexMap.put(FIELD_UNIQUETAG, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_USERCAT, 43);
        fieldIndexMap.put(FIELD_USERTAG, 44);
        fieldIndexMap.put(FIELD_USERTAG2, 45);
        fieldIndexMap.put(FIELD_USERTAG3, 46);
        fieldIndexMap.put(FIELD_USERTAG4, 47);
        fieldIndexMap.put(FIELD_VALIDFLAG, 48);
    }
}

