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
 * 实体[PPModel] 数据对象基类
 */
public abstract class PPModelBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PPModelBase.class);
    /**
     * 属性[中间部件1]
     */
    public final static String FIELD_C1PVPARTCTRLID = "C1PVPARTCTRLID";
    /**
     * 属性[中间部件1]
     */
    public final static String FIELD_C1PVPARTID = "C1PVPARTID";
    /**
     * 属性[中间部件1]
     */
    public final static String FIELD_C1PVPARTNAME = "C1PVPARTNAME";
    /**
     * 属性[中间部件2]
     */
    public final static String FIELD_C2PVPARTCTRLID = "C2PVPARTCTRLID";
    /**
     * 属性[中间部件2]
     */
    public final static String FIELD_C2PVPARTID = "C2PVPARTID";
    /**
     * 属性[中间部件2]
     */
    public final static String FIELD_C2PVPARTNAME = "C2PVPARTNAME";
    /**
     * 属性[中间部件3]
     */
    public final static String FIELD_C3PVPARTCTRLID = "C3PVPARTCTRLID";
    /**
     * 属性[中间部件3]
     */
    public final static String FIELD_C3PVPARTID = "C3PVPARTID";
    /**
     * 属性[中间部件3]
     */
    public final static String FIELD_C3PVPARTNAME = "C3PVPARTNAME";
    /**
     * 属性[中间部件4]
     */
    public final static String FIELD_C4PVPARTCTRLID = "C4PVPARTCTRLID";
    /**
     * 属性[中间部件4]
     */
    public final static String FIELD_C4PVPARTID = "C4PVPARTID";
    /**
     * 属性[中间部件4]
     */
    public final static String FIELD_C4PVPARTNAME = "C4PVPARTNAME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[系统数据]
     */
    public final static String FIELD_ISSYSTEM = "ISSYSTEM";
    /**
     * 属性[左侧部件1]
     */
    public final static String FIELD_L1PVPARTCTRLID = "L1PVPARTCTRLID";
    /**
     * 属性[左侧部件1]
     */
    public final static String FIELD_L1PVPARTID = "L1PVPARTID";
    /**
     * 属性[左侧部件1]
     */
    public final static String FIELD_L1PVPARTNAME = "L1PVPARTNAME";
    /**
     * 属性[左侧部件2]
     */
    public final static String FIELD_L2PVPARTCTRLID = "L2PVPARTCTRLID";
    /**
     * 属性[左侧部件2]
     */
    public final static String FIELD_L2PVPARTID = "L2PVPARTID";
    /**
     * 属性[左侧部件2]
     */
    public final static String FIELD_L2PVPARTNAME = "L2PVPARTNAME";
    /**
     * 属性[左侧部件3]
     */
    public final static String FIELD_L3PVPARTCTRLID = "L3PVPARTCTRLID";
    /**
     * 属性[左侧部件3]
     */
    public final static String FIELD_L3PVPARTID = "L3PVPARTID";
    /**
     * 属性[左侧部件3]
     */
    public final static String FIELD_L3PVPARTNAME = "L3PVPARTNAME";
    /**
     * 属性[左侧部件4]
     */
    public final static String FIELD_L4PVPARTCTRLID = "L4PVPARTCTRLID";
    /**
     * 属性[左侧部件4]
     */
    public final static String FIELD_L4PVPARTID = "L4PVPARTID";
    /**
     * 属性[左侧部件4]
     */
    public final static String FIELD_L4PVPARTNAME = "L4PVPARTNAME";
    /**
     * 属性[所有者]
     */
    public final static String FIELD_OWNERID = "OWNERID";
    /**
     * 属性[门户页面]
     */
    public final static String FIELD_PORTALPAGEID = "PORTALPAGEID";
    /**
     * 属性[频道页]
     */
    public final static String FIELD_PORTALPAGENAME = "PORTALPAGENAME";
    /**
     * 属性[页面布局]
     */
    public final static String FIELD_PPMODEL = "PPMODEL";
    /**
     * 属性[模型明细]
     */
    public final static String FIELD_PPMODELDETAIL = "PPMODELDETAIL";
    /**
     * 属性[用户频道页标识]
     */
    public final static String FIELD_PPMODELID = "PPMODELID";
    /**
     * 属性[用户频道页名称]
     */
    public final static String FIELD_PPMODELNAME = "PPMODELNAME";
    /**
     * 属性[版本]
     */
    public final static String FIELD_PPMVERSION = "PPMVERSION";
    /**
     * 属性[右侧部件1]
     */
    public final static String FIELD_R1PVPARTCTRLID = "R1PVPARTCTRLID";
    /**
     * 属性[右侧部件1]
     */
    public final static String FIELD_R1PVPARTID = "R1PVPARTID";
    /**
     * 属性[右侧部件1]
     */
    public final static String FIELD_R1PVPARTNAME = "R1PVPARTNAME";
    /**
     * 属性[右侧部件2]
     */
    public final static String FIELD_R2PVPARTCTRLID = "R2PVPARTCTRLID";
    /**
     * 属性[右侧部件2]
     */
    public final static String FIELD_R2PVPARTID = "R2PVPARTID";
    /**
     * 属性[右侧部件2]
     */
    public final static String FIELD_R2PVPARTNAME = "R2PVPARTNAME";
    /**
     * 属性[右侧部件3]
     */
    public final static String FIELD_R3PVPARTCTRLID = "R3PVPARTCTRLID";
    /**
     * 属性[右侧部件3]
     */
    public final static String FIELD_R3PVPARTID = "R3PVPARTID";
    /**
     * 属性[右侧部件3]
     */
    public final static String FIELD_R3PVPARTNAME = "R3PVPARTNAME";
    /**
     * 属性[右侧部件4]
     */
    public final static String FIELD_R4PVPARTCTRLID = "R4PVPARTCTRLID";
    /**
     * 属性[右侧部件4]
     */
    public final static String FIELD_R4PVPARTID = "R4PVPARTID";
    /**
     * 属性[右侧部件4]
     */
    public final static String FIELD_R4PVPARTNAME = "R4PVPARTNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_C1PVPARTCTRLID = 0;
    private final static int INDEX_C1PVPARTID = 1;
    private final static int INDEX_C1PVPARTNAME = 2;
    private final static int INDEX_C2PVPARTCTRLID = 3;
    private final static int INDEX_C2PVPARTID = 4;
    private final static int INDEX_C2PVPARTNAME = 5;
    private final static int INDEX_C3PVPARTCTRLID = 6;
    private final static int INDEX_C3PVPARTID = 7;
    private final static int INDEX_C3PVPARTNAME = 8;
    private final static int INDEX_C4PVPARTCTRLID = 9;
    private final static int INDEX_C4PVPARTID = 10;
    private final static int INDEX_C4PVPARTNAME = 11;
    private final static int INDEX_CREATEDATE = 12;
    private final static int INDEX_CREATEMAN = 13;
    private final static int INDEX_ISSYSTEM = 14;
    private final static int INDEX_L1PVPARTCTRLID = 15;
    private final static int INDEX_L1PVPARTID = 16;
    private final static int INDEX_L1PVPARTNAME = 17;
    private final static int INDEX_L2PVPARTCTRLID = 18;
    private final static int INDEX_L2PVPARTID = 19;
    private final static int INDEX_L2PVPARTNAME = 20;
    private final static int INDEX_L3PVPARTCTRLID = 21;
    private final static int INDEX_L3PVPARTID = 22;
    private final static int INDEX_L3PVPARTNAME = 23;
    private final static int INDEX_L4PVPARTCTRLID = 24;
    private final static int INDEX_L4PVPARTID = 25;
    private final static int INDEX_L4PVPARTNAME = 26;
    private final static int INDEX_OWNERID = 27;
    private final static int INDEX_PORTALPAGEID = 28;
    private final static int INDEX_PORTALPAGENAME = 29;
    private final static int INDEX_PPMODEL = 30;
    private final static int INDEX_PPMODELDETAIL = 31;
    private final static int INDEX_PPMODELID = 32;
    private final static int INDEX_PPMODELNAME = 33;
    private final static int INDEX_PPMVERSION = 34;
    private final static int INDEX_R1PVPARTCTRLID = 35;
    private final static int INDEX_R1PVPARTID = 36;
    private final static int INDEX_R1PVPARTNAME = 37;
    private final static int INDEX_R2PVPARTCTRLID = 38;
    private final static int INDEX_R2PVPARTID = 39;
    private final static int INDEX_R2PVPARTNAME = 40;
    private final static int INDEX_R3PVPARTCTRLID = 41;
    private final static int INDEX_R3PVPARTID = 42;
    private final static int INDEX_R3PVPARTNAME = 43;
    private final static int INDEX_R4PVPARTCTRLID = 44;
    private final static int INDEX_R4PVPARTID = 45;
    private final static int INDEX_R4PVPARTNAME = 46;
    private final static int INDEX_UPDATEDATE = 47;
    private final static int INDEX_UPDATEMAN = 48;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_C1PVPARTCTRLID, INDEX_C1PVPARTCTRLID);
        fieldIndexMap.put( FIELD_C1PVPARTID, INDEX_C1PVPARTID);
        fieldIndexMap.put( FIELD_C1PVPARTNAME, INDEX_C1PVPARTNAME);
        fieldIndexMap.put( FIELD_C2PVPARTCTRLID, INDEX_C2PVPARTCTRLID);
        fieldIndexMap.put( FIELD_C2PVPARTID, INDEX_C2PVPARTID);
        fieldIndexMap.put( FIELD_C2PVPARTNAME, INDEX_C2PVPARTNAME);
        fieldIndexMap.put( FIELD_C3PVPARTCTRLID, INDEX_C3PVPARTCTRLID);
        fieldIndexMap.put( FIELD_C3PVPARTID, INDEX_C3PVPARTID);
        fieldIndexMap.put( FIELD_C3PVPARTNAME, INDEX_C3PVPARTNAME);
        fieldIndexMap.put( FIELD_C4PVPARTCTRLID, INDEX_C4PVPARTCTRLID);
        fieldIndexMap.put( FIELD_C4PVPARTID, INDEX_C4PVPARTID);
        fieldIndexMap.put( FIELD_C4PVPARTNAME, INDEX_C4PVPARTNAME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ISSYSTEM, INDEX_ISSYSTEM);
        fieldIndexMap.put( FIELD_L1PVPARTCTRLID, INDEX_L1PVPARTCTRLID);
        fieldIndexMap.put( FIELD_L1PVPARTID, INDEX_L1PVPARTID);
        fieldIndexMap.put( FIELD_L1PVPARTNAME, INDEX_L1PVPARTNAME);
        fieldIndexMap.put( FIELD_L2PVPARTCTRLID, INDEX_L2PVPARTCTRLID);
        fieldIndexMap.put( FIELD_L2PVPARTID, INDEX_L2PVPARTID);
        fieldIndexMap.put( FIELD_L2PVPARTNAME, INDEX_L2PVPARTNAME);
        fieldIndexMap.put( FIELD_L3PVPARTCTRLID, INDEX_L3PVPARTCTRLID);
        fieldIndexMap.put( FIELD_L3PVPARTID, INDEX_L3PVPARTID);
        fieldIndexMap.put( FIELD_L3PVPARTNAME, INDEX_L3PVPARTNAME);
        fieldIndexMap.put( FIELD_L4PVPARTCTRLID, INDEX_L4PVPARTCTRLID);
        fieldIndexMap.put( FIELD_L4PVPARTID, INDEX_L4PVPARTID);
        fieldIndexMap.put( FIELD_L4PVPARTNAME, INDEX_L4PVPARTNAME);
        fieldIndexMap.put( FIELD_OWNERID, INDEX_OWNERID);
        fieldIndexMap.put( FIELD_PORTALPAGEID, INDEX_PORTALPAGEID);
        fieldIndexMap.put( FIELD_PORTALPAGENAME, INDEX_PORTALPAGENAME);
        fieldIndexMap.put( FIELD_PPMODEL, INDEX_PPMODEL);
        fieldIndexMap.put( FIELD_PPMODELDETAIL, INDEX_PPMODELDETAIL);
        fieldIndexMap.put( FIELD_PPMODELID, INDEX_PPMODELID);
        fieldIndexMap.put( FIELD_PPMODELNAME, INDEX_PPMODELNAME);
        fieldIndexMap.put( FIELD_PPMVERSION, INDEX_PPMVERSION);
        fieldIndexMap.put( FIELD_R1PVPARTCTRLID, INDEX_R1PVPARTCTRLID);
        fieldIndexMap.put( FIELD_R1PVPARTID, INDEX_R1PVPARTID);
        fieldIndexMap.put( FIELD_R1PVPARTNAME, INDEX_R1PVPARTNAME);
        fieldIndexMap.put( FIELD_R2PVPARTCTRLID, INDEX_R2PVPARTCTRLID);
        fieldIndexMap.put( FIELD_R2PVPARTID, INDEX_R2PVPARTID);
        fieldIndexMap.put( FIELD_R2PVPARTNAME, INDEX_R2PVPARTNAME);
        fieldIndexMap.put( FIELD_R3PVPARTCTRLID, INDEX_R3PVPARTCTRLID);
        fieldIndexMap.put( FIELD_R3PVPARTID, INDEX_R3PVPARTID);
        fieldIndexMap.put( FIELD_R3PVPARTNAME, INDEX_R3PVPARTNAME);
        fieldIndexMap.put( FIELD_R4PVPARTCTRLID, INDEX_R4PVPARTCTRLID);
        fieldIndexMap.put( FIELD_R4PVPARTID, INDEX_R4PVPARTID);
        fieldIndexMap.put( FIELD_R4PVPARTNAME, INDEX_R4PVPARTNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private PPModelBase proxyPPModelBase = null;
    public PPModelBase() {
        super();
    }
    private boolean c1pvpartctrlidDirtyFlag = false;
    private boolean c1pvpartidDirtyFlag = false;
    private boolean c1pvpartnameDirtyFlag = false;
    private boolean c2pvpartctrlidDirtyFlag = false;
    private boolean c2pvpartidDirtyFlag = false;
    private boolean c2pvpartnameDirtyFlag = false;
    private boolean c3pvpartctrlidDirtyFlag = false;
    private boolean c3pvpartidDirtyFlag = false;
    private boolean c3pvpartnameDirtyFlag = false;
    private boolean c4pvpartctrlidDirtyFlag = false;
    private boolean c4pvpartidDirtyFlag = false;
    private boolean c4pvpartnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean l1pvpartctrlidDirtyFlag = false;
    private boolean l1pvpartidDirtyFlag = false;
    private boolean l1pvpartnameDirtyFlag = false;
    private boolean l2pvpartctrlidDirtyFlag = false;
    private boolean l2pvpartidDirtyFlag = false;
    private boolean l2pvpartnameDirtyFlag = false;
    private boolean l3pvpartctrlidDirtyFlag = false;
    private boolean l3pvpartidDirtyFlag = false;
    private boolean l3pvpartnameDirtyFlag = false;
    private boolean l4pvpartctrlidDirtyFlag = false;
    private boolean l4pvpartidDirtyFlag = false;
    private boolean l4pvpartnameDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean portalpageidDirtyFlag = false;
    private boolean portalpagenameDirtyFlag = false;
    private boolean ppmodelDirtyFlag = false;
    private boolean ppmodeldetailDirtyFlag = false;
    private boolean ppmodelidDirtyFlag = false;
    private boolean ppmodelnameDirtyFlag = false;
    private boolean ppmversionDirtyFlag = false;
    private boolean r1pvpartctrlidDirtyFlag = false;
    private boolean r1pvpartidDirtyFlag = false;
    private boolean r1pvpartnameDirtyFlag = false;
    private boolean r2pvpartctrlidDirtyFlag = false;
    private boolean r2pvpartidDirtyFlag = false;
    private boolean r2pvpartnameDirtyFlag = false;
    private boolean r3pvpartctrlidDirtyFlag = false;
    private boolean r3pvpartidDirtyFlag = false;
    private boolean r3pvpartnameDirtyFlag = false;
    private boolean r4pvpartctrlidDirtyFlag = false;
    private boolean r4pvpartidDirtyFlag = false;
    private boolean r4pvpartnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="c1pvpartctrlid")
    private String c1pvpartctrlid;
    @Column(name="c1pvpartid")
    private String c1pvpartid;
    @Column(name="c1pvpartname")
    private String c1pvpartname;
    @Column(name="c2pvpartctrlid")
    private String c2pvpartctrlid;
    @Column(name="c2pvpartid")
    private String c2pvpartid;
    @Column(name="c2pvpartname")
    private String c2pvpartname;
    @Column(name="c3pvpartctrlid")
    private String c3pvpartctrlid;
    @Column(name="c3pvpartid")
    private String c3pvpartid;
    @Column(name="c3pvpartname")
    private String c3pvpartname;
    @Column(name="c4pvpartctrlid")
    private String c4pvpartctrlid;
    @Column(name="c4pvpartid")
    private String c4pvpartid;
    @Column(name="c4pvpartname")
    private String c4pvpartname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="l1pvpartctrlid")
    private String l1pvpartctrlid;
    @Column(name="l1pvpartid")
    private String l1pvpartid;
    @Column(name="l1pvpartname")
    private String l1pvpartname;
    @Column(name="l2pvpartctrlid")
    private String l2pvpartctrlid;
    @Column(name="l2pvpartid")
    private String l2pvpartid;
    @Column(name="l2pvpartname")
    private String l2pvpartname;
    @Column(name="l3pvpartctrlid")
    private String l3pvpartctrlid;
    @Column(name="l3pvpartid")
    private String l3pvpartid;
    @Column(name="l3pvpartname")
    private String l3pvpartname;
    @Column(name="l4pvpartctrlid")
    private String l4pvpartctrlid;
    @Column(name="l4pvpartid")
    private String l4pvpartid;
    @Column(name="l4pvpartname")
    private String l4pvpartname;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="portalpageid")
    private String portalpageid;
    @Column(name="portalpagename")
    private String portalpagename;
    @Column(name="ppmodel")
    private String ppmodel;
    @Column(name="ppmodeldetail")
    private String ppmodeldetail;
    @Column(name="ppmodelid")
    private String ppmodelid;
    @Column(name="ppmodelname")
    private String ppmodelname;
    @Column(name="ppmversion")
    private Integer ppmversion;
    @Column(name="r1pvpartctrlid")
    private String r1pvpartctrlid;
    @Column(name="r1pvpartid")
    private String r1pvpartid;
    @Column(name="r1pvpartname")
    private String r1pvpartname;
    @Column(name="r2pvpartctrlid")
    private String r2pvpartctrlid;
    @Column(name="r2pvpartid")
    private String r2pvpartid;
    @Column(name="r2pvpartname")
    private String r2pvpartname;
    @Column(name="r3pvpartctrlid")
    private String r3pvpartctrlid;
    @Column(name="r3pvpartid")
    private String r3pvpartid;
    @Column(name="r3pvpartname")
    private String r3pvpartname;
    @Column(name="r4pvpartctrlid")
    private String r4pvpartctrlid;
    @Column(name="r4pvpartid")
    private String r4pvpartid;
    @Column(name="r4pvpartname")
    private String r4pvpartname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[中间部件1]
     *  @param c1pvpartctrlid
     */
    public void setC1PVPartCtrlId(String c1pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC1PVPartCtrlId(c1pvpartctrlid);
            return;
        }
        if(c1pvpartctrlid!=null) {
            c1pvpartctrlid = StringHelper.trimRight(c1pvpartctrlid);
            if(c1pvpartctrlid.length()==0) {
                c1pvpartctrlid = null;
            }
        }
        this.c1pvpartctrlid = c1pvpartctrlid;
        this.c1pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件1]
     */
    public String getC1PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC1PVPartCtrlId();
        }
        return this.c1pvpartctrlid;
    }

    /**
     *  获取属性值[中间部件1]是否修改
     */
    public boolean isC1PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC1PVPartCtrlIdDirty();
        }
        return this.c1pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件1]
     */
    public void resetC1PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC1PVPartCtrlId();
            return;
        }

        this.c1pvpartctrlidDirtyFlag = false;
        this.c1pvpartctrlid = null;
    }
    /**
     *  设置属性值[中间部件1]
     *  @param c1pvpartid
     */
    public void setC1PVPartId(String c1pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC1PVPartId(c1pvpartid);
            return;
        }
        if(c1pvpartid!=null) {
            c1pvpartid = StringHelper.trimRight(c1pvpartid);
            if(c1pvpartid.length()==0) {
                c1pvpartid = null;
            }
        }
        this.c1pvpartid = c1pvpartid;
        this.c1pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件1]
     */
    public String getC1PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC1PVPartId();
        }
        return this.c1pvpartid;
    }

    /**
     *  获取属性值[中间部件1]是否修改
     */
    public boolean isC1PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC1PVPartIdDirty();
        }
        return this.c1pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件1]
     */
    public void resetC1PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC1PVPartId();
            return;
        }

        this.c1pvpartidDirtyFlag = false;
        this.c1pvpartid = null;
    }
    /**
     *  设置属性值[中间部件1]
     *  @param c1pvpartname
     */
    public void setC1PVPartName(String c1pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC1PVPartName(c1pvpartname);
            return;
        }
        if(c1pvpartname!=null) {
            c1pvpartname = StringHelper.trimRight(c1pvpartname);
            if(c1pvpartname.length()==0) {
                c1pvpartname = null;
            }
        }
        this.c1pvpartname = c1pvpartname;
        this.c1pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件1]
     */
    public String getC1PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC1PVPartName();
        }
        return this.c1pvpartname;
    }

    /**
     *  获取属性值[中间部件1]是否修改
     */
    public boolean isC1PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC1PVPartNameDirty();
        }
        return this.c1pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[中间部件1]
     */
    public void resetC1PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC1PVPartName();
            return;
        }

        this.c1pvpartnameDirtyFlag = false;
        this.c1pvpartname = null;
    }
    /**
     *  设置属性值[中间部件2]
     *  @param c2pvpartctrlid
     */
    public void setC2PVPartCtrlId(String c2pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC2PVPartCtrlId(c2pvpartctrlid);
            return;
        }
        if(c2pvpartctrlid!=null) {
            c2pvpartctrlid = StringHelper.trimRight(c2pvpartctrlid);
            if(c2pvpartctrlid.length()==0) {
                c2pvpartctrlid = null;
            }
        }
        this.c2pvpartctrlid = c2pvpartctrlid;
        this.c2pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件2]
     */
    public String getC2PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC2PVPartCtrlId();
        }
        return this.c2pvpartctrlid;
    }

    /**
     *  获取属性值[中间部件2]是否修改
     */
    public boolean isC2PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC2PVPartCtrlIdDirty();
        }
        return this.c2pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件2]
     */
    public void resetC2PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC2PVPartCtrlId();
            return;
        }

        this.c2pvpartctrlidDirtyFlag = false;
        this.c2pvpartctrlid = null;
    }
    /**
     *  设置属性值[中间部件2]
     *  @param c2pvpartid
     */
    public void setC2PVPartId(String c2pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC2PVPartId(c2pvpartid);
            return;
        }
        if(c2pvpartid!=null) {
            c2pvpartid = StringHelper.trimRight(c2pvpartid);
            if(c2pvpartid.length()==0) {
                c2pvpartid = null;
            }
        }
        this.c2pvpartid = c2pvpartid;
        this.c2pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件2]
     */
    public String getC2PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC2PVPartId();
        }
        return this.c2pvpartid;
    }

    /**
     *  获取属性值[中间部件2]是否修改
     */
    public boolean isC2PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC2PVPartIdDirty();
        }
        return this.c2pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件2]
     */
    public void resetC2PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC2PVPartId();
            return;
        }

        this.c2pvpartidDirtyFlag = false;
        this.c2pvpartid = null;
    }
    /**
     *  设置属性值[中间部件2]
     *  @param c2pvpartname
     */
    public void setC2PVPartName(String c2pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC2PVPartName(c2pvpartname);
            return;
        }
        if(c2pvpartname!=null) {
            c2pvpartname = StringHelper.trimRight(c2pvpartname);
            if(c2pvpartname.length()==0) {
                c2pvpartname = null;
            }
        }
        this.c2pvpartname = c2pvpartname;
        this.c2pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件2]
     */
    public String getC2PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC2PVPartName();
        }
        return this.c2pvpartname;
    }

    /**
     *  获取属性值[中间部件2]是否修改
     */
    public boolean isC2PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC2PVPartNameDirty();
        }
        return this.c2pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[中间部件2]
     */
    public void resetC2PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC2PVPartName();
            return;
        }

        this.c2pvpartnameDirtyFlag = false;
        this.c2pvpartname = null;
    }
    /**
     *  设置属性值[中间部件3]
     *  @param c3pvpartctrlid
     */
    public void setC3PVPartCtrlId(String c3pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC3PVPartCtrlId(c3pvpartctrlid);
            return;
        }
        if(c3pvpartctrlid!=null) {
            c3pvpartctrlid = StringHelper.trimRight(c3pvpartctrlid);
            if(c3pvpartctrlid.length()==0) {
                c3pvpartctrlid = null;
            }
        }
        this.c3pvpartctrlid = c3pvpartctrlid;
        this.c3pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件3]
     */
    public String getC3PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC3PVPartCtrlId();
        }
        return this.c3pvpartctrlid;
    }

    /**
     *  获取属性值[中间部件3]是否修改
     */
    public boolean isC3PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC3PVPartCtrlIdDirty();
        }
        return this.c3pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件3]
     */
    public void resetC3PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC3PVPartCtrlId();
            return;
        }

        this.c3pvpartctrlidDirtyFlag = false;
        this.c3pvpartctrlid = null;
    }
    /**
     *  设置属性值[中间部件3]
     *  @param c3pvpartid
     */
    public void setC3PVPartId(String c3pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC3PVPartId(c3pvpartid);
            return;
        }
        if(c3pvpartid!=null) {
            c3pvpartid = StringHelper.trimRight(c3pvpartid);
            if(c3pvpartid.length()==0) {
                c3pvpartid = null;
            }
        }
        this.c3pvpartid = c3pvpartid;
        this.c3pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件3]
     */
    public String getC3PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC3PVPartId();
        }
        return this.c3pvpartid;
    }

    /**
     *  获取属性值[中间部件3]是否修改
     */
    public boolean isC3PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC3PVPartIdDirty();
        }
        return this.c3pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件3]
     */
    public void resetC3PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC3PVPartId();
            return;
        }

        this.c3pvpartidDirtyFlag = false;
        this.c3pvpartid = null;
    }
    /**
     *  设置属性值[中间部件3]
     *  @param c3pvpartname
     */
    public void setC3PVPartName(String c3pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC3PVPartName(c3pvpartname);
            return;
        }
        if(c3pvpartname!=null) {
            c3pvpartname = StringHelper.trimRight(c3pvpartname);
            if(c3pvpartname.length()==0) {
                c3pvpartname = null;
            }
        }
        this.c3pvpartname = c3pvpartname;
        this.c3pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件3]
     */
    public String getC3PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC3PVPartName();
        }
        return this.c3pvpartname;
    }

    /**
     *  获取属性值[中间部件3]是否修改
     */
    public boolean isC3PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC3PVPartNameDirty();
        }
        return this.c3pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[中间部件3]
     */
    public void resetC3PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC3PVPartName();
            return;
        }

        this.c3pvpartnameDirtyFlag = false;
        this.c3pvpartname = null;
    }
    /**
     *  设置属性值[中间部件4]
     *  @param c4pvpartctrlid
     */
    public void setC4PVPartCtrlId(String c4pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC4PVPartCtrlId(c4pvpartctrlid);
            return;
        }
        if(c4pvpartctrlid!=null) {
            c4pvpartctrlid = StringHelper.trimRight(c4pvpartctrlid);
            if(c4pvpartctrlid.length()==0) {
                c4pvpartctrlid = null;
            }
        }
        this.c4pvpartctrlid = c4pvpartctrlid;
        this.c4pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件4]
     */
    public String getC4PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC4PVPartCtrlId();
        }
        return this.c4pvpartctrlid;
    }

    /**
     *  获取属性值[中间部件4]是否修改
     */
    public boolean isC4PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC4PVPartCtrlIdDirty();
        }
        return this.c4pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件4]
     */
    public void resetC4PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC4PVPartCtrlId();
            return;
        }

        this.c4pvpartctrlidDirtyFlag = false;
        this.c4pvpartctrlid = null;
    }
    /**
     *  设置属性值[中间部件4]
     *  @param c4pvpartid
     */
    public void setC4PVPartId(String c4pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC4PVPartId(c4pvpartid);
            return;
        }
        if(c4pvpartid!=null) {
            c4pvpartid = StringHelper.trimRight(c4pvpartid);
            if(c4pvpartid.length()==0) {
                c4pvpartid = null;
            }
        }
        this.c4pvpartid = c4pvpartid;
        this.c4pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件4]
     */
    public String getC4PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC4PVPartId();
        }
        return this.c4pvpartid;
    }

    /**
     *  获取属性值[中间部件4]是否修改
     */
    public boolean isC4PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC4PVPartIdDirty();
        }
        return this.c4pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[中间部件4]
     */
    public void resetC4PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC4PVPartId();
            return;
        }

        this.c4pvpartidDirtyFlag = false;
        this.c4pvpartid = null;
    }
    /**
     *  设置属性值[中间部件4]
     *  @param c4pvpartname
     */
    public void setC4PVPartName(String c4pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setC4PVPartName(c4pvpartname);
            return;
        }
        if(c4pvpartname!=null) {
            c4pvpartname = StringHelper.trimRight(c4pvpartname);
            if(c4pvpartname.length()==0) {
                c4pvpartname = null;
            }
        }
        this.c4pvpartname = c4pvpartname;
        this.c4pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[中间部件4]
     */
    public String getC4PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC4PVPartName();
        }
        return this.c4pvpartname;
    }

    /**
     *  获取属性值[中间部件4]是否修改
     */
    public boolean isC4PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isC4PVPartNameDirty();
        }
        return this.c4pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[中间部件4]
     */
    public void resetC4PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetC4PVPartName();
            return;
        }

        this.c4pvpartnameDirtyFlag = false;
        this.c4pvpartname = null;
    }
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
     *  设置属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param issystem
     */
    public void setIsSystem(Integer issystem) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsSystem() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    /**
     *  获取属性值[系统数据]是否修改
     */
    public boolean isIsSystemDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    /**
     *  重置属性值[系统数据]
     */
    public void resetIsSystem() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }

        this.issystemDirtyFlag = false;
        this.issystem = null;
    }
    /**
     *  设置属性值[左侧部件1]
     *  @param l1pvpartctrlid
     */
    public void setL1PVPartCtrlId(String l1pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL1PVPartCtrlId(l1pvpartctrlid);
            return;
        }
        if(l1pvpartctrlid!=null) {
            l1pvpartctrlid = StringHelper.trimRight(l1pvpartctrlid);
            if(l1pvpartctrlid.length()==0) {
                l1pvpartctrlid = null;
            }
        }
        this.l1pvpartctrlid = l1pvpartctrlid;
        this.l1pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件1]
     */
    public String getL1PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL1PVPartCtrlId();
        }
        return this.l1pvpartctrlid;
    }

    /**
     *  获取属性值[左侧部件1]是否修改
     */
    public boolean isL1PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL1PVPartCtrlIdDirty();
        }
        return this.l1pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件1]
     */
    public void resetL1PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL1PVPartCtrlId();
            return;
        }

        this.l1pvpartctrlidDirtyFlag = false;
        this.l1pvpartctrlid = null;
    }
    /**
     *  设置属性值[左侧部件1]
     *  @param l1pvpartid
     */
    public void setL1PVPartId(String l1pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL1PVPartId(l1pvpartid);
            return;
        }
        if(l1pvpartid!=null) {
            l1pvpartid = StringHelper.trimRight(l1pvpartid);
            if(l1pvpartid.length()==0) {
                l1pvpartid = null;
            }
        }
        this.l1pvpartid = l1pvpartid;
        this.l1pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件1]
     */
    public String getL1PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL1PVPartId();
        }
        return this.l1pvpartid;
    }

    /**
     *  获取属性值[左侧部件1]是否修改
     */
    public boolean isL1PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL1PVPartIdDirty();
        }
        return this.l1pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件1]
     */
    public void resetL1PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL1PVPartId();
            return;
        }

        this.l1pvpartidDirtyFlag = false;
        this.l1pvpartid = null;
    }
    /**
     *  设置属性值[左侧部件1]
     *  @param l1pvpartname
     */
    public void setL1PVPartName(String l1pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL1PVPartName(l1pvpartname);
            return;
        }
        if(l1pvpartname!=null) {
            l1pvpartname = StringHelper.trimRight(l1pvpartname);
            if(l1pvpartname.length()==0) {
                l1pvpartname = null;
            }
        }
        this.l1pvpartname = l1pvpartname;
        this.l1pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件1]
     */
    public String getL1PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL1PVPartName();
        }
        return this.l1pvpartname;
    }

    /**
     *  获取属性值[左侧部件1]是否修改
     */
    public boolean isL1PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL1PVPartNameDirty();
        }
        return this.l1pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件1]
     */
    public void resetL1PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL1PVPartName();
            return;
        }

        this.l1pvpartnameDirtyFlag = false;
        this.l1pvpartname = null;
    }
    /**
     *  设置属性值[左侧部件2]
     *  @param l2pvpartctrlid
     */
    public void setL2PVPartCtrlId(String l2pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL2PVPartCtrlId(l2pvpartctrlid);
            return;
        }
        if(l2pvpartctrlid!=null) {
            l2pvpartctrlid = StringHelper.trimRight(l2pvpartctrlid);
            if(l2pvpartctrlid.length()==0) {
                l2pvpartctrlid = null;
            }
        }
        this.l2pvpartctrlid = l2pvpartctrlid;
        this.l2pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件2]
     */
    public String getL2PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL2PVPartCtrlId();
        }
        return this.l2pvpartctrlid;
    }

    /**
     *  获取属性值[左侧部件2]是否修改
     */
    public boolean isL2PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL2PVPartCtrlIdDirty();
        }
        return this.l2pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件2]
     */
    public void resetL2PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL2PVPartCtrlId();
            return;
        }

        this.l2pvpartctrlidDirtyFlag = false;
        this.l2pvpartctrlid = null;
    }
    /**
     *  设置属性值[左侧部件2]
     *  @param l2pvpartid
     */
    public void setL2PVPartId(String l2pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL2PVPartId(l2pvpartid);
            return;
        }
        if(l2pvpartid!=null) {
            l2pvpartid = StringHelper.trimRight(l2pvpartid);
            if(l2pvpartid.length()==0) {
                l2pvpartid = null;
            }
        }
        this.l2pvpartid = l2pvpartid;
        this.l2pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件2]
     */
    public String getL2PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL2PVPartId();
        }
        return this.l2pvpartid;
    }

    /**
     *  获取属性值[左侧部件2]是否修改
     */
    public boolean isL2PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL2PVPartIdDirty();
        }
        return this.l2pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件2]
     */
    public void resetL2PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL2PVPartId();
            return;
        }

        this.l2pvpartidDirtyFlag = false;
        this.l2pvpartid = null;
    }
    /**
     *  设置属性值[左侧部件2]
     *  @param l2pvpartname
     */
    public void setL2PVPartName(String l2pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL2PVPartName(l2pvpartname);
            return;
        }
        if(l2pvpartname!=null) {
            l2pvpartname = StringHelper.trimRight(l2pvpartname);
            if(l2pvpartname.length()==0) {
                l2pvpartname = null;
            }
        }
        this.l2pvpartname = l2pvpartname;
        this.l2pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件2]
     */
    public String getL2PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL2PVPartName();
        }
        return this.l2pvpartname;
    }

    /**
     *  获取属性值[左侧部件2]是否修改
     */
    public boolean isL2PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL2PVPartNameDirty();
        }
        return this.l2pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件2]
     */
    public void resetL2PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL2PVPartName();
            return;
        }

        this.l2pvpartnameDirtyFlag = false;
        this.l2pvpartname = null;
    }
    /**
     *  设置属性值[左侧部件3]
     *  @param l3pvpartctrlid
     */
    public void setL3PVPartCtrlId(String l3pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL3PVPartCtrlId(l3pvpartctrlid);
            return;
        }
        if(l3pvpartctrlid!=null) {
            l3pvpartctrlid = StringHelper.trimRight(l3pvpartctrlid);
            if(l3pvpartctrlid.length()==0) {
                l3pvpartctrlid = null;
            }
        }
        this.l3pvpartctrlid = l3pvpartctrlid;
        this.l3pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件3]
     */
    public String getL3PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL3PVPartCtrlId();
        }
        return this.l3pvpartctrlid;
    }

    /**
     *  获取属性值[左侧部件3]是否修改
     */
    public boolean isL3PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL3PVPartCtrlIdDirty();
        }
        return this.l3pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件3]
     */
    public void resetL3PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL3PVPartCtrlId();
            return;
        }

        this.l3pvpartctrlidDirtyFlag = false;
        this.l3pvpartctrlid = null;
    }
    /**
     *  设置属性值[左侧部件3]
     *  @param l3pvpartid
     */
    public void setL3PVPartId(String l3pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL3PVPartId(l3pvpartid);
            return;
        }
        if(l3pvpartid!=null) {
            l3pvpartid = StringHelper.trimRight(l3pvpartid);
            if(l3pvpartid.length()==0) {
                l3pvpartid = null;
            }
        }
        this.l3pvpartid = l3pvpartid;
        this.l3pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件3]
     */
    public String getL3PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL3PVPartId();
        }
        return this.l3pvpartid;
    }

    /**
     *  获取属性值[左侧部件3]是否修改
     */
    public boolean isL3PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL3PVPartIdDirty();
        }
        return this.l3pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件3]
     */
    public void resetL3PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL3PVPartId();
            return;
        }

        this.l3pvpartidDirtyFlag = false;
        this.l3pvpartid = null;
    }
    /**
     *  设置属性值[左侧部件3]
     *  @param l3pvpartname
     */
    public void setL3PVPartName(String l3pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL3PVPartName(l3pvpartname);
            return;
        }
        if(l3pvpartname!=null) {
            l3pvpartname = StringHelper.trimRight(l3pvpartname);
            if(l3pvpartname.length()==0) {
                l3pvpartname = null;
            }
        }
        this.l3pvpartname = l3pvpartname;
        this.l3pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件3]
     */
    public String getL3PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL3PVPartName();
        }
        return this.l3pvpartname;
    }

    /**
     *  获取属性值[左侧部件3]是否修改
     */
    public boolean isL3PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL3PVPartNameDirty();
        }
        return this.l3pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件3]
     */
    public void resetL3PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL3PVPartName();
            return;
        }

        this.l3pvpartnameDirtyFlag = false;
        this.l3pvpartname = null;
    }
    /**
     *  设置属性值[左侧部件4]
     *  @param l4pvpartctrlid
     */
    public void setL4PVPartCtrlId(String l4pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL4PVPartCtrlId(l4pvpartctrlid);
            return;
        }
        if(l4pvpartctrlid!=null) {
            l4pvpartctrlid = StringHelper.trimRight(l4pvpartctrlid);
            if(l4pvpartctrlid.length()==0) {
                l4pvpartctrlid = null;
            }
        }
        this.l4pvpartctrlid = l4pvpartctrlid;
        this.l4pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件4]
     */
    public String getL4PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL4PVPartCtrlId();
        }
        return this.l4pvpartctrlid;
    }

    /**
     *  获取属性值[左侧部件4]是否修改
     */
    public boolean isL4PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL4PVPartCtrlIdDirty();
        }
        return this.l4pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件4]
     */
    public void resetL4PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL4PVPartCtrlId();
            return;
        }

        this.l4pvpartctrlidDirtyFlag = false;
        this.l4pvpartctrlid = null;
    }
    /**
     *  设置属性值[左侧部件4]
     *  @param l4pvpartid
     */
    public void setL4PVPartId(String l4pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL4PVPartId(l4pvpartid);
            return;
        }
        if(l4pvpartid!=null) {
            l4pvpartid = StringHelper.trimRight(l4pvpartid);
            if(l4pvpartid.length()==0) {
                l4pvpartid = null;
            }
        }
        this.l4pvpartid = l4pvpartid;
        this.l4pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件4]
     */
    public String getL4PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL4PVPartId();
        }
        return this.l4pvpartid;
    }

    /**
     *  获取属性值[左侧部件4]是否修改
     */
    public boolean isL4PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL4PVPartIdDirty();
        }
        return this.l4pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件4]
     */
    public void resetL4PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL4PVPartId();
            return;
        }

        this.l4pvpartidDirtyFlag = false;
        this.l4pvpartid = null;
    }
    /**
     *  设置属性值[左侧部件4]
     *  @param l4pvpartname
     */
    public void setL4PVPartName(String l4pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setL4PVPartName(l4pvpartname);
            return;
        }
        if(l4pvpartname!=null) {
            l4pvpartname = StringHelper.trimRight(l4pvpartname);
            if(l4pvpartname.length()==0) {
                l4pvpartname = null;
            }
        }
        this.l4pvpartname = l4pvpartname;
        this.l4pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[左侧部件4]
     */
    public String getL4PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL4PVPartName();
        }
        return this.l4pvpartname;
    }

    /**
     *  获取属性值[左侧部件4]是否修改
     */
    public boolean isL4PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isL4PVPartNameDirty();
        }
        return this.l4pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[左侧部件4]
     */
    public void resetL4PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetL4PVPartName();
            return;
        }

        this.l4pvpartnameDirtyFlag = false;
        this.l4pvpartname = null;
    }
    /**
     *  设置属性值[所有者]
     *  @param ownerid
     */
    public void setOwnerId(String ownerid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOwnerId(ownerid);
            return;
        }
        if(ownerid!=null) {
            ownerid = StringHelper.trimRight(ownerid);
            if(ownerid.length()==0) {
                ownerid = null;
            }
        }
        this.ownerid = ownerid;
        this.owneridDirtyFlag  = true;
    }

    /**
     *  获取属性值[所有者]
     */
    public String getOwnerId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    /**
     *  获取属性值[所有者]是否修改
     */
    public boolean isOwnerIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    /**
     *  重置属性值[所有者]
     */
    public void resetOwnerId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }

        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }
    /**
     *  设置属性值[门户页面]
     *  @param portalpageid
     */
    public void setPortalPageId(String portalpageid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPortalPageId(portalpageid);
            return;
        }
        if(portalpageid!=null) {
            portalpageid = StringHelper.trimRight(portalpageid);
            if(portalpageid.length()==0) {
                portalpageid = null;
            }
        }
        this.portalpageid = portalpageid;
        this.portalpageidDirtyFlag  = true;
    }

    /**
     *  获取属性值[门户页面]
     */
    public String getPortalPageId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPageId();
        }
        return this.portalpageid;
    }

    /**
     *  获取属性值[门户页面]是否修改
     */
    public boolean isPortalPageIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPortalPageIdDirty();
        }
        return this.portalpageidDirtyFlag;
    }

    /**
     *  重置属性值[门户页面]
     */
    public void resetPortalPageId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPortalPageId();
            return;
        }

        this.portalpageidDirtyFlag = false;
        this.portalpageid = null;
    }
    /**
     *  设置属性值[频道页]
     *  @param portalpagename
     */
    public void setPortalPageName(String portalpagename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPortalPageName(portalpagename);
            return;
        }
        if(portalpagename!=null) {
            portalpagename = StringHelper.trimRight(portalpagename);
            if(portalpagename.length()==0) {
                portalpagename = null;
            }
        }
        this.portalpagename = portalpagename;
        this.portalpagenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[频道页]
     */
    public String getPortalPageName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPageName();
        }
        return this.portalpagename;
    }

    /**
     *  获取属性值[频道页]是否修改
     */
    public boolean isPortalPageNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPortalPageNameDirty();
        }
        return this.portalpagenameDirtyFlag;
    }

    /**
     *  重置属性值[频道页]
     */
    public void resetPortalPageName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPortalPageName();
            return;
        }

        this.portalpagenameDirtyFlag = false;
        this.portalpagename = null;
    }
    /**
     *  设置属性值[页面布局]代码表：net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel
     *  @param ppmodel
     */
    public void setPPModel(String ppmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPPModel(ppmodel);
            return;
        }
        if(ppmodel!=null) {
            ppmodel = StringHelper.trimRight(ppmodel);
            if(ppmodel.length()==0) {
                ppmodel = null;
            }
        }
        this.ppmodel = ppmodel;
        this.ppmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[页面布局]代码表：net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel
     */
    public String getPPModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPPModel();
        }
        return this.ppmodel;
    }

    /**
     *  获取属性值[页面布局]是否修改
     */
    public boolean isPPModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPPModelDirty();
        }
        return this.ppmodelDirtyFlag;
    }

    /**
     *  重置属性值[页面布局]
     */
    public void resetPPModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPPModel();
            return;
        }

        this.ppmodelDirtyFlag = false;
        this.ppmodel = null;
    }
    /**
     *  设置属性值[模型明细]
     *  @param ppmodeldetail
     */
    public void setPPModelDetail(String ppmodeldetail) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPPModelDetail(ppmodeldetail);
            return;
        }
        if(ppmodeldetail!=null) {
            ppmodeldetail = StringHelper.trimRight(ppmodeldetail);
            if(ppmodeldetail.length()==0) {
                ppmodeldetail = null;
            }
        }
        this.ppmodeldetail = ppmodeldetail;
        this.ppmodeldetailDirtyFlag  = true;
    }

    /**
     *  获取属性值[模型明细]
     */
    public String getPPModelDetail() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPPModelDetail();
        }
        return this.ppmodeldetail;
    }

    /**
     *  获取属性值[模型明细]是否修改
     */
    public boolean isPPModelDetailDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPPModelDetailDirty();
        }
        return this.ppmodeldetailDirtyFlag;
    }

    /**
     *  重置属性值[模型明细]
     */
    public void resetPPModelDetail() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPPModelDetail();
            return;
        }

        this.ppmodeldetailDirtyFlag = false;
        this.ppmodeldetail = null;
    }
    /**
     *  设置属性值[用户频道页标识]
     *  @param ppmodelid
     */
    public void setPPModelId(String ppmodelid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPPModelId(ppmodelid);
            return;
        }
        if(ppmodelid!=null) {
            ppmodelid = StringHelper.trimRight(ppmodelid);
            if(ppmodelid.length()==0) {
                ppmodelid = null;
            }
        }
        this.ppmodelid = ppmodelid;
        this.ppmodelidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户频道页标识]
     */
    public String getPPModelId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPPModelId();
        }
        return this.ppmodelid;
    }

    /**
     *  获取属性值[用户频道页标识]是否修改
     */
    public boolean isPPModelIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPPModelIdDirty();
        }
        return this.ppmodelidDirtyFlag;
    }

    /**
     *  重置属性值[用户频道页标识]
     */
    public void resetPPModelId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPPModelId();
            return;
        }

        this.ppmodelidDirtyFlag = false;
        this.ppmodelid = null;
    }
    /**
     *  设置属性值[用户频道页名称]
     *  @param ppmodelname
     */
    public void setPPModelName(String ppmodelname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPPModelName(ppmodelname);
            return;
        }
        if(ppmodelname!=null) {
            ppmodelname = StringHelper.trimRight(ppmodelname);
            if(ppmodelname.length()==0) {
                ppmodelname = null;
            }
        }
        this.ppmodelname = ppmodelname;
        this.ppmodelnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户频道页名称]
     */
    public String getPPModelName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPPModelName();
        }
        return this.ppmodelname;
    }

    /**
     *  获取属性值[用户频道页名称]是否修改
     */
    public boolean isPPModelNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPPModelNameDirty();
        }
        return this.ppmodelnameDirtyFlag;
    }

    /**
     *  重置属性值[用户频道页名称]
     */
    public void resetPPModelName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPPModelName();
            return;
        }

        this.ppmodelnameDirtyFlag = false;
        this.ppmodelname = null;
    }
    /**
     *  设置属性值[版本]
     *  @param ppmversion
     */
    public void setPPMVersion(Integer ppmversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPPMVersion(ppmversion);
            return;
        }
        this.ppmversion = ppmversion;
        this.ppmversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getPPMVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPPMVersion();
        }
        return this.ppmversion;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isPPMVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPPMVersionDirty();
        }
        return this.ppmversionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetPPMVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPPMVersion();
            return;
        }

        this.ppmversionDirtyFlag = false;
        this.ppmversion = null;
    }
    /**
     *  设置属性值[右侧部件1]
     *  @param r1pvpartctrlid
     */
    public void setR1PVPartCtrlId(String r1pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR1PVPartCtrlId(r1pvpartctrlid);
            return;
        }
        if(r1pvpartctrlid!=null) {
            r1pvpartctrlid = StringHelper.trimRight(r1pvpartctrlid);
            if(r1pvpartctrlid.length()==0) {
                r1pvpartctrlid = null;
            }
        }
        this.r1pvpartctrlid = r1pvpartctrlid;
        this.r1pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件1]
     */
    public String getR1PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR1PVPartCtrlId();
        }
        return this.r1pvpartctrlid;
    }

    /**
     *  获取属性值[右侧部件1]是否修改
     */
    public boolean isR1PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR1PVPartCtrlIdDirty();
        }
        return this.r1pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件1]
     */
    public void resetR1PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR1PVPartCtrlId();
            return;
        }

        this.r1pvpartctrlidDirtyFlag = false;
        this.r1pvpartctrlid = null;
    }
    /**
     *  设置属性值[右侧部件1]
     *  @param r1pvpartid
     */
    public void setR1PVPartId(String r1pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR1PVPartId(r1pvpartid);
            return;
        }
        if(r1pvpartid!=null) {
            r1pvpartid = StringHelper.trimRight(r1pvpartid);
            if(r1pvpartid.length()==0) {
                r1pvpartid = null;
            }
        }
        this.r1pvpartid = r1pvpartid;
        this.r1pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件1]
     */
    public String getR1PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR1PVPartId();
        }
        return this.r1pvpartid;
    }

    /**
     *  获取属性值[右侧部件1]是否修改
     */
    public boolean isR1PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR1PVPartIdDirty();
        }
        return this.r1pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件1]
     */
    public void resetR1PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR1PVPartId();
            return;
        }

        this.r1pvpartidDirtyFlag = false;
        this.r1pvpartid = null;
    }
    /**
     *  设置属性值[右侧部件1]
     *  @param r1pvpartname
     */
    public void setR1PVPartName(String r1pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR1PVPartName(r1pvpartname);
            return;
        }
        if(r1pvpartname!=null) {
            r1pvpartname = StringHelper.trimRight(r1pvpartname);
            if(r1pvpartname.length()==0) {
                r1pvpartname = null;
            }
        }
        this.r1pvpartname = r1pvpartname;
        this.r1pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件1]
     */
    public String getR1PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR1PVPartName();
        }
        return this.r1pvpartname;
    }

    /**
     *  获取属性值[右侧部件1]是否修改
     */
    public boolean isR1PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR1PVPartNameDirty();
        }
        return this.r1pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件1]
     */
    public void resetR1PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR1PVPartName();
            return;
        }

        this.r1pvpartnameDirtyFlag = false;
        this.r1pvpartname = null;
    }
    /**
     *  设置属性值[右侧部件2]
     *  @param r2pvpartctrlid
     */
    public void setR2PVPartCtrlId(String r2pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR2PVPartCtrlId(r2pvpartctrlid);
            return;
        }
        if(r2pvpartctrlid!=null) {
            r2pvpartctrlid = StringHelper.trimRight(r2pvpartctrlid);
            if(r2pvpartctrlid.length()==0) {
                r2pvpartctrlid = null;
            }
        }
        this.r2pvpartctrlid = r2pvpartctrlid;
        this.r2pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件2]
     */
    public String getR2PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR2PVPartCtrlId();
        }
        return this.r2pvpartctrlid;
    }

    /**
     *  获取属性值[右侧部件2]是否修改
     */
    public boolean isR2PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR2PVPartCtrlIdDirty();
        }
        return this.r2pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件2]
     */
    public void resetR2PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR2PVPartCtrlId();
            return;
        }

        this.r2pvpartctrlidDirtyFlag = false;
        this.r2pvpartctrlid = null;
    }
    /**
     *  设置属性值[右侧部件2]
     *  @param r2pvpartid
     */
    public void setR2PVPartId(String r2pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR2PVPartId(r2pvpartid);
            return;
        }
        if(r2pvpartid!=null) {
            r2pvpartid = StringHelper.trimRight(r2pvpartid);
            if(r2pvpartid.length()==0) {
                r2pvpartid = null;
            }
        }
        this.r2pvpartid = r2pvpartid;
        this.r2pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件2]
     */
    public String getR2PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR2PVPartId();
        }
        return this.r2pvpartid;
    }

    /**
     *  获取属性值[右侧部件2]是否修改
     */
    public boolean isR2PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR2PVPartIdDirty();
        }
        return this.r2pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件2]
     */
    public void resetR2PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR2PVPartId();
            return;
        }

        this.r2pvpartidDirtyFlag = false;
        this.r2pvpartid = null;
    }
    /**
     *  设置属性值[右侧部件2]
     *  @param r2pvpartname
     */
    public void setR2PVPartName(String r2pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR2PVPartName(r2pvpartname);
            return;
        }
        if(r2pvpartname!=null) {
            r2pvpartname = StringHelper.trimRight(r2pvpartname);
            if(r2pvpartname.length()==0) {
                r2pvpartname = null;
            }
        }
        this.r2pvpartname = r2pvpartname;
        this.r2pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件2]
     */
    public String getR2PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR2PVPartName();
        }
        return this.r2pvpartname;
    }

    /**
     *  获取属性值[右侧部件2]是否修改
     */
    public boolean isR2PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR2PVPartNameDirty();
        }
        return this.r2pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件2]
     */
    public void resetR2PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR2PVPartName();
            return;
        }

        this.r2pvpartnameDirtyFlag = false;
        this.r2pvpartname = null;
    }
    /**
     *  设置属性值[右侧部件3]
     *  @param r3pvpartctrlid
     */
    public void setR3PVPartCtrlId(String r3pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR3PVPartCtrlId(r3pvpartctrlid);
            return;
        }
        if(r3pvpartctrlid!=null) {
            r3pvpartctrlid = StringHelper.trimRight(r3pvpartctrlid);
            if(r3pvpartctrlid.length()==0) {
                r3pvpartctrlid = null;
            }
        }
        this.r3pvpartctrlid = r3pvpartctrlid;
        this.r3pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件3]
     */
    public String getR3PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR3PVPartCtrlId();
        }
        return this.r3pvpartctrlid;
    }

    /**
     *  获取属性值[右侧部件3]是否修改
     */
    public boolean isR3PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR3PVPartCtrlIdDirty();
        }
        return this.r3pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件3]
     */
    public void resetR3PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR3PVPartCtrlId();
            return;
        }

        this.r3pvpartctrlidDirtyFlag = false;
        this.r3pvpartctrlid = null;
    }
    /**
     *  设置属性值[右侧部件3]
     *  @param r3pvpartid
     */
    public void setR3PVPartId(String r3pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR3PVPartId(r3pvpartid);
            return;
        }
        if(r3pvpartid!=null) {
            r3pvpartid = StringHelper.trimRight(r3pvpartid);
            if(r3pvpartid.length()==0) {
                r3pvpartid = null;
            }
        }
        this.r3pvpartid = r3pvpartid;
        this.r3pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件3]
     */
    public String getR3PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR3PVPartId();
        }
        return this.r3pvpartid;
    }

    /**
     *  获取属性值[右侧部件3]是否修改
     */
    public boolean isR3PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR3PVPartIdDirty();
        }
        return this.r3pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件3]
     */
    public void resetR3PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR3PVPartId();
            return;
        }

        this.r3pvpartidDirtyFlag = false;
        this.r3pvpartid = null;
    }
    /**
     *  设置属性值[右侧部件3]
     *  @param r3pvpartname
     */
    public void setR3PVPartName(String r3pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR3PVPartName(r3pvpartname);
            return;
        }
        if(r3pvpartname!=null) {
            r3pvpartname = StringHelper.trimRight(r3pvpartname);
            if(r3pvpartname.length()==0) {
                r3pvpartname = null;
            }
        }
        this.r3pvpartname = r3pvpartname;
        this.r3pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件3]
     */
    public String getR3PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR3PVPartName();
        }
        return this.r3pvpartname;
    }

    /**
     *  获取属性值[右侧部件3]是否修改
     */
    public boolean isR3PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR3PVPartNameDirty();
        }
        return this.r3pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件3]
     */
    public void resetR3PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR3PVPartName();
            return;
        }

        this.r3pvpartnameDirtyFlag = false;
        this.r3pvpartname = null;
    }
    /**
     *  设置属性值[右侧部件4]
     *  @param r4pvpartctrlid
     */
    public void setR4PVPartCtrlId(String r4pvpartctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR4PVPartCtrlId(r4pvpartctrlid);
            return;
        }
        if(r4pvpartctrlid!=null) {
            r4pvpartctrlid = StringHelper.trimRight(r4pvpartctrlid);
            if(r4pvpartctrlid.length()==0) {
                r4pvpartctrlid = null;
            }
        }
        this.r4pvpartctrlid = r4pvpartctrlid;
        this.r4pvpartctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件4]
     */
    public String getR4PVPartCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR4PVPartCtrlId();
        }
        return this.r4pvpartctrlid;
    }

    /**
     *  获取属性值[右侧部件4]是否修改
     */
    public boolean isR4PVPartCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR4PVPartCtrlIdDirty();
        }
        return this.r4pvpartctrlidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件4]
     */
    public void resetR4PVPartCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR4PVPartCtrlId();
            return;
        }

        this.r4pvpartctrlidDirtyFlag = false;
        this.r4pvpartctrlid = null;
    }
    /**
     *  设置属性值[右侧部件4]
     *  @param r4pvpartid
     */
    public void setR4PVPartId(String r4pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR4PVPartId(r4pvpartid);
            return;
        }
        if(r4pvpartid!=null) {
            r4pvpartid = StringHelper.trimRight(r4pvpartid);
            if(r4pvpartid.length()==0) {
                r4pvpartid = null;
            }
        }
        this.r4pvpartid = r4pvpartid;
        this.r4pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件4]
     */
    public String getR4PVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR4PVPartId();
        }
        return this.r4pvpartid;
    }

    /**
     *  获取属性值[右侧部件4]是否修改
     */
    public boolean isR4PVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR4PVPartIdDirty();
        }
        return this.r4pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件4]
     */
    public void resetR4PVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR4PVPartId();
            return;
        }

        this.r4pvpartidDirtyFlag = false;
        this.r4pvpartid = null;
    }
    /**
     *  设置属性值[右侧部件4]
     *  @param r4pvpartname
     */
    public void setR4PVPartName(String r4pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setR4PVPartName(r4pvpartname);
            return;
        }
        if(r4pvpartname!=null) {
            r4pvpartname = StringHelper.trimRight(r4pvpartname);
            if(r4pvpartname.length()==0) {
                r4pvpartname = null;
            }
        }
        this.r4pvpartname = r4pvpartname;
        this.r4pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[右侧部件4]
     */
    public String getR4PVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR4PVPartName();
        }
        return this.r4pvpartname;
    }

    /**
     *  获取属性值[右侧部件4]是否修改
     */
    public boolean isR4PVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isR4PVPartNameDirty();
        }
        return this.r4pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[右侧部件4]
     */
    public void resetR4PVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetR4PVPartName();
            return;
        }

        this.r4pvpartnameDirtyFlag = false;
        this.r4pvpartname = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        PPModelBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PPModelBase et) {
        et.resetC1PVPartCtrlId();
        et.resetC1PVPartId();
        et.resetC1PVPartName();
        et.resetC2PVPartCtrlId();
        et.resetC2PVPartId();
        et.resetC2PVPartName();
        et.resetC3PVPartCtrlId();
        et.resetC3PVPartId();
        et.resetC3PVPartName();
        et.resetC4PVPartCtrlId();
        et.resetC4PVPartId();
        et.resetC4PVPartName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsSystem();
        et.resetL1PVPartCtrlId();
        et.resetL1PVPartId();
        et.resetL1PVPartName();
        et.resetL2PVPartCtrlId();
        et.resetL2PVPartId();
        et.resetL2PVPartName();
        et.resetL3PVPartCtrlId();
        et.resetL3PVPartId();
        et.resetL3PVPartName();
        et.resetL4PVPartCtrlId();
        et.resetL4PVPartId();
        et.resetL4PVPartName();
        et.resetOwnerId();
        et.resetPortalPageId();
        et.resetPortalPageName();
        et.resetPPModel();
        et.resetPPModelDetail();
        et.resetPPModelId();
        et.resetPPModelName();
        et.resetPPMVersion();
        et.resetR1PVPartCtrlId();
        et.resetR1PVPartId();
        et.resetR1PVPartName();
        et.resetR2PVPartCtrlId();
        et.resetR2PVPartId();
        et.resetR2PVPartName();
        et.resetR3PVPartCtrlId();
        et.resetR3PVPartId();
        et.resetR3PVPartName();
        et.resetR4PVPartCtrlId();
        et.resetR4PVPartId();
        et.resetR4PVPartName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isC1PVPartCtrlIdDirty()) {
            params.put(FIELD_C1PVPARTCTRLID,getC1PVPartCtrlId());
        }
        if(!bDirtyOnly || isC1PVPartIdDirty()) {
            params.put(FIELD_C1PVPARTID,getC1PVPartId());
        }
        if(!bDirtyOnly || isC1PVPartNameDirty()) {
            params.put(FIELD_C1PVPARTNAME,getC1PVPartName());
        }
        if(!bDirtyOnly || isC2PVPartCtrlIdDirty()) {
            params.put(FIELD_C2PVPARTCTRLID,getC2PVPartCtrlId());
        }
        if(!bDirtyOnly || isC2PVPartIdDirty()) {
            params.put(FIELD_C2PVPARTID,getC2PVPartId());
        }
        if(!bDirtyOnly || isC2PVPartNameDirty()) {
            params.put(FIELD_C2PVPARTNAME,getC2PVPartName());
        }
        if(!bDirtyOnly || isC3PVPartCtrlIdDirty()) {
            params.put(FIELD_C3PVPARTCTRLID,getC3PVPartCtrlId());
        }
        if(!bDirtyOnly || isC3PVPartIdDirty()) {
            params.put(FIELD_C3PVPARTID,getC3PVPartId());
        }
        if(!bDirtyOnly || isC3PVPartNameDirty()) {
            params.put(FIELD_C3PVPARTNAME,getC3PVPartName());
        }
        if(!bDirtyOnly || isC4PVPartCtrlIdDirty()) {
            params.put(FIELD_C4PVPARTCTRLID,getC4PVPartCtrlId());
        }
        if(!bDirtyOnly || isC4PVPartIdDirty()) {
            params.put(FIELD_C4PVPARTID,getC4PVPartId());
        }
        if(!bDirtyOnly || isC4PVPartNameDirty()) {
            params.put(FIELD_C4PVPARTNAME,getC4PVPartName());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM,getIsSystem());
        }
        if(!bDirtyOnly || isL1PVPartCtrlIdDirty()) {
            params.put(FIELD_L1PVPARTCTRLID,getL1PVPartCtrlId());
        }
        if(!bDirtyOnly || isL1PVPartIdDirty()) {
            params.put(FIELD_L1PVPARTID,getL1PVPartId());
        }
        if(!bDirtyOnly || isL1PVPartNameDirty()) {
            params.put(FIELD_L1PVPARTNAME,getL1PVPartName());
        }
        if(!bDirtyOnly || isL2PVPartCtrlIdDirty()) {
            params.put(FIELD_L2PVPARTCTRLID,getL2PVPartCtrlId());
        }
        if(!bDirtyOnly || isL2PVPartIdDirty()) {
            params.put(FIELD_L2PVPARTID,getL2PVPartId());
        }
        if(!bDirtyOnly || isL2PVPartNameDirty()) {
            params.put(FIELD_L2PVPARTNAME,getL2PVPartName());
        }
        if(!bDirtyOnly || isL3PVPartCtrlIdDirty()) {
            params.put(FIELD_L3PVPARTCTRLID,getL3PVPartCtrlId());
        }
        if(!bDirtyOnly || isL3PVPartIdDirty()) {
            params.put(FIELD_L3PVPARTID,getL3PVPartId());
        }
        if(!bDirtyOnly || isL3PVPartNameDirty()) {
            params.put(FIELD_L3PVPARTNAME,getL3PVPartName());
        }
        if(!bDirtyOnly || isL4PVPartCtrlIdDirty()) {
            params.put(FIELD_L4PVPARTCTRLID,getL4PVPartCtrlId());
        }
        if(!bDirtyOnly || isL4PVPartIdDirty()) {
            params.put(FIELD_L4PVPARTID,getL4PVPartId());
        }
        if(!bDirtyOnly || isL4PVPartNameDirty()) {
            params.put(FIELD_L4PVPARTNAME,getL4PVPartName());
        }
        if(!bDirtyOnly || isOwnerIdDirty()) {
            params.put(FIELD_OWNERID,getOwnerId());
        }
        if(!bDirtyOnly || isPortalPageIdDirty()) {
            params.put(FIELD_PORTALPAGEID,getPortalPageId());
        }
        if(!bDirtyOnly || isPortalPageNameDirty()) {
            params.put(FIELD_PORTALPAGENAME,getPortalPageName());
        }
        if(!bDirtyOnly || isPPModelDirty()) {
            params.put(FIELD_PPMODEL,getPPModel());
        }
        if(!bDirtyOnly || isPPModelDetailDirty()) {
            params.put(FIELD_PPMODELDETAIL,getPPModelDetail());
        }
        if(!bDirtyOnly || isPPModelIdDirty()) {
            params.put(FIELD_PPMODELID,getPPModelId());
        }
        if(!bDirtyOnly || isPPModelNameDirty()) {
            params.put(FIELD_PPMODELNAME,getPPModelName());
        }
        if(!bDirtyOnly || isPPMVersionDirty()) {
            params.put(FIELD_PPMVERSION,getPPMVersion());
        }
        if(!bDirtyOnly || isR1PVPartCtrlIdDirty()) {
            params.put(FIELD_R1PVPARTCTRLID,getR1PVPartCtrlId());
        }
        if(!bDirtyOnly || isR1PVPartIdDirty()) {
            params.put(FIELD_R1PVPARTID,getR1PVPartId());
        }
        if(!bDirtyOnly || isR1PVPartNameDirty()) {
            params.put(FIELD_R1PVPARTNAME,getR1PVPartName());
        }
        if(!bDirtyOnly || isR2PVPartCtrlIdDirty()) {
            params.put(FIELD_R2PVPARTCTRLID,getR2PVPartCtrlId());
        }
        if(!bDirtyOnly || isR2PVPartIdDirty()) {
            params.put(FIELD_R2PVPARTID,getR2PVPartId());
        }
        if(!bDirtyOnly || isR2PVPartNameDirty()) {
            params.put(FIELD_R2PVPARTNAME,getR2PVPartName());
        }
        if(!bDirtyOnly || isR3PVPartCtrlIdDirty()) {
            params.put(FIELD_R3PVPARTCTRLID,getR3PVPartCtrlId());
        }
        if(!bDirtyOnly || isR3PVPartIdDirty()) {
            params.put(FIELD_R3PVPARTID,getR3PVPartId());
        }
        if(!bDirtyOnly || isR3PVPartNameDirty()) {
            params.put(FIELD_R3PVPARTNAME,getR3PVPartName());
        }
        if(!bDirtyOnly || isR4PVPartCtrlIdDirty()) {
            params.put(FIELD_R4PVPARTCTRLID,getR4PVPartCtrlId());
        }
        if(!bDirtyOnly || isR4PVPartIdDirty()) {
            params.put(FIELD_R4PVPARTID,getR4PVPartId());
        }
        if(!bDirtyOnly || isR4PVPartNameDirty()) {
            params.put(FIELD_R4PVPARTNAME,getR4PVPartName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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

        return  PPModelBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PPModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_C1PVPARTCTRLID:
            return et.getC1PVPartCtrlId();
        case INDEX_C1PVPARTID:
            return et.getC1PVPartId();
        case INDEX_C1PVPARTNAME:
            return et.getC1PVPartName();
        case INDEX_C2PVPARTCTRLID:
            return et.getC2PVPartCtrlId();
        case INDEX_C2PVPARTID:
            return et.getC2PVPartId();
        case INDEX_C2PVPARTNAME:
            return et.getC2PVPartName();
        case INDEX_C3PVPARTCTRLID:
            return et.getC3PVPartCtrlId();
        case INDEX_C3PVPARTID:
            return et.getC3PVPartId();
        case INDEX_C3PVPARTNAME:
            return et.getC3PVPartName();
        case INDEX_C4PVPARTCTRLID:
            return et.getC4PVPartCtrlId();
        case INDEX_C4PVPARTID:
            return et.getC4PVPartId();
        case INDEX_C4PVPARTNAME:
            return et.getC4PVPartName();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ISSYSTEM:
            return et.getIsSystem();
        case INDEX_L1PVPARTCTRLID:
            return et.getL1PVPartCtrlId();
        case INDEX_L1PVPARTID:
            return et.getL1PVPartId();
        case INDEX_L1PVPARTNAME:
            return et.getL1PVPartName();
        case INDEX_L2PVPARTCTRLID:
            return et.getL2PVPartCtrlId();
        case INDEX_L2PVPARTID:
            return et.getL2PVPartId();
        case INDEX_L2PVPARTNAME:
            return et.getL2PVPartName();
        case INDEX_L3PVPARTCTRLID:
            return et.getL3PVPartCtrlId();
        case INDEX_L3PVPARTID:
            return et.getL3PVPartId();
        case INDEX_L3PVPARTNAME:
            return et.getL3PVPartName();
        case INDEX_L4PVPARTCTRLID:
            return et.getL4PVPartCtrlId();
        case INDEX_L4PVPARTID:
            return et.getL4PVPartId();
        case INDEX_L4PVPARTNAME:
            return et.getL4PVPartName();
        case INDEX_OWNERID:
            return et.getOwnerId();
        case INDEX_PORTALPAGEID:
            return et.getPortalPageId();
        case INDEX_PORTALPAGENAME:
            return et.getPortalPageName();
        case INDEX_PPMODEL:
            return et.getPPModel();
        case INDEX_PPMODELDETAIL:
            return et.getPPModelDetail();
        case INDEX_PPMODELID:
            return et.getPPModelId();
        case INDEX_PPMODELNAME:
            return et.getPPModelName();
        case INDEX_PPMVERSION:
            return et.getPPMVersion();
        case INDEX_R1PVPARTCTRLID:
            return et.getR1PVPartCtrlId();
        case INDEX_R1PVPARTID:
            return et.getR1PVPartId();
        case INDEX_R1PVPARTNAME:
            return et.getR1PVPartName();
        case INDEX_R2PVPARTCTRLID:
            return et.getR2PVPartCtrlId();
        case INDEX_R2PVPARTID:
            return et.getR2PVPartId();
        case INDEX_R2PVPARTNAME:
            return et.getR2PVPartName();
        case INDEX_R3PVPARTCTRLID:
            return et.getR3PVPartCtrlId();
        case INDEX_R3PVPARTID:
            return et.getR3PVPartId();
        case INDEX_R3PVPARTNAME:
            return et.getR3PVPartName();
        case INDEX_R4PVPARTCTRLID:
            return et.getR4PVPartCtrlId();
        case INDEX_R4PVPARTID:
            return et.getR4PVPartId();
        case INDEX_R4PVPARTNAME:
            return et.getR4PVPartName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
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

        PPModelBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(PPModelBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_C1PVPARTCTRLID:
            et.setC1PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C1PVPARTID:
            et.setC1PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C1PVPARTNAME:
            et.setC1PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_C2PVPARTCTRLID:
            et.setC2PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C2PVPARTID:
            et.setC2PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C2PVPARTNAME:
            et.setC2PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_C3PVPARTCTRLID:
            et.setC3PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C3PVPARTID:
            et.setC3PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C3PVPARTNAME:
            et.setC3PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_C4PVPARTCTRLID:
            et.setC4PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C4PVPARTID:
            et.setC4PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_C4PVPARTNAME:
            et.setC4PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISSYSTEM:
            et.setIsSystem(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_L1PVPARTCTRLID:
            et.setL1PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L1PVPARTID:
            et.setL1PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L1PVPARTNAME:
            et.setL1PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_L2PVPARTCTRLID:
            et.setL2PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L2PVPARTID:
            et.setL2PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L2PVPARTNAME:
            et.setL2PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_L3PVPARTCTRLID:
            et.setL3PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L3PVPARTID:
            et.setL3PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L3PVPARTNAME:
            et.setL3PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_L4PVPARTCTRLID:
            et.setL4PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L4PVPARTID:
            et.setL4PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_L4PVPARTNAME:
            et.setL4PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_OWNERID:
            et.setOwnerId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PORTALPAGEID:
            et.setPortalPageId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PORTALPAGENAME:
            et.setPortalPageName(DataObject.getStringValue(obj));
            return ;
        case INDEX_PPMODEL:
            et.setPPModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_PPMODELDETAIL:
            et.setPPModelDetail(DataObject.getStringValue(obj));
            return ;
        case INDEX_PPMODELID:
            et.setPPModelId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PPMODELNAME:
            et.setPPModelName(DataObject.getStringValue(obj));
            return ;
        case INDEX_PPMVERSION:
            et.setPPMVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_R1PVPARTCTRLID:
            et.setR1PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R1PVPARTID:
            et.setR1PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R1PVPARTNAME:
            et.setR1PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_R2PVPARTCTRLID:
            et.setR2PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R2PVPARTID:
            et.setR2PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R2PVPARTNAME:
            et.setR2PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_R3PVPARTCTRLID:
            et.setR3PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R3PVPARTID:
            et.setR3PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R3PVPARTNAME:
            et.setR3PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_R4PVPARTCTRLID:
            et.setR4PVPartCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R4PVPARTID:
            et.setR4PVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_R4PVPARTNAME:
            et.setR4PVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
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

        return  PPModelBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(PPModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_C1PVPARTCTRLID:
            return et.getC1PVPartCtrlId()==null;
        case INDEX_C1PVPARTID:
            return et.getC1PVPartId()==null;
        case INDEX_C1PVPARTNAME:
            return et.getC1PVPartName()==null;
        case INDEX_C2PVPARTCTRLID:
            return et.getC2PVPartCtrlId()==null;
        case INDEX_C2PVPARTID:
            return et.getC2PVPartId()==null;
        case INDEX_C2PVPARTNAME:
            return et.getC2PVPartName()==null;
        case INDEX_C3PVPARTCTRLID:
            return et.getC3PVPartCtrlId()==null;
        case INDEX_C3PVPARTID:
            return et.getC3PVPartId()==null;
        case INDEX_C3PVPARTNAME:
            return et.getC3PVPartName()==null;
        case INDEX_C4PVPARTCTRLID:
            return et.getC4PVPartCtrlId()==null;
        case INDEX_C4PVPARTID:
            return et.getC4PVPartId()==null;
        case INDEX_C4PVPARTNAME:
            return et.getC4PVPartName()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ISSYSTEM:
            return et.getIsSystem()==null;
        case INDEX_L1PVPARTCTRLID:
            return et.getL1PVPartCtrlId()==null;
        case INDEX_L1PVPARTID:
            return et.getL1PVPartId()==null;
        case INDEX_L1PVPARTNAME:
            return et.getL1PVPartName()==null;
        case INDEX_L2PVPARTCTRLID:
            return et.getL2PVPartCtrlId()==null;
        case INDEX_L2PVPARTID:
            return et.getL2PVPartId()==null;
        case INDEX_L2PVPARTNAME:
            return et.getL2PVPartName()==null;
        case INDEX_L3PVPARTCTRLID:
            return et.getL3PVPartCtrlId()==null;
        case INDEX_L3PVPARTID:
            return et.getL3PVPartId()==null;
        case INDEX_L3PVPARTNAME:
            return et.getL3PVPartName()==null;
        case INDEX_L4PVPARTCTRLID:
            return et.getL4PVPartCtrlId()==null;
        case INDEX_L4PVPARTID:
            return et.getL4PVPartId()==null;
        case INDEX_L4PVPARTNAME:
            return et.getL4PVPartName()==null;
        case INDEX_OWNERID:
            return et.getOwnerId()==null;
        case INDEX_PORTALPAGEID:
            return et.getPortalPageId()==null;
        case INDEX_PORTALPAGENAME:
            return et.getPortalPageName()==null;
        case INDEX_PPMODEL:
            return et.getPPModel()==null;
        case INDEX_PPMODELDETAIL:
            return et.getPPModelDetail()==null;
        case INDEX_PPMODELID:
            return et.getPPModelId()==null;
        case INDEX_PPMODELNAME:
            return et.getPPModelName()==null;
        case INDEX_PPMVERSION:
            return et.getPPMVersion()==null;
        case INDEX_R1PVPARTCTRLID:
            return et.getR1PVPartCtrlId()==null;
        case INDEX_R1PVPARTID:
            return et.getR1PVPartId()==null;
        case INDEX_R1PVPARTNAME:
            return et.getR1PVPartName()==null;
        case INDEX_R2PVPARTCTRLID:
            return et.getR2PVPartCtrlId()==null;
        case INDEX_R2PVPARTID:
            return et.getR2PVPartId()==null;
        case INDEX_R2PVPARTNAME:
            return et.getR2PVPartName()==null;
        case INDEX_R3PVPARTCTRLID:
            return et.getR3PVPartCtrlId()==null;
        case INDEX_R3PVPARTID:
            return et.getR3PVPartId()==null;
        case INDEX_R3PVPARTNAME:
            return et.getR3PVPartName()==null;
        case INDEX_R4PVPARTCTRLID:
            return et.getR4PVPartCtrlId()==null;
        case INDEX_R4PVPARTID:
            return et.getR4PVPartId()==null;
        case INDEX_R4PVPARTNAME:
            return et.getR4PVPartName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
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
        return  PPModelBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(PPModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_C1PVPARTCTRLID:
            return et.isC1PVPartCtrlIdDirty();
        case INDEX_C1PVPARTID:
            return et.isC1PVPartIdDirty();
        case INDEX_C1PVPARTNAME:
            return et.isC1PVPartNameDirty();
        case INDEX_C2PVPARTCTRLID:
            return et.isC2PVPartCtrlIdDirty();
        case INDEX_C2PVPARTID:
            return et.isC2PVPartIdDirty();
        case INDEX_C2PVPARTNAME:
            return et.isC2PVPartNameDirty();
        case INDEX_C3PVPARTCTRLID:
            return et.isC3PVPartCtrlIdDirty();
        case INDEX_C3PVPARTID:
            return et.isC3PVPartIdDirty();
        case INDEX_C3PVPARTNAME:
            return et.isC3PVPartNameDirty();
        case INDEX_C4PVPARTCTRLID:
            return et.isC4PVPartCtrlIdDirty();
        case INDEX_C4PVPARTID:
            return et.isC4PVPartIdDirty();
        case INDEX_C4PVPARTNAME:
            return et.isC4PVPartNameDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ISSYSTEM:
            return et.isIsSystemDirty();
        case INDEX_L1PVPARTCTRLID:
            return et.isL1PVPartCtrlIdDirty();
        case INDEX_L1PVPARTID:
            return et.isL1PVPartIdDirty();
        case INDEX_L1PVPARTNAME:
            return et.isL1PVPartNameDirty();
        case INDEX_L2PVPARTCTRLID:
            return et.isL2PVPartCtrlIdDirty();
        case INDEX_L2PVPARTID:
            return et.isL2PVPartIdDirty();
        case INDEX_L2PVPARTNAME:
            return et.isL2PVPartNameDirty();
        case INDEX_L3PVPARTCTRLID:
            return et.isL3PVPartCtrlIdDirty();
        case INDEX_L3PVPARTID:
            return et.isL3PVPartIdDirty();
        case INDEX_L3PVPARTNAME:
            return et.isL3PVPartNameDirty();
        case INDEX_L4PVPARTCTRLID:
            return et.isL4PVPartCtrlIdDirty();
        case INDEX_L4PVPARTID:
            return et.isL4PVPartIdDirty();
        case INDEX_L4PVPARTNAME:
            return et.isL4PVPartNameDirty();
        case INDEX_OWNERID:
            return et.isOwnerIdDirty();
        case INDEX_PORTALPAGEID:
            return et.isPortalPageIdDirty();
        case INDEX_PORTALPAGENAME:
            return et.isPortalPageNameDirty();
        case INDEX_PPMODEL:
            return et.isPPModelDirty();
        case INDEX_PPMODELDETAIL:
            return et.isPPModelDetailDirty();
        case INDEX_PPMODELID:
            return et.isPPModelIdDirty();
        case INDEX_PPMODELNAME:
            return et.isPPModelNameDirty();
        case INDEX_PPMVERSION:
            return et.isPPMVersionDirty();
        case INDEX_R1PVPARTCTRLID:
            return et.isR1PVPartCtrlIdDirty();
        case INDEX_R1PVPARTID:
            return et.isR1PVPartIdDirty();
        case INDEX_R1PVPARTNAME:
            return et.isR1PVPartNameDirty();
        case INDEX_R2PVPARTCTRLID:
            return et.isR2PVPartCtrlIdDirty();
        case INDEX_R2PVPARTID:
            return et.isR2PVPartIdDirty();
        case INDEX_R2PVPARTNAME:
            return et.isR2PVPartNameDirty();
        case INDEX_R3PVPARTCTRLID:
            return et.isR3PVPartCtrlIdDirty();
        case INDEX_R3PVPARTID:
            return et.isR3PVPartIdDirty();
        case INDEX_R3PVPARTNAME:
            return et.isR3PVPartNameDirty();
        case INDEX_R4PVPARTCTRLID:
            return et.isR4PVPartCtrlIdDirty();
        case INDEX_R4PVPARTID:
            return et.isR4PVPartIdDirty();
        case INDEX_R4PVPARTNAME:
            return et.isR4PVPartNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
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
    private static  void fillJSONObject(PPModelBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getC1PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"c1pvpartctrlid",getJSONValue(et.getC1PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getC1PVPartId()!=null) {
            JSONObjectHelper.put(json,"c1pvpartid",getJSONValue(et.getC1PVPartId()),false);
        }
        if(bIncEmpty||et.getC1PVPartName()!=null) {
            JSONObjectHelper.put(json,"c1pvpartname",getJSONValue(et.getC1PVPartName()),false);
        }
        if(bIncEmpty||et.getC2PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"c2pvpartctrlid",getJSONValue(et.getC2PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getC2PVPartId()!=null) {
            JSONObjectHelper.put(json,"c2pvpartid",getJSONValue(et.getC2PVPartId()),false);
        }
        if(bIncEmpty||et.getC2PVPartName()!=null) {
            JSONObjectHelper.put(json,"c2pvpartname",getJSONValue(et.getC2PVPartName()),false);
        }
        if(bIncEmpty||et.getC3PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"c3pvpartctrlid",getJSONValue(et.getC3PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getC3PVPartId()!=null) {
            JSONObjectHelper.put(json,"c3pvpartid",getJSONValue(et.getC3PVPartId()),false);
        }
        if(bIncEmpty||et.getC3PVPartName()!=null) {
            JSONObjectHelper.put(json,"c3pvpartname",getJSONValue(et.getC3PVPartName()),false);
        }
        if(bIncEmpty||et.getC4PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"c4pvpartctrlid",getJSONValue(et.getC4PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getC4PVPartId()!=null) {
            JSONObjectHelper.put(json,"c4pvpartid",getJSONValue(et.getC4PVPartId()),false);
        }
        if(bIncEmpty||et.getC4PVPartName()!=null) {
            JSONObjectHelper.put(json,"c4pvpartname",getJSONValue(et.getC4PVPartName()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            JSONObjectHelper.put(json,"issystem",getJSONValue(et.getIsSystem()),false);
        }
        if(bIncEmpty||et.getL1PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"l1pvpartctrlid",getJSONValue(et.getL1PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getL1PVPartId()!=null) {
            JSONObjectHelper.put(json,"l1pvpartid",getJSONValue(et.getL1PVPartId()),false);
        }
        if(bIncEmpty||et.getL1PVPartName()!=null) {
            JSONObjectHelper.put(json,"l1pvpartname",getJSONValue(et.getL1PVPartName()),false);
        }
        if(bIncEmpty||et.getL2PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"l2pvpartctrlid",getJSONValue(et.getL2PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getL2PVPartId()!=null) {
            JSONObjectHelper.put(json,"l2pvpartid",getJSONValue(et.getL2PVPartId()),false);
        }
        if(bIncEmpty||et.getL2PVPartName()!=null) {
            JSONObjectHelper.put(json,"l2pvpartname",getJSONValue(et.getL2PVPartName()),false);
        }
        if(bIncEmpty||et.getL3PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"l3pvpartctrlid",getJSONValue(et.getL3PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getL3PVPartId()!=null) {
            JSONObjectHelper.put(json,"l3pvpartid",getJSONValue(et.getL3PVPartId()),false);
        }
        if(bIncEmpty||et.getL3PVPartName()!=null) {
            JSONObjectHelper.put(json,"l3pvpartname",getJSONValue(et.getL3PVPartName()),false);
        }
        if(bIncEmpty||et.getL4PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"l4pvpartctrlid",getJSONValue(et.getL4PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getL4PVPartId()!=null) {
            JSONObjectHelper.put(json,"l4pvpartid",getJSONValue(et.getL4PVPartId()),false);
        }
        if(bIncEmpty||et.getL4PVPartName()!=null) {
            JSONObjectHelper.put(json,"l4pvpartname",getJSONValue(et.getL4PVPartName()),false);
        }
        if(bIncEmpty||et.getOwnerId()!=null) {
            JSONObjectHelper.put(json,"ownerid",getJSONValue(et.getOwnerId()),false);
        }
        if(bIncEmpty||et.getPortalPageId()!=null) {
            JSONObjectHelper.put(json,"portalpageid",getJSONValue(et.getPortalPageId()),false);
        }
        if(bIncEmpty||et.getPortalPageName()!=null) {
            JSONObjectHelper.put(json,"portalpagename",getJSONValue(et.getPortalPageName()),false);
        }
        if(bIncEmpty||et.getPPModel()!=null) {
            JSONObjectHelper.put(json,"ppmodel",getJSONValue(et.getPPModel()),false);
        }
        if(bIncEmpty||et.getPPModelDetail()!=null) {
            JSONObjectHelper.put(json,"ppmodeldetail",getJSONValue(et.getPPModelDetail()),false);
        }
        if(bIncEmpty||et.getPPModelId()!=null) {
            JSONObjectHelper.put(json,"ppmodelid",getJSONValue(et.getPPModelId()),false);
        }
        if(bIncEmpty||et.getPPModelName()!=null) {
            JSONObjectHelper.put(json,"ppmodelname",getJSONValue(et.getPPModelName()),false);
        }
        if(bIncEmpty||et.getPPMVersion()!=null) {
            JSONObjectHelper.put(json,"ppmversion",getJSONValue(et.getPPMVersion()),false);
        }
        if(bIncEmpty||et.getR1PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"r1pvpartctrlid",getJSONValue(et.getR1PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getR1PVPartId()!=null) {
            JSONObjectHelper.put(json,"r1pvpartid",getJSONValue(et.getR1PVPartId()),false);
        }
        if(bIncEmpty||et.getR1PVPartName()!=null) {
            JSONObjectHelper.put(json,"r1pvpartname",getJSONValue(et.getR1PVPartName()),false);
        }
        if(bIncEmpty||et.getR2PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"r2pvpartctrlid",getJSONValue(et.getR2PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getR2PVPartId()!=null) {
            JSONObjectHelper.put(json,"r2pvpartid",getJSONValue(et.getR2PVPartId()),false);
        }
        if(bIncEmpty||et.getR2PVPartName()!=null) {
            JSONObjectHelper.put(json,"r2pvpartname",getJSONValue(et.getR2PVPartName()),false);
        }
        if(bIncEmpty||et.getR3PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"r3pvpartctrlid",getJSONValue(et.getR3PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getR3PVPartId()!=null) {
            JSONObjectHelper.put(json,"r3pvpartid",getJSONValue(et.getR3PVPartId()),false);
        }
        if(bIncEmpty||et.getR3PVPartName()!=null) {
            JSONObjectHelper.put(json,"r3pvpartname",getJSONValue(et.getR3PVPartName()),false);
        }
        if(bIncEmpty||et.getR4PVPartCtrlId()!=null) {
            JSONObjectHelper.put(json,"r4pvpartctrlid",getJSONValue(et.getR4PVPartCtrlId()),false);
        }
        if(bIncEmpty||et.getR4PVPartId()!=null) {
            JSONObjectHelper.put(json,"r4pvpartid",getJSONValue(et.getR4PVPartId()),false);
        }
        if(bIncEmpty||et.getR4PVPartName()!=null) {
            JSONObjectHelper.put(json,"r4pvpartname",getJSONValue(et.getR4PVPartName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
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
    private static void fillXmlNode(PPModelBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getC1PVPartCtrlId()!=null) {
            Object obj = et.getC1PVPartCtrlId();
            node.setAttribute("C1PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC1PVPartId()!=null) {
            Object obj = et.getC1PVPartId();
            node.setAttribute("C1PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC1PVPartName()!=null) {
            Object obj = et.getC1PVPartName();
            node.setAttribute("C1PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC2PVPartCtrlId()!=null) {
            Object obj = et.getC2PVPartCtrlId();
            node.setAttribute("C2PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC2PVPartId()!=null) {
            Object obj = et.getC2PVPartId();
            node.setAttribute("C2PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC2PVPartName()!=null) {
            Object obj = et.getC2PVPartName();
            node.setAttribute("C2PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC3PVPartCtrlId()!=null) {
            Object obj = et.getC3PVPartCtrlId();
            node.setAttribute("C3PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC3PVPartId()!=null) {
            Object obj = et.getC3PVPartId();
            node.setAttribute("C3PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC3PVPartName()!=null) {
            Object obj = et.getC3PVPartName();
            node.setAttribute("C3PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC4PVPartCtrlId()!=null) {
            Object obj = et.getC4PVPartCtrlId();
            node.setAttribute("C4PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC4PVPartId()!=null) {
            Object obj = et.getC4PVPartId();
            node.setAttribute("C4PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getC4PVPartName()!=null) {
            Object obj = et.getC4PVPartName();
            node.setAttribute("C4PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            Object obj = et.getIsSystem();
            node.setAttribute("ISSYSTEM",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getL1PVPartCtrlId()!=null) {
            Object obj = et.getL1PVPartCtrlId();
            node.setAttribute("L1PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL1PVPartId()!=null) {
            Object obj = et.getL1PVPartId();
            node.setAttribute("L1PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL1PVPartName()!=null) {
            Object obj = et.getL1PVPartName();
            node.setAttribute("L1PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL2PVPartCtrlId()!=null) {
            Object obj = et.getL2PVPartCtrlId();
            node.setAttribute("L2PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL2PVPartId()!=null) {
            Object obj = et.getL2PVPartId();
            node.setAttribute("L2PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL2PVPartName()!=null) {
            Object obj = et.getL2PVPartName();
            node.setAttribute("L2PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL3PVPartCtrlId()!=null) {
            Object obj = et.getL3PVPartCtrlId();
            node.setAttribute("L3PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL3PVPartId()!=null) {
            Object obj = et.getL3PVPartId();
            node.setAttribute("L3PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL3PVPartName()!=null) {
            Object obj = et.getL3PVPartName();
            node.setAttribute("L3PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL4PVPartCtrlId()!=null) {
            Object obj = et.getL4PVPartCtrlId();
            node.setAttribute("L4PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL4PVPartId()!=null) {
            Object obj = et.getL4PVPartId();
            node.setAttribute("L4PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getL4PVPartName()!=null) {
            Object obj = et.getL4PVPartName();
            node.setAttribute("L4PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOwnerId()!=null) {
            Object obj = et.getOwnerId();
            node.setAttribute("OWNERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPortalPageId()!=null) {
            Object obj = et.getPortalPageId();
            node.setAttribute("PORTALPAGEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPortalPageName()!=null) {
            Object obj = et.getPortalPageName();
            node.setAttribute("PORTALPAGENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPPModel()!=null) {
            Object obj = et.getPPModel();
            node.setAttribute("PPMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPPModelDetail()!=null) {
            Object obj = et.getPPModelDetail();
            node.setAttribute("PPMODELDETAIL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPPModelId()!=null) {
            Object obj = et.getPPModelId();
            node.setAttribute("PPMODELID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPPModelName()!=null) {
            Object obj = et.getPPModelName();
            node.setAttribute("PPMODELNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPPMVersion()!=null) {
            Object obj = et.getPPMVersion();
            node.setAttribute("PPMVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getR1PVPartCtrlId()!=null) {
            Object obj = et.getR1PVPartCtrlId();
            node.setAttribute("R1PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR1PVPartId()!=null) {
            Object obj = et.getR1PVPartId();
            node.setAttribute("R1PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR1PVPartName()!=null) {
            Object obj = et.getR1PVPartName();
            node.setAttribute("R1PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR2PVPartCtrlId()!=null) {
            Object obj = et.getR2PVPartCtrlId();
            node.setAttribute("R2PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR2PVPartId()!=null) {
            Object obj = et.getR2PVPartId();
            node.setAttribute("R2PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR2PVPartName()!=null) {
            Object obj = et.getR2PVPartName();
            node.setAttribute("R2PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR3PVPartCtrlId()!=null) {
            Object obj = et.getR3PVPartCtrlId();
            node.setAttribute("R3PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR3PVPartId()!=null) {
            Object obj = et.getR3PVPartId();
            node.setAttribute("R3PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR3PVPartName()!=null) {
            Object obj = et.getR3PVPartName();
            node.setAttribute("R3PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR4PVPartCtrlId()!=null) {
            Object obj = et.getR4PVPartCtrlId();
            node.setAttribute("R4PVPARTCTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR4PVPartId()!=null) {
            Object obj = et.getR4PVPartId();
            node.setAttribute("R4PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getR4PVPartName()!=null) {
            Object obj = et.getR4PVPartName();
            node.setAttribute("R4PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PPModelBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(PPModelBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isC1PVPartCtrlIdDirty() && (bIncEmpty||et.getC1PVPartCtrlId()!=null)) {
            dst.set(FIELD_C1PVPARTCTRLID,et.getC1PVPartCtrlId());
        }
        if(et.isC1PVPartIdDirty() && (bIncEmpty||et.getC1PVPartId()!=null)) {
            dst.set(FIELD_C1PVPARTID,et.getC1PVPartId());
        }
        if(et.isC1PVPartNameDirty() && (bIncEmpty||et.getC1PVPartName()!=null)) {
            dst.set(FIELD_C1PVPARTNAME,et.getC1PVPartName());
        }
        if(et.isC2PVPartCtrlIdDirty() && (bIncEmpty||et.getC2PVPartCtrlId()!=null)) {
            dst.set(FIELD_C2PVPARTCTRLID,et.getC2PVPartCtrlId());
        }
        if(et.isC2PVPartIdDirty() && (bIncEmpty||et.getC2PVPartId()!=null)) {
            dst.set(FIELD_C2PVPARTID,et.getC2PVPartId());
        }
        if(et.isC2PVPartNameDirty() && (bIncEmpty||et.getC2PVPartName()!=null)) {
            dst.set(FIELD_C2PVPARTNAME,et.getC2PVPartName());
        }
        if(et.isC3PVPartCtrlIdDirty() && (bIncEmpty||et.getC3PVPartCtrlId()!=null)) {
            dst.set(FIELD_C3PVPARTCTRLID,et.getC3PVPartCtrlId());
        }
        if(et.isC3PVPartIdDirty() && (bIncEmpty||et.getC3PVPartId()!=null)) {
            dst.set(FIELD_C3PVPARTID,et.getC3PVPartId());
        }
        if(et.isC3PVPartNameDirty() && (bIncEmpty||et.getC3PVPartName()!=null)) {
            dst.set(FIELD_C3PVPARTNAME,et.getC3PVPartName());
        }
        if(et.isC4PVPartCtrlIdDirty() && (bIncEmpty||et.getC4PVPartCtrlId()!=null)) {
            dst.set(FIELD_C4PVPARTCTRLID,et.getC4PVPartCtrlId());
        }
        if(et.isC4PVPartIdDirty() && (bIncEmpty||et.getC4PVPartId()!=null)) {
            dst.set(FIELD_C4PVPARTID,et.getC4PVPartId());
        }
        if(et.isC4PVPartNameDirty() && (bIncEmpty||et.getC4PVPartName()!=null)) {
            dst.set(FIELD_C4PVPARTNAME,et.getC4PVPartName());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isIsSystemDirty() && (bIncEmpty||et.getIsSystem()!=null)) {
            dst.set(FIELD_ISSYSTEM,et.getIsSystem());
        }
        if(et.isL1PVPartCtrlIdDirty() && (bIncEmpty||et.getL1PVPartCtrlId()!=null)) {
            dst.set(FIELD_L1PVPARTCTRLID,et.getL1PVPartCtrlId());
        }
        if(et.isL1PVPartIdDirty() && (bIncEmpty||et.getL1PVPartId()!=null)) {
            dst.set(FIELD_L1PVPARTID,et.getL1PVPartId());
        }
        if(et.isL1PVPartNameDirty() && (bIncEmpty||et.getL1PVPartName()!=null)) {
            dst.set(FIELD_L1PVPARTNAME,et.getL1PVPartName());
        }
        if(et.isL2PVPartCtrlIdDirty() && (bIncEmpty||et.getL2PVPartCtrlId()!=null)) {
            dst.set(FIELD_L2PVPARTCTRLID,et.getL2PVPartCtrlId());
        }
        if(et.isL2PVPartIdDirty() && (bIncEmpty||et.getL2PVPartId()!=null)) {
            dst.set(FIELD_L2PVPARTID,et.getL2PVPartId());
        }
        if(et.isL2PVPartNameDirty() && (bIncEmpty||et.getL2PVPartName()!=null)) {
            dst.set(FIELD_L2PVPARTNAME,et.getL2PVPartName());
        }
        if(et.isL3PVPartCtrlIdDirty() && (bIncEmpty||et.getL3PVPartCtrlId()!=null)) {
            dst.set(FIELD_L3PVPARTCTRLID,et.getL3PVPartCtrlId());
        }
        if(et.isL3PVPartIdDirty() && (bIncEmpty||et.getL3PVPartId()!=null)) {
            dst.set(FIELD_L3PVPARTID,et.getL3PVPartId());
        }
        if(et.isL3PVPartNameDirty() && (bIncEmpty||et.getL3PVPartName()!=null)) {
            dst.set(FIELD_L3PVPARTNAME,et.getL3PVPartName());
        }
        if(et.isL4PVPartCtrlIdDirty() && (bIncEmpty||et.getL4PVPartCtrlId()!=null)) {
            dst.set(FIELD_L4PVPARTCTRLID,et.getL4PVPartCtrlId());
        }
        if(et.isL4PVPartIdDirty() && (bIncEmpty||et.getL4PVPartId()!=null)) {
            dst.set(FIELD_L4PVPARTID,et.getL4PVPartId());
        }
        if(et.isL4PVPartNameDirty() && (bIncEmpty||et.getL4PVPartName()!=null)) {
            dst.set(FIELD_L4PVPARTNAME,et.getL4PVPartName());
        }
        if(et.isOwnerIdDirty() && (bIncEmpty||et.getOwnerId()!=null)) {
            dst.set(FIELD_OWNERID,et.getOwnerId());
        }
        if(et.isPortalPageIdDirty() && (bIncEmpty||et.getPortalPageId()!=null)) {
            dst.set(FIELD_PORTALPAGEID,et.getPortalPageId());
        }
        if(et.isPortalPageNameDirty() && (bIncEmpty||et.getPortalPageName()!=null)) {
            dst.set(FIELD_PORTALPAGENAME,et.getPortalPageName());
        }
        if(et.isPPModelDirty() && (bIncEmpty||et.getPPModel()!=null)) {
            dst.set(FIELD_PPMODEL,et.getPPModel());
        }
        if(et.isPPModelDetailDirty() && (bIncEmpty||et.getPPModelDetail()!=null)) {
            dst.set(FIELD_PPMODELDETAIL,et.getPPModelDetail());
        }
        if(et.isPPModelIdDirty() && (bIncEmpty||et.getPPModelId()!=null)) {
            dst.set(FIELD_PPMODELID,et.getPPModelId());
        }
        if(et.isPPModelNameDirty() && (bIncEmpty||et.getPPModelName()!=null)) {
            dst.set(FIELD_PPMODELNAME,et.getPPModelName());
        }
        if(et.isPPMVersionDirty() && (bIncEmpty||et.getPPMVersion()!=null)) {
            dst.set(FIELD_PPMVERSION,et.getPPMVersion());
        }
        if(et.isR1PVPartCtrlIdDirty() && (bIncEmpty||et.getR1PVPartCtrlId()!=null)) {
            dst.set(FIELD_R1PVPARTCTRLID,et.getR1PVPartCtrlId());
        }
        if(et.isR1PVPartIdDirty() && (bIncEmpty||et.getR1PVPartId()!=null)) {
            dst.set(FIELD_R1PVPARTID,et.getR1PVPartId());
        }
        if(et.isR1PVPartNameDirty() && (bIncEmpty||et.getR1PVPartName()!=null)) {
            dst.set(FIELD_R1PVPARTNAME,et.getR1PVPartName());
        }
        if(et.isR2PVPartCtrlIdDirty() && (bIncEmpty||et.getR2PVPartCtrlId()!=null)) {
            dst.set(FIELD_R2PVPARTCTRLID,et.getR2PVPartCtrlId());
        }
        if(et.isR2PVPartIdDirty() && (bIncEmpty||et.getR2PVPartId()!=null)) {
            dst.set(FIELD_R2PVPARTID,et.getR2PVPartId());
        }
        if(et.isR2PVPartNameDirty() && (bIncEmpty||et.getR2PVPartName()!=null)) {
            dst.set(FIELD_R2PVPARTNAME,et.getR2PVPartName());
        }
        if(et.isR3PVPartCtrlIdDirty() && (bIncEmpty||et.getR3PVPartCtrlId()!=null)) {
            dst.set(FIELD_R3PVPARTCTRLID,et.getR3PVPartCtrlId());
        }
        if(et.isR3PVPartIdDirty() && (bIncEmpty||et.getR3PVPartId()!=null)) {
            dst.set(FIELD_R3PVPARTID,et.getR3PVPartId());
        }
        if(et.isR3PVPartNameDirty() && (bIncEmpty||et.getR3PVPartName()!=null)) {
            dst.set(FIELD_R3PVPARTNAME,et.getR3PVPartName());
        }
        if(et.isR4PVPartCtrlIdDirty() && (bIncEmpty||et.getR4PVPartCtrlId()!=null)) {
            dst.set(FIELD_R4PVPARTCTRLID,et.getR4PVPartCtrlId());
        }
        if(et.isR4PVPartIdDirty() && (bIncEmpty||et.getR4PVPartId()!=null)) {
            dst.set(FIELD_R4PVPARTID,et.getR4PVPartId());
        }
        if(et.isR4PVPartNameDirty() && (bIncEmpty||et.getR4PVPartName()!=null)) {
            dst.set(FIELD_R4PVPARTNAME,et.getR4PVPartName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
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
        return  PPModelBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(PPModelBase et,int index) throws Exception {
        switch(index) {
        case INDEX_C1PVPARTCTRLID:
            et.resetC1PVPartCtrlId();
            return true;
        case INDEX_C1PVPARTID:
            et.resetC1PVPartId();
            return true;
        case INDEX_C1PVPARTNAME:
            et.resetC1PVPartName();
            return true;
        case INDEX_C2PVPARTCTRLID:
            et.resetC2PVPartCtrlId();
            return true;
        case INDEX_C2PVPARTID:
            et.resetC2PVPartId();
            return true;
        case INDEX_C2PVPARTNAME:
            et.resetC2PVPartName();
            return true;
        case INDEX_C3PVPARTCTRLID:
            et.resetC3PVPartCtrlId();
            return true;
        case INDEX_C3PVPARTID:
            et.resetC3PVPartId();
            return true;
        case INDEX_C3PVPARTNAME:
            et.resetC3PVPartName();
            return true;
        case INDEX_C4PVPARTCTRLID:
            et.resetC4PVPartCtrlId();
            return true;
        case INDEX_C4PVPARTID:
            et.resetC4PVPartId();
            return true;
        case INDEX_C4PVPARTNAME:
            et.resetC4PVPartName();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ISSYSTEM:
            et.resetIsSystem();
            return true;
        case INDEX_L1PVPARTCTRLID:
            et.resetL1PVPartCtrlId();
            return true;
        case INDEX_L1PVPARTID:
            et.resetL1PVPartId();
            return true;
        case INDEX_L1PVPARTNAME:
            et.resetL1PVPartName();
            return true;
        case INDEX_L2PVPARTCTRLID:
            et.resetL2PVPartCtrlId();
            return true;
        case INDEX_L2PVPARTID:
            et.resetL2PVPartId();
            return true;
        case INDEX_L2PVPARTNAME:
            et.resetL2PVPartName();
            return true;
        case INDEX_L3PVPARTCTRLID:
            et.resetL3PVPartCtrlId();
            return true;
        case INDEX_L3PVPARTID:
            et.resetL3PVPartId();
            return true;
        case INDEX_L3PVPARTNAME:
            et.resetL3PVPartName();
            return true;
        case INDEX_L4PVPARTCTRLID:
            et.resetL4PVPartCtrlId();
            return true;
        case INDEX_L4PVPARTID:
            et.resetL4PVPartId();
            return true;
        case INDEX_L4PVPARTNAME:
            et.resetL4PVPartName();
            return true;
        case INDEX_OWNERID:
            et.resetOwnerId();
            return true;
        case INDEX_PORTALPAGEID:
            et.resetPortalPageId();
            return true;
        case INDEX_PORTALPAGENAME:
            et.resetPortalPageName();
            return true;
        case INDEX_PPMODEL:
            et.resetPPModel();
            return true;
        case INDEX_PPMODELDETAIL:
            et.resetPPModelDetail();
            return true;
        case INDEX_PPMODELID:
            et.resetPPModelId();
            return true;
        case INDEX_PPMODELNAME:
            et.resetPPModelName();
            return true;
        case INDEX_PPMVERSION:
            et.resetPPMVersion();
            return true;
        case INDEX_R1PVPARTCTRLID:
            et.resetR1PVPartCtrlId();
            return true;
        case INDEX_R1PVPARTID:
            et.resetR1PVPartId();
            return true;
        case INDEX_R1PVPARTNAME:
            et.resetR1PVPartName();
            return true;
        case INDEX_R2PVPARTCTRLID:
            et.resetR2PVPartCtrlId();
            return true;
        case INDEX_R2PVPARTID:
            et.resetR2PVPartId();
            return true;
        case INDEX_R2PVPARTNAME:
            et.resetR2PVPartName();
            return true;
        case INDEX_R3PVPARTCTRLID:
            et.resetR3PVPartCtrlId();
            return true;
        case INDEX_R3PVPARTID:
            et.resetR3PVPartId();
            return true;
        case INDEX_R3PVPARTNAME:
            et.resetR3PVPartName();
            return true;
        case INDEX_R4PVPARTCTRLID:
            et.resetR4PVPartCtrlId();
            return true;
        case INDEX_R4PVPARTID:
            et.resetR4PVPartId();
            return true;
        case INDEX_R4PVPARTNAME:
            et.resetR4PVPartName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objPortalPageLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PortalPage portalpage = null;
    /**
    * 获取父数据 门户页面
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PortalPage getPortalPage() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPage();
        }

        if(this.getPortalPageId()==null)
            return null;
        synchronized(this.objPortalPageLock) {
            if(this.portalpage!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getPortalPageId(),portalpage.getPortalPageId())!=0) {
                    this.portalpage = null;
                }
            }


            if(this.portalpage==null) {
                net.ibizsys.psrt.srv.common.entity.PortalPage portalpage = new net.ibizsys.psrt.srv.common.entity.PortalPage();
                portalpage.setPortalPageId(this.getPortalPageId());
                net.ibizsys.psrt.srv.common.service.PortalPageService service = (net.ibizsys.psrt.srv.common.service.PortalPageService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PortalPageService.class,this.getSessionFactory());
                service.autoGet(portalpage);
                this.portalpage = portalpage;
            }
            return this.portalpage;
        }
    }

    private Integer objC1PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart c1pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getC1PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC1PVPart();
        }

        if(this.getC1PVPartId()==null)
            return null;
        synchronized(this.objC1PVPartLock) {
            if(this.c1pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getC1PVPartId(),c1pvpart.getPVPartId())!=0) {
                    this.c1pvpart = null;
                }
            }


            if(this.c1pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart c1pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                c1pvpart.setPVPartId(this.getC1PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(c1pvpart);
                this.c1pvpart = c1pvpart;
            }
            return this.c1pvpart;
        }
    }

    private Integer objC2PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart c2pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getC2PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC2PVPart();
        }

        if(this.getC2PVPartId()==null)
            return null;
        synchronized(this.objC2PVPartLock) {
            if(this.c2pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getC2PVPartId(),c2pvpart.getPVPartId())!=0) {
                    this.c2pvpart = null;
                }
            }


            if(this.c2pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart c2pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                c2pvpart.setPVPartId(this.getC2PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(c2pvpart);
                this.c2pvpart = c2pvpart;
            }
            return this.c2pvpart;
        }
    }

    private Integer objC3PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart c3pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getC3PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC3PVPart();
        }

        if(this.getC3PVPartId()==null)
            return null;
        synchronized(this.objC3PVPartLock) {
            if(this.c3pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getC3PVPartId(),c3pvpart.getPVPartId())!=0) {
                    this.c3pvpart = null;
                }
            }


            if(this.c3pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart c3pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                c3pvpart.setPVPartId(this.getC3PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(c3pvpart);
                this.c3pvpart = c3pvpart;
            }
            return this.c3pvpart;
        }
    }

    private Integer objC4PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart c4pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getC4PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getC4PVPart();
        }

        if(this.getC4PVPartId()==null)
            return null;
        synchronized(this.objC4PVPartLock) {
            if(this.c4pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getC4PVPartId(),c4pvpart.getPVPartId())!=0) {
                    this.c4pvpart = null;
                }
            }


            if(this.c4pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart c4pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                c4pvpart.setPVPartId(this.getC4PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(c4pvpart);
                this.c4pvpart = c4pvpart;
            }
            return this.c4pvpart;
        }
    }

    private Integer objL1PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart l1pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getL1PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL1PVPart();
        }

        if(this.getL1PVPartId()==null)
            return null;
        synchronized(this.objL1PVPartLock) {
            if(this.l1pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getL1PVPartId(),l1pvpart.getPVPartId())!=0) {
                    this.l1pvpart = null;
                }
            }


            if(this.l1pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart l1pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                l1pvpart.setPVPartId(this.getL1PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(l1pvpart);
                this.l1pvpart = l1pvpart;
            }
            return this.l1pvpart;
        }
    }

    private Integer objL2PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart l2pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getL2PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL2PVPart();
        }

        if(this.getL2PVPartId()==null)
            return null;
        synchronized(this.objL2PVPartLock) {
            if(this.l2pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getL2PVPartId(),l2pvpart.getPVPartId())!=0) {
                    this.l2pvpart = null;
                }
            }


            if(this.l2pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart l2pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                l2pvpart.setPVPartId(this.getL2PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(l2pvpart);
                this.l2pvpart = l2pvpart;
            }
            return this.l2pvpart;
        }
    }

    private Integer objL3PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart l3pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getL3PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL3PVPart();
        }

        if(this.getL3PVPartId()==null)
            return null;
        synchronized(this.objL3PVPartLock) {
            if(this.l3pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getL3PVPartId(),l3pvpart.getPVPartId())!=0) {
                    this.l3pvpart = null;
                }
            }


            if(this.l3pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart l3pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                l3pvpart.setPVPartId(this.getL3PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(l3pvpart);
                this.l3pvpart = l3pvpart;
            }
            return this.l3pvpart;
        }
    }

    private Integer objL4PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart l4pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getL4PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getL4PVPart();
        }

        if(this.getL4PVPartId()==null)
            return null;
        synchronized(this.objL4PVPartLock) {
            if(this.l4pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getL4PVPartId(),l4pvpart.getPVPartId())!=0) {
                    this.l4pvpart = null;
                }
            }


            if(this.l4pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart l4pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                l4pvpart.setPVPartId(this.getL4PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(l4pvpart);
                this.l4pvpart = l4pvpart;
            }
            return this.l4pvpart;
        }
    }

    private Integer objR1PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart r1pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getR1PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR1PVPart();
        }

        if(this.getR1PVPartId()==null)
            return null;
        synchronized(this.objR1PVPartLock) {
            if(this.r1pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getR1PVPartId(),r1pvpart.getPVPartId())!=0) {
                    this.r1pvpart = null;
                }
            }


            if(this.r1pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart r1pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                r1pvpart.setPVPartId(this.getR1PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(r1pvpart);
                this.r1pvpart = r1pvpart;
            }
            return this.r1pvpart;
        }
    }

    private Integer objR2PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart r2pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getR2PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR2PVPart();
        }

        if(this.getR2PVPartId()==null)
            return null;
        synchronized(this.objR2PVPartLock) {
            if(this.r2pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getR2PVPartId(),r2pvpart.getPVPartId())!=0) {
                    this.r2pvpart = null;
                }
            }


            if(this.r2pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart r2pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                r2pvpart.setPVPartId(this.getR2PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(r2pvpart);
                this.r2pvpart = r2pvpart;
            }
            return this.r2pvpart;
        }
    }

    private Integer objR3PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart r3pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getR3PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR3PVPart();
        }

        if(this.getR3PVPartId()==null)
            return null;
        synchronized(this.objR3PVPartLock) {
            if(this.r3pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getR3PVPartId(),r3pvpart.getPVPartId())!=0) {
                    this.r3pvpart = null;
                }
            }


            if(this.r3pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart r3pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                r3pvpart.setPVPartId(this.getR3PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(r3pvpart);
                this.r3pvpart = r3pvpart;
            }
            return this.r3pvpart;
        }
    }

    private Integer objR4PVPartLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PVPart r4pvpart = null;
    /**
    * 获取父数据 门户视图部件
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PVPart getR4PVPart() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getR4PVPart();
        }

        if(this.getR4PVPartId()==null)
            return null;
        synchronized(this.objR4PVPartLock) {
            if(this.r4pvpart!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getR4PVPartId(),r4pvpart.getPVPartId())!=0) {
                    this.r4pvpart = null;
                }
            }


            if(this.r4pvpart==null) {
                net.ibizsys.psrt.srv.common.entity.PVPart r4pvpart = new net.ibizsys.psrt.srv.common.entity.PVPart();
                r4pvpart.setPVPartId(this.getR4PVPartId());
                net.ibizsys.psrt.srv.common.service.PVPartService service = (net.ibizsys.psrt.srv.common.service.PVPartService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PVPartService.class,this.getSessionFactory());
                service.autoGet(r4pvpart);
                this.r4pvpart = r4pvpart;
            }
            return this.r4pvpart;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private PPModelBase getProxyEntity() {
        return this.proxyPPModelBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPPModelBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof PPModelBase) {
            this.proxyPPModelBase = (PPModelBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PPModelService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}