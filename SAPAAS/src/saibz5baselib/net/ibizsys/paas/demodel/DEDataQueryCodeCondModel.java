package net.ibizsys.paas.demodel;

import java.util.Iterator;

import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;

/**
 * 实体查询代码条件模型
 * 
 * @author lionlau
 *
 */
public class DEDataQueryCodeCondModel implements IDEDataQueryCodeCond {
	private DEDataQueryCodeCond deDataQueryCodeCond = null;

	public DEDataQueryCodeCondModel(DEDataQueryCodeCond deDataQueryCodeCond) {
		this.deDataQueryCodeCond = deDataQueryCodeCond;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.deDataQueryCodeCond.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.deDataQueryCodeCond.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getDEFName()
	 */
	@Override
	public String getDEFName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCondType()
	 */
	@Override
	public String getCondType() {
		return IDEDataQueryCodeCond.CONDTYPE_CUSTOM;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCondOp()
	 */
	@Override
	public String getCondOp() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCondValue()
	 */
	@Override
	public String getCondValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCustomCond()
	 */
	@Override
	public String getCustomCond() {
		return this.deDataQueryCodeCond.condition();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getPredefindedCond()
	 */
	@Override
	public String getPredefindedCond() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public String getPredefinedCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getChildDEDataQueryConds()
	 */
	@Override
	public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getDEFieldExp()
	 */
	@Override
	public String getDEFieldExp() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#isNotMode()
	 */
	@Override
	public boolean isNotMode() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getStdDataType()
	 */
	@Override
	public int getStdDataType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValueFunc() {
		return null;
	}
	
	

}
