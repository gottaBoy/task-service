/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.system.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="df93b04c07324dc3f4ae6aa109e612d1",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="02A70D34-9714-4ADE-B08D-A36D94C080AD",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class SystemDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public SystemDefaultDSModelBase() {
        super();

        this.initAnnotation(SystemDefaultDSModelBase.class);
    }




}