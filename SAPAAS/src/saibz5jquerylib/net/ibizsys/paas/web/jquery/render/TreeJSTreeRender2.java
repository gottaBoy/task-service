package net.ibizsys.paas.web.jquery.render;

/**
 * JQuery JSTree 树视图绘制器，不以数据形式下发结果
 * 
 * @author Administrator
 *
 */
public class TreeJSTreeRender2 extends TreeJSTreeRender {

	@Override
	protected boolean isFetchResultArrayMode() {
		return false;
	}

}
