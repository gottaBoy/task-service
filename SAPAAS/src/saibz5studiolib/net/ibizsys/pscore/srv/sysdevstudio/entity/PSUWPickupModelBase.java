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

public abstract class PSUWPickupModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWPickupModelBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSOBJID = "DSTPSOBJID";
    public static final String FIELD_DSTPSOBJNAME = "DSTPSOBJNAME";
    public static final String FIELD_DSTPSOBJTYPE = "DSTPSOBJTYPE";
    public static final String FIELD_ERRORINFO = "ERRORINFO";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSUWPICKUPMODELID = "PSUWPICKUPMODELID";
    public static final String FIELD_PSUWPICKUPMODELNAME = "PSUWPICKUPMODELNAME";
    public static final String FIELD_RETCODE = "RETCODE";
    public static final String FIELD_SRCPSOBJID = "SRCPSOBJID";
    public static final String FIELD_SRCPSOBJNAME = "SRCPSOBJNAME";
    public static final String FIELD_SRFNEXTFORM = "SRFNEXTFORM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDDATA = "WIZARDDATA";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM10 = "WIZARDPARAM10";
    public static final String FIELD_WIZARDPARAM11 = "WIZARDPARAM11";
    public static final String FIELD_WIZARDPARAM12 = "WIZARDPARAM12";
    public static final String FIELD_WIZARDPARAM13 = "WIZARDPARAM13";
    public static final String FIELD_WIZARDPARAM14 = "WIZARDPARAM14";
    public static final String FIELD_WIZARDPARAM15 = "WIZARDPARAM15";
    public static final String FIELD_WIZARDPARAM16 = "WIZARDPARAM16";
    public static final String FIELD_WIZARDPARAM17 = "WIZARDPARAM17";
    public static final String FIELD_WIZARDPARAM18 = "WIZARDPARAM18";
    public static final String FIELD_WIZARDPARAM19 = "WIZARDPARAM19";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM20 = "WIZARDPARAM20";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String FIELD_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String FIELD_WIZARDPARAM6 = "WIZARDPARAM6";
    public static final String FIELD_WIZARDPARAM7 = "WIZARDPARAM7";
    public static final String FIELD_WIZARDPARAM8 = "WIZARDPARAM8";
    public static final String FIELD_WIZARDPARAM9 = "WIZARDPARAM9";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DSTPSOBJID = 3;
    private static final int INDEX_DSTPSOBJNAME = 4;
    private static final int INDEX_DSTPSOBJTYPE = 5;
    private static final int INDEX_ERRORINFO = 6;
    private static final int INDEX_LOGICNAME = 7;
    private static final int INDEX_PSDATAENTITYNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_PSDYNAINSTID = 11;
    private static final int INDEX_PSMODULEID = 12;
    private static final int INDEX_PSMODULENAME = 13;
    private static final int INDEX_PSOBJTYPE = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_PSSYSTEMID = 17;
    private static final int INDEX_PSUWPICKUPMODELID = 18;
    private static final int INDEX_PSUWPICKUPMODELNAME = 19;
    private static final int INDEX_RETCODE = 20;
    private static final int INDEX_SRCPSOBJID = 21;
    private static final int INDEX_SRCPSOBJNAME = 22;
    private static final int INDEX_SRFNEXTFORM = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_WIZARDDATA = 26;
    private static final int INDEX_WIZARDMODE = 27;
    private static final int INDEX_WIZARDPARAM = 28;
    private static final int INDEX_WIZARDPARAM10 = 29;
    private static final int INDEX_WIZARDPARAM11 = 30;
    private static final int INDEX_WIZARDPARAM12 = 31;
    private static final int INDEX_WIZARDPARAM13 = 32;
    private static final int INDEX_WIZARDPARAM14 = 33;
    private static final int INDEX_WIZARDPARAM15 = 34;
    private static final int INDEX_WIZARDPARAM16 = 35;
    private static final int INDEX_WIZARDPARAM17 = 36;
    private static final int INDEX_WIZARDPARAM18 = 37;
    private static final int INDEX_WIZARDPARAM19 = 38;
    private static final int INDEX_WIZARDPARAM2 = 39;
    private static final int INDEX_WIZARDPARAM20 = 40;
    private static final int INDEX_WIZARDPARAM3 = 41;
    private static final int INDEX_WIZARDPARAM4 = 42;
    private static final int INDEX_WIZARDPARAM5 = 43;
    private static final int INDEX_WIZARDPARAM6 = 44;
    private static final int INDEX_WIZARDPARAM7 = 45;
    private static final int INDEX_WIZARDPARAM8 = 46;
    private static final int INDEX_WIZARDPARAM9 = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWPickupModelBase proxyPSUWPickupModelBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsobjidDirtyFlag = false;
    private boolean dstpsobjnameDirtyFlag = false;
    private boolean dstpsobjtypeDirtyFlag = false;
    private boolean errorinfoDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean psdataentitynameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean psuwpickupmodelidDirtyFlag = false;
    private boolean psuwpickupmodelnameDirtyFlag = false;
    private boolean retcodeDirtyFlag = false;
    private boolean srcpsobjidDirtyFlag = false;
    private boolean srcpsobjnameDirtyFlag = false;
    private boolean srfnextformDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizarddataDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam10DirtyFlag = false;
    private boolean wizardparam11DirtyFlag = false;
    private boolean wizardparam12DirtyFlag = false;
    private boolean wizardparam13DirtyFlag = false;
    private boolean wizardparam14DirtyFlag = false;
    private boolean wizardparam15DirtyFlag = false;
    private boolean wizardparam16DirtyFlag = false;
    private boolean wizardparam17DirtyFlag = false;
    private boolean wizardparam18DirtyFlag = false;
    private boolean wizardparam19DirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam20DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    private boolean wizardparam5DirtyFlag = false;
    private boolean wizardparam6DirtyFlag = false;
    private boolean wizardparam7DirtyFlag = false;
    private boolean wizardparam8DirtyFlag = false;
    private boolean wizardparam9DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstpsobjid")
    private String dstpsobjid;
    @Column(name="dstpsobjname")
    private String dstpsobjname;
    @Column(name="dstpsobjtype")
    private String dstpsobjtype;
    @Column(name="errorinfo")
    private String errorinfo;
    @Column(name="logicname")
    private String logicname;
    @Column(name="psdataentityname")
    private String psdataentityname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="psuwpickupmodelid")
    private String psuwpickupmodelid;
    @Column(name="psuwpickupmodelname")
    private String psuwpickupmodelname;
    @Column(name="retcode")
    private Integer retcode;
    @Column(name="srcpsobjid")
    private String srcpsobjid;
    @Column(name="srcpsobjname")
    private String srcpsobjname;
    @Column(name="srfnextform")
    private String srfnextform;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizarddata")
    private String wizarddata;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam10")
    private String wizardparam10;
    @Column(name="wizardparam11")
    private Integer wizardparam11;
    @Column(name="wizardparam12")
    private Integer wizardparam12;
    @Column(name="wizardparam13")
    private Integer wizardparam13;
    @Column(name="wizardparam14")
    private Integer wizardparam14;
    @Column(name="wizardparam15")
    private Integer wizardparam15;
    @Column(name="wizardparam16")
    private Integer wizardparam16;
    @Column(name="wizardparam17")
    private Double wizardparam17;
    @Column(name="wizardparam18")
    private Double wizardparam18;
    @Column(name="wizardparam19")
    private Timestamp wizardparam19;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam20")
    private Timestamp wizardparam20;
    @Column(name="wizardparam3")
    private Integer wizardparam3;
    @Column(name="wizardparam4")
    private Integer wizardparam4;
    @Column(name="wizardparam5")
    private String wizardparam5;
    @Column(name="wizardparam6")
    private String wizardparam6;
    @Column(name="wizardparam7")
    private String wizardparam7;
    @Column(name="wizardparam8")
    private String wizardparam8;
    @Column(name="wizardparam9")
    private String wizardparam9;

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

    public void setDstPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsobjid = string;
        this.dstpsobjidDirtyFlag = true;
    }

    public String getDstPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSObjId();
        }
        return this.dstpsobjid;
    }

    public boolean isDstPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSObjIdDirty();
        }
        return this.dstpsobjidDirtyFlag;
    }

    public void resetDstPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSObjId();
            return;
        }
        this.dstpsobjidDirtyFlag = false;
        this.dstpsobjid = null;
    }

    public void setDstPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsobjname = string;
        this.dstpsobjnameDirtyFlag = true;
    }

    public String getDstPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSObjName();
        }
        return this.dstpsobjname;
    }

    public boolean isDstPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSObjNameDirty();
        }
        return this.dstpsobjnameDirtyFlag;
    }

    public void resetDstPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSObjName();
            return;
        }
        this.dstpsobjnameDirtyFlag = false;
        this.dstpsobjname = null;
    }

    public void setDstPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsobjtype = string;
        this.dstpsobjtypeDirtyFlag = true;
    }

    public String getDstPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSObjType();
        }
        return this.dstpsobjtype;
    }

    public boolean isDstPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSObjTypeDirty();
        }
        return this.dstpsobjtypeDirtyFlag;
    }

    public void resetDstPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSObjType();
            return;
        }
        this.dstpsobjtypeDirtyFlag = false;
        this.dstpsobjtype = null;
    }

    public void setErrorInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorinfo = string;
        this.errorinfoDirtyFlag = true;
    }

    public String getErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    public boolean isErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    public void resetErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }
        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setPSDataEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdataentityname = string;
        this.psdataentitynameDirtyFlag = true;
    }

    public String getPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityName();
        }
        return this.psdataentityname;
    }

    public boolean isPSDataEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityNameDirty();
        }
        return this.psdataentitynameDirtyFlag;
    }

    public void resetPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityName();
            return;
        }
        this.psdataentitynameDirtyFlag = false;
        this.psdataentityname = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSUWPickupModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWPickupModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwpickupmodelid = string;
        this.psuwpickupmodelidDirtyFlag = true;
    }

    public String getPSUWPickupModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWPickupModelId();
        }
        return this.psuwpickupmodelid;
    }

    public boolean isPSUWPickupModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWPickupModelIdDirty();
        }
        return this.psuwpickupmodelidDirtyFlag;
    }

    public void resetPSUWPickupModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWPickupModelId();
            return;
        }
        this.psuwpickupmodelidDirtyFlag = false;
        this.psuwpickupmodelid = null;
    }

    public void setPSUWPickupModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWPickupModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwpickupmodelname = string;
        this.psuwpickupmodelnameDirtyFlag = true;
    }

    public String getPSUWPickupModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWPickupModelName();
        }
        return this.psuwpickupmodelname;
    }

    public boolean isPSUWPickupModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWPickupModelNameDirty();
        }
        return this.psuwpickupmodelnameDirtyFlag;
    }

    public void resetPSUWPickupModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWPickupModelName();
            return;
        }
        this.psuwpickupmodelnameDirtyFlag = false;
        this.psuwpickupmodelname = null;
    }

    public void setRetCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetCode(n);
            return;
        }
        this.retcode = n;
        this.retcodeDirtyFlag = true;
    }

    public Integer getRetCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetCode();
        }
        return this.retcode;
    }

    public boolean isRetCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetCodeDirty();
        }
        return this.retcodeDirtyFlag;
    }

    public void resetRetCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetCode();
            return;
        }
        this.retcodeDirtyFlag = false;
        this.retcode = null;
    }

    public void setSrcPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsobjid = string;
        this.srcpsobjidDirtyFlag = true;
    }

    public String getSrcPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSObjId();
        }
        return this.srcpsobjid;
    }

    public boolean isSrcPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSObjIdDirty();
        }
        return this.srcpsobjidDirtyFlag;
    }

    public void resetSrcPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSObjId();
            return;
        }
        this.srcpsobjidDirtyFlag = false;
        this.srcpsobjid = null;
    }

    public void setSrcPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsobjname = string;
        this.srcpsobjnameDirtyFlag = true;
    }

    public String getSrcPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSObjName();
        }
        return this.srcpsobjname;
    }

    public boolean isSrcPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSObjNameDirty();
        }
        return this.srcpsobjnameDirtyFlag;
    }

    public void resetSrcPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSObjName();
            return;
        }
        this.srcpsobjnameDirtyFlag = false;
        this.srcpsobjname = null;
    }

    public void setSRFNextForm(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFNextForm(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfnextform = string;
        this.srfnextformDirtyFlag = true;
    }

    public String getSRFNextForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFNextForm();
        }
        return this.srfnextform;
    }

    public boolean isSRFNextFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFNextFormDirty();
        }
        return this.srfnextformDirtyFlag;
    }

    public void resetSRFNextForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFNextForm();
            return;
        }
        this.srfnextformDirtyFlag = false;
        this.srfnextform = null;
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

    public void setWizardData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizarddata = string;
        this.wizarddataDirtyFlag = true;
    }

    public String getWizardData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardData();
        }
        return this.wizarddata;
    }

    public boolean isWizardDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardDataDirty();
        }
        return this.wizarddataDirtyFlag;
    }

    public void resetWizardData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardData();
            return;
        }
        this.wizarddataDirtyFlag = false;
        this.wizarddata = null;
    }

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam10(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam10(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam10 = string;
        this.wizardparam10DirtyFlag = true;
    }

    public String getWizardParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam10();
        }
        return this.wizardparam10;
    }

    public boolean isWizardParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam10Dirty();
        }
        return this.wizardparam10DirtyFlag;
    }

    public void resetWizardParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam10();
            return;
        }
        this.wizardparam10DirtyFlag = false;
        this.wizardparam10 = null;
    }

    public void setWizardParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam11(n);
            return;
        }
        this.wizardparam11 = n;
        this.wizardparam11DirtyFlag = true;
    }

    public Integer getWizardParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam11();
        }
        return this.wizardparam11;
    }

    public boolean isWizardParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam11Dirty();
        }
        return this.wizardparam11DirtyFlag;
    }

    public void resetWizardParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam11();
            return;
        }
        this.wizardparam11DirtyFlag = false;
        this.wizardparam11 = null;
    }

    public void setWizardParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam12(n);
            return;
        }
        this.wizardparam12 = n;
        this.wizardparam12DirtyFlag = true;
    }

    public Integer getWizardParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam12();
        }
        return this.wizardparam12;
    }

    public boolean isWizardParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam12Dirty();
        }
        return this.wizardparam12DirtyFlag;
    }

    public void resetWizardParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam12();
            return;
        }
        this.wizardparam12DirtyFlag = false;
        this.wizardparam12 = null;
    }

    public void setWizardParam13(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam13(n);
            return;
        }
        this.wizardparam13 = n;
        this.wizardparam13DirtyFlag = true;
    }

    public Integer getWizardParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam13();
        }
        return this.wizardparam13;
    }

    public boolean isWizardParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam13Dirty();
        }
        return this.wizardparam13DirtyFlag;
    }

    public void resetWizardParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam13();
            return;
        }
        this.wizardparam13DirtyFlag = false;
        this.wizardparam13 = null;
    }

    public void setWizardParam14(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam14(n);
            return;
        }
        this.wizardparam14 = n;
        this.wizardparam14DirtyFlag = true;
    }

    public Integer getWizardParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam14();
        }
        return this.wizardparam14;
    }

    public boolean isWizardParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam14Dirty();
        }
        return this.wizardparam14DirtyFlag;
    }

    public void resetWizardParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam14();
            return;
        }
        this.wizardparam14DirtyFlag = false;
        this.wizardparam14 = null;
    }

    public void setWizardParam15(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam15(n);
            return;
        }
        this.wizardparam15 = n;
        this.wizardparam15DirtyFlag = true;
    }

    public Integer getWizardParam15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam15();
        }
        return this.wizardparam15;
    }

    public boolean isWizardParam15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam15Dirty();
        }
        return this.wizardparam15DirtyFlag;
    }

    public void resetWizardParam15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam15();
            return;
        }
        this.wizardparam15DirtyFlag = false;
        this.wizardparam15 = null;
    }

    public void setWizardParam16(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam16(n);
            return;
        }
        this.wizardparam16 = n;
        this.wizardparam16DirtyFlag = true;
    }

    public Integer getWizardParam16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam16();
        }
        return this.wizardparam16;
    }

    public boolean isWizardParam16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam16Dirty();
        }
        return this.wizardparam16DirtyFlag;
    }

    public void resetWizardParam16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam16();
            return;
        }
        this.wizardparam16DirtyFlag = false;
        this.wizardparam16 = null;
    }

    public void setWizardParam17(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam17(d);
            return;
        }
        this.wizardparam17 = d;
        this.wizardparam17DirtyFlag = true;
    }

    public Double getWizardParam17() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam17();
        }
        return this.wizardparam17;
    }

    public boolean isWizardParam17Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam17Dirty();
        }
        return this.wizardparam17DirtyFlag;
    }

    public void resetWizardParam17() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam17();
            return;
        }
        this.wizardparam17DirtyFlag = false;
        this.wizardparam17 = null;
    }

    public void setWizardParam18(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam18(d);
            return;
        }
        this.wizardparam18 = d;
        this.wizardparam18DirtyFlag = true;
    }

    public Double getWizardParam18() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam18();
        }
        return this.wizardparam18;
    }

    public boolean isWizardParam18Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam18Dirty();
        }
        return this.wizardparam18DirtyFlag;
    }

    public void resetWizardParam18() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam18();
            return;
        }
        this.wizardparam18DirtyFlag = false;
        this.wizardparam18 = null;
    }

    public void setWizardParam19(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam19(timestamp);
            return;
        }
        this.wizardparam19 = timestamp;
        this.wizardparam19DirtyFlag = true;
    }

    public Timestamp getWizardParam19() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam19();
        }
        return this.wizardparam19;
    }

    public boolean isWizardParam19Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam19Dirty();
        }
        return this.wizardparam19DirtyFlag;
    }

    public void resetWizardParam19() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam19();
            return;
        }
        this.wizardparam19DirtyFlag = false;
        this.wizardparam19 = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam20(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam20(timestamp);
            return;
        }
        this.wizardparam20 = timestamp;
        this.wizardparam20DirtyFlag = true;
    }

    public Timestamp getWizardParam20() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam20();
        }
        return this.wizardparam20;
    }

    public boolean isWizardParam20Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam20Dirty();
        }
        return this.wizardparam20DirtyFlag;
    }

    public void resetWizardParam20() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam20();
            return;
        }
        this.wizardparam20DirtyFlag = false;
        this.wizardparam20 = null;
    }

    public void setWizardParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(n);
            return;
        }
        this.wizardparam3 = n;
        this.wizardparam3DirtyFlag = true;
    }

    public Integer getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(n);
            return;
        }
        this.wizardparam4 = n;
        this.wizardparam4DirtyFlag = true;
    }

    public Integer getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    public void setWizardParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam5 = string;
        this.wizardparam5DirtyFlag = true;
    }

    public String getWizardParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam5();
        }
        return this.wizardparam5;
    }

    public boolean isWizardParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam5Dirty();
        }
        return this.wizardparam5DirtyFlag;
    }

    public void resetWizardParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam5();
            return;
        }
        this.wizardparam5DirtyFlag = false;
        this.wizardparam5 = null;
    }

    public void setWizardParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam6 = string;
        this.wizardparam6DirtyFlag = true;
    }

    public String getWizardParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam6();
        }
        return this.wizardparam6;
    }

    public boolean isWizardParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam6Dirty();
        }
        return this.wizardparam6DirtyFlag;
    }

    public void resetWizardParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam6();
            return;
        }
        this.wizardparam6DirtyFlag = false;
        this.wizardparam6 = null;
    }

    public void setWizardParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam7 = string;
        this.wizardparam7DirtyFlag = true;
    }

    public String getWizardParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam7();
        }
        return this.wizardparam7;
    }

    public boolean isWizardParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam7Dirty();
        }
        return this.wizardparam7DirtyFlag;
    }

    public void resetWizardParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam7();
            return;
        }
        this.wizardparam7DirtyFlag = false;
        this.wizardparam7 = null;
    }

    public void setWizardParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam8 = string;
        this.wizardparam8DirtyFlag = true;
    }

    public String getWizardParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam8();
        }
        return this.wizardparam8;
    }

    public boolean isWizardParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam8Dirty();
        }
        return this.wizardparam8DirtyFlag;
    }

    public void resetWizardParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam8();
            return;
        }
        this.wizardparam8DirtyFlag = false;
        this.wizardparam8 = null;
    }

    public void setWizardParam9(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam9(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam9 = string;
        this.wizardparam9DirtyFlag = true;
    }

    public String getWizardParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam9();
        }
        return this.wizardparam9;
    }

    public boolean isWizardParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam9Dirty();
        }
        return this.wizardparam9DirtyFlag;
    }

    public void resetWizardParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam9();
            return;
        }
        this.wizardparam9DirtyFlag = false;
        this.wizardparam9 = null;
    }

    protected void onReset() {
        PSUWPickupModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWPickupModelBase pSUWPickupModelBase) {
        pSUWPickupModelBase.resetCodeName();
        pSUWPickupModelBase.resetCreateDate();
        pSUWPickupModelBase.resetCreateMan();
        pSUWPickupModelBase.resetDstPSObjId();
        pSUWPickupModelBase.resetDstPSObjName();
        pSUWPickupModelBase.resetDstPSObjType();
        pSUWPickupModelBase.resetErrorInfo();
        pSUWPickupModelBase.resetLogicName();
        pSUWPickupModelBase.resetPSDataEntityName();
        pSUWPickupModelBase.resetPSDEId();
        pSUWPickupModelBase.resetPSDEName();
        pSUWPickupModelBase.resetPSDynaInstId();
        pSUWPickupModelBase.resetPSModuleId();
        pSUWPickupModelBase.resetPSModuleName();
        pSUWPickupModelBase.resetPSObjType();
        pSUWPickupModelBase.resetPSSysAppId();
        pSUWPickupModelBase.resetPSSysAppName();
        pSUWPickupModelBase.resetPSSystemId();
        pSUWPickupModelBase.resetPSUWPickupModelId();
        pSUWPickupModelBase.resetPSUWPickupModelName();
        pSUWPickupModelBase.resetRetCode();
        pSUWPickupModelBase.resetSrcPSObjId();
        pSUWPickupModelBase.resetSrcPSObjName();
        pSUWPickupModelBase.resetSRFNextForm();
        pSUWPickupModelBase.resetUpdateDate();
        pSUWPickupModelBase.resetUpdateMan();
        pSUWPickupModelBase.resetWizardData();
        pSUWPickupModelBase.resetWizardMode();
        pSUWPickupModelBase.resetWizardParam();
        pSUWPickupModelBase.resetWizardParam10();
        pSUWPickupModelBase.resetWizardParam11();
        pSUWPickupModelBase.resetWizardParam12();
        pSUWPickupModelBase.resetWizardParam13();
        pSUWPickupModelBase.resetWizardParam14();
        pSUWPickupModelBase.resetWizardParam15();
        pSUWPickupModelBase.resetWizardParam16();
        pSUWPickupModelBase.resetWizardParam17();
        pSUWPickupModelBase.resetWizardParam18();
        pSUWPickupModelBase.resetWizardParam19();
        pSUWPickupModelBase.resetWizardParam2();
        pSUWPickupModelBase.resetWizardParam20();
        pSUWPickupModelBase.resetWizardParam3();
        pSUWPickupModelBase.resetWizardParam4();
        pSUWPickupModelBase.resetWizardParam5();
        pSUWPickupModelBase.resetWizardParam6();
        pSUWPickupModelBase.resetWizardParam7();
        pSUWPickupModelBase.resetWizardParam8();
        pSUWPickupModelBase.resetWizardParam9();
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
        if (!bl || this.isDstPSObjIdDirty()) {
            hashMap.put(FIELD_DSTPSOBJID, this.getDstPSObjId());
        }
        if (!bl || this.isDstPSObjNameDirty()) {
            hashMap.put(FIELD_DSTPSOBJNAME, this.getDstPSObjName());
        }
        if (!bl || this.isDstPSObjTypeDirty()) {
            hashMap.put(FIELD_DSTPSOBJTYPE, this.getDstPSObjType());
        }
        if (!bl || this.isErrorInfoDirty()) {
            hashMap.put(FIELD_ERRORINFO, this.getErrorInfo());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isPSDataEntityNameDirty()) {
            hashMap.put(FIELD_PSDATAENTITYNAME, this.getPSDataEntityName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSUWPickupModelIdDirty()) {
            hashMap.put(FIELD_PSUWPICKUPMODELID, this.getPSUWPickupModelId());
        }
        if (!bl || this.isPSUWPickupModelNameDirty()) {
            hashMap.put(FIELD_PSUWPICKUPMODELNAME, this.getPSUWPickupModelName());
        }
        if (!bl || this.isRetCodeDirty()) {
            hashMap.put(FIELD_RETCODE, this.getRetCode());
        }
        if (!bl || this.isSrcPSObjIdDirty()) {
            hashMap.put(FIELD_SRCPSOBJID, this.getSrcPSObjId());
        }
        if (!bl || this.isSrcPSObjNameDirty()) {
            hashMap.put(FIELD_SRCPSOBJNAME, this.getSrcPSObjName());
        }
        if (!bl || this.isSRFNextFormDirty()) {
            hashMap.put(FIELD_SRFNEXTFORM, this.getSRFNextForm());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWizardDataDirty()) {
            hashMap.put(FIELD_WIZARDDATA, this.getWizardData());
        }
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam10Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM10, this.getWizardParam10());
        }
        if (!bl || this.isWizardParam11Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM11, this.getWizardParam11());
        }
        if (!bl || this.isWizardParam12Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM12, this.getWizardParam12());
        }
        if (!bl || this.isWizardParam13Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM13, this.getWizardParam13());
        }
        if (!bl || this.isWizardParam14Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM14, this.getWizardParam14());
        }
        if (!bl || this.isWizardParam15Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM15, this.getWizardParam15());
        }
        if (!bl || this.isWizardParam16Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM16, this.getWizardParam16());
        }
        if (!bl || this.isWizardParam17Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM17, this.getWizardParam17());
        }
        if (!bl || this.isWizardParam18Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM18, this.getWizardParam18());
        }
        if (!bl || this.isWizardParam19Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM19, this.getWizardParam19());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam20Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM20, this.getWizardParam20());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
        }
        if (!bl || this.isWizardParam5Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM5, this.getWizardParam5());
        }
        if (!bl || this.isWizardParam6Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM6, this.getWizardParam6());
        }
        if (!bl || this.isWizardParam7Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM7, this.getWizardParam7());
        }
        if (!bl || this.isWizardParam8Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM8, this.getWizardParam8());
        }
        if (!bl || this.isWizardParam9Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM9, this.getWizardParam9());
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
        return PSUWPickupModelBase.get(this, n);
    }

    private static Object get(PSUWPickupModelBase pSUWPickupModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWPickupModelBase.getCodeName();
            }
            case 1: {
                return pSUWPickupModelBase.getCreateDate();
            }
            case 2: {
                return pSUWPickupModelBase.getCreateMan();
            }
            case 3: {
                return pSUWPickupModelBase.getDstPSObjId();
            }
            case 4: {
                return pSUWPickupModelBase.getDstPSObjName();
            }
            case 5: {
                return pSUWPickupModelBase.getDstPSObjType();
            }
            case 6: {
                return pSUWPickupModelBase.getErrorInfo();
            }
            case 7: {
                return pSUWPickupModelBase.getLogicName();
            }
            case 8: {
                return pSUWPickupModelBase.getPSDataEntityName();
            }
            case 9: {
                return pSUWPickupModelBase.getPSDEId();
            }
            case 10: {
                return pSUWPickupModelBase.getPSDEName();
            }
            case 11: {
                return pSUWPickupModelBase.getPSDynaInstId();
            }
            case 12: {
                return pSUWPickupModelBase.getPSModuleId();
            }
            case 13: {
                return pSUWPickupModelBase.getPSModuleName();
            }
            case 14: {
                return pSUWPickupModelBase.getPSObjType();
            }
            case 15: {
                return pSUWPickupModelBase.getPSSysAppId();
            }
            case 16: {
                return pSUWPickupModelBase.getPSSysAppName();
            }
            case 17: {
                return pSUWPickupModelBase.getPSSystemId();
            }
            case 18: {
                return pSUWPickupModelBase.getPSUWPickupModelId();
            }
            case 19: {
                return pSUWPickupModelBase.getPSUWPickupModelName();
            }
            case 20: {
                return pSUWPickupModelBase.getRetCode();
            }
            case 21: {
                return pSUWPickupModelBase.getSrcPSObjId();
            }
            case 22: {
                return pSUWPickupModelBase.getSrcPSObjName();
            }
            case 23: {
                return pSUWPickupModelBase.getSRFNextForm();
            }
            case 24: {
                return pSUWPickupModelBase.getUpdateDate();
            }
            case 25: {
                return pSUWPickupModelBase.getUpdateMan();
            }
            case 26: {
                return pSUWPickupModelBase.getWizardData();
            }
            case 27: {
                return pSUWPickupModelBase.getWizardMode();
            }
            case 28: {
                return pSUWPickupModelBase.getWizardParam();
            }
            case 29: {
                return pSUWPickupModelBase.getWizardParam10();
            }
            case 30: {
                return pSUWPickupModelBase.getWizardParam11();
            }
            case 31: {
                return pSUWPickupModelBase.getWizardParam12();
            }
            case 32: {
                return pSUWPickupModelBase.getWizardParam13();
            }
            case 33: {
                return pSUWPickupModelBase.getWizardParam14();
            }
            case 34: {
                return pSUWPickupModelBase.getWizardParam15();
            }
            case 35: {
                return pSUWPickupModelBase.getWizardParam16();
            }
            case 36: {
                return pSUWPickupModelBase.getWizardParam17();
            }
            case 37: {
                return pSUWPickupModelBase.getWizardParam18();
            }
            case 38: {
                return pSUWPickupModelBase.getWizardParam19();
            }
            case 39: {
                return pSUWPickupModelBase.getWizardParam2();
            }
            case 40: {
                return pSUWPickupModelBase.getWizardParam20();
            }
            case 41: {
                return pSUWPickupModelBase.getWizardParam3();
            }
            case 42: {
                return pSUWPickupModelBase.getWizardParam4();
            }
            case 43: {
                return pSUWPickupModelBase.getWizardParam5();
            }
            case 44: {
                return pSUWPickupModelBase.getWizardParam6();
            }
            case 45: {
                return pSUWPickupModelBase.getWizardParam7();
            }
            case 46: {
                return pSUWPickupModelBase.getWizardParam8();
            }
            case 47: {
                return pSUWPickupModelBase.getWizardParam9();
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
        PSUWPickupModelBase.set(this, n, object);
    }

    private static void set(PSUWPickupModelBase pSUWPickupModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWPickupModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWPickupModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWPickupModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWPickupModelBase.setDstPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWPickupModelBase.setDstPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWPickupModelBase.setDstPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWPickupModelBase.setErrorInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWPickupModelBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWPickupModelBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWPickupModelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWPickupModelBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWPickupModelBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWPickupModelBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWPickupModelBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWPickupModelBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWPickupModelBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWPickupModelBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWPickupModelBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWPickupModelBase.setPSUWPickupModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWPickupModelBase.setPSUWPickupModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWPickupModelBase.setRetCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSUWPickupModelBase.setSrcPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWPickupModelBase.setSrcPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWPickupModelBase.setSRFNextForm(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWPickupModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSUWPickupModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUWPickupModelBase.setWizardData(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSUWPickupModelBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUWPickupModelBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSUWPickupModelBase.setWizardParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUWPickupModelBase.setWizardParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSUWPickupModelBase.setWizardParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSUWPickupModelBase.setWizardParam13(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSUWPickupModelBase.setWizardParam14(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSUWPickupModelBase.setWizardParam15(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSUWPickupModelBase.setWizardParam16(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSUWPickupModelBase.setWizardParam17(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 37: {
                pSUWPickupModelBase.setWizardParam18(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 38: {
                pSUWPickupModelBase.setWizardParam19(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 39: {
                pSUWPickupModelBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSUWPickupModelBase.setWizardParam20(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSUWPickupModelBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSUWPickupModelBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSUWPickupModelBase.setWizardParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSUWPickupModelBase.setWizardParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSUWPickupModelBase.setWizardParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSUWPickupModelBase.setWizardParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSUWPickupModelBase.setWizardParam9(DataObject.getStringValue((Object)object));
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
        return PSUWPickupModelBase.isNull(this, n);
    }

    private static boolean isNull(PSUWPickupModelBase pSUWPickupModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWPickupModelBase.getCodeName() == null;
            }
            case 1: {
                return pSUWPickupModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSUWPickupModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSUWPickupModelBase.getDstPSObjId() == null;
            }
            case 4: {
                return pSUWPickupModelBase.getDstPSObjName() == null;
            }
            case 5: {
                return pSUWPickupModelBase.getDstPSObjType() == null;
            }
            case 6: {
                return pSUWPickupModelBase.getErrorInfo() == null;
            }
            case 7: {
                return pSUWPickupModelBase.getLogicName() == null;
            }
            case 8: {
                return pSUWPickupModelBase.getPSDataEntityName() == null;
            }
            case 9: {
                return pSUWPickupModelBase.getPSDEId() == null;
            }
            case 10: {
                return pSUWPickupModelBase.getPSDEName() == null;
            }
            case 11: {
                return pSUWPickupModelBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSUWPickupModelBase.getPSModuleId() == null;
            }
            case 13: {
                return pSUWPickupModelBase.getPSModuleName() == null;
            }
            case 14: {
                return pSUWPickupModelBase.getPSObjType() == null;
            }
            case 15: {
                return pSUWPickupModelBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSUWPickupModelBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSUWPickupModelBase.getPSSystemId() == null;
            }
            case 18: {
                return pSUWPickupModelBase.getPSUWPickupModelId() == null;
            }
            case 19: {
                return pSUWPickupModelBase.getPSUWPickupModelName() == null;
            }
            case 20: {
                return pSUWPickupModelBase.getRetCode() == null;
            }
            case 21: {
                return pSUWPickupModelBase.getSrcPSObjId() == null;
            }
            case 22: {
                return pSUWPickupModelBase.getSrcPSObjName() == null;
            }
            case 23: {
                return pSUWPickupModelBase.getSRFNextForm() == null;
            }
            case 24: {
                return pSUWPickupModelBase.getUpdateDate() == null;
            }
            case 25: {
                return pSUWPickupModelBase.getUpdateMan() == null;
            }
            case 26: {
                return pSUWPickupModelBase.getWizardData() == null;
            }
            case 27: {
                return pSUWPickupModelBase.getWizardMode() == null;
            }
            case 28: {
                return pSUWPickupModelBase.getWizardParam() == null;
            }
            case 29: {
                return pSUWPickupModelBase.getWizardParam10() == null;
            }
            case 30: {
                return pSUWPickupModelBase.getWizardParam11() == null;
            }
            case 31: {
                return pSUWPickupModelBase.getWizardParam12() == null;
            }
            case 32: {
                return pSUWPickupModelBase.getWizardParam13() == null;
            }
            case 33: {
                return pSUWPickupModelBase.getWizardParam14() == null;
            }
            case 34: {
                return pSUWPickupModelBase.getWizardParam15() == null;
            }
            case 35: {
                return pSUWPickupModelBase.getWizardParam16() == null;
            }
            case 36: {
                return pSUWPickupModelBase.getWizardParam17() == null;
            }
            case 37: {
                return pSUWPickupModelBase.getWizardParam18() == null;
            }
            case 38: {
                return pSUWPickupModelBase.getWizardParam19() == null;
            }
            case 39: {
                return pSUWPickupModelBase.getWizardParam2() == null;
            }
            case 40: {
                return pSUWPickupModelBase.getWizardParam20() == null;
            }
            case 41: {
                return pSUWPickupModelBase.getWizardParam3() == null;
            }
            case 42: {
                return pSUWPickupModelBase.getWizardParam4() == null;
            }
            case 43: {
                return pSUWPickupModelBase.getWizardParam5() == null;
            }
            case 44: {
                return pSUWPickupModelBase.getWizardParam6() == null;
            }
            case 45: {
                return pSUWPickupModelBase.getWizardParam7() == null;
            }
            case 46: {
                return pSUWPickupModelBase.getWizardParam8() == null;
            }
            case 47: {
                return pSUWPickupModelBase.getWizardParam9() == null;
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
        return PSUWPickupModelBase.contains(this, n);
    }

    private static boolean contains(PSUWPickupModelBase pSUWPickupModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWPickupModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSUWPickupModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSUWPickupModelBase.isCreateManDirty();
            }
            case 3: {
                return pSUWPickupModelBase.isDstPSObjIdDirty();
            }
            case 4: {
                return pSUWPickupModelBase.isDstPSObjNameDirty();
            }
            case 5: {
                return pSUWPickupModelBase.isDstPSObjTypeDirty();
            }
            case 6: {
                return pSUWPickupModelBase.isErrorInfoDirty();
            }
            case 7: {
                return pSUWPickupModelBase.isLogicNameDirty();
            }
            case 8: {
                return pSUWPickupModelBase.isPSDataEntityNameDirty();
            }
            case 9: {
                return pSUWPickupModelBase.isPSDEIdDirty();
            }
            case 10: {
                return pSUWPickupModelBase.isPSDENameDirty();
            }
            case 11: {
                return pSUWPickupModelBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSUWPickupModelBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSUWPickupModelBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSUWPickupModelBase.isPSObjTypeDirty();
            }
            case 15: {
                return pSUWPickupModelBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSUWPickupModelBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSUWPickupModelBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSUWPickupModelBase.isPSUWPickupModelIdDirty();
            }
            case 19: {
                return pSUWPickupModelBase.isPSUWPickupModelNameDirty();
            }
            case 20: {
                return pSUWPickupModelBase.isRetCodeDirty();
            }
            case 21: {
                return pSUWPickupModelBase.isSrcPSObjIdDirty();
            }
            case 22: {
                return pSUWPickupModelBase.isSrcPSObjNameDirty();
            }
            case 23: {
                return pSUWPickupModelBase.isSRFNextFormDirty();
            }
            case 24: {
                return pSUWPickupModelBase.isUpdateDateDirty();
            }
            case 25: {
                return pSUWPickupModelBase.isUpdateManDirty();
            }
            case 26: {
                return pSUWPickupModelBase.isWizardDataDirty();
            }
            case 27: {
                return pSUWPickupModelBase.isWizardModeDirty();
            }
            case 28: {
                return pSUWPickupModelBase.isWizardParamDirty();
            }
            case 29: {
                return pSUWPickupModelBase.isWizardParam10Dirty();
            }
            case 30: {
                return pSUWPickupModelBase.isWizardParam11Dirty();
            }
            case 31: {
                return pSUWPickupModelBase.isWizardParam12Dirty();
            }
            case 32: {
                return pSUWPickupModelBase.isWizardParam13Dirty();
            }
            case 33: {
                return pSUWPickupModelBase.isWizardParam14Dirty();
            }
            case 34: {
                return pSUWPickupModelBase.isWizardParam15Dirty();
            }
            case 35: {
                return pSUWPickupModelBase.isWizardParam16Dirty();
            }
            case 36: {
                return pSUWPickupModelBase.isWizardParam17Dirty();
            }
            case 37: {
                return pSUWPickupModelBase.isWizardParam18Dirty();
            }
            case 38: {
                return pSUWPickupModelBase.isWizardParam19Dirty();
            }
            case 39: {
                return pSUWPickupModelBase.isWizardParam2Dirty();
            }
            case 40: {
                return pSUWPickupModelBase.isWizardParam20Dirty();
            }
            case 41: {
                return pSUWPickupModelBase.isWizardParam3Dirty();
            }
            case 42: {
                return pSUWPickupModelBase.isWizardParam4Dirty();
            }
            case 43: {
                return pSUWPickupModelBase.isWizardParam5Dirty();
            }
            case 44: {
                return pSUWPickupModelBase.isWizardParam6Dirty();
            }
            case 45: {
                return pSUWPickupModelBase.isWizardParam7Dirty();
            }
            case 46: {
                return pSUWPickupModelBase.isWizardParam8Dirty();
            }
            case 47: {
                return pSUWPickupModelBase.isWizardParam9Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWPickupModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWPickupModelBase pSUWPickupModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWPickupModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getDstPSObjId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getDstPSObjName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjtype", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getDstPSObjType()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getErrorInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorinfo", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getErrorInfo()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getLogicName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSUWPickupModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwpickupmodelid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSUWPickupModelId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getPSUWPickupModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwpickupmodelname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getPSUWPickupModelName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getRetCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retcode", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getRetCode()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getSrcPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsobjid", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getSrcPSObjId()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getSrcPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsobjname", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getSrcPSObjName()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getSRFNextForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfnextform", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getSRFNextForm()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizarddata", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardData()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam10", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam10()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam11", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam11()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam12", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam12()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam13", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam13()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam14", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam14()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam15", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam15()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam16", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam16()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam17() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam17", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam17()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam18() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam18", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam18()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam19() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam19", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam19()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam20() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam20", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam20()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam4()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam5", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam5()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam6", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam6()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam7", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam7()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam8", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam8()), (boolean)false);
        }
        if (bl || pSUWPickupModelBase.getWizardParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam9", (Object)PSUWPickupModelBase.getJSONValue((Object)pSUWPickupModelBase.getWizardParam9()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWPickupModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWPickupModelBase pSUWPickupModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWPickupModelBase.getCodeName() != null) {
            object = pSUWPickupModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getCreateDate() != null) {
            object = pSUWPickupModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getCreateMan() != null) {
            object = pSUWPickupModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjId() != null) {
            object = pSUWPickupModelBase.getDstPSObjId();
            xmlNode.setAttribute(FIELD_DSTPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjName() != null) {
            object = pSUWPickupModelBase.getDstPSObjName();
            xmlNode.setAttribute(FIELD_DSTPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getDstPSObjType() != null) {
            object = pSUWPickupModelBase.getDstPSObjType();
            xmlNode.setAttribute(FIELD_DSTPSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getErrorInfo() != null) {
            object = pSUWPickupModelBase.getErrorInfo();
            xmlNode.setAttribute(FIELD_ERRORINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getLogicName() != null) {
            object = pSUWPickupModelBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSDataEntityName() != null) {
            object = pSUWPickupModelBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSDEId() != null) {
            object = pSUWPickupModelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSDEName() != null) {
            object = pSUWPickupModelBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSDynaInstId() != null) {
            object = pSUWPickupModelBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSModuleId() != null) {
            object = pSUWPickupModelBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSModuleName() != null) {
            object = pSUWPickupModelBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSObjType() != null) {
            object = pSUWPickupModelBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSSysAppId() != null) {
            object = pSUWPickupModelBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSSysAppName() != null) {
            object = pSUWPickupModelBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSSystemId() != null) {
            object = pSUWPickupModelBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSUWPickupModelId() != null) {
            object = pSUWPickupModelBase.getPSUWPickupModelId();
            xmlNode.setAttribute(FIELD_PSUWPICKUPMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getPSUWPickupModelName() != null) {
            object = pSUWPickupModelBase.getPSUWPickupModelName();
            xmlNode.setAttribute(FIELD_PSUWPICKUPMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getRetCode() != null) {
            object = pSUWPickupModelBase.getRetCode();
            xmlNode.setAttribute(FIELD_RETCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getSrcPSObjId() != null) {
            object = pSUWPickupModelBase.getSrcPSObjId();
            xmlNode.setAttribute(FIELD_SRCPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getSrcPSObjName() != null) {
            object = pSUWPickupModelBase.getSrcPSObjName();
            xmlNode.setAttribute(FIELD_SRCPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getSRFNextForm() != null) {
            object = pSUWPickupModelBase.getSRFNextForm();
            xmlNode.setAttribute(FIELD_SRFNEXTFORM, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getUpdateDate() != null) {
            object = pSUWPickupModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getUpdateMan() != null) {
            object = pSUWPickupModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardData() != null) {
            object = pSUWPickupModelBase.getWizardData();
            xmlNode.setAttribute(FIELD_WIZARDDATA, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardMode() != null) {
            object = pSUWPickupModelBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam() != null) {
            object = pSUWPickupModelBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam10() != null) {
            object = pSUWPickupModelBase.getWizardParam10();
            xmlNode.setAttribute(FIELD_WIZARDPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam11() != null) {
            object = pSUWPickupModelBase.getWizardParam11();
            xmlNode.setAttribute(FIELD_WIZARDPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam12() != null) {
            object = pSUWPickupModelBase.getWizardParam12();
            xmlNode.setAttribute(FIELD_WIZARDPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam13() != null) {
            object = pSUWPickupModelBase.getWizardParam13();
            xmlNode.setAttribute(FIELD_WIZARDPARAM13, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam14() != null) {
            object = pSUWPickupModelBase.getWizardParam14();
            xmlNode.setAttribute(FIELD_WIZARDPARAM14, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam15() != null) {
            object = pSUWPickupModelBase.getWizardParam15();
            xmlNode.setAttribute(FIELD_WIZARDPARAM15, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam16() != null) {
            object = pSUWPickupModelBase.getWizardParam16();
            xmlNode.setAttribute(FIELD_WIZARDPARAM16, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam17() != null) {
            object = pSUWPickupModelBase.getWizardParam17();
            xmlNode.setAttribute(FIELD_WIZARDPARAM17, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam18() != null) {
            object = pSUWPickupModelBase.getWizardParam18();
            xmlNode.setAttribute(FIELD_WIZARDPARAM18, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam19() != null) {
            object = pSUWPickupModelBase.getWizardParam19();
            xmlNode.setAttribute(FIELD_WIZARDPARAM19, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam2() != null) {
            object = pSUWPickupModelBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam20() != null) {
            object = pSUWPickupModelBase.getWizardParam20();
            xmlNode.setAttribute(FIELD_WIZARDPARAM20, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam3() != null) {
            object = pSUWPickupModelBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam4() != null) {
            object = pSUWPickupModelBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWPickupModelBase.getWizardParam5() != null) {
            object = pSUWPickupModelBase.getWizardParam5();
            xmlNode.setAttribute(FIELD_WIZARDPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam6() != null) {
            object = pSUWPickupModelBase.getWizardParam6();
            xmlNode.setAttribute(FIELD_WIZARDPARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam7() != null) {
            object = pSUWPickupModelBase.getWizardParam7();
            xmlNode.setAttribute(FIELD_WIZARDPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam8() != null) {
            object = pSUWPickupModelBase.getWizardParam8();
            xmlNode.setAttribute(FIELD_WIZARDPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSUWPickupModelBase.getWizardParam9() != null) {
            object = pSUWPickupModelBase.getWizardParam9();
            xmlNode.setAttribute(FIELD_WIZARDPARAM9, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWPickupModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWPickupModelBase pSUWPickupModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWPickupModelBase.isCodeNameDirty() && (bl || pSUWPickupModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWPickupModelBase.getCodeName());
        }
        if (pSUWPickupModelBase.isCreateDateDirty() && (bl || pSUWPickupModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWPickupModelBase.getCreateDate());
        }
        if (pSUWPickupModelBase.isCreateManDirty() && (bl || pSUWPickupModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWPickupModelBase.getCreateMan());
        }
        if (pSUWPickupModelBase.isDstPSObjIdDirty() && (bl || pSUWPickupModelBase.getDstPSObjId() != null)) {
            iDataObject.set(FIELD_DSTPSOBJID, (Object)pSUWPickupModelBase.getDstPSObjId());
        }
        if (pSUWPickupModelBase.isDstPSObjNameDirty() && (bl || pSUWPickupModelBase.getDstPSObjName() != null)) {
            iDataObject.set(FIELD_DSTPSOBJNAME, (Object)pSUWPickupModelBase.getDstPSObjName());
        }
        if (pSUWPickupModelBase.isDstPSObjTypeDirty() && (bl || pSUWPickupModelBase.getDstPSObjType() != null)) {
            iDataObject.set(FIELD_DSTPSOBJTYPE, (Object)pSUWPickupModelBase.getDstPSObjType());
        }
        if (pSUWPickupModelBase.isErrorInfoDirty() && (bl || pSUWPickupModelBase.getErrorInfo() != null)) {
            iDataObject.set(FIELD_ERRORINFO, (Object)pSUWPickupModelBase.getErrorInfo());
        }
        if (pSUWPickupModelBase.isLogicNameDirty() && (bl || pSUWPickupModelBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSUWPickupModelBase.getLogicName());
        }
        if (pSUWPickupModelBase.isPSDataEntityNameDirty() && (bl || pSUWPickupModelBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSUWPickupModelBase.getPSDataEntityName());
        }
        if (pSUWPickupModelBase.isPSDEIdDirty() && (bl || pSUWPickupModelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWPickupModelBase.getPSDEId());
        }
        if (pSUWPickupModelBase.isPSDENameDirty() && (bl || pSUWPickupModelBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWPickupModelBase.getPSDEName());
        }
        if (pSUWPickupModelBase.isPSDynaInstIdDirty() && (bl || pSUWPickupModelBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWPickupModelBase.getPSDynaInstId());
        }
        if (pSUWPickupModelBase.isPSModuleIdDirty() && (bl || pSUWPickupModelBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSUWPickupModelBase.getPSModuleId());
        }
        if (pSUWPickupModelBase.isPSModuleNameDirty() && (bl || pSUWPickupModelBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSUWPickupModelBase.getPSModuleName());
        }
        if (pSUWPickupModelBase.isPSObjTypeDirty() && (bl || pSUWPickupModelBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSUWPickupModelBase.getPSObjType());
        }
        if (pSUWPickupModelBase.isPSSysAppIdDirty() && (bl || pSUWPickupModelBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSUWPickupModelBase.getPSSysAppId());
        }
        if (pSUWPickupModelBase.isPSSysAppNameDirty() && (bl || pSUWPickupModelBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSUWPickupModelBase.getPSSysAppName());
        }
        if (pSUWPickupModelBase.isPSSystemIdDirty() && (bl || pSUWPickupModelBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSUWPickupModelBase.getPSSystemId());
        }
        if (pSUWPickupModelBase.isPSUWPickupModelIdDirty() && (bl || pSUWPickupModelBase.getPSUWPickupModelId() != null)) {
            iDataObject.set(FIELD_PSUWPICKUPMODELID, (Object)pSUWPickupModelBase.getPSUWPickupModelId());
        }
        if (pSUWPickupModelBase.isPSUWPickupModelNameDirty() && (bl || pSUWPickupModelBase.getPSUWPickupModelName() != null)) {
            iDataObject.set(FIELD_PSUWPICKUPMODELNAME, (Object)pSUWPickupModelBase.getPSUWPickupModelName());
        }
        if (pSUWPickupModelBase.isRetCodeDirty() && (bl || pSUWPickupModelBase.getRetCode() != null)) {
            iDataObject.set(FIELD_RETCODE, (Object)pSUWPickupModelBase.getRetCode());
        }
        if (pSUWPickupModelBase.isSrcPSObjIdDirty() && (bl || pSUWPickupModelBase.getSrcPSObjId() != null)) {
            iDataObject.set(FIELD_SRCPSOBJID, (Object)pSUWPickupModelBase.getSrcPSObjId());
        }
        if (pSUWPickupModelBase.isSrcPSObjNameDirty() && (bl || pSUWPickupModelBase.getSrcPSObjName() != null)) {
            iDataObject.set(FIELD_SRCPSOBJNAME, (Object)pSUWPickupModelBase.getSrcPSObjName());
        }
        if (pSUWPickupModelBase.isSRFNextFormDirty() && (bl || pSUWPickupModelBase.getSRFNextForm() != null)) {
            iDataObject.set(FIELD_SRFNEXTFORM, (Object)pSUWPickupModelBase.getSRFNextForm());
        }
        if (pSUWPickupModelBase.isUpdateDateDirty() && (bl || pSUWPickupModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWPickupModelBase.getUpdateDate());
        }
        if (pSUWPickupModelBase.isUpdateManDirty() && (bl || pSUWPickupModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWPickupModelBase.getUpdateMan());
        }
        if (pSUWPickupModelBase.isWizardDataDirty() && (bl || pSUWPickupModelBase.getWizardData() != null)) {
            iDataObject.set(FIELD_WIZARDDATA, (Object)pSUWPickupModelBase.getWizardData());
        }
        if (pSUWPickupModelBase.isWizardModeDirty() && (bl || pSUWPickupModelBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWPickupModelBase.getWizardMode());
        }
        if (pSUWPickupModelBase.isWizardParamDirty() && (bl || pSUWPickupModelBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWPickupModelBase.getWizardParam());
        }
        if (pSUWPickupModelBase.isWizardParam10Dirty() && (bl || pSUWPickupModelBase.getWizardParam10() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM10, (Object)pSUWPickupModelBase.getWizardParam10());
        }
        if (pSUWPickupModelBase.isWizardParam11Dirty() && (bl || pSUWPickupModelBase.getWizardParam11() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM11, (Object)pSUWPickupModelBase.getWizardParam11());
        }
        if (pSUWPickupModelBase.isWizardParam12Dirty() && (bl || pSUWPickupModelBase.getWizardParam12() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM12, (Object)pSUWPickupModelBase.getWizardParam12());
        }
        if (pSUWPickupModelBase.isWizardParam13Dirty() && (bl || pSUWPickupModelBase.getWizardParam13() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM13, (Object)pSUWPickupModelBase.getWizardParam13());
        }
        if (pSUWPickupModelBase.isWizardParam14Dirty() && (bl || pSUWPickupModelBase.getWizardParam14() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM14, (Object)pSUWPickupModelBase.getWizardParam14());
        }
        if (pSUWPickupModelBase.isWizardParam15Dirty() && (bl || pSUWPickupModelBase.getWizardParam15() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM15, (Object)pSUWPickupModelBase.getWizardParam15());
        }
        if (pSUWPickupModelBase.isWizardParam16Dirty() && (bl || pSUWPickupModelBase.getWizardParam16() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM16, (Object)pSUWPickupModelBase.getWizardParam16());
        }
        if (pSUWPickupModelBase.isWizardParam17Dirty() && (bl || pSUWPickupModelBase.getWizardParam17() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM17, (Object)pSUWPickupModelBase.getWizardParam17());
        }
        if (pSUWPickupModelBase.isWizardParam18Dirty() && (bl || pSUWPickupModelBase.getWizardParam18() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM18, (Object)pSUWPickupModelBase.getWizardParam18());
        }
        if (pSUWPickupModelBase.isWizardParam19Dirty() && (bl || pSUWPickupModelBase.getWizardParam19() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM19, (Object)pSUWPickupModelBase.getWizardParam19());
        }
        if (pSUWPickupModelBase.isWizardParam2Dirty() && (bl || pSUWPickupModelBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWPickupModelBase.getWizardParam2());
        }
        if (pSUWPickupModelBase.isWizardParam20Dirty() && (bl || pSUWPickupModelBase.getWizardParam20() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM20, (Object)pSUWPickupModelBase.getWizardParam20());
        }
        if (pSUWPickupModelBase.isWizardParam3Dirty() && (bl || pSUWPickupModelBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWPickupModelBase.getWizardParam3());
        }
        if (pSUWPickupModelBase.isWizardParam4Dirty() && (bl || pSUWPickupModelBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWPickupModelBase.getWizardParam4());
        }
        if (pSUWPickupModelBase.isWizardParam5Dirty() && (bl || pSUWPickupModelBase.getWizardParam5() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM5, (Object)pSUWPickupModelBase.getWizardParam5());
        }
        if (pSUWPickupModelBase.isWizardParam6Dirty() && (bl || pSUWPickupModelBase.getWizardParam6() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM6, (Object)pSUWPickupModelBase.getWizardParam6());
        }
        if (pSUWPickupModelBase.isWizardParam7Dirty() && (bl || pSUWPickupModelBase.getWizardParam7() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM7, (Object)pSUWPickupModelBase.getWizardParam7());
        }
        if (pSUWPickupModelBase.isWizardParam8Dirty() && (bl || pSUWPickupModelBase.getWizardParam8() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM8, (Object)pSUWPickupModelBase.getWizardParam8());
        }
        if (pSUWPickupModelBase.isWizardParam9Dirty() && (bl || pSUWPickupModelBase.getWizardParam9() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM9, (Object)pSUWPickupModelBase.getWizardParam9());
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
        return PSUWPickupModelBase.remove(this, n);
    }

    private static boolean remove(PSUWPickupModelBase pSUWPickupModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWPickupModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSUWPickupModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSUWPickupModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSUWPickupModelBase.resetDstPSObjId();
                return true;
            }
            case 4: {
                pSUWPickupModelBase.resetDstPSObjName();
                return true;
            }
            case 5: {
                pSUWPickupModelBase.resetDstPSObjType();
                return true;
            }
            case 6: {
                pSUWPickupModelBase.resetErrorInfo();
                return true;
            }
            case 7: {
                pSUWPickupModelBase.resetLogicName();
                return true;
            }
            case 8: {
                pSUWPickupModelBase.resetPSDataEntityName();
                return true;
            }
            case 9: {
                pSUWPickupModelBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSUWPickupModelBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSUWPickupModelBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSUWPickupModelBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSUWPickupModelBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSUWPickupModelBase.resetPSObjType();
                return true;
            }
            case 15: {
                pSUWPickupModelBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSUWPickupModelBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSUWPickupModelBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSUWPickupModelBase.resetPSUWPickupModelId();
                return true;
            }
            case 19: {
                pSUWPickupModelBase.resetPSUWPickupModelName();
                return true;
            }
            case 20: {
                pSUWPickupModelBase.resetRetCode();
                return true;
            }
            case 21: {
                pSUWPickupModelBase.resetSrcPSObjId();
                return true;
            }
            case 22: {
                pSUWPickupModelBase.resetSrcPSObjName();
                return true;
            }
            case 23: {
                pSUWPickupModelBase.resetSRFNextForm();
                return true;
            }
            case 24: {
                pSUWPickupModelBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSUWPickupModelBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSUWPickupModelBase.resetWizardData();
                return true;
            }
            case 27: {
                pSUWPickupModelBase.resetWizardMode();
                return true;
            }
            case 28: {
                pSUWPickupModelBase.resetWizardParam();
                return true;
            }
            case 29: {
                pSUWPickupModelBase.resetWizardParam10();
                return true;
            }
            case 30: {
                pSUWPickupModelBase.resetWizardParam11();
                return true;
            }
            case 31: {
                pSUWPickupModelBase.resetWizardParam12();
                return true;
            }
            case 32: {
                pSUWPickupModelBase.resetWizardParam13();
                return true;
            }
            case 33: {
                pSUWPickupModelBase.resetWizardParam14();
                return true;
            }
            case 34: {
                pSUWPickupModelBase.resetWizardParam15();
                return true;
            }
            case 35: {
                pSUWPickupModelBase.resetWizardParam16();
                return true;
            }
            case 36: {
                pSUWPickupModelBase.resetWizardParam17();
                return true;
            }
            case 37: {
                pSUWPickupModelBase.resetWizardParam18();
                return true;
            }
            case 38: {
                pSUWPickupModelBase.resetWizardParam19();
                return true;
            }
            case 39: {
                pSUWPickupModelBase.resetWizardParam2();
                return true;
            }
            case 40: {
                pSUWPickupModelBase.resetWizardParam20();
                return true;
            }
            case 41: {
                pSUWPickupModelBase.resetWizardParam3();
                return true;
            }
            case 42: {
                pSUWPickupModelBase.resetWizardParam4();
                return true;
            }
            case 43: {
                pSUWPickupModelBase.resetWizardParam5();
                return true;
            }
            case 44: {
                pSUWPickupModelBase.resetWizardParam6();
                return true;
            }
            case 45: {
                pSUWPickupModelBase.resetWizardParam7();
                return true;
            }
            case 46: {
                pSUWPickupModelBase.resetWizardParam8();
                return true;
            }
            case 47: {
                pSUWPickupModelBase.resetWizardParam9();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWPickupModelBase getProxyEntity() {
        return this.proxyPSUWPickupModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWPickupModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWPickupModelBase) {
            this.proxyPSUWPickupModelBase = (PSUWPickupModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWPickupModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DSTPSOBJID, 3);
        fieldIndexMap.put(FIELD_DSTPSOBJNAME, 4);
        fieldIndexMap.put(FIELD_DSTPSOBJTYPE, 5);
        fieldIndexMap.put(FIELD_ERRORINFO, 6);
        fieldIndexMap.put(FIELD_LOGICNAME, 7);
        fieldIndexMap.put(FIELD_PSDATAENTITYNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 11);
        fieldIndexMap.put(FIELD_PSMODULEID, 12);
        fieldIndexMap.put(FIELD_PSMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 17);
        fieldIndexMap.put(FIELD_PSUWPICKUPMODELID, 18);
        fieldIndexMap.put(FIELD_PSUWPICKUPMODELNAME, 19);
        fieldIndexMap.put(FIELD_RETCODE, 20);
        fieldIndexMap.put(FIELD_SRCPSOBJID, 21);
        fieldIndexMap.put(FIELD_SRCPSOBJNAME, 22);
        fieldIndexMap.put(FIELD_SRFNEXTFORM, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_WIZARDDATA, 26);
        fieldIndexMap.put(FIELD_WIZARDMODE, 27);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 28);
        fieldIndexMap.put(FIELD_WIZARDPARAM10, 29);
        fieldIndexMap.put(FIELD_WIZARDPARAM11, 30);
        fieldIndexMap.put(FIELD_WIZARDPARAM12, 31);
        fieldIndexMap.put(FIELD_WIZARDPARAM13, 32);
        fieldIndexMap.put(FIELD_WIZARDPARAM14, 33);
        fieldIndexMap.put(FIELD_WIZARDPARAM15, 34);
        fieldIndexMap.put(FIELD_WIZARDPARAM16, 35);
        fieldIndexMap.put(FIELD_WIZARDPARAM17, 36);
        fieldIndexMap.put(FIELD_WIZARDPARAM18, 37);
        fieldIndexMap.put(FIELD_WIZARDPARAM19, 38);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 39);
        fieldIndexMap.put(FIELD_WIZARDPARAM20, 40);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 41);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 42);
        fieldIndexMap.put(FIELD_WIZARDPARAM5, 43);
        fieldIndexMap.put(FIELD_WIZARDPARAM6, 44);
        fieldIndexMap.put(FIELD_WIZARDPARAM7, 45);
        fieldIndexMap.put(FIELD_WIZARDPARAM8, 46);
        fieldIndexMap.put(FIELD_WIZARDPARAM9, 47);
    }
}

