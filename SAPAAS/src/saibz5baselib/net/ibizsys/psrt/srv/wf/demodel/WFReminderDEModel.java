package net.ibizsys.psrt.srv.wf.demodel;


import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.psrt.srv.wf.demodel.wfreminder.WFReminderDEDataAccMgr;


//@Component
public class WFReminderDEModel extends WFReminderDEModelBase {

   private static final long serialVersionUID = -1L;

   public WFReminderDEModel() throws Exception{
        super();
   }
   
   
   /**
	 * 建立实体数据访问控制对象
	 * @return
	 * @throws Exception
	 */
   @Override
	protected IDEDataAccMgr prepareDEDataAccMgr() throws Exception
	{
		IDEDataAccMgr	iDEDataAccMgr = new WFReminderDEDataAccMgr();
		iDEDataAccMgr.init(this);
		return iDEDataAccMgr;
	}
 
}