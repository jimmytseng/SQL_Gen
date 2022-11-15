package ;
import javax.persistence.Entity;
import import javax.persistence.Id;


@Entity
public class VisitsEntity.java {
	
	@Id
	@Column(name="visit_id")
	private Integer visit_id;

	@Column(name="first_name")
	private String first_name;

	@Column(name="last_name")
	private String last_name;

	@Column(name="visited_at")
	private String visited_at;

	@Column(name="phone")
	private String phone;

	@Column(name="store_id")
	private Integer store_id;

	public Integer getVisit_id(){
		return visit_id;
	}
	public void setVisit_id(Integer visit_id){
		this.visit_id=visit_id;
	}
	public String getFirst_name(){
		return first_name;
	}
	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}
	public String getLast_name(){
		return last_name;
	}
	public void setLast_name(String last_name){
		this.last_name=last_name;
	}
	public String getVisited_at(){
		return visited_at;
	}
	public void setVisited_at(String visited_at){
		this.visited_at=visited_at;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public Integer getStore_id(){
		return store_id;
	}
	public void setStore_id(Integer store_id){
		this.store_id=store_id;
	}
}