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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewCodeBase.class);
    public static final String FIELD_CODEPATH = "CODEPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MERGECODE = "MERGECODE";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSAPPVIEWCODEID = "PSAPPVIEWCODEID";
    public static final String FIELD_PSAPPVIEWCODENAME = "PSAPPVIEWCODENAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PUBCODE = "PUBCODE";
    public static final String FIELD_UISTYLE = "UISTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCODE = "USERCODE";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODEPATH = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MERGECODE = 4;
    private static final int INDEX_PRJTYPE = 5;
    private static final int INDEX_PSAPPVIEWCODEID = 6;
    private static final int INDEX_PSAPPVIEWCODENAME = 7;
    private static final int INDEX_PSAPPVIEWID = 8;
    private static final int INDEX_PSAPPVIEWNAME = 9;
    private static final int INDEX_PSPFPUBCODEID = 10;
    private static final int INDEX_PSPFPUBCODENAME = 11;
    private static final int INDEX_PSSYSAPPID = 12;
    private static final int INDEX_PSSYSAPPNAME = 13;
    private static final int INDEX_PUBCODE = 14;
    private static final int INDEX_UISTYLE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCODE = 18;
    private static final int INDEX_USERPARAMS = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewCodeBase proxyPSAppViewCodeBase = null;
    private boolean codepathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mergecodeDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean psappviewcodeidDirtyFlag = false;
    private boolean psappviewcodenameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pubcodeDirtyFlag = false;
    private boolean uistyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercodeDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codepath")
    private String codepath;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="mergecode")
    private String mergecode;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="psappviewcodeid")
    private String psappviewcodeid;
    @Column(name="psappviewcodename")
    private String psappviewcodename;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pubcode")
    private String pubcode;
    @Column(name="uistyle")
    private String uistyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercode")
    private String usercode;
    @Column(name="userparams")
    private String userparams;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

    public void setCodePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codepath = string;
        this.codepathDirtyFlag = true;
    }

    public String getCodePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodePath();
        }
        return this.codepath;
    }

    public boolean isCodePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodePathDirty();
        }
        return this.codepathDirtyFlag;
    }

    public void resetCodePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodePath();
            return;
        }
        this.codepathDirtyFlag = false;
        this.codepath = null;
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

    public void setMergeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMergeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mergecode = string;
        this.mergecodeDirtyFlag = true;
    }

    public String getMergeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMergeCode();
        }
        return this.mergecode;
    }

    public boolean isMergeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMergeCodeDirty();
        }
        return this.mergecodeDirtyFlag;
    }

    public void resetMergeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMergeCode();
            return;
        }
        this.mergecodeDirtyFlag = false;
        this.mergecode = null;
    }

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
    }

    public void setPSAppViewCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewcodeid = string;
        this.psappviewcodeidDirtyFlag = true;
    }

    public String getPSAppViewCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCodeId();
        }
        return this.psappviewcodeid;
    }

    public boolean isPSAppViewCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewCodeIdDirty();
        }
        return this.psappviewcodeidDirtyFlag;
    }

    public void resetPSAppViewCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewCodeId();
            return;
        }
        this.psappviewcodeidDirtyFlag = false;
        this.psappviewcodeid = null;
    }

    public void setPSAppViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewcodename = string;
        this.psappviewcodenameDirtyFlag = true;
    }

    public String getPSAppViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCodeName();
        }
        return this.psappviewcodename;
    }

    public boolean isPSAppViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewCodeNameDirty();
        }
        return this.psappviewcodenameDirtyFlag;
    }

    public void resetPSAppViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewCodeName();
            return;
        }
        this.psappviewcodenameDirtyFlag = false;
        this.psappviewcodename = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodeid = string;
        this.pspfpubcodeidDirtyFlag = true;
    }

    public String getPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeId();
        }
        return this.pspfpubcodeid;
    }

    public boolean isPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeIdDirty();
        }
        return this.pspfpubcodeidDirtyFlag;
    }

    public void resetPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeId();
            return;
        }
        this.pspfpubcodeidDirtyFlag = false;
        this.pspfpubcodeid = null;
    }

    public void setPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodename = string;
        this.pspfpubcodenameDirtyFlag = true;
    }

    public String getPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeName();
        }
        return this.pspfpubcodename;
    }

    public boolean isPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeNameDirty();
        }
        return this.pspfpubcodenameDirtyFlag;
    }

    public void resetPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeName();
            return;
        }
        this.pspfpubcodenameDirtyFlag = false;
        this.pspfpubcodename = null;
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

    public void setPubCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubcode = string;
        this.pubcodeDirtyFlag = true;
    }

    public String getPubCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubCode();
        }
        return this.pubcode;
    }

    public boolean isPubCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubCodeDirty();
        }
        return this.pubcodeDirtyFlag;
    }

    public void resetPubCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubCode();
            return;
        }
        this.pubcodeDirtyFlag = false;
        this.pubcode = null;
    }

    public void setUIStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uistyle = string;
        this.uistyleDirtyFlag = true;
    }

    public String getUIStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIStyle();
        }
        return this.uistyle;
    }

    public boolean isUIStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIStyleDirty();
        }
        return this.uistyleDirtyFlag;
    }

    public void resetUIStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIStyle();
            return;
        }
        this.uistyleDirtyFlag = false;
        this.uistyle = null;
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

    public void setUserCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercode = string;
        this.usercodeDirtyFlag = true;
    }

    public String getUserCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCode();
        }
        return this.usercode;
    }

    public boolean isUserCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCodeDirty();
        }
        return this.usercodeDirtyFlag;
    }

    public void resetUserCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCode();
            return;
        }
        this.usercodeDirtyFlag = false;
        this.usercode = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSAppViewCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewCodeBase pSAppViewCodeBase) {
        pSAppViewCodeBase.resetCodePath();
        pSAppViewCodeBase.resetCreateDate();
        pSAppViewCodeBase.resetCreateMan();
        pSAppViewCodeBase.resetMemo();
        pSAppViewCodeBase.resetMergeCode();
        pSAppViewCodeBase.resetPrjType();
        pSAppViewCodeBase.resetPSAppViewCodeId();
        pSAppViewCodeBase.resetPSAppViewCodeName();
        pSAppViewCodeBase.resetPSAppViewId();
        pSAppViewCodeBase.resetPSAppViewName();
        pSAppViewCodeBase.resetPSPFPubCodeId();
        pSAppViewCodeBase.resetPSPFPubCodeName();
        pSAppViewCodeBase.resetPSSysAppId();
        pSAppViewCodeBase.resetPSSysAppName();
        pSAppViewCodeBase.resetPubCode();
        pSAppViewCodeBase.resetUIStyle();
        pSAppViewCodeBase.resetUpdateDate();
        pSAppViewCodeBase.resetUpdateMan();
        pSAppViewCodeBase.resetUserCode();
        pSAppViewCodeBase.resetUserParams();
        pSAppViewCodeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodePathDirty()) {
            hashMap.put(FIELD_CODEPATH, this.getCodePath());
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
        if (!bl || this.isMergeCodeDirty()) {
            hashMap.put(FIELD_MERGECODE, this.getMergeCode());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSAppViewCodeIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWCODEID, this.getPSAppViewCodeId());
        }
        if (!bl || this.isPSAppViewCodeNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWCODENAME, this.getPSAppViewCodeName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPubCodeDirty()) {
            hashMap.put(FIELD_PUBCODE, this.getPubCode());
        }
        if (!bl || this.isUIStyleDirty()) {
            hashMap.put(FIELD_UISTYLE, this.getUIStyle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCodeDirty()) {
            hashMap.put(FIELD_USERCODE, this.getUserCode());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSAppViewCodeBase.get(this, n);
    }

    private static Object get(PSAppViewCodeBase pSAppViewCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewCodeBase.getCodePath();
            }
            case 1: {
                return pSAppViewCodeBase.getCreateDate();
            }
            case 2: {
                return pSAppViewCodeBase.getCreateMan();
            }
            case 3: {
                return pSAppViewCodeBase.getMemo();
            }
            case 4: {
                return pSAppViewCodeBase.getMergeCode();
            }
            case 5: {
                return pSAppViewCodeBase.getPrjType();
            }
            case 6: {
                return pSAppViewCodeBase.getPSAppViewCodeId();
            }
            case 7: {
                return pSAppViewCodeBase.getPSAppViewCodeName();
            }
            case 8: {
                return pSAppViewCodeBase.getPSAppViewId();
            }
            case 9: {
                return pSAppViewCodeBase.getPSAppViewName();
            }
            case 10: {
                return pSAppViewCodeBase.getPSPFPubCodeId();
            }
            case 11: {
                return pSAppViewCodeBase.getPSPFPubCodeName();
            }
            case 12: {
                return pSAppViewCodeBase.getPSSysAppId();
            }
            case 13: {
                return pSAppViewCodeBase.getPSSysAppName();
            }
            case 14: {
                return pSAppViewCodeBase.getPubCode();
            }
            case 15: {
                return pSAppViewCodeBase.getUIStyle();
            }
            case 16: {
                return pSAppViewCodeBase.getUpdateDate();
            }
            case 17: {
                return pSAppViewCodeBase.getUpdateMan();
            }
            case 18: {
                return pSAppViewCodeBase.getUserCode();
            }
            case 19: {
                return pSAppViewCodeBase.getUserParams();
            }
            case 20: {
                return pSAppViewCodeBase.getValidFlag();
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
        PSAppViewCodeBase.set(this, n, object);
    }

    private static void set(PSAppViewCodeBase pSAppViewCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewCodeBase.setCodePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewCodeBase.setMergeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewCodeBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewCodeBase.setPSAppViewCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewCodeBase.setPSAppViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewCodeBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewCodeBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppViewCodeBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppViewCodeBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppViewCodeBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppViewCodeBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppViewCodeBase.setPubCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppViewCodeBase.setUIStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppViewCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSAppViewCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppViewCodeBase.setUserCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppViewCodeBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppViewCodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppViewCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewCodeBase pSAppViewCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewCodeBase.getCodePath() == null;
            }
            case 1: {
                return pSAppViewCodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppViewCodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppViewCodeBase.getMemo() == null;
            }
            case 4: {
                return pSAppViewCodeBase.getMergeCode() == null;
            }
            case 5: {
                return pSAppViewCodeBase.getPrjType() == null;
            }
            case 6: {
                return pSAppViewCodeBase.getPSAppViewCodeId() == null;
            }
            case 7: {
                return pSAppViewCodeBase.getPSAppViewCodeName() == null;
            }
            case 8: {
                return pSAppViewCodeBase.getPSAppViewId() == null;
            }
            case 9: {
                return pSAppViewCodeBase.getPSAppViewName() == null;
            }
            case 10: {
                return pSAppViewCodeBase.getPSPFPubCodeId() == null;
            }
            case 11: {
                return pSAppViewCodeBase.getPSPFPubCodeName() == null;
            }
            case 12: {
                return pSAppViewCodeBase.getPSSysAppId() == null;
            }
            case 13: {
                return pSAppViewCodeBase.getPSSysAppName() == null;
            }
            case 14: {
                return pSAppViewCodeBase.getPubCode() == null;
            }
            case 15: {
                return pSAppViewCodeBase.getUIStyle() == null;
            }
            case 16: {
                return pSAppViewCodeBase.getUpdateDate() == null;
            }
            case 17: {
                return pSAppViewCodeBase.getUpdateMan() == null;
            }
            case 18: {
                return pSAppViewCodeBase.getUserCode() == null;
            }
            case 19: {
                return pSAppViewCodeBase.getUserParams() == null;
            }
            case 20: {
                return pSAppViewCodeBase.getValidFlag() == null;
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
        return PSAppViewCodeBase.contains(this, n);
    }

    private static boolean contains(PSAppViewCodeBase pSAppViewCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewCodeBase.isCodePathDirty();
            }
            case 1: {
                return pSAppViewCodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppViewCodeBase.isCreateManDirty();
            }
            case 3: {
                return pSAppViewCodeBase.isMemoDirty();
            }
            case 4: {
                return pSAppViewCodeBase.isMergeCodeDirty();
            }
            case 5: {
                return pSAppViewCodeBase.isPrjTypeDirty();
            }
            case 6: {
                return pSAppViewCodeBase.isPSAppViewCodeIdDirty();
            }
            case 7: {
                return pSAppViewCodeBase.isPSAppViewCodeNameDirty();
            }
            case 8: {
                return pSAppViewCodeBase.isPSAppViewIdDirty();
            }
            case 9: {
                return pSAppViewCodeBase.isPSAppViewNameDirty();
            }
            case 10: {
                return pSAppViewCodeBase.isPSPFPubCodeIdDirty();
            }
            case 11: {
                return pSAppViewCodeBase.isPSPFPubCodeNameDirty();
            }
            case 12: {
                return pSAppViewCodeBase.isPSSysAppIdDirty();
            }
            case 13: {
                return pSAppViewCodeBase.isPSSysAppNameDirty();
            }
            case 14: {
                return pSAppViewCodeBase.isPubCodeDirty();
            }
            case 15: {
                return pSAppViewCodeBase.isUIStyleDirty();
            }
            case 16: {
                return pSAppViewCodeBase.isUpdateDateDirty();
            }
            case 17: {
                return pSAppViewCodeBase.isUpdateManDirty();
            }
            case 18: {
                return pSAppViewCodeBase.isUserCodeDirty();
            }
            case 19: {
                return pSAppViewCodeBase.isUserParamsDirty();
            }
            case 20: {
                return pSAppViewCodeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewCodeBase pSAppViewCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewCodeBase.getCodePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepath", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getCodePath()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getMergeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mergecode", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getMergeCode()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPrjType()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewcodeid", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSAppViewCodeId()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewcodename", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSAppViewCodeName()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getPubCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubcode", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getPubCode()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getUIStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uistyle", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getUIStyle()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getUserCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercode", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getUserCode()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppViewCodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppViewCodeBase.getJSONValue((Object)pSAppViewCodeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewCodeBase pSAppViewCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewCodeBase.getCodePath() != null) {
            object = pSAppViewCodeBase.getCodePath();
            xmlNode.setAttribute(FIELD_CODEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getCreateDate() != null) {
            object = pSAppViewCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewCodeBase.getCreateMan() != null) {
            object = pSAppViewCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getMemo() != null) {
            object = pSAppViewCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getMergeCode() != null) {
            object = pSAppViewCodeBase.getMergeCode();
            xmlNode.setAttribute(FIELD_MERGECODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPrjType() != null) {
            object = pSAppViewCodeBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewCodeId() != null) {
            object = pSAppViewCodeBase.getPSAppViewCodeId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewCodeName() != null) {
            object = pSAppViewCodeBase.getPSAppViewCodeName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewId() != null) {
            object = pSAppViewCodeBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSAppViewName() != null) {
            object = pSAppViewCodeBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSPFPubCodeId() != null) {
            object = pSAppViewCodeBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSPFPubCodeName() != null) {
            object = pSAppViewCodeBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSSysAppId() != null) {
            object = pSAppViewCodeBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPSSysAppName() != null) {
            object = pSAppViewCodeBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getPubCode() != null) {
            object = pSAppViewCodeBase.getPubCode();
            xmlNode.setAttribute(FIELD_PUBCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getUIStyle() != null) {
            object = pSAppViewCodeBase.getUIStyle();
            xmlNode.setAttribute(FIELD_UISTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getUpdateDate() != null) {
            object = pSAppViewCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewCodeBase.getUpdateMan() != null) {
            object = pSAppViewCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getUserCode() != null) {
            object = pSAppViewCodeBase.getUserCode();
            xmlNode.setAttribute(FIELD_USERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getUserParams() != null) {
            object = pSAppViewCodeBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewCodeBase.getValidFlag() != null) {
            object = pSAppViewCodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewCodeBase pSAppViewCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewCodeBase.isCodePathDirty() && (bl || pSAppViewCodeBase.getCodePath() != null)) {
            iDataObject.set(FIELD_CODEPATH, (Object)pSAppViewCodeBase.getCodePath());
        }
        if (pSAppViewCodeBase.isCreateDateDirty() && (bl || pSAppViewCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewCodeBase.getCreateDate());
        }
        if (pSAppViewCodeBase.isCreateManDirty() && (bl || pSAppViewCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewCodeBase.getCreateMan());
        }
        if (pSAppViewCodeBase.isMemoDirty() && (bl || pSAppViewCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewCodeBase.getMemo());
        }
        if (pSAppViewCodeBase.isMergeCodeDirty() && (bl || pSAppViewCodeBase.getMergeCode() != null)) {
            iDataObject.set(FIELD_MERGECODE, (Object)pSAppViewCodeBase.getMergeCode());
        }
        if (pSAppViewCodeBase.isPrjTypeDirty() && (bl || pSAppViewCodeBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSAppViewCodeBase.getPrjType());
        }
        if (pSAppViewCodeBase.isPSAppViewCodeIdDirty() && (bl || pSAppViewCodeBase.getPSAppViewCodeId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWCODEID, (Object)pSAppViewCodeBase.getPSAppViewCodeId());
        }
        if (pSAppViewCodeBase.isPSAppViewCodeNameDirty() && (bl || pSAppViewCodeBase.getPSAppViewCodeName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWCODENAME, (Object)pSAppViewCodeBase.getPSAppViewCodeName());
        }
        if (pSAppViewCodeBase.isPSAppViewIdDirty() && (bl || pSAppViewCodeBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppViewCodeBase.getPSAppViewId());
        }
        if (pSAppViewCodeBase.isPSAppViewNameDirty() && (bl || pSAppViewCodeBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppViewCodeBase.getPSAppViewName());
        }
        if (pSAppViewCodeBase.isPSPFPubCodeIdDirty() && (bl || pSAppViewCodeBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSAppViewCodeBase.getPSPFPubCodeId());
        }
        if (pSAppViewCodeBase.isPSPFPubCodeNameDirty() && (bl || pSAppViewCodeBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSAppViewCodeBase.getPSPFPubCodeName());
        }
        if (pSAppViewCodeBase.isPSSysAppIdDirty() && (bl || pSAppViewCodeBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppViewCodeBase.getPSSysAppId());
        }
        if (pSAppViewCodeBase.isPSSysAppNameDirty() && (bl || pSAppViewCodeBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppViewCodeBase.getPSSysAppName());
        }
        if (pSAppViewCodeBase.isPubCodeDirty() && (bl || pSAppViewCodeBase.getPubCode() != null)) {
            iDataObject.set(FIELD_PUBCODE, (Object)pSAppViewCodeBase.getPubCode());
        }
        if (pSAppViewCodeBase.isUIStyleDirty() && (bl || pSAppViewCodeBase.getUIStyle() != null)) {
            iDataObject.set(FIELD_UISTYLE, (Object)pSAppViewCodeBase.getUIStyle());
        }
        if (pSAppViewCodeBase.isUpdateDateDirty() && (bl || pSAppViewCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewCodeBase.getUpdateDate());
        }
        if (pSAppViewCodeBase.isUpdateManDirty() && (bl || pSAppViewCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewCodeBase.getUpdateMan());
        }
        if (pSAppViewCodeBase.isUserCodeDirty() && (bl || pSAppViewCodeBase.getUserCode() != null)) {
            iDataObject.set(FIELD_USERCODE, (Object)pSAppViewCodeBase.getUserCode());
        }
        if (pSAppViewCodeBase.isUserParamsDirty() && (bl || pSAppViewCodeBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppViewCodeBase.getUserParams());
        }
        if (pSAppViewCodeBase.isValidFlagDirty() && (bl || pSAppViewCodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppViewCodeBase.getValidFlag());
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
        return PSAppViewCodeBase.remove(this, n);
    }

    private static boolean remove(PSAppViewCodeBase pSAppViewCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewCodeBase.resetCodePath();
                return true;
            }
            case 1: {
                pSAppViewCodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppViewCodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppViewCodeBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppViewCodeBase.resetMergeCode();
                return true;
            }
            case 5: {
                pSAppViewCodeBase.resetPrjType();
                return true;
            }
            case 6: {
                pSAppViewCodeBase.resetPSAppViewCodeId();
                return true;
            }
            case 7: {
                pSAppViewCodeBase.resetPSAppViewCodeName();
                return true;
            }
            case 8: {
                pSAppViewCodeBase.resetPSAppViewId();
                return true;
            }
            case 9: {
                pSAppViewCodeBase.resetPSAppViewName();
                return true;
            }
            case 10: {
                pSAppViewCodeBase.resetPSPFPubCodeId();
                return true;
            }
            case 11: {
                pSAppViewCodeBase.resetPSPFPubCodeName();
                return true;
            }
            case 12: {
                pSAppViewCodeBase.resetPSSysAppId();
                return true;
            }
            case 13: {
                pSAppViewCodeBase.resetPSSysAppName();
                return true;
            }
            case 14: {
                pSAppViewCodeBase.resetPubCode();
                return true;
            }
            case 15: {
                pSAppViewCodeBase.resetUIStyle();
                return true;
            }
            case 16: {
                pSAppViewCodeBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSAppViewCodeBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSAppViewCodeBase.resetUserCode();
                return true;
            }
            case 19: {
                pSAppViewCodeBase.resetUserParams();
                return true;
            }
            case 20: {
                pSAppViewCodeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSPFPubCodeLock;
        synchronized (n) {
            if (this.pspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pspfpubcode = null;
            }
            if (this.pspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet((IEntity)pSPFPubCode);
                this.pspfpubcode = pSPFPubCode;
            }
            return this.pspfpubcode;
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSAppViewCodeBase getProxyEntity() {
        return this.proxyPSAppViewCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewCodeBase) {
            this.proxyPSAppViewCodeBase = (PSAppViewCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPATH, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MERGECODE, 4);
        fieldIndexMap.put(FIELD_PRJTYPE, 5);
        fieldIndexMap.put(FIELD_PSAPPVIEWCODEID, 6);
        fieldIndexMap.put(FIELD_PSAPPVIEWCODENAME, 7);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 8);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 9);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 10);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 12);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 13);
        fieldIndexMap.put(FIELD_PUBCODE, 14);
        fieldIndexMap.put(FIELD_UISTYLE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCODE, 18);
        fieldIndexMap.put(FIELD_USERPARAMS, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

