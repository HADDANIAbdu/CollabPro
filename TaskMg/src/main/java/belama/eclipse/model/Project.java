package belama.eclipse.model;

import java.util.Date;
public class Project {
	private int pr_id;
	private int chef_id;
	private String title;
	private String description;
	private Date start_date;
	private Date end_date;
	private int duration;
	public Project(int chef_id, String title, String description, Date start_date, Date end_date, int duration) {
		super();
		this.chef_id = chef_id;
		this.title = title;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.duration = duration;
	}
	public int getPr_id() {
		return pr_id;
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
	public int getChef_id() {
		return chef_id;
	}
	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
