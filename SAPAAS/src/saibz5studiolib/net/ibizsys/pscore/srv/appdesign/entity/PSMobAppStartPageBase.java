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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppStartPageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMobAppStartPageBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSMOBAPPSTARTPAGEID = "PSMOBAPPSTARTPAGEID";
    public static final String FIELD_PSMOBAPPSTARTPAGENAME = "PSMOBAPPSTARTPAGENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_RESSPEC = "RESSPEC";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_STARTPAGEFILE = "STARTPAGEFILE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPVIEWID = 4;
    private static final int INDEX_PSAPPVIEWNAME = 5;
    private static final int INDEX_PSMOBAPPSTARTPAGEID = 6;
    private static final int INDEX_PSMOBAPPSTARTPAGENAME = 7;
    private static final int INDEX_PSSYSAPPID = 8;
    private static final int INDEX_PSSYSAPPNAME = 9;
    private static final int INDEX_PSSYSIMAGEID = 10;
    private static final int INDEX_PSSYSIMAGENAME = 11;
    private static final int INDEX_RESSPEC = 12;
    private static final int INDEX_RESTYPE = 13;
    private static final int INDEX_STARTPAGEFILE = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMobAppStartPageBase proxyPSMobAppStartPageBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psmobappstartpageidDirtyFlag = false;
    private boolean psmobappstartpagenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean resspecDirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean startpagefileDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psmobappstartpageid")
    private String psmobappstartpageid;
    @Column(name="psmobappstartpagename")
    private String psmobappstartpagename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="resspec")
    private String resspec;
    @Column(name="restype")
    private String restype;
    @Column(name="startpagefile")
    private String startpagefile;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;

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

    public void setPSMobAppStartPageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppStartPageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobappstartpageid = string;
        this.psmobappstartpageidDirtyFlag = true;
    }

    public String getPSMobAppStartPageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppStartPageId();
        }
        return this.psmobappstartpageid;
    }

    public boolean isPSMobAppStartPageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppStartPageIdDirty();
        }
        return this.psmobappstartpageidDirtyFlag;
    }

    public void resetPSMobAppStartPageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppStartPageId();
            return;
        }
        this.psmobappstartpageidDirtyFlag = false;
        this.psmobappstartpageid = null;
    }

    public void setPSMobAppStartPageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppStartPageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobappstartpagename = string;
        this.psmobappstartpagenameDirtyFlag = true;
    }

    public String getPSMobAppStartPageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppStartPageName();
        }
        return this.psmobappstartpagename;
    }

    public boolean isPSMobAppStartPageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppStartPageNameDirty();
        }
        return this.psmobappstartpagenameDirtyFlag;
    }

    public void resetPSMobAppStartPageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppStartPageName();
            return;
        }
        this.psmobappstartpagenameDirtyFlag = false;
        this.psmobappstartpagename = null;
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

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setResSpec(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResSpec(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resspec = string;
        this.resspecDirtyFlag = true;
    }

    public String getResSpec() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResSpec();
        }
        return this.resspec;
    }

    public boolean isResSpecDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResSpecDirty();
        }
        return this.resspecDirtyFlag;
    }

    public void resetResSpec() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResSpec();
            return;
        }
        this.resspecDirtyFlag = false;
        this.resspec = null;
    }

    public void setResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restype = string;
        this.restypeDirtyFlag = true;
    }

    public String getResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResType();
        }
        return this.restype;
    }

    public boolean isResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTypeDirty();
        }
        return this.restypeDirtyFlag;
    }

    public void resetResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResType();
            return;
        }
        this.restypeDirtyFlag = false;
        this.restype = null;
    }

    public void setStartPageFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartPageFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startpagefile = string;
        this.startpagefileDirtyFlag = true;
    }

    public String getStartPageFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartPageFile();
        }
        return this.startpagefile;
    }

    public boolean isStartPageFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartPageFileDirty();
        }
        return this.startpagefileDirtyFlag;
    }

    public void resetStartPageFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartPageFile();
            return;
        }
        this.startpagefileDirtyFlag = false;
        this.startpagefile = null;
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
        PSMobAppStartPageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMobAppStartPageBase pSMobAppStartPageBase) {
        pSMobAppStartPageBase.resetCodeName();
        pSMobAppStartPageBase.resetCreateDate();
        pSMobAppStartPageBase.resetCreateMan();
        pSMobAppStartPageBase.resetMemo();
        pSMobAppStartPageBase.resetPSAppViewId();
        pSMobAppStartPageBase.resetPSAppViewName();
        pSMobAppStartPageBase.resetPSMobAppStartPageId();
        pSMobAppStartPageBase.resetPSMobAppStartPageName();
        pSMobAppStartPageBase.resetPSSysAppId();
        pSMobAppStartPageBase.resetPSSysAppName();
        pSMobAppStartPageBase.resetPSSysImageId();
        pSMobAppStartPageBase.resetPSSysImageName();
        pSMobAppStartPageBase.resetResSpec();
        pSMobAppStartPageBase.resetResType();
        pSMobAppStartPageBase.resetStartPageFile();
        pSMobAppStartPageBase.resetUpdateDate();
        pSMobAppStartPageBase.resetUpdateMan();
        pSMobAppStartPageBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSMobAppStartPageIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPSTARTPAGEID, this.getPSMobAppStartPageId());
        }
        if (!bl || this.isPSMobAppStartPageNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPSTARTPAGENAME, this.getPSMobAppStartPageName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isResSpecDirty()) {
            hashMap.put(FIELD_RESSPEC, this.getResSpec());
        }
        if (!bl || this.isResTypeDirty()) {
            hashMap.put(FIELD_RESTYPE, this.getResType());
        }
        if (!bl || this.isStartPageFileDirty()) {
            hashMap.put(FIELD_STARTPAGEFILE, this.getStartPageFile());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSMobAppStartPageBase.get(this, n);
    }

    private static Object get(PSMobAppStartPageBase pSMobAppStartPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppStartPageBase.getCodeName();
            }
            case 1: {
                return pSMobAppStartPageBase.getCreateDate();
            }
            case 2: {
                return pSMobAppStartPageBase.getCreateMan();
            }
            case 3: {
                return pSMobAppStartPageBase.getMemo();
            }
            case 4: {
                return pSMobAppStartPageBase.getPSAppViewId();
            }
            case 5: {
                return pSMobAppStartPageBase.getPSAppViewName();
            }
            case 6: {
                return pSMobAppStartPageBase.getPSMobAppStartPageId();
            }
            case 7: {
                return pSMobAppStartPageBase.getPSMobAppStartPageName();
            }
            case 8: {
                return pSMobAppStartPageBase.getPSSysAppId();
            }
            case 9: {
                return pSMobAppStartPageBase.getPSSysAppName();
            }
            case 10: {
                return pSMobAppStartPageBase.getPSSysImageId();
            }
            case 11: {
                return pSMobAppStartPageBase.getPSSysImageName();
            }
            case 12: {
                return pSMobAppStartPageBase.getResSpec();
            }
            case 13: {
                return pSMobAppStartPageBase.getResType();
            }
            case 14: {
                return pSMobAppStartPageBase.getStartPageFile();
            }
            case 15: {
                return pSMobAppStartPageBase.getUpdateDate();
            }
            case 16: {
                return pSMobAppStartPageBase.getUpdateMan();
            }
            case 17: {
                return pSMobAppStartPageBase.getValidFlag();
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
        PSMobAppStartPageBase.set(this, n, object);
    }

    private static void set(PSMobAppStartPageBase pSMobAppStartPageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppStartPageBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMobAppStartPageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMobAppStartPageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMobAppStartPageBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMobAppStartPageBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMobAppStartPageBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMobAppStartPageBase.setPSMobAppStartPageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMobAppStartPageBase.setPSMobAppStartPageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMobAppStartPageBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMobAppStartPageBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMobAppStartPageBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMobAppStartPageBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMobAppStartPageBase.setResSpec(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSMobAppStartPageBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMobAppStartPageBase.setStartPageFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMobAppStartPageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSMobAppStartPageBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSMobAppStartPageBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMobAppStartPageBase.isNull(this, n);
    }

    private static boolean isNull(PSMobAppStartPageBase pSMobAppStartPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppStartPageBase.getCodeName() == null;
            }
            case 1: {
                return pSMobAppStartPageBase.getCreateDate() == null;
            }
            case 2: {
                return pSMobAppStartPageBase.getCreateMan() == null;
            }
            case 3: {
                return pSMobAppStartPageBase.getMemo() == null;
            }
            case 4: {
                return pSMobAppStartPageBase.getPSAppViewId() == null;
            }
            case 5: {
                return pSMobAppStartPageBase.getPSAppViewName() == null;
            }
            case 6: {
                return pSMobAppStartPageBase.getPSMobAppStartPageId() == null;
            }
            case 7: {
                return pSMobAppStartPageBase.getPSMobAppStartPageName() == null;
            }
            case 8: {
                return pSMobAppStartPageBase.getPSSysAppId() == null;
            }
            case 9: {
                return pSMobAppStartPageBase.getPSSysAppName() == null;
            }
            case 10: {
                return pSMobAppStartPageBase.getPSSysImageId() == null;
            }
            case 11: {
                return pSMobAppStartPageBase.getPSSysImageName() == null;
            }
            case 12: {
                return pSMobAppStartPageBase.getResSpec() == null;
            }
            case 13: {
                return pSMobAppStartPageBase.getResType() == null;
            }
            case 14: {
                return pSMobAppStartPageBase.getStartPageFile() == null;
            }
            case 15: {
                return pSMobAppStartPageBase.getUpdateDate() == null;
            }
            case 16: {
                return pSMobAppStartPageBase.getUpdateMan() == null;
            }
            case 17: {
                return pSMobAppStartPageBase.getValidFlag() == null;
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
        return PSMobAppStartPageBase.contains(this, n);
    }

    private static boolean contains(PSMobAppStartPageBase pSMobAppStartPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppStartPageBase.isCodeNameDirty();
            }
            case 1: {
                return pSMobAppStartPageBase.isCreateDateDirty();
            }
            case 2: {
                return pSMobAppStartPageBase.isCreateManDirty();
            }
            case 3: {
                return pSMobAppStartPageBase.isMemoDirty();
            }
            case 4: {
                return pSMobAppStartPageBase.isPSAppViewIdDirty();
            }
            case 5: {
                return pSMobAppStartPageBase.isPSAppViewNameDirty();
            }
            case 6: {
                return pSMobAppStartPageBase.isPSMobAppStartPageIdDirty();
            }
            case 7: {
                return pSMobAppStartPageBase.isPSMobAppStartPageNameDirty();
            }
            case 8: {
                return pSMobAppStartPageBase.isPSSysAppIdDirty();
            }
            case 9: {
                return pSMobAppStartPageBase.isPSSysAppNameDirty();
            }
            case 10: {
                return pSMobAppStartPageBase.isPSSysImageIdDirty();
            }
            case 11: {
                return pSMobAppStartPageBase.isPSSysImageNameDirty();
            }
            case 12: {
                return pSMobAppStartPageBase.isResSpecDirty();
            }
            case 13: {
                return pSMobAppStartPageBase.isResTypeDirty();
            }
            case 14: {
                return pSMobAppStartPageBase.isStartPageFileDirty();
            }
            case 15: {
                return pSMobAppStartPageBase.isUpdateDateDirty();
            }
            case 16: {
                return pSMobAppStartPageBase.isUpdateManDirty();
            }
            case 17: {
                return pSMobAppStartPageBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMobAppStartPageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMobAppStartPageBase pSMobAppStartPageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMobAppStartPageBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getCodeName()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getMemo()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSMobAppStartPageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobappstartpageid", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSMobAppStartPageId()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSMobAppStartPageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobappstartpagename", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSMobAppStartPageName()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getResSpec() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resspec", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getResSpec()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getResType()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getStartPageFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpagefile", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getStartPageFile()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMobAppStartPageBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMobAppStartPageBase.getJSONValue((Object)pSMobAppStartPageBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMobAppStartPageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMobAppStartPageBase pSMobAppStartPageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMobAppStartPageBase.getCodeName() != null) {
            object = pSMobAppStartPageBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getCreateDate() != null) {
            object = pSMobAppStartPageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppStartPageBase.getCreateMan() != null) {
            object = pSMobAppStartPageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getMemo() != null) {
            object = pSMobAppStartPageBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSAppViewId() != null) {
            object = pSMobAppStartPageBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSAppViewName() != null) {
            object = pSMobAppStartPageBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSMobAppStartPageId() != null) {
            object = pSMobAppStartPageBase.getPSMobAppStartPageId();
            xmlNode.setAttribute(FIELD_PSMOBAPPSTARTPAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSMobAppStartPageName() != null) {
            object = pSMobAppStartPageBase.getPSMobAppStartPageName();
            xmlNode.setAttribute(FIELD_PSMOBAPPSTARTPAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSSysAppId() != null) {
            object = pSMobAppStartPageBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSSysAppName() != null) {
            object = pSMobAppStartPageBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSSysImageId() != null) {
            object = pSMobAppStartPageBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getPSSysImageName() != null) {
            object = pSMobAppStartPageBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getResSpec() != null) {
            object = pSMobAppStartPageBase.getResSpec();
            xmlNode.setAttribute(FIELD_RESSPEC, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getResType() != null) {
            object = pSMobAppStartPageBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getStartPageFile() != null) {
            object = pSMobAppStartPageBase.getStartPageFile();
            xmlNode.setAttribute(FIELD_STARTPAGEFILE, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getUpdateDate() != null) {
            object = pSMobAppStartPageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppStartPageBase.getUpdateMan() != null) {
            object = pSMobAppStartPageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppStartPageBase.getValidFlag() != null) {
            object = pSMobAppStartPageBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMobAppStartPageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMobAppStartPageBase pSMobAppStartPageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMobAppStartPageBase.isCodeNameDirty() && (bl || pSMobAppStartPageBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSMobAppStartPageBase.getCodeName());
        }
        if (pSMobAppStartPageBase.isCreateDateDirty() && (bl || pSMobAppStartPageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMobAppStartPageBase.getCreateDate());
        }
        if (pSMobAppStartPageBase.isCreateManDirty() && (bl || pSMobAppStartPageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMobAppStartPageBase.getCreateMan());
        }
        if (pSMobAppStartPageBase.isMemoDirty() && (bl || pSMobAppStartPageBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMobAppStartPageBase.getMemo());
        }
        if (pSMobAppStartPageBase.isPSAppViewIdDirty() && (bl || pSMobAppStartPageBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSMobAppStartPageBase.getPSAppViewId());
        }
        if (pSMobAppStartPageBase.isPSAppViewNameDirty() && (bl || pSMobAppStartPageBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSMobAppStartPageBase.getPSAppViewName());
        }
        if (pSMobAppStartPageBase.isPSMobAppStartPageIdDirty() && (bl || pSMobAppStartPageBase.getPSMobAppStartPageId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPSTARTPAGEID, (Object)pSMobAppStartPageBase.getPSMobAppStartPageId());
        }
        if (pSMobAppStartPageBase.isPSMobAppStartPageNameDirty() && (bl || pSMobAppStartPageBase.getPSMobAppStartPageName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPSTARTPAGENAME, (Object)pSMobAppStartPageBase.getPSMobAppStartPageName());
        }
        if (pSMobAppStartPageBase.isPSSysAppIdDirty() && (bl || pSMobAppStartPageBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSMobAppStartPageBase.getPSSysAppId());
        }
        if (pSMobAppStartPageBase.isPSSysAppNameDirty() && (bl || pSMobAppStartPageBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSMobAppStartPageBase.getPSSysAppName());
        }
        if (pSMobAppStartPageBase.isPSSysImageIdDirty() && (bl || pSMobAppStartPageBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSMobAppStartPageBase.getPSSysImageId());
        }
        if (pSMobAppStartPageBase.isPSSysImageNameDirty() && (bl || pSMobAppStartPageBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSMobAppStartPageBase.getPSSysImageName());
        }
        if (pSMobAppStartPageBase.isResSpecDirty() && (bl || pSMobAppStartPageBase.getResSpec() != null)) {
            iDataObject.set(FIELD_RESSPEC, (Object)pSMobAppStartPageBase.getResSpec());
        }
        if (pSMobAppStartPageBase.isResTypeDirty() && (bl || pSMobAppStartPageBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSMobAppStartPageBase.getResType());
        }
        if (pSMobAppStartPageBase.isStartPageFileDirty() && (bl || pSMobAppStartPageBase.getStartPageFile() != null)) {
            iDataObject.set(FIELD_STARTPAGEFILE, (Object)pSMobAppStartPageBase.getStartPageFile());
        }
        if (pSMobAppStartPageBase.isUpdateDateDirty() && (bl || pSMobAppStartPageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMobAppStartPageBase.getUpdateDate());
        }
        if (pSMobAppStartPageBase.isUpdateManDirty() && (bl || pSMobAppStartPageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMobAppStartPageBase.getUpdateMan());
        }
        if (pSMobAppStartPageBase.isValidFlagDirty() && (bl || pSMobAppStartPageBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMobAppStartPageBase.getValidFlag());
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
        return PSMobAppStartPageBase.remove(this, n);
    }

    private static boolean remove(PSMobAppStartPageBase pSMobAppStartPageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppStartPageBase.resetCodeName();
                return true;
            }
            case 1: {
                pSMobAppStartPageBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMobAppStartPageBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMobAppStartPageBase.resetMemo();
                return true;
            }
            case 4: {
                pSMobAppStartPageBase.resetPSAppViewId();
                return true;
            }
            case 5: {
                pSMobAppStartPageBase.resetPSAppViewName();
                return true;
            }
            case 6: {
                pSMobAppStartPageBase.resetPSMobAppStartPageId();
                return true;
            }
            case 7: {
                pSMobAppStartPageBase.resetPSMobAppStartPageName();
                return true;
            }
            case 8: {
                pSMobAppStartPageBase.resetPSSysAppId();
                return true;
            }
            case 9: {
                pSMobAppStartPageBase.resetPSSysAppName();
                return true;
            }
            case 10: {
                pSMobAppStartPageBase.resetPSSysImageId();
                return true;
            }
            case 11: {
                pSMobAppStartPageBase.resetPSSysImageName();
                return true;
            }
            case 12: {
                pSMobAppStartPageBase.resetResSpec();
                return true;
            }
            case 13: {
                pSMobAppStartPageBase.resetResType();
                return true;
            }
            case 14: {
                pSMobAppStartPageBase.resetStartPageFile();
                return true;
            }
            case 15: {
                pSMobAppStartPageBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSMobAppStartPageBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSMobAppStartPageBase.resetValidFlag();
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
                pSAppViewService.autoGet(pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
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
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    private PSMobAppStartPageBase getProxyEntity() {
        return this.proxyPSMobAppStartPageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMobAppStartPageBase = null;
        if (iDataObject != null && iDataObject instanceof PSMobAppStartPageBase) {
            this.proxyPSMobAppStartPageBase = (PSMobAppStartPageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 4);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 5);
        fieldIndexMap.put(FIELD_PSMOBAPPSTARTPAGEID, 6);
        fieldIndexMap.put(FIELD_PSMOBAPPSTARTPAGENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 10);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 11);
        fieldIndexMap.put(FIELD_RESSPEC, 12);
        fieldIndexMap.put(FIELD_RESTYPE, 13);
        fieldIndexMap.put(FIELD_STARTPAGEFILE, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

