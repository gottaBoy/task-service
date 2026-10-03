package net.ibizsys.pswf.core;

/**
 * 流程排它网关处理对象接口
  * 寻找唯一一条能走完的连接，也就是说当有一个连接可以走通的情况下，它不会再次去寻找第二条可以走通的连接 ，如是没有符合条件的，就走默认的连接
 * @author Administrator
 *
 */
public interface IWFExclusiveGatewayProcessModel extends IWFGatewayProcessModelBase {

}
