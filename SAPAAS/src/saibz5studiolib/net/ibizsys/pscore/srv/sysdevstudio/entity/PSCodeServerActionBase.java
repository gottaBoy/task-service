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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSCodeServerActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeServerActionBase.class);
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String FIELD_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String FIELD_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String FIELD_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String FIELD_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_ACTIONSTATE = "ACTIONSTATE";
    public static final String FIELD_ACTIONSTEP = "ACTIONSTEP";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CODESERVERURL = "CODESERVERURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSCODESERVERACTIONID = "PSCODESERVERACTIONID";
    public static final String FIELD_PSCODESERVERACTIONNAME = "PSCODESERVERACTIONNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
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
    private static final int INDEX_ACTIONSTEP = 8;
    private static final int INDEX_BEGINTIME = 9;
    private static final int INDEX_CODESERVERURL = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_ENDTIME = 13;
    private static final int INDEX_PASSWD = 14;
    private static final int INDEX_PSCODESERVERACTIONID = 15;
    private static final int INDEX_PSCODESERVERACTIONNAME = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDSCONSOLEID = 18;
    private static final int INDEX_PSOBJID = 19;
    private static final int INDEX_PSOBJTYPE = 20;
    private static final int INDEX_PSTASKSERVERID = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeServerActionBase proxyPSCodeServerActionBase = null;
    private boolean actionparamDirtyFlag = false;
    private boolean actionparam2DirtyFlag = false;
    private boolean actionparam3DirtyFlag = false;
    private boolean actionparam4DirtyFlag = false;
    private boolean actionparam5DirtyFlag = false;
    private boolean actionparam6DirtyFlag = false;
    private boolean actionresultDirtyFlag = false;
    private boolean actionstateDirtyFlag = false;
    private boolean actionstepDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean codeserverurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean pscodeserveractionidDirtyFlag = false;
    private boolean pscodeserveractionnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
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
    @Column(name="actionstep")
    private String actionstep;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="codeserverurl")
    private String codeserverurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="passwd")
    private String passwd;
    @Column(name="pscodeserveractionid")
    private String pscodeserveractionid;
    @Column(name="pscodeserveractionname")
    private String pscodeserveractionname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjtype")
    private String psobjtype;
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

    public void setActionStep(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionStep(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionstep = string;
        this.actionstepDirtyFlag = true;
    }

    public String getActionStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionStep();
        }
        return this.actionstep;
    }

    public boolean isActionStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionStepDirty();
        }
        return this.actionstepDirtyFlag;
    }

    public void resetActionStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionStep();
            return;
        }
        this.actionstepDirtyFlag = false;
        this.actionstep = null;
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

    public void setCodeServerUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeServerUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codeserverurl = string;
        this.codeserverurlDirtyFlag = true;
    }

    public String getCodeServerUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeServerUrl();
        }
        return this.codeserverurl;
    }

    public boolean isCodeServerUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeServerUrlDirty();
        }
        return this.codeserverurlDirtyFlag;
    }

    public void resetCodeServerUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeServerUrl();
            return;
        }
        this.codeserverurlDirtyFlag = false;
        this.codeserverurl = null;
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

    public void setPSCodeServerActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeServerActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodeserveractionid = string;
        this.pscodeserveractionidDirtyFlag = true;
    }

    public String getPSCodeServerActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeServerActionId();
        }
        return this.pscodeserveractionid;
    }

    public boolean isPSCodeServerActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeServerActionIdDirty();
        }
        return this.pscodeserveractionidDirtyFlag;
    }

    public void resetPSCodeServerActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeServerActionId();
            return;
        }
        this.pscodeserveractionidDirtyFlag = false;
        this.pscodeserveractionid = null;
    }

    public void setPSCodeServerActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeServerActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodeserveractionname = string;
        this.pscodeserveractionnameDirtyFlag = true;
    }

    public String getPSCodeServerActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeServerActionName();
        }
        return this.pscodeserveractionname;
    }

    public boolean isPSCodeServerActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeServerActionNameDirty();
        }
        return this.pscodeserveractionnameDirtyFlag;
    }

    public void resetPSCodeServerActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeServerActionName();
            return;
        }
        this.pscodeserveractionnameDirtyFlag = false;
        this.pscodeserveractionname = null;
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
        PSCodeServerActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeServerActionBase pSCodeServerActionBase) {
        pSCodeServerActionBase.resetActionParam();
        pSCodeServerActionBase.resetActionParam2();
        pSCodeServerActionBase.resetActionParam3();
        pSCodeServerActionBase.resetActionParam4();
        pSCodeServerActionBase.resetActionParam5();
        pSCodeServerActionBase.resetActionParam6();
        pSCodeServerActionBase.resetActionResult();
        pSCodeServerActionBase.resetActionState();
        pSCodeServerActionBase.resetActionStep();
        pSCodeServerActionBase.resetBeginTime();
        pSCodeServerActionBase.resetCodeServerUrl();
        pSCodeServerActionBase.resetCreateDate();
        pSCodeServerActionBase.resetCreateMan();
        pSCodeServerActionBase.resetEndTime();
        pSCodeServerActionBase.resetPasswd();
        pSCodeServerActionBase.resetPSCodeServerActionId();
        pSCodeServerActionBase.resetPSCodeServerActionName();
        pSCodeServerActionBase.resetPSDevSlnId();
        pSCodeServerActionBase.resetPSDSConsoleId();
        pSCodeServerActionBase.resetPSObjId();
        pSCodeServerActionBase.resetPSObjType();
        pSCodeServerActionBase.resetPSTaskServerId();
        pSCodeServerActionBase.resetUpdateDate();
        pSCodeServerActionBase.resetUpdateMan();
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
        if (!bl || this.isActionStepDirty()) {
            hashMap.put(FIELD_ACTIONSTEP, this.getActionStep());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCodeServerUrlDirty()) {
            hashMap.put(FIELD_CODESERVERURL, this.getCodeServerUrl());
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
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSCodeServerActionIdDirty()) {
            hashMap.put(FIELD_PSCODESERVERACTIONID, this.getPSCodeServerActionId());
        }
        if (!bl || this.isPSCodeServerActionNameDirty()) {
            hashMap.put(FIELD_PSCODESERVERACTIONNAME, this.getPSCodeServerActionName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
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
        return PSCodeServerActionBase.get(this, n);
    }

    private static Object get(PSCodeServerActionBase pSCodeServerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeServerActionBase.getActionParam();
            }
            case 1: {
                return pSCodeServerActionBase.getActionParam2();
            }
            case 2: {
                return pSCodeServerActionBase.getActionParam3();
            }
            case 3: {
                return pSCodeServerActionBase.getActionParam4();
            }
            case 4: {
                return pSCodeServerActionBase.getActionParam5();
            }
            case 5: {
                return pSCodeServerActionBase.getActionParam6();
            }
            case 6: {
                return pSCodeServerActionBase.getActionResult();
            }
            case 7: {
                return pSCodeServerActionBase.getActionState();
            }
            case 8: {
                return pSCodeServerActionBase.getActionStep();
            }
            case 9: {
                return pSCodeServerActionBase.getBeginTime();
            }
            case 10: {
                return pSCodeServerActionBase.getCodeServerUrl();
            }
            case 11: {
                return pSCodeServerActionBase.getCreateDate();
            }
            case 12: {
                return pSCodeServerActionBase.getCreateMan();
            }
            case 13: {
                return pSCodeServerActionBase.getEndTime();
            }
            case 14: {
                return pSCodeServerActionBase.getPasswd();
            }
            case 15: {
                return pSCodeServerActionBase.getPSCodeServerActionId();
            }
            case 16: {
                return pSCodeServerActionBase.getPSCodeServerActionName();
            }
            case 17: {
                return pSCodeServerActionBase.getPSDevSlnId();
            }
            case 18: {
                return pSCodeServerActionBase.getPSDSConsoleId();
            }
            case 19: {
                return pSCodeServerActionBase.getPSObjId();
            }
            case 20: {
                return pSCodeServerActionBase.getPSObjType();
            }
            case 21: {
                return pSCodeServerActionBase.getPSTaskServerId();
            }
            case 22: {
                return pSCodeServerActionBase.getUpdateDate();
            }
            case 23: {
                return pSCodeServerActionBase.getUpdateMan();
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
        PSCodeServerActionBase.set(this, n, object);
    }

    private static void set(PSCodeServerActionBase pSCodeServerActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeServerActionBase.setActionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCodeServerActionBase.setActionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeServerActionBase.setActionParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeServerActionBase.setActionParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeServerActionBase.setActionParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSCodeServerActionBase.setActionParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSCodeServerActionBase.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCodeServerActionBase.setActionState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSCodeServerActionBase.setActionStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCodeServerActionBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSCodeServerActionBase.setCodeServerUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCodeServerActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCodeServerActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCodeServerActionBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSCodeServerActionBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCodeServerActionBase.setPSCodeServerActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCodeServerActionBase.setPSCodeServerActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCodeServerActionBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCodeServerActionBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCodeServerActionBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCodeServerActionBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCodeServerActionBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCodeServerActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSCodeServerActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCodeServerActionBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeServerActionBase pSCodeServerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeServerActionBase.getActionParam() == null;
            }
            case 1: {
                return pSCodeServerActionBase.getActionParam2() == null;
            }
            case 2: {
                return pSCodeServerActionBase.getActionParam3() == null;
            }
            case 3: {
                return pSCodeServerActionBase.getActionParam4() == null;
            }
            case 4: {
                return pSCodeServerActionBase.getActionParam5() == null;
            }
            case 5: {
                return pSCodeServerActionBase.getActionParam6() == null;
            }
            case 6: {
                return pSCodeServerActionBase.getActionResult() == null;
            }
            case 7: {
                return pSCodeServerActionBase.getActionState() == null;
            }
            case 8: {
                return pSCodeServerActionBase.getActionStep() == null;
            }
            case 9: {
                return pSCodeServerActionBase.getBeginTime() == null;
            }
            case 10: {
                return pSCodeServerActionBase.getCodeServerUrl() == null;
            }
            case 11: {
                return pSCodeServerActionBase.getCreateDate() == null;
            }
            case 12: {
                return pSCodeServerActionBase.getCreateMan() == null;
            }
            case 13: {
                return pSCodeServerActionBase.getEndTime() == null;
            }
            case 14: {
                return pSCodeServerActionBase.getPasswd() == null;
            }
            case 15: {
                return pSCodeServerActionBase.getPSCodeServerActionId() == null;
            }
            case 16: {
                return pSCodeServerActionBase.getPSCodeServerActionName() == null;
            }
            case 17: {
                return pSCodeServerActionBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSCodeServerActionBase.getPSDSConsoleId() == null;
            }
            case 19: {
                return pSCodeServerActionBase.getPSObjId() == null;
            }
            case 20: {
                return pSCodeServerActionBase.getPSObjType() == null;
            }
            case 21: {
                return pSCodeServerActionBase.getPSTaskServerId() == null;
            }
            case 22: {
                return pSCodeServerActionBase.getUpdateDate() == null;
            }
            case 23: {
                return pSCodeServerActionBase.getUpdateMan() == null;
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
        return PSCodeServerActionBase.contains(this, n);
    }

    private static boolean contains(PSCodeServerActionBase pSCodeServerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeServerActionBase.isActionParamDirty();
            }
            case 1: {
                return pSCodeServerActionBase.isActionParam2Dirty();
            }
            case 2: {
                return pSCodeServerActionBase.isActionParam3Dirty();
            }
            case 3: {
                return pSCodeServerActionBase.isActionParam4Dirty();
            }
            case 4: {
                return pSCodeServerActionBase.isActionParam5Dirty();
            }
            case 5: {
                return pSCodeServerActionBase.isActionParam6Dirty();
            }
            case 6: {
                return pSCodeServerActionBase.isActionResultDirty();
            }
            case 7: {
                return pSCodeServerActionBase.isActionStateDirty();
            }
            case 8: {
                return pSCodeServerActionBase.isActionStepDirty();
            }
            case 9: {
                return pSCodeServerActionBase.isBeginTimeDirty();
            }
            case 10: {
                return pSCodeServerActionBase.isCodeServerUrlDirty();
            }
            case 11: {
                return pSCodeServerActionBase.isCreateDateDirty();
            }
            case 12: {
                return pSCodeServerActionBase.isCreateManDirty();
            }
            case 13: {
                return pSCodeServerActionBase.isEndTimeDirty();
            }
            case 14: {
                return pSCodeServerActionBase.isPasswdDirty();
            }
            case 15: {
                return pSCodeServerActionBase.isPSCodeServerActionIdDirty();
            }
            case 16: {
                return pSCodeServerActionBase.isPSCodeServerActionNameDirty();
            }
            case 17: {
                return pSCodeServerActionBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSCodeServerActionBase.isPSDSConsoleIdDirty();
            }
            case 19: {
                return pSCodeServerActionBase.isPSObjIdDirty();
            }
            case 20: {
                return pSCodeServerActionBase.isPSObjTypeDirty();
            }
            case 21: {
                return pSCodeServerActionBase.isPSTaskServerIdDirty();
            }
            case 22: {
                return pSCodeServerActionBase.isUpdateDateDirty();
            }
            case 23: {
                return pSCodeServerActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeServerActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeServerActionBase pSCodeServerActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeServerActionBase.getActionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam2", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam2()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam3", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam3()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam4", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam4()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam5", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam5()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparam6", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionParam6()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionResult()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstate", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionState()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getActionStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionstep", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getActionStep()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getCodeServerUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeserverurl", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getCodeServerUrl()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getEndTime()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPasswd()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSCodeServerActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodeserveractionid", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSCodeServerActionId()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSCodeServerActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodeserveractionname", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSCodeServerActionName()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeServerActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeServerActionBase.getJSONValue((Object)pSCodeServerActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeServerActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeServerActionBase pSCodeServerActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeServerActionBase.getActionParam() != null) {
            object = pSCodeServerActionBase.getActionParam();
            xmlNode.setAttribute(FIELD_ACTIONPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeServerActionBase.getActionParam2() != null) {
            object = pSCodeServerActionBase.getActionParam2();
            xmlNode.setAttribute(FIELD_ACTIONPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeServerActionBase.getActionParam3() != null) {
            object = pSCodeServerActionBase.getActionParam3();
            xmlNode.setAttribute(FIELD_ACTIONPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeServerActionBase.getActionParam4() != null) {
            object = pSCodeServerActionBase.getActionParam4();
            xmlNode.setAttribute(FIELD_ACTIONPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getActionParam5() != null) {
            object = pSCodeServerActionBase.getActionParam5();
            xmlNode.setAttribute(FIELD_ACTIONPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getActionParam6() != null) {
            object = pSCodeServerActionBase.getActionParam6();
            xmlNode.setAttribute(FIELD_ACTIONPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getActionResult() != null) {
            object = pSCodeServerActionBase.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getActionState() != null) {
            object = pSCodeServerActionBase.getActionState();
            xmlNode.setAttribute(FIELD_ACTIONSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getActionStep() != null) {
            object = pSCodeServerActionBase.getActionStep();
            xmlNode.setAttribute(FIELD_ACTIONSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getBeginTime() != null) {
            object = pSCodeServerActionBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getCodeServerUrl() != null) {
            object = pSCodeServerActionBase.getCodeServerUrl();
            xmlNode.setAttribute(FIELD_CODESERVERURL, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getCreateDate() != null) {
            object = pSCodeServerActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getCreateMan() != null) {
            object = pSCodeServerActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getEndTime() != null) {
            object = pSCodeServerActionBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getPasswd() != null) {
            object = pSCodeServerActionBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSCodeServerActionId() != null) {
            object = pSCodeServerActionBase.getPSCodeServerActionId();
            xmlNode.setAttribute(FIELD_PSCODESERVERACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSCodeServerActionName() != null) {
            object = pSCodeServerActionBase.getPSCodeServerActionName();
            xmlNode.setAttribute(FIELD_PSCODESERVERACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSDevSlnId() != null) {
            object = pSCodeServerActionBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSDSConsoleId() != null) {
            object = pSCodeServerActionBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSObjId() != null) {
            object = pSCodeServerActionBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSObjType() != null) {
            object = pSCodeServerActionBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getPSTaskServerId() != null) {
            object = pSCodeServerActionBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeServerActionBase.getUpdateDate() != null) {
            object = pSCodeServerActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeServerActionBase.getUpdateMan() != null) {
            object = pSCodeServerActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeServerActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeServerActionBase pSCodeServerActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeServerActionBase.isActionParamDirty() && (bl || pSCodeServerActionBase.getActionParam() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM, (Object)pSCodeServerActionBase.getActionParam());
        }
        if (pSCodeServerActionBase.isActionParam2Dirty() && (bl || pSCodeServerActionBase.getActionParam2() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM2, (Object)pSCodeServerActionBase.getActionParam2());
        }
        if (pSCodeServerActionBase.isActionParam3Dirty() && (bl || pSCodeServerActionBase.getActionParam3() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM3, (Object)pSCodeServerActionBase.getActionParam3());
        }
        if (pSCodeServerActionBase.isActionParam4Dirty() && (bl || pSCodeServerActionBase.getActionParam4() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM4, (Object)pSCodeServerActionBase.getActionParam4());
        }
        if (pSCodeServerActionBase.isActionParam5Dirty() && (bl || pSCodeServerActionBase.getActionParam5() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM5, (Object)pSCodeServerActionBase.getActionParam5());
        }
        if (pSCodeServerActionBase.isActionParam6Dirty() && (bl || pSCodeServerActionBase.getActionParam6() != null)) {
            iDataObject.set(FIELD_ACTIONPARAM6, (Object)pSCodeServerActionBase.getActionParam6());
        }
        if (pSCodeServerActionBase.isActionResultDirty() && (bl || pSCodeServerActionBase.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSCodeServerActionBase.getActionResult());
        }
        if (pSCodeServerActionBase.isActionStateDirty() && (bl || pSCodeServerActionBase.getActionState() != null)) {
            iDataObject.set(FIELD_ACTIONSTATE, (Object)pSCodeServerActionBase.getActionState());
        }
        if (pSCodeServerActionBase.isActionStepDirty() && (bl || pSCodeServerActionBase.getActionStep() != null)) {
            iDataObject.set(FIELD_ACTIONSTEP, (Object)pSCodeServerActionBase.getActionStep());
        }
        if (pSCodeServerActionBase.isBeginTimeDirty() && (bl || pSCodeServerActionBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSCodeServerActionBase.getBeginTime());
        }
        if (pSCodeServerActionBase.isCodeServerUrlDirty() && (bl || pSCodeServerActionBase.getCodeServerUrl() != null)) {
            iDataObject.set(FIELD_CODESERVERURL, (Object)pSCodeServerActionBase.getCodeServerUrl());
        }
        if (pSCodeServerActionBase.isCreateDateDirty() && (bl || pSCodeServerActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeServerActionBase.getCreateDate());
        }
        if (pSCodeServerActionBase.isCreateManDirty() && (bl || pSCodeServerActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeServerActionBase.getCreateMan());
        }
        if (pSCodeServerActionBase.isEndTimeDirty() && (bl || pSCodeServerActionBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSCodeServerActionBase.getEndTime());
        }
        if (pSCodeServerActionBase.isPasswdDirty() && (bl || pSCodeServerActionBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSCodeServerActionBase.getPasswd());
        }
        if (pSCodeServerActionBase.isPSCodeServerActionIdDirty() && (bl || pSCodeServerActionBase.getPSCodeServerActionId() != null)) {
            iDataObject.set(FIELD_PSCODESERVERACTIONID, (Object)pSCodeServerActionBase.getPSCodeServerActionId());
        }
        if (pSCodeServerActionBase.isPSCodeServerActionNameDirty() && (bl || pSCodeServerActionBase.getPSCodeServerActionName() != null)) {
            iDataObject.set(FIELD_PSCODESERVERACTIONNAME, (Object)pSCodeServerActionBase.getPSCodeServerActionName());
        }
        if (pSCodeServerActionBase.isPSDevSlnIdDirty() && (bl || pSCodeServerActionBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSCodeServerActionBase.getPSDevSlnId());
        }
        if (pSCodeServerActionBase.isPSDSConsoleIdDirty() && (bl || pSCodeServerActionBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSCodeServerActionBase.getPSDSConsoleId());
        }
        if (pSCodeServerActionBase.isPSObjIdDirty() && (bl || pSCodeServerActionBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSCodeServerActionBase.getPSObjId());
        }
        if (pSCodeServerActionBase.isPSObjTypeDirty() && (bl || pSCodeServerActionBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSCodeServerActionBase.getPSObjType());
        }
        if (pSCodeServerActionBase.isPSTaskServerIdDirty() && (bl || pSCodeServerActionBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSCodeServerActionBase.getPSTaskServerId());
        }
        if (pSCodeServerActionBase.isUpdateDateDirty() && (bl || pSCodeServerActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeServerActionBase.getUpdateDate());
        }
        if (pSCodeServerActionBase.isUpdateManDirty() && (bl || pSCodeServerActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeServerActionBase.getUpdateMan());
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
        return PSCodeServerActionBase.remove(this, n);
    }

    private static boolean remove(PSCodeServerActionBase pSCodeServerActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeServerActionBase.resetActionParam();
                return true;
            }
            case 1: {
                pSCodeServerActionBase.resetActionParam2();
                return true;
            }
            case 2: {
                pSCodeServerActionBase.resetActionParam3();
                return true;
            }
            case 3: {
                pSCodeServerActionBase.resetActionParam4();
                return true;
            }
            case 4: {
                pSCodeServerActionBase.resetActionParam5();
                return true;
            }
            case 5: {
                pSCodeServerActionBase.resetActionParam6();
                return true;
            }
            case 6: {
                pSCodeServerActionBase.resetActionResult();
                return true;
            }
            case 7: {
                pSCodeServerActionBase.resetActionState();
                return true;
            }
            case 8: {
                pSCodeServerActionBase.resetActionStep();
                return true;
            }
            case 9: {
                pSCodeServerActionBase.resetBeginTime();
                return true;
            }
            case 10: {
                pSCodeServerActionBase.resetCodeServerUrl();
                return true;
            }
            case 11: {
                pSCodeServerActionBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSCodeServerActionBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSCodeServerActionBase.resetEndTime();
                return true;
            }
            case 14: {
                pSCodeServerActionBase.resetPasswd();
                return true;
            }
            case 15: {
                pSCodeServerActionBase.resetPSCodeServerActionId();
                return true;
            }
            case 16: {
                pSCodeServerActionBase.resetPSCodeServerActionName();
                return true;
            }
            case 17: {
                pSCodeServerActionBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSCodeServerActionBase.resetPSDSConsoleId();
                return true;
            }
            case 19: {
                pSCodeServerActionBase.resetPSObjId();
                return true;
            }
            case 20: {
                pSCodeServerActionBase.resetPSObjType();
                return true;
            }
            case 21: {
                pSCodeServerActionBase.resetPSTaskServerId();
                return true;
            }
            case 22: {
                pSCodeServerActionBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSCodeServerActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCodeServerActionBase getProxyEntity() {
        return this.proxyPSCodeServerActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeServerActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeServerActionBase) {
            this.proxyPSCodeServerActionBase = (PSCodeServerActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSCodeServerActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_ACTIONSTEP, 8);
        fieldIndexMap.put(FIELD_BEGINTIME, 9);
        fieldIndexMap.put(FIELD_CODESERVERURL, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_ENDTIME, 13);
        fieldIndexMap.put(FIELD_PASSWD, 14);
        fieldIndexMap.put(FIELD_PSCODESERVERACTIONID, 15);
        fieldIndexMap.put(FIELD_PSCODESERVERACTIONNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 18);
        fieldIndexMap.put(FIELD_PSOBJID, 19);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 20);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

