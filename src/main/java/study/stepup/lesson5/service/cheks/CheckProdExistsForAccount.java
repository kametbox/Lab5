package study.stepup.lesson5.service.cheks;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.ProductRegister;
import study.stepup.lesson5.model.request.AccountModel;
import study.stepup.lesson5.repository.ProductRegisterRepository;


@Component
@RequiredArgsConstructor
@Order(3)
//проверка наличия продукта для контроля Создания доп.соглашения
public class CheckProdExistsForAccount implements ChecksAccount {
    private final ProductRegisterRepository productRegisterRepository;
    public void start(AccountModel accountModel) {
        ProductRegister productRegister = productRegisterRepository.findFirstByProductId_Id(accountModel.getInstanceId());
        //System.out.println("проверка наличия продукта для привязки счета");
        if(productRegister == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND
                    , ": Экземпляр продукта с параметром instanceId <" + accountModel.getInstanceId() + "> не найден");
        }
        if(productRegister.getAccountNumber() != null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND
                    , ": Экземпляр продукта с параметром instanceId <" + accountModel.getInstanceId() + "> не найден");
        }

    }
}
