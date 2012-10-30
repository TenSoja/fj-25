package br.com.caelum.financas.infra.search;

import javax.faces.convert.Converter;

import com.sun.faces.application.ApplicationImpl;

@SuppressWarnings("rawtypes")
public class FixedEnumConverter extends ApplicationImpl {  

	@Override
	protected Converter createConverterBasedOnClass(Class targetClass, Class baseClass) {
		if (targetClass.isEnum()
				&& baseClass.getName().contains(targetClass.getName())
				&& baseClass.getName().contains("$")) {
			
			return super.createConverterBasedOnClass(Enum.class, targetClass);
		} else {
			return super.createConverterBasedOnClass(targetClass, baseClass);
		}
    }  

}
