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

public abstract class PSSFPreviewActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPreviewActionBase.class);
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
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PREVIEWINFO = "PREVIEWINFO";
    public static final String FIELD_PREVIEWSTEP = "PREVIEWSTEP";
    public static final String FIELD_PREVIEWURL = "PREVIEWURL";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFPREVIEWACTIONID = "PSSFPREVIEWACTIONID";
    public static final String FIELD_PSSFPREVIEWACTIONNAME = "PSSFPREVIEWACTIONNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
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
    private static final int INDEX_ENDTIME = 12;
    private static final int INDEX_PREVIEWINFO = 13;
    private static final int INDEX_PREVIEWSTEP = 14;
    private static final int INDEX_PREVIEWURL = 15;
    private static final int INDEX_PSDEVSLNSYSID = 16;
    private static final int INDEX_PSDSCONSOLEID = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_PSOBJID = 19;
    private static final int INDEX_PSOBJTYPE = 20;
    private static final int INDEX_PSSFID = 21;
    private static final int INDEX_PSSFPREVIEWACTIONID = 22;
    private static final int INDEX_PSSFPREVIEWACTIONNAME = 23;
    private static final int INDEX_PSSFSTYLEID = 24;
    private static final int INDEX_PSSYSAPPID = 25;
    private static final int INDEX_PSSYSSFPUBID = 26;
    private static final int INDEX_PSTASKSERVERID = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPreviewActionBase proxyPSSFPreviewActionBase = null;
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
    private boolean endtimeDirtyFlag = false;
    private boolean previewinfoDirtyFlag = false;
    private boolean previewstepDirtyFlag = false;
    private boolean previewurlDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfpreviewactionidDirtyFlag = false;
    private boolean pssfpreviewactionnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
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
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="previewinfo")
    private String previewinfo;
    @Column(name="previewstep")
    private String previewstep;
    @Column(name="previewurl")
    private String previewurl;
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
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfpreviewactionid")
    private String pssfpreviewactionid;
    @Column(name="pssfpreviewactionname")
    private String pssfpreviewactionname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
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

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFPreviewActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPreviewActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpreviewactionid = string;
        this.pssfpreviewactionidDirtyFlag = true;
    }

    public String getPSSFPreviewActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPreviewActionId();
        }
        return this.pssfpreviewactionid;
    }

    public boolean isPSSFPreviewActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPreviewActionIdDirty();
        }
        return this.pssfpreviewactionidDirtyFlag;
    }

    public void resetPSSFPreviewActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPreviewActionId();
            return;
        }
        this.pssfpreviewactionidDirtyFlag = false;
        this.pssfpreviewactionid = null;
    }

    public void setPSSFPreviewActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPreviewActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpreviewactionname = string;
        this.pssfpreviewactionnameDirtyFlag = true;
    }

    public String getPSSFPreviewActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPreviewActionName();
        }
        return this.pssfpreviewactionname;
    }

    public boolean isPSSFPreviewActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPreviewActionNameDirty();
        }
        return this.pssfpreviewactionnameDirtyFlag;
    }

    public void resetPSSFPreviewActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPreviewActionName();
            return;
        }
        this.pssfpreviewactionnameDirtyFlag = false;
        this.pssfpreviewactionname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
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

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
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
        PSSFPreviewActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPreviewActionBase pSSFPreviewActionBase) {
        pSSFPreviewActionBase.resetActionParam();
        pSSFPreviewActionBase.resetActionParam2();
        pSSFPreviewActionBase.resetActionParam3();
        pSSFPreviewActionBase.resetActionParam4();
        pSSFPreviewActionBase.resetActionParam5();
        pSSFPreviewActionBase.resetActionParam6();
        pSSFPreviewActionBase.resetActionResult();
        pSSFPreviewActionBase.resetActionState();
        pSSFPreviewActionBase.resetBeginTime();
        pSSFPreviewActionBase.resetCodeUrl();
        pSSFPreviewActionBase.resetCreateDate();
        pSSFPreviewActionBase.resetCreateMan();
        pSSFPreviewActionBase.resetEndTime();
        pSSFPreviewActionBase.resetPreviewInfo();
        pSSFPreviewActionBase.resetPreviewStep();
        pSSFPreviewActionBase.resetPreviewUrl();
        pSSFPreviewActionBase.resetPSDevSlnSysId();
        pSSFPreviewActionBase.resetPSDSConsoleId();
        pSSFPreviewActionBase.resetPSDynaInstId();
        pSSFPreviewActionBase.resetPSObjId();
        pSSFPreviewActionBase.resetPSObjType();
        pSSFPreviewActionBase.resetPSSFId();
        pSSFPreviewActionBase.resetPSSFPreviewActionId();
        pSSFPreviewActionBase.resetPSSFPreviewActionName();
        pSSFPreviewActionBase.resetPSSFStyleId();
        pSSFPreviewActionBase.resetPSSysAppId();
        pSSFPreviewActionBase.resetPSSysSFPubId();
        pSSFPreviewActionBase.resetPSTaskServerId();
        pSSFPreviewActionBase.resetUpdateDate();
        pSSFPreviewActionBase.resetUpdateMan();
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
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFPreviewActionIdDirty()) {
            hashMap.put(FIELD_PSSFPREVIEWACTIONID, this.getPSSFPreviewActionId());
        }
        if (!bl || this.isPSSFPreviewActionNameDirty()) {
            hashMap.put(FIELD_PSSFPREVIEWACTIONNAME, this.getPSSFPreviewActionName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
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
        return PSSFPreviewActionBase.get(this, n);
    }

    private static Object get(PSSFPreviewActionBase pSSFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPreviewActionBase.getActionParam();
            }
            case 1: {
                return pSSFPreviewActionBase.getActionParam2();
            }
            case 2: {
                return pSSFPreviewActionBase.getActionParam3();
            }
            case 3: {
                return pSSFPreviewActionBase.getActionParam4();
            }
            case 4: {
                return pSSFPreviewActionBase.getActionParam5();
            }
            case 5: {
                return pSSFPreviewActionBase.getActionParam6();
            }
            case 6: {
                return pSSFPreviewActionBase.getActionResult();
            }
            case 7: {
                return pSSFPreviewActionBase.getActionState();
            }
            case 8: {
                return pSSFPreviewActionBase.getBeginTime();
            }
            case 9: {
                return pSSFPreviewActionBase.getCodeUrl();
            }
            case 10: {
                return pSSFPreviewActionBase.getCreateDate();
            }
            case 11: {
                return pSSFPreviewActionBase.getCreateMan();
            }
            case 12: {
                return pSSFPreviewActionBase.getEndTime();
            }
            case 13: {
                return pSSFPreviewActionBase.getPreviewInfo();
            }
            case 14: {
                return pSSFPreviewActionBase.getPreviewStep();
            }
            case 15: {
                return pSSFPreviewActionBase.getPreviewUrl();
            }
            case 16: {
                return pSSFPreviewActionBase.getPSDevSlnSysId();
            }
            case 17: {
                return pSSFPreviewActionBase.getPSDSConsoleId();
            }
            case 18: {
                return pSSFPreviewActionBase.getPSDynaInstId();
            }
            case 19: {
                return pSSFPreviewActionBase.getPSObjId();
            }
            case 20: {
                return pSSFPreviewActionBase.getPSObjType();
            }
            case 21: {
                return pSSFPreviewActionBase.getPSSFId();
            }
            case 22: {
                return pSSFPreviewActionBase.getPSSFPreviewActionId();
            }
            case 23: {
                return pSSFPreviewActionBase.getPSSFPreviewActionName();
            }
            case 24: {
                return pSSFPreviewActionBase.getPSSFStyleId();
            }
            case 25: {
                return pSSFPreviewActionBase.getPSSysAppId();
            }
            case 26: {
                return pSSFPreviewActionBase.getPSSysSFPubId();
            }
            case 27: {
                return pSSFPreviewActionBase.getPSTaskServerId();
            }
            case 28: {
                return pSSFPreviewActionBase.getUpdateDate();
            }
            case 29: {
                return pSSFPreviewActionBase.getUpdateMan();
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
        PSSFPreviewActionBase.set(this, n, object);
    }

    private static void set(PSSFPreviewActionBase pSSFPreviewActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPreviewActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFPreviewActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPreviewActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPreviewActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPreviewActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSFPreviewActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFPreviewActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPreviewActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSFPreviewActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSFPreviewActionBase.setCodeUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPreviewActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSFPreviewActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPreviewActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSFPreviewActionBase.setPreviewInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFPreviewActionBase.setPreviewStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFPreviewActionBase.setPreviewUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFPreviewActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSFPreviewActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFPreviewActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSFPreviewActionBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSFPreviewActionBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSFPreviewActionBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSFPreviewActionBase.setPSSFPreviewActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSFPreviewActionBase.setPSSFPreviewActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSFPreviewActionBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSFPreviewActionBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSFPreviewActionBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSFPreviewActionBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSFPreviewActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSSFPreviewActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFPreviewActionBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPreviewActionBase pSSFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPreviewActionBase.getActionParam() == null;
            }
            case 1: {
                return pSSFPreviewActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSSFPreviewActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSSFPreviewActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSSFPreviewActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSSFPreviewActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSSFPreviewActionBase.getActionResult() == null;
            }
            case 7: {
                return pSSFPreviewActionBase.getActionState() == null;
            }
            case 8: {
                return pSSFPreviewActionBase.getBeginTime() == null;
            }
            case 9: {
                return pSSFPreviewActionBase.getCodeUrl() == null;
            }
            case 10: {
                return pSSFPreviewActionBase.getCreateDate() == null;
            }
            case 11: {
                return pSSFPreviewActionBase.getCreateMan() == null;
            }
            case 12: {
                return pSSFPreviewActionBase.getEndTime() == null;
            }
            case 13: {
                return pSSFPreviewActionBase.getPreviewInfo() == null;
            }
            case 14: {
                return pSSFPreviewActionBase.getPreviewStep() == null;
            }
            case 15: {
                return pSSFPreviewActionBase.getPreviewUrl() == null;
            }
            case 16: {
                return pSSFPreviewActionBase.getPSDevSlnSysId() == null;
            }
            case 17: {
                return pSSFPreviewActionBase.getPSDSConsoleId() == null;
            }
            case 18: {
                return pSSFPreviewActionBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSSFPreviewActionBase.getPSObjId() == null;
            }
            case 20: {
                return pSSFPreviewActionBase.getPSObjType() == null;
            }
            case 21: {
                return pSSFPreviewActionBase.getPSSFId() == null;
            }
            case 22: {
                return pSSFPreviewActionBase.getPSSFPreviewActionId() == null;
            }
            case 23: {
                return pSSFPreviewActionBase.getPSSFPreviewActionName() == null;
            }
            case 24: {
                return pSSFPreviewActionBase.getPSSFStyleId() == null;
            }
            case 25: {
                return pSSFPreviewActionBase.getPSSysAppId() == null;
            }
            case 26: {
                return pSSFPreviewActionBase.getPSSysSFPubId() == null;
            }
            case 27: {
                return pSSFPreviewActionBase.getPSTaskServerId() == null;
            }
            case 28: {
                return pSSFPreviewActionBase.getUpdateDate() == null;
            }
            case 29: {
                return pSSFPreviewActionBase.getUpdateMan() == null;
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
        return PSSFPreviewActionBase.contains(this, n);
    }

    private static boolean contains(PSSFPreviewActionBase pSSFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPreviewActionBase.isActionParamDirty();
            }
            case 1: {
                return pSSFPreviewActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSSFPreviewActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSSFPreviewActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSSFPreviewActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSSFPreviewActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSSFPreviewActionBase.isActionResultDirty();
            }
            case 7: {
                return pSSFPreviewActionBase.isActionStateDirty();
            }
            case 8: {
                return pSSFPreviewActionBase.isBeginTimeDirty();
            }
            case 9: {
                return pSSFPreviewActionBase.isCodeUrlDirty();
            }
            case 10: {
                return pSSFPreviewActionBase.isCreateDateDirty();
            }
            case 11: {
                return pSSFPreviewActionBase.isCreateManDirty();
            }
            case 12: {
                return pSSFPreviewActionBase.isEndTimeDirty();
            }
            case 13: {
                return pSSFPreviewActionBase.isPreviewInfoDirty();
            }
            case 14: {
                return pSSFPreviewActionBase.isPreviewStepDirty();
            }
            case 15: {
                return pSSFPreviewActionBase.isPreviewUrlDirty();
            }
            case 16: {
                return pSSFPreviewActionBase.isPSDevSlnSysIdDirty();
            }
            case 17: {
                return pSSFPreviewActionBase.isPSDSConsoleIdDirty();
            }
            case 18: {
                return pSSFPreviewActionBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSSFPreviewActionBase.isPSObjIdDirty();
            }
            case 20: {
                return pSSFPreviewActionBase.isPSObjTypeDirty();
            }
            case 21: {
                return pSSFPreviewActionBase.isPSSFIdDirty();
            }
            case 22: {
                return pSSFPreviewActionBase.isPSSFPreviewActionIdDirty();
            }
            case 23: {
                return pSSFPreviewActionBase.isPSSFPreviewActionNameDirty();
            }
            case 24: {
                return pSSFPreviewActionBase.isPSSFStyleIdDirty();
            }
            case 25: {
                return pSSFPreviewActionBase.isPSSysAppIdDirty();
            }
            case 26: {
                return pSSFPreviewActionBase.isPSSysSFPubIdDirty();
            }
            case 27: {
                return pSSFPreviewActionBase.isPSTaskServerIdDirty();
            }
            case 28: {
                return pSSFPreviewActionBase.isUpdateDateDirty();
            }
            case 29: {
                return pSSFPreviewActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPreviewActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPreviewActionBase pSSFPreviewActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPreviewActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getCodeUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeurl", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getCodeUrl()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPreviewInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewinfo", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPreviewInfo()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPreviewStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewstep", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPreviewStep()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPreviewUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewurl", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPreviewUrl()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSFPreviewActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpreviewactionid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSFPreviewActionId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSFPreviewActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpreviewactionname", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSFPreviewActionName()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPreviewActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPreviewActionBase.getJSONValue((Object)pSSFPreviewActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPreviewActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPreviewActionBase pSSFPreviewActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPreviewActionBase.getActionParam() != null) {
            object = pSSFPreviewActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSFPreviewActionBase.getActionParam2() != null) {
            object = pSSFPreviewActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSFPreviewActionBase.getActionParam3() != null) {
            object = pSSFPreviewActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSSFPreviewActionBase.getActionParam4() != null) {
            object = pSSFPreviewActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getActionParam5() != null) {
            object = pSSFPreviewActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getActionParam6() != null) {
            object = pSSFPreviewActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getActionResult() != null) {
            object = pSSFPreviewActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getActionState() != null) {
            object = pSSFPreviewActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getBeginTime() != null) {
            object = pSSFPreviewActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getCodeUrl() != null) {
            object = pSSFPreviewActionBase.getCodeUrl();
            xmlNode.setAttribute(FIELD_CODEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getCreateDate() != null) {
            object = pSSFPreviewActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getCreateMan() != null) {
            object = pSSFPreviewActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getEndTime() != null) {
            object = pSSFPreviewActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getPreviewInfo() != null) {
            object = pSSFPreviewActionBase.getPreviewInfo();
            xmlNode.setAttribute(FIELD_PREVIEWINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPreviewStep() != null) {
            object = pSSFPreviewActionBase.getPreviewStep();
            xmlNode.setAttribute(FIELD_PREVIEWSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPreviewUrl() != null) {
            object = pSSFPreviewActionBase.getPreviewUrl();
            xmlNode.setAttribute(FIELD_PREVIEWURL, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSDevSlnSysId() != null) {
            object = pSSFPreviewActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSDSConsoleId() != null) {
            object = pSSFPreviewActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSDynaInstId() != null) {
            object = pSSFPreviewActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSObjId() != null) {
            object = pSSFPreviewActionBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSObjType() != null) {
            object = pSSFPreviewActionBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSFId() != null) {
            object = pSSFPreviewActionBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSFPreviewActionId() != null) {
            object = pSSFPreviewActionBase.getPSSFPreviewActionId();
            xmlNode.setAttribute(FIELD_PSSFPREVIEWACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSFPreviewActionName() != null) {
            object = pSSFPreviewActionBase.getPSSFPreviewActionName();
            xmlNode.setAttribute(FIELD_PSSFPREVIEWACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSFStyleId() != null) {
            object = pSSFPreviewActionBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSysAppId() != null) {
            object = pSSFPreviewActionBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSSysSFPubId() != null) {
            object = pSSFPreviewActionBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getPSTaskServerId() != null) {
            object = pSSFPreviewActionBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPreviewActionBase.getUpdateDate() != null) {
            object = pSSFPreviewActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPreviewActionBase.getUpdateMan() != null) {
            object = pSSFPreviewActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPreviewActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPreviewActionBase pSSFPreviewActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPreviewActionBase.isActionParamDirty() && (bl || pSSFPreviewActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSSFPreviewActionBase.getActionParam());
        }
        if (pSSFPreviewActionBase.isActionParam2Dirty() && (bl || pSSFPreviewActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSSFPreviewActionBase.getActionParam2());
        }
        if (pSSFPreviewActionBase.isActionParam3Dirty() && (bl || pSSFPreviewActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSSFPreviewActionBase.getActionParam3());
        }
        if (pSSFPreviewActionBase.isActionParam4Dirty() && (bl || pSSFPreviewActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSSFPreviewActionBase.getActionParam4());
        }
        if (pSSFPreviewActionBase.isActionParam5Dirty() && (bl || pSSFPreviewActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSSFPreviewActionBase.getActionParam5());
        }
        if (pSSFPreviewActionBase.isActionParam6Dirty() && (bl || pSSFPreviewActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSSFPreviewActionBase.getActionParam6());
        }
        if (pSSFPreviewActionBase.isActionResultDirty() && (bl || pSSFPreviewActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSSFPreviewActionBase.getActionResult());
        }
        if (pSSFPreviewActionBase.isActionStateDirty() && (bl || pSSFPreviewActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSSFPreviewActionBase.getActionState());
        }
        if (pSSFPreviewActionBase.isBeginTimeDirty() && (bl || pSSFPreviewActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSSFPreviewActionBase.getBeginTime());
        }
        if (pSSFPreviewActionBase.isCodeUrlDirty() && (bl || pSSFPreviewActionBase.getCodeUrl() != null)) {
            iDataObject.set(FIELD_CODEURL, (Object)pSSFPreviewActionBase.getCodeUrl());
        }
        if (pSSFPreviewActionBase.isCreateDateDirty() && (bl || pSSFPreviewActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPreviewActionBase.getCreateDate());
        }
        if (pSSFPreviewActionBase.isCreateManDirty() && (bl || pSSFPreviewActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPreviewActionBase.getCreateMan());
        }
        if (pSSFPreviewActionBase.isEndTimeDirty() && (bl || pSSFPreviewActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSSFPreviewActionBase.getEndTime());
        }
        if (pSSFPreviewActionBase.isPreviewInfoDirty() && (bl || pSSFPreviewActionBase.getPreviewInfo() != null)) {
            iDataObject.set(FIELD_PREVIEWINFO, (Object)pSSFPreviewActionBase.getPreviewInfo());
        }
        if (pSSFPreviewActionBase.isPreviewStepDirty() && (bl || pSSFPreviewActionBase.getPreviewStep() != null)) {
            iDataObject.set(FIELD_PREVIEWSTEP, (Object)pSSFPreviewActionBase.getPreviewStep());
        }
        if (pSSFPreviewActionBase.isPreviewUrlDirty() && (bl || pSSFPreviewActionBase.getPreviewUrl() != null)) {
            iDataObject.set(FIELD_PREVIEWURL, (Object)pSSFPreviewActionBase.getPreviewUrl());
        }
        if (pSSFPreviewActionBase.isPSDevSlnSysIdDirty() && (bl || pSSFPreviewActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSFPreviewActionBase.getPSDevSlnSysId());
        }
        if (pSSFPreviewActionBase.isPSDSConsoleIdDirty() && (bl || pSSFPreviewActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSSFPreviewActionBase.getPSDSConsoleId());
        }
        if (pSSFPreviewActionBase.isPSDynaInstIdDirty() && (bl || pSSFPreviewActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSFPreviewActionBase.getPSDynaInstId());
        }
        if (pSSFPreviewActionBase.isPSObjIdDirty() && (bl || pSSFPreviewActionBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSFPreviewActionBase.getPSObjId());
        }
        if (pSSFPreviewActionBase.isPSObjTypeDirty() && (bl || pSSFPreviewActionBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSFPreviewActionBase.getPSObjType());
        }
        if (pSSFPreviewActionBase.isPSSFIdDirty() && (bl || pSSFPreviewActionBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPreviewActionBase.getPSSFId());
        }
        if (pSSFPreviewActionBase.isPSSFPreviewActionIdDirty() && (bl || pSSFPreviewActionBase.getPSSFPreviewActionId() != null)) {
            iDataObject.set(FIELD_PSSFPREVIEWACTIONID, (Object)pSSFPreviewActionBase.getPSSFPreviewActionId());
        }
        if (pSSFPreviewActionBase.isPSSFPreviewActionNameDirty() && (bl || pSSFPreviewActionBase.getPSSFPreviewActionName() != null)) {
            iDataObject.set(FIELD_PSSFPREVIEWACTIONNAME, (Object)pSSFPreviewActionBase.getPSSFPreviewActionName());
        }
        if (pSSFPreviewActionBase.isPSSFStyleIdDirty() && (bl || pSSFPreviewActionBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFPreviewActionBase.getPSSFStyleId());
        }
        if (pSSFPreviewActionBase.isPSSysAppIdDirty() && (bl || pSSFPreviewActionBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSFPreviewActionBase.getPSSysAppId());
        }
        if (pSSFPreviewActionBase.isPSSysSFPubIdDirty() && (bl || pSSFPreviewActionBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSFPreviewActionBase.getPSSysSFPubId());
        }
        if (pSSFPreviewActionBase.isPSTaskServerIdDirty() && (bl || pSSFPreviewActionBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSSFPreviewActionBase.getPSTaskServerId());
        }
        if (pSSFPreviewActionBase.isUpdateDateDirty() && (bl || pSSFPreviewActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPreviewActionBase.getUpdateDate());
        }
        if (pSSFPreviewActionBase.isUpdateManDirty() && (bl || pSSFPreviewActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPreviewActionBase.getUpdateMan());
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
        return PSSFPreviewActionBase.remove(this, n);
    }

    private static boolean remove(PSSFPreviewActionBase pSSFPreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPreviewActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSSFPreviewActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSSFPreviewActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSSFPreviewActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSSFPreviewActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSSFPreviewActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSSFPreviewActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSSFPreviewActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSSFPreviewActionBase.resetBeginTime();
                return true;
            }
            case 9: {
                pSSFPreviewActionBase.resetCodeUrl();
                return true;
            }
            case 10: {
                pSSFPreviewActionBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSSFPreviewActionBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSSFPreviewActionBase.resetEndTime();
                return true;
            }
            case 13: {
                pSSFPreviewActionBase.resetPreviewInfo();
                return true;
            }
            case 14: {
                pSSFPreviewActionBase.resetPreviewStep();
                return true;
            }
            case 15: {
                pSSFPreviewActionBase.resetPreviewUrl();
                return true;
            }
            case 16: {
                pSSFPreviewActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 17: {
                pSSFPreviewActionBase.resetPSDSConsoleId();
                return true;
            }
            case 18: {
                pSSFPreviewActionBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSSFPreviewActionBase.resetPSObjId();
                return true;
            }
            case 20: {
                pSSFPreviewActionBase.resetPSObjType();
                return true;
            }
            case 21: {
                pSSFPreviewActionBase.resetPSSFId();
                return true;
            }
            case 22: {
                pSSFPreviewActionBase.resetPSSFPreviewActionId();
                return true;
            }
            case 23: {
                pSSFPreviewActionBase.resetPSSFPreviewActionName();
                return true;
            }
            case 24: {
                pSSFPreviewActionBase.resetPSSFStyleId();
                return true;
            }
            case 25: {
                pSSFPreviewActionBase.resetPSSysAppId();
                return true;
            }
            case 26: {
                pSSFPreviewActionBase.resetPSSysSFPubId();
                return true;
            }
            case 27: {
                pSSFPreviewActionBase.resetPSTaskServerId();
                return true;
            }
            case 28: {
                pSSFPreviewActionBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSSFPreviewActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSFPreviewActionBase getProxyEntity() {
        return this.proxyPSSFPreviewActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPreviewActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPreviewActionBase) {
            this.proxyPSSFPreviewActionBase = (PSSFPreviewActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSFPreviewActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_ENDTIME, 12);
        fieldIndexMap.put(FIELD_PREVIEWINFO, 13);
        fieldIndexMap.put(FIELD_PREVIEWSTEP, 14);
        fieldIndexMap.put(FIELD_PREVIEWURL, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 16);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_PSOBJID, 19);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 20);
        fieldIndexMap.put(FIELD_PSSFID, 21);
        fieldIndexMap.put(FIELD_PSSFPREVIEWACTIONID, 22);
        fieldIndexMap.put(FIELD_PSSFPREVIEWACTIONNAME, 23);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 24);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 25);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 26);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
    }
}

