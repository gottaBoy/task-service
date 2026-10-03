package net.ibizsys.psba.entity;

import net.ibizsys.paas.entity.IEntityActionSupporter;

/**
 * 大数据表数据对象操作支持对象接口
 * @author Administrator
 *
 */
public interface IBAEntityActionSupporter extends IEntityActionSupporter {
	
	/**
	 * 建立数据
	 * @param families
	 * @throws Exception
	 */
	void create(String[] families)throws Exception;
	
	
	
	/**
	 * 更新数据
	 * @param families
	 * @throws Exception
	 */
	void update(String[] families)throws Exception;
	
	

	
	
	
	
	/**
	 * 保存数据
	 * @param families
	 * @throws Exception
	 * 
	 */
	void save(String[] families)throws Exception;
	
	
	
	
	/**
	 * 获取数据
	 * @param families 
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	boolean get(String[] families,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取数据
	 * @param families
	 * @return
	 * @throws Exception
	 */
	void get(String[] families)throws Exception;
	
	
	
}
