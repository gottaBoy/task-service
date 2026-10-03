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
 * 实体[DSDynaView] 数据对象基类
 */
public abstract class DSDynaViewBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaViewBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[实体标识]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[实体工作流标识]
     */
    public final static String FIELD_DEWFID = "DEWFID";
    /**
     * 属性[动态视图标识]
     */
    public final static String FIELD_DSDYNAVIEWID = "DSDYNAVIEWID";
    /**
     * 属性[动态视图名称]
     */
    public final static String FIELD_DSDYNAVIEWNAME = "DSDYNAVIEWNAME";
    /**
     * 属性[预置视图类型参数]
     */
    public final static String FIELD_PDVTPARAM = "PDVTPARAM";
    /**
     * 属性[预置视图类型]
     */
    public final static String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[视图说明]
     */
    public final static String FIELD_VIEWDESC = "VIEWDESC";
    /**
     * 属性[视图实例对象]
     */
    public final static String FIELD_VIEWINSTOBJ = "VIEWINSTOBJ";
    /**
     * 属性[视图类型]
     */
    public final static String FIELD_VIEWTYPE = "VIEWTYPE";
    /**
     * 属性[视图版本]
     */
    public final static String FIELD_VIEWVER = "VIEWVER";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DEID = 2;
    private final static int INDEX_DEWFID = 3;
    private final static int INDEX_DSDYNAVIEWID = 4;
    private final static int INDEX_DSDYNAVIEWNAME = 5;
    private final static int INDEX_PDVTPARAM = 6;
    private final static int INDEX_PREDEFINEDVIEWTYPE = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;
    private final static int INDEX_VIEWDESC = 10;
    private final static int INDEX_VIEWINSTOBJ = 11;
    private final static int INDEX_VIEWTYPE = 12;
    private final static int INDEX_VIEWVER = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DEWFID, INDEX_DEWFID);
        fieldIndexMap.put( FIELD_DSDYNAVIEWID, INDEX_DSDYNAVIEWID);
        fieldIndexMap.put( FIELD_DSDYNAVIEWNAME, INDEX_DSDYNAVIEWNAME);
        fieldIndexMap.put( FIELD_PDVTPARAM, INDEX_PDVTPARAM);
        fieldIndexMap.put( FIELD_PREDEFINEDVIEWTYPE, INDEX_PREDEFINEDVIEWTYPE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VIEWDESC, INDEX_VIEWDESC);
        fieldIndexMap.put( FIELD_VIEWINSTOBJ, INDEX_VIEWINSTOBJ);
        fieldIndexMap.put( FIELD_VIEWTYPE, INDEX_VIEWTYPE);
        fieldIndexMap.put( FIELD_VIEWVER, INDEX_VIEWVER);
    }

    private DSDynaViewBase proxyDSDynaViewBase = null;
    public DSDynaViewBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean dewfidDirtyFlag = false;
    private boolean dsdynaviewidDirtyFlag = false;
    private boolean dsdynaviewnameDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewdescDirtyFlag = false;
    private boolean viewinstobjDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    private boolean viewverDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dewfid")
    private String dewfid;
    @Column(name="dsdynaviewid")
    private String dsdynaviewid;
    @Column(name="dsdynaviewname")
    private String dsdynaviewname;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewdesc")
    private String viewdesc;
    @Column(name="viewinstobj")
    private String viewinstobj;
    @Column(name="viewtype")
    private String viewtype;
    @Column(name="viewver")
    private Integer viewver;


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
     *  设置属性值[实体标识]
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
     *  获取属性值[实体标识]
     */
    public String getDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    /**
     *  获取属性值[实体标识]是否修改
     */
    public boolean isDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    /**
     *  重置属性值[实体标识]
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
     *  设置属性值[实体工作流标识]
     *  @param dewfid
     */
    public void setDEWFId(String dewfid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEWFId(dewfid);
            return;
        }
        if(dewfid!=null) {
            dewfid = StringHelper.trimRight(dewfid);
            if(dewfid.length()==0) {
                dewfid = null;
            }
        }
        this.dewfid = dewfid;
        this.dewfidDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体工作流标识]
     */
    public String getDEWFId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEWFId();
        }
        return this.dewfid;
    }

    /**
     *  获取属性值[实体工作流标识]是否修改
     */
    public boolean isDEWFIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEWFIdDirty();
        }
        return this.dewfidDirtyFlag;
    }

    /**
     *  重置属性值[实体工作流标识]
     */
    public void resetDEWFId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEWFId();
            return;
        }

        this.dewfidDirtyFlag = false;
        this.dewfid = null;
    }
    /**
     *  设置属性值[动态视图标识]
     *  @param dsdynaviewid
     */
    public void setDSDynaViewId(String dsdynaviewid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaViewId(dsdynaviewid);
            return;
        }
        if(dsdynaviewid!=null) {
            dsdynaviewid = StringHelper.trimRight(dsdynaviewid);
            if(dsdynaviewid.length()==0) {
                dsdynaviewid = null;
            }
        }
        this.dsdynaviewid = dsdynaviewid;
        this.dsdynaviewidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态视图标识]
     */
    public String getDSDynaViewId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaViewId();
        }
        return this.dsdynaviewid;
    }

    /**
     *  获取属性值[动态视图标识]是否修改
     */
    public boolean isDSDynaViewIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaViewIdDirty();
        }
        return this.dsdynaviewidDirtyFlag;
    }

    /**
     *  重置属性值[动态视图标识]
     */
    public void resetDSDynaViewId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaViewId();
            return;
        }

        this.dsdynaviewidDirtyFlag = false;
        this.dsdynaviewid = null;
    }
    /**
     *  设置属性值[动态视图名称]
     *  @param dsdynaviewname
     */
    public void setDSDynaViewName(String dsdynaviewname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDSDynaViewName(dsdynaviewname);
            return;
        }
        if(dsdynaviewname!=null) {
            dsdynaviewname = StringHelper.trimRight(dsdynaviewname);
            if(dsdynaviewname.length()==0) {
                dsdynaviewname = null;
            }
        }
        this.dsdynaviewname = dsdynaviewname;
        this.dsdynaviewnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态视图名称]
     */
    public String getDSDynaViewName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaViewName();
        }
        return this.dsdynaviewname;
    }

    /**
     *  获取属性值[动态视图名称]是否修改
     */
    public boolean isDSDynaViewNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDSDynaViewNameDirty();
        }
        return this.dsdynaviewnameDirtyFlag;
    }

    /**
     *  重置属性值[动态视图名称]
     */
    public void resetDSDynaViewName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDSDynaViewName();
            return;
        }

        this.dsdynaviewnameDirtyFlag = false;
        this.dsdynaviewname = null;
    }
    /**
     *  设置属性值[预置视图类型参数]
     *  @param pdvtparam
     */
    public void setPDVTParam(String pdvtparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPDVTParam(pdvtparam);
            return;
        }
        if(pdvtparam!=null) {
            pdvtparam = StringHelper.trimRight(pdvtparam);
            if(pdvtparam.length()==0) {
                pdvtparam = null;
            }
        }
        this.pdvtparam = pdvtparam;
        this.pdvtparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[预置视图类型参数]
     */
    public String getPDVTParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    /**
     *  获取属性值[预置视图类型参数]是否修改
     */
    public boolean isPDVTParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    /**
     *  重置属性值[预置视图类型参数]
     */
    public void resetPDVTParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }

        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }
    /**
     *  设置属性值[预置视图类型]
     *  @param predefinedviewtype
     */
    public void setPredefinedViewType(String predefinedviewtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPredefinedViewType(predefinedviewtype);
            return;
        }
        if(predefinedviewtype!=null) {
            predefinedviewtype = StringHelper.trimRight(predefinedviewtype);
            if(predefinedviewtype.length()==0) {
                predefinedviewtype = null;
            }
        }
        this.predefinedviewtype = predefinedviewtype;
        this.predefinedviewtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[预置视图类型]
     */
    public String getPredefinedViewType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    /**
     *  获取属性值[预置视图类型]是否修改
     */
    public boolean isPredefinedViewTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    /**
     *  重置属性值[预置视图类型]
     */
    public void resetPredefinedViewType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }

        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
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
     *  设置属性值[视图说明]
     *  @param viewdesc
     */
    public void setViewDesc(String viewdesc) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setViewDesc(viewdesc);
            return;
        }
        if(viewdesc!=null) {
            viewdesc = StringHelper.trimRight(viewdesc);
            if(viewdesc.length()==0) {
                viewdesc = null;
            }
        }
        this.viewdesc = viewdesc;
        this.viewdescDirtyFlag  = true;
    }

    /**
     *  获取属性值[视图说明]
     */
    public String getViewDesc() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewDesc();
        }
        return this.viewdesc;
    }

    /**
     *  获取属性值[视图说明]是否修改
     */
    public boolean isViewDescDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewDescDirty();
        }
        return this.viewdescDirtyFlag;
    }

    /**
     *  重置属性值[视图说明]
     */
    public void resetViewDesc() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetViewDesc();
            return;
        }

        this.viewdescDirtyFlag = false;
        this.viewdesc = null;
    }
    /**
     *  设置属性值[视图实例对象]
     *  @param viewinstobj
     */
    public void setViewInstObj(String viewinstobj) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setViewInstObj(viewinstobj);
            return;
        }
        if(viewinstobj!=null) {
            viewinstobj = StringHelper.trimRight(viewinstobj);
            if(viewinstobj.length()==0) {
                viewinstobj = null;
            }
        }
        this.viewinstobj = viewinstobj;
        this.viewinstobjDirtyFlag  = true;
    }

    /**
     *  获取属性值[视图实例对象]
     */
    public String getViewInstObj() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewInstObj();
        }
        return this.viewinstobj;
    }

    /**
     *  获取属性值[视图实例对象]是否修改
     */
    public boolean isViewInstObjDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewInstObjDirty();
        }
        return this.viewinstobjDirtyFlag;
    }

    /**
     *  重置属性值[视图实例对象]
     */
    public void resetViewInstObj() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetViewInstObj();
            return;
        }

        this.viewinstobjDirtyFlag = false;
        this.viewinstobj = null;
    }
    /**
     *  设置属性值[视图类型]代码表：net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel
     *  @param viewtype
     */
    public void setViewType(String viewtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setViewType(viewtype);
            return;
        }
        if(viewtype!=null) {
            viewtype = StringHelper.trimRight(viewtype);
            if(viewtype.length()==0) {
                viewtype = null;
            }
        }
        this.viewtype = viewtype;
        this.viewtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[视图类型]代码表：net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel
     */
    public String getViewType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    /**
     *  获取属性值[视图类型]是否修改
     */
    public boolean isViewTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    /**
     *  重置属性值[视图类型]
     */
    public void resetViewType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetViewType();
            return;
        }

        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }
    /**
     *  设置属性值[视图版本]
     *  @param viewver
     */
    public void setViewVer(Integer viewver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setViewVer(viewver);
            return;
        }
        this.viewver = viewver;
        this.viewverDirtyFlag  = true;
    }

    /**
     *  获取属性值[视图版本]
     */
    public Integer getViewVer() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewVer();
        }
        return this.viewver;
    }

    /**
     *  获取属性值[视图版本]是否修改
     */
    public boolean isViewVerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewVerDirty();
        }
        return this.viewverDirtyFlag;
    }

    /**
     *  重置属性值[视图版本]
     */
    public void resetViewVer() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetViewVer();
            return;
        }

        this.viewverDirtyFlag = false;
        this.viewver = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        DSDynaViewBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DSDynaViewBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEWFId();
        et.resetDSDynaViewId();
        et.resetDSDynaViewName();
        et.resetPDVTParam();
        et.resetPredefinedViewType();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetViewDesc();
        et.resetViewInstObj();
        et.resetViewType();
        et.resetViewVer();
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
        if(!bDirtyOnly || isDEWFIdDirty()) {
            params.put(FIELD_DEWFID,getDEWFId());
        }
        if(!bDirtyOnly || isDSDynaViewIdDirty()) {
            params.put(FIELD_DSDYNAVIEWID,getDSDynaViewId());
        }
        if(!bDirtyOnly || isDSDynaViewNameDirty()) {
            params.put(FIELD_DSDYNAVIEWNAME,getDSDynaViewName());
        }
        if(!bDirtyOnly || isPDVTParamDirty()) {
            params.put(FIELD_PDVTPARAM,getPDVTParam());
        }
        if(!bDirtyOnly || isPredefinedViewTypeDirty()) {
            params.put(FIELD_PREDEFINEDVIEWTYPE,getPredefinedViewType());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isViewDescDirty()) {
            params.put(FIELD_VIEWDESC,getViewDesc());
        }
        if(!bDirtyOnly || isViewInstObjDirty()) {
            params.put(FIELD_VIEWINSTOBJ,getViewInstObj());
        }
        if(!bDirtyOnly || isViewTypeDirty()) {
            params.put(FIELD_VIEWTYPE,getViewType());
        }
        if(!bDirtyOnly || isViewVerDirty()) {
            params.put(FIELD_VIEWVER,getViewVer());
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

        return  DSDynaViewBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DSDynaViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DEWFID:
            return et.getDEWFId();
        case INDEX_DSDYNAVIEWID:
            return et.getDSDynaViewId();
        case INDEX_DSDYNAVIEWNAME:
            return et.getDSDynaViewName();
        case INDEX_PDVTPARAM:
            return et.getPDVTParam();
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.getPredefinedViewType();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VIEWDESC:
            return et.getViewDesc();
        case INDEX_VIEWINSTOBJ:
            return et.getViewInstObj();
        case INDEX_VIEWTYPE:
            return et.getViewType();
        case INDEX_VIEWVER:
            return et.getViewVer();
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

        DSDynaViewBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DSDynaViewBase et,int index,Object obj) throws Exception {
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
        case INDEX_DEWFID:
            et.setDEWFId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAVIEWID:
            et.setDSDynaViewId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DSDYNAVIEWNAME:
            et.setDSDynaViewName(DataObject.getStringValue(obj));
            return ;
        case INDEX_PDVTPARAM:
            et.setPDVTParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_PREDEFINEDVIEWTYPE:
            et.setPredefinedViewType(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VIEWDESC:
            et.setViewDesc(DataObject.getStringValue(obj));
            return ;
        case INDEX_VIEWINSTOBJ:
            et.setViewInstObj(DataObject.getStringValue(obj));
            return ;
        case INDEX_VIEWTYPE:
            et.setViewType(DataObject.getStringValue(obj));
            return ;
        case INDEX_VIEWVER:
            et.setViewVer(DataObject.getIntegerValue(obj));
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

        return  DSDynaViewBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DSDynaViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DEWFID:
            return et.getDEWFId()==null;
        case INDEX_DSDYNAVIEWID:
            return et.getDSDynaViewId()==null;
        case INDEX_DSDYNAVIEWNAME:
            return et.getDSDynaViewName()==null;
        case INDEX_PDVTPARAM:
            return et.getPDVTParam()==null;
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.getPredefinedViewType()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VIEWDESC:
            return et.getViewDesc()==null;
        case INDEX_VIEWINSTOBJ:
            return et.getViewInstObj()==null;
        case INDEX_VIEWTYPE:
            return et.getViewType()==null;
        case INDEX_VIEWVER:
            return et.getViewVer()==null;
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
        return  DSDynaViewBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DSDynaViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DEWFID:
            return et.isDEWFIdDirty();
        case INDEX_DSDYNAVIEWID:
            return et.isDSDynaViewIdDirty();
        case INDEX_DSDYNAVIEWNAME:
            return et.isDSDynaViewNameDirty();
        case INDEX_PDVTPARAM:
            return et.isPDVTParamDirty();
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.isPredefinedViewTypeDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VIEWDESC:
            return et.isViewDescDirty();
        case INDEX_VIEWINSTOBJ:
            return et.isViewInstObjDirty();
        case INDEX_VIEWTYPE:
            return et.isViewTypeDirty();
        case INDEX_VIEWVER:
            return et.isViewVerDirty();
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
    private static  void fillJSONObject(DSDynaViewBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            JSONObjectHelper.put(json,"deid",getJSONValue(et.getDEId()),false);
        }
        if(bIncEmpty||et.getDEWFId()!=null) {
            JSONObjectHelper.put(json,"dewfid",getJSONValue(et.getDEWFId()),false);
        }
        if(bIncEmpty||et.getDSDynaViewId()!=null) {
            JSONObjectHelper.put(json,"dsdynaviewid",getJSONValue(et.getDSDynaViewId()),false);
        }
        if(bIncEmpty||et.getDSDynaViewName()!=null) {
            JSONObjectHelper.put(json,"dsdynaviewname",getJSONValue(et.getDSDynaViewName()),false);
        }
        if(bIncEmpty||et.getPDVTParam()!=null) {
            JSONObjectHelper.put(json,"pdvtparam",getJSONValue(et.getPDVTParam()),false);
        }
        if(bIncEmpty||et.getPredefinedViewType()!=null) {
            JSONObjectHelper.put(json,"predefinedviewtype",getJSONValue(et.getPredefinedViewType()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getViewDesc()!=null) {
            JSONObjectHelper.put(json,"viewdesc",getJSONValue(et.getViewDesc()),false);
        }
        if(bIncEmpty||et.getViewInstObj()!=null) {
            JSONObjectHelper.put(json,"viewinstobj",getJSONValue(et.getViewInstObj()),false);
        }
        if(bIncEmpty||et.getViewType()!=null) {
            JSONObjectHelper.put(json,"viewtype",getJSONValue(et.getViewType()),false);
        }
        if(bIncEmpty||et.getViewVer()!=null) {
            JSONObjectHelper.put(json,"viewver",getJSONValue(et.getViewVer()),false);
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
    private static void fillXmlNode(DSDynaViewBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getDEWFId()!=null) {
            Object obj = et.getDEWFId();
            node.setAttribute("DEWFID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaViewId()!=null) {
            Object obj = et.getDSDynaViewId();
            node.setAttribute("DSDYNAVIEWID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDSDynaViewName()!=null) {
            Object obj = et.getDSDynaViewName();
            node.setAttribute("DSDYNAVIEWNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPDVTParam()!=null) {
            Object obj = et.getPDVTParam();
            node.setAttribute("PDVTPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPredefinedViewType()!=null) {
            Object obj = et.getPredefinedViewType();
            node.setAttribute("PREDEFINEDVIEWTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getViewDesc()!=null) {
            Object obj = et.getViewDesc();
            node.setAttribute("VIEWDESC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getViewInstObj()!=null) {
            Object obj = et.getViewInstObj();
            node.setAttribute("VIEWINSTOBJ",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getViewType()!=null) {
            Object obj = et.getViewType();
            node.setAttribute("VIEWTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getViewVer()!=null) {
            Object obj = et.getViewVer();
            node.setAttribute("VIEWVER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaViewBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DSDynaViewBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDEIdDirty() && (bIncEmpty||et.getDEId()!=null)) {
            dst.set(FIELD_DEID,et.getDEId());
        }
        if(et.isDEWFIdDirty() && (bIncEmpty||et.getDEWFId()!=null)) {
            dst.set(FIELD_DEWFID,et.getDEWFId());
        }
        if(et.isDSDynaViewIdDirty() && (bIncEmpty||et.getDSDynaViewId()!=null)) {
            dst.set(FIELD_DSDYNAVIEWID,et.getDSDynaViewId());
        }
        if(et.isDSDynaViewNameDirty() && (bIncEmpty||et.getDSDynaViewName()!=null)) {
            dst.set(FIELD_DSDYNAVIEWNAME,et.getDSDynaViewName());
        }
        if(et.isPDVTParamDirty() && (bIncEmpty||et.getPDVTParam()!=null)) {
            dst.set(FIELD_PDVTPARAM,et.getPDVTParam());
        }
        if(et.isPredefinedViewTypeDirty() && (bIncEmpty||et.getPredefinedViewType()!=null)) {
            dst.set(FIELD_PREDEFINEDVIEWTYPE,et.getPredefinedViewType());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isViewDescDirty() && (bIncEmpty||et.getViewDesc()!=null)) {
            dst.set(FIELD_VIEWDESC,et.getViewDesc());
        }
        if(et.isViewInstObjDirty() && (bIncEmpty||et.getViewInstObj()!=null)) {
            dst.set(FIELD_VIEWINSTOBJ,et.getViewInstObj());
        }
        if(et.isViewTypeDirty() && (bIncEmpty||et.getViewType()!=null)) {
            dst.set(FIELD_VIEWTYPE,et.getViewType());
        }
        if(et.isViewVerDirty() && (bIncEmpty||et.getViewVer()!=null)) {
            dst.set(FIELD_VIEWVER,et.getViewVer());
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
        return  DSDynaViewBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DSDynaViewBase et,int index) throws Exception {
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
        case INDEX_DEWFID:
            et.resetDEWFId();
            return true;
        case INDEX_DSDYNAVIEWID:
            et.resetDSDynaViewId();
            return true;
        case INDEX_DSDYNAVIEWNAME:
            et.resetDSDynaViewName();
            return true;
        case INDEX_PDVTPARAM:
            et.resetPDVTParam();
            return true;
        case INDEX_PREDEFINEDVIEWTYPE:
            et.resetPredefinedViewType();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VIEWDESC:
            et.resetViewDesc();
            return true;
        case INDEX_VIEWINSTOBJ:
            et.resetViewInstObj();
            return true;
        case INDEX_VIEWTYPE:
            et.resetViewType();
            return true;
        case INDEX_VIEWVER:
            et.resetViewVer();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    private Integer objDSDynaViewInstsLock = new Integer(1);
    private ArrayList<net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst> dsdynaviewinsts = null;

    /**
    * 获取子数据 动态视图实例
     * @throws Exception
    */
    public ArrayList<net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst> getDSDynaViewInsts() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDSDynaViewInsts();
        }
        if(this.getDSDynaViewId()==null)
            return null;
        net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService service = (net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService)ServiceGlobal.getService(net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService.class,this.getSessionFactory());
        synchronized(objDSDynaViewInstsLock) {
            if(dsdynaviewinsts==null) {
                dsdynaviewinsts =  service.selectByDSDynaView(this);
            }
            return dsdynaviewinsts;
        }
    }

    /**
     *  获取代理的数据对象
     */
    private DSDynaViewBase getProxyEntity() {
        return this.proxyDSDynaViewBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaViewBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DSDynaViewBase) {
            this.proxyDSDynaViewBase = (DSDynaViewBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}