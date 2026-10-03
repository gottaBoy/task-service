package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IGridRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
/**
 * ParamQuery Grid 绘制器基类
 * @author hebao
 *
 */
public class GridPQGridRender  implements ICtrlRender, IMDCtrlRender, IGridRender{
	
	/**
	 * 填充数据集合查询上下文，填充表格排序及分页信息
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	@Override
	public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception
	{
		IWebContext iWebContext = WebContext.getCurrent();
		if (iWebContext == null)
		{
			return;
		}

		String strOrder0Column = iWebContext.getPostOrParamValue("pqorder[0][column]");
		String strOrder0Dir = iWebContext.getPostOrParamValue("pqorder[0][direction]");

		if (!StringHelper.isNullOrEmpty(strOrder0Column) && !StringHelper.isNullOrEmpty(strOrder0Dir))
		{
			deDataSetFetchContextImpl.setSort(strOrder0Column);
			deDataSetFetchContextImpl.setSortDir(strOrder0Dir);
		}

		String strOrder1Column = iWebContext.getPostOrParamValue("pqorder[1][column]");
		String strOrder1Dir = iWebContext.getPostOrParamValue("pqorder[1][direction]");

		if (!StringHelper.isNullOrEmpty(strOrder1Column) && !StringHelper.isNullOrEmpty(strOrder1Dir))
		{
			deDataSetFetchContextImpl.setSort2(strOrder1Column);
			deDataSetFetchContextImpl.setSort2Dir(strOrder1Dir);
		}

		String strLimit = iWebContext.getPostOrParamValue("length");
		String strOffset = iWebContext.getPostOrParamValue("start");
		int nStartRow = 0;
		if (!StringHelper.isNullOrEmpty(strOffset))
		{
			nStartRow = Integer.parseInt(strOffset);
		}

		int nSize = 25;
		if (!StringHelper.isNullOrEmpty(strLimit))
		{
			nSize = Integer.parseInt(strLimit);
		}

		deDataSetFetchContextImpl.setStartRow(nStartRow);
		deDataSetFetchContextImpl.setPageSize(nSize);

	}

	/**
	 * 获取快速搜索条件
	 * 
	 * @return
	 */
	@Override
	public String getFetchQuickSearch()
	{
		IWebContext iWebContext = WebContext.getCurrent();
		if (iWebContext == null)
		{
			return null;

		}
		return iWebContext.getPostOrParamValue("search");
	}

	/**
	 * 过滤异步操作结果，处理分页相关参数
	 * 
	 * @param ajaxActionResult
	 * @param jo
	 */
	@Override
	public void filteAjaxActionResult(AjaxActionResult ajaxActionResult, JSONObject jo)
	{
		if (StringHelper.compare(ajaxActionResult.getAjaxAction(), MDCtrlHandlerBase.ACTION_FETCH, true) == 0)
		{
			MDAjaxActionResult mdAjaxActionResult = (MDAjaxActionResult) ajaxActionResult;

			jo.put("totalRecords", mdAjaxActionResult.getTotalRow());
			
			// objJSON.put("sEcho", nStartRow);
			if (mdAjaxActionResult.getPageSize() > 0)
			{
				jo.put("iTotalRecords", mdAjaxActionResult.getPageSize());
			}
			int nPageSize = mdAjaxActionResult.getPageSize();
			int nStartRow = mdAjaxActionResult.getStartRow();
			int curPage = nStartRow/nPageSize+1;
			jo.put("curPage", curPage);
		}
	}
	
	/**
	 * 填充数据获取结果
	 * 
	 * @param iGridModel 表格模型
	 * @param fetchResult 请求结果
	 * @param dt 数据
	 * @throws Exception
	 */
	@Override
	public void fillFetchResult(IGridModel iGridModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception
	{
		iGridModel.fillFetchResult(fetchResult, dt);
	}
}
