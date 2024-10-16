import by.sakhdanil.t1_tomcat.ManagerRep;
import by.sakhdanil.t1_tomcat.SuportPeopleServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SupportPeopleServletTest {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private SuportPeopleServlet servlet;
    private StringWriter stringWriter;
    private ManagerRep managerRep;

    @BeforeEach
    public void setUp() throws IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        managerRep = mock(ManagerRep.class);
        stringWriter = new StringWriter();
        servlet = new SuportPeopleServlet(managerRep);

        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

    }


    @Test
    public void test_get_servlet() throws ServletException, IOException {
        String testPhrase = "test";
        doReturn(testPhrase).when(this.managerRep).getPhrase();

        this.servlet.doGet(request, response);

        verify(managerRep, times(1)).getPhrase();
        assertEquals(testPhrase, stringWriter.toString());

    }


    @Test
    public void test_post_servlet() throws ServletException, IOException {
        String testPhrase = "test";
        String testPhrase2 = "Good test";

        doReturn(testPhrase2).when(this.managerRep).addPhrase(testPhrase);
        doReturn(testPhrase).when(this.request).getParameter("Phrase");


        this.servlet.doPost(request, response);

        verify(managerRep, times(1)).addPhrase(testPhrase);
        assertEquals(testPhrase2, stringWriter.toString());
    }


}
