


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class BusController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/bus.jsp";
    private static String LIST_BUS = "/listBus.jsp";
    private BusDao busdao;

    public BusController()
    {
        super();
        busdao = new BusDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete"))
        {
            int busId = Integer.parseInt(request.getParameter("busId"));
            busdao.deleteBus(busId);
            forward = LIST_BUS;
            request.setAttribute("buses", busdao.getAllBuses());    
        } else if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            int busId = Integer.parseInt(request.getParameter("busId"));
            Bus bus = busdao.getBusById(busId);
            request.setAttribute("bus", bus);
        } else if (action.equalsIgnoreCase("listBuses"))
        {
            forward = LIST_BUS;
            request.setAttribute("buses", busdao.getAllBuses());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bus bus = new Bus();
        bus.setBusName(request.getParameter("busName"));
        bus.setLunchTime(request.getParameter("lunchTime"));
        bus.setDestination(request.getParameter("destination"));
        String busid = request.getParameter("busId");
        if(busid == null || busid.isEmpty())
        {
            busdao.addBus(bus);
        }
        else
        {
            bus.setBusid(Integer.parseInt(busid));
            busdao.updateBus(bus);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_BUS);
        request.setAttribute("buses", busdao.getAllBuses());
        view.forward(request, response);
    }
}