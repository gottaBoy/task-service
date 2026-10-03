package net.ibizsys.ssdyna.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体查询代码模型
 * 
 * @author lionlau
 *
 */
public class DynaDEDataQueryCodeModel implements IDEDataQueryCode {


	private IPSDEDataQueryCode deDataQueryCode = null;
	private IDEDataQuery iDEDataQuery = null;
	private HashMap<String, IDEDataQueryCodeExp> fieldExpMap = new HashMap<String, IDEDataQueryCodeExp>();
	private ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondList = new ArrayList<IDEDataQueryCodeCond>();
	private HashMap<String, SqlCodeHelper> sqlCodeHelperMap = new HashMap<String, SqlCodeHelper>();
	private IDataEntityModel iDEModel = null;

	public DynaDEDataQueryCodeModel(IDEDataQuery iDEDataQuery, IPSDEDataQueryCode deDataQueryCode) throws Exception{
		this.iDEDataQuery = iDEDataQuery;
		this.deDataQueryCode = deDataQueryCode;
		if (this.iDEDataQuery.getDataEntity() != null && this.iDEDataQuery.getDataEntity() instanceof IDataEntityModel) {
			this.iDEModel = (IDataEntityModel) this.iDEDataQuery.getDataEntity();
		}
		this.prepareDEDataQueryCodeExps();
		this.prepareDEDataQueryCodeConds();
	}

	/**
	 * 准备实体数据查询代码表达式
	 */
	protected void prepareDEDataQueryCodeExps() throws Exception{
		java.util.Iterator<IPSDEDataQueryCodeExp > psDEDataQueryCodeExps = this.deDataQueryCode.getPSDEDataQueryCodeExps();
		while(psDEDataQueryCodeExps.hasNext()){
			DynaDEDataQueryCodeExpModel deDataQueryCodeExpModel = new DynaDEDataQueryCodeExpModel(psDEDataQueryCodeExps.next());
			fieldExpMap.put(deDataQueryCodeExpModel.getName().toUpperCase(), deDataQueryCodeExpModel);
		}
		

	}

	/**
	 * 准备实体数据查询代码条件
	 */
	protected void prepareDEDataQueryCodeConds() throws Exception{
		java.util.Iterator<IPSDEDataQueryCodeCond > psDEDataQueryCodeConds = this.deDataQueryCode.getPSDEDataQueryCodeConds();
		while(psDEDataQueryCodeConds.hasNext()){
			
			DynaDEDataQueryCodeCondModel deDataQueryCodeCondModel = new DynaDEDataQueryCodeCondModel(psDEDataQueryCodeConds.next());
			deDataQueryCodeCondList.add(deDataQueryCodeCondModel);

		}

	}

