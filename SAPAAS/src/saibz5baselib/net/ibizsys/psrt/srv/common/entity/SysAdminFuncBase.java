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
 * 实体[SysAdminFunc] 数据对象基类
 */
public abstract class SysAdminFuncBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(SysAdminFuncBase.class);
    /**
     * 属性[管理对象]
     */
    public final static String FIELD_ADMINOBJECT = "ADMINOBJECT";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[功能编号]
     */
    public final static String FIELD_FUNCID = "FUNCID";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[参数]
     */
    public final static String FIELD_PARAM = "PARAM";
    /**
     * 属性[系统管理功能标识]
     */
    public final static String FIELD_SYSADMINFUNCID = "SYSADMINFUNCID";
    /**
     * 属性[系统管理功能名称]
     */
    public final static String FIELD_SYSADMINFUNCNAME = "SYSADMINFUNCNAME";
    /**
     * 属性[系统管理功能_管理模块]
     */
    public final static String FIELD_SYSADMINID = "SYSADMINID";
    /**
     * 属性[管理模块]
     */
    public final static String FIELD_SYSADMINNAME = "SYSADMINNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_ADMINOBJECT = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_FUNCID = 3;
    private final static int INDEX_MEMO = 4;
    private final static int INDEX_PARAM = 5;
    private final static int INDEX_SYSADMINFUNCID = 6;
    private final static int INDEX_SYSADMINFUNCNAME = 7;
    private final static int INDEX_SYSADMINID = 8;
    private final static int INDEX_SYSADMINNAME = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ADMINOBJECT, INDEX_ADMINOBJECT);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_FUNCID, INDEX_FUNCID);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PARAM, INDEX_PARAM);
        fieldIndexMap.put( FIELD_SYSADMINFUNCID, INDEX_SYSADMINFUNCID);
        fieldIndexMap.put( FIELD_SYSADMINFUNCNAME, INDEX_SYSADMINFUNCNAME);
        fieldIndexMap.put( FIELD_SYSADMINID, INDEX_SYSADMINID);
        fieldIndexMap.put( FIELD_SYSADMINNAME, INDEX_SYSADMINNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private SysAdminFuncBase proxySysAdminFuncBase = null;
    public SysAdminFuncBase() {
        super();
    }
    private boolean adminobjectDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean sysadminfuncidDirtyFlag = false;
    private boolean sysadminfuncnameDirtyFlag = false;
    private boolean sysadminidDirtyFlag = false;
    private boolean sysadminnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="adminobject")
    private String adminobject;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcid")
    private String funcid;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="sysadminfuncid")
    private String sysadminfuncid;
    @Column(name="sysadminfuncname")
    private String sysadminfuncname;
    @Column(name="sysadminid")
    private String sysadminid;
    @Column(name="sysadminname")
    private String sysadminname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[管理对象]
     *  @param adminobject
     */
    public void setAdminObject(String adminobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAdminObject(adminobject);
            return;
        }
        if(adminobject!=null) {
            adminobject = StringHelper.trimRight(adminobject);
            if(adminobject.length()==0) {
                adminobject = null;
            }
        }
        this.adminobject = adminobject;
        this.adminobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[管理对象]
     */
    public String getAdminObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAdminObject();
        }
        return this.adminobject;
    }

    /**
     *  获取属性值[管理对象]是否修改
     */
    public boolean isAdminObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAdminObjectDirty();
        }
        return this.adminobjectDirtyFlag;
    }

    /**
     *  重置属性值[管理对象]
     */
    public void resetAdminObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAdminObject();
            return;
        }

        this.adminobjectDirtyFlag = false;
        this.adminobject = null;
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
     *  设置属性值[功能编号]
     *  @param funcid
     */
    public void setFuncId(String funcid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFuncId(funcid);
            return;
        }
        if(funcid!=null) {
            funcid = StringHelper.trimRight(funcid);
            if(funcid.length()==0) {
                funcid = null;
            }
        }
        this.funcid = funcid;
        this.funcidDirtyFlag  = true;
    }

    /**
     *  获取属性值[功能编号]
     */
    public String getFuncId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFuncId();
        }
        return this.funcid;
    }

    /**
     *  获取属性值[功能编号]是否修改
     */
    public boolean isFuncIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFuncIdDirty();
        }
        return this.funcidDirtyFlag;
    }

    /**
     *  重置属性值[功能编号]
     */
    public void resetFuncId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFuncId();
            return;
        }

        this.funcidDirtyFlag = false;
        this.funcid = null;
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
     *  设置属性值[参数]
     *  @param param
     */
    public void setParam(String param) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam(param);
            return;
        }
        if(param!=null) {
            param = StringHelper.trimRight(param);
            if(param.length()==0) {
                param = null;
            }
        }
        this.param = param;
        this.paramDirtyFlag  = true;
    }

    /**
     *  获取属性值[参数]
     */
    public String getParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    /**
     *  获取属性值[参数]是否修改
     */
    public boolean isParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    /**
     *  重置属性值[参数]
     */
    public void resetParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam();
            return;
        }

        this.paramDirtyFlag = false;
        this.param = null;
    }
    /**
     *  设置属性值[系统管理功能标识]
     *  @param sysadminfuncid
     */
    public void setSysAdminFuncId(String sysadminfuncid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSysAdminFuncId(sysadminfuncid);
            return;
        }
        if(sysadminfuncid!=null) {
            sysadminfuncid = StringHelper.trimRight(sysadminfuncid);
            if(sysadminfuncid.length()==0) {
                sysadminfuncid = null;
            }
        }
        this.sysadminfuncid = sysadminfuncid;
        this.sysadminfuncidDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统管理功能标识]
     */
    public String getSysAdminFuncId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSysAdminFuncId();
        }
        return this.sysadminfuncid;
    }

    /**
     *  获取属性值[系统管理功能标识]是否修改
     */
    public boolean isSysAdminFuncIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSysAdminFuncIdDirty();
        }
        return this.sysadminfuncidDirtyFlag;
    }

    /**
     *  重置属性值[系统管理功能标识]
     */
    public void resetSysAdminFuncId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSysAdminFuncId();
            return;
        }

        this.sysadminfuncidDirtyFlag = false;
        this.sysadminfuncid = null;
    }
    /**
     *  设置属性值[系统管理功能名称]
     *  @param sysadminfuncname
     */
    public void setSysAdminFuncName(String sysadminfuncname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSysAdminFuncName(sysadminfuncname);
            return;
        }
        if(sysadminfuncname!=null) {
            sysadminfuncname = StringHelper.trimRight(sysadminfuncname);
            if(sysadminfuncname.length()==0) {
                sysadminfuncname = null;
            }
        }
        this.sysadminfuncname = sysadminfuncname;
        this.sysadminfuncnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统管理功能名称]
     */
    public String getSysAdminFuncName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSysAdminFuncName();
        }
        return this.sysadminfuncname;
    }

    /**
     *  获取属性值[系统管理功能名称]是否修改
     */
    public boolean isSysAdminFuncNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSysAdminFuncNameDirty();
        }
        return this.sysadminfuncnameDirtyFlag;
    }

    /**
     *  重置属性值[系统管理功能名称]
     */
    public void resetSysAdminFuncName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSysAdminFuncName();
            return;
        }

        this.sysadminfuncnameDirtyFlag = false;
        this.sysadminfuncname = null;
    }
    /**
     *  设置属性值[系统管理功能_管理模块]
     *  @param sysadminid
     */
    public void setSysAdminId(String sysadminid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSysAdminId(sysadminid);
            return;
        }
        if(sysadminid!=null) {
            sysadminid = StringHelper.trimRight(sysadminid);
            if(sysadminid.length()==0) {
                sysadminid = null;
            }
        }
        this.sysadminid = sysadminid;
        this.sysadminidDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统管理功能_管理模块]
     */
    public String getSysAdminId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSysAdminId();
        }
        return this.sysadminid;
    }

    /**
     *  获取属性值[系统管理功能_管理模块]是否修改
     */
    public boolean isSysAdminIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSysAdminIdDirty();
        }
        return this.sysadminidDirtyFlag;
    }

    /**
     *  重置属性值[系统管理功能_管理模块]
     */
    public void resetSysAdminId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSysAdminId();
            return;
        }

        this.sysadminidDirtyFlag = false;
        this.sysadminid = null;
    }
    /**
     *  设置属性值[管理模块]
     *  @param sysadminname
     */
    public void setSysAdminName(String sysadminname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSysAdminName(sysadminname);
            return;
        }
        if(sysadminname!=null) {
            sysadminname = StringHelper.trimRight(sysadminname);
            if(sysadminname.length()==0) {
                sysadminname = null;
            }
        }
        this.sysadminname = sysadminname;
        this.sysadminnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[管理模块]
     */
    public String getSysAdminName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSysAdminName();
        }
        return this.sysadminname;
    }

    /**
     *  获取属性值[管理模块]是否修改
     */
    public boolean isSysAdminNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSysAdminNameDirty();
        }
        return this.sysadminnameDirtyFlag;
    }

    /**
     *  重置属性值[管理模块]
     */
    public void resetSysAdminName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSysAdminName();
            return;
        }

        this.sysadminnameDirtyFlag = false;
        this.sysadminname = null;
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
        SysAdminFuncBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(SysAdminFuncBase et) {
        et.resetAdminObject();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetFuncId();
        et.resetMemo();
        et.resetParam();
        et.resetSysAdminFuncId();
        et.resetSysAdminFuncName();
        et.resetSysAdminId();
        et.resetSysAdminName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAdminObjectDirty()) {
            params.put(FIELD_ADMINOBJECT,getAdminObject());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isFuncIdDirty()) {
            params.put(FIELD_FUNCID,getFuncId());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isParamDirty()) {
            params.put(FIELD_PARAM,getParam());
        }
        if(!bDirtyOnly || isSysAdminFuncIdDirty()) {
            params.put(FIELD_SYSADMINFUNCID,getSysAdminFuncId());
        }
        if(!bDirtyOnly || isSysAdminFuncNameDirty()) {
            params.put(FIELD_SYSADMINFUNCNAME,getSysAdminFuncName());
        }
        if(!bDirtyOnly || isSysAdminIdDirty()) {
            params.put(FIELD_SYSADMINID,getSysAdminId());
        }
        if(!bDirtyOnly || isSysAdminNameDirty()) {
            params.put(FIELD_SYSADMINNAME,getSysAdminName());
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

        return  SysAdminFuncBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(SysAdminFuncBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ADMINOBJECT:
            return et.getAdminObject();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_FUNCID:
            return et.getFuncId();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PARAM:
            return et.getParam();
        case INDEX_SYSADMINFUNCID:
            return et.getSysAdminFuncId();
        case INDEX_SYSADMINFUNCNAME:
            return et.getSysAdminFuncName();
        case INDEX_SYSADMINID:
            return et.getSysAdminId();
        case INDEX_SYSADMINNAME:
            return et.getSysAdminName();
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

        SysAdminFuncBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(SysAdminFuncBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ADMINOBJECT:
            et.setAdminObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_FUNCID:
            et.setFuncId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM:
            et.setParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSADMINFUNCID:
            et.setSysAdminFuncId(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSADMINFUNCNAME:
            et.setSysAdminFuncName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSADMINID:
            et.setSysAdminId(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSADMINNAME:
            et.setSysAdminName(DataObject.getStringValue(obj));
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

        return  SysAdminFuncBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(SysAdminFuncBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ADMINOBJECT:
            return et.getAdminObject()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_FUNCID:
            return et.getFuncId()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PARAM:
            return et.getParam()==null;
        case INDEX_SYSADMINFUNCID:
            return et.getSysAdminFuncId()==null;
        case INDEX_SYSADMINFUNCNAME:
            return et.getSysAdminFuncName()==null;
        case INDEX_SYSADMINID:
            return et.getSysAdminId()==null;
        case INDEX_SYSADMINNAME:
            return et.getSysAdminName()==null;
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
        return  SysAdminFuncBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(SysAdminFuncBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ADMINOBJECT:
            return et.isAdminObjectDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_FUNCID:
            return et.isFuncIdDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PARAM:
            return et.isParamDirty();
        case INDEX_SYSADMINFUNCID:
            return et.isSysAdminFuncIdDirty();
        case INDEX_SYSADMINFUNCNAME:
            return et.isSysAdminFuncNameDirty();
        case INDEX_SYSADMINID:
            return et.isSysAdminIdDirty();
        case INDEX_SYSADMINNAME:
            return et.isSysAdminNameDirty();
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
    private static  void fillJSONObject(SysAdminFuncBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAdminObject()!=null) {
            JSONObjectHelper.put(json,"adminobject",getJSONValue(et.getAdminObject()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getFuncId()!=null) {
            JSONObjectHelper.put(json,"funcid",getJSONValue(et.getFuncId()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getParam()!=null) {
            JSONObjectHelper.put(json,"param",getJSONValue(et.getParam()),false);
        }
        if(bIncEmpty||et.getSysAdminFuncId()!=null) {
            JSONObjectHelper.put(json,"sysadminfuncid",getJSONValue(et.getSysAdminFuncId()),false);
        }
        if(bIncEmpty||et.getSysAdminFuncName()!=null) {
            JSONObjectHelper.put(json,"sysadminfuncname",getJSONValue(et.getSysAdminFuncName()),false);
        }
        if(bIncEmpty||et.getSysAdminId()!=null) {
            JSONObjectHelper.put(json,"sysadminid",getJSONValue(et.getSysAdminId()),false);
        }
        if(bIncEmpty||et.getSysAdminName()!=null) {
            JSONObjectHelper.put(json,"sysadminname",getJSONValue(et.getSysAdminName()),false);
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
    private static void fillXmlNode(SysAdminFuncBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAdminObject()!=null) {
            Object obj = et.getAdminObject();
            node.setAttribute("ADMINOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFuncId()!=null) {
            Object obj = et.getFuncId();
            node.setAttribute("FUNCID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam()!=null) {
            Object obj = et.getParam();
            node.setAttribute("PARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSysAdminFuncId()!=null) {
            Object obj = et.getSysAdminFuncId();
            node.setAttribute("SYSADMINFUNCID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSysAdminFuncName()!=null) {
            Object obj = et.getSysAdminFuncName();
            node.setAttribute("SYSADMINFUNCNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSysAdminId()!=null) {
            Object obj = et.getSysAdminId();
            node.setAttribute("SYSADMINID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSysAdminName()!=null) {
            Object obj = et.getSysAdminName();
            node.setAttribute("SYSADMINNAME",(obj==null)?"":(String)obj);
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
        SysAdminFuncBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(SysAdminFuncBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAdminObjectDirty() && (bIncEmpty||et.getAdminObject()!=null)) {
            dst.set(FIELD_ADMINOBJECT,et.getAdminObject());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isFuncIdDirty() && (bIncEmpty||et.getFuncId()!=null)) {
            dst.set(FIELD_FUNCID,et.getFuncId());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isParamDirty() && (bIncEmpty||et.getParam()!=null)) {
            dst.set(FIELD_PARAM,et.getParam());
        }
        if(et.isSysAdminFuncIdDirty() && (bIncEmpty||et.getSysAdminFuncId()!=null)) {
            dst.set(FIELD_SYSADMINFUNCID,et.getSysAdminFuncId());
        }
        if(et.isSysAdminFuncNameDirty() && (bIncEmpty||et.getSysAdminFuncName()!=null)) {
            dst.set(FIELD_SYSADMINFUNCNAME,et.getSysAdminFuncName());
        }
        if(et.isSysAdminIdDirty() && (bIncEmpty||et.getSysAdminId()!=null)) {
            dst.set(FIELD_SYSADMINID,et.getSysAdminId());
        }
        if(et.isSysAdminNameDirty() && (bIncEmpty||et.getSysAdminName()!=null)) {
            dst.set(FIELD_SYSADMINNAME,et.getSysAdminName());
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
        return  SysAdminFuncBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(SysAdminFuncBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ADMINOBJECT:
            et.resetAdminObject();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_FUNCID:
            et.resetFuncId();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_PARAM:
            et.resetParam();
            return true;
        case INDEX_SYSADMINFUNCID:
            et.resetSysAdminFuncId();
            return true;
        case INDEX_SYSADMINFUNCNAME:
            et.resetSysAdminFuncName();
            return true;
        case INDEX_SYSADMINID:
            et.resetSysAdminId();
            return true;
        case INDEX_SYSADMINNAME:
            et.resetSysAdminName();
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


    private Integer objSysAdminLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.SysAdmin sysadmin = null;
    /**
    * 获取父数据 系统管理模块
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.SysAdmin getSysAdmin() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSysAdmin();
        }

        if(this.getSysAdminId()==null)
            return null;
        synchronized(this.objSysAdminLock) {
            if(this.sysadmin!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getSysAdminId(),sysadmin.getSysAdminId())!=0) {
                    this.sysadmin = null;
                }
            }


            if(this.sysadmin==null) {
                net.ibizsys.psrt.srv.common.entity.SysAdmin sysadmin = new net.ibizsys.psrt.srv.common.entity.SysAdmin();
                sysadmin.setSysAdminId(this.getSysAdminId());
                net.ibizsys.psrt.srv.common.service.SysAdminService service = (net.ibizsys.psrt.srv.common.service.SysAdminService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.SysAdminService.class,this.getSessionFactory());
                service.autoGet(sysadmin);
                this.sysadmin = sysadmin;
            }
            return this.sysadmin;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private SysAdminFuncBase getProxyEntity() {
        return this.proxySysAdminFuncBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxySysAdminFuncBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof SysAdminFuncBase) {
            this.proxySysAdminFuncBase = (SysAdminFuncBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.SysAdminFuncService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}