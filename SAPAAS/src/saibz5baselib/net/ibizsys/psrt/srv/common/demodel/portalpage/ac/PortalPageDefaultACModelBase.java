/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.portalpage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="f63040021720d1401ec2014d30b02bb6",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="PORTALPAGEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="PORTALPAGENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class PortalPageDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public PortalPageDefaultACModelBase() {
        super();

        this.initAnnotation(PortalPageDefaultACModelBase.class);
    }

}