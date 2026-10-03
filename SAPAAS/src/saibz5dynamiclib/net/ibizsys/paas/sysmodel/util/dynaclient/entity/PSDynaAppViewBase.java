/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  基于实体数据对象基类模板,https://gitee.com/dev_ibizsys/PSSF/tree/master/J2EE6_IBIZSYSRT_MS/DEENTITYBASE/MAIN.java
 */
package net.ibizsys.paas.sysmodel.util.dynaclient.entity;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[PSDynaAppView] 数据对象基类
 */
public abstract class PSDynaAppViewBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewBase.class);
    /**
     * 属性[动态应用视图标识]
     */
    public final static String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    /**
     * 属性[动态应用视图名称]
     */
    public final static String FIELD_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    /**
     * 属性[应用视图类型]
     */
    public final static String FIELD_VIEWTYPE = "VIEWTYPE";
    /**
     * 属性[预置视图类型参数]
     */
    public final static String FIELD_PDVTPARAM = "PDVTPARAM";
    /**
     * 属性[预置视图类型]
     */
    public final static String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    /**
     * 属性[实体工作流]
     */
    public final static String FIELD_PSWFDEID = "PSWFDEID";
    /**
     * 属性[动态实体]
     */
    public final static String FIELD_PSDYNADEID = "PSDYNADEID";

    private final static int INDEX_PSDYNAAPPVIEWID = 0;
    private final static int INDEX_PSDYNAAPPVIEWNAME = 1;
    private final static int INDEX_VIEWTYPE = 2;
    private final static int INDEX_PDVTPARAM = 3;
    private final static int INDEX_PREDEFINEDVIEWTYPE = 4;
    private final static int INDEX_PSWFDEID = 5;
    private final static int INDEX_PSDYNADEID = 6;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_PSDYNAAPPVIEWID, INDEX_PSDYNAAPPVIEWID);
        fieldIndexMap.put( FIELD_PSDYNAAPPVIEWNAME, INDEX_PSDYNAAPPVIEWNAME);
        fieldIndexMap.put( FIELD_VIEWTYPE, INDEX_VIEWTYPE);
        fieldIndexMap.put( FIELD_PDVTPARAM, INDEX_PDVTPARAM);
        fieldIndexMap.put( FIELD_PREDEFINEDVIEWTYPE, INDEX_PREDEFINEDVIEWTYPE);
        fieldIndexMap.put( FIELD_PSWFDEID, INDEX_PSWFDEID);
        fieldIndexMap.put( FIELD_PSDYNADEID, INDEX_PSDYNADEID);
    }

    private PSDynaAppViewBase proxyPSDynaAppViewBase = null;
    public PSDynaAppViewBase() {
        super();
    }
    private boolean psdynaappviewidDirtyFlag = false;
    private boolean psdynaappviewnameDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean psdynadeidDirtyFlag = false;

    @Column(name="psdynaappviewid")
    private String psdynaappviewid;
    @Column(name="psdynaappviewname")
    private String psdynaappviewname;
    @Column(name="viewtype")
    private String viewtype;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="psdynadeid")
    private String psdynadeid;


    /**
     *  设置属性值[动态应用视图标识]
     *  @param psdynaappviewid
     */
    public void setPSDynaAppViewId(String psdynaappviewid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPSDynaAppViewId(psdynaappviewid);
            return;
        }
        if(psdynaappviewid!=null) {
            psdynaappviewid = StringHelper.trimRight(psdynaappviewid);
            if(psdynaappviewid.length()==0) {
                psdynaappviewid = null;
            }
        }
        this.psdynaappviewid = psdynaappviewid;
        this.psdynaappviewidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态应用视图标识]
     */
    public String getPSDynaAppViewId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    /**
     *  获取属性值[动态应用视图标识]是否修改
     */
    public boolean isPSDynaAppViewIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    /**
     *  重置属性值[动态应用视图标识]
     */
    public void resetPSDynaAppViewId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }

        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }
    /**
     *  设置属性值[动态应用视图名称]
     *  @param psdynaappviewname
     */
    public void setPSDynaAppViewName(String psdynaappviewname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPSDynaAppViewName(psdynaappviewname);
            return;
        }
        if(psdynaappviewname!=null) {
            psdynaappviewname = StringHelper.trimRight(psdynaappviewname);
            if(psdynaappviewname.length()==0) {
                psdynaappviewname = null;
            }
        }
        this.psdynaappviewname = psdynaappviewname;
        this.psdynaappviewnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态应用视图名称]
     */
    public String getPSDynaAppViewName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPSDynaAppViewName();
        }
        return this.psdynaappviewname;
    }

    /**
     *  获取属性值[动态应用视图名称]是否修改
     */
    public boolean isPSDynaAppViewNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPSDynaAppViewNameDirty();
        }
        return this.psdynaappviewnameDirtyFlag;
    }

    /**
     *  重置属性值[动态应用视图名称]
     */
    public void resetPSDynaAppViewName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPSDynaAppViewName();
            return;
        }

        this.psdynaappviewnameDirtyFlag = false;
        this.psdynaappviewname = null;
    }
    /**
     *  设置属性值[应用视图类型]代码表：net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel
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
     *  获取属性值[应用视图类型]代码表：net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel
     */
    public String getViewType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    /**
     *  获取属性值[应用视图类型]是否修改
     */
    public boolean isViewTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    /**
     *  重置属性值[应用视图类型]
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
     *  设置属性值[预置视图类型]代码表：net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel
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
     *  获取属性值[预置视图类型]代码表：net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel
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
     *  设置属性值[实体工作流]
     *  @param pswfdeid
     */
    public void setPSWFDEId(String pswfdeid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPSWFDEId(pswfdeid);
            return;
        }
        if(pswfdeid!=null) {
            pswfdeid = StringHelper.trimRight(pswfdeid);
            if(pswfdeid.length()==0) {
                pswfdeid = null;
            }
        }
        this.pswfdeid = pswfdeid;
        this.pswfdeidDirtyFlag  = true;
    }

    /**
     *  获取属性值[实体工作流]
     */
    public String getPSWFDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    /**
     *  获取属性值[实体工作流]是否修改
     */
    public boolean isPSWFDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    /**
     *  重置属性值[实体工作流]
     */
    public void resetPSWFDEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }

        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }
    /**
     *  设置属性值[动态实体]
     *  @param psdynadeid
     */
    public void setPSDynaDEId(String psdynadeid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPSDynaDEId(psdynadeid);
            return;
        }
        if(psdynadeid!=null) {
            psdynadeid = StringHelper.trimRight(psdynadeid);
            if(psdynadeid.length()==0) {
                psdynadeid = null;
            }
        }
        this.psdynadeid = psdynadeid;
        this.psdynadeidDirtyFlag  = true;
    }

    /**
     *  获取属性值[动态实体]
     */
    public String getPSDynaDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPSDynaDEId();
        }
        return this.psdynadeid;
    }

    /**
     *  获取属性值[动态实体]是否修改
     */
    public boolean isPSDynaDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPSDynaDEIdDirty();
        }
        return this.psdynadeidDirtyFlag;
    }

    /**
     *  重置属性值[动态实体]
     */
    public void resetPSDynaDEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPSDynaDEId();
            return;
        }

        this.psdynadeidDirtyFlag = false;
        this.psdynadeid = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        PSDynaAppViewBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PSDynaAppViewBase et) {
        et.resetPSDynaAppViewId();
        et.resetPSDynaAppViewName();
        et.resetViewType();
        et.resetPDVTParam();
        et.resetPredefinedViewType();
        et.resetPSWFDEId();
        et.resetPSDynaDEId();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isPSDynaAppViewIdDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWID,getPSDynaAppViewId());
        }
        if(!bDirtyOnly || isPSDynaAppViewNameDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWNAME,getPSDynaAppViewName());
        }
        if(!bDirtyOnly || isViewTypeDirty()) {
            params.put(FIELD_VIEWTYPE,getViewType());
        }
        if(!bDirtyOnly || isPDVTParamDirty()) {
            params.put(FIELD_PDVTPARAM,getPDVTParam());
        }
        if(!bDirtyOnly || isPredefinedViewTypeDirty()) {
            params.put(FIELD_PREDEFINEDVIEWTYPE,getPredefinedViewType());
        }
        if(!bDirtyOnly || isPSWFDEIdDirty()) {
            params.put(FIELD_PSWFDEID,getPSWFDEId());
        }
        if(!bDirtyOnly || isPSDynaDEIdDirty()) {
            params.put(FIELD_PSDYNADEID,getPSDynaDEId());
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

        return  PSDynaAppViewBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PSDynaAppViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_PSDYNAAPPVIEWID:
            return et.getPSDynaAppViewId();
        case INDEX_PSDYNAAPPVIEWNAME:
            return et.getPSDynaAppViewName();
        case INDEX_VIEWTYPE:
            return et.getViewType();
        case INDEX_PDVTPARAM:
            return et.getPDVTParam();
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.getPredefinedViewType();
        case INDEX_PSWFDEID:
            return et.getPSWFDEId();
        case INDEX_PSDYNADEID:
            return et.getPSDynaDEId();
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

        PSDynaAppViewBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(PSDynaAppViewBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_PSDYNAAPPVIEWID:
            et.setPSDynaAppViewId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PSDYNAAPPVIEWNAME:
            et.setPSDynaAppViewName(DataObject.getStringValue(obj));
            return ;
        case INDEX_VIEWTYPE:
            et.setViewType(DataObject.getStringValue(obj));
            return ;
        case INDEX_PDVTPARAM:
            et.setPDVTParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_PREDEFINEDVIEWTYPE:
            et.setPredefinedViewType(DataObject.getStringValue(obj));
            return ;
        case INDEX_PSWFDEID:
            et.setPSWFDEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PSDYNADEID:
            et.setPSDynaDEId(DataObject.getStringValue(obj));
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

        return  PSDynaAppViewBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(PSDynaAppViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_PSDYNAAPPVIEWID:
            return et.getPSDynaAppViewId()==null;
        case INDEX_PSDYNAAPPVIEWNAME:
            return et.getPSDynaAppViewName()==null;
        case INDEX_VIEWTYPE:
            return et.getViewType()==null;
        case INDEX_PDVTPARAM:
            return et.getPDVTParam()==null;
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.getPredefinedViewType()==null;
        case INDEX_PSWFDEID:
            return et.getPSWFDEId()==null;
        case INDEX_PSDYNADEID:
            return et.getPSDynaDEId()==null;
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
        return  PSDynaAppViewBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(PSDynaAppViewBase et,int index) throws Exception {

        switch(index) {
        case INDEX_PSDYNAAPPVIEWID:
            return et.isPSDynaAppViewIdDirty();
        case INDEX_PSDYNAAPPVIEWNAME:
            return et.isPSDynaAppViewNameDirty();
        case INDEX_VIEWTYPE:
            return et.isViewTypeDirty();
        case INDEX_PDVTPARAM:
            return et.isPDVTParamDirty();
        case INDEX_PREDEFINEDVIEWTYPE:
            return et.isPredefinedViewTypeDirty();
        case INDEX_PSWFDEID:
            return et.isPSWFDEIdDirty();
        case INDEX_PSDYNADEID:
            return et.isPSDynaDEIdDirty();
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
    private static  void fillJSONObject(PSDynaAppViewBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getPSDynaAppViewId()!=null) {
            JSONObjectHelper.put(json,"psdynaappviewid",getJSONValue(et.getPSDynaAppViewId()),false);
        }
        if(bIncEmpty||et.getPSDynaAppViewName()!=null) {
            JSONObjectHelper.put(json,"psdynaappviewname",getJSONValue(et.getPSDynaAppViewName()),false);
        }
        if(bIncEmpty||et.getViewType()!=null) {
            JSONObjectHelper.put(json,"viewtype",getJSONValue(et.getViewType()),false);
        }
        if(bIncEmpty||et.getPDVTParam()!=null) {
            JSONObjectHelper.put(json,"pdvtparam",getJSONValue(et.getPDVTParam()),false);
        }
        if(bIncEmpty||et.getPredefinedViewType()!=null) {
            JSONObjectHelper.put(json,"predefinedviewtype",getJSONValue(et.getPredefinedViewType()),false);
        }
        if(bIncEmpty||et.getPSWFDEId()!=null) {
            JSONObjectHelper.put(json,"pswfdeid",getJSONValue(et.getPSWFDEId()),false);
        }
        if(bIncEmpty||et.getPSDynaDEId()!=null) {
            JSONObjectHelper.put(json,"psdynadeid",getJSONValue(et.getPSDynaDEId()),false);
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
    private static void fillXmlNode(PSDynaAppViewBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getPSDynaAppViewId()!=null) {
            Object obj = et.getPSDynaAppViewId();
            node.setAttribute("PSDYNAAPPVIEWID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPSDynaAppViewName()!=null) {
            Object obj = et.getPSDynaAppViewName();
            node.setAttribute("PSDYNAAPPVIEWNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getViewType()!=null) {
            Object obj = et.getViewType();
            node.setAttribute("VIEWTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPDVTParam()!=null) {
            Object obj = et.getPDVTParam();
            node.setAttribute("PDVTPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPredefinedViewType()!=null) {
            Object obj = et.getPredefinedViewType();
            node.setAttribute("PREDEFINEDVIEWTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPSWFDEId()!=null) {
            Object obj = et.getPSWFDEId();
            node.setAttribute("PSWFDEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPSDynaDEId()!=null) {
            Object obj = et.getPSDynaDEId();
            node.setAttribute("PSDYNADEID",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaAppViewBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(PSDynaAppViewBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isPSDynaAppViewIdDirty() && (bIncEmpty||et.getPSDynaAppViewId()!=null)) {
            dst.set(FIELD_PSDYNAAPPVIEWID,et.getPSDynaAppViewId());
        }
        if(et.isPSDynaAppViewNameDirty() && (bIncEmpty||et.getPSDynaAppViewName()!=null)) {
            dst.set(FIELD_PSDYNAAPPVIEWNAME,et.getPSDynaAppViewName());
        }
        if(et.isViewTypeDirty() && (bIncEmpty||et.getViewType()!=null)) {
            dst.set(FIELD_VIEWTYPE,et.getViewType());
        }
        if(et.isPDVTParamDirty() && (bIncEmpty||et.getPDVTParam()!=null)) {
            dst.set(FIELD_PDVTPARAM,et.getPDVTParam());
        }
        if(et.isPredefinedViewTypeDirty() && (bIncEmpty||et.getPredefinedViewType()!=null)) {
            dst.set(FIELD_PREDEFINEDVIEWTYPE,et.getPredefinedViewType());
        }
        if(et.isPSWFDEIdDirty() && (bIncEmpty||et.getPSWFDEId()!=null)) {
            dst.set(FIELD_PSWFDEID,et.getPSWFDEId());
        }
        if(et.isPSDynaDEIdDirty() && (bIncEmpty||et.getPSDynaDEId()!=null)) {
            dst.set(FIELD_PSDYNADEID,et.getPSDynaDEId());
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
        return  PSDynaAppViewBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(PSDynaAppViewBase et,int index) throws Exception {
        switch(index) {
        case INDEX_PSDYNAAPPVIEWID:
            et.resetPSDynaAppViewId();
            return true;
        case INDEX_PSDYNAAPPVIEWNAME:
            et.resetPSDynaAppViewName();
            return true;
        case INDEX_VIEWTYPE:
            et.resetViewType();
            return true;
        case INDEX_PDVTPARAM:
            et.resetPDVTParam();
            return true;
        case INDEX_PREDEFINEDVIEWTYPE:
            et.resetPredefinedViewType();
            return true;
        case INDEX_PSWFDEID:
            et.resetPSWFDEId();
            return true;
        case INDEX_PSDYNADEID:
            et.resetPSDynaDEId();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private PSDynaAppViewBase getProxyEntity() {
        return this.proxyPSDynaAppViewBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaAppViewBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof PSDynaAppViewBase) {
            this.proxyPSDynaAppViewBase = (PSDynaAppViewBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

}