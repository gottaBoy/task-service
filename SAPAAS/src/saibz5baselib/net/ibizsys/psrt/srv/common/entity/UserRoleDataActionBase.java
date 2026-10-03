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
 * 实体[UserRoleDataAction] 数据对象基类
 */
public abstract class UserRoleDataActionBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDataActionBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[允许]
     */
    public final static String FIELD_ISALLOW = "ISALLOW";
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
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户角色数据操作标识]
     */
    public final static String FIELD_USERROLEDATAACTIONID = "USERROLEDATAACTIONID";
    /**
     * 属性[操作名称]
     */
    public final static String FIELD_USERROLEDATAACTIONNAME = "USERROLEDATAACTIONNAME";
    /**
     * 属性[用户角色数据操作_用户角色数据]
     */
    public final static String FIELD_USERROLEDATAID = "USERROLEDATAID";
    /**
     * 属性[用户角色]
     */
    public final static String FIELD_USERROLEDATANAME = "USERROLEDATANAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ISALLOW = 2;
    private final static int INDEX_RESERVER = 3;
    private final static int INDEX_RESERVER2 = 4;
    private final static int INDEX_RESERVER3 = 5;
    private final static int INDEX_RESERVER4 = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_USERROLEDATAACTIONID = 9;
    private final static int INDEX_USERROLEDATAACTIONNAME = 10;
    private final static int INDEX_USERROLEDATAID = 11;
    private final static int INDEX_USERROLEDATANAME = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ISALLOW, INDEX_ISALLOW);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERROLEDATAACTIONID, INDEX_USERROLEDATAACTIONID);
        fieldIndexMap.put( FIELD_USERROLEDATAACTIONNAME, INDEX_USERROLEDATAACTIONNAME);
        fieldIndexMap.put( FIELD_USERROLEDATAID, INDEX_USERROLEDATAID);
        fieldIndexMap.put( FIELD_USERROLEDATANAME, INDEX_USERROLEDATANAME);
    }

    private UserRoleDataActionBase proxyUserRoleDataActionBase = null;
    public UserRoleDataActionBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isallowDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userroledataactionidDirtyFlag = false;
    private boolean userroledataactionnameDirtyFlag = false;
    private boolean userroledataidDirtyFlag = false;
    private boolean userroledatanameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="isallow")
    private Integer isallow;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userroledataactionid")
    private String userroledataactionid;
    @Column(name="userroledataactionname")
    private String userroledataactionname;
    @Column(name="userroledataid")
    private String userroledataid;
    @Column(name="userroledataname")
    private String userroledataname;


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
     *  设置属性值[允许]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isallow
     */
    public void setIsAllow(Integer isallow) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsAllow(isallow);
            return;
        }
        this.isallow = isallow;
        this.isallowDirtyFlag  = true;
    }

    /**
     *  获取属性值[允许]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsAllow() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsAllow();
        }
        return this.isallow;
    }

    /**
     *  获取属性值[允许]是否修改
     */
    public boolean isIsAllowDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsAllowDirty();
        }
        return this.isallowDirtyFlag;
    }

    /**
     *  重置属性值[允许]
     */
    public void resetIsAllow() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsAllow();
            return;
        }

        this.isallowDirtyFlag = false;
        this.isallow = null;
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
     *  设置属性值[用户角色数据操作标识]
     *  @param userroledataactionid
     */
    public void setUserRoleDataActionId(String userroledataactionid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDataActionId(userroledataactionid);
            return;
        }
        if(userroledataactionid!=null) {
            userroledataactionid = StringHelper.trimRight(userroledataactionid);
            if(userroledataactionid.length()==0) {
                userroledataactionid = null;
            }
        }
        this.userroledataactionid = userroledataactionid;
        this.userroledataactionidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户角色数据操作标识]
     */
    public String getUserRoleDataActionId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataActionId();
        }
        return this.userroledataactionid;
    }

    /**
     *  获取属性值[用户角色数据操作标识]是否修改
     */
    public boolean isUserRoleDataActionIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataActionIdDirty();
        }
        return this.userroledataactionidDirtyFlag;
    }

    /**
     *  重置属性值[用户角色数据操作标识]
     */
    public void resetUserRoleDataActionId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDataActionId();
            return;
        }

        this.userroledataactionidDirtyFlag = false;
        this.userroledataactionid = null;
    }
    /**
     *  设置属性值[操作名称]
     *  @param userroledataactionname
     */
    public void setUserRoleDataActionName(String userroledataactionname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDataActionName(userroledataactionname);
            return;
        }
        if(userroledataactionname!=null) {
            userroledataactionname = StringHelper.trimRight(userroledataactionname);
            if(userroledataactionname.length()==0) {
                userroledataactionname = null;
            }
        }
        this.userroledataactionname = userroledataactionname;
        this.userroledataactionnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作名称]
     */
    public String getUserRoleDataActionName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataActionName();
        }
        return this.userroledataactionname;
    }

    /**
     *  获取属性值[操作名称]是否修改
     */
    public boolean isUserRoleDataActionNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataActionNameDirty();
        }
        return this.userroledataactionnameDirtyFlag;
    }

    /**
     *  重置属性值[操作名称]
     */
    public void resetUserRoleDataActionName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDataActionName();
            return;
        }

        this.userroledataactionnameDirtyFlag = false;
        this.userroledataactionname = null;
    }
    /**
     *  设置属性值[用户角色数据操作_用户角色数据]
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
     *  获取属性值[用户角色数据操作_用户角色数据]
     */
    public String getUserRoleDataId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataId();
        }
        return this.userroledataid;
    }

    /**
     *  获取属性值[用户角色数据操作_用户角色数据]是否修改
     */
    public boolean isUserRoleDataIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataIdDirty();
        }
        return this.userroledataidDirtyFlag;
    }

    /**
     *  重置属性值[用户角色数据操作_用户角色数据]
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
     *  设置属性值[用户角色]
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
     *  获取属性值[用户角色]
     */
    public String getUserRoleDataName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDataName();
        }
        return this.userroledataname;
    }

    /**
     *  获取属性值[用户角色]是否修改
     */
    public boolean isUserRoleDataNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDataNameDirty();
        }
        return this.userroledatanameDirtyFlag;
    }

    /**
     *  重置属性值[用户角色]
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
        UserRoleDataActionBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserRoleDataActionBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsAllow();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserRoleDataActionId();
        et.resetUserRoleDataActionName();
        et.resetUserRoleDataId();
        et.resetUserRoleDataName();
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
        if(!bDirtyOnly || isIsAllowDirty()) {
            params.put(FIELD_ISALLOW,getIsAllow());
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
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserRoleDataActionIdDirty()) {
            params.put(FIELD_USERROLEDATAACTIONID,getUserRoleDataActionId());
        }
        if(!bDirtyOnly || isUserRoleDataActionNameDirty()) {
            params.put(FIELD_USERROLEDATAACTIONNAME,getUserRoleDataActionName());
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

        return  UserRoleDataActionBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserRoleDataActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ISALLOW:
            return et.getIsAllow();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERROLEDATAACTIONID:
            return et.getUserRoleDataActionId();
        case INDEX_USERROLEDATAACTIONNAME:
            return et.getUserRoleDataActionName();
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

        UserRoleDataActionBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserRoleDataActionBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISALLOW:
            et.setIsAllow(DataObject.getIntegerValue(obj));
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
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEDATAACTIONID:
            et.setUserRoleDataActionId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEDATAACTIONNAME:
            et.setUserRoleDataActionName(DataObject.getStringValue(obj));
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

        return  UserRoleDataActionBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserRoleDataActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ISALLOW:
            return et.getIsAllow()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERROLEDATAACTIONID:
            return et.getUserRoleDataActionId()==null;
        case INDEX_USERROLEDATAACTIONNAME:
            return et.getUserRoleDataActionName()==null;
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
        return  UserRoleDataActionBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserRoleDataActionBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ISALLOW:
            return et.isIsAllowDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERROLEDATAACTIONID:
            return et.isUserRoleDataActionIdDirty();
        case INDEX_USERROLEDATAACTIONNAME:
            return et.isUserRoleDataActionNameDirty();
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
    private static  void fillJSONObject(UserRoleDataActionBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getIsAllow()!=null) {
            JSONObjectHelper.put(json,"isallow",getJSONValue(et.getIsAllow()),false);
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserRoleDataActionId()!=null) {
            JSONObjectHelper.put(json,"userroledataactionid",getJSONValue(et.getUserRoleDataActionId()),false);
        }
        if(bIncEmpty||et.getUserRoleDataActionName()!=null) {
            JSONObjectHelper.put(json,"userroledataactionname",getJSONValue(et.getUserRoleDataActionName()),false);
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
    private static void fillXmlNode(UserRoleDataActionBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsAllow()!=null) {
            Object obj = et.getIsAllow();
            node.setAttribute("ISALLOW",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleDataActionId()!=null) {
            Object obj = et.getUserRoleDataActionId();
            node.setAttribute("USERROLEDATAACTIONID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleDataActionName()!=null) {
            Object obj = et.getUserRoleDataActionName();
            node.setAttribute("USERROLEDATAACTIONNAME",(obj==null)?"":(String)obj);
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
        UserRoleDataActionBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserRoleDataActionBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isIsAllowDirty() && (bIncEmpty||et.getIsAllow()!=null)) {
            dst.set(FIELD_ISALLOW,et.getIsAllow());
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
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserRoleDataActionIdDirty() && (bIncEmpty||et.getUserRoleDataActionId()!=null)) {
            dst.set(FIELD_USERROLEDATAACTIONID,et.getUserRoleDataActionId());
        }
        if(et.isUserRoleDataActionNameDirty() && (bIncEmpty||et.getUserRoleDataActionName()!=null)) {
            dst.set(FIELD_USERROLEDATAACTIONNAME,et.getUserRoleDataActionName());
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
        return  UserRoleDataActionBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserRoleDataActionBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ISALLOW:
            et.resetIsAllow();
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
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERROLEDATAACTIONID:
            et.resetUserRoleDataActionId();
            return true;
        case INDEX_USERROLEDATAACTIONNAME:
            et.resetUserRoleDataActionName();
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


    private Integer objUserRoleDataLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserRoleData userroledata = null;
    /**
    * 获取父数据 数据对象能力
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserRoleData getUserRoleData() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleData();
        }

        if(this.getUserRoleDataId()==null)
            return null;
        synchronized(this.objUserRoleDataLock) {
            if(this.userroledata!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserRoleDataId(),userroledata.getUserRoleDataId())!=0) {
                    this.userroledata = null;
                }
            }


            if(this.userroledata==null) {
                net.ibizsys.psrt.srv.common.entity.UserRoleData userroledata = new net.ibizsys.psrt.srv.common.entity.UserRoleData();
                userroledata.setUserRoleDataId(this.getUserRoleDataId());
                net.ibizsys.psrt.srv.common.service.UserRoleDataService service = (net.ibizsys.psrt.srv.common.service.UserRoleDataService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserRoleDataService.class,this.getSessionFactory());
                service.autoGet(userroledata);
                this.userroledata = userroledata;
            }
            return this.userroledata;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private UserRoleDataActionBase getProxyEntity() {
        return this.proxyUserRoleDataActionBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDataActionBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserRoleDataActionBase) {
            this.proxyUserRoleDataActionBase = (UserRoleDataActionBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDataActionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}