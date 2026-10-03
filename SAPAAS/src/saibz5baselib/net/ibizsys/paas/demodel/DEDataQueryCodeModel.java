package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParamList;
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
public class DEDataQueryCodeModel implements IDEDataQueryCode {
	
	private DEDataQueryCode deDataQueryCode = null;
	private IDEDataQuery iDEDataQuery = null;
	private HashMap<String, IDEDataQueryCodeExp> fieldExpMap = new HashMap<String, IDEDataQueryCodeExp>();
	private ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondList = new ArrayList<IDEDataQueryCodeCond>();
	private HashMap<String, SqlCodeHelper> sqlCodeHelperMap = new HashMap<String, SqlCodeHelper>();
	private IDataEntityModel iDEModel = null;

	public DEDataQueryCodeModel(IDEDataQuery iDEDataQuery, DEDataQueryCode deDataQueryCode) {
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
	protected void prepareDEDataQueryCodeExps() {
		for (DEDataQueryCodeExp fieldExp : this.deDataQueryCode.fieldexps()) {
			DEDataQueryCodeExpModel deDataQueryCodeExpModel = new DEDataQueryCodeExpModel(fieldExp);
			fieldExpMap.put(deDataQueryCodeExpModel.getName().toUpperCase(), deDataQueryCodeExpModel);
		}

	}

	/**
	 * 准备实体数据查询代码条件
	 */
	protected void prepareDEDataQueryCodeConds() {
		for (DEDataQueryCodeCond fieldCond : this.deDataQueryCode.conds()) {
			DEDataQueryCodeCondModel deDataQueryCodeCondModel = new DEDataQueryCodeCondModel(fieldCond);
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
		return deDataQueryCode.dbtype();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getQueryCode()
	 */
	@Override
	public String getQueryCode() {
		return deDataQueryCode.querycode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getQueryCode()
	 */
	@Override
	public String getQueryCodeTemp() {
		return deDataQueryCode.querycodetemp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataQueryModel#getDeclareCode()
	 */
	@Override
	public String getDeclareCode() {
		return deDataQueryCode.declarecode();
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

			if (condList.size() == 0){
				return null;
			}

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
			if(StringHelper.isNullOrEmpty(iDEDataQueryCond.getValueFunc())){
				if (nStdDataType == DataTypes.UNKNOWN) {
					IDEField iDEField = this.iDEDataQuery.getDataEntity().getDEField(iDEDataQueryCond.getDEFName(), false);
					nStdDataType = iDEField.getStdDataType();
				}
			}
			else{
				IDBFunction iDBFunction = null;
				if (this.getDEModel() != null) {
					iDBFunction = this.getDEModel().getSystemModel().getDBFunction(iDBDialect, iDEDataQueryCond.getValueFunc());
				}
				else {
					iDBFunction = iDBDialect.getDBFunction(iDEDataQueryCond.getValueFunc());
				}
				nStdDataType = iDBFunction.getOutputDataType();
				strDEFieldExp = iDBFunction.getFuncSQL(false, new String[]{strDEFieldExp});
			}
			if (this.getDEModel() != null) {
				return this.getDEModel().getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
			}
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
			return null;
		}

		return iDEDataQueryCodeExp.getExpression();
	}
	
	@Override
	public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps(){
		return fieldExpMap.values().iterator() ;
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

}
