package net.ibizsys.psrt.srv.wf.demodel;


import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.psrt.srv.wf.demodel.wfstepactor.WFStepActorDEDataAccMgr;


//@Component
public class WFStepActorDEModel extends WFStepActorDEModelBase {

   private static final long serialVersionUID = -1L;

   public WFStepActorDEModel() throws Exception{
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
  		IDEDataAccMgr	iDEDataAccMgr = new WFStepActorDEDataAccMgr();
  		iDEDataAccMgr.init(this);
  		return iDEDataAccMgr;
  	}
   
}