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
import net.ibizsys.pscore.srv.config.entity.PSRobotAbility;
import net.ibizsys.pscore.srv.config.service.PSRobotAbilityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotAbilityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRobotAbilityBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENERGY = "ENERGY";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCROBOTABILITYID = "PSDCROBOTABILITYID";
    public static final String FIELD_PSDCROBOTABILITYNAME = "PSDCROBOTABILITYNAME";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSROBOTABILITYID = "PSROBOTABILITYID";
    public static final String FIELD_PSROBOTABILITYNAME = "PSROBOTABILITYNAME";
    public static final String FIELD_ROBOTWORKTYPE = "ROBOTWORKTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENERGY = 2;
    private static final int INDEX_EXPIREDTIME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDCROBOTABILITYID = 5;
    private static final int INDEX_PSDCROBOTABILITYNAME = 6;
    private static final int INDEX_PSDCROBOTID = 7;
    private static final int INDEX_PSDCROBOTNAME = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSROBOTABILITYID = 11;
    private static final int INDEX_PSROBOTABILITYNAME = 12;
    private static final int INDEX_ROBOTWORKTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRobotAbilityBase proxyPSDCRobotAbilityBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean energyDirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcrobotabilityidDirtyFlag = false;
    private boolean psdcrobotabilitynameDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psrobotabilityidDirtyFlag = false;
    private boolean psrobotabilitynameDirtyFlag = false;
    private boolean robotworktypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="energy")
    private Integer energy;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcrobotabilityid")
    private String psdcrobotabilityid;
    @Column(name="psdcrobotabilityname")
    private String psdcrobotabilityname;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psrobotabilityid")
    private String psrobotabilityid;
    @Column(name="psrobotabilityname")
    private String psrobotabilityname;
    @Column(name="robotworktype")
    private String robotworktype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSRobotAbilityLock = new Integer(1);
    private PSRobotAbility psrobotability = null;

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

    public void setEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnergy(n);
            return;
        }
        this.energy = n;
        this.energyDirtyFlag = true;
    }

    public Integer getEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnergy();
        }
        return this.energy;
    }

    public boolean isEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnergyDirty();
        }
        return this.energyDirtyFlag;
    }

    public void resetEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnergy();
            return;
        }
        this.energyDirtyFlag = false;
        this.energy = null;
    }

    public void setExpiredTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(timestamp);
            return;
        }
        this.expiredtime = timestamp;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
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

    public void setPSDCRobotAbilityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotAbilityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotabilityid = string;
        this.psdcrobotabilityidDirtyFlag = true;
    }

    public String getPSDCRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotAbilityId();
        }
        return this.psdcrobotabilityid;
    }

    public boolean isPSDCRobotAbilityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotAbilityIdDirty();
        }
        return this.psdcrobotabilityidDirtyFlag;
    }

    public void resetPSDCRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotAbilityId();
            return;
        }
        this.psdcrobotabilityidDirtyFlag = false;
        this.psdcrobotabilityid = null;
    }

    public void setPSDCRobotAbilityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotAbilityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotabilityname = string;
        this.psdcrobotabilitynameDirtyFlag = true;
    }

    public String getPSDCRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotAbilityName();
        }
        return this.psdcrobotabilityname;
    }

    public boolean isPSDCRobotAbilityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotAbilityNameDirty();
        }
        return this.psdcrobotabilitynameDirtyFlag;
    }

    public void resetPSDCRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotAbilityName();
            return;
        }
        this.psdcrobotabilitynameDirtyFlag = false;
        this.psdcrobotabilityname = null;
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

    public void setPSRobotAbilityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotAbilityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotabilityid = string;
        this.psrobotabilityidDirtyFlag = true;
    }

    public String getPSRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotAbilityId();
        }
        return this.psrobotabilityid;
    }

    public boolean isPSRobotAbilityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotAbilityIdDirty();
        }
        return this.psrobotabilityidDirtyFlag;
    }

    public void resetPSRobotAbilityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotAbilityId();
            return;
        }
        this.psrobotabilityidDirtyFlag = false;
        this.psrobotabilityid = null;
    }

    public void setPSRobotAbilityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotAbilityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotabilityname = string;
        this.psrobotabilitynameDirtyFlag = true;
    }

    public String getPSRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotAbilityName();
        }
        return this.psrobotabilityname;
    }

    public boolean isPSRobotAbilityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotAbilityNameDirty();
        }
        return this.psrobotabilitynameDirtyFlag;
    }

    public void resetPSRobotAbilityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotAbilityName();
            return;
        }
        this.psrobotabilitynameDirtyFlag = false;
        this.psrobotabilityname = null;
    }

    public void setRobotWorkType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRobotWorkType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.robotworktype = string;
        this.robotworktypeDirtyFlag = true;
    }

    public String getRobotWorkType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRobotWorkType();
        }
        return this.robotworktype;
    }

    public boolean isRobotWorkTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRobotWorkTypeDirty();
        }
        return this.robotworktypeDirtyFlag;
    }

    public void resetRobotWorkType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRobotWorkType();
            return;
        }
        this.robotworktypeDirtyFlag = false;
        this.robotworktype = null;
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
        PSDCRobotAbilityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRobotAbilityBase pSDCRobotAbilityBase) {
        pSDCRobotAbilityBase.resetCreateDate();
        pSDCRobotAbilityBase.resetCreateMan();
        pSDCRobotAbilityBase.resetEnergy();
        pSDCRobotAbilityBase.resetExpiredTime();
        pSDCRobotAbilityBase.resetMemo();
        pSDCRobotAbilityBase.resetPSDCRobotAbilityId();
        pSDCRobotAbilityBase.resetPSDCRobotAbilityName();
        pSDCRobotAbilityBase.resetPSDCRobotId();
        pSDCRobotAbilityBase.resetPSDCRobotName();
        pSDCRobotAbilityBase.resetPSDevCenterId();
        pSDCRobotAbilityBase.resetPSDevCenterName();
        pSDCRobotAbilityBase.resetPSRobotAbilityId();
        pSDCRobotAbilityBase.resetPSRobotAbilityName();
        pSDCRobotAbilityBase.resetRobotWorkType();
        pSDCRobotAbilityBase.resetUpdateDate();
        pSDCRobotAbilityBase.resetUpdateMan();
        pSDCRobotAbilityBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnergyDirty()) {
            hashMap.put(FIELD_ENERGY, this.getEnergy());
        }
        if (!bl || this.isExpiredTimeDirty()) {
            hashMap.put(FIELD_EXPIREDTIME, this.getExpiredTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCRobotAbilityIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTABILITYID, this.getPSDCRobotAbilityId());
        }
        if (!bl || this.isPSDCRobotAbilityNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTABILITYNAME, this.getPSDCRobotAbilityName());
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
        if (!bl || this.isPSRobotAbilityIdDirty()) {
            hashMap.put(FIELD_PSROBOTABILITYID, this.getPSRobotAbilityId());
        }
        if (!bl || this.isPSRobotAbilityNameDirty()) {
            hashMap.put(FIELD_PSROBOTABILITYNAME, this.getPSRobotAbilityName());
        }
        if (!bl || this.isRobotWorkTypeDirty()) {
            hashMap.put(FIELD_ROBOTWORKTYPE, this.getRobotWorkType());
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
        return PSDCRobotAbilityBase.get(this, n);
    }

    private static Object get(PSDCRobotAbilityBase pSDCRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotAbilityBase.getCreateDate();
            }
            case 1: {
                return pSDCRobotAbilityBase.getCreateMan();
            }
            case 2: {
                return pSDCRobotAbilityBase.getEnergy();
            }
            case 3: {
                return pSDCRobotAbilityBase.getExpiredTime();
            }
            case 4: {
                return pSDCRobotAbilityBase.getMemo();
            }
            case 5: {
                return pSDCRobotAbilityBase.getPSDCRobotAbilityId();
            }
            case 6: {
                return pSDCRobotAbilityBase.getPSDCRobotAbilityName();
            }
            case 7: {
                return pSDCRobotAbilityBase.getPSDCRobotId();
            }
            case 8: {
                return pSDCRobotAbilityBase.getPSDCRobotName();
            }
            case 9: {
                return pSDCRobotAbilityBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCRobotAbilityBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCRobotAbilityBase.getPSRobotAbilityId();
            }
            case 12: {
                return pSDCRobotAbilityBase.getPSRobotAbilityName();
            }
            case 13: {
                return pSDCRobotAbilityBase.getRobotWorkType();
            }
            case 14: {
                return pSDCRobotAbilityBase.getUpdateDate();
            }
            case 15: {
                return pSDCRobotAbilityBase.getUpdateMan();
            }
            case 16: {
                return pSDCRobotAbilityBase.getValidFlag();
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
        PSDCRobotAbilityBase.set(this, n, object);
    }

    private static void set(PSDCRobotAbilityBase pSDCRobotAbilityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotAbilityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCRobotAbilityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCRobotAbilityBase.setEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCRobotAbilityBase.setExpiredTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCRobotAbilityBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCRobotAbilityBase.setPSDCRobotAbilityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCRobotAbilityBase.setPSDCRobotAbilityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCRobotAbilityBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCRobotAbilityBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCRobotAbilityBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRobotAbilityBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCRobotAbilityBase.setPSRobotAbilityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRobotAbilityBase.setPSRobotAbilityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCRobotAbilityBase.setRobotWorkType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRobotAbilityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDCRobotAbilityBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRobotAbilityBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCRobotAbilityBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRobotAbilityBase pSDCRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotAbilityBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCRobotAbilityBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCRobotAbilityBase.getEnergy() == null;
            }
            case 3: {
                return pSDCRobotAbilityBase.getExpiredTime() == null;
            }
            case 4: {
                return pSDCRobotAbilityBase.getMemo() == null;
            }
            case 5: {
                return pSDCRobotAbilityBase.getPSDCRobotAbilityId() == null;
            }
            case 6: {
                return pSDCRobotAbilityBase.getPSDCRobotAbilityName() == null;
            }
            case 7: {
                return pSDCRobotAbilityBase.getPSDCRobotId() == null;
            }
            case 8: {
                return pSDCRobotAbilityBase.getPSDCRobotName() == null;
            }
            case 9: {
                return pSDCRobotAbilityBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCRobotAbilityBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCRobotAbilityBase.getPSRobotAbilityId() == null;
            }
            case 12: {
                return pSDCRobotAbilityBase.getPSRobotAbilityName() == null;
            }
            case 13: {
                return pSDCRobotAbilityBase.getRobotWorkType() == null;
            }
            case 14: {
                return pSDCRobotAbilityBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDCRobotAbilityBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDCRobotAbilityBase.getValidFlag() == null;
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
        return PSDCRobotAbilityBase.contains(this, n);
    }

    private static boolean contains(PSDCRobotAbilityBase pSDCRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotAbilityBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCRobotAbilityBase.isCreateManDirty();
            }
            case 2: {
                return pSDCRobotAbilityBase.isEnergyDirty();
            }
            case 3: {
                return pSDCRobotAbilityBase.isExpiredTimeDirty();
            }
            case 4: {
                return pSDCRobotAbilityBase.isMemoDirty();
            }
            case 5: {
                return pSDCRobotAbilityBase.isPSDCRobotAbilityIdDirty();
            }
            case 6: {
                return pSDCRobotAbilityBase.isPSDCRobotAbilityNameDirty();
            }
            case 7: {
                return pSDCRobotAbilityBase.isPSDCRobotIdDirty();
            }
            case 8: {
                return pSDCRobotAbilityBase.isPSDCRobotNameDirty();
            }
            case 9: {
                return pSDCRobotAbilityBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCRobotAbilityBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCRobotAbilityBase.isPSRobotAbilityIdDirty();
            }
            case 12: {
                return pSDCRobotAbilityBase.isPSRobotAbilityNameDirty();
            }
            case 13: {
                return pSDCRobotAbilityBase.isRobotWorkTypeDirty();
            }
            case 14: {
                return pSDCRobotAbilityBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDCRobotAbilityBase.isUpdateManDirty();
            }
            case 16: {
                return pSDCRobotAbilityBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRobotAbilityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRobotAbilityBase pSDCRobotAbilityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRobotAbilityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energy", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getExpiredTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expiredtime", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getExpiredTime()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotabilityid", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDCRobotAbilityId()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotabilityname", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDCRobotAbilityName()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSRobotAbilityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotabilityid", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSRobotAbilityId()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getPSRobotAbilityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotabilityname", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getPSRobotAbilityName()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getRobotWorkType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotworktype", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getRobotWorkType()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCRobotAbilityBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCRobotAbilityBase.getJSONValue((Object)pSDCRobotAbilityBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRobotAbilityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRobotAbilityBase pSDCRobotAbilityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRobotAbilityBase.getCreateDate() != null) {
            object = pSDCRobotAbilityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotAbilityBase.getCreateMan() != null) {
            object = pSDCRobotAbilityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getEnergy() != null) {
            object = pSDCRobotAbilityBase.getEnergy();
            xmlNode.setAttribute(FIELD_ENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotAbilityBase.getExpiredTime() != null) {
            object = pSDCRobotAbilityBase.getExpiredTime();
            xmlNode.setAttribute(FIELD_EXPIREDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotAbilityBase.getMemo() != null) {
            object = pSDCRobotAbilityBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityId() != null) {
            object = pSDCRobotAbilityBase.getPSDCRobotAbilityId();
            xmlNode.setAttribute(FIELD_PSDCROBOTABILITYID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityName() != null) {
            object = pSDCRobotAbilityBase.getPSDCRobotAbilityName();
            xmlNode.setAttribute(FIELD_PSDCROBOTABILITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotId() != null) {
            object = pSDCRobotAbilityBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDCRobotName() != null) {
            object = pSDCRobotAbilityBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDevCenterId() != null) {
            object = pSDCRobotAbilityBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSDevCenterName() != null) {
            object = pSDCRobotAbilityBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSRobotAbilityId() != null) {
            object = pSDCRobotAbilityBase.getPSRobotAbilityId();
            xmlNode.setAttribute(FIELD_PSROBOTABILITYID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getPSRobotAbilityName() != null) {
            object = pSDCRobotAbilityBase.getPSRobotAbilityName();
            xmlNode.setAttribute(FIELD_PSROBOTABILITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getRobotWorkType() != null) {
            object = pSDCRobotAbilityBase.getRobotWorkType();
            xmlNode.setAttribute(FIELD_ROBOTWORKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getUpdateDate() != null) {
            object = pSDCRobotAbilityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotAbilityBase.getUpdateMan() != null) {
            object = pSDCRobotAbilityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotAbilityBase.getValidFlag() != null) {
            object = pSDCRobotAbilityBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRobotAbilityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRobotAbilityBase pSDCRobotAbilityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRobotAbilityBase.isCreateDateDirty() && (bl || pSDCRobotAbilityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRobotAbilityBase.getCreateDate());
        }
        if (pSDCRobotAbilityBase.isCreateManDirty() && (bl || pSDCRobotAbilityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRobotAbilityBase.getCreateMan());
        }
        if (pSDCRobotAbilityBase.isEnergyDirty() && (bl || pSDCRobotAbilityBase.getEnergy() != null)) {
            iDataObject.set(FIELD_ENERGY, (Object)pSDCRobotAbilityBase.getEnergy());
        }
        if (pSDCRobotAbilityBase.isExpiredTimeDirty() && (bl || pSDCRobotAbilityBase.getExpiredTime() != null)) {
            iDataObject.set(FIELD_EXPIREDTIME, (Object)pSDCRobotAbilityBase.getExpiredTime());
        }
        if (pSDCRobotAbilityBase.isMemoDirty() && (bl || pSDCRobotAbilityBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCRobotAbilityBase.getMemo());
        }
        if (pSDCRobotAbilityBase.isPSDCRobotAbilityIdDirty() && (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTABILITYID, (Object)pSDCRobotAbilityBase.getPSDCRobotAbilityId());
        }
        if (pSDCRobotAbilityBase.isPSDCRobotAbilityNameDirty() && (bl || pSDCRobotAbilityBase.getPSDCRobotAbilityName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTABILITYNAME, (Object)pSDCRobotAbilityBase.getPSDCRobotAbilityName());
        }
        if (pSDCRobotAbilityBase.isPSDCRobotIdDirty() && (bl || pSDCRobotAbilityBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSDCRobotAbilityBase.getPSDCRobotId());
        }
        if (pSDCRobotAbilityBase.isPSDCRobotNameDirty() && (bl || pSDCRobotAbilityBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSDCRobotAbilityBase.getPSDCRobotName());
        }
        if (pSDCRobotAbilityBase.isPSDevCenterIdDirty() && (bl || pSDCRobotAbilityBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCRobotAbilityBase.getPSDevCenterId());
        }
        if (pSDCRobotAbilityBase.isPSDevCenterNameDirty() && (bl || pSDCRobotAbilityBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCRobotAbilityBase.getPSDevCenterName());
        }
        if (pSDCRobotAbilityBase.isPSRobotAbilityIdDirty() && (bl || pSDCRobotAbilityBase.getPSRobotAbilityId() != null)) {
            iDataObject.set(FIELD_PSROBOTABILITYID, (Object)pSDCRobotAbilityBase.getPSRobotAbilityId());
        }
        if (pSDCRobotAbilityBase.isPSRobotAbilityNameDirty() && (bl || pSDCRobotAbilityBase.getPSRobotAbilityName() != null)) {
            iDataObject.set(FIELD_PSROBOTABILITYNAME, (Object)pSDCRobotAbilityBase.getPSRobotAbilityName());
        }
        if (pSDCRobotAbilityBase.isRobotWorkTypeDirty() && (bl || pSDCRobotAbilityBase.getRobotWorkType() != null)) {
            iDataObject.set(FIELD_ROBOTWORKTYPE, (Object)pSDCRobotAbilityBase.getRobotWorkType());
        }
        if (pSDCRobotAbilityBase.isUpdateDateDirty() && (bl || pSDCRobotAbilityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRobotAbilityBase.getUpdateDate());
        }
        if (pSDCRobotAbilityBase.isUpdateManDirty() && (bl || pSDCRobotAbilityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRobotAbilityBase.getUpdateMan());
        }
        if (pSDCRobotAbilityBase.isValidFlagDirty() && (bl || pSDCRobotAbilityBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCRobotAbilityBase.getValidFlag());
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
        return PSDCRobotAbilityBase.remove(this, n);
    }

    private static boolean remove(PSDCRobotAbilityBase pSDCRobotAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotAbilityBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCRobotAbilityBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCRobotAbilityBase.resetEnergy();
                return true;
            }
            case 3: {
                pSDCRobotAbilityBase.resetExpiredTime();
                return true;
            }
            case 4: {
                pSDCRobotAbilityBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCRobotAbilityBase.resetPSDCRobotAbilityId();
                return true;
            }
            case 6: {
                pSDCRobotAbilityBase.resetPSDCRobotAbilityName();
                return true;
            }
            case 7: {
                pSDCRobotAbilityBase.resetPSDCRobotId();
                return true;
            }
            case 8: {
                pSDCRobotAbilityBase.resetPSDCRobotName();
                return true;
            }
            case 9: {
                pSDCRobotAbilityBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCRobotAbilityBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCRobotAbilityBase.resetPSRobotAbilityId();
                return true;
            }
            case 12: {
                pSDCRobotAbilityBase.resetPSRobotAbilityName();
                return true;
            }
            case 13: {
                pSDCRobotAbilityBase.resetRobotWorkType();
                return true;
            }
            case 14: {
                pSDCRobotAbilityBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDCRobotAbilityBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDCRobotAbilityBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRobot getPSDCRobot() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobot();
        }
        if (this.getPSDCRobotId() == null) {
            return null;
        }
        Integer n = this.objPSDCRobotLock;
        synchronized (n) {
            if (this.psdcrobot != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRobotId(), (Object)this.psdcrobot.getPSDCRobotId()) != 0L) {
                this.psdcrobot = null;
            }
            if (this.psdcrobot == null) {
                PSDCRobot pSDCRobot = new PSDCRobot();
                pSDCRobot.setPSDCRobotId(this.getPSDCRobotId());
                PSDCRobotService pSDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
                pSDCRobotService.autoGet(pSDCRobot);
                this.psdcrobot = pSDCRobot;
            }
            return this.psdcrobot;
        }
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
    public PSRobotAbility getPSRobotAbility() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotAbility();
        }
        if (this.getPSRobotAbilityId() == null) {
            return null;
        }
        Integer n = this.objPSRobotAbilityLock;
        synchronized (n) {
            if (this.psrobotability != null && DataTypeHelper.compare((int)25, (Object)this.getPSRobotAbilityId(), (Object)this.psrobotability.getPSRobotAbilityId()) != 0L) {
                this.psrobotability = null;
            }
            if (this.psrobotability == null) {
                PSRobotAbility pSRobotAbility = new PSRobotAbility();
                pSRobotAbility.setPSRobotAbilityId(this.getPSRobotAbilityId());
                PSRobotAbilityService pSRobotAbilityService = (PSRobotAbilityService)ServiceGlobal.getService(PSRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
                pSRobotAbilityService.autoGet(pSRobotAbility);
                this.psrobotability = pSRobotAbility;
            }
            return this.psrobotability;
        }
    }

    private PSDCRobotAbilityBase getProxyEntity() {
        return this.proxyPSDCRobotAbilityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRobotAbilityBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRobotAbilityBase) {
            this.proxyPSDCRobotAbilityBase = (PSDCRobotAbilityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENERGY, 2);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDCROBOTABILITYID, 5);
        fieldIndexMap.put(FIELD_PSDCROBOTABILITYNAME, 6);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 7);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSROBOTABILITYID, 11);
        fieldIndexMap.put(FIELD_PSROBOTABILITYNAME, 12);
        fieldIndexMap.put(FIELD_ROBOTWORKTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

