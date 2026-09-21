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
import net.ibizsys.pscore.srv.config.entity.PSRobotTypeAbility;
import net.ibizsys.pscore.srv.config.service.PSRobotTypeAbilityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotWorkTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotWorkTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENERGY = "ENERGY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSROBOTWORKTYPEID = "PSROBOTWORKTYPEID";
    public static final String FIELD_PSROBOTWORKTYPENAME = "PSROBOTWORKTYPENAME";
    public static final String FIELD_ROBOTLEVEL = "ROBOTLEVEL";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WORKDESC = "WORKDESC";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENERGY = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSROBOTWORKTYPEID = 4;
    private static final int INDEX_PSROBOTWORKTYPENAME = 5;
    private static final int INDEX_ROBOTLEVEL = 6;
    private static final int INDEX_TYPEOBJ = 7;
    private static final int INDEX_TYPEPARAMS = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERTAG = 11;
    private static final int INDEX_USERTAG2 = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final int INDEX_WORKDESC = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotWorkTypeBase proxyPSRobotWorkTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean energyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrobotworktypeidDirtyFlag = false;
    private boolean psrobotworktypenameDirtyFlag = false;
    private boolean robotlevelDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean workdescDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="energy")
    private Integer energy;
    @Column(name="memo")
    private String memo;
    @Column(name="psrobotworktypeid")
    private String psrobotworktypeid;
    @Column(name="psrobotworktypename")
    private String psrobotworktypename;
    @Column(name="robotlevel")
    private Integer robotlevel;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="workdesc")
    private String workdesc;
    private Integer objPSRobotTypeAbilitiesLock = new Integer(1);
    private ArrayList<PSRobotTypeAbility> psrobottypeabilities = null;

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

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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

    public void setWorkDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workdesc = string;
        this.workdescDirtyFlag = true;
    }

    public String getWorkDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkDesc();
        }
        return this.workdesc;
    }

    public boolean isWorkDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkDescDirty();
        }
        return this.workdescDirtyFlag;
    }

    public void resetWorkDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkDesc();
            return;
        }
        this.workdescDirtyFlag = false;
        this.workdesc = null;
    }

    protected void onReset() {
        PSRobotWorkTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotWorkTypeBase pSRobotWorkTypeBase) {
        pSRobotWorkTypeBase.resetCreateDate();
        pSRobotWorkTypeBase.resetCreateMan();
        pSRobotWorkTypeBase.resetEnergy();
        pSRobotWorkTypeBase.resetMemo();
        pSRobotWorkTypeBase.resetPSRobotWorkTypeId();
        pSRobotWorkTypeBase.resetPSRobotWorkTypeName();
        pSRobotWorkTypeBase.resetRobotLevel();
        pSRobotWorkTypeBase.resetTypeObj();
        pSRobotWorkTypeBase.resetTypeParams();
        pSRobotWorkTypeBase.resetUpdateDate();
        pSRobotWorkTypeBase.resetUpdateMan();
        pSRobotWorkTypeBase.resetUserTag();
        pSRobotWorkTypeBase.resetUserTag2();
        pSRobotWorkTypeBase.resetValidFlag();
        pSRobotWorkTypeBase.resetWorkDesc();
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
        if (!bl || this.isPSRobotWorkTypeIdDirty()) {
            hashMap.put(FIELD_PSROBOTWORKTYPEID, this.getPSRobotWorkTypeId());
        }
        if (!bl || this.isPSRobotWorkTypeNameDirty()) {
            hashMap.put(FIELD_PSROBOTWORKTYPENAME, this.getPSRobotWorkTypeName());
        }
        if (!bl || this.isRobotLevelDirty()) {
            hashMap.put(FIELD_ROBOTLEVEL, this.getRobotLevel());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWorkDescDirty()) {
            hashMap.put(FIELD_WORKDESC, this.getWorkDesc());
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
        return PSRobotWorkTypeBase.get(this, n);
    }

    private static Object get(PSRobotWorkTypeBase pSRobotWorkTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkTypeBase.getCreateDate();
            }
            case 1: {
                return pSRobotWorkTypeBase.getCreateMan();
            }
            case 2: {
                return pSRobotWorkTypeBase.getEnergy();
            }
            case 3: {
                return pSRobotWorkTypeBase.getMemo();
            }
            case 4: {
                return pSRobotWorkTypeBase.getPSRobotWorkTypeId();
            }
            case 5: {
                return pSRobotWorkTypeBase.getPSRobotWorkTypeName();
            }
            case 6: {
                return pSRobotWorkTypeBase.getRobotLevel();
            }
            case 7: {
                return pSRobotWorkTypeBase.getTypeObj();
            }
            case 8: {
                return pSRobotWorkTypeBase.getTypeParams();
            }
            case 9: {
                return pSRobotWorkTypeBase.getUpdateDate();
            }
            case 10: {
                return pSRobotWorkTypeBase.getUpdateMan();
            }
            case 11: {
                return pSRobotWorkTypeBase.getUserTag();
            }
            case 12: {
                return pSRobotWorkTypeBase.getUserTag2();
            }
            case 13: {
                return pSRobotWorkTypeBase.getValidFlag();
            }
            case 14: {
                return pSRobotWorkTypeBase.getWorkDesc();
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
        PSRobotWorkTypeBase.set(this, n, object);
    }

    private static void set(PSRobotWorkTypeBase pSRobotWorkTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotWorkTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRobotWorkTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotWorkTypeBase.setEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSRobotWorkTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRobotWorkTypeBase.setPSRobotWorkTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRobotWorkTypeBase.setPSRobotWorkTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRobotWorkTypeBase.setRobotLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSRobotWorkTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRobotWorkTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRobotWorkTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSRobotWorkTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSRobotWorkTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSRobotWorkTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRobotWorkTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSRobotWorkTypeBase.setWorkDesc(DataObject.getStringValue((Object)object));
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
        return PSRobotWorkTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotWorkTypeBase pSRobotWorkTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSRobotWorkTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSRobotWorkTypeBase.getEnergy() == null;
            }
            case 3: {
                return pSRobotWorkTypeBase.getMemo() == null;
            }
            case 4: {
                return pSRobotWorkTypeBase.getPSRobotWorkTypeId() == null;
            }
            case 5: {
                return pSRobotWorkTypeBase.getPSRobotWorkTypeName() == null;
            }
            case 6: {
                return pSRobotWorkTypeBase.getRobotLevel() == null;
            }
            case 7: {
                return pSRobotWorkTypeBase.getTypeObj() == null;
            }
            case 8: {
                return pSRobotWorkTypeBase.getTypeParams() == null;
            }
            case 9: {
                return pSRobotWorkTypeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSRobotWorkTypeBase.getUpdateMan() == null;
            }
            case 11: {
                return pSRobotWorkTypeBase.getUserTag() == null;
            }
            case 12: {
                return pSRobotWorkTypeBase.getUserTag2() == null;
            }
            case 13: {
                return pSRobotWorkTypeBase.getValidFlag() == null;
            }
            case 14: {
                return pSRobotWorkTypeBase.getWorkDesc() == null;
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
        return PSRobotWorkTypeBase.contains(this, n);
    }

    private static boolean contains(PSRobotWorkTypeBase pSRobotWorkTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSRobotWorkTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSRobotWorkTypeBase.isEnergyDirty();
            }
            case 3: {
                return pSRobotWorkTypeBase.isMemoDirty();
            }
            case 4: {
                return pSRobotWorkTypeBase.isPSRobotWorkTypeIdDirty();
            }
            case 5: {
                return pSRobotWorkTypeBase.isPSRobotWorkTypeNameDirty();
            }
            case 6: {
                return pSRobotWorkTypeBase.isRobotLevelDirty();
            }
            case 7: {
                return pSRobotWorkTypeBase.isTypeObjDirty();
            }
            case 8: {
                return pSRobotWorkTypeBase.isTypeParamsDirty();
            }
            case 9: {
                return pSRobotWorkTypeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSRobotWorkTypeBase.isUpdateManDirty();
            }
            case 11: {
                return pSRobotWorkTypeBase.isUserTagDirty();
            }
            case 12: {
                return pSRobotWorkTypeBase.isUserTag2Dirty();
            }
            case 13: {
                return pSRobotWorkTypeBase.isValidFlagDirty();
            }
            case 14: {
                return pSRobotWorkTypeBase.isWorkDescDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotWorkTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotWorkTypeBase pSRobotWorkTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotWorkTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energy", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getEnergy()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworktypeid", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getPSRobotWorkTypeId()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworktypename", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getPSRobotWorkTypeName()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getRobotLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"robotlevel", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getRobotLevel()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSRobotWorkTypeBase.getWorkDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workdesc", (Object)PSRobotWorkTypeBase.getJSONValue((Object)pSRobotWorkTypeBase.getWorkDesc()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotWorkTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotWorkTypeBase pSRobotWorkTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotWorkTypeBase.getCreateDate() != null) {
            object = pSRobotWorkTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotWorkTypeBase.getCreateMan() != null) {
            object = pSRobotWorkTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getEnergy() != null) {
            object = pSRobotWorkTypeBase.getEnergy();
            xmlNode.setAttribute(FIELD_ENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotWorkTypeBase.getMemo() != null) {
            object = pSRobotWorkTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeId() != null) {
            object = pSRobotWorkTypeBase.getPSRobotWorkTypeId();
            xmlNode.setAttribute(FIELD_PSROBOTWORKTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeName() != null) {
            object = pSRobotWorkTypeBase.getPSRobotWorkTypeName();
            xmlNode.setAttribute(FIELD_PSROBOTWORKTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getRobotLevel() != null) {
            object = pSRobotWorkTypeBase.getRobotLevel();
            xmlNode.setAttribute(FIELD_ROBOTLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotWorkTypeBase.getTypeObj() != null) {
            object = pSRobotWorkTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getTypeParams() != null) {
            object = pSRobotWorkTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getUpdateDate() != null) {
            object = pSRobotWorkTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotWorkTypeBase.getUpdateMan() != null) {
            object = pSRobotWorkTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getUserTag() != null) {
            object = pSRobotWorkTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getUserTag2() != null) {
            object = pSRobotWorkTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkTypeBase.getValidFlag() != null) {
            object = pSRobotWorkTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotWorkTypeBase.getWorkDesc() != null) {
            object = pSRobotWorkTypeBase.getWorkDesc();
            xmlNode.setAttribute(FIELD_WORKDESC, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotWorkTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotWorkTypeBase pSRobotWorkTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotWorkTypeBase.isCreateDateDirty() && (bl || pSRobotWorkTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotWorkTypeBase.getCreateDate());
        }
        if (pSRobotWorkTypeBase.isCreateManDirty() && (bl || pSRobotWorkTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotWorkTypeBase.getCreateMan());
        }
        if (pSRobotWorkTypeBase.isEnergyDirty() && (bl || pSRobotWorkTypeBase.getEnergy() != null)) {
            iDataObject.set(FIELD_ENERGY, (Object)pSRobotWorkTypeBase.getEnergy());
        }
        if (pSRobotWorkTypeBase.isMemoDirty() && (bl || pSRobotWorkTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotWorkTypeBase.getMemo());
        }
        if (pSRobotWorkTypeBase.isPSRobotWorkTypeIdDirty() && (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeId() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKTYPEID, (Object)pSRobotWorkTypeBase.getPSRobotWorkTypeId());
        }
        if (pSRobotWorkTypeBase.isPSRobotWorkTypeNameDirty() && (bl || pSRobotWorkTypeBase.getPSRobotWorkTypeName() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKTYPENAME, (Object)pSRobotWorkTypeBase.getPSRobotWorkTypeName());
        }
        if (pSRobotWorkTypeBase.isRobotLevelDirty() && (bl || pSRobotWorkTypeBase.getRobotLevel() != null)) {
            iDataObject.set(FIELD_ROBOTLEVEL, (Object)pSRobotWorkTypeBase.getRobotLevel());
        }
        if (pSRobotWorkTypeBase.isTypeObjDirty() && (bl || pSRobotWorkTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSRobotWorkTypeBase.getTypeObj());
        }
        if (pSRobotWorkTypeBase.isTypeParamsDirty() && (bl || pSRobotWorkTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSRobotWorkTypeBase.getTypeParams());
        }
        if (pSRobotWorkTypeBase.isUpdateDateDirty() && (bl || pSRobotWorkTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotWorkTypeBase.getUpdateDate());
        }
        if (pSRobotWorkTypeBase.isUpdateManDirty() && (bl || pSRobotWorkTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotWorkTypeBase.getUpdateMan());
        }
        if (pSRobotWorkTypeBase.isUserTagDirty() && (bl || pSRobotWorkTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSRobotWorkTypeBase.getUserTag());
        }
        if (pSRobotWorkTypeBase.isUserTag2Dirty() && (bl || pSRobotWorkTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSRobotWorkTypeBase.getUserTag2());
        }
        if (pSRobotWorkTypeBase.isValidFlagDirty() && (bl || pSRobotWorkTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotWorkTypeBase.getValidFlag());
        }
        if (pSRobotWorkTypeBase.isWorkDescDirty() && (bl || pSRobotWorkTypeBase.getWorkDesc() != null)) {
            iDataObject.set(FIELD_WORKDESC, (Object)pSRobotWorkTypeBase.getWorkDesc());
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
        return PSRobotWorkTypeBase.remove(this, n);
    }

    private static boolean remove(PSRobotWorkTypeBase pSRobotWorkTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotWorkTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRobotWorkTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRobotWorkTypeBase.resetEnergy();
                return true;
            }
            case 3: {
                pSRobotWorkTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSRobotWorkTypeBase.resetPSRobotWorkTypeId();
                return true;
            }
            case 5: {
                pSRobotWorkTypeBase.resetPSRobotWorkTypeName();
                return true;
            }
            case 6: {
                pSRobotWorkTypeBase.resetRobotLevel();
                return true;
            }
            case 7: {
                pSRobotWorkTypeBase.resetTypeObj();
                return true;
            }
            case 8: {
                pSRobotWorkTypeBase.resetTypeParams();
                return true;
            }
            case 9: {
                pSRobotWorkTypeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSRobotWorkTypeBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSRobotWorkTypeBase.resetUserTag();
                return true;
            }
            case 12: {
                pSRobotWorkTypeBase.resetUserTag2();
                return true;
            }
            case 13: {
                pSRobotWorkTypeBase.resetValidFlag();
                return true;
            }
            case 14: {
                pSRobotWorkTypeBase.resetWorkDesc();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSRobotTypeAbility> getPSRobotTypeAbilities() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeAbilities();
        }
        if (this.getPSRobotWorkTypeId() == null) {
            return null;
        }
        PSRobotTypeAbilityService pSRobotTypeAbilityService = (PSRobotTypeAbilityService)ServiceGlobal.getService(PSRobotTypeAbilityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSRobotTypeAbilitiesLock;
        synchronized (n) {
            if (this.psrobottypeabilities == null) {
                this.psrobottypeabilities = pSRobotTypeAbilityService.selectByPSRobotWorkType(this);
            }
            return this.psrobottypeabilities;
        }
    }

    private PSRobotWorkTypeBase getProxyEntity() {
        return this.proxyPSRobotWorkTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotWorkTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotWorkTypeBase) {
            this.proxyPSRobotWorkTypeBase = (PSRobotWorkTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENERGY, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSROBOTWORKTYPEID, 4);
        fieldIndexMap.put(FIELD_PSROBOTWORKTYPENAME, 5);
        fieldIndexMap.put(FIELD_ROBOTLEVEL, 6);
        fieldIndexMap.put(FIELD_TYPEOBJ, 7);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERTAG, 11);
        fieldIndexMap.put(FIELD_USERTAG2, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
        fieldIndexMap.put(FIELD_WORKDESC, 14);
    }
}

