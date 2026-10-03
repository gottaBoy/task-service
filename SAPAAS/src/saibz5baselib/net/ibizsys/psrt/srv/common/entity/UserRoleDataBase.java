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
 * 实体[UserRoleData] 数据对象基类
 */
public abstract class UserRoleDataBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDataBase.class);
    /**
     * 属性[条线数据类型]
     */
    public final static String FIELD_BCDR = "BCDR";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据实体]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[数据对象]
     */
    public final static String FIELD_DENAME = "DENAME";
    /**
     * 属性[指定当前机构]
     */
    public final static String FIELD_DSTORGID = "DSTORGID";
    /**
     * 属性[指定当前机构]
     */
    public final static String FIELD_DSTORGNAME = "DSTORGNAME";
    /**
     * 属性[指定当前部门]
     */
    public final static String FIELD_DSTORGSECTORID = "DSTORGSECTORID";
    /**
     * 属性[指定当前部门]
     */
    public final static String FIELD_DSTORGSECTORNAME = "DSTORGSECTORNAME";
    /**
     * 属性[指定部门业务类型]
     */
    public final static String FIELD_DSTSECBC = "DSTSECBC";
    /**
     * 属性[全部数据]
     */
    public final static String FIELD_ISALLDATA = "ISALLDATA";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[机构数据类型]
     */
    public final static String FIELD_ORGDR = "ORGDR";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[保留字段3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[保留字段4]
     */
    public final static String FIELD_RESERVER4 = "RESERVER4";
    /**
     * 属性[部门数据类型]
     */
    public final static String FIELD_SECDR = "SECDR";
    /**
     * 属性[框架发布]
     */
    public final static String FIELD_SRFSYSPUB = "SRFSYSPUB";
    /**
     * 属性[应用发布]
     */
    public final static String FIELD_SRFUSERPUB = "SRFUSERPUB";
    /**
     * 属性[版本]
     */
    public final static String FIELD_UDVERSION = "UDVERSION";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户数据类型]
     */
    public final static String FIELD_USERDR = "USERDR";
    /**
     * 属性[数据对象能力标识]
     */
    public final static String FIELD_USERROLEDATAID = "USERROLEDATAID";
    /**
     * 属性[能力名称]
     */
    public final static String FIELD_USERROLEDATANAME = "USERROLEDATANAME";

    private final static int INDEX_BCDR = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_DEID = 3;
    private final static int INDEX_DENAME = 4;
    private final static int INDEX_DSTORGID = 5;
    private final static int INDEX_DSTORGNAME = 6;
    private final static int INDEX_DSTORGSECTORID = 7;
    private final static int INDEX_DSTORGSECTORNAME = 8;
    private final static int INDEX_DSTSECBC = 9;
    private final static int INDEX_ISALLDATA = 10;
    private final static int INDEX_MEMO = 11;
    private final static int INDEX_ORGDR = 12;
    private final static int INDEX_RESERVER = 13;
    private final static int INDEX_RESERVER2 = 14;
    private final static int INDEX_RESERVER3 = 15;
    private final static int INDEX_RESERVER4 = 16;
    private final static int INDEX_SECDR = 17;
    private final static int INDEX_SRFSYSPUB = 18;
    private final static int INDEX_SRFUSERPUB = 19;
    private final static int INDEX_UDVERSION = 20;
    private final static int INDEX_UPDATEDATE = 21;
    private final static int INDEX_UPDATEMAN = 22;
    private final static int INDEX_USERDR = 23;
    private final static int INDEX_USERROLEDATAID = 24;
    private final static int INDEX_USERROLEDATANAME = 25;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_BCDR, INDEX_BCDR);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DENAME, INDEX_DENAME);
        fieldIndexMap.put( FIELD_DSTORGID, INDEX_DSTORGID);
        fieldIndexMap.put( FIELD_DSTORGNAME, INDEX_DSTORGNAME);
        fieldIndexMap.put( FIELD_DSTORGSECTORID, INDEX_DSTORGSECTORID);
        fieldIndexMap.put( FIELD_DSTORGSECTORNAME, INDEX_DSTORGSECTORNAME);
        fieldIndexMap.put( FIELD_DSTSECBC, INDEX_DSTSECBC);
        fieldIndexMap.put( FIELD_ISALLDATA, INDEX_ISALLDATA);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_ORGDR, INDEX_ORGDR);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_SECDR, INDEX_SECDR);
        fieldIndexMap.put( FIELD_SRFSYSPUB, INDEX_SRFSYSPUB);
        fieldIndexMap.put( FIELD_SRFUSERPUB, INDEX_SRFUSERPUB);
        fieldIndexMap.put( FIELD_UDVERSION, INDEX_UDVERSION);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDR, INDEX_USERDR);
        fieldIndexMap.put( FIELD_USERROLEDATAID, INDEX_USERROLEDATAID);
        fieldIndexMap.put( FIELD_USERROLEDATANAME, INDEX_USERROLEDATANAME);
    }

    private UserRoleDataBase proxyUserRoleDataBase = null;
    public UserRoleDataBase() {
        super();
    }
    private boolean bcdrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean dstorgidDirtyFlag = false;
    private boolean dstorgnameDirtyFlag = false;
    private boolean dstorgsectoridDirtyFlag = false;
    private boolean dstorgsectornameDirtyFlag = false;
    private boolean dstsecbcDirtyFlag = false;
    private boolean isalldataDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgdrDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean secdrDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean udversionDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdrDirtyFlag = false;
    private boolean userroledataidDirtyFlag = false;
    private boolean userroledatanameDirtyFlag = false;

    @Column(name="bcdr")
    private Integer bcdr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="dstorgid")
    private String dstorgid;
    @Column(name="dstorgname")
    private String dstorgname;
    @Column(name="dstorgsectorid")
    private String dstorgsectorid;
    @Column(name="dstorgsectorname")
    private String dstorgsectorname;
    @Column(name="dstsecbc")
    private String dstsecbc;
    @Column(name="isalldata")
    private Integer isalldata;
    @Column(name="memo")
    private String memo;
    @Column(name="orgdr")
    private Integer orgdr;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="secdr")
    private Integer secdr;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="udversion")
    private Integer udversion;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdr")
    private Integer userdr;
    @Column(name="userroledataid")
    private String userroledataid;
    @Column(name="userroledataname")
    private String userroledataname;


    /**
     *  设置属性值[条线数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel
     *  @param bcdr
     */
    public void setBCDR(Integer bcdr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setBCDR(bcdr);
            return;
        }
        this.bcdr = bcdr;
        this.bcdrDirtyFlag  = true;
    }

    /**
     *  获取属性值[条线数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel
     */
    public Integer getBCDR() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getBCDR();
        }
        return this.bcdr;
    }

    /**
     *  获取属性值[条线数据类型]是否修改
     */
    public boolean isBCDRDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isBCDRDirty();
        }
        return this.bcdrDirtyFlag;
    }

    /**
     *  重置属性值[条线数据类型]
     */
    public void resetBCDR() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetBCDR();
            return;
        }

        this.bcdrDirtyFlag = false;
        this.bcdr = null;
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
     *  设置属性值[数据实体]
     *  @param deid
     */
    public void setDEId(String deid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if(deid!=null) {
            deid = StringHelper.trimRight(deid);
            if(deid.length()==0) {
                deid = null;
            }
        }
        this.deid = deid;
        this.deidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据实体]
     */
    public String getDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    /**
     *  获取属性值[数据实体]是否修改
     */
    public boolean isDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    /**
     *  重置属性值[数据实体]
     */
    public void resetDEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEId();
            return;
        }

        this.deidDirtyFlag = false;
        this.deid = null;
    }
    /**
     *  设置属性值[数据对象]
     *  @param dename
     */
    public void setDEName(String dename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if(dename!=null) {
            dename = StringHelper.trimRight(dename);
            if(dename.length()==0) {
                dename = null;
            }
        }
        this.dename = dename;
        this.denameDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据对象]
     */
    public String getDEName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    /**
     *  获取属性值[数据对象]是否修改
     */
    public boolean isDENameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    /**
     *  重置属性值[数据对象]
     */
    public void resetDEName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEName();
            return;
        }

        this.denameDirtyFlag = false;
        this.dename = null;
    }
    /**
     *  设置属性值[指定当前机构]
     *  @param dstorgid
     */
    public void setDstOrgId(String dstorgid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDstOrgId(dstorgid);
            return;
        }
        if(dstorgid!=null) {
            dstorgid = StringHelper.trimRight(dstorgid);
            if(dstorgid.length()==0) {
                dstorgid = null;
            }
        }
        this.dstorgid = dstorgid;
        this.dstorgidDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定当前机构]
     */
    public String getDstOrgId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrgId();
        }
        return this.dstorgid;
    }

    /**
     *  获取属性值[指定当前机构]是否修改
     */
    public boolean isDstOrgIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDstOrgIdDirty();
        }
        return this.dstorgidDirtyFlag;
    }

    /**
     *  重置属性值[指定当前机构]
     */
    public void resetDstOrgId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDstOrgId();
            return;
        }

        this.dstorgidDirtyFlag = false;
        this.dstorgid = null;
    }
    /**
     *  设置属性值[指定当前机构]
     *  @param dstorgname
     */
    public void setDstOrgName(String dstorgname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDstOrgName(dstorgname);
            return;
        }
        if(dstorgname!=null) {
            dstorgname = StringHelper.trimRight(dstorgname);
            if(dstorgname.length()==0) {
                dstorgname = null;
            }
        }
        this.dstorgname = dstorgname;
        this.dstorgnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定当前机构]
     */
    public String getDstOrgName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrgName();
        }
        return this.dstorgname;
    }

    /**
     *  获取属性值[指定当前机构]是否修改
     */
    public boolean isDstOrgNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDstOrgNameDirty();
        }
        return this.dstorgnameDirtyFlag;
    }

    /**
     *  重置属性值[指定当前机构]
     */
    public void resetDstOrgName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDstOrgName();
            return;
        }

        this.dstorgnameDirtyFlag = false;
        this.dstorgname = null;
    }
    /**
     *  设置属性值[指定当前部门]
     *  @param dstorgsectorid
     */
    public void setDstOrgSectorId(String dstorgsectorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDstOrgSectorId(dstorgsectorid);
            return;
        }
        if(dstorgsectorid!=null) {
            dstorgsectorid = StringHelper.trimRight(dstorgsectorid);
            if(dstorgsectorid.length()==0) {
                dstorgsectorid = null;
            }
        }
        this.dstorgsectorid = dstorgsectorid;
        this.dstorgsectoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定当前部门]
     */
    public String getDstOrgSectorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrgSectorId();
        }
        return this.dstorgsectorid;
    }

    /**
     *  获取属性值[指定当前部门]是否修改
     */
    public boolean isDstOrgSectorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDstOrgSectorIdDirty();
        }
        return this.dstorgsectoridDirtyFlag;
    }

    /**
     *  重置属性值[指定当前部门]
     */
    public void resetDstOrgSectorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDstOrgSectorId();
            return;
        }

        this.dstorgsectoridDirtyFlag = false;
        this.dstorgsectorid = null;
    }
    /**
     *  设置属性值[指定当前部门]
     *  @param dstorgsectorname
     */
    public void setDstOrgSectorName(String dstorgsectorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDstOrgSectorName(dstorgsectorname);
            return;
        }
        if(dstorgsectorname!=null) {
            dstorgsectorname = StringHelper.trimRight(dstorgsectorname);
            if(dstorgsectorname.length()==0) {
                dstorgsectorname = null;
            }
        }
        this.dstorgsectorname = dstorgsectorname;
        this.dstorgsectornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定当前部门]
     */
    public String getDstOrgSectorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrgSectorName();
        }
        return this.dstorgsectorname;
    }

    /**
     *  获取属性值[指定当前部门]是否修改
     */
    public boolean isDstOrgSectorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDstOrgSectorNameDirty();
        }
        return this.dstorgsectornameDirtyFlag;
    }

    /**
     *  重置属性值[指定当前部门]
     */
    public void resetDstOrgSectorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDstOrgSectorName();
            return;
        }

        this.dstorgsectornameDirtyFlag = false;
        this.dstorgsectorname = null;
    }
    /**
     *  设置属性值[指定部门业务类型]
     *  @param dstsecbc
     */
    public void setDstSecBC(String dstsecbc) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDstSecBC(dstsecbc);
            return;
        }
        if(dstsecbc!=null) {
            dstsecbc = StringHelper.trimRight(dstsecbc);
            if(dstsecbc.length()==0) {
                dstsecbc = null;
            }
        }
        this.dstsecbc = dstsecbc;
        this.dstsecbcDirtyFlag  = true;
    }

    /**
     *  获取属性值[指定部门业务类型]
     */
    public String getDstSecBC() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstSecBC();
        }
        return this.dstsecbc;
    }

    /**
     *  获取属性值[指定部门业务类型]是否修改
     */
    public boolean isDstSecBCDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDstSecBCDirty();
        }
        return this.dstsecbcDirtyFlag;
    }

    /**
     *  重置属性值[指定部门业务类型]
     */
    public void resetDstSecBC() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDstSecBC();
            return;
        }

        this.dstsecbcDirtyFlag = false;
        this.dstsecbc = null;
    }
    /**
     *  设置属性值[全部数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isalldata
     */
    public void setIsAllData(Integer isalldata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsAllData(isalldata);
            return;
        }
        this.isalldata = isalldata;
        this.isalldataDirtyFlag  = true;
    }

    /**
     *  获取属性值[全部数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsAllData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsAllData();
        }
        return this.isalldata;
    }

    /**
     *  获取属性值[全部数据]是否修改
     */
    public boolean isIsAllDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsAllDataDirty();
        }
        return this.isalldataDirtyFlag;
    }

    /**
     *  重置属性值[全部数据]
     */
    public void resetIsAllData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsAllData();
            return;
        }

        this.isalldataDirtyFlag = false;
        this.isalldata = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[机构数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel
     *  @param orgdr
     */
    public void setOrgDR(Integer orgdr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgDR(orgdr);
            return;
        }
        this.orgdr = orgdr;
        this.orgdrDirtyFlag  = true;
    }

    /**
     *  获取属性值[机构数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel
     */
    public Integer getOrgDR() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgDR();
        }
        return this.orgdr;
    }

    /**
     *  获取属性值[机构数据类型]是否修改
     */
    public boolean isOrgDRDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgDRDirty();
        }
        return this.orgdrDirtyFlag;
    }

    /**
     *  重置属性值[机构数据类型]
     */
    public void resetOrgDR() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgDR();
            return;
        }

        this.orgdrDirtyFlag = false;
        this.orgdr = null;
    }
    /**
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[保留字段3]
     *  @param reserver3
     */
    public void setReserver3(String reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if(reserver3!=null) {
            reserver3 = StringHelper.trimRight(reserver3);
            if(reserver3.length()==0) {
                reserver3 = null;
            }
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public String getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[保留字段3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[保留字段3]
     */
    public void resetReserver3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver3();
            return;
        }

        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }
    /**
     *  设置属性值[保留字段4]
     *  @param reserver4
     */
    public void setReserver4(String reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if(reserver4!=null) {
            reserver4 = StringHelper.trimRight(reserver4);
            if(reserver4.length()==0) {
                reserver4 = null;
            }
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public String getReserver4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    /**
     *  获取属性值[保留字段4]是否修改
     */
    public boolean isReserver4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    /**
     *  重置属性值[保留字段4]
     */
    public void resetReserver4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver4();
            return;
        }

        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }
    /**
     *  设置属性值[部门数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel
     *  @param secdr
     */
    public void setSecDR(Integer secdr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSecDR(secdr);
            return;
        }
        this.secdr = secdr;
        this.secdrDirtyFlag  = true;
    }

    /**
     *  获取属性值[部门数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel
     */
    public Integer getSecDR() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSecDR();
        }
        return this.secdr;
    }

    /**
     *  获取属性值[部门数据类型]是否修改
     */
    public boolean isSecDRDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSecDRDirty();
        }
        return this.secdrDirtyFlag;
    }

    /**
     *  重置属性值[部门数据类型]
     */
    public void resetSecDR() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSecDR();
            return;
        }

        this.secdrDirtyFlag = false;
        this.secdr = null;
    }
    /**
     *  设置属性值[框架发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param srfsyspub
     */
    public void setSRFSysPub(Integer srfsyspub) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSRFSysPub(srfsyspub);
            return;
        }
        this.srfsyspub = srfsyspub;
        this.srfsyspubDirtyFlag  = true;
    }

    /**
     *  获取属性值[框架发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSRFSysPub() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    /**
     *  获取属性值[框架发布]是否修改
     */
    public boolean isSRFSysPubDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    /**
     *  重置属性值[框架发布]
     */
    public void resetSRFSysPub() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }

        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }
    /**
     *  设置属性值[应用发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param srfuserpub
     */
    public void setSRFUserPub(Integer srfuserpub) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSRFUserPub(srfuserpub);
            return;
        }
        this.srfuserpub = srfuserpub;
        this.srfuserpubDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSRFUserPub() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSRFUserPub();
        }
        return this.srfuserpub;
    }

    /**
     *  获取属性值[应用发布]是否修改
     */
    public boolean isSRFUserPubDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSRFUserPubDirty();
        }
        return this.srfuserpubDirtyFlag;
    }

    /**
     *  重置属性值[应用发布]
     */
    public void resetSRFUserPub() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSRFUserPub();
            return;
        }

        this.srfuserpubDirtyFlag = false;
        this.srfuserpub = null;
    }
    /**
     *  设置属性值[版本]
     *  @param udversion
     */
    public void setUDVersion(Integer udversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUDVersion(udversion);
            return;
        }
        this.udversion = udversion;
        this.udversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getUDVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUDVersion();
        }
        return this.udversion;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isUDVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUDVersionDirty();
        }
        return this.udversionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetUDVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUDVersion();
            return;
        }

        this.udversionDirtyFlag = false;
        this.udversion = null;
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
     *  设置属性值[用户数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel
     *  @param userdr
     */
    public void setUserDR(Integer userdr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDR(userdr);
            return;
        }
        this.userdr = userdr;
        this.userdrDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据类型]代码表：net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel
     */
    public Integer getUserDR() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDR();
        }
        return this.userdr;
    }

    /**
     *  获取属性值[用户数据类型]是否修改
     */
    public boolean isUserDRDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDRDirty();
        }
        return this.userdrDirtyFlag;
    }

    /**
     *  重置属性值[用户数据类型]
     */
    public void resetUserDR() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDR();
            return;
        }

        this.userdrDirtyFlag = false;
        this.userdr = null;
    }
    /**
     *  设置属性值[数据对象能力标识]
     *  @param userroledataid
     */
    public void setUserRoleDataId(String userroledataid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDataId(userroledataid);
            return;
        }
        if(userroledataid!=null) {
            userroledataid = StringHelper.trimRight(userroledataid);
            if(userroledataid.length()==0) {
                userroledataid = null;
            }
        }
        this.userroledataid = userroledataid;
        this.userroledataidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据对象能力标识]
     */
    public String getUserRoleDataId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataId();
        }
        return this.userroledataid;
    }

    /**
     *  获取属性值[数据对象能力标识]是否修改
     */
    public boolean isUserRoleDataIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataIdDirty();
        }
        return this.userroledataidDirtyFlag;
    }

    /**
     *  重置属性值[数据对象能力标识]
     */
    public void resetUserRoleDataId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDataId();
            return;
        }

        this.userroledataidDirtyFlag = false;
        this.userroledataid = null;
    }
    /**
     *  设置属性值[能力名称]
     *  @param userroledataname
     */
    public void setUserRoleDataName(String userroledataname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDataName(userroledataname);
            return;
        }
        if(userroledataname!=null) {
            userroledataname = StringHelper.trimRight(userroledataname);
            if(userroledataname.length()==0) {
                userroledataname = null;
            }
        }
        this.userroledataname = userroledataname;
        this.userroledatanameDirtyFlag  = true;
    }

    /**
     *  获取属性值[能力名称]
     */
    public String getUserRoleDataName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataName();
        }
        return this.userroledataname;
    }

    /**
     *  获取属性值[能力名称]是否修改
     */
    public boolean isUserRoleDataNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataNameDirty();
        }
        return this.userroledatanameDirtyFlag;
    }

    /**
     *  重置属性值[能力名称]
     */
    public void resetUserRoleDataName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDataName();
            return;
        }

        this.userroledatanameDirtyFlag = false;
        this.userroledataname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserRoleDataBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserRoleDataBase et) {
        et.resetBCDR();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetDstOrgId();
        et.resetDstOrgName();
        et.resetDstOrgSectorId();
        et.resetDstOrgSectorName();
        et.resetDstSecBC();
        et.resetIsAllData();
        et.resetMemo();
        et.resetOrgDR();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetSecDR();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUDVersion();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDR();
        et.resetUserRoleDataId();
        et.resetUserRoleDataName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isBCDRDirty()) {
            params.put(FIELD_BCDR,getBCDR());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDEIdDirty()) {
            params.put(FIELD_DEID,getDEId());
        }
        if(!bDirtyOnly || isDENameDirty()) {
            params.put(FIELD_DENAME,getDEName());
        }
        if(!bDirtyOnly || isDstOrgIdDirty()) {
            params.put(FIELD_DSTORGID,getDstOrgId());
        }
        if(!bDirtyOnly || isDstOrgNameDirty()) {
            params.put(FIELD_DSTORGNAME,getDstOrgName());
        }
        if(!bDirtyOnly || isDstOrgSectorIdDirty()) {
            params.put(FIELD_DSTORGSECTORID,getDstOrgSectorId());
        }
        if(!bDirtyOnly || isDstOrgSectorNameDirty()) {
            params.put(FIELD_DSTORGSECTORNAME,getDstOrgSectorName());
        }
        if(!bDirtyOnly || isDstSecBCDirty()) {
            params.put(FIELD_DSTSECBC,getDstSecBC());
        }
        if(!bDirtyOnly || isIsAllDataDirty()) {
            params.put(FIELD_ISALLDATA,getIsAllData());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOrgDRDirty()) {
            params.put(FIELD_ORGDR,getOrgDR());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isReserver3Dirty()) {
            params.put(FIELD_RESERVER3,getReserver3());
        }
        if(!bDirtyOnly || isReserver4Dirty()) {
            params.put(FIELD_RESERVER4,getReserver4());
        }
        if(!bDirtyOnly || isSecDRDirty()) {
            params.put(FIELD_SECDR,getSecDR());
        }
        if(!bDirtyOnly || isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB,getSRFSysPub());
        }
        if(!bDirtyOnly || isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB,getSRFUserPub());
        }
        if(!bDirtyOnly || isUDVersionDirty()) {
            params.put(FIELD_UDVERSION,getUDVersion());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDRDirty()) {
            params.put(FIELD_USERDR,getUserDR());
        }
        if(!bDirtyOnly || isUserRoleDataIdDirty()) {
            params.put(FIELD_USERROLEDATAID,getUserRoleDataId());
        }
        if(!bDirtyOnly || isUserRoleDataNameDirty()) {
            params.put(FIELD_USERROLEDATANAME,getUserRoleDataName());
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

        return  UserRoleDataBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserRoleDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BCDR:
            return et.getBCDR();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DENAME:
            return et.getDEName();
        case INDEX_DSTORGID:
            return et.getDstOrgId();
        case INDEX_DSTORGNAME:
            return et.getDstOrgName();
        case INDEX_DSTORGSECTORID:
            return et.getDstOrgSectorId();
        case INDEX_DSTORGSECTORNAME:
            return et.getDstOrgSectorName();
        case INDEX_DSTSECBC:
            return et.getDstSecBC();
        case INDEX_ISALLDATA:
            return et.getIsAllData();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_ORGDR:
            return et.getOrgDR();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_SECDR:
            return et.getSecDR();
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub();
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub();
        case INDEX_UDVERSION:
            return et.getUDVersion();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDR:
            return et.getUserDR();
        case INDEX_USERROLEDATAID:
            return et.getUserRoleDataId();
        case INDEX_USERROLEDATANAME:
            return et.getUserRoleDataName();
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

        UserRoleDataBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserRoleDataBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_BCDR:
            et.setBCDR(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEID:
            et.setDEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DENAME:
            et.setDEName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSTORGID:
            et.setDstOrgId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSTORGNAME:
            et.setDstOrgName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSTORGSECTORID:
            et.setDstOrgSectorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSTORGSECTORNAME:
            et.setDstOrgSectorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSTSECBC:
            et.setDstSecBC(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISALLDATA:
            et.setIsAllData(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGDR:
            et.setOrgDR(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getStringValue(obj));
            return ;
        case INDEX_SECDR:
            et.setSecDR(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SRFSYSPUB:
            et.setSRFSysPub(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SRFUSERPUB:
            et.setSRFUserPub(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_UDVERSION:
            et.setUDVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDR:
            et.setUserDR(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_USERROLEDATAID:
            et.setUserRoleDataId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEDATANAME:
            et.setUserRoleDataName(DataObject.getStringValue(obj));
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

        return  UserRoleDataBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserRoleDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BCDR:
            return et.getBCDR()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DENAME:
            return et.getDEName()==null;
        case INDEX_DSTORGID:
            return et.getDstOrgId()==null;
        case INDEX_DSTORGNAME:
            return et.getDstOrgName()==null;
        case INDEX_DSTORGSECTORID:
            return et.getDstOrgSectorId()==null;
        case INDEX_DSTORGSECTORNAME:
            return et.getDstOrgSectorName()==null;
        case INDEX_DSTSECBC:
            return et.getDstSecBC()==null;
        case INDEX_ISALLDATA:
            return et.getIsAllData()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_ORGDR:
            return et.getOrgDR()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_SECDR:
            return et.getSecDR()==null;
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub()==null;
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub()==null;
        case INDEX_UDVERSION:
            return et.getUDVersion()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDR:
            return et.getUserDR()==null;
        case INDEX_USERROLEDATAID:
            return et.getUserRoleDataId()==null;
        case INDEX_USERROLEDATANAME:
            return et.getUserRoleDataName()==null;
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
        return  UserRoleDataBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserRoleDataBase et,int index) throws Exception {

        switch(index) {
        case INDEX_BCDR:
            return et.isBCDRDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DENAME:
            return et.isDENameDirty();
        case INDEX_DSTORGID:
            return et.isDstOrgIdDirty();
        case INDEX_DSTORGNAME:
            return et.isDstOrgNameDirty();
        case INDEX_DSTORGSECTORID:
            return et.isDstOrgSectorIdDirty();
        case INDEX_DSTORGSECTORNAME:
            return et.isDstOrgSectorNameDirty();
        case INDEX_DSTSECBC:
            return et.isDstSecBCDirty();
        case INDEX_ISALLDATA:
            return et.isIsAllDataDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_ORGDR:
            return et.isOrgDRDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_SECDR:
            return et.isSecDRDirty();
        case INDEX_SRFSYSPUB:
            return et.isSRFSysPubDirty();
        case INDEX_SRFUSERPUB:
            return et.isSRFUserPubDirty();
        case INDEX_UDVERSION:
            return et.isUDVersionDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDR:
            return et.isUserDRDirty();
        case INDEX_USERROLEDATAID:
            return et.isUserRoleDataIdDirty();
        case INDEX_USERROLEDATANAME:
            return et.isUserRoleDataNameDirty();
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
    private static  void fillJSONObject(UserRoleDataBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getBCDR()!=null) {
            JSONObjectHelper.put(json,"bcdr",getJSONValue(et.getBCDR()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            JSONObjectHelper.put(json,"deid",getJSONValue(et.getDEId()),false);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            JSONObjectHelper.put(json,"dename",getJSONValue(et.getDEName()),false);
        }
        if(bIncEmpty||et.getDstOrgId()!=null) {
            JSONObjectHelper.put(json,"dstorgid",getJSONValue(et.getDstOrgId()),false);
        }
        if(bIncEmpty||et.getDstOrgName()!=null) {
            JSONObjectHelper.put(json,"dstorgname",getJSONValue(et.getDstOrgName()),false);
        }
        if(bIncEmpty||et.getDstOrgSectorId()!=null) {
            JSONObjectHelper.put(json,"dstorgsectorid",getJSONValue(et.getDstOrgSectorId()),false);
        }
        if(bIncEmpty||et.getDstOrgSectorName()!=null) {
            JSONObjectHelper.put(json,"dstorgsectorname",getJSONValue(et.getDstOrgSectorName()),false);
        }
        if(bIncEmpty||et.getDstSecBC()!=null) {
            JSONObjectHelper.put(json,"dstsecbc",getJSONValue(et.getDstSecBC()),false);
        }
        if(bIncEmpty||et.getIsAllData()!=null) {
            JSONObjectHelper.put(json,"isalldata",getJSONValue(et.getIsAllData()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOrgDR()!=null) {
            JSONObjectHelper.put(json,"orgdr",getJSONValue(et.getOrgDR()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            JSONObjectHelper.put(json,"reserver3",getJSONValue(et.getReserver3()),false);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            JSONObjectHelper.put(json,"reserver4",getJSONValue(et.getReserver4()),false);
        }
        if(bIncEmpty||et.getSecDR()!=null) {
            JSONObjectHelper.put(json,"secdr",getJSONValue(et.getSecDR()),false);
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            JSONObjectHelper.put(json,"srfsyspub",getJSONValue(et.getSRFSysPub()),false);
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            JSONObjectHelper.put(json,"srfuserpub",getJSONValue(et.getSRFUserPub()),false);
        }
        if(bIncEmpty||et.getUDVersion()!=null) {
            JSONObjectHelper.put(json,"udversion",getJSONValue(et.getUDVersion()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserDR()!=null) {
            JSONObjectHelper.put(json,"userdr",getJSONValue(et.getUserDR()),false);
        }
        if(bIncEmpty||et.getUserRoleDataId()!=null) {
            JSONObjectHelper.put(json,"userroledataid",getJSONValue(et.getUserRoleDataId()),false);
        }
        if(bIncEmpty||et.getUserRoleDataName()!=null) {
            JSONObjectHelper.put(json,"userroledataname",getJSONValue(et.getUserRoleDataName()),false);
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
    private static void fillXmlNode(UserRoleDataBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getBCDR()!=null) {
            Object obj = et.getBCDR();
            node.setAttribute("BCDR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            Object obj = et.getDEId();
            node.setAttribute("DEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            Object obj = et.getDEName();
            node.setAttribute("DENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDstOrgId()!=null) {
            Object obj = et.getDstOrgId();
            node.setAttribute("DSTORGID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDstOrgName()!=null) {
            Object obj = et.getDstOrgName();
            node.setAttribute("DSTORGNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDstOrgSectorId()!=null) {
            Object obj = et.getDstOrgSectorId();
            node.setAttribute("DSTORGSECTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDstOrgSectorName()!=null) {
            Object obj = et.getDstOrgSectorName();
            node.setAttribute("DSTORGSECTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDstSecBC()!=null) {
            Object obj = et.getDstSecBC();
            node.setAttribute("DSTSECBC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsAllData()!=null) {
            Object obj = et.getIsAllData();
            node.setAttribute("ISALLDATA",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgDR()!=null) {
            Object obj = et.getOrgDR();
            node.setAttribute("ORGDR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            Object obj = et.getReserver3();
            node.setAttribute("RESERVER3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSecDR()!=null) {
            Object obj = et.getSecDR();
            node.setAttribute("SECDR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            Object obj = et.getSRFSysPub();
            node.setAttribute("SRFSYSPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            Object obj = et.getSRFUserPub();
            node.setAttribute("SRFUSERPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUDVersion()!=null) {
            Object obj = et.getUDVersion();
            node.setAttribute("UDVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDR()!=null) {
            Object obj = et.getUserDR();
            node.setAttribute("USERDR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUserRoleDataId()!=null) {
            Object obj = et.getUserRoleDataId();
            node.setAttribute("USERROLEDATAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleDataName()!=null) {
            Object obj = et.getUserRoleDataName();
            node.setAttribute("USERROLEDATANAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDataBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserRoleDataBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isBCDRDirty() && (bIncEmpty||et.getBCDR()!=null)) {
            dst.set(FIELD_BCDR,et.getBCDR());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDEIdDirty() && (bIncEmpty||et.getDEId()!=null)) {
            dst.set(FIELD_DEID,et.getDEId());
        }
        if(et.isDENameDirty() && (bIncEmpty||et.getDEName()!=null)) {
            dst.set(FIELD_DENAME,et.getDEName());
        }
        if(et.isDstOrgIdDirty() && (bIncEmpty||et.getDstOrgId()!=null)) {
            dst.set(FIELD_DSTORGID,et.getDstOrgId());
        }
        if(et.isDstOrgNameDirty() && (bIncEmpty||et.getDstOrgName()!=null)) {
            dst.set(FIELD_DSTORGNAME,et.getDstOrgName());
        }
        if(et.isDstOrgSectorIdDirty() && (bIncEmpty||et.getDstOrgSectorId()!=null)) {
            dst.set(FIELD_DSTORGSECTORID,et.getDstOrgSectorId());
        }
        if(et.isDstOrgSectorNameDirty() && (bIncEmpty||et.getDstOrgSectorName()!=null)) {
            dst.set(FIELD_DSTORGSECTORNAME,et.getDstOrgSectorName());
        }
        if(et.isDstSecBCDirty() && (bIncEmpty||et.getDstSecBC()!=null)) {
            dst.set(FIELD_DSTSECBC,et.getDstSecBC());
        }
        if(et.isIsAllDataDirty() && (bIncEmpty||et.getIsAllData()!=null)) {
            dst.set(FIELD_ISALLDATA,et.getIsAllData());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOrgDRDirty() && (bIncEmpty||et.getOrgDR()!=null)) {
            dst.set(FIELD_ORGDR,et.getOrgDR());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isReserver3Dirty() && (bIncEmpty||et.getReserver3()!=null)) {
            dst.set(FIELD_RESERVER3,et.getReserver3());
        }
        if(et.isReserver4Dirty() && (bIncEmpty||et.getReserver4()!=null)) {
            dst.set(FIELD_RESERVER4,et.getReserver4());
        }
        if(et.isSecDRDirty() && (bIncEmpty||et.getSecDR()!=null)) {
            dst.set(FIELD_SECDR,et.getSecDR());
        }
        if(et.isSRFSysPubDirty() && (bIncEmpty||et.getSRFSysPub()!=null)) {
            dst.set(FIELD_SRFSYSPUB,et.getSRFSysPub());
        }
        if(et.isSRFUserPubDirty() && (bIncEmpty||et.getSRFUserPub()!=null)) {
            dst.set(FIELD_SRFUSERPUB,et.getSRFUserPub());
        }
        if(et.isUDVersionDirty() && (bIncEmpty||et.getUDVersion()!=null)) {
            dst.set(FIELD_UDVERSION,et.getUDVersion());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDRDirty() && (bIncEmpty||et.getUserDR()!=null)) {
            dst.set(FIELD_USERDR,et.getUserDR());
        }
        if(et.isUserRoleDataIdDirty() && (bIncEmpty||et.getUserRoleDataId()!=null)) {
            dst.set(FIELD_USERROLEDATAID,et.getUserRoleDataId());
        }
        if(et.isUserRoleDataNameDirty() && (bIncEmpty||et.getUserRoleDataName()!=null)) {
            dst.set(FIELD_USERROLEDATANAME,et.getUserRoleDataName());
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
        return  UserRoleDataBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserRoleDataBase et,int index) throws Exception {
        switch(index) {
        case INDEX_BCDR:
            et.resetBCDR();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DEID:
            et.resetDEId();
            return true;
        case INDEX_DENAME:
            et.resetDEName();
            return true;
        case INDEX_DSTORGID:
            et.resetDstOrgId();
            return true;
        case INDEX_DSTORGNAME:
            et.resetDstOrgName();
            return true;
        case INDEX_DSTORGSECTORID:
            et.resetDstOrgSectorId();
            return true;
        case INDEX_DSTORGSECTORNAME:
            et.resetDstOrgSectorName();
            return true;
        case INDEX_DSTSECBC:
            et.resetDstSecBC();
            return true;
        case INDEX_ISALLDATA:
            et.resetIsAllData();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_ORGDR:
            et.resetOrgDR();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_RESERVER3:
            et.resetReserver3();
            return true;
        case INDEX_RESERVER4:
            et.resetReserver4();
            return true;
        case INDEX_SECDR:
            et.resetSecDR();
            return true;
        case INDEX_SRFSYSPUB:
            et.resetSRFSysPub();
            return true;
        case INDEX_SRFUSERPUB:
            et.resetSRFUserPub();
            return true;
        case INDEX_UDVERSION:
            et.resetUDVersion();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDR:
            et.resetUserDR();
            return true;
        case INDEX_USERROLEDATAID:
            et.resetUserRoleDataId();
            return true;
        case INDEX_USERROLEDATANAME:
            et.resetUserRoleDataName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objDELock = new Integer(1);
    private net.ibizsys.psrt.srv.demodel.entity.DataEntity de = null;
    /**
    * 获取父数据 实体
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.demodel.entity.DataEntity getDE() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDE();
        }

        if(this.getDEId()==null)
            return null;
        synchronized(this.objDELock) {
            if(this.de!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDEId(),de.getDEId())!=0) {
                    this.de = null;
                }
            }


            if(this.de==null) {
                net.ibizsys.psrt.srv.demodel.entity.DataEntity de = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
                de.setDEId(this.getDEId());
                net.ibizsys.psrt.srv.demodel.service.DataEntityService service = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class,this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }

    private Integer objDstOrgSectorLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.OrgSector dstorgsector = null;
    /**
    * 获取父数据 组织部门
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.OrgSector getDstOrgSector() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrgSector();
        }

        if(this.getDstOrgSectorId()==null)
            return null;
        synchronized(this.objDstOrgSectorLock) {
            if(this.dstorgsector!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDstOrgSectorId(),dstorgsector.getOrgSectorId())!=0) {
                    this.dstorgsector = null;
                }
            }


            if(this.dstorgsector==null) {
                net.ibizsys.psrt.srv.common.entity.OrgSector dstorgsector = new net.ibizsys.psrt.srv.common.entity.OrgSector();
                dstorgsector.setOrgSectorId(this.getDstOrgSectorId());
                net.ibizsys.psrt.srv.common.service.OrgSectorService service = (net.ibizsys.psrt.srv.common.service.OrgSectorService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.OrgSectorService.class,this.getSessionFactory());
                service.autoGet(dstorgsector);
                this.dstorgsector = dstorgsector;
            }
            return this.dstorgsector;
        }
    }

    private Integer objDstOrgLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.Org dstorg = null;
    /**
    * 获取父数据 组织机构
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.Org getDstOrg() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDstOrg();
        }

        if(this.getDstOrgId()==null)
            return null;
        synchronized(this.objDstOrgLock) {
            if(this.dstorg!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDstOrgId(),dstorg.getOrgId())!=0) {
                    this.dstorg = null;
                }
            }


            if(this.dstorg==null) {
                net.ibizsys.psrt.srv.common.entity.Org dstorg = new net.ibizsys.psrt.srv.common.entity.Org();
                dstorg.setOrgId(this.getDstOrgId());
                net.ibizsys.psrt.srv.common.service.OrgService service = (net.ibizsys.psrt.srv.common.service.OrgService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.OrgService.class,this.getSessionFactory());
                service.autoGet(dstorg);
                this.dstorg = dstorg;
            }
            return this.dstorg;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private UserRoleDataBase getProxyEntity() {
        return this.proxyUserRoleDataBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDataBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserRoleDataBase) {
            this.proxyUserRoleDataBase = (UserRoleDataBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDataService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}