package net.ibizsys.model.pub.preview;

import SA.SRFDA.PS.Core.App.IPSAppLan;

/**
 * PreViewPC应用程序语言支持
 * 
 * @author lionlau
 *
 */
public class PSPreviewAppLanCodePublisherImpl extends PSPreviewAppCodePublisherImpl
{
	
	@Override
	protected void onGenerateCode() throws Exception {
		
		java.util.Iterator<IPSAppLan> psAppLans = this.iPSApplication.getAllPSAppLans();
		while(psAppLans.hasNext()){
			IPSAppLan iPSAppLan = psAppLans.next();
			this.onGenerateCode(iPSAppLan,iPSAppLan.getLanguage().toLowerCase());
		}
	}
	
	
	
}
