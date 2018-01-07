

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BusDao 
{

	private Connection connection;

	public BusDao() 
        {
		connection = DbUtil.getConnection();
	}

        public void addBus(Bus bus) 
        {
		try 
                {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into buses(busName,lunchTime,destination) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, bus.getBusName());
			preparedStatement.setString(2, bus.getLunchTime());
			preparedStatement.setString(3, bus.getDestination());
			preparedStatement.executeUpdate();

		} catch (SQLException e) 
                {
			e.printStackTrace();
		}
	}
        
	public void deleteBus(int busId) 
        {
		try 
                {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from buses where busId=?");
			// Parameters start with 1
			preparedStatement.setInt(1, busId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) 
                {
			e.printStackTrace();
		}
	}
	
        public void updateBus(Bus bus) 
        {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update buses set busName=?, lunchTime=?, destination=?" +
							"where busId=?");
			// Parameters start with 1
			preparedStatement.setString(1, bus.getBusName());
			preparedStatement.setString(2, bus.getLunchTime());
			preparedStatement.setString(3, bus.getDestination());
			preparedStatement.setInt(4, bus.getBusid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) 
                {
			e.printStackTrace();
		}
	}

	public List<Bus> getAllBuses() 
        {
		List<Bus> buses = new ArrayList<Bus>();
		try 
                {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from buses");
			while (rs.next()) 
                        {
				Bus bus= new Bus();
				bus.setBusid(rs.getInt("busId"));
				bus.setBusName(rs.getString("busName"));
				bus.setLunchTime(rs.getString("lunchTime"));
				bus.setDestination(rs.getString("destination"));
				buses.add(bus);
			}
		} catch (SQLException e) 
                {
			e.printStackTrace();
		}

		return buses;
	}
	
	public Bus getBusById(int busId)
        {
		Bus bus = new Bus();
		try 
                {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from buses where busId=?");
			preparedStatement.setInt(1, busId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) 
                        {
				bus.setBusid(rs.getInt("busId"));
				bus.setBusName(rs.getString("busName"));
				bus.setLunchTime(rs.getString("lunchTime"));
				bus.setDestination(rs.getString("destination"));
			}
		} catch (SQLException e) 
                {
			e.printStackTrace();
		}

		return bus;
	}
}
