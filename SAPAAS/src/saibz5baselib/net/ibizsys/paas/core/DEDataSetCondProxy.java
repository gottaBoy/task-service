package net.ibizsys.paas.core;

import java.util.Iterator;

/**
 * 实体数据集条件代理对象
 * @author Administrator
 *
 */
public class DEDataSetCondProxy implements IDEDataSetCond {

	private IDEDataQueryCodeCond iDEDataQueryCodeCond = null;
	public DEDataSetCondProxy(IDEDataQueryCodeCond iDEDataQueryCodeCond ) {
		this.iDEDataQueryCodeCond = iDEDataQueryCodeCond;
	}
	@Override
	public String getDEFName() {
		return this.iDEDataQueryCodeCond.getDEFName();
	}
	@Override
	public String getCondType() {
		return this.iDEDataQueryCodeCond.getCondType();
	}
	@Override
	public String getCondOp() {
		return this.iDEDataQueryCodeCond.getCondOp();
	}
	@Override
	public String getCondValue() {
		return this.iDEDataQueryCodeCond.getCondValue();
	}
	@Override
	public String getCustomCond() {
		return this.iDEDataQueryCodeCond.getCustomCond();
	}
	@Override
	public String getPredefindedCond() {
		return this.iDEDataQueryCodeCond.getPredefindedCond();
	}
	@Override
	public String getPredefinedCode() {
		return this.iDEDataQueryCodeCond.getPredefinedCode();
	}
	@Override
	public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
		return this.iDEDataQueryCodeCond.getChildDEDataQueryConds();
	}
	@Override
	public String getDEFieldExp() {
		return this.iDEDataQueryCodeCond.getDEFieldExp();
	}
	@Override
	public boolean isNotMode() {
		return this.iDEDataQueryCodeCond.isNotMode();
	}
	@Override
	public int getStdDataType() {
		return this.iDEDataQueryCodeCond.getStdDataType();
	}
	@Override
	public String getValueFunc() {
		return this.iDEDataQueryCodeCond.getValueFunc();
	}
	@Override
	public String getId() {
		return this.iDEDataQueryCodeCond.getId();
	}
	@Override
	public String getName() {
		return this.iDEDataQueryCodeCond.getName();
	}
	@Override
	public String getDEDataQueryName() {
		// TODO Auto-generated method stub
		return null;
	}
}
