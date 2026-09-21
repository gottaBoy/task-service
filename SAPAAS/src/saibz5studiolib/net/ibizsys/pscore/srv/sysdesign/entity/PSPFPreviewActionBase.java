/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPreviewActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPreviewActionBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String FIELD_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CODEURL = "CODEURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVICETYPE = "DEVICETYPE";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PREVIEWINFO = "PREVIEWINFO";
    public static final String FIELD_PREVIEWSTEP = "PREVIEWSTEP";
    public static final String FIELD_PREVIEWURL = "PREVIEWURL";
    public static final String FIELD_PREVIEWURLFLAG = "PREVIEWURLFLAG";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFPREVIEWACTIONID = "PSPFPREVIEWACTIONID";
    public static final String FIELD_PSPFPREVIEWACTIONNAME = "PSPFPREVIEWACTIONNAME";
    public static final String FIELD_PSPFPREVIEWNODEID = "PSPFPREVIEWNODEID";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONPARAM = 0;
    private static final int INDEX_ACTIONPARAM2 = 1;
    private static final int INDEX_ACTIONPARAM3 = 2;
    private static final int INDEX_ACTIONPARAM4 = 3;
    private static final int INDEX_ACTIONPARAM5 = 4;
    private static final int INDEX_ACTIONPARAM6 = 5;
    private static final int INDEX_ACTIONRESULT = 6;
    private static final int INDEX_ACTIONSTATE = 7;
    private static final int INDEX_BEGINTIME = 8;
    private static final int INDEX_CODEURL = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_DEVICETYPE = 12;
    private static final int INDEX_ENDTIME = 13;
    private static final int INDEX_PREVIEWINFO = 14;
    private static final int INDEX_PREVIEWSTEP = 15;
    private static final int INDEX_PREVIEWURL = 16;
    private static final int INDEX_PREVIEWURLFLAG = 17;
    private static final int INDEX_PSAPPTYPEID = 18;
    private static final int INDEX_PSDEVSLNSYSID = 19;
    private static final int INDEX_PSDSCONSOLEID = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_PSOBJID = 22;
    private static final int INDEX_PSOBJTYPE = 23;
    private static final int INDEX_PSPFID = 24;
    private static final int INDEX_PSPFPREVIEWACTIONID = 25;
    private static final int INDEX_PSPFPREVIEWACTIONNAME = 26;
    private static final int INDEX_PSPFPREVIEWNODEID = 27;
    private static final int INDEX_PSPFSTYLEID = 28;
    private static final int INDEX_PSSYSAPPID = 29;
    private static final int INDEX_PSTASKSERVERID = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPreviewActionBase proxyPSPFPreviewActionBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionparam5DirtyFlag = false;
    private boolean actionparam6DirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean codeurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devicetypeDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean previewinfoDirtyFlag = false;
    private boolean previewstepDirtyFlag = false;
    private boolean previewurlDirtyFlag = false;
    private boolean previewurlflagDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfpreviewactionidDirtyFlag = false;
    private boolean pspfpreviewactionnameDirtyFlag = false;
    private boolean pspfpreviewnodeidDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="actionparam2")
    private String actionparam2;
    @Column(name="actionparam3")
    private String actionparam3;
    @Column(name="actionparam4")
    private String actionparam4;
    @Column(name="actionparam5")
    private Integer actionparam5;
    @Column(name="actionparam6")
    private Integer actionparam6;
    @Column(name="actionresult")
    private String actionresult;
    @Column(name="actionstate")
    private Integer actionstate;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="codeurl")
    private String codeurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devicetype")
    private String devicetype;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="previewinfo")
    private String previewinfo;
    @Column(name="previewstep")
    private String previewstep;
    @Column(name="previewurl")
    private String previewurl;
    @Column(name="previewurlflag")
    private Integer previewurlflag;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfpreviewactionid")
    private String pspfpreviewactionid;
    @Column(name="pspfpreviewactionname")
    private String pspfpreviewactionname;
    @Column(name="pspfpreviewnodeid")
    private String pspfpreviewnodeid;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setActionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam = string;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
    }

    public void setActionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam2 = string;
        this.actionparam2DirtyFlag = true;
    }

    public String getActionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam2();
        }
        return this.actionparam2;
    }

    public boolean isActionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam2Dirty();
        }
        return this.actionparam2DirtyFlag;
    }

    public void resetActionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam2();
            return;
        }
        this.actionparam2DirtyFlag = false;
        this.actionparam2 = null;
    }

    public void setActionParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam3 = string;
        this.actionparam3DirtyFlag = true;
    }

    public String getActionParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam3();
        }
        return this.actionparam3;
    }

    public boolean isActionParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam3Dirty();
        }
        return this.actionparam3DirtyFlag;
    }

    public void resetActionParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam3();
            return;
        }
        this.actionparam3DirtyFlag = false;
        this.actionparam3 = null;
    }

    public void setActionParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparam4 = string;
        this.actionparam4DirtyFlag = true;
    }

    public String getActionParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam4();
        }
        return this.actionparam4;
    }

    public boolean isActionParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam4Dirty();
        }
        return this.actionparam4DirtyFlag;
    }

    public void resetActionParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam4();
            return;
        }
        this.actionparam4DirtyFlag = false;
        this.actionparam4 = null;
    }

    public void setActionParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam5(n);
            return;
        }
        this.actionparam5 = n;
        this.actionparam5DirtyFlag = true;
    }

    public Integer getActionParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam5();
        }
        return this.actionparam5;
    }

    public boolean isActionParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam5Dirty();
        }
        return this.actionparam5DirtyFlag;
    }

    public void resetActionParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam5();
            return;
        }
        this.actionparam5DirtyFlag = false;
        this.actionparam5 = null;
    }

    public void setActionParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam6(n);
            return;
        }
        this.actionparam6 = n;
        this.actionparam6DirtyFlag = true;
    }

    public Integer getActionParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam6();
        }
        return this.actionparam6;
    }

    public boolean isActionParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParam6Dirty();
        }
        return this.actionparam6DirtyFlag;
    }

    public void resetActionParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam6();
            return;
        }
        this.actionparam6DirtyFlag = false;
        this.actionparam6 = null;
    }

    public void setActionResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionresult = string;
        this.actionresultDirtyFlag = true;
    }

    public String getActionResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionResult();
        }
        return this.actionresult;
    }

    public boolean isActionResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionResultDirty();
        }
        return this.actionresultDirtyFlag;
    }

    public void resetActionResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionResult();
            return;
        }
        this.actionresultDirtyFlag = false;
        this.actionresult = null;
    }

    public void setActionState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionState(n);
            return;
        }
        this.actionstate = n;
        this.actionstateDirtyFlag = true;
    }

    public Integer getActionState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionState();
        }
        return this.actionstate;
    }

    public boolean isActionStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionStateDirty();
        }
        return this.actionstateDirtyFlag;
    }

    public void resetActionState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionState();
            return;
        }
        this.actionstateDirtyFlag = false;
        this.actionstate = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
    }

    public void setCodeUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codeurl = string;
        this.codeurlDirtyFlag = true;
    }

    public String getCodeUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeUrl();
        }
        return this.codeurl;
    }

    public boolean isCodeUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeUrlDirty();
        }
        return this.codeurlDirtyFlag;
    }

    public void resetCodeUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeUrl();
            return;
        }
        this.codeurlDirtyFlag = false;
        this.codeurl = null;
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

    public void setDeviceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeviceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devicetype = string;
        this.devicetypeDirtyFlag = true;
    }

    public String getDeviceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeviceType();
        }
        return this.devicetype;
    }

    public boolean isDeviceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeviceTypeDirty();
        }
        return this.devicetypeDirtyFlag;
    }

    public void resetDeviceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeviceType();
            return;
        }
        this.devicetypeDirtyFlag = false;
        this.devicetype = null;
    }

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setPreviewInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewinfo = string;
        this.previewinfoDirtyFlag = true;
    }

    public String getPreviewInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewInfo();
        }
        return this.previewinfo;
    }

    public boolean isPreviewInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewInfoDirty();
        }
        return this.previewinfoDirtyFlag;
    }

    public void resetPreviewInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewInfo();
            return;
        }
        this.previewinfoDirtyFlag = false;
        this.previewinfo = null;
    }

    public void setPreviewStep(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewStep(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewstep = string;
        this.previewstepDirtyFlag = true;
    }

    public String getPreviewStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewStep();
        }
        return this.previewstep;
    }

    public boolean isPreviewStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewStepDirty();
        }
        return this.previewstepDirtyFlag;
    }

    public void resetPreviewStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewStep();
            return;
        }
        this.previewstepDirtyFlag = false;
        this.previewstep = null;
    }

    public void setPreviewUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewurl = string;
        this.previewurlDirtyFlag = true;
    }

    public String getPreviewUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewUrl();
        }
        return this.previewurl;
    }

    public boolean isPreviewUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewUrlDirty();
        }
        return this.previewurlDirtyFlag;
    }

    public void resetPreviewUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewUrl();
            return;
        }
        this.previewurlDirtyFlag = false;
        this.previewurl = null;
    }

    public void setPreviewUrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewUrlFlag(n);
            return;
        }
        this.previewurlflag = n;
        this.previewurlflagDirtyFlag = true;
    }

    public Integer getPreviewUrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewUrlFlag();
        }
        return this.previewurlflag;
    }

    public boolean isPreviewUrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewUrlFlagDirty();
        }
        return this.previewurlflagDirtyFlag;
    }

    public void resetPreviewUrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewUrlFlag();
            return;
        }
        this.previewurlflagDirtyFlag = false;
        this.previewurlflag = null;
    }

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFPreviewActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPreviewActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpreviewactionid = string;
        this.pspfpreviewactionidDirtyFlag = true;
    }

    public String getPSPFPreviewActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewActionId();
        }
        return this.pspfpreviewactionid;
    }

    public boolean isPSPFPreviewActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPreviewActionIdDirty();
        }
        return this.pspfpreviewactionidDirtyFlag;
    }

    public void resetPSPFPreviewActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPreviewActionId();
            return;
        }
        this.pspfpreviewactionidDirtyFlag = false;
        this.pspfpreviewactionid = null;
    }

    public void setPSPFPreviewActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPreviewActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpreviewactionname = string;
        this.pspfpreviewactionnameDirtyFlag = true;
    }

    public String getPSPFPreviewActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewActionName();
        }
        return this.pspfpreviewactionname;
    }

    public boolean isPSPFPreviewActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPreviewActionNameDirty();
        }
        return this.pspfpreviewactionnameDirtyFlag;
    }

    public void resetPSPFPreviewActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPreviewActionName();
            return;
        }
        this.pspfpreviewactionnameDirtyFlag = false;
        this.pspfpreviewactionname = null;
    }

    public void setPSPFPreviewNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPreviewNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpreviewnodeid = string;
        this.pspfpreviewnodeidDirtyFlag = true;
    }

    public String getPSPFPreviewNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewNodeId();
        }
        return this.pspfpreviewnodeid;
    }

    public boolean isPSPFPreviewNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPreviewNodeIdDirty();
        }
        return this.pspfpreviewnodeidDirtyFlag;
    }

    public void resetPSPFPreviewNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPreviewNodeId();
            return;
        }
        this.pspfpreviewnodeidDirtyFlag = false;
        this.pspfpreviewnodeid = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
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

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
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

    protected void onReset() {
        PSPFPreviewActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPreviewActionBase pSPFPreviewActionBase) {
        pSPFPreviewActionBase.resetActionParam();
        pSPFPreviewActionBase.resetActionParam2();
        pSPFPreviewActionBase.resetActionParam3();
        pSPFPreviewActionBase.resetActionParam4();
        pSPFPreviewActionBase.resetActionParam5();
        pSPFPreviewActionBase.resetActionParam6();
        pSPFPreviewActionBase.resetActionResult();
        pSPFPreviewActionBase.resetActionState();
        pSPFPreviewActionBase.resetBeginTime();
        pSPFPreviewActionBase.resetCodeUrl();
        pSPFPreviewActionBase.resetCreateDate();
        pSPFPreviewActionBase.resetCreateMan();
        pSPFPreviewActionBase.resetDeviceType();
        pSPFPreviewActionBase.resetEndTime();
        pSPFPreviewActionBase.resetPreviewInfo();
        pSPFPreviewActionBase.resetPreviewStep();
        pSPFPreviewActionBase.resetPreviewUrl();
        pSPFPreviewActionBase.resetPreviewUrlFlag();
        pSPFPreviewActionBase.resetPSAppTypeId();
        pSPFPreviewActionBase.resetPSDevSlnSysId();
        pSPFPreviewActionBase.resetPSDSConsoleId();
        pSPFPreviewActionBase.resetPSDynaInstId();
        pSPFPreviewActionBase.resetPSObjId();
        pSPFPreviewActionBase.resetPSObjType();
        pSPFPreviewActionBase.resetPSPFId();
        pSPFPreviewActionBase.resetPSPFPreviewActionId();
        pSPFPreviewActionBase.resetPSPFPreviewActionName();
        pSPFPreviewActionBase.resetPSPFPreviewNodeId();
        pSPFPreviewActionBase.resetPSPFStyleId();
        pSPFPreviewActionBase.resetPSSysAppId();
        pSPFPreviewActionBase.resetPSTaskServerId();
        pSPFPreviewActionBase.resetUpdateDate();
        pSPFPreviewActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamDirty()) {
            hashMap.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bl || this.isActionParam2Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM2, this.getActionParam2());
        }
        if (!bl || this.isActionParam3Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM3, this.getActionParam3());
        }
        if (!bl || this.isActionParam4Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM4, this.getActionParam4());
        }
        if (!bl || this.isActionParam5Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM5, this.getActionParam5());
        }
        if (!bl || this.isActionParam6Dirty()) {
            hashMap.put(FIELD_ACTIONPARAM6, this.getActionParam6());
        }
        if (!bl || this.isActionResultDirty()) {
            hashMap.put(FIELD_ACTIONRESULT, this.getActionResult());
        }
        if (!bl || this.isActionStateDirty()) {
            hashMap.put(FIELD_ACTIONSTATE, this.getActionState());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCodeUrlDirty()) {
            hashMap.put(FIELD_CODEURL, this.getCodeUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeviceTypeDirty()) {
            hashMap.put(FIELD_DEVICETYPE, this.getDeviceType());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isPreviewInfoDirty()) {
            hashMap.put(FIELD_PREVIEWINFO, this.getPreviewInfo());
        }
        if (!bl || this.isPreviewStepDirty()) {
            hashMap.put(FIELD_PREVIEWSTEP, this.getPreviewStep());
        }
        if (!bl || this.isPreviewUrlDirty()) {
            hashMap.put(FIELD_PREVIEWURL, this.getPreviewUrl());
        }
        if (!bl || this.isPreviewUrlFlagDirty()) {
            hashMap.put(FIELD_PREVIEWURLFLAG, this.getPreviewUrlFlag());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFPreviewActionIdDirty()) {
            hashMap.put(FIELD_PSPFPREVIEWACTIONID, this.getPSPFPreviewActionId());
        }
        if (!bl || this.isPSPFPreviewActionNameDirty()) {
            hashMap.put(FIELD_PSPFPREVIEWACTIONNAME, this.getPSPFPreviewActionName());
        }
        if (!bl || this.isPSPFPreviewNodeIdDirty()) {
            hashMap.put(FIELD_PSPFPREVIEWNODEID, this.getPSPFPreviewNodeId());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSPFPreviewActionBase.get(this, n);
    }

    private static Object get(PSPFPreviewActionBase pSPFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewActionBase.getActionParam();
            }
            case 1: {
                return pSPFPreviewActionBase.getActionParam2();
            }
            case 2: {
                return pSPFPreviewActionBase.getActionParam3();
            }
            case 3: {
                return pSPFPreviewActionBase.getActionParam4();
            }
            case 4: {
                return pSPFPreviewActionBase.getActionParam5();
            }
            case 5: {
                return pSPFPreviewActionBase.getActionParam6();
            }
            case 6: {
                return pSPFPreviewActionBase.getActionResult();
            }
            case 7: {
                return pSPFPreviewActionBase.getActionState();
            }
            case 8: {
                return pSPFPreviewActionBase.getBeginTime();
            }
            case 9: {
                return pSPFPreviewActionBase.getCodeUrl();
            }
            case 10: {
                return pSPFPreviewActionBase.getCreateDate();
            }
            case 11: {
                return pSPFPreviewActionBase.getCreateMan();
            }
            case 12: {
                return pSPFPreviewActionBase.getDeviceType();
            }
            case 13: {
                return pSPFPreviewActionBase.getEndTime();
            }
            case 14: {
                return pSPFPreviewActionBase.getPreviewInfo();
            }
            case 15: {
                return pSPFPreviewActionBase.getPreviewStep();
            }
            case 16: {
                return pSPFPreviewActionBase.getPreviewUrl();
            }
            case 17: {
                return pSPFPreviewActionBase.getPreviewUrlFlag();
            }
            case 18: {
                return pSPFPreviewActionBase.getPSAppTypeId();
            }
            case 19: {
                return pSPFPreviewActionBase.getPSDevSlnSysId();
            }
            case 20: {
                return pSPFPreviewActionBase.getPSDSConsoleId();
            }
            case 21: {
                return pSPFPreviewActionBase.getPSDynaInstId();
            }
            case 22: {
                return pSPFPreviewActionBase.getPSObjId();
            }
            case 23: {
                return pSPFPreviewActionBase.getPSObjType();
            }
            case 24: {
                return pSPFPreviewActionBase.getPSPFId();
            }
            case 25: {
                return pSPFPreviewActionBase.getPSPFPreviewActionId();
            }
            case 26: {
                return pSPFPreviewActionBase.getPSPFPreviewActionName();
            }
            case 27: {
                return pSPFPreviewActionBase.getPSPFPreviewNodeId();
            }
            case 28: {
                return pSPFPreviewActionBase.getPSPFStyleId();
            }
            case 29: {
                return pSPFPreviewActionBase.getPSSysAppId();
            }
            case 30: {
                return pSPFPreviewActionBase.getPSTaskServerId();
            }
            case 31: {
                return pSPFPreviewActionBase.getUpdateDate();
            }
            case 32: {
                return pSPFPreviewActionBase.getUpdateMan();
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
        PSPFPreviewActionBase.set(this, n, object);
    }

    private static void set(PSPFPreviewActionBase pSPFPreviewActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPreviewActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFPreviewActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPreviewActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPreviewActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPreviewActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSPFPreviewActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSPFPreviewActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPreviewActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSPFPreviewActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSPFPreviewActionBase.setCodeUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPreviewActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSPFPreviewActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPreviewActionBase.setDeviceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPreviewActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFPreviewActionBase.setPreviewInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPreviewActionBase.setPreviewStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPreviewActionBase.setPreviewUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFPreviewActionBase.setPreviewUrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSPFPreviewActionBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFPreviewActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFPreviewActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFPreviewActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPFPreviewActionBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPFPreviewActionBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPFPreviewActionBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPFPreviewActionBase.setPSPFPreviewActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPFPreviewActionBase.setPSPFPreviewActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSPFPreviewActionBase.setPSPFPreviewNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPFPreviewActionBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSPFPreviewActionBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSPFPreviewActionBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSPFPreviewActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSPFPreviewActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPreviewActionBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPreviewActionBase pSPFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewActionBase.getActionParam() == null;
            }
            case 1: {
                return pSPFPreviewActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSPFPreviewActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSPFPreviewActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSPFPreviewActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSPFPreviewActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSPFPreviewActionBase.getActionResult() == null;
            }
            case 7: {
                return pSPFPreviewActionBase.getActionState() == null;
            }
            case 8: {
                return pSPFPreviewActionBase.getBeginTime() == null;
            }
            case 9: {
                return pSPFPreviewActionBase.getCodeUrl() == null;
            }
            case 10: {
                return pSPFPreviewActionBase.getCreateDate() == null;
            }
            case 11: {
                return pSPFPreviewActionBase.getCreateMan() == null;
            }
            case 12: {
                return pSPFPreviewActionBase.getDeviceType() == null;
            }
            case 13: {
                return pSPFPreviewActionBase.getEndTime() == null;
            }
            case 14: {
                return pSPFPreviewActionBase.getPreviewInfo() == null;
            }
            case 15: {
                return pSPFPreviewActionBase.getPreviewStep() == null;
            }
            case 16: {
                return pSPFPreviewActionBase.getPreviewUrl() == null;
            }
            case 17: {
                return pSPFPreviewActionBase.getPreviewUrlFlag() == null;
            }
            case 18: {
                return pSPFPreviewActionBase.getPSAppTypeId() == null;
            }
            case 19: {
                return pSPFPreviewActionBase.getPSDevSlnSysId() == null;
            }
            case 20: {
                return pSPFPreviewActionBase.getPSDSConsoleId() == null;
            }
            case 21: {
                return pSPFPreviewActionBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSPFPreviewActionBase.getPSObjId() == null;
            }
            case 23: {
                return pSPFPreviewActionBase.getPSObjType() == null;
            }
            case 24: {
                return pSPFPreviewActionBase.getPSPFId() == null;
            }
            case 25: {
                return pSPFPreviewActionBase.getPSPFPreviewActionId() == null;
            }
            case 26: {
                return pSPFPreviewActionBase.getPSPFPreviewActionName() == null;
            }
            case 27: {
                return pSPFPreviewActionBase.getPSPFPreviewNodeId() == null;
            }
            case 28: {
                return pSPFPreviewActionBase.getPSPFStyleId() == null;
            }
            case 29: {
                return pSPFPreviewActionBase.getPSSysAppId() == null;
            }
            case 30: {
                return pSPFPreviewActionBase.getPSTaskServerId() == null;
            }
            case 31: {
                return pSPFPreviewActionBase.getUpdateDate() == null;
            }
            case 32: {
                return pSPFPreviewActionBase.getUpdateMan() == null;
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
        return PSPFPreviewActionBase.contains(this, n);
    }

    private static boolean contains(PSPFPreviewActionBase pSPFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPreviewActionBase.isActionParamDirty();
            }
            case 1: {
                return pSPFPreviewActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSPFPreviewActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSPFPreviewActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSPFPreviewActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSPFPreviewActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSPFPreviewActionBase.isActionResultDirty();
            }
            case 7: {
                return pSPFPreviewActionBase.isActionStateDirty();
            }
            case 8: {
                return pSPFPreviewActionBase.isBeginTimeDirty();
            }
            case 9: {
                return pSPFPreviewActionBase.isCodeUrlDirty();
            }
            case 10: {
                return pSPFPreviewActionBase.isCreateDateDirty();
            }
            case 11: {
                return pSPFPreviewActionBase.isCreateManDirty();
            }
            case 12: {
                return pSPFPreviewActionBase.isDeviceTypeDirty();
            }
            case 13: {
                return pSPFPreviewActionBase.isEndTimeDirty();
            }
            case 14: {
                return pSPFPreviewActionBase.isPreviewInfoDirty();
            }
            case 15: {
                return pSPFPreviewActionBase.isPreviewStepDirty();
            }
            case 16: {
                return pSPFPreviewActionBase.isPreviewUrlDirty();
            }
            case 17: {
                return pSPFPreviewActionBase.isPreviewUrlFlagDirty();
            }
            case 18: {
                return pSPFPreviewActionBase.isPSAppTypeIdDirty();
            }
            case 19: {
                return pSPFPreviewActionBase.isPSDevSlnSysIdDirty();
            }
            case 20: {
                return pSPFPreviewActionBase.isPSDSConsoleIdDirty();
            }
            case 21: {
                return pSPFPreviewActionBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSPFPreviewActionBase.isPSObjIdDirty();
            }
            case 23: {
                return pSPFPreviewActionBase.isPSObjTypeDirty();
            }
            case 24: {
                return pSPFPreviewActionBase.isPSPFIdDirty();
            }
            case 25: {
                return pSPFPreviewActionBase.isPSPFPreviewActionIdDirty();
            }
            case 26: {
                return pSPFPreviewActionBase.isPSPFPreviewActionNameDirty();
            }
            case 27: {
                return pSPFPreviewActionBase.isPSPFPreviewNodeIdDirty();
            }
            case 28: {
                return pSPFPreviewActionBase.isPSPFStyleIdDirty();
            }
            case 29: {
                return pSPFPreviewActionBase.isPSSysAppIdDirty();
            }
            case 30: {
                return pSPFPreviewActionBase.isPSTaskServerIdDirty();
            }
            case 31: {
                return pSPFPreviewActionBase.isUpdateDateDirty();
            }
            case 32: {
                return pSPFPreviewActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPreviewActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPreviewActionBase pSPFPreviewActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPreviewActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getCodeUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeurl", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getCodeUrl()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getDeviceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devicetype", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getDeviceType()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPreviewInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewinfo", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPreviewInfo()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPreviewStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewstep", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPreviewStep()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPreviewUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurl", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPreviewUrl()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPreviewUrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurlflag", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPreviewUrlFlag()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpreviewactionid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSPFPreviewActionId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpreviewactionname", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSPFPreviewActionName()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpreviewnodeid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSPFPreviewNodeId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPreviewActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPreviewActionBase.getJSONValue((Object)pSPFPreviewActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPreviewActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPreviewActionBase pSPFPreviewActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPreviewActionBase.getActionParam() != null) {
            object = pSPFPreviewActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPreviewActionBase.getActionParam2() != null) {
            object = pSPFPreviewActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPreviewActionBase.getActionParam3() != null) {
            object = pSPFPreviewActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSPFPreviewActionBase.getActionParam4() != null) {
            object = pSPFPreviewActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getActionParam5() != null) {
            object = pSPFPreviewActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getActionParam6() != null) {
            object = pSPFPreviewActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getActionResult() != null) {
            object = pSPFPreviewActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getActionState() != null) {
            object = pSPFPreviewActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getBeginTime() != null) {
            object = pSPFPreviewActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getCodeUrl() != null) {
            object = pSPFPreviewActionBase.getCodeUrl();
            xmlNode.setAttribute(FIELD_CODEURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getCreateDate() != null) {
            object = pSPFPreviewActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getCreateMan() != null) {
            object = pSPFPreviewActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getDeviceType() != null) {
            object = pSPFPreviewActionBase.getDeviceType();
            xmlNode.setAttribute(FIELD_DEVICETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getEndTime() != null) {
            object = pSPFPreviewActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getPreviewInfo() != null) {
            object = pSPFPreviewActionBase.getPreviewInfo();
            xmlNode.setAttribute(FIELD_PREVIEWINFO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPreviewStep() != null) {
            object = pSPFPreviewActionBase.getPreviewStep();
            xmlNode.setAttribute(FIELD_PREVIEWSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPreviewUrl() != null) {
            object = pSPFPreviewActionBase.getPreviewUrl();
            xmlNode.setAttribute(FIELD_PREVIEWURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPreviewUrlFlag() != null) {
            object = pSPFPreviewActionBase.getPreviewUrlFlag();
            xmlNode.setAttribute(FIELD_PREVIEWURLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getPSAppTypeId() != null) {
            object = pSPFPreviewActionBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSDevSlnSysId() != null) {
            object = pSPFPreviewActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSDSConsoleId() != null) {
            object = pSPFPreviewActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSDynaInstId() != null) {
            object = pSPFPreviewActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSObjId() != null) {
            object = pSPFPreviewActionBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSObjType() != null) {
            object = pSPFPreviewActionBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSPFId() != null) {
            object = pSPFPreviewActionBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewActionId() != null) {
            object = pSPFPreviewActionBase.getPSPFPreviewActionId();
            xmlNode.setAttribute(FIELD_PSPFPREVIEWACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewActionName() != null) {
            object = pSPFPreviewActionBase.getPSPFPreviewActionName();
            xmlNode.setAttribute(FIELD_PSPFPREVIEWACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSPFPreviewNodeId() != null) {
            object = pSPFPreviewActionBase.getPSPFPreviewNodeId();
            xmlNode.setAttribute(FIELD_PSPFPREVIEWNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSPFStyleId() != null) {
            object = pSPFPreviewActionBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSSysAppId() != null) {
            object = pSPFPreviewActionBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getPSTaskServerId() != null) {
            object = pSPFPreviewActionBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPreviewActionBase.getUpdateDate() != null) {
            object = pSPFPreviewActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPreviewActionBase.getUpdateMan() != null) {
            object = pSPFPreviewActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPreviewActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPreviewActionBase pSPFPreviewActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPreviewActionBase.isActionParamDirty() && (bl || pSPFPreviewActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSPFPreviewActionBase.getActionParam());
        }
        if (pSPFPreviewActionBase.isActionParam2Dirty() && (bl || pSPFPreviewActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSPFPreviewActionBase.getActionParam2());
        }
        if (pSPFPreviewActionBase.isActionParam3Dirty() && (bl || pSPFPreviewActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSPFPreviewActionBase.getActionParam3());
        }
        if (pSPFPreviewActionBase.isActionParam4Dirty() && (bl || pSPFPreviewActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSPFPreviewActionBase.getActionParam4());
        }
        if (pSPFPreviewActionBase.isActionParam5Dirty() && (bl || pSPFPreviewActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSPFPreviewActionBase.getActionParam5());
        }
        if (pSPFPreviewActionBase.isActionParam6Dirty() && (bl || pSPFPreviewActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSPFPreviewActionBase.getActionParam6());
        }
        if (pSPFPreviewActionBase.isActionResultDirty() && (bl || pSPFPreviewActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSPFPreviewActionBase.getActionResult());
        }
        if (pSPFPreviewActionBase.isActionStateDirty() && (bl || pSPFPreviewActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSPFPreviewActionBase.getActionState());
        }
        if (pSPFPreviewActionBase.isBeginTimeDirty() && (bl || pSPFPreviewActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSPFPreviewActionBase.getBeginTime());
        }
        if (pSPFPreviewActionBase.isCodeUrlDirty() && (bl || pSPFPreviewActionBase.getCodeUrl() != null)) {
            iDataObject.set(FIELD_CODEURL, (Object)pSPFPreviewActionBase.getCodeUrl());
        }
        if (pSPFPreviewActionBase.isCreateDateDirty() && (bl || pSPFPreviewActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPreviewActionBase.getCreateDate());
        }
        if (pSPFPreviewActionBase.isCreateManDirty() && (bl || pSPFPreviewActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPreviewActionBase.getCreateMan());
        }
        if (pSPFPreviewActionBase.isDeviceTypeDirty() && (bl || pSPFPreviewActionBase.getDeviceType() != null)) {
            iDataObject.set(FIELD_DEVICETYPE, (Object)pSPFPreviewActionBase.getDeviceType());
        }
        if (pSPFPreviewActionBase.isEndTimeDirty() && (bl || pSPFPreviewActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSPFPreviewActionBase.getEndTime());
        }
        if (pSPFPreviewActionBase.isPreviewInfoDirty() && (bl || pSPFPreviewActionBase.getPreviewInfo() != null)) {
            iDataObject.set(FIELD_PREVIEWINFO, (Object)pSPFPreviewActionBase.getPreviewInfo());
        }
        if (pSPFPreviewActionBase.isPreviewStepDirty() && (bl || pSPFPreviewActionBase.getPreviewStep() != null)) {
            iDataObject.set(FIELD_PREVIEWSTEP, (Object)pSPFPreviewActionBase.getPreviewStep());
        }
        if (pSPFPreviewActionBase.isPreviewUrlDirty() && (bl || pSPFPreviewActionBase.getPreviewUrl() != null)) {
            iDataObject.set(FIELD_PREVIEWURL, (Object)pSPFPreviewActionBase.getPreviewUrl());
        }
        if (pSPFPreviewActionBase.isPreviewUrlFlagDirty() && (bl || pSPFPreviewActionBase.getPreviewUrlFlag() != null)) {
            iDataObject.set(FIELD_PREVIEWURLFLAG, (Object)pSPFPreviewActionBase.getPreviewUrlFlag());
        }
        if (pSPFPreviewActionBase.isPSAppTypeIdDirty() && (bl || pSPFPreviewActionBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSPFPreviewActionBase.getPSAppTypeId());
        }
        if (pSPFPreviewActionBase.isPSDevSlnSysIdDirty() && (bl || pSPFPreviewActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSPFPreviewActionBase.getPSDevSlnSysId());
        }
        if (pSPFPreviewActionBase.isPSDSConsoleIdDirty() && (bl || pSPFPreviewActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSPFPreviewActionBase.getPSDSConsoleId());
        }
        if (pSPFPreviewActionBase.isPSDynaInstIdDirty() && (bl || pSPFPreviewActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSPFPreviewActionBase.getPSDynaInstId());
        }
        if (pSPFPreviewActionBase.isPSObjIdDirty() && (bl || pSPFPreviewActionBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSPFPreviewActionBase.getPSObjId());
        }
        if (pSPFPreviewActionBase.isPSObjTypeDirty() && (bl || pSPFPreviewActionBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSPFPreviewActionBase.getPSObjType());
        }
        if (pSPFPreviewActionBase.isPSPFIdDirty() && (bl || pSPFPreviewActionBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPreviewActionBase.getPSPFId());
        }
        if (pSPFPreviewActionBase.isPSPFPreviewActionIdDirty() && (bl || pSPFPreviewActionBase.getPSPFPreviewActionId() != null)) {
            iDataObject.set(FIELD_PSPFPREVIEWACTIONID, (Object)pSPFPreviewActionBase.getPSPFPreviewActionId());
        }
        if (pSPFPreviewActionBase.isPSPFPreviewActionNameDirty() && (bl || pSPFPreviewActionBase.getPSPFPreviewActionName() != null)) {
            iDataObject.set(FIELD_PSPFPREVIEWACTIONNAME, (Object)pSPFPreviewActionBase.getPSPFPreviewActionName());
        }
        if (pSPFPreviewActionBase.isPSPFPreviewNodeIdDirty() && (bl || pSPFPreviewActionBase.getPSPFPreviewNodeId() != null)) {
            iDataObject.set(FIELD_PSPFPREVIEWNODEID, (Object)pSPFPreviewActionBase.getPSPFPreviewNodeId());
        }
        if (pSPFPreviewActionBase.isPSPFStyleIdDirty() && (bl || pSPFPreviewActionBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFPreviewActionBase.getPSPFStyleId());
        }
        if (pSPFPreviewActionBase.isPSSysAppIdDirty() && (bl || pSPFPreviewActionBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSPFPreviewActionBase.getPSSysAppId());
        }
        if (pSPFPreviewActionBase.isPSTaskServerIdDirty() && (bl || pSPFPreviewActionBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSPFPreviewActionBase.getPSTaskServerId());
        }
        if (pSPFPreviewActionBase.isUpdateDateDirty() && (bl || pSPFPreviewActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPreviewActionBase.getUpdateDate());
        }
        if (pSPFPreviewActionBase.isUpdateManDirty() && (bl || pSPFPreviewActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPreviewActionBase.getUpdateMan());
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
        return PSPFPreviewActionBase.remove(this, n);
    }

    private static boolean remove(PSPFPreviewActionBase pSPFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPreviewActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSPFPreviewActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSPFPreviewActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSPFPreviewActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSPFPreviewActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSPFPreviewActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSPFPreviewActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSPFPreviewActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSPFPreviewActionBase.resetBeginTime();
                return true;
            }
            case 9: {
                pSPFPreviewActionBase.resetCodeUrl();
                return true;
            }
            case 10: {
                pSPFPreviewActionBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSPFPreviewActionBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSPFPreviewActionBase.resetDeviceType();
                return true;
            }
            case 13: {
                pSPFPreviewActionBase.resetEndTime();
                return true;
            }
            case 14: {
                pSPFPreviewActionBase.resetPreviewInfo();
                return true;
            }
            case 15: {
                pSPFPreviewActionBase.resetPreviewStep();
                return true;
            }
            case 16: {
                pSPFPreviewActionBase.resetPreviewUrl();
                return true;
            }
            case 17: {
                pSPFPreviewActionBase.resetPreviewUrlFlag();
                return true;
            }
            case 18: {
                pSPFPreviewActionBase.resetPSAppTypeId();
                return true;
            }
            case 19: {
                pSPFPreviewActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 20: {
                pSPFPreviewActionBase.resetPSDSConsoleId();
                return true;
            }
            case 21: {
                pSPFPreviewActionBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSPFPreviewActionBase.resetPSObjId();
                return true;
            }
            case 23: {
                pSPFPreviewActionBase.resetPSObjType();
                return true;
            }
            case 24: {
                pSPFPreviewActionBase.resetPSPFId();
                return true;
            }
            case 25: {
                pSPFPreviewActionBase.resetPSPFPreviewActionId();
                return true;
            }
            case 26: {
                pSPFPreviewActionBase.resetPSPFPreviewActionName();
                return true;
            }
            case 27: {
                pSPFPreviewActionBase.resetPSPFPreviewNodeId();
                return true;
            }
            case 28: {
                pSPFPreviewActionBase.resetPSPFStyleId();
                return true;
            }
            case 29: {
                pSPFPreviewActionBase.resetPSSysAppId();
                return true;
            }
            case 30: {
                pSPFPreviewActionBase.resetPSTaskServerId();
                return true;
            }
            case 31: {
                pSPFPreviewActionBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSPFPreviewActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPFPreviewActionBase getProxyEntity() {
        return this.proxyPSPFPreviewActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPreviewActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPreviewActionBase) {
            this.proxyPSPFPreviewActionBase = (PSPFPreviewActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPFPreviewActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAM, 0);
        fieldIndexMap.put(FIELD_ACTIONPARAM2, 1);
        fieldIndexMap.put(FIELD_ACTIONPARAM3, 2);
        fieldIndexMap.put(FIELD_ACTIONPARAM4, 3);
        fieldIndexMap.put(FIELD_ACTIONPARAM5, 4);
        fieldIndexMap.put(FIELD_ACTIONPARAM6, 5);
        fieldIndexMap.put(FIELD_ACTIONRESULT, 6);
        fieldIndexMap.put(FIELD_ACTIONSTATE, 7);
        fieldIndexMap.put(FIELD_BEGINTIME, 8);
        fieldIndexMap.put(FIELD_CODEURL, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_DEVICETYPE, 12);
        fieldIndexMap.put(FIELD_ENDTIME, 13);
        fieldIndexMap.put(FIELD_PREVIEWINFO, 14);
        fieldIndexMap.put(FIELD_PREVIEWSTEP, 15);
        fieldIndexMap.put(FIELD_PREVIEWURL, 16);
        fieldIndexMap.put(FIELD_PREVIEWURLFLAG, 17);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 19);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_PSOBJID, 22);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 23);
        fieldIndexMap.put(FIELD_PSPFID, 24);
        fieldIndexMap.put(FIELD_PSPFPREVIEWACTIONID, 25);
        fieldIndexMap.put(FIELD_PSPFPREVIEWACTIONNAME, 26);
        fieldIndexMap.put(FIELD_PSPFPREVIEWNODEID, 27);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 28);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 29);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
    }
}

