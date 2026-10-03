/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userdgtheme.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="dfe988181f007801f103fd18e8a5661b",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="5C414785-C655-4789-9CE6-01E8C1D66AEC",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserDGThemeDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserDGThemeDefaultDSModelBase() {
        super();

        this.initAnnotation(UserDGThemeDefaultDSModelBase.class);
    }




}