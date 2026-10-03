package net.ibizsys.pswx.core;

import net.sf.json.JSONObject;

/**
 * 微信菜单项模型接口
 * 
 * @author Administrator
 * 
 */
public interface IWXMenuItem {

	/**
	 * 点击推事件
	 */
	final static String WXFUNC_CLICK = "click";

	/**
	 * 跳转URL
	 */
	final static String WXFUNC_VIEW = "view";

	/**
	 * 扫码推事件
	 */
	final static String WXFUNC_SCANCODE_PUSH = "scancode_push";

	/**
	 * 扫码推事件（且弹出“消息接收中”提示框）
	 */
	final static String WXFUNC_SCANCODE_WAITMSG = "scancode_waitmsg";

	/**
	 * 弹出系统拍照发图
	 */
	final static String WXFUNC_PIC_SYSPHOTO = "pic_sysphoto";

	/**
	 * 弹出拍照或者相册发图
	 */
	final static String WXFUNC_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";

	/**
	 * 弹出企业微信相册发图器
	 */
	final static String WXFUNC_PIC_WEIXIN = "pic_weixin";

	/**
	 * 弹出地理位置选择器
	 */
	final static String WXFUNC_LOCATION_SELECT = "location_select";

	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取父标识
	 * 
	 * @return
	 */
	String getPId();

	/**
	 * 获取文本
	 * 
	 * @return
	 */
	String getText();

	// /**
	// * 获取菜单模型
	// * @return
	// */
	// IWXMenu getWXMenu();

	// /**
	// * 获取父菜单项模型
	// * @return
	// */
	// IWXMenuItem getParent();

	/**
	 * 获取子菜单项集合
	 * 
	 * @return
	 */
	java.util.ArrayList<IWXMenuItem> getItems();

	/**
	 * 获取菜单的功能类型
	 * 
	 * @return
	 */
	String getWXFunc();

	/**
	 * 获取菜单的功能类型
	 * 
	 * @return
	 */
	String getClickTag();

	/**
	 * 转换成JSON对象
	 * 
	 * @return
	 */
	JSONObject toJSON();
}
