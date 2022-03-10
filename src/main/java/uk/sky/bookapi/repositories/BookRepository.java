package uk.sky.bookapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.sky.bookapi.models.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findByTitle(String title);
}
