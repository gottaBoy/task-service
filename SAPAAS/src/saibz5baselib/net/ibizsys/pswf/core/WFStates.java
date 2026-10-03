package net.ibizsys.pswf.core;

/**
 * 流程状态
 * @author Administrator
 *
 */
public class WFStates
{
	/**
	 * 流程未启动
	 */
	public final static String TAG_NOTSTART = "WFNOTSTART";
	
	/**
	 * 流程未完成
	 */
	public final static String TAG_NOTFINISH = "WFNOTFINISH";
	
	/**
	 * 流程已完成
	 */
	public final static String TAG_FINISH = "WFFINISH";
	
	/**
	 * 流程发生错误
	 */
	public final static String TAG_ERROR = "WFERROR";
	
	/**
	 * 流程被取消
	 */
	public final static String TAG_CANCEL = "WFCANCEL";
	
	/**
	 * 流程被人工取消
	 */
	public final static String TAG_CANCELMANUAL = "WFCANCELMANUAL";
	
	/**
	 * 流程被超时取消
	 */
	public final static String TAG_CANCELTIMEOUT = "WFCANCELTIMEOUT";
	
	/**
	 * 流程未启动
	 */
	public final static int NOTSTART = 0;
	
	/**
	 * 流程未完成
	 */
	public final static int NOTFINISH = 1;
	
	/**
	 * 流程已完成
	 */
	public final static int FINISH = 2;
	
	/**
	 * 流程被取消
	 */
	public final static int CANCEL =3;
	/**
	 * 流程被人工取消
	 */
	public final static int CANCEL_MANUAL = 31;
	
	/**
	 * 流程被超时取消
	 */
	public final static int CANCEL_TIMEOUT = 32;
	
	/**
	 * 流程发生错误
	 */
	public final static int ERROR = 4;
	
	/**
	 * 将状态码转换为文本信息
	 * @param nValue
	 * @return
	 */
	public static String toString(int nValue)
	{
		switch(nValue)
		{
		case NOTSTART:
			return TAG_NOTSTART;
		case NOTFINISH:
			return TAG_NOTFINISH;	
		case FINISH:
			return TAG_FINISH;	
		case CANCEL:
			return TAG_CANCEL;
		case CANCEL_MANUAL:
			return TAG_CANCELMANUAL;	
		case CANCEL_TIMEOUT:
			return TAG_CANCELTIMEOUT;	
		case ERROR:
			return TAG_ERROR;
		}
		return TAG_NOTSTART;
	}
	
}
