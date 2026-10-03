/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userrole.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="1e40618663977c439800bf56d8ac4390",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="EE18C1CB-725B-468A-BEDA-201196F9751A",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserRoleDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserRoleDefaultDSModelBase() {
        super();

        this.initAnnotation(UserRoleDefaultDSModelBase.class);
    }




}