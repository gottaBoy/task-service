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
 * 实体[PSDynaWFVer] 数据对象
 */
public abstract class PSDynaWFVerBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

   private static final long serialVersionUID = -1L;
   private static final Log log = LogFactory.getLog(PSDynaWFVerBase.class); 
   /**
    *   实体属性标识[动态工作流版本标识]
    */
   public final static String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
   /**
    *   实体属性标识[动态工作流版本]
    */
   public final static String FIELD_PSDYNAWFVERNAME = "PSDYNAWFVERNAME";
   /**
    *   实体属性标识[动态工作流]
    */
   public final static String FIELD_PSDYNAWFID = "PSDYNAWFID";
   /**
    *   实体属性标识[动态工作流]
    */
   public final static String FIELD_PSDYNAWFNAME = "PSDYNAWFNAME";

   private final static int INDEX_PSDYNAWFVERID = 0;
   private final static int INDEX_PSDYNAWFVERNAME = 1;
   private final static int INDEX_PSDYNAWFID = 2;
   private final static int INDEX_PSDYNAWFNAME = 3;

   private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
   static
   {
       fieldIndexMap.put( FIELD_PSDYNAWFVERID, INDEX_PSDYNAWFVERID);
       fieldIndexMap.put( FIELD_PSDYNAWFVERNAME, INDEX_PSDYNAWFVERNAME);
       fieldIndexMap.put( FIELD_PSDYNAWFID, INDEX_PSDYNAWFID);
       fieldIndexMap.put( FIELD_PSDYNAWFNAME, INDEX_PSDYNAWFNAME);
   }
   
   private PSDynaWFVerBase proxyPSDynaWFVerBase = null;

   public PSDynaWFVerBase(){
        super();
   }
   private boolean psdynawfveridDirtyFlag = false;
   private boolean psdynawfvernameDirtyFlag = false;
   private boolean psdynawfidDirtyFlag = false;
   private boolean psdynawfnameDirtyFlag = false;

    @Column(name="psdynawfverid")
    private String psdynawfverid;
    @Column(name="psdynawfvername")
    private String psdynawfvername;
    @Column(name="psdynawfid")
    private String psdynawfid;
    @Column(name="psdynawfname")
    private String psdynawfname;

   
    /**
     *  设置属性值[动态工作流版本标识]
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
     *  获取属性值[动态工作流版本标识]
     */
    public String getPSDynaWFVerId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFVerId();
    	}
        return this.psdynawfverid;
    }

    /**
     *  获取属性值[动态工作流版本标识]是否修改
     */
    public boolean isPSDynaWFVerIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFVerIdDirty();
    	}
        return this.psdynawfveridDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流版本标识]
     */
    public void resetPSDynaWFVerId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFVerId();
    		 return;
    	}
    	
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }
    /**
     *  设置属性值[动态工作流版本]
     *  @param psdynawfvername
     */
    public void setPSDynaWFVerName(String psdynawfvername){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFVerName(psdynawfvername);
    		return;
    	}
        if(psdynawfvername!=null)
        {
        	psdynawfvername = StringHelper.trimRight(psdynawfvername);
        	if(psdynawfvername.length()==0){
        		psdynawfvername = null;
        	}
        }
        this.psdynawfvername =  psdynawfvername; 
        this.psdynawfvernameDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态工作流版本]
     */
    public String getPSDynaWFVerName(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFVerName();
    	}
        return this.psdynawfvername;
    }

    /**
     *  获取属性值[动态工作流版本]是否修改
     */
    public boolean isPSDynaWFVerNameDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFVerNameDirty();
    	}
        return this.psdynawfvernameDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流版本]
     */
    public void resetPSDynaWFVerName(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFVerName();
    		 return;
    	}
    	
        this.psdynawfvernameDirtyFlag = false;
        this.psdynawfvername = null;
    }
    /**
     *  设置属性值[动态工作流]
     *  @param psdynawfid
     */
    public void setPSDynaWFId(String psdynawfid){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFId(psdynawfid);
    		return;
    	}
        if(psdynawfid!=null)
        {
        	psdynawfid = StringHelper.trimRight(psdynawfid);
        	if(psdynawfid.length()==0){
        		psdynawfid = null;
        	}
        }
        this.psdynawfid =  psdynawfid; 
        this.psdynawfidDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态工作流]
     */
    public String getPSDynaWFId(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFId();
    	}
        return this.psdynawfid;
    }

    /**
     *  获取属性值[动态工作流]是否修改
     */
    public boolean isPSDynaWFIdDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFIdDirty();
    	}
        return this.psdynawfidDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流]
     */
    public void resetPSDynaWFId(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFId();
    		 return;
    	}
    	
        this.psdynawfidDirtyFlag = false;
        this.psdynawfid = null;
    }
    /**
     *  设置属性值[动态工作流]
     *  @param psdynawfname
     */
    public void setPSDynaWFName(String psdynawfname){
    	
    	if(this.getProxyEntity()!=null){
    		this.getProxyEntity().setPSDynaWFName(psdynawfname);
    		return;
    	}
        if(psdynawfname!=null)
        {
        	psdynawfname = StringHelper.trimRight(psdynawfname);
        	if(psdynawfname.length()==0){
        		psdynawfname = null;
        	}
        }
        this.psdynawfname =  psdynawfname; 
        this.psdynawfnameDirtyFlag  = true;
    }
    
    /**
     *  获取属性值[动态工作流]
     */
    public String getPSDynaWFName(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().getPSDynaWFName();
    	}
        return this.psdynawfname;
    }

    /**
     *  获取属性值[动态工作流]是否修改
     */
    public boolean isPSDynaWFNameDirty(){
    	if(this.getProxyEntity()!=null){
    		return this.getProxyEntity().isPSDynaWFNameDirty();
    	}
        return this.psdynawfnameDirtyFlag;
    }

    /**
     *  重置属性值[动态工作流]
     */
    public void resetPSDynaWFName(){
    	
    	if(this.getProxyEntity()!=null){
    		 this.getProxyEntity().resetPSDynaWFName();
    		 return;
    	}
    	
        this.psdynawfnameDirtyFlag = false;
        this.psdynawfname = null;
    }

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.EntityBase#onReset()
	 */
    @Override
    protected void onReset()
    {
       PSDynaWFVerBase.resetAll(this);
       super.onReset();
    }
    
    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(PSDynaWFVerBase et){
        et.resetPSDynaWFVerId();
        et.resetPSDynaWFVerName();
        et.resetPSDynaWFId();
        et.resetPSDynaWFName();
    }

     /* (non-Javadoc)
      * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
      */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly)
    {
        if(!bDirtyOnly || isPSDynaWFVerIdDirty()){
             params.put(FIELD_PSDYNAWFVERID,getPSDynaWFVerId());
        } 
        if(!bDirtyOnly || isPSDynaWFVerNameDirty()){
             params.put(FIELD_PSDYNAWFVERNAME,getPSDynaWFVerName());
        } 
        if(!bDirtyOnly || isPSDynaWFIdDirty()){
             params.put(FIELD_PSDYNAWFID,getPSDynaWFId());
        } 
        if(!bDirtyOnly || isPSDynaWFNameDirty()){
             params.put(FIELD_PSDYNAWFNAME,getPSDynaWFName());
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

                return  PSDynaWFVerBase.get(this, index);
	}
    
    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(PSDynaWFVerBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERID:return et.getPSDynaWFVerId();
               case INDEX_PSDYNAWFVERNAME:return et.getPSDynaWFVerName();
               case INDEX_PSDYNAWFID:return et.getPSDynaWFId();
               case INDEX_PSDYNAWFNAME:return et.getPSDynaWFName();
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
            
            PSDynaWFVerBase.set(this,index,objValue);
 	}

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
            private static void set(PSDynaWFVerBase et,int index,Object obj) throws Exception
         {    
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERID:et.setPSDynaWFVerId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAWFVERNAME:et.setPSDynaWFVerName(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAWFID:et.setPSDynaWFId(DataObject.getStringValue(obj));return ;
               case INDEX_PSDYNAWFNAME:et.setPSDynaWFName(DataObject.getStringValue(obj));return ;
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

    	     return  PSDynaWFVerBase.isNull(this, index);
    	}

            /**
             * 判断指定属性值是否为空值
             * @param et
             * @param index
             * @return
             * @throws Exception
             */
         private static boolean isNull(PSDynaWFVerBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERID:return et.getPSDynaWFVerId()==null;
               case INDEX_PSDYNAWFVERNAME:return et.getPSDynaWFVerName()==null;
               case INDEX_PSDYNAWFID:return et.getPSDynaWFId()==null;
               case INDEX_PSDYNAWFNAME:return et.getPSDynaWFName()==null;
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

    	    return  PSDynaWFVerBase.contains(this, index);
    	}

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
         private static boolean contains(PSDynaWFVerBase et,int index) throws Exception{
             
            switch(index)
    	    {
               case INDEX_PSDYNAWFVERID:return et.isPSDynaWFVerIdDirty();
               case INDEX_PSDYNAWFVERNAME:return et.isPSDynaWFVerNameDirty();
               case INDEX_PSDYNAWFID:return et.isPSDynaWFIdDirty();
               case INDEX_PSDYNAWFNAME:return et.isPSDynaWFNameDirty();
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
        private static  void fillJSONObject(PSDynaWFVerBase et,JSONObject json, boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaWFVerId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfverid",getJSONValue(et.getPSDynaWFVerId()),false);
        	}
                if(bIncEmpty||et.getPSDynaWFVerName()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfvername",getJSONValue(et.getPSDynaWFVerName()),false);
        	}
                if(bIncEmpty||et.getPSDynaWFId()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfid",getJSONValue(et.getPSDynaWFId()),false);
        	}
                if(bIncEmpty||et.getPSDynaWFName()!=null)
        	{
                	JSONObjectHelper.put(json,"psdynawfname",getJSONValue(et.getPSDynaWFName()),false);
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
        private static void fillXmlNode(PSDynaWFVerBase et,XmlNode node,boolean bIncEmpty) throws Exception
        {
                if(bIncEmpty||et.getPSDynaWFVerId()!=null)
        	{
                    Object obj = et.getPSDynaWFVerId();
                    node.setAttribute("PSDYNAWFVERID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaWFVerName()!=null)
        	{
                    Object obj = et.getPSDynaWFVerName();
                    node.setAttribute("PSDYNAWFVERNAME",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaWFId()!=null)
        	{
                    Object obj = et.getPSDynaWFId();
                    node.setAttribute("PSDYNAWFID",(obj==null)?"":(String)obj);
         	}
                if(bIncEmpty||et.getPSDynaWFName()!=null)
        	{
                    Object obj = et.getPSDynaWFName();
                    node.setAttribute("PSDYNAWFNAME",(obj==null)?"":(String)obj);
         	}


        }

        /* (non-Javadoc)
         * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
         */
	    @Override
	   	protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception
	  	{
	          PSDynaWFVerBase.copyTo(this,dataEntity,bIncludeEmtpy);
	          super.onCopyTo(dataEntity,bIncludeEmtpy);
	  	}
        
	    /**
         * 复制当前对象数据到目标对象
         * @param et 当前数据对象
         * @param dst 目标数据对象
         * @param bIncEmpty 是否包括空值
         * @throws Exception
         */
        private static void copyTo(PSDynaWFVerBase et,IDataObject dst,boolean bIncEmpty) throws Exception
        {
            if(et.isPSDynaWFVerIdDirty() && (bIncEmpty||et.getPSDynaWFVerId()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFVERID,et.getPSDynaWFVerId());
         	}
            if(et.isPSDynaWFVerNameDirty() && (bIncEmpty||et.getPSDynaWFVerName()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFVERNAME,et.getPSDynaWFVerName());
         	}
            if(et.isPSDynaWFIdDirty() && (bIncEmpty||et.getPSDynaWFId()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFID,et.getPSDynaWFId());
         	}
            if(et.isPSDynaWFNameDirty() && (bIncEmpty||et.getPSDynaWFName()!=null))
        	{
        		dst.set(FIELD_PSDYNAWFNAME,et.getPSDynaWFName());
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
            return  PSDynaWFVerBase.remove(this, index);
    	}
        
        /**
         * 通过属性标识删除属性值
         * @param entity
         * @param index
         * @return
         * @throws Exception
         */
        private static boolean remove(PSDynaWFVerBase et,int index) throws Exception
        {
        	switch(index)
        	{
				case INDEX_PSDYNAWFVERID: et.resetPSDynaWFVerId();return true;
				case INDEX_PSDYNAWFVERNAME: et.resetPSDynaWFVerName();return true;
				case INDEX_PSDYNAWFID: et.resetPSDynaWFId();return true;
				case INDEX_PSDYNAWFNAME: et.resetPSDynaWFName();return true;
				default: throw new Exception("不明属性标识");
			}
        }






	/**
	 *  获取代理的数据对象
	 */
	private PSDynaWFVerBase getProxyEntity(){return this.proxyPSDynaWFVerBase;}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	protected void onProxy(IDataObject proxyDataObject)
	{
		this.proxyPSDynaWFVerBase = null;
		if(proxyDataObject!=null && proxyDataObject instanceof PSDynaWFVer){
			this.proxyPSDynaWFVerBase = (PSDynaWFVer)proxyDataObject;
		}
		super.onProxy(proxyDataObject);			
	}

}