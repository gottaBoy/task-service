package net.ibizsys.model.der;

/**
 * 实体N:N关系对象接口
 * @author lionlau
 *
 */
public interface IPSDERNN
{
	/**
	 * 获取第一个关系
	 * @return
	 */
	IPSDER1N getFirstPSDER1N();
	
	
	/**
	 * 获取第二个关系
	 * @return
	 */
	IPSDER1N getSecondPSDER1N();
}
