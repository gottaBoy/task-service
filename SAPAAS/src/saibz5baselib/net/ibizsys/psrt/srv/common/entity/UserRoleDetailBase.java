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
 * 实体[UserRoleDetail] 数据对象基类
 */
public abstract class UserRoleDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDetailBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
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
     * 属性[用户角色]
     */
    public final static String FIELD_USERROLENAME = "UESRROLENAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户数据]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[用户数据2]
     */
    public final static String FIELD_USERDATA2 = "USERDATA2";
    /**
     * 属性[用户对象]
     */
    public final static String FIELD_USEROBJECTID = "USEROBJECTID";
    /**
     * 属性[用户对象]
     */
    public final static String FIELD_USEROBJECTNAME = "USEROBJECTNAME";
    /**
     * 属性[用户角色成员标识]
     */
    public final static String FIELD_USERROLEDETAILID = "USERROLEDETAILID";
    /**
     * 属性[用户角色成员名称]
     */
    public final static String FIELD_USERROLEDETAILNAME = "USERROLEDETAILNAME";
    /**
     * 属性[用户角色]
     */
    public final static String FIELD_USERROLEID = "USERROLEID";
    /**
     * 属性[用户自定义]
     */
    public final static String FIELD_USERTAG = "USERTAG";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_RESERVER = 2;
    private final static int INDEX_RESERVER2 = 3;
    private final static int INDEX_RESERVER3 = 4;
    private final static int INDEX_RESERVER4 = 5;
    private final static int INDEX_USERROLENAME = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_USERDATA = 9;
    private final static int INDEX_USERDATA2 = 10;
    private final static int INDEX_USEROBJECTID = 11;
    private final static int INDEX_USEROBJECTNAME = 12;
    private final static int INDEX_USERROLEDETAILID = 13;
    private final static int INDEX_USERROLEDETAILNAME = 14;
    private final static int INDEX_USERROLEID = 15;
    private final static int INDEX_USERTAG = 16;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_USERROLENAME, INDEX_USERROLENAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USEROBJECTID, INDEX_USEROBJECTID);
        fieldIndexMap.put( FIELD_USEROBJECTNAME, INDEX_USEROBJECTNAME);
        fieldIndexMap.put( FIELD_USERROLEDETAILID, INDEX_USERROLEDETAILID);
        fieldIndexMap.put( FIELD_USERROLEDETAILNAME, INDEX_USERROLEDETAILNAME);
        fieldIndexMap.put( FIELD_USERROLEID, INDEX_USERROLEID);
        fieldIndexMap.put( FIELD_USERTAG, INDEX_USERTAG);
    }

    private UserRoleDetailBase proxyUserRoleDetailBase = null;
    public UserRoleDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean userrolenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;
    private boolean userroledetailidDirtyFlag = false;
    private boolean userroledetailnameDirtyFlag = false;
    private boolean userroleidDirtyFlag = false;
    private boolean usertagDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="userrolename")
    private String userrolename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userobjectid")
    private String userobjectid;
    @Column(name="userobjectname")
    private String userobjectname;
    @Column(name="userroledetailid")
    private String userroledetailid;
    @Column(name="userroledetailname")
    private String userroledetailname;
    @Column(name="userroleid")
    private String userroleid;
    @Column(name="usertag")
    private String usertag;


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
     *  设置属性值[用户角色]
     *  @param userrolename
     */
    public void setUserRoleName(String userrolename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleName(userrolename);
            return;
        }
        if(userrolename!=null) {
            userrolename = StringHelper.trimRight(userrolename);
            if(userrolename.length()==0) {
                userrolename = null;
            }
        }
        this.userrolename = userrolename;
        this.userrolenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户角色]
     */
    public String getUserRoleName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleName();
        }
        return this.userrolename;
    }

    /**
     *  获取属性值[用户角色]是否修改
     */
    public boolean isUserRoleNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleNameDirty();
        }
        return this.userrolenameDirtyFlag;
    }

    /**
     *  重置属性值[用户角色]
     */
    public void resetUserRoleName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleName();
            return;
        }

        this.userrolenameDirtyFlag = false;
        this.userrolename = null;
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
     *  设置属性值[用户数据]
     *  @param userdata
     */
    public void setUserData(String userdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if(userdata!=null) {
            userdata = StringHelper.trimRight(userdata);
            if(userdata.length()==0) {
                userdata = null;
            }
        }
        this.userdata = userdata;
        this.userdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[用户数据]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[用户数据]
     */
    public void resetUserData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData();
            return;
        }

        this.userdataDirtyFlag = false;
        this.userdata = null;
    }
    /**
     *  设置属性值[用户数据2]
     *  @param userdata2
     */
    public void setUserData2(String userdata2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if(userdata2!=null) {
            userdata2 = StringHelper.trimRight(userdata2);
            if(userdata2.length()==0) {
                userdata2 = null;
            }
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据2]
     */
    public String getUserData2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    /**
     *  获取属性值[用户数据2]是否修改
     */
    public boolean isUserData2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    /**
     *  重置属性值[用户数据2]
     */
    public void resetUserData2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData2();
            return;
        }

        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }
    /**
     *  设置属性值[用户对象]
     *  @param userobjectid
     */
    public void setUserObjectId(String userobjectid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserObjectId(userobjectid);
            return;
        }
        if(userobjectid!=null) {
            userobjectid = StringHelper.trimRight(userobjectid);
            if(userobjectid.length()==0) {
                userobjectid = null;
            }
        }
        this.userobjectid = userobjectid;
        this.userobjectidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户对象]
     */
    public String getUserObjectId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectId();
        }
        return this.userobjectid;
    }

    /**
     *  获取属性值[用户对象]是否修改
     */
    public boolean isUserObjectIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectIdDirty();
        }
        return this.userobjectidDirtyFlag;
    }

    /**
     *  重置属性值[用户对象]
     */
    public void resetUserObjectId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserObjectId();
            return;
        }

        this.userobjectidDirtyFlag = false;
        this.userobjectid = null;
    }
    /**
     *  设置属性值[用户对象]
     *  @param userobjectname
     */
    public void setUserObjectName(String userobjectname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserObjectName(userobjectname);
            return;
        }
        if(userobjectname!=null) {
            userobjectname = StringHelper.trimRight(userobjectname);
            if(userobjectname.length()==0) {
                userobjectname = null;
            }
        }
        this.userobjectname = userobjectname;
        this.userobjectnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户对象]
     */
    public String getUserObjectName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectName();
        }
        return this.userobjectname;
    }

    /**
     *  获取属性值[用户对象]是否修改
     */
    public boolean isUserObjectNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectNameDirty();
        }
        return this.userobjectnameDirtyFlag;
    }

    /**
     *  重置属性值[用户对象]
     */
    public void resetUserObjectName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserObjectName();
            return;
        }

        this.userobjectnameDirtyFlag = false;
        this.userobjectname = null;
    }
    /**
     *  设置属性值[用户角色成员标识]
     *  @param userroledetailid
     */
    public void setUserRoleDetailId(String userroledetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDetailId(userroledetailid);
            return;
        }
        if(userroledetailid!=null) {
            userroledetailid = StringHelper.trimRight(userroledetailid);
            if(userroledetailid.length()==0) {
                userroledetailid = null;
            }
        }
        this.userroledetailid = userroledetailid;
        this.userroledetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户角色成员标识]
     */
    public String getUserRoleDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDetailId();
        }
        return this.userroledetailid;
    }

    /**
     *  获取属性值[用户角色成员标识]是否修改
     */
    public boolean isUserRoleDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDetailIdDirty();
        }
        return this.userroledetailidDirtyFlag;
    }

    /**
     *  重置属性值[用户角色成员标识]
     */
    public void resetUserRoleDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDetailId();
            return;
        }

        this.userroledetailidDirtyFlag = false;
        this.userroledetailid = null;
    }
    /**
     *  设置属性值[用户角色成员名称]
     *  @param userroledetailname
     */
    public void setUserRoleDetailName(String userroledetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleDetailName(userroledetailname);
            return;
        }
        if(userroledetailname!=null) {
            userroledetailname = StringHelper.trimRight(userroledetailname);
            if(userroledetailname.length()==0) {
                userroledetailname = null;
            }
        }
        this.userroledetailname = userroledetailname;
        this.userroledetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户角色成员名称]
     */
    public String getUserRoleDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleDetailName();
        }
        return this.userroledetailname;
    }

    /**
     *  获取属性值[用户角色成员名称]是否修改
     */
    public boolean isUserRoleDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleDetailNameDirty();
        }
        return this.userroledetailnameDirtyFlag;
    }

    /**
     *  重置属性值[用户角色成员名称]
     */
    public void resetUserRoleDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleDetailName();
            return;
        }

        this.userroledetailnameDirtyFlag = false;
        this.userroledetailname = null;
    }
    /**
     *  设置属性值[用户角色]
     *  @param userroleid
     */
    public void setUserRoleId(String userroleid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserRoleId(userroleid);
            return;
        }
        if(userroleid!=null) {
            userroleid = StringHelper.trimRight(userroleid);
            if(userroleid.length()==0) {
                userroleid = null;
            }
        }
        this.userroleid = userroleid;
        this.userroleidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户角色]
     */
    public String getUserRoleId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRoleId();
        }
        return this.userroleid;
    }

    /**
     *  获取属性值[用户角色]是否修改
     */
    public boolean isUserRoleIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserRoleIdDirty();
        }
        return this.userroleidDirtyFlag;
    }

    /**
     *  重置属性值[用户角色]
     */
    public void resetUserRoleId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserRoleId();
            return;
        }

        this.userroleidDirtyFlag = false;
        this.userroleid = null;
    }
    /**
     *  设置属性值[用户自定义]
     *  @param usertag
     */
    public void setUserTag(String usertag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserTag(usertag);
            return;
        }
        if(usertag!=null) {
            usertag = StringHelper.trimRight(usertag);
            if(usertag.length()==0) {
                usertag = null;
            }
        }
        this.usertag = usertag;
        this.usertagDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户自定义]
     */
    public String getUserTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    /**
     *  获取属性值[用户自定义]是否修改
     */
    public boolean isUserTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    /**
     *  重置属性值[用户自定义]
     */
    public void resetUserTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserTag();
            return;
        }

        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserRoleDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserRoleDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUserRoleName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserObjectId();
        et.resetUserObjectName();
        et.resetUserRoleDetailId();
        et.resetUserRoleDetailName();
        et.resetUserRoleId();
        et.resetUserTag();
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
        if(!bDirtyOnly || isUserRoleNameDirty()) {
            params.put(FIELD_USERROLENAME,getUserRoleName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDataDirty()) {
            params.put(FIELD_USERDATA,getUserData());
        }
        if(!bDirtyOnly || isUserData2Dirty()) {
            params.put(FIELD_USERDATA2,getUserData2());
        }
        if(!bDirtyOnly || isUserObjectIdDirty()) {
            params.put(FIELD_USEROBJECTID,getUserObjectId());
        }
        if(!bDirtyOnly || isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME,getUserObjectName());
        }
        if(!bDirtyOnly || isUserRoleDetailIdDirty()) {
            params.put(FIELD_USERROLEDETAILID,getUserRoleDetailId());
        }
        if(!bDirtyOnly || isUserRoleDetailNameDirty()) {
            params.put(FIELD_USERROLEDETAILNAME,getUserRoleDetailName());
        }
        if(!bDirtyOnly || isUserRoleIdDirty()) {
            params.put(FIELD_USERROLEID,getUserRoleId());
        }
        if(!bDirtyOnly || isUserTagDirty()) {
            params.put(FIELD_USERTAG,getUserTag());
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

        return  UserRoleDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserRoleDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_USERROLENAME:
            return et.getUserRoleName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_USEROBJECTID:
            return et.getUserObjectId();
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName();
        case INDEX_USERROLEDETAILID:
            return et.getUserRoleDetailId();
        case INDEX_USERROLEDETAILNAME:
            return et.getUserRoleDetailName();
        case INDEX_USERROLEID:
            return et.getUserRoleId();
        case INDEX_USERTAG:
            return et.getUserTag();
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

        UserRoleDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserRoleDetailBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
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
        case INDEX_USERROLENAME:
            et.setUserRoleName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA:
            et.setUserData(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA2:
            et.setUserData2(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECTID:
            et.setUserObjectId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECTNAME:
            et.setUserObjectName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEDETAILID:
            et.setUserRoleDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEDETAILNAME:
            et.setUserRoleDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERROLEID:
            et.setUserRoleId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERTAG:
            et.setUserTag(DataObject.getStringValue(obj));
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

        return  UserRoleDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserRoleDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_USERROLENAME:
            return et.getUserRoleName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_USEROBJECTID:
            return et.getUserObjectId()==null;
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName()==null;
        case INDEX_USERROLEDETAILID:
            return et.getUserRoleDetailId()==null;
        case INDEX_USERROLEDETAILNAME:
            return et.getUserRoleDetailName()==null;
        case INDEX_USERROLEID:
            return et.getUserRoleId()==null;
        case INDEX_USERTAG:
            return et.getUserTag()==null;
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
        return  UserRoleDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserRoleDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_USERROLENAME:
            return et.isUserRoleNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_USEROBJECTID:
            return et.isUserObjectIdDirty();
        case INDEX_USEROBJECTNAME:
            return et.isUserObjectNameDirty();
        case INDEX_USERROLEDETAILID:
            return et.isUserRoleDetailIdDirty();
        case INDEX_USERROLEDETAILNAME:
            return et.isUserRoleDetailNameDirty();
        case INDEX_USERROLEID:
            return et.isUserRoleIdDirty();
        case INDEX_USERTAG:
            return et.isUserTagDirty();
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
    private static  void fillJSONObject(UserRoleDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
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
        if(bIncEmpty||et.getUserRoleName()!=null) {
            JSONObjectHelper.put(json,"uesrrolename",getJSONValue(et.getUserRoleName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            JSONObjectHelper.put(json,"userdata",getJSONValue(et.getUserData()),false);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            JSONObjectHelper.put(json,"userdata2",getJSONValue(et.getUserData2()),false);
        }
        if(bIncEmpty||et.getUserObjectId()!=null) {
            JSONObjectHelper.put(json,"userobjectid",getJSONValue(et.getUserObjectId()),false);
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            JSONObjectHelper.put(json,"userobjectname",getJSONValue(et.getUserObjectName()),false);
        }
        if(bIncEmpty||et.getUserRoleDetailId()!=null) {
            JSONObjectHelper.put(json,"userroledetailid",getJSONValue(et.getUserRoleDetailId()),false);
        }
        if(bIncEmpty||et.getUserRoleDetailName()!=null) {
            JSONObjectHelper.put(json,"userroledetailname",getJSONValue(et.getUserRoleDetailName()),false);
        }
        if(bIncEmpty||et.getUserRoleId()!=null) {
            JSONObjectHelper.put(json,"userroleid",getJSONValue(et.getUserRoleId()),false);
        }
        if(bIncEmpty||et.getUserTag()!=null) {
            JSONObjectHelper.put(json,"usertag",getJSONValue(et.getUserTag()),false);
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
    private static void fillXmlNode(UserRoleDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getUserRoleName()!=null) {
            Object obj = et.getUserRoleName();
            node.setAttribute("USERROLENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            Object obj = et.getUserData();
            node.setAttribute("USERDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            Object obj = et.getUserData2();
            node.setAttribute("USERDATA2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObjectId()!=null) {
            Object obj = et.getUserObjectId();
            node.setAttribute("USEROBJECTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            Object obj = et.getUserObjectName();
            node.setAttribute("USEROBJECTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleDetailId()!=null) {
            Object obj = et.getUserRoleDetailId();
            node.setAttribute("USERROLEDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleDetailName()!=null) {
            Object obj = et.getUserRoleDetailName();
            node.setAttribute("USERROLEDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserRoleId()!=null) {
            Object obj = et.getUserRoleId();
            node.setAttribute("USERROLEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserTag()!=null) {
            Object obj = et.getUserTag();
            node.setAttribute("USERTAG",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserRoleDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
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
        if(et.isUserRoleNameDirty() && (bIncEmpty||et.getUserRoleName()!=null)) {
            dst.set(FIELD_USERROLENAME,et.getUserRoleName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDataDirty() && (bIncEmpty||et.getUserData()!=null)) {
            dst.set(FIELD_USERDATA,et.getUserData());
        }
        if(et.isUserData2Dirty() && (bIncEmpty||et.getUserData2()!=null)) {
            dst.set(FIELD_USERDATA2,et.getUserData2());
        }
        if(et.isUserObjectIdDirty() && (bIncEmpty||et.getUserObjectId()!=null)) {
            dst.set(FIELD_USEROBJECTID,et.getUserObjectId());
        }
        if(et.isUserObjectNameDirty() && (bIncEmpty||et.getUserObjectName()!=null)) {
            dst.set(FIELD_USEROBJECTNAME,et.getUserObjectName());
        }
        if(et.isUserRoleDetailIdDirty() && (bIncEmpty||et.getUserRoleDetailId()!=null)) {
            dst.set(FIELD_USERROLEDETAILID,et.getUserRoleDetailId());
        }
        if(et.isUserRoleDetailNameDirty() && (bIncEmpty||et.getUserRoleDetailName()!=null)) {
            dst.set(FIELD_USERROLEDETAILNAME,et.getUserRoleDetailName());
        }
        if(et.isUserRoleIdDirty() && (bIncEmpty||et.getUserRoleId()!=null)) {
            dst.set(FIELD_USERROLEID,et.getUserRoleId());
        }
        if(et.isUserTagDirty() && (bIncEmpty||et.getUserTag()!=null)) {
            dst.set(FIELD_USERTAG,et.getUserTag());
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
        return  UserRoleDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserRoleDetailBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
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
        case INDEX_USERROLENAME:
            et.resetUserRoleName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDATA:
            et.resetUserData();
            return true;
        case INDEX_USERDATA2:
            et.resetUserData2();
            return true;
        case INDEX_USEROBJECTID:
            et.resetUserObjectId();
            return true;
        case INDEX_USEROBJECTNAME:
            et.resetUserObjectName();
            return true;
        case INDEX_USERROLEDETAILID:
            et.resetUserRoleDetailId();
            return true;
        case INDEX_USERROLEDETAILNAME:
            et.resetUserRoleDetailName();
            return true;
        case INDEX_USERROLEID:
            et.resetUserRoleId();
            return true;
        case INDEX_USERTAG:
            et.resetUserTag();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objUserObjectLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserObject userobject = null;
    /**
    * 获取父数据 用户对象
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserObject getUserObject() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObject();
        }

        if(this.getUserObjectId()==null)
            return null;
        synchronized(this.objUserObjectLock) {
            if(this.userobject!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserObjectId(),userobject.getUserObjectId())!=0) {
                    this.userobject = null;
                }
            }


            if(this.userobject==null) {
                net.ibizsys.psrt.srv.common.entity.UserObject userobject = new net.ibizsys.psrt.srv.common.entity.UserObject();
                userobject.setUserObjectId(this.getUserObjectId());
                net.ibizsys.psrt.srv.common.service.UserObjectService service = (net.ibizsys.psrt.srv.common.service.UserObjectService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserObjectService.class,this.getSessionFactory());
                service.autoGet(userobject);
                this.userobject = userobject;
            }
            return this.userobject;
        }
    }

    private Integer objUserRoleLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserRole userrole = null;
    /**
    * 获取父数据 用户角色
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserRole getUserRole() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserRole();
        }

        if(this.getUserRoleId()==null)
            return null;
        synchronized(this.objUserRoleLock) {
            if(this.userrole!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserRoleId(),userrole.getUserRoleId())!=0) {
                    this.userrole = null;
                }
            }


            if(this.userrole==null) {
                net.ibizsys.psrt.srv.common.entity.UserRole userrole = new net.ibizsys.psrt.srv.common.entity.UserRole();
                userrole.setUserRoleId(this.getUserRoleId());
                net.ibizsys.psrt.srv.common.service.UserRoleService service = (net.ibizsys.psrt.srv.common.service.UserRoleService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserRoleService.class,this.getSessionFactory());
                service.autoGet(userrole);
                this.userrole = userrole;
            }
            return this.userrole;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private UserRoleDetailBase getProxyEntity() {
        return this.proxyUserRoleDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserRoleDetailBase) {
            this.proxyUserRoleDetailBase = (UserRoleDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}