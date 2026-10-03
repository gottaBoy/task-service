/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccount.uiaction;


import java.util.List;
import java.util.HashMap;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ibizsys.paas.core.IDELogicActionContext;
import net.ibizsys.paas.core.DELogic;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.service.ServiceGlobal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 实体界面行为 发布菜单
 */
public class WXAccountPubMenuUIActionModel extends WXAccountPubMenuUIActionModelBase {

    private static final Log log = LogFactory.getLog(WXAccountPubMenuUIActionModel.class);

    public WXAccountPubMenuUIActionModel() {
        super();
    }


}