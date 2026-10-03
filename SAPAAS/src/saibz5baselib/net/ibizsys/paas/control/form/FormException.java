package net.ibizsys.paas.control.form;

/**
 * 表单处理异常对象
 * 
 * @author lionlau
 *
 */
public class FormException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormError formError = null;

	/**
	 * 表单错误对象
	 * 
	 * @param formError
	 */
	public FormException(FormError formError) {
		super();
		this.formError = formError;

	}

	/**
	 * 获取表单错误对象
	 * 
	 * @return
	 */
	public FormError getFormError() {
		return this.formError;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		if (formError != null) return formError.toString();
		return super.getMessage();
	}
}
