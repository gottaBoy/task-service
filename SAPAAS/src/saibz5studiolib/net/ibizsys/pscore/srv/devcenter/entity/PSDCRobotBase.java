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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotAbility;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobot;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRobotBase.class);
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
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_PSROBOTID = "PSROBOTID";
    public static final String FIELD_PSROBOTNAME = "PSROBOTNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_ROBOTLEVEL = "ROBOTLEVEL";
    public static final String FIELD_ROBOTTYPE = "ROBOTTYPE";
    public static final String FIELD_TOTALENERGY = "TOTALENERGY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
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
    private static final int INDEX_PSDCROBOTID = 11;
    private static final int INDEX_PSDCROBOTNAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_PSDEVUSERID = 15;
    private static final int INDEX_PSDEVUSERNAME = 16;
    private static final int INDEX_PSROBOTID = 17;
    private static final int INDEX_PSROBOTNAME = 18;
    private static final int INDEX_PSTASKSERVERID = 19;
    private static final int INDEX_PSTASKSERVERNAME = 20;
    private static final int INDEX_REFOBJID = 21;
    private static final int INDEX_REFOBJNAME = 22;
    private static final int INDEX_REFOBJTYPE = 23;
    private static final int INDEX_RESSTATE = 24;
    private static final int INDEX_ROBOTLEVEL = 25;
    private static final int INDEX_ROBOTTYPE = 26;
    private static final int INDEX_TOTALENERGY = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRobotBase proxyPSDCRobotBase = null;
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
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean psrobotidDirtyFlag = false;
    private boolean psrobotnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean robotlevelDirtyFlag = false;
    private boolean robottypeDirtyFlag = false;
    private boolean totalenergyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="psrobotid")
    private String psrobotid;
    @Column(name="psrobotname")
    private String psrobotname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="robotlevel")
    private Integer robotlevel;
    @Column(name="robottype")
    private String robottype;
    @Column(name="totalenergy")
    private Integer totalenergy;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;
    private Integer objPSRobotLock = new Integer(1);
    private PSRobot psrobot = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSDCRobotAbilitiesLock = new Integer(1);
    private ArrayList<PSDCRobotAbility> psdcrobotabilities = null;

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

    public void setPSDCRobotId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotid = string;
        this.psdcrobotidDirtyFlag = true;
    }

    public String getPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotId();
        }
        return this.psdcrobotid;
    }

    public boolean isPSDCRobotIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotIdDirty();
        }
        return this.psdcrobotidDirtyFlag;
    }

    public void resetPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotId();
            return;
        }
        this.psdcrobotidDirtyFlag = false;
        this.psdcrobotid = null;
    }

    public void setPSDCRobotName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotname = string;
        this.psdcrobotnameDirtyFlag = true;
    }

    public String getPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotName();
        }
        return this.psdcrobotname;
    }

    public boolean isPSDCRobotNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotNameDirty();
        }
        return this.psdcrobotnameDirtyFlag;
    }

    public void resetPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotName();
            return;
        }
        this.psdcrobotnameDirtyFlag = false;
        this.psdcrobotname = null;
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

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
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

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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

    public void setTotalEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalEnergy(n);
            return;
        }
        this.totalenergy = n;
        this.totalenergyDirtyFlag = true;
    }

    public Integer getTotalEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalEnergy();
        }
        return this.totalenergy;
    }

    public boolean isTotalEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalEnergyDirty();
        }
        return this.totalenergyDirtyFlag;
    }

    public void resetTotalEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalEnergy();
            return;
        }
        this.totalenergyDirtyFlag = false;
        this.totalenergy = null;
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
        PSDCRobotBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRobotBase pSDCRobotBase) {
        pSDCRobotBase.resetCreateDate();
        pSDCRobotBase.resetCreateMan();
        pSDCRobotBase.resetCurEnergy();
        pSDCRobotBase.resetEnergyRate();
        pSDCRobotBase.resetExtEnergy();
        pSDCRobotBase.resetLastCalcTime();
        pSDCRobotBase.resetLastEnergy();
        pSDCRobotBase.resetMaxEnergy();
        pSDCRobotBase.resetMaxExtEnergy();
        pSDCRobotBase.resetMemo();
        pSDCRobotBase.resetOrderValue();
        pSDCRobotBase.resetPSDCRobotId();
        pSDCRobotBase.resetPSDCRobotName();
        pSDCRobotBase.resetPSDevCenterId();
        pSDCRobotBase.resetPSDevCenterName();
        pSDCRobotBase.resetPSDevUserId();
        pSDCRobotBase.resetPSDevUserName();
        pSDCRobotBase.resetPSRobotId();
        pSDCRobotBase.resetPSRobotName();
        pSDCRobotBase.resetPSTaskServerId();
        pSDCRobotBase.resetPSTaskServerName();
        pSDCRobotBase.resetRefObjId();
        pSDCRobotBase.resetRefObjName();
        pSDCRobotBase.resetRefObjType();
        pSDCRobotBase.resetResState();
        pSDCRobotBase.resetRobotLevel();
        pSDCRobotBase.resetRobotType();
        pSDCRobotBase.resetTotalEnergy();
        pSDCRobotBase.resetUpdateDate();
        pSDCRobotBase.resetUpdateMan();
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
        if (!bl || this.isPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTID, this.getPSDCRobotId());
        }
        if (!bl || this.isPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTNAME, this.getPSDCRobotName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isPSRobotIdDirty()) {
            hashMap.put(FIELD_PSROBOTID, this.getPSRobotId());
        }
        if (!bl || this.isPSRobotNameDirty()) {
            hashMap.put(FIELD_PSROBOTNAME, this.getPSRobotName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isRobotLevelDirty()) {
            hashMap.put(FIELD_ROBOTLEVEL, this.getRobotLevel());
        }
        if (!bl || this.isRobotTypeDirty()) {
            hashMap.put(FIELD_ROBOTTYPE, this.getRobotType());
        }
        if (!bl || this.isTotalEnergyDirty()) {
            hashMap.put(FIELD_TOTALENERGY, this.getTotalEnergy());
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
        return PSDCRobotBase.get(this, n);
    }

    private static Object get(PSDCRobotBase pSDCRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotBase.getCreateDate();
            }
            case 1: {
                return pSDCRobotBase.getCreateMan();
            }
            case 2: {
                return pSDCRobotBase.getCurEnergy();
            }
            case 3: {
                return pSDCRobotBase.getEnergyRate();
            }
            case 4: {
                return pSDCRobotBase.getExtEnergy();
            }
            case 5: {
                return pSDCRobotBase.getLastCalcTime();
            }
            case 6: {
                return pSDCRobotBase.getLastEnergy();
            }
            case 7: {
                return pSDCRobotBase.getMaxEnergy();
            }
            case 8: {
                return pSDCRobotBase.getMaxExtEnergy();
            }
            case 9: {
                return pSDCRobotBase.getMemo();
            }
            case 10: {
                return pSDCRobotBase.getOrderValue();
            }
            case 11: {
                return pSDCRobotBase.getPSDCRobotId();
            }
            case 12: {
                return pSDCRobotBase.getPSDCRobotName();
            }
            case 13: {
                return pSDCRobotBase.getPSDevCenterId();
            }
            case 14: {
                return pSDCRobotBase.getPSDevCenterName();
            }
            case 15: {
                return pSDCRobotBase.getPSDevUserId();
            }
            case 16: {
                return pSDCRobotBase.getPSDevUserName();
            }
            case 17: {
                return pSDCRobotBase.getPSRobotId();
            }
            case 18: {
                return pSDCRobotBase.getPSRobotName();
            }
            case 19: {
                return pSDCRobotBase.getPSTaskServerId();
            }
            case 20: {
                return pSDCRobotBase.getPSTaskServerName();
            }
            case 21: {
                return pSDCRobotBase.getRefObjId();
            }
            case 22: {
                return pSDCRobotBase.getRefObjName();
            }
            case 23: {
                return pSDCRobotBase.getRefObjType();
            }
            case 24: {
                return pSDCRobotBase.getResState();
            }
            case 25: {
                return pSDCRobotBase.getRobotLevel();
            }
            case 26: {
                return pSDCRobotBase.getRobotType();
            }
            case 27: {
                return pSDCRobotBase.getTotalEnergy();
            }
            case 28: {
                return pSDCRobotBase.getUpdateDate();
            }
            case 29: {
                return pSDCRobotBase.getUpdateMan();
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
        PSDCRobotBase.set(this, n, object);
    }

    private static void set(PSDCRobotBase pSDCRobotBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCRobotBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCRobotBase.setCurEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCRobotBase.setEnergyRate(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSDCRobotBase.setExtEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCRobotBase.setLastCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCRobotBase.setLastEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDCRobotBase.setMaxEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCRobotBase.setMaxExtEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCRobotBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRobotBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCRobotBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRobotBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCRobotBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRobotBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCRobotBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRobotBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCRobotBase.setPSRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCRobotBase.setPSRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCRobotBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCRobotBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCRobotBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCRobotBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCRobotBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCRobotBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCRobotBase.setRobotLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDCRobotBase.setRobotType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCRobotBase.setTotalEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDCRobotBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDCRobotBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCRobotBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRobotBase pSDCRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCRobotBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCRobotBase.getCurEnergy() == null;
            }
            case 3: {
                return pSDCRobotBase.getEnergyRate() == null;
            }
            case 4: {
                return pSDCRobotBase.getExtEnergy() == null;
            }
            case 5: {
                return pSDCRobotBase.getLastCalcTime() == null;
            }
            case 6: {
                return pSDCRobotBase.getLastEnergy() == null;
            }
            case 7: {
                return pSDCRobotBase.getMaxEnergy() == null;
            }
            case 8: {
                return pSDCRobotBase.getMaxExtEnergy() == null;
            }
            case 9: {
                return pSDCRobotBase.getMemo() == null;
            }
            case 10: {
                return pSDCRobotBase.getOrderValue() == null;
            }
            case 11: {
                return pSDCRobotBase.getPSDCRobotId() == null;
            }
            case 12: {
                return pSDCRobotBase.getPSDCRobotName() == null;
            }
            case 13: {
                return pSDCRobotBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDCRobotBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDCRobotBase.getPSDevUserId() == null;
            }
            case 16: {
                return pSDCRobotBase.getPSDevUserName() == null;
            }
            case 17: {
                return pSDCRobotBase.getPSRobotId() == null;
            }
            case 18: {
                return pSDCRobotBase.getPSRobotName() == null;
            }
            case 19: {
                return pSDCRobotBase.getPSTaskServerId() == null;
            }
            case 20: {
                return pSDCRobotBase.getPSTaskServerName() == null;
            }
            case 21: {
                return pSDCRobotBase.getRefObjId() == null;
            }
            case 22: {
                return pSDCRobotBase.getRefObjName() == null;
            }
            case 23: {
                return pSDCRobotBase.getRefObjType() == null;
            }
            case 24: {
                return pSDCRobotBase.getResState() == null;
            }
            case 25: {
                return pSDCRobotBase.getRobotLevel() == null;
            }
            case 26: {
                return pSDCRobotBase.getRobotType() == null;
            }
            case 27: {
                return pSDCRobotBase.getTotalEnergy() == null;
            }
            case 28: {
                return pSDCRobotBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDCRobotBase.getUpdateMan() == null;
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
        return PSDCRobotBase.contains(this, n);
    }

    private static boolean contains(PSDCRobotBase pSDCRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCRobotBase.isCreateManDirty();
            }
            case 2: {
                return pSDCRobotBase.isCurEnergyDirty();
            }
            case 3: {
                return pSDCRobotBase.isEnergyRateDirty();
            }
            case 4: {
                return pSDCRobotBase.isExtEnergyDirty();
            }
            case 5: {
                return pSDCRobotBase.isLastCalcTimeDirty();
            }
            case 6: {
                return pSDCRobotBase.isLastEnergyDirty();
            }
            case 7: {
                return pSDCRobotBase.isMaxEnergyDirty();
            }
            case 8: {
                return pSDCRobotBase.isMaxExtEnergyDirty();
            }
            case 9: {
                return pSDCRobotBase.isMemoDirty();
            }
            case 10: {
                return pSDCRobotBase.isOrderValueDirty();
            }
            case 11: {
                return pSDCRobotBase.isPSDCRobotIdDirty();
            }
            case 12: {
                return pSDCRobotBase.isPSDCRobotNameDirty();
            }
            case 13: {
                return pSDCRobotBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDCRobotBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDCRobotBase.isPSDevUserIdDirty();
            }
            case 16: {
                return pSDCRobotBase.isPSDevUserNameDirty();
            }
            case 17: {
                return pSDCRobotBase.isPSRobotIdDirty();
            }
            case 18: {
                return pSDCRobotBase.isPSRobotNameDirty();
            }
            case 19: {
                return pSDCRobotBase.isPSTaskServerIdDirty();
            }
            case 20: {
                return pSDCRobotBase.isPSTaskServerNameDirty();
            }
            case 21: {
                return pSDCRobotBase.isRefObjIdDirty();
            }
            case 22: {
                return pSDCRobotBase.isRefObjNameDirty();
            }
            case 23: {
                return pSDCRobotBase.isRefObjTypeDirty();
            }
            case 24: {
                return pSDCRobotBase.isResStateDirty();
            }
            case 25: {
                return pSDCRobotBase.isRobotLevelDirty();
            }
            case 26: {
                return pSDCRobotBase.isRobotTypeDirty();
            }
            case 27: {
                return pSDCRobotBase.isTotalEnergyDirty();
            }
            case 28: {
                return pSDCRobotBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDCRobotBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRobotBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRobotBase pSDCRobotBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRobotBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getCurEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getCurEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getEnergyRate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energyrate", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getEnergyRate()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getExtEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getExtEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getLastCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcalctime", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getLastCalcTime()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getLastEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getLastEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getMaxEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getMaxEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getMaxExtEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxextenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getMaxExtEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSRobotId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotname", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSRobotName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getResState()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getRobotLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotlevel", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getRobotLevel()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getRobotType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robottype", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getRobotType()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getTotalEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalenergy", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getTotalEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRobotBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRobotBase.getJSONValue((Object)pSDCRobotBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRobotBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRobotBase pSDCRobotBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRobotBase.getCreateDate() != null) {
            object = pSDCRobotBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotBase.getCreateMan() != null) {
            object = pSDCRobotBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getCurEnergy() != null) {
            object = pSDCRobotBase.getCurEnergy();
            xmlNode.setAttribute(FIELD_CURENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getEnergyRate() != null) {
            object = pSDCRobotBase.getEnergyRate();
            xmlNode.setAttribute(FIELD_ENERGYRATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getExtEnergy() != null) {
            object = pSDCRobotBase.getExtEnergy();
            xmlNode.setAttribute(FIELD_EXTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getLastCalcTime() != null) {
            object = pSDCRobotBase.getLastCalcTime();
            xmlNode.setAttribute(FIELD_LASTCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotBase.getLastEnergy() != null) {
            object = pSDCRobotBase.getLastEnergy();
            xmlNode.setAttribute(FIELD_LASTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getMaxEnergy() != null) {
            object = pSDCRobotBase.getMaxEnergy();
            xmlNode.setAttribute(FIELD_MAXENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getMaxExtEnergy() != null) {
            object = pSDCRobotBase.getMaxExtEnergy();
            xmlNode.setAttribute(FIELD_MAXEXTENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getMemo() != null) {
            object = pSDCRobotBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getOrderValue() != null) {
            object = pSDCRobotBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getPSDCRobotId() != null) {
            object = pSDCRobotBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSDCRobotName() != null) {
            object = pSDCRobotBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSDevCenterId() != null) {
            object = pSDCRobotBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSDevCenterName() != null) {
            object = pSDCRobotBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSDevUserId() != null) {
            object = pSDCRobotBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSDevUserName() != null) {
            object = pSDCRobotBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSRobotId() != null) {
            object = pSDCRobotBase.getPSRobotId();
            xmlNode.setAttribute(FIELD_PSROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSRobotName() != null) {
            object = pSDCRobotBase.getPSRobotName();
            xmlNode.setAttribute(FIELD_PSROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSTaskServerId() != null) {
            object = pSDCRobotBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getPSTaskServerName() != null) {
            object = pSDCRobotBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getRefObjId() != null) {
            object = pSDCRobotBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getRefObjName() != null) {
            object = pSDCRobotBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getRefObjType() != null) {
            object = pSDCRobotBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getResState() != null) {
            object = pSDCRobotBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getRobotLevel() != null) {
            object = pSDCRobotBase.getRobotLevel();
            xmlNode.setAttribute(FIELD_ROBOTLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getRobotType() != null) {
            object = pSDCRobotBase.getRobotType();
            xmlNode.setAttribute(FIELD_ROBOTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotBase.getTotalEnergy() != null) {
            object = pSDCRobotBase.getTotalEnergy();
            xmlNode.setAttribute(FIELD_TOTALENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotBase.getUpdateDate() != null) {
            object = pSDCRobotBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotBase.getUpdateMan() != null) {
            object = pSDCRobotBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRobotBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRobotBase pSDCRobotBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRobotBase.isCreateDateDirty() && (bl || pSDCRobotBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRobotBase.getCreateDate());
        }
        if (pSDCRobotBase.isCreateManDirty() && (bl || pSDCRobotBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRobotBase.getCreateMan());
        }
        if (pSDCRobotBase.isCurEnergyDirty() && (bl || pSDCRobotBase.getCurEnergy() != null)) {
            iDataObject.set(FIELD_CURENERGY, (Object)pSDCRobotBase.getCurEnergy());
        }
        if (pSDCRobotBase.isEnergyRateDirty() && (bl || pSDCRobotBase.getEnergyRate() != null)) {
            iDataObject.set(FIELD_ENERGYRATE, (Object)pSDCRobotBase.getEnergyRate());
        }
        if (pSDCRobotBase.isExtEnergyDirty() && (bl || pSDCRobotBase.getExtEnergy() != null)) {
            iDataObject.set(FIELD_EXTENERGY, (Object)pSDCRobotBase.getExtEnergy());
        }
        if (pSDCRobotBase.isLastCalcTimeDirty() && (bl || pSDCRobotBase.getLastCalcTime() != null)) {
            iDataObject.set(FIELD_LASTCALCTIME, (Object)pSDCRobotBase.getLastCalcTime());
        }
        if (pSDCRobotBase.isLastEnergyDirty() && (bl || pSDCRobotBase.getLastEnergy() != null)) {
            iDataObject.set(FIELD_LASTENERGY, (Object)pSDCRobotBase.getLastEnergy());
        }
        if (pSDCRobotBase.isMaxEnergyDirty() && (bl || pSDCRobotBase.getMaxEnergy() != null)) {
            iDataObject.set(FIELD_MAXENERGY, (Object)pSDCRobotBase.getMaxEnergy());
        }
        if (pSDCRobotBase.isMaxExtEnergyDirty() && (bl || pSDCRobotBase.getMaxExtEnergy() != null)) {
            iDataObject.set(FIELD_MAXEXTENERGY, (Object)pSDCRobotBase.getMaxExtEnergy());
        }
        if (pSDCRobotBase.isMemoDirty() && (bl || pSDCRobotBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCRobotBase.getMemo());
        }
        if (pSDCRobotBase.isOrderValueDirty() && (bl || pSDCRobotBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDCRobotBase.getOrderValue());
        }
        if (pSDCRobotBase.isPSDCRobotIdDirty() && (bl || pSDCRobotBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSDCRobotBase.getPSDCRobotId());
        }
        if (pSDCRobotBase.isPSDCRobotNameDirty() && (bl || pSDCRobotBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSDCRobotBase.getPSDCRobotName());
        }
        if (pSDCRobotBase.isPSDevCenterIdDirty() && (bl || pSDCRobotBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCRobotBase.getPSDevCenterId());
        }
        if (pSDCRobotBase.isPSDevCenterNameDirty() && (bl || pSDCRobotBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCRobotBase.getPSDevCenterName());
        }
        if (pSDCRobotBase.isPSDevUserIdDirty() && (bl || pSDCRobotBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDCRobotBase.getPSDevUserId());
        }
        if (pSDCRobotBase.isPSDevUserNameDirty() && (bl || pSDCRobotBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDCRobotBase.getPSDevUserName());
        }
        if (pSDCRobotBase.isPSRobotIdDirty() && (bl || pSDCRobotBase.getPSRobotId() != null)) {
            iDataObject.set(FIELD_PSROBOTID, (Object)pSDCRobotBase.getPSRobotId());
        }
        if (pSDCRobotBase.isPSRobotNameDirty() && (bl || pSDCRobotBase.getPSRobotName() != null)) {
            iDataObject.set(FIELD_PSROBOTNAME, (Object)pSDCRobotBase.getPSRobotName());
        }
        if (pSDCRobotBase.isPSTaskServerIdDirty() && (bl || pSDCRobotBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDCRobotBase.getPSTaskServerId());
        }
        if (pSDCRobotBase.isPSTaskServerNameDirty() && (bl || pSDCRobotBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDCRobotBase.getPSTaskServerName());
        }
        if (pSDCRobotBase.isRefObjIdDirty() && (bl || pSDCRobotBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDCRobotBase.getRefObjId());
        }
        if (pSDCRobotBase.isRefObjNameDirty() && (bl || pSDCRobotBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDCRobotBase.getRefObjName());
        }
        if (pSDCRobotBase.isRefObjTypeDirty() && (bl || pSDCRobotBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSDCRobotBase.getRefObjType());
        }
        if (pSDCRobotBase.isResStateDirty() && (bl || pSDCRobotBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCRobotBase.getResState());
        }
        if (pSDCRobotBase.isRobotLevelDirty() && (bl || pSDCRobotBase.getRobotLevel() != null)) {
            iDataObject.set(FIELD_ROBOTLEVEL, (Object)pSDCRobotBase.getRobotLevel());
        }
        if (pSDCRobotBase.isRobotTypeDirty() && (bl || pSDCRobotBase.getRobotType() != null)) {
            iDataObject.set(FIELD_ROBOTTYPE, (Object)pSDCRobotBase.getRobotType());
        }
        if (pSDCRobotBase.isTotalEnergyDirty() && (bl || pSDCRobotBase.getTotalEnergy() != null)) {
            iDataObject.set(FIELD_TOTALENERGY, (Object)pSDCRobotBase.getTotalEnergy());
        }
        if (pSDCRobotBase.isUpdateDateDirty() && (bl || pSDCRobotBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRobotBase.getUpdateDate());
        }
        if (pSDCRobotBase.isUpdateManDirty() && (bl || pSDCRobotBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRobotBase.getUpdateMan());
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
        return PSDCRobotBase.remove(this, n);
    }

    private static boolean remove(PSDCRobotBase pSDCRobotBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCRobotBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCRobotBase.resetCurEnergy();
                return true;
            }
            case 3: {
                pSDCRobotBase.resetEnergyRate();
                return true;
            }
            case 4: {
                pSDCRobotBase.resetExtEnergy();
                return true;
            }
            case 5: {
                pSDCRobotBase.resetLastCalcTime();
                return true;
            }
            case 6: {
                pSDCRobotBase.resetLastEnergy();
                return true;
            }
            case 7: {
                pSDCRobotBase.resetMaxEnergy();
                return true;
            }
            case 8: {
                pSDCRobotBase.resetMaxExtEnergy();
                return true;
            }
            case 9: {
                pSDCRobotBase.resetMemo();
                return true;
            }
            case 10: {
                pSDCRobotBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSDCRobotBase.resetPSDCRobotId();
                return true;
            }
            case 12: {
                pSDCRobotBase.resetPSDCRobotName();
                return true;
            }
            case 13: {
                pSDCRobotBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDCRobotBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDCRobotBase.resetPSDevUserId();
                return true;
            }
            case 16: {
                pSDCRobotBase.resetPSDevUserName();
                return true;
            }
            case 17: {
                pSDCRobotBase.resetPSRobotId();
                return true;
            }
            case 18: {
                pSDCRobotBase.resetPSRobotName();
                return true;
            }
            case 19: {
                pSDCRobotBase.resetPSTaskServerId();
                return true;
            }
            case 20: {
                pSDCRobotBase.resetPSTaskServerName();
                return true;
            }
            case 21: {
                pSDCRobotBase.resetRefObjId();
                return true;
            }
            case 22: {
                pSDCRobotBase.resetRefObjName();
                return true;
            }
            case 23: {
                pSDCRobotBase.resetRefObjType();
                return true;
            }
            case 24: {
                pSDCRobotBase.resetResState();
                return true;
            }
            case 25: {
                pSDCRobotBase.resetRobotLevel();
                return true;
            }
            case 26: {
                pSDCRobotBase.resetRobotType();
                return true;
            }
            case 27: {
                pSDCRobotBase.resetTotalEnergy();
                return true;
            }
            case 28: {
                pSDCRobotBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDCRobotBase.resetUpdateMan();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet((IEntity)pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRobot getPSRobot() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobot();
        }
        if (this.getPSRobotId() == null) {
            return null;
        }
        Integer n = this.objPSRobotLock;
        synchronized (n) {
            if (this.psrobot != null && DataTypeHelper.compare((int)25, (Object)this.getPSRobotId(), (Object)this.psrobot.getPSRobotId()) != 0L) {
                this.psrobot = null;
            }
            if (this.psrobot == null) {
                PSRobot pSRobot = new PSRobot();
                pSRobot.setPSRobotId(this.getPSRobotId());
                PSRobotService pSRobotService = (PSRobotService)ServiceGlobal.getService(PSRobotService.class, (SessionFactory)this.getSessionFactory());
                pSRobotService.autoGet((IEntity)pSRobot);
                this.psrobot = pSRobot;
            }
            return this.psrobot;
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
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRobotAbility> getPSDCRobotAbilities() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotAbilities();
        }
        if (this.getPSDCRobotId() == null) {
            return null;
        }
        PSDCRobotAbilityService pSDCRobotAbilityService = (PSDCRobotAbilityService)ServiceGlobal.getService(PSDCRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRobotAbilitiesLock;
        synchronized (n) {
            if (this.psdcrobotabilities == null) {
                this.psdcrobotabilities = pSDCRobotAbilityService.selectByPSDCRobot(this);
            }
            return this.psdcrobotabilities;
        }
    }

    private PSDCRobotBase getProxyEntity() {
        return this.proxyPSDCRobotBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRobotBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRobotBase) {
            this.proxyPSDCRobotBase = (PSDCRobotBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDCROBOTID, 11);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 15);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 16);
        fieldIndexMap.put(FIELD_PSROBOTID, 17);
        fieldIndexMap.put(FIELD_PSROBOTNAME, 18);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 19);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 20);
        fieldIndexMap.put(FIELD_REFOBJID, 21);
        fieldIndexMap.put(FIELD_REFOBJNAME, 22);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 23);
        fieldIndexMap.put(FIELD_RESSTATE, 24);
        fieldIndexMap.put(FIELD_ROBOTLEVEL, 25);
        fieldIndexMap.put(FIELD_ROBOTTYPE, 26);
        fieldIndexMap.put(FIELD_TOTALENERGY, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
    }
}

