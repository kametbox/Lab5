package study.stepup.lesson5.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import study.stepup.lesson5.model.Book;
import study.stepup.lesson5.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final BookService service;

    @GetMapping("/api/v1/books/{id}")
    public ResponseEntity<String> getBook(@PathVariable("id") Long id){
        Book book = service.findById(id);
        return book != null ? new ResponseEntity<>(book.toString(), HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/v1/books")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        service.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/books")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> bookList = service.findAll();
        return bookList != null && !bookList.isEmpty()
                ? new ResponseEntity<>(bookList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
