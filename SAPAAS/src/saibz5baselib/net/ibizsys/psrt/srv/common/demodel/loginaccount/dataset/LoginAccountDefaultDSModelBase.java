/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.loginaccount.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="5ae7d9610693e638cd1064cf7c9126f8",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="5D2DAA40-8DC0-45FC-9D72-D5BBDBF55957",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class LoginAccountDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public LoginAccountDefaultDSModelBase() {
        super();

        this.initAnnotation(LoginAccountDefaultDSModelBase.class);
    }




}