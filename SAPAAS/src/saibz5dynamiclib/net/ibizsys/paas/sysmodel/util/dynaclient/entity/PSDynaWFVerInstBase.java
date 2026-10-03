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
 * 实体[PSDynaWFVerInst] 数据对象
 */
public abstract class PSDynaWFVerInstBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

   private static final long serialVersionUID = -1L;
   private static final Log log = LogFactory.getLog(PSDynaWFVerInstBase.class); 
   /**
    *   实体属性标识[动态流程版本实例标识]
    */
   public final static String FIELD_PSDYNAWFVERINSTID = "PSDYNAWFVERINSTID";
   /**
    *   实体属性标识[流程版本实例名称]
    */
   public final static String FIELD_PSDYNAWFVERINSTNAME = "PSDYNAWFVERINSTNAME";
   /**
    *   实体属性标识[版本号]
    */
   public final static String FIELD_WFVERSION = "WFVERSION";
   /**
    *   实体属性标识[动态模型]
    */
   public final static String FIELD_DYNAMODEL = "DYNAMODEL";
   /**
    *   实体属性标识[实例版本]
    */
   public final static String FIELD_INSTVER = "INSTVER";
   /**
    *   实体属性标识[动态实例]
    */
   public final static String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
   /**
    *   实体属性标识[动态工作流版本]
    */
   public final static String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";

   private final static int INDEX_PSDYNAWFVERINSTID = 0;
   private final static int INDEX_PSDYNAWFVERINSTNAME = 1;
   private final static int INDEX_WFVERSION = 2;
   private final static int INDEX_DYNAMODEL = 3;
   private final static int INDEX_INSTVER = 4;
   private final static int INDEX_PSDYNAINSTID = 5;
   private final static int INDEX_PSDYNAWFVERID = 6;

   private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
   static
   {
       fieldIndexMap.put( FIELD_PSDYNAWFVERINSTID, INDEX_PSDYNAWFVERINSTID);
       fieldIndexMap.put( FIELD_PSDYNAWFVERINSTNAME, INDEX_PSDYNAWFVERINSTNAME);
       fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
       fieldIndexMap.put( FIELD_DYNAMODEL, INDEX_DYNAMODEL);
       fieldIndexMap.put( FIELD_INSTVER, INDEX_INSTVER);
       fieldIndexMap.put( FIELD_PSDYNAINSTID, INDEX_PSDYNAINSTID);
       fieldIndexMap.put( FIELD_PSDYNAWFVERID, INDEX_PSDYNAWFVERID);
   }
   
   private PSDynaWFVerInstBase proxyPSDynaWFVerInstBase = null;

   public PSDynaWFVerInstBase(){
        super();
   }
   private boolean psdynawfverinstidDirtyFlag = false;
   private boolean psdynawfverinstnameDirtyFlag = false;
   private boolean wfversionDirtyFlag = false;
   private boolean dynamodelDirtyFlag = false;
   private boolean instverDirtyFlag = false;
   private boolean psdynainstidDirtyFlag = false;
   private boolean psdynawfveridDirtyFlag = false;

    @Column(name="psdynawfverinstid")
    private String psdynawfverinstid;
    @Column(name="psdynawfverinstname")
    private String psdynawfverinstname;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="instver")
    private Integer instver;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynawfverid")
    private String psdynawfverid;

   
    /**
     *  设置属性值[动态流程版本实例标识]
     *  @param psdynawfverinstid
     */
    public void setPSDynaWFVerInstId(String psdynawfverinstid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFVerInstId(psdynawfverinstid);
    		return;
    	}
        if(psdynawfverinstid!=null)
        {
        	psdynawfverinstid = StringHelper.trimRight(psdynawfverinstid);
        	if(psdynawfverinstid.length()==0){
        		psdynawfverinstid = null;
        	}
        }
        this.psdynawfverinstid =  psdynawfverinstid; 
        this.psdynawfverinstidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态流程版本实例标识]
     */
    public String getPSDynaWFVerInstId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFVerInstId();
    	}
        return this.psdynawfverinstid;
    }

    /**
     *  获取属性值[动态流程版本实例标识]是否修改
     */
    public boolean isPSDynaWFVerInstIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFVerInstIdDirty();
    	}
        return this.psdynawfverinstidDirtyFlag;
    }

    /**
     *  重置属性值[动态流程版本实例标识]
     */
    public void resetPSDynaWFVerInstId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFVerInstId();
    		 return;
    	}
    	
        this.psdynawfverinstidDirtyFlag = false;
        this.psdynawfverinstid = null;
    }
    /**
     *  设置属性值[流程版本实例名称]
     *  @param psdynawfverinstname
     */
    public void setPSDynaWFVerInstName(String psdynawfverinstname){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFVerInstName(psdynawfverinstname);
    		return;
    	}
        if(psdynawfverinstname!=null)
        {
        	psdynawfverinstname = StringHelper.trimRight(psdynawfverinstname);
        	if(psdynawfverinstname.length()==0){
        		psdynawfverinstname = null;
        	}
        }
        this.psdynawfverinstname =  psdynawfverinstname; 
        this.psdynawfverinstnameDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[流程版本实例名称]
     */
    public String getPSDynaWFVerInstName(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFVerInstName();
    	}
        return this.psdynawfverinstname;
    }

    /**
     *  获取属性值[流程版本实例名称]是否修改
     */
    public boolean isPSDynaWFVerInstNameDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFVerInstNameDirty();
    	}
        return this.psdynawfverinstnameDirtyFlag;
    }

    /**
     *  重置属性值[流程版本实例名称]
     */
    public void resetPSDynaWFVerInstName(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFVerInstName();
    		 return;
    	}
    	
        this.psdynawfverinstnameDirtyFlag = false;
        this.psdynawfverinstname = null;
    }
    /**
     *  设置属性值[版本号]
     *  @param wfversion
     */
    public void setWFVersion(Integer wfversion){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setWFVersion(wfversion);
    		return;
    	}
        this.wfversion =  wfversion; 
        this.wfversionDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[版本号]
     */
    public Integer getWFVersion(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getWFVersion();
    	}
        return this.wfversion;
    }

    /**
     *  获取属性值[版本号]是否修改
     */
    public boolean isWFVersionDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isWFVersionDirty();
    	}
        return this.wfversionDirtyFlag;
    }

    /**
     *  重置属性值[版本号]
     */
    public void resetWFVersion(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetWFVersion();
    		 return;
    	}
    	
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
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
     *  设置属性值[动态实例]
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
     *  获取属性值[动态实例]
     */
    public String getPSDynaInstId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaInstId();
    	}
        return this.psdynainstid;
    }

    /**
     *  获取属性值[动态实例]是否修改
     */
    public boolean isPSDynaInstIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaInstIdDirty();
    	}
        return this.psdynainstidDirtyFlag;
    }

    /**
     *  重置属性值[动态实例]
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
     *  设置属性值[动态工作流版本]
     *  @param psdynawfverid
     */
    public void setPSDynaWFVerId(String psdynawfverid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFVerId(psdynawfverid);
    		return;
    	}
        if(psdynawfverid!=null)
        {
        	psdynawfverid = StringHelper.trimRight(psdynawfverid);
        	if(psdynawfverid.length()==0){
        		psdynawfverid = null;
        	}
        }
        this.psdynawfverid =  psdynawfverid; 
        this.psdynawfveridDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态工作流版本]
     */
    public String getPSDynaWFVerId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFVerId();
    	}
        return this.psdynawfverid;
    }

    /**
     *  获取属性值[动态工作流版本]是否修改
     */
    public boolean isPSDynaWFVerIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFVerIdDirty();
    	}
        return this.psdynawfveridDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流版本]
     */
    public void resetPSDynaWFVerId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFVerId();
    		 return;
    	}
    	
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.EntityBase#onReset()
	 */
    @Override
    protected void onReset()
    {
       PSDynaWFVerInstBase.resetAll(this);
       super.onReset();
    }
    
    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PSDynaWFVerInstBase et){
        et.resetPSDynaWFVerInstId();
        et.resetPSDynaWFVerInstName();
        et.resetWFVersion();
        et.resetDynaModel();
        et.resetInstVer();
        et.resetPSDynaInstId();
        et.resetPSDynaWFVerId();
    }

     /* (non-Javadoc)
      * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
      */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly)
    {
        if(!bDirtyOnly || isPSDynaWFVerInstIdDirty()){
             params.put(FIELD_PSDYNAWFVERINSTID,getPSDynaWFVerInstId());
        } 
        if(!bDirtyOnly || isPSDynaWFVerInstNameDirty()){
             params.put(FIELD_PSDYNAWFVERINSTNAME,getPSDynaWFVerInstName());
        } 
        if(!bDirtyOnly || isWFVersionDirty()){
             params.put(FIELD_WFVERSION,getWFVersion());
        } 
        if(!bDirtyOnly || isDynaModelDirty()){
             params.put(FIELD_DYNAMODEL,getDynaModel());
        } 
        if(!bDirtyOnly || isInstVerDirty()){
             params.put(FIELD_INSTVER,getInstVer());
        } 
        if(!bDirtyOnly || isPSDynaInstIdDirty()){
             params.put(FIELD_PSDYNAINSTID,getPSDynaInstId());
        } 
        if(!bDirtyOnly || isPSDynaWFVerIdDirty()){
             params.put(FIELD_PSDYNAWFVERID,getPSDynaWFVerId());
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

                return  PSDynaWFVerInstBase.get(this, index);
	}
    
    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PSDynaWFVerInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERINSTID:return et.getPSDynaWFVerInstId();
               case INDEX_PSDYNAWFVERINSTNAME:return et.getPSDynaWFVerInstName();
               case INDEX_WFVERSION:return et.getWFVersion();
               case INDEX_DYNAMODEL:return et.getDynaModel();
               case INDEX_INSTVER:return et.getInstVer();
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId();
               case INDEX_PSDYNAWFVERID:return et.getPSDynaWFVerId();
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
            
            PSDynaWFVerInstBase.set(this,index,objValue);
 	}

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
            private static void set(PSDynaWFVerInstBase et,int index,Object obj) throws Exception
         {    
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERINSTID:et.setPSDynaWFVerInstId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAWFVERINSTNAME:et.setPSDynaWFVerInstName(DataObject.getStringValue(obj));return ;
               case INDEX_WFVERSION:et.setWFVersion(DataObject.getIntegerValue(obj));return ;
               case INDEX_DYNAMODEL:et.setDynaModel(DataObject.getStringValue(obj));return ;
               case INDEX_INSTVER:et.setInstVer(DataObject.getIntegerValue(obj));return ;
               case INDEX_PSDYNAINSTID:et.setPSDynaInstId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAWFVERID:et.setPSDynaWFVerId(DataObject.getStringValue(obj));return ;
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

    	     return  PSDynaWFVerInstBase.isNull(this, index);
    	}

            /**
             * 判断指定属性值是否为空值
             * @param et
             * @param index
             * @return
             * @throws Exception
             */
         private static boolean isNull(PSDynaWFVerInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERINSTID:return et.getPSDynaWFVerInstId()==null;
               case INDEX_PSDYNAWFVERINSTNAME:return et.getPSDynaWFVerInstName()==null;
               case INDEX_WFVERSION:return et.getWFVersion()==null;
               case INDEX_DYNAMODEL:return et.getDynaModel()==null;
               case INDEX_INSTVER:return et.getInstVer()==null;
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId()==null;
               case INDEX_PSDYNAWFVERID:return et.getPSDynaWFVerId()==null;
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

    	    return  PSDynaWFVerInstBase.contains(this, index);
    	}

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
         private static boolean contains(PSDynaWFVerInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERINSTID:return et.isPSDynaWFVerInstIdDirty();
               case INDEX_PSDYNAWFVERINSTNAME:return et.isPSDynaWFVerInstNameDirty();
               case INDEX_WFVERSION:return et.isWFVersionDirty();
               case INDEX_DYNAMODEL:return et.isDynaModelDirty();
               case INDEX_INSTVER:return et.isInstVerDirty();
               case INDEX_PSDYNAINSTID:return et.isPSDynaInstIdDirty();
               case INDEX_PSDYNAWFVERID:return et.isPSDynaWFVerIdDirty();
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
        private static  void fillJSONObject(PSDynaWFVerInstBase et,JSONObject json, boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaWFVerInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfverinstid",getJSONValue(et.getPSDynaWFVerInstId()),false);
        	}
                if(bIncEmpty||et.getPSDynaWFVerInstName()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfverinstname",getJSONValue(et.getPSDynaWFVerInstName()),false);
        	}
                if(bIncEmpty||et.getWFVersion()!=null)
        	{
                	JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
        	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                	JSONObjectHelper.put(json,"dynamodel",getJSONValue(et.getDynaModel()),false);
        	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                	JSONObjectHelper.put(json,"instver",getJSONValue(et.getInstVer()),false);
        	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynainstid",getJSONValue(et.getPSDynaInstId()),false);
        	}
                if(bIncEmpty||et.getPSDynaWFVerId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfverid",getJSONValue(et.getPSDynaWFVerId()),false);
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
        private static void fillXmlNode(PSDynaWFVerInstBase et,XmlNode node,boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaWFVerInstId()!=null)
        	{
                    Object obj = et.getPSDynaWFVerInstId();
                    node.setAttribute("PSDYNAWFVERINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaWFVerInstName()!=null)
        	{
                    Object obj = et.getPSDynaWFVerInstName();
                    node.setAttribute("PSDYNAWFVERINSTNAME",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getWFVersion()!=null)
        	{
                    Object obj = et.getWFVersion();
                    node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
         	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                    Object obj = et.getDynaModel();
                    node.setAttribute("DYNAMODEL",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                    Object obj = et.getInstVer();
                    node.setAttribute("INSTVER",(obj==null)?"":StringHelper.format("%1$s",obj));
         	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                    Object obj = et.getPSDynaInstId();
                    node.setAttribute("PSDYNAINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaWFVerId()!=null)
        	{
                    Object obj = et.getPSDynaWFVerId();
                    node.setAttribute("PSDYNAWFVERID",(obj==null)?"":(String)obj);
         	}


        }

        /* (non-Javadoc)
         * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
         */
	    @Override
	   	protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception
	  	{
	          PSDynaWFVerInstBase.copyTo(this,dataEntity,bIncludeEmtpy);
	          super.onCopyTo(dataEntity,bIncludeEmtpy);
	  	}
        
	    /**
         * 复制当前对象数据到目标对象
         * @param et 当前数据对象
         * @param dst 目标数据对象
         * @param bIncEmpty 是否包括空值
         * @throws Exception
         */
        private static void copyTo(PSDynaWFVerInstBase et,IDataObject dst,boolean bIncEmpty) throws Exception
        {
            if(et.isPSDynaWFVerInstIdDirty() && (bIncEmpty||et.getPSDynaWFVerInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFVERINSTID,et.getPSDynaWFVerInstId());
         	}
            if(et.isPSDynaWFVerInstNameDirty() && (bIncEmpty||et.getPSDynaWFVerInstName()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFVERINSTNAME,et.getPSDynaWFVerInstName());
         	}
            if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null))
        	{
        		dst.set(FIELD_WFVERSION,et.getWFVersion());
         	}
            if(et.isDynaModelDirty() && (bIncEmpty||et.getDynaModel()!=null))
        	{
        		dst.set(FIELD_DYNAMODEL,et.getDynaModel());
         	}
            if(et.isInstVerDirty() && (bIncEmpty||et.getInstVer()!=null))
        	{
        		dst.set(FIELD_INSTVER,et.getInstVer());
         	}
            if(et.isPSDynaInstIdDirty() && (bIncEmpty||et.getPSDynaInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNAINSTID,et.getPSDynaInstId());
         	}
            if(et.isPSDynaWFVerIdDirty() && (bIncEmpty||et.getPSDynaWFVerId()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFVERID,et.getPSDynaWFVerId());
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
            return  PSDynaWFVerInstBase.remove(this, index);
    	}
        
        /**
         * 通过属性标识删除属性值
         * @param entity
         * @param index
         * @return
         * @throws Exception
         */
        private static boolean remove(PSDynaWFVerInstBase et,int index) throws Exception
        {
        	switch(index)
        	{
				case INDEX_PSDYNAWFVERINSTID: et.resetPSDynaWFVerInstId();return true;
				case INDEX_PSDYNAWFVERINSTNAME: et.resetPSDynaWFVerInstName();return true;
				case INDEX_WFVERSION: et.resetWFVersion();return true;
				case INDEX_DYNAMODEL: et.resetDynaModel();return true;
				case INDEX_INSTVER: et.resetInstVer();return true;
				case INDEX_PSDYNAINSTID: et.resetPSDynaInstId();return true;
				case INDEX_PSDYNAWFVERID: et.resetPSDynaWFVerId();return true;
				default: throw new Exception("不明属性标识");
			}
        }






	/**
	 *  获取代理的数据对象
	 */
	private PSDynaWFVerInstBase getProxyEntity(){return this.proxyPSDynaWFVerInstBase;}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	protected void onProxy(IDataObject proxyDataObject)
	{
		this.proxyPSDynaWFVerInstBase = null;
		if(proxyDataObject!=null && proxyDataObject instanceof PSDynaWFVerInst){
			this.proxyPSDynaWFVerInstBase = (PSDynaWFVerInst)proxyDataObject;
		}
		super.onProxy(proxyDataObject);			
	}

}