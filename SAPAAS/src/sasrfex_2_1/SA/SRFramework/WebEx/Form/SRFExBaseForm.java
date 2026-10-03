package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Common.SRFGlobal;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.ValueRule.DefaultValueRuleEngine;
import SA.SRFramework.ValueRule.FormValueRuleConfig;
import SA.SRFramework.ValueRule.StringLengthsConfig;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import SA.SRFramework.ValueRule.WebFormValueRuleEngineContext;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.ISRFExFormItem2;
import SA.SRFramework.WebEx.ISRFExFormItem3;
import SA.SRFramework.WebEx.ISRFExFormItemEx;
import SA.SRFramework.WebEx.ISRFExFormItemValueTransform;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SRFExBaseForm {
   protected Vector<SRFExBaseFormAction> formActions = new Vector<>();
   protected Vector formControls = new Vector();
   protected HashMap<String, SRFExControl> formControlMap = new HashMap<>();
   protected String strRemotePath = "";
   protected Hashtable paramList = null;
   protected Hashtable updateHtmlList = null;
   protected String strFormId = "";
   protected SRFExPage curPage = null;
   protected String strErrorInfoControlId = "";
   protected String strFormValueRuleId = "";
   protected String strResourceId = "";
   protected boolean bUpdateMode = false;
   protected boolean bEnableItemPrivilege = false;
   private static final Log log = LogFactory.getLog(SRFExBaseForm.class);

   public String getFormId() {
      return this.strFormId;
   }

   public void setFormId(String strFormId) {
      this.strFormId = strFormId;
   }

   public String getFormValueRuleId() {
      return this.strFormValueRuleId;
   }

   public void setFormValueRuleId(String strFormValueRuleId) {
      this.strFormValueRuleId = strFormValueRuleId;
   }

   public SRFExPage getPage() {
      return this.curPage;
   }

   public void setPage(SRFExPage page) {
      this.curPage = page;
   }

   public String getRemotePath() {
      return StringHelper.Length(this.strRemotePath) == 0 ? this.getPage().getDefaultBackEndUrl() : this.strRemotePath;
   }

   public void setRemotePath(String strRemotePath) {
      this.strRemotePath = strRemotePath;
   }

   public String getErrorInfoControlId() {
      return this.strErrorInfoControlId;
   }

   public void setErrorInfoControlId(String strErrorInfoControlId) {
      this.strErrorInfoControlId = strErrorInfoControlId;
   }

   public void Render(Writer writer) {
      try {
         this.OnRender(writer);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   protected void OnRender(Writer writer) {
      try {
         this.PrepareParams();
         writer.write(StringHelper.Format("var %1$s={", this.getFormId()));
         this.RenderParams(writer);
         this.RenderSystemActions(writer);

         for (int i = 0; i < this.formActions.size(); i++) {
            SRFExBaseFormAction baseFormAction = this.formActions.get(i);
            if (baseFormAction.getEnabled()) {
               writer.write(",");
               baseFormAction.Render(writer);
            }
         }

         writer.write("};\r\n");
         writer.write(StringHelper.Format("$P.form['%1$s']=new SRFFormMgr({form:%1$s});\r\n", this.getFormId()));
         StringBuilderEx script = new StringBuilderEx();
         script.Append("Ext.EventManager.on(window,'unload',function(){");
         script.Append("delete %1$s._MGR;%1$s._MGR=null;delete %1$s;", this.getFormId());
         script.Append("%1$s=null;});", this.getFormId());
         writer.write(script.toString());
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   protected void PrepareParams() {
      this.SetParam("formid", StringHelper.Format("'%1$s'", this.getFormId()));
      this.SetParam("_URL", StringHelper.Format("'%1$s'", this.getRemotePath()));
   }

   protected void RenderSystemActions(Writer writer) throws IOException {
   }

   public Vector getFormControls() {
      return this.formControls;
   }

   public synchronized void AddFormAction(SRFExBaseFormAction formAction) {
      formAction.setForm(this);
      this.formActions.add(formAction);
   }

   public synchronized void RemoveFormAction(SRFExBaseFormAction formAction) {
      this.formActions.remove(formAction);
   }

   public synchronized void RemoveFormAction(String strActionName) {
      for (SRFExBaseFormAction formAction : this.formActions) {
         if (StringHelper.Compare(strActionName, formAction.strActionName, false) == 0) {
            this.formActions.remove(formAction);
            break;
         }
      }
   }

   public synchronized SRFExBaseFormAction GetFormAction(String strActionName) {
      for (SRFExBaseFormAction formAction : this.formActions) {
         if (StringHelper.Compare(strActionName, formAction.strActionName, false) == 0) {
            return formAction;
         }
      }

      return null;
   }

   public synchronized void AddControl(SRFExControl srfControl) {
      this.formControls.add(srfControl);
      if (srfControl instanceof ISRFExFormItem) {
         ISRFExFormItem formItem = (ISRFExFormItem)srfControl;
         formItem.setForm(this);
      }

      this.formControlMap.put(srfControl.getID().toUpperCase(), srfControl);
   }

   public synchronized void RemoveControl(SRFExControl srfControl) {
      if (this.formControls.contains(srfControl)) {
         ISRFExFormItem formItem = (ISRFExFormItem)srfControl;
         formItem.setForm(null);
         this.formControls.remove(srfControl);
         this.formControlMap.remove(srfControl.getID().toUpperCase());
      }
   }

   public synchronized SRFExControl FindControl(String strControlId) {
      return this.InternalFindControl(strControlId);
   }

   public void FillDataEntityDV(BaseDataEntity dataEntity) {
      this.FillDataEntityDV(dataEntity, false);
   }

   public void FillDataEntityDV(BaseDataEntity dataEntity, boolean bUpdate) {
      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if (formItem.getFormItemConfig() != null
               && (!bUpdate ? !dataEntity.ContainesParam(childControl.getID()) : dataEntity.GetParamValue(childControl.getID()) == null)) {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               String strDVT = "";
               String strDV = "";
               if (!bUpdate) {
                  strDVT = formItemConfig.getDVT();
                  strDV = formItemConfig.getDV();
               } else {
                  strDVT = formItemConfig.getDVT2();
                  strDV = formItemConfig.getDV2();
               }

               if (StringHelper.Length(strDVT) != 0 || StringHelper.Length(strDV) != 0) {
                  dataEntity.SetParamValue(
                     childControl.getID(), DADVHelper.GetDefaultValue(this.getPage().getWebContext(), strDVT, strDV, formItemConfig.getDataType(), dataEntity)
                  );
               }
            }
         }
      }
   }

   public boolean FillDataEntity(BaseDataEntity dataEntity, boolean bIgnoreEmpty, SRFExFormItemErrors formItemErrors) {
      return this.FillDataEntity(dataEntity, bIgnoreEmpty, formItemErrors, true);
   }

   public boolean FillDataEntity(BaseDataEntity dataEntity, boolean bIgnoreEmpty, SRFExFormItemErrors formItemErrors, boolean bUniqueId) {
      boolean bRet = true;
      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if (formItem.getFormItemConfig() != null) {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               if (StringHelper.Length(formItemConfig.getValueTransform()) > 0) {
                  ISRFExFormItemValueTransform iFormItemValueTransform = this.getPage()
                     .getWebContext()
                     .getValueTransformMgr()
                     .GetFormItemValueTransform(formItemConfig.getValueTransform());
                  if (iFormItemValueTransform != null) {
                     iFormItemValueTransform.Transform(this.getPage().getWebContext(), formItem);
                  } else {
                     log.error(StringHelper.Format("无法获取表单值转换对象[%1$s]", formItemConfig.getValueTransform()));
                  }
               }
            }
         }
      }

      WebFormValueRuleEngineContext valueRuleEngineContext = new WebFormValueRuleEngineContext();
      valueRuleEngineContext.setDataEntity(dataEntity);
      valueRuleEngineContext.setDBCallerHelper(this.getPage().getWebContext().getDBCaller());
      valueRuleEngineContext.setValueRuleMgr(this.getPage().getWebContext().getValueRuleMgr());
      valueRuleEngineContext.setForm(this);
      DefaultValueRuleEngine valueRuleEngine = new DefaultValueRuleEngine();
      FormValueRuleConfig formValueRuleConfig = null;
      if (StringHelper.Length(this.getFormValueRuleId()) > 0) {
         formValueRuleConfig = this.getPage().getWebContext().getValueRuleMgr().GetFormValueRuleConfig(this.getFormValueRuleId());
         if (formValueRuleConfig == null) {
            log.error(StringHelper.Format("定义了表单值规则[%1$s]，但无法获取对应的配置。", this.getFormValueRuleId()));
         }
      }

      StringLengthsConfig stringLengthsConfig = this.getPage().getWebContext().getStringLengthMgr().GetStringLengthsConfig();
      ISRFExFormItemRuleEngine formItemRuleEngine = CreateFormItemRuleEngine(this, dataEntity);
      IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if ((!(childControl instanceof ISRFExFormItem3) || ((ISRFExFormItem3)childControl).IsSupportModify()) && formItem.getFormItemConfig() != null) {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               if (!this.isEnableItemPrivilege()
                  || StringHelper.IsNullOrEmpty(formItemConfig.getPrivilegeId())
                  || iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), formItemConfig.getPrivilegeId()) == 3) {
                  String strValue = "";
                  if (bUniqueId) {
                     strValue = formItem.getValue();
                  } else {
                     strValue = this.getPage().getRequest().getParameter(formItemConfig.getDBField().toLowerCase());
                  }

                  if (strValue != null) {
                     strValue = strValue.trim();
                     if (!StringHelper.IsNullOrEmpty(formItemConfig.getStringCase())) {
                        if (StringHelper.Compare(formItemConfig.getStringCase(), "UCASE", true) == 0) {
                           strValue = strValue.toUpperCase();
                        } else {
                           strValue = strValue.toLowerCase();
                        }
                     }
                  }

                  String strBackupValue = strValue;
                  if (StringHelper.Length(strValue) == 0) {
                     if (!bIgnoreEmpty) {
                        if (!StringHelper.IsNullOrEmpty(formItemConfig.getAllowEmptyCond())) {
                           String strValidCode = formItemConfig.getValidCond();
                           if (StringHelper.Compare(strValidCode, "NONE", true) == 0) {
                              dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                           } else {
                              if (StringHelper.Compare(strValidCode, "CREATE", true) == 0) {
                                 if (this.isUpdateMode()) {
                                    dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                    continue;
                                 }
                              } else if (StringHelper.Compare(strValidCode, "UPDATE", true) == 0 && !this.isUpdateMode()) {
                                 dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                 continue;
                              }

                              if (formItemRuleEngine == null) {
                                 log.error("定义了是否允许为空动态监测语句，但没有对应的引擎解释");
                                 bRet = false;
                              } else if (!formItemRuleEngine.TestAllowEmpty(formItemConfig)) {
                                 formItemErrors.Register(
                                    bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                                    formItemConfig.getErrorRegionId(),
                                    1,
                                    GetFormItemErrorMsg(this.getPage(), 1, formItemConfig)
                                 );
                                 bRet = false;
                              } else {
                                 dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                              }
                           }
                        } else if (!formItemConfig.getAllowEmpty()) {
                           formItemErrors.Register(
                              bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                              formItemConfig.getErrorRegionId(),
                              1,
                              GetFormItemErrorMsg(this.getPage(), 1, formItemConfig)
                           );
                           bRet = false;
                        } else {
                           dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                        }
                     }
                  } else {
                     boolean bCheckRule = true;
                     String strValidCode = formItemConfig.getValidCond();
                     if (StringHelper.Compare(strValidCode, "NONE", true) == 0) {
                        bCheckRule = false;
                     } else if (StringHelper.Compare(strValidCode, "CREATE", true) == 0) {
                        if (this.isUpdateMode()) {
                           bCheckRule = false;
                        }
                     } else if (StringHelper.Compare(strValidCode, "UPDATE", true) == 0 && !this.isUpdateMode()) {
                        bCheckRule = false;
                     }

                     strValue = strBackupValue;
                     Object objValue = this.GetFormItemValue(strValue, formItemConfig);
                     if (objValue == null) {
                        formItemErrors.Register(
                           bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                           formItemConfig.getErrorRegionId(),
                           2,
                           GetFormItemErrorMsg(this.getPage(), 2, formItemConfig)
                        );
                        bRet = false;
                     } else {
                        objValue = ConvertValue(objValue, formItemConfig);
                        if (bCheckRule) {
                           if (objValue instanceof String) {
                              int nMaxLength = formItemConfig.getMaxLength();
                              if (nMaxLength == 0) {
                                 nMaxLength = stringLengthsConfig.getStringMaxLength(formItemConfig.getDBField());
                              }

                              if (nMaxLength > 0 && StringHelper.Length(objValue.toString()) > nMaxLength) {
                                 formItemErrors.Register(
                                    bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                                    formItemConfig.getErrorRegionId(),
                                    3,
                                    GetFormItemMaxLengthErrorMsg(this.getPage(), formItemConfig, nMaxLength)
                                 );
                                 bRet = false;
                                 continue;
                              }
                           }

                           ValueRuleConfig valueRuleConfig = formItemConfig.getValueRuleConfig();
                           if (valueRuleConfig == null && StringHelper.Length(formItemConfig.getValueRuleId()) > 0) {
                              valueRuleConfig = this.getPage().getWebContext().getValueRuleMgr().GetValueRuleConfig(formItemConfig.getValueRuleId());
                           }

                           if (valueRuleConfig == null && formValueRuleConfig != null) {
                              valueRuleConfig = formValueRuleConfig.GetFormItemValueRuleConfig(formItemConfig.getRealFormItemId());
                           }

                           if (valueRuleConfig != null) {
                              valueRuleEngineContext.setErrorMessage("");
                              valueRuleEngineContext.setDataType(formItemConfig.getDataType());
                              valueRuleEngineContext.setValue(objValue);
                              valueRuleEngineContext.setErrorMessage("");
                              if (!valueRuleEngine.Check(valueRuleEngineContext, valueRuleConfig)) {
                                 formItemErrors.Register(
                                    bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                                    formItemConfig.getErrorRegionId(),
                                    3,
                                    GetFormItemErrorMsg(this.getPage(), formItemConfig, valueRuleEngineContext.getErrorMessage())
                                 );
                                 bRet = false;
                                 continue;
                              }
                           }

                           if (!StringHelper.IsNullOrEmpty(formItemConfig.getValueRuleCode()) && formItemRuleEngine != null) {
                              dataEntity.SetParamValue(formItemConfig.getDBField(), objValue);
                              boolean bTestRet = formItemRuleEngine.TestValueRule(formItemConfig, objValue, strValue);
                              dataEntity.RemoveParam(formItemConfig.getDBField());
                              if (!bTestRet) {
                                 formItemErrors.Register(
                                    bUniqueId ? childControl.getUniqueID() : formItemConfig.getDBField(),
                                    formItemConfig.getErrorRegionId(),
                                    3,
                                    formItemConfig.getValueRuleInfo()
                                 );
                                 bRet = false;
                                 continue;
                              }
                           }
                        }

                        dataEntity.SetParamValue(formItemConfig.getDBField(), objValue);
                     }
                  }
               }
            }
         }
      }

      return bRet;
   }

   public boolean FillByDataEntity(BaseDataEntity dataEntity, boolean bCopyMode) {
      if (dataEntity == null) {
         return false;
      }

      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            String strPrivilegeId = formItem.getFormItemConfig().getPrivilegeId();
            if (!StringHelper.IsNullOrEmpty(strPrivilegeId)) {
               String strHiddenItemId = StringHelper.Format("SRFIP_%1$s", formItem.getFormItemConfig().getDBField());
               if ((this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) {
                  dataEntity.SetParamValue(strHiddenItemId, 0);
               } else {
                  dataEntity.SetParamValue(strHiddenItemId, 1);
               }
            }
         }
      }

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            String strPrivilegeId = formItem.getFormItemConfig().getPrivilegeId();
            if (!StringHelper.IsNullOrEmpty(strPrivilegeId)
               && (this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) {
               continue;
            }
         }

         if (childControl instanceof ISRFExFormItemEx) {
            ISRFExFormItemEx formItemEx = (ISRFExFormItemEx)childControl;
            formItemEx.setValue(dataEntity);
         } else if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if (formItem.getFormItemConfig() == null) {
               formItem.setValue("");
            } else {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               if (formItemConfig.getKey() && bCopyMode) {
                  formItem.setValue("");
               } else {
                  formItem.setValue(formItemConfig.GetFormItemValue(this.curPage.getWebContext(), dataEntity));
               }
            }
         } else {
            log.error(StringHelper.Format("无法填充对象[%1$s]", childControl.getUniqueID()));
         }
      }

      return true;
   }

   public void EnableFormItems(boolean bCreate) {
      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if (formItem.getFormItemConfig() != null) {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               formItem.setEnabled(
                  StringHelper.Compare(formItemConfig.getEnableCond(), "ALL", true) == 0
                     || bCreate && StringHelper.Compare(formItemConfig.getEnableCond(), "CREATE", true) == 0
                     || !bCreate && StringHelper.Compare(formItemConfig.getEnableCond(), "UPDATE", true) == 0
               );
            }
         }
      }
   }

   public void DisableFormItems(Hashtable formItemMap, boolean bInclude) {
      if (formItemMap != null) {
         int nChildControlCount = this.formControls.size();

         for (int i = 0; i < nChildControlCount; i++) {
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem) {
               ISRFExFormItem formItem = (ISRFExFormItem)childControl;
               if (bInclude) {
                  if (formItemMap.containsKey(childControl.getID().toUpperCase())) {
                     formItem.setEnabled(false);
                  }
               } else if (!formItemMap.containsKey(childControl.getID().toUpperCase())) {
                  formItem.setEnabled(false);
               }
            }
         }
      }
   }

   public void RemoveInvalidValue(BaseDataEntity dataEntity, boolean bCreate) {
      ISRFExFormItemRuleEngine formItemRuleEngine = CreateFormItemRuleEngine(this, dataEntity);
      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)childControl;
            if (formItem.getFormItemConfig() != null) {
               FormItemConfig formItemConfig = formItem.getFormItemConfig();
               if (!formItemConfig.getKey()) {
                  String strValidCond = formItemConfig.getValidCond();
                  if (!StringHelper.IsNullOrEmpty(strValidCond)) {
                     if (StringHelper.Compare(strValidCond, "NONE", true) == 0) {
                        dataEntity.RemoveParam(formItemConfig.getDBField());
                     } else if (StringHelper.Compare(strValidCond, "ALL", true) != 0) {
                        if (StringHelper.Compare(strValidCond, "CREATE", true) == 0) {
                           if (!bCreate) {
                              dataEntity.RemoveParam(formItemConfig.getDBField());
                           }
                        } else if (StringHelper.Compare(strValidCond, "UPDATE", true) == 0) {
                           if (bCreate) {
                              dataEntity.RemoveParam(formItemConfig.getDBField());
                           }
                        } else if (formItemRuleEngine != null && !formItemRuleEngine.TestProcess(formItemConfig)) {
                           dataEntity.RemoveParam(formItemConfig.getDBField());
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected Object GetFormItemValue(String strValue, FormItemConfig formItemConfig) {
      Object objValue = DataTypeParse.Parse(formItemConfig.getDataType(), strValue);
      if (SRFGlobal.isMultiTimeZone() && DataTypeParse.IsDateTimeDataType(formItemConfig.getDataType()) && DateParser.isDateTimeType(objValue)) {
         objValue = DateParser.AdjustByTimeZone(objValue, this.getPage().getWebContext().getCurTimeZone(), true);
      }

      return objValue;
   }

   protected static String GetFormItemErrorMsg(int nErrorType, FormItemConfig formItemConfig) {
      switch (nErrorType) {
         case 1:
            return StringHelper.Format("【%1$s】 不能输入为空，必须为其指定值", formItemConfig.getName());
         case 2:
            return StringHelper.Format("【%1$s】 输入内容不正确，必须输入类型为[%2$s]的值", formItemConfig.getName(), DataTypeHelper.GetTypeName(formItemConfig.getDataType()));
         default:
            return StringHelper.Format("【%1$s】 输入不正确", formItemConfig.getName());
      }
   }

   protected static String GetFormItemErrorMsg(SRFExPage page, int nErrorType, FormItemConfig formItemConfig) {
      switch (nErrorType) {
         case 1:
            return StringHelper.Format(page.GetLocalization("ERROR.STD.FORM.NOTALLOWEMPTY", "【%1$s】 不能输入为空，必须为其指定值"), formItemConfig.getName());
         case 2:
            return StringHelper.Format(
               page.GetLocalization("ERROR.STD.FORM.INVALIDDATATYPE", "【%1$s】 输入内容不正确，必须输入类型为[%2$s]的值"),
               formItemConfig.getName(),
               DataTypeHelper.GetTypeName(formItemConfig.getDataType())
            );
         default:
            return StringHelper.Format(page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE", "【%1$s】 输入不正确"), formItemConfig.getName());
      }
   }

   protected static String GetFormItemMaxLengthErrorMsg(FormItemConfig formItemConfig, int nLength) {
      return StringHelper.Format("【%1$s】 输入内容不正确，输入内容的长度不得大于[%2$s](含%2$s)", formItemConfig.getName(), nLength);
   }

   protected static String GetFormItemMaxLengthErrorMsg(SRFExPage page, FormItemConfig formItemConfig, int nLength) {
      return StringHelper.Format(
         page.GetLocalization("ERROR.STD.FORM.MAXLENGTHEXCEED", "【%1$s】 输入内容不正确，输入内容的长度不得大于[%2$s](含%2$s)"), formItemConfig.getName(), nLength
      );
   }

   protected static String GetFormItemErrorMsg(FormItemConfig formItemConfig, String strErrorMsg) {
      return StringHelper.Length(strErrorMsg) > 0
         ? StringHelper.Format("【%1$s】 输入不正确，请确认您的输入符合以下规则：%2$s", formItemConfig.getName(), strErrorMsg)
         : StringHelper.Format("【%1$s】 输入不正确", formItemConfig.getName());
   }

   protected static String GetFormItemErrorMsg(SRFExPage page, FormItemConfig formItemConfig, String strErrorMsg) {
      return StringHelper.Length(strErrorMsg) > 0
         ? StringHelper.Format(page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE2", "【%1$s】 输入不正确，请确认您的输入符合以下规则：%2$s"), formItemConfig.getName(), strErrorMsg)
         : StringHelper.Format(page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE", "【%1$s】 输入不正确"), formItemConfig.getName());
   }

   private SRFExControl InternalFindControl(String strControlId) {
      if (this.formControls != null && this.formControlMap != null) {
         SRFExControl control = this.formControlMap.get(strControlId.toUpperCase());
         if (control != null) {
            return control;
         }

         log.error(StringHelper.Format("[%1$s]无法定位表单控件[%2$s]", this.getPage().getWebContext().getCurPagePath(), strControlId));
         return null;
      } else {
         log.error(StringHelper.Format("表单控件集合无效"));
         return null;
      }
   }

   public void FillValueJSON(Vector vector, boolean bUniId) {
      this.FillValueJSON(vector, bUniId, null);
   }

   public void FillValueJSON(Vector vector, boolean bUniId, TreeMap<String, Integer> fillControlMap) {
      if (this.formControls != null) {
         IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
         HashMap<String, Integer> itemPrivilegeMap = new HashMap<>();
         if (this.updateHtmlList != null) {
            Vector updatelist = new Vector();
            Enumeration en = this.updateHtmlList.keys();

            while (en.hasMoreElements()) {
               String strFormItemId = (String)en.nextElement();
               if (fillControlMap == null || fillControlMap.containsKey(strFormItemId.toUpperCase())) {
                  SRFExControl control = this.FindControl(strFormItemId);
                  if (control != null && control instanceof ISRFExFormItem2) {
                     ISRFExFormItem2 iFormItem2 = (ISRFExFormItem2)control;
                     iFormItem2.UpdateItem(updatelist);
                     if (this.isEnableItemPrivilege() && !StringHelper.IsNullOrEmpty(iFormItem2.getFormItemConfig().getPrivilegeId())) {
                        itemPrivilegeMap.put(
                           control.getUniqueID(), iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), iFormItem2.getFormItemConfig().getPrivilegeId())
                        );
                     }
                  }
               }
            }

            int nCount = updatelist.size();

            for (int i = 0; i < nCount; i++) {
               Object obj = updatelist.get(i);
               if (obj != null && obj instanceof JSONObject) {
                  JSONObject jsonObj = (JSONObject)obj;
                  jsonObj.put("_T", 1);
                  if (this.isEnableItemPrivilege()) {
                     Integer nRet = itemPrivilegeMap.get(jsonObj.getString("id"));
                     if (nRet != null) {
                        jsonObj.put("_P", nRet);
                        if (nRet == 0) {
                           jsonObj.remove("html");
                           jsonObj.put("html", "");
                        }
                     }
                  }

                  vector.add(jsonObj);
               }
            }
         }

         Vector valuelist = new Vector();
         int nChildControlCount = this.formControls.size();

         for (int i = 0; i < nChildControlCount; i++) {
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if ((fillControlMap == null || fillControlMap.containsKey(childControl.getID().toUpperCase())) && childControl instanceof ISRFExFormItem) {
               ISRFExFormItem formItem = (ISRFExFormItem)childControl;
               if (formItem.getFormItemConfig().getEndOfDay()) {
                  Vector tempList = new Vector();
                  formItem.FillValueJSON(tempList, bUniId);
                  if (tempList.size() >= 1) {
                     if (tempList.size() == 1) {
                        JSONObject jo = (JSONObject)tempList.get(0);
                        if (jo.has("value")) {
                           String strValue = jo.getString("value");
                           if (!StringHelper.IsNullOrEmpty(strValue)) {
                              Object objValue = DataTypeParse.TestDateTime(strValue);
                              Timestamp endTime = (Timestamp)objValue;
                              Calendar cal = Calendar.getInstance();
                              cal.setTime(new Date(endTime.getTime()));
                              cal.set(11, 23);
                              cal.set(12, 59);
                              cal.set(13, 59);
                              endTime.setTime(cal.getTime().getTime());
                              strValue = DateParser.toDateTimeString(new Date(endTime.getTime()));
                              jo.remove("value");
                              jo.put("value", strValue);
                           }
                        }
                     }

                     valuelist.addAll(tempList);
                  }
               } else {
                  formItem.FillValueJSON(valuelist, bUniId);
               }

               if (this.isEnableItemPrivilege() && !StringHelper.IsNullOrEmpty(formItem.getFormItemConfig().getPrivilegeId())) {
                  itemPrivilegeMap.put(
                     childControl.getUniqueID(), iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), formItem.getFormItemConfig().getPrivilegeId())
                  );
               }
            }
         }

         int nCount = valuelist.size();

         for (int i = 0; i < nCount; i++) {
            Object obj = valuelist.get(i);
            if (obj != null && obj instanceof JSONObject) {
               JSONObject jsonObj = (JSONObject)obj;
               jsonObj.put("_T", 0);
               if (this.isEnableItemPrivilege()) {
                  Integer nRet = itemPrivilegeMap.get(jsonObj.getString("id"));
                  if (nRet != null) {
                     jsonObj.put("_P", nRet);
                     if (nRet == 0) {
                        jsonObj.remove("value");
                        jsonObj.put("value", "");
                     }
                  }
               }

               vector.add(jsonObj);
            }
         }
      }
   }

   public void FillValueJSON(Vector vector) {
      this.FillValueJSON(vector, true);
   }

   public void SetParam(String strParamName, String strParamValue) {
      if (this.paramList == null) {
         this.paramList = new Hashtable();
      }

      this.paramList.put(strParamName, strParamValue);
   }

   public void RemoveParam(String strParamName) {
      if (this.paramList != null) {
         this.paramList.remove(strParamName);
      }
   }

   public String GetParam(String strParamName) {
      if (this.paramList == null) {
         return "";
      } else {
         return this.paramList.containsKey(strParamName) ? (String)this.paramList.get(strParamName) : "";
      }
   }

   public void ResetParam() {
      if (this.paramList != null) {
         this.paramList.clear();
         this.paramList = null;
      }
   }

   protected void RenderParams(Writer writer) throws IOException {
      if (this.paramList != null) {
         boolean bFirst = true;
         Enumeration en = this.paramList.keys();

         while (en.hasMoreElements()) {
            String strParam = (String)en.nextElement();
            String strValue = (String)this.paramList.get(strParam);
            if (!bFirst) {
               writer.write(",\r\n");
            } else {
               bFirst = false;
            }

            writer.write(StringHelper.Format("%1$s:%2$s", strParam, strValue));
         }
      }
   }

   public void EnableFormItem(String strFormItemId, boolean bEnabled) {
      SRFExControl control = this.FindControl(strFormItemId);
      if (control != null) {
         if (control instanceof ISRFExFormItem) {
            ISRFExFormItem iFormItem = (ISRFExFormItem)control;
            iFormItem.setEnabled(bEnabled);
         }
      }
   }

   public boolean isEnableFormItem(String strFormItemId) {
      SRFExControl control = this.FindControl(strFormItemId);
      if (control == null) {
         return false;
      } else if (control instanceof ISRFExFormItem) {
         ISRFExFormItem iFormItem = (ISRFExFormItem)control;
         return iFormItem.getEnabled();
      } else {
         return false;
      }
   }

   public void EnableAllFormItems(boolean bEnabled) {
      int nChildControlCount = this.formControls.size();

      for (int i = 0; i < nChildControlCount; i++) {
         SRFExControl childControl = (SRFExControl)this.formControls.get(i);
         if (childControl instanceof ISRFExFormItem) {
            ISRFExFormItem iFormItem = (ISRFExFormItem)childControl;
            iFormItem.setEnabled(bEnabled);
         }
      }
   }

   public void UpdateFormItem(String strFormItemId) {
      if (this.updateHtmlList == null) {
         this.updateHtmlList = new Hashtable();
      }

      this.updateHtmlList.put(strFormItemId, "");
   }

   public void UpdateFormItemCodeList(String strFormItemId, String strCodeListId) {
      SRFExControl control = this.FindControl(strFormItemId);
      if (control != null) {
         if (control instanceof SRFExListControl) {
            SRFExListControl listControl = (SRFExListControl)control;
            listControl.getListControlConfig().getListItems().Clear();
            listControl.getListControlConfig().getListFillerConfig().setCodeList(strCodeListId);
            listControl.ReloadConfig();
            this.UpdateFormItem(strFormItemId);
         }
      }
   }

   public String GetFormItemUniqueId(String strFormItemId) {
      SRFExControl control = this.FindControl(strFormItemId);
      return control == null ? "" : control.getUniqueID();
   }

   public ISRFExFormItem FindFormItem(String strFormItemId) {
      SRFExControl control = this.FindControl(strFormItemId);
      if (control == null) {
         return null;
      } else {
         return control instanceof ISRFExFormItem ? (ISRFExFormItem)control : null;
      }
   }

   public String getResourceId() {
      return this.strResourceId;
   }

   public void setResourceId(String strResourceId) {
      this.strResourceId = strResourceId;
   }

   private static ISRFExFormItemRuleEngine CreateFormItemRuleEngine(SRFExBaseForm form, BaseDataEntity dataEntity) {
      ISRFExFormItemRuleEngine iEngine = null;
      String strEngine = form.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "FORMITEMRULEENGINE", "");
      if (StringHelper.IsNullOrEmpty(strEngine)) {
         return null;
      }

      Object objEngine = ObjectHelper.Create(strEngine);
      if (objEngine != null && objEngine instanceof ISRFExFormItemRuleEngine) {
         iEngine = (ISRFExFormItemRuleEngine)objEngine;
      }

      return iEngine != null && iEngine.Init(form, dataEntity) ? iEngine : null;
   }

   public boolean isUpdateMode() {
      return this.bUpdateMode;
   }

   public void setUpdateMode(boolean bUpdateMode) {
      this.bUpdateMode = bUpdateMode;
   }

   public boolean isEnableItemPrivilege() {
      return this.bEnableItemPrivilege;
   }

   public void setEnableItemPrivilege(boolean bEnableItemPrivilege) {
      this.bEnableItemPrivilege = bEnableItemPrivilege;
   }

   private static Object ConvertValue(Object objValue, FormItemConfig formItemConfig) {
      if (objValue instanceof Float) {
         if (formItemConfig.getPrecision() >= 0) {
            BigDecimal bd = new BigDecimal(((Float)objValue).floatValue());
            bd = bd.setScale(formItemConfig.getPrecision(), 6);
            return bd.floatValue();
         } else {
            return objValue;
         }
      } else if (objValue instanceof Double) {
         if (formItemConfig.getPrecision() >= 0) {
            BigDecimal bd = new BigDecimal((Double)objValue);
            bd = bd.setScale(formItemConfig.getPrecision(), 6);
            return bd.doubleValue();
         } else {
            return objValue;
         }
      } else if (objValue instanceof Timestamp) {
         if (formItemConfig.getEndOfDay()) {
            Timestamp endTime = (Timestamp)objValue;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(endTime.getTime()));
            cal.set(11, 23);
            cal.set(12, 59);
            cal.set(13, 59);
            endTime.setTime(cal.getTime().getTime());
            return endTime;
         } else {
            return objValue;
         }
      } else if (objValue instanceof java.sql.Date) {
         if (formItemConfig.getEndOfDay()) {
            java.sql.Date endTime = (java.sql.Date)objValue;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(endTime.getTime()));
            cal.set(11, 23);
            cal.set(12, 59);
            cal.set(13, 59);
            endTime.setTime(cal.getTime().getTime());
            return endTime;
         } else {
            return objValue;
         }
      } else if (objValue instanceof Time) {
         if (formItemConfig.getEndOfDay()) {
            Time endTime = (Time)objValue;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(endTime.getTime()));
            cal.set(11, 23);
            cal.set(12, 59);
            cal.set(13, 59);
            endTime.setTime(cal.getTime().getTime());
            return endTime;
         } else {
            return objValue;
         }
      } else {
         return objValue;
      }
   }
}
