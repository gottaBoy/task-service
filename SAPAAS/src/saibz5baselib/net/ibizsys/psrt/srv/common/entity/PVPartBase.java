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
 * 实体[PVPart] 数据对象基类
 */
public abstract class PVPartBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PVPartBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[控件标识]
     */
    public final static String FIELD_CTRLID = "CTRLID";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[门户视图]
     */
    public final static String FIELD_PORTALPAGEID = "PORTALPAGEID";
    /**
     * 属性[门户视图]
     */
    public final static String FIELD_PORTALPAGENAME = "PORTALPAGENAME";
    /**
     * 属性[门户视图部件标识]
     */
    public final static String FIELD_PVPARTID = "PVPARTID";
    /**
     * 属性[门户视图部件名称]
     */
    public final static String FIELD_PVPARTNAME = "PVPARTNAME";
    /**
     * 属性[部件类型]
     */
    public final static String FIELD_PVPARTTYPE = "PVPARTTYPE";
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
    private final static int INDEX_CTRLID = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_PORTALPAGEID = 4;
    private final static int INDEX_PORTALPAGENAME = 5;
    private final static int INDEX_PVPARTID = 6;
    private final static int INDEX_PVPARTNAME = 7;
    private final static int INDEX_PVPARTTYPE = 8;
    private final static int INDEX_UPDATEDATE = 9;
    private final static int INDEX_UPDATEMAN = 10;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_CTRLID, INDEX_CTRLID);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PORTALPAGEID, INDEX_PORTALPAGEID);
        fieldIndexMap.put( FIELD_PORTALPAGENAME, INDEX_PORTALPAGENAME);
        fieldIndexMap.put( FIELD_PVPARTID, INDEX_PVPARTID);
        fieldIndexMap.put( FIELD_PVPARTNAME, INDEX_PVPARTNAME);
        fieldIndexMap.put( FIELD_PVPARTTYPE, INDEX_PVPARTTYPE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private PVPartBase proxyPVPartBase = null;
    public PVPartBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portalpageidDirtyFlag = false;
    private boolean portalpagenameDirtyFlag = false;
    private boolean pvpartidDirtyFlag = false;
    private boolean pvpartnameDirtyFlag = false;
    private boolean pvparttypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlid")
    private String ctrlid;
    @Column(name="memo")
    private String memo;
    @Column(name="portalpageid")
    private String portalpageid;
    @Column(name="portalpagename")
    private String portalpagename;
    @Column(name="pvpartid")
    private String pvpartid;
    @Column(name="pvpartname")
    private String pvpartname;
    @Column(name="pvparttype")
    private String pvparttype;
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
     *  设置属性值[控件标识]
     *  @param ctrlid
     */
    public void setCtrlId(String ctrlid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCtrlId(ctrlid);
            return;
        }
        if(ctrlid!=null) {
            ctrlid = StringHelper.trimRight(ctrlid);
            if(ctrlid.length()==0) {
                ctrlid = null;
            }
        }
        this.ctrlid = ctrlid;
        this.ctrlidDirtyFlag  = true;
    }

    /**
     *  获取属性值[控件标识]
     */
    public String getCtrlId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCtrlId();
        }
        return this.ctrlid;
    }

    /**
     *  获取属性值[控件标识]是否修改
     */
    public boolean isCtrlIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCtrlIdDirty();
        }
        return this.ctrlidDirtyFlag;
    }

    /**
     *  重置属性值[控件标识]
     */
    public void resetCtrlId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCtrlId();
            return;
        }

        this.ctrlidDirtyFlag = false;
        this.ctrlid = null;
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
     *  设置属性值[门户视图]
     *  @param portalpageid
     */
    public void setPortalPageId(String portalpageid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPortalPageId(portalpageid);
            return;
        }
        if(portalpageid!=null) {
            portalpageid = StringHelper.trimRight(portalpageid);
            if(portalpageid.length()==0) {
                portalpageid = null;
            }
        }
        this.portalpageid = portalpageid;
        this.portalpageidDirtyFlag  = true;
    }

    /**
     *  获取属性值[门户视图]
     */
    public String getPortalPageId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPageId();
        }
        return this.portalpageid;
    }

    /**
     *  获取属性值[门户视图]是否修改
     */
    public boolean isPortalPageIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPortalPageIdDirty();
        }
        return this.portalpageidDirtyFlag;
    }

    /**
     *  重置属性值[门户视图]
     */
    public void resetPortalPageId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPortalPageId();
            return;
        }

        this.portalpageidDirtyFlag = false;
        this.portalpageid = null;
    }
    /**
     *  设置属性值[门户视图]
     *  @param portalpagename
     */
    public void setPortalPageName(String portalpagename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPortalPageName(portalpagename);
            return;
        }
        if(portalpagename!=null) {
            portalpagename = StringHelper.trimRight(portalpagename);
            if(portalpagename.length()==0) {
                portalpagename = null;
            }
        }
        this.portalpagename = portalpagename;
        this.portalpagenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[门户视图]
     */
    public String getPortalPageName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPageName();
        }
        return this.portalpagename;
    }

    /**
     *  获取属性值[门户视图]是否修改
     */
    public boolean isPortalPageNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPortalPageNameDirty();
        }
        return this.portalpagenameDirtyFlag;
    }

    /**
     *  重置属性值[门户视图]
     */
    public void resetPortalPageName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPortalPageName();
            return;
        }

        this.portalpagenameDirtyFlag = false;
        this.portalpagename = null;
    }
    /**
     *  设置属性值[门户视图部件标识]
     *  @param pvpartid
     */
    public void setPVPartId(String pvpartid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPVPartId(pvpartid);
            return;
        }
        if(pvpartid!=null) {
            pvpartid = StringHelper.trimRight(pvpartid);
            if(pvpartid.length()==0) {
                pvpartid = null;
            }
        }
        this.pvpartid = pvpartid;
        this.pvpartidDirtyFlag  = true;
    }

    /**
     *  获取属性值[门户视图部件标识]
     */
    public String getPVPartId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPVPartId();
        }
        return this.pvpartid;
    }

    /**
     *  获取属性值[门户视图部件标识]是否修改
     */
    public boolean isPVPartIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPVPartIdDirty();
        }
        return this.pvpartidDirtyFlag;
    }

    /**
     *  重置属性值[门户视图部件标识]
     */
    public void resetPVPartId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPVPartId();
            return;
        }

        this.pvpartidDirtyFlag = false;
        this.pvpartid = null;
    }
    /**
     *  设置属性值[门户视图部件名称]
     *  @param pvpartname
     */
    public void setPVPartName(String pvpartname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPVPartName(pvpartname);
            return;
        }
        if(pvpartname!=null) {
            pvpartname = StringHelper.trimRight(pvpartname);
            if(pvpartname.length()==0) {
                pvpartname = null;
            }
        }
        this.pvpartname = pvpartname;
        this.pvpartnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[门户视图部件名称]
     */
    public String getPVPartName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPVPartName();
        }
        return this.pvpartname;
    }

    /**
     *  获取属性值[门户视图部件名称]是否修改
     */
    public boolean isPVPartNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPVPartNameDirty();
        }
        return this.pvpartnameDirtyFlag;
    }

    /**
     *  重置属性值[门户视图部件名称]
     */
    public void resetPVPartName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPVPartName();
            return;
        }

        this.pvpartnameDirtyFlag = false;
        this.pvpartname = null;
    }
    /**
     *  设置属性值[部件类型]代码表：net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel
     *  @param pvparttype
     */
    public void setPVPartType(String pvparttype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPVPartType(pvparttype);
            return;
        }
        if(pvparttype!=null) {
            pvparttype = StringHelper.trimRight(pvparttype);
            if(pvparttype.length()==0) {
                pvparttype = null;
            }
        }
        this.pvparttype = pvparttype;
        this.pvparttypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[部件类型]代码表：net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel
     */
    public String getPVPartType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPVPartType();
        }
        return this.pvparttype;
    }

    /**
     *  获取属性值[部件类型]是否修改
     */
    public boolean isPVPartTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPVPartTypeDirty();
        }
        return this.pvparttypeDirtyFlag;
    }

    /**
     *  重置属性值[部件类型]
     */
    public void resetPVPartType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPVPartType();
            return;
        }

        this.pvparttypeDirtyFlag = false;
        this.pvparttype = null;
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
        PVPartBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PVPartBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetCtrlId();
        et.resetMemo();
        et.resetPortalPageId();
        et.resetPortalPageName();
        et.resetPVPartId();
        et.resetPVPartName();
        et.resetPVPartType();
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
        if(!bDirtyOnly || isCtrlIdDirty()) {
            params.put(FIELD_CTRLID,getCtrlId());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isPortalPageIdDirty()) {
            params.put(FIELD_PORTALPAGEID,getPortalPageId());
        }
        if(!bDirtyOnly || isPortalPageNameDirty()) {
            params.put(FIELD_PORTALPAGENAME,getPortalPageName());
        }
        if(!bDirtyOnly || isPVPartIdDirty()) {
            params.put(FIELD_PVPARTID,getPVPartId());
        }
        if(!bDirtyOnly || isPVPartNameDirty()) {
            params.put(FIELD_PVPARTNAME,getPVPartName());
        }
        if(!bDirtyOnly || isPVPartTypeDirty()) {
            params.put(FIELD_PVPARTTYPE,getPVPartType());
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

        return  PVPartBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PVPartBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_CTRLID:
            return et.getCtrlId();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PORTALPAGEID:
            return et.getPortalPageId();
        case INDEX_PORTALPAGENAME:
            return et.getPortalPageName();
        case INDEX_PVPARTID:
            return et.getPVPartId();
        case INDEX_PVPARTNAME:
            return et.getPVPartName();
        case INDEX_PVPARTTYPE:
            return et.getPVPartType();
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

        PVPartBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(PVPartBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_CTRLID:
            et.setCtrlId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_PORTALPAGEID:
            et.setPortalPageId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PORTALPAGENAME:
            et.setPortalPageName(DataObject.getStringValue(obj));
            return ;
        case INDEX_PVPARTID:
            et.setPVPartId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PVPARTNAME:
            et.setPVPartName(DataObject.getStringValue(obj));
            return ;
        case INDEX_PVPARTTYPE:
            et.setPVPartType(DataObject.getStringValue(obj));
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

        return  PVPartBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(PVPartBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_CTRLID:
            return et.getCtrlId()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PORTALPAGEID:
            return et.getPortalPageId()==null;
        case INDEX_PORTALPAGENAME:
            return et.getPortalPageName()==null;
        case INDEX_PVPARTID:
            return et.getPVPartId()==null;
        case INDEX_PVPARTNAME:
            return et.getPVPartName()==null;
        case INDEX_PVPARTTYPE:
            return et.getPVPartType()==null;
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
        return  PVPartBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(PVPartBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_CTRLID:
            return et.isCtrlIdDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PORTALPAGEID:
            return et.isPortalPageIdDirty();
        case INDEX_PORTALPAGENAME:
            return et.isPortalPageNameDirty();
        case INDEX_PVPARTID:
            return et.isPVPartIdDirty();
        case INDEX_PVPARTNAME:
            return et.isPVPartNameDirty();
        case INDEX_PVPARTTYPE:
            return et.isPVPartTypeDirty();
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
    private static  void fillJSONObject(PVPartBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getCtrlId()!=null) {
            JSONObjectHelper.put(json,"ctrlid",getJSONValue(et.getCtrlId()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getPortalPageId()!=null) {
            JSONObjectHelper.put(json,"portalpageid",getJSONValue(et.getPortalPageId()),false);
        }
        if(bIncEmpty||et.getPortalPageName()!=null) {
            JSONObjectHelper.put(json,"portalpagename",getJSONValue(et.getPortalPageName()),false);
        }
        if(bIncEmpty||et.getPVPartId()!=null) {
            JSONObjectHelper.put(json,"pvpartid",getJSONValue(et.getPVPartId()),false);
        }
        if(bIncEmpty||et.getPVPartName()!=null) {
            JSONObjectHelper.put(json,"pvpartname",getJSONValue(et.getPVPartName()),false);
        }
        if(bIncEmpty||et.getPVPartType()!=null) {
            JSONObjectHelper.put(json,"pvparttype",getJSONValue(et.getPVPartType()),false);
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
    private static void fillXmlNode(PVPartBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCtrlId()!=null) {
            Object obj = et.getCtrlId();
            node.setAttribute("CTRLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPortalPageId()!=null) {
            Object obj = et.getPortalPageId();
            node.setAttribute("PORTALPAGEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPortalPageName()!=null) {
            Object obj = et.getPortalPageName();
            node.setAttribute("PORTALPAGENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPVPartId()!=null) {
            Object obj = et.getPVPartId();
            node.setAttribute("PVPARTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPVPartName()!=null) {
            Object obj = et.getPVPartName();
            node.setAttribute("PVPARTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPVPartType()!=null) {
            Object obj = et.getPVPartType();
            node.setAttribute("PVPARTTYPE",(obj==null)?"":(String)obj);
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
        PVPartBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(PVPartBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isCtrlIdDirty() && (bIncEmpty||et.getCtrlId()!=null)) {
            dst.set(FIELD_CTRLID,et.getCtrlId());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isPortalPageIdDirty() && (bIncEmpty||et.getPortalPageId()!=null)) {
            dst.set(FIELD_PORTALPAGEID,et.getPortalPageId());
        }
        if(et.isPortalPageNameDirty() && (bIncEmpty||et.getPortalPageName()!=null)) {
            dst.set(FIELD_PORTALPAGENAME,et.getPortalPageName());
        }
        if(et.isPVPartIdDirty() && (bIncEmpty||et.getPVPartId()!=null)) {
            dst.set(FIELD_PVPARTID,et.getPVPartId());
        }
        if(et.isPVPartNameDirty() && (bIncEmpty||et.getPVPartName()!=null)) {
            dst.set(FIELD_PVPARTNAME,et.getPVPartName());
        }
        if(et.isPVPartTypeDirty() && (bIncEmpty||et.getPVPartType()!=null)) {
            dst.set(FIELD_PVPARTTYPE,et.getPVPartType());
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
        return  PVPartBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(PVPartBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_CTRLID:
            et.resetCtrlId();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_PORTALPAGEID:
            et.resetPortalPageId();
            return true;
        case INDEX_PORTALPAGENAME:
            et.resetPortalPageName();
            return true;
        case INDEX_PVPARTID:
            et.resetPVPartId();
            return true;
        case INDEX_PVPARTNAME:
            et.resetPVPartName();
            return true;
        case INDEX_PVPARTTYPE:
            et.resetPVPartType();
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


    private Integer objPortalPageLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.PortalPage portalpage = null;
    /**
    * 获取父数据 门户页面
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.PortalPage getPortalPage() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPortalPage();
        }

        if(this.getPortalPageId()==null)
            return null;
        synchronized(this.objPortalPageLock) {
            if(this.portalpage!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getPortalPageId(),portalpage.getPortalPageId())!=0) {
                    this.portalpage = null;
                }
            }


            if(this.portalpage==null) {
                net.ibizsys.psrt.srv.common.entity.PortalPage portalpage = new net.ibizsys.psrt.srv.common.entity.PortalPage();
                portalpage.setPortalPageId(this.getPortalPageId());
                net.ibizsys.psrt.srv.common.service.PortalPageService service = (net.ibizsys.psrt.srv.common.service.PortalPageService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.PortalPageService.class,this.getSessionFactory());
                service.autoGet(portalpage);
                this.portalpage = portalpage;
            }
            return this.portalpage;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private PVPartBase getProxyEntity() {
        return this.proxyPVPartBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPVPartBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof PVPartBase) {
            this.proxyPVPartBase = (PVPartBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}