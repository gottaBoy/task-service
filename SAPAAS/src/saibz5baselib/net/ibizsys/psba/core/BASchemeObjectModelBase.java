package net.ibizsys.psba.core;

/**
 * 大数据架构相关相关模型对象基类
 * 
 * @author Administrator
 *
 */
public abstract class BASchemeObjectModelBase extends BAModelBase implements IBASchemeObject {

	private IBAScheme iBAScheme = null;

	/**
	 * 设置大数据架构
	 * 
	 * @param iBAScheme
	 */
	protected void setBAScheme(IBAScheme iBAScheme) {
		this.iBAScheme = iBAScheme;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBASchemeObject#getBAScheme()
	 */
	@Override
	public IBAScheme getBAScheme() {
		return this.iBAScheme;
	}
	
	
	
	/**
	 * 获取大数据架构模型对象
	 * @return
	 */
	public IBASchemeModel getBASchemeModel(){
		return (IBASchemeModel)getBAScheme();
	}

}
