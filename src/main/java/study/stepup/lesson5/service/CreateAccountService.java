package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.stepup.lesson5.service.cheks.CheckRequired;

@Service
@RequiredArgsConstructor
public class CreateAccountService {
    private final CheckRequired required;

    //public void create(AccountModel accountModel){
    //    required.accept(accountModel);
    //}

//    public Book findById(Long id){
//        Optional<Book> book = bookRepository.findById(id);
//        //return book.map(Book::getTitle).orElseThrow(()->new RuntimeException("Не нашли по id=" + id));
//        return book.orElse(null);
//    }
//    public List<Book> findAll(){
//        return bookRepository.findAll();
//    }
//    public void save(Book book){
//        bookRepository.save(book);
//    }

}
