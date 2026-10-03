package net.ibizsys.model.control.drctrl;


/**
 * 实体数据关系栏部件对象接口
 * @author lionlau
 *
 */
public interface IPSDEDRBar extends IPSDRBar,IPSDEDRCtrl
{
	
	/**
	 * 获取数据关系栏项目集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDRBarGroup> getPSDEDRBarGroups()throws Exception;
	
	
	
	
	
	
}
