package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component

public class BookService {
	
	
//	private static List <Book> list = new ArrayList<>();
	
	@Autowired
	private BookRepository bookRepository;
	
	
/*	static {
		
		list.add(new Book(1,"Java","Rahul Khemani"));
		list.add(new Book(2,"Scala","Anurag Botre"));
		list.add(new Book(3,"Php","C"));		
	}
*/
	//getallbooks

	public List<Book> getAllBooks(){
		
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		 return list ;
	}
	
	//getsinglebook
	
	public Book getBookById(int id) {
	
	Book book = null;
	try {
		
	
	//book =list.stream().filter(e->e.getId()==id).findFirst().get();
	book=this.bookRepository.findById(id);	 
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return book;
	}
	
	
	//adding the book
	
	
	
	public Book addBook(Book b) {
		
		Book result = bookRepository.save(b);
		return result;
	}
	
	//deletebook
	
	public void deleteBook(int bid) {
		/* list.stream().filter(book->{
			if (book.getId()!=bid) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList()); */
		
		bookRepository .deleteById(bid);
		
		
	}
	
	//update book
	
	public void updateBook(Book book, int bookId) {
		
		book.setId(bookId);
		bookRepository.save(book);		
/*	list = list.stream().map(b->{
			
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList()); */
		
	}
}
