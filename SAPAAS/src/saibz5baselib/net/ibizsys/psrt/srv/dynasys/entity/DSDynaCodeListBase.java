/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.entity;


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
 * 实体[DSDynaCodeList] 数据对象基类
 */
public abstract class DSDynaCodeListBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaCodeListBase.class);
    /**
     * 属性[代码表标识]
     */
    public final static String FIELD_CODELISTID = "CODELISTID";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[动态代码表标识]
     */
    public final static String FIELD_DSDYNACODELISTID = "DSDYNACODELISTID";
    /**
     * 属性[动态代码表名称]
     */
    public final static String FIELD_DSDYNACODELISTNAME = "DSDYNACODELISTNAME";
    /**
     * 属性[动态模型]
     */
    public final static String FIELD_DYNAMODEL = "DYNAMODEL";
    /**
     * 属性[动态实例标识]
     */
    public final static String FIELD_DYNASYSINSTID = "DYNASYSINSTID";
    /**
     * 属性[代码表版本]
     */
    public final static String FIELD_INSTVER = "INSTVER";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CODELISTID = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_DSDYNACODELISTID = 3;
    private final static int INDEX_DSDYNACODELISTNAME = 4;
    private final static int INDEX_DYNAMODEL = 5;
    private final static int INDEX_DYNASYSINSTID = 6;
    private final static int INDEX_INSTVER = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CODELISTID, INDEX_CODELISTID);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DSDYNACODELISTID, INDEX_DSDYNACODELISTID);
        fieldIndexMap.put( FIELD_DSDYNACODELISTNAME, INDEX_DSDYNACODELISTNAME);
        fieldIndexMap.put( FIELD_DYNAMODEL, INDEX_DYNAMODEL);
        fieldIndexMap.put( FIELD_DYNASYSINSTID, INDEX_DYNASYSINSTID);
        fieldIndexMap.put( FIELD_INSTVER, INDEX_INSTVER);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private DSDynaCodeListBase proxyDSDynaCodeListBase = null;
    public DSDynaCodeListBase() {
        super();
    }
    private boolean codelistidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynacodelistidDirtyFlag = false;
    private boolean dsdynacodelistnameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynasysinstidDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="codelistid")
    private String codelistid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynacodelistid")
    private String dsdynacodelistid;
    @Column(name="dsdynacodelistname")
    private String dsdynacodelistname;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynasysinstid")
    private String dynasysinstid;
    @Column(name="instver")
    private Integer instver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[代码表标识]
     *  @param codelistid
     */
    public void setCodeListId(String codelistid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if(codelistid!=null) {
            codelistid = StringHelper.trimRight(codelistid);
            if(codelistid.length()==0) {
                codelistid = null;
            }
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表标识]
     */
    public String getCodeListId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    /**
     *  获取属性值[代码表标识]是否修改
     */
    public boolean isCodeListIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    /**
     *  重置属性值[代码表标识]
     */
    public void resetCodeListId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }

        this.codelistidDirtyFlag = false;
        this.codelistid = null;
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
     *  设置属性值[动态代码表标识]
     *  @param dsdynacodelistid
     */
    public void setDSDynaCodeListId(String dsdynacodelistid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaCodeListId(dsdynacodelistid);
            return;
        }
        if(dsdynacodelistid!=null) {
            dsdynacodelistid = StringHelper.trimRight(dsdynacodelistid);
            if(dsdynacodelistid.length()==0) {
                dsdynacodelistid = null;
            }
        }
        this.dsdynacodelistid = dsdynacodelistid;
        this.dsdynacodelistidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态代码表标识]
     */
    public String getDSDynaCodeListId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaCodeListId();
        }
        return this.dsdynacodelistid;
    }

    /**
     *  获取属性值[动态代码表标识]是否修改
     */
    public boolean isDSDynaCodeListIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaCodeListIdDirty();
        }
        return this.dsdynacodelistidDirtyFlag;
    }

    /**
     *  重置属性值[动态代码表标识]
     */
    public void resetDSDynaCodeListId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaCodeListId();
            return;
        }

        this.dsdynacodelistidDirtyFlag = false;
        this.dsdynacodelistid = null;
    }
    /**
     *  设置属性值[动态代码表名称]
     *  @param dsdynacodelistname
     */
    public void setDSDynaCodeListName(String dsdynacodelistname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaCodeListName(dsdynacodelistname);
            return;
        }
        if(dsdynacodelistname!=null) {
            dsdynacodelistname = StringHelper.trimRight(dsdynacodelistname);
            if(dsdynacodelistname.length()==0) {
                dsdynacodelistname = null;
            }
        }
        this.dsdynacodelistname = dsdynacodelistname;
        this.dsdynacodelistnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态代码表名称]
     */
    public String getDSDynaCodeListName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaCodeListName();
        }
        return this.dsdynacodelistname;
    }

    /**
     *  获取属性值[动态代码表名称]是否修改
     */
    public boolean isDSDynaCodeListNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaCodeListNameDirty();
        }
        return this.dsdynacodelistnameDirtyFlag;
    }

    /**
     *  重置属性值[动态代码表名称]
     */
    public void resetDSDynaCodeListName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaCodeListName();
            return;
        }

        this.dsdynacodelistnameDirtyFlag = false;
        this.dsdynacodelistname = null;
    }
    /**
     *  设置属性值[动态模型]
     *  @param dynamodel
     */
    public void setDynaModel(String dynamodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDynaModel(dynamodel);
            return;
        }
        if(dynamodel!=null) {
            dynamodel = StringHelper.trimRight(dynamodel);
            if(dynamodel.length()==0) {
                dynamodel = null;
            }
        }
        this.dynamodel = dynamodel;
        this.dynamodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态模型]
     */
    public String getDynaModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    /**
     *  获取属性值[动态模型]是否修改
     */
    public boolean isDynaModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    /**
     *  重置属性值[动态模型]
     */
    public void resetDynaModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }

        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }
    /**
     *  设置属性值[动态实例标识]
     *  @param dynasysinstid
     */
    public void setDynaSysInstId(String dynasysinstid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDynaSysInstId(dynasysinstid);
            return;
        }
        if(dynasysinstid!=null) {
            dynasysinstid = StringHelper.trimRight(dynasysinstid);
            if(dynasysinstid.length()==0) {
                dynasysinstid = null;
            }
        }
        this.dynasysinstid = dynasysinstid;
        this.dynasysinstidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态实例标识]
     */
    public String getDynaSysInstId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDynaSysInstId();
        }
        return this.dynasysinstid;
    }

    /**
     *  获取属性值[动态实例标识]是否修改
     */
    public boolean isDynaSysInstIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDynaSysInstIdDirty();
        }
        return this.dynasysinstidDirtyFlag;
    }

    /**
     *  重置属性值[动态实例标识]
     */
    public void resetDynaSysInstId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDynaSysInstId();
            return;
        }

        this.dynasysinstidDirtyFlag = false;
        this.dynasysinstid = null;
    }
    /**
     *  设置属性值[代码表版本]
     *  @param instver
     */
    public void setInstVer(Integer instver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setInstVer(instver);
            return;
        }
        this.instver = instver;
        this.instverDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表版本]
     */
    public Integer getInstVer() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    /**
     *  获取属性值[代码表版本]是否修改
     */
    public boolean isInstVerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    /**
     *  重置属性值[代码表版本]
     */
    public void resetInstVer() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetInstVer();
            return;
        }

        this.instverDirtyFlag = false;
        this.instver = null;
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
        DSDynaCodeListBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DSDynaCodeListBase et) {
        et.resetCodeListId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaCodeListId();
        et.resetDSDynaCodeListName();
        et.resetDynaModel();
        et.resetDynaSysInstId();
        et.resetInstVer();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID,getCodeListId());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDSDynaCodeListIdDirty()) {
            params.put(FIELD_DSDYNACODELISTID,getDSDynaCodeListId());
        }
        if(!bDirtyOnly || isDSDynaCodeListNameDirty()) {
            params.put(FIELD_DSDYNACODELISTNAME,getDSDynaCodeListName());
        }
        if(!bDirtyOnly || isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL,getDynaModel());
        }
        if(!bDirtyOnly || isDynaSysInstIdDirty()) {
            params.put(FIELD_DYNASYSINSTID,getDynaSysInstId());
        }
        if(!bDirtyOnly || isInstVerDirty()) {
            params.put(FIELD_INSTVER,getInstVer());
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

        return  DSDynaCodeListBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DSDynaCodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODELISTID:
            return et.getCodeListId();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DSDYNACODELISTID:
            return et.getDSDynaCodeListId();
        case INDEX_DSDYNACODELISTNAME:
            return et.getDSDynaCodeListName();
        case INDEX_DYNAMODEL:
            return et.getDynaModel();
        case INDEX_DYNASYSINSTID:
            return et.getDynaSysInstId();
        case INDEX_INSTVER:
            return et.getInstVer();
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

        DSDynaCodeListBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DSDynaCodeListBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CODELISTID:
            et.setCodeListId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNACODELISTID:
            et.setDSDynaCodeListId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNACODELISTNAME:
            et.setDSDynaCodeListName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DYNAMODEL:
            et.setDynaModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_DYNASYSINSTID:
            et.setDynaSysInstId(DataObject.getStringValue(obj));
            return ;
        case INDEX_INSTVER:
            et.setInstVer(DataObject.getIntegerValue(obj));
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

        return  DSDynaCodeListBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DSDynaCodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODELISTID:
            return et.getCodeListId()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DSDYNACODELISTID:
            return et.getDSDynaCodeListId()==null;
        case INDEX_DSDYNACODELISTNAME:
            return et.getDSDynaCodeListName()==null;
        case INDEX_DYNAMODEL:
            return et.getDynaModel()==null;
        case INDEX_DYNASYSINSTID:
            return et.getDynaSysInstId()==null;
        case INDEX_INSTVER:
            return et.getInstVer()==null;
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
        return  DSDynaCodeListBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DSDynaCodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODELISTID:
            return et.isCodeListIdDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DSDYNACODELISTID:
            return et.isDSDynaCodeListIdDirty();
        case INDEX_DSDYNACODELISTNAME:
            return et.isDSDynaCodeListNameDirty();
        case INDEX_DYNAMODEL:
            return et.isDynaModelDirty();
        case INDEX_DYNASYSINSTID:
            return et.isDynaSysInstIdDirty();
        case INDEX_INSTVER:
            return et.isInstVerDirty();
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
    private static  void fillJSONObject(DSDynaCodeListBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCodeListId()!=null) {
            JSONObjectHelper.put(json,"codelistid",getJSONValue(et.getCodeListId()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDSDynaCodeListId()!=null) {
            JSONObjectHelper.put(json,"dsdynacodelistid",getJSONValue(et.getDSDynaCodeListId()),false);
        }
        if(bIncEmpty||et.getDSDynaCodeListName()!=null) {
            JSONObjectHelper.put(json,"dsdynacodelistname",getJSONValue(et.getDSDynaCodeListName()),false);
        }
        if(bIncEmpty||et.getDynaModel()!=null) {
            JSONObjectHelper.put(json,"dynamodel",getJSONValue(et.getDynaModel()),false);
        }
        if(bIncEmpty||et.getDynaSysInstId()!=null) {
            JSONObjectHelper.put(json,"dynasysinstid",getJSONValue(et.getDynaSysInstId()),false);
        }
        if(bIncEmpty||et.getInstVer()!=null) {
            JSONObjectHelper.put(json,"instver",getJSONValue(et.getInstVer()),false);
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
    private static void fillXmlNode(DSDynaCodeListBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCodeListId()!=null) {
            Object obj = et.getCodeListId();
            node.setAttribute("CODELISTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaCodeListId()!=null) {
            Object obj = et.getDSDynaCodeListId();
            node.setAttribute("DSDYNACODELISTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaCodeListName()!=null) {
            Object obj = et.getDSDynaCodeListName();
            node.setAttribute("DSDYNACODELISTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDynaModel()!=null) {
            Object obj = et.getDynaModel();
            node.setAttribute("DYNAMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDynaSysInstId()!=null) {
            Object obj = et.getDynaSysInstId();
            node.setAttribute("DYNASYSINSTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getInstVer()!=null) {
            Object obj = et.getInstVer();
            node.setAttribute("INSTVER",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        DSDynaCodeListBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DSDynaCodeListBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCodeListIdDirty() && (bIncEmpty||et.getCodeListId()!=null)) {
            dst.set(FIELD_CODELISTID,et.getCodeListId());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDSDynaCodeListIdDirty() && (bIncEmpty||et.getDSDynaCodeListId()!=null)) {
            dst.set(FIELD_DSDYNACODELISTID,et.getDSDynaCodeListId());
        }
        if(et.isDSDynaCodeListNameDirty() && (bIncEmpty||et.getDSDynaCodeListName()!=null)) {
            dst.set(FIELD_DSDYNACODELISTNAME,et.getDSDynaCodeListName());
        }
        if(et.isDynaModelDirty() && (bIncEmpty||et.getDynaModel()!=null)) {
            dst.set(FIELD_DYNAMODEL,et.getDynaModel());
        }
        if(et.isDynaSysInstIdDirty() && (bIncEmpty||et.getDynaSysInstId()!=null)) {
            dst.set(FIELD_DYNASYSINSTID,et.getDynaSysInstId());
        }
        if(et.isInstVerDirty() && (bIncEmpty||et.getInstVer()!=null)) {
            dst.set(FIELD_INSTVER,et.getInstVer());
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
        return  DSDynaCodeListBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DSDynaCodeListBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CODELISTID:
            et.resetCodeListId();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DSDYNACODELISTID:
            et.resetDSDynaCodeListId();
            return true;
        case INDEX_DSDYNACODELISTNAME:
            et.resetDSDynaCodeListName();
            return true;
        case INDEX_DYNAMODEL:
            et.resetDynaModel();
            return true;
        case INDEX_DYNASYSINSTID:
            et.resetDynaSysInstId();
            return true;
        case INDEX_INSTVER:
            et.resetInstVer();
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




    /**
     *  获取代理的数据对象
     */
    private DSDynaCodeListBase getProxyEntity() {
        return this.proxyDSDynaCodeListBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaCodeListBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DSDynaCodeListBase) {
            this.proxyDSDynaCodeListBase = (DSDynaCodeListBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}