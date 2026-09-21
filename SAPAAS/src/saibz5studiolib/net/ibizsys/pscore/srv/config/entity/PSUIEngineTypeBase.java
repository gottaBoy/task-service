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
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSUIEngineTypeParam;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeParamService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUIEngineTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUIEngineTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENGINECAT = "ENGINECAT";
    public static final String FIELD_ENGINEOBJ = "ENGINEOBJ";
    public static final String FIELD_ENGINEPARAM10FLAG = "ENGINEPARAM10FLAG";
    public static final String FIELD_ENGINEPARAM10LABEL = "ENGINEPARAM10LABEL";
    public static final String FIELD_ENGINEPARAM2FLAG = "ENGINEPARAM2FLAG";
    public static final String FIELD_ENGINEPARAM2LABEL = "ENGINEPARAM2LABEL";
    public static final String FIELD_ENGINEPARAM3FLAG = "ENGINEPARAM3FLAG";
    public static final String FIELD_ENGINEPARAM3LABEL = "ENGINEPARAM3LABEL";
    public static final String FIELD_ENGINEPARAM4FLAG = "ENGINEPARAM4FLAG";
    public static final String FIELD_ENGINEPARAM4LABEL = "ENGINEPARAM4LABEL";
    public static final String FIELD_ENGINEPARAM5FLAG = "ENGINEPARAM5FLAG";
    public static final String FIELD_ENGINEPARAM5LABEL = "ENGINEPARAM5LABEL";
    public static final String FIELD_ENGINEPARAM6FLAG = "ENGINEPARAM6FLAG";
    public static final String FIELD_ENGINEPARAM6LABEL = "ENGINEPARAM6LABEL";
    public static final String FIELD_ENGINEPARAM7FLAG = "ENGINEPARAM7FLAG";
    public static final String FIELD_ENGINEPARAM7LABEL = "ENGINEPARAM7LABEL";
    public static final String FIELD_ENGINEPARAM8FLAG = "ENGINEPARAM8FLAG";
    public static final String FIELD_ENGINEPARAM8LABEL = "ENGINEPARAM8LABEL";
    public static final String FIELD_ENGINEPARAM9FLAG = "ENGINEPARAM9FLAG";
    public static final String FIELD_ENGINEPARAM9LABEL = "ENGINEPARAM9LABEL";
    public static final String FIELD_ENGINEPARAMFLAG = "ENGINEPARAMFLAG";
    public static final String FIELD_ENGINEPARAMLABEL = "ENGINEPARAMLABEL";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NO2UICTRLFLAG = "NO2UICTRLFLAG";
    public static final String FIELD_NO2UICTRLLABEL = "NO2UICTRLLABEL";
    public static final String FIELD_NO2UILOGICFLAG = "NO2UILOGICFLAG";
    public static final String FIELD_NO2UILOGICLABEL = "NO2UILOGICLABEL";
    public static final String FIELD_NO3UICTRLFLAG = "NO3UICTRLFLAG";
    public static final String FIELD_NO3UICTRLLABEL = "NO3UICTRLLABEL";
    public static final String FIELD_NO3UILOGICFLAG = "NO3UILOGICFLAG";
    public static final String FIELD_NO3UILOGICLABEL = "NO3UILOGICLABEL";
    public static final String FIELD_NO4UICTRLFLAG = "NO4UICTRLFLAG";
    public static final String FIELD_NO4UICTRLLABEL = "NO4UICTRLLABEL";
    public static final String FIELD_NO4UILOGICFLAG = "NO4UILOGICFLAG";
    public static final String FIELD_NO4UILOGICLABEL = "NO4UILOGICLABEL";
    public static final String FIELD_PANELENGINEOBJ = "PANELENGINEOBJ";
    public static final String FIELD_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String FIELD_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UICTRLFLAG = "UICTRLFLAG";
    public static final String FIELD_UICTRLLABEL = "UICTRLLABEL";
    public static final String FIELD_UILOGICFLAG = "UILOGICFLAG";
    public static final String FIELD_UILOGICLABEL = "UILOGICLABEL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENGINECAT = 2;
    private static final int INDEX_ENGINEOBJ = 3;
    private static final int INDEX_ENGINEPARAM10FLAG = 4;
    private static final int INDEX_ENGINEPARAM10LABEL = 5;
    private static final int INDEX_ENGINEPARAM2FLAG = 6;
    private static final int INDEX_ENGINEPARAM2LABEL = 7;
    private static final int INDEX_ENGINEPARAM3FLAG = 8;
    private static final int INDEX_ENGINEPARAM3LABEL = 9;
    private static final int INDEX_ENGINEPARAM4FLAG = 10;
    private static final int INDEX_ENGINEPARAM4LABEL = 11;
    private static final int INDEX_ENGINEPARAM5FLAG = 12;
    private static final int INDEX_ENGINEPARAM5LABEL = 13;
    private static final int INDEX_ENGINEPARAM6FLAG = 14;
    private static final int INDEX_ENGINEPARAM6LABEL = 15;
    private static final int INDEX_ENGINEPARAM7FLAG = 16;
    private static final int INDEX_ENGINEPARAM7LABEL = 17;
    private static final int INDEX_ENGINEPARAM8FLAG = 18;
    private static final int INDEX_ENGINEPARAM8LABEL = 19;
    private static final int INDEX_ENGINEPARAM9FLAG = 20;
    private static final int INDEX_ENGINEPARAM9LABEL = 21;
    private static final int INDEX_ENGINEPARAMFLAG = 22;
    private static final int INDEX_ENGINEPARAMLABEL = 23;
    private static final int INDEX_LOGICNAME = 24;
    private static final int INDEX_MEMO = 25;
    private static final int INDEX_NO2UICTRLFLAG = 26;
    private static final int INDEX_NO2UICTRLLABEL = 27;
    private static final int INDEX_NO2UILOGICFLAG = 28;
    private static final int INDEX_NO2UILOGICLABEL = 29;
    private static final int INDEX_NO3UICTRLFLAG = 30;
    private static final int INDEX_NO3UICTRLLABEL = 31;
    private static final int INDEX_NO3UILOGICFLAG = 32;
    private static final int INDEX_NO3UILOGICLABEL = 33;
    private static final int INDEX_NO4UICTRLFLAG = 34;
    private static final int INDEX_NO4UICTRLLABEL = 35;
    private static final int INDEX_NO4UILOGICFLAG = 36;
    private static final int INDEX_NO4UILOGICLABEL = 37;
    private static final int INDEX_PANELENGINEOBJ = 38;
    private static final int INDEX_PSUIENGINETYPEID = 39;
    private static final int INDEX_PSUIENGINETYPENAME = 40;
    private static final int INDEX_TYPECODE = 41;
    private static final int INDEX_TYPEOBJ = 42;
    private static final int INDEX_UICTRLFLAG = 43;
    private static final int INDEX_UICTRLLABEL = 44;
    private static final int INDEX_UILOGICFLAG = 45;
    private static final int INDEX_UILOGICLABEL = 46;
    private static final int INDEX_UPDATEDATE = 47;
    private static final int INDEX_UPDATEMAN = 48;
    private static final int INDEX_UTILPARAMS = 49;
    private static final int INDEX_VALIDFLAG = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUIEngineTypeBase proxyPSUIEngineTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enginecatDirtyFlag = false;
    private boolean engineobjDirtyFlag = false;
    private boolean engineparam10flagDirtyFlag = false;
    private boolean engineparam10labelDirtyFlag = false;
    private boolean engineparam2flagDirtyFlag = false;
    private boolean engineparam2labelDirtyFlag = false;
    private boolean engineparam3flagDirtyFlag = false;
    private boolean engineparam3labelDirtyFlag = false;
    private boolean engineparam4flagDirtyFlag = false;
    private boolean engineparam4labelDirtyFlag = false;
    private boolean engineparam5flagDirtyFlag = false;
    private boolean engineparam5labelDirtyFlag = false;
    private boolean engineparam6flagDirtyFlag = false;
    private boolean engineparam6labelDirtyFlag = false;
    private boolean engineparam7flagDirtyFlag = false;
    private boolean engineparam7labelDirtyFlag = false;
    private boolean engineparam8flagDirtyFlag = false;
    private boolean engineparam8labelDirtyFlag = false;
    private boolean engineparam9flagDirtyFlag = false;
    private boolean engineparam9labelDirtyFlag = false;
    private boolean engineparamflagDirtyFlag = false;
    private boolean engineparamlabelDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean no2uictrlflagDirtyFlag = false;
    private boolean no2uictrllabelDirtyFlag = false;
    private boolean no2uilogicflagDirtyFlag = false;
    private boolean no2uilogiclabelDirtyFlag = false;
    private boolean no3uictrlflagDirtyFlag = false;
    private boolean no3uictrllabelDirtyFlag = false;
    private boolean no3uilogicflagDirtyFlag = false;
    private boolean no3uilogiclabelDirtyFlag = false;
    private boolean no4uictrlflagDirtyFlag = false;
    private boolean no4uictrllabelDirtyFlag = false;
    private boolean no4uilogicflagDirtyFlag = false;
    private boolean no4uilogiclabelDirtyFlag = false;
    private boolean panelengineobjDirtyFlag = false;
    private boolean psuienginetypeidDirtyFlag = false;
    private boolean psuienginetypenameDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean uictrlflagDirtyFlag = false;
    private boolean uictrllabelDirtyFlag = false;
    private boolean uilogicflagDirtyFlag = false;
    private boolean uilogiclabelDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enginecat")
    private String enginecat;
    @Column(name="engineobj")
    private String engineobj;
    @Column(name="engineparam10flag")
    private Integer engineparam10flag;
    @Column(name="engineparam10label")
    private String engineparam10label;
    @Column(name="engineparam2flag")
    private Integer engineparam2flag;
    @Column(name="engineparam2label")
    private String engineparam2label;
    @Column(name="engineparam3flag")
    private Integer engineparam3flag;
    @Column(name="engineparam3label")
    private String engineparam3label;
    @Column(name="engineparam4flag")
    private Integer engineparam4flag;
    @Column(name="engineparam4label")
    private String engineparam4label;
    @Column(name="engineparam5flag")
    private Integer engineparam5flag;
    @Column(name="engineparam5label")
    private String engineparam5label;
    @Column(name="engineparam6flag")
    private Integer engineparam6flag;
    @Column(name="engineparam6label")
    private String engineparam6label;
    @Column(name="engineparam7flag")
    private Integer engineparam7flag;
    @Column(name="engineparam7label")
    private String engineparam7label;
    @Column(name="engineparam8flag")
    private Integer engineparam8flag;
    @Column(name="engineparam8label")
    private String engineparam8label;
    @Column(name="engineparam9flag")
    private Integer engineparam9flag;
    @Column(name="engineparam9label")
    private String engineparam9label;
    @Column(name="engineparamflag")
    private Integer engineparamflag;
    @Column(name="engineparamlabel")
    private String engineparamlabel;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="no2uictrlflag")
    private Integer no2uictrlflag;
    @Column(name="no2uictrllabel")
    private String no2uictrllabel;
    @Column(name="no2uilogicflag")
    private Integer no2uilogicflag;
    @Column(name="no2uilogiclabel")
    private String no2uilogiclabel;
    @Column(name="no3uictrlflag")
    private Integer no3uictrlflag;
    @Column(name="no3uictrllabel")
    private String no3uictrllabel;
    @Column(name="no3uilogicflag")
    private Integer no3uilogicflag;
    @Column(name="no3uilogiclabel")
    private String no3uilogiclabel;
    @Column(name="no4uictrlflag")
    private Integer no4uictrlflag;
    @Column(name="no4uictrllabel")
    private String no4uictrllabel;
    @Column(name="no4uilogicflag")
    private Integer no4uilogicflag;
    @Column(name="no4uilogiclabel")
    private String no4uilogiclabel;
    @Column(name="panelengineobj")
    private String panelengineobj;
    @Column(name="psuienginetypeid")
    private String psuienginetypeid;
    @Column(name="psuienginetypename")
    private String psuienginetypename;
    @Column(name="typecode")
    private String typecode;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="uictrlflag")
    private Integer uictrlflag;
    @Column(name="uictrllabel")
    private String uictrllabel;
    @Column(name="uilogicflag")
    private Integer uilogicflag;
    @Column(name="uilogiclabel")
    private String uilogiclabel;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSUIEngineTypeParamsLock = new Integer(1);
    private ArrayList<PSUIEngineTypeParam> psuienginetypeparams = null;

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

    public void setEngineCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enginecat = string;
        this.enginecatDirtyFlag = true;
    }

    public String getEngineCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineCat();
        }
        return this.enginecat;
    }

    public boolean isEngineCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineCatDirty();
        }
        return this.enginecatDirtyFlag;
    }

    public void resetEngineCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineCat();
            return;
        }
        this.enginecatDirtyFlag = false;
        this.enginecat = null;
    }

    public void setEngineObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineobj = string;
        this.engineobjDirtyFlag = true;
    }

    public String getEngineObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineObj();
        }
        return this.engineobj;
    }

    public boolean isEngineObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineObjDirty();
        }
        return this.engineobjDirtyFlag;
    }

    public void resetEngineObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineObj();
            return;
        }
        this.engineobjDirtyFlag = false;
        this.engineobj = null;
    }

    public void setEngineParam10Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam10Flag(n);
            return;
        }
        this.engineparam10flag = n;
        this.engineparam10flagDirtyFlag = true;
    }

    public Integer getEngineParam10Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam10Flag();
        }
        return this.engineparam10flag;
    }

    public boolean isEngineParam10FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam10FlagDirty();
        }
        return this.engineparam10flagDirtyFlag;
    }

    public void resetEngineParam10Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam10Flag();
            return;
        }
        this.engineparam10flagDirtyFlag = false;
        this.engineparam10flag = null;
    }

    public void setEngineParam10Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam10Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam10label = string;
        this.engineparam10labelDirtyFlag = true;
    }

    public String getEngineParam10Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam10Label();
        }
        return this.engineparam10label;
    }

    public boolean isEngineParam10LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam10LabelDirty();
        }
        return this.engineparam10labelDirtyFlag;
    }

    public void resetEngineParam10Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam10Label();
            return;
        }
        this.engineparam10labelDirtyFlag = false;
        this.engineparam10label = null;
    }

    public void setEngineParam2Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam2Flag(n);
            return;
        }
        this.engineparam2flag = n;
        this.engineparam2flagDirtyFlag = true;
    }

    public Integer getEngineParam2Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam2Flag();
        }
        return this.engineparam2flag;
    }

    public boolean isEngineParam2FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam2FlagDirty();
        }
        return this.engineparam2flagDirtyFlag;
    }

    public void resetEngineParam2Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam2Flag();
            return;
        }
        this.engineparam2flagDirtyFlag = false;
        this.engineparam2flag = null;
    }

    public void setEngineParam2Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam2Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam2label = string;
        this.engineparam2labelDirtyFlag = true;
    }

    public String getEngineParam2Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam2Label();
        }
        return this.engineparam2label;
    }

    public boolean isEngineParam2LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam2LabelDirty();
        }
        return this.engineparam2labelDirtyFlag;
    }

    public void resetEngineParam2Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam2Label();
            return;
        }
        this.engineparam2labelDirtyFlag = false;
        this.engineparam2label = null;
    }

    public void setEngineParam3Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam3Flag(n);
            return;
        }
        this.engineparam3flag = n;
        this.engineparam3flagDirtyFlag = true;
    }

    public Integer getEngineParam3Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam3Flag();
        }
        return this.engineparam3flag;
    }

    public boolean isEngineParam3FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam3FlagDirty();
        }
        return this.engineparam3flagDirtyFlag;
    }

    public void resetEngineParam3Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam3Flag();
            return;
        }
        this.engineparam3flagDirtyFlag = false;
        this.engineparam3flag = null;
    }

    public void setEngineParam3Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam3Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam3label = string;
        this.engineparam3labelDirtyFlag = true;
    }

    public String getEngineParam3Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam3Label();
        }
        return this.engineparam3label;
    }

    public boolean isEngineParam3LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam3LabelDirty();
        }
        return this.engineparam3labelDirtyFlag;
    }

    public void resetEngineParam3Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam3Label();
            return;
        }
        this.engineparam3labelDirtyFlag = false;
        this.engineparam3label = null;
    }

    public void setEngineParam4Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam4Flag(n);
            return;
        }
        this.engineparam4flag = n;
        this.engineparam4flagDirtyFlag = true;
    }

    public Integer getEngineParam4Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam4Flag();
        }
        return this.engineparam4flag;
    }

    public boolean isEngineParam4FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam4FlagDirty();
        }
        return this.engineparam4flagDirtyFlag;
    }

    public void resetEngineParam4Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam4Flag();
            return;
        }
        this.engineparam4flagDirtyFlag = false;
        this.engineparam4flag = null;
    }

    public void setEngineParam4Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam4Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam4label = string;
        this.engineparam4labelDirtyFlag = true;
    }

    public String getEngineParam4Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam4Label();
        }
        return this.engineparam4label;
    }

    public boolean isEngineParam4LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam4LabelDirty();
        }
        return this.engineparam4labelDirtyFlag;
    }

    public void resetEngineParam4Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam4Label();
            return;
        }
        this.engineparam4labelDirtyFlag = false;
        this.engineparam4label = null;
    }

    public void setEngineParam5Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam5Flag(n);
            return;
        }
        this.engineparam5flag = n;
        this.engineparam5flagDirtyFlag = true;
    }

    public Integer getEngineParam5Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam5Flag();
        }
        return this.engineparam5flag;
    }

    public boolean isEngineParam5FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam5FlagDirty();
        }
        return this.engineparam5flagDirtyFlag;
    }

    public void resetEngineParam5Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam5Flag();
            return;
        }
        this.engineparam5flagDirtyFlag = false;
        this.engineparam5flag = null;
    }

    public void setEngineParam5Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam5Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam5label = string;
        this.engineparam5labelDirtyFlag = true;
    }

    public String getEngineParam5Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam5Label();
        }
        return this.engineparam5label;
    }

    public boolean isEngineParam5LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam5LabelDirty();
        }
        return this.engineparam5labelDirtyFlag;
    }

    public void resetEngineParam5Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam5Label();
            return;
        }
        this.engineparam5labelDirtyFlag = false;
        this.engineparam5label = null;
    }

    public void setEngineParam6Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam6Flag(n);
            return;
        }
        this.engineparam6flag = n;
        this.engineparam6flagDirtyFlag = true;
    }

    public Integer getEngineParam6Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam6Flag();
        }
        return this.engineparam6flag;
    }

    public boolean isEngineParam6FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam6FlagDirty();
        }
        return this.engineparam6flagDirtyFlag;
    }

    public void resetEngineParam6Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam6Flag();
            return;
        }
        this.engineparam6flagDirtyFlag = false;
        this.engineparam6flag = null;
    }

    public void setEngineParam6Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam6Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam6label = string;
        this.engineparam6labelDirtyFlag = true;
    }

    public String getEngineParam6Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam6Label();
        }
        return this.engineparam6label;
    }

    public boolean isEngineParam6LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam6LabelDirty();
        }
        return this.engineparam6labelDirtyFlag;
    }

    public void resetEngineParam6Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam6Label();
            return;
        }
        this.engineparam6labelDirtyFlag = false;
        this.engineparam6label = null;
    }

    public void setEngineParam7Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam7Flag(n);
            return;
        }
        this.engineparam7flag = n;
        this.engineparam7flagDirtyFlag = true;
    }

    public Integer getEngineParam7Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam7Flag();
        }
        return this.engineparam7flag;
    }

    public boolean isEngineParam7FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam7FlagDirty();
        }
        return this.engineparam7flagDirtyFlag;
    }

    public void resetEngineParam7Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam7Flag();
            return;
        }
        this.engineparam7flagDirtyFlag = false;
        this.engineparam7flag = null;
    }

    public void setEngineParam7Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam7Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam7label = string;
        this.engineparam7labelDirtyFlag = true;
    }

    public String getEngineParam7Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam7Label();
        }
        return this.engineparam7label;
    }

    public boolean isEngineParam7LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam7LabelDirty();
        }
        return this.engineparam7labelDirtyFlag;
    }

    public void resetEngineParam7Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam7Label();
            return;
        }
        this.engineparam7labelDirtyFlag = false;
        this.engineparam7label = null;
    }

    public void setEngineParam8Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam8Flag(n);
            return;
        }
        this.engineparam8flag = n;
        this.engineparam8flagDirtyFlag = true;
    }

    public Integer getEngineParam8Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam8Flag();
        }
        return this.engineparam8flag;
    }

    public boolean isEngineParam8FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam8FlagDirty();
        }
        return this.engineparam8flagDirtyFlag;
    }

    public void resetEngineParam8Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam8Flag();
            return;
        }
        this.engineparam8flagDirtyFlag = false;
        this.engineparam8flag = null;
    }

    public void setEngineParam8Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam8Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam8label = string;
        this.engineparam8labelDirtyFlag = true;
    }

    public String getEngineParam8Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam8Label();
        }
        return this.engineparam8label;
    }

    public boolean isEngineParam8LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam8LabelDirty();
        }
        return this.engineparam8labelDirtyFlag;
    }

    public void resetEngineParam8Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam8Label();
            return;
        }
        this.engineparam8labelDirtyFlag = false;
        this.engineparam8label = null;
    }

    public void setEngineParam9Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam9Flag(n);
            return;
        }
        this.engineparam9flag = n;
        this.engineparam9flagDirtyFlag = true;
    }

    public Integer getEngineParam9Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam9Flag();
        }
        return this.engineparam9flag;
    }

    public boolean isEngineParam9FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam9FlagDirty();
        }
        return this.engineparam9flagDirtyFlag;
    }

    public void resetEngineParam9Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam9Flag();
            return;
        }
        this.engineparam9flagDirtyFlag = false;
        this.engineparam9flag = null;
    }

    public void setEngineParam9Label(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParam9Label(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparam9label = string;
        this.engineparam9labelDirtyFlag = true;
    }

    public String getEngineParam9Label() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParam9Label();
        }
        return this.engineparam9label;
    }

    public boolean isEngineParam9LabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParam9LabelDirty();
        }
        return this.engineparam9labelDirtyFlag;
    }

    public void resetEngineParam9Label() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParam9Label();
            return;
        }
        this.engineparam9labelDirtyFlag = false;
        this.engineparam9label = null;
    }

    public void setEngineParamFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParamFlag(n);
            return;
        }
        this.engineparamflag = n;
        this.engineparamflagDirtyFlag = true;
    }

    public Integer getEngineParamFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParamFlag();
        }
        return this.engineparamflag;
    }

    public boolean isEngineParamFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamFlagDirty();
        }
        return this.engineparamflagDirtyFlag;
    }

    public void resetEngineParamFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParamFlag();
            return;
        }
        this.engineparamflagDirtyFlag = false;
        this.engineparamflag = null;
    }

    public void setEngineParamLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParamLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparamlabel = string;
        this.engineparamlabelDirtyFlag = true;
    }

    public String getEngineParamLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParamLabel();
        }
        return this.engineparamlabel;
    }

    public boolean isEngineParamLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamLabelDirty();
        }
        return this.engineparamlabelDirtyFlag;
    }

    public void resetEngineParamLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParamLabel();
            return;
        }
        this.engineparamlabelDirtyFlag = false;
        this.engineparamlabel = null;
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

    public void setNo2UICtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2UICtrlFlag(n);
            return;
        }
        this.no2uictrlflag = n;
        this.no2uictrlflagDirtyFlag = true;
    }

    public Integer getNo2UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2UICtrlFlag();
        }
        return this.no2uictrlflag;
    }

    public boolean isNo2UICtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2UICtrlFlagDirty();
        }
        return this.no2uictrlflagDirtyFlag;
    }

    public void resetNo2UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2UICtrlFlag();
            return;
        }
        this.no2uictrlflagDirtyFlag = false;
        this.no2uictrlflag = null;
    }

    public void setNo2UICtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2UICtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2uictrllabel = string;
        this.no2uictrllabelDirtyFlag = true;
    }

    public String getNo2UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2UICtrlLabel();
        }
        return this.no2uictrllabel;
    }

    public boolean isNo2UICtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2UICtrlLabelDirty();
        }
        return this.no2uictrllabelDirtyFlag;
    }

    public void resetNo2UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2UICtrlLabel();
            return;
        }
        this.no2uictrllabelDirtyFlag = false;
        this.no2uictrllabel = null;
    }

    public void setNo2UILogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2UILogicFlag(n);
            return;
        }
        this.no2uilogicflag = n;
        this.no2uilogicflagDirtyFlag = true;
    }

    public Integer getNo2UILogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2UILogicFlag();
        }
        return this.no2uilogicflag;
    }

    public boolean isNo2UILogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2UILogicFlagDirty();
        }
        return this.no2uilogicflagDirtyFlag;
    }

    public void resetNo2UILogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2UILogicFlag();
            return;
        }
        this.no2uilogicflagDirtyFlag = false;
        this.no2uilogicflag = null;
    }

    public void setNo2UILogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2UILogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2uilogiclabel = string;
        this.no2uilogiclabelDirtyFlag = true;
    }

    public String getNo2UILogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2UILogicLabel();
        }
        return this.no2uilogiclabel;
    }

    public boolean isNo2UILogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2UILogicLabelDirty();
        }
        return this.no2uilogiclabelDirtyFlag;
    }

    public void resetNo2UILogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2UILogicLabel();
            return;
        }
        this.no2uilogiclabelDirtyFlag = false;
        this.no2uilogiclabel = null;
    }

    public void setNo3UICtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3UICtrlFlag(n);
            return;
        }
        this.no3uictrlflag = n;
        this.no3uictrlflagDirtyFlag = true;
    }

    public Integer getNo3UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3UICtrlFlag();
        }
        return this.no3uictrlflag;
    }

    public boolean isNo3UICtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3UICtrlFlagDirty();
        }
        return this.no3uictrlflagDirtyFlag;
    }

    public void resetNo3UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3UICtrlFlag();
            return;
        }
        this.no3uictrlflagDirtyFlag = false;
        this.no3uictrlflag = null;
    }

    public void setNo3UICtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3UICtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3uictrllabel = string;
        this.no3uictrllabelDirtyFlag = true;
    }

    public String getNo3UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3UICtrlLabel();
        }
        return this.no3uictrllabel;
    }

    public boolean isNo3UICtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3UICtrlLabelDirty();
        }
        return this.no3uictrllabelDirtyFlag;
    }

    public void resetNo3UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3UICtrlLabel();
            return;
        }
        this.no3uictrllabelDirtyFlag = false;
        this.no3uictrllabel = null;
    }

    public void setNo3UILogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3UILogicFlag(n);
            return;
        }
        this.no3uilogicflag = n;
        this.no3uilogicflagDirtyFlag = true;
    }

    public Integer getNo3UILogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3UILogicFlag();
        }
        return this.no3uilogicflag;
    }

    public boolean isNo3UILogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3UILogicFlagDirty();
        }
        return this.no3uilogicflagDirtyFlag;
    }

    public void resetNo3UILogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3UILogicFlag();
            return;
        }
        this.no3uilogicflagDirtyFlag = false;
        this.no3uilogicflag = null;
    }

    public void setNo3UILogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo3UILogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no3uilogiclabel = string;
        this.no3uilogiclabelDirtyFlag = true;
    }

    public String getNo3UILogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo3UILogicLabel();
        }
        return this.no3uilogiclabel;
    }

    public boolean isNo3UILogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo3UILogicLabelDirty();
        }
        return this.no3uilogiclabelDirtyFlag;
    }

    public void resetNo3UILogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo3UILogicLabel();
            return;
        }
        this.no3uilogiclabelDirtyFlag = false;
        this.no3uilogiclabel = null;
    }

    public void setNo4UICtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4UICtrlFlag(n);
            return;
        }
        this.no4uictrlflag = n;
        this.no4uictrlflagDirtyFlag = true;
    }

    public Integer getNo4UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4UICtrlFlag();
        }
        return this.no4uictrlflag;
    }

    public boolean isNo4UICtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4UICtrlFlagDirty();
        }
        return this.no4uictrlflagDirtyFlag;
    }

    public void resetNo4UICtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4UICtrlFlag();
            return;
        }
        this.no4uictrlflagDirtyFlag = false;
        this.no4uictrlflag = null;
    }

    public void setNo4UICtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4UICtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4uictrllabel = string;
        this.no4uictrllabelDirtyFlag = true;
    }

    public String getNo4UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4UICtrlLabel();
        }
        return this.no4uictrllabel;
    }

    public boolean isNo4UICtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4UICtrlLabelDirty();
        }
        return this.no4uictrllabelDirtyFlag;
    }

    public void resetNo4UICtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4UICtrlLabel();
            return;
        }
        this.no4uictrllabelDirtyFlag = false;
        this.no4uictrllabel = null;
    }

    public void setNo4UILogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4UILogicFlag(n);
            return;
        }
        this.no4uilogicflag = n;
        this.no4uilogicflagDirtyFlag = true;
    }

    public Integer getNo4UILogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4UILogicFlag();
        }
        return this.no4uilogicflag;
    }

    public boolean isNo4UILogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4UILogicFlagDirty();
        }
        return this.no4uilogicflagDirtyFlag;
    }

    public void resetNo4UILogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4UILogicFlag();
            return;
        }
        this.no4uilogicflagDirtyFlag = false;
        this.no4uilogicflag = null;
    }

    public void setNo4UILogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo4UILogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no4uilogiclabel = string;
        this.no4uilogiclabelDirtyFlag = true;
    }

    public String getNo4UILogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo4UILogicLabel();
        }
        return this.no4uilogiclabel;
    }

    public boolean isNo4UILogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo4UILogicLabelDirty();
        }
        return this.no4uilogiclabelDirtyFlag;
    }

    public void resetNo4UILogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo4UILogicLabel();
            return;
        }
        this.no4uilogiclabelDirtyFlag = false;
        this.no4uilogiclabel = null;
    }

    public void setPanelEngineObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelEngineObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelengineobj = string;
        this.panelengineobjDirtyFlag = true;
    }

    public String getPanelEngineObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelEngineObj();
        }
        return this.panelengineobj;
    }

    public boolean isPanelEngineObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelEngineObjDirty();
        }
        return this.panelengineobjDirtyFlag;
    }

    public void resetPanelEngineObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelEngineObj();
            return;
        }
        this.panelengineobjDirtyFlag = false;
        this.panelengineobj = null;
    }

    public void setPSUIEngineTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypeid = string;
        this.psuienginetypeidDirtyFlag = true;
    }

    public String getPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeId();
        }
        return this.psuienginetypeid;
    }

    public boolean isPSUIEngineTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeIdDirty();
        }
        return this.psuienginetypeidDirtyFlag;
    }

    public void resetPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeId();
            return;
        }
        this.psuienginetypeidDirtyFlag = false;
        this.psuienginetypeid = null;
    }

    public void setPSUIEngineTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypename = string;
        this.psuienginetypenameDirtyFlag = true;
    }

    public String getPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeName();
        }
        return this.psuienginetypename;
    }

    public boolean isPSUIEngineTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeNameDirty();
        }
        return this.psuienginetypenameDirtyFlag;
    }

    public void resetPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeName();
            return;
        }
        this.psuienginetypenameDirtyFlag = false;
        this.psuienginetypename = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
    }

    public void setUICtrlFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUICtrlFlag(n);
            return;
        }
        this.uictrlflag = n;
        this.uictrlflagDirtyFlag = true;
    }

    public Integer getUICtrlFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUICtrlFlag();
        }
        return this.uictrlflag;
    }

    public boolean isUICtrlFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUICtrlFlagDirty();
        }
        return this.uictrlflagDirtyFlag;
    }

    public void resetUICtrlFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUICtrlFlag();
            return;
        }
        this.uictrlflagDirtyFlag = false;
        this.uictrlflag = null;
    }

    public void setUICtrlLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUICtrlLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uictrllabel = string;
        this.uictrllabelDirtyFlag = true;
    }

    public String getUICtrlLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUICtrlLabel();
        }
        return this.uictrllabel;
    }

    public boolean isUICtrlLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUICtrlLabelDirty();
        }
        return this.uictrllabelDirtyFlag;
    }

    public void resetUICtrlLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUICtrlLabel();
            return;
        }
        this.uictrllabelDirtyFlag = false;
        this.uictrllabel = null;
    }

    public void setUILogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUILogicFlag(n);
            return;
        }
        this.uilogicflag = n;
        this.uilogicflagDirtyFlag = true;
    }

    public Integer getUILogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUILogicFlag();
        }
        return this.uilogicflag;
    }

    public boolean isUILogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUILogicFlagDirty();
        }
        return this.uilogicflagDirtyFlag;
    }

    public void resetUILogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUILogicFlag();
            return;
        }
        this.uilogicflagDirtyFlag = false;
        this.uilogicflag = null;
    }

    public void setUILogicLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUILogicLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uilogiclabel = string;
        this.uilogiclabelDirtyFlag = true;
    }

    public String getUILogicLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUILogicLabel();
        }
        return this.uilogiclabel;
    }

    public boolean isUILogicLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUILogicLabelDirty();
        }
        return this.uilogiclabelDirtyFlag;
    }

    public void resetUILogicLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUILogicLabel();
            return;
        }
        this.uilogiclabelDirtyFlag = false;
        this.uilogiclabel = null;
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

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
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
        PSUIEngineTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUIEngineTypeBase pSUIEngineTypeBase) {
        pSUIEngineTypeBase.resetCreateDate();
        pSUIEngineTypeBase.resetCreateMan();
        pSUIEngineTypeBase.resetEngineCat();
        pSUIEngineTypeBase.resetEngineObj();
        pSUIEngineTypeBase.resetEngineParam10Flag();
        pSUIEngineTypeBase.resetEngineParam10Label();
        pSUIEngineTypeBase.resetEngineParam2Flag();
        pSUIEngineTypeBase.resetEngineParam2Label();
        pSUIEngineTypeBase.resetEngineParam3Flag();
        pSUIEngineTypeBase.resetEngineParam3Label();
        pSUIEngineTypeBase.resetEngineParam4Flag();
        pSUIEngineTypeBase.resetEngineParam4Label();
        pSUIEngineTypeBase.resetEngineParam5Flag();
        pSUIEngineTypeBase.resetEngineParam5Label();
        pSUIEngineTypeBase.resetEngineParam6Flag();
        pSUIEngineTypeBase.resetEngineParam6Label();
        pSUIEngineTypeBase.resetEngineParam7Flag();
        pSUIEngineTypeBase.resetEngineParam7Label();
        pSUIEngineTypeBase.resetEngineParam8Flag();
        pSUIEngineTypeBase.resetEngineParam8Label();
        pSUIEngineTypeBase.resetEngineParam9Flag();
        pSUIEngineTypeBase.resetEngineParam9Label();
        pSUIEngineTypeBase.resetEngineParamFlag();
        pSUIEngineTypeBase.resetEngineParamLabel();
        pSUIEngineTypeBase.resetLogicName();
        pSUIEngineTypeBase.resetMemo();
        pSUIEngineTypeBase.resetNo2UICtrlFlag();
        pSUIEngineTypeBase.resetNo2UICtrlLabel();
        pSUIEngineTypeBase.resetNo2UILogicFlag();
        pSUIEngineTypeBase.resetNo2UILogicLabel();
        pSUIEngineTypeBase.resetNo3UICtrlFlag();
        pSUIEngineTypeBase.resetNo3UICtrlLabel();
        pSUIEngineTypeBase.resetNo3UILogicFlag();
        pSUIEngineTypeBase.resetNo3UILogicLabel();
        pSUIEngineTypeBase.resetNo4UICtrlFlag();
        pSUIEngineTypeBase.resetNo4UICtrlLabel();
        pSUIEngineTypeBase.resetNo4UILogicFlag();
        pSUIEngineTypeBase.resetNo4UILogicLabel();
        pSUIEngineTypeBase.resetPanelEngineObj();
        pSUIEngineTypeBase.resetPSUIEngineTypeId();
        pSUIEngineTypeBase.resetPSUIEngineTypeName();
        pSUIEngineTypeBase.resetTypeCode();
        pSUIEngineTypeBase.resetTypeObj();
        pSUIEngineTypeBase.resetUICtrlFlag();
        pSUIEngineTypeBase.resetUICtrlLabel();
        pSUIEngineTypeBase.resetUILogicFlag();
        pSUIEngineTypeBase.resetUILogicLabel();
        pSUIEngineTypeBase.resetUpdateDate();
        pSUIEngineTypeBase.resetUpdateMan();
        pSUIEngineTypeBase.resetUtilParams();
        pSUIEngineTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEngineCatDirty()) {
            hashMap.put(FIELD_ENGINECAT, this.getEngineCat());
        }
        if (!bl || this.isEngineObjDirty()) {
            hashMap.put(FIELD_ENGINEOBJ, this.getEngineObj());
        }
        if (!bl || this.isEngineParam10FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM10FLAG, this.getEngineParam10Flag());
        }
        if (!bl || this.isEngineParam10LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM10LABEL, this.getEngineParam10Label());
        }
        if (!bl || this.isEngineParam2FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM2FLAG, this.getEngineParam2Flag());
        }
        if (!bl || this.isEngineParam2LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM2LABEL, this.getEngineParam2Label());
        }
        if (!bl || this.isEngineParam3FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM3FLAG, this.getEngineParam3Flag());
        }
        if (!bl || this.isEngineParam3LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM3LABEL, this.getEngineParam3Label());
        }
        if (!bl || this.isEngineParam4FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM4FLAG, this.getEngineParam4Flag());
        }
        if (!bl || this.isEngineParam4LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM4LABEL, this.getEngineParam4Label());
        }
        if (!bl || this.isEngineParam5FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM5FLAG, this.getEngineParam5Flag());
        }
        if (!bl || this.isEngineParam5LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM5LABEL, this.getEngineParam5Label());
        }
        if (!bl || this.isEngineParam6FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM6FLAG, this.getEngineParam6Flag());
        }
        if (!bl || this.isEngineParam6LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM6LABEL, this.getEngineParam6Label());
        }
        if (!bl || this.isEngineParam7FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM7FLAG, this.getEngineParam7Flag());
        }
        if (!bl || this.isEngineParam7LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM7LABEL, this.getEngineParam7Label());
        }
        if (!bl || this.isEngineParam8FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM8FLAG, this.getEngineParam8Flag());
        }
        if (!bl || this.isEngineParam8LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM8LABEL, this.getEngineParam8Label());
        }
        if (!bl || this.isEngineParam9FlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAM9FLAG, this.getEngineParam9Flag());
        }
        if (!bl || this.isEngineParam9LabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAM9LABEL, this.getEngineParam9Label());
        }
        if (!bl || this.isEngineParamFlagDirty()) {
            hashMap.put(FIELD_ENGINEPARAMFLAG, this.getEngineParamFlag());
        }
        if (!bl || this.isEngineParamLabelDirty()) {
            hashMap.put(FIELD_ENGINEPARAMLABEL, this.getEngineParamLabel());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNo2UICtrlFlagDirty()) {
            hashMap.put(FIELD_NO2UICTRLFLAG, this.getNo2UICtrlFlag());
        }
        if (!bl || this.isNo2UICtrlLabelDirty()) {
            hashMap.put(FIELD_NO2UICTRLLABEL, this.getNo2UICtrlLabel());
        }
        if (!bl || this.isNo2UILogicFlagDirty()) {
            hashMap.put(FIELD_NO2UILOGICFLAG, this.getNo2UILogicFlag());
        }
        if (!bl || this.isNo2UILogicLabelDirty()) {
            hashMap.put(FIELD_NO2UILOGICLABEL, this.getNo2UILogicLabel());
        }
        if (!bl || this.isNo3UICtrlFlagDirty()) {
            hashMap.put(FIELD_NO3UICTRLFLAG, this.getNo3UICtrlFlag());
        }
        if (!bl || this.isNo3UICtrlLabelDirty()) {
            hashMap.put(FIELD_NO3UICTRLLABEL, this.getNo3UICtrlLabel());
        }
        if (!bl || this.isNo3UILogicFlagDirty()) {
            hashMap.put(FIELD_NO3UILOGICFLAG, this.getNo3UILogicFlag());
        }
        if (!bl || this.isNo3UILogicLabelDirty()) {
            hashMap.put(FIELD_NO3UILOGICLABEL, this.getNo3UILogicLabel());
        }
        if (!bl || this.isNo4UICtrlFlagDirty()) {
            hashMap.put(FIELD_NO4UICTRLFLAG, this.getNo4UICtrlFlag());
        }
        if (!bl || this.isNo4UICtrlLabelDirty()) {
            hashMap.put(FIELD_NO4UICTRLLABEL, this.getNo4UICtrlLabel());
        }
        if (!bl || this.isNo4UILogicFlagDirty()) {
            hashMap.put(FIELD_NO4UILOGICFLAG, this.getNo4UILogicFlag());
        }
        if (!bl || this.isNo4UILogicLabelDirty()) {
            hashMap.put(FIELD_NO4UILOGICLABEL, this.getNo4UILogicLabel());
        }
        if (!bl || this.isPanelEngineObjDirty()) {
            hashMap.put(FIELD_PANELENGINEOBJ, this.getPanelEngineObj());
        }
        if (!bl || this.isPSUIEngineTypeIdDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPEID, this.getPSUIEngineTypeId());
        }
        if (!bl || this.isPSUIEngineTypeNameDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPENAME, this.getPSUIEngineTypeName());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isUICtrlFlagDirty()) {
            hashMap.put(FIELD_UICTRLFLAG, this.getUICtrlFlag());
        }
        if (!bl || this.isUICtrlLabelDirty()) {
            hashMap.put(FIELD_UICTRLLABEL, this.getUICtrlLabel());
        }
        if (!bl || this.isUILogicFlagDirty()) {
            hashMap.put(FIELD_UILOGICFLAG, this.getUILogicFlag());
        }
        if (!bl || this.isUILogicLabelDirty()) {
            hashMap.put(FIELD_UILOGICLABEL, this.getUILogicLabel());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
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
        return PSUIEngineTypeBase.get(this, n);
    }

    private static Object get(PSUIEngineTypeBase pSUIEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeBase.getCreateDate();
            }
            case 1: {
                return pSUIEngineTypeBase.getCreateMan();
            }
            case 2: {
                return pSUIEngineTypeBase.getEngineCat();
            }
            case 3: {
                return pSUIEngineTypeBase.getEngineObj();
            }
            case 4: {
                return pSUIEngineTypeBase.getEngineParam10Flag();
            }
            case 5: {
                return pSUIEngineTypeBase.getEngineParam10Label();
            }
            case 6: {
                return pSUIEngineTypeBase.getEngineParam2Flag();
            }
            case 7: {
                return pSUIEngineTypeBase.getEngineParam2Label();
            }
            case 8: {
                return pSUIEngineTypeBase.getEngineParam3Flag();
            }
            case 9: {
                return pSUIEngineTypeBase.getEngineParam3Label();
            }
            case 10: {
                return pSUIEngineTypeBase.getEngineParam4Flag();
            }
            case 11: {
                return pSUIEngineTypeBase.getEngineParam4Label();
            }
            case 12: {
                return pSUIEngineTypeBase.getEngineParam5Flag();
            }
            case 13: {
                return pSUIEngineTypeBase.getEngineParam5Label();
            }
            case 14: {
                return pSUIEngineTypeBase.getEngineParam6Flag();
            }
            case 15: {
                return pSUIEngineTypeBase.getEngineParam6Label();
            }
            case 16: {
                return pSUIEngineTypeBase.getEngineParam7Flag();
            }
            case 17: {
                return pSUIEngineTypeBase.getEngineParam7Label();
            }
            case 18: {
                return pSUIEngineTypeBase.getEngineParam8Flag();
            }
            case 19: {
                return pSUIEngineTypeBase.getEngineParam8Label();
            }
            case 20: {
                return pSUIEngineTypeBase.getEngineParam9Flag();
            }
            case 21: {
                return pSUIEngineTypeBase.getEngineParam9Label();
            }
            case 22: {
                return pSUIEngineTypeBase.getEngineParamFlag();
            }
            case 23: {
                return pSUIEngineTypeBase.getEngineParamLabel();
            }
            case 24: {
                return pSUIEngineTypeBase.getLogicName();
            }
            case 25: {
                return pSUIEngineTypeBase.getMemo();
            }
            case 26: {
                return pSUIEngineTypeBase.getNo2UICtrlFlag();
            }
            case 27: {
                return pSUIEngineTypeBase.getNo2UICtrlLabel();
            }
            case 28: {
                return pSUIEngineTypeBase.getNo2UILogicFlag();
            }
            case 29: {
                return pSUIEngineTypeBase.getNo2UILogicLabel();
            }
            case 30: {
                return pSUIEngineTypeBase.getNo3UICtrlFlag();
            }
            case 31: {
                return pSUIEngineTypeBase.getNo3UICtrlLabel();
            }
            case 32: {
                return pSUIEngineTypeBase.getNo3UILogicFlag();
            }
            case 33: {
                return pSUIEngineTypeBase.getNo3UILogicLabel();
            }
            case 34: {
                return pSUIEngineTypeBase.getNo4UICtrlFlag();
            }
            case 35: {
                return pSUIEngineTypeBase.getNo4UICtrlLabel();
            }
            case 36: {
                return pSUIEngineTypeBase.getNo4UILogicFlag();
            }
            case 37: {
                return pSUIEngineTypeBase.getNo4UILogicLabel();
            }
            case 38: {
                return pSUIEngineTypeBase.getPanelEngineObj();
            }
            case 39: {
                return pSUIEngineTypeBase.getPSUIEngineTypeId();
            }
            case 40: {
                return pSUIEngineTypeBase.getPSUIEngineTypeName();
            }
            case 41: {
                return pSUIEngineTypeBase.getTypeCode();
            }
            case 42: {
                return pSUIEngineTypeBase.getTypeObj();
            }
            case 43: {
                return pSUIEngineTypeBase.getUICtrlFlag();
            }
            case 44: {
                return pSUIEngineTypeBase.getUICtrlLabel();
            }
            case 45: {
                return pSUIEngineTypeBase.getUILogicFlag();
            }
            case 46: {
                return pSUIEngineTypeBase.getUILogicLabel();
            }
            case 47: {
                return pSUIEngineTypeBase.getUpdateDate();
            }
            case 48: {
                return pSUIEngineTypeBase.getUpdateMan();
            }
            case 49: {
                return pSUIEngineTypeBase.getUtilParams();
            }
            case 50: {
                return pSUIEngineTypeBase.getValidFlag();
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
        PSUIEngineTypeBase.set(this, n, object);
    }

    private static void set(PSUIEngineTypeBase pSUIEngineTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUIEngineTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUIEngineTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUIEngineTypeBase.setEngineCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUIEngineTypeBase.setEngineObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUIEngineTypeBase.setEngineParam10Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSUIEngineTypeBase.setEngineParam10Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUIEngineTypeBase.setEngineParam2Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSUIEngineTypeBase.setEngineParam2Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUIEngineTypeBase.setEngineParam3Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSUIEngineTypeBase.setEngineParam3Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUIEngineTypeBase.setEngineParam4Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSUIEngineTypeBase.setEngineParam4Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUIEngineTypeBase.setEngineParam5Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSUIEngineTypeBase.setEngineParam5Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUIEngineTypeBase.setEngineParam6Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSUIEngineTypeBase.setEngineParam6Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUIEngineTypeBase.setEngineParam7Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSUIEngineTypeBase.setEngineParam7Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUIEngineTypeBase.setEngineParam8Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSUIEngineTypeBase.setEngineParam8Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUIEngineTypeBase.setEngineParam9Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSUIEngineTypeBase.setEngineParam9Label(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUIEngineTypeBase.setEngineParamFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSUIEngineTypeBase.setEngineParamLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUIEngineTypeBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSUIEngineTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUIEngineTypeBase.setNo2UICtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSUIEngineTypeBase.setNo2UICtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUIEngineTypeBase.setNo2UILogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSUIEngineTypeBase.setNo2UILogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUIEngineTypeBase.setNo3UICtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSUIEngineTypeBase.setNo3UICtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSUIEngineTypeBase.setNo3UILogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSUIEngineTypeBase.setNo3UILogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSUIEngineTypeBase.setNo4UICtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSUIEngineTypeBase.setNo4UICtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSUIEngineTypeBase.setNo4UILogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSUIEngineTypeBase.setNo4UILogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSUIEngineTypeBase.setPanelEngineObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSUIEngineTypeBase.setPSUIEngineTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSUIEngineTypeBase.setPSUIEngineTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSUIEngineTypeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSUIEngineTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSUIEngineTypeBase.setUICtrlFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSUIEngineTypeBase.setUICtrlLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSUIEngineTypeBase.setUILogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSUIEngineTypeBase.setUILogicLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSUIEngineTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 48: {
                pSUIEngineTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSUIEngineTypeBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSUIEngineTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUIEngineTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSUIEngineTypeBase pSUIEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSUIEngineTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSUIEngineTypeBase.getEngineCat() == null;
            }
            case 3: {
                return pSUIEngineTypeBase.getEngineObj() == null;
            }
            case 4: {
                return pSUIEngineTypeBase.getEngineParam10Flag() == null;
            }
            case 5: {
                return pSUIEngineTypeBase.getEngineParam10Label() == null;
            }
            case 6: {
                return pSUIEngineTypeBase.getEngineParam2Flag() == null;
            }
            case 7: {
                return pSUIEngineTypeBase.getEngineParam2Label() == null;
            }
            case 8: {
                return pSUIEngineTypeBase.getEngineParam3Flag() == null;
            }
            case 9: {
                return pSUIEngineTypeBase.getEngineParam3Label() == null;
            }
            case 10: {
                return pSUIEngineTypeBase.getEngineParam4Flag() == null;
            }
            case 11: {
                return pSUIEngineTypeBase.getEngineParam4Label() == null;
            }
            case 12: {
                return pSUIEngineTypeBase.getEngineParam5Flag() == null;
            }
            case 13: {
                return pSUIEngineTypeBase.getEngineParam5Label() == null;
            }
            case 14: {
                return pSUIEngineTypeBase.getEngineParam6Flag() == null;
            }
            case 15: {
                return pSUIEngineTypeBase.getEngineParam6Label() == null;
            }
            case 16: {
                return pSUIEngineTypeBase.getEngineParam7Flag() == null;
            }
            case 17: {
                return pSUIEngineTypeBase.getEngineParam7Label() == null;
            }
            case 18: {
                return pSUIEngineTypeBase.getEngineParam8Flag() == null;
            }
            case 19: {
                return pSUIEngineTypeBase.getEngineParam8Label() == null;
            }
            case 20: {
                return pSUIEngineTypeBase.getEngineParam9Flag() == null;
            }
            case 21: {
                return pSUIEngineTypeBase.getEngineParam9Label() == null;
            }
            case 22: {
                return pSUIEngineTypeBase.getEngineParamFlag() == null;
            }
            case 23: {
                return pSUIEngineTypeBase.getEngineParamLabel() == null;
            }
            case 24: {
                return pSUIEngineTypeBase.getLogicName() == null;
            }
            case 25: {
                return pSUIEngineTypeBase.getMemo() == null;
            }
            case 26: {
                return pSUIEngineTypeBase.getNo2UICtrlFlag() == null;
            }
            case 27: {
                return pSUIEngineTypeBase.getNo2UICtrlLabel() == null;
            }
            case 28: {
                return pSUIEngineTypeBase.getNo2UILogicFlag() == null;
            }
            case 29: {
                return pSUIEngineTypeBase.getNo2UILogicLabel() == null;
            }
            case 30: {
                return pSUIEngineTypeBase.getNo3UICtrlFlag() == null;
            }
            case 31: {
                return pSUIEngineTypeBase.getNo3UICtrlLabel() == null;
            }
            case 32: {
                return pSUIEngineTypeBase.getNo3UILogicFlag() == null;
            }
            case 33: {
                return pSUIEngineTypeBase.getNo3UILogicLabel() == null;
            }
            case 34: {
                return pSUIEngineTypeBase.getNo4UICtrlFlag() == null;
            }
            case 35: {
                return pSUIEngineTypeBase.getNo4UICtrlLabel() == null;
            }
            case 36: {
                return pSUIEngineTypeBase.getNo4UILogicFlag() == null;
            }
            case 37: {
                return pSUIEngineTypeBase.getNo4UILogicLabel() == null;
            }
            case 38: {
                return pSUIEngineTypeBase.getPanelEngineObj() == null;
            }
            case 39: {
                return pSUIEngineTypeBase.getPSUIEngineTypeId() == null;
            }
            case 40: {
                return pSUIEngineTypeBase.getPSUIEngineTypeName() == null;
            }
            case 41: {
                return pSUIEngineTypeBase.getTypeCode() == null;
            }
            case 42: {
                return pSUIEngineTypeBase.getTypeObj() == null;
            }
            case 43: {
                return pSUIEngineTypeBase.getUICtrlFlag() == null;
            }
            case 44: {
                return pSUIEngineTypeBase.getUICtrlLabel() == null;
            }
            case 45: {
                return pSUIEngineTypeBase.getUILogicFlag() == null;
            }
            case 46: {
                return pSUIEngineTypeBase.getUILogicLabel() == null;
            }
            case 47: {
                return pSUIEngineTypeBase.getUpdateDate() == null;
            }
            case 48: {
                return pSUIEngineTypeBase.getUpdateMan() == null;
            }
            case 49: {
                return pSUIEngineTypeBase.getUtilParams() == null;
            }
            case 50: {
                return pSUIEngineTypeBase.getValidFlag() == null;
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
        return PSUIEngineTypeBase.contains(this, n);
    }

    private static boolean contains(PSUIEngineTypeBase pSUIEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSUIEngineTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSUIEngineTypeBase.isEngineCatDirty();
            }
            case 3: {
                return pSUIEngineTypeBase.isEngineObjDirty();
            }
            case 4: {
                return pSUIEngineTypeBase.isEngineParam10FlagDirty();
            }
            case 5: {
                return pSUIEngineTypeBase.isEngineParam10LabelDirty();
            }
            case 6: {
                return pSUIEngineTypeBase.isEngineParam2FlagDirty();
            }
            case 7: {
                return pSUIEngineTypeBase.isEngineParam2LabelDirty();
            }
            case 8: {
                return pSUIEngineTypeBase.isEngineParam3FlagDirty();
            }
            case 9: {
                return pSUIEngineTypeBase.isEngineParam3LabelDirty();
            }
            case 10: {
                return pSUIEngineTypeBase.isEngineParam4FlagDirty();
            }
            case 11: {
                return pSUIEngineTypeBase.isEngineParam4LabelDirty();
            }
            case 12: {
                return pSUIEngineTypeBase.isEngineParam5FlagDirty();
            }
            case 13: {
                return pSUIEngineTypeBase.isEngineParam5LabelDirty();
            }
            case 14: {
                return pSUIEngineTypeBase.isEngineParam6FlagDirty();
            }
            case 15: {
                return pSUIEngineTypeBase.isEngineParam6LabelDirty();
            }
            case 16: {
                return pSUIEngineTypeBase.isEngineParam7FlagDirty();
            }
            case 17: {
                return pSUIEngineTypeBase.isEngineParam7LabelDirty();
            }
            case 18: {
                return pSUIEngineTypeBase.isEngineParam8FlagDirty();
            }
            case 19: {
                return pSUIEngineTypeBase.isEngineParam8LabelDirty();
            }
            case 20: {
                return pSUIEngineTypeBase.isEngineParam9FlagDirty();
            }
            case 21: {
                return pSUIEngineTypeBase.isEngineParam9LabelDirty();
            }
            case 22: {
                return pSUIEngineTypeBase.isEngineParamFlagDirty();
            }
            case 23: {
                return pSUIEngineTypeBase.isEngineParamLabelDirty();
            }
            case 24: {
                return pSUIEngineTypeBase.isLogicNameDirty();
            }
            case 25: {
                return pSUIEngineTypeBase.isMemoDirty();
            }
            case 26: {
                return pSUIEngineTypeBase.isNo2UICtrlFlagDirty();
            }
            case 27: {
                return pSUIEngineTypeBase.isNo2UICtrlLabelDirty();
            }
            case 28: {
                return pSUIEngineTypeBase.isNo2UILogicFlagDirty();
            }
            case 29: {
                return pSUIEngineTypeBase.isNo2UILogicLabelDirty();
            }
            case 30: {
                return pSUIEngineTypeBase.isNo3UICtrlFlagDirty();
            }
            case 31: {
                return pSUIEngineTypeBase.isNo3UICtrlLabelDirty();
            }
            case 32: {
                return pSUIEngineTypeBase.isNo3UILogicFlagDirty();
            }
            case 33: {
                return pSUIEngineTypeBase.isNo3UILogicLabelDirty();
            }
            case 34: {
                return pSUIEngineTypeBase.isNo4UICtrlFlagDirty();
            }
            case 35: {
                return pSUIEngineTypeBase.isNo4UICtrlLabelDirty();
            }
            case 36: {
                return pSUIEngineTypeBase.isNo4UILogicFlagDirty();
            }
            case 37: {
                return pSUIEngineTypeBase.isNo4UILogicLabelDirty();
            }
            case 38: {
                return pSUIEngineTypeBase.isPanelEngineObjDirty();
            }
            case 39: {
                return pSUIEngineTypeBase.isPSUIEngineTypeIdDirty();
            }
            case 40: {
                return pSUIEngineTypeBase.isPSUIEngineTypeNameDirty();
            }
            case 41: {
                return pSUIEngineTypeBase.isTypeCodeDirty();
            }
            case 42: {
                return pSUIEngineTypeBase.isTypeObjDirty();
            }
            case 43: {
                return pSUIEngineTypeBase.isUICtrlFlagDirty();
            }
            case 44: {
                return pSUIEngineTypeBase.isUICtrlLabelDirty();
            }
            case 45: {
                return pSUIEngineTypeBase.isUILogicFlagDirty();
            }
            case 46: {
                return pSUIEngineTypeBase.isUILogicLabelDirty();
            }
            case 47: {
                return pSUIEngineTypeBase.isUpdateDateDirty();
            }
            case 48: {
                return pSUIEngineTypeBase.isUpdateManDirty();
            }
            case 49: {
                return pSUIEngineTypeBase.isUtilParamsDirty();
            }
            case 50: {
                return pSUIEngineTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUIEngineTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUIEngineTypeBase pSUIEngineTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUIEngineTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enginecat", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineCat()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineobj", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineObj()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam10Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam10Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam10Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam10label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam10Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam2Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam2Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam2Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam2label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam2Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam3Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam3Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam3Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam3label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam3Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam4Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam4Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam4Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam4label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam4Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam5Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam5Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam5Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam5label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam5Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam6Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam6Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam6Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam6label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam6Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam7Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam7Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam7Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam7label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam7Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam8Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam8Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam8Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam8label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam8Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam9Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9flag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam9Flag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam9Label() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparam9label", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParam9Label()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParamFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParamFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getEngineParamLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparamlabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getEngineParamLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getLogicName()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo2UICtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2uictrlflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo2UICtrlFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo2UICtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2uictrllabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo2UICtrlLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo2UILogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2uilogicflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo2UILogicFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo2UILogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2uilogiclabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo2UILogicLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo3UICtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3uictrlflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo3UICtrlFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo3UICtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3uictrllabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo3UICtrlLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo3UILogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3uilogicflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo3UILogicFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo3UILogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no3uilogiclabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo3UILogicLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo4UICtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4uictrlflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo4UICtrlFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo4UICtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4uictrllabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo4UICtrlLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo4UILogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4uilogicflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo4UILogicFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getNo4UILogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no4uilogiclabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getNo4UILogicLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getPanelEngineObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelengineobj", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getPanelEngineObj()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getPSUIEngineTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeid", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getPSUIEngineTypeId()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getPSUIEngineTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypename", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getPSUIEngineTypeName()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUICtrlFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uictrlflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUICtrlFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUICtrlLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uictrllabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUICtrlLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUILogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uilogicflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUILogicFlag()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUILogicLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uilogiclabel", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUILogicLabel()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSUIEngineTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUIEngineTypeBase.getJSONValue((Object)pSUIEngineTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUIEngineTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUIEngineTypeBase pSUIEngineTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUIEngineTypeBase.getCreateDate() != null) {
            object = pSUIEngineTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getCreateMan() != null) {
            object = pSUIEngineTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineCat() != null) {
            object = pSUIEngineTypeBase.getEngineCat();
            xmlNode.setAttribute(FIELD_ENGINECAT, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineObj() != null) {
            object = pSUIEngineTypeBase.getEngineObj();
            xmlNode.setAttribute(FIELD_ENGINEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam10Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam10Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam10Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam10Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM10LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam2Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam2Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam2Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam2Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM2LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam3Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam3Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam3Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam3Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM3LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam4Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam4Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam4Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam4Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM4LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam5Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam5Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam5Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam5Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM5LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam6Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam6Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam6Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam6Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM6LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam7Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam7Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam7Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam7Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM7LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam8Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam8Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam8Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam8Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM8LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParam9Flag() != null) {
            object = pSUIEngineTypeBase.getEngineParam9Flag();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParam9Label() != null) {
            object = pSUIEngineTypeBase.getEngineParam9Label();
            xmlNode.setAttribute(FIELD_ENGINEPARAM9LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getEngineParamFlag() != null) {
            object = pSUIEngineTypeBase.getEngineParamFlag();
            xmlNode.setAttribute(FIELD_ENGINEPARAMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getEngineParamLabel() != null) {
            object = pSUIEngineTypeBase.getEngineParamLabel();
            xmlNode.setAttribute(FIELD_ENGINEPARAMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getLogicName() != null) {
            object = pSUIEngineTypeBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getMemo() != null) {
            object = pSUIEngineTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo2UICtrlFlag() != null) {
            object = pSUIEngineTypeBase.getNo2UICtrlFlag();
            xmlNode.setAttribute(FIELD_NO2UICTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo2UICtrlLabel() != null) {
            object = pSUIEngineTypeBase.getNo2UICtrlLabel();
            xmlNode.setAttribute(FIELD_NO2UICTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo2UILogicFlag() != null) {
            object = pSUIEngineTypeBase.getNo2UILogicFlag();
            xmlNode.setAttribute(FIELD_NO2UILOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo2UILogicLabel() != null) {
            object = pSUIEngineTypeBase.getNo2UILogicLabel();
            xmlNode.setAttribute(FIELD_NO2UILOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo3UICtrlFlag() != null) {
            object = pSUIEngineTypeBase.getNo3UICtrlFlag();
            xmlNode.setAttribute(FIELD_NO3UICTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo3UICtrlLabel() != null) {
            object = pSUIEngineTypeBase.getNo3UICtrlLabel();
            xmlNode.setAttribute(FIELD_NO3UICTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo3UILogicFlag() != null) {
            object = pSUIEngineTypeBase.getNo3UILogicFlag();
            xmlNode.setAttribute(FIELD_NO3UILOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo3UILogicLabel() != null) {
            object = pSUIEngineTypeBase.getNo3UILogicLabel();
            xmlNode.setAttribute(FIELD_NO3UILOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo4UICtrlFlag() != null) {
            object = pSUIEngineTypeBase.getNo4UICtrlFlag();
            xmlNode.setAttribute(FIELD_NO4UICTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo4UICtrlLabel() != null) {
            object = pSUIEngineTypeBase.getNo4UICtrlLabel();
            xmlNode.setAttribute(FIELD_NO4UICTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getNo4UILogicFlag() != null) {
            object = pSUIEngineTypeBase.getNo4UILogicFlag();
            xmlNode.setAttribute(FIELD_NO4UILOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getNo4UILogicLabel() != null) {
            object = pSUIEngineTypeBase.getNo4UILogicLabel();
            xmlNode.setAttribute(FIELD_NO4UILOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getPanelEngineObj() != null) {
            object = pSUIEngineTypeBase.getPanelEngineObj();
            xmlNode.setAttribute(FIELD_PANELENGINEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getPSUIEngineTypeId() != null) {
            object = pSUIEngineTypeBase.getPSUIEngineTypeId();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getPSUIEngineTypeName() != null) {
            object = pSUIEngineTypeBase.getPSUIEngineTypeName();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getTypeCode() != null) {
            object = pSUIEngineTypeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getTypeObj() != null) {
            object = pSUIEngineTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getUICtrlFlag() != null) {
            object = pSUIEngineTypeBase.getUICtrlFlag();
            xmlNode.setAttribute(FIELD_UICTRLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getUICtrlLabel() != null) {
            object = pSUIEngineTypeBase.getUICtrlLabel();
            xmlNode.setAttribute(FIELD_UICTRLLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getUILogicFlag() != null) {
            object = pSUIEngineTypeBase.getUILogicFlag();
            xmlNode.setAttribute(FIELD_UILOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getUILogicLabel() != null) {
            object = pSUIEngineTypeBase.getUILogicLabel();
            xmlNode.setAttribute(FIELD_UILOGICLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getUpdateDate() != null) {
            object = pSUIEngineTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUIEngineTypeBase.getUpdateMan() != null) {
            object = pSUIEngineTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getUtilParams() != null) {
            object = pSUIEngineTypeBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeBase.getValidFlag() != null) {
            object = pSUIEngineTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUIEngineTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUIEngineTypeBase pSUIEngineTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUIEngineTypeBase.isCreateDateDirty() && (bl || pSUIEngineTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUIEngineTypeBase.getCreateDate());
        }
        if (pSUIEngineTypeBase.isCreateManDirty() && (bl || pSUIEngineTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUIEngineTypeBase.getCreateMan());
        }
        if (pSUIEngineTypeBase.isEngineCatDirty() && (bl || pSUIEngineTypeBase.getEngineCat() != null)) {
            iDataObject.set(FIELD_ENGINECAT, (Object)pSUIEngineTypeBase.getEngineCat());
        }
        if (pSUIEngineTypeBase.isEngineObjDirty() && (bl || pSUIEngineTypeBase.getEngineObj() != null)) {
            iDataObject.set(FIELD_ENGINEOBJ, (Object)pSUIEngineTypeBase.getEngineObj());
        }
        if (pSUIEngineTypeBase.isEngineParam10FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam10Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10FLAG, (Object)pSUIEngineTypeBase.getEngineParam10Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam10LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam10Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM10LABEL, (Object)pSUIEngineTypeBase.getEngineParam10Label());
        }
        if (pSUIEngineTypeBase.isEngineParam2FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam2Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2FLAG, (Object)pSUIEngineTypeBase.getEngineParam2Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam2LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam2Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM2LABEL, (Object)pSUIEngineTypeBase.getEngineParam2Label());
        }
        if (pSUIEngineTypeBase.isEngineParam3FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam3Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3FLAG, (Object)pSUIEngineTypeBase.getEngineParam3Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam3LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam3Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM3LABEL, (Object)pSUIEngineTypeBase.getEngineParam3Label());
        }
        if (pSUIEngineTypeBase.isEngineParam4FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam4Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4FLAG, (Object)pSUIEngineTypeBase.getEngineParam4Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam4LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam4Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM4LABEL, (Object)pSUIEngineTypeBase.getEngineParam4Label());
        }
        if (pSUIEngineTypeBase.isEngineParam5FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam5Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5FLAG, (Object)pSUIEngineTypeBase.getEngineParam5Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam5LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam5Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM5LABEL, (Object)pSUIEngineTypeBase.getEngineParam5Label());
        }
        if (pSUIEngineTypeBase.isEngineParam6FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam6Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6FLAG, (Object)pSUIEngineTypeBase.getEngineParam6Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam6LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam6Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM6LABEL, (Object)pSUIEngineTypeBase.getEngineParam6Label());
        }
        if (pSUIEngineTypeBase.isEngineParam7FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam7Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7FLAG, (Object)pSUIEngineTypeBase.getEngineParam7Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam7LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam7Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM7LABEL, (Object)pSUIEngineTypeBase.getEngineParam7Label());
        }
        if (pSUIEngineTypeBase.isEngineParam8FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam8Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8FLAG, (Object)pSUIEngineTypeBase.getEngineParam8Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam8LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam8Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM8LABEL, (Object)pSUIEngineTypeBase.getEngineParam8Label());
        }
        if (pSUIEngineTypeBase.isEngineParam9FlagDirty() && (bl || pSUIEngineTypeBase.getEngineParam9Flag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9FLAG, (Object)pSUIEngineTypeBase.getEngineParam9Flag());
        }
        if (pSUIEngineTypeBase.isEngineParam9LabelDirty() && (bl || pSUIEngineTypeBase.getEngineParam9Label() != null)) {
            iDataObject.set(FIELD_ENGINEPARAM9LABEL, (Object)pSUIEngineTypeBase.getEngineParam9Label());
        }
        if (pSUIEngineTypeBase.isEngineParamFlagDirty() && (bl || pSUIEngineTypeBase.getEngineParamFlag() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMFLAG, (Object)pSUIEngineTypeBase.getEngineParamFlag());
        }
        if (pSUIEngineTypeBase.isEngineParamLabelDirty() && (bl || pSUIEngineTypeBase.getEngineParamLabel() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMLABEL, (Object)pSUIEngineTypeBase.getEngineParamLabel());
        }
        if (pSUIEngineTypeBase.isLogicNameDirty() && (bl || pSUIEngineTypeBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSUIEngineTypeBase.getLogicName());
        }
        if (pSUIEngineTypeBase.isMemoDirty() && (bl || pSUIEngineTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUIEngineTypeBase.getMemo());
        }
        if (pSUIEngineTypeBase.isNo2UICtrlFlagDirty() && (bl || pSUIEngineTypeBase.getNo2UICtrlFlag() != null)) {
            iDataObject.set(FIELD_NO2UICTRLFLAG, (Object)pSUIEngineTypeBase.getNo2UICtrlFlag());
        }
        if (pSUIEngineTypeBase.isNo2UICtrlLabelDirty() && (bl || pSUIEngineTypeBase.getNo2UICtrlLabel() != null)) {
            iDataObject.set(FIELD_NO2UICTRLLABEL, (Object)pSUIEngineTypeBase.getNo2UICtrlLabel());
        }
        if (pSUIEngineTypeBase.isNo2UILogicFlagDirty() && (bl || pSUIEngineTypeBase.getNo2UILogicFlag() != null)) {
            iDataObject.set(FIELD_NO2UILOGICFLAG, (Object)pSUIEngineTypeBase.getNo2UILogicFlag());
        }
        if (pSUIEngineTypeBase.isNo2UILogicLabelDirty() && (bl || pSUIEngineTypeBase.getNo2UILogicLabel() != null)) {
            iDataObject.set(FIELD_NO2UILOGICLABEL, (Object)pSUIEngineTypeBase.getNo2UILogicLabel());
        }
        if (pSUIEngineTypeBase.isNo3UICtrlFlagDirty() && (bl || pSUIEngineTypeBase.getNo3UICtrlFlag() != null)) {
            iDataObject.set(FIELD_NO3UICTRLFLAG, (Object)pSUIEngineTypeBase.getNo3UICtrlFlag());
        }
        if (pSUIEngineTypeBase.isNo3UICtrlLabelDirty() && (bl || pSUIEngineTypeBase.getNo3UICtrlLabel() != null)) {
            iDataObject.set(FIELD_NO3UICTRLLABEL, (Object)pSUIEngineTypeBase.getNo3UICtrlLabel());
        }
        if (pSUIEngineTypeBase.isNo3UILogicFlagDirty() && (bl || pSUIEngineTypeBase.getNo3UILogicFlag() != null)) {
            iDataObject.set(FIELD_NO3UILOGICFLAG, (Object)pSUIEngineTypeBase.getNo3UILogicFlag());
        }
        if (pSUIEngineTypeBase.isNo3UILogicLabelDirty() && (bl || pSUIEngineTypeBase.getNo3UILogicLabel() != null)) {
            iDataObject.set(FIELD_NO3UILOGICLABEL, (Object)pSUIEngineTypeBase.getNo3UILogicLabel());
        }
        if (pSUIEngineTypeBase.isNo4UICtrlFlagDirty() && (bl || pSUIEngineTypeBase.getNo4UICtrlFlag() != null)) {
            iDataObject.set(FIELD_NO4UICTRLFLAG, (Object)pSUIEngineTypeBase.getNo4UICtrlFlag());
        }
        if (pSUIEngineTypeBase.isNo4UICtrlLabelDirty() && (bl || pSUIEngineTypeBase.getNo4UICtrlLabel() != null)) {
            iDataObject.set(FIELD_NO4UICTRLLABEL, (Object)pSUIEngineTypeBase.getNo4UICtrlLabel());
        }
        if (pSUIEngineTypeBase.isNo4UILogicFlagDirty() && (bl || pSUIEngineTypeBase.getNo4UILogicFlag() != null)) {
            iDataObject.set(FIELD_NO4UILOGICFLAG, (Object)pSUIEngineTypeBase.getNo4UILogicFlag());
        }
        if (pSUIEngineTypeBase.isNo4UILogicLabelDirty() && (bl || pSUIEngineTypeBase.getNo4UILogicLabel() != null)) {
            iDataObject.set(FIELD_NO4UILOGICLABEL, (Object)pSUIEngineTypeBase.getNo4UILogicLabel());
        }
        if (pSUIEngineTypeBase.isPanelEngineObjDirty() && (bl || pSUIEngineTypeBase.getPanelEngineObj() != null)) {
            iDataObject.set(FIELD_PANELENGINEOBJ, (Object)pSUIEngineTypeBase.getPanelEngineObj());
        }
        if (pSUIEngineTypeBase.isPSUIEngineTypeIdDirty() && (bl || pSUIEngineTypeBase.getPSUIEngineTypeId() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEID, (Object)pSUIEngineTypeBase.getPSUIEngineTypeId());
        }
        if (pSUIEngineTypeBase.isPSUIEngineTypeNameDirty() && (bl || pSUIEngineTypeBase.getPSUIEngineTypeName() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPENAME, (Object)pSUIEngineTypeBase.getPSUIEngineTypeName());
        }
        if (pSUIEngineTypeBase.isTypeCodeDirty() && (bl || pSUIEngineTypeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSUIEngineTypeBase.getTypeCode());
        }
        if (pSUIEngineTypeBase.isTypeObjDirty() && (bl || pSUIEngineTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSUIEngineTypeBase.getTypeObj());
        }
        if (pSUIEngineTypeBase.isUICtrlFlagDirty() && (bl || pSUIEngineTypeBase.getUICtrlFlag() != null)) {
            iDataObject.set(FIELD_UICTRLFLAG, (Object)pSUIEngineTypeBase.getUICtrlFlag());
        }
        if (pSUIEngineTypeBase.isUICtrlLabelDirty() && (bl || pSUIEngineTypeBase.getUICtrlLabel() != null)) {
            iDataObject.set(FIELD_UICTRLLABEL, (Object)pSUIEngineTypeBase.getUICtrlLabel());
        }
        if (pSUIEngineTypeBase.isUILogicFlagDirty() && (bl || pSUIEngineTypeBase.getUILogicFlag() != null)) {
            iDataObject.set(FIELD_UILOGICFLAG, (Object)pSUIEngineTypeBase.getUILogicFlag());
        }
        if (pSUIEngineTypeBase.isUILogicLabelDirty() && (bl || pSUIEngineTypeBase.getUILogicLabel() != null)) {
            iDataObject.set(FIELD_UILOGICLABEL, (Object)pSUIEngineTypeBase.getUILogicLabel());
        }
        if (pSUIEngineTypeBase.isUpdateDateDirty() && (bl || pSUIEngineTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUIEngineTypeBase.getUpdateDate());
        }
        if (pSUIEngineTypeBase.isUpdateManDirty() && (bl || pSUIEngineTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUIEngineTypeBase.getUpdateMan());
        }
        if (pSUIEngineTypeBase.isUtilParamsDirty() && (bl || pSUIEngineTypeBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSUIEngineTypeBase.getUtilParams());
        }
        if (pSUIEngineTypeBase.isValidFlagDirty() && (bl || pSUIEngineTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUIEngineTypeBase.getValidFlag());
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
        return PSUIEngineTypeBase.remove(this, n);
    }

    private static boolean remove(PSUIEngineTypeBase pSUIEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUIEngineTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUIEngineTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUIEngineTypeBase.resetEngineCat();
                return true;
            }
            case 3: {
                pSUIEngineTypeBase.resetEngineObj();
                return true;
            }
            case 4: {
                pSUIEngineTypeBase.resetEngineParam10Flag();
                return true;
            }
            case 5: {
                pSUIEngineTypeBase.resetEngineParam10Label();
                return true;
            }
            case 6: {
                pSUIEngineTypeBase.resetEngineParam2Flag();
                return true;
            }
            case 7: {
                pSUIEngineTypeBase.resetEngineParam2Label();
                return true;
            }
            case 8: {
                pSUIEngineTypeBase.resetEngineParam3Flag();
                return true;
            }
            case 9: {
                pSUIEngineTypeBase.resetEngineParam3Label();
                return true;
            }
            case 10: {
                pSUIEngineTypeBase.resetEngineParam4Flag();
                return true;
            }
            case 11: {
                pSUIEngineTypeBase.resetEngineParam4Label();
                return true;
            }
            case 12: {
                pSUIEngineTypeBase.resetEngineParam5Flag();
                return true;
            }
            case 13: {
                pSUIEngineTypeBase.resetEngineParam5Label();
                return true;
            }
            case 14: {
                pSUIEngineTypeBase.resetEngineParam6Flag();
                return true;
            }
            case 15: {
                pSUIEngineTypeBase.resetEngineParam6Label();
                return true;
            }
            case 16: {
                pSUIEngineTypeBase.resetEngineParam7Flag();
                return true;
            }
            case 17: {
                pSUIEngineTypeBase.resetEngineParam7Label();
                return true;
            }
            case 18: {
                pSUIEngineTypeBase.resetEngineParam8Flag();
                return true;
            }
            case 19: {
                pSUIEngineTypeBase.resetEngineParam8Label();
                return true;
            }
            case 20: {
                pSUIEngineTypeBase.resetEngineParam9Flag();
                return true;
            }
            case 21: {
                pSUIEngineTypeBase.resetEngineParam9Label();
                return true;
            }
            case 22: {
                pSUIEngineTypeBase.resetEngineParamFlag();
                return true;
            }
            case 23: {
                pSUIEngineTypeBase.resetEngineParamLabel();
                return true;
            }
            case 24: {
                pSUIEngineTypeBase.resetLogicName();
                return true;
            }
            case 25: {
                pSUIEngineTypeBase.resetMemo();
                return true;
            }
            case 26: {
                pSUIEngineTypeBase.resetNo2UICtrlFlag();
                return true;
            }
            case 27: {
                pSUIEngineTypeBase.resetNo2UICtrlLabel();
                return true;
            }
            case 28: {
                pSUIEngineTypeBase.resetNo2UILogicFlag();
                return true;
            }
            case 29: {
                pSUIEngineTypeBase.resetNo2UILogicLabel();
                return true;
            }
            case 30: {
                pSUIEngineTypeBase.resetNo3UICtrlFlag();
                return true;
            }
            case 31: {
                pSUIEngineTypeBase.resetNo3UICtrlLabel();
                return true;
            }
            case 32: {
                pSUIEngineTypeBase.resetNo3UILogicFlag();
                return true;
            }
            case 33: {
                pSUIEngineTypeBase.resetNo3UILogicLabel();
                return true;
            }
            case 34: {
                pSUIEngineTypeBase.resetNo4UICtrlFlag();
                return true;
            }
            case 35: {
                pSUIEngineTypeBase.resetNo4UICtrlLabel();
                return true;
            }
            case 36: {
                pSUIEngineTypeBase.resetNo4UILogicFlag();
                return true;
            }
            case 37: {
                pSUIEngineTypeBase.resetNo4UILogicLabel();
                return true;
            }
            case 38: {
                pSUIEngineTypeBase.resetPanelEngineObj();
                return true;
            }
            case 39: {
                pSUIEngineTypeBase.resetPSUIEngineTypeId();
                return true;
            }
            case 40: {
                pSUIEngineTypeBase.resetPSUIEngineTypeName();
                return true;
            }
            case 41: {
                pSUIEngineTypeBase.resetTypeCode();
                return true;
            }
            case 42: {
                pSUIEngineTypeBase.resetTypeObj();
                return true;
            }
            case 43: {
                pSUIEngineTypeBase.resetUICtrlFlag();
                return true;
            }
            case 44: {
                pSUIEngineTypeBase.resetUICtrlLabel();
                return true;
            }
            case 45: {
                pSUIEngineTypeBase.resetUILogicFlag();
                return true;
            }
            case 46: {
                pSUIEngineTypeBase.resetUILogicLabel();
                return true;
            }
            case 47: {
                pSUIEngineTypeBase.resetUpdateDate();
                return true;
            }
            case 48: {
                pSUIEngineTypeBase.resetUpdateMan();
                return true;
            }
            case 49: {
                pSUIEngineTypeBase.resetUtilParams();
                return true;
            }
            case 50: {
                pSUIEngineTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUIEngineTypeParam> getPSUIEngineTypeParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeParams();
        }
        if (this.getPSUIEngineTypeId() == null) {
            return null;
        }
        PSUIEngineTypeParamService pSUIEngineTypeParamService = (PSUIEngineTypeParamService)ServiceGlobal.getService(PSUIEngineTypeParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUIEngineTypeParamsLock;
        synchronized (n) {
            if (this.psuienginetypeparams == null) {
                this.psuienginetypeparams = pSUIEngineTypeParamService.selectByPSUIEngineType(this);
            }
            return this.psuienginetypeparams;
        }
    }

    private PSUIEngineTypeBase getProxyEntity() {
        return this.proxyPSUIEngineTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUIEngineTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSUIEngineTypeBase) {
            this.proxyPSUIEngineTypeBase = (PSUIEngineTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENGINECAT, 2);
        fieldIndexMap.put(FIELD_ENGINEOBJ, 3);
        fieldIndexMap.put(FIELD_ENGINEPARAM10FLAG, 4);
        fieldIndexMap.put(FIELD_ENGINEPARAM10LABEL, 5);
        fieldIndexMap.put(FIELD_ENGINEPARAM2FLAG, 6);
        fieldIndexMap.put(FIELD_ENGINEPARAM2LABEL, 7);
        fieldIndexMap.put(FIELD_ENGINEPARAM3FLAG, 8);
        fieldIndexMap.put(FIELD_ENGINEPARAM3LABEL, 9);
        fieldIndexMap.put(FIELD_ENGINEPARAM4FLAG, 10);
        fieldIndexMap.put(FIELD_ENGINEPARAM4LABEL, 11);
        fieldIndexMap.put(FIELD_ENGINEPARAM5FLAG, 12);
        fieldIndexMap.put(FIELD_ENGINEPARAM5LABEL, 13);
        fieldIndexMap.put(FIELD_ENGINEPARAM6FLAG, 14);
        fieldIndexMap.put(FIELD_ENGINEPARAM6LABEL, 15);
        fieldIndexMap.put(FIELD_ENGINEPARAM7FLAG, 16);
        fieldIndexMap.put(FIELD_ENGINEPARAM7LABEL, 17);
        fieldIndexMap.put(FIELD_ENGINEPARAM8FLAG, 18);
        fieldIndexMap.put(FIELD_ENGINEPARAM8LABEL, 19);
        fieldIndexMap.put(FIELD_ENGINEPARAM9FLAG, 20);
        fieldIndexMap.put(FIELD_ENGINEPARAM9LABEL, 21);
        fieldIndexMap.put(FIELD_ENGINEPARAMFLAG, 22);
        fieldIndexMap.put(FIELD_ENGINEPARAMLABEL, 23);
        fieldIndexMap.put(FIELD_LOGICNAME, 24);
        fieldIndexMap.put(FIELD_MEMO, 25);
        fieldIndexMap.put(FIELD_NO2UICTRLFLAG, 26);
        fieldIndexMap.put(FIELD_NO2UICTRLLABEL, 27);
        fieldIndexMap.put(FIELD_NO2UILOGICFLAG, 28);
        fieldIndexMap.put(FIELD_NO2UILOGICLABEL, 29);
        fieldIndexMap.put(FIELD_NO3UICTRLFLAG, 30);
        fieldIndexMap.put(FIELD_NO3UICTRLLABEL, 31);
        fieldIndexMap.put(FIELD_NO3UILOGICFLAG, 32);
        fieldIndexMap.put(FIELD_NO3UILOGICLABEL, 33);
        fieldIndexMap.put(FIELD_NO4UICTRLFLAG, 34);
        fieldIndexMap.put(FIELD_NO4UICTRLLABEL, 35);
        fieldIndexMap.put(FIELD_NO4UILOGICFLAG, 36);
        fieldIndexMap.put(FIELD_NO4UILOGICLABEL, 37);
        fieldIndexMap.put(FIELD_PANELENGINEOBJ, 38);
        fieldIndexMap.put(FIELD_PSUIENGINETYPEID, 39);
        fieldIndexMap.put(FIELD_PSUIENGINETYPENAME, 40);
        fieldIndexMap.put(FIELD_TYPECODE, 41);
        fieldIndexMap.put(FIELD_TYPEOBJ, 42);
        fieldIndexMap.put(FIELD_UICTRLFLAG, 43);
        fieldIndexMap.put(FIELD_UICTRLLABEL, 44);
        fieldIndexMap.put(FIELD_UILOGICFLAG, 45);
        fieldIndexMap.put(FIELD_UILOGICLABEL, 46);
        fieldIndexMap.put(FIELD_UPDATEDATE, 47);
        fieldIndexMap.put(FIELD_UPDATEMAN, 48);
        fieldIndexMap.put(FIELD_UTILPARAMS, 49);
        fieldIndexMap.put(FIELD_VALIDFLAG, 50);
    }
}

