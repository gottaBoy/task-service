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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBVIEWFLAG = "MOBVIEWFLAG";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String FIELD_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    public static final String FIELD_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    public static final String FIELD_PSDYNADEID = "PSDYNADEID";
    public static final String FIELD_PSDYNADENAME = "PSDYNADENAME";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    public static final String FIELD_VIEWTYPE = "VIEWTYPE";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLEVIEWACTIONS = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MOBVIEWFLAG = 5;
    private static final int INDEX_PDVTPARAM = 6;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 7;
    private static final int INDEX_PSAPPMENUID = 8;
    private static final int INDEX_PSAPPMENUNAME = 9;
    private static final int INDEX_PSDYNAAPPID = 10;
    private static final int INDEX_PSDYNAAPPNAME = 11;
    private static final int INDEX_PSDYNAAPPVIEWID = 12;
    private static final int INDEX_PSDYNAAPPVIEWNAME = 13;
    private static final int INDEX_PSDYNADEID = 14;
    private static final int INDEX_PSDYNADENAME = 15;
    private static final int INDEX_PSWFDEID = 16;
    private static final int INDEX_PSWFDENAME = 17;
    private static final int INDEX_TITLE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final int INDEX_VIEWACTIONS = 22;
    private static final int INDEX_VIEWTYPE = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppViewBase proxyPSDynaAppViewBase = null;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobviewflagDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psdynaappidDirtyFlag = false;
    private boolean psdynaappnameDirtyFlag = false;
    private boolean psdynaappviewidDirtyFlag = false;
    private boolean psdynaappviewnameDirtyFlag = false;
    private boolean psdynadeidDirtyFlag = false;
    private boolean psdynadenameDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="memo")
    private String memo;
    @Column(name="mobviewflag")
    private Integer mobviewflag;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psdynaappid")
    private String psdynaappid;
    @Column(name="psdynaappname")
    private String psdynaappname;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;
    @Column(name="psdynaappviewname")
    private String psdynaappviewname;
    @Column(name="psdynadeid")
    private String psdynadeid;
    @Column(name="psdynadename")
    private String psdynadename;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewactions")
    private Integer viewactions;
    @Column(name="viewtype")
    private String viewtype;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objPSDynaAppLock = new Integer(1);
    private PSDynaApp psdynaapp = null;
    private Integer objPSDynaDELock = new Integer(1);
    private PSDynaDE psdynade = null;
    private Integer objPSWFDELock = new Integer(1);
    private PSWFDE pswfde = null;
    private Integer objPSDynaAppViewCtrlsLock = new Integer(1);
    private ArrayList<PSDynaAppViewCtrl> psdynaappviewctrls = null;

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setMobViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobViewFlag(n);
            return;
        }
        this.mobviewflag = n;
        this.mobviewflagDirtyFlag = true;
    }

    public Integer getMobViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobViewFlag();
        }
        return this.mobviewflag;
    }

    public boolean isMobViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobViewFlagDirty();
        }
        return this.mobviewflagDirtyFlag;
    }

    public void resetMobViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobViewFlag();
            return;
        }
        this.mobviewflagDirtyFlag = false;
        this.mobviewflag = null;
    }

    public void setPDVTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdvtparam = string;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPredefinedViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedviewtype = string;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
    }

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSDynaAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappid = string;
        this.psdynaappidDirtyFlag = true;
    }

    public String getPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppId();
        }
        return this.psdynaappid;
    }

    public boolean isPSDynaAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppIdDirty();
        }
        return this.psdynaappidDirtyFlag;
    }

    public void resetPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppId();
            return;
        }
        this.psdynaappidDirtyFlag = false;
        this.psdynaappid = null;
    }

    public void setPSDynaAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappname = string;
        this.psdynaappnameDirtyFlag = true;
    }

    public String getPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppName();
        }
        return this.psdynaappname;
    }

    public boolean isPSDynaAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppNameDirty();
        }
        return this.psdynaappnameDirtyFlag;
    }

    public void resetPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppName();
            return;
        }
        this.psdynaappnameDirtyFlag = false;
        this.psdynaappname = null;
    }

    public void setPSDynaAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewid = string;
        this.psdynaappviewidDirtyFlag = true;
    }

    public String getPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    public boolean isPSDynaAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    public void resetPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

    public void setPSDynaAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappviewname = string;
        this.psdynaappviewnameDirtyFlag = true;
    }

    public String getPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewName();
        }
        return this.psdynaappviewname;
    }

    public boolean isPSDynaAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewNameDirty();
        }
        return this.psdynaappviewnameDirtyFlag;
    }

    public void resetPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewName();
            return;
        }
        this.psdynaappviewnameDirtyFlag = false;
        this.psdynaappviewname = null;
    }

    public void setPSDynaDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeid = string;
        this.psdynadeidDirtyFlag = true;
    }

    public String getPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEId();
        }
        return this.psdynadeid;
    }

    public boolean isPSDynaDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEIdDirty();
        }
        return this.psdynadeidDirtyFlag;
    }

    public void resetPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEId();
            return;
        }
        this.psdynadeidDirtyFlag = false;
        this.psdynadeid = null;
    }

    public void setPSDynaDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadename = string;
        this.psdynadenameDirtyFlag = true;
    }

    public String getPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEName();
        }
        return this.psdynadename;
    }

    public boolean isPSDynaDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDENameDirty();
        }
        return this.psdynadenameDirtyFlag;
    }

    public void resetPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEName();
            return;
        }
        this.psdynadenameDirtyFlag = false;
        this.psdynadename = null;
    }

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdename = string;
        this.pswfdenameDirtyFlag = true;
    }

    public String getPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEName();
        }
        return this.pswfdename;
    }

    public boolean isPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDENameDirty();
        }
        return this.pswfdenameDirtyFlag;
    }

    public void resetPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEName();
            return;
        }
        this.pswfdenameDirtyFlag = false;
        this.pswfdename = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
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

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
    }

    public void setViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewtype = string;
        this.viewtypeDirtyFlag = true;
    }

    public String getViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    public boolean isViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    public void resetViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewType();
            return;
        }
        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }

    protected void onReset() {
        PSDynaAppViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppViewBase pSDynaAppViewBase) {
        pSDynaAppViewBase.resetCaption();
        pSDynaAppViewBase.resetCreateDate();
        pSDynaAppViewBase.resetCreateMan();
        pSDynaAppViewBase.resetEnableViewActions();
        pSDynaAppViewBase.resetMemo();
        pSDynaAppViewBase.resetMobViewFlag();
        pSDynaAppViewBase.resetPDVTParam();
        pSDynaAppViewBase.resetPredefinedViewType();
        pSDynaAppViewBase.resetPSAppMenuId();
        pSDynaAppViewBase.resetPSAppMenuName();
        pSDynaAppViewBase.resetPSDynaAppId();
        pSDynaAppViewBase.resetPSDynaAppName();
        pSDynaAppViewBase.resetPSDynaAppViewId();
        pSDynaAppViewBase.resetPSDynaAppViewName();
        pSDynaAppViewBase.resetPSDynaDEId();
        pSDynaAppViewBase.resetPSDynaDEName();
        pSDynaAppViewBase.resetPSWFDEId();
        pSDynaAppViewBase.resetPSWFDEName();
        pSDynaAppViewBase.resetTitle();
        pSDynaAppViewBase.resetUpdateDate();
        pSDynaAppViewBase.resetUpdateMan();
        pSDynaAppViewBase.resetValidFlag();
        pSDynaAppViewBase.resetViewActions();
        pSDynaAppViewBase.resetViewType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobViewFlagDirty()) {
            hashMap.put(FIELD_MOBVIEWFLAG, this.getMobViewFlag());
        }
        if (!bl || this.isPDVTParamDirty()) {
            hashMap.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bl || this.isPredefinedViewTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSDynaAppIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPID, this.getPSDynaAppId());
        }
        if (!bl || this.isPSDynaAppNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPNAME, this.getPSDynaAppName());
        }
        if (!bl || this.isPSDynaAppViewIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWID, this.getPSDynaAppViewId());
        }
        if (!bl || this.isPSDynaAppViewNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPVIEWNAME, this.getPSDynaAppViewName());
        }
        if (!bl || this.isPSDynaDEIdDirty()) {
            hashMap.put(FIELD_PSDYNADEID, this.getPSDynaDEId());
        }
        if (!bl || this.isPSDynaDENameDirty()) {
            hashMap.put(FIELD_PSDYNADENAME, this.getPSDynaDEName());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFDENameDirty()) {
            hashMap.put(FIELD_PSWFDENAME, this.getPSWFDEName());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
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
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
        }
        if (!bl || this.isViewTypeDirty()) {
            hashMap.put(FIELD_VIEWTYPE, this.getViewType());
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
        return PSDynaAppViewBase.get(this, n);
    }

    private static Object get(PSDynaAppViewBase pSDynaAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewBase.getCaption();
            }
            case 1: {
                return pSDynaAppViewBase.getCreateDate();
            }
            case 2: {
                return pSDynaAppViewBase.getCreateMan();
            }
            case 3: {
                return pSDynaAppViewBase.getEnableViewActions();
            }
            case 4: {
                return pSDynaAppViewBase.getMemo();
            }
            case 5: {
                return pSDynaAppViewBase.getMobViewFlag();
            }
            case 6: {
                return pSDynaAppViewBase.getPDVTParam();
            }
            case 7: {
                return pSDynaAppViewBase.getPredefinedViewType();
            }
            case 8: {
                return pSDynaAppViewBase.getPSAppMenuId();
            }
            case 9: {
                return pSDynaAppViewBase.getPSAppMenuName();
            }
            case 10: {
                return pSDynaAppViewBase.getPSDynaAppId();
            }
            case 11: {
                return pSDynaAppViewBase.getPSDynaAppName();
            }
            case 12: {
                return pSDynaAppViewBase.getPSDynaAppViewId();
            }
            case 13: {
                return pSDynaAppViewBase.getPSDynaAppViewName();
            }
            case 14: {
                return pSDynaAppViewBase.getPSDynaDEId();
            }
            case 15: {
                return pSDynaAppViewBase.getPSDynaDEName();
            }
            case 16: {
                return pSDynaAppViewBase.getPSWFDEId();
            }
            case 17: {
                return pSDynaAppViewBase.getPSWFDEName();
            }
            case 18: {
                return pSDynaAppViewBase.getTitle();
            }
            case 19: {
                return pSDynaAppViewBase.getUpdateDate();
            }
            case 20: {
                return pSDynaAppViewBase.getUpdateMan();
            }
            case 21: {
                return pSDynaAppViewBase.getValidFlag();
            }
            case 22: {
                return pSDynaAppViewBase.getViewActions();
            }
            case 23: {
                return pSDynaAppViewBase.getViewType();
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
        PSDynaAppViewBase.set(this, n, object);
    }

    private static void set(PSDynaAppViewBase pSDynaAppViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDynaAppViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDynaAppViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaAppViewBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDynaAppViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaAppViewBase.setMobViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDynaAppViewBase.setPDVTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaAppViewBase.setPredefinedViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaAppViewBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaAppViewBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaAppViewBase.setPSDynaAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaAppViewBase.setPSDynaAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaAppViewBase.setPSDynaAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaAppViewBase.setPSDynaAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaAppViewBase.setPSDynaDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaAppViewBase.setPSDynaDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaAppViewBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDynaAppViewBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDynaAppViewBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDynaAppViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDynaAppViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDynaAppViewBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDynaAppViewBase.setViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDynaAppViewBase.setViewType(DataObject.getStringValue((Object)object));
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
        return PSDynaAppViewBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaAppViewBase pSDynaAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewBase.getCaption() == null;
            }
            case 1: {
                return pSDynaAppViewBase.getCreateDate() == null;
            }
            case 2: {
                return pSDynaAppViewBase.getCreateMan() == null;
            }
            case 3: {
                return pSDynaAppViewBase.getEnableViewActions() == null;
            }
            case 4: {
                return pSDynaAppViewBase.getMemo() == null;
            }
            case 5: {
                return pSDynaAppViewBase.getMobViewFlag() == null;
            }
            case 6: {
                return pSDynaAppViewBase.getPDVTParam() == null;
            }
            case 7: {
                return pSDynaAppViewBase.getPredefinedViewType() == null;
            }
            case 8: {
                return pSDynaAppViewBase.getPSAppMenuId() == null;
            }
            case 9: {
                return pSDynaAppViewBase.getPSAppMenuName() == null;
            }
            case 10: {
                return pSDynaAppViewBase.getPSDynaAppId() == null;
            }
            case 11: {
                return pSDynaAppViewBase.getPSDynaAppName() == null;
            }
            case 12: {
                return pSDynaAppViewBase.getPSDynaAppViewId() == null;
            }
            case 13: {
                return pSDynaAppViewBase.getPSDynaAppViewName() == null;
            }
            case 14: {
                return pSDynaAppViewBase.getPSDynaDEId() == null;
            }
            case 15: {
                return pSDynaAppViewBase.getPSDynaDEName() == null;
            }
            case 16: {
                return pSDynaAppViewBase.getPSWFDEId() == null;
            }
            case 17: {
                return pSDynaAppViewBase.getPSWFDEName() == null;
            }
            case 18: {
                return pSDynaAppViewBase.getTitle() == null;
            }
            case 19: {
                return pSDynaAppViewBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDynaAppViewBase.getUpdateMan() == null;
            }
            case 21: {
                return pSDynaAppViewBase.getValidFlag() == null;
            }
            case 22: {
                return pSDynaAppViewBase.getViewActions() == null;
            }
            case 23: {
                return pSDynaAppViewBase.getViewType() == null;
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
        return PSDynaAppViewBase.contains(this, n);
    }

    private static boolean contains(PSDynaAppViewBase pSDynaAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppViewBase.isCaptionDirty();
            }
            case 1: {
                return pSDynaAppViewBase.isCreateDateDirty();
            }
            case 2: {
                return pSDynaAppViewBase.isCreateManDirty();
            }
            case 3: {
                return pSDynaAppViewBase.isEnableViewActionsDirty();
            }
            case 4: {
                return pSDynaAppViewBase.isMemoDirty();
            }
            case 5: {
                return pSDynaAppViewBase.isMobViewFlagDirty();
            }
            case 6: {
                return pSDynaAppViewBase.isPDVTParamDirty();
            }
            case 7: {
                return pSDynaAppViewBase.isPredefinedViewTypeDirty();
            }
            case 8: {
                return pSDynaAppViewBase.isPSAppMenuIdDirty();
            }
            case 9: {
                return pSDynaAppViewBase.isPSAppMenuNameDirty();
            }
            case 10: {
                return pSDynaAppViewBase.isPSDynaAppIdDirty();
            }
            case 11: {
                return pSDynaAppViewBase.isPSDynaAppNameDirty();
            }
            case 12: {
                return pSDynaAppViewBase.isPSDynaAppViewIdDirty();
            }
            case 13: {
                return pSDynaAppViewBase.isPSDynaAppViewNameDirty();
            }
            case 14: {
                return pSDynaAppViewBase.isPSDynaDEIdDirty();
            }
            case 15: {
                return pSDynaAppViewBase.isPSDynaDENameDirty();
            }
            case 16: {
                return pSDynaAppViewBase.isPSWFDEIdDirty();
            }
            case 17: {
                return pSDynaAppViewBase.isPSWFDENameDirty();
            }
            case 18: {
                return pSDynaAppViewBase.isTitleDirty();
            }
            case 19: {
                return pSDynaAppViewBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDynaAppViewBase.isUpdateManDirty();
            }
            case 21: {
                return pSDynaAppViewBase.isValidFlagDirty();
            }
            case 22: {
                return pSDynaAppViewBase.isViewActionsDirty();
            }
            case 23: {
                return pSDynaAppViewBase.isViewTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaAppViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaAppViewBase pSDynaAppViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaAppViewBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getCaption()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getMobViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobviewflag", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getMobViewFlag()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdvtparam", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPDVTParam()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedviewtype", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPredefinedViewType()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappid", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaAppId()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappname", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaAppName()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewid", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaAppViewId()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappviewname", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaAppViewName()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeid", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaDEId()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSDynaDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadename", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSDynaDEName()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getTitle()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getViewActions()), (boolean)false);
        }
        if (bl || pSDynaAppViewBase.getViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewtype", (Object)PSDynaAppViewBase.getJSONValue((Object)pSDynaAppViewBase.getViewType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaAppViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaAppViewBase pSDynaAppViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaAppViewBase.getCaption() != null) {
            object = pSDynaAppViewBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getCreateDate() != null) {
            object = pSDynaAppViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getCreateMan() != null) {
            object = pSDynaAppViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getEnableViewActions() != null) {
            object = pSDynaAppViewBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getMemo() != null) {
            object = pSDynaAppViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getMobViewFlag() != null) {
            object = pSDynaAppViewBase.getMobViewFlag();
            xmlNode.setAttribute(FIELD_MOBVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getPDVTParam() != null) {
            object = pSDynaAppViewBase.getPDVTParam();
            xmlNode.setAttribute(FIELD_PDVTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPredefinedViewType() != null) {
            object = pSDynaAppViewBase.getPredefinedViewType();
            xmlNode.setAttribute(FIELD_PREDEFINEDVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSAppMenuId() != null) {
            object = pSDynaAppViewBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSAppMenuName() != null) {
            object = pSDynaAppViewBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppId() != null) {
            object = pSDynaAppViewBase.getPSDynaAppId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppName() != null) {
            object = pSDynaAppViewBase.getPSDynaAppName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppViewId() != null) {
            object = pSDynaAppViewBase.getPSDynaAppViewId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaAppViewName() != null) {
            object = pSDynaAppViewBase.getPSDynaAppViewName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaDEId() != null) {
            object = pSDynaAppViewBase.getPSDynaDEId();
            xmlNode.setAttribute(FIELD_PSDYNADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSDynaDEName() != null) {
            object = pSDynaAppViewBase.getPSDynaDEName();
            xmlNode.setAttribute(FIELD_PSDYNADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSWFDEId() != null) {
            object = pSDynaAppViewBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getPSWFDEName() != null) {
            object = pSDynaAppViewBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getTitle() != null) {
            object = pSDynaAppViewBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getUpdateDate() != null) {
            object = pSDynaAppViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getUpdateMan() != null) {
            object = pSDynaAppViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppViewBase.getValidFlag() != null) {
            object = pSDynaAppViewBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getViewActions() != null) {
            object = pSDynaAppViewBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaAppViewBase.getViewType() != null) {
            object = pSDynaAppViewBase.getViewType();
            xmlNode.setAttribute(FIELD_VIEWTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaAppViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaAppViewBase pSDynaAppViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaAppViewBase.isCaptionDirty() && (bl || pSDynaAppViewBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDynaAppViewBase.getCaption());
        }
        if (pSDynaAppViewBase.isCreateDateDirty() && (bl || pSDynaAppViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaAppViewBase.getCreateDate());
        }
        if (pSDynaAppViewBase.isCreateManDirty() && (bl || pSDynaAppViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaAppViewBase.getCreateMan());
        }
        if (pSDynaAppViewBase.isEnableViewActionsDirty() && (bl || pSDynaAppViewBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDynaAppViewBase.getEnableViewActions());
        }
        if (pSDynaAppViewBase.isMemoDirty() && (bl || pSDynaAppViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaAppViewBase.getMemo());
        }
        if (pSDynaAppViewBase.isMobViewFlagDirty() && (bl || pSDynaAppViewBase.getMobViewFlag() != null)) {
            iDataObject.set(FIELD_MOBVIEWFLAG, (Object)pSDynaAppViewBase.getMobViewFlag());
        }
        if (pSDynaAppViewBase.isPDVTParamDirty() && (bl || pSDynaAppViewBase.getPDVTParam() != null)) {
            iDataObject.set(FIELD_PDVTPARAM, (Object)pSDynaAppViewBase.getPDVTParam());
        }
        if (pSDynaAppViewBase.isPredefinedViewTypeDirty() && (bl || pSDynaAppViewBase.getPredefinedViewType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDVIEWTYPE, (Object)pSDynaAppViewBase.getPredefinedViewType());
        }
        if (pSDynaAppViewBase.isPSAppMenuIdDirty() && (bl || pSDynaAppViewBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSDynaAppViewBase.getPSAppMenuId());
        }
        if (pSDynaAppViewBase.isPSAppMenuNameDirty() && (bl || pSDynaAppViewBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSDynaAppViewBase.getPSAppMenuName());
        }
        if (pSDynaAppViewBase.isPSDynaAppIdDirty() && (bl || pSDynaAppViewBase.getPSDynaAppId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPID, (Object)pSDynaAppViewBase.getPSDynaAppId());
        }
        if (pSDynaAppViewBase.isPSDynaAppNameDirty() && (bl || pSDynaAppViewBase.getPSDynaAppName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPNAME, (Object)pSDynaAppViewBase.getPSDynaAppName());
        }
        if (pSDynaAppViewBase.isPSDynaAppViewIdDirty() && (bl || pSDynaAppViewBase.getPSDynaAppViewId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWID, (Object)pSDynaAppViewBase.getPSDynaAppViewId());
        }
        if (pSDynaAppViewBase.isPSDynaAppViewNameDirty() && (bl || pSDynaAppViewBase.getPSDynaAppViewName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPVIEWNAME, (Object)pSDynaAppViewBase.getPSDynaAppViewName());
        }
        if (pSDynaAppViewBase.isPSDynaDEIdDirty() && (bl || pSDynaAppViewBase.getPSDynaDEId() != null)) {
            iDataObject.set(FIELD_PSDYNADEID, (Object)pSDynaAppViewBase.getPSDynaDEId());
        }
        if (pSDynaAppViewBase.isPSDynaDENameDirty() && (bl || pSDynaAppViewBase.getPSDynaDEName() != null)) {
            iDataObject.set(FIELD_PSDYNADENAME, (Object)pSDynaAppViewBase.getPSDynaDEName());
        }
        if (pSDynaAppViewBase.isPSWFDEIdDirty() && (bl || pSDynaAppViewBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSDynaAppViewBase.getPSWFDEId());
        }
        if (pSDynaAppViewBase.isPSWFDENameDirty() && (bl || pSDynaAppViewBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSDynaAppViewBase.getPSWFDEName());
        }
        if (pSDynaAppViewBase.isTitleDirty() && (bl || pSDynaAppViewBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSDynaAppViewBase.getTitle());
        }
        if (pSDynaAppViewBase.isUpdateDateDirty() && (bl || pSDynaAppViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaAppViewBase.getUpdateDate());
        }
        if (pSDynaAppViewBase.isUpdateManDirty() && (bl || pSDynaAppViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaAppViewBase.getUpdateMan());
        }
        if (pSDynaAppViewBase.isValidFlagDirty() && (bl || pSDynaAppViewBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaAppViewBase.getValidFlag());
        }
        if (pSDynaAppViewBase.isViewActionsDirty() && (bl || pSDynaAppViewBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDynaAppViewBase.getViewActions());
        }
        if (pSDynaAppViewBase.isViewTypeDirty() && (bl || pSDynaAppViewBase.getViewType() != null)) {
            iDataObject.set(FIELD_VIEWTYPE, (Object)pSDynaAppViewBase.getViewType());
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
        return PSDynaAppViewBase.remove(this, n);
    }

    private static boolean remove(PSDynaAppViewBase pSDynaAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppViewBase.resetCaption();
                return true;
            }
            case 1: {
                pSDynaAppViewBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDynaAppViewBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDynaAppViewBase.resetEnableViewActions();
                return true;
            }
            case 4: {
                pSDynaAppViewBase.resetMemo();
                return true;
            }
            case 5: {
                pSDynaAppViewBase.resetMobViewFlag();
                return true;
            }
            case 6: {
                pSDynaAppViewBase.resetPDVTParam();
                return true;
            }
            case 7: {
                pSDynaAppViewBase.resetPredefinedViewType();
                return true;
            }
            case 8: {
                pSDynaAppViewBase.resetPSAppMenuId();
                return true;
            }
            case 9: {
                pSDynaAppViewBase.resetPSAppMenuName();
                return true;
            }
            case 10: {
                pSDynaAppViewBase.resetPSDynaAppId();
                return true;
            }
            case 11: {
                pSDynaAppViewBase.resetPSDynaAppName();
                return true;
            }
            case 12: {
                pSDynaAppViewBase.resetPSDynaAppViewId();
                return true;
            }
            case 13: {
                pSDynaAppViewBase.resetPSDynaAppViewName();
                return true;
            }
            case 14: {
                pSDynaAppViewBase.resetPSDynaDEId();
                return true;
            }
            case 15: {
                pSDynaAppViewBase.resetPSDynaDEName();
                return true;
            }
            case 16: {
                pSDynaAppViewBase.resetPSWFDEId();
                return true;
            }
            case 17: {
                pSDynaAppViewBase.resetPSWFDEName();
                return true;
            }
            case 18: {
                pSDynaAppViewBase.resetTitle();
                return true;
            }
            case 19: {
                pSDynaAppViewBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDynaAppViewBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSDynaAppViewBase.resetValidFlag();
                return true;
            }
            case 22: {
                pSDynaAppViewBase.resetViewActions();
                return true;
            }
            case 23: {
                pSDynaAppViewBase.resetViewType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet((IEntity)pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaApp getPSDynaApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaApp();
        }
        if (this.getPSDynaAppId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppLock;
        synchronized (n) {
            if (this.psdynaapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppId(), (Object)this.psdynaapp.getPSDynaAppId()) != 0L) {
                this.psdynaapp = null;
            }
            if (this.psdynaapp == null) {
                PSDynaApp pSDynaApp = new PSDynaApp();
                pSDynaApp.setPSDynaAppId(this.getPSDynaAppId());
                PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppService.autoGet((IEntity)pSDynaApp);
                this.psdynaapp = pSDynaApp;
            }
            return this.psdynaapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDE getPSDynaDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDE();
        }
        if (this.getPSDynaDEId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDELock;
        synchronized (n) {
            if (this.psdynade != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEId(), (Object)this.psdynade.getPSDynaDEId()) != 0L) {
                this.psdynade = null;
            }
            if (this.psdynade == null) {
                PSDynaDE pSDynaDE = new PSDynaDE();
                pSDynaDE.setPSDynaDEId(this.getPSDynaDEId());
                PSDynaDEService pSDynaDEService = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEService.autoGet((IEntity)pSDynaDE);
                this.psdynade = pSDynaDE;
            }
            return this.psdynade;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDE();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFDELock;
        synchronized (n) {
            if (this.pswfde != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswfde.getPSWFDEId()) != 0L) {
                this.pswfde = null;
            }
            if (this.pswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet((IEntity)pSWFDE);
                this.pswfde = pSWFDE;
            }
            return this.pswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaAppViewCtrl> getPSDynaAppViewCtrls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewCtrls();
        }
        if (this.getPSDynaAppViewId() == null) {
            return null;
        }
        PSDynaAppViewCtrlService pSDynaAppViewCtrlService = (PSDynaAppViewCtrlService)ServiceGlobal.getService(PSDynaAppViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaAppViewCtrlsLock;
        synchronized (n) {
            if (this.psdynaappviewctrls == null) {
                this.psdynaappviewctrls = pSDynaAppViewCtrlService.selectByPSDynaAppView(this);
            }
            return this.psdynaappviewctrls;
        }
    }

    private PSDynaAppViewBase getProxyEntity() {
        return this.proxyPSDynaAppViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaAppViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaAppViewBase) {
            this.proxyPSDynaAppViewBase = (PSDynaAppViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MOBVIEWFLAG, 5);
        fieldIndexMap.put(FIELD_PDVTPARAM, 6);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 7);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 8);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNAAPPID, 10);
        fieldIndexMap.put(FIELD_PSDYNAAPPNAME, 11);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWID, 12);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWNAME, 13);
        fieldIndexMap.put(FIELD_PSDYNADEID, 14);
        fieldIndexMap.put(FIELD_PSDYNADENAME, 15);
        fieldIndexMap.put(FIELD_PSWFDEID, 16);
        fieldIndexMap.put(FIELD_PSWFDENAME, 17);
        fieldIndexMap.put(FIELD_TITLE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 22);
        fieldIndexMap.put(FIELD_VIEWTYPE, 23);
    }
}

