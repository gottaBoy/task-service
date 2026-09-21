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

public abstract class PSUAWizard3Base
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUAWizard3Base.class);
    public static final String FIELD_ACTIONRESULT = "ACTIONRESULT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVSERVERCOUNT = "DEVSERVERCOUNT";
    public static final String FIELD_DEVSLNCODENAME = "DEVSLNCODENAME";
    public static final String FIELD_DEVSLNCOUNT = "DEVSLNCOUNT";
    public static final String FIELD_DEVSLNNAME = "DEVSLNNAME";
    public static final String FIELD_MSSQLINSTCOUNT = "MSSQLINSTCOUNT";
    public static final String FIELD_MYSQL5INSTCOUNT = "MYSQL5INSTCOUNT";
    public static final String FIELD_ORAINSTCOUNT = "ORAINSTCOUNT";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSUAWIZARD3ID = "PSUAWIZARD3ID";
    public static final String FIELD_PSUAWIZARD3NAME = "PSUAWIZARD3NAME";
    public static final String FIELD_TOMCAT7ASCOUNT = "TOMCAT7ASCOUNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCOUNTPERSYS = "USERCOUNTPERSYS";
    public static final String FIELD_USERLOGINNAME = "USERLOGINNAME";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_ACTIONRESULT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEVSERVERCOUNT = 3;
    private static final int INDEX_DEVSLNCODENAME = 4;
    private static final int INDEX_DEVSLNCOUNT = 5;
    private static final int INDEX_DEVSLNNAME = 6;
    private static final int INDEX_MSSQLINSTCOUNT = 7;
    private static final int INDEX_MYSQL5INSTCOUNT = 8;
    private static final int INDEX_ORAINSTCOUNT = 9;
    private static final int INDEX_PSDSCONSOLEID = 10;
    private static final int INDEX_PSUAWIZARD3ID = 11;
    private static final int INDEX_PSUAWIZARD3NAME = 12;
    private static final int INDEX_TOMCAT7ASCOUNT = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCOUNTPERSYS = 16;
    private static final int INDEX_USERLOGINNAME = 17;
    private static final int INDEX_USERNAME = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUAWizard3Base proxyPSUAWizard3Base = null;
    private boolean actionresultDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devservercountDirtyFlag = false;
    private boolean devslncodenameDirtyFlag = false;
    private boolean devslncountDirtyFlag = false;
    private boolean devslnnameDirtyFlag = false;
    private boolean mssqlinstcountDirtyFlag = false;
    private boolean mysql5instcountDirtyFlag = false;
    private boolean orainstcountDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psuawizard3idDirtyFlag = false;
    private boolean psuawizard3nameDirtyFlag = false;
    private boolean tomcat7ascountDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercountpersysDirtyFlag = false;
    private boolean userloginnameDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="actionresult")
    private String actionresult;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devservercount")
    private Integer devservercount;
    @Column(name="devslncodename")
    private String devslncodename;
    @Column(name="devslncount")
    private Integer devslncount;
    @Column(name="devslnname")
    private String devslnname;
    @Column(name="mssqlinstcount")
    private Integer mssqlinstcount;
    @Column(name="mysql5instcount")
    private Integer mysql5instcount;
    @Column(name="orainstcount")
    private Integer orainstcount;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psuawizard3id")
    private String psuawizard3id;
    @Column(name="psuawizard3name")
    private String psuawizard3name;
    @Column(name="tomcat7ascount")
    private Integer tomcat7ascount;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercountpersys")
    private Integer usercountpersys;
    @Column(name="userloginname")
    private String userloginname;
    @Column(name="username")
    private String username;

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

    public void setDevServerCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevServerCount(n);
            return;
        }
        this.devservercount = n;
        this.devservercountDirtyFlag = true;
    }

    public Integer getDevServerCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevServerCount();
        }
        return this.devservercount;
    }

    public boolean isDevServerCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevServerCountDirty();
        }
        return this.devservercountDirtyFlag;
    }

    public void resetDevServerCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevServerCount();
            return;
        }
        this.devservercountDirtyFlag = false;
        this.devservercount = null;
    }

    public void setDevSlnCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSlnCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devslncodename = string;
        this.devslncodenameDirtyFlag = true;
    }

    public String getDevSlnCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSlnCodeName();
        }
        return this.devslncodename;
    }

    public boolean isDevSlnCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSlnCodeNameDirty();
        }
        return this.devslncodenameDirtyFlag;
    }

    public void resetDevSlnCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSlnCodeName();
            return;
        }
        this.devslncodenameDirtyFlag = false;
        this.devslncodename = null;
    }

    public void setDevSlnCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSlnCount(n);
            return;
        }
        this.devslncount = n;
        this.devslncountDirtyFlag = true;
    }

    public Integer getDevSlnCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSlnCount();
        }
        return this.devslncount;
    }

    public boolean isDevSlnCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSlnCountDirty();
        }
        return this.devslncountDirtyFlag;
    }

    public void resetDevSlnCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSlnCount();
            return;
        }
        this.devslncountDirtyFlag = false;
        this.devslncount = null;
    }

    public void setDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.devslnname = string;
        this.devslnnameDirtyFlag = true;
    }

    public String getDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSlnName();
        }
        return this.devslnname;
    }

    public boolean isDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSlnNameDirty();
        }
        return this.devslnnameDirtyFlag;
    }

    public void resetDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSlnName();
            return;
        }
        this.devslnnameDirtyFlag = false;
        this.devslnname = null;
    }

    public void setMSSqlInstCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSqlInstCount(n);
            return;
        }
        this.mssqlinstcount = n;
        this.mssqlinstcountDirtyFlag = true;
    }

    public Integer getMSSqlInstCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSqlInstCount();
        }
        return this.mssqlinstcount;
    }

    public boolean isMSSqlInstCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSqlInstCountDirty();
        }
        return this.mssqlinstcountDirtyFlag;
    }

    public void resetMSSqlInstCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSqlInstCount();
            return;
        }
        this.mssqlinstcountDirtyFlag = false;
        this.mssqlinstcount = null;
    }

    public void setMySQL5InstCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQL5InstCount(n);
            return;
        }
        this.mysql5instcount = n;
        this.mysql5instcountDirtyFlag = true;
    }

    public Integer getMySQL5InstCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQL5InstCount();
        }
        return this.mysql5instcount;
    }

    public boolean isMySQL5InstCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQL5InstCountDirty();
        }
        return this.mysql5instcountDirtyFlag;
    }

    public void resetMySQL5InstCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQL5InstCount();
            return;
        }
        this.mysql5instcountDirtyFlag = false;
        this.mysql5instcount = null;
    }

    public void setOraInstCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOraInstCount(n);
            return;
        }
        this.orainstcount = n;
        this.orainstcountDirtyFlag = true;
    }

    public Integer getOraInstCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraInstCount();
        }
        return this.orainstcount;
    }

    public boolean isOraInstCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOraInstCountDirty();
        }
        return this.orainstcountDirtyFlag;
    }

    public void resetOraInstCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOraInstCount();
            return;
        }
        this.orainstcountDirtyFlag = false;
        this.orainstcount = null;
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

    public void setPSUAWizard3Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizard3Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizard3id = string;
        this.psuawizard3idDirtyFlag = true;
    }

    public String getPSUAWizard3Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizard3Id();
        }
        return this.psuawizard3id;
    }

    public boolean isPSUAWizard3IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizard3IdDirty();
        }
        return this.psuawizard3idDirtyFlag;
    }

    public void resetPSUAWizard3Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizard3Id();
            return;
        }
        this.psuawizard3idDirtyFlag = false;
        this.psuawizard3id = null;
    }

    public void setPSUAWizard3Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizard3Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizard3name = string;
        this.psuawizard3nameDirtyFlag = true;
    }

    public String getPSUAWizard3Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizard3Name();
        }
        return this.psuawizard3name;
    }

    public boolean isPSUAWizard3NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizard3NameDirty();
        }
        return this.psuawizard3nameDirtyFlag;
    }

    public void resetPSUAWizard3Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizard3Name();
            return;
        }
        this.psuawizard3nameDirtyFlag = false;
        this.psuawizard3name = null;
    }

    public void setTomcat7ASCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTomcat7ASCount(n);
            return;
        }
        this.tomcat7ascount = n;
        this.tomcat7ascountDirtyFlag = true;
    }

    public Integer getTomcat7ASCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTomcat7ASCount();
        }
        return this.tomcat7ascount;
    }

    public boolean isTomcat7ASCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTomcat7ASCountDirty();
        }
        return this.tomcat7ascountDirtyFlag;
    }

    public void resetTomcat7ASCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTomcat7ASCount();
            return;
        }
        this.tomcat7ascountDirtyFlag = false;
        this.tomcat7ascount = null;
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

    public void setUserCountPerSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCountPerSys(n);
            return;
        }
        this.usercountpersys = n;
        this.usercountpersysDirtyFlag = true;
    }

    public Integer getUserCountPerSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCountPerSys();
        }
        return this.usercountpersys;
    }

    public boolean isUserCountPerSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCountPerSysDirty();
        }
        return this.usercountpersysDirtyFlag;
    }

    public void resetUserCountPerSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCountPerSys();
            return;
        }
        this.usercountpersysDirtyFlag = false;
        this.usercountpersys = null;
    }

    public void setUserLoginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserLoginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userloginname = string;
        this.userloginnameDirtyFlag = true;
    }

    public String getUserLoginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserLoginName();
        }
        return this.userloginname;
    }

    public boolean isUserLoginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserLoginNameDirty();
        }
        return this.userloginnameDirtyFlag;
    }

    public void resetUserLoginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserLoginName();
            return;
        }
        this.userloginnameDirtyFlag = false;
        this.userloginname = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
    }

    protected void onReset() {
        PSUAWizard3Base.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUAWizard3Base pSUAWizard3Base) {
        pSUAWizard3Base.resetActionResult();
        pSUAWizard3Base.resetCreateDate();
        pSUAWizard3Base.resetCreateMan();
        pSUAWizard3Base.resetDevServerCount();
        pSUAWizard3Base.resetDevSlnCodeName();
        pSUAWizard3Base.resetDevSlnCount();
        pSUAWizard3Base.resetDevSlnName();
        pSUAWizard3Base.resetMSSqlInstCount();
        pSUAWizard3Base.resetMySQL5InstCount();
        pSUAWizard3Base.resetOraInstCount();
        pSUAWizard3Base.resetPSDSConsoleId();
        pSUAWizard3Base.resetPSUAWizard3Id();
        pSUAWizard3Base.resetPSUAWizard3Name();
        pSUAWizard3Base.resetTomcat7ASCount();
        pSUAWizard3Base.resetUpdateDate();
        pSUAWizard3Base.resetUpdateMan();
        pSUAWizard3Base.resetUserCountPerSys();
        pSUAWizard3Base.resetUserLoginName();
        pSUAWizard3Base.resetUserName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionResultDirty()) {
            hashMap.put(FIELD_ACTIONRESULT, this.getActionResult());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDevServerCountDirty()) {
            hashMap.put(FIELD_DEVSERVERCOUNT, this.getDevServerCount());
        }
        if (!bl || this.isDevSlnCodeNameDirty()) {
            hashMap.put(FIELD_DEVSLNCODENAME, this.getDevSlnCodeName());
        }
        if (!bl || this.isDevSlnCountDirty()) {
            hashMap.put(FIELD_DEVSLNCOUNT, this.getDevSlnCount());
        }
        if (!bl || this.isDevSlnNameDirty()) {
            hashMap.put(FIELD_DEVSLNNAME, this.getDevSlnName());
        }
        if (!bl || this.isMSSqlInstCountDirty()) {
            hashMap.put(FIELD_MSSQLINSTCOUNT, this.getMSSqlInstCount());
        }
        if (!bl || this.isMySQL5InstCountDirty()) {
            hashMap.put(FIELD_MYSQL5INSTCOUNT, this.getMySQL5InstCount());
        }
        if (!bl || this.isOraInstCountDirty()) {
            hashMap.put(FIELD_ORAINSTCOUNT, this.getOraInstCount());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSUAWizard3IdDirty()) {
            hashMap.put(FIELD_PSUAWIZARD3ID, this.getPSUAWizard3Id());
        }
        if (!bl || this.isPSUAWizard3NameDirty()) {
            hashMap.put(FIELD_PSUAWIZARD3NAME, this.getPSUAWizard3Name());
        }
        if (!bl || this.isTomcat7ASCountDirty()) {
            hashMap.put(FIELD_TOMCAT7ASCOUNT, this.getTomcat7ASCount());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCountPerSysDirty()) {
            hashMap.put(FIELD_USERCOUNTPERSYS, this.getUserCountPerSys());
        }
        if (!bl || this.isUserLoginNameDirty()) {
            hashMap.put(FIELD_USERLOGINNAME, this.getUserLoginName());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSUAWizard3Base.get(this, n);
    }

    private static Object get(PSUAWizard3Base pSUAWizard3Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard3Base.getActionResult();
            }
            case 1: {
                return pSUAWizard3Base.getCreateDate();
            }
            case 2: {
                return pSUAWizard3Base.getCreateMan();
            }
            case 3: {
                return pSUAWizard3Base.getDevServerCount();
            }
            case 4: {
                return pSUAWizard3Base.getDevSlnCodeName();
            }
            case 5: {
                return pSUAWizard3Base.getDevSlnCount();
            }
            case 6: {
                return pSUAWizard3Base.getDevSlnName();
            }
            case 7: {
                return pSUAWizard3Base.getMSSqlInstCount();
            }
            case 8: {
                return pSUAWizard3Base.getMySQL5InstCount();
            }
            case 9: {
                return pSUAWizard3Base.getOraInstCount();
            }
            case 10: {
                return pSUAWizard3Base.getPSDSConsoleId();
            }
            case 11: {
                return pSUAWizard3Base.getPSUAWizard3Id();
            }
            case 12: {
                return pSUAWizard3Base.getPSUAWizard3Name();
            }
            case 13: {
                return pSUAWizard3Base.getTomcat7ASCount();
            }
            case 14: {
                return pSUAWizard3Base.getUpdateDate();
            }
            case 15: {
                return pSUAWizard3Base.getUpdateMan();
            }
            case 16: {
                return pSUAWizard3Base.getUserCountPerSys();
            }
            case 17: {
                return pSUAWizard3Base.getUserLoginName();
            }
            case 18: {
                return pSUAWizard3Base.getUserName();
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
        PSUAWizard3Base.set(this, n, object);
    }

    private static void set(PSUAWizard3Base pSUAWizard3Base, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUAWizard3Base.setActionResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUAWizard3Base.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUAWizard3Base.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUAWizard3Base.setDevServerCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSUAWizard3Base.setDevSlnCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUAWizard3Base.setDevSlnCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUAWizard3Base.setDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUAWizard3Base.setMSSqlInstCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSUAWizard3Base.setMySQL5InstCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSUAWizard3Base.setOraInstCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSUAWizard3Base.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUAWizard3Base.setPSUAWizard3Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUAWizard3Base.setPSUAWizard3Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUAWizard3Base.setTomcat7ASCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSUAWizard3Base.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSUAWizard3Base.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUAWizard3Base.setUserCountPerSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSUAWizard3Base.setUserLoginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUAWizard3Base.setUserName(DataObject.getStringValue((Object)object));
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
        return PSUAWizard3Base.isNull(this, n);
    }

    private static boolean isNull(PSUAWizard3Base pSUAWizard3Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard3Base.getActionResult() == null;
            }
            case 1: {
                return pSUAWizard3Base.getCreateDate() == null;
            }
            case 2: {
                return pSUAWizard3Base.getCreateMan() == null;
            }
            case 3: {
                return pSUAWizard3Base.getDevServerCount() == null;
            }
            case 4: {
                return pSUAWizard3Base.getDevSlnCodeName() == null;
            }
            case 5: {
                return pSUAWizard3Base.getDevSlnCount() == null;
            }
            case 6: {
                return pSUAWizard3Base.getDevSlnName() == null;
            }
            case 7: {
                return pSUAWizard3Base.getMSSqlInstCount() == null;
            }
            case 8: {
                return pSUAWizard3Base.getMySQL5InstCount() == null;
            }
            case 9: {
                return pSUAWizard3Base.getOraInstCount() == null;
            }
            case 10: {
                return pSUAWizard3Base.getPSDSConsoleId() == null;
            }
            case 11: {
                return pSUAWizard3Base.getPSUAWizard3Id() == null;
            }
            case 12: {
                return pSUAWizard3Base.getPSUAWizard3Name() == null;
            }
            case 13: {
                return pSUAWizard3Base.getTomcat7ASCount() == null;
            }
            case 14: {
                return pSUAWizard3Base.getUpdateDate() == null;
            }
            case 15: {
                return pSUAWizard3Base.getUpdateMan() == null;
            }
            case 16: {
                return pSUAWizard3Base.getUserCountPerSys() == null;
            }
            case 17: {
                return pSUAWizard3Base.getUserLoginName() == null;
            }
            case 18: {
                return pSUAWizard3Base.getUserName() == null;
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
        return PSUAWizard3Base.contains(this, n);
    }

    private static boolean contains(PSUAWizard3Base pSUAWizard3Base, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAWizard3Base.isActionResultDirty();
            }
            case 1: {
                return pSUAWizard3Base.isCreateDateDirty();
            }
            case 2: {
                return pSUAWizard3Base.isCreateManDirty();
            }
            case 3: {
                return pSUAWizard3Base.isDevServerCountDirty();
            }
            case 4: {
                return pSUAWizard3Base.isDevSlnCodeNameDirty();
            }
            case 5: {
                return pSUAWizard3Base.isDevSlnCountDirty();
            }
            case 6: {
                return pSUAWizard3Base.isDevSlnNameDirty();
            }
            case 7: {
                return pSUAWizard3Base.isMSSqlInstCountDirty();
            }
            case 8: {
                return pSUAWizard3Base.isMySQL5InstCountDirty();
            }
            case 9: {
                return pSUAWizard3Base.isOraInstCountDirty();
            }
            case 10: {
                return pSUAWizard3Base.isPSDSConsoleIdDirty();
            }
            case 11: {
                return pSUAWizard3Base.isPSUAWizard3IdDirty();
            }
            case 12: {
                return pSUAWizard3Base.isPSUAWizard3NameDirty();
            }
            case 13: {
                return pSUAWizard3Base.isTomcat7ASCountDirty();
            }
            case 14: {
                return pSUAWizard3Base.isUpdateDateDirty();
            }
            case 15: {
                return pSUAWizard3Base.isUpdateManDirty();
            }
            case 16: {
                return pSUAWizard3Base.isUserCountPerSysDirty();
            }
            case 17: {
                return pSUAWizard3Base.isUserLoginNameDirty();
            }
            case 18: {
                return pSUAWizard3Base.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUAWizard3Base.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUAWizard3Base pSUAWizard3Base, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUAWizard3Base.getActionResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionresult", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getActionResult()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getCreateDate()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getCreateMan()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getDevServerCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devservercount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getDevServerCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getDevSlnCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devslncodename", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getDevSlnCodeName()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getDevSlnCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devslncount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getDevSlnCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devslnname", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getDevSlnName()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getMSSqlInstCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqlinstcount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getMSSqlInstCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getMySQL5InstCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysql5instcount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getMySQL5InstCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getOraInstCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orainstcount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getOraInstCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getPSUAWizard3Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizard3id", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getPSUAWizard3Id()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getPSUAWizard3Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizard3name", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getPSUAWizard3Name()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getTomcat7ASCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tomcat7ascount", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getTomcat7ASCount()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getUserCountPerSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercountpersys", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getUserCountPerSys()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getUserLoginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userloginname", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getUserLoginName()), (boolean)false);
        }
        if (bl || pSUAWizard3Base.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSUAWizard3Base.getJSONValue((Object)pSUAWizard3Base.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUAWizard3Base.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUAWizard3Base pSUAWizard3Base, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUAWizard3Base.getActionResult() != null) {
            object = pSUAWizard3Base.getActionResult();
            xmlNode.setAttribute(FIELD_ACTIONRESULT, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getCreateDate() != null) {
            object = pSUAWizard3Base.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard3Base.getCreateMan() != null) {
            object = pSUAWizard3Base.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getDevServerCount() != null) {
            object = pSUAWizard3Base.getDevServerCount();
            xmlNode.setAttribute(FIELD_DEVSERVERCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getDevSlnCodeName() != null) {
            object = pSUAWizard3Base.getDevSlnCodeName();
            xmlNode.setAttribute(FIELD_DEVSLNCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getDevSlnCount() != null) {
            object = pSUAWizard3Base.getDevSlnCount();
            xmlNode.setAttribute(FIELD_DEVSLNCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getDevSlnName() != null) {
            object = pSUAWizard3Base.getDevSlnName();
            xmlNode.setAttribute(FIELD_DEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getMSSqlInstCount() != null) {
            object = pSUAWizard3Base.getMSSqlInstCount();
            xmlNode.setAttribute(FIELD_MSSQLINSTCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getMySQL5InstCount() != null) {
            object = pSUAWizard3Base.getMySQL5InstCount();
            xmlNode.setAttribute(FIELD_MYSQL5INSTCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getOraInstCount() != null) {
            object = pSUAWizard3Base.getOraInstCount();
            xmlNode.setAttribute(FIELD_ORAINSTCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getPSDSConsoleId() != null) {
            object = pSUAWizard3Base.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getPSUAWizard3Id() != null) {
            object = pSUAWizard3Base.getPSUAWizard3Id();
            xmlNode.setAttribute(FIELD_PSUAWIZARD3ID, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getPSUAWizard3Name() != null) {
            object = pSUAWizard3Base.getPSUAWizard3Name();
            xmlNode.setAttribute(FIELD_PSUAWIZARD3NAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getTomcat7ASCount() != null) {
            object = pSUAWizard3Base.getTomcat7ASCount();
            xmlNode.setAttribute(FIELD_TOMCAT7ASCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getUpdateDate() != null) {
            object = pSUAWizard3Base.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAWizard3Base.getUpdateMan() != null) {
            object = pSUAWizard3Base.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getUserCountPerSys() != null) {
            object = pSUAWizard3Base.getUserCountPerSys();
            xmlNode.setAttribute(FIELD_USERCOUNTPERSYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUAWizard3Base.getUserLoginName() != null) {
            object = pSUAWizard3Base.getUserLoginName();
            xmlNode.setAttribute(FIELD_USERLOGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAWizard3Base.getUserName() != null) {
            object = pSUAWizard3Base.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUAWizard3Base.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUAWizard3Base pSUAWizard3Base, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUAWizard3Base.isActionResultDirty() && (bl || pSUAWizard3Base.getActionResult() != null)) {
            iDataObject.set(FIELD_ACTIONRESULT, (Object)pSUAWizard3Base.getActionResult());
        }
        if (pSUAWizard3Base.isCreateDateDirty() && (bl || pSUAWizard3Base.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUAWizard3Base.getCreateDate());
        }
        if (pSUAWizard3Base.isCreateManDirty() && (bl || pSUAWizard3Base.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUAWizard3Base.getCreateMan());
        }
        if (pSUAWizard3Base.isDevServerCountDirty() && (bl || pSUAWizard3Base.getDevServerCount() != null)) {
            iDataObject.set(FIELD_DEVSERVERCOUNT, (Object)pSUAWizard3Base.getDevServerCount());
        }
        if (pSUAWizard3Base.isDevSlnCodeNameDirty() && (bl || pSUAWizard3Base.getDevSlnCodeName() != null)) {
            iDataObject.set(FIELD_DEVSLNCODENAME, (Object)pSUAWizard3Base.getDevSlnCodeName());
        }
        if (pSUAWizard3Base.isDevSlnCountDirty() && (bl || pSUAWizard3Base.getDevSlnCount() != null)) {
            iDataObject.set(FIELD_DEVSLNCOUNT, (Object)pSUAWizard3Base.getDevSlnCount());
        }
        if (pSUAWizard3Base.isDevSlnNameDirty() && (bl || pSUAWizard3Base.getDevSlnName() != null)) {
            iDataObject.set(FIELD_DEVSLNNAME, (Object)pSUAWizard3Base.getDevSlnName());
        }
        if (pSUAWizard3Base.isMSSqlInstCountDirty() && (bl || pSUAWizard3Base.getMSSqlInstCount() != null)) {
            iDataObject.set(FIELD_MSSQLINSTCOUNT, (Object)pSUAWizard3Base.getMSSqlInstCount());
        }
        if (pSUAWizard3Base.isMySQL5InstCountDirty() && (bl || pSUAWizard3Base.getMySQL5InstCount() != null)) {
            iDataObject.set(FIELD_MYSQL5INSTCOUNT, (Object)pSUAWizard3Base.getMySQL5InstCount());
        }
        if (pSUAWizard3Base.isOraInstCountDirty() && (bl || pSUAWizard3Base.getOraInstCount() != null)) {
            iDataObject.set(FIELD_ORAINSTCOUNT, (Object)pSUAWizard3Base.getOraInstCount());
        }
        if (pSUAWizard3Base.isPSDSConsoleIdDirty() && (bl || pSUAWizard3Base.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSUAWizard3Base.getPSDSConsoleId());
        }
        if (pSUAWizard3Base.isPSUAWizard3IdDirty() && (bl || pSUAWizard3Base.getPSUAWizard3Id() != null)) {
            iDataObject.set(FIELD_PSUAWIZARD3ID, (Object)pSUAWizard3Base.getPSUAWizard3Id());
        }
        if (pSUAWizard3Base.isPSUAWizard3NameDirty() && (bl || pSUAWizard3Base.getPSUAWizard3Name() != null)) {
            iDataObject.set(FIELD_PSUAWIZARD3NAME, (Object)pSUAWizard3Base.getPSUAWizard3Name());
        }
        if (pSUAWizard3Base.isTomcat7ASCountDirty() && (bl || pSUAWizard3Base.getTomcat7ASCount() != null)) {
            iDataObject.set(FIELD_TOMCAT7ASCOUNT, (Object)pSUAWizard3Base.getTomcat7ASCount());
        }
        if (pSUAWizard3Base.isUpdateDateDirty() && (bl || pSUAWizard3Base.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUAWizard3Base.getUpdateDate());
        }
        if (pSUAWizard3Base.isUpdateManDirty() && (bl || pSUAWizard3Base.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUAWizard3Base.getUpdateMan());
        }
        if (pSUAWizard3Base.isUserCountPerSysDirty() && (bl || pSUAWizard3Base.getUserCountPerSys() != null)) {
            iDataObject.set(FIELD_USERCOUNTPERSYS, (Object)pSUAWizard3Base.getUserCountPerSys());
        }
        if (pSUAWizard3Base.isUserLoginNameDirty() && (bl || pSUAWizard3Base.getUserLoginName() != null)) {
            iDataObject.set(FIELD_USERLOGINNAME, (Object)pSUAWizard3Base.getUserLoginName());
        }
        if (pSUAWizard3Base.isUserNameDirty() && (bl || pSUAWizard3Base.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSUAWizard3Base.getUserName());
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
        return PSUAWizard3Base.remove(this, n);
    }

    private static boolean remove(PSUAWizard3Base pSUAWizard3Base, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUAWizard3Base.resetActionResult();
                return true;
            }
            case 1: {
                pSUAWizard3Base.resetCreateDate();
                return true;
            }
            case 2: {
                pSUAWizard3Base.resetCreateMan();
                return true;
            }
            case 3: {
                pSUAWizard3Base.resetDevServerCount();
                return true;
            }
            case 4: {
                pSUAWizard3Base.resetDevSlnCodeName();
                return true;
            }
            case 5: {
                pSUAWizard3Base.resetDevSlnCount();
                return true;
            }
            case 6: {
                pSUAWizard3Base.resetDevSlnName();
                return true;
            }
            case 7: {
                pSUAWizard3Base.resetMSSqlInstCount();
                return true;
            }
            case 8: {
                pSUAWizard3Base.resetMySQL5InstCount();
                return true;
            }
            case 9: {
                pSUAWizard3Base.resetOraInstCount();
                return true;
            }
            case 10: {
                pSUAWizard3Base.resetPSDSConsoleId();
                return true;
            }
            case 11: {
                pSUAWizard3Base.resetPSUAWizard3Id();
                return true;
            }
            case 12: {
                pSUAWizard3Base.resetPSUAWizard3Name();
                return true;
            }
            case 13: {
                pSUAWizard3Base.resetTomcat7ASCount();
                return true;
            }
            case 14: {
                pSUAWizard3Base.resetUpdateDate();
                return true;
            }
            case 15: {
                pSUAWizard3Base.resetUpdateMan();
                return true;
            }
            case 16: {
                pSUAWizard3Base.resetUserCountPerSys();
                return true;
            }
            case 17: {
                pSUAWizard3Base.resetUserLoginName();
                return true;
            }
            case 18: {
                pSUAWizard3Base.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUAWizard3Base getProxyEntity() {
        return this.proxyPSUAWizard3Base;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUAWizard3Base = null;
        if (iDataObject != null && iDataObject instanceof PSUAWizard3Base) {
            this.proxyPSUAWizard3Base = (PSUAWizard3Base)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard3Service", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONRESULT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEVSERVERCOUNT, 3);
        fieldIndexMap.put(FIELD_DEVSLNCODENAME, 4);
        fieldIndexMap.put(FIELD_DEVSLNCOUNT, 5);
        fieldIndexMap.put(FIELD_DEVSLNNAME, 6);
        fieldIndexMap.put(FIELD_MSSQLINSTCOUNT, 7);
        fieldIndexMap.put(FIELD_MYSQL5INSTCOUNT, 8);
        fieldIndexMap.put(FIELD_ORAINSTCOUNT, 9);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 10);
        fieldIndexMap.put(FIELD_PSUAWIZARD3ID, 11);
        fieldIndexMap.put(FIELD_PSUAWIZARD3NAME, 12);
        fieldIndexMap.put(FIELD_TOMCAT7ASCOUNT, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCOUNTPERSYS, 16);
        fieldIndexMap.put(FIELD_USERLOGINNAME, 17);
        fieldIndexMap.put(FIELD_USERNAME, 18);
    }
}

