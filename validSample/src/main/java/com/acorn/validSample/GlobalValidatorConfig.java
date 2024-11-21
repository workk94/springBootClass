package com.acorn.validSample;


import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//global validator로 등록하기

@Configuration
public class GlobalValidatorConfig implements WebMvcConfigurer {

    @Override
    public Validator getValidator() {
        return new OrderValidator(); //  global  커스텀 Validator 등록
    }
}



/*
스프링부트 :
spring.messages.basename=errors


스프링:
메시지 등록
	<!--  error_message.properties  정보 등록
	  -->
	<beans:bean     id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<beans:property name="basenames">
			<beans:list>
				<beans:value>error_message</beans:value>

		<!--  value 값이 실제 파일이름과 같아야 한다.
		      확장자. properties 임 -->
        <!-- /src/main/resources/error_message.properties  -->
			</beans:list>
		</beans:property>
		<beans:property name="defaultEncoding" value="UTF-8"/>
	</beans:bean>



 */