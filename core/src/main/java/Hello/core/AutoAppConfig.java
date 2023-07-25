package Hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// ComponentScan이 Component가 붙은 모든 클래스를 스프링 빈으로 등록

@Configuration
@ComponentScan(
        basePackages = "Hello.core",        // 해당 위치부터 컴포넌트스캔 대상이 됨
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 수동으로 등록한 AppConfig는 자동으로 등록되지 않도록 제외시킴
        // 보통 사용하는 방법은 아니지만 예제 코드를 유지하기 위해 사용
)
public class AutoAppConfig {

}
