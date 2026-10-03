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
 * 实体[UserObject] 数据对象基类
 */
public abstract class UserObjectBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserObjectBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[所有者标识]
     */
    public final static String FIELD_OWNERID = "OWNERID";
    /**
     * 属性[所有者类型]
     */
    public final static String FIELD_OWNERTYPE = "OWNERTYPE";
    /**
     * 属性[子类型]
     */
    public final static String FIELD_SUBTYPE = "SUBTYPE";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[自定义数据]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[自定义数据2]
     */
    public final static String FIELD_USERDATA2 = "USERDATA2";
    /**
     * 属性[用户对象标识]
     */
    public final static String FIELD_USEROBJECTID = "USEROBJECTID";
    /**
     * 属性[用户对象级别]
     */
    public final static String FIELD_USEROBJECTLEVEL = "USEROBJECTLEVEL";
    /**
     * 属性[用户对象名称]
     */
    public final static String FIELD_USEROBJECTNAME = "USEROBJECTNAME";
    /**
     * 属性[用户对象类型]
     */
    public final static String FIELD_USEROBJECTTYPE = "USEROBJECTTYPE";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ENABLE = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_OWNERID = 4;
    private final static int INDEX_OWNERTYPE = 5;
    private final static int INDEX_SUBTYPE = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_USERDATA = 9;
    private final static int INDEX_USERDATA2 = 10;
    private final static int INDEX_USEROBJECTID = 11;
    private final static int INDEX_USEROBJECTLEVEL = 12;
    private final static int INDEX_USEROBJECTNAME = 13;
    private final static int INDEX_USEROBJECTTYPE = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_OWNERID, INDEX_OWNERID);
        fieldIndexMap.put( FIELD_OWNERTYPE, INDEX_OWNERTYPE);
        fieldIndexMap.put( FIELD_SUBTYPE, INDEX_SUBTYPE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USEROBJECTID, INDEX_USEROBJECTID);
        fieldIndexMap.put( FIELD_USEROBJECTLEVEL, INDEX_USEROBJECTLEVEL);
        fieldIndexMap.put( FIELD_USEROBJECTNAME, INDEX_USEROBJECTNAME);
        fieldIndexMap.put( FIELD_USEROBJECTTYPE, INDEX_USEROBJECTTYPE);
    }

    private UserObjectBase proxyUserObjectBase = null;
    public UserObjectBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean subtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectlevelDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;
    private boolean userobjecttypeDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="subtype")
    private String subtype;
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
    @Column(name="userobjectlevel")
    private Integer userobjectlevel;
    @Column(name="userobjectname")
    private String userobjectname;
    @Column(name="userobjecttype")
    private String userobjecttype;


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
     *  设置属性值[逻辑有效标志]
     *  @param enable
     */
    public void setEnable(Integer enable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑有效标志]
     */
    public Integer getEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    /**
     *  获取属性值[逻辑有效标志]是否修改
     */
    public boolean isEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    /**
     *  重置属性值[逻辑有效标志]
     */
    public void resetEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnable();
            return;
        }

        this.enableDirtyFlag = false;
        this.enable = null;
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
     *  设置属性值[所有者标识]
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
     *  获取属性值[所有者标识]
     */
    public String getOwnerId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    /**
     *  获取属性值[所有者标识]是否修改
     */
    public boolean isOwnerIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    /**
     *  重置属性值[所有者标识]
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
     *  设置属性值[所有者类型]
     *  @param ownertype
     */
    public void setOwnerType(String ownertype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOwnerType(ownertype);
            return;
        }
        if(ownertype!=null) {
            ownertype = StringHelper.trimRight(ownertype);
            if(ownertype.length()==0) {
                ownertype = null;
            }
        }
        this.ownertype = ownertype;
        this.ownertypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[所有者类型]
     */
    public String getOwnerType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    /**
     *  获取属性值[所有者类型]是否修改
     */
    public boolean isOwnerTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    /**
     *  重置属性值[所有者类型]
     */
    public void resetOwnerType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }

        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }
    /**
     *  设置属性值[子类型]
     *  @param subtype
     */
    public void setSubType(String subtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSubType(subtype);
            return;
        }
        if(subtype!=null) {
            subtype = StringHelper.trimRight(subtype);
            if(subtype.length()==0) {
                subtype = null;
            }
        }
        this.subtype = subtype;
        this.subtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[子类型]
     */
    public String getSubType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSubType();
        }
        return this.subtype;
    }

    /**
     *  获取属性值[子类型]是否修改
     */
    public boolean isSubTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSubTypeDirty();
        }
        return this.subtypeDirtyFlag;
    }

    /**
     *  重置属性值[子类型]
     */
    public void resetSubType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSubType();
            return;
        }

        this.subtypeDirtyFlag = false;
        this.subtype = null;
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
     *  设置属性值[自定义数据]
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
     *  获取属性值[自定义数据]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[自定义数据]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[自定义数据]
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
     *  设置属性值[自定义数据2]
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
     *  获取属性值[自定义数据2]
     */
    public String getUserData2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    /**
     *  获取属性值[自定义数据2]是否修改
     */
    public boolean isUserData2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    /**
     *  重置属性值[自定义数据2]
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
     *  设置属性值[用户对象标识]
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
     *  获取属性值[用户对象标识]
     */
    public String getUserObjectId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectId();
        }
        return this.userobjectid;
    }

    /**
     *  获取属性值[用户对象标识]是否修改
     */
    public boolean isUserObjectIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectIdDirty();
        }
        return this.userobjectidDirtyFlag;
    }

    /**
     *  重置属性值[用户对象标识]
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
     *  设置属性值[用户对象级别]
     *  @param userobjectlevel
     */
    public void setUserObjectLevel(Integer userobjectlevel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserObjectLevel(userobjectlevel);
            return;
        }
        this.userobjectlevel = userobjectlevel;
        this.userobjectlevelDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户对象级别]
     */
    public Integer getUserObjectLevel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectLevel();
        }
        return this.userobjectlevel;
    }

    /**
     *  获取属性值[用户对象级别]是否修改
     */
    public boolean isUserObjectLevelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectLevelDirty();
        }
        return this.userobjectlevelDirtyFlag;
    }

    /**
     *  重置属性值[用户对象级别]
     */
    public void resetUserObjectLevel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserObjectLevel();
            return;
        }

        this.userobjectlevelDirtyFlag = false;
        this.userobjectlevel = null;
    }
    /**
     *  设置属性值[用户对象名称]
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
     *  获取属性值[用户对象名称]
     */
    public String getUserObjectName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectName();
        }
        return this.userobjectname;
    }

    /**
     *  获取属性值[用户对象名称]是否修改
     */
    public boolean isUserObjectNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectNameDirty();
        }
        return this.userobjectnameDirtyFlag;
    }

    /**
     *  重置属性值[用户对象名称]
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
     *  设置属性值[用户对象类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel
     *  @param userobjecttype
     */
    public void setUserObjectType(String userobjecttype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserObjectType(userobjecttype);
            return;
        }
        if(userobjecttype!=null) {
            userobjecttype = StringHelper.trimRight(userobjecttype);
            if(userobjecttype.length()==0) {
                userobjecttype = null;
            }
        }
        this.userobjecttype = userobjecttype;
        this.userobjecttypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户对象类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel
     */
    public String getUserObjectType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObjectType();
        }
        return this.userobjecttype;
    }

    /**
     *  获取属性值[用户对象类型]是否修改
     */
    public boolean isUserObjectTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectTypeDirty();
        }
        return this.userobjecttypeDirtyFlag;
    }

    /**
     *  重置属性值[用户对象类型]
     */
    public void resetUserObjectType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserObjectType();
            return;
        }

        this.userobjecttypeDirtyFlag = false;
        this.userobjecttype = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserObjectBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserObjectBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetMemo();
        et.resetOwnerId();
        et.resetOwnerType();
        et.resetSubType();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserObjectId();
        et.resetUserObjectLevel();
        et.resetUserObjectName();
        et.resetUserObjectType();
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
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOwnerIdDirty()) {
            params.put(FIELD_OWNERID,getOwnerId());
        }
        if(!bDirtyOnly || isOwnerTypeDirty()) {
            params.put(FIELD_OWNERTYPE,getOwnerType());
        }
        if(!bDirtyOnly || isSubTypeDirty()) {
            params.put(FIELD_SUBTYPE,getSubType());
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
        if(!bDirtyOnly || isUserObjectLevelDirty()) {
            params.put(FIELD_USEROBJECTLEVEL,getUserObjectLevel());
        }
        if(!bDirtyOnly || isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME,getUserObjectName());
        }
        if(!bDirtyOnly || isUserObjectTypeDirty()) {
            params.put(FIELD_USEROBJECTTYPE,getUserObjectType());
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

        return  UserObjectBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserObjectBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_OWNERID:
            return et.getOwnerId();
        case INDEX_OWNERTYPE:
            return et.getOwnerType();
        case INDEX_SUBTYPE:
            return et.getSubType();
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
        case INDEX_USEROBJECTLEVEL:
            return et.getUserObjectLevel();
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName();
        case INDEX_USEROBJECTTYPE:
            return et.getUserObjectType();
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

        UserObjectBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserObjectBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_OWNERID:
            et.setOwnerId(DataObject.getStringValue(obj));
            return ;
        case INDEX_OWNERTYPE:
            et.setOwnerType(DataObject.getStringValue(obj));
            return ;
        case INDEX_SUBTYPE:
            et.setSubType(DataObject.getStringValue(obj));
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
        case INDEX_USEROBJECTLEVEL:
            et.setUserObjectLevel(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_USEROBJECTNAME:
            et.setUserObjectName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECTTYPE:
            et.setUserObjectType(DataObject.getStringValue(obj));
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

        return  UserObjectBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserObjectBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_OWNERID:
            return et.getOwnerId()==null;
        case INDEX_OWNERTYPE:
            return et.getOwnerType()==null;
        case INDEX_SUBTYPE:
            return et.getSubType()==null;
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
        case INDEX_USEROBJECTLEVEL:
            return et.getUserObjectLevel()==null;
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName()==null;
        case INDEX_USEROBJECTTYPE:
            return et.getUserObjectType()==null;
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
        return  UserObjectBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserObjectBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_OWNERID:
            return et.isOwnerIdDirty();
        case INDEX_OWNERTYPE:
            return et.isOwnerTypeDirty();
        case INDEX_SUBTYPE:
            return et.isSubTypeDirty();
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
        case INDEX_USEROBJECTLEVEL:
            return et.isUserObjectLevelDirty();
        case INDEX_USEROBJECTNAME:
            return et.isUserObjectNameDirty();
        case INDEX_USEROBJECTTYPE:
            return et.isUserObjectTypeDirty();
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
    private static  void fillJSONObject(UserObjectBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOwnerId()!=null) {
            JSONObjectHelper.put(json,"ownerid",getJSONValue(et.getOwnerId()),false);
        }
        if(bIncEmpty||et.getOwnerType()!=null) {
            JSONObjectHelper.put(json,"ownertype",getJSONValue(et.getOwnerType()),false);
        }
        if(bIncEmpty||et.getSubType()!=null) {
            JSONObjectHelper.put(json,"subtype",getJSONValue(et.getSubType()),false);
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
        if(bIncEmpty||et.getUserObjectLevel()!=null) {
            JSONObjectHelper.put(json,"userobjectlevel",getJSONValue(et.getUserObjectLevel()),false);
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            JSONObjectHelper.put(json,"userobjectname",getJSONValue(et.getUserObjectName()),false);
        }
        if(bIncEmpty||et.getUserObjectType()!=null) {
            JSONObjectHelper.put(json,"userobjecttype",getJSONValue(et.getUserObjectType()),false);
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
    private static void fillXmlNode(UserObjectBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOwnerId()!=null) {
            Object obj = et.getOwnerId();
            node.setAttribute("OWNERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOwnerType()!=null) {
            Object obj = et.getOwnerType();
            node.setAttribute("OWNERTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSubType()!=null) {
            Object obj = et.getSubType();
            node.setAttribute("SUBTYPE",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getUserObjectLevel()!=null) {
            Object obj = et.getUserObjectLevel();
            node.setAttribute("USEROBJECTLEVEL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            Object obj = et.getUserObjectName();
            node.setAttribute("USEROBJECTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObjectType()!=null) {
            Object obj = et.getUserObjectType();
            node.setAttribute("USEROBJECTTYPE",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserObjectBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserObjectBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOwnerIdDirty() && (bIncEmpty||et.getOwnerId()!=null)) {
            dst.set(FIELD_OWNERID,et.getOwnerId());
        }
        if(et.isOwnerTypeDirty() && (bIncEmpty||et.getOwnerType()!=null)) {
            dst.set(FIELD_OWNERTYPE,et.getOwnerType());
        }
        if(et.isSubTypeDirty() && (bIncEmpty||et.getSubType()!=null)) {
            dst.set(FIELD_SUBTYPE,et.getSubType());
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
        if(et.isUserObjectLevelDirty() && (bIncEmpty||et.getUserObjectLevel()!=null)) {
            dst.set(FIELD_USEROBJECTLEVEL,et.getUserObjectLevel());
        }
        if(et.isUserObjectNameDirty() && (bIncEmpty||et.getUserObjectName()!=null)) {
            dst.set(FIELD_USEROBJECTNAME,et.getUserObjectName());
        }
        if(et.isUserObjectTypeDirty() && (bIncEmpty||et.getUserObjectType()!=null)) {
            dst.set(FIELD_USEROBJECTTYPE,et.getUserObjectType());
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
        return  UserObjectBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserObjectBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_OWNERID:
            et.resetOwnerId();
            return true;
        case INDEX_OWNERTYPE:
            et.resetOwnerType();
            return true;
        case INDEX_SUBTYPE:
            et.resetSubType();
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
        case INDEX_USEROBJECTLEVEL:
            et.resetUserObjectLevel();
            return true;
        case INDEX_USEROBJECTNAME:
            et.resetUserObjectName();
            return true;
        case INDEX_USEROBJECTTYPE:
            et.resetUserObjectType();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private UserObjectBase getProxyEntity() {
        return this.proxyUserObjectBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserObjectBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserObjectBase) {
            this.proxyUserObjectBase = (UserObjectBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserObjectService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}