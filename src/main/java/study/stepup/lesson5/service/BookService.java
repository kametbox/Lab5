package study.stepup.lesson5.service;

import study.stepup.lesson5.model.data.Book;
import study.stepup.lesson5.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book findById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        //return book.map(Book::getTitle).orElseThrow(()->new RuntimeException("Не нашли по id=" + id));
        return book.orElse(null);
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }
}
