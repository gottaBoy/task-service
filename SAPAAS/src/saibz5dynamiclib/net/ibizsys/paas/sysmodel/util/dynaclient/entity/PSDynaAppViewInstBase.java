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
 * 实体[PSDynaAppViewInst] 数据对象
 */
public abstract class PSDynaAppViewInstBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

   private static final long serialVersionUID = -1L;
   private static final Log log = LogFactory.getLog(PSDynaAppViewInstBase.class); 
   /**
    *   实体属性标识[动态应用视图标识]
    */
   public final static String FIELD_PSDYNAAPPVIEWINSTID = "PSDYNAAPPVIEWINSTID";
   /**
    *   实体属性标识[动态应用视图]
    */
   public final static String FIELD_PSDYNAAPPVIEWINSTNAME = "PSDYNAAPPVIEWINSTNAME";
   /**
    *   实体属性标识[系统动态实例]
    */
   public final static String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
   /**
    *   实体属性标识[预置视图类型]
    */
   public final static String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
   /**
    *   实体属性标识[实例版本]
    */
   public final static String FIELD_INSTVER = "INSTVER";
   /**
    *   实体属性标识[动态模型]
    */
   public final static String FIELD_DYNAMODEL = "DYNAMODEL";
   /**
    *   实体属性标识[预置视图类型参数]
    */
   public final static String FIELD_PDVTPARAM = "PDVTPARAM";
   /**
    *   实体属性标识[应用视图]
    */
   public final static String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";

   private final static int INDEX_PSDYNAAPPVIEWINSTID = 0;
   private final static int INDEX_PSDYNAAPPVIEWINSTNAME = 1;
   private final static int INDEX_PSDYNAINSTID = 2;
   private final static int INDEX_PREDEFINEDVIEWTYPE = 3;
   private final static int INDEX_INSTVER = 4;
   private final static int INDEX_DYNAMODEL = 5;
   private final static int INDEX_PDVTPARAM = 6;
   private final static int INDEX_PSDYNAAPPVIEWID = 7;

   private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
   static
   {
       fieldIndexMap.put( FIELD_PSDYNAAPPVIEWINSTID, INDEX_PSDYNAAPPVIEWINSTID);
       fieldIndexMap.put( FIELD_PSDYNAAPPVIEWINSTNAME, INDEX_PSDYNAAPPVIEWINSTNAME);
       fieldIndexMap.put( FIELD_PSDYNAINSTID, INDEX_PSDYNAINSTID);
       fieldIndexMap.put( FIELD_PREDEFINEDVIEWTYPE, INDEX_PREDEFINEDVIEWTYPE);
       fieldIndexMap.put( FIELD_INSTVER, INDEX_INSTVER);
       fieldIndexMap.put( FIELD_DYNAMODEL, INDEX_DYNAMODEL);
       fieldIndexMap.put( FIELD_PDVTPARAM, INDEX_PDVTPARAM);
       fieldIndexMap.put( FIELD_PSDYNAAPPVIEWID, INDEX_PSDYNAAPPVIEWID);
   }
   
   private PSDynaAppViewInstBase proxyPSDynaAppViewInstBase = null;

   public PSDynaAppViewInstBase(){
        super();
   }
   private boolean psdynaappviewinstidDirtyFlag = false;
   private boolean psdynaappviewinstnameDirtyFlag = false;
   private boolean psdynainstidDirtyFlag = false;
   private boolean predefinedviewtypeDirtyFlag = false;
   private boolean instverDirtyFlag = false;
   private boolean dynamodelDirtyFlag = false;
   private boolean pdvtparamDirtyFlag = false;
   private boolean psdynaappviewidDirtyFlag = false;

    @Column(name="psdynaappviewinstid")
    private String psdynaappviewinstid;
    @Column(name="psdynaappviewinstname")
    private String psdynaappviewinstname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="instver")
    private Integer instver;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;

   
    /**
     *  设置属性值[动态应用视图标识]
     *  @param psdynaappviewinstid
     */
    public void setPSDynaAppViewInstId(String psdynaappviewinstid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaAppViewInstId(psdynaappviewinstid);
    		return;
    	}
        if(psdynaappviewinstid!=null)
        {
        	psdynaappviewinstid = StringHelper.trimRight(psdynaappviewinstid);
        	if(psdynaappviewinstid.length()==0){
        		psdynaappviewinstid = null;
        	}
        }
        this.psdynaappviewinstid =  psdynaappviewinstid; 
        this.psdynaappviewinstidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态应用视图标识]
     */
    public String getPSDynaAppViewInstId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaAppViewInstId();
    	}
        return this.psdynaappviewinstid;
    }

    /**
     *  获取属性值[动态应用视图标识]是否修改
     */
    public boolean isPSDynaAppViewInstIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaAppViewInstIdDirty();
    	}
        return this.psdynaappviewinstidDirtyFlag;
    }

    /**
     *  重置属性值[动态应用视图标识]
     */
    public void resetPSDynaAppViewInstId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaAppViewInstId();
    		 return;
    	}
    	
        this.psdynaappviewinstidDirtyFlag = false;
        this.psdynaappviewinstid = null;
    }
    /**
     *  设置属性值[动态应用视图]
     *  @param psdynaappviewinstname
     */
    public void setPSDynaAppViewInstName(String psdynaappviewinstname){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaAppViewInstName(psdynaappviewinstname);
    		return;
    	}
        if(psdynaappviewinstname!=null)
        {
        	psdynaappviewinstname = StringHelper.trimRight(psdynaappviewinstname);
        	if(psdynaappviewinstname.length()==0){
        		psdynaappviewinstname = null;
        	}
        }
        this.psdynaappviewinstname =  psdynaappviewinstname; 
        this.psdynaappviewinstnameDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态应用视图]
     */
    public String getPSDynaAppViewInstName(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaAppViewInstName();
    	}
        return this.psdynaappviewinstname;
    }

    /**
     *  获取属性值[动态应用视图]是否修改
     */
    public boolean isPSDynaAppViewInstNameDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaAppViewInstNameDirty();
    	}
        return this.psdynaappviewinstnameDirtyFlag;
    }

    /**
     *  重置属性值[动态应用视图]
     */
    public void resetPSDynaAppViewInstName(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaAppViewInstName();
    		 return;
    	}
    	
        this.psdynaappviewinstnameDirtyFlag = false;
        this.psdynaappviewinstname = null;
    }
    /**
     *  设置属性值[系统动态实例]
     *  @param psdynainstid
     */
    public void setPSDynaInstId(String psdynainstid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaInstId(psdynainstid);
    		return;
    	}
        if(psdynainstid!=null)
        {
        	psdynainstid = StringHelper.trimRight(psdynainstid);
        	if(psdynainstid.length()==0){
        		psdynainstid = null;
        	}
        }
        this.psdynainstid =  psdynainstid; 
        this.psdynainstidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[系统动态实例]
     */
    public String getPSDynaInstId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaInstId();
    	}
        return this.psdynainstid;
    }

    /**
     *  获取属性值[系统动态实例]是否修改
     */
    public boolean isPSDynaInstIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaInstIdDirty();
    	}
        return this.psdynainstidDirtyFlag;
    }

    /**
     *  重置属性值[系统动态实例]
     */
    public void resetPSDynaInstId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaInstId();
    		 return;
    	}
    	
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }
    /**
     *  设置属性值[预置视图类型]
     *  @param predefinedviewtype
     */
    public void setPredefinedViewType(String predefinedviewtype){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPredefinedViewType(predefinedviewtype);
    		return;
    	}
        if(predefinedviewtype!=null)
        {
        	predefinedviewtype = StringHelper.trimRight(predefinedviewtype);
        	if(predefinedviewtype.length()==0){
        		predefinedviewtype = null;
        	}
        }
        this.predefinedviewtype =  predefinedviewtype; 
        this.predefinedviewtypeDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[预置视图类型]
     */
    public String getPredefinedViewType(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPredefinedViewType();
    	}
        return this.predefinedviewtype;
    }

    /**
     *  获取属性值[预置视图类型]是否修改
     */
    public boolean isPredefinedViewTypeDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPredefinedViewTypeDirty();
    	}
        return this.predefinedviewtypeDirtyFlag;
    }

    /**
     *  重置属性值[预置视图类型]
     */
    public void resetPredefinedViewType(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPredefinedViewType();
    		 return;
    	}
    	
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
    }
    /**
     *  设置属性值[实例版本]
     *  @param instver
     */
    public void setInstVer(Integer instver){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setInstVer(instver);
    		return;
    	}
        this.instver =  instver; 
        this.instverDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[实例版本]
     */
    public Integer getInstVer(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getInstVer();
    	}
        return this.instver;
    }

    /**
     *  获取属性值[实例版本]是否修改
     */
    public boolean isInstVerDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isInstVerDirty();
    	}
        return this.instverDirtyFlag;
    }

    /**
     *  重置属性值[实例版本]
     */
    public void resetInstVer(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetInstVer();
    		 return;
    	}
    	
        this.instverDirtyFlag = false;
        this.instver = null;
    }
    /**
     *  设置属性值[动态模型]
     *  @param dynamodel
     */
    public void setDynaModel(String dynamodel){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setDynaModel(dynamodel);
    		return;
    	}
        if(dynamodel!=null)
        {
        	dynamodel = StringHelper.trimRight(dynamodel);
        	if(dynamodel.length()==0){
        		dynamodel = null;
        	}
        }
        this.dynamodel =  dynamodel; 
        this.dynamodelDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态模型]
     */
    public String getDynaModel(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getDynaModel();
    	}
        return this.dynamodel;
    }

    /**
     *  获取属性值[动态模型]是否修改
     */
    public boolean isDynaModelDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isDynaModelDirty();
    	}
        return this.dynamodelDirtyFlag;
    }

    /**
     *  重置属性值[动态模型]
     */
    public void resetDynaModel(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetDynaModel();
    		 return;
    	}
    	
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }
    /**
     *  设置属性值[预置视图类型参数]
     *  @param pdvtparam
     */
    public void setPDVTParam(String pdvtparam){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPDVTParam(pdvtparam);
    		return;
    	}
        if(pdvtparam!=null)
        {
        	pdvtparam = StringHelper.trimRight(pdvtparam);
        	if(pdvtparam.length()==0){
        		pdvtparam = null;
        	}
        }
        this.pdvtparam =  pdvtparam; 
        this.pdvtparamDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[预置视图类型参数]
     */
    public String getPDVTParam(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPDVTParam();
    	}
        return this.pdvtparam;
    }

    /**
     *  获取属性值[预置视图类型参数]是否修改
     */
    public boolean isPDVTParamDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPDVTParamDirty();
    	}
        return this.pdvtparamDirtyFlag;
    }

    /**
     *  重置属性值[预置视图类型参数]
     */
    public void resetPDVTParam(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPDVTParam();
    		 return;
    	}
    	
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }
    /**
     *  设置属性值[应用视图]
     *  @param psdynaappviewid
     */
    public void setPSDynaAppViewId(String psdynaappviewid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaAppViewId(psdynaappviewid);
    		return;
    	}
        if(psdynaappviewid!=null)
        {
        	psdynaappviewid = StringHelper.trimRight(psdynaappviewid);
        	if(psdynaappviewid.length()==0){
        		psdynaappviewid = null;
        	}
        }
        this.psdynaappviewid =  psdynaappviewid; 
        this.psdynaappviewidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[应用视图]
     */
    public String getPSDynaAppViewId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaAppViewId();
    	}
        return this.psdynaappviewid;
    }

    /**
     *  获取属性值[应用视图]是否修改
     */
    public boolean isPSDynaAppViewIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaAppViewIdDirty();
    	}
        return this.psdynaappviewidDirtyFlag;
    }

    /**
     *  重置属性值[应用视图]
     */
    public void resetPSDynaAppViewId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaAppViewId();
    		 return;
    	}
    	
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.EntityBase#onReset()
	 */
    @Override
    protected void onReset()
    {
       PSDynaAppViewInstBase.resetAll(this);
       super.onReset();
    }
    
    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PSDynaAppViewInstBase et){
        et.resetPSDynaAppViewInstId();
        et.resetPSDynaAppViewInstName();
        et.resetPSDynaInstId();
        et.resetPredefinedViewType();
        et.resetInstVer();
        et.resetDynaModel();
        et.resetPDVTParam();
        et.resetPSDynaAppViewId();
    }

     /* (non-Javadoc)
      * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
      */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly)
    {
        if(!bDirtyOnly || isPSDynaAppViewInstIdDirty()){
             params.put(FIELD_PSDYNAAPPVIEWINSTID,getPSDynaAppViewInstId());
        } 
        if(!bDirtyOnly || isPSDynaAppViewInstNameDirty()){
             params.put(FIELD_PSDYNAAPPVIEWINSTNAME,getPSDynaAppViewInstName());
        } 
        if(!bDirtyOnly || isPSDynaInstIdDirty()){
             params.put(FIELD_PSDYNAINSTID,getPSDynaInstId());
        } 
        if(!bDirtyOnly || isPredefinedViewTypeDirty()){
             params.put(FIELD_PREDEFINEDVIEWTYPE,getPredefinedViewType());
        } 
        if(!bDirtyOnly || isInstVerDirty()){
             params.put(FIELD_INSTVER,getInstVer());
        } 
        if(!bDirtyOnly || isDynaModelDirty()){
             params.put(FIELD_DYNAMODEL,getDynaModel());
        } 
        if(!bDirtyOnly || isPDVTParamDirty()){
             params.put(FIELD_PDVTPARAM,getPDVTParam());
        } 
        if(!bDirtyOnly || isPSDynaAppViewIdDirty()){
             params.put(FIELD_PSDYNAAPPVIEWID,getPSDynaAppViewId());
        } 
    	super.onFillMap(params, bDirtyOnly);
    }
   
    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
	public Object get(String strParamName) throws Exception
	{
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().get(strParamName);
    	}
    	
            if(StringHelper.isNullOrEmpty(strParamName))
                 throw new Exception("没有指定属性");
            Integer index=fieldIndexMap.get(strParamName.toUpperCase());
            if(index==null)
                 return super.get(strParamName);

                return  PSDynaAppViewInstBase.get(this, index);
	}
    
    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PSDynaAppViewInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAAPPVIEWINSTID:return et.getPSDynaAppViewInstId();
               case INDEX_PSDYNAAPPVIEWINSTNAME:return et.getPSDynaAppViewInstName();
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId();
               case INDEX_PREDEFINEDVIEWTYPE:return et.getPredefinedViewType();
               case INDEX_INSTVER:return et.getInstVer();
               case INDEX_DYNAMODEL:return et.getDynaModel();
               case INDEX_PDVTPARAM:return et.getPDVTParam();
               case INDEX_PSDYNAAPPVIEWID:return et.getPSDynaAppViewId();
    	       default:
    		     throw new Exception("不明属性标识");
    	    }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
	public void set(String strParamName,Object objValue) throws Exception
	{
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().set(strParamName,objValue);
    		 return;
    	}
            if(StringHelper.isNullOrEmpty(strParamName))
                 throw new Exception("没有指定属性");

            Integer index=fieldIndexMap.get(strParamName.toUpperCase());
            if(index==null)
            {
                super.set(strParamName,objValue);
                return;
            }
            
            PSDynaAppViewInstBase.set(this,index,objValue);
 	}

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
            private static void set(PSDynaAppViewInstBase et,int index,Object obj) throws Exception
         {    
            switch(index)
    	    {
               case INDEX_PSDYNAAPPVIEWINSTID:et.setPSDynaAppViewInstId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAAPPVIEWINSTNAME:et.setPSDynaAppViewInstName(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAINSTID:et.setPSDynaInstId(DataObject.getStringValue(obj));return ;
               case INDEX_PREDEFINEDVIEWTYPE:et.setPredefinedViewType(DataObject.getStringValue(obj));return ;
               case INDEX_INSTVER:et.setInstVer(DataObject.getIntegerValue(obj));return ;
               case INDEX_DYNAMODEL:et.setDynaModel(DataObject.getStringValue(obj));return ;
               case INDEX_PDVTPARAM:et.setPDVTParam(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAAPPVIEWID:et.setPSDynaAppViewId(DataObject.getStringValue(obj));return ;
    	       default:
    		     throw new Exception("不明属性标识");
    	    }
        }

            /* (non-Javadoc)
             * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
             */
            @Override
    	public boolean isNull(String strParamName) throws Exception
    	{
			 if(this.getProxyEntity()!=null){
		 		return this.getProxyEntity().isNull(strParamName);
		 	}
            if(StringHelper.isNullOrEmpty(strParamName))
                 throw new Exception("没有指定属性");

    	    Integer index=fieldIndexMap.get(strParamName.toUpperCase());
            if(index==null)
                 return super.isNull(strParamName);

    	     return  PSDynaAppViewInstBase.isNull(this, index);
    	}

            /**
             * 判断指定属性值是否为空值
             * @param et
             * @param index
             * @return
             * @throws Exception
             */
         private static boolean isNull(PSDynaAppViewInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAAPPVIEWINSTID:return et.getPSDynaAppViewInstId()==null;
               case INDEX_PSDYNAAPPVIEWINSTNAME:return et.getPSDynaAppViewInstName()==null;
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId()==null;
               case INDEX_PREDEFINEDVIEWTYPE:return et.getPredefinedViewType()==null;
               case INDEX_INSTVER:return et.getInstVer()==null;
               case INDEX_DYNAMODEL:return et.getDynaModel()==null;
               case INDEX_PDVTPARAM:return et.getPDVTParam()==null;
               case INDEX_PSDYNAAPPVIEWID:return et.getPSDynaAppViewId()==null;
    	       default:
    		     throw new Exception("不明属性标识");
    	    }
    }

    
         /* (non-Javadoc)
          * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
          */
         @Override
    	public boolean contains(String strParamName) throws Exception
    	{
    	 	if(this.getProxyEntity()!=null){
		 		return this.getProxyEntity().contains(strParamName);
		 	}
    	 
            if(StringHelper.isNullOrEmpty(strParamName))
                 throw new Exception("没有指定属性");
    	    Integer index=fieldIndexMap.get(strParamName.toUpperCase());
            if(index==null)
                 return super.contains(strParamName);

    	    return  PSDynaAppViewInstBase.contains(this, index);
    	}

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
         private static boolean contains(PSDynaAppViewInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAAPPVIEWINSTID:return et.isPSDynaAppViewInstIdDirty();
               case INDEX_PSDYNAAPPVIEWINSTNAME:return et.isPSDynaAppViewInstNameDirty();
               case INDEX_PSDYNAINSTID:return et.isPSDynaInstIdDirty();
               case INDEX_PREDEFINEDVIEWTYPE:return et.isPredefinedViewTypeDirty();
               case INDEX_INSTVER:return et.isInstVerDirty();
               case INDEX_DYNAMODEL:return et.isDynaModelDirty();
               case INDEX_PDVTPARAM:return et.isPDVTParamDirty();
               case INDEX_PSDYNAAPPVIEWID:return et.isPSDynaAppViewIdDirty();
    	       default:
    		     throw new Exception("不明属性标识");
    	    }
    }

         /* (non-Javadoc)
          * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
          */
    @Override
      protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception
      {
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
        private static  void fillJSONObject(PSDynaAppViewInstBase et,JSONObject json, boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaAppViewInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynaappviewinstid",getJSONValue(et.getPSDynaAppViewInstId()),false);
        	}
                if(bIncEmpty||et.getPSDynaAppViewInstName()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynaappviewinstname",getJSONValue(et.getPSDynaAppViewInstName()),false);
        	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynainstid",getJSONValue(et.getPSDynaInstId()),false);
        	}
                if(bIncEmpty||et.getPredefinedViewType()!=null)
        	{
                	JSONObjectHelper.put(json,"predefinedviewtype",getJSONValue(et.getPredefinedViewType()),false);
        	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                	JSONObjectHelper.put(json,"instver",getJSONValue(et.getInstVer()),false);
        	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                	JSONObjectHelper.put(json,"dynamodel",getJSONValue(et.getDynaModel()),false);
        	}
                if(bIncEmpty||et.getPDVTParam()!=null)
        	{
                	JSONObjectHelper.put(json,"pdvtparam",getJSONValue(et.getPDVTParam()),false);
        	}
                if(bIncEmpty||et.getPSDynaAppViewId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynaappviewid",getJSONValue(et.getPSDynaAppViewId()),false);
        	}
        }

        /* (non-Javadoc)
         * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
         */
     @Override
      protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception
      {
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
        private static void fillXmlNode(PSDynaAppViewInstBase et,XmlNode node,boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaAppViewInstId()!=null)
        	{
                    Object obj = et.getPSDynaAppViewInstId();
                    node.setAttribute("PSDYNAAPPVIEWINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaAppViewInstName()!=null)
        	{
                    Object obj = et.getPSDynaAppViewInstName();
                    node.setAttribute("PSDYNAAPPVIEWINSTNAME",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                    Object obj = et.getPSDynaInstId();
                    node.setAttribute("PSDYNAINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPredefinedViewType()!=null)
        	{
                    Object obj = et.getPredefinedViewType();
                    node.setAttribute("PREDEFINEDVIEWTYPE",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                    Object obj = et.getInstVer();
                    node.setAttribute("INSTVER",(obj==null)?"":StringHelper.format("%1$s",obj));
         	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                    Object obj = et.getDynaModel();
                    node.setAttribute("DYNAMODEL",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPDVTParam()!=null)
        	{
                    Object obj = et.getPDVTParam();
                    node.setAttribute("PDVTPARAM",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaAppViewId()!=null)
        	{
                    Object obj = et.getPSDynaAppViewId();
                    node.setAttribute("PSDYNAAPPVIEWID",(obj==null)?"":(String)obj);
         	}


        }

        /* (non-Javadoc)
         * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
         */
	    @Override
	   	protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception
	  	{
	          PSDynaAppViewInstBase.copyTo(this,dataEntity,bIncludeEmtpy);
	          super.onCopyTo(dataEntity,bIncludeEmtpy);
	  	}
        
	    /**
         * 复制当前对象数据到目标对象
         * @param et 当前数据对象
         * @param dst 目标数据对象
         * @param bIncEmpty 是否包括空值
         * @throws Exception
         */
        private static void copyTo(PSDynaAppViewInstBase et,IDataObject dst,boolean bIncEmpty) throws Exception
        {
            if(et.isPSDynaAppViewInstIdDirty() && (bIncEmpty||et.getPSDynaAppViewInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNAAPPVIEWINSTID,et.getPSDynaAppViewInstId());
         	}
            if(et.isPSDynaAppViewInstNameDirty() && (bIncEmpty||et.getPSDynaAppViewInstName()!=null))
        	{
        		dst.set(FIELD_PSDYNAAPPVIEWINSTNAME,et.getPSDynaAppViewInstName());
         	}
            if(et.isPSDynaInstIdDirty() && (bIncEmpty||et.getPSDynaInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNAINSTID,et.getPSDynaInstId());
         	}
            if(et.isPredefinedViewTypeDirty() && (bIncEmpty||et.getPredefinedViewType()!=null))
        	{
        		dst.set(FIELD_PREDEFINEDVIEWTYPE,et.getPredefinedViewType());
         	}
            if(et.isInstVerDirty() && (bIncEmpty||et.getInstVer()!=null))
        	{
        		dst.set(FIELD_INSTVER,et.getInstVer());
         	}
            if(et.isDynaModelDirty() && (bIncEmpty||et.getDynaModel()!=null))
        	{
        		dst.set(FIELD_DYNAMODEL,et.getDynaModel());
         	}
            if(et.isPDVTParamDirty() && (bIncEmpty||et.getPDVTParam()!=null))
        	{
        		dst.set(FIELD_PDVTPARAM,et.getPDVTParam());
         	}
            if(et.isPSDynaAppViewIdDirty() && (bIncEmpty||et.getPSDynaAppViewId()!=null))
        	{
        		dst.set(FIELD_PSDYNAAPPVIEWID,et.getPSDynaAppViewId());
         	}
        }
        
        /* (non-Javadoc)
         * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
         */
        @Override
    	public boolean remove(String strParamName) throws Exception
    	{
        	if(this.getProxyEntity()!=null){
		 		return this.getProxyEntity().remove(strParamName);
		 	}
        	
            if(StringHelper.isNullOrEmpty(strParamName))
                 throw new Exception("没有指定属性");
            Integer index=fieldIndexMap.get(strParamName.toUpperCase());
            if(index==null)
                 return super.remove(strParamName);
            return  PSDynaAppViewInstBase.remove(this, index);
    	}
        
        /**
         * 通过属性标识删除属性值
         * @param entity
         * @param index
         * @return
         * @throws Exception
         */
        private static boolean remove(PSDynaAppViewInstBase et,int index) throws Exception
        {
        	switch(index)
        	{
				case INDEX_PSDYNAAPPVIEWINSTID: et.resetPSDynaAppViewInstId();return true;
				case INDEX_PSDYNAAPPVIEWINSTNAME: et.resetPSDynaAppViewInstName();return true;
				case INDEX_PSDYNAINSTID: et.resetPSDynaInstId();return true;
				case INDEX_PREDEFINEDVIEWTYPE: et.resetPredefinedViewType();return true;
				case INDEX_INSTVER: et.resetInstVer();return true;
				case INDEX_DYNAMODEL: et.resetDynaModel();return true;
				case INDEX_PDVTPARAM: et.resetPDVTParam();return true;
				case INDEX_PSDYNAAPPVIEWID: et.resetPSDynaAppViewId();return true;
				default: throw new Exception("不明属性标识");
			}
        }






	/**
	 *  获取代理的数据对象
	 */
	private PSDynaAppViewInstBase getProxyEntity(){return this.proxyPSDynaAppViewInstBase;}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	protected void onProxy(IDataObject proxyDataObject)
	{
		this.proxyPSDynaAppViewInstBase = null;
		if(proxyDataObject!=null && proxyDataObject instanceof PSDynaAppViewInst){
			this.proxyPSDynaAppViewInstBase = (PSDynaAppViewInst)proxyDataObject;
		}
		super.onProxy(proxyDataObject);			
	}

}