	/**
	 * 获取实体数据查询
	 * 
	 * @return
	 */
	@Override
	public IDEDataQuery getDEDataQuery() {
		return this.iDEDataQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getDBType()
	 */
	@Override
	public String getDBType() {
		return deDataQueryCode.getDBType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getQueryCode()
	 */
	@Override
	public String getQueryCode() {
		return deDataQueryCode.getQueryCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getQueryCode()
	 */
	@Override
	public String getQueryCodeTemp() {
		return deDataQueryCode.getQueryCodeTemp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getDeclareCode()
	 */
	@Override
	public String getDeclareCode() {
		return deDataQueryCode.getDeclareCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#fillDeclareParams(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#fillQueryParams(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getConditionSQL(net.ibizsys.paas.core.IDEDataSetFetchContext, net.ibizsys.paas.core.IDEDataQueryCodeCond, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception {
		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_GROUP, true) == 0) {
			ArrayList<String> condList = new ArrayList<String>();
			java.util.Iterator<IDEDataQueryCodeCond> childDEDataQueryConds = iDEDataQueryCond.getChildDEDataQueryConds();
			if (childDEDataQueryConds != null) {
				while (childDEDataQueryConds.hasNext()) {
					IDEDataQueryCodeCond childDEDataQueryCond = childDEDataQueryConds.next();
					String strCond = getConditionSQL(iDEDataSetFetchContext, childDEDataQueryCond, iDBDialect, list);
					if (!StringHelper.isNullOrEmpty(strCond)) {
						condList.add(strCond);
					}
				}
			}

			if (condList.size() == 0) return null;

			StringBuilderEx sb = new StringBuilderEx();

			boolean bFirst = true;
			for (String strCond : condList) {
				if (bFirst)
					bFirst = false;
				else
					sb.append(" %1$s ", iDEDataQueryCond.getCondOp());
				sb.append("( %1$s )", strCond);
			}

			if (iDEDataQueryCond.isNotMode()) {
				return StringHelper.format(" NOT( %1$s )", sb.toString());
			} else
				return sb.toString();
		}

		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_DEFIELD, true) == 0) {
			String strDEFieldExp = iDEDataQueryCond.getDEFieldExp();
			int nStdDataType = iDEDataQueryCond.getStdDataType();
			if (StringHelper.isNullOrEmpty(strDEFieldExp)) {
				strDEFieldExp = getDEFieldExp(iDEDataQueryCond.getDEFName(), false);
			}
			if (nStdDataType == DataTypes.UNKNOWN) {
				IDEField iDEField = this.iDEDataQuery.getDataEntity().getDEField(iDEDataQueryCond.getDEFName(), false);
				nStdDataType = iDEField.getStdDataType();
			}
			if (this.getDEModel() != null) return this.getDEModel().getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
			return iDBDialect.getConditionSQL(strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue(), false, null);
		}

		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_CUSTOM, true) == 0) {
			// 自定义代码，要分析是否有参数
			SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(iDEDataQueryCond.getCustomCond());
			if (sqlCodeHelper == null) {
				sqlCodeHelper = new SqlCodeHelper();
				sqlCodeHelper.init(this, iDEDataQueryCond.getCustomCond());
				sqlCodeHelperMap.put(iDEDataQueryCond.getCustomCond(), sqlCodeHelper);
			}
			return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
		}

		throw new Exception(StringHelper.format("无法识别的条件类型[%1$s]", iDEDataQueryCond.getCondType()));
	}

	/**
	 * 获取属性表达式
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	public String getDEFieldExp(String strName, boolean bTry) throws Exception {
		strName = strName.toUpperCase();
		IDEDataQueryCodeExp iDEDataQueryCodeExp = fieldExpMap.get(strName);
		if (iDEDataQueryCodeExp == null) {
			// 猜测
			IDEField iDEField = this.getDEDataQuery().getDataEntity().getDEField(strName, true);
			if (iDEField != null) {
				if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) {
					return StringHelper.format("t11.%1$s", iDEField.getName());
				} else
					return StringHelper.format("t1.%1$s", iDEField.getName());
			}
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取属性表达式[%1$s]", strName));
			}
		}

		return iDEDataQueryCodeExp.getExpression();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQueryCode#getDEDataQueryCodeConds()
	 */
	@Override
	public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
		return deDataQueryCodeCondList.iterator();
	}

	/**
	 * @param iDEDataSetFetchContext
	 * @param iDEField
	 * @param strFunc
	 * @param strAction
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception {
		// 自定义代码，要分析是否有参数
		SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
		if (sqlCodeHelper == null) {
			sqlCodeHelper = new SqlCodeHelper();
			sqlCodeHelper.init(this, strCode);
			sqlCodeHelperMap.put(strCode, sqlCodeHelper);
		}
		return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
	}

	@Override
	public String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
		String strCode = this.getQueryCode();
		SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
		if (sqlCodeHelper == null) {
			sqlCodeHelper = new SqlCodeHelper();
			sqlCodeHelper.init(this, strCode);
			sqlCodeHelperMap.put(strCode, sqlCodeHelper);
		}
		return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
	}

	@Override
	public String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
		String strCode = this.getQueryCodeTemp();
		SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
		if (sqlCodeHelper == null) {
			sqlCodeHelper = new SqlCodeHelper();
			sqlCodeHelper.init(this, strCode);
			sqlCodeHelperMap.put(strCode, sqlCodeHelper);
		}
		return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
	}

	@Override
	public String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
		String strCode = this.getDeclareCode();
		SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
		if (sqlCodeHelper == null) {
			sqlCodeHelper = new SqlCodeHelper();
			sqlCodeHelper.init(this, strCode);
			sqlCodeHelperMap.put(strCode, sqlCodeHelper);
		}
		return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
	}

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	protected IDataEntityModel getDEModel() {
		return this.iDEModel;
	}

	@Override
	public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
		return null;
	}
}
