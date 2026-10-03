/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.org.uiaction;


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
 * 实体界面行为 InitAll
 */
public class OrgInitAllUIActionModel extends OrgInitAllUIActionModelBase {

    private static final Log log = LogFactory.getLog(OrgInitAllUIActionModel.class);

    public OrgInitAllUIActionModel() {
        super();
    }


}