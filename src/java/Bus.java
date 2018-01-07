

public class Bus 
{

	private int busId;
	private String busName;
	private String lunchTime;
	private String destination;
        
	public int getBusid()
        {
		return busId;
	}
	public void setBusid(int busId) 
        {
		this.busId = busId;
	}
	public String getBusName() 
        {
		return busName;
	}
	public void setBusName(String busName) 
        {
		this.busName = busName;
	}

	public String getLunchTime() 
        {
		return lunchTime;
	}
	public void setLunchTime(String lunchTime)
        {
		this.lunchTime = lunchTime;
	}
	public String getDestination() 
        {
		return destination;
	}
	public void setDestination(String destination) 
        {
		this.destination = destination;
	}
	@Override
	public String toString() 
        {
		return "User [userId=" + busId + ", busName=" + busName
				+ ", lunchTime=" + lunchTime + ", destination="
				+ destination + "]";
	}
	
	
}
