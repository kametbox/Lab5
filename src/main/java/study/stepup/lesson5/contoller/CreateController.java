package study.stepup.lesson5.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import study.stepup.lesson5.model.request.AccountModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.model.response.ResponseAccountId;
import study.stepup.lesson5.model.response.ResponseProduct;
import study.stepup.lesson5.service.CreateAccountService;
import study.stepup.lesson5.service.CreateProductService;

@Controller
@RequiredArgsConstructor
public class CreateController {
    private final CreateProductService prodService;
    private final CreateAccountService accService;

    @PostMapping("/corporate-settlement-instance/create")
    @Transactional
    public ResponseEntity<?> createAccount(@RequestBody ProductModel productModel){
        ResponseProduct responseProduct = prodService.create(productModel);
        return new ResponseEntity<>(responseProduct, HttpStatus.OK);
    }

    @PostMapping("/corporate-settlement-account/create")
    @Transactional
    public ResponseEntity<?> createAccount(@RequestBody AccountModel accountModel){
        ResponseAccountId responseAccountId = accService.create(accountModel);
        return new ResponseEntity<>(responseAccountId, HttpStatus.OK);
    }
}
