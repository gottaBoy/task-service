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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSRobotType;
import net.ibizsys.pscore.srv.config.entity.PSRobotWorkType;
import net.ibizsys.pscore.srv.config.service.PSRobotTypeService;
import net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotTypeAbilityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotTypeAbilityBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENERGY = "ENERGY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSROBOTTYPEABILITYID = "PSROBOTTYPEABILITYID";
    public static final String FIELD_PSROBOTTYPEABILITYNAME = "PSROBOTTYPEABILITYNAME";
    public static final String FIELD_PSROBOTTYPEID = "PSROBOTTYPEID";
    public static final String FIELD_PSROBOTTYPENAME = "PSROBOTTYPENAME";
    public static final String FIELD_PSROBOTWORKTYPEID = "PSROBOTWORKTYPEID";
    public static final String FIELD_PSROBOTWORKTYPENAME = "PSROBOTWORKTYPENAME";
    public static final String FIELD_ROBOTLEVEL = "ROBOTLEVEL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENERGY = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSROBOTTYPEABILITYID = 4;
    private static final int INDEX_PSROBOTTYPEABILITYNAME = 5;
    private static final int INDEX_PSROBOTTYPEID = 6;
    private static final int INDEX_PSROBOTTYPENAME = 7;
    private static final int INDEX_PSROBOTWORKTYPEID = 8;
    private static final int INDEX_PSROBOTWORKTYPENAME = 9;
    private static final int INDEX_ROBOTLEVEL = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotTypeAbilityBase proxyPSRobotTypeAbilityBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean energyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrobottypeabilityidDirtyFlag = false;
    private boolean psrobottypeabilitynameDirtyFlag = false;
    private boolean psrobottypeidDirtyFlag = false;
    private boolean psrobottypenameDirtyFlag = false;
    private boolean psrobotworktypeidDirtyFlag = false;
    private boolean psrobotworktypenameDirtyFlag = false;
    private boolean robotlevelDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="energy")
    private Integer energy;
    @Column(name="memo")
    private String memo;
    @Column(name="psrobottypeabilityid")
    private String psrobottypeabilityid;
    @Column(name="psrobottypeabilityname")
    private String psrobottypeabilityname;
    @Column(name="psrobottypeid")
    private String psrobottypeid;
    @Column(name="psrobottypename")
    private String psrobottypename;
    @Column(name="psrobotworktypeid")
    private String psrobotworktypeid;
    @Column(name="psrobotworktypename")
    private String psrobotworktypename;
    @Column(name="robotlevel")
    private Integer robotlevel;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSRobotTypeLock = new Integer(1);
    private PSRobotType psrobottype = null;
    private Integer objPSRobotWorkTypeLock = new Integer(1);
    private PSRobotWorkType psrobotworktype = null;

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

    public void setPSRobotTypeAbilityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeAbilityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypeabilityid = string;
        this.psrobottypeabilityidDirtyFlag = true;
    }

    public String getPSRobotTypeAbilityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeAbilityId();
        }
        return this.psrobottypeabilityid;
    }

    public boolean isPSRobotTypeAbilityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeAbilityIdDirty();
        }
        return this.psrobottypeabilityidDirtyFlag;
    }

    public void resetPSRobotTypeAbilityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeAbilityId();
            return;
        }
        this.psrobottypeabilityidDirtyFlag = false;
        this.psrobottypeabilityid = null;
    }

    public void setPSRobotTypeAbilityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeAbilityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypeabilityname = string;
        this.psrobottypeabilitynameDirtyFlag = true;
    }

    public String getPSRobotTypeAbilityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeAbilityName();
        }
        return this.psrobottypeabilityname;
    }

    public boolean isPSRobotTypeAbilityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeAbilityNameDirty();
        }
        return this.psrobottypeabilitynameDirtyFlag;
    }

    public void resetPSRobotTypeAbilityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeAbilityName();
            return;
        }
        this.psrobottypeabilitynameDirtyFlag = false;
        this.psrobottypeabilityname = null;
    }

    public void setPSRobotTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypeid = string;
        this.psrobottypeidDirtyFlag = true;
    }

    public String getPSRobotTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeId();
        }
        return this.psrobottypeid;
    }

    public boolean isPSRobotTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeIdDirty();
        }
        return this.psrobottypeidDirtyFlag;
    }

    public void resetPSRobotTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeId();
            return;
        }
        this.psrobottypeidDirtyFlag = false;
        this.psrobottypeid = null;
    }

    public void setPSRobotTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypename = string;
        this.psrobottypenameDirtyFlag = true;
    }

    public String getPSRobotTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeName();
        }
        return this.psrobottypename;
    }

    public boolean isPSRobotTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeNameDirty();
        }
        return this.psrobottypenameDirtyFlag;
    }

    public void resetPSRobotTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeName();
            return;
        }
        this.psrobottypenameDirtyFlag = false;
        this.psrobottypename = null;
    }

    public void setPSRobotWorkTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworktypeid = string;
        this.psrobotworktypeidDirtyFlag = true;
    }

    public String getPSRobotWorkTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkTypeId();
        }
        return this.psrobotworktypeid;
    }

    public boolean isPSRobotWorkTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkTypeIdDirty();
        }
        return this.psrobotworktypeidDirtyFlag;
    }

    public void resetPSRobotWorkTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkTypeId();
            return;
        }
        this.psrobotworktypeidDirtyFlag = false;
        this.psrobotworktypeid = null;
    }

    public void setPSRobotWorkTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworktypename = string;
        this.psrobotworktypenameDirtyFlag = true;
    }

    public String getPSRobotWorkTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkTypeName();
        }
        return this.psrobotworktypename;
    }

    public boolean isPSRobotWorkTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkTypeNameDirty();
        }
        return this.psrobotworktypenameDirtyFlag;
    }

    public void resetPSRobotWorkTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkTypeName();
            return;
        }
        this.psrobotworktypenameDirtyFlag = false;
        this.psrobotworktypename = null;
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
        PSRobotTypeAbilityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotTypeAbilityBase pSRobotTypeAbilityBase) {
        pSRobotTypeAbilityBase.resetCreateDate();
        pSRobotTypeAbilityBase.resetCreateMan();
        pSRobotTypeAbilityBase.resetEnergy();
        pSRobotTypeAbilityBase.resetMemo();
        pSRobotTypeAbilityBase.resetPSRobotTypeAbilityId();
        pSRobotTypeAbilityBase.resetPSRobotTypeAbilityName();
        pSRobotTypeAbilityBase.resetPSRobotTypeId();
        pSRobotTypeAbilityBase.resetPSRobotTypeName();
        pSRobotTypeAbilityBase.resetPSRobotWorkTypeId();
        pSRobotTypeAbilityBase.resetPSRobotWorkTypeName();
        pSRobotTypeAbilityBase.resetRobotLevel();
        pSRobotTypeAbilityBase.resetUpdateDate();
        pSRobotTypeAbilityBase.resetUpdateMan();
        pSRobotTypeAbilityBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSRobotTypeAbilityIdDirty()) {
            hashMap.put(FIELD_PSROBOTTYPEABILITYID, this.getPSRobotTypeAbilityId());
        }
        if (!bl || this.isPSRobotTypeAbilityNameDirty()) {
            hashMap.put(FIELD_PSROBOTTYPEABILITYNAME, this.getPSRobotTypeAbilityName());
        }
        if (!bl || this.isPSRobotTypeIdDirty()) {
            hashMap.put(FIELD_PSROBOTTYPEID, this.getPSRobotTypeId());
        }
        if (!bl || this.isPSRobotTypeNameDirty()) {
            hashMap.put(FIELD_PSROBOTTYPENAME, this.getPSRobotTypeName());
        }
        if (!bl || this.isPSRobotWorkTypeIdDirty()) {
            hashMap.put(FIELD_PSROBOTWORKTYPEID, this.getPSRobotWorkTypeId());
        }
        if (!bl || this.isPSRobotWorkTypeNameDirty()) {
            hashMap.put(FIELD_PSROBOTWORKTYPENAME, this.getPSRobotWorkTypeName());
        }
        if (!bl || this.isRobotLevelDirty()) {
            hashMap.put(FIELD_ROBOTLEVEL, this.getRobotLevel());
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
        return PSRobotTypeAbilityBase.get(this, n);
    }

    private static Object get(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeAbilityBase.getCreateDate();
            }
            case 1: {
                return pSRobotTypeAbilityBase.getCreateMan();
            }
            case 2: {
                return pSRobotTypeAbilityBase.getEnergy();
            }
            case 3: {
                return pSRobotTypeAbilityBase.getMemo();
            }
            case 4: {
                return pSRobotTypeAbilityBase.getPSRobotTypeAbilityId();
            }
            case 5: {
                return pSRobotTypeAbilityBase.getPSRobotTypeAbilityName();
            }
            case 6: {
                return pSRobotTypeAbilityBase.getPSRobotTypeId();
            }
            case 7: {
                return pSRobotTypeAbilityBase.getPSRobotTypeName();
            }
            case 8: {
                return pSRobotTypeAbilityBase.getPSRobotWorkTypeId();
            }
            case 9: {
                return pSRobotTypeAbilityBase.getPSRobotWorkTypeName();
            }
            case 10: {
                return pSRobotTypeAbilityBase.getRobotLevel();
            }
            case 11: {
                return pSRobotTypeAbilityBase.getUpdateDate();
            }
            case 12: {
                return pSRobotTypeAbilityBase.getUpdateMan();
            }
            case 13: {
                return pSRobotTypeAbilityBase.getValidFlag();
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
        PSRobotTypeAbilityBase.set(this, n, object);
    }

    private static void set(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotTypeAbilityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRobotTypeAbilityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotTypeAbilityBase.setEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSRobotTypeAbilityBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRobotTypeAbilityBase.setPSRobotTypeAbilityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRobotTypeAbilityBase.setPSRobotTypeAbilityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRobotTypeAbilityBase.setPSRobotTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRobotTypeAbilityBase.setPSRobotTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRobotTypeAbilityBase.setPSRobotWorkTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRobotTypeAbilityBase.setPSRobotWorkTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRobotTypeAbilityBase.setRobotLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSRobotTypeAbilityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSRobotTypeAbilityBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRobotTypeAbilityBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRobotTypeAbilityBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeAbilityBase.getCreateDate() == null;
            }
            case 1: {
                return pSRobotTypeAbilityBase.getCreateMan() == null;
            }
            case 2: {
                return pSRobotTypeAbilityBase.getEnergy() == null;
            }
            case 3: {
                return pSRobotTypeAbilityBase.getMemo() == null;
            }
            case 4: {
                return pSRobotTypeAbilityBase.getPSRobotTypeAbilityId() == null;
            }
            case 5: {
                return pSRobotTypeAbilityBase.getPSRobotTypeAbilityName() == null;
            }
            case 6: {
                return pSRobotTypeAbilityBase.getPSRobotTypeId() == null;
            }
            case 7: {
                return pSRobotTypeAbilityBase.getPSRobotTypeName() == null;
            }
            case 8: {
                return pSRobotTypeAbilityBase.getPSRobotWorkTypeId() == null;
            }
            case 9: {
                return pSRobotTypeAbilityBase.getPSRobotWorkTypeName() == null;
            }
            case 10: {
                return pSRobotTypeAbilityBase.getRobotLevel() == null;
            }
            case 11: {
                return pSRobotTypeAbilityBase.getUpdateDate() == null;
            }
            case 12: {
                return pSRobotTypeAbilityBase.getUpdateMan() == null;
            }
            case 13: {
                return pSRobotTypeAbilityBase.getValidFlag() == null;
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
        return PSRobotTypeAbilityBase.contains(this, n);
    }

    private static boolean contains(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeAbilityBase.isCreateDateDirty();
            }
            case 1: {
                return pSRobotTypeAbilityBase.isCreateManDirty();
            }
            case 2: {
                return pSRobotTypeAbilityBase.isEnergyDirty();
            }
            case 3: {
                return pSRobotTypeAbilityBase.isMemoDirty();
            }
            case 4: {
                return pSRobotTypeAbilityBase.isPSRobotTypeAbilityIdDirty();
            }
            case 5: {
                return pSRobotTypeAbilityBase.isPSRobotTypeAbilityNameDirty();
            }
            case 6: {
                return pSRobotTypeAbilityBase.isPSRobotTypeIdDirty();
            }
            case 7: {
                return pSRobotTypeAbilityBase.isPSRobotTypeNameDirty();
            }
            case 8: {
                return pSRobotTypeAbilityBase.isPSRobotWorkTypeIdDirty();
            }
            case 9: {
                return pSRobotTypeAbilityBase.isPSRobotWorkTypeNameDirty();
            }
            case 10: {
                return pSRobotTypeAbilityBase.isRobotLevelDirty();
            }
            case 11: {
                return pSRobotTypeAbilityBase.isUpdateDateDirty();
            }
            case 12: {
                return pSRobotTypeAbilityBase.isUpdateManDirty();
            }
            case 13: {
                return pSRobotTypeAbilityBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotTypeAbilityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotTypeAbilityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energy", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getEnergy()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypeabilityid", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotTypeAbilityId()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypeabilityname", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotTypeAbilityName()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypeid", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotTypeId()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypename", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotTypeName()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworktypeid", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotWorkTypeId()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworktypename", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getPSRobotWorkTypeName()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getRobotLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotlevel", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getRobotLevel()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotTypeAbilityBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotTypeAbilityBase.getJSONValue((Object)pSRobotTypeAbilityBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotTypeAbilityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotTypeAbilityBase.getCreateDate() != null) {
            object = pSRobotTypeAbilityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotTypeAbilityBase.getCreateMan() != null) {
            object = pSRobotTypeAbilityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getEnergy() != null) {
            object = pSRobotTypeAbilityBase.getEnergy();
            xmlNode.setAttribute(FIELD_ENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotTypeAbilityBase.getMemo() != null) {
            object = pSRobotTypeAbilityBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityId() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotTypeAbilityId();
            xmlNode.setAttribute(FIELD_PSROBOTTYPEABILITYID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityName() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotTypeAbilityName();
            xmlNode.setAttribute(FIELD_PSROBOTTYPEABILITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeId() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotTypeId();
            xmlNode.setAttribute(FIELD_PSROBOTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotTypeName() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotTypeName();
            xmlNode.setAttribute(FIELD_PSROBOTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeId() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotWorkTypeId();
            xmlNode.setAttribute(FIELD_PSROBOTWORKTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeName() != null) {
            object = pSRobotTypeAbilityBase.getPSRobotWorkTypeName();
            xmlNode.setAttribute(FIELD_PSROBOTWORKTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getRobotLevel() != null) {
            object = pSRobotTypeAbilityBase.getRobotLevel();
            xmlNode.setAttribute(FIELD_ROBOTLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotTypeAbilityBase.getUpdateDate() != null) {
            object = pSRobotTypeAbilityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotTypeAbilityBase.getUpdateMan() != null) {
            object = pSRobotTypeAbilityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeAbilityBase.getValidFlag() != null) {
            object = pSRobotTypeAbilityBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotTypeAbilityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotTypeAbilityBase.isCreateDateDirty() && (bl || pSRobotTypeAbilityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotTypeAbilityBase.getCreateDate());
        }
        if (pSRobotTypeAbilityBase.isCreateManDirty() && (bl || pSRobotTypeAbilityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotTypeAbilityBase.getCreateMan());
        }
        if (pSRobotTypeAbilityBase.isEnergyDirty() && (bl || pSRobotTypeAbilityBase.getEnergy() != null)) {
            iDataObject.set(FIELD_ENERGY, (Object)pSRobotTypeAbilityBase.getEnergy());
        }
        if (pSRobotTypeAbilityBase.isMemoDirty() && (bl || pSRobotTypeAbilityBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotTypeAbilityBase.getMemo());
        }
        if (pSRobotTypeAbilityBase.isPSRobotTypeAbilityIdDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityId() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPEABILITYID, (Object)pSRobotTypeAbilityBase.getPSRobotTypeAbilityId());
        }
        if (pSRobotTypeAbilityBase.isPSRobotTypeAbilityNameDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotTypeAbilityName() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPEABILITYNAME, (Object)pSRobotTypeAbilityBase.getPSRobotTypeAbilityName());
        }
        if (pSRobotTypeAbilityBase.isPSRobotTypeIdDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotTypeId() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPEID, (Object)pSRobotTypeAbilityBase.getPSRobotTypeId());
        }
        if (pSRobotTypeAbilityBase.isPSRobotTypeNameDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotTypeName() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPENAME, (Object)pSRobotTypeAbilityBase.getPSRobotTypeName());
        }
        if (pSRobotTypeAbilityBase.isPSRobotWorkTypeIdDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeId() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKTYPEID, (Object)pSRobotTypeAbilityBase.getPSRobotWorkTypeId());
        }
        if (pSRobotTypeAbilityBase.isPSRobotWorkTypeNameDirty() && (bl || pSRobotTypeAbilityBase.getPSRobotWorkTypeName() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKTYPENAME, (Object)pSRobotTypeAbilityBase.getPSRobotWorkTypeName());
        }
        if (pSRobotTypeAbilityBase.isRobotLevelDirty() && (bl || pSRobotTypeAbilityBase.getRobotLevel() != null)) {
            iDataObject.set(FIELD_ROBOTLEVEL, (Object)pSRobotTypeAbilityBase.getRobotLevel());
        }
        if (pSRobotTypeAbilityBase.isUpdateDateDirty() && (bl || pSRobotTypeAbilityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotTypeAbilityBase.getUpdateDate());
        }
        if (pSRobotTypeAbilityBase.isUpdateManDirty() && (bl || pSRobotTypeAbilityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotTypeAbilityBase.getUpdateMan());
        }
        if (pSRobotTypeAbilityBase.isValidFlagDirty() && (bl || pSRobotTypeAbilityBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotTypeAbilityBase.getValidFlag());
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
        return PSRobotTypeAbilityBase.remove(this, n);
    }

    private static boolean remove(PSRobotTypeAbilityBase pSRobotTypeAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotTypeAbilityBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRobotTypeAbilityBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRobotTypeAbilityBase.resetEnergy();
                return true;
            }
            case 3: {
                pSRobotTypeAbilityBase.resetMemo();
                return true;
            }
            case 4: {
                pSRobotTypeAbilityBase.resetPSRobotTypeAbilityId();
                return true;
            }
            case 5: {
                pSRobotTypeAbilityBase.resetPSRobotTypeAbilityName();
                return true;
            }
            case 6: {
                pSRobotTypeAbilityBase.resetPSRobotTypeId();
                return true;
            }
            case 7: {
                pSRobotTypeAbilityBase.resetPSRobotTypeName();
                return true;
            }
            case 8: {
                pSRobotTypeAbilityBase.resetPSRobotWorkTypeId();
                return true;
            }
            case 9: {
                pSRobotTypeAbilityBase.resetPSRobotWorkTypeName();
                return true;
            }
            case 10: {
                pSRobotTypeAbilityBase.resetRobotLevel();
                return true;
            }
            case 11: {
                pSRobotTypeAbilityBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSRobotTypeAbilityBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSRobotTypeAbilityBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRobotType getPSRobotType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotType();
        }
        if (this.getPSRobotTypeId() == null) {
            return null;
        }
        Integer n = this.objPSRobotTypeLock;
        synchronized (n) {
            if (this.psrobottype != null && DataTypeHelper.compare((int)25, (Object)this.getPSRobotTypeId(), (Object)this.psrobottype.getPSRobotTypeId()) != 0L) {
                this.psrobottype = null;
            }
            if (this.psrobottype == null) {
                PSRobotType pSRobotType = new PSRobotType();
                pSRobotType.setPSRobotTypeId(this.getPSRobotTypeId());
                PSRobotTypeService pSRobotTypeService = (PSRobotTypeService)ServiceGlobal.getService(PSRobotTypeService.class, (SessionFactory)this.getSessionFactory());
                pSRobotTypeService.autoGet((IEntity)pSRobotType);
                this.psrobottype = pSRobotType;
            }
            return this.psrobottype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRobotWorkType getPSRobotWorkType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkType();
        }
        if (this.getPSRobotWorkTypeId() == null) {
            return null;
        }
        Integer n = this.objPSRobotWorkTypeLock;
        synchronized (n) {
            if (this.psrobotworktype != null && DataTypeHelper.compare((int)25, (Object)this.getPSRobotWorkTypeId(), (Object)this.psrobotworktype.getPSRobotWorkTypeId()) != 0L) {
                this.psrobotworktype = null;
            }
            if (this.psrobotworktype == null) {
                PSRobotWorkType pSRobotWorkType = new PSRobotWorkType();
                pSRobotWorkType.setPSRobotWorkTypeId(this.getPSRobotWorkTypeId());
                PSRobotWorkTypeService pSRobotWorkTypeService = (PSRobotWorkTypeService)ServiceGlobal.getService(PSRobotWorkTypeService.class, (SessionFactory)this.getSessionFactory());
                pSRobotWorkTypeService.autoGet((IEntity)pSRobotWorkType);
                this.psrobotworktype = pSRobotWorkType;
            }
            return this.psrobotworktype;
        }
    }

    private PSRobotTypeAbilityBase getProxyEntity() {
        return this.proxyPSRobotTypeAbilityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotTypeAbilityBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotTypeAbilityBase) {
            this.proxyPSRobotTypeAbilityBase = (PSRobotTypeAbilityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotTypeAbilityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENERGY, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSROBOTTYPEABILITYID, 4);
        fieldIndexMap.put(FIELD_PSROBOTTYPEABILITYNAME, 5);
        fieldIndexMap.put(FIELD_PSROBOTTYPEID, 6);
        fieldIndexMap.put(FIELD_PSROBOTTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSROBOTWORKTYPEID, 8);
        fieldIndexMap.put(FIELD_PSROBOTWORKTYPENAME, 9);
        fieldIndexMap.put(FIELD_ROBOTLEVEL, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

