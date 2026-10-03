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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewServiceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewServiceBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODTAG = "METHODTAG";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWSERVICEID = "PSDEVIEWSERVICEID";
    public static final String FIELD_PSDEVIEWSERVICENAME = "PSDEVIEWSERVICENAME";
    public static final String FIELD_REQUESTFIELD = "REQUESTFIELD";
    public static final String FIELD_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String FIELD_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DETAILTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_METHODTAG = 4;
    private static final int INDEX_PSDEACTIONID = 5;
    private static final int INDEX_PSDEACTIONNAME = 6;
    private static final int INDEX_PSDEDQID = 7;
    private static final int INDEX_PSDEDQNAME = 8;
    private static final int INDEX_PSDEDSID = 9;
    private static final int INDEX_PSDEDSNAME = 10;
    private static final int INDEX_PSDEVIEWBASEID = 11;
    private static final int INDEX_PSDEVIEWBASENAME = 12;
    private static final int INDEX_PSDEVIEWSERVICEID = 13;
    private static final int INDEX_PSDEVIEWSERVICENAME = 14;
    private static final int INDEX_REQUESTFIELD = 15;
    private static final int INDEX_REQUESTMETHOD = 16;
    private static final int INDEX_REQUESTPARAMTYPE = 17;
    private static final int INDEX_UNIQUETAG = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewServiceBase proxyPSDEViewServiceBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodtagDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewserviceidDirtyFlag = false;
    private boolean psdeviewservicenameDirtyFlag = false;
    private boolean requestfieldDirtyFlag = false;
    private boolean requestmethodDirtyFlag = false;
    private boolean requestparamtypeDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="memo")
    private String memo;
    @Column(name="methodtag")
    private String methodtag;
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
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewserviceid")
    private String psdeviewserviceid;
    @Column(name="psdeviewservicename")
    private String psdeviewservicename;
    @Column(name="requestfield")
    private String requestfield;
    @Column(name="requestmethod")
    private String requestmethod;
    @Column(name="requestparamtype")
    private String requestparamtype;
    @Column(name="uniquetag")
    private String uniquetag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;

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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewserviceid = string;
        this.psdeviewserviceidDirtyFlag = true;
    }

    public String getPSDEViewServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewServiceId();
        }
        return this.psdeviewserviceid;
    }

    public boolean isPSDEViewServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewServiceIdDirty();
        }
        return this.psdeviewserviceidDirtyFlag;
    }

    public void resetPSDEViewServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewServiceId();
            return;
        }
        this.psdeviewserviceidDirtyFlag = false;
        this.psdeviewserviceid = null;
    }

    public void setPSDEViewServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewservicename = string;
        this.psdeviewservicenameDirtyFlag = true;
    }

    public String getPSDEViewServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewServiceName();
        }
        return this.psdeviewservicename;
    }

    public boolean isPSDEViewServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewServiceNameDirty();
        }
        return this.psdeviewservicenameDirtyFlag;
    }

    public void resetPSDEViewServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewServiceName();
            return;
        }
        this.psdeviewservicenameDirtyFlag = false;
        this.psdeviewservicename = null;
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

    protected void onReset() {
        PSDEViewServiceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewServiceBase pSDEViewServiceBase) {
        pSDEViewServiceBase.resetCreateDate();
        pSDEViewServiceBase.resetCreateMan();
        pSDEViewServiceBase.resetDetailType();
        pSDEViewServiceBase.resetMemo();
        pSDEViewServiceBase.resetMethodTag();
        pSDEViewServiceBase.resetPSDEActionId();
        pSDEViewServiceBase.resetPSDEActionName();
        pSDEViewServiceBase.resetPSDEDQId();
        pSDEViewServiceBase.resetPSDEDQName();
        pSDEViewServiceBase.resetPSDEDSId();
        pSDEViewServiceBase.resetPSDEDSName();
        pSDEViewServiceBase.resetPSDEViewBaseId();
        pSDEViewServiceBase.resetPSDEViewBaseName();
        pSDEViewServiceBase.resetPSDEViewServiceId();
        pSDEViewServiceBase.resetPSDEViewServiceName();
        pSDEViewServiceBase.resetRequestField();
        pSDEViewServiceBase.resetRequestMethod();
        pSDEViewServiceBase.resetRequestParamType();
        pSDEViewServiceBase.resetUniqueTag();
        pSDEViewServiceBase.resetUpdateDate();
        pSDEViewServiceBase.resetUpdateMan();
        pSDEViewServiceBase.resetUserTag();
        pSDEViewServiceBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodTagDirty()) {
            hashMap.put(FIELD_METHODTAG, this.getMethodTag());
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
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewServiceIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWSERVICEID, this.getPSDEViewServiceId());
        }
        if (!bl || this.isPSDEViewServiceNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWSERVICENAME, this.getPSDEViewServiceName());
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
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        return PSDEViewServiceBase.get(this, n);
    }

    private static Object get(PSDEViewServiceBase pSDEViewServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewServiceBase.getCreateDate();
            }
            case 1: {
                return pSDEViewServiceBase.getCreateMan();
            }
            case 2: {
                return pSDEViewServiceBase.getDetailType();
            }
            case 3: {
                return pSDEViewServiceBase.getMemo();
            }
            case 4: {
                return pSDEViewServiceBase.getMethodTag();
            }
            case 5: {
                return pSDEViewServiceBase.getPSDEActionId();
            }
            case 6: {
                return pSDEViewServiceBase.getPSDEActionName();
            }
            case 7: {
                return pSDEViewServiceBase.getPSDEDQId();
            }
            case 8: {
                return pSDEViewServiceBase.getPSDEDQName();
            }
            case 9: {
                return pSDEViewServiceBase.getPSDEDSId();
            }
            case 10: {
                return pSDEViewServiceBase.getPSDEDSName();
            }
            case 11: {
                return pSDEViewServiceBase.getPSDEViewBaseId();
            }
            case 12: {
                return pSDEViewServiceBase.getPSDEViewBaseName();
            }
            case 13: {
                return pSDEViewServiceBase.getPSDEViewServiceId();
            }
            case 14: {
                return pSDEViewServiceBase.getPSDEViewServiceName();
            }
            case 15: {
                return pSDEViewServiceBase.getRequestField();
            }
            case 16: {
                return pSDEViewServiceBase.getRequestMethod();
            }
            case 17: {
                return pSDEViewServiceBase.getRequestParamType();
            }
            case 18: {
                return pSDEViewServiceBase.getUniqueTag();
            }
            case 19: {
                return pSDEViewServiceBase.getUpdateDate();
            }
            case 20: {
                return pSDEViewServiceBase.getUpdateMan();
            }
            case 21: {
                return pSDEViewServiceBase.getUserTag();
            }
            case 22: {
                return pSDEViewServiceBase.getUserTag2();
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
        PSDEViewServiceBase.set(this, n, object);
    }

    private static void set(PSDEViewServiceBase pSDEViewServiceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewServiceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewServiceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewServiceBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewServiceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewServiceBase.setMethodTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewServiceBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewServiceBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewServiceBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewServiceBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewServiceBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewServiceBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewServiceBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewServiceBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewServiceBase.setPSDEViewServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewServiceBase.setPSDEViewServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewServiceBase.setRequestField(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewServiceBase.setRequestMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewServiceBase.setRequestParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewServiceBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewServiceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewServiceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewServiceBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewServiceBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEViewServiceBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewServiceBase pSDEViewServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewServiceBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewServiceBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewServiceBase.getDetailType() == null;
            }
            case 3: {
                return pSDEViewServiceBase.getMemo() == null;
            }
            case 4: {
                return pSDEViewServiceBase.getMethodTag() == null;
            }
            case 5: {
                return pSDEViewServiceBase.getPSDEActionId() == null;
            }
            case 6: {
                return pSDEViewServiceBase.getPSDEActionName() == null;
            }
            case 7: {
                return pSDEViewServiceBase.getPSDEDQId() == null;
            }
            case 8: {
                return pSDEViewServiceBase.getPSDEDQName() == null;
            }
            case 9: {
                return pSDEViewServiceBase.getPSDEDSId() == null;
            }
            case 10: {
                return pSDEViewServiceBase.getPSDEDSName() == null;
            }
            case 11: {
                return pSDEViewServiceBase.getPSDEViewBaseId() == null;
            }
            case 12: {
                return pSDEViewServiceBase.getPSDEViewBaseName() == null;
            }
            case 13: {
                return pSDEViewServiceBase.getPSDEViewServiceId() == null;
            }
            case 14: {
                return pSDEViewServiceBase.getPSDEViewServiceName() == null;
            }
            case 15: {
                return pSDEViewServiceBase.getRequestField() == null;
            }
            case 16: {
                return pSDEViewServiceBase.getRequestMethod() == null;
            }
            case 17: {
                return pSDEViewServiceBase.getRequestParamType() == null;
            }
            case 18: {
                return pSDEViewServiceBase.getUniqueTag() == null;
            }
            case 19: {
                return pSDEViewServiceBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDEViewServiceBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDEViewServiceBase.getUserTag() == null;
            }
            case 22: {
                return pSDEViewServiceBase.getUserTag2() == null;
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
        return PSDEViewServiceBase.contains(this, n);
    }

    private static boolean contains(PSDEViewServiceBase pSDEViewServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewServiceBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewServiceBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewServiceBase.isDetailTypeDirty();
            }
            case 3: {
                return pSDEViewServiceBase.isMemoDirty();
            }
            case 4: {
                return pSDEViewServiceBase.isMethodTagDirty();
            }
            case 5: {
                return pSDEViewServiceBase.isPSDEActionIdDirty();
            }
            case 6: {
                return pSDEViewServiceBase.isPSDEActionNameDirty();
            }
            case 7: {
                return pSDEViewServiceBase.isPSDEDQIdDirty();
            }
            case 8: {
                return pSDEViewServiceBase.isPSDEDQNameDirty();
            }
            case 9: {
                return pSDEViewServiceBase.isPSDEDSIdDirty();
            }
            case 10: {
                return pSDEViewServiceBase.isPSDEDSNameDirty();
            }
            case 11: {
                return pSDEViewServiceBase.isPSDEViewBaseIdDirty();
            }
            case 12: {
                return pSDEViewServiceBase.isPSDEViewBaseNameDirty();
            }
            case 13: {
                return pSDEViewServiceBase.isPSDEViewServiceIdDirty();
            }
            case 14: {
                return pSDEViewServiceBase.isPSDEViewServiceNameDirty();
            }
            case 15: {
                return pSDEViewServiceBase.isRequestFieldDirty();
            }
            case 16: {
                return pSDEViewServiceBase.isRequestMethodDirty();
            }
            case 17: {
                return pSDEViewServiceBase.isRequestParamTypeDirty();
            }
            case 18: {
                return pSDEViewServiceBase.isUniqueTagDirty();
            }
            case 19: {
                return pSDEViewServiceBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDEViewServiceBase.isUpdateManDirty();
            }
            case 21: {
                return pSDEViewServiceBase.isUserTagDirty();
            }
            case 22: {
                return pSDEViewServiceBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewServiceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewServiceBase pSDEViewServiceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewServiceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getMethodTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodtag", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getMethodTag()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewserviceid", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEViewServiceId()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewservicename", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getPSDEViewServiceName()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getRequestField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestfield", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getRequestField()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getRequestMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestmethod", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getRequestMethod()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getRequestParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"requestparamtype", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getRequestParamType()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEViewServiceBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEViewServiceBase.getJSONValue((Object)pSDEViewServiceBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewServiceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewServiceBase pSDEViewServiceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewServiceBase.getCreateDate() != null) {
            object = pSDEViewServiceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewServiceBase.getCreateMan() != null) {
            object = pSDEViewServiceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getDetailType() != null) {
            object = pSDEViewServiceBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getMemo() != null) {
            object = pSDEViewServiceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getMethodTag() != null) {
            object = pSDEViewServiceBase.getMethodTag();
            xmlNode.setAttribute(FIELD_METHODTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEActionId() != null) {
            object = pSDEViewServiceBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEActionName() != null) {
            object = pSDEViewServiceBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEDQId() != null) {
            object = pSDEViewServiceBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEDQName() != null) {
            object = pSDEViewServiceBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEDSId() != null) {
            object = pSDEViewServiceBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEDSName() != null) {
            object = pSDEViewServiceBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewBaseId() != null) {
            object = pSDEViewServiceBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewBaseName() != null) {
            object = pSDEViewServiceBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewServiceId() != null) {
            object = pSDEViewServiceBase.getPSDEViewServiceId();
            xmlNode.setAttribute(FIELD_PSDEVIEWSERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getPSDEViewServiceName() != null) {
            object = pSDEViewServiceBase.getPSDEViewServiceName();
            xmlNode.setAttribute(FIELD_PSDEVIEWSERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getRequestField() != null) {
            object = pSDEViewServiceBase.getRequestField();
            xmlNode.setAttribute(FIELD_REQUESTFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getRequestMethod() != null) {
            object = pSDEViewServiceBase.getRequestMethod();
            xmlNode.setAttribute(FIELD_REQUESTMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getRequestParamType() != null) {
            object = pSDEViewServiceBase.getRequestParamType();
            xmlNode.setAttribute(FIELD_REQUESTPARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getUniqueTag() != null) {
            object = pSDEViewServiceBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getUpdateDate() != null) {
            object = pSDEViewServiceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewServiceBase.getUpdateMan() != null) {
            object = pSDEViewServiceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getUserTag() != null) {
            object = pSDEViewServiceBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewServiceBase.getUserTag2() != null) {
            object = pSDEViewServiceBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewServiceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewServiceBase pSDEViewServiceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewServiceBase.isCreateDateDirty() && (bl || pSDEViewServiceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewServiceBase.getCreateDate());
        }
        if (pSDEViewServiceBase.isCreateManDirty() && (bl || pSDEViewServiceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewServiceBase.getCreateMan());
        }
        if (pSDEViewServiceBase.isDetailTypeDirty() && (bl || pSDEViewServiceBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDEViewServiceBase.getDetailType());
        }
        if (pSDEViewServiceBase.isMemoDirty() && (bl || pSDEViewServiceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewServiceBase.getMemo());
        }
        if (pSDEViewServiceBase.isMethodTagDirty() && (bl || pSDEViewServiceBase.getMethodTag() != null)) {
            iDataObject.set(FIELD_METHODTAG, (Object)pSDEViewServiceBase.getMethodTag());
        }
        if (pSDEViewServiceBase.isPSDEActionIdDirty() && (bl || pSDEViewServiceBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEViewServiceBase.getPSDEActionId());
        }
        if (pSDEViewServiceBase.isPSDEActionNameDirty() && (bl || pSDEViewServiceBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEViewServiceBase.getPSDEActionName());
        }
        if (pSDEViewServiceBase.isPSDEDQIdDirty() && (bl || pSDEViewServiceBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEViewServiceBase.getPSDEDQId());
        }
        if (pSDEViewServiceBase.isPSDEDQNameDirty() && (bl || pSDEViewServiceBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEViewServiceBase.getPSDEDQName());
        }
        if (pSDEViewServiceBase.isPSDEDSIdDirty() && (bl || pSDEViewServiceBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEViewServiceBase.getPSDEDSId());
        }
        if (pSDEViewServiceBase.isPSDEDSNameDirty() && (bl || pSDEViewServiceBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEViewServiceBase.getPSDEDSName());
        }
        if (pSDEViewServiceBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewServiceBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewServiceBase.getPSDEViewBaseId());
        }
        if (pSDEViewServiceBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewServiceBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewServiceBase.getPSDEViewBaseName());
        }
        if (pSDEViewServiceBase.isPSDEViewServiceIdDirty() && (bl || pSDEViewServiceBase.getPSDEViewServiceId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWSERVICEID, (Object)pSDEViewServiceBase.getPSDEViewServiceId());
        }
        if (pSDEViewServiceBase.isPSDEViewServiceNameDirty() && (bl || pSDEViewServiceBase.getPSDEViewServiceName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWSERVICENAME, (Object)pSDEViewServiceBase.getPSDEViewServiceName());
        }
        if (pSDEViewServiceBase.isRequestFieldDirty() && (bl || pSDEViewServiceBase.getRequestField() != null)) {
            iDataObject.set(FIELD_REQUESTFIELD, (Object)pSDEViewServiceBase.getRequestField());
        }
        if (pSDEViewServiceBase.isRequestMethodDirty() && (bl || pSDEViewServiceBase.getRequestMethod() != null)) {
            iDataObject.set(FIELD_REQUESTMETHOD, (Object)pSDEViewServiceBase.getRequestMethod());
        }
        if (pSDEViewServiceBase.isRequestParamTypeDirty() && (bl || pSDEViewServiceBase.getRequestParamType() != null)) {
            iDataObject.set(FIELD_REQUESTPARAMTYPE, (Object)pSDEViewServiceBase.getRequestParamType());
        }
        if (pSDEViewServiceBase.isUniqueTagDirty() && (bl || pSDEViewServiceBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSDEViewServiceBase.getUniqueTag());
        }
        if (pSDEViewServiceBase.isUpdateDateDirty() && (bl || pSDEViewServiceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewServiceBase.getUpdateDate());
        }
        if (pSDEViewServiceBase.isUpdateManDirty() && (bl || pSDEViewServiceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewServiceBase.getUpdateMan());
        }
        if (pSDEViewServiceBase.isUserTagDirty() && (bl || pSDEViewServiceBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEViewServiceBase.getUserTag());
        }
        if (pSDEViewServiceBase.isUserTag2Dirty() && (bl || pSDEViewServiceBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEViewServiceBase.getUserTag2());
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
        return PSDEViewServiceBase.remove(this, n);
    }

    private static boolean remove(PSDEViewServiceBase pSDEViewServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewServiceBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewServiceBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewServiceBase.resetDetailType();
                return true;
            }
            case 3: {
                pSDEViewServiceBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEViewServiceBase.resetMethodTag();
                return true;
            }
            case 5: {
                pSDEViewServiceBase.resetPSDEActionId();
                return true;
            }
            case 6: {
                pSDEViewServiceBase.resetPSDEActionName();
                return true;
            }
            case 7: {
                pSDEViewServiceBase.resetPSDEDQId();
                return true;
            }
            case 8: {
                pSDEViewServiceBase.resetPSDEDQName();
                return true;
            }
            case 9: {
                pSDEViewServiceBase.resetPSDEDSId();
                return true;
            }
            case 10: {
                pSDEViewServiceBase.resetPSDEDSName();
                return true;
            }
            case 11: {
                pSDEViewServiceBase.resetPSDEViewBaseId();
                return true;
            }
            case 12: {
                pSDEViewServiceBase.resetPSDEViewBaseName();
                return true;
            }
            case 13: {
                pSDEViewServiceBase.resetPSDEViewServiceId();
                return true;
            }
            case 14: {
                pSDEViewServiceBase.resetPSDEViewServiceName();
                return true;
            }
            case 15: {
                pSDEViewServiceBase.resetRequestField();
                return true;
            }
            case 16: {
                pSDEViewServiceBase.resetRequestMethod();
                return true;
            }
            case 17: {
                pSDEViewServiceBase.resetRequestParamType();
                return true;
            }
            case 18: {
                pSDEViewServiceBase.resetUniqueTag();
                return true;
            }
            case 19: {
                pSDEViewServiceBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDEViewServiceBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDEViewServiceBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDEViewServiceBase.resetUserTag2();
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
                pSDEDataQueryService.autoGet(pSDEDataQuery);
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    private PSDEViewServiceBase getProxyEntity() {
        return this.proxyPSDEViewServiceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewServiceBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewServiceBase) {
            this.proxyPSDEViewServiceBase = (PSDEViewServiceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DETAILTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_METHODTAG, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 5);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 6);
        fieldIndexMap.put(FIELD_PSDEDQID, 7);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 8);
        fieldIndexMap.put(FIELD_PSDEDSID, 9);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 11);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 12);
        fieldIndexMap.put(FIELD_PSDEVIEWSERVICEID, 13);
        fieldIndexMap.put(FIELD_PSDEVIEWSERVICENAME, 14);
        fieldIndexMap.put(FIELD_REQUESTFIELD, 15);
        fieldIndexMap.put(FIELD_REQUESTMETHOD, 16);
        fieldIndexMap.put(FIELD_REQUESTPARAMTYPE, 17);
        fieldIndexMap.put(FIELD_UNIQUETAG, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
    }
}

