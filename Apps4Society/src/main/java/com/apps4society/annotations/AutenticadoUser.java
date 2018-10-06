package com.apps4society.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutenticadoUser {
	/*
	 * Target: vou passar essa anotação, como parametro para cadastro de municipios e attr
	 * Userloogado
	 * @Retention: Indica por quanto tempo as anotações com o tipo anotado devem ser retidas(Runtime)
	 * @Documented: Essa anotação pode ser anotada em um javadoc por exemplo
	 */

}
