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

public abstract class PSUWCreateModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWCreateModelBase.class);
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
    public static final String FIELD_PSUWCREATEMODELID = "PSUWCREATEMODELID";
    public static final String FIELD_PSUWCREATEMODELNAME = "PSUWCREATEMODELNAME";
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
    private static final int INDEX_PSUWCREATEMODELID = 18;
    private static final int INDEX_PSUWCREATEMODELNAME = 19;
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
    private PSUWCreateModelBase proxyPSUWCreateModelBase = null;
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
    private boolean psuwcreatemodelidDirtyFlag = false;
    private boolean psuwcreatemodelnameDirtyFlag = false;
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
    @Column(name="psuwcreatemodelid")
    private String psuwcreatemodelid;
    @Column(name="psuwcreatemodelname")
    private String psuwcreatemodelname;
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

    public void setPSUWCreateModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatemodelid = string;
        this.psuwcreatemodelidDirtyFlag = true;
    }

    public String getPSUWCreateModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateModelId();
        }
        return this.psuwcreatemodelid;
    }

    public boolean isPSUWCreateModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateModelIdDirty();
        }
        return this.psuwcreatemodelidDirtyFlag;
    }

    public void resetPSUWCreateModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateModelId();
            return;
        }
        this.psuwcreatemodelidDirtyFlag = false;
        this.psuwcreatemodelid = null;
    }

    public void setPSUWCreateModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatemodelname = string;
        this.psuwcreatemodelnameDirtyFlag = true;
    }

    public String getPSUWCreateModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateModelName();
        }
        return this.psuwcreatemodelname;
    }

    public boolean isPSUWCreateModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateModelNameDirty();
        }
        return this.psuwcreatemodelnameDirtyFlag;
    }

    public void resetPSUWCreateModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateModelName();
            return;
        }
        this.psuwcreatemodelnameDirtyFlag = false;
        this.psuwcreatemodelname = null;
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
        PSUWCreateModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWCreateModelBase pSUWCreateModelBase) {
        pSUWCreateModelBase.resetCodeName();
        pSUWCreateModelBase.resetCreateDate();
        pSUWCreateModelBase.resetCreateMan();
        pSUWCreateModelBase.resetDstPSObjId();
        pSUWCreateModelBase.resetDstPSObjName();
        pSUWCreateModelBase.resetDstPSObjType();
        pSUWCreateModelBase.resetErrorInfo();
        pSUWCreateModelBase.resetLogicName();
        pSUWCreateModelBase.resetPSDataEntityName();
        pSUWCreateModelBase.resetPSDEId();
        pSUWCreateModelBase.resetPSDEName();
        pSUWCreateModelBase.resetPSDynaInstId();
        pSUWCreateModelBase.resetPSModuleId();
        pSUWCreateModelBase.resetPSModuleName();
        pSUWCreateModelBase.resetPSObjType();
        pSUWCreateModelBase.resetPSSysAppId();
        pSUWCreateModelBase.resetPSSysAppName();
        pSUWCreateModelBase.resetPSSystemId();
        pSUWCreateModelBase.resetPSUWCreateModelId();
        pSUWCreateModelBase.resetPSUWCreateModelName();
        pSUWCreateModelBase.resetRetCode();
        pSUWCreateModelBase.resetSrcPSObjId();
        pSUWCreateModelBase.resetSrcPSObjName();
        pSUWCreateModelBase.resetSRFNextForm();
        pSUWCreateModelBase.resetUpdateDate();
        pSUWCreateModelBase.resetUpdateMan();
        pSUWCreateModelBase.resetWizardData();
        pSUWCreateModelBase.resetWizardMode();
        pSUWCreateModelBase.resetWizardParam();
        pSUWCreateModelBase.resetWizardParam10();
        pSUWCreateModelBase.resetWizardParam11();
        pSUWCreateModelBase.resetWizardParam12();
        pSUWCreateModelBase.resetWizardParam13();
        pSUWCreateModelBase.resetWizardParam14();
        pSUWCreateModelBase.resetWizardParam15();
        pSUWCreateModelBase.resetWizardParam16();
        pSUWCreateModelBase.resetWizardParam17();
        pSUWCreateModelBase.resetWizardParam18();
        pSUWCreateModelBase.resetWizardParam19();
        pSUWCreateModelBase.resetWizardParam2();
        pSUWCreateModelBase.resetWizardParam20();
        pSUWCreateModelBase.resetWizardParam3();
        pSUWCreateModelBase.resetWizardParam4();
        pSUWCreateModelBase.resetWizardParam5();
        pSUWCreateModelBase.resetWizardParam6();
        pSUWCreateModelBase.resetWizardParam7();
        pSUWCreateModelBase.resetWizardParam8();
        pSUWCreateModelBase.resetWizardParam9();
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
        if (!bl || this.isPSUWCreateModelIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEMODELID, this.getPSUWCreateModelId());
        }
        if (!bl || this.isPSUWCreateModelNameDirty()) {
            hashMap.put(FIELD_PSUWCREATEMODELNAME, this.getPSUWCreateModelName());
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
        return PSUWCreateModelBase.get(this, n);
    }

    private static Object get(PSUWCreateModelBase pSUWCreateModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateModelBase.getCodeName();
            }
            case 1: {
                return pSUWCreateModelBase.getCreateDate();
            }
            case 2: {
                return pSUWCreateModelBase.getCreateMan();
            }
            case 3: {
                return pSUWCreateModelBase.getDstPSObjId();
            }
            case 4: {
                return pSUWCreateModelBase.getDstPSObjName();
            }
            case 5: {
                return pSUWCreateModelBase.getDstPSObjType();
            }
            case 6: {
                return pSUWCreateModelBase.getErrorInfo();
            }
            case 7: {
                return pSUWCreateModelBase.getLogicName();
            }
            case 8: {
                return pSUWCreateModelBase.getPSDataEntityName();
            }
            case 9: {
                return pSUWCreateModelBase.getPSDEId();
            }
            case 10: {
                return pSUWCreateModelBase.getPSDEName();
            }
            case 11: {
                return pSUWCreateModelBase.getPSDynaInstId();
            }
            case 12: {
                return pSUWCreateModelBase.getPSModuleId();
            }
            case 13: {
                return pSUWCreateModelBase.getPSModuleName();
            }
            case 14: {
                return pSUWCreateModelBase.getPSObjType();
            }
            case 15: {
                return pSUWCreateModelBase.getPSSysAppId();
            }
            case 16: {
                return pSUWCreateModelBase.getPSSysAppName();
            }
            case 17: {
                return pSUWCreateModelBase.getPSSystemId();
            }
            case 18: {
                return pSUWCreateModelBase.getPSUWCreateModelId();
            }
            case 19: {
                return pSUWCreateModelBase.getPSUWCreateModelName();
            }
            case 20: {
                return pSUWCreateModelBase.getRetCode();
            }
            case 21: {
                return pSUWCreateModelBase.getSrcPSObjId();
            }
            case 22: {
                return pSUWCreateModelBase.getSrcPSObjName();
            }
            case 23: {
                return pSUWCreateModelBase.getSRFNextForm();
            }
            case 24: {
                return pSUWCreateModelBase.getUpdateDate();
            }
            case 25: {
                return pSUWCreateModelBase.getUpdateMan();
            }
            case 26: {
                return pSUWCreateModelBase.getWizardData();
            }
            case 27: {
                return pSUWCreateModelBase.getWizardMode();
            }
            case 28: {
                return pSUWCreateModelBase.getWizardParam();
            }
            case 29: {
                return pSUWCreateModelBase.getWizardParam10();
            }
            case 30: {
                return pSUWCreateModelBase.getWizardParam11();
            }
            case 31: {
                return pSUWCreateModelBase.getWizardParam12();
            }
            case 32: {
                return pSUWCreateModelBase.getWizardParam13();
            }
            case 33: {
                return pSUWCreateModelBase.getWizardParam14();
            }
            case 34: {
                return pSUWCreateModelBase.getWizardParam15();
            }
            case 35: {
                return pSUWCreateModelBase.getWizardParam16();
            }
            case 36: {
                return pSUWCreateModelBase.getWizardParam17();
            }
            case 37: {
                return pSUWCreateModelBase.getWizardParam18();
            }
            case 38: {
                return pSUWCreateModelBase.getWizardParam19();
            }
            case 39: {
                return pSUWCreateModelBase.getWizardParam2();
            }
            case 40: {
                return pSUWCreateModelBase.getWizardParam20();
            }
            case 41: {
                return pSUWCreateModelBase.getWizardParam3();
            }
            case 42: {
                return pSUWCreateModelBase.getWizardParam4();
            }
            case 43: {
                return pSUWCreateModelBase.getWizardParam5();
            }
            case 44: {
                return pSUWCreateModelBase.getWizardParam6();
            }
            case 45: {
                return pSUWCreateModelBase.getWizardParam7();
            }
            case 46: {
                return pSUWCreateModelBase.getWizardParam8();
            }
            case 47: {
                return pSUWCreateModelBase.getWizardParam9();
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
        PSUWCreateModelBase.set(this, n, object);
    }

    private static void set(PSUWCreateModelBase pSUWCreateModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWCreateModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWCreateModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWCreateModelBase.setDstPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWCreateModelBase.setDstPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWCreateModelBase.setDstPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWCreateModelBase.setErrorInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWCreateModelBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWCreateModelBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWCreateModelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWCreateModelBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWCreateModelBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWCreateModelBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWCreateModelBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWCreateModelBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWCreateModelBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWCreateModelBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWCreateModelBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWCreateModelBase.setPSUWCreateModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWCreateModelBase.setPSUWCreateModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWCreateModelBase.setRetCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSUWCreateModelBase.setSrcPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWCreateModelBase.setSrcPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWCreateModelBase.setSRFNextForm(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWCreateModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSUWCreateModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUWCreateModelBase.setWizardData(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSUWCreateModelBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUWCreateModelBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSUWCreateModelBase.setWizardParam10(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUWCreateModelBase.setWizardParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSUWCreateModelBase.setWizardParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSUWCreateModelBase.setWizardParam13(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSUWCreateModelBase.setWizardParam14(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSUWCreateModelBase.setWizardParam15(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSUWCreateModelBase.setWizardParam16(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSUWCreateModelBase.setWizardParam17(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 37: {
                pSUWCreateModelBase.setWizardParam18(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 38: {
                pSUWCreateModelBase.setWizardParam19(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 39: {
                pSUWCreateModelBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSUWCreateModelBase.setWizardParam20(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSUWCreateModelBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSUWCreateModelBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSUWCreateModelBase.setWizardParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSUWCreateModelBase.setWizardParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSUWCreateModelBase.setWizardParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSUWCreateModelBase.setWizardParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSUWCreateModelBase.setWizardParam9(DataObject.getStringValue((Object)object));
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
        return PSUWCreateModelBase.isNull(this, n);
    }

    private static boolean isNull(PSUWCreateModelBase pSUWCreateModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateModelBase.getCodeName() == null;
            }
            case 1: {
                return pSUWCreateModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSUWCreateModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSUWCreateModelBase.getDstPSObjId() == null;
            }
            case 4: {
                return pSUWCreateModelBase.getDstPSObjName() == null;
            }
            case 5: {
                return pSUWCreateModelBase.getDstPSObjType() == null;
            }
            case 6: {
                return pSUWCreateModelBase.getErrorInfo() == null;
            }
            case 7: {
                return pSUWCreateModelBase.getLogicName() == null;
            }
            case 8: {
                return pSUWCreateModelBase.getPSDataEntityName() == null;
            }
            case 9: {
                return pSUWCreateModelBase.getPSDEId() == null;
            }
            case 10: {
                return pSUWCreateModelBase.getPSDEName() == null;
            }
            case 11: {
                return pSUWCreateModelBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSUWCreateModelBase.getPSModuleId() == null;
            }
            case 13: {
                return pSUWCreateModelBase.getPSModuleName() == null;
            }
            case 14: {
                return pSUWCreateModelBase.getPSObjType() == null;
            }
            case 15: {
                return pSUWCreateModelBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSUWCreateModelBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSUWCreateModelBase.getPSSystemId() == null;
            }
            case 18: {
                return pSUWCreateModelBase.getPSUWCreateModelId() == null;
            }
            case 19: {
                return pSUWCreateModelBase.getPSUWCreateModelName() == null;
            }
            case 20: {
                return pSUWCreateModelBase.getRetCode() == null;
            }
            case 21: {
                return pSUWCreateModelBase.getSrcPSObjId() == null;
            }
            case 22: {
                return pSUWCreateModelBase.getSrcPSObjName() == null;
            }
            case 23: {
                return pSUWCreateModelBase.getSRFNextForm() == null;
            }
            case 24: {
                return pSUWCreateModelBase.getUpdateDate() == null;
            }
            case 25: {
                return pSUWCreateModelBase.getUpdateMan() == null;
            }
            case 26: {
                return pSUWCreateModelBase.getWizardData() == null;
            }
            case 27: {
                return pSUWCreateModelBase.getWizardMode() == null;
            }
            case 28: {
                return pSUWCreateModelBase.getWizardParam() == null;
            }
            case 29: {
                return pSUWCreateModelBase.getWizardParam10() == null;
            }
            case 30: {
                return pSUWCreateModelBase.getWizardParam11() == null;
            }
            case 31: {
                return pSUWCreateModelBase.getWizardParam12() == null;
            }
            case 32: {
                return pSUWCreateModelBase.getWizardParam13() == null;
            }
            case 33: {
                return pSUWCreateModelBase.getWizardParam14() == null;
            }
            case 34: {
                return pSUWCreateModelBase.getWizardParam15() == null;
            }
            case 35: {
                return pSUWCreateModelBase.getWizardParam16() == null;
            }
            case 36: {
                return pSUWCreateModelBase.getWizardParam17() == null;
            }
            case 37: {
                return pSUWCreateModelBase.getWizardParam18() == null;
            }
            case 38: {
                return pSUWCreateModelBase.getWizardParam19() == null;
            }
            case 39: {
                return pSUWCreateModelBase.getWizardParam2() == null;
            }
            case 40: {
                return pSUWCreateModelBase.getWizardParam20() == null;
            }
            case 41: {
                return pSUWCreateModelBase.getWizardParam3() == null;
            }
            case 42: {
                return pSUWCreateModelBase.getWizardParam4() == null;
            }
            case 43: {
                return pSUWCreateModelBase.getWizardParam5() == null;
            }
            case 44: {
                return pSUWCreateModelBase.getWizardParam6() == null;
            }
            case 45: {
                return pSUWCreateModelBase.getWizardParam7() == null;
            }
            case 46: {
                return pSUWCreateModelBase.getWizardParam8() == null;
            }
            case 47: {
                return pSUWCreateModelBase.getWizardParam9() == null;
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
        return PSUWCreateModelBase.contains(this, n);
    }

    private static boolean contains(PSUWCreateModelBase pSUWCreateModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSUWCreateModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSUWCreateModelBase.isCreateManDirty();
            }
            case 3: {
                return pSUWCreateModelBase.isDstPSObjIdDirty();
            }
            case 4: {
                return pSUWCreateModelBase.isDstPSObjNameDirty();
            }
            case 5: {
                return pSUWCreateModelBase.isDstPSObjTypeDirty();
            }
            case 6: {
                return pSUWCreateModelBase.isErrorInfoDirty();
            }
            case 7: {
                return pSUWCreateModelBase.isLogicNameDirty();
            }
            case 8: {
                return pSUWCreateModelBase.isPSDataEntityNameDirty();
            }
            case 9: {
                return pSUWCreateModelBase.isPSDEIdDirty();
            }
            case 10: {
                return pSUWCreateModelBase.isPSDENameDirty();
            }
            case 11: {
                return pSUWCreateModelBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSUWCreateModelBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSUWCreateModelBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSUWCreateModelBase.isPSObjTypeDirty();
            }
            case 15: {
                return pSUWCreateModelBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSUWCreateModelBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSUWCreateModelBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSUWCreateModelBase.isPSUWCreateModelIdDirty();
            }
            case 19: {
                return pSUWCreateModelBase.isPSUWCreateModelNameDirty();
            }
            case 20: {
                return pSUWCreateModelBase.isRetCodeDirty();
            }
            case 21: {
                return pSUWCreateModelBase.isSrcPSObjIdDirty();
            }
            case 22: {
                return pSUWCreateModelBase.isSrcPSObjNameDirty();
            }
            case 23: {
                return pSUWCreateModelBase.isSRFNextFormDirty();
            }
            case 24: {
                return pSUWCreateModelBase.isUpdateDateDirty();
            }
            case 25: {
                return pSUWCreateModelBase.isUpdateManDirty();
            }
            case 26: {
                return pSUWCreateModelBase.isWizardDataDirty();
            }
            case 27: {
                return pSUWCreateModelBase.isWizardModeDirty();
            }
            case 28: {
                return pSUWCreateModelBase.isWizardParamDirty();
            }
            case 29: {
                return pSUWCreateModelBase.isWizardParam10Dirty();
            }
            case 30: {
                return pSUWCreateModelBase.isWizardParam11Dirty();
            }
            case 31: {
                return pSUWCreateModelBase.isWizardParam12Dirty();
            }
            case 32: {
                return pSUWCreateModelBase.isWizardParam13Dirty();
            }
            case 33: {
                return pSUWCreateModelBase.isWizardParam14Dirty();
            }
            case 34: {
                return pSUWCreateModelBase.isWizardParam15Dirty();
            }
            case 35: {
                return pSUWCreateModelBase.isWizardParam16Dirty();
            }
            case 36: {
                return pSUWCreateModelBase.isWizardParam17Dirty();
            }
            case 37: {
                return pSUWCreateModelBase.isWizardParam18Dirty();
            }
            case 38: {
                return pSUWCreateModelBase.isWizardParam19Dirty();
            }
            case 39: {
                return pSUWCreateModelBase.isWizardParam2Dirty();
            }
            case 40: {
                return pSUWCreateModelBase.isWizardParam20Dirty();
            }
            case 41: {
                return pSUWCreateModelBase.isWizardParam3Dirty();
            }
            case 42: {
                return pSUWCreateModelBase.isWizardParam4Dirty();
            }
            case 43: {
                return pSUWCreateModelBase.isWizardParam5Dirty();
            }
            case 44: {
                return pSUWCreateModelBase.isWizardParam6Dirty();
            }
            case 45: {
                return pSUWCreateModelBase.isWizardParam7Dirty();
            }
            case 46: {
                return pSUWCreateModelBase.isWizardParam8Dirty();
            }
            case 47: {
                return pSUWCreateModelBase.isWizardParam9Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWCreateModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWCreateModelBase pSUWCreateModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWCreateModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getDstPSObjId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getDstPSObjName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsobjtype", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getDstPSObjType()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getErrorInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorinfo", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getErrorInfo()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getLogicName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSUWCreateModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatemodelid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSUWCreateModelId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getPSUWCreateModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatemodelname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getPSUWCreateModelName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getRetCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retcode", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getRetCode()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getSrcPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsobjid", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getSrcPSObjId()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getSrcPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsobjname", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getSrcPSObjName()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getSRFNextForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfnextform", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getSRFNextForm()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizarddata", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardData()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam10", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam10()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam11", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam11()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam12", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam12()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam13", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam13()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam14", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam14()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam15", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam15()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam16", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam16()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam17() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam17", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam17()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam18() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam18", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam18()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam19() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam19", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam19()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam20() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam20", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam20()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam4()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam5", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam5()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam6", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam6()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam7", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam7()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam8", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam8()), (boolean)false);
        }
        if (bl || pSUWCreateModelBase.getWizardParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam9", (Object)PSUWCreateModelBase.getJSONValue((Object)pSUWCreateModelBase.getWizardParam9()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWCreateModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWCreateModelBase pSUWCreateModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWCreateModelBase.getCodeName() != null) {
            object = pSUWCreateModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getCreateDate() != null) {
            object = pSUWCreateModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getCreateMan() != null) {
            object = pSUWCreateModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjId() != null) {
            object = pSUWCreateModelBase.getDstPSObjId();
            xmlNode.setAttribute(FIELD_DSTPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjName() != null) {
            object = pSUWCreateModelBase.getDstPSObjName();
            xmlNode.setAttribute(FIELD_DSTPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getDstPSObjType() != null) {
            object = pSUWCreateModelBase.getDstPSObjType();
            xmlNode.setAttribute(FIELD_DSTPSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getErrorInfo() != null) {
            object = pSUWCreateModelBase.getErrorInfo();
            xmlNode.setAttribute(FIELD_ERRORINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getLogicName() != null) {
            object = pSUWCreateModelBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSDataEntityName() != null) {
            object = pSUWCreateModelBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSDEId() != null) {
            object = pSUWCreateModelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSDEName() != null) {
            object = pSUWCreateModelBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSDynaInstId() != null) {
            object = pSUWCreateModelBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSModuleId() != null) {
            object = pSUWCreateModelBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSModuleName() != null) {
            object = pSUWCreateModelBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSObjType() != null) {
            object = pSUWCreateModelBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSSysAppId() != null) {
            object = pSUWCreateModelBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSSysAppName() != null) {
            object = pSUWCreateModelBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSSystemId() != null) {
            object = pSUWCreateModelBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSUWCreateModelId() != null) {
            object = pSUWCreateModelBase.getPSUWCreateModelId();
            xmlNode.setAttribute(FIELD_PSUWCREATEMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getPSUWCreateModelName() != null) {
            object = pSUWCreateModelBase.getPSUWCreateModelName();
            xmlNode.setAttribute(FIELD_PSUWCREATEMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getRetCode() != null) {
            object = pSUWCreateModelBase.getRetCode();
            xmlNode.setAttribute(FIELD_RETCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getSrcPSObjId() != null) {
            object = pSUWCreateModelBase.getSrcPSObjId();
            xmlNode.setAttribute(FIELD_SRCPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getSrcPSObjName() != null) {
            object = pSUWCreateModelBase.getSrcPSObjName();
            xmlNode.setAttribute(FIELD_SRCPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getSRFNextForm() != null) {
            object = pSUWCreateModelBase.getSRFNextForm();
            xmlNode.setAttribute(FIELD_SRFNEXTFORM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getUpdateDate() != null) {
            object = pSUWCreateModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getUpdateMan() != null) {
            object = pSUWCreateModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardData() != null) {
            object = pSUWCreateModelBase.getWizardData();
            xmlNode.setAttribute(FIELD_WIZARDDATA, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardMode() != null) {
            object = pSUWCreateModelBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam() != null) {
            object = pSUWCreateModelBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam10() != null) {
            object = pSUWCreateModelBase.getWizardParam10();
            xmlNode.setAttribute(FIELD_WIZARDPARAM10, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam11() != null) {
            object = pSUWCreateModelBase.getWizardParam11();
            xmlNode.setAttribute(FIELD_WIZARDPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam12() != null) {
            object = pSUWCreateModelBase.getWizardParam12();
            xmlNode.setAttribute(FIELD_WIZARDPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam13() != null) {
            object = pSUWCreateModelBase.getWizardParam13();
            xmlNode.setAttribute(FIELD_WIZARDPARAM13, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam14() != null) {
            object = pSUWCreateModelBase.getWizardParam14();
            xmlNode.setAttribute(FIELD_WIZARDPARAM14, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam15() != null) {
            object = pSUWCreateModelBase.getWizardParam15();
            xmlNode.setAttribute(FIELD_WIZARDPARAM15, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam16() != null) {
            object = pSUWCreateModelBase.getWizardParam16();
            xmlNode.setAttribute(FIELD_WIZARDPARAM16, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam17() != null) {
            object = pSUWCreateModelBase.getWizardParam17();
            xmlNode.setAttribute(FIELD_WIZARDPARAM17, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam18() != null) {
            object = pSUWCreateModelBase.getWizardParam18();
            xmlNode.setAttribute(FIELD_WIZARDPARAM18, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam19() != null) {
            object = pSUWCreateModelBase.getWizardParam19();
            xmlNode.setAttribute(FIELD_WIZARDPARAM19, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam2() != null) {
            object = pSUWCreateModelBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam20() != null) {
            object = pSUWCreateModelBase.getWizardParam20();
            xmlNode.setAttribute(FIELD_WIZARDPARAM20, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam3() != null) {
            object = pSUWCreateModelBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam4() != null) {
            object = pSUWCreateModelBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateModelBase.getWizardParam5() != null) {
            object = pSUWCreateModelBase.getWizardParam5();
            xmlNode.setAttribute(FIELD_WIZARDPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam6() != null) {
            object = pSUWCreateModelBase.getWizardParam6();
            xmlNode.setAttribute(FIELD_WIZARDPARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam7() != null) {
            object = pSUWCreateModelBase.getWizardParam7();
            xmlNode.setAttribute(FIELD_WIZARDPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam8() != null) {
            object = pSUWCreateModelBase.getWizardParam8();
            xmlNode.setAttribute(FIELD_WIZARDPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateModelBase.getWizardParam9() != null) {
            object = pSUWCreateModelBase.getWizardParam9();
            xmlNode.setAttribute(FIELD_WIZARDPARAM9, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWCreateModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWCreateModelBase pSUWCreateModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWCreateModelBase.isCodeNameDirty() && (bl || pSUWCreateModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWCreateModelBase.getCodeName());
        }
        if (pSUWCreateModelBase.isCreateDateDirty() && (bl || pSUWCreateModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWCreateModelBase.getCreateDate());
        }
        if (pSUWCreateModelBase.isCreateManDirty() && (bl || pSUWCreateModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWCreateModelBase.getCreateMan());
        }
        if (pSUWCreateModelBase.isDstPSObjIdDirty() && (bl || pSUWCreateModelBase.getDstPSObjId() != null)) {
            iDataObject.set(FIELD_DSTPSOBJID, (Object)pSUWCreateModelBase.getDstPSObjId());
        }
        if (pSUWCreateModelBase.isDstPSObjNameDirty() && (bl || pSUWCreateModelBase.getDstPSObjName() != null)) {
            iDataObject.set(FIELD_DSTPSOBJNAME, (Object)pSUWCreateModelBase.getDstPSObjName());
        }
        if (pSUWCreateModelBase.isDstPSObjTypeDirty() && (bl || pSUWCreateModelBase.getDstPSObjType() != null)) {
            iDataObject.set(FIELD_DSTPSOBJTYPE, (Object)pSUWCreateModelBase.getDstPSObjType());
        }
        if (pSUWCreateModelBase.isErrorInfoDirty() && (bl || pSUWCreateModelBase.getErrorInfo() != null)) {
            iDataObject.set(FIELD_ERRORINFO, (Object)pSUWCreateModelBase.getErrorInfo());
        }
        if (pSUWCreateModelBase.isLogicNameDirty() && (bl || pSUWCreateModelBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSUWCreateModelBase.getLogicName());
        }
        if (pSUWCreateModelBase.isPSDataEntityNameDirty() && (bl || pSUWCreateModelBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSUWCreateModelBase.getPSDataEntityName());
        }
        if (pSUWCreateModelBase.isPSDEIdDirty() && (bl || pSUWCreateModelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWCreateModelBase.getPSDEId());
        }
        if (pSUWCreateModelBase.isPSDENameDirty() && (bl || pSUWCreateModelBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWCreateModelBase.getPSDEName());
        }
        if (pSUWCreateModelBase.isPSDynaInstIdDirty() && (bl || pSUWCreateModelBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWCreateModelBase.getPSDynaInstId());
        }
        if (pSUWCreateModelBase.isPSModuleIdDirty() && (bl || pSUWCreateModelBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSUWCreateModelBase.getPSModuleId());
        }
        if (pSUWCreateModelBase.isPSModuleNameDirty() && (bl || pSUWCreateModelBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSUWCreateModelBase.getPSModuleName());
        }
        if (pSUWCreateModelBase.isPSObjTypeDirty() && (bl || pSUWCreateModelBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSUWCreateModelBase.getPSObjType());
        }
        if (pSUWCreateModelBase.isPSSysAppIdDirty() && (bl || pSUWCreateModelBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSUWCreateModelBase.getPSSysAppId());
        }
        if (pSUWCreateModelBase.isPSSysAppNameDirty() && (bl || pSUWCreateModelBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSUWCreateModelBase.getPSSysAppName());
        }
        if (pSUWCreateModelBase.isPSSystemIdDirty() && (bl || pSUWCreateModelBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSUWCreateModelBase.getPSSystemId());
        }
        if (pSUWCreateModelBase.isPSUWCreateModelIdDirty() && (bl || pSUWCreateModelBase.getPSUWCreateModelId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEMODELID, (Object)pSUWCreateModelBase.getPSUWCreateModelId());
        }
        if (pSUWCreateModelBase.isPSUWCreateModelNameDirty() && (bl || pSUWCreateModelBase.getPSUWCreateModelName() != null)) {
            iDataObject.set(FIELD_PSUWCREATEMODELNAME, (Object)pSUWCreateModelBase.getPSUWCreateModelName());
        }
        if (pSUWCreateModelBase.isRetCodeDirty() && (bl || pSUWCreateModelBase.getRetCode() != null)) {
            iDataObject.set(FIELD_RETCODE, (Object)pSUWCreateModelBase.getRetCode());
        }
        if (pSUWCreateModelBase.isSrcPSObjIdDirty() && (bl || pSUWCreateModelBase.getSrcPSObjId() != null)) {
            iDataObject.set(FIELD_SRCPSOBJID, (Object)pSUWCreateModelBase.getSrcPSObjId());
        }
        if (pSUWCreateModelBase.isSrcPSObjNameDirty() && (bl || pSUWCreateModelBase.getSrcPSObjName() != null)) {
            iDataObject.set(FIELD_SRCPSOBJNAME, (Object)pSUWCreateModelBase.getSrcPSObjName());
        }
        if (pSUWCreateModelBase.isSRFNextFormDirty() && (bl || pSUWCreateModelBase.getSRFNextForm() != null)) {
            iDataObject.set(FIELD_SRFNEXTFORM, (Object)pSUWCreateModelBase.getSRFNextForm());
        }
        if (pSUWCreateModelBase.isUpdateDateDirty() && (bl || pSUWCreateModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWCreateModelBase.getUpdateDate());
        }
        if (pSUWCreateModelBase.isUpdateManDirty() && (bl || pSUWCreateModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWCreateModelBase.getUpdateMan());
        }
        if (pSUWCreateModelBase.isWizardDataDirty() && (bl || pSUWCreateModelBase.getWizardData() != null)) {
            iDataObject.set(FIELD_WIZARDDATA, (Object)pSUWCreateModelBase.getWizardData());
        }
        if (pSUWCreateModelBase.isWizardModeDirty() && (bl || pSUWCreateModelBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWCreateModelBase.getWizardMode());
        }
        if (pSUWCreateModelBase.isWizardParamDirty() && (bl || pSUWCreateModelBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWCreateModelBase.getWizardParam());
        }
        if (pSUWCreateModelBase.isWizardParam10Dirty() && (bl || pSUWCreateModelBase.getWizardParam10() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM10, (Object)pSUWCreateModelBase.getWizardParam10());
        }
        if (pSUWCreateModelBase.isWizardParam11Dirty() && (bl || pSUWCreateModelBase.getWizardParam11() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM11, (Object)pSUWCreateModelBase.getWizardParam11());
        }
        if (pSUWCreateModelBase.isWizardParam12Dirty() && (bl || pSUWCreateModelBase.getWizardParam12() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM12, (Object)pSUWCreateModelBase.getWizardParam12());
        }
        if (pSUWCreateModelBase.isWizardParam13Dirty() && (bl || pSUWCreateModelBase.getWizardParam13() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM13, (Object)pSUWCreateModelBase.getWizardParam13());
        }
        if (pSUWCreateModelBase.isWizardParam14Dirty() && (bl || pSUWCreateModelBase.getWizardParam14() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM14, (Object)pSUWCreateModelBase.getWizardParam14());
        }
        if (pSUWCreateModelBase.isWizardParam15Dirty() && (bl || pSUWCreateModelBase.getWizardParam15() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM15, (Object)pSUWCreateModelBase.getWizardParam15());
        }
        if (pSUWCreateModelBase.isWizardParam16Dirty() && (bl || pSUWCreateModelBase.getWizardParam16() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM16, (Object)pSUWCreateModelBase.getWizardParam16());
        }
        if (pSUWCreateModelBase.isWizardParam17Dirty() && (bl || pSUWCreateModelBase.getWizardParam17() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM17, (Object)pSUWCreateModelBase.getWizardParam17());
        }
        if (pSUWCreateModelBase.isWizardParam18Dirty() && (bl || pSUWCreateModelBase.getWizardParam18() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM18, (Object)pSUWCreateModelBase.getWizardParam18());
        }
        if (pSUWCreateModelBase.isWizardParam19Dirty() && (bl || pSUWCreateModelBase.getWizardParam19() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM19, (Object)pSUWCreateModelBase.getWizardParam19());
        }
        if (pSUWCreateModelBase.isWizardParam2Dirty() && (bl || pSUWCreateModelBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWCreateModelBase.getWizardParam2());
        }
        if (pSUWCreateModelBase.isWizardParam20Dirty() && (bl || pSUWCreateModelBase.getWizardParam20() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM20, (Object)pSUWCreateModelBase.getWizardParam20());
        }
        if (pSUWCreateModelBase.isWizardParam3Dirty() && (bl || pSUWCreateModelBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWCreateModelBase.getWizardParam3());
        }
        if (pSUWCreateModelBase.isWizardParam4Dirty() && (bl || pSUWCreateModelBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWCreateModelBase.getWizardParam4());
        }
        if (pSUWCreateModelBase.isWizardParam5Dirty() && (bl || pSUWCreateModelBase.getWizardParam5() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM5, (Object)pSUWCreateModelBase.getWizardParam5());
        }
        if (pSUWCreateModelBase.isWizardParam6Dirty() && (bl || pSUWCreateModelBase.getWizardParam6() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM6, (Object)pSUWCreateModelBase.getWizardParam6());
        }
        if (pSUWCreateModelBase.isWizardParam7Dirty() && (bl || pSUWCreateModelBase.getWizardParam7() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM7, (Object)pSUWCreateModelBase.getWizardParam7());
        }
        if (pSUWCreateModelBase.isWizardParam8Dirty() && (bl || pSUWCreateModelBase.getWizardParam8() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM8, (Object)pSUWCreateModelBase.getWizardParam8());
        }
        if (pSUWCreateModelBase.isWizardParam9Dirty() && (bl || pSUWCreateModelBase.getWizardParam9() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM9, (Object)pSUWCreateModelBase.getWizardParam9());
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
        return PSUWCreateModelBase.remove(this, n);
    }

    private static boolean remove(PSUWCreateModelBase pSUWCreateModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSUWCreateModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSUWCreateModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSUWCreateModelBase.resetDstPSObjId();
                return true;
            }
            case 4: {
                pSUWCreateModelBase.resetDstPSObjName();
                return true;
            }
            case 5: {
                pSUWCreateModelBase.resetDstPSObjType();
                return true;
            }
            case 6: {
                pSUWCreateModelBase.resetErrorInfo();
                return true;
            }
            case 7: {
                pSUWCreateModelBase.resetLogicName();
                return true;
            }
            case 8: {
                pSUWCreateModelBase.resetPSDataEntityName();
                return true;
            }
            case 9: {
                pSUWCreateModelBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSUWCreateModelBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSUWCreateModelBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSUWCreateModelBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSUWCreateModelBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSUWCreateModelBase.resetPSObjType();
                return true;
            }
            case 15: {
                pSUWCreateModelBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSUWCreateModelBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSUWCreateModelBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSUWCreateModelBase.resetPSUWCreateModelId();
                return true;
            }
            case 19: {
                pSUWCreateModelBase.resetPSUWCreateModelName();
                return true;
            }
            case 20: {
                pSUWCreateModelBase.resetRetCode();
                return true;
            }
            case 21: {
                pSUWCreateModelBase.resetSrcPSObjId();
                return true;
            }
            case 22: {
                pSUWCreateModelBase.resetSrcPSObjName();
                return true;
            }
            case 23: {
                pSUWCreateModelBase.resetSRFNextForm();
                return true;
            }
            case 24: {
                pSUWCreateModelBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSUWCreateModelBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSUWCreateModelBase.resetWizardData();
                return true;
            }
            case 27: {
                pSUWCreateModelBase.resetWizardMode();
                return true;
            }
            case 28: {
                pSUWCreateModelBase.resetWizardParam();
                return true;
            }
            case 29: {
                pSUWCreateModelBase.resetWizardParam10();
                return true;
            }
            case 30: {
                pSUWCreateModelBase.resetWizardParam11();
                return true;
            }
            case 31: {
                pSUWCreateModelBase.resetWizardParam12();
                return true;
            }
            case 32: {
                pSUWCreateModelBase.resetWizardParam13();
                return true;
            }
            case 33: {
                pSUWCreateModelBase.resetWizardParam14();
                return true;
            }
            case 34: {
                pSUWCreateModelBase.resetWizardParam15();
                return true;
            }
            case 35: {
                pSUWCreateModelBase.resetWizardParam16();
                return true;
            }
            case 36: {
                pSUWCreateModelBase.resetWizardParam17();
                return true;
            }
            case 37: {
                pSUWCreateModelBase.resetWizardParam18();
                return true;
            }
            case 38: {
                pSUWCreateModelBase.resetWizardParam19();
                return true;
            }
            case 39: {
                pSUWCreateModelBase.resetWizardParam2();
                return true;
            }
            case 40: {
                pSUWCreateModelBase.resetWizardParam20();
                return true;
            }
            case 41: {
                pSUWCreateModelBase.resetWizardParam3();
                return true;
            }
            case 42: {
                pSUWCreateModelBase.resetWizardParam4();
                return true;
            }
            case 43: {
                pSUWCreateModelBase.resetWizardParam5();
                return true;
            }
            case 44: {
                pSUWCreateModelBase.resetWizardParam6();
                return true;
            }
            case 45: {
                pSUWCreateModelBase.resetWizardParam7();
                return true;
            }
            case 46: {
                pSUWCreateModelBase.resetWizardParam8();
                return true;
            }
            case 47: {
                pSUWCreateModelBase.resetWizardParam9();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWCreateModelBase getProxyEntity() {
        return this.proxyPSUWCreateModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWCreateModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWCreateModelBase) {
            this.proxyPSUWCreateModelBase = (PSUWCreateModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSUWCREATEMODELID, 18);
        fieldIndexMap.put(FIELD_PSUWCREATEMODELNAME, 19);
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

