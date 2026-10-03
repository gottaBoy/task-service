package net.ibizsys.model.control;

/**
 * 控件子部件对象接口
 * @author lionlau
 *
 */
public interface IPSControlItem
{
	/**
	 * 无处理对象，用于取消掉原有设置
	 */
	String HandlerType_None = "None";
	
	
	/**
	 * 部件子部件处理类型：代码表
	 */
	String HandlerType_CodeList = "CodeList";
	
	
	/**
	 * 部件子部件处理类型：外键文本
	 */
	String HandlerType_PickupText = "PickupText";
	
	
	/**
	 * 部件子部件处理类型：自动填充
	 */
	String HandlerType_AC = "AC";
	
	
	/**
	 * 部件子部件处理类型：自定义
	 */
	String HandlerType_Custom = "Custom";
}
