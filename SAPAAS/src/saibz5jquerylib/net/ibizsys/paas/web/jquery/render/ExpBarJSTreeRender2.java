package net.ibizsys.paas.web.jquery.render;

/**
 * JQuery JSTree 导航栏绘制器2，供angularJS框架使用，不以数组的形式下发数据
 * 
 * @author Administrator
 *
 */
public class ExpBarJSTreeRender2 extends ExpBarJSTreeRender {

	@Override
	protected boolean isFetchResultArrayMode() {
		return false;
	}

}
