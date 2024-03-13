package study.stepup.lesson5.service.cheks;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.request.RequiredField;

import java.lang.reflect.Field;

@Component
@Order(1)
//проверка на обязательность реквизитов
public class CheckRequired implements ChecksProduct, ChecksAgreements {
    public void start(Object obj) {
        System.out.println("проверка на обязательность реквизитов" + obj.getClass().getTypeName());
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RequiredField.class)) {
                field.setAccessible(true);

                try {
                    if (field.get(obj) == null || field.get(obj).toString().equals("")
                            || field.get(obj).toString().equals("0"))
                        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST
                                , ": Имя обязательного параметра <" + field.getName() + "> не заполнено.");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
