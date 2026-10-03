/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[TSSDItem] 数据对象基类
 */
public abstract class TSSDItemBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDItemBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[小时]
     */
    public final static String FIELD_HOURTYPE = "HOURTYPE";
    /**
     * 属性[指定小时]
     */
    public final static String FIELD_HOURVALUE = "HOURVALUE";
    /**
     * 属性[分钟]
     */
    public final static String FIELD_MINUTETYPE = "MINUTETYPE";
    /**
     * 属性[指定分钟]
     */
    public final static String FIELD_MINUTEVALUE = "MINUTEVALUE";
    /**
     * 属性[月天]
     */
    public final static String FIELD_MONTHDAYTYPE = "MONTHDAYTYPE";
    /**
     * 属性[指定月天]
     */
    public final static String FIELD_MONTHDAYVALUE = "MONTHDAYVALUE";
    /**
     * 属性[月份]
     */
    public final static String FIELD_MONTHTYPE = "MONTHTYPE";
    /**
     * 属性[指定月份]
     */
    public final static String FIELD_MONTHVALUE = "MONTHVALUE";
    /**
     * 属性[月周]
     */
    public final static String FIELD_MONTHWEEKTYPE = "MONTHWEEKTYPE";
    /**
     * 属性[指定周天]
     */
    public final static String FIELD_MONTHWEEKVALUE = "MONTHWEEKVALUE";
    /**
     * 属性[秒钟]
     */
    public final static String FIELD_SECONDTYPE = "SECONDTYPE";
    /**
     * 属性[指定秒钟]
     */
    public final static String FIELD_SECONDVALUE = "SECONDVALUE";
    /**
     * 属性[任务时刻策略项标识]
     */
    public final static String FIELD_TSSDITEMID = "TSSDITEMID";
    /**
     * 属性[任务时刻策略项]
     */
    public final static String FIELD_TSSDITEMNAME = "TSSDITEMNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[版本]
     */
    public final static String FIELD_VERSION = "VERSION";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_HOURTYPE = 2;
    private final static int INDEX_HOURVALUE = 3;
    private final static int INDEX_MINUTETYPE = 4;
    private final static int INDEX_MINUTEVALUE = 5;
    private final static int INDEX_MONTHDAYTYPE = 6;
    private final static int INDEX_MONTHDAYVALUE = 7;
    private final static int INDEX_MONTHTYPE = 8;
    private final static int INDEX_MONTHVALUE = 9;
    private final static int INDEX_MONTHWEEKTYPE = 10;
    private final static int INDEX_MONTHWEEKVALUE = 11;
    private final static int INDEX_SECONDTYPE = 12;
    private final static int INDEX_SECONDVALUE = 13;
    private final static int INDEX_TSSDITEMID = 14;
    private final static int INDEX_TSSDITEMNAME = 15;
    private final static int INDEX_UPDATEDATE = 16;
    private final static int INDEX_UPDATEMAN = 17;
    private final static int INDEX_VERSION = 18;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_HOURTYPE, INDEX_HOURTYPE);
        fieldIndexMap.put( FIELD_HOURVALUE, INDEX_HOURVALUE);
        fieldIndexMap.put( FIELD_MINUTETYPE, INDEX_MINUTETYPE);
        fieldIndexMap.put( FIELD_MINUTEVALUE, INDEX_MINUTEVALUE);
        fieldIndexMap.put( FIELD_MONTHDAYTYPE, INDEX_MONTHDAYTYPE);
        fieldIndexMap.put( FIELD_MONTHDAYVALUE, INDEX_MONTHDAYVALUE);
        fieldIndexMap.put( FIELD_MONTHTYPE, INDEX_MONTHTYPE);
        fieldIndexMap.put( FIELD_MONTHVALUE, INDEX_MONTHVALUE);
        fieldIndexMap.put( FIELD_MONTHWEEKTYPE, INDEX_MONTHWEEKTYPE);
        fieldIndexMap.put( FIELD_MONTHWEEKVALUE, INDEX_MONTHWEEKVALUE);
        fieldIndexMap.put( FIELD_SECONDTYPE, INDEX_SECONDTYPE);
        fieldIndexMap.put( FIELD_SECONDVALUE, INDEX_SECONDVALUE);
        fieldIndexMap.put( FIELD_TSSDITEMID, INDEX_TSSDITEMID);
        fieldIndexMap.put( FIELD_TSSDITEMNAME, INDEX_TSSDITEMNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VERSION, INDEX_VERSION);
    }

    private TSSDItemBase proxyTSSDItemBase = null;
    public TSSDItemBase() {
        super();
    }
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


    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[小时]代码表：net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel
     *  @param hourtype
     */
    public void setHourType(String hourtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setHourType(hourtype);
            return;
        }
        if(hourtype!=null) {
            hourtype = StringHelper.trimRight(hourtype);
            if(hourtype.length()==0) {
                hourtype = null;
            }
        }
        this.hourtype = hourtype;
        this.hourtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[小时]代码表：net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel
     */
    public String getHourType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getHourType();
        }
        return this.hourtype;
    }

    /**
     *  获取属性值[小时]是否修改
     */
    public boolean isHourTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isHourTypeDirty();
        }
        return this.hourtypeDirtyFlag;
    }

    /**
     *  重置属性值[小时]
     */
    public void resetHourType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetHourType();
            return;
        }

        this.hourtypeDirtyFlag = false;
        this.hourtype = null;
    }
    /**
     *  设置属性值[指定小时]代码表：net.ibizsys.psrt.srv.codelist.TSHourCodeListModel
     *  @param hourvalue
     */
    public void setHourValue(String hourvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setHourValue(hourvalue);
            return;
        }
        if(hourvalue!=null) {
            hourvalue = StringHelper.trimRight(hourvalue);
            if(hourvalue.length()==0) {
                hourvalue = null;
            }
        }
        this.hourvalue = hourvalue;
        this.hourvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定小时]代码表：net.ibizsys.psrt.srv.codelist.TSHourCodeListModel
     */
    public String getHourValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getHourValue();
        }
        return this.hourvalue;
    }

    /**
     *  获取属性值[指定小时]是否修改
     */
    public boolean isHourValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isHourValueDirty();
        }
        return this.hourvalueDirtyFlag;
    }

    /**
     *  重置属性值[指定小时]
     */
    public void resetHourValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetHourValue();
            return;
        }

        this.hourvalueDirtyFlag = false;
        this.hourvalue = null;
    }
    /**
     *  设置属性值[分钟]代码表：net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel
     *  @param minutetype
     */
    public void setMinuteType(String minutetype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinuteType(minutetype);
            return;
        }
        if(minutetype!=null) {
            minutetype = StringHelper.trimRight(minutetype);
            if(minutetype.length()==0) {
                minutetype = null;
            }
        }
        this.minutetype = minutetype;
        this.minutetypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[分钟]代码表：net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel
     */
    public String getMinuteType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinuteType();
        }
        return this.minutetype;
    }

    /**
     *  获取属性值[分钟]是否修改
     */
    public boolean isMinuteTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinuteTypeDirty();
        }
        return this.minutetypeDirtyFlag;
    }

    /**
     *  重置属性值[分钟]
     */
    public void resetMinuteType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinuteType();
            return;
        }

        this.minutetypeDirtyFlag = false;
        this.minutetype = null;
    }
    /**
     *  设置属性值[指定分钟]代码表：net.ibizsys.psrt.srv.codelist.TSMinuteCodeListModel
     *  @param minutevalue
     */
    public void setMinuteValue(String minutevalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinuteValue(minutevalue);
            return;
        }
        if(minutevalue!=null) {
            minutevalue = StringHelper.trimRight(minutevalue);
            if(minutevalue.length()==0) {
                minutevalue = null;
            }
        }
        this.minutevalue = minutevalue;
        this.minutevalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定分钟]代码表：net.ibizsys.psrt.srv.codelist.TSMinuteCodeListModel
     */
    public String getMinuteValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinuteValue();
        }
        return this.minutevalue;
    }

    /**
     *  获取属性值[指定分钟]是否修改
     */
    public boolean isMinuteValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinuteValueDirty();
        }
        return this.minutevalueDirtyFlag;
    }

    /**
     *  重置属性值[指定分钟]
     */
    public void resetMinuteValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinuteValue();
            return;
        }

        this.minutevalueDirtyFlag = false;
        this.minutevalue = null;
    }
    /**
     *  设置属性值[月天]代码表：net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel
     *  @param monthdaytype
     */
    public void setMonthDayType(String monthdaytype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthDayType(monthdaytype);
            return;
        }
        if(monthdaytype!=null) {
            monthdaytype = StringHelper.trimRight(monthdaytype);
            if(monthdaytype.length()==0) {
                monthdaytype = null;
            }
        }
        this.monthdaytype = monthdaytype;
        this.monthdaytypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[月天]代码表：net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel
     */
    public String getMonthDayType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthDayType();
        }
        return this.monthdaytype;
    }

    /**
     *  获取属性值[月天]是否修改
     */
    public boolean isMonthDayTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthDayTypeDirty();
        }
        return this.monthdaytypeDirtyFlag;
    }

    /**
     *  重置属性值[月天]
     */
    public void resetMonthDayType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthDayType();
            return;
        }

        this.monthdaytypeDirtyFlag = false;
        this.monthdaytype = null;
    }
    /**
     *  设置属性值[指定月天]代码表：net.ibizsys.psrt.srv.codelist.TSDayCodeListModel
     *  @param monthdayvalue
     */
    public void setMonthDayValue(String monthdayvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthDayValue(monthdayvalue);
            return;
        }
        if(monthdayvalue!=null) {
            monthdayvalue = StringHelper.trimRight(monthdayvalue);
            if(monthdayvalue.length()==0) {
                monthdayvalue = null;
            }
        }
        this.monthdayvalue = monthdayvalue;
        this.monthdayvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定月天]代码表：net.ibizsys.psrt.srv.codelist.TSDayCodeListModel
     */
    public String getMonthDayValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthDayValue();
        }
        return this.monthdayvalue;
    }

    /**
     *  获取属性值[指定月天]是否修改
     */
    public boolean isMonthDayValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthDayValueDirty();
        }
        return this.monthdayvalueDirtyFlag;
    }

    /**
     *  重置属性值[指定月天]
     */
    public void resetMonthDayValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthDayValue();
            return;
        }

        this.monthdayvalueDirtyFlag = false;
        this.monthdayvalue = null;
    }
    /**
     *  设置属性值[月份]代码表：net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel
     *  @param monthtype
     */
    public void setMonthType(String monthtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthType(monthtype);
            return;
        }
        if(monthtype!=null) {
            monthtype = StringHelper.trimRight(monthtype);
            if(monthtype.length()==0) {
                monthtype = null;
            }
        }
        this.monthtype = monthtype;
        this.monthtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[月份]代码表：net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel
     */
    public String getMonthType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthType();
        }
        return this.monthtype;
    }

    /**
     *  获取属性值[月份]是否修改
     */
    public boolean isMonthTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthTypeDirty();
        }
        return this.monthtypeDirtyFlag;
    }

    /**
     *  重置属性值[月份]
     */
    public void resetMonthType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthType();
            return;
        }

        this.monthtypeDirtyFlag = false;
        this.monthtype = null;
    }
    /**
     *  设置属性值[指定月份]代码表：net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel
     *  @param monthvalue
     */
    public void setMonthValue(String monthvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthValue(monthvalue);
            return;
        }
        if(monthvalue!=null) {
            monthvalue = StringHelper.trimRight(monthvalue);
            if(monthvalue.length()==0) {
                monthvalue = null;
            }
        }
        this.monthvalue = monthvalue;
        this.monthvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定月份]代码表：net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel
     */
    public String getMonthValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthValue();
        }
        return this.monthvalue;
    }

    /**
     *  获取属性值[指定月份]是否修改
     */
    public boolean isMonthValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthValueDirty();
        }
        return this.monthvalueDirtyFlag;
    }

    /**
     *  重置属性值[指定月份]
     */
    public void resetMonthValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthValue();
            return;
        }

        this.monthvalueDirtyFlag = false;
        this.monthvalue = null;
    }
    /**
     *  设置属性值[月周]代码表：net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel
     *  @param monthweektype
     */
    public void setMonthWeekType(String monthweektype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthWeekType(monthweektype);
            return;
        }
        if(monthweektype!=null) {
            monthweektype = StringHelper.trimRight(monthweektype);
            if(monthweektype.length()==0) {
                monthweektype = null;
            }
        }
        this.monthweektype = monthweektype;
        this.monthweektypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[月周]代码表：net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel
     */
    public String getMonthWeekType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthWeekType();
        }
        return this.monthweektype;
    }

    /**
     *  获取属性值[月周]是否修改
     */
    public boolean isMonthWeekTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthWeekTypeDirty();
        }
        return this.monthweektypeDirtyFlag;
    }

    /**
     *  重置属性值[月周]
     */
    public void resetMonthWeekType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthWeekType();
            return;
        }

        this.monthweektypeDirtyFlag = false;
        this.monthweektype = null;
    }
    /**
     *  设置属性值[指定周天]代码表：net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel
     *  @param monthweekvalue
     */
    public void setMonthWeekValue(String monthweekvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMonthWeekValue(monthweekvalue);
            return;
        }
        if(monthweekvalue!=null) {
            monthweekvalue = StringHelper.trimRight(monthweekvalue);
            if(monthweekvalue.length()==0) {
                monthweekvalue = null;
            }
        }
        this.monthweekvalue = monthweekvalue;
        this.monthweekvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定周天]代码表：net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel
     */
    public String getMonthWeekValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMonthWeekValue();
        }
        return this.monthweekvalue;
    }

    /**
     *  获取属性值[指定周天]是否修改
     */
    public boolean isMonthWeekValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMonthWeekValueDirty();
        }
        return this.monthweekvalueDirtyFlag;
    }

    /**
     *  重置属性值[指定周天]
     */
    public void resetMonthWeekValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMonthWeekValue();
            return;
        }

        this.monthweekvalueDirtyFlag = false;
        this.monthweekvalue = null;
    }
    /**
     *  设置属性值[秒钟]代码表：net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel
     *  @param secondtype
     */
    public void setSecondType(String secondtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSecondType(secondtype);
            return;
        }
        if(secondtype!=null) {
            secondtype = StringHelper.trimRight(secondtype);
            if(secondtype.length()==0) {
                secondtype = null;
            }
        }
        this.secondtype = secondtype;
        this.secondtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[秒钟]代码表：net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel
     */
    public String getSecondType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSecondType();
        }
        return this.secondtype;
    }

    /**
     *  获取属性值[秒钟]是否修改
     */
    public boolean isSecondTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSecondTypeDirty();
        }
        return this.secondtypeDirtyFlag;
    }

    /**
     *  重置属性值[秒钟]
     */
    public void resetSecondType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSecondType();
            return;
        }

        this.secondtypeDirtyFlag = false;
        this.secondtype = null;
    }
    /**
     *  设置属性值[指定秒钟]代码表：net.ibizsys.psrt.srv.codelist.TSSecondCodeListModel
     *  @param secondvalue
     */
    public void setSecondValue(String secondvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSecondValue(secondvalue);
            return;
        }
        if(secondvalue!=null) {
            secondvalue = StringHelper.trimRight(secondvalue);
            if(secondvalue.length()==0) {
                secondvalue = null;
            }
        }
        this.secondvalue = secondvalue;
        this.secondvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定秒钟]代码表：net.ibizsys.psrt.srv.codelist.TSSecondCodeListModel
     */
    public String getSecondValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSecondValue();
        }
        return this.secondvalue;
    }

    /**
     *  获取属性值[指定秒钟]是否修改
     */
    public boolean isSecondValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSecondValueDirty();
        }
        return this.secondvalueDirtyFlag;
    }

    /**
     *  重置属性值[指定秒钟]
     */
    public void resetSecondValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSecondValue();
            return;
        }

        this.secondvalueDirtyFlag = false;
        this.secondvalue = null;
    }
    /**
     *  设置属性值[任务时刻策略项标识]
     *  @param tssditemid
     */
    public void setTSSDItemId(String tssditemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDItemId(tssditemid);
            return;
        }
        if(tssditemid!=null) {
            tssditemid = StringHelper.trimRight(tssditemid);
            if(tssditemid.length()==0) {
                tssditemid = null;
            }
        }
        this.tssditemid = tssditemid;
        this.tssditemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略项标识]
     */
    public String getTSSDItemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDItemId();
        }
        return this.tssditemid;
    }

    /**
     *  获取属性值[任务时刻策略项标识]是否修改
     */
    public boolean isTSSDItemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDItemIdDirty();
        }
        return this.tssditemidDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略项标识]
     */
    public void resetTSSDItemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDItemId();
            return;
        }

        this.tssditemidDirtyFlag = false;
        this.tssditemid = null;
    }
    /**
     *  设置属性值[任务时刻策略项]
     *  @param tssditemname
     */
    public void setTSSDItemName(String tssditemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTSSDItemName(tssditemname);
            return;
        }
        if(tssditemname!=null) {
            tssditemname = StringHelper.trimRight(tssditemname);
            if(tssditemname.length()==0) {
                tssditemname = null;
            }
        }
        this.tssditemname = tssditemname;
        this.tssditemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[任务时刻策略项]
     */
    public String getTSSDItemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTSSDItemName();
        }
        return this.tssditemname;
    }

    /**
     *  获取属性值[任务时刻策略项]是否修改
     */
    public boolean isTSSDItemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTSSDItemNameDirty();
        }
        return this.tssditemnameDirtyFlag;
    }

    /**
     *  重置属性值[任务时刻策略项]
     */
    public void resetTSSDItemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTSSDItemName();
            return;
        }

        this.tssditemnameDirtyFlag = false;
        this.tssditemname = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[版本]
     *  @param version
     */
    public void setVersion(Integer version) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        this.version = version;
        this.versionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetVersion();
            return;
        }

        this.versionDirtyFlag = false;
        this.version = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        TSSDItemBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isHourTypeDirty()) {
            params.put(FIELD_HOURTYPE,getHourType());
        }
        if(!bDirtyOnly || isHourValueDirty()) {
            params.put(FIELD_HOURVALUE,getHourValue());
        }
        if(!bDirtyOnly || isMinuteTypeDirty()) {
            params.put(FIELD_MINUTETYPE,getMinuteType());
        }
        if(!bDirtyOnly || isMinuteValueDirty()) {
            params.put(FIELD_MINUTEVALUE,getMinuteValue());
        }
        if(!bDirtyOnly || isMonthDayTypeDirty()) {
            params.put(FIELD_MONTHDAYTYPE,getMonthDayType());
        }
        if(!bDirtyOnly || isMonthDayValueDirty()) {
            params.put(FIELD_MONTHDAYVALUE,getMonthDayValue());
        }
        if(!bDirtyOnly || isMonthTypeDirty()) {
            params.put(FIELD_MONTHTYPE,getMonthType());
        }
        if(!bDirtyOnly || isMonthValueDirty()) {
            params.put(FIELD_MONTHVALUE,getMonthValue());
        }
        if(!bDirtyOnly || isMonthWeekTypeDirty()) {
            params.put(FIELD_MONTHWEEKTYPE,getMonthWeekType());
        }
        if(!bDirtyOnly || isMonthWeekValueDirty()) {
            params.put(FIELD_MONTHWEEKVALUE,getMonthWeekValue());
        }
        if(!bDirtyOnly || isSecondTypeDirty()) {
            params.put(FIELD_SECONDTYPE,getSecondType());
        }
        if(!bDirtyOnly || isSecondValueDirty()) {
            params.put(FIELD_SECONDVALUE,getSecondValue());
        }
        if(!bDirtyOnly || isTSSDItemIdDirty()) {
            params.put(FIELD_TSSDITEMID,getTSSDItemId());
        }
        if(!bDirtyOnly || isTSSDItemNameDirty()) {
            params.put(FIELD_TSSDITEMNAME,getTSSDItemName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isVersionDirty()) {
            params.put(FIELD_VERSION,getVersion());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  TSSDItemBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(TSSDItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_HOURTYPE:
            return et.getHourType();
        case INDEX_HOURVALUE:
            return et.getHourValue();
        case INDEX_MINUTETYPE:
            return et.getMinuteType();
        case INDEX_MINUTEVALUE:
            return et.getMinuteValue();
        case INDEX_MONTHDAYTYPE:
            return et.getMonthDayType();
        case INDEX_MONTHDAYVALUE:
            return et.getMonthDayValue();
        case INDEX_MONTHTYPE:
            return et.getMonthType();
        case INDEX_MONTHVALUE:
            return et.getMonthValue();
        case INDEX_MONTHWEEKTYPE:
            return et.getMonthWeekType();
        case INDEX_MONTHWEEKVALUE:
            return et.getMonthWeekValue();
        case INDEX_SECONDTYPE:
            return et.getSecondType();
        case INDEX_SECONDVALUE:
            return et.getSecondValue();
        case INDEX_TSSDITEMID:
            return et.getTSSDItemId();
        case INDEX_TSSDITEMNAME:
            return et.getTSSDItemName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VERSION:
            return et.getVersion();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        TSSDItemBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(TSSDItemBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_HOURTYPE:
            et.setHourType(DataObject.getStringValue(obj));
            return ;
        case INDEX_HOURVALUE:
            et.setHourValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINUTETYPE:
            et.setMinuteType(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINUTEVALUE:
            et.setMinuteValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHDAYTYPE:
            et.setMonthDayType(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHDAYVALUE:
            et.setMonthDayValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHTYPE:
            et.setMonthType(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHVALUE:
            et.setMonthValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHWEEKTYPE:
            et.setMonthWeekType(DataObject.getStringValue(obj));
            return ;
        case INDEX_MONTHWEEKVALUE:
            et.setMonthWeekValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_SECONDTYPE:
            et.setSecondType(DataObject.getStringValue(obj));
            return ;
        case INDEX_SECONDVALUE:
            et.setSecondValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDITEMID:
            et.setTSSDItemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TSSDITEMNAME:
            et.setTSSDItemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VERSION:
            et.setVersion(DataObject.getIntegerValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  TSSDItemBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(TSSDItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_HOURTYPE:
            return et.getHourType()==null;
        case INDEX_HOURVALUE:
            return et.getHourValue()==null;
        case INDEX_MINUTETYPE:
            return et.getMinuteType()==null;
        case INDEX_MINUTEVALUE:
            return et.getMinuteValue()==null;
        case INDEX_MONTHDAYTYPE:
            return et.getMonthDayType()==null;
        case INDEX_MONTHDAYVALUE:
            return et.getMonthDayValue()==null;
        case INDEX_MONTHTYPE:
            return et.getMonthType()==null;
        case INDEX_MONTHVALUE:
            return et.getMonthValue()==null;
        case INDEX_MONTHWEEKTYPE:
            return et.getMonthWeekType()==null;
        case INDEX_MONTHWEEKVALUE:
            return et.getMonthWeekValue()==null;
        case INDEX_SECONDTYPE:
            return et.getSecondType()==null;
        case INDEX_SECONDVALUE:
            return et.getSecondValue()==null;
        case INDEX_TSSDITEMID:
            return et.getTSSDItemId()==null;
        case INDEX_TSSDITEMNAME:
            return et.getTSSDItemName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VERSION:
            return et.getVersion()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  TSSDItemBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(TSSDItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_HOURTYPE:
            return et.isHourTypeDirty();
        case INDEX_HOURVALUE:
            return et.isHourValueDirty();
        case INDEX_MINUTETYPE:
            return et.isMinuteTypeDirty();
        case INDEX_MINUTEVALUE:
            return et.isMinuteValueDirty();
        case INDEX_MONTHDAYTYPE:
            return et.isMonthDayTypeDirty();
        case INDEX_MONTHDAYVALUE:
            return et.isMonthDayValueDirty();
        case INDEX_MONTHTYPE:
            return et.isMonthTypeDirty();
        case INDEX_MONTHVALUE:
            return et.isMonthValueDirty();
        case INDEX_MONTHWEEKTYPE:
            return et.isMonthWeekTypeDirty();
        case INDEX_MONTHWEEKVALUE:
            return et.isMonthWeekValueDirty();
        case INDEX_SECONDTYPE:
            return et.isSecondTypeDirty();
        case INDEX_SECONDVALUE:
            return et.isSecondValueDirty();
        case INDEX_TSSDITEMID:
            return et.isTSSDItemIdDirty();
        case INDEX_TSSDITEMNAME:
            return et.isTSSDItemNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VERSION:
            return et.isVersionDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(TSSDItemBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getHourType()!=null) {
            JSONObjectHelper.put(json,"hourtype",getJSONValue(et.getHourType()),false);
        }
        if(bIncEmpty||et.getHourValue()!=null) {
            JSONObjectHelper.put(json,"hourvalue",getJSONValue(et.getHourValue()),false);
        }
        if(bIncEmpty||et.getMinuteType()!=null) {
            JSONObjectHelper.put(json,"minutetype",getJSONValue(et.getMinuteType()),false);
        }
        if(bIncEmpty||et.getMinuteValue()!=null) {
            JSONObjectHelper.put(json,"minutevalue",getJSONValue(et.getMinuteValue()),false);
        }
        if(bIncEmpty||et.getMonthDayType()!=null) {
            JSONObjectHelper.put(json,"monthdaytype",getJSONValue(et.getMonthDayType()),false);
        }
        if(bIncEmpty||et.getMonthDayValue()!=null) {
            JSONObjectHelper.put(json,"monthdayvalue",getJSONValue(et.getMonthDayValue()),false);
        }
        if(bIncEmpty||et.getMonthType()!=null) {
            JSONObjectHelper.put(json,"monthtype",getJSONValue(et.getMonthType()),false);
        }
        if(bIncEmpty||et.getMonthValue()!=null) {
            JSONObjectHelper.put(json,"monthvalue",getJSONValue(et.getMonthValue()),false);
        }
        if(bIncEmpty||et.getMonthWeekType()!=null) {
            JSONObjectHelper.put(json,"monthweektype",getJSONValue(et.getMonthWeekType()),false);
        }
        if(bIncEmpty||et.getMonthWeekValue()!=null) {
            JSONObjectHelper.put(json,"monthweekvalue",getJSONValue(et.getMonthWeekValue()),false);
        }
        if(bIncEmpty||et.getSecondType()!=null) {
            JSONObjectHelper.put(json,"secondtype",getJSONValue(et.getSecondType()),false);
        }
        if(bIncEmpty||et.getSecondValue()!=null) {
            JSONObjectHelper.put(json,"secondvalue",getJSONValue(et.getSecondValue()),false);
        }
        if(bIncEmpty||et.getTSSDItemId()!=null) {
            JSONObjectHelper.put(json,"tssditemid",getJSONValue(et.getTSSDItemId()),false);
        }
        if(bIncEmpty||et.getTSSDItemName()!=null) {
            JSONObjectHelper.put(json,"tssditemname",getJSONValue(et.getTSSDItemName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            JSONObjectHelper.put(json,"version",getJSONValue(et.getVersion()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(TSSDItemBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getHourType()!=null) {
            Object obj = et.getHourType();
            node.setAttribute("HOURTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getHourValue()!=null) {
            Object obj = et.getHourValue();
            node.setAttribute("HOURVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinuteType()!=null) {
            Object obj = et.getMinuteType();
            node.setAttribute("MINUTETYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinuteValue()!=null) {
            Object obj = et.getMinuteValue();
            node.setAttribute("MINUTEVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthDayType()!=null) {
            Object obj = et.getMonthDayType();
            node.setAttribute("MONTHDAYTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthDayValue()!=null) {
            Object obj = et.getMonthDayValue();
            node.setAttribute("MONTHDAYVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthType()!=null) {
            Object obj = et.getMonthType();
            node.setAttribute("MONTHTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthValue()!=null) {
            Object obj = et.getMonthValue();
            node.setAttribute("MONTHVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthWeekType()!=null) {
            Object obj = et.getMonthWeekType();
            node.setAttribute("MONTHWEEKTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMonthWeekValue()!=null) {
            Object obj = et.getMonthWeekValue();
            node.setAttribute("MONTHWEEKVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSecondType()!=null) {
            Object obj = et.getSecondType();
            node.setAttribute("SECONDTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSecondValue()!=null) {
            Object obj = et.getSecondValue();
            node.setAttribute("SECONDVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDItemId()!=null) {
            Object obj = et.getTSSDItemId();
            node.setAttribute("TSSDITEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTSSDItemName()!=null) {
            Object obj = et.getTSSDItemName();
            node.setAttribute("TSSDITEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getVersion()!=null) {
            Object obj = et.getVersion();
            node.setAttribute("VERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDItemBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(TSSDItemBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isHourTypeDirty() && (bIncEmpty||et.getHourType()!=null)) {
            dst.set(FIELD_HOURTYPE,et.getHourType());
        }
        if(et.isHourValueDirty() && (bIncEmpty||et.getHourValue()!=null)) {
            dst.set(FIELD_HOURVALUE,et.getHourValue());
        }
        if(et.isMinuteTypeDirty() && (bIncEmpty||et.getMinuteType()!=null)) {
            dst.set(FIELD_MINUTETYPE,et.getMinuteType());
        }
        if(et.isMinuteValueDirty() && (bIncEmpty||et.getMinuteValue()!=null)) {
            dst.set(FIELD_MINUTEVALUE,et.getMinuteValue());
        }
        if(et.isMonthDayTypeDirty() && (bIncEmpty||et.getMonthDayType()!=null)) {
            dst.set(FIELD_MONTHDAYTYPE,et.getMonthDayType());
        }
        if(et.isMonthDayValueDirty() && (bIncEmpty||et.getMonthDayValue()!=null)) {
            dst.set(FIELD_MONTHDAYVALUE,et.getMonthDayValue());
        }
        if(et.isMonthTypeDirty() && (bIncEmpty||et.getMonthType()!=null)) {
            dst.set(FIELD_MONTHTYPE,et.getMonthType());
        }
        if(et.isMonthValueDirty() && (bIncEmpty||et.getMonthValue()!=null)) {
            dst.set(FIELD_MONTHVALUE,et.getMonthValue());
        }
        if(et.isMonthWeekTypeDirty() && (bIncEmpty||et.getMonthWeekType()!=null)) {
            dst.set(FIELD_MONTHWEEKTYPE,et.getMonthWeekType());
        }
        if(et.isMonthWeekValueDirty() && (bIncEmpty||et.getMonthWeekValue()!=null)) {
            dst.set(FIELD_MONTHWEEKVALUE,et.getMonthWeekValue());
        }
        if(et.isSecondTypeDirty() && (bIncEmpty||et.getSecondType()!=null)) {
            dst.set(FIELD_SECONDTYPE,et.getSecondType());
        }
        if(et.isSecondValueDirty() && (bIncEmpty||et.getSecondValue()!=null)) {
            dst.set(FIELD_SECONDVALUE,et.getSecondValue());
        }
        if(et.isTSSDItemIdDirty() && (bIncEmpty||et.getTSSDItemId()!=null)) {
            dst.set(FIELD_TSSDITEMID,et.getTSSDItemId());
        }
        if(et.isTSSDItemNameDirty() && (bIncEmpty||et.getTSSDItemName()!=null)) {
            dst.set(FIELD_TSSDITEMNAME,et.getTSSDItemName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isVersionDirty() && (bIncEmpty||et.getVersion()!=null)) {
            dst.set(FIELD_VERSION,et.getVersion());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  TSSDItemBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(TSSDItemBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_HOURTYPE:
            et.resetHourType();
            return true;
        case INDEX_HOURVALUE:
            et.resetHourValue();
            return true;
        case INDEX_MINUTETYPE:
            et.resetMinuteType();
            return true;
        case INDEX_MINUTEVALUE:
            et.resetMinuteValue();
            return true;
        case INDEX_MONTHDAYTYPE:
            et.resetMonthDayType();
            return true;
        case INDEX_MONTHDAYVALUE:
            et.resetMonthDayValue();
            return true;
        case INDEX_MONTHTYPE:
            et.resetMonthType();
            return true;
        case INDEX_MONTHVALUE:
            et.resetMonthValue();
            return true;
        case INDEX_MONTHWEEKTYPE:
            et.resetMonthWeekType();
            return true;
        case INDEX_MONTHWEEKVALUE:
            et.resetMonthWeekValue();
            return true;
        case INDEX_SECONDTYPE:
            et.resetSecondType();
            return true;
        case INDEX_SECONDVALUE:
            et.resetSecondValue();
            return true;
        case INDEX_TSSDITEMID:
            et.resetTSSDItemId();
            return true;
        case INDEX_TSSDITEMNAME:
            et.resetTSSDItemName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VERSION:
            et.resetVersion();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private TSSDItemBase getProxyEntity() {
        return this.proxyTSSDItemBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDItemBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof TSSDItemBase) {
            this.proxyTSSDItemBase = (TSSDItemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}