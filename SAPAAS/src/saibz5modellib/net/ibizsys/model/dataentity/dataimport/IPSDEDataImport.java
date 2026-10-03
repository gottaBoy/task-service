package net.ibizsys.model.dataentity.dataimport;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.paas.core.IDEDataImport;
/* INTERNAL-BEGIN */

/**
 * 实体数据导入定义对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEDataImport extends IPSDataEntityObject, IDEDataImport {

//
//	/**
//	 * 获取数据导入项集合
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSDEDataImportItem> getPSDEDataImportItems();


	
	/**
	 * 获取建立数据实体行为对象
	 * @return
	 */
	IPSDEAction getCreatePSDEAction();
	
	
	
	/**
	 * 获取更新数据实体行为对象
	 * @return
	 */
	IPSDEAction getUpdatePSDEAction();
	
	
	
	/**
	 * 获取建立数据需要的数据操作标识
	 * @return
	 */
	IPSDEOPPriv getCreatePSDEOPPriv();
	
	
	/**
	 * 获取更新数据需要的数据操作标识
	 * @return
	 */
	IPSDEOPPriv getUpdatePSDEOPPriv();
}
