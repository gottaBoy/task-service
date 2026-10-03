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
 * 实体[DataAuditDetail] 数据对象基类
 */
public abstract class DataAuditDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataAuditDetailBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据审计明细标识]
     */
    public final static String FIELD_DATAAUDITDETAILID = "DATAAUDITDETAILID";
    /**
     * 属性[属性]
     */
    public final static String FIELD_DATAAUDITDETAILNAME = "DATAAUDITDETAILNAME";
    /**
     * 属性[数据审计]
     */
    public final static String FIELD_DATAAUDITID = "DATAAUDITID";
    /**
     * 属性[数据审计]
     */
    public final static String FIELD_DATAAUDITNAME = "DATAAUDITNAME";
    /**
     * 属性[新值（文本）]
     */
    public final static String FIELD_NEWTEXT = "NEWTEXT";
    /**
     * 属性[新值]
     */
    public final static String FIELD_NEWVALUE = "NEWVALUE";
    /**
     * 属性[原值（文本）]
     */
    public final static String FIELD_OLDTEXT = "OLDTEXT";
    /**
     * 属性[原值]
     */
    public final static String FIELD_OLDVALUE = "OLDVALUE";
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
    private final static int INDEX_DATAAUDITDETAILID = 2;
    private final static int INDEX_DATAAUDITDETAILNAME = 3;
    private final static int INDEX_DATAAUDITID = 4;
    private final static int INDEX_DATAAUDITNAME = 5;
    private final static int INDEX_NEWTEXT = 6;
    private final static int INDEX_NEWVALUE = 7;
    private final static int INDEX_OLDTEXT = 8;
    private final static int INDEX_OLDVALUE = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATAAUDITDETAILID, INDEX_DATAAUDITDETAILID);
        fieldIndexMap.put( FIELD_DATAAUDITDETAILNAME, INDEX_DATAAUDITDETAILNAME);
        fieldIndexMap.put( FIELD_DATAAUDITID, INDEX_DATAAUDITID);
        fieldIndexMap.put( FIELD_DATAAUDITNAME, INDEX_DATAAUDITNAME);
        fieldIndexMap.put( FIELD_NEWTEXT, INDEX_NEWTEXT);
        fieldIndexMap.put( FIELD_NEWVALUE, INDEX_NEWVALUE);
        fieldIndexMap.put( FIELD_OLDTEXT, INDEX_OLDTEXT);
        fieldIndexMap.put( FIELD_OLDVALUE, INDEX_OLDVALUE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private DataAuditDetailBase proxyDataAuditDetailBase = null;
    public DataAuditDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataauditdetailidDirtyFlag = false;
    private boolean dataauditdetailnameDirtyFlag = false;
    private boolean dataauditidDirtyFlag = false;
    private boolean dataauditnameDirtyFlag = false;
    private boolean newtextDirtyFlag = false;
    private boolean newvalueDirtyFlag = false;
    private boolean oldtextDirtyFlag = false;
    private boolean oldvalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataauditdetailid")
    private String dataauditdetailid;
    @Column(name="dataauditdetailname")
    private String dataauditdetailname;
    @Column(name="dataauditid")
    private String dataauditid;
    @Column(name="dataauditname")
    private String dataauditname;
    @Column(name="newtext")
    private String newtext;
    @Column(name="newvalue")
    private String newvalue;
    @Column(name="oldtext")
    private String oldtext;
    @Column(name="oldvalue")
    private String oldvalue;
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
     *  设置属性值[数据审计明细标识]
     *  @param dataauditdetailid
     */
    public void setDataAuditDetailId(String dataauditdetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditDetailId(dataauditdetailid);
            return;
        }
        if(dataauditdetailid!=null) {
            dataauditdetailid = StringHelper.trimRight(dataauditdetailid);
            if(dataauditdetailid.length()==0) {
                dataauditdetailid = null;
            }
        }
        this.dataauditdetailid = dataauditdetailid;
        this.dataauditdetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据审计明细标识]
     */
    public String getDataAuditDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditDetailId();
        }
        return this.dataauditdetailid;
    }

    /**
     *  获取属性值[数据审计明细标识]是否修改
     */
    public boolean isDataAuditDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditDetailIdDirty();
        }
        return this.dataauditdetailidDirtyFlag;
    }

    /**
     *  重置属性值[数据审计明细标识]
     */
    public void resetDataAuditDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditDetailId();
            return;
        }

        this.dataauditdetailidDirtyFlag = false;
        this.dataauditdetailid = null;
    }
    /**
     *  设置属性值[属性]
     *  @param dataauditdetailname
     */
    public void setDataAuditDetailName(String dataauditdetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditDetailName(dataauditdetailname);
            return;
        }
        if(dataauditdetailname!=null) {
            dataauditdetailname = StringHelper.trimRight(dataauditdetailname);
            if(dataauditdetailname.length()==0) {
                dataauditdetailname = null;
            }
        }
        this.dataauditdetailname = dataauditdetailname;
        this.dataauditdetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[属性]
     */
    public String getDataAuditDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditDetailName();
        }
        return this.dataauditdetailname;
    }

    /**
     *  获取属性值[属性]是否修改
     */
    public boolean isDataAuditDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditDetailNameDirty();
        }
        return this.dataauditdetailnameDirtyFlag;
    }

    /**
     *  重置属性值[属性]
     */
    public void resetDataAuditDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditDetailName();
            return;
        }

        this.dataauditdetailnameDirtyFlag = false;
        this.dataauditdetailname = null;
    }
    /**
     *  设置属性值[数据审计]
     *  @param dataauditid
     */
    public void setDataAuditId(String dataauditid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditId(dataauditid);
            return;
        }
        if(dataauditid!=null) {
            dataauditid = StringHelper.trimRight(dataauditid);
            if(dataauditid.length()==0) {
                dataauditid = null;
            }
        }
        this.dataauditid = dataauditid;
        this.dataauditidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据审计]
     */
    public String getDataAuditId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditId();
        }
        return this.dataauditid;
    }

    /**
     *  获取属性值[数据审计]是否修改
     */
    public boolean isDataAuditIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditIdDirty();
        }
        return this.dataauditidDirtyFlag;
    }

    /**
     *  重置属性值[数据审计]
     */
    public void resetDataAuditId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditId();
            return;
        }

        this.dataauditidDirtyFlag = false;
        this.dataauditid = null;
    }
    /**
     *  设置属性值[数据审计]
     *  @param dataauditname
     */
    public void setDataAuditName(String dataauditname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditName(dataauditname);
            return;
        }
        if(dataauditname!=null) {
            dataauditname = StringHelper.trimRight(dataauditname);
            if(dataauditname.length()==0) {
                dataauditname = null;
            }
        }
        this.dataauditname = dataauditname;
        this.dataauditnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据审计]
     */
    public String getDataAuditName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditName();
        }
        return this.dataauditname;
    }

    /**
     *  获取属性值[数据审计]是否修改
     */
    public boolean isDataAuditNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditNameDirty();
        }
        return this.dataauditnameDirtyFlag;
    }

    /**
     *  重置属性值[数据审计]
     */
    public void resetDataAuditName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditName();
            return;
        }

        this.dataauditnameDirtyFlag = false;
        this.dataauditname = null;
    }
    /**
     *  设置属性值[新值（文本）]
     *  @param newtext
     */
    public void setNewText(String newtext) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNewText(newtext);
            return;
        }
        if(newtext!=null) {
            newtext = StringHelper.trimRight(newtext);
            if(newtext.length()==0) {
                newtext = null;
            }
        }
        this.newtext = newtext;
        this.newtextDirtyFlag  = true;
    }

    /**
     *  获取属性值[新值（文本）]
     */
    public String getNewText() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNewText();
        }
        return this.newtext;
    }

    /**
     *  获取属性值[新值（文本）]是否修改
     */
    public boolean isNewTextDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNewTextDirty();
        }
        return this.newtextDirtyFlag;
    }

    /**
     *  重置属性值[新值（文本）]
     */
    public void resetNewText() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNewText();
            return;
        }

        this.newtextDirtyFlag = false;
        this.newtext = null;
    }
    /**
     *  设置属性值[新值]
     *  @param newvalue
     */
    public void setNewValue(String newvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNewValue(newvalue);
            return;
        }
        if(newvalue!=null) {
            newvalue = StringHelper.trimRight(newvalue);
            if(newvalue.length()==0) {
                newvalue = null;
            }
        }
        this.newvalue = newvalue;
        this.newvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[新值]
     */
    public String getNewValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNewValue();
        }
        return this.newvalue;
    }

    /**
     *  获取属性值[新值]是否修改
     */
    public boolean isNewValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNewValueDirty();
        }
        return this.newvalueDirtyFlag;
    }

    /**
     *  重置属性值[新值]
     */
    public void resetNewValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNewValue();
            return;
        }

        this.newvalueDirtyFlag = false;
        this.newvalue = null;
    }
    /**
     *  设置属性值[原值（文本）]
     *  @param oldtext
     */
    public void setOldText(String oldtext) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOldText(oldtext);
            return;
        }
        if(oldtext!=null) {
            oldtext = StringHelper.trimRight(oldtext);
            if(oldtext.length()==0) {
                oldtext = null;
            }
        }
        this.oldtext = oldtext;
        this.oldtextDirtyFlag  = true;
    }

    /**
     *  获取属性值[原值（文本）]
     */
    public String getOldText() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOldText();
        }
        return this.oldtext;
    }

    /**
     *  获取属性值[原值（文本）]是否修改
     */
    public boolean isOldTextDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOldTextDirty();
        }
        return this.oldtextDirtyFlag;
    }

    /**
     *  重置属性值[原值（文本）]
     */
    public void resetOldText() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOldText();
            return;
        }

        this.oldtextDirtyFlag = false;
        this.oldtext = null;
    }
    /**
     *  设置属性值[原值]
     *  @param oldvalue
     */
    public void setOldValue(String oldvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOldValue(oldvalue);
            return;
        }
        if(oldvalue!=null) {
            oldvalue = StringHelper.trimRight(oldvalue);
            if(oldvalue.length()==0) {
                oldvalue = null;
            }
        }
        this.oldvalue = oldvalue;
        this.oldvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[原值]
     */
    public String getOldValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOldValue();
        }
        return this.oldvalue;
    }

    /**
     *  获取属性值[原值]是否修改
     */
    public boolean isOldValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOldValueDirty();
        }
        return this.oldvalueDirtyFlag;
    }

    /**
     *  重置属性值[原值]
     */
    public void resetOldValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOldValue();
            return;
        }

        this.oldvalueDirtyFlag = false;
        this.oldvalue = null;
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
        DataAuditDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DataAuditDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataAuditDetailId();
        et.resetDataAuditDetailName();
        et.resetDataAuditId();
        et.resetDataAuditName();
        et.resetNewText();
        et.resetNewValue();
        et.resetOldText();
        et.resetOldValue();
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
        if(!bDirtyOnly || isDataAuditDetailIdDirty()) {
            params.put(FIELD_DATAAUDITDETAILID,getDataAuditDetailId());
        }
        if(!bDirtyOnly || isDataAuditDetailNameDirty()) {
            params.put(FIELD_DATAAUDITDETAILNAME,getDataAuditDetailName());
        }
        if(!bDirtyOnly || isDataAuditIdDirty()) {
            params.put(FIELD_DATAAUDITID,getDataAuditId());
        }
        if(!bDirtyOnly || isDataAuditNameDirty()) {
            params.put(FIELD_DATAAUDITNAME,getDataAuditName());
        }
        if(!bDirtyOnly || isNewTextDirty()) {
            params.put(FIELD_NEWTEXT,getNewText());
        }
        if(!bDirtyOnly || isNewValueDirty()) {
            params.put(FIELD_NEWVALUE,getNewValue());
        }
        if(!bDirtyOnly || isOldTextDirty()) {
            params.put(FIELD_OLDTEXT,getOldText());
        }
        if(!bDirtyOnly || isOldValueDirty()) {
            params.put(FIELD_OLDVALUE,getOldValue());
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

        return  DataAuditDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DataAuditDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATAAUDITDETAILID:
            return et.getDataAuditDetailId();
        case INDEX_DATAAUDITDETAILNAME:
            return et.getDataAuditDetailName();
        case INDEX_DATAAUDITID:
            return et.getDataAuditId();
        case INDEX_DATAAUDITNAME:
            return et.getDataAuditName();
        case INDEX_NEWTEXT:
            return et.getNewText();
        case INDEX_NEWVALUE:
            return et.getNewValue();
        case INDEX_OLDTEXT:
            return et.getOldText();
        case INDEX_OLDVALUE:
            return et.getOldValue();
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

        DataAuditDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DataAuditDetailBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITDETAILID:
            et.setDataAuditDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITDETAILNAME:
            et.setDataAuditDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITID:
            et.setDataAuditId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITNAME:
            et.setDataAuditName(DataObject.getStringValue(obj));
            return ;
        case INDEX_NEWTEXT:
            et.setNewText(DataObject.getStringValue(obj));
            return ;
        case INDEX_NEWVALUE:
            et.setNewValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_OLDTEXT:
            et.setOldText(DataObject.getStringValue(obj));
            return ;
        case INDEX_OLDVALUE:
            et.setOldValue(DataObject.getStringValue(obj));
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

        return  DataAuditDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DataAuditDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATAAUDITDETAILID:
            return et.getDataAuditDetailId()==null;
        case INDEX_DATAAUDITDETAILNAME:
            return et.getDataAuditDetailName()==null;
        case INDEX_DATAAUDITID:
            return et.getDataAuditId()==null;
        case INDEX_DATAAUDITNAME:
            return et.getDataAuditName()==null;
        case INDEX_NEWTEXT:
            return et.getNewText()==null;
        case INDEX_NEWVALUE:
            return et.getNewValue()==null;
        case INDEX_OLDTEXT:
            return et.getOldText()==null;
        case INDEX_OLDVALUE:
            return et.getOldValue()==null;
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
        return  DataAuditDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DataAuditDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATAAUDITDETAILID:
            return et.isDataAuditDetailIdDirty();
        case INDEX_DATAAUDITDETAILNAME:
            return et.isDataAuditDetailNameDirty();
        case INDEX_DATAAUDITID:
            return et.isDataAuditIdDirty();
        case INDEX_DATAAUDITNAME:
            return et.isDataAuditNameDirty();
        case INDEX_NEWTEXT:
            return et.isNewTextDirty();
        case INDEX_NEWVALUE:
            return et.isNewValueDirty();
        case INDEX_OLDTEXT:
            return et.isOldTextDirty();
        case INDEX_OLDVALUE:
            return et.isOldValueDirty();
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
    private static  void fillJSONObject(DataAuditDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataAuditDetailId()!=null) {
            JSONObjectHelper.put(json,"dataauditdetailid",getJSONValue(et.getDataAuditDetailId()),false);
        }
        if(bIncEmpty||et.getDataAuditDetailName()!=null) {
            JSONObjectHelper.put(json,"dataauditdetailname",getJSONValue(et.getDataAuditDetailName()),false);
        }
        if(bIncEmpty||et.getDataAuditId()!=null) {
            JSONObjectHelper.put(json,"dataauditid",getJSONValue(et.getDataAuditId()),false);
        }
        if(bIncEmpty||et.getDataAuditName()!=null) {
            JSONObjectHelper.put(json,"dataauditname",getJSONValue(et.getDataAuditName()),false);
        }
        if(bIncEmpty||et.getNewText()!=null) {
            JSONObjectHelper.put(json,"newtext",getJSONValue(et.getNewText()),false);
        }
        if(bIncEmpty||et.getNewValue()!=null) {
            JSONObjectHelper.put(json,"newvalue",getJSONValue(et.getNewValue()),false);
        }
        if(bIncEmpty||et.getOldText()!=null) {
            JSONObjectHelper.put(json,"oldtext",getJSONValue(et.getOldText()),false);
        }
        if(bIncEmpty||et.getOldValue()!=null) {
            JSONObjectHelper.put(json,"oldvalue",getJSONValue(et.getOldValue()),false);
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
    private static void fillXmlNode(DataAuditDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditDetailId()!=null) {
            Object obj = et.getDataAuditDetailId();
            node.setAttribute("DATAAUDITDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditDetailName()!=null) {
            Object obj = et.getDataAuditDetailName();
            node.setAttribute("DATAAUDITDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditId()!=null) {
            Object obj = et.getDataAuditId();
            node.setAttribute("DATAAUDITID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditName()!=null) {
            Object obj = et.getDataAuditName();
            node.setAttribute("DATAAUDITNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getNewText()!=null) {
            Object obj = et.getNewText();
            node.setAttribute("NEWTEXT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getNewValue()!=null) {
            Object obj = et.getNewValue();
            node.setAttribute("NEWVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOldText()!=null) {
            Object obj = et.getOldText();
            node.setAttribute("OLDTEXT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOldValue()!=null) {
            Object obj = et.getOldValue();
            node.setAttribute("OLDVALUE",(obj==null)?"":(String)obj);
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
        DataAuditDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DataAuditDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataAuditDetailIdDirty() && (bIncEmpty||et.getDataAuditDetailId()!=null)) {
            dst.set(FIELD_DATAAUDITDETAILID,et.getDataAuditDetailId());
        }
        if(et.isDataAuditDetailNameDirty() && (bIncEmpty||et.getDataAuditDetailName()!=null)) {
            dst.set(FIELD_DATAAUDITDETAILNAME,et.getDataAuditDetailName());
        }
        if(et.isDataAuditIdDirty() && (bIncEmpty||et.getDataAuditId()!=null)) {
            dst.set(FIELD_DATAAUDITID,et.getDataAuditId());
        }
        if(et.isDataAuditNameDirty() && (bIncEmpty||et.getDataAuditName()!=null)) {
            dst.set(FIELD_DATAAUDITNAME,et.getDataAuditName());
        }
        if(et.isNewTextDirty() && (bIncEmpty||et.getNewText()!=null)) {
            dst.set(FIELD_NEWTEXT,et.getNewText());
        }
        if(et.isNewValueDirty() && (bIncEmpty||et.getNewValue()!=null)) {
            dst.set(FIELD_NEWVALUE,et.getNewValue());
        }
        if(et.isOldTextDirty() && (bIncEmpty||et.getOldText()!=null)) {
            dst.set(FIELD_OLDTEXT,et.getOldText());
        }
        if(et.isOldValueDirty() && (bIncEmpty||et.getOldValue()!=null)) {
            dst.set(FIELD_OLDVALUE,et.getOldValue());
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
        return  DataAuditDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DataAuditDetailBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATAAUDITDETAILID:
            et.resetDataAuditDetailId();
            return true;
        case INDEX_DATAAUDITDETAILNAME:
            et.resetDataAuditDetailName();
            return true;
        case INDEX_DATAAUDITID:
            et.resetDataAuditId();
            return true;
        case INDEX_DATAAUDITNAME:
            et.resetDataAuditName();
            return true;
        case INDEX_NEWTEXT:
            et.resetNewText();
            return true;
        case INDEX_NEWVALUE:
            et.resetNewValue();
            return true;
        case INDEX_OLDTEXT:
            et.resetOldText();
            return true;
        case INDEX_OLDVALUE:
            et.resetOldValue();
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


    private Integer objDataAuditLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.DataAudit dataaudit = null;
    /**
    * 获取父数据 数据审计
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.DataAudit getDataAudit() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAudit();
        }

        if(this.getDataAuditId()==null)
            return null;
        synchronized(this.objDataAuditLock) {
            if(this.dataaudit!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDataAuditId(),dataaudit.getDataAuditId())!=0) {
                    this.dataaudit = null;
                }
            }


            if(this.dataaudit==null) {
                net.ibizsys.psrt.srv.common.entity.DataAudit dataaudit = new net.ibizsys.psrt.srv.common.entity.DataAudit();
                dataaudit.setDataAuditId(this.getDataAuditId());
                net.ibizsys.psrt.srv.common.service.DataAuditService service = (net.ibizsys.psrt.srv.common.service.DataAuditService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.DataAuditService.class,this.getSessionFactory());
                service.autoGet(dataaudit);
                this.dataaudit = dataaudit;
            }
            return this.dataaudit;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private DataAuditDetailBase getProxyEntity() {
        return this.proxyDataAuditDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataAuditDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DataAuditDetailBase) {
            this.proxyDataAuditDetailBase = (DataAuditDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataAuditDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}