package study.stepup.lesson5.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.model.response.ResponseProduct;
import study.stepup.lesson5.service.CreateProductService;

@Controller
@RequiredArgsConstructor
public class CreateProductController {
    private final CreateProductService service;

    @PostMapping("/corporate-settlement-instance/create")
    @Transactional
    public ResponseEntity<?> createAccount(@RequestBody ProductModel productModel){
        ResponseProduct responseProduct = service.create(productModel);
        return new ResponseEntity<>(responseProduct, HttpStatus.OK);
    }
}
