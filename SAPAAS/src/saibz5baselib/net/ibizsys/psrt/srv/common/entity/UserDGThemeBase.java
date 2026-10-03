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
 * 实体[UserDGTheme] 数据对象基类
 */
public abstract class UserDGThemeBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserDGThemeBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[表格编号]
     */
    public final static String FIELD_DATAGRIDID = "DATAGRIDID";
    /**
     * 属性[表格主题模型]
     */
    public final static String FIELD_DGTHEMEMODEL = "DGTHEMEMODEL";
    /**
     * 属性[人员编号]
     */
    public final static String FIELD_PERSONID = "PERSONID";
    /**
     * 属性[项目编号]
     */
    public final static String FIELD_PROJECTID = "PROJECTID";
    /**
     * 属性[RESERVER]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[RESERVER2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[RESERVER3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[表格列定义标识]
     */
    public final static String FIELD_USERDGTHEMEID = "USERDGTHEMEID";
    /**
     * 属性[表格列定义名称]
     */
    public final static String FIELD_USERDGTHEMENAME = "USERDGTHEMENAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DATAGRIDID = 2;
    private final static int INDEX_DGTHEMEMODEL = 3;
    private final static int INDEX_PERSONID = 4;
    private final static int INDEX_PROJECTID = 5;
    private final static int INDEX_RESERVER = 6;
    private final static int INDEX_RESERVER2 = 7;
    private final static int INDEX_RESERVER3 = 8;
    private final static int INDEX_UPDATEDATE = 9;
    private final static int INDEX_UPDATEMAN = 10;
    private final static int INDEX_USERDGTHEMEID = 11;
    private final static int INDEX_USERDGTHEMENAME = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATAGRIDID, INDEX_DATAGRIDID);
        fieldIndexMap.put( FIELD_DGTHEMEMODEL, INDEX_DGTHEMEMODEL);
        fieldIndexMap.put( FIELD_PERSONID, INDEX_PERSONID);
        fieldIndexMap.put( FIELD_PROJECTID, INDEX_PROJECTID);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDGTHEMEID, INDEX_USERDGTHEMEID);
        fieldIndexMap.put( FIELD_USERDGTHEMENAME, INDEX_USERDGTHEMENAME);
    }

    private UserDGThemeBase proxyUserDGThemeBase = null;
    public UserDGThemeBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datagrididDirtyFlag = false;
    private boolean dgthememodelDirtyFlag = false;
    private boolean personidDirtyFlag = false;
    private boolean projectidDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdgthemeidDirtyFlag = false;
    private boolean userdgthemenameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datagridid")
    private String datagridid;
    @Column(name="dgthememodel")
    private String dgthememodel;
    @Column(name="personid")
    private String personid;
    @Column(name="projectid")
    private String projectid;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdgthemeid")
    private String userdgthemeid;
    @Column(name="userdgthemename")
    private String userdgthemename;


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
     *  设置属性值[表格编号]
     *  @param datagridid
     */
    public void setDataGridId(String datagridid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataGridId(datagridid);
            return;
        }
        if(datagridid!=null) {
            datagridid = StringHelper.trimRight(datagridid);
            if(datagridid.length()==0) {
                datagridid = null;
            }
        }
        this.datagridid = datagridid;
        this.datagrididDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格编号]
     */
    public String getDataGridId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataGridId();
        }
        return this.datagridid;
    }

    /**
     *  获取属性值[表格编号]是否修改
     */
    public boolean isDataGridIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataGridIdDirty();
        }
        return this.datagrididDirtyFlag;
    }

    /**
     *  重置属性值[表格编号]
     */
    public void resetDataGridId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataGridId();
            return;
        }

        this.datagrididDirtyFlag = false;
        this.datagridid = null;
    }
    /**
     *  设置属性值[表格主题模型]
     *  @param dgthememodel
     */
    public void setDGThemeModel(String dgthememodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDGThemeModel(dgthememodel);
            return;
        }
        if(dgthememodel!=null) {
            dgthememodel = StringHelper.trimRight(dgthememodel);
            if(dgthememodel.length()==0) {
                dgthememodel = null;
            }
        }
        this.dgthememodel = dgthememodel;
        this.dgthememodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格主题模型]
     */
    public String getDGThemeModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDGThemeModel();
        }
        return this.dgthememodel;
    }

    /**
     *  获取属性值[表格主题模型]是否修改
     */
    public boolean isDGThemeModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDGThemeModelDirty();
        }
        return this.dgthememodelDirtyFlag;
    }

    /**
     *  重置属性值[表格主题模型]
     */
    public void resetDGThemeModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDGThemeModel();
            return;
        }

        this.dgthememodelDirtyFlag = false;
        this.dgthememodel = null;
    }
    /**
     *  设置属性值[人员编号]
     *  @param personid
     */
    public void setPersonId(String personid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPersonId(personid);
            return;
        }
        if(personid!=null) {
            personid = StringHelper.trimRight(personid);
            if(personid.length()==0) {
                personid = null;
            }
        }
        this.personid = personid;
        this.personidDirtyFlag  = true;
    }

    /**
     *  获取属性值[人员编号]
     */
    public String getPersonId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPersonId();
        }
        return this.personid;
    }

    /**
     *  获取属性值[人员编号]是否修改
     */
    public boolean isPersonIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPersonIdDirty();
        }
        return this.personidDirtyFlag;
    }

    /**
     *  重置属性值[人员编号]
     */
    public void resetPersonId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPersonId();
            return;
        }

        this.personidDirtyFlag = false;
        this.personid = null;
    }
    /**
     *  设置属性值[项目编号]
     *  @param projectid
     */
    public void setProjectId(String projectid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setProjectId(projectid);
            return;
        }
        if(projectid!=null) {
            projectid = StringHelper.trimRight(projectid);
            if(projectid.length()==0) {
                projectid = null;
            }
        }
        this.projectid = projectid;
        this.projectidDirtyFlag  = true;
    }

    /**
     *  获取属性值[项目编号]
     */
    public String getProjectId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getProjectId();
        }
        return this.projectid;
    }

    /**
     *  获取属性值[项目编号]是否修改
     */
    public boolean isProjectIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isProjectIdDirty();
        }
        return this.projectidDirtyFlag;
    }

    /**
     *  重置属性值[项目编号]
     */
    public void resetProjectId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetProjectId();
            return;
        }

        this.projectidDirtyFlag = false;
        this.projectid = null;
    }
    /**
     *  设置属性值[RESERVER]
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
     *  获取属性值[RESERVER]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[RESERVER]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[RESERVER]
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
     *  设置属性值[RESERVER2]
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
     *  获取属性值[RESERVER2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[RESERVER2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[RESERVER2]
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
     *  设置属性值[RESERVER3]
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
     *  获取属性值[RESERVER3]
     */
    public String getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[RESERVER3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[RESERVER3]
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
     *  设置属性值[表格列定义标识]
     *  @param userdgthemeid
     */
    public void setUserDGThemeId(String userdgthemeid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDGThemeId(userdgthemeid);
            return;
        }
        if(userdgthemeid!=null) {
            userdgthemeid = StringHelper.trimRight(userdgthemeid);
            if(userdgthemeid.length()==0) {
                userdgthemeid = null;
            }
        }
        this.userdgthemeid = userdgthemeid;
        this.userdgthemeidDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格列定义标识]
     */
    public String getUserDGThemeId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDGThemeId();
        }
        return this.userdgthemeid;
    }

    /**
     *  获取属性值[表格列定义标识]是否修改
     */
    public boolean isUserDGThemeIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDGThemeIdDirty();
        }
        return this.userdgthemeidDirtyFlag;
    }

    /**
     *  重置属性值[表格列定义标识]
     */
    public void resetUserDGThemeId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDGThemeId();
            return;
        }

        this.userdgthemeidDirtyFlag = false;
        this.userdgthemeid = null;
    }
    /**
     *  设置属性值[表格列定义名称]
     *  @param userdgthemename
     */
    public void setUserDGThemeName(String userdgthemename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDGThemeName(userdgthemename);
            return;
        }
        if(userdgthemename!=null) {
            userdgthemename = StringHelper.trimRight(userdgthemename);
            if(userdgthemename.length()==0) {
                userdgthemename = null;
            }
        }
        this.userdgthemename = userdgthemename;
        this.userdgthemenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[表格列定义名称]
     */
    public String getUserDGThemeName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDGThemeName();
        }
        return this.userdgthemename;
    }

    /**
     *  获取属性值[表格列定义名称]是否修改
     */
    public boolean isUserDGThemeNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDGThemeNameDirty();
        }
        return this.userdgthemenameDirtyFlag;
    }

    /**
     *  重置属性值[表格列定义名称]
     */
    public void resetUserDGThemeName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDGThemeName();
            return;
        }

        this.userdgthemenameDirtyFlag = false;
        this.userdgthemename = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserDGThemeBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserDGThemeBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataGridId();
        et.resetDGThemeModel();
        et.resetPersonId();
        et.resetProjectId();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDGThemeId();
        et.resetUserDGThemeName();
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
        if(!bDirtyOnly || isDataGridIdDirty()) {
            params.put(FIELD_DATAGRIDID,getDataGridId());
        }
        if(!bDirtyOnly || isDGThemeModelDirty()) {
            params.put(FIELD_DGTHEMEMODEL,getDGThemeModel());
        }
        if(!bDirtyOnly || isPersonIdDirty()) {
            params.put(FIELD_PERSONID,getPersonId());
        }
        if(!bDirtyOnly || isProjectIdDirty()) {
            params.put(FIELD_PROJECTID,getProjectId());
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
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDGThemeIdDirty()) {
            params.put(FIELD_USERDGTHEMEID,getUserDGThemeId());
        }
        if(!bDirtyOnly || isUserDGThemeNameDirty()) {
            params.put(FIELD_USERDGTHEMENAME,getUserDGThemeName());
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

        return  UserDGThemeBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserDGThemeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATAGRIDID:
            return et.getDataGridId();
        case INDEX_DGTHEMEMODEL:
            return et.getDGThemeModel();
        case INDEX_PERSONID:
            return et.getPersonId();
        case INDEX_PROJECTID:
            return et.getProjectId();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDGTHEMEID:
            return et.getUserDGThemeId();
        case INDEX_USERDGTHEMENAME:
            return et.getUserDGThemeName();
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

        UserDGThemeBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserDGThemeBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAGRIDID:
            et.setDataGridId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DGTHEMEMODEL:
            et.setDGThemeModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_PERSONID:
            et.setPersonId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PROJECTID:
            et.setProjectId(DataObject.getStringValue(obj));
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
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDGTHEMEID:
            et.setUserDGThemeId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDGTHEMENAME:
            et.setUserDGThemeName(DataObject.getStringValue(obj));
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

        return  UserDGThemeBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserDGThemeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATAGRIDID:
            return et.getDataGridId()==null;
        case INDEX_DGTHEMEMODEL:
            return et.getDGThemeModel()==null;
        case INDEX_PERSONID:
            return et.getPersonId()==null;
        case INDEX_PROJECTID:
            return et.getProjectId()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDGTHEMEID:
            return et.getUserDGThemeId()==null;
        case INDEX_USERDGTHEMENAME:
            return et.getUserDGThemeName()==null;
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
        return  UserDGThemeBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserDGThemeBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATAGRIDID:
            return et.isDataGridIdDirty();
        case INDEX_DGTHEMEMODEL:
            return et.isDGThemeModelDirty();
        case INDEX_PERSONID:
            return et.isPersonIdDirty();
        case INDEX_PROJECTID:
            return et.isProjectIdDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDGTHEMEID:
            return et.isUserDGThemeIdDirty();
        case INDEX_USERDGTHEMENAME:
            return et.isUserDGThemeNameDirty();
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
    private static  void fillJSONObject(UserDGThemeBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataGridId()!=null) {
            JSONObjectHelper.put(json,"datagridid",getJSONValue(et.getDataGridId()),false);
        }
        if(bIncEmpty||et.getDGThemeModel()!=null) {
            JSONObjectHelper.put(json,"dgthememodel",getJSONValue(et.getDGThemeModel()),false);
        }
        if(bIncEmpty||et.getPersonId()!=null) {
            JSONObjectHelper.put(json,"personid",getJSONValue(et.getPersonId()),false);
        }
        if(bIncEmpty||et.getProjectId()!=null) {
            JSONObjectHelper.put(json,"projectid",getJSONValue(et.getProjectId()),false);
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserDGThemeId()!=null) {
            JSONObjectHelper.put(json,"userdgthemeid",getJSONValue(et.getUserDGThemeId()),false);
        }
        if(bIncEmpty||et.getUserDGThemeName()!=null) {
            JSONObjectHelper.put(json,"userdgthemename",getJSONValue(et.getUserDGThemeName()),false);
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
    private static void fillXmlNode(UserDGThemeBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataGridId()!=null) {
            Object obj = et.getDataGridId();
            node.setAttribute("DATAGRIDID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDGThemeModel()!=null) {
            Object obj = et.getDGThemeModel();
            node.setAttribute("DGTHEMEMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPersonId()!=null) {
            Object obj = et.getPersonId();
            node.setAttribute("PERSONID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getProjectId()!=null) {
            Object obj = et.getProjectId();
            node.setAttribute("PROJECTID",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDGThemeId()!=null) {
            Object obj = et.getUserDGThemeId();
            node.setAttribute("USERDGTHEMEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDGThemeName()!=null) {
            Object obj = et.getUserDGThemeName();
            node.setAttribute("USERDGTHEMENAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserDGThemeBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserDGThemeBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataGridIdDirty() && (bIncEmpty||et.getDataGridId()!=null)) {
            dst.set(FIELD_DATAGRIDID,et.getDataGridId());
        }
        if(et.isDGThemeModelDirty() && (bIncEmpty||et.getDGThemeModel()!=null)) {
            dst.set(FIELD_DGTHEMEMODEL,et.getDGThemeModel());
        }
        if(et.isPersonIdDirty() && (bIncEmpty||et.getPersonId()!=null)) {
            dst.set(FIELD_PERSONID,et.getPersonId());
        }
        if(et.isProjectIdDirty() && (bIncEmpty||et.getProjectId()!=null)) {
            dst.set(FIELD_PROJECTID,et.getProjectId());
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
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDGThemeIdDirty() && (bIncEmpty||et.getUserDGThemeId()!=null)) {
            dst.set(FIELD_USERDGTHEMEID,et.getUserDGThemeId());
        }
        if(et.isUserDGThemeNameDirty() && (bIncEmpty||et.getUserDGThemeName()!=null)) {
            dst.set(FIELD_USERDGTHEMENAME,et.getUserDGThemeName());
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
        return  UserDGThemeBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserDGThemeBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATAGRIDID:
            et.resetDataGridId();
            return true;
        case INDEX_DGTHEMEMODEL:
            et.resetDGThemeModel();
            return true;
        case INDEX_PERSONID:
            et.resetPersonId();
            return true;
        case INDEX_PROJECTID:
            et.resetProjectId();
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
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDGTHEMEID:
            et.resetUserDGThemeId();
            return true;
        case INDEX_USERDGTHEMENAME:
            et.resetUserDGThemeName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private UserDGThemeBase getProxyEntity() {
        return this.proxyUserDGThemeBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserDGThemeBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserDGThemeBase) {
            this.proxyUserDGThemeBase = (UserDGThemeBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDGThemeService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}