package testing;

//Uncomment the below code to test your application

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Blog;

public class TestBlog {
	LocalDate ld = LocalDate.of(2005, 4, 9);
	Blog blog = new Blog("Java","ProgrammingLanguage",ld);
	
	 @Test
	 public void testSetterGetter() {
		 blog.setDescription("ProgrammingLanguage");
		 blog.setTitle("Java");
		 blog.setPostedOn(ld);
		 assertEquals("ProgrammingLanguage",blog.getDescription());
		 assertEquals("Java",blog.getTitle());
		 assertEquals(ld,blog.getPostedOn());
		 try {
			 blog.setDescription(null);
			 blog.setTitle(null);
			 blog.setPostedOn(null);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
}

