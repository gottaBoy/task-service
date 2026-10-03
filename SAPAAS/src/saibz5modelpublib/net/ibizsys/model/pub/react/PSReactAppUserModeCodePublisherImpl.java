package net.ibizsys.model.pub.react;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.Pub.IPSPFAppUserModeCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

/**
 * 应用用户模式
 * 
 * @author lionlau
 *
 */
public class PSReactAppUserModeCodePublisherImpl extends PSReactAppCodePublisherImpl implements IPSPFAppUserModeCodePublisher
{
	@Override
	protected void onGenerateCode() throws Exception
	{
		java.util.Iterator<IPSAppUserMode> psAppUserModes = this.iPSApplication.getAllPSAppUserModes();
		while(psAppUserModes.hasNext()){
			IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
			
			if(iPSAppUserMode.getPSAppMenuModel()==null){
				continue;
			}
			
			this.onGenerateCode(iPSAppUserMode, iPSAppUserMode.getPSAppMenuModel().getCodeName().toLowerCase());
			
		}
	}
	
	
	/**
	 * 产生代码
	 * @param iPSPublisherContext
	 * @param iPSApplication
	 * @param iPSAppUserMode
	 * @throws Exception
	 */
	public void generateCode(IPSPublisherContext iPSPublisherContext, IPSApplication iPSApplication,IPSAppUserMode iPSAppUserMode) throws Exception
	{
		this.iPSPublisherContext = iPSPublisherContext;
		this.iPSApplication = iPSApplication;
		this.iPSPF = this.iPSApplication.getPSPF();// this.getPSModelStorage().getPSPF(this.iPSApplication.getPFType());
		this.iPSPFStyle  = this.iPSApplication.getPSPFStyle();//  this.iPSPF.getPSPFStyle(this.iPSApplication.getPFStyle());
		
		this.onGenerateCode(iPSAppUserMode, iPSAppUserMode.getPSAppMenuModel().getCodeName().toLowerCase());	
	}
	
}
