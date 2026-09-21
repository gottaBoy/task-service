/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

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

public abstract class TSSDItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HOURTYPE = "HOURTYPE";
    public static final String FIELD_HOURVALUE = "HOURVALUE";
    public static final String FIELD_MINUTETYPE = "MINUTETYPE";
    public static final String FIELD_MINUTEVALUE = "MINUTEVALUE";
    public static final String FIELD_MONTHDAYTYPE = "MONTHDAYTYPE";
    public static final String FIELD_MONTHDAYVALUE = "MONTHDAYVALUE";
    public static final String FIELD_MONTHTYPE = "MONTHTYPE";
    public static final String FIELD_MONTHVALUE = "MONTHVALUE";
    public static final String FIELD_MONTHWEEKTYPE = "MONTHWEEKTYPE";
    public static final String FIELD_MONTHWEEKVALUE = "MONTHWEEKVALUE";
    public static final String FIELD_SECONDTYPE = "SECONDTYPE";
    public static final String FIELD_SECONDVALUE = "SECONDVALUE";
    public static final String FIELD_TSSDITEMID = "TSSDITEMID";
    public static final String FIELD_TSSDITEMNAME = "TSSDITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_HOURTYPE = 2;
    private static final int INDEX_HOURVALUE = 3;
    private static final int INDEX_MINUTETYPE = 4;
    private static final int INDEX_MINUTEVALUE = 5;
    private static final int INDEX_MONTHDAYTYPE = 6;
    private static final int INDEX_MONTHDAYVALUE = 7;
    private static final int INDEX_MONTHTYPE = 8;
    private static final int INDEX_MONTHVALUE = 9;
    private static final int INDEX_MONTHWEEKTYPE = 10;
    private static final int INDEX_MONTHWEEKVALUE = 11;
    private static final int INDEX_SECONDTYPE = 12;
    private static final int INDEX_SECONDVALUE = 13;
    private static final int INDEX_TSSDITEMID = 14;
    private static final int INDEX_TSSDITEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VERSION = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDItemBase proxyTSSDItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean hourtypeDirtyFlag = false;
    private boolean hourvalueDirtyFlag = false;
    private boolean minutetypeDirtyFlag = false;
    private boolean minutevalueDirtyFlag = false;
    private boolean monthdaytypeDirtyFlag = false;
    private boolean monthdayvalueDirtyFlag = false;
    private boolean monthtypeDirtyFlag = false;
    private boolean monthvalueDirtyFlag = false;
    private boolean monthweektypeDirtyFlag = false;
    private boolean monthweekvalueDirtyFlag = false;
    private boolean secondtypeDirtyFlag = false;
    private boolean secondvalueDirtyFlag = false;
    private boolean tssditemidDirtyFlag = false;
    private boolean tssditemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="hourtype")
    private String hourtype;
    @Column(name="hourvalue")
    private String hourvalue;
    @Column(name="minutetype")
    private String minutetype;
    @Column(name="minutevalue")
    private String minutevalue;
    @Column(name="monthdaytype")
    private String monthdaytype;
    @Column(name="monthdayvalue")
    private String monthdayvalue;
    @Column(name="monthtype")
    private String monthtype;
    @Column(name="monthvalue")
    private String monthvalue;
    @Column(name="monthweektype")
    private String monthweektype;
    @Column(name="monthweekvalue")
    private String monthweekvalue;
    @Column(name="secondtype")
    private String secondtype;
    @Column(name="secondvalue")
    private String secondvalue;
    @Column(name="tssditemid")
    private String tssditemid;
    @Column(name="tssditemname")
    private String tssditemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="version")
    private Integer version;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_HOURTYPE, 2);
        fieldIndexMap.put(FIELD_HOURVALUE, 3);
        fieldIndexMap.put(FIELD_MINUTETYPE, 4);
        fieldIndexMap.put(FIELD_MINUTEVALUE, 5);
        fieldIndexMap.put(FIELD_MONTHDAYTYPE, 6);
        fieldIndexMap.put(FIELD_MONTHDAYVALUE, 7);
        fieldIndexMap.put(FIELD_MONTHTYPE, 8);
        fieldIndexMap.put(FIELD_MONTHVALUE, 9);
        fieldIndexMap.put(FIELD_MONTHWEEKTYPE, 10);
        fieldIndexMap.put(FIELD_MONTHWEEKVALUE, 11);
        fieldIndexMap.put(FIELD_SECONDTYPE, 12);
        fieldIndexMap.put(FIELD_SECONDVALUE, 13);
        fieldIndexMap.put(FIELD_TSSDITEMID, 14);
        fieldIndexMap.put(FIELD_TSSDITEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VERSION, 18);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setHourType(String hourtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHourType(hourtype);
            return;
        }
        if (hourtype != null && (hourtype = StringHelper.trimRight(hourtype)).length() == 0) {
            hourtype = null;
        }
        this.hourtype = hourtype;
        this.hourtypeDirtyFlag = true;
    }

    public String getHourType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHourType();
        }
        return this.hourtype;
    }

    public boolean isHourTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHourTypeDirty();
        }
        return this.hourtypeDirtyFlag;
    }

    public void resetHourType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHourType();
            return;
        }
        this.hourtypeDirtyFlag = false;
        this.hourtype = null;
    }

    public void setHourValue(String hourvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHourValue(hourvalue);
            return;
        }
        if (hourvalue != null && (hourvalue = StringHelper.trimRight(hourvalue)).length() == 0) {
            hourvalue = null;
        }
        this.hourvalue = hourvalue;
        this.hourvalueDirtyFlag = true;
    }

    public String getHourValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHourValue();
        }
        return this.hourvalue;
    }

    public boolean isHourValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHourValueDirty();
        }
        return this.hourvalueDirtyFlag;
    }

    public void resetHourValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHourValue();
            return;
        }
        this.hourvalueDirtyFlag = false;
        this.hourvalue = null;
    }

    public void setMinuteType(String minutetype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinuteType(minutetype);
            return;
        }
        if (minutetype != null && (minutetype = StringHelper.trimRight(minutetype)).length() == 0) {
            minutetype = null;
        }
        this.minutetype = minutetype;
        this.minutetypeDirtyFlag = true;
    }

    public String getMinuteType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinuteType();
        }
        return this.minutetype;
    }

    public boolean isMinuteTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinuteTypeDirty();
        }
        return this.minutetypeDirtyFlag;
    }

    public void resetMinuteType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinuteType();
            return;
        }
        this.minutetypeDirtyFlag = false;
        this.minutetype = null;
    }

    public void setMinuteValue(String minutevalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinuteValue(minutevalue);
            return;
        }
        if (minutevalue != null && (minutevalue = StringHelper.trimRight(minutevalue)).length() == 0) {
            minutevalue = null;
        }
        this.minutevalue = minutevalue;
        this.minutevalueDirtyFlag = true;
    }

    public String getMinuteValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinuteValue();
        }
        return this.minutevalue;
    }

    public boolean isMinuteValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinuteValueDirty();
        }
        return this.minutevalueDirtyFlag;
    }

    public void resetMinuteValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinuteValue();
            return;
        }
        this.minutevalueDirtyFlag = false;
        this.minutevalue = null;
    }

    public void setMonthDayType(String monthdaytype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthDayType(monthdaytype);
            return;
        }
        if (monthdaytype != null && (monthdaytype = StringHelper.trimRight(monthdaytype)).length() == 0) {
            monthdaytype = null;
        }
        this.monthdaytype = monthdaytype;
        this.monthdaytypeDirtyFlag = true;
    }

    public String getMonthDayType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthDayType();
        }
        return this.monthdaytype;
    }

    public boolean isMonthDayTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthDayTypeDirty();
        }
        return this.monthdaytypeDirtyFlag;
    }

    public void resetMonthDayType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthDayType();
            return;
        }
        this.monthdaytypeDirtyFlag = false;
        this.monthdaytype = null;
    }

    public void setMonthDayValue(String monthdayvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthDayValue(monthdayvalue);
            return;
        }
        if (monthdayvalue != null && (monthdayvalue = StringHelper.trimRight(monthdayvalue)).length() == 0) {
            monthdayvalue = null;
        }
        this.monthdayvalue = monthdayvalue;
        this.monthdayvalueDirtyFlag = true;
    }

    public String getMonthDayValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthDayValue();
        }
        return this.monthdayvalue;
    }

    public boolean isMonthDayValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthDayValueDirty();
        }
        return this.monthdayvalueDirtyFlag;
    }

    public void resetMonthDayValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthDayValue();
            return;
        }
        this.monthdayvalueDirtyFlag = false;
        this.monthdayvalue = null;
    }

    public void setMonthType(String monthtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthType(monthtype);
            return;
        }
        if (monthtype != null && (monthtype = StringHelper.trimRight(monthtype)).length() == 0) {
            monthtype = null;
        }
        this.monthtype = monthtype;
        this.monthtypeDirtyFlag = true;
    }

    public String getMonthType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthType();
        }
        return this.monthtype;
    }

    public boolean isMonthTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthTypeDirty();
        }
        return this.monthtypeDirtyFlag;
    }

    public void resetMonthType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthType();
            return;
        }
        this.monthtypeDirtyFlag = false;
        this.monthtype = null;
    }

    public void setMonthValue(String monthvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthValue(monthvalue);
            return;
        }
        if (monthvalue != null && (monthvalue = StringHelper.trimRight(monthvalue)).length() == 0) {
            monthvalue = null;
        }
        this.monthvalue = monthvalue;
        this.monthvalueDirtyFlag = true;
    }

    public String getMonthValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthValue();
        }
        return this.monthvalue;
    }

    public boolean isMonthValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthValueDirty();
        }
        return this.monthvalueDirtyFlag;
    }

    public void resetMonthValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthValue();
            return;
        }
        this.monthvalueDirtyFlag = false;
        this.monthvalue = null;
    }

    public void setMonthWeekType(String monthweektype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthWeekType(monthweektype);
            return;
        }
        if (monthweektype != null && (monthweektype = StringHelper.trimRight(monthweektype)).length() == 0) {
            monthweektype = null;
        }
        this.monthweektype = monthweektype;
        this.monthweektypeDirtyFlag = true;
    }

    public String getMonthWeekType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthWeekType();
        }
        return this.monthweektype;
    }

    public boolean isMonthWeekTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthWeekTypeDirty();
        }
        return this.monthweektypeDirtyFlag;
    }

    public void resetMonthWeekType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthWeekType();
            return;
        }
        this.monthweektypeDirtyFlag = false;
        this.monthweektype = null;
    }

    public void setMonthWeekValue(String monthweekvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMonthWeekValue(monthweekvalue);
            return;
        }
        if (monthweekvalue != null && (monthweekvalue = StringHelper.trimRight(monthweekvalue)).length() == 0) {
            monthweekvalue = null;
        }
        this.monthweekvalue = monthweekvalue;
        this.monthweekvalueDirtyFlag = true;
    }

    public String getMonthWeekValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMonthWeekValue();
        }
        return this.monthweekvalue;
    }

    public boolean isMonthWeekValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMonthWeekValueDirty();
        }
        return this.monthweekvalueDirtyFlag;
    }

    public void resetMonthWeekValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMonthWeekValue();
            return;
        }
        this.monthweekvalueDirtyFlag = false;
        this.monthweekvalue = null;
    }

    public void setSecondType(String secondtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecondType(secondtype);
            return;
        }
        if (secondtype != null && (secondtype = StringHelper.trimRight(secondtype)).length() == 0) {
            secondtype = null;
        }
        this.secondtype = secondtype;
        this.secondtypeDirtyFlag = true;
    }

    public String getSecondType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecondType();
        }
        return this.secondtype;
    }

    public boolean isSecondTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecondTypeDirty();
        }
        return this.secondtypeDirtyFlag;
    }

    public void resetSecondType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecondType();
            return;
        }
        this.secondtypeDirtyFlag = false;
        this.secondtype = null;
    }

    public void setSecondValue(String secondvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecondValue(secondvalue);
            return;
        }
        if (secondvalue != null && (secondvalue = StringHelper.trimRight(secondvalue)).length() == 0) {
            secondvalue = null;
        }
        this.secondvalue = secondvalue;
        this.secondvalueDirtyFlag = true;
    }

    public String getSecondValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecondValue();
        }
        return this.secondvalue;
    }

    public boolean isSecondValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecondValueDirty();
        }
        return this.secondvalueDirtyFlag;
    }

    public void resetSecondValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecondValue();
            return;
        }
        this.secondvalueDirtyFlag = false;
        this.secondvalue = null;
    }

    public void setTSSDItemId(String tssditemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDItemId(tssditemid);
            return;
        }
        if (tssditemid != null && (tssditemid = StringHelper.trimRight(tssditemid)).length() == 0) {
            tssditemid = null;
        }
        this.tssditemid = tssditemid;
        this.tssditemidDirtyFlag = true;
    }

    public String getTSSDItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDItemId();
        }
        return this.tssditemid;
    }

    public boolean isTSSDItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDItemIdDirty();
        }
        return this.tssditemidDirtyFlag;
    }

    public void resetTSSDItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDItemId();
            return;
        }
        this.tssditemidDirtyFlag = false;
        this.tssditemid = null;
    }

    public void setTSSDItemName(String tssditemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDItemName(tssditemname);
            return;
        }
        if (tssditemname != null && (tssditemname = StringHelper.trimRight(tssditemname)).length() == 0) {
            tssditemname = null;
        }
        this.tssditemname = tssditemname;
        this.tssditemnameDirtyFlag = true;
    }

    public String getTSSDItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDItemName();
        }
        return this.tssditemname;
    }

    public boolean isTSSDItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDItemNameDirty();
        }
        return this.tssditemnameDirtyFlag;
    }

    public void resetTSSDItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDItemName();
            return;
        }
        this.tssditemnameDirtyFlag = false;
        this.tssditemname = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setVersion(Integer version) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        this.version = version;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    @Override
    protected void onReset() {
        TSSDItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDItemBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetHourType();
        et.resetHourValue();
        et.resetMinuteType();
        et.resetMinuteValue();
        et.resetMonthDayType();
        et.resetMonthDayValue();
        et.resetMonthType();
        et.resetMonthValue();
        et.resetMonthWeekType();
        et.resetMonthWeekValue();
        et.resetSecondType();
        et.resetSecondValue();
        et.resetTSSDItemId();
        et.resetTSSDItemName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetVersion();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isHourTypeDirty()) {
            params.put(FIELD_HOURTYPE, this.getHourType());
        }
        if (!bDirtyOnly || this.isHourValueDirty()) {
            params.put(FIELD_HOURVALUE, this.getHourValue());
        }
        if (!bDirtyOnly || this.isMinuteTypeDirty()) {
            params.put(FIELD_MINUTETYPE, this.getMinuteType());
        }
        if (!bDirtyOnly || this.isMinuteValueDirty()) {
            params.put(FIELD_MINUTEVALUE, this.getMinuteValue());
        }
        if (!bDirtyOnly || this.isMonthDayTypeDirty()) {
            params.put(FIELD_MONTHDAYTYPE, this.getMonthDayType());
        }
        if (!bDirtyOnly || this.isMonthDayValueDirty()) {
            params.put(FIELD_MONTHDAYVALUE, this.getMonthDayValue());
        }
        if (!bDirtyOnly || this.isMonthTypeDirty()) {
            params.put(FIELD_MONTHTYPE, this.getMonthType());
        }
        if (!bDirtyOnly || this.isMonthValueDirty()) {
            params.put(FIELD_MONTHVALUE, this.getMonthValue());
        }
        if (!bDirtyOnly || this.isMonthWeekTypeDirty()) {
            params.put(FIELD_MONTHWEEKTYPE, this.getMonthWeekType());
        }
        if (!bDirtyOnly || this.isMonthWeekValueDirty()) {
            params.put(FIELD_MONTHWEEKVALUE, this.getMonthWeekValue());
        }
        if (!bDirtyOnly || this.isSecondTypeDirty()) {
            params.put(FIELD_SECONDTYPE, this.getSecondType());
        }
        if (!bDirtyOnly || this.isSecondValueDirty()) {
            params.put(FIELD_SECONDVALUE, this.getSecondValue());
        }
        if (!bDirtyOnly || this.isTSSDItemIdDirty()) {
            params.put(FIELD_TSSDITEMID, this.getTSSDItemId());
        }
        if (!bDirtyOnly || this.isTSSDItemNameDirty()) {
            params.put(FIELD_TSSDITEMNAME, this.getTSSDItemName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isVersionDirty()) {
            params.put(FIELD_VERSION, this.getVersion());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return TSSDItemBase.get(this, index);
    }

    private static Object get(TSSDItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getHourType();
            }
            case 3: {
                return et.getHourValue();
            }
            case 4: {
                return et.getMinuteType();
            }
            case 5: {
                return et.getMinuteValue();
            }
            case 6: {
                return et.getMonthDayType();
            }
            case 7: {
                return et.getMonthDayValue();
            }
            case 8: {
                return et.getMonthType();
            }
            case 9: {
                return et.getMonthValue();
            }
            case 10: {
                return et.getMonthWeekType();
            }
            case 11: {
                return et.getMonthWeekValue();
            }
            case 12: {
                return et.getSecondType();
            }
            case 13: {
                return et.getSecondValue();
            }
            case 14: {
                return et.getTSSDItemId();
            }
            case 15: {
                return et.getTSSDItemName();
            }
            case 16: {
                return et.getUpdateDate();
            }
            case 17: {
                return et.getUpdateMan();
            }
            case 18: {
                return et.getVersion();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        TSSDItemBase.set(this, index, objValue);
    }

    private static void set(TSSDItemBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setHourType(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setHourValue(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setMinuteType(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setMinuteValue(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMonthDayType(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMonthDayValue(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setMonthType(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setMonthValue(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setMonthWeekType(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setMonthWeekValue(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setSecondType(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setSecondValue(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setTSSDItemId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setTSSDItemName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 17: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setVersion(DataObject.getIntegerValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return TSSDItemBase.isNull(this, index);
    }

    private static boolean isNull(TSSDItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getHourType() == null;
            }
            case 3: {
                return et.getHourValue() == null;
            }
            case 4: {
                return et.getMinuteType() == null;
            }
            case 5: {
                return et.getMinuteValue() == null;
            }
            case 6: {
                return et.getMonthDayType() == null;
            }
            case 7: {
                return et.getMonthDayValue() == null;
            }
            case 8: {
                return et.getMonthType() == null;
            }
            case 9: {
                return et.getMonthValue() == null;
            }
            case 10: {
                return et.getMonthWeekType() == null;
            }
            case 11: {
                return et.getMonthWeekValue() == null;
            }
            case 12: {
                return et.getSecondType() == null;
            }
            case 13: {
                return et.getSecondValue() == null;
            }
            case 14: {
                return et.getTSSDItemId() == null;
            }
            case 15: {
                return et.getTSSDItemName() == null;
            }
            case 16: {
                return et.getUpdateDate() == null;
            }
            case 17: {
                return et.getUpdateMan() == null;
            }
            case 18: {
                return et.getVersion() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return TSSDItemBase.contains(this, index);
    }

    private static boolean contains(TSSDItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isHourTypeDirty();
            }
            case 3: {
                return et.isHourValueDirty();
            }
            case 4: {
                return et.isMinuteTypeDirty();
            }
            case 5: {
                return et.isMinuteValueDirty();
            }
            case 6: {
                return et.isMonthDayTypeDirty();
            }
            case 7: {
                return et.isMonthDayValueDirty();
            }
            case 8: {
                return et.isMonthTypeDirty();
            }
            case 9: {
                return et.isMonthValueDirty();
            }
            case 10: {
                return et.isMonthWeekTypeDirty();
            }
            case 11: {
                return et.isMonthWeekValueDirty();
            }
            case 12: {
                return et.isSecondTypeDirty();
            }
            case 13: {
                return et.isSecondValueDirty();
            }
            case 14: {
                return et.isTSSDItemIdDirty();
            }
            case 15: {
                return et.isTSSDItemNameDirty();
            }
            case 16: {
                return et.isUpdateDateDirty();
            }
            case 17: {
                return et.isUpdateManDirty();
            }
            case 18: {
                return et.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDItemBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDItemBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDItemBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDItemBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getHourType() != null) {
            JSONObjectHelper.put(json, "hourtype", TSSDItemBase.getJSONValue(et.getHourType()), false);
        }
        if (bIncEmpty || et.getHourValue() != null) {
            JSONObjectHelper.put(json, "hourvalue", TSSDItemBase.getJSONValue(et.getHourValue()), false);
        }
        if (bIncEmpty || et.getMinuteType() != null) {
            JSONObjectHelper.put(json, "minutetype", TSSDItemBase.getJSONValue(et.getMinuteType()), false);
        }
        if (bIncEmpty || et.getMinuteValue() != null) {
            JSONObjectHelper.put(json, "minutevalue", TSSDItemBase.getJSONValue(et.getMinuteValue()), false);
        }
        if (bIncEmpty || et.getMonthDayType() != null) {
            JSONObjectHelper.put(json, "monthdaytype", TSSDItemBase.getJSONValue(et.getMonthDayType()), false);
        }
        if (bIncEmpty || et.getMonthDayValue() != null) {
            JSONObjectHelper.put(json, "monthdayvalue", TSSDItemBase.getJSONValue(et.getMonthDayValue()), false);
        }
        if (bIncEmpty || et.getMonthType() != null) {
            JSONObjectHelper.put(json, "monthtype", TSSDItemBase.getJSONValue(et.getMonthType()), false);
        }
        if (bIncEmpty || et.getMonthValue() != null) {
            JSONObjectHelper.put(json, "monthvalue", TSSDItemBase.getJSONValue(et.getMonthValue()), false);
        }
        if (bIncEmpty || et.getMonthWeekType() != null) {
            JSONObjectHelper.put(json, "monthweektype", TSSDItemBase.getJSONValue(et.getMonthWeekType()), false);
        }
        if (bIncEmpty || et.getMonthWeekValue() != null) {
            JSONObjectHelper.put(json, "monthweekvalue", TSSDItemBase.getJSONValue(et.getMonthWeekValue()), false);
        }
        if (bIncEmpty || et.getSecondType() != null) {
            JSONObjectHelper.put(json, "secondtype", TSSDItemBase.getJSONValue(et.getSecondType()), false);
        }
        if (bIncEmpty || et.getSecondValue() != null) {
            JSONObjectHelper.put(json, "secondvalue", TSSDItemBase.getJSONValue(et.getSecondValue()), false);
        }
        if (bIncEmpty || et.getTSSDItemId() != null) {
            JSONObjectHelper.put(json, "tssditemid", TSSDItemBase.getJSONValue(et.getTSSDItemId()), false);
        }
        if (bIncEmpty || et.getTSSDItemName() != null) {
            JSONObjectHelper.put(json, "tssditemname", TSSDItemBase.getJSONValue(et.getTSSDItemName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDItemBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDItemBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getVersion() != null) {
            JSONObjectHelper.put(json, "version", TSSDItemBase.getJSONValue(et.getVersion()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDItemBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDItemBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getHourType() != null) {
            obj = et.getHourType();
            node.setAttribute(FIELD_HOURTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getHourValue() != null) {
            obj = et.getHourValue();
            node.setAttribute(FIELD_HOURVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinuteType() != null) {
            obj = et.getMinuteType();
            node.setAttribute(FIELD_MINUTETYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinuteValue() != null) {
            obj = et.getMinuteValue();
            node.setAttribute(FIELD_MINUTEVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthDayType() != null) {
            obj = et.getMonthDayType();
            node.setAttribute(FIELD_MONTHDAYTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthDayValue() != null) {
            obj = et.getMonthDayValue();
            node.setAttribute(FIELD_MONTHDAYVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthType() != null) {
            obj = et.getMonthType();
            node.setAttribute(FIELD_MONTHTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthValue() != null) {
            obj = et.getMonthValue();
            node.setAttribute(FIELD_MONTHVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthWeekType() != null) {
            obj = et.getMonthWeekType();
            node.setAttribute(FIELD_MONTHWEEKTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMonthWeekValue() != null) {
            obj = et.getMonthWeekValue();
            node.setAttribute(FIELD_MONTHWEEKVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSecondType() != null) {
            obj = et.getSecondType();
            node.setAttribute(FIELD_SECONDTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSecondValue() != null) {
            obj = et.getSecondValue();
            node.setAttribute(FIELD_SECONDVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDItemId() != null) {
            obj = et.getTSSDItemId();
            node.setAttribute(FIELD_TSSDITEMID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDItemName() != null) {
            obj = et.getTSSDItemName();
            node.setAttribute(FIELD_TSSDITEMNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getVersion() != null) {
            obj = et.getVersion();
            node.setAttribute(FIELD_VERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDItemBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDItemBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isHourTypeDirty() && (bIncEmpty || et.getHourType() != null)) {
            dst.set(FIELD_HOURTYPE, et.getHourType());
        }
        if (et.isHourValueDirty() && (bIncEmpty || et.getHourValue() != null)) {
            dst.set(FIELD_HOURVALUE, et.getHourValue());
        }
        if (et.isMinuteTypeDirty() && (bIncEmpty || et.getMinuteType() != null)) {
            dst.set(FIELD_MINUTETYPE, et.getMinuteType());
        }
        if (et.isMinuteValueDirty() && (bIncEmpty || et.getMinuteValue() != null)) {
            dst.set(FIELD_MINUTEVALUE, et.getMinuteValue());
        }
        if (et.isMonthDayTypeDirty() && (bIncEmpty || et.getMonthDayType() != null)) {
            dst.set(FIELD_MONTHDAYTYPE, et.getMonthDayType());
        }
        if (et.isMonthDayValueDirty() && (bIncEmpty || et.getMonthDayValue() != null)) {
            dst.set(FIELD_MONTHDAYVALUE, et.getMonthDayValue());
        }
        if (et.isMonthTypeDirty() && (bIncEmpty || et.getMonthType() != null)) {
            dst.set(FIELD_MONTHTYPE, et.getMonthType());
        }
        if (et.isMonthValueDirty() && (bIncEmpty || et.getMonthValue() != null)) {
            dst.set(FIELD_MONTHVALUE, et.getMonthValue());
        }
        if (et.isMonthWeekTypeDirty() && (bIncEmpty || et.getMonthWeekType() != null)) {
            dst.set(FIELD_MONTHWEEKTYPE, et.getMonthWeekType());
        }
        if (et.isMonthWeekValueDirty() && (bIncEmpty || et.getMonthWeekValue() != null)) {
            dst.set(FIELD_MONTHWEEKVALUE, et.getMonthWeekValue());
        }
        if (et.isSecondTypeDirty() && (bIncEmpty || et.getSecondType() != null)) {
            dst.set(FIELD_SECONDTYPE, et.getSecondType());
        }
        if (et.isSecondValueDirty() && (bIncEmpty || et.getSecondValue() != null)) {
            dst.set(FIELD_SECONDVALUE, et.getSecondValue());
        }
        if (et.isTSSDItemIdDirty() && (bIncEmpty || et.getTSSDItemId() != null)) {
            dst.set(FIELD_TSSDITEMID, et.getTSSDItemId());
        }
        if (et.isTSSDItemNameDirty() && (bIncEmpty || et.getTSSDItemName() != null)) {
            dst.set(FIELD_TSSDITEMNAME, et.getTSSDItemName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isVersionDirty() && (bIncEmpty || et.getVersion() != null)) {
            dst.set(FIELD_VERSION, et.getVersion());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return TSSDItemBase.remove(this, index);
    }

    private static boolean remove(TSSDItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetHourType();
                return true;
            }
            case 3: {
                et.resetHourValue();
                return true;
            }
            case 4: {
                et.resetMinuteType();
                return true;
            }
            case 5: {
                et.resetMinuteValue();
                return true;
            }
            case 6: {
                et.resetMonthDayType();
                return true;
            }
            case 7: {
                et.resetMonthDayValue();
                return true;
            }
            case 8: {
                et.resetMonthType();
                return true;
            }
            case 9: {
                et.resetMonthValue();
                return true;
            }
            case 10: {
                et.resetMonthWeekType();
                return true;
            }
            case 11: {
                et.resetMonthWeekValue();
                return true;
            }
            case 12: {
                et.resetSecondType();
                return true;
            }
            case 13: {
                et.resetSecondValue();
                return true;
            }
            case 14: {
                et.resetTSSDItemId();
                return true;
            }
            case 15: {
                et.resetTSSDItemName();
                return true;
            }
            case 16: {
                et.resetUpdateDate();
                return true;
            }
            case 17: {
                et.resetUpdateMan();
                return true;
            }
            case 18: {
                et.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private TSSDItemBase getProxyEntity() {
        return this.proxyTSSDItemBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDItemBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDItemBase) {
            this.proxyTSSDItemBase = (TSSDItemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

