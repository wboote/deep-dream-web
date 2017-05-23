package deepdream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

	    System.out.println("WAZA_WAZ_ERE");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	    final String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    final Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    final String fileName = filePart.getSubmittedFileName();
	    final InputStream fileContent = filePart.getInputStream();
	    final File file = new File( "c:\\deepdream\\capture.jpg" );
	    if (file.exists())
	    {
	        file.delete();
	    }
	    try ( FileOutputStream fos = new FileOutputStream( file ) )
	    {
	        IOUtils.copy( fileContent, fos );
	    }
	}

}
