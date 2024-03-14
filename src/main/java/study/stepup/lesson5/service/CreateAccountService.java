package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.Account;
import study.stepup.lesson5.model.data.AccountPool;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.AccountModel;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.model.response.ResponseAccountId;
import study.stepup.lesson5.model.response.ResponseProduct;
import study.stepup.lesson5.repository.AccountPoolRepository;
import study.stepup.lesson5.repository.AccountRepository;
import study.stepup.lesson5.service.cheks.CheckRequired;
import study.stepup.lesson5.service.cheks.ChecksAccount;
import study.stepup.lesson5.service.cheks.ChecksProduct;
import study.stepup.lesson5.service.cheks.ChecksRequestModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateAccountService {
    private final List<ChecksAccount> checksAccounts;
    private final List<ChecksRequestModel> checksRequestModelList;
    private final AccountPoolRepository accountPoolRepository;
    private final AccountRepository accountRepository;


    public ResponseAccountId create(AccountModel accountModel){
        System.out.println("CreateAccountService.create " + "accountModel.getInstanceId()= "+ accountModel.getInstanceId());

        //контроль модели на обязательность реквизитов
        checksRequestModelList.forEach(x -> x.start(accountModel));

        //выполняем контроли Account
        checksAccounts.forEach(x -> x.start(accountModel));

        //ищем счет в пуле счетов и длобавляем его в продуктовый регистр
        System.out.println("accountModel"+ "\n" + accountModel.getBranchCode()+"\n"+
                accountModel.getCurrencyCode()+"\n"+
                accountModel.getMdmCode()+"\n"+
                accountModel.getPriorityCode()+"\n"+
                accountModel.getRegistryTypeCode());
        AccountPool accountPool = accountPoolRepository
                .findFirstByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                        accountModel.getBranchCode(),
                        accountModel.getCurrencyCode(),
                        accountModel.getMdmCode(),
                        accountModel.getPriorityCode(),
                        accountModel.getRegistryTypeCode()
                );
        System.out.println("accountPool"+accountPool);
        //берем первый счет
        Account account = accountRepository.findFirstByAccountPoolId(accountPool);
        System.out.println("account"+account);

        if (account == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND
                , ": Для продукта с параметром instanceId <" + accountModel.getInstanceId() + "> счет с указанными параметрами отсутствует в пуле счетов");


        ResponseAccountId responseAccountId = new ResponseAccountId(String.valueOf(account.getId()));
        System.out.println(responseAccountId);


        return responseAccountId;
    }
}
