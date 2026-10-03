/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userobject.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="318a3649ecafa3b934925a0231207d09",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="AC308D65-082C-4F63-A4C3-12A1EEB9C7DB",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserObjectDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserObjectDefaultDSModelBase() {
        super();

        this.initAnnotation(UserObjectDefaultDSModelBase.class);
    }




}