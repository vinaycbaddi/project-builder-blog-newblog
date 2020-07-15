package controller;

import java.io.IOException;

import java.time.LocalDate;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;

import model.User;


@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] blogData = blogDetails.split(",");
		String blogTitle = blogData[0];
		String blogDescription = blogData[1];
		LocalDate blogDate = LocalDate.now();
		
		Blog blog=new Blog(blogTitle, blogDescription, blogDate);
		blog.setTitle(blogTitle);
		blog.setDescription(blogDescription);
		blog.setPostedOn(blogDate);
		
		System.out.println("Blog Title: "+blog.getTitle());
		System.out.println("Blog Description: "+blog.getDescription());
		System.out.println("Posted on: "+blog.getPostedOn());

		
		if(blog!=null) {
			request.setAttribute("blog", blog);
			//request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
	
	}

}
