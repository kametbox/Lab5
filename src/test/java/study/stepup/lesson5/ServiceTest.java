package study.stepup.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.Agreement;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.data.ProductRegisterType;
import study.stepup.lesson5.model.request.AccountModel;
import study.stepup.lesson5.model.request.AdditionalPropertiesModel;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.AgreementsRepository;
import study.stepup.lesson5.repository.ProductRegisterTypeRepository;
import study.stepup.lesson5.repository.ProductRepository;
import study.stepup.lesson5.service.cheks.CheckDoubleAgreements;
import study.stepup.lesson5.service.cheks.CheckDoubleProduct;
import study.stepup.lesson5.service.cheks.CheckProductRegisterType;
import study.stepup.lesson5.service.cheks.CheckRequired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServiceTest {
    AccountModel accountModel;
    AccountModel accountModel2;
    AgreementModel agreementModel1;
    AgreementModel agreementModel2;
    ProductModel productModel1;
    ProductModel productModel2;
    ProductModel productModel3;

    @BeforeEach
    public void initData() throws ParseException {
        //подготовим данные перед выполнением тестов
        accountModel = new AccountModel(1, "03.012.002_47533_ComSoLd", "Клиентский", "800",
                "0022", "00", "15", "", "15-12345", "ABC", "123");
        accountModel2 = new AccountModel(0, "03.012.002_47533_ComSoLd", "Клиентский", "800",
                "0022", "00", "15", "", "15-12345", "ABC", "123");
        agreementModel1 = new AgreementModel("123", "456", "НСО",
                123456789, "НСО-123", "2024-01-11", "2025-01-10", "",
                365, "", "открыт", "", 0, 0,
                "", 0, 0, "",
                0, 0, "");
        agreementModel2 = new AgreementModel("789", "456", "СМО",
                123456789, "СМО-789", "2024-01-13", "2024-01-13", "",
                365, "", "открыт", "", 0, 0,
                "", 0, 0, "",
                0, 0, "");
        productModel1 = new ProductModel(1, "ДОГОВОР", "03.012.002", "03.012.002_47533_ComSoLd",
                "15", "2024-01-10-000001", new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-10"), 2, 12.25F,
                0F, 0F, "qwerty", "0", 13F, 1000F,
                112233, "0022", "800", "00", 1234, new AdditionalPropertiesModel(),
                new ArrayList<>(Arrays.asList(agreementModel1, agreementModel2)));
        productModel2 = new ProductModel(1, "", "", "",
                "", "", new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-10"), 2, 12.25F,
                0F, 0F, "qwerty", "0", 13F, 1000F,
                0, "0022", "800", "00", 1234, new AdditionalPropertiesModel(),
                new ArrayList<>());
        productModel3 = new ProductModel(null, "", "", "",
                "", "", new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-10"), 2, 12.25F,
                0F, 0F, "qwerty", "0", 13F, 1000F,
                0, "0022", "800", "00", 1234, new AdditionalPropertiesModel(),
                new ArrayList<>());
        accountModel = new AccountModel(1, "03.012.002_47533_ComSoLd", "Клиентский",
                "800", "0022", "00", "15", "", "15-12345",
                "ABC", "123");

    }

    @Test
    public void CheckRequiredProductGood() {
        Assertions.assertDoesNotThrow(
                () -> new CheckRequired().start(productModel1)
        );
    }

    @Test
    public void CheckRequiredProductBad() {
        Assertions.assertThrows(HttpClientErrorException.class,
                () -> new CheckRequired().start(productModel2)
        );
    }

    @Test
    public void CheckRequiredAccountGood() {
        Assertions.assertDoesNotThrow(
                () -> new CheckRequired().start(accountModel)
        );
    }

    @Test
    public void CheckRequiredAccountBad() {
        Assertions.assertThrows(HttpClientErrorException.class,
                () -> new CheckRequired().start(accountModel2)
        );
    }

    @Test
    public void CheckDoubleProductGood() {

        ProductRepository mockRepo = Mockito.mock(ProductRepository.class);
        Mockito.when(mockRepo.findFirstByNumber(Mockito.any())).thenReturn(null);

        Assertions.assertDoesNotThrow(
                () -> new CheckDoubleProduct(mockRepo).start(productModel3)
        );
    }

    @Test
    public void CheckDoubleProductBad() {

        ProductRepository mockRepo = Mockito.mock(ProductRepository.class);
        Mockito.when(mockRepo.findFirstByNumber(Mockito.any())).thenReturn(new Product());

        Assertions.assertThrows(HttpClientErrorException.class,
                () -> new CheckDoubleProduct(mockRepo).start(productModel3)
        );
    }

    @Test
    public void CheckDoubleAgreementsGood() {

        ProductRepository mockRepoProd = Mockito.mock(ProductRepository.class);
        AgreementsRepository mockRepoAgr = Mockito.mock(AgreementsRepository.class);

        Mockito.when(mockRepoProd.findFirstByNumber(Mockito.any())).thenReturn(null);
        Mockito.when(mockRepoAgr.findFirstByProductAndNumber(Mockito.any(),Mockito.any())).thenReturn(null);

        Assertions.assertDoesNotThrow(
                () -> new CheckDoubleAgreements(mockRepoProd, mockRepoAgr).start(productModel1)
        );
    }

    @Test
    public void CheckDoubleAgreementsBad() {

        ProductRepository mockRepoProd = Mockito.mock(ProductRepository.class);
        AgreementsRepository mockRepoAgr = Mockito.mock(AgreementsRepository.class);

        Mockito.when(mockRepoProd.findFirstByNumber(Mockito.any())).thenReturn(new Product());
        Mockito.when(mockRepoAgr.findFirstByProductAndNumber(Mockito.any(),Mockito.any())).thenReturn(new Agreement());

        Assertions.assertThrows(HttpClientErrorException.class,
                () -> new CheckDoubleAgreements(mockRepoProd, mockRepoAgr).start(productModel1)
        );
    }
    @Test
    public void CheckProductRegisterTypeGood() {

        ProductRegisterTypeRepository mockRepo = Mockito.mock(ProductRegisterTypeRepository.class);
        Mockito.when(mockRepo.findFirstByProductClassCode_ValueAndAccountType_Value(Mockito.any(), Mockito.any())).thenReturn(null);

        Assertions.assertThrows(HttpClientErrorException.class,
                () -> new CheckProductRegisterType(mockRepo).start(productModel3)
        );
    }

    @Test
    public void CheckProductRegisterTypeBad() {

        ProductRegisterTypeRepository mockRepo = Mockito.mock(ProductRegisterTypeRepository.class);
        ProductRegisterType productRegisterType1 = new ProductRegisterType(1, "03.012.002_47533_ComSoLd", "Хранение ДМ.", null, null);
        Mockito.when(mockRepo.findFirstByProductClassCode_ValueAndAccountType_Value(Mockito.any(), Mockito.any()))
                .thenReturn(productRegisterType1);

        Assertions.assertDoesNotThrow(
                () -> new CheckProductRegisterType(mockRepo).start(productModel1)
        );
    }
}
