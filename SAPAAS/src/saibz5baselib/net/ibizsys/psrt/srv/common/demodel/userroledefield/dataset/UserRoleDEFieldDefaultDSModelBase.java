/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefield.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="10d6c2ea8dda8754dcde1bceab9704c5",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="EEFA7B6D-D93A-4BC9-8AAD-F2A83357F679",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserRoleDEFieldDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserRoleDEFieldDefaultDSModelBase() {
        super();

        this.initAnnotation(UserRoleDEFieldDefaultDSModelBase.class);
    }




}