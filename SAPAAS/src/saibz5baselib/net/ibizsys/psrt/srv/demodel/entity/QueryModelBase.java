/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.entity;


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
 * 实体[QueryModel] 数据对象基类
 */
public abstract class QueryModelBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(QueryModelBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[查询模型_相关实体]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[数据对象]
     */
    public final static String FIELD_DENAME = "DENAME";
    /**
     * 属性[分组模型]
     */
    public final static String FIELD_GROUPMODEL = "GROUPMODEL";
    /**
     * 属性[直接代码]
     */
    public final static String FIELD_ISRAWMODE = "ISRAWMODE";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[版本]
     */
    public final static String FIELD_QMVERSION = "QMVERSION";
    /**
     * 属性[查询条件]
     */
    public final static String FIELD_QUERYCOND = "QUERYCOND";
    /**
     * 属性[查询字段]
     */
    public final static String FIELD_QUERYFIELD = "QUERYFIELD";
    /**
     * 属性[查询模型]
     */
    public final static String FIELD_QUERYMODEL = "QUERYMODEL";
    /**
     * 属性[实体查询模型标识]
     */
    public final static String FIELD_QUERYMODELID = "QUERYMODELID";
    /**
     * 属性[实体查询模型名称]
     */
    public final static String FIELD_QUERYMODELNAME = "QUERYMODELNAME";
    /**
     * 属性[查询对象]
     */
    public final static String FIELD_QUERYOBJECT = "QUERYOBJECT";
    /**
     * 属性[查询参数]
     */
    public final static String FIELD_QUERYPARAM = "QUERYPARAM";
    /**
     * 属性[查询SQL]
     */
    public final static String FIELD_QUERYSQL = "QUERYSQL";
    /**
     * 属性[查询模式]
     */
    public final static String FIELD_SELECTMODE = "SELECTMODE";
    /**
     * 属性[查询排序信息]
     */
    public final static String FIELD_SELECTORDER = "SELECTORDER";
    /**
     * 属性[框架发布]
     */
    public final static String FIELD_SRFSYSPUB = "SRFSYSPUB";
    /**
     * 属性[应用发布]
     */
    public final static String FIELD_SRFUSERPUB = "SRFUSERPUB";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DEID = 2;
    private final static int INDEX_DENAME = 3;
    private final static int INDEX_GROUPMODEL = 4;
    private final static int INDEX_ISRAWMODE = 5;
    private final static int INDEX_MEMO = 6;
    private final static int INDEX_QMVERSION = 7;
    private final static int INDEX_QUERYCOND = 8;
    private final static int INDEX_QUERYFIELD = 9;
    private final static int INDEX_QUERYMODEL = 10;
    private final static int INDEX_QUERYMODELID = 11;
    private final static int INDEX_QUERYMODELNAME = 12;
    private final static int INDEX_QUERYOBJECT = 13;
    private final static int INDEX_QUERYPARAM = 14;
    private final static int INDEX_QUERYSQL = 15;
    private final static int INDEX_SELECTMODE = 16;
    private final static int INDEX_SELECTORDER = 17;
    private final static int INDEX_SRFSYSPUB = 18;
    private final static int INDEX_SRFUSERPUB = 19;
    private final static int INDEX_UPDATEDATE = 20;
    private final static int INDEX_UPDATEMAN = 21;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DENAME, INDEX_DENAME);
        fieldIndexMap.put( FIELD_GROUPMODEL, INDEX_GROUPMODEL);
        fieldIndexMap.put( FIELD_ISRAWMODE, INDEX_ISRAWMODE);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_QMVERSION, INDEX_QMVERSION);
        fieldIndexMap.put( FIELD_QUERYCOND, INDEX_QUERYCOND);
        fieldIndexMap.put( FIELD_QUERYFIELD, INDEX_QUERYFIELD);
        fieldIndexMap.put( FIELD_QUERYMODEL, INDEX_QUERYMODEL);
        fieldIndexMap.put( FIELD_QUERYMODELID, INDEX_QUERYMODELID);
        fieldIndexMap.put( FIELD_QUERYMODELNAME, INDEX_QUERYMODELNAME);
        fieldIndexMap.put( FIELD_QUERYOBJECT, INDEX_QUERYOBJECT);
        fieldIndexMap.put( FIELD_QUERYPARAM, INDEX_QUERYPARAM);
        fieldIndexMap.put( FIELD_QUERYSQL, INDEX_QUERYSQL);
        fieldIndexMap.put( FIELD_SELECTMODE, INDEX_SELECTMODE);
        fieldIndexMap.put( FIELD_SELECTORDER, INDEX_SELECTORDER);
        fieldIndexMap.put( FIELD_SRFSYSPUB, INDEX_SRFSYSPUB);
        fieldIndexMap.put( FIELD_SRFUSERPUB, INDEX_SRFUSERPUB);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private QueryModelBase proxyQueryModelBase = null;
    public QueryModelBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean groupmodelDirtyFlag = false;
    private boolean israwmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean qmversionDirtyFlag = false;
    private boolean querycondDirtyFlag = false;
    private boolean queryfieldDirtyFlag = false;
    private boolean querymodelDirtyFlag = false;
    private boolean querymodelidDirtyFlag = false;
    private boolean querymodelnameDirtyFlag = false;
    private boolean queryobjectDirtyFlag = false;
    private boolean queryparamDirtyFlag = false;
    private boolean querysqlDirtyFlag = false;
    private boolean selectmodeDirtyFlag = false;
    private boolean selectorderDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="groupmodel")
    private String groupmodel;
    @Column(name="israwmode")
    private Integer israwmode;
    @Column(name="memo")
    private String memo;
    @Column(name="qmversion")
    private Integer qmversion;
    @Column(name="querycond")
    private String querycond;
    @Column(name="queryfield")
    private String queryfield;
    @Column(name="querymodel")
    private String querymodel;
    @Column(name="querymodelid")
    private String querymodelid;
    @Column(name="querymodelname")
    private String querymodelname;
    @Column(name="queryobject")
    private String queryobject;
    @Column(name="queryparam")
    private String queryparam;
    @Column(name="querysql")
    private String querysql;
    @Column(name="selectmode")
    private String selectmode;
    @Column(name="selectorder")
    private String selectorder;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


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
     *  设置属性值[查询模型_相关实体]
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
     *  获取属性值[查询模型_相关实体]
     */
    public String getDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    /**
     *  获取属性值[查询模型_相关实体]是否修改
     */
    public boolean isDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    /**
     *  重置属性值[查询模型_相关实体]
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
     *  设置属性值[分组模型]
     *  @param groupmodel
     */
    public void setGroupModel(String groupmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setGroupModel(groupmodel);
            return;
        }
        if(groupmodel!=null) {
            groupmodel = StringHelper.trimRight(groupmodel);
            if(groupmodel.length()==0) {
                groupmodel = null;
            }
        }
        this.groupmodel = groupmodel;
        this.groupmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[分组模型]
     */
    public String getGroupModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getGroupModel();
        }
        return this.groupmodel;
    }

    /**
     *  获取属性值[分组模型]是否修改
     */
    public boolean isGroupModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isGroupModelDirty();
        }
        return this.groupmodelDirtyFlag;
    }

    /**
     *  重置属性值[分组模型]
     */
    public void resetGroupModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetGroupModel();
            return;
        }

        this.groupmodelDirtyFlag = false;
        this.groupmodel = null;
    }
    /**
     *  设置属性值[直接代码]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param israwmode
     */
    public void setIsRawMode(Integer israwmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsRawMode(israwmode);
            return;
        }
        this.israwmode = israwmode;
        this.israwmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[直接代码]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsRawMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsRawMode();
        }
        return this.israwmode;
    }

    /**
     *  获取属性值[直接代码]是否修改
     */
    public boolean isIsRawModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsRawModeDirty();
        }
        return this.israwmodeDirtyFlag;
    }

    /**
     *  重置属性值[直接代码]
     */
    public void resetIsRawMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsRawMode();
            return;
        }

        this.israwmodeDirtyFlag = false;
        this.israwmode = null;
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
     *  设置属性值[版本]
     *  @param qmversion
     */
    public void setQMVersion(Integer qmversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQMVersion(qmversion);
            return;
        }
        this.qmversion = qmversion;
        this.qmversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[版本]
     */
    public Integer getQMVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQMVersion();
        }
        return this.qmversion;
    }

    /**
     *  获取属性值[版本]是否修改
     */
    public boolean isQMVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQMVersionDirty();
        }
        return this.qmversionDirtyFlag;
    }

    /**
     *  重置属性值[版本]
     */
    public void resetQMVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQMVersion();
            return;
        }

        this.qmversionDirtyFlag = false;
        this.qmversion = null;
    }
    /**
     *  设置属性值[查询条件]
     *  @param querycond
     */
    public void setQueryCond(String querycond) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryCond(querycond);
            return;
        }
        if(querycond!=null) {
            querycond = StringHelper.trimRight(querycond);
            if(querycond.length()==0) {
                querycond = null;
            }
        }
        this.querycond = querycond;
        this.querycondDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询条件]
     */
    public String getQueryCond() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryCond();
        }
        return this.querycond;
    }

    /**
     *  获取属性值[查询条件]是否修改
     */
    public boolean isQueryCondDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryCondDirty();
        }
        return this.querycondDirtyFlag;
    }

    /**
     *  重置属性值[查询条件]
     */
    public void resetQueryCond() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryCond();
            return;
        }

        this.querycondDirtyFlag = false;
        this.querycond = null;
    }
    /**
     *  设置属性值[查询字段]
     *  @param queryfield
     */
    public void setQueryField(String queryfield) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryField(queryfield);
            return;
        }
        if(queryfield!=null) {
            queryfield = StringHelper.trimRight(queryfield);
            if(queryfield.length()==0) {
                queryfield = null;
            }
        }
        this.queryfield = queryfield;
        this.queryfieldDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询字段]
     */
    public String getQueryField() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryField();
        }
        return this.queryfield;
    }

    /**
     *  获取属性值[查询字段]是否修改
     */
    public boolean isQueryFieldDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryFieldDirty();
        }
        return this.queryfieldDirtyFlag;
    }

    /**
     *  重置属性值[查询字段]
     */
    public void resetQueryField() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryField();
            return;
        }

        this.queryfieldDirtyFlag = false;
        this.queryfield = null;
    }
    /**
     *  设置属性值[查询模型]
     *  @param querymodel
     */
    public void setQueryModel(String querymodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryModel(querymodel);
            return;
        }
        if(querymodel!=null) {
            querymodel = StringHelper.trimRight(querymodel);
            if(querymodel.length()==0) {
                querymodel = null;
            }
        }
        this.querymodel = querymodel;
        this.querymodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询模型]
     */
    public String getQueryModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryModel();
        }
        return this.querymodel;
    }

    /**
     *  获取属性值[查询模型]是否修改
     */
    public boolean isQueryModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryModelDirty();
        }
        return this.querymodelDirtyFlag;
    }

    /**
     *  重置属性值[查询模型]
     */
    public void resetQueryModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryModel();
            return;
        }

        this.querymodelDirtyFlag = false;
        this.querymodel = null;
    }
    /**
     *  设置属性值[实体查询模型标识]
     *  @param querymodelid
     */
    public void setQueryModelId(String querymodelid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryModelId(querymodelid);
            return;
        }
        if(querymodelid!=null) {
            querymodelid = StringHelper.trimRight(querymodelid);
            if(querymodelid.length()==0) {
                querymodelid = null;
            }
        }
        this.querymodelid = querymodelid;
        this.querymodelidDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体查询模型标识]
     */
    public String getQueryModelId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryModelId();
        }
        return this.querymodelid;
    }

    /**
     *  获取属性值[实体查询模型标识]是否修改
     */
    public boolean isQueryModelIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryModelIdDirty();
        }
        return this.querymodelidDirtyFlag;
    }

    /**
     *  重置属性值[实体查询模型标识]
     */
    public void resetQueryModelId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryModelId();
            return;
        }

        this.querymodelidDirtyFlag = false;
        this.querymodelid = null;
    }
    /**
     *  设置属性值[实体查询模型名称]
     *  @param querymodelname
     */
    public void setQueryModelName(String querymodelname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryModelName(querymodelname);
            return;
        }
        if(querymodelname!=null) {
            querymodelname = StringHelper.trimRight(querymodelname);
            if(querymodelname.length()==0) {
                querymodelname = null;
            }
        }
        this.querymodelname = querymodelname;
        this.querymodelnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体查询模型名称]
     */
    public String getQueryModelName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryModelName();
        }
        return this.querymodelname;
    }

    /**
     *  获取属性值[实体查询模型名称]是否修改
     */
    public boolean isQueryModelNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryModelNameDirty();
        }
        return this.querymodelnameDirtyFlag;
    }

    /**
     *  重置属性值[实体查询模型名称]
     */
    public void resetQueryModelName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryModelName();
            return;
        }

        this.querymodelnameDirtyFlag = false;
        this.querymodelname = null;
    }
    /**
     *  设置属性值[查询对象]
     *  @param queryobject
     */
    public void setQueryObject(String queryobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryObject(queryobject);
            return;
        }
        if(queryobject!=null) {
            queryobject = StringHelper.trimRight(queryobject);
            if(queryobject.length()==0) {
                queryobject = null;
            }
        }
        this.queryobject = queryobject;
        this.queryobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询对象]
     */
    public String getQueryObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryObject();
        }
        return this.queryobject;
    }

    /**
     *  获取属性值[查询对象]是否修改
     */
    public boolean isQueryObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryObjectDirty();
        }
        return this.queryobjectDirtyFlag;
    }

    /**
     *  重置属性值[查询对象]
     */
    public void resetQueryObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryObject();
            return;
        }

        this.queryobjectDirtyFlag = false;
        this.queryobject = null;
    }
    /**
     *  设置属性值[查询参数]
     *  @param queryparam
     */
    public void setQueryParam(String queryparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQueryParam(queryparam);
            return;
        }
        if(queryparam!=null) {
            queryparam = StringHelper.trimRight(queryparam);
            if(queryparam.length()==0) {
                queryparam = null;
            }
        }
        this.queryparam = queryparam;
        this.queryparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询参数]
     */
    public String getQueryParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQueryParam();
        }
        return this.queryparam;
    }

    /**
     *  获取属性值[查询参数]是否修改
     */
    public boolean isQueryParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQueryParamDirty();
        }
        return this.queryparamDirtyFlag;
    }

    /**
     *  重置属性值[查询参数]
     */
    public void resetQueryParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQueryParam();
            return;
        }

        this.queryparamDirtyFlag = false;
        this.queryparam = null;
    }
    /**
     *  设置属性值[查询SQL]
     *  @param querysql
     */
    public void setQuerySQL(String querysql) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setQuerySQL(querysql);
            return;
        }
        if(querysql!=null) {
            querysql = StringHelper.trimRight(querysql);
            if(querysql.length()==0) {
                querysql = null;
            }
        }
        this.querysql = querysql;
        this.querysqlDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询SQL]
     */
    public String getQuerySQL() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getQuerySQL();
        }
        return this.querysql;
    }

    /**
     *  获取属性值[查询SQL]是否修改
     */
    public boolean isQuerySQLDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isQuerySQLDirty();
        }
        return this.querysqlDirtyFlag;
    }

    /**
     *  重置属性值[查询SQL]
     */
    public void resetQuerySQL() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetQuerySQL();
            return;
        }

        this.querysqlDirtyFlag = false;
        this.querysql = null;
    }
    /**
     *  设置属性值[查询模式]
     *  @param selectmode
     */
    public void setSelectMode(String selectmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSelectMode(selectmode);
            return;
        }
        if(selectmode!=null) {
            selectmode = StringHelper.trimRight(selectmode);
            if(selectmode.length()==0) {
                selectmode = null;
            }
        }
        this.selectmode = selectmode;
        this.selectmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询模式]
     */
    public String getSelectMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSelectMode();
        }
        return this.selectmode;
    }

    /**
     *  获取属性值[查询模式]是否修改
     */
    public boolean isSelectModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSelectModeDirty();
        }
        return this.selectmodeDirtyFlag;
    }

    /**
     *  重置属性值[查询模式]
     */
    public void resetSelectMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSelectMode();
            return;
        }

        this.selectmodeDirtyFlag = false;
        this.selectmode = null;
    }
    /**
     *  设置属性值[查询排序信息]
     *  @param selectorder
     */
    public void setSelectOrder(String selectorder) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSelectOrder(selectorder);
            return;
        }
        if(selectorder!=null) {
            selectorder = StringHelper.trimRight(selectorder);
            if(selectorder.length()==0) {
                selectorder = null;
            }
        }
        this.selectorder = selectorder;
        this.selectorderDirtyFlag  = true;
    }

    /**
     *  获取属性值[查询排序信息]
     */
    public String getSelectOrder() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSelectOrder();
        }
        return this.selectorder;
    }

    /**
     *  获取属性值[查询排序信息]是否修改
     */
    public boolean isSelectOrderDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSelectOrderDirty();
        }
        return this.selectorderDirtyFlag;
    }

    /**
     *  重置属性值[查询排序信息]
     */
    public void resetSelectOrder() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSelectOrder();
            return;
        }

        this.selectorderDirtyFlag = false;
        this.selectorder = null;
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
        QueryModelBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(QueryModelBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetGroupModel();
        et.resetIsRawMode();
        et.resetMemo();
        et.resetQMVersion();
        et.resetQueryCond();
        et.resetQueryField();
        et.resetQueryModel();
        et.resetQueryModelId();
        et.resetQueryModelName();
        et.resetQueryObject();
        et.resetQueryParam();
        et.resetQuerySQL();
        et.resetSelectMode();
        et.resetSelectOrder();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUpdateDate();
        et.resetUpdateMan();
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
        if(!bDirtyOnly || isDEIdDirty()) {
            params.put(FIELD_DEID,getDEId());
        }
        if(!bDirtyOnly || isDENameDirty()) {
            params.put(FIELD_DENAME,getDEName());
        }
        if(!bDirtyOnly || isGroupModelDirty()) {
            params.put(FIELD_GROUPMODEL,getGroupModel());
        }
        if(!bDirtyOnly || isIsRawModeDirty()) {
            params.put(FIELD_ISRAWMODE,getIsRawMode());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isQMVersionDirty()) {
            params.put(FIELD_QMVERSION,getQMVersion());
        }
        if(!bDirtyOnly || isQueryCondDirty()) {
            params.put(FIELD_QUERYCOND,getQueryCond());
        }
        if(!bDirtyOnly || isQueryFieldDirty()) {
            params.put(FIELD_QUERYFIELD,getQueryField());
        }
        if(!bDirtyOnly || isQueryModelDirty()) {
            params.put(FIELD_QUERYMODEL,getQueryModel());
        }
        if(!bDirtyOnly || isQueryModelIdDirty()) {
            params.put(FIELD_QUERYMODELID,getQueryModelId());
        }
        if(!bDirtyOnly || isQueryModelNameDirty()) {
            params.put(FIELD_QUERYMODELNAME,getQueryModelName());
        }
        if(!bDirtyOnly || isQueryObjectDirty()) {
            params.put(FIELD_QUERYOBJECT,getQueryObject());
        }
        if(!bDirtyOnly || isQueryParamDirty()) {
            params.put(FIELD_QUERYPARAM,getQueryParam());
        }
        if(!bDirtyOnly || isQuerySQLDirty()) {
            params.put(FIELD_QUERYSQL,getQuerySQL());
        }
        if(!bDirtyOnly || isSelectModeDirty()) {
            params.put(FIELD_SELECTMODE,getSelectMode());
        }
        if(!bDirtyOnly || isSelectOrderDirty()) {
            params.put(FIELD_SELECTORDER,getSelectOrder());
        }
        if(!bDirtyOnly || isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB,getSRFSysPub());
        }
        if(!bDirtyOnly || isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB,getSRFUserPub());
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

        return  QueryModelBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(QueryModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DENAME:
            return et.getDEName();
        case INDEX_GROUPMODEL:
            return et.getGroupModel();
        case INDEX_ISRAWMODE:
            return et.getIsRawMode();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_QMVERSION:
            return et.getQMVersion();
        case INDEX_QUERYCOND:
            return et.getQueryCond();
        case INDEX_QUERYFIELD:
            return et.getQueryField();
        case INDEX_QUERYMODEL:
            return et.getQueryModel();
        case INDEX_QUERYMODELID:
            return et.getQueryModelId();
        case INDEX_QUERYMODELNAME:
            return et.getQueryModelName();
        case INDEX_QUERYOBJECT:
            return et.getQueryObject();
        case INDEX_QUERYPARAM:
            return et.getQueryParam();
        case INDEX_QUERYSQL:
            return et.getQuerySQL();
        case INDEX_SELECTMODE:
            return et.getSelectMode();
        case INDEX_SELECTORDER:
            return et.getSelectOrder();
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub();
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub();
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

        QueryModelBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(QueryModelBase et,int index,Object obj) throws Exception {
        switch(index) {
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
        case INDEX_GROUPMODEL:
            et.setGroupModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISRAWMODE:
            et.setIsRawMode(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_QMVERSION:
            et.setQMVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_QUERYCOND:
            et.setQueryCond(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYFIELD:
            et.setQueryField(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYMODEL:
            et.setQueryModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYMODELID:
            et.setQueryModelId(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYMODELNAME:
            et.setQueryModelName(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYOBJECT:
            et.setQueryObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYPARAM:
            et.setQueryParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_QUERYSQL:
            et.setQuerySQL(DataObject.getStringValue(obj));
            return ;
        case INDEX_SELECTMODE:
            et.setSelectMode(DataObject.getStringValue(obj));
            return ;
        case INDEX_SELECTORDER:
            et.setSelectOrder(DataObject.getStringValue(obj));
            return ;
        case INDEX_SRFSYSPUB:
            et.setSRFSysPub(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SRFUSERPUB:
            et.setSRFUserPub(DataObject.getIntegerValue(obj));
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

        return  QueryModelBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(QueryModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DENAME:
            return et.getDEName()==null;
        case INDEX_GROUPMODEL:
            return et.getGroupModel()==null;
        case INDEX_ISRAWMODE:
            return et.getIsRawMode()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_QMVERSION:
            return et.getQMVersion()==null;
        case INDEX_QUERYCOND:
            return et.getQueryCond()==null;
        case INDEX_QUERYFIELD:
            return et.getQueryField()==null;
        case INDEX_QUERYMODEL:
            return et.getQueryModel()==null;
        case INDEX_QUERYMODELID:
            return et.getQueryModelId()==null;
        case INDEX_QUERYMODELNAME:
            return et.getQueryModelName()==null;
        case INDEX_QUERYOBJECT:
            return et.getQueryObject()==null;
        case INDEX_QUERYPARAM:
            return et.getQueryParam()==null;
        case INDEX_QUERYSQL:
            return et.getQuerySQL()==null;
        case INDEX_SELECTMODE:
            return et.getSelectMode()==null;
        case INDEX_SELECTORDER:
            return et.getSelectOrder()==null;
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub()==null;
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub()==null;
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
        return  QueryModelBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(QueryModelBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DENAME:
            return et.isDENameDirty();
        case INDEX_GROUPMODEL:
            return et.isGroupModelDirty();
        case INDEX_ISRAWMODE:
            return et.isIsRawModeDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_QMVERSION:
            return et.isQMVersionDirty();
        case INDEX_QUERYCOND:
            return et.isQueryCondDirty();
        case INDEX_QUERYFIELD:
            return et.isQueryFieldDirty();
        case INDEX_QUERYMODEL:
            return et.isQueryModelDirty();
        case INDEX_QUERYMODELID:
            return et.isQueryModelIdDirty();
        case INDEX_QUERYMODELNAME:
            return et.isQueryModelNameDirty();
        case INDEX_QUERYOBJECT:
            return et.isQueryObjectDirty();
        case INDEX_QUERYPARAM:
            return et.isQueryParamDirty();
        case INDEX_QUERYSQL:
            return et.isQuerySQLDirty();
        case INDEX_SELECTMODE:
            return et.isSelectModeDirty();
        case INDEX_SELECTORDER:
            return et.isSelectOrderDirty();
        case INDEX_SRFSYSPUB:
            return et.isSRFSysPubDirty();
        case INDEX_SRFUSERPUB:
            return et.isSRFUserPubDirty();
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
    private static  void fillJSONObject(QueryModelBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getGroupModel()!=null) {
            JSONObjectHelper.put(json,"groupmodel",getJSONValue(et.getGroupModel()),false);
        }
        if(bIncEmpty||et.getIsRawMode()!=null) {
            JSONObjectHelper.put(json,"israwmode",getJSONValue(et.getIsRawMode()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getQMVersion()!=null) {
            JSONObjectHelper.put(json,"qmversion",getJSONValue(et.getQMVersion()),false);
        }
        if(bIncEmpty||et.getQueryCond()!=null) {
            JSONObjectHelper.put(json,"querycond",getJSONValue(et.getQueryCond()),false);
        }
        if(bIncEmpty||et.getQueryField()!=null) {
            JSONObjectHelper.put(json,"queryfield",getJSONValue(et.getQueryField()),false);
        }
        if(bIncEmpty||et.getQueryModel()!=null) {
            JSONObjectHelper.put(json,"querymodel",getJSONValue(et.getQueryModel()),false);
        }
        if(bIncEmpty||et.getQueryModelId()!=null) {
            JSONObjectHelper.put(json,"querymodelid",getJSONValue(et.getQueryModelId()),false);
        }
        if(bIncEmpty||et.getQueryModelName()!=null) {
            JSONObjectHelper.put(json,"querymodelname",getJSONValue(et.getQueryModelName()),false);
        }
        if(bIncEmpty||et.getQueryObject()!=null) {
            JSONObjectHelper.put(json,"queryobject",getJSONValue(et.getQueryObject()),false);
        }
        if(bIncEmpty||et.getQueryParam()!=null) {
            JSONObjectHelper.put(json,"queryparam",getJSONValue(et.getQueryParam()),false);
        }
        if(bIncEmpty||et.getQuerySQL()!=null) {
            JSONObjectHelper.put(json,"querysql",getJSONValue(et.getQuerySQL()),false);
        }
        if(bIncEmpty||et.getSelectMode()!=null) {
            JSONObjectHelper.put(json,"selectmode",getJSONValue(et.getSelectMode()),false);
        }
        if(bIncEmpty||et.getSelectOrder()!=null) {
            JSONObjectHelper.put(json,"selectorder",getJSONValue(et.getSelectOrder()),false);
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            JSONObjectHelper.put(json,"srfsyspub",getJSONValue(et.getSRFSysPub()),false);
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            JSONObjectHelper.put(json,"srfuserpub",getJSONValue(et.getSRFUserPub()),false);
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
    private static void fillXmlNode(QueryModelBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getGroupModel()!=null) {
            Object obj = et.getGroupModel();
            node.setAttribute("GROUPMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsRawMode()!=null) {
            Object obj = et.getIsRawMode();
            node.setAttribute("ISRAWMODE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQMVersion()!=null) {
            Object obj = et.getQMVersion();
            node.setAttribute("QMVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getQueryCond()!=null) {
            Object obj = et.getQueryCond();
            node.setAttribute("QUERYCOND",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryField()!=null) {
            Object obj = et.getQueryField();
            node.setAttribute("QUERYFIELD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryModel()!=null) {
            Object obj = et.getQueryModel();
            node.setAttribute("QUERYMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryModelId()!=null) {
            Object obj = et.getQueryModelId();
            node.setAttribute("QUERYMODELID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryModelName()!=null) {
            Object obj = et.getQueryModelName();
            node.setAttribute("QUERYMODELNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryObject()!=null) {
            Object obj = et.getQueryObject();
            node.setAttribute("QUERYOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQueryParam()!=null) {
            Object obj = et.getQueryParam();
            node.setAttribute("QUERYPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getQuerySQL()!=null) {
            Object obj = et.getQuerySQL();
            node.setAttribute("QUERYSQL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSelectMode()!=null) {
            Object obj = et.getSelectMode();
            node.setAttribute("SELECTMODE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSelectOrder()!=null) {
            Object obj = et.getSelectOrder();
            node.setAttribute("SELECTORDER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            Object obj = et.getSRFSysPub();
            node.setAttribute("SRFSYSPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            Object obj = et.getSRFUserPub();
            node.setAttribute("SRFUSERPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        QueryModelBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(QueryModelBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isGroupModelDirty() && (bIncEmpty||et.getGroupModel()!=null)) {
            dst.set(FIELD_GROUPMODEL,et.getGroupModel());
        }
        if(et.isIsRawModeDirty() && (bIncEmpty||et.getIsRawMode()!=null)) {
            dst.set(FIELD_ISRAWMODE,et.getIsRawMode());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isQMVersionDirty() && (bIncEmpty||et.getQMVersion()!=null)) {
            dst.set(FIELD_QMVERSION,et.getQMVersion());
        }
        if(et.isQueryCondDirty() && (bIncEmpty||et.getQueryCond()!=null)) {
            dst.set(FIELD_QUERYCOND,et.getQueryCond());
        }
        if(et.isQueryFieldDirty() && (bIncEmpty||et.getQueryField()!=null)) {
            dst.set(FIELD_QUERYFIELD,et.getQueryField());
        }
        if(et.isQueryModelDirty() && (bIncEmpty||et.getQueryModel()!=null)) {
            dst.set(FIELD_QUERYMODEL,et.getQueryModel());
        }
        if(et.isQueryModelIdDirty() && (bIncEmpty||et.getQueryModelId()!=null)) {
            dst.set(FIELD_QUERYMODELID,et.getQueryModelId());
        }
        if(et.isQueryModelNameDirty() && (bIncEmpty||et.getQueryModelName()!=null)) {
            dst.set(FIELD_QUERYMODELNAME,et.getQueryModelName());
        }
        if(et.isQueryObjectDirty() && (bIncEmpty||et.getQueryObject()!=null)) {
            dst.set(FIELD_QUERYOBJECT,et.getQueryObject());
        }
        if(et.isQueryParamDirty() && (bIncEmpty||et.getQueryParam()!=null)) {
            dst.set(FIELD_QUERYPARAM,et.getQueryParam());
        }
        if(et.isQuerySQLDirty() && (bIncEmpty||et.getQuerySQL()!=null)) {
            dst.set(FIELD_QUERYSQL,et.getQuerySQL());
        }
        if(et.isSelectModeDirty() && (bIncEmpty||et.getSelectMode()!=null)) {
            dst.set(FIELD_SELECTMODE,et.getSelectMode());
        }
        if(et.isSelectOrderDirty() && (bIncEmpty||et.getSelectOrder()!=null)) {
            dst.set(FIELD_SELECTORDER,et.getSelectOrder());
        }
        if(et.isSRFSysPubDirty() && (bIncEmpty||et.getSRFSysPub()!=null)) {
            dst.set(FIELD_SRFSYSPUB,et.getSRFSysPub());
        }
        if(et.isSRFUserPubDirty() && (bIncEmpty||et.getSRFUserPub()!=null)) {
            dst.set(FIELD_SRFUSERPUB,et.getSRFUserPub());
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
        return  QueryModelBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(QueryModelBase et,int index) throws Exception {
        switch(index) {
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
        case INDEX_GROUPMODEL:
            et.resetGroupModel();
            return true;
        case INDEX_ISRAWMODE:
            et.resetIsRawMode();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_QMVERSION:
            et.resetQMVersion();
            return true;
        case INDEX_QUERYCOND:
            et.resetQueryCond();
            return true;
        case INDEX_QUERYFIELD:
            et.resetQueryField();
            return true;
        case INDEX_QUERYMODEL:
            et.resetQueryModel();
            return true;
        case INDEX_QUERYMODELID:
            et.resetQueryModelId();
            return true;
        case INDEX_QUERYMODELNAME:
            et.resetQueryModelName();
            return true;
        case INDEX_QUERYOBJECT:
            et.resetQueryObject();
            return true;
        case INDEX_QUERYPARAM:
            et.resetQueryParam();
            return true;
        case INDEX_QUERYSQL:
            et.resetQuerySQL();
            return true;
        case INDEX_SELECTMODE:
            et.resetSelectMode();
            return true;
        case INDEX_SELECTORDER:
            et.resetSelectOrder();
            return true;
        case INDEX_SRFSYSPUB:
            et.resetSRFSysPub();
            return true;
        case INDEX_SRFUSERPUB:
            et.resetSRFUserPub();
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



    /**
     *  获取代理的数据对象
     */
    private QueryModelBase getProxyEntity() {
        return this.proxyQueryModelBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyQueryModelBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof QueryModelBase) {
            this.proxyQueryModelBase = (QueryModelBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.QueryModelService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}