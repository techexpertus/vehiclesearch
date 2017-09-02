package cucumber.runtime.java.spring;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Scope("cucumber-glue")
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScenarioScoped {
}
