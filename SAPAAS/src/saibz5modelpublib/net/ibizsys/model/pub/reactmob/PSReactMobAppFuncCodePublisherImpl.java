package net.ibizsys.model.pub.reactmob;

import org.hibernate.annotations.common.util.StringHelper;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

public class PSReactMobAppFuncCodePublisherImpl extends PSReactMobAppCodePublisherImpl
{
	@Override
	protected void onGenerateCode() throws Exception
	{
		java.util.Iterator<IPSAppFunc> psAppFuncs = this.iPSApplication.getAllPSAppFuncs();
		while(psAppFuncs.hasNext()){
			IPSAppFunc iPSAppFunc = psAppFuncs.next();
			
			if(StringHelper.isNotEmpty(iPSAppFunc.getCodeName())&& iPSAppFunc.getCodeName()==null){
				continue;
			}
			//手动添加以及目录
			this.onGenerateCode(iPSAppFunc,iPSAppFunc.getCodeName().toLowerCase()+"/"+iPSAppFunc.getCodeName().toLowerCase());
			
		}
	}
	
	
	/**
	 * 产生代码
	 * @param iPSPublisherContext
	 * @param iPSApplication
	 * @param iPSAppFunc
	 * @throws Exception
	 */
	public void generateCode(IPSPublisherContext iPSPublisherContext, IPSApplication iPSApplication,IPSAppFunc iPSAppFunc) throws Exception
	{
		this.iPSPublisherContext = iPSPublisherContext;
		this.iPSApplication = iPSApplication;
		this.iPSPF = this.iPSApplication.getPSPF();// this.getPSModelStorage().getPSPF(this.iPSApplication.getPFType());
		this.iPSPFStyle  = this.iPSApplication.getPSPFStyle();//  this.iPSPF.getPSPFStyle(this.iPSApplication.getPFStyle());
		
		this.onGenerateCode(iPSAppFunc, iPSAppFunc.getCodeName().toLowerCase());	
	}	
	
	
}
