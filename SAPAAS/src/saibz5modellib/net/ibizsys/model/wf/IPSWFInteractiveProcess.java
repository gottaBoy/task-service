package net.ibizsys.model.wf;

import net.ibizsys.pswf.core.IWFInteractiveProcessModel;

/**
 * 流程交互处理对象接口
 * @author Administrator
 *
 */
public interface IPSWFInteractiveProcess extends IPSWFProcess,IWFInteractiveProcessModel
{
		
	//定义预定义操作代码表

		/**
		*预定义操作:回退
		*/
		public final static String PREDEFINEDACTION_SENDBACK = "SENDBACK" ;

		/**
		*预定义操作:补充信息
		*/
		public final static String PREDEFINEDACTION_SUPPLYINFO = "SUPPLYINFO" ;

		/**
		*预定义操作:前加签
		*/
		public final static String PREDEFINEDACTION_ADDSTEPBEFORE = "ADDSTEPBEFORE" ;

		/**
		*预定义操作:后加签
		*/
		public final static String PREDEFINEDACTION_ADDSTEPAFTER = "ADDSTEPAFTER" ;
		
		/**
		*预定义操作:征求意见
		*/
		public final static String PREDEFINEDACTION_TAKEADVICE = "TAKEADVICE" ;
		
		
		/**
		*预定义操作:用户自定义
		*/
		public final static String PREDEFINEDACTION_USERACTION = "USERACTION" ;
		
		/**
		*预定义操作:用户自定义2
		*/
		public final static String PREDEFINEDACTION_USERACTION2 = "USERACTION2" ;
	    
		/**
		*预定义操作:用户自定义3
		*/
		public final static String PREDEFINEDACTION_USERACTION3 = "USERACTION3" ;
		
		/**
		*预定义操作:用户自定义4
		*/
		public final static String PREDEFINEDACTION_USERACTION4 = "USERACTION4" ;
		
		/**
		*预定义操作:用户自定义5
		*/
		public final static String PREDEFINEDACTION_USERACTION5 = "USERACTION5" ;
		
		/**
		*预定义操作:用户自定义6
		*/
		public final static String PREDEFINEDACTION_USERACTION6 = "USERACTION6" ;
		
		
		/**
		 * 获取交互流程角色集合
		 * @return
		 */
		java.util.Iterator<IPSWFProcessRole> getPSWFProcessRoles();
		
		
		/**
		 * 获取支持的预定义操作
		 * @return
		 */
		java.util.Iterator<String> getPredefinedActions();
		
		
		
		/**
		 * 是否支持指定预定义操作
		 * @param strAction
		 * @return
		 */
		boolean isEnablePredefinedAction(String strAction);
}
