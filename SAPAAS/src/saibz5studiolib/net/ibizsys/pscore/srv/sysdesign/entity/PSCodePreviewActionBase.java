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

public abstract class PSCodePreviewActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodePreviewActionBase.class);
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
    public static final String FIELD_PREVIEWSTEP = "PREVIEWSTEP";
    public static final String FIELD_PSCODEPREVIEWACTIONID = "PSCODEPREVIEWACTIONID";
    public static final String FIELD_PSCODEPREVIEWACTIONNAME = "PSCODEPREVIEWACTIONNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
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
    private static final int INDEX_PREVIEWSTEP = 13;
    private static final int INDEX_PSCODEPREVIEWACTIONID = 14;
    private static final int INDEX_PSCODEPREVIEWACTIONNAME = 15;
    private static final int INDEX_PSDEVSLNSYSID = 16;
    private static final int INDEX_PSDSCONSOLEID = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_PSOBJID = 19;
    private static final int INDEX_PSOBJTYPE = 20;
    private static final int INDEX_PSSYSAPPID = 21;
    private static final int INDEX_PSTASKSERVERID = 22;
    private static final int INDEX_TEMPLCODE = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodePreviewActionBase proxyPSCodePreviewActionBase = null;
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
    private boolean previewstepDirtyFlag = false;
    private boolean pscodepreviewactionidDirtyFlag = false;
    private boolean pscodepreviewactionnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
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
    @Column(name="previewstep")
    private String previewstep;
    @Column(name="pscodepreviewactionid")
    private String pscodepreviewactionid;
    @Column(name="pscodepreviewactionname")
    private String pscodepreviewactionname;
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
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="templcode")
    private String templcode;
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

    public void setPSCodePreviewActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodePreviewActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodepreviewactionid = string;
        this.pscodepreviewactionidDirtyFlag = true;
    }

    public String getPSCodePreviewActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodePreviewActionId();
        }
        return this.pscodepreviewactionid;
    }

    public boolean isPSCodePreviewActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodePreviewActionIdDirty();
        }
        return this.pscodepreviewactionidDirtyFlag;
    }

    public void resetPSCodePreviewActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodePreviewActionId();
            return;
        }
        this.pscodepreviewactionidDirtyFlag = false;
        this.pscodepreviewactionid = null;
    }

    public void setPSCodePreviewActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodePreviewActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodepreviewactionname = string;
        this.pscodepreviewactionnameDirtyFlag = true;
    }

    public String getPSCodePreviewActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodePreviewActionName();
        }
        return this.pscodepreviewactionname;
    }

    public boolean isPSCodePreviewActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodePreviewActionNameDirty();
        }
        return this.pscodepreviewactionnameDirtyFlag;
    }

    public void resetPSCodePreviewActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodePreviewActionName();
            return;
        }
        this.pscodepreviewactionnameDirtyFlag = false;
        this.pscodepreviewactionname = null;
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

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
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
        PSCodePreviewActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodePreviewActionBase pSCodePreviewActionBase) {
        pSCodePreviewActionBase.resetActionParam();
        pSCodePreviewActionBase.resetActionParam2();
        pSCodePreviewActionBase.resetActionParam3();
        pSCodePreviewActionBase.resetActionParam4();
        pSCodePreviewActionBase.resetActionParam5();
        pSCodePreviewActionBase.resetActionParam6();
        pSCodePreviewActionBase.resetActionResult();
        pSCodePreviewActionBase.resetActionState();
        pSCodePreviewActionBase.resetBeginTime();
        pSCodePreviewActionBase.resetCodeUrl();
        pSCodePreviewActionBase.resetCreateDate();
        pSCodePreviewActionBase.resetCreateMan();
        pSCodePreviewActionBase.resetEndTime();
        pSCodePreviewActionBase.resetPreviewStep();
        pSCodePreviewActionBase.resetPSCodePreviewActionId();
        pSCodePreviewActionBase.resetPSCodePreviewActionName();
        pSCodePreviewActionBase.resetPSDevSlnSysId();
        pSCodePreviewActionBase.resetPSDSConsoleId();
        pSCodePreviewActionBase.resetPSDynaInstId();
        pSCodePreviewActionBase.resetPSObjId();
        pSCodePreviewActionBase.resetPSObjType();
        pSCodePreviewActionBase.resetPSSysAppId();
        pSCodePreviewActionBase.resetPSTaskServerId();
        pSCodePreviewActionBase.resetTemplCode();
        pSCodePreviewActionBase.resetUpdateDate();
        pSCodePreviewActionBase.resetUpdateMan();
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
        if (!bl || this.isPreviewStepDirty()) {
            hashMap.put(FIELD_PREVIEWSTEP, this.getPreviewStep());
        }
        if (!bl || this.isPSCodePreviewActionIdDirty()) {
            hashMap.put(FIELD_PSCODEPREVIEWACTIONID, this.getPSCodePreviewActionId());
        }
        if (!bl || this.isPSCodePreviewActionNameDirty()) {
            hashMap.put(FIELD_PSCODEPREVIEWACTIONNAME, this.getPSCodePreviewActionName());
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
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
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
        return PSCodePreviewActionBase.get(this, n);
    }

    private static Object get(PSCodePreviewActionBase pSCodePreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodePreviewActionBase.getActionParam();
            }
            case 1: {
                return pSCodePreviewActionBase.getActionParam2();
            }
            case 2: {
                return pSCodePreviewActionBase.getActionParam3();
            }
            case 3: {
                return pSCodePreviewActionBase.getActionParam4();
            }
            case 4: {
                return pSCodePreviewActionBase.getActionParam5();
            }
            case 5: {
                return pSCodePreviewActionBase.getActionParam6();
            }
            case 6: {
                return pSCodePreviewActionBase.getActionResult();
            }
            case 7: {
                return pSCodePreviewActionBase.getActionState();
            }
            case 8: {
                return pSCodePreviewActionBase.getBeginTime();
            }
            case 9: {
                return pSCodePreviewActionBase.getCodeUrl();
            }
            case 10: {
                return pSCodePreviewActionBase.getCreateDate();
            }
            case 11: {
                return pSCodePreviewActionBase.getCreateMan();
            }
            case 12: {
                return pSCodePreviewActionBase.getEndTime();
            }
            case 13: {
                return pSCodePreviewActionBase.getPreviewStep();
            }
            case 14: {
                return pSCodePreviewActionBase.getPSCodePreviewActionId();
            }
            case 15: {
                return pSCodePreviewActionBase.getPSCodePreviewActionName();
            }
            case 16: {
                return pSCodePreviewActionBase.getPSDevSlnSysId();
            }
            case 17: {
                return pSCodePreviewActionBase.getPSDSConsoleId();
            }
            case 18: {
                return pSCodePreviewActionBase.getPSDynaInstId();
            }
            case 19: {
                return pSCodePreviewActionBase.getPSObjId();
            }
            case 20: {
                return pSCodePreviewActionBase.getPSObjType();
            }
            case 21: {
                return pSCodePreviewActionBase.getPSSysAppId();
            }
            case 22: {
                return pSCodePreviewActionBase.getPSTaskServerId();
            }
            case 23: {
                return pSCodePreviewActionBase.getTemplCode();
            }
            case 24: {
                return pSCodePreviewActionBase.getUpdateDate();
            }
            case 25: {
                return pSCodePreviewActionBase.getUpdateMan();
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
        PSCodePreviewActionBase.set(this, n, object);
    }

    private static void set(PSCodePreviewActionBase pSCodePreviewActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodePreviewActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCodePreviewActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodePreviewActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodePreviewActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodePreviewActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSCodePreviewActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSCodePreviewActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCodePreviewActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSCodePreviewActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSCodePreviewActionBase.setCodeUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCodePreviewActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCodePreviewActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCodePreviewActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSCodePreviewActionBase.setPreviewStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCodePreviewActionBase.setPSCodePreviewActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCodePreviewActionBase.setPSCodePreviewActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCodePreviewActionBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCodePreviewActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCodePreviewActionBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCodePreviewActionBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCodePreviewActionBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCodePreviewActionBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCodePreviewActionBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCodePreviewActionBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSCodePreviewActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSCodePreviewActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCodePreviewActionBase.isNull(this, n);
    }

    private static boolean isNull(PSCodePreviewActionBase pSCodePreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodePreviewActionBase.getActionParam() == null;
            }
            case 1: {
                return pSCodePreviewActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSCodePreviewActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSCodePreviewActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSCodePreviewActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSCodePreviewActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSCodePreviewActionBase.getActionResult() == null;
            }
            case 7: {
                return pSCodePreviewActionBase.getActionState() == null;
            }
            case 8: {
                return pSCodePreviewActionBase.getBeginTime() == null;
            }
            case 9: {
                return pSCodePreviewActionBase.getCodeUrl() == null;
            }
            case 10: {
                return pSCodePreviewActionBase.getCreateDate() == null;
            }
            case 11: {
                return pSCodePreviewActionBase.getCreateMan() == null;
            }
            case 12: {
                return pSCodePreviewActionBase.getEndTime() == null;
            }
            case 13: {
                return pSCodePreviewActionBase.getPreviewStep() == null;
            }
            case 14: {
                return pSCodePreviewActionBase.getPSCodePreviewActionId() == null;
            }
            case 15: {
                return pSCodePreviewActionBase.getPSCodePreviewActionName() == null;
            }
            case 16: {
                return pSCodePreviewActionBase.getPSDevSlnSysId() == null;
            }
            case 17: {
                return pSCodePreviewActionBase.getPSDSConsoleId() == null;
            }
            case 18: {
                return pSCodePreviewActionBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSCodePreviewActionBase.getPSObjId() == null;
            }
            case 20: {
                return pSCodePreviewActionBase.getPSObjType() == null;
            }
            case 21: {
                return pSCodePreviewActionBase.getPSSysAppId() == null;
            }
            case 22: {
                return pSCodePreviewActionBase.getPSTaskServerId() == null;
            }
            case 23: {
                return pSCodePreviewActionBase.getTemplCode() == null;
            }
            case 24: {
                return pSCodePreviewActionBase.getUpdateDate() == null;
            }
            case 25: {
                return pSCodePreviewActionBase.getUpdateMan() == null;
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
        return PSCodePreviewActionBase.contains(this, n);
    }

    private static boolean contains(PSCodePreviewActionBase pSCodePreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodePreviewActionBase.isActionParamDirty();
            }
            case 1: {
                return pSCodePreviewActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSCodePreviewActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSCodePreviewActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSCodePreviewActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSCodePreviewActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSCodePreviewActionBase.isActionResultDirty();
            }
            case 7: {
                return pSCodePreviewActionBase.isActionStateDirty();
            }
            case 8: {
                return pSCodePreviewActionBase.isBeginTimeDirty();
            }
            case 9: {
                return pSCodePreviewActionBase.isCodeUrlDirty();
            }
            case 10: {
                return pSCodePreviewActionBase.isCreateDateDirty();
            }
            case 11: {
                return pSCodePreviewActionBase.isCreateManDirty();
            }
            case 12: {
                return pSCodePreviewActionBase.isEndTimeDirty();
            }
            case 13: {
                return pSCodePreviewActionBase.isPreviewStepDirty();
            }
            case 14: {
                return pSCodePreviewActionBase.isPSCodePreviewActionIdDirty();
            }
            case 15: {
                return pSCodePreviewActionBase.isPSCodePreviewActionNameDirty();
            }
            case 16: {
                return pSCodePreviewActionBase.isPSDevSlnSysIdDirty();
            }
            case 17: {
                return pSCodePreviewActionBase.isPSDSConsoleIdDirty();
            }
            case 18: {
                return pSCodePreviewActionBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSCodePreviewActionBase.isPSObjIdDirty();
            }
            case 20: {
                return pSCodePreviewActionBase.isPSObjTypeDirty();
            }
            case 21: {
                return pSCodePreviewActionBase.isPSSysAppIdDirty();
            }
            case 22: {
                return pSCodePreviewActionBase.isPSTaskServerIdDirty();
            }
            case 23: {
                return pSCodePreviewActionBase.isTemplCodeDirty();
            }
            case 24: {
                return pSCodePreviewActionBase.isUpdateDateDirty();
            }
            case 25: {
                return pSCodePreviewActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodePreviewActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodePreviewActionBase pSCodePreviewActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodePreviewActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getCodeUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeurl", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getCodeUrl()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPreviewStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewstep", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPreviewStep()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSCodePreviewActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodepreviewactionid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSCodePreviewActionId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSCodePreviewActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodepreviewactionname", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSCodePreviewActionName()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodePreviewActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodePreviewActionBase.getJSONValue((Object)pSCodePreviewActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodePreviewActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodePreviewActionBase pSCodePreviewActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodePreviewActionBase.getActionParam() != null) {
            object = pSCodePreviewActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSCodePreviewActionBase.getActionParam2() != null) {
            object = pSCodePreviewActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSCodePreviewActionBase.getActionParam3() != null) {
            object = pSCodePreviewActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSCodePreviewActionBase.getActionParam4() != null) {
            object = pSCodePreviewActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getActionParam5() != null) {
            object = pSCodePreviewActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getActionParam6() != null) {
            object = pSCodePreviewActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getActionResult() != null) {
            object = pSCodePreviewActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getActionState() != null) {
            object = pSCodePreviewActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getBeginTime() != null) {
            object = pSCodePreviewActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getCodeUrl() != null) {
            object = pSCodePreviewActionBase.getCodeUrl();
            xmlNode.setAttribute(FIELD_CODEURL, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getCreateDate() != null) {
            object = pSCodePreviewActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getCreateMan() != null) {
            object = pSCodePreviewActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getEndTime() != null) {
            object = pSCodePreviewActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getPreviewStep() != null) {
            object = pSCodePreviewActionBase.getPreviewStep();
            xmlNode.setAttribute(FIELD_PREVIEWSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSCodePreviewActionId() != null) {
            object = pSCodePreviewActionBase.getPSCodePreviewActionId();
            xmlNode.setAttribute(FIELD_PSCODEPREVIEWACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSCodePreviewActionName() != null) {
            object = pSCodePreviewActionBase.getPSCodePreviewActionName();
            xmlNode.setAttribute(FIELD_PSCODEPREVIEWACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSDevSlnSysId() != null) {
            object = pSCodePreviewActionBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSDSConsoleId() != null) {
            object = pSCodePreviewActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSDynaInstId() != null) {
            object = pSCodePreviewActionBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSObjId() != null) {
            object = pSCodePreviewActionBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSObjType() != null) {
            object = pSCodePreviewActionBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSSysAppId() != null) {
            object = pSCodePreviewActionBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getPSTaskServerId() != null) {
            object = pSCodePreviewActionBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getTemplCode() != null) {
            object = pSCodePreviewActionBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSCodePreviewActionBase.getUpdateDate() != null) {
            object = pSCodePreviewActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodePreviewActionBase.getUpdateMan() != null) {
            object = pSCodePreviewActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodePreviewActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodePreviewActionBase pSCodePreviewActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodePreviewActionBase.isActionParamDirty() && (bl || pSCodePreviewActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSCodePreviewActionBase.getActionParam());
        }
        if (pSCodePreviewActionBase.isActionParam2Dirty() && (bl || pSCodePreviewActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSCodePreviewActionBase.getActionParam2());
        }
        if (pSCodePreviewActionBase.isActionParam3Dirty() && (bl || pSCodePreviewActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSCodePreviewActionBase.getActionParam3());
        }
        if (pSCodePreviewActionBase.isActionParam4Dirty() && (bl || pSCodePreviewActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSCodePreviewActionBase.getActionParam4());
        }
        if (pSCodePreviewActionBase.isActionParam5Dirty() && (bl || pSCodePreviewActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSCodePreviewActionBase.getActionParam5());
        }
        if (pSCodePreviewActionBase.isActionParam6Dirty() && (bl || pSCodePreviewActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSCodePreviewActionBase.getActionParam6());
        }
        if (pSCodePreviewActionBase.isActionResultDirty() && (bl || pSCodePreviewActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSCodePreviewActionBase.getActionResult());
        }
        if (pSCodePreviewActionBase.isActionStateDirty() && (bl || pSCodePreviewActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSCodePreviewActionBase.getActionState());
        }
        if (pSCodePreviewActionBase.isBeginTimeDirty() && (bl || pSCodePreviewActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSCodePreviewActionBase.getBeginTime());
        }
        if (pSCodePreviewActionBase.isCodeUrlDirty() && (bl || pSCodePreviewActionBase.getCodeUrl() != null)) {
            iDataObject.set(FIELD_CODEURL, (Object)pSCodePreviewActionBase.getCodeUrl());
        }
        if (pSCodePreviewActionBase.isCreateDateDirty() && (bl || pSCodePreviewActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodePreviewActionBase.getCreateDate());
        }
        if (pSCodePreviewActionBase.isCreateManDirty() && (bl || pSCodePreviewActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodePreviewActionBase.getCreateMan());
        }
        if (pSCodePreviewActionBase.isEndTimeDirty() && (bl || pSCodePreviewActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSCodePreviewActionBase.getEndTime());
        }
        if (pSCodePreviewActionBase.isPreviewStepDirty() && (bl || pSCodePreviewActionBase.getPreviewStep() != null)) {
            iDataObject.set(FIELD_PREVIEWSTEP, (Object)pSCodePreviewActionBase.getPreviewStep());
        }
        if (pSCodePreviewActionBase.isPSCodePreviewActionIdDirty() && (bl || pSCodePreviewActionBase.getPSCodePreviewActionId() != null)) {
            iDataObject.set(FIELD_PSCODEPREVIEWACTIONID, (Object)pSCodePreviewActionBase.getPSCodePreviewActionId());
        }
        if (pSCodePreviewActionBase.isPSCodePreviewActionNameDirty() && (bl || pSCodePreviewActionBase.getPSCodePreviewActionName() != null)) {
            iDataObject.set(FIELD_PSCODEPREVIEWACTIONNAME, (Object)pSCodePreviewActionBase.getPSCodePreviewActionName());
        }
        if (pSCodePreviewActionBase.isPSDevSlnSysIdDirty() && (bl || pSCodePreviewActionBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSCodePreviewActionBase.getPSDevSlnSysId());
        }
        if (pSCodePreviewActionBase.isPSDSConsoleIdDirty() && (bl || pSCodePreviewActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSCodePreviewActionBase.getPSDSConsoleId());
        }
        if (pSCodePreviewActionBase.isPSDynaInstIdDirty() && (bl || pSCodePreviewActionBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSCodePreviewActionBase.getPSDynaInstId());
        }
        if (pSCodePreviewActionBase.isPSObjIdDirty() && (bl || pSCodePreviewActionBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSCodePreviewActionBase.getPSObjId());
        }
        if (pSCodePreviewActionBase.isPSObjTypeDirty() && (bl || pSCodePreviewActionBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSCodePreviewActionBase.getPSObjType());
        }
        if (pSCodePreviewActionBase.isPSSysAppIdDirty() && (bl || pSCodePreviewActionBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSCodePreviewActionBase.getPSSysAppId());
        }
        if (pSCodePreviewActionBase.isPSTaskServerIdDirty() && (bl || pSCodePreviewActionBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSCodePreviewActionBase.getPSTaskServerId());
        }
        if (pSCodePreviewActionBase.isTemplCodeDirty() && (bl || pSCodePreviewActionBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSCodePreviewActionBase.getTemplCode());
        }
        if (pSCodePreviewActionBase.isUpdateDateDirty() && (bl || pSCodePreviewActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodePreviewActionBase.getUpdateDate());
        }
        if (pSCodePreviewActionBase.isUpdateManDirty() && (bl || pSCodePreviewActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodePreviewActionBase.getUpdateMan());
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
        return PSCodePreviewActionBase.remove(this, n);
    }

    private static boolean remove(PSCodePreviewActionBase pSCodePreviewActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodePreviewActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSCodePreviewActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSCodePreviewActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSCodePreviewActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSCodePreviewActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSCodePreviewActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSCodePreviewActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSCodePreviewActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSCodePreviewActionBase.resetBeginTime();
                return true;
            }
            case 9: {
                pSCodePreviewActionBase.resetCodeUrl();
                return true;
            }
            case 10: {
                pSCodePreviewActionBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSCodePreviewActionBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSCodePreviewActionBase.resetEndTime();
                return true;
            }
            case 13: {
                pSCodePreviewActionBase.resetPreviewStep();
                return true;
            }
            case 14: {
                pSCodePreviewActionBase.resetPSCodePreviewActionId();
                return true;
            }
            case 15: {
                pSCodePreviewActionBase.resetPSCodePreviewActionName();
                return true;
            }
            case 16: {
                pSCodePreviewActionBase.resetPSDevSlnSysId();
                return true;
            }
            case 17: {
                pSCodePreviewActionBase.resetPSDSConsoleId();
                return true;
            }
            case 18: {
                pSCodePreviewActionBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSCodePreviewActionBase.resetPSObjId();
                return true;
            }
            case 20: {
                pSCodePreviewActionBase.resetPSObjType();
                return true;
            }
            case 21: {
                pSCodePreviewActionBase.resetPSSysAppId();
                return true;
            }
            case 22: {
                pSCodePreviewActionBase.resetPSTaskServerId();
                return true;
            }
            case 23: {
                pSCodePreviewActionBase.resetTemplCode();
                return true;
            }
            case 24: {
                pSCodePreviewActionBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSCodePreviewActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCodePreviewActionBase getProxyEntity() {
        return this.proxyPSCodePreviewActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodePreviewActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodePreviewActionBase) {
            this.proxyPSCodePreviewActionBase = (PSCodePreviewActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodePreviewActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PREVIEWSTEP, 13);
        fieldIndexMap.put(FIELD_PSCODEPREVIEWACTIONID, 14);
        fieldIndexMap.put(FIELD_PSCODEPREVIEWACTIONNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 16);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_PSOBJID, 19);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 20);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 21);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 22);
        fieldIndexMap.put(FIELD_TEMPLCODE, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

