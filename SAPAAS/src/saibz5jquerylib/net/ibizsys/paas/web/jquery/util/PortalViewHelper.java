package net.ibizsys.paas.web.jquery.util;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.PPModel;
import net.ibizsys.psrt.srv.common.service.PPModelService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 门户视图辅助对象
 * 
 * @author Administrator
 *
 */
public class PortalViewHelper {
	private static PortalViewHelper portalViewHelper = new PortalViewHelper();

	protected ThreadLocal<IViewController> viewControllerLocal = new ThreadLocal<IViewController>();

	private static Log log = LogFactory.getLog(PortalViewHelper.class);

	private class PortalViewModel {
		public int LeftColCount = 9;
		public int CenterColCount = 0;
		public int RightColCount = 3;

		public ArrayList<String> LeftColCtrlList = new ArrayList<String>();
		public ArrayList<String> CenterColCtrlList = new ArrayList<String>();
		public ArrayList<String> RightColCtrlList = new ArrayList<String>();
	}

	protected ThreadLocal<PortalViewModel> portalViewModelLocal = new ThreadLocal<PortalViewModel>();
	// protected ThreadLocal<Boo> viewControLocal = new ThreadLocal<IViewController> ();

	/**
	 * 获取门户视图辅助对象
	 * 
	 * @param iViewController
	 * @param bEmbed
	 * @return
	 * @throws Exception
	 */
	public static PortalViewHelper getInstance(IViewController iViewController, boolean bEmbed) throws Exception {
		portalViewHelper.setViewController(iViewController);
		return portalViewHelper;
	}

	/**
	 * 设置视图控制对象
	 * 
	 * @param iViewController
	 */
	protected void setViewController(IViewController iViewController) throws Exception {
		viewControllerLocal.set(iViewController);
		// 计算相关的参数
		portalViewModelLocal.set(null);
		// 清空参数
		if (iViewController == null) {
			// 清空
			return;
		}

		PPModel ppModel = new PPModel();
		PPModelService pPModelService = (PPModelService) ServiceGlobal.getService(PPModelService.class, iViewController.getSessionFactory());
		// 查询用户当前的视图模型
		String strUserId = WebContext.getCurrent().getCurUserId();
		if (!StringHelper.isNullOrEmpty(strUserId)) {
			String strPPModelId = KeyValueHelper.genUniqueId(iViewController.getId(), strUserId);
			ppModel.setPPModelId(strPPModelId);
			if (!pPModelService.get(ppModel, true)) {
				// 建立用户
				PPModel defPPModel = new PPModel();
				defPPModel.setPPModelId(KeyValueHelper.genUniqueId(iViewController.getId(), "DEFAULT"));
				if (pPModelService.get(defPPModel, true)) {
					defPPModel.copyTo(ppModel, true);
					ppModel.setPPModelId(strPPModelId);
					ppModel.setOwnerId(strUserId);
					pPModelService.create(ppModel);
				} else {
					log.error(StringHelper.format("没有定义门户页面[%1$s]默认布局", iViewController.getTitle()));
				}
			}
		} else {
			// 建立用户
			ppModel.setPPModelId(KeyValueHelper.genUniqueId(iViewController.getId(), "DEFAULT"));
			if (!pPModelService.get(ppModel, true)) {
				log.error(StringHelper.format("没有定义门户页面[%1$s]默认布局", iViewController.getTitle()));
			}
		}
		PortalViewModel portalViewModel = new PortalViewModel();
		// 展开布局
		String strLayoutModel = ppModel.getPPModel();
		if (StringHelper.isNullOrEmpty(strLayoutModel)) {
			// 放入默认
			portalViewModelLocal.set(portalViewModel);
			return;
		}

		// 展开分析
		HashMap<String, String> ctrlIdMap = new HashMap<String, String>();
		int nLeave = 12;
		String[] parts = strLayoutModel.split("[_]");
		for (int i = 0; i < parts.length; i++) {
			String strPart = parts[i];
			String strPos = "";

			int nCol = getColCount(strPart);
			if (nCol < 0 || nCol > 12) {
				nCol = 12;
			}
			if (i == (parts.length - 1)) {
				nCol = nLeave;
			}
			nLeave -= nCol;

			ArrayList<String> list = null;
			switch (i) {
			case 0:
				strPos = "L";
				portalViewModel.LeftColCount = nCol;
				list = portalViewModel.LeftColCtrlList;
				break;
			case 1:
				strPos = "C";
				portalViewModel.CenterColCount = nCol;
				list = portalViewModel.CenterColCtrlList;
				break;
			case 2:
				strPos = "R";
				portalViewModel.RightColCount = nCol;
				list = portalViewModel.RightColCtrlList;
				break;
			default:
				break;
			}

			for (int j = 0; j < 5; j++) {
				String strFieldName = StringHelper.format("%1$s%2$sPVPartCtrlId", strPos, j + 1);
				String strCtrlId = DataObject.getStringValue(ppModel, strFieldName, "");
				if (StringHelper.isNullOrEmpty(strCtrlId)) continue;

				if (ctrlIdMap.containsKey(strCtrlId)) continue;

				ctrlIdMap.put(strCtrlId, "");
				list.add(strCtrlId);
			}

		}
		portalViewModelLocal.set(portalViewModel);
	}

	private static int getColCount(String strPart) {
		if (strPart.indexOf("P") != -1) {
			int nValue = Integer.parseInt(strPart.replace("P", ""));
			nValue = nValue / 10;
			if (nValue <= 1) return 1;
			if (nValue <= 4) return nValue;
			if (nValue == 5) return 6;
			return nValue + 2;
		}

		return Integer.parseInt(strPart);
	}

	/**
	 * 获取视图控制类
	 * 
	 * @return
	 */
	protected IViewController getViewController() {
		return viewControllerLocal.get();
	}

	private PortalViewModel getPortalViewModel() {
		return portalViewModelLocal.get();
	}

	/**
	 * 获取左侧列数量
	 * 
	 * @return
	 */
	public int getLeftColCount() {
		return getPortalViewModel().LeftColCount;
	}

	/**
	 * 获取内容列数量
	 * 
	 * @return
	 */
	public int getCenterColCount() {
		return getPortalViewModel().CenterColCount;
	}

	/**
	 * 获取右侧列数量
	 * 
	 * @return
	 */
	public int getRightColCount() {
		return getPortalViewModel().RightColCount;
	}

	public java.util.ArrayList<String> getLeftColCtrls() {
		return getPortalViewModel().LeftColCtrlList;
	}

	public java.util.ArrayList<String> getCenterColCtrls() {
		return getPortalViewModel().CenterColCtrlList;
	}

	public java.util.ArrayList<String> getRightColCtrls() {
		return getPortalViewModel().RightColCtrlList;
	}
}
