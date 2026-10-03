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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataRef;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataRefService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESampleDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESampleDataBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DATA2 = "DATA2";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_LOGICMODE = "LOGICMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESAMPLEDATAID = "PSDESAMPLEDATAID";
    public static final String FIELD_PSDESAMPLEDATANAME = "PSDESAMPLEDATANAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_RANDOMCNT = "RANDOMECNT";
    public static final String FIELD_RANDOMMODE = "RANDOMMODE";
    public static final String FIELD_RANDOMPARAM = "RANDOMPARAM";
    public static final String FIELD_RANDOMPARAM2 = "RANDOMPARAM2";
    public static final String FIELD_RANDOMPARAM3 = "RANDOMPARAM3";
    public static final String FIELD_RANDOMPARAM4 = "RANDOMPARAM4";
    public static final String FIELD_SDTAG = "SDTAG";
    public static final String FIELD_SDTAG2 = "SDTAG2";
    public static final String FIELD_SDTAG3 = "SDTAG3";
    public static final String FIELD_SDTAG4 = "SDTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGE = "USAGE";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_DATA = 5;
    private static final int INDEX_DATA2 = 6;
    private static final int INDEX_DATATYPE = 7;
    private static final int INDEX_LOGICMODE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDEMAINSTATEID = 11;
    private static final int INDEX_PSDEMAINSTATENAME = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSDESAMPLEDATAID = 14;
    private static final int INDEX_PSDESAMPLEDATANAME = 15;
    private static final int INDEX_PSSYSREQITEMID = 16;
    private static final int INDEX_PSSYSREQITEMNAME = 17;
    private static final int INDEX_RANDOMCNT = 18;
    private static final int INDEX_RANDOMMODE = 19;
    private static final int INDEX_RANDOMPARAM = 20;
    private static final int INDEX_RANDOMPARAM2 = 21;
    private static final int INDEX_RANDOMPARAM3 = 22;
    private static final int INDEX_RANDOMPARAM4 = 23;
    private static final int INDEX_SDTAG = 24;
    private static final int INDEX_SDTAG2 = 25;
    private static final int INDEX_SDTAG3 = 26;
    private static final int INDEX_SDTAG4 = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USAGE = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESampleDataBase proxyPSDESampleDataBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean data2DirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean logicmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdesampledataidDirtyFlag = false;
    private boolean psdesampledatanameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean randomcntDirtyFlag = false;
    private boolean randommodeDirtyFlag = false;
    private boolean randomparamDirtyFlag = false;
    private boolean randomparam2DirtyFlag = false;
    private boolean randomparam3DirtyFlag = false;
    private boolean randomparam4DirtyFlag = false;
    private boolean sdtagDirtyFlag = false;
    private boolean sdtag2DirtyFlag = false;
    private boolean sdtag3DirtyFlag = false;
    private boolean sdtag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usageDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="data")
    private String data;
    @Column(name="data2")
    private String data2;
    @Column(name="datatype")
    private String datatype;
    @Column(name="logicmode")
    private String logicmode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdesampledataid")
    private String psdesampledataid;
    @Column(name="psdesampledataname")
    private String psdesampledataname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="randomcnt")
    private Integer randomcnt;
    @Column(name="randommode")
    private String randommode;
    @Column(name="randomparam")
    private String randomparam;
    @Column(name="randomparam2")
    private String randomparam2;
    @Column(name="randomparam3")
    private Integer randomparam3;
    @Column(name="randomparam4")
    private Integer randomparam4;
    @Column(name="sdtag")
    private String sdtag;
    @Column(name="sdtag2")
    private String sdtag2;
    @Column(name="sdtag3")
    private String sdtag3;
    @Column(name="sdtag4")
    private String sdtag4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usage")
    private String usage;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSDESampleDataRefsLock = new Integer(1);
    private ArrayList<PSDESampleDataRef> psdesampledatarefs = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data2 = string;
        this.data2DirtyFlag = true;
    }

    public String getData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData2();
        }
        return this.data2;
    }

    public boolean isData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isData2Dirty();
        }
        return this.data2DirtyFlag;
    }

    public void resetData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData2();
            return;
        }
        this.data2DirtyFlag = false;
        this.data2 = null;
    }

    public void setDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatype = string;
        this.datatypeDirtyFlag = true;
    }

    public String getDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataType();
        }
        return this.datatype;
    }

    public boolean isDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDirty();
        }
        return this.datatypeDirtyFlag;
    }

    public void resetDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataType();
            return;
        }
        this.datatypeDirtyFlag = false;
        this.datatype = null;
    }

    public void setLogicMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicmode = string;
        this.logicmodeDirtyFlag = true;
    }

    public String getLogicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicMode();
        }
        return this.logicmode;
    }

    public boolean isLogicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicModeDirty();
        }
        return this.logicmodeDirtyFlag;
    }

    public void resetLogicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicMode();
            return;
        }
        this.logicmodeDirtyFlag = false;
        this.logicmode = null;
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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
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

    public void setPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataid = string;
        this.psdesampledataidDirtyFlag = true;
    }

    public String getPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataId();
        }
        return this.psdesampledataid;
    }

    public boolean isPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataIdDirty();
        }
        return this.psdesampledataidDirtyFlag;
    }

    public void resetPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataId();
            return;
        }
        this.psdesampledataidDirtyFlag = false;
        this.psdesampledataid = null;
    }

    public void setPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataname = string;
        this.psdesampledatanameDirtyFlag = true;
    }

    public String getPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataName();
        }
        return this.psdesampledataname;
    }

    public boolean isPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataNameDirty();
        }
        return this.psdesampledatanameDirtyFlag;
    }

    public void resetPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataName();
            return;
        }
        this.psdesampledatanameDirtyFlag = false;
        this.psdesampledataname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setRandomCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomCnt(n);
            return;
        }
        this.randomcnt = n;
        this.randomcntDirtyFlag = true;
    }

    public Integer getRandomCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomCnt();
        }
        return this.randomcnt;
    }

    public boolean isRandomCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomCntDirty();
        }
        return this.randomcntDirtyFlag;
    }

    public void resetRandomCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomCnt();
            return;
        }
        this.randomcntDirtyFlag = false;
        this.randomcnt = null;
    }

    public void setRandomMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.randommode = string;
        this.randommodeDirtyFlag = true;
    }

    public String getRandomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomMode();
        }
        return this.randommode;
    }

    public boolean isRandomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomModeDirty();
        }
        return this.randommodeDirtyFlag;
    }

    public void resetRandomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomMode();
            return;
        }
        this.randommodeDirtyFlag = false;
        this.randommode = null;
    }

    public void setRandomParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.randomparam = string;
        this.randomparamDirtyFlag = true;
    }

    public String getRandomParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomParam();
        }
        return this.randomparam;
    }

    public boolean isRandomParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomParamDirty();
        }
        return this.randomparamDirtyFlag;
    }

    public void resetRandomParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomParam();
            return;
        }
        this.randomparamDirtyFlag = false;
        this.randomparam = null;
    }

    public void setRandomParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.randomparam2 = string;
        this.randomparam2DirtyFlag = true;
    }

    public String getRandomParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomParam2();
        }
        return this.randomparam2;
    }

    public boolean isRandomParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomParam2Dirty();
        }
        return this.randomparam2DirtyFlag;
    }

    public void resetRandomParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomParam2();
            return;
        }
        this.randomparam2DirtyFlag = false;
        this.randomparam2 = null;
    }

    public void setRandomParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomParam3(n);
            return;
        }
        this.randomparam3 = n;
        this.randomparam3DirtyFlag = true;
    }

    public Integer getRandomParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomParam3();
        }
        return this.randomparam3;
    }

    public boolean isRandomParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomParam3Dirty();
        }
        return this.randomparam3DirtyFlag;
    }

    public void resetRandomParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomParam3();
            return;
        }
        this.randomparam3DirtyFlag = false;
        this.randomparam3 = null;
    }

    public void setRandomParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomParam4(n);
            return;
        }
        this.randomparam4 = n;
        this.randomparam4DirtyFlag = true;
    }

    public Integer getRandomParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomParam4();
        }
        return this.randomparam4;
    }

    public boolean isRandomParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomParam4Dirty();
        }
        return this.randomparam4DirtyFlag;
    }

    public void resetRandomParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomParam4();
            return;
        }
        this.randomparam4DirtyFlag = false;
        this.randomparam4 = null;
    }

    public void setSDTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdtag = string;
        this.sdtagDirtyFlag = true;
    }

    public String getSDTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDTag();
        }
        return this.sdtag;
    }

    public boolean isSDTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDTagDirty();
        }
        return this.sdtagDirtyFlag;
    }

    public void resetSDTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDTag();
            return;
        }
        this.sdtagDirtyFlag = false;
        this.sdtag = null;
    }

    public void setSDTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdtag2 = string;
        this.sdtag2DirtyFlag = true;
    }

    public String getSDTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDTag2();
        }
        return this.sdtag2;
    }

    public boolean isSDTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDTag2Dirty();
        }
        return this.sdtag2DirtyFlag;
    }

    public void resetSDTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDTag2();
            return;
        }
        this.sdtag2DirtyFlag = false;
        this.sdtag2 = null;
    }

    public void setSDTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdtag3 = string;
        this.sdtag3DirtyFlag = true;
    }

    public String getSDTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDTag3();
        }
        return this.sdtag3;
    }

    public boolean isSDTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDTag3Dirty();
        }
        return this.sdtag3DirtyFlag;
    }

    public void resetSDTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDTag3();
            return;
        }
        this.sdtag3DirtyFlag = false;
        this.sdtag3 = null;
    }

    public void setSDTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSDTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sdtag4 = string;
        this.sdtag4DirtyFlag = true;
    }

    public String getSDTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSDTag4();
        }
        return this.sdtag4;
    }

    public boolean isSDTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSDTag4Dirty();
        }
        return this.sdtag4DirtyFlag;
    }

    public void resetSDTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSDTag4();
            return;
        }
        this.sdtag4DirtyFlag = false;
        this.sdtag4 = null;
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

    public void setUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usage = string;
        this.usageDirtyFlag = true;
    }

    public String getUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsage();
        }
        return this.usage;
    }

    public boolean isUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageDirty();
        }
        return this.usageDirtyFlag;
    }

    public void resetUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsage();
            return;
        }
        this.usageDirtyFlag = false;
        this.usage = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSDESampleDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESampleDataBase pSDESampleDataBase) {
        pSDESampleDataBase.resetCodeName();
        pSDESampleDataBase.resetCreateDate();
        pSDESampleDataBase.resetCreateMan();
        pSDESampleDataBase.resetCustomCode();
        pSDESampleDataBase.resetCustomMode();
        pSDESampleDataBase.resetData();
        pSDESampleDataBase.resetData2();
        pSDESampleDataBase.resetDataType();
        pSDESampleDataBase.resetLogicMode();
        pSDESampleDataBase.resetMemo();
        pSDESampleDataBase.resetPSDEId();
        pSDESampleDataBase.resetPSDEMainStateId();
        pSDESampleDataBase.resetPSDEMainStateName();
        pSDESampleDataBase.resetPSDEName();
        pSDESampleDataBase.resetPSDESampleDataId();
        pSDESampleDataBase.resetPSDESampleDataName();
        pSDESampleDataBase.resetPSSysReqItemId();
        pSDESampleDataBase.resetPSSysReqItemName();
        pSDESampleDataBase.resetRandomCnt();
        pSDESampleDataBase.resetRandomMode();
        pSDESampleDataBase.resetRandomParam();
        pSDESampleDataBase.resetRandomParam2();
        pSDESampleDataBase.resetRandomParam3();
        pSDESampleDataBase.resetRandomParam4();
        pSDESampleDataBase.resetSDTag();
        pSDESampleDataBase.resetSDTag2();
        pSDESampleDataBase.resetSDTag3();
        pSDESampleDataBase.resetSDTag4();
        pSDESampleDataBase.resetUpdateDate();
        pSDESampleDataBase.resetUpdateMan();
        pSDESampleDataBase.resetUsage();
        pSDESampleDataBase.resetUserCat();
        pSDESampleDataBase.resetUserTag();
        pSDESampleDataBase.resetUserTag2();
        pSDESampleDataBase.resetUserTag3();
        pSDESampleDataBase.resetUserTag4();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isData2Dirty()) {
            hashMap.put(FIELD_DATA2, this.getData2());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isLogicModeDirty()) {
            hashMap.put(FIELD_LOGICMODE, this.getLogicMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATAID, this.getPSDESampleDataId());
        }
        if (!bl || this.isPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATANAME, this.getPSDESampleDataName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isRandomCntDirty()) {
            hashMap.put(FIELD_RANDOMCNT, this.getRandomCnt());
        }
        if (!bl || this.isRandomModeDirty()) {
            hashMap.put(FIELD_RANDOMMODE, this.getRandomMode());
        }
        if (!bl || this.isRandomParamDirty()) {
            hashMap.put(FIELD_RANDOMPARAM, this.getRandomParam());
        }
        if (!bl || this.isRandomParam2Dirty()) {
            hashMap.put(FIELD_RANDOMPARAM2, this.getRandomParam2());
        }
        if (!bl || this.isRandomParam3Dirty()) {
            hashMap.put(FIELD_RANDOMPARAM3, this.getRandomParam3());
        }
        if (!bl || this.isRandomParam4Dirty()) {
            hashMap.put(FIELD_RANDOMPARAM4, this.getRandomParam4());
        }
        if (!bl || this.isSDTagDirty()) {
            hashMap.put(FIELD_SDTAG, this.getSDTag());
        }
        if (!bl || this.isSDTag2Dirty()) {
            hashMap.put(FIELD_SDTAG2, this.getSDTag2());
        }
        if (!bl || this.isSDTag3Dirty()) {
            hashMap.put(FIELD_SDTAG3, this.getSDTag3());
        }
        if (!bl || this.isSDTag4Dirty()) {
            hashMap.put(FIELD_SDTAG4, this.getSDTag4());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageDirty()) {
            hashMap.put(FIELD_USAGE, this.getUsage());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSDESampleDataBase.get(this, n);
    }

    private static Object get(PSDESampleDataBase pSDESampleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataBase.getCodeName();
            }
            case 1: {
                return pSDESampleDataBase.getCreateDate();
            }
            case 2: {
                return pSDESampleDataBase.getCreateMan();
            }
            case 3: {
                return pSDESampleDataBase.getCustomCode();
            }
            case 4: {
                return pSDESampleDataBase.getCustomMode();
            }
            case 5: {
                return pSDESampleDataBase.getData();
            }
            case 6: {
                return pSDESampleDataBase.getData2();
            }
            case 7: {
                return pSDESampleDataBase.getDataType();
            }
            case 8: {
                return pSDESampleDataBase.getLogicMode();
            }
            case 9: {
                return pSDESampleDataBase.getMemo();
            }
            case 10: {
                return pSDESampleDataBase.getPSDEId();
            }
            case 11: {
                return pSDESampleDataBase.getPSDEMainStateId();
            }
            case 12: {
                return pSDESampleDataBase.getPSDEMainStateName();
            }
            case 13: {
                return pSDESampleDataBase.getPSDEName();
            }
            case 14: {
                return pSDESampleDataBase.getPSDESampleDataId();
            }
            case 15: {
                return pSDESampleDataBase.getPSDESampleDataName();
            }
            case 16: {
                return pSDESampleDataBase.getPSSysReqItemId();
            }
            case 17: {
                return pSDESampleDataBase.getPSSysReqItemName();
            }
            case 18: {
                return pSDESampleDataBase.getRandomCnt();
            }
            case 19: {
                return pSDESampleDataBase.getRandomMode();
            }
            case 20: {
                return pSDESampleDataBase.getRandomParam();
            }
            case 21: {
                return pSDESampleDataBase.getRandomParam2();
            }
            case 22: {
                return pSDESampleDataBase.getRandomParam3();
            }
            case 23: {
                return pSDESampleDataBase.getRandomParam4();
            }
            case 24: {
                return pSDESampleDataBase.getSDTag();
            }
            case 25: {
                return pSDESampleDataBase.getSDTag2();
            }
            case 26: {
                return pSDESampleDataBase.getSDTag3();
            }
            case 27: {
                return pSDESampleDataBase.getSDTag4();
            }
            case 28: {
                return pSDESampleDataBase.getUpdateDate();
            }
            case 29: {
                return pSDESampleDataBase.getUpdateMan();
            }
            case 30: {
                return pSDESampleDataBase.getUsage();
            }
            case 31: {
                return pSDESampleDataBase.getUserCat();
            }
            case 32: {
                return pSDESampleDataBase.getUserTag();
            }
            case 33: {
                return pSDESampleDataBase.getUserTag2();
            }
            case 34: {
                return pSDESampleDataBase.getUserTag3();
            }
            case 35: {
                return pSDESampleDataBase.getUserTag4();
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
        PSDESampleDataBase.set(this, n, object);
    }

    private static void set(PSDESampleDataBase pSDESampleDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESampleDataBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDESampleDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDESampleDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESampleDataBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESampleDataBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDESampleDataBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESampleDataBase.setData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESampleDataBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESampleDataBase.setLogicMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESampleDataBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESampleDataBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESampleDataBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESampleDataBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDESampleDataBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDESampleDataBase.setPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDESampleDataBase.setPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDESampleDataBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDESampleDataBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDESampleDataBase.setRandomCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDESampleDataBase.setRandomMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDESampleDataBase.setRandomParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDESampleDataBase.setRandomParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDESampleDataBase.setRandomParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDESampleDataBase.setRandomParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDESampleDataBase.setSDTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDESampleDataBase.setSDTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDESampleDataBase.setSDTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDESampleDataBase.setSDTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDESampleDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDESampleDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDESampleDataBase.setUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDESampleDataBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDESampleDataBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDESampleDataBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDESampleDataBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDESampleDataBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDESampleDataBase.isNull(this, n);
    }

    private static boolean isNull(PSDESampleDataBase pSDESampleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataBase.getCodeName() == null;
            }
            case 1: {
                return pSDESampleDataBase.getCreateDate() == null;
            }
            case 2: {
                return pSDESampleDataBase.getCreateMan() == null;
            }
            case 3: {
                return pSDESampleDataBase.getCustomCode() == null;
            }
            case 4: {
                return pSDESampleDataBase.getCustomMode() == null;
            }
            case 5: {
                return pSDESampleDataBase.getData() == null;
            }
            case 6: {
                return pSDESampleDataBase.getData2() == null;
            }
            case 7: {
                return pSDESampleDataBase.getDataType() == null;
            }
            case 8: {
                return pSDESampleDataBase.getLogicMode() == null;
            }
            case 9: {
                return pSDESampleDataBase.getMemo() == null;
            }
            case 10: {
                return pSDESampleDataBase.getPSDEId() == null;
            }
            case 11: {
                return pSDESampleDataBase.getPSDEMainStateId() == null;
            }
            case 12: {
                return pSDESampleDataBase.getPSDEMainStateName() == null;
            }
            case 13: {
                return pSDESampleDataBase.getPSDEName() == null;
            }
            case 14: {
                return pSDESampleDataBase.getPSDESampleDataId() == null;
            }
            case 15: {
                return pSDESampleDataBase.getPSDESampleDataName() == null;
            }
            case 16: {
                return pSDESampleDataBase.getPSSysReqItemId() == null;
            }
            case 17: {
                return pSDESampleDataBase.getPSSysReqItemName() == null;
            }
            case 18: {
                return pSDESampleDataBase.getRandomCnt() == null;
            }
            case 19: {
                return pSDESampleDataBase.getRandomMode() == null;
            }
            case 20: {
                return pSDESampleDataBase.getRandomParam() == null;
            }
            case 21: {
                return pSDESampleDataBase.getRandomParam2() == null;
            }
            case 22: {
                return pSDESampleDataBase.getRandomParam3() == null;
            }
            case 23: {
                return pSDESampleDataBase.getRandomParam4() == null;
            }
            case 24: {
                return pSDESampleDataBase.getSDTag() == null;
            }
            case 25: {
                return pSDESampleDataBase.getSDTag2() == null;
            }
            case 26: {
                return pSDESampleDataBase.getSDTag3() == null;
            }
            case 27: {
                return pSDESampleDataBase.getSDTag4() == null;
            }
            case 28: {
                return pSDESampleDataBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDESampleDataBase.getUpdateMan() == null;
            }
            case 30: {
                return pSDESampleDataBase.getUsage() == null;
            }
            case 31: {
                return pSDESampleDataBase.getUserCat() == null;
            }
            case 32: {
                return pSDESampleDataBase.getUserTag() == null;
            }
            case 33: {
                return pSDESampleDataBase.getUserTag2() == null;
            }
            case 34: {
                return pSDESampleDataBase.getUserTag3() == null;
            }
            case 35: {
                return pSDESampleDataBase.getUserTag4() == null;
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
        return PSDESampleDataBase.contains(this, n);
    }

    private static boolean contains(PSDESampleDataBase pSDESampleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESampleDataBase.isCodeNameDirty();
            }
            case 1: {
                return pSDESampleDataBase.isCreateDateDirty();
            }
            case 2: {
                return pSDESampleDataBase.isCreateManDirty();
            }
            case 3: {
                return pSDESampleDataBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDESampleDataBase.isCustomModeDirty();
            }
            case 5: {
                return pSDESampleDataBase.isDataDirty();
            }
            case 6: {
                return pSDESampleDataBase.isData2Dirty();
            }
            case 7: {
                return pSDESampleDataBase.isDataTypeDirty();
            }
            case 8: {
                return pSDESampleDataBase.isLogicModeDirty();
            }
            case 9: {
                return pSDESampleDataBase.isMemoDirty();
            }
            case 10: {
                return pSDESampleDataBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDESampleDataBase.isPSDEMainStateIdDirty();
            }
            case 12: {
                return pSDESampleDataBase.isPSDEMainStateNameDirty();
            }
            case 13: {
                return pSDESampleDataBase.isPSDENameDirty();
            }
            case 14: {
                return pSDESampleDataBase.isPSDESampleDataIdDirty();
            }
            case 15: {
                return pSDESampleDataBase.isPSDESampleDataNameDirty();
            }
            case 16: {
                return pSDESampleDataBase.isPSSysReqItemIdDirty();
            }
            case 17: {
                return pSDESampleDataBase.isPSSysReqItemNameDirty();
            }
            case 18: {
                return pSDESampleDataBase.isRandomCntDirty();
            }
            case 19: {
                return pSDESampleDataBase.isRandomModeDirty();
            }
            case 20: {
                return pSDESampleDataBase.isRandomParamDirty();
            }
            case 21: {
                return pSDESampleDataBase.isRandomParam2Dirty();
            }
            case 22: {
                return pSDESampleDataBase.isRandomParam3Dirty();
            }
            case 23: {
                return pSDESampleDataBase.isRandomParam4Dirty();
            }
            case 24: {
                return pSDESampleDataBase.isSDTagDirty();
            }
            case 25: {
                return pSDESampleDataBase.isSDTag2Dirty();
            }
            case 26: {
                return pSDESampleDataBase.isSDTag3Dirty();
            }
            case 27: {
                return pSDESampleDataBase.isSDTag4Dirty();
            }
            case 28: {
                return pSDESampleDataBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDESampleDataBase.isUpdateManDirty();
            }
            case 30: {
                return pSDESampleDataBase.isUsageDirty();
            }
            case 31: {
                return pSDESampleDataBase.isUserCatDirty();
            }
            case 32: {
                return pSDESampleDataBase.isUserTagDirty();
            }
            case 33: {
                return pSDESampleDataBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDESampleDataBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDESampleDataBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESampleDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESampleDataBase pSDESampleDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESampleDataBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getData()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data2", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getData2()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getDataType()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getLogicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmode", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getLogicMode()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataid", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataname", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomecnt", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomCnt()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randommode", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomMode()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomparam", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomParam()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomparam2", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomParam2()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomparam3", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomParam3()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getRandomParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomparam4", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getRandomParam4()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getSDTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdtag", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getSDTag()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getSDTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdtag2", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getSDTag2()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getSDTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdtag3", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getSDTag3()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getSDTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sdtag4", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getSDTag4()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usage", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUsage()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDESampleDataBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDESampleDataBase.getJSONValue((Object)pSDESampleDataBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESampleDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESampleDataBase pSDESampleDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESampleDataBase.getCodeName() != null) {
            object = pSDESampleDataBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getCreateDate() != null) {
            object = pSDESampleDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESampleDataBase.getCreateMan() != null) {
            object = pSDESampleDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getCustomCode() != null) {
            object = pSDESampleDataBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getCustomMode() != null) {
            object = pSDESampleDataBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESampleDataBase.getData() != null) {
            object = pSDESampleDataBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getData2() != null) {
            object = pSDESampleDataBase.getData2();
            xmlNode.setAttribute(FIELD_DATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getDataType() != null) {
            object = pSDESampleDataBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getLogicMode() != null) {
            object = pSDESampleDataBase.getLogicMode();
            xmlNode.setAttribute(FIELD_LOGICMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getMemo() != null) {
            object = pSDESampleDataBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDEId() != null) {
            object = pSDESampleDataBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDEMainStateId() != null) {
            object = pSDESampleDataBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDEMainStateName() != null) {
            object = pSDESampleDataBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDEName() != null) {
            object = pSDESampleDataBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDESampleDataId() != null) {
            object = pSDESampleDataBase.getPSDESampleDataId();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSDESampleDataName() != null) {
            object = pSDESampleDataBase.getPSDESampleDataName();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSSysReqItemId() != null) {
            object = pSDESampleDataBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getPSSysReqItemName() != null) {
            object = pSDESampleDataBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getRandomCnt() != null) {
            object = pSDESampleDataBase.getRandomCnt();
            xmlNode.setAttribute("RANDOMCNT", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESampleDataBase.getRandomMode() != null) {
            object = pSDESampleDataBase.getRandomMode();
            xmlNode.setAttribute(FIELD_RANDOMMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getRandomParam() != null) {
            object = pSDESampleDataBase.getRandomParam();
            xmlNode.setAttribute(FIELD_RANDOMPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getRandomParam2() != null) {
            object = pSDESampleDataBase.getRandomParam2();
            xmlNode.setAttribute(FIELD_RANDOMPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getRandomParam3() != null) {
            object = pSDESampleDataBase.getRandomParam3();
            xmlNode.setAttribute(FIELD_RANDOMPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESampleDataBase.getRandomParam4() != null) {
            object = pSDESampleDataBase.getRandomParam4();
            xmlNode.setAttribute(FIELD_RANDOMPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESampleDataBase.getSDTag() != null) {
            object = pSDESampleDataBase.getSDTag();
            xmlNode.setAttribute(FIELD_SDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getSDTag2() != null) {
            object = pSDESampleDataBase.getSDTag2();
            xmlNode.setAttribute(FIELD_SDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getSDTag3() != null) {
            object = pSDESampleDataBase.getSDTag3();
            xmlNode.setAttribute(FIELD_SDTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getSDTag4() != null) {
            object = pSDESampleDataBase.getSDTag4();
            xmlNode.setAttribute(FIELD_SDTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUpdateDate() != null) {
            object = pSDESampleDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESampleDataBase.getUpdateMan() != null) {
            object = pSDESampleDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUsage() != null) {
            object = pSDESampleDataBase.getUsage();
            xmlNode.setAttribute(FIELD_USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUserCat() != null) {
            object = pSDESampleDataBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUserTag() != null) {
            object = pSDESampleDataBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUserTag2() != null) {
            object = pSDESampleDataBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUserTag3() != null) {
            object = pSDESampleDataBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESampleDataBase.getUserTag4() != null) {
            object = pSDESampleDataBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESampleDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESampleDataBase pSDESampleDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESampleDataBase.isCodeNameDirty() && (bl || pSDESampleDataBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDESampleDataBase.getCodeName());
        }
        if (pSDESampleDataBase.isCreateDateDirty() && (bl || pSDESampleDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESampleDataBase.getCreateDate());
        }
        if (pSDESampleDataBase.isCreateManDirty() && (bl || pSDESampleDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESampleDataBase.getCreateMan());
        }
        if (pSDESampleDataBase.isCustomCodeDirty() && (bl || pSDESampleDataBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDESampleDataBase.getCustomCode());
        }
        if (pSDESampleDataBase.isCustomModeDirty() && (bl || pSDESampleDataBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDESampleDataBase.getCustomMode());
        }
        if (pSDESampleDataBase.isDataDirty() && (bl || pSDESampleDataBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDESampleDataBase.getData());
        }
        if (pSDESampleDataBase.isData2Dirty() && (bl || pSDESampleDataBase.getData2() != null)) {
            iDataObject.set(FIELD_DATA2, (Object)pSDESampleDataBase.getData2());
        }
        if (pSDESampleDataBase.isDataTypeDirty() && (bl || pSDESampleDataBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSDESampleDataBase.getDataType());
        }
        if (pSDESampleDataBase.isLogicModeDirty() && (bl || pSDESampleDataBase.getLogicMode() != null)) {
            iDataObject.set(FIELD_LOGICMODE, (Object)pSDESampleDataBase.getLogicMode());
        }
        if (pSDESampleDataBase.isMemoDirty() && (bl || pSDESampleDataBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESampleDataBase.getMemo());
        }
        if (pSDESampleDataBase.isPSDEIdDirty() && (bl || pSDESampleDataBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDESampleDataBase.getPSDEId());
        }
        if (pSDESampleDataBase.isPSDEMainStateIdDirty() && (bl || pSDESampleDataBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDESampleDataBase.getPSDEMainStateId());
        }
        if (pSDESampleDataBase.isPSDEMainStateNameDirty() && (bl || pSDESampleDataBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDESampleDataBase.getPSDEMainStateName());
        }
        if (pSDESampleDataBase.isPSDENameDirty() && (bl || pSDESampleDataBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDESampleDataBase.getPSDEName());
        }
        if (pSDESampleDataBase.isPSDESampleDataIdDirty() && (bl || pSDESampleDataBase.getPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATAID, (Object)pSDESampleDataBase.getPSDESampleDataId());
        }
        if (pSDESampleDataBase.isPSDESampleDataNameDirty() && (bl || pSDESampleDataBase.getPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATANAME, (Object)pSDESampleDataBase.getPSDESampleDataName());
        }
        if (pSDESampleDataBase.isPSSysReqItemIdDirty() && (bl || pSDESampleDataBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDESampleDataBase.getPSSysReqItemId());
        }
        if (pSDESampleDataBase.isPSSysReqItemNameDirty() && (bl || pSDESampleDataBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDESampleDataBase.getPSSysReqItemName());
        }
        if (pSDESampleDataBase.isRandomCntDirty() && (bl || pSDESampleDataBase.getRandomCnt() != null)) {
            iDataObject.set(FIELD_RANDOMCNT, (Object)pSDESampleDataBase.getRandomCnt());
        }
        if (pSDESampleDataBase.isRandomModeDirty() && (bl || pSDESampleDataBase.getRandomMode() != null)) {
            iDataObject.set(FIELD_RANDOMMODE, (Object)pSDESampleDataBase.getRandomMode());
        }
        if (pSDESampleDataBase.isRandomParamDirty() && (bl || pSDESampleDataBase.getRandomParam() != null)) {
            iDataObject.set(FIELD_RANDOMPARAM, (Object)pSDESampleDataBase.getRandomParam());
        }
        if (pSDESampleDataBase.isRandomParam2Dirty() && (bl || pSDESampleDataBase.getRandomParam2() != null)) {
            iDataObject.set(FIELD_RANDOMPARAM2, (Object)pSDESampleDataBase.getRandomParam2());
        }
        if (pSDESampleDataBase.isRandomParam3Dirty() && (bl || pSDESampleDataBase.getRandomParam3() != null)) {
            iDataObject.set(FIELD_RANDOMPARAM3, (Object)pSDESampleDataBase.getRandomParam3());
        }
        if (pSDESampleDataBase.isRandomParam4Dirty() && (bl || pSDESampleDataBase.getRandomParam4() != null)) {
            iDataObject.set(FIELD_RANDOMPARAM4, (Object)pSDESampleDataBase.getRandomParam4());
        }
        if (pSDESampleDataBase.isSDTagDirty() && (bl || pSDESampleDataBase.getSDTag() != null)) {
            iDataObject.set(FIELD_SDTAG, (Object)pSDESampleDataBase.getSDTag());
        }
        if (pSDESampleDataBase.isSDTag2Dirty() && (bl || pSDESampleDataBase.getSDTag2() != null)) {
            iDataObject.set(FIELD_SDTAG2, (Object)pSDESampleDataBase.getSDTag2());
        }
        if (pSDESampleDataBase.isSDTag3Dirty() && (bl || pSDESampleDataBase.getSDTag3() != null)) {
            iDataObject.set(FIELD_SDTAG3, (Object)pSDESampleDataBase.getSDTag3());
        }
        if (pSDESampleDataBase.isSDTag4Dirty() && (bl || pSDESampleDataBase.getSDTag4() != null)) {
            iDataObject.set(FIELD_SDTAG4, (Object)pSDESampleDataBase.getSDTag4());
        }
        if (pSDESampleDataBase.isUpdateDateDirty() && (bl || pSDESampleDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESampleDataBase.getUpdateDate());
        }
        if (pSDESampleDataBase.isUpdateManDirty() && (bl || pSDESampleDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESampleDataBase.getUpdateMan());
        }
        if (pSDESampleDataBase.isUsageDirty() && (bl || pSDESampleDataBase.getUsage() != null)) {
            iDataObject.set(FIELD_USAGE, (Object)pSDESampleDataBase.getUsage());
        }
        if (pSDESampleDataBase.isUserCatDirty() && (bl || pSDESampleDataBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDESampleDataBase.getUserCat());
        }
        if (pSDESampleDataBase.isUserTagDirty() && (bl || pSDESampleDataBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDESampleDataBase.getUserTag());
        }
        if (pSDESampleDataBase.isUserTag2Dirty() && (bl || pSDESampleDataBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDESampleDataBase.getUserTag2());
        }
        if (pSDESampleDataBase.isUserTag3Dirty() && (bl || pSDESampleDataBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDESampleDataBase.getUserTag3());
        }
        if (pSDESampleDataBase.isUserTag4Dirty() && (bl || pSDESampleDataBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDESampleDataBase.getUserTag4());
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
        return PSDESampleDataBase.remove(this, n);
    }

    private static boolean remove(PSDESampleDataBase pSDESampleDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESampleDataBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDESampleDataBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDESampleDataBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDESampleDataBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDESampleDataBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSDESampleDataBase.resetData();
                return true;
            }
            case 6: {
                pSDESampleDataBase.resetData2();
                return true;
            }
            case 7: {
                pSDESampleDataBase.resetDataType();
                return true;
            }
            case 8: {
                pSDESampleDataBase.resetLogicMode();
                return true;
            }
            case 9: {
                pSDESampleDataBase.resetMemo();
                return true;
            }
            case 10: {
                pSDESampleDataBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDESampleDataBase.resetPSDEMainStateId();
                return true;
            }
            case 12: {
                pSDESampleDataBase.resetPSDEMainStateName();
                return true;
            }
            case 13: {
                pSDESampleDataBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSDESampleDataBase.resetPSDESampleDataId();
                return true;
            }
            case 15: {
                pSDESampleDataBase.resetPSDESampleDataName();
                return true;
            }
            case 16: {
                pSDESampleDataBase.resetPSSysReqItemId();
                return true;
            }
            case 17: {
                pSDESampleDataBase.resetPSSysReqItemName();
                return true;
            }
            case 18: {
                pSDESampleDataBase.resetRandomCnt();
                return true;
            }
            case 19: {
                pSDESampleDataBase.resetRandomMode();
                return true;
            }
            case 20: {
                pSDESampleDataBase.resetRandomParam();
                return true;
            }
            case 21: {
                pSDESampleDataBase.resetRandomParam2();
                return true;
            }
            case 22: {
                pSDESampleDataBase.resetRandomParam3();
                return true;
            }
            case 23: {
                pSDESampleDataBase.resetRandomParam4();
                return true;
            }
            case 24: {
                pSDESampleDataBase.resetSDTag();
                return true;
            }
            case 25: {
                pSDESampleDataBase.resetSDTag2();
                return true;
            }
            case 26: {
                pSDESampleDataBase.resetSDTag3();
                return true;
            }
            case 27: {
                pSDESampleDataBase.resetSDTag4();
                return true;
            }
            case 28: {
                pSDESampleDataBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDESampleDataBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSDESampleDataBase.resetUsage();
                return true;
            }
            case 31: {
                pSDESampleDataBase.resetUserCat();
                return true;
            }
            case 32: {
                pSDESampleDataBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDESampleDataBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDESampleDataBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDESampleDataBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESampleDataRef> getPSDESampleDataRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataRefs();
        }
        if (this.getPSDESampleDataId() == null) {
            return null;
        }
        PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESampleDataRefsLock;
        synchronized (n) {
            if (this.psdesampledatarefs == null) {
                this.psdesampledatarefs = pSDESampleDataRefService.selectByPSDESampleData(this);
            }
            return this.psdesampledatarefs;
        }
    }

    private PSDESampleDataBase getProxyEntity() {
        return this.proxyPSDESampleDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESampleDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESampleDataBase) {
            this.proxyPSDESampleDataBase = (PSDESampleDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_DATA, 5);
        fieldIndexMap.put(FIELD_DATA2, 6);
        fieldIndexMap.put(FIELD_DATATYPE, 7);
        fieldIndexMap.put(FIELD_LOGICMODE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 11);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATAID, 14);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATANAME, 15);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 17);
        fieldIndexMap.put(FIELD_RANDOMCNT, 18);
        fieldIndexMap.put(FIELD_RANDOMMODE, 19);
        fieldIndexMap.put(FIELD_RANDOMPARAM, 20);
        fieldIndexMap.put(FIELD_RANDOMPARAM2, 21);
        fieldIndexMap.put(FIELD_RANDOMPARAM3, 22);
        fieldIndexMap.put(FIELD_RANDOMPARAM4, 23);
        fieldIndexMap.put(FIELD_SDTAG, 24);
        fieldIndexMap.put(FIELD_SDTAG2, 25);
        fieldIndexMap.put(FIELD_SDTAG3, 26);
        fieldIndexMap.put(FIELD_SDTAG4, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USAGE, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
    }
}

