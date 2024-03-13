package study.stepup.lesson5.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import study.stepup.lesson5.model.request.AccountModel;
import study.stepup.lesson5.service.CreateAccountService;

@Controller
@RequiredArgsConstructor
public class CreateAccountController {
    private final CreateAccountService service;
//    private final CheckRequired required;

    @PostMapping("/corporate-settlement-account/create")
    @Transactional
    public ResponseEntity<?> createAccount(@RequestBody AccountModel accountModel){
//        required.accept(accountModel);
        //service.save(accountModel);
        //service.create(accountModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PostMapping("/corporate-settlement-instance/create")
//    public ResponseEntity<?> createInstance(@RequestBody ProductModel productModel){
//        required.accept(productModel);
//        //service.save(productModel);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}
