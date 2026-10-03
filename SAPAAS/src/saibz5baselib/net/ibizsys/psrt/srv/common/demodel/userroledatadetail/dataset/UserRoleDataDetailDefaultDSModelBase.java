/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatadetail.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="a54fc7fa42e8260cab1cb33393e222b1",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="39A7C025-DE82-4378-81BC-47A95FA43616",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserRoleDataDetailDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserRoleDataDetailDefaultDSModelBase() {
        super();

        this.initAnnotation(UserRoleDataDetailDefaultDSModelBase.class);
    }




}