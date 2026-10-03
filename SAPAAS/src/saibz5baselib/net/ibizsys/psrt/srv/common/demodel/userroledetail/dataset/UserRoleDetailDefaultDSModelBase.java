/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledetail.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="a6ba8b8895f3f2438f9e9ef761ccb29c",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="EF71FC47-262A-4437-8FB3-21B39CEC9ADC",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserRoleDetailDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserRoleDetailDefaultDSModelBase() {
        super();

        this.initAnnotation(UserRoleDetailDefaultDSModelBase.class);
    }




}