package study.stepup.lesson5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import study.stepup.lesson5.contoller.CreateController;
import study.stepup.lesson5.repository.AccountPoolRepository;
import study.stepup.lesson5.repository.AccountRepository;
import study.stepup.lesson5.repository.ProductRepository;
import study.stepup.lesson5.service.AddAgreementsProcess;
import study.stepup.lesson5.service.AddProductProcess;
import study.stepup.lesson5.service.CreateAccountService;
import study.stepup.lesson5.service.CreateProductService;
import study.stepup.lesson5.service.cheks.ChecksAccount;
import study.stepup.lesson5.service.cheks.ChecksProduct;
import study.stepup.lesson5.service.cheks.ChecksRequestModel;

import java.util.List;

@SpringBootTest
public class BeanTest {
    CreateController testCreateController;
    CreateProductService testProdService;
    CreateAccountService testAccService;
    List<ChecksAccount> testChecksAccounts;
    List<ChecksRequestModel> testChecksRequestModelList;
    AccountPoolRepository testAccountPoolRepository;
    AccountRepository testAccountRepository;
    List<ChecksProduct> testChecksProductList;
    AddProductProcess testAddProductProcess;
    AddAgreementsProcess testAddAgreementsProcess;
    ProductRepository testProductRepository;

    @Autowired
    public BeanTest(CreateController createController, CreateProductService testProdService, CreateAccountService testAccService, List<ChecksAccount> testChecksAccounts, List<ChecksRequestModel> testChecksRequestModelList, AccountPoolRepository testAccountPoolRepository, AccountRepository testAccountRepository, List<ChecksProduct> testChecksProductList, AddProductProcess testAddProductProcess, AddAgreementsProcess testAddAgreementsProcess, ProductRepository testProductRepository) {
        this.testCreateController = createController;
        this.testProdService = testProdService;
        this.testAccService = testAccService;
        this.testChecksAccounts = testChecksAccounts;
        this.testChecksRequestModelList = testChecksRequestModelList;
        this.testAccountPoolRepository = testAccountPoolRepository;
        this.testAccountRepository = testAccountRepository;
        this.testChecksProductList = testChecksProductList;
        this.testAddProductProcess = testAddProductProcess;
        this.testAddAgreementsProcess = testAddAgreementsProcess;
        this.testProductRepository = testProductRepository;
    }

    //ищем конкретные бины
    @Test
    public void contextLoads() {

        assertThat(testCreateController).isNotNull();
        assertThat(testProdService).isNotNull();
        assertThat(testAccService).isNotNull();
        assertThat(testChecksAccounts).isNotNull();
        assertThat(testChecksRequestModelList).isNotNull();
        assertThat(testAccountPoolRepository).isNotNull();
        assertThat(testAccountRepository).isNotNull();
        assertThat(testChecksProductList).isNotNull();
        assertThat(testAddProductProcess).isNotNull();
        assertThat(testAddAgreementsProcess).isNotNull();
        assertThat(testProductRepository).isNotNull();


    }
}