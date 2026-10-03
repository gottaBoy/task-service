/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="733170434261be84089d353a6a231373",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="7D21E4C3-A8FC-4A14-B817-5A5EEC5589F0",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFDynamicUserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFDynamicUserDefaultDSModelBase() {
        super();

        this.initAnnotation(WFDynamicUserDefaultDSModelBase.class);
    }




}