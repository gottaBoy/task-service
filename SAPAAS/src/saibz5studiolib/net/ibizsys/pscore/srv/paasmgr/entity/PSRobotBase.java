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
package net.ibizsys.pscore.srv.paasmgr.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURENERGY = "CURENERGY";
    public static final String FIELD_ENERGYRATE = "ENERGYRATE";
    public static final String FIELD_EXTENERGY = "EXTENERGY";
    public static final String FIELD_LASTCALCTIME = "LASTCALCTIME";
    public static final String FIELD_LASTENERGY = "LASTENERGY";
    public static final String FIELD_MAXENERGY = "MAXENERGY";
    public static final String FIELD_MAXEXTENERGY = "MAXEXTENERGY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSROBOTID = "PSROBOTID";
    public static final String FIELD_PSROBOTNAME = "PSROBOTNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_REFFLAG = "REFFLAG";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_ROBOTLEVEL = "ROBOTLEVEL";
    public static final String FIELD_ROBOTSTATE = "ROBOTSTATE";
    public static final String FIELD_ROBOTTYPE = "ROBOTTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURENERGY = 2;
    private static final int INDEX_ENERGYRATE = 3;
    private static final int INDEX_EXTENERGY = 4;
    private static final int INDEX_LASTCALCTIME = 5;
    private static final int INDEX_LASTENERGY = 6;
    private static final int INDEX_MAXENERGY = 7;
    private static final int INDEX_MAXEXTENERGY = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PARAM = 11;
    private static final int INDEX_PARAM2 = 12;
    private static final int INDEX_PARAM3 = 13;
    private static final int INDEX_PARAM4 = 14;
    private static final int INDEX_PARAM5 = 15;
    private static final int INDEX_PARAM6 = 16;
    private static final int INDEX_PARAM7 = 17;
    private static final int INDEX_PARAM8 = 18;
    private static final int INDEX_PSDEVCENTERID = 19;
    private static final int INDEX_PSDEVCENTERNAME = 20;
    private static final int INDEX_PSROBOTID = 21;
    private static final int INDEX_PSROBOTNAME = 22;
    private static final int INDEX_PSSVRDOMAINID = 23;
    private static final int INDEX_PSSVRDOMAINNAME = 24;
    private static final int INDEX_PSTASKSERVERID = 25;
    private static final int INDEX_PSTASKSERVERNAME = 26;
    private static final int INDEX_REFFLAG = 27;
    private static final int INDEX_REFOBJID = 28;
    private static final int INDEX_REFOBJNAME = 29;
    private static final int INDEX_REFOBJTYPE = 30;
    private static final int INDEX_ROBOTLEVEL = 31;
    private static final int INDEX_ROBOTSTATE = 32;
    private static final int INDEX_ROBOTTYPE = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_VALIDFLAG = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotBase proxyPSRobotBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curenergyDirtyFlag = false;
    private boolean energyrateDirtyFlag = false;
    private boolean extenergyDirtyFlag = false;
    private boolean lastcalctimeDirtyFlag = false;
    private boolean lastenergyDirtyFlag = false;
    private boolean maxenergyDirtyFlag = false;
    private boolean maxextenergyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psrobotidDirtyFlag = false;
    private boolean psrobotnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean refflagDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean robotlevelDirtyFlag = false;
    private boolean robotstateDirtyFlag = false;
    private boolean robottypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curenergy")
    private Integer curenergy;
    @Column(name="energyrate")
    private Double energyrate;
    @Column(name="extenergy")
    private Integer extenergy;
    @Column(name="lastcalctime")
    private Timestamp lastcalctime;
    @Column(name="lastenergy")
    private Integer lastenergy;
    @Column(name="maxenergy")
    private Integer maxenergy;
    @Column(name="maxextenergy")
    private Integer maxextenergy;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psrobotid")
    private String psrobotid;
    @Column(name="psrobotname")
    private String psrobotname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="refflag")
    private Integer refflag;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="robotlevel")
    private Integer robotlevel;
    @Column(name="robotstate")
    private Integer robotstate;
    @Column(name="robottype")
    private String robottype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setCurEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurEnergy(n);
            return;
        }
        this.curenergy = n;
        this.curenergyDirtyFlag = true;
    }

    public Integer getCurEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurEnergy();
        }
        return this.curenergy;
    }

    public boolean isCurEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurEnergyDirty();
        }
        return this.curenergyDirtyFlag;
    }

    public void resetCurEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurEnergy();
            return;
        }
        this.curenergyDirtyFlag = false;
        this.curenergy = null;
    }

    public void setEnergyRate(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnergyRate(d);
            return;
        }
        this.energyrate = d;
        this.energyrateDirtyFlag = true;
    }

    public Double getEnergyRate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnergyRate();
        }
        return this.energyrate;
    }

    public boolean isEnergyRateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnergyRateDirty();
        }
        return this.energyrateDirtyFlag;
    }

    public void resetEnergyRate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnergyRate();
            return;
        }
        this.energyrateDirtyFlag = false;
        this.energyrate = null;
    }

    public void setExtEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtEnergy(n);
            return;
        }
        this.extenergy = n;
        this.extenergyDirtyFlag = true;
    }

    public Integer getExtEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtEnergy();
        }
        return this.extenergy;
    }

    public boolean isExtEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtEnergyDirty();
        }
        return this.extenergyDirtyFlag;
    }

    public void resetExtEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtEnergy();
            return;
        }
        this.extenergyDirtyFlag = false;
        this.extenergy = null;
    }

    public void setLastCalcTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastCalcTime(timestamp);
            return;
        }
        this.lastcalctime = timestamp;
        this.lastcalctimeDirtyFlag = true;
    }

    public Timestamp getLastCalcTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastCalcTime();
        }
        return this.lastcalctime;
    }

    public boolean isLastCalcTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastCalcTimeDirty();
        }
        return this.lastcalctimeDirtyFlag;
    }

    public void resetLastCalcTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastCalcTime();
            return;
        }
        this.lastcalctimeDirtyFlag = false;
        this.lastcalctime = null;
    }

    public void setLastEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastEnergy(n);
            return;
        }
        this.lastenergy = n;
        this.lastenergyDirtyFlag = true;
    }

    public Integer getLastEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastEnergy();
        }
        return this.lastenergy;
    }

    public boolean isLastEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastEnergyDirty();
        }
        return this.lastenergyDirtyFlag;
    }

    public void resetLastEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastEnergy();
            return;
        }
        this.lastenergyDirtyFlag = false;
        this.lastenergy = null;
    }

    public void setMaxEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEnergy(n);
            return;
        }
        this.maxenergy = n;
        this.maxenergyDirtyFlag = true;
    }

    public Integer getMaxEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEnergy();
        }
        return this.maxenergy;
    }

    public boolean isMaxEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEnergyDirty();
        }
        return this.maxenergyDirtyFlag;
    }

    public void resetMaxEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEnergy();
            return;
        }
        this.maxenergyDirtyFlag = false;
        this.maxenergy = null;
    }

    public void setMaxExtEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxExtEnergy(n);
            return;
        }
        this.maxextenergy = n;
        this.maxextenergyDirtyFlag = true;
    }

    public Integer getMaxExtEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxExtEnergy();
        }
        return this.maxextenergy;
    }

    public boolean isMaxExtEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxExtEnergyDirty();
        }
        return this.maxextenergyDirtyFlag;
    }

    public void resetMaxExtEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxExtEnergy();
            return;
        }
        this.maxextenergyDirtyFlag = false;
        this.maxextenergy = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSRobotId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotid = string;
        this.psrobotidDirtyFlag = true;
    }

    public String getPSRobotId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotId();
        }
        return this.psrobotid;
    }

    public boolean isPSRobotIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotIdDirty();
        }
        return this.psrobotidDirtyFlag;
    }

    public void resetPSRobotId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotId();
            return;
        }
        this.psrobotidDirtyFlag = false;
        this.psrobotid = null;
    }

    public void setPSRobotName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotname = string;
        this.psrobotnameDirtyFlag = true;
    }

    public String getPSRobotName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotName();
        }
        return this.psrobotname;
    }

    public boolean isPSRobotNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotNameDirty();
        }
        return this.psrobotnameDirtyFlag;
    }

    public void resetPSRobotName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotName();
            return;
        }
        this.psrobotnameDirtyFlag = false;
        this.psrobotname = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
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

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFlag(n);
            return;
        }
        this.refflag = n;
        this.refflagDirtyFlag = true;
    }

    public Integer getRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFlag();
        }
        return this.refflag;
    }

    public boolean isRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFlagDirty();
        }
        return this.refflagDirtyFlag;
    }

    public void resetRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFlag();
            return;
        }
        this.refflagDirtyFlag = false;
        this.refflag = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
    }

    public void setRobotLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotLevel(n);
            return;
        }
        this.robotlevel = n;
        this.robotlevelDirtyFlag = true;
    }

    public Integer getRobotLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotLevel();
        }
        return this.robotlevel;
    }

    public boolean isRobotLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotLevelDirty();
        }
        return this.robotlevelDirtyFlag;
    }

    public void resetRobotLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotLevel();
            return;
        }
        this.robotlevelDirtyFlag = false;
        this.robotlevel = null;
    }

    public void setRobotState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotState(n);
            return;
        }
        this.robotstate = n;
        this.robotstateDirtyFlag = true;
    }

    public Integer getRobotState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotState();
        }
        return this.robotstate;
    }

    public boolean isRobotStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotStateDirty();
        }
        return this.robotstateDirtyFlag;
    }

    public void resetRobotState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotState();
            return;
        }
        this.robotstateDirtyFlag = false;
        this.robotstate = null;
    }

    public void setRobotType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.robottype = string;
        this.robottypeDirtyFlag = true;
    }

    public String getRobotType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotType();
        }
        return this.robottype;
    }

    public boolean isRobotTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotTypeDirty();
        }
        return this.robottypeDirtyFlag;
    }

    public void resetRobotType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotType();
            return;
        }
        this.robottypeDirtyFlag = false;
        this.robottype = null;
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

    protected void onReset() {
        PSRobotBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotBase pSRobotBase) {
        pSRobotBase.resetCreateDate();
        pSRobotBase.resetCreateMan();
        pSRobotBase.resetCurEnergy();
        pSRobotBase.resetEnergyRate();
        pSRobotBase.resetExtEnergy();
        pSRobotBase.resetLastCalcTime();
        pSRobotBase.resetLastEnergy();
        pSRobotBase.resetMaxEnergy();
        pSRobotBase.resetMaxExtEnergy();
        pSRobotBase.resetMemo();
        pSRobotBase.resetOrderValue();
        pSRobotBase.resetParam();
        pSRobotBase.resetParam2();
        pSRobotBase.resetParam3();
        pSRobotBase.resetParam4();
        pSRobotBase.resetParam5();
        pSRobotBase.resetParam6();
        pSRobotBase.resetParam7();
        pSRobotBase.resetParam8();
        pSRobotBase.resetPSDevCenterId();
        pSRobotBase.resetPSDevCenterName();
        pSRobotBase.resetPSRobotId();
        pSRobotBase.resetPSRobotName();
        pSRobotBase.resetPSSvrDomainId();
        pSRobotBase.resetPSSvrDomainName();
        pSRobotBase.resetPSTaskServerId();
        pSRobotBase.resetPSTaskServerName();
        pSRobotBase.resetRefFlag();
        pSRobotBase.resetRefObjId();
        pSRobotBase.resetRefObjName();
        pSRobotBase.resetRefObjType();
        pSRobotBase.resetRobotLevel();
        pSRobotBase.resetRobotState();
        pSRobotBase.resetRobotType();
        pSRobotBase.resetUpdateDate();
        pSRobotBase.resetUpdateMan();
        pSRobotBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurEnergyDirty()) {
            hashMap.put(FIELD_CURENERGY, this.getCurEnergy());
        }
        if (!bl || this.isEnergyRateDirty()) {
            hashMap.put(FIELD_ENERGYRATE, this.getEnergyRate());
        }
        if (!bl || this.isExtEnergyDirty()) {
            hashMap.put(FIELD_EXTENERGY, this.getExtEnergy());
        }
        if (!bl || this.isLastCalcTimeDirty()) {
            hashMap.put(FIELD_LASTCALCTIME, this.getLastCalcTime());
        }
        if (!bl || this.isLastEnergyDirty()) {
            hashMap.put(FIELD_LASTENERGY, this.getLastEnergy());
        }
        if (!bl || this.isMaxEnergyDirty()) {
            hashMap.put(FIELD_MAXENERGY, this.getMaxEnergy());
        }
        if (!bl || this.isMaxExtEnergyDirty()) {
            hashMap.put(FIELD_MAXEXTENERGY, this.getMaxExtEnergy());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSRobotIdDirty()) {
            hashMap.put(FIELD_PSROBOTID, this.getPSRobotId());
        }
        if (!bl || this.isPSRobotNameDirty()) {
            hashMap.put(FIELD_PSROBOTNAME, this.getPSRobotName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isRefFlagDirty()) {
            hashMap.put(FIELD_REFFLAG, this.getRefFlag());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
        }
        if (!bl || this.isRobotLevelDirty()) {
            hashMap.put(FIELD_ROBOTLEVEL, this.getRobotLevel());
        }
        if (!bl || this.isRobotStateDirty()) {
            hashMap.put(FIELD_ROBOTSTATE, this.getRobotState());
        }
        if (!bl || this.isRobotTypeDirty()) {
            hashMap.put(FIELD_ROBOTTYPE, this.getRobotType());
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
        return PSRobotBase.get(this, n);
    }

    private static Object get(PSRobotBase pSRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotBase.getCreateDate();
            }
            case 1: {
                return pSRobotBase.getCreateMan();
            }
            case 2: {
                return pSRobotBase.getCurEnergy();
            }
            case 3: {
                return pSRobotBase.getEnergyRate();
            }
            case 4: {
                return pSRobotBase.getExtEnergy();
            }
            case 5: {
                return pSRobotBase.getLastCalcTime();
            }
            case 6: {
                return pSRobotBase.getLastEnergy();
            }
            case 7: {
                return pSRobotBase.getMaxEnergy();
            }
            case 8: {
                return pSRobotBase.getMaxExtEnergy();
            }
            case 9: {
                return pSRobotBase.getMemo();
            }
            case 10: {
                return pSRobotBase.getOrderValue();
            }
            case 11: {
                return pSRobotBase.getParam();
            }
            case 12: {
                return pSRobotBase.getParam2();
            }
            case 13: {
                return pSRobotBase.getParam3();
            }
            case 14: {
                return pSRobotBase.getParam4();
            }
            case 15: {
                return pSRobotBase.getParam5();
            }
            case 16: {
                return pSRobotBase.getParam6();
            }
            case 17: {
                return pSRobotBase.getParam7();
            }
            case 18: {
                return pSRobotBase.getParam8();
            }
            case 19: {
                return pSRobotBase.getPSDevCenterId();
            }
            case 20: {
                return pSRobotBase.getPSDevCenterName();
            }
            case 21: {
                return pSRobotBase.getPSRobotId();
            }
            case 22: {
                return pSRobotBase.getPSRobotName();
            }
            case 23: {
                return pSRobotBase.getPSSvrDomainId();
            }
            case 24: {
                return pSRobotBase.getPSSvrDomainName();
            }
            case 25: {
                return pSRobotBase.getPSTaskServerId();
            }
            case 26: {
                return pSRobotBase.getPSTaskServerName();
            }
            case 27: {
                return pSRobotBase.getRefFlag();
            }
            case 28: {
                return pSRobotBase.getRefObjId();
            }
            case 29: {
                return pSRobotBase.getRefObjName();
            }
            case 30: {
                return pSRobotBase.getRefObjType();
            }
            case 31: {
                return pSRobotBase.getRobotLevel();
            }
            case 32: {
                return pSRobotBase.getRobotState();
            }
            case 33: {
                return pSRobotBase.getRobotType();
            }
            case 34: {
                return pSRobotBase.getUpdateDate();
            }
            case 35: {
                return pSRobotBase.getUpdateMan();
            }
            case 36: {
                return pSRobotBase.getValidFlag();
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
        PSRobotBase.set(this, n, object);
    }

    private static void set(PSRobotBase pSRobotBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRobotBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotBase.setCurEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSRobotBase.setEnergyRate(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSRobotBase.setExtEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSRobotBase.setLastCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSRobotBase.setLastEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSRobotBase.setMaxEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSRobotBase.setMaxExtEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSRobotBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRobotBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSRobotBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSRobotBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRobotBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSRobotBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSRobotBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSRobotBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSRobotBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSRobotBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSRobotBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSRobotBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSRobotBase.setPSRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSRobotBase.setPSRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSRobotBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSRobotBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSRobotBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSRobotBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSRobotBase.setRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSRobotBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSRobotBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSRobotBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSRobotBase.setRobotLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSRobotBase.setRobotState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSRobotBase.setRobotType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSRobotBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSRobotBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSRobotBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRobotBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotBase pSRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotBase.getCreateDate() == null;
            }
            case 1: {
                return pSRobotBase.getCreateMan() == null;
            }
            case 2: {
                return pSRobotBase.getCurEnergy() == null;
            }
            case 3: {
                return pSRobotBase.getEnergyRate() == null;
            }
            case 4: {
                return pSRobotBase.getExtEnergy() == null;
            }
            case 5: {
                return pSRobotBase.getLastCalcTime() == null;
            }
            case 6: {
                return pSRobotBase.getLastEnergy() == null;
            }
            case 7: {
                return pSRobotBase.getMaxEnergy() == null;
            }
            case 8: {
                return pSRobotBase.getMaxExtEnergy() == null;
            }
            case 9: {
                return pSRobotBase.getMemo() == null;
            }
            case 10: {
                return pSRobotBase.getOrderValue() == null;
            }
            case 11: {
                return pSRobotBase.getParam() == null;
            }
            case 12: {
                return pSRobotBase.getParam2() == null;
            }
            case 13: {
                return pSRobotBase.getParam3() == null;
            }
            case 14: {
                return pSRobotBase.getParam4() == null;
            }
            case 15: {
                return pSRobotBase.getParam5() == null;
            }
            case 16: {
                return pSRobotBase.getParam6() == null;
            }
            case 17: {
                return pSRobotBase.getParam7() == null;
            }
            case 18: {
                return pSRobotBase.getParam8() == null;
            }
            case 19: {
                return pSRobotBase.getPSDevCenterId() == null;
            }
            case 20: {
                return pSRobotBase.getPSDevCenterName() == null;
            }
            case 21: {
                return pSRobotBase.getPSRobotId() == null;
            }
            case 22: {
                return pSRobotBase.getPSRobotName() == null;
            }
            case 23: {
                return pSRobotBase.getPSSvrDomainId() == null;
            }
            case 24: {
                return pSRobotBase.getPSSvrDomainName() == null;
            }
            case 25: {
                return pSRobotBase.getPSTaskServerId() == null;
            }
            case 26: {
                return pSRobotBase.getPSTaskServerName() == null;
            }
            case 27: {
                return pSRobotBase.getRefFlag() == null;
            }
            case 28: {
                return pSRobotBase.getRefObjId() == null;
            }
            case 29: {
                return pSRobotBase.getRefObjName() == null;
            }
            case 30: {
                return pSRobotBase.getRefObjType() == null;
            }
            case 31: {
                return pSRobotBase.getRobotLevel() == null;
            }
            case 32: {
                return pSRobotBase.getRobotState() == null;
            }
            case 33: {
                return pSRobotBase.getRobotType() == null;
            }
            case 34: {
                return pSRobotBase.getUpdateDate() == null;
            }
            case 35: {
                return pSRobotBase.getUpdateMan() == null;
            }
            case 36: {
                return pSRobotBase.getValidFlag() == null;
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
        return PSRobotBase.contains(this, n);
    }

    private static boolean contains(PSRobotBase pSRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotBase.isCreateDateDirty();
            }
            case 1: {
                return pSRobotBase.isCreateManDirty();
            }
            case 2: {
                return pSRobotBase.isCurEnergyDirty();
            }
            case 3: {
                return pSRobotBase.isEnergyRateDirty();
            }
            case 4: {
                return pSRobotBase.isExtEnergyDirty();
            }
            case 5: {
                return pSRobotBase.isLastCalcTimeDirty();
            }
            case 6: {
                return pSRobotBase.isLastEnergyDirty();
            }
            case 7: {
                return pSRobotBase.isMaxEnergyDirty();
            }
            case 8: {
                return pSRobotBase.isMaxExtEnergyDirty();
            }
            case 9: {
                return pSRobotBase.isMemoDirty();
            }
            case 10: {
                return pSRobotBase.isOrderValueDirty();
            }
            case 11: {
                return pSRobotBase.isParamDirty();
            }
            case 12: {
                return pSRobotBase.isParam2Dirty();
            }
            case 13: {
                return pSRobotBase.isParam3Dirty();
            }
            case 14: {
                return pSRobotBase.isParam4Dirty();
            }
            case 15: {
                return pSRobotBase.isParam5Dirty();
            }
            case 16: {
                return pSRobotBase.isParam6Dirty();
            }
            case 17: {
                return pSRobotBase.isParam7Dirty();
            }
            case 18: {
                return pSRobotBase.isParam8Dirty();
            }
            case 19: {
                return pSRobotBase.isPSDevCenterIdDirty();
            }
            case 20: {
                return pSRobotBase.isPSDevCenterNameDirty();
            }
            case 21: {
                return pSRobotBase.isPSRobotIdDirty();
            }
            case 22: {
                return pSRobotBase.isPSRobotNameDirty();
            }
            case 23: {
                return pSRobotBase.isPSSvrDomainIdDirty();
            }
            case 24: {
                return pSRobotBase.isPSSvrDomainNameDirty();
            }
            case 25: {
                return pSRobotBase.isPSTaskServerIdDirty();
            }
            case 26: {
                return pSRobotBase.isPSTaskServerNameDirty();
            }
            case 27: {
                return pSRobotBase.isRefFlagDirty();
            }
            case 28: {
                return pSRobotBase.isRefObjIdDirty();
            }
            case 29: {
                return pSRobotBase.isRefObjNameDirty();
            }
            case 30: {
                return pSRobotBase.isRefObjTypeDirty();
            }
            case 31: {
                return pSRobotBase.isRobotLevelDirty();
            }
            case 32: {
                return pSRobotBase.isRobotStateDirty();
            }
            case 33: {
                return pSRobotBase.isRobotTypeDirty();
            }
            case 34: {
                return pSRobotBase.isUpdateDateDirty();
            }
            case 35: {
                return pSRobotBase.isUpdateManDirty();
            }
            case 36: {
                return pSRobotBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotBase pSRobotBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotBase.getCurEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curenergy", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getCurEnergy()), (boolean)false);
        }
        if (bl || pSRobotBase.getEnergyRate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energyrate", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getEnergyRate()), (boolean)false);
        }
        if (bl || pSRobotBase.getExtEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extenergy", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getExtEnergy()), (boolean)false);
        }
        if (bl || pSRobotBase.getLastCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcalctime", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getLastCalcTime()), (boolean)false);
        }
        if (bl || pSRobotBase.getLastEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastenergy", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getLastEnergy()), (boolean)false);
        }
        if (bl || pSRobotBase.getMaxEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxenergy", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getMaxEnergy()), (boolean)false);
        }
        if (bl || pSRobotBase.getMaxExtEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxextenergy", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getMaxExtEnergy()), (boolean)false);
        }
        if (bl || pSRobotBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam2()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam3()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam4()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam5()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam6()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam7()), (boolean)false);
        }
        if (bl || pSRobotBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getParam8()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotid", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSRobotId()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotname", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSRobotName()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSRobotBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSRobotBase.getRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refflag", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRefFlag()), (boolean)false);
        }
        if (bl || pSRobotBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSRobotBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSRobotBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSRobotBase.getRobotLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotlevel", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRobotLevel()), (boolean)false);
        }
        if (bl || pSRobotBase.getRobotState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotstate", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRobotState()), (boolean)false);
        }
        if (bl || pSRobotBase.getRobotType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robottype", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getRobotType()), (boolean)false);
        }
        if (bl || pSRobotBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotBase.getJSONValue((Object)pSRobotBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotBase pSRobotBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotBase.getCreateDate() != null) {
            object = pSRobotBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotBase.getCreateMan() != null) {
            object = pSRobotBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getCurEnergy() != null) {
            object = pSRobotBase.getCurEnergy();
            xmlNode.setAttribute(FIELD_CURENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getEnergyRate() != null) {
            object = pSRobotBase.getEnergyRate();
            xmlNode.setAttribute(FIELD_ENERGYRATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getExtEnergy() != null) {
            object = pSRobotBase.getExtEnergy();
            xmlNode.setAttribute(FIELD_EXTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getLastCalcTime() != null) {
            object = pSRobotBase.getLastCalcTime();
            xmlNode.setAttribute(FIELD_LASTCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotBase.getLastEnergy() != null) {
            object = pSRobotBase.getLastEnergy();
            xmlNode.setAttribute(FIELD_LASTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getMaxEnergy() != null) {
            object = pSRobotBase.getMaxEnergy();
            xmlNode.setAttribute(FIELD_MAXENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getMaxExtEnergy() != null) {
            object = pSRobotBase.getMaxExtEnergy();
            xmlNode.setAttribute(FIELD_MAXEXTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getMemo() != null) {
            object = pSRobotBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getOrderValue() != null) {
            object = pSRobotBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getParam() != null) {
            object = pSRobotBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getParam2() != null) {
            object = pSRobotBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getParam3() != null) {
            object = pSRobotBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getParam4() != null) {
            object = pSRobotBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getParam5() != null) {
            object = pSRobotBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getParam6() != null) {
            object = pSRobotBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getParam7() != null) {
            object = pSRobotBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getParam8() != null) {
            object = pSRobotBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getPSDevCenterId() != null) {
            object = pSRobotBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSDevCenterName() != null) {
            object = pSRobotBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSRobotId() != null) {
            object = pSRobotBase.getPSRobotId();
            xmlNode.setAttribute(FIELD_PSROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSRobotName() != null) {
            object = pSRobotBase.getPSRobotName();
            xmlNode.setAttribute(FIELD_PSROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSSvrDomainId() != null) {
            object = pSRobotBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSSvrDomainName() != null) {
            object = pSRobotBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSTaskServerId() != null) {
            object = pSRobotBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getPSTaskServerName() != null) {
            object = pSRobotBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getRefFlag() != null) {
            object = pSRobotBase.getRefFlag();
            xmlNode.setAttribute(FIELD_REFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getRefObjId() != null) {
            object = pSRobotBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getRefObjName() != null) {
            object = pSRobotBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getRefObjType() != null) {
            object = pSRobotBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getRobotLevel() != null) {
            object = pSRobotBase.getRobotLevel();
            xmlNode.setAttribute(FIELD_ROBOTLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getRobotState() != null) {
            object = pSRobotBase.getRobotState();
            xmlNode.setAttribute(FIELD_ROBOTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotBase.getRobotType() != null) {
            object = pSRobotBase.getRobotType();
            xmlNode.setAttribute(FIELD_ROBOTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getUpdateDate() != null) {
            object = pSRobotBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotBase.getUpdateMan() != null) {
            object = pSRobotBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotBase.getValidFlag() != null) {
            object = pSRobotBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotBase pSRobotBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotBase.isCreateDateDirty() && (bl || pSRobotBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotBase.getCreateDate());
        }
        if (pSRobotBase.isCreateManDirty() && (bl || pSRobotBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotBase.getCreateMan());
        }
        if (pSRobotBase.isCurEnergyDirty() && (bl || pSRobotBase.getCurEnergy() != null)) {
            iDataObject.set(FIELD_CURENERGY, (Object)pSRobotBase.getCurEnergy());
        }
        if (pSRobotBase.isEnergyRateDirty() && (bl || pSRobotBase.getEnergyRate() != null)) {
            iDataObject.set(FIELD_ENERGYRATE, (Object)pSRobotBase.getEnergyRate());
        }
        if (pSRobotBase.isExtEnergyDirty() && (bl || pSRobotBase.getExtEnergy() != null)) {
            iDataObject.set(FIELD_EXTENERGY, (Object)pSRobotBase.getExtEnergy());
        }
        if (pSRobotBase.isLastCalcTimeDirty() && (bl || pSRobotBase.getLastCalcTime() != null)) {
            iDataObject.set(FIELD_LASTCALCTIME, (Object)pSRobotBase.getLastCalcTime());
        }
        if (pSRobotBase.isLastEnergyDirty() && (bl || pSRobotBase.getLastEnergy() != null)) {
            iDataObject.set(FIELD_LASTENERGY, (Object)pSRobotBase.getLastEnergy());
        }
        if (pSRobotBase.isMaxEnergyDirty() && (bl || pSRobotBase.getMaxEnergy() != null)) {
            iDataObject.set(FIELD_MAXENERGY, (Object)pSRobotBase.getMaxEnergy());
        }
        if (pSRobotBase.isMaxExtEnergyDirty() && (bl || pSRobotBase.getMaxExtEnergy() != null)) {
            iDataObject.set(FIELD_MAXEXTENERGY, (Object)pSRobotBase.getMaxExtEnergy());
        }
        if (pSRobotBase.isMemoDirty() && (bl || pSRobotBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotBase.getMemo());
        }
        if (pSRobotBase.isOrderValueDirty() && (bl || pSRobotBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSRobotBase.getOrderValue());
        }
        if (pSRobotBase.isParamDirty() && (bl || pSRobotBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSRobotBase.getParam());
        }
        if (pSRobotBase.isParam2Dirty() && (bl || pSRobotBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSRobotBase.getParam2());
        }
        if (pSRobotBase.isParam3Dirty() && (bl || pSRobotBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSRobotBase.getParam3());
        }
        if (pSRobotBase.isParam4Dirty() && (bl || pSRobotBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSRobotBase.getParam4());
        }
        if (pSRobotBase.isParam5Dirty() && (bl || pSRobotBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSRobotBase.getParam5());
        }
        if (pSRobotBase.isParam6Dirty() && (bl || pSRobotBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSRobotBase.getParam6());
        }
        if (pSRobotBase.isParam7Dirty() && (bl || pSRobotBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSRobotBase.getParam7());
        }
        if (pSRobotBase.isParam8Dirty() && (bl || pSRobotBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSRobotBase.getParam8());
        }
        if (pSRobotBase.isPSDevCenterIdDirty() && (bl || pSRobotBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSRobotBase.getPSDevCenterId());
        }
        if (pSRobotBase.isPSDevCenterNameDirty() && (bl || pSRobotBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSRobotBase.getPSDevCenterName());
        }
        if (pSRobotBase.isPSRobotIdDirty() && (bl || pSRobotBase.getPSRobotId() != null)) {
            iDataObject.set(FIELD_PSROBOTID, (Object)pSRobotBase.getPSRobotId());
        }
        if (pSRobotBase.isPSRobotNameDirty() && (bl || pSRobotBase.getPSRobotName() != null)) {
            iDataObject.set(FIELD_PSROBOTNAME, (Object)pSRobotBase.getPSRobotName());
        }
        if (pSRobotBase.isPSSvrDomainIdDirty() && (bl || pSRobotBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSRobotBase.getPSSvrDomainId());
        }
        if (pSRobotBase.isPSSvrDomainNameDirty() && (bl || pSRobotBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSRobotBase.getPSSvrDomainName());
        }
        if (pSRobotBase.isPSTaskServerIdDirty() && (bl || pSRobotBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSRobotBase.getPSTaskServerId());
        }
        if (pSRobotBase.isPSTaskServerNameDirty() && (bl || pSRobotBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSRobotBase.getPSTaskServerName());
        }
        if (pSRobotBase.isRefFlagDirty() && (bl || pSRobotBase.getRefFlag() != null)) {
            iDataObject.set(FIELD_REFFLAG, (Object)pSRobotBase.getRefFlag());
        }
        if (pSRobotBase.isRefObjIdDirty() && (bl || pSRobotBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSRobotBase.getRefObjId());
        }
        if (pSRobotBase.isRefObjNameDirty() && (bl || pSRobotBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSRobotBase.getRefObjName());
        }
        if (pSRobotBase.isRefObjTypeDirty() && (bl || pSRobotBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSRobotBase.getRefObjType());
        }
        if (pSRobotBase.isRobotLevelDirty() && (bl || pSRobotBase.getRobotLevel() != null)) {
            iDataObject.set(FIELD_ROBOTLEVEL, (Object)pSRobotBase.getRobotLevel());
        }
        if (pSRobotBase.isRobotStateDirty() && (bl || pSRobotBase.getRobotState() != null)) {
            iDataObject.set(FIELD_ROBOTSTATE, (Object)pSRobotBase.getRobotState());
        }
        if (pSRobotBase.isRobotTypeDirty() && (bl || pSRobotBase.getRobotType() != null)) {
            iDataObject.set(FIELD_ROBOTTYPE, (Object)pSRobotBase.getRobotType());
        }
        if (pSRobotBase.isUpdateDateDirty() && (bl || pSRobotBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotBase.getUpdateDate());
        }
        if (pSRobotBase.isUpdateManDirty() && (bl || pSRobotBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotBase.getUpdateMan());
        }
        if (pSRobotBase.isValidFlagDirty() && (bl || pSRobotBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotBase.getValidFlag());
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
        return PSRobotBase.remove(this, n);
    }

    private static boolean remove(PSRobotBase pSRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRobotBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRobotBase.resetCurEnergy();
                return true;
            }
            case 3: {
                pSRobotBase.resetEnergyRate();
                return true;
            }
            case 4: {
                pSRobotBase.resetExtEnergy();
                return true;
            }
            case 5: {
                pSRobotBase.resetLastCalcTime();
                return true;
            }
            case 6: {
                pSRobotBase.resetLastEnergy();
                return true;
            }
            case 7: {
                pSRobotBase.resetMaxEnergy();
                return true;
            }
            case 8: {
                pSRobotBase.resetMaxExtEnergy();
                return true;
            }
            case 9: {
                pSRobotBase.resetMemo();
                return true;
            }
            case 10: {
                pSRobotBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSRobotBase.resetParam();
                return true;
            }
            case 12: {
                pSRobotBase.resetParam2();
                return true;
            }
            case 13: {
                pSRobotBase.resetParam3();
                return true;
            }
            case 14: {
                pSRobotBase.resetParam4();
                return true;
            }
            case 15: {
                pSRobotBase.resetParam5();
                return true;
            }
            case 16: {
                pSRobotBase.resetParam6();
                return true;
            }
            case 17: {
                pSRobotBase.resetParam7();
                return true;
            }
            case 18: {
                pSRobotBase.resetParam8();
                return true;
            }
            case 19: {
                pSRobotBase.resetPSDevCenterId();
                return true;
            }
            case 20: {
                pSRobotBase.resetPSDevCenterName();
                return true;
            }
            case 21: {
                pSRobotBase.resetPSRobotId();
                return true;
            }
            case 22: {
                pSRobotBase.resetPSRobotName();
                return true;
            }
            case 23: {
                pSRobotBase.resetPSSvrDomainId();
                return true;
            }
            case 24: {
                pSRobotBase.resetPSSvrDomainName();
                return true;
            }
            case 25: {
                pSRobotBase.resetPSTaskServerId();
                return true;
            }
            case 26: {
                pSRobotBase.resetPSTaskServerName();
                return true;
            }
            case 27: {
                pSRobotBase.resetRefFlag();
                return true;
            }
            case 28: {
                pSRobotBase.resetRefObjId();
                return true;
            }
            case 29: {
                pSRobotBase.resetRefObjName();
                return true;
            }
            case 30: {
                pSRobotBase.resetRefObjType();
                return true;
            }
            case 31: {
                pSRobotBase.resetRobotLevel();
                return true;
            }
            case 32: {
                pSRobotBase.resetRobotState();
                return true;
            }
            case 33: {
                pSRobotBase.resetRobotType();
                return true;
            }
            case 34: {
                pSRobotBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSRobotBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSRobotBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSRobotBase getProxyEntity() {
        return this.proxyPSRobotBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotBase) {
            this.proxyPSRobotBase = (PSRobotBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRobotService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURENERGY, 2);
        fieldIndexMap.put(FIELD_ENERGYRATE, 3);
        fieldIndexMap.put(FIELD_EXTENERGY, 4);
        fieldIndexMap.put(FIELD_LASTCALCTIME, 5);
        fieldIndexMap.put(FIELD_LASTENERGY, 6);
        fieldIndexMap.put(FIELD_MAXENERGY, 7);
        fieldIndexMap.put(FIELD_MAXEXTENERGY, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PARAM, 11);
        fieldIndexMap.put(FIELD_PARAM2, 12);
        fieldIndexMap.put(FIELD_PARAM3, 13);
        fieldIndexMap.put(FIELD_PARAM4, 14);
        fieldIndexMap.put(FIELD_PARAM5, 15);
        fieldIndexMap.put(FIELD_PARAM6, 16);
        fieldIndexMap.put(FIELD_PARAM7, 17);
        fieldIndexMap.put(FIELD_PARAM8, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 20);
        fieldIndexMap.put(FIELD_PSROBOTID, 21);
        fieldIndexMap.put(FIELD_PSROBOTNAME, 22);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 23);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 24);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 25);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 26);
        fieldIndexMap.put(FIELD_REFFLAG, 27);
        fieldIndexMap.put(FIELD_REFOBJID, 28);
        fieldIndexMap.put(FIELD_REFOBJNAME, 29);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 30);
        fieldIndexMap.put(FIELD_ROBOTLEVEL, 31);
        fieldIndexMap.put(FIELD_ROBOTSTATE, 32);
        fieldIndexMap.put(FIELD_ROBOTTYPE, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_VALIDFLAG, 36);
    }
}

