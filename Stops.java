
public class Stops {
	int stopId;
	String stopCode;
	String stopName;
	String stopDesc;
	double stopLat;
	double stopLon;
	String zoneID;
	String stopURL;
	int location_type;
	String parent_station;
	
	Stops(){
		
	}
	
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	
	public int getStopId() {
		return this.stopId;
	}
	
    public void setStopCode(String stopCode) {
		this.stopCode = stopCode;
	}
    
    public String getStopCode() {
		return this.stopCode;
	}
	
    public void setStopName(String stopName) {
		this.stopName = stopName;
	}
    
    public String getStopName() {
		return this.stopName;
	}
    
    public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
	}
    
    public String getStopDesc() {
		return this.stopDesc;
	}

    public void setStopLat(double stopLat) {
		this.stopLat = stopLat;
	}
    
    public double getStopLat() {
		return this.stopLat;
	}
    
    public void setStopLon(double stopLon) {
		this.stopLon = stopLon;
	}
    
    public double getStopLon() {
		return this.stopLon;
	}
    
    public void setZoneId(String zoneID) {
		this.zoneID = zoneID;
	}
    
    public String getZoneId() {
		return this.zoneID;
	}
   
    public void setStopURL(String stopURL) {
		this.stopURL = stopURL;
	}
    
    public String getStopURL() {
		return this.stopURL;
	}
    
    public void setLocationType(int location_type) {
		this.location_type = location_type;
	}
    
    public int getLocationType() {
		return this.location_type;
	}
    
    public void setParentStation(String parent_station) {
		this.parent_station = parent_station;
	}
    
    public String getParentStation() {
		return this.parent_station;
	}
}
