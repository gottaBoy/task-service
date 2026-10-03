package net.ibizsys.paas.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;

/**
 * 实体数据变更派送者基类
 * 
 * @author LionLau
 *
 */
public abstract class DEDataChangeDispatcherBase implements IDEDataChangeDispatcher {
	private static final Log log = LogFactory.getLog(DEDataChangeDispatcherBase.class);

	protected DEDataChgDisp deDataChgDisp = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataChangeDispatcher#init(net.ibizsys.psrt.srv.common.entity.DEDataChgDisp)
	 */
	public void init(DEDataChgDisp deDataChgDisp) throws Exception {
		this.deDataChgDisp = deDataChgDisp;

		onInit();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataChangeDispatcher#getName()
	 */
	@Override
	public String getName() {
		return deDataChgDisp.getDEDataChgDispName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataChangeDispatcher#dispatch(net.ibizsys.paas.core.IDEDataChangeDispatchParam)
	 */
	@Override
	public void dispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
		onDispatch(iDEDataChangeDispatchParam);
	}

	/**
	 * 数据派发时触发
	 * 
	 * @param iDEDataChangeDispatchParam
	 * @throws Exception
	 */
	protected void onDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {

	}

}
