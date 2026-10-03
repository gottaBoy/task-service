package net.ibizsys.paas.core;

/**
 * 模型基类
 * 
 * @author lionlau
 *
 */
public abstract class ModelBaseImpl implements IModelBase
{
	protected String strId = null;
	protected String strName = null;

	protected void onInit() throws Exception {

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.strId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.strName;
	}

}
