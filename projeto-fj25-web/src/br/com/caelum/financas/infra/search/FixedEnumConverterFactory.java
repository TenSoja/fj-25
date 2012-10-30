package br.com.caelum.financas.infra.search;

import javax.faces.application.Application;

import com.sun.faces.application.ApplicationFactoryImpl;

public class FixedEnumConverterFactory extends ApplicationFactoryImpl {  
	private Application application;

	@Override
	public Application getApplication() {
		if (application == null) {
			application = new FixedEnumConverter();
		}
		return application;
	}
}
