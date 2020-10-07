

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/fileServ")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ServletConfig sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sc = config;
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			//String name = request.getParameter("name");		
			//String file = request.getParameter("file");		
			//System.out.println("request name : "+name); //null
			//System.out.println("request file : "+file); //null
		
			
			int maxSize = 1024 * 1024 * 5;
			String uploadDir = sc.getServletContext().getRealPath("file");
			System.out.println("uploadDir : "+uploadDir);
			//uploadDir : C:\EL_JSTL_Servlet_kkh\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\11_FileUpload\file
			MultipartRequest mr = new MultipartRequest(request,
									uploadDir,
									maxSize,
									"UTF-8",
									new DefaultFileRenamePolicy());
			String name = mr.getParameter("name");
			String file = mr.getFilesystemName("file");
			System.out.println("name : "+name); 
			System.out.println("file : "+file); 
			
			String position = request.getContextPath() + "\\file";
			System.out.println("position : "+position);
			//position : /11_FileUpload\file
			
			PrintWriter pw = response.getWriter();
			pw.println("이름 : " +name);
			pw.println("<img src='"+position+"\\"+file+"'"+" width='400' height='400'/>");
			
			pw.close();
		
			//게시판 만들기 꼭하기!!!
		
		
	}

}
