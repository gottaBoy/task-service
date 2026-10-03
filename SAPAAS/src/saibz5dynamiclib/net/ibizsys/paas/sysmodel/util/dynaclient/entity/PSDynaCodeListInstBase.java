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
 * 实体[PSDynaCodeListInst] 数据对象
 */
public abstract class PSDynaCodeListInstBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

   private static final long serialVersionUID = -1L;
   private static final Log log = LogFactory.getLog(PSDynaCodeListInstBase.class); 
   /**
    *   实体属性标识[动态代码表实例标识]
    */
   public final static String FIELD_PSDYNACODELISTINSTID = "PSDYNACODELISTINSTID";
   /**
    *   实体属性标识[动态代码表实例名称]
    */
   public final static String FIELD_PSDYNACODELISTINSTNAME = "PSDYNACODELISTINSTNAME";
   /**
    *   实体属性标识[动态模型]
    */
   public final static String FIELD_DYNAMODEL = "DYNAMODEL";
   /**
    *   实体属性标识[动态实例]
    */
   public final static String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
   /**
    *   实体属性标识[实例版本]
    */
   public final static String FIELD_INSTVER = "INSTVER";
   /**
    *   实体属性标识[动态代码表]
    */
   public final static String FIELD_PSDYNACODELISTID = "PSDYNACODELISTID";

   private final static int INDEX_PSDYNACODELISTINSTID = 0;
   private final static int INDEX_PSDYNACODELISTINSTNAME = 1;
   private final static int INDEX_DYNAMODEL = 2;
   private final static int INDEX_PSDYNAINSTID = 3;
   private final static int INDEX_INSTVER = 4;
   private final static int INDEX_PSDYNACODELISTID = 5;

   private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
   static
   {
       fieldIndexMap.put( FIELD_PSDYNACODELISTINSTID, INDEX_PSDYNACODELISTINSTID);
       fieldIndexMap.put( FIELD_PSDYNACODELISTINSTNAME, INDEX_PSDYNACODELISTINSTNAME);
       fieldIndexMap.put( FIELD_DYNAMODEL, INDEX_DYNAMODEL);
       fieldIndexMap.put( FIELD_PSDYNAINSTID, INDEX_PSDYNAINSTID);
       fieldIndexMap.put( FIELD_INSTVER, INDEX_INSTVER);
       fieldIndexMap.put( FIELD_PSDYNACODELISTID, INDEX_PSDYNACODELISTID);
   }
   
   private PSDynaCodeListInstBase proxyPSDynaCodeListInstBase = null;

   public PSDynaCodeListInstBase(){
        super();
   }
   private boolean psdynacodelistinstidDirtyFlag = false;
   private boolean psdynacodelistinstnameDirtyFlag = false;
   private boolean dynamodelDirtyFlag = false;
   private boolean psdynainstidDirtyFlag = false;
   private boolean instverDirtyFlag = false;
   private boolean psdynacodelistidDirtyFlag = false;

    @Column(name="psdynacodelistinstid")
    private String psdynacodelistinstid;
    @Column(name="psdynacodelistinstname")
    private String psdynacodelistinstname;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="instver")
    private Integer instver;
    @Column(name="psdynacodelistid")
    private String psdynacodelistid;

   
    /**
     *  设置属性值[动态代码表实例标识]
     *  @param psdynacodelistinstid
     */
    public void setPSDynaCodeListInstId(String psdynacodelistinstid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaCodeListInstId(psdynacodelistinstid);
    		return;
    	}
        if(psdynacodelistinstid!=null)
        {
        	psdynacodelistinstid = StringHelper.trimRight(psdynacodelistinstid);
        	if(psdynacodelistinstid.length()==0){
        		psdynacodelistinstid = null;
        	}
        }
        this.psdynacodelistinstid =  psdynacodelistinstid; 
        this.psdynacodelistinstidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态代码表实例标识]
     */
    public String getPSDynaCodeListInstId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaCodeListInstId();
    	}
        return this.psdynacodelistinstid;
    }

    /**
     *  获取属性值[动态代码表实例标识]是否修改
     */
    public boolean isPSDynaCodeListInstIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaCodeListInstIdDirty();
    	}
        return this.psdynacodelistinstidDirtyFlag;
    }

    /**
     *  重置属性值[动态代码表实例标识]
     */
    public void resetPSDynaCodeListInstId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaCodeListInstId();
    		 return;
    	}
    	
        this.psdynacodelistinstidDirtyFlag = false;
        this.psdynacodelistinstid = null;
    }
    /**
     *  设置属性值[动态代码表实例名称]
     *  @param psdynacodelistinstname
     */
    public void setPSDynaCodeListInstName(String psdynacodelistinstname){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaCodeListInstName(psdynacodelistinstname);
    		return;
    	}
        if(psdynacodelistinstname!=null)
        {
        	psdynacodelistinstname = StringHelper.trimRight(psdynacodelistinstname);
        	if(psdynacodelistinstname.length()==0){
        		psdynacodelistinstname = null;
        	}
        }
        this.psdynacodelistinstname =  psdynacodelistinstname; 
        this.psdynacodelistinstnameDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态代码表实例名称]
     */
    public String getPSDynaCodeListInstName(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaCodeListInstName();
    	}
        return this.psdynacodelistinstname;
    }

    /**
     *  获取属性值[动态代码表实例名称]是否修改
     */
    public boolean isPSDynaCodeListInstNameDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaCodeListInstNameDirty();
    	}
        return this.psdynacodelistinstnameDirtyFlag;
    }

    /**
     *  重置属性值[动态代码表实例名称]
     */
    public void resetPSDynaCodeListInstName(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaCodeListInstName();
    		 return;
    	}
    	
        this.psdynacodelistinstnameDirtyFlag = false;
        this.psdynacodelistinstname = null;
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
     *  设置属性值[动态代码表]
     *  @param psdynacodelistid
     */
    public void setPSDynaCodeListId(String psdynacodelistid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaCodeListId(psdynacodelistid);
    		return;
    	}
        if(psdynacodelistid!=null)
        {
        	psdynacodelistid = StringHelper.trimRight(psdynacodelistid);
        	if(psdynacodelistid.length()==0){
        		psdynacodelistid = null;
        	}
        }
        this.psdynacodelistid =  psdynacodelistid; 
        this.psdynacodelistidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态代码表]
     */
    public String getPSDynaCodeListId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaCodeListId();
    	}
        return this.psdynacodelistid;
    }

    /**
     *  获取属性值[动态代码表]是否修改
     */
    public boolean isPSDynaCodeListIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaCodeListIdDirty();
    	}
        return this.psdynacodelistidDirtyFlag;
    }

    /**
     *  重置属性值[动态代码表]
     */
    public void resetPSDynaCodeListId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaCodeListId();
    		 return;
    	}
    	
        this.psdynacodelistidDirtyFlag = false;
        this.psdynacodelistid = null;
    }

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.EntityBase#onReset()
	 */
    @Override
    protected void onReset()
    {
       PSDynaCodeListInstBase.resetAll(this);
       super.onReset();
    }
    
    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PSDynaCodeListInstBase et){
        et.resetPSDynaCodeListInstId();
        et.resetPSDynaCodeListInstName();
        et.resetDynaModel();
        et.resetPSDynaInstId();
        et.resetInstVer();
        et.resetPSDynaCodeListId();
    }

     /* (non-Javadoc)
      * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
      */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly)
    {
        if(!bDirtyOnly || isPSDynaCodeListInstIdDirty()){
             params.put(FIELD_PSDYNACODELISTINSTID,getPSDynaCodeListInstId());
        } 
        if(!bDirtyOnly || isPSDynaCodeListInstNameDirty()){
             params.put(FIELD_PSDYNACODELISTINSTNAME,getPSDynaCodeListInstName());
        } 
        if(!bDirtyOnly || isDynaModelDirty()){
             params.put(FIELD_DYNAMODEL,getDynaModel());
        } 
        if(!bDirtyOnly || isPSDynaInstIdDirty()){
             params.put(FIELD_PSDYNAINSTID,getPSDynaInstId());
        } 
        if(!bDirtyOnly || isInstVerDirty()){
             params.put(FIELD_INSTVER,getInstVer());
        } 
        if(!bDirtyOnly || isPSDynaCodeListIdDirty()){
             params.put(FIELD_PSDYNACODELISTID,getPSDynaCodeListId());
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

                return  PSDynaCodeListInstBase.get(this, index);
	}
    
    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PSDynaCodeListInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNACODELISTINSTID:return et.getPSDynaCodeListInstId();
               case INDEX_PSDYNACODELISTINSTNAME:return et.getPSDynaCodeListInstName();
               case INDEX_DYNAMODEL:return et.getDynaModel();
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId();
               case INDEX_INSTVER:return et.getInstVer();
               case INDEX_PSDYNACODELISTID:return et.getPSDynaCodeListId();
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
            
            PSDynaCodeListInstBase.set(this,index,objValue);
 	}

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
            private static void set(PSDynaCodeListInstBase et,int index,Object obj) throws Exception
         {    
            switch(index)
    	    {
               case INDEX_PSDYNACODELISTINSTID:et.setPSDynaCodeListInstId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNACODELISTINSTNAME:et.setPSDynaCodeListInstName(DataObject.getStringValue(obj));return ;
               case INDEX_DYNAMODEL:et.setDynaModel(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAINSTID:et.setPSDynaInstId(DataObject.getStringValue(obj));return ;
               case INDEX_INSTVER:et.setInstVer(DataObject.getIntegerValue(obj));return ;
               case INDEX_PSDYNACODELISTID:et.setPSDynaCodeListId(DataObject.getStringValue(obj));return ;
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

    	     return  PSDynaCodeListInstBase.isNull(this, index);
    	}

            /**
             * 判断指定属性值是否为空值
             * @param et
             * @param index
             * @return
             * @throws Exception
             */
         private static boolean isNull(PSDynaCodeListInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNACODELISTINSTID:return et.getPSDynaCodeListInstId()==null;
               case INDEX_PSDYNACODELISTINSTNAME:return et.getPSDynaCodeListInstName()==null;
               case INDEX_DYNAMODEL:return et.getDynaModel()==null;
               case INDEX_PSDYNAINSTID:return et.getPSDynaInstId()==null;
               case INDEX_INSTVER:return et.getInstVer()==null;
               case INDEX_PSDYNACODELISTID:return et.getPSDynaCodeListId()==null;
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

    	    return  PSDynaCodeListInstBase.contains(this, index);
    	}

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
         private static boolean contains(PSDynaCodeListInstBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNACODELISTINSTID:return et.isPSDynaCodeListInstIdDirty();
               case INDEX_PSDYNACODELISTINSTNAME:return et.isPSDynaCodeListInstNameDirty();
               case INDEX_DYNAMODEL:return et.isDynaModelDirty();
               case INDEX_PSDYNAINSTID:return et.isPSDynaInstIdDirty();
               case INDEX_INSTVER:return et.isInstVerDirty();
               case INDEX_PSDYNACODELISTID:return et.isPSDynaCodeListIdDirty();
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
        private static  void fillJSONObject(PSDynaCodeListInstBase et,JSONObject json, boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaCodeListInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynacodelistinstid",getJSONValue(et.getPSDynaCodeListInstId()),false);
        	}
                if(bIncEmpty||et.getPSDynaCodeListInstName()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynacodelistinstname",getJSONValue(et.getPSDynaCodeListInstName()),false);
        	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                	JSONObjectHelper.put(json,"dynamodel",getJSONValue(et.getDynaModel()),false);
        	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynainstid",getJSONValue(et.getPSDynaInstId()),false);
        	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                	JSONObjectHelper.put(json,"instver",getJSONValue(et.getInstVer()),false);
        	}
                if(bIncEmpty||et.getPSDynaCodeListId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynacodelistid",getJSONValue(et.getPSDynaCodeListId()),false);
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
        private static void fillXmlNode(PSDynaCodeListInstBase et,XmlNode node,boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaCodeListInstId()!=null)
        	{
                    Object obj = et.getPSDynaCodeListInstId();
                    node.setAttribute("PSDYNACODELISTINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaCodeListInstName()!=null)
        	{
                    Object obj = et.getPSDynaCodeListInstName();
                    node.setAttribute("PSDYNACODELISTINSTNAME",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getDynaModel()!=null)
        	{
                    Object obj = et.getDynaModel();
                    node.setAttribute("DYNAMODEL",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaInstId()!=null)
        	{
                    Object obj = et.getPSDynaInstId();
                    node.setAttribute("PSDYNAINSTID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getInstVer()!=null)
        	{
                    Object obj = et.getInstVer();
                    node.setAttribute("INSTVER",(obj==null)?"":StringHelper.format("%1$s",obj));
         	}
                if(bIncEmpty||et.getPSDynaCodeListId()!=null)
        	{
                    Object obj = et.getPSDynaCodeListId();
                    node.setAttribute("PSDYNACODELISTID",(obj==null)?"":(String)obj);
         	}


        }

        /* (non-Javadoc)
         * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
         */
	    @Override
	   	protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception
	  	{
	          PSDynaCodeListInstBase.copyTo(this,dataEntity,bIncludeEmtpy);
	          super.onCopyTo(dataEntity,bIncludeEmtpy);
	  	}
        
	    /**
         * 复制当前对象数据到目标对象
         * @param et 当前数据对象
         * @param dst 目标数据对象
         * @param bIncEmpty 是否包括空值
         * @throws Exception
         */
        private static void copyTo(PSDynaCodeListInstBase et,IDataObject dst,boolean bIncEmpty) throws Exception
        {
            if(et.isPSDynaCodeListInstIdDirty() && (bIncEmpty||et.getPSDynaCodeListInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNACODELISTINSTID,et.getPSDynaCodeListInstId());
         	}
            if(et.isPSDynaCodeListInstNameDirty() && (bIncEmpty||et.getPSDynaCodeListInstName()!=null))
        	{
        		dst.set(FIELD_PSDYNACODELISTINSTNAME,et.getPSDynaCodeListInstName());
         	}
            if(et.isDynaModelDirty() && (bIncEmpty||et.getDynaModel()!=null))
        	{
        		dst.set(FIELD_DYNAMODEL,et.getDynaModel());
         	}
            if(et.isPSDynaInstIdDirty() && (bIncEmpty||et.getPSDynaInstId()!=null))
        	{
        		dst.set(FIELD_PSDYNAINSTID,et.getPSDynaInstId());
         	}
            if(et.isInstVerDirty() && (bIncEmpty||et.getInstVer()!=null))
        	{
        		dst.set(FIELD_INSTVER,et.getInstVer());
         	}
            if(et.isPSDynaCodeListIdDirty() && (bIncEmpty||et.getPSDynaCodeListId()!=null))
        	{
        		dst.set(FIELD_PSDYNACODELISTID,et.getPSDynaCodeListId());
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
            return  PSDynaCodeListInstBase.remove(this, index);
    	}
        
        /**
         * 通过属性标识删除属性值
         * @param entity
         * @param index
         * @return
         * @throws Exception
         */
        private static boolean remove(PSDynaCodeListInstBase et,int index) throws Exception
        {
        	switch(index)
        	{
				case INDEX_PSDYNACODELISTINSTID: et.resetPSDynaCodeListInstId();return true;
				case INDEX_PSDYNACODELISTINSTNAME: et.resetPSDynaCodeListInstName();return true;
				case INDEX_DYNAMODEL: et.resetDynaModel();return true;
				case INDEX_PSDYNAINSTID: et.resetPSDynaInstId();return true;
				case INDEX_INSTVER: et.resetInstVer();return true;
				case INDEX_PSDYNACODELISTID: et.resetPSDynaCodeListId();return true;
				default: throw new Exception("不明属性标识");
			}
        }






	/**
	 *  获取代理的数据对象
	 */
	private PSDynaCodeListInstBase getProxyEntity(){return this.proxyPSDynaCodeListInstBase;}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	protected void onProxy(IDataObject proxyDataObject)
	{
		this.proxyPSDynaCodeListInstBase = null;
		if(proxyDataObject!=null && proxyDataObject instanceof PSDynaCodeListInst){
			this.proxyPSDynaCodeListInstBase = (PSDynaCodeListInst)proxyDataObject;
		}
		super.onProxy(proxyDataObject);			
	}

}