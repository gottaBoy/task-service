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
 * 实体[UserGroupDetail] 数据对象基类
 */
public abstract class UserGroupDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserGroupDetailBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
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
     * 属性[用户组成员标识]
     */
    public final static String FIELD_USERGROUPDETAILID = "USERGROUPDETAILID";
    /**
     * 属性[用户组成员名称]
     */
    public final static String FIELD_USERGROUPDETAILNAME = "USERGROUPDETAILNAME";
    /**
     * 属性[用户组]
     */
    public final static String FIELD_USERGROUPID = "USERGROUPID";
    /**
     * 属性[用户组]
     */
    public final static String FIELD_USERGROUPNAME = "USERGROUPNAME";
    /**
     * 属性[用户对象]
     */
    public final static String FIELD_USEROBJECTID = "USEROBJECTID";
    /**
     * 属性[用户对象]
     */
    public final static String FIELD_USEROBJECTNAME = "USEROBJECTNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_UPDATEDATE = 2;
    private final static int INDEX_UPDATEMAN = 3;
    private final static int INDEX_USERDATA = 4;
    private final static int INDEX_USERDATA2 = 5;
    private final static int INDEX_USERGROUPDETAILID = 6;
    private final static int INDEX_USERGROUPDETAILNAME = 7;
    private final static int INDEX_USERGROUPID = 8;
    private final static int INDEX_USERGROUPNAME = 9;
    private final static int INDEX_USEROBJECTID = 10;
    private final static int INDEX_USEROBJECTNAME = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USERGROUPDETAILID, INDEX_USERGROUPDETAILID);
        fieldIndexMap.put( FIELD_USERGROUPDETAILNAME, INDEX_USERGROUPDETAILNAME);
        fieldIndexMap.put( FIELD_USERGROUPID, INDEX_USERGROUPID);
        fieldIndexMap.put( FIELD_USERGROUPNAME, INDEX_USERGROUPNAME);
        fieldIndexMap.put( FIELD_USEROBJECTID, INDEX_USEROBJECTID);
        fieldIndexMap.put( FIELD_USEROBJECTNAME, INDEX_USEROBJECTNAME);
    }

    private UserGroupDetailBase proxyUserGroupDetailBase = null;
    public UserGroupDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usergroupdetailidDirtyFlag = false;
    private boolean usergroupdetailnameDirtyFlag = false;
    private boolean usergroupidDirtyFlag = false;
    private boolean usergroupnameDirtyFlag = false;
    private boolean userobjectidDirtyFlag = false;
    private boolean userobjectnameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usergroupdetailid")
    private String usergroupdetailid;
    @Column(name="usergroupdetailname")
    private String usergroupdetailname;
    @Column(name="usergroupid")
    private String usergroupid;
    @Column(name="usergroupname")
    private String usergroupname;
    @Column(name="userobjectid")
    private String userobjectid;
    @Column(name="userobjectname")
    private String userobjectname;


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
     *  设置属性值[用户组成员标识]
     *  @param usergroupdetailid
     */
    public void setUserGroupDetailId(String usergroupdetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserGroupDetailId(usergroupdetailid);
            return;
        }
        if(usergroupdetailid!=null) {
            usergroupdetailid = StringHelper.trimRight(usergroupdetailid);
            if(usergroupdetailid.length()==0) {
                usergroupdetailid = null;
            }
        }
        this.usergroupdetailid = usergroupdetailid;
        this.usergroupdetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户组成员标识]
     */
    public String getUserGroupDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserGroupDetailId();
        }
        return this.usergroupdetailid;
    }

    /**
     *  获取属性值[用户组成员标识]是否修改
     */
    public boolean isUserGroupDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserGroupDetailIdDirty();
        }
        return this.usergroupdetailidDirtyFlag;
    }

    /**
     *  重置属性值[用户组成员标识]
     */
    public void resetUserGroupDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserGroupDetailId();
            return;
        }

        this.usergroupdetailidDirtyFlag = false;
        this.usergroupdetailid = null;
    }
    /**
     *  设置属性值[用户组成员名称]
     *  @param usergroupdetailname
     */
    public void setUserGroupDetailName(String usergroupdetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserGroupDetailName(usergroupdetailname);
            return;
        }
        if(usergroupdetailname!=null) {
            usergroupdetailname = StringHelper.trimRight(usergroupdetailname);
            if(usergroupdetailname.length()==0) {
                usergroupdetailname = null;
            }
        }
        this.usergroupdetailname = usergroupdetailname;
        this.usergroupdetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户组成员名称]
     */
    public String getUserGroupDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserGroupDetailName();
        }
        return this.usergroupdetailname;
    }

    /**
     *  获取属性值[用户组成员名称]是否修改
     */
    public boolean isUserGroupDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserGroupDetailNameDirty();
        }
        return this.usergroupdetailnameDirtyFlag;
    }

    /**
     *  重置属性值[用户组成员名称]
     */
    public void resetUserGroupDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserGroupDetailName();
            return;
        }

        this.usergroupdetailnameDirtyFlag = false;
        this.usergroupdetailname = null;
    }
    /**
     *  设置属性值[用户组]
     *  @param usergroupid
     */
    public void setUserGroupId(String usergroupid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserGroupId(usergroupid);
            return;
        }
        if(usergroupid!=null) {
            usergroupid = StringHelper.trimRight(usergroupid);
            if(usergroupid.length()==0) {
                usergroupid = null;
            }
        }
        this.usergroupid = usergroupid;
        this.usergroupidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户组]
     */
    public String getUserGroupId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserGroupId();
        }
        return this.usergroupid;
    }

    /**
     *  获取属性值[用户组]是否修改
     */
    public boolean isUserGroupIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserGroupIdDirty();
        }
        return this.usergroupidDirtyFlag;
    }

    /**
     *  重置属性值[用户组]
     */
    public void resetUserGroupId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserGroupId();
            return;
        }

        this.usergroupidDirtyFlag = false;
        this.usergroupid = null;
    }
    /**
     *  设置属性值[用户组]
     *  @param usergroupname
     */
    public void setUserGroupName(String usergroupname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserGroupName(usergroupname);
            return;
        }
        if(usergroupname!=null) {
            usergroupname = StringHelper.trimRight(usergroupname);
            if(usergroupname.length()==0) {
                usergroupname = null;
            }
        }
        this.usergroupname = usergroupname;
        this.usergroupnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户组]
     */
    public String getUserGroupName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserGroupName();
        }
        return this.usergroupname;
    }

    /**
     *  获取属性值[用户组]是否修改
     */
    public boolean isUserGroupNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserGroupNameDirty();
        }
        return this.usergroupnameDirtyFlag;
    }

    /**
     *  重置属性值[用户组]
     */
    public void resetUserGroupName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserGroupName();
            return;
        }

        this.usergroupnameDirtyFlag = false;
        this.usergroupname = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserGroupDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserGroupDetailId();
        et.resetUserGroupDetailName();
        et.resetUserGroupId();
        et.resetUserGroupName();
        et.resetUserObjectId();
        et.resetUserObjectName();
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
        if(!bDirtyOnly || isUserGroupDetailIdDirty()) {
            params.put(FIELD_USERGROUPDETAILID,getUserGroupDetailId());
        }
        if(!bDirtyOnly || isUserGroupDetailNameDirty()) {
            params.put(FIELD_USERGROUPDETAILNAME,getUserGroupDetailName());
        }
        if(!bDirtyOnly || isUserGroupIdDirty()) {
            params.put(FIELD_USERGROUPID,getUserGroupId());
        }
        if(!bDirtyOnly || isUserGroupNameDirty()) {
            params.put(FIELD_USERGROUPNAME,getUserGroupName());
        }
        if(!bDirtyOnly || isUserObjectIdDirty()) {
            params.put(FIELD_USEROBJECTID,getUserObjectId());
        }
        if(!bDirtyOnly || isUserObjectNameDirty()) {
            params.put(FIELD_USEROBJECTNAME,getUserObjectName());
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

        return  UserGroupDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_USERGROUPDETAILID:
            return et.getUserGroupDetailId();
        case INDEX_USERGROUPDETAILNAME:
            return et.getUserGroupDetailName();
        case INDEX_USERGROUPID:
            return et.getUserGroupId();
        case INDEX_USERGROUPNAME:
            return et.getUserGroupName();
        case INDEX_USEROBJECTID:
            return et.getUserObjectId();
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName();
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

        UserGroupDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserGroupDetailBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
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
        case INDEX_USERGROUPDETAILID:
            et.setUserGroupDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERGROUPDETAILNAME:
            et.setUserGroupDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERGROUPID:
            et.setUserGroupId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERGROUPNAME:
            et.setUserGroupName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECTID:
            et.setUserObjectId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECTNAME:
            et.setUserObjectName(DataObject.getStringValue(obj));
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

        return  UserGroupDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_USERGROUPDETAILID:
            return et.getUserGroupDetailId()==null;
        case INDEX_USERGROUPDETAILNAME:
            return et.getUserGroupDetailName()==null;
        case INDEX_USERGROUPID:
            return et.getUserGroupId()==null;
        case INDEX_USERGROUPNAME:
            return et.getUserGroupName()==null;
        case INDEX_USEROBJECTID:
            return et.getUserObjectId()==null;
        case INDEX_USEROBJECTNAME:
            return et.getUserObjectName()==null;
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
        return  UserGroupDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_USERGROUPDETAILID:
            return et.isUserGroupDetailIdDirty();
        case INDEX_USERGROUPDETAILNAME:
            return et.isUserGroupDetailNameDirty();
        case INDEX_USERGROUPID:
            return et.isUserGroupIdDirty();
        case INDEX_USERGROUPNAME:
            return et.isUserGroupNameDirty();
        case INDEX_USEROBJECTID:
            return et.isUserObjectIdDirty();
        case INDEX_USEROBJECTNAME:
            return et.isUserObjectNameDirty();
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
    private static  void fillJSONObject(UserGroupDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
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
        if(bIncEmpty||et.getUserGroupDetailId()!=null) {
            JSONObjectHelper.put(json,"usergroupdetailid",getJSONValue(et.getUserGroupDetailId()),false);
        }
        if(bIncEmpty||et.getUserGroupDetailName()!=null) {
            JSONObjectHelper.put(json,"usergroupdetailname",getJSONValue(et.getUserGroupDetailName()),false);
        }
        if(bIncEmpty||et.getUserGroupId()!=null) {
            JSONObjectHelper.put(json,"usergroupid",getJSONValue(et.getUserGroupId()),false);
        }
        if(bIncEmpty||et.getUserGroupName()!=null) {
            JSONObjectHelper.put(json,"usergroupname",getJSONValue(et.getUserGroupName()),false);
        }
        if(bIncEmpty||et.getUserObjectId()!=null) {
            JSONObjectHelper.put(json,"userobjectid",getJSONValue(et.getUserObjectId()),false);
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            JSONObjectHelper.put(json,"userobjectname",getJSONValue(et.getUserObjectName()),false);
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
    private static void fillXmlNode(UserGroupDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getUserGroupDetailId()!=null) {
            Object obj = et.getUserGroupDetailId();
            node.setAttribute("USERGROUPDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserGroupDetailName()!=null) {
            Object obj = et.getUserGroupDetailName();
            node.setAttribute("USERGROUPDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserGroupId()!=null) {
            Object obj = et.getUserGroupId();
            node.setAttribute("USERGROUPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserGroupName()!=null) {
            Object obj = et.getUserGroupName();
            node.setAttribute("USERGROUPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObjectId()!=null) {
            Object obj = et.getUserObjectId();
            node.setAttribute("USEROBJECTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObjectName()!=null) {
            Object obj = et.getUserObjectName();
            node.setAttribute("USEROBJECTNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserGroupDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserGroupDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
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
        if(et.isUserGroupDetailIdDirty() && (bIncEmpty||et.getUserGroupDetailId()!=null)) {
            dst.set(FIELD_USERGROUPDETAILID,et.getUserGroupDetailId());
        }
        if(et.isUserGroupDetailNameDirty() && (bIncEmpty||et.getUserGroupDetailName()!=null)) {
            dst.set(FIELD_USERGROUPDETAILNAME,et.getUserGroupDetailName());
        }
        if(et.isUserGroupIdDirty() && (bIncEmpty||et.getUserGroupId()!=null)) {
            dst.set(FIELD_USERGROUPID,et.getUserGroupId());
        }
        if(et.isUserGroupNameDirty() && (bIncEmpty||et.getUserGroupName()!=null)) {
            dst.set(FIELD_USERGROUPNAME,et.getUserGroupName());
        }
        if(et.isUserObjectIdDirty() && (bIncEmpty||et.getUserObjectId()!=null)) {
            dst.set(FIELD_USEROBJECTID,et.getUserObjectId());
        }
        if(et.isUserObjectNameDirty() && (bIncEmpty||et.getUserObjectName()!=null)) {
            dst.set(FIELD_USEROBJECTNAME,et.getUserObjectName());
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
        return  UserGroupDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserGroupDetailBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
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
        case INDEX_USERGROUPDETAILID:
            et.resetUserGroupDetailId();
            return true;
        case INDEX_USERGROUPDETAILNAME:
            et.resetUserGroupDetailName();
            return true;
        case INDEX_USERGROUPID:
            et.resetUserGroupId();
            return true;
        case INDEX_USERGROUPNAME:
            et.resetUserGroupName();
            return true;
        case INDEX_USEROBJECTID:
            et.resetUserObjectId();
            return true;
        case INDEX_USEROBJECTNAME:
            et.resetUserObjectName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objUserGroupLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserGroup usergroup = null;
    /**
    * 获取父数据 用户组
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserGroup getUserGroup() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserGroup();
        }

        if(this.getUserGroupId()==null)
            return null;
        synchronized(this.objUserGroupLock) {
            if(this.usergroup!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserGroupId(),usergroup.getUserGroupId())!=0) {
                    this.usergroup = null;
                }
            }


            if(this.usergroup==null) {
                net.ibizsys.psrt.srv.common.entity.UserGroup usergroup = new net.ibizsys.psrt.srv.common.entity.UserGroup();
                usergroup.setUserGroupId(this.getUserGroupId());
                net.ibizsys.psrt.srv.common.service.UserGroupService service = (net.ibizsys.psrt.srv.common.service.UserGroupService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserGroupService.class,this.getSessionFactory());
                service.autoGet(usergroup);
                this.usergroup = usergroup;
            }
            return this.usergroup;
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



    /**
     *  获取代理的数据对象
     */
    private UserGroupDetailBase getProxyEntity() {
        return this.proxyUserGroupDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserGroupDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserGroupDetailBase) {
            this.proxyUserGroupDetailBase = (UserGroupDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}