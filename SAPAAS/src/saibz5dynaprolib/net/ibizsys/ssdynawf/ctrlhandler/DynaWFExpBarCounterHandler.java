package net.ibizsys.ssdynawf.ctrlhandler;

import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCounterHandler;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.pswf.ctrlhandler.WFExpBarCounterHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JIT工作流导航栏计数器处理对象
 * @author Administrator
 *
 */
public class DynaWFExpBarCounterHandler extends WFExpBarCounterHandler implements IDynaCounterHandler {

	
	private static final Log log = LogFactory.getLog(DynaWFExpBarCounterHandler.class);
	private IDynaSysModel iDynaSysModel = null;
	private IPSSysCounter iPSSysCounter = null;
	
	@Override
	public void init(IDynaSysModel iDynaSysModel , IPSSysCounter iPSSysCounter) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
		this.iPSSysCounter = iPSSysCounter;
		  this.setId(this.iPSSysCounter.getId());
        this.setName(this.iPSSysCounter.getName());
        
        //注册计数器
       // CounterGlobal.registerCounterHandler(this.getId(), this);
		this.onInit();
	}
	
	/**
	 * 获取系统计数器
	 * @return
	 */
	public IPSSysCounter getPSSysCounter(){
		return this.iPSSysCounter;
	}
	
	public IDynaSysModel getSystemModel(){
		return this.iDynaSysModel;
	}
	
	
	   

	 
}
